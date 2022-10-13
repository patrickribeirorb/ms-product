package br.dev.patrick.product.domain;

import br.dev.patrick.product.shared.Auditable;
import br.dev.patrick.product.shared.DomainWithId;

import java.util.Collection;

public interface Product extends DomainWithId, Auditable {

    String getName();
    void setName(String name);

    Type getType();
    void setType(Type type);

    Collection<? extends Group> getGroups();
    void setGroups(Collection<? extends Group> groups);

    Status getStatus();
    void setStatus(Status status);

    enum Status {
        ACTIVE,
        INACTIVE
    }

    interface Type extends DomainWithId {
        String getDescription();
        void setDescription(String description);

        String getShortDescription();
        void setShortDescription(String shortDescription);
    }

    interface Group extends DomainWithId {
        String getDescription();
        void setDescription(String description);
    }
}
