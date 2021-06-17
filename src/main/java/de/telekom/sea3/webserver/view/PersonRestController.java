package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.model.Size;
import de.telekom.sea3.webserver.service.PersonService;

@RestController
public class PersonRestController {

	private PersonService personService;

	@Autowired
	public PersonRestController(PersonService personService) {
		super();
		this.personService = personService;
	}

	/**
	 * URL: <a href="http://localhost:8080/json/persons/all">the url...</a>
	 * 
	 * @return
	 */
	// URL:"http://localhost:8080/json/persons/all"
	@GetMapping("/json/persons/all")
	public Personen getAllPersons() {
		Personen personen = personService.getAllPersons();
		return personen;
	}

	/**
	 * URL: <a href="http://localhost:8080/json/persons/size">the url...</a>
	 * 
	 * @return
	 */
	// URL:"http://localhost:8080/json/persons/maxsize"
	@GetMapping("/json/persons/maxsize")
	public Size getMaxSize() {
		return new Size(personService.getMaxId());
	}
	
	/**
	 * URL: <a href="http://localhost:8080/json/persons/maxid">the url...</a>
	 * 
	 * @return
	 */
	// URL:"http://localhost:8080/json/persons/size"
	@GetMapping("/json/persons/maxid")
	public int getMaxId() {
		return personService.getAllPersons().getPersonen().size();
	}

	/**
	 * URL: <a href="http://localhost:8080/json/persons/size">the url...</a>
	 * 
	 * @return
	 */
	// URL:"http://localhost:8080/json/persons/42"
	@GetMapping("/json/persons/{id}")
	public Person getPerson(@PathVariable("id") int id) {
		return personService.get(id);
	}
	
	/**
	 * 
	 * URL: <a href="http://localhost:8080/json/person">the url...</a>
	 * 
	 * @return
	 */
	@PostMapping(path = "json/person")
	public Person addPerson(@RequestBody Person person) {
		return personService.add(person);
	}
	
	/**
	 * 
	 * URL: <a href="http://localhost:8080/json/persons/">the url...</a>
	 * 
	 * @return
	 */
	@DeleteMapping(path = "json/persons/{id}")
	public Person removePerson(@PathVariable("id") int id) {
		return personService.delete(id);
	}
	
	@DeleteMapping(path = "json/persons/all")
	public boolean clearPerson() {
		return personService.clear();
	}
	
}
