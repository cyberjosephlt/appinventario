package com.unab.edu.co.grupo69.appinventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AppinventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppinventarioApplication.class, args);
	}

// Add the controller.
@RestController
class InfoApi {
  @GetMapping("/")
  public String info() {
    return "Hola, Soy una app de SpringBoot!, desarrollada para MISIONTIC 2022";
  	}

	}
}

