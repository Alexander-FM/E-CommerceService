package com.alexandertutoriales.service.ecommerce.service;

import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_OK;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_WARNING;
import static com.alexandertutoriales.service.ecommerce.utils.Global.TIPO_DATA;
import static com.alexandertutoriales.service.ecommerce.utils.Global.TIPO_RESULT;

import java.util.Optional;

import com.alexandertutoriales.service.ecommerce.entity.Cliente;
import com.alexandertutoriales.service.ecommerce.repository.ClienteRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClienteService {
  private final ClienteRepository repository;

  public ClienteService(ClienteRepository repository) {
    this.repository = repository;
  }

  //GUARDAR Y ACTUALIZAR CLIENTE
  public GenericResponse save(Cliente c) {
    Optional<Cliente> opt = this.repository.findById(c.getId());
    int idf = opt.map(Cliente::getId).orElse(0);
    //NUEVO REGISTRO
    if (idf == 0) {
      if (repository.existByDoc(c.getNumDoc().trim()) == 1) {
        return new GenericResponse(TIPO_RESULT, RPTA_WARNING,
            "Lo sentimos: Ya existe un cliente con ese mismo documento, y si el problema persiste comuníquese con soporte técnico.", null);
      } else {
        //GUARDA
        c.setId(idf);
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Cliente registrado correctamente", this.repository.save(c));
      }
    } else {
      //ACTUALIZAR REGISTRO
      if (repository.existByDocForUpdate(c.getNumDoc().trim(), c.getId()) == 1) {
        return new GenericResponse(TIPO_RESULT, RPTA_WARNING,
            "Error: Ya existe un cliente con esos mismos datos. verifíque e intente de nuevo!.", null);
      } else {
        //ACTUALIZA
        c.setId(idf);
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Datos del cliente actualizado", this.repository.save(c));
      }
    }
  }
}
