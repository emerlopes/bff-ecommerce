package br.com.emerlopes.bffecommerce.domain.usecase.order;

import br.com.emerlopes.bffecommerce.domain.entity.OrderDomainEntity;
import br.com.emerlopes.bffecommerce.domain.shared.ExecuteArgs;

import java.util.List;

public interface FindOrderByUsernameUseCase extends ExecuteArgs<List<OrderDomainEntity>, String> {
}
