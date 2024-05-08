package com.example.dao;

import com.example.model.Billing;
import com.example.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {
    
    private static List<Billing> billings = new ArrayList<>();
    
    static{
        List<Patient> allPatients = PatientDAO.getAllPatients();
        
        billings.add(new Billing(1,allPatients.get(0),50.0,"0001","Done"));
        billings.add(new Billing(2,allPatients.get(0),60.00,"0002","DOne"));
        
    }
    public List<Billing> getAllBillings(){
        return billings;
    }
    
    public Billing getBillingByID(int billingId){
        for (Billing billing : billings){
            if (billing.getId() == billingId){
                return billing;
            }
        }
        return null;
    }
    public void addBilling(Billing billing){
        int newUserId = getNextUserId();
        billing.setId(newUserId);
        billings.add(billing);
    }
    
    public void updateBilling(Billing updatedBilling){
        for (int i=0 ; i < billings.size();i++){
            Billing billing = billings.get(i);
            if(billing.getId() == updatedBilling.getId()){
                billings.set(i,updatedBilling);
                System.out.println("Billing updated: " + updatedBilling);
                return;
            }
        }
    }
    public void deleteBilling(int billingId) {
        billings.removeIf(billing -> billing.getId() == billingId);
    }
    public int getNextUserId(){
        int maxUserId = Integer.MIN_VALUE;
        
        for (Billing billing : billings){
            int userId = billing.getId();
            if (userId > maxUserId){
                maxUserId = userId;
            }
        }
        return maxUserId +1;
    }
    
}
