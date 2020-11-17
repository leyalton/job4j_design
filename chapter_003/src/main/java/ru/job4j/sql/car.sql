create database car;

create table body(
    body_id   serial primary key,
    body_name varchar(255)
);

create table motor(
    motor_id   serial primary key,
    motor_name varchar(255)
);

create table box(
    box_id   serial primary key,
    box_name varchar(255)
);

create table car(
    id serial primary key,
    name varchar(255),
    body int references body(body_id) not null,
    motor int references motor(motor_id) not null,
    box int references box(box_id) not null
);

insert into body (body_name) values ('hatchback'),('sedan'),('crossover');
insert into motor (motor_name) values ('benzine'),('diesel'),('hybrid');
insert into box (box_name) values ('auto'),('robot'),('dsg'),('electric');
insert into car (name,body,motor,box)  values ('Logan',2,1,1);
insert into car (name,body,motor,box)  values ('BMW',1,2,1);
insert into car (name,body,motor,box)  values ('Toyota',1,3,1);

select car.name, b.body_name, m.motor_name, b2.box_name
from car
join motor m on car.motor = m.motor_id
join box b2 on car.box = b2.box_id
join body b on car.body = b.body_id;

select body.body_name as unused_body
from body
left join car c
on body.body_id = c.body
where c.name is null;

select motor.motor_name as unused_motor
from motor
left join car c
on motor.motor_id = c.motor
where c.name is null;

select box.box_name as unused_box
from box
left join car c
on box.box_id = c.box
where c.name is null;