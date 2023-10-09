package com.alexandertutoriales.service.ecommerce.mapper;

import com.alexandertutoriales.service.ecommerce.entity.Empleado;
import com.alexandertutoriales.service.ecommerce.entity.Rol;
import com.alexandertutoriales.service.ecommerce.entity.dto.EmpleadoDto;
import com.alexandertutoriales.service.ecommerce.entity.dto.RolDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-08T19:51:57-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class EmpleadoMapperImpl implements EmpleadoMapper {

    @Override
    public List<Empleado> toEntity(List<EmpleadoDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Empleado> list = new ArrayList<Empleado>( dtoList.size() );
        for ( EmpleadoDto empleadoDto : dtoList ) {
            list.add( toEntity( empleadoDto ) );
        }

        return list;
    }

    @Override
    public List<EmpleadoDto> toDto(List<Empleado> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmpleadoDto> list = new ArrayList<EmpleadoDto>( entityList.size() );
        for ( Empleado empleado : entityList ) {
            list.add( toDto( empleado ) );
        }

        return list;
    }

    @Override
    public Set<EmpleadoDto> toDto(Set<Empleado> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<EmpleadoDto> set = new LinkedHashSet<EmpleadoDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Empleado empleado : entityList ) {
            set.add( toDto( empleado ) );
        }

        return set;
    }

    @Override
    public EmpleadoDto toDto(Empleado empleado) {
        if ( empleado == null ) {
            return null;
        }

        EmpleadoDto empleadoDto = new EmpleadoDto();

        empleadoDto.setId( empleado.getId() );
        empleadoDto.setNombre( empleado.getNombre() );
        empleadoDto.setApellidos( empleado.getApellidos() );
        empleadoDto.setVigencia( empleado.isVigencia() );
        empleadoDto.setRol( rolToRolDto( empleado.getRol() ) );
        empleadoDto.setVigenciaString( empleado.getVigenciaString() );

        return empleadoDto;
    }

    @Override
    public Empleado toEntity(EmpleadoDto empleadoDto) {
        if ( empleadoDto == null ) {
            return null;
        }

        Empleado empleado = new Empleado();

        empleado.setId( empleadoDto.getId() );
        empleado.setNombre( empleadoDto.getNombre() );
        empleado.setApellidos( empleadoDto.getApellidos() );
        empleado.setVigencia( empleadoDto.isVigencia() );
        empleado.setRol( rolDtoToRol( empleadoDto.getRol() ) );
        empleado.setVigenciaString( empleadoDto.getVigenciaString() );

        return empleado;
    }

    protected RolDto rolToRolDto(Rol rol) {
        if ( rol == null ) {
            return null;
        }

        RolDto rolDto = new RolDto();

        rolDto.setId( rol.getId() );
        rolDto.setNombre( rol.getNombre() );

        return rolDto;
    }

    protected Rol rolDtoToRol(RolDto rolDto) {
        if ( rolDto == null ) {
            return null;
        }

        Rol rol = new Rol();

        rol.setId( rolDto.getId() );
        rol.setNombre( rolDto.getNombre() );

        return rol;
    }
}
