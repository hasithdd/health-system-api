package com.example.dao;

import com.example.model.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private static List<Doctor> doctors = new ArrayList<>();
    
    static {
        doctors.add(new Doctor(5,1,"Ranil","0715555555","5,Galle Road,Colombo","Neuro"));
        doctors.add(new Doctor(6,2,"Ruwan","0716666666","6,Galle Road,Colombo","Child"));
    }
    
    public static List<Doctor> getAllDoctors(){
        return doctors;
    }
    
    public Doctor getDoctorById(int doctorId){
        for (Doctor doctor : doctors){
            if(doctor.getId() == doctorId){
                return doctor;
            }
        }
        return null;
    }
    
    public void addDoctor(Doctor doctor){
        int newUserId = getNextUserId();
        doctor.setDoctorId(newUserId);
        doctors.add(doctor);
    }
    
    public void updateDoctor(Doctor updatedDoctor){
        for(int i=0 ; i < doctors.size() ; i++){
            Doctor doctor = doctors.get(i);
            if(doctor.getDoctorId() == updatedDoctor.getDoctorId()) {
                doctors.set(i,updatedDoctor);
                System.out.println("Doctor updated: " + updatedDoctor);
                return;
            }
        }
    }
    
    public void deleteDoctor(int doctorId){
        doctors.removeIf(doctor -> doctor.getDoctorId() == doctorId);
    }
    
    public int getNextUserId(){
        int maxUserId = Integer.MIN_VALUE;
        
        for (Doctor doctor : doctors){
            int userId = doctor.getDoctorId();
            if (userId > maxUserId){
                maxUserId = userId;
            }
        }
        return maxUserId +1;
    }
}

