package it.intersistemi.corso.users.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("")
	public String homePage(Model model) {
		String userName = SecurityContextHolder
				.getContext().getAuthentication().getName();
		model.addAttribute("userName", userName);
		return "home";
	}
}
