package br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTokenResponseDTO {
    private String username;
    private String token;
}
