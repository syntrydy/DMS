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

import cm.gasmyr.mougang.it.sgs.core.Facility;
import cm.gasmyr.mougang.it.sgs.impl.service.FacilityService;

@Controller
public class FacilityController {

	private FacilityService facilityService;

	@Autowired
	public FacilityController(FacilityService facilityService) {
		this.facilityService = facilityService;
	}

	@RequestMapping("/facilities")
	public String goToFacilityListPage(Model model) {
		model.addAttribute("facilities", facilityService.getAll());
		return "FacilityListPage";
	}

	@RequestMapping(value = "/edit_facility/{id}", method = RequestMethod.GET)
	public String goToFacilityEditPage(Model model, @PathVariable Long id) {
		Facility facility = facilityService.getById(id);
		model.addAttribute("facility", facility);
		return "FacilityEditPage";
	}

	@RequestMapping(value = "/edit_facility/{id}", method = { RequestMethod.POST })
	public String editFacility(@Valid Facility facility, BindingResult bindingResult, @PathVariable Long id) {
		Facility oldFacility = facilityService.getById(id);
		oldFacility.updateInternal(facility);
		facilityService.add(oldFacility);
		return "redirect:/facilities";
	}

	@RequestMapping(value = "/delete_facility/{id}")
	public String deleteFacility(@Valid Facility facility, BindingResult bindingResult, @PathVariable Long id) {
		Facility facilityToBeDeleted = facilityService.getById(id);
		facilityService.delete(facilityToBeDeleted);
		return "redirect:/facilities";
	}

	@GetMapping(value = "/facility")
	public String gotoAddPage(Model model) {
		model.addAttribute("facility", new Facility());
		return "FacilityAddPage";
	}

	@RequestMapping(value = "/facility", method = RequestMethod.POST)
	public String saveFacilityt(@Valid Facility facility, BindingResult bindingResult, Model model) {
		facilityService.add(facility);
		return "redirect:/facilities";
	}

}
