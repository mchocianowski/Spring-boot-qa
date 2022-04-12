package com.qa.dog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dog.domain.Dog;

@Repository
public interface DogRepo extends JpaRepository<Dog, Integer> {

	
	//SPRING WILL AUTO-GENERATE ALL OF THE BASIC CRUD FUNCTIONALITY :)
	
	List<Dog> findByNameIgnoreCase(String name);
	List<Dog> findByBreedIgnoreCase(String breed);
	List<Dog> findByGenderIgnoreCase(String gender);
	List<Dog> findByAge(Integer age);
}