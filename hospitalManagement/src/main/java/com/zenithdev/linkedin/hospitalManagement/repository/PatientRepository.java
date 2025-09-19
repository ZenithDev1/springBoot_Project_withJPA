package com.zenithdev.linkedin.hospitalManagement.repository;

import com.zenithdev.linkedin.hospitalManagement.entity.Patient;
import com.zenithdev.linkedin.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthday, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContaining(String query);

    @Query("SELECT p FROM Patient p where p.blood_group =?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select  p from Patient p where p.birthDate >:birthdate")
    List<Patient> findByBornAfterDate(@Param("birthdate") LocalDate birthdate);

    @Query("select  p.blood_group, Count(p) from Patient p group by p.blood_group")
    List<Object[]> countEachBloodGroupType();

    @Query(value = "SELECT * FROM Patient", nativeQuery = true)
    List<Patient> findAllPatient();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

}
