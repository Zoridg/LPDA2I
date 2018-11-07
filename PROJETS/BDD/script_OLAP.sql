-------------------------------------
---- OLAP et Window functions--------
-------------------------------------

1) 1. SELECT * FROM notes WHERE netu = 11;

2. SELECT AVG(note) FROM notes WHERE netu = 11;

3. SELECT AVG(coalesce(note,0)) FROM notes WHERE netu = 11;

4. SELECT AVG(coalesce(note,20)) FROM notes WHERE netu = 11; 

5. select avg(coalesce(note,(select avg(note) from notes))) from notes where netu = 11;

2) 1. INSERT INTO ntoes VALUES('ges',1,10,'k',5);
	  INSERT INTO ntoes VALUES('ges',1,11,'k',5);

2. INSERT INTO notes VALUES ('ges',1,10,'k',10) ON CONFLICT (mat,ncont,netu) DO UPDATE SET note = random() * 20;
   INSERT INTO notes VALUES ('ges',1,11,'k',10) ON CONFLICT (mat,ncont,netu) DO UPDATE SET note = random() * 20;
   INSERT INTO notes VALUES ('ges',1,12,'l',10) ON CONFLICT (mat,ncont,netu) DO UPDATE SET note = random() * 20;
   INSERT INTO notes VALUES ('ges',1,13,'l',10) ON CONFLICT (mat,ncont,netu) DO UPDATE SET note = random() * 20;

3. WITH cte(count) AS (SELECT COUNT(*) AS count FROM notes GROUP BY netu)
SELECT AVG(count) FROM cte; 

4. WITH cte AS (SELECT netu, AVG(note) AS moy
   FROM notes
   GROUP BY netu)
   SELECT netu, moy
   FROM cte
   WHERE moy = (SELECT MAX(moy) FROM cte);

3) 1. SELECT mat, ncont, AVG(note) FROM notes GROUP BY mat, ncont;
	
2. SELECT mat, ncont, groupe, AVG(note) FROM notes GROUP BY mat, ncont, groupe;

3. SELECT mat, ncont, groupe, AVG(note) FROM notes GROUP BY ROLLUP (mat, ncont, groupe);

4. SELECT mat, ncont, groupe, AVG(note) FROM notes GROUP BY CUBE(mat, ncont, groupe);

5. SELECT mat, ncont, groupe, AVG(note) FROM notes GROUP BY GROUPING SETS(mat,ncont), GROUPING SETS(groupe);

4) 1. SELECT *, SUM(note) OVER() FROM notes;

2. SELECT *, note* 100.0/SUM(note) OVER() FROM notes;

3. 
