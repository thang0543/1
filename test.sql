create database Test
use Test

create table brand(
id bigint AUTO_INCREMENT,
 brand_name varchar(100) not null,
 primary key (id)
)
create table category(
id bigint AUTO_INCREMENT,
cate_code varchar(20) not null,
cate_name varchar(50) not null,
primary key(id)
)

create table status(
id bigint AUTO_INCREMENT,
status_name varchar(100),
primary key(id)
)

create table sub_category(
id bigint AUTO_INCREMENT,
sub_cate_code varchar(20) not null,
sub_cate_name varchar(50) not null,
cate_id bigint,
primary key(id),
foreign key(cate_id ) references category(id)
)

create table product(
id bigint AUTO_INCREMENT,
subcate_id bigint,
produce_name varchar(100) not null,
color varchar(50) not  null,
quantity bigint not null,
sell_price double not null,
origin_price double not null,
description varchar(1000),
status_id bigint, 
primary key(id),
foreign key(subcate_id) references sub_category(id),
foreign key(status_id) references status(id)
)
create table product_brand(
product_id bigint ,
brand_id bigint  ,

foreign key (brand_id) references brand(id),
foreign key  (product_id) references product(id)
)






