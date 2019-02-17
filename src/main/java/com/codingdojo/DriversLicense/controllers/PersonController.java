package com.codingdojo.DriversLicense.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.DriversLicense.models.Person;
import com.codingdojo.DriversLicense.services.PersonService;

@Controller
public class PersonController {
	
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/DriversLicense/NewPerson.jsp";
	}
	@PostMapping("/persons")
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "/DriversLicense/NewPerson.jsp";
		} else {
			Person createdPerson = personService.createPerson(person);
			return "redirect:/persons/" + createdPerson.getId();
		}
		
	}
	@GetMapping("/persons/{personId}")
	public String show(@PathVariable("personId") Long personId, Model model) {
		Person person = personService.findPerson(personId);
		model.addAttribute("person", person);
		return "/DriversLicense/details.jsp";
	}
	@RequestMapping("persons/{personId}/delete")
	public String deleteUser(@PathVariable("personId") Long personId) {
		personService.deletePerson(personId);
		return "redirect:/persons/new";
	}
}
