package com.zenithdev.linkedin.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @Column(nullable = false, length = 20)
    private String doctorName;

    @Column(nullable = false, length = 18)
    private String specializationOfDoctor;

    @Column(nullable = false, unique = true, length = 30)
    private String doctorEmail;

//    @OneToMany
//    private Appointment appointment;

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments;
}
