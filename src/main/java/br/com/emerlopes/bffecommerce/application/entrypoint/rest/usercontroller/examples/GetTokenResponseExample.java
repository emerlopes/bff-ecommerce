package br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller.examples;

import br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller.response.UserTokenResponseBffDTO;
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
        summary = "Obter token",
        description = "Gera um token para o usuário com base nas credenciais fornecidas",
        responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Token gerado com sucesso",
                        content = @Content(
                                schema = @Schema(implementation = UserTokenResponseBffDTO.class),
                                examples = @ExampleObject(
                                        name = "Success Response",
                                        summary = "Exemplo de resposta bem-sucedida",
                                        value = """
                                                {
                                                    "data": {
                                                        "username": "user_guest",
                                                        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBUEkiLCJzdWIiOiJ1c2VyX2d1ZXN0Iiwicm9sZXMiOlsiW0dVRVNUXSJdLCJleHAiOjE3MjA3MzY5OTB9.u7ynaKh5uOWDMWII8VMQo6xoP5LVxABLYqrVUh7WATg"
                                                    }
                                                }
                                                """
                                )
                        )
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Erro interno no servidor",
                        content = @Content(mediaType = "application/json")
                )
        }
)
public @interface GetTokenResponseExample {
}
