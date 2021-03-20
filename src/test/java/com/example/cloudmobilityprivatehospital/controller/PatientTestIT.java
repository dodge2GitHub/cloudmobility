package com.example.cloudmobilityprivatehospital.controller;

import com.example.cloudmobilityprivatehospital.TestProperties;
import com.example.cloudmobilityprivatehospital.web.model.AvailableAppointmentsDTO;
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
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_TIME;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
		"classpath:cleanup.sql", "classpath:populate-data.sql"})
@EnableConfigurationProperties(TestProperties.class)
class PatientTestIT {

	private static final String FREE_APPOINTMENTS_URL = "/api/v1/patient/free-appointments?endDate=";
	public static final String DR_JENIFFER = "Dr. Jeniffer";
	public static final String DR_PAUL = "Dr. Paul";

	@Value("${test-properties.user}")
	private String user;

	@Value("${test-properties.password}")
	private String password;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getAvailability() {

		LocalDate endDate = LocalDate.of(2021, 3, 22);

		ResponseEntity<AvailableAppointmentsDTO> response = testRestTemplate
				.withBasicAuth(user, password)
				.getForEntity(FREE_APPOINTMENTS_URL+endDate, AvailableAppointmentsDTO.class,endDate);

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();

		assertThat(response.getBody().getMapOfAvailability().get(DR_JENIFFER)
				.get(LocalDate.of(2021,3,20)).contains(LocalTime.of(9,0))).isFalse();

		assertThat(response.getBody().getMapOfAvailability().get(DR_PAUL)
				.get(LocalDate.of(2021,3,22)).contains(LocalTime.of(17,0))).isFalse();

	}
}