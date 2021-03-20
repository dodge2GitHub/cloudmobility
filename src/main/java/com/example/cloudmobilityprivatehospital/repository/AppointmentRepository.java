package com.example.cloudmobilityprivatehospital.repository;

import com.example.cloudmobilityprivatehospital.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

	List<Appointment> findAppointmentByDateBetween(LocalDate nowDate, LocalDate endDate);
}
