package br.com.emerlopes.bffecommerce.infrastructure.integrations.msproduct.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductReponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}
