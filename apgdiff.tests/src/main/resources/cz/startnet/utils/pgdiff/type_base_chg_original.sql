CREATE TYPE public.typ_base (
    INPUT = input_func_2,
    OUTPUT = output_func_2,
    RECEIVE = receive_func_2,
    SEND = send_func_2,
    TYPMOD_IN = typmod_in_func_2,
    TYPMOD_OUT = typmod_out_func_2,
    ANALYZE = analyze_func_2,
    INTERNALLENGTH = 4,
    ALIGNMENT = char,
    STORAGE = plain,
    CATEGORY = 'U',
    PREFERRED = false,
    DEFAULT = NULL,
    COLLATABLE = true
);

ALTER TYPE public.typ_base OWNER TO botov_av;