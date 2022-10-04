CREATE AGGREGATE alt_agg1 (basetype = int4, sfunc = int4pl,  stype = int4, initcond = 0);
ALTER AGGREGATE alt_agg1(int) RENAME TO alt_func3;
ALTER AGGREGATE alt_agg1(int) OWNER TO regress_alter_generic_user3;
ALTER AGGREGATE alt_agg1(int) SET SCHEMA alt_nsp2;
 
create aggregate my_sum_init(int4)
(
   sfunc = avg_transfn,
   stype = avg_state,
   finalfunc = sum_finalfn,
   initcond = '(10,0)'
);

create aggregate my_avg_init(int4)
(
   sfunc = avg_transfn,
   stype = avg_state,
   finalfunc = avg_finalfn,
   initcond = '(10,0)'
);

create aggregate my_avg_init2(int4)
(
   sfunc = avg_transfn,
   stype = avg_state,
   finalfunc = avg_finalfn,
   initcond = '(4,0)'
);

CREATE AGGREGATE balk(int4)
(
    SFUNC = balkifnull/*(int8, int4)*/,
    STYPE = int8,
    PARALLEL = SAFE,
    INITCOND = '0'
);

SELECT balk(hundred) FROM tenk1;

CREATE AGGREGATE balk(int4)
(
    SFUNC = int4_sum/*(int8, int4)*/,
    STYPE = int8,
    COMBINEFUNC = balkifnull/*(int8, int8)*/,
    PARALLEL = SAFE,
    INITCOND = '0'
);


CREATE AGGREGATE newavg (
   basetype = int4, sfunc = int4_avg_accum,  stype = _int8,
   finalfunc = int8_avg,
   initcond = '{0,0}'
);

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

create aggregate sum2(int8,int8) (
   sfunc = sum3, stype = int8,
   initcond = '0'
);

create aggregate aggfstr(integer,integer,text) (
   sfunc = aggf_trans, stype = aggtype[],
   initcond = '{}'
);

create aggregate aggfns(integer,integer,text) (
   sfunc = aggfns_trans, stype = aggtype[], sspace = 10000,
   initcond = '{}'
);

create aggregate least_agg(variadic items anyarray) (
  sfunc = least_accum, stype = anyelement
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

-- ensure combine function parameters are checked
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

DROP AGGREGATE myavg (numeric);

CREATE AGGREGATE case_agg(float8)
(
    Sfunc = ordered_set_transition,
    Stype = internal,
    Finalfunc = percentile_disc_final,
    Finalfunc_extra,
    Finalfunc_modify = read_write,
    Parallel = safe
);