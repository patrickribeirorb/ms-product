package br.dev.patrick.product.shared;

import java.util.UUID;

public interface DomainWithId {
    UUID getId();
    void setId(UUID id);
}
