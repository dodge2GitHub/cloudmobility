package com.example.cloudmobilityprivatehospital.repository;

import com.example.cloudmobilityprivatehospital.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

	List<Appointment> findAppointmentByDateBetween(LocalDate nowDate, LocalDate endDate);
	List<Appointment> findAppointmentByDateBetweenAndDoctor(LocalDateTime localDateTime, LocalDateTime endDate, Doctor doctor);
}
