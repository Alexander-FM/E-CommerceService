package com.alexandertutoriales.service.ecommerce.mapper;

import com.alexandertutoriales.service.ecommerce.entity.Rol;
import com.alexandertutoriales.service.ecommerce.entity.dto.RolDto;
import com.alexandertutoriales.service.ecommerce.mapperImpl.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolMapper extends GenericMapper<RolDto, Rol> {

  @Override
  RolDto toDto(Rol rol);

  @Override
  Rol toEntity(RolDto rolDto);
}
