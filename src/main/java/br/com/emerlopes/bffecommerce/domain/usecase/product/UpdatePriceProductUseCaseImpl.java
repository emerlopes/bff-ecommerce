package br.com.emerlopes.bffecommerce.domain.usecase.product;

import br.com.emerlopes.bffecommerce.domain.entity.ProductDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.ProductDomainRepository;
import org.springframework.stereotype.Service;


@Service
public class UpdatePriceProductUseCaseImpl implements UpdatePriceProductUseCase {

    private final ProductDomainRepository productDomainRepository;

    public UpdatePriceProductUseCaseImpl(
            final ProductDomainRepository productDomainRepository
    ) {
        this.productDomainRepository = productDomainRepository;
    }

    @Override
    public ProductDomainEntity execute(
            final ProductDomainEntity product
    ) {
        return productDomainRepository.updateProduct(product);
    }
}
