package com.alexandertutoriales.service.ecommerce.mapperImpl;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

/**
 * Mapper genérico con las operaciones básicas de transformación entre entidades y DTOs, incluyendo List y Page.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 * @author Dagner Anibal Chúman Lluen.
 */
public interface GenericMapper<D, E> {

  /**
   * To entity.
   *
   * @param dto the dto
   * @return the e
   */
  E toEntity(D dto);

  /**
   * To dto.
   *
   * @param entity the entity
   * @return the d
   */
  D toDto(E entity);

  /**
   * To entity.
   *
   * @param dtoList the dto list
   * @return the list
   */
  List<E> toEntity(List<D> dtoList);

  /**
   * To dto.
   *
   * @param entityPage the entity page
   * @return the page
   */
  default Page<D> toDto(Page<E> entityPage) {
    return entityPage.map(data -> toDto(data));
  }

  /**
   * To dto.
   *
   * @param entityList the entity list
   * @return the list
   */
  List<D> toDto(List<E> entityList);

  /**
   * To dto.
   *
   * @param entityList the entity list
   * @return the sets the
   */
  Set<D> toDto(Set<E> entityList);
}
