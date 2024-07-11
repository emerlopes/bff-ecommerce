package br.com.emerlopes.bffecommerce.domain.usecase.product;

import br.com.emerlopes.bffecommerce.domain.entity.ProductDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.ProductDomainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsUseCaseImpl implements GetProductsUseCase {

    private final ProductDomainRepository productDomainRepository;

    public GetProductsUseCaseImpl(
            final ProductDomainRepository productDomainRepository
    ) {
        this.productDomainRepository = productDomainRepository;
    }

    @Override
    public List<ProductDomainEntity> execute(Void domainObject) {
        return productDomainRepository.getProducts();
    }
}
