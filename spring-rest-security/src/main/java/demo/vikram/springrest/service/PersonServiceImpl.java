package demo.vikram.springrest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.vikram.springrest.dao.PersonDAO;
import demo.vikram.springrest.domain.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService{

	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	private PersonDAO personDAO;
	
	@Override
	public List<Person> findAllPersons() throws Exception {
		logger.debug("findAllPersons() ");
		return personDAO.findAllPersons();
	}

	@Override
	public Person findPersonById(int id) throws Exception {
		logger.debug("findPersonById() ");
		return personDAO.findPersonById(id);
	}
	
}
