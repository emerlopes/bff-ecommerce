package br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller;

import br.com.emerlopes.bffecommerce.application.entrypoint.rest.usercontroller.dto.request.UpdateProductRequestBffDTO;
import br.com.emerlopes.bffecommerce.application.shared.response.CustomResponseDTO;
import br.com.emerlopes.bffecommerce.domain.entity.ProductDomainEntity;
import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.domain.usecase.product.GetProductsUseCase;
import br.com.emerlopes.bffecommerce.domain.usecase.product.RegisterProductsUseCase;
import br.com.emerlopes.bffecommerce.domain.usecase.product.UpdatePriceProductUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final RegisterProductsUseCase registerProductsUseCase;
    private final GetProductsUseCase getProductsUseCase;
    private final UpdatePriceProductUseCase updatePriceProductUseCase;

    public ProductController(
            final RegisterProductsUseCase registerProductsUseCase,
            final GetProductsUseCase getProductsUseCase,
            final UpdatePriceProductUseCase updatePriceProductUseCase
    ) {
        this.registerProductsUseCase = registerProductsUseCase;
        this.getProductsUseCase = getProductsUseCase;
        this.updatePriceProductUseCase = updatePriceProductUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerProducts(
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

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("id") Long id,
            final @RequestBody UpdateProductRequestBffDTO request
    ) {
        try {

            RequestParametersStore.removeAuthorization();
            RequestParametersStore.setAuthorization(authorization);

            final var executionResult = updatePriceProductUseCase.execute(
                    ProductDomainEntity.builder()
                            .id(id)
                            .name(request.getName())
                            .description(request.getDescription())
                            .price(request.getPrice())
                            .quantity(request.getQuantity())
                            .build()
            );

            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponseDTO<>()
                            .setData(executionResult)
            );

        } catch (
                final Throwable throwable
        ) {

            logger.error("Error updating product", throwable);
            throw throwable;
        }

    }

    @PostMapping("/update-price/{id}")
    public ResponseEntity<?> updatePriceProduct(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("id") Long id,
            final @RequestBody UpdateProductRequestBffDTO request
    ) {
        try {

            RequestParametersStore.removeAuthorization();
            RequestParametersStore.setAuthorization(authorization);

            final var executionResult = updatePriceProductUseCase.execute(
                    ProductDomainEntity.builder()
                            .id(id)
                            .price(request.getPrice())
                            .build()
            );

            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponseDTO<>()
                            .setData(executionResult)
            );

        } catch (
                final Throwable throwable
        ) {

            logger.error("Error updating product", throwable);
            throw throwable;
        }

    }

    @PostMapping("/update-stock/{id}")
    public ResponseEntity<?> updateStockProduct(
            final @RequestHeader(value = "Authorization") String authorization,
            final @PathVariable("id") Long id,
            final @RequestBody UpdateProductRequestBffDTO request
    ) {
        try {

            RequestParametersStore.removeAuthorization();
            RequestParametersStore.setAuthorization(authorization);

            final var executionResult = updatePriceProductUseCase.execute(
                    ProductDomainEntity.builder()
                            .id(id)
                            .quantity(request.getQuantity())
                            .build()
            );

            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponseDTO<>()
                            .setData(executionResult)
            );

        } catch (
                final Throwable throwable
        ) {

            logger.error("Error updating product", throwable);
            throw throwable;
        }

    }
}
