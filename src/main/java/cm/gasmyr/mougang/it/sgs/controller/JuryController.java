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

import cm.gasmyr.mougang.it.sgs.core.Jury;
import cm.gasmyr.mougang.it.sgs.impl.service.JuryService;
import cm.gasmyr.mougang.it.sgs.impl.service.TeacherService;

@Controller
public class JuryController {

	private JuryService juryService;
	private TeacherService teacherService;

	@Autowired
	public JuryController(JuryService juryService, TeacherService teacherService) {
		this.juryService = juryService;
		this.teacherService = teacherService;
	}

	@RequestMapping("/juries")
	public String goToJuryListPage(Model model) {
		model.addAttribute("juries", juryService.getAll());
		return "JuryListPage";
	}

	@RequestMapping(value = "/edit_jury/{id}", method = RequestMethod.GET)
	public String goToJuryEditPage(Model model, @PathVariable Long id) {
		Jury jury = juryService.getById(id);
		model.addAttribute("jury", jury);
		model.addAttribute("teachers",teacherService.getAll());
		return "JuryEditPage";
	}

	@RequestMapping(value = "/edit_jury/{id}", method = { RequestMethod.POST })
	public String editJury(@Valid Jury jury, BindingResult bindingResult, @PathVariable Long id) {
		Jury oldjury = juryService.getById(id);
		oldjury.updateInternal(jury);
		juryService.add(oldjury);
		return "redirect:/juries";
	}

	@RequestMapping(value = "/delete_jury/{id}")
	public String deleteJury(@Valid Jury jury, BindingResult bindingResult, @PathVariable Long id) {
		Jury juryToBeDeleted = juryService.getById(id);
		juryService.delete(juryToBeDeleted);
		return "redirect:/juries";
	}

	@GetMapping(value = "/jury")
	public String gotoAddPage(Model model) {
		model.addAttribute("jury", new Jury());
		model.addAttribute("teachers",teacherService.getAll());
		return "JuryAddPage";
	}

	@RequestMapping(value = "/jury", method = RequestMethod.POST)
	public String saveJury(@Valid Jury jury, BindingResult bindingResult, Model model) {
		juryService.add(jury);
		return "redirect:/juries";
	}

}
