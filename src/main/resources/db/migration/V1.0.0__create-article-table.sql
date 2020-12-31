drop table if exists article;
create table article (
    id serial not null,
    title varchar(255) not null,
    subtitle varchar(255),
    body text not null,
    image_url  varchar(255) not null
);
