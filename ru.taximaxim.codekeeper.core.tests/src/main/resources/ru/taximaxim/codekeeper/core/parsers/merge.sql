--
-- MERGE syntax tests
--
CREATE TABLE target (c1 integer, balance integer)
  WITH (autovacuum_enabled=off);
CREATE TABLE source (sid integer, delta integer) -- no index
  WITH (autovacuum_enabled=off);

MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN NOT MATCHED THEN
    DO NOTHING;

MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN MATCHED THEN
    UPDATE SET balance = 0;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN MATCHED THEN
    DELETE;
BEGIN;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN NOT MATCHED THEN
    INSERT DEFAULT VALUES;
SELECT * FROM target ORDER BY tid;
ROLLBACK;

EXPLAIN (COSTS OFF)
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN MATCHED THEN
    UPDATE SET balance = 0;
EXPLAIN (COSTS OFF)
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN MATCHED THEN
    DELETE;
EXPLAIN (COSTS OFF)
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN NOT MATCHED THEN
    INSERT VALUES (4, NULL);
DELETE FROM target WHERE tid > 100;
ANALYZE target;

-- insert some matching source rows to work from
INSERT INTO source VALUES (2, 5);
INSERT INTO source VALUES (3, 20);
SELECT * FROM source ORDER BY sid;
SELECT * FROM target ORDER BY tid;

-- equivalent of an UPDATE join
BEGIN;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN MATCHED THEN
    UPDATE SET balance = 0;
SELECT * FROM target ORDER BY tid;
ROLLBACK;

-- equivalent of a DELETE join
BEGIN;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN MATCHED THEN
    DELETE;
SELECT * FROM target ORDER BY tid;
ROLLBACK;

BEGIN;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN MATCHED THEN
    DO NOTHING;
SELECT * FROM target ORDER BY tid;
ROLLBACK;

BEGIN;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN NOT MATCHED THEN
    INSERT VALUES (4, NULL);
SELECT * FROM target ORDER BY tid;
ROLLBACK;

-- multiple actions
BEGIN;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN NOT MATCHED THEN
    INSERT VALUES (4, 4)
WHEN MATCHED THEN
    UPDATE SET balance = 0;
SELECT * FROM target ORDER BY tid;
ROLLBACK;

-- should be equivalent
BEGIN;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN MATCHED THEN
    UPDATE SET balance = 0
WHEN NOT MATCHED THEN
    INSERT VALUES (4, 4);
SELECT * FROM target ORDER BY tid;
ROLLBACK;

-- column references
-- do a simple equivalent of an UPDATE join
BEGIN;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN MATCHED THEN
    UPDATE SET balance = t.balance + s.delta;
SELECT * FROM target ORDER BY tid;
ROLLBACK;

-- do a simple equivalent of an INSERT SELECT
BEGIN;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN NOT MATCHED THEN
    INSERT VALUES (s.sid, s.delta);
SELECT * FROM target ORDER BY tid;
ROLLBACK;

-- and again with a constant ON clause
BEGIN;
MERGE INTO target t
USING source AS s
ON (SELECT true)
WHEN NOT MATCHED THEN
    INSERT (tid, balance) VALUES (t.tid, s.delta);
SELECT * FROM target ORDER BY tid;
ROLLBACK;

-- now the classic UPSERT
BEGIN;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN MATCHED THEN
    UPDATE SET balance = t.balance + s.delta
WHEN NOT MATCHED THEN
    INSERT VALUES (s.sid, s.delta);
SELECT * FROM target ORDER BY tid;
ROLLBACK;

-- check source-side whole-row references
BEGIN;
MERGE INTO wq_target t
USING wq_source s ON (t.tid = s.sid)
WHEN matched and t = s or t.tid = s.sid THEN
    UPDATE SET balance = t.balance + s.balance;
SELECT * FROM wq_target;
ROLLBACK;

-- check if subqueries work in the conditions?
MERGE INTO wq_target t
USING wq_source s ON t.tid = s.sid
WHEN MATCHED AND t.balance > (SELECT max(balance) FROM target) THEN
    UPDATE SET balance = t.balance + s.balance;

-- check if we can access system columns in the conditions
MERGE INTO wq_target t
USING wq_source s ON t.tid = s.sid
WHEN MATCHED AND t.xmin = t.xmax THEN
    UPDATE SET balance = t.balance + s.balance;

MERGE INTO wq_target t
USING wq_source s ON t.tid = s.sid
WHEN MATCHED AND (merge_when_and_write()) THEN
    UPDATE SET balance = t.balance + s.balance;

--source constants
BEGIN;
MERGE INTO target t
USING (SELECT 9 AS sid, 57 AS delta) AS s
ON t.tid = s.sid
WHEN NOT MATCHED THEN
    INSERT (tid, balance) VALUES (s.sid, s.delta);
SELECT * FROM target ORDER BY tid;
ROLLBACK;

--source query
BEGIN;
MERGE INTO target t
USING (SELECT sid, delta FROM source WHERE delta > 0) AS s
ON t.tid = s.sid
WHEN NOT MATCHED THEN
    INSERT (tid, balance) VALUES (s.sid, s.delta);
SELECT * FROM target ORDER BY tid;
ROLLBACK;

BEGIN;
MERGE INTO target t
USING (SELECT sid, delta as newname FROM source WHERE delta > 0) AS s
ON t.tid = s.sid
WHEN NOT MATCHED THEN
    INSERT (tid, balance) VALUES (s.sid, s.newname);
SELECT * FROM target ORDER BY tid;
ROLLBACK;

--self-merge
BEGIN;
MERGE INTO target t1
USING target t2
ON t1.tid = t2.tid
WHEN MATCHED THEN
    UPDATE SET balance = t1.balance + t2.balance
WHEN NOT MATCHED THEN
    INSERT VALUES (t2.tid, t2.balance);
SELECT * FROM target ORDER BY tid;
ROLLBACK;

BEGIN;
MERGE INTO target t
USING (SELECT tid as sid, balance as delta FROM target WHERE balance > 0) AS s
ON t.tid = s.sid
WHEN NOT MATCHED THEN
    INSERT (tid, balance) VALUES (s.sid, s.delta);
SELECT * FROM target ORDER BY tid;
ROLLBACK;

BEGIN;
MERGE INTO target t
USING
(SELECT sid, max(delta) AS delta
 FROM source
 GROUP BY sid
 HAVING count(*) = 1
 ORDER BY sid ASC) AS s
ON t.tid = s.sid
WHEN NOT MATCHED THEN
    INSERT (tid, balance) VALUES (s.sid, s.delta);
SELECT * FROM target ORDER BY tid;
ROLLBACK;

-- ambiguous reference to a column
BEGIN;
MERGE INTO sq_target
USING v
ON tid = sid
WHEN MATCHED AND tid > 2 THEN
    UPDATE SET balance = balance + delta
WHEN NOT MATCHED THEN
    INSERT (balance, tid) VALUES (balance + delta, sid)
WHEN MATCHED AND tid < 2 THEN
    DELETE;
ROLLBACK;

-- try simple MERGE
BEGIN;
MERGE INTO pa_target t
  USING pa_source s
  ON t.tid = s.sid
  WHEN MATCHED THEN
    UPDATE SET balance = balance + delta, val = val || ' updated by merge'
  WHEN NOT MATCHED THEN
    INSERT VALUES (sid, delta, 'inserted by merge');
SELECT * FROM pa_target ORDER BY tid;
ROLLBACK;

-- try updating the partition key column
BEGIN;
MERGE INTO pa_target t
  USING pa_source s
  ON t.tid = s.sid
  WHEN MATCHED THEN
    UPDATE SET tid = tid + 1, balance = balance + delta, val = val || ' updated by merge'
  WHEN NOT MATCHED THEN
    INSERT VALUES (sid, delta, 'inserted by merge');
SELECT * FROM pa_target ORDER BY tid;
ROLLBACK;

-- same with a constant qual
BEGIN;
MERGE INTO pa_target t
  USING pa_source s
  ON t.tid = s.sid AND tid IN (1, 5)
  WHEN MATCHED AND tid % 5 = 0 THEN DELETE
  WHEN MATCHED THEN
    UPDATE SET balance = balance + delta, val = val || ' updated by merge'
  WHEN NOT MATCHED THEN
    INSERT VALUES (sid, delta, 'inserted by merge');
SELECT * FROM pa_target ORDER BY tid;
ROLLBACK;

-- try updating the partition key column
BEGIN;
MERGE INTO pa_target t
  USING pa_source s
  ON t.tid = s.sid
  WHEN MATCHED THEN
    UPDATE SET tid = tid + 1, balance = balance + delta, val = val || ' updated by merge'
  WHEN NOT MATCHED THEN
    INSERT VALUES (sid, delta, 'inserted by merge');
SELECT * FROM pa_target ORDER BY tid;
ROLLBACK;

MERGE into measurement m
 USING new_measurement nm ON
      (m.city_id = nm.city_id and m.logdate=nm.logdate)
WHEN MATCHED AND nm.peaktemp IS NULL THEN DELETE
WHEN MATCHED THEN UPDATE
     SET peaktemp = greatest(m.peaktemp, nm.peaktemp),
        unitsales = m.unitsales + coalesce(nm.unitsales, 0)
WHEN NOT MATCHED THEN INSERT
     (city_id, logdate, peaktemp, unitsales)
   VALUES (city_id, logdate, peaktemp, unitsales);