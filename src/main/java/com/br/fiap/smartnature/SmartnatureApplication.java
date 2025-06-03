package com.br.fiap.smartnature;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "SmartNature API",
				version = "1.0",
				description = "API para monitoramento ambiental com sensores IoT e alertas de queimadas",
				contact = @Contact(
						name = "Equipe SmartNature",
						email = "contato@smartnature.com.br"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0.html"
				)
		),
		servers = @Server(
				url = "http://localhost:8080",
				description = "Servidor local de desenvolvimento"
		)
)
@SpringBootApplication
public class SmartnatureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartnatureApplication.class, args);
	}
}