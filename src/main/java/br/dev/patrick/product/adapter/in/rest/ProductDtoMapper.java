package br.dev.patrick.product.adapter.in.rest;

import br.dev.patrick.product.adapter.in.rest.response.ProductDto;
import br.dev.patrick.product.domain.Product;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "cdi")
public interface ProductDtoMapper {

    ProductDto mapToDto(Product domain);

    Collection<ProductDto> mapToDtoCollection(Collection<Product> domains);
}
