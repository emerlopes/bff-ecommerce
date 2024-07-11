package br.com.emerlopes.bffecommerce.repository;

import br.com.emerlopes.bffecommerce.domain.entity.ProductDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.ProductDomainRepository;
import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.msproduct.ProductClient;
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
}
