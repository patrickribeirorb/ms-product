package br.dev.patrick.product.adapter.out.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "product_types")
public class TypeEntity implements DefaultEntity {

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

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
