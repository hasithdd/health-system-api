package com.example.resource;

import com.example.dao.DoctorDAO;
import com.example.model.Doctor;
import com.example.exception.ResourceNotFoundException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/doctors")
public class DoctorResource {
    private DoctorDAO doctorDAO = new DoctorDAO();
    private static final Logger LOGGER = Logger.getLogger(DoctorResource.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getAllDoctors() {
        LOGGER.log(Level.INFO,"Getting all DOctors");
        return doctorDAO.getAllDoctors();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorById(@PathParam("id") int id) {
        
        LOGGER.log(Level.INFO,"Getting a doctor by id.");
        Doctor doctor =doctorDAO.getDoctorById(id);
        if(doctor != null){
            return doctor;
        }else{
            throw new ResourceNotFoundException("Doctor " + id + " not found.");
        }
        
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDoctor(Doctor doctor) {
        LOGGER.log(Level.INFO,"Posting a doctor.");
        doctorDAO.addDoctor(doctor);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDoctor(@PathParam("id") int id, Doctor updatedDoctor) {
        
        LOGGER.log(Level.INFO,"Updating a doctor.");
        Doctor existingDoctor = doctorDAO.getDoctorById(id);
        if (existingDoctor != null) {
            updatedDoctor.setId(id);
            doctorDAO.updateDoctor(updatedDoctor);
        }else{
            throw new ResourceNotFoundException("Doctor " +id + " not updated.");
        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteDoctor(@PathParam("id") int id) {
        LOGGER.log(Level.INFO,"Updating a doctor.");
        doctorDAO.deleteDoctor(id);
    }
}
