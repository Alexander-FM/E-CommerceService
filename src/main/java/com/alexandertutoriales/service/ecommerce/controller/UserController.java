package com.alexandertutoriales.service.ecommerce.controller;

import com.alexandertutoriales.service.ecommerce.entity.dto.UserDto;
import com.alexandertutoriales.service.ecommerce.service.UserService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public GenericResponse<UserDto> filtrar(@Valid @RequestBody() UserDto userDto) {
        return this.service.loginUser(userDto.getUsername(), userDto.getPassword());
    }
}
