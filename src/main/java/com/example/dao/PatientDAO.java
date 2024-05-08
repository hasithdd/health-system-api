package com.example.dao;

import com.example.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private static List<Patient> patients = new ArrayList<>();
    
    static {
        patients.add(new Patient(3,"Sunil","0713333333","3,Galle Road,Colombo","Had a cancer","Bad"));
        patients.add(new Patient(4,"Anil","0714444444","4,Galle Road,Colombo","Heart Attack","Recovering"));
    }
    
    public static List<Patient> getAllPatients(){
        return patients;
    }
    
    public Patient getPatientById(int id){
        for (Patient patient : patients){
            if(patient.getId() == id){
                return patient;
            }
        }
        return null;
    }
    
    public void addPatient(Patient patient){
        int newUserId = getNextUserId();
        patient.setId(newUserId);
        patients.add(patient);
    }
    
    public void updatePatient(Patient updatedPatient){
        for(int i=0 ; i < patients.size() ; i++){
            Patient patient = patients.get(i);
            if(patient.getId() == updatedPatient.getId()) {
                patients.set(i,updatedPatient);
                System.out.println("Patient updated: " + updatedPatient);
                return;
            }
        }
    }
    
    public void deletePatient(int id){
        patients.removeIf(patient -> patient.getId() == id);
    }
    
    public int getNextUserId(){
        int maxUserId = Integer.MIN_VALUE;
        
        for (Patient patient : patients){
            int userId = patient.getId();
            if (userId > maxUserId){
                maxUserId = userId;
            }
        }
        return maxUserId +1;
    }
}

