package br.dev.patrick.product.adapter.out.persistence.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.MappedSuperclass;
import java.util.UUID;

@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
@MappedSuperclass
public interface DefaultEntity {
    UUID getId();

    void setId(UUID id);
}
