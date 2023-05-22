package com.PNM3.Deputy_RESTApi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.PNM3.Deputy_RESTApi.model.Deputy;
import com.PNM3.Deputy_RESTApi.model.PoliticalParties;
import com.PNM3.Deputy_RESTApi.repository.DeputyRepository;
import com.PNM3.Deputy_RESTApi.repository.PoliticalPartyRepository;

@Service
public class DeputyService {

	@Autowired
	private DeputyRepository deputyRepository;
	
	@Autowired
	PoliticalPartyRepository politicalPartyRepository;
	
	public DeputyService(DeputyRepository deputyRepository, PoliticalPartyRepository politicalPartyRepository) {
        this.deputyRepository = deputyRepository;
        this.politicalPartyRepository = politicalPartyRepository;
    }
	
	
	
	public List<Deputy> findAllDeputy(){
		// StreamSupport.stream() créer un flux à partir de l'itérable
		// false pour l'argument parallélisme de manière séquentielle.
		return StreamSupport.stream(deputyRepository.findAll().spliterator(), false)
	            .collect(Collectors.toList());
	}
	
	public Page<Deputy> list(Pageable pageable) {
        return deputyRepository.findAll(pageable).map(deputy -> deputy);
    }
	
	public Optional<Deputy> getDeputyById(final Long id){
		return deputyRepository.findById(id);
	}
		
	public Optional<Deputy> findByLastName(String lastName) {
	    return deputyRepository.findByLastName(lastName);
	}
	
	public Optional<Deputy> findByIntDepartment(Integer intDepartment) {
	    return deputyRepository.findByIntDepartment(intDepartment);
	}
	
	public Optional<List<Deputy>> findByPoliticalPartyId(final Long politicalPartyId) {
		PoliticalParties politicalParty = politicalPartyRepository.findById(politicalPartyId)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid political party ID"));

	    return deputyRepository.findByPoliticalParty(politicalParty);
	}
	
	public Deputy createDeputy(Deputy deputy) {
		return deputyRepository.save(deputy);
	}
	
	public Deputy updateDeputy(final Long id){
		Deputy deputy = deputyRepository.findById(id).get();
		return deputyRepository.save(deputy);
	}
	
	public void deleteDeputy(final Long id) throws Exception {
		try {
			deputyRepository.deleteById(id);
		} catch (Exception e){
			throw new Exception("Delete error deputy id : "+id);
		}
	}
}
