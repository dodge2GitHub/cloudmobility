package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.web.model.AppointmentDTO;
import com.example.cloudmobilityprivatehospital.web.model.RequestAppointmentDTO;

public interface AppointmentService {
	AppointmentDTO bookAppointment(RequestAppointmentDTO requestAppointmentDTO);
}
