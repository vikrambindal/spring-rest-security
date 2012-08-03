package demo.vikram.springrest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonServiceImpl implements PersonService{

	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
}
