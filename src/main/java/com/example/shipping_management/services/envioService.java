package com.example.shipping_management.services;

import com.example.shipping_management.model.envio;
import com.example.shipping_management.repository.envioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class envioService {
    @Autowired
    private envioRepository envioRepository;

    // Método que retorna todos los envíos
    public List<envio> getEnvios() {
        return envioRepository.findAll();
    }

    // Método que busca un envío por id
    public envio getEnvioById(int idEnvio) {
        return envioRepository.findById(idEnvio).orElse(null);
    }

    // Método que guarda un envío
    public void saveEnvio(envio envio) {
        envioRepository.save(envio);
    }

    // Método que actualiza un envío
    public void updateEnvio(envio envio) {
        envioRepository.save(envio); // `save` también actualiza si el ID ya existe
    }

    // Método que elimina un envío
    public void deleteEnvio(int idEnvio) {
        envioRepository.deleteById(idEnvio);
    }

    // Método que busca envíos por idCliente
    public List<envio> getEnviosByIdCliente(int idCliente) {
        return envioRepository.findByIdCliente(idCliente);
    }
}
