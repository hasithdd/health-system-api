package com.example.model;


public class Appointment {
    private int appointmentId;
    private String date;
    private String time;
    private Patient patient;
    private Doctor doctor;
    
    public Appointment(){}
    
    public Appointment(int appointmentId,String date,String time,Patient patient,Doctor doctor){
        this.appointmentId=appointmentId;
        this.date=date;
        this.time=time;
        this.patient=patient;
        this.doctor=doctor;
    }

    public int getId() {
        return appointmentId;
    }

    public void setId(int id) {
        this.appointmentId = appointmentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
