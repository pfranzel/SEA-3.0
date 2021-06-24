package de.telekom.sea3.webserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Persons;
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

	
	public Persons getAllPersons() {
		return new Persons(personRepository.findAll());
	}

	public Optional<Person> getById(Long id) {
		return personRepository.findById(id);
	}

	public Person add(Person person) {
		personRepository.save(person);
		System.out.println("Person was created!");
		return person;
	}
	
	public Person search(long id) {
		System.out.println("Person searched!");
		return personRepository.findById(id).get();
	}
	
	public Person update(Person person) {
		personRepository.save(person);
		System.out.println("Person was created!");
		return person;
	}
	
	public Person delete(long id) {
		System.out.println("Try to delete person with ID: \"" + id );
		try {
			personRepository.deleteById(id);
		} catch (NumberFormatException e) {
			return null;
		} catch (Exception e) {
			System.out.println("Exception: " + e); 		
		} 
		return null;
	}
	
	public void clear() {
		System.out.println("Cleanup the list completely");
		personRepository.deleteAll();
	}


	public long count() {
		long count = personRepository.count();
		System.out.println("There are " + count + "entries in the table");
		return count;
	}
}