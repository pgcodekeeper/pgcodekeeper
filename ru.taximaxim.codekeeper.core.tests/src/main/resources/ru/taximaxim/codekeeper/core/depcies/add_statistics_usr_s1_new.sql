CREATE SCHEMA first;

CREATE SCHEMA second;

CREATE STATISTICS second.s1 ON first.f1(b), a FROM first.t1;
