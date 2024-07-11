package br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller;

import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.domain.entity.ProductDomainEntity;
import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.domain.usecase.product.GetProductsUseCase;
import br.com.emerlopes.bffecommerce.domain.usecase.product.RegisterProductsUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final RegisterProductsUseCase registerProductsUseCase;
    private final GetProductsUseCase getProductsUseCase;

    public ProductController(
            final RegisterProductsUseCase registerProductsUseCase,
            final GetProductsUseCase getProductsUseCase
    ) {
        this.registerProductsUseCase = registerProductsUseCase;
        this.getProductsUseCase = getProductsUseCase;
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

    @GetMapping()
    public ResponseEntity<?> getProducts(
            final @RequestHeader(value = "Authorization") String authorization
    ) {
        try {

            RequestParametersStore.removeAuthorization();
            RequestParametersStore.setAuthorization(authorization);

            final var resultExecution = getProductsUseCase.execute(null);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponseDTO<List<ProductDomainEntity>>()
                            .setData(resultExecution)
            );

        } catch (
                final Throwable throwable
        ) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(throwable.getMessage());

        }

    }
}
