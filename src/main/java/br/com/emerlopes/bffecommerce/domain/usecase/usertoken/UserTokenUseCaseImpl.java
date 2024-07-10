package br.com.emerlopes.bffecommerce.domain.usecase.usertoken;

import br.com.emerlopes.bffecommerce.domain.entity.UserTokenDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.UserDomainRepository;
import org.springframework.stereotype.Service;

@Service
public class UserTokenUseCaseImpl implements UserTokenUseCase {

    private final UserDomainRepository userDomainRepository;

    public UserTokenUseCaseImpl(
            final UserDomainRepository userDomainRepository
    ) {
        this.userDomainRepository = userDomainRepository;
    }

    @Override
    public UserTokenDomainEntity execute(UserTokenDomainEntity userTokenDomainEntity) {
        return userDomainRepository.getUserToken(userTokenDomainEntity);
    }
}
