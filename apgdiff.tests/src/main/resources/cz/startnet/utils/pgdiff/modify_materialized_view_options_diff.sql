SET search_path = public, pg_catalog;

ALTER MATERIALIZED VIEW testview SET (fillfactor='70', user_catalog_table);
