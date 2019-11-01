-- o = old owner, n = new owner
-- + = grant, - = revoke
-- name: first part = old state, second part = new state
-- this file is old state, all owners set to o

create table public."o+o+"();
alter table public."o+o+" owner to o;
-- implicit old owner grant

create table public."o+o-"();
alter table public."o+o-" owner to o;
-- implicit old owner grant

create table public."o-o+"();
alter table public."o-o+" owner to o;
revoke all on table public."o-o+" from o;

create table public."o-o-"();
alter table public."o-o-" owner to o;
revoke all on table public."o-o-" from o;


create table public."n+n+"();
alter table public."n+n+" owner to o;
grant all on table public."n+n+" to n;

create table public."n+n-"();
alter table public."n+n-" owner to o;
grant all on table public."n+n-" to n;

create table public."n-n+"();
alter table public."n-n+" owner to o;
-- implicit revoke from regular user n

create table public."n-n-"();
alter table public."n-n-" owner to o;
-- implicit revoke from regular user n

-- same but with added dummy grant, so that there are no empty ACLs

create table public."o+o+2"();
alter table public."o+o+2" owner to o;
-- implicit old owner grant
grant all on table public."o+o+2" to dummy;

create table public."o+o-2"();
alter table public."o+o-2" owner to o;
-- implicit old owner grant
grant all on table public."o+o-2" to dummy;

create table public."o-o+2"();
alter table public."o-o+2" owner to o;
revoke all on table public."o-o+2" from o;
grant all on table public."o-o+2" to dummy;

create table public."o-o-2"();
alter table public."o-o-2" owner to o;
revoke all on table public."o-o-2" from o;
grant all on table public."o-o-2" to dummy;


create table public."n+n+2"();
alter table public."n+n+2" owner to o;
grant all on table public."n+n+2" to n;
grant all on table public."n+n+2" to dummy;

create table public."n+n-2"();
alter table public."n+n-2" owner to o;
grant all on table public."n+n-2" to n;
grant all on table public."n+n-2" to dummy;

create table public."n-n+2"();
alter table public."n-n+2" owner to o;
-- implicit revoke from regular user n
grant all on table public."n-n+2" to dummy;

create table public."n-n-2"();
alter table public."n-n-2" owner to o;
-- implicit revoke from regular user n
grant all on table public."n-n-2" to dummy;
