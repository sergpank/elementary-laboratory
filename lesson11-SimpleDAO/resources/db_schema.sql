create table users
(
  id integer primary key,
  name text,
  login text,
  password text
);

insert into users (name, login, password) values
  ('Alexandr Alexandrov', 'alex', 'asd123'),
  ('Ivan Ivanov', 'vanya', '123456'),
  ('Pavel Pavlov', 'pasha', '1q2w3e'),
  ('Vladimir Vladimirov', 'vova', 'qwe123');

create table groups
(
  id integer primary key,
  name text,
  description text
);

insert into groups (name, description) values
  ('admin', 'super user'),
  ('user', 'regular user'),
  ('guest', 'limited acces user');

create table roles
(
  id integer primary key,
  name text,
  description text
);

insert into roles (name, description) values
  ('rwx','full access'),
  ('rw', 'read and write file, no execution premitted'),
  ('r', 'read-only access');