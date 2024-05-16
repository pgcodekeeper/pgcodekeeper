CREATE POLICY pol1 ON default.t2
  USING col2 != 3
  AS RESTRICTIVE;

CREATE POLICY pol2 ON default.t2
  USING col1 > 10
  AS RESTRICTIVE
  TO admin EXCEPT director;