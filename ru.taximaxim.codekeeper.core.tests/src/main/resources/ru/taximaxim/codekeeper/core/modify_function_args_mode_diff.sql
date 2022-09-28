SET search_path = pg_catalog;

DROP FUNCTION public.fn_plpgsqltestout(param_subject text, subject_scramble text, INOUT subject_char text, OUT subject_char_out text);

CREATE OR REPLACE FUNCTION public.fn_plpgsqltestout(param_subject text, INOUT subject_scramble text, INOUT subject_char text, OUT subject_char_out text) RETURNS record
    LANGUAGE plpgsql
    AS $_$
BEGIN
    subject_scramble := substring($1, 1,CAST(random()*length($1) As integer));
    subject_char := substring($1, 1,1);
    subject_char_out := substring($1, 1,1);
END;
    $_$;

ALTER FUNCTION public.fn_plpgsqltestout(param_subject text, INOUT subject_scramble text, INOUT subject_char text, OUT subject_char_out text) OWNER TO shamsutdinov_lr;
