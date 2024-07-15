package br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller.examples;

import br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller.request.RegisterUserRequestBffDTO;
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
        summary = "Registrar usuário",
        description = "Registra um novo usuário na plataforma",
        requestBody = @RequestBody(
                content = @Content(
                        schema = @Schema(implementation = RegisterUserRequestBffDTO.class),
                        examples = @ExampleObject(
                                name = "Register User Request Example",
                                summary = "Exemplo de JSON para registrar usuário",
                                value = """
                                        {
                                            "username": "user",
                                            "password": "password"
                                        }
                                        """
                        )
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "204",
                        description = "Usuário registrado com sucesso",
                        content = @Content(mediaType = "application/json")
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Erro interno no servidor",
                        content = @Content(mediaType = "application/json")
                )
        }
)
public @interface RegisterUserResponseExample {
}
