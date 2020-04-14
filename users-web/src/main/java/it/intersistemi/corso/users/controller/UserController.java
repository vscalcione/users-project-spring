package it.intersistemi.corso.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.intersistemi.corso.users.model.AuthorityDto;
import it.intersistemi.corso.users.model.UserDto;
import it.intersistemi.corso.users.service.AuthorityService;
import it.intersistemi.corso.users.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController extends CrudController<UserDto, Integer, UserService> {

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	public UserController(UserService userService) {
		super(userService);
	}

	@Override
	protected void onShowEditForm(Integer id, UserDto dto, Model model) {
		List<AuthorityDto> userAuthorities = super.service.listAuthorities(dto.getUserName());
		model.addAttribute("userAuthorities", userAuthorities);

		Iterable<AuthorityDto> authorities = authorityService.findAll();
		model.addAttribute("authorities", authorities);
	}

	@RequestMapping(value="/{id}/addAuthority", method=RequestMethod.POST)
	public String saveEntity(@PathVariable("id") Integer id,
			@RequestParam(value="userName", required=true) String userName,
			@RequestParam(value="authority", required=true) String authority,
			Model model) {
		this.service.addAuthority(userName, authority);
		return "redirect:/users/"+id+"/edit";
	}

	@Override
	protected String getEntityListModelName() {
		return "userList";
	}

	@Override
	protected String getEntityModelName() {
		return "user";
	}

	@Override
	protected String getListView() {
		return "users/userList";
	}

	@Override
	protected String getDetailsView() {
		return "users/userDetails";
	}

	@Override
	protected String getFormView() {
		return "users/userForm";
	}

	@Override
	protected String getListUrl() {
		return "/users";
	}

}
