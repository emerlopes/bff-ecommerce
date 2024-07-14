package br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.response;

import br.com.emerlopes.bffecommerce.domain.shared.OrderStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderResponseDTO {
    private Long id;
    private String username;
    private List<ProductOrderResponseDTO> products;
    private BigDecimal total;
    private OrderStatusEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
