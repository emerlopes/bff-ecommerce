package br.com.emerlopes.bffecommerce.domain.usecase.order.impl;

import br.com.emerlopes.bffecommerce.domain.entity.OrderDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.OrderDomainRepository;
import br.com.emerlopes.bffecommerce.domain.usecase.order.CreateOrderToShoppingCartUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderToShoppingCartUseCaseImpl implements CreateOrderToShoppingCartUseCase {

    private final OrderDomainRepository orderDomainRepository;

    public CreateOrderToShoppingCartUseCaseImpl(
            final OrderDomainRepository orderDomainRepository
    ) {
        this.orderDomainRepository = orderDomainRepository;
    }

    @Override
    public OrderDomainEntity execute(
            final OrderDomainEntity orderDomainEntity
    ) {
        return orderDomainRepository.saveOrder(orderDomainEntity);
    }

}
