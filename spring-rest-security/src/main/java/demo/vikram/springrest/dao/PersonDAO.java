package demo.vikram.springrest.dao;

import java.util.List;

import demo.vikram.springrest.domain.Person;

public interface PersonDAO {

	public List<Person> findAllPersons() throws Exception;

	public Person findPersonById(int id) throws Exception;

}
