package com.lpu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("/hi")
	public String takeReqHi() {
		return "page.jsp";
	}
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "logout.jsp";
	}
	@RequestMapping("/register")
	public String register() {
		return "register.jsp";
	}
}
