package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${server.url}")
    private String url;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(url);
        devServer.setDescription("Server URL");

        Contact contact = new Contact();
        contact.setEmail("Chopar");
        contact.setName("Asadbek");
        contact.setUrl("https://www.asadbek.com");


        Info info = new Info()
                .title("Chopar Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials.")
                .termsOfService("https://www.asadbek.com/terms")
                .license(null);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }

}
