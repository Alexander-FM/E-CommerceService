package com.alexandertutoriales.service.ecommerce.controller;

import java.util.List;

import com.alexandertutoriales.service.ecommerce.entity.dto.GenerarPedidoDTO;
import com.alexandertutoriales.service.ecommerce.entity.dto.PedidoConDetallesDTO;
import com.alexandertutoriales.service.ecommerce.service.PedidoService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

  private final PedidoService service;

  public PedidoController(PedidoService service) {
    this.service = service;
  }

  //LISTAR PEDIDOS CON DETALLES
  @GetMapping("/misPedidos/{idCli}")
  public GenericResponse<List<PedidoConDetallesDTO>> devolverMisComprasConDetalle(@PathVariable int idCli) {
    return this.service.devolverMisCompras(idCli);
  }

  //GUARDAR PEDIDO
  @PostMapping
  public GenericResponse guardarPedido(@RequestBody GenerarPedidoDTO dto) {
    return this.service.guardarPedido(dto);
  }

  //ANULAR PEDIDO
  @DeleteMapping("/{id}")
  public GenericResponse anular(@PathVariable int id) {
    return this.service.anular(id);
  }

  //EXPORTAR PDF DE ORDEN
  @GetMapping("/exportInvoice")
  public ResponseEntity<Resource> exportInvoice(@RequestParam int idCli, @RequestParam int idOrden) {
    return this.service.exportInvoice(idCli, idOrden);
  }

}
