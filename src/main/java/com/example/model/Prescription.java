package com.example.model;

public class Prescription {
    private int prescriptionId;
    private Patient patient;
    private String medication;
    private String dosage;
    private String instructions;
    private String duration;
    
    public Prescription() {
    }
    
    public Prescription(int prescriptionId, Patient patient, String medication, String dosage, String instructions, String duration) {
        this.prescriptionId = prescriptionId;
        this.patient = patient;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
    }

    public int getId() {
        return prescriptionId;
    }

    public void setId(int id) {
        this.prescriptionId = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
