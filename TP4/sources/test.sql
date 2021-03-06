--DROP TABLE EQUIPE;
--DROP TABLE PAYS;

CREATE TABLE PAYS (
idPays CHAR(3),
nom VARCHAR(30) NOT NULL,
continent CHAR(3) NOT NULL,
CONSTRAINT PAYS_PK PRIMARY KEY (idPays)
);

CREATE TABLE EQUIPE (
idEq CHAR(3),
nom VARCHAR(80) NOT NULL,
pays CHAR(3) NOT NULL,
CONSTRAINT EQUIPE_PK PRIMARY KEY (idEq),
FOREIGN KEY (pays) REFERENCES PAYS
);

INSERT INTO PAYS VALUES ('FRA', 'FRANCE', 'EUR');
INSERT INTO PAYS VALUES ('NED', 'NETHERLANDS', 'EUR');

INSERT INTO EQUIPE VALUES ('ALM', 'AG2R LA MONDIALE', 'FRA');
INSERT INTO EQUIPE VALUES ('BEL', 'BELKIN-PRO CYCLING TEAM', 'NED');
