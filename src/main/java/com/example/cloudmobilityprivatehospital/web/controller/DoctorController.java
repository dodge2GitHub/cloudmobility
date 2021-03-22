package com.example.cloudmobilityprivatehospital.web.controller;

import com.example.cloudmobilityprivatehospital.service.DoctorService;
import com.example.cloudmobilityprivatehospital.web.model.ScheduledAppointmentsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/doctor")
@AllArgsConstructor
@Tag(name = "Doctor")
@Log4j2
public class DoctorController {

	@Autowired
	private final DoctorService doctorService;

	@GetMapping("/scheduled-appointments")
	@Operation(summary = "See all appointments schedule for a specific time period")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success",
					content = @Content(schema = @Schema(implementation = ScheduledAppointmentsDTO.class)))})
	public ResponseEntity<ScheduledAppointmentsDTO> getFreeAppointments(
			@RequestParam( "start" ) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startDate,
			@RequestParam( "end" ) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endDate,
			@RequestParam("doctorName") String doctorName) {

		log.info("Enter Doctor controller...get scheduled appointments endpoint");
		return new ResponseEntity<>(doctorService.getScheduledAppointments(startDate, endDate, doctorName), HttpStatus.OK);
	}

}
