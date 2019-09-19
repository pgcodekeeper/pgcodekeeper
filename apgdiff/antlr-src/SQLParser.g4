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
    : BOM? SEMI_COLON* (statement (SEMI_COLON+ | EOF))* EOF
    ;

qname_parser
    : schema_qualified_name EOF
    ;

function_args_parser
    : schema_qualified_name? function_args EOF
    ;

operator_args_parser
    : target_operator EOF
    ;

object_identity_parser
    : name=identifier ON parent=schema_qualified_name EOF
    ;

vex_eof
    : vex (COMMA vex)* EOF
    ;

plpgsql_function
    : comp_options? function_block SEMI_COLON? EOF
    ;

plpgsql_function_test_list
    : (comp_options? function_block SEMI_COLON)* EOF
    ;

/******* END Start symbols *******/

statement
    : data_statement
    | schema_statement
    | script_statement
    ;

data_statement
    : select_stmt
    | insert_stmt_for_psql
    | update_stmt_for_psql
    | delete_stmt_for_psql
    | notify_stmt
    | truncate_stmt
    ;

script_statement
    : script_transaction
    | script_additional
    ;

script_transaction
    : (START TRANSACTION | BEGIN (WORK | TRANSACTION)?) (transaction_mode (COMMA transaction_mode)*)?
    | (COMMIT | END) (WORK | TRANSACTION)?
    | (COMMIT PREPARED | PREPARE TRANSACTION) Character_String_Literal
    | (SAVEPOINT | RELEASE SAVEPOINT?) identifier
    | ROLLBACK (PREPARED Character_String_Literal | (WORK | TRANSACTION)? (TO SAVEPOINT? identifier)?)
    | lock_table
    | ABORT (WORK | TRANSACTION)?
    ;

transaction_mode
    : ISOLATION LEVEL (SERIALIZABLE | REPEATABLE READ | READ COMMITTED | READ UNCOMMITTED)
    | READ WRITE | READ ONLY
    | (NOT)? DEFERRABLE
    ;

lock_table
    : LOCK TABLE? only_table_multiply (COMMA only_table_multiply)*
     (IN lock_mode MODE)? NOWAIT?
    ;

lock_mode
    : (ROW | ACCESS) SHARE
    | ROW EXCLUSIVE
    | SHARE (ROW | UPDATE) EXCLUSIVE
    | SHARE
    | ACCESS? EXCLUSIVE
    ;

script_additional
    : anonymous_block
    | LISTEN identifier
    | UNLISTEN (identifier | MULTIPLY)
    | ANALYZE VERBOSE? table_cols_list?
    | CLUSTER VERBOSE? (identifier (ON schema_qualified_name | USING identifier)?)?
    | VACUUM (LEFT_PAREN vacuum_mode (COMMA vacuum_mode)* RIGHT_PAREN | vacuum_mode+)? table_cols_list?
    | SHOW (identifier | ALL)
    | CHECKPOINT
    | LOAD Character_String_Literal
    | DISCARD (ALL | PLANS | SEQUENCES | TEMPORARY | TEMP)
    | DEALLOCATE PREPARE? (identifier | ALL)
    | (FETCH | MOVE) fetch_move_direction? (FROM | IN)? identifier
    | CLOSE (identifier | ALL)
    | CALL function_call
    | REINDEX (LEFT_PAREN VERBOSE RIGHT_PAREN)? (INDEX | TABLE | SCHEMA | DATABASE | SYSTEM) identifier
    | RESET (identifier | TIME ZONE | SESSION AUTHORIZATION | ALL)
    | DECLARE identifier BINARY? INSENSITIVE? (NO? SCROLL)? CURSOR ((WITH | WITHOUT) HOLD)? FOR select_stmt
    | EXPLAIN (ANALYZE? VERBOSE? | (LEFT_PAREN explain_option (COMMA explain_option)* RIGHT_PAREN)) statement
    | REFRESH MATERIALIZED VIEW CONCURRENTLY? schema_qualified_name (WITH NO? DATA)?
    | PREPARE identifier (LEFT_PAREN data_type (COMMA data_type)* RIGHT_PAREN)? AS data_statement
    | EXECUTE identifier (LEFT_PAREN vex (COMMA vex)* RIGHT_PAREN)?
    | REASSIGN OWNED BY user_identifer_current_session (COMMA user_identifer_current_session)*
      TO user_identifer_current_session
    | copy_statement
    ;

explain_option
    : (ANALYZE | VERBOSE | COSTS | BUFFERS | TIMING | SUMMARY) (TRUE | FALSE | OFF | ON)?
    | FORMAT (TEXT | XML | JSON | YAML)
    ;

user_identifer_current_session
    : name = identifier | CURRENT_USER | SESSION_USER
    ;

table_cols_list
    : table_cols (COMMA table_cols)*
    ;

table_cols
    : schema_qualified_name (LEFT_PAREN identifier (COMMA identifier)* RIGHT_PAREN)?
    ;

vacuum_mode
    : FULL
    | FREEZE
    | VERBOSE
    | ANALYZE
    | DISABLE_PAGE_SKIPPING
    ;

fetch_move_direction
    : NEXT
    | PRIOR
    | FIRST
    | LAST
    | (ABSOLUTE | RELATIVE)? signed_number_literal
    | ALL
    | FORWARD (NUMBER_LITERAL | ALL)?
    | BACKWARD (NUMBER_LITERAL | ALL)?
    ;

schema_statement
    : schema_create
    | schema_alter
    | schema_drop
    ;

schema_create
    : CREATE (create_table_statement
    | create_foreign_table_statement
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
    | create_server_statement
    | create_fts_configuration
    | create_fts_template
    | create_fts_parser
    | create_fts_dictionary
    | create_collation
    | create_user_mapping
    | create_transform_statement
    | create_access_method
    | create_user_or_role
    | create_group
    | create_tablespace
    | create_statistics
    | create_foreign_data_wrapper
    | create_operator_statement
    | create_aggregate_statement
    | create_table_as_statement
    | create_policy_statement
    | create_subscription_statement
    | create_cast_statement
    | create_operator_family_statement
    | create_operator_class_statement
    | create_conversion_statement
    | create_publication_statement)

    | comment_on_statement
    | rule_common
    | set_statement
    | schema_import
    | security_label
    ;

schema_alter
    : ALTER (alter_function_statement
    | alter_schema_statement
    | alter_language_statement
    | alter_table_statement
    | alter_index_statement
    | alter_default_privileges
    | alter_sequence_statement
    | alter_view_statement
    | alter_event_trigger
    | alter_type_statement
    | alter_domain_statement
    | alter_server_statement
    | alter_fts_statement
    | alter_collation
    | alter_user_mapping
    | alter_user_or_role
    | alter_group
    | alter_tablespace
    | alter_statistics
    | alter_foreign_data_wrapper
    | alter_operator_statement
    | alter_aggregate_statement
    | alter_extension_statement
    | alter_policy_statement
    | alter_subscription_statement
    | alter_trigger_statement
    | alter_rule_statement
    | alter_operator_family_statement
    | alter_operator_class_statement
    | alter_conversion_statement
    | alter_publication_statement
    | alter_owner)
    ;

schema_drop
    : DROP (drop_function_statement
    | drop_trigger_statement
    | drop_rule_statement
    | drop_policy_statement
    | drop_cast_statement
    | drop_operator_family_statement
    | drop_operator_class_statement
    | drop_statements
    | drop_user_mapping
    | drop_owned
    | drop_operator_statement)
    ;

schema_import
    : IMPORT FOREIGN SCHEMA schema_name_remote=identifier
    ((LIMIT TO | EXCEPT)
    LEFT_PAREN (table_name+=identifier (COMMA table_name+=identifier)*) RIGHT_PAREN)?
    FROM SERVER server_name=identifier INTO schema_name_local=identifier
    define_foreign_options?
    ;

alter_function_statement
    : (FUNCTION | PROCEDURE) function_parameters?
      ((function_actions_common | RESET (configuration_parameter=identifier | ALL))+ RESTRICT?
    | rename_to
    | set_schema
    | DEPENDS ON EXTENSION identifier)
    ;

alter_aggregate_statement
    : AGGREGATE function_parameters (rename_to | set_schema)
    ;

alter_extension_statement
    : EXTENSION identifier alter_extension_action
    ;

alter_extension_action
    : set_schema
    | UPDATE (TO (identifier | character_string))?
    | (ADD | DROP) extension_member_object
    ;

extension_member_object
    : ACCESS METHOD schema_qualified_name
    | AGGREGATE function_parameters
    | CAST LEFT_PAREN schema_qualified_name AS schema_qualified_name RIGHT_PAREN
    | COLLATION identifier
    | CONVERSION identifier
    | DOMAIN schema_qualified_name
    | EVENT TRIGGER identifier
    | FOREIGN DATA WRAPPER identifier
    | FOREIGN TABLE schema_qualified_name
    | FUNCTION function_parameters
    | MATERIALIZED? VIEW schema_qualified_name
    | OPERATOR operator_name
    | OPERATOR CLASS schema_qualified_name USING identifier
    | OPERATOR FAMILY schema_qualified_name USING identifier
    | PROCEDURAL? LANGUAGE identifier
    | PROCEDURE function_parameters
    | ROUTINE function_parameters
    | SCHEMA identifier
    | SEQUENCE schema_qualified_name
    | SERVER identifier
    | TABLE schema_qualified_name
    | TEXT SEARCH CONFIGURATION schema_qualified_name
    | TEXT SEARCH DICTIONARY schema_qualified_name
    | TEXT SEARCH PARSER schema_qualified_name
    | TEXT SEARCH TEMPLATE schema_qualified_name
    | TRANSFORM FOR identifier LANGUAGE identifier
    | TYPE schema_qualified_name
    ;

alter_schema_statement
    : schema_with_name rename_to
    ;

alter_language_statement
    : PROCEDURAL? LANGUAGE name=identifier (rename_to | owner_to)
    ;

alter_table_statement
    : FOREIGN? TABLE (IF EXISTS)? ONLY? name=schema_qualified_name MULTIPLY?(
        (table_action (COMMA table_action)*
        | RENAME COLUMN? column=schema_qualified_name TO new_column=schema_qualified_name)
    | set_schema
    | rename_to
    | RENAME CONSTRAINT identifier TO identifier
    | ATTACH PARTITION child=schema_qualified_name for_values_bound
    | DETACH PARTITION child=schema_qualified_name)
    ;

table_action
    : ADD COLUMN? if_not_exists? table_column_definition
    | DROP COLUMN? (IF EXISTS)? column=schema_qualified_name cascade_restrict?
    | ALTER COLUMN? column=schema_qualified_name
      ((SET DATA)? TYPE datatype=data_type collate_identifier? (USING expression=vex)?
      | (set_def_column
        | drop_def
        | ((set=SET | DROP) NOT NULL)
        | SET STATISTICS signed_number_literal
        | set_attribute_option
        | define_foreign_options
        | RESET storage_parameter
        | set_storage
        | ADD identity_body
        | alter_identity+
        | DROP IDENTITY (IF EXISTS)?
        ))
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
    | define_foreign_options
    | INHERIT parent_table=schema_qualified_name
    | NO INHERIT parent_table=schema_qualified_name
    | OF type_name=schema_qualified_name
    | NOT OF
    | owner_to
    | SET table_space
    | REPLICA IDENTITY (DEFAULT | FULL | NOTHING | USING INDEX identifier)
    | ALTER CONSTRAINT identifier table_deferrable? table_initialy_immed?
    ;

identity_body
    : GENERATED (ALWAYS | BY DEFAULT) AS IDENTITY (LEFT_PAREN sequence_body+ RIGHT_PAREN)?
    ;

alter_identity
    : SET GENERATED (ALWAYS | BY DEFAULT)
    | SET sequence_body
    | RESTART (WITH? restart=NUMBER_LITERAL)?
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
    : DROP CONSTRAINT (IF EXISTS)? constraint_name=identifier cascade_restrict?
    ;

table_deferrable
    : (NOT)? DEFERRABLE
    ;

table_initialy_immed
    : INITIALLY (DEFERRED | IMMEDIATE)
    ;

function_actions_common
    : (CALLED | RETURNS NULL) ON NULL INPUT
    | TRANSFORM transform_for_type (COMMA transform_for_type)*
    | STRICT
    | IMMUTABLE
    | VOLATILE
    | STABLE
    | NOT? LEAKPROOF
    | (EXTERNAL)? SECURITY (INVOKER | DEFINER)
    | PARALLEL (SAFE | UNSAFE | RESTRICTED)
    | COST execution_cost=unsigned_numeric_literal
    | ROWS result_rows=unsigned_numeric_literal
    | SET configuration_parameter=identifier (((TO | EQUAL) value+=set_statement_value) | FROM CURRENT)(COMMA value+=set_statement_value)*
    | LANGUAGE lang_name=identifier
    | WINDOW
    | AS function_def
    ;

function_def
    : character_string (COMMA character_string)*
    ;

alter_index_statement
    : index_def
    | index_all_def
    ;

index_def
    : index_if_exists_name index_def_action
    ;

index_if_exists_name
    : INDEX (IF EXISTS)? schema_qualified_name
    ;

index_def_action
    : rename_to
    | ATTACH PARTITION index=schema_qualified_name
    | DEPENDS ON EXTENSION extension=schema_qualified_name
    | ALTER COLUMN? sign? NUMBER_LITERAL SET STATISTICS signed_number_literal
    | RESET LEFT_PAREN name+=identifier (COMMA name+=identifier)* RIGHT_PAREN
    | SET (TABLESPACE tbl_spc=identifier | LEFT_PAREN option_with_value (COMMA option_with_value)* RIGHT_PAREN)
    ;

index_all_def
    : INDEX ALL IN TABLESPACE tbl_spc=identifier (OWNED BY rolname+=identifier (COMMA rolname+=identifier)*)?
      SET TABLESPACE new_tbl_spc=identifier NOWAIT?
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

    | (USAGE | CREATE | ALL PRIVILEGES?)
        ON SCHEMAS

    | (USAGE | ALL PRIVILEGES?)
        ON TYPES)
        (grant_to_rule | revoke_from_cascade_restrict)
    ;

grant_option_for
    : GRANT OPTION FOR
    ;

alter_sequence_statement
    : SEQUENCE (IF EXISTS)? name=schema_qualified_name
     ( (sequence_body | RESTART (WITH? restart=signed_number_literal)?)*
    | set_schema
    | rename_to)
    ;

alter_view_statement
    : MATERIALIZED? VIEW (IF EXISTS)? name=schema_qualified_name
     (ALTER COLUMN? column_name=schema_qualified_name  (set_def_column | drop_def)
    | set_schema
    | rename_to
    | SET LEFT_PAREN view_option_name=identifier (EQUAL view_option_value=vex)?(COMMA view_option_name=identifier (EQUAL view_option_value=vex)?)*  RIGHT_PAREN
    | RESET LEFT_PAREN view_option_name=identifier (COMMA view_option_name=identifier)*  RIGHT_PAREN)
    ;

alter_event_trigger
    : EVENT TRIGGER name=identifier alter_event_trigger_action
    ;

alter_event_trigger_action
    : DISABLE
    | ENABLE (REPLICA | ALWAYS)?
    | owner_to
    | rename_to
    ;

alter_type_statement
    : TYPE name=schema_qualified_name
      (set_schema
      | rename_to
      | ADD VALUE if_not_exists? new_enum_value=character_string ((BEFORE | AFTER) existing_enum_value=character_string)?
      | RENAME ATTRIBUTE attribute_name=identifier TO new_attribute_name=identifier cascade_restrict?
      | RENAME VALUE existing_enum_name=character_string TO new_enum_name=character_string
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
    | rename_to
    | set_schema)
    ;

alter_server_statement
    : SERVER identifier alter_server_action
    ;

alter_server_action
    : (VERSION character_string)? define_foreign_options
    | VERSION character_string
    | owner_to
    | rename_to
    ;

alter_fts_statement
    : TEXT SEARCH
    ((TEMPLATE | DICTIONARY | CONFIGURATION | PARSER) name=schema_qualified_name (rename_to | set_schema)
    | DICTIONARY name=schema_qualified_name storage_parameter
    | CONFIGURATION name=schema_qualified_name alter_fts_configuration)
    ;

alter_fts_configuration
    : (ADD | ALTER) MAPPING FOR types+=identifier (COMMA types+=identifier)*
    WITH dictionaries+=schema_qualified_name (COMMA dictionaries+=schema_qualified_name)*
    | ALTER MAPPING (FOR identifier (COMMA identifier))? REPLACE schema_qualified_name WITH schema_qualified_name
    | DROP MAPPING (IF EXISTS)? FOR identifier (COMMA identifier)*
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
    : unique_value=UNIQUE? INDEX CONCURRENTLY? if_not_exists? name=identifier? ON ONLY? table_name=schema_qualified_name
        index_rest
    ;

index_rest
    : (USING method=identifier)? index_sort including_index? with_storage_parameter? table_space? index_where?
    ;

index_sort
    : LEFT_PAREN sort_specifier_list RIGHT_PAREN
    ;

including_index
    : INCLUDE LEFT_PAREN identifier (COMMA identifier)* RIGHT_PAREN
    ;

index_where
    : WHERE vex
    ;

 create_extension_statement
    : EXTENSION if_not_exists? name=identifier WITH?
         schema_with_name? (VERSION version=unsigned_value_specification)? (FROM old_version=unsigned_value_specification)?
    ;

create_language_statement
    : (OR REPLACE)? TRUSTED? PROCEDURAL? LANGUAGE name=identifier
        (HANDLER call_handler=schema_qualified_name (INLINE inline_handler=schema_qualified_name)? (VALIDATOR valfunction=schema_qualified_name)?)?
    ;

create_event_trigger
    : EVENT TRIGGER name=identifier ON event=identifier
        (WHEN (filter_variable=schema_qualified_name IN
            LEFT_PAREN
                filter_value+=character_string (COMMA filter_value+=character_string)*
            RIGHT_PAREN AND?)+ )?
        EXECUTE (PROCEDURE | FUNCTION) funct_name=vex
    ;

create_type_statement
    : TYPE name=schema_qualified_name (AS(
        LEFT_PAREN (attrs+=table_column_definition (COMMA attrs+=table_column_definition)*)? RIGHT_PAREN
        | ENUM LEFT_PAREN ( enums+=character_string (COMMA enums+=character_string)* )? RIGHT_PAREN
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
            | CATEGORY EQUAL category=character_string
            | PREFERRED EQUAL preferred=truth_value
            | DEFAULT EQUAL default_value=vex
            | ELEMENT EQUAL element=data_type
            | DELIMITER EQUAL delimiter=character_string
            | COLLATABLE EQUAL collatable=truth_value))*
        RIGHT_PAREN)?
    ;

create_domain_statement
    : DOMAIN name=schema_qualified_name (AS)? dat_type=data_type
      (collate_identifier
      | DEFAULT def_value=vex
      | dom_constraint+=domain_constraint)*
    ;

create_server_statement
    : SERVER if_not_exists? identifier (TYPE character_string)? (VERSION character_string)?
    FOREIGN DATA WRAPPER identifier
    define_foreign_options?
    ;

create_fts_dictionary
    : TEXT SEARCH DICTIONARY name=schema_qualified_name
    LEFT_PAREN
        TEMPLATE EQUAL template=schema_qualified_name (COMMA option_with_value)*
    RIGHT_PAREN
    ;

option_with_value
    : name=identifier EQUAL value=vex
    ;

create_fts_configuration
    : TEXT SEARCH CONFIGURATION name=schema_qualified_name
    LEFT_PAREN
        (PARSER EQUAL parser_name=schema_qualified_name
        | COPY EQUAL config_name=schema_qualified_name)
    RIGHT_PAREN
    ;

create_fts_template
    : TEXT SEARCH TEMPLATE name=schema_qualified_name
    LEFT_PAREN
        (INIT EQUAL init_name=schema_qualified_name COMMA)?
        LEXIZE EQUAL lexize_name=schema_qualified_name
        (COMMA INIT EQUAL init_name=schema_qualified_name)?
    RIGHT_PAREN
    ;

create_fts_parser
    : TEXT SEARCH PARSER name=schema_qualified_name
    LEFT_PAREN
        START EQUAL start_func=schema_qualified_name COMMA
        GETTOKEN EQUAL gettoken_func=schema_qualified_name COMMA
        END EQUAL end_func=schema_qualified_name COMMA
        (HEADLINE EQUAL headline_func=schema_qualified_name COMMA)?
        LEXTYPES EQUAL lextypes_func=schema_qualified_name
        (COMMA HEADLINE EQUAL headline_func=schema_qualified_name)?
    RIGHT_PAREN
    ;

create_collation
    : COLLATION if_not_exists? name=schema_qualified_name
      (FROM copy=schema_qualified_name | LEFT_PAREN (collation_option (COMMA collation_option)*)? RIGHT_PAREN)
    ;

alter_collation
    : COLLATION name=schema_qualified_name (REFRESH VERSION | rename_to | owner_to | set_schema)
    ;

collation_option
    : (LOCALE | LC_COLLATE | LC_CTYPE | PROVIDER | VERSION) EQUAL (character_string | identifier)
    ;

create_user_mapping
    : USER MAPPING if_not_exists? FOR (identifier | USER | CURRENT_USER | SESSION_USER)
    SERVER identifier
    define_foreign_options?
    ;

alter_user_mapping
    : USER MAPPING FOR (identifier | USER | CURRENT_USER | SESSION_USER) SERVER identifier
    define_foreign_options?
    ;

alter_user_or_role
    : (USER | ROLE) (alter_user_or_role_set_reset
        | old_name=identifier rename_to
        | user_identifer_current_session WITH? user_or_role_option_for_alter+)
    ;

alter_user_or_role_set_reset
    : (user_identifer_current_session | ALL) (IN DATABASE db_name=identifier)? user_or_role_set_reset
    ;

user_or_role_set_reset
    : SET config_param=identifier (TO | EQUAL) config_param_val=set_statement_value
    | SET config_param=identifier FROM CURRENT
    | RESET config_param=identifier
    | RESET ALL
    ;

alter_group
    : GROUP alter_group_action
    ;

alter_group_action
    : name=identifier rename_to
    | user_identifer_current_session (ADD | DROP)
        USER user_name+=identifier (COMMA user_name+=identifier)*
    ;

alter_tablespace
    : TABLESPACE name=identifier alter_tablespace_action
    ;

alter_owner
    : (OPERATOR target_operator
    | (FUNCTION | PROCEDURE | AGGREGATE) name=schema_qualified_name function_args
    | (TEXT SEARCH DICTIONARY | TEXT SEARCH CONFIGURATION | DOMAIN | SCHEMA | SEQUENCE | TYPE | MATERIALIZED? VIEW)
    (IF EXISTS)? name=schema_qualified_name) owner_to
    ;

alter_tablespace_action
    : rename_to
    | owner_to
    | SET LEFT_PAREN tablespace_option=identifier EQUAL value=vex
            (COMMA tablespace_option=identifier EQUAL value=vex)* RIGHT_PAREN
    | RESET LEFT_PAREN tablespace_option=identifier
            (COMMA tablespace_option=identifier)* RIGHT_PAREN
    ;

alter_statistics
    : STATISTICS name=schema_qualified_name (rename_to
        | SET SCHEMA schema_name=identifier
        | owner_to)
    ;

alter_foreign_data_wrapper
    : FOREIGN DATA WRAPPER name=identifier alter_foreign_data_wrapper_action
    ;

alter_foreign_data_wrapper_action
    : alter_foreign_data_wrapper_handler_validator_option
    | owner_to
    | rename_to
    ;

alter_foreign_data_wrapper_handler_validator_option
    : (HANDLER handler_function=identifier | NO HANDLER )?
    (VALIDATOR validator_function=identifier | NO VALIDATOR)?
    define_foreign_options?
    ;

alter_operator_statement
    : OPERATOR target_operator alter_operator_action
    ;

alter_operator_action
    : set_schema
    | SET LEFT_PAREN operator_set_restrict_join (COMMA operator_set_restrict_join)* RIGHT_PAREN
    ;

operator_set_restrict_join
    : (RESTRICT | JOIN) EQUAL restr_join_name=schema_qualified_name
    ;

drop_user_mapping
    : USER MAPPING (IF EXISTS)? FOR (identifier | USER | CURRENT_USER | SESSION_USER) SERVER identifier
    ;

drop_owned
    : OWNED BY user_identifer_current_session (COMMA user_identifer_current_session)*
      cascade_restrict?
    ;

drop_operator_statement
    : OPERATOR (IF EXISTS)? target_operator (COMMA target_operator)* cascade_restrict?
    ;

target_operator
    : name=operator_name LEFT_PAREN (left_type=data_type | NONE) COMMA (right_type=data_type | NONE) RIGHT_PAREN
    ;

domain_constraint
    : (CONSTRAINT name=identifier)? (CHECK LEFT_PAREN expression=vex RIGHT_PAREN | NOT? NULL)
    ;

create_transform_statement
    : (OR REPLACE)? TRANSFORM FOR data_type LANGUAGE identifier
    LEFT_PAREN
        FROM SQL WITH FUNCTION  function_parameters COMMA
        TO SQL WITH FUNCTION function_parameters
    RIGHT_PAREN
    ;

create_access_method
    : ACCESS METHOD name=identifier TYPE type=identifier HANDLER func_name=schema_qualified_name
    ;

create_user_or_role
    : (USER | ROLE) name=identifier (WITH? user_or_role_option user_or_role_option*)?
    ;

user_or_role_option
    : user_or_role_or_group_common_option
    | user_or_role_common_option
    | user_or_role_or_group_option_for_create
    ;

user_or_role_option_for_alter
    : user_or_role_or_group_common_option
    | user_or_role_common_option
    ;

user_or_role_or_group_common_option
    : SUPERUSER | NOSUPERUSER
    | CREATEDB | NOCREATEDB
    | CREATEROLE | NOCREATEROLE
    | INHERIT | NOINHERIT
    | LOGIN | NOLOGIN
    | ENCRYPTED? PASSWORD (password=Character_String_Literal | NULL)
    | VALID UNTIL date_time=Character_String_Literal
    ;

user_or_role_common_option
    : REPLICATION | NOREPLICATION
    | BYPASSRLS | NOBYPASSRLS
    | CONNECTION LIMIT signed_number_literal
    ;

user_or_role_or_group_option_for_create
    : SYSID vex
    | (IN ROLE | IN GROUP | ROLE | ADMIN | USER) option_role_name+=identifier
        (COMMA option_role_name+=identifier)*
    ;

create_group
    : GROUP name=identifier (WITH? group_option+)?
    ;

group_option
    : user_or_role_or_group_common_option
    | user_or_role_or_group_option_for_create
    ;

create_tablespace
    : TABLESPACE name=identifier (OWNER user_identifer_current_session)?
    LOCATION directory=Character_String_Literal
    (WITH LEFT_PAREN option_with_value (COMMA option_with_value)* RIGHT_PAREN)?
    ;

create_statistics
    : STATISTICS if_not_exists? name=schema_qualified_name
    (LEFT_PAREN statistisc_type+=identifier (COMMA statistisc_type+=identifier)* RIGHT_PAREN)?
    ON table_column+=identifier COMMA table_column+=identifier (COMMA table_column+=identifier)*
    FROM table_name=schema_qualified_name
    ;

create_foreign_data_wrapper
    : FOREIGN DATA WRAPPER name=identifier (HANDLER handler_function=identifier | NO HANDLER )?
    (VALIDATOR validator_function=identifier | NO VALIDATOR)?
    (OPTIONS LEFT_PAREN option_without_equal (COMMA option_without_equal)* RIGHT_PAREN )?
    ;

option_without_equal
    : name=identifier value=Character_String_Literal
    ;

create_operator_statement
    : OPERATOR name=operator_name LEFT_PAREN operator_option (COMMA operator_option)* RIGHT_PAREN
    ;

operator_name
    : (schema_name=identifier DOT)? operator=all_simple_op
    ;

operator_option
    : (FUNCTION | PROCEDURE) EQUAL func_name=schema_qualified_name
    | RESTRICT EQUAL restr_name=schema_qualified_name
    | JOIN EQUAL join_name=schema_qualified_name
    | (LEFTARG | RIGHTARG) EQUAL type=data_type
    | (COMMUTATOR | NEGATOR) EQUAL addition_oper_name=all_op_ref
    | HASHES
    | MERGES
    ;

create_aggregate_statement
    : AGGREGATE name=schema_qualified_name function_args? LEFT_PAREN
    (BASETYPE EQUAL base_type=data_type COMMA)?
    SFUNC EQUAL sfunc_name=schema_qualified_name COMMA
    STYPE EQUAL type=data_type
    (COMMA aggregate_param)*
    RIGHT_PAREN
    ;

aggregate_param
    : SSPACE EQUAL s_space=NUMBER_LITERAL
    | FINALFUNC EQUAL final_func=schema_qualified_name
    | FINALFUNC_EXTRA
    | FINALFUNC_MODIFY EQUAL (READ_ONLY | SHAREABLE | READ_WRITE)
    | COMBINEFUNC EQUAL combine_func=schema_qualified_name
    | SERIALFUNC EQUAL serial_func=schema_qualified_name
    | DESERIALFUNC EQUAL deserial_func=schema_qualified_name
    | INITCOND EQUAL init_cond=vex
    | MSFUNC EQUAL ms_func=schema_qualified_name
    | MINVFUNC EQUAL minv_func=schema_qualified_name
    | MSTYPE EQUAL ms_type=data_type
    | MSSPACE EQUAL ms_space=NUMBER_LITERAL
    | MFINALFUNC EQUAL mfinal_func=schema_qualified_name
    | MFINALFUNC_EXTRA
    | MFINALFUNC_MODIFY EQUAL (READ_ONLY | SHAREABLE | READ_WRITE)
    | MINITCOND EQUAL minit_cond=vex
    | SORTOP EQUAL all_op_ref
    | PARALLEL EQUAL (SAFE | RESTRICTED | UNSAFE)
    | HYPOTHETICAL
    ;

set_statement
    : SET set_action
    ;

set_action
    : CONSTRAINTS (ALL | (constr_name+=schema_qualified_name (COMMA constr_name+=schema_qualified_name)*)) (DEFERRED | IMMEDIATE)
    | TRANSACTION (transaction_mode (COMMA transaction_mode)* | SNAPSHOT snapshot_id=Character_String_Literal)
    | SESSION CHARACTERISTICS AS TRANSACTION transaction_mode (COMMA transaction_mode)*
    | (SESSION | LOCAL)? session_local_option
    | XML OPTION (DOCUMENT | CONTENT)
    ;

session_local_option
    : SESSION AUTHORIZATION (name=Character_String_Literal | identifier |DEFAULT)
    | TIME ZONE (timezone=Character_String_Literal | signed_numerical_literal | LOCAL | DEFAULT)
    | config_param=identifier (TO | EQUAL) config_param_val+=set_statement_value (COMMA config_param_val+=set_statement_value)*
    | ROLE (identifier | NONE)
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
    (((insert_true=INSERT | delete_true=DELETE | truncate_true=TRUNCATE) 
    | update_true=UPDATE (OF columns_list)?)OR?)+
    ON table_name=schema_qualified_name
    (FROM referenced_table_name=schema_qualified_name)?
    table_deferrable? table_initialy_immed?
    (REFERENCING trigger_referencing trigger_referencing?)?
    (for_each_true=FOR EACH? (ROW | STATEMENT))?
    when_trigger?
    EXECUTE (FUNCTION | PROCEDURE) func_name=function_call
    ;

columns_list
    : name+=identifier (COMMA name+=identifier)*
    ;

trigger_referencing
    : (OLD | NEW) TABLE AS? transition_relation_name=identifier
    ;

when_trigger
    : WHEN LEFT_PAREN when_expr=vex RIGHT_PAREN
    ;

rule_common
    : (GRANT | REVOKE grant_opt_for=grant_option_for?)
    (permissions | columns_permissions)
    ON rule_member_object
    (TO | FROM) roles_names (WITH GRANT OPTION | cascade_restrict)?
    | other_rules
    ;

rule_member_object
    : TABLE? table_names=names_references
    | SEQUENCE names_references
    | DATABASE names_references
    | DOMAIN names_references
    | FOREIGN DATA WRAPPER names_references
    | FOREIGN SERVER names_references
    | (FUNCTION | PROCEDURE | ROUTINE) func_name+=function_parameters (COMMA func_name+=function_parameters)*
    | LARGE OBJECT unsigned_numeric_literal (COMMA unsigned_numeric_literal)*
    | LANGUAGE names_references
    | SCHEMA schema_names=names_references
    | TABLESPACE names_references
    | TYPE names_references
    | ALL (TABLES | SEQUENCES | FUNCTIONS | PROCEDURES | ROUTINES) IN SCHEMA names_references
    ;

columns_permissions
    : table_column_privileges (COMMA table_column_privileges)*
    ;

table_column_privileges
    : table_column_privilege LEFT_PAREN column+=identifier (COMMA column+=identifier)* RIGHT_PAREN
    ;

permissions
    : permission (COMMA permission)*
    ;

permission
    : ALL PRIVILEGES?
    | CONNECT
    | CREATE
    | DELETE
    | EXECUTE
    | INSERT
    | UPDATE
    | REFERENCES
    | SELECT
    | TEMP
    | TRIGGER
    | TRUNCATE
    | USAGE
    ;

other_rules
    : GRANT obj_name=names_references TO role_name=names_references (WITH ADMIN OPTION)?
    | REVOKE (ADMIN OPTION FOR)? obj_name=names_references FROM role_name=names_references cascade_restrict?
    ;

grant_to_rule
    : TO roles_names (WITH GRANT OPTION)?
    ;

revoke_from_cascade_restrict
    : FROM roles_names cascade_restrict?
    ;

roles_names
    : role_name_with_group (COMMA role_name_with_group)*
    ;

role_name_with_group
    : GROUP? role_name=identifier | CURRENT_USER | SESSION_USER
    ;

comment_on_statement
    : COMMENT ON comment_member_object IS (comment_text=character_string | NULL)
    ;

security_label
    : SECURITY LABEL (FOR (identifier | character_string))? ON label_member_object IS (label=character_string | NULL)
    ;

comment_member_object
    : ACCESS METHOD identifier 
    | (AGGREGATE | PROCEDURE | FUNCTION | ROUTINE) name=schema_qualified_name function_args
    | CAST LEFT_PAREN source_type=data_type AS target_type=data_type RIGHT_PAREN
    | COLLATION identifier
    | COLUMN name=schema_qualified_name
    | CONSTRAINT identifier ON DOMAIN? table_name=schema_qualified_name
    | CONVERSION name=schema_qualified_name
    | DATABASE identifier
    | DOMAIN name=schema_qualified_name
    | EXTENSION identifier
    | EVENT TRIGGER identifier
    | FOREIGN DATA WRAPPER identifier
    | FOREIGN? TABLE name=schema_qualified_name
    | INDEX name=schema_qualified_name
    | LARGE OBJECT unsigned_numeric_literal
    | MATERIALIZED? VIEW name=schema_qualified_name
    | OPERATOR target_operator
    | OPERATOR (FAMILY| CLASS) name=schema_qualified_name USING index_method=identifier
    | POLICY identifier ON name=schema_qualified_name
    | PROCEDURAL? LANGUAGE name=schema_qualified_name
    | PUBLICATION identifier
    | ROLE identifier
    | RULE identifier ON table_name=schema_qualified_name
    | SCHEMA identifier
    | SEQUENCE name=schema_qualified_name
    | SERVER identifier
    | STATISTICS name=schema_qualified_name
    | SUBSCRIPTION identifier
    | TABLESPACE identifier
    | TEXT SEARCH CONFIGURATION name=schema_qualified_name
    | TEXT SEARCH DICTIONARY name=schema_qualified_name
    | TEXT SEARCH PARSER name=schema_qualified_name
    | TEXT SEARCH TEMPLATE name=schema_qualified_name
    | TRANSFORM FOR name=schema_qualified_name LANGUAGE identifier
    | TRIGGER identifier ON table_name=schema_qualified_name
    | TYPE name=schema_qualified_name
    ;

label_member_object
    : (AGGREGATE | PROCEDURE | FUNCTION | ROUTINE) name=schema_qualified_name function_args
    | COLUMN name=schema_qualified_name
    | DATABASE identifier
    | DOMAIN name=schema_qualified_name
    | EVENT TRIGGER identifier
    | FOREIGN? TABLE name=schema_qualified_name
    | LARGE OBJECT unsigned_numeric_literal
    | MATERIALIZED? VIEW name=schema_qualified_name
    | PROCEDURAL? LANGUAGE name=schema_qualified_name
    | PUBLICATION identifier
    | ROLE identifier
    | SCHEMA identifier
    | SEQUENCE name=schema_qualified_name
    | SUBSCRIPTION identifier
    | TABLESPACE identifier
    | TYPE name=schema_qualified_name
    ;

/*
===============================================================================
  Function and Procedure Definition
===============================================================================
*/
create_function_statement
    : (OR REPLACE)? (FUNCTION | PROCEDURE) function_parameters
        (RETURNS (rettype_data=data_type | ret_table=function_ret_table))?
          funct_body=create_funct_params
    ;

create_funct_params
    : function_actions_common+ with_storage_parameter?
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
    : LEFT_PAREN
    ( (function_arguments (COMMA function_arguments)*)?  agg_order?
      | MULTIPLY )
    RIGHT_PAREN
    ;

agg_order
    : ORDER BY function_arguments (COMMA function_arguments)*
    ;

character_string
    : BeginDollarStringConstant Text_between_Dollar+ EndDollarStringConstant
    | Character_String_Literal
    ;

function_arguments
    :arg_mode=argmode? argname=identifier_nontype? argtype_data=data_type function_def_value?
    ;

function_def_value
    : (DEFAULT | EQUAL) def_value=vex
    ;

argmode
    : IN | OUT | INOUT | VARIADIC
    ;

create_sequence_statement
    : (TEMPORARY | TEMP)? SEQUENCE if_not_exists? name=schema_qualified_name (sequence_body)*
    ;

sequence_body
    : AS type=(SMALLINT | INTEGER | BIGINT)
    | SEQUENCE NAME name=schema_qualified_name
    | INCREMENT BY? incr=signed_numerical_literal
    | (MINVALUE minval=signed_numerical_literal | NO MINVALUE)
    | (MAXVALUE maxval=signed_numerical_literal | NO MAXVALUE)
    | START WITH? start_val=signed_numerical_literal
    | CACHE cache_val=signed_numerical_literal
    | cycle_true=NO? cycle_val=CYCLE
    | OWNED BY col_name=schema_qualified_name
    ;

signed_number_literal
  : sign? NUMBER_LITERAL
  ;

signed_numerical_literal
  : sign? unsigned_numeric_literal
  ;

sign
  : PLUS | MINUS
  ;

create_schema_statement
    : SCHEMA if_not_exists? name=identifier? (AUTHORIZATION (user_name = identifier | CURRENT_USER | SESSION_USER))?
    ;

create_policy_statement
    : POLICY identifier ON schema_qualified_name 
    (AS (PERMISSIVE | RESTRICTIVE))?
    (FOR (ALL | SELECT | INSERT | UPDATE | DELETE))?
    (TO user_identifer_current_session (COMMA user_identifer_current_session)*)?
    (USING vex)? (WITH CHECK vex)?
    ;

alter_policy_statement
    : POLICY identifier ON schema_qualified_name rename_to
    | POLICY identifier ON schema_qualified_name
        (TO user_identifer_current_session (COMMA user_identifer_current_session)*)?
        (USING vex)? (WITH CHECK vex)?
    ;

drop_policy_statement
    : POLICY (IF EXISTS)? identifier ON schema_qualified_name cascade_restrict?
    ;

create_subscription_statement
    : SUBSCRIPTION identifier
    CONNECTION Character_String_Literal
    PUBLICATION identifier_list
    with_storage_parameter?
    ;

alter_subscription_statement
    : SUBSCRIPTION identifier alter_subscription_action
    ;

alter_subscription_action
    : CONNECTION character_string
    | SET PUBLICATION identifier_list with_storage_parameter?
    | REFRESH PUBLICATION with_storage_parameter?
    | ENABLE
    | DISABLE
    | SET storage_parameter
    | owner_to
    | rename_to
    ;

create_cast_statement
    : CAST LEFT_PAREN schema_qualified_name AS schema_qualified_name RIGHT_PAREN
    (WITH FUNCTION function_call | WITHOUT FUNCTION | WITH INOUT)
    (AS ASSIGNMENT | AS IMPLICIT)?
    ;

drop_cast_statement
    : CAST (IF EXISTS)? LEFT_PAREN schema_qualified_name AS schema_qualified_name RIGHT_PAREN cascade_restrict?
    ;

create_operator_family_statement
    : OPERATOR FAMILY schema_qualified_name USING identifier
    ;

alter_operator_family_statement
    : OPERATOR FAMILY schema_qualified_name USING identifier operator_family_action
    ;

operator_family_action
    : rename_to
    | owner_to
    | set_schema
    | ADD add_operator_to_family (COMMA add_operator_to_family)*
    | DROP drop_operator_from_family (COMMA drop_operator_from_family)*
    ;

add_operator_to_family
    : OPERATOR unsigned_numeric_literal target_operator (FOR SEARCH | FOR ORDER BY schema_qualified_name)?
    | FUNCTION unsigned_numeric_literal (LEFT_PAREN (left_type=data_type | NONE) (COMMA (right_type=data_type | NONE))? RIGHT_PAREN)? 
    function_name (LEFT_PAREN vex_or_named_notation (COMMA vex_or_named_notation)* RIGHT_PAREN)?
    ;

drop_operator_from_family
    : (OPERATOR | FUNCTION) unsigned_numeric_literal LEFT_PAREN (left_type=data_type | NONE) (COMMA (right_type=data_type | NONE))? RIGHT_PAREN
    ;

drop_operator_family_statement
    : OPERATOR FAMILY (IF EXISTS)? schema_qualified_name USING identifier cascade_restrict?
    ;

create_operator_class_statement
    :  OPERATOR CLASS schema_qualified_name DEFAULT? FOR TYPE data_type 
    USING identifier (FAMILY schema_qualified_name)? AS
    create_operator_class_option (COMMA create_operator_class_option)*
    ;

create_operator_class_option
    : OPERATOR unsigned_numeric_literal name=operator_name 
        (LEFT_PAREN (data_type | NONE) COMMA (data_type | NONE) RIGHT_PAREN)?
        (FOR SEARCH | FOR ORDER BY schema_qualified_name)?
    | FUNCTION unsigned_numeric_literal 
        (LEFT_PAREN (data_type | NONE) (COMMA (data_type | NONE))? RIGHT_PAREN)? 
        function_call
    | STORAGE data_type
    ;

alter_operator_class_statement
    : OPERATOR CLASS schema_qualified_name USING identifier (rename_to | owner_to | set_schema)
    ;

drop_operator_class_statement
    : OPERATOR CLASS (IF EXISTS)? schema_qualified_name USING identifier cascade_restrict?
    ;

create_conversion_statement
    : DEFAULT? CONVERSION schema_qualified_name FOR Character_String_Literal TO Character_String_Literal FROM schema_qualified_name
    ;

alter_conversion_statement
    : CONVERSION schema_qualified_name (rename_to | owner_to | set_schema)
    ;

create_publication_statement
    : PUBLICATION identifier 
    (FOR TABLE only_table_multiply (COMMA only_table_multiply)* | FOR ALL TABLES)?
    with_storage_parameter?
    ;

alter_publication_statement
    : PUBLICATION identifier alter_publication_action
    ;

alter_publication_action
    : rename_to
    | owner_to
    | SET storage_parameter
    | (ADD | DROP | SET) TABLE only_table_multiply (COMMA only_table_multiply)*
    ;

only_table_multiply
    : ONLY? schema_qualified_name MULTIPLY?
    ;

alter_trigger_statement
    : TRIGGER identifier ON schema_qualified_name (rename_to | DEPENDS ON EXTENSION identifier)
    ;

alter_rule_statement
    : RULE identifier ON schema_qualified_name rename_to
    ;

copy_statement
    : copy_to_statement 
    | copy_from_statement
    ;

copy_from_statement
    : COPY table_cols
    FROM (PROGRAM? Character_String_Literal | STDIN) 
    (WITH? (LEFT_PAREN copy_option_list RIGHT_PAREN | copy_option_list))?
    ;

copy_to_statement
    : COPY (table_cols | LEFT_PAREN (select_stmt | insert_stmt_for_psql | update_stmt_for_psql | delete_stmt_for_psql) RIGHT_PAREN )
    TO (PROGRAM? Character_String_Literal | STDOUT)
    (WITH? (LEFT_PAREN copy_option_list RIGHT_PAREN | copy_option_list))?
    ;

copy_option_list
    : copy_option (COMMA? copy_option)*
    ;

copy_option
    : FORMAT? (TEXT | CSV | BINARY)
    | OIDS truth_value?
    | FREEZE truth_value?
    | DELIMITER AS? Character_String_Literal
    | NULL AS? Character_String_Literal
    | HEADER truth_value?
    | QUOTE Character_String_Literal
    | ESCAPE Character_String_Literal
    | FORCE QUOTE (MULTIPLY | columns_list)
    | FORCE_QUOTE (MULTIPLY | LEFT_PAREN columns_list RIGHT_PAREN)
    | FORCE NOT NULL columns_list
    | FORCE_NOT_NULL LEFT_PAREN columns_list RIGHT_PAREN
    | FORCE_NULL LEFT_PAREN columns_list RIGHT_PAREN
    | ENCODING Character_String_Literal
    ;

create_view_statement
    : (OR REPLACE)? (TEMP | TEMPORARY)? RECURSIVE? MATERIALIZED? VIEW if_not_exists? name=schema_qualified_name column_names=view_columns?
        (WITH storage_parameter)?
        table_space?
        AS v_query=select_stmt
        with_check_option?
        (WITH NO? DATA)?
    ;

if_not_exists
    : IF NOT EXISTS
    ;

view_columns
    : LEFT_PAREN column_name+=identifier (COMMA column_name+=identifier)* RIGHT_PAREN
    ;

with_check_option
    : WITH (CASCADED|LOCAL)? CHECK OPTION
    ;

create_table_statement
  : ((GLOBAL | LOCAL)? (TEMPORARY | TEMP) | UNLOGGED)? TABLE if_not_exists? name=schema_qualified_name
    define_table
    partition_by?
    storage_parameter_oid?
    on_commit?
    table_space?
  ;

create_table_as_statement
    : ((GLOBAL | LOCAL)? (TEMPORARY | TEMP) | UNLOGGED)? TABLE if_not_exists? name=schema_qualified_name
    column_references?
    storage_parameter_oid?
    on_commit?
    table_space?
    AS (select_stmt | EXECUTE function_call)
    (WITH NO? DATA)?
    ;


create_foreign_table_statement
   : FOREIGN TABLE if_not_exists? name=schema_qualified_name
   (define_columns | define_partition)
   define_server
   ;

define_table
   : define_columns
   | define_type
   | define_partition
   ;

define_partition
    : PARTITION OF parent_table=schema_qualified_name
    list_of_type_column_def?
    for_values_bound
    ;

for_values_bound
    : FOR VALUES partition_bound_spec
    | DEFAULT
    ;

partition_bound_spec
    : IN LEFT_PAREN vex (COMMA vex)* RIGHT_PAREN
    | FROM partition_bound_part TO partition_bound_part
    | WITH LEFT_PAREN MODULUS NUMBER_LITERAL COMMA REMAINDER NUMBER_LITERAL RIGHT_PAREN
    ;

partition_bound_part
    : LEFT_PAREN vex (COMMA vex)* RIGHT_PAREN
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

partition_by
    : PARTITION BY partition_method
    ;

partition_method
    : (RANGE | LIST | HASH) LEFT_PAREN partition_column (COMMA partition_column)* RIGHT_PAREN
    ;

partition_column
    :  vex op_class=identifier?
    ;

define_server
  : SERVER server_name=identifier define_foreign_options?
  ;

define_foreign_options
  : OPTIONS
    LEFT_PAREN
      (foreign_option (COMMA foreign_option)*)
    RIGHT_PAREN
  ;

foreign_option
  : (ADD | SET | DROP)? name=foreign_option_name value=character_string?
  ;

foreign_option_name
  : identifier
  | USER
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
    : identifier (WITH OPTIONS)? constraint_common*
    | tabl_constraint=constraint_common
    ;

table_column_definition
    : column_name=identifier datatype=data_type define_foreign_options? collate_name=collate_identifier? constraint_common*
    ;

like_option
    : (INCLUDING | EXCLUDING) (DEFAULTS | CONSTRAINTS | IDENTITY | INDEXES | STORAGE | COMMENTS | ALL)
    ;
/** NULL, DEFAULT - column constraint
* EXCLUDE, FOREIGN KEY - table_constraint
*/
constraint_common
    : (CONSTRAINT constraint_name=identifier)? constr_body table_deferrable? table_initialy_immed?
    ;

constr_body
    : EXCLUDE (USING index_method=identifier)?
            LEFT_PAREN sort_specifier WITH all_op (COMMA sort_specifier WITH all_op)* RIGHT_PAREN
            index_parameters (where=WHERE exp=vex)?
    | (FOREIGN KEY column_references)? REFERENCES schema_qualified_name ref=column_references?
        (MATCH (FULL | PARTIAL | SIMPLE) | ON (DELETE | UPDATE) action)*
    | CHECK LEFT_PAREN expression=vex RIGHT_PAREN (NO INHERIT)?
    | NOT? NULL
    | (UNIQUE | PRIMARY KEY) col=column_references? index_parameters
    | DEFAULT default_expr=vex
    | identity_body
    ;

all_op
    : op
    | EQUAL | NOT_EQUAL | LTH | LEQ | GTH | GEQ
    | PLUS | MINUS | MULTIPLY | DIVIDE | MODULAR | EXP
    ;

all_simple_op
    : op_chars
    | EQUAL | NOT_EQUAL | LTH | LEQ | GTH | GEQ
    | PLUS | MINUS | MULTIPLY | DIVIDE | MODULAR | EXP
    ;

op_chars
    : OP_CHARS
    | LESS_LESS
    | GREATER_GREATER
    | HASH_SIGN
    ;

index_parameters
    : including_index? with_storage_parameter? (USING INDEX (table_space | schema_qualified_name))?
    ;

column_references
    : LEFT_PAREN names_references RIGHT_PAREN
    ;

names_references
    : name+=schema_qualified_name (COMMA name+=schema_qualified_name)*
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
    : OWNER TO (name=identifier | CURRENT_USER | SESSION_USER)
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

partition_by_columns
    : PARTITION BY vex (COMMA vex)*
    ;

cascade_restrict
    : CASCADE | RESTRICT
    ;

collate_identifier
    : COLLATE collation=schema_qualified_name
    ;

indirection_identifier
    : LEFT_PAREN vex RIGHT_PAREN (DOT identifier)+
    ;

/*
===============================================================================
  11.21 <data types>
===============================================================================
*/

drop_function_statement
    : (FUNCTION | PROCEDURE | AGGREGATE) (IF EXISTS)? name=schema_qualified_name function_args? cascade_restrict?
    ;

drop_trigger_statement
    : TRIGGER (IF EXISTS)? name=identifier ON table_name=schema_qualified_name cascade_restrict?
    ;

drop_rule_statement
    : RULE (IF EXISTS)? name=identifier ON schema_qualified_name cascade_restrict?
    ;

drop_statements
    : (ACCESS METHOD
    | COLLATION
    | CONVERSION
    | DATABASE
    | DOMAIN
    | EVENT TRIGGER
    | EXTENSION
    | GROUP
    | FOREIGN? TABLE
    | FOREIGN DATA WRAPPER
    | INDEX CONCURRENTLY?
    | MATERIALIZED? VIEW
    | PROCEDURAL? LANGUAGE
    | PUBLICATION
    | ROLE
    | SCHEMA
    | SEQUENCE
    | SERVER
    | STATISTICS
    | SUBSCRIPTION
    | TABLESPACE
    | TYPE
    | TEXT SEARCH (CONFIGURATION | DICTIONARY | PARSER | TEMPLATE)
    | USER) if_exist_names_restrict_cascade
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

id_token
  : Identifier | QuotedIdentifier | tokens_nonkeyword;

/*
  old rule for default old identifier behavior
  includes types
*/
identifier
  : id_token | DOLLAR_NUMBER
  | tokens_nonreserved
  | tokens_nonreserved_except_function_type
  ;

identifier_nontype
  : id_token
  | tokens_nonreserved
  | tokens_reserved_except_function_type
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
    | ATTACH
    | ATTRIBUTE
    | BACKWARD
    | BEFORE
    | BEGIN
    | BY
    | CACHE
    | CALL
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
    | COLUMNS
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
    | DETACH
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
    | GENERATED
    | GLOBAL
    | GRANTED
    | GROUPS
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
    | INCLUDE
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
    | NEW
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
    | OLD
    | OPERATOR
    | OPTION
    | OPTIONS
    | ORDINALITY
    | OTHERS
    | OVER
    | OVERRIDING
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
    | PROCEDURES
    | PROGRAM
    | PUBLICATION
    | QUOTE
    | RANGE
    | READ
    | REASSIGN
    | RECHECK
    | RECURSIVE
    | REF
    | REFERENCING
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
    | ROUTINE
    | ROUTINES
    | ROWS
    | RULE
    | SAVEPOINT
    | SCHEMA
    | SCHEMAS
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
    | SUBSCRIPTION
    | SYSID
    | SYSTEM
    | TABLES
    | TABLESPACE
    | TEMP
    | TEMPLATE
    | TEMPORARY
    | TEXT
    | TIES
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
    | XMLNAMESPACES
    | XMLPARSE
    | XMLPI
    | XMLROOT
    | XMLSERIALIZE
    | XMLTABLE
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
    : ALIGNMENT
    | BASETYPE
    | BUFFERS
    | BYPASSRLS
    | CANONICAL
    | CATEGORY
    | COLLATABLE
    | COMBINEFUNC
    | COMMUTATOR
    | CONNECT
    | COSTS
    | CREATEDB
    | CREATEROLE
    | DESERIALFUNC
    | DISABLE_PAGE_SKIPPING
    | ELEMENT
    | EXTENDED
    | FINALFUNC
    | FINALFUNC_EXTRA
    | FINALFUNC_MODIFY
    | FORCE_NOT_NULL
    | FORCE_NULL
    | FORCE_QUOTE
    | FORMAT
    | GETTOKEN
    | HASH
    | HASHES
    | HEADLINE
    | HYPOTHETICAL
    | INIT
    | INITCOND
    | INTERNALLENGTH
    | JSON
    | LC_COLLATE
    | LC_CTYPE 
    | LEFTARG
    | LEXIZE
    | LEXTYPES
    | LOCALE 
    | LOGIN
    | MAIN
    | MERGES
    | MFINALFUNC
    | MFINALFUNC_EXTRA
    | MFINALFUNC_MODIFY
    | MINITCOND
    | MINVFUNC
    | MODULUS
    | MSFUNC
    | MSSPACE
    | MSTYPE
    | NEGATOR
    | NOBYPASSRLS
    | NOCREATEDB
    | NOCREATEROLE
    | NOINHERIT
    | NOLOGIN
    | NOREPLICATION
    | NOSUPERUSER
    | OUTPUT
    | PASSEDBYVALUE
    | PATH
    | PERMISSIVE
    | PLAIN
    | PREFERRED
    | PROVIDER
    | READ_ONLY
    | READ_WRITE
    | RECEIVE
    | REPLICATION
    | REMAINDER
    | RESTRICTED
    | RESTRICTIVE
    | RIGHTARG
    | SAFE
    | SEND
    | SERIALFUNC
    | SFUNC
    | SHAREABLE
    | SORTOP
    | SSPACE
    | STYPE
    | SUBTYPE
    | SUBTYPE_DIFF
    | SUBTYPE_OPCLASS
    | SUMMARY
    | SUPERUSER
    | TIMING
    | TYPMOD_IN
    | TYPMOD_OUT
    | UNSAFE
    | USAGE
    | VARIABLE
    | YAML

    // plpgsql tokens
    | ALIAS
    | ASSERT
    | CONSTANT
    | DATATYPE
    | DEBUG
    | DETAIL
    | DIAGNOSTICS
    | ELSEIF
    | ELSIF
    | ERRCODE
    | EXIT
    | EXCEPTION
    | FOREACH
    | GET
    | HINT
    | INFO
    | LOG
    | LOOP
    | MESSAGE
    | NOTICE
    | OPEN
    | PERFORM
    | QUERY
    | RAISE
    | RECORD
    | RETURN
    | REVERSE
    | ROWTYPE
    | SLICE
    | SQLSTATE
    | STACKED
    | WARNING
    | WHILE
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

type_list
  : data_type (COMMA data_type)*
  ;

data_type
  : SETOF? predefined_type (ARRAY array_type | array_type+)?
  ;

array_type
    : LEFT_BRACKET NUMBER_LITERAL? RIGHT_BRACKET
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
    | INTERVAL interval_field? type_length?
    | NATIONAL? (CHARACTER | CHAR) VARYING? type_length?
    | NCHAR VARYING? type_length?
    | NUMERIC precision_param?
    | REAL
    | SMALLINT
    | TIME type_length? ((WITH | WITHOUT) TIME ZONE)?
    | TIMESTAMP type_length? ((WITH | WITHOUT) TIME ZONE)?
    | VARCHAR type_length?
    | schema_qualified_name_nontype (LEFT_PAREN vex (COMMA vex)* RIGHT_PAREN)?
    ;

interval_field
  : YEAR
  | MONTH
  | DAY
  | HOUR
  | MINUTE
  | SECOND
  | YEAR TO MONTH
  | DAY TO HOUR
  | DAY TO MINUTE
  | DAY TO SECOND
  | HOUR TO MINUTE
  | HOUR TO SECOND
  | MINUTE TO SECOND
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
  | LEFT_PAREN vex (COMMA vex)+ RIGHT_PAREN
  | vex LEFT_BRACKET vex RIGHT_BRACKET
  | vex LEFT_BRACKET vex? COLON vex? RIGHT_BRACKET
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
  | vex IS NOT? UNKNOWN
  | vex IS NOT? OF LEFT_PAREN type_list RIGHT_PAREN
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
  | LEFT_PAREN vex (COMMA vex)+ RIGHT_PAREN
  | vex_b LEFT_BRACKET vex RIGHT_BRACKET
  | vex_b LEFT_BRACKET vex? COLON vex? RIGHT_BRACKET
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
  | vex_b IS NOT? UNKNOWN
  | vex_b IS NOT? OF LEFT_PAREN type_list RIGHT_PAREN
  | value_expression_primary
  ;

op
  : op_chars
  | OPERATOR LEFT_PAREN identifier DOT all_simple_op RIGHT_PAREN
  ;

all_op_ref
  : all_simple_op
  | OPERATOR LEFT_PAREN identifier DOT all_simple_op RIGHT_PAREN
  ;

datetime_overlaps
  : LEFT_PAREN vex COMMA vex RIGHT_PAREN OVERLAPS LEFT_PAREN vex COMMA vex RIGHT_PAREN
  ;

value_expression_primary
  : unsigned_value_specification
  | LEFT_PAREN select_stmt_no_parens RIGHT_PAREN
  | case_expression
  | NULL
  // technically incorrect since ANY cannot be value expression
  // but fixing this would require to write a vex rule duplicating all operators
  // like vex (op|op|op|...) comparison_mod
  | comparison_mod
  | EXISTS table_subquery
  | function_call
  | schema_qualified_name
  | indirection_identifier
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
  : character_string
  | truth_value
  ;

truth_value
  : TRUE | FALSE | ON // on is reserved but is required by SET statements
  ;

case_expression
  : CASE vex? (WHEN vex THEN r+=vex)+ (ELSE r+=vex)? END
  ;

cast_specification
  : (CAST | TREAT) LEFT_PAREN vex AS data_type RIGHT_PAREN
  ;

// using data_type for function name because keyword-named functions
// use the same category of keywords as keyword-named types
function_call
    : function_name LEFT_PAREN (set_qualifier? vex_or_named_notation (COMMA vex_or_named_notation)* orderby_clause?)? RIGHT_PAREN
        (WITHIN GROUP LEFT_PAREN orderby_clause RIGHT_PAREN)?
        filter_clause? (OVER (identifier | window_definition))?
    | extract_function
    | system_function
    | date_time_function
    | string_value_function
    | xml_function
    ;

function_name
  : schema_qualified_name_nontype
  // allow for all built-in function except those with explicit syntax rules defined
  | (identifier DOT)? tokens_simple_functions
  ;

vex_or_named_notation
    : VARIADIC? (argname=identifier pointer)? vex
    ;

pointer
    : EQUAL_GTH | COLON_EQUAL
    ;

extract_function
  : EXTRACT LEFT_PAREN (identifier | character_string) FROM vex RIGHT_PAREN
  ;

system_function
    : CURRENT_CATALOG
    // parens are handled by generic function call
    // since current_schema is defined as reserved(can be function) keyword
    | CURRENT_SCHEMA /*(LEFT_PAREN RIGHT_PAREN)?*/
    | CURRENT_USER
    | SESSION_USER
    | USER
    | cast_specification
    ;

date_time_function
    : CURRENT_DATE
    | CURRENT_TIME type_length?
    | CURRENT_TIMESTAMP type_length?
    | LOCALTIME type_length?
    | LOCALTIMESTAMP type_length?
    ;

string_value_function
  : TRIM LEFT_PAREN (LEADING | TRAILING | BOTH)? (chars=vex FROM str=vex | FROM? str=vex (COMMA chars=vex)?) RIGHT_PAREN
  | SUBSTRING LEFT_PAREN vex (COMMA vex)* (FROM vex)? (FOR vex)? RIGHT_PAREN
  | POSITION LEFT_PAREN vex_b IN vex RIGHT_PAREN
  | OVERLAY LEFT_PAREN vex PLACING vex FROM vex (FOR vex)? RIGHT_PAREN
  | COLLATION FOR LEFT_PAREN vex RIGHT_PAREN
  ;

xml_function
    : XMLELEMENT LEFT_PAREN NAME name=identifier
        (COMMA XMLATTRIBUTES LEFT_PAREN vex (AS attname=identifier)? (COMMA vex (AS attname=identifier)?)* RIGHT_PAREN)?
        (COMMA vex)* RIGHT_PAREN
    | XMLFOREST LEFT_PAREN vex (AS name=identifier)? (COMMA vex (AS name=identifier)?)* RIGHT_PAREN
    | XMLPI LEFT_PAREN NAME name=identifier (COMMA vex)? RIGHT_PAREN
    | XMLROOT LEFT_PAREN vex COMMA VERSION (vex | NO VALUE) (COMMA STANDALONE (YES | NO | NO VALUE))? RIGHT_PAREN
    | XMLEXISTS LEFT_PAREN vex PASSING (BY REF)? vex (BY REF)? RIGHT_PAREN
    | XMLPARSE LEFT_PAREN (DOCUMENT | CONTENT) vex RIGHT_PAREN
    | XMLSERIALIZE LEFT_PAREN (DOCUMENT | CONTENT) vex AS data_type RIGHT_PAREN
    | XMLTABLE LEFT_PAREN 
        (XMLNAMESPACES LEFT_PAREN vex AS name=identifier (COMMA vex AS name=identifier)* RIGHT_PAREN COMMA)?
        vex PASSING (BY REF)? vex (BY REF)?
        COLUMNS xml_table_column (COMMA xml_table_column)*
        RIGHT_PAREN
    ;

xml_table_column
    : name=identifier (data_type (PATH vex)? (DEFAULT vex)? (NOT? NULL)? | FOR ORDINALITY)
    ;

comparison_mod
    : (ALL | ANY | SOME) LEFT_PAREN (vex | select_stmt_no_parens) RIGHT_PAREN
    ;

filter_clause
  : FILTER LEFT_PAREN WHERE vex RIGHT_PAREN
  ;

window_definition
  : LEFT_PAREN w_name=identifier? partition_by_columns? orderby_clause? frame_clause? RIGHT_PAREN
  ;

frame_clause
  : (RANGE | ROWS | GROUPS) (frame_bound | BETWEEN frame_bound AND frame_bound)
  (EXCLUDE (CURRENT ROW | GROUP | TIES | NO OTHERS))?
  ;

frame_bound
  : vex (PRECEDING | FOLLOWING)
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
    : ARRAY array_elements
    ;

array_elements
    : LEFT_BRACKET ((vex | array_elements) (COMMA (vex | array_elements))*)? RIGHT_BRACKET
    ;

array_query
    : ARRAY table_subquery
    ;

type_coercion
    : data_type character_string
    | INTERVAL character_string interval_field type_length?
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
    : with_clause? select_ops (after_ops into_statement?)*
    ;

after_ops
    : orderby_clause
    | LIMIT (vex | ALL)
    | OFFSET vex (ROW | ROWS)?
    | FETCH (FIRST | NEXT) vex? (ROW | ROWS) ONLY?
    | FOR (UPDATE | NO KEY UPDATE | SHARE | NO KEY SHARE) (OF schema_qualified_name (COMMA schema_qualified_name)*)? NOWAIT?
    ;

// select_stmt copy that doesn't consume external parens
// for use in vex
// we let the vex rule to consume as many parens as it can
select_stmt_no_parens
    : with_clause? select_ops_no_parens after_ops*
    ;

with_clause
    : WITH RECURSIVE? with_query (COMMA with_query)*
    ;

with_query
    : query_name=identifier (LEFT_PAREN column_name+=identifier (COMMA column_name+=identifier)* RIGHT_PAREN)?
            AS LEFT_PAREN (select_stmt | insert_stmt_for_psql | update_stmt_for_psql | delete_stmt_for_psql) RIGHT_PAREN
    ;

select_ops
    : LEFT_PAREN select_stmt RIGHT_PAREN // parens can be used to apply "global" clauses (WITH etc) to a particular select in UNION expr
    | select_ops (INTERSECT | UNION | EXCEPT) set_qualifier? select_ops
    | select_primary
    ;

// version of select_ops for use in select_stmt_no_parens
select_ops_no_parens
    : select_ops (INTERSECT | UNION | EXCEPT) set_qualifier? (select_primary | LEFT_PAREN select_stmt RIGHT_PAREN)
    | select_primary
    ;

select_primary
    : SELECT
        into_statement?
        (set_qualifier (ON LEFT_PAREN vex (COMMA vex)* RIGHT_PAREN)?)?
        select_list?
        (into_statement | into_table)?
        (FROM into_statement? from_item (COMMA from_item)*)?
        (WHERE vex into_statement?)?
        groupby_clause?
        (HAVING vex)?
        (WINDOW w_name=identifier AS window_definition (COMMA w_name=identifier AS window_definition)*)?
    | TABLE ONLY? schema_qualified_name MULTIPLY?
    | values_stmt
    ;

select_list
  : select_sublist (COMMA select_sublist)*
  ;

select_sublist
  : vex (AS identifier | AS tokens_reserved | id_token )?
  ;

into_table
    : INTO TABLE schema_qualified_name
    | INTO (TEMPORARY | TEMP | UNLOGGED) TABLE? schema_qualified_name
    ;

from_item
    : LEFT_PAREN from_item RIGHT_PAREN alias_clause?
    | from_item CROSS JOIN from_item
    | from_item (INNER | (LEFT | RIGHT | FULL) OUTER?)? JOIN from_item ON vex
    | from_item (INNER | (LEFT | RIGHT | FULL) OUTER?)? JOIN from_item USING column_references
    | from_item NATURAL (INNER | (LEFT | RIGHT | FULL) OUTER?)? JOIN from_item
    | from_primary into_statement?
    ;

from_primary
    : ONLY? schema_qualified_name MULTIPLY? alias_clause? (TABLESAMPLE method=identifier LEFT_PAREN vex (COMMA vex)* RIGHT_PAREN (REPEATABLE vex)?)?
    | LATERAL? table_subquery alias_clause
    | LATERAL? function_call (WITH ORDINALITY)?
        (AS from_function_column_def
        | AS? alias=identifier (LEFT_PAREN column_alias+=identifier (COMMA column_alias+=identifier)* RIGHT_PAREN | from_function_column_def)?
        )?
    | LATERAL? ROWS FROM LEFT_PAREN function_call (AS from_function_column_def)? (COMMA function_call (AS from_function_column_def)?)* RIGHT_PAREN
    (WITH ORDINALITY)? (AS? alias=identifier (LEFT_PAREN column_alias+=identifier (COMMA column_alias+=identifier)* RIGHT_PAREN)?)?
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
  : vex
  | LEFT_PAREN RIGHT_PAREN
  | (ROLLUP | CUBE | GROUPING SETS) LEFT_PAREN c=grouping_element_list RIGHT_PAREN
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
    opclass=schema_qualified_name? // this allows to share this rule with create_index; technically invalid syntax
    order=order_specification?
    null_order=null_ordering?
  ;

order_specification
  : ASC | DESC | USING all_op_ref
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
  : with_clause? INSERT INTO insert_table_name=schema_qualified_name (AS alias=identifier)?
  (OVERRIDING (SYSTEM | USER) VALUE)?
  (LEFT_PAREN column+=identifier (COMMA column+=identifier)* RIGHT_PAREN)?
  (select_stmt | DEFAULT VALUES)
  (ON CONFLICT conflict_object? conflict_action)?
  (RETURNING select_list into_statement?)?
  ;

conflict_object
    : index_sort index_where?
    | ON CONSTRAINT identifier
    ;

conflict_action
    : DO NOTHING
    | DO UPDATE SET update_set (COMMA update_set)* (WHERE vex)?
    ;

delete_stmt_for_psql
  : with_clause? DELETE FROM ONLY? delete_table_name=schema_qualified_name MULTIPLY? (AS? alias=identifier)?
  (USING from_item (COMMA from_item)*)?
  (WHERE (vex | CURRENT OF cursor=identifier))?
  (RETURNING select_list into_statement?)?
  ;

update_stmt_for_psql
  : with_clause? UPDATE ONLY? update_table_name=schema_qualified_name MULTIPLY? (AS? alias=identifier)?
  SET update_set (COMMA update_set)*
  (FROM from_item (COMMA from_item)*)?
  (WHERE (vex | CURRENT OF cursor=identifier))?
  (RETURNING select_list into_statement?)?
  ;

update_set
  : column+=identifier EQUAL (value+=vex | DEFAULT)
  | LEFT_PAREN column+=identifier (COMMA column+=identifier)* RIGHT_PAREN EQUAL ROW?
  (LEFT_PAREN (value+=vex | DEFAULT) (COMMA (value+=vex | DEFAULT))* RIGHT_PAREN
    | table_subquery)
  ;

notify_stmt
  : NOTIFY channel=identifier (COMMA payload=character_string)?
  ;

truncate_stmt
  : TRUNCATE TABLE? only_table_multiply (COMMA only_table_multiply)*
  ((RESTART | CONTINUE) IDENTITY)? (CASCADE | RESTRICT)?
  ;

comp_options
    : HASH_SIGN identifier identifier
    ;

function_block
    : start_label? declarations?
    BEGIN function_statements exception_statement?
    END end_label=identifier?
    ;

start_label
    : LESS_LESS identifier GREATER_GREATER
    ;

declarations
    : DECLARE (identifier type_declaration SEMI_COLON)*
    ;

type_declaration
    : CONSTANT? data_type_dec collate_identifier? (NOT NULL)? ((DEFAULT | COLON_EQUAL | EQUAL) vex)?
    | ALIAS FOR (identifier | DOLLAR_NUMBER)
    | ((NO)? SCROLL)? CURSOR (LEFT_PAREN arguments_list RIGHT_PAREN)? (FOR | IS) select_stmt
    ;

arguments_list
    : identifier data_type (COMMA identifier data_type)*
    ;

data_type_dec
    : data_type (MODULAR (TYPE | ROWTYPE))?
    ;

exception_statement
    : EXCEPTION (WHEN vex THEN function_statements)+
    ;

function_statements
    : (function_statement SEMI_COLON)*
    ;

function_statement
    : function_block
    | base_statement
    | control_statement
    | transaction_statement
    | cursor_statement
    | message_statement
    | anonymous_block
    | schema_statement
    | data_statement
    ;

base_statement
    : assign_stmt
    | execute_stmt
    | PERFORM perform_stmt
    | GET (CURRENT | STACKED)? DIAGNOSTICS diagnostic_option (COMMA diagnostic_option)*
    | NULL
    ;

var
    : (schema_qualified_name | DOLLAR_NUMBER) (LEFT_BRACKET vex RIGHT_BRACKET)*
    ;

diagnostic_option
    : var (COLON_EQUAL | EQUAL) identifier
    ;

// keep this in sync with select_primary (except intended differences)
perform_stmt
    : (set_qualifier (ON LEFT_PAREN vex (COMMA vex)* RIGHT_PAREN)?)?
    select_list
    (FROM from_item (COMMA from_item)*)?
    (WHERE vex)?
    groupby_clause?
    (HAVING vex)?
    (WINDOW w_name=identifier AS window_definition (COMMA w_name=identifier AS window_definition)*)?
    ((INTERSECT | UNION | EXCEPT) set_qualifier? select_ops)?
    after_ops*
    ;

assign_stmt
    : var (COLON_EQUAL | EQUAL) (select_stmt_no_parens | perform_stmt)
    ;

execute_stmt
    : EXECUTE vex into_statement? using_vex?
    ;

control_statement
    : return_stmt
    | CALL function_call
    | if_statement
    | case_statement
    | loop_statement
    ;

cursor_statement
    : OPEN var ((NO)? SCROLL)? FOR (select_stmt | execute_stmt)
    | OPEN var (option (COMMA option)*)?
    | FETCH fetch_move_direction? (FROM | IN)? var INTO identifier_list
    | MOVE fetch_move_direction? (FROM | IN)? var
    | CLOSE var
    ;

option
    : (identifier COLON_EQUAL)? vex
    ;

transaction_statement
    : COMMIT
    | ROLLBACK
    ;

message_statement
    : RAISE log_level? SQLSTATE? (character_string (COMMA vex)*)? raise_using?
    | ASSERT vex (COMMA vex)?
    ;

log_level
    : DEBUG
    | LOG
    | INFO
    | NOTICE
    | WARNING
    | EXCEPTION
    ;

raise_using
    : USING raise_param EQUAL vex (COMMA raise_param EQUAL vex)*
    ;

raise_param
    : MESSAGE
    | DETAIL
    | HINT
    | ERRCODE
    | COLUMN
    | CONSTRAINT
    | DATATYPE
    | TABLE
    | SCHEMA
    ;

return_stmt
    : RETURN vex?
    | RETURN NEXT vex
    | RETURN QUERY (select_stmt | execute_stmt)
    ;

loop_statement
    : start_label? loop_start? LOOP function_statements END LOOP identifier?
    | (EXIT | CONTINUE) identifier? (WHEN vex)?
    ;

loop_start
    : WHILE vex
    | FOR identifier IN REVERSE? vex DOUBLE_DOT vex (BY vex)?
    | FOR identifier_list IN (select_stmt | execute_stmt)
    | FOR identifier IN identifier (LEFT_PAREN option (COMMA option)* RIGHT_PAREN)? // cursor loop
    | FOREACH identifier_list (SLICE NUMBER_LITERAL)? IN ARRAY vex
    ;

identifier_list
    : identifier (COMMA identifier)*
    ;

using_vex
    : USING vex (COMMA vex)*
    ;

if_statement
    : IF vex THEN function_statements ((ELSIF | ELSEIF) vex THEN function_statements)* (ELSE function_statements)? END IF
    ;

// plpgsql case
case_statement
    : CASE vex? (WHEN vex (COMMA vex)* THEN function_statements)+ (ELSE function_statements)? END CASE
    ;

into_statement
    : INTO STRICT? names_references
    ;

anonymous_block
    : DO (LANGUAGE identifier)? character_string
    | DO character_string LANGUAGE identifier
    ;