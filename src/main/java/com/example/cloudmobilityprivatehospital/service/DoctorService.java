package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.domain.Doctor;
import com.example.cloudmobilityprivatehospital.web.model.AvailableAppointmentsDTO;

import java.time.LocalDate;

public interface DoctorService {

	AvailableAppointmentsDTO getDoctorsAvailability(LocalDate endDate);

	Doctor getDoctorByName(String doctorName);
}
