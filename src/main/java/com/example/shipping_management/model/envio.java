package com.example.shipping_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "envios")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnvio;

    @Column(nullable = false)
    private int idCliente;

    @Column(unique = true, nullable = false)
    private int idPaquete;

    @Column(nullable = false)
    private String idRuta;

    @Column(nullable = false)
    private String direccionEntrega;

    @Column(nullable = false)
    private int fechaEnvio; //formato DDMMYYYY

    @Column(nullable = false)
    private String estadoEnvio;

    @Column(nullable = false)
    private int fechaEntregaEstimada; //formato DDMMYYYY
    
    @Column(nullable = true)
    private int fechaEntregaReal; // Se puede dejar como null si no se ha entregado aún
}
