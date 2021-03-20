package com.example.cloudmobilityprivatehospital.repository;

import com.example.cloudmobilityprivatehospital.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

	Optional<Patient> findByNameAndBirthDay(String patientName, LocalDateTime patientBirthday);
}
