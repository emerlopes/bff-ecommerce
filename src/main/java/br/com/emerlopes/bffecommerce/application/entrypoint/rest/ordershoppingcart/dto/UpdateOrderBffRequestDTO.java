package br.com.emerlopes.bffecommerce.application.entrypoint.rest.ordershoppingcart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderBffRequestDTO {
    private String status;
}
