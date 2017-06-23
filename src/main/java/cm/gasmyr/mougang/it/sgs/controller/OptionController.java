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

import cm.gasmyr.mougang.it.sgs.core.Option;
import cm.gasmyr.mougang.it.sgs.impl.service.OptionService;
@Controller
public class OptionController {
	
	private OptionService optionService;

	@Autowired
	public OptionController(OptionService optionService) {
		this.optionService = optionService;
	}
	
	@RequestMapping("/options")
	public String goToOptionListPage(Model model) {
		model.addAttribute("options", optionService.getAll());
		return "OptionListPage";
	}

	@RequestMapping(value = "/edit_option/{id}", method = RequestMethod.GET)
	public String goToOptionEditPage(Model model, @PathVariable Long id) {
		Option option = optionService.getById(id);
		model.addAttribute("option", option);
		return "OptionEditPage";
	}

	@RequestMapping(value = "/edit_option/{id}", method = { RequestMethod.POST })
	public String editOption(@Valid Option option, BindingResult bindingResult, @PathVariable Long id) {
		Option oldOption = optionService.getById(id);
		oldOption.updateInternal(option);
		optionService.add(oldOption);
		return "redirect:/options";
	}

	@RequestMapping(value = "/delete_option/{id}")
	public String deleteOptionl(@Valid Option option, BindingResult bindingResult, @PathVariable Long id) {
		Option optionToBeDeleted = optionService.getById(id);
		optionService.delete(optionToBeDeleted);
		return "redirect:/options";
	}

	@GetMapping(value = "/option")
	public String gotoAddPage(Model model) {
		model.addAttribute("option", new Option());
		return "OptionAddPage";
	}

	@RequestMapping(value = "/option", method = RequestMethod.POST)
	public String saveOption(@Valid Option option, BindingResult bindingResult, Model model) {
		optionService.add(option);
		return "redirect:/options";
	}

}
