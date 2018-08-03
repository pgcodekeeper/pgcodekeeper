SET search_path = pg_catalog;

ALTER MATERIALIZED VIEW public.testview SET (fillfactor='70', user_catalog_table);
