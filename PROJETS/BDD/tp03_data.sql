INSERT INTO pilote (nom , prenom ) VALUES ('Jordao' , 'Ninon');
INSERT INTO pilote (nom , prenom ) VALUES ('Vermersch' , 'William');
INSERT INTO pilote (nom , prenom ) VALUES ('Bergamini' , 'Nathan');

INSERT INTO avion (type, places, compagnie) VALUES ('A320', 250, 'Air Congo');
INSERT INTO avion (type, places, compagnie) VALUES ('A750', 450, 'RyanAir');
INSERT INTO avion (type, places, compagnie) VALUES ('A440', 450, 'RyanAir');

INSERT INTO ligne (depart, arrivee) VALUES ('Lille', 'Paris');
INSERT INTO ligne (depart, arrivee) VALUES ('Marseille', 'Paris');
INSERT INTO ligne (depart, arrivee) VALUES ('Marseille', 'Nice');

INSERT INTO vol(SELECT ano, pno, lno, '12:00:00', '14:00:00' FROM pilote, avion, ligne);

SELECT * FROM vol;
SELECT * FROM vol ORDER BY random();
SELECT * FROM vol ORDER BY random() FETCH FIRST 20 PERCENT ROWS ONLY;	

