package demo.vikram.springrest.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import demo.vikram.springrest.domain.Person;

@Repository("personDAO")
public class PersonDAOImpl implements PersonDAO{

	private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);
	
	Map<Integer, Person> tempDataMap = new LinkedHashMap<Integer, Person>();
	{
		tempDataMap.put(1, new Person(1, "Micheal Schofield", 45));
		tempDataMap.put(2, new Person(2, "Bruce Wayne", 46));
		tempDataMap.put(3, new Person(3, "Samwise Gamgee", 30));
		tempDataMap.put(4, new Person(4, "Maximum Desmus Meradius", 40));
		tempDataMap.put(5, new Person(5, "Vikram Bindal", 30));
	}
	
	@Override
	public List<Person> findAllPersons() throws Exception {
		
		logger.debug("findAllPersons()");
		List<Person> personCollection = new ArrayList<Person>();
		Set<Entry<Integer, Person>> entrySet = tempDataMap.entrySet();
		for (Entry<Integer, Person> entry : entrySet) {
			personCollection.add(entry.getValue());
		}
		return personCollection;
	}

	@Override
	public Person findPersonById(int id) throws Exception {
		
		logger.debug("findPersonById()");
		
		Person p = null;
		if(tempDataMap.containsKey(id)){
			p = tempDataMap.get(id);
		}
		return p;
	}
}
