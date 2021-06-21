package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonHtmlController {

	private static final String HTMLTEMPLATE = "<!DOCTYPE html><html lang'de'> <head><meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>PersonRepo</title></head><body>size: %d </body></html>";

	private PersonService personService;

	@Autowired
	public PersonHtmlController(PersonService personService) {
		super();
		this.personService = personService;
		System.out.println("PersonController initialized: " + this.toString());
		System.out.println("PersonService: " + personService.toString());
	}

	@GetMapping("/home")
	public String home(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);

		return "home";
	}

	// URL:"http://localhost:8080/count"
	@GetMapping("/count")
	public String getSize() {

		String string = "count";

		return string;
	}

	@GetMapping("/size")
	public String getSize(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("size", personService.getSize());

		return "home";
	}

	@GetMapping("/personen")
	public String getpersonen(Model model) {
		Personen personen = personService.getAllPersons();
		model.addAttribute("personenList", personen);
		return "personen";
	}

}
