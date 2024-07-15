package br.com.emerlopes.bffecommerce.application.entrypoint.rest.product.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateProductRequestBffDTO {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}
