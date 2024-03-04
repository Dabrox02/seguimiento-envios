package com.campusjaider.seguimientoenvios;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.campusjaider.seguimientoenvios.domain.service.DireccionService;
import com.campusjaider.seguimientoenvios.persistence.entity.Direccion;

@SpringBootApplication
public class SeguimientoEnviosApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SeguimientoEnviosApplication.class, args);

		DireccionService direccionService = context.getBean(DireccionService.class);

        Direccion direccion1 = new Direccion();
        Direccion direccion2 = new Direccion();

        direccion1.setCalle("123 Calle Principal");
        direccion1.setCiudad("Ciudad Uno");
        direccion1.setEstado("Estado Uno");
        direccion1.setCodigoPostal("12345");

        direccion2.setCalle("456 Calle Secundaria");
        direccion2.setCiudad("Ciudad Dos");
        direccion2.setEstado("Estado Dos");
        direccion2.setCodigoPostal("54321");

		direccionService.save(direccion1);
		direccionService.save(direccion2);


        // Direcciones

		List<Direccion> direcciones = direccionService.getAll();
		for (Direccion direccion : direcciones) {
			System.out.println(direccion);
		}







	}

}
