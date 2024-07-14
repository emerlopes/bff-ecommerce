package br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart;

import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request.ShoppingCartProductRequestDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.response.ShoppingCartResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "shoppingcart", url = "${application.shoppingcart.host}/shopping-carts")
public interface ShoppingCartClient {

    @PostMapping("/register/{username}")
    CustomResponseDTO<ShoppingCartResponseDTO> registerCart(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("username") String username
    );

    @GetMapping("/{username}")
    CustomResponseDTO<ShoppingCartResponseDTO> getShoppingCartByUsername(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("username") String username
    );

    @PostMapping("/add-product/{username}")
    CustomResponseDTO<ShoppingCartResponseDTO> addProductToShoppingCart(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("username") String username,
            final @RequestBody ShoppingCartProductRequestDTO shoppingCartProductRequestDTO
    );

    @PostMapping("/remove-product/{username}")
    CustomResponseDTO<ShoppingCartResponseDTO> removeProductFromShoppingCart(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("username") String username,
            final @RequestBody ShoppingCartProductRequestDTO shoppingCartProductRequestDTO
    );

}
