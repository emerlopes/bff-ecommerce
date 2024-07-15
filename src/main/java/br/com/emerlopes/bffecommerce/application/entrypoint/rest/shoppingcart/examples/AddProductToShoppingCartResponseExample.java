package br.com.emerlopes.bffecommerce.application.entrypoint.rest.shoppingcart.examples;


import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request.ShoppingCartProductRequestDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.response.ShoppingCartResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
        summary = "Adicionar produto ao carrinho",
        description = "Adiciona um produto ao carrinho de compras do usuário especificado",
        requestBody = @RequestBody(
                content = @Content(
                        schema = @Schema(implementation = ShoppingCartProductRequestDTO.class),
                        examples = @ExampleObject(
                                name = "Add Product Request Example",
                                summary = "Exemplo de JSON para adicionar produto ao carrinho",
                                value = """
                                        {
                                            "name": "Fish",
                                            "description": "Fresh fish",
                                            "price": 848.00,
                                            "quantity": 5
                                        }
                                        """
                        )
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Resposta de sucesso",
                        content = @Content(
                                schema = @Schema(implementation = ShoppingCartResponseDTO.class),
                                examples = @ExampleObject(
                                        name = "Success Response",
                                        summary = "Exemplo de resposta bem-sucedida",
                                        value = """
                                                {
                                                    "data": {
                                                        "username": "emerlopes",
                                                        "products": [
                                                            {
                                                                "name": "Fish",
                                                                "description": "Fresh fish",
                                                                "price": 848.00,
                                                                "quantity": 5
                                                            },
                                                            {
                                                                "name": "Shoes",
                                                                "description": null,
                                                                "price": 913.00,
                                                                "quantity": 2
                                                            }
                                                        ],
                                                        "total": 6066.00
                                                    }
                                                }
                                                """
                                )
                        )
                )
        }
)
public @interface AddProductToShoppingCartResponseExample {
}
