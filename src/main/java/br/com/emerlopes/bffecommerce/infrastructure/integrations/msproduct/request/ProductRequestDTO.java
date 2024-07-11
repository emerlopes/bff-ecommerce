package br.com.emerlopes.bffecommerce.infrastructure.integrations.msproduct.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDTO {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}
