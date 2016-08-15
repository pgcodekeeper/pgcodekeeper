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
  : function_args EOF
  ;

/******* END Start symbols *******/

statement
  : data_statement
   /*| data_change_statement*/
  | schema_statement
  | script_statement
  ;

data_statement
  : select_stmt
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
           | ( query=select_stmt ))
        (FROM | TO) (filename=identifier | STDIN)
        (WITH? LEFT_PAREN option=copy_option(COMMA option=copy_option)* RIGHT_PAREN)?
    ;
copy_option:
    FORMAT format_name=identifier
    | OIDS (boolean_val=truth_value)?
    | DELIMITER delimiter_character=identifier
    | NULL null_string=identifier
    | HEADER (boolean_val=truth_value)?
    | QUOTE_CHAR quote_character=identifier
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
      ((SET DATA)? TYPE datatype=data_type collate_identifier? (USING expression=vex)?
      | (set_def_column
        | drop_def
        | ((SET | DROP) NOT NULL)
        | SET STATISTICS integer=NUMBER_LITERAL
        | SET LEFT_PAREN attribute_option_value (COMMA attribute_option_value)* RIGHT_PAREN
        | RESET LEFT_PAREN attribute_option+=table_attribute_option (COMMA attribute_option+=table_attribute_option)* RIGHT_PAREN
        | SET STORAGE (PLAIN | EXTERNAL | EXTENDED | MAIN)))
    | ADD tabl_constraint=constraint_common (NOT VALID)?
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

table_attribute_option
    : N_DISTINCT | N_DISTINCT_INHERITED
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
    : unique_value=UNIQUE? INDEX CONCURRENTLY? name=schema_qualified_name? ON table_name=schema_qualified_name
        index_rest
    ;

index_rest
    : (USING method=identifier)?
      LEFT_PAREN sort_specifier_list RIGHT_PAREN
      param_clause? table_space? (WHERE vex)?
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

set_statement
    : SET (SESSION | LOCAL)?
    (config_param=identifier (TO | EQUAL) config_param_val+=set_statement_value (COMMA config_param_val+=set_statement_value)*
    | TIME ZONE (timezone=identifier | (LOCAL | DEFAULT)))
    ;

set_statement_value
    : vex | DEFAULT
    ;

create_rewrite_statement
    : (OR REPLACE)? RULE name=schema_qualified_name AS ON event=(SELECT | INSERT | DELETE | UPDATE)
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
    : CONSTRAINT? TRIGGER name=schema_qualified_name (before_true=BEFORE | (INSTEAD OF) | AFTER)
    (((insert_true=INSERT | delete_true=DELETE | truncate_true=TRUNCATE) | update_true=UPDATE (OF names_references )?)OR?)+
    ON tabl_name=schema_qualified_name
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
    :arg_mode=argmode? argname=identifier? argtype_data=data_type function_def_value?
    ;

function_def_value
    : (DEFAULT | EQUAL) def_value=vex
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
    : SCHEMA (IF NOT EXISTS)? name=schema_qualified_name? (AUTHORIZATION user_name=identifier)? schema_def=schema_definition?
    ;

schema_definition
    : schema_element+=statement+
    ;

create_view_statement
    : (OR REPLACE)? (TEMP | TEMPORARY)? VIEW name=schema_qualified_name column_name=column_references?
        (WITH LEFT_PAREN (view_option_name+=identifier (EQUAL view_option_value+=identifier)?)+ RIGHT_PAREN)?
        AS v_query=select_stmt
    ;

create_table_statement
  : ((GLOBAL | LOCAL)? (TEMPORARY | TEMP) | UNLOGGED)? TABLE (IF NOT EXISTS)? name=schema_qualified_name
        (OF type_name=identifier)?
        LEFT_PAREN (table_col_def+=table_column_def (COMMA table_col_def+=table_column_def)*)? RIGHT_PAREN
        (INHERITS parent_table= column_references)?
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
    : column_name=identifier datatype=data_type collate_name=collate_identifier? with_options? (colmn_constraint+=constraint_common)*
    ;

with_options
    : WITH OPTIONS
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
            index_parameters (WHERE vex)?)
       | (FOREIGN KEY column_references)? table_references
       | common_constraint
       | table_unique_prkey
       | DEFAULT default_expr=vex
      )
      table_deferrable? table_initialy_immed?
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
        storage_param=schema_qualified_name (EQUAL value=vex)?
        (COMMA storage_param=schema_qualified_name (EQUAL value=vex)?)*
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
    : TABLESPACE name=schema_qualified_name
    ;

action
    : cascade_restrict
      | SET (NULL | DEFAULT)
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

table_column_privilege
    : SELECT | INSERT | UPDATE | DELETE | TRUNCATE | REFERENCES | TRIGGER | ALL PRIVILEGES?
    ;

usage_select_update
    : USAGE | SELECT | UPDATE
    ;
create_connect_temporary_temp
    :CREATE | CONNECT | TEMPORARY | TEMP
    ;

param_clause
  : WITH LEFT_PAREN param (COMMA param)* RIGHT_PAREN
  ;

param
  : key=identifier EQUAL value=vex
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

/*
  old rule for default old identifier behavior
  includes types
*/
identifier
  : (Identifier | QuotedIdentifier)
  | tokens_nonreserved
  | tokens_nonreserved_types
  | tokens_nonreserved_except_function_type
  ;

identifier_nontype
  : (Identifier | QuotedIdentifier)
  | tokens_nonreserved;

tokens_nonreserved
  : ABORT
//  | A
//  | ABS
//  | ABSENT
  | ABSOLUTE
  | ACCESS
//  | ACCORDING
  | ACTION
//  | ADA
  | ADD
  | ADMIN
  | AFTER
  | AGGREGATE
  | ALIGNMENT
//  | ALLOCATE
  | ALSO
  | ALTER
  | ALWAYS
//  | ARE
//  | ARRAY_AGG
//  | ARRAY_MAX_CARDINALITY
//  | ASENSITIVE
  | ASSERTION
  | ASSIGNMENT
  | AT
//  | ATOMIC
  | ATTRIBUTE
//  | ATTRIBUTES
  | AVG
  | BACKWARD
//  | BASE64
  | BEFORE
  | BEGIN
//  | BEGIN_FRAME
//  | BEGIN_PARTITION
//  | BERNOULLI
//  | BIT_LENGTH
//  | BLOCKED
//  | BOM
//  | BREADTH
  | BY
//  | C
  | CACHE
//  | CALL
  | CALLED
  | CANONICAL
//  | CARDINALITY
  | CASCADE
  | CASCADED
  | CATALOG
//  | CATALOG_NAME
  | CATEGORY
//  | CEIL
//  | CEILING
  | CENTURY
  | CHAIN
  | CHARACTERISTICS
//  | CHARACTERS
//  | CHARACTER_LENGTH
//  | CHARACTER_SET_CATALOG
//  | CHARACTER_SET_NAME
//  | CHARACTER_SET_SCHEMA
//  | CHAR_LENGTH
  | CHECKPOINT
  | CLASS
//  | CLASS_ORIGIN
//  | CLOB
  | CLOSE
  | CLUSTER
//  | COBOL
  | COLLATABLE
//  | COLLATION_CATALOG
//  | COLLATION_NAME
//  | COLLATION_SCHEMA
  | COLLECT
//  | COLUMNS
//  | COLUMN_NAME
//  | COMMAND_FUNCTION
//  | COMMAND_FUNCTION_CODE
  | COMMENT
  | COMMENTS
  | COMMIT
  | COMMITTED
//  | CONDITION
//  | CONDITION_NUMBER
  | CONFIGURATION
  | CONNECT
  | CONNECTION
//  | CONNECTION_NAME
  | CONSTRAINTS
//  | CONSTRAINT_CATALOG
//  | CONSTRAINT_NAME
//  | CONSTRAINT_SCHEMA
//  | CONSTRUCTOR
//  | CONTAINS
  | CONTENT
  | CONTINUE
//  | CONTROL
  | CONVERSION
//  | CONVERT
  | COPY
//  | CORR
//  | CORRESPONDING
  | COST
  | COUNT
//  | COVAR_POP
//  | COVAR_SAMP
  | CSV
  | CUBE
//  | CUME_DIST
  | CURRENT
//  | CURRENT_DEFAULT_TRANSFORM_GROUP
//  | CURRENT_PATH
//  | CURRENT_ROW
//  | CURRENT_TRANSFORM_GROUP_FOR_TYPE
  | CURSOR
//  | CURSOR_NAME
  | CYCLE
  | DATA
  | DATABASE
//  | DATALINK
//  | DATETIME_INTERVAL_CODE
//  | DATETIME_INTERVAL_PRECISION
  | DAY
//  | DB
  | DEALLOCATE
  | DECADE
  | DECLARE
  | DEFAULTS
  | DEFERRED
//  | DEFINED
  | DEFINER
//  | DEGREE
  | DELETE
  | DELIMITER
  | DELIMITERS
//  | DENSE_RANK
//  | DEPTH
//  | DEREF
//  | DERIVED
//  | DESCRIBE
//  | DESCRIPTOR
//  | DETERMINISTIC
//  | DIAGNOSTICS
  | DICTIONARY
  | DISABLE
  | DISCARD
//  | DISCONNECT
//  | DISPATCH
//  | DLNEWCOPY
//  | DLPREVIOUSCOPY
//  | DLURLCOMPLETE
//  | DLURLCOMPLETEONLY
//  | DLURLCOMPLETEWRITE
//  | DLURLPATH
//  | DLURLPATHONLY
//  | DLURLPATHWRITE
//  | DLURLSCHEME
//  | DLURLSERVER
//  | DLVALUE
  | DOCUMENT
  | DOMAIN
  | DOW
  | DOY
  | DROP
//  | DYNAMIC
//  | DYNAMIC_FUNCTION
//  | DYNAMIC_FUNCTION_CODE
  | EACH
  | ELEMENT
//  | EMPTY
  | ENABLE
  | ENCODING
  | ENCRYPTED
  | END_EXEC
//  | END_FRAME
//  | END_PARTITION
//  | ENFORCED
  | ENUM
  | EPOCH
//  | EQUALS
  | ESCAPE
  | EVENT
  | EVERY
//  | EXCEPTION
  | EXCLUDE
  | EXCLUDING
  | EXCLUSIVE
//  | EXEC
  | EXECUTE
//  | EXP
  | EXPLAIN
//  | EXPRESSION
  | EXTENDED
  | EXTENSION
  | EXTERNAL
  | FAMILY
//  | FILE
  | FILTER
//  | FINAL
  | FIRST
//  | FIRST_VALUE
//  | FLAG
//  | FLOOR
  | FOLLOWING
  | FORCE
  | FORCE_NOT_NULL
  | FORCE_QUOTE
  | FORMAT
//  | FORTRAN
  | FORWARD
//  | FOUND
//  | FRAME_ROW
//  | FREE
//  | FS
  | FUNCTION
  | FUNCTIONS
  | FUSION
//  | G
//  | GENERAL
//  | GENERATED
//  | GET
  | GLOBAL
//  | GO
//  | GOTO
  | GRANTED
  | GROUPING
//  | GROUPS
  | HANDLER
  | HEADER
//  | HEX
//  | HIERARCHY
  | HOLD
  | HOUR
//  | ID
  | IDENTITY
  | IF
//  | IGNORE
  | IMMEDIATE
//  | IMMEDIATELY
  | IMMUTABLE
//  | IMPLEMENTATION
  | IMPLICIT
//  | IMPORT
  | INCLUDING
  | INCREMENT
//  | INDENT
  | INDEX
  | INDEXES
//  | INDICATOR
  | INHERIT
  | INHERITS
  | INLINE
  | INPUT
  | INSENSITIVE
  | INSERT
//  | INSTANCE
//  | INSTANTIABLE
  | INSTEAD
//  | INTEGRITY
  | INTERNALLENGTH
  | INTERSECTION
  | INVOKER
  | ISCACHABLE
  | ISODOW
  | ISOLATION
  | ISOYEAR
  | ISSTRICT
//  | K
  | KEY
//  | KEY_MEMBER
//  | KEY_TYPE
  | LABEL
//  | LAG
  | LANGUAGE
  | LARGE
  | LAST
//  | LAST_VALUE
  | LC_COLLATE
  | LC_CTYPE
//  | LEAD
  | LEAKPROOF
//  | LENGTH
  | LEVEL
//  | LIBRARY
//  | LIKE_REGEX
//  | LINK
  | LISTEN
//  | LN
  | LOAD
  | LOCAL
  | LOCATION
//  | LOCATOR
  | LOCK
//  | LOWER
//  | M
  | MAIN
//  | MAP
  | MAPPING
  | MATCH
//  | MATCHED
  | MATERIALIZED
  | MAX
  | MAXVALUE
//  | MAX_CARDINALITY
//  | MEMBER
//  | MERGE
//  | MESSAGE_LENGTH
//  | MESSAGE_OCTET_LENGTH
//  | MESSAGE_TEXT
//  | METHOD
  | MICROSECONDS
  | MILLENNIUM
  | MILLISECONDS
  | MIN
  | MINUTE
  | MINVALUE
//  | MOD
  | MODE
//  | MODIFIES
//  | MODULE
  | MONTH
//  | MORE
  | MOVE
//  | MULTISET
//  | MUMPS
  | NAMES
//  | NAMESPACE
//  | NCLOB
//  | NESTING
//  | NEW
  | NEXT
//  | NFC
//  | NFD
//  | NFKC
//  | NFKD
//  | NIL
  | NO
//  | NORMALIZE
//  | NORMALIZED
  | NOTHING
  | NOTIFY
  | NOWAIT
//  | NTH_VALUE
//  | NTILE
//  | NULLABLE
  | NULLS
//  | NUMBER
  | N_DISTINCT
  | N_DISTINCT_INHERITED
  | OBJECT
//  | OCCURRENCES_REGEX
//  | OCTETS
//  | OCTET_LENGTH
  | OF
  | OFF
  | OIDS
//  | OLD
//  | OPEN
  | OPERATOR
  | OPTION
  | OPTIONS
//  | ORDERING
//  | ORDINALITY
//  | OTHERS
  | OUTPUT
//  | OVERRIDING
  | OWNED
  | OWNER
//  | P
//  | PAD
//  | PARAMETER
//  | PARAMETER_MODE
//  | PARAMETER_NAME
//  | PARAMETER_ORDINAL_POSITION
//  | PARAMETER_SPECIFIC_CATALOG
//  | PARAMETER_SPECIFIC_NAME
//  | PARAMETER_SPECIFIC_SCHEMA
  | PARSER
  | PARTIAL
  | PARTITION
//  | PASCAL
  | PASSEDBYVALUE
  | PASSING
//  | PASSTHROUGH
  | PASSWORD
//  | PATH
//  | PERCENT
//  | PERCENTILE_CONT
//  | PERCENTILE_DISC
//  | PERCENT_RANK
//  | PERIOD
//  | PERMISSION
  | PLAIN
  | PLANS
//  | PLI
//  | PORTION
//  | POSITION_REGEX
//  | POWER
//  | PRECEDES
  | PRECEDING
  | PREFERRED
  | PREPARE
  | PREPARED
  | PRESERVE
  | PRIOR
  | PRIVILEGES
  | PROCEDURAL
  | PROCEDURE
  | PROGRAM
  | PUBLIC
  | QUARTER
  | QUOTE
  | RANGE
//  | RANK
  | READ
//  | READS
  | REASSIGN
  | RECEIVE
  | RECHECK
//  | RECOVERY
  | RECURSIVE
  | REF
//  | REFERENCING
  | REFRESH
  | REGEXP
//  | REGR_AVGX
//  | REGR_AVGY
//  | REGR_COUNT
//  | REGR_INTERCEPT
//  | REGR_R2
//  | REGR_SLOPE
//  | REGR_SXX
//  | REGR_SXY
//  | REGR_SYY
  | REINDEX
  | RELATIVE
  | RELEASE
  | RENAME
  | REPEATABLE
  | REPLACE
  | REPLICA
//  | REQUIRING
  | RESET
//  | RESPECT
  | RESTART
//  | RESTORE
  | RESTRICT
//  | RESULT
//  | RETURN
//  | RETURNED_CARDINALITY
//  | RETURNED_LENGTH
//  | RETURNED_OCTET_LENGTH
//  | RETURNED_SQLSTATE
  | RETURNS
  | REVOKE
  | RLIKE
  | ROLE
  | ROLLBACK
  | ROLLUP
//  | ROUTINE
//  | ROUTINE_CATALOG
//  | ROUTINE_NAME
//  | ROUTINE_SCHEMA
  | ROWS
//  | ROW_COUNT
//  | ROW_NUMBER
  | RULE
  | SAVEPOINT
//  | SCALE
  | SCHEMA
//  | SCHEMA_NAME
//  | SCOPE
//  | SCOPE_CATALOG
//  | SCOPE_NAME
//  | SCOPE_SCHEMA
  | SCROLL
  | SEARCH
  | SECOND
//  | SECTION
  | SECURITY
//  | SELECTIVE
//  | SELF
  | SEND
//  | SENSITIVE
  | SEQUENCE
  | SEQUENCES
  | SERIALIZABLE
  | SERVER
//  | SERVER_NAME
  | SESSION
  | SET
  | SETS
  | SHARE
  | SHOW
  | SIMPLE
//  | SIZE
  | SNAPSHOT
//  | SOURCE
//  | SPACE
//  | SPECIFIC
//  | SPECIFICTYPE
//  | SPECIFIC_NAME
//  | SQL
//  | SQLCODE
//  | SQLERROR
//  | SQLEXCEPTION
//  | SQLSTATE
//  | SQLWARNING
//  | SQRT
  | STABLE
  | STANDALONE
  | START
//  | STATE
  | STATEMENT
//  | STATIC
  | STATISTICS
  | STDDEV_POP
  | STDDEV_SAMP
  | STDIN
  | STDOUT
  | STORAGE
  | STRICT
  | STRIP
//  | STRUCTURE
//  | STYLE
//  | SUBCLASS_ORIGIN
//  | SUBMULTISET
//  | SUBSTRING_REGEX
  | SUBTYPE
  | SUBTYPE_DIFF
  | SUBTYPE_OPCLASS
//  | SUCCEEDS
  | SUM
  | SYSID
  | SYSTEM
//  | SYSTEM_TIME
//  | SYSTEM_USER
//  | T
  | TABLES
//  | TABLESAMPLE
  | TABLESPACE
//  | TABLE_NAME
  | TEMP
  | TEMPLATE
  | TEMPORARY
//  | TIES
  | TIMEZONE
  | TIMEZONE_HOUR
  | TIMEZONE_MINUTE
//  | TOKEN
//  | TOP_LEVEL_COUNT
  | TRANSACTION
//  | TRANSACTIONS_COMMITTED
//  | TRANSACTIONS_ROLLED_BACK
//  | TRANSACTION_ACTIVE
//  | TRANSFORM
//  | TRANSFORMS
//  | TRANSLATE
//  | TRANSLATE_REGEX
//  | TRANSLATION
//  | TRIGGER_CATALOG
//  | TRIGGER_NAME
//  | TRIGGER_SCHEMA
//  | TRIM_ARRAY
  | TRUNCATE
  | TRUSTED
  | TYPE
  | TYPES
  | TYPMOD_IN
  | TYPMOD_OUT
//  | UESCAPE
  | UNBOUNDED
  | UNCOMMITTED
//  | UNDER
  | UNENCRYPTED
//  | UNLINK
  | UNLISTEN
  | UNLOGGED
//  | UNNAMED
//  | UNNEST
  | UNTIL
//  | UNTYPED
  | UPDATE
//  | UPPER
//  | URI
  | USAGE
//  | USER_DEFINED_TYPE_CATALOG
//  | USER_DEFINED_TYPE_CODE
//  | USER_DEFINED_TYPE_NAME
//  | USER_DEFINED_TYPE_SCHEMA
  | VACUUM
  | VALID
  | VALIDATE
  | VALIDATOR
  | VALUE
//  | VALUE_OF
  | VARIABLE
  | VAR_POP
  | VAR_SAMP
  | VERSION
//  | VERSIONING
  | VIEW
  | VOLATILE
  | WEEK
//  | WHENEVER
  | WHITESPACE
//  | WIDTH_BUCKET
//  | WITHIN
  | WITHOUT
  | WORK
  | WRAPPER
  | WRITE
//  | XMLAGG
//  | XMLBINARY
//  | XMLCAST
//  | XMLCOMMENT
//  | XMLDECLARATION
//  | XMLDOCUMENT
//  | XMLITERATE
//  | XMLNAMESPACES
//  | XMLQUERY
//  | XMLSCHEMA
//  | XMLTABLE
//  | XMLTEXT
//  | XMLVALIDATE
  | YEAR
  | YES
  | ZONE
  ;

tokens_nonreserved_types
  : BLOB
  | BOOL
  | BYTEA
  | CIDR
  | DATE
  | DOUBLE
  | FLOAT4
  | FLOAT8
  | INET
  | INET4
  | INT1
  | INT2
  | INT4
  | INT8
  | MONEY
  | NAME
  | OID
  | REGCLASS
  | REGCONFIG
  | TEXT
  | TIMESTAMPTZ
  | TIMETZ
  | TINYINT
  | TRIGGER
  | UNKNOWN
  | UUID
  | VARBINARY
  | VARBIT
  | VARYING
  | VOID
  | XML
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
  | OVER
  | OVERLAPS
  | RIGHT
  | SIMILAR
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

/*
===============================================================================
  6.1 <data types>
===============================================================================
*/

schema_qualified_name_nontype
  : identifier_nontype
  | identifier DOT identifier_nontype
  ;

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
  | (OID
  | REGCLASS
  | REGCONFIG
  | TRIGGER
  | UUID
  | VOID
  | UNKNOWN)
  | schema_qualified_name_nontype
  ;

network_type
  : CIDR
  | INET
  | INET4
  ;

character_string_type
  : NATIONAL? (CHARACTER | CHAR) VARYING? type_length?
  | NCHAR VARYING? type_length?
  | VARCHAR type_length?
  | (TEXT | NAME | XML)
  ;

type_length
  : LEFT_PAREN NUMBER_LITERAL RIGHT_PAREN
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
  | MONEY
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
  | DOUBLE PRECISION
  ;

precision_param
  : LEFT_PAREN precision=NUMBER_LITERAL (COMMA scale=NUMBER_LITERAL)? RIGHT_PAREN
  ;

boolean_type
  : BOOLEAN
  | BOOL
  ;

datetime_type
  : DATE
  | TIME type_length? ((WITH | WITHOUT) TIME ZONE)?
  | TIMETZ
  | TIMESTAMP type_length? ((WITH | WITHOUT) TIME ZONE)?
  | TIMESTAMPTZ
  | INTERVAL interval_field? type_length?
  ;

interval_field
    : primary_datetime_field
    | YEAR TO MONTH
    | DAY TO HOUR
    | DAY TO MINUTE
    | DAY TO SECOND
    | HOUR TO MINUTE
    | HOUR TO SECOND
    | MINUTE TO SECOND
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
  | vex OP_CHARS vex
  | vex OP_CHARS
  | vex NOT? (LIKE | ILIKE | SIMILAR TO) vex ESCAPE vex
  | vex NOT? (LIKE | ILIKE | SIMILAR TO) vex
  | vex NOT? IN LEFT_PAREN (select_stmt_no_parens | vex (COMMA vex)*) RIGHT_PAREN
  | vex NOT? BETWEEN (ASYMMETRIC | SYMMETRIC)? vex_b AND vex
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
  | vex_b OP_CHARS vex_b
  | vex_b OP_CHARS
  | vex_b (LTH | GTH | LEQ | GEQ | EQUAL | NOT_EQUAL) vex_b
  | vex_b IS NOT? DISTINCT FROM vex_b
  | vex_b IS NOT? DOCUMENT
  | value_expression_primary
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

truth_value
  : TRUE | FALSE | UNKNOWN | ON | OFF
  ;

case_expression
  : CASE vex? (WHEN vex THEN vex)+ (ELSE r=vex)? END
  ;

cast_specification
  : (CAST | TREAT) LEFT_PAREN vex AS data_type RIGHT_PAREN
  ;

function_call
    : schema_qualified_name LEFT_PAREN (set_qualifier? vex (COMMA vex)* orderby_clause?)? RIGHT_PAREN
        filter_clause? (OVER window_definition)?
    | extract_function
    | system_function
    | date_time_function
    | string_value_function
    | xml_function
    ;

extract_function
  : EXTRACT LEFT_PAREN extract_field_string=extract_field FROM vex RIGHT_PAREN
  ;

extract_field
  : primary_datetime_field
  | time_zone_field
  | extended_datetime_field
  ;

primary_datetime_field
    : YEAR | MONTH | DAY | HOUR | MINUTE | SECOND
    ;

extended_datetime_field
  : CENTURY | DECADE | DOW | DOY | EPOCH | ISODOW | ISOYEAR | MICROSECONDS | MILLENNIUM | MILLISECONDS | QUARTER | WEEK
  ;

time_zone_field
  : TIMEZONE | TIMEZONE_HOUR | TIMEZONE_MINUTE
  ;

system_function
    : CURRENT_CATALOG
    | CURRENT_SCHEMA (LEFT_PAREN RIGHT_PAREN)?
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
  : TRIM LEFT_PAREN (LEADING | TRAILING | BOTH)? vex? FROM? vex RIGHT_PAREN
  | SUBSTRING LEFT_PAREN vex (FROM vex)? (FOR vex)? RIGHT_PAREN
  | POSITION LEFT_PAREN vex_b IN vex RIGHT_PAREN
  | OVERLAY LEFT_PAREN vex PLACING vex FROM vex (FOR vex)? RIGHT_PAREN
  ;

xml_function
    : XMLELEMENT LEFT_PAREN NAME name=identifier
        (COMMA XMLATTRIBUTES LEFT_PAREN vex (AS attname=identifier)? (COMMA vex (AS attname=identifier)?)* RIGHT_PAREN)?
        (vex (COMMA vex)?)? RIGHT_PAREN
    | XMLFOREST LEFT_PAREN vex (AS name=identifier)? (COMMA vex (AS name=identifier)?)* RIGHT_PAREN
    | XMLPI LEFT_PAREN NAME name=identifier (COMMA vex)? RIGHT_PAREN
    | XMLROOT LEFT_PAREN vex COMMA VERSION (vex | NO VALUE) (COMMA STANDALONE (YES | NO | NO VALUE))? RIGHT_PAREN
    | XMLEXISTS LEFT_PAREN vex PASSING (BY REF)? vex (BY REF)? RIGHT_PAREN
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
