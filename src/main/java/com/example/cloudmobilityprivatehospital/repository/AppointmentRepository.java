package com.example.cloudmobilityprivatehospital.repository;

import com.example.cloudmobilityprivatehospital.domain.Appointment;
import com.example.cloudmobilityprivatehospital.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	List<Appointment> findAppointmentByDateBetween(LocalDate nowDate, LocalDate endDate);
	List<Appointment> findAppointmentByDateBetweenAndDoctor(LocalDate localDate, LocalDate endDate, Doctor doctor);
}
