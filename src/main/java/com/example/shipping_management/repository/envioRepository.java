package com.example.shipping_management.repository;

import com.example.shipping_management.model.envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface envioRepository extends JpaRepository<envio, Integer> {
    // Método personalizado para buscar envíos por idCliente
    List<envio> findByIdCliente(int idCliente);
}