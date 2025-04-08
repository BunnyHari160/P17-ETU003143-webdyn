CREATE DATABASE IF NOT EXISTS depenses ;

USE depenses;

DROP TABLE IF EXISTS previsions, depenses;

CREATE TABLE previsions (
    id_prev INT AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(100),
    montant INT 
);

CREATE TABLE depenses (
    id_dep INT AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(100),
    montant INT,
    date_insert VARCHAR(10)
);
