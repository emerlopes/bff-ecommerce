package br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ShoppingCartProductRequestDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
