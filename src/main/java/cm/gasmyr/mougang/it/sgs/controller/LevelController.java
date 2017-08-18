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

import cm.gasmyr.mougang.it.sgs.core.Level;
import cm.gasmyr.mougang.it.sgs.impl.service.LevelService;
import cm.gasmyr.mougang.it.sgs.impl.service.OptionService;
@Controller
public class LevelController {
	
	private LevelService levelService;
	private OptionService optionService;

	@Autowired
	public LevelController(LevelService levelService,OptionService optionService) {
		this.levelService = levelService;
		this.optionService=optionService;
	}
	
	@RequestMapping("/levels")
	public String goToLevelListPage(Model model) {
		model.addAttribute("levels", levelService.getAll());
		return "LevelListPage";
	}

	@RequestMapping(value = "/edit_level/{id}", method = RequestMethod.GET)
	public String goToLevelEditPage(Model model, @PathVariable Long id) {
		Level level = levelService.getById(id);
		model.addAttribute("level", level);
		model.addAttribute("options", optionService.getAll());
		return "LevelEditPage";
	}

	@RequestMapping(value = "/edit_level/{id}", method = { RequestMethod.POST })
	public String editLevel(@Valid Level level, BindingResult bindingResult, @PathVariable Long id) {
		Level oldLevel = levelService.getById(id);
		oldLevel.updateInternal(level);
		levelService.add(oldLevel);
		return "redirect:/levels";
	}

	@RequestMapping(value = "/delete_level/{id}")
	public String deleteLevel(@Valid Level level, BindingResult bindingResult, @PathVariable Long id) {
		Level levelToBeDeleted = levelService.getById(id);
		levelService.delete(levelToBeDeleted);
		return "redirect:/levels";
	}

	@GetMapping(value = "/level")
	public String gotoAddPage(Model model) {
		model.addAttribute("level", new Level());
		model.addAttribute("options", optionService.getAll());
		return "LevelAddPage";
	}

	@RequestMapping(value = "/level", method = RequestMethod.POST)
	public String saveLevel(@Valid Level level, BindingResult bindingResult, Model model) {
		levelService.add(level);
		return "redirect:/levels";
	}

}
