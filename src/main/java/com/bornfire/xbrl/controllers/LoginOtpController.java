package com.bornfire.xbrl.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginOtpController {

	private static final int OTP_MAX_ATTEMPTS = 3;

	@GetMapping("/login-otp")
	public String loginOtpPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("USERID") == null) {
			return "redirect:/login";
		}
		if (!Boolean.TRUE.equals(session.getAttribute("LOGIN_OTP_PENDING"))) {
			return "redirect:/MenuLanding";
		}
		return "XBRLLoginOtp";
	}

	@PostMapping("/login-otp")
	public String verifyLoginOtp(HttpServletRequest request, @RequestParam("otp") String otp, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("USERID") == null) {
			return "redirect:/login";
		}
		if (!Boolean.TRUE.equals(session.getAttribute("LOGIN_OTP_PENDING"))) {
			return "redirect:/MenuLanding";
		}

		String sessionOtp = (String) session.getAttribute("LOGIN_OTP");
		Integer attempts = (Integer) session.getAttribute("LOGIN_OTP_ATTEMPTS");
		if (attempts == null) {
			attempts = 0;
		}

		if (otp != null && otp.trim().equals(sessionOtp)) {
			session.setAttribute("LOGIN_OTP_PENDING", false);
			session.setAttribute("LOGIN_OTP_VERIFIED", true);
			session.removeAttribute("LOGIN_OTP");
			session.removeAttribute("LOGIN_OTP_ATTEMPTS");
			return "redirect:/MenuLanding";
		}

		attempts = attempts + 1;
		session.setAttribute("LOGIN_OTP_ATTEMPTS", attempts);
		if (attempts >= OTP_MAX_ATTEMPTS) {
			session.invalidate();
			return "redirect:/login?error=Invalid OTP limit exceeded. Please login again.";
		}

		model.addAttribute("error", "Invalid OTP. Remaining attempts: " + (OTP_MAX_ATTEMPTS - attempts));
		return "XBRLLoginOtp";
	}
}

