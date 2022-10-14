package br.dev.patrick.product.adapter.out.persistence;

import br.dev.patrick.product.adapter.out.persistence.entities.ProductEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
class ProductRepository implements PanacheRepositoryBase<ProductEntity, UUID> {
}
