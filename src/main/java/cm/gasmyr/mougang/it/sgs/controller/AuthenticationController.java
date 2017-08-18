package cm.gasmyr.mougang.it.sgs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cm.gasmyr.mougang.it.sgs.common.UiUser;
import cm.gasmyr.mougang.it.sgs.core.User;
import cm.gasmyr.mougang.it.sgs.impl.service.UserService;

@Controller
public class AuthenticationController {

	private UserService userService;

	@Autowired
	public AuthenticationController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToSignInPage(Model model) {
		model.addAttribute("user", new UiUser());
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String signIn(@Valid UiUser uiUser, BindingResult bindingResult) {
		List<User> users = userService.searchByUserName(uiUser.getUsername());
		if (users.size() == 1 && users.get(0).getPasswd().equalsIgnoreCase(uiUser.getPassword())) {
			return "redirect:/home";
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

}
