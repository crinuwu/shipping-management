package com.example.shipping_management;
import com.example.shipping_management.model.envio;
import com.example.shipping_management.repository.envioRepository;
import com.example.shipping_management.services.envioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class envioServiceTest {
    @Autowired
    private envioService envioService;

    @MockBean
    private envioRepository envioRepository;

    @Test
    public void testGetEnvios(){
        when(envioRepository.findAll()).thenReturn(List.of(new envio(1 , 1, 1, "1", "hay que anotar algo", 26-06-2025, "entregado", 26-06-2025, 0)));
    }

    List<envio> envios = envioService.findAll();

    assertNotNull(envios);
    assertEquals(expect:1, envios.size());
}
