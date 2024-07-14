package br.com.emerlopes.bffecommerce.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@Accessors(chain = true)
public class ShoppingCartDomainEntity {
    private String username;
    private List<ProductShoppingCartDomainEntity> products;
    private BigDecimal total;
}
