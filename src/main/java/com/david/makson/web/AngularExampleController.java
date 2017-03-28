package com.david.makson.web;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
@RequestMapping(value = "/api/person")
public class AngularExampleController {

    public final static Logger LOG = LoggerFactory.getLogger(AngularExampleController.class);

    @Inject
    PersonService personService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonDTO>> findAllPerson(Pageable pageable, HttpServletRequest req) {
        List<PersonDTO> page = personService.findPersons(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id, HttpServletRequest req) {
        PersonDTO person = personService.getPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createPerson(@RequestBody PersonDTO personDTO) {
        personService.savePerson(personDTO);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updatePerson(@RequestBody PersonDTO personDTO) {
        personService.updatePerson(personDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }


class PersonDTO extends AbstractDTO {

    String firstname;

    String lastname;

    Integer age;

    Date dateOfBirth;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
 class AbstractDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
  interface PersonService {

	  List<PersonDTO> findPersons(Pageable pageable);

	    PersonDTO getPerson(Long id);

	    void updatePerson(PersonDTO personDTO);

	    void savePerson(PersonDTO personDTO);

	    void deletePerson(Long id);

	}
}
