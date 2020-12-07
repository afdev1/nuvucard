---------------------------------------------------------
CREATE TABLE public.administrators
(
    id serial NOT NULL,
    username varchar(16) NOT NULL,
    password varchar(72) NOT NULL,
    email varchar(254) NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    CONSTRAINT u_id_admin PRIMARY KEY (id),
    CONSTRAINT u_username_admin UNIQUE (username)
);

ALTER TABLE public.administrators
    OWNER to pfehbacyfjvatl;

COMMENT ON TABLE public.administrators
    IS 'Tabla que almacena usuarios tipo Administrador.';

---------------------------------------------------------
CREATE TABLE public.clients
(
    address varchar(90) NOT NULL,
    city varchar(32) NOT NULL,
    country varchar(30) NOT NULL,
    telephone numeric(10) NOT NULL,
    "card_number" numeric(16) NOT NULL,
    card_month numeric(2) NOT NULL,
    card_year numeric(4) NOT NULL,
    card_security_code numeric(4) NOT NULL,
    CONSTRAINT u_id_clients PRIMARY KEY (id),
    CONSTRAINT u_username_clients UNIQUE (username)
)
    INHERITS (public.administrators);

ALTER TABLE public.clients
    OWNER to pfehbacyfjvatl;

COMMENT ON TABLE public.clients
    IS 'Tabla que almacena Clientes y su tarjeta de crédito.';


--Población de administradores
INSERT INTO public.administrators(username, password, email, first_name, last_name) VALUES ('admin1', '$2y$12$ArhiUpE0QU3.Pscs02s3weV5G8Raxvn8j0NkNqFjFVXH0j3uBeP9S', 'afdeo@gmail.com', 'Andrés F.', 'De O.');


--Población de clientes
INSERT INTO public.clients(username, password, email, first_name, last_name, address, city, country, telephone, card_number, card_month, card_year, card_security_code) VALUES ('cliente1', 'abc', 'cliente1@gmail.com', 'Jose', 'Noriega', 'Calle 123 #45-67', 'Bogotá', 'Colombia', '6778899', 4929943358259506, 12, 2024, 445);
INSERT INTO public.clients(username, password, email, first_name, last_name, address, city, country, telephone, card_number, card_month, card_year, card_security_code) VALUES ('cliente2', 'abc', 'cliente2@gmail.com', 'Mario', 'Morales', 'Av. 13 #4-30', 'Cali', 'Colombia', '1231545', 2221004486092696, 5, 2028, 223);
INSERT INTO public.clients(username, password, email, first_name, last_name, address, city, country, telephone, card_number, card_month, card_year, card_security_code) VALUES ('cliente3', 'abc', 'cliente3@gmail.com', 'Laura', 'Barriga', 'Diag. 128c #60-80', 'Medellín', 'Colombia', '8787544', 376365095209469, 1, 2021, 5567);
INSERT INTO public.clients(username, password, email, first_name, last_name, address, city, country, telephone, card_number, card_month, card_year, card_security_code) VALUES ('cliente4', 'abc', 'cliente4@gmail.com', 'Rocío', 'Durcal', 'Av. 1 #45-4 casa 55', 'Barranquilla', 'Colombia', '5456878', 4485830981460930, 10, 2023, 889);
INSERT INTO public.clients(username, password, email, first_name, last_name, address, city, country, telephone, card_number, card_month, card_year, card_security_code) VALUES ('cliente5', 'abc', 'cliente5@gmail.com', 'Juan', 'González', 'Cra. 7 #5-67 int. 502', 'Manizales', 'Colombia', '8787445', 375451678193634, 4, 2022, 556);

