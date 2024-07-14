package br.com.emerlopes.bffecommerce.application.entrypoint.rest;

import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.domain.entity.OrderDomainEntity;
import br.com.emerlopes.bffecommerce.domain.entity.ProductShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.shared.OrderStatusEnum;
import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.domain.usecase.order.CreateOrderToShoppingCartUseCase;
import br.com.emerlopes.bffecommerce.domain.usecase.order.FindOrderByIdUseCase;
import br.com.emerlopes.bffecommerce.domain.usecase.order.FindOrderByUsernameUseCase;
import br.com.emerlopes.bffecommerce.domain.usecase.order.UpdateOrderStatusUseCase;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request.OrderRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderShoppingCartController {

    private final CreateOrderToShoppingCartUseCase createOrderToShoppingCartUseCase;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final FindOrderByUsernameUseCase findOrderByUsernameUseCase;
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;

    public OrderShoppingCartController(
            final CreateOrderToShoppingCartUseCase createOrderToShoppingCartUseCase,
            final FindOrderByIdUseCase findOrderByIdUseCase,
            final FindOrderByUsernameUseCase findOrderByUsernameUseCase,
            final UpdateOrderStatusUseCase updateOrderStatusUseCase
    ) {
        this.createOrderToShoppingCartUseCase = createOrderToShoppingCartUseCase;
        this.findOrderByIdUseCase = findOrderByIdUseCase;
        this.findOrderByUsernameUseCase = findOrderByUsernameUseCase;
        this.updateOrderStatusUseCase = updateOrderStatusUseCase;
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(
            final @RequestHeader(value = "Authorization") String authorization,
            final @RequestBody OrderRequestDTO orderRequestDTO
    ) {

        RequestParametersStore.removeAuthorization();
        RequestParametersStore.setAuthorization(authorization);

        final var products = orderRequestDTO.getProducts().stream()
                .map(p -> ProductShoppingCartDomainEntity.builder()
                        .name(p.getName())
                        .description(p.getDescription())
                        .price(p.getPrice())
                        .quantity(p.getQuantity())
                        .build()
                ).toList();

        final var executionResult = createOrderToShoppingCartUseCase.execute(
                OrderDomainEntity.builder()
                        .username(orderRequestDTO.getUsername())
                        .products(products)
                        .build()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new CustomResponseDTO<>().setData(executionResult)
        );
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findOrderById(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable Long orderId
    ) {

        RequestParametersStore.removeAuthorization();
        RequestParametersStore.setAuthorization(authorization);

        final var executionResult = findOrderByIdUseCase.execute(orderId);
        return ResponseEntity.ok(
                new CustomResponseDTO<>().setData(executionResult)
        );
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> findOrderByUsername(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("username") String username
    ) {

        RequestParametersStore.removeAuthorization();
        RequestParametersStore.setAuthorization(authorization);

        final var executionResult = findOrderByUsernameUseCase.execute(username);
        return ResponseEntity.ok(
                new CustomResponseDTO<>().setData(executionResult)
        );
    }

    @PostMapping("/update-status/{orderId}")
    public ResponseEntity<?> updateOrderStatus(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("orderId") Long orderId,
            final @RequestBody OrderRequestDTO orderRequestDTO
    ) {

        RequestParametersStore.removeAuthorization();
        RequestParametersStore.setAuthorization(authorization);

        final var executionResult = updateOrderStatusUseCase.execute(
                OrderDomainEntity.builder()
                        .id(orderId)
                        .orderStatusEnum(
                                OrderStatusEnum.fromString(orderRequestDTO.getStatus())
                        )
                        .build()
        );

        return ResponseEntity.status(HttpStatus.OK).body(
                new CustomResponseDTO<>().setData(executionResult)
        );
    }

}
