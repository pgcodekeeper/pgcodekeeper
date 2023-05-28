CREATE TYPE public.int2 (
    INPUT = public.int2_in,
    OUTPUT = public.int2_out,
    INTERNALLENGTH = 4,
    PASSEDBYVALUE,
    ALIGNMENT = int4,
    STORAGE = plain,
    DEFAULT = '123',
    COMPRESSTYPE = zstd,
    COMPRESSLEVEL = 4,
    BLOCKSIZE = 20000
);

CREATE TYPE public.int3 (
    INPUT = public.int3_in,
    OUTPUT = public.int3_out,
    INTERNALLENGTH = 4,
    PASSEDBYVALUE,
    ALIGNMENT = int4,
    STORAGE = plain,
    DEFAULT = '123',
    COMPRESSTYPE = none,
    COMPRESSLEVEL = 0,
    BLOCKSIZE = 32768
);

CREATE TYPE public.int44 (
    INPUT = public.int44_in,
    OUTPUT = public.int44_out,
    INTERNALLENGTH = 4,
    PASSEDBYVALUE,
    ALIGNMENT = int4,
    STORAGE = plain,
    DEFAULT = '123',
    COMPRESSTYPE = zlib,
    COMPRESSLEVEL = 7,
    BLOCKSIZE = 32768
);