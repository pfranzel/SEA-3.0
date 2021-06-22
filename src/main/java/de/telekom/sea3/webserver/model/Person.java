package de.telekom.sea3.webserver.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="persons")

public class Person {
	
	// SQL: CREATE TABLE persons ( ID integer primary key, ANREDE VARCHAR(10), VORNAME VARCHAR(20), LASTNAME VARCHAR(20));

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column // Column ist eine Spalte
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String salutation;
	
	@Column
	private String birthdate;
	
	@Column
	private String location;
	
	@Column
	private String email;
	
	public Person() {}
	
	public Person(String firstname, String lastname, String salutation) {
		// TODO Auto-generated constructor stub
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
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
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
 