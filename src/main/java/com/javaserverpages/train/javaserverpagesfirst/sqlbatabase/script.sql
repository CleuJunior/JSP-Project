CREATE DATABASE "jsp-postgres"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

CREATE TABLE public.model_login
(
  login character varying(200),
  password character varying(200),
  CONSTRAINT login_unique UNIQUE (login)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.model_login
  OWNER TO postgres;

INSERT INTO public.model_login(
    login, pass)
VALUES ('admin', 'admin');