package com.eci.register.pet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
@OpenAPIDefinition(servers = { @Server(url = "https://refactored-tribble-wrxg49pwwghvq45-8080.app.github.dev/") })
public class SwaggerConf {                                    
    
    @Bean
    OpenAPI api() { 
        return new OpenAPI()
        .info(new Info()
        .title("Pet Register Api")
        .version("1.0.0")
        .description("Api correspondiente al subdominio de mascota"));
    }
}