package br.com.emerlopes.bffecommerce.infrastructure.integrations.msproduct.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductReponseDTO {
    private Long id;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("preco")
    private Double price;

    @JsonProperty("quantidade")
    private Integer quantity;
}
