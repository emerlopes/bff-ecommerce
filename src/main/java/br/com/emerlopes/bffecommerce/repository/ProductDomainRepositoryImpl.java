package br.com.emerlopes.bffecommerce.repository;

import br.com.emerlopes.bffecommerce.application.exceptions.ProductNotFoundException;
import br.com.emerlopes.bffecommerce.domain.entity.ProductDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.ProductDomainRepository;
import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.msproduct.ProductClient;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.msproduct.request.ProductRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDomainRepositoryImpl implements ProductDomainRepository {

    private final ProductClient productClient;

    public ProductDomainRepositoryImpl(
            final ProductClient productClient
    ) {
        this.productClient = productClient;
    }

    @Override
    public void registerProducts() {
        final var authorization = RequestParametersStore.getAuthorization();
        productClient.registerProducts(authorization);
    }

    @Override
    public List<ProductDomainEntity> getProducts() {
        final var products = this.productClient.getProducts(RequestParametersStore.getAuthorization());
        if (products != null) {
            return products.getData().stream().map(
                    product -> ProductDomainEntity
                            .builder()
                            .id(product.getId())
                            .name(product.getName())
                            .description(product.getDescription())
                            .price(product.getPrice())
                            .quantity(product.getQuantity())
                            .available(product.getQuantity() > 0)
                            .build()
            ).toList();
        }

        return List.of();
    }

    @Override
    public ProductDomainEntity updateProduct(
            final ProductDomainEntity product
    ) {
        final var authorization = RequestParametersStore.getAuthorization();
        final var productToUpdate = ProductRequestDTO.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();

        final var updatedProduct = this.productClient.updateProduct(
                authorization,
                product.getId(),
                productToUpdate
        );

        if (updatedProduct.getData() == null) {
            throw new ProductNotFoundException("Product not found");
        }

        return ProductDomainEntity
                .builder()
                .id(updatedProduct.getData().getId())
                .name(updatedProduct.getData().getName())
                .description(updatedProduct.getData().getDescription())
                .price(updatedProduct.getData().getPrice())
                .quantity(updatedProduct.getData().getQuantity())
                .available(updatedProduct.getData().getQuantity() > 0)
                .build();
    }

}
