SET search_path = pg_catalog;

-- HIDDEN: Object public.v2 of type VIEW (action DROP)

-- HIDDEN: Object public.v1 of type VIEW (action DROP)

ALTER TABLE public.tbl
    ALTER COLUMN name TYPE text USING name::text; /* ТИП колонки изменился - Таблица: public.tbl оригинал: integer новый: text */

-- HIDDEN: Object public.v1 of type VIEW (action CREATE)

-- HIDDEN: Object public.v2 of type VIEW (action CREATE)
