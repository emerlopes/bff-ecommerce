package br.com.emerlopes.bffecommerce.domain.usecase.userauthentication;

import br.com.emerlopes.bffecommerce.domain.entity.RegisterUserDomainEntity;
import br.com.emerlopes.bffecommerce.domain.shared.ExecuteArgs;

public interface RegisterUserUseCase extends ExecuteArgs<RegisterUserDomainEntity, RegisterUserDomainEntity> {
}
