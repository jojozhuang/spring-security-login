INSERT INTO customers (name, contact_name, email, phone_number) values ('Apple', 'Tim Cook', 'tcook@apple.com', '1-408-386-2351');
INSERT INTO customers (name, contact_name, email, phone_number) values ('Google', 'Sundar Pichai', 'spichai@google.com', '1-408-386-2355');
INSERT INTO customers (name, contact_name, email, phone_number) values ('Meta', 'Mark Zuckerberg', 'mzuckerberg@meta.com', '1-408-386-2357');
INSERT INTO customers (name, contact_name, email, phone_number) values ('Amazon', 'Jeff Bezos', 'jbezos@amazon.com', '1-408-386-2358');
INSERT INTO customers (name, contact_name, email, phone_number) values ('Netflix', 'Reed Hastings', 'reedhastings@netflix.com', '1-408-386-6666');
INSERT INTO customers (name, contact_name, email, phone_number) values ('Microsoft', 'Satya Nadella', 'snadella@microsoft.com', '1-408-386-7755');
INSERT INTO customers (name, contact_name, email, phone_number) values ('Tesla', 'Elon Musk', 'emusk@tesla.com', '1-408-386-8862');

INSERT INTO orders (customer_id, items) values ((SELECT customer_id FROM customers where name = 'Apple'), 'Macbook Pro');
INSERT INTO orders (customer_id, items) values ((SELECT customer_id FROM customers where name = 'Apple'), 'iPhone 13 Pro');
INSERT INTO orders (customer_id, items) values ((SELECT customer_id FROM customers where name = 'Microsoft'), 'XBox S');
INSERT INTO orders (customer_id, items) values ((SELECT customer_id FROM customers where name = 'Tesla'), 'Model S');
INSERT INTO orders (customer_id, items) values ((SELECT customer_id FROM customers where name = 'Tesla'), 'Model Y');

INSERT INTO products (product_name, price) values ('Macbook Pro', 2299.00);
INSERT INTO products (product_name, price) values ('iPhone 13 Pro', 799.00);
INSERT INTO products (product_name, price) values ('XBox S', 649.00);
INSERT INTO products (product_name, price) values ('Model S', 45999.00);
INSERT INTO products (product_name, price) values ('Model Y', 76999.00);

INSERT INTO users (username, password, enabled) values ('johnny', 'abc123', true);
INSERT INTO users (username, password, enabled) values ('admin', 'abc123', true);

INSERT INTO authorities (username, authority) values ('johnny', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('admin', 'ROLE_ADMIN');
