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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointment",uniqueConstraints = { @UniqueConstraint( columnNames = { "doctor_id", "date", "time_slot" })})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointmentSequenceGenerator")
	@SequenceGenerator(name = "appointmentSequenceGenerator", sequenceName = "appointment_id_seq", allocationSize = 1)
	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@With
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	@With
	private Doctor doctor;

	@Column
	private LocalDate date;

	@Column(name = "time_slot")
	private LocalTime timeSlot;
}
