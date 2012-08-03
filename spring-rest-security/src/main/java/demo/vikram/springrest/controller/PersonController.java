package demo.vikram.springrest.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.vikram.springrest.domain.Person;
import demo.vikram.springrest.domain.PersonList;
import demo.vikram.springrest.service.PersonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/service/persons", method = RequestMethod.GET )
	public @ResponseBody PersonList findAllPersons() throws Exception {
		logger.debug("findAllPersons() ");
		List<Person> persons = personService.findAllPersons();
		PersonList personList = new PersonList();
		personList.setPerson(persons);
		return personList;
	}

	@RequestMapping(value = "/service/person/{id}", method = RequestMethod.GET )
	public @ResponseBody Person findPersonById(@PathVariable int id) throws Exception {
		logger.debug("findPersonById() ");
		return personService.findPersonById(id);
	}
}
