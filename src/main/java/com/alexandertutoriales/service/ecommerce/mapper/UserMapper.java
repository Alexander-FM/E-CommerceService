package com.alexandertutoriales.service.ecommerce.mapper;

import com.alexandertutoriales.service.ecommerce.entity.User;
import com.alexandertutoriales.service.ecommerce.entity.dto.UserDto;
import com.alexandertutoriales.service.ecommerce.mapperImpl.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDto, User> {
  @Override
  UserDto toDto(User user);

  @Override
  User toEntity(UserDto userDto);
}
