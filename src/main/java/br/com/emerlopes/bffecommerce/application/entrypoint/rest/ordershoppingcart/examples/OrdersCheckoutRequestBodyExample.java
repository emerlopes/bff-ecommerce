package br.com.emerlopes.bffecommerce.application.entrypoint.rest.ordershoppingcart.examples;

import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request.OrderRequestDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.response.OrderResponseDTO;
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
        summary = "Realizar checkout",
        description = "Cria um pedido com os produtos do carrinho de compras",
        requestBody = @RequestBody(
                content = @Content(
                        schema = @Schema(implementation = OrderRequestDTO.class),
                        examples = {
                                @ExampleObject(
                                        name = "Checkout Example",
                                        summary = "Exemplo de JSON para checkout",
                                        value = """
                                                {
                                                  "username": "emerlopes",
                                                  "products": [
                                                    {
                                                      "name": "Playstation 5",
                                                      "description": "The PlayStation 5 is a home video game console developed by Sony Interactive Entertainment. Announced in 2019 as the successor to the PlayStation 4, the PS5 was released on November 12, 2020, in Australia, Japan, New Zealand, North America, and South Korea, with worldwide release following a week later.",
                                                      "price": 100.00,
                                                      "quantity": 99
                                                    },
                                                    {
                                                      "name": "Xbox Series X",
                                                      "description": "The Xbox Series X and Series S are home video game consoles developed by Microsoft. They were both released on November 10, 2020, as the fourth generation of the Xbox console family, succeeding the Xbox One family.",
                                                      "price": 200.00,
                                                      "quantity": 99
                                                    },
                                                    {
                                                      "name": "Nintendo Switch",
                                                      "description": "The Nintendo Switch is a video game console developed by Nintendo, released worldwide in most regions on March 3, 2017. It is a hybrid console that can be used as a home console and portable device.",
                                                      "price": 300.00,
                                                      "quantity": 99
                                                    }
                                                  ]
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
                                schema = @Schema(implementation = OrderResponseDTO.class),
                                examples = @ExampleObject(
                                        name = "Success Response",
                                        summary = "Exemplo de resposta bem-sucedida",
                                        value = """
                                                {
                                                    "data": {
                                                        "id": 123,
                                                        "username": "emerlopes",
                                                        "products": [
                                                            {
                                                                "name": "Playstation 5",
                                                                "description": "The PlayStation 5 is a home video game console developed by Sony Interactive Entertainment. Announced in 2019 as the successor to the PlayStation 4, the PS5 was released on November 12, 2020, in Australia, Japan, New Zealand, North America, and South Korea, with worldwide release following a week later.",
                                                                "price": 100.00,
                                                                "quantity": 99
                                                            },
                                                            {
                                                                "name": "Xbox Series X",
                                                                "description": "The Xbox Series X and Series S are home video game consoles developed by Microsoft. They were both released on November 10, 2020, as the fourth generation of the Xbox console family, succeeding the Xbox One family.",
                                                                "price": 200.00,
                                                                "quantity": 99
                                                            },
                                                            {
                                                                "name": "Nintendo Switch",
                                                                "description": "The Nintendo Switch is a video game console developed by Nintendo, released worldwide in most regions on March 3, 2017. It is a hybrid console that can be used as a home console and portable device.",
                                                                "price": 300.00,
                                                                "quantity": 99
                                                            }
                                                        ],
                                                        "total": 600.00,
                                                        "orderStatusEnum": "PENDING",
                                                        "createdAt": "2024-07-14T16:27:52.34932",
                                                        "updatedAt": null
                                                    }
                                                }
                                                """
                                )
                        )
                )
        }
)
public @interface OrdersCheckoutRequestBodyExample {
}