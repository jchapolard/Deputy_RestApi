--Source : https://www2.assemblee-nationale.fr/deputes/fiche/OMC_PA719318

DROP TABLE IF EXISTS deputies;
DROP TABLE IF EXISTS political_parties;

CREATE TABLE political_parties (
  id INT AUTO_INCREMENT PRIMARY KEY,
  labels VARCHAR(255) NOT NULL
  );

INSERT INTO political_parties (labels) VALUES
  ('RENAISSANCE'),
  ('FRANCE INSOUMISE'),
  ('LES RÉPUBLICAINS'),
  ('ÉCOLOGISTE - NUPES');

CREATE TABLE deputies (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  int_department INT NOT NULL,
  id_political_party INT NOT NULL,
  FOREIGN KEY (id_political_party) REFERENCES political_parties(id)
);

INSERT INTO deputies (first_name, last_name, int_department, id_political_party) VALUES
  ('Damien', 'Abad', 1, 1),
  ('Caroline', 'Abadie', 38, 1),
  ('Damien', 'Adam', 76, 1),
  
  ('Nadège', 'Abomangoli', 93, 2),
  ('Laurent', 'Alexandre', 12, 2),
  ('Gabriel', 'Amard', 69, 2),
  
  ('Emmanuelle', 'Anthoine', 26, 3),
  ('Thibault', 'Bazin', 54, 3),
  ('Valérie', 'Bazin-Malgras', 10, 3),
  
  ('Christine', 'Arrighi', 31, 4),
  ('Delphine', 'Batho', 79, 4),
  ('Julien', 'Bayou', 75, 4)
  ;

select first_name, last_name, int_department, labels  as political_party
  from deputies
  INNER JOIN political_parties 
  ON deputies.id_political_party = political_parties.id
  ORDER BY labels, last_name, first_name;
  