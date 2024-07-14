package br.com.emerlopes.bffecommerce.application.entrypoint.rest.ordershoppingcart.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateOrderBffRequestDTO {
    private String status;
}
