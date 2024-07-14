package br.com.emerlopes.bffecommerce.domain.usecase.shoppingcart.impl;

import br.com.emerlopes.bffecommerce.domain.entity.ProductShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.entity.ShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.ShoppingCartDomainRepository;
import br.com.emerlopes.bffecommerce.domain.usecase.shoppingcart.RemoveProductFromShoppingCartByUsernameUseCase;
import org.springframework.stereotype.Service;

@Service
public class RemoveProductFromShoppingCartByUsernameUseCaseImpl implements RemoveProductFromShoppingCartByUsernameUseCase {

    private final ShoppingCartDomainRepository shoppingCartDomainRepository;

    public RemoveProductFromShoppingCartByUsernameUseCaseImpl(
            final ShoppingCartDomainRepository shoppingCartDomainRepository
    ) {
        this.shoppingCartDomainRepository = shoppingCartDomainRepository;
    }

    @Override
    public ShoppingCartDomainEntity execute(
            final ProductShoppingCartDomainEntity productShoppingCartDomainEntity
    ) {
        return shoppingCartDomainRepository.removeProductFromShoppingCart(productShoppingCartDomainEntity);
    }
}
