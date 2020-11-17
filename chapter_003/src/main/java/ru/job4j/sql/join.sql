create database job;

create table departments(
    id   serial primary key,
    name varchar(255)
);

create table employers(
    id   serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);

create table teens(
    id     serial primary key,
    name   varchar(255),
    gender varchar(255)
);

insert into departments(name) values ('dep 1');
insert into departments(name) values ('dep 2');
insert into departments(name) values ('dep 3');
insert into teens(name, gender) values ('name 1', 'male');
insert into teens(name, gender) values ('name 2', 'male');
insert into teens(name, gender) values ('name 3', 'female');
insert into teens(name, gender) values ('name 4', 'female');
insert into teens(name, gender) values ('name 5', 'male');
insert into teens(name, gender) values ('name 6', 'female');
insert into employers(name, departments_id) values ('employers 1', 1);
insert into employers(name, departments_id) values ('employers 2', 2);
insert into employers(name, departments_id) values ('employers 3', 3);
insert into employers(name, departments_id) values ('employers 4', null);
insert into employers(name, departments_id) values ('employers 5', null);
insert into employers(name, departments_id) values ('employers 6', 1);

select * from employers e left join departments d on e.departments_id = d.id;
select * from employers e right join departments d on e.departments_id = d.id;
select * from employers e full join departments d on e.departments_id = d.id;
select * from employers e cross join departments d;

select *from employers e left join departments d on e.departments_id = d.id where departments_id is null;

select * from departments d left join employers e on d.id = e.departments_id;
select * from employers e right join departments d on e.departments_id = d.id;

select * from teens x cross join teens y where x.gender != y.gender;