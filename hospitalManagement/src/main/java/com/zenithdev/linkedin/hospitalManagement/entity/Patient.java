package com.zenithdev.linkedin.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient_tbl",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name", columnNames = {"name"})
                },
        indexes = {
                @Index(name = "idx_patient_email", columnList = "email")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name")
    private String name;

    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String gender;

    @Column(updatable = false)
    private LocalDateTime patientCreatedAt;

}
