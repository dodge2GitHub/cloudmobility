package com.example.cloudmobilityprivatehospital.web.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ScheduledAppointmentsDTO {

	Map<LocalDateTime,String> mapOfAppointments;
}
