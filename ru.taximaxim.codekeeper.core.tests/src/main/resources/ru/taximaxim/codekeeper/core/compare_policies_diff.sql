SET search_path = pg_catalog;

DROP POLICY test_policy_1 ON public.t1;

CREATE POLICY test_policy_2 ON public.t1;

DROP POLICY test_policy_3 ON public.t1;

DROP POLICY test_policy_5 ON public.t1;

DROP POLICY test_policy_6 ON public.t1;

DROP POLICY test_policy_8 ON public.t1;

ALTER POLICY test_policy_9 ON public.t1
  TO PUBLIC;

ALTER POLICY test_policy_10 ON public.t1
  TO test_user_2;

ALTER POLICY test_policy_12 ON public.t1
  TO CURRENT_USER;

DROP POLICY test_policy_13 ON public.t1;

ALTER POLICY test_policy_14 ON public.t1
  USING (true);

ALTER POLICY test_policy_15 ON public.t1
  USING (false);

DROP POLICY test_policy_16 ON public.t1;

ALTER POLICY test_policy_17 ON public.t1
  WITH CHECK (true);

ALTER POLICY test_policy_18 ON public.t1
  WITH CHECK (false);

ALTER POLICY test_policy_19 ON public.t1
  TO test_user_2
  USING (false)
  WITH CHECK (false);

DROP POLICY test_policy_20 ON public.t1;

CREATE POLICY test_policy_3 ON public.t1
  AS RESTRICTIVE;

CREATE POLICY test_policy_5 ON public.t1;

CREATE POLICY test_policy_6 ON public.t1
  FOR DELETE;

CREATE POLICY test_policy_8 ON public.t1
  FOR INSERT;

CREATE POLICY test_policy_13 ON public.t1;

CREATE POLICY test_policy_16 ON public.t1;

CREATE POLICY test_policy_20 ON public.t1
  FOR SELECT
  TO test_user
  USING (true)
  WITH CHECK (true);