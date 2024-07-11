package br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication;

import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.userauthentication.response.UserTokenResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "user-token", url = "${application.customerauthentication.host}/auth")
public interface UserTokenClient {

    @PostMapping("/token")
    CustomResponseDTO<UserTokenResponseDTO> getToken(
            final @RequestParam String username,
            final @RequestParam String password
    );

}
