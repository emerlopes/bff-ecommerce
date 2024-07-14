package br.com.emerlopes.bffecommerce.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductShoppingCartDomainEntity {
    private String username;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
