package br.dev.patrick.product.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Data
public class Product implements DefaultDomain, Auditable {
    private UUID id;
    private String name;
    private Type type;
    private Collection<Group> groups;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public enum Status {
        ACTIVE,
        INACTIVE
    }

    @Data
    public static class Type implements DefaultDomain {
        private UUID id;
        private String description;
        private String shortDescription;
    }

    @Data
    public static class Group implements DefaultDomain {
        private UUID id;
        private String description;
    }
}
