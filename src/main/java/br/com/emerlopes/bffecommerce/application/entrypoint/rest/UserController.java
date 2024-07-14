package br.com.emerlopes.bffecommerce.application.entrypoint.rest;

import br.com.emerlopes.bffecommerce.application.entrypoint.rest.dto.response.UserTokenResponseBffDTO;
import br.com.emerlopes.bffecommerce.application.entrypoint.rest.dto.request.RegisterUserRequestBffDTO;
import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.domain.entity.RegisterUserDomainEntity;
import br.com.emerlopes.bffecommerce.domain.entity.UserTokenDomainEntity;
import br.com.emerlopes.bffecommerce.domain.usecase.userauthentication.RegisterUserUseCase;
import br.com.emerlopes.bffecommerce.domain.usecase.usertoken.UserTokenUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "API para gerenciamento de usuários")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserTokenUseCase userTokenUseCase;
    private final RegisterUserUseCase registerUserUseCase;

    public UserController(
            final UserTokenUseCase userTokenUseCase,
            final RegisterUserUseCase registerUserUseCase
    ) {
        this.userTokenUseCase = userTokenUseCase;
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping("/token")
    @Operation(summary = "Obter token", description = "Gera um token para o usuário com base nas credenciais fornecidas")
    public ResponseEntity<?> getToken(
            @RequestParam String username,
            @RequestParam String password
    ) {

        try {

            final var executionResult = userTokenUseCase.execute(this.toDomainEntity(username, password));
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new CustomResponseDTO<UserTokenResponseBffDTO>()
                            .setData(
                                    this.toResponseDTO(executionResult)
                            )
            );

        } catch (final Throwable throwable) {

            logger.error("Error getting token", throwable);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(throwable.getMessage());

        }
    }

    @PostMapping("/register-user")
    @Operation(summary = "Registrar usuário", description = "Registra um novo usuário na plataforma")
    public ResponseEntity<?> registerGuest(
            final @RequestHeader(value = "Authorization", required = false) String authorization,
            final @RequestBody RegisterUserRequestBffDTO request
    ) {
        try {

            registerUserUseCase.execute(this.toDomainEntity(authorization, request));
            logger.info("User registered");

        } catch (final Throwable throwable) {

            logger.error("Error registering user", throwable);
            throw throwable;

        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private RegisterUserDomainEntity toDomainEntity(
            final String authorization,
            final RegisterUserRequestBffDTO request
    ) {
        return RegisterUserDomainEntity.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .role(request.getRole())
                .authorization(authorization)
                .build();
    }

    private UserTokenDomainEntity toDomainEntity(
            final String username,
            final String password
    ) {
        return UserTokenDomainEntity.builder()
                .username(username)
                .password(password)
                .build();
    }

    private UserTokenResponseBffDTO toResponseDTO(
            final UserTokenDomainEntity domainEntity
    ) {
        return UserTokenResponseBffDTO.builder()
                .username(domainEntity.getUsername())
                .token(domainEntity.getToken())
                .build();
    }

}
