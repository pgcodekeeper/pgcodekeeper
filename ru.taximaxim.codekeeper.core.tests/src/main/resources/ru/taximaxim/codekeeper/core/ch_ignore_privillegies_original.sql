CREATE USER khazieva_gr
	DEFAULT ROLE admin;

GRANT INSERT ON default.table1 TO khazieva_gr;
GRANT SELECT(c1) ON default.table1 TO khazieva_gr WITH GRANT OPTION;
GRANT SELECT(c2) ON default.table1 TO khazieva_gr WITH GRANT OPTION;