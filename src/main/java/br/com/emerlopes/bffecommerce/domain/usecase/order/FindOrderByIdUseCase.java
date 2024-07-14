package br.com.emerlopes.bffecommerce.domain.usecase.order;


import br.com.emerlopes.bffecommerce.domain.entity.OrderDomainEntity;
import br.com.emerlopes.bffecommerce.domain.shared.ExecuteArgs;

public interface FindOrderByIdUseCase extends ExecuteArgs<OrderDomainEntity, Long> {
}
