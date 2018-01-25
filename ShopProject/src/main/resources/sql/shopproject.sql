create table shopcustomer(
	id varchar2(20) primary key,
	password varchar(20) not null,
	name varchar(20) not null,
	phone varchar(20),
	address varchar(100),
	money number
);

create table productboard(
	num number primary key,
	id varchar(20) not null,
	title varchar(100),
	content clob,
	indate date default sysdate,
	score number
);

create sequence productboard_seq;