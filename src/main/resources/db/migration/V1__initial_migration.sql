create table users
(
    id       bigint auto_increment primary key,
    name     varchar(255) not null,
    email    varchar(255) not null unique,
    password varchar(255) not null
);

create table contact_groups
(
    id         smallint auto_increment primary key,
    group_name varchar(255) not null
);

create table contacts
(
    id         bigint auto_increment primary key,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    phone      varchar(255) null,
    email      varchar(255) null,
    address    varchar(255) null,
    user_id    bigint       not null,
    group_id   smallint     null,
    constraint contacts_users_id_fk
        foreign key (user_id) references users (id)
            on delete cascade,
    constraint contacts_groups_id_fk
        foreign key (group_id) references contact_groups (id)
);
