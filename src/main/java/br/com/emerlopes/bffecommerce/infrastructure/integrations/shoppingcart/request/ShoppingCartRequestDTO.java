package br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShoppingCartRequestDTO {
    private List<ShoppingCartProductRequestDTO> products;
}
