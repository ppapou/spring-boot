CREATE TABLE customer
(
    id                  Long(20) not null AUTO_INCREMENT,
    first_name          varchar(50) not null,
    last_name           varchar(50) not null,
    password               varchar(50) not null,
    primary key (id),
)