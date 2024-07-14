package br.com.emerlopes.bffecommerce.repository;

import br.com.emerlopes.bffecommerce.domain.entity.ProductShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.entity.ShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.ShoppingCartDomainRepository;
import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.ShoppingCartClient;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.request.ShoppingCartProductRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartDomainRepositoryImpl implements ShoppingCartDomainRepository {

    private final ShoppingCartClient shoppingCartClient;

    public ShoppingCartDomainRepositoryImpl(
            final ShoppingCartClient shoppingCartClient
    ) {
        this.shoppingCartClient = shoppingCartClient;
    }

    @Override
    public ShoppingCartDomainEntity getShoppingCart(
            final String username
    ) {
        final var authorization = RequestParametersStore.getAuthorization();

        final var response = shoppingCartClient.getShoppingCartByUsername(
                authorization,
                username
        );

        final var data = response.getData();

        return ShoppingCartDomainEntity.builder()
                .username(data.getUsername())
                .products(data.getProducts().stream().map(p -> ProductShoppingCartDomainEntity.builder()
                        .name(p.getName())
                        .price(p.getPrice())
                        .quantity(p.getQuantity())
                        .build()
                ).toList())
                .total(data.getTotal())
                .build();
    }

    @Override
    public ShoppingCartDomainEntity addProductToShoppingCart(
            final ProductShoppingCartDomainEntity productDomainEntity
    ) {
        final var authorization = RequestParametersStore.getAuthorization();

        final var response = shoppingCartClient.addProductToShoppingCart(
                authorization,
                productDomainEntity.getUsername(),
                ShoppingCartProductRequestDTO.builder()
                        .name(productDomainEntity.getName())
                        .price(productDomainEntity.getPrice())
                        .quantity(productDomainEntity.getQuantity())
                        .build()
        );

        return ShoppingCartDomainEntity.builder()
                .username(response.getData().getUsername())
                .products(response.getData().getProducts().stream().map(p -> ProductShoppingCartDomainEntity.builder()
                        .name(p.getName())
                        .price(p.getPrice())
                        .quantity(p.getQuantity())
                        .build()
                ).toList())
                .total(response.getData().getTotal())
                .build();
    }

    @Override
    public ShoppingCartDomainEntity removeProductFromShoppingCart(
            final ProductShoppingCartDomainEntity productDomainEntity
    ) {
        final var authorization = RequestParametersStore.getAuthorization();

        final var response = shoppingCartClient.removeProductFromShoppingCart(
                authorization,
                productDomainEntity.getUsername(),
                ShoppingCartProductRequestDTO.builder()
                        .name(productDomainEntity.getName())
                        .price(productDomainEntity.getPrice())
                        .quantity(productDomainEntity.getQuantity())
                        .build()
        );

        return ShoppingCartDomainEntity.builder()
                .username(response.getData().getUsername())
                .products(response.getData().getProducts().stream().map(p -> ProductShoppingCartDomainEntity.builder()
                        .name(p.getName())
                        .price(p.getPrice())
                        .quantity(p.getQuantity())
                        .build()
                ).toList())
                .total(response.getData().getTotal())
                .build();
    }

}
