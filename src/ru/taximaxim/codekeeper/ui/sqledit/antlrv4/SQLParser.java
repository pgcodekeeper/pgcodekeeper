// Generated from SQLParser.g4 by ANTLR 4.4
package ru.taximaxim.codekeeper.ui.sqledit.antlrv4;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNCTION=46, ISODOW=192, OVERWRITE=223, FUNCTIONS=47, ROW=95, PRECISION=229, 
		ILIKE=55, ENABLE=169, Character_String_Literal=358, NOT=78, EXCEPT=37, 
		FOREIGN=44, CACHE=140, PRIVILEGES=91, BYTEA=316, MONTH=211, STATEMENT=111, 
		CHARACTER=144, TYPE=264, BlockComment=353, VARBIT=284, STDDEV_POP=251, 
		CREATE=23, COMMENTS=151, ESC_SEQUENCES=359, USING=127, UNLOGGED=266, NOT_EQUAL=331, 
		TIMEZONE_MINUTE=261, VERTICAL_BAR=345, VARIADIC=129, TIMESTAMPTZ=310, 
		VALID=268, REGEXP=234, FAMILY=176, GEQ=335, HANDLER=53, STDDEV_SAMP=252, 
		DIVIDE=341, DISABLE=165, BLOB=315, REPLICA=236, STRICT=112, PRESERVE=89, 
		ASC=10, GROUPING=181, SUBPARTITION=253, VALIDATOR=128, KEY=71, SETOF=109, 
		TEMP=115, ELSE=36, NUMBER=351, BOOL=282, TRAILING=118, DEFINER=163, SEMI_COLON=328, 
		INT=291, RLIKE=238, LEADING=72, RESTRICT=99, SERVER=243, PROCEDURAL=93, 
		TABLESPACE=255, MILLISECONDS=207, REAL=296, INTERSECT=64, GROUP=51, LANGUAGE=195, 
		SEQUENCES=106, OUT=83, REAL_NUMBER=352, NONE=214, USER=267, TRIM=262, 
		LEFT_PAREN=336, LOCATION=200, SEARCH=240, END=35, N_DISTINCT=216, CONSTRAINT=20, 
		TIMEZONE_HOUR=260, RENAME=235, CAST_EXPRESSION=324, ALTER=6, OPTION=221, 
		ISOYEAR=193, UUID=312, NCHAR=304, PLAIN=228, ONLY=220, EXECUTE=40, OWNER=88, 
		INPUT=188, TABLE=114, VARCHAR=303, FLOAT=298, VERSION=274, MICROSECONDS=205, 
		IMMUTABLE=57, ASYMMETRIC=9, SUM=254, N_DISTINCT_INHERITED=217, UnterminatedQuotedIdentifier=357, 
		OWNED=87, Space=360, INOUT=66, STORAGE=250, TIME=307, AS=4, RIGHT_PAREN=337, 
		THEN=117, MAXVALUE=204, COLLATION=18, DOUBLE_UNDER_DOLLAR=350, LEFT=73, 
		REPLACE=98, AVG=137, ZONE=280, TRUNCATE=122, COLUMN=149, TRUSTED=119, 
		PLUS=338, EXISTS=172, NVARCHAR=305, Not_Similar_To=321, RETURNS=100, LIKE=74, 
		COLLATE=17, ADD=1, INTEGER=292, OUTER=82, BY=139, DEFERRABLE=28, TO=263, 
		INHERIT=184, SET=244, RIGHT=102, HAVING=52, MIN=208, SESSION=108, MINUS=339, 
		TEXT=311, HOUR=183, QuotedIdentifier=356, CONCATENATION_OPERATOR=330, 
		CONVERSION=22, UNION=123, CURRENT=157, COLON=327, COMMIT=152, SCHEMA=104, 
		DATABASE=25, DECIMAL=301, DROP=168, BIGINT=293, WHEN=131, VALIDATE=269, 
		ROWS=96, START=248, BIT=283, LARGE=196, REVOKE=101, NATURAL=77, FORMAT=179, 
		PUBLIC=230, AGGREGATE=2, EXTENSION=41, BETWEEN=138, OPTIONS=222, FIRST=178, 
		CAST=16, WEEK=276, EXTERNAL=174, DOUBLE_QUOTE=347, VARYING=273, RESET=237, 
		TRIGGER=120, CASE=14, CHAR=302, INT8=288, COUNT=155, DAY=160, CASCADE=15, 
		COST=154, INT2=286, INT1=285, Identifier=355, INT4=287, ISCACHABLE=191, 
		EXTENDED=173, QUOTE=346, MODULAR=342, INVOKER=68, FULL=45, DICTIONARY=164, 
		THAN=258, QUARTER=232, INSERT=189, INHERITS=60, CONNECT=19, ALWAYS=136, 
		INTERSECTION=190, LESS=198, TINYINT=289, BOTH=13, Similar_To_Case_Insensitive=322, 
		DOUBLE=299, ADMIN=135, SYMMETRIC=113, VOID=319, ISSTRICT=194, EACH=34, 
		LAST=197, COMMENT=150, SELECT=107, INTO=65, UNIQUE=124, COALESCE=148, 
		SECOND=241, ROLE=94, RULE=103, VIEW=130, EPOCH=170, ROLLUP=239, NULL=79, 
		WITHOUT=134, NO=213, EVERY=171, ON=219, MATCH=202, PRIMARY=90, DELETE=30, 
		INET4=317, NUMERIC=300, LOCAL=76, LIST=199, OF=80, EXCLUDING=39, TABLES=256, 
		UNDERLINE=344, SEQUENCE=105, Not_Similar_To_Case_Insensitive=323, CUBE=156, 
		NATIONAL=212, CALLED=141, STATISTICS=249, VAR_POP=272, OR=85, FILTER=177, 
		CHECK=145, INLINE=62, FROM=48, FALSE=42, COLLECT=147, PARSER=224, DISTINCT=32, 
		TEMPORARY=116, TIMESTAMP=309, SIMPLE=246, DOLLAR=348, CONSTRAINTS=21, 
		WHERE=132, DEC=161, VAR_SAMP=271, NULLIF=215, MAIN=201, CLASS=142, TIMETZ=308, 
		INNER=63, YEAR=279, TIMEZONE=259, ORDER=86, AUTHORIZATION=11, LIMIT=75, 
		DECADE=162, GTH=334, CYCLE=158, White_Space=361, MAX=203, UPDATE=125, 
		LineComment=354, DEFERRED=29, FOR=43, FLOAT4=294, CONFIGURATION=153, FLOAT8=295, 
		AND=7, CROSS=24, Similar_To=320, INTERVAL=318, USAGE=126, IF=54, INDEX=185, 
		OIDS=81, BOOLEAN=281, IN=58, MINVALUE=209, UNKNOWN=265, MULTIPLY=340, 
		OBJECT=218, COMMA=329, REFERENCES=97, PARTITION=226, IS=69, PARTITIONS=227, 
		SOME=110, EQUAL=326, ALL=5, DOUBLE_DOLLAR=349, DOT=343, EXTRACT=175, CENTURY=143, 
		STABLE=247, SECURITY=242, PARTIAL=225, DOW=166, EXCLUDE=38, WITH=133, 
		INITIALLY=61, DOY=167, FUSION=180, GRANT=50, VARBINARY=314, VOLATILE=275, 
		OPERATOR=84, DEFAULT=26, VALUES=270, HASH=182, RANGE=233, MILLENNIUM=206, 
		INDEXES=186, PURGE=231, BEFORE=12, AFTER=3, INSTEAD=67, WRAPPER=278, TRUE=121, 
		PROCEDURE=92, JOIN=70, SIMILAR=245, DOMAIN=33, DEFAULTS=27, LTH=332, INCREMENT=187, 
		ANY=8, TEMPLATE=257, BAD=362, ASSIGN=325, REGCLASS=297, IMMEDIATE=56, 
		CLUSTER=146, WINDOW=277, BINARY=313, DESC=31, DATE=306, MINUTE=210, GLOBAL=49, 
		DATA=159, INCLUDING=59, LEQ=333, SMALLINT=290;
	public static final String[] tokenNames = {
		"<INVALID>", "ADD", "AGGREGATE", "AFTER", "AS", "ALL", "ALTER", "AND", 
		"ANY", "ASYMMETRIC", "ASC", "AUTHORIZATION", "BEFORE", "BOTH", "CASE", 
		"CASCADE", "CAST", "COLLATE", "COLLATION", "CONNECT", "CONSTRAINT", "CONSTRAINTS", 
		"CONVERSION", "CREATE", "CROSS", "DATABASE", "DEFAULT", "DEFAULTS", "DEFERRABLE", 
		"DEFERRED", "DELETE", "DESC", "DISTINCT", "DOMAIN", "EACH", "END", "ELSE", 
		"EXCEPT", "EXCLUDE", "EXCLUDING", "EXECUTE", "EXTENSION", "FALSE", "FOR", 
		"FOREIGN", "FULL", "FUNCTION", "FUNCTIONS", "FROM", "GLOBAL", "GRANT", 
		"GROUP", "HAVING", "HANDLER", "IF", "ILIKE", "IMMEDIATE", "IMMUTABLE", 
		"IN", "INCLUDING", "INHERITS", "INITIALLY", "INLINE", "INNER", "INTERSECT", 
		"INTO", "INOUT", "INSTEAD", "INVOKER", "IS", "JOIN", "KEY", "LEADING", 
		"LEFT", "LIKE", "LIMIT", "LOCAL", "NATURAL", "NOT", "NULL", "OF", "OIDS", 
		"OUTER", "OUT", "OPERATOR", "OR", "ORDER", "OWNED", "OWNER", "PRESERVE", 
		"PRIMARY", "PRIVILEGES", "PROCEDURE", "PROCEDURAL", "ROLE", "ROW", "ROWS", 
		"REFERENCES", "REPLACE", "RESTRICT", "RETURNS", "REVOKE", "RIGHT", "RULE", 
		"SCHEMA", "SEQUENCE", "SEQUENCES", "SELECT", "SESSION", "SETOF", "SOME", 
		"STATEMENT", "STRICT", "SYMMETRIC", "TABLE", "TEMP", "TEMPORARY", "THEN", 
		"TRAILING", "TRUSTED", "TRIGGER", "TRUE", "TRUNCATE", "UNION", "UNIQUE", 
		"UPDATE", "USAGE", "USING", "VALIDATOR", "VARIADIC", "VIEW", "WHEN", "WHERE", 
		"WITH", "WITHOUT", "ADMIN", "ALWAYS", "AVG", "BETWEEN", "BY", "CACHE", 
		"CALLED", "CLASS", "CENTURY", "CHARACTER", "CHECK", "CLUSTER", "COLLECT", 
		"COALESCE", "COLUMN", "COMMENT", "COMMENTS", "COMMIT", "CONFIGURATION", 
		"COST", "COUNT", "CUBE", "CURRENT", "CYCLE", "DATA", "DAY", "DEC", "DECADE", 
		"DEFINER", "DICTIONARY", "DISABLE", "DOW", "DOY", "DROP", "ENABLE", "EPOCH", 
		"EVERY", "EXISTS", "EXTENDED", "EXTERNAL", "EXTRACT", "FAMILY", "FILTER", 
		"FIRST", "FORMAT", "FUSION", "GROUPING", "HASH", "HOUR", "INHERIT", "INDEX", 
		"INDEXES", "INCREMENT", "INPUT", "INSERT", "INTERSECTION", "ISCACHABLE", 
		"ISODOW", "ISOYEAR", "ISSTRICT", "LANGUAGE", "LARGE", "LAST", "LESS", 
		"LIST", "LOCATION", "MAIN", "MATCH", "MAX", "MAXVALUE", "MICROSECONDS", 
		"MILLENNIUM", "MILLISECONDS", "MIN", "MINVALUE", "MINUTE", "MONTH", "NATIONAL", 
		"NO", "NONE", "NULLIF", "N_DISTINCT", "N_DISTINCT_INHERITED", "OBJECT", 
		"ON", "ONLY", "OPTION", "OPTIONS", "OVERWRITE", "PARSER", "PARTIAL", "PARTITION", 
		"PARTITIONS", "PLAIN", "PRECISION", "PUBLIC", "PURGE", "QUARTER", "RANGE", 
		"REGEXP", "RENAME", "REPLICA", "RESET", "RLIKE", "ROLLUP", "SEARCH", "SECOND", 
		"SECURITY", "SERVER", "SET", "SIMILAR", "SIMPLE", "STABLE", "START", "STATISTICS", 
		"STORAGE", "STDDEV_POP", "STDDEV_SAMP", "SUBPARTITION", "SUM", "TABLESPACE", 
		"TABLES", "TEMPLATE", "THAN", "TIMEZONE", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", 
		"TRIM", "TO", "TYPE", "UNKNOWN", "UNLOGGED", "USER", "VALID", "VALIDATE", 
		"VALUES", "VAR_SAMP", "VAR_POP", "VARYING", "VERSION", "VOLATILE", "WEEK", 
		"WINDOW", "WRAPPER", "YEAR", "ZONE", "BOOLEAN", "BOOL", "BIT", "VARBIT", 
		"INT1", "INT2", "INT4", "INT8", "TINYINT", "SMALLINT", "INT", "INTEGER", 
		"BIGINT", "FLOAT4", "FLOAT8", "REAL", "REGCLASS", "FLOAT", "DOUBLE", "NUMERIC", 
		"DECIMAL", "CHAR", "VARCHAR", "NCHAR", "NVARCHAR", "DATE", "TIME", "TIMETZ", 
		"TIMESTAMP", "TIMESTAMPTZ", "TEXT", "UUID", "BINARY", "VARBINARY", "BLOB", 
		"BYTEA", "INET4", "INTERVAL", "VOID", "'~'", "'!~'", "'~*'", "'!~*'", 
		"CAST_EXPRESSION", "':='", "'='", "':'", "';'", "','", "CONCATENATION_OPERATOR", 
		"NOT_EQUAL", "'<'", "'<='", "'>'", "'>='", "'('", "')'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'.'", "'_'", "'|'", "'''", "'\"'", "'$'", "'$$'", 
		"'$_$'", "NUMBER", "REAL_NUMBER", "BlockComment", "LineComment", "Identifier", 
		"QuotedIdentifier", "UnterminatedQuotedIdentifier", "Character_String_Literal", 
		"ESC_SEQUENCES", "' '", "White_Space", "BAD"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_data_statement = 2, RULE_data_change_statement = 3, 
		RULE_schema_statement = 4, RULE_schema_create = 5, RULE_schema_alter = 6, 
		RULE_alter_function_statement = 7, RULE_alter_schema_statement = 8, RULE_alter_language_statement = 9, 
		RULE_alter_table_statement = 10, RULE_table_action = 11, RULE_table_constraint_using_index = 12, 
		RULE_table_attribute_option = 13, RULE_function_action = 14, RULE_index_statement = 15, 
		RULE_create_extension_statement = 16, RULE_create_language_statement = 17, 
		RULE_set_statement = 18, RULE_create_trigger_statement = 19, RULE_revoke_statement = 20, 
		RULE_revoke_from_cascade_restrict = 21, RULE_grant_statement = 22, RULE_grant_to_rule = 23, 
		RULE_comment_on_statement = 24, RULE_create_function_statement = 25, RULE_function_parameters = 26, 
		RULE_function_body = 27, RULE_function_body_separator = 28, RULE_function_body_separator_dollar_under = 29, 
		RULE_function_attribute = 30, RULE_argmode = 31, RULE_function_definition = 32, 
		RULE_functions_definition_schema = 33, RULE_create_sequence_statement = 34, 
		RULE_create_schema_statement = 35, RULE_create_view_statement = 36, RULE_query = 37, 
		RULE_create_table_statement = 38, RULE_table_column_definition = 39, RULE_like_option = 40, 
		RULE_table_constraint = 41, RULE_column_constraint = 42, RULE_check_boolean_expression = 43, 
		RULE_storage_parameter = 44, RULE_with_storage_parameter = 45, RULE_storage_parameter_oid = 46, 
		RULE_on_commit = 47, RULE_table_space = 48, RULE_action = 49, RULE_index_parameters = 50, 
		RULE_table_elements = 51, RULE_field_element = 52, RULE_field_type = 53, 
		RULE_param_clause = 54, RULE_param = 55, RULE_method_specifier = 56, RULE_table_space_specifier = 57, 
		RULE_table_space_name = 58, RULE_table_partitioning_clauses = 59, RULE_range_partitions = 60, 
		RULE_range_value_clause_list = 61, RULE_range_value_clause = 62, RULE_hash_partitions = 63, 
		RULE_individual_hash_partitions = 64, RULE_individual_hash_partition = 65, 
		RULE_hash_partitions_by_quantity = 66, RULE_list_partitions = 67, RULE_list_value_clause_list = 68, 
		RULE_list_value_partition = 69, RULE_column_partitions = 70, RULE_partition_name = 71, 
		RULE_drop_table_statement = 72, RULE_identifier = 73, RULE_nonreserved_keywords = 74, 
		RULE_unsigned_literal = 75, RULE_general_literal = 76, RULE_datetime_literal = 77, 
		RULE_time_literal = 78, RULE_timestamp_literal = 79, RULE_date_literal = 80, 
		RULE_boolean_literal = 81, RULE_data_type = 82, RULE_predefined_type = 83, 
		RULE_regclass = 84, RULE_network_type = 85, RULE_character_string_type = 86, 
		RULE_type_length = 87, RULE_national_character_string_type = 88, RULE_binary_large_object_string_type = 89, 
		RULE_numeric_type = 90, RULE_exact_numeric_type = 91, RULE_approximate_numeric_type = 92, 
		RULE_precision_param = 93, RULE_boolean_type = 94, RULE_datetime_type = 95, 
		RULE_bit_type = 96, RULE_binary_type = 97, RULE_value_expression_primary = 98, 
		RULE_parenthesized_value_expression = 99, RULE_nonparenthesized_value_expression_primary = 100, 
		RULE_unsigned_value_specification = 101, RULE_unsigned_numeric_literal = 102, 
		RULE_signed_numerical_literal = 103, RULE_set_function_specification = 104, 
		RULE_aggregate_function = 105, RULE_general_set_function = 106, RULE_set_function_type = 107, 
		RULE_filter_clause = 108, RULE_grouping_operation = 109, RULE_case_expression = 110, 
		RULE_case_abbreviation = 111, RULE_case_specification = 112, RULE_simple_case = 113, 
		RULE_searched_case = 114, RULE_simple_when_clause = 115, RULE_searched_when_clause = 116, 
		RULE_else_clause = 117, RULE_result = 118, RULE_cast_specification = 119, 
		RULE_cast_operand = 120, RULE_cast_target = 121, RULE_value_expression = 122, 
		RULE_common_value_expression = 123, RULE_numeric_value_expression = 124, 
		RULE_term = 125, RULE_factor = 126, RULE_array = 127, RULE_numeric_primary = 128, 
		RULE_sign = 129, RULE_numeric_value_function = 130, RULE_extract_expression = 131, 
		RULE_extract_field = 132, RULE_time_zone_field = 133, RULE_extract_source = 134, 
		RULE_string_value_expression = 135, RULE_character_value_expression = 136, 
		RULE_character_factor = 137, RULE_character_primary = 138, RULE_string_value_function = 139, 
		RULE_trim_function = 140, RULE_trim_operands = 141, RULE_trim_specification = 142, 
		RULE_boolean_value_expression = 143, RULE_or_predicate = 144, RULE_and_predicate = 145, 
		RULE_boolean_factor = 146, RULE_boolean_test = 147, RULE_is_clause = 148, 
		RULE_truth_value = 149, RULE_boolean_primary = 150, RULE_boolean_predicand = 151, 
		RULE_parenthesized_boolean_value_expression = 152, RULE_row_value_expression = 153, 
		RULE_row_value_special_case = 154, RULE_explicit_row_value_constructor = 155, 
		RULE_row_value_predicand = 156, RULE_row_value_constructor_predicand = 157, 
		RULE_table_expression = 158, RULE_from_clause = 159, RULE_table_reference_list = 160, 
		RULE_table_reference = 161, RULE_joined_table = 162, RULE_joined_table_primary = 163, 
		RULE_cross_join = 164, RULE_qualified_join = 165, RULE_natural_join = 166, 
		RULE_union_join = 167, RULE_join_type = 168, RULE_outer_join_type = 169, 
		RULE_outer_join_type_part2 = 170, RULE_join_specification = 171, RULE_join_condition = 172, 
		RULE_named_columns_join = 173, RULE_table_primary = 174, RULE_column_name_list = 175, 
		RULE_derived_table = 176, RULE_where_clause = 177, RULE_search_condition = 178, 
		RULE_groupby_clause = 179, RULE_grouping_element_list = 180, RULE_grouping_element = 181, 
		RULE_ordinary_grouping_set = 182, RULE_ordinary_grouping_set_list = 183, 
		RULE_rollup_list = 184, RULE_cube_list = 185, RULE_empty_grouping_set = 186, 
		RULE_having_clause = 187, RULE_row_value_predicand_list = 188, RULE_query_expression = 189, 
		RULE_query_expression_body = 190, RULE_non_join_query_expression = 191, 
		RULE_query_term = 192, RULE_non_join_query_term = 193, RULE_query_primary = 194, 
		RULE_non_join_query_primary = 195, RULE_simple_table = 196, RULE_explicit_table = 197, 
		RULE_table_or_query_name = 198, RULE_schema_qualified_name = 199, RULE_query_specification = 200, 
		RULE_select_list = 201, RULE_select_sublist = 202, RULE_derived_column = 203, 
		RULE_qualified_asterisk = 204, RULE_set_qualifier = 205, RULE_column_reference = 206, 
		RULE_as_clause = 207, RULE_column_reference_list = 208, RULE_scalar_subquery = 209, 
		RULE_row_subquery = 210, RULE_table_subquery = 211, RULE_subquery = 212, 
		RULE_predicate = 213, RULE_comparison_predicate = 214, RULE_comp_op = 215, 
		RULE_between_predicate = 216, RULE_between_predicate_part_2 = 217, RULE_in_predicate = 218, 
		RULE_in_predicate_value = 219, RULE_in_value_list = 220, RULE_pattern_matching_predicate = 221, 
		RULE_pattern_matcher = 222, RULE_negativable_matcher = 223, RULE_regex_matcher = 224, 
		RULE_null_predicate = 225, RULE_quantified_comparison_predicate = 226, 
		RULE_quantifier = 227, RULE_all = 228, RULE_some = 229, RULE_exists_predicate = 230, 
		RULE_unique_predicate = 231, RULE_primary_datetime_field = 232, RULE_non_second_primary_datetime_field = 233, 
		RULE_extended_datetime_field = 234, RULE_routine_invocation = 235, RULE_function_names_for_reserved_words = 236, 
		RULE_function_name = 237, RULE_sql_argument_list = 238, RULE_orderby_clause = 239, 
		RULE_sort_specifier_list = 240, RULE_sort_specifier = 241, RULE_order_specification = 242, 
		RULE_limit_clause = 243, RULE_null_ordering = 244, RULE_insert_statement = 245;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"schema_create", "schema_alter", "alter_function_statement", "alter_schema_statement", 
		"alter_language_statement", "alter_table_statement", "table_action", "table_constraint_using_index", 
		"table_attribute_option", "function_action", "index_statement", "create_extension_statement", 
		"create_language_statement", "set_statement", "create_trigger_statement", 
		"revoke_statement", "revoke_from_cascade_restrict", "grant_statement", 
		"grant_to_rule", "comment_on_statement", "create_function_statement", 
		"function_parameters", "function_body", "function_body_separator", "function_body_separator_dollar_under", 
		"function_attribute", "argmode", "function_definition", "functions_definition_schema", 
		"create_sequence_statement", "create_schema_statement", "create_view_statement", 
		"query", "create_table_statement", "table_column_definition", "like_option", 
		"table_constraint", "column_constraint", "check_boolean_expression", "storage_parameter", 
		"with_storage_parameter", "storage_parameter_oid", "on_commit", "table_space", 
		"action", "index_parameters", "table_elements", "field_element", "field_type", 
		"param_clause", "param", "method_specifier", "table_space_specifier", 
		"table_space_name", "table_partitioning_clauses", "range_partitions", 
		"range_value_clause_list", "range_value_clause", "hash_partitions", "individual_hash_partitions", 
		"individual_hash_partition", "hash_partitions_by_quantity", "list_partitions", 
		"list_value_clause_list", "list_value_partition", "column_partitions", 
		"partition_name", "drop_table_statement", "identifier", "nonreserved_keywords", 
		"unsigned_literal", "general_literal", "datetime_literal", "time_literal", 
		"timestamp_literal", "date_literal", "boolean_literal", "data_type", "predefined_type", 
		"regclass", "network_type", "character_string_type", "type_length", "national_character_string_type", 
		"binary_large_object_string_type", "numeric_type", "exact_numeric_type", 
		"approximate_numeric_type", "precision_param", "boolean_type", "datetime_type", 
		"bit_type", "binary_type", "value_expression_primary", "parenthesized_value_expression", 
		"nonparenthesized_value_expression_primary", "unsigned_value_specification", 
		"unsigned_numeric_literal", "signed_numerical_literal", "set_function_specification", 
		"aggregate_function", "general_set_function", "set_function_type", "filter_clause", 
		"grouping_operation", "case_expression", "case_abbreviation", "case_specification", 
		"simple_case", "searched_case", "simple_when_clause", "searched_when_clause", 
		"else_clause", "result", "cast_specification", "cast_operand", "cast_target", 
		"value_expression", "common_value_expression", "numeric_value_expression", 
		"term", "factor", "array", "numeric_primary", "sign", "numeric_value_function", 
		"extract_expression", "extract_field", "time_zone_field", "extract_source", 
		"string_value_expression", "character_value_expression", "character_factor", 
		"character_primary", "string_value_function", "trim_function", "trim_operands", 
		"trim_specification", "boolean_value_expression", "or_predicate", "and_predicate", 
		"boolean_factor", "boolean_test", "is_clause", "truth_value", "boolean_primary", 
		"boolean_predicand", "parenthesized_boolean_value_expression", "row_value_expression", 
		"row_value_special_case", "explicit_row_value_constructor", "row_value_predicand", 
		"row_value_constructor_predicand", "table_expression", "from_clause", 
		"table_reference_list", "table_reference", "joined_table", "joined_table_primary", 
		"cross_join", "qualified_join", "natural_join", "union_join", "join_type", 
		"outer_join_type", "outer_join_type_part2", "join_specification", "join_condition", 
		"named_columns_join", "table_primary", "column_name_list", "derived_table", 
		"where_clause", "search_condition", "groupby_clause", "grouping_element_list", 
		"grouping_element", "ordinary_grouping_set", "ordinary_grouping_set_list", 
		"rollup_list", "cube_list", "empty_grouping_set", "having_clause", "row_value_predicand_list", 
		"query_expression", "query_expression_body", "non_join_query_expression", 
		"query_term", "non_join_query_term", "query_primary", "non_join_query_primary", 
		"simple_table", "explicit_table", "table_or_query_name", "schema_qualified_name", 
		"query_specification", "select_list", "select_sublist", "derived_column", 
		"qualified_asterisk", "set_qualifier", "column_reference", "as_clause", 
		"column_reference_list", "scalar_subquery", "row_subquery", "table_subquery", 
		"subquery", "predicate", "comparison_predicate", "comp_op", "between_predicate", 
		"between_predicate_part_2", "in_predicate", "in_predicate_value", "in_value_list", 
		"pattern_matching_predicate", "pattern_matcher", "negativable_matcher", 
		"regex_matcher", "null_predicate", "quantified_comparison_predicate", 
		"quantifier", "all", "some", "exists_predicate", "unique_predicate", "primary_datetime_field", 
		"non_second_primary_datetime_field", "extended_datetime_field", "routine_invocation", 
		"function_names_for_reserved_words", "function_name", "sql_argument_list", 
		"orderby_clause", "sort_specifier_list", "sort_specifier", "order_specification", 
		"limit_clause", "null_ordering", "insert_statement"
	};

	@Override
	public String getGrammarFileName() { return "SQLParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SqlContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON(int i) {
			return getToken(SQLParser.SEMI_COLON, i);
		}
		public List<TerminalNode> SEMI_COLON() { return getTokens(SQLParser.SEMI_COLON); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode EOF() { return getToken(SQLParser.EOF, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SqlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSql(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSql(this);
		}
	}

	public final SqlContext sql() throws RecognitionException {
		SqlContext _localctx = new SqlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sql);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALTER) | (1L << CREATE) | (1L << GRANT))) != 0) || _la==REVOKE || _la==COMMENT || _la==DROP || _la==SET) {
				{
				{
				setState(492); statement();
				setState(494);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(493); match(SEMI_COLON);
					}
				}

				}
				}
				setState(500);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(501); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Schema_statementContext schema_statement() {
			return getRuleContext(Schema_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503); schema_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_statementContext extends ParserRuleContext {
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public Data_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterData_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitData_statement(this);
		}
	}

	public final Data_statementContext data_statement() throws RecognitionException {
		Data_statementContext _localctx = new Data_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505); query_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_change_statementContext extends ParserRuleContext {
		public Insert_statementContext insert_statement() {
			return getRuleContext(Insert_statementContext.class,0);
		}
		public Data_change_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_change_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterData_change_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitData_change_statement(this);
		}
	}

	public final Data_change_statementContext data_change_statement() throws RecognitionException {
		Data_change_statementContext _localctx = new Data_change_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_data_change_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507); insert_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_statementContext extends ParserRuleContext {
		public Drop_table_statementContext drop_table_statement() {
			return getRuleContext(Drop_table_statementContext.class,0);
		}
		public Schema_createContext schema_create() {
			return getRuleContext(Schema_createContext.class,0);
		}
		public Schema_alterContext schema_alter() {
			return getRuleContext(Schema_alterContext.class,0);
		}
		public Schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSchema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSchema_statement(this);
		}
	}

	public final Schema_statementContext schema_statement() throws RecognitionException {
		Schema_statementContext _localctx = new Schema_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_schema_statement);
		try {
			setState(512);
			switch (_input.LA(1)) {
			case CREATE:
			case GRANT:
			case REVOKE:
			case COMMENT:
			case SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(509); schema_create();
				}
				break;
			case ALTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(510); schema_alter();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 3);
				{
				setState(511); drop_table_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_createContext extends ParserRuleContext {
		public Create_function_statementContext create_function_statement() {
			return getRuleContext(Create_function_statementContext.class,0);
		}
		public Create_table_statementContext create_table_statement() {
			return getRuleContext(Create_table_statementContext.class,0);
		}
		public Create_sequence_statementContext create_sequence_statement() {
			return getRuleContext(Create_sequence_statementContext.class,0);
		}
		public Index_statementContext index_statement() {
			return getRuleContext(Index_statementContext.class,0);
		}
		public Create_language_statementContext create_language_statement() {
			return getRuleContext(Create_language_statementContext.class,0);
		}
		public Set_statementContext set_statement() {
			return getRuleContext(Set_statementContext.class,0);
		}
		public Create_extension_statementContext create_extension_statement() {
			return getRuleContext(Create_extension_statementContext.class,0);
		}
		public Comment_on_statementContext comment_on_statement() {
			return getRuleContext(Comment_on_statementContext.class,0);
		}
		public Revoke_statementContext revoke_statement() {
			return getRuleContext(Revoke_statementContext.class,0);
		}
		public Grant_statementContext grant_statement() {
			return getRuleContext(Grant_statementContext.class,0);
		}
		public Create_schema_statementContext create_schema_statement() {
			return getRuleContext(Create_schema_statementContext.class,0);
		}
		public Create_trigger_statementContext create_trigger_statement() {
			return getRuleContext(Create_trigger_statementContext.class,0);
		}
		public Create_view_statementContext create_view_statement() {
			return getRuleContext(Create_view_statementContext.class,0);
		}
		public Schema_createContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_create; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSchema_create(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSchema_create(this);
		}
	}

	public final Schema_createContext schema_create() throws RecognitionException {
		Schema_createContext _localctx = new Schema_createContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_schema_create);
		try {
			setState(527);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(514); create_table_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(515); index_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(516); create_extension_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(517); create_trigger_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(518); create_function_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(519); create_sequence_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(520); create_schema_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(521); create_view_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(522); comment_on_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(523); revoke_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(524); set_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(525); grant_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(526); create_language_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_alterContext extends ParserRuleContext {
		public Alter_function_statementContext alter_function_statement() {
			return getRuleContext(Alter_function_statementContext.class,0);
		}
		public Alter_schema_statementContext alter_schema_statement() {
			return getRuleContext(Alter_schema_statementContext.class,0);
		}
		public Alter_table_statementContext alter_table_statement() {
			return getRuleContext(Alter_table_statementContext.class,0);
		}
		public Alter_language_statementContext alter_language_statement() {
			return getRuleContext(Alter_language_statementContext.class,0);
		}
		public Schema_alterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_alter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSchema_alter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSchema_alter(this);
		}
	}

	public final Schema_alterContext schema_alter() throws RecognitionException {
		Schema_alterContext _localctx = new Schema_alterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_schema_alter);
		try {
			setState(533);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(529); alter_function_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(530); alter_schema_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(531); alter_language_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(532); alter_table_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_function_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public Schema_qualified_nameContext new_name;
		public IdentifierContext new_owner;
		public Schema_qualified_nameContext new_schema;
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public TerminalNode RESTRICT() { return getToken(SQLParser.RESTRICT, 0); }
		public TerminalNode OWNER() { return getToken(SQLParser.OWNER, 0); }
		public Function_actionContext function_action(int i) {
			return getRuleContext(Function_actionContext.class,i);
		}
		public List<Function_actionContext> function_action() {
			return getRuleContexts(Function_actionContext.class);
		}
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public Alter_function_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_function_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAlter_function_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAlter_function_statement(this);
		}
	}

	public final Alter_function_statementContext alter_function_statement() throws RecognitionException {
		Alter_function_statementContext _localctx = new Alter_function_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_alter_function_statement);
		int _la;
		try {
			setState(571);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(535); match(ALTER);
				setState(536); match(FUNCTION);
				setState(537); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(538); function_parameters();
				setState(540); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(539); function_action();
					}
					}
					setState(542); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (RETURNS - 100)) | (1L << (STRICT - 100)) | (1L << (CALLED - 100)))) != 0) || _la==EXTERNAL || ((((_la - 242)) & ~0x3f) == 0 && ((1L << (_la - 242)) & ((1L << (SECURITY - 242)) | (1L << (STABLE - 242)) | (1L << (VOLATILE - 242)))) != 0) );
				setState(545);
				_la = _input.LA(1);
				if (_la==RESTRICT) {
					{
					setState(544); match(RESTRICT);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(547); match(ALTER);
				setState(548); match(FUNCTION);
				setState(549); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(550); function_parameters();
				setState(551); match(RENAME);
				setState(552); match(TO);
				setState(553); ((Alter_function_statementContext)_localctx).new_name = schema_qualified_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(555); match(ALTER);
				setState(556); match(FUNCTION);
				setState(557); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(558); function_parameters();
				setState(559); match(OWNER);
				setState(560); match(TO);
				setState(561); ((Alter_function_statementContext)_localctx).new_owner = identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(563); match(ALTER);
				setState(564); match(FUNCTION);
				setState(565); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(566); function_parameters();
				setState(567); match(SET);
				setState(568); match(SCHEMA);
				setState(569); ((Alter_function_statementContext)_localctx).new_schema = schema_qualified_name();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_schema_statementContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext new_name;
		public IdentifierContext new_owner;
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode OWNER() { return getToken(SQLParser.OWNER, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Alter_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAlter_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAlter_schema_statement(this);
		}
	}

	public final Alter_schema_statementContext alter_schema_statement() throws RecognitionException {
		Alter_schema_statementContext _localctx = new Alter_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_alter_schema_statement);
		try {
			setState(587);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(573); match(ALTER);
				setState(574); match(SCHEMA);
				setState(575); ((Alter_schema_statementContext)_localctx).name = identifier();
				setState(576); match(RENAME);
				setState(577); match(TO);
				setState(578); ((Alter_schema_statementContext)_localctx).new_name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(580); match(ALTER);
				setState(581); match(SCHEMA);
				setState(582); ((Alter_schema_statementContext)_localctx).name = identifier();
				setState(583); match(OWNER);
				setState(584); match(TO);
				setState(585); ((Alter_schema_statementContext)_localctx).new_owner = identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_language_statementContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext new_name;
		public IdentifierContext new_owner;
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LANGUAGE() { return getToken(SQLParser.LANGUAGE, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode OWNER() { return getToken(SQLParser.OWNER, 0); }
		public TerminalNode PROCEDURAL() { return getToken(SQLParser.PROCEDURAL, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Alter_language_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_language_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAlter_language_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAlter_language_statement(this);
		}
	}

	public final Alter_language_statementContext alter_language_statement() throws RecognitionException {
		Alter_language_statementContext _localctx = new Alter_language_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_alter_language_statement);
		int _la;
		try {
			setState(609);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(589); match(ALTER);
				setState(591);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(590); match(PROCEDURAL);
					}
				}

				setState(593); match(LANGUAGE);
				setState(594); ((Alter_language_statementContext)_localctx).name = identifier();
				setState(595); match(RENAME);
				setState(596); match(TO);
				setState(597); ((Alter_language_statementContext)_localctx).new_name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(599); match(ALTER);
				setState(601);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(600); match(PROCEDURAL);
					}
				}

				setState(603); match(LANGUAGE);
				setState(604); ((Alter_language_statementContext)_localctx).name = identifier();
				setState(605); match(OWNER);
				setState(606); match(TO);
				setState(607); ((Alter_language_statementContext)_localctx).new_owner = identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_table_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public Schema_qualified_nameContext column;
		public Schema_qualified_nameContext new_column;
		public Schema_qualified_nameContext new_name;
		public Schema_qualified_nameContext new_schema;
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Table_actionContext> table_action() {
			return getRuleContexts(Table_actionContext.class);
		}
		public TerminalNode ONLY() { return getToken(SQLParser.ONLY, 0); }
		public Table_actionContext table_action(int i) {
			return getRuleContext(Table_actionContext.class,i);
		}
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public Alter_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAlter_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAlter_table_statement(this);
		}
	}

	public final Alter_table_statementContext alter_table_statement() throws RecognitionException {
		Alter_table_statementContext _localctx = new Alter_table_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_alter_table_statement);
		int _la;
		try {
			int _alt;
			setState(661);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(611); match(ALTER);
				setState(612); match(TABLE);
				setState(614);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(613); match(ONLY);
					}
					break;
				}
				setState(617); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(616); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(619); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(625); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(621); table_action();
						setState(623);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(622); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(627); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(629); match(ALTER);
				setState(630); match(TABLE);
				setState(632);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(631); match(ONLY);
					}
					break;
				}
				setState(635); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(634); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(637); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(639); match(RENAME);
				setState(641);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(640); match(COLUMN);
					}
					break;
				}
				setState(643); ((Alter_table_statementContext)_localctx).column = schema_qualified_name();
				setState(644); match(TO);
				setState(645); ((Alter_table_statementContext)_localctx).new_column = schema_qualified_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(647); match(ALTER);
				setState(648); match(TABLE);
				setState(649); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
				setState(650); match(RENAME);
				setState(651); match(TO);
				setState(652); ((Alter_table_statementContext)_localctx).new_name = schema_qualified_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(654); match(ALTER);
				setState(655); match(TABLE);
				setState(656); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
				setState(657); match(SET);
				setState(658); match(SCHEMA);
				setState(659); ((Alter_table_statementContext)_localctx).new_schema = schema_qualified_name();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_actionContext extends ParserRuleContext {
		public Schema_qualified_nameContext column;
		public Data_typeContext datatype;
		public IdentifierContext collation;
		public Value_expressionContext expression;
		public Token integer;
		public Table_attribute_optionContext attribute_option;
		public Signed_numerical_literalContext value;
		public Table_constraintContext tabl_constraint;
		public Table_constraint_using_indexContext tabl_constraint_using_index;
		public Schema_qualified_nameContext constraint_name;
		public Schema_qualified_nameContext trigger_name;
		public Schema_qualified_nameContext rewrite_rule_name;
		public Schema_qualified_nameContext index_name;
		public Schema_qualified_nameContext parent_table;
		public Schema_qualified_nameContext type_name;
		public Schema_qualified_nameContext new_owner;
		public Schema_qualified_nameContext new_tablespace;
		public TerminalNode RESET() { return getToken(SQLParser.RESET, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public With_storage_parameterContext with_storage_parameter(int i) {
			return getRuleContext(With_storage_parameterContext.class,i);
		}
		public List<Table_attribute_optionContext> table_attribute_option() {
			return getRuleContexts(Table_attribute_optionContext.class);
		}
		public List<Signed_numerical_literalContext> signed_numerical_literal() {
			return getRuleContexts(Signed_numerical_literalContext.class);
		}
		public TerminalNode ADD() { return getToken(SQLParser.ADD, 0); }
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public TerminalNode EQUAL(int i) {
			return getToken(SQLParser.EQUAL, i);
		}
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Table_column_definitionContext table_column_definition() {
			return getRuleContext(Table_column_definitionContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(SQLParser.TYPE, 0); }
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode EXTENDED() { return getToken(SQLParser.EXTENDED, 0); }
		public TerminalNode NO() { return getToken(SQLParser.NO, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public List<TerminalNode> EQUAL() { return getTokens(SQLParser.EQUAL); }
		public Table_attribute_optionContext table_attribute_option(int i) {
			return getRuleContext(Table_attribute_optionContext.class,i);
		}
		public List<With_storage_parameterContext> with_storage_parameter() {
			return getRuleContexts(With_storage_parameterContext.class);
		}
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode RESTRICT() { return getToken(SQLParser.RESTRICT, 0); }
		public TerminalNode STATISTICS() { return getToken(SQLParser.STATISTICS, 0); }
		public TerminalNode OWNER() { return getToken(SQLParser.OWNER, 0); }
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public TerminalNode RULE() { return getToken(SQLParser.RULE, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TerminalNode TRIGGER() { return getToken(SQLParser.TRIGGER, 0); }
		public TerminalNode CASCADE() { return getToken(SQLParser.CASCADE, 0); }
		public TerminalNode COLLATE() { return getToken(SQLParser.COLLATE, 0); }
		public TerminalNode VALIDATE() { return getToken(SQLParser.VALIDATE, 0); }
		public TerminalNode DATA() { return getToken(SQLParser.DATA, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public TerminalNode INHERIT() { return getToken(SQLParser.INHERIT, 0); }
		public TerminalNode CLUSTER() { return getToken(SQLParser.CLUSTER, 0); }
		public TerminalNode DISABLE() { return getToken(SQLParser.DISABLE, 0); }
		public Storage_parameterContext storage_parameter() {
			return getRuleContext(Storage_parameterContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public TerminalNode ENABLE() { return getToken(SQLParser.ENABLE, 0); }
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode VALID() { return getToken(SQLParser.VALID, 0); }
		public TerminalNode OF() { return getToken(SQLParser.OF, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode WITHOUT() { return getToken(SQLParser.WITHOUT, 0); }
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public TerminalNode PLAIN() { return getToken(SQLParser.PLAIN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode USER() { return getToken(SQLParser.USER, 0); }
		public TerminalNode STORAGE() { return getToken(SQLParser.STORAGE, 0); }
		public Table_constraintContext table_constraint() {
			return getRuleContext(Table_constraintContext.class,0);
		}
		public Table_constraint_using_indexContext table_constraint_using_index() {
			return getRuleContext(Table_constraint_using_indexContext.class,0);
		}
		public TerminalNode ALWAYS() { return getToken(SQLParser.ALWAYS, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode MAIN() { return getToken(SQLParser.MAIN, 0); }
		public TerminalNode OIDS() { return getToken(SQLParser.OIDS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode REPLICA() { return getToken(SQLParser.REPLICA, 0); }
		public Signed_numerical_literalContext signed_numerical_literal(int i) {
			return getRuleContext(Signed_numerical_literalContext.class,i);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Table_actionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_action(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_action(this);
		}
	}

	public final Table_actionContext table_action() throws RecognitionException {
		Table_actionContext _localctx = new Table_actionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_table_action);
		int _la;
		try {
			setState(880);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(663); match(ADD);
				setState(665);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(664); match(COLUMN);
					}
					break;
				}
				setState(667); table_column_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(668); match(DROP);
				setState(670);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(669); match(COLUMN);
					}
					break;
				}
				setState(674);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(672); match(IF);
					setState(673); match(EXISTS);
					}
				}

				setState(676); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(678);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(677);
					_la = _input.LA(1);
					if ( !(_la==CASCADE || _la==RESTRICT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(680); match(ALTER);
				setState(682);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(681); match(COLUMN);
					}
					break;
				}
				setState(684); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(687);
				_la = _input.LA(1);
				if (_la==SET) {
					{
					setState(685); match(SET);
					setState(686); match(DATA);
					}
				}

				setState(689); match(TYPE);
				setState(690); ((Table_actionContext)_localctx).datatype = data_type();
				setState(693);
				_la = _input.LA(1);
				if (_la==COLLATE) {
					{
					setState(691); match(COLLATE);
					setState(692); ((Table_actionContext)_localctx).collation = identifier();
					}
				}

				setState(697);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(695); match(USING);
					setState(696); ((Table_actionContext)_localctx).expression = value_expression();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(699); match(ALTER);
				setState(701);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(700); match(COLUMN);
					}
					break;
				}
				setState(703); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(704); match(SET);
				setState(705); match(DEFAULT);
				setState(706); ((Table_actionContext)_localctx).expression = value_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(708); match(ALTER);
				setState(710);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(709); match(COLUMN);
					}
					break;
				}
				setState(712); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(713); match(DROP);
				setState(714); match(DEFAULT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(716); match(ALTER);
				setState(718);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(717); match(COLUMN);
					}
					break;
				}
				setState(720); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(721); match(SET);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(723); match(DROP);
				setState(724); match(NOT);
				setState(725); match(NULL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(726); match(ALTER);
				setState(728);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(727); match(COLUMN);
					}
					break;
				}
				setState(730); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(731); match(SET);
				setState(732); match(STATISTICS);
				setState(733); ((Table_actionContext)_localctx).integer = match(NUMBER);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(735); match(ALTER);
				setState(737);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(736); match(COLUMN);
					}
					break;
				}
				setState(739); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(740); match(SET);
				setState(741); match(LEFT_PAREN);
				setState(748); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(742); ((Table_actionContext)_localctx).attribute_option = table_attribute_option();
					setState(743); match(EQUAL);
					setState(744); ((Table_actionContext)_localctx).value = signed_numerical_literal();
					setState(746);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(745); match(COMMA);
						}
					}

					}
					}
					setState(750); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==N_DISTINCT || _la==N_DISTINCT_INHERITED );
				setState(752); match(RIGHT_PAREN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(754); match(ALTER);
				setState(756);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(755); match(COLUMN);
					}
					break;
				}
				setState(758); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(759); match(RESET);
				setState(760); match(LEFT_PAREN);
				setState(765); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(761); ((Table_actionContext)_localctx).attribute_option = table_attribute_option();
					setState(763);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(762); match(COMMA);
						}
					}

					}
					}
					setState(767); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==N_DISTINCT || _la==N_DISTINCT_INHERITED );
				setState(769); match(RIGHT_PAREN);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(771); match(ALTER);
				setState(773);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(772); match(COLUMN);
					}
					break;
				}
				setState(775); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(776); match(SET);
				setState(777); match(STORAGE);
				setState(778); match(PLAIN);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(780); match(EXTERNAL);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(781); match(EXTENDED);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(782); match(MAIN);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(783); match(ADD);
				setState(784); ((Table_actionContext)_localctx).tabl_constraint = table_constraint();
				setState(787);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(785); match(NOT);
					setState(786); match(VALID);
					}
					break;
				}
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(789); match(ADD);
				setState(790); ((Table_actionContext)_localctx).tabl_constraint_using_index = table_constraint_using_index();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(791); match(VALIDATE);
				setState(792); match(CONSTRAINT);
				setState(793); ((Table_actionContext)_localctx).constraint_name = schema_qualified_name();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(794); match(DROP);
				setState(795); match(CONSTRAINT);
				setState(798);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(796); match(IF);
					setState(797); match(EXISTS);
					}
				}

				setState(800); ((Table_actionContext)_localctx).constraint_name = schema_qualified_name();
				setState(801);
				_la = _input.LA(1);
				if ( !(_la==CASCADE || _la==RESTRICT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(803); match(DISABLE);
				setState(804); match(TRIGGER);
				setState(808);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(805); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
					}
					break;
				case 2:
					{
					setState(806); match(ALL);
					}
					break;
				case 3:
					{
					setState(807); match(USER);
					}
					break;
				}
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(810); match(ENABLE);
				setState(811); match(TRIGGER);
				setState(815);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(812); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
					}
					break;
				case 2:
					{
					setState(813); match(ALL);
					}
					break;
				case 3:
					{
					setState(814); match(USER);
					}
					break;
				}
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(817); match(ENABLE);
				setState(818); match(REPLICA);
				setState(819); match(TRIGGER);
				setState(820); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(821); match(ENABLE);
				setState(822); match(ALWAYS);
				setState(823); match(TRIGGER);
				setState(824); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(825); match(DISABLE);
				setState(826); match(RULE);
				setState(827); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(828); match(ENABLE);
				setState(829); match(RULE);
				setState(830); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(831); match(ENABLE);
				setState(832); match(REPLICA);
				setState(833); match(RULE);
				setState(834); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(835); match(ENABLE);
				setState(836); match(ALWAYS);
				setState(837); match(RULE);
				setState(838); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(839); match(CLUSTER);
				setState(840); match(ON);
				setState(841); ((Table_actionContext)_localctx).index_name = schema_qualified_name();
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(842); match(SET);
				setState(843); match(WITHOUT);
				setState(844); match(CLUSTER);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(845); match(SET);
				setState(846); match(WITH);
				setState(847); match(OIDS);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(848); match(SET);
				setState(849); match(WITHOUT);
				setState(850); match(OIDS);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(851); match(SET);
				setState(852); storage_parameter();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(853); match(RESET);
				setState(854); match(LEFT_PAREN);
				setState(859); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(855); with_storage_parameter();
					setState(857);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(856); match(COMMA);
						}
					}

					}
					}
					setState(861); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WITH );
				setState(863); match(RIGHT_PAREN);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(865); match(INHERIT);
				setState(866); ((Table_actionContext)_localctx).parent_table = schema_qualified_name();
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(867); match(NO);
				setState(868); match(INHERIT);
				setState(869); ((Table_actionContext)_localctx).parent_table = schema_qualified_name();
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(870); match(OF);
				setState(871); ((Table_actionContext)_localctx).type_name = schema_qualified_name();
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(872); match(NOT);
				setState(873); match(OF);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(874); match(OWNER);
				setState(875); match(TO);
				setState(876); ((Table_actionContext)_localctx).new_owner = schema_qualified_name();
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(877); match(SET);
				setState(878); match(TABLESPACE);
				setState(879); ((Table_actionContext)_localctx).new_tablespace = schema_qualified_name();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_constraint_using_indexContext extends ParserRuleContext {
		public Schema_qualified_nameContext constraint_name;
		public Schema_qualified_nameContext index_name;
		public TerminalNode DEFERRED() { return getToken(SQLParser.DEFERRED, 0); }
		public TerminalNode DEFERRABLE() { return getToken(SQLParser.DEFERRABLE, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public TerminalNode KEY() { return getToken(SQLParser.KEY, 0); }
		public TerminalNode PRIMARY() { return getToken(SQLParser.PRIMARY, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode IMMEDIATE() { return getToken(SQLParser.IMMEDIATE, 0); }
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public TerminalNode INITIALLY() { return getToken(SQLParser.INITIALLY, 0); }
		public Table_constraint_using_indexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_constraint_using_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_constraint_using_index(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_constraint_using_index(this);
		}
	}

	public final Table_constraint_using_indexContext table_constraint_using_index() throws RecognitionException {
		Table_constraint_using_indexContext _localctx = new Table_constraint_using_indexContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_table_constraint_using_index);
		int _la;
		try {
			setState(903);
			switch (_input.LA(1)) {
			case CONSTRAINT:
			case UNIQUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(884);
				_la = _input.LA(1);
				if (_la==CONSTRAINT) {
					{
					setState(882); match(CONSTRAINT);
					setState(883); ((Table_constraint_using_indexContext)_localctx).constraint_name = schema_qualified_name();
					}
				}

				setState(886); match(UNIQUE);
				}
				break;
			case PRIMARY:
				enterOuterAlt(_localctx, 2);
				{
				setState(887); match(PRIMARY);
				setState(888); match(KEY);
				setState(889); match(USING);
				setState(890); match(INDEX);
				setState(891); ((Table_constraint_using_indexContext)_localctx).index_name = schema_qualified_name();
				setState(895);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(892); match(DEFERRABLE);
					}
					break;
				case 2:
					{
					setState(893); match(NOT);
					setState(894); match(DEFERRABLE);
					}
					break;
				}
				setState(901);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(897); match(INITIALLY);
					setState(898); match(DEFERRED);
					}
					break;
				case 2:
					{
					setState(899); match(INITIALLY);
					setState(900); match(IMMEDIATE);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_attribute_optionContext extends ParserRuleContext {
		public TerminalNode N_DISTINCT_INHERITED() { return getToken(SQLParser.N_DISTINCT_INHERITED, 0); }
		public TerminalNode N_DISTINCT() { return getToken(SQLParser.N_DISTINCT, 0); }
		public Table_attribute_optionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_attribute_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_attribute_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_attribute_option(this);
		}
	}

	public final Table_attribute_optionContext table_attribute_option() throws RecognitionException {
		Table_attribute_optionContext _localctx = new Table_attribute_optionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_table_attribute_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			_la = _input.LA(1);
			if ( !(_la==N_DISTINCT || _la==N_DISTINCT_INHERITED) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_actionContext extends ParserRuleContext {
		public Token execution_cost;
		public Token result_rows;
		public IdentifierContext configuration_parameter;
		public IdentifierContext value;
		public List<TerminalNode> SET() { return getTokens(SQLParser.SET); }
		public List<TerminalNode> RESET() { return getTokens(SQLParser.RESET); }
		public TerminalNode INPUT() { return getToken(SQLParser.INPUT, 0); }
		public TerminalNode VOLATILE() { return getToken(SQLParser.VOLATILE, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode SET(int i) {
			return getToken(SQLParser.SET, i);
		}
		public TerminalNode STABLE() { return getToken(SQLParser.STABLE, 0); }
		public TerminalNode STRICT() { return getToken(SQLParser.STRICT, 0); }
		public TerminalNode COST() { return getToken(SQLParser.COST, 0); }
		public TerminalNode CALLED() { return getToken(SQLParser.CALLED, 0); }
		public TerminalNode IMMUTABLE() { return getToken(SQLParser.IMMUTABLE, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(SQLParser.NUMBER); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public TerminalNode INVOKER() { return getToken(SQLParser.INVOKER, 0); }
		public TerminalNode DEFINER() { return getToken(SQLParser.DEFINER, 0); }
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public TerminalNode NULL(int i) {
			return getToken(SQLParser.NULL, i);
		}
		public TerminalNode CURRENT() { return getToken(SQLParser.CURRENT, 0); }
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public TerminalNode ROWS() { return getToken(SQLParser.ROWS, 0); }
		public TerminalNode SECURITY() { return getToken(SQLParser.SECURITY, 0); }
		public TerminalNode NUMBER(int i) {
			return getToken(SQLParser.NUMBER, i);
		}
		public TerminalNode RESET(int i) {
			return getToken(SQLParser.RESET, i);
		}
		public TerminalNode RETURNS() { return getToken(SQLParser.RETURNS, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> NULL() { return getTokens(SQLParser.NULL); }
		public Function_actionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_action(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_action(this);
		}
	}

	public final Function_actionContext function_action() throws RecognitionException {
		Function_actionContext _localctx = new Function_actionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_function_action);
		int _la;
		try {
			setState(952);
			switch (_input.LA(1)) {
			case CALLED:
				enterOuterAlt(_localctx, 1);
				{
				setState(907); match(CALLED);
				setState(908); match(ON);
				setState(909); match(NULL);
				setState(910); match(INPUT);
				}
				break;
			case RETURNS:
				enterOuterAlt(_localctx, 2);
				{
				setState(911); match(RETURNS);
				setState(912); match(NULL);
				setState(913); match(ON);
				setState(914); match(NULL);
				setState(915); match(INPUT);
				}
				break;
			case STRICT:
				enterOuterAlt(_localctx, 3);
				{
				setState(916); match(STRICT);
				setState(917); match(IMMUTABLE);
				}
				break;
			case STABLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(918); match(STABLE);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(919); match(VOLATILE);
				setState(921);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(920); match(EXTERNAL);
					}
				}

				setState(923); match(SECURITY);
				setState(924); match(INVOKER);
				}
				break;
			case EXTERNAL:
			case SECURITY:
				enterOuterAlt(_localctx, 6);
				{
				setState(926);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(925); match(EXTERNAL);
					}
				}

				setState(928); match(SECURITY);
				setState(929); match(DEFINER);
				setState(930); match(COST);
				setState(931); ((Function_actionContext)_localctx).execution_cost = match(NUMBER);
				setState(932); match(ROWS);
				setState(933); ((Function_actionContext)_localctx).result_rows = match(NUMBER);
				setState(934); match(SET);
				setState(935); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(941);
				switch (_input.LA(1)) {
				case TO:
					{
					setState(936); match(TO);
					setState(937); ((Function_actionContext)_localctx).value = identifier();
					}
					break;
				case EQUAL:
					{
					setState(938); match(EQUAL);
					setState(939); ((Function_actionContext)_localctx).value = identifier();
					}
					break;
				case DEFAULT:
					{
					setState(940); match(DEFAULT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(943); match(SET);
				setState(944); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(945); match(FROM);
				setState(946); match(CURRENT);
				setState(947); match(RESET);
				setState(948); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(949); match(RESET);
				setState(950); match(ALL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_statementContext extends ParserRuleContext {
		public Token u;
		public IdentifierContext n;
		public Schema_qualified_nameContext t;
		public Method_specifierContext m;
		public Sort_specifier_listContext s;
		public Param_clauseContext p;
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public Sort_specifier_listContext sort_specifier_list() {
			return getRuleContext(Sort_specifier_listContext.class,0);
		}
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Method_specifierContext method_specifier() {
			return getRuleContext(Method_specifierContext.class,0);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public Index_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIndex_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIndex_statement(this);
		}
	}

	public final Index_statementContext index_statement() throws RecognitionException {
		Index_statementContext _localctx = new Index_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_index_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(954); match(CREATE);
			setState(956);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(955); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(958); match(INDEX);
			setState(959); ((Index_statementContext)_localctx).n = identifier();
			setState(960); match(ON);
			setState(961); ((Index_statementContext)_localctx).t = schema_qualified_name();
			setState(963);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(962); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(965); match(LEFT_PAREN);
			setState(966); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(967); match(RIGHT_PAREN);
			setState(969);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(968); ((Index_statementContext)_localctx).p = param_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_extension_statementContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext schema_name;
		public IdentifierContext version;
		public IdentifierContext old_version;
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode VERSION() { return getToken(SQLParser.VERSION, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode EXTENSION() { return getToken(SQLParser.EXTENSION, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Create_extension_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_extension_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCreate_extension_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCreate_extension_statement(this);
		}
	}

	public final Create_extension_statementContext create_extension_statement() throws RecognitionException {
		Create_extension_statementContext _localctx = new Create_extension_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_create_extension_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(971); match(CREATE);
			setState(972); match(EXTENSION);
			setState(976);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(973); match(IF);
				setState(974); match(NOT);
				setState(975); match(EXISTS);
				}
			}

			setState(978); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(980);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(979); match(WITH);
				}
			}

			setState(984);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(982); match(SCHEMA);
				setState(983); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(988);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(986); match(VERSION);
				setState(987); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(992);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(990); match(FROM);
				setState(991); ((Create_extension_statementContext)_localctx).old_version = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_language_statementContext extends ParserRuleContext {
		public IdentifierContext name;
		public Schema_qualified_nameContext call_handler;
		public Schema_qualified_nameContext inline_handler;
		public Schema_qualified_nameContext valfunction;
		public TerminalNode VALIDATOR() { return getToken(SQLParser.VALIDATOR, 0); }
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode TRUSTED() { return getToken(SQLParser.TRUSTED, 0); }
		public TerminalNode OR() { return getToken(SQLParser.OR, 0); }
		public TerminalNode INLINE() { return getToken(SQLParser.INLINE, 0); }
		public TerminalNode REPLACE() { return getToken(SQLParser.REPLACE, 0); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode LANGUAGE() { return getToken(SQLParser.LANGUAGE, 0); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public TerminalNode HANDLER() { return getToken(SQLParser.HANDLER, 0); }
		public TerminalNode PROCEDURAL() { return getToken(SQLParser.PROCEDURAL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Create_language_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_language_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCreate_language_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCreate_language_statement(this);
		}
	}

	public final Create_language_statementContext create_language_statement() throws RecognitionException {
		Create_language_statementContext _localctx = new Create_language_statementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_create_language_statement);
		int _la;
		try {
			setState(1027);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(994); match(CREATE);
				setState(997);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(995); match(OR);
					setState(996); match(REPLACE);
					}
				}

				setState(1000);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(999); match(PROCEDURAL);
					}
				}

				setState(1002); match(LANGUAGE);
				setState(1003); ((Create_language_statementContext)_localctx).name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1004); match(CREATE);
				setState(1007);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(1005); match(OR);
					setState(1006); match(REPLACE);
					}
				}

				setState(1010);
				_la = _input.LA(1);
				if (_la==TRUSTED) {
					{
					setState(1009); match(TRUSTED);
					}
				}

				setState(1013);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1012); match(PROCEDURAL);
					}
				}

				setState(1015); match(LANGUAGE);
				setState(1016); ((Create_language_statementContext)_localctx).name = identifier();
				setState(1017); match(HANDLER);
				setState(1018); ((Create_language_statementContext)_localctx).call_handler = schema_qualified_name();
				setState(1021);
				_la = _input.LA(1);
				if (_la==INLINE) {
					{
					setState(1019); match(INLINE);
					setState(1020); ((Create_language_statementContext)_localctx).inline_handler = schema_qualified_name();
					}
				}

				setState(1025);
				_la = _input.LA(1);
				if (_la==VALIDATOR) {
					{
					setState(1023); match(VALIDATOR);
					setState(1024); ((Create_language_statementContext)_localctx).valfunction = schema_qualified_name();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_statementContext extends ParserRuleContext {
		public IdentifierContext config_param;
		public Value_expressionContext value;
		public IdentifierContext timezone;
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode QUOTE(int i) {
			return getToken(SQLParser.QUOTE, i);
		}
		public TerminalNode SESSION() { return getToken(SQLParser.SESSION, 0); }
		public TerminalNode TIME() { return getToken(SQLParser.TIME, 0); }
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<TerminalNode> DEFAULT() { return getTokens(SQLParser.DEFAULT); }
		public List<TerminalNode> QUOTE() { return getTokens(SQLParser.QUOTE); }
		public TerminalNode DEFAULT(int i) {
			return getToken(SQLParser.DEFAULT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode LOCAL(int i) {
			return getToken(SQLParser.LOCAL, i);
		}
		public List<TerminalNode> LOCAL() { return getTokens(SQLParser.LOCAL); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode ZONE() { return getToken(SQLParser.ZONE, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Set_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSet_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSet_statement(this);
		}
	}

	public final Set_statementContext set_statement() throws RecognitionException {
		Set_statementContext _localctx = new Set_statementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_set_statement);
		int _la;
		try {
			int _alt;
			setState(1068);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1029); match(SET);
				setState(1031);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(1030);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1033); ((Set_statementContext)_localctx).config_param = identifier();
				setState(1034);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1046); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1041);
						switch (_input.LA(1)) {
						case ANY:
						case CASE:
						case CAST:
						case FALSE:
						case LEFT:
						case NOT:
						case NULL:
						case RIGHT:
						case SOME:
						case TRUE:
						case ADMIN:
						case ALWAYS:
						case AVG:
						case BETWEEN:
						case BY:
						case CACHE:
						case CALLED:
						case CLASS:
						case CENTURY:
						case CHARACTER:
						case CHECK:
						case CLUSTER:
						case COLLECT:
						case COALESCE:
						case COLUMN:
						case COMMENT:
						case COMMENTS:
						case COMMIT:
						case CONFIGURATION:
						case COST:
						case COUNT:
						case CUBE:
						case CURRENT:
						case CYCLE:
						case DATA:
						case DAY:
						case DEC:
						case DECADE:
						case DEFINER:
						case DICTIONARY:
						case DISABLE:
						case DOW:
						case DOY:
						case DROP:
						case ENABLE:
						case EPOCH:
						case EVERY:
						case EXISTS:
						case EXTENDED:
						case EXTERNAL:
						case EXTRACT:
						case FAMILY:
						case FILTER:
						case FIRST:
						case FORMAT:
						case FUSION:
						case GROUPING:
						case HASH:
						case INHERIT:
						case INDEX:
						case INCREMENT:
						case INPUT:
						case INSERT:
						case INTERSECTION:
						case ISCACHABLE:
						case ISODOW:
						case ISOYEAR:
						case ISSTRICT:
						case LANGUAGE:
						case LARGE:
						case LAST:
						case LESS:
						case LIST:
						case LOCATION:
						case MAIN:
						case MATCH:
						case MAX:
						case MAXVALUE:
						case MICROSECONDS:
						case MILLENNIUM:
						case MILLISECONDS:
						case MIN:
						case MINVALUE:
						case MINUTE:
						case MONTH:
						case NATIONAL:
						case NO:
						case NONE:
						case NULLIF:
						case OBJECT:
						case ON:
						case ONLY:
						case OPTION:
						case OPTIONS:
						case OVERWRITE:
						case PARSER:
						case PARTIAL:
						case PARTITION:
						case PARTITIONS:
						case PLAIN:
						case PRECISION:
						case PUBLIC:
						case PURGE:
						case QUARTER:
						case RANGE:
						case REGEXP:
						case RENAME:
						case REPLICA:
						case RESET:
						case RLIKE:
						case ROLLUP:
						case SEARCH:
						case SECOND:
						case SECURITY:
						case SERVER:
						case SET:
						case SIMILAR:
						case SIMPLE:
						case STABLE:
						case START:
						case STATISTICS:
						case STORAGE:
						case STDDEV_POP:
						case STDDEV_SAMP:
						case SUBPARTITION:
						case SUM:
						case TABLESPACE:
						case TEMPLATE:
						case THAN:
						case TIMEZONE:
						case TIMEZONE_HOUR:
						case TIMEZONE_MINUTE:
						case TRIM:
						case TO:
						case TYPE:
						case UNKNOWN:
						case UNLOGGED:
						case USER:
						case VALID:
						case VALIDATE:
						case VALUES:
						case VAR_SAMP:
						case VAR_POP:
						case VARYING:
						case VERSION:
						case VOLATILE:
						case WEEK:
						case WINDOW:
						case WRAPPER:
						case YEAR:
						case ZONE:
						case BOOLEAN:
						case BOOL:
						case BIT:
						case VARBIT:
						case INT1:
						case INT2:
						case INT4:
						case INT8:
						case TINYINT:
						case SMALLINT:
						case INT:
						case INTEGER:
						case BIGINT:
						case FLOAT4:
						case FLOAT8:
						case REAL:
						case FLOAT:
						case DOUBLE:
						case NUMERIC:
						case DECIMAL:
						case CHAR:
						case VARCHAR:
						case NCHAR:
						case NVARCHAR:
						case DATE:
						case TIME:
						case TIMETZ:
						case TIMESTAMP:
						case TIMESTAMPTZ:
						case TEXT:
						case UUID:
						case VARBINARY:
						case BLOB:
						case BYTEA:
						case INET4:
						case INTERVAL:
						case VOID:
						case LEFT_PAREN:
						case PLUS:
						case MINUS:
						case DOUBLE_QUOTE:
						case NUMBER:
						case REAL_NUMBER:
						case Identifier:
						case QuotedIdentifier:
						case Character_String_Literal:
							{
							setState(1035); ((Set_statementContext)_localctx).value = value_expression();
							}
							break;
						case QUOTE:
							{
							setState(1036); match(QUOTE);
							setState(1037); ((Set_statementContext)_localctx).value = value_expression();
							setState(1038); match(QUOTE);
							}
							break;
						case DEFAULT:
							{
							setState(1040); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1044);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1043); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1048); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1050); match(SET);
				setState(1052);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(1051);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1054); match(TIME);
				setState(1055); match(ZONE);
				setState(1064); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1059);
						switch (_input.LA(1)) {
						case ADMIN:
						case ALWAYS:
						case AVG:
						case BETWEEN:
						case BY:
						case CACHE:
						case CALLED:
						case CLASS:
						case CENTURY:
						case CHARACTER:
						case CHECK:
						case CLUSTER:
						case COLLECT:
						case COALESCE:
						case COLUMN:
						case COMMENT:
						case COMMENTS:
						case COMMIT:
						case CONFIGURATION:
						case COST:
						case COUNT:
						case CUBE:
						case CURRENT:
						case CYCLE:
						case DATA:
						case DAY:
						case DEC:
						case DECADE:
						case DEFINER:
						case DICTIONARY:
						case DISABLE:
						case DOW:
						case DOY:
						case DROP:
						case ENABLE:
						case EPOCH:
						case EVERY:
						case EXISTS:
						case EXTENDED:
						case EXTERNAL:
						case EXTRACT:
						case FAMILY:
						case FILTER:
						case FIRST:
						case FORMAT:
						case FUSION:
						case GROUPING:
						case HASH:
						case INHERIT:
						case INDEX:
						case INCREMENT:
						case INPUT:
						case INSERT:
						case INTERSECTION:
						case ISCACHABLE:
						case ISODOW:
						case ISOYEAR:
						case ISSTRICT:
						case LANGUAGE:
						case LARGE:
						case LAST:
						case LESS:
						case LIST:
						case LOCATION:
						case MAIN:
						case MATCH:
						case MAX:
						case MAXVALUE:
						case MICROSECONDS:
						case MILLENNIUM:
						case MILLISECONDS:
						case MIN:
						case MINVALUE:
						case MINUTE:
						case MONTH:
						case NATIONAL:
						case NO:
						case NONE:
						case NULLIF:
						case OBJECT:
						case ON:
						case ONLY:
						case OPTION:
						case OPTIONS:
						case OVERWRITE:
						case PARSER:
						case PARTIAL:
						case PARTITION:
						case PARTITIONS:
						case PLAIN:
						case PRECISION:
						case PUBLIC:
						case PURGE:
						case QUARTER:
						case RANGE:
						case REGEXP:
						case RENAME:
						case REPLICA:
						case RESET:
						case RLIKE:
						case ROLLUP:
						case SEARCH:
						case SECOND:
						case SECURITY:
						case SERVER:
						case SET:
						case SIMILAR:
						case SIMPLE:
						case STABLE:
						case START:
						case STATISTICS:
						case STORAGE:
						case STDDEV_POP:
						case STDDEV_SAMP:
						case SUBPARTITION:
						case SUM:
						case TABLESPACE:
						case TEMPLATE:
						case THAN:
						case TIMEZONE:
						case TIMEZONE_HOUR:
						case TIMEZONE_MINUTE:
						case TRIM:
						case TO:
						case TYPE:
						case UNKNOWN:
						case UNLOGGED:
						case USER:
						case VALID:
						case VALIDATE:
						case VALUES:
						case VAR_SAMP:
						case VAR_POP:
						case VARYING:
						case VERSION:
						case VOLATILE:
						case WEEK:
						case WINDOW:
						case WRAPPER:
						case YEAR:
						case ZONE:
						case BOOLEAN:
						case BOOL:
						case BIT:
						case VARBIT:
						case INT1:
						case INT2:
						case INT4:
						case INT8:
						case TINYINT:
						case SMALLINT:
						case INT:
						case INTEGER:
						case BIGINT:
						case FLOAT4:
						case FLOAT8:
						case REAL:
						case FLOAT:
						case DOUBLE:
						case NUMERIC:
						case DECIMAL:
						case CHAR:
						case VARCHAR:
						case NCHAR:
						case NVARCHAR:
						case DATE:
						case TIME:
						case TIMETZ:
						case TIMESTAMP:
						case TIMESTAMPTZ:
						case TEXT:
						case UUID:
						case VARBINARY:
						case BLOB:
						case BYTEA:
						case INET4:
						case INTERVAL:
						case VOID:
						case DOUBLE_QUOTE:
						case Identifier:
						case QuotedIdentifier:
							{
							setState(1056); ((Set_statementContext)_localctx).timezone = identifier();
							}
							break;
						case LOCAL:
							{
							setState(1057); match(LOCAL);
							}
							break;
						case DEFAULT:
							{
							setState(1058); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1062);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1061); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1066); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_trigger_statementContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext columnName;
		public Schema_qualified_nameContext tabl_name;
		public Schema_qualified_nameContext referenced_table_name;
		public IdentifierContext func_name;
		public IdentifierContext arguments;
		public TerminalNode DEFERRED() { return getToken(SQLParser.DEFERRED, 0); }
		public TerminalNode EXECUTE() { return getToken(SQLParser.EXECUTE, 0); }
		public TerminalNode BEFORE() { return getToken(SQLParser.BEFORE, 0); }
		public TerminalNode DEFERRABLE() { return getToken(SQLParser.DEFERRABLE, 0); }
		public TerminalNode PROCEDURE() { return getToken(SQLParser.PROCEDURE, 0); }
		public TerminalNode OF(int i) {
			return getToken(SQLParser.OF, i);
		}
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public TerminalNode EACH() { return getToken(SQLParser.EACH, 0); }
		public TerminalNode TRUNCATE() { return getToken(SQLParser.TRUNCATE, 0); }
		public TerminalNode INITIALLY() { return getToken(SQLParser.INITIALLY, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode ROW() { return getToken(SQLParser.ROW, 0); }
		public TerminalNode INSTEAD() { return getToken(SQLParser.INSTEAD, 0); }
		public List<TerminalNode> OF() { return getTokens(SQLParser.OF); }
		public TerminalNode DELETE() { return getToken(SQLParser.DELETE, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode UPDATE() { return getToken(SQLParser.UPDATE, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode IMMEDIATE() { return getToken(SQLParser.IMMEDIATE, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public TerminalNode WHEN() { return getToken(SQLParser.WHEN, 0); }
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode STATEMENT() { return getToken(SQLParser.STATEMENT, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode TRIGGER() { return getToken(SQLParser.TRIGGER, 0); }
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode AFTER() { return getToken(SQLParser.AFTER, 0); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public Create_trigger_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_trigger_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCreate_trigger_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCreate_trigger_statement(this);
		}
	}

	public final Create_trigger_statementContext create_trigger_statement() throws RecognitionException {
		Create_trigger_statementContext _localctx = new Create_trigger_statementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_create_trigger_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1070); match(CREATE);
			setState(1072);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1071); match(CONSTRAINT);
				}
			}

			setState(1074); match(TRIGGER);
			setState(1075); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(1080);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(1076); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(1077); match(INSTEAD);
				setState(1078); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(1079); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1097);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(1082); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(1083); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(1084); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				{
				setState(1085); match(UPDATE);
				setState(1095);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(1086); match(OF);
					setState(1091); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1087); ((Create_trigger_statementContext)_localctx).columnName = identifier();
							setState(1089);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1088); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1093); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1099); match(ON);
			setState(1100); ((Create_trigger_statementContext)_localctx).tabl_name = schema_qualified_name();
			setState(1103);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(1101); match(FROM);
				setState(1102); ((Create_trigger_statementContext)_localctx).referenced_table_name = schema_qualified_name();
				}
			}

			setState(1114);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(1105); match(NOT);
				setState(1106); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(1108);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(1107); match(DEFERRABLE);
					}
				}

				{
				setState(1110); match(INITIALLY);
				setState(1111); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(1112); match(INITIALLY);
				setState(1113); match(DEFERRED);
				}
				}
				break;
			}
			setState(1122);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(1116); match(FOR);
				setState(1118);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(1117); match(EACH);
					}
				}

				setState(1120); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(1121); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1126);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(1124); match(WHEN);
				{
				setState(1125); boolean_value_expression();
				}
				}
			}

			setState(1128); match(EXECUTE);
			setState(1129); match(PROCEDURE);
			setState(1130); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(1131); match(LEFT_PAREN);
			setState(1136);
			_la = _input.LA(1);
			if (((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0)) {
				{
				setState(1132); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(1134);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1133); match(COMMA);
					}
				}

				}
			}

			setState(1138); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Revoke_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext table_name;
		public IdentifierContext schema_name;
		public IdentifierContext column;
		public Schema_qualified_nameContext sequence_name;
		public IdentifierContext database_name;
		public Schema_qualified_nameContext fdw_name;
		public IdentifierContext server_name;
		public IdentifierContext lang_name;
		public IdentifierContext loid;
		public IdentifierContext tablespace_name;
		public IdentifierContext role_name;
		public TerminalNode TABLE(int i) {
			return getToken(SQLParser.TABLE, i);
		}
		public TerminalNode SELECT(int i) {
			return getToken(SQLParser.SELECT, i);
		}
		public List<TerminalNode> INSERT() { return getTokens(SQLParser.INSERT); }
		public TerminalNode DELETE(int i) {
			return getToken(SQLParser.DELETE, i);
		}
		public List<TerminalNode> TRUNCATE() { return getTokens(SQLParser.TRUNCATE); }
		public TerminalNode REVOKE() { return getToken(SQLParser.REVOKE, 0); }
		public Functions_definition_schemaContext functions_definition_schema() {
			return getRuleContext(Functions_definition_schemaContext.class,0);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public TerminalNode WRAPPER() { return getToken(SQLParser.WRAPPER, 0); }
		public TerminalNode GRANT() { return getToken(SQLParser.GRANT, 0); }
		public TerminalNode UPDATE(int i) {
			return getToken(SQLParser.UPDATE, i);
		}
		public TerminalNode TRUNCATE(int i) {
			return getToken(SQLParser.TRUNCATE, i);
		}
		public List<TerminalNode> DELETE() { return getTokens(SQLParser.DELETE); }
		public List<TerminalNode> TABLE() { return getTokens(SQLParser.TABLE); }
		public TerminalNode PRIVILEGES() { return getToken(SQLParser.PRIVILEGES, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public List<TerminalNode> ALL() { return getTokens(SQLParser.ALL); }
		public Revoke_from_cascade_restrictContext revoke_from_cascade_restrict() {
			return getRuleContext(Revoke_from_cascade_restrictContext.class,0);
		}
		public TerminalNode RESTRICT() { return getToken(SQLParser.RESTRICT, 0); }
		public List<TerminalNode> USAGE() { return getTokens(SQLParser.USAGE); }
		public List<TerminalNode> REFERENCES() { return getTokens(SQLParser.REFERENCES); }
		public List<TerminalNode> TRIGGER() { return getTokens(SQLParser.TRIGGER); }
		public TerminalNode CASCADE() { return getToken(SQLParser.CASCADE, 0); }
		public TerminalNode DATA() { return getToken(SQLParser.DATA, 0); }
		public TerminalNode ALL(int i) {
			return getToken(SQLParser.ALL, i);
		}
		public List<TerminalNode> CONNECT() { return getTokens(SQLParser.CONNECT); }
		public TerminalNode FOREIGN() { return getToken(SQLParser.FOREIGN, 0); }
		public TerminalNode OBJECT() { return getToken(SQLParser.OBJECT, 0); }
		public TerminalNode CONNECT(int i) {
			return getToken(SQLParser.CONNECT, i);
		}
		public TerminalNode ADMIN() { return getToken(SQLParser.ADMIN, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode EXECUTE() { return getToken(SQLParser.EXECUTE, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode TABLES() { return getToken(SQLParser.TABLES, 0); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public TerminalNode USAGE(int i) {
			return getToken(SQLParser.USAGE, i);
		}
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode TRIGGER(int i) {
			return getToken(SQLParser.TRIGGER, i);
		}
		public TerminalNode SERVER() { return getToken(SQLParser.SERVER, 0); }
		public List<TerminalNode> TEMP() { return getTokens(SQLParser.TEMP); }
		public TerminalNode LANGUAGE() { return getToken(SQLParser.LANGUAGE, 0); }
		public List<TerminalNode> UPDATE() { return getTokens(SQLParser.UPDATE); }
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public TerminalNode OPTION() { return getToken(SQLParser.OPTION, 0); }
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public List<TerminalNode> CREATE() { return getTokens(SQLParser.CREATE); }
		public TerminalNode CREATE(int i) {
			return getToken(SQLParser.CREATE, i);
		}
		public TerminalNode LARGE() { return getToken(SQLParser.LARGE, 0); }
		public List<TerminalNode> TEMPORARY() { return getTokens(SQLParser.TEMPORARY); }
		public List<TerminalNode> SELECT() { return getTokens(SQLParser.SELECT); }
		public TerminalNode INSERT(int i) {
			return getToken(SQLParser.INSERT, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode SEQUENCE() { return getToken(SQLParser.SEQUENCE, 0); }
		public TerminalNode TEMP(int i) {
			return getToken(SQLParser.TEMP, i);
		}
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode TEMPORARY(int i) {
			return getToken(SQLParser.TEMPORARY, i);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public TerminalNode REFERENCES(int i) {
			return getToken(SQLParser.REFERENCES, i);
		}
		public TerminalNode SEQUENCES() { return getToken(SQLParser.SEQUENCES, 0); }
		public Revoke_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_revoke_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRevoke_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRevoke_statement(this);
		}
	}

	public final Revoke_statementContext revoke_statement() throws RecognitionException {
		Revoke_statementContext _localctx = new Revoke_statementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_revoke_statement);
		int _la;
		try {
			int _alt;
			setState(1519);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1140); match(REVOKE);
				setState(1144);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1141); match(GRANT);
					setState(1142); match(OPTION);
					setState(1143); match(FOR);
					}
				}

				setState(1155);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1147); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1146);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1149); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1151); match(ALL);
					setState(1153);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1152); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1157); match(ON);
				setState(1175);
				switch (_input.LA(1)) {
				case TABLE:
				case ADMIN:
				case ALWAYS:
				case AVG:
				case BETWEEN:
				case BY:
				case CACHE:
				case CALLED:
				case CLASS:
				case CENTURY:
				case CHARACTER:
				case CHECK:
				case CLUSTER:
				case COLLECT:
				case COALESCE:
				case COLUMN:
				case COMMENT:
				case COMMENTS:
				case COMMIT:
				case CONFIGURATION:
				case COST:
				case COUNT:
				case CUBE:
				case CURRENT:
				case CYCLE:
				case DATA:
				case DAY:
				case DEC:
				case DECADE:
				case DEFINER:
				case DICTIONARY:
				case DISABLE:
				case DOW:
				case DOY:
				case DROP:
				case ENABLE:
				case EPOCH:
				case EVERY:
				case EXISTS:
				case EXTENDED:
				case EXTERNAL:
				case EXTRACT:
				case FAMILY:
				case FILTER:
				case FIRST:
				case FORMAT:
				case FUSION:
				case GROUPING:
				case HASH:
				case INHERIT:
				case INDEX:
				case INCREMENT:
				case INPUT:
				case INSERT:
				case INTERSECTION:
				case ISCACHABLE:
				case ISODOW:
				case ISOYEAR:
				case ISSTRICT:
				case LANGUAGE:
				case LARGE:
				case LAST:
				case LESS:
				case LIST:
				case LOCATION:
				case MAIN:
				case MATCH:
				case MAX:
				case MAXVALUE:
				case MICROSECONDS:
				case MILLENNIUM:
				case MILLISECONDS:
				case MIN:
				case MINVALUE:
				case MINUTE:
				case MONTH:
				case NATIONAL:
				case NO:
				case NONE:
				case NULLIF:
				case OBJECT:
				case ON:
				case ONLY:
				case OPTION:
				case OPTIONS:
				case OVERWRITE:
				case PARSER:
				case PARTIAL:
				case PARTITION:
				case PARTITIONS:
				case PLAIN:
				case PRECISION:
				case PUBLIC:
				case PURGE:
				case QUARTER:
				case RANGE:
				case REGEXP:
				case RENAME:
				case REPLICA:
				case RESET:
				case RLIKE:
				case ROLLUP:
				case SEARCH:
				case SECOND:
				case SECURITY:
				case SERVER:
				case SET:
				case SIMILAR:
				case SIMPLE:
				case STABLE:
				case START:
				case STATISTICS:
				case STORAGE:
				case STDDEV_POP:
				case STDDEV_SAMP:
				case SUBPARTITION:
				case SUM:
				case TABLESPACE:
				case TEMPLATE:
				case THAN:
				case TIMEZONE:
				case TIMEZONE_HOUR:
				case TIMEZONE_MINUTE:
				case TRIM:
				case TO:
				case TYPE:
				case UNKNOWN:
				case UNLOGGED:
				case USER:
				case VALID:
				case VALIDATE:
				case VALUES:
				case VAR_SAMP:
				case VAR_POP:
				case VARYING:
				case VERSION:
				case VOLATILE:
				case WEEK:
				case WINDOW:
				case WRAPPER:
				case YEAR:
				case ZONE:
				case BOOLEAN:
				case BOOL:
				case BIT:
				case VARBIT:
				case INT1:
				case INT2:
				case INT4:
				case INT8:
				case TINYINT:
				case SMALLINT:
				case INT:
				case INTEGER:
				case BIGINT:
				case FLOAT4:
				case FLOAT8:
				case REAL:
				case FLOAT:
				case DOUBLE:
				case NUMERIC:
				case DECIMAL:
				case CHAR:
				case VARCHAR:
				case NCHAR:
				case NVARCHAR:
				case DATE:
				case TIME:
				case TIMETZ:
				case TIMESTAMP:
				case TIMESTAMPTZ:
				case TEXT:
				case UUID:
				case VARBINARY:
				case BLOB:
				case BYTEA:
				case INET4:
				case INTERVAL:
				case VOID:
				case DOUBLE_QUOTE:
				case Identifier:
				case QuotedIdentifier:
					{
					setState(1162); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1159);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1158); match(TABLE);
							}
						}

						setState(1161); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
						}
						}
						setState(1164); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (TABLE - 114)) | (1L << (ADMIN - 114)) | (1L << (ALWAYS - 114)) | (1L << (AVG - 114)) | (1L << (BETWEEN - 114)) | (1L << (BY - 114)) | (1L << (CACHE - 114)) | (1L << (CALLED - 114)) | (1L << (CLASS - 114)) | (1L << (CENTURY - 114)) | (1L << (CHARACTER - 114)) | (1L << (CHECK - 114)) | (1L << (CLUSTER - 114)) | (1L << (COLLECT - 114)) | (1L << (COALESCE - 114)) | (1L << (COLUMN - 114)) | (1L << (COMMENT - 114)) | (1L << (COMMENTS - 114)) | (1L << (COMMIT - 114)) | (1L << (CONFIGURATION - 114)) | (1L << (COST - 114)) | (1L << (COUNT - 114)) | (1L << (CUBE - 114)) | (1L << (CURRENT - 114)) | (1L << (CYCLE - 114)) | (1L << (DATA - 114)) | (1L << (DAY - 114)) | (1L << (DEC - 114)) | (1L << (DECADE - 114)) | (1L << (DEFINER - 114)) | (1L << (DICTIONARY - 114)) | (1L << (DISABLE - 114)) | (1L << (DOW - 114)) | (1L << (DOY - 114)) | (1L << (DROP - 114)) | (1L << (ENABLE - 114)) | (1L << (EPOCH - 114)) | (1L << (EVERY - 114)) | (1L << (EXISTS - 114)) | (1L << (EXTENDED - 114)) | (1L << (EXTERNAL - 114)) | (1L << (EXTRACT - 114)) | (1L << (FAMILY - 114)) | (1L << (FILTER - 114)))) != 0) || ((((_la - 178)) & ~0x3f) == 0 && ((1L << (_la - 178)) & ((1L << (FIRST - 178)) | (1L << (FORMAT - 178)) | (1L << (FUSION - 178)) | (1L << (GROUPING - 178)) | (1L << (HASH - 178)) | (1L << (INHERIT - 178)) | (1L << (INDEX - 178)) | (1L << (INCREMENT - 178)) | (1L << (INPUT - 178)) | (1L << (INSERT - 178)) | (1L << (INTERSECTION - 178)) | (1L << (ISCACHABLE - 178)) | (1L << (ISODOW - 178)) | (1L << (ISOYEAR - 178)) | (1L << (ISSTRICT - 178)) | (1L << (LANGUAGE - 178)) | (1L << (LARGE - 178)) | (1L << (LAST - 178)) | (1L << (LESS - 178)) | (1L << (LIST - 178)) | (1L << (LOCATION - 178)) | (1L << (MAIN - 178)) | (1L << (MATCH - 178)) | (1L << (MAX - 178)) | (1L << (MAXVALUE - 178)) | (1L << (MICROSECONDS - 178)) | (1L << (MILLENNIUM - 178)) | (1L << (MILLISECONDS - 178)) | (1L << (MIN - 178)) | (1L << (MINVALUE - 178)) | (1L << (MINUTE - 178)) | (1L << (MONTH - 178)) | (1L << (NATIONAL - 178)) | (1L << (NO - 178)) | (1L << (NONE - 178)) | (1L << (NULLIF - 178)) | (1L << (OBJECT - 178)) | (1L << (ON - 178)) | (1L << (ONLY - 178)) | (1L << (OPTION - 178)) | (1L << (OPTIONS - 178)) | (1L << (OVERWRITE - 178)) | (1L << (PARSER - 178)) | (1L << (PARTIAL - 178)) | (1L << (PARTITION - 178)) | (1L << (PARTITIONS - 178)) | (1L << (PLAIN - 178)) | (1L << (PRECISION - 178)) | (1L << (PUBLIC - 178)) | (1L << (PURGE - 178)) | (1L << (QUARTER - 178)) | (1L << (RANGE - 178)) | (1L << (REGEXP - 178)) | (1L << (RENAME - 178)) | (1L << (REPLICA - 178)) | (1L << (RESET - 178)) | (1L << (RLIKE - 178)) | (1L << (ROLLUP - 178)) | (1L << (SEARCH - 178)) | (1L << (SECOND - 178)))) != 0) || ((((_la - 242)) & ~0x3f) == 0 && ((1L << (_la - 242)) & ((1L << (SECURITY - 242)) | (1L << (SERVER - 242)) | (1L << (SET - 242)) | (1L << (SIMILAR - 242)) | (1L << (SIMPLE - 242)) | (1L << (STABLE - 242)) | (1L << (START - 242)) | (1L << (STATISTICS - 242)) | (1L << (STORAGE - 242)) | (1L << (STDDEV_POP - 242)) | (1L << (STDDEV_SAMP - 242)) | (1L << (SUBPARTITION - 242)) | (1L << (SUM - 242)) | (1L << (TABLESPACE - 242)) | (1L << (TEMPLATE - 242)) | (1L << (THAN - 242)) | (1L << (TIMEZONE - 242)) | (1L << (TIMEZONE_HOUR - 242)) | (1L << (TIMEZONE_MINUTE - 242)) | (1L << (TRIM - 242)) | (1L << (TO - 242)) | (1L << (TYPE - 242)) | (1L << (UNKNOWN - 242)) | (1L << (UNLOGGED - 242)) | (1L << (USER - 242)) | (1L << (VALID - 242)) | (1L << (VALIDATE - 242)) | (1L << (VALUES - 242)) | (1L << (VAR_SAMP - 242)) | (1L << (VAR_POP - 242)) | (1L << (VARYING - 242)) | (1L << (VERSION - 242)) | (1L << (VOLATILE - 242)) | (1L << (WEEK - 242)) | (1L << (WINDOW - 242)) | (1L << (WRAPPER - 242)) | (1L << (YEAR - 242)) | (1L << (ZONE - 242)) | (1L << (BOOLEAN - 242)) | (1L << (BOOL - 242)) | (1L << (BIT - 242)) | (1L << (VARBIT - 242)) | (1L << (INT1 - 242)) | (1L << (INT2 - 242)) | (1L << (INT4 - 242)) | (1L << (INT8 - 242)) | (1L << (TINYINT - 242)) | (1L << (SMALLINT - 242)) | (1L << (INT - 242)) | (1L << (INTEGER - 242)) | (1L << (BIGINT - 242)) | (1L << (FLOAT4 - 242)) | (1L << (FLOAT8 - 242)) | (1L << (REAL - 242)) | (1L << (FLOAT - 242)) | (1L << (DOUBLE - 242)) | (1L << (NUMERIC - 242)) | (1L << (DECIMAL - 242)) | (1L << (CHAR - 242)) | (1L << (VARCHAR - 242)) | (1L << (NCHAR - 242)) | (1L << (NVARCHAR - 242)))) != 0) || ((((_la - 306)) & ~0x3f) == 0 && ((1L << (_la - 306)) & ((1L << (DATE - 306)) | (1L << (TIME - 306)) | (1L << (TIMETZ - 306)) | (1L << (TIMESTAMP - 306)) | (1L << (TIMESTAMPTZ - 306)) | (1L << (TEXT - 306)) | (1L << (UUID - 306)) | (1L << (VARBINARY - 306)) | (1L << (BLOB - 306)) | (1L << (BYTEA - 306)) | (1L << (INET4 - 306)) | (1L << (INTERVAL - 306)) | (1L << (VOID - 306)) | (1L << (DOUBLE_QUOTE - 306)) | (1L << (Identifier - 306)) | (1L << (QuotedIdentifier - 306)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1166); match(ALL);
					setState(1167); match(TABLES);
					setState(1168); match(IN);
					setState(1169); match(SCHEMA);
					setState(1171); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1170); ((Revoke_statementContext)_localctx).schema_name = identifier();
						}
						}
						setState(1173); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1177); revoke_from_cascade_restrict();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1179); match(REVOKE);
				setState(1183);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1180); match(GRANT);
					setState(1181); match(OPTION);
					setState(1182); match(FOR);
					}
				}

				setState(1216);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1197); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1185);
						_la = _input.LA(1);
						if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1186); match(LEFT_PAREN);
						setState(1191); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1187); ((Revoke_statementContext)_localctx).column = identifier();
							setState(1189);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1188); match(COMMA);
								}
							}

							}
							}
							setState(1193); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
						setState(1195); match(RIGHT_PAREN);
						}
						}
						setState(1199); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1201); match(ALL);
					setState(1203);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1202); match(PRIVILEGES);
						}
					}

					setState(1205); match(LEFT_PAREN);
					setState(1210); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1206); ((Revoke_statementContext)_localctx).column = identifier();
						setState(1208);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1207); match(COMMA);
							}
						}

						}
						}
						setState(1212); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
					setState(1214); match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1218); match(ON);
				setState(1220);
				_la = _input.LA(1);
				if (_la==TABLE) {
					{
					setState(1219); match(TABLE);
					}
				}

				setState(1226); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1222); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
					setState(1224);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1223); match(COMMA);
						}
					}

					}
					}
					setState(1228); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(1230); revoke_from_cascade_restrict();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1232); match(REVOKE);
				setState(1236);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1233); match(GRANT);
					setState(1234); match(OPTION);
					setState(1235); match(FOR);
					}
				}

				setState(1247);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(1239); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1238);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1241); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1243); match(ALL);
					setState(1245);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1244); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1249); match(ON);
				setState(1271);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1250); match(SEQUENCE);
					setState(1255); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1251); ((Revoke_statementContext)_localctx).sequence_name = schema_qualified_name();
						setState(1253);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1252); match(COMMA);
							}
						}

						}
						}
						setState(1257); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1259); match(ALL);
					setState(1260); match(SEQUENCES);
					setState(1261); match(IN);
					setState(1262); match(SCHEMA);
					setState(1267); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1263); ((Revoke_statementContext)_localctx).schema_name = identifier();
						setState(1265);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1264); match(COMMA);
							}
						}

						}
						}
						setState(1269); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1273); revoke_from_cascade_restrict();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1275); match(REVOKE);
				setState(1279);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1276); match(GRANT);
					setState(1277); match(OPTION);
					setState(1278); match(FOR);
					}
				}

				setState(1290);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1282); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1281);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1284); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(1286); match(ALL);
					setState(1288);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1287); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1292); match(ON);
				setState(1293); match(DATABASE);
				setState(1298); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1294); ((Revoke_statementContext)_localctx).database_name = identifier();
					setState(1296);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1295); match(COMMA);
						}
					}

					}
					}
					setState(1300); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(1302); revoke_from_cascade_restrict();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1304); match(REVOKE);
				setState(1308);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1305); match(GRANT);
					setState(1306); match(OPTION);
					setState(1307); match(FOR);
					}
				}

				setState(1315);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1310); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1311); match(ALL);
					setState(1313);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1312); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1317); match(ON);
				setState(1318); match(FOREIGN);
				setState(1319); match(DATA);
				setState(1320); match(WRAPPER);
				setState(1325); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1321); ((Revoke_statementContext)_localctx).fdw_name = schema_qualified_name();
					setState(1323);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1322); match(COMMA);
						}
					}

					}
					}
					setState(1327); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(1329); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1331); match(REVOKE);
				setState(1335);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1332); match(GRANT);
					setState(1333); match(OPTION);
					setState(1334); match(FOR);
					}
				}

				setState(1342);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1337); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1338); match(ALL);
					setState(1340);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1339); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1344); match(ON);
				setState(1345); match(FOREIGN);
				setState(1346); match(SERVER);
				setState(1351); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1347); ((Revoke_statementContext)_localctx).server_name = identifier();
					setState(1349);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1348); match(COMMA);
						}
					}

					}
					}
					setState(1353); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(1355); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1357); match(REVOKE);
				setState(1361);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1358); match(GRANT);
					setState(1359); match(OPTION);
					setState(1360); match(FOR);
					}
				}

				setState(1368);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1363); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1364); match(ALL);
					setState(1366);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1365); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1370); match(ON);
				setState(1373);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1371); function_definition();
					}
					break;
				case ALL:
					{
					setState(1372); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1375); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1377); match(REVOKE);
				setState(1381);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1378); match(GRANT);
					setState(1379); match(OPTION);
					setState(1380); match(FOR);
					}
				}

				setState(1388);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1383); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1384); match(ALL);
					setState(1386);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1385); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1390); match(ON);
				setState(1391); match(LANGUAGE);
				setState(1396); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1392); ((Revoke_statementContext)_localctx).lang_name = identifier();
					setState(1394);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1393); match(COMMA);
						}
					}

					}
					}
					setState(1398); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(1400); revoke_from_cascade_restrict();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1402); match(REVOKE);
				setState(1406);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1403); match(GRANT);
					setState(1404); match(OPTION);
					setState(1405); match(FOR);
					}
				}

				setState(1421);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1413); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(1413);
						switch (_input.LA(1)) {
						case SELECT:
							{
							setState(1408); match(SELECT);
							}
							break;
						case UPDATE:
							{
							setState(1409); match(UPDATE);
							setState(1411);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1410); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(1415); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1417); match(ALL);
					setState(1419);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1418); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1423); match(ON);
				setState(1424); match(LARGE);
				setState(1425); match(OBJECT);
				setState(1430); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1426); ((Revoke_statementContext)_localctx).loid = identifier();
					setState(1428);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1427); match(COMMA);
						}
					}

					}
					}
					setState(1432); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(1434); revoke_from_cascade_restrict();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1436); match(REVOKE);
				setState(1440);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1437); match(GRANT);
					setState(1438); match(OPTION);
					setState(1439); match(FOR);
					}
				}

				setState(1454);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1446); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1442);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1444);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1443); match(COMMA);
							}
						}

						}
						}
						setState(1448); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1450); match(ALL);
					setState(1452);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1451); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1456); match(ON);
				setState(1457); match(SCHEMA);
				setState(1462); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1458); ((Revoke_statementContext)_localctx).schema_name = identifier();
					setState(1460);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1459); match(COMMA);
						}
					}

					}
					}
					setState(1464); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(1466); revoke_from_cascade_restrict();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1468); match(REVOKE);
				setState(1472);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1469); match(GRANT);
					setState(1470); match(OPTION);
					setState(1471); match(FOR);
					}
				}

				setState(1479);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1474); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1475); match(ALL);
					setState(1477);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1476); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1481); match(ON);
				setState(1482); match(TABLESPACE);
				setState(1487); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1483); ((Revoke_statementContext)_localctx).tablespace_name = identifier();
					setState(1485);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1484); match(COMMA);
						}
					}

					}
					}
					setState(1489); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(1491); revoke_from_cascade_restrict();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1493); match(REVOKE);
				setState(1497);
				switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
				case 1:
					{
					setState(1494); match(ADMIN);
					setState(1495); match(OPTION);
					setState(1496); match(FOR);
					}
					break;
				}
				setState(1503); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1499); ((Revoke_statementContext)_localctx).role_name = identifier();
					setState(1501);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1500); match(COMMA);
						}
					}

					}
					}
					setState(1505); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(1507); match(FROM);
				setState(1512); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1508); ((Revoke_statementContext)_localctx).role_name = identifier();
						setState(1510);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1509); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1514); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,170,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1517);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(1516);
					_la = _input.LA(1);
					if ( !(_la==CASCADE || _la==RESTRICT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Revoke_from_cascade_restrictContext extends ParserRuleContext {
		public IdentifierContext role_name;
		public List<TerminalNode> PUBLIC() { return getTokens(SQLParser.PUBLIC); }
		public TerminalNode CASCADE() { return getToken(SQLParser.CASCADE, 0); }
		public TerminalNode GROUP(int i) {
			return getToken(SQLParser.GROUP, i);
		}
		public TerminalNode PUBLIC(int i) {
			return getToken(SQLParser.PUBLIC, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode RESTRICT() { return getToken(SQLParser.RESTRICT, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public List<TerminalNode> GROUP() { return getTokens(SQLParser.GROUP); }
		public Revoke_from_cascade_restrictContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_revoke_from_cascade_restrict; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRevoke_from_cascade_restrict(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRevoke_from_cascade_restrict(this);
		}
	}

	public final Revoke_from_cascade_restrictContext revoke_from_cascade_restrict() throws RecognitionException {
		Revoke_from_cascade_restrictContext _localctx = new Revoke_from_cascade_restrictContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_revoke_from_cascade_restrict);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1521); match(FROM);
			setState(1530); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1530);
					switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
					case 1:
						{
						setState(1523);
						_la = _input.LA(1);
						if (_la==GROUP) {
							{
							setState(1522); match(GROUP);
							}
						}

						setState(1525); ((Revoke_from_cascade_restrictContext)_localctx).role_name = identifier();
						}
						break;
					case 2:
						{
						setState(1526); match(PUBLIC);
						setState(1528);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1527); match(COMMA);
							}
						}

						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1532); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1535);
			_la = _input.LA(1);
			if (_la==CASCADE || _la==RESTRICT) {
				{
				setState(1534);
				_la = _input.LA(1);
				if ( !(_la==CASCADE || _la==RESTRICT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Grant_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext tabl_name;
		public IdentifierContext schem_name;
		public IdentifierContext column;
		public IdentifierContext sequence_name;
		public IdentifierContext schema_name;
		public IdentifierContext database_name;
		public IdentifierContext fdw_name;
		public IdentifierContext server_name;
		public IdentifierContext lang_name;
		public IdentifierContext loid;
		public IdentifierContext tablespace_name;
		public IdentifierContext role_name;
		public TerminalNode TABLE(int i) {
			return getToken(SQLParser.TABLE, i);
		}
		public TerminalNode SELECT(int i) {
			return getToken(SQLParser.SELECT, i);
		}
		public Grant_to_ruleContext grant_to_rule() {
			return getRuleContext(Grant_to_ruleContext.class,0);
		}
		public List<TerminalNode> INSERT() { return getTokens(SQLParser.INSERT); }
		public TerminalNode DELETE(int i) {
			return getToken(SQLParser.DELETE, i);
		}
		public List<TerminalNode> TRUNCATE() { return getTokens(SQLParser.TRUNCATE); }
		public Functions_definition_schemaContext functions_definition_schema() {
			return getRuleContext(Functions_definition_schemaContext.class,0);
		}
		public TerminalNode WRAPPER() { return getToken(SQLParser.WRAPPER, 0); }
		public List<TerminalNode> GRANT() { return getTokens(SQLParser.GRANT); }
		public TerminalNode UPDATE(int i) {
			return getToken(SQLParser.UPDATE, i);
		}
		public TerminalNode TRUNCATE(int i) {
			return getToken(SQLParser.TRUNCATE, i);
		}
		public List<TerminalNode> DELETE() { return getTokens(SQLParser.DELETE); }
		public List<TerminalNode> TABLE() { return getTokens(SQLParser.TABLE); }
		public TerminalNode PRIVILEGES() { return getToken(SQLParser.PRIVILEGES, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public List<TerminalNode> ALL() { return getTokens(SQLParser.ALL); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public List<TerminalNode> USAGE() { return getTokens(SQLParser.USAGE); }
		public List<TerminalNode> REFERENCES() { return getTokens(SQLParser.REFERENCES); }
		public List<TerminalNode> TRIGGER() { return getTokens(SQLParser.TRIGGER); }
		public TerminalNode ALL(int i) {
			return getToken(SQLParser.ALL, i);
		}
		public TerminalNode DATA() { return getToken(SQLParser.DATA, 0); }
		public List<TerminalNode> CONNECT() { return getTokens(SQLParser.CONNECT); }
		public TerminalNode FOREIGN() { return getToken(SQLParser.FOREIGN, 0); }
		public TerminalNode OBJECT() { return getToken(SQLParser.OBJECT, 0); }
		public TerminalNode CONNECT(int i) {
			return getToken(SQLParser.CONNECT, i);
		}
		public TerminalNode ADMIN() { return getToken(SQLParser.ADMIN, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode EXECUTE() { return getToken(SQLParser.EXECUTE, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode TABLES() { return getToken(SQLParser.TABLES, 0); }
		public TerminalNode GRANT(int i) {
			return getToken(SQLParser.GRANT, i);
		}
		public TerminalNode USAGE(int i) {
			return getToken(SQLParser.USAGE, i);
		}
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode TRIGGER(int i) {
			return getToken(SQLParser.TRIGGER, i);
		}
		public TerminalNode SERVER() { return getToken(SQLParser.SERVER, 0); }
		public List<TerminalNode> TEMP() { return getTokens(SQLParser.TEMP); }
		public TerminalNode LANGUAGE() { return getToken(SQLParser.LANGUAGE, 0); }
		public List<TerminalNode> UPDATE() { return getTokens(SQLParser.UPDATE); }
		public TerminalNode OPTION() { return getToken(SQLParser.OPTION, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode SEQUENCE(int i) {
			return getToken(SQLParser.SEQUENCE, i);
		}
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public List<TerminalNode> CREATE() { return getTokens(SQLParser.CREATE); }
		public TerminalNode CREATE(int i) {
			return getToken(SQLParser.CREATE, i);
		}
		public TerminalNode LARGE() { return getToken(SQLParser.LARGE, 0); }
		public List<TerminalNode> TEMPORARY() { return getTokens(SQLParser.TEMPORARY); }
		public List<TerminalNode> SELECT() { return getTokens(SQLParser.SELECT); }
		public TerminalNode INSERT(int i) {
			return getToken(SQLParser.INSERT, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<TerminalNode> SEQUENCE() { return getTokens(SQLParser.SEQUENCE); }
		public TerminalNode TEMP(int i) {
			return getToken(SQLParser.TEMP, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode TEMPORARY(int i) {
			return getToken(SQLParser.TEMPORARY, i);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public TerminalNode REFERENCES(int i) {
			return getToken(SQLParser.REFERENCES, i);
		}
		public TerminalNode SEQUENCES() { return getToken(SQLParser.SEQUENCES, 0); }
		public Grant_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grant_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGrant_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGrant_statement(this);
		}
	}

	public final Grant_statementContext grant_statement() throws RecognitionException {
		Grant_statementContext _localctx = new Grant_statementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_grant_statement);
		int _la;
		try {
			int _alt;
			setState(1862);
			switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1537); match(GRANT);
				setState(1547);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1539); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1538);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1541); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1543); match(ALL);
					setState(1545);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1544); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1549); match(ON);
				setState(1573);
				switch (_input.LA(1)) {
				case TABLE:
				case ADMIN:
				case ALWAYS:
				case AVG:
				case BETWEEN:
				case BY:
				case CACHE:
				case CALLED:
				case CLASS:
				case CENTURY:
				case CHARACTER:
				case CHECK:
				case CLUSTER:
				case COLLECT:
				case COALESCE:
				case COLUMN:
				case COMMENT:
				case COMMENTS:
				case COMMIT:
				case CONFIGURATION:
				case COST:
				case COUNT:
				case CUBE:
				case CURRENT:
				case CYCLE:
				case DATA:
				case DAY:
				case DEC:
				case DECADE:
				case DEFINER:
				case DICTIONARY:
				case DISABLE:
				case DOW:
				case DOY:
				case DROP:
				case ENABLE:
				case EPOCH:
				case EVERY:
				case EXISTS:
				case EXTENDED:
				case EXTERNAL:
				case EXTRACT:
				case FAMILY:
				case FILTER:
				case FIRST:
				case FORMAT:
				case FUSION:
				case GROUPING:
				case HASH:
				case INHERIT:
				case INDEX:
				case INCREMENT:
				case INPUT:
				case INSERT:
				case INTERSECTION:
				case ISCACHABLE:
				case ISODOW:
				case ISOYEAR:
				case ISSTRICT:
				case LANGUAGE:
				case LARGE:
				case LAST:
				case LESS:
				case LIST:
				case LOCATION:
				case MAIN:
				case MATCH:
				case MAX:
				case MAXVALUE:
				case MICROSECONDS:
				case MILLENNIUM:
				case MILLISECONDS:
				case MIN:
				case MINVALUE:
				case MINUTE:
				case MONTH:
				case NATIONAL:
				case NO:
				case NONE:
				case NULLIF:
				case OBJECT:
				case ON:
				case ONLY:
				case OPTION:
				case OPTIONS:
				case OVERWRITE:
				case PARSER:
				case PARTIAL:
				case PARTITION:
				case PARTITIONS:
				case PLAIN:
				case PRECISION:
				case PUBLIC:
				case PURGE:
				case QUARTER:
				case RANGE:
				case REGEXP:
				case RENAME:
				case REPLICA:
				case RESET:
				case RLIKE:
				case ROLLUP:
				case SEARCH:
				case SECOND:
				case SECURITY:
				case SERVER:
				case SET:
				case SIMILAR:
				case SIMPLE:
				case STABLE:
				case START:
				case STATISTICS:
				case STORAGE:
				case STDDEV_POP:
				case STDDEV_SAMP:
				case SUBPARTITION:
				case SUM:
				case TABLESPACE:
				case TEMPLATE:
				case THAN:
				case TIMEZONE:
				case TIMEZONE_HOUR:
				case TIMEZONE_MINUTE:
				case TRIM:
				case TO:
				case TYPE:
				case UNKNOWN:
				case UNLOGGED:
				case USER:
				case VALID:
				case VALIDATE:
				case VALUES:
				case VAR_SAMP:
				case VAR_POP:
				case VARYING:
				case VERSION:
				case VOLATILE:
				case WEEK:
				case WINDOW:
				case WRAPPER:
				case YEAR:
				case ZONE:
				case BOOLEAN:
				case BOOL:
				case BIT:
				case VARBIT:
				case INT1:
				case INT2:
				case INT4:
				case INT8:
				case TINYINT:
				case SMALLINT:
				case INT:
				case INTEGER:
				case BIGINT:
				case FLOAT4:
				case FLOAT8:
				case REAL:
				case FLOAT:
				case DOUBLE:
				case NUMERIC:
				case DECIMAL:
				case CHAR:
				case VARCHAR:
				case NCHAR:
				case NVARCHAR:
				case DATE:
				case TIME:
				case TIMETZ:
				case TIMESTAMP:
				case TIMESTAMPTZ:
				case TEXT:
				case UUID:
				case VARBINARY:
				case BLOB:
				case BYTEA:
				case INET4:
				case INTERVAL:
				case VOID:
				case DOUBLE_QUOTE:
				case Identifier:
				case QuotedIdentifier:
					{
					{
					setState(1551);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1550); match(TABLE);
						}
					}

					setState(1557); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1553); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
							setState(1555);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1554); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1559); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,183,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(1561); match(ALL);
					setState(1562); match(TABLES);
					setState(1563); match(IN);
					setState(1564); match(SCHEMA);
					setState(1569); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1565); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(1567);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1566); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1571); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1575); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1577); match(GRANT);
				setState(1603);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1587); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1578);
						_la = _input.LA(1);
						if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1583); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1579); ((Grant_statementContext)_localctx).column = identifier();
								setState(1581);
								_la = _input.LA(1);
								if (_la==COMMA) {
									{
									setState(1580); match(COMMA);
									}
								}

								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1585); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(1589); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1591); match(ALL);
					setState(1593);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1592); match(PRIVILEGES);
						}
					}

					setState(1599); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1595); ((Grant_statementContext)_localctx).column = identifier();
							setState(1597);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1596); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1601); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,192,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1605); match(ON);
				setState(1613); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1607);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1606); match(TABLE);
							}
						}

						setState(1609); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
						setState(1611);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1610); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1615); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,196,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1617); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1619); match(GRANT);
				setState(1632);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(1624); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1620);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1622);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1621); match(COMMA);
							}
						}

						}
						}
						setState(1626); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1628); match(ALL);
					setState(1630);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1629); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1634); match(ON);
				setState(1656);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1640); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1635); match(SEQUENCE);
						setState(1636); ((Grant_statementContext)_localctx).sequence_name = identifier();
						setState(1638);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1637); match(COMMA);
							}
						}

						}
						}
						setState(1642); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(1644); match(ALL);
					setState(1645); match(SEQUENCES);
					setState(1646); match(IN);
					setState(1647); match(SCHEMA);
					setState(1652); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1648); ((Grant_statementContext)_localctx).schema_name = identifier();
							setState(1650);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1649); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1654); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,204,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1658); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1660); match(GRANT);
				setState(1673);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1665); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1661);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1663);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1662); match(COMMA);
							}
						}

						}
						}
						setState(1667); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(1669); match(ALL);
					setState(1671);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1670); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1675); match(ON);
				setState(1676); match(DATABASE);
				setState(1681); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1677); ((Grant_statementContext)_localctx).database_name = identifier();
						setState(1679);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1678); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1683); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,211,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1685); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1687); match(GRANT);
				setState(1693);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1688); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1689); match(ALL);
					setState(1691);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1690); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1695); match(ON);
				setState(1696); match(FOREIGN);
				setState(1697); match(DATA);
				setState(1698); match(WRAPPER);
				setState(1703); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1699); ((Grant_statementContext)_localctx).fdw_name = identifier();
						setState(1701);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1700); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1705); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1707); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1709); match(GRANT);
				setState(1715);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1710); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1711); match(ALL);
					setState(1713);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1712); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1717); match(ON);
				setState(1718); match(FOREIGN);
				setState(1719); match(SERVER);
				setState(1724); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1720); ((Grant_statementContext)_localctx).server_name = identifier();
						setState(1722);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1721); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1726); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,219,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1728); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1730); match(GRANT);
				setState(1736);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1731); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1732); match(ALL);
					setState(1734);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1733); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1738); match(ON);
				setState(1741);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1739); function_definition();
					}
					break;
				case ALL:
					{
					setState(1740); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1743); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1745); match(GRANT);
				setState(1751);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1746); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1747); match(ALL);
					setState(1749);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1748); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1753); match(ON);
				setState(1754); match(LANGUAGE);
				setState(1759); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1755); ((Grant_statementContext)_localctx).lang_name = identifier();
						setState(1757);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1756); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1761); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,226,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1763); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1765); match(GRANT);
				setState(1778);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1770); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1766);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1768);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1767); match(COMMA);
							}
						}

						}
						}
						setState(1772); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1774); match(ALL);
					setState(1776);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1775); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1780); match(ON);
				setState(1781); match(LARGE);
				setState(1782); match(OBJECT);
				setState(1787); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1783); ((Grant_statementContext)_localctx).loid = identifier();
						setState(1785);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1784); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1789); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,232,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1791); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1793); match(GRANT);
				setState(1806);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1798); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1794);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1796);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1795); match(COMMA);
							}
						}

						}
						}
						setState(1800); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1802); match(ALL);
					setState(1804);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1803); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1808); match(ON);
				setState(1809); match(SCHEMA);
				setState(1814); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1810); ((Grant_statementContext)_localctx).schema_name = identifier();
						setState(1812);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1811); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1816); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,238,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1818); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1820); match(GRANT);
				setState(1826);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1821); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1822); match(ALL);
					setState(1824);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1823); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1828); match(ON);
				setState(1829); match(TABLESPACE);
				setState(1834); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1830); ((Grant_statementContext)_localctx).tablespace_name = identifier();
						setState(1832);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1831); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1836); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,242,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1838); grant_to_rule();
				setState(1839); match(GRANT);
				setState(1844); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1840); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1842);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1841); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1846); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,244,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1848); match(TO);
				setState(1853); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1849); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1851);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1850); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1855); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,246,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1860);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1857); match(WITH);
					setState(1858); match(ADMIN);
					setState(1859); match(OPTION);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Grant_to_ruleContext extends ParserRuleContext {
		public IdentifierContext role_name;
		public List<TerminalNode> PUBLIC() { return getTokens(SQLParser.PUBLIC); }
		public TerminalNode GROUP(int i) {
			return getToken(SQLParser.GROUP, i);
		}
		public TerminalNode PUBLIC(int i) {
			return getToken(SQLParser.PUBLIC, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode GRANT() { return getToken(SQLParser.GRANT, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OPTION() { return getToken(SQLParser.OPTION, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<TerminalNode> GROUP() { return getTokens(SQLParser.GROUP); }
		public Grant_to_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grant_to_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGrant_to_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGrant_to_rule(this);
		}
	}

	public final Grant_to_ruleContext grant_to_rule() throws RecognitionException {
		Grant_to_ruleContext _localctx = new Grant_to_ruleContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_grant_to_rule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1864); match(TO);
			setState(1875); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1866);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1865); match(GROUP);
						}
					}

					setState(1870);
					switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
					case 1:
						{
						{
						setState(1868); ((Grant_to_ruleContext)_localctx).role_name = identifier();
						}
						}
						break;
					case 2:
						{
						setState(1869); match(PUBLIC);
						}
						break;
					}
					setState(1873);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1872); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1877); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,252,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1882);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1879); match(WITH);
				setState(1880); match(GRANT);
				setState(1881); match(OPTION);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comment_on_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext agg_name;
		public Data_typeContext agg_type;
		public Data_typeContext source_type;
		public Data_typeContext target_type;
		public Schema_qualified_nameContext object_name;
		public Schema_qualified_nameContext column_name;
		public Schema_qualified_nameContext constraint_name;
		public Schema_qualified_nameContext table_name;
		public IdentifierContext large_object_oid;
		public Schema_qualified_nameContext operator_name;
		public Data_typeContext left_type;
		public Data_typeContext right_type;
		public IdentifierContext index_method;
		public Schema_qualified_nameContext rule_name;
		public Schema_qualified_nameContext trigger_name;
		public TerminalNode VIEW() { return getToken(SQLParser.VIEW, 0); }
		public TerminalNode EXTENSION() { return getToken(SQLParser.EXTENSION, 0); }
		public TerminalNode IS() { return getToken(SQLParser.IS, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public TerminalNode CONVERSION() { return getToken(SQLParser.CONVERSION, 0); }
		public TerminalNode WRAPPER() { return getToken(SQLParser.WRAPPER, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode TYPE() { return getToken(SQLParser.TYPE, 0); }
		public TerminalNode OPERATOR() { return getToken(SQLParser.OPERATOR, 0); }
		public TerminalNode ON(int i) {
			return getToken(SQLParser.ON, i);
		}
		public TerminalNode CONFIGURATION() { return getToken(SQLParser.CONFIGURATION, 0); }
		public TerminalNode SEARCH() { return getToken(SQLParser.SEARCH, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TerminalNode RULE() { return getToken(SQLParser.RULE, 0); }
		public TerminalNode TRIGGER() { return getToken(SQLParser.TRIGGER, 0); }
		public TerminalNode DOMAIN() { return getToken(SQLParser.DOMAIN, 0); }
		public TerminalNode DATA() { return getToken(SQLParser.DATA, 0); }
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public TerminalNode DICTIONARY() { return getToken(SQLParser.DICTIONARY, 0); }
		public Data_typeContext data_type(int i) {
			return getRuleContext(Data_typeContext.class,i);
		}
		public TerminalNode AGGREGATE() { return getToken(SQLParser.AGGREGATE, 0); }
		public TerminalNode ROLE() { return getToken(SQLParser.ROLE, 0); }
		public TerminalNode FOREIGN() { return getToken(SQLParser.FOREIGN, 0); }
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public TerminalNode OBJECT() { return getToken(SQLParser.OBJECT, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public TerminalNode TEMPLATE() { return getToken(SQLParser.TEMPLATE, 0); }
		public TerminalNode CLASS() { return getToken(SQLParser.CLASS, 0); }
		public List<TerminalNode> ON() { return getTokens(SQLParser.ON); }
		public TerminalNode COLLATION() { return getToken(SQLParser.COLLATION, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode SERVER() { return getToken(SQLParser.SERVER, 0); }
		public TerminalNode COMMENT() { return getToken(SQLParser.COMMENT, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LANGUAGE() { return getToken(SQLParser.LANGUAGE, 0); }
		public List<Data_typeContext> data_type() {
			return getRuleContexts(Data_typeContext.class);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CAST() { return getToken(SQLParser.CAST, 0); }
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public TerminalNode LARGE() { return getToken(SQLParser.LARGE, 0); }
		public TerminalNode PROCEDURAL() { return getToken(SQLParser.PROCEDURAL, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode SEQUENCE() { return getToken(SQLParser.SEQUENCE, 0); }
		public TerminalNode PARSER() { return getToken(SQLParser.PARSER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode FAMILY() { return getToken(SQLParser.FAMILY, 0); }
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public Comment_on_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment_on_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterComment_on_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitComment_on_statement(this);
		}
	}

	public final Comment_on_statementContext comment_on_statement() throws RecognitionException {
		Comment_on_statementContext _localctx = new Comment_on_statementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_comment_on_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1884); match(COMMENT);
			setState(1885); match(ON);
			setState(2004);
			switch ( getInterpreter().adaptivePredict(_input,257,_ctx) ) {
			case 1:
				{
				setState(1886); match(AGGREGATE);
				setState(1887); ((Comment_on_statementContext)_localctx).agg_name = schema_qualified_name();
				setState(1888); match(LEFT_PAREN);
				setState(1895);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & ((1L << (SETOF - 109)) | (1L << (TRIGGER - 109)) | (1L << (CHARACTER - 109)) | (1L << (DEC - 109)))) != 0) || _la==NATIONAL || ((((_la - 281)) & ~0x3f) == 0 && ((1L << (_la - 281)) & ((1L << (BOOLEAN - 281)) | (1L << (BOOL - 281)) | (1L << (BIT - 281)) | (1L << (VARBIT - 281)) | (1L << (INT1 - 281)) | (1L << (INT2 - 281)) | (1L << (INT4 - 281)) | (1L << (INT8 - 281)) | (1L << (TINYINT - 281)) | (1L << (SMALLINT - 281)) | (1L << (INT - 281)) | (1L << (INTEGER - 281)) | (1L << (BIGINT - 281)) | (1L << (FLOAT4 - 281)) | (1L << (FLOAT8 - 281)) | (1L << (REAL - 281)) | (1L << (REGCLASS - 281)) | (1L << (FLOAT - 281)) | (1L << (DOUBLE - 281)) | (1L << (NUMERIC - 281)) | (1L << (DECIMAL - 281)) | (1L << (CHAR - 281)) | (1L << (VARCHAR - 281)) | (1L << (NCHAR - 281)) | (1L << (NVARCHAR - 281)) | (1L << (DATE - 281)) | (1L << (TIME - 281)) | (1L << (TIMETZ - 281)) | (1L << (TIMESTAMP - 281)) | (1L << (TIMESTAMPTZ - 281)) | (1L << (TEXT - 281)) | (1L << (UUID - 281)) | (1L << (BINARY - 281)) | (1L << (VARBINARY - 281)) | (1L << (BLOB - 281)) | (1L << (BYTEA - 281)) | (1L << (INET4 - 281)) | (1L << (INTERVAL - 281)) | (1L << (VOID - 281)))) != 0)) {
					{
					{
					setState(1889); ((Comment_on_statementContext)_localctx).agg_type = data_type();
					setState(1891);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1890); match(COMMA);
						}
					}

					}
					}
					setState(1897);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1898); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1900); match(CAST);
				setState(1901); match(LEFT_PAREN);
				setState(1902); ((Comment_on_statementContext)_localctx).source_type = data_type();
				setState(1903); match(AS);
				setState(1904); ((Comment_on_statementContext)_localctx).target_type = data_type();
				setState(1905); match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(1907); match(COLLATION);
				setState(1908); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 4:
				{
				setState(1909); match(COLUMN);
				setState(1910); ((Comment_on_statementContext)_localctx).column_name = schema_qualified_name();
				}
				break;
			case 5:
				{
				setState(1911); match(CONSTRAINT);
				setState(1912); ((Comment_on_statementContext)_localctx).constraint_name = schema_qualified_name();
				setState(1913); match(ON);
				setState(1914); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 6:
				{
				setState(1916); match(CONVERSION);
				setState(1917); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 7:
				{
				setState(1918); match(DATABASE);
				setState(1919); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 8:
				{
				setState(1920); match(DOMAIN);
				setState(1921); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 9:
				{
				setState(1922); match(EXTENSION);
				setState(1923); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 10:
				{
				setState(1924); match(FOREIGN);
				setState(1925); match(DATA);
				setState(1926); match(WRAPPER);
				setState(1927); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 11:
				{
				setState(1928); match(FOREIGN);
				setState(1929); match(TABLE);
				setState(1930); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 12:
				{
				setState(1931); function_definition();
				}
				break;
			case 13:
				{
				setState(1932); match(INDEX);
				setState(1933); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 14:
				{
				setState(1934); match(LARGE);
				setState(1935); match(OBJECT);
				setState(1936); ((Comment_on_statementContext)_localctx).large_object_oid = identifier();
				}
				break;
			case 15:
				{
				setState(1937); match(OPERATOR);
				setState(1938); ((Comment_on_statementContext)_localctx).operator_name = schema_qualified_name();
				setState(1939); match(LEFT_PAREN);
				setState(1940); ((Comment_on_statementContext)_localctx).left_type = data_type();
				setState(1941); match(COMMA);
				setState(1942); ((Comment_on_statementContext)_localctx).right_type = data_type();
				setState(1943); match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(1945); match(OPERATOR);
				setState(1946); match(CLASS);
				setState(1947); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1948); match(USING);
				setState(1949); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 17:
				{
				setState(1951); match(OPERATOR);
				setState(1952); match(FAMILY);
				setState(1953); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1954); match(USING);
				setState(1955); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 18:
				{
				setState(1958);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1957); match(PROCEDURAL);
					}
				}

				setState(1960); match(LANGUAGE);
				setState(1961); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 19:
				{
				setState(1962); match(ROLE);
				setState(1963); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 20:
				{
				setState(1964); match(RULE);
				setState(1965); ((Comment_on_statementContext)_localctx).rule_name = schema_qualified_name();
				setState(1966); match(ON);
				setState(1967); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 21:
				{
				setState(1969); match(SCHEMA);
				setState(1970); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 22:
				{
				setState(1971); match(SEQUENCE);
				setState(1972); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 23:
				{
				setState(1973); match(SERVER);
				setState(1974); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 24:
				{
				setState(1975); match(TABLE);
				setState(1976); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 25:
				{
				setState(1977); match(TABLESPACE);
				setState(1978); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 26:
				{
				setState(1979); match(TEXT);
				setState(1980); match(SEARCH);
				setState(1981); match(CONFIGURATION);
				setState(1982); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 27:
				{
				setState(1983); match(TEXT);
				setState(1984); match(SEARCH);
				setState(1985); match(DICTIONARY);
				setState(1986); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 28:
				{
				setState(1987); match(TEXT);
				setState(1988); match(SEARCH);
				setState(1989); match(PARSER);
				setState(1990); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 29:
				{
				setState(1991); match(TEXT);
				setState(1992); match(SEARCH);
				setState(1993); match(TEMPLATE);
				setState(1994); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 30:
				{
				setState(1995); match(TRIGGER);
				setState(1996); ((Comment_on_statementContext)_localctx).trigger_name = schema_qualified_name();
				setState(1997); match(ON);
				setState(1998); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 31:
				{
				setState(2000); match(TYPE);
				setState(2001); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 32:
				{
				setState(2002); match(VIEW);
				setState(2003); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			}
			setState(2006); match(IS);
			setState(2007); match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_function_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public Value_expressionContext rettype;
		public Data_typeContext rettype_data;
		public IdentifierContext column_name;
		public Data_typeContext column_type;
		public IdentifierContext lang_name;
		public Token execution_cost;
		public Token result_rows;
		public IdentifierContext configuration_parameter;
		public IdentifierContext value;
		public Function_attributeContext attribute;
		public TerminalNode VOLATILE(int i) {
			return getToken(SQLParser.VOLATILE, i);
		}
		public TerminalNode TO(int i) {
			return getToken(SQLParser.TO, i);
		}
		public List<Function_bodyContext> function_body() {
			return getRuleContexts(Function_bodyContext.class);
		}
		public List<TerminalNode> Character_String_Literal() { return getTokens(SQLParser.Character_String_Literal); }
		public TerminalNode AS(int i) {
			return getToken(SQLParser.AS, i);
		}
		public TerminalNode SET(int i) {
			return getToken(SQLParser.SET, i);
		}
		public TerminalNode EQUAL(int i) {
			return getToken(SQLParser.EQUAL, i);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public TerminalNode STABLE(int i) {
			return getToken(SQLParser.STABLE, i);
		}
		public List<TerminalNode> COST() { return getTokens(SQLParser.COST); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public List<TerminalNode> TO() { return getTokens(SQLParser.TO); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode ROWS(int i) {
			return getToken(SQLParser.ROWS, i);
		}
		public List<TerminalNode> INVOKER() { return getTokens(SQLParser.INVOKER); }
		public List<TerminalNode> WINDOW() { return getTokens(SQLParser.WINDOW); }
		public TerminalNode CURRENT(int i) {
			return getToken(SQLParser.CURRENT, i);
		}
		public TerminalNode NULL(int i) {
			return getToken(SQLParser.NULL, i);
		}
		public TerminalNode ON(int i) {
			return getToken(SQLParser.ON, i);
		}
		public TerminalNode OR() { return getToken(SQLParser.OR, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public List<TerminalNode> CURRENT() { return getTokens(SQLParser.CURRENT); }
		public List<TerminalNode> EQUAL() { return getTokens(SQLParser.EQUAL); }
		public TerminalNode RETURNS(int i) {
			return getToken(SQLParser.RETURNS, i);
		}
		public List<TerminalNode> EXTERNAL() { return getTokens(SQLParser.EXTERNAL); }
		public TerminalNode INPUT(int i) {
			return getToken(SQLParser.INPUT, i);
		}
		public TerminalNode CALLED(int i) {
			return getToken(SQLParser.CALLED, i);
		}
		public TerminalNode INVOKER(int i) {
			return getToken(SQLParser.INVOKER, i);
		}
		public Data_typeContext data_type(int i) {
			return getRuleContext(Data_typeContext.class,i);
		}
		public List<TerminalNode> NULL() { return getTokens(SQLParser.NULL); }
		public TerminalNode LANGUAGE(int i) {
			return getToken(SQLParser.LANGUAGE, i);
		}
		public List<TerminalNode> SET() { return getTokens(SQLParser.SET); }
		public List<TerminalNode> AS() { return getTokens(SQLParser.AS); }
		public Function_attributeContext function_attribute(int i) {
			return getRuleContext(Function_attributeContext.class,i);
		}
		public TerminalNode IMMUTABLE(int i) {
			return getToken(SQLParser.IMMUTABLE, i);
		}
		public List<TerminalNode> INPUT() { return getTokens(SQLParser.INPUT); }
		public List<TerminalNode> VOLATILE() { return getTokens(SQLParser.VOLATILE); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public List<TerminalNode> ON() { return getTokens(SQLParser.ON); }
		public TerminalNode Character_String_Literal(int i) {
			return getToken(SQLParser.Character_String_Literal, i);
		}
		public List<TerminalNode> STABLE() { return getTokens(SQLParser.STABLE); }
		public TerminalNode COST(int i) {
			return getToken(SQLParser.COST, i);
		}
		public List<TerminalNode> STRICT() { return getTokens(SQLParser.STRICT); }
		public List<TerminalNode> CALLED() { return getTokens(SQLParser.CALLED); }
		public List<TerminalNode> NUMBER() { return getTokens(SQLParser.NUMBER); }
		public List<TerminalNode> IMMUTABLE() { return getTokens(SQLParser.IMMUTABLE); }
		public List<TerminalNode> LANGUAGE() { return getTokens(SQLParser.LANGUAGE); }
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<Data_typeContext> data_type() {
			return getRuleContexts(Data_typeContext.class);
		}
		public List<TerminalNode> FROM() { return getTokens(SQLParser.FROM); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public List<TerminalNode> DEFINER() { return getTokens(SQLParser.DEFINER); }
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode STRICT(int i) {
			return getToken(SQLParser.STRICT, i);
		}
		public TerminalNode SECURITY(int i) {
			return getToken(SQLParser.SECURITY, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode FROM(int i) {
			return getToken(SQLParser.FROM, i);
		}
		public List<Function_attributeContext> function_attribute() {
			return getRuleContexts(Function_attributeContext.class);
		}
		public List<TerminalNode> ROWS() { return getTokens(SQLParser.ROWS); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
		public List<TerminalNode> SECURITY() { return getTokens(SQLParser.SECURITY); }
		public TerminalNode NUMBER(int i) {
			return getToken(SQLParser.NUMBER, i);
		}
		public TerminalNode REPLACE() { return getToken(SQLParser.REPLACE, 0); }
		public List<TerminalNode> RETURNS() { return getTokens(SQLParser.RETURNS); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode WINDOW(int i) {
			return getToken(SQLParser.WINDOW, i);
		}
		public TerminalNode EXTERNAL(int i) {
			return getToken(SQLParser.EXTERNAL, i);
		}
		public Function_bodyContext function_body(int i) {
			return getRuleContext(Function_bodyContext.class,i);
		}
		public TerminalNode DEFINER(int i) {
			return getToken(SQLParser.DEFINER, i);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Create_function_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_function_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCreate_function_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCreate_function_statement(this);
		}
	}

	public final Create_function_statementContext create_function_statement() throws RecognitionException {
		Create_function_statementContext _localctx = new Create_function_statementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_create_function_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2009); match(CREATE);
			setState(2012);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(2010); match(OR);
				setState(2011); match(REPLACE);
				}
			}

			setState(2014); match(FUNCTION);
			setState(2015); ((Create_function_statementContext)_localctx).name = schema_qualified_name();
			setState(2016); function_parameters();
			setState(2036);
			switch ( getInterpreter().adaptivePredict(_input,262,_ctx) ) {
			case 1:
				{
				setState(2017); match(RETURNS);
				setState(2020);
				switch ( getInterpreter().adaptivePredict(_input,259,_ctx) ) {
				case 1:
					{
					setState(2018); ((Create_function_statementContext)_localctx).rettype = value_expression();
					}
					break;
				case 2:
					{
					setState(2019); ((Create_function_statementContext)_localctx).rettype_data = data_type();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(2022); match(RETURNS);
				setState(2023); match(TABLE);
				setState(2024); match(LEFT_PAREN);
				setState(2030); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2025); ((Create_function_statementContext)_localctx).column_name = identifier();
					setState(2026); ((Create_function_statementContext)_localctx).column_type = data_type();
					setState(2028);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2027); match(COMMA);
						}
					}

					}
					}
					setState(2032); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(2034); match(RIGHT_PAREN);
				}
				break;
			}
			setState(2091); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(2091);
					switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
					case 1:
						{
						setState(2038); match(LANGUAGE);
						setState(2039); ((Create_function_statementContext)_localctx).lang_name = identifier();
						}
						break;
					case 2:
						{
						setState(2040); match(WINDOW);
						}
						break;
					case 3:
						{
						setState(2041); match(IMMUTABLE);
						}
						break;
					case 4:
						{
						setState(2042); match(STABLE);
						}
						break;
					case 5:
						{
						setState(2043); match(VOLATILE);
						}
						break;
					case 6:
						{
						setState(2044); match(CALLED);
						setState(2045); match(ON);
						setState(2046); match(NULL);
						setState(2047); match(INPUT);
						}
						break;
					case 7:
						{
						setState(2048); match(RETURNS);
						setState(2049); match(NULL);
						setState(2050); match(ON);
						setState(2051); match(NULL);
						setState(2052); match(INPUT);
						}
						break;
					case 8:
						{
						setState(2053); match(STRICT);
						}
						break;
					case 9:
						{
						setState(2055);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(2054); match(EXTERNAL);
							}
						}

						setState(2057); match(SECURITY);
						setState(2058); match(INVOKER);
						}
						break;
					case 10:
						{
						setState(2060);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(2059); match(EXTERNAL);
							}
						}

						setState(2062); match(SECURITY);
						setState(2063); match(DEFINER);
						}
						break;
					case 11:
						{
						setState(2064); match(COST);
						setState(2065); ((Create_function_statementContext)_localctx).execution_cost = match(NUMBER);
						}
						break;
					case 12:
						{
						setState(2066); match(ROWS);
						setState(2067); ((Create_function_statementContext)_localctx).result_rows = match(NUMBER);
						}
						break;
					case 13:
						{
						setState(2068); match(SET);
						setState(2069); ((Create_function_statementContext)_localctx).configuration_parameter = identifier();
						setState(2076);
						switch (_input.LA(1)) {
						case TO:
							{
							setState(2070); match(TO);
							setState(2071); ((Create_function_statementContext)_localctx).value = identifier();
							}
							break;
						case EQUAL:
							{
							setState(2072); match(EQUAL);
							setState(2073); ((Create_function_statementContext)_localctx).value = identifier();
							}
							break;
						case FROM:
							{
							setState(2074); match(FROM);
							setState(2075); match(CURRENT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(2082);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(2078); match(COMMA);
							setState(2079); ((Create_function_statementContext)_localctx).value = identifier();
							}
							}
							setState(2084);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case 14:
						{
						setState(2085); match(AS);
						setState(2086); function_body();
						}
						break;
					case 15:
						{
						setState(2087); match(AS);
						setState(2088); match(Character_String_Literal);
						setState(2089); match(COMMA);
						setState(2090); match(Character_String_Literal);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2093); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,268,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(2107);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2095); match(WITH);
				setState(2096); match(LEFT_PAREN);
				setState(2101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2097); ((Create_function_statementContext)_localctx).attribute = function_attribute();
					setState(2099);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2098); match(COMMA);
						}
					}

					}
					}
					setState(2103); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ISCACHABLE || _la==ISSTRICT );
				setState(2105); match(RIGHT_PAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_parametersContext extends ParserRuleContext {
		public ArgmodeContext arg_mode;
		public IdentifierContext argname;
		public Data_typeContext argtype;
		public IdentifierContext argtype_string;
		public Value_expressionContext def_value;
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public List<TerminalNode> EQUAL() { return getTokens(SQLParser.EQUAL); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public ArgmodeContext argmode(int i) {
			return getRuleContext(ArgmodeContext.class,i);
		}
		public List<TerminalNode> DEFAULT() { return getTokens(SQLParser.DEFAULT); }
		public TerminalNode DEFAULT(int i) {
			return getToken(SQLParser.DEFAULT, i);
		}
		public TerminalNode EQUAL(int i) {
			return getToken(SQLParser.EQUAL, i);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Data_typeContext data_type(int i) {
			return getRuleContext(Data_typeContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<ArgmodeContext> argmode() {
			return getRuleContexts(ArgmodeContext.class);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public List<Data_typeContext> data_type() {
			return getRuleContexts(Data_typeContext.class);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Function_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_parameters(this);
		}
	}

	public final Function_parametersContext function_parameters() throws RecognitionException {
		Function_parametersContext _localctx = new Function_parametersContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_function_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2109); match(LEFT_PAREN);
			setState(2135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & ((1L << (IN - 58)) | (1L << (INOUT - 58)) | (1L << (OUT - 58)) | (1L << (SETOF - 58)) | (1L << (TRIGGER - 58)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (VARIADIC - 129)) | (1L << (ADMIN - 129)) | (1L << (ALWAYS - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (CLUSTER - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DISABLE - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (ENABLE - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTENDED - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INHERIT - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (ISOYEAR - 193)) | (1L << (ISSTRICT - 193)) | (1L << (LANGUAGE - 193)) | (1L << (LARGE - 193)) | (1L << (LAST - 193)) | (1L << (LESS - 193)) | (1L << (LIST - 193)) | (1L << (LOCATION - 193)) | (1L << (MAIN - 193)) | (1L << (MATCH - 193)) | (1L << (MAX - 193)) | (1L << (MAXVALUE - 193)) | (1L << (MICROSECONDS - 193)) | (1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (ON - 193)) | (1L << (ONLY - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PLAIN - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RENAME - 193)) | (1L << (REPLICA - 193)) | (1L << (RESET - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STATISTICS - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (TEMPLATE - 257)) | (1L << (THAN - 257)) | (1L << (TIMEZONE - 257)) | (1L << (TIMEZONE_HOUR - 257)) | (1L << (TIMEZONE_MINUTE - 257)) | (1L << (TRIM - 257)) | (1L << (TO - 257)) | (1L << (TYPE - 257)) | (1L << (UNKNOWN - 257)) | (1L << (UNLOGGED - 257)) | (1L << (USER - 257)) | (1L << (VALID - 257)) | (1L << (VALIDATE - 257)) | (1L << (VALUES - 257)) | (1L << (VAR_SAMP - 257)) | (1L << (VAR_POP - 257)) | (1L << (VARYING - 257)) | (1L << (VERSION - 257)) | (1L << (VOLATILE - 257)) | (1L << (WEEK - 257)) | (1L << (WINDOW - 257)) | (1L << (WRAPPER - 257)) | (1L << (YEAR - 257)) | (1L << (ZONE - 257)) | (1L << (BOOLEAN - 257)) | (1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (REGCLASS - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (BINARY - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (INTERVAL - 257)) | (1L << (VOID - 257)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0)) {
				{
				{
				setState(2111);
				_la = _input.LA(1);
				if (_la==IN || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INOUT - 66)) | (1L << (OUT - 66)) | (1L << (VARIADIC - 66)))) != 0)) {
					{
					setState(2110); ((Function_parametersContext)_localctx).arg_mode = argmode();
					}
				}

				setState(2114);
				switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
				case 1:
					{
					setState(2113); ((Function_parametersContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(2118);
				switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
				case 1:
					{
					setState(2116); ((Function_parametersContext)_localctx).argtype = data_type();
					}
					break;
				case 2:
					{
					setState(2117); ((Function_parametersContext)_localctx).argtype_string = identifier();
					}
					break;
				}
				setState(2128);
				_la = _input.LA(1);
				if (_la==DEFAULT || _la==EQUAL) {
					{
					setState(2120);
					_la = _input.LA(1);
					if ( !(_la==DEFAULT || _la==EQUAL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(2122);
					switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
					case 1:
						{
						setState(2121); match(LEFT_PAREN);
						}
						break;
					}
					setState(2124); ((Function_parametersContext)_localctx).def_value = value_expression();
					setState(2126);
					_la = _input.LA(1);
					if (_la==LEFT_PAREN) {
						{
						setState(2125); match(LEFT_PAREN);
						}
					}

					}
				}

				setState(2131);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2130); match(COMMA);
					}
				}

				}
				}
				setState(2137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2138); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_bodyContext extends ParserRuleContext {
		public Function_body_separatorContext function_body_separator() {
			return getRuleContext(Function_body_separatorContext.class,0);
		}
		public Function_body_separator_dollar_underContext function_body_separator_dollar_under() {
			return getRuleContext(Function_body_separator_dollar_underContext.class,0);
		}
		public Function_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_body(this);
		}
	}

	public final Function_bodyContext function_body() throws RecognitionException {
		Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_function_body);
		try {
			setState(2142);
			switch (_input.LA(1)) {
			case DOUBLE_DOLLAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2140); function_body_separator();
				}
				break;
			case DOUBLE_UNDER_DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2141); function_body_separator_dollar_under();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_body_separatorContext extends ParserRuleContext {
		public List<TerminalNode> DOUBLE_DOLLAR() { return getTokens(SQLParser.DOUBLE_DOLLAR); }
		public TerminalNode DOUBLE_DOLLAR(int i) {
			return getToken(SQLParser.DOUBLE_DOLLAR, i);
		}
		public Function_body_separatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body_separator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_body_separator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_body_separator(this);
		}
	}

	public final Function_body_separatorContext function_body_separator() throws RecognitionException {
		Function_body_separatorContext _localctx = new Function_body_separatorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_function_body_separator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2144); match(DOUBLE_DOLLAR);
			setState(2148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << ALTER) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << HANDLER) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INLINE) | (1L << INNER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTERSECT - 64)) | (1L << (INTO - 64)) | (1L << (INOUT - 64)) | (1L << (INSTEAD - 64)) | (1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (OWNER - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRUSTED - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (VALIDATOR - 128)) | (1L << (VARIADIC - 128)) | (1L << (VIEW - 128)) | (1L << (WHEN - 128)) | (1L << (WHERE - 128)) | (1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (ALWAYS - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (CLUSTER - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DISABLE - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (ENABLE - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTENDED - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INHERIT - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (ISODOW - 192)) | (1L << (ISOYEAR - 192)) | (1L << (ISSTRICT - 192)) | (1L << (LANGUAGE - 192)) | (1L << (LARGE - 192)) | (1L << (LAST - 192)) | (1L << (LESS - 192)) | (1L << (LIST - 192)) | (1L << (LOCATION - 192)) | (1L << (MAIN - 192)) | (1L << (MATCH - 192)) | (1L << (MAX - 192)) | (1L << (MAXVALUE - 192)) | (1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (N_DISTINCT - 192)) | (1L << (N_DISTINCT_INHERITED - 192)) | (1L << (OBJECT - 192)) | (1L << (ON - 192)) | (1L << (ONLY - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PLAIN - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RENAME - 192)) | (1L << (REPLICA - 192)) | (1L << (RESET - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STATISTICS - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (TABLES - 256)) | (1L << (TEMPLATE - 256)) | (1L << (THAN - 256)) | (1L << (TIMEZONE - 256)) | (1L << (TIMEZONE_HOUR - 256)) | (1L << (TIMEZONE_MINUTE - 256)) | (1L << (TRIM - 256)) | (1L << (TO - 256)) | (1L << (TYPE - 256)) | (1L << (UNKNOWN - 256)) | (1L << (UNLOGGED - 256)) | (1L << (USER - 256)) | (1L << (VALID - 256)) | (1L << (VALIDATE - 256)) | (1L << (VALUES - 256)) | (1L << (VAR_SAMP - 256)) | (1L << (VAR_POP - 256)) | (1L << (VARYING - 256)) | (1L << (VERSION - 256)) | (1L << (VOLATILE - 256)) | (1L << (WEEK - 256)) | (1L << (WINDOW - 256)) | (1L << (WRAPPER - 256)) | (1L << (YEAR - 256)) | (1L << (ZONE - 256)) | (1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (INTERVAL - 256)) | (1L << (VOID - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (Similar_To - 320)) | (1L << (Not_Similar_To - 320)) | (1L << (Similar_To_Case_Insensitive - 320)) | (1L << (Not_Similar_To_Case_Insensitive - 320)) | (1L << (CAST_EXPRESSION - 320)) | (1L << (ASSIGN - 320)) | (1L << (EQUAL - 320)) | (1L << (COLON - 320)) | (1L << (SEMI_COLON - 320)) | (1L << (COMMA - 320)) | (1L << (CONCATENATION_OPERATOR - 320)) | (1L << (NOT_EQUAL - 320)) | (1L << (LTH - 320)) | (1L << (LEQ - 320)) | (1L << (GTH - 320)) | (1L << (GEQ - 320)) | (1L << (LEFT_PAREN - 320)) | (1L << (RIGHT_PAREN - 320)) | (1L << (PLUS - 320)) | (1L << (MINUS - 320)) | (1L << (MULTIPLY - 320)) | (1L << (DIVIDE - 320)) | (1L << (MODULAR - 320)) | (1L << (DOT - 320)) | (1L << (UNDERLINE - 320)) | (1L << (VERTICAL_BAR - 320)) | (1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (DOUBLE_UNDER_DOLLAR - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (QuotedIdentifier - 320)) | (1L << (UnterminatedQuotedIdentifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)))) != 0)) {
				{
				{
				setState(2145);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==DOUBLE_DOLLAR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(2150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2151); match(DOUBLE_DOLLAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_body_separator_dollar_underContext extends ParserRuleContext {
		public TerminalNode DOUBLE_UNDER_DOLLAR(int i) {
			return getToken(SQLParser.DOUBLE_UNDER_DOLLAR, i);
		}
		public List<TerminalNode> DOUBLE_UNDER_DOLLAR() { return getTokens(SQLParser.DOUBLE_UNDER_DOLLAR); }
		public Function_body_separator_dollar_underContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body_separator_dollar_under; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_body_separator_dollar_under(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_body_separator_dollar_under(this);
		}
	}

	public final Function_body_separator_dollar_underContext function_body_separator_dollar_under() throws RecognitionException {
		Function_body_separator_dollar_underContext _localctx = new Function_body_separator_dollar_underContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_function_body_separator_dollar_under);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2153); match(DOUBLE_UNDER_DOLLAR);
			setState(2157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << ALTER) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << HANDLER) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INLINE) | (1L << INNER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTERSECT - 64)) | (1L << (INTO - 64)) | (1L << (INOUT - 64)) | (1L << (INSTEAD - 64)) | (1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (OWNER - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRUSTED - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (VALIDATOR - 128)) | (1L << (VARIADIC - 128)) | (1L << (VIEW - 128)) | (1L << (WHEN - 128)) | (1L << (WHERE - 128)) | (1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (ALWAYS - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (CLUSTER - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DISABLE - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (ENABLE - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTENDED - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INHERIT - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (ISODOW - 192)) | (1L << (ISOYEAR - 192)) | (1L << (ISSTRICT - 192)) | (1L << (LANGUAGE - 192)) | (1L << (LARGE - 192)) | (1L << (LAST - 192)) | (1L << (LESS - 192)) | (1L << (LIST - 192)) | (1L << (LOCATION - 192)) | (1L << (MAIN - 192)) | (1L << (MATCH - 192)) | (1L << (MAX - 192)) | (1L << (MAXVALUE - 192)) | (1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (N_DISTINCT - 192)) | (1L << (N_DISTINCT_INHERITED - 192)) | (1L << (OBJECT - 192)) | (1L << (ON - 192)) | (1L << (ONLY - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PLAIN - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RENAME - 192)) | (1L << (REPLICA - 192)) | (1L << (RESET - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STATISTICS - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (TABLES - 256)) | (1L << (TEMPLATE - 256)) | (1L << (THAN - 256)) | (1L << (TIMEZONE - 256)) | (1L << (TIMEZONE_HOUR - 256)) | (1L << (TIMEZONE_MINUTE - 256)) | (1L << (TRIM - 256)) | (1L << (TO - 256)) | (1L << (TYPE - 256)) | (1L << (UNKNOWN - 256)) | (1L << (UNLOGGED - 256)) | (1L << (USER - 256)) | (1L << (VALID - 256)) | (1L << (VALIDATE - 256)) | (1L << (VALUES - 256)) | (1L << (VAR_SAMP - 256)) | (1L << (VAR_POP - 256)) | (1L << (VARYING - 256)) | (1L << (VERSION - 256)) | (1L << (VOLATILE - 256)) | (1L << (WEEK - 256)) | (1L << (WINDOW - 256)) | (1L << (WRAPPER - 256)) | (1L << (YEAR - 256)) | (1L << (ZONE - 256)) | (1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (INTERVAL - 256)) | (1L << (VOID - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (Similar_To - 320)) | (1L << (Not_Similar_To - 320)) | (1L << (Similar_To_Case_Insensitive - 320)) | (1L << (Not_Similar_To_Case_Insensitive - 320)) | (1L << (CAST_EXPRESSION - 320)) | (1L << (ASSIGN - 320)) | (1L << (EQUAL - 320)) | (1L << (COLON - 320)) | (1L << (SEMI_COLON - 320)) | (1L << (COMMA - 320)) | (1L << (CONCATENATION_OPERATOR - 320)) | (1L << (NOT_EQUAL - 320)) | (1L << (LTH - 320)) | (1L << (LEQ - 320)) | (1L << (GTH - 320)) | (1L << (GEQ - 320)) | (1L << (LEFT_PAREN - 320)) | (1L << (RIGHT_PAREN - 320)) | (1L << (PLUS - 320)) | (1L << (MINUS - 320)) | (1L << (MULTIPLY - 320)) | (1L << (DIVIDE - 320)) | (1L << (MODULAR - 320)) | (1L << (DOT - 320)) | (1L << (UNDERLINE - 320)) | (1L << (VERTICAL_BAR - 320)) | (1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (DOUBLE_DOLLAR - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (QuotedIdentifier - 320)) | (1L << (UnterminatedQuotedIdentifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)))) != 0)) {
				{
				{
				setState(2154);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==DOUBLE_UNDER_DOLLAR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(2159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2160); match(DOUBLE_UNDER_DOLLAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_attributeContext extends ParserRuleContext {
		public TerminalNode ISCACHABLE() { return getToken(SQLParser.ISCACHABLE, 0); }
		public TerminalNode ISSTRICT() { return getToken(SQLParser.ISSTRICT, 0); }
		public Function_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_attribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_attribute(this);
		}
	}

	public final Function_attributeContext function_attribute() throws RecognitionException {
		Function_attributeContext _localctx = new Function_attributeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_function_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2162);
			_la = _input.LA(1);
			if ( !(_la==ISCACHABLE || _la==ISSTRICT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgmodeContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public TerminalNode OUT() { return getToken(SQLParser.OUT, 0); }
		public TerminalNode VARIADIC() { return getToken(SQLParser.VARIADIC, 0); }
		public TerminalNode INOUT() { return getToken(SQLParser.INOUT, 0); }
		public ArgmodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argmode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterArgmode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitArgmode(this);
		}
	}

	public final ArgmodeContext argmode() throws RecognitionException {
		ArgmodeContext _localctx = new ArgmodeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_argmode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2164);
			_la = _input.LA(1);
			if ( !(_la==IN || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INOUT - 66)) | (1L << (OUT - 66)) | (1L << (VARIADIC - 66)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_definitionContext extends ParserRuleContext {
		public IdentifierContext func_name;
		public ArgmodeContext arg_mode;
		public IdentifierContext argname;
		public Data_typeContext argtype_data;
		public Value_expressionContext argtype_expres;
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public ArgmodeContext argmode(int i) {
			return getRuleContext(ArgmodeContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Data_typeContext data_type(int i) {
			return getRuleContext(Data_typeContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<ArgmodeContext> argmode() {
			return getRuleContexts(ArgmodeContext.class);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Data_typeContext> data_type() {
			return getRuleContexts(Data_typeContext.class);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_definition(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2166); match(FUNCTION);
			setState(2167); ((Function_definitionContext)_localctx).func_name = identifier();
			setState(2168); match(LEFT_PAREN);
			setState(2184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << IN))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INOUT - 66)) | (1L << (LEFT - 66)) | (1L << (NOT - 66)) | (1L << (NULL - 66)) | (1L << (OUT - 66)) | (1L << (RIGHT - 66)) | (1L << (SETOF - 66)) | (1L << (SOME - 66)) | (1L << (TRIGGER - 66)) | (1L << (TRUE - 66)) | (1L << (VARIADIC - 66)))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (REGCLASS - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (BINARY - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 336)) & ~0x3f) == 0 && ((1L << (_la - 336)) & ((1L << (LEFT_PAREN - 336)) | (1L << (PLUS - 336)) | (1L << (MINUS - 336)) | (1L << (DOUBLE_QUOTE - 336)) | (1L << (NUMBER - 336)) | (1L << (REAL_NUMBER - 336)) | (1L << (Identifier - 336)) | (1L << (QuotedIdentifier - 336)) | (1L << (Character_String_Literal - 336)))) != 0)) {
				{
				{
				setState(2170);
				_la = _input.LA(1);
				if (_la==IN || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INOUT - 66)) | (1L << (OUT - 66)) | (1L << (VARIADIC - 66)))) != 0)) {
					{
					setState(2169); ((Function_definitionContext)_localctx).arg_mode = argmode();
					}
				}

				setState(2173);
				switch ( getInterpreter().adaptivePredict(_input,284,_ctx) ) {
				case 1:
					{
					setState(2172); ((Function_definitionContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(2177);
				switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
				case 1:
					{
					setState(2175); ((Function_definitionContext)_localctx).argtype_data = data_type();
					}
					break;
				case 2:
					{
					setState(2176); ((Function_definitionContext)_localctx).argtype_expres = value_expression();
					}
					break;
				}
				setState(2180);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2179); match(COMMA);
					}
				}

				}
				}
				setState(2186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2187); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Functions_definition_schemaContext extends ParserRuleContext {
		public IdentifierContext schema_name;
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode FUNCTIONS() { return getToken(SQLParser.FUNCTIONS, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Functions_definition_schemaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions_definition_schema; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunctions_definition_schema(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunctions_definition_schema(this);
		}
	}

	public final Functions_definition_schemaContext functions_definition_schema() throws RecognitionException {
		Functions_definition_schemaContext _localctx = new Functions_definition_schemaContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_functions_definition_schema);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2189); match(ALL);
			setState(2190); match(FUNCTIONS);
			setState(2191); match(IN);
			setState(2192); match(SCHEMA);
			setState(2197); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2193); ((Functions_definition_schemaContext)_localctx).schema_name = identifier();
					setState(2195);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2194); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2199); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,289,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_sequence_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public Token incr;
		public Token minval;
		public Numeric_typeContext maxval;
		public Token start_val;
		public Token cache_val;
		public Schema_qualified_nameContext col_name;
		public TerminalNode MINVALUE(int i) {
			return getToken(SQLParser.MINVALUE, i);
		}
		public TerminalNode MAXVALUE(int i) {
			return getToken(SQLParser.MAXVALUE, i);
		}
		public TerminalNode OWNED(int i) {
			return getToken(SQLParser.OWNED, i);
		}
		public TerminalNode WITH(int i) {
			return getToken(SQLParser.WITH, i);
		}
		public List<TerminalNode> OWNED() { return getTokens(SQLParser.OWNED); }
		public List<TerminalNode> BY() { return getTokens(SQLParser.BY); }
		public List<Numeric_typeContext> numeric_type() {
			return getRuleContexts(Numeric_typeContext.class);
		}
		public List<TerminalNode> CYCLE() { return getTokens(SQLParser.CYCLE); }
		public TerminalNode TEMP() { return getToken(SQLParser.TEMP, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(SQLParser.NUMBER); }
		public TerminalNode NO(int i) {
			return getToken(SQLParser.NO, i);
		}
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode BY(int i) {
			return getToken(SQLParser.BY, i);
		}
		public TerminalNode TEMPORARY() { return getToken(SQLParser.TEMPORARY, 0); }
		public TerminalNode CACHE(int i) {
			return getToken(SQLParser.CACHE, i);
		}
		public List<TerminalNode> WITH() { return getTokens(SQLParser.WITH); }
		public List<TerminalNode> NO() { return getTokens(SQLParser.NO); }
		public List<TerminalNode> MAXVALUE() { return getTokens(SQLParser.MAXVALUE); }
		public TerminalNode CYCLE(int i) {
			return getToken(SQLParser.CYCLE, i);
		}
		public TerminalNode SEQUENCE() { return getToken(SQLParser.SEQUENCE, 0); }
		public List<TerminalNode> INCREMENT() { return getTokens(SQLParser.INCREMENT); }
		public List<TerminalNode> NONE() { return getTokens(SQLParser.NONE); }
		public List<TerminalNode> START() { return getTokens(SQLParser.START); }
		public Numeric_typeContext numeric_type(int i) {
			return getRuleContext(Numeric_typeContext.class,i);
		}
		public List<TerminalNode> MINVALUE() { return getTokens(SQLParser.MINVALUE); }
		public TerminalNode INCREMENT(int i) {
			return getToken(SQLParser.INCREMENT, i);
		}
		public TerminalNode NONE(int i) {
			return getToken(SQLParser.NONE, i);
		}
		public TerminalNode NUMBER(int i) {
			return getToken(SQLParser.NUMBER, i);
		}
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode START(int i) {
			return getToken(SQLParser.START, i);
		}
		public List<TerminalNode> CACHE() { return getTokens(SQLParser.CACHE); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public Create_sequence_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_sequence_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCreate_sequence_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCreate_sequence_statement(this);
		}
	}

	public final Create_sequence_statementContext create_sequence_statement() throws RecognitionException {
		Create_sequence_statementContext _localctx = new Create_sequence_statementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_create_sequence_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2201); match(CREATE);
			setState(2203);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(2202);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2205); match(SEQUENCE);
			setState(2206); ((Create_sequence_statementContext)_localctx).name = schema_qualified_name();
			setState(2243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OWNED || _la==CACHE || ((((_la - 158)) & ~0x3f) == 0 && ((1L << (_la - 158)) & ((1L << (CYCLE - 158)) | (1L << (INCREMENT - 158)) | (1L << (MAXVALUE - 158)) | (1L << (MINVALUE - 158)) | (1L << (NO - 158)))) != 0) || _la==START) {
				{
				setState(2241);
				switch ( getInterpreter().adaptivePredict(_input,297,_ctx) ) {
				case 1:
					{
					{
					setState(2207); match(INCREMENT);
					setState(2209);
					_la = _input.LA(1);
					if (_la==BY) {
						{
						setState(2208); match(BY);
						}
					}

					setState(2211); ((Create_sequence_statementContext)_localctx).incr = match(NUMBER);
					}
					}
					break;
				case 2:
					{
					setState(2216);
					switch (_input.LA(1)) {
					case MINVALUE:
						{
						setState(2212); match(MINVALUE);
						setState(2213); ((Create_sequence_statementContext)_localctx).minval = match(NUMBER);
						}
						break;
					case NO:
						{
						setState(2214); match(NO);
						setState(2215); match(MINVALUE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case 3:
					{
					setState(2222);
					switch (_input.LA(1)) {
					case MAXVALUE:
						{
						setState(2218); match(MAXVALUE);
						setState(2219); ((Create_sequence_statementContext)_localctx).maxval = numeric_type();
						}
						break;
					case NO:
						{
						setState(2220); match(NO);
						setState(2221); match(MAXVALUE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case 4:
					{
					{
					setState(2224); match(START);
					setState(2226);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(2225); match(WITH);
						}
					}

					setState(2228); ((Create_sequence_statementContext)_localctx).start_val = match(NUMBER);
					}
					}
					break;
				case 5:
					{
					{
					setState(2229); match(CACHE);
					setState(2230); ((Create_sequence_statementContext)_localctx).cache_val = match(NUMBER);
					}
					}
					break;
				case 6:
					{
					{
					setState(2232);
					_la = _input.LA(1);
					if (_la==NO) {
						{
						setState(2231); match(NO);
						}
					}

					setState(2234); match(CYCLE);
					}
					}
					break;
				case 7:
					{
					{
					setState(2235); match(OWNED);
					setState(2236); match(BY);
					setState(2239);
					switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
					case 1:
						{
						setState(2237); ((Create_sequence_statementContext)_localctx).col_name = schema_qualified_name();
						}
						break;
					case 2:
						{
						setState(2238); match(NONE);
						}
						break;
					}
					}
					}
					break;
				}
				}
				setState(2245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_schema_statementContext extends ParserRuleContext {
		public IdentifierContext schema_name;
		public IdentifierContext user_name;
		public SqlContext schema_element;
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public List<SqlContext> sql() {
			return getRuleContexts(SqlContext.class);
		}
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public SqlContext sql(int i) {
			return getRuleContext(SqlContext.class,i);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode AUTHORIZATION() { return getToken(SQLParser.AUTHORIZATION, 0); }
		public Create_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCreate_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCreate_schema_statement(this);
		}
	}

	public final Create_schema_statementContext create_schema_statement() throws RecognitionException {
		Create_schema_statementContext _localctx = new Create_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_create_schema_statement);
		int _la;
		try {
			int _alt;
			setState(2286);
			switch ( getInterpreter().adaptivePredict(_input,303,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2246); match(CREATE);
				setState(2247); match(SCHEMA);
				setState(2248); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(2251);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(2249); match(AUTHORIZATION);
					setState(2250); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				setState(2256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,300,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2253); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(2258);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,300,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2259); match(CREATE);
				setState(2260); match(SCHEMA);
				setState(2261); match(AUTHORIZATION);
				setState(2262); ((Create_schema_statementContext)_localctx).user_name = identifier();
				setState(2266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,301,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2263); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(2268);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,301,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2269); match(CREATE);
				setState(2270); match(SCHEMA);
				setState(2271); match(IF);
				setState(2272); match(NOT);
				setState(2273); match(EXISTS);
				setState(2274); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(2277);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(2275); match(AUTHORIZATION);
					setState(2276); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2279); match(CREATE);
				setState(2280); match(SCHEMA);
				setState(2281); match(IF);
				setState(2282); match(NOT);
				setState(2283); match(EXISTS);
				setState(2284); match(AUTHORIZATION);
				setState(2285); ((Create_schema_statementContext)_localctx).user_name = identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_view_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public IdentifierContext column_name;
		public IdentifierContext view_option_name;
		public IdentifierContext view_option_value;
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public TerminalNode VIEW() { return getToken(SQLParser.VIEW, 0); }
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode TEMPORARY() { return getToken(SQLParser.TEMPORARY, 0); }
		public TerminalNode OR() { return getToken(SQLParser.OR, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public List<TerminalNode> EQUAL() { return getTokens(SQLParser.EQUAL); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode EQUAL(int i) {
			return getToken(SQLParser.EQUAL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode REPLACE() { return getToken(SQLParser.REPLACE, 0); }
		public TerminalNode TEMP() { return getToken(SQLParser.TEMP, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Query_specificationContext query_specification() {
			return getRuleContext(Query_specificationContext.class,0);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Create_view_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_view_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCreate_view_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCreate_view_statement(this);
		}
	}

	public final Create_view_statementContext create_view_statement() throws RecognitionException {
		Create_view_statementContext _localctx = new Create_view_statementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_create_view_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2288); match(CREATE);
			setState(2291);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(2289); match(OR);
				setState(2290); match(REPLACE);
				}
			}

			setState(2294);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(2293);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2296); match(VIEW);
			setState(2297); ((Create_view_statementContext)_localctx).name = schema_qualified_name();
			setState(2304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0)) {
				{
				{
				setState(2298); ((Create_view_statementContext)_localctx).column_name = identifier();
				setState(2300);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2299); match(COMMA);
					}
				}

				}
				}
				setState(2306);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2320);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2307); match(WITH);
				setState(2308); match(LEFT_PAREN);
				setState(2314); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2309); ((Create_view_statementContext)_localctx).view_option_name = identifier();
					setState(2312);
					_la = _input.LA(1);
					if (_la==EQUAL) {
						{
						setState(2310); match(EQUAL);
						setState(2311); ((Create_view_statementContext)_localctx).view_option_value = identifier();
						}
					}

					}
					}
					setState(2316); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(2318); match(RIGHT_PAREN);
				}
			}

			setState(2322); match(AS);
			setState(2323); query_specification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_table_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext n;
		public Table_constraintContext tabl_constraint;
		public IdentifierContext parent_table;
		public Like_optionContext like_opt;
		public IdentifierContext type_name;
		public IdentifierContext column_name;
		public Column_constraintContext col_constraint;
		public On_commitContext on_commit() {
			return getRuleContext(On_commitContext.class,0);
		}
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public Table_spaceContext table_space() {
			return getRuleContext(Table_spaceContext.class,0);
		}
		public Like_optionContext like_option(int i) {
			return getRuleContext(Like_optionContext.class,i);
		}
		public TerminalNode WITH(int i) {
			return getToken(SQLParser.WITH, i);
		}
		public TerminalNode INHERITS() { return getToken(SQLParser.INHERITS, 0); }
		public TerminalNode LIKE(int i) {
			return getToken(SQLParser.LIKE, i);
		}
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public List<TerminalNode> OPTIONS() { return getTokens(SQLParser.OPTIONS); }
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public TerminalNode GLOBAL() { return getToken(SQLParser.GLOBAL, 0); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public Table_column_definitionContext table_column_definition(int i) {
			return getRuleContext(Table_column_definitionContext.class,i);
		}
		public Table_constraintContext table_constraint(int i) {
			return getRuleContext(Table_constraintContext.class,i);
		}
		public TerminalNode OF() { return getToken(SQLParser.OF, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode TEMP() { return getToken(SQLParser.TEMP, 0); }
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LIKE() { return getTokens(SQLParser.LIKE); }
		public List<Table_column_definitionContext> table_column_definition() {
			return getRuleContexts(Table_column_definitionContext.class);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public List<Like_optionContext> like_option() {
			return getRuleContexts(Like_optionContext.class);
		}
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public Storage_parameter_oidContext storage_parameter_oid() {
			return getRuleContext(Storage_parameter_oidContext.class,0);
		}
		public TerminalNode TEMPORARY() { return getToken(SQLParser.TEMPORARY, 0); }
		public List<TerminalNode> WITH() { return getTokens(SQLParser.WITH); }
		public Column_constraintContext column_constraint(int i) {
			return getRuleContext(Column_constraintContext.class,i);
		}
		public List<Table_constraintContext> table_constraint() {
			return getRuleContexts(Table_constraintContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode UNLOGGED() { return getToken(SQLParser.UNLOGGED, 0); }
		public List<Column_constraintContext> column_constraint() {
			return getRuleContexts(Column_constraintContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode LOCAL() { return getToken(SQLParser.LOCAL, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OPTIONS(int i) {
			return getToken(SQLParser.OPTIONS, i);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Create_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCreate_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCreate_table_statement(this);
		}
	}

	public final Create_table_statementContext create_table_statement() throws RecognitionException {
		Create_table_statementContext _localctx = new Create_table_statementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_create_table_statement);
		int _la;
		try {
			int _alt;
			setState(2428);
			switch ( getInterpreter().adaptivePredict(_input,330,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2327); match(CREATE);
				setState(2333);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(2329);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(2328);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(2331);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(2332); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2335); match(TABLE);
				setState(2339);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(2336); match(IF);
					setState(2337); match(NOT);
					setState(2338); match(EXISTS);
					}
				}

				setState(2341); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(2342); match(LEFT_PAREN);
				setState(2362);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (LIKE - 74)) | (1L << (PRIMARY - 74)) | (1L << (UNIQUE - 74)) | (1L << (ADMIN - 74)) | (1L << (ALWAYS - 74)) | (1L << (AVG - 74)))) != 0) || ((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (BETWEEN - 138)) | (1L << (BY - 138)) | (1L << (CACHE - 138)) | (1L << (CALLED - 138)) | (1L << (CLASS - 138)) | (1L << (CENTURY - 138)) | (1L << (CHARACTER - 138)) | (1L << (CHECK - 138)) | (1L << (CLUSTER - 138)) | (1L << (COLLECT - 138)) | (1L << (COALESCE - 138)) | (1L << (COLUMN - 138)) | (1L << (COMMENT - 138)) | (1L << (COMMENTS - 138)) | (1L << (COMMIT - 138)) | (1L << (CONFIGURATION - 138)) | (1L << (COST - 138)) | (1L << (COUNT - 138)) | (1L << (CUBE - 138)) | (1L << (CURRENT - 138)) | (1L << (CYCLE - 138)) | (1L << (DATA - 138)) | (1L << (DAY - 138)) | (1L << (DEC - 138)) | (1L << (DECADE - 138)) | (1L << (DEFINER - 138)) | (1L << (DICTIONARY - 138)) | (1L << (DISABLE - 138)) | (1L << (DOW - 138)) | (1L << (DOY - 138)) | (1L << (DROP - 138)) | (1L << (ENABLE - 138)) | (1L << (EPOCH - 138)) | (1L << (EVERY - 138)) | (1L << (EXISTS - 138)) | (1L << (EXTENDED - 138)) | (1L << (EXTERNAL - 138)) | (1L << (EXTRACT - 138)) | (1L << (FAMILY - 138)) | (1L << (FILTER - 138)) | (1L << (FIRST - 138)) | (1L << (FORMAT - 138)) | (1L << (FUSION - 138)) | (1L << (GROUPING - 138)) | (1L << (HASH - 138)) | (1L << (INHERIT - 138)) | (1L << (INDEX - 138)) | (1L << (INCREMENT - 138)) | (1L << (INPUT - 138)) | (1L << (INSERT - 138)) | (1L << (INTERSECTION - 138)) | (1L << (ISCACHABLE - 138)) | (1L << (ISODOW - 138)) | (1L << (ISOYEAR - 138)) | (1L << (ISSTRICT - 138)) | (1L << (LANGUAGE - 138)) | (1L << (LARGE - 138)) | (1L << (LAST - 138)) | (1L << (LESS - 138)) | (1L << (LIST - 138)) | (1L << (LOCATION - 138)) | (1L << (MAIN - 138)))) != 0) || ((((_la - 202)) & ~0x3f) == 0 && ((1L << (_la - 202)) & ((1L << (MATCH - 202)) | (1L << (MAX - 202)) | (1L << (MAXVALUE - 202)) | (1L << (MICROSECONDS - 202)) | (1L << (MILLENNIUM - 202)) | (1L << (MILLISECONDS - 202)) | (1L << (MIN - 202)) | (1L << (MINVALUE - 202)) | (1L << (MINUTE - 202)) | (1L << (MONTH - 202)) | (1L << (NATIONAL - 202)) | (1L << (NO - 202)) | (1L << (NONE - 202)) | (1L << (NULLIF - 202)) | (1L << (OBJECT - 202)) | (1L << (ON - 202)) | (1L << (ONLY - 202)) | (1L << (OPTION - 202)) | (1L << (OPTIONS - 202)) | (1L << (OVERWRITE - 202)) | (1L << (PARSER - 202)) | (1L << (PARTIAL - 202)) | (1L << (PARTITION - 202)) | (1L << (PARTITIONS - 202)) | (1L << (PLAIN - 202)) | (1L << (PRECISION - 202)) | (1L << (PUBLIC - 202)) | (1L << (PURGE - 202)) | (1L << (QUARTER - 202)) | (1L << (RANGE - 202)) | (1L << (REGEXP - 202)) | (1L << (RENAME - 202)) | (1L << (REPLICA - 202)) | (1L << (RESET - 202)) | (1L << (RLIKE - 202)) | (1L << (ROLLUP - 202)) | (1L << (SEARCH - 202)) | (1L << (SECOND - 202)) | (1L << (SECURITY - 202)) | (1L << (SERVER - 202)) | (1L << (SET - 202)) | (1L << (SIMILAR - 202)) | (1L << (SIMPLE - 202)) | (1L << (STABLE - 202)) | (1L << (START - 202)) | (1L << (STATISTICS - 202)) | (1L << (STORAGE - 202)) | (1L << (STDDEV_POP - 202)) | (1L << (STDDEV_SAMP - 202)) | (1L << (SUBPARTITION - 202)) | (1L << (SUM - 202)) | (1L << (TABLESPACE - 202)) | (1L << (TEMPLATE - 202)) | (1L << (THAN - 202)) | (1L << (TIMEZONE - 202)) | (1L << (TIMEZONE_HOUR - 202)) | (1L << (TIMEZONE_MINUTE - 202)) | (1L << (TRIM - 202)) | (1L << (TO - 202)) | (1L << (TYPE - 202)) | (1L << (UNKNOWN - 202)))) != 0) || ((((_la - 266)) & ~0x3f) == 0 && ((1L << (_la - 266)) & ((1L << (UNLOGGED - 266)) | (1L << (USER - 266)) | (1L << (VALID - 266)) | (1L << (VALIDATE - 266)) | (1L << (VALUES - 266)) | (1L << (VAR_SAMP - 266)) | (1L << (VAR_POP - 266)) | (1L << (VARYING - 266)) | (1L << (VERSION - 266)) | (1L << (VOLATILE - 266)) | (1L << (WEEK - 266)) | (1L << (WINDOW - 266)) | (1L << (WRAPPER - 266)) | (1L << (YEAR - 266)) | (1L << (ZONE - 266)) | (1L << (BOOLEAN - 266)) | (1L << (BOOL - 266)) | (1L << (BIT - 266)) | (1L << (VARBIT - 266)) | (1L << (INT1 - 266)) | (1L << (INT2 - 266)) | (1L << (INT4 - 266)) | (1L << (INT8 - 266)) | (1L << (TINYINT - 266)) | (1L << (SMALLINT - 266)) | (1L << (INT - 266)) | (1L << (INTEGER - 266)) | (1L << (BIGINT - 266)) | (1L << (FLOAT4 - 266)) | (1L << (FLOAT8 - 266)) | (1L << (REAL - 266)) | (1L << (FLOAT - 266)) | (1L << (DOUBLE - 266)) | (1L << (NUMERIC - 266)) | (1L << (DECIMAL - 266)) | (1L << (CHAR - 266)) | (1L << (VARCHAR - 266)) | (1L << (NCHAR - 266)) | (1L << (NVARCHAR - 266)) | (1L << (DATE - 266)) | (1L << (TIME - 266)) | (1L << (TIMETZ - 266)) | (1L << (TIMESTAMP - 266)) | (1L << (TIMESTAMPTZ - 266)) | (1L << (TEXT - 266)) | (1L << (UUID - 266)) | (1L << (VARBINARY - 266)) | (1L << (BLOB - 266)) | (1L << (BYTEA - 266)) | (1L << (INET4 - 266)) | (1L << (INTERVAL - 266)) | (1L << (VOID - 266)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0)) {
					{
					setState(2358); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2353);
						switch ( getInterpreter().adaptivePredict(_input,315,_ctx) ) {
						case 1:
							{
							{
							setState(2343); table_column_definition();
							}
							}
							break;
						case 2:
							{
							setState(2344); ((Create_table_statementContext)_localctx).tabl_constraint = table_constraint();
							}
							break;
						case 3:
							{
							{
							setState(2345); match(LIKE);
							setState(2346); ((Create_table_statementContext)_localctx).parent_table = identifier();
							setState(2350);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==EXCLUDING || _la==INCLUDING) {
								{
								{
								setState(2347); ((Create_table_statementContext)_localctx).like_opt = like_option();
								}
								}
								setState(2352);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							break;
						}
						setState(2356);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2355); match(COMMA);
							}
						}

						}
						}
						setState(2360); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (LIKE - 74)) | (1L << (PRIMARY - 74)) | (1L << (UNIQUE - 74)) | (1L << (ADMIN - 74)) | (1L << (ALWAYS - 74)) | (1L << (AVG - 74)))) != 0) || ((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (BETWEEN - 138)) | (1L << (BY - 138)) | (1L << (CACHE - 138)) | (1L << (CALLED - 138)) | (1L << (CLASS - 138)) | (1L << (CENTURY - 138)) | (1L << (CHARACTER - 138)) | (1L << (CHECK - 138)) | (1L << (CLUSTER - 138)) | (1L << (COLLECT - 138)) | (1L << (COALESCE - 138)) | (1L << (COLUMN - 138)) | (1L << (COMMENT - 138)) | (1L << (COMMENTS - 138)) | (1L << (COMMIT - 138)) | (1L << (CONFIGURATION - 138)) | (1L << (COST - 138)) | (1L << (COUNT - 138)) | (1L << (CUBE - 138)) | (1L << (CURRENT - 138)) | (1L << (CYCLE - 138)) | (1L << (DATA - 138)) | (1L << (DAY - 138)) | (1L << (DEC - 138)) | (1L << (DECADE - 138)) | (1L << (DEFINER - 138)) | (1L << (DICTIONARY - 138)) | (1L << (DISABLE - 138)) | (1L << (DOW - 138)) | (1L << (DOY - 138)) | (1L << (DROP - 138)) | (1L << (ENABLE - 138)) | (1L << (EPOCH - 138)) | (1L << (EVERY - 138)) | (1L << (EXISTS - 138)) | (1L << (EXTENDED - 138)) | (1L << (EXTERNAL - 138)) | (1L << (EXTRACT - 138)) | (1L << (FAMILY - 138)) | (1L << (FILTER - 138)) | (1L << (FIRST - 138)) | (1L << (FORMAT - 138)) | (1L << (FUSION - 138)) | (1L << (GROUPING - 138)) | (1L << (HASH - 138)) | (1L << (INHERIT - 138)) | (1L << (INDEX - 138)) | (1L << (INCREMENT - 138)) | (1L << (INPUT - 138)) | (1L << (INSERT - 138)) | (1L << (INTERSECTION - 138)) | (1L << (ISCACHABLE - 138)) | (1L << (ISODOW - 138)) | (1L << (ISOYEAR - 138)) | (1L << (ISSTRICT - 138)) | (1L << (LANGUAGE - 138)) | (1L << (LARGE - 138)) | (1L << (LAST - 138)) | (1L << (LESS - 138)) | (1L << (LIST - 138)) | (1L << (LOCATION - 138)) | (1L << (MAIN - 138)))) != 0) || ((((_la - 202)) & ~0x3f) == 0 && ((1L << (_la - 202)) & ((1L << (MATCH - 202)) | (1L << (MAX - 202)) | (1L << (MAXVALUE - 202)) | (1L << (MICROSECONDS - 202)) | (1L << (MILLENNIUM - 202)) | (1L << (MILLISECONDS - 202)) | (1L << (MIN - 202)) | (1L << (MINVALUE - 202)) | (1L << (MINUTE - 202)) | (1L << (MONTH - 202)) | (1L << (NATIONAL - 202)) | (1L << (NO - 202)) | (1L << (NONE - 202)) | (1L << (NULLIF - 202)) | (1L << (OBJECT - 202)) | (1L << (ON - 202)) | (1L << (ONLY - 202)) | (1L << (OPTION - 202)) | (1L << (OPTIONS - 202)) | (1L << (OVERWRITE - 202)) | (1L << (PARSER - 202)) | (1L << (PARTIAL - 202)) | (1L << (PARTITION - 202)) | (1L << (PARTITIONS - 202)) | (1L << (PLAIN - 202)) | (1L << (PRECISION - 202)) | (1L << (PUBLIC - 202)) | (1L << (PURGE - 202)) | (1L << (QUARTER - 202)) | (1L << (RANGE - 202)) | (1L << (REGEXP - 202)) | (1L << (RENAME - 202)) | (1L << (REPLICA - 202)) | (1L << (RESET - 202)) | (1L << (RLIKE - 202)) | (1L << (ROLLUP - 202)) | (1L << (SEARCH - 202)) | (1L << (SECOND - 202)) | (1L << (SECURITY - 202)) | (1L << (SERVER - 202)) | (1L << (SET - 202)) | (1L << (SIMILAR - 202)) | (1L << (SIMPLE - 202)) | (1L << (STABLE - 202)) | (1L << (START - 202)) | (1L << (STATISTICS - 202)) | (1L << (STORAGE - 202)) | (1L << (STDDEV_POP - 202)) | (1L << (STDDEV_SAMP - 202)) | (1L << (SUBPARTITION - 202)) | (1L << (SUM - 202)) | (1L << (TABLESPACE - 202)) | (1L << (TEMPLATE - 202)) | (1L << (THAN - 202)) | (1L << (TIMEZONE - 202)) | (1L << (TIMEZONE_HOUR - 202)) | (1L << (TIMEZONE_MINUTE - 202)) | (1L << (TRIM - 202)) | (1L << (TO - 202)) | (1L << (TYPE - 202)) | (1L << (UNKNOWN - 202)))) != 0) || ((((_la - 266)) & ~0x3f) == 0 && ((1L << (_la - 266)) & ((1L << (UNLOGGED - 266)) | (1L << (USER - 266)) | (1L << (VALID - 266)) | (1L << (VALIDATE - 266)) | (1L << (VALUES - 266)) | (1L << (VAR_SAMP - 266)) | (1L << (VAR_POP - 266)) | (1L << (VARYING - 266)) | (1L << (VERSION - 266)) | (1L << (VOLATILE - 266)) | (1L << (WEEK - 266)) | (1L << (WINDOW - 266)) | (1L << (WRAPPER - 266)) | (1L << (YEAR - 266)) | (1L << (ZONE - 266)) | (1L << (BOOLEAN - 266)) | (1L << (BOOL - 266)) | (1L << (BIT - 266)) | (1L << (VARBIT - 266)) | (1L << (INT1 - 266)) | (1L << (INT2 - 266)) | (1L << (INT4 - 266)) | (1L << (INT8 - 266)) | (1L << (TINYINT - 266)) | (1L << (SMALLINT - 266)) | (1L << (INT - 266)) | (1L << (INTEGER - 266)) | (1L << (BIGINT - 266)) | (1L << (FLOAT4 - 266)) | (1L << (FLOAT8 - 266)) | (1L << (REAL - 266)) | (1L << (FLOAT - 266)) | (1L << (DOUBLE - 266)) | (1L << (NUMERIC - 266)) | (1L << (DECIMAL - 266)) | (1L << (CHAR - 266)) | (1L << (VARCHAR - 266)) | (1L << (NCHAR - 266)) | (1L << (NVARCHAR - 266)) | (1L << (DATE - 266)) | (1L << (TIME - 266)) | (1L << (TIMETZ - 266)) | (1L << (TIMESTAMP - 266)) | (1L << (TIMESTAMPTZ - 266)) | (1L << (TEXT - 266)) | (1L << (UUID - 266)) | (1L << (VARBINARY - 266)) | (1L << (BLOB - 266)) | (1L << (BYTEA - 266)) | (1L << (INET4 - 266)) | (1L << (INTERVAL - 266)) | (1L << (VOID - 266)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
					}
				}

				setState(2364); match(RIGHT_PAREN);
				setState(2377);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(2365); match(INHERITS);
					setState(2366); match(LEFT_PAREN);
					setState(2371); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2367); ((Create_table_statementContext)_localctx).parent_table = identifier();
						setState(2369);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2368); match(COMMA);
							}
						}

						}
						}
						setState(2373); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
					setState(2375); match(RIGHT_PAREN);
					}
				}

				setState(2379); storage_parameter_oid();
				setState(2380); on_commit();
				setState(2381); table_space();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2383); match(CREATE);
				setState(2389);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(2385);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(2384);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(2387);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(2388); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2391); match(TABLE);
				setState(2395);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(2392); match(IF);
					setState(2393); match(NOT);
					setState(2394); match(EXISTS);
					}
				}

				setState(2397); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(2398); match(OF);
				setState(2399); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(2422);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2400); match(LEFT_PAREN);
					setState(2416); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2411);
						switch ( getInterpreter().adaptivePredict(_input,326,_ctx) ) {
						case 1:
							{
							{
							setState(2401); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(2402); match(WITH);
							setState(2403); match(OPTIONS);
							setState(2407);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,325,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(2404); ((Create_table_statementContext)_localctx).col_constraint = column_constraint();
									}
									} 
								}
								setState(2409);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,325,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(2410); table_constraint();
							}
							break;
						}
						setState(2414);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2413); match(COMMA);
							}
						}

						}
						}
						setState(2418); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (PRIMARY - 90)) | (1L << (UNIQUE - 90)) | (1L << (ADMIN - 90)) | (1L << (ALWAYS - 90)) | (1L << (AVG - 90)) | (1L << (BETWEEN - 90)) | (1L << (BY - 90)) | (1L << (CACHE - 90)) | (1L << (CALLED - 90)) | (1L << (CLASS - 90)) | (1L << (CENTURY - 90)) | (1L << (CHARACTER - 90)) | (1L << (CHECK - 90)) | (1L << (CLUSTER - 90)) | (1L << (COLLECT - 90)) | (1L << (COALESCE - 90)) | (1L << (COLUMN - 90)) | (1L << (COMMENT - 90)) | (1L << (COMMENTS - 90)) | (1L << (COMMIT - 90)) | (1L << (CONFIGURATION - 90)))) != 0) || ((((_la - 154)) & ~0x3f) == 0 && ((1L << (_la - 154)) & ((1L << (COST - 154)) | (1L << (COUNT - 154)) | (1L << (CUBE - 154)) | (1L << (CURRENT - 154)) | (1L << (CYCLE - 154)) | (1L << (DATA - 154)) | (1L << (DAY - 154)) | (1L << (DEC - 154)) | (1L << (DECADE - 154)) | (1L << (DEFINER - 154)) | (1L << (DICTIONARY - 154)) | (1L << (DISABLE - 154)) | (1L << (DOW - 154)) | (1L << (DOY - 154)) | (1L << (DROP - 154)) | (1L << (ENABLE - 154)) | (1L << (EPOCH - 154)) | (1L << (EVERY - 154)) | (1L << (EXISTS - 154)) | (1L << (EXTENDED - 154)) | (1L << (EXTERNAL - 154)) | (1L << (EXTRACT - 154)) | (1L << (FAMILY - 154)) | (1L << (FILTER - 154)) | (1L << (FIRST - 154)) | (1L << (FORMAT - 154)) | (1L << (FUSION - 154)) | (1L << (GROUPING - 154)) | (1L << (HASH - 154)) | (1L << (INHERIT - 154)) | (1L << (INDEX - 154)) | (1L << (INCREMENT - 154)) | (1L << (INPUT - 154)) | (1L << (INSERT - 154)) | (1L << (INTERSECTION - 154)) | (1L << (ISCACHABLE - 154)) | (1L << (ISODOW - 154)) | (1L << (ISOYEAR - 154)) | (1L << (ISSTRICT - 154)) | (1L << (LANGUAGE - 154)) | (1L << (LARGE - 154)) | (1L << (LAST - 154)) | (1L << (LESS - 154)) | (1L << (LIST - 154)) | (1L << (LOCATION - 154)) | (1L << (MAIN - 154)) | (1L << (MATCH - 154)) | (1L << (MAX - 154)) | (1L << (MAXVALUE - 154)) | (1L << (MICROSECONDS - 154)) | (1L << (MILLENNIUM - 154)) | (1L << (MILLISECONDS - 154)) | (1L << (MIN - 154)) | (1L << (MINVALUE - 154)) | (1L << (MINUTE - 154)) | (1L << (MONTH - 154)) | (1L << (NATIONAL - 154)) | (1L << (NO - 154)) | (1L << (NONE - 154)) | (1L << (NULLIF - 154)))) != 0) || ((((_la - 218)) & ~0x3f) == 0 && ((1L << (_la - 218)) & ((1L << (OBJECT - 218)) | (1L << (ON - 218)) | (1L << (ONLY - 218)) | (1L << (OPTION - 218)) | (1L << (OPTIONS - 218)) | (1L << (OVERWRITE - 218)) | (1L << (PARSER - 218)) | (1L << (PARTIAL - 218)) | (1L << (PARTITION - 218)) | (1L << (PARTITIONS - 218)) | (1L << (PLAIN - 218)) | (1L << (PRECISION - 218)) | (1L << (PUBLIC - 218)) | (1L << (PURGE - 218)) | (1L << (QUARTER - 218)) | (1L << (RANGE - 218)) | (1L << (REGEXP - 218)) | (1L << (RENAME - 218)) | (1L << (REPLICA - 218)) | (1L << (RESET - 218)) | (1L << (RLIKE - 218)) | (1L << (ROLLUP - 218)) | (1L << (SEARCH - 218)) | (1L << (SECOND - 218)) | (1L << (SECURITY - 218)) | (1L << (SERVER - 218)) | (1L << (SET - 218)) | (1L << (SIMILAR - 218)) | (1L << (SIMPLE - 218)) | (1L << (STABLE - 218)) | (1L << (START - 218)) | (1L << (STATISTICS - 218)) | (1L << (STORAGE - 218)) | (1L << (STDDEV_POP - 218)) | (1L << (STDDEV_SAMP - 218)) | (1L << (SUBPARTITION - 218)) | (1L << (SUM - 218)) | (1L << (TABLESPACE - 218)) | (1L << (TEMPLATE - 218)) | (1L << (THAN - 218)) | (1L << (TIMEZONE - 218)) | (1L << (TIMEZONE_HOUR - 218)) | (1L << (TIMEZONE_MINUTE - 218)) | (1L << (TRIM - 218)) | (1L << (TO - 218)) | (1L << (TYPE - 218)) | (1L << (UNKNOWN - 218)) | (1L << (UNLOGGED - 218)) | (1L << (USER - 218)) | (1L << (VALID - 218)) | (1L << (VALIDATE - 218)) | (1L << (VALUES - 218)) | (1L << (VAR_SAMP - 218)) | (1L << (VAR_POP - 218)) | (1L << (VARYING - 218)) | (1L << (VERSION - 218)) | (1L << (VOLATILE - 218)) | (1L << (WEEK - 218)) | (1L << (WINDOW - 218)) | (1L << (WRAPPER - 218)) | (1L << (YEAR - 218)) | (1L << (ZONE - 218)) | (1L << (BOOLEAN - 218)))) != 0) || ((((_la - 282)) & ~0x3f) == 0 && ((1L << (_la - 282)) & ((1L << (BOOL - 282)) | (1L << (BIT - 282)) | (1L << (VARBIT - 282)) | (1L << (INT1 - 282)) | (1L << (INT2 - 282)) | (1L << (INT4 - 282)) | (1L << (INT8 - 282)) | (1L << (TINYINT - 282)) | (1L << (SMALLINT - 282)) | (1L << (INT - 282)) | (1L << (INTEGER - 282)) | (1L << (BIGINT - 282)) | (1L << (FLOAT4 - 282)) | (1L << (FLOAT8 - 282)) | (1L << (REAL - 282)) | (1L << (FLOAT - 282)) | (1L << (DOUBLE - 282)) | (1L << (NUMERIC - 282)) | (1L << (DECIMAL - 282)) | (1L << (CHAR - 282)) | (1L << (VARCHAR - 282)) | (1L << (NCHAR - 282)) | (1L << (NVARCHAR - 282)) | (1L << (DATE - 282)) | (1L << (TIME - 282)) | (1L << (TIMETZ - 282)) | (1L << (TIMESTAMP - 282)) | (1L << (TIMESTAMPTZ - 282)) | (1L << (TEXT - 282)) | (1L << (UUID - 282)) | (1L << (VARBINARY - 282)) | (1L << (BLOB - 282)) | (1L << (BYTEA - 282)) | (1L << (INET4 - 282)) | (1L << (INTERVAL - 282)) | (1L << (VOID - 282)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
					setState(2420); match(RIGHT_PAREN);
					}
				}

				setState(2424); storage_parameter_oid();
				setState(2425); on_commit();
				setState(2426); table_space();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_column_definitionContext extends ParserRuleContext {
		public IdentifierContext column_name;
		public Data_typeContext datatype;
		public IdentifierContext collation;
		public Column_constraintContext colmn_constraint;
		public TerminalNode COLLATE() { return getToken(SQLParser.COLLATE, 0); }
		public List<Column_constraintContext> column_constraint() {
			return getRuleContexts(Column_constraintContext.class);
		}
		public Column_constraintContext column_constraint(int i) {
			return getRuleContext(Column_constraintContext.class,i);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Table_column_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_column_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_column_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_column_definition(this);
		}
	}

	public final Table_column_definitionContext table_column_definition() throws RecognitionException {
		Table_column_definitionContext _localctx = new Table_column_definitionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_table_column_definition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2430); ((Table_column_definitionContext)_localctx).column_name = identifier();
			setState(2431); ((Table_column_definitionContext)_localctx).datatype = data_type();
			setState(2434);
			_la = _input.LA(1);
			if (_la==COLLATE) {
				{
				setState(2432); match(COLLATE);
				setState(2433); ((Table_column_definitionContext)_localctx).collation = identifier();
				}
			}

			setState(2439);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,332,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2436); ((Table_column_definitionContext)_localctx).colmn_constraint = column_constraint();
					}
					} 
				}
				setState(2441);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,332,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Like_optionContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public TerminalNode INDEXES() { return getToken(SQLParser.INDEXES, 0); }
		public TerminalNode CONSTRAINTS() { return getToken(SQLParser.CONSTRAINTS, 0); }
		public TerminalNode DEFAULTS() { return getToken(SQLParser.DEFAULTS, 0); }
		public TerminalNode COMMENTS() { return getToken(SQLParser.COMMENTS, 0); }
		public TerminalNode STORAGE() { return getToken(SQLParser.STORAGE, 0); }
		public TerminalNode EXCLUDING() { return getToken(SQLParser.EXCLUDING, 0); }
		public TerminalNode INCLUDING() { return getToken(SQLParser.INCLUDING, 0); }
		public Like_optionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_like_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterLike_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitLike_option(this);
		}
	}

	public final Like_optionContext like_option() throws RecognitionException {
		Like_optionContext _localctx = new Like_optionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2442);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(2443);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << CONSTRAINTS) | (1L << DEFAULTS))) != 0) || _la==COMMENTS || _la==INDEXES || _la==STORAGE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_constraintContext extends ParserRuleContext {
		public IdentifierContext constraint_name;
		public IdentifierContext column_name_unique;
		public Index_parametersContext index_parameters_unique;
		public IdentifierContext column_name_pr_key;
		public Index_parametersContext index_parameters_pr_key;
		public IdentifierContext index_method;
		public IdentifierContext exclude_element;
		public IdentifierContext operator;
		public IdentifierContext predicat;
		public IdentifierContext column_name_for_key;
		public IdentifierContext reftable;
		public IdentifierContext refcolumn;
		public ActionContext action_on_delete;
		public ActionContext action_on_update;
		public TerminalNode DEFERRED() { return getToken(SQLParser.DEFERRED, 0); }
		public TerminalNode FULL() { return getToken(SQLParser.FULL, 0); }
		public TerminalNode DEFERRABLE() { return getToken(SQLParser.DEFERRABLE, 0); }
		public Check_boolean_expressionContext check_boolean_expression() {
			return getRuleContext(Check_boolean_expressionContext.class,0);
		}
		public Index_parametersContext index_parameters() {
			return getRuleContext(Index_parametersContext.class,0);
		}
		public TerminalNode KEY() { return getToken(SQLParser.KEY, 0); }
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public TerminalNode PARTIAL() { return getToken(SQLParser.PARTIAL, 0); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public TerminalNode INITIALLY() { return getToken(SQLParser.INITIALLY, 0); }
		public List<TerminalNode> ON() { return getTokens(SQLParser.ON); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public TerminalNode SIMPLE() { return getToken(SQLParser.SIMPLE, 0); }
		public TerminalNode DELETE() { return getToken(SQLParser.DELETE, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode UPDATE() { return getToken(SQLParser.UPDATE, 0); }
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode IMMEDIATE() { return getToken(SQLParser.IMMEDIATE, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode EXCLUDE() { return getToken(SQLParser.EXCLUDE, 0); }
		public TerminalNode ON(int i) {
			return getToken(SQLParser.ON, i);
		}
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public TerminalNode REFERENCES() { return getToken(SQLParser.REFERENCES, 0); }
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public TerminalNode MATCH() { return getToken(SQLParser.MATCH, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public TerminalNode PRIMARY() { return getToken(SQLParser.PRIMARY, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode FOREIGN() { return getToken(SQLParser.FOREIGN, 0); }
		public Table_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_constraint(this);
		}
	}

	public final Table_constraintContext table_constraint() throws RecognitionException {
		Table_constraintContext _localctx = new Table_constraintContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2447);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2445); match(CONSTRAINT);
				setState(2446); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2547);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(2449); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(2450); match(UNIQUE);
				setState(2451); match(LEFT_PAREN);
				setState(2456); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2452); ((Table_constraintContext)_localctx).column_name_unique = identifier();
					setState(2454);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2453); match(COMMA);
						}
					}

					}
					}
					setState(2458); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(2460); match(RIGHT_PAREN);
				setState(2461); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2463); match(PRIMARY);
				setState(2464); match(KEY);
				setState(2465); match(LEFT_PAREN);
				setState(2470); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2466); ((Table_constraintContext)_localctx).column_name_pr_key = identifier();
					setState(2468);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2467); match(COMMA);
						}
					}

					}
					}
					setState(2472); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(2474); match(RIGHT_PAREN);
				setState(2475); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(2477); match(EXCLUDE);
				setState(2480);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(2478); match(USING);
					setState(2479); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(2482); match(LEFT_PAREN);
				setState(2483); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(2484); match(WITH);
				setState(2489); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2485); ((Table_constraintContext)_localctx).operator = identifier();
					setState(2487);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2486); match(COMMA);
						}
					}

					}
					}
					setState(2491); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(2493); match(RIGHT_PAREN);
				setState(2494); index_parameters();
				setState(2500);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(2495); match(WHERE);
					setState(2496); match(LEFT_PAREN);
					setState(2497); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(2498); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(2502); match(FOREIGN);
				setState(2503); match(KEY);
				setState(2504); match(LEFT_PAREN);
				setState(2509); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2505); ((Table_constraintContext)_localctx).column_name_for_key = identifier();
					setState(2507);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2506); match(COMMA);
						}
					}

					}
					}
					setState(2511); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
				setState(2513); match(RIGHT_PAREN);
				setState(2514); match(REFERENCES);
				setState(2515); ((Table_constraintContext)_localctx).reftable = identifier();
				setState(2527);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2516); match(LEFT_PAREN);
					setState(2521); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2517); ((Table_constraintContext)_localctx).refcolumn = identifier();
						setState(2519);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2518); match(COMMA);
							}
						}

						}
						}
						setState(2523); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
					setState(2525); match(RIGHT_PAREN);
					}
				}

				setState(2535);
				switch ( getInterpreter().adaptivePredict(_input,347,_ctx) ) {
				case 1:
					{
					{
					setState(2529); match(MATCH);
					setState(2530); match(FULL);
					}
					}
					break;
				case 2:
					{
					{
					setState(2531); match(MATCH);
					setState(2532); match(PARTIAL);
					}
					}
					break;
				case 3:
					{
					{
					setState(2533); match(MATCH);
					setState(2534); match(SIMPLE);
					}
					}
					break;
				}
				setState(2540);
				switch ( getInterpreter().adaptivePredict(_input,348,_ctx) ) {
				case 1:
					{
					setState(2537); match(ON);
					setState(2538); match(DELETE);
					setState(2539); ((Table_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2545);
				switch ( getInterpreter().adaptivePredict(_input,349,_ctx) ) {
				case 1:
					{
					setState(2542); match(ON);
					setState(2543); match(UPDATE);
					setState(2544); ((Table_constraintContext)_localctx).action_on_update = action();
					}
					break;
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2552);
			switch ( getInterpreter().adaptivePredict(_input,351,_ctx) ) {
			case 1:
				{
				setState(2549); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2550); match(NOT);
				setState(2551); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2558);
			switch ( getInterpreter().adaptivePredict(_input,352,_ctx) ) {
			case 1:
				{
				{
				setState(2554); match(INITIALLY);
				setState(2555); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2556); match(INITIALLY);
				setState(2557); match(IMMEDIATE);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_constraintContext extends ParserRuleContext {
		public IdentifierContext constraint_name;
		public Data_typeContext default_expr_data;
		public Value_expressionContext default_expr;
		public Index_parametersContext index_params_unique;
		public Index_parametersContext index_params_pr_key;
		public Schema_qualified_nameContext reftable;
		public IdentifierContext refcolumn;
		public ActionContext action_on_delete;
		public ActionContext action_on_update;
		public TerminalNode DEFERRED() { return getToken(SQLParser.DEFERRED, 0); }
		public TerminalNode FULL() { return getToken(SQLParser.FULL, 0); }
		public TerminalNode DEFERRABLE() { return getToken(SQLParser.DEFERRABLE, 0); }
		public Check_boolean_expressionContext check_boolean_expression() {
			return getRuleContext(Check_boolean_expressionContext.class,0);
		}
		public Index_parametersContext index_parameters() {
			return getRuleContext(Index_parametersContext.class,0);
		}
		public TerminalNode KEY() { return getToken(SQLParser.KEY, 0); }
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public TerminalNode PARTIAL() { return getToken(SQLParser.PARTIAL, 0); }
		public TerminalNode INITIALLY() { return getToken(SQLParser.INITIALLY, 0); }
		public List<TerminalNode> ON() { return getTokens(SQLParser.ON); }
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public TerminalNode NOT(int i) {
			return getToken(SQLParser.NOT, i);
		}
		public TerminalNode DELETE() { return getToken(SQLParser.DELETE, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode SIMPLE() { return getToken(SQLParser.SIMPLE, 0); }
		public TerminalNode UPDATE() { return getToken(SQLParser.UPDATE, 0); }
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public TerminalNode IMMEDIATE() { return getToken(SQLParser.IMMEDIATE, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode ON(int i) {
			return getToken(SQLParser.ON, i);
		}
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public TerminalNode REFERENCES() { return getToken(SQLParser.REFERENCES, 0); }
		public TerminalNode MATCH() { return getToken(SQLParser.MATCH, 0); }
		public List<TerminalNode> NOT() { return getTokens(SQLParser.NOT); }
		public TerminalNode PRIMARY() { return getToken(SQLParser.PRIMARY, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Column_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumn_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumn_constraint(this);
		}
	}

	public final Column_constraintContext column_constraint() throws RecognitionException {
		Column_constraintContext _localctx = new Column_constraintContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2562);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2560); match(CONSTRAINT);
				setState(2561); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2599);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(2564); match(NOT);
				setState(2565); match(NULL);
				}
				break;
			case NULL:
				{
				setState(2566); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(2567); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				setState(2568); match(DEFAULT);
				setState(2571);
				switch ( getInterpreter().adaptivePredict(_input,354,_ctx) ) {
				case 1:
					{
					setState(2569); ((Column_constraintContext)_localctx).default_expr_data = data_type();
					}
					break;
				case 2:
					{
					setState(2570); ((Column_constraintContext)_localctx).default_expr = value_expression();
					}
					break;
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(2573); match(UNIQUE);
				setState(2574); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2575); match(PRIMARY);
				setState(2576); match(KEY);
				setState(2577); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(2578); match(REFERENCES);
				setState(2579); ((Column_constraintContext)_localctx).reftable = schema_qualified_name();
				{
				{
				setState(2580); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(2587);
				switch ( getInterpreter().adaptivePredict(_input,355,_ctx) ) {
				case 1:
					{
					setState(2581); match(MATCH);
					setState(2582); match(FULL);
					}
					break;
				case 2:
					{
					setState(2583); match(MATCH);
					setState(2584); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(2585); match(MATCH);
					setState(2586); match(SIMPLE);
					}
					break;
				}
				setState(2592);
				switch ( getInterpreter().adaptivePredict(_input,356,_ctx) ) {
				case 1:
					{
					setState(2589); match(ON);
					setState(2590); match(DELETE);
					setState(2591); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2597);
				switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
				case 1:
					{
					setState(2594); match(ON);
					setState(2595); match(UPDATE);
					setState(2596); ((Column_constraintContext)_localctx).action_on_update = action();
					}
					break;
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2604);
			switch ( getInterpreter().adaptivePredict(_input,359,_ctx) ) {
			case 1:
				{
				setState(2601); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2602); match(NOT);
				setState(2603); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2610);
			switch ( getInterpreter().adaptivePredict(_input,360,_ctx) ) {
			case 1:
				{
				{
				setState(2606); match(INITIALLY);
				setState(2607); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2608); match(INITIALLY);
				setState(2609); match(IMMEDIATE);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Check_boolean_expressionContext extends ParserRuleContext {
		public Boolean_value_expressionContext expression;
		public TerminalNode CHECK() { return getToken(SQLParser.CHECK, 0); }
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Check_boolean_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_check_boolean_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCheck_boolean_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCheck_boolean_expression(this);
		}
	}

	public final Check_boolean_expressionContext check_boolean_expression() throws RecognitionException {
		Check_boolean_expressionContext _localctx = new Check_boolean_expressionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_check_boolean_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2612); match(CHECK);
			setState(2613); match(LEFT_PAREN);
			setState(2614); ((Check_boolean_expressionContext)_localctx).expression = boolean_value_expression();
			setState(2615); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Storage_parameterContext extends ParserRuleContext {
		public IdentifierContext storage_param;
		public IdentifierContext value;
		public TerminalNode EQUAL(int i) {
			return getToken(SQLParser.EQUAL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<TerminalNode> EQUAL() { return getTokens(SQLParser.EQUAL); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Storage_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storage_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterStorage_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitStorage_parameter(this);
		}
	}

	public final Storage_parameterContext storage_parameter() throws RecognitionException {
		Storage_parameterContext _localctx = new Storage_parameterContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2617); match(LEFT_PAREN);
			setState(2626); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2618); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(2621);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(2619); match(EQUAL);
					setState(2620); ((Storage_parameterContext)_localctx).value = identifier();
					}
				}

				setState(2624);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2623); match(COMMA);
					}
				}

				}
				}
				setState(2628); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0) || ((((_la - 347)) & ~0x3f) == 0 && ((1L << (_la - 347)) & ((1L << (DOUBLE_QUOTE - 347)) | (1L << (Identifier - 347)) | (1L << (QuotedIdentifier - 347)))) != 0) );
			setState(2630); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class With_storage_parameterContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public Storage_parameterContext storage_parameter() {
			return getRuleContext(Storage_parameterContext.class,0);
		}
		public With_storage_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_storage_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterWith_storage_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitWith_storage_parameter(this);
		}
	}

	public final With_storage_parameterContext with_storage_parameter() throws RecognitionException {
		With_storage_parameterContext _localctx = new With_storage_parameterContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_with_storage_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2632); match(WITH);
			setState(2633); storage_parameter();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Storage_parameter_oidContext extends ParserRuleContext {
		public TerminalNode OIDS() { return getToken(SQLParser.OIDS, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode WITHOUT() { return getToken(SQLParser.WITHOUT, 0); }
		public With_storage_parameterContext with_storage_parameter() {
			return getRuleContext(With_storage_parameterContext.class,0);
		}
		public Storage_parameter_oidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storage_parameter_oid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterStorage_parameter_oid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitStorage_parameter_oid(this);
		}
	}

	public final Storage_parameter_oidContext storage_parameter_oid() throws RecognitionException {
		Storage_parameter_oidContext _localctx = new Storage_parameter_oidContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2640);
			switch ( getInterpreter().adaptivePredict(_input,364,_ctx) ) {
			case 1:
				{
				setState(2635); with_storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(2636); match(WITH);
				setState(2637); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(2638); match(WITHOUT);
				setState(2639); match(OIDS);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class On_commitContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode ROWS() { return getToken(SQLParser.ROWS, 0); }
		public TerminalNode PRESERVE() { return getToken(SQLParser.PRESERVE, 0); }
		public TerminalNode COMMIT() { return getToken(SQLParser.COMMIT, 0); }
		public TerminalNode DELETE() { return getToken(SQLParser.DELETE, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public On_commitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_on_commit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOn_commit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOn_commit(this);
		}
	}

	public final On_commitContext on_commit() throws RecognitionException {
		On_commitContext _localctx = new On_commitContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2651);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(2642); match(ON);
				setState(2643); match(COMMIT);
				setState(2649);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(2644); match(PRESERVE);
					setState(2645); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(2646); match(DELETE);
					setState(2647); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(2648); match(DROP);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_spaceContext extends ParserRuleContext {
		public IdentifierContext tablespace;
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Table_spaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_space; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_space(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_space(this);
		}
	}

	public final Table_spaceContext table_space() throws RecognitionException {
		Table_spaceContext _localctx = new Table_spaceContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_table_space);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2655);
			_la = _input.LA(1);
			if (_la==TABLESPACE) {
				{
				setState(2653); match(TABLESPACE);
				setState(2654); ((Table_spaceContext)_localctx).tablespace = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public TerminalNode CASCADE() { return getToken(SQLParser.CASCADE, 0); }
		public TerminalNode RESTRICT() { return getToken(SQLParser.RESTRICT, 0); }
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2663);
			switch ( getInterpreter().adaptivePredict(_input,368,_ctx) ) {
			case 1:
				{
				setState(2657); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(2658); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(2659); match(SET);
				setState(2660); match(NULL);
				}
				break;
			case 4:
				{
				setState(2661); match(SET);
				setState(2662); match(DEFAULT);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_parametersContext extends ParserRuleContext {
		public IdentifierContext tablespace;
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public With_storage_parameterContext with_storage_parameter() {
			return getRuleContext(With_storage_parameterContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public Index_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIndex_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIndex_parameters(this);
		}
	}

	public final Index_parametersContext index_parameters() throws RecognitionException {
		Index_parametersContext _localctx = new Index_parametersContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2666);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2665); with_storage_parameter();
				}
			}

			setState(2672);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(2668); match(USING);
				setState(2669); match(INDEX);
				setState(2670); match(TABLESPACE);
				setState(2671); ((Index_parametersContext)_localctx).tablespace = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_elementsContext extends ParserRuleContext {
		public Field_elementContext field_element(int i) {
			return getRuleContext(Field_elementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Field_elementContext> field_element() {
			return getRuleContexts(Field_elementContext.class);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Table_elementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_elements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_elements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_elements(this);
		}
	}

	public final Table_elementsContext table_elements() throws RecognitionException {
		Table_elementsContext _localctx = new Table_elementsContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2674); match(LEFT_PAREN);
			setState(2675); field_element();
			setState(2680);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2676); match(COMMA);
				setState(2677); field_element();
				}
				}
				setState(2682);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2683); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_elementContext extends ParserRuleContext {
		public IdentifierContext name;
		public Field_typeContext field_type() {
			return getRuleContext(Field_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Field_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterField_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitField_element(this);
		}
	}

	public final Field_elementContext field_element() throws RecognitionException {
		Field_elementContext _localctx = new Field_elementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2685); ((Field_elementContext)_localctx).name = identifier();
			setState(2686); field_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_typeContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public Field_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterField_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitField_type(this);
		}
	}

	public final Field_typeContext field_type() throws RecognitionException {
		Field_typeContext _localctx = new Field_typeContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2688); data_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_clauseContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Param_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterParam_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitParam_clause(this);
		}
	}

	public final Param_clauseContext param_clause() throws RecognitionException {
		Param_clauseContext _localctx = new Param_clauseContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2690); match(WITH);
			setState(2691); match(LEFT_PAREN);
			setState(2692); param();
			setState(2697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2693); match(COMMA);
				setState(2694); param();
				}
				}
				setState(2699);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2700); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public Token key;
		public Numeric_value_expressionContext value;
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2702); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(2703); match(EQUAL);
			setState(2704); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_specifierContext extends ParserRuleContext {
		public IdentifierContext m;
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Method_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterMethod_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitMethod_specifier(this);
		}
	}

	public final Method_specifierContext method_specifier() throws RecognitionException {
		Method_specifierContext _localctx = new Method_specifierContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2706); match(USING);
			setState(2707); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_space_specifierContext extends ParserRuleContext {
		public Table_space_nameContext table_space_name() {
			return getRuleContext(Table_space_nameContext.class,0);
		}
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public Table_space_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_space_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_space_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_space_specifier(this);
		}
	}

	public final Table_space_specifierContext table_space_specifier() throws RecognitionException {
		Table_space_specifierContext _localctx = new Table_space_specifierContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2709); match(TABLESPACE);
			setState(2710); table_space_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_space_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Table_space_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_space_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_space_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_space_name(this);
		}
	}

	public final Table_space_nameContext table_space_name() throws RecognitionException {
		Table_space_nameContext _localctx = new Table_space_nameContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2712); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_partitioning_clausesContext extends ParserRuleContext {
		public Column_partitionsContext column_partitions() {
			return getRuleContext(Column_partitionsContext.class,0);
		}
		public Hash_partitionsContext hash_partitions() {
			return getRuleContext(Hash_partitionsContext.class,0);
		}
		public List_partitionsContext list_partitions() {
			return getRuleContext(List_partitionsContext.class,0);
		}
		public Range_partitionsContext range_partitions() {
			return getRuleContext(Range_partitionsContext.class,0);
		}
		public Table_partitioning_clausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_partitioning_clauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_partitioning_clauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_partitioning_clauses(this);
		}
	}

	public final Table_partitioning_clausesContext table_partitioning_clauses() throws RecognitionException {
		Table_partitioning_clausesContext _localctx = new Table_partitioning_clausesContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_table_partitioning_clauses);
		try {
			setState(2718);
			switch ( getInterpreter().adaptivePredict(_input,373,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2714); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2715); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2716); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2717); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Range_partitionsContext extends ParserRuleContext {
		public TerminalNode RANGE() { return getToken(SQLParser.RANGE, 0); }
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Range_value_clause_listContext range_value_clause_list() {
			return getRuleContext(Range_value_clause_listContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public Range_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_partitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRange_partitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRange_partitions(this);
		}
	}

	public final Range_partitionsContext range_partitions() throws RecognitionException {
		Range_partitionsContext _localctx = new Range_partitionsContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2720); match(PARTITION);
			setState(2721); match(BY);
			setState(2722); match(RANGE);
			setState(2723); match(LEFT_PAREN);
			setState(2724); column_reference_list();
			setState(2725); match(RIGHT_PAREN);
			setState(2726); match(LEFT_PAREN);
			setState(2727); range_value_clause_list();
			setState(2728); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Range_value_clause_listContext extends ParserRuleContext {
		public Range_value_clauseContext range_value_clause(int i) {
			return getRuleContext(Range_value_clauseContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Range_value_clauseContext> range_value_clause() {
			return getRuleContexts(Range_value_clauseContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Range_value_clause_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_value_clause_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRange_value_clause_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRange_value_clause_list(this);
		}
	}

	public final Range_value_clause_listContext range_value_clause_list() throws RecognitionException {
		Range_value_clause_listContext _localctx = new Range_value_clause_listContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2730); range_value_clause();
			setState(2735);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2731); match(COMMA);
				setState(2732); range_value_clause();
				}
				}
				setState(2737);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Range_value_clauseContext extends ParserRuleContext {
		public TerminalNode THAN() { return getToken(SQLParser.THAN, 0); }
		public TerminalNode LESS() { return getToken(SQLParser.LESS, 0); }
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public Partition_nameContext partition_name() {
			return getRuleContext(Partition_nameContext.class,0);
		}
		public TerminalNode MAXVALUE() { return getToken(SQLParser.MAXVALUE, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public Range_value_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_value_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRange_value_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRange_value_clause(this);
		}
	}

	public final Range_value_clauseContext range_value_clause() throws RecognitionException {
		Range_value_clauseContext _localctx = new Range_value_clauseContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2738); match(PARTITION);
			setState(2739); partition_name();
			setState(2740); match(VALUES);
			setState(2741); match(LESS);
			setState(2742); match(THAN);
			setState(2754);
			switch ( getInterpreter().adaptivePredict(_input,377,_ctx) ) {
			case 1:
				{
				setState(2743); match(LEFT_PAREN);
				setState(2744); value_expression();
				setState(2745); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(2748);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2747); match(LEFT_PAREN);
					}
				}

				setState(2750); match(MAXVALUE);
				setState(2752);
				switch ( getInterpreter().adaptivePredict(_input,376,_ctx) ) {
				case 1:
					{
					setState(2751); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Hash_partitionsContext extends ParserRuleContext {
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public Hash_partitions_by_quantityContext hash_partitions_by_quantity() {
			return getRuleContext(Hash_partitions_by_quantityContext.class,0);
		}
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Individual_hash_partitionsContext individual_hash_partitions() {
			return getRuleContext(Individual_hash_partitionsContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode HASH() { return getToken(SQLParser.HASH, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public Hash_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hash_partitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterHash_partitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitHash_partitions(this);
		}
	}

	public final Hash_partitionsContext hash_partitions() throws RecognitionException {
		Hash_partitionsContext _localctx = new Hash_partitionsContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2756); match(PARTITION);
			setState(2757); match(BY);
			setState(2758); match(HASH);
			setState(2759); match(LEFT_PAREN);
			setState(2760); column_reference_list();
			setState(2761); match(RIGHT_PAREN);
			setState(2767);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(2762); match(LEFT_PAREN);
				setState(2763); individual_hash_partitions();
				setState(2764); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(2766); hash_partitions_by_quantity();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Individual_hash_partitionsContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Individual_hash_partitionContext> individual_hash_partition() {
			return getRuleContexts(Individual_hash_partitionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Individual_hash_partitionContext individual_hash_partition(int i) {
			return getRuleContext(Individual_hash_partitionContext.class,i);
		}
		public Individual_hash_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_individual_hash_partitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIndividual_hash_partitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIndividual_hash_partitions(this);
		}
	}

	public final Individual_hash_partitionsContext individual_hash_partitions() throws RecognitionException {
		Individual_hash_partitionsContext _localctx = new Individual_hash_partitionsContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2769); individual_hash_partition();
			setState(2774);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2770); match(COMMA);
				setState(2771); individual_hash_partition();
				}
				}
				setState(2776);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Individual_hash_partitionContext extends ParserRuleContext {
		public Partition_nameContext partition_name() {
			return getRuleContext(Partition_nameContext.class,0);
		}
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public Individual_hash_partitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_individual_hash_partition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIndividual_hash_partition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIndividual_hash_partition(this);
		}
	}

	public final Individual_hash_partitionContext individual_hash_partition() throws RecognitionException {
		Individual_hash_partitionContext _localctx = new Individual_hash_partitionContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2777); match(PARTITION);
			setState(2778); partition_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Hash_partitions_by_quantityContext extends ParserRuleContext {
		public Numeric_value_expressionContext quantity;
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public TerminalNode PARTITIONS() { return getToken(SQLParser.PARTITIONS, 0); }
		public Hash_partitions_by_quantityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hash_partitions_by_quantity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterHash_partitions_by_quantity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitHash_partitions_by_quantity(this);
		}
	}

	public final Hash_partitions_by_quantityContext hash_partitions_by_quantity() throws RecognitionException {
		Hash_partitions_by_quantityContext _localctx = new Hash_partitions_by_quantityContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2780); match(PARTITIONS);
			setState(2781); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_partitionsContext extends ParserRuleContext {
		public List_value_clause_listContext list_value_clause_list() {
			return getRuleContext(List_value_clause_listContext.class,0);
		}
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode LIST() { return getToken(SQLParser.LIST, 0); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public List_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_partitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterList_partitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitList_partitions(this);
		}
	}

	public final List_partitionsContext list_partitions() throws RecognitionException {
		List_partitionsContext _localctx = new List_partitionsContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2783); match(PARTITION);
			setState(2784); match(BY);
			setState(2785); match(LIST);
			setState(2786); match(LEFT_PAREN);
			setState(2787); column_reference_list();
			setState(2788); match(RIGHT_PAREN);
			setState(2789); match(LEFT_PAREN);
			setState(2790); list_value_clause_list();
			setState(2791); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_value_clause_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<List_value_partitionContext> list_value_partition() {
			return getRuleContexts(List_value_partitionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List_value_partitionContext list_value_partition(int i) {
			return getRuleContext(List_value_partitionContext.class,i);
		}
		public List_value_clause_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_value_clause_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterList_value_clause_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitList_value_clause_list(this);
		}
	}

	public final List_value_clause_listContext list_value_clause_list() throws RecognitionException {
		List_value_clause_listContext _localctx = new List_value_clause_listContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2793); list_value_partition();
			setState(2798);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2794); match(COMMA);
				setState(2795); list_value_partition();
				}
				}
				setState(2800);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_value_partitionContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public In_value_listContext in_value_list() {
			return getRuleContext(In_value_listContext.class,0);
		}
		public Partition_nameContext partition_name() {
			return getRuleContext(Partition_nameContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public List_value_partitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_value_partition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterList_value_partition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitList_value_partition(this);
		}
	}

	public final List_value_partitionContext list_value_partition() throws RecognitionException {
		List_value_partitionContext _localctx = new List_value_partitionContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2801); match(PARTITION);
			setState(2802); partition_name();
			setState(2803); match(VALUES);
			setState(2805);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(2804); match(IN);
				}
			}

			setState(2807); match(LEFT_PAREN);
			setState(2808); in_value_list();
			setState(2809); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_partitionsContext extends ParserRuleContext {
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public Table_elementsContext table_elements() {
			return getRuleContext(Table_elementsContext.class,0);
		}
		public Column_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_partitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumn_partitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumn_partitions(this);
		}
	}

	public final Column_partitionsContext column_partitions() throws RecognitionException {
		Column_partitionsContext _localctx = new Column_partitionsContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2811); match(PARTITION);
			setState(2812); match(BY);
			setState(2813); match(COLUMN);
			setState(2814); table_elements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Partition_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Partition_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPartition_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPartition_name(this);
		}
	}

	public final Partition_nameContext partition_name() throws RecognitionException {
		Partition_nameContext _localctx = new Partition_nameContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2816); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_table_statementContext extends ParserRuleContext {
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode PURGE() { return getToken(SQLParser.PURGE, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Drop_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDrop_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDrop_table_statement(this);
		}
	}

	public final Drop_table_statementContext drop_table_statement() throws RecognitionException {
		Drop_table_statementContext _localctx = new Drop_table_statementContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_drop_table_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2818); match(DROP);
			setState(2819); match(TABLE);
			setState(2820); schema_qualified_name();
			setState(2822);
			_la = _input.LA(1);
			if (_la==PURGE) {
				{
				setState(2821); match(PURGE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode QuotedIdentifier() { return getToken(SQLParser.QuotedIdentifier, 0); }
		public Nonreserved_keywordsContext nonreserved_keywords() {
			return getRuleContext(Nonreserved_keywordsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SQLParser.Identifier, 0); }
		public TerminalNode DOUBLE_QUOTE(int i) {
			return getToken(SQLParser.DOUBLE_QUOTE, i);
		}
		public List<TerminalNode> DOUBLE_QUOTE() { return getTokens(SQLParser.DOUBLE_QUOTE); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_identifier);
		int _la;
		try {
			setState(2833);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2824); match(Identifier);
				}
				break;
			case QuotedIdentifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(2825); match(QuotedIdentifier);
				}
				break;
			case ADMIN:
			case ALWAYS:
			case AVG:
			case BETWEEN:
			case BY:
			case CACHE:
			case CALLED:
			case CLASS:
			case CENTURY:
			case CHARACTER:
			case CHECK:
			case CLUSTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COMMENT:
			case COMMENTS:
			case COMMIT:
			case CONFIGURATION:
			case COST:
			case COUNT:
			case CUBE:
			case CURRENT:
			case CYCLE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
			case DEFINER:
			case DICTIONARY:
			case DISABLE:
			case DOW:
			case DOY:
			case DROP:
			case ENABLE:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTENDED:
			case EXTERNAL:
			case EXTRACT:
			case FAMILY:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INHERIT:
			case INDEX:
			case INCREMENT:
			case INPUT:
			case INSERT:
			case INTERSECTION:
			case ISCACHABLE:
			case ISODOW:
			case ISOYEAR:
			case ISSTRICT:
			case LANGUAGE:
			case LARGE:
			case LAST:
			case LESS:
			case LIST:
			case LOCATION:
			case MAIN:
			case MATCH:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINVALUE:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NO:
			case NONE:
			case NULLIF:
			case OBJECT:
			case ON:
			case ONLY:
			case OPTION:
			case OPTIONS:
			case OVERWRITE:
			case PARSER:
			case PARTIAL:
			case PARTITION:
			case PARTITIONS:
			case PLAIN:
			case PRECISION:
			case PUBLIC:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RENAME:
			case REPLICA:
			case RESET:
			case RLIKE:
			case ROLLUP:
			case SEARCH:
			case SECOND:
			case SECURITY:
			case SERVER:
			case SET:
			case SIMILAR:
			case SIMPLE:
			case STABLE:
			case START:
			case STATISTICS:
			case STORAGE:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case TEMPLATE:
			case THAN:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case TYPE:
			case UNKNOWN:
			case UNLOGGED:
			case USER:
			case VALID:
			case VALIDATE:
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case VERSION:
			case VOLATILE:
			case WEEK:
			case WINDOW:
			case WRAPPER:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case DECIMAL:
			case CHAR:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case UUID:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case INTERVAL:
			case VOID:
			case DOUBLE_QUOTE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2827);
				_la = _input.LA(1);
				if (_la==DOUBLE_QUOTE) {
					{
					setState(2826); match(DOUBLE_QUOTE);
					}
				}

				setState(2829); nonreserved_keywords();
				setState(2831);
				switch ( getInterpreter().adaptivePredict(_input,384,_ctx) ) {
				case 1:
					{
					setState(2830); match(DOUBLE_QUOTE);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nonreserved_keywordsContext extends ParserRuleContext {
		public TerminalNode TIMESTAMP() { return getToken(SQLParser.TIMESTAMP, 0); }
		public TerminalNode RESET() { return getToken(SQLParser.RESET, 0); }
		public TerminalNode BIT() { return getToken(SQLParser.BIT, 0); }
		public TerminalNode VAR_SAMP() { return getToken(SQLParser.VAR_SAMP, 0); }
		public TerminalNode STDDEV_POP() { return getToken(SQLParser.STDDEV_POP, 0); }
		public TerminalNode COALESCE() { return getToken(SQLParser.COALESCE, 0); }
		public TerminalNode SUM() { return getToken(SQLParser.SUM, 0); }
		public TerminalNode INT() { return getToken(SQLParser.INT, 0); }
		public TerminalNode VERSION() { return getToken(SQLParser.VERSION, 0); }
		public TerminalNode QUARTER() { return getToken(SQLParser.QUARTER, 0); }
		public TerminalNode EVERY() { return getToken(SQLParser.EVERY, 0); }
		public TerminalNode NVARCHAR() { return getToken(SQLParser.NVARCHAR, 0); }
		public TerminalNode INT1() { return getToken(SQLParser.INT1, 0); }
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public TerminalNode SECOND() { return getToken(SQLParser.SECOND, 0); }
		public TerminalNode ROLLUP() { return getToken(SQLParser.ROLLUP, 0); }
		public TerminalNode MAX() { return getToken(SQLParser.MAX, 0); }
		public TerminalNode OPTIONS() { return getToken(SQLParser.OPTIONS, 0); }
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode YEAR() { return getToken(SQLParser.YEAR, 0); }
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode SIMILAR() { return getToken(SQLParser.SIMILAR, 0); }
		public TerminalNode COST() { return getToken(SQLParser.COST, 0); }
		public TerminalNode RLIKE() { return getToken(SQLParser.RLIKE, 0); }
		public TerminalNode BYTEA() { return getToken(SQLParser.BYTEA, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode PURGE() { return getToken(SQLParser.PURGE, 0); }
		public TerminalNode INTERVAL() { return getToken(SQLParser.INTERVAL, 0); }
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public TerminalNode VARBINARY() { return getToken(SQLParser.VARBINARY, 0); }
		public TerminalNode EXTENDED() { return getToken(SQLParser.EXTENDED, 0); }
		public TerminalNode NO() { return getToken(SQLParser.NO, 0); }
		public TerminalNode VARCHAR() { return getToken(SQLParser.VARCHAR, 0); }
		public TerminalNode AVG() { return getToken(SQLParser.AVG, 0); }
		public TerminalNode INET4() { return getToken(SQLParser.INET4, 0); }
		public TerminalNode FLOAT8() { return getToken(SQLParser.FLOAT8, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode VAR_POP() { return getToken(SQLParser.VAR_POP, 0); }
		public TerminalNode CONFIGURATION() { return getToken(SQLParser.CONFIGURATION, 0); }
		public TerminalNode ISOYEAR() { return getToken(SQLParser.ISOYEAR, 0); }
		public TerminalNode MINUTE() { return getToken(SQLParser.MINUTE, 0); }
		public TerminalNode LAST() { return getToken(SQLParser.LAST, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TerminalNode PUBLIC() { return getToken(SQLParser.PUBLIC, 0); }
		public TerminalNode VALIDATE() { return getToken(SQLParser.VALIDATE, 0); }
		public TerminalNode DATA() { return getToken(SQLParser.DATA, 0); }
		public TerminalNode OVERWRITE() { return getToken(SQLParser.OVERWRITE, 0); }
		public TerminalNode NCHAR() { return getToken(SQLParser.NCHAR, 0); }
		public TerminalNode DICTIONARY() { return getToken(SQLParser.DICTIONARY, 0); }
		public TerminalNode ONLY() { return getToken(SQLParser.ONLY, 0); }
		public TerminalNode TIMEZONE_HOUR() { return getToken(SQLParser.TIMEZONE_HOUR, 0); }
		public TerminalNode TIMETZ() { return getToken(SQLParser.TIMETZ, 0); }
		public TerminalNode INHERIT() { return getToken(SQLParser.INHERIT, 0); }
		public TerminalNode CACHE() { return getToken(SQLParser.CACHE, 0); }
		public TerminalNode CHECK() { return getToken(SQLParser.CHECK, 0); }
		public TerminalNode OBJECT() { return getToken(SQLParser.OBJECT, 0); }
		public TerminalNode INPUT() { return getToken(SQLParser.INPUT, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public TerminalNode MONTH() { return getToken(SQLParser.MONTH, 0); }
		public TerminalNode BLOB() { return getToken(SQLParser.BLOB, 0); }
		public TerminalNode DEC() { return getToken(SQLParser.DEC, 0); }
		public TerminalNode INTERSECTION() { return getToken(SQLParser.INTERSECTION, 0); }
		public TerminalNode VOLATILE() { return getToken(SQLParser.VOLATILE, 0); }
		public TerminalNode TEMPLATE() { return getToken(SQLParser.TEMPLATE, 0); }
		public TerminalNode CLASS() { return getToken(SQLParser.CLASS, 0); }
		public TerminalNode LESS() { return getToken(SQLParser.LESS, 0); }
		public TerminalNode MILLENNIUM() { return getToken(SQLParser.MILLENNIUM, 0); }
		public TerminalNode SIMPLE() { return getToken(SQLParser.SIMPLE, 0); }
		public TerminalNode CALLED() { return getToken(SQLParser.CALLED, 0); }
		public TerminalNode OPTION() { return getToken(SQLParser.OPTION, 0); }
		public TerminalNode ISSTRICT() { return getToken(SQLParser.ISSTRICT, 0); }
		public TerminalNode TINYINT() { return getToken(SQLParser.TINYINT, 0); }
		public TerminalNode USER() { return getToken(SQLParser.USER, 0); }
		public TerminalNode STORAGE() { return getToken(SQLParser.STORAGE, 0); }
		public TerminalNode GROUPING() { return getToken(SQLParser.GROUPING, 0); }
		public TerminalNode ALWAYS() { return getToken(SQLParser.ALWAYS, 0); }
		public TerminalNode TIMESTAMPTZ() { return getToken(SQLParser.TIMESTAMPTZ, 0); }
		public TerminalNode NATIONAL() { return getToken(SQLParser.NATIONAL, 0); }
		public TerminalNode BETWEEN() { return getToken(SQLParser.BETWEEN, 0); }
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public TerminalNode PARSER() { return getToken(SQLParser.PARSER, 0); }
		public TerminalNode UNLOGGED() { return getToken(SQLParser.UNLOGGED, 0); }
		public TerminalNode FUSION() { return getToken(SQLParser.FUSION, 0); }
		public TerminalNode INCREMENT() { return getToken(SQLParser.INCREMENT, 0); }
		public TerminalNode SECURITY() { return getToken(SQLParser.SECURITY, 0); }
		public TerminalNode COMMIT() { return getToken(SQLParser.COMMIT, 0); }
		public TerminalNode INT2() { return getToken(SQLParser.INT2, 0); }
		public TerminalNode VARBIT() { return getToken(SQLParser.VARBIT, 0); }
		public TerminalNode REPLICA() { return getToken(SQLParser.REPLICA, 0); }
		public TerminalNode ZONE() { return getToken(SQLParser.ZONE, 0); }
		public TerminalNode WEEK() { return getToken(SQLParser.WEEK, 0); }
		public TerminalNode FAMILY() { return getToken(SQLParser.FAMILY, 0); }
		public TerminalNode FIRST() { return getToken(SQLParser.FIRST, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode NULLIF() { return getToken(SQLParser.NULLIF, 0); }
		public TerminalNode TIME() { return getToken(SQLParser.TIME, 0); }
		public TerminalNode TRIM() { return getToken(SQLParser.TRIM, 0); }
		public TerminalNode VOID() { return getToken(SQLParser.VOID, 0); }
		public TerminalNode DOUBLE() { return getToken(SQLParser.DOUBLE, 0); }
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public TerminalNode CENTURY() { return getToken(SQLParser.CENTURY, 0); }
		public TerminalNode LIST() { return getToken(SQLParser.LIST, 0); }
		public TerminalNode WRAPPER() { return getToken(SQLParser.WRAPPER, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public TerminalNode CYCLE() { return getToken(SQLParser.CYCLE, 0); }
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode ISCACHABLE() { return getToken(SQLParser.ISCACHABLE, 0); }
		public TerminalNode TYPE() { return getToken(SQLParser.TYPE, 0); }
		public TerminalNode SMALLINT() { return getToken(SQLParser.SMALLINT, 0); }
		public TerminalNode ISODOW() { return getToken(SQLParser.ISODOW, 0); }
		public TerminalNode UUID() { return getToken(SQLParser.UUID, 0); }
		public TerminalNode FORMAT() { return getToken(SQLParser.FORMAT, 0); }
		public TerminalNode WINDOW() { return getToken(SQLParser.WINDOW, 0); }
		public TerminalNode DOY() { return getToken(SQLParser.DOY, 0); }
		public TerminalNode COMMENTS() { return getToken(SQLParser.COMMENTS, 0); }
		public TerminalNode CURRENT() { return getToken(SQLParser.CURRENT, 0); }
		public TerminalNode MIN() { return getToken(SQLParser.MIN, 0); }
		public TerminalNode FILTER() { return getToken(SQLParser.FILTER, 0); }
		public TerminalNode PRECISION() { return getToken(SQLParser.PRECISION, 0); }
		public TerminalNode SUBPARTITION() { return getToken(SQLParser.SUBPARTITION, 0); }
		public TerminalNode STATISTICS() { return getToken(SQLParser.STATISTICS, 0); }
		public TerminalNode DOW() { return getToken(SQLParser.DOW, 0); }
		public TerminalNode SEARCH() { return getToken(SQLParser.SEARCH, 0); }
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public TerminalNode MINVALUE() { return getToken(SQLParser.MINVALUE, 0); }
		public TerminalNode MICROSECONDS() { return getToken(SQLParser.MICROSECONDS, 0); }
		public TerminalNode HASH() { return getToken(SQLParser.HASH, 0); }
		public TerminalNode DISABLE() { return getToken(SQLParser.DISABLE, 0); }
		public TerminalNode CLUSTER() { return getToken(SQLParser.CLUSTER, 0); }
		public TerminalNode DECIMAL() { return getToken(SQLParser.DECIMAL, 0); }
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode ENABLE() { return getToken(SQLParser.ENABLE, 0); }
		public TerminalNode THAN() { return getToken(SQLParser.THAN, 0); }
		public TerminalNode EPOCH() { return getToken(SQLParser.EPOCH, 0); }
		public TerminalNode ADMIN() { return getToken(SQLParser.ADMIN, 0); }
		public TerminalNode REGEXP() { return getToken(SQLParser.REGEXP, 0); }
		public TerminalNode TIMEZONE() { return getToken(SQLParser.TIMEZONE, 0); }
		public TerminalNode FLOAT4() { return getToken(SQLParser.FLOAT4, 0); }
		public TerminalNode CUBE() { return getToken(SQLParser.CUBE, 0); }
		public TerminalNode PARTIAL() { return getToken(SQLParser.PARTIAL, 0); }
		public TerminalNode UNKNOWN() { return getToken(SQLParser.UNKNOWN, 0); }
		public TerminalNode TIMEZONE_MINUTE() { return getToken(SQLParser.TIMEZONE_MINUTE, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode BOOLEAN() { return getToken(SQLParser.BOOLEAN, 0); }
		public TerminalNode CHARACTER() { return getToken(SQLParser.CHARACTER, 0); }
		public TerminalNode VALID() { return getToken(SQLParser.VALID, 0); }
		public TerminalNode STABLE() { return getToken(SQLParser.STABLE, 0); }
		public TerminalNode SERVER() { return getToken(SQLParser.SERVER, 0); }
		public TerminalNode REAL() { return getToken(SQLParser.REAL, 0); }
		public TerminalNode DAY() { return getToken(SQLParser.DAY, 0); }
		public TerminalNode COMMENT() { return getToken(SQLParser.COMMENT, 0); }
		public TerminalNode LANGUAGE() { return getToken(SQLParser.LANGUAGE, 0); }
		public TerminalNode PLAIN() { return getToken(SQLParser.PLAIN, 0); }
		public TerminalNode COLLECT() { return getToken(SQLParser.COLLECT, 0); }
		public TerminalNode BIGINT() { return getToken(SQLParser.BIGINT, 0); }
		public TerminalNode STDDEV_SAMP() { return getToken(SQLParser.STDDEV_SAMP, 0); }
		public TerminalNode DEFINER() { return getToken(SQLParser.DEFINER, 0); }
		public TerminalNode RANGE() { return getToken(SQLParser.RANGE, 0); }
		public TerminalNode FLOAT() { return getToken(SQLParser.FLOAT, 0); }
		public TerminalNode LARGE() { return getToken(SQLParser.LARGE, 0); }
		public TerminalNode EXTRACT() { return getToken(SQLParser.EXTRACT, 0); }
		public TerminalNode INT4() { return getToken(SQLParser.INT4, 0); }
		public TerminalNode MAXVALUE() { return getToken(SQLParser.MAXVALUE, 0); }
		public TerminalNode MILLISECONDS() { return getToken(SQLParser.MILLISECONDS, 0); }
		public TerminalNode MAIN() { return getToken(SQLParser.MAIN, 0); }
		public TerminalNode NUMERIC() { return getToken(SQLParser.NUMERIC, 0); }
		public TerminalNode BOOL() { return getToken(SQLParser.BOOL, 0); }
		public TerminalNode MATCH() { return getToken(SQLParser.MATCH, 0); }
		public TerminalNode START() { return getToken(SQLParser.START, 0); }
		public TerminalNode NONE() { return getToken(SQLParser.NONE, 0); }
		public TerminalNode INT8() { return getToken(SQLParser.INT8, 0); }
		public TerminalNode DECADE() { return getToken(SQLParser.DECADE, 0); }
		public TerminalNode INTEGER() { return getToken(SQLParser.INTEGER, 0); }
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public TerminalNode PARTITIONS() { return getToken(SQLParser.PARTITIONS, 0); }
		public Nonreserved_keywordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonreserved_keywords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNonreserved_keywords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNonreserved_keywords(this);
		}
	}

	public final Nonreserved_keywordsContext nonreserved_keywords() throws RecognitionException {
		Nonreserved_keywordsContext _localctx = new Nonreserved_keywordsContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2835);
			_la = _input.LA(1);
			if ( !(((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)) | (1L << (LARGE - 135)) | (1L << (LAST - 135)) | (1L << (LESS - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)) | (1L << (TEMPLATE - 199)) | (1L << (THAN - 199)) | (1L << (TIMEZONE - 199)) | (1L << (TIMEZONE_HOUR - 199)) | (1L << (TIMEZONE_MINUTE - 199)) | (1L << (TRIM - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INTERVAL - 263)) | (1L << (VOID - 263)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_literalContext extends ParserRuleContext {
		public General_literalContext general_literal() {
			return getRuleContext(General_literalContext.class,0);
		}
		public Unsigned_numeric_literalContext unsigned_numeric_literal() {
			return getRuleContext(Unsigned_numeric_literalContext.class,0);
		}
		public Unsigned_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnsigned_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnsigned_literal(this);
		}
	}

	public final Unsigned_literalContext unsigned_literal() throws RecognitionException {
		Unsigned_literalContext _localctx = new Unsigned_literalContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_unsigned_literal);
		try {
			setState(2839);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2837); unsigned_numeric_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
			case DATE:
			case TIME:
			case TIMESTAMP:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(2838); general_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class General_literalContext extends ParserRuleContext {
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Datetime_literalContext datetime_literal() {
			return getRuleContext(Datetime_literalContext.class,0);
		}
		public General_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGeneral_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGeneral_literal(this);
		}
	}

	public final General_literalContext general_literal() throws RecognitionException {
		General_literalContext _localctx = new General_literalContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_general_literal);
		try {
			setState(2844);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2841); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(2842); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(2843); boolean_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datetime_literalContext extends ParserRuleContext {
		public Timestamp_literalContext timestamp_literal() {
			return getRuleContext(Timestamp_literalContext.class,0);
		}
		public Date_literalContext date_literal() {
			return getRuleContext(Date_literalContext.class,0);
		}
		public Time_literalContext time_literal() {
			return getRuleContext(Time_literalContext.class,0);
		}
		public Datetime_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDatetime_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDatetime_literal(this);
		}
	}

	public final Datetime_literalContext datetime_literal() throws RecognitionException {
		Datetime_literalContext _localctx = new Datetime_literalContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_datetime_literal);
		try {
			setState(2849);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(2846); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2847); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2848); date_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Time_literalContext extends ParserRuleContext {
		public Token time_string;
		public TerminalNode TIME() { return getToken(SQLParser.TIME, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Time_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTime_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTime_literal(this);
		}
	}

	public final Time_literalContext time_literal() throws RecognitionException {
		Time_literalContext _localctx = new Time_literalContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2851); match(TIME);
			setState(2852); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Timestamp_literalContext extends ParserRuleContext {
		public Token timestamp_string;
		public TerminalNode TIMESTAMP() { return getToken(SQLParser.TIMESTAMP, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Timestamp_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timestamp_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTimestamp_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTimestamp_literal(this);
		}
	}

	public final Timestamp_literalContext timestamp_literal() throws RecognitionException {
		Timestamp_literalContext _localctx = new Timestamp_literalContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2854); match(TIMESTAMP);
			setState(2855); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Date_literalContext extends ParserRuleContext {
		public Token date_string;
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Date_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDate_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDate_literal(this);
		}
	}

	public final Date_literalContext date_literal() throws RecognitionException {
		Date_literalContext _localctx = new Date_literalContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2857); match(DATE);
			setState(2858); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_literalContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SQLParser.TRUE, 0); }
		public TerminalNode UNKNOWN() { return getToken(SQLParser.UNKNOWN, 0); }
		public TerminalNode FALSE() { return getToken(SQLParser.FALSE, 0); }
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_literal(this);
		}
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2860);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE || _la==UNKNOWN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_typeContext extends ParserRuleContext {
		public IdentifierContext value;
		public Predefined_typeContext predefined_type() {
			return getRuleContext(Predefined_typeContext.class,0);
		}
		public TerminalNode SETOF() { return getToken(SQLParser.SETOF, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Data_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterData_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitData_type(this);
		}
	}

	public final Data_typeContext data_type() throws RecognitionException {
		Data_typeContext _localctx = new Data_typeContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_data_type);
		try {
			setState(2865);
			switch (_input.LA(1)) {
			case TRIGGER:
			case CHARACTER:
			case DEC:
			case NATIONAL:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case REGCLASS:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case DECIMAL:
			case CHAR:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case UUID:
			case BINARY:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case INTERVAL:
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(2862); predefined_type();
				}
				break;
			case SETOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(2863); match(SETOF);
				setState(2864); ((Data_typeContext)_localctx).value = identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Predefined_typeContext extends ParserRuleContext {
		public TerminalNode UUID() { return getToken(SQLParser.UUID, 0); }
		public Character_string_typeContext character_string_type() {
			return getRuleContext(Character_string_typeContext.class,0);
		}
		public Network_typeContext network_type() {
			return getRuleContext(Network_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(SQLParser.VOID, 0); }
		public TerminalNode TRIGGER() { return getToken(SQLParser.TRIGGER, 0); }
		public Bit_typeContext bit_type() {
			return getRuleContext(Bit_typeContext.class,0);
		}
		public Binary_large_object_string_typeContext binary_large_object_string_type() {
			return getRuleContext(Binary_large_object_string_typeContext.class,0);
		}
		public National_character_string_typeContext national_character_string_type() {
			return getRuleContext(National_character_string_typeContext.class,0);
		}
		public Numeric_typeContext numeric_type() {
			return getRuleContext(Numeric_typeContext.class,0);
		}
		public Datetime_typeContext datetime_type() {
			return getRuleContext(Datetime_typeContext.class,0);
		}
		public Binary_typeContext binary_type() {
			return getRuleContext(Binary_typeContext.class,0);
		}
		public RegclassContext regclass() {
			return getRuleContext(RegclassContext.class,0);
		}
		public Predefined_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predefined_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPredefined_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPredefined_type(this);
		}
	}

	public final Predefined_typeContext predefined_type() throws RecognitionException {
		Predefined_typeContext _localctx = new Predefined_typeContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_predefined_type);
		try {
			setState(2880);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
			case INTERVAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(2867); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2868); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(2869); binary_large_object_string_type();
				}
				break;
			case DEC:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case DECIMAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(2870); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(2871); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(2872); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2873); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(2874); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(2875); network_type();
				}
				break;
			case REGCLASS:
				enterOuterAlt(_localctx, 10);
				{
				setState(2876); regclass();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 11);
				{
				setState(2877); match(TRIGGER);
				}
				break;
			case UUID:
				enterOuterAlt(_localctx, 12);
				{
				setState(2878); match(UUID);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 13);
				{
				setState(2879); match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegclassContext extends ParserRuleContext {
		public TerminalNode REGCLASS() { return getToken(SQLParser.REGCLASS, 0); }
		public RegclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRegclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRegclass(this);
		}
	}

	public final RegclassContext regclass() throws RecognitionException {
		RegclassContext _localctx = new RegclassContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_regclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2882); match(REGCLASS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Network_typeContext extends ParserRuleContext {
		public TerminalNode INET4() { return getToken(SQLParser.INET4, 0); }
		public Network_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_network_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNetwork_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNetwork_type(this);
		}
	}

	public final Network_typeContext network_type() throws RecognitionException {
		Network_typeContext _localctx = new Network_typeContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2884); match(INET4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Character_string_typeContext extends ParserRuleContext {
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode CHARACTER() { return getToken(SQLParser.CHARACTER, 0); }
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode VARCHAR() { return getToken(SQLParser.VARCHAR, 0); }
		public TerminalNode INTERVAL() { return getToken(SQLParser.INTERVAL, 0); }
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public Character_string_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_string_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCharacter_string_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCharacter_string_type(this);
		}
	}

	public final Character_string_typeContext character_string_type() throws RecognitionException {
		Character_string_typeContext _localctx = new Character_string_typeContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_character_string_type);
		try {
			setState(2910);
			switch ( getInterpreter().adaptivePredict(_input,396,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2886); match(CHARACTER);
				setState(2888);
				switch ( getInterpreter().adaptivePredict(_input,391,_ctx) ) {
				case 1:
					{
					setState(2887); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2890); match(CHAR);
				setState(2892);
				switch ( getInterpreter().adaptivePredict(_input,392,_ctx) ) {
				case 1:
					{
					setState(2891); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2894); match(CHARACTER);
				setState(2895); match(VARYING);
				setState(2897);
				switch ( getInterpreter().adaptivePredict(_input,393,_ctx) ) {
				case 1:
					{
					setState(2896); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2899); match(CHAR);
				setState(2900); match(VARYING);
				setState(2902);
				switch ( getInterpreter().adaptivePredict(_input,394,_ctx) ) {
				case 1:
					{
					setState(2901); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2904); match(VARCHAR);
				setState(2906);
				switch ( getInterpreter().adaptivePredict(_input,395,_ctx) ) {
				case 1:
					{
					setState(2905); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2908); match(TEXT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2909); match(INTERVAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_lengthContext extends ParserRuleContext {
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Type_lengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_length; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterType_length(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitType_length(this);
		}
	}

	public final Type_lengthContext type_length() throws RecognitionException {
		Type_lengthContext _localctx = new Type_lengthContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2912); match(LEFT_PAREN);
			setState(2913); match(NUMBER);
			setState(2914); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class National_character_string_typeContext extends ParserRuleContext {
		public TerminalNode NATIONAL() { return getToken(SQLParser.NATIONAL, 0); }
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode CHARACTER() { return getToken(SQLParser.CHARACTER, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode NVARCHAR() { return getToken(SQLParser.NVARCHAR, 0); }
		public TerminalNode NCHAR() { return getToken(SQLParser.NCHAR, 0); }
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public National_character_string_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_national_character_string_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNational_character_string_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNational_character_string_type(this);
		}
	}

	public final National_character_string_typeContext national_character_string_type() throws RecognitionException {
		National_character_string_typeContext _localctx = new National_character_string_typeContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_national_character_string_type);
		try {
			setState(2951);
			switch ( getInterpreter().adaptivePredict(_input,404,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2916); match(NATIONAL);
				setState(2917); match(CHARACTER);
				setState(2919);
				switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
				case 1:
					{
					setState(2918); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2921); match(NATIONAL);
				setState(2922); match(CHAR);
				setState(2924);
				switch ( getInterpreter().adaptivePredict(_input,398,_ctx) ) {
				case 1:
					{
					setState(2923); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2926); match(NCHAR);
				setState(2928);
				switch ( getInterpreter().adaptivePredict(_input,399,_ctx) ) {
				case 1:
					{
					setState(2927); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2930); match(NATIONAL);
				setState(2931); match(CHARACTER);
				setState(2932); match(VARYING);
				setState(2934);
				switch ( getInterpreter().adaptivePredict(_input,400,_ctx) ) {
				case 1:
					{
					setState(2933); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2936); match(NATIONAL);
				setState(2937); match(CHAR);
				setState(2938); match(VARYING);
				setState(2940);
				switch ( getInterpreter().adaptivePredict(_input,401,_ctx) ) {
				case 1:
					{
					setState(2939); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2942); match(NCHAR);
				setState(2943); match(VARYING);
				setState(2945);
				switch ( getInterpreter().adaptivePredict(_input,402,_ctx) ) {
				case 1:
					{
					setState(2944); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2947); match(NVARCHAR);
				setState(2949);
				switch ( getInterpreter().adaptivePredict(_input,403,_ctx) ) {
				case 1:
					{
					setState(2948); type_length();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_large_object_string_typeContext extends ParserRuleContext {
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode BLOB() { return getToken(SQLParser.BLOB, 0); }
		public TerminalNode BYTEA() { return getToken(SQLParser.BYTEA, 0); }
		public Binary_large_object_string_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_large_object_string_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBinary_large_object_string_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBinary_large_object_string_type(this);
		}
	}

	public final Binary_large_object_string_typeContext binary_large_object_string_type() throws RecognitionException {
		Binary_large_object_string_typeContext _localctx = new Binary_large_object_string_typeContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_binary_large_object_string_type);
		try {
			setState(2961);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(2953); match(BLOB);
				setState(2955);
				switch ( getInterpreter().adaptivePredict(_input,405,_ctx) ) {
				case 1:
					{
					setState(2954); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(2957); match(BYTEA);
				setState(2959);
				switch ( getInterpreter().adaptivePredict(_input,406,_ctx) ) {
				case 1:
					{
					setState(2958); type_length();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numeric_typeContext extends ParserRuleContext {
		public Exact_numeric_typeContext exact_numeric_type() {
			return getRuleContext(Exact_numeric_typeContext.class,0);
		}
		public Approximate_numeric_typeContext approximate_numeric_type() {
			return getRuleContext(Approximate_numeric_typeContext.class,0);
		}
		public Numeric_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNumeric_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNumeric_type(this);
		}
	}

	public final Numeric_typeContext numeric_type() throws RecognitionException {
		Numeric_typeContext _localctx = new Numeric_typeContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_numeric_type);
		try {
			setState(2965);
			switch (_input.LA(1)) {
			case DEC:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case NUMERIC:
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(2963); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2964); approximate_numeric_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exact_numeric_typeContext extends ParserRuleContext {
		public TerminalNode TINYINT() { return getToken(SQLParser.TINYINT, 0); }
		public TerminalNode INT() { return getToken(SQLParser.INT, 0); }
		public TerminalNode DEC() { return getToken(SQLParser.DEC, 0); }
		public TerminalNode INT1() { return getToken(SQLParser.INT1, 0); }
		public TerminalNode INT4() { return getToken(SQLParser.INT4, 0); }
		public TerminalNode NUMERIC() { return getToken(SQLParser.NUMERIC, 0); }
		public Precision_paramContext precision_param() {
			return getRuleContext(Precision_paramContext.class,0);
		}
		public TerminalNode INT8() { return getToken(SQLParser.INT8, 0); }
		public TerminalNode INT2() { return getToken(SQLParser.INT2, 0); }
		public TerminalNode INTEGER() { return getToken(SQLParser.INTEGER, 0); }
		public TerminalNode BIGINT() { return getToken(SQLParser.BIGINT, 0); }
		public TerminalNode DECIMAL() { return getToken(SQLParser.DECIMAL, 0); }
		public TerminalNode SMALLINT() { return getToken(SQLParser.SMALLINT, 0); }
		public Exact_numeric_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exact_numeric_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExact_numeric_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExact_numeric_type(this);
		}
	}

	public final Exact_numeric_typeContext exact_numeric_type() throws RecognitionException {
		Exact_numeric_typeContext _localctx = new Exact_numeric_typeContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_exact_numeric_type);
		try {
			setState(2988);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2967); match(NUMERIC);
				setState(2969);
				switch ( getInterpreter().adaptivePredict(_input,409,_ctx) ) {
				case 1:
					{
					setState(2968); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2971); match(DECIMAL);
				setState(2973);
				switch ( getInterpreter().adaptivePredict(_input,410,_ctx) ) {
				case 1:
					{
					setState(2972); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(2975); match(DEC);
				setState(2977);
				switch ( getInterpreter().adaptivePredict(_input,411,_ctx) ) {
				case 1:
					{
					setState(2976); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(2979); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2980); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(2981); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2982); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(2983); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(2984); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(2985); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(2986); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(2987); match(BIGINT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Approximate_numeric_typeContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(SQLParser.FLOAT, 0); }
		public Precision_paramContext precision_param() {
			return getRuleContext(Precision_paramContext.class,0);
		}
		public TerminalNode FLOAT4() { return getToken(SQLParser.FLOAT4, 0); }
		public TerminalNode DOUBLE() { return getToken(SQLParser.DOUBLE, 0); }
		public TerminalNode REAL() { return getToken(SQLParser.REAL, 0); }
		public TerminalNode PRECISION() { return getToken(SQLParser.PRECISION, 0); }
		public TerminalNode FLOAT8() { return getToken(SQLParser.FLOAT8, 0); }
		public Approximate_numeric_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_approximate_numeric_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterApproximate_numeric_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitApproximate_numeric_type(this);
		}
	}

	public final Approximate_numeric_typeContext approximate_numeric_type() throws RecognitionException {
		Approximate_numeric_typeContext _localctx = new Approximate_numeric_typeContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_approximate_numeric_type);
		try {
			setState(3000);
			switch ( getInterpreter().adaptivePredict(_input,414,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2990); match(FLOAT);
				setState(2992);
				switch ( getInterpreter().adaptivePredict(_input,413,_ctx) ) {
				case 1:
					{
					setState(2991); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2994); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2995); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2996); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2997); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2998); match(DOUBLE);
				setState(2999); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precision_paramContext extends ParserRuleContext {
		public Token precision;
		public Token scale;
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public TerminalNode NUMBER(int i) {
			return getToken(SQLParser.NUMBER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(SQLParser.NUMBER); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Precision_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precision_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPrecision_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPrecision_param(this);
		}
	}

	public final Precision_paramContext precision_param() throws RecognitionException {
		Precision_paramContext _localctx = new Precision_paramContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_precision_param);
		try {
			setState(3010);
			switch ( getInterpreter().adaptivePredict(_input,415,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3002); match(LEFT_PAREN);
				setState(3003); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(3004); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3005); match(LEFT_PAREN);
				setState(3006); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(3007); match(COMMA);
				setState(3008); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(3009); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_typeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(SQLParser.BOOL, 0); }
		public TerminalNode BOOLEAN() { return getToken(SQLParser.BOOLEAN, 0); }
		public Boolean_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_type(this);
		}
	}

	public final Boolean_typeContext boolean_type() throws RecognitionException {
		Boolean_typeContext _localctx = new Boolean_typeContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3012);
			_la = _input.LA(1);
			if ( !(_la==BOOLEAN || _la==BOOL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datetime_typeContext extends ParserRuleContext {
		public TerminalNode TIMESTAMP() { return getToken(SQLParser.TIMESTAMP, 0); }
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public List<TerminalNode> TIME() { return getTokens(SQLParser.TIME); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode TIME(int i) {
			return getToken(SQLParser.TIME, i);
		}
		public TerminalNode TIMETZ() { return getToken(SQLParser.TIMETZ, 0); }
		public TerminalNode WITHOUT() { return getToken(SQLParser.WITHOUT, 0); }
		public TerminalNode ZONE() { return getToken(SQLParser.ZONE, 0); }
		public TerminalNode TIMESTAMPTZ() { return getToken(SQLParser.TIMESTAMPTZ, 0); }
		public Datetime_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDatetime_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDatetime_type(this);
		}
	}

	public final Datetime_typeContext datetime_type() throws RecognitionException {
		Datetime_typeContext _localctx = new Datetime_typeContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_datetime_type);
		try {
			setState(3031);
			switch ( getInterpreter().adaptivePredict(_input,416,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3014); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3015); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3016); match(TIME);
				setState(3017); match(WITH);
				setState(3018); match(TIME);
				setState(3019); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3020); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3021); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3022); match(TIMESTAMP);
				setState(3023); match(WITH);
				setState(3024); match(TIME);
				setState(3025); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3026); match(TIMESTAMP);
				setState(3027); match(WITHOUT);
				setState(3028); match(TIME);
				setState(3029); match(ZONE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(3030); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bit_typeContext extends ParserRuleContext {
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode BIT() { return getToken(SQLParser.BIT, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode VARBIT() { return getToken(SQLParser.VARBIT, 0); }
		public Bit_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBit_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBit_type(this);
		}
	}

	public final Bit_typeContext bit_type() throws RecognitionException {
		Bit_typeContext _localctx = new Bit_typeContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_bit_type);
		try {
			setState(3046);
			switch ( getInterpreter().adaptivePredict(_input,420,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3033); match(BIT);
				setState(3035);
				switch ( getInterpreter().adaptivePredict(_input,417,_ctx) ) {
				case 1:
					{
					setState(3034); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3037); match(VARBIT);
				setState(3039);
				switch ( getInterpreter().adaptivePredict(_input,418,_ctx) ) {
				case 1:
					{
					setState(3038); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3041); match(BIT);
				setState(3042); match(VARYING);
				setState(3044);
				switch ( getInterpreter().adaptivePredict(_input,419,_ctx) ) {
				case 1:
					{
					setState(3043); type_length();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_typeContext extends ParserRuleContext {
		public TerminalNode VARBINARY() { return getToken(SQLParser.VARBINARY, 0); }
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode BINARY() { return getToken(SQLParser.BINARY, 0); }
		public Binary_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBinary_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBinary_type(this);
		}
	}

	public final Binary_typeContext binary_type() throws RecognitionException {
		Binary_typeContext _localctx = new Binary_typeContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_binary_type);
		try {
			setState(3061);
			switch ( getInterpreter().adaptivePredict(_input,424,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3048); match(BINARY);
				setState(3050);
				switch ( getInterpreter().adaptivePredict(_input,421,_ctx) ) {
				case 1:
					{
					setState(3049); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3052); match(BINARY);
				setState(3053); match(VARYING);
				setState(3055);
				switch ( getInterpreter().adaptivePredict(_input,422,_ctx) ) {
				case 1:
					{
					setState(3054); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3057); match(VARBINARY);
				setState(3059);
				switch ( getInterpreter().adaptivePredict(_input,423,_ctx) ) {
				case 1:
					{
					setState(3058); type_length();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_expression_primaryContext extends ParserRuleContext {
		public Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() {
			return getRuleContext(Nonparenthesized_value_expression_primaryContext.class,0);
		}
		public Parenthesized_value_expressionContext parenthesized_value_expression() {
			return getRuleContext(Parenthesized_value_expressionContext.class,0);
		}
		public Value_expression_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expression_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterValue_expression_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitValue_expression_primary(this);
		}
	}

	public final Value_expression_primaryContext value_expression_primary() throws RecognitionException {
		Value_expression_primaryContext _localctx = new Value_expression_primaryContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_value_expression_primary);
		try {
			setState(3065);
			switch ( getInterpreter().adaptivePredict(_input,425,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3063); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3064); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parenthesized_value_expressionContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Parenthesized_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesized_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterParenthesized_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitParenthesized_value_expression(this);
		}
	}

	public final Parenthesized_value_expressionContext parenthesized_value_expression() throws RecognitionException {
		Parenthesized_value_expressionContext _localctx = new Parenthesized_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3067); match(LEFT_PAREN);
			setState(3068); value_expression();
			setState(3069); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nonparenthesized_value_expression_primaryContext extends ParserRuleContext {
		public Case_expressionContext case_expression() {
			return getRuleContext(Case_expressionContext.class,0);
		}
		public Unsigned_value_specificationContext unsigned_value_specification() {
			return getRuleContext(Unsigned_value_specificationContext.class,0);
		}
		public Scalar_subqueryContext scalar_subquery() {
			return getRuleContext(Scalar_subqueryContext.class,0);
		}
		public Cast_specificationContext cast_specification() {
			return getRuleContext(Cast_specificationContext.class,0);
		}
		public Set_function_specificationContext set_function_specification() {
			return getRuleContext(Set_function_specificationContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Column_referenceContext column_reference() {
			return getRuleContext(Column_referenceContext.class,0);
		}
		public Routine_invocationContext routine_invocation() {
			return getRuleContext(Routine_invocationContext.class,0);
		}
		public Nonparenthesized_value_expression_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonparenthesized_value_expression_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNonparenthesized_value_expression_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNonparenthesized_value_expression_primary(this);
		}
	}

	public final Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() throws RecognitionException {
		Nonparenthesized_value_expression_primaryContext _localctx = new Nonparenthesized_value_expression_primaryContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(3079);
			switch ( getInterpreter().adaptivePredict(_input,426,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3071); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3072); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3073); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3074); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3075); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3076); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3077); routine_invocation();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(3078); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_value_specificationContext extends ParserRuleContext {
		public Unsigned_literalContext unsigned_literal() {
			return getRuleContext(Unsigned_literalContext.class,0);
		}
		public Unsigned_value_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_value_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnsigned_value_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnsigned_value_specification(this);
		}
	}

	public final Unsigned_value_specificationContext unsigned_value_specification() throws RecognitionException {
		Unsigned_value_specificationContext _localctx = new Unsigned_value_specificationContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3081); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_numeric_literalContext extends ParserRuleContext {
		public TerminalNode REAL_NUMBER() { return getToken(SQLParser.REAL_NUMBER, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public Unsigned_numeric_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_numeric_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnsigned_numeric_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnsigned_numeric_literal(this);
		}
	}

	public final Unsigned_numeric_literalContext unsigned_numeric_literal() throws RecognitionException {
		Unsigned_numeric_literalContext _localctx = new Unsigned_numeric_literalContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3083);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==REAL_NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_numerical_literalContext extends ParserRuleContext {
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public Unsigned_numeric_literalContext unsigned_numeric_literal() {
			return getRuleContext(Unsigned_numeric_literalContext.class,0);
		}
		public Signed_numerical_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_numerical_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSigned_numerical_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSigned_numerical_literal(this);
		}
	}

	public final Signed_numerical_literalContext signed_numerical_literal() throws RecognitionException {
		Signed_numerical_literalContext _localctx = new Signed_numerical_literalContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3086);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(3085); sign();
				}
			}

			setState(3088); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_function_specificationContext extends ParserRuleContext {
		public Aggregate_functionContext aggregate_function() {
			return getRuleContext(Aggregate_functionContext.class,0);
		}
		public Set_function_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_function_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSet_function_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSet_function_specification(this);
		}
	}

	public final Set_function_specificationContext set_function_specification() throws RecognitionException {
		Set_function_specificationContext _localctx = new Set_function_specificationContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3090); aggregate_function();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aggregate_functionContext extends ParserRuleContext {
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode MULTIPLY() { return getToken(SQLParser.MULTIPLY, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public General_set_functionContext general_set_function() {
			return getRuleContext(General_set_functionContext.class,0);
		}
		public Filter_clauseContext filter_clause() {
			return getRuleContext(Filter_clauseContext.class,0);
		}
		public Aggregate_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAggregate_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAggregate_function(this);
		}
	}

	public final Aggregate_functionContext aggregate_function() throws RecognitionException {
		Aggregate_functionContext _localctx = new Aggregate_functionContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_aggregate_function);
		try {
			setState(3100);
			switch ( getInterpreter().adaptivePredict(_input,429,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3092); match(COUNT);
				setState(3093); match(LEFT_PAREN);
				setState(3094); match(MULTIPLY);
				setState(3095); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3096); general_set_function();
				setState(3098);
				switch ( getInterpreter().adaptivePredict(_input,428,_ctx) ) {
				case 1:
					{
					setState(3097); filter_clause();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class General_set_functionContext extends ParserRuleContext {
		public Set_qualifierContext set_qualifier() {
			return getRuleContext(Set_qualifierContext.class,0);
		}
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Set_function_typeContext set_function_type() {
			return getRuleContext(Set_function_typeContext.class,0);
		}
		public General_set_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_set_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGeneral_set_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGeneral_set_function(this);
		}
	}

	public final General_set_functionContext general_set_function() throws RecognitionException {
		General_set_functionContext _localctx = new General_set_functionContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3102); set_function_type();
			setState(3103); match(LEFT_PAREN);
			setState(3105);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(3104); set_qualifier();
				}
			}

			setState(3107); value_expression();
			setState(3108); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_function_typeContext extends ParserRuleContext {
		public TerminalNode STDDEV_SAMP() { return getToken(SQLParser.STDDEV_SAMP, 0); }
		public TerminalNode STDDEV_POP() { return getToken(SQLParser.STDDEV_POP, 0); }
		public TerminalNode VAR_SAMP() { return getToken(SQLParser.VAR_SAMP, 0); }
		public TerminalNode SUM() { return getToken(SQLParser.SUM, 0); }
		public TerminalNode EVERY() { return getToken(SQLParser.EVERY, 0); }
		public TerminalNode ANY() { return getToken(SQLParser.ANY, 0); }
		public TerminalNode AVG() { return getToken(SQLParser.AVG, 0); }
		public TerminalNode INTERSECTION() { return getToken(SQLParser.INTERSECTION, 0); }
		public TerminalNode MIN() { return getToken(SQLParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(SQLParser.MAX, 0); }
		public TerminalNode VAR_POP() { return getToken(SQLParser.VAR_POP, 0); }
		public TerminalNode SOME() { return getToken(SQLParser.SOME, 0); }
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode FUSION() { return getToken(SQLParser.FUSION, 0); }
		public TerminalNode COLLECT() { return getToken(SQLParser.COLLECT, 0); }
		public Set_function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_function_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSet_function_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSet_function_type(this);
		}
	}

	public final Set_function_typeContext set_function_type() throws RecognitionException {
		Set_function_typeContext _localctx = new Set_function_typeContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3110);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & ((1L << (SOME - 110)) | (1L << (AVG - 110)) | (1L << (COLLECT - 110)) | (1L << (COUNT - 110)) | (1L << (EVERY - 110)))) != 0) || ((((_la - 180)) & ~0x3f) == 0 && ((1L << (_la - 180)) & ((1L << (FUSION - 180)) | (1L << (INTERSECTION - 180)) | (1L << (MAX - 180)) | (1L << (MIN - 180)))) != 0) || ((((_la - 251)) & ~0x3f) == 0 && ((1L << (_la - 251)) & ((1L << (STDDEV_POP - 251)) | (1L << (STDDEV_SAMP - 251)) | (1L << (SUM - 251)) | (1L << (VAR_SAMP - 251)) | (1L << (VAR_POP - 251)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Filter_clauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode FILTER() { return getToken(SQLParser.FILTER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Filter_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFilter_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFilter_clause(this);
		}
	}

	public final Filter_clauseContext filter_clause() throws RecognitionException {
		Filter_clauseContext _localctx = new Filter_clauseContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3112); match(FILTER);
			setState(3113); match(LEFT_PAREN);
			setState(3114); match(WHERE);
			setState(3115); search_condition();
			setState(3116); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Grouping_operationContext extends ParserRuleContext {
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode GROUPING() { return getToken(SQLParser.GROUPING, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Grouping_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouping_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGrouping_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGrouping_operation(this);
		}
	}

	public final Grouping_operationContext grouping_operation() throws RecognitionException {
		Grouping_operationContext _localctx = new Grouping_operationContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3118); match(GROUPING);
			setState(3119); match(LEFT_PAREN);
			setState(3120); column_reference_list();
			setState(3121); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_expressionContext extends ParserRuleContext {
		public Case_specificationContext case_specification() {
			return getRuleContext(Case_specificationContext.class,0);
		}
		public Case_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCase_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCase_expression(this);
		}
	}

	public final Case_expressionContext case_expression() throws RecognitionException {
		Case_expressionContext _localctx = new Case_expressionContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3123); case_specification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_abbreviationContext extends ParserRuleContext {
		public TerminalNode COALESCE() { return getToken(SQLParser.COALESCE, 0); }
		public Boolean_value_expressionContext boolean_value_expression(int i) {
			return getRuleContext(Boolean_value_expressionContext.class,i);
		}
		public TerminalNode NULLIF() { return getToken(SQLParser.NULLIF, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Boolean_value_expressionContext> boolean_value_expression() {
			return getRuleContexts(Boolean_value_expressionContext.class);
		}
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Case_abbreviationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_abbreviation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCase_abbreviation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCase_abbreviation(this);
		}
	}

	public final Case_abbreviationContext case_abbreviation() throws RecognitionException {
		Case_abbreviationContext _localctx = new Case_abbreviationContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_case_abbreviation);
		int _la;
		try {
			setState(3143);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(3125); match(NULLIF);
				setState(3126); match(LEFT_PAREN);
				setState(3127); numeric_value_expression();
				setState(3128); match(COMMA);
				setState(3129); boolean_value_expression();
				setState(3130); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3132); match(COALESCE);
				setState(3133); match(LEFT_PAREN);
				setState(3134); numeric_value_expression();
				setState(3137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(3135); match(COMMA);
					setState(3136); boolean_value_expression();
					}
					}
					setState(3139); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(3141); match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_specificationContext extends ParserRuleContext {
		public Searched_caseContext searched_case() {
			return getRuleContext(Searched_caseContext.class,0);
		}
		public Simple_caseContext simple_case() {
			return getRuleContext(Simple_caseContext.class,0);
		}
		public Case_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCase_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCase_specification(this);
		}
	}

	public final Case_specificationContext case_specification() throws RecognitionException {
		Case_specificationContext _localctx = new Case_specificationContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_case_specification);
		try {
			setState(3147);
			switch ( getInterpreter().adaptivePredict(_input,433,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3145); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3146); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_caseContext extends ParserRuleContext {
		public List<Simple_when_clauseContext> simple_when_clause() {
			return getRuleContexts(Simple_when_clauseContext.class);
		}
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public TerminalNode CASE() { return getToken(SQLParser.CASE, 0); }
		public Simple_when_clauseContext simple_when_clause(int i) {
			return getRuleContext(Simple_when_clauseContext.class,i);
		}
		public Else_clauseContext else_clause() {
			return getRuleContext(Else_clauseContext.class,0);
		}
		public TerminalNode END() { return getToken(SQLParser.END, 0); }
		public Simple_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_case; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSimple_case(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSimple_case(this);
		}
	}

	public final Simple_caseContext simple_case() throws RecognitionException {
		Simple_caseContext _localctx = new Simple_caseContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3149); match(CASE);
			setState(3150); boolean_value_expression();
			setState(3152); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3151); simple_when_clause();
				}
				}
				setState(3154); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(3157);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(3156); else_clause();
				}
			}

			setState(3159); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Searched_caseContext extends ParserRuleContext {
		public List<Searched_when_clauseContext> searched_when_clause() {
			return getRuleContexts(Searched_when_clauseContext.class);
		}
		public TerminalNode CASE() { return getToken(SQLParser.CASE, 0); }
		public Searched_when_clauseContext searched_when_clause(int i) {
			return getRuleContext(Searched_when_clauseContext.class,i);
		}
		public Else_clauseContext else_clause() {
			return getRuleContext(Else_clauseContext.class,0);
		}
		public TerminalNode END() { return getToken(SQLParser.END, 0); }
		public Searched_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searched_case; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSearched_case(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSearched_case(this);
		}
	}

	public final Searched_caseContext searched_case() throws RecognitionException {
		Searched_caseContext _localctx = new Searched_caseContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3161); match(CASE);
			setState(3163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3162); searched_when_clause();
				}
				}
				setState(3165); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(3168);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(3167); else_clause();
				}
			}

			setState(3170); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_when_clauseContext extends ParserRuleContext {
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SQLParser.THEN, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public TerminalNode WHEN() { return getToken(SQLParser.WHEN, 0); }
		public Simple_when_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_when_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSimple_when_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSimple_when_clause(this);
		}
	}

	public final Simple_when_clauseContext simple_when_clause() throws RecognitionException {
		Simple_when_clauseContext _localctx = new Simple_when_clauseContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3172); match(WHEN);
			setState(3173); search_condition();
			setState(3174); match(THEN);
			setState(3175); result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Searched_when_clauseContext extends ParserRuleContext {
		public Search_conditionContext c;
		public ResultContext r;
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SQLParser.THEN, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public TerminalNode WHEN() { return getToken(SQLParser.WHEN, 0); }
		public Searched_when_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searched_when_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSearched_when_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSearched_when_clause(this);
		}
	}

	public final Searched_when_clauseContext searched_when_clause() throws RecognitionException {
		Searched_when_clauseContext _localctx = new Searched_when_clauseContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3177); match(WHEN);
			setState(3178); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(3179); match(THEN);
			setState(3180); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_clauseContext extends ParserRuleContext {
		public ResultContext r;
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(SQLParser.ELSE, 0); }
		public Else_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterElse_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitElse_clause(this);
		}
	}

	public final Else_clauseContext else_clause() throws RecognitionException {
		Else_clauseContext _localctx = new Else_clauseContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3182); match(ELSE);
			setState(3183); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitResult(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_result);
		try {
			setState(3187);
			switch ( getInterpreter().adaptivePredict(_input,438,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3185); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3186); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cast_specificationContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Cast_targetContext cast_target() {
			return getRuleContext(Cast_targetContext.class,0);
		}
		public Cast_operandContext cast_operand() {
			return getRuleContext(Cast_operandContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode CAST() { return getToken(SQLParser.CAST, 0); }
		public Cast_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCast_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCast_specification(this);
		}
	}

	public final Cast_specificationContext cast_specification() throws RecognitionException {
		Cast_specificationContext _localctx = new Cast_specificationContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3189); match(CAST);
			setState(3190); match(LEFT_PAREN);
			setState(3191); cast_operand();
			setState(3192); match(AS);
			setState(3193); cast_target();
			setState(3194); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cast_operandContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public Cast_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCast_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCast_operand(this);
		}
	}

	public final Cast_operandContext cast_operand() throws RecognitionException {
		Cast_operandContext _localctx = new Cast_operandContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3196); value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cast_targetContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public Cast_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCast_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCast_target(this);
		}
	}

	public final Cast_targetContext cast_target() throws RecognitionException {
		Cast_targetContext _localctx = new Cast_targetContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3198); data_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_expressionContext extends ParserRuleContext {
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public Common_value_expressionContext common_value_expression() {
			return getRuleContext(Common_value_expressionContext.class,0);
		}
		public Row_value_expressionContext row_value_expression() {
			return getRuleContext(Row_value_expressionContext.class,0);
		}
		public Value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterValue_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitValue_expression(this);
		}
	}

	public final Value_expressionContext value_expression() throws RecognitionException {
		Value_expressionContext _localctx = new Value_expressionContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_value_expression);
		try {
			setState(3203);
			switch ( getInterpreter().adaptivePredict(_input,439,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3200); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3201); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3202); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Common_value_expressionContext extends ParserRuleContext {
		public String_value_expressionContext string_value_expression() {
			return getRuleContext(String_value_expressionContext.class,0);
		}
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Common_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCommon_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCommon_value_expression(this);
		}
	}

	public final Common_value_expressionContext common_value_expression() throws RecognitionException {
		Common_value_expressionContext _localctx = new Common_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_common_value_expression);
		try {
			setState(3208);
			switch ( getInterpreter().adaptivePredict(_input,440,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3205); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3206); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3207); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numeric_value_expressionContext extends ParserRuleContext {
		public TermContext left;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TerminalNode MINUS(int i) {
			return getToken(SQLParser.MINUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(SQLParser.MINUS); }
		public List<TerminalNode> PLUS() { return getTokens(SQLParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(SQLParser.PLUS, i);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Numeric_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNumeric_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNumeric_value_expression(this);
		}
	}

	public final Numeric_value_expressionContext numeric_value_expression() throws RecognitionException {
		Numeric_value_expressionContext _localctx = new Numeric_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_numeric_value_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3210); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(3215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,441,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3211);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(3212); ((Numeric_value_expressionContext)_localctx).right = term();
					}
					} 
				}
				setState(3217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,441,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public FactorContext left;
		public FactorContext right;
		public List<TerminalNode> MODULAR() { return getTokens(SQLParser.MODULAR); }
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TerminalNode MULTIPLY(int i) {
			return getToken(SQLParser.MULTIPLY, i);
		}
		public TerminalNode DIVIDE(int i) {
			return getToken(SQLParser.DIVIDE, i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(SQLParser.MULTIPLY); }
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(SQLParser.DIVIDE); }
		public TerminalNode MODULAR(int i) {
			return getToken(SQLParser.MODULAR, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3218); ((TermContext)_localctx).left = factor();
			setState(3223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 340)) & ~0x3f) == 0 && ((1L << (_la - 340)) & ((1L << (MULTIPLY - 340)) | (1L << (DIVIDE - 340)) | (1L << (MODULAR - 340)))) != 0)) {
				{
				{
				setState(3219);
				_la = _input.LA(1);
				if ( !(((((_la - 340)) & ~0x3f) == 0 && ((1L << (_la - 340)) & ((1L << (MULTIPLY - 340)) | (1L << (DIVIDE - 340)) | (1L << (MODULAR - 340)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3220); ((TermContext)_localctx).right = factor();
				}
				}
				setState(3225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public Numeric_primaryContext numeric_primary() {
			return getRuleContext(Numeric_primaryContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3227);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(3226); sign();
				}
			}

			setState(3229); numeric_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Numeric_value_expressionContext> numeric_value_expression() {
			return getRuleContexts(Numeric_value_expressionContext.class);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Numeric_value_expressionContext numeric_value_expression(int i) {
			return getRuleContext(Numeric_value_expressionContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3231); match(LEFT_PAREN);
			setState(3232); numeric_value_expression();
			setState(3237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3233); match(COMMA);
				setState(3234); numeric_value_expression();
				}
				}
				setState(3239);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3240); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numeric_primaryContext extends ParserRuleContext {
		public Cast_targetContext cast_target(int i) {
			return getRuleContext(Cast_targetContext.class,i);
		}
		public List<Cast_targetContext> cast_target() {
			return getRuleContexts(Cast_targetContext.class);
		}
		public Numeric_value_functionContext numeric_value_function() {
			return getRuleContext(Numeric_value_functionContext.class,0);
		}
		public List<TerminalNode> CAST_EXPRESSION() { return getTokens(SQLParser.CAST_EXPRESSION); }
		public TerminalNode CAST_EXPRESSION(int i) {
			return getToken(SQLParser.CAST_EXPRESSION, i);
		}
		public Value_expression_primaryContext value_expression_primary() {
			return getRuleContext(Value_expression_primaryContext.class,0);
		}
		public Numeric_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNumeric_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNumeric_primary(this);
		}
	}

	public final Numeric_primaryContext numeric_primary() throws RecognitionException {
		Numeric_primaryContext _localctx = new Numeric_primaryContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_numeric_primary);
		int _la;
		try {
			setState(3251);
			switch ( getInterpreter().adaptivePredict(_input,446,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3242); value_expression_primary();
				setState(3247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(3243); match(CAST_EXPRESSION);
					setState(3244); cast_target();
					}
					}
					setState(3249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3250); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SQLParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SQLParser.PLUS, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSign(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3253);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numeric_value_functionContext extends ParserRuleContext {
		public Extract_expressionContext extract_expression() {
			return getRuleContext(Extract_expressionContext.class,0);
		}
		public Numeric_value_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_value_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNumeric_value_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNumeric_value_function(this);
		}
	}

	public final Numeric_value_functionContext numeric_value_function() throws RecognitionException {
		Numeric_value_functionContext _localctx = new Numeric_value_functionContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3255); extract_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Extract_expressionContext extends ParserRuleContext {
		public Extract_fieldContext extract_field_string;
		public Extract_fieldContext extract_field() {
			return getRuleContext(Extract_fieldContext.class,0);
		}
		public TerminalNode EXTRACT() { return getToken(SQLParser.EXTRACT, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Extract_sourceContext extract_source() {
			return getRuleContext(Extract_sourceContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public Extract_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extract_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExtract_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExtract_expression(this);
		}
	}

	public final Extract_expressionContext extract_expression() throws RecognitionException {
		Extract_expressionContext _localctx = new Extract_expressionContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3257); match(EXTRACT);
			setState(3258); match(LEFT_PAREN);
			setState(3259); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(3260); match(FROM);
			setState(3261); extract_source();
			setState(3262); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Extract_fieldContext extends ParserRuleContext {
		public Extended_datetime_fieldContext extended_datetime_field() {
			return getRuleContext(Extended_datetime_fieldContext.class,0);
		}
		public Primary_datetime_fieldContext primary_datetime_field() {
			return getRuleContext(Primary_datetime_fieldContext.class,0);
		}
		public Time_zone_fieldContext time_zone_field() {
			return getRuleContext(Time_zone_fieldContext.class,0);
		}
		public Extract_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extract_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExtract_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExtract_field(this);
		}
	}

	public final Extract_fieldContext extract_field() throws RecognitionException {
		Extract_fieldContext _localctx = new Extract_fieldContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_extract_field);
		try {
			setState(3267);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3264); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3265); time_zone_field();
				}
				break;
			case CENTURY:
			case DECADE:
			case DOW:
			case DOY:
			case EPOCH:
			case ISODOW:
			case ISOYEAR:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case QUARTER:
			case WEEK:
				enterOuterAlt(_localctx, 3);
				{
				setState(3266); extended_datetime_field();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Time_zone_fieldContext extends ParserRuleContext {
		public TerminalNode TIMEZONE_MINUTE() { return getToken(SQLParser.TIMEZONE_MINUTE, 0); }
		public TerminalNode TIMEZONE() { return getToken(SQLParser.TIMEZONE, 0); }
		public TerminalNode TIMEZONE_HOUR() { return getToken(SQLParser.TIMEZONE_HOUR, 0); }
		public Time_zone_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_zone_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTime_zone_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTime_zone_field(this);
		}
	}

	public final Time_zone_fieldContext time_zone_field() throws RecognitionException {
		Time_zone_fieldContext _localctx = new Time_zone_fieldContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3269);
			_la = _input.LA(1);
			if ( !(((((_la - 259)) & ~0x3f) == 0 && ((1L << (_la - 259)) & ((1L << (TIMEZONE - 259)) | (1L << (TIMEZONE_HOUR - 259)) | (1L << (TIMEZONE_MINUTE - 259)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Extract_sourceContext extends ParserRuleContext {
		public Column_referenceContext column_reference() {
			return getRuleContext(Column_referenceContext.class,0);
		}
		public Datetime_literalContext datetime_literal() {
			return getRuleContext(Datetime_literalContext.class,0);
		}
		public Extract_sourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extract_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExtract_source(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExtract_source(this);
		}
	}

	public final Extract_sourceContext extract_source() throws RecognitionException {
		Extract_sourceContext _localctx = new Extract_sourceContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_extract_source);
		try {
			setState(3273);
			switch ( getInterpreter().adaptivePredict(_input,448,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3271); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3272); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_value_expressionContext extends ParserRuleContext {
		public Character_value_expressionContext character_value_expression() {
			return getRuleContext(Character_value_expressionContext.class,0);
		}
		public String_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterString_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitString_value_expression(this);
		}
	}

	public final String_value_expressionContext string_value_expression() throws RecognitionException {
		String_value_expressionContext _localctx = new String_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3275); character_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Character_value_expressionContext extends ParserRuleContext {
		public List<TerminalNode> CONCATENATION_OPERATOR() { return getTokens(SQLParser.CONCATENATION_OPERATOR); }
		public List<Character_factorContext> character_factor() {
			return getRuleContexts(Character_factorContext.class);
		}
		public TerminalNode CONCATENATION_OPERATOR(int i) {
			return getToken(SQLParser.CONCATENATION_OPERATOR, i);
		}
		public Character_factorContext character_factor(int i) {
			return getRuleContext(Character_factorContext.class,i);
		}
		public Character_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCharacter_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCharacter_value_expression(this);
		}
	}

	public final Character_value_expressionContext character_value_expression() throws RecognitionException {
		Character_value_expressionContext _localctx = new Character_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3277); character_factor();
			setState(3282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(3278); match(CONCATENATION_OPERATOR);
				setState(3279); character_factor();
				}
				}
				setState(3284);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Character_factorContext extends ParserRuleContext {
		public Character_primaryContext character_primary() {
			return getRuleContext(Character_primaryContext.class,0);
		}
		public Character_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCharacter_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCharacter_factor(this);
		}
	}

	public final Character_factorContext character_factor() throws RecognitionException {
		Character_factorContext _localctx = new Character_factorContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3285); character_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Character_primaryContext extends ParserRuleContext {
		public String_value_functionContext string_value_function() {
			return getRuleContext(String_value_functionContext.class,0);
		}
		public Value_expression_primaryContext value_expression_primary() {
			return getRuleContext(Value_expression_primaryContext.class,0);
		}
		public Character_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCharacter_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCharacter_primary(this);
		}
	}

	public final Character_primaryContext character_primary() throws RecognitionException {
		Character_primaryContext _localctx = new Character_primaryContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_character_primary);
		try {
			setState(3289);
			switch ( getInterpreter().adaptivePredict(_input,450,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3287); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3288); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_value_functionContext extends ParserRuleContext {
		public Trim_functionContext trim_function() {
			return getRuleContext(Trim_functionContext.class,0);
		}
		public String_value_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_value_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterString_value_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitString_value_function(this);
		}
	}

	public final String_value_functionContext string_value_function() throws RecognitionException {
		String_value_functionContext _localctx = new String_value_functionContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3291); trim_function();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trim_functionContext extends ParserRuleContext {
		public TerminalNode TRIM() { return getToken(SQLParser.TRIM, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Trim_operandsContext trim_operands() {
			return getRuleContext(Trim_operandsContext.class,0);
		}
		public Trim_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trim_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTrim_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTrim_function(this);
		}
	}

	public final Trim_functionContext trim_function() throws RecognitionException {
		Trim_functionContext _localctx = new Trim_functionContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3293); match(TRIM);
			setState(3294); match(LEFT_PAREN);
			setState(3295); trim_operands();
			setState(3296); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trim_operandsContext extends ParserRuleContext {
		public Character_value_expressionContext trim_character;
		public Character_value_expressionContext trim_source;
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public Character_value_expressionContext character_value_expression(int i) {
			return getRuleContext(Character_value_expressionContext.class,i);
		}
		public Trim_specificationContext trim_specification() {
			return getRuleContext(Trim_specificationContext.class,0);
		}
		public List<Character_value_expressionContext> character_value_expression() {
			return getRuleContexts(Character_value_expressionContext.class);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public Trim_operandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trim_operands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTrim_operands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTrim_operands(this);
		}
	}

	public final Trim_operandsContext trim_operands() throws RecognitionException {
		Trim_operandsContext _localctx = new Trim_operandsContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_trim_operands);
		int _la;
		try {
			setState(3312);
			switch ( getInterpreter().adaptivePredict(_input,454,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3305);
				switch ( getInterpreter().adaptivePredict(_input,453,_ctx) ) {
				case 1:
					{
					setState(3299);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(3298); trim_specification();
						}
					}

					setState(3302);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LEFT - 73)) | (1L << (NULL - 73)) | (1L << (RIGHT - 73)) | (1L << (SOME - 73)) | (1L << (TRUE - 73)) | (1L << (ADMIN - 73)) | (1L << (ALWAYS - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (AVG - 137)) | (1L << (BETWEEN - 137)) | (1L << (BY - 137)) | (1L << (CACHE - 137)) | (1L << (CALLED - 137)) | (1L << (CLASS - 137)) | (1L << (CENTURY - 137)) | (1L << (CHARACTER - 137)) | (1L << (CHECK - 137)) | (1L << (CLUSTER - 137)) | (1L << (COLLECT - 137)) | (1L << (COALESCE - 137)) | (1L << (COLUMN - 137)) | (1L << (COMMENT - 137)) | (1L << (COMMENTS - 137)) | (1L << (COMMIT - 137)) | (1L << (CONFIGURATION - 137)) | (1L << (COST - 137)) | (1L << (COUNT - 137)) | (1L << (CUBE - 137)) | (1L << (CURRENT - 137)) | (1L << (CYCLE - 137)) | (1L << (DATA - 137)) | (1L << (DAY - 137)) | (1L << (DEC - 137)) | (1L << (DECADE - 137)) | (1L << (DEFINER - 137)) | (1L << (DICTIONARY - 137)) | (1L << (DISABLE - 137)) | (1L << (DOW - 137)) | (1L << (DOY - 137)) | (1L << (DROP - 137)) | (1L << (ENABLE - 137)) | (1L << (EPOCH - 137)) | (1L << (EVERY - 137)) | (1L << (EXISTS - 137)) | (1L << (EXTENDED - 137)) | (1L << (EXTERNAL - 137)) | (1L << (EXTRACT - 137)) | (1L << (FAMILY - 137)) | (1L << (FILTER - 137)) | (1L << (FIRST - 137)) | (1L << (FORMAT - 137)) | (1L << (FUSION - 137)) | (1L << (GROUPING - 137)) | (1L << (HASH - 137)) | (1L << (INHERIT - 137)) | (1L << (INDEX - 137)) | (1L << (INCREMENT - 137)) | (1L << (INPUT - 137)) | (1L << (INSERT - 137)) | (1L << (INTERSECTION - 137)) | (1L << (ISCACHABLE - 137)) | (1L << (ISODOW - 137)) | (1L << (ISOYEAR - 137)) | (1L << (ISSTRICT - 137)) | (1L << (LANGUAGE - 137)) | (1L << (LARGE - 137)) | (1L << (LAST - 137)) | (1L << (LESS - 137)) | (1L << (LIST - 137)) | (1L << (LOCATION - 137)))) != 0) || ((((_la - 201)) & ~0x3f) == 0 && ((1L << (_la - 201)) & ((1L << (MAIN - 201)) | (1L << (MATCH - 201)) | (1L << (MAX - 201)) | (1L << (MAXVALUE - 201)) | (1L << (MICROSECONDS - 201)) | (1L << (MILLENNIUM - 201)) | (1L << (MILLISECONDS - 201)) | (1L << (MIN - 201)) | (1L << (MINVALUE - 201)) | (1L << (MINUTE - 201)) | (1L << (MONTH - 201)) | (1L << (NATIONAL - 201)) | (1L << (NO - 201)) | (1L << (NONE - 201)) | (1L << (NULLIF - 201)) | (1L << (OBJECT - 201)) | (1L << (ON - 201)) | (1L << (ONLY - 201)) | (1L << (OPTION - 201)) | (1L << (OPTIONS - 201)) | (1L << (OVERWRITE - 201)) | (1L << (PARSER - 201)) | (1L << (PARTIAL - 201)) | (1L << (PARTITION - 201)) | (1L << (PARTITIONS - 201)) | (1L << (PLAIN - 201)) | (1L << (PRECISION - 201)) | (1L << (PUBLIC - 201)) | (1L << (PURGE - 201)) | (1L << (QUARTER - 201)) | (1L << (RANGE - 201)) | (1L << (REGEXP - 201)) | (1L << (RENAME - 201)) | (1L << (REPLICA - 201)) | (1L << (RESET - 201)) | (1L << (RLIKE - 201)) | (1L << (ROLLUP - 201)) | (1L << (SEARCH - 201)) | (1L << (SECOND - 201)) | (1L << (SECURITY - 201)) | (1L << (SERVER - 201)) | (1L << (SET - 201)) | (1L << (SIMILAR - 201)) | (1L << (SIMPLE - 201)) | (1L << (STABLE - 201)) | (1L << (START - 201)) | (1L << (STATISTICS - 201)) | (1L << (STORAGE - 201)) | (1L << (STDDEV_POP - 201)) | (1L << (STDDEV_SAMP - 201)) | (1L << (SUBPARTITION - 201)) | (1L << (SUM - 201)) | (1L << (TABLESPACE - 201)) | (1L << (TEMPLATE - 201)) | (1L << (THAN - 201)) | (1L << (TIMEZONE - 201)) | (1L << (TIMEZONE_HOUR - 201)) | (1L << (TIMEZONE_MINUTE - 201)) | (1L << (TRIM - 201)) | (1L << (TO - 201)) | (1L << (TYPE - 201)))) != 0) || ((((_la - 265)) & ~0x3f) == 0 && ((1L << (_la - 265)) & ((1L << (UNKNOWN - 265)) | (1L << (UNLOGGED - 265)) | (1L << (USER - 265)) | (1L << (VALID - 265)) | (1L << (VALIDATE - 265)) | (1L << (VALUES - 265)) | (1L << (VAR_SAMP - 265)) | (1L << (VAR_POP - 265)) | (1L << (VARYING - 265)) | (1L << (VERSION - 265)) | (1L << (VOLATILE - 265)) | (1L << (WEEK - 265)) | (1L << (WINDOW - 265)) | (1L << (WRAPPER - 265)) | (1L << (YEAR - 265)) | (1L << (ZONE - 265)) | (1L << (BOOLEAN - 265)) | (1L << (BOOL - 265)) | (1L << (BIT - 265)) | (1L << (VARBIT - 265)) | (1L << (INT1 - 265)) | (1L << (INT2 - 265)) | (1L << (INT4 - 265)) | (1L << (INT8 - 265)) | (1L << (TINYINT - 265)) | (1L << (SMALLINT - 265)) | (1L << (INT - 265)) | (1L << (INTEGER - 265)) | (1L << (BIGINT - 265)) | (1L << (FLOAT4 - 265)) | (1L << (FLOAT8 - 265)) | (1L << (REAL - 265)) | (1L << (FLOAT - 265)) | (1L << (DOUBLE - 265)) | (1L << (NUMERIC - 265)) | (1L << (DECIMAL - 265)) | (1L << (CHAR - 265)) | (1L << (VARCHAR - 265)) | (1L << (NCHAR - 265)) | (1L << (NVARCHAR - 265)) | (1L << (DATE - 265)) | (1L << (TIME - 265)) | (1L << (TIMETZ - 265)) | (1L << (TIMESTAMP - 265)) | (1L << (TIMESTAMPTZ - 265)) | (1L << (TEXT - 265)) | (1L << (UUID - 265)) | (1L << (VARBINARY - 265)) | (1L << (BLOB - 265)) | (1L << (BYTEA - 265)) | (1L << (INET4 - 265)) | (1L << (INTERVAL - 265)) | (1L << (VOID - 265)))) != 0) || ((((_la - 336)) & ~0x3f) == 0 && ((1L << (_la - 336)) & ((1L << (LEFT_PAREN - 336)) | (1L << (DOUBLE_QUOTE - 336)) | (1L << (NUMBER - 336)) | (1L << (REAL_NUMBER - 336)) | (1L << (Identifier - 336)) | (1L << (QuotedIdentifier - 336)) | (1L << (Character_String_Literal - 336)))) != 0)) {
						{
						setState(3301); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(3304); match(FROM);
					}
					break;
				}
				setState(3307); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3308); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(3309); match(COMMA);
				setState(3310); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trim_specificationContext extends ParserRuleContext {
		public TerminalNode BOTH() { return getToken(SQLParser.BOTH, 0); }
		public TerminalNode TRAILING() { return getToken(SQLParser.TRAILING, 0); }
		public TerminalNode LEADING() { return getToken(SQLParser.LEADING, 0); }
		public Trim_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trim_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTrim_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTrim_specification(this);
		}
	}

	public final Trim_specificationContext trim_specification() throws RecognitionException {
		Trim_specificationContext _localctx = new Trim_specificationContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3314);
			_la = _input.LA(1);
			if ( !(_la==BOTH || _la==LEADING || _la==TRAILING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_value_expressionContext extends ParserRuleContext {
		public Or_predicateContext or_predicate() {
			return getRuleContext(Or_predicateContext.class,0);
		}
		public Boolean_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_value_expression(this);
		}
	}

	public final Boolean_value_expressionContext boolean_value_expression() throws RecognitionException {
		Boolean_value_expressionContext _localctx = new Boolean_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3316); or_predicate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_predicateContext extends ParserRuleContext {
		public List<Or_predicateContext> or_predicate() {
			return getRuleContexts(Or_predicateContext.class);
		}
		public Or_predicateContext or_predicate(int i) {
			return getRuleContext(Or_predicateContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(SQLParser.OR); }
		public And_predicateContext and_predicate() {
			return getRuleContext(And_predicateContext.class,0);
		}
		public TerminalNode OR(int i) {
			return getToken(SQLParser.OR, i);
		}
		public Or_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOr_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOr_predicate(this);
		}
	}

	public final Or_predicateContext or_predicate() throws RecognitionException {
		Or_predicateContext _localctx = new Or_predicateContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3318); and_predicate();
			setState(3323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,455,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3319); match(OR);
					setState(3320); or_predicate();
					}
					} 
				}
				setState(3325);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,455,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class And_predicateContext extends ParserRuleContext {
		public Boolean_factorContext boolean_factor() {
			return getRuleContext(Boolean_factorContext.class,0);
		}
		public List<TerminalNode> AND() { return getTokens(SQLParser.AND); }
		public List<And_predicateContext> and_predicate() {
			return getRuleContexts(And_predicateContext.class);
		}
		public TerminalNode AND(int i) {
			return getToken(SQLParser.AND, i);
		}
		public And_predicateContext and_predicate(int i) {
			return getRuleContext(And_predicateContext.class,i);
		}
		public And_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAnd_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAnd_predicate(this);
		}
	}

	public final And_predicateContext and_predicate() throws RecognitionException {
		And_predicateContext _localctx = new And_predicateContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3326); boolean_factor();
			setState(3331);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,456,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3327); match(AND);
					setState(3328); and_predicate();
					}
					} 
				}
				setState(3333);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,456,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_factorContext extends ParserRuleContext {
		public Boolean_testContext boolean_test() {
			return getRuleContext(Boolean_testContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Boolean_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_factor(this);
		}
	}

	public final Boolean_factorContext boolean_factor() throws RecognitionException {
		Boolean_factorContext _localctx = new Boolean_factorContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_boolean_factor);
		try {
			setState(3337);
			switch ( getInterpreter().adaptivePredict(_input,457,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3334); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3335); match(NOT);
				setState(3336); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_testContext extends ParserRuleContext {
		public Is_clauseContext is_clause() {
			return getRuleContext(Is_clauseContext.class,0);
		}
		public Boolean_primaryContext boolean_primary() {
			return getRuleContext(Boolean_primaryContext.class,0);
		}
		public Boolean_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_test(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_test(this);
		}
	}

	public final Boolean_testContext boolean_test() throws RecognitionException {
		Boolean_testContext _localctx = new Boolean_testContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3339); boolean_primary();
			setState(3341);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(3340); is_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Is_clauseContext extends ParserRuleContext {
		public Truth_valueContext t;
		public Truth_valueContext truth_value() {
			return getRuleContext(Truth_valueContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode IS() { return getToken(SQLParser.IS, 0); }
		public Is_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIs_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIs_clause(this);
		}
	}

	public final Is_clauseContext is_clause() throws RecognitionException {
		Is_clauseContext _localctx = new Is_clauseContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3343); match(IS);
			setState(3345);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3344); match(NOT);
				}
			}

			setState(3347); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Truth_valueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SQLParser.TRUE, 0); }
		public TerminalNode UNKNOWN() { return getToken(SQLParser.UNKNOWN, 0); }
		public TerminalNode FALSE() { return getToken(SQLParser.FALSE, 0); }
		public Truth_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truth_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTruth_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTruth_value(this);
		}
	}

	public final Truth_valueContext truth_value() throws RecognitionException {
		Truth_valueContext _localctx = new Truth_valueContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3349);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE || _la==UNKNOWN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_primaryContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public Boolean_predicandContext boolean_predicand() {
			return getRuleContext(Boolean_predicandContext.class,0);
		}
		public Boolean_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_primary(this);
		}
	}

	public final Boolean_primaryContext boolean_primary() throws RecognitionException {
		Boolean_primaryContext _localctx = new Boolean_primaryContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_boolean_primary);
		try {
			setState(3353);
			switch ( getInterpreter().adaptivePredict(_input,460,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3351); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3352); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_predicandContext extends ParserRuleContext {
		public Parenthesized_boolean_value_expressionContext parenthesized_boolean_value_expression() {
			return getRuleContext(Parenthesized_boolean_value_expressionContext.class,0);
		}
		public Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() {
			return getRuleContext(Nonparenthesized_value_expression_primaryContext.class,0);
		}
		public Boolean_predicandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_predicand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBoolean_predicand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBoolean_predicand(this);
		}
	}

	public final Boolean_predicandContext boolean_predicand() throws RecognitionException {
		Boolean_predicandContext _localctx = new Boolean_predicandContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_boolean_predicand);
		try {
			setState(3357);
			switch ( getInterpreter().adaptivePredict(_input,461,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3355); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3356); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parenthesized_boolean_value_expressionContext extends ParserRuleContext {
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Parenthesized_boolean_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesized_boolean_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterParenthesized_boolean_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitParenthesized_boolean_value_expression(this);
		}
	}

	public final Parenthesized_boolean_value_expressionContext parenthesized_boolean_value_expression() throws RecognitionException {
		Parenthesized_boolean_value_expressionContext _localctx = new Parenthesized_boolean_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3359); match(LEFT_PAREN);
			setState(3360); boolean_value_expression();
			setState(3361); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_value_expressionContext extends ParserRuleContext {
		public Row_value_special_caseContext row_value_special_case() {
			return getRuleContext(Row_value_special_caseContext.class,0);
		}
		public Explicit_row_value_constructorContext explicit_row_value_constructor() {
			return getRuleContext(Explicit_row_value_constructorContext.class,0);
		}
		public Row_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_value_expression(this);
		}
	}

	public final Row_value_expressionContext row_value_expression() throws RecognitionException {
		Row_value_expressionContext _localctx = new Row_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_row_value_expression);
		try {
			setState(3365);
			switch ( getInterpreter().adaptivePredict(_input,462,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3363); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3364); explicit_row_value_constructor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_value_special_caseContext extends ParserRuleContext {
		public Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() {
			return getRuleContext(Nonparenthesized_value_expression_primaryContext.class,0);
		}
		public Row_value_special_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_special_case; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_value_special_case(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_value_special_case(this);
		}
	}

	public final Row_value_special_caseContext row_value_special_case() throws RecognitionException {
		Row_value_special_caseContext _localctx = new Row_value_special_caseContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3367); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Explicit_row_value_constructorContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Explicit_row_value_constructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicit_row_value_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExplicit_row_value_constructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExplicit_row_value_constructor(this);
		}
	}

	public final Explicit_row_value_constructorContext explicit_row_value_constructor() throws RecognitionException {
		Explicit_row_value_constructorContext _localctx = new Explicit_row_value_constructorContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3369); match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_value_predicandContext extends ParserRuleContext {
		public Row_value_special_caseContext row_value_special_case() {
			return getRuleContext(Row_value_special_caseContext.class,0);
		}
		public Row_value_constructor_predicandContext row_value_constructor_predicand() {
			return getRuleContext(Row_value_constructor_predicandContext.class,0);
		}
		public Row_value_predicandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_predicand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_value_predicand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_value_predicand(this);
		}
	}

	public final Row_value_predicandContext row_value_predicand() throws RecognitionException {
		Row_value_predicandContext _localctx = new Row_value_predicandContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_row_value_predicand);
		try {
			setState(3373);
			switch ( getInterpreter().adaptivePredict(_input,463,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3371); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3372); row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_value_constructor_predicandContext extends ParserRuleContext {
		public Boolean_predicandContext boolean_predicand() {
			return getRuleContext(Boolean_predicandContext.class,0);
		}
		public Common_value_expressionContext common_value_expression() {
			return getRuleContext(Common_value_expressionContext.class,0);
		}
		public Row_value_constructor_predicandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_constructor_predicand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_value_constructor_predicand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_value_constructor_predicand(this);
		}
	}

	public final Row_value_constructor_predicandContext row_value_constructor_predicand() throws RecognitionException {
		Row_value_constructor_predicandContext _localctx = new Row_value_constructor_predicandContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_row_value_constructor_predicand);
		try {
			setState(3377);
			switch ( getInterpreter().adaptivePredict(_input,464,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3375); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3376); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_expressionContext extends ParserRuleContext {
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public From_clauseContext from_clause() {
			return getRuleContext(From_clauseContext.class,0);
		}
		public Groupby_clauseContext groupby_clause() {
			return getRuleContext(Groupby_clauseContext.class,0);
		}
		public Limit_clauseContext limit_clause() {
			return getRuleContext(Limit_clauseContext.class,0);
		}
		public Having_clauseContext having_clause() {
			return getRuleContext(Having_clauseContext.class,0);
		}
		public Orderby_clauseContext orderby_clause() {
			return getRuleContext(Orderby_clauseContext.class,0);
		}
		public Table_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_expression(this);
		}
	}

	public final Table_expressionContext table_expression() throws RecognitionException {
		Table_expressionContext _localctx = new Table_expressionContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3379); from_clause();
			setState(3381);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(3380); where_clause();
				}
			}

			setState(3384);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(3383); groupby_clause();
				}
			}

			setState(3387);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(3386); having_clause();
				}
			}

			setState(3390);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(3389); orderby_clause();
				}
			}

			setState(3393);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(3392); limit_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class From_clauseContext extends ParserRuleContext {
		public Table_reference_listContext table_reference_list() {
			return getRuleContext(Table_reference_listContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public From_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFrom_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFrom_clause(this);
		}
	}

	public final From_clauseContext from_clause() throws RecognitionException {
		From_clauseContext _localctx = new From_clauseContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3395); match(FROM);
			setState(3396); table_reference_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_reference_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Table_referenceContext table_reference(int i) {
			return getRuleContext(Table_referenceContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<Table_referenceContext> table_reference() {
			return getRuleContexts(Table_referenceContext.class);
		}
		public Table_reference_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_reference_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_reference_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_reference_list(this);
		}
	}

	public final Table_reference_listContext table_reference_list() throws RecognitionException {
		Table_reference_listContext _localctx = new Table_reference_listContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3398); table_reference();
			setState(3403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3399); match(COMMA);
				setState(3400); table_reference();
				}
				}
				setState(3405);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_referenceContext extends ParserRuleContext {
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Table_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_reference(this);
		}
	}

	public final Table_referenceContext table_reference() throws RecognitionException {
		Table_referenceContext _localctx = new Table_referenceContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_table_reference);
		try {
			setState(3408);
			switch ( getInterpreter().adaptivePredict(_input,471,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3406); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3407); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Joined_tableContext extends ParserRuleContext {
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public List<Joined_table_primaryContext> joined_table_primary() {
			return getRuleContexts(Joined_table_primaryContext.class);
		}
		public Joined_table_primaryContext joined_table_primary(int i) {
			return getRuleContext(Joined_table_primaryContext.class,i);
		}
		public Joined_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joined_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterJoined_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitJoined_table(this);
		}
	}

	public final Joined_tableContext joined_table() throws RecognitionException {
		Joined_tableContext _localctx = new Joined_tableContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3410); table_primary();
			setState(3412); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(3411); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(3414); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,472,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Joined_table_primaryContext extends ParserRuleContext {
		public Table_primaryContext right;
		public Join_typeContext t;
		public Join_specificationContext s;
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public TerminalNode UNION() { return getToken(SQLParser.UNION, 0); }
		public Join_typeContext join_type() {
			return getRuleContext(Join_typeContext.class,0);
		}
		public TerminalNode NATURAL() { return getToken(SQLParser.NATURAL, 0); }
		public TerminalNode CROSS() { return getToken(SQLParser.CROSS, 0); }
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Join_specificationContext join_specification() {
			return getRuleContext(Join_specificationContext.class,0);
		}
		public Joined_table_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joined_table_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterJoined_table_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitJoined_table_primary(this);
		}
	}

	public final Joined_table_primaryContext joined_table_primary() throws RecognitionException {
		Joined_table_primaryContext _localctx = new Joined_table_primaryContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_joined_table_primary);
		int _la;
		try {
			setState(3435);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(3416); match(CROSS);
				setState(3417); match(JOIN);
				setState(3418); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3420);
				_la = _input.LA(1);
				if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
					{
					setState(3419); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3422); match(JOIN);
				setState(3423); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(3424); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(3426); match(NATURAL);
				setState(3428);
				_la = _input.LA(1);
				if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
					{
					setState(3427); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3430); match(JOIN);
				setState(3431); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(3432); match(UNION);
				setState(3433); match(JOIN);
				setState(3434); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cross_joinContext extends ParserRuleContext {
		public Table_primaryContext r;
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public TerminalNode CROSS() { return getToken(SQLParser.CROSS, 0); }
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Cross_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cross_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCross_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCross_join(this);
		}
	}

	public final Cross_joinContext cross_join() throws RecognitionException {
		Cross_joinContext _localctx = new Cross_joinContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3437); match(CROSS);
			setState(3438); match(JOIN);
			setState(3439); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Qualified_joinContext extends ParserRuleContext {
		public Join_typeContext t;
		public Table_primaryContext r;
		public Join_specificationContext s;
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public Join_typeContext join_type() {
			return getRuleContext(Join_typeContext.class,0);
		}
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Join_specificationContext join_specification() {
			return getRuleContext(Join_specificationContext.class,0);
		}
		public Qualified_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQualified_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQualified_join(this);
		}
	}

	public final Qualified_joinContext qualified_join() throws RecognitionException {
		Qualified_joinContext _localctx = new Qualified_joinContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3442);
			_la = _input.LA(1);
			if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
				{
				setState(3441); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(3444); match(JOIN);
			setState(3445); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(3446); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Natural_joinContext extends ParserRuleContext {
		public Join_typeContext t;
		public Table_primaryContext r;
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public Join_typeContext join_type() {
			return getRuleContext(Join_typeContext.class,0);
		}
		public TerminalNode NATURAL() { return getToken(SQLParser.NATURAL, 0); }
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Natural_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_natural_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNatural_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNatural_join(this);
		}
	}

	public final Natural_joinContext natural_join() throws RecognitionException {
		Natural_joinContext _localctx = new Natural_joinContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3448); match(NATURAL);
			setState(3450);
			_la = _input.LA(1);
			if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
				{
				setState(3449); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(3452); match(JOIN);
			setState(3453); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Union_joinContext extends ParserRuleContext {
		public Table_primaryContext r;
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public TerminalNode UNION() { return getToken(SQLParser.UNION, 0); }
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Union_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnion_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnion_join(this);
		}
	}

	public final Union_joinContext union_join() throws RecognitionException {
		Union_joinContext _localctx = new Union_joinContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3455); match(UNION);
			setState(3456); match(JOIN);
			setState(3457); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_typeContext extends ParserRuleContext {
		public Outer_join_typeContext t;
		public Outer_join_typeContext outer_join_type() {
			return getRuleContext(Outer_join_typeContext.class,0);
		}
		public TerminalNode INNER() { return getToken(SQLParser.INNER, 0); }
		public Join_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterJoin_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitJoin_type(this);
		}
	}

	public final Join_typeContext join_type() throws RecognitionException {
		Join_typeContext _localctx = new Join_typeContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_join_type);
		try {
			setState(3461);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3459); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3460); ((Join_typeContext)_localctx).t = outer_join_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outer_join_typeContext extends ParserRuleContext {
		public TerminalNode OUTER() { return getToken(SQLParser.OUTER, 0); }
		public Outer_join_type_part2Context outer_join_type_part2() {
			return getRuleContext(Outer_join_type_part2Context.class,0);
		}
		public Outer_join_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outer_join_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOuter_join_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOuter_join_type(this);
		}
	}

	public final Outer_join_typeContext outer_join_type() throws RecognitionException {
		Outer_join_typeContext _localctx = new Outer_join_typeContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3463); outer_join_type_part2();
			setState(3465);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(3464); match(OUTER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outer_join_type_part2Context extends ParserRuleContext {
		public TerminalNode FULL() { return getToken(SQLParser.FULL, 0); }
		public TerminalNode LEFT() { return getToken(SQLParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(SQLParser.RIGHT, 0); }
		public Outer_join_type_part2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outer_join_type_part2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOuter_join_type_part2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOuter_join_type_part2(this);
		}
	}

	public final Outer_join_type_part2Context outer_join_type_part2() throws RecognitionException {
		Outer_join_type_part2Context _localctx = new Outer_join_type_part2Context(_ctx, getState());
		enterRule(_localctx, 340, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3467);
			_la = _input.LA(1);
			if ( !(((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_specificationContext extends ParserRuleContext {
		public Named_columns_joinContext named_columns_join() {
			return getRuleContext(Named_columns_joinContext.class,0);
		}
		public Join_conditionContext join_condition() {
			return getRuleContext(Join_conditionContext.class,0);
		}
		public Join_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterJoin_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitJoin_specification(this);
		}
	}

	public final Join_specificationContext join_specification() throws RecognitionException {
		Join_specificationContext _localctx = new Join_specificationContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_join_specification);
		try {
			setState(3471);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(3469); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(3470); named_columns_join();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_conditionContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public Join_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterJoin_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitJoin_condition(this);
		}
	}

	public final Join_conditionContext join_condition() throws RecognitionException {
		Join_conditionContext _localctx = new Join_conditionContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3473); match(ON);
			setState(3474); search_condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Named_columns_joinContext extends ParserRuleContext {
		public Column_reference_listContext f;
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Named_columns_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_named_columns_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNamed_columns_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNamed_columns_join(this);
		}
	}

	public final Named_columns_joinContext named_columns_join() throws RecognitionException {
		Named_columns_joinContext _localctx = new Named_columns_joinContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3476); match(USING);
			setState(3477); match(LEFT_PAREN);
			setState(3478); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(3479); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_primaryContext extends ParserRuleContext {
		public IdentifierContext alias;
		public IdentifierContext name;
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Derived_tableContext derived_table() {
			return getRuleContext(Derived_tableContext.class,0);
		}
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public Table_or_query_nameContext table_or_query_name() {
			return getRuleContext(Table_or_query_nameContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Table_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_primary(this);
		}
	}

	public final Table_primaryContext table_primary() throws RecognitionException {
		Table_primaryContext _localctx = new Table_primaryContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_table_primary);
		int _la;
		try {
			setState(3505);
			switch (_input.LA(1)) {
			case ADMIN:
			case ALWAYS:
			case AVG:
			case BETWEEN:
			case BY:
			case CACHE:
			case CALLED:
			case CLASS:
			case CENTURY:
			case CHARACTER:
			case CHECK:
			case CLUSTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COMMENT:
			case COMMENTS:
			case COMMIT:
			case CONFIGURATION:
			case COST:
			case COUNT:
			case CUBE:
			case CURRENT:
			case CYCLE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
			case DEFINER:
			case DICTIONARY:
			case DISABLE:
			case DOW:
			case DOY:
			case DROP:
			case ENABLE:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTENDED:
			case EXTERNAL:
			case EXTRACT:
			case FAMILY:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INHERIT:
			case INDEX:
			case INCREMENT:
			case INPUT:
			case INSERT:
			case INTERSECTION:
			case ISCACHABLE:
			case ISODOW:
			case ISOYEAR:
			case ISSTRICT:
			case LANGUAGE:
			case LARGE:
			case LAST:
			case LESS:
			case LIST:
			case LOCATION:
			case MAIN:
			case MATCH:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINVALUE:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NO:
			case NONE:
			case NULLIF:
			case OBJECT:
			case ON:
			case ONLY:
			case OPTION:
			case OPTIONS:
			case OVERWRITE:
			case PARSER:
			case PARTIAL:
			case PARTITION:
			case PARTITIONS:
			case PLAIN:
			case PRECISION:
			case PUBLIC:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RENAME:
			case REPLICA:
			case RESET:
			case RLIKE:
			case ROLLUP:
			case SEARCH:
			case SECOND:
			case SECURITY:
			case SERVER:
			case SET:
			case SIMILAR:
			case SIMPLE:
			case STABLE:
			case START:
			case STATISTICS:
			case STORAGE:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case TEMPLATE:
			case THAN:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case TYPE:
			case UNKNOWN:
			case UNLOGGED:
			case USER:
			case VALID:
			case VALIDATE:
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case VERSION:
			case VOLATILE:
			case WEEK:
			case WINDOW:
			case WRAPPER:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case DECIMAL:
			case CHAR:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case UUID:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case INTERVAL:
			case VOID:
			case DOUBLE_QUOTE:
			case Identifier:
			case QuotedIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(3481); table_or_query_name();
				setState(3486);
				switch ( getInterpreter().adaptivePredict(_input,482,_ctx) ) {
				case 1:
					{
					setState(3483);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(3482); match(AS);
						}
					}

					setState(3485); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(3492);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3488); match(LEFT_PAREN);
					setState(3489); column_name_list();
					setState(3490); match(RIGHT_PAREN);
					}
				}

				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3494); derived_table();
				setState(3496);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3495); match(AS);
					}
				}

				setState(3498); ((Table_primaryContext)_localctx).name = identifier();
				setState(3503);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3499); match(LEFT_PAREN);
					setState(3500); column_name_list();
					setState(3501); match(RIGHT_PAREN);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_name_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Column_name_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumn_name_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumn_name_list(this);
		}
	}

	public final Column_name_listContext column_name_list() throws RecognitionException {
		Column_name_listContext _localctx = new Column_name_listContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3507); identifier();
			setState(3512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3508); match(COMMA);
				setState(3509); identifier();
				}
				}
				setState(3514);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Derived_tableContext extends ParserRuleContext {
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public Derived_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derived_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDerived_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDerived_table(this);
		}
	}

	public final Derived_tableContext derived_table() throws RecognitionException {
		Derived_tableContext _localctx = new Derived_tableContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3515); table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Where_clauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterWhere_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitWhere_clause(this);
		}
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3517); match(WHERE);
			setState(3518); search_condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Search_conditionContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public Search_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_search_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSearch_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSearch_condition(this);
		}
	}

	public final Search_conditionContext search_condition() throws RecognitionException {
		Search_conditionContext _localctx = new Search_conditionContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3520); value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Groupby_clauseContext extends ParserRuleContext {
		public Grouping_element_listContext g;
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Grouping_element_listContext grouping_element_list() {
			return getRuleContext(Grouping_element_listContext.class,0);
		}
		public TerminalNode GROUP() { return getToken(SQLParser.GROUP, 0); }
		public Groupby_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupby_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGroupby_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGroupby_clause(this);
		}
	}

	public final Groupby_clauseContext groupby_clause() throws RecognitionException {
		Groupby_clauseContext _localctx = new Groupby_clauseContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3522); match(GROUP);
			setState(3523); match(BY);
			setState(3524); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Grouping_element_listContext extends ParserRuleContext {
		public Grouping_elementContext grouping_element(int i) {
			return getRuleContext(Grouping_elementContext.class,i);
		}
		public List<Grouping_elementContext> grouping_element() {
			return getRuleContexts(Grouping_elementContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Grouping_element_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouping_element_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGrouping_element_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGrouping_element_list(this);
		}
	}

	public final Grouping_element_listContext grouping_element_list() throws RecognitionException {
		Grouping_element_listContext _localctx = new Grouping_element_listContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3526); grouping_element();
			setState(3531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3527); match(COMMA);
				setState(3528); grouping_element();
				}
				}
				setState(3533);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Grouping_elementContext extends ParserRuleContext {
		public Cube_listContext cube_list() {
			return getRuleContext(Cube_listContext.class,0);
		}
		public Empty_grouping_setContext empty_grouping_set() {
			return getRuleContext(Empty_grouping_setContext.class,0);
		}
		public Ordinary_grouping_setContext ordinary_grouping_set() {
			return getRuleContext(Ordinary_grouping_setContext.class,0);
		}
		public Rollup_listContext rollup_list() {
			return getRuleContext(Rollup_listContext.class,0);
		}
		public Grouping_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouping_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGrouping_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGrouping_element(this);
		}
	}

	public final Grouping_elementContext grouping_element() throws RecognitionException {
		Grouping_elementContext _localctx = new Grouping_elementContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_grouping_element);
		try {
			setState(3538);
			switch ( getInterpreter().adaptivePredict(_input,489,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3534); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3535); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3536); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3537); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ordinary_grouping_setContext extends ParserRuleContext {
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public Row_value_predicand_listContext row_value_predicand_list() {
			return getRuleContext(Row_value_predicand_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Ordinary_grouping_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordinary_grouping_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOrdinary_grouping_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOrdinary_grouping_set(this);
		}
	}

	public final Ordinary_grouping_setContext ordinary_grouping_set() throws RecognitionException {
		Ordinary_grouping_setContext _localctx = new Ordinary_grouping_setContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_ordinary_grouping_set);
		try {
			setState(3545);
			switch ( getInterpreter().adaptivePredict(_input,490,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3540); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3541); match(LEFT_PAREN);
				setState(3542); row_value_predicand_list();
				setState(3543); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ordinary_grouping_set_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Ordinary_grouping_setContext> ordinary_grouping_set() {
			return getRuleContexts(Ordinary_grouping_setContext.class);
		}
		public Ordinary_grouping_setContext ordinary_grouping_set(int i) {
			return getRuleContext(Ordinary_grouping_setContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Ordinary_grouping_set_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordinary_grouping_set_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOrdinary_grouping_set_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOrdinary_grouping_set_list(this);
		}
	}

	public final Ordinary_grouping_set_listContext ordinary_grouping_set_list() throws RecognitionException {
		Ordinary_grouping_set_listContext _localctx = new Ordinary_grouping_set_listContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3547); ordinary_grouping_set();
			setState(3552);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3548); match(COMMA);
				setState(3549); ordinary_grouping_set();
				}
				}
				setState(3554);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rollup_listContext extends ParserRuleContext {
		public Ordinary_grouping_set_listContext c;
		public Ordinary_grouping_set_listContext ordinary_grouping_set_list() {
			return getRuleContext(Ordinary_grouping_set_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode ROLLUP() { return getToken(SQLParser.ROLLUP, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Rollup_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rollup_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRollup_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRollup_list(this);
		}
	}

	public final Rollup_listContext rollup_list() throws RecognitionException {
		Rollup_listContext _localctx = new Rollup_listContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3555); match(ROLLUP);
			setState(3556); match(LEFT_PAREN);
			setState(3557); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3558); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cube_listContext extends ParserRuleContext {
		public Ordinary_grouping_set_listContext c;
		public Ordinary_grouping_set_listContext ordinary_grouping_set_list() {
			return getRuleContext(Ordinary_grouping_set_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode CUBE() { return getToken(SQLParser.CUBE, 0); }
		public Cube_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cube_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCube_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCube_list(this);
		}
	}

	public final Cube_listContext cube_list() throws RecognitionException {
		Cube_listContext _localctx = new Cube_listContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3560); match(CUBE);
			setState(3561); match(LEFT_PAREN);
			setState(3562); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3563); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Empty_grouping_setContext extends ParserRuleContext {
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Empty_grouping_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty_grouping_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterEmpty_grouping_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitEmpty_grouping_set(this);
		}
	}

	public final Empty_grouping_setContext empty_grouping_set() throws RecognitionException {
		Empty_grouping_setContext _localctx = new Empty_grouping_setContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3565); match(LEFT_PAREN);
			setState(3566); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Having_clauseContext extends ParserRuleContext {
		public TerminalNode HAVING() { return getToken(SQLParser.HAVING, 0); }
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public Having_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_having_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterHaving_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitHaving_clause(this);
		}
	}

	public final Having_clauseContext having_clause() throws RecognitionException {
		Having_clauseContext _localctx = new Having_clauseContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3568); match(HAVING);
			setState(3569); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_value_predicand_listContext extends ParserRuleContext {
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Row_value_predicand_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_predicand_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_value_predicand_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_value_predicand_list(this);
		}
	}

	public final Row_value_predicand_listContext row_value_predicand_list() throws RecognitionException {
		Row_value_predicand_listContext _localctx = new Row_value_predicand_listContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3571); row_value_predicand();
			setState(3576);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3572); match(COMMA);
				setState(3573); row_value_predicand();
				}
				}
				setState(3578);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Query_expressionContext extends ParserRuleContext {
		public Query_expression_bodyContext query_expression_body() {
			return getRuleContext(Query_expression_bodyContext.class,0);
		}
		public Query_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuery_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuery_expression(this);
		}
	}

	public final Query_expressionContext query_expression() throws RecognitionException {
		Query_expressionContext _localctx = new Query_expressionContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3579); query_expression_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Query_expression_bodyContext extends ParserRuleContext {
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Non_join_query_expressionContext non_join_query_expression() {
			return getRuleContext(Non_join_query_expressionContext.class,0);
		}
		public Query_expression_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_expression_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuery_expression_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuery_expression_body(this);
		}
	}

	public final Query_expression_bodyContext query_expression_body() throws RecognitionException {
		Query_expression_bodyContext _localctx = new Query_expression_bodyContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_query_expression_body);
		try {
			setState(3583);
			switch ( getInterpreter().adaptivePredict(_input,493,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3581); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3582); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Non_join_query_expressionContext extends ParserRuleContext {
		public List<TerminalNode> EXCEPT() { return getTokens(SQLParser.EXCEPT); }
		public List<TerminalNode> UNION() { return getTokens(SQLParser.UNION); }
		public List<TerminalNode> ALL() { return getTokens(SQLParser.ALL); }
		public TerminalNode EXCEPT(int i) {
			return getToken(SQLParser.EXCEPT, i);
		}
		public Query_termContext query_term(int i) {
			return getRuleContext(Query_termContext.class,i);
		}
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Non_join_query_termContext non_join_query_term() {
			return getRuleContext(Non_join_query_termContext.class,0);
		}
		public List<TerminalNode> DISTINCT() { return getTokens(SQLParser.DISTINCT); }
		public TerminalNode ALL(int i) {
			return getToken(SQLParser.ALL, i);
		}
		public TerminalNode DISTINCT(int i) {
			return getToken(SQLParser.DISTINCT, i);
		}
		public List<Query_termContext> query_term() {
			return getRuleContexts(Query_termContext.class);
		}
		public TerminalNode UNION(int i) {
			return getToken(SQLParser.UNION, i);
		}
		public Non_join_query_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_join_query_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNon_join_query_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNon_join_query_expression(this);
		}
	}

	public final Non_join_query_expressionContext non_join_query_expression() throws RecognitionException {
		Non_join_query_expressionContext _localctx = new Non_join_query_expressionContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3593);
			switch ( getInterpreter().adaptivePredict(_input,495,_ctx) ) {
			case 1:
				{
				setState(3585); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(3586); joined_table();
				setState(3587);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3589);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3588);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3591); query_term();
				}
				break;
			}
			setState(3602);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(3595);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3597);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3596);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3599); query_term();
				}
				}
				setState(3604);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Query_termContext extends ParserRuleContext {
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Non_join_query_termContext non_join_query_term() {
			return getRuleContext(Non_join_query_termContext.class,0);
		}
		public Query_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuery_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuery_term(this);
		}
	}

	public final Query_termContext query_term() throws RecognitionException {
		Query_termContext _localctx = new Query_termContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_query_term);
		try {
			setState(3607);
			switch ( getInterpreter().adaptivePredict(_input,498,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3605); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3606); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Non_join_query_termContext extends ParserRuleContext {
		public List<TerminalNode> ALL() { return getTokens(SQLParser.ALL); }
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public List<TerminalNode> DISTINCT() { return getTokens(SQLParser.DISTINCT); }
		public TerminalNode ALL(int i) {
			return getToken(SQLParser.ALL, i);
		}
		public List<Query_primaryContext> query_primary() {
			return getRuleContexts(Query_primaryContext.class);
		}
		public List<TerminalNode> INTERSECT() { return getTokens(SQLParser.INTERSECT); }
		public TerminalNode DISTINCT(int i) {
			return getToken(SQLParser.DISTINCT, i);
		}
		public Query_primaryContext query_primary(int i) {
			return getRuleContext(Query_primaryContext.class,i);
		}
		public Non_join_query_primaryContext non_join_query_primary() {
			return getRuleContext(Non_join_query_primaryContext.class,0);
		}
		public TerminalNode INTERSECT(int i) {
			return getToken(SQLParser.INTERSECT, i);
		}
		public Non_join_query_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_join_query_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNon_join_query_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNon_join_query_term(this);
		}
	}

	public final Non_join_query_termContext non_join_query_term() throws RecognitionException {
		Non_join_query_termContext _localctx = new Non_join_query_termContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3617);
			switch ( getInterpreter().adaptivePredict(_input,500,_ctx) ) {
			case 1:
				{
				setState(3609); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(3610); joined_table();
				setState(3611); match(INTERSECT);
				setState(3613);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3612);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3615); query_primary();
				}
				break;
			}
			setState(3626);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(3619); match(INTERSECT);
				setState(3621);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3620);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3623); query_primary();
				}
				}
				setState(3628);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Query_primaryContext extends ParserRuleContext {
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Non_join_query_primaryContext non_join_query_primary() {
			return getRuleContext(Non_join_query_primaryContext.class,0);
		}
		public Query_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuery_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuery_primary(this);
		}
	}

	public final Query_primaryContext query_primary() throws RecognitionException {
		Query_primaryContext _localctx = new Query_primaryContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_query_primary);
		try {
			setState(3631);
			switch ( getInterpreter().adaptivePredict(_input,503,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3629); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3630); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Non_join_query_primaryContext extends ParserRuleContext {
		public Simple_tableContext simple_table() {
			return getRuleContext(Simple_tableContext.class,0);
		}
		public Non_join_query_expressionContext non_join_query_expression() {
			return getRuleContext(Non_join_query_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Non_join_query_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_join_query_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNon_join_query_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNon_join_query_primary(this);
		}
	}

	public final Non_join_query_primaryContext non_join_query_primary() throws RecognitionException {
		Non_join_query_primaryContext _localctx = new Non_join_query_primaryContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_non_join_query_primary);
		try {
			setState(3638);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3633); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3634); match(LEFT_PAREN);
				setState(3635); non_join_query_expression();
				setState(3636); match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_tableContext extends ParserRuleContext {
		public Explicit_tableContext explicit_table() {
			return getRuleContext(Explicit_tableContext.class,0);
		}
		public Query_specificationContext query_specification() {
			return getRuleContext(Query_specificationContext.class,0);
		}
		public Simple_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSimple_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSimple_table(this);
		}
	}

	public final Simple_tableContext simple_table() throws RecognitionException {
		Simple_tableContext _localctx = new Simple_tableContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_simple_table);
		try {
			setState(3642);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(3640); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3641); explicit_table();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Explicit_tableContext extends ParserRuleContext {
		public Table_or_query_nameContext table_or_query_name() {
			return getRuleContext(Table_or_query_nameContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public Explicit_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicit_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExplicit_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExplicit_table(this);
		}
	}

	public final Explicit_tableContext explicit_table() throws RecognitionException {
		Explicit_tableContext _localctx = new Explicit_tableContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3644); match(TABLE);
			setState(3645); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_or_query_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Table_or_query_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_query_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_or_query_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_or_query_name(this);
		}
	}

	public final Table_or_query_nameContext table_or_query_name() throws RecognitionException {
		Table_or_query_nameContext _localctx = new Table_or_query_nameContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_table_or_query_name);
		try {
			setState(3649);
			switch ( getInterpreter().adaptivePredict(_input,506,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3647); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3648); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_qualified_nameContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(SQLParser.DOT); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode DOT(int i) {
			return getToken(SQLParser.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Schema_qualified_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_qualified_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSchema_qualified_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSchema_qualified_name(this);
		}
	}

	public final Schema_qualified_nameContext schema_qualified_name() throws RecognitionException {
		Schema_qualified_nameContext _localctx = new Schema_qualified_nameContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_schema_qualified_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3651); identifier();
			setState(3658);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(3652); match(DOT);
				setState(3653); identifier();
				setState(3656);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(3654); match(DOT);
					setState(3655); identifier();
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Query_specificationContext extends ParserRuleContext {
		public Table_expressionContext table_expression() {
			return getRuleContext(Table_expressionContext.class,0);
		}
		public Set_qualifierContext set_qualifier() {
			return getRuleContext(Set_qualifierContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(SQLParser.SELECT, 0); }
		public Select_listContext select_list() {
			return getRuleContext(Select_listContext.class,0);
		}
		public Query_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuery_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuery_specification(this);
		}
	}

	public final Query_specificationContext query_specification() throws RecognitionException {
		Query_specificationContext _localctx = new Query_specificationContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3660); match(SELECT);
			setState(3662);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(3661); set_qualifier();
				}
			}

			setState(3664); select_list();
			setState(3666);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(3665); table_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_listContext extends ParserRuleContext {
		public Select_sublistContext select_sublist(int i) {
			return getRuleContext(Select_sublistContext.class,i);
		}
		public List<Select_sublistContext> select_sublist() {
			return getRuleContexts(Select_sublistContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Select_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSelect_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSelect_list(this);
		}
	}

	public final Select_listContext select_list() throws RecognitionException {
		Select_listContext _localctx = new Select_listContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3668); select_sublist();
			setState(3673);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3669); match(COMMA);
				setState(3670); select_sublist();
				}
				}
				setState(3675);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_sublistContext extends ParserRuleContext {
		public Derived_columnContext derived_column() {
			return getRuleContext(Derived_columnContext.class,0);
		}
		public Qualified_asteriskContext qualified_asterisk() {
			return getRuleContext(Qualified_asteriskContext.class,0);
		}
		public Select_sublistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_sublist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSelect_sublist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSelect_sublist(this);
		}
	}

	public final Select_sublistContext select_sublist() throws RecognitionException {
		Select_sublistContext _localctx = new Select_sublistContext(_ctx, getState());
		enterRule(_localctx, 404, RULE_select_sublist);
		try {
			setState(3678);
			switch ( getInterpreter().adaptivePredict(_input,512,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3676); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3677); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Derived_columnContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public As_clauseContext as_clause() {
			return getRuleContext(As_clauseContext.class,0);
		}
		public Derived_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derived_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDerived_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDerived_column(this);
		}
	}

	public final Derived_columnContext derived_column() throws RecognitionException {
		Derived_columnContext _localctx = new Derived_columnContext(_ctx, getState());
		enterRule(_localctx, 406, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3680); value_expression();
			setState(3682);
			switch ( getInterpreter().adaptivePredict(_input,513,_ctx) ) {
			case 1:
				{
				setState(3681); as_clause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Qualified_asteriskContext extends ParserRuleContext {
		public Token tb_name;
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(SQLParser.Identifier, 0); }
		public TerminalNode MULTIPLY() { return getToken(SQLParser.MULTIPLY, 0); }
		public Qualified_asteriskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_asterisk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQualified_asterisk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQualified_asterisk(this);
		}
	}

	public final Qualified_asteriskContext qualified_asterisk() throws RecognitionException {
		Qualified_asteriskContext _localctx = new Qualified_asteriskContext(_ctx, getState());
		enterRule(_localctx, 408, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3686);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(3684); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(3685); match(DOT);
				}
			}

			setState(3688); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_qualifierContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public TerminalNode DISTINCT() { return getToken(SQLParser.DISTINCT, 0); }
		public Set_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSet_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSet_qualifier(this);
		}
	}

	public final Set_qualifierContext set_qualifier() throws RecognitionException {
		Set_qualifierContext _localctx = new Set_qualifierContext(_ctx, getState());
		enterRule(_localctx, 410, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3690);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_referenceContext extends ParserRuleContext {
		public IdentifierContext tb_name;
		public IdentifierContext name;
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Column_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumn_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumn_reference(this);
		}
	}

	public final Column_referenceContext column_reference() throws RecognitionException {
		Column_referenceContext _localctx = new Column_referenceContext(_ctx, getState());
		enterRule(_localctx, 412, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3695);
			switch ( getInterpreter().adaptivePredict(_input,515,_ctx) ) {
			case 1:
				{
				setState(3692); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(3693); match(DOT);
				}
				break;
			}
			setState(3697); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class As_clauseContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public As_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAs_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAs_clause(this);
		}
	}

	public final As_clauseContext as_clause() throws RecognitionException {
		As_clauseContext _localctx = new As_clauseContext(_ctx, getState());
		enterRule(_localctx, 414, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3700);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(3699); match(AS);
				}
			}

			setState(3702); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_reference_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Column_referenceContext column_reference(int i) {
			return getRuleContext(Column_referenceContext.class,i);
		}
		public List<Column_referenceContext> column_reference() {
			return getRuleContexts(Column_referenceContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Column_reference_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_reference_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterColumn_reference_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitColumn_reference_list(this);
		}
	}

	public final Column_reference_listContext column_reference_list() throws RecognitionException {
		Column_reference_listContext _localctx = new Column_reference_listContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3704); column_reference();
			setState(3709);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3705); match(COMMA);
				setState(3706); column_reference();
				}
				}
				setState(3711);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scalar_subqueryContext extends ParserRuleContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Scalar_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterScalar_subquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitScalar_subquery(this);
		}
	}

	public final Scalar_subqueryContext scalar_subquery() throws RecognitionException {
		Scalar_subqueryContext _localctx = new Scalar_subqueryContext(_ctx, getState());
		enterRule(_localctx, 418, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3712); subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Row_subqueryContext extends ParserRuleContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Row_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRow_subquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRow_subquery(this);
		}
	}

	public final Row_subqueryContext row_subquery() throws RecognitionException {
		Row_subqueryContext _localctx = new Row_subqueryContext(_ctx, getState());
		enterRule(_localctx, 420, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3714); subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_subqueryContext extends ParserRuleContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Table_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_subquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_subquery(this);
		}
	}

	public final Table_subqueryContext table_subquery() throws RecognitionException {
		Table_subqueryContext _localctx = new Table_subqueryContext(_ctx, getState());
		enterRule(_localctx, 422, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3716); subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubqueryContext extends ParserRuleContext {
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public SubqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSubquery(this);
		}
	}

	public final SubqueryContext subquery() throws RecognitionException {
		SubqueryContext _localctx = new SubqueryContext(_ctx, getState());
		enterRule(_localctx, 424, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3718); match(LEFT_PAREN);
			setState(3719); query_expression();
			setState(3720); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public Pattern_matching_predicateContext pattern_matching_predicate() {
			return getRuleContext(Pattern_matching_predicateContext.class,0);
		}
		public Exists_predicateContext exists_predicate() {
			return getRuleContext(Exists_predicateContext.class,0);
		}
		public In_predicateContext in_predicate() {
			return getRuleContext(In_predicateContext.class,0);
		}
		public Null_predicateContext null_predicate() {
			return getRuleContext(Null_predicateContext.class,0);
		}
		public Between_predicateContext between_predicate() {
			return getRuleContext(Between_predicateContext.class,0);
		}
		public Comparison_predicateContext comparison_predicate() {
			return getRuleContext(Comparison_predicateContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 426, RULE_predicate);
		try {
			setState(3728);
			switch ( getInterpreter().adaptivePredict(_input,518,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3722); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3723); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3724); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3725); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3726); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3727); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comparison_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext left;
		public Comp_opContext c;
		public Row_value_predicandContext right;
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public Comp_opContext comp_op() {
			return getRuleContext(Comp_opContext.class,0);
		}
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public Comparison_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterComparison_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitComparison_predicate(this);
		}
	}

	public final Comparison_predicateContext comparison_predicate() throws RecognitionException {
		Comparison_predicateContext _localctx = new Comparison_predicateContext(_ctx, getState());
		enterRule(_localctx, 428, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3730); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(3731); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(3732); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_opContext extends ParserRuleContext {
		public TerminalNode GEQ() { return getToken(SQLParser.GEQ, 0); }
		public TerminalNode GTH() { return getToken(SQLParser.GTH, 0); }
		public TerminalNode LEQ() { return getToken(SQLParser.LEQ, 0); }
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(SQLParser.NOT_EQUAL, 0); }
		public TerminalNode LTH() { return getToken(SQLParser.LTH, 0); }
		public Comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterComp_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitComp_op(this);
		}
	}

	public final Comp_opContext comp_op() throws RecognitionException {
		Comp_opContext _localctx = new Comp_opContext(_ctx, getState());
		enterRule(_localctx, 430, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3734);
			_la = _input.LA(1);
			if ( !(((((_la - 326)) & ~0x3f) == 0 && ((1L << (_la - 326)) & ((1L << (EQUAL - 326)) | (1L << (NOT_EQUAL - 326)) | (1L << (LTH - 326)) | (1L << (LEQ - 326)) | (1L << (GTH - 326)) | (1L << (GEQ - 326)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Between_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext predicand;
		public Between_predicate_part_2Context between_predicate_part_2() {
			return getRuleContext(Between_predicate_part_2Context.class,0);
		}
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public Between_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBetween_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBetween_predicate(this);
		}
	}

	public final Between_predicateContext between_predicate() throws RecognitionException {
		Between_predicateContext _localctx = new Between_predicateContext(_ctx, getState());
		enterRule(_localctx, 432, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3736); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3737); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Between_predicate_part_2Context extends ParserRuleContext {
		public Row_value_predicandContext begin;
		public Row_value_predicandContext end;
		public TerminalNode ASYMMETRIC() { return getToken(SQLParser.ASYMMETRIC, 0); }
		public TerminalNode BETWEEN() { return getToken(SQLParser.BETWEEN, 0); }
		public TerminalNode SYMMETRIC() { return getToken(SQLParser.SYMMETRIC, 0); }
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public TerminalNode AND() { return getToken(SQLParser.AND, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Between_predicate_part_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_predicate_part_2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBetween_predicate_part_2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBetween_predicate_part_2(this);
		}
	}

	public final Between_predicate_part_2Context between_predicate_part_2() throws RecognitionException {
		Between_predicate_part_2Context _localctx = new Between_predicate_part_2Context(_ctx, getState());
		enterRule(_localctx, 434, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3740);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3739); match(NOT);
				}
			}

			setState(3742); match(BETWEEN);
			setState(3744);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(3743);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(3746); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(3747); match(AND);
			setState(3748); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class In_predicateContext extends ParserRuleContext {
		public Numeric_value_expressionContext predicand;
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public In_predicate_valueContext in_predicate_value() {
			return getRuleContext(In_predicate_valueContext.class,0);
		}
		public In_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIn_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIn_predicate(this);
		}
	}

	public final In_predicateContext in_predicate() throws RecognitionException {
		In_predicateContext _localctx = new In_predicateContext(_ctx, getState());
		enterRule(_localctx, 436, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3750); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(3752);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3751); match(NOT);
				}
			}

			setState(3754); match(IN);
			setState(3755); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class In_predicate_valueContext extends ParserRuleContext {
		public In_value_listContext in_value_list() {
			return getRuleContext(In_value_listContext.class,0);
		}
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public In_predicate_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_predicate_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIn_predicate_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIn_predicate_value(this);
		}
	}

	public final In_predicate_valueContext in_predicate_value() throws RecognitionException {
		In_predicate_valueContext _localctx = new In_predicate_valueContext(_ctx, getState());
		enterRule(_localctx, 438, RULE_in_predicate_value);
		try {
			setState(3762);
			switch ( getInterpreter().adaptivePredict(_input,522,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3757); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3758); match(LEFT_PAREN);
				setState(3759); in_value_list();
				setState(3760); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class In_value_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Row_value_expressionContext row_value_expression(int i) {
			return getRuleContext(Row_value_expressionContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<Row_value_expressionContext> row_value_expression() {
			return getRuleContexts(Row_value_expressionContext.class);
		}
		public In_value_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_value_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIn_value_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIn_value_list(this);
		}
	}

	public final In_value_listContext in_value_list() throws RecognitionException {
		In_value_listContext _localctx = new In_value_listContext(_ctx, getState());
		enterRule(_localctx, 440, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3764); row_value_expression();
			setState(3769);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3765); match(COMMA);
				setState(3766); row_value_expression();
				}
				}
				setState(3771);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pattern_matching_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext f;
		public Token s;
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public Pattern_matcherContext pattern_matcher() {
			return getRuleContext(Pattern_matcherContext.class,0);
		}
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Pattern_matching_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_matching_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPattern_matching_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPattern_matching_predicate(this);
		}
	}

	public final Pattern_matching_predicateContext pattern_matching_predicate() throws RecognitionException {
		Pattern_matching_predicateContext _localctx = new Pattern_matching_predicateContext(_ctx, getState());
		enterRule(_localctx, 442, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3772); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(3773); pattern_matcher();
			setState(3774); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pattern_matcherContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Negativable_matcherContext negativable_matcher() {
			return getRuleContext(Negativable_matcherContext.class,0);
		}
		public Regex_matcherContext regex_matcher() {
			return getRuleContext(Regex_matcherContext.class,0);
		}
		public Pattern_matcherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_matcher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPattern_matcher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPattern_matcher(this);
		}
	}

	public final Pattern_matcherContext pattern_matcher() throws RecognitionException {
		Pattern_matcherContext _localctx = new Pattern_matcherContext(_ctx, getState());
		enterRule(_localctx, 444, RULE_pattern_matcher);
		int _la;
		try {
			setState(3781);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3777);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3776); match(NOT);
					}
				}

				setState(3779); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(3780); regex_matcher();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Negativable_matcherContext extends ParserRuleContext {
		public TerminalNode SIMILAR() { return getToken(SQLParser.SIMILAR, 0); }
		public TerminalNode REGEXP() { return getToken(SQLParser.REGEXP, 0); }
		public TerminalNode ILIKE() { return getToken(SQLParser.ILIKE, 0); }
		public TerminalNode RLIKE() { return getToken(SQLParser.RLIKE, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode LIKE() { return getToken(SQLParser.LIKE, 0); }
		public Negativable_matcherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negativable_matcher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNegativable_matcher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNegativable_matcher(this);
		}
	}

	public final Negativable_matcherContext negativable_matcher() throws RecognitionException {
		Negativable_matcherContext _localctx = new Negativable_matcherContext(_ctx, getState());
		enterRule(_localctx, 446, RULE_negativable_matcher);
		try {
			setState(3789);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3783); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3784); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(3785); match(SIMILAR);
				setState(3786); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(3787); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(3788); match(RLIKE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Regex_matcherContext extends ParserRuleContext {
		public TerminalNode Not_Similar_To() { return getToken(SQLParser.Not_Similar_To, 0); }
		public TerminalNode Similar_To() { return getToken(SQLParser.Similar_To, 0); }
		public TerminalNode Not_Similar_To_Case_Insensitive() { return getToken(SQLParser.Not_Similar_To_Case_Insensitive, 0); }
		public TerminalNode Similar_To_Case_Insensitive() { return getToken(SQLParser.Similar_To_Case_Insensitive, 0); }
		public Regex_matcherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regex_matcher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRegex_matcher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRegex_matcher(this);
		}
	}

	public final Regex_matcherContext regex_matcher() throws RecognitionException {
		Regex_matcherContext _localctx = new Regex_matcherContext(_ctx, getState());
		enterRule(_localctx, 448, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3791);
			_la = _input.LA(1);
			if ( !(((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (Similar_To - 320)) | (1L << (Not_Similar_To - 320)) | (1L << (Similar_To_Case_Insensitive - 320)) | (1L << (Not_Similar_To_Case_Insensitive - 320)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Null_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext predicand;
		public Token n;
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode IS() { return getToken(SQLParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Null_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNull_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNull_predicate(this);
		}
	}

	public final Null_predicateContext null_predicate() throws RecognitionException {
		Null_predicateContext _localctx = new Null_predicateContext(_ctx, getState());
		enterRule(_localctx, 450, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3793); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3794); match(IS);
			setState(3796);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3795); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(3798); match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Quantified_comparison_predicateContext extends ParserRuleContext {
		public Numeric_value_expressionContext l;
		public Comp_opContext c;
		public QuantifierContext q;
		public Table_subqueryContext s;
		public Comp_opContext comp_op() {
			return getRuleContext(Comp_opContext.class,0);
		}
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public Quantified_comparison_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantified_comparison_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuantified_comparison_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuantified_comparison_predicate(this);
		}
	}

	public final Quantified_comparison_predicateContext quantified_comparison_predicate() throws RecognitionException {
		Quantified_comparison_predicateContext _localctx = new Quantified_comparison_predicateContext(_ctx, getState());
		enterRule(_localctx, 452, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3800); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(3801); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(3802); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(3803); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierContext extends ParserRuleContext {
		public AllContext all() {
			return getRuleContext(AllContext.class,0);
		}
		public SomeContext some() {
			return getRuleContext(SomeContext.class,0);
		}
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuantifier(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 454, RULE_quantifier);
		try {
			setState(3807);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3805); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3806); some();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AllContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public AllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_all; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAll(this);
		}
	}

	public final AllContext all() throws RecognitionException {
		AllContext _localctx = new AllContext(_ctx, getState());
		enterRule(_localctx, 456, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3809); match(ALL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SomeContext extends ParserRuleContext {
		public TerminalNode SOME() { return getToken(SQLParser.SOME, 0); }
		public TerminalNode ANY() { return getToken(SQLParser.ANY, 0); }
		public SomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_some; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSome(this);
		}
	}

	public final SomeContext some() throws RecognitionException {
		SomeContext _localctx = new SomeContext(_ctx, getState());
		enterRule(_localctx, 458, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3811);
			_la = _input.LA(1);
			if ( !(_la==ANY || _la==SOME) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exists_predicateContext extends ParserRuleContext {
		public Table_subqueryContext s;
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public Exists_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exists_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExists_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExists_predicate(this);
		}
	}

	public final Exists_predicateContext exists_predicate() throws RecognitionException {
		Exists_predicateContext _localctx = new Exists_predicateContext(_ctx, getState());
		enterRule(_localctx, 460, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3814);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3813); match(NOT);
				}
			}

			setState(3816); match(EXISTS);
			setState(3817); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unique_predicateContext extends ParserRuleContext {
		public Table_subqueryContext s;
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public Unique_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unique_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnique_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnique_predicate(this);
		}
	}

	public final Unique_predicateContext unique_predicate() throws RecognitionException {
		Unique_predicateContext _localctx = new Unique_predicateContext(_ctx, getState());
		enterRule(_localctx, 462, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3819); match(UNIQUE);
			setState(3820); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primary_datetime_fieldContext extends ParserRuleContext {
		public TerminalNode SECOND() { return getToken(SQLParser.SECOND, 0); }
		public Non_second_primary_datetime_fieldContext non_second_primary_datetime_field() {
			return getRuleContext(Non_second_primary_datetime_fieldContext.class,0);
		}
		public Primary_datetime_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_datetime_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPrimary_datetime_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPrimary_datetime_field(this);
		}
	}

	public final Primary_datetime_fieldContext primary_datetime_field() throws RecognitionException {
		Primary_datetime_fieldContext _localctx = new Primary_datetime_fieldContext(_ctx, getState());
		enterRule(_localctx, 464, RULE_primary_datetime_field);
		try {
			setState(3824);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3822); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(3823); match(SECOND);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Non_second_primary_datetime_fieldContext extends ParserRuleContext {
		public TerminalNode YEAR() { return getToken(SQLParser.YEAR, 0); }
		public TerminalNode MONTH() { return getToken(SQLParser.MONTH, 0); }
		public TerminalNode HOUR() { return getToken(SQLParser.HOUR, 0); }
		public TerminalNode DAY() { return getToken(SQLParser.DAY, 0); }
		public TerminalNode MINUTE() { return getToken(SQLParser.MINUTE, 0); }
		public Non_second_primary_datetime_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_second_primary_datetime_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNon_second_primary_datetime_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNon_second_primary_datetime_field(this);
		}
	}

	public final Non_second_primary_datetime_fieldContext non_second_primary_datetime_field() throws RecognitionException {
		Non_second_primary_datetime_fieldContext _localctx = new Non_second_primary_datetime_fieldContext(_ctx, getState());
		enterRule(_localctx, 466, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3826);
			_la = _input.LA(1);
			if ( !(((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (DAY - 160)) | (1L << (HOUR - 160)) | (1L << (MINUTE - 160)) | (1L << (MONTH - 160)))) != 0) || _la==YEAR) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Extended_datetime_fieldContext extends ParserRuleContext {
		public TerminalNode ISODOW() { return getToken(SQLParser.ISODOW, 0); }
		public TerminalNode EPOCH() { return getToken(SQLParser.EPOCH, 0); }
		public TerminalNode QUARTER() { return getToken(SQLParser.QUARTER, 0); }
		public TerminalNode DOY() { return getToken(SQLParser.DOY, 0); }
		public TerminalNode MILLENNIUM() { return getToken(SQLParser.MILLENNIUM, 0); }
		public TerminalNode DECADE() { return getToken(SQLParser.DECADE, 0); }
		public TerminalNode MICROSECONDS() { return getToken(SQLParser.MICROSECONDS, 0); }
		public TerminalNode WEEK() { return getToken(SQLParser.WEEK, 0); }
		public TerminalNode CENTURY() { return getToken(SQLParser.CENTURY, 0); }
		public TerminalNode MILLISECONDS() { return getToken(SQLParser.MILLISECONDS, 0); }
		public TerminalNode ISOYEAR() { return getToken(SQLParser.ISOYEAR, 0); }
		public TerminalNode DOW() { return getToken(SQLParser.DOW, 0); }
		public Extended_datetime_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extended_datetime_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExtended_datetime_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExtended_datetime_field(this);
		}
	}

	public final Extended_datetime_fieldContext extended_datetime_field() throws RecognitionException {
		Extended_datetime_fieldContext _localctx = new Extended_datetime_fieldContext(_ctx, getState());
		enterRule(_localctx, 468, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3828);
			_la = _input.LA(1);
			if ( !(((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & ((1L << (CENTURY - 143)) | (1L << (DECADE - 143)) | (1L << (DOW - 143)) | (1L << (DOY - 143)) | (1L << (EPOCH - 143)) | (1L << (ISODOW - 143)) | (1L << (ISOYEAR - 143)) | (1L << (MICROSECONDS - 143)) | (1L << (MILLENNIUM - 143)))) != 0) || _la==MILLISECONDS || _la==QUARTER || _la==WEEK) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Routine_invocationContext extends ParserRuleContext {
		public Sql_argument_listContext sql_argument_list() {
			return getRuleContext(Sql_argument_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public Routine_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routine_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterRoutine_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitRoutine_invocation(this);
		}
	}

	public final Routine_invocationContext routine_invocation() throws RecognitionException {
		Routine_invocationContext _localctx = new Routine_invocationContext(_ctx, getState());
		enterRule(_localctx, 470, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3830); function_name();
			setState(3831); match(LEFT_PAREN);
			setState(3833);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LEFT - 73)) | (1L << (NOT - 73)) | (1L << (NULL - 73)) | (1L << (RIGHT - 73)) | (1L << (SOME - 73)) | (1L << (TRUE - 73)) | (1L << (ADMIN - 73)) | (1L << (ALWAYS - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (AVG - 137)) | (1L << (BETWEEN - 137)) | (1L << (BY - 137)) | (1L << (CACHE - 137)) | (1L << (CALLED - 137)) | (1L << (CLASS - 137)) | (1L << (CENTURY - 137)) | (1L << (CHARACTER - 137)) | (1L << (CHECK - 137)) | (1L << (CLUSTER - 137)) | (1L << (COLLECT - 137)) | (1L << (COALESCE - 137)) | (1L << (COLUMN - 137)) | (1L << (COMMENT - 137)) | (1L << (COMMENTS - 137)) | (1L << (COMMIT - 137)) | (1L << (CONFIGURATION - 137)) | (1L << (COST - 137)) | (1L << (COUNT - 137)) | (1L << (CUBE - 137)) | (1L << (CURRENT - 137)) | (1L << (CYCLE - 137)) | (1L << (DATA - 137)) | (1L << (DAY - 137)) | (1L << (DEC - 137)) | (1L << (DECADE - 137)) | (1L << (DEFINER - 137)) | (1L << (DICTIONARY - 137)) | (1L << (DISABLE - 137)) | (1L << (DOW - 137)) | (1L << (DOY - 137)) | (1L << (DROP - 137)) | (1L << (ENABLE - 137)) | (1L << (EPOCH - 137)) | (1L << (EVERY - 137)) | (1L << (EXISTS - 137)) | (1L << (EXTENDED - 137)) | (1L << (EXTERNAL - 137)) | (1L << (EXTRACT - 137)) | (1L << (FAMILY - 137)) | (1L << (FILTER - 137)) | (1L << (FIRST - 137)) | (1L << (FORMAT - 137)) | (1L << (FUSION - 137)) | (1L << (GROUPING - 137)) | (1L << (HASH - 137)) | (1L << (INHERIT - 137)) | (1L << (INDEX - 137)) | (1L << (INCREMENT - 137)) | (1L << (INPUT - 137)) | (1L << (INSERT - 137)) | (1L << (INTERSECTION - 137)) | (1L << (ISCACHABLE - 137)) | (1L << (ISODOW - 137)) | (1L << (ISOYEAR - 137)) | (1L << (ISSTRICT - 137)) | (1L << (LANGUAGE - 137)) | (1L << (LARGE - 137)) | (1L << (LAST - 137)) | (1L << (LESS - 137)) | (1L << (LIST - 137)) | (1L << (LOCATION - 137)))) != 0) || ((((_la - 201)) & ~0x3f) == 0 && ((1L << (_la - 201)) & ((1L << (MAIN - 201)) | (1L << (MATCH - 201)) | (1L << (MAX - 201)) | (1L << (MAXVALUE - 201)) | (1L << (MICROSECONDS - 201)) | (1L << (MILLENNIUM - 201)) | (1L << (MILLISECONDS - 201)) | (1L << (MIN - 201)) | (1L << (MINVALUE - 201)) | (1L << (MINUTE - 201)) | (1L << (MONTH - 201)) | (1L << (NATIONAL - 201)) | (1L << (NO - 201)) | (1L << (NONE - 201)) | (1L << (NULLIF - 201)) | (1L << (OBJECT - 201)) | (1L << (ON - 201)) | (1L << (ONLY - 201)) | (1L << (OPTION - 201)) | (1L << (OPTIONS - 201)) | (1L << (OVERWRITE - 201)) | (1L << (PARSER - 201)) | (1L << (PARTIAL - 201)) | (1L << (PARTITION - 201)) | (1L << (PARTITIONS - 201)) | (1L << (PLAIN - 201)) | (1L << (PRECISION - 201)) | (1L << (PUBLIC - 201)) | (1L << (PURGE - 201)) | (1L << (QUARTER - 201)) | (1L << (RANGE - 201)) | (1L << (REGEXP - 201)) | (1L << (RENAME - 201)) | (1L << (REPLICA - 201)) | (1L << (RESET - 201)) | (1L << (RLIKE - 201)) | (1L << (ROLLUP - 201)) | (1L << (SEARCH - 201)) | (1L << (SECOND - 201)) | (1L << (SECURITY - 201)) | (1L << (SERVER - 201)) | (1L << (SET - 201)) | (1L << (SIMILAR - 201)) | (1L << (SIMPLE - 201)) | (1L << (STABLE - 201)) | (1L << (START - 201)) | (1L << (STATISTICS - 201)) | (1L << (STORAGE - 201)) | (1L << (STDDEV_POP - 201)) | (1L << (STDDEV_SAMP - 201)) | (1L << (SUBPARTITION - 201)) | (1L << (SUM - 201)) | (1L << (TABLESPACE - 201)) | (1L << (TEMPLATE - 201)) | (1L << (THAN - 201)) | (1L << (TIMEZONE - 201)) | (1L << (TIMEZONE_HOUR - 201)) | (1L << (TIMEZONE_MINUTE - 201)) | (1L << (TRIM - 201)) | (1L << (TO - 201)) | (1L << (TYPE - 201)))) != 0) || ((((_la - 265)) & ~0x3f) == 0 && ((1L << (_la - 265)) & ((1L << (UNKNOWN - 265)) | (1L << (UNLOGGED - 265)) | (1L << (USER - 265)) | (1L << (VALID - 265)) | (1L << (VALIDATE - 265)) | (1L << (VALUES - 265)) | (1L << (VAR_SAMP - 265)) | (1L << (VAR_POP - 265)) | (1L << (VARYING - 265)) | (1L << (VERSION - 265)) | (1L << (VOLATILE - 265)) | (1L << (WEEK - 265)) | (1L << (WINDOW - 265)) | (1L << (WRAPPER - 265)) | (1L << (YEAR - 265)) | (1L << (ZONE - 265)) | (1L << (BOOLEAN - 265)) | (1L << (BOOL - 265)) | (1L << (BIT - 265)) | (1L << (VARBIT - 265)) | (1L << (INT1 - 265)) | (1L << (INT2 - 265)) | (1L << (INT4 - 265)) | (1L << (INT8 - 265)) | (1L << (TINYINT - 265)) | (1L << (SMALLINT - 265)) | (1L << (INT - 265)) | (1L << (INTEGER - 265)) | (1L << (BIGINT - 265)) | (1L << (FLOAT4 - 265)) | (1L << (FLOAT8 - 265)) | (1L << (REAL - 265)) | (1L << (FLOAT - 265)) | (1L << (DOUBLE - 265)) | (1L << (NUMERIC - 265)) | (1L << (DECIMAL - 265)) | (1L << (CHAR - 265)) | (1L << (VARCHAR - 265)) | (1L << (NCHAR - 265)) | (1L << (NVARCHAR - 265)) | (1L << (DATE - 265)) | (1L << (TIME - 265)) | (1L << (TIMETZ - 265)) | (1L << (TIMESTAMP - 265)) | (1L << (TIMESTAMPTZ - 265)) | (1L << (TEXT - 265)) | (1L << (UUID - 265)) | (1L << (VARBINARY - 265)) | (1L << (BLOB - 265)) | (1L << (BYTEA - 265)) | (1L << (INET4 - 265)) | (1L << (INTERVAL - 265)) | (1L << (VOID - 265)))) != 0) || ((((_la - 336)) & ~0x3f) == 0 && ((1L << (_la - 336)) & ((1L << (LEFT_PAREN - 336)) | (1L << (PLUS - 336)) | (1L << (MINUS - 336)) | (1L << (DOUBLE_QUOTE - 336)) | (1L << (NUMBER - 336)) | (1L << (REAL_NUMBER - 336)) | (1L << (Identifier - 336)) | (1L << (QuotedIdentifier - 336)) | (1L << (Character_String_Literal - 336)))) != 0)) {
				{
				setState(3832); sql_argument_list();
				}
			}

			setState(3835); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_names_for_reserved_wordsContext extends ParserRuleContext {
		public TerminalNode LEFT() { return getToken(SQLParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(SQLParser.RIGHT, 0); }
		public Function_names_for_reserved_wordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_names_for_reserved_words; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_names_for_reserved_words(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_names_for_reserved_words(this);
		}
	}

	public final Function_names_for_reserved_wordsContext function_names_for_reserved_words() throws RecognitionException {
		Function_names_for_reserved_wordsContext _localctx = new Function_names_for_reserved_wordsContext(_ctx, getState());
		enterRule(_localctx, 472, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3837);
			_la = _input.LA(1);
			if ( !(_la==LEFT || _la==RIGHT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public Function_names_for_reserved_wordsContext function_names_for_reserved_words() {
			return getRuleContext(Function_names_for_reserved_wordsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_name(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 474, RULE_function_name);
		try {
			setState(3841);
			switch (_input.LA(1)) {
			case ADMIN:
			case ALWAYS:
			case AVG:
			case BETWEEN:
			case BY:
			case CACHE:
			case CALLED:
			case CLASS:
			case CENTURY:
			case CHARACTER:
			case CHECK:
			case CLUSTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COMMENT:
			case COMMENTS:
			case COMMIT:
			case CONFIGURATION:
			case COST:
			case COUNT:
			case CUBE:
			case CURRENT:
			case CYCLE:
			case DATA:
			case DAY:
			case DEC:
			case DECADE:
			case DEFINER:
			case DICTIONARY:
			case DISABLE:
			case DOW:
			case DOY:
			case DROP:
			case ENABLE:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTENDED:
			case EXTERNAL:
			case EXTRACT:
			case FAMILY:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INHERIT:
			case INDEX:
			case INCREMENT:
			case INPUT:
			case INSERT:
			case INTERSECTION:
			case ISCACHABLE:
			case ISODOW:
			case ISOYEAR:
			case ISSTRICT:
			case LANGUAGE:
			case LARGE:
			case LAST:
			case LESS:
			case LIST:
			case LOCATION:
			case MAIN:
			case MATCH:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINVALUE:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NO:
			case NONE:
			case NULLIF:
			case OBJECT:
			case ON:
			case ONLY:
			case OPTION:
			case OPTIONS:
			case OVERWRITE:
			case PARSER:
			case PARTIAL:
			case PARTITION:
			case PARTITIONS:
			case PLAIN:
			case PRECISION:
			case PUBLIC:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RENAME:
			case REPLICA:
			case RESET:
			case RLIKE:
			case ROLLUP:
			case SEARCH:
			case SECOND:
			case SECURITY:
			case SERVER:
			case SET:
			case SIMILAR:
			case SIMPLE:
			case STABLE:
			case START:
			case STATISTICS:
			case STORAGE:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case TEMPLATE:
			case THAN:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case TYPE:
			case UNKNOWN:
			case UNLOGGED:
			case USER:
			case VALID:
			case VALIDATE:
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case VERSION:
			case VOLATILE:
			case WEEK:
			case WINDOW:
			case WRAPPER:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case DECIMAL:
			case CHAR:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case UUID:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case INTERVAL:
			case VOID:
			case DOUBLE_QUOTE:
			case Identifier:
			case QuotedIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(3839); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3840); function_names_for_reserved_words();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_argument_listContext extends ParserRuleContext {
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Sql_argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_argument_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSql_argument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSql_argument_list(this);
		}
	}

	public final Sql_argument_listContext sql_argument_list() throws RecognitionException {
		Sql_argument_listContext _localctx = new Sql_argument_listContext(_ctx, getState());
		enterRule(_localctx, 476, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3843); value_expression();
			setState(3848);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3844); match(COMMA);
				setState(3845); value_expression();
				}
				}
				setState(3850);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Orderby_clauseContext extends ParserRuleContext {
		public Sort_specifier_listContext sort_specifier_list() {
			return getRuleContext(Sort_specifier_listContext.class,0);
		}
		public TerminalNode ORDER() { return getToken(SQLParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Orderby_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderby_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOrderby_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOrderby_clause(this);
		}
	}

	public final Orderby_clauseContext orderby_clause() throws RecognitionException {
		Orderby_clauseContext _localctx = new Orderby_clauseContext(_ctx, getState());
		enterRule(_localctx, 478, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3851); match(ORDER);
			setState(3852); match(BY);
			setState(3853); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sort_specifier_listContext extends ParserRuleContext {
		public List<Sort_specifierContext> sort_specifier() {
			return getRuleContexts(Sort_specifierContext.class);
		}
		public Sort_specifierContext sort_specifier(int i) {
			return getRuleContext(Sort_specifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Sort_specifier_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort_specifier_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSort_specifier_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSort_specifier_list(this);
		}
	}

	public final Sort_specifier_listContext sort_specifier_list() throws RecognitionException {
		Sort_specifier_listContext _localctx = new Sort_specifier_listContext(_ctx, getState());
		enterRule(_localctx, 480, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3855); sort_specifier();
			setState(3860);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3856); match(COMMA);
				setState(3857); sort_specifier();
				}
				}
				setState(3862);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sort_specifierContext extends ParserRuleContext {
		public Row_value_predicandContext key;
		public Order_specificationContext order;
		public Null_orderingContext null_order;
		public Order_specificationContext order_specification() {
			return getRuleContext(Order_specificationContext.class,0);
		}
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public Null_orderingContext null_ordering() {
			return getRuleContext(Null_orderingContext.class,0);
		}
		public Sort_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSort_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSort_specifier(this);
		}
	}

	public final Sort_specifierContext sort_specifier() throws RecognitionException {
		Sort_specifierContext _localctx = new Sort_specifierContext(_ctx, getState());
		enterRule(_localctx, 482, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3863); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(3865);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(3864); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(3868);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(3867); ((Sort_specifierContext)_localctx).null_order = null_ordering();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Order_specificationContext extends ParserRuleContext {
		public TerminalNode DESC() { return getToken(SQLParser.DESC, 0); }
		public TerminalNode ASC() { return getToken(SQLParser.ASC, 0); }
		public Order_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOrder_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOrder_specification(this);
		}
	}

	public final Order_specificationContext order_specification() throws RecognitionException {
		Order_specificationContext _localctx = new Order_specificationContext(_ctx, getState());
		enterRule(_localctx, 484, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3870);
			_la = _input.LA(1);
			if ( !(_la==ASC || _la==DESC) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Limit_clauseContext extends ParserRuleContext {
		public Numeric_value_expressionContext e;
		public TerminalNode LIMIT() { return getToken(SQLParser.LIMIT, 0); }
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public Limit_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterLimit_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitLimit_clause(this);
		}
	}

	public final Limit_clauseContext limit_clause() throws RecognitionException {
		Limit_clauseContext _localctx = new Limit_clauseContext(_ctx, getState());
		enterRule(_localctx, 486, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3872); match(LIMIT);
			setState(3873); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Null_orderingContext extends ParserRuleContext {
		public TerminalNode FIRST() { return getToken(SQLParser.FIRST, 0); }
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public TerminalNode LAST() { return getToken(SQLParser.LAST, 0); }
		public Null_orderingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_ordering; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNull_ordering(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNull_ordering(this);
		}
	}

	public final Null_orderingContext null_ordering() throws RecognitionException {
		Null_orderingContext _localctx = new Null_orderingContext(_ctx, getState());
		enterRule(_localctx, 488, RULE_null_ordering);
		try {
			setState(3879);
			switch ( getInterpreter().adaptivePredict(_input,537,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3875); match(NULL);
				setState(3876); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3877); match(NULL);
				setState(3878); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_statementContext extends ParserRuleContext {
		public Token path;
		public IdentifierContext file_type;
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public TerminalNode OVERWRITE() { return getToken(SQLParser.OVERWRITE, 0); }
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public TerminalNode INTO() { return getToken(SQLParser.INTO, 0); }
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Insert_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterInsert_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitInsert_statement(this);
		}
	}

	public final Insert_statementContext insert_statement() throws RecognitionException {
		Insert_statementContext _localctx = new Insert_statementContext(_ctx, getState());
		enterRule(_localctx, 490, RULE_insert_statement);
		int _la;
		try {
			setState(3910);
			switch ( getInterpreter().adaptivePredict(_input,543,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3881); match(INSERT);
				setState(3883);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3882); match(OVERWRITE);
					}
				}

				setState(3885); match(INTO);
				setState(3886); schema_qualified_name();
				setState(3891);
				switch ( getInterpreter().adaptivePredict(_input,539,_ctx) ) {
				case 1:
					{
					setState(3887); match(LEFT_PAREN);
					setState(3888); column_name_list();
					setState(3889); match(RIGHT_PAREN);
					}
					break;
				}
				setState(3893); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3895); match(INSERT);
				setState(3897);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3896); match(OVERWRITE);
					}
				}

				setState(3899); match(INTO);
				setState(3900); match(LOCATION);
				setState(3901); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(3907);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(3902); match(USING);
					setState(3903); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(3905);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(3904); param_clause();
						}
					}

					}
				}

				setState(3909); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	private static final int _serializedATNSegments = 2;
	private static final String _serializedATNSegment0 =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u016c\u0f4b\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8\4\u00a9"+
		"\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad\t\u00ad"+
		"\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1\4\u00b2"+
		"\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6\t\u00b6"+
		"\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba\4\u00bb"+
		"\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be\t\u00be\4\u00bf\t\u00bf"+
		"\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2\4\u00c3\t\u00c3\4\u00c4"+
		"\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6\4\u00c7\t\u00c7\4\u00c8\t\u00c8"+
		"\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb\4\u00cc\t\u00cc\4\u00cd"+
		"\t\u00cd\4\u00ce\t\u00ce\4\u00cf\t\u00cf\4\u00d0\t\u00d0\4\u00d1\t\u00d1"+
		"\4\u00d2\t\u00d2\4\u00d3\t\u00d3\4\u00d4\t\u00d4\4\u00d5\t\u00d5\4\u00d6"+
		"\t\u00d6\4\u00d7\t\u00d7\4\u00d8\t\u00d8\4\u00d9\t\u00d9\4\u00da\t\u00da"+
		"\4\u00db\t\u00db\4\u00dc\t\u00dc\4\u00dd\t\u00dd\4\u00de\t\u00de\4\u00df"+
		"\t\u00df\4\u00e0\t\u00e0\4\u00e1\t\u00e1\4\u00e2\t\u00e2\4\u00e3\t\u00e3"+
		"\4\u00e4\t\u00e4\4\u00e5\t\u00e5\4\u00e6\t\u00e6\4\u00e7\t\u00e7\4\u00e8"+
		"\t\u00e8\4\u00e9\t\u00e9\4\u00ea\t\u00ea\4\u00eb\t\u00eb\4\u00ec\t\u00ec"+
		"\4\u00ed\t\u00ed\4\u00ee\t\u00ee\4\u00ef\t\u00ef\4\u00f0\t\u00f0\4\u00f1"+
		"\t\u00f1\4\u00f2\t\u00f2\4\u00f3\t\u00f3\4\u00f4\t\u00f4\4\u00f5\t\u00f5"+
		"\4\u00f6\t\u00f6\4\u00f7\t\u00f7\3\2\3\2\5\2\u01f1\n\2\7\2\u01f3\n\2\f"+
		"\2\16\2\u01f6\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\5\6\u0203"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0212\n\7"+
		"\3\b\3\b\3\b\3\b\5\b\u0218\n\b\3\t\3\t\3\t\3\t\3\t\6\t\u021f\n\t\r\t\16"+
		"\t\u0220\3\t\5\t\u0224\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u023e\n\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u024e\n\n\3\13"+
		"\3\13\5\13\u0252\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u025c"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0264\n\13\3\f\3\f\3\f\5\f\u0269"+
		"\n\f\3\f\6\f\u026c\n\f\r\f\16\f\u026d\3\f\3\f\5\f\u0272\n\f\6\f\u0274"+
		"\n\f\r\f\16\f\u0275\3\f\3\f\3\f\5\f\u027b\n\f\3\f\6\f\u027e\n\f\r\f\16"+
		"\f\u027f\3\f\3\f\5\f\u0284\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0298\n\f\3\r\3\r\5\r\u029c\n\r\3"+
		"\r\3\r\3\r\5\r\u02a1\n\r\3\r\3\r\5\r\u02a5\n\r\3\r\3\r\5\r\u02a9\n\r\3"+
		"\r\3\r\5\r\u02ad\n\r\3\r\3\r\3\r\5\r\u02b2\n\r\3\r\3\r\3\r\3\r\5\r\u02b8"+
		"\n\r\3\r\3\r\5\r\u02bc\n\r\3\r\3\r\5\r\u02c0\n\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u02c9\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u02d1\n\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u02db\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u02e4"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u02ed\n\r\6\r\u02ef\n\r\r\r\16\r"+
		"\u02f0\3\r\3\r\3\r\3\r\5\r\u02f7\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u02fe\n\r"+
		"\6\r\u0300\n\r\r\r\16\r\u0301\3\r\3\r\3\r\3\r\5\r\u0308\n\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0316\n\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u0321\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u032b"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u0332\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u035c\n"+
		"\r\6\r\u035e\n\r\r\r\16\r\u035f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0373\n\r\3\16\3\16\5\16\u0377\n\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0382\n\16\3\16\3\16"+
		"\3\16\3\16\5\16\u0388\n\16\5\16\u038a\n\16\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u039c\n\20"+
		"\3\20\3\20\3\20\5\20\u03a1\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u03b0\n\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u03bb\n\20\3\21\3\21\5\21\u03bf\n\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u03c6\n\21\3\21\3\21\3\21\3\21\5\21\u03cc\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u03d3\n\22\3\22\3\22\5\22\u03d7\n\22\3\22\3"+
		"\22\5\22\u03db\n\22\3\22\3\22\5\22\u03df\n\22\3\22\3\22\5\22\u03e3\n\22"+
		"\3\23\3\23\3\23\5\23\u03e8\n\23\3\23\5\23\u03eb\n\23\3\23\3\23\3\23\3"+
		"\23\3\23\5\23\u03f2\n\23\3\23\5\23\u03f5\n\23\3\23\5\23\u03f8\n\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u0400\n\23\3\23\3\23\5\23\u0404\n\23\5"+
		"\23\u0406\n\23\3\24\3\24\5\24\u040a\n\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u0414\n\24\3\24\5\24\u0417\n\24\6\24\u0419\n\24\r\24\16"+
		"\24\u041a\3\24\3\24\5\24\u041f\n\24\3\24\3\24\3\24\3\24\3\24\5\24\u0426"+
		"\n\24\3\24\5\24\u0429\n\24\6\24\u042b\n\24\r\24\16\24\u042c\5\24\u042f"+
		"\n\24\3\25\3\25\5\25\u0433\n\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u043b"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0444\n\25\6\25\u0446\n"+
		"\25\r\25\16\25\u0447\5\25\u044a\n\25\5\25\u044c\n\25\3\25\3\25\3\25\3"+
		"\25\5\25\u0452\n\25\3\25\3\25\3\25\5\25\u0457\n\25\3\25\3\25\3\25\3\25"+
		"\5\25\u045d\n\25\3\25\3\25\5\25\u0461\n\25\3\25\3\25\5\25\u0465\n\25\3"+
		"\25\3\25\5\25\u0469\n\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0471\n\25"+
		"\5\25\u0473\n\25\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u047b\n\26\3\26\6"+
		"\26\u047e\n\26\r\26\16\26\u047f\3\26\3\26\5\26\u0484\n\26\5\26\u0486\n"+
		"\26\3\26\3\26\5\26\u048a\n\26\3\26\6\26\u048d\n\26\r\26\16\26\u048e\3"+
		"\26\3\26\3\26\3\26\3\26\6\26\u0496\n\26\r\26\16\26\u0497\5\26\u049a\n"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u04a2\n\26\3\26\3\26\3\26\3\26"+
		"\5\26\u04a8\n\26\6\26\u04aa\n\26\r\26\16\26\u04ab\3\26\3\26\6\26\u04b0"+
		"\n\26\r\26\16\26\u04b1\3\26\3\26\5\26\u04b6\n\26\3\26\3\26\3\26\5\26\u04bb"+
		"\n\26\6\26\u04bd\n\26\r\26\16\26\u04be\3\26\3\26\5\26\u04c3\n\26\3\26"+
		"\3\26\5\26\u04c7\n\26\3\26\3\26\5\26\u04cb\n\26\6\26\u04cd\n\26\r\26\16"+
		"\26\u04ce\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u04d7\n\26\3\26\6\26\u04da"+
		"\n\26\r\26\16\26\u04db\3\26\3\26\5\26\u04e0\n\26\5\26\u04e2\n\26\3\26"+
		"\3\26\3\26\3\26\5\26\u04e8\n\26\6\26\u04ea\n\26\r\26\16\26\u04eb\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u04f4\n\26\6\26\u04f6\n\26\r\26\16\26\u04f7"+
		"\5\26\u04fa\n\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0502\n\26\3\26\6"+
		"\26\u0505\n\26\r\26\16\26\u0506\3\26\3\26\5\26\u050b\n\26\5\26\u050d\n"+
		"\26\3\26\3\26\3\26\3\26\5\26\u0513\n\26\6\26\u0515\n\26\r\26\16\26\u0516"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u051f\n\26\3\26\3\26\3\26\5\26\u0524"+
		"\n\26\5\26\u0526\n\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u052e\n\26\6"+
		"\26\u0530\n\26\r\26\16\26\u0531\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u053a"+
		"\n\26\3\26\3\26\3\26\5\26\u053f\n\26\5\26\u0541\n\26\3\26\3\26\3\26\3"+
		"\26\3\26\5\26\u0548\n\26\6\26\u054a\n\26\r\26\16\26\u054b\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\5\26\u0554\n\26\3\26\3\26\3\26\5\26\u0559\n\26\5\26"+
		"\u055b\n\26\3\26\3\26\3\26\5\26\u0560\n\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\5\26\u0568\n\26\3\26\3\26\3\26\5\26\u056d\n\26\5\26\u056f\n\26\3\26"+
		"\3\26\3\26\3\26\5\26\u0575\n\26\6\26\u0577\n\26\r\26\16\26\u0578\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u0581\n\26\3\26\3\26\3\26\5\26\u0586\n"+
		"\26\6\26\u0588\n\26\r\26\16\26\u0589\3\26\3\26\5\26\u058e\n\26\5\26\u0590"+
		"\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u0597\n\26\6\26\u0599\n\26\r\26\16"+
		"\26\u059a\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u05a3\n\26\3\26\3\26\5\26"+
		"\u05a7\n\26\6\26\u05a9\n\26\r\26\16\26\u05aa\3\26\3\26\5\26\u05af\n\26"+
		"\5\26\u05b1\n\26\3\26\3\26\3\26\3\26\5\26\u05b7\n\26\6\26\u05b9\n\26\r"+
		"\26\16\26\u05ba\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u05c3\n\26\3\26\3\26"+
		"\3\26\5\26\u05c8\n\26\5\26\u05ca\n\26\3\26\3\26\3\26\3\26\5\26\u05d0\n"+
		"\26\6\26\u05d2\n\26\r\26\16\26\u05d3\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u05dc\n\26\3\26\3\26\5\26\u05e0\n\26\6\26\u05e2\n\26\r\26\16\26\u05e3"+
		"\3\26\3\26\3\26\5\26\u05e9\n\26\6\26\u05eb\n\26\r\26\16\26\u05ec\3\26"+
		"\5\26\u05f0\n\26\5\26\u05f2\n\26\3\27\3\27\5\27\u05f6\n\27\3\27\3\27\3"+
		"\27\5\27\u05fb\n\27\6\27\u05fd\n\27\r\27\16\27\u05fe\3\27\5\27\u0602\n"+
		"\27\3\30\3\30\6\30\u0606\n\30\r\30\16\30\u0607\3\30\3\30\5\30\u060c\n"+
		"\30\5\30\u060e\n\30\3\30\3\30\5\30\u0612\n\30\3\30\3\30\5\30\u0616\n\30"+
		"\6\30\u0618\n\30\r\30\16\30\u0619\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0622"+
		"\n\30\6\30\u0624\n\30\r\30\16\30\u0625\5\30\u0628\n\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u0630\n\30\6\30\u0632\n\30\r\30\16\30\u0633\6\30"+
		"\u0636\n\30\r\30\16\30\u0637\3\30\3\30\5\30\u063c\n\30\3\30\3\30\5\30"+
		"\u0640\n\30\6\30\u0642\n\30\r\30\16\30\u0643\5\30\u0646\n\30\3\30\3\30"+
		"\5\30\u064a\n\30\3\30\3\30\5\30\u064e\n\30\6\30\u0650\n\30\r\30\16\30"+
		"\u0651\3\30\3\30\3\30\3\30\3\30\5\30\u0659\n\30\6\30\u065b\n\30\r\30\16"+
		"\30\u065c\3\30\3\30\5\30\u0661\n\30\5\30\u0663\n\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0669\n\30\6\30\u066b\n\30\r\30\16\30\u066c\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u0675\n\30\6\30\u0677\n\30\r\30\16\30\u0678\5\30\u067b"+
		"\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u0682\n\30\6\30\u0684\n\30\r\30\16"+
		"\30\u0685\3\30\3\30\5\30\u068a\n\30\5\30\u068c\n\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0692\n\30\6\30\u0694\n\30\r\30\16\30\u0695\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u069e\n\30\5\30\u06a0\n\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u06a8\n\30\6\30\u06aa\n\30\r\30\16\30\u06ab\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\5\30\u06b4\n\30\5\30\u06b6\n\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u06bd\n\30\6\30\u06bf\n\30\r\30\16\30\u06c0\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u06c9\n\30\5\30\u06cb\n\30\3\30\3\30\3\30\5\30\u06d0\n"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u06d8\n\30\5\30\u06da\n\30\3\30"+
		"\3\30\3\30\3\30\5\30\u06e0\n\30\6\30\u06e2\n\30\r\30\16\30\u06e3\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u06eb\n\30\6\30\u06ed\n\30\r\30\16\30\u06ee"+
		"\3\30\3\30\5\30\u06f3\n\30\5\30\u06f5\n\30\3\30\3\30\3\30\3\30\3\30\5"+
		"\30\u06fc\n\30\6\30\u06fe\n\30\r\30\16\30\u06ff\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u0707\n\30\6\30\u0709\n\30\r\30\16\30\u070a\3\30\3\30\5\30\u070f"+
		"\n\30\5\30\u0711\n\30\3\30\3\30\3\30\3\30\5\30\u0717\n\30\6\30\u0719\n"+
		"\30\r\30\16\30\u071a\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0723\n\30\5\30"+
		"\u0725\n\30\3\30\3\30\3\30\3\30\5\30\u072b\n\30\6\30\u072d\n\30\r\30\16"+
		"\30\u072e\3\30\3\30\3\30\3\30\5\30\u0735\n\30\6\30\u0737\n\30\r\30\16"+
		"\30\u0738\3\30\3\30\3\30\5\30\u073e\n\30\6\30\u0740\n\30\r\30\16\30\u0741"+
		"\3\30\3\30\3\30\5\30\u0747\n\30\5\30\u0749\n\30\3\31\3\31\5\31\u074d\n"+
		"\31\3\31\3\31\5\31\u0751\n\31\3\31\5\31\u0754\n\31\6\31\u0756\n\31\r\31"+
		"\16\31\u0757\3\31\3\31\3\31\5\31\u075d\n\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\5\32\u0766\n\32\7\32\u0768\n\32\f\32\16\32\u076b\13\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\5\32\u07a9\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u07d7\n\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\5\33\u07df\n\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u07e7"+
		"\n\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u07ef\n\33\6\33\u07f1\n\33\r"+
		"\33\16\33\u07f2\3\33\3\33\5\33\u07f7\n\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u080a\n\33"+
		"\3\33\3\33\3\33\5\33\u080f\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u081f\n\33\3\33\3\33\7\33\u0823\n"+
		"\33\f\33\16\33\u0826\13\33\3\33\3\33\3\33\3\33\3\33\3\33\6\33\u082e\n"+
		"\33\r\33\16\33\u082f\3\33\3\33\3\33\3\33\5\33\u0836\n\33\6\33\u0838\n"+
		"\33\r\33\16\33\u0839\3\33\3\33\5\33\u083e\n\33\3\34\3\34\5\34\u0842\n"+
		"\34\3\34\5\34\u0845\n\34\3\34\3\34\5\34\u0849\n\34\3\34\3\34\5\34\u084d"+
		"\n\34\3\34\3\34\5\34\u0851\n\34\5\34\u0853\n\34\3\34\5\34\u0856\n\34\7"+
		"\34\u0858\n\34\f\34\16\34\u085b\13\34\3\34\3\34\3\35\3\35\5\35\u0861\n"+
		"\35\3\36\3\36\7\36\u0865\n\36\f\36\16\36\u0868\13\36\3\36\3\36\3\37\3"+
		"\37\7\37\u086e\n\37\f\37\16\37\u0871\13\37\3\37\3\37\3 \3 \3!\3!\3\"\3"+
		"\"\3\"\3\"\5\"\u087d\n\"\3\"\5\"\u0880\n\"\3\"\3\"\5\"\u0884\n\"\3\"\5"+
		"\"\u0887\n\"\7\"\u0889\n\"\f\"\16\"\u088c\13\"\3\"\3\"\3#\3#\3#\3#\3#"+
		"\3#\5#\u0896\n#\6#\u0898\n#\r#\16#\u0899\3$\3$\5$\u089e\n$\3$\3$\3$\3"+
		"$\5$\u08a4\n$\3$\3$\3$\3$\3$\5$\u08ab\n$\3$\3$\3$\3$\5$\u08b1\n$\3$\3"+
		"$\5$\u08b5\n$\3$\3$\3$\3$\5$\u08bb\n$\3$\3$\3$\3$\3$\5$\u08c2\n$\7$\u08c4"+
		"\n$\f$\16$\u08c7\13$\3%\3%\3%\3%\3%\5%\u08ce\n%\3%\7%\u08d1\n%\f%\16%"+
		"\u08d4\13%\3%\3%\3%\3%\3%\7%\u08db\n%\f%\16%\u08de\13%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\5%\u08e8\n%\3%\3%\3%\3%\3%\3%\3%\5%\u08f1\n%\3&\3&\3&\5&\u08f6"+
		"\n&\3&\5&\u08f9\n&\3&\3&\3&\3&\5&\u08ff\n&\7&\u0901\n&\f&\16&\u0904\13"+
		"&\3&\3&\3&\3&\3&\5&\u090b\n&\6&\u090d\n&\r&\16&\u090e\3&\3&\5&\u0913\n"+
		"&\3&\3&\3&\3\'\3\'\3(\3(\5(\u091c\n(\3(\3(\5(\u0920\n(\3(\3(\3(\3(\5("+
		"\u0926\n(\3(\3(\3(\3(\3(\3(\3(\7(\u092f\n(\f(\16(\u0932\13(\5(\u0934\n"+
		"(\3(\5(\u0937\n(\6(\u0939\n(\r(\16(\u093a\5(\u093d\n(\3(\3(\3(\3(\3(\5"+
		"(\u0944\n(\6(\u0946\n(\r(\16(\u0947\3(\3(\5(\u094c\n(\3(\3(\3(\3(\3(\3"+
		"(\5(\u0954\n(\3(\3(\5(\u0958\n(\3(\3(\3(\3(\5(\u095e\n(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\7(\u0968\n(\f(\16(\u096b\13(\3(\5(\u096e\n(\3(\5(\u0971\n("+
		"\6(\u0973\n(\r(\16(\u0974\3(\3(\5(\u0979\n(\3(\3(\3(\3(\5(\u097f\n(\3"+
		")\3)\3)\3)\5)\u0985\n)\3)\7)\u0988\n)\f)\16)\u098b\13)\3*\3*\3*\3+\3+"+
		"\5+\u0992\n+\3+\3+\3+\3+\3+\5+\u0999\n+\6+\u099b\n+\r+\16+\u099c\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\5+\u09a7\n+\6+\u09a9\n+\r+\16+\u09aa\3+\3+\3+\3+\3"+
		"+\3+\5+\u09b3\n+\3+\3+\3+\3+\3+\5+\u09ba\n+\6+\u09bc\n+\r+\16+\u09bd\3"+
		"+\3+\3+\3+\3+\3+\3+\5+\u09c7\n+\3+\3+\3+\3+\3+\5+\u09ce\n+\6+\u09d0\n"+
		"+\r+\16+\u09d1\3+\3+\3+\3+\3+\3+\5+\u09da\n+\6+\u09dc\n+\r+\16+\u09dd"+
		"\3+\3+\5+\u09e2\n+\3+\3+\3+\3+\3+\3+\5+\u09ea\n+\3+\3+\3+\5+\u09ef\n+"+
		"\3+\3+\3+\5+\u09f4\n+\5+\u09f6\n+\3+\3+\3+\5+\u09fb\n+\3+\3+\3+\3+\5+"+
		"\u0a01\n+\3,\3,\5,\u0a05\n,\3,\3,\3,\3,\3,\3,\3,\5,\u0a0e\n,\3,\3,\3,"+
		"\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0a1e\n,\3,\3,\3,\5,\u0a23\n,\3,"+
		"\3,\3,\5,\u0a28\n,\5,\u0a2a\n,\3,\3,\3,\5,\u0a2f\n,\3,\3,\3,\3,\5,\u0a35"+
		"\n,\3-\3-\3-\3-\3-\3.\3.\3.\3.\5.\u0a40\n.\3.\5.\u0a43\n.\6.\u0a45\n."+
		"\r.\16.\u0a46\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\5\60\u0a53\n\60"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u0a5c\n\61\5\61\u0a5e\n\61\3"+
		"\62\3\62\5\62\u0a62\n\62\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u0a6a\n\63"+
		"\3\64\5\64\u0a6d\n\64\3\64\3\64\3\64\3\64\5\64\u0a73\n\64\3\65\3\65\3"+
		"\65\3\65\7\65\u0a79\n\65\f\65\16\65\u0a7c\13\65\3\65\3\65\3\66\3\66\3"+
		"\66\3\67\3\67\38\38\38\38\38\78\u0a8a\n8\f8\168\u0a8d\138\38\38\39\39"+
		"\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3=\3=\3=\3=\5=\u0aa1\n=\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3?\3?\3?\7?\u0ab0\n?\f?\16?\u0ab3\13?\3@\3@\3@\3@\3@\3"+
		"@\3@\3@\3@\3@\5@\u0abf\n@\3@\3@\5@\u0ac3\n@\5@\u0ac5\n@\3A\3A\3A\3A\3"+
		"A\3A\3A\3A\3A\3A\3A\5A\u0ad2\nA\3B\3B\3B\7B\u0ad7\nB\fB\16B\u0ada\13B"+
		"\3C\3C\3C\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F\7F\u0aef\nF"+
		"\fF\16F\u0af2\13F\3G\3G\3G\3G\5G\u0af8\nG\3G\3G\3G\3G\3H\3H\3H\3H\3H\3"+
		"I\3I\3J\3J\3J\3J\5J\u0b09\nJ\3K\3K\3K\5K\u0b0e\nK\3K\3K\5K\u0b12\nK\5"+
		"K\u0b14\nK\3L\3L\3M\3M\5M\u0b1a\nM\3N\3N\3N\5N\u0b1f\nN\3O\3O\3O\5O\u0b24"+
		"\nO\3P\3P\3P\3Q\3Q\3Q\3R\3R\3R\3S\3S\3T\3T\3T\5T\u0b34\nT\3U\3U\3U\3U"+
		"\3U\3U\3U\3U\3U\3U\3U\3U\3U\5U\u0b43\nU\3V\3V\3W\3W\3X\3X\5X\u0b4b\nX"+
		"\3X\3X\5X\u0b4f\nX\3X\3X\3X\5X\u0b54\nX\3X\3X\3X\5X\u0b59\nX\3X\3X\5X"+
		"\u0b5d\nX\3X\3X\5X\u0b61\nX\3Y\3Y\3Y\3Y\3Z\3Z\3Z\5Z\u0b6a\nZ\3Z\3Z\3Z"+
		"\5Z\u0b6f\nZ\3Z\3Z\5Z\u0b73\nZ\3Z\3Z\3Z\3Z\5Z\u0b79\nZ\3Z\3Z\3Z\3Z\5Z"+
		"\u0b7f\nZ\3Z\3Z\3Z\5Z\u0b84\nZ\3Z\3Z\5Z\u0b88\nZ\5Z\u0b8a\nZ\3[\3[\5["+
		"\u0b8e\n[\3[\3[\5[\u0b92\n[\5[\u0b94\n[\3\\\3\\\5\\\u0b98\n\\\3]\3]\5"+
		"]\u0b9c\n]\3]\3]\5]\u0ba0\n]\3]\3]\5]\u0ba4\n]\3]\3]\3]\3]\3]\3]\3]\3"+
		"]\3]\5]\u0baf\n]\3^\3^\5^\u0bb3\n^\3^\3^\3^\3^\3^\3^\5^\u0bbb\n^\3_\3"+
		"_\3_\3_\3_\3_\3_\3_\5_\u0bc5\n_\3`\3`\3a\3a\3a\3a\3a\3a\3a\3a\3a\3a\3"+
		"a\3a\3a\3a\3a\3a\3a\5a\u0bda\na\3b\3b\5b\u0bde\nb\3b\3b\5b\u0be2\nb\3"+
		"b\3b\3b\5b\u0be7\nb\5b\u0be9\nb\3c\3c\5c\u0bed\nc\3c\3c\3c\5c\u0bf2\n"+
		"c\3c\3c\5c\u0bf6\nc\5c\u0bf8\nc\3d\3d\5d\u0bfc\nd\3e\3e\3e\3e\3f\3f\3"+
		"f\3f\3f\3f\3f\3f\5f\u0c0a\nf\3g\3g\3h\3h\3i\5i\u0c11\ni\3i\3i\3j\3j\3"+
		"k\3k\3k\3k\3k\3k\5k\u0c1d\nk\5k\u0c1f\nk\3l\3l\3l\5l\u0c24\nl\3l\3l\3"+
		"l\3m\3m\3n\3n\3n\3n\3n\3n\3o\3o\3o\3o\3o\3p\3p\3q\3q\3q\3q\3q\3q\3q\3"+
		"q\3q\3q\3q\3q\6q\u0c44\nq\rq\16q\u0c45\3q\3q\5q\u0c4a\nq\3r\3r\5r\u0c4e"+
		"\nr\3s\3s\3s\6s\u0c53\ns\rs\16s\u0c54\3s\5s\u0c58\ns\3s\3s\3t\3t\6t\u0c5e"+
		"\nt\rt\16t\u0c5f\3t\5t\u0c63\nt\3t\3t\3u\3u\3u\3u\3u\3v\3v\3v\3v\3v\3"+
		"w\3w\3w\3x\3x\5x\u0c76\nx\3y\3y\3y\3y\3y\3y\3y\3z\3z\3{\3{\3|\3|\3|\5"+
		"|\u0c86\n|\3}\3}\3}\5}\u0c8b\n}\3~\3~\3~\7~\u0c90\n~\f~\16~\u0c93\13~"+
		"\3\177\3\177\3\177\7\177\u0c98\n\177\f\177\16\177\u0c9b\13\177\3\u0080"+
		"\5\u0080\u0c9e\n\u0080\3\u0080\3\u0080\3\u0081\3\u0081\3\u0081\3\u0081"+
		"\7\u0081\u0ca6\n\u0081\f\u0081\16\u0081\u0ca9\13\u0081\3\u0081\3\u0081"+
		"\3\u0082\3\u0082\3\u0082\7\u0082\u0cb0\n\u0082\f\u0082\16\u0082\u0cb3"+
		"\13\u0082\3\u0082\5\u0082\u0cb6\n\u0082\3\u0083\3\u0083\3\u0084\3\u0084"+
		"\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0086\3\u0086"+
		"\3\u0086\5\u0086\u0cc6\n\u0086\3\u0087\3\u0087\3\u0088\3\u0088\5\u0088"+
		"\u0ccc\n\u0088\3\u0089\3\u0089\3\u008a\3\u008a\3\u008a\7\u008a\u0cd3\n"+
		"\u008a\f\u008a\16\u008a\u0cd6\13\u008a\3\u008b\3\u008b\3\u008c\3\u008c"+
		"\5\u008c\u0cdc\n\u008c\3\u008d\3\u008d\3\u008e\3\u008e\3\u008e\3\u008e"+
		"\3\u008e\3\u008f\5\u008f\u0ce6\n\u008f\3\u008f\5\u008f\u0ce9\n\u008f\3"+
		"\u008f\5\u008f\u0cec\n\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\5"+
		"\u008f\u0cf3\n\u008f\3\u0090\3\u0090\3\u0091\3\u0091\3\u0092\3\u0092\3"+
		"\u0092\7\u0092\u0cfc\n\u0092\f\u0092\16\u0092\u0cff\13\u0092\3\u0093\3"+
		"\u0093\3\u0093\7\u0093\u0d04\n\u0093\f\u0093\16\u0093\u0d07\13\u0093\3"+
		"\u0094\3\u0094\3\u0094\5\u0094\u0d0c\n\u0094\3\u0095\3\u0095\5\u0095\u0d10"+
		"\n\u0095\3\u0096\3\u0096\5\u0096\u0d14\n\u0096\3\u0096\3\u0096\3\u0097"+
		"\3\u0097\3\u0098\3\u0098\5\u0098\u0d1c\n\u0098\3\u0099\3\u0099\5\u0099"+
		"\u0d20\n\u0099\3\u009a\3\u009a\3\u009a\3\u009a\3\u009b\3\u009b\5\u009b"+
		"\u0d28\n\u009b\3\u009c\3\u009c\3\u009d\3\u009d\3\u009e\3\u009e\5\u009e"+
		"\u0d30\n\u009e\3\u009f\3\u009f\5\u009f\u0d34\n\u009f\3\u00a0\3\u00a0\5"+
		"\u00a0\u0d38\n\u00a0\3\u00a0\5\u00a0\u0d3b\n\u00a0\3\u00a0\5\u00a0\u0d3e"+
		"\n\u00a0\3\u00a0\5\u00a0\u0d41\n\u00a0\3\u00a0\5\u00a0\u0d44\n\u00a0\3"+
		"\u00a1\3\u00a1\3\u00a1\3\u00a2\3\u00a2\3\u00a2\7\u00a2\u0d4c\n\u00a2\f"+
		"\u00a2\16\u00a2\u0d4f\13\u00a2\3\u00a3\3\u00a3\5\u00a3\u0d53\n\u00a3\3"+
		"\u00a4\3\u00a4\6\u00a4\u0d57\n\u00a4\r\u00a4\16\u00a4\u0d58\3\u00a5\3"+
		"\u00a5\3\u00a5\3\u00a5\5\u00a5\u0d5f\n\u00a5\3\u00a5\3\u00a5\3\u00a5\3"+
		"\u00a5\3\u00a5\3\u00a5\5\u00a5\u0d67\n\u00a5\3\u00a5\3\u00a5\3\u00a5\3"+
		"\u00a5\3\u00a5\5\u00a5\u0d6e\n\u00a5\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3"+
		"\u00a7\5\u00a7\u0d75\n\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a8\3"+
		"\u00a8\5\u00a8\u0d7d\n\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a9\3\u00a9\3"+
		"\u00a9\3\u00a9\3\u00aa\3\u00aa\5\u00aa\u0d88\n\u00aa\3\u00ab\3\u00ab\5"+
		"\u00ab\u0d8c\n\u00ab\3\u00ac\3\u00ac\3\u00ad\3\u00ad\5\u00ad\u0d92\n\u00ad"+
		"\3\u00ae\3\u00ae\3\u00ae\3\u00af\3\u00af\3\u00af\3\u00af\3\u00af\3\u00b0"+
		"\3\u00b0\5\u00b0\u0d9e\n\u00b0\3\u00b0\5\u00b0\u0da1\n\u00b0\3\u00b0\3"+
		"\u00b0\3\u00b0\3\u00b0\5\u00b0\u0da7\n\u00b0\3\u00b0\3\u00b0\5\u00b0\u0dab"+
		"\n\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\5\u00b0\u0db2\n\u00b0"+
		"\5\u00b0\u0db4\n\u00b0\3\u00b1\3\u00b1\3\u00b1\7\u00b1\u0db9\n\u00b1\f"+
		"\u00b1\16\u00b1\u0dbc\13\u00b1\3\u00b2\3\u00b2\3\u00b3\3\u00b3\3\u00b3"+
		"\3\u00b4\3\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b6\3\u00b6\3\u00b6"+
		"\7\u00b6\u0dcc\n\u00b6\f\u00b6\16\u00b6\u0dcf\13\u00b6\3\u00b7\3\u00b7"+
		"\3\u00b7\3\u00b7\5\u00b7\u0dd5\n\u00b7\3\u00b8\3\u00b8\3\u00b8\3\u00b8"+
		"\3\u00b8\5\u00b8\u0ddc\n\u00b8\3\u00b9\3\u00b9\3\u00b9\7\u00b9\u0de1\n"+
		"\u00b9\f\u00b9\16\u00b9\u0de4\13\u00b9\3\u00ba\3\u00ba\3\u00ba\3\u00ba"+
		"\3\u00ba\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bc\3\u00bc\3\u00bc"+
		"\3\u00bd\3\u00bd\3\u00bd\3\u00be\3\u00be\3\u00be\7\u00be\u0df9\n\u00be"+
		"\f\u00be\16\u00be\u0dfc\13\u00be\3\u00bf\3\u00bf\3\u00c0\3\u00c0\5\u00c0"+
		"\u0e02\n\u00c0\3\u00c1\3\u00c1\3\u00c1\3\u00c1\5\u00c1\u0e08\n\u00c1\3"+
		"\u00c1\3\u00c1\5\u00c1\u0e0c\n\u00c1\3\u00c1\3\u00c1\5\u00c1\u0e10\n\u00c1"+
		"\3\u00c1\7\u00c1\u0e13\n\u00c1\f\u00c1\16\u00c1\u0e16\13\u00c1\3\u00c2"+
		"\3\u00c2\5\u00c2\u0e1a\n\u00c2\3\u00c3\3\u00c3\3\u00c3\3\u00c3\5\u00c3"+
		"\u0e20\n\u00c3\3\u00c3\3\u00c3\5\u00c3\u0e24\n\u00c3\3\u00c3\3\u00c3\5"+
		"\u00c3\u0e28\n\u00c3\3\u00c3\7\u00c3\u0e2b\n\u00c3\f\u00c3\16\u00c3\u0e2e"+
		"\13\u00c3\3\u00c4\3\u00c4\5\u00c4\u0e32\n\u00c4\3\u00c5\3\u00c5\3\u00c5"+
		"\3\u00c5\3\u00c5\5\u00c5\u0e39\n\u00c5\3\u00c6\3\u00c6\5\u00c6\u0e3d\n"+
		"\u00c6\3\u00c7\3\u00c7\3\u00c7\3\u00c8\3\u00c8\5\u00c8\u0e44\n\u00c8\3"+
		"\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\5\u00c9\u0e4b\n\u00c9\5\u00c9\u0e4d"+
		"\n\u00c9\3\u00ca\3\u00ca\5\u00ca\u0e51\n\u00ca\3\u00ca\3\u00ca\5\u00ca"+
		"\u0e55\n\u00ca\3\u00cb\3\u00cb\3\u00cb\7\u00cb\u0e5a\n\u00cb\f\u00cb\16"+
		"\u00cb\u0e5d\13\u00cb\3\u00cc\3\u00cc\5\u00cc\u0e61\n\u00cc\3\u00cd\3"+
		"\u00cd\5\u00cd\u0e65\n\u00cd\3\u00ce\3\u00ce\5\u00ce\u0e69\n\u00ce\3\u00ce"+
		"\3\u00ce\3\u00cf\3\u00cf\3\u00d0\3\u00d0\3\u00d0\5\u00d0\u0e72\n\u00d0"+
		"\3\u00d0\3\u00d0\3\u00d1\5\u00d1\u0e77\n\u00d1\3\u00d1\3\u00d1\3\u00d2"+
		"\3\u00d2\3\u00d2\7\u00d2\u0e7e\n\u00d2\f\u00d2\16\u00d2\u0e81\13\u00d2"+
		"\3\u00d3\3\u00d3\3\u00d4\3\u00d4\3\u00d5\3\u00d5\3\u00d6\3\u00d6\3\u00d6"+
		"\3\u00d6\3\u00d7\3\u00d7\3\u00d7\3\u00d7\3\u00d7\3\u00d7\5\u00d7\u0e93"+
		"\n\u00d7\3\u00d8\3\u00d8\3\u00d8\3\u00d8\3\u00d9\3\u00d9\3\u00da\3\u00da"+
		"\3\u00da\3\u00db\5\u00db\u0e9f\n\u00db\3\u00db\3\u00db\5\u00db\u0ea3\n"+
		"\u00db\3\u00db\3\u00db\3\u00db\3\u00db\3\u00dc\3\u00dc\5\u00dc\u0eab\n"+
		"\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dd\3\u00dd\3\u00dd\3\u00dd\3\u00dd"+
		"\5\u00dd\u0eb5\n\u00dd\3\u00de\3\u00de\3\u00de\7\u00de\u0eba\n\u00de\f"+
		"\u00de\16\u00de\u0ebd\13\u00de\3\u00df\3\u00df\3\u00df\3\u00df\3\u00e0"+
		"\5\u00e0\u0ec4\n\u00e0\3\u00e0\3\u00e0\5\u00e0\u0ec8\n\u00e0\3\u00e1\3"+
		"\u00e1\3\u00e1\3\u00e1\3\u00e1\3\u00e1\5\u00e1\u0ed0\n\u00e1\3\u00e2\3"+
		"\u00e2\3\u00e3\3\u00e3\3\u00e3\5\u00e3\u0ed7\n\u00e3\3\u00e3\3\u00e3\3"+
		"\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e5\3\u00e5\5\u00e5\u0ee2\n"+
		"\u00e5\3\u00e6\3\u00e6\3\u00e7\3\u00e7\3\u00e8\5\u00e8\u0ee9\n\u00e8\3"+
		"\u00e8\3\u00e8\3\u00e8\3\u00e9\3\u00e9\3\u00e9\3\u00ea\3\u00ea\5\u00ea"+
		"\u0ef3\n\u00ea\3\u00eb\3\u00eb\3\u00ec\3\u00ec\3\u00ed\3\u00ed\3\u00ed"+
		"\5\u00ed\u0efc\n\u00ed\3\u00ed\3\u00ed\3\u00ee\3\u00ee\3\u00ef\3\u00ef"+
		"\5\u00ef\u0f04\n\u00ef\3\u00f0\3\u00f0\3\u00f0\7\u00f0\u0f09\n\u00f0\f"+
		"\u00f0\16\u00f0\u0f0c\13\u00f0\3\u00f1\3\u00f1\3\u00f1\3\u00f1\3\u00f2"+
		"\3\u00f2\3\u00f2\7\u00f2\u0f15\n\u00f2\f\u00f2\16\u00f2\u0f18\13\u00f2"+
		"\3\u00f3\3\u00f3\5\u00f3\u0f1c\n\u00f3\3\u00f3\5\u00f3\u0f1f\n\u00f3\3"+
		"\u00f4\3\u00f4\3\u00f5\3\u00f5\3\u00f5\3\u00f6\3\u00f6\3\u00f6\3\u00f6"+
		"\5\u00f6\u0f2a\n\u00f6\3\u00f7\3\u00f7\5\u00f7\u0f2e\n\u00f7\3\u00f7\3"+
		"\u00f7\3\u00f7\3\u00f7\3\u00f7\3\u00f7\5\u00f7\u0f36\n\u00f7\3\u00f7\3"+
		"\u00f7\3\u00f7\3\u00f7\5\u00f7\u0f3c\n\u00f7\3\u00f7\3\u00f7\3\u00f7\3"+
		"\u00f7\3\u00f7\3\u00f7\5\u00f7\u0f44\n\u00f7\5\u00f7\u0f46\n\u00f7\3\u00f7"+
		"\5\u00f7\u0f49\n\u00f7\3\u00f7\2\2\u00f8\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8"+
		"\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0"+
		"\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8"+
		"\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110"+
		"\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128"+
		"\u012a\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140"+
		"\u0142\u0144\u0146\u0148\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158"+
		"\u015a\u015c\u015e\u0160\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170"+
		"\u0172\u0174\u0176\u0178\u017a\u017c\u017e\u0180\u0182\u0184\u0186\u0188"+
		"\u018a\u018c\u018e\u0190\u0192\u0194\u0196\u0198\u019a\u019c\u019e\u01a0"+
		"\u01a2\u01a4\u01a6\u01a8\u01aa\u01ac\u01ae\u01b0\u01b2\u01b4\u01b6\u01b8"+
		"\u01ba\u01bc\u01be\u01c0\u01c2\u01c4\u01c6\u01c8\u01ca\u01cc\u01ce\u01d0"+
		"\u01d2\u01d4\u01d6\u01d8\u01da\u01dc\u01de\u01e0\u01e2\u01e4\u01e6\u01e8"+
		"\u01ea\u01ec\2)\4\2\21\21ee\3\2\u00da\u00db\4\2NNnn\4\2\u0109\u0109\u0148"+
		"\u0148\t\2  ccmmzz||\177\177\u00bf\u00bf\6\2ccmm\177\177\u00bf\u00bf\4"+
		"\2mm\177\u0080\5\2\25\25\31\31uv\4\2\31\31\u0080\u0080\4\2mm\177\177\4"+
		"\2\34\34\u0148\u0148\3\2\u015f\u015f\3\2\u0160\u0160\4\2\u00c1\u00c1\u00c4"+
		"\u00c4\6\2<<DDUU\u0083\u0083\3\2uv\4\2\63\63NN\4\2))==\b\2\7\7\27\27\35"+
		"\35\u0099\u0099\u00bc\u00bc\u00fc\u00fc\t\2\u0089\u00b8\u00ba\u00bb\u00bd"+
		"\u00d9\u00dc\u0101\u0103\u012a\u012c\u013a\u013c\u0141\5\2,,{{\u010b\u010b"+
		"\3\2\u011b\u011c\3\2\u0161\u0162\17\2\n\npp\u008b\u008b\u0095\u0095\u009d"+
		"\u009d\u00ad\u00ad\u00b6\u00b6\u00c0\u00c0\u00cd\u00cd\u00d2\u00d2\u00fd"+
		"\u00fe\u0100\u0100\u0111\u0112\3\2\u0154\u0155\3\2\u0156\u0158\3\2\u0105"+
		"\u0107\5\2\17\17JJxx\5\2//KKhh\4\2\'\'}}\4\2\7\7\"\"\4\2\u0148\u0148\u014d"+
		"\u0151\4\2\13\13ss\3\2\u0142\u0145\4\2\n\npp\6\2\u00a2\u00a2\u00b9\u00b9"+
		"\u00d4\u00d5\u0119\u0119\n\2\u0091\u0091\u00a4\u00a4\u00a8\u00a9\u00ac"+
		"\u00ac\u00c2\u00c3\u00cf\u00d1\u00ea\u00ea\u0116\u0116\4\2KKhh\4\2\f\f"+
		"!!\u1160\2\u01f4\3\2\2\2\4\u01f9\3\2\2\2\6\u01fb\3\2\2\2\b\u01fd\3\2\2"+
		"\2\n\u0202\3\2\2\2\f\u0211\3\2\2\2\16\u0217\3\2\2\2\20\u023d\3\2\2\2\22"+
		"\u024d\3\2\2\2\24\u0263\3\2\2\2\26\u0297\3\2\2\2\30\u0372\3\2\2\2\32\u0389"+
		"\3\2\2\2\34\u038b\3\2\2\2\36\u03ba\3\2\2\2 \u03bc\3\2\2\2\"\u03cd\3\2"+
		"\2\2$\u0405\3\2\2\2&\u042e\3\2\2\2(\u0430\3\2\2\2*\u05f1\3\2\2\2,\u05f3"+
		"\3\2\2\2.\u0748\3\2\2\2\60\u074a\3\2\2\2\62\u075e\3\2\2\2\64\u07db\3\2"+
		"\2\2\66\u083f\3\2\2\28\u0860\3\2\2\2:\u0862\3\2\2\2<\u086b\3\2\2\2>\u0874"+
		"\3\2\2\2@\u0876\3\2\2\2B\u0878\3\2\2\2D\u088f\3\2\2\2F\u089b\3\2\2\2H"+
		"\u08f0\3\2\2\2J\u08f2\3\2\2\2L\u0917\3\2\2\2N\u097e\3\2\2\2P\u0980\3\2"+
		"\2\2R\u098c\3\2\2\2T\u0991\3\2\2\2V\u0a04\3\2\2\2X\u0a36\3\2\2\2Z\u0a3b"+
		"\3\2\2\2\\\u0a4a\3\2\2\2^\u0a52\3\2\2\2`\u0a5d\3\2\2\2b\u0a61\3\2\2\2"+
		"d\u0a69\3\2\2\2f\u0a6c\3\2\2\2h\u0a74\3\2\2\2j\u0a7f\3\2\2\2l\u0a82\3"+
		"\2\2\2n\u0a84\3\2\2\2p\u0a90\3\2\2\2r\u0a94\3\2\2\2t\u0a97\3\2\2\2v\u0a9a"+
		"\3\2\2\2x\u0aa0\3\2\2\2z\u0aa2\3\2\2\2|\u0aac\3\2\2\2~\u0ab4\3\2\2\2\u0080"+
		"\u0ac6\3\2\2\2\u0082\u0ad3\3\2\2\2\u0084\u0adb\3\2\2\2\u0086\u0ade\3\2"+
		"\2\2\u0088\u0ae1\3\2\2\2\u008a\u0aeb\3\2\2\2\u008c\u0af3\3\2\2\2\u008e"+
		"\u0afd\3\2\2\2\u0090\u0b02\3\2\2\2\u0092\u0b04\3\2\2\2\u0094\u0b13\3\2"+
		"\2\2\u0096\u0b15\3\2\2\2\u0098\u0b19\3\2\2\2\u009a\u0b1e\3\2\2\2\u009c"+
		"\u0b23\3\2\2\2\u009e\u0b25\3\2\2\2\u00a0\u0b28\3\2\2\2\u00a2\u0b2b\3\2"+
		"\2\2\u00a4\u0b2e\3\2\2\2\u00a6\u0b33\3\2\2\2\u00a8\u0b42\3\2\2\2\u00aa"+
		"\u0b44\3\2\2\2\u00ac\u0b46\3\2\2\2\u00ae\u0b60\3\2\2\2\u00b0\u0b62\3\2"+
		"\2\2\u00b2\u0b89\3\2\2\2\u00b4\u0b93\3\2\2\2\u00b6\u0b97\3\2\2\2\u00b8"+
		"\u0bae\3\2\2\2\u00ba\u0bba\3\2\2\2\u00bc\u0bc4\3\2\2\2\u00be\u0bc6\3\2"+
		"\2\2\u00c0\u0bd9\3\2\2\2\u00c2\u0be8\3\2\2\2\u00c4\u0bf7\3\2\2\2\u00c6"+
		"\u0bfb\3\2\2\2\u00c8\u0bfd\3\2\2\2\u00ca\u0c09\3\2\2\2\u00cc\u0c0b\3\2"+
		"\2\2\u00ce\u0c0d\3\2\2\2\u00d0\u0c10\3\2\2\2\u00d2\u0c14\3\2\2\2\u00d4"+
		"\u0c1e\3\2\2\2\u00d6\u0c20\3\2\2\2\u00d8\u0c28\3\2\2\2\u00da\u0c2a\3\2"+
		"\2\2\u00dc\u0c30\3\2\2\2\u00de\u0c35\3\2\2\2\u00e0\u0c49\3\2\2\2\u00e2"+
		"\u0c4d\3\2\2\2\u00e4\u0c4f\3\2\2\2\u00e6\u0c5b\3\2\2\2\u00e8\u0c66\3\2"+
		"\2\2\u00ea\u0c6b\3\2\2\2\u00ec\u0c70\3\2\2\2\u00ee\u0c75\3\2\2\2\u00f0"+
		"\u0c77\3\2\2\2\u00f2\u0c7e\3\2\2\2\u00f4\u0c80\3\2\2\2\u00f6\u0c85\3\2"+
		"\2\2\u00f8\u0c8a\3\2\2\2\u00fa\u0c8c\3\2\2\2\u00fc\u0c94\3\2\2\2\u00fe"+
		"\u0c9d\3\2\2\2\u0100\u0ca1\3\2\2\2\u0102\u0cb5\3\2\2\2\u0104\u0cb7\3\2"+
		"\2\2\u0106\u0cb9\3\2\2\2\u0108\u0cbb\3\2\2\2\u010a\u0cc5\3\2\2\2\u010c"+
		"\u0cc7\3\2\2\2\u010e\u0ccb\3\2\2\2\u0110\u0ccd\3\2\2\2\u0112\u0ccf\3\2"+
		"\2\2\u0114\u0cd7\3\2\2\2\u0116\u0cdb\3\2\2\2\u0118\u0cdd\3\2\2\2\u011a"+
		"\u0cdf\3\2\2\2\u011c\u0cf2\3\2\2\2\u011e\u0cf4\3\2\2\2\u0120\u0cf6\3\2"+
		"\2\2\u0122\u0cf8\3\2\2\2\u0124\u0d00\3\2\2\2\u0126\u0d0b\3\2\2\2\u0128"+
		"\u0d0d\3\2\2\2\u012a\u0d11\3\2\2\2\u012c\u0d17\3\2\2\2\u012e\u0d1b\3\2"+
		"\2\2\u0130\u0d1f\3\2\2\2\u0132\u0d21\3\2\2\2\u0134\u0d27\3\2\2\2\u0136"+
		"\u0d29\3\2\2\2\u0138\u0d2b\3\2\2\2\u013a\u0d2f\3\2\2\2\u013c\u0d33\3\2"+
		"\2\2\u013e\u0d35\3\2\2\2\u0140\u0d45\3\2\2\2\u0142\u0d48\3\2\2\2\u0144"+
		"\u0d52\3\2\2\2\u0146\u0d54\3\2\2\2\u0148\u0d6d\3\2\2\2\u014a\u0d6f\3\2"+
		"\2\2\u014c\u0d74\3\2\2\2\u014e\u0d7a\3\2\2\2\u0150\u0d81\3\2\2\2\u0152"+
		"\u0d87\3\2\2\2\u0154\u0d89\3\2\2\2\u0156\u0d8d\3\2\2\2\u0158\u0d91\3\2"+
		"\2\2\u015a\u0d93\3\2\2\2\u015c\u0d96\3\2\2\2\u015e\u0db3\3\2\2\2\u0160"+
		"\u0db5\3\2\2\2\u0162\u0dbd\3\2\2\2\u0164\u0dbf\3\2\2\2\u0166\u0dc2\3\2"+
		"\2\2\u0168\u0dc4\3\2\2\2\u016a\u0dc8\3\2\2\2\u016c\u0dd4\3\2\2\2\u016e"+
		"\u0ddb\3\2\2\2\u0170\u0ddd\3\2\2\2\u0172\u0de5\3\2\2\2\u0174\u0dea\3\2"+
		"\2\2\u0176\u0def\3\2\2\2\u0178\u0df2\3\2\2\2\u017a\u0df5\3\2\2\2\u017c"+
		"\u0dfd\3\2\2\2\u017e\u0e01\3\2\2\2\u0180\u0e0b\3\2\2\2\u0182\u0e19\3\2"+
		"\2\2\u0184\u0e23\3\2\2\2\u0186\u0e31\3\2\2\2\u0188\u0e38\3\2\2\2\u018a"+
		"\u0e3c\3\2\2\2\u018c\u0e3e\3\2\2\2\u018e\u0e43\3\2\2\2\u0190\u0e45\3\2"+
		"\2\2\u0192\u0e4e\3\2\2\2\u0194\u0e56\3\2\2\2\u0196\u0e60\3\2\2\2\u0198"+
		"\u0e62\3\2\2\2\u019a\u0e68\3\2\2\2\u019c\u0e6c\3\2\2\2\u019e\u0e71\3\2"+
		"\2\2\u01a0\u0e76\3\2\2\2\u01a2\u0e7a\3\2\2\2\u01a4\u0e82\3\2\2\2\u01a6"+
		"\u0e84\3\2\2\2\u01a8\u0e86\3\2\2\2\u01aa\u0e88\3\2\2\2\u01ac\u0e92\3\2"+
		"\2\2\u01ae\u0e94\3\2\2\2\u01b0\u0e98\3\2\2\2\u01b2\u0e9a\3\2\2\2\u01b4"+
		"\u0e9e\3\2\2\2\u01b6\u0ea8\3\2\2\2\u01b8\u0eb4\3\2\2\2\u01ba\u0eb6\3\2"+
		"\2\2\u01bc\u0ebe\3\2\2\2\u01be\u0ec7\3\2\2\2\u01c0\u0ecf\3\2\2\2\u01c2"+
		"\u0ed1\3\2\2\2\u01c4\u0ed3\3\2\2\2\u01c6\u0eda\3\2\2\2\u01c8\u0ee1\3\2"+
		"\2\2\u01ca\u0ee3\3\2\2\2\u01cc\u0ee5\3\2\2\2\u01ce\u0ee8\3\2\2\2\u01d0"+
		"\u0eed\3\2\2\2\u01d2\u0ef2\3\2\2\2\u01d4\u0ef4\3\2\2\2\u01d6\u0ef6\3\2"+
		"\2\2\u01d8\u0ef8\3\2\2\2\u01da\u0eff\3\2\2\2\u01dc\u0f03\3\2\2\2\u01de"+
		"\u0f05\3\2\2\2\u01e0\u0f0d\3\2\2\2\u01e2\u0f11\3\2\2\2\u01e4\u0f19\3\2"+
		"\2\2\u01e6\u0f20\3\2\2\2\u01e8\u0f22\3\2\2\2\u01ea\u0f29\3\2\2\2\u01ec"+
		"\u0f48\3\2\2\2\u01ee\u01f0\5\4\3\2\u01ef\u01f1\7\u014a\2\2\u01f0\u01ef"+
		"\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f3\3\2\2\2\u01f2\u01ee\3\2\2\2\u01f3"+
		"\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f7\3\2"+
		"\2\2\u01f6\u01f4\3\2\2\2\u01f7\u01f8\7\2\2\3\u01f8\3\3\2\2\2\u01f9\u01fa"+
		"\5\n\6\2\u01fa\5\3\2\2\2\u01fb\u01fc\5\u017c\u00bf\2\u01fc\7\3\2\2\2\u01fd"+
		"\u01fe\5\u01ec\u00f7\2\u01fe\t\3\2\2\2\u01ff\u0203\5\f\7\2\u0200\u0203"+
		"\5\16\b\2\u0201\u0203\5\u0092J\2\u0202\u01ff\3\2\2\2\u0202\u0200\3\2\2"+
		"\2\u0202\u0201\3\2\2\2\u0203\13\3\2\2\2\u0204\u0212\5N(\2\u0205\u0212"+
		"\5 \21\2\u0206\u0212\5\"\22\2\u0207\u0212\5(\25\2\u0208\u0212\5\64\33"+
		"\2\u0209\u0212\5F$\2\u020a\u0212\5H%\2\u020b\u0212\5J&\2\u020c\u0212\5"+
		"\62\32\2\u020d\u0212\5*\26\2\u020e\u0212\5&\24\2\u020f\u0212\5.\30\2\u0210"+
		"\u0212\5$\23\2\u0211\u0204\3\2\2\2\u0211\u0205\3\2\2\2\u0211\u0206\3\2"+
		"\2\2\u0211\u0207\3\2\2\2\u0211\u0208\3\2\2\2\u0211\u0209\3\2\2\2\u0211"+
		"\u020a\3\2\2\2\u0211\u020b\3\2\2\2\u0211\u020c\3\2\2\2\u0211\u020d\3\2"+
		"\2\2\u0211\u020e\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0210\3\2\2\2\u0212"+
		"\r\3\2\2\2\u0213\u0218\5\20\t\2\u0214\u0218\5\22\n\2\u0215\u0218\5\24"+
		"\13\2\u0216\u0218\5\26\f\2\u0217\u0213\3\2\2\2\u0217\u0214\3\2\2\2\u0217"+
		"\u0215\3\2\2\2\u0217\u0216\3\2\2\2\u0218\17\3\2\2\2\u0219\u021a\7\b\2"+
		"\2\u021a\u021b\7\60\2\2\u021b\u021c\5\u0190\u00c9\2\u021c\u021e\5\66\34"+
		"\2\u021d\u021f\5\36\20\2\u021e\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220"+
		"\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0223\3\2\2\2\u0222\u0224\7e"+
		"\2\2\u0223\u0222\3\2\2\2\u0223\u0224\3\2\2\2\u0224\u023e\3\2\2\2\u0225"+
		"\u0226\7\b\2\2\u0226\u0227\7\60\2\2\u0227\u0228\5\u0190\u00c9\2\u0228"+
		"\u0229\5\66\34\2\u0229\u022a\7\u00ed\2\2\u022a\u022b\7\u0109\2\2\u022b"+
		"\u022c\5\u0190\u00c9\2\u022c\u023e\3\2\2\2\u022d\u022e\7\b\2\2\u022e\u022f"+
		"\7\60\2\2\u022f\u0230\5\u0190\u00c9\2\u0230\u0231\5\66\34\2\u0231\u0232"+
		"\7Z\2\2\u0232\u0233\7\u0109\2\2\u0233\u0234\5\u0094K\2\u0234\u023e\3\2"+
		"\2\2\u0235\u0236\7\b\2\2\u0236\u0237\7\60\2\2\u0237\u0238\5\u0190\u00c9"+
		"\2\u0238\u0239\5\66\34\2\u0239\u023a\7\u00f6\2\2\u023a\u023b\7j\2\2\u023b"+
		"\u023c\5\u0190\u00c9\2\u023c\u023e\3\2\2\2\u023d\u0219\3\2\2\2\u023d\u0225"+
		"\3\2\2\2\u023d\u022d\3\2\2\2\u023d\u0235\3\2\2\2\u023e\21\3\2\2\2\u023f"+
		"\u0240\7\b\2\2\u0240\u0241\7j\2\2\u0241\u0242\5\u0094K\2\u0242\u0243\7"+
		"\u00ed\2\2\u0243\u0244\7\u0109\2\2\u0244\u0245\5\u0094K\2\u0245\u024e"+
		"\3\2\2\2\u0246\u0247\7\b\2\2\u0247\u0248\7j\2\2\u0248\u0249\5\u0094K\2"+
		"\u0249\u024a\7Z\2\2\u024a\u024b\7\u0109\2\2\u024b\u024c\5\u0094K\2\u024c"+
		"\u024e\3\2\2\2\u024d\u023f\3\2\2\2\u024d\u0246\3\2\2\2\u024e\23\3\2\2"+
		"\2\u024f\u0251\7\b\2\2\u0250\u0252\7_\2\2\u0251\u0250\3\2\2\2\u0251\u0252"+
		"\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0254\7\u00c5\2\2\u0254\u0255\5\u0094"+
		"K\2\u0255\u0256\7\u00ed\2\2\u0256\u0257\7\u0109\2\2\u0257\u0258\5\u0094"+
		"K\2\u0258\u0264\3\2\2\2\u0259\u025b\7\b\2\2\u025a\u025c\7_\2\2\u025b\u025a"+
		"\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025e\7\u00c5\2"+
		"\2\u025e\u025f\5\u0094K\2\u025f\u0260\7Z\2\2\u0260\u0261\7\u0109\2\2\u0261"+
		"\u0262\5\u0094K\2\u0262\u0264\3\2\2\2\u0263\u024f\3\2\2\2\u0263\u0259"+
		"\3\2\2\2\u0264\25\3\2\2\2\u0265\u0266\7\b\2\2\u0266\u0268\7t\2\2\u0267"+
		"\u0269\7\u00de\2\2\u0268\u0267\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u026b"+
		"\3\2\2\2\u026a\u026c\5\u0190\u00c9\2\u026b\u026a\3\2\2\2\u026c\u026d\3"+
		"\2\2\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0273\3\2\2\2\u026f"+
		"\u0271\5\30\r\2\u0270\u0272\7\u014b\2\2\u0271\u0270\3\2\2\2\u0271\u0272"+
		"\3\2\2\2\u0272\u0274\3\2\2\2\u0273\u026f\3\2\2\2\u0274\u0275\3\2\2\2\u0275"+
		"\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0298\3\2\2\2\u0277\u0278\7\b"+
		"\2\2\u0278\u027a\7t\2\2\u0279\u027b\7\u00de\2\2\u027a\u0279\3\2\2\2\u027a"+
		"\u027b\3\2\2\2\u027b\u027d\3\2\2\2\u027c\u027e\5\u0190\u00c9\2\u027d\u027c"+
		"\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u027d\3\2\2\2\u027f\u0280\3\2\2\2\u0280"+
		"\u0281\3\2\2\2\u0281\u0283\7\u00ed\2\2\u0282\u0284\7\u0097\2\2\u0283\u0282"+
		"\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0286\5\u0190\u00c9"+
		"\2\u0286\u0287\7\u0109\2\2\u0287\u0288\5\u0190\u00c9\2\u0288\u0298\3\2"+
		"\2\2\u0289\u028a\7\b\2\2\u028a\u028b\7t\2\2\u028b\u028c\5\u0190\u00c9"+
		"\2\u028c\u028d\7\u00ed\2\2\u028d\u028e\7\u0109\2\2\u028e\u028f\5\u0190"+
		"\u00c9\2\u028f\u0298\3\2\2\2\u0290\u0291\7\b\2\2\u0291\u0292\7t\2\2\u0292"+
		"\u0293\5\u0190\u00c9\2\u0293\u0294\7\u00f6\2\2\u0294\u0295\7j\2\2\u0295"+
		"\u0296\5\u0190\u00c9\2\u0296\u0298\3\2\2\2\u0297\u0265\3\2\2\2\u0297\u0277"+
		"\3\2\2\2\u0297\u0289\3\2\2\2\u0297\u0290\3\2\2\2\u0298\27\3\2\2\2\u0299"+
		"\u029b\7\3\2\2\u029a\u029c\7\u0097\2\2\u029b\u029a\3\2\2\2\u029b\u029c"+
		"\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u0373\5P)\2\u029e\u02a0\7\u00aa\2\2"+
		"\u029f\u02a1\7\u0097\2\2\u02a0\u029f\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1"+
		"\u02a4\3\2\2\2\u02a2\u02a3\78\2\2\u02a3\u02a5\7\u00ae\2\2\u02a4\u02a2"+
		"\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02a8\5\u0190\u00c9"+
		"\2\u02a7\u02a9\t\2\2\2\u02a8\u02a7\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u0373"+
		"\3\2\2\2\u02aa\u02ac\7\b\2\2\u02ab\u02ad\7\u0097\2\2\u02ac\u02ab\3\2\2"+
		"\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02b1\5\u0190\u00c9\2"+
		"\u02af\u02b0\7\u00f6\2\2\u02b0\u02b2\7\u00a1\2\2\u02b1\u02af\3\2\2\2\u02b1"+
		"\u02b2\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b4\7\u010a\2\2\u02b4\u02b7"+
		"\5\u00a6T\2\u02b5\u02b6\7\23\2\2\u02b6\u02b8\5\u0094K\2\u02b7\u02b5\3"+
		"\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02bb\3\2\2\2\u02b9\u02ba\7\u0081\2\2"+
		"\u02ba\u02bc\5\u00f6|\2\u02bb\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc"+
		"\u0373\3\2\2\2\u02bd\u02bf\7\b\2\2\u02be\u02c0\7\u0097\2\2\u02bf\u02be"+
		"\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\5\u0190\u00c9"+
		"\2\u02c2\u02c3\7\u00f6\2\2\u02c3\u02c4\7\34\2\2\u02c4\u02c5\5\u00f6|\2"+
		"\u02c5\u0373\3\2\2\2\u02c6\u02c8\7\b\2\2\u02c7\u02c9\7\u0097\2\2\u02c8"+
		"\u02c7\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\5\u0190"+
		"\u00c9\2\u02cb\u02cc\7\u00aa\2\2\u02cc\u02cd\7\34\2\2\u02cd\u0373\3\2"+
		"\2\2\u02ce\u02d0\7\b\2\2\u02cf\u02d1\7\u0097\2\2\u02d0\u02cf\3\2\2\2\u02d0"+
		"\u02d1\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d3\5\u0190\u00c9\2\u02d3\u02d4"+
		"\7\u00f6\2\2\u02d4\u0373\3\2\2\2\u02d5\u02d6\7\u00aa\2\2\u02d6\u02d7\7"+
		"P\2\2\u02d7\u0373\7Q\2\2\u02d8\u02da\7\b\2\2\u02d9\u02db\7\u0097\2\2\u02da"+
		"\u02d9\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02dd\5\u0190"+
		"\u00c9\2\u02dd\u02de\7\u00f6\2\2\u02de\u02df\7\u00fb\2\2\u02df\u02e0\7"+
		"\u0161\2\2\u02e0\u0373\3\2\2\2\u02e1\u02e3\7\b\2\2\u02e2\u02e4\7\u0097"+
		"\2\2\u02e3\u02e2\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5"+
		"\u02e6\5\u0190\u00c9\2\u02e6\u02e7\7\u00f6\2\2\u02e7\u02ee\7\u0152\2\2"+
		"\u02e8\u02e9\5\34\17\2\u02e9\u02ea\7\u0148\2\2\u02ea\u02ec\5\u00d0i\2"+
		"\u02eb\u02ed\7\u014b\2\2\u02ec\u02eb\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed"+
		"\u02ef\3\2\2\2\u02ee\u02e8\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02ee\3\2"+
		"\2\2\u02f0\u02f1\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u02f3\7\u0153\2\2\u02f3"+
		"\u0373\3\2\2\2\u02f4\u02f6\7\b\2\2\u02f5\u02f7\7\u0097\2\2\u02f6\u02f5"+
		"\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02f9\5\u0190\u00c9"+
		"\2\u02f9\u02fa\7\u00ef\2\2\u02fa\u02ff\7\u0152\2\2\u02fb\u02fd\5\34\17"+
		"\2\u02fc\u02fe\7\u014b\2\2\u02fd\u02fc\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe"+
		"\u0300\3\2\2\2\u02ff\u02fb\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u02ff\3\2"+
		"\2\2\u0301\u0302\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u0304\7\u0153\2\2\u0304"+
		"\u0373\3\2\2\2\u0305\u0307\7\b\2\2\u0306\u0308\7\u0097\2\2\u0307\u0306"+
		"\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u030a\5\u0190\u00c9"+
		"\2\u030a\u030b\7\u00f6\2\2\u030b\u030c\7\u00fc\2\2\u030c\u030d\7\u00e6"+
		"\2\2\u030d\u0373\3\2\2\2\u030e\u0373\7\u00b0\2\2\u030f\u0373\7\u00af\2"+
		"\2\u0310\u0373\7\u00cb\2\2\u0311\u0312\7\3\2\2\u0312\u0315\5T+\2\u0313"+
		"\u0314\7P\2\2\u0314\u0316\7\u010e\2\2\u0315\u0313\3\2\2\2\u0315\u0316"+
		"\3\2\2\2\u0316\u0373\3\2\2\2\u0317\u0318\7\3\2\2\u0318\u0373\5\32\16\2"+
		"\u0319\u031a\7\u010f\2\2\u031a\u031b\7\26\2\2\u031b\u0373\5\u0190\u00c9"+
		"\2\u031c\u031d\7\u00aa\2\2\u031d\u0320\7\26\2\2\u031e\u031f\78\2\2\u031f"+
		"\u0321\7\u00ae\2\2\u0320\u031e\3\2\2\2\u0320\u0321\3\2\2\2\u0321\u0322"+
		"\3\2\2\2\u0322\u0323\5\u0190\u00c9\2\u0323\u0324\t\2\2\2\u0324\u0373\3"+
		"\2\2\2\u0325\u0326\7\u00a7\2\2\u0326\u032a\7z\2\2\u0327\u032b\5\u0190"+
		"\u00c9\2\u0328\u032b\7\7\2\2\u0329\u032b\7\u010d\2\2\u032a\u0327\3\2\2"+
		"\2\u032a\u0328\3\2\2\2\u032a\u0329\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u0373"+
		"\3\2\2\2\u032c\u032d\7\u00ab\2\2\u032d\u0331\7z\2\2\u032e\u0332\5\u0190"+
		"\u00c9\2\u032f\u0332\7\7\2\2\u0330\u0332\7\u010d\2\2\u0331\u032e\3\2\2"+
		"\2\u0331\u032f\3\2\2\2\u0331\u0330\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0373"+
		"\3\2\2\2\u0333\u0334\7\u00ab\2\2\u0334\u0335\7\u00ee\2\2\u0335\u0336\7"+
		"z\2\2\u0336\u0373\5\u0190\u00c9\2\u0337\u0338\7\u00ab\2\2\u0338\u0339"+
		"\7\u008a\2\2\u0339\u033a\7z\2\2\u033a\u0373\5\u0190\u00c9\2\u033b\u033c"+
		"\7\u00a7\2\2\u033c\u033d\7i\2\2\u033d\u0373\5\u0190\u00c9\2\u033e\u033f"+
		"\7\u00ab\2\2\u033f\u0340\7i\2\2\u0340\u0373\5\u0190\u00c9\2\u0341\u0342"+
		"\7\u00ab\2\2\u0342\u0343\7\u00ee\2\2\u0343\u0344\7i\2\2\u0344\u0373\5"+
		"\u0190\u00c9\2\u0345\u0346\7\u00ab\2\2\u0346\u0347\7\u008a\2\2\u0347\u0348"+
		"\7i\2\2\u0348\u0373\5\u0190\u00c9\2\u0349\u034a\7\u0094\2\2\u034a\u034b"+
		"\7\u00dd\2\2\u034b\u0373\5\u0190\u00c9\2\u034c\u034d\7\u00f6\2\2\u034d"+
		"\u034e\7\u0088\2\2\u034e\u0373\7\u0094\2\2\u034f\u0350\7\u00f6\2\2\u0350"+
		"\u0351\7\u0087\2\2\u0351\u0373\7S\2\2\u0352\u0353\7\u00f6\2\2\u0353\u0354"+
		"\7\u0088\2\2\u0354\u0373\7S\2\2\u0355\u0356\7\u00f6\2\2\u0356\u0373\5"+
		"Z.\2\u0357\u0358\7\u00ef\2\2\u0358\u035d\7\u0152\2\2\u0359\u035b\5\\/"+
		"\2\u035a\u035c\7\u014b\2\2\u035b\u035a\3\2\2\2\u035b\u035c\3\2\2\2\u035c"+
		"\u035e\3\2\2\2\u035d\u0359\3\2\2\2\u035e\u035f\3\2\2\2\u035f\u035d\3\2"+
		"\2\2\u035f\u0360\3\2\2\2\u0360\u0361\3\2\2\2\u0361\u0362\7\u0153\2\2\u0362"+
		"\u0373\3\2\2\2\u0363\u0364\7\u00ba\2\2\u0364\u0373\5\u0190\u00c9\2\u0365"+
		"\u0366\7\u00d7\2\2\u0366\u0367\7\u00ba\2\2\u0367\u0373\5\u0190\u00c9\2"+
		"\u0368\u0369\7R\2\2\u0369\u0373\5\u0190\u00c9\2\u036a\u036b\7P\2\2\u036b"+
		"\u0373\7R\2\2\u036c\u036d\7Z\2\2\u036d\u036e\7\u0109\2\2\u036e\u0373\5"+
		"\u0190\u00c9\2\u036f\u0370\7\u00f6\2\2\u0370\u0371\7\u0101\2\2\u0371\u0373"+
		"\5\u0190\u00c9\2\u0372\u0299\3\2\2\2\u0372\u029e\3\2\2\2\u0372\u02aa\3"+
		"\2\2\2\u0372\u02bd\3\2\2\2\u0372\u02c6\3\2\2\2\u0372\u02ce\3\2\2\2\u0372"+
		"\u02d5\3\2\2\2\u0372\u02d8\3\2\2\2\u0372\u02e1\3\2\2\2\u0372\u02f4\3\2"+
		"\2\2\u0372\u0305\3\2\2\2\u0372\u030e\3\2\2\2\u0372\u030f\3\2\2\2\u0372"+
		"\u0310\3\2\2\2\u0372\u0311\3\2\2\2\u0372\u0317\3\2\2\2\u0372\u0319\3\2"+
		"\2\2\u0372\u031c\3\2\2\2\u0372\u0325\3\2\2\2\u0372\u032c\3\2\2\2\u0372"+
		"\u0333\3\2\2\2\u0372\u0337\3\2\2\2\u0372\u033b\3\2\2\2\u0372\u033e\3\2"+
		"\2\2\u0372\u0341\3\2\2\2\u0372\u0345\3\2\2\2\u0372\u0349\3\2\2\2\u0372"+
		"\u034c\3\2\2\2\u0372\u034f\3\2\2\2\u0372\u0352\3\2\2\2\u0372\u0355\3\2"+
		"\2\2\u0372\u0357\3\2\2\2\u0372\u0363\3\2\2\2\u0372\u0365\3\2\2\2\u0372"+
		"\u0368\3\2\2\2\u0372\u036a\3\2\2\2\u0372\u036c\3\2\2\2\u0372\u036f\3\2"+
		"\2\2\u0373\31\3\2\2\2\u0374\u0375\7\26\2\2\u0375\u0377\5\u0190\u00c9\2"+
		"\u0376\u0374\3\2\2\2\u0376\u0377\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u038a"+
		"\7~\2\2\u0379\u037a\7\\\2\2\u037a\u037b\7I\2\2\u037b\u037c\7\u0081\2\2"+
		"\u037c\u037d\7\u00bb\2\2\u037d\u0381\5\u0190\u00c9\2\u037e\u0382\7\36"+
		"\2\2\u037f\u0380\7P\2\2\u0380\u0382\7\36\2\2\u0381\u037e\3\2\2\2\u0381"+
		"\u037f\3\2\2\2\u0381\u0382\3\2\2\2\u0382\u0387\3\2\2\2\u0383\u0384\7?"+
		"\2\2\u0384\u0388\7\37\2\2\u0385\u0386\7?\2\2\u0386\u0388\7:\2\2\u0387"+
		"\u0383\3\2\2\2\u0387\u0385\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u038a\3\2"+
		"\2\2\u0389\u0376\3\2\2\2\u0389\u0379\3\2\2\2\u038a\33\3\2\2\2\u038b\u038c"+
		"\t\3\2\2\u038c\35\3\2\2\2\u038d\u038e\7\u008f\2\2\u038e\u038f\7\u00dd"+
		"\2\2\u038f\u0390\7Q\2\2\u0390\u03bb\7\u00be\2\2\u0391\u0392\7f\2\2\u0392"+
		"\u0393\7Q\2\2\u0393\u0394\7\u00dd\2\2\u0394\u0395\7Q\2\2\u0395\u03bb\7"+
		"\u00be\2\2\u0396\u0397\7r\2\2\u0397\u03bb\7;\2\2\u0398\u03bb\7\u00f9\2"+
		"\2\u0399\u039b\7\u0115\2\2\u039a\u039c\7\u00b0\2\2\u039b\u039a\3\2\2\2"+
		"\u039b\u039c\3\2\2\2\u039c\u039d\3\2\2\2\u039d\u039e\7\u00f4\2\2\u039e"+
		"\u03bb\7F\2\2\u039f\u03a1\7\u00b0\2\2\u03a0\u039f\3\2\2\2\u03a0\u03a1"+
		"\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03a3\7\u00f4\2\2\u03a3\u03a4\7\u00a5"+
		"\2\2\u03a4\u03a5\7\u009c\2\2\u03a5\u03a6\7\u0161\2\2\u03a6\u03a7\7b\2"+
		"\2\u03a7\u03a8\7\u0161\2\2\u03a8\u03a9\7\u00f6\2\2\u03a9\u03af\5\u0094"+
		"K\2\u03aa\u03ab\7\u0109\2\2\u03ab\u03b0\5\u0094K\2\u03ac\u03ad\7\u0148"+
		"\2\2\u03ad\u03b0\5\u0094K\2\u03ae\u03b0\7\34\2\2\u03af\u03aa\3\2\2\2\u03af"+
		"\u03ac\3\2\2\2\u03af\u03ae\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b2\7\u00f6"+
		"\2\2\u03b2\u03b3\5\u0094K\2\u03b3\u03b4\7\62\2\2\u03b4\u03b5\7\u009f\2"+
		"\2\u03b5\u03b6\7\u00ef\2\2\u03b6\u03b7\5\u0094K\2\u03b7\u03b8\7\u00ef"+
		"\2\2\u03b8\u03b9\7\7\2\2\u03b9\u03bb\3\2\2\2\u03ba\u038d\3\2\2\2\u03ba"+
		"\u0391\3\2\2\2\u03ba\u0396\3\2\2\2\u03ba\u0398\3\2\2\2\u03ba\u0399\3\2"+
		"\2\2\u03ba\u03a0\3\2\2\2\u03bb\37\3\2\2\2\u03bc\u03be\7\31\2\2\u03bd\u03bf"+
		"\7~\2\2\u03be\u03bd\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0"+
		"\u03c1\7\u00bb\2\2\u03c1\u03c2\5\u0094K\2\u03c2\u03c3\7\u00dd\2\2\u03c3"+
		"\u03c5\5\u0190\u00c9\2\u03c4\u03c6\5r:\2\u03c5\u03c4\3\2\2\2\u03c5\u03c6"+
		"\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7\u03c8\7\u0152\2\2\u03c8\u03c9\5\u01e2"+
		"\u00f2\2\u03c9\u03cb\7\u0153\2\2\u03ca\u03cc\5n8\2\u03cb\u03ca\3\2\2\2"+
		"\u03cb\u03cc\3\2\2\2\u03cc!\3\2\2\2\u03cd\u03ce\7\31\2\2\u03ce\u03d2\7"+
		"+\2\2\u03cf\u03d0\78\2\2\u03d0\u03d1\7P\2\2\u03d1\u03d3\7\u00ae\2\2\u03d2"+
		"\u03cf\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3\u03d4\3\2\2\2\u03d4\u03d6\5\u0094"+
		"K\2\u03d5\u03d7\7\u0087\2\2\u03d6\u03d5\3\2\2\2\u03d6\u03d7\3\2\2\2\u03d7"+
		"\u03da\3\2\2\2\u03d8\u03d9\7j\2\2\u03d9\u03db\5\u0094K\2\u03da\u03d8\3"+
		"\2\2\2\u03da\u03db\3\2\2\2\u03db\u03de\3\2\2\2\u03dc\u03dd\7\u0114\2\2"+
		"\u03dd\u03df\5\u0094K\2\u03de\u03dc\3\2\2\2\u03de\u03df\3\2\2\2\u03df"+
		"\u03e2\3\2\2\2\u03e0\u03e1\7\62\2\2\u03e1\u03e3\5\u0094K\2\u03e2\u03e0"+
		"\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3#\3\2\2\2\u03e4\u03e7\7\31\2\2\u03e5"+
		"\u03e6\7W\2\2\u03e6\u03e8\7d\2\2\u03e7\u03e5\3\2\2\2\u03e7\u03e8\3\2\2"+
		"\2\u03e8\u03ea\3\2\2\2\u03e9\u03eb\7_\2\2\u03ea\u03e9\3\2\2\2\u03ea\u03eb"+
		"\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec\u03ed\7\u00c5\2\2\u03ed\u0406\5\u0094"+
		"K\2\u03ee\u03f1\7\31\2\2\u03ef\u03f0\7W\2\2\u03f0\u03f2\7d\2\2\u03f1\u03ef"+
		"\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f4\3\2\2\2\u03f3\u03f5\7y\2\2\u03f4"+
		"\u03f3\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5\u03f7\3\2\2\2\u03f6\u03f8\7_"+
		"\2\2\u03f7\u03f6\3\2\2\2\u03f7\u03f8\3\2\2\2\u03f8\u03f9\3\2\2\2\u03f9"+
		"\u03fa\7\u00c5\2\2\u03fa\u03fb\5\u0094K\2\u03fb\u03fc\7\67\2\2\u03fc\u03ff"+
		"\5\u0190\u00c9\2\u03fd\u03fe\7@\2\2\u03fe\u0400\5\u0190\u00c9\2\u03ff"+
		"\u03fd\3\2\2\2\u03ff\u0400\3\2\2\2\u0400\u0403\3\2\2\2\u0401\u0402\7\u0082"+
		"\2\2\u0402\u0404\5\u0190\u00c9\2\u0403\u0401\3\2\2\2\u0403\u0404\3\2\2"+
		"\2\u0404\u0406\3\2\2\2\u0405\u03e4\3\2\2\2\u0405\u03ee\3\2\2\2\u0406%"+
		"\3\2\2\2\u0407\u0409\7\u00f6\2\2\u0408\u040a\t\4\2\2\u0409\u0408\3\2\2"+
		"\2\u0409\u040a\3\2\2\2\u040a\u040b\3\2\2\2\u040b\u040c\5\u0094K\2\u040c"+
		"\u0418\t\5\2\2\u040d\u0414\5\u00f6|\2\u040e\u040f\7\u015c\2\2\u040f\u0410"+
		"\5\u00f6|\2\u0410\u0411\7\u015c\2\2\u0411\u0414\3\2\2\2\u0412\u0414\7"+
		"\34\2\2\u0413\u040d\3\2\2\2\u0413\u040e\3\2\2\2\u0413\u0412\3\2\2\2\u0414"+
		"\u0416\3\2\2\2\u0415\u0417\7\u014b\2\2\u0416\u0415\3\2\2\2\u0416\u0417"+
		"\3\2\2\2\u0417\u0419\3\2\2\2\u0418\u0413\3\2\2\2\u0419\u041a\3\2\2\2\u041a"+
		"\u0418\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u042f\3\2\2\2\u041c\u041e\7\u00f6"+
		"\2\2\u041d\u041f\t\4\2\2\u041e\u041d\3\2\2\2\u041e\u041f\3\2\2\2\u041f"+
		"\u0420\3\2\2\2\u0420\u0421\7\u0135\2\2\u0421\u042a\7\u011a\2\2\u0422\u0426"+
		"\5\u0094K\2\u0423\u0426\7N\2\2\u0424\u0426\7\34\2\2\u0425\u0422\3\2\2"+
		"\2\u0425\u0423\3\2\2\2\u0425\u0424\3\2\2\2\u0426\u0428\3\2\2\2\u0427\u0429"+
		"\7\u014b\2\2\u0428\u0427\3\2\2\2\u0428\u0429\3\2\2\2\u0429\u042b\3\2\2"+
		"\2\u042a\u0425\3\2\2\2\u042b\u042c\3\2\2\2\u042c\u042a\3\2\2\2\u042c\u042d"+
		"\3\2\2\2\u042d\u042f\3\2\2\2\u042e\u0407\3\2\2\2\u042e\u041c\3\2\2\2\u042f"+
		"\'\3\2\2\2\u0430\u0432\7\31\2\2\u0431\u0433\7\26\2\2\u0432\u0431\3\2\2"+
		"\2\u0432\u0433\3\2\2\2\u0433\u0434\3\2\2\2\u0434\u0435\7z\2\2\u0435\u043a"+
		"\5\u0094K\2\u0436\u043b\7\16\2\2\u0437\u0438\7E\2\2\u0438\u043b\7R\2\2"+
		"\u0439\u043b\7\5\2\2\u043a\u0436\3\2\2\2\u043a\u0437\3\2\2\2\u043a\u0439"+
		"\3\2\2\2\u043b\u044b\3\2\2\2\u043c\u044c\7\u00bf\2\2\u043d\u044c\7 \2"+
		"\2\u043e\u044c\7|\2\2\u043f\u0449\7\177\2\2\u0440\u0445\7R\2\2\u0441\u0443"+
		"\5\u0094K\2\u0442\u0444\7\u014b\2\2\u0443\u0442\3\2\2\2\u0443\u0444\3"+
		"\2\2\2\u0444\u0446\3\2\2\2\u0445\u0441\3\2\2\2\u0446\u0447\3\2\2\2\u0447"+
		"\u0445\3\2\2\2\u0447\u0448\3\2\2\2\u0448\u044a\3\2\2\2\u0449\u0440\3\2"+
		"\2\2\u0449\u044a\3\2\2\2\u044a\u044c\3\2\2\2\u044b\u043c\3\2\2\2\u044b"+
		"\u043d\3\2\2\2\u044b\u043e\3\2\2\2\u044b\u043f\3\2\2\2\u044c\u044d\3\2"+
		"\2\2\u044d\u044e\7\u00dd\2\2\u044e\u0451\5\u0190\u00c9\2\u044f\u0450\7"+
		"\62\2\2\u0450\u0452\5\u0190\u00c9\2\u0451\u044f\3\2\2\2\u0451\u0452\3"+
		"\2\2\2\u0452\u045c\3\2\2\2\u0453\u0454\7P\2\2\u0454\u045d\7\36\2\2\u0455"+
		"\u0457\7\36\2\2\u0456\u0455\3\2\2\2\u0456\u0457\3\2\2\2\u0457\u0458\3"+
		"\2\2\2\u0458\u0459\7?\2\2\u0459\u045d\7:\2\2\u045a\u045b\7?\2\2\u045b"+
		"\u045d\7\37\2\2\u045c\u0453\3\2\2\2\u045c\u0456\3\2\2\2\u045c\u045a\3"+
		"\2\2\2\u045c\u045d\3\2\2\2\u045d\u0464\3\2\2\2\u045e\u0460\7-\2\2\u045f"+
		"\u0461\7$\2\2\u0460\u045f\3\2\2\2\u0460\u0461\3\2\2\2\u0461\u0462\3\2"+
		"\2\2\u0462\u0465\7a\2\2\u0463\u0465\7q\2\2\u0464\u045e\3\2\2\2\u0464\u0463"+
		"\3\2\2\2\u0464\u0465\3\2\2\2\u0465\u0468\3\2\2\2\u0466\u0467\7\u0085\2"+
		"\2\u0467\u0469\5\u0120\u0091\2\u0468\u0466\3\2\2\2\u0468\u0469\3\2\2\2"+
		"\u0469\u046a\3\2\2\2\u046a\u046b\7*\2\2\u046b\u046c\7^\2\2\u046c\u046d"+
		"\5\u0094K\2\u046d\u0472\7\u0152\2\2\u046e\u0470\5\u0094K\2\u046f\u0471"+
		"\7\u014b\2\2\u0470\u046f\3\2\2\2\u0470\u0471\3\2\2\2\u0471\u0473\3\2\2"+
		"\2\u0472\u046e\3\2\2\2\u0472\u0473\3\2\2\2\u0473\u0474\3\2\2\2\u0474\u0475"+
		"\7\u0153\2\2\u0475)\3\2\2\2\u0476\u047a\7g\2\2\u0477\u0478\7\64\2\2\u0478"+
		"\u0479\7\u00df\2\2\u0479\u047b\7-\2\2\u047a\u0477\3\2\2\2\u047a\u047b"+
		"\3\2\2\2\u047b\u0485\3\2\2\2\u047c\u047e\t\6\2\2\u047d\u047c\3\2\2\2\u047e"+
		"\u047f\3\2\2\2\u047f\u047d\3\2\2\2\u047f\u0480\3\2\2\2\u0480\u0486\3\2"+
		"\2\2\u0481\u0483\7\7\2\2\u0482\u0484\7]\2\2\u0483\u0482\3\2\2\2\u0483"+
		"\u0484\3\2\2\2\u0484\u0486\3\2\2\2\u0485\u047d\3\2\2\2\u0485\u0481\3\2"+
		"\2\2\u0486\u0487\3\2\2\2\u0487\u0499\7\u00dd\2\2\u0488\u048a\7t\2\2\u0489"+
		"\u0488\3\2\2\2\u0489\u048a\3\2\2\2\u048a\u048b\3\2\2\2\u048b\u048d\5\u0190"+
		"\u00c9\2\u048c\u0489\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u048c\3\2\2\2\u048e"+
		"\u048f\3\2\2\2\u048f\u049a\3\2\2\2\u0490\u0491\7\7\2\2\u0491\u0492\7\u0102"+
		"\2\2\u0492\u0493\7<\2\2\u0493\u0495\7j\2\2\u0494\u0496\5\u0094K\2\u0495"+
		"\u0494\3\2\2\2\u0496\u0497\3\2\2\2\u0497\u0495\3\2\2\2\u0497\u0498\3\2"+
		"\2\2\u0498\u049a\3\2\2\2\u0499\u048c\3\2\2\2\u0499\u0490\3\2\2\2\u049a"+
		"\u049b\3\2\2\2\u049b\u049c\5,\27\2\u049c\u05f2\3\2\2\2\u049d\u04a1\7g"+
		"\2\2\u049e\u049f\7\64\2\2\u049f\u04a0\7\u00df\2\2\u04a0\u04a2\7-\2\2\u04a1"+
		"\u049e\3\2\2\2\u04a1\u04a2\3\2\2\2\u04a2\u04c2\3\2\2\2\u04a3\u04a4\t\7"+
		"\2\2\u04a4\u04a9\7\u0152\2\2\u04a5\u04a7\5\u0094K\2\u04a6\u04a8\7\u014b"+
		"\2\2\u04a7\u04a6\3\2\2\2\u04a7\u04a8\3\2\2\2\u04a8\u04aa\3\2\2\2\u04a9"+
		"\u04a5\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab\u04a9\3\2\2\2\u04ab\u04ac\3\2"+
		"\2\2\u04ac\u04ad\3\2\2\2\u04ad\u04ae\7\u0153\2\2\u04ae\u04b0\3\2\2\2\u04af"+
		"\u04a3\3\2\2\2\u04b0\u04b1\3\2\2\2\u04b1\u04af\3\2\2\2\u04b1\u04b2\3\2"+
		"\2\2\u04b2\u04c3\3\2\2\2\u04b3\u04b5\7\7\2\2\u04b4\u04b6\7]\2\2\u04b5"+
		"\u04b4\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u04b7\3\2\2\2\u04b7\u04bc\7\u0152"+
		"\2\2\u04b8\u04ba\5\u0094K\2\u04b9\u04bb\7\u014b\2\2\u04ba\u04b9\3\2\2"+
		"\2\u04ba\u04bb\3\2\2\2\u04bb\u04bd\3\2\2\2\u04bc\u04b8\3\2\2\2\u04bd\u04be"+
		"\3\2\2\2\u04be\u04bc\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf\u04c0\3\2\2\2\u04c0"+
		"\u04c1\7\u0153\2\2\u04c1\u04c3\3\2\2\2\u04c2\u04af\3\2\2\2\u04c2\u04b3"+
		"\3\2\2\2\u04c3\u04c4\3\2\2\2\u04c4\u04c6\7\u00dd\2\2\u04c5\u04c7\7t\2"+
		"\2\u04c6\u04c5\3\2\2\2\u04c6\u04c7\3\2\2\2\u04c7\u04cc\3\2\2\2\u04c8\u04ca"+
		"\5\u0190\u00c9\2\u04c9\u04cb\7\u014b\2\2\u04ca\u04c9\3\2\2\2\u04ca\u04cb"+
		"\3\2\2\2\u04cb\u04cd\3\2\2\2\u04cc\u04c8\3\2\2\2\u04cd\u04ce\3\2\2\2\u04ce"+
		"\u04cc\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf\u04d0\3\2\2\2\u04d0\u04d1\5,"+
		"\27\2\u04d1\u05f2\3\2\2\2\u04d2\u04d6\7g\2\2\u04d3\u04d4\7\64\2\2\u04d4"+
		"\u04d5\7\u00df\2\2\u04d5\u04d7\7-\2\2\u04d6\u04d3\3\2\2\2\u04d6\u04d7"+
		"\3\2\2\2\u04d7\u04e1\3\2\2\2\u04d8\u04da\t\b\2\2\u04d9\u04d8\3\2\2\2\u04da"+
		"\u04db\3\2\2\2\u04db\u04d9\3\2\2\2\u04db\u04dc\3\2\2\2\u04dc\u04e2\3\2"+
		"\2\2\u04dd\u04df\7\7\2\2\u04de\u04e0\7]\2\2\u04df\u04de\3\2\2\2\u04df"+
		"\u04e0\3\2\2\2\u04e0\u04e2\3\2\2\2\u04e1\u04d9\3\2\2\2\u04e1\u04dd\3\2"+
		"\2\2\u04e2\u04e3\3\2\2\2\u04e3\u04f9\7\u00dd\2\2\u04e4\u04e9\7k\2\2\u04e5"+
		"\u04e7\5\u0190\u00c9\2\u04e6\u04e8\7\u014b\2\2\u04e7\u04e6\3\2\2\2\u04e7"+
		"\u04e8\3\2\2\2\u04e8\u04ea\3\2\2\2\u04e9\u04e5\3\2\2\2\u04ea\u04eb\3\2"+
		"\2\2\u04eb\u04e9\3\2\2\2\u04eb\u04ec\3\2\2\2\u04ec\u04fa\3\2\2\2\u04ed"+
		"\u04ee\7\7\2\2\u04ee\u04ef\7l\2\2\u04ef\u04f0\7<\2\2\u04f0\u04f5\7j\2"+
		"\2\u04f1\u04f3\5\u0094K\2\u04f2\u04f4\7\u014b\2\2\u04f3\u04f2\3\2\2\2"+
		"\u04f3\u04f4\3\2\2\2\u04f4\u04f6\3\2\2\2\u04f5\u04f1\3\2\2\2\u04f6\u04f7"+
		"\3\2\2\2\u04f7\u04f5\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8\u04fa\3\2\2\2\u04f9"+
		"\u04e4\3\2\2\2\u04f9\u04ed\3\2\2\2\u04fa\u04fb\3\2\2\2\u04fb\u04fc\5,"+
		"\27\2\u04fc\u05f2\3\2\2\2\u04fd\u0501\7g\2\2\u04fe\u04ff\7\64\2\2\u04ff"+
		"\u0500\7\u00df\2\2\u0500\u0502\7-\2\2\u0501\u04fe\3\2\2\2\u0501\u0502"+
		"\3\2\2\2\u0502\u050c\3\2\2\2\u0503\u0505\t\t\2\2\u0504\u0503\3\2\2\2\u0505"+
		"\u0506\3\2\2\2\u0506\u0504\3\2\2\2\u0506\u0507\3\2\2\2\u0507\u050d\3\2"+
		"\2\2\u0508\u050a\7\7\2\2\u0509\u050b\7]\2\2\u050a\u0509\3\2\2\2\u050a"+
		"\u050b\3\2\2\2\u050b\u050d\3\2\2\2\u050c\u0504\3\2\2\2\u050c\u0508\3\2"+
		"\2\2\u050d\u050e\3\2\2\2\u050e\u050f\7\u00dd\2\2\u050f\u0514\7\33\2\2"+
		"\u0510\u0512\5\u0094K\2\u0511\u0513\7\u014b\2\2\u0512\u0511\3\2\2\2\u0512"+
		"\u0513\3\2\2\2\u0513\u0515\3\2\2\2\u0514\u0510\3\2\2\2\u0515\u0516\3\2"+
		"\2\2\u0516\u0514\3\2\2\2\u0516\u0517\3\2\2\2\u0517\u0518\3\2\2\2\u0518"+
		"\u0519\5,\27\2\u0519\u05f2\3\2\2\2\u051a\u051e\7g\2\2\u051b\u051c\7\64"+
		"\2\2\u051c\u051d\7\u00df\2\2\u051d\u051f\7-\2\2\u051e\u051b\3\2\2\2\u051e"+
		"\u051f\3\2\2\2\u051f\u0525\3\2\2\2\u0520\u0526\7\u0080\2\2\u0521\u0523"+
		"\7\7\2\2\u0522\u0524\7]\2\2\u0523\u0522\3\2\2\2\u0523\u0524\3\2\2\2\u0524"+
		"\u0526\3\2\2\2\u0525\u0520\3\2\2\2\u0525\u0521\3\2\2\2\u0526\u0527\3\2"+
		"\2\2\u0527\u0528\7\u00dd\2\2\u0528\u0529\7.\2\2\u0529\u052a\7\u00a1\2"+
		"\2\u052a\u052f\7\u0118\2\2\u052b\u052d\5\u0190\u00c9\2\u052c\u052e\7\u014b"+
		"\2\2\u052d\u052c\3\2\2\2\u052d\u052e\3\2\2\2\u052e\u0530\3\2\2\2\u052f"+
		"\u052b\3\2\2\2\u0530\u0531\3\2\2\2\u0531\u052f\3\2\2\2\u0531\u0532\3\2"+
		"\2\2\u0532\u0533\3\2\2\2\u0533\u0534\5,\27\2\u0534\u05f2\3\2\2\2\u0535"+
		"\u0539\7g\2\2\u0536\u0537\7\64\2\2\u0537\u0538\7\u00df\2\2\u0538\u053a"+
		"\7-\2\2\u0539\u0536\3\2\2\2\u0539\u053a\3\2\2\2\u053a\u0540\3\2\2\2\u053b"+
		"\u0541\7\u0080\2\2\u053c\u053e\7\7\2\2\u053d\u053f\7]\2\2\u053e\u053d"+
		"\3\2\2\2\u053e\u053f\3\2\2\2\u053f\u0541\3\2\2\2\u0540\u053b\3\2\2\2\u0540"+
		"\u053c\3\2\2\2\u0541\u0542\3\2\2\2\u0542\u0543\7\u00dd\2\2\u0543\u0544"+
		"\7.\2\2\u0544\u0549\7\u00f5\2\2\u0545\u0547\5\u0094K\2\u0546\u0548\7\u014b"+
		"\2\2\u0547\u0546\3\2\2\2\u0547\u0548\3\2\2\2\u0548\u054a\3\2\2\2\u0549"+
		"\u0545\3\2\2\2\u054a\u054b\3\2\2\2\u054b\u0549\3\2\2\2\u054b\u054c\3\2"+
		"\2\2\u054c\u054d\3\2\2\2\u054d\u054e\5,\27\2\u054e\u05f2\3\2\2\2\u054f"+
		"\u0553\7g\2\2\u0550\u0551\7\64\2\2\u0551\u0552\7\u00df\2\2\u0552\u0554"+
		"\7-\2\2\u0553\u0550\3\2\2\2\u0553\u0554\3\2\2\2\u0554\u055a\3\2\2\2\u0555"+
		"\u055b\7*\2\2\u0556\u0558\7\7\2\2\u0557\u0559\7]\2\2\u0558\u0557\3\2\2"+
		"\2\u0558\u0559\3\2\2\2\u0559\u055b\3\2\2\2\u055a\u0555\3\2\2\2\u055a\u0556"+
		"\3\2\2\2\u055b\u055c\3\2\2\2\u055c\u055f\7\u00dd\2\2\u055d\u0560\5B\""+
		"\2\u055e\u0560\5D#\2\u055f\u055d\3\2\2\2\u055f\u055e\3\2\2\2\u0560\u0561"+
		"\3\2\2\2\u0561\u0562\5,\27\2\u0562\u05f2\3\2\2\2\u0563\u0567\7g\2\2\u0564"+
		"\u0565\7\64\2\2\u0565\u0566\7\u00df\2\2\u0566\u0568\7-\2\2\u0567\u0564"+
		"\3\2\2\2\u0567\u0568\3\2\2\2\u0568\u056e\3\2\2\2\u0569\u056f\7\u0080\2"+
		"\2\u056a\u056c\7\7\2\2\u056b\u056d\7]\2\2\u056c\u056b\3\2\2\2\u056c\u056d"+
		"\3\2\2\2\u056d\u056f\3\2\2\2\u056e\u0569\3\2\2\2\u056e\u056a\3\2\2\2\u056f"+
		"\u0570\3\2\2\2\u0570\u0571\7\u00dd\2\2\u0571\u0576\7\u00c5\2\2\u0572\u0574"+
		"\5\u0094K\2\u0573\u0575\7\u014b\2\2\u0574\u0573\3\2\2\2\u0574\u0575\3"+
		"\2\2\2\u0575\u0577\3\2\2\2\u0576\u0572\3\2\2\2\u0577\u0578\3\2\2\2\u0578"+
		"\u0576\3\2\2\2\u0578\u0579\3\2\2\2\u0579\u057a\3\2\2\2\u057a\u057b\5,"+
		"\27\2\u057b\u05f2\3\2\2\2\u057c\u0580\7g\2\2\u057d\u057e\7\64\2\2\u057e"+
		"\u057f\7\u00df\2\2\u057f\u0581\7-\2\2\u0580\u057d\3\2\2\2\u0580\u0581"+
		"\3\2\2\2\u0581\u058f\3\2\2\2\u0582\u0588\7m\2\2\u0583\u0585\7\177\2\2"+
		"\u0584\u0586\7\u014b\2\2\u0585\u0584\3\2\2\2\u0585\u0586\3\2\2\2\u0586"+
		"\u0588\3\2\2\2\u0587\u0582\3\2\2\2\u0587\u0583\3\2\2\2\u0588\u0589\3\2"+
		"\2\2\u0589\u0587\3\2\2\2\u0589\u058a\3\2\2\2\u058a\u0590\3\2\2\2\u058b"+
		"\u058d\7\7\2\2\u058c\u058e\7]\2\2\u058d\u058c\3\2\2\2\u058d\u058e\3\2"+
		"\2\2\u058e\u0590\3\2\2\2\u058f\u0587\3\2\2\2\u058f\u058b\3\2\2\2\u0590"+
		"\u0591\3\2\2\2\u0591\u0592\7\u00dd\2\2\u0592\u0593\7\u00c6\2\2\u0593\u0598"+
		"\7\u00dc\2\2\u0594\u0596\5\u0094K\2\u0595\u0597\7\u014b\2\2\u0596\u0595"+
		"\3\2\2\2\u0596\u0597\3\2\2\2\u0597\u0599\3\2\2\2\u0598\u0594\3\2\2\2\u0599"+
		"\u059a\3\2\2\2\u059a\u0598\3\2\2\2\u059a\u059b\3\2\2\2\u059b\u059c\3\2"+
		"\2\2\u059c\u059d\5,\27\2\u059d\u05f2\3\2\2\2\u059e\u05a2\7g\2\2\u059f"+
		"\u05a0\7\64\2\2\u05a0\u05a1\7\u00df\2\2\u05a1\u05a3\7-\2\2\u05a2\u059f"+
		"\3\2\2\2\u05a2\u05a3\3\2\2\2\u05a3\u05b0\3\2\2\2\u05a4\u05a6\t\n\2\2\u05a5"+
		"\u05a7\7\u014b\2\2\u05a6\u05a5\3\2\2\2\u05a6\u05a7\3\2\2\2\u05a7\u05a9"+
		"\3\2\2\2\u05a8\u05a4\3\2\2\2\u05a9\u05aa\3\2\2\2\u05aa\u05a8\3\2\2\2\u05aa"+
		"\u05ab\3\2\2\2\u05ab\u05b1\3\2\2\2\u05ac\u05ae\7\7\2\2\u05ad\u05af\7]"+
		"\2\2\u05ae\u05ad\3\2\2\2\u05ae\u05af\3\2\2\2\u05af\u05b1\3\2\2\2\u05b0"+
		"\u05a8\3\2\2\2\u05b0\u05ac\3\2\2\2\u05b1\u05b2\3\2\2\2\u05b2\u05b3\7\u00dd"+
		"\2\2\u05b3\u05b8\7j\2\2\u05b4\u05b6\5\u0094K\2\u05b5\u05b7\7\u014b\2\2"+
		"\u05b6\u05b5\3\2\2\2\u05b6\u05b7\3\2\2\2\u05b7\u05b9\3\2\2\2\u05b8\u05b4"+
		"\3\2\2\2\u05b9\u05ba\3\2\2\2\u05ba\u05b8\3\2\2\2\u05ba\u05bb\3\2\2\2\u05bb"+
		"\u05bc\3\2\2\2\u05bc\u05bd\5,\27\2\u05bd\u05f2\3\2\2\2\u05be\u05c2\7g"+
		"\2\2\u05bf\u05c0\7\64\2\2\u05c0\u05c1\7\u00df\2\2\u05c1\u05c3\7-\2\2\u05c2"+
		"\u05bf\3\2\2\2\u05c2\u05c3\3\2\2\2\u05c3\u05c9\3\2\2\2\u05c4\u05ca\7\31"+
		"\2\2\u05c5\u05c7\7\7\2\2\u05c6\u05c8\7]\2\2\u05c7\u05c6\3\2\2\2\u05c7"+
		"\u05c8\3\2\2\2\u05c8\u05ca\3\2\2\2\u05c9\u05c4\3\2\2\2\u05c9\u05c5\3\2"+
		"\2\2\u05ca\u05cb\3\2\2\2\u05cb\u05cc\7\u00dd\2\2\u05cc\u05d1\7\u0101\2"+
		"\2\u05cd\u05cf\5\u0094K\2\u05ce\u05d0\7\u014b\2\2\u05cf\u05ce\3\2\2\2"+
		"\u05cf\u05d0\3\2\2\2\u05d0\u05d2\3\2\2\2\u05d1\u05cd\3\2\2\2\u05d2\u05d3"+
		"\3\2\2\2\u05d3\u05d1\3\2\2\2\u05d3\u05d4\3\2\2\2\u05d4\u05d5\3\2\2\2\u05d5"+
		"\u05d6\5,\27\2\u05d6\u05f2\3\2\2\2\u05d7\u05db\7g\2\2\u05d8\u05d9\7\u0089"+
		"\2\2\u05d9\u05da\7\u00df\2\2\u05da\u05dc\7-\2\2\u05db\u05d8\3\2\2\2\u05db"+
		"\u05dc\3\2\2\2\u05dc\u05e1\3\2\2\2\u05dd\u05df\5\u0094K\2\u05de\u05e0"+
		"\7\u014b\2\2\u05df\u05de\3\2\2\2\u05df\u05e0\3\2\2\2\u05e0\u05e2\3\2\2"+
		"\2\u05e1\u05dd\3\2\2\2\u05e2\u05e3\3\2\2\2\u05e3\u05e1\3\2\2\2\u05e3\u05e4"+
		"\3\2\2\2\u05e4\u05e5\3\2\2\2\u05e5\u05ea\7\62\2\2\u05e6\u05e8\5\u0094"+
		"K\2\u05e7\u05e9\7\u014b\2\2\u05e8\u05e7\3\2\2\2\u05e8\u05e9\3\2\2\2\u05e9"+
		"\u05eb\3\2\2\2\u05ea\u05e6\3\2\2\2\u05eb\u05ec\3\2\2\2\u05ec\u05ea\3\2"+
		"\2\2\u05ec\u05ed\3\2\2\2\u05ed\u05ef\3\2\2\2\u05ee\u05f0\t\2\2\2\u05ef"+
		"\u05ee\3\2\2\2\u05ef\u05f0\3\2\2\2\u05f0\u05f2\3\2\2\2\u05f1\u0476\3\2"+
		"\2\2\u05f1\u049d\3\2\2\2\u05f1\u04d2\3\2\2\2\u05f1\u04fd\3\2\2\2\u05f1"+
		"\u051a\3\2\2\2\u05f1\u0535\3\2\2\2\u05f1\u054f\3\2\2\2\u05f1\u0563\3\2"+
		"\2\2\u05f1\u057c\3\2\2\2\u05f1\u059e\3\2\2\2\u05f1\u05be\3\2\2\2\u05f1"+
		"\u05d7\3\2\2\2\u05f2+\3\2\2\2\u05f3\u05fc\7\62\2\2\u05f4\u05f6\7\65\2"+
		"\2\u05f5\u05f4\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u05f7\3\2\2\2\u05f7\u05fd"+
		"\5\u0094K\2\u05f8\u05fa\7\u00e8\2\2\u05f9\u05fb\7\u014b\2\2\u05fa\u05f9"+
		"\3\2\2\2\u05fa\u05fb\3\2\2\2\u05fb\u05fd\3\2\2\2\u05fc\u05f5\3\2\2\2\u05fc"+
		"\u05f8\3\2\2\2\u05fd\u05fe\3\2\2\2\u05fe\u05fc\3\2\2\2\u05fe\u05ff\3\2"+
		"\2\2\u05ff\u0601\3\2\2\2\u0600\u0602\t\2\2\2\u0601\u0600\3\2\2\2\u0601"+
		"\u0602\3\2\2\2\u0602-\3\2\2\2\u0603\u060d\7\64\2\2\u0604\u0606\t\6\2\2"+
		"\u0605\u0604\3\2\2\2\u0606\u0607\3\2\2\2\u0607\u0605\3\2\2\2\u0607\u0608"+
		"\3\2\2\2\u0608\u060e\3\2\2\2\u0609\u060b\7\7\2\2\u060a\u060c\7]\2\2\u060b"+
		"\u060a\3\2\2\2\u060b\u060c\3\2\2\2\u060c\u060e\3\2\2\2\u060d\u0605\3\2"+
		"\2\2\u060d\u0609\3\2\2\2\u060e\u060f\3\2\2\2\u060f\u0627\7\u00dd\2\2\u0610"+
		"\u0612\7t\2\2\u0611\u0610\3\2\2\2\u0611\u0612\3\2\2\2\u0612\u0617\3\2"+
		"\2\2\u0613\u0615\5\u0190\u00c9\2\u0614\u0616\7\u014b\2\2\u0615\u0614\3"+
		"\2\2\2\u0615\u0616\3\2\2\2\u0616\u0618\3\2\2\2\u0617\u0613\3\2\2\2\u0618"+
		"\u0619\3\2\2\2\u0619\u0617\3\2\2\2\u0619\u061a\3\2\2\2\u061a\u0628\3\2"+
		"\2\2\u061b\u061c\7\7\2\2\u061c\u061d\7\u0102\2\2\u061d\u061e\7<\2\2\u061e"+
		"\u0623\7j\2\2\u061f\u0621\5\u0094K\2\u0620\u0622\7\u014b\2\2\u0621\u0620"+
		"\3\2\2\2\u0621\u0622\3\2\2\2\u0622\u0624\3\2\2\2\u0623\u061f\3\2\2\2\u0624"+
		"\u0625\3\2\2\2\u0625\u0623\3\2\2\2\u0625\u0626\3\2\2\2\u0626\u0628\3\2"+
		"\2\2\u0627\u0611\3\2\2\2\u0627\u061b\3\2\2\2\u0628\u0629\3\2\2\2\u0629"+
		"\u062a\5\60\31\2\u062a\u0749\3\2\2\2\u062b\u0645\7\64\2\2\u062c\u0631"+
		"\t\7\2\2\u062d\u062f\5\u0094K\2\u062e\u0630\7\u014b\2\2\u062f\u062e\3"+
		"\2\2\2\u062f\u0630\3\2\2\2\u0630\u0632\3\2\2\2\u0631\u062d\3\2\2\2\u0632"+
		"\u0633\3\2\2\2\u0633\u0631\3\2\2\2\u0633\u0634\3\2\2\2\u0634\u0636\3\2"+
		"\2\2\u0635\u062c\3\2\2\2\u0636\u0637\3\2\2\2\u0637\u0635\3\2\2\2\u0637"+
		"\u0638\3\2\2\2\u0638\u0646\3\2\2\2\u0639\u063b\7\7\2\2\u063a\u063c\7]"+
		"\2\2\u063b\u063a\3\2\2\2\u063b\u063c\3\2\2\2\u063c\u0641\3\2\2\2\u063d"+
		"\u063f\5\u0094K\2\u063e\u0640\7\u014b\2\2\u063f\u063e\3\2\2\2\u063f\u0640"+
		"\3\2\2\2\u0640\u0642\3\2\2\2\u0641\u063d\3\2\2\2\u0642\u0643\3\2\2\2\u0643"+
		"\u0641\3\2\2\2\u0643\u0644\3\2\2\2\u0644\u0646\3\2\2\2\u0645\u0635\3\2"+
		"\2\2\u0645\u0639\3\2\2\2\u0646\u0647\3\2\2\2\u0647\u064f\7\u00dd\2\2\u0648"+
		"\u064a\7t\2\2\u0649\u0648\3\2\2\2\u0649\u064a\3\2\2\2\u064a\u064b\3\2"+
		"\2\2\u064b\u064d\5\u0190\u00c9\2\u064c\u064e\7\u014b\2\2\u064d\u064c\3"+
		"\2\2\2\u064d\u064e\3\2\2\2\u064e\u0650\3\2\2\2\u064f\u0649\3\2\2\2\u0650"+
		"\u0651\3\2\2\2\u0651\u064f\3\2\2\2\u0651\u0652\3\2\2\2\u0652\u0653\3\2"+
		"\2\2\u0653\u0654\5\60\31\2\u0654\u0749\3\2\2\2\u0655\u0662\7\64\2\2\u0656"+
		"\u0658\t\b\2\2\u0657\u0659\7\u014b\2\2\u0658\u0657\3\2\2\2\u0658\u0659"+
		"\3\2\2\2\u0659\u065b\3\2\2\2\u065a\u0656\3\2\2\2\u065b\u065c\3\2\2\2\u065c"+
		"\u065a\3\2\2\2\u065c\u065d\3\2\2\2\u065d\u0663\3\2\2\2\u065e\u0660\7\7"+
		"\2\2\u065f\u0661\7]\2\2\u0660\u065f\3\2\2\2\u0660\u0661\3\2\2\2\u0661"+
		"\u0663\3\2\2\2\u0662\u065a\3\2\2\2\u0662\u065e\3\2\2\2\u0663\u0664\3\2"+
		"\2\2\u0664\u067a\7\u00dd\2\2\u0665\u0666\7k\2\2\u0666\u0668\5\u0094K\2"+
		"\u0667\u0669\7\u014b\2\2\u0668\u0667\3\2\2\2\u0668\u0669\3\2\2\2\u0669"+
		"\u066b\3\2\2\2\u066a\u0665\3\2\2\2\u066b\u066c\3\2\2\2\u066c\u066a\3\2"+
		"\2\2\u066c\u066d\3\2\2\2\u066d\u067b\3\2\2\2\u066e\u066f\7\7\2\2\u066f"+
		"\u0670\7l\2\2\u0670\u0671\7<\2\2\u0671\u0676\7j\2\2\u0672\u0674\5\u0094"+
		"K\2\u0673\u0675\7\u014b\2\2\u0674\u0673\3\2\2\2\u0674\u0675\3\2\2\2\u0675"+
		"\u0677\3\2\2\2\u0676\u0672\3\2\2\2\u0677\u0678\3\2\2\2\u0678\u0676\3\2"+
		"\2\2\u0678\u0679\3\2\2\2\u0679\u067b\3\2\2\2\u067a\u066a\3\2\2\2\u067a"+
		"\u066e\3\2\2\2\u067b\u067c\3\2\2\2\u067c\u067d\5\60\31\2\u067d\u0749\3"+
		"\2\2\2\u067e\u068b\7\64\2\2\u067f\u0681\t\t\2\2\u0680\u0682\7\u014b\2"+
		"\2\u0681\u0680\3\2\2\2\u0681\u0682\3\2\2\2\u0682\u0684\3\2\2\2\u0683\u067f"+
		"\3\2\2\2\u0684\u0685\3\2\2\2\u0685\u0683\3\2\2\2\u0685\u0686\3\2\2\2\u0686"+
		"\u068c\3\2\2\2\u0687\u0689\7\7\2\2\u0688\u068a\7]\2\2\u0689\u0688\3\2"+
		"\2\2\u0689\u068a\3\2\2\2\u068a\u068c\3\2\2\2\u068b\u0683\3\2\2\2\u068b"+
		"\u0687\3\2\2\2\u068c\u068d\3\2\2\2\u068d\u068e\7\u00dd\2\2\u068e\u0693"+
		"\7\33\2\2\u068f\u0691\5\u0094K\2\u0690\u0692\7\u014b\2\2\u0691\u0690\3"+
		"\2\2\2\u0691\u0692\3\2\2\2\u0692\u0694\3\2\2\2\u0693\u068f\3\2\2\2\u0694"+
		"\u0695\3\2\2\2\u0695\u0693\3\2\2\2\u0695\u0696\3\2\2\2\u0696\u0697\3\2"+
		"\2\2\u0697\u0698\5\60\31\2\u0698\u0749\3\2\2\2\u0699\u069f\7\64\2\2\u069a"+
		"\u06a0\7\u0080\2\2\u069b\u069d\7\7\2\2\u069c\u069e\7]\2\2\u069d\u069c"+
		"\3\2\2\2\u069d\u069e\3\2\2\2\u069e\u06a0\3\2\2\2\u069f\u069a\3\2\2\2\u069f"+
		"\u069b\3\2\2\2\u06a0\u06a1\3\2\2\2\u06a1\u06a2\7\u00dd\2\2\u06a2\u06a3"+
		"\7.\2\2\u06a3\u06a4\7\u00a1\2\2\u06a4\u06a9\7\u0118\2\2\u06a5\u06a7\5"+
		"\u0094K\2\u06a6\u06a8\7\u014b\2\2\u06a7\u06a6\3\2\2\2\u06a7\u06a8\3\2"+
		"\2\2\u06a8\u06aa\3\2\2\2\u06a9\u06a5\3\2\2\2\u06aa\u06ab\3\2\2\2\u06ab"+
		"\u06a9\3\2\2\2\u06ab\u06ac\3\2\2\2\u06ac\u06ad\3\2\2\2\u06ad\u06ae\5\60"+
		"\31\2\u06ae\u0749\3\2\2\2\u06af\u06b5\7\64\2\2\u06b0\u06b6\7\u0080\2\2"+
		"\u06b1\u06b3\7\7\2\2\u06b2\u06b4\7]\2\2\u06b3\u06b2\3\2\2\2\u06b3\u06b4"+
		"\3\2\2\2\u06b4\u06b6\3\2\2\2\u06b5\u06b0\3\2\2\2\u06b5\u06b1\3\2\2\2\u06b6"+
		"\u06b7\3\2\2\2\u06b7\u06b8\7\u00dd\2\2\u06b8\u06b9\7.\2\2\u06b9\u06be"+
		"\7\u00f5\2\2\u06ba\u06bc\5\u0094K\2\u06bb\u06bd\7\u014b\2\2\u06bc\u06bb"+
		"\3\2\2\2\u06bc\u06bd\3\2\2\2\u06bd\u06bf\3\2\2\2\u06be\u06ba\3\2\2\2\u06bf"+
		"\u06c0\3\2\2\2\u06c0\u06be\3\2\2\2\u06c0\u06c1\3\2\2\2\u06c1\u06c2\3\2"+
		"\2\2\u06c2\u06c3\5\60\31\2\u06c3\u0749\3\2\2\2\u06c4\u06ca\7\64\2\2\u06c5"+
		"\u06cb\7*\2\2\u06c6\u06c8\7\7\2\2\u06c7\u06c9\7]\2\2\u06c8\u06c7\3\2\2"+
		"\2\u06c8\u06c9\3\2\2\2\u06c9\u06cb\3\2\2\2\u06ca\u06c5\3\2\2\2\u06ca\u06c6"+
		"\3\2\2\2\u06cb\u06cc\3\2\2\2\u06cc\u06cf\7\u00dd\2\2\u06cd\u06d0\5B\""+
		"\2\u06ce\u06d0\5D#\2\u06cf\u06cd\3\2\2\2\u06cf\u06ce\3\2\2\2\u06d0\u06d1"+
		"\3\2\2\2\u06d1\u06d2\5\60\31\2\u06d2\u0749\3\2\2\2\u06d3\u06d9\7\64\2"+
		"\2\u06d4\u06da\7\u0080\2\2\u06d5\u06d7\7\7\2\2\u06d6\u06d8\7]\2\2\u06d7"+
		"\u06d6\3\2\2\2\u06d7\u06d8\3\2\2\2\u06d8\u06da\3\2\2\2\u06d9\u06d4\3\2"+
		"\2\2\u06d9\u06d5\3\2\2\2\u06da\u06db\3\2\2\2\u06db\u06dc\7\u00dd\2\2\u06dc"+
		"\u06e1\7\u00c5\2\2\u06dd\u06df\5\u0094K\2\u06de\u06e0\7\u014b\2\2\u06df"+
		"\u06de\3\2\2\2\u06df\u06e0\3\2\2\2\u06e0\u06e2\3\2\2\2\u06e1\u06dd\3\2"+
		"\2\2\u06e2\u06e3\3\2\2\2\u06e3\u06e1\3\2\2\2\u06e3\u06e4\3\2\2\2\u06e4"+
		"\u06e5\3\2\2\2\u06e5\u06e6\5\60\31\2\u06e6\u0749\3\2\2\2\u06e7\u06f4\7"+
		"\64\2\2\u06e8\u06ea\t\13\2\2\u06e9\u06eb\7\u014b\2\2\u06ea\u06e9\3\2\2"+
		"\2\u06ea\u06eb\3\2\2\2\u06eb\u06ed\3\2\2\2\u06ec\u06e8\3\2\2\2\u06ed\u06ee"+
		"\3\2\2\2\u06ee\u06ec\3\2\2\2\u06ee\u06ef\3\2\2\2\u06ef\u06f5\3\2\2\2\u06f0"+
		"\u06f2\7\7\2\2\u06f1\u06f3\7]\2\2\u06f2\u06f1\3\2\2\2\u06f2\u06f3\3\2"+
		"\2\2\u06f3\u06f5\3\2\2\2\u06f4\u06ec\3\2\2\2\u06f4\u06f0\3\2\2\2\u06f5"+
		"\u06f6\3\2\2\2\u06f6\u06f7\7\u00dd\2\2\u06f7\u06f8\7\u00c6\2\2\u06f8\u06fd"+
		"\7\u00dc\2\2\u06f9\u06fb\5\u0094K\2\u06fa\u06fc\7\u014b\2\2\u06fb\u06fa"+
		"\3\2\2\2\u06fb\u06fc\3\2\2\2\u06fc\u06fe\3\2\2\2\u06fd\u06f9\3\2\2\2\u06fe"+
		"\u06ff\3\2\2\2\u06ff\u06fd\3\2\2\2\u06ff\u0700\3\2\2\2\u0700\u0701\3\2"+
		"\2\2\u0701\u0702\5\60\31\2\u0702\u0749\3\2\2\2\u0703\u0710\7\64\2\2\u0704"+
		"\u0706\t\n\2\2\u0705\u0707\7\u014b\2\2\u0706\u0705\3\2\2\2\u0706\u0707"+
		"\3\2\2\2\u0707\u0709\3\2\2\2\u0708\u0704\3\2\2\2\u0709\u070a\3\2\2\2\u070a"+
		"\u0708\3\2\2\2\u070a\u070b\3\2\2\2\u070b\u0711\3\2\2\2\u070c\u070e\7\7"+
		"\2\2\u070d\u070f\7]\2\2\u070e\u070d\3\2\2\2\u070e\u070f\3\2\2\2\u070f"+
		"\u0711\3\2\2\2\u0710\u0708\3\2\2\2\u0710\u070c\3\2\2\2\u0711\u0712\3\2"+
		"\2\2\u0712\u0713\7\u00dd\2\2\u0713\u0718\7j\2\2\u0714\u0716\5\u0094K\2"+
		"\u0715\u0717\7\u014b\2\2\u0716\u0715\3\2\2\2\u0716\u0717\3\2\2\2\u0717"+
		"\u0719\3\2\2\2\u0718\u0714\3\2\2\2\u0719\u071a\3\2\2\2\u071a\u0718\3\2"+
		"\2\2\u071a\u071b\3\2\2\2\u071b\u071c\3\2\2\2\u071c\u071d\5\60\31\2\u071d"+
		"\u0749\3\2\2\2\u071e\u0724\7\64\2\2\u071f\u0725\7\31\2\2\u0720\u0722\7"+
		"\7\2\2\u0721\u0723\7]\2\2\u0722\u0721\3\2\2\2\u0722\u0723\3\2\2\2\u0723"+
		"\u0725\3\2\2\2\u0724\u071f\3\2\2\2\u0724\u0720\3\2\2\2\u0725\u0726\3\2"+
		"\2\2\u0726\u0727\7\u00dd\2\2\u0727\u072c\7\u0101\2\2\u0728\u072a\5\u0094"+
		"K\2\u0729\u072b\7\u014b\2\2\u072a\u0729\3\2\2\2\u072a\u072b\3\2\2\2\u072b"+
		"\u072d\3\2\2\2\u072c\u0728\3\2\2\2\u072d\u072e\3\2\2\2\u072e\u072c\3\2"+
		"\2\2\u072e\u072f\3\2\2\2\u072f\u0730\3\2\2\2\u0730\u0731\5\60\31\2\u0731"+
		"\u0736\7\64\2\2\u0732\u0734\5\u0094K\2\u0733\u0735\7\u014b\2\2\u0734\u0733"+
		"\3\2\2\2\u0734\u0735\3\2\2\2\u0735\u0737\3\2\2\2\u0736\u0732\3\2\2\2\u0737"+
		"\u0738\3\2\2\2\u0738\u0736\3\2\2\2\u0738\u0739\3\2\2\2\u0739\u073a\3\2"+
		"\2\2\u073a\u073f\7\u0109\2\2\u073b\u073d\5\u0094K\2\u073c\u073e\7\u014b"+
		"\2\2\u073d\u073c\3\2\2\2\u073d\u073e\3\2\2\2\u073e\u0740\3\2\2\2\u073f"+
		"\u073b\3\2\2\2\u0740\u0741\3\2\2\2\u0741\u073f\3\2\2\2\u0741\u0742\3\2"+
		"\2\2\u0742\u0746\3\2\2\2\u0743\u0744\7\u0087\2\2\u0744\u0745\7\u0089\2"+
		"\2\u0745\u0747\7\u00df\2\2\u0746\u0743\3\2\2\2\u0746\u0747\3\2\2\2\u0747"+
		"\u0749\3\2\2\2\u0748\u0603\3\2\2\2\u0748\u062b\3\2\2\2\u0748\u0655\3\2"+
		"\2\2\u0748\u067e\3\2\2\2\u0748\u0699\3\2\2\2\u0748\u06af\3\2\2\2\u0748"+
		"\u06c4\3\2\2\2\u0748\u06d3\3\2\2\2\u0748\u06e7\3\2\2\2\u0748\u0703\3\2"+
		"\2\2\u0748\u071e\3\2\2\2\u0749/\3\2\2\2\u074a\u0755\7\u0109\2\2\u074b"+
		"\u074d\7\65\2\2\u074c\u074b\3\2\2\2\u074c\u074d\3\2\2\2\u074d\u0750\3"+
		"\2\2\2\u074e\u0751\5\u0094K\2\u074f\u0751\7\u00e8\2\2\u0750\u074e\3\2"+
		"\2\2\u0750\u074f\3\2\2\2\u0751\u0753\3\2\2\2\u0752\u0754\7\u014b\2\2\u0753"+
		"\u0752\3\2\2\2\u0753\u0754\3\2\2\2\u0754\u0756\3\2\2\2\u0755\u074c\3\2"+
		"\2\2\u0756\u0757\3\2\2\2\u0757\u0755\3\2\2\2\u0757\u0758\3\2\2\2\u0758"+
		"\u075c\3\2\2\2\u0759\u075a\7\u0087\2\2\u075a\u075b\7\64\2\2\u075b\u075d"+
		"\7\u00df\2\2\u075c\u0759\3\2\2\2\u075c\u075d\3\2\2\2\u075d\61\3\2\2\2"+
		"\u075e\u075f\7\u0098\2\2\u075f\u07d6\7\u00dd\2\2\u0760\u0761\7\4\2\2\u0761"+
		"\u0762\5\u0190\u00c9\2\u0762\u0769\7\u0152\2\2\u0763\u0765\5\u00a6T\2"+
		"\u0764\u0766\7\u014b\2\2\u0765\u0764\3\2\2\2\u0765\u0766\3\2\2\2\u0766"+
		"\u0768\3\2\2\2\u0767\u0763\3\2\2\2\u0768\u076b\3\2\2\2\u0769\u0767\3\2"+
		"\2\2\u0769\u076a\3\2\2\2\u076a\u076c\3\2\2\2\u076b\u0769\3\2\2\2\u076c"+
		"\u076d\7\u0153\2\2\u076d\u07d7\3\2\2\2\u076e\u076f\7\22\2\2\u076f\u0770"+
		"\7\u0152\2\2\u0770\u0771\5\u00a6T\2\u0771\u0772\7\6\2\2\u0772\u0773\5"+
		"\u00a6T\2\u0773\u0774\7\u0153\2\2\u0774\u07d7\3\2\2\2\u0775\u0776\7\24"+
		"\2\2\u0776\u07d7\5\u0190\u00c9\2\u0777\u0778\7\u0097\2\2\u0778\u07d7\5"+
		"\u0190\u00c9\2\u0779\u077a\7\26\2\2\u077a\u077b\5\u0190\u00c9\2\u077b"+
		"\u077c\7\u00dd\2\2\u077c\u077d\5\u0190\u00c9\2\u077d\u07d7\3\2\2\2\u077e"+
		"\u077f\7\30\2\2\u077f\u07d7\5\u0190\u00c9\2\u0780\u0781\7\33\2\2\u0781"+
		"\u07d7\5\u0190\u00c9\2\u0782\u0783\7#\2\2\u0783\u07d7\5\u0190\u00c9\2"+
		"\u0784\u0785\7+\2\2\u0785\u07d7\5\u0190\u00c9\2\u0786\u0787\7.\2\2\u0787"+
		"\u0788\7\u00a1\2\2\u0788\u0789\7\u0118\2\2\u0789\u07d7\5\u0190\u00c9\2"+
		"\u078a\u078b\7.\2\2\u078b\u078c\7t\2\2\u078c\u07d7\5\u0190\u00c9\2\u078d"+
		"\u07d7\5B\"\2\u078e\u078f\7\u00bb\2\2\u078f\u07d7\5\u0190\u00c9\2\u0790"+
		"\u0791\7\u00c6\2\2\u0791\u0792\7\u00dc\2\2\u0792\u07d7\5\u0094K\2\u0793"+
		"\u0794\7V\2\2\u0794\u0795\5\u0190\u00c9\2\u0795\u0796\7\u0152\2\2\u0796"+
		"\u0797\5\u00a6T\2\u0797\u0798\7\u014b\2\2\u0798\u0799\5\u00a6T\2\u0799"+
		"\u079a\7\u0153\2\2\u079a\u07d7\3\2\2\2\u079b\u079c\7V\2\2\u079c\u079d"+
		"\7\u0090\2\2\u079d\u079e\5\u0190\u00c9\2\u079e\u079f\7\u0081\2\2\u079f"+
		"\u07a0\5\u0094K\2\u07a0\u07d7\3\2\2\2\u07a1\u07a2\7V\2\2\u07a2\u07a3\7"+
		"\u00b2\2\2\u07a3\u07a4\5\u0190\u00c9\2\u07a4\u07a5\7\u0081\2\2\u07a5\u07a6"+
		"\5\u0094K\2\u07a6\u07d7\3\2\2\2\u07a7\u07a9\7_\2\2\u07a8\u07a7\3\2\2\2"+
		"\u07a8\u07a9\3\2\2\2\u07a9\u07aa\3\2\2\2\u07aa\u07ab\7\u00c5\2\2\u07ab"+
		"\u07d7\5\u0190\u00c9\2\u07ac\u07ad\7`\2\2\u07ad\u07d7\5\u0190\u00c9\2"+
		"\u07ae\u07af\7i\2\2\u07af\u07b0\5\u0190\u00c9\2\u07b0\u07b1\7\u00dd\2"+
		"\2\u07b1\u07b2\5\u0190\u00c9\2\u07b2\u07d7\3\2\2\2\u07b3\u07b4\7j\2\2"+
		"\u07b4\u07d7\5\u0190\u00c9\2\u07b5\u07b6\7k\2\2\u07b6\u07d7\5\u0190\u00c9"+
		"\2\u07b7\u07b8\7\u00f5\2\2\u07b8\u07d7\5\u0190\u00c9\2\u07b9\u07ba\7t"+
		"\2\2\u07ba\u07d7\5\u0190\u00c9\2\u07bb\u07bc\7\u0101\2\2\u07bc\u07d7\5"+
		"\u0190\u00c9\2\u07bd\u07be\7\u0139\2\2\u07be\u07bf\7\u00f2\2\2\u07bf\u07c0"+
		"\7\u009b\2\2\u07c0\u07d7\5\u0190\u00c9\2\u07c1\u07c2\7\u0139\2\2\u07c2"+
		"\u07c3\7\u00f2\2\2\u07c3\u07c4\7\u00a6\2\2\u07c4\u07d7\5\u0190\u00c9\2"+
		"\u07c5\u07c6\7\u0139\2\2\u07c6\u07c7\7\u00f2\2\2\u07c7\u07c8\7\u00e2\2"+
		"\2\u07c8\u07d7\5\u0190\u00c9\2\u07c9\u07ca\7\u0139\2\2\u07ca\u07cb\7\u00f2"+
		"\2\2\u07cb\u07cc\7\u0103\2\2\u07cc\u07d7\5\u0190\u00c9\2\u07cd\u07ce\7"+
		"z\2\2\u07ce\u07cf\5\u0190\u00c9\2\u07cf\u07d0\7\u00dd\2\2\u07d0\u07d1"+
		"\5\u0190\u00c9\2\u07d1\u07d7\3\2\2\2\u07d2\u07d3\7\u010a\2\2\u07d3\u07d7"+
		"\5\u0190\u00c9\2\u07d4\u07d5\7\u0084\2\2\u07d5\u07d7\5\u0190\u00c9\2\u07d6"+
		"\u0760\3\2\2\2\u07d6\u076e\3\2\2\2\u07d6\u0775\3\2\2\2\u07d6\u0777\3\2"+
		"\2\2\u07d6\u0779\3\2\2\2\u07d6\u077e\3\2\2\2\u07d6\u0780\3\2\2\2\u07d6"+
		"\u0782\3\2\2\2\u07d6\u0784\3\2\2\2\u07d6\u0786\3\2\2\2\u07d6\u078a\3\2"+
		"\2\2\u07d6\u078d\3\2\2\2\u07d6\u078e\3\2\2\2\u07d6\u0790\3\2\2\2\u07d6"+
		"\u0793\3\2\2\2\u07d6\u079b\3\2\2\2\u07d6\u07a1\3\2\2\2\u07d6\u07a8\3\2"+
		"\2\2\u07d6\u07ac\3\2\2\2\u07d6\u07ae\3\2\2\2\u07d6\u07b3\3\2\2\2\u07d6"+
		"\u07b5\3\2\2\2\u07d6\u07b7\3\2\2\2\u07d6\u07b9\3\2\2\2\u07d6\u07bb\3\2"+
		"\2\2\u07d6\u07bd\3\2\2\2\u07d6\u07c1\3\2\2\2\u07d6\u07c5\3";
	private static final String _serializedATNSegment1 =
		"\2\2\2\u07d6\u07c9\3\2\2\2\u07d6\u07cd\3\2\2\2\u07d6\u07d2\3\2\2\2\u07d6"+
		"\u07d4\3\2\2\2\u07d7\u07d8\3\2\2\2\u07d8\u07d9\7G\2\2\u07d9\u07da\7\u0168"+
		"\2\2\u07da\63\3\2\2\2\u07db\u07de\7\31\2\2\u07dc\u07dd\7W\2\2\u07dd\u07df"+
		"\7d\2\2\u07de\u07dc\3\2\2\2\u07de\u07df\3\2\2\2\u07df\u07e0\3\2\2\2\u07e0"+
		"\u07e1\7\60\2\2\u07e1\u07e2\5\u0190\u00c9\2\u07e2\u07f6\5\66\34\2\u07e3"+
		"\u07e6\7f\2\2\u07e4\u07e7\5\u00f6|\2\u07e5\u07e7\5\u00a6T\2\u07e6\u07e4"+
		"\3\2\2\2\u07e6\u07e5\3\2\2\2\u07e7\u07f7\3\2\2\2\u07e8\u07e9\7f\2\2\u07e9"+
		"\u07ea\7t\2\2\u07ea\u07f0\7\u0152\2\2\u07eb\u07ec\5\u0094K\2\u07ec\u07ee"+
		"\5\u00a6T\2\u07ed\u07ef\7\u014b\2\2\u07ee\u07ed\3\2\2\2\u07ee\u07ef\3"+
		"\2\2\2\u07ef\u07f1\3\2\2\2\u07f0\u07eb\3\2\2\2\u07f1\u07f2\3\2\2\2\u07f2"+
		"\u07f0\3\2\2\2\u07f2\u07f3\3\2\2\2\u07f3\u07f4\3\2\2\2\u07f4\u07f5\7\u0153"+
		"\2\2\u07f5\u07f7\3\2\2\2\u07f6\u07e3\3\2\2\2\u07f6\u07e8\3\2\2\2\u07f6"+
		"\u07f7\3\2\2\2\u07f7\u082d\3\2\2\2\u07f8\u07f9\7\u00c5\2\2\u07f9\u082e"+
		"\5\u0094K\2\u07fa\u082e\7\u0117\2\2\u07fb\u082e\7;\2\2\u07fc\u082e\7\u00f9"+
		"\2\2\u07fd\u082e\7\u0115\2\2\u07fe\u07ff\7\u008f\2\2\u07ff\u0800\7\u00dd"+
		"\2\2\u0800\u0801\7Q\2\2\u0801\u082e\7\u00be\2\2\u0802\u0803\7f\2\2\u0803"+
		"\u0804\7Q\2\2\u0804\u0805\7\u00dd\2\2\u0805\u0806\7Q\2\2\u0806\u082e\7"+
		"\u00be\2\2\u0807\u082e\7r\2\2\u0808\u080a\7\u00b0\2\2\u0809\u0808\3\2"+
		"\2\2\u0809\u080a\3\2\2\2\u080a\u080b\3\2\2\2\u080b\u080c\7\u00f4\2\2\u080c"+
		"\u082e\7F\2\2\u080d\u080f\7\u00b0\2\2\u080e\u080d\3\2\2\2\u080e\u080f"+
		"\3\2\2\2\u080f\u0810\3\2\2\2\u0810\u0811\7\u00f4\2\2\u0811\u082e\7\u00a5"+
		"\2\2\u0812\u0813\7\u009c\2\2\u0813\u082e\7\u0161\2\2\u0814\u0815\7b\2"+
		"\2\u0815\u082e\7\u0161\2\2\u0816\u0817\7\u00f6\2\2\u0817\u081e\5\u0094"+
		"K\2\u0818\u0819\7\u0109\2\2\u0819\u081f\5\u0094K\2\u081a\u081b\7\u0148"+
		"\2\2\u081b\u081f\5\u0094K\2\u081c\u081d\7\62\2\2\u081d\u081f\7\u009f\2"+
		"\2\u081e\u0818\3\2\2\2\u081e\u081a\3\2\2\2\u081e\u081c\3\2\2\2\u081f\u0824"+
		"\3\2\2\2\u0820\u0821\7\u014b\2\2\u0821\u0823\5\u0094K\2\u0822\u0820\3"+
		"\2\2\2\u0823\u0826\3\2\2\2\u0824\u0822\3\2\2\2\u0824\u0825\3\2\2\2\u0825"+
		"\u082e\3\2\2\2\u0826\u0824\3\2\2\2\u0827\u0828\7\6\2\2\u0828\u082e\58"+
		"\35\2\u0829\u082a\7\6\2\2\u082a\u082b\7\u0168\2\2\u082b\u082c\7\u014b"+
		"\2\2\u082c\u082e\7\u0168\2\2\u082d\u07f8\3\2\2\2\u082d\u07fa\3\2\2\2\u082d"+
		"\u07fb\3\2\2\2\u082d\u07fc\3\2\2\2\u082d\u07fd\3\2\2\2\u082d\u07fe\3\2"+
		"\2\2\u082d\u0802\3\2\2\2\u082d\u0807\3\2\2\2\u082d\u0809\3\2\2\2\u082d"+
		"\u080e\3\2\2\2\u082d\u0812\3\2\2\2\u082d\u0814\3\2\2\2\u082d\u0816\3\2"+
		"\2\2\u082d\u0827\3\2\2\2\u082d\u0829\3\2\2\2\u082e\u082f\3\2\2\2\u082f"+
		"\u082d\3\2\2\2\u082f\u0830\3\2\2\2\u0830\u083d\3\2\2\2\u0831\u0832\7\u0087"+
		"\2\2\u0832\u0837\7\u0152\2\2\u0833\u0835\5> \2\u0834\u0836\7\u014b\2\2"+
		"\u0835\u0834\3\2\2\2\u0835\u0836\3\2\2\2\u0836\u0838\3\2\2\2\u0837\u0833"+
		"\3\2\2\2\u0838\u0839\3\2\2\2\u0839\u0837\3\2\2\2\u0839\u083a\3\2\2\2\u083a"+
		"\u083b\3\2\2\2\u083b\u083c\7\u0153\2\2\u083c\u083e\3\2\2\2\u083d\u0831"+
		"\3\2\2\2\u083d\u083e\3\2\2\2\u083e\65\3\2\2\2\u083f\u0859\7\u0152\2\2"+
		"\u0840\u0842\5@!\2\u0841\u0840\3\2\2\2\u0841\u0842\3\2\2\2\u0842\u0844"+
		"\3\2\2\2\u0843\u0845\5\u0094K\2\u0844\u0843\3\2\2\2\u0844\u0845\3\2\2"+
		"\2\u0845\u0848\3\2\2\2\u0846\u0849\5\u00a6T\2\u0847\u0849\5\u0094K\2\u0848"+
		"\u0846\3\2\2\2\u0848\u0847\3\2\2\2\u0849\u0852\3\2\2\2\u084a\u084c\t\f"+
		"\2\2\u084b\u084d\7\u0152\2\2\u084c\u084b\3\2\2\2\u084c\u084d\3\2\2\2\u084d"+
		"\u084e\3\2\2\2\u084e\u0850\5\u00f6|\2\u084f\u0851\7\u0152\2\2\u0850\u084f"+
		"\3\2\2\2\u0850\u0851\3\2\2\2\u0851\u0853\3\2\2\2\u0852\u084a\3\2\2\2\u0852"+
		"\u0853\3\2\2\2\u0853\u0855\3\2\2\2\u0854\u0856\7\u014b\2\2\u0855\u0854"+
		"\3\2\2\2\u0855\u0856\3\2\2\2\u0856\u0858\3\2\2\2\u0857\u0841\3\2\2\2\u0858"+
		"\u085b\3\2\2\2\u0859\u0857\3\2\2\2\u0859\u085a\3\2\2\2\u085a\u085c\3\2"+
		"\2\2\u085b\u0859\3\2\2\2\u085c\u085d\7\u0153\2\2\u085d\67\3\2\2\2\u085e"+
		"\u0861\5:\36\2\u085f\u0861\5<\37\2\u0860\u085e\3\2\2\2\u0860\u085f\3\2"+
		"\2\2\u08619\3\2\2\2\u0862\u0866\7\u015f\2\2\u0863\u0865\n\r\2\2\u0864"+
		"\u0863\3\2\2\2\u0865\u0868\3\2\2\2\u0866\u0864\3\2\2\2\u0866\u0867\3\2"+
		"\2\2\u0867\u0869\3\2\2\2\u0868\u0866\3\2\2\2\u0869\u086a\7\u015f\2\2\u086a"+
		";\3\2\2\2\u086b\u086f\7\u0160\2\2\u086c\u086e\n\16\2\2\u086d\u086c\3\2"+
		"\2\2\u086e\u0871\3\2\2\2\u086f\u086d\3\2\2\2\u086f\u0870\3\2\2\2\u0870"+
		"\u0872\3\2\2\2\u0871\u086f\3\2\2\2\u0872\u0873\7\u0160\2\2\u0873=\3\2"+
		"\2\2\u0874\u0875\t\17\2\2\u0875?\3\2\2\2\u0876\u0877\t\20\2\2\u0877A\3"+
		"\2\2\2\u0878\u0879\7\60\2\2\u0879\u087a\5\u0094K\2\u087a\u088a\7\u0152"+
		"\2\2\u087b\u087d\5@!\2\u087c\u087b\3\2\2\2\u087c\u087d\3\2\2\2\u087d\u087f"+
		"\3\2\2\2\u087e\u0880\5\u0094K\2\u087f\u087e\3\2\2\2\u087f\u0880\3\2\2"+
		"\2\u0880\u0883\3\2\2\2\u0881\u0884\5\u00a6T\2\u0882\u0884\5\u00f6|\2\u0883"+
		"\u0881\3\2\2\2\u0883\u0882\3\2\2\2\u0884\u0886\3\2\2\2\u0885\u0887\7\u014b"+
		"\2\2\u0886\u0885\3\2\2\2\u0886\u0887\3\2\2\2\u0887\u0889\3\2\2\2\u0888"+
		"\u087c\3\2\2\2\u0889\u088c\3\2\2\2\u088a\u0888\3\2\2\2\u088a\u088b\3\2"+
		"\2\2\u088b\u088d\3\2\2\2\u088c\u088a\3\2\2\2\u088d\u088e\7\u0153\2\2\u088e"+
		"C\3\2\2\2\u088f\u0890\7\7\2\2\u0890\u0891\7\61\2\2\u0891\u0892\7<\2\2"+
		"\u0892\u0897\7j\2\2\u0893\u0895\5\u0094K\2\u0894\u0896\7\u014b\2\2\u0895"+
		"\u0894\3\2\2\2\u0895\u0896\3\2\2\2\u0896\u0898\3\2\2\2\u0897\u0893\3\2"+
		"\2\2\u0898\u0899\3\2\2\2\u0899\u0897\3\2\2\2\u0899\u089a\3\2\2\2\u089a"+
		"E\3\2\2\2\u089b\u089d\7\31\2\2\u089c\u089e\t\21\2\2\u089d\u089c\3\2\2"+
		"\2\u089d\u089e\3\2\2\2\u089e\u089f\3\2\2\2\u089f\u08a0\7k\2\2\u08a0\u08c5"+
		"\5\u0190\u00c9\2\u08a1\u08a3\7\u00bd\2\2\u08a2\u08a4\7\u008d\2\2\u08a3"+
		"\u08a2\3\2\2\2\u08a3\u08a4\3\2\2\2\u08a4\u08a5\3\2\2\2\u08a5\u08c4\7\u0161"+
		"\2\2\u08a6\u08a7\7\u00d3\2\2\u08a7\u08ab\7\u0161\2\2\u08a8\u08a9\7\u00d7"+
		"\2\2\u08a9\u08ab\7\u00d3\2\2\u08aa\u08a6\3\2\2\2\u08aa\u08a8\3\2\2\2\u08ab"+
		"\u08c4\3\2\2\2\u08ac\u08ad\7\u00ce\2\2\u08ad\u08b1\5\u00b6\\\2\u08ae\u08af"+
		"\7\u00d7\2\2\u08af\u08b1\7\u00ce\2\2\u08b0\u08ac\3\2\2\2\u08b0\u08ae\3"+
		"\2\2\2\u08b1\u08c4\3\2\2\2\u08b2\u08b4\7\u00fa\2\2\u08b3\u08b5\7\u0087"+
		"\2\2\u08b4\u08b3\3\2\2\2\u08b4\u08b5\3\2\2\2\u08b5\u08b6\3\2\2\2\u08b6"+
		"\u08c4\7\u0161\2\2\u08b7\u08b8\7\u008e\2\2\u08b8\u08c4\7\u0161\2\2\u08b9"+
		"\u08bb\7\u00d7\2\2\u08ba\u08b9\3\2\2\2\u08ba\u08bb\3\2\2\2\u08bb\u08bc"+
		"\3\2\2\2\u08bc\u08c4\7\u00a0\2\2\u08bd\u08be\7Y\2\2\u08be\u08c1\7\u008d"+
		"\2\2\u08bf\u08c2\5\u0190\u00c9\2\u08c0\u08c2\7\u00d8\2\2\u08c1\u08bf\3"+
		"\2\2\2\u08c1\u08c0\3\2\2\2\u08c2\u08c4\3\2\2\2\u08c3\u08a1\3\2\2\2\u08c3"+
		"\u08aa\3\2\2\2\u08c3\u08b0\3\2\2\2\u08c3\u08b2\3\2\2\2\u08c3\u08b7\3\2"+
		"\2\2\u08c3\u08ba\3\2\2\2\u08c3\u08bd\3\2\2\2\u08c4\u08c7\3\2\2\2\u08c5"+
		"\u08c3\3\2\2\2\u08c5\u08c6\3\2\2\2\u08c6G\3\2\2\2\u08c7\u08c5\3\2\2\2"+
		"\u08c8\u08c9\7\31\2\2\u08c9\u08ca\7j\2\2\u08ca\u08cd\5\u0094K\2\u08cb"+
		"\u08cc\7\r\2\2\u08cc\u08ce\5\u0094K\2\u08cd\u08cb\3\2\2\2\u08cd\u08ce"+
		"\3\2\2\2\u08ce\u08d2\3\2\2\2\u08cf\u08d1\5\2\2\2\u08d0\u08cf\3\2\2\2\u08d1"+
		"\u08d4\3\2\2\2\u08d2\u08d0\3\2\2\2\u08d2\u08d3\3\2\2\2\u08d3\u08f1\3\2"+
		"\2\2\u08d4\u08d2\3\2\2\2\u08d5\u08d6\7\31\2\2\u08d6\u08d7\7j\2\2\u08d7"+
		"\u08d8\7\r\2\2\u08d8\u08dc\5\u0094K\2\u08d9\u08db\5\2\2\2\u08da\u08d9"+
		"\3\2\2\2\u08db\u08de\3\2\2\2\u08dc\u08da\3\2\2\2\u08dc\u08dd\3\2\2\2\u08dd"+
		"\u08f1\3\2\2\2\u08de\u08dc\3\2\2\2\u08df\u08e0\7\31\2\2\u08e0\u08e1\7"+
		"j\2\2\u08e1\u08e2\78\2\2\u08e2\u08e3\7P\2\2\u08e3\u08e4\7\u00ae\2\2\u08e4"+
		"\u08e7\5\u0094K\2\u08e5\u08e6\7\r\2\2\u08e6\u08e8\5\u0094K\2\u08e7\u08e5"+
		"\3\2\2\2\u08e7\u08e8\3\2\2\2\u08e8\u08f1\3\2\2\2\u08e9\u08ea\7\31\2\2"+
		"\u08ea\u08eb\7j\2\2\u08eb\u08ec\78\2\2\u08ec\u08ed\7P\2\2\u08ed\u08ee"+
		"\7\u00ae\2\2\u08ee\u08ef\7\r\2\2\u08ef\u08f1\5\u0094K\2\u08f0\u08c8\3"+
		"\2\2\2\u08f0\u08d5\3\2\2\2\u08f0\u08df\3\2\2\2\u08f0\u08e9\3\2\2\2\u08f1"+
		"I\3\2\2\2\u08f2\u08f5\7\31\2\2\u08f3\u08f4\7W\2\2\u08f4\u08f6\7d\2\2\u08f5"+
		"\u08f3\3\2\2\2\u08f5\u08f6\3\2\2\2\u08f6\u08f8\3\2\2\2\u08f7\u08f9\t\21"+
		"\2\2\u08f8\u08f7\3\2\2\2\u08f8\u08f9\3\2\2\2\u08f9\u08fa\3\2\2\2\u08fa"+
		"\u08fb\7\u0084\2\2\u08fb\u0902\5\u0190\u00c9\2\u08fc\u08fe\5\u0094K\2"+
		"\u08fd\u08ff\7\u014b\2\2\u08fe\u08fd\3\2\2\2\u08fe\u08ff\3\2\2\2\u08ff"+
		"\u0901\3\2\2\2\u0900\u08fc\3\2\2\2\u0901\u0904\3\2\2\2\u0902\u0900\3\2"+
		"\2\2\u0902\u0903\3\2\2\2\u0903\u0912\3\2\2\2\u0904\u0902\3\2\2\2\u0905"+
		"\u0906\7\u0087\2\2\u0906\u090c\7\u0152\2\2\u0907\u090a\5\u0094K\2\u0908"+
		"\u0909\7\u0148\2\2\u0909\u090b\5\u0094K\2\u090a\u0908\3\2\2\2\u090a\u090b"+
		"\3\2\2\2\u090b\u090d\3\2\2\2\u090c\u0907\3\2\2\2\u090d\u090e\3\2\2\2\u090e"+
		"\u090c\3\2\2\2\u090e\u090f\3\2\2\2\u090f\u0910\3\2\2\2\u0910\u0911\7\u0153"+
		"\2\2\u0911\u0913\3\2\2\2\u0912\u0905\3\2\2\2\u0912\u0913\3\2\2\2\u0913"+
		"\u0914\3\2\2\2\u0914\u0915\7\6\2\2\u0915\u0916\5\u0192\u00ca\2\u0916K"+
		"\3\2\2\2\u0917\u0918\3\2\2\2\u0918M\3\2\2\2\u0919\u091f\7\31\2\2\u091a"+
		"\u091c\t\22\2\2\u091b\u091a\3\2\2\2\u091b\u091c\3\2\2\2\u091c\u091d\3"+
		"\2\2\2\u091d\u0920\t\21\2\2\u091e\u0920\7\u010c\2\2\u091f\u091b\3\2\2"+
		"\2\u091f\u091e\3\2\2\2\u091f\u0920\3\2\2\2\u0920\u0921\3\2\2\2\u0921\u0925"+
		"\7t\2\2\u0922\u0923\78\2\2\u0923\u0924\7P\2\2\u0924\u0926\7\u00ae\2\2"+
		"\u0925\u0922\3\2\2\2\u0925\u0926\3\2\2\2\u0926\u0927\3\2\2\2\u0927\u0928"+
		"\5\u0190\u00c9\2\u0928\u093c\7\u0152\2\2\u0929\u0934\5P)\2\u092a\u0934"+
		"\5T+\2\u092b\u092c\7L\2\2\u092c\u0930\5\u0094K\2\u092d\u092f\5R*\2\u092e"+
		"\u092d\3\2\2\2\u092f\u0932\3\2\2\2\u0930\u092e\3\2\2\2\u0930\u0931\3\2"+
		"\2\2\u0931\u0934\3\2\2\2\u0932\u0930\3\2\2\2\u0933\u0929\3\2\2\2\u0933"+
		"\u092a\3\2\2\2\u0933\u092b\3\2\2\2\u0934\u0936\3\2\2\2\u0935\u0937\7\u014b"+
		"\2\2\u0936\u0935\3\2\2\2\u0936\u0937\3\2\2\2\u0937\u0939\3\2\2\2\u0938"+
		"\u0933\3\2\2\2\u0939\u093a\3\2\2\2\u093a\u0938\3\2\2\2\u093a\u093b\3\2"+
		"\2\2\u093b\u093d\3\2\2\2\u093c\u0938\3\2\2\2\u093c\u093d\3\2\2\2\u093d"+
		"\u093e\3\2\2\2\u093e\u094b\7\u0153\2\2\u093f\u0940\7>\2\2\u0940\u0945"+
		"\7\u0152\2\2\u0941\u0943\5\u0094K\2\u0942\u0944\7\u014b\2\2\u0943\u0942"+
		"\3\2\2\2\u0943\u0944\3\2\2\2\u0944\u0946\3\2\2\2\u0945\u0941\3\2\2\2\u0946"+
		"\u0947\3\2\2\2\u0947\u0945\3\2\2\2\u0947\u0948\3\2\2\2\u0948\u0949\3\2"+
		"\2\2\u0949\u094a\7\u0153\2\2\u094a\u094c\3\2\2\2\u094b\u093f\3\2\2\2\u094b"+
		"\u094c\3\2\2\2\u094c\u094d\3\2\2\2\u094d\u094e\5^\60\2\u094e\u094f\5`"+
		"\61\2\u094f\u0950\5b\62\2\u0950\u097f\3\2\2\2\u0951\u0957\7\31\2\2\u0952"+
		"\u0954\t\22\2\2\u0953\u0952\3\2\2\2\u0953\u0954\3\2\2\2\u0954\u0955\3"+
		"\2\2\2\u0955\u0958\t\21\2\2\u0956\u0958\7\u010c\2\2\u0957\u0953\3\2\2"+
		"\2\u0957\u0956\3\2\2\2\u0957\u0958\3\2\2\2\u0958\u0959\3\2\2\2\u0959\u095d"+
		"\7t\2\2\u095a\u095b\78\2\2\u095b\u095c\7P\2\2\u095c\u095e\7\u00ae\2\2"+
		"\u095d\u095a\3\2\2\2\u095d\u095e\3\2\2\2\u095e\u095f\3\2\2\2\u095f\u0960"+
		"\5\u0190\u00c9\2\u0960\u0961\7R\2\2\u0961\u0978\5\u0094K\2\u0962\u0972"+
		"\7\u0152\2\2\u0963\u0964\5\u0094K\2\u0964\u0965\7\u0087\2\2\u0965\u0969"+
		"\7\u00e0\2\2\u0966\u0968\5V,\2\u0967\u0966\3\2\2\2\u0968\u096b\3\2\2\2"+
		"\u0969\u0967\3\2\2\2\u0969\u096a\3\2\2\2\u096a\u096e\3\2\2\2\u096b\u0969"+
		"\3\2\2\2\u096c\u096e\5T+\2\u096d\u0963\3\2\2\2\u096d\u096c\3\2\2\2\u096e"+
		"\u0970\3\2\2\2\u096f\u0971\7\u014b\2\2\u0970\u096f\3\2\2\2\u0970\u0971"+
		"\3\2\2\2\u0971\u0973\3\2\2\2\u0972\u096d\3\2\2\2\u0973\u0974\3\2\2\2\u0974"+
		"\u0972\3\2\2\2\u0974\u0975\3\2\2\2\u0975\u0976\3\2\2\2\u0976\u0977\7\u0153"+
		"\2\2\u0977\u0979\3\2\2\2\u0978\u0962\3\2\2\2\u0978\u0979\3\2\2\2\u0979"+
		"\u097a\3\2\2\2\u097a\u097b\5^\60\2\u097b\u097c\5`\61\2\u097c\u097d\5b"+
		"\62\2\u097d\u097f\3\2\2\2\u097e\u0919\3\2\2\2\u097e\u0951\3\2\2\2\u097f"+
		"O\3\2\2\2\u0980\u0981\5\u0094K\2\u0981\u0984\5\u00a6T\2\u0982\u0983\7"+
		"\23\2\2\u0983\u0985\5\u0094K\2\u0984\u0982\3\2\2\2\u0984\u0985\3\2\2\2"+
		"\u0985\u0989\3\2\2\2\u0986\u0988\5V,\2\u0987\u0986\3\2\2\2\u0988\u098b"+
		"\3\2\2\2\u0989\u0987\3\2\2\2\u0989\u098a\3\2\2\2\u098aQ\3\2\2\2\u098b"+
		"\u0989\3\2\2\2\u098c\u098d\t\23\2\2\u098d\u098e\t\24\2\2\u098eS\3\2\2"+
		"\2\u098f\u0990\7\26\2\2\u0990\u0992\5\u0094K\2\u0991\u098f\3\2\2\2\u0991"+
		"\u0992\3\2\2\2\u0992\u09f5\3\2\2\2\u0993\u09f6\5X-\2\u0994\u0995\7~\2"+
		"\2\u0995\u099a\7\u0152\2\2\u0996\u0998\5\u0094K\2\u0997\u0999\7\u014b"+
		"\2\2\u0998\u0997\3\2\2\2\u0998\u0999\3\2\2\2\u0999\u099b\3\2\2\2\u099a"+
		"\u0996\3\2\2\2\u099b\u099c\3\2\2\2\u099c\u099a\3\2\2\2\u099c\u099d\3\2"+
		"\2\2\u099d\u099e\3\2\2\2\u099e\u099f\7\u0153\2\2\u099f\u09a0\5f\64\2\u09a0"+
		"\u09f6\3\2\2\2\u09a1\u09a2\7\\\2\2\u09a2\u09a3\7I\2\2\u09a3\u09a8\7\u0152"+
		"\2\2\u09a4\u09a6\5\u0094K\2\u09a5\u09a7\7\u014b\2\2\u09a6\u09a5\3\2\2"+
		"\2\u09a6\u09a7\3\2\2\2\u09a7\u09a9\3\2\2\2\u09a8\u09a4\3\2\2\2\u09a9\u09aa"+
		"\3\2\2\2\u09aa\u09a8\3\2\2\2\u09aa\u09ab\3\2\2\2\u09ab\u09ac\3\2\2\2\u09ac"+
		"\u09ad\7\u0153\2\2\u09ad\u09ae\5f\64\2\u09ae\u09f6\3\2\2\2\u09af\u09b2"+
		"\7(\2\2\u09b0\u09b1\7\u0081\2\2\u09b1\u09b3\5\u0094K\2\u09b2\u09b0\3\2"+
		"\2\2\u09b2\u09b3\3\2\2\2\u09b3\u09b4\3\2\2\2\u09b4\u09b5\7\u0152\2\2\u09b5"+
		"\u09b6\5\u0094K\2\u09b6\u09bb\7\u0087\2\2\u09b7\u09b9\5\u0094K\2\u09b8"+
		"\u09ba\7\u014b\2\2\u09b9\u09b8\3\2\2\2\u09b9\u09ba\3\2\2\2\u09ba\u09bc"+
		"\3\2\2\2\u09bb\u09b7\3\2\2\2\u09bc\u09bd\3\2\2\2\u09bd\u09bb\3\2\2\2\u09bd"+
		"\u09be\3\2\2\2\u09be\u09bf\3\2\2\2\u09bf\u09c0\7\u0153\2\2\u09c0\u09c6"+
		"\5f\64\2\u09c1\u09c2\7\u0086\2\2\u09c2\u09c3\7\u0152\2\2\u09c3\u09c4\5"+
		"\u0094K\2\u09c4\u09c5\7\u0153\2\2\u09c5\u09c7\3\2\2\2\u09c6\u09c1\3\2"+
		"\2\2\u09c6\u09c7\3\2\2\2\u09c7\u09f6\3\2\2\2\u09c8\u09c9\7.\2\2\u09c9"+
		"\u09ca\7I\2\2\u09ca\u09cf\7\u0152\2\2\u09cb\u09cd\5\u0094K\2\u09cc\u09ce"+
		"\7\u014b\2\2\u09cd\u09cc\3\2\2\2\u09cd\u09ce\3\2\2\2\u09ce\u09d0\3\2\2"+
		"\2\u09cf\u09cb\3\2\2\2\u09d0\u09d1\3\2\2\2\u09d1\u09cf\3\2\2\2\u09d1\u09d2"+
		"\3\2\2\2\u09d2\u09d3\3\2\2\2\u09d3\u09d4\7\u0153\2\2\u09d4\u09d5\7c\2"+
		"\2\u09d5\u09e1\5\u0094K\2\u09d6\u09db\7\u0152\2\2\u09d7\u09d9\5\u0094"+
		"K\2\u09d8\u09da\7\u014b\2\2\u09d9\u09d8\3\2\2\2\u09d9\u09da\3\2\2\2\u09da"+
		"\u09dc\3\2\2\2\u09db\u09d7\3\2\2\2\u09dc\u09dd\3\2\2\2\u09dd\u09db\3\2"+
		"\2\2\u09dd\u09de\3\2\2\2\u09de\u09df\3\2\2\2\u09df\u09e0\7\u0153\2\2\u09e0"+
		"\u09e2\3\2\2\2\u09e1\u09d6\3\2\2\2\u09e1\u09e2\3\2\2\2\u09e2\u09e9\3\2"+
		"\2\2\u09e3\u09e4\7\u00cc\2\2\u09e4\u09ea\7/\2\2\u09e5\u09e6\7\u00cc\2"+
		"\2\u09e6\u09ea\7\u00e3\2\2\u09e7\u09e8\7\u00cc\2\2\u09e8\u09ea\7\u00f8"+
		"\2\2\u09e9\u09e3\3\2\2\2\u09e9\u09e5\3\2\2\2\u09e9\u09e7\3\2\2\2\u09e9"+
		"\u09ea\3\2\2\2\u09ea\u09ee\3\2\2\2\u09eb\u09ec\7\u00dd\2\2\u09ec\u09ed"+
		"\7 \2\2\u09ed\u09ef\5d\63\2\u09ee\u09eb\3\2\2\2\u09ee\u09ef\3\2\2\2\u09ef"+
		"\u09f3\3\2\2\2\u09f0\u09f1\7\u00dd\2\2\u09f1\u09f2\7\177\2\2\u09f2\u09f4"+
		"\5d\63\2\u09f3\u09f0\3\2\2\2\u09f3\u09f4\3\2\2\2\u09f4\u09f6\3\2\2\2\u09f5"+
		"\u0993\3\2\2\2\u09f5\u0994\3\2\2\2\u09f5\u09a1\3\2\2\2\u09f5\u09af\3\2"+
		"\2\2\u09f5\u09c8\3\2\2\2\u09f6\u09fa\3\2\2\2\u09f7\u09fb\7\36\2\2\u09f8"+
		"\u09f9\7P\2\2\u09f9\u09fb\7\36\2\2\u09fa\u09f7\3\2\2\2\u09fa\u09f8\3\2"+
		"\2\2\u09fa\u09fb\3\2\2\2\u09fb\u0a00\3\2\2\2\u09fc\u09fd\7?\2\2\u09fd"+
		"\u0a01\7\37\2\2\u09fe\u09ff\7?\2\2\u09ff\u0a01\7:\2\2\u0a00\u09fc\3\2"+
		"\2\2\u0a00\u09fe\3\2\2\2\u0a00\u0a01\3\2\2\2\u0a01U\3\2\2\2\u0a02\u0a03"+
		"\7\26\2\2\u0a03\u0a05\5\u0094K\2\u0a04\u0a02\3\2\2\2\u0a04\u0a05\3\2\2"+
		"\2\u0a05\u0a29\3\2\2\2\u0a06\u0a07\7P\2\2\u0a07\u0a2a\7Q\2\2\u0a08\u0a2a"+
		"\7Q\2\2\u0a09\u0a2a\5X-\2\u0a0a\u0a0d\7\34\2\2\u0a0b\u0a0e\5\u00a6T\2"+
		"\u0a0c\u0a0e\5\u00f6|\2\u0a0d\u0a0b\3\2\2\2\u0a0d\u0a0c\3\2\2\2\u0a0e"+
		"\u0a2a\3\2\2\2\u0a0f\u0a10\7~\2\2\u0a10\u0a2a\5f\64\2\u0a11\u0a12\7\\"+
		"\2\2\u0a12\u0a13\7I\2\2\u0a13\u0a2a\5f\64\2\u0a14\u0a15\7c\2\2\u0a15\u0a16"+
		"\5\u0190\u00c9\2\u0a16\u0a1d\5\u0094K\2\u0a17\u0a18\7\u00cc\2\2\u0a18"+
		"\u0a1e\7/\2\2\u0a19\u0a1a\7\u00cc\2\2\u0a1a\u0a1e\7\u00e3\2\2\u0a1b\u0a1c"+
		"\7\u00cc\2\2\u0a1c\u0a1e\7\u00f8\2\2\u0a1d\u0a17\3\2\2\2\u0a1d\u0a19\3"+
		"\2\2\2\u0a1d\u0a1b\3\2\2\2\u0a1d\u0a1e\3\2\2\2\u0a1e\u0a22\3\2\2\2\u0a1f"+
		"\u0a20\7\u00dd\2\2\u0a20\u0a21\7 \2\2\u0a21\u0a23\5d\63\2\u0a22\u0a1f"+
		"\3\2\2\2\u0a22\u0a23\3\2\2\2\u0a23\u0a27\3\2\2\2\u0a24\u0a25\7\u00dd\2"+
		"\2\u0a25\u0a26\7\177\2\2\u0a26\u0a28\5d\63\2\u0a27\u0a24\3\2\2\2\u0a27"+
		"\u0a28\3\2\2\2\u0a28\u0a2a\3\2\2\2\u0a29\u0a06\3\2\2\2\u0a29\u0a08\3\2"+
		"\2\2\u0a29\u0a09\3\2\2\2\u0a29\u0a0a\3\2\2\2\u0a29\u0a0f\3\2\2\2\u0a29"+
		"\u0a11\3\2\2\2\u0a29\u0a14\3\2\2\2\u0a2a\u0a2e\3\2\2\2\u0a2b\u0a2f\7\36"+
		"\2\2\u0a2c\u0a2d\7P\2\2\u0a2d\u0a2f\7\36\2\2\u0a2e\u0a2b\3\2\2\2\u0a2e"+
		"\u0a2c\3\2\2\2\u0a2e\u0a2f\3\2\2\2\u0a2f\u0a34\3\2\2\2\u0a30\u0a31\7?"+
		"\2\2\u0a31\u0a35\7\37\2\2\u0a32\u0a33\7?\2\2\u0a33\u0a35\7:\2\2\u0a34"+
		"\u0a30\3\2\2\2\u0a34\u0a32\3\2\2\2\u0a34\u0a35\3\2\2\2\u0a35W\3\2\2\2"+
		"\u0a36\u0a37\7\u0093\2\2\u0a37\u0a38\7\u0152\2\2\u0a38\u0a39\5\u0120\u0091"+
		"\2\u0a39\u0a3a\7\u0153\2\2\u0a3aY\3\2\2\2\u0a3b\u0a44\7\u0152\2\2\u0a3c"+
		"\u0a3f\5\u0094K\2\u0a3d\u0a3e\7\u0148\2\2\u0a3e\u0a40\5\u0094K\2\u0a3f"+
		"\u0a3d\3\2\2\2\u0a3f\u0a40\3\2\2\2\u0a40\u0a42\3\2\2\2\u0a41\u0a43\7\u014b"+
		"\2\2\u0a42\u0a41\3\2\2\2\u0a42\u0a43\3\2\2\2\u0a43\u0a45\3\2\2\2\u0a44"+
		"\u0a3c\3\2\2\2\u0a45\u0a46\3\2\2\2\u0a46\u0a44\3\2\2\2\u0a46\u0a47\3\2"+
		"\2\2\u0a47\u0a48\3\2\2\2\u0a48\u0a49\7\u0153\2\2\u0a49[\3\2\2\2\u0a4a"+
		"\u0a4b\7\u0087\2\2\u0a4b\u0a4c\5Z.\2\u0a4c]\3\2\2\2\u0a4d\u0a53\5\\/\2"+
		"\u0a4e\u0a4f\7\u0087\2\2\u0a4f\u0a53\7S\2\2\u0a50\u0a51\7\u0088\2\2\u0a51"+
		"\u0a53\7S\2\2\u0a52\u0a4d\3\2\2\2\u0a52\u0a4e\3\2\2\2\u0a52\u0a50\3\2"+
		"\2\2\u0a52\u0a53\3\2\2\2\u0a53_\3\2\2\2\u0a54\u0a55\7\u00dd\2\2\u0a55"+
		"\u0a5b\7\u009a\2\2\u0a56\u0a57\7[\2\2\u0a57\u0a5c\7b\2\2\u0a58\u0a59\7"+
		" \2\2\u0a59\u0a5c\7b\2\2\u0a5a\u0a5c\7\u00aa\2\2\u0a5b\u0a56\3\2\2\2\u0a5b"+
		"\u0a58\3\2\2\2\u0a5b\u0a5a\3\2\2\2\u0a5c\u0a5e\3\2\2\2\u0a5d\u0a54\3\2"+
		"\2\2\u0a5d\u0a5e\3\2\2\2\u0a5ea\3\2\2\2\u0a5f\u0a60\7\u0101\2\2\u0a60"+
		"\u0a62\5\u0094K\2\u0a61\u0a5f\3\2\2\2\u0a61\u0a62\3\2\2\2\u0a62c\3\2\2"+
		"\2\u0a63\u0a6a\7e\2\2\u0a64\u0a6a\7\21\2\2\u0a65\u0a66\7\u00f6\2\2\u0a66"+
		"\u0a6a\7Q\2\2\u0a67\u0a68\7\u00f6\2\2\u0a68\u0a6a\7\34\2\2\u0a69\u0a63"+
		"\3\2\2\2\u0a69\u0a64\3\2\2\2\u0a69\u0a65\3\2\2\2\u0a69\u0a67\3\2\2\2\u0a6a"+
		"e\3\2\2\2\u0a6b\u0a6d\5\\/\2\u0a6c\u0a6b\3\2\2\2\u0a6c\u0a6d\3\2\2\2\u0a6d"+
		"\u0a72\3\2\2\2\u0a6e\u0a6f\7\u0081\2\2\u0a6f\u0a70\7\u00bb\2\2\u0a70\u0a71"+
		"\7\u0101\2\2\u0a71\u0a73\5\u0094K\2\u0a72\u0a6e\3\2\2\2\u0a72\u0a73\3"+
		"\2\2\2\u0a73g\3\2\2\2\u0a74\u0a75\7\u0152\2\2\u0a75\u0a7a\5j\66\2\u0a76"+
		"\u0a77\7\u014b\2\2\u0a77\u0a79\5j\66\2\u0a78\u0a76\3\2\2\2\u0a79\u0a7c"+
		"\3\2\2\2\u0a7a\u0a78\3\2\2\2\u0a7a\u0a7b\3\2\2\2\u0a7b\u0a7d\3\2\2\2\u0a7c"+
		"\u0a7a\3\2\2\2\u0a7d\u0a7e\7\u0153\2\2\u0a7ei\3\2\2\2\u0a7f\u0a80\5\u0094"+
		"K\2\u0a80\u0a81\5l\67\2\u0a81k\3\2\2\2\u0a82\u0a83\5\u00a6T\2\u0a83m\3"+
		"\2\2\2\u0a84\u0a85\7\u0087\2\2\u0a85\u0a86\7\u0152\2\2\u0a86\u0a8b\5p"+
		"9\2\u0a87\u0a88\7\u014b\2\2\u0a88\u0a8a\5p9\2\u0a89\u0a87\3\2\2\2\u0a8a"+
		"\u0a8d\3\2\2\2\u0a8b\u0a89\3\2\2\2\u0a8b\u0a8c\3\2\2\2\u0a8c\u0a8e\3\2"+
		"\2\2\u0a8d\u0a8b\3\2\2\2\u0a8e\u0a8f\7\u0153\2\2\u0a8fo\3\2\2\2\u0a90"+
		"\u0a91\7\u0168\2\2\u0a91\u0a92\7\u0148\2\2\u0a92\u0a93\5\u00fa~\2\u0a93"+
		"q\3\2\2\2\u0a94\u0a95\7\u0081\2\2\u0a95\u0a96\5\u0094K\2\u0a96s\3\2\2"+
		"\2\u0a97\u0a98\7\u0101\2\2\u0a98\u0a99\5v<\2\u0a99u\3\2\2\2\u0a9a\u0a9b"+
		"\5\u0094K\2\u0a9bw\3\2\2\2\u0a9c\u0aa1\5z>\2\u0a9d\u0aa1\5\u0080A\2\u0a9e"+
		"\u0aa1\5\u0088E\2\u0a9f\u0aa1\5\u008eH\2\u0aa0\u0a9c\3\2\2\2\u0aa0\u0a9d"+
		"\3\2\2\2\u0aa0\u0a9e\3\2\2\2\u0aa0\u0a9f\3\2\2\2\u0aa1y\3\2\2\2\u0aa2"+
		"\u0aa3\7\u00e4\2\2\u0aa3\u0aa4\7\u008d\2\2\u0aa4\u0aa5\7\u00eb\2\2\u0aa5"+
		"\u0aa6\7\u0152\2\2\u0aa6\u0aa7\5\u01a2\u00d2\2\u0aa7\u0aa8\7\u0153\2\2"+
		"\u0aa8\u0aa9\7\u0152\2\2\u0aa9\u0aaa\5|?\2\u0aaa\u0aab\7\u0153\2\2\u0aab"+
		"{\3\2\2\2\u0aac\u0ab1\5~@\2\u0aad\u0aae\7\u014b\2\2\u0aae\u0ab0\5~@\2"+
		"\u0aaf\u0aad\3\2\2\2\u0ab0\u0ab3\3\2\2\2\u0ab1\u0aaf\3\2\2\2\u0ab1\u0ab2"+
		"\3\2\2\2\u0ab2}\3\2\2\2\u0ab3\u0ab1\3\2\2\2\u0ab4\u0ab5\7\u00e4\2\2\u0ab5"+
		"\u0ab6\5\u0090I\2\u0ab6\u0ab7\7\u0110\2\2\u0ab7\u0ab8\7\u00c8\2\2\u0ab8"+
		"\u0ac4\7\u0104\2\2\u0ab9\u0aba\7\u0152\2\2\u0aba\u0abb\5\u00f6|\2\u0abb"+
		"\u0abc\7\u0153\2\2\u0abc\u0ac5\3\2\2\2\u0abd\u0abf\7\u0152\2\2\u0abe\u0abd"+
		"\3\2\2\2\u0abe\u0abf\3\2\2\2\u0abf\u0ac0\3\2\2\2\u0ac0\u0ac2\7\u00ce\2"+
		"\2\u0ac1\u0ac3\7\u0153\2\2\u0ac2\u0ac1\3\2\2\2\u0ac2\u0ac3\3\2\2\2\u0ac3"+
		"\u0ac5\3\2\2\2\u0ac4\u0ab9\3\2\2\2\u0ac4\u0abe\3\2\2\2\u0ac5\177\3\2\2"+
		"\2\u0ac6\u0ac7\7\u00e4\2\2\u0ac7\u0ac8\7\u008d\2\2\u0ac8\u0ac9\7\u00b8"+
		"\2\2\u0ac9\u0aca\7\u0152\2\2\u0aca\u0acb\5\u01a2\u00d2\2\u0acb\u0ad1\7"+
		"\u0153\2\2\u0acc\u0acd\7\u0152\2\2\u0acd\u0ace\5\u0082B\2\u0ace\u0acf"+
		"\7\u0153\2\2\u0acf\u0ad2\3\2\2\2\u0ad0\u0ad2\5\u0086D\2\u0ad1\u0acc\3"+
		"\2\2\2\u0ad1\u0ad0\3\2\2\2\u0ad2\u0081\3\2\2\2\u0ad3\u0ad8\5\u0084C\2"+
		"\u0ad4\u0ad5\7\u014b\2\2\u0ad5\u0ad7\5\u0084C\2\u0ad6\u0ad4\3\2\2\2\u0ad7"+
		"\u0ada\3\2\2\2\u0ad8\u0ad6\3\2\2\2\u0ad8\u0ad9\3\2\2\2\u0ad9\u0083\3\2"+
		"\2\2\u0ada\u0ad8\3\2\2\2\u0adb\u0adc\7\u00e4\2\2\u0adc\u0add\5\u0090I"+
		"\2\u0add\u0085\3\2\2\2\u0ade\u0adf\7\u00e5\2\2\u0adf\u0ae0\5\u00fa~\2"+
		"\u0ae0\u0087\3\2\2\2\u0ae1\u0ae2\7\u00e4\2\2\u0ae2\u0ae3\7\u008d\2\2\u0ae3"+
		"\u0ae4\7\u00c9\2\2\u0ae4\u0ae5\7\u0152\2\2\u0ae5\u0ae6\5\u01a2\u00d2\2"+
		"\u0ae6\u0ae7\7\u0153\2\2\u0ae7\u0ae8\7\u0152\2\2\u0ae8\u0ae9\5\u008aF"+
		"\2\u0ae9\u0aea\7\u0153\2\2\u0aea\u0089\3\2\2\2\u0aeb\u0af0\5\u008cG\2"+
		"\u0aec\u0aed\7\u014b\2\2\u0aed\u0aef\5\u008cG\2\u0aee\u0aec\3\2\2\2\u0aef"+
		"\u0af2\3\2\2\2\u0af0\u0aee\3\2\2\2\u0af0\u0af1\3\2\2\2\u0af1\u008b\3\2"+
		"\2\2\u0af2\u0af0\3\2\2\2\u0af3\u0af4\7\u00e4\2\2\u0af4\u0af5\5\u0090I"+
		"\2\u0af5\u0af7\7\u0110\2\2\u0af6\u0af8\7<\2\2\u0af7\u0af6\3\2\2\2\u0af7"+
		"\u0af8\3\2\2\2\u0af8\u0af9\3\2\2\2\u0af9\u0afa\7\u0152\2\2\u0afa\u0afb"+
		"\5\u01ba\u00de\2\u0afb\u0afc\7\u0153\2\2\u0afc\u008d\3\2\2\2\u0afd\u0afe"+
		"\7\u00e4\2\2\u0afe\u0aff\7\u008d\2\2\u0aff\u0b00\7\u0097\2\2\u0b00\u0b01"+
		"\5h\65\2\u0b01\u008f\3\2\2\2\u0b02\u0b03\5\u0094K\2\u0b03\u0091\3\2\2"+
		"\2\u0b04\u0b05\7\u00aa\2\2\u0b05\u0b06\7t\2\2\u0b06\u0b08\5\u0190\u00c9"+
		"\2\u0b07\u0b09\7\u00e9\2\2\u0b08\u0b07\3\2\2\2\u0b08\u0b09\3\2\2\2\u0b09"+
		"\u0093\3\2\2\2\u0b0a\u0b14\7\u0165\2\2\u0b0b\u0b14\7\u0166\2\2\u0b0c\u0b0e"+
		"\7\u015d\2\2\u0b0d\u0b0c\3\2\2\2\u0b0d\u0b0e\3\2\2\2\u0b0e\u0b0f\3\2\2"+
		"\2\u0b0f\u0b11\5\u0096L\2\u0b10\u0b12\7\u015d\2\2\u0b11\u0b10\3\2\2\2"+
		"\u0b11\u0b12\3\2\2\2\u0b12\u0b14\3\2\2\2\u0b13\u0b0a\3\2\2\2\u0b13\u0b0b"+
		"\3\2\2\2\u0b13\u0b0d\3\2\2\2\u0b14\u0095\3\2\2\2\u0b15\u0b16\t\25\2\2"+
		"\u0b16\u0097\3\2\2\2\u0b17\u0b1a\5\u00ceh\2\u0b18\u0b1a\5\u009aN\2\u0b19"+
		"\u0b17\3\2\2\2\u0b19\u0b18\3\2\2\2\u0b1a\u0099\3\2\2\2\u0b1b\u0b1f\7\u0168"+
		"\2\2\u0b1c\u0b1f\5\u009cO\2\u0b1d\u0b1f\5\u00a4S\2\u0b1e\u0b1b\3\2\2\2"+
		"\u0b1e\u0b1c\3\2\2\2\u0b1e\u0b1d\3\2\2\2\u0b1f\u009b\3\2\2\2\u0b20\u0b24"+
		"\5\u00a0Q\2\u0b21\u0b24\5\u009eP\2\u0b22\u0b24\5\u00a2R\2\u0b23\u0b20"+
		"\3\2\2\2\u0b23\u0b21\3\2\2\2\u0b23\u0b22\3\2\2\2\u0b24\u009d\3\2\2\2\u0b25"+
		"\u0b26\7\u0135\2\2\u0b26\u0b27\7\u0168\2\2\u0b27\u009f\3\2\2\2\u0b28\u0b29"+
		"\7\u0137\2\2\u0b29\u0b2a\7\u0168\2\2\u0b2a\u00a1\3\2\2\2\u0b2b\u0b2c\7"+
		"\u0134\2\2\u0b2c\u0b2d\7\u0168\2\2\u0b2d\u00a3\3\2\2\2\u0b2e\u0b2f\t\26"+
		"\2\2\u0b2f\u00a5\3\2\2\2\u0b30\u0b34\5\u00a8U\2\u0b31\u0b32\7o\2\2\u0b32"+
		"\u0b34\5\u0094K\2\u0b33\u0b30\3\2\2\2\u0b33\u0b31\3\2\2\2\u0b34\u00a7"+
		"\3\2\2\2\u0b35\u0b43\5\u00aeX\2\u0b36\u0b43\5\u00b2Z\2\u0b37\u0b43\5\u00b4"+
		"[\2\u0b38\u0b43\5\u00b6\\\2\u0b39\u0b43\5\u00be`\2\u0b3a\u0b43\5\u00c0"+
		"a\2\u0b3b\u0b43\5\u00c2b\2\u0b3c\u0b43\5\u00c4c\2\u0b3d\u0b43\5\u00ac"+
		"W\2\u0b3e\u0b43\5\u00aaV\2\u0b3f\u0b43\7z\2\2\u0b40\u0b43\7\u013a\2\2"+
		"\u0b41\u0b43\7\u0141\2\2\u0b42\u0b35\3\2\2\2\u0b42\u0b36\3\2\2\2\u0b42"+
		"\u0b37\3\2\2\2\u0b42\u0b38\3\2\2\2\u0b42\u0b39\3\2\2\2\u0b42\u0b3a\3\2"+
		"\2\2\u0b42\u0b3b\3\2\2\2\u0b42\u0b3c\3\2\2\2\u0b42\u0b3d\3\2\2\2\u0b42"+
		"\u0b3e\3\2\2\2\u0b42\u0b3f\3\2\2\2\u0b42\u0b40\3\2\2\2\u0b42\u0b41\3\2"+
		"\2\2\u0b43\u00a9\3\2\2\2\u0b44\u0b45\7\u012b\2\2\u0b45\u00ab\3\2\2\2\u0b46"+
		"\u0b47\7\u013f\2\2\u0b47\u00ad\3\2\2\2\u0b48\u0b4a\7\u0092\2\2\u0b49\u0b4b"+
		"\5\u00b0Y\2\u0b4a\u0b49\3\2\2\2\u0b4a\u0b4b\3\2\2\2\u0b4b\u0b61\3\2\2"+
		"\2\u0b4c\u0b4e\7\u0130\2\2\u0b4d\u0b4f\5\u00b0Y\2\u0b4e\u0b4d\3\2\2\2"+
		"\u0b4e\u0b4f\3\2\2\2\u0b4f\u0b61\3\2\2\2\u0b50\u0b51\7\u0092\2\2\u0b51"+
		"\u0b53\7\u0113\2\2\u0b52\u0b54\5\u00b0Y\2\u0b53\u0b52\3\2\2\2\u0b53\u0b54"+
		"\3\2\2\2\u0b54\u0b61\3\2\2\2\u0b55\u0b56\7\u0130\2\2\u0b56\u0b58\7\u0113"+
		"\2\2\u0b57\u0b59\5\u00b0Y\2\u0b58\u0b57\3\2\2\2\u0b58\u0b59\3\2\2\2\u0b59"+
		"\u0b61\3\2\2\2\u0b5a\u0b5c\7\u0131\2\2\u0b5b\u0b5d\5\u00b0Y\2\u0b5c\u0b5b"+
		"\3\2\2\2\u0b5c\u0b5d\3\2\2\2\u0b5d\u0b61\3\2\2\2\u0b5e\u0b61\7\u0139\2"+
		"\2\u0b5f\u0b61\7\u0140\2\2\u0b60\u0b48\3\2\2\2\u0b60\u0b4c\3\2\2\2\u0b60"+
		"\u0b50\3\2\2\2\u0b60\u0b55\3\2\2\2\u0b60\u0b5a\3\2\2\2\u0b60\u0b5e\3\2"+
		"\2\2\u0b60\u0b5f\3\2\2\2\u0b61\u00af\3\2\2\2\u0b62\u0b63\7\u0152\2\2\u0b63"+
		"\u0b64\7\u0161\2\2\u0b64\u0b65\7\u0153\2\2\u0b65\u00b1\3\2\2\2\u0b66\u0b67"+
		"\7\u00d6\2\2\u0b67\u0b69\7\u0092\2\2\u0b68\u0b6a\5\u00b0Y\2\u0b69\u0b68"+
		"\3\2\2\2\u0b69\u0b6a\3\2\2\2\u0b6a\u0b8a\3\2\2\2\u0b6b\u0b6c\7\u00d6\2"+
		"\2\u0b6c\u0b6e\7\u0130\2\2\u0b6d\u0b6f\5\u00b0Y\2\u0b6e\u0b6d\3\2\2\2"+
		"\u0b6e\u0b6f\3\2\2\2\u0b6f\u0b8a\3\2\2\2\u0b70\u0b72\7\u0132\2\2\u0b71"+
		"\u0b73\5\u00b0Y\2\u0b72\u0b71\3\2\2\2\u0b72\u0b73\3\2\2\2\u0b73\u0b8a"+
		"\3\2\2\2\u0b74\u0b75\7\u00d6\2\2\u0b75\u0b76\7\u0092\2\2\u0b76\u0b78\7"+
		"\u0113\2\2\u0b77\u0b79\5\u00b0Y\2\u0b78\u0b77\3\2\2\2\u0b78\u0b79\3\2"+
		"\2\2\u0b79\u0b8a\3\2\2\2\u0b7a\u0b7b\7\u00d6\2\2\u0b7b\u0b7c\7\u0130\2"+
		"\2\u0b7c\u0b7e\7\u0113\2\2\u0b7d\u0b7f\5\u00b0Y\2\u0b7e\u0b7d\3\2\2\2"+
		"\u0b7e\u0b7f\3\2\2\2\u0b7f\u0b8a\3\2\2\2\u0b80\u0b81\7\u0132\2\2\u0b81"+
		"\u0b83\7\u0113\2\2\u0b82\u0b84\5\u00b0Y\2\u0b83\u0b82\3\2\2\2\u0b83\u0b84"+
		"\3\2\2\2\u0b84\u0b8a\3\2\2\2\u0b85\u0b87\7\u0133\2\2\u0b86\u0b88\5\u00b0"+
		"Y\2\u0b87\u0b86\3\2\2\2\u0b87\u0b88\3\2\2\2\u0b88\u0b8a\3\2\2\2\u0b89"+
		"\u0b66\3\2\2\2\u0b89\u0b6b\3\2\2\2\u0b89\u0b70\3\2\2\2\u0b89\u0b74\3\2"+
		"\2\2\u0b89\u0b7a\3\2\2\2\u0b89\u0b80\3\2\2\2\u0b89\u0b85\3\2\2\2\u0b8a"+
		"\u00b3\3\2\2\2\u0b8b\u0b8d\7\u013d\2\2\u0b8c\u0b8e\5\u00b0Y\2\u0b8d\u0b8c"+
		"\3\2\2\2\u0b8d\u0b8e\3\2\2\2\u0b8e\u0b94\3\2\2\2\u0b8f\u0b91\7\u013e\2"+
		"\2\u0b90\u0b92\5\u00b0Y\2\u0b91\u0b90\3\2\2\2\u0b91\u0b92\3\2\2\2\u0b92"+
		"\u0b94\3\2\2\2\u0b93\u0b8b\3\2\2\2\u0b93\u0b8f\3\2\2\2\u0b94\u00b5\3\2"+
		"\2\2\u0b95\u0b98\5\u00b8]\2\u0b96\u0b98\5\u00ba^\2\u0b97\u0b95\3\2\2\2"+
		"\u0b97\u0b96\3\2\2\2\u0b98\u00b7\3\2\2\2\u0b99\u0b9b\7\u012e\2\2\u0b9a"+
		"\u0b9c\5\u00bc_\2\u0b9b\u0b9a\3\2\2\2\u0b9b\u0b9c\3\2\2\2\u0b9c\u0baf"+
		"\3\2\2\2\u0b9d\u0b9f\7\u012f\2\2\u0b9e\u0ba0\5\u00bc_\2\u0b9f\u0b9e\3"+
		"\2\2\2\u0b9f\u0ba0\3\2\2\2\u0ba0\u0baf\3\2\2\2\u0ba1\u0ba3\7\u00a3\2\2"+
		"\u0ba2\u0ba4\5\u00bc_\2\u0ba3\u0ba2\3\2\2\2\u0ba3\u0ba4\3\2\2\2\u0ba4"+
		"\u0baf\3\2\2\2\u0ba5\u0baf\7\u011f\2\2\u0ba6\u0baf\7\u0123\2\2\u0ba7\u0baf"+
		"\7\u0120\2\2\u0ba8\u0baf\7\u0124\2\2\u0ba9\u0baf\7\u0121\2\2\u0baa\u0baf"+
		"\7\u0125\2\2\u0bab\u0baf\7\u0126\2\2\u0bac\u0baf\7\u0122\2\2\u0bad\u0baf"+
		"\7\u0127\2\2\u0bae\u0b99\3\2\2\2\u0bae\u0b9d\3\2\2\2\u0bae\u0ba1\3\2\2"+
		"\2\u0bae\u0ba5\3\2\2\2\u0bae\u0ba6\3\2\2\2\u0bae\u0ba7\3\2\2\2\u0bae\u0ba8"+
		"\3\2\2\2\u0bae\u0ba9\3\2\2\2\u0bae\u0baa\3\2\2\2\u0bae\u0bab\3\2\2\2\u0bae"+
		"\u0bac\3\2\2\2\u0bae\u0bad\3\2\2\2\u0baf\u00b9\3\2\2\2\u0bb0\u0bb2\7\u012c"+
		"\2\2\u0bb1\u0bb3\5\u00bc_\2\u0bb2\u0bb1\3\2\2\2\u0bb2\u0bb3\3\2\2\2\u0bb3"+
		"\u0bbb\3\2\2\2\u0bb4\u0bbb\7\u0128\2\2\u0bb5\u0bbb\7\u012a\2\2\u0bb6\u0bbb"+
		"\7\u0129\2\2\u0bb7\u0bbb\7\u012d\2\2\u0bb8\u0bb9\7\u012d\2\2\u0bb9\u0bbb"+
		"\7\u00e7\2\2\u0bba\u0bb0\3\2\2\2\u0bba\u0bb4\3\2\2\2\u0bba\u0bb5\3\2\2"+
		"\2\u0bba\u0bb6\3\2\2\2\u0bba\u0bb7\3\2\2\2\u0bba\u0bb8\3\2\2\2\u0bbb\u00bb"+
		"\3\2\2\2\u0bbc\u0bbd\7\u0152\2\2\u0bbd\u0bbe\7\u0161\2\2\u0bbe\u0bc5\7"+
		"\u0153\2\2\u0bbf\u0bc0\7\u0152\2\2\u0bc0\u0bc1\7\u0161\2\2\u0bc1\u0bc2"+
		"\7\u014b\2\2\u0bc2\u0bc3\7\u0161\2\2\u0bc3\u0bc5\7\u0153\2\2\u0bc4\u0bbc"+
		"\3\2\2\2\u0bc4\u0bbf\3\2\2\2\u0bc5\u00bd\3\2\2\2\u0bc6\u0bc7\t\27\2\2"+
		"\u0bc7\u00bf\3\2\2\2\u0bc8\u0bda\7\u0134\2\2\u0bc9\u0bda\7\u0135\2\2\u0bca"+
		"\u0bcb\7\u0135\2\2\u0bcb\u0bcc\7\u0087\2\2\u0bcc\u0bcd\7\u0135\2\2\u0bcd"+
		"\u0bda\7\u011a\2\2\u0bce\u0bda\7\u0136\2\2\u0bcf\u0bda\7\u0137\2\2\u0bd0"+
		"\u0bd1\7\u0137\2\2\u0bd1\u0bd2\7\u0087\2\2\u0bd2\u0bd3\7\u0135\2\2\u0bd3"+
		"\u0bda\7\u011a\2\2\u0bd4\u0bd5\7\u0137\2\2\u0bd5\u0bd6\7\u0088\2\2\u0bd6"+
		"\u0bd7\7\u0135\2\2\u0bd7\u0bda\7\u011a\2\2\u0bd8\u0bda\7\u0138\2\2\u0bd9"+
		"\u0bc8\3\2\2\2\u0bd9\u0bc9\3\2\2\2\u0bd9\u0bca\3\2\2\2\u0bd9\u0bce\3\2"+
		"\2\2\u0bd9\u0bcf\3\2\2\2\u0bd9\u0bd0\3\2\2\2\u0bd9\u0bd4\3\2\2\2\u0bd9"+
		"\u0bd8\3\2\2\2\u0bda\u00c1\3\2\2\2\u0bdb\u0bdd\7\u011d\2\2\u0bdc\u0bde"+
		"\5\u00b0Y\2\u0bdd\u0bdc\3\2\2\2\u0bdd\u0bde\3\2\2\2\u0bde\u0be9\3\2\2"+
		"\2\u0bdf\u0be1\7\u011e\2\2\u0be0\u0be2\5\u00b0Y\2\u0be1\u0be0\3\2\2\2"+
		"\u0be1\u0be2\3\2\2\2\u0be2\u0be9\3\2\2\2\u0be3\u0be4\7\u011d\2\2\u0be4"+
		"\u0be6\7\u0113\2\2\u0be5\u0be7\5\u00b0Y\2\u0be6\u0be5\3\2\2\2\u0be6\u0be7"+
		"\3\2\2\2\u0be7\u0be9\3\2\2\2\u0be8\u0bdb\3\2\2\2\u0be8\u0bdf\3\2\2\2\u0be8"+
		"\u0be3\3\2\2\2\u0be9\u00c3\3\2\2\2\u0bea\u0bec\7\u013b\2\2\u0beb\u0bed"+
		"\5\u00b0Y\2\u0bec\u0beb\3\2\2\2\u0bec\u0bed\3\2\2\2\u0bed\u0bf8\3\2\2"+
		"\2\u0bee\u0bef\7\u013b\2\2\u0bef\u0bf1\7\u0113\2\2\u0bf0\u0bf2\5\u00b0"+
		"Y\2\u0bf1\u0bf0\3\2\2\2\u0bf1\u0bf2\3\2\2\2\u0bf2\u0bf8\3\2\2\2\u0bf3"+
		"\u0bf5\7\u013c\2\2\u0bf4\u0bf6\5\u00b0Y\2\u0bf5\u0bf4\3\2\2\2\u0bf5\u0bf6"+
		"\3\2\2\2\u0bf6\u0bf8\3\2\2\2\u0bf7\u0bea\3\2\2\2\u0bf7\u0bee\3\2\2\2\u0bf7"+
		"\u0bf3\3\2\2\2\u0bf8\u00c5\3\2\2\2\u0bf9\u0bfc\5\u00c8e\2\u0bfa\u0bfc"+
		"\5\u00caf\2\u0bfb\u0bf9\3\2\2\2\u0bfb\u0bfa\3\2\2\2\u0bfc\u00c7\3\2\2"+
		"\2\u0bfd\u0bfe\7\u0152\2\2\u0bfe\u0bff\5\u00f6|\2\u0bff\u0c00\7\u0153"+
		"\2\2\u0c00\u00c9\3\2\2\2\u0c01\u0c0a\5\u00ccg\2\u0c02\u0c0a\5\u019e\u00d0"+
		"\2\u0c03\u0c0a\5\u00d2j\2\u0c04\u0c0a\5\u01a4\u00d3\2\u0c05\u0c0a\5\u00de"+
		"p\2\u0c06\u0c0a\5\u00f0y\2\u0c07\u0c0a\5\u01d8\u00ed\2\u0c08\u0c0a\7Q"+
		"\2\2\u0c09\u0c01\3\2\2\2\u0c09\u0c02\3\2\2\2\u0c09\u0c03\3\2\2\2\u0c09"+
		"\u0c04\3\2\2\2\u0c09\u0c05\3\2\2\2\u0c09\u0c06\3\2\2\2\u0c09\u0c07\3\2"+
		"\2\2\u0c09\u0c08\3\2\2\2\u0c0a\u00cb\3\2\2\2\u0c0b\u0c0c\5\u0098M\2\u0c0c"+
		"\u00cd\3\2\2\2\u0c0d\u0c0e\t\30\2\2\u0c0e\u00cf\3\2\2\2\u0c0f\u0c11\5"+
		"\u0104\u0083\2\u0c10\u0c0f\3\2\2\2\u0c10\u0c11\3\2\2\2\u0c11\u0c12\3\2"+
		"\2\2\u0c12\u0c13\5\u00ceh\2\u0c13\u00d1\3\2\2\2\u0c14\u0c15\5\u00d4k\2"+
		"\u0c15\u00d3\3\2\2\2\u0c16\u0c17\7\u009d\2\2\u0c17\u0c18\7\u0152\2\2\u0c18"+
		"\u0c19\7\u0156\2\2\u0c19\u0c1f\7\u0153\2\2\u0c1a\u0c1c\5\u00d6l\2\u0c1b"+
		"\u0c1d\5\u00dan\2\u0c1c\u0c1b\3\2\2\2\u0c1c\u0c1d\3\2\2\2\u0c1d\u0c1f"+
		"\3\2\2\2\u0c1e\u0c16\3\2\2\2\u0c1e\u0c1a\3\2\2\2\u0c1f\u00d5\3\2\2\2\u0c20"+
		"\u0c21\5\u00d8m\2\u0c21\u0c23\7\u0152\2\2\u0c22\u0c24\5\u019c\u00cf\2"+
		"\u0c23\u0c22\3\2\2\2\u0c23\u0c24\3\2\2\2\u0c24\u0c25\3\2\2\2\u0c25\u0c26"+
		"\5\u00f6|\2\u0c26\u0c27\7\u0153\2\2\u0c27\u00d7\3\2\2\2\u0c28\u0c29\t"+
		"\31\2\2\u0c29\u00d9\3\2\2\2\u0c2a\u0c2b\7\u00b3\2\2\u0c2b\u0c2c\7\u0152"+
		"\2\2\u0c2c\u0c2d\7\u0086\2\2\u0c2d\u0c2e\5\u0166\u00b4\2\u0c2e\u0c2f\7"+
		"\u0153\2\2\u0c2f\u00db\3\2\2\2\u0c30\u0c31\7\u00b7\2\2\u0c31\u0c32\7\u0152"+
		"\2\2\u0c32\u0c33\5\u01a2\u00d2\2\u0c33\u0c34\7\u0153\2\2\u0c34\u00dd\3"+
		"\2\2\2\u0c35\u0c36\5\u00e2r\2\u0c36\u00df\3\2\2\2\u0c37\u0c38\7\u00d9"+
		"\2\2\u0c38\u0c39\7\u0152\2\2\u0c39\u0c3a\5\u00fa~\2\u0c3a\u0c3b\7\u014b"+
		"\2\2\u0c3b\u0c3c\5\u0120\u0091\2\u0c3c\u0c3d\7\u0153\2\2\u0c3d\u0c4a\3"+
		"\2\2\2\u0c3e\u0c3f\7\u0096\2\2\u0c3f\u0c40\7\u0152\2\2\u0c40\u0c43\5\u00fa"+
		"~\2\u0c41\u0c42\7\u014b\2\2\u0c42\u0c44\5\u0120\u0091\2\u0c43\u0c41\3"+
		"\2\2\2\u0c44\u0c45\3\2\2\2\u0c45\u0c43\3\2\2\2\u0c45\u0c46\3\2\2\2\u0c46"+
		"\u0c47\3\2\2\2\u0c47\u0c48\7\u0153\2\2\u0c48\u0c4a\3\2\2\2\u0c49\u0c37"+
		"\3\2\2\2\u0c49\u0c3e\3\2\2\2\u0c4a\u00e1\3\2\2\2\u0c4b\u0c4e\5\u00e4s"+
		"\2\u0c4c\u0c4e\5\u00e6t\2\u0c4d\u0c4b\3\2\2\2\u0c4d\u0c4c\3\2\2\2\u0c4e"+
		"\u00e3\3\2\2\2\u0c4f\u0c50\7\20\2\2\u0c50\u0c52\5\u0120\u0091\2\u0c51"+
		"\u0c53\5\u00e8u\2\u0c52\u0c51\3\2\2\2\u0c53\u0c54\3\2\2\2\u0c54\u0c52"+
		"\3\2\2\2\u0c54\u0c55\3\2\2\2\u0c55\u0c57\3\2\2\2\u0c56\u0c58\5\u00ecw"+
		"\2\u0c57\u0c56\3\2\2\2\u0c57\u0c58\3\2\2\2\u0c58\u0c59\3\2\2\2\u0c59\u0c5a"+
		"\7%\2\2\u0c5a\u00e5\3\2\2\2\u0c5b\u0c5d\7\20\2\2\u0c5c\u0c5e\5\u00eav"+
		"\2\u0c5d\u0c5c\3\2\2\2\u0c5e\u0c5f\3\2\2\2\u0c5f\u0c5d\3\2\2\2\u0c5f\u0c60"+
		"\3\2\2\2\u0c60\u0c62\3\2\2\2\u0c61\u0c63\5\u00ecw\2\u0c62\u0c61\3\2\2"+
		"\2\u0c62\u0c63\3\2\2\2\u0c63\u0c64\3\2\2\2\u0c64\u0c65\7%\2\2\u0c65\u00e7"+
		"\3\2\2\2\u0c66\u0c67\7\u0085\2\2\u0c67\u0c68\5\u0166\u00b4\2\u0c68\u0c69"+
		"\7w\2\2\u0c69\u0c6a\5\u00eex\2\u0c6a\u00e9\3\2\2\2\u0c6b\u0c6c\7\u0085"+
		"\2\2\u0c6c\u0c6d\5\u0166\u00b4\2\u0c6d\u0c6e\7w\2\2\u0c6e\u0c6f\5\u00ee"+
		"x\2\u0c6f\u00eb\3\2\2\2\u0c70\u0c71\7&\2\2\u0c71\u0c72\5\u00eex\2\u0c72"+
		"\u00ed\3\2\2\2\u0c73\u0c76\5\u00f6|\2\u0c74\u0c76\7Q\2\2\u0c75\u0c73\3"+
		"\2\2\2\u0c75\u0c74\3\2\2\2\u0c76\u00ef\3\2\2\2\u0c77\u0c78\7\22\2\2\u0c78"+
		"\u0c79\7\u0152\2\2\u0c79\u0c7a\5\u00f2z\2\u0c7a\u0c7b\7\6\2\2\u0c7b\u0c7c"+
		"\5\u00f4{\2\u0c7c\u0c7d\7\u0153\2\2\u0c7d\u00f1\3\2\2\2\u0c7e\u0c7f\5"+
		"\u00f6|\2\u0c7f\u00f3\3\2\2\2\u0c80\u0c81\5\u00a6T\2\u0c81\u00f5\3\2\2"+
		"\2\u0c82\u0c86\5\u00f8}\2\u0c83\u0c86\5\u0134\u009b\2\u0c84\u0c86\5\u0120"+
		"\u0091\2\u0c85\u0c82\3\2\2\2\u0c85\u0c83\3\2\2\2\u0c85\u0c84\3\2\2\2\u0c86"+
		"\u00f7\3\2\2\2\u0c87\u0c8b\5\u00fa~\2\u0c88\u0c8b\5\u0110\u0089\2\u0c89"+
		"\u0c8b\7Q\2\2\u0c8a\u0c87\3\2\2\2\u0c8a\u0c88\3\2\2\2\u0c8a\u0c89\3\2"+
		"\2\2\u0c8b\u00f9\3\2\2\2\u0c8c\u0c91\5\u00fc\177\2\u0c8d\u0c8e\t\32\2"+
		"\2\u0c8e\u0c90\5\u00fc\177\2\u0c8f\u0c8d\3\2\2\2\u0c90\u0c93\3\2\2\2\u0c91"+
		"\u0c8f\3\2\2\2\u0c91\u0c92\3\2\2\2\u0c92\u00fb\3\2\2\2\u0c93\u0c91\3\2"+
		"\2\2\u0c94\u0c99\5\u00fe\u0080\2\u0c95\u0c96\t\33\2\2\u0c96\u0c98\5\u00fe"+
		"\u0080\2\u0c97\u0c95\3\2\2\2\u0c98\u0c9b\3\2\2\2\u0c99\u0c97\3\2\2\2\u0c99"+
		"\u0c9a\3\2\2\2\u0c9a\u00fd\3\2\2\2\u0c9b\u0c99\3\2\2\2\u0c9c\u0c9e\5\u0104"+
		"\u0083\2\u0c9d\u0c9c\3\2\2\2\u0c9d\u0c9e\3\2\2\2\u0c9e\u0c9f\3\2\2\2\u0c9f"+
		"\u0ca0\5\u0102\u0082\2\u0ca0\u00ff\3\2\2\2\u0ca1\u0ca2\7\u0152\2\2\u0ca2"+
		"\u0ca7\5\u00fa~\2\u0ca3\u0ca4\7\u014b\2\2\u0ca4\u0ca6\5\u00fa~\2\u0ca5"+
		"\u0ca3\3\2\2\2\u0ca6\u0ca9\3\2\2\2\u0ca7\u0ca5\3\2\2\2\u0ca7\u0ca8\3\2"+
		"\2\2\u0ca8\u0caa\3\2\2\2\u0ca9\u0ca7\3\2\2\2\u0caa\u0cab\7\u0153\2\2\u0cab"+
		"\u0101\3\2\2\2\u0cac\u0cb1\5\u00c6d\2\u0cad\u0cae\7\u0146\2\2\u0cae\u0cb0"+
		"\5\u00f4{\2\u0caf\u0cad\3\2\2\2\u0cb0\u0cb3\3\2\2\2\u0cb1\u0caf\3\2\2"+
		"\2\u0cb1\u0cb2\3\2\2\2\u0cb2\u0cb6\3\2\2\2\u0cb3\u0cb1\3\2\2\2\u0cb4\u0cb6"+
		"\5\u0106\u0084\2\u0cb5\u0cac\3\2\2\2\u0cb5\u0cb4\3\2\2\2\u0cb6\u0103\3"+
		"\2\2\2\u0cb7\u0cb8\t\32\2\2\u0cb8\u0105\3\2\2\2\u0cb9\u0cba\5\u0108\u0085"+
		"\2\u0cba\u0107\3\2\2\2\u0cbb\u0cbc\7\u00b1\2\2\u0cbc\u0cbd\7\u0152\2\2"+
		"\u0cbd\u0cbe\5\u010a\u0086\2\u0cbe\u0cbf\7\62\2\2\u0cbf\u0cc0\5\u010e"+
		"\u0088\2\u0cc0\u0cc1\7\u0153\2\2\u0cc1\u0109\3\2\2\2\u0cc2\u0cc6\5\u01d2"+
		"\u00ea\2\u0cc3\u0cc6\5\u010c\u0087\2\u0cc4\u0cc6\5\u01d6\u00ec\2\u0cc5"+
		"\u0cc2\3\2\2\2\u0cc5\u0cc3\3\2\2\2\u0cc5\u0cc4\3\2\2\2\u0cc6\u010b\3\2"+
		"\2\2\u0cc7\u0cc8\t\34\2\2\u0cc8\u010d\3\2\2\2\u0cc9\u0ccc\5\u019e\u00d0"+
		"\2\u0cca\u0ccc\5\u009cO\2\u0ccb\u0cc9\3\2\2\2\u0ccb\u0cca\3\2\2\2\u0ccc"+
		"\u010f\3\2\2\2\u0ccd\u0cce\5\u0112\u008a\2\u0cce\u0111\3\2\2\2\u0ccf\u0cd4"+
		"\5\u0114\u008b\2\u0cd0\u0cd1\7\u014c\2\2\u0cd1\u0cd3\5\u0114\u008b\2\u0cd2"+
		"\u0cd0\3\2\2\2\u0cd3\u0cd6\3\2\2\2\u0cd4\u0cd2\3\2\2\2\u0cd4\u0cd5\3\2"+
		"\2\2\u0cd5\u0113\3\2\2\2\u0cd6\u0cd4\3\2\2\2\u0cd7\u0cd8\5\u0116\u008c"+
		"\2\u0cd8\u0115\3\2\2\2\u0cd9\u0cdc\5\u00c6d\2\u0cda\u0cdc\5\u0118\u008d"+
		"\2\u0cdb\u0cd9\3\2\2\2\u0cdb\u0cda\3\2\2\2\u0cdc\u0117\3\2\2\2\u0cdd\u0cde"+
		"\5\u011a\u008e\2\u0cde\u0119\3\2\2\2\u0cdf\u0ce0\7\u0108\2\2\u0ce0\u0ce1"+
		"\7\u0152\2\2\u0ce1\u0ce2\5\u011c\u008f\2\u0ce2\u0ce3\7\u0153\2\2\u0ce3"+
		"\u011b\3\2\2\2\u0ce4\u0ce6\5\u011e\u0090\2\u0ce5\u0ce4\3\2\2\2\u0ce5\u0ce6"+
		"\3\2\2\2\u0ce6\u0ce8\3\2\2\2\u0ce7\u0ce9\5\u0112\u008a\2\u0ce8\u0ce7\3"+
		"\2\2\2\u0ce8\u0ce9\3\2\2\2\u0ce9\u0cea\3\2\2\2\u0cea\u0cec\7\62\2\2\u0ceb"+
		"\u0ce5\3\2\2\2\u0ceb\u0cec\3\2\2\2\u0cec\u0ced\3\2\2\2\u0ced\u0cf3\5\u0112"+
		"\u008a\2\u0cee\u0cef\5\u0112\u008a\2\u0cef\u0cf0\7\u014b\2\2\u0cf0\u0cf1"+
		"\5\u0112\u008a\2\u0cf1\u0cf3\3\2\2\2\u0cf2\u0ceb\3\2\2\2\u0cf2\u0cee\3"+
		"\2\2\2\u0cf3\u011d\3\2\2\2\u0cf4\u0cf5\t\35\2\2\u0cf5\u011f\3\2\2\2\u0cf6"+
		"\u0cf7\5\u0122\u0092\2\u0cf7\u0121\3\2\2\2\u0cf8\u0cfd\5\u0124\u0093\2"+
		"\u0cf9\u0cfa\7W\2\2\u0cfa\u0cfc\5\u0122\u0092\2\u0cfb\u0cf9\3\2\2\2\u0cfc"+
		"\u0cff\3\2\2\2\u0cfd\u0cfb\3\2\2\2\u0cfd\u0cfe\3\2\2\2\u0cfe\u0123\3\2"+
		"\2\2\u0cff\u0cfd\3\2\2\2\u0d00\u0d05\5\u0126\u0094\2\u0d01\u0d02\7\t\2"+
		"\2\u0d02\u0d04\5\u0124\u0093\2\u0d03\u0d01\3\2\2\2\u0d04\u0d07\3\2\2\2"+
		"\u0d05\u0d03\3\2\2\2\u0d05\u0d06\3\2\2\2\u0d06\u0125\3\2\2\2\u0d07\u0d05"+
		"\3\2\2\2\u0d08\u0d0c\5\u0128\u0095\2\u0d09\u0d0a\7P\2\2\u0d0a\u0d0c\5"+
		"\u0128\u0095\2\u0d0b\u0d08\3\2\2\2\u0d0b\u0d09\3\2\2\2\u0d0c\u0127\3\2"+
		"\2\2\u0d0d\u0d0f\5\u012e\u0098\2\u0d0e\u0d10\5\u012a\u0096\2\u0d0f\u0d0e"+
		"\3\2\2\2\u0d0f\u0d10\3\2\2\2\u0d10\u0129\3\2\2\2\u0d11\u0d13\7G\2\2\u0d12"+
		"\u0d14\7P\2\2\u0d13\u0d12\3\2\2\2\u0d13\u0d14\3\2\2\2\u0d14\u0d15\3\2"+
		"\2\2\u0d15\u0d16\5\u012c\u0097\2\u0d16\u012b\3\2\2\2\u0d17\u0d18\t\26"+
		"\2\2\u0d18\u012d\3\2\2\2\u0d19\u0d1c\5\u01ac\u00d7\2\u0d1a\u0d1c\5\u0130"+
		"\u0099\2\u0d1b\u0d19\3\2\2\2\u0d1b\u0d1a\3\2\2\2\u0d1c\u012f\3\2\2\2\u0d1d"+
		"\u0d20\5\u0132\u009a\2\u0d1e\u0d20\5\u00caf\2\u0d1f\u0d1d\3\2\2\2\u0d1f"+
		"\u0d1e\3\2\2\2\u0d20\u0131\3\2\2\2\u0d21\u0d22\7\u0152\2\2\u0d22\u0d23"+
		"\5\u0120\u0091\2\u0d23\u0d24\7\u0153\2\2\u0d24\u0133\3\2\2\2\u0d25\u0d28"+
		"\5\u0136\u009c\2\u0d26\u0d28\5\u0138\u009d\2\u0d27\u0d25\3\2\2\2\u0d27"+
		"\u0d26\3\2\2\2\u0d28\u0135\3\2\2\2\u0d29\u0d2a\5\u00caf\2\u0d2a\u0137"+
		"\3\2\2\2\u0d2b\u0d2c\7Q\2\2\u0d2c\u0139\3\2\2\2\u0d2d\u0d30\5\u0136\u009c"+
		"\2\u0d2e\u0d30\5\u013c\u009f\2\u0d2f\u0d2d\3\2\2\2\u0d2f\u0d2e\3\2\2\2"+
		"\u0d30\u013b\3\2\2\2\u0d31\u0d34\5\u00f8}\2\u0d32\u0d34\5\u0130\u0099"+
		"\2\u0d33\u0d31\3\2\2\2\u0d33\u0d32\3\2\2\2\u0d34\u013d\3\2\2\2\u0d35\u0d37"+
		"\5\u0140\u00a1\2\u0d36\u0d38\5\u0164\u00b3\2\u0d37\u0d36\3\2\2\2\u0d37"+
		"\u0d38\3\2\2\2\u0d38\u0d3a\3\2\2\2\u0d39\u0d3b\5\u0168\u00b5\2\u0d3a\u0d39"+
		"\3\2\2\2\u0d3a\u0d3b\3\2\2\2\u0d3b\u0d3d\3\2\2\2\u0d3c\u0d3e\5\u0178\u00bd"+
		"\2\u0d3d\u0d3c\3\2\2\2\u0d3d\u0d3e\3\2\2\2\u0d3e\u0d40\3\2\2\2\u0d3f\u0d41"+
		"\5\u01e0\u00f1\2\u0d40\u0d3f\3\2\2\2\u0d40\u0d41\3\2\2\2\u0d41\u0d43\3"+
		"\2\2\2\u0d42\u0d44\5\u01e8\u00f5\2\u0d43\u0d42\3\2\2\2\u0d43\u0d44\3\2"+
		"\2\2\u0d44\u013f\3\2\2\2\u0d45\u0d46\7\62\2\2\u0d46\u0d47\5\u0142\u00a2"+
		"\2\u0d47\u0141\3\2\2\2\u0d48\u0d4d\5\u0144\u00a3\2\u0d49\u0d4a\7\u014b"+
		"\2\2\u0d4a\u0d4c\5\u0144\u00a3\2\u0d4b\u0d49\3\2\2\2\u0d4c\u0d4f\3\2\2"+
		"\2\u0d4d\u0d4b\3\2\2\2\u0d4d\u0d4e\3\2\2\2\u0d4e\u0143\3\2\2\2\u0d4f\u0d4d"+
		"\3\2\2\2\u0d50\u0d53\5\u0146\u00a4\2\u0d51\u0d53\5\u015e\u00b0\2\u0d52"+
		"\u0d50\3\2\2\2\u0d52\u0d51\3\2\2\2\u0d53\u0145\3\2\2\2\u0d54\u0d56\5\u015e"+
		"\u00b0\2\u0d55\u0d57\5\u0148\u00a5\2\u0d56\u0d55\3\2\2\2\u0d57\u0d58\3"+
		"\2\2\2\u0d58\u0d56\3\2\2\2\u0d58\u0d59\3\2\2\2\u0d59\u0147\3\2\2\2\u0d5a"+
		"\u0d5b\7\32\2\2\u0d5b\u0d5c\7H\2\2\u0d5c\u0d6e\5\u015e\u00b0\2\u0d5d\u0d5f"+
		"\5\u0152\u00aa\2\u0d5e\u0d5d\3\2\2\2\u0d5e\u0d5f\3\2\2\2\u0d5f\u0d60\3"+
		"\2\2\2\u0d60\u0d61\7H\2\2\u0d61\u0d62\5\u015e\u00b0\2\u0d62\u0d63\5\u0158"+
		"\u00ad\2\u0d63\u0d6e\3\2\2\2\u0d64\u0d66\7O\2\2\u0d65\u0d67\5\u0152\u00aa"+
		"\2\u0d66\u0d65\3\2\2\2\u0d66\u0d67\3\2\2\2\u0d67\u0d68\3\2\2\2\u0d68\u0d69"+
		"\7H\2\2\u0d69\u0d6e\5\u015e\u00b0\2\u0d6a\u0d6b\7}\2\2\u0d6b\u0d6c\7H"+
		"\2\2\u0d6c\u0d6e\5\u015e\u00b0\2\u0d6d\u0d5a\3\2\2\2\u0d6d\u0d5e\3\2\2"+
		"\2\u0d6d\u0d64\3\2\2\2\u0d6d\u0d6a\3\2\2\2\u0d6e\u0149\3\2\2\2\u0d6f\u0d70"+
		"\7\32\2\2\u0d70\u0d71\7H\2\2\u0d71\u0d72\5\u015e\u00b0\2\u0d72\u014b\3"+
		"\2\2\2\u0d73\u0d75\5\u0152\u00aa\2\u0d74\u0d73\3\2\2\2\u0d74\u0d75\3\2"+
		"\2\2\u0d75\u0d76\3\2\2\2\u0d76\u0d77\7H\2\2\u0d77\u0d78\5\u015e\u00b0"+
		"\2\u0d78\u0d79\5\u0158\u00ad\2\u0d79\u014d\3\2\2\2\u0d7a\u0d7c\7O\2\2"+
		"\u0d7b\u0d7d\5\u0152\u00aa\2\u0d7c\u0d7b\3\2\2\2\u0d7c\u0d7d\3\2\2\2\u0d7d"+
		"\u0d7e\3\2\2\2\u0d7e\u0d7f\7H\2\2\u0d7f\u0d80\5\u015e\u00b0\2\u0d80\u014f"+
		"\3\2\2\2\u0d81\u0d82\7}\2\2\u0d82\u0d83\7H\2\2\u0d83\u0d84\5\u015e\u00b0"+
		"\2\u0d84\u0151\3\2\2\2\u0d85\u0d88\7A\2\2\u0d86\u0d88\5\u0154\u00ab\2"+
		"\u0d87\u0d85\3\2\2\2\u0d87\u0d86\3\2\2\2\u0d88\u0153\3\2\2\2\u0d89\u0d8b"+
		"\5\u0156\u00ac\2\u0d8a\u0d8c\7T\2\2\u0d8b\u0d8a\3\2\2\2\u0d8b\u0d8c\3"+
		"\2\2\2\u0d8c\u0155\3\2\2\2\u0d8d\u0d8e\t\36\2\2\u0d8e\u0157\3\2\2\2\u0d8f"+
		"\u0d92\5\u015a\u00ae\2\u0d90\u0d92\5\u015c\u00af\2\u0d91\u0d8f\3\2\2\2"+
		"\u0d91\u0d90\3\2\2\2\u0d92\u0159\3\2\2\2\u0d93\u0d94\7\u00dd\2\2\u0d94"+
		"\u0d95\5\u0166\u00b4\2\u0d95\u015b\3\2\2\2\u0d96\u0d97\7\u0081\2\2\u0d97"+
		"\u0d98\7\u0152\2\2\u0d98\u0d99\5\u01a2\u00d2\2\u0d99\u0d9a\7\u0153\2\2"+
		"\u0d9a\u015d\3\2\2\2\u0d9b\u0da0\5\u018e\u00c8\2\u0d9c\u0d9e\7\6\2\2\u0d9d"+
		"\u0d9c\3\2\2\2\u0d9d\u0d9e\3\2\2\2\u0d9e\u0d9f\3\2\2\2\u0d9f\u0da1\5\u0094"+
		"K\2\u0da0\u0d9d\3\2\2\2\u0da0\u0da1\3\2\2\2\u0da1\u0da6\3\2\2\2\u0da2"+
		"\u0da3\7\u0152\2\2\u0da3\u0da4\5\u0160\u00b1\2\u0da4\u0da5\7\u0153\2\2"+
		"\u0da5\u0da7\3\2\2\2\u0da6\u0da2\3\2\2\2\u0da6\u0da7\3\2\2\2\u0da7\u0db4"+
		"\3\2\2\2\u0da8\u0daa\5\u0162\u00b2\2\u0da9\u0dab\7\6\2\2\u0daa\u0da9\3"+
		"\2\2\2\u0daa\u0dab\3\2\2\2\u0dab\u0dac\3\2\2\2\u0dac\u0db1\5\u0094K\2"+
		"\u0dad\u0dae\7\u0152\2\2\u0dae\u0daf\5\u0160\u00b1\2\u0daf\u0db0\7\u0153"+
		"\2\2\u0db0\u0db2\3\2\2\2\u0db1\u0dad\3\2\2\2\u0db1\u0db2\3\2\2\2\u0db2"+
		"\u0db4\3\2\2\2\u0db3\u0d9b\3\2\2\2\u0db3\u0da8\3\2\2\2\u0db4\u015f\3\2"+
		"\2\2\u0db5\u0dba\5\u0094K\2\u0db6\u0db7\7\u014b\2\2\u0db7\u0db9\5\u0094"+
		"K\2\u0db8\u0db6\3\2\2\2\u0db9\u0dbc\3\2\2\2\u0dba\u0db8\3\2\2\2\u0dba"+
		"\u0dbb\3\2\2\2\u0dbb\u0161\3\2\2\2\u0dbc\u0dba\3\2\2\2\u0dbd\u0dbe\5\u01a8"+
		"\u00d5\2\u0dbe\u0163\3\2\2\2\u0dbf\u0dc0\7\u0086\2\2\u0dc0\u0dc1\5\u0166"+
		"\u00b4\2\u0dc1\u0165\3\2\2\2\u0dc2\u0dc3\5\u00f6|\2\u0dc3\u0167\3\2\2"+
		"\2\u0dc4\u0dc5\7\65\2\2\u0dc5\u0dc6\7\u008d\2\2\u0dc6\u0dc7\5\u016a\u00b6"+
		"\2\u0dc7\u0169\3\2\2\2\u0dc8\u0dcd\5\u016c\u00b7\2\u0dc9\u0dca\7\u014b"+
		"\2\2\u0dca\u0dcc\5\u016c\u00b7\2\u0dcb\u0dc9\3\2\2\2\u0dcc\u0dcf\3\2\2"+
		"\2\u0dcd\u0dcb\3\2\2\2\u0dcd\u0dce\3\2\2\2\u0dce\u016b\3\2\2\2\u0dcf\u0dcd"+
		"\3\2\2\2\u0dd0\u0dd5\5\u0172\u00ba\2\u0dd1\u0dd5\5\u0174\u00bb\2\u0dd2"+
		"\u0dd5\5\u0176\u00bc\2\u0dd3\u0dd5\5\u016e\u00b8\2\u0dd4\u0dd0\3\2\2\2"+
		"\u0dd4\u0dd1\3\2\2\2\u0dd4\u0dd2\3\2\2\2\u0dd4\u0dd3\3\2\2\2\u0dd5\u016d"+
		"\3\2\2\2\u0dd6\u0ddc\5\u013a\u009e\2\u0dd7\u0dd8\7\u0152\2\2\u0dd8\u0dd9"+
		"\5\u017a\u00be\2\u0dd9\u0dda\7\u0153\2\2\u0dda\u0ddc\3\2\2\2\u0ddb\u0dd6"+
		"\3\2\2\2\u0ddb\u0dd7\3\2\2\2\u0ddc\u016f\3\2\2\2\u0ddd\u0de2\5\u016e\u00b8"+
		"\2\u0dde\u0ddf\7\u014b\2\2\u0ddf\u0de1\5\u016e\u00b8\2\u0de0\u0dde\3\2"+
		"\2\2\u0de1\u0de4\3\2\2\2\u0de2\u0de0\3\2\2\2\u0de2\u0de3\3\2\2\2\u0de3"+
		"\u0171\3\2\2\2\u0de4\u0de2\3\2\2\2\u0de5\u0de6\7\u00f1\2\2\u0de6\u0de7"+
		"\7\u0152\2\2\u0de7\u0de8\5\u0170\u00b9\2\u0de8\u0de9\7\u0153\2\2\u0de9"+
		"\u0173\3\2\2\2\u0dea\u0deb\7\u009e\2\2\u0deb\u0dec\7\u0152\2\2\u0dec\u0ded"+
		"\5\u0170\u00b9\2\u0ded\u0dee\7\u0153\2\2\u0dee\u0175\3\2\2\2\u0def\u0df0"+
		"\7\u0152\2\2\u0df0\u0df1\7\u0153\2\2\u0df1\u0177\3\2\2\2\u0df2\u0df3\7"+
		"\66\2\2\u0df3\u0df4\5\u0120\u0091\2\u0df4\u0179\3\2\2\2\u0df5\u0dfa\5"+
		"\u013a\u009e\2\u0df6\u0df7\7\u014b\2\2\u0df7\u0df9\5\u013a\u009e\2\u0df8"+
		"\u0df6\3\2\2\2\u0df9\u0dfc\3\2\2\2\u0dfa\u0df8\3\2\2\2\u0dfa\u0dfb\3\2"+
		"\2\2\u0dfb\u017b\3\2\2\2\u0dfc\u0dfa\3\2\2\2\u0dfd\u0dfe\5\u017e\u00c0"+
		"\2\u0dfe\u017d\3\2\2\2\u0dff\u0e02\5\u0180\u00c1\2\u0e00\u0e02\5\u0146"+
		"\u00a4\2\u0e01\u0dff\3\2\2\2\u0e01\u0e00\3\2\2\2\u0e02\u017f\3\2\2\2\u0e03"+
		"\u0e0c\5\u0184\u00c3\2\u0e04\u0e05\5\u0146\u00a4\2\u0e05\u0e07\t\37\2"+
		"\2\u0e06\u0e08\t \2\2\u0e07\u0e06\3\2\2\2\u0e07\u0e08\3\2\2\2\u0e08\u0e09"+
		"\3\2\2\2\u0e09\u0e0a\5\u0182\u00c2\2\u0e0a\u0e0c\3\2\2\2\u0e0b\u0e03\3"+
		"\2\2\2\u0e0b\u0e04\3\2\2\2\u0e0c\u0e14\3\2\2\2\u0e0d\u0e0f\t\37\2\2\u0e0e"+
		"\u0e10\t \2\2\u0e0f\u0e0e\3\2\2\2\u0e0f\u0e10\3\2\2\2\u0e10\u0e11\3\2"+
		"\2\2\u0e11\u0e13\5\u0182\u00c2\2\u0e12\u0e0d\3\2\2\2\u0e13\u0e16\3\2\2"+
		"\2\u0e14\u0e12\3\2\2\2\u0e14\u0e15\3\2\2\2\u0e15\u0181\3\2\2\2\u0e16\u0e14"+
		"\3\2\2\2\u0e17\u0e1a\5\u0184\u00c3\2\u0e18\u0e1a\5\u0146\u00a4\2\u0e19"+
		"\u0e17\3\2\2\2\u0e19\u0e18\3\2\2\2\u0e1a\u0183\3\2\2\2\u0e1b\u0e24\5\u0188"+
		"\u00c5\2\u0e1c\u0e1d\5\u0146\u00a4\2\u0e1d\u0e1f\7B\2\2\u0e1e\u0e20\t"+
		" \2\2\u0e1f\u0e1e\3\2\2\2\u0e1f\u0e20\3\2\2\2\u0e20\u0e21\3\2\2\2\u0e21"+
		"\u0e22\5\u0186\u00c4\2\u0e22\u0e24\3\2\2\2\u0e23\u0e1b\3\2\2\2\u0e23\u0e1c"+
		"\3\2\2\2\u0e24\u0e2c\3\2\2\2\u0e25\u0e27\7B\2\2\u0e26\u0e28\t \2\2\u0e27"+
		"\u0e26\3\2\2\2\u0e27\u0e28\3\2\2\2\u0e28\u0e29\3\2\2\2\u0e29\u0e2b\5\u0186"+
		"\u00c4\2\u0e2a\u0e25\3\2\2\2\u0e2b\u0e2e\3\2\2\2\u0e2c\u0e2a\3\2\2\2\u0e2c"+
		"\u0e2d\3\2\2\2\u0e2d\u0185\3\2\2\2\u0e2e\u0e2c\3\2\2\2\u0e2f\u0e32\5\u0188"+
		"\u00c5\2\u0e30\u0e32\5\u0146\u00a4\2\u0e31\u0e2f\3\2\2\2\u0e31\u0e30\3"+
		"\2\2\2\u0e32\u0187\3\2\2\2\u0e33\u0e39\5\u018a\u00c6\2\u0e34\u0e35\7\u0152"+
		"\2\2\u0e35\u0e36\5\u0180\u00c1\2\u0e36\u0e37\7\u0153\2\2\u0e37\u0e39\3"+
		"\2\2\2\u0e38\u0e33\3\2\2\2\u0e38\u0e34\3\2\2\2\u0e39\u0189\3\2\2\2\u0e3a"+
		"\u0e3d\5\u0192\u00ca\2\u0e3b\u0e3d\5\u018c\u00c7\2\u0e3c\u0e3a\3\2\2\2"+
		"\u0e3c\u0e3b\3\2\2\2\u0e3d\u018b\3\2\2\2\u0e3e\u0e3f\7t\2\2\u0e3f\u0e40"+
		"\5\u018e\u00c8\2\u0e40\u018d\3\2\2\2\u0e41\u0e44\5\u0190\u00c9\2\u0e42"+
		"\u0e44\5\u0094K\2\u0e43\u0e41\3\2\2\2\u0e43\u0e42\3\2\2\2\u0e44\u018f"+
		"\3\2\2\2\u0e45\u0e4c\5\u0094K\2\u0e46\u0e47\7\u0159\2\2\u0e47\u0e4a\5"+
		"\u0094K\2\u0e48\u0e49\7\u0159\2\2\u0e49\u0e4b\5\u0094K\2\u0e4a\u0e48\3"+
		"\2\2\2\u0e4a\u0e4b\3\2\2\2\u0e4b\u0e4d\3\2\2\2\u0e4c\u0e46\3\2\2\2\u0e4c"+
		"\u0e4d\3\2\2\2\u0e4d\u0191\3\2\2\2\u0e4e\u0e50\7m\2\2\u0e4f\u0e51\5\u019c"+
		"\u00cf\2\u0e50\u0e4f\3\2\2\2\u0e50\u0e51\3\2\2\2\u0e51\u0e52\3\2\2\2\u0e52"+
		"\u0e54\5\u0194\u00cb\2\u0e53\u0e55\5\u013e\u00a0\2\u0e54\u0e53\3\2\2\2"+
		"\u0e54\u0e55\3\2\2\2\u0e55\u0193\3\2\2\2\u0e56\u0e5b\5\u0196\u00cc\2\u0e57"+
		"\u0e58\7\u014b\2\2\u0e58\u0e5a\5\u0196\u00cc\2\u0e59\u0e57\3\2\2\2\u0e5a"+
		"\u0e5d\3\2\2\2\u0e5b\u0e59\3\2\2\2\u0e5b\u0e5c\3\2\2\2\u0e5c\u0195\3\2"+
		"\2\2\u0e5d\u0e5b\3\2\2\2\u0e5e\u0e61\5\u0198\u00cd\2\u0e5f\u0e61\5\u019a"+
		"\u00ce\2\u0e60\u0e5e\3\2\2\2\u0e60\u0e5f\3\2\2\2\u0e61\u0197\3\2\2\2\u0e62"+
		"\u0e64\5\u00f6|\2\u0e63\u0e65\5\u01a0\u00d1\2\u0e64\u0e63\3\2\2\2\u0e64"+
		"\u0e65\3\2\2\2\u0e65\u0199\3\2\2\2\u0e66\u0e67\7\u0165\2\2\u0e67\u0e69"+
		"\7\u0159\2\2\u0e68\u0e66\3\2\2\2\u0e68\u0e69\3\2\2\2\u0e69\u0e6a\3\2\2"+
		"\2\u0e6a\u0e6b\7\u0156\2\2\u0e6b\u019b\3\2\2\2\u0e6c\u0e6d\t \2\2\u0e6d"+
		"\u019d\3\2\2\2\u0e6e\u0e6f\5\u0094K\2\u0e6f\u0e70\7\u0159\2\2\u0e70\u0e72"+
		"\3\2\2\2\u0e71\u0e6e\3\2\2\2\u0e71\u0e72\3\2\2\2\u0e72\u0e73\3\2\2\2\u0e73"+
		"\u0e74\5\u0094K\2\u0e74\u019f\3\2\2\2\u0e75\u0e77\7\6\2\2\u0e76\u0e75"+
		"\3\2\2\2\u0e76\u0e77\3\2\2\2\u0e77\u0e78\3\2\2\2\u0e78\u0e79\5\u0094K"+
		"\2\u0e79\u01a1\3\2\2\2\u0e7a\u0e7f\5\u019e\u00d0\2\u0e7b\u0e7c\7\u014b"+
		"\2\2\u0e7c\u0e7e\5\u019e\u00d0\2\u0e7d\u0e7b\3\2\2\2\u0e7e\u0e81\3\2\2"+
		"\2\u0e7f\u0e7d\3\2\2\2\u0e7f\u0e80\3\2\2\2\u0e80\u01a3\3\2\2\2\u0e81\u0e7f"+
		"\3\2\2\2\u0e82\u0e83\5\u01aa\u00d6\2\u0e83\u01a5\3\2\2\2\u0e84\u0e85\5"+
		"\u01aa\u00d6\2\u0e85\u01a7\3\2\2\2\u0e86\u0e87\5\u01aa\u00d6\2\u0e87\u01a9"+
		"\3\2\2\2\u0e88\u0e89\7\u0152\2\2\u0e89\u0e8a\5\u017c\u00bf\2\u0e8a\u0e8b"+
		"\7\u0153\2\2\u0e8b\u01ab\3\2\2\2\u0e8c\u0e93\5\u01ae\u00d8\2\u0e8d\u0e93"+
		"\5\u01b2\u00da\2\u0e8e\u0e93\5\u01b6\u00dc\2\u0e8f\u0e93\5\u01bc\u00df"+
		"\2\u0e90\u0e93\5\u01c4\u00e3\2\u0e91\u0e93\5\u01ce\u00e8\2\u0e92\u0e8c"+
		"\3\2\2\2\u0e92\u0e8d\3\2\2\2\u0e92\u0e8e\3\2\2\2\u0e92\u0e8f\3\2\2\2\u0e92"+
		"\u0e90\3\2\2\2\u0e92\u0e91\3\2\2\2\u0e93\u01ad\3\2\2\2\u0e94\u0e95\5\u013a"+
		"\u009e\2\u0e95\u0e96\5\u01b0\u00d9\2\u0e96\u0e97\5\u013a\u009e\2\u0e97"+
		"\u01af\3\2\2\2\u0e98\u0e99\t!\2\2\u0e99\u01b1\3\2\2\2\u0e9a\u0e9b\5\u013a"+
		"\u009e\2\u0e9b\u0e9c\5\u01b4\u00db\2\u0e9c\u01b3\3\2\2\2\u0e9d\u0e9f\7"+
		"P\2\2\u0e9e\u0e9d\3\2\2\2\u0e9e\u0e9f\3\2\2\2\u0e9f\u0ea0\3\2\2\2\u0ea0"+
		"\u0ea2\7\u008c\2\2\u0ea1\u0ea3\t\"\2\2\u0ea2\u0ea1\3\2\2\2\u0ea2\u0ea3"+
		"\3\2\2\2\u0ea3\u0ea4\3\2\2\2\u0ea4\u0ea5\5\u013a\u009e\2\u0ea5\u0ea6\7"+
		"\t\2\2\u0ea6\u0ea7\5\u013a\u009e\2\u0ea7\u01b5\3\2\2\2\u0ea8\u0eaa\5\u00fa"+
		"~\2\u0ea9\u0eab\7P\2\2\u0eaa\u0ea9\3\2\2\2\u0eaa\u0eab\3\2\2\2\u0eab\u0eac"+
		"\3\2\2\2\u0eac\u0ead\7<\2\2\u0ead\u0eae\5\u01b8\u00dd\2\u0eae\u01b7\3"+
		"\2\2\2\u0eaf\u0eb5\5\u01a8\u00d5\2\u0eb0\u0eb1\7\u0152\2\2\u0eb1\u0eb2"+
		"\5\u01ba\u00de\2\u0eb2\u0eb3\7\u0153\2\2\u0eb3\u0eb5\3\2\2\2\u0eb4\u0eaf"+
		"\3\2\2\2\u0eb4\u0eb0\3\2\2\2\u0eb5\u01b9\3\2\2\2\u0eb6\u0ebb\5\u0134\u009b"+
		"\2\u0eb7\u0eb8\7\u014b\2\2\u0eb8\u0eba\5\u0134\u009b\2\u0eb9\u0eb7\3\2"+
		"\2\2\u0eba\u0ebd\3\2\2\2\u0ebb\u0eb9\3\2\2\2\u0ebb\u0ebc\3\2\2\2\u0ebc"+
		"\u01bb\3\2\2\2\u0ebd\u0ebb\3\2\2\2\u0ebe\u0ebf\5\u013a\u009e\2\u0ebf\u0ec0"+
		"\5\u01be\u00e0\2\u0ec0\u0ec1\7\u0168\2\2\u0ec1\u01bd\3\2\2\2\u0ec2\u0ec4"+
		"\7P\2\2\u0ec3\u0ec2\3\2\2\2\u0ec3\u0ec4\3\2\2\2\u0ec4\u0ec5\3\2\2\2\u0ec5"+
		"\u0ec8\5\u01c0\u00e1\2\u0ec6\u0ec8\5\u01c2\u00e2\2\u0ec7\u0ec3\3\2\2\2"+
		"\u0ec7\u0ec6\3\2\2\2\u0ec8\u01bf\3\2\2\2\u0ec9\u0ed0\7L\2\2\u0eca\u0ed0"+
		"\79\2\2\u0ecb\u0ecc\7\u00f7\2\2\u0ecc\u0ed0\7\u0109\2\2\u0ecd\u0ed0\7"+
		"\u00ec\2\2\u0ece\u0ed0\7\u00f0\2\2\u0ecf\u0ec9\3\2\2\2\u0ecf\u0eca\3\2"+
		"\2\2\u0ecf\u0ecb\3\2\2\2\u0ecf\u0ecd\3\2\2\2\u0ecf\u0ece\3\2\2\2\u0ed0"+
		"\u01c1\3\2\2\2\u0ed1\u0ed2\t#\2\2\u0ed2\u01c3\3\2\2\2\u0ed3\u0ed4\5\u013a"+
		"\u009e\2\u0ed4\u0ed6\7G\2\2\u0ed5\u0ed7\7P\2\2\u0ed6\u0ed5\3\2\2\2\u0ed6"+
		"\u0ed7\3\2\2\2\u0ed7\u0ed8\3\2\2\2\u0ed8\u0ed9\7Q\2\2\u0ed9\u01c5\3\2"+
		"\2\2\u0eda\u0edb\5\u00fa~\2\u0edb\u0edc\5\u01b0\u00d9\2\u0edc\u0edd\5"+
		"\u01c8\u00e5\2\u0edd\u0ede\5\u01a8\u00d5\2\u0ede\u01c7\3\2\2\2\u0edf\u0ee2"+
		"\5\u01ca\u00e6\2\u0ee0\u0ee2\5\u01cc\u00e7\2\u0ee1\u0edf\3\2\2\2\u0ee1"+
		"\u0ee0\3\2\2\2\u0ee2\u01c9\3\2\2\2\u0ee3\u0ee4\7\7\2\2\u0ee4\u01cb\3\2"+
		"\2\2\u0ee5\u0ee6\t$\2\2\u0ee6\u01cd\3\2\2\2\u0ee7\u0ee9\7P\2\2\u0ee8\u0ee7"+
		"\3\2\2\2\u0ee8\u0ee9\3\2\2\2\u0ee9\u0eea\3\2\2\2\u0eea\u0eeb\7\u00ae\2"+
		"\2\u0eeb\u0eec\5\u01a8\u00d5\2\u0eec\u01cf\3\2\2\2\u0eed\u0eee\7~\2\2"+
		"\u0eee\u0eef\5\u01a8\u00d5\2\u0eef\u01d1\3\2\2\2\u0ef0\u0ef3\5\u01d4\u00eb"+
		"\2\u0ef1\u0ef3\7\u00f3\2\2\u0ef2\u0ef0\3\2\2\2\u0ef2\u0ef1\3\2\2\2\u0ef3"+
		"\u01d3\3\2\2\2\u0ef4\u0ef5\t%\2\2\u0ef5\u01d5\3\2\2\2\u0ef6\u0ef7\t&\2"+
		"\2\u0ef7\u01d7\3\2\2\2\u0ef8\u0ef9\5\u01dc\u00ef\2\u0ef9\u0efb\7\u0152"+
		"\2\2\u0efa\u0efc\5\u01de\u00f0\2\u0efb\u0efa\3\2\2\2\u0efb\u0efc\3\2\2"+
		"\2\u0efc\u0efd\3\2\2\2\u0efd\u0efe\7\u0153\2\2\u0efe\u01d9\3\2\2\2\u0eff"+
		"\u0f00\t\'\2\2\u0f00\u01db\3\2\2\2\u0f01\u0f04\5\u0094K\2\u0f02\u0f04"+
		"\5\u01da\u00ee\2\u0f03\u0f01\3\2\2\2\u0f03\u0f02\3\2\2\2\u0f04\u01dd\3"+
		"\2\2\2\u0f05\u0f0a\5\u00f6|\2\u0f06\u0f07\7\u014b\2\2\u0f07\u0f09\5\u00f6"+
		"|\2\u0f08\u0f06\3\2\2\2\u0f09\u0f0c\3\2\2\2\u0f0a\u0f08\3\2\2\2\u0f0a"+
		"\u0f0b\3\2\2\2\u0f0b\u01df\3\2\2\2\u0f0c\u0f0a\3\2\2\2\u0f0d\u0f0e\7X"+
		"\2\2\u0f0e\u0f0f\7\u008d\2\2\u0f0f\u0f10\5\u01e2\u00f2\2\u0f10\u01e1\3"+
		"\2\2\2\u0f11\u0f16\5\u01e4\u00f3\2\u0f12\u0f13\7\u014b\2\2\u0f13\u0f15"+
		"\5\u01e4\u00f3\2\u0f14\u0f12\3\2\2\2\u0f15\u0f18\3\2\2\2\u0f16\u0f14\3"+
		"\2\2\2\u0f16\u0f17\3\2\2\2\u0f17\u01e3\3\2\2\2\u0f18\u0f16\3\2\2\2\u0f19"+
		"\u0f1b\5\u013a\u009e\2\u0f1a\u0f1c\5\u01e6\u00f4\2\u0f1b\u0f1a\3\2\2\2"+
		"\u0f1b\u0f1c\3\2\2\2\u0f1c\u0f1e\3\2\2\2\u0f1d\u0f1f\5\u01ea\u00f6\2\u0f1e"+
		"\u0f1d\3\2\2\2\u0f1e\u0f1f\3\2\2\2\u0f1f\u01e5\3\2\2\2\u0f20\u0f21\t("+
		"\2\2\u0f21\u01e7\3\2\2\2\u0f22\u0f23\7M\2\2\u0f23\u0f24\5\u00fa~\2\u0f24"+
		"\u01e9\3\2\2\2\u0f25\u0f26\7Q\2\2\u0f26\u0f2a\7\u00b4\2\2\u0f27\u0f28"+
		"\7Q\2\2\u0f28\u0f2a\7\u00c7\2\2\u0f29\u0f25\3\2\2\2\u0f29\u0f27\3\2\2"+
		"\2\u0f2a\u01eb\3\2\2\2\u0f2b\u0f2d\7\u00bf\2\2\u0f2c\u0f2e\7\u00e1\2\2"+
		"\u0f2d\u0f2c\3\2\2\2\u0f2d\u0f2e\3\2\2\2\u0f2e\u0f2f\3\2\2\2\u0f2f\u0f30"+
		"\7C\2\2\u0f30\u0f35\5\u0190\u00c9\2\u0f31\u0f32\7\u0152\2\2\u0f32\u0f33"+
		"\5\u0160\u00b1\2\u0f33\u0f34\7\u0153\2\2\u0f34\u0f36\3\2\2\2\u0f35\u0f31"+
		"\3\2\2\2\u0f35\u0f36\3\2\2\2\u0f36\u0f37\3\2\2\2\u0f37\u0f38\5\u017c\u00bf"+
		"\2\u0f38\u0f49\3\2\2\2\u0f39\u0f3b\7\u00bf\2\2\u0f3a\u0f3c\7\u00e1\2\2"+
		"\u0f3b\u0f3a\3\2\2\2\u0f3b\u0f3c\3\2\2\2\u0f3c\u0f3d\3\2\2\2\u0f3d\u0f3e"+
		"\7C\2\2\u0f3e\u0f3f\7\u00ca\2\2\u0f3f\u0f45\7\u0168\2\2\u0f40\u0f41\7"+
		"\u0081\2\2\u0f41\u0f43\5\u0094K\2\u0f42\u0f44\5n8\2\u0f43\u0f42\3\2\2"+
		"\2\u0f43\u0f44\3\2\2\2\u0f44\u0f46\3\2\2\2\u0f45\u0f40\3\2\2\2\u0f45\u0f46"+
		"\3\2\2\2\u0f46\u0f47\3\2\2\2\u0f47\u0f49\5\u017c\u00bf\2\u0f48\u0f2b\3"+
		"\2\2\2\u0f48\u0f39\3\2\2\2\u0f49\u01ed\3\2\2\2\u0222\u01f0\u01f4\u0202"+
		"\u0211\u0217\u0220\u0223\u023d\u024d\u0251\u025b\u0263\u0268\u026d\u0271"+
		"\u0275\u027a\u027f\u0283\u0297\u029b\u02a0\u02a4\u02a8\u02ac\u02b1\u02b7"+
		"\u02bb\u02bf\u02c8\u02d0\u02da\u02e3\u02ec\u02f0\u02f6\u02fd\u0301\u0307"+
		"\u0315\u0320\u032a\u0331\u035b\u035f\u0372\u0376\u0381\u0387\u0389\u039b"+
		"\u03a0\u03af\u03ba\u03be\u03c5\u03cb\u03d2\u03d6\u03da\u03de\u03e2\u03e7"+
		"\u03ea\u03f1\u03f4\u03f7\u03ff\u0403\u0405\u0409\u0413\u0416\u041a\u041e"+
		"\u0425\u0428\u042c\u042e\u0432\u043a\u0443\u0447\u0449\u044b\u0451\u0456"+
		"\u045c\u0460\u0464\u0468\u0470\u0472\u047a\u047f\u0483\u0485\u0489\u048e"+
		"\u0497\u0499\u04a1\u04a7\u04ab\u04b1\u04b5\u04ba\u04be\u04c2\u04c6\u04ca"+
		"\u04ce\u04d6\u04db\u04df\u04e1\u04e7\u04eb\u04f3\u04f7\u04f9\u0501\u0506"+
		"\u050a\u050c\u0512\u0516\u051e\u0523\u0525\u052d\u0531\u0539\u053e\u0540"+
		"\u0547\u054b\u0553\u0558\u055a\u055f\u0567\u056c\u056e\u0574\u0578\u0580"+
		"\u0585\u0587\u0589\u058d\u058f\u0596\u059a\u05a2\u05a6\u05aa\u05ae\u05b0"+
		"\u05b6\u05ba\u05c2\u05c7\u05c9\u05cf\u05d3\u05db\u05df\u05e3\u05e8\u05ec"+
		"\u05ef\u05f1\u05f5\u05fa\u05fc\u05fe\u0601\u0607\u060b\u060d\u0611\u0615"+
		"\u0619\u0621\u0625\u0627\u062f\u0633\u0637\u063b\u063f\u0643\u0645\u0649"+
		"\u064d\u0651\u0658\u065c\u0660\u0662\u0668\u066c\u0674\u0678\u067a\u0681"+
		"\u0685\u0689\u068b\u0691\u0695\u069d\u069f\u06a7\u06ab\u06b3\u06b5\u06bc"+
		"\u06c0\u06c8\u06ca\u06cf\u06d7\u06d9\u06df\u06e3\u06ea\u06ee\u06f2\u06f4"+
		"\u06fb\u06ff\u0706\u070a\u070e\u0710\u0716\u071a\u0722\u0724\u072a\u072e"+
		"\u0734\u0738\u073d\u0741\u0746\u0748\u074c\u0750\u0753\u0757\u075c\u0765"+
		"\u0769\u07a8\u07d6\u07de\u07e6\u07ee\u07f2\u07f6\u0809\u080e\u081e\u0824"+
		"\u082d\u082f\u0835\u0839\u083d\u0841\u0844\u0848\u084c\u0850\u0852\u0855"+
		"\u0859\u0860\u0866\u086f\u087c\u087f\u0883\u0886\u088a\u0895\u0899\u089d"+
		"\u08a3\u08aa\u08b0\u08b4\u08ba\u08c1\u08c3\u08c5\u08cd\u08d2\u08dc\u08e7"+
		"\u08f0\u08f5\u08f8\u08fe\u0902\u090a\u090e\u0912\u091b\u091f\u0925\u0930"+
		"\u0933\u0936\u093a\u093c\u0943\u0947\u094b\u0953\u0957\u095d\u0969\u096d"+
		"\u0970\u0974\u0978\u097e\u0984\u0989\u0991\u0998\u099c\u09a6\u09aa\u09b2"+
		"\u09b9\u09bd\u09c6\u09cd\u09d1\u09d9\u09dd\u09e1\u09e9\u09ee\u09f3\u09f5"+
		"\u09fa\u0a00\u0a04\u0a0d\u0a1d\u0a22\u0a27\u0a29\u0a2e\u0a34\u0a3f\u0a42"+
		"\u0a46\u0a52\u0a5b\u0a5d\u0a61\u0a69\u0a6c\u0a72\u0a7a\u0a8b\u0aa0\u0ab1"+
		"\u0abe\u0ac2\u0ac4\u0ad1\u0ad8\u0af0\u0af7\u0b08\u0b0d\u0b11\u0b13\u0b19"+
		"\u0b1e\u0b23\u0b33\u0b42\u0b4a\u0b4e\u0b53\u0b58\u0b5c\u0b60\u0b69\u0b6e"+
		"\u0b72\u0b78\u0b7e\u0b83\u0b87\u0b89\u0b8d\u0b91\u0b93\u0b97\u0b9b\u0b9f"+
		"\u0ba3\u0bae\u0bb2\u0bba\u0bc4\u0bd9\u0bdd\u0be1\u0be6\u0be8\u0bec\u0bf1"+
		"\u0bf5\u0bf7\u0bfb\u0c09\u0c10\u0c1c\u0c1e\u0c23\u0c45\u0c49\u0c4d\u0c54"+
		"\u0c57\u0c5f\u0c62\u0c75\u0c85\u0c8a\u0c91\u0c99\u0c9d\u0ca7\u0cb1\u0cb5"+
		"\u0cc5\u0ccb\u0cd4\u0cdb\u0ce5\u0ce8\u0ceb\u0cf2\u0cfd\u0d05\u0d0b\u0d0f"+
		"\u0d13\u0d1b\u0d1f\u0d27\u0d2f\u0d33\u0d37\u0d3a\u0d3d\u0d40\u0d43\u0d4d"+
		"\u0d52\u0d58\u0d5e\u0d66\u0d6d\u0d74\u0d7c\u0d87\u0d8b\u0d91\u0d9d\u0da0"+
		"\u0da6\u0daa\u0db1\u0db3\u0dba\u0dcd\u0dd4\u0ddb\u0de2\u0dfa\u0e01\u0e07"+
		"\u0e0b\u0e0f\u0e14\u0e19\u0e1f\u0e23\u0e27\u0e2c\u0e31\u0e38\u0e3c\u0e43"+
		"\u0e4a\u0e4c\u0e50\u0e54\u0e5b\u0e60\u0e64\u0e68\u0e71\u0e76\u0e7f\u0e92"+
		"\u0e9e\u0ea2\u0eaa\u0eb4\u0ebb\u0ec3\u0ec7\u0ecf\u0ed6\u0ee1\u0ee8\u0ef2"+
		"\u0efb\u0f03\u0f0a\u0f16\u0f1b\u0f1e\u0f29\u0f2d\u0f35\u0f3b\u0f43\u0f45"+
		"\u0f48";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}