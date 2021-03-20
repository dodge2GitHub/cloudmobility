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
import java.time.LocalDate;

@Entity
@Table(name = "patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientSequenceGenerator")
	@SequenceGenerator(name = "patientSequenceGenerator", sequenceName = "patient_id_seq", allocationSize = 1)
	@With
	private Integer id;

	@Column(length = 128, unique = true, nullable = false)
	private String name;

	@Column
	private LocalDate birthday;
}
