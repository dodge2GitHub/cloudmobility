package com.example.cloudmobilityprivatehospital.controller;

import com.example.cloudmobilityprivatehospital.TestProperties;
import com.example.cloudmobilityprivatehospital.web.model.ScheduledAppointmentsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
		"classpath:cleanup.sql", "classpath:populate-data.sql"})
@EnableConfigurationProperties(TestProperties.class)
class DoctorTestIT {

	private static final String SCHEDULED_APPOINTMENTS_URL
			= "/api/v1/doctor/scheduled-appointments";
	public static final String DR_JENIFFER = "Dr. Jeniffer";

	@Value("${test-properties.user}")
	private String user;

	@Value("${test-properties.password}")
	private String password;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getScheduledAppointments() {
		LocalDate startDate = LocalDate.of(2021, 3, 20);
		LocalDate endDate = LocalDate.of(2021, 3, 23);

		ResponseEntity<ScheduledAppointmentsDTO> response = testRestTemplate
				.withBasicAuth(user, password)
				.getForEntity(SCHEDULED_APPOINTMENTS_URL
						+"?startDate="+startDate
						+"&endDate="+endDate
						+"&doctorName="+DR_JENIFFER, ScheduledAppointmentsDTO.class);

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getMapOfAppointments().size()).isEqualTo(1);
		assertThat(response.getBody().getMapOfAppointments().get(DR_JENIFFER)).isEqualTo(
				LocalDateTime.of(2021,3,20,9,0,0));

	}


}