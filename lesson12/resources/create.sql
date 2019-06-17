PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS address
(
  id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  street TEXT NOT NULL,
  houseNr TEXT NOT NULL,
  appartmentNr TEXT NOT NULL,
  zip   INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS client
(
  id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  name TEXT NOT NULL,
  surname TEXT NOT NULL,
  birthDate TEXT,
  phoneNr TEXT NOT NULL,
  addressId INTEGER NOT NULL,
  FOREIGN KEY(addressId) REFERENCES address (id)
  ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS pet
(
  id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  name TEXT NOT NULL,
  type TEXT NOT NULL,
  birthDate TEXT NOT NULL,
  masterId INTEGER NOT NULL,
  FOREIGN KEY(masterId) REFERENCES client (id)
  ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS doctor
(
  id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  name TEXT NOT NULL,
  surname TEXT NOT NULL,
  birthDate TEXT,
  phoneNr TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS visit
(
  id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  visitDate TEXT DEFAULT(date('now')),
  description TEXT,
  charge INTEGER,
  doctorId   INTEGER NOT NULL,
  petId  INTEGER NOT NULL,
  FOREIGN KEY(doctorId) REFERENCES doctor (id)
  ON DELETE CASCADE,
  FOREIGN KEY(petId) REFERENCES pet (id)
  ON DELETE CASCADE
);

CREATE VIEW IF NOT EXISTS clientView AS
  SELECT
    c.id AS masterId,
    c.name AS masterName,
    c.surname AS surname,
    c.phoneNr  AS phoneNr,
    c.birthDate AS birthDate,
    a.id AS addressId,
    a.street AS street,
    a.houseNr AS houseNr,
    a.appartmentNr AS appartmentNr,
    a.zip AS zip
  FROM client AS c INNER JOIN address AS a ON c.addressId=a.id;

CREATE VIEW IF NOT EXISTS petView AS
  SELECT
    p.id AS petId,
    p.name AS petName,
    p.type AS petType,
    p.birthDate AS petBirthDate,
    c.id AS masterId,
    c.name AS masterName,
    c.surname AS surname,
    c.phoneNr AS phoneNr,
    c.birthDate AS birthDate,
    a.id AS addressId,
    a.street AS street,
    a.houseNr AS houseNr,
    a.appartmentNr AS appartmentNr,
    a.zip AS zip
  FROM pet AS p INNER JOIN (client AS c INNER JOIN address AS a ON c.addressId=a.id) ON p.masterId=c.id;

 CREATE VIEW IF NOT EXISTS visitView AS
   SELECT d.id AS doctorId,
     d.name AS doctorName,
     d.surname AS doctorSurname,
     d.phoneNr AS doctorPhoneNr,
     d.birthDate AS doctorBirthDate,
     v.id AS visitId,
     v.visitDate AS visitDate,
     v.description AS description,
     v.charge AS charge,
     p.id AS petId,
     p.name AS petName,
     p.type AS petType,
     p.birthDate AS petBirthDate,
     c.id AS masterId,
     c.name AS masterName,
     c.surname AS surname,
     c.phoneNr AS phoneNr,
     c.birthDate AS birthDate,
     a.id AS addressId,
     a.street AS street,
     a.houseNr AS houseNr,
     a.appartmentNr AS appartmentNr,
     a.zip AS zip

   FROM doctor AS d INNER JOIN (visit AS v INNER JOIN (pet AS p INNER JOIN (client AS c INNER JOIN address AS a
    ON c.addressId=a.id)
     ON p.masterId=c.id)
      ON v.petId=p.id)
       ON v.doctorId=d.id;
