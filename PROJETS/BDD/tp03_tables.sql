-------------------
-- Suppression des différents objets
-- ATTENTION : l'ordre est important
-------------------

drop table if exists vol;
drop table if exists avion cascade;
drop table if exists pilote cascade;
drop table if exists ligne cascade;

-------------------
-- La table AVION 
-------------------

create table avion
(
    ano serial,
    type text,
    places integer CHECK (places BETWEEN 100 AND 500),
    compagnie text,
    constraint pk_avion primary key(ano)
);

-------------------
-- La table PILOTE 
-------------------

create table pilote
(
    pno serial,
    nom text,
    prenom text,
    adresse text DEFAULT 'Lille',
    constraint pk_pilote primary key(pno)
);

-------------------
-- La table LIGNE 
-------------------

create table ligne
(
    lno serial,
    depart text,
    arrivee text,
    constraint pk_ligne primary key(lno)
);

-------------------
-- La table VOL 
-------------------

create table vol
(
    ano serial, 
    pno serial,
    lno serial,
    hdep time,
    harr time CHECK (harr > hdep),
    constraint pk_vol primary key(ano,pno,lno),
    constraint fk_avion foreign key(ano) references avion(ano) ON DELETE RESTRICT ON UPDATE CASCADE,
    constraint fk_pilote foreign key(pno) references pilote(pno) ON DELETE RESTRICT ON UPDATE CASCADE, 
    constraint fk_ligne foreign key(lno) references ligne(lno)ON DELETE RESTRICT ON UPDATE CASCADE
);
