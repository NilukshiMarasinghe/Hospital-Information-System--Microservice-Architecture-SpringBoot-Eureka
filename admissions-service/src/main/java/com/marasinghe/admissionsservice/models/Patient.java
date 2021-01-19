package com.marasinghe.admissionsservice.models;

//this class represents all patients data so patient's name patient's treatments
public class Patient {

	private String Id;
	private String name;
	private String nationality;
	
	//default constructor that takes no parameters
	public Patient() {
		
	}
	//constructor
	public Patient(String id, String name, String nationality) {
		Id = id;
		this.name = name;
		this.nationality = nationality;
	}
    
	//getters and setters
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	
}
