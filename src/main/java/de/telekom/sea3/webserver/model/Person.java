package de.telekom.sea3.webserver.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Version;

import de.telekom.sea3.lookup.Salutation;

// SQL: CREATE TABLE persons ( ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT, VERSION BIGINT NOT NULL DEFAULT 1, SALUTATION VARCHAR(10), FIRSTNAME VARCHAR(20), LASTNAME VARCHAR(20), BIRTHDATE DATE, LOCATION VARCHAR(40), EMAIL VARCHAR(40));

@Entity
@Table(name="persons")

public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Version
	private Long version;
	
	@Column // Column ist eine Spalte
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
    @Enumerated(EnumType.ORDINAL)    //  ORDINAL: 0, 1,2,3,4  public static final int FRAU = 0 ...,  EnumType.STRING: "FRAU", "HERR", "DIVERS"
	private Salutation salutation;
	
	@Column
	private Date birthdate;
	
	@Column
	private String location;
	
	@Column
	private String email;
	
	public Person() {}
	
	public Person(String firstname, String lastname, String salutation) {
		// TODO Auto-generated constructor stub
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Salutation getSalutation() {
		return salutation;
	}
	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
 