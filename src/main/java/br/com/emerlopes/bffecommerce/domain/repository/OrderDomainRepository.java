package br.com.emerlopes.bffecommerce.domain.repository;


import br.com.emerlopes.bffecommerce.domain.entity.OrderDomainEntity;

import java.util.List;

public interface OrderDomainRepository {
    OrderDomainEntity saveOrder(
            final OrderDomainEntity order
    );

    OrderDomainEntity updateOrderStatus(
            final OrderDomainEntity order
    );

    OrderDomainEntity getOrderById(
            final Long id
    );

    List<OrderDomainEntity> getOrderByUsername(
            final String username
    );
}
