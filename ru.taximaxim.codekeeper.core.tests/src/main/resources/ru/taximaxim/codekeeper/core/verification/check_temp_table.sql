CREATE OR REPLACE FUNCTION test.check_temp_table() RETURNS void
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
begin
  create table table1 (id_base integer NOT NULL) on commit drop;

     create table table2 (id_base integer NOT NULL, c_drv_no_ord integer) on commit drop;
  create temp table table3 (id_base integer NOT NULL, c_drv_no_ord integer) on commit drop;
end;
$$;