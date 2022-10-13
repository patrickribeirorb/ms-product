package br.dev.patrick.product.shared;

import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getCreatedAt();
    void setCreatedAt(LocalDateTime createdAt);

    LocalDateTime getUpdatedAt();
    void setUpdatedAt(LocalDateTime createdAt);

    LocalDateTime getDeletedAt();
    void setDeletedAt(LocalDateTime createdAt);
}
