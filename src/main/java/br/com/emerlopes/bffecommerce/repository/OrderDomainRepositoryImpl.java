package br.com.emerlopes.bffecommerce.repository;


import br.com.emerlopes.bffecommerce.application.exceptions.OrderNotFoundByIdException;
import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.domain.entity.OrderDomainEntity;
import br.com.emerlopes.bffecommerce.domain.entity.ProductShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.OrderDomainRepository;
import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.OrderShoppingCartClient;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request.OrderRequestDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request.ProductRequestDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.response.OrderResponseDTO;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDomainRepositoryImpl implements OrderDomainRepository {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(OrderDomainRepositoryImpl.class);
    private final OrderShoppingCartClient orderShoppingCartClient;

    public OrderDomainRepositoryImpl(
            final OrderShoppingCartClient orderShoppingCartClient
    ) {
        this.orderShoppingCartClient = orderShoppingCartClient;
    }


    @Override
    public OrderDomainEntity saveOrder(
            final OrderDomainEntity orderDomainEntity
    ) {

        final var authorization = RequestParametersStore.getAuthorization();

        final var responseOrder = orderShoppingCartClient.checkout(
                authorization,
                OrderRequestDTO.builder()
                        .username(orderDomainEntity.getUsername())
                        .products(orderDomainEntity.getProducts().stream()
                                .map(product -> ProductRequestDTO.builder()
                                        .name(product.getName())
                                        .description(product.getDescription())
                                        .price(product.getPrice())
                                        .quantity(product.getQuantity())
                                        .build())
                                .toList()
                        )
                        .build());

        final var data = this.getDataFromResponse(responseOrder);

        logger.info("Order saved: {}", data.getId());

        return this.getOrderDomainEntity(data);
    }

    @Override
    public OrderDomainEntity updateOrderStatus(
            final OrderDomainEntity order
    ) {

        final var authorization = RequestParametersStore.getAuthorization();

        final var responseOrder = orderShoppingCartClient.updateOrderStatus(
                authorization,
                order.getId(),
                OrderRequestDTO.builder()
                        .status(order.getOrderStatusEnum().name())
                        .build()
        );

        final var data = this.getDataFromResponse(responseOrder);

        logger.info("Order updated: {}", data.getId());

        return this.getOrderDomainEntity(data);

    }

    @Override
    public OrderDomainEntity getOrderById(
            final Long id
    ) {

        final var authorization = RequestParametersStore.getAuthorization();

        final var responseOrder = orderShoppingCartClient.findOrderById(
                authorization,
                id
        );

        final var data = this.getDataFromResponse(responseOrder);

        logger.info("Order found by id: {}", data.getId());

        return this.getOrderDomainEntity(data);

    }

    @Override
    public List<OrderDomainEntity> getOrderByUsername(
            final String username
    ) {

        final var authorization = RequestParametersStore.getAuthorization();

        final var responseOrder = orderShoppingCartClient.findOrderByUsername(
                authorization,
                username
        );

        final var orders = responseOrder.getBody();

        if (orders == null) {
            throw new OrderNotFoundByIdException("Response not found", "ORDER_NOT_FOUND");
        }

        if (orders.getData() == null) {
            throw new OrderNotFoundByIdException("Order not found", "ORDER_NOT_FOUND");
        }

        logger.info("Orders found by username: {}", orders.getData().size());

        return orders.getData().stream().map(data -> OrderDomainEntity.builder()
                        .id(data.getId())
                        .username(data.getUsername())
                        .products(data.getProducts().stream().map(p -> ProductShoppingCartDomainEntity.builder()
                                        .name(p.getName())
                                        .description(p.getDescription())
                                        .price(p.getPrice())
                                        .quantity(p.getQuantity())
                                        .build())
                                .toList())
                        .total(data.getTotal())
                        .orderStatusEnum(data.getStatus())
                        .createdAt(data.getCreatedAt())
                        .updatedAt(data.getUpdatedAt())
                        .build())
                .toList();

    }

    private OrderDomainEntity getOrderDomainEntity(
            final OrderResponseDTO orderResponseDTO) {

        return OrderDomainEntity.builder()
                .id(orderResponseDTO.getId())
                .username(orderResponseDTO.getUsername())
                .products(orderResponseDTO.getProducts().stream().map(p -> ProductShoppingCartDomainEntity.builder()
                                .name(p.getName())
                                .description(p.getDescription())
                                .price(p.getPrice())
                                .quantity(p.getQuantity())
                                .build())
                        .toList())
                .total(orderResponseDTO.getTotal())
                .orderStatusEnum(orderResponseDTO.getStatus())
                .createdAt(orderResponseDTO.getCreatedAt())
                .updatedAt(orderResponseDTO.getUpdatedAt())
                .build();

    }

    private OrderResponseDTO getDataFromResponse(
            final ResponseEntity<CustomResponseDTO<OrderResponseDTO>> responseOrder) {

        final var order = responseOrder.getBody();

        if (order == null) {
            throw new OrderNotFoundByIdException("Response not found", "ORDER_NOT_FOUND");
        }

        if (order.getData() == null) {
            throw new OrderNotFoundByIdException("Order not found", "ORDER_NOT_FOUND");
        }

        return order.getData();

    }

}
