package br.com.emerlopes.bffecommerce.repository;

import br.com.emerlopes.bffecommerce.domain.entity.RegisterUserDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.RegisterUserDomainRepository;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication.UserAuthenticationClient;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication.request.RegisterUserRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserDomainRepositoryImpl implements RegisterUserDomainRepository {

    private final UserAuthenticationClient userAuthenticationClient;

    public RegisterUserDomainRepositoryImpl(
            final UserAuthenticationClient userAuthenticationClient
    ) {
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
        userAuthenticationClient.registerAdminUser(this.getRegisterUserRequestDTO(registerUserDomainEntity));
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
