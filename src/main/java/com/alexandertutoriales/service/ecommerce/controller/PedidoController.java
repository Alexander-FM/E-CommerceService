package com.alexandertutoriales.service.ecommerce.controller;

import com.alexandertutoriales.service.ecommerce.entity.Pedido;
import com.alexandertutoriales.service.ecommerce.entity.dto.PedidoConDetallesDTO;
import com.alexandertutoriales.service.ecommerce.service.PedidoService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping("/misPedidos/{idCli}")
    public GenericResponse<List<PedidoConDetallesDTO>> devolverMisComprasConDetalle(@PathVariable int idCli) {
        return this.service.devolverMisCompras(idCli);
    }
}
