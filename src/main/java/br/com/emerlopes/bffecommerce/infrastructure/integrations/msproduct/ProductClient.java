package br.com.emerlopes.bffecommerce.infrastructure.integrations.msproduct;

import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.msproduct.response.ProductReponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;


@FeignClient(name = "ms-product", url = "http://localhost:8082/produtos")
public interface ProductClient {

    @PostMapping("/cadastrar-produtos")
    void registerProducts(
            final @RequestHeader(value = "Authorization") String authorization
    );

    @GetMapping("/listar-produtos")
    CustomResponseDTO<List<ProductReponseDTO>> getProducts(
            final @RequestHeader(value = "Authorization") String authorization
    );

}
