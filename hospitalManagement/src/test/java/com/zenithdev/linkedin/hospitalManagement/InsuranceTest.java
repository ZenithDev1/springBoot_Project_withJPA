package com.zenithdev.linkedin.hospitalManagement;

import com.zenithdev.linkedin.hospitalManagement.entity.Appointment;
import com.zenithdev.linkedin.hospitalManagement.entity.Insurance;
import com.zenithdev.linkedin.hospitalManagement.entity.Patient;
import com.zenithdev.linkedin.hospitalManagement.service.AppointmentService;
import com.zenithdev.linkedin.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("1234")
                .validUntil(LocalDate.of(2030,12,31))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);

        var newPatient = insuranceService.disaccociateInsuranceFromPatient(patient.getPatientId());
        System.out.println(newPatient);
    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,00))
                .reason("cancer").build();

        var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 1L);

        System.out.println(newAppointment);

        var updatedAppointment = appointmentService
                .reAssignAppointmentToAnotherDoctor(newAppointment.getAppointmentId(),3L);

        System.out.println(updatedAppointment);
    }
}
