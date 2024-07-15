package br.com.emerlopes.bffecommerce.application.entrypoint.rest.product.examples;

import br.com.emerlopes.bffecommerce.domain.entity.ProductDomainEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Operation(
        summary = "Obter produtos",
        description = "Retorna uma lista de produtos registrados",
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Resposta de sucesso",
                        content = @Content(
                                schema = @Schema(implementation = ProductDomainEntity.class),
                                examples = @ExampleObject(
                                        name = "Success Response",
                                        summary = "Exemplo de resposta bem-sucedida",
                                        value = """
                                                {
                                                    "data": [
                                                        {
                                                            "id": 1,
                                                            "name": "Laptop",
                                                            "description": "A high-end gaming laptop",
                                                            "price": 1501.0,
                                                            "quantity": 1,
                                                            "available": true
                                                        },
                                                        {
                                                            "id": 2,
                                                            "name": "Laptop",
                                                            "description": "Portable computer",
                                                            "price": 1299.99,
                                                            "quantity": 30,
                                                            "available": true
                                                        }
                                                    ]
                                                }
                                                """
                                )
                        )
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal Server Error",
                        content = @Content(mediaType = "application/json")
                )
        }
)
public @interface GetProductsResponseExample {
}
