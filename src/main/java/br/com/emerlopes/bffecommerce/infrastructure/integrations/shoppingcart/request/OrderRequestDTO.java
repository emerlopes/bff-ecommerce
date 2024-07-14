package br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequestDTO {
    private String username;
    private List<ProductRequestDTO> products;
    private String status;
}
