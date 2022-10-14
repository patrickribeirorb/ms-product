package br.dev.patrick.product.application.service;

import br.dev.patrick.product.application.port.out.LoadProductPort;
import br.dev.patrick.product.application.usecase.FindProductsUseCase;
import br.dev.patrick.product.domain.Product;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class FindProductsService implements FindProductsUseCase {

    @Inject
    LoadProductPort loadProductPort;

    @Override
    public Uni<Collection<Product>> findProducts(Command command) {
        return loadProductPort.loadProductsByStatus(command.status());
    }
}
