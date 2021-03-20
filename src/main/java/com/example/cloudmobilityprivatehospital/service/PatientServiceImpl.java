package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.domain.Patient;
import com.example.cloudmobilityprivatehospital.repository.PatientRepository;
import com.example.cloudmobilityprivatehospital.web.model.AppointmentDTO;
import com.example.cloudmobilityprivatehospital.web.model.AvailableAppointmentsDTO;
import com.example.cloudmobilityprivatehospital.web.model.RequestAppointmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

	private final DoctorService doctorService;
	private final AppointmentService appointmentService;
	private final PatientRepository patientRepository;

	@Override
	public AvailableAppointmentsDTO getFreeAppointmentSlots(LocalDate endDate) {
		return doctorService.getDoctorsAvailability(endDate);
	}

	@Override
	public AppointmentDTO bookAppointment(RequestAppointmentDTO requestAppointmentDTO) {
		return appointmentService.bookAppointment(requestAppointmentDTO);
	}

	@Override
	public Patient getPatientByNameAndBirthDay(String patientName, LocalDateTime patientBirthday) {
		return patientRepository.findByNameAndBirthDay(patientName, patientBirthday).get();
	}
}
