package com.example.cloudmobilityprivatehospital.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledAppointmentsDTO {

	Map<String,LocalDateTime> mapOfAppointments;
}
