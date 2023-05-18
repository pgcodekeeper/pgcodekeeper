CREATE TABLE public.test_table_elm1 (
    col1 text ENCODING (compresstype = zlib, compresslevel = 1, blocksize = 32768)
)
WITH (appendonly='true', orientation = 'column');

ALTER TABLE public.test_table_elm1 OWNER TO shamsutdinov_er;
