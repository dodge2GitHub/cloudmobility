INSERT INTO doctor (id, name, start_time, end_time)
VALUES (1, 'Dr. Jeniffer','09:00:00','19:00:00');
INSERT INTO doctor (id, name, start_time, end_time)
VALUES (2, 'Dr. Paul','09:00:00','19:00:00');


INSERT INTO patient (id, birthday, name)
VALUES (1, '1988-10-13', 'Carol');
INSERT INTO patient (id, birthday, name)
VALUES (2, '1988-10-13', 'John');

INSERT INTO appointment (id, patient_id, doctor_id, date, time_slot)
VALUES (10, 1, 1, '2021-03-20', '09:00:00');
INSERT INTO appointment (id, patient_id, doctor_id, date, time_slot)
VALUES (11, 2, 2, '2021-03-22', '17:00:00');