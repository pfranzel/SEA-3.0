package de.telekom.sea3.webserver.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Persons;
import de.telekom.sea3.webserver.model.Size;
import de.telekom.sea3.webserver.service.PersonService;



@RestController
@EnableAutoConfiguration

public class PersonRestController {

	private PersonService personService;
    private static final Logger log = LoggerFactory.getLogger(PersonRestController.class);
	
	@Autowired
	public PersonRestController(PersonService personService) {
		super();
		this.personService = personService;
	}

//    public PersonRestController(MeterRegistry registry) {
//        // constructs a gauge to monitor the size of the population
//        registry.mapSize("persons_count", persons);
//    }

	
	/**
	 * URL: <a href="http://localhost:8080/json/persons/all">the url...</a>
	 * 
	 * @return
	 */
	// URL:"http://localhost:8080/json/persons/all"
	@GetMapping("/json/persons/all")
	public Persons getAllPersons() {
        log.info("Inside getAllPersons() method.");
		Persons persons = personService.getAllPersons();
        log.info("getAllPersons has been finished");
		return persons;
	}

	/**
	 * URL: <a href="http://localhost:8080/json/persons/size">the url...</a>
	 * 
	 * @return
	 */
	// URL:"http://localhost:8080/json/persons/maxsize"
	@GetMapping("/json/persons/maxsize")
	public Size getMaxSize() {
        log.info("Inside getAllPersons() method.");
        Size size = new Size(personService.count());
        log.info("getMaxSize() has been finished");
		return size;
	}
	
	/**
	 * URL: <a href="http://localhost:8080/json/persons/<id>">the url...</a>
	 * 
	 * @return
	 */
	// URL:"http://localhost:8080/json/persons/42"
	@GetMapping("/json/persons/{id}")
	public Person getPerson(@PathVariable("id") long id) {
        log.info("Inside getPerson() method.");
		Person person = personService.getById(id).get();
        log.info("getPerson() has been finished");
        return person;
	}
	
	/**
	 * 
	 * URL: <a href="http://localhost:8080/json/person">the url...</a>
	 * 
	 * @return
	 */
	@PostMapping(path = "json/person")
	public Person addPerson(@RequestBody Person person) {
        log.info("Inside addPerson() method.");
		personService.add(person);
        log.info("getPerson() has been finished");
        return person;
	}
	
	/**
	 * 
	 * URL: <a href="http://localhost:8080/json/person">the url...</a>
	 * 
	 * @return
	 */
	@PutMapping(path = "json/person")
	public Person updatePerson(@RequestBody Person person) {
        log.info("Inside updatePerson() method.");
		personService.update(person);
        log.info("updatePerson() has been finished");
		return person;
	}
	
	/**
	 * 
	 * URL: <a href="http://localhost:8080/json/persons/">the url...</a>
	 * 
	 * @return
	 */
	@DeleteMapping(path = "json/persons/{id}")
	public Person removePerson(@PathVariable("id") int id) {
        log.info("Inside removePerson() method.");
		Person person =  personService.delete(id);
        log.info("removePerson() has been finished");
        return person;
	}
	
	@DeleteMapping(path = "json/persons/all")
	public void clearPerson() {
        log.info("Inside clearPerson() method.");
		personService.clear();
        log.info("clearPerson() has been finished");
	}
	
//	@GetMapping("/json/select")
//	public Persons searchNachOrt(@RequestParam(name="location", required=false) String location) {
//		Persons persons = personService.selectPersons(location);
//		logger.info("Location: " + location);
//		return persons;
//	}
	
}
