package com.alexandertutoriales.service.ecommerce.mapper;

import com.alexandertutoriales.service.ecommerce.entity.Categoria;
import com.alexandertutoriales.service.ecommerce.entity.dto.CategoriaDto;
import com.alexandertutoriales.service.ecommerce.mapperImpl.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends GenericMapper<CategoriaDto, Categoria> {

  @Override
  CategoriaDto toDto(Categoria categoria);

  @Override
  Categoria toEntity(CategoriaDto usuarioDto);
}
