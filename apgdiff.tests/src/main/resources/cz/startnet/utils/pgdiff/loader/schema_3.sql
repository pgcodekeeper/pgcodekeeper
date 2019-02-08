CREATE SEQUENCE public."admins_aid_seq" start 1 increment 1 maxvalue 1000000000 minvalue 1 cache 1;

CREATE TABLE public."admins" (
    "aid" integer DEFAULT nextval('"admins_aid_seq"'::regclass) NOT NULL,
    "companyid" integer DEFAULT 0 NOT NULL,
    "groupid" integer DEFAULT 0 NOT NULL,
    "username" character varying NOT NULL,
    "password" character varying(40) NOT NULL,
    "superuser" boolean DEFAULT 'f'::bool NOT NULL,
    "name" character varying(40),
    "surname" character varying(40),
    "email" character varying(100) NOT NULL,
    "tel" character varying(40),
    "mobile" character varying(40),
    "enabled" boolean DEFAULT 't'::bool NOT NULL,
    "lastlogints" timestamp with time zone DEFAULT now() NOT NULL,
    "expirienced" boolean DEFAULT 'f'::bool,
    Constraint "admins_pkey" Primary Key ("aid")
);