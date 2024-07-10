package br.com.emerlopes.bffecommerce.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterUserDomainEntity {
    private String id;
    private String username;
    private String password;
    private String role;
    private String authorization;
}
