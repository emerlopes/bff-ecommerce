package br.com.emerlopes.bffecommerce.application.entrypoint.rest.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserRequestBffDTO {
    private String username;
    private String password;
    private String role;
    private String authorization;
}
