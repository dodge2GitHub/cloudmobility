package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.web.model.AppointmentDTO;
import com.example.cloudmobilityprivatehospital.web.model.AvailableAppointmentsDTO;
import com.example.cloudmobilityprivatehospital.web.model.CreateAppointmentRequestDTO;

import java.time.LocalDate;

public interface PatientService {

	/**
	 * Returns all of the free appointments of doctors
	 * @return
	 * @param endDate
	 */
	AvailableAppointmentsDTO getFreeAppointmentSlots(LocalDate endDate);

	/**
	 * Books an appointment
	 * @param createAppointmentRequestDTO
	 * @return
	 */
	AppointmentDTO bookAppointment(CreateAppointmentRequestDTO createAppointmentRequestDTO);
}
