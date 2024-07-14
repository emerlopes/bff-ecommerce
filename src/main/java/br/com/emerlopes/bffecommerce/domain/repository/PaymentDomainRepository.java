package br.com.emerlopes.bffecommerce.domain.repository;

import br.com.emerlopes.bffecommerce.domain.entity.PaymentDomainEntity;

public interface PaymentDomainRepository {
    PaymentDomainEntity processPayment(
            final PaymentDomainEntity paymentDomainEntity
    );
}
