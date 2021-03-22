package com.example.cloudmobilityprivatehospital.web.model;

import com.example.cloudmobilityprivatehospital.domain.Doctor;
import com.example.cloudmobilityprivatehospital.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

	private PatientDTO patient;

	private DoctorDTO doctor;

	private LocalDate date;

	private LocalTime timeSlot;
}
