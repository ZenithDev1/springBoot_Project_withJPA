package com.zenithdev.linkedin.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
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

    @Column(nullable = false, length = 50)
    private String doctorName;

    @Column(nullable = false, length = 50)
    private String specializationOfDoctor;

    @Column(nullable = false, unique = true, length = 50)
    private String doctorEmail;

    @OneToMany(mappedBy ="doctor")
    private List<Appointment> appointment = new ArrayList<>();

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments;
}
