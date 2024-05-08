API Documentation: Healthcare
Management System
Introduction
The Healthcare Management System API provides endpoints for managing
various aspects of a healthcare system, including appointments, patients,
doctors, billing, medical records, and prescriptions. This document serves as a
comprehensive guide to understand and use the API effectively.
Prerequisites
Before getting started, ensure you have the following software installed on your
system:
1. NetBeans IDE
2. JDK 19
3. Apache Tomcat
4. Postman
Installation Instructions
1. Install NetBeans IDE
• Download the NetBeans IDE installer from the official website.
• Follow the installation instructions provided on the website.
2. Install JDK 19
• Download the JDK 19 installer from the Oracle website.
• Follow the installation instructions provided on the website.
3. Install Apache Tomcat
• Download the latest version of Apache Tomcat from the official website.
• Extract the downloaded ZIP file to your preferred location.
4. Install Postman
• Download and install Postman from the official website.
• Follow the installation instructions provided on the website.
Project Setup
1. Extract Project
• Download the project source code as a ZIP archive and extract it to your desired
location.
2. Open the Project in NetBeans
• Launch NetBeans IDE.
• Click on File > Open Project.
• Navigate to the directory where you cloned or extracted the project and select it.
3. Configure Apache Tomcat Server
• In NetBeans, right-click on the project in the Projects window.
• Select Properties.
• Go to the Run category.
• Choose Apache Tomcat as the server.
• Browse and select the location where Apache Tomcat is installed.
Building and Running the Application
1. Clean and Build the Project
• Right-click on the project in the Projects window.
• Select Clean and Build.
2. Deploy the Project to Apache Tomcat
• Right-click on the project in the Projects window.
• Select Run.
Testing with Postman
1. Import API Documentation
• Open Postman.
• Copy local host address from browser and paste into Postman workspace like this
../rest/{endpoint}/.
2. Test Endpoints
• Test GET, POST, PUT, DELETE methods.
Authentication
Authentication is not required to access the API endpoints at the moment.
Error Handling
The API follows RESTful principles for error handling. Errors are returned with
appropriate HTTP status codes and error messages in the response body. The
error messages are informative and provide details about the encountered issue.
Common HTTP Status Codes
• 200 OK: The request was successful.
• 400 Bad Request: The request was malformed or invalid.
• 404 Not Found: The requested resource was not found.
• 500 Internal Server Error: An unexpected error occurred on the server.
Endpoints
1. Appointments
GET /appointments
• Description: Get all appointments.
• Response: Returns a list of all appointments in JSON format.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 500 Internal Server Error: If an unexpected error occurs.
GET /appointments/{appointmentId}
• Description: Get an appointment by ID.
• Parameters:
o appointmentId (path parameter): The ID of the appointment to retrieve.
• Response: Returns the appointment details in JSON format if found.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 404 Not Found: If the appointment with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
POST /appointments
• Description: Add a new appointment.
• Request Body: JSON object representing the new appointment.
• HTTP Status Codes:
o 201 Created: If the appointment is successfully created.
o 400 Bad Request: If the request body is invalid.
o 500 Internal Server Error: If an unexpected error occurs.
PUT /appointments/{appointmentId}
• Description: Update an existing appointment.
• Parameters:
o appointmentId (path parameter): The ID of the appointment to update.
• Request Body: JSON object representing the updated appointment.
• HTTP Status Codes:
o 204 No Content: If the appointment is successfully updated.
o 404 Not Found: If the appointment with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
DELETE /appointments/{appointmentId}
• Description: Delete an appointment.
• Parameters:
o appointmentId (path parameter): The ID of the appointment to delete.
• HTTP Status Codes:
o 204 No Content: If the appointment is successfully deleted.
o 404 Not Found: If the appointment with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
2. Patients
GET /patients
• Description: Get all patients.
• Response: Returns a list of all patients in JSON format.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 500 Internal Server Error: If an unexpected error occurs.
GET /patients/{id}
• Description: Get a patient by ID.
• Parameters:
o id (path parameter): The ID of the patient to retrieve.
• Response: Returns the patient details in JSON format if found.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 404 Not Found: If the patient with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
POST /patients
• Description: Add a new patient.
• Request Body: JSON object representing the new patient.
• HTTP Status Codes:
o 201 Created: If the patient is successfully created.
o 400 Bad Request: If the request body is invalid.
o 500 Internal Server Error: If an unexpected error occurs.
PUT /patients/{id}
• Description: Update an existing patient.
• Parameters:
o id (path parameter): The ID of the patient to update.
• Request Body: JSON object representing the updated patient.
• HTTP Status Codes:
o 204 No Content: If the patient is successfully updated.
o 404 Not Found: If the patient with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
DELETE /patients/{id}
• Description: Delete a patient.
• Parameters:
o id (path parameter): The ID of the patient to delete.
• HTTP Status Codes:
o 204 No Content: If the patient is successfully deleted.
o 404 Not Found: If the patient with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
3. Doctors
GET /doctors
• Description: Get all doctors.
• Response: Returns a list of all doctors in JSON format.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 500 Internal Server Error: If an unexpected error occurs.
GET /doctors/{id}
• Description: Get a doctor by ID.
• Parameters:
o id (path parameter): The ID of the doctor to retrieve.
• Response: Returns the doctor details in JSON format if found.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 404 Not Found: If the doctor with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
POST /doctors
• Description: Add a new doctor.
• Request Body: JSON object representing the new doctor.
• HTTP Status Codes:
o 201 Created: If the doctor is successfully created.
o 400 Bad Request: If the request body is invalid.
o 500 Internal Server Error: If an unexpected error occurs.
PUT /doctors/{id}
• Description: Update an existing doctor.
• Parameters:
o id (path parameter): The ID of the doctor to update.
• Request Body: JSON object representing the updated doctor.
• HTTP Status Codes:
o 204 No Content: If the doctor is successfully updated.
o 404 Not Found: If the doctor with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
DELETE /doctors/{id}
• Description: Delete a doctor.
• Parameters:
o id (path parameter): The ID of the doctor to delete.
• HTTP Status Codes:
o 204 No Content: If the doctor is successfully deleted.
o 404 Not Found: If the doctor with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
4. Medical Records
GET /medicalRecords
• Description: Get all medical records.
• Response: Returns a list of all medical records in JSON format.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 500 Internal Server Error: If an unexpected error occurs.
GET /medicalRecords/{medicalRecordId}
• Description: Get a medical record by ID.
• Parameters:
o medicalRecordId (path parameter): The ID of the medical record to retrieve.
• Response: Returns the medical record details in JSON format if found.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 404 Not Found: If the medical record with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
POST /medicalRecords
• Description: Add a new medical record.
• Request Body: JSON object representing the new medical record.
• HTTP Status Codes:
o 201 Created: If the medical record is successfully created.
o 400 Bad Request: If the request body is invalid.
o 500 Internal Server Error: If an unexpected error occurs.
PUT /medicalRecords/{medicalRecordId}
• Description: Update an existing medical record.
• Parameters:
o medicalRecordId (path parameter): The ID of the medical record to update.
• Request Body: JSON object representing the updated medical record.
• HTTP Status Codes:
o 204 No Content: If the medical record is successfully updated.
o 404 Not Found: If the medical record with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
5. Prescriptions
GET /prescriptions
• Description: Retrieve all prescriptions.
• Response: Returns a list of prescriptions in JSON format.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 500 Internal Server Error: If an unexpected error occurs.
GET /prescriptions/{prescriptionId}
• Description: Get a prescription by ID.
• Parameters:
o prescriptionId (path parameter): The ID of the prescription to retrieve.
• Response: Returns the prescription details in JSON format if found.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 404 Not Found: If the prescription with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
POST /prescriptions
• Description: Create a new prescription.
• Request Body: JSON object representing the new prescription.
• HTTP Status Codes:
o 201 Created: If the prescription is successfully created.
o 400 Bad Request: If the request body is invalid.
o 500 Internal Server Error: If an unexpected error occurs.
PUT /prescriptions/{prescriptionId}
• Description: Update an existing prescription.
• Parameters:
o prescriptionId (path parameter): The ID of the prescription to update.
• Request Body: JSON object representing the updated prescription.
• HTTP Status Codes:
o 204 No Content: If the prescription is successfully updated.
o 404 Not Found: If the prescription with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
DELETE /prescriptions/{prescriptionId}
• Description: Delete a prescription.
• Parameters:
o prescriptionId (path parameter): The ID of the prescription to delete.
• HTTP Status Codes:
o 204 No Content: If the prescription is successfully deleted.
o 404 Not Found: If the prescription with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
6. Billings
GET /billings
• Description: Retrieve all billings.
• Response: Returns a list of billings in JSON format.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 500 Internal Server Error: If an unexpected error occurs.
GET /billings/{billingId}
• Description: Get a billing by ID.
• Parameters:
o billingId (path parameter): The ID of the billing to retrieve.
• Response: Returns the billing details in JSON format if found.
• HTTP Status Codes:
o 200 OK: Successful operation.
o 404 Not Found: If the billing with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
POST /billings
• Description: Create a new billing.
• Request Body: JSON object representing the new billing.
• HTTP Status Codes:
o 201 Created: If the billing is successfully created.
o 400 Bad Request: If the request body is invalid.
o 500 Internal Server Error: If an unexpected error occurs.
PUT /billings/{billingId}
• Description: Update an existing billing.
• Parameters:
o billingId (path parameter): The ID of the billing to update.
• Request Body: JSON object representing the updated billing.
• HTTP Status Codes:
o 204 No Content: If the billing is successfully updated.
o 404 Not Found: If the billing with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
DELETE /billings/{billingId}
• Description: Delete a billing.
• Parameters:
o billingId (path parameter): The ID of the billing to delete.
• HTTP Status Codes:
o 204 No Content: If the billing is successfully deleted.
o 404 Not Found: If the billing with the specified ID is not found.
o 500 Internal Server Error: If an unexpected error occurs.
Conclusion
This concludes the API documentation for the Healthcare Management System.
Please refer to this document for detailed information on each endpoint and how
to interact with the API.
