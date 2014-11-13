/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

parser grammar SQLParser;

options {
	language=Java;
	tokenVocab=SQLLexer;
}

@header {
}

@members {
}

/*
===============================================================================
  SQL statement (Start Symbol)
===============================================================================
*/
sql
  : (statement (SEMI_COLON)?)* EOF
  ;

statement
  : data_statement
  | data_change_statement
  | schema_statement
  | index_statement
  | create_extension_statement
  | set_statement
  | create_trigger_statement
  | grant_statement
  | revoke_statement
  | comment_on_statement
  | create_function_statement
  | create_sequence_statement
  | create_schema_statement
  ;

data_statement
  : query_expression
  ;

data_change_statement
  : insert_statement
  ;

schema_statement
  : create_table_statement
  | drop_table_statement
  ;

index_statement
  : CREATE (u=UNIQUE)? INDEX n=identifier ON t=schema_qualified_name (m=method_specifier)?
    LEFT_PAREN s=sort_specifier_list RIGHT_PAREN p=param_clause?
  ;
  
 create_extension_statement
    : CREATE EXTENSION (IF NOT EXISTS)? name=identifier (WITH)?
         (SCHEMA schema_name=identifier)? (VERSION version=identifier)? (FROM old_version=identifier)?
    ;
    
set_statement
    : SET (SESSION | LOCAL)? config_param=identifier (TO |EQUAL) ((value=identifier | QUOTE value=identifier QUOTE | DEFAULT)(COMMA)?)+
    | SET (SESSION | LOCAL)? TIME ZONE ((timezone=identifier | LOCAL | DEFAULT)(COMMA)?)+
    ;
   
create_trigger_statement
    : CREATE (CONSTRAINT)? TRIGGER name=identifier (BEFORE | (INSTEAD OF) | AFTER)
    (INSERT | DELETE | TRUNCATE | (UPDATE (OF (columnName=identifier(COMMA)?)+)?))
    ON tabl_name=schema_qualified_name 
    (FROM referenced_table_name=schema_qualified_name)?
    (NOT DEFERRABLE | (DEFERRABLE)? (INITIALLY IMMEDIATE) | (INITIALLY DEFERRED))?
    (FOR (EACH)? ROW | STATEMENT)?
    (WHEN (boolean_value_expression))?
    EXECUTE PROCEDURE func_name=identifier LEFT_PAREN (arguments=identifier(COMMA)?)? RIGHT_PAREN
    ;
    
revoke_statement
    : REVOKE (GRANT OPTION FOR)?
        ((SELECT | INSERT | UPDATE | DELETE | TRUNCATE | REFERENCES | TRIGGER)+
         | ALL (PRIVILEGES)?) 
        ON (((TABLE)? table_name=schema_qualified_name)+
             | ALL TABLES IN SCHEMA (schema_name=identifier)+)
        revoke_from_cascade_restrict
    
    | REVOKE (GRANT OPTION FOR)?
        (((SELECT | INSERT | UPDATE | REFERENCES) LEFT_PAREN (column=identifier(COMMA)?)+ RIGHT_PAREN)+
         | ALL (PRIVILEGES)? LEFT_PAREN (column=identifier(COMMA)?)+ RIGHT_PAREN )
        ON (TABLE)? (table_name=schema_qualified_name(COMMA)?)+
        revoke_from_cascade_restrict
    
    | REVOKE (GRANT OPTION FOR)?
        ( (USAGE | SELECT | UPDATE)+
        | ALL (PRIVILEGES)?)
        ON (SEQUENCE (sequence_name=schema_qualified_name(COMMA)?)+
             | ALL SEQUENCES IN SCHEMA (schema_name=identifier(COMMA)?)+ )
        revoke_from_cascade_restrict
        
    | REVOKE (GRANT OPTION FOR)?
        ((CREATE | CONNECT | TEMPORARY | TEMP)+ | ALL (PRIVILEGES)?)
        ON DATABASE (database_name=identifier(COMMA)?)+
        revoke_from_cascade_restrict
    
    | REVOKE (GRANT OPTION FOR)?
        (USAGE | ALL (PRIVILEGES)?) 
        ON FOREIGN DATA WRAPPER (fdw_name=schema_qualified_name(COMMA)?)+
        revoke_from_cascade_restrict
        
    | REVOKE (GRANT OPTION FOR)?
        (USAGE | ALL (PRIVILEGES)?)
        ON FOREIGN SERVER (server_name=identifier(COMMA)?)+
        revoke_from_cascade_restrict
        
    | REVOKE (GRANT OPTION FOR)?
        (EXECUTE | ALL (PRIVILEGES)?) 
        ON (function_definition| functions_definition_schema)
        revoke_from_cascade_restrict
    
    | REVOKE (GRANT OPTION FOR)?
        (USAGE | ALL (PRIVILEGES)?)
        ON LANGUAGE (lang_name=identifier(COMMA)?)+
        revoke_from_cascade_restrict

    | REVOKE (GRANT OPTION FOR)?
        ((SELECT | UPDATE(COMMA)?)+  | ALL (PRIVILEGES)?) 
        ON LARGE OBJECT (loid=identifier(COMMA)?)+
        revoke_from_cascade_restrict
    
    | REVOKE (GRANT OPTION FOR)?
        ( ((CREATE | USAGE)(COMMA)?)+ | ALL (PRIVILEGES)?) 
        ON SCHEMA (schema_name=identifier(COMMA)?)+
        revoke_from_cascade_restrict
     
    | REVOKE (GRANT OPTION FOR)?
        (CREATE | ALL (PRIVILEGES)?)
        ON TABLESPACE (tablespace_name=identifier(COMMA)?)+
        revoke_from_cascade_restrict

    | REVOKE (ADMIN OPTION FOR)?
        (role_name=identifier(COMMA)?)+ FROM (role_name=identifier(COMMA)?)+
        (CASCADE | RESTRICT)?
    ;
    
revoke_from_cascade_restrict
    : FROM ((GROUP)? role_name=identifier | PUBLIC(COMMA)?)+
        (CASCADE | RESTRICT)?
    ;
    
grant_statement
    : 
    GRANT ((SELECT | INSERT | UPDATE | DELETE | TRUNCATE | REFERENCES | TRIGGER)+
    | ALL (PRIVILEGES)?)
    ON  (((TABLE)? (tabl_name=schema_qualified_name (COMMA)?)+)
         | (ALL TABLES IN SCHEMA (schem_name=identifier (COMMA)?)+))
    grant_to_rule
    
    | GRANT ( ((SELECT | INSERT | UPDATE | REFERENCES) (column=identifier (COMMA)?)+)+
    | ALL (PRIVILEGES)? (column=identifier (COMMA)?)+)
    ON ((TABLE)? tabl_name=schema_qualified_name (COMMA)?)+
    grant_to_rule
    
    | GRANT ( (( USAGE | SELECT | UPDATE )(COMMA)?)+
        | ALL ( PRIVILEGES)? )
    ON ( (SEQUENCE sequence_name=identifier(COMMA)?)+
         | ALL SEQUENCES IN SCHEMA (schema_name=identifier(COMMA)?)+ )
    grant_to_rule
    
    | GRANT ( ((CREATE | CONNECT | TEMPORARY | TEMP)(COMMA)?)+ | ALL (PRIVILEGES)? )
    ON DATABASE (database_name=identifier(COMMA)?)+
    grant_to_rule
    
    | GRANT (USAGE | ALL (PRIVILEGES)?)
    ON FOREIGN DATA WRAPPER (fdw_name=identifier(COMMA)?)+
    grant_to_rule
    
    | GRANT (USAGE | ALL (PRIVILEGES)?) 
    ON FOREIGN SERVER (server_name=identifier(COMMA)?)+
    grant_to_rule
    
    | GRANT (EXECUTE | ALL (PRIVILEGES)?) 
    ON (function_definition | functions_definition_schema)
    grant_to_rule
    
    | GRANT (USAGE | ALL (PRIVILEGES)?)
    ON LANGUAGE (lang_name=identifier(COMMA)?)+
    grant_to_rule
    
    | GRANT ( ((SELECT | UPDATE)(COMMA)?)+ | ALL (PRIVILEGES)?)
    ON LARGE OBJECT (loid=identifier(COMMA)?)+
    grant_to_rule
    
    | GRANT ( ((CREATE | USAGE)(COMMA)?)+ | ALL (PRIVILEGES)?)
    ON SCHEMA (schema_name=identifier(COMMA)?)+
    grant_to_rule
    
    | GRANT (CREATE | ALL (PRIVILEGES)?) 
    ON TABLESPACE (tablespace_name=identifier(COMMA)?)+
    grant_to_rule
    
    GRANT (role_name=identifier(COMMA)?)+ TO (role_name=identifier(COMMA)?)+ (WITH ADMIN OPTION)?
    ;
    
grant_to_rule
    :
    TO ((GROUP)? ((role_name=identifier) | PUBLIC) (COMMA)?)+ (WITH GRANT OPTION)?
    ;
    
comment_on_statement
    : COMMENT ON( AGGREGATE agg_name=schema_qualified_name LEFT_PAREN (agg_type=data_type(COMMA)?)* RIGHT_PAREN 
        | CAST LEFT_PAREN source_type=data_type AS target_type=data_type RIGHT_PAREN 
        | COLLATION object_name=schema_qualified_name
        | COLUMN column_name=schema_qualified_name 
        | CONSTRAINT constraint_name=schema_qualified_name ON table_name=schema_qualified_name 
        | CONVERSION object_name=schema_qualified_name 
        | DATABASE object_name=schema_qualified_name 
        | DOMAIN object_name=schema_qualified_name 
        | EXTENSION object_name=schema_qualified_name 
        | FOREIGN DATA WRAPPER object_name=schema_qualified_name 
        | FOREIGN TABLE object_name=schema_qualified_name 
        | FUNCTION routine_invocation 
        | INDEX object_name=schema_qualified_name 
        | LARGE OBJECT large_object_oid=identifier 
        | OPERATOR operator_name=schema_qualified_name LEFT_PAREN left_type=data_type COMMA right_type=data_type RIGHT_PAREN 
        | OPERATOR CLASS object_name=schema_qualified_name USING index_method=identifier 
        | OPERATOR FAMILY object_name=schema_qualified_name  USING index_method=identifier 
        | (PROCEDURAL)? LANGUAGE object_name=schema_qualified_name
        | ROLE object_name=schema_qualified_name 
        | RULE rule_name=schema_qualified_name ON table_name=schema_qualified_name 
        | SCHEMA object_name=schema_qualified_name 
        | SEQUENCE object_name=schema_qualified_name 
        | SERVER object_name=schema_qualified_name 
        | TABLE object_name=schema_qualified_name 
        | TABLESPACE object_name=schema_qualified_name 
        | TEXT SEARCH CONFIGURATION object_name=schema_qualified_name 
        | TEXT SEARCH DICTIONARY object_name=schema_qualified_name 
        | TEXT SEARCH PARSER object_name=schema_qualified_name 
        | TEXT SEARCH TEMPLATE object_name=schema_qualified_name 
        | TRIGGER trigger_name=schema_qualified_name ON table_name=schema_qualified_name 
        | TYPE object_name=schema_qualified_name 
        | VIEW object_name=schema_qualified_name
        ) IS Character_String_Literal
    ;

/*
===============================================================================
  Function Definition
===============================================================================
*/
create_function_statement
    : CREATE (OR REPLACE)? FUNCTION name=identifier 
        LEFT_PAREN ( (arg_mode=argmode)? (argname=identifier)? argtype=data_type 
            ( (DEFAULT | EQUAL routine_invocation(COMMA)?)+ )?
        )? RIGHT_PAREN
        (RETURNS rettype=data_type 
            | RETURNS TABLE LEFT_PAREN (column_name=identifier column_type=data_type(COMMA)?)+ RIGHT_PAREN
        )?
          (LANGUAGE lang_name=identifier
            | WINDOW
            | IMMUTABLE | STABLE | VOLATILE
            | CALLED ON NULL INPUT | RETURNS NULL ON NULL INPUT | STRICT
            | (EXTERNAL)? SECURITY INVOKER | (EXTERNAL)? SECURITY DEFINER
            | COST execution_cost=NUMBER
            | ROWS result_rows=NUMBER
            | SET configuration_parameter=identifier (TO value=Character_String_Literal | EQUAL value=Character_String_Literal | FROM CURRENT)
            | AS function_body
            | AS Character_String_Literal COMMA Character_String_Literal
          )+
            (WITH LEFT_PAREN (attribute=function_attribute(COMMA)?)+ RIGHT_PAREN)?
    ;

function_body
    :DOUBLE_DOLLAR ( ~(DOUBLE_DOLLAR) )* DOUBLE_DOLLAR
    ;

function_attribute
    : ISSTRICT | ISCACHABLE
    ;
        
argmode
    : 
      IN | OUT | INOUT | VARIADIC
    ;

function_definition
    : FUNCTION func_name=identifier 
        LEFT_PAREN ( (arg_mode=argmode)? (argname=identifier)? argtype=data_type (COMMA)? )* RIGHT_PAREN
    ;
    
functions_definition_schema
    : ALL FUNCTIONS IN SCHEMA (schema_name=identifier(COMMA)?)+
    ;
    
create_sequence_statement
    : CREATE (TEMPORARY | TEMP)? SEQUENCE name=schema_qualified_name 
        ((INCREMENT (BY)? incr=NUMBER)
        | (MINVALUE minval=NUMBER | NO MINVALUE) 
        | (MAXVALUE maxval=numeric_type | NO MAXVALUE)
        | (START (WITH)? start_val=NUMBER) 
        | (CACHE cache_val=NUMBER)
        | ((NO)? CYCLE)
        | (OWNED BY (col_name=schema_qualified_name | NONE)))*
    ;
    
create_schema_statement
    : CREATE SCHEMA schema_name=identifier (AUTHORIZATION user_name=identifier)? (schema_element=sql)*
      | CREATE SCHEMA AUTHORIZATION user_name=identifier (schema_element=sql)*
      | CREATE SCHEMA IF NOT EXISTS schema_name=identifier (AUTHORIZATION user_name=identifier)?
      | CREATE SCHEMA IF NOT EXISTS AUTHORIZATION user_name=identifier
    ;
create_table_statement
  : CREATE EXTERNAL TABLE n=schema_qualified_name table_elements USING file_type=identifier
    (param_clause)? (table_partitioning_clauses)? (LOCATION path=Character_String_Literal)
  | CREATE TABLE n=schema_qualified_name table_elements (USING file_type=identifier)?
    (param_clause)? (table_partitioning_clauses)? (AS query_expression)?
  | CREATE TABLE n=schema_qualified_name (USING file_type=identifier)?
    (param_clause)? (table_partitioning_clauses)? AS query_expression
    
  | CREATE ((GLOBAL | LOCAL)? (TEMPORARY | TEMP) | UNLOGGED)? TABLE (IF NOT EXISTS)? n=schema_qualified_name 
        LEFT_PAREN (
            ((
                (column_name=identifier datatype=data_type (COLLATE collation=identifier)?  (colmn_constraint=column_constraint)*)
                | tabl_constraint=table_constraint
                | (LIKE parent_table=identifier (like_opt=like_option)*)
                )(COMMA)?)+
        )? RIGHT_PAREN
        (INHERITS 
            LEFT_PAREN 
                (parent_table=identifier(COMMA)?)+ 
            RIGHT_PAREN
        )?
        storage_parameter_oid
        on_commit
        table_space
    
   | CREATE ((GLOBAL | LOCAL)? (TEMPORARY | TEMP) | UNLOGGED)? TABLE (IF NOT EXISTS)? n=schema_qualified_name OF type_name=identifier 
        (LEFT_PAREN
            (((column_name=identifier WITH OPTIONS (col_constraint=column_constraint)*) 
            | table_constraint)
            (COMMA)?)+
        RIGHT_PAREN)?
        storage_parameter_oid
        on_commit
        table_space
  ;
  
like_option
    : (INCLUDING | EXCLUDING) (DEFAULTS | CONSTRAINTS | INDEXES | STORAGE | COMMENTS | ALL)
    ;
    
table_constraint
    : (CONSTRAINT constraint_name=identifier)?
        ( check_boolean_expression
        | (UNIQUE LEFT_PAREN 
            (column_name_unique=identifier(COMMA)?)+ 
          RIGHT_PAREN index_parameters_unique=index_parameters) 
        | (PRIMARY KEY LEFT_PAREN 
            (column_name_pr_key=identifier(COMMA)?)+ 
          RIGHT_PAREN index_parameters_pr_key=index_parameters) 
        | (EXCLUDE (USING index_method=identifier)? 
            LEFT_PAREN exclude_element=identifier WITH (operator=identifier(COMMA)?)+ RIGHT_PAREN 
            index_parameters (WHERE LEFT_PAREN predicat=identifier RIGHT_PAREN)?) 
        | (FOREIGN KEY LEFT_PAREN 
            (column_name_for_key=identifier(COMMA)?)+ 
          RIGHT_PAREN 
          REFERENCES reftable=identifier ( LEFT_PAREN (refcolumn=identifier(COMMA)?)+ RIGHT_PAREN )?
            ((MATCH FULL) | (MATCH PARTIAL) | (MATCH SIMPLE))? 
            (ON DELETE action_on_delete=action)? (ON UPDATE action_on_update=action)?))
        (DEFERRABLE | (NOT DEFERRABLE))? ((INITIALLY DEFERRED) | (INITIALLY IMMEDIATE))?
    ;
    
column_constraint
    : (CONSTRAINT constraint_name=identifier)? 
        ((NOT NULL) 
        | NULL
        | check_boolean_expression 
        | (DEFAULT default_expr=routine_invocation) 
        | (UNIQUE index_params_unique=index_parameters) 
        | (PRIMARY KEY index_params_pr_key=index_parameters) 
        | (REFERENCES reftable=schema_qualified_name (( refcolumn=identifier ))  (MATCH FULL | MATCH PARTIAL | MATCH SIMPLE)? 
        (ON DELETE action_on_delete=action)? (ON UPDATE action_on_update=action)?))
        (DEFERRABLE | (NOT DEFERRABLE))? ((INITIALLY DEFERRED) | (INITIALLY IMMEDIATE))?
    ;

check_boolean_expression
    : CHECK LEFT_PAREN expression=boolean_value_expression RIGHT_PAREN
    ;
    
storage_parameter
    : WITH
        LEFT_PAREN
            (storage_param=identifier (EQUAL value=identifier)?(COMMA)?)+ 
        RIGHT_PAREN 
    ;
    
storage_parameter_oid
    : (storage_parameter | (WITH OIDS) | (WITHOUT OIDS))?
    ;

on_commit
    : (ON COMMIT ((PRESERVE ROWS) | (DELETE ROWS) | DROP))?
    ;
    
table_space
    :(TABLESPACE tablespace=identifier)?
    ;
    
action
    : (RESTRICT | CASCADE | SET NULL | SET DEFAULT)
    ;
    
index_parameters
    : (storage_parameter)? 
        (USING INDEX TABLESPACE tablespace=identifier)?
    ;
    
table_elements
  : LEFT_PAREN field_element (COMMA field_element)* RIGHT_PAREN
  ;

field_element
  : name=identifier field_type
  ;

field_type
  : data_type
  ;

param_clause
  : WITH LEFT_PAREN param (COMMA param)* RIGHT_PAREN
  ;

param
  : key=Character_String_Literal EQUAL value=numeric_value_expression
  ;

method_specifier
  : USING m=identifier
  ;

table_space_specifier
  : TABLESPACE table_space_name
  ;

table_space_name
  : identifier
  ;

table_partitioning_clauses
  : range_partitions
  | hash_partitions
  | list_partitions
  | column_partitions
  ;

range_partitions
  : PARTITION BY RANGE LEFT_PAREN column_reference_list RIGHT_PAREN
    LEFT_PAREN range_value_clause_list RIGHT_PAREN
  ;

range_value_clause_list
  : range_value_clause (COMMA range_value_clause)*
  ;

range_value_clause
  : PARTITION partition_name VALUES LESS THAN (LEFT_PAREN value_expression RIGHT_PAREN | LEFT_PAREN? MAXVALUE RIGHT_PAREN?)
  ;

hash_partitions
  : PARTITION BY HASH LEFT_PAREN column_reference_list RIGHT_PAREN
    (LEFT_PAREN individual_hash_partitions RIGHT_PAREN | hash_partitions_by_quantity)
  ;

individual_hash_partitions
  : individual_hash_partition (COMMA individual_hash_partition)*
  ;

individual_hash_partition
  : PARTITION partition_name
  ;

hash_partitions_by_quantity
  : PARTITIONS quantity = numeric_value_expression
  ;

list_partitions
  : PARTITION BY LIST LEFT_PAREN column_reference_list RIGHT_PAREN LEFT_PAREN  list_value_clause_list RIGHT_PAREN
  ;

list_value_clause_list
  : list_value_partition (COMMA list_value_partition)*
  ;

list_value_partition
  : PARTITION partition_name VALUES (IN)? LEFT_PAREN in_value_list RIGHT_PAREN
  ;

column_partitions
  : PARTITION BY COLUMN table_elements
  ;

partition_name
  : identifier
  ;

/*
===============================================================================
  11.21 <data types>
===============================================================================
*/

drop_table_statement
  : DROP TABLE schema_qualified_name (PURGE)?
  ;

/*
===============================================================================
  5.2 <token and separator>

  Specifying lexical units (tokens and separators) that participate in SQL language
===============================================================================
*/

identifier
  : (QUOTE)? Identifier (QUOTE)?
  | nonreserved_keywords
  ;

nonreserved_keywords
  : ADMIN 
  | AVG
  | BETWEEN
  | BY
  | CACHE
  | CALLED
  | CENTURY
  | CHARACTER
  | CHECK
  | CLASS
  | COALESCE
  | COLLECT
  | COLUMN
  | COMMENT
  | COMMENTS
  | COMMIT
  | CONFIGURATION
  | COST
  | COUNT
  | CUBE
  | CURRENT
  | CYCLE
  | DATA
  | DAY
  | DEC
  | DECADE
  | DEFINER
  | DICTIONARY
  | DOW
  | DOY
  | DROP
  | EPOCH
  | EVERY
  | EXISTS
  | EXTERNAL
  | EXTRACT
  | FAMILY
  | FILTER
  | FIRST
  | FORMAT
  | FUSION
  | GROUPING
  | HASH
  | INDEX
  | INCREMENT
  | INPUT
  | INSERT
  | INTERSECTION
  | ISCACHABLE
  | ISODOW
  | ISOYEAR
  | ISSTRICT
  | LANGUAGE
  | LARGE
  | LAST
  | LESS
  | LIST
  | LOCATION
  | MATCH
  | MAX
  | MAXVALUE
  | MICROSECONDS
  | MILLENNIUM
  | MILLISECONDS
  | MIN
  | MINVALUE
  | MINUTE
  | MONTH
  | NATIONAL
  | NO
  | NONE
  | NULLIF
  | OBJECT
  | OPTION
  | OPTIONS
  | OVERWRITE
  | PARSER
  | PARTIAL
  | PARTITION
  | PARTITIONS
  | PRECISION
  | PUBLIC
  | PURGE
  | QUARTER
  | RANGE
  | REGEXP
  | RLIKE
  | ROLLUP
  | SEARCH
  | SECOND
  | SECURITY
  | SERVER
  | SET
  | SIMILAR
  | SIMPLE
  | STABLE
  | START
  | STORAGE
  | STDDEV_POP
  | STDDEV_SAMP
  | SUBPARTITION
  | SUM
  | TABLESPACE
  | TEMPLATE
  | THAN
  | TIMEZONE
  | TIMEZONE_HOUR
  | TIMEZONE_MINUTE
  | TRIM
  | TO
  | UNKNOWN
  | UNLOGGED
  | VALUES
  | VAR_POP
  | VAR_SAMP
  | VARYING
  | VOLATILE
  | WEEK
  | WINDOW
  | WRAPPER
  | YEAR
  | ZONE

  | BIGINT
  | BIT
  | BLOB
  | BOOL
  | BOOLEAN
  | BYTEA
  | CHAR
  | DATE
  | DECIMAL
  | DOUBLE
  | FLOAT
  | FLOAT4
  | FLOAT8
  | INET4
  | INT
  | INT1
  | INT2
  | INT4
  | INT8
  | INTEGER
  | NCHAR
  | NUMERIC
  | NVARCHAR
  | REAL
  | SMALLINT
  | TEXT
  | TIME
  | TIMESTAMP
  | TIMESTAMPTZ
  | TIMETZ
  | TINYINT
  | VARBINARY
  | VARBIT
  | VARCHAR
  ;

/*
===============================================================================
  5.3 <literal>
===============================================================================
*/

unsigned_literal
  : unsigned_numeric_literal
  | general_literal
  ;

general_literal
  : Character_String_Literal
  | datetime_literal
  | boolean_literal
  ;

datetime_literal
  : timestamp_literal
  | time_literal
  | date_literal
  ;

time_literal
  : TIME time_string=Character_String_Literal
  ;

timestamp_literal
  : TIMESTAMP timestamp_string=Character_String_Literal
  ;

date_literal
  : DATE date_string=Character_String_Literal
  ;

boolean_literal
  : TRUE | FALSE | UNKNOWN
  ;

/*
===============================================================================
  6.1 <data types>
===============================================================================
*/

data_type
  : predefined_type
  ;

predefined_type
  : character_string_type
  | national_character_string_type
  | binary_large_object_string_type
  | numeric_type
  | boolean_type
  | datetime_type
  | bit_type
  | binary_type
  | network_type
  | regclass
  | TRIGGER
  ;

regclass
    : REGCLASS
    ;
    
network_type
  : INET4
  ;

character_string_type
  : CHARACTER type_length?
  | CHAR type_length?
  | CHARACTER VARYING type_length?
  | CHAR VARYING type_length?
  | VARCHAR type_length?
  | TEXT
  ;

type_length
  : LEFT_PAREN NUMBER RIGHT_PAREN
  ;

national_character_string_type
  : NATIONAL CHARACTER type_length?
  | NATIONAL CHAR type_length?
  | NCHAR type_length?
  | NATIONAL CHARACTER VARYING type_length?
  | NATIONAL CHAR VARYING type_length?
  | NCHAR VARYING type_length?
  | NVARCHAR type_length?
  ;

binary_large_object_string_type
  : BLOB type_length?
  | BYTEA type_length?
  ;

numeric_type
  : exact_numeric_type | approximate_numeric_type
  ;

exact_numeric_type
  : NUMERIC (precision_param)?
  | DECIMAL (precision_param)?
  | DEC (precision_param)?
  | INT1
  | TINYINT
  | INT2
  | SMALLINT
  | INT4
  | INT
  | INTEGER
  | INT8
  | BIGINT
  ;

approximate_numeric_type
  : FLOAT (precision_param)?
  | FLOAT4
  | REAL
  | FLOAT8
  | DOUBLE
  | DOUBLE PRECISION
  ;

precision_param
  : LEFT_PAREN precision=NUMBER RIGHT_PAREN
  | LEFT_PAREN precision=NUMBER COMMA scale=NUMBER RIGHT_PAREN
  ;

boolean_type
  : BOOLEAN
  | BOOL
  ;

datetime_type
  : DATE
  | TIME
  | TIME WITH TIME ZONE
  | TIMETZ
  | TIMESTAMP
  | TIMESTAMP WITH TIME ZONE
  | TIMESTAMPTZ
  ;

bit_type
  : BIT type_length?
  | VARBIT type_length?
  | BIT VARYING type_length?
  ;

binary_type
  : BINARY type_length?
  | BINARY VARYING type_length?
  | VARBINARY type_length?
  ;

/*
===============================================================================
  6.3 <value_expression_primary>
===============================================================================
*/
value_expression_primary
  : parenthesized_value_expression
  | nonparenthesized_value_expression_primary
  ;

parenthesized_value_expression
  : LEFT_PAREN value_expression RIGHT_PAREN
  ;

nonparenthesized_value_expression_primary
  : unsigned_value_specification
  | column_reference
  | set_function_specification
  | scalar_subquery
  | case_expression
  | cast_specification
  | routine_invocation
  ;

/*
===============================================================================
  6.4 <unsigned value specification>
===============================================================================
*/

unsigned_value_specification
  : unsigned_literal
  ;

unsigned_numeric_literal
  : NUMBER
  | REAL_NUMBER
  ;

signed_numerical_literal
  : sign? unsigned_numeric_literal
  ;

/*
===============================================================================
  6.9 <set function specification>

  Invoke an SQL-invoked routine.
===============================================================================
*/
set_function_specification
  : aggregate_function
  ;

aggregate_function
  : COUNT LEFT_PAREN MULTIPLY RIGHT_PAREN
  | general_set_function filter_clause?
  ;

general_set_function
  : set_function_type LEFT_PAREN set_qualifier? value_expression RIGHT_PAREN
  ;

set_function_type
  : AVG
  | MAX
  | MIN
  | SUM
  | EVERY
  | ANY
  | SOME
  | COUNT
  | STDDEV_POP
  | STDDEV_SAMP
  | VAR_SAMP
  | VAR_POP
  | COLLECT
  | FUSION
  | INTERSECTION
  ;

filter_clause
  : FILTER LEFT_PAREN WHERE search_condition RIGHT_PAREN
  ;

grouping_operation
  : GROUPING LEFT_PAREN column_reference_list RIGHT_PAREN
  ;

/*
===============================================================================
  6.11 <case expression>
===============================================================================
*/

case_expression
  : case_specification
  ;

case_abbreviation
  : NULLIF LEFT_PAREN numeric_value_expression COMMA boolean_value_expression  RIGHT_PAREN
  | COALESCE LEFT_PAREN numeric_value_expression ( COMMA boolean_value_expression  )+ RIGHT_PAREN
  ;

case_specification
  : simple_case
  | searched_case
  ;

simple_case
  : CASE boolean_value_expression ( simple_when_clause )+ ( else_clause  )? END
  ;

searched_case
  : CASE (searched_when_clause)+ (else_clause)? END
  ;

simple_when_clause : WHEN search_condition THEN result ;

searched_when_clause
  : WHEN c=search_condition THEN r=result
  ;

else_clause
  : ELSE r=result
  ;

result
  : value_expression | NULL
  ;

/*
===============================================================================
  6.12 <cast specification>
===============================================================================
*/

cast_specification
  : CAST LEFT_PAREN cast_operand AS cast_target RIGHT_PAREN
  ;

cast_operand
  : value_expression
  ;

cast_target
  : data_type
  ;

/*
===============================================================================
  6.25 <value expression>
===============================================================================
*/
value_expression
  : common_value_expression
  | row_value_expression
  | boolean_value_expression
  ;
  
common_value_expression
  : numeric_value_expression
  | string_value_expression
  | NULL
  ;

/*
===============================================================================
  6.26 <numeric value expression>

  Specify a comparison of two row values.
===============================================================================
*/

numeric_value_expression
  : left=term ((PLUS|MINUS) right=term)*
  ;

term
  : left=factor ((MULTIPLY|DIVIDE|MODULAR) right=factor)*
  ;

factor
  : (sign)? numeric_primary
  ;

array
  : LEFT_PAREN numeric_value_expression (COMMA numeric_value_expression )* RIGHT_PAREN
  ;

numeric_primary
  : value_expression_primary (CAST_EXPRESSION cast_target)*
  | numeric_value_function
  ;

sign
  : PLUS | MINUS
  ;

/*
===============================================================================
  6.27 <numeric value function>
===============================================================================
*/

numeric_value_function
  : extract_expression
  ;

extract_expression
  : EXTRACT LEFT_PAREN extract_field_string=extract_field FROM extract_source RIGHT_PAREN
  ;

extract_field
  : primary_datetime_field
  | time_zone_field
  | extended_datetime_field
  ;

time_zone_field
  : TIMEZONE | TIMEZONE_HOUR | TIMEZONE_MINUTE
  ;

extract_source
  : column_reference
  | datetime_literal
  ;

/*
===============================================================================
  6.28 <string value expression>
===============================================================================
*/

string_value_expression
  : character_value_expression
  ;

character_value_expression
  : character_factor (CONCATENATION_OPERATOR character_factor)*
  ;

character_factor
  : character_primary
  ;

character_primary
  : value_expression_primary
  | string_value_function
  ;

/*
===============================================================================
  6.29 <string value function>
===============================================================================
*/

string_value_function
  : trim_function
  ;

trim_function
  : TRIM LEFT_PAREN trim_operands RIGHT_PAREN
  ;

trim_operands
  : ((trim_specification)? (trim_character=character_value_expression)? FROM)? trim_source=character_value_expression
  | trim_source=character_value_expression COMMA trim_character=character_value_expression
  ;

trim_specification
  : LEADING | TRAILING | BOTH
  ;

/*
===============================================================================
  6.34 <boolean value expression>
===============================================================================
*/

boolean_value_expression
  : or_predicate
  ;

or_predicate
  : and_predicate (OR or_predicate)*
  ;

and_predicate
  : boolean_factor (AND and_predicate)*
  ;

boolean_factor
  : boolean_test
  | NOT boolean_test
  ;

boolean_test
  : boolean_primary is_clause?
  ;

is_clause
  : IS NOT? t=truth_value
  ;

truth_value
  : TRUE | FALSE | UNKNOWN
  ;

boolean_primary
  : predicate
  | boolean_predicand
  ;

boolean_predicand
  : parenthesized_boolean_value_expression 
  | nonparenthesized_value_expression_primary
  ;

parenthesized_boolean_value_expression
  : LEFT_PAREN boolean_value_expression RIGHT_PAREN
  ;

/*
===============================================================================
  7.2 <row value expression>
===============================================================================
*/
row_value_expression
  : row_value_special_case
  | explicit_row_value_constructor
  ;

row_value_special_case
  : nonparenthesized_value_expression_primary
  ;

explicit_row_value_constructor
  : NULL
  ;

row_value_predicand
  : row_value_special_case
  | row_value_constructor_predicand
  ;

row_value_constructor_predicand
  : common_value_expression
  | boolean_predicand
//  | explicit_row_value_constructor
  ;

/*
===============================================================================
  7.4 <table expression>
===============================================================================
*/

table_expression
  : from_clause
    where_clause?
    groupby_clause?
    having_clause?
    orderby_clause?
    limit_clause?
  ;

/*
===============================================================================
  7.5 <from clause>
===============================================================================
*/

from_clause
  : FROM table_reference_list
  ;

table_reference_list
  :table_reference (COMMA table_reference)*
  ;

/*
===============================================================================
  7.6 <table reference>
===============================================================================
*/

table_reference
  : joined_table
  | table_primary
  ;

/*
===============================================================================
  7.7 <joined table>
===============================================================================
*/

joined_table
  : table_primary joined_table_primary+
  ;

joined_table_primary
  : CROSS JOIN right=table_primary
  | (t=join_type)? JOIN right=table_primary s=join_specification
  | NATURAL (t=join_type)? JOIN right=table_primary
  | UNION JOIN right=table_primary
  ;

cross_join
  : CROSS JOIN r=table_primary
  ;

qualified_join
  : (t=join_type)? JOIN r=table_primary s=join_specification
  ;

natural_join
  : NATURAL (t=join_type)? JOIN r=table_primary
  ;

union_join
  : UNION JOIN r=table_primary
  ;

join_type
  : INNER
  | t=outer_join_type
  ;

outer_join_type
  : outer_join_type_part2 OUTER?
  ;

outer_join_type_part2
  : LEFT
  | RIGHT
  | FULL
  ;

join_specification
  : join_condition
  | named_columns_join
  ;

join_condition
  : ON search_condition
  ;

named_columns_join
  : USING LEFT_PAREN f=column_reference_list RIGHT_PAREN
  ;

table_primary
  : table_or_query_name ((AS)? alias=identifier)? (LEFT_PAREN column_name_list RIGHT_PAREN)?
  | derived_table (AS)? name=identifier (LEFT_PAREN column_name_list RIGHT_PAREN)?
  ;

column_name_list
  :  identifier  ( COMMA identifier  )*
  ;

derived_table
  : table_subquery
  ;

/*
===============================================================================
  7.8 <where clause>
===============================================================================
*/
where_clause
  : WHERE search_condition
  ;

search_condition
  : value_expression // instead of boolean_value_expression, we use value_expression for more flexibility.
  ;

/*
===============================================================================
  7.9 <group by clause>
===============================================================================
*/
groupby_clause
  : GROUP BY g=grouping_element_list
  ;

grouping_element_list
  : grouping_element (COMMA grouping_element)*
  ;

grouping_element
  : rollup_list
  | cube_list
  | empty_grouping_set
  | ordinary_grouping_set
  ;

ordinary_grouping_set
  : row_value_predicand
  | LEFT_PAREN row_value_predicand_list RIGHT_PAREN
  ;

ordinary_grouping_set_list
  : ordinary_grouping_set (COMMA ordinary_grouping_set)*
  ;

rollup_list
  : ROLLUP LEFT_PAREN c=ordinary_grouping_set_list RIGHT_PAREN
  ;

cube_list
  : CUBE LEFT_PAREN c=ordinary_grouping_set_list RIGHT_PAREN
  ;

empty_grouping_set
  : LEFT_PAREN RIGHT_PAREN
  ;

having_clause
  : HAVING boolean_value_expression
  ;

row_value_predicand_list
  : row_value_predicand (COMMA row_value_predicand)*
  ;

/*
===============================================================================
  7.13 <query expression>
===============================================================================
*/
query_expression
  : query_expression_body
  ;

query_expression_body
  : non_join_query_expression
  | joined_table
  ;

non_join_query_expression
  : (non_join_query_term
  | joined_table (UNION | EXCEPT) (ALL|DISTINCT)? query_term)
    ((UNION | EXCEPT) (ALL|DISTINCT)? query_term)*
  ;

query_term
  : non_join_query_term
  | joined_table
  ;

non_join_query_term
  : ( non_join_query_primary
  | joined_table INTERSECT (ALL|DISTINCT)? query_primary)
    (INTERSECT (ALL|DISTINCT)? query_primary)*
  ;

query_primary
  : non_join_query_primary
  | joined_table
  ;

non_join_query_primary
  : simple_table
  | LEFT_PAREN non_join_query_expression RIGHT_PAREN
  ;

simple_table
  : query_specification
  | explicit_table
  ;

explicit_table
  : TABLE table_or_query_name
  ;

table_or_query_name
  : schema_qualified_name
  | identifier
  ;

schema_qualified_name
  : identifier  ( DOT  identifier (  DOT identifier )? )?
  ;

query_specification
  : SELECT set_qualifier? select_list table_expression?
  ;

select_list
  : select_sublist (COMMA select_sublist)*
  ;

select_sublist
  : derived_column
  | qualified_asterisk
  ;

derived_column
  : value_expression as_clause?
  ;

qualified_asterisk
  : (tb_name=Identifier DOT)? MULTIPLY
  ;

set_qualifier
  : DISTINCT
  | ALL
  ;

column_reference
  : (tb_name=identifier DOT)? name=identifier
  ;

as_clause
  : (AS)? identifier
  ;

column_reference_list
  : column_reference (COMMA column_reference)*
  ;

/*
==============================================================================================
  7.15 <subquery>

  Specify a scalar value, a row, or a table derived from a query_expression .
==============================================================================================
*/

scalar_subquery
  :  subquery
  ;

row_subquery
  :  subquery
  ;

table_subquery
  : subquery
  ;

subquery
  :  LEFT_PAREN query_expression RIGHT_PAREN
  ;

/*
===============================================================================
  8.1 <predicate>
===============================================================================
*/

predicate
  : comparison_predicate
  | between_predicate
  | in_predicate
  | pattern_matching_predicate // like predicate and other similar predicates
  | null_predicate
  | exists_predicate
  ;

/*
===============================================================================
  8.2 <comparison predicate>

  Specify a comparison of two row values.
===============================================================================
*/
comparison_predicate
  : left=row_value_predicand c=comp_op right=row_value_predicand
  ;

comp_op
  : EQUAL
  | NOT_EQUAL
  | LTH
  | LEQ
  | GTH
  | GEQ
  ;

/*
===============================================================================
  8.3 <between predicate>
===============================================================================
*/

between_predicate
  : predicand=row_value_predicand between_predicate_part_2
  ;

between_predicate_part_2
  : (NOT)? BETWEEN (ASYMMETRIC | SYMMETRIC)? begin=row_value_predicand AND end=row_value_predicand
  ;


/*
===============================================================================
  8.4 <in predicate>
===============================================================================
*/

in_predicate
  : predicand=numeric_value_expression  NOT? IN in_predicate_value
  ;

in_predicate_value
  : table_subquery
  | LEFT_PAREN in_value_list RIGHT_PAREN
  ;

in_value_list
  : row_value_expression  ( COMMA row_value_expression )*
  ;

/*
===============================================================================
  8.5, 8.6 <pattern matching predicate>

  Specify a pattern-matching comparison.
===============================================================================
*/

pattern_matching_predicate
  : f=row_value_predicand pattern_matcher s=Character_String_Literal
  ;

pattern_matcher
  : NOT? negativable_matcher
  | regex_matcher
  ;

negativable_matcher
  : LIKE
  | ILIKE
  | SIMILAR TO
  | REGEXP
  | RLIKE
  ;

regex_matcher
  : Similar_To
  | Not_Similar_To
  | Similar_To_Case_Insensitive
  | Not_Similar_To_Case_Insensitive
  ;

/*
===============================================================================
  8.7 <null predicate>

  Specify a test for a null value.
===============================================================================
*/

null_predicate
  : predicand=row_value_predicand IS (n=NOT)? NULL
  ;

/*
==============================================================================================
  8.8 <quantified comparison predicate>

  Specify a quantified comparison.
==============================================================================================
*/

quantified_comparison_predicate
  : l=numeric_value_expression  c=comp_op q=quantifier s=table_subquery
  ;

quantifier : all  | some ;

all : ALL;

some : SOME | ANY;

/*
==============================================================================================
  8.9 <exists predicate>

  Specify a test for a non_empty set.
==============================================================================================
*/

exists_predicate
  : NOT? EXISTS s=table_subquery
  ;


/*
==============================================================================================
  8.10 <unique predicate>

  Specify a test for the absence of duplicate rows
==============================================================================================
*/

unique_predicate
  : UNIQUE s=table_subquery
  ;

/*
===============================================================================
  10.1 <interval qualifier>

  Specify the precision of an interval data type.
===============================================================================
*/

primary_datetime_field
	:	non_second_primary_datetime_field
	|	SECOND
	;

non_second_primary_datetime_field
  : YEAR | MONTH | DAY | HOUR | MINUTE
  ;

extended_datetime_field
  : CENTURY | DECADE | DOW | DOY | EPOCH | ISODOW | ISOYEAR | MICROSECONDS | MILLENNIUM | MILLISECONDS | QUARTER | WEEK
  ;

/*
===============================================================================
  10.4 <routine invocation>

  Invoke an SQL-invoked routine.
===============================================================================
*/

routine_invocation
  : function_name LEFT_PAREN sql_argument_list? RIGHT_PAREN
  ;

function_names_for_reserved_words
  : LEFT
  | RIGHT
  ;

function_name
  : identifier
  | function_names_for_reserved_words
  ;

sql_argument_list
  : value_expression (COMMA value_expression)*
  ;

/*
===============================================================================
  14.1 <declare cursor>
===============================================================================
*/

orderby_clause
  : ORDER BY sort_specifier_list
  ;

sort_specifier_list
  : sort_specifier (COMMA sort_specifier)*
  ;

sort_specifier
  : key=row_value_predicand order=order_specification? null_order=null_ordering?
  ;

order_specification
  : ASC
  | DESC
  ;

limit_clause
  : LIMIT e=numeric_value_expression
  ;

null_ordering
  : NULL FIRST
  | NULL LAST
  ;

/*
===============================================================================
  14.8 <insert statement>
===============================================================================
*/

insert_statement
  : INSERT (OVERWRITE)? INTO schema_qualified_name (LEFT_PAREN column_name_list RIGHT_PAREN)? query_expression
  | INSERT (OVERWRITE)? INTO LOCATION path=Character_String_Literal (USING file_type=identifier (param_clause)?)? query_expression
  ;
