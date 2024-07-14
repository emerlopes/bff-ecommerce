package br.com.emerlopes.bffecommerce.application.entrypoint.rest.ordershoppingcart.examples;

import br.com.emerlopes.bffecommerce.application.entrypoint.rest.ordershoppingcart.dto.UpdateOrderBffRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Operation(
        summary = "Atualização de status do pedido",
        description = "Atualiza o status de um pedido específico de acordo com o número do pedido. Os status disponíveis são: PENDING, IN_PROGRESS, DONE, CANCELED.",
        requestBody = @RequestBody(
                content = @Content(
                        schema = @Schema(implementation = UpdateOrderBffRequestDTO.class),
                        examples = {
                                @ExampleObject(
                                        name = "Update Status Example: IN_PROGRESS",
                                        summary = "Exemplo de JSON para status IN_PROGRESS",
                                        value = """
                                                {
                                                    "status": "IN_PROGRESS"
                                                }
                                                """
                                ),
                                @ExampleObject(
                                        name = "Update Status Example: DONE",
                                        summary = "Exemplo de JSON para status DONE",
                                        value = """
                                                {
                                                    "status": "DONE"
                                                }
                                                """
                                ),
                                @ExampleObject(
                                        name = "Update Status Example: CANCELLED",
                                        summary = "Exemplo de JSON para status CANCELLED",
                                        value = """
                                                {
                                                    "status": "CANCELLED"
                                                }
                                                """
                                )
                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Resposta de sucesso",
                        content = @Content(
                                schema = @Schema(implementation = UpdateOrderBffRequestDTO.class),
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
public @interface UpdateOrdersCheckoutRequestBodyExample {
}