package com.qa.dog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.dog.domain.Dog;
import com.qa.dog.repo.DogRepo;

@Service // stores the main business logic of the application
public class DogService {

	
	private DogRepo drepo;

	@Autowired
	public DogService(DogRepo drepo) {
		super();
		this.drepo=drepo;
	}
	
//CRUD	
	public Dog create(Dog d) {
		Dog created = this.drepo.save(d);
		return created;
	}

	public List<Dog> getAll() {
		return this.drepo.findAll();
	}

	public Dog getOne(Integer id) {
		Optional<Dog> found = this.drepo.findById(id);
		return found.get();
	}
	
	// SELECT * FROM Person WHERE name= 
		public List<Dog> getDogsByName(String name) {
			List<Dog> found = this.drepo.findByNameIgnoreCase(name);
			return found;
		}
		
		public List<Dog> getDogsByBreed(String breed) {
			List<Dog> found = this.drepo.findByBreedIgnoreCase(breed);
			return found;
		}
		
		public List<Dog> getDogsByGender(String gender) {
			List<Dog> found = this.drepo.findByGenderIgnoreCase(gender);
			return found;
		}
		// SELECT * FROM Person WHERE age= 
		public List<Dog> getDogsByAge(Integer age) {
			List<Dog> found = this.drepo.findByAge(age);
			return found;
		}

	public Dog replace(Integer id, Dog newDog) {
		Dog existing = this.drepo.findById(id).get();
		existing.setName(newDog.getName());
		existing.setBreed(newDog.getBreed());
		existing.setGender(newDog.getGender());
		existing.setAge(newDog.getAge());
		Dog updated = this.drepo.save(existing);
		return updated;
	}

	public void remove(@PathVariable Integer id) {
		this.drepo.deleteById(id);

	}
}