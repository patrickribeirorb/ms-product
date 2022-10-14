package br.dev.patrick.product.adapter.in.rest.response;

import java.util.UUID;

public record GroupDto(
        UUID id,
        String description
) {
}
