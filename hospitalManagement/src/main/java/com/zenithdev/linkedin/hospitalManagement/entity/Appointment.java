package com.zenithdev.linkedin.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 300)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    //@ToString.Exclude  use exclude to print all the patient just for Testing purpose only
    // patient canot be null in appointment bcz, patient is required for appointment registration.
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(nullable = false)
    //@ToString.Exclude  use exclude to print all the patient just for Testing purpose only
    private Doctor doctor;

}
