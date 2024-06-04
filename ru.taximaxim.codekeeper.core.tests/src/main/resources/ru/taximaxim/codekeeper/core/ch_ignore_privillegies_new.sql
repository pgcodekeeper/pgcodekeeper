CREATE USER khazieva_gr
	DEFAULT ROLE admin;

GRANT SELECT(c3) ON default.table1 TO khazieva_gr WITH GRANT OPTION;