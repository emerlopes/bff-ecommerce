package br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication;

import br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication.request.RegisterUserRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "user-authentication", url = "http://localhost:8080/users")
public interface UserAuthenticationClient {

    @PostMapping("/register-guest")
    void registerGuestUser(
            @RequestBody RegisterUserRequestDTO registerUserRequestDTO
    );

    @PostMapping("/register-user")
    void registerUser(
            @RequestBody RegisterUserRequestDTO registerUserRequestDTO
    );

    @PostMapping("/register-admin")
    void registerAdminUser(
            @RequestBody RegisterUserRequestDTO registerUserRequestDTO
    );

}
