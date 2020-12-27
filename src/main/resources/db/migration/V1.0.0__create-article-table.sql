drop table if exists article;
create table article (
    id serial not null,
    title character varying[255] not null,
    subtitle character varying[255],
    body text not null,
    src  character varying[255] not null,
    flex smallint
);
