use onlineEntertaiment

create table [USER](
	ID varchar(15) primary key,
	FULLNAME nvarchar(30),
	PASSWORD varchar(15),
	ADMIN bit default 0
)

create table VIDEO(
	ID varchar(15) primary key,
	TITTLE nvarchar(30),
	POSTER Nvarchar(299),
	VIEWS int,
	DESCRIPTION nvarchar(299),
	ACTIVE bit default 0
)
create table SHARE(
	ID int primary key,
	USERID varchar(15) foreign key references [USER](ID),
	VIDEOID varchar(15) foreign key references VIDEO(ID),
	EMAIL varchar(30),
	SHAREDATE date
)
create table FAVORITE(
	ID int primary key,
	USERID varchar(15) foreign key references [USER](ID),
	VIDEOID varchar(15) foreign key references VIDEO(ID),
	LIKEDATE date
)
