package com.example.cloudmobilityprivatehospital.service;

import com.example.cloudmobilityprivatehospital.domain.Appointment;
import com.example.cloudmobilityprivatehospital.domain.Doctor;
import com.example.cloudmobilityprivatehospital.repository.AppointmentRepository;
import com.example.cloudmobilityprivatehospital.repository.DoctorRepository;
import com.example.cloudmobilityprivatehospital.web.model.AvailableAppointmentsDTO;
import com.example.cloudmobilityprivatehospital.web.model.ScheduledAppointmentsDTO;
import com.example.cloudmobilityprivatehospital.web.model.UnavailableDTO;
import com.example.cloudmobilityprivatehospital.web.model.UnavailableRequestDTO;
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
		return doctorRepository.findDoctorByName(doctorName).get();
	}

	@Override
	public ScheduledAppointmentsDTO getScheduledAppointments(LocalDate startDate, LocalDate endDate, String doctorName) {

		Doctor doctor = doctorRepository.findDoctorByName(doctorName).get();

		List<Appointment> appointmentList = appointmentRepository
				.findAppointmentByDateBetweenAndDoctor(startDate, endDate, doctor);

		Map<String,LocalDateTime> mapOfAppointments = new HashMap<>();
		appointmentList.forEach(appointment -> {
			mapOfAppointments.put(appointment.getDoctor().getName(), LocalDateTime.of(appointment.getDate(), appointment.getTimeSlot()));
		});

		return ScheduledAppointmentsDTO.builder().mapOfAppointments(mapOfAppointments).build();

	}

	@Override
	public UnavailableDTO markUnavailable(UnavailableRequestDTO requestDTO) {

		String unavailableInterval = requestDTO.getStartDate().toString()+","+requestDTO.getEndDate().toString();
		Doctor doctor = doctorRepository.findDoctorByName(requestDTO.getDoctorName()).get();
		doctor.setUnavailable(unavailableInterval);
		Doctor savedDoctor = doctorRepository.save(doctor);
		return UnavailableDTO.builder()
				.startDate(LocalDate.parse(savedDoctor.getUnavailable().substring(0,10)))
				.endDate(LocalDate.parse(savedDoctor.getUnavailable().substring(11)))
				.build();
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
