package com.alexandertutoriales.service.ecommerce.mapper;

import com.alexandertutoriales.service.ecommerce.entity.Categoria;
import com.alexandertutoriales.service.ecommerce.entity.DocumentoAlmacenado;
import com.alexandertutoriales.service.ecommerce.entity.dto.CategoriaDto;
import com.alexandertutoriales.service.ecommerce.entity.dto.DocumentoAlmacenadoDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-21T23:50:23-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public List<Categoria> toEntity(List<CategoriaDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Categoria> list = new ArrayList<Categoria>( dtoList.size() );
        for ( CategoriaDto categoriaDto : dtoList ) {
            list.add( toEntity( categoriaDto ) );
        }

        return list;
    }

    @Override
    public List<CategoriaDto> toDto(List<Categoria> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CategoriaDto> list = new ArrayList<CategoriaDto>( entityList.size() );
        for ( Categoria categoria : entityList ) {
            list.add( toDto( categoria ) );
        }

        return list;
    }

    @Override
    public Set<CategoriaDto> toDto(Set<Categoria> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<CategoriaDto> set = new LinkedHashSet<CategoriaDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Categoria categoria : entityList ) {
            set.add( toDto( categoria ) );
        }

        return set;
    }

    @Override
    public CategoriaDto toDto(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaDto categoriaDto = new CategoriaDto();

        categoriaDto.setId( categoria.getId() );
        categoriaDto.setNombre( categoria.getNombre() );
        categoriaDto.setVigenciaString( categoria.getVigenciaString() );
        categoriaDto.setVigencia( categoria.isVigencia() );
        categoriaDto.setFoto( documentoAlmacenadoToDocumentoAlmacenadoDto( categoria.getFoto() ) );

        return categoriaDto;
    }

    @Override
    public Categoria toEntity(CategoriaDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( usuarioDto.getId() );
        categoria.setNombre( usuarioDto.getNombre() );
        categoria.setVigencia( usuarioDto.isVigencia() );
        categoria.setFoto( documentoAlmacenadoDtoToDocumentoAlmacenado( usuarioDto.getFoto() ) );
        categoria.setVigenciaString( usuarioDto.getVigenciaString() );

        return categoria;
    }

    protected DocumentoAlmacenadoDto documentoAlmacenadoToDocumentoAlmacenadoDto(DocumentoAlmacenado documentoAlmacenado) {
        if ( documentoAlmacenado == null ) {
            return null;
        }

        DocumentoAlmacenadoDto documentoAlmacenadoDto = new DocumentoAlmacenadoDto();

        documentoAlmacenadoDto.setId( documentoAlmacenado.getId() );
        documentoAlmacenadoDto.setNombre( documentoAlmacenado.getNombre() );
        documentoAlmacenadoDto.setFileName( documentoAlmacenado.getFileName() );
        documentoAlmacenadoDto.setExtension( documentoAlmacenado.getExtension() );
        documentoAlmacenadoDto.setEstado( documentoAlmacenado.getEstado() );
        documentoAlmacenadoDto.setEliminado( documentoAlmacenado.isEliminado() );
        documentoAlmacenadoDto.setFile( documentoAlmacenado.getFile() );
        documentoAlmacenadoDto.setUrlFile( documentoAlmacenado.getUrlFile() );

        return documentoAlmacenadoDto;
    }

    protected DocumentoAlmacenado documentoAlmacenadoDtoToDocumentoAlmacenado(DocumentoAlmacenadoDto documentoAlmacenadoDto) {
        if ( documentoAlmacenadoDto == null ) {
            return null;
        }

        DocumentoAlmacenado documentoAlmacenado = new DocumentoAlmacenado();

        documentoAlmacenado.setId( documentoAlmacenadoDto.getId() );
        documentoAlmacenado.setNombre( documentoAlmacenadoDto.getNombre() );
        documentoAlmacenado.setFileName( documentoAlmacenadoDto.getFileName() );
        documentoAlmacenado.setExtension( documentoAlmacenadoDto.getExtension() );
        documentoAlmacenado.setEstado( documentoAlmacenadoDto.getEstado() );
        documentoAlmacenado.setEliminado( documentoAlmacenadoDto.isEliminado() );
        documentoAlmacenado.setFile( documentoAlmacenadoDto.getFile() );
        documentoAlmacenado.setUrlFile( documentoAlmacenadoDto.getUrlFile() );

        return documentoAlmacenado;
    }
}
