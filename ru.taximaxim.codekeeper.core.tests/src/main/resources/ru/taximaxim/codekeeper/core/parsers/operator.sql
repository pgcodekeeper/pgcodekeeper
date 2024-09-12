CREATE OPERATOR ## (leftarg = path, rightarg = path, function = path_inter, commutator = ##);
CREATE OPERATOR <% (leftarg = point, rightarg = widget, procedure = pt_in_widget, commutator = >% , negator = >=%);
CREATE OPERATOR @#@ (rightarg = int8, procedure = numeric_fac);
CREATE OPERATOR #@# (leftarg = int8, procedure = numeric_fac);
CREATE OPERATOR #%# (leftarg = int8, procedure = numeric_fac);
COMMENT ON OPERATOR ###### (int4, NONE) IS 'bad right unary';
CREATE OPERATOR !=- (leftarg = int8, procedure = numeric_fac);
CREATE OPERATOR schema_op1.#*# (leftarg = int8, procedure = numeric_fac);
CREATE OPERATOR #*# (leftarg = SETOF int8, procedure = numeric_fac);
CREATE OPERATOR #*# (rightarg = SETOF int8, procedure = numeric_fac);
CREATE OPERATOR === (LEFTARG = boolean,
    RIGHTARG = boolean,
    PROCEDURE = fn_op2,
    COMMUTATOR = ===,
    NEGATOR = !==,
    RESTRICT = contsel,
    JOIN = contjoinsel,
    HASHES, MERGES
);
CREATE OPERATOR #@%# (procedure = numeric_fac);
CREATE OPERATOR #@%# (leftarg = int8);
CREATE OPERATOR #*# (leftarg = type_op3, rightarg = int8, procedure = fn_op3);
CREATE OPERATOR #*# (leftarg = int8, rightarg = type_op4, procedure = fn_op4);
CREATE OPERATOR #*# (leftarg = int8, rightarg = int8, procedure = fn_op5);
CREATE OPERATOR #*# (leftarg = int8, rightarg = int8, procedure = fn_op6);
CREATE OPERATOR ===
(
    Leftarg = box,
    Rightarg = box,
    Procedure = area_equal_function,
    Commutator = ===,
    Negator = !==,
    Restrict = area_restriction_function,
    Join = area_join_function,
    Hashes,
    Merges
);
CREATE OPERATOR === (
    LEFTARG = boolean,
    RIGHTARG = boolean,
    PROCEDURE = alter_op_test_fn,
    COMMUTATOR = ===,
    NEGATOR = !==,
    RESTRICT = customcontsel,
    JOIN = contjoinsel,
    HASHES, MERGES
);
ALTER OPERATOR === (boolean, boolean) SET (RESTRICT = NONE);
ALTER OPERATOR === (boolean, boolean) SET (JOIN = NONE);
ALTER OPERATOR === (boolean, boolean) SET (RESTRICT = contsel);
ALTER OPERATOR === (boolean, boolean) SET (JOIN = contjoinsel);
ALTER OPERATOR === (boolean, boolean) SET (RESTRICT = NONE, JOIN = NONE);
ALTER OPERATOR === (boolean, boolean) SET (RESTRICT = customcontsel, JOIN = contjoinsel);
ALTER OPERATOR === (boolean, boolean) SET (RESTRICT = non_existent_func);
ALTER OPERATOR === (boolean, boolean) SET (JOIN = non_existent_func);
ALTER OPERATOR === (boolean, boolean) SET (RESTRICT = NONE);
DROP OPERATOR === (boolean, boolean);
CREATE OPERATOR @-@ ( leftarg = int4, rightarg = int4, procedure = int4mi );
ALTER OPERATOR @+@(int4, int4) OWNER TO regress_alter_generic_user2;
ALTER OPERATOR @-@(int4, int4) SET SCHEMA alt_nsp2;
CREATE OPERATOR CLASS alt_opc1 FOR TYPE uuid USING hash AS STORAGE uuid;
ALTER OPERATOR CLASS alt_opc2 USING hash OWNER TO regress_alter_generic_user1;
ALTER OPERATOR CLASS alt_opc1 USING hash RENAME TO alt_opc2;
ALTER OPERATOR CLASS alt_opc2 USING hash SET SCHEMA alt_nsp2;
CREATE OPERATOR FAMILY alt_opf1 USING hash;
ALTER OPERATOR FAMILY alt_opf1 USING hash RENAME TO alt_opf3;
ALTER OPERATOR FAMILY alt_opf2 USING hash OWNER TO regress_alter_generic_user2;
ALTER OPERATOR FAMILY alt_opf2 USING hash SET SCHEMA alt_nsp2;
ALTER OPERATOR FAMILY alt_opf4 USING btree ADD
  -- int4 vs int2
  OPERATOR 1 < (int4, int2) ,
  OPERATOR 2 <= (int4, int2) ,
  OPERATOR 3 = (int4, int2) ,
  OPERATOR 4 >= (int4, int2) ,
  OPERATOR 5 > (int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2);
ALTER OPERATOR FAMILY alt_opf4 USING btree DROP
  -- int4 vs int2
  OPERATOR 1 (int4, int2) ,
  OPERATOR 2 (int4, int2) ,
  OPERATOR 3 (int4, int2) ,
  OPERATOR 4 (int4, int2) ,
  OPERATOR 5 (int4, int2) ,
  FUNCTION 1 (int4, int2) ;
CREATE OPERATOR FAMILY alt_opf4 USING btree;
ALTER OPERATOR FAMILY alt_opf4 USING invalid_index_method ADD  OPERATOR 1 < (int4, int2);
ALTER OPERATOR FAMILY alt_opf4 USING btree ADD OPERATOR 6 < (int4, int2);
ALTER OPERATOR FAMILY alt_opf4 USING btree ADD OPERATOR 0 < (int4, int2);
ALTER OPERATOR FAMILY alt_opf4 USING btree ADD FUNCTION 0 btint42cmp(int4, int2);
ALTER OPERATOR FAMILY alt_opf4 USING btree ADD FUNCTION 6 btint42cmp(int4, int2);
DROP OPERATOR FAMILY alt_opf4 USING btree;
CREATE ROLE regress_alter_generic_user5 NOSUPERUSER;
ALTER OPERATOR FAMILY alt_opf5 USING btree ADD OPERATOR 1 < (int4, int2), FUNCTION 1 btint42cmp(int4, int2);
DROP OPERATOR FAMILY alt_opf5 USING btree;
CREATE ROLE regress_alter_generic_user6;
REVOKE ALL ON SCHEMA alt_nsp6 FROM regress_alter_generic_user6;
CREATE OPERATOR FAMILY alt_nsp6.alt_opf6 USING btree;
ALTER OPERATOR FAMILY alt_nsp6.alt_opf6 USING btree ADD OPERATOR 1 < (int4, int2);
CREATE OPERATOR FAMILY alt_opf7 USING btree;
ALTER OPERATOR FAMILY alt_opf7 USING btree ADD OPERATOR 1 < (int4, int2);
DROP OPERATOR FAMILY alt_opf7 USING btree;
CREATE OPERATOR FAMILY alt_opf8 USING btree;
ALTER OPERATOR FAMILY alt_opf8 USING btree ADD OPERATOR 1 < (int4, int4);
DROP OPERATOR FAMILY alt_opf8 USING btree;
CREATE OPERATOR FAMILY alt_opf9 USING gist;
ALTER OPERATOR FAMILY alt_opf9 USING gist ADD OPERATOR 1 < (int4, int4) FOR ORDER BY float_ops;
DROP OPERATOR FAMILY alt_opf9 USING gist;
CREATE OPERATOR FAMILY alt_opf10 USING btree;
ALTER OPERATOR FAMILY alt_opf10 USING btree ADD OPERATOR 1 < (int4, int4) FOR ORDER BY float_ops;
DROP OPERATOR FAMILY alt_opf10 USING btree;
CREATE OPERATOR FAMILY alt_opf11 USING gist;
ALTER OPERATOR FAMILY alt_opf11 USING gist ADD OPERATOR 1 < (int4, int4) FOR ORDER BY float_ops;
ALTER OPERATOR FAMILY alt_opf11 USING gist DROP OPERATOR 1 (int4, int4);
ALTER OPERATOR FAMILY alt_opf16 USING gist ADD FUNCTION 1 btint42cmp(int4, int2);
DROP OPERATOR FAMILY alt_opf16 USING gist;
CREATE OPERATOR FAMILY alt_opf17 USING btree;
ALTER OPERATOR FAMILY alt_opf17 USING btree ADD
  OPERATOR 1 < (int4, int2) ,
  OPERATOR 2 <= (int4, int2) ,
  OPERATOR 3 = (int4, int2) ,
  OPERATOR 4 >= (int4, int2) ,
  OPERATOR 5 > (int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2);
ALTER OPERATOR FAMILY alt_opf17 USING btree ADD
  OPERATOR 1 < (int4, int2) ,
  OPERATOR 2 <= (int4, int2) ,
  OPERATOR 3 = (int4, int2) ,
  OPERATOR 4 >= (int4, int2) ,
  OPERATOR 5 > (int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2);
ALTER OPERATOR FAMILY alt_opf17 USING btree ADD
  OPERATOR 1 < (int4, int2) ,
  OPERATOR 2 <= (int4, int2) ,
  OPERATOR 3 = (int4, int2) ,
  OPERATOR 4 >= (int4, int2) ,
  OPERATOR 5 > (int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2);
DROP OPERATOR FAMILY alt_opf17 USING btree;
CREATE OPERATOR FAMILY alt_opf18 USING btree;
ALTER OPERATOR FAMILY alt_opf18 USING btree DROP OPERATOR 1 (int4, int4);
ALTER OPERATOR FAMILY alt_opf18 USING btree ADD
  OPERATOR 1 < (int4, int2) ,
  OPERATOR 2 <= (int4, int2) ,
  OPERATOR 3 = (int4, int2) ,
  OPERATOR 4 >= (int4, int2) ,
  OPERATOR 5 > (int4, int2) ,
  FUNCTION 1 btint42cmp(int4, int2);
ALTER OPERATOR FAMILY alt_opf18 USING btree DROP FUNCTION 2 (int4, int4);
DROP OPERATOR FAMILY alt_opf18 USING btree;
CREATE OPERATOR CLASS box_ops DEFAULT
    FOR TYPE box USING gist2 AS
    OPERATOR 1  <<,
    OPERATOR 2  &<,
    OPERATOR 3  &&,
    OPERATOR 4  &>,
    OPERATOR 5  >>,
    OPERATOR 6  ~=,
    OPERATOR 7  @>,
    OPERATOR 8  <@,
    OPERATOR 9  &<|,
    OPERATOR 10 <<|,
    OPERATOR 11 |>>,
    OPERATOR 12 |&>,
    OPERATOR 13 ~,
    OPERATOR 14 @,
    FUNCTION 1  gist_box_consistent(internal, box, smallint, oid, internal),
    FUNCTION 2  gist_box_union(internal, internal),
    -- don't need compress, decompress, or fetch functions
    FUNCTION 5  gist_box_penalty(internal, internal, internal),
    FUNCTION 6  gist_box_picksplit(internal, internal),
    FUNCTION 7  gist_box_same(box, box, internal);
CREATE OPERATOR |@| (PROCEDURE = unnest, RIGHTARG = ANYARRAY);

-- Test setting merges and hashes
ALTER OPERATOR === (boolean, real) SET (MERGES);
ALTER OPERATOR === (boolean, real) SET (HASHES);

-- Test setting commutator
ALTER OPERATOR === (boolean, real) SET (COMMUTATOR = ====);

ALTER OPERATOR @=(real, boolean) SET (COMMUTATOR = ===);
ALTER OPERATOR @!=(boolean, real) SET (NEGATOR = ===);