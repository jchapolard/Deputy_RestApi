package com.PNM3.Deputy_RESTApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="political_parties")
public class PoliticalParties {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="labels")
	private String namePoliticalParty;
		 
	// Relation est bidirectionnelle. Cela permet d'accéder aux députés d'un parti politique spécifique.
	//@OneToMany(mappedBy = "politicalParty")
    //private List<Deputy> deputies;
	
	
	
	public PoliticalParties() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNamePoliticalParty() {
		return namePoliticalParty;
	}

	public void setNamePoliticalParty(String namePoliticalParty) {
		this.namePoliticalParty = namePoliticalParty;
	}
}
