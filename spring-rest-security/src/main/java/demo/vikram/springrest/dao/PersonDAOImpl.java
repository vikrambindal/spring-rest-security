package demo.vikram.springrest.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("personDAO")
public class PersonDAOImpl implements PersonDAO{

	private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);
}
