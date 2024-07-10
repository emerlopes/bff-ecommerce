package br.com.emerlopes.bffecommerce.domain.usecase.product;

import br.com.emerlopes.bffecommerce.domain.repository.ProductDomainRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterProductsUseCaseImpl implements RegisterProductsUseCase {

    private final ProductDomainRepository productDomainRepository;

    public RegisterProductsUseCaseImpl(
            final ProductDomainRepository productDomainRepository
    ) {
        this.productDomainRepository = productDomainRepository;
    }

    @Override
    public Void execute(
            final Void domainObject
    ) {
        productDomainRepository.registerProducts();
        return null;
    }
}
