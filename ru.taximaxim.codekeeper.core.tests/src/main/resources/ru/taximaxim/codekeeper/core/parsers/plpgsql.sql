begin
    if new.roomno != old.roomno then
        update WSlot set roomno = new.roomno where roomno = old.roomno;
    end if;
    return new;
end;

begin
    delete from WSlot where roomno = old.roomno;
    return old;
end;

begin
    if new.name != old.name then
        update PSlot set pfname = new.name where pfname = old.name;
    end if;
    return new;
end;

begin
    delete from PSlot where pfname = old.name;
    return old;
end;

declare
    pfrec   record;
    ps          alias for new;
begin
    select into pfrec * from PField where name = ps.pfname;
    if not found then
        raise exception $$Patchfield "%" does not exist$$, ps.pfname;
    end if;
    return ps;
end;

begin
    if new.name != old.name then
        update IFace set sysname = new.name where sysname = old.name;
    end if;
    return new;
end;

declare
    sname   text;
    sysrec  record;
begin
    select into sysrec * from system where name = new.sysname;
    if not found then
        raise exception $q$system "%" does not exist$q$, new.sysname;
    end if;
    sname := 'IF.' || new.sysname;
    sname := sname || '.';
    sname := sname || new.ifname;
    if length(sname) > 20 then
        raise exception 'IFace slotname "%" too long (20 char max)', sname;
    end if;
    new.slotname := sname;
    return new;
end;

declare
    hname   text;
    dummy   integer;
begin
    if tg_op = 'INSERT' then
    dummy := tg_hub_adjustslots(new.name, 0, new.nslots);
    return new;
    end if;
    if tg_op = 'UPDATE' then
    if new.name != old.name then
        update HSlot set hubname = new.name where hubname = old.name;
    end if;
    dummy := tg_hub_adjustslots(new.name, old.nslots, new.nslots);
    return new;
    end if;
    if tg_op = 'DELETE' then
    dummy := tg_hub_adjustslots(old.name, old.nslots, 0);
    return old;
    end if;
end;

begin
    if newnslots = oldnslots then
        return 0;
    end if;
    if newnslots < oldnslots then
        delete from HSlot where hubname = hname and slotno > newnslots;
    return 0;
    end if;
    for i in oldnslots + 1 .. newnslots loop
        insert into HSlot (slotname, hubname, slotno, slotlink)
        values ('HS.dummy', hname, i, '');
    end loop;
    return 0;
end;

declare
    sname   text;
    xname   HSlot.slotname%TYPE;
    hubrec  record;
begin
    select into hubrec * from Hub where name = new.hubname;
    if not found then
        raise exception 'no manual manipulation of HSlot';
    end if;
    if new.slotno < 1 or new.slotno > hubrec.nslots then
        raise exception 'no manual manipulation of HSlot';
    end if;
    if tg_op = 'UPDATE' and new.hubname != old.hubname then
       /* if count(*) > 0 from Hub where name = old.hubname then
            raise exception 'no manual manipulation of HSlot';
        end if;*/
    end if;
    sname := 'HS.' || trim(new.hubname);
    sname := sname || '.';
    sname := sname || new.slotno::text;
    if length(sname) > 20 then
        raise exception 'HSlot slotname "%" too long (20 char max)', sname;
    end if;
    new.slotname := sname;
    return new;
end;

declare
    hubrec  record;
begin
    select into hubrec * from Hub where name = old.hubname;
    if not found then
        return old;
    end if;
    if old.slotno > hubrec.nslots then
        return old;
    end if;
    raise exception 'no manual manipulation of HSlot';
end;

begin
    if substr(new.slotname, 1, 2) != tg_argv[0] then
        raise exception 'slotname must begin with %', tg_argv[0];
    end if;
    return new;
end;

begin
    if new.slotlink isnull then
        new.slotlink := '';
    end if;
    return new;
end;

begin
    if new.backlink isnull then
        new.backlink := '';
    end if;
    return new;
end;

begin
    if new.slotname != old.slotname then
        delete from PSlot where slotname = old.slotname;
    insert into PSlot (
            slotname,
            pfname,
            slotlink,
            backlink
        ) values (
            new.slotname,
            new.pfname,
            new.slotlink,
            new.backlink
        );
        return null;
    end if;
    return new;
end;

begin
    if new.slotname != old.slotname then
        delete from WSlot where slotname = old.slotname;
    insert into WSlot (
            slotname,
            roomno,
            slotlink,
            backlink
        ) values (
            new.slotname,
            new.roomno,
            new.slotlink,
            new.backlink
        );
        return null;
    end if;
    return new;
end;

begin
    if new.slotname != old.slotname then
        delete from PLine where slotname = old.slotname;
    insert into PLine (
            slotname,
            phonenumber,
            comment,
            backlink
        ) values (
            new.slotname,
            new.phonenumber,
            new.comment,
            new.backlink
        );
        return null;
    end if;
    return new;
end;

begin
    if new.slotname != old.slotname then
        delete from IFace where slotname = old.slotname;
    insert into IFace (
            slotname,
            sysname,
            ifname,
            slotlink
        ) values (
            new.slotname,
            new.sysname,
            new.ifname,
            new.slotlink
        );
        return null;
    end if;
    return new;
end;

begin
    if new.slotname != old.slotname or new.hubname != old.hubname then
        delete from HSlot where slotname = old.slotname;
    insert into HSlot (
            slotname,
            hubname,
            slotno,
            slotlink
        ) values (
            new.slotname,
            new.hubname,
            new.slotno,
            new.slotlink
        );
        return null;
    end if;
    return new;
end;

begin
    if new.slotname != old.slotname then
        delete from PHone where slotname = old.slotname;
    insert into PHone (
            slotname,
            comment,
            slotlink
        ) values (
            new.slotname,
            new.comment,
            new.slotlink
        );
        return null;
    end if;
    return new;
end;

declare
    dummy   integer;
begin
    if tg_op = 'INSERT' then
        if new.backlink != '' then
        dummy := tg_backlink_set(new.backlink, new.slotname);
    end if;
    return new;
    end if;
    if tg_op = 'UPDATE' then
        if new.backlink != old.backlink then
        if old.backlink != '' then
            dummy := tg_backlink_unset(old.backlink, old.slotname);
        end if;
        if new.backlink != '' then
            dummy := tg_backlink_set(new.backlink, new.slotname);
        end if;
    else
        if new.slotname != old.slotname and new.backlink != '' then
            dummy := tg_slotlink_set(new.backlink, new.slotname);
        end if;
    end if;
    return new;
    end if;
    if tg_op = 'DELETE' then
        if old.backlink != '' then
        dummy := tg_backlink_unset(old.backlink, old.slotname);
    end if;
    return old;
    end if;
end;

declare
    mytype  char(2);
    link    char(4);
    rec     record;
begin
    mytype := substr(myname, 1, 2);
    link := mytype || substr(blname, 1, 2);
    if link = 'PLPL' then
        raise exception
        'backlink between two phone lines does not make sense';
    end if;
    if link in ('PLWS', 'WSPL') then
        raise exception
        'direct link of phone line to wall slot not permitted';
    end if;
    if mytype = 'PS' then
        select into rec * from PSlot where slotname = myname;
    if not found then
        raise exception '% does not exist', myname;
    end if;
    if rec.backlink != blname then
        update PSlot set backlink = blname where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'WS' then
        select into rec * from WSlot where slotname = myname;
    if not found then
        raise exception '% does not exist', myname;
    end if;
    if rec.backlink != blname then
        update WSlot set backlink = blname where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'PL' then
        select into rec * from PLine where slotname = myname;
    if not found then
        raise exception '% does not exist', myname;
    end if;
    if rec.backlink != blname then
        update PLine set backlink = blname where slotname = myname;
    end if;
    return 0;
    end if;
    raise exception 'illegal backlink beginning with %', mytype;
end;

declare
    myname  alias for $1;
    blname  alias for $2;
    mytype  char(2);
    rec     record;
begin
    mytype := substr(myname, 1, 2);
    if mytype = 'PS' then
        select into rec * from PSlot where slotname = myname;
    if not found then
        return 0;
    end if;
    if rec.backlink = blname then
        update PSlot set backlink = '' where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'WS' then
        select into rec * from WSlot where slotname = myname;
    if not found then
        return 0;
    end if;
    if rec.backlink = blname then
        update WSlot set backlink = '' where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'PL' then
        select into rec * from PLine where slotname = myname;
    if not found then
        return 0;
    end if;
    if rec.backlink = blname then
        update PLine set backlink = '' where slotname = myname;
    end if;
    return 0;
    end if;
end;

declare
    dummy   integer;
begin
    if tg_op = 'INSERT' then
        if new.slotlink != '' then
        dummy := tg_slotlink_set(new.slotlink, new.slotname);
    end if;
    return new;
    end if;
    if tg_op = 'UPDATE' then
        if new.slotlink != old.slotlink then
        if old.slotlink != '' then
            dummy := tg_slotlink_unset(old.slotlink, old.slotname);
        end if;
        if new.slotlink != '' then
            dummy := tg_slotlink_set(new.slotlink, new.slotname);
        end if;
    else
        if new.slotname != old.slotname and new.slotlink != '' then
            dummy := tg_slotlink_set(new.slotlink, new.slotname);
        end if;
    end if;
    return new;
    end if;
    if tg_op = 'DELETE' then
        if old.slotlink != '' then
        dummy := tg_slotlink_unset(old.slotlink, old.slotname);
    end if;
    return old;
    end if;
end;

declare
    myname  alias for $1;
    blname  alias for $2;
    mytype  char(2);
    link    char(4);
    rec     record;
begin
    mytype := substr(myname, 1, 2);
    link := mytype || substr(blname, 1, 2);
    if link = 'PHPH' then
        raise exception
        'slotlink between two phones does not make sense';
    end if;
    if link in ('PHHS', 'HSPH') then
        raise exception
        'link of phone to hub does not make sense';
    end if;
    if link in ('PHIF', 'IFPH') then
        raise exception
        'link of phone to hub does not make sense';
    end if;
    if link in ('PSWS', 'WSPS') then
        raise exception
        'slotlink from patchslot to wallslot not permitted';
    end if;
    if mytype = 'PS' then
        select into rec * from PSlot where slotname = myname;
    if not found then
        raise exception '% does not exist', myname;
    end if;
    if rec.slotlink != blname then
        update PSlot set slotlink = blname where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'WS' then
        select into rec * from WSlot where slotname = myname;
    if not found then
        raise exception '% does not exist', myname;
    end if;
    if rec.slotlink != blname then
        update WSlot set slotlink = blname where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'IF' then
        select into rec * from IFace where slotname = myname;
    if not found then
        raise exception '% does not exist', myname;
    end if;
    if rec.slotlink != blname then
        update IFace set slotlink = blname where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'HS' then
        select into rec * from HSlot where slotname = myname;
    if not found then
        raise exception '% does not exist', myname;
    end if;
    if rec.slotlink != blname then
        update HSlot set slotlink = blname where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'PH' then
        select into rec * from PHone where slotname = myname;
    if not found then
        raise exception '% does not exist', myname;
    end if;
    if rec.slotlink != blname then
        update PHone set slotlink = blname where slotname = myname;
    end if;
    return 0;
    end if;
    raise exception 'illegal slotlink beginning with %', mytype;
end;


declare
    myname  alias for $1;
    blname  alias for $2;
    mytype  char(2);
    rec     record;
begin
    mytype := substr(myname, 1, 2);
    if mytype = 'PS' then
        select into rec * from PSlot where slotname = myname;
    if not found then
        return 0;
    end if;
    if rec.slotlink = blname then
        update PSlot set slotlink = '' where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'WS' then
        select into rec * from WSlot where slotname = myname;
    if not found then
        return 0;
    end if;
    if rec.slotlink = blname then
        update WSlot set slotlink = '' where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'IF' then
        select into rec * from IFace where slotname = myname;
    if not found then
        return 0;
    end if;
    if rec.slotlink = blname then
        update IFace set slotlink = '' where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'HS' then
        select into rec * from HSlot where slotname = myname;
    if not found then
        return 0;
    end if;
    if rec.slotlink = blname then
        update HSlot set slotlink = '' where slotname = myname;
    end if;
    return 0;
    end if;
    if mytype = 'PH' then
        select into rec * from PHone where slotname = myname;
    if not found then
        return 0;
    end if;
    if rec.slotlink = blname then
        update PHone set slotlink = '' where slotname = myname;
    end if;
    return 0;
    end if;
end;

declare
    rec     record;
    bltype  char(2);
    retval  text;
begin
    select into rec * from PSlot where slotname = $1;
    if not found then
        return '';
    end if;
    if rec.backlink = '' then
        return '-';
    end if;
    bltype := substr(rec.backlink, 1, 2);
    if bltype = 'PL' then
        declare
        rec     record;
    begin
        select into rec * from PLine where slotname = "outer".rec.backlink;
        retval := 'Phone line ' || trim(rec.phonenumber);
        if rec.comment != '' then
            retval := retval || ' (';
        retval := retval || rec.comment;
        retval := retval || ')';
        end if;
        return retval;
    end;
    end if;
    if bltype = 'WS' then
        select into rec * from WSlot where slotname = rec.backlink;
    retval := trim(rec.slotname) || ' in room ';
    retval := retval || trim(rec.roomno);
    retval := retval || ' -> ';
    return retval || wslot_slotlink_view(rec.slotname);
    end if;
    return rec.backlink;
end;

declare
    psrec   record;
    sltype  char(2);
    retval  text;
begin
    select into psrec * from PSlot where slotname = $1;
    if not found then
        return '';
    end if;
    if psrec.slotlink = '' then
        return '-';
    end if;
    sltype := substr(psrec.slotlink, 1, 2);
    if sltype = 'PS' then
    retval := trim(psrec.slotlink) || ' -> ';
    return retval || pslot_backlink_view(psrec.slotlink);
    end if;
    if sltype = 'HS' then
        retval := comment from Hub H, HSlot HS
            where HS.slotname = psrec.slotlink
              and H.name = HS.hubname;
        retval := retval || ' slot ';
    retval := retval || slotno::text from HSlot
            where slotname = psrec.slotlink;
    return retval;
    end if;
    return psrec.slotlink;
end;

declare
    rec     record;
    sltype  char(2);
    retval  text;
begin
    select into rec * from WSlot where slotname = $1;
    if not found then
        return '';
    end if;
    if rec.slotlink = '' then
        return '-';
    end if;
    sltype := substr(rec.slotlink, 1, 2);
    if sltype = 'PH' then
        select into rec * from PHone where slotname = rec.slotlink;
    retval := 'Phone ' || trim(rec.slotname);
    if rec.comment != '' then
        retval := retval || ' (';
        retval := retval || rec.comment;
        retval := retval || ')';
    end if;
    return retval;
    end if;
    if sltype = 'IF' then
    declare
        syrow   System%RowType;
        ifrow   IFace%ROWTYPE;
        begin
        select into ifrow * from IFace where slotname = rec.slotlink;
        select into syrow * from System where name = ifrow.sysname;
        retval := syrow.name || ' IF ';
        retval := retval || ifrow.ifname;
        if syrow.comment != '' then
            retval := retval || ' (';
        retval := retval || syrow.comment;
        retval := retval || ')';
        end if;
        return retval;
    end;
    end if;
    return rec.slotlink;
end;

DECLARE rslt text;
BEGIN
    IF $1 <= 0 THEN
        rslt = CAST($2 AS TEXT);
    ELSE
        rslt = CAST($1 AS TEXT) || ',' || recursion_test($1 - 1, $2);
    END IF;
    RETURN rslt;
END;

declare
begin
  insert into found_test_tbl values (1);
  if FOUND then
     insert into found_test_tbl values (2);
  end if;

  update found_test_tbl set a = 100 where a = 1;
  if FOUND then
    insert into found_test_tbl values (3);
  end if;

  delete from found_test_tbl where a = 9999; -- matches no rows
  if not FOUND then
    insert into found_test_tbl values (4);
  end if;

  for i in 1 .. 10 loop
    -- no need to do anything
  end loop;
  if FOUND then
    insert into found_test_tbl values (5);
  end if;

  -- never executes the loop
  for i in 2 .. 1 loop
    -- no need to do anything
  end loop;
  if not FOUND then
    insert into found_test_tbl values (6);
  end if;
  return true;
end;

DECLARE
    rec RECORD;
BEGIN
    FOR rec IN select * from found_test_tbl LOOP
        RETURN NEXT rec;
    END LOOP;
    RETURN;
END;

DECLARE
    row found_test_tbl%ROWTYPE;
BEGIN
    FOR row IN select * from found_test_tbl LOOP
        RETURN NEXT row;
    END LOOP;
    RETURN;
END;

DECLARE
    i int;
BEGIN
    FOR i IN $1 .. $2 LOOP
        RETURN NEXT i + 1;
    END LOOP;
    RETURN;
END;

DECLARE
    retval RECORD;
BEGIN
    IF $1 > 10 THEN
        SELECT INTO retval 5, 10, 15;
        RETURN NEXT retval;
        RETURN NEXT retval;
    ELSE
        SELECT INTO retval 50, 5::numeric, 'xxx'::text;
        RETURN NEXT retval;
        RETURN NEXT retval;
    END IF;
    RETURN;
END;

DECLARE
    retval RECORD;
BEGIN
    IF $1 > 10 THEN
        SELECT INTO retval 5, 10, 15;
        RETURN retval;
    ELSE
        SELECT INTO retval 50, 5::numeric, 'xxx'::text;
        RETURN retval;
    END IF;
END;

BEGIN
    IF $1 < 20 THEN
        INSERT INTO perform_test VALUES ($1, $1 + 10);
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;

BEGIN
    IF FOUND then
        INSERT INTO perform_test VALUES (100, 100);
    END IF;

    PERFORM perform_simple_func(5);

    IF FOUND then
        INSERT INTO perform_test VALUES (100, 100);
    END IF;

    PERFORM perform_simple_func(50);

    IF FOUND then
        INSERT INTO perform_test VALUES (100, 100);
    END IF;

    RETURN;
END;

declare x int;
    sx smallint;
begin
    begin   -- start a subtransaction
        raise notice 'should see this';
        x := 100 / $1;
        raise notice 'should see this only if % <> 0', $1;
        sx := $1;
        raise notice 'should see this only if % fits in smallint', $1;
        if $1 < 0 then
            raise exception '% is less than zero', $1;
        end if;
    exception
        when division_by_zero then
            raise notice 'caught division_by_zero';
            x := -1;
        when NUMERIC_VALUE_OUT_OF_RANGE then
            raise notice 'caught numeric_value_out_of_range';
            x := -2;
    end;
    return x;
end;

declare x int;
    sx smallint;
    y int;
begin
    begin   -- start a subtransaction
        x := 100 / $1;
        sx := $1;
        select into y unique1 from tenk1 where unique2 =
            (select unique2 from tenk1 b where ten = $1);
    exception
        when data_exception then  -- category match
            raise notice 'caught data_exception';
            x := -1;
        when NUMERIC_VALUE_OUT_OF_RANGE OR CARDINALITY_VIOLATION then
            raise notice 'caught numeric_value_out_of_range or cardinality_violation';
            x := -2;
    end;
    return x;
end;

declare x int;
begin
  x := 1;
  insert into foo values(x);
  begin
    x := x + 1;
    insert into foo values(x);
    raise exception 'inner';
  exception
    when others then
      x := x * 10;
  end;
  insert into foo values(x);
  return x;
end;

begin
  declare x int;
  begin
    -- we assume this will take longer than 2 seconds:
    select count(*) into x from tenk1 a, tenk1 b, tenk1 c;
  exception
    when others then
      raise notice 'caught others?';
    when query_canceled then
      raise notice 'nyeah nyeah, cant stop me';
  end;
  -- Abort transaction to abandon the statement_timeout setting.  Otherwise,
  -- the next top-level statement would be vulnerable to the timeout.
  raise exception 'end of function';
end;

declare x text;
begin
  x := '1234';
  begin
    x := x || '5678';
    -- force error inside subtransaction SPI context
    perform trap_zero_divide(-100);
  exception
    when others then
      x := x || '9012';
  end;
  return x;
end;

begin
    begin   -- start a subtransaction
        insert into slave values($1);
    exception
        when foreign_key_violation then
            raise notice 'caught foreign_key_violation';
            return 0;
    end;
    return 1;
end;

begin
    begin   -- start a subtransaction
        set constraints all immediate;
    exception
        when foreign_key_violation then
            raise notice 'caught foreign_key_violation';
            return 0;
    end;
    return 1;
end;

declare x int;
begin
  select into x id from users where login = a_login;
  if found then return x; end if;
  return 0;
end;

declare my_id_user int;
begin
  my_id_user = sp_id_user( a_login );
  IF  my_id_user > 0 THEN
    RETURN -1;  -- error code for existing user
  END IF;
  INSERT INTO users ( login ) VALUES ( a_login );
  my_id_user = sp_id_user( a_login );
  IF  my_id_user = 0 THEN
    RETURN -2;  -- error code for insertion failure
  END IF;
  RETURN my_id_user;
end;

declare
    rc refcursor;
begin
    open rc for select a from rc_test;
    return rc;
end;

declare
    rc refcursor;
    x record;
begin
    rc := return_unnamed_refcursor();
    fetch next from rc into x;
    return x.a;
end;

begin
    open rc for select a from rc_test;
    return rc;
end;

begin
    perform return_refcursor($1);
    return $1;
end;

declare
    c1 cursor (param1 int, param2 int) for select * from rc_test where a > param1 and b > param2;
    nonsense record;
begin
    open c1($1, $2);
    fetch c1 into nonsense;
    close c1;
    if found then
        return true;
    else
        return false;
    end if;
end;

declare
    c1 cursor (param1 int, param12 int) for select * from rc_test where a > param1 and b > param12;
    nonsense record;
begin
    open c1(param12 := $2, param1 := $1);
    fetch c1 into nonsense;
    close c1;
    if found then
        return true;
    else
        return false;
    end if;
end;

declare
    c1 cursor (param1 int, param2 int) for select * from rc_test where a > param1 and b > param2;
    nonsense record;
begin
    open c1(param1 := $1, $2);
    fetch c1 into nonsense;
    close c1;
    if found then
        return true;
    else
        return false;
    end if;
end;

declare
    c1 cursor (param1 int, param2 int) for select * from rc_test where a > param1 and b > param2;
begin
    open c1(param2 := 20, 21);
end;

declare
    c1 cursor (param1 int, param2 int) for select * from rc_test where a > param1 and b > param2;
begin
    open c1(20, param1 := 21);
end;

declare
  c1 cursor (p1 int, p2 int) for
    select * from tenk1 where thousand = p1 and tenthous = p2;
begin
  open c1 (p2 := 77, p2 := 42);
end;

declare
  c1 cursor (p1 int, p2 int) for
    select * from tenk1 where thousand = p1 and tenthous = p2;
begin
  open c1 (p2 := 77);
end;

declare
  c1 cursor (p1 int, p2 int) for
    select * from tenk1 where thousand = p1 and tenthous = p2;
begin
  open c1 (p2 := 77, p1 := 42/0);
end;

declare
  c1 cursor (p1 int, p2 int) for
    select count(*) from tenk1 where thousand = p1 and tenthous = p2;
  n int4;
begin
  open c1 (77 -- test
  , 42);
  fetch c1 into n;
  return n;
end;

declare
  c1 cursor (p1 int, p2 int, debug int) for
    select count(*) from tenk1 where thousand = p1 and tenthous = p2
      and four = debug;
  p2 int4 := 1006;
  n int4;
begin
  open c1 (p1 := p1, p2 := p2, debug := 2);
  fetch c1 into n;
  return n;
end;

begin
    raise notice 'This message has too many parameters!', $1;
    return $1;
end;

begin
    raise notice 'This message has too few parameters: %, %, %', $1, $1;
    return $1;
end;

begin
    raise notice 'This message has no parameters (despite having %% signs in it)!';
    return $1;
end;

BEGIN
   BEGIN
       RAISE syntax_error;
   EXCEPTION
       WHEN syntax_error THEN
           BEGIN
               raise notice 'exception % thrown in inner block, reraising', sqlerrm;
               RAISE;
           EXCEPTION
               WHEN OTHERS THEN
                   raise notice 'RIGHT - exception % caught in inner block', sqlerrm;
           END;
   END;
EXCEPTION
   WHEN OTHERS THEN
       raise notice 'WRONG - exception % caught in outer block', sqlerrm;
END;

declare
    _r record;
    _rt eifoo%rowtype;
    _v eitype;
    i int;
    j int;
    k int;
begin
    execute 'insert into '||$1||' values(10,15)';
    execute 'select (row).* from (select row(10,1)::eifoo) s' into _r;
    raise notice '% %', _r.i, _r.y;
    execute 'select * from '||$1||' limit 1' into _rt;
    raise notice '% %', _rt.i, _rt.y;
    execute 'select *, 20 from '||$1||' limit 1' into i, j, k;
    raise notice '% % %', i, j, k;
    execute 'select 1,2' into _v;
    return _v;
end;

begin
    raise notice '% %', sqlstate, sqlerrm;
end;

begin
    begin
        begin
            raise notice '% %', sqlstate, sqlerrm;
        end;
    end;
end;

begin
    begin
        raise exception 'user exception';
    exception when others then
        raise notice 'caught exception % %', sqlstate, sqlerrm;
        begin
            raise notice '% %', sqlstate, sqlerrm;
            perform 10/0;
        exception
            when substring_error then
                -- this exception handler shouldn't be invoked
                raise notice 'unexpected exception: % %', sqlstate, sqlerrm;
            when division_by_zero then
                raise notice 'caught exception % %', sqlstate, sqlerrm;
        end;
        raise notice '% %', sqlstate, sqlerrm;
    end;
end;

begin
    begin perform 1/0;
    exception when others then return sqlerrm; end;
end;

declare
    a integer[] = '{10,20,30}';
    c varchar = 'xyz';
    i integer;
begin
    i := 2;
    raise notice '%; %; %; %; %; %', a, a[i], c, (select c || 'abc'), row(10,'aaa',NULL,30), NULL;
end;

declare
  x int;
  y int;
begin
  select into x,y unique1/p1, unique1/$1 from tenk1 group by unique1/p1;
  return x = y;
end;

declare x record;
begin
  -- should work
  insert into foo values(5,6) returning * into x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  -- should fail due to implicit strict
  insert into foo values(7,8),(9,10) returning * into x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  -- should work
  execute 'insert into foo values(5,6) returning *' into x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  -- this should work since EXECUTE isn't as picky
  execute 'insert into foo values(7,8),(9,10) returning *' into x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  -- should work
  select * from foo where f1 = 3 into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  -- should fail, no rows
  select * from foo where f1 = 0 into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  -- should fail, too many rows
  select * from foo where f1 > 3 into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  -- should work
  execute 'select * from foo where f1 = 3' into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  -- should fail, no rows
  execute 'select * from foo where f1 = 0' into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  -- should fail, too many rows
  execute 'select * from foo where f1 > 3' into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare
x record;
p1 int := 2;
p3 text := 'foo';
begin
  -- no rows
  select * from foo where f1 = p1 and f1::text = p3 into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare
x record;
p1 int := 2;
p3 text := 'foo';
begin
  select * from foo where f1 > p1 or f1::text = p3  into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  select * from foo where f1 > 3 into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  execute 'select * from foo where f1 = $1 or f1::text = $2' using 0, 'foo' into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  execute 'select * from foo where f1 > $1' using 1 into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare x record;
begin
  execute 'select * from foo where f1 > 3' into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

#print_strict_params off
declare
x record;
p1 int := 2;
p3 text := 'foo';
begin
  select * from foo where f1 > p1 or f1::text = p3  into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

#print_strict_params on
declare
x record;
p1 int := 2;
p3 text := 'foo';
begin
  select * from foo where f1 > p1 or f1::text = p3  into strict x;
  raise notice 'x.f1 = %, x.f2 = %', x.f1, x.f2;
end;

declare
in1 int;
out1 int;
begin
end;

declare
in1 int;
out1 int;
begin
end;

declare
f1 int;
begin
    declare
    f1 int;
    begin
    end;
end;

declare
in1 int;
begin
    declare
    in1 int;
    begin
    end;
end;

declare
f1 int;
c1 cursor (f1 int) for select 1;
begin
end;

declare f1 int; begin return 1; end;

declare
  c scroll cursor for select f1 from int4_tbl;
  x integer;
begin
  open c;
  fetch last from c into x;
  while found loop
    return next x;
    fetch prior from c into x;
  end loop;
  close c;
end;

declare
  c no scroll cursor for select f1 from int4_tbl;
  x integer;
begin
  open c;
  fetch last from c into x;
  while found loop
    return next x;
    fetch prior from c into x;
  end loop;
  close c;
end;

declare
  c refcursor;
  x integer;
begin
  open c scroll for select f1 from int4_tbl;
  fetch last from c into x;
  while found loop
    return next x;
    fetch prior from c into x;
  end loop;
  close c;
end;

declare
  c refcursor;
  x integer;
begin
  open c scroll for execute 'select f1 from int4_tbl';
  fetch last from c into x;
  while found loop
    return next x;
    fetch relative -2 from c into x;
  end loop;
  close c;
end;

declare
  c refcursor;
  x integer;
begin
  open c scroll for execute 'select f1 from int4_tbl';
  fetch last from c into x;
  while found loop
    return next x;
    move backward 2 from c;
    fetch relative -1 from c into x;
  end loop;
  close c;
end;

declare
  c cursor for select * from generate_series(1, 10);
  x integer;
begin
  open c;
  loop
      move relative 2 in c;
      if not found then
          exit;
      end if;
      fetch next from c into x;
      if found then
          return next x;
      end if;
  end loop;
  close c;
end;

declare
  c cursor for select * from generate_series(1, 10);
  x integer;
begin
  open c;
  move forward all in c;
  fetch backward from c into x;
  if found then
    return next x;
  end if;
  close c;
end;

<<outerblock>>
declare
  param1 int := 1;
begin
  <<innerblock>>
  declare
    param1 int := 2;
  begin
    raise notice 'param1 = %', param1;
    raise notice 'pl_qual_names.param1 = %', pl_qual_names.param1;
    raise notice 'outerblock.param1 = %', outerblock.param1;
    raise notice 'innerblock.param1 = %', innerblock.param1;
  end;
end;

begin
    $1 := -1;
    $2 := -2;
    return next;
    return query select x + 1, x * 10 from generate_series(0, 10) s (x);
    return next;
end;

begin
    return query select md5(s.x::text), s.x, s.x > 0
                 from generate_series(-8, lim) s (x) where s.x % 2 = 0;
end;

declare i int;
begin
  for i in execute 'select * from generate_series(1,$1)' using $1+1 loop
    raise notice '%', i;
  end loop;
  execute 'select $2 + $2*3 + length($1)' into i using $2,$1;
  return i;
end;

declare
  c refcursor;
  i int;
begin
  open c for execute 'select * from generate_series(1,$1)' using $1+1;
  loop
    fetch c into i;
    exit when not found;
    raise notice '%', i;
  end loop;
  close c;
  return;
end;

declare
  c cursor(r1 integer, r2 integer)
       for select * from generate_series(r1,r2) i;
  c2 cursor
       for select * from generate_series(41,43) i;
begin
  for r in c(5,7) loop
    raise notice '% from %', r.i, c;
  end loop;
  -- again, to test if cursor was closed properly
  for r in c(9,10) loop
    raise notice '% from %', r.i, c;
  end loop;
  -- and test a parameterless cursor
  for r in c2 loop
    raise notice '% from %', r.i, c2;
  end loop;
  -- and try it with a hand-assigned name
  raise notice 'after loop, c2 = %', c2;
  c2 := 'special_name';
  for r in c2 loop
    raise notice '% from %', r.i, c2;
  end loop;
  raise notice 'after loop, c2 = %', c2;
  -- and try it with a generated name
  -- (which we can't show in the output because it's variable)
  c2 := null;
  for r in c2 loop
    raise notice '%', r.i;
  end loop;
  raise notice 'after loop, c2 = %', c2;
  return;
end;

declare
  c cursor for select * from forc_test;
begin
  for r in c loop
    raise notice '%, %', r.i, r.j;
    update forc_test set i = i * 100, j = r.j * 2 where current of c;
  end loop;
end;

declare
  c refcursor := 'fooled_ya';
  r record;
begin
  open c for select * from forc_test;
  loop
    fetch c into r;
    exit when not found;
    raise notice '%, %', r.i, r.j;
    update forc_test set i = i * 100, j = r.j * 2 where current of c;
  end loop;
end;

declare
  c refcursor;
begin
  for r in c loop
    raise notice '%', r.i;
  end loop;
end;

begin
  return query execute 'select * from (values(10),(20)) f';
  return query execute 'select * from (values($1),($2)) f' using 40,50;
end;

begin
  return query select * from tabwithcols;
  return query execute 'select * from tabwithcols';
end;

declare
  v compostype;
begin
  v := (1, 'hello');
  return v;
end;

declare
  v record;
begin
  v := (1, 'hello'::varchar);
  return v;
end;

begin
  return (1, 'hello'::varchar);
end;

begin
  return (1, 'hello');
end;

begin
  return (1, 'hello')::compostype;
end;

declare
  v record;
begin
  v := (1, 'hello');
  return v;
end;

begin
  for i in 1 .. 3
  loop
    return next (1, 'hello'::varchar);
  end loop;
  return next null::compostype;
  return next (2, 'goodbye')::compostype;
end;

begin
  return 1 + 1;
end;

declare x int := 42;
begin
  return x;
end;

declare
  v compostype;
begin
  v := (1, 'hello');
  return v;
end;

begin
  return (1, 'hello')::compostype;
end;

begin
  raise notice '% % %', 1, 2, 3
     using errcode = '55001', detail = 'some detail info', hint = 'some hint';
  raise '% % %', 1, 2, 3
     using errcode = 'division_by_zero', detail = 'some detail info';
end;

begin
  raise 'check me'
     using errcode = 'division_by_zero', detail = 'some detail info';
  exception
    when others then
      raise notice 'SQLSTATE: % SQLERRM: %', sqlstate, sqlerrm;
      raise;
end;

begin
  raise 'check me'
     using errcode = '1234F', detail = 'some detail info';
  exception
    when others then
      raise notice 'SQLSTATE: % SQLERRM: %', sqlstate, sqlerrm;
      raise;
end;

begin
  raise 'check me'
     using errcode = '1234F', detail = 'some detail info';
  exception
    when sqlstate '1234F' then
      raise notice 'SQLSTATE: % SQLERRM: %', sqlstate, sqlerrm;
      raise;
end;

begin
  raise division_by_zero using detail = 'some detail info';
  exception
    when others then
      raise notice 'SQLSTATE: % SQLERRM: %', sqlstate, sqlerrm;
      raise;
end;

begin
  raise division_by_zero;
end;

begin
  raise sqlstate '1234F';
end;

begin
  raise division_by_zero using message = 'custom' || ' message';
end;

begin
  raise using message = 'custom' || ' message', errcode = '22012';
end;

begin
  raise notice 'some message' using message = 'custom' || ' message', errcode = '22012';
end;

begin
  raise division_by_zero using message = 'custom' || ' message', errcode = '22012';
end;

begin
  raise;
end;

declare v int := 0;
begin
  return 10 / v;
end;

begin
  raise exception 'custom exception'
     using detail = 'some detail of custom exception',
           hint = 'some hint related to custom exception';
end;

declare _sqlstate text;
        _message text;
        _context text;
begin
  perform zero_divide();
exception when others then
  get stacked diagnostics
        _sqlstate = returned_sqlstate,
        _message = message_text,
        _context = pg_exception_context;
  raise notice 'sqlstate: %, message: %, context: [%]',
    _sqlstate, _message, replace(_context, E'\n', ' <- ');
end;

declare _detail text;
        _hint text;
        _message text;
begin
  perform raise_test();
exception when others then
  get stacked diagnostics
        _message = message_text,
        _detail = pg_exception_detail,
        _hint = pg_exception_hint;
  raise notice 'message: %, detail: %, hint: %', _message, _detail, _hint;
end;

declare _detail text;
        _hint text;
        _message text;
begin
  get stacked diagnostics
        _message = message_text,
        _detail = pg_exception_detail,
        _hint = pg_exception_hint;
  raise notice 'message: %, detail: %, hint: %', _message, _detail, _hint;
end;

begin
  perform 1/0;
exception
  when sqlstate '22012' then
    raise notice using message = sqlstate;
    raise sqlstate '22012' using message = 'substitute message';
end;

declare _column_name text;
        _constraint_name text;
        _datatype_name text;
        _table_name text;
        _schema_name text;
begin
  raise exception using
    column = '>>some column name<<',
    constraint = '>>some constraint name<<',
    datatype = '>>some datatype name<<',
    table = '>>some table name<<',
    schema = '>>some schema name<<';
exception when others then
  get stacked diagnostics
        _column_name = column_name,
        _constraint_name = constraint_name,
        _datatype_name = pg_datatype_name,
        _table_name = table_name,
        _schema_name = schema_name;
  raise notice 'column %, constraint %, type %, table %, schema %',
    _column_name, _constraint_name, _datatype_name, _table_name, _schema_name;
end;


begin
  for i in array_lower($1,1) .. array_upper($1,1) loop
    raise notice '%', $1[i];
  end loop; end;


declare aux numeric = $1[array_lower($1,1)];
begin
  for i in array_lower($1,1)+1 .. array_upper($1,1) loop
    if $1[i] < aux then aux := $1[i]; end if;
  end loop;
  return aux;
end;


begin
  raise notice 'non-variadic function called';
  return $1;
end;

begin
  return query select $1, $1+i from generate_series(1,5) g(i);
end;

begin
  a := a1; b := a1 + 1;
  return next;
  a := a1 * 10; b := a1 * 10 + 1;
  return next;
end;

declare rc int;
  rca int[];
begin
  return query values(10),(20);
  get diagnostics rc = row_count;
  raise notice '% %', found, rc;
  return query select * from (values(10),(20)) f(a) where false;
  get diagnostics rc = row_count;
  raise notice '% %', found, rc;
  return query execute 'values(10),(20)';
  -- just for fun, let's use array elements as targets
  get diagnostics rca[1] = row_count;
  raise notice '% %', found, rca[1];
  return query execute 'select * from (values(10),(20)) f(a) where false';
  get diagnostics rca[2] = row_count;
  raise notice '% %', found, rca[2];
end;

DECLARE
  v_var INTEGER;
BEGIN
  BEGIN
    v_var := (leaker_2(fail)).error_code;
  EXCEPTION
    WHEN others THEN RETURN 0;
  END;
  RETURN 1;
END;

BEGIN
  IF fail THEN
    RAISE EXCEPTION 'fail ...';
  END IF;
  error_code := 1;
  new_id := 1;
  RETURN;
END;

DECLARE
  arr text[];
  lr text;
  i integer;
BEGIN
  arr := array[array['foo','bar'], array['baz', 'quux']];
  lr := 'fool';
  i := 1;
  -- use sub-SELECTs to make expressions non-simple
  arr[(SELECT i)][(SELECT i+1)] := (SELECT lr);
  RETURN arr;
END;

declare
   i integer NOT NULL := 0;
begin
  begin
    i := (SELECT NULL::integer);  -- should throw error
  exception
    WHEN OTHERS THEN
      i := (SELECT 1::integer);
  end;
  return i;
end;

begin
  if ($1 > 0) then
    return sql_recurse($1 - 1);
  else
    return $1;
  end if;
end;

begin
  return error1(p_name_table);
end;

begin
  return $1;
end;

begin
do $$ declare x text[]; begin x := '{1.23, 4.56}'::numeric[]; end $$;
do $$ declare x text[]; begin x := '{1.23, 4.56}'::numeric[]; end $$;
end;

begin
  return 1/0;
end;

begin
  raise notice 'foo\\bar\041baz';
  return 'foo\\bar\041baz';
end;

begin
  raise notice E'foo\\bar\041baz';
  return E'foo\\bar\041baz';
end;

begin
  raise notice 'foo\\bar\041baz\';
  return 'foo\\bar\041baz\';
end;

begin
  raise notice E'foo\\bar\041baz';
  return E'foo\\bar\041baz';
end;

DECLARE r record;
BEGIN
    FOR r IN SELECT rtrim(roomno) AS roomno, comment FROM Room ORDER BY roomno
    LOOP
        RAISE NOTICE '%, %', r.roomno, r.comment;
    END LOOP;
END;

DECLARE r record;
BEGIN
    FOR r IN SELECT rtrim(roomno) AS roomno, foo FROM Room ORDER BY roomno
    LOOP
        RAISE NOTICE '%, %', r.roomno, r.comment;
    END LOOP;
END;

declare x int := 42;
begin
  declare y int := x + 1;
          x int := x + 2;
  begin
    return x * 100 + y;
  end;
end;

declare r record;
  q1 bigint := 42;
begin
  for r in select q1,q2 from int8_tbl loop
    return next r;
  end loop;
end;

#variable_conflict use_variable
declare r record;
  q1 bigint := 42;
begin
  for r in select q1,q2 from int8_tbl loop
    return next r;
  end loop;
end;

#variable_conflict use_column
declare r record;
  q1 bigint := 42;
begin
  for r in select q1,q2 from int8_tbl loop
    return next r;
  end loop;
end;

declare
  forward int := 21;
begin
  forward := forward * 2;
  return forward;
end;

declare
  return int := 42;
begin
  return := return + 1;
  return return;
end;

declare
  comment int := 21;
begin
  comment := comment * 2;
  comment on function unreserved_test() is 'this is a test';
  return comment;
end;

declare x int;
begin
  foreach x in array $1
  loop
    raise notice '%', x;
  end loop;
end;

declare x int;
begin
  foreach x slice 1 in array $1
  loop
    raise notice '%', x;
  end loop;
end;

declare x int[];
begin
  foreach x slice 1 in array $1
  loop
    raise notice '%', x;
  end loop;
end;

declare x int[];
begin
  foreach x slice 2 in array $1
  loop
    raise notice '%', x;
  end loop;
end;

declare r record;
begin
  foreach r in array $1
  loop
    raise notice '%', r;
  end loop;
end;

declare x int; y int;
begin
  foreach x, y in array $1
  loop
    raise notice 'x = %, y = %', x, y;
  end loop;
end;

declare x xy_tuple[];
begin
  foreach x slice 1 in array $1
  loop
    raise notice '%', x;
  end loop;
end;

declare
 r record;
begin
  r := row(12, '{foo,bar,baz}')::rtype;
  r.ar[2] := 'replace';
  return r.ar;
end;

declare res orderedarray;
begin
  res := array[x1, x2];
  res[2] := x3;
  return res;
end;

declare r int[]; begin r := array[$1, $1]; return r; end;

begin return $1[1]; end;

declare a int[] := array[1,2];
begin
  a := a || 3;
  raise notice 'a = %', a;
end;

declare _context text;
begin
  get diagnostics _context = pg_context;
  raise notice '***%***', _context;
  -- lets do it again, just for fun..
  get diagnostics _context = pg_context;
  raise notice '***%***', _context;
  raise notice 'lets make sure we didnt break anything';
  return 2 * $1;
end;

declare
  myresult int;
begin
  raise notice 'calling down into inner_func()';
  myresult := inner_func($1);
  raise notice 'inner_func() done';
  return myresult;
end;

declare
  myresult int;
begin
  raise notice 'calling down into outer_func()';
  myresult := outer_func($1);
  raise notice 'outer_func() done';
  return myresult;
end;

declare
  _context text;
  sx int := 5;
begin
  begin
    perform sx / 0;
  exception
    when division_by_zero then
      get diagnostics _context = pg_context;
      raise notice '***%***', _context;
  end;

  -- lets do it again, just for fun..
  get diagnostics _context = pg_context;
  raise notice '***%***', _context;
  raise notice 'lets make sure we didnt break anything';
  return 2 * $1;
end;

declare
  myresult int;
begin
  raise notice 'calling down into inner_func()';
  myresult := inner_func($1);
  raise notice 'inner_func() done';
  return myresult;
end;

declare
  myresult int;
begin
  raise notice 'calling down into outer_func()';
  myresult := outer_func($1);
  raise notice 'outer_func() done';
  return myresult;
end;

begin
  assert 1=0, 'unhandled assertion';
exception when others then
  null; -- do nothing
end;

begin return val > 0; end;

declare v_test plpgsql_domain;
begin
  v_test := 1;
end;

declare v_test plpgsql_domain := 1;
begin
  v_test := 0;  -- fail
end;

begin return val[1] > 0; end;

begin
  v_test := array[1];
  v_test := v_test || 2;
end;

declare v_test plpgsql_arr_domain := array[1];
begin
  v_test := 0 || v_test;  -- fail
end;

DECLARE
  t text;
  l text;
BEGIN
  t = '';
  FOR l IN EXECUTE
           $q$
             EXPLAIN (TIMING off, COSTS off, VERBOSE on)
             SELECT * FROM newtable
           $q$ LOOP
    t = t || l || E'\n';
  END LOOP;

  RAISE INFO '%', t;
  RETURN new;
END;

DECLARE
  t text;
  l text;
BEGIN
  t = '';
  FOR l IN EXECUTE
           $q$
             EXPLAIN (TIMING off, COSTS off, VERBOSE on)
             SELECT * FROM oldtable ot FULL JOIN newtable nt USING (id)
           $q$ LOOP
    t = t || l || E'\n';
  END LOOP;

  RAISE INFO '%', t;
  RETURN new;
END;

  DECLARE n bigint;
  BEGIN
    --PERFORM FROM p JOIN transition_table_level2 c ON c.parent_no = p.level1_no;
    IF FOUND THEN
      RAISE EXCEPTION 'RI error';
    END IF;
    RETURN NULL;
  END;

  DECLARE
    x int;
  BEGIN
    WITH p AS (SELECT level1_no, sum(delta) cnt
                 FROM (SELECT level1_no, 1 AS delta FROM i
                       UNION ALL
                       SELECT level1_no, -1 AS delta FROM d) w
                 GROUP BY level1_no
                 HAVING sum(delta) < 0)
    SELECT level1_no
      FROM p JOIN transition_table_level2 c ON c.parent_no = p.level1_no
      INTO x;
    IF FOUND THEN
      RAISE EXCEPTION 'RI error';
    END IF;
    RETURN NULL;
  END;

  BEGIN
    INSERT INTO dx VALUES (1000000, 1000000, 'x');
    RETURN NULL;
  END;

BEGIN
  RAISE WARNING 'old table = %, new table = %',
                  (SELECT string_agg(id || '=' || name, ',') FROM d),
                  (SELECT string_agg(id || '=' || name, ',') FROM i);
  RAISE NOTICE 'one = %', (SELECT 1 FROM alter_table_under_transition_tables LIMIT 1);
  RETURN NULL;
END;

BEGIN
    RAISE NOTICE 'count = %', (SELECT COUNT(*) FROM new_test);
    RAISE NOTICE 'count union = %',
      (SELECT COUNT(*)
       FROM (SELECT * FROM new_test UNION ALL SELECT * FROM new_test) ss);
    RETURN NULL;
END;

DECLARE
    a_val partitioned_table.a%TYPE;
    result partitioned_table%ROWTYPE;
BEGIN
    a_val := $1;
    SELECT * INTO result FROM partitioned_table WHERE a = a_val;
    RETURN result;
END;

DECLARE
    row partitioned_table%ROWTYPE;
    a_val partitioned_table.a%TYPE;
BEGIN
    FOR row IN SELECT * FROM partitioned_table ORDER BY a LOOP
        a_val := row.a;
        RETURN NEXT a_val;
    END LOOP;
    RETURN;
END;

BEGIN
  GET DIAGNOSTICS x = ROW_COUNT;
  RETURN;
END;

DECLARE
  first TEXT ARRAY;
BEGIN
  LISTEN virtual;
  NOTIFY virtual;
  UNLISTEN *;
  ANALYZE VERBOSE public.t2;
  LOCK public.t1;
  CHECKPOINT;
  RESET ALL;
  REASSIGN OWNED BY SESSION_USER TO CURRENT_USER;
  REFRESH MATERIALIZED VIEW public.mv1 WITH DATA;
  COPY (SELECT 1) TO STDOUT;
  EXPLAIN SELECT 1;
  CLUSTER public.t1;
  DEALLOCATE ALL;
  REINDEX TABLE public.t1;

  return DISTINCT c2 FROM public.t1 LIMIT 1;
END;

declare 
  i text;
begin
  show DateStyle into i;
  raise notice 'DateStyle is %', i;
  show search_path into i;
  raise notice 'search_path is %', i;
  show plpgsql.print_strict_params into i;
  raise notice 'plpgsql.print_strict_params is %', i;
end;

declare 
  _id int;
  _count int;
begin
    if _count <> coalesce (array_length (_id, 1), 0) then
        raise warning 'some text '
                        'more text '
                        ' and parameters: '
                        '% %',
               _count,
               coalesce (array_length (_id, 1));
    end if;
end;

/*
DECLARE n bigint = c1 from public.t1 limit 1;
BEGIN
  PERFORM FROM public.t1 p JOIN public.t2 c ON c.c1 = p.c2;
  IF FOUND THEN
    RAISE NOTICE 'RI error';
  END IF;
END;

begin
  for q in 1 .. 5 loop 
   RAISE notice 'Duplicate user ID: %', c1 from public.t1 limit 1 USING SCHEMA = c2 from public.t1 limit 1;
  end loop;
end;

begin
  case
    WHEN c1 > 0 FROM public.t1 limit 1 THEN
      raise notice 'positive';
  end case;
end;

begin
  case c1 FROM public.t1 limit 1 
  WHEN 1 THEN
      raise notice 'positive';
  end case;
end;

begin
  if c1 > 0 FROM public.t1 limit 1 THEN
      raise notice 'positive';
  elsif c1 < 0 FROM public.t2 limit 1 THEN
      raise notice 'negative';
  end IF;
end;

begin
  for q in c1 FROM public.t1 limit 1 .. c1 FROM public.t2 limit 1 by c1 FROM public.t3 limit 1 LOOP
  -- do nothing
  end LOOP;
end;

begin
  while c1>  0 FROM public.t1 limit 1 LOOP
    exit;
  end LOOP;
end;

begin
  foreach q in array ARRAY[c1,2] from public.t1 limit 1 loop
    exit;
  end LOOP;
end;

declare
  q integer;
begin
  execute 'select 1' into q using c1 from public.t1 limit 1;
  raise notice 'val = %', q;
end;

begin
  for q in 1 .. 5 loop 
   exit when c1 > 0 from public.t1 limit 1;
  end loop;
end;

begin
    if count(*) = 0 from Room where roomno = new.roomno then
        raise exception 'Room % does not exist', new.roomno;
    end if;
    return new;
end;

BEGIN
  PERFORM FROM i
    LEFT JOIN transition_table_level1 p
      ON p.level1_no IS NOT NULL AND p.level1_no = i.parent_no
    WHERE p.level1_no IS NULL;
  IF FOUND THEN
    RAISE EXCEPTION 'RI error';
  END IF;
  RETURN NULL;
END;
*/

DECLARE
    rc refcursor;
    r record;
BEGIN
    open rc for explain analyze values (1);
    close rc;
    open rc for SHOW ALL;
    close rc;
    open rc for select 1 from public.t1;
    close rc;
    open rc for insert into public.t1 (c1) select 5 returning *;
    close rc;
    open rc for update public.t1 set c1 = 6 where c1 = 5  returning *;
    close rc;
    open rc for DELETE from public.t1 where c1 = 6  returning *;
    close rc;

    FOR r IN show time zone loop 
        raise notice 'var is %', r;
    end loop;

    return query explain insert into public.t1 (c1) values (1) returning c1;
END;

DECLARE
    s $1%TYPE;
    t2_row table2%ROWTYPE;
BEGIN
    RETURN;
END;

BEGIN
    ANALYSE;
    RAISE NOTICE 'ANALYZE выполнен для всей базы данных';
END;