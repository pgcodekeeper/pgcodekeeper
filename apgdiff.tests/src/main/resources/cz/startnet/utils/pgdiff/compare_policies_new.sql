CREATE TABLE public.t1 (c1 integer);

-- no diff
CREATE POLICY test_policy_0 ON public.t1;

-- restrictive/restrictive
CREATE POLICY test_policy_2 ON public.t1;
CREATE POLICY test_policy_3 ON public.t1 AS RESTRICTIVE;
CREATE POLICY test_policy_4 ON public.t1;

-- event
CREATE POLICY test_policy_5 ON public.t1;
CREATE POLICY test_policy_6 ON public.t1 FOR DELETE;
CREATE POLICY test_policy_7 ON public.t1;
CREATE POLICY test_policy_8 ON public.t1 FOR INSERT;

-- roles
CREATE POLICY test_policy_9 ON public.t1;
CREATE POLICY test_policy_10 ON public.t1 TO test_user_2;
CREATE POLICY test_policy_11 ON public.t1 TO test_user_2, test_user;
CREATE POLICY test_policy_12 ON public.t1 TO CURRENT_USER;

-- using
CREATE POLICY test_policy_13 ON public.t1;
CREATE POLICY test_policy_14 ON public.t1 USING (true);
CREATE POLICY test_policy_15 ON public.t1 USING (false);

-- check
CREATE POLICY test_policy_16 ON public.t1;
CREATE POLICY test_policy_17 ON public.t1 WITH CHECK (true);
CREATE POLICY test_policy_18 ON public.t1 WITH CHECK (false);

-- alterable changes
CREATE POLICY test_policy_19 ON public.t1 
  AS RESTRICTIVE
  FOR ALL
  TO test_user_2
  USING (false)
  WITH CHECK (false);

-- unalterable changes
CREATE POLICY test_policy_20 ON public.t1 
  AS PERMISSIVE
  FOR SELECT
  TO test_user
  USING (true)
  WITH CHECK (true);