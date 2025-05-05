CREATE FUNCTION public.fun2() RETURNS void LANGUAGE plpgsql AS $$ BEGIN 
/*GROUP BY, HAVING*/
select id, fio, _date, age, city FROM public.people WHERE age>20 GROUP BY city HAVING _date='12.12.1998'; 

/*SELECT, SUBSELECT*/
select to_jsonb(t) into param from (select pay as "🙈 🙉 🙊 😎 🤙 😎 🤙",  act_id as "id", token as "token", _sign as "signature") t;  

/*SELECT, SUBSELECT, WHERE, operators*/
select sum(account) into _sum_total from test.account where id in (select distinct public.test2 from public.test3 t where t.id = id  and t.acc<> acc  and t.sts = 'work') and price > 0.00 and id_currency = _currency;

/*SELECT, CASE, INNER LEFT JOIN*/
select p.id, p.phone as id_phone, coalesce(t.client, 0) as worker, case when exists (select id from test.account where id = acc and blocked = 0) then pub.id_acc else p.acc end as id_client, pub.test2 into _rec from public.test1 pub join pub.library lib on pub.id = p.id_order and pub.seria = lib.seria inner join public.test2 b on pub.id = b.id left join client.phones p on pub.phone = p.phone where pub.id = _order;

/*SELECT, CASE, INNER LEFT JOIN*/
select p.id, p.phone as id_phone, coalesce(t.client, 0) as worker, case when exists (select id from test.account where id = acc and blocked = 0) then pub.id_acc else p.acc end as id_client, pub.test2 into _rec from public.test1 pub
 join pub.library lib on pub.id = p.id_order and pub.seria = lib.seria
 inner join public.test2 b on pub.id = b.id
 left join client.phones p on pub.phone = p.phone where pub.id = _order;

/*EXCEPTION*/
exception when others then get stacked diagnostics _sqlstate = returned_sqlstate, _message_text = message_text, _context = pg_exception_context;
     
/*DELETE*/
 DELETE FROM public.test1 WHERE id = _id;

/*UPDATE*/
UPDATE public.test1 SET id_account = _id_account, id_phone = _id_phone, c_type = _type, c_address = _address WHERE id = _id;

/*CASE WHEN*/
case _user when 'one' then f ='1'; when 'two' then f ='2'; when 'three' then f='3'; when 'four' then f='4'; when '🙈 🙉 🙊 😎 🤙 😎 🤙' then f='5'; else null; end case; 

/*SELECT, SUBSELECT, UNION*/
select array_agg(public.id) into id_total from (select id from public.events where _update> 30 and last_update > c_update and id_name = any(_name) UNION select id from public.events where _update > 5 and last_update > c__update  and c_name = any (name_5m)) alias_;

/*INSERT*/
insert into public.days(id, _name, _date, country) values(_id, _name, _date, _country) returning id;      

/*IF, ELSEIF*/
if (count_worker = 0) then _test_worker = 0; elseif (_count_worker > 0) then _test_worker = 1; elseif (_id_worker = 2) then _test_worker = 2; else _test_worker = 3;  end if;

 /*WHILE LOOP*/
while count(_people) > 0 loop _people = test.get_people(_people, _name); _people = _people-1; end loop;  

/*FOR LOOP*/
for _id_test in select id from public.people where age>20 loop update test.workers set status = "work" where id = _id_test; end loop;

 /*FOREACH LOOP*/
foreach _id in array params loop insert into public.test (id, _name, _date) values (_id, name_1, public.getDate()) returning public.test.id into _id; end loop;
 
/*OVER WINDOW*/
SELECT sum(salary) OVER w, avg(salary) OVER w FROM empsalary WINDOW w AS (PARTITION BY depname ORDER BY salary DESC);  

/*FOR ...(SELECT...) ...LOOP*/
for v_next_sync in (select sys_change_version from bankrupt_bulk.address order by 1 ) loop end loop;

/*SELECT ...UNION...SELECT*/
((select 1 limit 1) union (select 2 limit 1)) order by 1;

/*SELECT ...EXCEPTION*/
select 1; BEGIN select 1; EXCEPTION WHEN condition THEN select 12; WHEN condition THEN begin select 12; end; WHEN condition THEN select 13; END;

/*DECLARE*/
declare aa int; begin end;

/*MERGE*/
MERGE INTO customer_account ca USING (SELECT customer_id, transaction_value FROM recent_transactions) AS t ON t.customer_id = ca.customer_id WHEN MATCHED THEN UPDATE SET balance = balance + transaction_value WHEN NOT MATCHED THEN INSERT (customer_id, balance) VALUES (t.customer_id, t.transaction_value);
END$$;
ALTER FUNCTION public.fun2() OWNER TO user_m;
