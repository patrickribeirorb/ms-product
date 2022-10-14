package br.dev.patrick.product.adapter.in.api;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public sealed interface ProductRestFacade permits ProductRest {

    @GET
    Uni<Response> getProducts();
}
