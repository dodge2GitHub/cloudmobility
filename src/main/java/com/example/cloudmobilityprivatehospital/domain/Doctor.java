package com.example.cloudmobilityprivatehospital.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name = "doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctorSequenceGenerator")
	@SequenceGenerator(name = "doctorSequenceGenerator", sequenceName = "doctor_id_seq", allocationSize = 1)
	@With
	private Integer id;

	@Column(length = 128, unique = true, nullable = false)
	private String name;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column
	private String unavailable;
}
