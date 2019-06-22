CREATE TABLE client
(
  id integer primary key not null,
  name text,
  surname text,
  address_id integer,
  date_of_birth integer,
  phone_nr text,

  FOREIGN KEY(address_id) REFERENCES address(id)
);

CREATE TABLE address
(
    id integer primary key not null,
    street text,
    house text,
    apartmentNr integer,
    zip integer
);

CREATE TABLE pet
(
    id integer primary key not null,
    name text,
    birthDate integer,
    type text,
    client_id text
);
CREATE TABLE doc (
	  id	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE
	  name	TEXT NOT NULL
	  surname	TEXT NOT NULL
	  birthdate	INTEGER
	  phone	INTEGER
);
CREATE TABLE visit (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    birthdate   INTEGER NOT NULL,
    doc_id      INTEGER REFERENCES doc (id),
    client_id   INTEGER REFERENCES client (id),
    pet_id      INTEGER REFERENCES pet (id),
    description TEXT,
    charge      INTEGER
);
