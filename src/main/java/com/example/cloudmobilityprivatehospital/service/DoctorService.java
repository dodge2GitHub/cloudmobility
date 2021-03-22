package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.domain.Doctor;
import com.example.cloudmobilityprivatehospital.web.model.AvailableAppointmentsDTO;
import com.example.cloudmobilityprivatehospital.web.model.ScheduledAppointmentsDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DoctorService {

	AvailableAppointmentsDTO getDoctorsAvailability(LocalDate endDate);

	Doctor getDoctorByName(String doctorName);

	ScheduledAppointmentsDTO getScheduledAppointments(LocalDate startDate,
													  LocalDate endDate,
													  String doctorName);
}
