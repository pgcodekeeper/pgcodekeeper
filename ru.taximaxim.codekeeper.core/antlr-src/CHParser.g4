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
    : ALTER TABLE table_identifier cluster_clause? alter_table_action (COMMA alter_table_action)*
    ;

alter_table_action
    : ADD COLUMN (IF NOT EXISTS)? table_column_def (AFTER qualified_identifier)?
    | ADD INDEX (IF NOT EXISTS)? table_index_def (AFTER qualified_identifier)?
    | ADD PROJECTION (IF NOT EXISTS)? table_projection_def (AFTER qualified_identifier)?
    | ATTACH partition_clause (FROM table_identifier)?
    | CLEAR COLUMN (IF EXISTS)? qualified_identifier (IN partition_clause)?
    | CLEAR INDEX (IF EXISTS)? qualified_identifier (IN partition_clause)?
    | CLEAR PROJECTION (IF EXISTS)? qualified_identifier (IN partition_clause)?
    | COMMENT COLUMN (IF EXISTS)? qualified_identifier STRING_LITERAL
    | DELETE WHERE expr
    | DETACH partition_clause
    | DROP COLUMN (IF EXISTS)? qualified_identifier
    | DROP INDEX (IF EXISTS)? qualified_identifier
    | DROP PROJECTION (IF EXISTS)? qualified_identifier
    | DROP partition_clause
    | FREEZE partition_clause?
    | MATERIALIZE INDEX (IF EXISTS)? qualified_identifier (IN partition_clause)?
    | MATERIALIZE PROJECTION (IF EXISTS)? qualified_identifier (IN partition_clause)?
    | MODIFY COLUMN (IF EXISTS)? qualified_identifier codec_expr
    | MODIFY COLUMN (IF EXISTS)? qualified_identifier COMMENT STRING_LITERAL
    | MODIFY COLUMN (IF EXISTS)? qualified_identifier REMOVE table_column_property_type
    | MODIFY COLUMN (IF EXISTS)? table_column_def
    | MODIFY ORDER BY expr
    | MODIFY ttl_clause
    | MOVE partition_clause TO (DISK STRING_LITERAL | VOLUME STRING_LITERAL | TABLE table_identifier)
    | REMOVE TTL
    | RENAME COLUMN (IF EXISTS)? qualified_identifier TO qualified_identifier
    | REPLACE partition_clause FROM table_identifier
    | UPDATE qualified_identifier EQ_SINGLE expr (COMMA qualified_identifier EQ_SINGLE expr)* where_clause
    ;

table_column_property_type
    : ALIAS
    | CODEC
    | COMMENT
    | DEFAULT
    | MATERIALIZED
    | TTL
    ;

partition_clause
    : PARTITION expr
    | PARTITION ID STRING_LITERAL
    ;

attach_stmt
    : ATTACH DICTIONARY table_identifier cluster_clause?
    ;

check_stmt
    : CHECK TABLE table_identifier partition_clause?
    ;

create_stmt
    : (ATTACH | CREATE) DATABASE (IF NOT EXISTS)? identifier cluster_clause? engine_expr?
    | create_dictinary_stmt
    | (ATTACH | CREATE) LIVE VIEW (IF NOT EXISTS)? table_identifier uuid_clause? cluster_clause? (WITH TIMEOUT DECIMAL_LITERAL?)? destination_clause? table_schema_clause? subquery_clause
    | create_mat_view_stmt
    | (ATTACH | CREATE (OR REPLACE)? | REPLACE) TEMPORARY? TABLE (IF NOT EXISTS)? table_identifier uuid_clause? cluster_clause? table_schema_clause? engine_clause? subquery_clause?
    | (ATTACH | CREATE) (OR REPLACE)? VIEW (IF NOT EXISTS)? table_identifier uuid_clause? cluster_clause? table_schema_clause? subquery_clause
    ;

create_dictinary_stmt
    : (ATTACH | CREATE (OR REPLACE)? | REPLACE) DICTIONARY (IF NOT EXISTS)?
    table_identifier uuid_clause? cluster_clause?
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
    : identifier (identifier (LPAREN RPAREN)? | literal)
    ;

cluster_clause
    : ON CLUSTER (identifier | STRING_LITERAL)
    ;

uuid_clause
    : UUID STRING_LITERAL
    ;

create_mat_view_stmt
    : (ATTACH | CREATE) MATERIALIZED VIEW (IF NOT EXISTS)? table_identifier uuid_clause? cluster_clause?
    destination_clause? table_schema_clause? engine_clause? POPULATE?
    subquery_clause
    ;

destination_clause
    : TO table_identifier
    ;

subquery_clause
    : AS select_stmt
    ;

table_schema_clause
    : LPAREN table_element_expr (COMMA table_element_expr)* RPAREN
    | AS table_identifier
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
    : table_column_def
    | CONSTRAINT identifier CHECK expr
    | INDEX table_index_def
    | PROJECTION table_projection_def
    ;

table_column_def
    : qualified_identifier (data_type? table_column_property_expr | data_type)
    (COMMENT STRING_LITERAL)? codec_expr? (TTL expr)?
    ;

table_column_property_expr
    : (DEFAULT | MATERIALIZED | ALIAS) expr
    ;

table_index_def
    : qualified_identifier expr TYPE data_type (GRANULARITY DECIMAL_LITERAL)?
    ;

table_projection_def
    : qualified_identifier projection_select_stmt
    ;

codec_expr
    : CODEC LPAREN codec_arg_expr (COMMA codec_arg_expr)* RPAREN
    ;

codec_arg_expr
    : identifier (LPAREN expr_list? RPAREN)?
    ;

ttl_expr
    : expr (DELETE | TO DISK STRING_LITERAL | TO VOLUME STRING_LITERAL)?
    ;

describe_stmt
    : (DESCRIBE | DESC) TABLE? table_expr
    ;

drop_stmt
    : (DETACH | DROP) DATABASE (IF EXISTS)? identifier cluster_clause?
    | (DETACH | DROP) (DICTIONARY | TEMPORARY? TABLE | VIEW) (IF EXISTS)? table_identifier cluster_clause? (NO DELAY)?
    ;

exists_stmt
    : EXISTS DATABASE identifier
    | EXISTS (DICTIONARY | TEMPORARY? TABLE | VIEW)? table_identifier
    ;

explain_stmt
    : EXPLAIN (AST | SYNTAX) stmt
    ;

insert_stmt
    : INSERT INTO TABLE? (table_identifier | FUNCTION table_function_expr) columns_clause? data_clause
    ;

columns_clause
    : LPAREN qualified_identifier (COMMA qualified_identifier)* RPAREN
    ;

data_clause
    : FORMAT identifier
    | VALUES values_values (COMMA values_values)*
    | /*selectUnion_stmt*/  select_ops  SEMICOLON? EOF // FIXME EOF?
    ;

values_values
    : LPAREN (expr | DEFAULT) (COMMA (expr | DEFAULT))* RPAREN
    ;

kill_stmt
    : KILL MUTATION cluster_clause? where_clause (SYNC | ASYNC | TEST)?
    ;

optimize_stmt
    : OPTIMIZE TABLE table_identifier cluster_clause? partition_clause? FINAL? DEDUPLICATE?
    ;

rename_stmt
    : RENAME TABLE table_identifier TO table_identifier (COMMA table_identifier TO table_identifier)* cluster_clause?
    ;

projection_select_stmt:
    LPAREN
    with_clause?
    SELECT expr_list
    group_by_clause?
    ORDER BY expr_list?
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
    | from_primary (alias | AS identifier)? FINAL? sample_clause?
    ;

from_primary
    : table_identifier
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
    | LPAREN RPAREN
    | (ROLLUP | CUBE | GROUPING SETS) LPAREN grouping_element_list RPAREN
    ;

having_clause
    : HAVING expr
    ;

order_by_clause
    : ORDER BY order_expr_list
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
    | LPAREN (PARTITION BY expr_list)? (ORDER BY order_expr_list)? ((ROWS | RANGE) win_frame_extend)? RPAREN
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
    | SHOW CREATE DICTIONARY table_identifier
    | SHOW CREATE TEMPORARY? TABLE? table_identifier
    | SHOW DATABASES
    | SHOW DICTIONARIES (FROM identifier)?
    | SHOW TEMPORARY? TABLES ((FROM | IN) identifier)? (LIKE STRING_LITERAL | where_clause)? limit_clause?
    ;

system_stmt
    : SYSTEM FLUSH DISTRIBUTED table_identifier
    | SYSTEM FLUSH LOGS
    | SYSTEM RELOAD DICTIONARIES
    | SYSTEM RELOAD DICTIONARY table_identifier
    | SYSTEM (START | STOP) (DISTRIBUTED SENDS | FETCHES | TTL? MERGES) table_identifier
    | SYSTEM (START | STOP) REPLICATED SENDS
    | SYSTEM SYNC REPLICA table_identifier
    ;

truncate_stmt
    : TRUNCATE TEMPORARY? TABLE? (IF EXISTS)? table_identifier cluster_clause?
    ;

use_stmt
    : USE identifier
    ;

watch_stmt
    : WATCH table_identifier EVENTS? (LIMIT DECIMAL_LITERAL)?
    ;

data_type
    : identifier
    | identifier LPAREN identifier data_type (COMMA identifier data_type)* RPAREN
    | identifier LPAREN enum_value (COMMA enum_value)* RPAREN
    | complex_data_type
    ;

complex_data_type
    : identifier LPAREN expr_list? RPAREN
    ;

expr_list
    : expr (COMMA expr)*
    ;

expr
    : expr CAST_EXPRESSION data_type
    | expr LBRACKET expr RBRACKET
    | LPAREN expr (COMMA expr)* RPAREN
    | expr IS NOT? NULL
    | expr (ASTERISK | SLASH | PERCENT) expr
    | expr (PLUS | MINUS) expr
    | expr op expr
    | expr (GLOBAL? NOT? IN | NOT? (LIKE | ILIKE)) expr
    | NOT expr
    | expr NOT? BETWEEN expr AND expr
    | expr QUERY expr COLON expr
    | expr (alias | AS identifier)
    | expr AND expr
    | expr OR expr
    | expr_primary
    ;

expr_primary
    : literal
    | (table_identifier DOT)? ASTERISK
    | qualified_identifier
    | DATE STRING_LITERAL
    | LPAREN select_stmt_no_parens RPAREN
    | function_call (DOT DECIMAL_LITERAL)?
    | LBRACKET expr_list? RBRACKET
    | identifier (DOT DECIMAL_LITERAL)+
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
    ;

function_call
    : CASE expr? (WHEN expr THEN expr)+ (ELSE expr)? END
    | CAST LPAREN expr AS complex_data_type RPAREN // when using the data_type rule there are ambiguities with the simple function
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
    : (LPAREN identifier (COMMA identifier)* RPAREN | identifier) ARROW expr
    ;

qualified_identifier
    : identifier ( DOT identifier ( DOT identifier )? )?
    ;

// Tables

table_expr
    : table_identifier
    | table_function_expr
    | LPAREN select_ops RPAREN
    | table_expr (alias | AS identifier)
    ;

table_function_expr
    : identifier LPAREN table_arg_list? RPAREN
    ;

table_identifier
    : (identifier DOT)? table_name=identifier
    ;

table_arg_list
    : table_arg_expr (COMMA table_arg_expr)*
    ;

table_arg_expr
    : qualified_identifier
    | table_function_expr
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
    : (PLUS | MINUS)? (floating_literal | OCTAL_LITERAL | DECIMAL_LITERAL | HEXADECIMAL_LITERAL | INF | NAN)
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
    // except NULL, INF, NAN
    : AFTER
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
    | AST
    | ASYNC
    | ATTACH
    | BETWEEN
    | BOTH
    | BY
    | CASE
    | CAST
    | CHECK
    | CLEAR
    | CLUSTER
    | CODEC
    | COLLATE
    | COLUMN
    | COMMENT
    | CONSTRAINT
    | CREATE
    | CROSS
    | CUBE
    | CURRENT
    | DATABASE
    | DATABASES
    | DATE
    | DEDUPLICATE
    | DEFAULT
    | DELAY
    | DELETE
    | DESC
    | DESCENDING
    | DESCRIBE
    | DETACH
    | DICTIONARIES
    | DICTIONARY
    | DISK
    | DISTRIBUTED
    | DROP
    | ELSE
    | END
    | ENGINE
    | EVENTS
    | EXCEPT
    | EXISTS
    | EXPLAIN
    | EXPRESSION
    | EXTRACT
    | FETCHES
    | FILL
    | FINAL
    | FIRST
    | FLUSH
    | FOLLOWING
    | FOR
    | FOR
    | FORMAT
    | FREEZE
    | FROM
    | FULL
    | FUNCTION
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
    | INJECTIVE
    | INNER
    | INSERT
    | INTERPOLATE
    | INTERVAL
    | INTO
    | IS
    | IS_OBJECT_ID
    | JOIN
    | JSON_FALSE
    | JSON_TRUE
    | KEY
    | KILL
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
    | MATERIALIZE
    | MATERIALIZED
    | MAX
    | MERGES
    | MIN
    | MODIFY
    | MOVE
    | MUTATION
    | NO
    | NOT
    | NULLS
    | OFFSET
    | ON
    | OPTIMIZE
    | OR
    | ORDER
    | OUTER
    | OUTFILE
    | OVER
    | PARTITION
    | POPULATE
    | PRECEDING
    | PREWHERE
    | PRIMARY
    | RANGE
    | RELOAD
    | REMOVE
    | RENAME
    | REPLACE
    | REPLICA
    | REPLICATED
    | RIGHT
    | ROLLUP
    | ROW
    | ROWS
    | SAMPLE
    | SEMI
    | SENDS
    | SET
    | SETS
    | SETTINGS
    | SHOW
    | SOURCE
    | START
    | STEP
    | STOP
    | SUBSTRING
    | SYNC
    | SYNTAX
    | SYSTEM
    | TABLE
    | TABLES
    | TEMPORARY
    | TEST
    | THEN
    | TIES
    | TIMEOUT
    | TIMESTAMP
    | TO
    | TOP
    | TOTALS
    | TRAILING
    | TRIM
    | TRUNCATE
    | TTL
    | TYPE
    | UNBOUNDED
    | UNION
    | UPDATE
    | USE
    | USING
    | UUID
    | VALUES
    | VIEW
    | VOLUME
    | WATCH
    | WHEN
    | WHERE
    | WINDOW
    | WITH
    ;

keyword_for_alias
    : DATE
    | FIRST
    | ID
    | KEY
    | TEST
    | DISTINCT
    | SELECT
    ;

alias
    : IDENTIFIER
    | keyword_for_alias
    ;

identifier
    : IDENTIFIER
    | interval
    | keyword
    | LBRACE IDENTIFIER COLON IDENTIFIER RBRACE
    ;

enum_value
    : STRING_LITERAL EQ_SINGLE number_literal
    ;