package br.com.emerlopes.bffecommerce.application.entrypoint.rest.product.examples;


import br.com.emerlopes.bffecommerce.application.entrypoint.rest.product.request.UpdateProductRequestBffDTO;
import br.com.emerlopes.bffecommerce.domain.entity.ProductDomainEntity;
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
        summary = "Atualizar do estoque do produto",
        description = "Atualiza o estoque de um produto específico",
        requestBody = @RequestBody(
                content = @Content(
                        schema = @Schema(implementation = UpdateProductRequestBffDTO.class),
                        examples = @ExampleObject(
                                name = "Update Price Request Example",
                                summary = "Exemplo de JSON para atualizar preço do produto",
                                value = """
                                        {
                                            "stock": 12
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
                                schema = @Schema(implementation = ProductDomainEntity.class),
                                examples = @ExampleObject(
                                        name = "Success Response",
                                        summary = "Exemplo de resposta bem-sucedida",
                                        value = """
                                                {
                                                    "data": {
                                                        "id": 1,
                                                        "name": "Laptop Gamer",
                                                        "description": "gaming laptop",
                                                        "price": 15.0,
                                                        "quantity": 12,
                                                        "available": true
                                                    }
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
public @interface UpdateStockProductResponseExample {
}
