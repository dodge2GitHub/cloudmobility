package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.domain.Doctor;
import com.example.cloudmobilityprivatehospital.web.model.AvailableAppointmentsDTO;
import com.example.cloudmobilityprivatehospital.web.model.ScheduledAppointmentsDTO;
import com.example.cloudmobilityprivatehospital.web.model.UnavailableDTO;
import com.example.cloudmobilityprivatehospital.web.model.UnavailableRequestDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DoctorService {

	/**
	 * Get doctors availability for a given period
	 * @param endDate
	 * @return
	 */
	AvailableAppointmentsDTO getDoctorsAvailability(LocalDate endDate);

	/**
	 * get a doctor object by it's name
	 * @param doctorName
	 * @return
	 */
	Doctor getDoctorByName(String doctorName);

	/**
	 * get all the sheduled appointments of a doctor for a given period
	 * @param startDate
	 * @param endDate
	 * @param doctorName
	 * @return
	 */
	ScheduledAppointmentsDTO getScheduledAppointments(LocalDate startDate,
													  LocalDate endDate,
													  String doctorName);

	/**
	 * set a doctor unavailable for a certain period
	 * @param requestDTO
	 * @return
	 */
	UnavailableDTO markUnavailable(UnavailableRequestDTO requestDTO);
}
