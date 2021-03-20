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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(Appointment.class)
public class Appointment implements Serializable {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointmentSequenceGenerator")
	@SequenceGenerator(name = "appointmentSequenceGenerator", sequenceName = "appointment_id_seq", allocationSize = 1)
	@With
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	@With
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	@With
	@Id
	private Doctor doctor;

	@Column
	@Id
	private LocalDate date;

	@Column(name = "time_slot")
	@Id
	private LocalTime timeSlot;
}
