package com.qa.dog.web;

import java.util.ArrayList;
import java.util.List;

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

@RestController
public class DogController {

	private List<Dog> dogs = new ArrayList<>();

	@PostMapping("/create")
	public ResponseEntity<Dog> createDog(@RequestBody Dog d) {
		this.dogs.add(d);
		Dog created = this.dogs.get(this.dogs.size() - 1);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(created, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Dog>> getAllDogs() {
		return ResponseEntity.ok(this.dogs);
	}

	@GetMapping("/get/{id}")
	public Dog getDog(@PathVariable Integer id) {
		return this.dogs.get(id);
	}

	@PutMapping("/replace/{id}")
	public ResponseEntity<Dog> replaceDog(@PathVariable Integer id, @RequestBody Dog newDog) {
		Dog body = this.dogs.set(id, newDog);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeDog(@PathVariable Integer id) {
		this.dogs.remove(id.intValue());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
