CREATE OR REPLACE TRIGGER ins_same_time 
BEFORE INSERT ON Inscription 
FOR EACH ROW

DECLARE inscriptiondate DATE; 
DECLARE sortiesdate DATE; 
DECLARE difference NUMBER;

BEGIN 
SELECT S.dte 
INTO sortiesdate 
FROM Inscrition I, Sortie S 
WHERE S.idSort = I.idSort
I.pseudo = :new.pseudo; 

SELECT S.dte 
INTO inscriptiondate 
FROM Inscrition I, Sortie S 
WHERE S.idSort = :new.idSort;

SELECT DATEDIFF(hh, inscriptiondate, sortiesdate) INTO difference;

IF difference > 3
THEN raise_application_error(-20002, ('Impossible de s’inscrire à deux sorties e même temps')); 
END IF; 
END;