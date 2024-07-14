package br.com.emerlopes.bffecommerce.domain.usecase.shoppingcart;

import br.com.emerlopes.bffecommerce.domain.entity.ProductShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.entity.ShoppingCartDomainEntity;
import br.com.emerlopes.bffecommerce.domain.shared.ExecuteArgs;

public interface AddProductToShoppingCartByUsernameUseCase extends ExecuteArgs<ShoppingCartDomainEntity, ProductShoppingCartDomainEntity> {
}
