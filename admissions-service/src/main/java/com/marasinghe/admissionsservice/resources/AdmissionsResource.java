package com.marasinghe.admissionsservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.marasinghe.admissionsservice.models.DiseasesList;
import com.marasinghe.admissionsservice.models.EmployeesList;
import com.marasinghe.admissionsservice.models.Patient;

@RestController
@RequestMapping("/admissions") 
public class AdmissionsResource {
	
	
	//creating a RestTemplate private variable
	//a rest template is used for making a REST request
	//if u want to make a call from 1 service to another,
	//what u are going to use to make that call to get data to pull data is called a rest template 
	//these will be actually be used to making the call
	
	@Autowired
	private RestTemplate restTemplate;
	
	//hard coding patients 
	List<Patient> patients = Arrays.asList(
			new Patient("P1", "Nilu", "SriLankan"),
			new Patient("P2", "Sachi", "Indian"),
			new Patient("P3", "ku",    "American")
			);
	
	//getPhysician is from the HR admissions we are trying to get employees list from the HR microservice
	//and we need to get this inside of a list several list of items we are trying to get it as an object called employees list object. 
		
		@RequestMapping("/physician")
		public EmployeesList getPhysicians() {
			EmployeesList employeesList = restTemplate.getForObject("http://hr-service/hr/employees", EmployeesList.class);
			
			return employeesList;
		}
		 
		
	    //getDiseases() method uses restTemplate to get the list of diseases. this method returns a list of diseases as DiseasesList object
		//instead of returning list of objects, we create an object a class called diseaseList and that will be the object to return just 1 single object
		
		 @RequestMapping("/diseases")
		public DiseasesList getDiseases() {
			   DiseasesList diseasesList = restTemplate.getForObject("http://pathology-service/pathology/diseases", DiseasesList.class);
			
			return diseasesList;
		}
		
		
	//create a method getPatients() that return list of patients 
	
	@RequestMapping("/patients")
	public List<Patient> getPatients(){
		
		return patients;
	}

	
	//create a method getPatientById() that takes and id and returns a single patient
	//annotate the Id parameter with @pathVariable annotation
	
	@RequestMapping("/patients/{Id}")  //id parameter is going to change so is in curly braces
	public Patient getPatientById(@PathVariable("Id")String Id) {
		//using Stream API available in java
		Patient p = patients.stream()
				.filter(patient -> Id.equals(patient.getId()))
				.findAny()
				.orElse(null);
		return p;
		
	}
}
