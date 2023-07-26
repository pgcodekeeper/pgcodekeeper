create event trigger regress_event_trigger
   on ddl_command_start
   execute procedure pg_backend_pid();

create event trigger regress_event_trigger on elephant_bootstrap
   execute procedure test_event_trigger();

create event trigger regress_event_trigger on ddl_command_start
   execute procedure test_event_trigger();

create event trigger regress_event_trigger_end on ddl_command_end
   execute function test_event_trigger();

create event trigger regress_event_trigger2 on ddl_command_start
   when food in ('sandwich')
   execute procedure test_event_trigger();

create event trigger regress_event_trigger2 on ddl_command_start
   when tag in ('sandwich')
   execute procedure test_event_trigger();

create event trigger regress_event_trigger2 on ddl_command_start
   when tag in ('create table', 'create skunkcabbage')
   execute procedure test_event_trigger();

create event trigger regress_event_trigger2 on ddl_command_start
   when tag in ('DROP EVENT TRIGGER')
   execute procedure test_event_trigger();

create event trigger regress_event_trigger2 on ddl_command_start
   when tag in ('CREATE ROLE')
   execute procedure test_event_trigger();

create event trigger regress_event_trigger2 on ddl_command_start
   when tag in ('CREATE DATABASE')
   execute procedure test_event_trigger();

create event trigger regress_event_trigger2 on ddl_command_start
   when tag in ('CREATE TABLESPACE')
   execute procedure test_event_trigger();

create event trigger regress_event_trigger2 on ddl_command_start
   when tag in ('create table') and tag in ('CREATE FUNCTION')
   execute procedure test_event_trigger();

create event trigger regress_event_trigger2 on ddl_command_start
   execute procedure test_event_trigger('argument not allowed');

create event trigger regress_event_trigger2 on ddl_command_start
   when tag in ('create table', 'CREATE FUNCTION')
   execute procedure test_event_trigger();

CREATE EVENT TRIGGER undroppable ON sql_drop EXECUTE PROCEDURE undroppable();

CREATE EVENT TRIGGER regress_event_trigger_drop_objects ON sql_drop
    WHEN TAG IN ('drop table', 'drop function', 'drop view',
        'drop owned', 'drop schema', 'alter table')
    EXECUTE PROCEDURE test_evtrig_dropped_objects();

create event trigger no_rewrite_allowed on table_rewrite
  execute procedure test_evtrig_no_rewrite();

CREATE EVENT TRIGGER start_rls_command ON ddl_command_start
    WHEN TAG IN ('CREATE POLICY', 'ALTER POLICY', 'DROP POLICY') EXECUTE PROCEDURE start_command();

CREATE EVENT TRIGGER end_rls_command ON ddl_command_end
    WHEN TAG IN ('CREATE POLICY', 'ALTER POLICY', 'DROP POLICY') EXECUTE PROCEDURE end_command();

CREATE EVENT TRIGGER sql_drop_command ON sql_drop
    WHEN TAG IN ('DROP POLICY') EXECUTE PROCEDURE drop_sql_command();

comment on event trigger regress_event_trigger is 'test comment';

alter event trigger regress_event_trigger disable;
alter event trigger regress_event_trigger enable;
alter event trigger regress_event_trigger enable replica;
alter event trigger regress_event_trigger enable always;
alter event trigger regress_event_trigger disable;
alter event trigger regress_event_trigger rename to regress_event_trigger2;
alter event trigger regress_event_trigger rename to regress_event_trigger3;

drop event trigger regress_event_trigger;
drop event trigger if exists regress_event_trigger2;