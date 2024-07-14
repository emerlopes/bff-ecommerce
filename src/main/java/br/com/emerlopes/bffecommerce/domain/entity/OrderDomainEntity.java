package br.com.emerlopes.bffecommerce.domain.entity;

import br.com.emerlopes.bffecommerce.domain.shared.OrderStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderDomainEntity {
    private Long id;
    private String username;
    private List<ProductShoppingCartDomainEntity> products;
    private BigDecimal total;
    private OrderStatusEnum orderStatusEnum;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
