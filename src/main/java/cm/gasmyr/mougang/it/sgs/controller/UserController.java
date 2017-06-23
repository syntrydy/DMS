package cm.gasmyr.mougang.it.sgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cm.gasmyr.mougang.it.sgs.core.User;
import cm.gasmyr.mougang.it.sgs.impl.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/users")
	public String goToUserListPage(Model model) {
		model.addAttribute("users", userService.getAll());
		return "UserListPage";
	}

	@RequestMapping(value = "/edit_user/{id}", method = RequestMethod.GET)
	public String goToUserlEditPage(Model model, @PathVariable Long id) {
		User user = userService.getById(id);
		model.addAttribute("user", user);
		return "UserEditPage";
	}

	@RequestMapping(value = "/edit_user/{id}", method = { RequestMethod.POST })
	public String editUser(@Valid User user, BindingResult bindingResult, @PathVariable Long id) {
		User oldUser = userService.getById(id);
		oldUser.updateInternal(user);
		userService.add(oldUser);
		return "redirect:/users";
	}

	@RequestMapping(value = "/delete_user/{id}")
	public String deleteUser(@Valid User level, BindingResult bindingResult, @PathVariable Long id) {
		User levelToBeDeleted = userService.getById(id);
		userService.delete(levelToBeDeleted);
		return "redirect:/users";
	}

	@GetMapping(value = "/user")
	public String gotoAddPage(Model model) {
		model.addAttribute("user", new User());
		return "UserAddPage";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult bindingResult, Model model) {
		userService.add(user);
		return "redirect:/users";
	}

}
