package com.example.cloudmobilityprivatehospital.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAppointmentRequestDTO {

	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate appointmentDate;

	@Range(min = 0, max = 24)
	@NotNull
	Short appointmentHour;

	@NotNull
	private String doctorName;

	@NotNull
	private String patientName;
}
