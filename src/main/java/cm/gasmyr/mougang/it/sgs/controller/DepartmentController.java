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

import cm.gasmyr.mougang.it.sgs.core.Department;
import cm.gasmyr.mougang.it.sgs.impl.service.DepartmentService;

@Controller
public class DepartmentController {

	private DepartmentService departmentService;

	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@RequestMapping("/departments")
	public String goToDepartmentListPage(Model model) {
		model.addAttribute("departments", departmentService.getAll());
		return "DepartmentListPage";
	}

	@RequestMapping(value = "/edit_department/{id}", method = RequestMethod.GET)
	public String goToDepartmentEditPage(Model model, @PathVariable Long id) {
		Department department = departmentService.getById(id);
		model.addAttribute("department", department);
		return "DepartmentEditPage";
	}

	@RequestMapping(value = "/edit_department/{id}", method = { RequestMethod.POST })
	public String editDepartment(@Valid Department department, BindingResult bindingResult, @PathVariable Long id) {
		Department oldDepartment = departmentService.getById(id);
		oldDepartment.updateInternal(department);
		departmentService.add(oldDepartment);
		return "redirect:/departments";
	}

	@RequestMapping(value = "/delete_department/{id}")
	public String deleteDepartment(@Valid Department option, BindingResult bindingResult, @PathVariable Long id) {
		Department departmentToBeDeleted = departmentService.getById(id);
		departmentService.delete(departmentToBeDeleted);
		return "redirect:/departments";
	}

	@GetMapping(value = "/department")
	public String gotoAddPage(Model model) {
		model.addAttribute("department", new Department());
		return "DepartmentAddPage";
	}

	@RequestMapping(value = "/department", method = RequestMethod.POST)
	public String saveDepartment(@Valid Department option, BindingResult bindingResult, Model model) {
		departmentService.add(option);
		return "redirect:/departments";
	}

}
