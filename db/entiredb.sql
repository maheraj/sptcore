-- Database: sptdb

-- DROP DATABASE sptdb;

CREATE DATABASE sptdb
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;


DROP TABLE IF EXISTS t_person;
CREATE TABLE IF NOT EXISTS t_person (
  id SERIAL NOT NULL,
  email_address TEXT NOT NULL,
  password TEXT NOT NULL,
  name TEXT DEFAULT NULL,
  CONSTRAINT person_pkey PRIMARY KEY (id),
  CONSTRAINT person_email_ukey UNIQUE(email_address)
)