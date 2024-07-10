package br.com.emerlopes.bffecommerce.domain.repository;

import br.com.emerlopes.bffecommerce.domain.entity.RegisterUserDomainEntity;
import br.com.emerlopes.bffecommerce.domain.entity.UserTokenDomainEntity;

public interface UserDomainRepository {
    void registerGuestUser(RegisterUserDomainEntity registerUserDomainEntity);

    void registerUser(RegisterUserDomainEntity registerUserDomainEntity);

    void registerAdminUser(RegisterUserDomainEntity registerUserDomainEntity);

    UserTokenDomainEntity getUserToken(UserTokenDomainEntity userTokenDomainEntity);
}
