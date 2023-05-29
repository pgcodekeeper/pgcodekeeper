CREATE TABLE public.test_table_elm1 (
    col1 text NOT NULL ENCODING (compresstype = zlib, compresslevel = 2, blocksize = 32768),
    col2 text ENCODING (COMPRESSTYPE = none, COMPRESSLEVEL = 0, BLOCKSIZE = 32768),
    col3 text NOT NULL ENCODING (COMPRESSTYPE = none, COMPRESSLEVEL = 1, BLOCKSIZE = 32768)
)
WITH (appendonly='true', orientation='column');

ALTER TABLE public.test_table_elm1 OWNER TO shamsutdinov_er;
