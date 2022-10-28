INSERT INTO products(id, number) VALUES (1, '001');
INSERT INTO products(id, number) VALUES (2, '002');
INSERT INTO products(id, number) VALUES (3, '003');
INSERT INTO products(id, number) VALUES (4, '004');
INSERT INTO products(id, number) VALUES (5, '005');

INSERT INTO records(application_number, manufacturer_name, substance_name) VALUES ('application1', 'manufacture1', 'subs1');
INSERT INTO records(application_number, manufacturer_name, substance_name) VALUES ('application2', 'manufacture2', 'subs2');

INSERT INTO records_products(id, application_number_id, product_id) VALUES (1, 'application1', 1);
INSERT INTO records_products(id, application_number_id, product_id) VALUES (2, 'application1', 2);
INSERT INTO records_products(id, application_number_id, product_id) VALUES (3, 'application2', 3);
INSERT INTO records_products(id, application_number_id, product_id) VALUES (4, 'application2', 4);
INSERT INTO records_products(id, application_number_id, product_id) VALUES (5, 'application2', 5);