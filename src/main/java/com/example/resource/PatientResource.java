package com.example.resource;

import com.example.model.Patient;
import com.example.dao.PatientDAO;
import com.example.exception.ResourceNotFoundException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.ws.rs.*;
import java.util.List;
import javax.ws.rs.core.MediaType;

@Path("/patients")
public class PatientResource {
    private PatientDAO patientDAO = new PatientDAO();
    private static final Logger LOGGER = Logger.getLogger(PatientResource.class.getName());
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients() {
        LOGGER.log(Level.INFO,"Getting all patients");
        return patientDAO.getAllPatients();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientById(@PathParam("id") int id) {
        Patient patient = patientDAO.getPatientById(id);
        if (patient != null){
            return patient;
        }else{
            throw new ResourceNotFoundException("Patient " +id + " not found.");
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPatient(Patient patient) {
        LOGGER.log(Level.INFO,"Posting all patients");
        patientDAO.addPatient(patient);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePatient(@PathParam("id") int id, Patient updatedPatient) {
        LOGGER.log(Level.INFO,"Updating patient by id");
        Patient existingPatient = patientDAO.getPatientById(id);
        if (existingPatient != null) {
            updatedPatient.setId(id);
            patientDAO.updatePatient(updatedPatient);
        }else{
            throw new ResourceNotFoundException("Patient " +id + " not found");
        }
    }
    
    @DELETE
    @Path("/{id}")
    public void deletePatient(@PathParam("id") int id) {
        LOGGER.log(Level.INFO,"Deleting patient by id");
        patientDAO.deletePatient(id);
    }
}
