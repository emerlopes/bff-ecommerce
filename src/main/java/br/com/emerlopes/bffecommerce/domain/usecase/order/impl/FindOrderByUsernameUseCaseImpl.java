package br.com.emerlopes.bffecommerce.domain.usecase.order.impl;

import br.com.emerlopes.bffecommerce.domain.entity.OrderDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.OrderDomainRepository;
import br.com.emerlopes.bffecommerce.domain.usecase.order.FindOrderByUsernameUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindOrderByUsernameUseCaseImpl implements FindOrderByUsernameUseCase {

    private final OrderDomainRepository orderDomainRepository;

    public FindOrderByUsernameUseCaseImpl(
            final OrderDomainRepository orderDomainRepository
    ) {
        this.orderDomainRepository = orderDomainRepository;
    }

    @Override
    public List<OrderDomainEntity> execute(
            final String username
    ) {
        return orderDomainRepository.getOrderByUsername(username);
    }
}
