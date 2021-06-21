package de.telekom.sea3.webserver.model;

public class Person {
	
	private String firstname;
	private String lastname;
	private String salutation;
	private Integer id;

	// ID
	// Delete einbauen
	// DeleteAll
	// PUT --> Update
	// Datum Format JJJ-MM-TT ;-)
	// more things if there is time

	public Person() {}
	
	public Person(String firstname, String lastname, String salutation) {
		// TODO Auto-generated constructor stub
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

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
 