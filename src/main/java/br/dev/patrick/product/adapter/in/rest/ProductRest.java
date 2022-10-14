package br.dev.patrick.product.adapter.in.rest;

import br.dev.patrick.product.adapter.in.rest.request.ProductFilterDto;
import br.dev.patrick.product.adapter.in.rest.response.ProductDto;
import br.dev.patrick.product.application.usecase.FindProductsUseCase;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Collection;

public non-sealed class ProductRest implements ProductRestFacade {

    @Inject
    FindProductsUseCase findProductsUseCase;

    @Inject
    ProductDtoMapper productDtoMapper;

    @Override
    public Uni<Response> getProducts(ProductFilterDto filter) {
        FindProductsUseCase.Command findProductsCommand = new FindProductsUseCase.Command(
                filter.getStatus()
        );

        return findProductsUseCase.findProducts(findProductsCommand).map(products -> {
            Collection<ProductDto> productsDto = productDtoMapper.mapToDtoCollection(products);
            return Response.ok(productsDto).build();
        });
    }
}
