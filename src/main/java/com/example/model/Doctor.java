package com.example.model;

public class Doctor extends Person {
    private String specialization;
    private int doctorId;
    
    public Doctor(){}
    
    public Doctor(int id,int doctorId,String name,String contactInformation,String address,String specialization){
        super(id,name,contactInformation,address);
        this.specialization = specialization;
        this.doctorId=doctorId;
    }
    public int getDoctorId(){
        return doctorId;
    }
    public void setDoctorId(int doctorId){
        this.doctorId=doctorId;
    }    
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
