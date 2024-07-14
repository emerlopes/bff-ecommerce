package br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart;

import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request.OrderRequestDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.response.OrderResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "order", url = "${application.shoppingcart.host}/orders")
public interface OrderShoppingCartClient {

    @PostMapping("/checkout")
    ResponseEntity<CustomResponseDTO<OrderResponseDTO>> checkout(
            final @RequestHeader(value = "Authorization") String authorization,
            final @RequestBody OrderRequestDTO orderRequestDTO
    );

    @PostMapping("/update-status/{orderId}")
    ResponseEntity<CustomResponseDTO<OrderResponseDTO>> updateOrderStatus(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("orderId") Long orderId,
            final @RequestBody OrderRequestDTO orderRequestDTO
    );

    @GetMapping("/{orderId}")
    ResponseEntity<CustomResponseDTO<OrderResponseDTO>> findOrderById(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("orderId") Long orderId
    );

    @GetMapping("/user/{username}")
    ResponseEntity<CustomResponseDTO<List<OrderResponseDTO>>> findOrderByUsername(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("username") String username
    );


}
