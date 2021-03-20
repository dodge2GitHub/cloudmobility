package com.example.cloudmobilityprivatehospital.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestAppointmentDTO {

	private LocalDateTime appointmentDateTime;

	private String doctorName;

	private String patientName;

	private LocalDateTime patientBirthday;

}
