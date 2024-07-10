package br.com.emerlopes.bffecommerce.repository;

import br.com.emerlopes.bffecommerce.domain.repository.ProductDomainRepository;
import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.msprodutc.ProductClient;
import org.springframework.stereotype.Service;

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
}
