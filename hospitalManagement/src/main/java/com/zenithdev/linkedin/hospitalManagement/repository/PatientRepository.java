package com.zenithdev.linkedin.hospitalManagement.repository;

import com.zenithdev.linkedin.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.zenithdev.linkedin.hospitalManagement.entity.Patient;
import com.zenithdev.linkedin.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByPatientName(String name);
    List<Patient> findByBirthDateOrPatientEmail(LocalDate birthday, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByPatientNameContaining(String query);

    @Query("SELECT p FROM Patient p where p.blood_group =?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select  p from Patient p where p.birthDate >:birthdate")
    List<Patient> findByBornAfterDate(@Param("birthdate") LocalDate birthdate);

    @Query("select new com.zenithdev.linkedin.hospitalManagement.dto.BloodGroupCountResponseEntity(p.blood_group,"+
            "Count(p)) from Patient p group by p.blood_group")
//    List<Object[]> countEachBloodGroupType();
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "SELECT * FROM Patient", nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.patientName = :name where p.patientId = :id")
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);

    //@Query("SELECT p from p LEFT join fetch p.appointments a LEFT JOIN FETCH a.doctor")
    @Query("SELECT p from  Patient p LEFT join fetch p.appointments")
    List<Patient> findAllPatientWithAppointment();

}
