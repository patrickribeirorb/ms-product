package br.dev.patrick.product.application.port.out;

import br.dev.patrick.product.domain.Product;
import io.smallrye.mutiny.Uni;

import java.util.Collection;
import java.util.UUID;

public interface LoadProductPort {
    Uni<Product> loadProduct(UUID id);

    Uni<Collection<Product>> loadProductsByStatus(Product.Status status);
}
