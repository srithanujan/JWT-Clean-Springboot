package br.ufscar.dc.dsw.bikerental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
// @OpenAPIDefinition(info = @Info(title = "Library APIS", version = "1.0", description = "Library Management APIs."))
public class VirtualBikeRentalsApplication {
    public static void main(String[] args) {
        SpringApplication.run(VirtualBikeRentalsApplication.class, args);
    }
}
