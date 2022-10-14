package br.dev.patrick.product.adapter.out.persistence;

import br.dev.patrick.product.domain.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "product_groups")
public class GroupEntity implements Product.Group, DefaultEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "group_id")
    private UUID id;

    @Column(name = "description", nullable = false)
    private String description;

    public GroupEntity() {
    }

    public GroupEntity(Product.Group group) {
        if (Objects.isNull(group)) return;
        id = group.getId();
        description = group.getDescription();
    }

    public GroupEntity(UUID id, String description) {
        this.id = id;
        this.description = description;
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
}
