package com.PNM3.Deputy_RESTApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PNM3.Deputy_RESTApi.model.Deputy;
import com.PNM3.Deputy_RESTApi.model.PoliticalParties;
import com.PNM3.Deputy_RESTApi.service.DeputyService;

@RestController
@RequestMapping("/deputies")
public class DeputyController {

	@Autowired
	private DeputyService deputyService;
	
	@GetMapping
	public List<Deputy> getDeputy(){
		return deputyService.findAllDeputy();
	}
	
	@GetMapping("/{id}")
	public Optional<Deputy> getDeputy(@PathVariable final Long id){
		return deputyService.getDeputyById(id);
	}
	
	@GetMapping("/lastName/{lastName}")
	public Optional<Deputy> getDeputyByLastName(@PathVariable final String lastName) {
		return deputyService.findByLastName(lastName);
	}
	
	@GetMapping("/intDepartment/{intDepatment}")
	public Optional<Deputy> getDeputyByDepartment(@PathVariable final Integer intDepartment) {
		return deputyService.findByIntDepartment(intDepartment);
	}
		
	@GetMapping("/politicalParty/{id}")
	public Optional<List<Deputy>> getDeputiesByPoliicalParty(@PathVariable final Long id) {
		return deputyService.findByPoliticalPartyId(id);
	}
	
	
	@PostMapping
	public Deputy createDeputy(Deputy deputy) {
		return deputyService.createDeputy(deputy);
	}
	
	@PutMapping("/{id}")
	public Deputy updateDeputy(@PathVariable final Long id) {
		return deputyService.updateDeputy(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDeputy(@PathVariable final Long id) throws Exception {
		deputyService.deleteDeputy(id);
	}
	
	@RequestMapping("/hello")
    public String helloWorld()
    {
        return "Hello World!";
    }
}
