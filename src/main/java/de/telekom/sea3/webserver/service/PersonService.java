package de.telekom.sea3.webserver.service;

import java.util.Optional;

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

	
	public Personen getAllPersons() {
		return new Personen(personRepository.findAll());
	}

	public Optional<Person> getById(Long id) {
		return personRepository.findById(id);
	}

	public Person add(Person person) {
		personRepository.save(person);
		System.out.println("Person was created!");
		return person;
	}
	
	public Person delete(long id) {
		System.out.println("Person with ID: \"" + id + "\" will be deleted  ");
		personRepository.deleteById(id);
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