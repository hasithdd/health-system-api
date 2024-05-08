package com.example.dao;

import com.example.model.Patient;
import com.example.model.Prescription;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO {
    
    private static List<Prescription> prescriptions = new ArrayList<>();
    
    static{
        List<Patient> allPatients = PatientDAO.getAllPatients();
        
        prescriptions.add(new Prescription(1,allPatients.get(0),"Medication 1","5mg","After eat","6hours"));
        prescriptions.add(new Prescription(2,allPatients.get(1),"Medication 2","10mg","Before eat","8hours"));
    }
    public List<Prescription> getAllPrescriptions(){
        return prescriptions;
    }
    
    public Prescription getPrescriptionByID(int prescriptionId){
        for (Prescription prescription : prescriptions){
            if (prescription.getId() == prescriptionId){
                return prescription;
            }
        }
        return null;
    }
    public void addAppointment(Prescription prescription){
        int newUserId = getNextUserId();
        prescription.setId(newUserId);
        prescriptions.add(prescription);
    }
    
    public void updatePrescription(Prescription updatedPrescription){
        for (int i=0 ; i < prescriptions.size();i++){
            Prescription prescription = prescriptions.get(i);
            if(prescription.getId() == updatedPrescription.getId()){
                prescriptions.set(i,updatedPrescription);
                System.out.println("Prescription updated: " + updatedPrescription);
                return;
            }
        }
    }
    public void deletePrescription(int prescriptionId) {
        prescriptions.removeIf(prescription -> prescription.getId() == prescriptionId);
    }
    public int getNextUserId(){
        int maxUserId = Integer.MIN_VALUE;
        
        for (Prescription prescription : prescriptions){
            int userId = prescription.getId();
            if (userId > maxUserId){
                maxUserId = userId;
            }
        }
        return maxUserId +1;
    }
    
}
