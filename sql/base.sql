CREATE DATABASE spring_library;
\c spring_library;

-- Table type_adherant: professeur, etudiant, etc.
CREATE TABLE type_adherant (
    id_type_adherant SERIAL PRIMARY KEY,
    libelle VARCHAR(100)
);

-- Table adherant
CREATE TABLE adherant (
    id_adherant SERIAL PRIMARY KEY,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    telephone VARCHAR(20),
    id_type_adherant INT,
    FOREIGN KEY (id_type_adherant) REFERENCES type_adherant(id_type_adherant)
);

-- Table bibliothecaire
CREATE TABLE bibliothecaire (
    id_bibliothecaire SERIAL PRIMARY KEY,
    nom VARCHAR(55),
    prenom VARCHAR(55),
    email VARCHAR(55),
    mot_de_passe VARCHAR(55)
);

-- Table type_livre
CREATE TABLE type_livre (
    id_type_livre SERIAL PRIMARY KEY,
    libelle VARCHAR(100)
);

-- Table livre
CREATE TABLE livre (
    id_livre SERIAL PRIMARY KEY,
    titre VARCHAR(200),
    livre_edition VARCHAR(100),
    auteur VARCHAR(100) NOT NULL,
    date_sortie DATE,
    id_type_livre INT,
    date_ajout DATE,
    nombre_exemplaires INT,
    FOREIGN KEY (id_type_livre) REFERENCES type_livre(id_type_livre)
);

-- Table historique_nb_exemplaire
CREATE TABLE historique_nb_exemplaire (
    id_historique_exemplaire SERIAL PRIMARY KEY,
    id_livre INT,
    exemplaire_disponible INT,
    nombre_disponible INT,
    FOREIGN KEY (id_livre) REFERENCES livre(id_livre)
);

-- Table type_pret
CREATE TABLE type_pret (
    id_type_pret SERIAL PRIMARY KEY,
    libelle VARCHAR(55),
    duree_max INT
);

-- Table pret
CREATE TABLE pret (
    id_pret SERIAL PRIMARY KEY,
    id_livre INT,
    id_adherant INT,
    id_type_pret INT,
    id_bibliothecaire INT,
    date_debut TIMESTAMP,
    date_fin TIMESTAMP,
    duree DECIMAL(10,2),
    FOREIGN KEY (id_livre) REFERENCES livre(id_livre),
    FOREIGN KEY (id_adherant) REFERENCES adherant(id_adherant),
    FOREIGN KEY (id_type_pret) REFERENCES type_pret(id_type_pret),
    FOREIGN KEY (id_bibliothecaire) REFERENCES bibliothecaire(id_bibliothecaire)
);

-- Table historique_pret
CREATE TABLE historique_pret (
    id_historique_pret SERIAL PRIMARY KEY,
    id_pret INT,
    date_historique_pret TIMESTAMP,
    statut INT,
    FOREIGN KEY (id_pret) REFERENCES pret(id_pret)
);

create table penalite(
    id int,
);

---------    Reserver un exemplaire dd'un livre 

create table reservation(
    id int,
);



----------   Prolonger un pret

create table prolongement_pret(
    id int,
);



