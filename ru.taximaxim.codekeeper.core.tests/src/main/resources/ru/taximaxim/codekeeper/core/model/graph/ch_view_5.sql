CREATE TABLE default.aaa (
    id UInt16,
    data String
)
ENGINE = MergeTree()
PARTITION BY tuple()
ORDER BY id;

CREATE TABLE default.bbb (
    id UInt16,
    data String
)
ENGINE = MergeTree()
PARTITION BY tuple()
ORDER BY id;

CREATE VIEW default.view_aaa_bbb as
with ids as (select groupArray(id) from default.bbb)
select *
  from default.aaa
 where has((select * from ids), id)
order by id;