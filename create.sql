create table address (id bigint not null auto_increment, city varchar(255), country varchar(255), state varchar(255), street varchar(255), zip_code varchar(255), primary key (id)) engine=InnoDB
create table country (id integer not null auto_increment, code varchar(255), name varchar(255), primary key (id)) engine=InnoDB
create table customer (id bigint not null auto_increment, email varchar(255), first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB
create table order_item (id bigint not null auto_increment, image_url varchar(255), product_id bigint, quantity integer, unit_price decimal(19,2), order_id bigint, primary key (id)) engine=InnoDB
create table orders (id bigint not null auto_increment, date_created datetime(6), last_updated datetime(6), order_tracking_number varchar(255), status varchar(255), total_price decimal(19,2), total_quantity integer, billing_address_id bigint, customer_id bigint, shipping_address_id bigint, primary key (id)) engine=InnoDB
create table product (id bigint not null auto_increment, active bit, date_created datetime(6), description varchar(255), image_url varchar(255), last_updated datetime(6), name varchar(255), sku varchar(255), unit_price decimal(19,2), units_in_stock integer, category_id bigint not null, primary key (id)) engine=InnoDB
create table product_category (id bigint not null auto_increment, category_name varchar(255), primary key (id)) engine=InnoDB
create table state (id integer not null auto_increment, name varchar(255), country_id integer, primary key (id)) engine=InnoDB
alter table order_item add constraint FKt4dc2r9nbvbujrljv3e23iibt foreign key (order_id) references orders (id)
alter table orders add constraint FKqraecqgbbr1p37ic9dr44e2dr foreign key (billing_address_id) references address (id)
alter table orders add constraint FK624gtjin3po807j3vix093tlf foreign key (customer_id) references customer (id)
alter table orders add constraint FKh0uue95ltjysfmkqb5abgk7tj foreign key (shipping_address_id) references address (id)
alter table product add constraint FK5cypb0k23bovo3rn1a5jqs6j4 foreign key (category_id) references product_category (id)
alter table state add constraint FKghic7mqjt6qb9vq7up7awu0er foreign key (country_id) references country (id)
