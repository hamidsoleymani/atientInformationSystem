CREATE TABLE medical_facility
(
    id         bigint PRIMARY Key,
    name       character(50)               not null,
    address_id int references address (id) not null
);
