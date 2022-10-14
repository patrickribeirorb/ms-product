package br.dev.patrick.product.adapter.in.rest;

import br.dev.patrick.product.adapter.in.rest.request.ProductFilterDto;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public sealed interface ProductRestFacade permits ProductRest {

    @GET
    Uni<Response> getProducts(@BeanParam ProductFilterDto filter);
}
