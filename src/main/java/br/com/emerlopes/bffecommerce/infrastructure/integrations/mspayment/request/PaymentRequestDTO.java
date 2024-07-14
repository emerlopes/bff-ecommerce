package br.com.emerlopes.bffecommerce.infrastructure.integrations.mspayment.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentRequestDTO {
    private Long orderId;
    private String paymentMethod;
    private BigDecimal amount;
}
