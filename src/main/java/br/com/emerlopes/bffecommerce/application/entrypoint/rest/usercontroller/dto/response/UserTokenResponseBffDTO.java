package br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTokenResponseBffDTO {
    private String username;
    private String token;
}
