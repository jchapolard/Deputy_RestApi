package com.PNM3.Deputy_RESTApi.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
    
    //@Column(name="id_political_party")
    //private Integer idPoliticalParty;
    
    @OneToOne
    @JoinColumn(name="id_political_party")
    private PoliticalParties politicalParty;
    
  
    
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

	public PoliticalParties getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(PoliticalParties politicalParty) {
		this.politicalParty = politicalParty;
	}
	
}
