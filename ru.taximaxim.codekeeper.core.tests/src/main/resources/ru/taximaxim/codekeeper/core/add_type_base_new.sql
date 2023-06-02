CREATE TYPE public.typ_base;

ALTER TYPE public.typ_base OWNER TO botov_av;

CREATE TYPE public.typ_base (
    INPUT = input_func,
    OUTPUT = output_func,
    RECEIVE = receive_func,
    SEND = send_func,
    TYPMOD_IN = typmod_in_func,
    TYPMOD_OUT = typmod_out_func,
    ANALYZE = analyze_func,
    INTERNALLENGTH = 3,
    PASSEDBYVALUE,
    ALIGNMENT = char,
    STORAGE = plain,
    CATEGORY = 'U',
    PREFERRED = true,
    DEFAULT = '',
    COLLATABLE = false
);

ALTER TYPE public.typ_base OWNER TO botov_av;
