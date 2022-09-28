CREATE TABLE public."MyTestTable" (
    c1 integer
);

GRANT SELECT ON TABLE public."MyTestTable" TO test;
GRANT SELECT (c1), UPDATE (c1) ON TABLE public."MyTestTable" TO test;

CREATE VIEW public."MyTestView" AS SELECT 1;

GRANT SELECT ON TABLE public."MyTestView" TO test;