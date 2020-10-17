create schema parkon authorization parkon;

create table parkon.parks
(
    id        bigserial primary key,
    longitude double precision,
    latitude  double precision
);

create table parkon.space
(
    id      bigserial primary key,
    park_id bigint references parkon.parks (id) not null,
    number  int                                 not null,
    status  varchar(16)                         not null,
    type    varchar(16)                         not null
);
