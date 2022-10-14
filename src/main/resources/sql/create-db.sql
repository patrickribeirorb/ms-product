CREATE TABLE product_types
(
    type_id           UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    description       VARCHAR(255) NOT NULL,
    short_description VARCHAR(5)   NOT NULL UNIQUE
);

CREATE TABLE product_groups
(
    group_id    UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE products
(
    prod_id  UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    type_id  UUID         NOT NULL,
    group_id UUID         NOT NULL,
    status   VARCHAR(20)  NOT NULL,
    CONSTRAINT fk_products_product_types FOREIGN KEY (type_id) REFERENCES product_types (type_id),
    CONSTRAINT fk_products_product_groups FOREIGN KEY (group_id) REFERENCES product_groups (group_id)
);

CREATE TABLE associated_groups
(
    prod_id  UUID NOT NULL,
    group_id UUID NOT NULL,
    PRIMARY KEY (prod_id, group_id),
    CONSTRAINT fk_associated_groups_products FOREIGN KEY (prod_id) REFERENCES products (prod_id),
    CONSTRAINT fk_associated_groups_product_groups FOREIGN KEY (group_id) REFERENCES product_groups (group_id)
);
