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

import cm.gasmyr.mougang.it.sgs.core.Teacher;
import cm.gasmyr.mougang.it.sgs.impl.service.TeacherService;

@Controller
public class TeacherController {

	private TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@RequestMapping("/teachers")
	public String goToTeacherListPage(Model model) {
		model.addAttribute("teachers", teacherService.getAll());
		return "TeacherListPage";
	}

	@RequestMapping(value = "/edit_teacher/{id}", method = RequestMethod.GET)
	public String goToTeacherEditPage(Model model, @PathVariable Long id) {
		Teacher teacher = teacherService.getById(id);
		model.addAttribute("teacher", teacher);
		return "TeacherEditPage";
	}

	@RequestMapping(value = "/edit_teacher/{id}", method = { RequestMethod.POST })
	public String editTeacher(@Valid Teacher teacher, BindingResult bindingResult, @PathVariable Long id) {
		Teacher oldteacher = teacherService.getById(id);
		oldteacher.updateInternal(teacher);
		teacherService.add(oldteacher);
		return "redirect:/teachers";
	}

	@RequestMapping(value = "/delete_teacher/{id}")
	public String deleteTeacher(@Valid Teacher teacher, BindingResult bindingResult, @PathVariable Long id) {
		Teacher teacherToBeDeleted = teacherService.getById(id);
		teacherService.delete(teacherToBeDeleted);
		return "redirect:/teachers";
	}

	@GetMapping(value = "/teacher")
	public String gotoAddPage(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "TeacherAddPage";
	}

	@RequestMapping(value = "/teacher", method = RequestMethod.POST)
	public String saveTeacher(@Valid Teacher teacher, BindingResult bindingResult, Model model) {
		teacherService.add(teacher);
		return "redirect:/teachers";
	}

}
