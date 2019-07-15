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
    type text
);
