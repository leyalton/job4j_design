create database tracker;

create table rule(
    rule_id   serial primary key,
    rule_name varchar(255) not null
);

create table role(
    role_id   serial primary key,
    role_name varchar(255) not null,
    role_rule int references rule (rule_id)
);

create table users(
    user_id   serial primary key,
    user_name varchar(255),
    user_role int references role (role_id)
);

create table item_category(
    category_id serial primary key,
    category_name varchar(255) not null
);

create table item_state(
    state_id   serial primary key,
    state_name varchar(255) not null
);

create table item_attach(
    attach_id   serial primary key,
    attach_name varchar(255) not null
);

create table item(
    item_id       serial primary key,
    item_name     varchar(255) not null,
    item_author   int references users (user_id),
    item_category int references item_category (category_id),
    item_state    int references item_state (state_id),
    item_file     int references item_attach (attach_id)
);

create table item_comments(
    comment_id serial primary key,
    comment    varchar(255),
    author     int references users (user_id),
    item       int references item (item_id)
);

insert into role(role_id, role_name) values (1, 'role 1');
insert into role(role_id, role_name) values (2, 'role 2');
insert into role(role_id, role_name) values (3, 'role 3');
insert into users(user_id, user_name, user_role) values (1, 'user 1', 1);
insert into users(user_id, user_name, user_role) values (2, 'user 2', 2);
insert into users(user_id, user_name, user_role) values (3, 'user 3', 3);