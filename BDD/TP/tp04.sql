CREATE TABLE notes
(
    mat text,
    ncont integer,
    netu integer,
    groupe text,
    note integer,
    primary key(mat,ncont,netu)
);


COPY notes FROM stdin;
bdd	1	10	k	5
bdd	1	11	k	6
bdd	1	12	l	7
bdd	1	13	l	8
bdd	2	10	k	9
bdd	2	12	l	11
bdd	2	13	l	12
sys	1	10	k	10
sys	1	11	k	9
sys	1	12	l	8
sys	1	13	l	7
bdd	2	11	k	20
sys	2	11	k	\N
sys	2	10	k	8
sys	2	12	l	14
sys	2	13	l	17
\.
