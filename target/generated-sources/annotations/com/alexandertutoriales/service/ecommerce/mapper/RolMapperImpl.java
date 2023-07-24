package com.alexandertutoriales.service.ecommerce.mapper;

import com.alexandertutoriales.service.ecommerce.entity.Rol;
import com.alexandertutoriales.service.ecommerce.entity.dto.RolDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-24T17:50:07-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class RolMapperImpl implements RolMapper {

    @Override
    public List<Rol> toEntity(List<RolDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Rol> list = new ArrayList<Rol>( dtoList.size() );
        for ( RolDto rolDto : dtoList ) {
            list.add( toEntity( rolDto ) );
        }

        return list;
    }

    @Override
    public List<RolDto> toDto(List<Rol> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RolDto> list = new ArrayList<RolDto>( entityList.size() );
        for ( Rol rol : entityList ) {
            list.add( toDto( rol ) );
        }

        return list;
    }

    @Override
    public Set<RolDto> toDto(Set<Rol> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<RolDto> set = new LinkedHashSet<RolDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Rol rol : entityList ) {
            set.add( toDto( rol ) );
        }

        return set;
    }

    @Override
    public RolDto toDto(Rol rol) {
        if ( rol == null ) {
            return null;
        }

        RolDto rolDto = new RolDto();

        rolDto.setId( rol.getId() );
        rolDto.setNombre( rol.getNombre() );

        return rolDto;
    }

    @Override
    public Rol toEntity(RolDto rolDto) {
        if ( rolDto == null ) {
            return null;
        }

        Rol rol = new Rol();

        rol.setId( rolDto.getId() );
        rol.setNombre( rolDto.getNombre() );

        return rol;
    }
}
