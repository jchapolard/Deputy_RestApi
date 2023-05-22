package com.PNM3.Deputy_RESTApi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.PNM3.Deputy_RESTApi.model.PoliticalParties;

public interface PoliticalPartyRepository  extends CrudRepository<PoliticalParties,Long>{
	
	Optional<PoliticalParties> findById(Long id);

}
