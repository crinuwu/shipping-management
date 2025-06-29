package com.example.shipping_management;

import com.example.shipping_management.model.envio;
import com.example.shipping_management.repository.envioRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private envioRepository envioRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        String[] estados = {"pendiente", "en tránsito", "entregado", "cancelado"};

        for (int i = 0; i < 50; i++) {
            envio envio = new envio();

            envio.setIdCliente(faker.number().numberBetween(1, 100));
            envio.setIdPaquete(faker.number().numberBetween(1000, 2000));
            envio.setIdRuta(faker.address().zipCode());
            envio.setDireccionEntrega(faker.address().fullAddress());

            // Generar fecha en formato DD-MM-YYYY (simplificado)
            int fechaEnvio = Integer.parseInt(faker.date().past(30, java.util.concurrent.TimeUnit.DAYS)
                    .toInstant().toString().substring(0, 10).replaceAll("-", ""));
            envio.setFechaEnvio(fechaEnvio);

            envio.setEstadoEnvio(estados[random.nextInt(estados.length)]);

            int fechaEntregaEstimada = Integer.parseInt(faker.date().future(10, java.util.concurrent.TimeUnit.DAYS)
                    .toInstant().toString().substring(0, 10).replaceAll("-", ""));
            envio.setFechaEntregaEstimada(fechaEntregaEstimada);

            // fechaEntregaReal solo si estado es "entregado"
            if ("entregado".equals(envio.getEstadoEnvio())) {
                int fechaEntregaReal = Integer.parseInt(faker.date().between(
                        faker.date().past(30, java.util.concurrent.TimeUnit.DAYS),
                        faker.date().future(5, java.util.concurrent.TimeUnit.DAYS))
                        .toInstant().toString().substring(0, 10).replaceAll("-", ""));
                envio.setFechaEntregaReal(fechaEntregaReal);
            } else {
                envio.setFechaEntregaReal(0); // como nullable es int, usamos 0 para "sin fecha"
            }

            envioRepository.save(envio);
        }
    }
}

