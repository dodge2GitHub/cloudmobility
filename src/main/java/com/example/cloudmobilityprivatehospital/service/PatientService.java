package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.domain.Patient;
import com.example.cloudmobilityprivatehospital.web.model.AppointmentDTO;
import com.example.cloudmobilityprivatehospital.web.model.AvailableAppointmentsDTO;
import com.example.cloudmobilityprivatehospital.web.model.RequestAppointmentDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface PatientService {

	/**
	 * Returns all of the free appointments of doctors
	 * @return
	 * @param endDate
	 */
	AvailableAppointmentsDTO getFreeAppointmentSlots(LocalDate endDate);

	/**
	 * Books an appointment
	 * @param requestAppointmentDTO
	 * @return
	 */
	AppointmentDTO bookAppointment(RequestAppointmentDTO requestAppointmentDTO);

	/**
	 * Return patient by name and birthday
	 * @param patientName
	 * @param patientBirthday
	 * @return
	 */
	Patient getPatientByNameAndBirthDay(String patientName, LocalDateTime patientBirthday);
}
