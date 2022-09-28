-- o = old owner, n = new owner
-- + = grant, - = revoke
-- name: first part = old state, second part = new state
-- this file is new state, all owners set to n

create table public."o+o+"();
alter table public."o+o+" owner to n;
grant all on table public."o+o+" to o;

create table public."o+o-"();
alter table public."o+o-" owner to n;
-- implicit revoke from regular user o

create table public."o-o+"();
alter table public."o-o+" owner to n;
grant all on table public."o-o+" to o;

create table public."o-o-"();
alter table public."o-o-" owner to n;
-- implicit revoke from regular user o


create table public."n+n+"();
alter table public."n+n+" owner to n;
-- implicit new owner grant

create table public."n+n-"();
alter table public."n+n-" owner to n;
revoke all on table public."n+n-" from n;

create table public."n-n+"();
alter table public."n-n+" owner to n;
-- implicit new owner grant

create table public."n-n-"();
alter table public."n-n-" owner to n;
revoke all on table public."n-n-" from n;

-- same but with added dummy grant, so that there are no empty ACLs

create table public."o+o+2"();
alter table public."o+o+2" owner to n;
grant all on table public."o+o+2" to o;
grant all on table public."o+o+2" to dummy;

create table public."o+o-2"();
alter table public."o+o-2" owner to n;
-- implicit revoke from regular user o
grant all on table public."o+o-2" to dummy;

create table public."o-o+2"();
alter table public."o-o+2" owner to n;
grant all on table public."o-o+2" to o;
grant all on table public."o-o+2" to dummy;

create table public."o-o-2"();
alter table public."o-o-2" owner to n;
-- implicit revoke from regular user o
grant all on table public."o-o-2" to dummy;


create table public."n+n+2"();
alter table public."n+n+2" owner to n;
-- implicit new owner grant
grant all on table public."n+n+2" to dummy;

create table public."n+n-2"();
alter table public."n+n-2" owner to n;
revoke all on table public."n+n-2" from n;
grant all on table public."n+n-2" to dummy;

create table public."n-n+2"();
alter table public."n-n+2" owner to n;
-- implicit new owner grant
grant all on table public."n-n+2" to dummy;

create table public."n-n-2"();
alter table public."n-n-2" owner to n;
revoke all on table public."n-n-2" from n;
grant all on table public."n-n-2" to dummy;
