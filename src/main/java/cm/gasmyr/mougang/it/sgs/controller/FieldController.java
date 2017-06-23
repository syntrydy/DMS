package cm.gasmyr.mougang.it.sgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cm.gasmyr.mougang.it.sgs.core.Field;
import cm.gasmyr.mougang.it.sgs.core.User;
import cm.gasmyr.mougang.it.sgs.impl.service.FieldService;

public class FieldController {
	private FieldService fieldService;

	@Autowired
	public FieldController(FieldService fieldService) {
		this.fieldService = fieldService;
	}

	@RequestMapping("/fields")
	public String goToFieldListPage(Model model) {
		model.addAttribute("fields", fieldService.getAll());
		return "FieldListPage";
	}

	@RequestMapping(value = "/edit_field/{id}", method = RequestMethod.GET)
	public String goToFieldEditPage(Model model, @PathVariable Long id) {
		Field field = fieldService.getById(id);
		model.addAttribute("field", field);
		return "FieldEditPage";
	}

	@RequestMapping(value = "/edit_field/{id}", method = { RequestMethod.POST })
	public String editField(@Valid Field field, BindingResult bindingResult, @PathVariable Long id) {
		Field oldField = fieldService.getById(id);
		oldField.updateInternal(field);
		fieldService.add(oldField);
		return "redirect:/fields";
	}

	@RequestMapping(value = "/delete_user/{id}")
	public String deleteField(@Valid Field field, BindingResult bindingResult, @PathVariable Long id) {
		Field fieldToBeDeleted = fieldService.getById(id);
		fieldService.delete(fieldToBeDeleted);
		return "redirect:/fields";
	}

	@GetMapping(value = "/user")
	public String gotoAddPage(Model model) {
		model.addAttribute("user", new User());
		return "FieldAddPage";
	}

	@RequestMapping(value = "/field", method = RequestMethod.POST)
	public String saveField(@Valid Field field, BindingResult bindingResult, Model model) {
		fieldService.add(field);
		return "redirect:/fields";
	}

}
