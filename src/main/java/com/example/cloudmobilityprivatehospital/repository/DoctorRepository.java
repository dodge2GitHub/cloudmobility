package com.example.cloudmobilityprivatehospital.repository;

import com.example.cloudmobilityprivatehospital.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
	Optional<Doctor> findDoctorByName(String doctorName);
}
