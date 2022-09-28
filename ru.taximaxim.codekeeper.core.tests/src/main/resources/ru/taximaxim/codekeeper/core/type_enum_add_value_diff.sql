SET search_path = pg_catalog;

ALTER TYPE public.typ_enum
	ADD VALUE 'e-1' BEFORE 'e1';

ALTER TYPE public.typ_enum
	ADD VALUE 'e0' AFTER 'e-1';

ALTER TYPE public.typ_enum
	ADD VALUE 'e2.5' AFTER 'e2';
