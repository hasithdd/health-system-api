package com.example.resource;

import com.example.dao.PrescriptionDAO;
import com.example.model.Prescription;
import com.example.exception.ResourceNotFoundException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/prescriptions")
public class PrescriptionResource {
    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    private static final Logger LOGGER = Logger.getLogger(PrescriptionResource.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getAllPrescriptions() {
        LOGGER.log(Level.INFO,"Getting all prescriptions");
        return prescriptionDAO.getAllPrescriptions();
    }

    @GET
    @Path("/{prescriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getPrescriptionById(@PathParam("prescriptionId") int prescriptionId) {
        LOGGER.log(Level.INFO,"Getting prescription by prescriptionId");
        Prescription prescription =  prescriptionDAO.getPrescriptionByID(prescriptionId);
        if (prescription != null){
            return prescription;
        }else{
            throw new ResourceNotFoundException("prescription " +prescriptionId + " not found");
        }       
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPrescription(Prescription prescription) {
        LOGGER.log(Level.INFO,"Posting a prescription");
        prescriptionDAO.addAppointment(prescription);
    }

    @PUT
    @Path("/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePrescription(@PathParam("prescriptionId") int prescriptionId, Prescription updatedPrescription) {
        LOGGER.log(Level.INFO,"Updating prescription by prescriptionId");
        Prescription existingPrescription = prescriptionDAO.getPrescriptionByID(prescriptionId);
        if (existingPrescription != null) {
            updatedPrescription.setId(prescriptionId);
            prescriptionDAO.updatePrescription(updatedPrescription);
        }else{
            throw new ResourceNotFoundException("Prescription " +prescriptionId + " not found");
        }
    }

    @DELETE
    @Path("/{prescriptionId}")
    public void deletePrescription(@PathParam("prescriptionId") int prescriptionId) {
        LOGGER.log(Level.INFO,"Deleting prescription by prescriptionId");
        prescriptionDAO.deletePrescription(prescriptionId);
    }
}
