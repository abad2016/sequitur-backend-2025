package com.sequitur.api.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name = "sequiturOpenApi")
    public OpenAPI sequiturOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("API")
                        .description("OpenAPI 3.0"))
                .servers(List.of(new Server().url("https://sequitur-backend-2025-production.up.railway.app")));         
    }
}
