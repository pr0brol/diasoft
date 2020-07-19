
--Во всех таблицах тип данных в поле id заменён c NUMERIC(19) на BIGSERIAL не по ошибке, а чтобы flyway стабильно мигрировал таблицы,

DROP TABLE IF EXISTS persons CASCADE;
CREATE TABLE persons (
  id                      BIGSERIAL,
  first_name              VARCHAR(80) NOT NULL,
  last_name               VARCHAR(80) NOT NULL,
  middle_name             VARCHAR(80),
  position                VARCHAR(255),
  PRIMARY KEY(id)
);

INSERT INTO persons
(first_name, last_name, middle_name, position) VALUES
  ('Ivan', 'Ivanov', 'Ivanovich', 'developer'),
  ('Petr', 'Petrov', 'Petrovich', 'financer'),
  ('Sidor', 'Sidorov', 'Sidorovich', 'director');

DROP TABLE IF EXISTS contact_type CASCADE;
CREATE TABLE contact_type (
  id                     BIGSERIAL,
  type                   VARCHAR(255) UNIQUE NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO contact_type
(type) VALUES
  ('home'),
  ('mobile'),
  ('work');

DROP TABLE IF EXISTS contacts CASCADE;
CREATE TABLE contacts (
  id                     BIGSERIAL,
  person_id              BIGSERIAL NOT NULL,
  contact_type_id        BIGSERIAL NOT NULL,
  number                 VARCHAR(20) NOT NULL,
  PRIMARY KEY(id),
  CONSTRAINT fk_person_id FOREIGN KEY (person_id) references persons (id),
  CONSTRAINT fk_contact_type_id FOREIGN KEY (contact_type_id) references contact_type (id)
);

INSERT INTO contacts
(person_id, contact_type_id, number) VALUES
  (1, 1, '88-88-99'),
  (2, 2, '+7999'),
  (3, 3, '1555');