package it.intersistemi.corso.users.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.intersistemi.corso.users.model.UserDto;
import it.intersistemi.corso.users.service.UserService;

@Controller
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping
	@ResponseBody
	public Iterable<UserDto> findAll() {
		return userService.findAll();
	}

	@GetMapping("/count")
	@ResponseBody
	public long countAll() {
		return userService.countAll();
	}


}
