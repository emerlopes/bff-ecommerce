package br.com.emerlopes.bffecommerce.domain.shared;

public interface ExecuteArgs<T, J> {
    T execute(J domainObject);
}
