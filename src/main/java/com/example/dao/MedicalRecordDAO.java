package com.example.dao;

import com.example.model.MedicalRecord;
import com.example.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDAO {
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    
    static{
        List<Patient> allPatients = PatientDAO.getAllPatients();
        
        medicalRecords.add(new MedicalRecord(1,allPatients.get(0),"Heart Attack","Pills","Not in Danger"));
        medicalRecords.add(new MedicalRecord(2,allPatients.get(1),"Brain Attack","Therapy","In Danger"));
        
    }
    public List<MedicalRecord> getAllMedicalRecords(){
        return medicalRecords;
    }
    
    public MedicalRecord getMedicalRecordByID(int medicalRecordId){
        for (MedicalRecord medicalRecord : medicalRecords){
            if (medicalRecord.getId() == medicalRecordId){
                return medicalRecord;
            }
        }
        return null;
    }
    public void addMedicalRecord(MedicalRecord medicalRecord){
        int newUserId = getNextUserId();
        medicalRecord.setId(newUserId);
        medicalRecords.add(medicalRecord);
    }
    
    public void updateMedicalRecord(MedicalRecord updatedMedicalRecord){
        for (int i=0 ; i < medicalRecords.size();i++){
            MedicalRecord medicalRecord = medicalRecords.get(i);
            if(medicalRecord.getId() == updatedMedicalRecord.getId()){
                medicalRecords.set(i,updatedMedicalRecord);
                System.out.println("MedicalRecord updated: " + updatedMedicalRecord);
                return;
            }
        }
    }
    public int getNextUserId(){
        int maxUserId = Integer.MIN_VALUE;
        
        for (MedicalRecord medicalRecord : medicalRecords){
            int userId = medicalRecord.getId();
            if (userId > maxUserId){
                maxUserId = userId;
            }
        }
        return maxUserId +1;
    }
}
