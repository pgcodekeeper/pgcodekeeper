CREATE OR REPLACE FUNCTION public.ordered_set_transition_multi(
    IN internal, boolean, boolean,
    VARIADIC "any")
  RETURNS internal AS
'ordered_set_transition_multi'
  LANGUAGE internal IMMUTABLE
  COST 1;

CREATE OR REPLACE FUNCTION public.rank_final(
    IN internal,  boolean, boolean,
    VARIADIC "any")
  RETURNS bigint AS
'hypothetical_rank_final'
  LANGUAGE internal IMMUTABLE
  COST 1;

----------------------------------------------------------------------------

CREATE AGGREGATE public.test(VARIADIC "any" ORDER BY VARIADIC "any") (
    SFUNC = ordered_set_transition_multi,
    STYPE = internal,
    FINALFUNC = rank_final,
    FINALFUNC_EXTRA
);

ALTER AGGREGATE public.test(VARIADIC "any" ORDER BY VARIADIC "any") OWNER TO shamsutdinov_lr;


CREATE AGGREGATE public.test2(VARIADIC "any") (
    SFUNC = ordered_set_transition_multi,
    STYPE = internal,
    FINALFUNC = rank_final,
    FINALFUNC_EXTRA
);

ALTER AGGREGATE public.test2(VARIADIC "any") OWNER TO shamsutdinov_lr;


CREATE AGGREGATE public.test3(ORDER BY VARIADIC "any") (
    SFUNC = ordered_set_transition_multi,
    STYPE = internal,
    FINALFUNC = rank_final,
    FINALFUNC_EXTRA
);

ALTER AGGREGATE public.test3(ORDER BY VARIADIC "any") OWNER TO shamsutdinov_lr;


CREATE AGGREGATE public.test4(boolean, boolean, VARIADIC "any") (
    SFUNC = public.ordered_set_transition_multi,
    STYPE = internal,
    FINALFUNC = public.rank_final,
    FINALFUNC_EXTRA
);

ALTER AGGREGATE public.test4(boolean, boolean, VARIADIC "any") OWNER TO shamsutdinov_lr;