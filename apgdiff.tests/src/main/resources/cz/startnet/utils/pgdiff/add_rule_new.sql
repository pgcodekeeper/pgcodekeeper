CREATE TABLE t1(c1 int);

CREATE RULE on_delete AS ON DELETE TO t1 DO ALSO DELETE FROM user_data WHERE (user_data.id = old.id);
CREATE RULE on_insert AS ON INSERT TO t1 DO INSTEAD (INSERT INTO user_data (id, email, created) VALUES (new.id, new.email, new.created); INSERT INTO t1(c1) DEFAULT VALUES);
CREATE RULE on_update AS ON UPDATE TO t1 DO INSTEAD (UPDATE user_data SET id = new.id, email = new.email, created = new.created WHERE (user_data.id = old.id));
CREATE RULE on_select AS ON SELECT TO t1 WHERE (1=1) DO INSTEAD NOTHING;