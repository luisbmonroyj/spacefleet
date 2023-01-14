#Database initialisation

## Schema creation
-- SCHEMA: spacefleet

-- DROP SCHEMA IF EXISTS spacefleet ;

CREATE SCHEMA IF NOT EXISTS spacefleet
    AUTHORIZATION postgres;

## Tables: All tables are mostly equal, except satellite that has less fields. "name" is the primary key for everyone
## Tables: Shuttle


-- Table: spacefleet.shuttle

-- DROP TABLE IF EXISTS spacefleet.shuttle;

CREATE TABLE IF NOT EXISTS spacefleet.shuttle
(
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    mass double precision DEFAULT 0,
    capacity double precision DEFAULT 0,
    thrust double precision DEFAULT 0,
    engines integer DEFAULT 0,
    location double precision[],
    rotation double precision[],
    CONSTRAINT shuttle_pkey PRIMARY KEY (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS spacefleet.shuttle
    OWNER to postgres;


## Tables: spacecraft

-- Table: spacefleet.spacecraft

-- DROP TABLE IF EXISTS spacefleet.spacecraft;

CREATE TABLE IF NOT EXISTS spacefleet.spacecraft
(
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    mass double precision DEFAULT 0,
    capacity double precision DEFAULT 0,
    thrust double precision DEFAULT 0,
    engines integer DEFAULT 0,
    location double precision[],
    rotation double precision[],
    CONSTRAINT spacecraft_pkey PRIMARY KEY (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS spacefleet.spacecraft
    OWNER to postgres;


## Tables: probe

-- Table: spacefleet.probe

-- DROP TABLE IF EXISTS spacefleet.probe;

CREATE TABLE IF NOT EXISTS spacefleet.probe
(
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    mass double precision DEFAULT 0,
    capacity double precision DEFAULT 0,
    thrust double precision DEFAULT 0,
    engines integer DEFAULT 0,
    location double precision[],
    rotation double precision[],
    CONSTRAINT probe_pkey PRIMARY KEY (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS spacefleet.probe
    OWNER to postgres;

## Tables: satellite

-- Table: spacefleet.satellite

-- DROP TABLE IF EXISTS spacefleet.satellite;

CREATE TABLE IF NOT EXISTS spacefleet.satellite
(
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    mass double precision DEFAULT 0,
    location double precision[],
    rotation double precision[],
    CONSTRAINT satellite_pkey PRIMARY KEY (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS spacefleet.satellite
    OWNER to postgres;

## Credentials:
please insert your own credentials, username and password, and maybe address and port, for the communication with postgres in the 
interface Properties.java

also remember to add the postgresql-42.5.1.jar to the project referenced libraries.