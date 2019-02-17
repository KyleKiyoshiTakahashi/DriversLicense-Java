package com.codingdojo.DriversLicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.DriversLicense.models.License;
import com.codingdojo.DriversLicense.repositories.LicenseRepo;
@Service
public class LicenseService {
	private final LicenseRepo lr;
	
	private static String newNumber = "000000";
	
	
	public LicenseService(LicenseRepo lr) {
		this.lr = lr;
	}
	public License createLicense(License license) {
		newNumber = String.format("%06d", Integer.parseInt(newNumber)+1);
		license.setNumber(newNumber);
		
		return lr.save(license);
	}
	
	public List<License> showAll(){
		return (List<License>) lr.findAll();
	}
	
	
	
	
	
	public void deleteLicense(Long id) {
		lr.deleteById(id);
	}
	
	
}
