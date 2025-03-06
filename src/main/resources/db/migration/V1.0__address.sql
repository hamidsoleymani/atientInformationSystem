CREATE SEQUENCE IF NOT EXISTS address_id_seq START WITH 1 INCREMENT BY 1;
create table address
(
    id                  bigint primary key,
    country             varchar(20) not null,
    city                varchar(20) not null,
    street              varchar(20) not null,
    zip_code            varchar(10) not null,
    building_nr         varchar(5)  not null,
    medical_facility_id bigint
);
