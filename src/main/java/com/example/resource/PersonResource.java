package com.example.resource;

import com.example.model.Person;
import com.example.model.Doctor;
import com.example.model.Patient;
import com.example.dao.PersonDAO;
import com.example.dao.DoctorDAO;
import com.example.dao.PatientDAO;
import com.example.exception.ResourceNotFoundException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.ArrayList;

@Path("/persons")
public class PersonResource {
    private PersonDAO personDAO = new PersonDAO();
    private DoctorDAO doctorDAO = new DoctorDAO();
    private PatientDAO patientDAO = new PatientDAO();
    private static final Logger LOGGER = Logger.getLogger(Person.class.getName());
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons(){
        LOGGER.log(Level.INFO,"Getting all persons");
        List<Person> allPersons = new ArrayList<>();
        allPersons.addAll(personDAO.getAllPersons());
        allPersons.addAll(doctorDAO.getAllDoctors());
        allPersons.addAll(patientDAO.getAllPatients());
        return allPersons;
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("id")int id){
        LOGGER.log(Level.INFO,"Getting person by id");
        Person person =  personDAO.getPersonById(id);
        if(person != null){
            return person;
        }else {
            throw new ResourceNotFoundException("Person " +id + " not found");
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(Person person){
        LOGGER.log(Level.INFO,"Posting person");
        personDAO.addPerson(person);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("id")int id,Person updatedPerson){
        LOGGER.log(Level.INFO,"Updating person by id");
        Person excistingPerson = personDAO.getPersonById(id);
        if(excistingPerson != null){
            updatedPerson.setId(id);
            personDAO.updatePerson(updatedPerson);
        }else{
            throw new ResourceNotFoundException("Person " +id + " not found");
        }
    }
    
    @DELETE
    @Path("/id")
    public void deletePerson(@PathParam("id")int id){
        LOGGER.log(Level.INFO,"Deleting person by id");
        personDAO.deletePerson(id);
    }
}
