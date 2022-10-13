package br.dev.patrick.product.domain;

import br.dev.patrick.product.shared.DefaultEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "types")
public class TypeEntity implements Product.Type, DefaultEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "type_id")
    private UUID id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "short_description", nullable = false, unique = true, columnDefinition = "VARCHAR(5)")
    private String shortDescription;


    public TypeEntity() {
    }

    public TypeEntity(Product.Type type) {
        if (Objects.isNull(type)) return;
        id = type.getId();
        description = type.getDescription();
        shortDescription = type.getShortDescription();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
