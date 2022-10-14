package br.dev.patrick.product.adapter.in.api;

import br.dev.patrick.product.application.usecase.FindProductsUseCase;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public non-sealed class ProductRest implements ProductRestFacade {

    @Inject
    FindProductsUseCase findProductsUseCase;

    @Override
    public Uni<Response> getProducts() {
        return findProductsUseCase.execute()
                .map(Response::ok)
                .map(Response.ResponseBuilder::build);
    }
}
