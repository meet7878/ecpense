package com.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Bean.Loginbean;
import com.Bean.UserBean;
import com.Dao.UserDao;

@Controller
public class SessionController {
	@Autowired
	UserDao userDao;

	@GetMapping("/signup")
	public String signup(UserBean user, Model model) {
		model.addAttribute("user", user);
		return "Signup";
	}

	@PostMapping("/saveuser")
	public String savuser(@ModelAttribute("user") @Valid UserBean user, BindingResult result, Model model) {
		System.out.println(result);
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "Signup";
		}

		else {
			System.out.println("fname" + user.getFirstName());
			System.out.println("result" + result);
			user.setUsertype("customer");
			userDao.adduser(user);
			// model.addAttribute(user);
			model.addAttribute("msg", "signup done");
			return "Login";

		}
	}

	@GetMapping("/login")
	public String login(Loginbean login,Model model) {
		model.addAttribute("login",login);
		return "Login";
	}

	@PostMapping("/login")
	public String authenticate(@ModelAttribute("login") @Valid Loginbean login,BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("login", login);
			return "Login";
		}
		
		UserBean sign = userDao.authenticate(login);

		if (sign == null) {
			model.addAttribute("msg", "Invalid creditial");
			return "Login";
		} else if (sign.getUsertype().contentEquals("customer")) {
			session.setAttribute("users", sign);
			System.out.println(sign.getUserid());
			return "Home";
		} else if (sign.getUsertype().contentEquals("admin")) {
			session.setAttribute("users", sign);
			return "Dashboard";

		} else {
			model.addAttribute("msg", "please contact admin");
			return "Login";

		}
	}
}
