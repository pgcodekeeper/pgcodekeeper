SET search_path = pg_catalog;

ALTER TABLE public.agent
	ADD COLUMN abc BIGINT;

COMMENT ON COLUMN public.agent.abc IS 'This agent supports credit system or not.';