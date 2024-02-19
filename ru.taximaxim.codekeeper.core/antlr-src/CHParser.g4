parser grammar CHParser;

options {
    language=Java;
    tokenVocab=CHLexer;
}

@header {package ru.taximaxim.codekeeper.core.parsers.antlr.generated;}

// Top-level statements

ch_file
    : BOM? SEMICOLON* (query (SEMICOLON+ | EOF))* EOF
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
    | attach_stmt
    | create_stmt
    | drop_stmt
    | kill_stmt
    | optimize_stmt
    | rename_stmt
    | truncate_stmt
    ;

dml_stmt
    : check_stmt
    | describe_stmt
    | exists_stmt
    | explain_stmt
    | set_stmt
    | show_stmt
    | system_stmt
    | use_stmt
    | watch_stmt
    | ctes? insert_stmt
    | select_stmt
    ;

ctes
    : WITH named_query (COMMA named_query)*
    ;

named_query
    : name=identifier (column_aliases)? AS LPAREN dml_stmt RPAREN
    ;

select_stmt
    : ctes? select_ops
    ;

select_stmt_no_parens
    : ctes? select_ops_no_parens
    ;

with_clause
    : WITH expr_list
    ;

select_ops
    : LPAREN select_stmt RPAREN
    | select_ops UNION ALL select_ops
    | select_primary
    ;

select_ops_no_parens
    : select_ops UNION ALL select_ops
    | select_primary
    ;

column_aliases
    : LPAREN identifier (COMMA identifier)* RPAREN
    ;

alter_stmt
    : ALTER TEMPORARY? TABLE qualified_name cluster_clause? alter_table_action (COMMA alter_table_action)*
    ;

alter_table_action
    : ADD alter_table_add_action
    | ALTER COLUMN if_not_exists? qualified_name TYPE (data_type not_null?)? table_column_property_expr? codec_arg_expr? ttl_clause? settings_clause? position?
    | APPLY DELETED MASK (IN partition_clause)?
    | ATTACH partition_clause (FROM qualified_name)?
    | CLEAR alter_table_clear_action
    | COMMENT COLUMN (IF EXISTS)? qualified_name STRING_LITERAL
    | DELETE (IN partition_clause)? WHERE expr
    | DETACH partition_clause
    | DROP alter_table_drop_action
    | FETCH partition_clause FROM expr
    | FREEZE partition_clause? (WITH NAME identifier)?
    | MATERIALIZE alter_table_mat_action
    | MODIFY alter_table_modify_action
    | MOVE partition_clause TO (DISK STRING_LITERAL | VOLUME STRING_LITERAL | TABLE qualified_name)
    | REMOVE (TTL | SAMPLE BY)
    | RENAME COLUMN (IF EXISTS)? qualified_name TO qualified_name
    | REPLACE partition_clause FROM qualified_name
    | RESET SETTING (identifier | setting_expr) (COMMA (identifier | setting_expr))*
    | UNFREEZE partition_clause? WITH NAME identifier
    | UPDATE qualified_name EQ_SINGLE expr (COMMA qualified_name EQ_SINGLE expr)* (IN partition_clause)? where_clause settings_clause?
    ;

alter_table_add_action
    : COLUMN if_not_exists? table_column_def position?
    | INDEX if_not_exists? table_index_def position?
    | PROJECTION if_not_exists? table_projection_def position?
    | CONSTRAINT identifier CHECK expr
    | alter_statistic
    ;

alter_table_clear_action
    : (COLUMN | INDEX | PROJECTION) (IF EXISTS)? qualified_name (IN partition_clause)?
    | alter_statistic
    ;

alter_table_drop_action
    : (COLUMN | INDEX | PROJECTION | CONSTRAINT) (IF EXISTS)? qualified_name settings_clause?
    | DETACHED? partition_clause
    | alter_statistic
    ;

alter_table_mat_action
    : (COLUMN | INDEX | PROJECTION) (IF EXISTS)? qualified_name  (IN partition_clause)?
    | alter_statistic
    | qualified_name settings_clause?
    ;

alter_table_modify_action
    : modify_column_expr
    | order_by_clause
    | QUERY select_stmt
    | SETTING (identifier | setting_expr) (COMMA (identifier | setting_expr))*
    | ttl_clause
    | comment_expr
    | sample_by_clause
    ;

modify_column_expr
    : COLUMN (IF EXISTS)? qualified_name data_type? table_column_property_expr? codec_expr? ttl_clause? setting_expr? position?
    | COLUMN qualified_name REMOVE (ALIAS | CODEC | COMMENT | DEFAULT | MATERIALIZED | EPHEMERAL | TTL | SETTINGS)
    ;

alter_statistic
    : STATISTIC (IF EXISTS)? qualified_name (COMMA qualified_name)* TYPE identifier
    ;

partition_clause
    : (PARTITION | PART) expr
    | PARTITION ID STRING_LITERAL
    ;

attach_stmt
    : ATTACH DICTIONARY qualified_name cluster_clause?
    ;

check_stmt
    : CHECK TABLE qualified_name partition_clause?
    ;

create_stmt
    : create_database_stmt
    | create_dictinary_stmt
    | create_live_view_stmt
    | create_mat_view_stmt
    | create_table_stmt
    | create_view_stmt
    | create_function_stmt
    ;

create_database_stmt
    : (ATTACH | CREATE) DATABASE if_not_exists? identifier cluster_clause? engine_expr?
    ;

create_view_stmt
    : (ATTACH | CREATE) (OR REPLACE)? VIEW if_not_exists? qualified_name
    uuid_clause? cluster_clause? table_schema_clause? subquery_clause
    ;

create_live_view_stmt
    : (ATTACH | CREATE) LIVE VIEW if_not_exists? qualified_name uuid_clause? cluster_clause?
    (WITH TIMEOUT DECIMAL_LITERAL?)? destination_clause? table_schema_clause? subquery_clause
    ;

create_function_stmt
    : CREATE FUNCTION qualified_name cluster_clause? AS column_lambda_expr
    ;

create_table_stmt
    : (ATTACH | CREATE (OR REPLACE)? | REPLACE) TEMPORARY? TABLE if_not_exists?
     qualified_name uuid_clause? cluster_clause? table_body_expr comment_expr?
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
    qualified_name uuid_clause? cluster_clause?
    LPAREN dictionary_attr_def (COMMA dictionary_attr_def)* RPAREN
    (PRIMARY KEY expr_list)?
    dictionary_option*
    ;

dictionary_attr_def
    : identifier data_type (DEFAULT literal | EXPRESSION expr | HIERARCHICAL | INJECTIVE | IS_OBJECT_ID)*
    ;

dictionary_option
    : SOURCE LPAREN identifier LPAREN dictionary_arg_expr* RPAREN RPAREN
    | LIFETIME LPAREN (DECIMAL_LITERAL | MIN DECIMAL_LITERAL MAX DECIMAL_LITERAL | MAX DECIMAL_LITERAL MIN DECIMAL_LITERAL) RPAREN
    | LAYOUT LPAREN identifier LPAREN dictionary_arg_expr* RPAREN RPAREN
    | RANGE LPAREN (MIN identifier MAX identifier | MAX identifier MIN identifier) RPAREN
    | SETTINGS LPAREN setting_expr_list RPAREN
    ;

dictionary_arg_expr
    : identifier (identifier blank_paren? | literal)
    ;

cluster_clause
    : ON CLUSTER (identifier | STRING_LITERAL)
    ;

uuid_clause
    : UUID STRING_LITERAL
    ;

create_mat_view_stmt
    : (ATTACH | CREATE) MATERIALIZED VIEW if_not_exists? qualified_name uuid_clause? cluster_clause?
    destination_clause? table_schema_clause? engine_clause? POPULATE?
    subquery_clause
    ;

destination_clause
    : TO qualified_name
    ;

subquery_clause
    : AS (select_stmt | qualified_name | table_function_expr)
    ;

table_schema_clause
    : LPAREN table_element_expr (COMMA table_element_expr?)* RPAREN
    | AS qualified_name
    | AS table_function_expr
    ;

engine_clause
    : engine_expr (order_by_clause | partition_by_clause | primary_key_clause | sample_by_clause | ttl_clause | settings_clause)*
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
    : TTL ttl_expr (COMMA ttl_expr)*
    ;

engine_expr
    : ENGINE EQ_SINGLE? (identifier | NULL) (LPAREN expr_list? RPAREN)?
    ;

table_element_expr
    : primary_key_clause
    | table_column_def
    | CONSTRAINT identifier (CHECK | ASSUME) expr
    | INDEX table_index_def
    | PROJECTION table_projection_def
    ;

table_column_def
    : qualified_name data_type_expr not_null? comment_expr? codec_expr?
     (STATISTIC LPAREN expr RPAREN)?
     (TTL expr)?
     (PRIMARY KEY)?
     (SETTINGS LPAREN setting_expr_list RPAREN)?
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
    : qualified_name expr TYPE (identifier | function_call | data_type) (GRANULARITY DECIMAL_LITERAL?)?
    ;

table_projection_def
    : qualified_name projection_select_stmt
    ;

codec_expr
    : CODEC LPAREN codec_arg_expr (COMMA codec_arg_expr)* RPAREN
    ;

codec_arg_expr
    : identifier (LPAREN expr_list? RPAREN)?
    ;

ttl_expr
    : expr (DELETE | RECOMPRESS CODEC expr | TO DISK (IF EXISTS)? STRING_LITERAL | TO VOLUME STRING_LITERAL)?
    where_clause? group_by_clause?
    ;

describe_stmt
    : (DESCRIBE | DESC) TABLE? table_expr
    ;

drop_stmt
    : (DETACH | DROP) DATABASE (IF EXISTS)? identifier cluster_clause?
    | (DETACH | DROP) (DICTIONARY | TEMPORARY? VIEW) (IF EXISTS)? qualified_name cluster_clause? (NO DELAY)?
    | drop_function_stmt
    | drop_table_stmt
    ;

drop_function_stmt
    : DROP FUNCTION (IF EXISTS)? qualified_name
    ;

drop_table_stmt
    : DROP TEMPORARY? TABLE (IF EXISTS)? (IF EMPTY)? qualified_name cluster_clause? SYNC?
    ;

exists_stmt
    : EXISTS DATABASE identifier
    | EXISTS (DICTIONARY | TEMPORARY? TABLE | VIEW)? qualified_name (INTO OUTFILE expr)? (FORMAT expr)?
    ;

explain_stmt
    : EXPLAIN (AST | SYNTAX) stmt
    ;

insert_stmt
    : INSERT INTO TABLE? (qualified_name | FUNCTION table_function_expr) columns_clause? data_clause
    ;

columns_clause
    : LPAREN qualified_name (COMMA qualified_name)* RPAREN
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
    : BY (ASTERISK | identifier (COMMA identifier)* | COLUMNS expr) (EXCEPT expr)?
    ;

rename_stmt
    : RENAME TABLE qualified_name TO qualified_name (COMMA qualified_name TO qualified_name)* cluster_clause?
    ;

projection_select_stmt:
    LPAREN
    with_clause?
    SELECT expr_list
    group_by_clause?
    order_by_clause?
    RPAREN
    ;

select_primary:
    with_clause?
    SELECT DISTINCT? top_clause?
    select_list COMMA? // strange but valid syntax: select 1, from t
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
    : expr select_mode* (COMMA expr select_mode*)*
    ;

select_mode
    : APPLY (LPAREN identifier RPAREN | identifier)
    | EXCEPT (LPAREN expr_list RPAREN | expr)
    | REPLACE (LPAREN expr RPAREN | expr)
    ;

top_clause
    : TOP DECIMAL_LITERAL (WITH TIES)?
    ;

from_clause
    : FROM from_item (COMMA from_item)*?
    ;

from_item
    : from_item (GLOBAL | LOCAL)? join_op? JOIN from_item (ON | USING) expr_list
    | from_item (GLOBAL | LOCAL)? CROSS JOIN from_item
    | LPAREN from_item RPAREN
    | from_primary alias_clause? FINAL? sample_clause?
    ;

from_primary
    : qualified_name
    | function_call
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
    : GROUP BY grouping_element_list
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
    : SETTINGS setting_expr_list
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

setting_expr_list
    : setting_expr (COMMA setting_expr)*
    ;

setting_expr
    : identifier EQ_SINGLE expr
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
    : (CURRENT ROW | UNBOUNDED PRECEDING | UNBOUNDED FOLLOWING | number_literal PRECEDING | number_literal FOLLOWING)
    ;

//range_clause
//    : RANGE LPAREN (MIN identifier MAX identifier | MAX identifier MIN identifier) RPAREN
//    ;

set_stmt
    : SET setting_expr_list
    ;

show_stmt
    : SHOW CREATE DATABASE identifier
    | SHOW CREATE DICTIONARY qualified_name
    | SHOW CREATE TEMPORARY? TABLE? qualified_name
    | SHOW DATABASES
    | SHOW DICTIONARIES (FROM identifier)?
    | SHOW TEMPORARY? TABLES ((FROM | IN) identifier)? (LIKE STRING_LITERAL | where_clause)? limit_clause?
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
    : TRUNCATE TEMPORARY? TABLE? (IF EXISTS)? qualified_name cluster_clause?
    ;

use_stmt
    : USE identifier
    ;

watch_stmt
    : WATCH qualified_name EVENTS? (LIMIT DECIMAL_LITERAL)?
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
    : expr CAST_EXPRESSION data_type
    | expr LBRACKET expr RBRACKET
    | expr IS NOT? NULL
    | (PLUS | MINUS) expr
    | expr op expr
    | expr (GLOBAL? NOT? IN | NOT? (LIKE | ILIKE)) expr
    | NOT expr
    | expr NOT? BETWEEN expr AND expr
    | expr QUESTION expr COLON expr
    | expr alias_clause
    | expr APPLY expr
    | expr_primary
    ;

expr_primary
    : literal
    | (qualified_name DOT)? ASTERISK
    | qualified_name
    | DATE STRING_LITERAL
    | function_call (DOT DECIMAL_LITERAL)?
    | identifier (DOT DECIMAL_LITERAL)+
    | LPAREN select_stmt_no_parens RPAREN
    | LPAREN expr_list RPAREN (DOT literal)*
    | LBRACKET expr_list? RBRACKET
    | LBRACE identifier COLON data_type RBRACE
    | LBRACE literal COLON literal RBRACE
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
    ;

function_call
    : CASE expr? (WHEN expr THEN expr)+ (ELSE expr)? END
    | identifier? CAST LPAREN expr AS data_type RPAREN // when using the data_type rule there are ambiguities with the simple function
    | INTERVAL (expr interval | STRING_LITERAL)
    | EXTRACT LPAREN interval FROM expr RPAREN
    | SUBSTRING LPAREN expr FROM expr (FOR expr)? RPAREN
    | TIMESTAMP STRING_LITERAL
    | TRIM LPAREN (BOTH | LEADING | TRAILING) STRING_LITERAL FROM expr RPAREN
    | identifier ((LPAREN expr RPAREN)? LPAREN expr_list? RPAREN) OVER window_expr
    | identifier (LPAREN expr_list? RPAREN) OVER identifier
    | identifier (LPAREN expr_list? RPAREN)? LPAREN DISTINCT? column_arg_list? RPAREN
    ;

column_arg_list
    : column_arg_expr (COMMA column_arg_expr)*
    ;

column_arg_expr
    : column_lambda_expr
    | select_stmt_no_parens
    | expr
    ;

column_lambda_expr
    : function_arguments ARROW expr
    ;

function_arguments
    : blank_paren
    | identifier
    | LPAREN identifier (COMMA identifier)* RPAREN
    ;

qualified_name
    : identifier (DOT identifier (DOT identifier)?)?
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

// Basics

floating_literal
    : FLOATING_LITERAL
    | DOT (DECIMAL_LITERAL | OCTAL_LITERAL)
    | DECIMAL_LITERAL DOT (DECIMAL_LITERAL | OCTAL_LITERAL)?  // can't move this to the lexer or it will break nested tuple access: t.1.2
    ;

number_literal
    : floating_literal | OCTAL_LITERAL | DECIMAL_LITERAL | HEXADECIMAL_LITERAL | INF | NAN
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
    // | BeginDollarStringConstant Text_between_Dollar* EndDollarStringConstant
    | NULL
    ;

interval
    : SECOND | MINUTE | HOUR | DAY | WEEK | MONTH | QUARTER | YEAR
    ;

keyword
    : ADD
    | AFTER
    | AGGREGATE_FUNCTION
    | ALIAS
    | ALL
    | ALTER
    | AND
    | ANTI
    | ANY
    | APPLY
    | ARRAY
    | AS
    | ASCENDING
    | ASOF
    | ASSUME
    | AST
    | ASYNC
    | ATTACH
    | AUTO_INCREMENT
    | BETWEEN
    | BIGINT
    | BINARY
    | BIT
    | BLOB
    | BOOLEAN
    | BOTH
    | BY
    | BYTE
    | BYTEA
    | CASE
    | CAST
    | CHAR
    | CHARACTER
    | CHECK
    | CLEAR
    | CLOB
    | CLUSTER
    | CODEC
    | COLLATE
    | COLUMN
    | COLUMNS
    | COMMENT
    | CONSTRAINT
    | CREATE
    | CROSS
    | CUBE
    | CURRENT
    | DATABASE
    | DATABASES
    | DATE
    | DATETIME
    | DATETIME64
    | DECIMAL
    | DECIMAL_BIT
    | DEDUPLICATE
    | DEFAULT
    | DELAY
    | DELETE
    | DELETED
    | DESC
    | DESCENDING
    | DESCRIBE
    | DETACH
    | DETACHED
    | DICTIONARIES
    | DICTIONARY
    | DISK
    // | DISTINCT
    | DISTRIBUTED
    | DOUBLE
    | DROP
    | ELSE
    | EMPTY
    | END
    | ENGINE
    | ENUM
    | EPHEMERAL
    | EVENTS
    | EXCEPT
    | EXISTS
    | EXPLAIN
    | EXPRESSION
    | EXTRACT
    | FETCH
    | FETCHES
    | FILL
    | FINAL
    | FIRST
    | FIXED
    | FIXED_STRING
    | FLOAT
    | FLUSH
    | FOLLOWING
    | FOR
    | FORMAT
    | FREEZE
    | FROM
    | FULL
    | FUNCTION
    | GEOMETRY
    | GLOBAL
    | GRANULARITY
    | GROUP
    | GROUPING
    | HAVING
    | HIERARCHICAL
    | ID
    | IF
    | ILIKE
    | IN
    | INDEX
    | INF
    | INJECTIVE
    | INNER
    | INSERT
    | INT
    | INT_TYPE
    | INTEGER
    | INTERPOLATE
    | INTERVAL
    | INTERVAL_TYPE
    | INTO
    | IPV4
    | IPV6
    | IS
    | IS_OBJECT_ID
    | JOIN
    | JSON
    | KEY
    | KILL
    | LARGE
    | LAST
    | LAYOUT
    | LEADING
    | LEFT
    | LIFETIME
    | LIKE
    | LIMIT
    | LIVE
    | LOCAL
    | LOGS
    | LONGBLOB
    | LONGTEXT
    | LOW_CARDINALITY
    | MAP
    | MASK
    | MATERIALIZE
    | MATERIALIZED
    | MAX
    | MEDIUMBLOB
    | MEDIUMINT
    | MEDIUMTEXT
    | MERGES
    | MIN
    | MODIFY
    | MOVE
    | MULTI_POLYGON
    | MUTATION
    | NAME
    | NAN
    | NATIONAL
    | NCHAR
    | NESTED
    | NO
    | NOT
    | NOTHING
    | NULLABLE
    | NULLS
    | NUMERIC
    | NVARCHAR
    | OBJECT
    | OBJECT_TYPE
    | OFFSET
    | ON
    | OPTIMIZE
    | OR
    | ORDER
    | OUTER
    | OUTFILE
    | OVER
    | PART
    | PARTITION
    | POINT
    | POLYGIN
    | POPULATE
    | PRECEDING
    | PRECISION
    | PREWHERE
    | PRIMARY
    | PROJECTION
    | QUERY
    | RANGE
    | REAL
    | RECOMPRESS
    | RELOAD
    | REMOVE
    | RENAME
    | REPLACE
    | REPLICA
    | REPLICATED
    | RESET
    | RIGHT
    | RING
    | ROLLUP
    | ROW
    | ROWS
    | SAMPLE
    | SEMI
    | SENDS
    | SET
    | SETS
    | SETTING
    | SETTINGS
    | SHOW
    | SIGNED
    | SINGLE
    | SMALLINT
    | SOURCE
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
    | TRIM
    | TRUNCATE
    | TTL
    | TUPLE
    | TYPE
    | UNBOUNDED
    | UNFREEZE
    | UNION
    | UNSIGNED
    | UPDATE
    | USE
    | USING
    | UUID
    | VALUES
    | VARBINARY
    | VARCHAR
    | VARYING
    | VIEW
    | VOLUME
    | WATCH
    | WHEN
    | WHERE
    | WINDOW
    | WITH
    ;

keyword_for_alias
    : FIRST
    | ID
    | KEY
    | TEST
    | SELECT
    | DATE
    ;

alias
    : IDENTIFIER
    | keyword_for_alias
    ;

alias_clause
    : alias
    | AS identifier
    ;

identifier
    : IDENTIFIER
    | interval
    | keyword
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