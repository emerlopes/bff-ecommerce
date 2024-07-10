package br.com.emerlopes.bffecommerce.infrastructure.integrations.msprodutc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "ms-product", url = "http://localhost:8082/produtos")
public interface ProductClient {

    @PostMapping("/cadastrar-produtos")
    void registerProducts(
            final @RequestHeader(value = "Authorization") String authorization
    );

    @PostMapping("atualizar/{idProduto}")
    void getProductById(
            final @PathVariable Long idProduto
    );

}
