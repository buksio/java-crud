create table
    company ( id serial not null,
    name varchar(255),
    latitude float8,
    longitude float8,
    location varchar(255),
    primary key (id));

create table
    app_user ( id serial not null,
    name varchar(255),
    surname varchar(255),
    primary key (id));

create table
    user_company ( id serial not null,
    user_id int4,
    company_id int4,
    foreign key (user_id) references app_user(id) on delete cascade,
    foreign key (company_id) references company(id) on delete cascade,
    unique(user_id, company_id),
    primary key (id));