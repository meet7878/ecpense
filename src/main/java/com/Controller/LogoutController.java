package com.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@GetMapping("/logout")
	public String log(HttpSession session) {
		session.invalidate();
		
		return "Login";
	}
}
