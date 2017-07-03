

------------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION pgcodekeeperhelper.%FUNCTION_NAME%(schema_oids bigint[], schema_names text[])
    RETURNS TABLE (
    json_col json,
    schema_oid bigint
    ) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
    show search_path into schema_name_current;
    FOR schema_oid, schema_name IN SELECT unnest(schema_oids), unnest(schema_names)
LOOP
    EXECUTE 'SET search_path TO ' || quote_literal(schema_name);
    RETURN QUERY (

SELECT row_to_json (json_columns), schema_oid FROM ( %FUNCTION_QEURY% ) AS json_columns);

END LOOP;
EXECUTE 'SET search_path TO ' || quote_literal(schema_name_current);
RETURN;
END
$BODY$
  LANGUAGE plpgsql;