CREATE  SEQUENCE IF NOT EXISTS medical_facility_id_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE medical_facility
(
    id         bigint PRIMARY Key,
    name       character(50)               not null

);
