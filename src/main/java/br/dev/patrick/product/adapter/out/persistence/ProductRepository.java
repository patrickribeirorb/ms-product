package br.dev.patrick.product.adapter.out.persistence;

import br.dev.patrick.product.application.port.out.LoadProductPort;
import br.dev.patrick.product.domain.Product;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.UUID;

@ApplicationScoped
public class ProductPanacheRepository implements LoadProductPort, PanacheRepositoryBase<ProductEntity, UUID> {

    @Inject
    ProductMapper productMapper;

    @Override
    public Uni<Product> loadProduct(UUID id) {
        return this.findById(id).map(productMapper::mapToDomain);
    }

    @Override
    public Uni<Collection<Product>> loadProducts() {
        return this.listAll().map(productMapper::mapToDomainCollection);
    }
}
