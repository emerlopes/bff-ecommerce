package br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller;

import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.domain.usecase.product.RegisterProductsUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final RegisterProductsUseCase registerProductsUseCase;

    public ProductController(
            final RegisterProductsUseCase registerProductsUseCase
    ) {
        this.registerProductsUseCase = registerProductsUseCase;
    }

    @PostMapping("/register-products")
    public ResponseEntity<?> registerGuest(
            final @RequestHeader(value = "Authorization") String authorization
    ) {
        try {

            RequestParametersStore.removeAuthorization();
            RequestParametersStore.setAuthorization(authorization);

            registerProductsUseCase.execute(null);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (
                final Throwable throwable
        ) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }
}
