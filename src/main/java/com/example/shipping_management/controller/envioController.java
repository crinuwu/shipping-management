package com.example.shipping_management.controller;

import com.example.shipping_management.model.envio;
import com.example.shipping_management.services.envioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/envios")
public class envioController {

    @Autowired
    private envioService envioService;

    @GetMapping
    public List<envio> getEnvios() {
        return envioService.getEnvios();
    }

    @PostMapping
    public envio agregarEnvio(@RequestBody envio envio) {
        envioService.saveEnvio(envio);
        return envio;
    }

    @GetMapping("/{idEnvio}")
    public envio getEnvioById(@PathVariable int idEnvio) { // Cambiado de String a int
        return envioService.getEnvioById(idEnvio);
    }

    @PutMapping("/{idEnvio}")
    public envio updateEnvio(@PathVariable int idEnvio, @RequestBody envio envio) { // Cambiado de String a int
        envio.setIdEnvio(idEnvio); // Asegurarse de que el ID del envío se mantenga igual
        envioService.updateEnvio(envio);
        return envio;
    }

    @DeleteMapping("/{idEnvio}")
    public void deleteEnvio(@PathVariable int idEnvio) { // Cambiado de String a int
        envioService.deleteEnvio(idEnvio);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<envio> getEnviosByIdCliente(@PathVariable int idCliente) {
        return envioService.getEnviosByIdCliente(idCliente);
    }
}
