package com.example.cloudmobilityprivatehospital.web.controller;

import com.example.cloudmobilityprivatehospital.service.PatientService;
import com.example.cloudmobilityprivatehospital.web.model.AppointmentDTO;
import com.example.cloudmobilityprivatehospital.web.model.AvailableAppointmentsDTO;
import com.example.cloudmobilityprivatehospital.web.model.CreateAppointmentRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api/v1/patient")
@AllArgsConstructor
@Tag(name = "Patient")
public class PatientController {

	private final PatientService patientService;

	@GetMapping("/free-appointments")
	@Operation(summary = "See all free doctors for making appointments")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = @Content(schema = @Schema(implementation = AvailableAppointmentsDTO.class)))})
	public ResponseEntity<AvailableAppointmentsDTO> deleteAllDataStoreTypes(
			@RequestParam( "endDate" ) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

		return new ResponseEntity<>(patientService.getFreeAppointmentSlots(endDate),HttpStatus.OK);
	}

	@PostMapping("/book-appointment")
	@Operation(summary = "Book an appointment in a free slot")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = @Content(schema = @Schema(implementation = AppointmentDTO.class)))})
	public ResponseEntity<AppointmentDTO> deleteAllDataStoreTypes(@RequestBody RequestAppointmentDTO requestAppointmentDTO){

		return new ResponseEntity<>(patientService.bookAppointment(requestAppointmentDTO), HttpStatus.OK);
	}
}
