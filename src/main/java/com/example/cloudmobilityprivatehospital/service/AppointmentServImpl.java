package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.domain.Appointment;
import com.example.cloudmobilityprivatehospital.domain.Doctor;
import com.example.cloudmobilityprivatehospital.domain.Patient;
import com.example.cloudmobilityprivatehospital.mapper.AppointmentMapper;
import com.example.cloudmobilityprivatehospital.repository.AppointmentRepository;
import com.example.cloudmobilityprivatehospital.web.model.AppointmentDTO;
import com.example.cloudmobilityprivatehospital.web.model.RequestAppointmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServImpl implements AppointmentService {

	private final DoctorService doctorService;
	private final PatientService patientService;
	private final AppointmentRepository appointmentRepository;
	private final AppointmentMapper appointmentMapper;

	@Override
	public AppointmentDTO bookAppointment(RequestAppointmentDTO requestAppointmentDTO) {

		Doctor doctor = doctorService.getDoctorByName(requestAppointmentDTO.getDoctorName());
		Patient patient = patientService.getPatientByNameAndBirthDay(requestAppointmentDTO.getPatientName(),
				requestAppointmentDTO.getPatientBirthday());

		Appointment appointment = Appointment.builder()
				.doctor(doctor)
				.patient(patient)
				.date(requestAppointmentDTO.getAppointmentDateTime().toLocalDate())
				.timeSlot(requestAppointmentDTO.getAppointmentDateTime().toLocalTime())
				.build();

		return appointmentMapper.appointmentToDTO(appointmentRepository.save(appointment));
	}
}


