CREATE SCHEMA first;

CREATE SCHEMA second;

CREATE STATISTICS second.s2 ON b, first.f1(a) FROM first.v1;
