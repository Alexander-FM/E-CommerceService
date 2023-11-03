package com.alexandertutoriales.service.ecommerce.mapper;

import com.alexandertutoriales.service.ecommerce.entity.DocumentoAlmacenado;
import com.alexandertutoriales.service.ecommerce.entity.dto.DocumentoAlmacenadoDto;
import com.alexandertutoriales.service.ecommerce.mapperImpl.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentoAlmacenadoMapper extends GenericMapper<DocumentoAlmacenadoDto, DocumentoAlmacenado> {

  @Override
  DocumentoAlmacenadoDto toDto(DocumentoAlmacenado documentoAlmacenado);

  @Override
  DocumentoAlmacenado toEntity(DocumentoAlmacenadoDto documentoAlmacenadoDto);
}
