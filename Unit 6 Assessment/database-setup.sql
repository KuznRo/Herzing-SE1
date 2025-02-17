create database order_management
use order_management

create table food_menu (
id int auto_increment primary key,
name varchar(50) not null,
description varchar(100),
price decimal(2,2) not null,
created_at timestamp default current_timestamp
)
