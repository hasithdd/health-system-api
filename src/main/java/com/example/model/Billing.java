package com.example.model;

public class Billing {
    private int billingId;
    private Patient patient;
    private double amount;
    private String invoiceNumber;
    private String paymentStatus;

    public Billing() {
    }

    public Billing(int billingId, Patient patient, double amount, String invoiceNumber, String paymentStatus) {
        this.billingId = billingId;
        this.patient = patient;
        this.amount = amount;
        this.invoiceNumber = invoiceNumber;
        this.paymentStatus = paymentStatus;
    }
    public int getId() {
        return billingId;
    }

    public void setId(int id) {
        this.billingId = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
