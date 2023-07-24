package com.alexandertutoriales.service.ecommerce.service;

import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_OK;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_WARNING;
import static com.alexandertutoriales.service.ecommerce.utils.Global.TIPO_AUTH;
import com.alexandertutoriales.service.ecommerce.entity.User;
import com.alexandertutoriales.service.ecommerce.entity.dto.UserDto;
import com.alexandertutoriales.service.ecommerce.mapper.UserMapper;
import com.alexandertutoriales.service.ecommerce.repository.UserRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public GenericResponse<UserDto> loginUser(String username, String password) {
        Optional<User> optU = this.repository.loginUser(username, password);
        return optU.map(user -> new GenericResponse<>(TIPO_AUTH, RPTA_OK, "Haz iniciado sesión correctamente", mapper.toDto(user)))
            .orElseGet(() -> new GenericResponse<>(TIPO_AUTH, RPTA_WARNING, "Lo sentimos, ese usuario no es válido", null));
    }
}

