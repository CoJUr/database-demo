-- drop table if exists PERSON;
-- create table person
-- (
--     id integer not null,
--     name varchar(255) not null,
--     location varchar(255),
--     birth_date timestamp,
--     primary key(id)
-- );
//no longer need to create the database due to hibernate schema generation of embedded db

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10001,  'Ranga', 'Hyderabad',localtime());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10002,  'James', 'New York', localtime());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10003,  'Pieter', 'Amsterdam',localtime());

select * from person;


