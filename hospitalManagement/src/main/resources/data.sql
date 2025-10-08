INSERT INTO patient (patient_name, patient_gender, birth_date, patient_email, blood_group)
VALUES
    ('Aarav Sharma', 'MALE', '1990-05-10', 'aarav.sharma@example.com', 'O_POSITIVE'),
    ('Diva Patel', 'FEMALE', '1995-08-20', 'diya.patel@example.com', 'A_POSITIVE'),
    ('Dishant Verma', 'MALE', '1988-03-15', 'dishant.verma@example.com', 'A_POSITIVE'),
    ('Neha Iver', 'FEMALE', '1992-12-01', 'neha.iyer@example.com', 'AB_POSITIVE'),
    ('Kabir Singh', 'MALE', '1993-07-11', 'kabir.singh@example.com', 'O_POSITIVE');


INSERT INTO doctor(doctor_name, specialization_of_doctor, doctor_email)
VALUES
    ('Dr. Devendrad Kumar', 'Neurology', 'devendraa.kumar@gmail.com'),
    ('Dr. Sneha Kapoor', 'CardioLogy', 'sneha.kapoor@example.com'),
    ('Dr. Arjun Sharma', 'Orthopedics', 'arjun.sharma@apolo.in');

INSERT INTO appointment(appointment_time, reason, doctor_id,patient_id)
VALUES
    ('2025-07-01 10:30:00','General CheckUp', 1,2),
    ('2025-07-02 11:30:00','Skin Rash',2,2),
    ('2025-07-03 09:45:00','Knee Pain',3,3),
    ('2025-07-04 10:15:00','Follow-Up Visit',1,1),
    ('2025-07-05 12:30:00','Consultation',1,4),
    ('2025-07-06 09:20:00','Allergy Treatment',2,5);