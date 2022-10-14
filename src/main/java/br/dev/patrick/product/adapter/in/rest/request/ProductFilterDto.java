package br.dev.patrick.product.adapter.in.rest.request;

import br.dev.patrick.product.domain.Product;
import lombok.Data;

import javax.ws.rs.QueryParam;

@Data
public class ProductFilterDto {
    @QueryParam("status")
    private Product.Status status = Product.Status.ACTIVE;
}
