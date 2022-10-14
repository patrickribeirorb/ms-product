package br.dev.patrick.product.adapter.out.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import static br.dev.patrick.product.domain.Product.*;

@Entity
@Table(name = "products")
public class ProductEntity extends AuditableEntity implements DefaultEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "prod_id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private TypeEntity type;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "associated_groups",
            joinColumns = @JoinColumn(name = "prod_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Collection<GroupEntity> groups;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }

    public Collection<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(Collection<? extends Group> groups) {
        if (Objects.isNull(groups)) this.groups = null;
        this.groups = groups.stream()
                .map(GroupEntity::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
