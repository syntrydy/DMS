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

import cm.gasmyr.mougang.it.sgs.core.Student;
import cm.gasmyr.mougang.it.sgs.impl.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping("/students")
	public String goToStudentListPage(Model model) {
		model.addAttribute("students", studentService.getAll());
		return "StudentListPage";
	}

	@RequestMapping(value = "/edit_student/{id}", method = RequestMethod.GET)
	public String goToStudentEditPage(Model model, @PathVariable Long id) {
		Student student = studentService.getById(id);
		model.addAttribute("student", student);
		return "StudentEditPage";
	}

	@RequestMapping(value = "/edit_student/{id}", method = { RequestMethod.POST })
	public String editStudent(@Valid Student student, BindingResult bindingResult, @PathVariable Long id) {
		Student oldstudent = studentService.getById(id);
		oldstudent.updateInternal(student);
		studentService.add(oldstudent);
		return "redirect:/students";
	}

	@RequestMapping(value = "/delete_student/{id}")
	public String deleteStudent(@Valid Student student, BindingResult bindingResult, @PathVariable Long id) {
		Student studentToBeDeleted = studentService.getById(id);
		studentService.delete(studentToBeDeleted);
		return "redirect:/students";
	}

	@GetMapping(value = "/student")
	public String gotoAddPage(Model model) {
		model.addAttribute("student", new Student());
		return "StudentAddPage";
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String saveStudent(@Valid Student student, BindingResult bindingResult, Model model) {
		studentService.add(student);
		return "redirect:/students";
	}

}
