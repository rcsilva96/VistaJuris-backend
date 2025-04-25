package com.techvista.vistajuris;

import org.springframework.boot.SpringApplication;

public class TestVistaJurisApplication {

	public static void main(String[] args) {
		SpringApplication.from(VistaJurisApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
