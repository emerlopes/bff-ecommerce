package br.com.emerlopes.bffecommerce.application.entrypoint.rest;

import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.domain.entity.PaymentDomainEntity;
import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.domain.usecase.payment.ProcessPaymentUseCase;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.mspayment.request.PaymentRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final ProcessPaymentUseCase processPaymentUseCase;

    public PaymentController(ProcessPaymentUseCase processPaymentUseCase) {
        this.processPaymentUseCase = processPaymentUseCase;
    }

    @PostMapping("/process/{orderId}")
    public ResponseEntity<?> processPayment(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable Long orderId,
            final @RequestBody PaymentRequestDTO paymentRequestDTO
    ) {

        RequestParametersStore.removeAuthorization();
        RequestParametersStore.setAuthorization(authorization);

        final var executionResponse = processPaymentUseCase.execute(
                PaymentDomainEntity.builder()
                        .orderId(orderId)
                        .paymentMethod(paymentRequestDTO.getPaymentMethod())
                        .amount(paymentRequestDTO.getAmount())
                        .build()

        );
        return ResponseEntity.status(HttpStatus.OK).body(
                new CustomResponseDTO<>().setData(executionResponse)
        );
    }
}
