package com.example.dao;

import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.Patient;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppointmentDAO {
    private static List<Appointment> appointments = new ArrayList<>();
    
    static {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        
        String formattedDate = date.format(dateFormatter);
        String formattedTime = time.format(timeFormatter);
        
        List<Patient> allPatients = PatientDAO.getAllPatients();
        List<Doctor> allDoctors = DoctorDAO.getAllDoctors();
        
        appointments.add(new Appointment(1,formattedDate,formattedTime,allPatients.get(0),allDoctors.get(0)));
        appointments.add(new Appointment(2,formattedDate,formattedTime,allPatients.get(1),allDoctors.get(1)));
              
    }
    public List<Appointment> getAllAppointments(){
        return appointments;
    }
    
    public Appointment getAppointmentByID(int appointmentId){
        for (Appointment appointment : appointments){
            if (appointment.getId() == appointmentId){
                return appointment;
            }
        }
        return null;
    }
    public void addAppointment(Appointment appointment){
        int newUserId = getNextUserId();
        appointment.setId(newUserId);
        appointments.add(appointment);
    }
    
    public void updateAppointment(Appointment updatedAppointment){
        for (int i=0 ; i < appointments.size();i++){
            Appointment appointment = appointments.get(i);
            if(appointment.getId() == updatedAppointment.getId()){
                appointments.set(i,updatedAppointment);
                System.out.println("Appointment updated: " + updatedAppointment);
                return;
            }
        }
    }
    public void deleteAppointment(int appointmentId) {
        appointments.removeIf(appointment -> appointment.getId() == appointmentId);
    }
    public int getNextUserId(){
        int maxUserId = Integer.MIN_VALUE;
        
        for (Appointment appointment : appointments){
            int userId = appointment.getId();
            if (userId > maxUserId){
                maxUserId = userId;
            }
        }
        return maxUserId +1;
    }
}
