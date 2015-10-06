COMMENT ON DATABASE current_database() IS 'comments database';

COMMENT ON COLUMN typ_composite."key" IS 'Type composite key comment';

COMMENT ON COLUMN typ_composite.val IS 'Type composite val comment';

COMMENT ON TYPE typ_composite IS 'test type';

COMMENT ON DOMAIN dom IS 'test domain';

COMMENT ON SEQUENCE test_id_seq IS 'test table sequence';

COMMENT ON FUNCTION test_fnc(arg character varying) IS 'test function';

COMMENT ON TABLE test IS 'test table';

COMMENT ON COLUMN test.id IS 'id column';

COMMENT ON COLUMN test.text IS 'text column';

COMMENT ON CONSTRAINT text_check ON test IS 'text check';

COMMENT ON CONSTRAINT test_pkey ON test IS 'primary key';

COMMENT ON TRIGGER test_trigger ON test IS 'test trigger';

COMMENT ON VIEW test_view IS 'test view';

COMMENT ON COLUMN test_view.id IS 'view id col';