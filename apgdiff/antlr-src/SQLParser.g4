parser grammar SQLParser;

options {
    language=Java;
    tokenVocab=SQLLexer;
}

@header {package cz.startnet.utils.pgdiff.parsers.antlr;}

// для запуска парсинга рекомендуется использовать только правила с EOF
// это исключает неоднозначные варианты разбора и ускоряет процесс
/******* Start symbols *******/

sql
  : (statement SEMI_COLON)* EOF
  ;

qname_parser
  : schema_qualified_name EOF
  ;

function_args_parser
  : schema_qualified_name? function_args EOF
  ;

vex_eof
  : vex EOF
  ;

/******* END Start symbols *******/

statement
  : data_statement
  | schema_statement
  | script_statement
  ;

data_statement
  : select_stmt
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

schema_statement
  : schema_create
    | schema_alter
    | schema_drop
  ;

schema_create
    : CREATE (create_table_statement
    | create_index_statement
    | create_extension_statement
    | create_trigger_statement
    | create_rewrite_statement
    | create_function_statement
    | create_sequence_statement
    | create_schema_statement
    | create_view_statement
    | create_language_statement
    | create_event_trigger
    | create_type_statement
    | create_domain_statement
    | create_transform_statement)

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
      ((SET DATA)? TYPE datatype=data_type collate_identifier? (USING expression=vex)?
      | (set_def_column
        | drop_def
        | ((SET | DROP) NOT NULL)
        | SET STATISTICS integer=NUMBER_LITERAL
        | set_attribute_option
        | RESET LEFT_PAREN storage_parameter RIGHT_PAREN
        | set_storage ))
    | ADD tabl_constraint=constraint_common (NOT not_valid=VALID)?
    | validate_constraint
    | drop_constraint
    | (DISABLE | ENABLE) TRIGGER (trigger_name=schema_qualified_name | (ALL | USER))?
    | ENABLE (REPLICA | ALWAYS) TRIGGER trigger_name=schema_qualified_name
    | (DISABLE | ENABLE) RULE rewrite_rule_name=schema_qualified_name
    | ENABLE (REPLICA | ALWAYS) RULE rewrite_rule_name=schema_qualified_name
    | (DISABLE | ENABLE) ROW LEVEL SECURITY
    | (NO)? FORCE ROW LEVEL SECURITY
    | CLUSTER ON index_name=schema_qualified_name
    | SET WITHOUT (CLUSTER | OIDS)
    | SET WITH OIDS
    | SET (LOGGED | UNLOGGED)
    | SET storage_parameter
    | RESET storage_parameter
    | INHERIT parent_table=schema_qualified_name
    | NO INHERIT parent_table=schema_qualified_name
    | OF type_name=schema_qualified_name
    | NOT OF
    | owner_to
    | SET table_space
    ;

set_attribute_option
    : SET storage_parameter
    ;
    
set_storage
    : SET STORAGE storage_option
    ;

storage_option
    : PLAIN 
    | EXTERNAL 
    | EXTENDED 
    | MAIN
    ;

validate_constraint
    : VALIDATE CONSTRAINT constraint_name=schema_qualified_name
    ;

drop_constraint
    : DROP CONSTRAINT (IF EXISTS)?  constraint_name=schema_qualified_name cascade_restrict?
    ;

table_deferrable
    : (NOT)? DEFERRABLE
    ;

table_initialy_immed
    :INITIALLY (DEFERRED | IMMEDIATE)
    ;

function_actions_common
    : (CALLED | RETURNS NULL) ON NULL INPUT
      | TRANSFORM transform_for_type (COMMA transform_for_type)*
      | (STRICT | IMMUTABLE | VOLATILE | STABLE)
      | (EXTERNAL)? SECURITY (INVOKER | DEFINER)
      | COST execution_cost=NUMBER_LITERAL
      | ROWS result_rows=NUMBER_LITERAL
      | SET configuration_parameter=identifier  (((TO | EQUAL)? (value+=set_statement_value)) | FROM CURRENT)(COMMA value+=set_statement_value)*
    ;

alter_default_privileges
    : DEFAULT PRIVILEGES
    (FOR (ROLE | USER) target_role+=identifier (COMMA target_role+=identifier)*)?
    (IN SCHEMA schema_name+=identifier (COMMA schema_name+=identifier)*)?
    abbreviated_grant_or_revoke
    ;

abbreviated_grant_or_revoke
    : (GRANT | REVOKE grant_option_for?) (
       table_column_privilege (COMMA table_column_privilege)*
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
    | SET LEFT_PAREN view_option_name=identifier (EQUAL view_option_value=vex)?(COMMA view_option_name=identifier (EQUAL view_option_value=vex)?)*  RIGHT_PAREN
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
    : ADD ATTRIBUTE attribute_name=identifier data_type collate_identifier? cascade_restrict?
    | DROP ATTRIBUTE (IF EXISTS)? attribute_name=identifier cascade_restrict?
    | ALTER ATTRIBUTE attribute_name=identifier (SET DATA)? TYPE data_type collate_identifier? cascade_restrict?
    ;

set_def_column
    : SET DEFAULT expression=vex
    ;

drop_def
    : DROP DEFAULT
    ;

create_index_statement
    : unique_value=UNIQUE? INDEX CONCURRENTLY? name=identifier? ON table_name=schema_qualified_name
        index_rest
    ;

index_rest
    : index_sort table_space? index_where?
    ;
    
index_sort
    : (USING method=identifier)?
      LEFT_PAREN sort_specifier_list RIGHT_PAREN
      with_storage_parameter?
    ;
    
index_where 
    : WHERE vex
    ;

 create_extension_statement
    : EXTENSION (IF NOT EXISTS)? name=identifier WITH?
         schema_with_name? (VERSION version=unsigned_value_specification)? (FROM old_version=unsigned_value_specification)?
    ;

create_language_statement
    : (OR REPLACE)? TRUSTED? PROCEDURAL? LANGUAGE name=identifier
        (HANDLER call_handler=schema_qualified_name (INLINE inline_handler=schema_qualified_name)? (VALIDATOR valfunction=schema_qualified_name)?)?
    ;

create_event_trigger
    : EVENT TRIGGER name=identifier ON event=identifier
        (WHEN filter_variable=schema_qualified_name (IN
            LEFT_PAREN
                filter_value+=Character_String_Literal(COMMA filter_value+=Character_String_Literal)*
            RIGHT_PAREN AND?)+ )?
        EXECUTE PROCEDURE funct_name=vex
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
            // pg_dump prints internallength first
            (INTERNALLENGTH EQUAL (internallength=signed_numerical_literal | VARIABLE) COMMA)?
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
            | STORAGE EQUAL storage=(PLAIN | EXTERNAL | EXTENDED | MAIN)
            | LIKE EQUAL like_type=data_type
            | CATEGORY EQUAL category=Character_String_Literal
            | PREFERRED EQUAL preferred=truth_value
            | DEFAULT EQUAL default_value=Character_String_Literal
            | ELEMENT EQUAL element=data_type
            | DELIMITER EQUAL delimiter=Character_String_Literal
            | COLLATABLE EQUAL collatable=truth_value))*
        RIGHT_PAREN)?
    ;

create_domain_statement
    : DOMAIN name=schema_qualified_name (AS)? dat_type=data_type
      (collate_identifier
      | DEFAULT def_value=vex
      | dom_constraint+=domain_constraint)*
    ;

domain_constraint
    :(CONSTRAINT name=schema_qualified_name)?
     common_constraint
    ;
    
create_transform_statement
    : (OR REPLACE)? TRANSFORM FOR schema_qualified_name LANGUAGE identifier 
    LEFT_PAREN
        FROM SQL WITH FUNCTION  function_parameters COMMA
        TO SQL WITH FUNCTION function_parameters
    RIGHT_PAREN
    ;

set_statement
    : SET (SESSION | LOCAL)?
    (config_param=identifier (TO | EQUAL) config_param_val+=set_statement_value (COMMA config_param_val+=set_statement_value)*
    | TIME ZONE (timezone=identifier | (LOCAL | DEFAULT)))
    ;

set_statement_value
    : vex | DEFAULT
    ;

create_rewrite_statement
    : (OR REPLACE)? RULE name=identifier AS ON event=(SELECT | INSERT | DELETE | UPDATE)
     TO table_name=schema_qualified_name (WHERE vex)? DO (ALSO | INSTEAD)?
     (NOTHING
        | commands+=rewrite_command
        | (LEFT_PAREN (commands+=rewrite_command SEMI_COLON)* commands+=rewrite_command SEMI_COLON? RIGHT_PAREN)
     )
    ;

rewrite_command
    : select_stmt
    | insert_stmt_for_psql
    | update_stmt_for_psql
    | delete_stmt_for_psql
    | notify_stmt
    ;

create_trigger_statement
    : CONSTRAINT? TRIGGER name=identifier (before_true=BEFORE | (INSTEAD OF) | AFTER)
    (((insert_true=INSERT | delete_true=DELETE | truncate_true=TRUNCATE) | update_true=UPDATE (OF names_references )?)OR?)+
    ON table_name=schema_qualified_name
    (FROM referenced_table_name=schema_qualified_name)?
    table_deferrable? table_initialy_immed?
    (for_each_true=FOR EACH? (ROW | STATEMENT))?
    when_trigger?
    EXECUTE PROCEDURE func_name=function_call
    ;

when_trigger
    : WHEN LEFT_PAREN when_expr=vex RIGHT_PAREN
    ;

rule_common
    : (GRANT | REVOKE grant_opt_for=grant_option_for?)
      body_rule=body_rules
    ;

body_rules
    :(on_table
    | on_sequence
    | on_database
    | on_datawrapper_server_lang
    | on_function
    | on_large_object
    | on_schema
    | on_tablespace
    | on_type
    | on_domain)
    body_rules_rest
    ;

body_rules_rest
    :(grant_to_rule | revoke_from_cascade_restrict)
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
    : priv_tbl_col+=table_column_privileges (COMMA priv_tbl_col+=table_column_privileges)*
        ON ( (TABLE? obj_name=names_references)
             | ALL TABLES IN SCHEMA (schema_name+=identifier)+)
    ;

table_column_privileges
    : table_column_privilege (LEFT_PAREN column+=identifier (COMMA column+=identifier)* RIGHT_PAREN)?
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
    :(GROUP? role_name+=identifier)(COMMA (GROUP? role_name+=identifier))*
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
        (RETURNS (rettype_data=data_type | ret_table=function_ret_table))?
          funct_body=create_funct_params
    ;

create_funct_params
    :(LANGUAGE lang_name=identifier
            | WINDOW
            | function_actions_common
            | AS function_body
            | AS Character_String_Literal (COMMA Character_String_Literal)*
          )+
      with_storage_parameter?
    ;

transform_for_type
    : FOR TYPE type_name=data_type
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
    :arg_mode=argmode? argname=identifier? argtype_data=data_type function_def_value?
    ;

function_def_value
    : (DEFAULT | EQUAL) def_value=vex
    ;

argmode
    : IN | OUT | INOUT | VARIADIC
    ;

create_sequence_statement
    : (TEMPORARY | TEMP)? SEQUENCE name=schema_qualified_name (sequence_body)*
    ;

sequence_body
    : INCREMENT BY? incr=signed_numerical_literal
        | (MINVALUE minval=signed_numerical_literal | NO MINVALUE)
        | (MAXVALUE maxval=signed_numerical_literal | NO MAXVALUE)
        | START WITH? start_val=signed_numerical_literal
        | CACHE cache_val=signed_numerical_literal
        | cycle_true=NO? cycle_val=CYCLE
        | OWNED BY (col_name=schema_qualified_name | NONE)
    ;

signed_numerical_literal
  : sign? unsigned_numeric_literal
  ;

sign
  : PLUS | MINUS
  ;

create_schema_statement
    : SCHEMA (IF NOT EXISTS)? name=identifier? (AUTHORIZATION user_name=identifier)? schema_def=schema_definition?
    ;

schema_definition
    : schema_element+=statement+
    ;

create_view_statement
    : (OR REPLACE)? (TEMP | TEMPORARY)? VIEW name=schema_qualified_name column_name=column_references?
        (WITH storage_parameter)?
        AS v_query=select_stmt
        with_check_option?
    ;
        
with_check_option
    : WITH (CASCADED|LOCAL)? CHECK OPTION
    ;

create_table_statement
  : ((GLOBAL | LOCAL)? (TEMPORARY | TEMP) | UNLOGGED)? TABLE (IF NOT EXISTS)? name=schema_qualified_name
    define_table
    storage_parameter_oid?
    on_commit?
    table_space?
  ;

define_table
   : define_columns 
   | define_type
   ;

define_columns
  : LEFT_PAREN 
      (table_col_def+=table_column_def (COMMA table_col_def+=table_column_def)*)? 
    RIGHT_PAREN
    (INHERITS parent_table=column_references)?
  ;

define_type
  : OF type_name=data_type
    list_of_type_column_def?
  ;

list_of_type_column_def
  : LEFT_PAREN 
      (table_col_def+=table_of_type_column_def (COMMA table_col_def+=table_of_type_column_def)*) 
    RIGHT_PAREN
  ;

table_column_def
    : table_column_definition
       | tabl_constraint=constraint_common
       | LIKE parent_table=schema_qualified_name (like_opt+=like_option)*
    ;
    
table_of_type_column_def
    : table_of_type_column_definition
       | tabl_constraint=constraint_common
    ;

table_column_definition
    : column_name=identifier datatype=data_type collate_name=collate_identifier? (colmn_constraint+=constraint_common)*
    ;
    
table_of_type_column_definition
    : column_name=identifier WITH OPTIONS (colmn_constraint+=constraint_common)*
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
            LEFT_PAREN exclude_element=identifier WITH operator=all_op RIGHT_PAREN
            index_parameters (WHERE vex)?)
       | (FOREIGN KEY column_references)? table_references
       | common_constraint
       | table_unique_prkey
       | DEFAULT default_expr=vex
      )
      table_deferrable? table_initialy_immed?
    ;
    
all_op
    :op
    | EQUAL | NOT_EQUAL | LTH | LEQ | GTH | GEQ
    | PLUS | MINUS | MULTIPLY | DIVIDE | MODULAR | EXP
    ;

table_unique_prkey
    : (UNIQUE | PRIMARY KEY) column_references? index_parameters_unique=index_parameters
    ;

index_parameters
    : with_storage_parameter? (USING INDEX (table_space | schema_qualified_name))?
    ;

common_constraint
    :check_boolean_expression
    | null_false=NOT? null_value=NULL
    ;

table_references
    : REFERENCES reftable=schema_qualified_name column_references?
            (match_all | (ON DELETE action_on_delete=action) | (ON UPDATE action_on_update=action))*
    ;

column_references
    :LEFT_PAREN names_references RIGHT_PAREN
    ;
    
names_references
    : name+=schema_qualified_name (COMMA name+=schema_qualified_name)*
    ;

match_all
    : MATCH (FULL | PARTIAL | SIMPLE)
    ;

check_boolean_expression
    : CHECK LEFT_PAREN expression=vex RIGHT_PAREN
    ;

storage_parameter
    : LEFT_PAREN
        storage_parameter_option
        (COMMA storage_parameter_option)*
      RIGHT_PAREN
    ;
    
storage_parameter_option
    :  storage_param=schema_qualified_name (EQUAL value=vex)?
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
    : TABLESPACE name=schema_qualified_name
    ;

action
    : cascade_restrict
      | SET (NULL | DEFAULT)
      | NO ACTION
    ;

owner_to
    : OWNER TO name=identifier
    ;

rename_to
    : RENAME TO name=identifier
    ;

set_schema
    : SET schema_with_name
    ;

schema_with_name
    : SCHEMA name=identifier
    ;

table_column_privilege
    : SELECT | INSERT | UPDATE | DELETE | TRUNCATE | REFERENCES | TRIGGER | ALL PRIVILEGES?
    ;

usage_select_update
    : USAGE | SELECT | UPDATE
    ;
create_connect_temporary_temp
    :CREATE | CONNECT | TEMPORARY | TEMP
    ;

partition_by_columns
    : PARTITION BY vex (COMMA vex)*
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
    : TRIGGER (IF EXISTS)? name=identifier ON table_name=schema_qualified_name cascade_restrict?
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

/*
  old rule for default old identifier behavior
  includes types
*/
identifier
  : (Identifier | QuotedIdentifier)
  | tokens_nonreserved
  | tokens_nonreserved_except_function_type
  | tokens_nonkeyword
  ;

identifier_nontype
  : (Identifier | QuotedIdentifier)
  | tokens_nonreserved
  | tokens_reserved_except_function_type
  | tokens_nonkeyword
  ;

/*
 * These rules should be generated using code in the Keyword class.
 * Word tokens that are not keywords should be added to nonreserved list.
 */
tokens_nonreserved
  : ABORT
  | ABSOLUTE
  | ACCESS
  | ACTION
  | ADD
  | ADMIN
  | AFTER
  | AGGREGATE
  | ALSO
  | ALTER
  | ALWAYS
  | ASSERTION
  | ASSIGNMENT
  | AT
  | ATTRIBUTE
  | BACKWARD
  | BEFORE
  | BEGIN
  | BY
  | CACHE
  | CALLED
  | CASCADE
  | CASCADED
  | CATALOG
  | CHAIN
  | CHARACTERISTICS
  | CHECKPOINT
  | CLASS
  | CLOSE
  | CLUSTER
  | COMMENT
  | COMMENTS
  | COMMIT
  | COMMITTED
  | CONFIGURATION
  | CONFLICT
  | CONNECTION
  | CONSTRAINTS
  | CONTENT
  | CONTINUE
  | CONVERSION
  | COPY
  | COST
  | CSV
  | CUBE
  | CURRENT
  | CURSOR
  | CYCLE
  | DATA
  | DATABASE
  | DAY
  | DEALLOCATE
  | DECLARE
  | DEFAULTS
  | DEFERRED
  | DEFINER
  | DELETE
  | DELIMITER
  | DELIMITERS
  | DEPENDS
  | DICTIONARY
  | DISABLE
  | DISCARD
  | DOCUMENT
  | DOMAIN
  | DOUBLE
  | DROP
  | EACH
  | ENABLE
  | ENCODING
  | ENCRYPTED
  | ENUM
  | ESCAPE
  | EVENT
  | EXCLUDE
  | EXCLUDING
  | EXCLUSIVE
  | EXECUTE
  | EXPLAIN
  | EXTENSION
  | EXTERNAL
  | FAMILY
  | FILTER
  | FIRST
  | FOLLOWING
  | FORCE
  | FORWARD
  | FUNCTION
  | FUNCTIONS
  | GLOBAL
  | GRANTED
  | HANDLER
  | HEADER
  | HOLD
  | HOUR
  | IDENTITY
  | IF
  | IMMEDIATE
  | IMMUTABLE
  | IMPLICIT
  | IMPORT
  | INCLUDING
  | INCREMENT
  | INDEX
  | INDEXES
  | INHERIT
  | INHERITS
  | INLINE
  | INPUT
  | INSENSITIVE
  | INSERT
  | INSTEAD
  | INVOKER
  | ISOLATION
  | KEY
  | LABEL
  | LANGUAGE
  | LARGE
  | LAST
  | LEAKPROOF
  | LEVEL
  | LISTEN
  | LOAD
  | LOCAL
  | LOCATION
  | LOCK
  | LOCKED
  | LOGGED
  | MAPPING
  | MATCH
  | MATERIALIZED
  | MAXVALUE
  | METHOD
  | MINUTE
  | MINVALUE
  | MODE
  | MONTH
  | MOVE
  | NAME
  | NAMES
  | NEXT
  | NO
  | NOTHING
  | NOTIFY
  | NOWAIT
  | NULLS
  | OBJECT
  | OF
  | OFF
  | OIDS
  | OPERATOR
  | OPTION
  | OPTIONS
  | ORDINALITY
  | OVER
  | OWNED
  | OWNER
  | PARALLEL
  | PARSER
  | PARTIAL
  | PARTITION
  | PASSING
  | PASSWORD
  | PLANS
  | POLICY
  | PRECEDING
  | PREPARE
  | PREPARED
  | PRESERVE
  | PRIOR
  | PRIVILEGES
  | PROCEDURAL
  | PROCEDURE
  | PROGRAM
  | QUOTE
  | RANGE
  | READ
  | REASSIGN
  | RECHECK
  | RECURSIVE
  | REF
  | REFRESH
  | REINDEX
  | RELATIVE
  | RELEASE
  | RENAME
  | REPEATABLE
  | REPLACE
  | REPLICA
  | RESET
  | RESTART
  | RESTRICT
  | RETURNS
  | REVOKE
  | ROLE
  | ROLLBACK
  | ROLLUP
  | ROWS
  | RULE
  | SAVEPOINT
  | SCHEMA
  | SCROLL
  | SEARCH
  | SECOND
  | SECURITY
  | SEQUENCE
  | SEQUENCES
  | SERIALIZABLE
  | SERVER
  | SESSION
  | SET
  | SETS
  | SHARE
  | SHOW
  | SIMPLE
  | SKIP_
  | SNAPSHOT
  | SQL
  | STABLE
  | STANDALONE
  | START
  | STATEMENT
  | STATISTICS
  | STDIN
  | STDOUT
  | STORAGE
  | STRICT
  | STRIP
  | SYSID
  | SYSTEM
  | TABLES
  | TABLESPACE
  | TEMP
  | TEMPLATE
  | TEMPORARY
  | TEXT
  | TRANSACTION
  | TRANSFORM
  | TRIGGER
  | TRUNCATE
  | TRUSTED
  | TYPE
  | TYPES
  | UNBOUNDED
  | UNCOMMITTED
  | UNENCRYPTED
  | UNKNOWN
  | UNLISTEN
  | UNLOGGED
  | UNTIL
  | UPDATE
  | VACUUM
  | VALID
  | VALIDATE
  | VALIDATOR
  | VALUE
  | VARYING
  | VERSION
  | VIEW
  | VIEWS
  | VOLATILE
  | WHITESPACE
  | WITHIN
  | WITHOUT
  | WORK
  | WRAPPER
  | WRITE
  | XML
  | YEAR
  | YES
  | ZONE
  ;

tokens_nonreserved_except_function_type
  : BETWEEN
  | BIGINT
  | BIT
  | BOOLEAN
  | CHAR
  | CHARACTER
  | COALESCE
  | DEC
  | DECIMAL
  | EXISTS
  | EXTRACT
  | FLOAT
  | GREATEST
  | GROUPING
  | INOUT
  | INT
  | INTEGER
  | INTERVAL
  | LEAST
  | NATIONAL
  | NCHAR
  | NONE
  | NULLIF
  | NUMERIC
  | OUT
  | OVERLAY
  | POSITION
  | PRECISION
  | REAL
  | ROW
  | SETOF
  | SMALLINT
  | SUBSTRING
  | TIME
  | TIMESTAMP
  | TREAT
  | TRIM
  | VALUES
  | VARCHAR
  | XMLATTRIBUTES
  | XMLCONCAT
  | XMLELEMENT
  | XMLEXISTS
  | XMLFOREST
  | XMLPARSE
  | XMLPI
  | XMLROOT
  | XMLSERIALIZE
  ;

tokens_simple_functions
  : COALESCE
  | GREATEST
  | GROUPING
  | LEAST
  | NULLIF
  | ROW
  | XMLCONCAT
  ;

tokens_reserved_except_function_type
  : AUTHORIZATION
  | BINARY
  | COLLATION
  | CONCURRENTLY
  | CROSS
  | CURRENT_SCHEMA
  | FREEZE
  | FULL
  | ILIKE
  | INNER
  | IS
  | ISNULL
  | JOIN
  | LEFT
  | LIKE
  | NATURAL
  | NOTNULL
  | OUTER
  | OVERLAPS
  | RIGHT
  | SIMILAR
  | TABLESAMPLE
  | VERBOSE
  ;

tokens_reserved
  : ALL
  | ANALYSE
  | ANALYZE
  | AND
  | ANY
  | ARRAY
  | AS
  | ASC
  | ASYMMETRIC
  | BOTH
  | CASE
  | CAST
  | CHECK
  | COLLATE
  | COLUMN
  | CONSTRAINT
  | CREATE
  | CURRENT_CATALOG
  | CURRENT_DATE
  | CURRENT_ROLE
  | CURRENT_TIME
  | CURRENT_TIMESTAMP
  | CURRENT_USER
  | DEFAULT
  | DEFERRABLE
  | DESC
  | DISTINCT
  | DO
  | ELSE
  | END
  | EXCEPT
  | FALSE
  | FETCH
  | FOR
  | FOREIGN
  | FROM
  | GRANT
  | GROUP
  | HAVING
  | IN
  | INITIALLY
  | INTERSECT
  | INTO
  | LATERAL
  | LEADING
  | LIMIT
  | LOCALTIME
  | LOCALTIMESTAMP
  | NOT
  | NULL
  | OFFSET
  | ON
  | ONLY
  | OR
  | ORDER
  | PLACING
  | PRIMARY
  | REFERENCES
  | RETURNING
  | SELECT
  | SESSION_USER
  | SOME
  | SYMMETRIC
  | TABLE
  | THEN
  | TO
  | TRAILING
  | TRUE
  | UNION
  | UNIQUE
  | USER
  | USING
  | VARIADIC
  | WHEN
  | WHERE
  | WINDOW
  | WITH
  ;
  
tokens_nonkeyword
  : PLAIN
  | EXTENDED
  | MAIN
  | SUBTYPE
  | SUBTYPE_OPCLASS
  | SUBTYPE_DIFF
  | CANONICAL
  | RECEIVE
  | SEND
  | TYPMOD_IN
  | TYPMOD_OUT
  | INTERNALLENGTH
  | PASSEDBYVALUE
  | ALIGNMENT
  | CATEGORY
  | PREFERRED
  | COLLATABLE
  | VARIABLE
  | OUTPUT
  | ELEMENT
  | USAGE
  | CONNECT
  ;

/*
===============================================================================
  6.1 <data types>
===============================================================================
*/

schema_qualified_name_nontype
  : identifier_nontype
  | schema=identifier DOT identifier_nontype 
  ;

data_type
  : predefined_type (LEFT_BRACKET RIGHT_BRACKET)?
  | SETOF value=predefined_type
  ;

predefined_type
  : BIGINT 
  | BIT VARYING? type_length?
  | BOOLEAN
  | DEC precision_param?
  | DECIMAL precision_param?
  | DOUBLE PRECISION
  | FLOAT precision_param?
  | INT
  | INTEGER
  | INTERVAL ((identifier TO)? identifier)? type_length?
  | NATIONAL? (CHARACTER | CHAR) VARYING? type_length?
  | NCHAR VARYING? type_length?
  | NUMERIC precision_param?
  | REAL
  | SMALLINT
  | TIME type_length? ((WITH | WITHOUT) TIME ZONE)?
  | TIMESTAMP type_length? ((WITH | WITHOUT) TIME ZONE)?
  | VARCHAR type_length?
  | schema_qualified_name_nontype
  ;

type_length
  : LEFT_PAREN NUMBER_LITERAL RIGHT_PAREN
  ;

precision_param
  : LEFT_PAREN precision=NUMBER_LITERAL (COMMA scale=NUMBER_LITERAL)? RIGHT_PAREN
  ;

/*
===============================================================================
  6.25 <value expression>
===============================================================================
*/

vex
  : vex CAST_EXPRESSION data_type
  | LEFT_PAREN vex RIGHT_PAREN
  | vex LEFT_BRACKET vex (COLON vex)? RIGHT_BRACKET
  | vex collate_identifier
  | <assoc=right> (PLUS | MINUS) vex
  | vex AT TIME ZONE vex
  | vex EXP vex
  | vex (MULTIPLY | DIVIDE | MODULAR) vex
  | vex (PLUS | MINUS) vex
  // TODO a lot of ambiguities between 3 next alternatives
  | vex op vex
  | op vex
  | vex op
  | vex NOT? IN LEFT_PAREN (select_stmt_no_parens | vex (COMMA vex)*) RIGHT_PAREN
  | vex NOT? BETWEEN (ASYMMETRIC | SYMMETRIC)? vex_b AND vex
  | vex NOT? (LIKE | ILIKE | SIMILAR TO) vex
  | vex NOT? (LIKE | ILIKE | SIMILAR TO) vex ESCAPE vex
  | vex (LTH | GTH | LEQ | GEQ | EQUAL | NOT_EQUAL) vex
  | vex IS NOT? (truth_value | NULL)
  | vex IS NOT? DISTINCT FROM vex
  | vex IS NOT? DOCUMENT
  | vex ISNULL
  | vex NOTNULL
  | datetime_overlaps
  | <assoc=right> NOT vex
  | vex AND vex
  | vex OR vex
  | value_expression_primary
  ;

// partial copy of vex
// resolves (vex BETWEEN vex AND vex) vs. (vex AND vex) ambiguity
// vex references that are not at alternative edge are referencing the full rule
// see postgres' b_expr (src/backend/parser/gram.y)
vex_b
  : vex_b CAST_EXPRESSION data_type
  | LEFT_PAREN vex RIGHT_PAREN
  | vex_b LEFT_BRACKET vex (COLON vex)? RIGHT_BRACKET
  | <assoc=right> (PLUS | MINUS) vex_b
  | vex_b EXP vex_b
  | vex_b (MULTIPLY | DIVIDE | MODULAR) vex_b
  | vex_b (PLUS | MINUS) vex_b
  | vex_b op vex_b
  | op vex_b
  | vex_b op
  | vex_b (LTH | GTH | LEQ | GEQ | EQUAL | NOT_EQUAL) vex_b
  | vex_b IS NOT? DISTINCT FROM vex_b
  | vex_b IS NOT? DOCUMENT
  | value_expression_primary
  ;

op
  : OP_CHARS
  | OPERATOR LEFT_PAREN identifier DOT OP_CHARS RIGHT_PAREN
  ;

datetime_overlaps
  : LEFT_PAREN vex COMMA vex RIGHT_PAREN OVERLAPS LEFT_PAREN vex COMMA vex RIGHT_PAREN
  ;

value_expression_primary
  : unsigned_value_specification
  | LEFT_PAREN select_stmt_no_parens RIGHT_PAREN
  | case_expression
  | cast_specification
  | NULL
  // technically incorrect since ANY cannot be value expression
  // but fixing this would require to write a vex rule duplicating all operators
  // like vex (op|op|op|...) comparison_mod
  | comparison_mod
  | EXISTS table_subquery
  | function_call
  | schema_qualified_name
  | qualified_asterisk
  | array_expression
  | type_coercion
  ;

unsigned_value_specification
  : unsigned_numeric_literal
  | general_literal
  ;

unsigned_numeric_literal
  : NUMBER_LITERAL
  | REAL_NUMBER
  ;

general_literal
  : Character_String_Literal
  | datetime_literal
  | truth_value
  ;
  
datetime_literal
  : identifier Character_String_Literal
  ;

truth_value
  : TRUE | FALSE | UNKNOWN | ON | OFF
  ;

case_expression
  : CASE vex? (WHEN vex THEN vex)+ (ELSE r=vex)? END
  ;

cast_specification
  : (CAST | TREAT) LEFT_PAREN vex AS data_type RIGHT_PAREN
  ;

// using data_type for function name because keyword-named functions
// use the same category of keywords as keyword-named types
function_call
    : function_name LEFT_PAREN (set_qualifier? vex (COMMA vex)* orderby_clause?)? RIGHT_PAREN
        filter_clause? (OVER window_definition)?
    | extract_function
    | system_function
    | date_time_function
    | string_value_function
    | xml_function
    ;

function_name
  : data_type
  // allow for all built-in function except those with explicit syntax rules defined
  | (identifier DOT)? tokens_simple_functions
  ;

extract_function
  : EXTRACT LEFT_PAREN extract_field_string=identifier FROM vex RIGHT_PAREN
  ;

system_function
    : CURRENT_CATALOG
    // parens are handled by generic function call
    // since current_schema is defined as reserved(can be function) keyword
    | CURRENT_SCHEMA /*(LEFT_PAREN RIGHT_PAREN)?*/
    | CURRENT_USER
    | SESSION_USER
    | USER
    ;

date_time_function
    : CURRENT_DATE
    | CURRENT_TIME type_length?
    | CURRENT_TIMESTAMP type_length?
    | LOCALTIME type_length?
    | LOCALTIMESTAMP type_length?
    ;

string_value_function
  : TRIM LEFT_PAREN (LEADING | TRAILING | BOTH)? (chars=vex? FROM str=vex | FROM? str=vex (COMMA chars=vex)?) RIGHT_PAREN
  | SUBSTRING LEFT_PAREN vex (FROM vex)? (FOR vex)? RIGHT_PAREN
  | POSITION LEFT_PAREN vex_b IN vex RIGHT_PAREN
  | OVERLAY LEFT_PAREN vex PLACING vex FROM vex (FOR vex)? RIGHT_PAREN
  ;

xml_function
    : XMLELEMENT LEFT_PAREN NAME name=identifier
        (COMMA XMLATTRIBUTES LEFT_PAREN vex (AS attname=identifier)? (COMMA vex (AS attname=identifier)?)* RIGHT_PAREN)?
        (vex (COMMA vex)*)? RIGHT_PAREN
    | XMLFOREST LEFT_PAREN vex (AS name=identifier)? (COMMA vex (AS name=identifier)?)* RIGHT_PAREN
    | XMLPI LEFT_PAREN NAME name=identifier (COMMA vex)? RIGHT_PAREN
    | XMLROOT LEFT_PAREN vex COMMA VERSION (vex | NO VALUE) (COMMA STANDALONE (YES | NO | NO VALUE))? RIGHT_PAREN
    | XMLEXISTS LEFT_PAREN vex PASSING (BY REF)? vex (BY REF)? RIGHT_PAREN
    | XMLPARSE LEFT_PAREN (DOCUMENT | CONTENT) vex RIGHT_PAREN
    | XMLSERIALIZE LEFT_PAREN (DOCUMENT | CONTENT) vex AS data_type RIGHT_PAREN
    ;

comparison_mod
    : (ALL | ANY | SOME) LEFT_PAREN (vex | select_stmt_no_parens) RIGHT_PAREN
    ;

filter_clause
  : FILTER LEFT_PAREN WHERE vex RIGHT_PAREN
  ;

window_definition
  : w_name=identifier | LEFT_PAREN (w_name=identifier? partition_by_columns? orderby_clause? frame_clause?) RIGHT_PAREN
  ;

frame_clause
  : (RANGE | ROWS) (frame_bound | BETWEEN frame_bound AND frame_bound)
  ;

frame_bound
  : (UNBOUNDED | vex) (PRECEDING | FOLLOWING)
  | CURRENT ROW
  ;

qualified_asterisk
  : (tb_name=schema_qualified_name DOT)? MULTIPLY
  ;

array_expression
    : array_brackets
    | array_query
    ;

array_brackets
    : ARRAY LEFT_BRACKET vex (COMMA vex)* RIGHT_BRACKET
    ;

array_query
    : ARRAY table_subquery
    ;

type_coercion
    : data_type Character_String_Literal
    ;
    
/*
===============================================================================
  7.13 <query expression>
===============================================================================
*/
schema_qualified_name
  : identifier ( DOT identifier ( DOT identifier )? )?
  ;

set_qualifier
  : DISTINCT | ALL
  ;

table_subquery
  : LEFT_PAREN select_stmt RIGHT_PAREN
  ;

select_stmt
    : with_clause? select_ops
        orderby_clause?
        (LIMIT (vex | ALL))?
        (OFFSET vex (ROW | ROWS))?
        (FETCH (FIRST | NEXT) vex? (ROW | ROWS) ONLY)?
        (FOR (UPDATE | NO KEY UPDATE | SHARE | NO KEY SHARE) (OF schema_qualified_name (COMMA schema_qualified_name)*)? NOWAIT?)*
    ;

// select_stmt copy that doesn't consume external parens
// for use in vex
// we let the vex rule to consume as many parens as it can
select_stmt_no_parens
    : with_clause? select_ops_no_parens
        orderby_clause?
        (LIMIT (vex | ALL))?
        (OFFSET vex (ROW | ROWS))?
        (FETCH (FIRST | NEXT) vex? (ROW | ROWS) ONLY)?
        (FOR (UPDATE | NO KEY UPDATE | SHARE | NO KEY SHARE) (OF schema_qualified_name (COMMA schema_qualified_name)*)? NOWAIT?)*
    ;

with_clause
    : WITH RECURSIVE? with_query (COMMA with_query)*
    ;

with_query
    : query_name=identifier (LEFT_PAREN column_name=identifier (COMMA column_name=identifier)* RIGHT_PAREN)?
            AS LEFT_PAREN (select_stmt | insert_stmt_for_psql | update_stmt_for_psql | delete_stmt_for_psql) RIGHT_PAREN
    ;

select_ops
    : LEFT_PAREN select_stmt RIGHT_PAREN // parens can be used to apply "global" clauses (WITH etc) to a particular select in UNION expr
    | select_ops (INTERSECT | UNION | EXCEPT) set_qualifier? select_ops
    | select_primary
    ;

// copy of select_ops for use in select_stmt_no_parens
select_ops_no_parens
    : select_ops (INTERSECT | UNION | EXCEPT) set_qualifier? select_ops
    | select_primary
    ;

select_primary
    : SELECT
        (set_qualifier (ON LEFT_PAREN vex (COMMA vex)* RIGHT_PAREN)?)?
        select_list
        (FROM from_item (COMMA from_item)*)?
        (WHERE vex)?
        groupby_clause?
        (HAVING vex)?
        (WINDOW w_name=identifier AS LEFT_PAREN window_definition RIGHT_PAREN (COMMA w_name=identifier AS LEFT_PAREN window_definition RIGHT_PAREN)*)?
    | TABLE ONLY? schema_qualified_name MULTIPLY?
    | values_stmt
    ;

select_list
  : select_sublist (COMMA select_sublist)*
  ;

select_sublist
  : vex (AS? alias=identifier)?
  ;

from_item
    : LEFT_PAREN from_item RIGHT_PAREN alias_clause?
    | from_item CROSS JOIN from_item
    | from_item (INNER | (LEFT | RIGHT | FULL) OUTER?)? JOIN from_item ON vex
    | from_item (INNER | (LEFT | RIGHT | FULL) OUTER?)? JOIN from_item USING column_references
    | from_item NATURAL (INNER | (LEFT | RIGHT | FULL) OUTER?)? JOIN from_item
    | from_primary
    ;

from_primary
    : ONLY? schema_qualified_name MULTIPLY? alias_clause?
    | LATERAL? table_subquery alias_clause
    | LATERAL? function_call
        (AS from_function_column_def 
        | AS? alias=identifier (LEFT_PAREN column_alias+=identifier (COMMA column_alias+=identifier)* RIGHT_PAREN | from_function_column_def)?
        )?
    ;

alias_clause
    : AS? alias=identifier (LEFT_PAREN column_alias+=identifier (COMMA column_alias+=identifier)* RIGHT_PAREN)?
    ;

from_function_column_def
    : LEFT_PAREN column_alias+=identifier data_type (COMMA column_alias+=identifier data_type)* RIGHT_PAREN
    ;

groupby_clause
  : GROUP BY g=grouping_element_list
  ;

grouping_element_list
  : grouping_element (COMMA grouping_element)*
  ;

grouping_element
  : grouping_set_list
  | empty_grouping_set
  | ordinary_grouping_set
  ;

ordinary_grouping_set
  : vex
  | row_value_predicand_list
  ;

ordinary_grouping_set_list
  : ordinary_grouping_set (COMMA ordinary_grouping_set)*
  ;

grouping_set_list
  : (ROLLUP | CUBE | GROUPING SETS) LEFT_PAREN c=ordinary_grouping_set_list RIGHT_PAREN
  ;

empty_grouping_set
  : LEFT_PAREN RIGHT_PAREN
  ;

row_value_predicand_list
  : LEFT_PAREN vex (COMMA vex)* RIGHT_PAREN
  ;

values_stmt
    : VALUES values_values (COMMA values_values)*
    ;

values_values
  : LEFT_PAREN (vex | DEFAULT) (COMMA (vex | DEFAULT))* RIGHT_PAREN
  ;

orderby_clause
  : ORDER BY sort_specifier_list
  ;

sort_specifier_list
  : sort_specifier (COMMA sort_specifier)*
  ;

sort_specifier
  : key=vex
    opclass=identifier? // this allows to share this rule with create_index; technically invalid syntax
    order=order_specification?
    null_order=null_ordering?
  ;

order_specification
  : ASC | DESC | USING schema_qualified_name
  ;

null_ordering
  : NULLS (FIRST | LAST)
  ;

/*
    TODO column_name
    The name of a column in the table named by table_name. The column name can be qualified with a subfield name or array subscript, if needed.
    (Inserting into only some fields of a composite column leaves the other fields null.)
    NOTE: name qualification is not allowed (e.g. t1.c1)
    this applies to UPDATE as well
*/
insert_stmt_for_psql
  : with_clause? INSERT INTO insert_table_name=schema_qualified_name
  (LEFT_PAREN column+=identifier (COMMA column+=identifier)* RIGHT_PAREN)?
  (select_stmt | DEFAULT VALUES)
  (RETURNING select_list)?
  ;

delete_stmt_for_psql
  : with_clause? DELETE FROM ONLY? delete_table_name=schema_qualified_name MULTIPLY? (AS? alias=identifier)?
  (USING using_table (COMMA using_table)*)?
  (WHERE (vex | CURRENT OF cursor=identifier))?
  (RETURNING select_list)?
  ;

update_stmt_for_psql
  : with_clause? UPDATE ONLY? update_table_name=schema_qualified_name MULTIPLY? (AS? alias=identifier)?
  SET update_set (COMMA update_set)*
  (FROM using_table (COMMA using_table)*)?
  (WHERE (vex | WHERE CURRENT OF cursor=identifier))?
  (RETURNING select_list)?
  ;

update_set
  : column+=identifier EQUAL (value+=vex | DEFAULT)
  | LEFT_PAREN column+=identifier (COMMA column+=identifier)* RIGHT_PAREN EQUAL
  (LEFT_PAREN (value+=vex | DEFAULT) (COMMA (value+=vex | DEFAULT))* RIGHT_PAREN
    | table_subquery)
  ;

using_table
  : ONLY? schema_qualified_name MULTIPLY? alias_clause?
  ;

notify_stmt
  : NOTIFY channel=identifier (COMMA payload=Character_String_Literal)?
  ;
