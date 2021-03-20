package com.example.cloudmobilityprivatehospital.mapper;

import com.example.cloudmobilityprivatehospital.domain.Appointment;
import com.example.cloudmobilityprivatehospital.web.model.AppointmentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface AppointmentMapper {

	AppointmentDTO appointmentToDTO(Appointment appointment);
}
