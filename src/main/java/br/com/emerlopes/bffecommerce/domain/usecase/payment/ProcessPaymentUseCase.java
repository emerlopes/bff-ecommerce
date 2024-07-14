package br.com.emerlopes.bffecommerce.domain.usecase.payment;

import br.com.emerlopes.bffecommerce.domain.entity.PaymentDomainEntity;
import br.com.emerlopes.bffecommerce.domain.shared.ExecuteArgs;

public interface ProcessPaymentUseCase extends ExecuteArgs<PaymentDomainEntity, PaymentDomainEntity> {
}
