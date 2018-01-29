drop table shopcustomer;
drop table productboard;

create table shopcustomer(
	id varchar2(20) primary key,
	password varchar(20) not null,
	name varchar(20) not null,
	phone varchar(20),
	email varchar(100),
	money number default 0
);

create table productboard(
	num number primary key,
	productCode varchar(20) not null,
	id varchar(20) not null,
	title varchar(100),
	content clob,
	indate date default sysdate,
	score number default 0
);

create sequence productboard_seq;