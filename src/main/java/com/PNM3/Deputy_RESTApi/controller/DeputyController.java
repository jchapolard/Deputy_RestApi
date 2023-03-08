package com.PNM3.Deputy_RESTApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PNM3.Deputy_RESTApi.model.Deputy;
import com.PNM3.Deputy_RESTApi.service.DeputyService;

@RestController
public class DeputyController {

	@Autowired
	private DeputyService deputyService;
	
	//private Logging log 
	@GetMapping("/deputies/{id}")
	@ResponseBody
	public Optional<Deputy> getDeputy(@PathVariable final Long id){
		return deputyService.getDeputyById(id);
	}
	
	@GetMapping("/deputies")
	@ResponseBody
	public List<Deputy> getDeputy(){
		return deputyService.getDeputies();
	}
	
	@PostMapping("/deputies")
	public Deputy createDeputy(Deputy deputy) {
		return deputyService.createDeputy(deputy);
	}
	
	@PutMapping("/deputies/{id}")
	public Deputy updateDeputy(@PathVariable final Long id) {
		return deputyService.updateDeputy(id);
	}
	
	@DeleteMapping("/deputies/{id}")
	public void deleteDeputy(@PathVariable final Long id) {
		deputyService.deleteDeputy(id);
	}
	
	@RequestMapping("/hello")
    @ResponseBody
    public String helloWorld()
    {
        return "Hello World!";
    }
}
