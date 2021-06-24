package de.telekom.sea3.webserver.model;

import java.util.ArrayList;
import java.util.List;

public class Persons {

	private List<Person> personen = new ArrayList<Person>();

	public Persons(Iterable<Person> iterable) {
		this.personen = (List<Person>) iterable;
	}

	public List<Person> getPersonen() {
		return personen;
	}

	public void setPersonen(List<Person> personen) {
		this.personen = personen;
	}
}
