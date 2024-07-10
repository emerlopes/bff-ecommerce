package br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller.dto.request;

import br.com.emerlopes.bffecommerce.application.shared.response.UserRoleEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserRequestBffDTO {
    private String username;
    private String password;
    private UserRoleEnum role;
}
