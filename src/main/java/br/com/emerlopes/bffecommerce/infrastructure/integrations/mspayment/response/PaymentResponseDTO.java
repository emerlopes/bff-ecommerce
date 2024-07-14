package br.com.emerlopes.bffecommerce.infrastructure.integrations.mspayment.response;

import br.com.emerlopes.bffecommerce.application.shared.response.PaymentStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentResponseDTO {
    private Long paymentId;
    private Long orderId;
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private BigDecimal amount;
    private PaymentStatusEnum status;
}
