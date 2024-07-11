package br.com.emerlopes.bffecommerce.domain.repository;

import br.com.emerlopes.bffecommerce.domain.entity.ProductDomainEntity;

import java.util.List;

public interface ProductDomainRepository {
    void registerProducts();

    List<ProductDomainEntity> getProducts();
}
