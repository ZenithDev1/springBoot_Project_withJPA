package com.zenithdev.linkedin.hospitalManagement.entity;

import com.zenithdev.linkedin.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient"
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(nullable = false, length = 20)
    private String patientName;

    @Column(nullable = false)
    private String patientGender;

//    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String patientEmail;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime patientCreatedAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType blood_group;

    //               MERGE works 4Updation,  PERSIST works for InitialTime
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "patient_insurance_id") // owningSide
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<Appointment> appointments = new ArrayList<>();
}
