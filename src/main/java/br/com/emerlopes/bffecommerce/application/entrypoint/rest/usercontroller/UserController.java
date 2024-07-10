package br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller;

import br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller.dto.request.RegisterUserRequestBffDTO;
import br.com.emerlopes.bffecommerce.domain.entity.RegisterUserDomainEntity;
import br.com.emerlopes.bffecommerce.domain.usecase.userauthentication.RegisterUserUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final RegisterUserUseCase registerUserUseCase;

    public UserController(
            final RegisterUserUseCase registerUserUseCase
    ) {
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping("/register-user")
    public ResponseEntity<?> registerGuest(
            final @RequestBody RegisterUserRequestBffDTO request
    ) {

        try {

            registerUserUseCase.execute(this.toDomainEntity(request));
            logger.info("User registered");

        } catch (Throwable throwable) {

            logger.error("Error registering user", throwable);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private RegisterUserDomainEntity toDomainEntity(RegisterUserRequestBffDTO request) {
        return RegisterUserDomainEntity.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }

}
