package de.telekom.sea3.webserver.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long>{

//	@Query(value="SELECT * from personen",nativeQuery=true )
//	Iterable<Person> selectPersonen();
	@Query(value="SELECT * from personen where location=:location",nativeQuery=true )
	Iterable<Person> selectPersonen(@Param("location") String location);
}
