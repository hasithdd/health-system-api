package com.example.resource;

import com.example.dao.MedicalRecordDAO;
import com.example.model.MedicalRecord;
import com.example.exception.ResourceNotFoundException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/medicalRecords")
public class MedicalRecordResource {
    private MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();
    private static final Logger LOGGER = Logger.getLogger(MedicalRecordResource.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> getAllMedicalRecords() {
        LOGGER.log(Level.INFO,"Getting all Medical Records.");
        return medicalRecordDAO.getAllMedicalRecords();
    }

    @GET
    @Path("/{medicalRecordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalRecordById(@PathParam("medicalRecordId") int medicalRecordId) {
        LOGGER.log(Level.INFO,"Getting a medical report by medicalReportId");
        MedicalRecord medicalRecord =  medicalRecordDAO.getMedicalRecordByID(medicalRecordId);
        if(medicalRecord != null){
            return medicalRecord;
        }else{
            throw new ResourceNotFoundException("MedicalRecord " +medicalRecordId + " not found.");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        LOGGER.log(Level.INFO,"Adding a medical reord.");
        medicalRecordDAO.addMedicalRecord(medicalRecord);
    }

    @PUT
    @Path("/{medicalRecordId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateMedicalRecord(@PathParam("medicalRecordId") int medicalRecordId, MedicalRecord updatedMedicalRecord) {
        LOGGER.log(Level.INFO,"PUpdating a medical record");
        MedicalRecord existingMedicalRecord = medicalRecordDAO.getMedicalRecordByID(medicalRecordId);
        if (existingMedicalRecord != null) {
            updatedMedicalRecord.setId(medicalRecordId);
            medicalRecordDAO.updateMedicalRecord(updatedMedicalRecord);
        }else{
            throw new ResourceNotFoundException("MedicalRecord " +medicalRecordId + " not found.");
        }
    }
}
