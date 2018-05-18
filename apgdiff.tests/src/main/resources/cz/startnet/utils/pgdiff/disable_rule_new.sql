CREATE TABLE t1 (
    c1 integer
);

ALTER TABLE t1 OWNER TO galiev_mr;

CREATE RULE notify_me AS
    ON UPDATE TO t1 DO  NOTIFY t1;
    
ALTER TABLE t1 DISABLE RULE notify_me;