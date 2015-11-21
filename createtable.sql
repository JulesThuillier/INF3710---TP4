CREATE TABLE Membre (
pseudo VARCHAR(30) PRIMARY KEY,
prenom VARCHAR(30) NOT NULL,
nom VARCHAR(30) NOT NULL,
dteNaiss DATE
);

CREATE TABLE Connexion (
pseudo VARCHAR(30) REFERENCES Membre,
debut TIMESTAMP, 
fin TIMESTAMP,
PRIMARY KEY (pseudo, debut)
);

CREATE TABLE Sortie (
idSort INTEGER PRIMARY KEY,
nom VARCHAR(30) NOT NULL, 
dte DATE NOT NULL,
responsable VARCHAR(30) REFERENCES Membre NOT NULL,
genre VARCHAR(30) NOT NULL,
description VARCHAR(200) NOT NULL,
adresse VARCHAR(100) NOT NULL,
participantsMax INTEGER NOT NULL
);

CREATE TABLE Interesse (
pseudo VARCHAR(30) REFERENCES Membre,
hobby VARCHAR(30) NOT NULL,
PRIMARY KEY (pseudo, hobby)
);

CREATE TABLE Inscription (
pseudo VARCHAR(30) REFERENCES Membre,
idSort INTEGER REFERENCES Sortie,
status INTEGER NOT NULL,
PRIMARY KEY (pseudo, idSort)
);

CREATE TABLE Amitie (
pseudo VARCHAR(30) REFERENCES Membre,
ami VARCHAR(30) REFERENCES Membre,
PRIMARY KEY (pseudo, ami)
);

CREATE TABLE Commentaire (
idSort INTEGER REFERENCES Sortie,
pseudo VARCHAR(30) REFERENCES Membre,
commentaire VARCHAR(200) NOT NULL, 
dte DATE NOT NULL
);