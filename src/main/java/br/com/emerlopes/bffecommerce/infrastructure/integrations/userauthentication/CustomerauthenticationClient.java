package br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication;

import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication.request.RegisterUserRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "user-authentication", url = "http://localhost:8080")
public interface CustomerauthenticationClient {

    @PostMapping("/user/register-guest")
    Optional<CustomResponseDTO<CustomerauthenticationResponseDTO>> registerGuestUser(
            @RequestBody RegisterUserRequestDTO registerUserRequestDTO
    );

    @PostMapping("/user/register-user")
    Optional<CustomResponseDTO<CustomerauthenticationResponseDTO>> registerUser(
            @RequestBody RegisterUserRequestDTO registerUserRequestDTO
    );

    @PostMapping("/user/register-admin")
    Optional<CustomResponseDTO<CustomerauthenticationResponseDTO>> registerAdminUser(
            @RequestBody RegisterUserRequestDTO registerUserRequestDTO
    );

}
