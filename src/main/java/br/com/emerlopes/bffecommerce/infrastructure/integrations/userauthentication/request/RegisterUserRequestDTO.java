package br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserRequestDTO {
    private String username;
    private String password;
}
