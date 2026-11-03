package com.bornfire.xbrl.config;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.Transactional;

import com.bornfire.xbrl.entities.AccessandRolesRepository;
import com.bornfire.xbrl.entities.AuditServicesRep;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.services.AuditService;
import com.bornfire.xbrl.services.LoginServices;

@Configuration
@EnableWebSecurity
public class XBRLWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	UserProfileRep userProfileRep;

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	LoginServices loginServices;


	@Autowired 
	AuditService auditService;
	
	
	@Autowired
	AccessandRolesRepository accessRepository;
	
	/** Idle session timeout: 2 hours */
	private final Integer SESSION_TIMEOUT_IN_SECONDS = 2 * 60 * 60;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/webjars/**", "/images/**", "/css/**", "/js/**", "/login*", "/login-otp",
						"/freezeColumn/**", "favicon.ico")
				.permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.failureHandler(xbrlAuthFailHandle()).successHandler(xbrlAuthSuccessHandle())
				.usernameParameter("userid").and().logout().permitAll().and()
				.logout().logoutSuccessHandler(xbrlLogoutSuccessHandler()).permitAll()
				.and().sessionManagement().maximumSessions(1)
				.maxSessionsPreventsLogin(false);
				

		http.csrf().disable();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean

	public AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider ap = new DaoAuthenticationProvider() {

			@Override
			@Transactional
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				String userid = authentication.getName();
				String password = authentication.getCredentials().toString();

				Optional<UserProfile> up = userProfileRep.findById(userid);

				try {

					if (up.isPresent()) {
						UserProfile usr = up.get();

						if (!usr.isAccountNonExpired()) {

							throw new AccountExpiredException("Account Expired");

						} else if (!usr.isAccountNonLocked()) {

							throw new LockedException("Account Locked");

						} else if (!usr.isEnabled()) {

							throw new DisabledException("Account Disabled");

						} else if (!usr.isLoginAllowed()) {

							throw new LockedException("Login Not Allowed");

						} else if (!PasswordEncryption.validatePassword(password, usr.getPassword())) {

							logger.info("Passing Userid :" + userid);

							Session hs = sessionFactory.getCurrentSession();
							Transaction tr = hs.getTransaction();
							hs.createQuery(
									"update UserProfile a set a.no_of_attmp=nvl(a.no_of_attmp,0)+1, a.user_locked_flg=decode(nvl(a.no_of_attmp,0)+1,'3','Y','N'), a.login_status=decode(nvl(a.no_of_attmp,0)+1,'3','Inactive','Active') where userid=?1")
									.setParameter(1, userid).executeUpdate();
							tr.commit();
							hs.close();
							
							throw new BadCredentialsException("Authentication failed");

						} else {
							
							return new UsernamePasswordAuthenticationToken(userid, password, Collections.emptyList());

						}

					} else {

						throw new UsernameNotFoundException("Invalid User Name");
					}

				} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
					e.printStackTrace();
					authentication.setAuthenticated(false);
				}
				return authentication;

			}

			@Override
			public boolean supports(Class<?> aClass) {
				return aClass.equals(UsernamePasswordAuthenticationToken.class);
			}

		};

		ap.setHideUserNotFoundExceptions(false);
		ap.setUserDetailsService(userDetailsService());

		return ap;
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {

		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

				Optional<UserProfile> up = userProfileRep.findByusername(username);

				if (up.isPresent()) {
					return up.get();
				} else {
					return new UserProfile();
				}

			}

		};
	}

	@Bean
	public AuthenticationFailureHandler xbrlAuthFailHandle() {
		return new AuthenticationFailureHandler() {

			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {

				response.setStatus(HttpStatus.UNAUTHORIZED.value());
	//			logger.info(exception.getMessage());
				response.sendRedirect("login?error=" + exception.getMessage());

			}

		};

	}

	@Bean
	public AuthenticationSuccessHandler xbrlAuthSuccessHandle() {
		return new AuthenticationSuccessHandler() {

			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				
				Optional<UserProfile> up = userProfileRep.findById(authentication.getName());
				UserProfile user = up.get();
				boolean firstLogin = "0".equals(user.getLog_in_count());
				boolean passwordExpired = !user.isCredentialsNonExpired();
				user.setNo_of_attmp(0);
				user.setUser_locked_flg("N");
				userProfileRep.save(user);
				
				loginServices.SessionLogging("LOGIN","M1",request.getSession().getId(),user.getUserid(),request.getRemoteAddr(),
						"ACTIVE");
				String menus = accessRepository.getMenulist(user.getRole_id());
				
//				System.out.println(menus + "MENUS");
//				System.out.println(user.getRole_id() + "ROLEiD");
				
				
			
				request.getSession().setMaxInactiveInterval(SESSION_TIMEOUT_IN_SECONDS);
				request.getSession().setAttribute("USERID", user.getUserid());
				request.getSession().setAttribute("USERNAME", user.getUsername());
				request.getSession().setAttribute("ROLEID", user.getRole_id());
				request.getSession().setAttribute("DOMAINID", user.getDomain_id());
				request.getSession().setAttribute("PERMISSIONS", user.getPermissions());
				request.getSession().setAttribute("WORKCLASS", user.getWork_class());
				request.getSession().setAttribute("MOBILENUMBER", user.getMob_number());
				request.getSession().setAttribute("ROLEDESC", user.getRole_desc());
				request.getSession().setAttribute("ACCESSCODE", user.getAcct_access_code());
				request.getSession().setAttribute("BRANCHCODE", user.getBranch_code());
				request.getSession().setAttribute("BRANCHNAME", user.getBranch_name());
				request.getSession().setAttribute("MENULIST", menus); 
				request.getSession().setAttribute("DEPARTMENT",  user.getDepartment());
				request.getSession().setAttribute("FORCE_PASSWORD_CHANGE", firstLogin);
				request.getSession().setAttribute("PASSWORD_EXPIRED", passwordExpired);
				request.getSession().setAttribute("DESIGNATION",  user.getDesignation());

				auditService.createLoginAudit(user.getUserid() , "Login",null , null, "XBRL_USER_PROFILE_TABLE",user);				
				if (firstLogin || passwordExpired) {
					response.sendRedirect("change-password");
				} else {
					String loginOtp = String.format("%06d", new java.util.Random().nextInt(1000000));
					request.getSession().setAttribute("LOGIN_OTP", loginOtp);
					request.getSession().setAttribute("LOGIN_OTP_ATTEMPTS", 0);
					request.getSession().setAttribute("LOGIN_OTP_PENDING", true);
					request.getSession().setAttribute("LOGIN_OTP_VERIFIED", false);
					loginServices.sendclientotp(loginOtp, user.getRole_id(), user);
					System.out.println(loginOtp);
					response.sendRedirect("login-otp");
				}
				
			}

		};

	}
	
	@Bean
	public LogoutSuccessHandler xbrlLogoutSuccessHandler() {
		
		return new LogoutSuccessHandler() {

			@Override
			public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {

				Optional<UserProfile> up = userProfileRep.findById(authentication.getName());
				UserProfile user = up.get();
				auditService.createLoginAudit(user.getUserid(), "Logout", null, null, "XBRL_USER_PROFILE_TABLE",user);

				response.sendRedirect("login?logout");

			}
		
		
	};
}
}