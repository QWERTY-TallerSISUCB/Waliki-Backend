CREATE TABLE product_category
(
    id            bigint auto_increment NOT NULL,
    category_name varchar(255)          NULL,
    CONSTRAINT pk_product_category PRIMARY KEY (id)
);

CREATE TABLE country
(
    id   INT AUTO_INCREMENT NOT NULL,
    code VARCHAR(255)       NULL,
    name VARCHAR(255)       NULL,
    CONSTRAINT pk_country PRIMARY KEY (id)
);

CREATE TABLE state
(
    id         INT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)       NULL,
    country_id INT                NULL,
    CONSTRAINT pk_state PRIMARY KEY (id)
);

ALTER TABLE state
    ADD CONSTRAINT FK_STATE_ON_COUNTRY FOREIGN KEY (country_id) REFERENCES country (id);

CREATE TABLE customer
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255)          NULL,
    last_name  VARCHAR(255)          NULL,
    email      VARCHAR(255)          NULL,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE product
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    category_id    BIGINT                NOT NULL,
    sku            VARCHAR(255)          NULL,
    name           VARCHAR(255)          NULL,
    `description`  VARCHAR(255)          NULL,
    unit_price     DECIMAL               NULL,
    image_url      VARCHAR(255)          NULL,
    active         BIT(1)                NULL,
    units_in_stock INT                   NULL,
    date_created   datetime              NULL,
    last_updated   datetime              NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES product_category (id);

CREATE TABLE address
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    street   VARCHAR(255)          NULL,
    city     VARCHAR(255)          NULL,
    state    VARCHAR(255)          NULL,
    country  VARCHAR(255)          NULL,
    zip_code VARCHAR(255)          NULL,
    order_id BIGINT                NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_ORDER FOREIGN KEY (order_id) REFERENCES orders (id);

CREATE TABLE orders
(
    id                    BIGINT AUTO_INCREMENT NOT NULL,
    order_tracking_number VARCHAR(255)          NULL,
    total_quantity        INT                   NULL,
    total_price           DECIMAL               NULL,
    status                VARCHAR(255)          NULL,
    date_created          datetime              NULL,
    last_updated          datetime              NULL,
    customer_id           BIGINT                NULL,
    shipping_address_id   BIGINT                NULL,
    billing_address_id    BIGINT                NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_BILLING_ADDRESS FOREIGN KEY (billing_address_id) REFERENCES address (id);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_SHIPPING_ADDRESS FOREIGN KEY (shipping_address_id) REFERENCES address (id);


CREATE TABLE order_item
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    image_url  VARCHAR(255)          NULL,
    unit_price DECIMAL               NULL,
    quantity   INT                   NULL,
    product_id BIGINT                NULL,
    order_id   BIGINT                NULL,
    CONSTRAINT pk_order_item PRIMARY KEY (id)
);

ALTER TABLE order_item
    ADD CONSTRAINT FK_ORDER_ITEM_ON_ORDER FOREIGN KEY (order_id) REFERENCES orders (id);



