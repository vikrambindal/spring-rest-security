package demo.vikram.springrest.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="persons")
public class PersonList {

	private List<Person> person;

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
	
	
}
