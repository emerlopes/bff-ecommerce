package br.com.emerlopes.bffecommerce.application.entrypoint.rest.ordershoppingcart.examples;

import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.response.OrderResponseDTO;
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
        summary = "Encontrar pedido por ID",
        description = "Retorna um pedido específico pelo ID",
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Resposta de sucesso",
                        content = @Content(
                                schema = @Schema(implementation = OrderResponseDTO.class),
                                examples = @ExampleObject(
                                        name = "Success Response",
                                        summary = "Exemplo de resposta bem-sucedida",
                                        value = """
                                                {
                                                    "data": {
                                                        "id": 1,
                                                        "username": "emerlopes",
                                                        "products": [
                                                            {
                                                                "name": "Bike",
                                                                "description": "New ABC 13 9370, 13.3, 5th Gen CoreA5-8250U, 8GB RAM, 256GB SSD, power UHD Graphics, OS 10 Home, OS Office A & J 2016",
                                                                "price": 306.00,
                                                                "quantity": 2
                                                            },
                                                            {
                                                                "name": "Pants",
                                                                "description": "The Apollotech B340 is an affordable wireless mouse with reliable connectivity, 12 months battery life and modern design",
                                                                "price": 247.00,
                                                                "quantity": 1
                                                            }
                                                        ],
                                                        "total": 859.00,
                                                        "orderStatusEnum": "IN_PROGRESS",
                                                        "createdAt": "2024-07-14T16:20:15.921333",
                                                        "updatedAt": "2024-07-14T16:25:25.125449"
                                                    }
                                                }
                                                """
                                )
                        )
                )
        }
)
public @interface FindOrderByIdResponseExamples {
}