package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.domain.Appointment;
import com.example.cloudmobilityprivatehospital.domain.Doctor;
import com.example.cloudmobilityprivatehospital.repository.AppointmentRepository;
import com.example.cloudmobilityprivatehospital.repository.DoctorRepository;
import com.example.cloudmobilityprivatehospital.web.model.AvailableAppointmentsDTO;
import com.example.cloudmobilityprivatehospital.web.model.ScheduledAppointmentsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class DoctorServiceImpl implements DoctorService {

	private final AppointmentRepository appointmentRepository;
	private final DoctorRepository doctorRepository;
	LocalDate currentDay;
	LocalDate endDate;

	@Override
	public AvailableAppointmentsDTO getDoctorsAvailability(LocalDate endDate) {

		log.info("Passing through doctor availability..");
		currentDay = LocalDate.now();
		this.endDate = endDate;

		List<Appointment> appointmentList = appointmentRepository.findAppointmentByDateBetween(currentDay, endDate);

		Map<String, Map<LocalDate, List<LocalTime>>> mapOfAvailability = new HashMap<>();

		appointmentList.forEach(appointment -> {
			String doctorName = appointment.getDoctor().getName();

			//if there isn't yet a map to this doctor the generate one
			if (!mapOfAvailability.containsKey(doctorName)) {
				mapOfAvailability.put(doctorName, generateTimeMap(appointment.getDoctor()));
			}

			//calculate date to take from available
			mapOfAvailability.get(doctorName).get(appointment.getDate())
					.remove(appointment.getTimeSlot());

		});

		return AvailableAppointmentsDTO.builder().mapOfAvailability(mapOfAvailability).build();
	}

	@Override
	public Doctor getDoctorByName(String doctorName) {
		return doctorRepository.findByName(doctorName).get();
	}

	@Override
	public ScheduledAppointmentsDTO getScheduledAppointments(LocalDateTime startDateTime, LocalDateTime endDateTime, String doctorName) {

		Doctor doctor = doctorRepository.findDoctorByName(doctorName).get();

		List<Appointment> appointmentList = appointmentRepository
				.findAppointmentByDateBetweenAndDoctor(startDateTime, endDateTime, doctor);

		Map<LocalDateTime, String> mapOfAppointments = new HashMap<>();
		appointmentList.forEach(appointment -> {
			mapOfAppointments.put(LocalDateTime.of(appointment.getDate(), appointment.getTimeSlot()),
					appointment.getDoctor().getName());
		});

		return ScheduledAppointmentsDTO.builder().mapOfAppointments(mapOfAppointments).build();

	}


	private Map<LocalDate, List<LocalTime>> generateTimeMap(Doctor doctor) {
		Map<LocalDate, List<LocalTime>> timeMap = new HashMap<>();
		LocalDate tempDay = currentDay;
		do {
			timeMap.put(tempDay, generateTimeList(doctor));
			tempDay = tempDay.plusDays(1);
		} while (tempDay.isBefore(endDate.plusDays(1)));

		return timeMap;
	}

	private List<LocalTime> generateTimeList(Doctor doctor) {
		List<LocalTime> timeList = new ArrayList<>();
		LocalTime endTime = doctor.getEndTime();
		LocalTime time;

		for (time = doctor.getStartTime(); time.isBefore(endTime.plusHours(1)); time = time.plusHours(1)) {

			if (!time.equals(LocalTime.of(13, 0))) {
				timeList.add(time);
			}
		}

		return timeList;
	}

}
