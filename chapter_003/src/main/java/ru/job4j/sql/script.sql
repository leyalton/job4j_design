create database students;

create table students(
    id       serial primary key,
    LastName varchar(255),
    Money    money,
    House    int,
    City     text
);

insert into students(LastName, Money, Address, City)values ('Ivan', '500', '1', 'Moscow');
update students set Money = '1000';
delete from students;
select * from students;