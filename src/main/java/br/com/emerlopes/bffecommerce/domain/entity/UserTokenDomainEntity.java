package br.com.emerlopes.bffecommerce.domain.entity;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserTokenDomainEntity {
    private String username;
    private String password;
    private String token;
}
