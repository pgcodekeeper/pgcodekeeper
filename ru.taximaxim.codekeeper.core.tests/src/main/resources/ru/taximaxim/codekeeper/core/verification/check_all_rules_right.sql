CREATE OR REPLACE FUNCTION public.f2(param1 integer, param2 integer, param3 text) RETURNS void
        LANGUAGE plpgsql
        AS $$
declare
    _resGh json;
    _foundTotal boolean;
    _select pbx.t_reclama_text%ROWTYPE;
    _select pbx.t_reclama_text%TYPE;
begin
    if (_eventtype is null or _eventtype not in (0, 1)) then
        perform f2 ('PLACE', _place, 'setzoneslength', msg);
    end if;
    _lenCity := null;
    IF _zoneS = _zoneE THEN
        _lenCity := 0.0;
    ELSE
        _resGh := f3(null, _latS, _logS, _latE, _lonE);
        _foundTotal = _resGh -> 'found';
        if _foundTotal = true then
            _lenCity := _resGh -> 'distance';
            _lenCity := _lenCity / 1000;
        else
            _message_text := 'Error Zone: Start - ' || _zoneS || '; End - ' || _zoneE;
            _error_text := _resGh -> 'errors';
            if _error_text is not null then
                _message_text := _message_text || '; Msg: ' || _error_text;
            end if;
            perform f1 ('PLACE', _place, 'setzoneslength', msg);
        end if;
    END IF;
    BEGIN
    EXCEPTION
        WHEN OTHERS THEN
            get stacked diagnostics
                _sqlstate = RETURNED_SQLSTATE,
                _message_text = MESSAGE_TEXT,
                _context = PG_EXCEPTION_CONTEXT;
            perform f1 ('PLACE', _place, 'setzoneslength', msg);
            raise exception 'Got exception: state: %, message: %, context: %', _sqlstate, _message_text, _context;
    END;

    case _object_type_src
    when 'city' then
        return query
            select city.f1(_object_type_filter, _id_object_filter);
    when 'subregion' then
        return query
            select city.f1(_object_type_filter, _id_object_filter);
    when 'region' then
        return query
            select city.f1(_object_type_filter, _id_object_filter);
    when 'federal' then
        return query
            select city.f1(_object_type_filter, _id_object_filter);
    when 'ss' then
        return query
            select city.f1(_object_type_filter, _id_object_filter);
    else
        _locale := context_variables.getcurrentlocale();
        raise exception '%', i18n.getstring('ParamSysExtend_ErrorObjectType', _locale);
    end case;
    a = a + b * (x - y);
    a = a::test / 0.5 - f(x, y);
    a = a::test % 0.5;

    CREATE temp TABLE t1 (
        id integer DEFAULT nextval('col22'::regclass) NOT NULL,
        col2 integer NOT NULL,
        col3 character varying(50) NOT NULL, col4 character varying(50), col5 integer
        );

EXCEPTION
    WHEN OTHERS THEN
        get stacked diagnostics
            _sqlstate = returned_sqlstate,
            _message_text = message_text,
            _context = pg_exception_context;
        raise exception 'got exception: state: %, message: %, context: %', _sqlstate, _message_text, _context;
end;
$$;

ALTER FUNCTION public.f(param1 integer, param2 integer, param3 text) OWNER TO user2;
GRANT ALL ON FUNCTION public.f(param1 integer, param2 integer, param3 text) TO user1;


