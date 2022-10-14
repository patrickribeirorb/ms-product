package br.dev.patrick.product.adapter.in.rest.response;

import br.dev.patrick.product.domain.Product;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

public record ProductDto(
        UUID id,
        String name,
        Product.Type type,
        Collection<Product.Group> groups,
        Product.Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt
) {
}
