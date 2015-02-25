DROP TABLE distributors;

DROP DOMAIN dom2;

-- DEPCY: This object depends on the domain we are about to create: dom2

CREATE TABLE distributors (
	did dom2,
	name character varying(40)
);

ALTER TABLE distributors OWNER TO botov_av;
