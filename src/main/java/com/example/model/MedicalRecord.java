package com.example.model;

public class MedicalRecord {
    private int medicalRecordId;
    private Patient patient;
    private String diagnosis;
    private String treatment;
    private String otherInformation;
    
    public MedicalRecord(){}
    
    public MedicalRecord(int medicalRecordId,Patient patient,String diagnosis,String treatment,String otherInformation){
        this.medicalRecordId=medicalRecordId;
        this.patient=patient;
        this.diagnosis=diagnosis;
        this.treatment=treatment;
        this.otherInformation=otherInformation;
    }

    public int getId() {
        return medicalRecordId;
    }

    public void setId(int id) {
        this.medicalRecordId = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
}
