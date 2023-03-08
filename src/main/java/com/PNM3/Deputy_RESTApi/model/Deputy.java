package com.PNM3.Deputy_RESTApi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="deputies")
public class Deputy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
    
    @Column(name="int_department")
    private Integer intDepartment;
    
    @Column(name="id_political_party")
    private Integer idPoliticalParty;
    
    //@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_political_party")
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "deputyy")
    //private PoliticalParties polipart;
    //private List<PoliticalParties> polipart;
 
    
    
    
    
	public Deputy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getIntDepartment() {
		return intDepartment;
	}

	public void setIntDepartment(Integer intDepartment) {
		this.intDepartment = intDepartment;
	}

	public Integer getIdPoliticalParty() {
		return idPoliticalParty;
	}

	public void setIdPoliticalParty(Integer idPoliticalParty) {
		this.idPoliticalParty = idPoliticalParty;
	}
}
