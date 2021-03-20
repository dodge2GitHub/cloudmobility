package com.example.cloudmobilityprivatehospital.repository;

import com.example.cloudmobilityprivatehospital.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
	Optional<Doctor> findByName(String doctorName);
}
