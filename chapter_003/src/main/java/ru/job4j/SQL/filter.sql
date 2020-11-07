create database shop;

create table type(
    type_id serial primary key,
    name    varchar(255) not null
);
create table product(
    id           SERIAL PRIMARY KEY,
    name         varchar(255) not null,
    price        money,
    expired_date date,
    type_id      INT REFERENCES type (type_id)
);

INSERT INTO type(type_id, name) VALUES (1, 'cheese');
INSERT INTO type(type_id, name) VALUES (2, 'ice');
INSERT INTO type(type_id, name) VALUES (3, 'milk');
INSERT INTO product(name, price, expired_date, type_id) VALUES ('cheese', 100, '2020-11-05', 1);
INSERT INTO product(name, price, expired_date, type_id) VALUES ('ice', 200, '2020-11-05', 2);
INSERT INTO product(name, price, expired_date, type_id) VALUES ('milk', 300, '2020-11-05', 3);

select * from type where name = 'cheese';
select * from product where name = 'ice';
select * from product where expired_date between date('2020-11-01') and date('2020-11-30');
select * from product order by price DESC limit 1;
select * from product inner join type t on product.type_id = t.type_id;
select * from product inner join type t on product.type_id = t.type_id where t.name = 'cheese' or t.name = 'milk';
select * from type where (select count(p.id) from product as p where p.type_id = type.type_id) < 10;
select count(distinct name) from product where name = 'cheese';