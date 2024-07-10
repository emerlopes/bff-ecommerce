package br.com.emerlopes.bffecommerce.domain.repository;

import br.com.emerlopes.bffecommerce.domain.entity.RegisterUserDomainEntity;

public interface RegisterUserDomainRepository {
    void registerGuestUser(RegisterUserDomainEntity registerUserDomainEntity);

    void registerUser(RegisterUserDomainEntity registerUserDomainEntity);

    void registerAdminUser(RegisterUserDomainEntity registerUserDomainEntity);
}
