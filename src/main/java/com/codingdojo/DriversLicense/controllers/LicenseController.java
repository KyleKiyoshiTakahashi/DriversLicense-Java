package com.codingdojo.DriversLicense.controllers;



import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.DriversLicense.models.License;

import com.codingdojo.DriversLicense.services.LicenseService;
import com.codingdojo.DriversLicense.services.PersonService;

@Controller
public class LicenseController {
	
	private final LicenseService ls;
	
	private  final PersonService ps; 
	
	public LicenseController(LicenseService ls, PersonService ps) {
		this.ps = ps;
		this.ls = ls;
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(Model model, @ModelAttribute("license") License license) {
		model.addAttribute("allPersons", ps.findAllPersons());
		return "/DriversLicense/newLicense.jsp";
	}
	
	@PostMapping("/licenses")
	public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "/DriversLicense/newLicense.jsp";
		} else { 
			
			License createdLicense = ls.createLicense(license);
			return "redirect:/persons/" + createdLicense.getPerson().getId();
		}
	}
	
}	
