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
    CONSTRAINT u_id_clients PRIMARY KEY (id),
    CONSTRAINT u_username_clients UNIQUE (username)
)
    INHERITS (public.administrators);

ALTER TABLE public.clients
    OWNER to pfehbacyfjvatl;

COMMENT ON TABLE public.clients
    IS 'Tabla que almacena Clientes.';


---------------------------------------------------------
CREATE TABLE public.credit_cards
(
    id serial NOT NULL,
    client_id integer NOT NULL,
    "number" numeric(16) NOT NULL,
    month numeric(2) NOT NULL,
    year numeric(4) NOT NULL,
    security_code numeric(4) NOT NULL,
    CONSTRAINT u_id_credit_cards PRIMARY KEY (id),
    CONSTRAINT u_card_client FOREIGN KEY (client_id)
        REFERENCES public.clients (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.credit_cards
    OWNER to pfehbacyfjvatl;

COMMENT ON TABLE public.credit_cards
    IS 'Tabla que almacena tarjetas de crédito de los Clientes.';


--Población de administradores
INSERT INTO public.administrators(username, password, email, first_name, last_name) VALUES ('admin1', '$2y$12$ArhiUpE0QU3.Pscs02s3weV5G8Raxvn8j0NkNqFjFVXH0j3uBeP9S', 'afdeo@gmail.com', 'Andrés F.', 'De O.');


--Población de clientes
INSERT INTO public.clients(
    username, password, email, first_name, last_name, address, city, country, telephone) VALUES ('cliente1', 'abc', 'cliente1@gmail.com', 'Pedro', 'Millas', 'Calle 123 #45-67', 'Bogotá', 'Colombia', '6778899');
