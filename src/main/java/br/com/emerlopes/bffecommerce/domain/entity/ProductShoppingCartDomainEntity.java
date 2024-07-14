package br.com.emerlopes.bffecommerce.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductShoppingCartDomainEntity {
    private String username;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
