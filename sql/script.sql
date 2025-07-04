\c postgres;
DROP DATABASE IF EXISTS bibliotheque;

CREATE DATABASE bibliotheque;

\c bibliotheque;

CREATE TABLE type_livre (
    id_type_livre INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL UNIQUE
);

-- Table livre
CREATE TABLE livre (
    id_livre INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) UNIQUE,
    edition VARCHAR(100),
    auteur VARCHAR(100) NOT NULL,
    date_sortie DATE,
    tag VARCHAR(50),
    id_type_livre INT NOT NULL,
    description TEXT,
    nombre_exemplaires INT DEFAULT 0,
    date_ajout DATE,
    FOREIGN KEY (id_type_livre) REFERENCES type_livre (id_type_livre)
);

-- Table type_pret
CREATE TABLE type_pret (
    id_type_pret INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL UNIQUE,
    duree_max INT
);

-- Table type_adherant
CREATE TABLE type_adherant (
    id_type_adherant INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL UNIQUE
);

-- Table adherant
CREATE TABLE adherant (
    id_adherant INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_type_adherant INT NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    mot_de_passe VARCHAR(255) NOT NULL,
    date_de_naissance DATE,
    adresse TEXT,
    telephone VARCHAR(20),
    date_inscription DATE,
    actif BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_type_adherant) REFERENCES type_adherant (id_type_adherant)
);

-- Table configuration_type_adherant_type_livre
CREATE TABLE configuration_type_adherant_type_livre (
    id_configuration INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_type_adherant INT NOT NULL,
    id_type_livre INT NOT NULL,
    FOREIGN KEY (id_type_adherant) REFERENCES type_adherant (id_type_adherant),
    FOREIGN KEY (id_type_livre) REFERENCES type_livre (id_type_livre),
    UNIQUE (
        id_type_adherant,
        id_type_livre
    )
);

-- Table configuration_type_adherant_type_pret
CREATE TABLE configuration_type_adherant_type_pret (
    id_configuration INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_type_adherant INT NOT NULL,
    id_type_pret INT NOT NULL,
    nombre_de_livres INT NOT NULL,
    duree_max_emprunt INT,
    FOREIGN KEY (id_type_adherant) REFERENCES type_adherant (id_type_adherant),
    FOREIGN KEY (id_type_pret) REFERENCES type_pret (id_type_pret),
    UNIQUE (
        id_type_adherant,
        id_type_pret
    )
);

-- Table exemplaire
CREATE TABLE exemplaire (
    id_exemplaire INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_livre INT NOT NULL,
    exemplaire_disponible BOOLEAN DEFAULT TRUE,
    date_ajout DATE,
    etat VARCHAR(50),
    FOREIGN KEY (id_livre) REFERENCES livre (id_livre)
);

-- Table bibliothecaire
CREATE TABLE bibliothecaire (
    id_bibliothecaire INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    mot_de_passe VARCHAR(255) NOT NULL
);

-- Table statut_pret
CREATE TABLE statut_pret (
    id_statut_pret INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL UNIQUE
);

-- Table pret
CREATE TABLE pret (
    id_pret INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_exemplaire INT NOT NULL,
    id_type_pret INT NOT NULL,
    id_bibliothecaire INT NOT NULL,
    id_adherant INT NOT NULL,
    date_debut TIMESTAMP NOT NULL,
    duree DECIMAL(10, 2),
    date_fin_prevue TIMESTAMP,
    FOREIGN KEY (id_exemplaire) REFERENCES exemplaire (id_exemplaire),
    FOREIGN KEY (id_type_pret) REFERENCES type_pret (id_type_pret),
    FOREIGN KEY (id_bibliothecaire) REFERENCES bibliothecaire (id_bibliothecaire),
    FOREIGN KEY (id_adherant) REFERENCES adherant (id_adherant)
);

-- Table historique_pret
CREATE TABLE historique_pret (
    id_historique INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_pret INT NOT NULL,
    date_historique_pret TIMESTAMP NOT NULL,
    id_statut INT NOT NULL,
    commentaire TEXT,
    FOREIGN KEY (id_pret) REFERENCES pret (id_pret),
    FOREIGN KEY (id_statut) REFERENCES statut_pret (id_statut_pret)
);

-- Table retour
CREATE TABLE retour (
    id_retour INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_pret INT NOT NULL UNIQUE,
    date_retour TIMESTAMP NOT NULL,
    etat_exemplaire VARCHAR(50),
    commentaire TEXT,
    FOREIGN KEY (id_pret) REFERENCES pret (id_pret)
);

CREATE TABLE type_penalite (
    id_type_penalite INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    libelle VARCHAR(255),
    id_type_adherant INT NOT NULL,
    nombre_de_jours INT,
    FOREIGN KEY (id_type_adherant) REFERENCES type_adherant (id_type_adherant)
);

-- Table penalite
CREATE TABLE penalite (
    id_penalite INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_adherant INT NOT NULL,
    id_type_penalite INT NOT NULL,
    date_debut TIMESTAMP,
    date_fin TIMESTAMP,
    motif TEXT,
    FOREIGN KEY (id_adherant) REFERENCES adherant (id_adherant),
    FOREIGN KEY (id_type_penalite) REFERENCES type_penalite (id_type_penalite)
);

-- Table inscription
CREATE TABLE inscription (
    id_inscription INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_adherant INT NOT NULL,
    date_inscription DATE NOT NULL,
    date_expiration DATE,
    etat VARCHAR(50) DEFAULT 'En attente',
    commentaire TEXT,
    FOREIGN KEY (id_adherant) REFERENCES adherant (id_adherant)
);

-- Table statut_reservation
CREATE TABLE statut_reservation (
    id_statut_reservation INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL UNIQUE
);

-- Table reservation
    -- id_type_pret INT NOT NULL,
    -- duree DECIMAL(10, 2),
CREATE TABLE reservation (
    id_reservation INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_adherant INT NOT NULL,
    id_exemplaire INT NOT NULL,
    date_reservation TIMESTAMP NOT NULL,
    date_expiration TIMESTAMP,
    FOREIGN KEY (id_adherant) REFERENCES adherant (id_adherant),
    FOREIGN KEY (id_exemplaire) REFERENCES exemplaire (id_exemplaire)
);

-- Table historique_reservation
CREATE TABLE historique_reservation (
    id_historique_reservation INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_bibliothecaire INT,
    id_reservation INT NOT NULL,
    date_historique TIMESTAMP NOT NULL,
    id_statut_reservation INT NOT NULL,
    commentaire TEXT,
    FOREIGN KEY (id_bibliothecaire) REFERENCES bibliothecaire (id_bibliothecaire),
    FOREIGN KEY (id_reservation) REFERENCES reservation (id_reservation),
    FOREIGN KEY (id_statut_reservation) REFERENCES statut_reservation (id_statut_reservation)
);

-- Table jour_ferie
CREATE TABLE jour_ferie (
    id_jour_ferie INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    day INT NOT NULL,
    month INT NOT NULL,
    description VARCHAR(255),
    UNIQUE (day, month)
);

-- Table configuration_reservation
CREATE TABLE configuration_reservation (
    id_configuration INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_type_adherant INT NOT NULL,
    nombre_max_reservations INT,
    duree_max_reservation INT,
    description TEXT,
    FOREIGN KEY (id_type_adherant) REFERENCES type_adherant (id_type_adherant)
);

CREATE TABLE quota_prologement(
    id_quota_prologement INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_type_adherant INT NOT NULL,
    nombre_de_jour_prologement INT NOT NULL,
    FOREIGN KEY (id_type_adherant) REFERENCES type_adherant (id_type_adherant)
);

-- Table prolongement
CREATE TABLE prolongement (
    id_prolongement INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_quota_prologement INT NOT NULL,
    id_bibliothecaire INT NOT NULL,
    id_pret INT NOT NULL,
    date_fin_prolongement TIMESTAMP NOT NULL,
    FOREIGN KEY (id_pret) REFERENCES pret(id_pret),
    FOREIGN KEY (id_quota_prologement) REFERENCES quota_prologement (id_quota_prologement),
    FOREIGN KEY (id_bibliothecaire) REFERENCES bibliothecaire (id_bibliothecaire)
);

CREATE TABLE quota_reservation (
    id_quota INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_type_adherant INT NOT NULL,
    nombre_reservations INT NOT NULL,
    FOREIGN KEY (id_type_adherant) REFERENCES type_adherant (id_type_adherant)
);