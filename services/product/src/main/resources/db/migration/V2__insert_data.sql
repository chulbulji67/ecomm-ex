-- Insert categories
INSERT INTO category (id, name, description)
VALUES
    (nextval('category_seq'), 'Electronics', 'Electronic items and gadgets'),
    (nextval('category_seq'), 'Books', 'Books of various genres'),
    (nextval('category_seq'), 'Clothing', 'Men and women clothing'),
    (nextval('category_seq'), 'Home Appliances', 'Appliances for daily home use');

-- Insert products for Electronics (ID = 1)
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Smartphone', 'Android smartphone', 100, 699.99, 1),
    (nextval('product_seq'), 'Laptop', 'Lightweight laptop', 50, 1299.50, 1);

-- Insert products for Books (ID = 51)
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Spring Boot in Action', 'Programming book', 200, 39.99, 51),
    (nextval('product_seq'), 'Clean Code', 'Best coding practices', 150, 45.00, 51);

-- Insert products for Clothing (ID = 101)
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'T-shirt', 'Cotton T-shirt', 300, 15.99, 101),
    (nextval('product_seq'), 'Jeans', 'Regular fit jeans', 180, 49.99, 101);

-- Insert products for Home Appliances (ID = 151)
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Mixer Grinder', 'Kitchen appliance', 80, 89.99, 151),
    (nextval('product_seq'), 'Air Purifier', 'Home air purifier', 40, 199.99, 151);
