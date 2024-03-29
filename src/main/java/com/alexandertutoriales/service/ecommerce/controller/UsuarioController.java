package com.alexandertutoriales.service.ecommerce.controller;

import com.alexandertutoriales.service.ecommerce.entity.Usuario;
import com.alexandertutoriales.service.ecommerce.service.UsuarioService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

  private final UsuarioService service;

  public UsuarioController(UsuarioService service) {
    this.service = service;
  }

  @PostMapping("/login")
  public GenericResponse<Usuario> login(HttpServletRequest request) {
    String email = request.getParameter("email");
    String contrasenia = request.getParameter("pass");
    return this.service.login(email, contrasenia);
  }

  @PostMapping
  public GenericResponse save(@RequestBody Usuario u) {
    return this.service.guardarUsuario(u);
  }

  @PutMapping("/{id}")
  public GenericResponse update(@PathVariable int id, @RequestBody Usuario u) {
    u.setId(id);
    return this.service.guardarUsuario(u);
  }

}
