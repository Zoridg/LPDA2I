drop table if exists typecollision cascade;
drop table if exists collision cascade;
drop table if exists organisme cascade;
drop table if exists intersection cascade;


create table typecollision
(
	type serial,
	constraint pk_typecollision primary key(type)
)

create table collision
(
	type serial,
	ono serial,
	conditionsAtmo text,
	lumiere text,
	situation int,
	nbrTues int,
	nbrBlessesG int,
	nbrBlessesL int,
	typeNum int,
	num int,
	distanceMetre int,
	libelleVoie text,
	indiceGravite float,
	nbrImpliques int,
    constraint pk_collision primary key(type,ono),
	constraint fk_typecollision foreign key(type) references typecollision(type) ON DELETE restrict ON UPDATE cascade,
	constraint fk_organisme foreign key(ono) references organisme(ono) ON DELETE restrict ON UPDATE cascade
);


create table organisme
(
	ono serial,
	constraint pk_organisme primary key(ono)
);

create table intersection
(
	type serial,
	ono serial,
	libelle text,
	agglo int,
	categorieRoute text,
	amenagement text,
	voie int,
	v1 int,
	regime text,
	nbrTotalVoie int,
	pr int,
	pr1 int,
	voieSpec text,
	profil int,
	trace text,
	lat int,
	longi int,
	numac int,
	codeInsee int,
	geoflaMatch text,
	coord float,
	constraint pk_collision primary key(type,ono),
	constraint fk_typecollision foreign key(type) references typecollision(type) ON DELETE restrict ON UPDATE cascade,
	constraint fk_organisme foreign key(ono) references organisme(ono) ON DELETE restrict ON UPDATE cascade
);

\copy typecollision FROM /usr/local/virtual_machine/info-sil/data/Typecollision.csv DELIMITER ',' CSV;

\copy collision FROM /usr/local/virtual_machine/info-sil/data/Collision.csv DELIMITER ',' CSV;

\copy organisme FROM /usr/local/virtual_machine/info-sil/data/Organisme.csv DELIMITER ',' CSV;

\copy intersection FROM /usr/local/virtual_machine/info-sil/data/Intersection.csv DELIMITER ',' CSV; 
