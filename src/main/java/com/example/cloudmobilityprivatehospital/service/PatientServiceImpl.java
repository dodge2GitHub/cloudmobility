package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.web.model.AppointmentDTO;
import com.example.cloudmobilityprivatehospital.web.model.AvailableAppointmentsDTO;
import com.example.cloudmobilityprivatehospital.web.model.CreateAppointmentRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Log4j2
public class PatientServiceImpl implements PatientService{

	private final DoctorService doctorService;
	private final AppointmentService appointmentService;

	@Override
	public AvailableAppointmentsDTO getFreeAppointmentSlots(LocalDate endDate) {
		log.info("Passing through patient service impl..");

		return doctorService.getDoctorsAvailability(endDate);
	}

	@Override
	public AppointmentDTO bookAppointment(CreateAppointmentRequestDTO createAppointmentRequestDTO) {
		log.info("Passing through patient service impl..");

		return appointmentService.bookAppointment(createAppointmentRequestDTO);
	}
}
