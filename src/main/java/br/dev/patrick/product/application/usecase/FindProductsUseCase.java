package br.dev.patrick.product.application.usecase;

import br.dev.patrick.product.domain.ProductEntity;
import br.dev.patrick.product.infrastructure.ProductRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

public sealed interface FindProductsUseCase permits FindProductsUseCaseImpl {

    Uni<List<ProductEntity>> execute();
}

@ApplicationScoped
non-sealed class FindProductsUseCaseImpl implements FindProductsUseCase {

    @Inject
    ProductRepository productRepository;

    @Override
    public Uni<List<ProductEntity>> execute() {
        return productRepository.listAll();
    }
}
