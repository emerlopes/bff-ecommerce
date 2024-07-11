package br.com.emerlopes.bffecommerce.domain.usecase.product;

import br.com.emerlopes.bffecommerce.domain.entity.ProductDomainEntity;
import br.com.emerlopes.bffecommerce.domain.shared.ExecuteArgs;

import java.util.List;

public interface GetProductsUseCase extends ExecuteArgs<List<ProductDomainEntity>, Void> {
}
