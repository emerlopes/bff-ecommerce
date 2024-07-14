package br.com.emerlopes.bffecommerce.domain.usecase.shoppingcart.impl;

import br.com.emerlopes.bffecommerce.domain.entity.ProductShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.entity.ShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.ShoppingCartDomainRepository;
import br.com.emerlopes.bffecommerce.domain.usecase.shoppingcart.AddProductToShoppingCartByUsernameUseCase;
import org.springframework.stereotype.Service;


@Service
public class AddProductToShoppingCartByUsernameUseCaseImpl implements AddProductToShoppingCartByUsernameUseCase {

    private final ShoppingCartDomainRepository shoppingCartDomainRepository;

    public AddProductToShoppingCartByUsernameUseCaseImpl(
            final ShoppingCartDomainRepository shoppingCartDomainRepository
    ) {
        this.shoppingCartDomainRepository = shoppingCartDomainRepository;
    }

    @Override
    public ShoppingCartDomainEntity execute(
            final ProductShoppingCartDomainEntity productDomainEntity
    ) {
        return shoppingCartDomainRepository.addProductToShoppingCart(productDomainEntity);
    }
}
