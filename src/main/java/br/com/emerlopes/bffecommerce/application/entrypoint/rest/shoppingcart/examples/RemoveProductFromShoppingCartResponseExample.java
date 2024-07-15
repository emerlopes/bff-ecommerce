package br.com.emerlopes.bffecommerce.application.entrypoint.rest.shoppingcart.examples;

import br.com.emerlopes.bffecommerce.infrastructure.integrations.msproduct.request.ProductRequestDTO;
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
        summary = "Remover produto do carrinho",
        description = "Remove um produto do carrinho de compras do usuário especificado",
        requestBody = @RequestBody(
                content = @Content(
                        schema = @Schema(implementation = ProductRequestDTO.class),
                        examples = @ExampleObject(
                                name = "Remove Product Request Example",
                                summary = "Exemplo de JSON para remover produto do carrinho",
                                value = """
                                        {
                                            "name": "Shoes"
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
                                                        "products": [],
                                                        "total": 0
                                                    }
                                                }
                                                """
                                )
                        )
                )
        }
)
public @interface RemoveProductFromShoppingCartResponseExample {
}
