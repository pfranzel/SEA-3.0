package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonRestController {


	private PersonService personService;

	@Autowired
	public PersonRestController(PersonService personService) {
		super();
		this.personService = personService;
	}


	/** URL: <a href="http://localhost:8080/json/persons/all">the url...</a>
	 * 
	 * @return
	 */
	// URL:"http://localhost:8080/json/allpersons"
	@GetMapping("/json/allpersons")
	@ResponseBody
	public String getAllPersons() {
		Personen personen = personService.getAllPersons();
//		System.out.println(personen.toJson(personen));
		
		String string = "{\n"
				+ "	\"personen\": [\n"
				+ "		{\n"
				+ "			\"firstname\": \"Jan\",\n"
				+ "			\"lastname\": \"Krüger\",\n"
				+ "			\"salutation\": \"Mr.\"\n"
				+ "		},\n"
				+ "		{\n"
				+ "			\"firstname\": \"Kurt\",\n"
				+ "			\"lastname\": \"Feller\",\n"
				+ "			\"salutation\": \"Mr.\"\n"
				+ "		},\n"
				+ "		{\n"
				+ "			\"firstname\": \"Sandra\",\n"
				+ "			\"lastname\": \"Bert\",\n"
				+ "			\"salutation\": \"Mrs.\"\n"
				+ "		}\n"
				+ "	]\n"
				+ "}";

		return string;
	}
	/** URL: <a href="http://localhost:8080/json/persons/all">the url...</a>
	 * 
	 * @return
	 */
	// URL:"http://localhost:8080/json/persons/size"
	@GetMapping("/json/persons/size")
	@ResponseBody
	public String getSize() {
		int size = personService.getSize();
//		System.out.println(personen.toJson(personen));
		
		String stringNr = String.format("{\n"
				+ "	\"size\": %d\n"
				+ "}",size);

		return stringNr;
	}
}
