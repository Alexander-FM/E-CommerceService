package com.alexandertutoriales.service.ecommerce.service;

import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_OK;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_WARNING;
import static com.alexandertutoriales.service.ecommerce.utils.Global.TIPO_AUTH;
import static com.alexandertutoriales.service.ecommerce.utils.Global.TIPO_DATA;

import java.util.Optional;

import com.alexandertutoriales.service.ecommerce.entity.Usuario;
import com.alexandertutoriales.service.ecommerce.repository.UsuarioRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

  private final UsuarioRepository repository;

  public UsuarioService(UsuarioRepository repository) {
    this.repository = repository;
  }

  //Método para iniciar sesión
  public GenericResponse<Usuario> login(String email, String contrasenia) {
    Optional<Usuario> optU = this.repository.login(email, contrasenia);
    if (optU.isPresent()) {
      return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_OK, "Haz iniciado sesión correctamente", optU.get());
    } else {
      return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_WARNING, "Lo sentimos, ese usuario no es válido", new Usuario());
    }
  }

  public GenericResponse guardarUsuario(Usuario c) {
    Optional<Usuario> opt = this.repository.findById(c.getId());
    int idf = opt.isPresent() ? opt.get().getId() : 0;
    if (idf == 0) {
      return new GenericResponse(TIPO_DATA, RPTA_OK, "Usuario registrado correctamente", this.repository.save(c));
    } else {
      return new GenericResponse(TIPO_DATA, RPTA_OK, "Datos del usuario actualizados", this.repository.save(c));
    }
  }
}

