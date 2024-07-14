package br.com.emerlopes.bffecommerce.infrastructure.integrations.mspayment;

import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.mspayment.request.PaymentRequestDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.mspayment.response.PaymentResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "ms-payment", url = "${application.payments.host}/payments")
public interface PaymentClient {

    @PostMapping("/cadastrar-produtos")
    void registerProducts(
            final @RequestHeader(value = "Authorization") String authorization
    );

    @PostMapping("/process/{orderId}")
    CustomResponseDTO<PaymentResponseDTO> processPayment(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable Long orderId,
            final @RequestBody PaymentRequestDTO paymentRequestDTO
    );
}
