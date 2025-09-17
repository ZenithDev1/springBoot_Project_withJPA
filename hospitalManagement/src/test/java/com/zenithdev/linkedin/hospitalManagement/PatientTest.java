package com.zenithdev.linkedin.hospitalManagement;

import com.zenithdev.linkedin.hospitalManagement.entity.Patient;
import com.zenithdev.linkedin.hospitalManagement.repository.PatientRepository;
import com.zenithdev.linkedin.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRespository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRespository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods(){

//        List<Patient> patientList = patientRespository.findByBirthDateOrEmail(LocalDate.of(1992,12,01), "kabir.singh@example.com");
//


          List<Patient> patientList = patientRespository.findByNameContaining("Di");

        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }
}
