package com.example.cloudmobilityprivatehospital.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnavailableRequestDTO {

	@NotNull
	private LocalDate startDate;

	@NotNull
	private LocalDate endDate;

	@NotNull
	private String doctorName;
}
