package br.dev.patrick.product.domain;

import br.dev.patrick.product.shared.Auditable;
import br.dev.patrick.product.shared.DefaultDomain;

import java.util.Collection;

public interface Product extends DefaultDomain, Auditable {

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

    interface Type extends DefaultDomain {
        String getDescription();
        void setDescription(String description);

        String getShortDescription();
        void setShortDescription(String shortDescription);
    }

    interface Group extends DefaultDomain {
        String getDescription();
        void setDescription(String description);
    }
}
