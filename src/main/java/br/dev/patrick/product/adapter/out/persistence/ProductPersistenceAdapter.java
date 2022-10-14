package br.dev.patrick.product.adapter.out.persistence;

import br.dev.patrick.product.application.port.out.LoadProductPort;
import br.dev.patrick.product.domain.Product;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.UUID;

@ApplicationScoped
public class ProductPersistenceAdapter implements LoadProductPort {

    @Inject
    ProductEntityMapper productMapper;

    @Inject
    ProductRepository productRepository;

    @Override
    public Uni<Product> loadProduct(UUID id) {
        return productRepository.findById(id).map(productMapper::mapToDomain);
    }

    @Override
    public Uni<Collection<Product>> loadProductsByStatus(Product.Status status) {
        return productRepository.list("status = ?1", status)
                .map(productMapper::mapToDomainCollection);
    }
}
