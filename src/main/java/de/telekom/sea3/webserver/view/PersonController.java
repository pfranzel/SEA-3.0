package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonController {

	private static final String HTMLTEMPLATE = "<!DOCTYPE html><html lang'de'> <head><meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>getSize</title></head><body>size: %d </body></html>";

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
		System.out.println("PersonController initialized: " + this.toString());
		System.out.println("PersonService: " + personService.toString());
	}

	// URL:"http://localhost:8080/size"
	@GetMapping("/size")
	@ResponseBody
	public String getSize() {
		String string1 = Integer.toString(personService.getSize());
		String string2 = String.valueOf(personService.getSize());
		String string3 = "" + personService.getSize();
		String string4 = String.format(HTMLTEMPLATE, personService.getSize());

		return string4;
	}
}
