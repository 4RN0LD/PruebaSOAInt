package com.soaint.prueba.controller;

import com.soaint.prueba.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteControllerTest {

    @Test
    void registrarCliente() {
        ClienteController controller = new ClienteController();
        Cliente c = new Cliente();
        c.setApellido("ARTEAGA");
        c.setDni("78965412");
        c.setEmail("juan@email.com");
        c.setNombre("JUAN");
        c.setTelefono("+54 987654213");
        controller.registrar(c);
//        Assert.notNull(c.getIdCliente());
    }
}