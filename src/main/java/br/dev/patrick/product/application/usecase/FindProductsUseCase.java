package br.dev.patrick.product.application.usecase;

import br.dev.patrick.product.domain.Product;
import io.smallrye.mutiny.Uni;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;

public interface FindProductsUseCase {

    Uni<Collection<Product>> findProducts(@Valid Command command);

    record Command(
            @NotNull(message = "{Product.Status.NotNull}")
            Product.Status status
    ) {
    }
}
