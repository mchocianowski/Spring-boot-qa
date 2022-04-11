package com.qa.dog.domain;

public class Dog {
	
	private Integer id;
	private String name;
	private String breed;
	private String gender;
	private Integer age;
	
	public Dog(Integer id, String name, String breed, String gender, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.age = age;
	}

	public Dog() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", gender=" + gender + ", age=" + age + "]";
	}
}
