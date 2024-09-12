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
   
MERGE INTO measurement AS mes
USING json_to_recordset(measurement) AS x("Identifier" VARCHAR (100),
                                             "Integrator" VARCHAR (100),
                                             "DisplayName" VARCHAR (500))
ON (mes.identifier = "Identifier"
    AND mes.integrator = "Integrator")
WHEN NOT MATCHED THEN
    INSERT (dentifier, integrator, display_name)
    VALUES ("Application", "Integrator", "isplayName");

MERGE INTO request_app_names AS dest
USING string_to_table(in_value, ',') AS source(val)
ON (dest.request_app_name = source.val)
WHEN NOT MATCHED THEN
    INSERT (request_app_name)
    VALUES (source.val);

MERGE INTO request_app_names AS dest
USING public.func1() AS source(val)
ON (dest.request_app_name = source.val)
WHEN NOT MATCHED THEN
    INSERT (request_app_name)
    VALUES (source.val);
    
-- DELETE/INSERT not matched by source/target
BEGIN;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN NOT MATCHED BY SOURCE THEN
	DELETE
WHEN NOT MATCHED BY TARGET THEN
	INSERT VALUES (s.sid, s.delta)
RETURNING merge_action(), t.*;
SELECT * FROM target ORDER BY tid;

-- UPSERT with UPDATE/DELETE when not matched by source
BEGIN;
DELETE FROM SOURCE WHERE sid = 2;
MERGE INTO target t
USING source AS s
ON t.tid = s.sid
WHEN MATCHED AND t.balance > s.delta THEN
    UPDATE SET balance = t.balance - s.delta
WHEN MATCHED THEN
	UPDATE SET balance = 0
WHEN NOT MATCHED THEN
    INSERT VALUES (s.sid, s.delta)
WHEN NOT MATCHED BY SOURCE AND tid = 1 THEN
	UPDATE SET balance = 0
WHEN NOT MATCHED BY SOURCE THEN
	DELETE
RETURNING merge_action(), t.*;

-- RETURNING
CREATE TABLE merge_actions(action text, abbrev text);
INSERT INTO merge_actions VALUES ('INSERT', 'ins'), ('UPDATE', 'upd'), ('DELETE', 'del');
MERGE INTO sq_target t
USING sq_source s
ON tid = sid
WHEN MATCHED AND tid >= 2 THEN
    UPDATE SET balance = t.balance + delta
WHEN NOT MATCHED THEN
    INSERT (balance, tid) VALUES (balance + delta, sid)
WHEN MATCHED AND tid < 2 THEN
    DELETE
RETURNING (SELECT abbrev FROM merge_actions
            WHERE action = merge_action()) AS action,
          t.*,
          CASE merge_action()
              WHEN 'INSERT' THEN 'Inserted '||t
              WHEN 'UPDATE' THEN 'Added '||delta||' to balance'
              WHEN 'DELETE' THEN 'Removed '||t
          END AS description;

-- RETURNING in CTEs
CREATE TABLE sq_target_merge_log (tid integer NOT NULL, last_change text);
INSERT INTO sq_target_merge_log VALUES (1, 'Original value');
BEGIN;
WITH m AS (
    MERGE INTO sq_target t
    USING sq_source s
    ON tid = sid
    WHEN MATCHED AND tid >= 2 THEN
        UPDATE SET balance = t.balance + delta
    WHEN NOT MATCHED THEN
        INSERT (balance, tid) VALUES (balance + delta, sid)
    WHEN MATCHED AND tid < 2 THEN
        DELETE
    RETURNING merge_action() AS action, t.*,
              CASE merge_action()
                  WHEN 'INSERT' THEN 'Inserted '||t
                  WHEN 'UPDATE' THEN 'Added '||delta||' to balance'
                  WHEN 'DELETE' THEN 'Removed '||t
              END AS description
), m2 AS (
    MERGE INTO sq_target_merge_log l
    USING m
    ON l.tid = m.tid
    WHEN MATCHED THEN
        UPDATE SET last_change = description
    WHEN NOT MATCHED THEN
        INSERT VALUES (m.tid, description)
    RETURNING action, merge_action() AS log_action, l.*
)
SELECT * FROM m2;
SELECT * FROM sq_target_merge_log ORDER BY tid;

-- COPY (MERGE ... RETURNING) TO ...
COPY (
    MERGE INTO sq_target t
    USING sq_source s
    ON tid = sid
    WHEN MATCHED AND tid >= 2 THEN
        UPDATE SET balance = t.balance + delta
    WHEN NOT MATCHED THEN
        INSERT (balance, tid) VALUES (balance + delta, sid)
    WHEN MATCHED AND tid < 2 THEN
        DELETE
    RETURNING merge_action(), t.*
) TO stdout;

-- try simple MERGE
MERGE INTO pa_target t
  USING (SELECT '2017-01-15' AS slogts, * FROM pa_source WHERE sid < 10) s
  ON t.tid = s.sid
  WHEN MATCHED THEN
    UPDATE SET balance = balance + delta, val = val || ' updated by merge'
  WHEN NOT MATCHED THEN
    INSERT VALUES (slogts::timestamp, sid, delta, 'inserted by merge')
  RETURNING merge_action(), t.*;
  
-- try a system catalog
MERGE INTO pg_class c
USING (SELECT 'pg_depend'::regclass AS oid) AS j
ON j.oid = c.oid
WHEN MATCHED THEN
	UPDATE SET reltuples = reltuples + 1
RETURNING j.oid;