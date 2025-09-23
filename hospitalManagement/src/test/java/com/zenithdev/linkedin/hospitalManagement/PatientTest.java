package com.zenithdev.linkedin.hospitalManagement;

import com.zenithdev.linkedin.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.zenithdev.linkedin.hospitalManagement.entity.Patient;
import com.zenithdev.linkedin.hospitalManagement.entity.type.BloodGroupType;
import com.zenithdev.linkedin.hospitalManagement.repository.PatientRepository;
import com.zenithdev.linkedin.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Page;

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

          //List<Patient> patientList = patientRespository.findByBloodGroup(BloodGroupType.A_NEGATIVE);

        //List<Patient> patientList = patientRespository.findByBornAfterDate(LocalDate.of(1988,01,06));

//        List<Patient> patientList = patientRespository.findAll();
//
//        for (Patient patient : patientList) {
//            System.out.println(patient);
//        }
//
//        List<Object[]> bloodGroupList = patientRespository.countEachBloodGroupType();
//        for(Object[] bloodGroup : bloodGroupList){
//            System.out.println(bloodGroup[0] + " " + bloodGroup[1]);
//        }

//        int rowsUpdated = patientRespository.updateNameWithId("Arav Sharma", 1L);
//        System.out.println(rowsUpdated);

//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRespository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponse : bloodGroupList){
//            System.out.println(bloodGroupCountResponse);
//        }

        Page<Patient> patientList = patientRespository.findAllPatient(PageRequest.of(0,3, Sort.by("name")));

        for (Patient patient : patientList) {
            System.out.println(patient);
        }

    }
}
