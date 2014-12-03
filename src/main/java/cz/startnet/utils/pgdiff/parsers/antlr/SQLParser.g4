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
  : (statement SEMI_COLON)* EOF
  ;

statement
  : data_statement
   /*| data_change_statement*/
  | schema_statement
  
  ;

data_statement
  : query_expression 
  | copy_statement
  ;

copy_statement
    : COPY (table_name=schema_qualified_name (LEFT_PAREN column_name=schema_qualified_name(COMMA column_name=schema_qualified_name)* RIGHT_PAREN)? 
           | ( query=query_expression ))
        (FROM | TO) (filename=identifier | STDIN)
        ((WITH)? LEFT_PAREN option=copy_option(COMMA option=copy_option)* RIGHT_PAREN)?
    ;
copy_option:
    FORMAT format_name=identifier
    | OIDS (boolean_val=truth_value)?
    | DELIMITER delimiter_character=identifier
    | NULL null_string=identifier
    | HEADER (boolean_val=truth_value)?
    | QUOTE quote_character=identifier
    | ESCAPE escape_character=identifier
    | FORCE_QUOTE ((LEFT_PAREN column_name=schema_qualified_name (COMMA column_name=schema_qualified_name)* RIGHT_PAREN) | MULTIPLY)
    | FORCE_NOT_NULL LEFT_PAREN column_name=schema_qualified_name (COMMA column_name=schema_qualified_name)* RIGHT_PAREN
    | ENCODING encoding_name=identifier
    ;
//data_change_statement
//  : insert_statement
//  ;

schema_statement
  : schema_create
    | schema_alter
    | drop_table_statement 
  ;
  
schema_create
    : CREATE (create_table_statement
    | index_statement
    | create_extension_statement
    | create_trigger_statement
    | create_function_statement
    | create_sequence_statement
    | create_schema_statement
    | create_view_statement
    | create_language_statement
    | create_event_trigger)
     
    | comment_on_statement
    | rule_common
    | set_statement
    ;
    
schema_alter
    : ALTER (alter_function_statement
    | alter_schema_statement
    | alter_language_statement
    | alter_table_statement
    | alter_default_privileges
    | alter_sequence_statement
    | alter_view_statement)
    ;
    
alter_function_statement
    : FUNCTION function_parameters 
      ((function_actions_common | RESET (configuration_parameter=identifier | ALL))+ (RESTRICT)?
    | rename_to
    | owner_to
    | set_schema)
    ;
    
alter_schema_statement
    : schema_with_name (rename_to | owner_to)
    ;

alter_language_statement
    : (PROCEDURAL)? LANGUAGE name=identifier (rename_to | owner_to)
    ;

alter_table_statement
    : TABLE (ONLY)? name=schema_qualified_name MULTIPLY?(
        (table_action ((COMMA)table_action)*
        | RENAME (COLUMN)? column=schema_qualified_name TO new_column=schema_qualified_name)
    | set_schema
    | rename_to)
    ;

table_action
    : ADD (COLUMN)? table_column_definition
    | DROP (COLUMN)? (IF EXISTS)? column=schema_qualified_name (RESTRICT | CASCADE)?
    | ALTER (COLUMN)? column=schema_qualified_name 
      ((SET DATA)? TYPE datatype=data_type (COLLATE collation=identifier)? (USING expression=value_expression)?
      | (SET DEFAULT expression=value_expression 
        | DROP DEFAULT 
        | ((SET | DROP) NOT NULL) 
        | SET STATISTICS integer=NUMBER
        | SET LEFT_PAREN attribute_option_value (COMMA attribute_option_value)* RIGHT_PAREN
        | RESET LEFT_PAREN attribute_option+=table_attribute_option (COMMA attribute_option+=table_attribute_option)* RIGHT_PAREN
        | SET STORAGE (PLAIN | EXTERNAL | EXTENDED | MAIN)))
    | ADD tabl_constraint=constraint_common (NOT VALID)?
    | ADD tabl_constraint_using_index=table_constraint_using_index
    | VALIDATE CONSTRAINT constraint_name=schema_qualified_name
    | DROP CONSTRAINT (IF EXISTS)?  constraint_name=schema_qualified_name (RESTRICT | CASCADE)
    | (DISABLE | ENABLE) TRIGGER (trigger_name=schema_qualified_name | (ALL | USER))?
    | ENABLE (REPLICA | ALWAYS) TRIGGER trigger_name=schema_qualified_name 
    | (DISABLE | ENABLE) RULE rewrite_rule_name=schema_qualified_name 
    | ENABLE (REPLICA | ALWAYS) RULE rewrite_rule_name=schema_qualified_name 
    | CLUSTER ON index_name=schema_qualified_name 
    | SET WITHOUT (CLUSTER | OIDS)
    | SET WITH OIDS
    | SET storage_parameter
    | RESET LEFT_PAREN with_storage_parameter (COMMA with_storage_parameter)* RIGHT_PAREN
    | INHERIT parent_table=schema_qualified_name 
    | NO INHERIT parent_table=schema_qualified_name 
    | OF type_name=schema_qualified_name 
    | NOT OF
    | owner_to
    | SET table_space
    ;

attribute_option_value
    : attribute_option=table_attribute_option EQUAL value=signed_numerical_literal
    ;

table_constraint_using_index
    : (CONSTRAINT constraint_name=schema_qualified_name)?
     (UNIQUE | PRIMARY KEY) USING INDEX index_name=schema_qualified_name
     table_deferrable? table_initialy_immed?
    ;

table_attribute_option
    :N_DISTINCT | N_DISTINCT_INHERITED
    ;

table_deferrable
    : (NOT)? DEFERRABLE
    ;

table_initialy_immed
    :INITIALLY (DEFERRED | IMMEDIATE)
    ;

function_actions_common
    : (CALLED | RETURNS NULL) ON NULL INPUT
      | (STRICT | IMMUTABLE | VOLATILE | STABLE)
      | (EXTERNAL)? SECURITY (INVOKER | DEFINER)
      | COST execution_cost=NUMBER
      | ROWS result_rows=NUMBER
      | SET configuration_parameter=identifier  (((TO | EQUAL)? (value+=identifier | DEFAULT)) | FROM CURRENT)(COMMA value+=identifier)*
    ;

alter_default_privileges
    : DEFAULT PRIVILEGES
    (FOR (ROLE | USER) target_role+=identifier (COMMA target_role+=identifier)*)?
    (IN SCHEMA schema_name+=identifier (COMMA schema_name+=identifier)*)?
    abbreviated_grant_or_revoke
    ;

abbreviated_grant_or_revoke
    : (GRANT | REVOKE (GRANT OPTION FOR)?) (
      (( common_query_list (COMMA common_query_list)*)
        | ALL (PRIVILEGES)?)
        ON TABLES

    | ((usage_select_update(COMMA usage_select_update)*)
        | ALL (PRIVILEGES)?)
        ON SEQUENCES

    | (EXECUTE | ALL (PRIVILEGES)?)
        ON FUNCTIONS

    | (USAGE | ALL (PRIVILEGES)?)
        ON TYPES)
        (grant_to_rule | revoke_from_cascade_restrict)
    ;

alter_sequence_statement
    : SEQUENCE (IF EXISTS)? name=schema_qualified_name 
     ( (sequence_body | RESTART ((WITH)? restart=identifier)?)*
    | set_schema
    | owner_to
    | rename_to)
    ;

alter_view_statement
    : VIEW (IF EXISTS)? name=schema_qualified_name 
     (ALTER (COLUMN)? column_name=schema_qualified_name  (SET DEFAULT expression=value_expression | DROP DEFAULT)
    | set_schema
    | owner_to
    | rename_to
    | SET LEFT_PAREN view_option_name=identifier (EQUAL view_option_value=value_expression)?(COMMA view_option_name=identifier (EQUAL view_option_value=value_expression)?)*  RIGHT_PAREN
    | RESET LEFT_PAREN view_option_name=identifier (COMMA view_option_name=identifier)*  RIGHT_PAREN)
    ;

index_statement
  : (unique_value=UNIQUE)? INDEX (CONCURRENTLY)? (name=schema_qualified_name)? ON table_name=schema_qualified_name 
    (USING method=schema_qualified_name)?
    LEFT_PAREN sort_specifier_list RIGHT_PAREN param_clause?
    table_space?
    (WHERE predic=boolean_value_expression)?
  ;
  
 create_extension_statement
    : EXTENSION (IF NOT EXISTS)? name=schema_qualified_name (WITH)?
         schema_with_name? (VERSION version=unsigned_literal)? (FROM old_version=unsigned_literal)?
    ;
    
create_language_statement
    : (OR REPLACE)? (TRUSTED)? (PROCEDURAL)? LANGUAGE name=identifier
        (HANDLER call_handler=schema_qualified_name (INLINE inline_handler=schema_qualified_name)? (VALIDATOR valfunction=schema_qualified_name)?)?
    ;

create_event_trigger
    : EVENT TRIGGER name=schema_qualified_name
        ON event=schema_qualified_name
        (WHEN filter_variable=schema_qualified_name (IN 
            LEFT_PAREN 
                filter_value+=Character_String_Literal(COMMA filter_value+=Character_String_Literal)* 
            RIGHT_PAREN(AND)?)+ )?
        EXECUTE PROCEDURE funct_name=value_expression
    ;
    
set_statement
    : SET (SESSION | LOCAL)? 
      (config_param=identifier (TO |EQUAL) config_param_val+=set_statement_value (COMMA config_param_val+=set_statement_value)*
    | TIME ZONE (timezone=identifier | (LOCAL | DEFAULT))(COMMA (timezone=identifier | (LOCAL | DEFAULT)))*)
    ;

set_statement_value
    : (value=value_expression | DEFAULT)
    | QUOTE set_statement_value QUOTE
    ;
   
create_trigger_statement
    : (CONSTRAINT)? TRIGGER name=schema_qualified_name (before_true=BEFORE | (INSTEAD OF) | AFTER)
    (((insert_true=INSERT | delete_true=DELETE | truncate_true=TRUNCATE) | update_true=UPDATE (OF columnName+=schema_qualified_name(COMMA columnName+=schema_qualified_name)* )?)OR?)+
    ON tabl_name=schema_qualified_name 
    (FROM referenced_table_name=schema_qualified_name)?
    table_deferrable? table_initialy_immed?
    (for_each_true=FOR (EACH)? (ROW | STATEMENT))?
    (WHEN (when_expr=boolean_value_expression))?
    EXECUTE PROCEDURE func_name=schema_qualified_name LEFT_PAREN (arguments+=identifier)? (COMMA arguments+=identifier)* RIGHT_PAREN
    ;
    
rule_common
    : (GRANT | REVOKE (GRANT OPTION FOR)?) 
      (on_table 
        | on_column 
        | on_sequence
        | on_database
        | on_datawrapper_server_lang
        | on_function
        | on_large_object
        | on_schema
        | on_tablespace)
      (grant_to_rule | revoke_from_cascade_restrict)
      | GRANT name+=schema_qualified_name (COMMA name+=schema_qualified_name)* TO role_name+=identifier(COMMA role_name+=identifier)* (WITH ADMIN OPTION)?
      | REVOKE (ADMIN OPTION FOR)? obj_name+=schema_qualified_name (COMMA obj_name+=schema_qualified_name)* FROM role_name+=identifier(COMMA role_name+=identifier)*
        (CASCADE | RESTRICT)?
    ;
    
grant_to_rule
    : TO roles_names (WITH GRANT OPTION)?
    ;
    
revoke_from_cascade_restrict
    : FROM roles_names (CASCADE | RESTRICT)?
    ;

on_table
    : (common_query_list (COMMA common_query_list)* | ALL (PRIVILEGES)?) 
        ON ( ((TABLE)? obj_name+=schema_qualified_name (COMMA obj_name+=schema_qualified_name)*)
             | ALL TABLES IN SCHEMA (schema_name+=identifier)+)
    ;

on_column
    : (((SELECT | INSERT | UPDATE | REFERENCES) LEFT_PAREN column+=identifier (COMMA column+=identifier)* RIGHT_PAREN)+
         | ALL (PRIVILEGES)? LEFT_PAREN column+=identifier (COMMA column+=identifier)* RIGHT_PAREN )
        ON (TABLE)? obj_name+=schema_qualified_name (COMMA obj_name+=schema_qualified_name)*
    ;

on_sequence
    : (usage_select_update(COMMA usage_select_update)*
        | ALL (PRIVILEGES)?)
        ON (SEQUENCE obj_name+=schema_qualified_name (COMMA obj_name+=schema_qualified_name)*
             | ALL SEQUENCES IN SCHEMA schema_name+=identifier (COMMA schema_name+=identifier)*)
    ;

on_database
    : (create_connect_temporary_temp(COMMA create_connect_temporary_temp)* | ALL (PRIVILEGES)? )
        ON DATABASE obj_name+=schema_qualified_name (COMMA obj_name+=schema_qualified_name)*
    ;

on_datawrapper_server_lang
    : (USAGE | ALL (PRIVILEGES)?)
        ON (FOREIGN (DATA WRAPPER | SERVER) | LANGUAGE) obj_name+=schema_qualified_name (COMMA obj_name+=schema_qualified_name)*
    ;

on_function
    : (EXECUTE | ALL (PRIVILEGES)?) 
        ON (FUNCTION obj_name+=schema_qualified_name funct_args=function_args (COMMA obj_name+=schema_qualified_name funct_args=function_args)* 
           | ALL FUNCTIONS IN SCHEMA schema_name+=identifier(COMMA schema_name+=identifier)*)
    ;

on_large_object
    : ((SELECT | UPDATE(COMMA)?)+  | ALL (PRIVILEGES)?) 
        ON LARGE OBJECT obj_name+=schema_qualified_name(COMMA obj_name+=schema_qualified_name)*
    ;
on_schema
    : (((CREATE | USAGE)(COMMA)?)+ | ALL (PRIVILEGES)?) 
        ON SCHEMA obj_name+=schema_qualified_name(COMMA obj_name+=schema_qualified_name)*
    ;
    
on_tablespace
    : (CREATE | ALL (PRIVILEGES)?)
        ON TABLESPACE obj_name+=schema_qualified_name (COMMA obj_name+=schema_qualified_name)*
    ;

roles_names
    :((GROUP)? role_name+=identifier | PUBLIC)(COMMA ((GROUP)? role_name+=identifier | PUBLIC))*
    ;
    
comment_on_statement
    : COMMENT ON(
        AGGREGATE name=schema_qualified_name LEFT_PAREN (agg_type+=data_type(COMMA agg_type+=data_type)*)? RIGHT_PAREN 
        | CAST LEFT_PAREN source_type=data_type AS target_type=data_type RIGHT_PAREN 
        | (CONSTRAINT | RULE | TRIGGER) name=schema_qualified_name ON table_name=schema_qualified_name
        | FUNCTION name=schema_qualified_name function_args
        | OPERATOR name=schema_qualified_name LEFT_PAREN left_type=data_type COMMA right_type=data_type RIGHT_PAREN 
        | OPERATOR (FAMILY| CLASS) name=schema_qualified_name USING index_method=identifier
        | (TEXT SEARCH (CONFIGURATION | DICTIONARY | PARSER | TEMPLATE )
        | (PROCEDURAL)? LANGUAGE 
        | LARGE OBJECT 
        | FOREIGN (DATA WRAPPER | TABLE)
        | (COLUMN | CONVERSION | DATABASE| DOMAIN| EXTENSION| INDEX | ROLE 
            | COLLATION| SCHEMA| SEQUENCE| SERVER| TABLE | TABLESPACE 
            | TYPE | VIEW)
          ) name=schema_qualified_name
        ) IS comment_text=Character_String_Literal
    ;

/*
===============================================================================
  Function Definition
===============================================================================
*/
create_function_statement
    : (OR REPLACE)? FUNCTION function_parameters
        (RETURNS (rettype=value_expression | rettype_data=data_type | ret_table=function_ret_table))?
          (LANGUAGE lang_name=identifier
            | WINDOW
            | function_actions_common
            | AS function_body
            | AS Character_String_Literal (COMMA Character_String_Literal)*
          )+
            (WITH LEFT_PAREN attribute+=function_attribute(COMMA attribute+=function_attribute)* RIGHT_PAREN)?
    ;

function_ret_table
    :TABLE LEFT_PAREN function_column_name_type(COMMA function_column_name_type)* RIGHT_PAREN
    ;
function_column_name_type
    : column_name=identifier column_type=data_type
    ;

function_parameters
    : name=schema_qualified_name 
      function_args
    ;

function_args
    : LEFT_PAREN (function_arguments (COMMA function_arguments)*)? RIGHT_PAREN
    ;

function_def_value
    : (DEFAULT | EQUAL) def_value=value_expression
    ;

function_body
    : BeginDollarStringConstant Text_between_Dollar+ EndDollarStringConstant
    ;

function_arguments
    :(arg_mode=argmode)? (argname=identifier)? (argtype_data=data_type | argtype_expres=value_expression) function_def_value?
    ;

function_attribute
    : ISSTRICT | ISCACHABLE
    ;
        
argmode
    : 
      IN | OUT | INOUT | VARIADIC
    ;
    
create_sequence_statement
    : (TEMPORARY | TEMP)? SEQUENCE name=schema_qualified_name 
        (sequence_body)*
    ;

sequence_body
    : INCREMENT (BY)? incr=NUMBER
        | (MINVALUE minval=signed_numerical_literal | NO MINVALUE) 
        | (MAXVALUE maxval=signed_numerical_literal | NO MAXVALUE)
        | START (WITH)? start_val=signed_numerical_literal
        | CACHE cache_val=signed_numerical_literal
        | (cycle_true=NO)? cycle_val=CYCLE
        | OWNED BY (col_name=schema_qualified_name | NONE)
    ;
    
create_schema_statement
    : SCHEMA (IF NOT EXISTS)? (name=schema_qualified_name)? (AUTHORIZATION user_name=identifier)? (schema_element+=sql)*
    ;
    
create_view_statement
    : (OR REPLACE)? (TEMP | TEMPORARY)? VIEW name=schema_qualified_name (column_name+=schema_qualified_name (COMMA column_name+=schema_qualified_name)*)?
    (WITH LEFT_PAREN (view_option_name=identifier (EQUAL view_option_value=identifier)?)+ RIGHT_PAREN)?
    AS v_query=query_expression
    ;
    
create_table_statement
  : ((GLOBAL | LOCAL)? (TEMPORARY | TEMP) | UNLOGGED)? TABLE (IF NOT EXISTS)? name=schema_qualified_name 
        (OF type_name=identifier)? 
        LEFT_PAREN (table_col_def+=table_column_def (COMMA table_col_def+=table_column_def)*)? RIGHT_PAREN
        (INHERITS 
            LEFT_PAREN 
                (paret_table+=schema_qualified_name(COMMA)?)+ 
            RIGHT_PAREN
        )?
        storage_parameter_oid?
        on_commit?
        table_space?
  ;

table_column_def
    : table_column_definition
       | tabl_constraint=constraint_common
       | LIKE parent_table=schema_qualified_name (like_opt+=like_option)*
    ;

table_column_definition
    : column_name=identifier (datatype=data_type)? (COLLATE collation=identifier)? (WITH OPTIONS)? (colmn_constraint+=constraint_common)*
    ;
  
like_option
    : (INCLUDING | EXCLUDING) (DEFAULTS | CONSTRAINTS | INDEXES | STORAGE | COMMENTS | ALL)
    ;
/** NULL, DEFAULT - column constraint
* EXCLUDE, FOREIGN KEY - table_constraint
*/
constraint_common
    : (CONSTRAINT constraint_name=identifier)?
      ((EXCLUDE (USING index_method=identifier)? 
            LEFT_PAREN exclude_element=identifier WITH operator+=identifier(COMMA operator+=identifier)* RIGHT_PAREN 
            index_parameters (WHERE LEFT_PAREN predicat=identifier RIGHT_PAREN)?) 
       | (FOREIGN KEY column_references)? table_references
       | common_constraint
       | null_false=NOT? null_value=NULL
       | DEFAULT (default_expr_data=data_type | default_expr=value_expression)
      )
      table_deferrable? table_initialy_immed?
    ;

common_constraint
    :check_boolean_expression 
    | table_unique
    | table_primary_key
    ;

table_unique
    : UNIQUE column_references? index_parameters_unique=index_parameters
    ;
table_primary_key
    : PRIMARY KEY column_references? index_parameters_pr_key=index_parameters
    ;

table_references
    : REFERENCES reftable=schema_qualified_name column_references?
            (match_all | (ON DELETE action_on_delete=action) | (ON UPDATE action_on_update=action))*
    ;

column_references
    :LEFT_PAREN name+=schema_qualified_name(COMMA name+=schema_qualified_name)* RIGHT_PAREN
    ;

match_all
    : MATCH (FULL | PARTIAL | SIMPLE)
    ;

check_boolean_expression
    : CHECK LEFT_PAREN expression=boolean_value_expression RIGHT_PAREN
    ;
    
storage_parameter
    : LEFT_PAREN
        (storage_param=identifier (EQUAL value=value_expression)?(COMMA)?)+ 
      RIGHT_PAREN 
    ;
    
with_storage_parameter
    : WITH storage_parameter
    ;
    
storage_parameter_oid
    : with_storage_parameter | (WITH OIDS) | (WITHOUT OIDS)
    ;

on_commit
    : ON COMMIT ((PRESERVE ROWS) | (DELETE ROWS) | DROP)
    ;
    
table_space
    :TABLESPACE name=schema_qualified_name
    ;
    
action
    : (RESTRICT | CASCADE) 
      | SET (NULL | DEFAULT)
    ;
    
index_parameters
    : (with_storage_parameter)? (USING INDEX table_space)?
    ;
    
table_elements
  : LEFT_PAREN field_element (COMMA field_element)* RIGHT_PAREN
  ;

owner_to
    : OWNER TO name=identifier
    ;

rename_to
    : RENAME TO name=schema_qualified_name
    ;

set_schema
    : SET schema_with_name
    ;

schema_with_name
    : SCHEMA name=schema_qualified_name
    ;

common_query_list
    : SELECT | INSERT | UPDATE | DELETE | TRUNCATE | REFERENCES | TRIGGER
    ;

usage_select_update
    : USAGE | SELECT | UPDATE
    ;
create_connect_temporary_temp
    :CREATE | CONNECT | TEMPORARY | TEMP
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
  : key=identifier EQUAL value=numeric_value_expression
  ;

//method_specifier
//  : USING m=identifier
//  ;

//table_space_specifier
//  : TABLESPACE table_space_name
//  ;

//table_space_name
//  : identifier
//  ;

//table_partitioning_clauses
//  : range_partitions
//  | hash_partitions
//  | list_partitions
//  | column_partitions
//  ;

//range_partitions
//  : PARTITION BY RANGE LEFT_PAREN column_reference_list RIGHT_PAREN
//    LEFT_PAREN range_value_clause_list RIGHT_PAREN
//  ;

//range_value_clause_list
//  : range_value_clause (COMMA range_value_clause)*
//  ;

//range_value_clause
//  : PARTITION partition_name VALUES LESS THAN (LEFT_PAREN value_expression RIGHT_PAREN | LEFT_PAREN? MAXVALUE RIGHT_PAREN?)
//  ;

//hash_partitions
//  : PARTITION BY HASH LEFT_PAREN column_reference_list RIGHT_PAREN
//    (LEFT_PAREN individual_hash_partitions RIGHT_PAREN | hash_partitions_by_quantity)
//  ;

//individual_hash_partitions
//  : individual_hash_partition (COMMA individual_hash_partition)*
//  ;

//individual_hash_partition
//  : PARTITION partition_name
//  ;

//hash_partitions_by_quantity
//  : PARTITIONS quantity = numeric_value_expression
//  ;

//list_partitions
//  : PARTITION BY LIST LEFT_PAREN column_reference_list RIGHT_PAREN LEFT_PAREN  list_value_clause_list RIGHT_PAREN
//  ;

//list_value_clause_list
//  : list_value_partition (COMMA list_value_partition)*
//  ;

//list_value_partition
//  : PARTITION partition_name VALUES (IN)? LEFT_PAREN in_value_list RIGHT_PAREN
//  ;

//column_partitions
//  : PARTITION BY COLUMN table_elements
//  ;

partition_by_columns
    : PARTITION BY schema_qualified_name (COMMA schema_qualified_name)*
    ;

//partition_name
//  : identifier
//  ;

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
  : (Identifier
  | QuotedIdentifier)
  | (DOUBLE_QUOTE)? nonreserved_keywords (DOUBLE_QUOTE)? 
  ;

nonreserved_keywords
  : ADMIN
  | ALWAYS
  | ARRAY
  | AVG
  | BETWEEN
  | BY
  | CACHE
  | CALLED
  | CENTURY
  | CHARACTER
  | CHECK
  | CLASS
  | CLUSTER
  | COALESCE
  | COLLECT
  | COLUMN
  | COMMENT
  | COMMENTS
  | COMMIT
  | CONCURRENTLY
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
  | DISABLE
  | DOW
  | DOY
  | DROP
  | ENABLE
  | EPOCH
  | EVENT
  | EVERY
  | EXISTS
  | EXTENDED
  | EXTERNAL
  | EXTRACT
  | FAMILY
  | FILTER
  | FIRST
  | FORMAT
  | FUSION
  | GROUPING
  | HASH
  | INHERIT
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
  | MAIN
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
  | ON
  | ONLY
  | OPTION
  | OPTIONS
  | OVER
  | OVERWRITE
  | PARSER
  | PARTIAL
  | PARTITION
  | PARTITIONS
  | PLAIN
  | PRECISION
  | PUBLIC
  | PURGE
  | QUARTER
  | RANGE
  | REGCONFIG
  | REGEXP
  | RENAME
  | REPLACE
  | REPLICA
  | RESET
  | RESTART
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
  | STATISTICS
  | STDIN
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
  | TYPE
  | TYPES
  | UNKNOWN
  | UNLOGGED
  | USER
  | VALID
  | VALIDATE
  | VALUES
  | VAR_POP
  | VAR_SAMP
  | VARYING
  | VERSION
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
  | INET
  | INT
  | INT1
  | INT2
  | INT4
  | INT8
  | INTEGER
  | INTERVAL
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
  | UUID
  | VOID
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
  | truth_value
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

//boolean_literal
//  : TRUE | FALSE | UNKNOWN
//  ;

/*
===============================================================================
  6.1 <data types>
===============================================================================
*/

data_type
  : predefined_type (LEFT_BRACKET RIGHT_BRACKET)?
  | SETOF value=identifier
  ;

predefined_type
  : character_string_type
  | binary_large_object_string_type
  | numeric_type
  | boolean_type
  | datetime_type
  | bit_type
  | binary_type
  | network_type
  | (REGCLASS
  | REGCONFIG
  | TRIGGER
  | UUID
  | VOID
  | INET)
  | schema_qualified_name
  ;
    
network_type
  : INET4
  ;

character_string_type
  : NATIONAL? CHARACTER VARYING? type_length?
  | NATIONAL? CHAR VARYING? type_length?
  | NCHAR VARYING? type_length?
  | NVARCHAR type_length?
  | VARCHAR type_length?
  | (TEXT | INTERVAL)
  ;

type_length
  : LEFT_PAREN NUMBER RIGHT_PAREN
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
  | (INT1
  | TINYINT
  | INT2
  | SMALLINT
  | INT4
  | INT
  | INTEGER
  | INT8
  | BIGINT)
  ;

approximate_numeric_type
  : FLOAT (precision_param)?
  | (FLOAT4
  | REAL
  | FLOAT8)
  | DOUBLE (PRECISION)?
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
  : (DATE
  | TIME (WITH TIME ZONE)?
  | TIMETZ
  | TIMESTAMP ((WITH | WITHOUT) TIME ZONE)?
  | TIMESTAMPTZ)
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
  | set_function_specification
  | scalar_subquery
  | case_expression
  | cast_specification
  | function_parameters
  | NULL
  | all_array
  | case_abbreviation
  | schema_qualified_name
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
  : FILTER LEFT_PAREN where_clause RIGHT_PAREN
  ;

//grouping_operation
//  : GROUPING LEFT_PAREN column_reference_list RIGHT_PAREN
//  ;

/*
===============================================================================
  6.11 <case expression>
===============================================================================
*/

case_expression
  : case_specification
  ;

case_abbreviation
  : NULLIF LEFT_PAREN numeric_value_expression COMMA value_expression  RIGHT_PAREN
  | COALESCE LEFT_PAREN numeric_value_expression (COMMA value_expression)+ RIGHT_PAREN
  ;

case_specification
  : CASE value_expression? simple_when_clause+ else_clause? END
  ;

simple_when_clause: WHEN c=value_expression THEN r=value_expression ;

else_clause
  : ELSE r=value_expression
  ;

/*
===============================================================================
  6.12 <cast specification>
===============================================================================
*/

cast_specification
  : CAST LEFT_PAREN value_expression AS data_type RIGHT_PAREN
  ;

/*
===============================================================================
  6.25 <value expression>
===============================================================================
*/
value_expression
  : common_value_expression
  | boolean_value_expression
  | array_expression
  ;

array_expression
    : ARRAY LEFT_BRACKET value_expression (COMMA value_expression)* RIGHT_BRACKET
    ;

all_array
    : ALL LEFT_PAREN array_expression RIGHT_PAREN
    ;
  
bit_operation
    : character_value_expression BIT_AND character_value_expression
    ;
common_value_expression
  : numeric_value_expression
  | string_value_expression
  | bit_operation
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
  : value_expression_primary_cast
  | numeric_value_function
  ;

value_expression_primary_cast
    : value_expression_primary (CAST_EXPRESSION data_type)*
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
  : schema_qualified_name
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
  : value_expression_primary_cast
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
row_value_predicand
  : nonparenthesized_value_expression_primary
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
  : FROM (LEFT_PAREN from_clause RIGHT_PAREN
         | (table_reference_list | query_expression)) as_clause?
  ;

table_reference_list
  : table_reference (COMMA table_reference)*
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
  : cross_join
  | qualified_join
  | natural_join
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

join_type
  : INNER
  | t=outer_join_type
  ;

outer_join_type
  :  (LEFT | RIGHT | FULL) OUTER?
  ;

join_specification
  : join_condition
  | named_columns_join
  ;

join_condition
  : ON value_expression
  ;

named_columns_join
  : USING LEFT_PAREN f=column_reference_list RIGHT_PAREN
  ;

table_primary
  : (alias_table | schema_qualified_name) ((AS)? alias=alias_def)? (LEFT_PAREN column_name_list RIGHT_PAREN)?
  | derived_table (AS)? name=identifier (LEFT_PAREN column_name_list RIGHT_PAREN)?
  | LEFT_PAREN table_reference RIGHT_PAREN
  ;

column_name_list
  :  identifier ( COMMA identifier  )*
  ;

alias_def
    : schema_qualified_name 
    | alias_table
    ;

alias_table
    : schema_qualified_name LEFT_PAREN (identifier (COMMA identifier)*)? RIGHT_PAREN
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
  : WHERE value_expression
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
  : TABLE schema_qualified_name
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
  : value_expression (over_clause | as_clause)*
  ;

qualified_asterisk
  : (tb_name=Identifier DOT)? MULTIPLY
  ;

set_qualifier
  : DISTINCT
  | ALL
  ;

as_clause
  : (AS)? identifier
  ;

over_clause
    : OVER LEFT_PAREN (partition_by_columns | orderby_clause | order_specification)* RIGHT_PAREN
    ;

column_reference_list
  : schema_qualified_name (COMMA schema_qualified_name)*
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
  : nonparenthesized_value_expression_primary  ( COMMA nonparenthesized_value_expression_primary )*
  ;

/*
===============================================================================
  8.5, 8.6 <pattern matching predicate>

  Specify a pattern-matching comparison.
===============================================================================
*/

pattern_matching_predicate
  : f=row_value_predicand pattern_matcher value_expression_primary_cast
  ;

pattern_matcher
  : NOT? negativable_matcher
  | regex_matcher+
  ;

negativable_matcher
  : (LIKE
  | ILIKE
  | REGEXP
  | RLIKE)
  | SIMILAR TO
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

//routine_invocation
//  : function_name LEFT_PAREN sql_argument_list? RIGHT_PAREN
//  ;

//function_names_for_reserved_words
//  : LEFT
//  | RIGHT
//  ;

//function_name
//  : schema_qualified_name
//  | function_names_for_reserved_words
//  ;

//sql_argument_list
//  : value_expression (COMMA value_expression)*
//  ;

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

///*
//===============================================================================
//  14.8 <insert statement>
//===============================================================================
//*/
//
//insert_statement
//  : INSERT (OVERWRITE)? INTO schema_qualified_name (LEFT_PAREN column_name_list RIGHT_PAREN)? query_expression
//  | INSERT (OVERWRITE)? INTO LOCATION path=Character_String_Literal (USING file_type=identifier (param_clause)?)? query_expression
//  ;
