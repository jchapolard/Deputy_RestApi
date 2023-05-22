package com.PNM3.Deputy_RESTApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PNM3.Deputy_RESTApi.model.Deputy;
import com.PNM3.Deputy_RESTApi.repository.DeputyRepository;

import lombok.Data;

@Data
@Service
public class DeputyService {

	@Autowired
	private DeputyRepository deputyRepository;
	
	
	public Optional<Deputy> getDeputyById(final Long id){
		return deputyRepository.findById(id);
	}
	
	public List<Deputy> getDeputies(){
	//public List<Deputy> getDeputies(){
		//return deputyRepository.findAll();
		 var deputies = (List<Deputy>) deputyRepository.findAll();
		 deputies.stream().map(n->n.getLastName() +" " + n.getFirstName())
		 		.sorted();
		 		//.collect(Collectors.toList());
		 deputies.forEach(System.out::println);
		return deputies;
	}
	
	public Deputy createDeputy(Deputy deputy) {
		return deputyRepository.save(deputy);
	}
	
	public Deputy updateDeputy(final Long id){
		Deputy deputy = deputyRepository.findById(id).get();
		return deputyRepository.save(deputy);
	}
	
	public void deleteDeputy(final Long id) {
		deputyRepository.deleteById(id);
	}
}
