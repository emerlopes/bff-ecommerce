package br.com.emerlopes.bffecommerce.domain.usecase.userauthentication;

import br.com.emerlopes.bffecommerce.application.shared.response.UserRoleEnum;
import br.com.emerlopes.bffecommerce.domain.entity.RegisterUserDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.UserDomainRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

    private final UserDomainRepository registerUserDomainRepository;

    public RegisterUserUseCaseImpl(
            final UserDomainRepository registerUserDomainRepository
    ) {
        this.registerUserDomainRepository = registerUserDomainRepository;
    }

    @Override
    public RegisterUserDomainEntity execute(
            final RegisterUserDomainEntity registerUserDomainEntity
    ) {

        final var role = UserRoleEnum.fromRole(registerUserDomainEntity.getRole());

        if (role == null) {
            throw new IllegalArgumentException("Invalid role");
        }

        if (role == UserRoleEnum.GUEST) {
            registerUserDomainRepository.registerGuestUser(registerUserDomainEntity);
        }

        if (role == UserRoleEnum.USER) {
            registerUserDomainRepository.registerUser(registerUserDomainEntity);
        }

        if (role == UserRoleEnum.ADMIN) {
            registerUserDomainRepository.registerAdminUser(registerUserDomainEntity);
        }

        return RegisterUserDomainEntity.builder()
                .username(registerUserDomainEntity.getUsername())
                .build();
    }
}
