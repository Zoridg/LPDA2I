---------------------------------------
-- Infos :
---- Données choisies : Accidents de la route en france en 2016
---- Lien pour télécharger le csv : https://www.data.gouv.fr/fr/datasets/base-de-donnees-accidents-corporels-de-la-circulation/
---- Nathan Bergamini
---- J'avais au départ récupéré les données des accidents corporels de 2006 à 2011 survenus sur la MEL, mais je n'ai pas réussi à créer mes tables car les données n'étaient pas bien triées.
---- J'ai donc dû emprunter les tables de Ninon pour quand même pouvoir faire des requêtes et travailler sur la fouille de données.

-----------------------------------------
-- Suppression des différents objets
-----------------------------------------
DROP TABLE IF EXISTS lieux_2016 ;
DROP TABLE IF EXISTS usagers_2016 cascade;
DROP TABLE IF EXISTS vehicules_2016 cascade;
DROP TABLE IF EXISTS caracteristiques_2016 cascade;


-----------------------------------------
-- Creation des tables 
-----------------------------------------
CREATE TABLE caracteristiques_2016
(
	Num_acc text,--numero d'identifiant de l'accident 
	an text, -- annee de l'accident 
	mois text, --mois de l'accident 
	jour text, -- jour de l'accident 
	hrmn text, --heure et minute de l'accident
	lum text, -- lumiere condition d'eclairage 1: plein jour, 2: crepuscule, 3: nuit sans eclairage public, 4: nuit avec eclairage non allume, 5: nuit avec eclairage public allume
	agg text, --localisation 1: hors agglo, 2: en agglo
	int text, -- type d'intersection
	atm text, -- condition atmosphérique
	col text, --type de collision
	com text, --commune numero par insee
	--adr text probleme encodage, -- adresse postable (pour accident en agglomeration)
	gps text, --codage gps (M:metropole, A:antilles, G:guyane, R:reunion, Y:mayotte)
	lat text, --latitude
	long text, --longitude
	dep text, --departement code insee
	constraint pk_num_acc primary key(Num_acc)
);

CREATE TABLE lieux_2016
(
	Num_acc text, --identifiant identique a celui de caracteristiques
	catr text, --categorie de route (autouroute, nationale, departementale...)
	voie text, --numero de la route
	v1 text, --indice du numero de route (2 bis...)
	v2 text, --lettre indice alphanumerique de la route
	circ text, -- regime de circu (sens unique, bidirectionnelle...)
	nbv text, --nbre de voie de circulation 
	pr text, -- numero du pr de rattachement 
	pr1 text, -- distance du pr 
	vosp text, -- existence de voie reservée (piste cyclable...)
	prof text, -- profil en long déclivité de la route (plat, pente)
	plan text, -- trace en plan (partie rectiligne, en courbe...)
	lartpc text, -- largeur du terre plein central
	larrout text, -- largeur de la chaussée 
	surf text, -- etat de la surface (mouille, normale, inonde, etc)
	infra text, --amenagement (souterrain, pont, carrefour)
	situ text, --situation de l'accident (sur chausse, bande d'arret)
	env1 text, --point ecole : proxi d'une ecole
	constraint fk_num_acc foreign key(Num_acc) references caracteristiques_2016(Num_acc) on update cascade on delete restrict
); 

CREATE TABLE usagers_2016
(
	Num_acc text, --identifiant identique a celui de caracteristiques
	place text, --place occupee dans le vehicule par l'usager
	catu text, -- categorie usager (pieton, chauffeur)
	grav text, --gravite de l'accident 
	sexe text,
	trajet text, --motif du deplacement
	secu text,
	locp text, --loc du pieton 
	actp text, --action du pieton 
	etatp text, --pieton accidente ou non (seul, en groupe) 
	an_nais text, -- annee de naissance de l'usager
	num_veh text, --identifiant vehicule
	constraint fk_num_acc foreign key(Num_acc) references caracteristiques_2016(Num_acc) on update cascade on delete restrict
);

CREATE TABLE vehicules_2016
(
	Num_acc text, --identifiant identique a celui de caracteristiques
	senc text, -- sens de circulation (croissant ou decroissant) 
	catv text, -- categorie du véhicule
	occutc text, --nbre d'occupant dans le transport
	obs text, -- obstacle fixe heurte
	obsm text, -- obstacle mobile heurte (pieton, animal...)
	choc text, -- pointeur de choc 
	manv text, -- manoeuvre principale avant accident
	num_veh text, -- identifiant du vehicule 
	constraint fk_num_acc foreign key(Num_acc) references caracteristiques_2016(Num_acc) on update cascade on delete restrict
); 

---------------------------------------
-- Remplisssage des tables
---------------------------------------
\copy caracteristiques_2016 FROM /usr/local/virtual_machine/info-sil/data/caracteristiques_2016.csv DELIMITER ',' CSV;

\copy lieux_2016 FROM /usr/local/virtual_machine/info-sil/data/lieux_2016.csv DELIMITER ',' CSV;

\copy vehicules_2016 FROM /usr/local/virtual_machine/info-sil/data/vehicules_2016.csv DELIMITER ',' CSV;

\copy usagers_2016 FROM /usr/local/virtual_machine/info-sil/data/usagers_2016.csv DELIMITER ',' CSV; 

---- Lister le nombre d’accidents en agglo de l’année 2016
SELECT COUNT(*) FROM caracteristiques_2016 WHERE agg = ‘2‘ ;

---- Lister le nombre d’accidents survenus en Septembre 2016 en plein jour hors agglo
SELECT COUNT(*) FROM caracteristiques_2016 WHERE mois = '9' AND lum = '1' AND agg = '1';

---- Donner le nombre d’accidents par catégorie et par sexe en Métropole
SELECT DISTINCT sexe, COUNT(*), col FROM caracteristiques_2016 INNER JOIN usagers_2016 ON usagers_2016.Num_acc = caracteristiques_2016.Num_acc WHERE gps = 'M' GROUP BY usagers_2016.sexe, caracteristiques_2016.col;

--- Donner la catégorie de route où survient le plus d'accidents
SELECT catr, COUNT(*) FROM lieux_2016 GROUP BY catr HAVING COUNT(*) >= ALL(SELECT COUNT(*) FROM lieux_2016 as l2 GROUP BY (l2.catr));

--- Lister les accidents des usagers de sexe masculin ayant pour motif de deplacement le domicile-travail et ayant heurte un vehicule mobile durant l'accident.
SELECT usager.Num_acc FROM usagers_2016 as usager, vehicules_2016 as veh WHERE veh.Num_acc=usager.Num_acc AND  usager.sexe='1' AND trajet='1' AND veh.obsm='1'; 
