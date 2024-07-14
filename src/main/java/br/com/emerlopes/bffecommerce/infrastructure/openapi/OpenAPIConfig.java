package br.com.emerlopes.bffecommerce.infrastructure.openapi;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de E-commerce")
                        .version("1.0")
                        .description("Documentação da API BFF E-commerce")
                        .contact(new Contact().name("Seu Nome").email("seuemail@example.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
