create table public.t1(c1 integer);
create table public.t2(c1 integer);
create table public.t3(c1 integer);
create table public.t4(c1 integer);
create table public.t5(c1 integer);
create table public.t6(c1 integer);
create table public.t7(c1 integer);
create table public.t8(c1 integer);
create table public.t9(c1 integer);
create table public.t10(c1 integer);
create table public.t11(c1 integer);
create table public.t12(c1 integer);
create table public.t13(c1 integer);

CREATE OR REPLACE FUNCTION public.f1() RETURNS setof text LANGUAGE plpgsql AS $$
DECLARE
    rc refcursor;
    r record;
    c integer;
BEGIN
    EXECUTE 'SELECT count(*) FROM public.t1 WHERE c1 = $1' INTO c USING 1;

    EXECUTE format('SELECT count(*) FROM %I.%I '
        'WHERE c1 = $1', 'public', 't2')
    INTO c
    USING abs(5);

    BEGIN
        c := 42 / 0;
    EXCEPTION
        WHEN division_by_zero THEN
           truncate public.t3;
    END;

    open rc for explain analyze select * from public.t4;
    close rc;
    open rc for select * from public.t5;
    close rc;
    open rc for insert into public.t6 (c1) select c1 from public.t7 returning *;
    close rc;
    open rc for update public.t8 set c1 = 6 where c1 = 5 returning *;
    close rc;
    open rc for DELETE from public.t9 where c1 = 6 returning *;
    close rc;

    FOR r IN insert into public.t10 select * from public.t11 returning c1 loop 
        raise notice 'var is %', r;
    end loop;

    return query explain insert into public.t12 (c1) values (1) returning c1;
END;
$$;
