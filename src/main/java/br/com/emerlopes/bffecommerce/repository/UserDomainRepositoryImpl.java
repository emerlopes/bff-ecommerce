package br.com.emerlopes.bffecommerce.repository;

import br.com.emerlopes.bffecommerce.domain.entity.RegisterUserDomainEntity;
import br.com.emerlopes.bffecommerce.domain.entity.UserTokenDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.UserDomainRepository;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication.UserTokenClient;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication.UserAuthenticationClient;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication.request.RegisterUserRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class UserDomainRepositoryImpl implements UserDomainRepository {

    private final UserTokenClient userTokenClient;
    private final UserAuthenticationClient userAuthenticationClient;

    public UserDomainRepositoryImpl(
            final UserTokenClient userTokenClient,
            final UserAuthenticationClient userAuthenticationClient
    ) {
        this.userTokenClient = userTokenClient;
        this.userAuthenticationClient = userAuthenticationClient;
    }

    @Override
    public void registerGuestUser(
            final RegisterUserDomainEntity registerUserDomainEntity
    ) {
        userAuthenticationClient.registerGuestUser(this.getRegisterUserRequestDTO(registerUserDomainEntity));
    }

    @Override
    public void registerUser(
            final RegisterUserDomainEntity registerUserDomainEntity
    ) {
        userAuthenticationClient.registerUser(this.getRegisterUserRequestDTO(registerUserDomainEntity));
    }

    @Override
    public void registerAdminUser(
            final RegisterUserDomainEntity registerUserDomainEntity
    ) {

        if (registerUserDomainEntity.getAuthorization() == null) {
            throw new IllegalArgumentException("Authorization is required");
        }

        userAuthenticationClient.registerAdminUser(
                registerUserDomainEntity.getAuthorization(),
                this.getRegisterUserRequestDTO(registerUserDomainEntity)
        );
    }

    @Override
    public UserTokenDomainEntity getUserToken(
            final UserTokenDomainEntity userTokenDomainEntity
    ) {
        final var userToken = userTokenClient.getToken(
                userTokenDomainEntity.getUsername(),
                userTokenDomainEntity.getPassword()
        );

        return UserTokenDomainEntity.builder()
                .username(userToken.getData().getUsername())
                .token(userToken.getData().getToken())
                .build();
    }

    private RegisterUserRequestDTO getRegisterUserRequestDTO(
            final RegisterUserDomainEntity registerUserDomainEntity
    ) {
        return RegisterUserRequestDTO.builder()
                .username(registerUserDomainEntity.getUsername())
                .password(registerUserDomainEntity.getPassword())
                .build();
    }
}
