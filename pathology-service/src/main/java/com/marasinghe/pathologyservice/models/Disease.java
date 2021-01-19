package com.marasinghe.pathologyservice.models;

public class Disease {

	private String Id;
	private String description;
	private String treatment;
	
	//default constructor
	public Disease() {
		
	}
     
	//constructor
	public Disease(String id, String description, String treatment) {
		Id = id;
		this.description = description;
		this.treatment = treatment;
	}

	//getters and setters
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
	
	
	
	
	
	
}
