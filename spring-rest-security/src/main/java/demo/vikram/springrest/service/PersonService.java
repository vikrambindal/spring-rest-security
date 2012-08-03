package demo.vikram.springrest.service;

import java.util.List;

import demo.vikram.springrest.domain.Person;

public interface PersonService {
	
	public List<Person> findAllPersons() throws Exception;
	
	public Person findPersonById(int id) throws Exception;

}
