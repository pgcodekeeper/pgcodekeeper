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