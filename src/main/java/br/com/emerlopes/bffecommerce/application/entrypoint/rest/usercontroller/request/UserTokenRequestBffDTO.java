package br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTokenRequestBffDTO {
    private String username;
    private String password;
}
