package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.web.model.AppointmentDTO;
import com.example.cloudmobilityprivatehospital.web.model.CreateAppointmentRequestDTO;

public interface AppointmentService {
	/**
	 * Books an appointment
	 * @param createAppointmentRequestDTO
	 * @return
	 */
	AppointmentDTO bookAppointment(CreateAppointmentRequestDTO createAppointmentRequestDTO);
}
