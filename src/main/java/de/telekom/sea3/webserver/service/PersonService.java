package de.telekom.sea3.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.repo.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		System.out.println("PersonService instanziert: " + this.toString());
		System.out.println("PersonRepository: " + personRepository.toString());
		this.personRepository = personRepository;
	}

	public int getSize() {
		return personRepository.getSize();
	}
	
	public int getMaxId() {
		return personRepository.getMaxId();
	}

	public Personen getAllPersons() {
		return new Personen(personRepository.getAll());
	}

	public Person get(int id) {
		
//		return new Person("Max","Mustermann","Herr");
		return personRepository.get(id);
	}

	public Person add(Person person) {
		personRepository.add(person);
		System.out.println("Person was created!");
		return person;
	}
	
	public Person delete(int id) {
		System.out.println("Person with ID: \"" + id + "\" will be deleted  ");
		personRepository.delete(id);
		return null;
	}
	
	public boolean clear() {
		System.out.println("Cleanup the list completely");
		return personRepository.clear();
	}
}