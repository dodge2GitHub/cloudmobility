package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.domain.Appointment;
import com.example.cloudmobilityprivatehospital.domain.Doctor;
import com.example.cloudmobilityprivatehospital.domain.Patient;
import com.example.cloudmobilityprivatehospital.mapper.AppointmentMapper;
import com.example.cloudmobilityprivatehospital.repository.AppointmentRepository;
import com.example.cloudmobilityprivatehospital.repository.DoctorRepository;
import com.example.cloudmobilityprivatehospital.repository.PatientRepository;
import com.example.cloudmobilityprivatehospital.web.model.AppointmentDTO;
import com.example.cloudmobilityprivatehospital.web.model.CreateAppointmentRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@RequiredArgsConstructor
@Log4j2
public class AppointmentServImpl implements AppointmentService {

	private final DoctorRepository doctorRepository;
	private final PatientRepository patientRepository;
	private final AppointmentRepository appointmentRepository;
	private final AppointmentMapper appointmentMapper;

	@Override
	public AppointmentDTO bookAppointment(CreateAppointmentRequestDTO createAppointmentRequestDTO) {

		log.info("Passing through appointment service impl..");

		Doctor doctor = doctorRepository.findDoctorByName(createAppointmentRequestDTO.getDoctorName()).get();
		Patient patient =  patientRepository.findByName(createAppointmentRequestDTO.getPatientName())
				.get();
		LocalTime timeSlot =  LocalTime
				.of(createAppointmentRequestDTO.getAppointmentHour(),0);

		Appointment appointment = Appointment.builder()
				.doctor(doctor)
				.patient(patient)
				.date(createAppointmentRequestDTO.getAppointmentDate())
				.timeSlot(timeSlot)
				.build();

		log.debug("Saving new appointment..{}",appointment);
		Appointment savedAppointment = appointmentRepository.save(appointment);

		log.debug("Saved successfully..{}",savedAppointment);
		return appointmentMapper.appointmentToDTO(savedAppointment);
	}
}


