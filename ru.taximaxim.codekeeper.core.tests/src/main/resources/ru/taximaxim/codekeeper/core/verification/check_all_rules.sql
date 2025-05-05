CREATE OR REPLACE FUNCTION public.f(
        param1 integer,
        param2 integer,
        param3 text,
        param4 numeric,
        param5 integer,
        param6 integer,
        param7 integer,
        OUT param8 text)
RETURNS void
        LANGUAGE plpgsql
        AS $fff$
BEGIN
    --1. check case without else
    case _object_type_src
    when 'city' then
        return query
            select city.get_place_id_list_filtered(_object_type_filter, _id_object_filter);
    when 'subregion' then
        return query
            select city.get_subregion_id_list_filtered(_object_type_filter, _id_object_filter);
    when 'region' then
        return query
            select city.get_region_id_list_filtered(_object_type_filter, _id_object_filter);
    when 'federal district' then
        return query
            select city.get_federal_district_id_list_filtered(_object_type_filter, _id_object_filter);
    when 'shard' then
        return query
            select city.get_shard_id_list_filtered(_object_type_filter, _id_object_filter);
    end case;

    -- 2. check space after if
    IF((NOT (_waypoint ->> 'isValid')::boolean) and (_type = 'restriction')) THEN
        RAISE EXCEPTION 'ERROR: restriction did not have via node';
    END IF;
    
    -- 3. check space after if
    create table table2 (id_base integer NOT NULL, c_drv_no_ord integer) on commit drop;
    
    -- 4. check space after math ops
    a=a::test <> 7 ;
    a=a+ b*(x -y);

    -- 4.1 check verifying space after MULTIPLY character in select
    select * from public.t_files;
    select count( * );
    SELECT count(*) AS count FROM public.t_files;
    SELECT count( *) AS count FROM public.t_files;
    select public.* into _sum, _curr, _id_place;
    select *, 1 as first from public.t_files;
    select 2 as second, *, 1 as first from public.t_files;
    select 2 as second,*, 1 as first from public.t_files;
    select 2 as "🙈 🙉 🙊",*, 1 as first from public.t_files;

    -- 5-6. check quote in column name, space after comma
    CREATE TEMP TABLE films (
        code                char(5),
        "title"            varchar(40),
        "did"                 integer,
        "🙈 🙉 🙊"            integer
        CONSTRAINT code_title PRIMARY KEY("🙈 🙉 🙊",title)
        );
    -- 7. check params count
    -- 8. check function body start
    -- 9. check indents,
select z.id
    from zones z
        inner join zones_1    zg on z.id = zg.id
    where z.c_future = 0
         and z.c_deleted = 0;
END;
$fff$;