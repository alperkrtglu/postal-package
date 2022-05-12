INSERT INTO SENDER (id, name, surname, email)
VALUES (10000, 'Ali', 'Kurt', 'ali@gmail.com');

INSERT INTO POSTMAN (id, name, surname)
VALUES (10000, 'Murat', 'Aydos');

INSERT INTO SHIPMENT (id, sender_id, postman_id)
VALUES (10000, 10000, 10000);

INSERT INTO ADDRESS (id, city, address, shipment_id)
VALUES (10000, 'ANKARA', 'Basinevleri', 10000);

INSERT INTO TAG (id, name)
VALUES (10000, 'FRAGILE');

INSERT INTO TAG (id, name)
VALUES (10001, 'ELECTRONIC');

INSERT INTO SHIPMENT_TAG (id, shipment_id, tag_id)
VALUES (10000, 10000, 10000);

INSERT INTO SHIPMENT_TAG (id, shipment_id, tag_id)
VALUES (10001, 10000, 10001);