package com.qa.dog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dog.domain.Dog;
import com.qa.dog.service.DogService;

@RestController
public class DogController {

	private DogService dservice;

	@Autowired // tells Spring to fetch the PersonService from the context - dependency
				// injection
	public DogController(DogService dservice) {
		super();
		this.dservice = dservice;
	}

	@PostMapping("/create")
	public ResponseEntity<Dog> createDog(@RequestBody Dog d) {
		Dog created = this.dservice.create(d);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(created, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Dog>> getAllDogs() {
		return ResponseEntity.ok(this.dservice.getAll());
	}

	@GetMapping("/get/{id}")
	public Dog getDog(@PathVariable Integer id) {
		return this.dservice.getOne(id);
	}

	// read by name
	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Dog>> getDogByName(@PathVariable String name) {
		List<Dog> found = this.dservice.getDogsByName(name);
		return ResponseEntity.ok(found);
	}

	// read by breed
	@GetMapping("/getByBreed/{breed}")
	public ResponseEntity<List<Dog>> getDogByBreed(@PathVariable String breed) {
		List<Dog> found = this.dservice.getDogsByBreed(breed);
		return ResponseEntity.ok(found);
	}

	// read by gender
	@GetMapping("/getByGender/{gender}")
	public ResponseEntity<List<Dog>> getDogByGender(@PathVariable String gender) {
		List<Dog> found = this.dservice.getDogsByGender(gender);
		return ResponseEntity.ok(found);
	}

	// read by age
	@GetMapping("/getByAge/{age}")
	public ResponseEntity<List<Dog>> getDogByAge(@PathVariable Integer age) {
		List<Dog> found = this.dservice.getDogsByAge(age);
		return ResponseEntity.ok(found);
	}

	@PutMapping("/replace/{id}")
	public ResponseEntity<Dog> replaceDog(@PathVariable Integer id, @RequestBody Dog newDog) {
		Dog body = this.dservice.replace(id, newDog);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeDog(@PathVariable Integer id) {
		this.dservice.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
