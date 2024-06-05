parser grammar CHParser;

options {
    language=Java;
    tokenVocab=CHLexer;
}

@header {package ru.taximaxim.codekeeper.core.parsers.antlr.generated;}

// Top-level statements

@members {
    private int selectLevel = 0;
}

ch_file
    : BOM? SEMICOLON* (query (SEMICOLON+ | EOF))* EOF
    ;

expr_eof
    : expr EOF
    ;

query
    : stmt (INTO OUTFILE STRING_LITERAL)? (FORMAT (identifier | NULL))?
    ;

stmt
    : ddl_stmt
    | dml_stmt
    ;

ddl_stmt
    : alter_stmt
    | ATTACH attach_stmt
    | create_stmt
    | drop_stmt
    | detach_stmt
    | kill_stmt
    | optimize_stmt
    | rename_stmt
    | truncate_stmt
    | privilegy_stmt
    ;

dml_stmt
    : check_stmt
    | describe_stmt
    | exists_stmt
    | explain_stmt
    | move_stmt
    | set_stmt
    | SHOW show_stmt
    | system_stmt
    | use_stmt
    | watch_stmt
    | insert_stmt
    | select_stmt
    | transaction_stmt
    ;

create_stmt
    : create_database_stmt
    | create_dictinary_stmt
    | create_table_stmt
    | create_view_stmt
    | create_function_stmt
    | create_policy_stmt
    | create_named_collection_stmt
    | create_user_stmt
    | create_role_stmt
    ;

alter_stmt
    : alter_table_stmt
    | alter_policy_stmt
    | alter_named_collection_stmt
    | alter_user_stmt
    | alter_role_stmt
    ;

privilegy_stmt
    : (GRANT | REVOKE) cluster_clause? privileges (TO | FROM) users with_option*
    ;

privileges
    : (GRANT OPTION FOR)? privilege (COMMA privilege)*
    | (ADMIN OPTION FOR)? identifier_list
    ;

privilege
    : (permissions | columns_permissions) ON names_references
    ;

names_references
    : qualified_name (DOT ASTERISK)?
    | ASTERISK (DOT ASTERISK)?
    ;

columns_permissions
    : table_column_privileges (COMMA table_column_privileges)*
    ;

table_column_privileges
    : permission LPAREN identifier_list RPAREN
    ;

permissions
    : permission (COMMA permission)*
    ;

permission
    : ACCESS MANAGEMENT
    | ALL
//  | ALLOW SQL SECURITY NONE
    | ALTER (object_type | CONSTRAINT | INDEX)?
    | ALTER ADD (COLUMN | CONSTRAINT | INDEX | PROJECTION | STATISTIC)
    | ALTER CLEAR (COLUMN | INDEX | PROJECTION)
    | ALTER (RENAME | COMMENT)? COLUMN
    | ALTER DATABASE SETTINGS
    | ALTER (DELETE | UPDATE)
    | ALTER DROP (COLUMN | CONSTRAINT | INDEX | PROJECTION | STATISTIC)
    | ALTER (FETCH | FREEZE | MOVE) PARTITION
    | ALTER MATERIALIZE (COLUMN | INDEX | PROJECTION | STATISTIC | TTL)
    | ALTER MODIFY (COLUMN | COMMENT)
    | ALTER (ORDER BY | PROJECTION | SAMPLE BY | SETTINGS | STATISTIC | TTL)
    | ALTER VIEW MODIFY (QUERY | REFRESH | SQL SECURITY)
    | CLUSTER
    | CREATE (object_type | DICTIONARY | FUNCTION | ARBITRARY? TEMPORARY TABLE)?
    | DELETE
    | DICTGET
    | DROP (object_type | DICTIONARY | FUNCTION)?
    | source_privilige
    | INSERT
    | INTROSPECTION
    | KILL (QUERY | TRANSACTION)
//  | MOVE PARTITION BETWEEN SHARDS
    | NAMED COLLECTION ADMIN?
    | NONE
    | OPTIMIZE
    | ROLE ADMIN
    | SELECT
    | SET DEFINER
    | SHOW (COLUMNS | DATABASES | DICTIONARIES | QUOTAS | ROLES | ROW POLICIES | TABLES | USERS
           | ACCESS | FILESYSTEM CACHES | SETTINGS PROFILES)?
//  | SHOW NAMED COLLECTIONS SECRETS?
    | SOURCES
    | SYSTEM
//  | SYSTEM CLEANUP
    | SYSTEM (DISTRIBUTED | REPLICATED)? SENDS
    | SYSTEM DROP (DISTRIBUTED | DNS | FILESYSTEM | MARK | QUERY | UNCOMPRESSED)? CACHE
//  | SYSTEM DROP (COMPILED EXPRESSION |CONNECTIONS | FORMAT SCHEMA | MMAP | PAGE) CACHE
    | SYSTEM DROP REPLICA
//  | SYSTEM DROP S3 CLIENT CACHE
//  | SYSTEM DROP SCHEMA CACHE
//  | SYSTEM FAILPOINT
    | SYSTEM (TTL? MERGES | MOVES | FETCHES)
//  | SYSTEM FLUSH ASYNC INSERT QUEUE
    | SYSTEM FLUSH (DISTRIBUTED | LOGS)?
//  | SYSTEM (JEMALLOC | LISTEN)
//  | SYSTEM PULLING REPLICATION LOG
    | SYSTEM RELOAD (CONFIG | DICTIONARY | EMBEDDED DICTIONARIES | FUNCTION | USERS)?
//  | SYSTEM RELOAD (ASYNCHRONOUS METRICS | MODEL)
//  | SYSTEM REPLICA READINESS
    | SYSTEM REPLICATION QUEUES
    | SYSTEM RESTART (DISK | REPLICA)
//  | SYSTEM RESTORE REPLICA
    | SYSTEM (SHUTDOWN | UNFREEZE)
    | SYSTEM SYNC (FILE CACHE | FILESYSTEM CACHE | DATABASE? REPLICA)
//  | SYSTEM SYNC TRANSACTION LOG
//  | SYSTEM THREAD FUZZER
//  | SYSTEM VIEWS
//  | SYSTEM VIRTUAL PARTS UPDATE
//  | SYSTEM WAIT LOADING PARTS
    | TRUNCATE
//  | UNDROP TABLE
    | USAGE
//  | addressToLine
//  | addressToLineWithInlines
//  | addressToSymbol
//  | demangle
//  | displaySecretsInShowAndSelect
    ;

object_type
    : DATABASE
    | NAMED COLLECTION
    | QUOTA
    | ROLE
    | ROW POLICY
    | SETTINGS PROFILE
    | TABLE
    | USER
    | VIEW
    ;

source_privilige
    : FILE
//  | BACKUP
    | URL
    | REMOTE
    | MYSQL
    | ODBC
    | JDBC
    | HDFS
//  | S3
//  | POSTGRES
//  | REDIS
//  | AZURE
//  | MONGO
//  | SQLITE
//  | HIVE
    ;

with_option
    : WITH (GRANT | REPLACE | ADMIN) OPTION
    ;

users
    : roles=identifier_list (EXCEPT excepts=identifier_list)?
    ;

alter_role_stmt
    : ALTER ROLE if_exists? name_with_cluster rename_to?
    (COMMA name_with_cluster rename_to?)*
    user_settings?
    ;

select_stmt
    :
    {selectLevel++;}
    select_ops
    {selectLevel--;}
    ;

select_stmt_no_parens
    :
    {selectLevel++;}
    select_ops_no_parens
    {selectLevel--;}
    ;

with_clause
    : WITH with_query (COMMA with_query)*
    ;

with_query
    : expr AS name=identifier
    | name=identifier AS LPAREN dml_stmt RPAREN
    ;

select_ops
    : LPAREN select_stmt RPAREN
    | select_ops (INTERSECT | EXCEPT | UNION ALL?) DISTINCT? select_ops
    | select_primary
    ;

select_ops_no_parens
    : select_ops (INTERSECT | EXCEPT | UNION ALL?) DISTINCT? select_ops
    | select_primary
    ;

create_named_collection_stmt
    : CREATE NAMED COLLECTION if_not_exists? qualified_name cluster_clause?
    AS named_collection_pair (COMMA named_collection_pair)*
    ;

create_user_stmt
    : CREATE USER (if_not_exists | OR REPLACE)? name_with_cluster (COMMA name_with_cluster)*
    (NOT IDENTIFIED | IDENTIFIED identification)?
    (HOST host)?
    (VALID UNTIL STRING_LITERAL)?
    (IN storage=identifier)?
    (DEFAULT ROLE role=users)?
    (DEFAULT DATABASE (database=identifier | NONE))?
    (GRANTEES grantees=users)?
    user_settings?
    ;

identification
    : (WITH auth_type=identifier)? BY STRING_LITERAL
    | WITH auth_type=identifier auth_params
    ;

auth_params
    : SERVER literal
    | REALM STRING_LITERAL?
    | CN STRING_LITERAL
    | BY KEY STRING_LITERAL TYPE STRING_LITERAL
    ;

host
    : host_type (COMMA host_type)*
    | ANY
    | NONE
    ;

host_type
    : LOCAL
    | (NAME | REGEXP | IP | LIKE) literal
    ;

create_role_stmt
     : CREATE ROLE (if_not_exists | OR REPLACE)? name_with_cluster (COMMA name_with_cluster)*
     (IN identifier)? user_settings?
     ;

name_with_cluster
    : identifier cluster_clause?
    ;

user_settings
    : SETTINGS user_setting ((SETTINGS | COMMA) user_setting)*
    ;

user_setting
    : identifier (EQ_SINGLE signed_number_literal)? ((MIN | MAX) EQ_SINGLE? signed_number_literal)* option_type?
    | PROFILE literal
    ;

option_type
    : CONST
    | READONLY
    | WRITABLE
    | CHANGEABLE_IN_READONLY
    ;

alter_named_collection_stmt
    : ALTER NAMED COLLECTION if_exists? qualified_name cluster_clause?
    (SET named_collection_pair (COMMA named_collection_pair)* | DELETE identifier_list)?
    ;

named_collection_pair
    : identifier EQ_SINGLE STRING_LITERAL (NOT? OVERRIDABLE)?
    ;

alter_user_stmt
    : ALTER USER if_exists? name_with_cluster rename_to?
    (COMMA name_with_cluster rename_to?)*
    (NOT IDENTIFIED | IDENTIFIED identification)?
    ((ADD | DROP)? HOST host)*
    (VALID UNTIL STRING_LITERAL)?
    (DEFAULT ROLE role=users)?
    (DEFAULT DATABASE (database=identifier | NONE))?
    (GRANTEES grantees=users)?
    user_settings?
    ;

create_policy_stmt
    : CREATE ROW? POLICY (if_not_exists | OR REPLACE)? policy_name (COMMA policy_name)* policy_action*
    ;

alter_policy_stmt
    : ALTER ROW? POLICY if_exists? policy_name rename_to? (COMMA policy_name rename_to?)* policy_action*
    ;

policy_name
    : identifier (COMMA identifier)* ON qualified_name_or_asterisk (COMMA qualified_name_or_asterisk)* cluster_clause?
    ;

policy_action
    : AS (PERMISSIVE | RESTRICTIVE)
    | USING expr
    | FOR SELECT
    | TO users
    ;

rename_to
    : RENAME TO qualified_name
    ;

alter_table_stmt
    : ALTER TEMPORARY? TABLE qualified_name cluster_clause? alter_table_actions
    ;

alter_table_actions
    : LPAREN alter_table_action (COMMA alter_table_action)* RPAREN
    | alter_table_action (COMMA alter_table_action)*
    ;

alter_table_action
    : ADD alter_table_add_action
    | ALTER COLUMN if_not_exists? qualified_name TYPE (data_type not_null?)? table_column_property_expr? codec_arg_expr? ttl_clause? settings_clause? position?
    | APPLY DELETED MASK (IN partition_clause)?
    | ATTACH partition_clause (FROM qualified_name)?
    | CLEAR alter_table_clear_action
    | COMMENT COLUMN if_exists? qualified_name STRING_LITERAL
    | DELETE (IN partition_clause)? WHERE expr
    | DETACH partition_clause
    | DROP alter_table_drop_action
    | FETCH partition_clause FROM expr
    | FREEZE partition_clause? (WITH NAME identifier)?
    | MATERIALIZE alter_table_mat_action
    | MODIFY alter_table_modify_action
    | MOVE partition_clause TO (DISK STRING_LITERAL | VOLUME STRING_LITERAL | TABLE qualified_name)
    | REMOVE (TTL | SAMPLE BY)
    | RENAME COLUMN if_exists? qualified_name TO qualified_name
    | REPLACE partition_clause FROM qualified_name
    | RESET SETTING (identifier | pair) (COMMA (identifier | pair))*
    | UNFREEZE partition_clause? WITH NAME identifier
    | UPDATE qualified_name EQ_SINGLE expr (COMMA qualified_name EQ_SINGLE expr)* (IN partition_clause)? where_clause settings_clause?
    ;

alter_table_add_action
    : COLUMN if_not_exists? table_column_def position?
    | INDEX if_not_exists? table_index_def position?
    | PROJECTION if_not_exists? table_projection_def position?
    | table_constraint_def
    | alter_statistic
    ;

alter_table_clear_action
    : (COLUMN | INDEX | PROJECTION) if_exists? qualified_name (IN partition_clause)?
    | alter_statistic
    ;

alter_table_drop_action
    : (COLUMN | INDEX | PROJECTION | CONSTRAINT) if_exists? qualified_name settings_clause?
    | DETACHED? partition_clause
    | alter_statistic
    ;

alter_table_mat_action
    : (COLUMN | INDEX | PROJECTION) if_exists? qualified_name  (IN partition_clause)?
    | alter_statistic
    | qualified_name settings_clause?
    ;

alter_table_modify_action
    : COLUMN modify_column_expr
    | order_by_clause
    | QUERY select_stmt
    | SETTING (identifier | pair) (COMMA (identifier | pair))*
    | ttl_clause
    | comment_expr
    | sample_by_clause
    | sql_security_clause definer_clause?
    ;

modify_column_expr
    : if_exists? qualified_name data_type? table_column_property_expr? codec_expr? ttl_clause? pair? position?
    | identifier MODIFY SETTING pairs
    | qualified_name REMOVE (ALIAS | CODEC | COMMENT | DEFAULT | MATERIALIZED | EPHEMERAL | TTL | SETTINGS)
    ;

alter_statistic
    : STATISTIC if_exists? qualified_name (COMMA qualified_name)* TYPE identifier
    ;

partition_clause
    : (PARTITION | PART) expr
    | PARTITION ID STRING_LITERAL
    ;

attach_stmt
    : DICTIONARY if_not_exists? qualified_name cluster_clause?
    | DATABASE if_not_exists? identifier engine_clause? cluster_clause?
    | MATERIALIZED VIEW if_not_exists? qualified_name
    | attach_table_stmt
    ;

attach_table_stmt
    : TABLE if_not_exists? qualified_name (uuid_clause | from_file_clause)?
    cluster_clause? table_body_expr? comment_expr? settings_clause?
    ;

from_file_clause
    : FROM STRING_LITERAL
    ;

check_stmt
    : CHECK TABLE qualified_name partition_clause? settings_clause?
    ;

create_database_stmt
    : CREATE DATABASE if_not_exists? name_with_cluster engine_expr? settings_clause? comment_expr?
    ;

create_view_stmt
    : (ATTACH | CREATE) (create_simple_view_stmt | create_mat_view_stmt | create_live_view_stmt) AS subquery_clause comment_expr?
    ;

create_simple_view_stmt
    : (OR REPLACE)? VIEW if_not_exists? qualified_name
    cluster_clause? table_schema_clause? definer_clause? sql_security_clause?
    ;

create_mat_view_stmt
    : MATERIALIZED VIEW if_not_exists? qualified_name
    cluster_clause? destination_clause? table_schema_clause? engine_clause? POPULATE? definer_clause? sql_security_clause?
    ;

create_live_view_stmt
    : LIVE VIEW if_not_exists? qualified_name (WITH PERIODIC? REFRESH NUMBER?)? table_schema_clause?
    ;

definer_clause
    : DEFINER EQ_SINGLE identifier
    ;

sql_security_clause
    : SQL SECURITY sec=(DEFINER | INVOKER | NONE)
    ;

subquery_clause
    : select_stmt
    | qualified_name
    | table_function_expr
    ;

create_function_stmt
    : CREATE FUNCTION qualified_name cluster_clause? AS lambda_expr
    ;

create_table_stmt
    : (CREATE (OR REPLACE)? | REPLACE) TEMPORARY? TABLE if_not_exists?
     qualified_name cluster_clause? table_body_expr comment_expr?
    ;

if_exists
    : IF EXISTS
    ;

if_not_exists
    : IF NOT EXISTS
    ;

table_body_expr
    : common_table_query_expr engine_clause?
    | engine_clause common_table_query_expr
    | LPAREN table_element_expr (COMMA table_element_expr?)* RPAREN engine_clause? common_table_query_expr?
    | LPAREN table_element_expr (COMMA table_element_expr?)* RPAREN engine_clause AS select_stmt
    | engine_clause? AS select_stmt
    ;

common_table_query_expr
    : AS qualified_name
    | AS table_function_expr
    ;

create_dictinary_stmt
    : (ATTACH | CREATE (OR REPLACE)? | REPLACE) DICTIONARY if_not_exists?
    qualified_name cluster_clause?
    LPAREN dictionary_attr_def (COMMA dictionary_attr_def)* RPAREN
    (PRIMARY KEY expr_list)?
    dictionary_option*
    comment_expr?
    ;

dictionary_attr_def
    : identifier data_type (DEFAULT literal | EXPRESSION expr)? attr_def_option?
    ;

attr_def_option
    : IS_OBJECT_ID
    | HIERARCHICAL
    | INJECTIVE
    ;

dictionary_option
    : SOURCE LPAREN identifier LPAREN dictionary_arg_expr* RPAREN RPAREN
    | LIFETIME LPAREN life_time_expr RPAREN
    | LAYOUT LPAREN layout_expr RPAREN
    | RANGE LPAREN range_expr RPAREN
    | SETTINGS LPAREN pairs RPAREN
    ;

life_time_expr
    : NUMBER
    | MIN NUMBER MAX NUMBER
    | MAX NUMBER MIN NUMBER
    ;

layout_expr
    : identifier LPAREN dictionary_arg_expr* RPAREN
    ;

range_expr
    : MIN identifier MAX identifier
    | MAX identifier MIN identifier
    ;

dictionary_arg_expr
    : identifier dictionary_arg_value
    ;

dictionary_arg_value
    : identifier blank_paren?
    | literal
    ;

cluster_clause
    : ON CLUSTER (identifier | STRING_LITERAL)
    ;

table_override_clause
    : TABLE OVERRIDE identifier LPAREN over_column? order_by_clause? primary_key_clause? partition_by_clause? sample_by_clause? ttl_clause? RPAREN
    ;

over_column
    : COLUMNS LPAREN table_element_expr (COMMA table_element_expr)* RPAREN
    ;

uuid_clause
    : UUID STRING_LITERAL
    ;

destination_clause
    : TO qualified_name
    ;

table_schema_clause
    : LPAREN table_element_expr (COMMA table_element_expr?)* RPAREN
    | AS qualified_name
    | AS table_function_expr
    ;

engine_clause
    : engine_expr engine_option*
    ;

engine_option
    : order_by_clause
    | partition_by_clause
    | primary_key_clause
    | sample_by_clause
    | ttl_clause
    | settings_clause
    ;

partition_by_clause
    : PARTITION BY expr
    ;

primary_key_clause
    : PRIMARY KEY expr
    ;

sample_by_clause
    : SAMPLE BY expr
    ;

ttl_clause
    : TTL ttl_expr_list
    ;

ttl_expr_list
    : ttl_expr (COMMA ttl_expr)*
    ;

engine_expr
    : ENGINE EQ_SINGLE? (identifier | NULL) (LPAREN expr_list? RPAREN)? (table_override_clause (COMMA table_override_clause)*)?
    ;

table_element_expr
    : primary_key_clause
    | table_column_def
    | table_constraint_def
    | INDEX table_index_def
    | PROJECTION table_projection_def
    ;

table_constraint_def
    : CONSTRAINT identifier (CHECK | ASSUME) expr
    ;

table_column_def
    : qualified_name data_type_expr not_null? comment_expr? codec_expr?
     (STATISTIC LPAREN stat=expr RPAREN)?
     (TTL ttl=expr)?
     (PRIMARY KEY)?
     (SETTINGS LPAREN pairs RPAREN)?
    ;

data_type_expr
    : not_null? table_column_property_expr
    | data_type not_null? table_column_property_expr?
    | IDENTIFIER NULL table_column_property_expr
    ;

comment_expr
    : COMMENT STRING_LITERAL
    ;

table_column_property_expr
    : ((DEFAULT | MATERIALIZED | ALIAS) expr | EPHEMERAL expr?) AUTO_INCREMENT?
    | AUTO_INCREMENT ((DEFAULT | MATERIALIZED | ALIAS) expr | EPHEMERAL expr?)
    ;

table_index_def
    : identifier expr TYPE index_type (GRANULARITY gran=NUMBER?)?
    ;

index_type
    : identifier | function_call | data_type
    ;

table_projection_def
    : qualified_name LPAREN select_stmt_no_parens RPAREN
    ;

codec_expr
    : CODEC LPAREN codec_arg_expr (COMMA codec_arg_expr)* RPAREN
    ;

codec_arg_expr
    : identifier (LPAREN expr_list? RPAREN)?
    ;

ttl_expr
    : expr (DELETE | RECOMPRESS CODEC expr | TO DISK if_exists? STRING_LITERAL | TO VOLUME STRING_LITERAL)?
    where_clause? group_by_clause?
    ;

describe_stmt
    : (DESCRIBE | DESC) TABLE? table_expr
    ;

drop_stmt
    : DROP drop_element
    ;

drop_element
    : DATABASE if_exists? name_with_cluster SYNC?
    | TEMPORARY? TABLE if_exists? (IF EMPTY)? qualified_name cluster_clause? SYNC?
    | DICTIONARY if_exists? qualified_name SYNC?
    | (ROLE | USER) if_exists? identifier_list cluster_clause? (FROM identifier)?
    | ROW? POLICY if_exists? policy_name (COMMA policy_name)* (FROM identifier)?
    | QUOTA if_exists? identifier_list cluster_clause? (FROM identifier)?
    | SETTINGS? PROFILE if_exists? identifier_list cluster_clause? (FROM identifier)?
    | VIEW if_exists? qualified_name cluster_clause? SYNC?
    | FUNCTION if_exists? name_with_cluster
    | NAMED COLLECTION if_exists? name_with_cluster
    | INDEX if_exists? identifier ON qualified_name
    ;

detach_stmt
    : DETACH (TABLE | VIEW | DICTIONARY | DATABASE) if_exists? qualified_name cluster_clause? PERMANENTLY? SYNC?
    ;

exists_stmt
    : EXISTS DATABASE identifier
    | EXISTS (DICTIONARY | TEMPORARY? TABLE | VIEW)? qualified_name
    ;

explain_stmt
    : EXPLAIN (AST | SYNTAX | QUERY TREE | PLAN | PIPELINE | ESTIMATE | TABLE OVERRIDE)? pairs? stmt
    ;

pairs
    : pair (COMMA pair)*
    ;

pair
    : identifier EQ_SINGLE expr
    ;

move_stmt
    : MOVE (USER | ROLE | QUOTA | SETTINGS PROFILE | ROW POLICY) name=identifier_list TO identifier
    ;

json_pair
    : literal COLON literal
    ;

insert_stmt
    : INSERT INTO TABLE? (qualified_name | FUNCTION table_function_expr) columns_clause? data_clause
    ;

columns_clause
    : LPAREN qualified_name (COMMA qualified_name)* RPAREN
    | LPAREN ASTERISK EXCEPT LPAREN identifier_list RPAREN RPAREN
    ;

data_clause
    : FORMAT identifier
    | VALUES values_values (COMMA values_values)*
    | select_stmt
    ;

values_values
    : LPAREN (expr | DEFAULT) (COMMA (expr | DEFAULT))* RPAREN
    ;

kill_stmt
    : KILL MUTATION cluster_clause? where_clause (SYNC | ASYNC | TEST)?
    ;

optimize_stmt
    : OPTIMIZE TABLE qualified_name cluster_clause? partition_clause? FINAL? (DEDUPLICATE optimize_by_expr?)?
    ;

optimize_by_expr
    : BY (ASTERISK | identifier_list | COLUMNS LPAREN literal RPAREN) (EXCEPT (LPAREN expr_list RPAREN | identifier | literal))?
    ;

rename_stmt
    : RENAME TABLE qualified_name TO qualified_name (COMMA qualified_name TO qualified_name)* cluster_clause?
    ;

select_primary:
    with_clause?
    SELECT DISTINCT? top_clause?
    select_list
    from_clause?
    array_join_clause?
    window_clause?
    prewhere_clause?
    where_clause?
    group_by_clause? (WITH (CUBE | ROLLUP))? (WITH TOTALS)?
    having_clause?
    order_by_clause?
    limit_by_clause?
    limit_clause?
    settings_clause?
    ;

select_list
    : expr (COMMA expr)*
    ;

select_mode
    : APPLY (LPAREN identifier RPAREN | identifier | function_call | lambda_expr)
    | EXCEPT (LPAREN expr_list RPAREN | identifier | literal)
    | REPLACE (LPAREN expr AS identifier RPAREN | expr AS identifier)
    ;

top_clause
    : TOP NUMBER (WITH TIES)?
    ;

from_clause
    : FROM from_item (COMMA from_item)*?
    ;

from_item
    : from_item (GLOBAL | LOCAL)? join_op? JOIN from_item (ON | USING) expr_list
    | from_item (GLOBAL | LOCAL)? (PASTE | CROSS) JOIN from_item
    | LPAREN from_item RPAREN
    | from_primary alias_clause? FINAL? sample_clause?
    ;

from_primary
    : qualified_name
    | function_call
    | LPAREN explain_stmt RPAREN
    | LPAREN select_ops RPAREN
    ;

array_join_clause
    : (LEFT | INNER)? ARRAY JOIN expr_list
    ;

window_clause
    : WINDOW identifier AS window_expr
    ;

prewhere_clause
    : PREWHERE expr
    ;

where_clause
    : WHERE expr
    ;

group_by_clause
    : GROUP BY grouping_element_list set_stmt?
    ;

grouping_element_list
    : grouping_element (COMMA grouping_element)*
    ;

grouping_element
    : expr
    | blank_paren
    | (ROLLUP | CUBE | GROUPING SETS) LPAREN grouping_element_list RPAREN
    ;

having_clause
    : HAVING expr
    ;

order_by_clause
    : ORDER BY (order_expr_list | blank_paren)
    ;

limit_by_clause
    : LIMIT limit_expr BY expr_list
    ;

limit_clause
    : LIMIT limit_expr (WITH TIES)?
    ;

settings_clause
    : SETTINGS pairs
    ;

join_op
    : (ALL | ANY | ASOF)? INNER
    | INNER? (ALL | ANY | ASOF)
    | (SEMI | ALL | ANTI | ANY | ASOF)? (LEFT | RIGHT) OUTER?
    | (LEFT | RIGHT) OUTER? (SEMI | ALL | ANTI | ANY | ASOF)
    | (ALL | ANY)? FULL OUTER?
    | FULL OUTER? (ALL | ANY)
    ;

sample_clause
    : SAMPLE ratio_expr (OFFSET ratio_expr)?
    ;

limit_expr
    : expr ((COMMA | OFFSET) expr)?
    ;

order_expr_list
    : order_expr (COMMA order_expr)*
    ;

order_expr
    : expr (ASCENDING | DESCENDING | DESC)? (NULLS (FIRST | LAST))? (COLLATE STRING_LITERAL)? with_fill?
    ;

with_fill
    : WITH FILL (FROM expr)? (TO expr)? (STEP expr)? (INTERPOLATE expr_list)?
    ;

ratio_expr
    : number_literal (SLASH number_literal)?
    ;

window_expr
    : identifier
    | LPAREN (PARTITION BY expr_list)? order_by_clause? ((ROWS | RANGE) win_frame_extend)? RPAREN
    ;

win_frame_extend
    : win_frame_bound
    | BETWEEN win_frame_bound AND win_frame_bound
    ;

win_frame_bound
    : CURRENT ROW
    | UNBOUNDED PRECEDING
    | UNBOUNDED FOLLOWING
    | number_literal PRECEDING
    | number_literal FOLLOWING
    ;

transaction_stmt
    : (BEGIN | ROLLBACK | COMMIT) TRANSACTION?
    ;

set_stmt
    : SET pairs
    ;

show_stmt
    : ACCESS
    | CHANGED? SETTINGS like_expr?
    | (CLUSTER | SETTING) expr
    | CREATE (ROLE | QUOTA) identifier_list
    | CREATE ROW? POLICY (identifier | identifier? (ON expr_list))
    | CREATE SETTINGS? PROFILE identifier_list
    | CREATE TEMPORARY? qualified_name
    | CREATE USER identifier_list?
    | CREATE? TEMPORARY? (TABLE | DICTIONARY | VIEW | DATABASE) qualified_name
    | CURRENT? QUOTA
    | (CURRENT | ENABLED)? ROLES
    | (DATABASES | MERGES | CLUSTERS) like_expr? limit_clause?
    | DICTIONARIES from_in_db? (like_expr | where_clause)? limit_clause?
    | ENGINES
    | EXTENDED? (INDEX | INDEXES | INDICES | KEYS) (FROM | IN) qualified_name from_in_db? (WHERE expr)?
    | EXTENDED? FULL? (FIELDS | COLUMNS) (FROM | IN) qualified_name from_in_db? (like_expr | where_clause)? limit_clause?
    | FILESYSTEM CACHES
    | FULL? TEMPORARY? TABLES from_in_db? (like_expr | where_clause)? limit_clause?
    | FUNCTIONS like_expr?
    | GRANTS (FOR identifier_list)?
    | PRIVILEGES
    | PROCESSLIST
    | QUOTAS
    | ROW? POLICIES (ON expr)?
    | SETTINGS? PROFILES
    | USERS
    ;

like_expr
    : NOT? (LIKE | ILIKE) expr
    ;

from_in_db
    : (FROM | IN) identifier
    ;

system_stmt
    : SYSTEM FLUSH DISTRIBUTED qualified_name
    | SYSTEM FLUSH LOGS
    | SYSTEM RELOAD DICTIONARIES
    | SYSTEM RELOAD DICTIONARY qualified_name
    | SYSTEM (START | STOP) (DISTRIBUTED SENDS | FETCHES | TTL? MERGES) qualified_name
    | SYSTEM (START | STOP) REPLICATED SENDS
    | SYSTEM SYNC REPLICA qualified_name
    ;

truncate_stmt
    : TRUNCATE TEMPORARY? TABLE? if_exists? qualified_name cluster_clause?
    ;

use_stmt
    : USE identifier
    ;

watch_stmt
    : WATCH qualified_name EVENTS? (LIMIT NUMBER)?
    ;

data_type
    : AGGREGATE_FUNCTION LPAREN identifier (COMMA data_type)+ RPAREN
    | ARRAY LPAREN data_type RPAREN
    | BINARY
    | BINARY LARGE OBJECT
    | BINARY VARYING
    | BIT
    | BLOB
    | BOOLEAN
    | BYTE
    | BYTEA
    | CHAR
    | CHAR LARGE OBJECT
    | CHAR VARYING
    | CHARACTER
    | CHARACTER LARGE OBJECT
    | CHARACTER VARYING
    | CLOB
    | DATE
    | DATETIME (LPAREN STRING_LITERAL RPAREN)?
    | DATETIME64 LPAREN number_literal (COMMA STRING_LITERAL)? RPAREN
    | DECIMAL LPAREN signed_number_literal COMMA signed_number_literal RPAREN
    | DECIMAL_BIT LPAREN signed_number_literal RPAREN
    | DOUBLE PRECISION? precision?
    | ENUM LPAREN enum_value (COMMA enum_value)* RPAREN
    | FIXED
    | FIXED_STRING LPAREN number_literal RPAREN
    | FLOAT precision?
    | GEOMETRY
    | INT_TYPE
    | INTERVAL_TYPE
    | IPV4
    | IPV6
    | JSON
    | LONGBLOB
    | LONGTEXT
    | LOW_CARDINALITY LPAREN data_type RPAREN
    | MAP LPAREN key=data_type COMMA value=data_type RPAREN
    | MEDIUMBLOB
    | MEDIUMTEXT
    | MULTI_POLYGON
    | NATIONAL CHAR VARYING?
    | NATIONAL CHARACTER
    | NATIONAL CHARACTER LARGE OBJECT
    | NATIONAL CHARACTER VARYING
    | NCHAR
    | NCHAR LARGE OBJECT
    | NCHAR VARYING
    | NESTED LPAREN identifier data_type (COMMA identifier data_type)* RPAREN
    | NOTHING
    | NULLABLE LPAREN data_type RPAREN
    | NUMERIC
    | NVARCHAR
    | OBJECT_TYPE LPAREN STRING_LITERAL RPAREN
    | POINT
    | POLYGIN
    | REAL
    | RING
    | SET
    | SINGLE
    | STRING
    | TEXT
    | TIME
    | TIMESTAMP
    | TINYBLOB
    | TINYTEXT
    | TUPLE LPAREN tuple_element (COMMA tuple_element)* RPAREN
    | UUID
    | VARBINARY
    | VARCHAR
    | YEAR
    | (INT | INTEGER | BIGINT | MEDIUMINT | SMALLINT | TINYINT) (UNSIGNED | SIGNED)? precision?
    ;

precision
    : LPAREN signed_number_literal (COMMA signed_number_literal)? RPAREN
    ;

tuple_element
    : identifier? data_type
    ;

expr_list
    : expr (COMMA expr)*
    ;

expr
    : expr CAST_EXPRESSION data_type alias_expr?
    | expr LBRACKET expr RBRACKET alias_expr?
    | expr IS NOT? NULL
    | (PLUS | MINUS) expr
    | expr op expr
    | expr (MOD | DIV) expr
    | expr (GLOBAL? NOT? IN) expr
    | expr like_expr
    | NOT expr
    | expr NOT? BETWEEN expr AND expr
    | expr QUESTION expr COLON expr
    | expr select_mode
    | expr DOT literal alias_expr? // tuple
    | expr_primary alias_expr?
    ;

alias_expr
    : {selectLevel > 0}? alias_clause  // only available in select
    ;

expr_primary
    : literal
    | (qualified_name DOT)? ASTERISK
    | qualified_name
    | DATE STRING_LITERAL
    | function_call
    | lambda_expr
    | LPAREN select_stmt_no_parens RPAREN
    | LPAREN expr_list COMMA? RPAREN
    | LBRACKET expr_list? RBRACKET
    | LBRACE identifier COLON data_type RBRACE
    | LBRACE json_pair (COMMA json_pair)* RBRACE
    | GLOBAL_VARIABLE
    ;

op
    : EQ_DOUBLE
    | EQ_SINGLE
    | NOT_EQ
    | LE
    | GE
    | LT
    | GT
    | CONCAT
    | PLUS
    | MINUS
    | ASTERISK
    | SLASH
    | PERCENT
    | AND
    | OR
    | NOT_DIST
    ;

function_call
    : CASE expr? (WHEN expr THEN expr)+ (ELSE expr)? END
    | COLUMNS LPAREN column=literal RPAREN
    | identifier? CAST LPAREN expr AS data_type RPAREN // when using the data_type rule there are ambiguities with the simple function
    | INTERVAL (expr interval | STRING_LITERAL)
    | EXTRACT LPAREN interval FROM expr RPAREN
    | SUBSTRING LPAREN expr FROM expr (FOR expr)? RPAREN
    | TIMESTAMP STRING_LITERAL
    | TRIM LPAREN (BOTH | LEADING | TRAILING) expr FROM expr RPAREN
    | name=identifier ((LPAREN expr RPAREN)? LPAREN expr_list? RPAREN) OVER window_expr
    | name=identifier (LPAREN expr_list? RPAREN)? LPAREN DISTINCT? arg_list? RPAREN
    ;

arg_list
    : arg_expr (COMMA arg_expr)*
    ;

arg_expr
    : select_stmt_no_parens
    | expr
    ;

lambda_expr
    : function_arguments ARROW expr
    ;

function_arguments
    : blank_paren
    | identifier
    | LPAREN identifier_list RPAREN
    ;

qualified_name
    : identifier (DOT identifier (DOT identifier)?)? uuid_clause?
    ;

qualified_name_or_asterisk
    : qualified_name
    | (qualified_name DOT)? ASTERISK
    ;

// Tables

table_expr
    : qualified_name
    | table_function_expr
    | LPAREN select_ops RPAREN
    | table_expr alias_clause
    ;

table_function_expr
    : identifier LPAREN table_arg_list? RPAREN
    ;

table_arg_list
    : table_arg_expr (COMMA table_arg_expr)*
    ;

table_arg_expr
    : qualified_name
    | function_call
    | literal
    ;

number_literal
    : FLOATING_LITERAL
    | NUMBER
    | INF
    | NAN
    ;

signed_number_literal
    : sign? number_literal
    ;

sign
    : PLUS
    | MINUS
    ;

literal
    : number_literal
    | STRING_LITERAL
    // | DOLLAR_LITERAL
    | NULL
    | BINARY_LITERAL
    ;

interval
    : NANOSECOND
    | MICROSECOND
    | MILLISECOND
    | SECOND
    | MINUTE
    | HOUR
    | DAY
    | WEEK
    | MONTH
    | QUARTER
    | YEAR
    ;

tokens_nonreserved
    : ACCESS
    | ADD
    | ADMIN
    | AFTER
    | AGGREGATE_FUNCTION
    | ALIAS
    | ALTER
    | AND
    | APPLY
    | ARBITRARY
    | ASCENDING
    | ASSUME
    | AST
    | ASYNC
    | ATTACH
    | AUTO_INCREMENT
    | BEGIN
    | BIGINT
    | BINARY
    | BIT
    | BLOB
    | BOOLEAN
    | BOTH
    | BY
    | BYTE
    | BYTEA
    | CACHE
    | CACHES
    | CASE
    | CAST
    | CHANGED
    | CHANGEABLE_IN_READONLY
    | CHAR
    | CHARACTER
    | CHECK
    | CLEAR
    | CLOB
    | CLUSTER
    | CLUSTERS
    | CN
    | CODEC
    | COLLATE
    | COLLECTION
    | COLUMN
    | COLUMNS
    | COMMENT
    | COMMIT
    | CONFIG
    | CONST
    | CONSTRAINT
    | CREATE
    | CUBE
    | CURRENT
    | CURRENT_USER
    | DATABASE
    | DATABASES
    | DATE
    | DATETIME
    | DATETIME64
    | DECIMAL
    | DECIMAL_BIT
    | DEDUPLICATE
    | DEFAULT
    | DEFINER
    | DELAY
    | DELETE
    | DELETED
    | DESC
    | DESCENDING
    | DESCRIBE
    | DETACH
    | DETACHED
    | DICTGET
    | DICTIONARIES
    | DICTIONARY
    | DISK
    | DISTINCT
    | DISTRIBUTED
    | DIV
    | DNS
    | DOUBLE
    | DROP
    | EMPTY
    | ENABLED
    | END
    | ENGINE
    | ENGINES
    | ENUM
    | EMBEDDED
    | EPHEMERAL
    | ESTIMATE
    | EVENTS
    | EXISTS
    | EXPLAIN
    | EXPRESSION
    | EXTENDED
    | EXTRACT
    | FETCH
    | FETCHES
    | FIELDS
    | FILE
    | FILESYSTEM
    | FILL
    | FIRST
    | FIXED
    | FIXED_STRING
    | FLOAT
    | FLUSH
    | FOLLOWING
    | FOR
    | FREEZE
    | FUNCTION
    | FUNCTIONS
    | GEOMETRY
    | GRANT
    | GRANTEES
    | GRANTS
    | GRANULARITY
    | GROUPING
    | HDFS
    | HIERARCHICAL
    | HOST
    | ID
    | IDENTIFIED
    | IF
    | IN
    | INDEX
    | INDEXES
    | INDICES
    | INJECTIVE
    | INSERT
    | INT
    | INT_TYPE
    | INTEGER
    | INTERPOLATE
    | INTERVAL
    | INTERVAL_TYPE
    | INTROSPECTION
    | INVOKER
    | IP
    | IPV4
    | IPV6
    | IS
    | IS_OBJECT_ID
    | JSON
    | JDBC
    | KEY
    | KEYS
    | KILL
    | LARGE
    | LAST
    | LAYOUT
    | LEADING
    | LIFETIME
    | LIVE
    | LOCAL
    | LOGS
    | LONGBLOB
    | LONGTEXT
    | LOW_CARDINALITY
    | MAP
    | MARK
    | MASK
    | MANAGEMENT
    | MATERIALIZE
    | MATERIALIZED
    | MAX
    | MEDIUMBLOB
    | MEDIUMINT
    | MEDIUMTEXT
    | MERGES
    | MICROSECOND
    | MILLISECOND
    | MIN
    | MOD
    | MODIFY
    | MOVE
    | MOVES
    | MULTI_POLYGON
    | MUTATION
    | MYSQL
    | NAME
    | NAMED
    | NANOSECOND
    | NATIONAL
    | NCHAR
    | NESTED
    | NO
    | NONE
    | NOTHING
    | NULLABLE
    | NULLS
    | NUMERIC
    | NVARCHAR
    | OBJECT
    | OBJECT_TYPE
    | ODBC
    | OPTIMIZE
    | OPTION
    | OR
    | OUTER
    | OUTFILE
    | OVER
    | OVERRIDABLE
    | OVERRIDE
    | PART
    | PARTITION
    | PERIODIC
    | PERMANENTLY
    | PERMISSIVE
    | PIPELINE
    | PLAN
    | POINT
    | POLICIES
    | POLICY
    | POLYGIN
    | POPULATE
    | PRECEDING
    | PRECISION
    | PRIMARY
    | PRIVILEGES
    | PROCESSLIST
    | PROFILE
    | PROFILES
    | PROJECTION
    | QUERY
    | QUOTA
    | QUOTAS
    | QUEUES
    | RANGE
    | READONLY
    | REALM
    | REAL
    | RECOMPRESS
    | REFRESH
    | REGEXP
    | RELOAD
    | REMOVE
    | REMOTE
    | RENAME
    | REPLACE
    | REPLICA
    | REPLICATED
    | REPLICATION
    | RESET
    | RESTART
    | RESTRICTIVE
    | REVOKE
    | RING
    | ROLE
    | ROLES
    | ROLLBACK
    | ROLLUP
    | ROW
    | ROWS
    | SECURITY
    | SELECT
    | SENDS
    | SERVER
    | SET
    | SETS
    | SETTING
    | SHOW
    | SHUTDOWN
    | SIGNED
    | SINGLE
    | SMALLINT
    | SOURCE
    | SOURCES
    | SQL
    | START
    | STATISTIC
    | STEP
    | STOP
    | STRING
    | SUBSTRING
    | SYNC
    | SYNTAX
    | SYSTEM
    | TABLE
    | TABLES
    | TEMPORARY
    | TEST
    | TEXT
    | THEN
    | TIES
    | TIME
    | TIMEOUT
    | TIMESTAMP
    | TINYBLOB
    | TINYINT
    | TINYTEXT
    | TO
    | TOP
    | TOTALS
    | TRAILING
    | TRANSACTION
    | TREE
    | TRIM
    | TRUNCATE
    | TTL
    | TUPLE
    | TYPE
    | UNBOUNDED
    | UNFREEZE
    | UNCOMPRESSED
    | UNSIGNED
    | UNTIL
    | UPDATE
    | URL
    | USAGE
    | USE
    | USER
    | USERS
    | VALID
    | VALUES
    | VARBINARY
    | VARCHAR
    | VARYING
    | VIEW
    | VOLUME
    | WATCH
    | WHEN
    | WRITABLE
    ;

alias_clause
    : AS identifier
    | id_token
    ;

tokens_reserved
    : ALL
    | ANTI
    | ANY
    | ARRAY
    | AS
    | ASOF
    | BETWEEN
    | CROSS
    | ELSE
    | EXCEPT
    | FINAL
    | FORMAT
    | FROM
    | FULL
    | GLOBAL
    | GROUP
    | HAVING
    | ILIKE
    | INNER
    | INTERSECT
    | INTO
    | JOIN
    | LEFT
    | LIKE
    | LIMIT
    | NOT
    | OFFSET
    | ON
    | ORDER
    | PASTE
    | PREWHERE
    | RIGHT
    | SAMPLE
    | SEMI
    | SETTINGS
    | UNION
    | USING
    | UUID
    | WHERE
    | WINDOW
    | WITH
    ;

identifier_list
    : identifier (COMMA identifier)*
    ;

identifier
    : id_token
    | tokens_reserved
    ;

id_token
    : IDENTIFIER
    | DOUBLE_QUOTED_IDENTIFIER
    | BACK_QUOTED_IDENTIFIER
    | tokens_nonreserved
    | interval
    | LBRACE identifier COLON IDENTIFIER RBRACE
    ;

enum_value
    : (STRING_LITERAL | NULL) (EQ_SINGLE signed_number_literal)?
    ;

not_null
    : NOT? NULL
    ;

position
    : AFTER qualified_name
    | FIRST
    ;

blank_paren
    : LPAREN RPAREN
    ;
