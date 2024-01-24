parser grammar CHParser;

options {
    language=Java;
    tokenVocab = CHLexer;
}

@header {package ru.taximaxim.codekeeper.core.parsers.antlr.generated;}

// Top-level statements

sql
    : stmt (INTO OUTFILE STRING_LITERAL)? (FORMAT (identifier | NULL))? (SEMICOLON)? | insert_stmt EOF
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
    | select_stmt
    ;

select_stmt
    : with_clause? select_ops
    ;

 select_ops
    : LPAREN select_stmt RPAREN // parens can be used to apply "global" clauses (WITH etc) to a particular select in UNION expr
    | select_ops UNION ALL select_ops
    | select_primary
    ;

with_clause
    : name=identifier (column_aliases)? AS LPAREN stmt RPAREN
    ;

column_aliases
    : LPAREN identifier (COMMA identifier)* RPAREN
    ;

// ALTER statement

alter_stmt
    : ALTER TABLE table_identifier cluster_clause? alter_table_action (COMMA alter_table_action)*
    ;

alter_table_action
    : ADD COLUMN (IF NOT EXISTS)? table_column_def (AFTER nested_identifier)?
    | ADD INDEX (IF NOT EXISTS)? table_index_def (AFTER nested_identifier)?
    | ADD PROJECTION (IF NOT EXISTS)? table_projection_def (AFTER nested_identifier)?
    | ATTACH partition_clause (FROM table_identifier)?
    | CLEAR COLUMN (IF EXISTS)? nested_identifier (IN partition_clause)?
    | CLEAR INDEX (IF EXISTS)? nested_identifier (IN partition_clause)?
    | CLEAR PROJECTION (IF EXISTS)? nested_identifier (IN partition_clause)?
    | COMMENT COLUMN (IF EXISTS)? nested_identifier STRING_LITERAL
    | DELETE WHERE column_expr
    | DETACH partition_clause
    | DROP COLUMN (IF EXISTS)? nested_identifier
    | DROP INDEX (IF EXISTS)? nested_identifier
    | DROP PROJECTION (IF EXISTS)? nested_identifier
    | DROP partition_clause
    | FREEZE partition_clause?
    | MATERIALIZE INDEX (IF EXISTS)? nested_identifier (IN partition_clause)?
    | MATERIALIZE PROJECTION (IF EXISTS)? nested_identifier (IN partition_clause)?
    | MODIFY COLUMN (IF EXISTS)? nested_identifier codec_expr
    | MODIFY COLUMN (IF EXISTS)? nested_identifier COMMENT STRING_LITERAL
    | MODIFY COLUMN (IF EXISTS)? nested_identifier REMOVE table_column_property_type
    | MODIFY COLUMN (IF EXISTS)? table_column_def
    | MODIFY ORDER BY column_expr
    | MODIFY ttl_clause
    | MOVE partition_clause TO (DISK STRING_LITERAL | VOLUME STRING_LITERAL | TABLE table_identifier)
    | REMOVE TTL
    | RENAME COLUMN (IF EXISTS)? nested_identifier TO nested_identifier
    | REPLACE partition_clause FROM table_identifier
    | UPDATE nested_identifier EQ_SINGLE column_expr (COMMA nested_identifier EQ_SINGLE column_expr)* where_clause
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
    : PARTITION column_expr         // actually we expect here any form of tuple of literals
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
    | (ATTACH | CREATE) MATERIALIZED VIEW (IF NOT EXISTS)? table_identifier uuid_clause? cluster_clause? table_schema_clause? (destination_clause | engine_clause POPULATE?) subquery_clause
    | (ATTACH | CREATE (OR REPLACE)? | REPLACE) TEMPORARY? TABLE (IF NOT EXISTS)? table_identifier uuid_clause? cluster_clause? table_schema_clause? engine_clause? subquery_clause?
    | (ATTACH | CREATE) (OR REPLACE)? VIEW (IF NOT EXISTS)? table_identifier uuid_clause? cluster_clause? table_schema_clause? subquery_clause
    ;

create_dictinary_stmt
    : (ATTACH | CREATE (OR REPLACE)? | REPLACE) DICTIONARY (IF NOT EXISTS)?
    table_identifier uuid_clause? cluster_clause?
    LPAREN dictionary_attr_def (COMMA dictionary_attr_def)* RPAREN
    (PRIMARY KEY column_expr_list)?
    dictionary_option*
    ;

dictionary_attr_def
    : identifier column_type_expr (DEFAULT literal | EXPRESSION column_expr | HIERARCHICAL | INJECTIVE | IS_OBJECT_ID)*
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

destination_clause
    : TO table_identifier
    ;

subquery_clause
    : AS /*selectUnion_stmt*/ select_ops
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
    : PARTITION BY column_expr
    ;

primary_key_clause
    : PRIMARY KEY column_expr
    ;

sample_by_clause
    : SAMPLE BY column_expr
    ;

ttl_clause
    : TTL ttl_expr (COMMA ttl_expr)*
    ;

engine_expr
    : ENGINE EQ_SINGLE? (identifier | NULL) (LPAREN column_expr_list? RPAREN)?
    ;

table_element_expr
    : table_column_def
    | CONSTRAINT identifier CHECK column_expr
    | INDEX table_index_def
    | PROJECTION table_projection_def
    ;

table_column_def
    : nested_identifier (column_type_expr table_column_property_expr? | column_type_expr? table_column_property_expr)
    (COMMENT STRING_LITERAL)? codec_expr? (TTL column_expr)?
    ;

table_column_property_expr
    : (DEFAULT | MATERIALIZED | ALIAS) column_expr
    ;

table_index_def
    : nested_identifier column_expr TYPE column_type_expr GRANULARITY DECIMAL_LITERAL
    ;

table_projection_def
    : nested_identifier projection_select_stmt
    ;

codec_expr
    : CODEC LPAREN codec_arg_expr (COMMA codec_arg_expr)* RPAREN
    ;

codec_arg_expr
    : identifier (LPAREN column_expr_list? RPAREN)?
    ;

ttl_expr
    : column_expr (DELETE | TO DISK STRING_LITERAL | TO VOLUME STRING_LITERAL)?
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
    : LPAREN nested_identifier (COMMA nested_identifier)* RPAREN
    ;

data_clause
    : FORMAT identifier
    | VALUES
    | /*selectUnion_stmt*/  select_ops  SEMICOLON? EOF // FIXME EOF?
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
    SELECT column_expr_list
    group_by_clause?
    ORDER BY column_expr_list?
    RPAREN
    ;

/*selectUnion_stmt
    : select_stmtWithParens (UNION ALL select_stmtWithParens)*
    ;

select_stmtWithParens
    : select_stmt| LPAREN selectUnion_stmt RPAREN
    ;
*/

select_primary:
    SELECT DISTINCT? top_clause? column_expr_list
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

top_clause
    : TOP DECIMAL_LITERAL (WITH TIES)?
    ;

from_clause
    : FROM join_expr
    ;

array_join_clause
    : (LEFT | INNER)? ARRAY JOIN column_expr_list
    ;

window_clause
    : WINDOW identifier AS window_expr
    ;

prewhere_clause
    : PREWHERE column_expr
    ;

where_clause
    : WHERE column_expr
    ;

group_by_clause
    : GROUP BY ((CUBE | ROLLUP) LPAREN column_expr_list RPAREN | column_expr_list)
    ;

having_clause
    : HAVING column_expr
    ;

order_by_clause
    : ORDER BY order_expr_list
    ;

limit_by_clause
    : LIMIT limit_expr BY column_expr_list
    ;

limit_clause
    : LIMIT limit_expr (WITH TIES)?
    ;

settings_clause
    : SETTINGS setting_expr_list
    ;

join_expr
    : join_expr (GLOBAL | LOCAL)? join_op? JOIN join_expr join_constraint_clause
    | join_expr join_op_cross join_expr
    | table_expr FINAL? sample_clause?
    | LPAREN join_expr RPAREN
    ;

join_op
    : (ALL | ANY | ASOF)? INNER
    | INNER (ALL | ANY | ASOF)?
    | ALL
    | ANY
    | ASOF
    | (SEMI | ALL | ANTI | ANY | ASOF)? (LEFT | RIGHT) OUTER?
    | (LEFT | RIGHT) OUTER? (SEMI | ALL | ANTI | ANY | ASOF)?
    | (ALL | ANY)? FULL OUTER?
    | FULL OUTER? (ALL | ANY)?
    ;

join_op_cross
    : (GLOBAL|LOCAL)? CROSS JOIN
    | COMMA
    ;

join_constraint_clause
    : ON column_expr_list
    | USING LPAREN column_expr_list RPAREN
    | USING column_expr_list
    ;

sample_clause
    : SAMPLE ratio_expr (OFFSET ratio_expr)?
    ;

limit_expr
    : column_expr ((COMMA | OFFSET) column_expr)?
    ;

order_expr_list
    : order_expr (COMMA order_expr)*
    ;

order_expr
    : column_expr (ASCENDING | DESCENDING | DESC)? (NULLS (FIRST | LAST))? (COLLATE STRING_LITERAL)?
    ;

ratio_expr
    : number_literal (SLASH number_literal)?
    ;

setting_expr_list
    : setting_expr (COMMA setting_expr)*
    ;

setting_expr
    : identifier EQ_SINGLE literal
    ;

window_expr
    : LPAREN (PARTITION BY column_expr_list)? (ORDER BY order_expr_list)? ((ROWS | RANGE) win_frame_extend)? RPAREN
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

column_type_expr
    : identifier
    | identifier LPAREN identifier column_type_expr (COMMA identifier column_type_expr)* RPAREN
    | identifier LPAREN enum_value (COMMA enum_value)* RPAREN
    | identifier LPAREN column_type_expr (COMMA column_type_expr)* RPAREN
    | identifier LPAREN column_expr_list? RPAREN
    ;

column_expr_list
    : columns_expr (COMMA columns_expr)*
    ;

columns_expr
    : // (table_identifier DOT)? ASTERISK
     LPAREN /*selectUnion_stmt*/ select_ops RPAREN
    // NOTE: asterisk and subquery goes before |column_expr| so that we can mark them as multi-column expressions.
    | column_expr
    ;

column_expr
    : CASE column_expr? (WHEN column_expr THEN column_expr)+ (ELSE column_expr)? END
    | CAST LPAREN column_expr AS column_type_expr RPAREN
    | DATE STRING_LITERAL
    | EXTRACT LPAREN interval FROM column_expr RPAREN
    | INTERVAL column_expr interval
    | SUBSTRING LPAREN column_expr FROM column_expr (FOR column_expr)? RPAREN
    | TIMESTAMP STRING_LITERAL
    | TRIM LPAREN (BOTH | LEADING | TRAILING) STRING_LITERAL FROM column_expr RPAREN
    | identifier (LPAREN column_expr_list? RPAREN) OVER window_expr
    | identifier (LPAREN column_expr_list? RPAREN) OVER identifier
    | identifier (LPAREN column_expr_list? RPAREN)? LPAREN DISTINCT? column_arg_list? RPAREN
    | literal
    // FIXME(ilezhankin): this part looks very ugly, maybe there is another way to express it
    | column_expr LBRACKET column_expr RBRACKET
    | column_expr DOT DECIMAL_LITERAL
    | DASH column_expr
    | column_expr (ASTERISK | SLASH | PERCENT) column_expr
    | column_expr (PLUS | DASH | CONCAT) column_expr
    | column_expr (EQ_DOUBLE | EQ_SINGLE | NOT_EQ | LE | GE | LT | GT | GLOBAL? NOT? IN | NOT? (LIKE | ILIKE)) column_expr
    | column_expr IS NOT? NULL
    | NOT column_expr
    | column_expr AND column_expr
    | column_expr OR column_expr
    // TODO(ilezhankin): `BETWEEN a AND b AND c` is parsed in a wrong way: `BETWEEN (a AND b) AND c`
    | column_expr NOT? BETWEEN column_expr AND column_expr
    | <assoc=right> column_expr QUERY column_expr COLON column_expr
    | column_expr (alias | AS identifier)
    | (table_identifier DOT)? ASTERISK
    | LPAREN /*selectUnion_stmt*/ select_ops RPAREN
    | LPAREN column_expr RPAREN
    | LPAREN column_expr_list RPAREN
    | LBRACKET column_expr_list? RBRACKET
    | column_identifier
    ;

column_arg_list
    : column_arg_expr (COMMA column_arg_expr)*
    ;

column_arg_expr
    : column_lambda_expr | column_expr
    ;

column_lambda_expr
    : (LPAREN identifier (COMMA identifier)* RPAREN | identifier (COMMA identifier)*) ARROW column_expr
    ;

column_identifier
    : (table_identifier DOT)? nested_identifier
    ;

nested_identifier
    : identifier (DOT identifier)?
    ;

// Tables

table_expr
    : table_identifier
    | table_function_expr
    | LPAREN /*selectUnion_stmt*/ select_ops RPAREN
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
    : nested_identifier
    | table_function_expr
    | literal
    ;

// Basics

floating_literal
    : FLOATING_LITERAL
    | DOT (DECIMAL_LITERAL | OCTAL_LITERAL)
    | DECIMAL_LITERAL DOT (DECIMAL_LITERAL | OCTAL_LITERAL)?  // can't move this to the lexer or it will break nested tuple access: t.1.2
    ;

number_literal
    : (PLUS | DASH)? (floating_literal | OCTAL_LITERAL | DECIMAL_LITERAL | HEXADECIMAL_LITERAL | INF | NAN)
    ;

literal
    : number_literal
    | STRING_LITERAL
    | NULL
    ;

interval
    : SECOND | MINUTE | HOUR | DAY | WEEK | MONTH | QUARTER | YEAR
    ;

keyword
    // except NULL, INF, NAN
    : AFTER | ALIAS | ALL | ALTER | AND | ANTI | ANY | ARRAY | AS | ASCENDING | ASOF | AST | ASYNC | ATTACH | BETWEEN | BOTH | BY | CASE
    | CAST | CHECK | CLEAR | CLUSTER | CODEC | COLLATE | COLUMN | COMMENT | CONSTRAINT | CREATE | CROSS | CUBE | CURRENT | DATABASE
    | DATABASES | DATE | DEDUPLICATE | DEFAULT | DELAY | DELETE | DESCRIBE | DESC | DESCENDING | DETACH | DICTIONARIES | DICTIONARY | DISK
    | DISTINCT | DISTRIBUTED | DROP | ELSE | END | ENGINE | EVENTS | EXISTS | EXPLAIN | EXPRESSION | EXTRACT | FETCHES | FINAL | FIRST
    | FLUSH | FOR | FOLLOWING | FOR | FORMAT | FREEZE | FROM | FULL | FUNCTION | GLOBAL | GRANULARITY | GROUP | HAVING | HIERARCHICAL | ID
    | IF | ILIKE | IN | INDEX | INJECTIVE | INNER | INSERT | INTERVAL | INTO | IS | IS_OBJECT_ID | JOIN | JSON_FALSE | JSON_TRUE | KEY
    | KILL | LAST | LAYOUT | LEADING | LEFT | LIFETIME | LIKE | LIMIT | LIVE | LOCAL | LOGS | MATERIALIZE | MATERIALIZED | MAX | MERGES
    | MIN | MODIFY | MOVE | MUTATION | NO | NOT | NULLS | OFFSET | ON | OPTIMIZE | OR | ORDER | OUTER | OUTFILE | OVER | PARTITION
    | POPULATE | PRECEDING | PREWHERE | PRIMARY | RANGE | RELOAD | REMOVE | RENAME | REPLACE | REPLICA | REPLICATED | RIGHT | ROLLUP | ROW
    | ROWS | SAMPLE | SELECT | SEMI | SENDS | SET | SETTINGS | SHOW | SOURCE | START | STOP | SUBSTRING | SYNC | SYNTAX | SYSTEM | TABLE
    | TABLES | TEMPORARY | TEST | THEN | TIES | TIMEOUT | TIMESTAMP | TOTALS | TRAILING | TRIM | TRUNCATE | TO | TOP | TTL | TYPE
    | UNBOUNDED | UNION | UPDATE | USE | USING | UUID | VALUES | VIEW | VOLUME | WATCH | WHEN | WHERE | WINDOW | WITH
    ;

keyword_for_alias
    : DATE
    | FIRST
    | ID
    | KEY
    ;

alias
    : IDENTIFIER
    | keyword_for_alias
    // |interval| can't be an alias, otherwise 'INTERVAL 1 SOMETHING' becomes ambiguous.
    ;

identifier
    : IDENTIFIER
    | interval
    | keyword
    ;

enum_value
    : STRING_LITERAL EQ_SINGLE number_literal
    ;