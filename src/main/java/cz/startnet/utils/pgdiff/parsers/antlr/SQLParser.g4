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
    package cz.startnet.utils.pgdiff.parsers.antlr;
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
  | script_statement
  ;

data_statement
  : query_expression 
  | copy_statement
  ;

  script_statement
  : START TRANSACTION transaction_mode*
  | COMMIT (WORK | TRANSACTION)?
  ;

  transaction_mode
  : ISOLATION LEVEL (SERIALIZABLE | REPEATABLE READ | READ COMMITTED | READ UNCOMMITTED)
  | READ WRITE | READ ONLY
  | (NOT)? DEFERRABLE
  ;

copy_statement
    : COPY (table_name=schema_qualified_name column_references? 
           | ( query=query_expression ))
        (FROM | TO) (filename=identifier | STDIN)
        (WITH? LEFT_PAREN option=copy_option(COMMA option=copy_option)* RIGHT_PAREN)?
    ;
copy_option:
    FORMAT format_name=identifier
    | OIDS (boolean_val=truth_value)?
    | DELIMITER delimiter_character=identifier
    | NULL null_string=identifier
    | HEADER (boolean_val=truth_value)?
    | QUOTE quote_character=identifier
    | ESCAPE escape_character=identifier
    | FORCE_QUOTE (column_references | MULTIPLY)
    | FORCE_NOT_NULL column_references
    | ENCODING encoding_name=identifier
    ;
//data_change_statement
//  : insert_statement
//  ;

schema_statement
  : schema_create
    | schema_alter
    | schema_drop
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
    | create_event_trigger
    | create_type_statement
    | create_domain_statement)
     
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
    | alter_view_statement
    | alter_type_statement
    | alter_domain_statement)
    ;

schema_drop
    : DROP (drop_function_statement 
    | drop_trigger_statement 
    | drop_statements)
    ;
    
alter_function_statement
    : FUNCTION function_parameters 
      ((function_actions_common | RESET (configuration_parameter=identifier | ALL))+ RESTRICT?
    | rename_to
    | owner_to
    | set_schema)
    ;
    
alter_schema_statement
    : schema_with_name (rename_to | owner_to)
    ;

alter_language_statement
    : PROCEDURAL? LANGUAGE name=identifier (rename_to | owner_to)
    ;

alter_table_statement
    : TABLE ONLY? name=schema_qualified_name MULTIPLY?(
        (table_action (COMMA table_action)*
        | RENAME COLUMN? column=schema_qualified_name TO new_column=schema_qualified_name)
    | set_schema
    | rename_to)
    ;

table_action
    : ADD COLUMN? table_column_definition
    | DROP COLUMN? (IF EXISTS)? column=schema_qualified_name cascade_restrict?
    | ALTER COLUMN? column=schema_qualified_name 
      ((SET DATA)? TYPE datatype=data_type collate_identifier? (USING expression=value_expression)?
      | (set_def_column
        | drop_def
        | ((SET | DROP) NOT NULL) 
        | SET STATISTICS integer=NUMBER
        | SET LEFT_PAREN attribute_option_value (COMMA attribute_option_value)* RIGHT_PAREN
        | RESET LEFT_PAREN attribute_option+=table_attribute_option (COMMA attribute_option+=table_attribute_option)* RIGHT_PAREN
        | SET STORAGE (PLAIN | EXTERNAL | EXTENDED | MAIN)))
    | ADD tabl_constraint=constraint_common (NOT VALID)?
    | ADD tabl_constraint_using_index=table_constraint_using_index
    | validate_constraint
    | drop_constraint
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

validate_constraint
    : VALIDATE CONSTRAINT constraint_name=schema_qualified_name
    ;

drop_constraint
    : DROP CONSTRAINT (IF EXISTS)?  constraint_name=schema_qualified_name cascade_restrict?
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
    : (GRANT | REVOKE grant_option_for?) (
      (( common_query_list (COMMA common_query_list)*)
        | ALL PRIVILEGES?)
        ON TABLES

    | ((usage_select_update(COMMA usage_select_update)*)
        | ALL PRIVILEGES?)
        ON SEQUENCES

    | (EXECUTE | ALL PRIVILEGES?)
        ON FUNCTIONS

    | (USAGE | ALL PRIVILEGES?)
        ON TYPES)
        (grant_to_rule | revoke_from_cascade_restrict)
    ;

grant_option_for
    : GRANT OPTION FOR
    ;

alter_sequence_statement
    : SEQUENCE (IF EXISTS)? name=schema_qualified_name 
     ( (sequence_body | RESTART (WITH? restart=identifier)?)*
    | set_schema
    | owner_to
    | rename_to)
    ;

alter_view_statement
    : VIEW (IF EXISTS)? name=schema_qualified_name 
     (ALTER COLUMN? column_name=schema_qualified_name  (set_def_column | drop_def)
    | set_schema
    | owner_to
    | rename_to
    | SET LEFT_PAREN view_option_name=identifier (EQUAL view_option_value=value_expression)?(COMMA view_option_name=identifier (EQUAL view_option_value=value_expression)?)*  RIGHT_PAREN
    | RESET LEFT_PAREN view_option_name=identifier (COMMA view_option_name=identifier)*  RIGHT_PAREN)
    ;

alter_type_statement
    : TYPE name=schema_qualified_name 
      (set_schema 
      | owner_to 
      | rename_to
      | ADD VALUE (IF NOT EXISTS)? new_enum_value=Character_String_Literal ((BEFORE | AFTER) existing_enum_value=Character_String_Literal)?
      | RENAME ATTRIBUTE attribute_name=identifier TO new_attribute_name=identifier cascade_restrict?
      | type_action (COMMA type_action)*)
    ;

alter_domain_statement
    : DOMAIN name=schema_qualified_name
    (set_def_column
    | drop_def
    | (SET | DROP) NOT NULL
    | ADD dom_constraint=domain_constraint (NOT not_valid=VALID)?
    | drop_constraint
    | RENAME CONSTRAINT dom_old_constraint=schema_qualified_name TO dom_new_constraint=schema_qualified_name
    | validate_constraint
    | owner_to
    | rename_to
    | set_schema)
    ;

type_action
    :ADD ATTRIBUTE attribute_name=identifier data_type collate_identifier? cascade_restrict?
    | DROP ATTRIBUTE (IF EXISTS)? attribute_name=identifier cascade_restrict?
    | ALTER ATTRIBUTE attribute_name=identifier (SET DATA)? TYPE data_type collate_identifier? cascade_restrict?
    ;

set_def_column
    : SET DEFAULT expression=value_expression
    ;

drop_def
    : DROP DEFAULT
    ;

index_statement
  : unique_value=UNIQUE? INDEX CONCURRENTLY? name=schema_qualified_name? ON table_name=schema_qualified_name 
    using_def
  ;
using_def
    :(USING method=schema_qualified_name)?
    LEFT_PAREN sort_specifier_list RIGHT_PAREN param_clause?
    table_space? where_clause?
    ;
  
 create_extension_statement
    : EXTENSION (IF NOT EXISTS)? name=schema_qualified_name WITH?
         schema_with_name? (VERSION version=unsigned_value_specification)? (FROM old_version=unsigned_value_specification)?
    ;
    
create_language_statement
    : (OR REPLACE)? TRUSTED? PROCEDURAL? LANGUAGE name=identifier
        (HANDLER call_handler=schema_qualified_name (INLINE inline_handler=schema_qualified_name)? (VALIDATOR valfunction=schema_qualified_name)?)?
    ;

create_event_trigger
    : EVENT TRIGGER name=schema_qualified_name ON event=schema_qualified_name
        (WHEN filter_variable=schema_qualified_name (IN 
            LEFT_PAREN 
                filter_value+=Character_String_Literal(COMMA filter_value+=Character_String_Literal)* 
            RIGHT_PAREN AND?)+ )?
        EXECUTE PROCEDURE funct_name=value_expression
    ;

create_type_statement
    :TYPE name=schema_qualified_name (AS(
        LEFT_PAREN (attrs+=table_column_definition (COMMA attrs+=table_column_definition)*)? RIGHT_PAREN
        | ENUM LEFT_PAREN ( enums+=Character_String_Literal (COMMA enums+=Character_String_Literal)* )? RIGHT_PAREN
        | RANGE LEFT_PAREN 
                (SUBTYPE EQUAL subtype_name=data_type
                | SUBTYPE_OPCLASS EQUAL subtype_operator_class=identifier
                | COLLATION EQUAL collation=schema_qualified_name
                | CANONICAL EQUAL canonical_function=schema_qualified_name
                | SUBTYPE_DIFF EQUAL subtype_diff_function=schema_qualified_name)? 
                (COMMA (SUBTYPE EQUAL subtype_name=data_type
                | SUBTYPE_OPCLASS EQUAL subtype_operator_class=identifier
                | COLLATION EQUAL collation=schema_qualified_name
                | CANONICAL EQUAL canonical_function=schema_qualified_name
                | SUBTYPE_DIFF EQUAL subtype_diff_function=schema_qualified_name))*
            RIGHT_PAREN)
    | LEFT_PAREN
            INPUT EQUAL input_function=schema_qualified_name COMMA
            OUTPUT EQUAL output_function=schema_qualified_name
            (COMMA (RECEIVE EQUAL receive_function=schema_qualified_name
            | SEND EQUAL send_function=schema_qualified_name
            | TYPMOD_IN EQUAL type_modifier_input_function=schema_qualified_name
            | TYPMOD_OUT EQUAL type_modifier_output_function=schema_qualified_name
            | ANALYZE EQUAL analyze_function=schema_qualified_name
            | INTERNALLENGTH EQUAL (internallength=signed_numerical_literal | VARIABLE )
            | PASSEDBYVALUE
            | ALIGNMENT EQUAL alignment=data_type
            | STORAGE EQUAL storage=identifier
            | LIKE EQUAL like_type=identifier
            | CATEGORY EQUAL category=Character_String_Literal
            | PREFERRED EQUAL preferred=truth_value
            | DEFAULT EQUAL default_value=Character_String_Literal
            | ELEMENT EQUAL element=identifier
            | DELIMITER EQUAL delimiter=Character_String_Literal
            | COLLATABLE EQUAL collatable=truth_value))*
        RIGHT_PAREN)?
    ;

create_domain_statement
    : DOMAIN name=schema_qualified_name (AS)? dat_type=data_type 
      (collate_identifier
      | DEFAULT def_value=value_expression
      | dom_constraint+=domain_constraint)*
    ;

domain_constraint
    :(CONSTRAINT name=schema_qualified_name)?
     common_constraint
    ;

set_statement
    : SET (SESSION | LOCAL)? 
      (config_param=identifier (TO |EQUAL) config_param_val+=set_statement_value (COMMA config_param_val+=set_statement_value)*
    | TIME ZONE (timezone=identifier | (LOCAL | DEFAULT))(COMMA (timezone=identifier | (LOCAL | DEFAULT)))*)
    ;

set_statement_value
    : value=value_expression | DEFAULT
    ;
   
create_trigger_statement
    : CONSTRAINT? TRIGGER name=schema_qualified_name (before_true=BEFORE | (INSTEAD OF) | AFTER)
    (((insert_true=INSERT | delete_true=DELETE | truncate_true=TRUNCATE) | update_true=UPDATE (OF names_references )?)OR?)+
    ON tabl_name=schema_qualified_name 
    (FROM referenced_table_name=schema_qualified_name)?
    table_deferrable? table_initialy_immed?
    (for_each_true=FOR EACH? (ROW | STATEMENT))?
    (WHEN (when_expr=value_expression))?
    EXECUTE PROCEDURE func_name=function_parameters
    ;
    
rule_common
    : (GRANT | REVOKE grant_opt_for=grant_option_for?)
      body_rule=body_rules
    ;

body_rules
    :(on_table 
    | on_column 
    | on_sequence
    | on_database
    | on_datawrapper_server_lang
    | on_function
    | on_large_object
    | on_schema
    | on_tablespace
    | on_type
    | on_domain)
    (grant_to_rule | revoke_from_cascade_restrict)
    | GRANT obj_name=names_references TO role_name=names_references (WITH ADMIN OPTION)?
    | REVOKE (ADMIN OPTION FOR)? obj_name=names_references FROM role_name=names_references
      cascade_restrict?
    ;
    
grant_to_rule
    : TO roles_names (WITH GRANT OPTION)?
    ;
    
revoke_from_cascade_restrict
    : FROM roles_names cascade_restrict?
    ;

on_table
    : (common_query_list (COMMA common_query_list)* | ALL PRIVILEGES?) 
        ON ( (TABLE? obj_name=names_references)
             | ALL TABLES IN SCHEMA (schema_name+=identifier)+)
    ;

on_column
    : (((SELECT | INSERT | UPDATE | REFERENCES) LEFT_PAREN column+=identifier (COMMA column+=identifier)* RIGHT_PAREN)+
         | ALL PRIVILEGES? LEFT_PAREN column+=identifier (COMMA column+=identifier)* RIGHT_PAREN )
        ON TABLE? obj_name=names_references
    ;

on_sequence
    : (usage_select_update(COMMA usage_select_update)*
        | ALL PRIVILEGES?)
        ON (SEQUENCE obj_name=names_references
             | ALL SEQUENCES IN SCHEMA schema_name+=identifier (COMMA schema_name+=identifier)*)
    ;

on_database
    : (create_connect_temporary_temp(COMMA create_connect_temporary_temp)* | ALL PRIVILEGES? )
        ON DATABASE obj_name=names_references
    ;

on_datawrapper_server_lang
    : (USAGE | ALL PRIVILEGES?)
        ON (FOREIGN (DATA WRAPPER | SERVER) | LANGUAGE) obj_name=names_references
    ;

on_function
    : (EXECUTE | ALL PRIVILEGES?) 
        ON (FUNCTION obj_name+=function_parameters (COMMA obj_name+=function_parameters)*
           | ALL FUNCTIONS IN SCHEMA schema_name=names_references)
    ;

on_large_object
    : ((SELECT | UPDATE COMMA?)+  | ALL PRIVILEGES?) 
        ON LARGE OBJECT obj_name=names_references
    ;
on_schema
    : (((CREATE | USAGE) COMMA?)+ | ALL PRIVILEGES?) 
        ON SCHEMA obj_name=names_references
    ;
    
on_tablespace
    : (CREATE | ALL PRIVILEGES?)
        ON TABLESPACE obj_name=names_references
    ;

on_type
    : (USAGE | ALL PRIVILEGES?)
        ON TYPE obj_name=names_references 
    ;

on_domain
    : (USAGE | ALL PRIVILEGES?)
        ON DOMAIN obj_name=names_references
    ;

roles_names
    :(GROUP? role_name+=identifier | PUBLIC)(COMMA (GROUP? role_name+=identifier | PUBLIC))*
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
        | PROCEDURAL? LANGUAGE 
        | LARGE OBJECT 
        | FOREIGN (DATA WRAPPER | TABLE)
        | (COLUMN | CONVERSION | DATABASE| DOMAIN| EXTENSION| INDEX | ROLE 
            | COLLATION| SCHEMA| SEQUENCE| SERVER| TABLE | TABLESPACE 
            | TYPE | VIEW)
          ) name=schema_qualified_name
        ) IS (comment_text=Character_String_Literal | NULL)
    ;

/*
===============================================================================
  Function Definition
===============================================================================
*/
create_function_statement
    : (OR REPLACE)? FUNCTION function_parameters
        (RETURNS (rettype=value_expression_primary_cast | rettype_data=data_type | ret_table=function_ret_table))?
          funct_body=create_funct_params
    ;

create_funct_params
    :(LANGUAGE lang_name=identifier
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
    : name=schema_qualified_name function_args
    ;

function_args
    : LEFT_PAREN (function_arguments (COMMA function_arguments)*)? RIGHT_PAREN
    ;

function_body
    : BeginDollarStringConstant Text_between_Dollar+ EndDollarStringConstant
    ;

function_arguments
    :arg_mode=argmode? argname=identifier? (argtype_data=data_type | argtype_expres=value_expression_primary_cast) function_def_value?
    ;

function_def_value
    : (DEFAULT | EQUAL) def_value=value_expression
    ;

function_attribute
    : ISSTRICT | ISCACHABLE
    ;
        
argmode
    : IN | OUT | INOUT | VARIADIC
    ;
    
create_sequence_statement
    : (TEMPORARY | TEMP)? SEQUENCE name=schema_qualified_name (sequence_body)*
    ;

sequence_body
    : INCREMENT BY? incr=NUMBER
        | (MINVALUE minval=signed_numerical_literal | NO MINVALUE) 
        | (MAXVALUE maxval=signed_numerical_literal | NO MAXVALUE)
        | START WITH? start_val=signed_numerical_literal
        | CACHE cache_val=signed_numerical_literal
        | cycle_true=NO? cycle_val=CYCLE
        | OWNED BY (col_name=schema_qualified_name | NONE)
    ;
    
create_schema_statement
    : SCHEMA (IF NOT EXISTS)? name=schema_qualified_name? (AUTHORIZATION user_name=identifier)? (schema_element+=statement)*
    ;
    
create_view_statement
    : (OR REPLACE)? (TEMP | TEMPORARY)? VIEW name=schema_qualified_name column_name=column_references?
        (WITH LEFT_PAREN (view_option_name+=identifier (EQUAL view_option_value+=identifier)?)+ RIGHT_PAREN)?
        AS v_query=query_expression
    ;
    
create_table_statement
  : ((GLOBAL | LOCAL)? (TEMPORARY | TEMP) | UNLOGGED)? TABLE (IF NOT EXISTS)? name=schema_qualified_name 
        (OF type_name=identifier)? 
        LEFT_PAREN (table_col_def+=table_column_def (COMMA table_col_def+=table_column_def)*)? RIGHT_PAREN
        (INHERITS paret_table= column_references)?
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
    : column_name=identifier datatype=data_type? collate_identifier? (WITH OPTIONS)? (colmn_constraint+=constraint_common)*
    ;
  
like_option
    : (INCLUDING | EXCLUDING) (DEFAULTS | CONSTRAINTS | INDEXES | STORAGE | COMMENTS | ALL)
    ;
/** NULL, DEFAULT - column constraint
* EXCLUDE, FOREIGN KEY - table_constraint
*/
constraint_common
    : (CONSTRAINT constraint_name=identifier)?
      constr_body
    ;

constr_body
    :((EXCLUDE (USING index_method=identifier)? 
            LEFT_PAREN exclude_element=identifier WITH operator=names_references RIGHT_PAREN 
            index_parameters where_clause?) 
       | (FOREIGN KEY column_references)? table_references
       | common_constraint
       | table_unique_prkey
       | DEFAULT (default_expr_data=data_type | default_expr=value_expression)
      )
      table_deferrable? table_initialy_immed?
    ;

common_constraint
    :check_boolean_expression 
    | null_false=NOT? null_value=NULL
    ;

table_unique_prkey
    : (UNIQUE | PRIMARY KEY) column_references? index_parameters_unique=index_parameters
    ;

table_references
    : REFERENCES reftable=schema_qualified_name column_references?
            (match_all | (ON DELETE action_on_delete=action) | (ON UPDATE action_on_update=action))*
    ;

column_references
    :LEFT_PAREN names_references RIGHT_PAREN
    ;
names_references
    : name+=schema_qualified_name(COMMA name+=schema_qualified_name)*
    ;

match_all
    : MATCH (FULL | PARTIAL | SIMPLE)
    ;

check_boolean_expression
    : CHECK LEFT_PAREN expression=value_expression RIGHT_PAREN
    ;
    
storage_parameter
    : LEFT_PAREN
        storage_param=identifier (EQUAL value=value_expression)? 
        (COMMA storage_param=identifier (EQUAL value=value_expression)?)*
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
    : cascade_restrict
      | SET (NULL | DEFAULT)
    ;
    
index_parameters
    : with_storage_parameter? (USING INDEX table_space)?
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
  : name=identifier data_type
  ;

param_clause
  : WITH LEFT_PAREN param (COMMA param)* RIGHT_PAREN
  ;

param
  : key=identifier EQUAL value=numeric_value_expression
  ;

partition_by_columns
    : PARTITION BY names_references
    ;

cascade_restrict
    : CASCADE | RESTRICT
    ;

collate_identifier
    : COLLATE collation=schema_qualified_name
    ;

/*
===============================================================================
  11.21 <data types>
===============================================================================
*/

drop_function_statement
    : FUNCTION (IF EXISTS)? function_parameters cascade_restrict?
    ;

drop_trigger_statement
    : TRIGGER (IF EXISTS)? name=schema_qualified_name ON schema_qualified_name cascade_restrict?
    ;

drop_statements
    :((DATABASE | DOMAIN | TABLE| EXTENSION | SCHEMA | SEQUENCE | VIEW | TYPE) | INDEX (CONCURRENTLY)?) if_exist_names_restrict_cascade
    ;

if_exist_names_restrict_cascade
    : (IF EXISTS)? names_references cascade_restrict?
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
  | DOUBLE_QUOTE? nonreserved_keywords DOUBLE_QUOTE? 
  ;

nonreserved_keywords
  : ADD
  | ADMIN
  | ALWAYS
  | ARRAY
  | ATTRIBUTE
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
  | COMMITTED
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
  | ISOLATION
  | ISOYEAR
  | ISSTRICT
  | KEY
  | LANGUAGE
  | LARGE
  | LAST
  | LESS
  | LEVEL
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
  | OPERATOR
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
  | READ
  | REGCONFIG
  | REGEXP
  | RENAME
  | REPEATABLE
  | REPLACE
  | REPLICA
  | RESET
  | RESTART
  | RLIKE
  | ROLLUP
  | SCHEMA
  | SEARCH
  | SECOND
  | SECURITY
  | SERIALIZABLE
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
  | TRANSACTION
  | TRIM
  | TO
  | TYPE
  | TYPES
  | UNCOMMITTED
  | UNKNOWN
  | UNLOGGED
  | USER
  | VALID
  | VALIDATE
  | VALUE
  | VALUES
  | VAR_POP
  | VAR_SAMP
  | VARYING
  | VERSION
  | VOLATILE
  | WEEK
  | WINDOW
  | WORK
  | WRAPPER
  | WRITE
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
  
  | SCHEMA
  ;

/*
===============================================================================
  5.3 <literal>
===============================================================================
*/

unsigned_value_specification
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

/*
===============================================================================
  6.1 <data types>
===============================================================================
*/

data_type
  : predefined_type (LEFT_BRACKET RIGHT_BRACKET)?
  | SETOF value=predefined_type
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
  : NATIONAL? (CHARACTER | CHAR) VARYING? type_length?
  | NCHAR VARYING? type_length?
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
  : NUMERIC precision_param?
  | DECIMAL precision_param?
  | DEC precision_param?
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
  : FLOAT precision_param?
  | (FLOAT4
  | REAL
  | FLOAT8)
  | DOUBLE PRECISION?
  ;

precision_param
  : LEFT_PAREN precision=NUMBER (COMMA scale=NUMBER)? RIGHT_PAREN
  ;

boolean_type
  : BOOLEAN
  | BOOL
  ;

datetime_type
  : DATE
  | TIME ((WITH | WITHOUT) TIME ZONE)?
  | TIMETZ
  | TIMESTAMP ((WITH | WITHOUT) TIME ZONE)?
  | TIMESTAMPTZ
  ;

bit_type
  : BIT VARYING? type_length?
  | VARBIT type_length?
  ;

binary_type
  : BINARY VARYING? type_length?
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
  | table_subquery
  | case_expression
  | cast_specification
  | NULL
  | all_array
  | case_abbreviation
  | name_or_func_calls
  | array_expression
  ;

name_or_func_calls
    :schema_qualified_name function_calls_paren?
    ;

function_calls_paren
    : LEFT_PAREN (function_calls_args (COMMA function_calls_args)*)? RIGHT_PAREN
    ;

function_calls_args
    : argname=identifier? argtype_expres=value_expression_primary_cast
    ;
/*
===============================================================================
  6.4 <unsigned value specification>
===============================================================================
*/

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
/*
===============================================================================
  6.11 <case expression>
===============================================================================
*/

case_expression
  : CASE value_expression_primary_cast? simple_when_clause+ else_clause? END
  ;

case_abbreviation
  : NULLIF LEFT_PAREN numeric_value_expression COMMA value_expression_primary_cast  RIGHT_PAREN
  | COALESCE LEFT_PAREN numeric_value_expression (COMMA value_expression_primary_cast)+ RIGHT_PAREN
  ;

simple_when_clause
    : WHEN c=value_expression_primary_cast THEN r=value_expression_primary_cast
    ;

else_clause
  : ELSE r=value_expression_primary_cast
  ;

/*
===============================================================================
  6.12 <cast specification>
===============================================================================
*/

cast_specification
  : CAST LEFT_PAREN value_expression_primary AS data_type RIGHT_PAREN
  ;

/*
===============================================================================
  6.25 <value expression>
===============================================================================
*/
value_expression
  : common_value_expression
  | boolean_value_expression
  ;

array_expression
    : ARRAY LEFT_BRACKET value_expression_primary_cast (COMMA value_expression_primary_cast)* RIGHT_BRACKET
    ;

all_array
    : ALL LEFT_PAREN array_expression RIGHT_PAREN
    ;
  
bit_operation
    : string_value_expression BIT_AND string_value_expression
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
  : left=term (sign right=term)*
  ;

term
  : left=factor ((MULTIPLY|DIVIDE|MODULAR) right=factor)*
  ;

factor
  : sign? numeric_primary
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
  : character_primary (CONCATENATION_OPERATOR character_primary)*
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
  : TRIM LEFT_PAREN trim_operands RIGHT_PAREN
  ;

trim_operands
  : ((trim_specification)? (trim_character=string_value_expression)? FROM)? trim_source=string_value_expression
  | trim_source=string_value_expression COMMA trim_character=string_value_expression
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
  : NOT? boolean_test
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
  | value_expression_primary
  ;

/*
===============================================================================
  7.2 <row value expression>
===============================================================================
*/

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
  : FROM table_reference (COMMA table_reference)*
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
  : t=join_type? JOIN r=table_primary s=join_specification
  ;

natural_join
  : NATURAL t=join_type? JOIN r=table_primary
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
  : ON boolean_value_expression
  ;

named_columns_join
  : USING column_references
  ;

table_primary
  : (name_or_func_calls | table_subquery) as_clause? column_references?
  ;

/*
===============================================================================
  7.8 <where clause>
===============================================================================
*/
where_clause
  : WHERE value_expression_primary_cast
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
  : value_expression_primary_cast
  | row_value_predicand_list
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
  : HAVING value_expression_primary_cast
  ;

row_value_predicand_list
  : LEFT_PAREN value_expression_primary_cast (COMMA value_expression_primary_cast)* RIGHT_PAREN
  ;

/*
===============================================================================
  7.13 <query expression>
===============================================================================
*/
query_expression
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
  : value_expression_primary_cast (over_clause | as_clause)*
  ;

qualified_asterisk
  : (tb_name=schema_qualified_name DOT)? MULTIPLY
  ;

set_qualifier
  : DISTINCT | ALL
  ;

as_clause
  : AS? identifier
  ;

over_clause
    : OVER LEFT_PAREN (partition_by_columns | orderby_clause | order_specification)* RIGHT_PAREN
    ;

/*
==============================================================================================
  7.15 <subquery>

  Specify a scalar value, a row, or a table derived from a query_expression .
==============================================================================================
*/

table_subquery
  : LEFT_PAREN query_expression RIGHT_PAREN
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
  : left=value_expression_primary_cast c=comp_op right=value_expression_primary_cast
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
  : predicand=value_expression_primary_cast between_predicate_part_2
  ;

between_predicate_part_2
  : NOT? BETWEEN (ASYMMETRIC | SYMMETRIC)? begin=value_expression_primary_cast AND end=value_expression_primary_cast
  ;


/*
===============================================================================
  8.4 <in predicate>
===============================================================================
*/

in_predicate
  : predicand=value_expression_primary_cast  NOT? IN in_predicate_value
  ;

in_predicate_value
  : table_subquery
  | row_value_predicand_list
  ;

/*
===============================================================================
  8.5, 8.6 <pattern matching predicate>

  Specify a pattern-matching comparison.
===============================================================================
*/

pattern_matching_predicate
  : f=value_expression_primary_cast pattern_matcher value_expression_primary_cast
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
  : predicand=value_expression_primary_cast IS n=NOT? NULL
  ;

/*
==============================================================================================
  8.8 <quantified comparison predicate>

  Specify a quantified comparison.
==============================================================================================
*/
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

/*
===============================================================================
  10.1 <interval qualifier>

  Specify the precision of an interval data type.
===============================================================================
*/

primary_datetime_field
    :YEAR | MONTH | DAY | HOUR | MINUTE | SECOND
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
  : key=value_expression_primary_cast order=order_specification? null_order=null_ordering?
  ;

order_specification
  : ASC
  | DESC
  ;

limit_clause
  : LIMIT e=value_expression_primary_cast
  ;

null_ordering
  : NULLS (FIRST | LAST)
  ;

/*
===============================================================================
  14.8 <insert statement>
===============================================================================
*/
//
//insert_statement
//  : INSERT (OVERWRITE)? INTO schema_qualified_name (LEFT_PAREN column_name_list RIGHT_PAREN)? query_expression
//  | INSERT (OVERWRITE)? INTO LOCATION path=Character_String_Literal (USING file_type=identifier (param_clause)?)? query_expression
//  ;
