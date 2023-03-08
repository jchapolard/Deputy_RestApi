package com.PNM3.Deputy_RESTApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="political_parties")
public class PoliticalParties {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="labels")
	private String namePoliticalParty;
	
	@Column(name="number_political_party")
	private String idPoliticalParty;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "number_political_party")
	private Deputy deputyy;
	//@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "number_political_party")
    
	
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

	public String getIdPoliticalParty() {
		return idPoliticalParty;
	}

	public void setIdPoliticalParty(String idPoliticalParty) {
		this.idPoliticalParty = idPoliticalParty;
	}
	
	
}
