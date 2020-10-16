create schema auth authorization parkon;

create table auth.users
(
    id              bigserial primary key,
    login           varchar(256) not null,
    email           varchar(512) not null,
    pswd            varchar(256) not null,
    blocked         boolean      not null,
    email_confirmed boolean      not null
);

create table auth.user_roles
(
    user_id bigint     not null,
    role    varchar(8) not null,
    constraint user_roles_users_id_fk foreign key (user_id) references auth.users
);

