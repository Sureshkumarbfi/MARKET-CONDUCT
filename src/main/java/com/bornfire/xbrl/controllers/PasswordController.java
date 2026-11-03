package com.bornfire.xbrl.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bornfire.xbrl.config.PasswordEncryption;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;

@Controller
public class PasswordController {

	@Autowired
	private UserProfileRep userProfileRep;

	@GetMapping("/change-password")
	public String changePasswordPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("USERID") == null) {
			return "redirect:/login";
		}
		populateCommonFlags(session, model);
		return "XBRLChangePassword";
	}

	@PostMapping("/change-password")
	public String changePassword(HttpServletRequest request, @RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String confirmPassword, Model model) {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("USERID") == null) {
			return "redirect:/login";
		}

		String userId = String.valueOf(session.getAttribute("USERID"));
		Optional<UserProfile> userOpt = userProfileRep.findById(userId);
		if (!userOpt.isPresent()) {
			session.invalidate();
			return "redirect:/login?error=Invalid user session";
		}

		if (newPassword == null || confirmPassword == null || newPassword.trim().isEmpty()
				|| confirmPassword.trim().isEmpty()) {
			model.addAttribute("error", "New password and confirm password are required.");
			populateCommonFlags(session, model);
			return "XBRLChangePassword";
		}

		if (!newPassword.equals(confirmPassword)) {
			model.addAttribute("error", "New password and confirm password do not match.");
			populateCommonFlags(session, model);
			return "XBRLChangePassword";
		}

		// Keep same strength rule as user creation flow.
		if (!isStrongPassword(newPassword)) {
			model.addAttribute("error",
					"Password must be at least 14 characters and include upper, lower, number, and special character.");
			populateCommonFlags(session, model);
			return "XBRLChangePassword";
		}

		try {
			UserProfile user = userOpt.get();
			if (PasswordEncryption.validatePassword(newPassword, user.getPassword())) {
				model.addAttribute("error", "New password must be different from previous password.");
				populateCommonFlags(session, model);
				return "XBRLChangePassword";
			}
			user.setPassword(PasswordEncryption.getEncryptedPassword(newPassword));
			user.setLog_in_count("1");
			user.setLogin_flg("Y");
			int expiryDays = 90;
			if (user.getPass_exp_days() != null && !user.getPass_exp_days().trim().isEmpty()) {
				expiryDays = Integer.parseInt(user.getPass_exp_days().trim());
			}
			user.setPass_exp_date(java.sql.Date.valueOf(LocalDate.now().plusDays(expiryDays)));
			userProfileRep.save(user);
			session.setAttribute("FORCE_PASSWORD_CHANGE", false);
			session.setAttribute("PASSWORD_EXPIRED", false);
			session.setAttribute("LOGIN_OTP_PENDING", false);
			session.setAttribute("LOGIN_OTP_VERIFIED", true);
			session.removeAttribute("LOGIN_OTP");
			session.removeAttribute("LOGIN_OTP_ATTEMPTS");
			populateCommonFlags(session, model);
			model.addAttribute("success", "Password changed successfully.");
			return "XBRLChangePassword";
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			model.addAttribute("error", "Unable to update password. Please contact administrator.");
			populateCommonFlags(session, model);
			return "XBRLChangePassword";
		}
	}

	private boolean isStrongPassword(String password) {
		return password.length() >= 14 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")
				&& password.matches(".*\\d.*") && password.matches(".*[@$!%*?&].*");
	}

	private void populateCommonFlags(HttpSession session, Model model) {
		model.addAttribute("forceChange", Boolean.TRUE.equals(session.getAttribute("FORCE_PASSWORD_CHANGE")));
		model.addAttribute("passwordExpired", Boolean.TRUE.equals(session.getAttribute("PASSWORD_EXPIRED")));
	}
}

