package com.codingdojo.DriversLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DriversLicense.models.Person;
import com.codingdojo.DriversLicense.repositories.PersonRepo;

@Service
public class PersonService {
	private final PersonRepo personRepo;
	
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}
	public Person findPerson(Long personId) {
		Optional<Person> optionalPerson = personRepo.findById(personId);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	public List<Person> findAllPersons(){
		return personRepo.findAll();
	}
	public void deletePerson(Long id) {
		personRepo.deleteById(id);
	}
	
}
