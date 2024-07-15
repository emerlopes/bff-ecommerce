package br.com.emerlopes.bffecommerce.application.entrypoint.rest.product.examples;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Operation(
        summary = "Registrar produtos",
        description = "Registra novos produtos na plataforma",
        responses = {
                @ApiResponse(
                        responseCode = "204",
                        description = "No Content",
                        content = @Content(mediaType = "application/json")
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal Server Error",
                        content = @Content(mediaType = "application/json")
                )
        }
)
public @interface RegisterProductsResponseExample {
}
