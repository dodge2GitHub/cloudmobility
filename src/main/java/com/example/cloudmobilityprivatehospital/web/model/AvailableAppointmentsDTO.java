package com.example.cloudmobilityprivatehospital.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvailableAppointmentsDTO {

	private Map<String, Map<LocalDate, List<LocalTime>>> mapOfAvailability;
}
