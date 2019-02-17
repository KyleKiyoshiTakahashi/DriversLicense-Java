package com.codingdojo.DriversLicense.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.DriversLicense.models.License;

public interface LicenseRepo extends CrudRepository<License, Long> {

}
