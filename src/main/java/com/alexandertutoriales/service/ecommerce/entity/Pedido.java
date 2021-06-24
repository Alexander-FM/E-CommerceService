package com.alexandertutoriales.service.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fechaCompra;
    @OneToOne
    private Cliente cliente;
    @Column
    private Double monto;
    @Column
    private boolean anularPedido;

}
