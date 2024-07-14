package br.com.emerlopes.bffecommerce.domain.repository;

import br.com.emerlopes.bffecommerce.domain.entity.ProductShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.entity.ShoppingCartDomainEntity;

public interface ShoppingCartDomainRepository {

    ShoppingCartDomainEntity getShoppingCart(
            final String username
    );

    ShoppingCartDomainEntity addProductToShoppingCart(
            final ProductShoppingCartDomainEntity productDomainEntity
    );

    ShoppingCartDomainEntity removeProductFromShoppingCart(
            final ProductShoppingCartDomainEntity productDomainEntity
    );
}
