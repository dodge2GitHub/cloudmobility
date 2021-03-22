--
-- PostgreSQL database dump
--
SET
client_encoding = 'UTF8';
SET
standard_conforming_strings = off;--Treats back slashes as escape characters
--disables validation of the function body string during sql-createfunction. Disabling validation avoids side effects of the validation process and avoids false positives due to --problems such as forward references
SET
check_function_bodies = false;
SET
client_min_messages = warning;
SET
escape_string_warning = off;

CREATE SCHEMA IF NOT EXISTS privatehospital;

CREATE TABLE privatehospital.patient
(
    id       serial PRIMARY KEY,
    birthday date    NOT NULL,
    name     varchar(128) NOT NULL
);

CREATE TABLE privatehospital.doctor
(
    id   serial PRIMARY KEY,
    name varchar(128) NOT NULL,
    start_time time NOT null default '09:00:00',
    end_time time NOT null  default '19:00:00',
    unavailable varchar(50)
);

CREATE TABLE privatehospital.appointment
(
    id serial PRIMARY KEY,
    patient_id INTEGER  NOT NULL,
    doctor_id  INTEGER  NOT NULL,
    "date" date not null,
    time_slot  time NOT null,
    unique (doctor_id, "date", time_slot)
);

ALTER TABLE privatehospital.appointment
    ADD CONSTRAINT "patient_fk" FOREIGN KEY (patient_id)
        REFERENCES privatehospital.patient (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT;
ALTER TABLE privatehospital.appointment
    ADD CONSTRAINT "doctor_fk" FOREIGN KEY (doctor_id)
        REFERENCES privatehospital.doctor (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT;