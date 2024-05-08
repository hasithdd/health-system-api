package com.example.resource;

import com.example.dao.BillingDAO;
import com.example.model.Billing;
import com.example.exception.ResourceNotFoundException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/billings")
public class BillingResource {
    private BillingDAO billingDAO = new BillingDAO();
    private static final Logger LOGGER = Logger.getLogger(BillingResource.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getAllBillings() {
        LOGGER.log(Level.INFO,"Getting all Billings");
        return billingDAO.getAllBillings();
    }

    @GET
    @Path("/{billingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBillingById(@PathParam("billingId") int billingId) {
        
        LOGGER.log(Level.INFO,"Getting Billing by billingId");
        Billing billing = billingDAO.getBillingByID(billingId);
        if(billing != null){
            return billing;
        }else{
            throw new ResourceNotFoundException("Billing " +billingId + " not found.");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBilling(Billing billing) {
        LOGGER.log(Level.INFO,"Posting a billing");
        billingDAO.addBilling(billing);
    }

    @PUT
    @Path("/{billingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBilling(@PathParam("billingId") int billingId, Billing updatedBilling) {
        
        LOGGER.log(Level.INFO,"Updating a billing");
        Billing existingBilling = billingDAO.getBillingByID(billingId);
        if (existingBilling != null) {
            updatedBilling.setId(billingId);
            billingDAO.updateBilling(updatedBilling);
        }else{
            throw new ResourceNotFoundException("Billing " +billingId + " not found.");
        }
    }

    @DELETE
    @Path("/{billingId}")
    public void deleteBilling(@PathParam("billingId") int billingId) {
        LOGGER.log(Level.INFO,"Deleting a billing");
        billingDAO.deleteBilling(billingId);
    }
}
