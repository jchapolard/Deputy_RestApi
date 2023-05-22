--Source : https://www2.assemblee-nationale.fr/deputes/fiche/OMC_PA719318

DROP TABLE IF EXISTS deputies;
DROP TABLE IF EXISTS political_parties;

CREATE TABLE political_parties (
  id INT AUTO_INCREMENT PRIMARY KEY,
  labels VARCHAR(255) NOT NULL
  );

CREATE TABLE deputies (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  int_department INT NOT NULL,
  id_political_party INT NOT NULL,
  FOREIGN KEY (id_political_party) REFERENCES political_parties(id)
);