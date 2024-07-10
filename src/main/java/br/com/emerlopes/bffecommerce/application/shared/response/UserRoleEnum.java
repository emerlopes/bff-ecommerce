package br.com.emerlopes.bffecommerce.application.shared.response;

import lombok.Getter;

@Getter
public enum UserRoleEnum {
    ADMIN("ROLE_ADMIN"),

    USER("ROLE_USER"),

    GUEST("ROLE_GUEST");

    private final String role;

    UserRoleEnum(String role) {
        this.role = role;
    }

}
