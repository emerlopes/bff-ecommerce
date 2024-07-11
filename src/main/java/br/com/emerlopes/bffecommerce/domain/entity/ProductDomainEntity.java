package br.com.emerlopes.bffecommerce.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDomainEntity {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private boolean available;
}
