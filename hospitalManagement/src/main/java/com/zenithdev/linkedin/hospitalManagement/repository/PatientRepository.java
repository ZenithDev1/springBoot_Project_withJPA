package com.zenithdev.linkedin.hospitalManagement.repository;

import com.zenithdev.linkedin.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {



}
