-- Users schema

-- !Ups

CREATE TABLE Account (
    email_address varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    full_name varchar(255) NOT NULL,
    is_Admin boolean NOT NULL
);

-- !Downs

DROP TABLE Account;
