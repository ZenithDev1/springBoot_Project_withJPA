package com.zenithdev.linkedin.hospitalManagement.service;

import com.zenithdev.linkedin.hospitalManagement.entity.Patient;
import com.zenithdev.linkedin.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    // DI
    private final PatientRepository patientRepository;
    private final EntityManager entityManager;

    @Transactional
    public Patient getPatientById(Long id) {

        Patient patient1 = patientRepository.findById(id).orElseThrow();
        Patient patient2 = patientRepository.findById(id).orElseThrow();

        System.out.println(patient1 == patient2);

        patient1.setPatientName("ArijitSingh");
        return patient1;
    }
}
