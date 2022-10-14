package br.dev.patrick.product.adapter.out.persistence;

import br.dev.patrick.product.adapter.out.persistence.entities.ProductEntity;
import br.dev.patrick.product.domain.Product;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "cdi")
public interface ProductEntityMapper {
    Product mapToDomain(ProductEntity entity);

    Collection<Product> mapToDomainCollection(Collection<ProductEntity> entities);

    ProductEntity mapToEntity(Product domain);

    Collection<ProductEntity> mapToEntityCollection (Collection<Product> domains);
}
