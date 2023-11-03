package com.alexandertutoriales.service.ecommerce.mapper;

import com.alexandertutoriales.service.ecommerce.entity.Empleado;
import com.alexandertutoriales.service.ecommerce.entity.dto.EmpleadoDto;
import com.alexandertutoriales.service.ecommerce.mapperImpl.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper extends GenericMapper<EmpleadoDto, Empleado> {

  @Override
  EmpleadoDto toDto(Empleado empleado);

  @Override
  Empleado toEntity(EmpleadoDto empleadoDto);
}
