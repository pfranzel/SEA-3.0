package de.telekom.sea3.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea3.webserver.repo.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;

		System.out.println("PersonRepository initialized: " + this.toString());

	}

	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
