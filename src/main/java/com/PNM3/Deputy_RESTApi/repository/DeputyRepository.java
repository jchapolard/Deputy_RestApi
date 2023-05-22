package com.PNM3.Deputy_RESTApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PNM3.Deputy_RESTApi.model.Deputy;
import com.PNM3.Deputy_RESTApi.model.PoliticalParties;

@Repository
public interface DeputyRepository extends CrudRepository<Deputy,Long>{
	
	Page<Deputy> findAll(Pageable pageable);
	Optional<Deputy> findById(Long id);
	Optional<Deputy> findByIntDepartment(Integer intDepartment);
	Optional<Deputy> findByLastName(String lastName);
	
	@Query("SELECT d FROM Deputy d WHERE d.politicalParty = :politicalParty")
	Optional<List<Deputy>> findByPoliticalParty(@Param("politicalParty") PoliticalParties politicalParty);

	
	
}
