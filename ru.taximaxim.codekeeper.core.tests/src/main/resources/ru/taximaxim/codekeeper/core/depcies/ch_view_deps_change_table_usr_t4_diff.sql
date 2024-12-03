-- DEPCY: This VIEW v3 depends on the COLUMN: default.t4.`Object.Key`

DROP VIEW default.v3;

ALTER TABLE default.t4
	DROP COLUMN `Object.Key`;

CREATE VIEW default.v3
(
	`Id` UInt32 NOT NULL,
	`Object.Key` Array(UInt16) NOT NULL,
	`Object.Value` Array(String) NOT NULL
)
AS SELECT * REPLACE arrayMap(x -> (x + 1), `Object.Value`) AS `Object.Value` FROM default.t4;