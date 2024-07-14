package br.com.emerlopes.bffecommerce.domain.usecase.order.impl;

import br.com.emerlopes.bffecommerce.domain.entity.OrderDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.OrderDomainRepository;
import br.com.emerlopes.bffecommerce.domain.usecase.order.UpdateOrderStatusUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderStatusUseCaseImpl implements UpdateOrderStatusUseCase {
    private final OrderDomainRepository orderDomainRepository;

    public UpdateOrderStatusUseCaseImpl(
            final OrderDomainRepository orderDomainRepository
    ) {
        this.orderDomainRepository = orderDomainRepository;
    }

    @Override
    public OrderDomainEntity execute(
            final OrderDomainEntity orderDomainEntity
    ) {
        return orderDomainRepository.updateOrderStatus(orderDomainEntity);
    }
}
