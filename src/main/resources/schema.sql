CREATE TABLE customers(
    customer_id bigint auto_increment primary key,
    name varchar(64) not null,
    contact_name varchar(128) not null,
    email varchar(128) not null,
    phone_number varchar(24) not null
);

CREATE TABLE orders(
    order_id bigint auto_increment primary key,
    customer_id bigint not null,
    items varchar (2048) not null,
    foreign key (customer_id) references customers(customer_id)
);

CREATE TABLE products(
    product_id bigint auto_increment primary key,
    product_name varchar(128) not null,
    price double not null
);
