package de.telekom.sea3.webserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	private Hund hund;

	private Katze katze;
	
	@Autowired
	public Person(Hund hund, Katze katze) {
		this.hund = hund;
		this.katze = katze;
		
		System.out.println("Person is generated! " + (this.hund != null) + " - reference --> " + this.hund.toString());
		
		System.out.println(this.hund.toString());
		System.out.println(this.katze.toString());
	}
}
 