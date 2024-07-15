package br.com.emerlopes.bffecommerce.application.entrypoint.rest.shoppingcart.examples;


import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.response.ShoppingCartResponseDTO;
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
        summary = "Obter carrinho de compras",
        description = "Retorna o carrinho de compras do usuário especificado",
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
                                                                "name": "Shoes",
                                                                "description": "A pair of shoes",
                                                                "price": 913.00,
                                                                "quantity": 2
                                                            }
                                                        ],
                                                        "total": 1826.00
                                                    }
                                                }
                                                """
                                )
                        )
                )
        }
)
public @interface GetShoppingCartByUseNameResponseExample {
}
