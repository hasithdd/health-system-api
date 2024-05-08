package com.example.resource;

import com.example.dao.AppointmentDAO;
import com.example.model.Appointment;
import com.example.exception.ResourceNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

@Path("/appointments")
public class AppointmentResource {
    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    private static final Logger LOGGER = Logger.getLogger(AppointmentResource.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointments() {
        LOGGER.log(Level.INFO,"Getting all Appointments");
        return appointmentDAO.getAllAppointments();           
    }

    @GET
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("appointmentId") int appointmentId) {
        
        LOGGER.log(Level.INFO,"Getting appointment by appointmentId");
        Appointment appointment =  appointmentDAO.getAppointmentByID(appointmentId);
        if (appointment != null){
            return appointment;
        }else{
            throw new ResourceNotFoundException("Appointment " +appointmentId + "not ");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAppointment(Appointment appointment) {
        LOGGER.log(Level.INFO,"Posting appointment by appointmentId");
        appointmentDAO.addAppointment(appointment);
    }

    @PUT
    @Path("/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAppointment(@PathParam("appointmentId") int appointmentId, Appointment updatedAppointment) {
        
        LOGGER.log(Level.INFO,"Updating appointment by appointmentId");
        Appointment existingAppointment = appointmentDAO.getAppointmentByID(appointmentId);
        if (existingAppointment != null) {
            updatedAppointment.setId(appointmentId);
            appointmentDAO.updateAppointment(updatedAppointment);
        }else{
            throw new ResourceNotFoundException("Appointment with ID" + appointmentId + " not found.");
        }
    }

    @DELETE
    @Path("/{appointmentId}")
    public void deleteAppointment(@PathParam("appointmentId") int appointmentId) {
        LOGGER.log(Level.INFO,"Deleting appointment by appointmentId");
        appointmentDAO.deleteAppointment(appointmentId);
    }
}
