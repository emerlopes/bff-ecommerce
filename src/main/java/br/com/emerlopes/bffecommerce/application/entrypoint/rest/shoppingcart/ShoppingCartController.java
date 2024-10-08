package br.com.emerlopes.bffecommerce.application.entrypoint.rest.shoppingcart;

import br.com.emerlopes.bffecommerce.application.entrypoint.rest.shoppingcart.examples.AddProductToShoppingCartResponseExample;
import br.com.emerlopes.bffecommerce.application.entrypoint.rest.shoppingcart.examples.GetShoppingCartByUseNameResponseExample;
import br.com.emerlopes.bffecommerce.application.entrypoint.rest.shoppingcart.examples.RemoveProductFromShoppingCartResponseExample;
import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.domain.entity.ProductShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.entity.ShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.domain.usecase.shoppingcart.AddProductToShoppingCartByUsernameUseCase;
import br.com.emerlopes.bffecommerce.domain.usecase.shoppingcart.GetShoppingCartByUsernameUseCase;
import br.com.emerlopes.bffecommerce.domain.usecase.shoppingcart.RemoveProductFromShoppingCartByUsernameUseCase;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.msproduct.request.ProductRequestDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request.ShoppingCartProductRequestDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.response.ProductDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.response.ShoppingCartResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shopping-carts")
@Tag(name = "Shopping Carts", description = "API para gerenciamento de carrinhos de compras")
public class ShoppingCartController {

    private final GetShoppingCartByUsernameUseCase getShoppingCartByUsernameUseCase;
    private final AddProductToShoppingCartByUsernameUseCase addProductToShoppingCartByUsernameUseCase;
    private final RemoveProductFromShoppingCartByUsernameUseCase removeProductFromShoppingCartByUsernameUseCase;

    public ShoppingCartController(
            final GetShoppingCartByUsernameUseCase getShoppingCartByUsernameUseCase,
            final AddProductToShoppingCartByUsernameUseCase addProductToShoppingCartByUsernameUseCase,
            final RemoveProductFromShoppingCartByUsernameUseCase removeProductFromShoppingCartByUsernameUseCase
    ) {
        this.getShoppingCartByUsernameUseCase = getShoppingCartByUsernameUseCase;
        this.addProductToShoppingCartByUsernameUseCase = addProductToShoppingCartByUsernameUseCase;
        this.removeProductFromShoppingCartByUsernameUseCase = removeProductFromShoppingCartByUsernameUseCase;
    }

    @GetMapping("/{username}")
    @GetShoppingCartByUseNameResponseExample
    public ResponseEntity<?> getShoppingCartByUsername(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("username") String username
    ) {

        RequestParametersStore.removeAuthorization();
        RequestParametersStore.setAuthorization(authorization);

        final var executionResult = getShoppingCartByUsernameUseCase.execute(username);
        return getShoppingCartResponseDTO(executionResult);
    }

    @PostMapping("/add-product/{username}")
    @AddProductToShoppingCartResponseExample
    public ResponseEntity<?> addProductToShoppingCart(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("username") String username,
            final @RequestBody ShoppingCartProductRequestDTO productRequestDTO
    ) {

        RequestParametersStore.removeAuthorization();
        RequestParametersStore.setAuthorization(authorization);

        final var executionResult = addProductToShoppingCartByUsernameUseCase.execute(
                ProductShoppingCartDomainEntity.builder()
                        .username(username)
                        .name(productRequestDTO.getName())
                        .description(productRequestDTO.getDescription())
                        .price(productRequestDTO.getPrice())
                        .quantity(productRequestDTO.getQuantity())
                        .build()
        );

        return getShoppingCartResponseDTO(executionResult);
    }

    @PostMapping("/remove-product/{username}")
    @RemoveProductFromShoppingCartResponseExample
    public ResponseEntity<?> removeProductFromShoppingCart(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("username") String username,
            final @RequestBody ProductRequestDTO productRequestDTO
    ) {

        RequestParametersStore.removeAuthorization();
        RequestParametersStore.setAuthorization(authorization);

        final var executionResult = removeProductFromShoppingCartByUsernameUseCase.execute(
                ProductShoppingCartDomainEntity.builder()
                        .username(username)
                        .name(productRequestDTO.getName())
                        .build()
        );

        return getShoppingCartResponseDTO(executionResult);
    }

    private ResponseEntity<?> getShoppingCartResponseDTO(
            final ShoppingCartDomainEntity executionResult
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new CustomResponseDTO<>().setData(ShoppingCartResponseDTO.builder()
                        .username(executionResult.getUsername())
                        .products(executionResult.getProducts().stream()
                                .map(p -> ProductDTO.builder()
                                        .name(p.getName())
                                        .description(p.getDescription())
                                        .price(p.getPrice())
                                        .quantity(p.getQuantity())
                                        .build()
                                ).toList())
                        .total(executionResult.getTotal())
                        .build())
        );
    }

}
