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