package br.com.emerlopes.bffecommerce.application.entrypoint.rest.payment.examples;

import br.com.emerlopes.bffecommerce.infrastructure.integrations.mspayment.request.PaymentRequestDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.mspayment.response.PaymentResponseDTO;
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
        summary = "Processar pagamento",
        description = "Processa o pagamento de um pedido específico",
        requestBody = @RequestBody(
                content = @Content(
                        schema = @Schema(implementation = PaymentRequestDTO.class),
                        examples = @ExampleObject(
                                name = "Payment Request Example",
                                summary = "Exemplo de JSON para processar pagamento",
                                value = """
                                        {
                                            "paymentMethod": "CREDIT_CARD",
                                            "amount": 500.00
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
                                schema = @Schema(implementation = PaymentResponseDTO.class),
                                examples = @ExampleObject(
                                        name = "Success Response",
                                        summary = "Exemplo de resposta bem-sucedida",
                                        value = """
                                                {
                                                    "data": {
                                                        "paymentId": 1,
                                                        "orderId": 123,
                                                        "paymentStatus": "APPROVED",
                                                        "amount": 500.00,
                                                        "paymentMethod": "CREDIT_CARD",
                                                        "createdAt": "2024-07-14T16:27:52.34932"
                                                    }
                                                }
                                                """
                                )
                        )
                )
        }
)
public @interface ProcessPaymentRequestResponseExamples {
}