--
-- CREATE_AGGREGATE
--

-- all functions CREATEd
CREATE AGGREGATE newavg (
   basetype = int4, sfunc = int4_avg_accum,  stype = _int8,
   finalfunc = int8_avg,
   initcond = '{0,0}'
);

-- test comments
COMMENT ON AGGREGATE newavg_wrong (int4) IS 'an agg comment';
COMMENT ON AGGREGATE newavg (int4) IS 'an agg comment';
COMMENT ON AGGREGATE newavg (int4) IS NULL;

-- without finalfunc; test obsolete spellings 'sfunc' etc
CREATE AGGREGATE newsum (
   basetype = int4, sfunc = int4pl, stype = int4,
   initcond = '0'
);

-- zero-argument aggregate
CREATE AGGREGATE newcnt (*) (
   sfunc = int8inc, stype = int8,
   initcond = '0', parallel = safe
);

-- old-style spelling of same (except without parallel-safe; that's too new)
CREATE AGGREGATE oldcnt (
   basetype = int8 /*'ANY'*/, 
   sfunc = int8inc, 
   stype = int8, 
   initcond = '0'
);

-- aggregate that only cares about null/nonnull input
CREATE AGGREGATE newcnt ("any") (
   sfunc = int8inc_any, stype = int8,
   initcond = '0'
);

COMMENT ON AGGREGATE nosuchagg (*) IS 'should fail';
COMMENT ON AGGREGATE newcnt (*) IS 'an agg(*) comment';
COMMENT ON AGGREGATE newcnt ("any") IS 'an agg(any) comment';

-- multi-argument aggregate
create function sum3(int8,int8,int8) returns int8 as
'select $1 + $2 + $3' language sql strict immutable;

create aggregate sum2(int8,int8) (
   sfunc = sum3, stype = int8,
   initcond = '0'
);

-- multi-argument aggregates sensitive to distinct/order, strict/nonstrict
create type aggtype as (a integer, b integer, c text);

create function aggf_trans(aggtype[],integer,integer,text) returns aggtype[]
as 'select array_append($1,ROW($2,$3,$4)::aggtype)'
language sql strict immutable;

create function aggfns_trans(aggtype[],integer,integer,text) returns aggtype[]
as 'select array_append($1,ROW($2,$3,$4)::aggtype)'
language sql immutable;

create aggregate aggfstr(integer,integer,text) (
   sfunc = aggf_trans, stype = aggtype[],
   initcond = '{}'
);

create aggregate aggfns(integer,integer,text) (
   sfunc = aggfns_trans, stype = aggtype[], sspace = 10000,
   initcond = '{}'
);

-- variadic aggregate
create function least_accum(anyelement, variadic anyarray)
returns anyelement language sql as
  'select least($1, min($2[i])) from generate_subscripts($2,1) g(i)';

create aggregate least_agg(variadic items anyarray) (
  sfunc = least_accum, stype = anyelement
);

-- test ordered-set aggs using built-in support functions
create aggregate my_percentile_disc(float8 ORDER BY anyelement) (
  sfunc = ordered_set_transition,
  stype = internal,
  finalfunc = percentile_disc_final,
  finalfunc_extra,
  finalfunc_modify = read_write
);

create aggregate my_rank(VARIADIC "any" ORDER BY VARIADIC "any") (
  sfunc = ordered_set_transition_multi,
  stype = internal,
  finalfunc = rank_final,
  finalfunc_extra,
  hypothetical
);

alter aggregate my_percentile_disc(float8 ORDER BY anyelement)
  rename to test_percentile_disc;
alter aggregate my_rank(VARIADIC "any" ORDER BY VARIADIC "any")
  rename to test_rank;



-- moving-aggregate options

CREATE AGGREGATE sumdouble (float8)
(
    sfunc = float8pl,
    stype = float8,
    mstype = float8,
    msfunc = float8pl,
    minvfunc = float8mi
);

-- aggregate combine and serialization functions

-- can't specify just one of serialfunc and deserialfunc
CREATE AGGREGATE myavg (numeric)
(
    sfunc = numeric_avg_accum,
    stype = internal,
    serialfunc = numeric_avg_serialize
);

-- serialfunc must have correct parameters
CREATE AGGREGATE myavg (numeric)
(
    sfunc = numeric_avg_accum,
    stype = internal,
    serialfunc = numeric_avg_deserialize,
    deserialfunc = numeric_avg_deserialize
);

-- deserialfunc must have correct parameters
CREATE AGGREGATE myavg (numeric)
(
    sfunc = numeric_avg_accum,
    stype = internal,
    serialfunc = numeric_avg_serialize,
    deserialfunc = numeric_avg_serialize
);

-- ensure combine function parameters are checked
CREATE AGGREGATE myavg (numeric)
(
    sfunc = numeric_avg_accum,
    stype = internal,
    serialfunc = numeric_avg_serialize,
    deserialfunc = numeric_avg_deserialize,
    combinefunc = int4larger
);

-- ensure create aggregate works.
CREATE AGGREGATE myavg (numeric)
(
    sfunc = numeric_avg_accum,
    stype = internal,
    finalfunc = numeric_avg,
    serialfunc = numeric_avg_serialize,
    deserialfunc = numeric_avg_deserialize,
    combinefunc = numeric_avg_combine,
    finalfunc_modify = shareable  -- just to test a non-default setting
);

-- Ensure all these functions made it into the catalog
SELECT aggfnoid, aggtransfn, aggcombinefn, aggtranstype::regtype,
       aggserialfn, aggdeserialfn, aggfinalmodify
FROM pg_aggregate
WHERE aggfnoid = 'myavg'::REGPROC;

DROP AGGREGATE myavg (numeric);

-- invalid: nonstrict inverse with strict forward function

CREATE FUNCTION float8mi_n(float8, float8) RETURNS float8 AS
$$ SELECT $1 - $2; $$
LANGUAGE SQL;

CREATE AGGREGATE invalidsumdouble (float8)
(
    sfunc = float8pl,
    stype = float8,
    mstype = float8,
    msfunc = float8pl,
    minvfunc = float8mi_n
);

-- invalid: non-matching result types

CREATE FUNCTION float8mi_int(float8, float8) RETURNS int AS
$$ SELECT CAST($1 - $2 AS INT); $$
LANGUAGE SQL;

CREATE AGGREGATE wrongreturntype (float8)
(
    sfunc = float8pl,
    stype = float8,
    mstype = float8,
    msfunc = float8pl,
    minvfunc = float8mi_int
);

-- invalid: non-lowercase quoted identifiers

CREATE AGGREGATE case_agg ( -- old syntax
    Basetype = int4,
    Sfunc = int4pl,
    Stype = int4,
    Initcond = '0',
    Parallel = safe
);

CREATE AGGREGATE case_agg(float8)
(
    Sfunc = ordered_set_transition,
    Stype = internal,
    Finalfunc = percentile_disc_final,
    Finalfunc_extra,
    Finalfunc_modify = read_write,
    Parallel = safe
);
