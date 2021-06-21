package de.telekom.sea3.webserver.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.Person;

@Repository
public class PersonRepository {

	private List<Person> personen = new ArrayList<Person>();

	public PersonRepository() {
		super();
		System.out.println("PersonRepository instanziert: " + this.toString());

	}

	public int getSize() {
		return personen.size();
	}

	public int getMaxId() {
		Person person = get(personen.size());
			if (person.getId() >= 0) {
				return person.getId();
			}
			else {
				return 0;
			}
		}

	public boolean add(Person person) {
//		personen.add(getMaxId(), person);
		personen.add(person);
//		return personen.add(person);
		return true;
	}

	public boolean delete(int id) {
		try {
			if (personen.get(id) != null) {
				personen.remove(id);
				return true;
			} else {
				throw new IndexOutOfBoundsException("ID does not exist in the list");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Person get(int id) {
		return personen.get(id);
	}

	public List<Person> getAll() {
		return personen;
	}

	public boolean clear() {
		personen.clear();
		return true;
	}
}