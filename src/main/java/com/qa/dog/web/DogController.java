package com.qa.dog.web;

import java.util.ArrayList;
import java.util.List;

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
	public Dog createDog(@RequestBody Dog d) {
		this.dogs.add(d);
		Dog created = this.dogs.get(this.dogs.size() - 1);
		return created;
	}

	@GetMapping("/getAll")
	public List<Dog> getAllDogs() {
		return this.dogs;
	}

	@GetMapping("/get/{id}")
	public Dog getDog(@PathVariable Integer id) {
		return this.dogs.get(id);
	}

	@PutMapping("/replace/{id}")
	public Dog replaceDog(@PathVariable Integer id, @RequestBody Dog newDog) {
		Dog body = this.dogs.set(id, newDog);
		return body;
	}

	@DeleteMapping("/remove/{id}")
	public void removeDog(@PathVariable Integer id) {
		this.dogs.remove(id.intValue());
	}
}
