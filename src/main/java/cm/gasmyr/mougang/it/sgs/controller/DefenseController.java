package cm.gasmyr.mougang.it.sgs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cm.gasmyr.mougang.it.sgs.core.Defense;
import cm.gasmyr.mougang.it.sgs.impl.service.DefenseService;
import cm.gasmyr.mougang.it.sgs.impl.service.MailService;
import cm.gasmyr.mougang.it.sgs.impl.service.StudentService;
import cm.gasmyr.mougang.it.sgs.mail.Message;
import cm.gasmyr.mougang.it.sgs.utils.PdfGenaratorUtil;

@Controller
public class DefenseController {

	private DefenseService defenseService;
	private MailService mailService;
	private StudentService studentService;
	PdfGenaratorUtil pdfGenaratorUtil;

	@Autowired
	public DefenseController(DefenseService defenseService, MailService mailService,StudentService studentService,
			PdfGenaratorUtil pdfGenaratorUtil) {
		this.defenseService = defenseService;
		this.mailService = mailService;
		this.studentService=studentService;
		this.pdfGenaratorUtil = pdfGenaratorUtil;
	}

	@RequestMapping("/defenses")
	public String goToDefenseListPage(Model model) {
		model.addAttribute("defenses", defenseService.getAll());
		return "DefenseListPage";
	}

	@RequestMapping(value = "/edit_defense/{id}", method = RequestMethod.GET)
	public String goToDefenseEditPage(Model model, @PathVariable Long id) {
		Defense defense = defenseService.getById(id);
		model.addAttribute("defense", defense);
		return "DefenseEditPage";
	}

	@RequestMapping(value = "/edit_defense/{id}", method = { RequestMethod.POST })
	public String editDefense(@Valid Defense defense, BindingResult bindingResult, @PathVariable Long id) {
		Defense olddefense = defenseService.getById(id);
		olddefense.updateInternal(defense);
		defenseService.add(olddefense);
		return "redirect:/defenses";
	}

	@RequestMapping(value = "/delete_defense/{id}")
	public String deleteDefense(@Valid Defense defense, BindingResult bindingResult, @PathVariable Long id) {
		Defense defenseToBeDeleted = defenseService.getById(id);
		defenseService.delete(defenseToBeDeleted);
		return "redirect:/defenses";
	}

	@GetMapping(value = "/defense")
	public String gotoAddPage(Model model) {
		model.addAttribute("defense", new Defense());
		model.addAttribute("students", studentService.getAll());
		return "DefenseAddPage";
	}

	@RequestMapping(value = "/defense", method = RequestMethod.POST)
	public String saveDefense(@Valid Defense defense, BindingResult bindingResult, Model model) {
		boolean wellDone = defenseService.add(defense);
		if (wellDone) {
			Message message = new Message();
			mailService.sendMessageTo(message);
		}
		return "redirect:/defenses";
	}

	public String generatePdf() {
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "James");
		try {
			pdfGenaratorUtil.createPdf("DefenseListPage", data);
			return "redirect:/defenses";
		} catch (Exception e) {
			return "redirect:/defenses";
		}
	}

}
