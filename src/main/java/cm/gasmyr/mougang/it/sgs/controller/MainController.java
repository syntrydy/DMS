package cm.gasmyr.mougang.it.sgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cm.gasmyr.mougang.it.sgs.core.University;
import cm.gasmyr.mougang.it.sgs.impl.service.UniversityService;

@Controller
public class MainController {

	private UniversityService universityService;

	@Autowired
	public MainController(UniversityService universityService) {
		this.universityService = universityService;
	}

	@RequestMapping("/master")
	public String goToMasterPage() {
		return "master";
	}

	@RequestMapping({ "/home" })
	public String goToHomePage() {
		return "home";
	}

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String goToSettingsPage(Model model) {
		University current = universityService.getAll().get(0);
		model.addAttribute("university", current);
		return "SettingsPage";
	}

	@RequestMapping(value = "/edit_university/{id}", method = RequestMethod.GET)
	public String goToUniversityEditPage(Model model, @PathVariable Long id) {
		University university = universityService.getById(id);
		model.addAttribute("university", university);
		return "EditUniversityPage";
	}

	@RequestMapping(value = "/edit_university/{id}", method = { RequestMethod.POST })
	public String goToUniversityEditPage(@Valid University university, BindingResult bindingResult,
			@PathVariable Long id) {
		University oldUniversity = universityService.getById(id);
		oldUniversity.updateInternal(university);
		universityService.add(oldUniversity);
		return "redirect:/settings";
	}

}
