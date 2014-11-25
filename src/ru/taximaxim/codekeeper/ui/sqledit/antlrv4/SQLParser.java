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
		FUNCTION=52, ISODOW=202, OVERWRITE=234, FUNCTIONS=53, ROW=102, PRECISION=240, 
		ILIKE=62, TYPES=279, ENABLE=178, Character_String_Literal=375, NOT=85, 
		EXCEPT=41, FOREIGN=48, CACHE=148, PRIVILEGES=98, BYTEA=331, MONTH=221, 
		STATEMENT=118, CHARACTER=152, TYPE=278, BlockComment=370, VARBIT=299, 
		STDDEV_POP=265, CREATE=24, COMMENTS=159, ESC_SEQUENCES=376, USING=134, 
		UNLOGGED=281, NOT_EQUAL=347, TIMEZONE_MINUTE=275, VERTICAL_BAR=361, VARIADIC=136, 
		TIMESTAMPTZ=325, RIGHT_BRACKET=366, VALID=283, REGEXP=246, FAMILY=186, 
		GEQ=351, HANDLER=59, STDDEV_SAMP=266, DIVIDE=357, DISABLE=174, BLOB=330, 
		REPLICA=248, STRICT=119, PRESERVE=96, ASC=10, GROUPING=191, SUBPARTITION=267, 
		VALIDATOR=135, KEY=78, SETOF=116, TEMP=122, ELSE=37, NUMBER=368, BOOL=297, 
		TRAILING=125, DEFINER=172, SEMI_COLON=344, INT=306, RLIKE=251, LEADING=79, 
		RESTRICT=106, SERVER=256, PROCEDURAL=100, TABLESPACE=269, MILLISECONDS=217, 
		REAL=311, INTERSECT=71, GROUP=57, LANGUAGE=205, SEQUENCES=113, OUT=90, 
		REAL_NUMBER=369, NONE=224, USER=282, TRIM=276, LEFT_PAREN=352, LOCATION=210, 
		SEARCH=253, END=38, N_DISTINCT=226, CONSTRAINT=20, TIMEZONE_HOUR=274, 
		RENAME=247, CAST_EXPRESSION=340, ALTER=6, OPTION=231, ISOYEAR=203, UUID=327, 
		NCHAR=319, PLAIN=239, ONLY=230, EXECUTE=44, LEFT_BRACKET=365, OWNER=95, 
		INPUT=198, TABLE=121, VARCHAR=318, FLOAT=313, VERSION=289, MICROSECONDS=215, 
		IMMUTABLE=64, ASYMMETRIC=9, SUM=268, N_DISTINCT_INHERITED=227, UnterminatedQuotedIdentifier=374, 
		OWNED=94, EndDollarStringConstant=382, Space=378, INOUT=73, STORAGE=264, 
		TIME=322, AS=4, RIGHT_PAREN=353, THEN=124, MAXVALUE=214, COLLATION=18, 
		LEFT=80, REPLACE=105, AVG=145, ZONE=295, TRUNCATE=129, COLUMN=157, TRUSTED=126, 
		PLUS=354, EXISTS=182, HEADER=60, NVARCHAR=320, Not_Similar_To=337, RETURNS=107, 
		LIKE=81, COLLATE=17, ADD=1, INTEGER=307, OUTER=89, BY=147, DEFERRABLE=29, 
		TO=277, INHERIT=194, SET=257, RIGHT=109, HAVING=58, MIN=218, SESSION=115, 
		MINUS=355, TEXT=326, HOUR=193, QuotedIdentifier=373, FORCE_QUOTE=49, CONCATENATION_OPERATOR=346, 
		CONVERSION=22, UNION=130, CURRENT=166, COLON=343, COMMIT=160, SCHEMA=111, 
		DATABASE=26, DECIMAL=316, DROP=177, BIGINT=308, WHEN=138, VALIDATE=284, 
		CONCURRENTLY=161, ROWS=103, START=261, BIT=298, LARGE=206, REVOKE=108, 
		NATURAL=84, FORMAT=189, PUBLIC=241, AGGREGATE=2, EXTENSION=45, BETWEEN=146, 
		OPTIONS=232, DELIMITER=32, FIRST=188, CAST=16, WEEK=291, EXTERNAL=184, 
		DOUBLE_QUOTE=363, VARYING=288, RESET=249, REGCONFIG=245, TRIGGER=127, 
		CASE=14, CHAR=317, INT8=303, ENCODING=39, COUNT=164, DAY=169, FORCE_NOT_NULL=50, 
		CASCADE=15, COST=163, INT2=301, INT1=300, Identifier=372, INT4=302, ISCACHABLE=201, 
		EXTENDED=183, QUOTE=362, MODULAR=358, INVOKER=75, FULL=51, DICTIONARY=173, 
		THAN=272, QUARTER=243, INSERT=199, ESCAPE=40, INHERITS=67, CONNECT=19, 
		ALWAYS=143, INTERSECTION=200, LESS=208, TINYINT=304, BOTH=13, Similar_To_Case_Insensitive=338, 
		DOUBLE=314, ADMIN=142, SYMMETRIC=120, VOID=335, ISSTRICT=204, EACH=36, 
		LAST=207, COMMENT=158, SELECT=114, INTO=72, ARRAY=144, UNIQUE=131, COALESCE=156, 
		SECOND=254, ROLE=101, RULE=110, VIEW=137, EPOCH=179, ROLLUP=252, NULL=86, 
		WITHOUT=141, NO=223, STDIN=263, EVERY=181, ON=229, RESTART=250, MATCH=212, 
		PRIMARY=97, DELETE=31, INET4=332, NUMERIC=315, LOCAL=83, LIST=209, OF=87, 
		EXCLUDING=43, TABLES=270, UNDERLINE=360, SEQUENCE=112, Not_Similar_To_Case_Insensitive=339, 
		CUBE=165, NATIONAL=222, CALLED=149, STATISTICS=262, VAR_POP=287, OR=92, 
		FILTER=187, CHECK=153, INLINE=69, FROM=54, FALSE=46, COLLECT=155, BeginDollarStringConstant=377, 
		PARSER=235, DISTINCT=34, TEMPORARY=123, TIMESTAMP=324, SIMPLE=259, DOLLAR=364, 
		OVER=233, CONSTRAINTS=21, WHERE=139, DEC=170, VAR_SAMP=286, NULLIF=225, 
		MAIN=211, CLASS=150, Text_between_Dollar=381, TIMETZ=323, INNER=70, BIT_AND=367, 
		YEAR=294, TIMEZONE=273, ORDER=93, AUTHORIZATION=11, LIMIT=82, DECADE=171, 
		GTH=350, CYCLE=167, White_Space=379, MAX=213, UPDATE=132, LineComment=371, 
		DEFERRED=30, FOR=47, FLOAT4=309, CONFIGURATION=162, FLOAT8=310, AND=7, 
		CROSS=25, Similar_To=336, INTERVAL=334, USAGE=133, IF=61, INDEX=195, OIDS=88, 
		BOOLEAN=296, IN=65, MINVALUE=219, UNKNOWN=280, MULTIPLY=356, OBJECT=228, 
		COMMA=345, REFERENCES=104, PARTITION=237, IS=76, PARTITIONS=238, COPY=23, 
		SOME=117, EQUAL=342, ALL=5, DOT=359, EXTRACT=185, CENTURY=151, STABLE=260, 
		SECURITY=255, PARTIAL=236, DOW=175, EXCLUDE=42, WITH=140, INITIALLY=68, 
		DOY=176, FUSION=190, GRANT=56, VARBINARY=329, VOLATILE=290, OPERATOR=91, 
		DEFAULT=27, VALUES=285, HASH=192, RANGE=244, MILLENNIUM=216, INDEXES=196, 
		PURGE=242, BEFORE=12, AFTER=3, INSTEAD=74, EVENT=180, WRAPPER=293, TRUE=128, 
		JOIN=77, PROCEDURE=99, SIMILAR=258, DOMAIN=35, DEFAULTS=28, LTH=348, INCREMENT=197, 
		ANY=8, INET=333, TEMPLATE=271, BAD=380, ASSIGN=341, REGCLASS=312, IMMEDIATE=63, 
		CLUSTER=154, WINDOW=292, BINARY=328, DESC=33, DATE=321, MINUTE=220, GLOBAL=55, 
		DATA=168, INCLUDING=66, LEQ=349, SMALLINT=305;
	public static final String[] tokenNames = {
		"<INVALID>", "ADD", "AGGREGATE", "AFTER", "AS", "ALL", "ALTER", "AND", 
		"ANY", "ASYMMETRIC", "ASC", "AUTHORIZATION", "BEFORE", "BOTH", "CASE", 
		"CASCADE", "CAST", "COLLATE", "COLLATION", "CONNECT", "CONSTRAINT", "CONSTRAINTS", 
		"CONVERSION", "COPY", "CREATE", "CROSS", "DATABASE", "DEFAULT", "DEFAULTS", 
		"DEFERRABLE", "DEFERRED", "DELETE", "DELIMITER", "DESC", "DISTINCT", "DOMAIN", 
		"EACH", "ELSE", "END", "ENCODING", "ESCAPE", "EXCEPT", "EXCLUDE", "EXCLUDING", 
		"EXECUTE", "EXTENSION", "FALSE", "FOR", "FOREIGN", "FORCE_QUOTE", "FORCE_NOT_NULL", 
		"FULL", "FUNCTION", "FUNCTIONS", "FROM", "GLOBAL", "GRANT", "GROUP", "HAVING", 
		"HANDLER", "HEADER", "IF", "ILIKE", "IMMEDIATE", "IMMUTABLE", "IN", "INCLUDING", 
		"INHERITS", "INITIALLY", "INLINE", "INNER", "INTERSECT", "INTO", "INOUT", 
		"INSTEAD", "INVOKER", "IS", "JOIN", "KEY", "LEADING", "LEFT", "LIKE", 
		"LIMIT", "LOCAL", "NATURAL", "NOT", "NULL", "OF", "OIDS", "OUTER", "OUT", 
		"OPERATOR", "OR", "ORDER", "OWNED", "OWNER", "PRESERVE", "PRIMARY", "PRIVILEGES", 
		"PROCEDURE", "PROCEDURAL", "ROLE", "ROW", "ROWS", "REFERENCES", "REPLACE", 
		"RESTRICT", "RETURNS", "REVOKE", "RIGHT", "RULE", "SCHEMA", "SEQUENCE", 
		"SEQUENCES", "SELECT", "SESSION", "SETOF", "SOME", "STATEMENT", "STRICT", 
		"SYMMETRIC", "TABLE", "TEMP", "TEMPORARY", "THEN", "TRAILING", "TRUSTED", 
		"TRIGGER", "TRUE", "TRUNCATE", "UNION", "UNIQUE", "UPDATE", "USAGE", "USING", 
		"VALIDATOR", "VARIADIC", "VIEW", "WHEN", "WHERE", "WITH", "WITHOUT", "ADMIN", 
		"ALWAYS", "ARRAY", "AVG", "BETWEEN", "BY", "CACHE", "CALLED", "CLASS", 
		"CENTURY", "CHARACTER", "CHECK", "CLUSTER", "COLLECT", "COALESCE", "COLUMN", 
		"COMMENT", "COMMENTS", "COMMIT", "CONCURRENTLY", "CONFIGURATION", "COST", 
		"COUNT", "CUBE", "CURRENT", "CYCLE", "DATA", "DAY", "DEC", "DECADE", "DEFINER", 
		"DICTIONARY", "DISABLE", "DOW", "DOY", "DROP", "ENABLE", "EPOCH", "EVENT", 
		"EVERY", "EXISTS", "EXTENDED", "EXTERNAL", "EXTRACT", "FAMILY", "FILTER", 
		"FIRST", "FORMAT", "FUSION", "GROUPING", "HASH", "HOUR", "INHERIT", "INDEX", 
		"INDEXES", "INCREMENT", "INPUT", "INSERT", "INTERSECTION", "ISCACHABLE", 
		"ISODOW", "ISOYEAR", "ISSTRICT", "LANGUAGE", "LARGE", "LAST", "LESS", 
		"LIST", "LOCATION", "MAIN", "MATCH", "MAX", "MAXVALUE", "MICROSECONDS", 
		"MILLENNIUM", "MILLISECONDS", "MIN", "MINVALUE", "MINUTE", "MONTH", "NATIONAL", 
		"NO", "NONE", "NULLIF", "N_DISTINCT", "N_DISTINCT_INHERITED", "OBJECT", 
		"ON", "ONLY", "OPTION", "OPTIONS", "OVER", "OVERWRITE", "PARSER", "PARTIAL", 
		"PARTITION", "PARTITIONS", "PLAIN", "PRECISION", "PUBLIC", "PURGE", "QUARTER", 
		"RANGE", "REGCONFIG", "REGEXP", "RENAME", "REPLICA", "RESET", "RESTART", 
		"RLIKE", "ROLLUP", "SEARCH", "SECOND", "SECURITY", "SERVER", "SET", "SIMILAR", 
		"SIMPLE", "STABLE", "START", "STATISTICS", "STDIN", "STORAGE", "STDDEV_POP", 
		"STDDEV_SAMP", "SUBPARTITION", "SUM", "TABLESPACE", "TABLES", "TEMPLATE", 
		"THAN", "TIMEZONE", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", "TRIM", "TO", 
		"TYPE", "TYPES", "UNKNOWN", "UNLOGGED", "USER", "VALID", "VALIDATE", "VALUES", 
		"VAR_SAMP", "VAR_POP", "VARYING", "VERSION", "VOLATILE", "WEEK", "WINDOW", 
		"WRAPPER", "YEAR", "ZONE", "BOOLEAN", "BOOL", "BIT", "VARBIT", "INT1", 
		"INT2", "INT4", "INT8", "TINYINT", "SMALLINT", "INT", "INTEGER", "BIGINT", 
		"FLOAT4", "FLOAT8", "REAL", "REGCLASS", "FLOAT", "DOUBLE", "NUMERIC", 
		"DECIMAL", "CHAR", "VARCHAR", "NCHAR", "NVARCHAR", "DATE", "TIME", "TIMETZ", 
		"TIMESTAMP", "TIMESTAMPTZ", "TEXT", "UUID", "BINARY", "VARBINARY", "BLOB", 
		"BYTEA", "INET4", "INET", "INTERVAL", "VOID", "'~'", "'!~'", "'~*'", "'!~*'", 
		"CAST_EXPRESSION", "':='", "'='", "':'", "';'", "','", "CONCATENATION_OPERATOR", 
		"NOT_EQUAL", "'<'", "'<='", "'>'", "'>='", "'('", "')'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'.'", "'_'", "'|'", "'''", "'\"'", "'$'", "'['", 
		"']'", "'&'", "NUMBER", "REAL_NUMBER", "BlockComment", "LineComment", 
		"Identifier", "QuotedIdentifier", "UnterminatedQuotedIdentifier", "Character_String_Literal", 
		"ESC_SEQUENCES", "BeginDollarStringConstant", "' '", "White_Space", "BAD", 
		"Text_between_Dollar", "EndDollarStringConstant"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_data_statement = 2, RULE_copy_statement = 3, 
		RULE_copy_option = 4, RULE_schema_statement = 5, RULE_schema_create = 6, 
		RULE_schema_alter = 7, RULE_alter_function_statement = 8, RULE_alter_schema_statement = 9, 
		RULE_alter_language_statement = 10, RULE_alter_table_statement = 11, RULE_table_action = 12, 
		RULE_attribute_option_value = 13, RULE_table_constraint_using_index = 14, 
		RULE_table_attribute_option = 15, RULE_function_action = 16, RULE_alter_default_privileges = 17, 
		RULE_abbreviated_grant_or_revoke = 18, RULE_alter_sequence_statement = 19, 
		RULE_alter_view_statement = 20, RULE_index_statement = 21, RULE_create_extension_statement = 22, 
		RULE_create_language_statement = 23, RULE_create_event_trigger = 24, RULE_set_statement = 25, 
		RULE_set_statement_value = 26, RULE_create_trigger_statement = 27, RULE_revoke_statement = 28, 
		RULE_revoke_from_cascade_restrict = 29, RULE_grant_statement = 30, RULE_grant_to_rule = 31, 
		RULE_comment_on_statement = 32, RULE_create_function_statement = 33, RULE_function_column_name_type = 34, 
		RULE_function_parameters = 35, RULE_function_def_value = 36, RULE_function_body = 37, 
		RULE_function_arguments = 38, RULE_function_attribute = 39, RULE_argmode = 40, 
		RULE_function_definition = 41, RULE_function_definition_name_paren = 42, 
		RULE_functions_definition_schema = 43, RULE_create_sequence_statement = 44, 
		RULE_sequence_body = 45, RULE_create_schema_statement = 46, RULE_create_view_statement = 47, 
		RULE_create_table_statement = 48, RULE_table_body = 49, RULE_table_column_definition = 50, 
		RULE_like_option = 51, RULE_table_constraint = 52, RULE_column_constraint = 53, 
		RULE_check_boolean_expression = 54, RULE_storage_parameter = 55, RULE_with_storage_parameter = 56, 
		RULE_storage_parameter_oid = 57, RULE_on_commit = 58, RULE_table_space = 59, 
		RULE_action = 60, RULE_index_parameters = 61, RULE_table_elements = 62, 
		RULE_field_element = 63, RULE_field_type = 64, RULE_param_clause = 65, 
		RULE_param = 66, RULE_partition_by_columns = 67, RULE_drop_table_statement = 68, 
		RULE_identifier = 69, RULE_nonreserved_keywords = 70, RULE_unsigned_literal = 71, 
		RULE_general_literal = 72, RULE_datetime_literal = 73, RULE_time_literal = 74, 
		RULE_timestamp_literal = 75, RULE_date_literal = 76, RULE_data_type = 77, 
		RULE_predefined_type = 78, RULE_network_type = 79, RULE_character_string_type = 80, 
		RULE_type_length = 81, RULE_national_character_string_type = 82, RULE_binary_large_object_string_type = 83, 
		RULE_numeric_type = 84, RULE_exact_numeric_type = 85, RULE_approximate_numeric_type = 86, 
		RULE_precision_param = 87, RULE_boolean_type = 88, RULE_datetime_type = 89, 
		RULE_bit_type = 90, RULE_binary_type = 91, RULE_value_expression_primary = 92, 
		RULE_parenthesized_value_expression = 93, RULE_nonparenthesized_value_expression_primary = 94, 
		RULE_unsigned_value_specification = 95, RULE_unsigned_numeric_literal = 96, 
		RULE_signed_numerical_literal = 97, RULE_set_function_specification = 98, 
		RULE_aggregate_function = 99, RULE_general_set_function = 100, RULE_set_function_type = 101, 
		RULE_filter_clause = 102, RULE_grouping_operation = 103, RULE_case_expression = 104, 
		RULE_case_abbreviation = 105, RULE_case_specification = 106, RULE_simple_case = 107, 
		RULE_searched_case = 108, RULE_simple_when_clause = 109, RULE_searched_when_clause = 110, 
		RULE_else_clause = 111, RULE_result = 112, RULE_cast_specification = 113, 
		RULE_cast_operand = 114, RULE_cast_target = 115, RULE_value_expression = 116, 
		RULE_array_expression = 117, RULE_all_array = 118, RULE_bit_operation = 119, 
		RULE_common_value_expression = 120, RULE_numeric_value_expression = 121, 
		RULE_term = 122, RULE_factor = 123, RULE_array = 124, RULE_numeric_primary = 125, 
		RULE_value_expression_primary_cast = 126, RULE_sign = 127, RULE_numeric_value_function = 128, 
		RULE_extract_expression = 129, RULE_extract_field = 130, RULE_time_zone_field = 131, 
		RULE_extract_source = 132, RULE_string_value_expression = 133, RULE_character_value_expression = 134, 
		RULE_character_factor = 135, RULE_character_primary = 136, RULE_string_value_function = 137, 
		RULE_trim_function = 138, RULE_trim_operands = 139, RULE_trim_specification = 140, 
		RULE_boolean_value_expression = 141, RULE_or_predicate = 142, RULE_and_predicate = 143, 
		RULE_boolean_factor = 144, RULE_boolean_test = 145, RULE_is_clause = 146, 
		RULE_truth_value = 147, RULE_boolean_primary = 148, RULE_boolean_predicand = 149, 
		RULE_parenthesized_boolean_value_expression = 150, RULE_row_value_expression = 151, 
		RULE_row_value_special_case = 152, RULE_explicit_row_value_constructor = 153, 
		RULE_row_value_predicand = 154, RULE_row_value_constructor_predicand = 155, 
		RULE_table_expression = 156, RULE_from_clause = 157, RULE_table_reference_list = 158, 
		RULE_table_reference = 159, RULE_joined_table = 160, RULE_joined_table_primary = 161, 
		RULE_cross_join = 162, RULE_qualified_join = 163, RULE_natural_join = 164, 
		RULE_union_join = 165, RULE_join_type = 166, RULE_outer_join_type = 167, 
		RULE_outer_join_type_part2 = 168, RULE_join_specification = 169, RULE_join_condition = 170, 
		RULE_named_columns_join = 171, RULE_table_primary = 172, RULE_column_name_list = 173, 
		RULE_alias_def = 174, RULE_alias_table = 175, RULE_derived_table = 176, 
		RULE_where_clause = 177, RULE_search_condition = 178, RULE_groupby_clause = 179, 
		RULE_grouping_element_list = 180, RULE_grouping_element = 181, RULE_ordinary_grouping_set = 182, 
		RULE_ordinary_grouping_set_list = 183, RULE_rollup_list = 184, RULE_cube_list = 185, 
		RULE_empty_grouping_set = 186, RULE_having_clause = 187, RULE_row_value_predicand_list = 188, 
		RULE_query_expression = 189, RULE_query_expression_body = 190, RULE_non_join_query_expression = 191, 
		RULE_query_term = 192, RULE_non_join_query_term = 193, RULE_query_primary = 194, 
		RULE_non_join_query_primary = 195, RULE_simple_table = 196, RULE_explicit_table = 197, 
		RULE_table_or_query_name = 198, RULE_schema_qualified_name = 199, RULE_query_specification = 200, 
		RULE_select_list = 201, RULE_select_sublist = 202, RULE_derived_column = 203, 
		RULE_qualified_asterisk = 204, RULE_set_qualifier = 205, RULE_column_reference = 206, 
		RULE_as_clause = 207, RULE_over_clause = 208, RULE_column_reference_list = 209, 
		RULE_scalar_subquery = 210, RULE_row_subquery = 211, RULE_table_subquery = 212, 
		RULE_subquery = 213, RULE_predicate = 214, RULE_comparison_predicate = 215, 
		RULE_comp_op = 216, RULE_between_predicate = 217, RULE_between_predicate_part_2 = 218, 
		RULE_in_predicate = 219, RULE_in_predicate_value = 220, RULE_in_value_list = 221, 
		RULE_pattern_matching_predicate = 222, RULE_pattern_matcher = 223, RULE_negativable_matcher = 224, 
		RULE_regex_matcher = 225, RULE_null_predicate = 226, RULE_quantified_comparison_predicate = 227, 
		RULE_quantifier = 228, RULE_all = 229, RULE_some = 230, RULE_exists_predicate = 231, 
		RULE_unique_predicate = 232, RULE_primary_datetime_field = 233, RULE_non_second_primary_datetime_field = 234, 
		RULE_extended_datetime_field = 235, RULE_orderby_clause = 236, RULE_sort_specifier_paren = 237, 
		RULE_sort_specifier_list = 238, RULE_sort_specifier = 239, RULE_order_specification = 240, 
		RULE_limit_clause = 241, RULE_null_ordering = 242;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "copy_statement", "copy_option", 
		"schema_statement", "schema_create", "schema_alter", "alter_function_statement", 
		"alter_schema_statement", "alter_language_statement", "alter_table_statement", 
		"table_action", "attribute_option_value", "table_constraint_using_index", 
		"table_attribute_option", "function_action", "alter_default_privileges", 
		"abbreviated_grant_or_revoke", "alter_sequence_statement", "alter_view_statement", 
		"index_statement", "create_extension_statement", "create_language_statement", 
		"create_event_trigger", "set_statement", "set_statement_value", "create_trigger_statement", 
		"revoke_statement", "revoke_from_cascade_restrict", "grant_statement", 
		"grant_to_rule", "comment_on_statement", "create_function_statement", 
		"function_column_name_type", "function_parameters", "function_def_value", 
		"function_body", "function_arguments", "function_attribute", "argmode", 
		"function_definition", "function_definition_name_paren", "functions_definition_schema", 
		"create_sequence_statement", "sequence_body", "create_schema_statement", 
		"create_view_statement", "create_table_statement", "table_body", "table_column_definition", 
		"like_option", "table_constraint", "column_constraint", "check_boolean_expression", 
		"storage_parameter", "with_storage_parameter", "storage_parameter_oid", 
		"on_commit", "table_space", "action", "index_parameters", "table_elements", 
		"field_element", "field_type", "param_clause", "param", "partition_by_columns", 
		"drop_table_statement", "identifier", "nonreserved_keywords", "unsigned_literal", 
		"general_literal", "datetime_literal", "time_literal", "timestamp_literal", 
		"date_literal", "data_type", "predefined_type", "network_type", "character_string_type", 
		"type_length", "national_character_string_type", "binary_large_object_string_type", 
		"numeric_type", "exact_numeric_type", "approximate_numeric_type", "precision_param", 
		"boolean_type", "datetime_type", "bit_type", "binary_type", "value_expression_primary", 
		"parenthesized_value_expression", "nonparenthesized_value_expression_primary", 
		"unsigned_value_specification", "unsigned_numeric_literal", "signed_numerical_literal", 
		"set_function_specification", "aggregate_function", "general_set_function", 
		"set_function_type", "filter_clause", "grouping_operation", "case_expression", 
		"case_abbreviation", "case_specification", "simple_case", "searched_case", 
		"simple_when_clause", "searched_when_clause", "else_clause", "result", 
		"cast_specification", "cast_operand", "cast_target", "value_expression", 
		"array_expression", "all_array", "bit_operation", "common_value_expression", 
		"numeric_value_expression", "term", "factor", "array", "numeric_primary", 
		"value_expression_primary_cast", "sign", "numeric_value_function", "extract_expression", 
		"extract_field", "time_zone_field", "extract_source", "string_value_expression", 
		"character_value_expression", "character_factor", "character_primary", 
		"string_value_function", "trim_function", "trim_operands", "trim_specification", 
		"boolean_value_expression", "or_predicate", "and_predicate", "boolean_factor", 
		"boolean_test", "is_clause", "truth_value", "boolean_primary", "boolean_predicand", 
		"parenthesized_boolean_value_expression", "row_value_expression", "row_value_special_case", 
		"explicit_row_value_constructor", "row_value_predicand", "row_value_constructor_predicand", 
		"table_expression", "from_clause", "table_reference_list", "table_reference", 
		"joined_table", "joined_table_primary", "cross_join", "qualified_join", 
		"natural_join", "union_join", "join_type", "outer_join_type", "outer_join_type_part2", 
		"join_specification", "join_condition", "named_columns_join", "table_primary", 
		"column_name_list", "alias_def", "alias_table", "derived_table", "where_clause", 
		"search_condition", "groupby_clause", "grouping_element_list", "grouping_element", 
		"ordinary_grouping_set", "ordinary_grouping_set_list", "rollup_list", 
		"cube_list", "empty_grouping_set", "having_clause", "row_value_predicand_list", 
		"query_expression", "query_expression_body", "non_join_query_expression", 
		"query_term", "non_join_query_term", "query_primary", "non_join_query_primary", 
		"simple_table", "explicit_table", "table_or_query_name", "schema_qualified_name", 
		"query_specification", "select_list", "select_sublist", "derived_column", 
		"qualified_asterisk", "set_qualifier", "column_reference", "as_clause", 
		"over_clause", "column_reference_list", "scalar_subquery", "row_subquery", 
		"table_subquery", "subquery", "predicate", "comparison_predicate", "comp_op", 
		"between_predicate", "between_predicate_part_2", "in_predicate", "in_predicate_value", 
		"in_value_list", "pattern_matching_predicate", "pattern_matcher", "negativable_matcher", 
		"regex_matcher", "null_predicate", "quantified_comparison_predicate", 
		"quantifier", "all", "some", "exists_predicate", "unique_predicate", "primary_datetime_field", 
		"non_second_primary_datetime_field", "extended_datetime_field", "orderby_clause", 
		"sort_specifier_paren", "sort_specifier_list", "sort_specifier", "order_specification", 
		"limit_clause", "null_ordering"
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
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALTER) | (1L << COPY) | (1L << CREATE) | (1L << GRANT))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (REVOKE - 105)) | (1L << (SELECT - 105)) | (1L << (TABLE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)) | (1L << (LEFT_PAREN - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0)) {
				{
				{
				setState(486); statement();
				setState(487); match(SEMI_COLON);
				}
				}
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(494); match(EOF);
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
		public Data_statementContext data_statement() {
			return getRuleContext(Data_statementContext.class,0);
		}
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
			setState(498);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(496); data_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(497); schema_statement();
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

	public static class Data_statementContext extends ParserRuleContext {
		public Copy_statementContext copy_statement() {
			return getRuleContext(Copy_statementContext.class,0);
		}
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
			setState(502);
			switch (_input.LA(1)) {
			case REPLACE:
			case SELECT:
			case TABLE:
			case ADMIN:
			case ALWAYS:
			case ARRAY:
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
			case CONCURRENTLY:
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
			case EVENT:
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
			case OVER:
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
			case REGCONFIG:
			case REGEXP:
			case RENAME:
			case REPLICA:
			case RESET:
			case RESTART:
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
			case STDIN:
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
			case TYPES:
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
			case INET:
			case INTERVAL:
			case VOID:
			case LEFT_PAREN:
			case DOUBLE_QUOTE:
			case Identifier:
			case QuotedIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(500); query_expression();
				}
				break;
			case COPY:
				enterOuterAlt(_localctx, 2);
				{
				setState(501); copy_statement();
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

	public static class Copy_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext table_name;
		public Schema_qualified_nameContext column_name;
		public Query_specificationContext query;
		public IdentifierContext filename;
		public Copy_optionContext option;
		public TerminalNode COPY() { return getToken(SQLParser.COPY, 0); }
		public Copy_optionContext copy_option(int i) {
			return getRuleContext(Copy_optionContext.class,i);
		}
		public List<Copy_optionContext> copy_option() {
			return getRuleContexts(Copy_optionContext.class);
		}
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode STDIN() { return getToken(SQLParser.STDIN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public Query_specificationContext query_specification() {
			return getRuleContext(Query_specificationContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Copy_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_copy_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCopy_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCopy_statement(this);
		}
	}

	public final Copy_statementContext copy_statement() throws RecognitionException {
		Copy_statementContext _localctx = new Copy_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_copy_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504); match(COPY);
			setState(520);
			switch (_input.LA(1)) {
			case REPLACE:
			case ADMIN:
			case ALWAYS:
			case ARRAY:
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
			case CONCURRENTLY:
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
			case EVENT:
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
			case OVER:
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
			case REGCONFIG:
			case REGEXP:
			case RENAME:
			case REPLICA:
			case RESET:
			case RESTART:
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
			case STDIN:
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
			case TYPES:
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
			case INET:
			case INTERVAL:
			case VOID:
			case DOUBLE_QUOTE:
			case Identifier:
			case QuotedIdentifier:
				{
				setState(505); ((Copy_statementContext)_localctx).table_name = schema_qualified_name();
				setState(517);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(506); match(LEFT_PAREN);
					setState(507); ((Copy_statementContext)_localctx).column_name = schema_qualified_name();
					setState(512);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(508); match(COMMA);
						setState(509); ((Copy_statementContext)_localctx).column_name = schema_qualified_name();
						}
						}
						setState(514);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(515); match(RIGHT_PAREN);
					}
				}

				}
				break;
			case SELECT:
				{
				{
				setState(519); ((Copy_statementContext)_localctx).query = query_specification();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(522);
			_la = _input.LA(1);
			if ( !(_la==FROM || _la==TO) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(525);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(523); ((Copy_statementContext)_localctx).filename = identifier();
				}
				break;
			case 2:
				{
				setState(524); match(STDIN);
				}
				break;
			}
			setState(541);
			_la = _input.LA(1);
			if (_la==WITH || _la==LEFT_PAREN) {
				{
				setState(528);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(527); match(WITH);
					}
				}

				setState(530); match(LEFT_PAREN);
				setState(531); ((Copy_statementContext)_localctx).option = copy_option();
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(532); match(COMMA);
					setState(533); ((Copy_statementContext)_localctx).option = copy_option();
					}
					}
					setState(538);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(539); match(RIGHT_PAREN);
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

	public static class Copy_optionContext extends ParserRuleContext {
		public IdentifierContext format_name;
		public Truth_valueContext boolean_val;
		public IdentifierContext delimiter_character;
		public IdentifierContext null_string;
		public IdentifierContext quote_character;
		public IdentifierContext escape_character;
		public Schema_qualified_nameContext column_name;
		public IdentifierContext encoding_name;
		public TerminalNode ESCAPE() { return getToken(SQLParser.ESCAPE, 0); }
		public TerminalNode FORMAT() { return getToken(SQLParser.FORMAT, 0); }
		public TerminalNode HEADER() { return getToken(SQLParser.HEADER, 0); }
		public TerminalNode MULTIPLY() { return getToken(SQLParser.MULTIPLY, 0); }
		public TerminalNode DELIMITER() { return getToken(SQLParser.DELIMITER, 0); }
		public TerminalNode ENCODING() { return getToken(SQLParser.ENCODING, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode FORCE_NOT_NULL() { return getToken(SQLParser.FORCE_NOT_NULL, 0); }
		public TerminalNode OIDS() { return getToken(SQLParser.OIDS, 0); }
		public TerminalNode QUOTE() { return getToken(SQLParser.QUOTE, 0); }
		public Truth_valueContext truth_value() {
			return getRuleContext(Truth_valueContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public TerminalNode FORCE_QUOTE() { return getToken(SQLParser.FORCE_QUOTE, 0); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Copy_optionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_copy_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCopy_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCopy_option(this);
		}
	}

	public final Copy_optionContext copy_option() throws RecognitionException {
		Copy_optionContext _localctx = new Copy_optionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_copy_option);
		int _la;
		try {
			setState(590);
			switch (_input.LA(1)) {
			case FORMAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(543); match(FORMAT);
				setState(544); ((Copy_optionContext)_localctx).format_name = identifier();
				}
				break;
			case OIDS:
				enterOuterAlt(_localctx, 2);
				{
				setState(545); match(OIDS);
				setState(547);
				_la = _input.LA(1);
				if (_la==FALSE || _la==TRUE || _la==UNKNOWN) {
					{
					setState(546); ((Copy_optionContext)_localctx).boolean_val = truth_value();
					}
				}

				}
				break;
			case DELIMITER:
				enterOuterAlt(_localctx, 3);
				{
				setState(549); match(DELIMITER);
				setState(550); ((Copy_optionContext)_localctx).delimiter_character = identifier();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(551); match(NULL);
				setState(552); ((Copy_optionContext)_localctx).null_string = identifier();
				}
				break;
			case HEADER:
				enterOuterAlt(_localctx, 5);
				{
				setState(553); match(HEADER);
				setState(555);
				_la = _input.LA(1);
				if (_la==FALSE || _la==TRUE || _la==UNKNOWN) {
					{
					setState(554); ((Copy_optionContext)_localctx).boolean_val = truth_value();
					}
				}

				}
				break;
			case QUOTE:
				enterOuterAlt(_localctx, 6);
				{
				setState(557); match(QUOTE);
				setState(558); ((Copy_optionContext)_localctx).quote_character = identifier();
				}
				break;
			case ESCAPE:
				enterOuterAlt(_localctx, 7);
				{
				setState(559); match(ESCAPE);
				setState(560); ((Copy_optionContext)_localctx).escape_character = identifier();
				}
				break;
			case FORCE_QUOTE:
				enterOuterAlt(_localctx, 8);
				{
				setState(561); match(FORCE_QUOTE);
				setState(574);
				switch (_input.LA(1)) {
				case LEFT_PAREN:
					{
					{
					setState(562); match(LEFT_PAREN);
					setState(563); ((Copy_optionContext)_localctx).column_name = schema_qualified_name();
					setState(568);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(564); match(COMMA);
						setState(565); ((Copy_optionContext)_localctx).column_name = schema_qualified_name();
						}
						}
						setState(570);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(571); match(RIGHT_PAREN);
					}
					}
					break;
				case MULTIPLY:
					{
					setState(573); match(MULTIPLY);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case FORCE_NOT_NULL:
				enterOuterAlt(_localctx, 9);
				{
				setState(576); match(FORCE_NOT_NULL);
				setState(577); match(LEFT_PAREN);
				setState(578); ((Copy_optionContext)_localctx).column_name = schema_qualified_name();
				setState(583);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(579); match(COMMA);
					setState(580); ((Copy_optionContext)_localctx).column_name = schema_qualified_name();
					}
					}
					setState(585);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(586); match(RIGHT_PAREN);
				}
				break;
			case ENCODING:
				enterOuterAlt(_localctx, 10);
				{
				setState(588); match(ENCODING);
				setState(589); ((Copy_optionContext)_localctx).encoding_name = identifier();
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
		enterRule(_localctx, 10, RULE_schema_statement);
		try {
			setState(595);
			switch (_input.LA(1)) {
			case CREATE:
			case GRANT:
			case REVOKE:
			case COMMENT:
			case SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(592); schema_create();
				}
				break;
			case ALTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(593); schema_alter();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 3);
				{
				setState(594); drop_table_statement();
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
		public Create_sequence_statementContext create_sequence_statement() {
			return getRuleContext(Create_sequence_statementContext.class,0);
		}
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public Index_statementContext index_statement() {
			return getRuleContext(Index_statementContext.class,0);
		}
		public Create_language_statementContext create_language_statement() {
			return getRuleContext(Create_language_statementContext.class,0);
		}
		public Create_extension_statementContext create_extension_statement() {
			return getRuleContext(Create_extension_statementContext.class,0);
		}
		public Revoke_statementContext revoke_statement() {
			return getRuleContext(Revoke_statementContext.class,0);
		}
		public Create_event_triggerContext create_event_trigger() {
			return getRuleContext(Create_event_triggerContext.class,0);
		}
		public Create_view_statementContext create_view_statement() {
			return getRuleContext(Create_view_statementContext.class,0);
		}
		public Create_table_statementContext create_table_statement() {
			return getRuleContext(Create_table_statementContext.class,0);
		}
		public Create_function_statementContext create_function_statement() {
			return getRuleContext(Create_function_statementContext.class,0);
		}
		public Set_statementContext set_statement() {
			return getRuleContext(Set_statementContext.class,0);
		}
		public Comment_on_statementContext comment_on_statement() {
			return getRuleContext(Comment_on_statementContext.class,0);
		}
		public Grant_statementContext grant_statement() {
			return getRuleContext(Grant_statementContext.class,0);
		}
		public Create_trigger_statementContext create_trigger_statement() {
			return getRuleContext(Create_trigger_statementContext.class,0);
		}
		public Create_schema_statementContext create_schema_statement() {
			return getRuleContext(Create_schema_statementContext.class,0);
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
		enterRule(_localctx, 12, RULE_schema_create);
		try {
			setState(614);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(597); match(CREATE);
				setState(608);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(598); create_table_statement();
					}
					break;
				case 2:
					{
					setState(599); index_statement();
					}
					break;
				case 3:
					{
					setState(600); create_extension_statement();
					}
					break;
				case 4:
					{
					setState(601); create_trigger_statement();
					}
					break;
				case 5:
					{
					setState(602); create_function_statement();
					}
					break;
				case 6:
					{
					setState(603); create_sequence_statement();
					}
					break;
				case 7:
					{
					setState(604); create_schema_statement();
					}
					break;
				case 8:
					{
					setState(605); create_view_statement();
					}
					break;
				case 9:
					{
					setState(606); create_language_statement();
					}
					break;
				case 10:
					{
					setState(607); create_event_trigger();
					}
					break;
				}
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(610); comment_on_statement();
				}
				break;
			case REVOKE:
				enterOuterAlt(_localctx, 3);
				{
				setState(611); revoke_statement();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 4);
				{
				setState(612); set_statement();
				}
				break;
			case GRANT:
				enterOuterAlt(_localctx, 5);
				{
				setState(613); grant_statement();
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

	public static class Schema_alterContext extends ParserRuleContext {
		public Alter_function_statementContext alter_function_statement() {
			return getRuleContext(Alter_function_statementContext.class,0);
		}
		public Alter_schema_statementContext alter_schema_statement() {
			return getRuleContext(Alter_schema_statementContext.class,0);
		}
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public Alter_table_statementContext alter_table_statement() {
			return getRuleContext(Alter_table_statementContext.class,0);
		}
		public Alter_sequence_statementContext alter_sequence_statement() {
			return getRuleContext(Alter_sequence_statementContext.class,0);
		}
		public Alter_language_statementContext alter_language_statement() {
			return getRuleContext(Alter_language_statementContext.class,0);
		}
		public Alter_view_statementContext alter_view_statement() {
			return getRuleContext(Alter_view_statementContext.class,0);
		}
		public Alter_default_privilegesContext alter_default_privileges() {
			return getRuleContext(Alter_default_privilegesContext.class,0);
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
		enterRule(_localctx, 14, RULE_schema_alter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616); match(ALTER);
			setState(624);
			switch (_input.LA(1)) {
			case FUNCTION:
				{
				setState(617); alter_function_statement();
				}
				break;
			case SCHEMA:
				{
				setState(618); alter_schema_statement();
				}
				break;
			case PROCEDURAL:
			case LANGUAGE:
				{
				setState(619); alter_language_statement();
				}
				break;
			case ALTER:
			case TABLE:
				{
				setState(620); alter_table_statement();
				}
				break;
			case DEFAULT:
				{
				setState(621); alter_default_privileges();
				}
				break;
			case SEQUENCE:
				{
				setState(622); alter_sequence_statement();
				}
				break;
			case VIEW:
				{
				setState(623); alter_view_statement();
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

	public static class Alter_function_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext new_name;
		public IdentifierContext new_owner;
		public Schema_qualified_nameContext new_schema;
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public Function_actionContext function_action(int i) {
			return getRuleContext(Function_actionContext.class,i);
		}
		public List<Function_actionContext> function_action() {
			return getRuleContexts(Function_actionContext.class);
		}
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public TerminalNode RESTRICT() { return getToken(SQLParser.RESTRICT, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public TerminalNode OWNER() { return getToken(SQLParser.OWNER, 0); }
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
		enterRule(_localctx, 16, RULE_alter_function_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626); match(FUNCTION);
			setState(627); function_parameters();
			setState(645);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(629); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(628); function_action();
					}
					}
					setState(631); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (ROWS - 103)) | (1L << (RETURNS - 103)) | (1L << (STRICT - 103)) | (1L << (CALLED - 103)) | (1L << (COST - 103)))) != 0) || _la==EXTERNAL || ((((_la - 249)) & ~0x3f) == 0 && ((1L << (_la - 249)) & ((1L << (RESET - 249)) | (1L << (SECURITY - 249)) | (1L << (SET - 249)) | (1L << (STABLE - 249)) | (1L << (VOLATILE - 249)))) != 0) );
				setState(634);
				_la = _input.LA(1);
				if (_la==RESTRICT) {
					{
					setState(633); match(RESTRICT);
					}
				}

				}
				break;
			case 2:
				{
				setState(636); match(RENAME);
				setState(637); match(TO);
				setState(638); ((Alter_function_statementContext)_localctx).new_name = schema_qualified_name();
				}
				break;
			case 3:
				{
				setState(639); match(OWNER);
				setState(640); match(TO);
				setState(641); ((Alter_function_statementContext)_localctx).new_owner = identifier();
				}
				break;
			case 4:
				{
				setState(642); match(SET);
				setState(643); match(SCHEMA);
				setState(644); ((Alter_function_statementContext)_localctx).new_schema = schema_qualified_name();
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

	public static class Alter_schema_statementContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext new_name;
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
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
		enterRule(_localctx, 18, RULE_alter_schema_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647); match(SCHEMA);
			setState(648); ((Alter_schema_statementContext)_localctx).name = identifier();
			setState(649);
			_la = _input.LA(1);
			if ( !(_la==OWNER || _la==RENAME) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(650); match(TO);
			setState(651); ((Alter_schema_statementContext)_localctx).new_name = identifier();
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
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LANGUAGE() { return getToken(SQLParser.LANGUAGE, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode PROCEDURAL() { return getToken(SQLParser.PROCEDURAL, 0); }
		public TerminalNode OWNER() { return getToken(SQLParser.OWNER, 0); }
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
		enterRule(_localctx, 20, RULE_alter_language_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			_la = _input.LA(1);
			if (_la==PROCEDURAL) {
				{
				setState(653); match(PROCEDURAL);
				}
			}

			setState(656); match(LANGUAGE);
			setState(657); ((Alter_language_statementContext)_localctx).name = identifier();
			setState(658);
			_la = _input.LA(1);
			if ( !(_la==OWNER || _la==RENAME) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(659); match(TO);
			setState(660); ((Alter_language_statementContext)_localctx).new_name = identifier();
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
		public Schema_qualified_nameContext schema_qualified_name;
		public List<Schema_qualified_nameContext> name = new ArrayList<Schema_qualified_nameContext>();
		public Schema_qualified_nameContext column;
		public Schema_qualified_nameContext new_column;
		public Schema_qualified_nameContext new_name;
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
		public Table_actionContext table_action(int i) {
			return getRuleContext(Table_actionContext.class,i);
		}
		public TerminalNode ONLY() { return getToken(SQLParser.ONLY, 0); }
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
		enterRule(_localctx, 22, RULE_alter_table_statement);
		int _la;
		try {
			int _alt;
			setState(700);
			switch (_input.LA(1)) {
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(662); match(TABLE);
				setState(664);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(663); match(ONLY);
					}
					break;
				}
				setState(667); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(666); ((Alter_table_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
						((Alter_table_statementContext)_localctx).name.add(((Alter_table_statementContext)_localctx).schema_qualified_name);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(669); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(687);
				switch (_input.LA(1)) {
				case ADD:
				case ALTER:
				case NOT:
				case OF:
				case OWNER:
				case CLUSTER:
				case DISABLE:
				case DROP:
				case ENABLE:
				case INHERIT:
				case NO:
				case RESET:
				case SET:
				case VALIDATE:
					{
					setState(671); table_action();
					setState(676);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						{
						setState(672); match(COMMA);
						}
						setState(673); table_action();
						}
						}
						setState(678);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case RENAME:
					{
					setState(679); match(RENAME);
					setState(681);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						setState(680); match(COLUMN);
						}
						break;
					}
					setState(683); ((Alter_table_statementContext)_localctx).column = schema_qualified_name();
					setState(684); match(TO);
					setState(685); ((Alter_table_statementContext)_localctx).new_column = schema_qualified_name();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case ALTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(689); match(ALTER);
				setState(690); match(TABLE);
				setState(691); ((Alter_table_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
				((Alter_table_statementContext)_localctx).name.add(((Alter_table_statementContext)_localctx).schema_qualified_name);
				setState(696);
				switch (_input.LA(1)) {
				case RENAME:
					{
					setState(692); match(RENAME);
					setState(693); match(TO);
					}
					break;
				case SET:
					{
					setState(694); match(SET);
					setState(695); match(SCHEMA);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(698); ((Alter_table_statementContext)_localctx).new_name = schema_qualified_name();
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

	public static class Table_actionContext extends ParserRuleContext {
		public Schema_qualified_nameContext column;
		public Data_typeContext datatype;
		public IdentifierContext collation;
		public Value_expressionContext expression;
		public Token integer;
		public Table_attribute_optionContext table_attribute_option;
		public List<Table_attribute_optionContext> attribute_option = new ArrayList<Table_attribute_optionContext>();
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
		public TerminalNode ADD() { return getToken(SQLParser.ADD, 0); }
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public List<Attribute_option_valueContext> attribute_option_value() {
			return getRuleContexts(Attribute_option_valueContext.class);
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
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode ENABLE() { return getToken(SQLParser.ENABLE, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode VALID() { return getToken(SQLParser.VALID, 0); }
		public TerminalNode OF() { return getToken(SQLParser.OF, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
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
		public Attribute_option_valueContext attribute_option_value(int i) {
			return getRuleContext(Attribute_option_valueContext.class,i);
		}
		public TerminalNode MAIN() { return getToken(SQLParser.MAIN, 0); }
		public TerminalNode OIDS() { return getToken(SQLParser.OIDS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode REPLICA() { return getToken(SQLParser.REPLICA, 0); }
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
		enterRule(_localctx, 24, RULE_table_action);
		int _la;
		try {
			setState(864);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(702); match(ADD);
				setState(704);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(703); match(COLUMN);
					}
					break;
				}
				setState(706); table_column_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(707); match(DROP);
				setState(709);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(708); match(COLUMN);
					}
					break;
				}
				setState(713);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(711); match(IF);
					setState(712); match(EXISTS);
					}
				}

				setState(715); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(717);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(716);
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
				setState(719); match(ALTER);
				setState(721);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(720); match(COLUMN);
					}
					break;
				}
				setState(723); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(726);
				_la = _input.LA(1);
				if (_la==SET) {
					{
					setState(724); match(SET);
					setState(725); match(DATA);
					}
				}

				setState(728); match(TYPE);
				setState(729); ((Table_actionContext)_localctx).datatype = data_type();
				setState(732);
				_la = _input.LA(1);
				if (_la==COLLATE) {
					{
					setState(730); match(COLLATE);
					setState(731); ((Table_actionContext)_localctx).collation = identifier();
					}
				}

				setState(736);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(734); match(USING);
					setState(735); ((Table_actionContext)_localctx).expression = value_expression();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(738); match(ALTER);
				setState(740);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(739); match(COLUMN);
					}
					break;
				}
				setState(742); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(786);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(743); match(SET);
					setState(744); match(DEFAULT);
					setState(745); ((Table_actionContext)_localctx).expression = value_expression();
					}
					break;
				case 2:
					{
					setState(746); match(DROP);
					setState(747); match(DEFAULT);
					}
					break;
				case 3:
					{
					{
					setState(748);
					_la = _input.LA(1);
					if ( !(_la==DROP || _la==SET) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(749); match(NOT);
					setState(750); match(NULL);
					}
					}
					break;
				case 4:
					{
					setState(751); match(SET);
					setState(752); match(STATISTICS);
					setState(753); ((Table_actionContext)_localctx).integer = match(NUMBER);
					}
					break;
				case 5:
					{
					setState(754); match(SET);
					setState(755); match(LEFT_PAREN);
					setState(756); attribute_option_value();
					setState(761);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(757); match(COMMA);
						setState(758); attribute_option_value();
						}
						}
						setState(763);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(764); match(RIGHT_PAREN);
					}
					break;
				case 6:
					{
					setState(766); match(RESET);
					setState(767); match(LEFT_PAREN);
					setState(768); ((Table_actionContext)_localctx).table_attribute_option = table_attribute_option();
					((Table_actionContext)_localctx).attribute_option.add(((Table_actionContext)_localctx).table_attribute_option);
					setState(773);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(769); match(COMMA);
						setState(770); ((Table_actionContext)_localctx).table_attribute_option = table_attribute_option();
						((Table_actionContext)_localctx).attribute_option.add(((Table_actionContext)_localctx).table_attribute_option);
						}
						}
						setState(775);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(776); match(RIGHT_PAREN);
					}
					break;
				case 7:
					{
					setState(784);
					switch (_input.LA(1)) {
					case SET:
						{
						setState(778); match(SET);
						setState(779); match(STORAGE);
						setState(780); match(PLAIN);
						}
						break;
					case EXTERNAL:
						{
						setState(781); match(EXTERNAL);
						}
						break;
					case EXTENDED:
						{
						setState(782); match(EXTENDED);
						}
						break;
					case MAIN:
						{
						setState(783); match(MAIN);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(788); match(ADD);
				setState(789); ((Table_actionContext)_localctx).tabl_constraint = table_constraint();
				setState(792);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(790); match(NOT);
					setState(791); match(VALID);
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(794); match(ADD);
				setState(795); ((Table_actionContext)_localctx).tabl_constraint_using_index = table_constraint_using_index();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(796); match(VALIDATE);
				setState(797); match(CONSTRAINT);
				setState(798); ((Table_actionContext)_localctx).constraint_name = schema_qualified_name();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(799); match(DROP);
				setState(800); match(CONSTRAINT);
				setState(803);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(801); match(IF);
					setState(802); match(EXISTS);
					}
				}

				setState(805); ((Table_actionContext)_localctx).constraint_name = schema_qualified_name();
				setState(806);
				_la = _input.LA(1);
				if ( !(_la==CASCADE || _la==RESTRICT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(808);
				_la = _input.LA(1);
				if ( !(_la==DISABLE || _la==ENABLE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(809); match(TRIGGER);
				setState(813);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(810); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
					}
					break;
				case 2:
					{
					setState(811); match(ALL);
					}
					break;
				case 3:
					{
					setState(812); match(USER);
					}
					break;
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(815); match(ENABLE);
				setState(816);
				_la = _input.LA(1);
				if ( !(_la==ALWAYS || _la==REPLICA) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(817); match(TRIGGER);
				setState(818); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(819);
				_la = _input.LA(1);
				if ( !(_la==DISABLE || _la==ENABLE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(820); match(RULE);
				setState(821); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(822); match(ENABLE);
				setState(823);
				_la = _input.LA(1);
				if ( !(_la==ALWAYS || _la==REPLICA) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(824); match(RULE);
				setState(825); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(826); match(CLUSTER);
				setState(827); match(ON);
				setState(828); ((Table_actionContext)_localctx).index_name = schema_qualified_name();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(829); match(SET);
				setState(830); match(WITHOUT);
				setState(831);
				_la = _input.LA(1);
				if ( !(_la==OIDS || _la==CLUSTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(832); match(SET);
				setState(833); match(WITH);
				setState(834); match(OIDS);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(835); match(SET);
				setState(836); storage_parameter();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(837); match(RESET);
				setState(838); match(LEFT_PAREN);
				setState(839); with_storage_parameter();
				setState(844);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(840); match(COMMA);
					setState(841); with_storage_parameter();
					}
					}
					setState(846);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(847); match(RIGHT_PAREN);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(849); match(INHERIT);
				setState(850); ((Table_actionContext)_localctx).parent_table = schema_qualified_name();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(851); match(NO);
				setState(852); match(INHERIT);
				setState(853); ((Table_actionContext)_localctx).parent_table = schema_qualified_name();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(854); match(OF);
				setState(855); ((Table_actionContext)_localctx).type_name = schema_qualified_name();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(856); match(NOT);
				setState(857); match(OF);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(858); match(OWNER);
				setState(859); match(TO);
				setState(860); ((Table_actionContext)_localctx).new_owner = schema_qualified_name();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(861); match(SET);
				setState(862); match(TABLESPACE);
				setState(863); ((Table_actionContext)_localctx).new_tablespace = schema_qualified_name();
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

	public static class Attribute_option_valueContext extends ParserRuleContext {
		public Table_attribute_optionContext attribute_option;
		public Signed_numerical_literalContext value;
		public Signed_numerical_literalContext signed_numerical_literal() {
			return getRuleContext(Signed_numerical_literalContext.class,0);
		}
		public Table_attribute_optionContext table_attribute_option() {
			return getRuleContext(Table_attribute_optionContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public Attribute_option_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_option_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAttribute_option_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAttribute_option_value(this);
		}
	}

	public final Attribute_option_valueContext attribute_option_value() throws RecognitionException {
		Attribute_option_valueContext _localctx = new Attribute_option_valueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_attribute_option_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866); ((Attribute_option_valueContext)_localctx).attribute_option = table_attribute_option();
			setState(867); match(EQUAL);
			setState(868); ((Attribute_option_valueContext)_localctx).value = signed_numerical_literal();
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
		public TerminalNode KEY() { return getToken(SQLParser.KEY, 0); }
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode PRIMARY() { return getToken(SQLParser.PRIMARY, 0); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode IMMEDIATE() { return getToken(SQLParser.IMMEDIATE, 0); }
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
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
		enterRule(_localctx, 28, RULE_table_constraint_using_index);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(870); match(CONSTRAINT);
				setState(871); ((Table_constraint_using_indexContext)_localctx).constraint_name = schema_qualified_name();
				}
			}

			setState(877);
			switch (_input.LA(1)) {
			case UNIQUE:
				{
				setState(874); match(UNIQUE);
				}
				break;
			case PRIMARY:
				{
				setState(875); match(PRIMARY);
				setState(876); match(KEY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(879); match(USING);
			setState(880); match(INDEX);
			setState(881); ((Table_constraint_using_indexContext)_localctx).index_name = schema_qualified_name();
			setState(886);
			_la = _input.LA(1);
			if (_la==DEFERRABLE || _la==NOT) {
				{
				setState(883);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(882); match(NOT);
					}
				}

				setState(885); match(DEFERRABLE);
				}
			}

			setState(890);
			_la = _input.LA(1);
			if (_la==INITIALLY) {
				{
				setState(888); match(INITIALLY);
				setState(889);
				_la = _input.LA(1);
				if ( !(_la==DEFERRED || _la==IMMEDIATE) ) {
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
		enterRule(_localctx, 30, RULE_table_attribute_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(892);
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
		public TerminalNode RESET() { return getToken(SQLParser.RESET, 0); }
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode INPUT() { return getToken(SQLParser.INPUT, 0); }
		public TerminalNode VOLATILE() { return getToken(SQLParser.VOLATILE, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode STABLE() { return getToken(SQLParser.STABLE, 0); }
		public TerminalNode STRICT() { return getToken(SQLParser.STRICT, 0); }
		public TerminalNode COST() { return getToken(SQLParser.COST, 0); }
		public TerminalNode CALLED() { return getToken(SQLParser.CALLED, 0); }
		public TerminalNode IMMUTABLE() { return getToken(SQLParser.IMMUTABLE, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public TerminalNode INVOKER() { return getToken(SQLParser.INVOKER, 0); }
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public TerminalNode DEFINER() { return getToken(SQLParser.DEFINER, 0); }
		public TerminalNode NULL(int i) {
			return getToken(SQLParser.NULL, i);
		}
		public TerminalNode CURRENT() { return getToken(SQLParser.CURRENT, 0); }
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public TerminalNode ROWS() { return getToken(SQLParser.ROWS, 0); }
		public TerminalNode SECURITY() { return getToken(SQLParser.SECURITY, 0); }
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
		enterRule(_localctx, 32, RULE_function_action);
		int _la;
		try {
			setState(939);
			switch (_input.LA(1)) {
			case CALLED:
				enterOuterAlt(_localctx, 1);
				{
				setState(894); match(CALLED);
				setState(895); match(ON);
				setState(896); match(NULL);
				setState(897); match(INPUT);
				}
				break;
			case RETURNS:
				enterOuterAlt(_localctx, 2);
				{
				setState(898); match(RETURNS);
				setState(899); match(NULL);
				setState(900); match(ON);
				setState(901); match(NULL);
				setState(902); match(INPUT);
				}
				break;
			case STRICT:
				enterOuterAlt(_localctx, 3);
				{
				setState(903); match(STRICT);
				setState(904); match(IMMUTABLE);
				}
				break;
			case STABLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(905); match(STABLE);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(906); match(VOLATILE);
				setState(908);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(907); match(EXTERNAL);
					}
				}

				setState(910); match(SECURITY);
				setState(911); match(INVOKER);
				}
				break;
			case EXTERNAL:
			case SECURITY:
				enterOuterAlt(_localctx, 6);
				{
				setState(913);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(912); match(EXTERNAL);
					}
				}

				setState(915); match(SECURITY);
				setState(916); match(DEFINER);
				}
				break;
			case COST:
				enterOuterAlt(_localctx, 7);
				{
				setState(917); match(COST);
				setState(918); ((Function_actionContext)_localctx).execution_cost = match(NUMBER);
				}
				break;
			case ROWS:
				enterOuterAlt(_localctx, 8);
				{
				setState(919); match(ROWS);
				setState(920); ((Function_actionContext)_localctx).result_rows = match(NUMBER);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 9);
				{
				setState(921); match(SET);
				setState(922); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(932);
				switch (_input.LA(1)) {
				case DEFAULT:
				case TO:
				case EQUAL:
					{
					setState(928);
					switch (_input.LA(1)) {
					case TO:
						{
						setState(923); match(TO);
						setState(924); ((Function_actionContext)_localctx).value = identifier();
						}
						break;
					case EQUAL:
						{
						setState(925); match(EQUAL);
						setState(926); ((Function_actionContext)_localctx).value = identifier();
						}
						break;
					case DEFAULT:
						{
						setState(927); match(DEFAULT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case FROM:
					{
					setState(930); match(FROM);
					setState(931); match(CURRENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case RESET:
				enterOuterAlt(_localctx, 10);
				{
				setState(934); match(RESET);
				setState(937);
				switch (_input.LA(1)) {
				case REPLACE:
				case ADMIN:
				case ALWAYS:
				case ARRAY:
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
				case CONCURRENTLY:
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
				case EVENT:
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
				case OVER:
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
				case REGCONFIG:
				case REGEXP:
				case RENAME:
				case REPLICA:
				case RESET:
				case RESTART:
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
				case STDIN:
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
				case TYPES:
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
				case INET:
				case INTERVAL:
				case VOID:
				case DOUBLE_QUOTE:
				case Identifier:
				case QuotedIdentifier:
					{
					setState(935); ((Function_actionContext)_localctx).configuration_parameter = identifier();
					}
					break;
				case ALL:
					{
					setState(936); match(ALL);
					}
					break;
				default:
					throw new NoViableAltException(this);
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

	public static class Alter_default_privilegesContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public List<IdentifierContext> target_role = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> schema_name = new ArrayList<IdentifierContext>();
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public Abbreviated_grant_or_revokeContext abbreviated_grant_or_revoke() {
			return getRuleContext(Abbreviated_grant_or_revokeContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode USER() { return getToken(SQLParser.USER, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode PRIVILEGES() { return getToken(SQLParser.PRIVILEGES, 0); }
		public TerminalNode ROLE() { return getToken(SQLParser.ROLE, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Alter_default_privilegesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_default_privileges; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAlter_default_privileges(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAlter_default_privileges(this);
		}
	}

	public final Alter_default_privilegesContext alter_default_privileges() throws RecognitionException {
		Alter_default_privilegesContext _localctx = new Alter_default_privilegesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_alter_default_privileges);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(941); match(DEFAULT);
			setState(942); match(PRIVILEGES);
			setState(953);
			_la = _input.LA(1);
			if (_la==FOR) {
				{
				setState(943); match(FOR);
				setState(944);
				_la = _input.LA(1);
				if ( !(_la==ROLE || _la==USER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(945); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
				((Alter_default_privilegesContext)_localctx).target_role.add(((Alter_default_privilegesContext)_localctx).identifier);
				setState(950);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(946); match(COMMA);
					setState(947); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
					((Alter_default_privilegesContext)_localctx).target_role.add(((Alter_default_privilegesContext)_localctx).identifier);
					}
					}
					setState(952);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(965);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(955); match(IN);
				setState(956); match(SCHEMA);
				setState(957); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
				((Alter_default_privilegesContext)_localctx).schema_name.add(((Alter_default_privilegesContext)_localctx).identifier);
				setState(962);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(958); match(COMMA);
					setState(959); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
					((Alter_default_privilegesContext)_localctx).schema_name.add(((Alter_default_privilegesContext)_localctx).identifier);
					}
					}
					setState(964);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(967); abbreviated_grant_or_revoke();
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

	public static class Abbreviated_grant_or_revokeContext extends ParserRuleContext {
		public TerminalNode EXECUTE() { return getToken(SQLParser.EXECUTE, 0); }
		public TerminalNode SELECT(int i) {
			return getToken(SQLParser.SELECT, i);
		}
		public Grant_to_ruleContext grant_to_rule() {
			return getRuleContext(Grant_to_ruleContext.class,0);
		}
		public List<TerminalNode> INSERT() { return getTokens(SQLParser.INSERT); }
		public TerminalNode TABLES() { return getToken(SQLParser.TABLES, 0); }
		public TerminalNode DELETE(int i) {
			return getToken(SQLParser.DELETE, i);
		}
		public TerminalNode FUNCTIONS() { return getToken(SQLParser.FUNCTIONS, 0); }
		public List<TerminalNode> TRUNCATE() { return getTokens(SQLParser.TRUNCATE); }
		public TerminalNode USAGE(int i) {
			return getToken(SQLParser.USAGE, i);
		}
		public TerminalNode REVOKE() { return getToken(SQLParser.REVOKE, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode TRIGGER(int i) {
			return getToken(SQLParser.TRIGGER, i);
		}
		public TerminalNode GRANT() { return getToken(SQLParser.GRANT, 0); }
		public TerminalNode UPDATE(int i) {
			return getToken(SQLParser.UPDATE, i);
		}
		public TerminalNode TRUNCATE(int i) {
			return getToken(SQLParser.TRUNCATE, i);
		}
		public List<TerminalNode> DELETE() { return getTokens(SQLParser.DELETE); }
		public List<TerminalNode> UPDATE() { return getTokens(SQLParser.UPDATE); }
		public TerminalNode PRIVILEGES() { return getToken(SQLParser.PRIVILEGES, 0); }
		public TerminalNode OPTION() { return getToken(SQLParser.OPTION, 0); }
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public Revoke_from_cascade_restrictContext revoke_from_cascade_restrict() {
			return getRuleContext(Revoke_from_cascade_restrictContext.class,0);
		}
		public TerminalNode TYPES() { return getToken(SQLParser.TYPES, 0); }
		public List<TerminalNode> SELECT() { return getTokens(SQLParser.SELECT); }
		public List<TerminalNode> USAGE() { return getTokens(SQLParser.USAGE); }
		public TerminalNode INSERT(int i) {
			return getToken(SQLParser.INSERT, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<TerminalNode> REFERENCES() { return getTokens(SQLParser.REFERENCES); }
		public List<TerminalNode> TRIGGER() { return getTokens(SQLParser.TRIGGER); }
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode REFERENCES(int i) {
			return getToken(SQLParser.REFERENCES, i);
		}
		public TerminalNode SEQUENCES() { return getToken(SQLParser.SEQUENCES, 0); }
		public Abbreviated_grant_or_revokeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abbreviated_grant_or_revoke; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAbbreviated_grant_or_revoke(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAbbreviated_grant_or_revoke(this);
		}
	}

	public final Abbreviated_grant_or_revokeContext abbreviated_grant_or_revoke() throws RecognitionException {
		Abbreviated_grant_or_revokeContext _localctx = new Abbreviated_grant_or_revokeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_abbreviated_grant_or_revoke);
		int _la;
		try {
			setState(1105);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(969); match(GRANT);
				setState(982);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					{
					setState(970);
					_la = _input.LA(1);
					if ( !(_la==DELETE || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (TRIGGER - 104)) | (1L << (TRUNCATE - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(975);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(971); match(COMMA);
						setState(972);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (TRIGGER - 104)) | (1L << (TRUNCATE - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(977);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(978); match(ALL);
					setState(980);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(979); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(984); match(ON);
				setState(985); match(TABLES);
				setState(986); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(987); match(GRANT);
				setState(1000);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					{
					setState(988);
					_la = _input.LA(1);
					if ( !(((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (SELECT - 114)) | (1L << (UPDATE - 114)) | (1L << (USAGE - 114)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(993);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(989); match(COMMA);
						setState(990);
						_la = _input.LA(1);
						if ( !(((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (SELECT - 114)) | (1L << (UPDATE - 114)) | (1L << (USAGE - 114)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(995);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(996); match(ALL);
					setState(998);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(997); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1002); match(ON);
				setState(1003); match(SEQUENCES);
				setState(1004); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1005); match(GRANT);
				setState(1011);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1006); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1007); match(ALL);
					setState(1009);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1008); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1013); match(ON);
				setState(1014); match(FUNCTIONS);
				setState(1015); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1016); match(GRANT);
				setState(1022);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1017); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1018); match(ALL);
					setState(1020);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1019); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1024); match(ON);
				setState(1025); match(TYPES);
				setState(1026); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1027); match(REVOKE);
				setState(1031);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1028); match(GRANT);
					setState(1029); match(OPTION);
					setState(1030); match(FOR);
					}
				}

				setState(1045);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					{
					setState(1033);
					_la = _input.LA(1);
					if ( !(_la==DELETE || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (TRIGGER - 104)) | (1L << (TRUNCATE - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1038);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1034); match(COMMA);
						setState(1035);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (TRIGGER - 104)) | (1L << (TRUNCATE - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1040);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(1041); match(ALL);
					setState(1043);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1042); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1047); match(ON);
				setState(1048); match(TABLES);
				setState(1049); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1050); match(REVOKE);
				setState(1054);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1051); match(GRANT);
					setState(1052); match(OPTION);
					setState(1053); match(FOR);
					}
				}

				setState(1068);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					{
					setState(1056);
					_la = _input.LA(1);
					if ( !(((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (SELECT - 114)) | (1L << (UPDATE - 114)) | (1L << (USAGE - 114)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1061);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1057); match(COMMA);
						setState(1058);
						_la = _input.LA(1);
						if ( !(((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (SELECT - 114)) | (1L << (UPDATE - 114)) | (1L << (USAGE - 114)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1063);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(1064); match(ALL);
					setState(1066);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1065); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1070); match(ON);
				setState(1071); match(SEQUENCES);
				setState(1072); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1073); match(REVOKE);
				setState(1077);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1074); match(GRANT);
					setState(1075); match(OPTION);
					setState(1076); match(FOR);
					}
				}

				setState(1084);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1079); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1080); match(ALL);
					setState(1082);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1081); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1086); match(ON);
				setState(1087); match(FUNCTIONS);
				setState(1088); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1089); match(REVOKE);
				setState(1093);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1090); match(GRANT);
					setState(1091); match(OPTION);
					setState(1092); match(FOR);
					}
				}

				setState(1100);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1095); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1096); match(ALL);
					setState(1098);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1097); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1102); match(ON);
				setState(1103); match(TYPES);
				setState(1104); revoke_from_cascade_restrict();
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

	public static class Alter_sequence_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public IdentifierContext restart;
		public Schema_qualified_nameContext new_name;
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode RESTART(int i) {
			return getToken(SQLParser.RESTART, i);
		}
		public List<TerminalNode> WITH() { return getTokens(SQLParser.WITH); }
		public Sequence_bodyContext sequence_body(int i) {
			return getRuleContext(Sequence_bodyContext.class,i);
		}
		public TerminalNode WITH(int i) {
			return getToken(SQLParser.WITH, i);
		}
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public List<TerminalNode> RESTART() { return getTokens(SQLParser.RESTART); }
		public TerminalNode OWNER() { return getToken(SQLParser.OWNER, 0); }
		public List<Sequence_bodyContext> sequence_body() {
			return getRuleContexts(Sequence_bodyContext.class);
		}
		public TerminalNode SEQUENCE() { return getToken(SQLParser.SEQUENCE, 0); }
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public Alter_sequence_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_sequence_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAlter_sequence_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAlter_sequence_statement(this);
		}
	}

	public final Alter_sequence_statementContext alter_sequence_statement() throws RecognitionException {
		Alter_sequence_statementContext _localctx = new Alter_sequence_statementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_alter_sequence_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1107); match(SEQUENCE);
			setState(1110);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1108); match(IF);
				setState(1109); match(EXISTS);
				}
			}

			setState(1112); ((Alter_sequence_statementContext)_localctx).name = schema_qualified_name();
			setState(1133);
			switch (_input.LA(1)) {
			case OWNED:
			case CACHE:
			case CYCLE:
			case INCREMENT:
			case MAXVALUE:
			case MINVALUE:
			case NO:
			case RESTART:
			case START:
			case SEMI_COLON:
				{
				setState(1123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OWNED || _la==CACHE || ((((_la - 167)) & ~0x3f) == 0 && ((1L << (_la - 167)) & ((1L << (CYCLE - 167)) | (1L << (INCREMENT - 167)) | (1L << (MAXVALUE - 167)) | (1L << (MINVALUE - 167)) | (1L << (NO - 167)))) != 0) || _la==RESTART || _la==START) {
					{
					setState(1121);
					switch (_input.LA(1)) {
					case OWNED:
					case CACHE:
					case CYCLE:
					case INCREMENT:
					case MAXVALUE:
					case MINVALUE:
					case NO:
					case START:
						{
						setState(1113); sequence_body();
						}
						break;
					case RESTART:
						{
						setState(1114); match(RESTART);
						setState(1119);
						switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
						case 1:
							{
							setState(1116);
							_la = _input.LA(1);
							if (_la==WITH) {
								{
								setState(1115); match(WITH);
								}
							}

							setState(1118); ((Alter_sequence_statementContext)_localctx).restart = identifier();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(1125);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case OWNER:
			case RENAME:
			case SET:
				{
				setState(1130);
				switch (_input.LA(1)) {
				case OWNER:
				case RENAME:
					{
					setState(1126);
					_la = _input.LA(1);
					if ( !(_la==OWNER || _la==RENAME) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1127); match(TO);
					}
					break;
				case SET:
					{
					setState(1128); match(SET);
					setState(1129); match(SCHEMA);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1132); ((Alter_sequence_statementContext)_localctx).new_name = schema_qualified_name();
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

	public static class Alter_view_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public Schema_qualified_nameContext column_name;
		public Value_expressionContext expression;
		public Schema_qualified_nameContext new_owner;
		public IdentifierContext view_option_name;
		public Value_expressionContext view_option_value;
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode RESET() { return getToken(SQLParser.RESET, 0); }
		public TerminalNode VIEW() { return getToken(SQLParser.VIEW, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public List<TerminalNode> EQUAL() { return getTokens(SQLParser.EQUAL); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode OWNER() { return getToken(SQLParser.OWNER, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public TerminalNode EQUAL(int i) {
			return getToken(SQLParser.EQUAL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Alter_view_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_view_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAlter_view_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAlter_view_statement(this);
		}
	}

	public final Alter_view_statementContext alter_view_statement() throws RecognitionException {
		Alter_view_statementContext _localctx = new Alter_view_statementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_alter_view_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1135); match(VIEW);
			setState(1138);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1136); match(IF);
				setState(1137); match(EXISTS);
				}
			}

			setState(1140); ((Alter_view_statementContext)_localctx).name = schema_qualified_name();
			setState(1192);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(1141); match(ALTER);
				setState(1143);
				switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
				case 1:
					{
					setState(1142); match(COLUMN);
					}
					break;
				}
				setState(1145); ((Alter_view_statementContext)_localctx).column_name = schema_qualified_name();
				setState(1151);
				switch (_input.LA(1)) {
				case SET:
					{
					setState(1146); match(SET);
					setState(1147); match(DEFAULT);
					setState(1148); ((Alter_view_statementContext)_localctx).expression = value_expression();
					}
					break;
				case DROP:
					{
					setState(1149); match(DROP);
					setState(1150); match(DEFAULT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				{
				setState(1157);
				switch (_input.LA(1)) {
				case OWNER:
				case RENAME:
					{
					{
					setState(1153);
					_la = _input.LA(1);
					if ( !(_la==OWNER || _la==RENAME) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1154); match(TO);
					}
					}
					break;
				case SET:
					{
					setState(1155); match(SET);
					setState(1156); match(SCHEMA);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1159); ((Alter_view_statementContext)_localctx).new_owner = schema_qualified_name();
				}
				break;
			case 3:
				{
				setState(1160); match(SET);
				setState(1161); match(LEFT_PAREN);
				setState(1162); ((Alter_view_statementContext)_localctx).view_option_name = identifier();
				setState(1165);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1163); match(EQUAL);
					setState(1164); ((Alter_view_statementContext)_localctx).view_option_value = value_expression();
					}
				}

				setState(1175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1167); match(COMMA);
					setState(1168); ((Alter_view_statementContext)_localctx).view_option_name = identifier();
					setState(1171);
					_la = _input.LA(1);
					if (_la==EQUAL) {
						{
						setState(1169); match(EQUAL);
						setState(1170); ((Alter_view_statementContext)_localctx).view_option_value = value_expression();
						}
					}

					}
					}
					setState(1177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1178); match(RIGHT_PAREN);
				}
				break;
			case 4:
				{
				setState(1180); match(RESET);
				setState(1181); match(LEFT_PAREN);
				setState(1182); ((Alter_view_statementContext)_localctx).view_option_name = identifier();
				setState(1187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1183); match(COMMA);
					setState(1184); ((Alter_view_statementContext)_localctx).view_option_name = identifier();
					}
					}
					setState(1189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1190); match(RIGHT_PAREN);
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

	public static class Index_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public Schema_qualified_nameContext table_name;
		public Schema_qualified_nameContext method;
		public Schema_qualified_nameContext tablespace_name;
		public Boolean_value_expressionContext predic;
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public Sort_specifier_parenContext sort_specifier_paren() {
			return getRuleContext(Sort_specifier_parenContext.class,0);
		}
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode CONCURRENTLY() { return getToken(SQLParser.CONCURRENTLY, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
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
		enterRule(_localctx, 42, RULE_index_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1195);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(1194); match(UNIQUE);
				}
			}

			setState(1197); match(INDEX);
			setState(1199);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				{
				setState(1198); match(CONCURRENTLY);
				}
				break;
			}
			setState(1202);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				{
				setState(1201); ((Index_statementContext)_localctx).name = schema_qualified_name();
				}
				break;
			}
			setState(1204); match(ON);
			setState(1205); ((Index_statementContext)_localctx).table_name = schema_qualified_name();
			setState(1208);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(1206); match(USING);
				setState(1207); ((Index_statementContext)_localctx).method = schema_qualified_name();
				}
			}

			setState(1210); sort_specifier_paren();
			setState(1212);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1211); param_clause();
				}
			}

			setState(1216);
			_la = _input.LA(1);
			if (_la==TABLESPACE) {
				{
				setState(1214); match(TABLESPACE);
				setState(1215); ((Index_statementContext)_localctx).tablespace_name = schema_qualified_name();
				}
			}

			setState(1220);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1218); match(WHERE);
				setState(1219); ((Index_statementContext)_localctx).predic = boolean_value_expression();
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
		public Unsigned_literalContext version;
		public Unsigned_literalContext old_version;
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public Unsigned_literalContext unsigned_literal(int i) {
			return getRuleContext(Unsigned_literalContext.class,i);
		}
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode VERSION() { return getToken(SQLParser.VERSION, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode EXTENSION() { return getToken(SQLParser.EXTENSION, 0); }
		public List<Unsigned_literalContext> unsigned_literal() {
			return getRuleContexts(Unsigned_literalContext.class);
		}
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
		enterRule(_localctx, 44, RULE_create_extension_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1222); match(EXTENSION);
			setState(1226);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1223); match(IF);
				setState(1224); match(NOT);
				setState(1225); match(EXISTS);
				}
			}

			setState(1228); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(1230);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1229); match(WITH);
				}
			}

			setState(1234);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(1232); match(SCHEMA);
				setState(1233); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(1238);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(1236); match(VERSION);
				setState(1237); ((Create_extension_statementContext)_localctx).version = unsigned_literal();
				}
			}

			setState(1242);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(1240); match(FROM);
				setState(1241); ((Create_extension_statementContext)_localctx).old_version = unsigned_literal();
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
		enterRule(_localctx, 46, RULE_create_language_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1246);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(1244); match(OR);
				setState(1245); match(REPLACE);
				}
			}

			setState(1249);
			_la = _input.LA(1);
			if (_la==TRUSTED) {
				{
				setState(1248); match(TRUSTED);
				}
			}

			setState(1252);
			_la = _input.LA(1);
			if (_la==PROCEDURAL) {
				{
				setState(1251); match(PROCEDURAL);
				}
			}

			setState(1254); match(LANGUAGE);
			setState(1255); ((Create_language_statementContext)_localctx).name = identifier();
			setState(1266);
			_la = _input.LA(1);
			if (_la==HANDLER) {
				{
				setState(1256); match(HANDLER);
				setState(1257); ((Create_language_statementContext)_localctx).call_handler = schema_qualified_name();
				setState(1260);
				_la = _input.LA(1);
				if (_la==INLINE) {
					{
					setState(1258); match(INLINE);
					setState(1259); ((Create_language_statementContext)_localctx).inline_handler = schema_qualified_name();
					}
				}

				setState(1264);
				_la = _input.LA(1);
				if (_la==VALIDATOR) {
					{
					setState(1262); match(VALIDATOR);
					setState(1263); ((Create_language_statementContext)_localctx).valfunction = schema_qualified_name();
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

	public static class Create_event_triggerContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public Schema_qualified_nameContext event;
		public Schema_qualified_nameContext filter_variable;
		public Token Character_String_Literal;
		public List<Token> filter_value = new ArrayList<Token>();
		public Value_expressionContext funct_name;
		public TerminalNode EXECUTE() { return getToken(SQLParser.EXECUTE, 0); }
		public List<TerminalNode> AND() { return getTokens(SQLParser.AND); }
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode PROCEDURE() { return getToken(SQLParser.PROCEDURE, 0); }
		public TerminalNode AND(int i) {
			return getToken(SQLParser.AND, i);
		}
		public List<TerminalNode> Character_String_Literal() { return getTokens(SQLParser.Character_String_Literal); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public TerminalNode TRIGGER() { return getToken(SQLParser.TRIGGER, 0); }
		public List<TerminalNode> IN() { return getTokens(SQLParser.IN); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode IN(int i) {
			return getToken(SQLParser.IN, i);
		}
		public TerminalNode EVENT() { return getToken(SQLParser.EVENT, 0); }
		public TerminalNode Character_String_Literal(int i) {
			return getToken(SQLParser.Character_String_Literal, i);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public TerminalNode WHEN() { return getToken(SQLParser.WHEN, 0); }
		public Create_event_triggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_event_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterCreate_event_trigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitCreate_event_trigger(this);
		}
	}

	public final Create_event_triggerContext create_event_trigger() throws RecognitionException {
		Create_event_triggerContext _localctx = new Create_event_triggerContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_create_event_trigger);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1268); match(EVENT);
			setState(1269); match(TRIGGER);
			setState(1270); ((Create_event_triggerContext)_localctx).name = schema_qualified_name();
			setState(1271); match(ON);
			setState(1272); ((Create_event_triggerContext)_localctx).event = schema_qualified_name();
			setState(1293);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(1273); match(WHEN);
				setState(1274); ((Create_event_triggerContext)_localctx).filter_variable = schema_qualified_name();
				setState(1289); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1275); match(IN);
					setState(1276); match(LEFT_PAREN);
					setState(1277); ((Create_event_triggerContext)_localctx).Character_String_Literal = match(Character_String_Literal);
					((Create_event_triggerContext)_localctx).filter_value.add(((Create_event_triggerContext)_localctx).Character_String_Literal);
					setState(1282);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1278); match(COMMA);
						setState(1279); ((Create_event_triggerContext)_localctx).Character_String_Literal = match(Character_String_Literal);
						((Create_event_triggerContext)_localctx).filter_value.add(((Create_event_triggerContext)_localctx).Character_String_Literal);
						}
						}
						setState(1284);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1285); match(RIGHT_PAREN);
					setState(1287);
					_la = _input.LA(1);
					if (_la==AND) {
						{
						setState(1286); match(AND);
						}
					}

					}
					}
					setState(1291); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IN );
				}
			}

			setState(1295); match(EXECUTE);
			setState(1296); match(PROCEDURE);
			setState(1297); ((Create_event_triggerContext)_localctx).funct_name = value_expression();
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
		public IdentifierContext timezone;
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode SESSION() { return getToken(SQLParser.SESSION, 0); }
		public TerminalNode TIME() { return getToken(SQLParser.TIME, 0); }
		public List<Set_statement_valueContext> set_statement_value() {
			return getRuleContexts(Set_statement_valueContext.class);
		}
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Set_statement_valueContext set_statement_value(int i) {
			return getRuleContext(Set_statement_valueContext.class,i);
		}
		public List<TerminalNode> DEFAULT() { return getTokens(SQLParser.DEFAULT); }
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
		enterRule(_localctx, 50, RULE_set_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1299); match(SET);
			setState(1301);
			_la = _input.LA(1);
			if (_la==LOCAL || _la==SESSION) {
				{
				setState(1300);
				_la = _input.LA(1);
				if ( !(_la==LOCAL || _la==SESSION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1331);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				{
				setState(1303); ((Set_statementContext)_localctx).config_param = identifier();
				setState(1304);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1305); set_statement_value();
				setState(1310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1306); match(COMMA);
					setState(1307); set_statement_value();
					}
					}
					setState(1312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(1313); match(TIME);
				setState(1314); match(ZONE);
				setState(1318);
				switch (_input.LA(1)) {
				case REPLACE:
				case ADMIN:
				case ALWAYS:
				case ARRAY:
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
				case CONCURRENTLY:
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
				case EVENT:
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
				case OVER:
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
				case REGCONFIG:
				case REGEXP:
				case RENAME:
				case REPLICA:
				case RESET:
				case RESTART:
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
				case STDIN:
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
				case TYPES:
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
				case INET:
				case INTERVAL:
				case VOID:
				case DOUBLE_QUOTE:
				case Identifier:
				case QuotedIdentifier:
					{
					setState(1315); ((Set_statementContext)_localctx).timezone = identifier();
					}
					break;
				case LOCAL:
					{
					setState(1316); match(LOCAL);
					}
					break;
				case DEFAULT:
					{
					setState(1317); match(DEFAULT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1320); match(COMMA);
					setState(1324);
					switch (_input.LA(1)) {
					case REPLACE:
					case ADMIN:
					case ALWAYS:
					case ARRAY:
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
					case CONCURRENTLY:
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
					case EVENT:
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
					case OVER:
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
					case REGCONFIG:
					case REGEXP:
					case RENAME:
					case REPLICA:
					case RESET:
					case RESTART:
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
					case STDIN:
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
					case TYPES:
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
					case INET:
					case INTERVAL:
					case VOID:
					case DOUBLE_QUOTE:
					case Identifier:
					case QuotedIdentifier:
						{
						setState(1321); ((Set_statementContext)_localctx).timezone = identifier();
						}
						break;
					case LOCAL:
						{
						setState(1322); match(LOCAL);
						}
						break;
					case DEFAULT:
						{
						setState(1323); match(DEFAULT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(1330);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class Set_statement_valueContext extends ParserRuleContext {
		public Value_expressionContext value;
		public TerminalNode QUOTE(int i) {
			return getToken(SQLParser.QUOTE, i);
		}
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public List<TerminalNode> QUOTE() { return getTokens(SQLParser.QUOTE); }
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public Set_statement_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_statement_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSet_statement_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSet_statement_value(this);
		}
	}

	public final Set_statement_valueContext set_statement_value() throws RecognitionException {
		Set_statement_valueContext _localctx = new Set_statement_valueContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_set_statement_value);
		try {
			setState(1339);
			switch (_input.LA(1)) {
			case ALL:
			case ANY:
			case CASE:
			case CAST:
			case FALSE:
			case NOT:
			case NULL:
			case REPLACE:
			case SELECT:
			case SOME:
			case TRUE:
			case ADMIN:
			case ALWAYS:
			case ARRAY:
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
			case CONCURRENTLY:
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
			case EVENT:
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
			case OVER:
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
			case REGCONFIG:
			case REGEXP:
			case RENAME:
			case REPLICA:
			case RESET:
			case RESTART:
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
			case STDIN:
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
			case TYPES:
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
			case INET:
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
				enterOuterAlt(_localctx, 1);
				{
				setState(1333); ((Set_statement_valueContext)_localctx).value = value_expression();
				}
				break;
			case QUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1334); match(QUOTE);
				setState(1335); ((Set_statement_valueContext)_localctx).value = value_expression();
				setState(1336); match(QUOTE);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1338); match(DEFAULT);
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

	public static class Create_trigger_statementContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext identifier;
		public List<IdentifierContext> columnName = new ArrayList<IdentifierContext>();
		public Schema_qualified_nameContext tabl_name;
		public Schema_qualified_nameContext referenced_table_name;
		public Schema_qualified_nameContext func_name;
		public List<IdentifierContext> arguments = new ArrayList<IdentifierContext>();
		public TerminalNode DEFERRED() { return getToken(SQLParser.DEFERRED, 0); }
		public TerminalNode EXECUTE() { return getToken(SQLParser.EXECUTE, 0); }
		public TerminalNode BEFORE() { return getToken(SQLParser.BEFORE, 0); }
		public TerminalNode DEFERRABLE() { return getToken(SQLParser.DEFERRABLE, 0); }
		public TerminalNode PROCEDURE() { return getToken(SQLParser.PROCEDURE, 0); }
		public TerminalNode OF(int i) {
			return getToken(SQLParser.OF, i);
		}
		public List<TerminalNode> INSERT() { return getTokens(SQLParser.INSERT); }
		public TerminalNode DELETE(int i) {
			return getToken(SQLParser.DELETE, i);
		}
		public TerminalNode EACH() { return getToken(SQLParser.EACH, 0); }
		public List<TerminalNode> TRUNCATE() { return getTokens(SQLParser.TRUNCATE); }
		public TerminalNode INITIALLY() { return getToken(SQLParser.INITIALLY, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode ROW() { return getToken(SQLParser.ROW, 0); }
		public TerminalNode INSTEAD() { return getToken(SQLParser.INSTEAD, 0); }
		public TerminalNode UPDATE(int i) {
			return getToken(SQLParser.UPDATE, i);
		}
		public TerminalNode TRUNCATE(int i) {
			return getToken(SQLParser.TRUNCATE, i);
		}
		public List<TerminalNode> OF() { return getTokens(SQLParser.OF); }
		public List<TerminalNode> DELETE() { return getTokens(SQLParser.DELETE); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public List<TerminalNode> UPDATE() { return getTokens(SQLParser.UPDATE); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode OR(int i) {
			return getToken(SQLParser.OR, i);
		}
		public TerminalNode IMMEDIATE() { return getToken(SQLParser.IMMEDIATE, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public TerminalNode WHEN() { return getToken(SQLParser.WHEN, 0); }
		public TerminalNode STATEMENT() { return getToken(SQLParser.STATEMENT, 0); }
		public List<TerminalNode> OR() { return getTokens(SQLParser.OR); }
		public TerminalNode INSERT(int i) {
			return getToken(SQLParser.INSERT, i);
		}
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
		enterRule(_localctx, 54, RULE_create_trigger_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1342);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1341); match(CONSTRAINT);
				}
			}

			setState(1344); match(TRIGGER);
			setState(1345); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(1350);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(1346); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(1347); match(INSTEAD);
				setState(1348); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(1349); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1370); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1365);
				switch (_input.LA(1)) {
				case DELETE:
				case TRUNCATE:
				case INSERT:
					{
					setState(1352);
					_la = _input.LA(1);
					if ( !(_la==DELETE || _la==TRUNCATE || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UPDATE:
					{
					setState(1353); match(UPDATE);
					setState(1363);
					_la = _input.LA(1);
					if (_la==OF) {
						{
						setState(1354); match(OF);
						setState(1355); ((Create_trigger_statementContext)_localctx).identifier = identifier();
						((Create_trigger_statementContext)_localctx).columnName.add(((Create_trigger_statementContext)_localctx).identifier);
						setState(1360);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1356); match(COMMA);
							setState(1357); ((Create_trigger_statementContext)_localctx).identifier = identifier();
							((Create_trigger_statementContext)_localctx).columnName.add(((Create_trigger_statementContext)_localctx).identifier);
							}
							}
							setState(1362);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1368);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(1367); match(OR);
					}
				}

				}
				}
				setState(1372); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DELETE || _la==TRUNCATE || _la==UPDATE || _la==INSERT );
			setState(1374); match(ON);
			setState(1375); ((Create_trigger_statementContext)_localctx).tabl_name = schema_qualified_name();
			setState(1378);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(1376); match(FROM);
				setState(1377); ((Create_trigger_statementContext)_localctx).referenced_table_name = schema_qualified_name();
				}
			}

			setState(1389);
			switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
			case 1:
				{
				setState(1380); match(NOT);
				setState(1381); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(1383);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(1382); match(DEFERRABLE);
					}
				}

				{
				setState(1385); match(INITIALLY);
				setState(1386); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(1387); match(INITIALLY);
				setState(1388); match(DEFERRED);
				}
				}
				break;
			}
			setState(1396);
			_la = _input.LA(1);
			if (_la==FOR) {
				{
				setState(1391); match(FOR);
				setState(1393);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(1392); match(EACH);
					}
				}

				setState(1395);
				_la = _input.LA(1);
				if ( !(_la==ROW || _la==STATEMENT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1400);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(1398); match(WHEN);
				{
				setState(1399); boolean_value_expression();
				}
				}
			}

			setState(1402); match(EXECUTE);
			setState(1403); match(PROCEDURE);
			setState(1404); ((Create_trigger_statementContext)_localctx).func_name = schema_qualified_name();
			setState(1405); match(LEFT_PAREN);
			setState(1407);
			_la = _input.LA(1);
			if (((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0)) {
				{
				setState(1406); ((Create_trigger_statementContext)_localctx).identifier = identifier();
				((Create_trigger_statementContext)_localctx).arguments.add(((Create_trigger_statementContext)_localctx).identifier);
				}
			}

			setState(1413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1409); match(COMMA);
				setState(1410); ((Create_trigger_statementContext)_localctx).identifier = identifier();
				((Create_trigger_statementContext)_localctx).arguments.add(((Create_trigger_statementContext)_localctx).identifier);
				}
				}
				setState(1415);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1416); match(RIGHT_PAREN);
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
		public Schema_qualified_nameContext schema_qualified_name;
		public List<Schema_qualified_nameContext> table_name = new ArrayList<Schema_qualified_nameContext>();
		public IdentifierContext identifier;
		public List<IdentifierContext> schema_name = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> column = new ArrayList<IdentifierContext>();
		public List<Schema_qualified_nameContext> sequence_name = new ArrayList<Schema_qualified_nameContext>();
		public List<IdentifierContext> database_name = new ArrayList<IdentifierContext>();
		public List<Schema_qualified_nameContext> fdw_name = new ArrayList<Schema_qualified_nameContext>();
		public List<IdentifierContext> server_name = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> lang_name = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> loid = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> tablespace_name = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> role_name = new ArrayList<IdentifierContext>();
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
		public TerminalNode GRANT() { return getToken(SQLParser.GRANT, 0); }
		public TerminalNode WRAPPER() { return getToken(SQLParser.WRAPPER, 0); }
		public TerminalNode UPDATE(int i) {
			return getToken(SQLParser.UPDATE, i);
		}
		public TerminalNode TRUNCATE(int i) {
			return getToken(SQLParser.TRUNCATE, i);
		}
		public List<TerminalNode> TABLE() { return getTokens(SQLParser.TABLE); }
		public List<TerminalNode> DELETE() { return getTokens(SQLParser.DELETE); }
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
		public List<TerminalNode> TEMP() { return getTokens(SQLParser.TEMP); }
		public TerminalNode SERVER() { return getToken(SQLParser.SERVER, 0); }
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public TerminalNode LANGUAGE() { return getToken(SQLParser.LANGUAGE, 0); }
		public List<TerminalNode> UPDATE() { return getTokens(SQLParser.UPDATE); }
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
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode INSERT(int i) {
			return getToken(SQLParser.INSERT, i);
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
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
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
		enterRule(_localctx, 56, RULE_revoke_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1418); match(REVOKE);
			setState(1729);
			switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
			case 1:
				{
				setState(1422);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1419); match(GRANT);
					setState(1420); match(OPTION);
					setState(1421); match(FOR);
					}
				}

				setState(1702);
				switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
				case 1:
					{
					setState(1436);
					switch (_input.LA(1)) {
					case DELETE:
					case REFERENCES:
					case SELECT:
					case TRIGGER:
					case TRUNCATE:
					case UPDATE:
					case INSERT:
						{
						setState(1424);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (TRIGGER - 104)) | (1L << (TRUNCATE - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1429);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1425); match(COMMA);
							setState(1426);
							_la = _input.LA(1);
							if ( !(_la==DELETE || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (TRIGGER - 104)) | (1L << (TRUNCATE - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							}
							}
							setState(1431);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case ALL:
						{
						setState(1432); match(ALL);
						setState(1434);
						_la = _input.LA(1);
						if (_la==PRIVILEGES) {
							{
							setState(1433); match(PRIVILEGES);
							}
						}

						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1438); match(ON);
					setState(1456);
					switch (_input.LA(1)) {
					case REPLACE:
					case TABLE:
					case ADMIN:
					case ALWAYS:
					case ARRAY:
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
					case CONCURRENTLY:
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
					case EVENT:
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
					case OVER:
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
					case REGCONFIG:
					case REGEXP:
					case RENAME:
					case REPLICA:
					case RESET:
					case RESTART:
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
					case STDIN:
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
					case TYPES:
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
					case INET:
					case INTERVAL:
					case VOID:
					case DOUBLE_QUOTE:
					case Identifier:
					case QuotedIdentifier:
						{
						setState(1443); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1440);
							_la = _input.LA(1);
							if (_la==TABLE) {
								{
								setState(1439); match(TABLE);
								}
							}

							setState(1442); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
							((Revoke_statementContext)_localctx).table_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
							}
							}
							setState(1445); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (TABLE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0) );
						}
						break;
					case ALL:
						{
						setState(1447); match(ALL);
						setState(1448); match(TABLES);
						setState(1449); match(IN);
						setState(1450); match(SCHEMA);
						setState(1452); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1451); ((Revoke_statementContext)_localctx).identifier = identifier();
							((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
							}
							}
							setState(1454); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0) );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1458); revoke_from_cascade_restrict();
					}
					break;
				case 2:
					{
					setState(1491);
					switch (_input.LA(1)) {
					case REFERENCES:
					case SELECT:
					case UPDATE:
					case INSERT:
						{
						setState(1472); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1460);
							_la = _input.LA(1);
							if ( !(((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							setState(1461); match(LEFT_PAREN);
							setState(1462); ((Revoke_statementContext)_localctx).identifier = identifier();
							((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
							setState(1467);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(1463); match(COMMA);
								setState(1464); ((Revoke_statementContext)_localctx).identifier = identifier();
								((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
								}
								}
								setState(1469);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							setState(1470); match(RIGHT_PAREN);
							}
							}
							setState(1474); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT );
						}
						break;
					case ALL:
						{
						setState(1476); match(ALL);
						setState(1478);
						_la = _input.LA(1);
						if (_la==PRIVILEGES) {
							{
							setState(1477); match(PRIVILEGES);
							}
						}

						setState(1480); match(LEFT_PAREN);
						setState(1481); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
						setState(1486);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1482); match(COMMA);
							setState(1483); ((Revoke_statementContext)_localctx).identifier = identifier();
							((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
							}
							}
							setState(1488);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1489); match(RIGHT_PAREN);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1493); match(ON);
					setState(1495);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1494); match(TABLE);
						}
					}

					setState(1497); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
					((Revoke_statementContext)_localctx).table_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
					setState(1502);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1498); match(COMMA);
						setState(1499); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
						((Revoke_statementContext)_localctx).table_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
						}
						}
						setState(1504);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1505); revoke_from_cascade_restrict();
					}
					break;
				case 3:
					{
					setState(1516);
					switch (_input.LA(1)) {
					case SELECT:
					case UPDATE:
					case USAGE:
						{
						setState(1508); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1507);
							_la = _input.LA(1);
							if ( !(((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (SELECT - 114)) | (1L << (UPDATE - 114)) | (1L << (USAGE - 114)))) != 0)) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							}
							}
							setState(1510); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (SELECT - 114)) | (1L << (UPDATE - 114)) | (1L << (USAGE - 114)))) != 0) );
						}
						break;
					case ALL:
						{
						setState(1512); match(ALL);
						setState(1514);
						_la = _input.LA(1);
						if (_la==PRIVILEGES) {
							{
							setState(1513); match(PRIVILEGES);
							}
						}

						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1518); match(ON);
					setState(1540);
					switch (_input.LA(1)) {
					case SEQUENCE:
						{
						setState(1519); match(SEQUENCE);
						setState(1520); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
						((Revoke_statementContext)_localctx).sequence_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
						setState(1525);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1521); match(COMMA);
							setState(1522); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
							((Revoke_statementContext)_localctx).sequence_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
							}
							}
							setState(1527);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case ALL:
						{
						setState(1528); match(ALL);
						setState(1529); match(SEQUENCES);
						setState(1530); match(IN);
						setState(1531); match(SCHEMA);
						setState(1532); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
						setState(1537);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1533); match(COMMA);
							setState(1534); ((Revoke_statementContext)_localctx).identifier = identifier();
							((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
							}
							}
							setState(1539);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1542); revoke_from_cascade_restrict();
					}
					break;
				case 4:
					{
					setState(1553);
					switch (_input.LA(1)) {
					case CONNECT:
					case CREATE:
					case TEMP:
					case TEMPORARY:
						{
						setState(1545); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1544);
							_la = _input.LA(1);
							if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							}
							}
							setState(1547); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
						}
						break;
					case ALL:
						{
						setState(1549); match(ALL);
						setState(1551);
						_la = _input.LA(1);
						if (_la==PRIVILEGES) {
							{
							setState(1550); match(PRIVILEGES);
							}
						}

						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1555); match(ON);
					setState(1556); match(DATABASE);
					setState(1557); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).database_name.add(((Revoke_statementContext)_localctx).identifier);
					setState(1562);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1558); match(COMMA);
						setState(1559); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).database_name.add(((Revoke_statementContext)_localctx).identifier);
						}
						}
						setState(1564);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1565); revoke_from_cascade_restrict();
					}
					break;
				case 5:
					{
					setState(1572);
					switch (_input.LA(1)) {
					case USAGE:
						{
						setState(1567); match(USAGE);
						}
						break;
					case ALL:
						{
						setState(1568); match(ALL);
						setState(1570);
						_la = _input.LA(1);
						if (_la==PRIVILEGES) {
							{
							setState(1569); match(PRIVILEGES);
							}
						}

						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1613);
					switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
					case 1:
						{
						setState(1574); match(ON);
						setState(1575); match(FOREIGN);
						setState(1576); match(DATA);
						setState(1577); match(WRAPPER);
						setState(1578); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
						((Revoke_statementContext)_localctx).fdw_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
						setState(1583);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1579); match(COMMA);
							setState(1580); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
							((Revoke_statementContext)_localctx).fdw_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
							}
							}
							setState(1585);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1586); revoke_from_cascade_restrict();
						}
						break;
					case 2:
						{
						setState(1588); match(ON);
						setState(1589); match(FOREIGN);
						setState(1590); match(SERVER);
						setState(1591); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).server_name.add(((Revoke_statementContext)_localctx).identifier);
						setState(1596);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1592); match(COMMA);
							setState(1593); ((Revoke_statementContext)_localctx).identifier = identifier();
							((Revoke_statementContext)_localctx).server_name.add(((Revoke_statementContext)_localctx).identifier);
							}
							}
							setState(1598);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1599); revoke_from_cascade_restrict();
						}
						break;
					case 3:
						{
						setState(1601); match(ON);
						setState(1602); match(LANGUAGE);
						setState(1603); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).lang_name.add(((Revoke_statementContext)_localctx).identifier);
						setState(1608);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1604); match(COMMA);
							setState(1605); ((Revoke_statementContext)_localctx).identifier = identifier();
							((Revoke_statementContext)_localctx).lang_name.add(((Revoke_statementContext)_localctx).identifier);
							}
							}
							setState(1610);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1611); revoke_from_cascade_restrict();
						}
						break;
					}
					}
					break;
				case 6:
					{
					setState(1620);
					switch (_input.LA(1)) {
					case EXECUTE:
						{
						setState(1615); match(EXECUTE);
						}
						break;
					case ALL:
						{
						setState(1616); match(ALL);
						setState(1618);
						_la = _input.LA(1);
						if (_la==PRIVILEGES) {
							{
							setState(1617); match(PRIVILEGES);
							}
						}

						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1622); match(ON);
					setState(1625);
					switch (_input.LA(1)) {
					case FUNCTION:
						{
						setState(1623); function_definition();
						}
						break;
					case ALL:
						{
						setState(1624); functions_definition_schema();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1627); revoke_from_cascade_restrict();
					}
					break;
				case 7:
					{
					setState(1642);
					switch (_input.LA(1)) {
					case SELECT:
					case UPDATE:
						{
						setState(1634); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							setState(1634);
							switch (_input.LA(1)) {
							case SELECT:
								{
								setState(1629); match(SELECT);
								}
								break;
							case UPDATE:
								{
								setState(1630); match(UPDATE);
								setState(1632);
								_la = _input.LA(1);
								if (_la==COMMA) {
									{
									setState(1631); match(COMMA);
									}
								}

								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							}
							setState(1636); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==SELECT || _la==UPDATE );
						}
						break;
					case ALL:
						{
						setState(1638); match(ALL);
						setState(1640);
						_la = _input.LA(1);
						if (_la==PRIVILEGES) {
							{
							setState(1639); match(PRIVILEGES);
							}
						}

						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1644); match(ON);
					setState(1645); match(LARGE);
					setState(1646); match(OBJECT);
					setState(1647); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).loid.add(((Revoke_statementContext)_localctx).identifier);
					setState(1652);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1648); match(COMMA);
						setState(1649); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).loid.add(((Revoke_statementContext)_localctx).identifier);
						}
						}
						setState(1654);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1655); revoke_from_cascade_restrict();
					}
					break;
				case 8:
					{
					setState(1669);
					switch (_input.LA(1)) {
					case CREATE:
					case USAGE:
						{
						setState(1661); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1657);
							_la = _input.LA(1);
							if ( !(_la==CREATE || _la==USAGE) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							setState(1659);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1658); match(COMMA);
								}
							}

							}
							}
							setState(1663); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==CREATE || _la==USAGE );
						}
						break;
					case ALL:
						{
						setState(1665); match(ALL);
						setState(1667);
						_la = _input.LA(1);
						if (_la==PRIVILEGES) {
							{
							setState(1666); match(PRIVILEGES);
							}
						}

						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1671); match(ON);
					setState(1672); match(SCHEMA);
					setState(1673); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
					setState(1678);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1674); match(COMMA);
						setState(1675); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
						}
						}
						setState(1680);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1681); revoke_from_cascade_restrict();
					}
					break;
				case 9:
					{
					setState(1688);
					switch (_input.LA(1)) {
					case CREATE:
						{
						setState(1683); match(CREATE);
						}
						break;
					case ALL:
						{
						setState(1684); match(ALL);
						setState(1686);
						_la = _input.LA(1);
						if (_la==PRIVILEGES) {
							{
							setState(1685); match(PRIVILEGES);
							}
						}

						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1690); match(ON);
					setState(1691); match(TABLESPACE);
					setState(1692); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).tablespace_name.add(((Revoke_statementContext)_localctx).identifier);
					setState(1697);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1693); match(COMMA);
						setState(1694); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).tablespace_name.add(((Revoke_statementContext)_localctx).identifier);
						}
						}
						setState(1699);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1700); revoke_from_cascade_restrict();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(1707);
				switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
				case 1:
					{
					setState(1704); match(ADMIN);
					setState(1705); match(OPTION);
					setState(1706); match(FOR);
					}
					break;
				}
				setState(1709); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1714);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1710); match(COMMA);
					setState(1711); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1716);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1717); match(FROM);
				setState(1718); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1723);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1719); match(COMMA);
					setState(1720); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1725);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1727);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(1726);
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
		public IdentifierContext identifier;
		public List<IdentifierContext> role_name = new ArrayList<IdentifierContext>();
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
		enterRule(_localctx, 58, RULE_revoke_from_cascade_restrict);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1731); match(FROM);
			setState(1737);
			switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
			case 1:
				{
				setState(1733);
				_la = _input.LA(1);
				if (_la==GROUP) {
					{
					setState(1732); match(GROUP);
					}
				}

				setState(1735); ((Revoke_from_cascade_restrictContext)_localctx).identifier = identifier();
				((Revoke_from_cascade_restrictContext)_localctx).role_name.add(((Revoke_from_cascade_restrictContext)_localctx).identifier);
				}
				break;
			case 2:
				{
				setState(1736); match(PUBLIC);
				}
				break;
			}
			setState(1749);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1739); match(COMMA);
				setState(1745);
				switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
				case 1:
					{
					setState(1741);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1740); match(GROUP);
						}
					}

					setState(1743); ((Revoke_from_cascade_restrictContext)_localctx).identifier = identifier();
					((Revoke_from_cascade_restrictContext)_localctx).role_name.add(((Revoke_from_cascade_restrictContext)_localctx).identifier);
					}
					break;
				case 2:
					{
					setState(1744); match(PUBLIC);
					}
					break;
				}
				}
				}
				setState(1751);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1753);
			_la = _input.LA(1);
			if (_la==CASCADE || _la==RESTRICT) {
				{
				setState(1752);
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
		public IdentifierContext identifier;
		public List<IdentifierContext> column = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> sequence_name = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> schema_name = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> database_name = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> fdw_name = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> server_name = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> lang_name = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> loid = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> tablespace_name = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> role_name = new ArrayList<IdentifierContext>();
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
		public TerminalNode GRANT() { return getToken(SQLParser.GRANT, 0); }
		public TerminalNode UPDATE(int i) {
			return getToken(SQLParser.UPDATE, i);
		}
		public TerminalNode TRUNCATE(int i) {
			return getToken(SQLParser.TRUNCATE, i);
		}
		public List<TerminalNode> TABLE() { return getTokens(SQLParser.TABLE); }
		public List<TerminalNode> DELETE() { return getTokens(SQLParser.DELETE); }
		public TerminalNode PRIVILEGES() { return getToken(SQLParser.PRIVILEGES, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public List<TerminalNode> ALL() { return getTokens(SQLParser.ALL); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public List<TerminalNode> USAGE() { return getTokens(SQLParser.USAGE); }
		public List<TerminalNode> REFERENCES() { return getTokens(SQLParser.REFERENCES); }
		public List<TerminalNode> TRIGGER() { return getTokens(SQLParser.TRIGGER); }
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
		public TerminalNode EXECUTE() { return getToken(SQLParser.EXECUTE, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode TABLES() { return getToken(SQLParser.TABLES, 0); }
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
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode INSERT(int i) {
			return getToken(SQLParser.INSERT, i);
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
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public TerminalNode SEQUENCES() { return getToken(SQLParser.SEQUENCES, 0); }
		public TerminalNode REFERENCES(int i) {
			return getToken(SQLParser.REFERENCES, i);
		}
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
		enterRule(_localctx, 60, RULE_grant_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1755); match(GRANT);
			setState(2065);
			switch ( getInterpreter().adaptivePredict(_input,262,_ctx) ) {
			case 1:
				{
				setState(1768);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1756);
					_la = _input.LA(1);
					if ( !(_la==DELETE || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (TRIGGER - 104)) | (1L << (TRUNCATE - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1761);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1757); match(COMMA);
						setState(1758);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (TRIGGER - 104)) | (1L << (TRUNCATE - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1763);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ALL:
					{
					setState(1764); match(ALL);
					setState(1766);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1765); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1770); match(ON);
				setState(1794);
				switch (_input.LA(1)) {
				case REPLACE:
				case TABLE:
				case ADMIN:
				case ALWAYS:
				case ARRAY:
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
				case CONCURRENTLY:
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
				case EVENT:
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
				case OVER:
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
				case REGCONFIG:
				case REGEXP:
				case RENAME:
				case REPLICA:
				case RESET:
				case RESTART:
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
				case STDIN:
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
				case TYPES:
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
				case INET:
				case INTERVAL:
				case VOID:
				case DOUBLE_QUOTE:
				case Identifier:
				case QuotedIdentifier:
					{
					{
					setState(1772);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1771); match(TABLE);
						}
					}

					setState(1778); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1774); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
							setState(1776);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1775); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1780); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(1782); match(ALL);
					setState(1783); match(TABLES);
					setState(1784); match(IN);
					setState(1785); match(SCHEMA);
					setState(1790); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1786); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(1788);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1787); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1792); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,216,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1796); grant_to_rule();
				}
				break;
			case 2:
				{
				setState(1823);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1807); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1798);
						_la = _input.LA(1);
						if ( !(((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1799); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
						setState(1804);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1800); match(COMMA);
							setState(1801); ((Grant_statementContext)_localctx).identifier = identifier();
							((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
							}
							}
							setState(1806);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						setState(1809); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (REFERENCES - 104)) | (1L << (SELECT - 104)) | (1L << (UPDATE - 104)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1811); match(ALL);
					setState(1813);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1812); match(PRIVILEGES);
						}
					}

					setState(1815); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
					setState(1820);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1816); match(COMMA);
						setState(1817); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
						}
						}
						setState(1822);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1825); match(ON);
				setState(1833); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1827);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1826); match(TABLE);
							}
						}

						setState(1829); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
						setState(1831);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1830); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1835); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,225,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1837); grant_to_rule();
				}
				break;
			case 3:
				{
				setState(1851);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					{
					setState(1839);
					_la = _input.LA(1);
					if ( !(((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (SELECT - 114)) | (1L << (UPDATE - 114)) | (1L << (USAGE - 114)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1844);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1840); match(COMMA);
						setState(1841);
						_la = _input.LA(1);
						if ( !(((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (SELECT - 114)) | (1L << (UPDATE - 114)) | (1L << (USAGE - 114)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1846);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(1847); match(ALL);
					setState(1849);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1848); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1853); match(ON);
				setState(1879);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1863); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1854); match(SEQUENCE);
						setState(1855); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).sequence_name.add(((Grant_statementContext)_localctx).identifier);
						setState(1860);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1856); match(COMMA);
							setState(1857); ((Grant_statementContext)_localctx).identifier = identifier();
							((Grant_statementContext)_localctx).sequence_name.add(((Grant_statementContext)_localctx).identifier);
							}
							}
							setState(1862);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						setState(1865); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(1867); match(ALL);
					setState(1868); match(SEQUENCES);
					setState(1869); match(IN);
					setState(1870); match(SCHEMA);
					setState(1871); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
					setState(1876);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1872); match(COMMA);
						setState(1873); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
						}
						}
						setState(1878);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1881); grant_to_rule();
				}
				break;
			case 4:
				{
				setState(1895);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1883);
					_la = _input.LA(1);
					if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1888);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1884); match(COMMA);
						setState(1885);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1890);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ALL:
					{
					setState(1891); match(ALL);
					setState(1893);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1892); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1897); match(ON);
				setState(1898); match(DATABASE);
				setState(1899); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).database_name.add(((Grant_statementContext)_localctx).identifier);
				setState(1904);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1900); match(COMMA);
					setState(1901); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).database_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(1906);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1907); grant_to_rule();
				}
				break;
			case 5:
				{
				setState(1914);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1909); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1910); match(ALL);
					setState(1912);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1911); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1955);
				switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
				case 1:
					{
					setState(1916); match(ON);
					setState(1917); match(FOREIGN);
					setState(1918); match(DATA);
					setState(1919); match(WRAPPER);
					setState(1920); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).fdw_name.add(((Grant_statementContext)_localctx).identifier);
					setState(1925);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1921); match(COMMA);
						setState(1922); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).fdw_name.add(((Grant_statementContext)_localctx).identifier);
						}
						}
						setState(1927);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1928); grant_to_rule();
					}
					break;
				case 2:
					{
					setState(1930); match(ON);
					setState(1931); match(FOREIGN);
					setState(1932); match(SERVER);
					setState(1933); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).server_name.add(((Grant_statementContext)_localctx).identifier);
					setState(1938);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1934); match(COMMA);
						setState(1935); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).server_name.add(((Grant_statementContext)_localctx).identifier);
						}
						}
						setState(1940);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1941); grant_to_rule();
					}
					break;
				case 3:
					{
					setState(1943); match(ON);
					setState(1944); match(LANGUAGE);
					setState(1945); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).lang_name.add(((Grant_statementContext)_localctx).identifier);
					setState(1950);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1946); match(COMMA);
						setState(1947); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).lang_name.add(((Grant_statementContext)_localctx).identifier);
						}
						}
						setState(1952);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1953); grant_to_rule();
					}
					break;
				}
				}
				break;
			case 6:
				{
				setState(1962);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1957); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1958); match(ALL);
					setState(1960);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1959); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1964); match(ON);
				setState(1967);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1965); function_definition();
					}
					break;
				case ALL:
					{
					setState(1966); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1969); grant_to_rule();
				}
				break;
			case 7:
				{
				setState(1983);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1975); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1971);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1973);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1972); match(COMMA);
							}
						}

						}
						}
						setState(1977); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1979); match(ALL);
					setState(1981);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1980); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1985); match(ON);
				setState(1986); match(LARGE);
				setState(1987); match(OBJECT);
				setState(1988); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).loid.add(((Grant_statementContext)_localctx).identifier);
				setState(1993);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1989); match(COMMA);
					setState(1990); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).loid.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(1995);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1996); grant_to_rule();
				}
				break;
			case 8:
				{
				setState(2010);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(2002); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1998);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(2000);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1999); match(COMMA);
							}
						}

						}
						}
						setState(2004); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(2006); match(ALL);
					setState(2008);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2007); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2012); match(ON);
				setState(2013); match(SCHEMA);
				setState(2014); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2019);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2015); match(COMMA);
					setState(2016); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2021);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2022); grant_to_rule();
				}
				break;
			case 9:
				{
				setState(2029);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(2024); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(2025); match(ALL);
					setState(2027);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2026); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2031); match(ON);
				setState(2032); match(TABLESPACE);
				setState(2033); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).tablespace_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2038);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2034); match(COMMA);
					setState(2035); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).tablespace_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2040);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2041); grant_to_rule();
				}
				break;
			case 10:
				{
				setState(2043); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2048);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2044); match(COMMA);
					setState(2045); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2050);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2051); match(TO);
				setState(2052); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2057);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2053); match(COMMA);
					setState(2054); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2059);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2063);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(2060); match(WITH);
					setState(2061); match(ADMIN);
					setState(2062); match(OPTION);
					}
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

	public static class Grant_to_ruleContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public List<IdentifierContext> role_name = new ArrayList<IdentifierContext>();
		public List<TerminalNode> PUBLIC() { return getTokens(SQLParser.PUBLIC); }
		public TerminalNode GROUP(int i) {
			return getToken(SQLParser.GROUP, i);
		}
		public TerminalNode PUBLIC(int i) {
			return getToken(SQLParser.PUBLIC, i);
		}
		public TerminalNode GRANT() { return getToken(SQLParser.GRANT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
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
		enterRule(_localctx, 62, RULE_grant_to_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2067); match(TO);
			setState(2073);
			switch ( getInterpreter().adaptivePredict(_input,264,_ctx) ) {
			case 1:
				{
				setState(2069);
				_la = _input.LA(1);
				if (_la==GROUP) {
					{
					setState(2068); match(GROUP);
					}
				}

				{
				setState(2071); ((Grant_to_ruleContext)_localctx).identifier = identifier();
				((Grant_to_ruleContext)_localctx).role_name.add(((Grant_to_ruleContext)_localctx).identifier);
				}
				}
				break;
			case 2:
				{
				setState(2072); match(PUBLIC);
				}
				break;
			}
			setState(2085);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2075); match(COMMA);
				setState(2081);
				switch ( getInterpreter().adaptivePredict(_input,266,_ctx) ) {
				case 1:
					{
					setState(2077);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(2076); match(GROUP);
						}
					}

					{
					setState(2079); ((Grant_to_ruleContext)_localctx).identifier = identifier();
					((Grant_to_ruleContext)_localctx).role_name.add(((Grant_to_ruleContext)_localctx).identifier);
					}
					}
					break;
				case 2:
					{
					setState(2080); match(PUBLIC);
					}
					break;
				}
				}
				}
				setState(2087);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2091);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2088); match(WITH);
				setState(2089); match(GRANT);
				setState(2090); match(OPTION);
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
		public Data_typeContext data_type;
		public List<Data_typeContext> agg_type = new ArrayList<Data_typeContext>();
		public Data_typeContext source_type;
		public Data_typeContext target_type;
		public Schema_qualified_nameContext object_name;
		public Schema_qualified_nameContext table_name;
		public Schema_qualified_nameContext operator_name;
		public Data_typeContext left_type;
		public Data_typeContext right_type;
		public IdentifierContext index_method;
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
		public TerminalNode TRIGGER() { return getToken(SQLParser.TRIGGER, 0); }
		public TerminalNode RULE() { return getToken(SQLParser.RULE, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
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
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
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
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
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
		enterRule(_localctx, 64, RULE_comment_on_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2093); match(COMMENT);
			setState(2094); match(ON);
			setState(2156);
			switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
			case 1:
				{
				setState(2095); match(AGGREGATE);
				setState(2096); ((Comment_on_statementContext)_localctx).agg_name = schema_qualified_name();
				setState(2097); match(LEFT_PAREN);
				setState(2106);
				_la = _input.LA(1);
				if (((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (SETOF - 105)) | (1L << (TRIGGER - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (REGCLASS - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (BINARY - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0)) {
					{
					setState(2098); ((Comment_on_statementContext)_localctx).data_type = data_type();
					((Comment_on_statementContext)_localctx).agg_type.add(((Comment_on_statementContext)_localctx).data_type);
					setState(2103);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2099); match(COMMA);
						setState(2100); ((Comment_on_statementContext)_localctx).data_type = data_type();
						((Comment_on_statementContext)_localctx).agg_type.add(((Comment_on_statementContext)_localctx).data_type);
						}
						}
						setState(2105);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(2108); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(2110); match(CAST);
				setState(2111); match(LEFT_PAREN);
				setState(2112); ((Comment_on_statementContext)_localctx).source_type = data_type();
				setState(2113); match(AS);
				setState(2114); ((Comment_on_statementContext)_localctx).target_type = data_type();
				setState(2115); match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(2117);
				_la = _input.LA(1);
				if ( !(_la==CONSTRAINT || _la==RULE || _la==TRIGGER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2118); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(2119); match(ON);
				setState(2120); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 4:
				{
				setState(2122); function_definition();
				}
				break;
			case 5:
				{
				setState(2123); match(OPERATOR);
				setState(2124); ((Comment_on_statementContext)_localctx).operator_name = schema_qualified_name();
				setState(2125); match(LEFT_PAREN);
				setState(2126); ((Comment_on_statementContext)_localctx).left_type = data_type();
				setState(2127); match(COMMA);
				setState(2128); ((Comment_on_statementContext)_localctx).right_type = data_type();
				setState(2129); match(RIGHT_PAREN);
				}
				break;
			case 6:
				{
				setState(2131); match(OPERATOR);
				setState(2132);
				_la = _input.LA(1);
				if ( !(_la==CLASS || _la==FAMILY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2133); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(2134); match(USING);
				setState(2135); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 7:
				{
				setState(2153);
				switch (_input.LA(1)) {
				case TEXT:
					{
					setState(2137); match(TEXT);
					setState(2138); match(SEARCH);
					setState(2139);
					_la = _input.LA(1);
					if ( !(_la==CONFIGURATION || _la==DICTIONARY || _la==PARSER || _la==TEMPLATE) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case PROCEDURAL:
				case LANGUAGE:
					{
					setState(2141);
					_la = _input.LA(1);
					if (_la==PROCEDURAL) {
						{
						setState(2140); match(PROCEDURAL);
						}
					}

					setState(2143); match(LANGUAGE);
					}
					break;
				case LARGE:
					{
					setState(2144); match(LARGE);
					setState(2145); match(OBJECT);
					}
					break;
				case FOREIGN:
					{
					setState(2146); match(FOREIGN);
					setState(2150);
					switch (_input.LA(1)) {
					case DATA:
						{
						setState(2147); match(DATA);
						setState(2148); match(WRAPPER);
						}
						break;
					case TABLE:
						{
						setState(2149); match(TABLE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case COLLATION:
				case CONVERSION:
				case DATABASE:
				case DOMAIN:
				case EXTENSION:
				case ROLE:
				case SCHEMA:
				case SEQUENCE:
				case TABLE:
				case VIEW:
				case COLUMN:
				case INDEX:
				case SERVER:
				case TABLESPACE:
				case TYPE:
					{
					setState(2152);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COLLATION) | (1L << CONVERSION) | (1L << DATABASE) | (1L << DOMAIN) | (1L << EXTENSION))) != 0) || ((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (ROLE - 101)) | (1L << (SCHEMA - 101)) | (1L << (SEQUENCE - 101)) | (1L << (TABLE - 101)) | (1L << (VIEW - 101)) | (1L << (COLUMN - 101)))) != 0) || _la==INDEX || _la==SERVER || _la==TABLESPACE || _la==TYPE) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2155); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			}
			setState(2158); match(IS);
			setState(2159); match(Character_String_Literal);
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
		public Value_expressionContext rettype;
		public Data_typeContext rettype_data;
		public IdentifierContext lang_name;
		public Token execution_cost;
		public Token result_rows;
		public IdentifierContext configuration_parameter;
		public IdentifierContext value;
		public Function_attributeContext function_attribute;
		public List<Function_attributeContext> attribute = new ArrayList<Function_attributeContext>();
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
		public List<TerminalNode> COST() { return getTokens(SQLParser.COST); }
		public TerminalNode STABLE(int i) {
			return getToken(SQLParser.STABLE, i);
		}
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public List<TerminalNode> TO() { return getTokens(SQLParser.TO); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public List<Function_column_name_typeContext> function_column_name_type() {
			return getRuleContexts(Function_column_name_typeContext.class);
		}
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
		public Function_column_name_typeContext function_column_name_type(int i) {
			return getRuleContext(Function_column_name_typeContext.class,i);
		}
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
		public List<TerminalNode> NULL() { return getTokens(SQLParser.NULL); }
		public TerminalNode LANGUAGE(int i) {
			return getToken(SQLParser.LANGUAGE, i);
		}
		public List<TerminalNode> SET() { return getTokens(SQLParser.SET); }
		public List<TerminalNode> AS() { return getTokens(SQLParser.AS); }
		public Function_attributeContext function_attribute(int i) {
			return getRuleContext(Function_attributeContext.class,i);
		}
		public List<TerminalNode> INPUT() { return getTokens(SQLParser.INPUT); }
		public TerminalNode IMMUTABLE(int i) {
			return getToken(SQLParser.IMMUTABLE, i);
		}
		public List<TerminalNode> VOLATILE() { return getTokens(SQLParser.VOLATILE); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public List<TerminalNode> ON() { return getTokens(SQLParser.ON); }
		public TerminalNode Character_String_Literal(int i) {
			return getToken(SQLParser.Character_String_Literal, i);
		}
		public TerminalNode COST(int i) {
			return getToken(SQLParser.COST, i);
		}
		public List<TerminalNode> STABLE() { return getTokens(SQLParser.STABLE); }
		public List<TerminalNode> STRICT() { return getTokens(SQLParser.STRICT); }
		public List<TerminalNode> CALLED() { return getTokens(SQLParser.CALLED); }
		public List<TerminalNode> NUMBER() { return getTokens(SQLParser.NUMBER); }
		public List<TerminalNode> LANGUAGE() { return getTokens(SQLParser.LANGUAGE); }
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> IMMUTABLE() { return getTokens(SQLParser.IMMUTABLE); }
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public List<TerminalNode> FROM() { return getTokens(SQLParser.FROM); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
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
		public List<TerminalNode> SECURITY() { return getTokens(SQLParser.SECURITY); }
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
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
		enterRule(_localctx, 66, RULE_create_function_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2163);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(2161); match(OR);
				setState(2162); match(REPLACE);
				}
			}

			setState(2165); match(FUNCTION);
			setState(2166); function_parameters();
			setState(2185);
			switch ( getInterpreter().adaptivePredict(_input,278,_ctx) ) {
			case 1:
				{
				setState(2167); match(RETURNS);
				setState(2170);
				switch ( getInterpreter().adaptivePredict(_input,276,_ctx) ) {
				case 1:
					{
					setState(2168); ((Create_function_statementContext)_localctx).rettype = value_expression();
					}
					break;
				case 2:
					{
					setState(2169); ((Create_function_statementContext)_localctx).rettype_data = data_type();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(2172); match(RETURNS);
				setState(2173); match(TABLE);
				setState(2174); match(LEFT_PAREN);
				setState(2175); function_column_name_type();
				setState(2180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2176); match(COMMA);
					setState(2177); function_column_name_type();
					}
					}
					setState(2182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2183); match(RIGHT_PAREN);
				}
				break;
			}
			setState(2236); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(2236);
				switch ( getInterpreter().adaptivePredict(_input,283,_ctx) ) {
				case 1:
					{
					setState(2187); match(LANGUAGE);
					setState(2188); ((Create_function_statementContext)_localctx).lang_name = identifier();
					}
					break;
				case 2:
					{
					setState(2189);
					_la = _input.LA(1);
					if ( !(_la==IMMUTABLE || _la==STRICT || ((((_la - 260)) & ~0x3f) == 0 && ((1L << (_la - 260)) & ((1L << (STABLE - 260)) | (1L << (VOLATILE - 260)) | (1L << (WINDOW - 260)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case 3:
					{
					setState(2190); match(CALLED);
					setState(2191); match(ON);
					setState(2192); match(NULL);
					setState(2193); match(INPUT);
					}
					break;
				case 4:
					{
					setState(2194); match(RETURNS);
					setState(2195); match(NULL);
					setState(2196); match(ON);
					setState(2197); match(NULL);
					setState(2198); match(INPUT);
					}
					break;
				case 5:
					{
					setState(2200);
					_la = _input.LA(1);
					if (_la==EXTERNAL) {
						{
						setState(2199); match(EXTERNAL);
						}
					}

					setState(2202); match(SECURITY);
					setState(2203);
					_la = _input.LA(1);
					if ( !(_la==INVOKER || _la==DEFINER) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case 6:
					{
					setState(2204); match(COST);
					setState(2205); ((Create_function_statementContext)_localctx).execution_cost = match(NUMBER);
					}
					break;
				case 7:
					{
					setState(2206); match(ROWS);
					setState(2207); ((Create_function_statementContext)_localctx).result_rows = match(NUMBER);
					}
					break;
				case 8:
					{
					setState(2208); match(SET);
					setState(2209); ((Create_function_statementContext)_localctx).configuration_parameter = identifier();
					setState(2216);
					switch (_input.LA(1)) {
					case TO:
						{
						setState(2210); match(TO);
						setState(2211); ((Create_function_statementContext)_localctx).value = identifier();
						}
						break;
					case EQUAL:
						{
						setState(2212); match(EQUAL);
						setState(2213); ((Create_function_statementContext)_localctx).value = identifier();
						}
						break;
					case FROM:
						{
						setState(2214); match(FROM);
						setState(2215); match(CURRENT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2222);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2218); match(COMMA);
						setState(2219); ((Create_function_statementContext)_localctx).value = identifier();
						}
						}
						setState(2224);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 9:
					{
					setState(2225); match(AS);
					setState(2226); function_body();
					}
					break;
				case 10:
					{
					setState(2227); match(AS);
					setState(2228); match(Character_String_Literal);
					setState(2233);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2229); match(COMMA);
						setState(2230); match(Character_String_Literal);
						}
						}
						setState(2235);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				}
				setState(2238); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AS || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IMMUTABLE - 64)) | (1L << (ROWS - 64)) | (1L << (RETURNS - 64)) | (1L << (STRICT - 64)))) != 0) || ((((_la - 149)) & ~0x3f) == 0 && ((1L << (_la - 149)) & ((1L << (CALLED - 149)) | (1L << (COST - 149)) | (1L << (EXTERNAL - 149)) | (1L << (LANGUAGE - 149)))) != 0) || ((((_la - 255)) & ~0x3f) == 0 && ((1L << (_la - 255)) & ((1L << (SECURITY - 255)) | (1L << (SET - 255)) | (1L << (STABLE - 255)) | (1L << (VOLATILE - 255)) | (1L << (WINDOW - 255)))) != 0) );
			setState(2252);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2240); match(WITH);
				setState(2241); match(LEFT_PAREN);
				setState(2242); ((Create_function_statementContext)_localctx).function_attribute = function_attribute();
				((Create_function_statementContext)_localctx).attribute.add(((Create_function_statementContext)_localctx).function_attribute);
				setState(2247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2243); match(COMMA);
					setState(2244); ((Create_function_statementContext)_localctx).function_attribute = function_attribute();
					((Create_function_statementContext)_localctx).attribute.add(((Create_function_statementContext)_localctx).function_attribute);
					}
					}
					setState(2249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2250); match(RIGHT_PAREN);
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

	public static class Function_column_name_typeContext extends ParserRuleContext {
		public IdentifierContext column_name;
		public Data_typeContext column_type;
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Function_column_name_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_column_name_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_column_name_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_column_name_type(this);
		}
	}

	public final Function_column_name_typeContext function_column_name_type() throws RecognitionException {
		Function_column_name_typeContext _localctx = new Function_column_name_typeContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_function_column_name_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2254); ((Function_column_name_typeContext)_localctx).column_name = identifier();
			setState(2255); ((Function_column_name_typeContext)_localctx).column_type = data_type();
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
		public Schema_qualified_nameContext name;
		public List<Function_argumentsContext> function_arguments() {
			return getRuleContexts(Function_argumentsContext.class);
		}
		public Function_def_valueContext function_def_value(int i) {
			return getRuleContext(Function_def_valueContext.class,i);
		}
		public List<Function_def_valueContext> function_def_value() {
			return getRuleContexts(Function_def_valueContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Function_argumentsContext function_arguments(int i) {
			return getRuleContext(Function_argumentsContext.class,i);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
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
		enterRule(_localctx, 70, RULE_function_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2257); ((Function_parametersContext)_localctx).name = schema_qualified_name();
			setState(2258); match(LEFT_PAREN);
			setState(2273);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (IN - 65)) | (1L << (INOUT - 65)) | (1L << (NOT - 65)) | (1L << (NULL - 65)) | (1L << (OUT - 65)) | (1L << (REPLACE - 65)) | (1L << (SELECT - 65)) | (1L << (SETOF - 65)) | (1L << (SOME - 65)) | (1L << (TRIGGER - 65)) | (1L << (TRUE - 65)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (VARIADIC - 136)) | (1L << (ADMIN - 136)) | (1L << (ALWAYS - 136)) | (1L << (ARRAY - 136)) | (1L << (AVG - 136)) | (1L << (BETWEEN - 136)) | (1L << (BY - 136)) | (1L << (CACHE - 136)) | (1L << (CALLED - 136)) | (1L << (CLASS - 136)) | (1L << (CENTURY - 136)) | (1L << (CHARACTER - 136)) | (1L << (CHECK - 136)) | (1L << (CLUSTER - 136)) | (1L << (COLLECT - 136)) | (1L << (COALESCE - 136)) | (1L << (COLUMN - 136)) | (1L << (COMMENT - 136)) | (1L << (COMMENTS - 136)) | (1L << (COMMIT - 136)) | (1L << (CONCURRENTLY - 136)) | (1L << (CONFIGURATION - 136)) | (1L << (COST - 136)) | (1L << (COUNT - 136)) | (1L << (CUBE - 136)) | (1L << (CURRENT - 136)) | (1L << (CYCLE - 136)) | (1L << (DATA - 136)) | (1L << (DAY - 136)) | (1L << (DEC - 136)) | (1L << (DECADE - 136)) | (1L << (DEFINER - 136)) | (1L << (DICTIONARY - 136)) | (1L << (DISABLE - 136)) | (1L << (DOW - 136)) | (1L << (DOY - 136)) | (1L << (DROP - 136)) | (1L << (ENABLE - 136)) | (1L << (EPOCH - 136)) | (1L << (EVENT - 136)) | (1L << (EVERY - 136)) | (1L << (EXISTS - 136)) | (1L << (EXTENDED - 136)) | (1L << (EXTERNAL - 136)) | (1L << (EXTRACT - 136)) | (1L << (FAMILY - 136)) | (1L << (FILTER - 136)) | (1L << (FIRST - 136)) | (1L << (FORMAT - 136)) | (1L << (FUSION - 136)) | (1L << (GROUPING - 136)) | (1L << (HASH - 136)) | (1L << (INHERIT - 136)) | (1L << (INDEX - 136)) | (1L << (INCREMENT - 136)) | (1L << (INPUT - 136)) | (1L << (INSERT - 136)))) != 0) || ((((_la - 200)) & ~0x3f) == 0 && ((1L << (_la - 200)) & ((1L << (INTERSECTION - 200)) | (1L << (ISCACHABLE - 200)) | (1L << (ISODOW - 200)) | (1L << (ISOYEAR - 200)) | (1L << (ISSTRICT - 200)) | (1L << (LANGUAGE - 200)) | (1L << (LARGE - 200)) | (1L << (LAST - 200)) | (1L << (LESS - 200)) | (1L << (LIST - 200)) | (1L << (LOCATION - 200)) | (1L << (MAIN - 200)) | (1L << (MATCH - 200)) | (1L << (MAX - 200)) | (1L << (MAXVALUE - 200)) | (1L << (MICROSECONDS - 200)) | (1L << (MILLENNIUM - 200)) | (1L << (MILLISECONDS - 200)) | (1L << (MIN - 200)) | (1L << (MINVALUE - 200)) | (1L << (MINUTE - 200)) | (1L << (MONTH - 200)) | (1L << (NATIONAL - 200)) | (1L << (NO - 200)) | (1L << (NONE - 200)) | (1L << (NULLIF - 200)) | (1L << (OBJECT - 200)) | (1L << (ON - 200)) | (1L << (ONLY - 200)) | (1L << (OPTION - 200)) | (1L << (OPTIONS - 200)) | (1L << (OVER - 200)) | (1L << (OVERWRITE - 200)) | (1L << (PARSER - 200)) | (1L << (PARTIAL - 200)) | (1L << (PARTITION - 200)) | (1L << (PARTITIONS - 200)) | (1L << (PLAIN - 200)) | (1L << (PRECISION - 200)) | (1L << (PUBLIC - 200)) | (1L << (PURGE - 200)) | (1L << (QUARTER - 200)) | (1L << (RANGE - 200)) | (1L << (REGCONFIG - 200)) | (1L << (REGEXP - 200)) | (1L << (RENAME - 200)) | (1L << (REPLICA - 200)) | (1L << (RESET - 200)) | (1L << (RESTART - 200)) | (1L << (RLIKE - 200)) | (1L << (ROLLUP - 200)) | (1L << (SEARCH - 200)) | (1L << (SECOND - 200)) | (1L << (SECURITY - 200)) | (1L << (SERVER - 200)) | (1L << (SET - 200)) | (1L << (SIMILAR - 200)) | (1L << (SIMPLE - 200)) | (1L << (STABLE - 200)) | (1L << (START - 200)) | (1L << (STATISTICS - 200)) | (1L << (STDIN - 200)))) != 0) || ((((_la - 264)) & ~0x3f) == 0 && ((1L << (_la - 264)) & ((1L << (STORAGE - 264)) | (1L << (STDDEV_POP - 264)) | (1L << (STDDEV_SAMP - 264)) | (1L << (SUBPARTITION - 264)) | (1L << (SUM - 264)) | (1L << (TABLESPACE - 264)) | (1L << (TEMPLATE - 264)) | (1L << (THAN - 264)) | (1L << (TIMEZONE - 264)) | (1L << (TIMEZONE_HOUR - 264)) | (1L << (TIMEZONE_MINUTE - 264)) | (1L << (TRIM - 264)) | (1L << (TO - 264)) | (1L << (TYPE - 264)) | (1L << (TYPES - 264)) | (1L << (UNKNOWN - 264)) | (1L << (UNLOGGED - 264)) | (1L << (USER - 264)) | (1L << (VALID - 264)) | (1L << (VALIDATE - 264)) | (1L << (VALUES - 264)) | (1L << (VAR_SAMP - 264)) | (1L << (VAR_POP - 264)) | (1L << (VARYING - 264)) | (1L << (VERSION - 264)) | (1L << (VOLATILE - 264)) | (1L << (WEEK - 264)) | (1L << (WINDOW - 264)) | (1L << (WRAPPER - 264)) | (1L << (YEAR - 264)) | (1L << (ZONE - 264)) | (1L << (BOOLEAN - 264)) | (1L << (BOOL - 264)) | (1L << (BIT - 264)) | (1L << (VARBIT - 264)) | (1L << (INT1 - 264)) | (1L << (INT2 - 264)) | (1L << (INT4 - 264)) | (1L << (INT8 - 264)) | (1L << (TINYINT - 264)) | (1L << (SMALLINT - 264)) | (1L << (INT - 264)) | (1L << (INTEGER - 264)) | (1L << (BIGINT - 264)) | (1L << (FLOAT4 - 264)) | (1L << (FLOAT8 - 264)) | (1L << (REAL - 264)) | (1L << (REGCLASS - 264)) | (1L << (FLOAT - 264)) | (1L << (DOUBLE - 264)) | (1L << (NUMERIC - 264)) | (1L << (DECIMAL - 264)) | (1L << (CHAR - 264)) | (1L << (VARCHAR - 264)) | (1L << (NCHAR - 264)) | (1L << (NVARCHAR - 264)) | (1L << (DATE - 264)) | (1L << (TIME - 264)) | (1L << (TIMETZ - 264)) | (1L << (TIMESTAMP - 264)) | (1L << (TIMESTAMPTZ - 264)) | (1L << (TEXT - 264)) | (1L << (UUID - 264)))) != 0) || ((((_la - 328)) & ~0x3f) == 0 && ((1L << (_la - 328)) & ((1L << (BINARY - 328)) | (1L << (VARBINARY - 328)) | (1L << (BLOB - 328)) | (1L << (BYTEA - 328)) | (1L << (INET4 - 328)) | (1L << (INET - 328)) | (1L << (INTERVAL - 328)) | (1L << (VOID - 328)) | (1L << (LEFT_PAREN - 328)) | (1L << (PLUS - 328)) | (1L << (MINUS - 328)) | (1L << (DOUBLE_QUOTE - 328)) | (1L << (NUMBER - 328)) | (1L << (REAL_NUMBER - 328)) | (1L << (Identifier - 328)) | (1L << (QuotedIdentifier - 328)) | (1L << (Character_String_Literal - 328)))) != 0)) {
				{
				setState(2259); function_arguments();
				setState(2261);
				_la = _input.LA(1);
				if (_la==DEFAULT || _la==EQUAL) {
					{
					setState(2260); function_def_value();
					}
				}

				setState(2270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2263); match(COMMA);
					setState(2264); function_arguments();
					setState(2266);
					_la = _input.LA(1);
					if (_la==DEFAULT || _la==EQUAL) {
						{
						setState(2265); function_def_value();
						}
					}

					}
					}
					setState(2272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(2275); match(RIGHT_PAREN);
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

	public static class Function_def_valueContext extends ParserRuleContext {
		public Value_expressionContext def_value;
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public Function_def_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_def_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_def_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_def_value(this);
		}
	}

	public final Function_def_valueContext function_def_value() throws RecognitionException {
		Function_def_valueContext _localctx = new Function_def_valueContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_function_def_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2277);
			_la = _input.LA(1);
			if ( !(_la==DEFAULT || _la==EQUAL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(2278); ((Function_def_valueContext)_localctx).def_value = value_expression();
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
		public TerminalNode BeginDollarStringConstant() { return getToken(SQLParser.BeginDollarStringConstant, 0); }
		public TerminalNode EndDollarStringConstant() { return getToken(SQLParser.EndDollarStringConstant, 0); }
		public List<TerminalNode> Text_between_Dollar() { return getTokens(SQLParser.Text_between_Dollar); }
		public TerminalNode Text_between_Dollar(int i) {
			return getToken(SQLParser.Text_between_Dollar, i);
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
		enterRule(_localctx, 74, RULE_function_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2280); match(BeginDollarStringConstant);
			setState(2282); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2281); match(Text_between_Dollar);
				}
				}
				setState(2284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Text_between_Dollar );
			setState(2286); match(EndDollarStringConstant);
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

	public static class Function_argumentsContext extends ParserRuleContext {
		public ArgmodeContext arg_mode;
		public IdentifierContext argname;
		public Data_typeContext argtype_data;
		public Value_expressionContext argtype_expres;
		public Schema_qualified_nameContext argtype_schema;
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public ArgmodeContext argmode() {
			return getRuleContext(ArgmodeContext.class,0);
		}
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Function_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_arguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_arguments(this);
		}
	}

	public final Function_argumentsContext function_arguments() throws RecognitionException {
		Function_argumentsContext _localctx = new Function_argumentsContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_function_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2289);
			_la = _input.LA(1);
			if (((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (IN - 65)) | (1L << (INOUT - 65)) | (1L << (OUT - 65)))) != 0) || _la==VARIADIC) {
				{
				setState(2288); ((Function_argumentsContext)_localctx).arg_mode = argmode();
				}
			}

			setState(2292);
			switch ( getInterpreter().adaptivePredict(_input,293,_ctx) ) {
			case 1:
				{
				setState(2291); ((Function_argumentsContext)_localctx).argname = identifier();
				}
				break;
			}
			setState(2297);
			switch ( getInterpreter().adaptivePredict(_input,294,_ctx) ) {
			case 1:
				{
				setState(2294); ((Function_argumentsContext)_localctx).argtype_data = data_type();
				}
				break;
			case 2:
				{
				setState(2295); ((Function_argumentsContext)_localctx).argtype_expres = value_expression();
				}
				break;
			case 3:
				{
				setState(2296); ((Function_argumentsContext)_localctx).argtype_schema = schema_qualified_name();
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
		enterRule(_localctx, 78, RULE_function_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2299);
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
		enterRule(_localctx, 80, RULE_argmode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2301);
			_la = _input.LA(1);
			if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (IN - 65)) | (1L << (INOUT - 65)) | (1L << (OUT - 65)))) != 0) || _la==VARIADIC) ) {
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
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
		public Function_definition_name_parenContext function_definition_name_paren() {
			return getRuleContext(Function_definition_name_parenContext.class,0);
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
		enterRule(_localctx, 82, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2303); match(FUNCTION);
			setState(2304); function_definition_name_paren();
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

	public static class Function_definition_name_parenContext extends ParserRuleContext {
		public Schema_qualified_nameContext func_name;
		public List<Function_argumentsContext> function_arguments() {
			return getRuleContexts(Function_argumentsContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Function_argumentsContext function_arguments(int i) {
			return getRuleContext(Function_argumentsContext.class,i);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Function_definition_name_parenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition_name_paren; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunction_definition_name_paren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunction_definition_name_paren(this);
		}
	}

	public final Function_definition_name_parenContext function_definition_name_paren() throws RecognitionException {
		Function_definition_name_parenContext _localctx = new Function_definition_name_parenContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_function_definition_name_paren);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2306); ((Function_definition_name_parenContext)_localctx).func_name = schema_qualified_name();
			setState(2307); match(LEFT_PAREN);
			setState(2316);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (IN - 65)) | (1L << (INOUT - 65)) | (1L << (NOT - 65)) | (1L << (NULL - 65)) | (1L << (OUT - 65)) | (1L << (REPLACE - 65)) | (1L << (SELECT - 65)) | (1L << (SETOF - 65)) | (1L << (SOME - 65)) | (1L << (TRIGGER - 65)) | (1L << (TRUE - 65)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (VARIADIC - 136)) | (1L << (ADMIN - 136)) | (1L << (ALWAYS - 136)) | (1L << (ARRAY - 136)) | (1L << (AVG - 136)) | (1L << (BETWEEN - 136)) | (1L << (BY - 136)) | (1L << (CACHE - 136)) | (1L << (CALLED - 136)) | (1L << (CLASS - 136)) | (1L << (CENTURY - 136)) | (1L << (CHARACTER - 136)) | (1L << (CHECK - 136)) | (1L << (CLUSTER - 136)) | (1L << (COLLECT - 136)) | (1L << (COALESCE - 136)) | (1L << (COLUMN - 136)) | (1L << (COMMENT - 136)) | (1L << (COMMENTS - 136)) | (1L << (COMMIT - 136)) | (1L << (CONCURRENTLY - 136)) | (1L << (CONFIGURATION - 136)) | (1L << (COST - 136)) | (1L << (COUNT - 136)) | (1L << (CUBE - 136)) | (1L << (CURRENT - 136)) | (1L << (CYCLE - 136)) | (1L << (DATA - 136)) | (1L << (DAY - 136)) | (1L << (DEC - 136)) | (1L << (DECADE - 136)) | (1L << (DEFINER - 136)) | (1L << (DICTIONARY - 136)) | (1L << (DISABLE - 136)) | (1L << (DOW - 136)) | (1L << (DOY - 136)) | (1L << (DROP - 136)) | (1L << (ENABLE - 136)) | (1L << (EPOCH - 136)) | (1L << (EVENT - 136)) | (1L << (EVERY - 136)) | (1L << (EXISTS - 136)) | (1L << (EXTENDED - 136)) | (1L << (EXTERNAL - 136)) | (1L << (EXTRACT - 136)) | (1L << (FAMILY - 136)) | (1L << (FILTER - 136)) | (1L << (FIRST - 136)) | (1L << (FORMAT - 136)) | (1L << (FUSION - 136)) | (1L << (GROUPING - 136)) | (1L << (HASH - 136)) | (1L << (INHERIT - 136)) | (1L << (INDEX - 136)) | (1L << (INCREMENT - 136)) | (1L << (INPUT - 136)) | (1L << (INSERT - 136)))) != 0) || ((((_la - 200)) & ~0x3f) == 0 && ((1L << (_la - 200)) & ((1L << (INTERSECTION - 200)) | (1L << (ISCACHABLE - 200)) | (1L << (ISODOW - 200)) | (1L << (ISOYEAR - 200)) | (1L << (ISSTRICT - 200)) | (1L << (LANGUAGE - 200)) | (1L << (LARGE - 200)) | (1L << (LAST - 200)) | (1L << (LESS - 200)) | (1L << (LIST - 200)) | (1L << (LOCATION - 200)) | (1L << (MAIN - 200)) | (1L << (MATCH - 200)) | (1L << (MAX - 200)) | (1L << (MAXVALUE - 200)) | (1L << (MICROSECONDS - 200)) | (1L << (MILLENNIUM - 200)) | (1L << (MILLISECONDS - 200)) | (1L << (MIN - 200)) | (1L << (MINVALUE - 200)) | (1L << (MINUTE - 200)) | (1L << (MONTH - 200)) | (1L << (NATIONAL - 200)) | (1L << (NO - 200)) | (1L << (NONE - 200)) | (1L << (NULLIF - 200)) | (1L << (OBJECT - 200)) | (1L << (ON - 200)) | (1L << (ONLY - 200)) | (1L << (OPTION - 200)) | (1L << (OPTIONS - 200)) | (1L << (OVER - 200)) | (1L << (OVERWRITE - 200)) | (1L << (PARSER - 200)) | (1L << (PARTIAL - 200)) | (1L << (PARTITION - 200)) | (1L << (PARTITIONS - 200)) | (1L << (PLAIN - 200)) | (1L << (PRECISION - 200)) | (1L << (PUBLIC - 200)) | (1L << (PURGE - 200)) | (1L << (QUARTER - 200)) | (1L << (RANGE - 200)) | (1L << (REGCONFIG - 200)) | (1L << (REGEXP - 200)) | (1L << (RENAME - 200)) | (1L << (REPLICA - 200)) | (1L << (RESET - 200)) | (1L << (RESTART - 200)) | (1L << (RLIKE - 200)) | (1L << (ROLLUP - 200)) | (1L << (SEARCH - 200)) | (1L << (SECOND - 200)) | (1L << (SECURITY - 200)) | (1L << (SERVER - 200)) | (1L << (SET - 200)) | (1L << (SIMILAR - 200)) | (1L << (SIMPLE - 200)) | (1L << (STABLE - 200)) | (1L << (START - 200)) | (1L << (STATISTICS - 200)) | (1L << (STDIN - 200)))) != 0) || ((((_la - 264)) & ~0x3f) == 0 && ((1L << (_la - 264)) & ((1L << (STORAGE - 264)) | (1L << (STDDEV_POP - 264)) | (1L << (STDDEV_SAMP - 264)) | (1L << (SUBPARTITION - 264)) | (1L << (SUM - 264)) | (1L << (TABLESPACE - 264)) | (1L << (TEMPLATE - 264)) | (1L << (THAN - 264)) | (1L << (TIMEZONE - 264)) | (1L << (TIMEZONE_HOUR - 264)) | (1L << (TIMEZONE_MINUTE - 264)) | (1L << (TRIM - 264)) | (1L << (TO - 264)) | (1L << (TYPE - 264)) | (1L << (TYPES - 264)) | (1L << (UNKNOWN - 264)) | (1L << (UNLOGGED - 264)) | (1L << (USER - 264)) | (1L << (VALID - 264)) | (1L << (VALIDATE - 264)) | (1L << (VALUES - 264)) | (1L << (VAR_SAMP - 264)) | (1L << (VAR_POP - 264)) | (1L << (VARYING - 264)) | (1L << (VERSION - 264)) | (1L << (VOLATILE - 264)) | (1L << (WEEK - 264)) | (1L << (WINDOW - 264)) | (1L << (WRAPPER - 264)) | (1L << (YEAR - 264)) | (1L << (ZONE - 264)) | (1L << (BOOLEAN - 264)) | (1L << (BOOL - 264)) | (1L << (BIT - 264)) | (1L << (VARBIT - 264)) | (1L << (INT1 - 264)) | (1L << (INT2 - 264)) | (1L << (INT4 - 264)) | (1L << (INT8 - 264)) | (1L << (TINYINT - 264)) | (1L << (SMALLINT - 264)) | (1L << (INT - 264)) | (1L << (INTEGER - 264)) | (1L << (BIGINT - 264)) | (1L << (FLOAT4 - 264)) | (1L << (FLOAT8 - 264)) | (1L << (REAL - 264)) | (1L << (REGCLASS - 264)) | (1L << (FLOAT - 264)) | (1L << (DOUBLE - 264)) | (1L << (NUMERIC - 264)) | (1L << (DECIMAL - 264)) | (1L << (CHAR - 264)) | (1L << (VARCHAR - 264)) | (1L << (NCHAR - 264)) | (1L << (NVARCHAR - 264)) | (1L << (DATE - 264)) | (1L << (TIME - 264)) | (1L << (TIMETZ - 264)) | (1L << (TIMESTAMP - 264)) | (1L << (TIMESTAMPTZ - 264)) | (1L << (TEXT - 264)) | (1L << (UUID - 264)))) != 0) || ((((_la - 328)) & ~0x3f) == 0 && ((1L << (_la - 328)) & ((1L << (BINARY - 328)) | (1L << (VARBINARY - 328)) | (1L << (BLOB - 328)) | (1L << (BYTEA - 328)) | (1L << (INET4 - 328)) | (1L << (INET - 328)) | (1L << (INTERVAL - 328)) | (1L << (VOID - 328)) | (1L << (LEFT_PAREN - 328)) | (1L << (PLUS - 328)) | (1L << (MINUS - 328)) | (1L << (DOUBLE_QUOTE - 328)) | (1L << (NUMBER - 328)) | (1L << (REAL_NUMBER - 328)) | (1L << (Identifier - 328)) | (1L << (QuotedIdentifier - 328)) | (1L << (Character_String_Literal - 328)))) != 0)) {
				{
				setState(2308); function_arguments();
				setState(2313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2309); match(COMMA);
					setState(2310); function_arguments();
					}
					}
					setState(2315);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(2318); match(RIGHT_PAREN);
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
		public IdentifierContext identifier;
		public List<IdentifierContext> schema_name = new ArrayList<IdentifierContext>();
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
		enterRule(_localctx, 86, RULE_functions_definition_schema);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2320); match(ALL);
			setState(2321); match(FUNCTIONS);
			setState(2322); match(IN);
			setState(2323); match(SCHEMA);
			setState(2324); ((Functions_definition_schemaContext)_localctx).identifier = identifier();
			((Functions_definition_schemaContext)_localctx).schema_name.add(((Functions_definition_schemaContext)_localctx).identifier);
			setState(2329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2325); match(COMMA);
				setState(2326); ((Functions_definition_schemaContext)_localctx).identifier = identifier();
				((Functions_definition_schemaContext)_localctx).schema_name.add(((Functions_definition_schemaContext)_localctx).identifier);
				}
				}
				setState(2331);
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

	public static class Create_sequence_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public TerminalNode SEQUENCE() { return getToken(SQLParser.SEQUENCE, 0); }
		public TerminalNode TEMPORARY() { return getToken(SQLParser.TEMPORARY, 0); }
		public Sequence_bodyContext sequence_body(int i) {
			return getRuleContext(Sequence_bodyContext.class,i);
		}
		public TerminalNode TEMP() { return getToken(SQLParser.TEMP, 0); }
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public List<Sequence_bodyContext> sequence_body() {
			return getRuleContexts(Sequence_bodyContext.class);
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
		enterRule(_localctx, 88, RULE_create_sequence_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2333);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(2332);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2335); match(SEQUENCE);
			setState(2336); ((Create_sequence_statementContext)_localctx).name = schema_qualified_name();
			setState(2340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OWNED || _la==CACHE || ((((_la - 167)) & ~0x3f) == 0 && ((1L << (_la - 167)) & ((1L << (CYCLE - 167)) | (1L << (INCREMENT - 167)) | (1L << (MAXVALUE - 167)) | (1L << (MINVALUE - 167)) | (1L << (NO - 167)))) != 0) || _la==START) {
				{
				{
				setState(2337); sequence_body();
				}
				}
				setState(2342);
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

	public static class Sequence_bodyContext extends ParserRuleContext {
		public Token incr;
		public Signed_numerical_literalContext minval;
		public Signed_numerical_literalContext maxval;
		public Signed_numerical_literalContext start_val;
		public Signed_numerical_literalContext cache_val;
		public Schema_qualified_nameContext col_name;
		public Signed_numerical_literalContext signed_numerical_literal() {
			return getRuleContext(Signed_numerical_literalContext.class,0);
		}
		public TerminalNode NO() { return getToken(SQLParser.NO, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode OWNED() { return getToken(SQLParser.OWNED, 0); }
		public TerminalNode MAXVALUE() { return getToken(SQLParser.MAXVALUE, 0); }
		public TerminalNode INCREMENT() { return getToken(SQLParser.INCREMENT, 0); }
		public TerminalNode NONE() { return getToken(SQLParser.NONE, 0); }
		public TerminalNode START() { return getToken(SQLParser.START, 0); }
		public TerminalNode MINVALUE() { return getToken(SQLParser.MINVALUE, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public TerminalNode CYCLE() { return getToken(SQLParser.CYCLE, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public TerminalNode CACHE() { return getToken(SQLParser.CACHE, 0); }
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Sequence_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSequence_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSequence_body(this);
		}
	}

	public final Sequence_bodyContext sequence_body() throws RecognitionException {
		Sequence_bodyContext _localctx = new Sequence_bodyContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_sequence_body);
		int _la;
		try {
			setState(2377);
			switch ( getInterpreter().adaptivePredict(_input,306,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2343); match(INCREMENT);
				setState(2345);
				_la = _input.LA(1);
				if (_la==BY) {
					{
					setState(2344); match(BY);
					}
				}

				setState(2347); ((Sequence_bodyContext)_localctx).incr = match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2352);
				switch (_input.LA(1)) {
				case MINVALUE:
					{
					setState(2348); match(MINVALUE);
					setState(2349); ((Sequence_bodyContext)_localctx).minval = signed_numerical_literal();
					}
					break;
				case NO:
					{
					setState(2350); match(NO);
					setState(2351); match(MINVALUE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2358);
				switch (_input.LA(1)) {
				case MAXVALUE:
					{
					setState(2354); match(MAXVALUE);
					setState(2355); ((Sequence_bodyContext)_localctx).maxval = signed_numerical_literal();
					}
					break;
				case NO:
					{
					setState(2356); match(NO);
					setState(2357); match(MAXVALUE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2360); match(START);
				setState(2362);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(2361); match(WITH);
					}
				}

				setState(2364); ((Sequence_bodyContext)_localctx).start_val = signed_numerical_literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2365); match(CACHE);
				setState(2366); ((Sequence_bodyContext)_localctx).cache_val = signed_numerical_literal();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2368);
				_la = _input.LA(1);
				if (_la==NO) {
					{
					setState(2367); match(NO);
					}
				}

				setState(2370); match(CYCLE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2371); match(OWNED);
				setState(2372); match(BY);
				setState(2375);
				switch ( getInterpreter().adaptivePredict(_input,305,_ctx) ) {
				case 1:
					{
					setState(2373); ((Sequence_bodyContext)_localctx).col_name = schema_qualified_name();
					}
					break;
				case 2:
					{
					setState(2374); match(NONE);
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

	public static class Create_schema_statementContext extends ParserRuleContext {
		public IdentifierContext schema_name;
		public IdentifierContext user_name;
		public SqlContext schema_element;
		public List<SqlContext> sql() {
			return getRuleContexts(SqlContext.class);
		}
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
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
		enterRule(_localctx, 92, RULE_create_schema_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2379); match(SCHEMA);
			setState(2411);
			switch (_input.LA(1)) {
			case REPLACE:
			case ADMIN:
			case ALWAYS:
			case ARRAY:
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
			case CONCURRENTLY:
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
			case EVENT:
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
			case OVER:
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
			case REGCONFIG:
			case REGEXP:
			case RENAME:
			case REPLICA:
			case RESET:
			case RESTART:
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
			case STDIN:
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
			case TYPES:
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
			case INET:
			case INTERVAL:
			case VOID:
			case DOUBLE_QUOTE:
			case Identifier:
			case QuotedIdentifier:
				{
				setState(2380); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(2383);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(2381); match(AUTHORIZATION);
					setState(2382); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				setState(2388);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - -1)) & ~0x3f) == 0 && ((1L << (_la - -1)) & ((1L << (EOF - -1)) | (1L << (ALTER - -1)) | (1L << (COPY - -1)) | (1L << (CREATE - -1)) | (1L << (GRANT - -1)))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (REVOKE - 105)) | (1L << (SELECT - 105)) | (1L << (TABLE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)) | (1L << (LEFT_PAREN - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0)) {
					{
					{
					setState(2385); ((Create_schema_statementContext)_localctx).schema_element = sql();
					}
					}
					setState(2390);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case AUTHORIZATION:
				{
				setState(2391); match(AUTHORIZATION);
				setState(2392); ((Create_schema_statementContext)_localctx).user_name = identifier();
				setState(2396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - -1)) & ~0x3f) == 0 && ((1L << (_la - -1)) & ((1L << (EOF - -1)) | (1L << (ALTER - -1)) | (1L << (COPY - -1)) | (1L << (CREATE - -1)) | (1L << (GRANT - -1)))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (REVOKE - 105)) | (1L << (SELECT - 105)) | (1L << (TABLE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)) | (1L << (LEFT_PAREN - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0)) {
					{
					{
					setState(2393); ((Create_schema_statementContext)_localctx).schema_element = sql();
					}
					}
					setState(2398);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case IF:
				{
				setState(2399); match(IF);
				setState(2400); match(NOT);
				setState(2401); match(EXISTS);
				setState(2409);
				switch (_input.LA(1)) {
				case REPLACE:
				case ADMIN:
				case ALWAYS:
				case ARRAY:
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
				case CONCURRENTLY:
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
				case EVENT:
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
				case OVER:
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
				case REGCONFIG:
				case REGEXP:
				case RENAME:
				case REPLICA:
				case RESET:
				case RESTART:
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
				case STDIN:
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
				case TYPES:
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
				case INET:
				case INTERVAL:
				case VOID:
				case DOUBLE_QUOTE:
				case Identifier:
				case QuotedIdentifier:
					{
					setState(2402); ((Create_schema_statementContext)_localctx).schema_name = identifier();
					setState(2405);
					_la = _input.LA(1);
					if (_la==AUTHORIZATION) {
						{
						setState(2403); match(AUTHORIZATION);
						setState(2404); ((Create_schema_statementContext)_localctx).user_name = identifier();
						}
					}

					}
					break;
				case AUTHORIZATION:
					{
					setState(2407); match(AUTHORIZATION);
					setState(2408); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static class Create_view_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public IdentifierContext identifier;
		public List<IdentifierContext> column_name = new ArrayList<IdentifierContext>();
		public IdentifierContext view_option_name;
		public IdentifierContext view_option_value;
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public TerminalNode VIEW() { return getToken(SQLParser.VIEW, 0); }
		public List<TerminalNode> ALL() { return getTokens(SQLParser.ALL); }
		public TerminalNode TEMPORARY() { return getToken(SQLParser.TEMPORARY, 0); }
		public TerminalNode OR() { return getToken(SQLParser.OR, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode UNION(int i) {
			return getToken(SQLParser.UNION, i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(SQLParser.EQUAL); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<TerminalNode> UNION() { return getTokens(SQLParser.UNION); }
		public TerminalNode ALL(int i) {
			return getToken(SQLParser.ALL, i);
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
		public Query_specificationContext query_specification(int i) {
			return getRuleContext(Query_specificationContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public List<Query_specificationContext> query_specification() {
			return getRuleContexts(Query_specificationContext.class);
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
		enterRule(_localctx, 94, RULE_create_view_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2415);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(2413); match(OR);
				setState(2414); match(REPLACE);
				}
			}

			setState(2418);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(2417);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2420); match(VIEW);
			setState(2421); ((Create_view_statementContext)_localctx).name = schema_qualified_name();
			setState(2428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0)) {
				{
				{
				setState(2422); ((Create_view_statementContext)_localctx).identifier = identifier();
				((Create_view_statementContext)_localctx).column_name.add(((Create_view_statementContext)_localctx).identifier);
				setState(2424);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2423); match(COMMA);
					}
				}

				}
				}
				setState(2430);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2444);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2431); match(WITH);
				setState(2432); match(LEFT_PAREN);
				setState(2438); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2433); ((Create_view_statementContext)_localctx).view_option_name = identifier();
					setState(2436);
					_la = _input.LA(1);
					if (_la==EQUAL) {
						{
						setState(2434); match(EQUAL);
						setState(2435); ((Create_view_statementContext)_localctx).view_option_value = identifier();
						}
					}

					}
					}
					setState(2440); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0) );
				setState(2442); match(RIGHT_PAREN);
				}
			}

			setState(2446); match(AS);
			setState(2447); query_specification();
			setState(2455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNION) {
				{
				{
				setState(2448); match(UNION);
				setState(2450);
				_la = _input.LA(1);
				if (_la==ALL) {
					{
					setState(2449); match(ALL);
					}
				}

				setState(2452); query_specification();
				}
				}
				setState(2457);
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

	public static class Create_table_statementContext extends ParserRuleContext {
		public Schema_qualified_nameContext n;
		public Schema_qualified_nameContext paret_table;
		public IdentifierContext type_name;
		public IdentifierContext column_name;
		public Column_constraintContext column_constraint;
		public List<Column_constraintContext> col_constraint = new ArrayList<Column_constraintContext>();
		public On_commitContext on_commit() {
			return getRuleContext(On_commitContext.class,0);
		}
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public Table_spaceContext table_space() {
			return getRuleContext(Table_spaceContext.class,0);
		}
		public TerminalNode WITH(int i) {
			return getToken(SQLParser.WITH, i);
		}
		public TerminalNode INHERITS() { return getToken(SQLParser.INHERITS, 0); }
		public Table_bodyContext table_body(int i) {
			return getRuleContext(Table_bodyContext.class,i);
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
		public Table_constraintContext table_constraint(int i) {
			return getRuleContext(Table_constraintContext.class,i);
		}
		public TerminalNode OF() { return getToken(SQLParser.OF, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode TEMP() { return getToken(SQLParser.TEMP, 0); }
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
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
		public List<Table_bodyContext> table_body() {
			return getRuleContexts(Table_bodyContext.class);
		}
		public TerminalNode UNLOGGED() { return getToken(SQLParser.UNLOGGED, 0); }
		public List<Column_constraintContext> column_constraint() {
			return getRuleContexts(Column_constraintContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode LOCAL() { return getToken(SQLParser.LOCAL, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OPTIONS(int i) {
			return getToken(SQLParser.OPTIONS, i);
		}
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
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
		enterRule(_localctx, 96, RULE_create_table_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2463);
			switch (_input.LA(1)) {
			case GLOBAL:
			case LOCAL:
			case TEMP:
			case TEMPORARY:
				{
				setState(2459);
				_la = _input.LA(1);
				if (_la==GLOBAL || _la==LOCAL) {
					{
					setState(2458);
					_la = _input.LA(1);
					if ( !(_la==GLOBAL || _la==LOCAL) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(2461);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case UNLOGGED:
				{
				setState(2462); match(UNLOGGED);
				}
				break;
			case TABLE:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2465); match(TABLE);
			setState(2469);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(2466); match(IF);
				setState(2467); match(NOT);
				setState(2468); match(EXISTS);
				}
			}

			setState(2471); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
			setState(2541);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(2472); match(LEFT_PAREN);
				setState(2481);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (LIKE - 81)) | (1L << (PRIMARY - 81)) | (1L << (REPLACE - 81)) | (1L << (UNIQUE - 81)) | (1L << (ADMIN - 81)) | (1L << (ALWAYS - 81)) | (1L << (ARRAY - 81)))) != 0) || ((((_la - 145)) & ~0x3f) == 0 && ((1L << (_la - 145)) & ((1L << (AVG - 145)) | (1L << (BETWEEN - 145)) | (1L << (BY - 145)) | (1L << (CACHE - 145)) | (1L << (CALLED - 145)) | (1L << (CLASS - 145)) | (1L << (CENTURY - 145)) | (1L << (CHARACTER - 145)) | (1L << (CHECK - 145)) | (1L << (CLUSTER - 145)) | (1L << (COLLECT - 145)) | (1L << (COALESCE - 145)) | (1L << (COLUMN - 145)) | (1L << (COMMENT - 145)) | (1L << (COMMENTS - 145)) | (1L << (COMMIT - 145)) | (1L << (CONCURRENTLY - 145)) | (1L << (CONFIGURATION - 145)) | (1L << (COST - 145)) | (1L << (COUNT - 145)) | (1L << (CUBE - 145)) | (1L << (CURRENT - 145)) | (1L << (CYCLE - 145)) | (1L << (DATA - 145)) | (1L << (DAY - 145)) | (1L << (DEC - 145)) | (1L << (DECADE - 145)) | (1L << (DEFINER - 145)) | (1L << (DICTIONARY - 145)) | (1L << (DISABLE - 145)) | (1L << (DOW - 145)) | (1L << (DOY - 145)) | (1L << (DROP - 145)) | (1L << (ENABLE - 145)) | (1L << (EPOCH - 145)) | (1L << (EVENT - 145)) | (1L << (EVERY - 145)) | (1L << (EXISTS - 145)) | (1L << (EXTENDED - 145)) | (1L << (EXTERNAL - 145)) | (1L << (EXTRACT - 145)) | (1L << (FAMILY - 145)) | (1L << (FILTER - 145)) | (1L << (FIRST - 145)) | (1L << (FORMAT - 145)) | (1L << (FUSION - 145)) | (1L << (GROUPING - 145)) | (1L << (HASH - 145)) | (1L << (INHERIT - 145)) | (1L << (INDEX - 145)) | (1L << (INCREMENT - 145)) | (1L << (INPUT - 145)) | (1L << (INSERT - 145)) | (1L << (INTERSECTION - 145)) | (1L << (ISCACHABLE - 145)) | (1L << (ISODOW - 145)) | (1L << (ISOYEAR - 145)) | (1L << (ISSTRICT - 145)) | (1L << (LANGUAGE - 145)) | (1L << (LARGE - 145)) | (1L << (LAST - 145)) | (1L << (LESS - 145)))) != 0) || ((((_la - 209)) & ~0x3f) == 0 && ((1L << (_la - 209)) & ((1L << (LIST - 209)) | (1L << (LOCATION - 209)) | (1L << (MAIN - 209)) | (1L << (MATCH - 209)) | (1L << (MAX - 209)) | (1L << (MAXVALUE - 209)) | (1L << (MICROSECONDS - 209)) | (1L << (MILLENNIUM - 209)) | (1L << (MILLISECONDS - 209)) | (1L << (MIN - 209)) | (1L << (MINVALUE - 209)) | (1L << (MINUTE - 209)) | (1L << (MONTH - 209)) | (1L << (NATIONAL - 209)) | (1L << (NO - 209)) | (1L << (NONE - 209)) | (1L << (NULLIF - 209)) | (1L << (OBJECT - 209)) | (1L << (ON - 209)) | (1L << (ONLY - 209)) | (1L << (OPTION - 209)) | (1L << (OPTIONS - 209)) | (1L << (OVER - 209)) | (1L << (OVERWRITE - 209)) | (1L << (PARSER - 209)) | (1L << (PARTIAL - 209)) | (1L << (PARTITION - 209)) | (1L << (PARTITIONS - 209)) | (1L << (PLAIN - 209)) | (1L << (PRECISION - 209)) | (1L << (PUBLIC - 209)) | (1L << (PURGE - 209)) | (1L << (QUARTER - 209)) | (1L << (RANGE - 209)) | (1L << (REGCONFIG - 209)) | (1L << (REGEXP - 209)) | (1L << (RENAME - 209)) | (1L << (REPLICA - 209)) | (1L << (RESET - 209)) | (1L << (RESTART - 209)) | (1L << (RLIKE - 209)) | (1L << (ROLLUP - 209)) | (1L << (SEARCH - 209)) | (1L << (SECOND - 209)) | (1L << (SECURITY - 209)) | (1L << (SERVER - 209)) | (1L << (SET - 209)) | (1L << (SIMILAR - 209)) | (1L << (SIMPLE - 209)) | (1L << (STABLE - 209)) | (1L << (START - 209)) | (1L << (STATISTICS - 209)) | (1L << (STDIN - 209)) | (1L << (STORAGE - 209)) | (1L << (STDDEV_POP - 209)) | (1L << (STDDEV_SAMP - 209)) | (1L << (SUBPARTITION - 209)) | (1L << (SUM - 209)) | (1L << (TABLESPACE - 209)) | (1L << (TEMPLATE - 209)) | (1L << (THAN - 209)))) != 0) || ((((_la - 273)) & ~0x3f) == 0 && ((1L << (_la - 273)) & ((1L << (TIMEZONE - 273)) | (1L << (TIMEZONE_HOUR - 273)) | (1L << (TIMEZONE_MINUTE - 273)) | (1L << (TRIM - 273)) | (1L << (TO - 273)) | (1L << (TYPE - 273)) | (1L << (TYPES - 273)) | (1L << (UNKNOWN - 273)) | (1L << (UNLOGGED - 273)) | (1L << (USER - 273)) | (1L << (VALID - 273)) | (1L << (VALIDATE - 273)) | (1L << (VALUES - 273)) | (1L << (VAR_SAMP - 273)) | (1L << (VAR_POP - 273)) | (1L << (VARYING - 273)) | (1L << (VERSION - 273)) | (1L << (VOLATILE - 273)) | (1L << (WEEK - 273)) | (1L << (WINDOW - 273)) | (1L << (WRAPPER - 273)) | (1L << (YEAR - 273)) | (1L << (ZONE - 273)) | (1L << (BOOLEAN - 273)) | (1L << (BOOL - 273)) | (1L << (BIT - 273)) | (1L << (VARBIT - 273)) | (1L << (INT1 - 273)) | (1L << (INT2 - 273)) | (1L << (INT4 - 273)) | (1L << (INT8 - 273)) | (1L << (TINYINT - 273)) | (1L << (SMALLINT - 273)) | (1L << (INT - 273)) | (1L << (INTEGER - 273)) | (1L << (BIGINT - 273)) | (1L << (FLOAT4 - 273)) | (1L << (FLOAT8 - 273)) | (1L << (REAL - 273)) | (1L << (FLOAT - 273)) | (1L << (DOUBLE - 273)) | (1L << (NUMERIC - 273)) | (1L << (DECIMAL - 273)) | (1L << (CHAR - 273)) | (1L << (VARCHAR - 273)) | (1L << (NCHAR - 273)) | (1L << (NVARCHAR - 273)) | (1L << (DATE - 273)) | (1L << (TIME - 273)) | (1L << (TIMETZ - 273)) | (1L << (TIMESTAMP - 273)) | (1L << (TIMESTAMPTZ - 273)) | (1L << (TEXT - 273)) | (1L << (UUID - 273)) | (1L << (VARBINARY - 273)) | (1L << (BLOB - 273)) | (1L << (BYTEA - 273)) | (1L << (INET4 - 273)) | (1L << (INET - 273)) | (1L << (INTERVAL - 273)) | (1L << (VOID - 273)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0)) {
					{
					setState(2473); table_body();
					setState(2478);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2474); match(COMMA);
						setState(2475); table_body();
						}
						}
						setState(2480);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(2483); match(RIGHT_PAREN);
				setState(2496);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(2484); match(INHERITS);
					setState(2485); match(LEFT_PAREN);
					setState(2490); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2486); ((Create_table_statementContext)_localctx).paret_table = schema_qualified_name();
						setState(2488);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2487); match(COMMA);
							}
						}

						}
						}
						setState(2492); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0) );
					setState(2494); match(RIGHT_PAREN);
					}
				}

				setState(2498); storage_parameter_oid();
				setState(2499); on_commit();
				setState(2500); table_space();
				}
				break;
			case OF:
				{
				setState(2502); match(OF);
				setState(2503); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(2535);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2504); match(LEFT_PAREN);
					setState(2515);
					switch ( getInterpreter().adaptivePredict(_input,331,_ctx) ) {
					case 1:
						{
						{
						setState(2505); ((Create_table_statementContext)_localctx).column_name = identifier();
						setState(2506); match(WITH);
						setState(2507); match(OPTIONS);
						setState(2511);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,330,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(2508); ((Create_table_statementContext)_localctx).column_constraint = column_constraint();
								((Create_table_statementContext)_localctx).col_constraint.add(((Create_table_statementContext)_localctx).column_constraint);
								}
								} 
							}
							setState(2513);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,330,_ctx);
						}
						}
						}
						break;
					case 2:
						{
						setState(2514); table_constraint();
						}
						break;
					}
					setState(2530);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (PRIMARY - 97)) | (1L << (UNIQUE - 97)) | (1L << (CHECK - 97)))) != 0) || _la==COMMA) {
						{
						setState(2528);
						switch (_input.LA(1)) {
						case COMMA:
							{
							setState(2517); match(COMMA);
							{
							setState(2518); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(2519); match(WITH);
							setState(2520); match(OPTIONS);
							setState(2524);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,332,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(2521); ((Create_table_statementContext)_localctx).column_constraint = column_constraint();
									((Create_table_statementContext)_localctx).col_constraint.add(((Create_table_statementContext)_localctx).column_constraint);
									}
									} 
								}
								setState(2526);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,332,_ctx);
							}
							}
							}
							break;
						case CONSTRAINT:
						case EXCLUDE:
						case FOREIGN:
						case PRIMARY:
						case UNIQUE:
						case CHECK:
							{
							setState(2527); table_constraint();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(2532);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2533); match(RIGHT_PAREN);
					}
				}

				setState(2537); storage_parameter_oid();
				setState(2538); on_commit();
				setState(2539); table_space();
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

	public static class Table_bodyContext extends ParserRuleContext {
		public Table_constraintContext tabl_constraint;
		public IdentifierContext parent_table;
		public Like_optionContext like_option;
		public List<Like_optionContext> like_opt = new ArrayList<Like_optionContext>();
		public List<Like_optionContext> like_option() {
			return getRuleContexts(Like_optionContext.class);
		}
		public Like_optionContext like_option(int i) {
			return getRuleContext(Like_optionContext.class,i);
		}
		public Table_constraintContext table_constraint() {
			return getRuleContext(Table_constraintContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(SQLParser.LIKE, 0); }
		public Table_column_definitionContext table_column_definition() {
			return getRuleContext(Table_column_definitionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Table_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTable_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTable_body(this);
		}
	}

	public final Table_bodyContext table_body() throws RecognitionException {
		Table_bodyContext _localctx = new Table_bodyContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_table_body);
		int _la;
		try {
			setState(2553);
			switch ( getInterpreter().adaptivePredict(_input,338,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2543); table_column_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2544); ((Table_bodyContext)_localctx).tabl_constraint = table_constraint();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2545); match(LIKE);
				setState(2546); ((Table_bodyContext)_localctx).parent_table = identifier();
				setState(2550);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==EXCLUDING || _la==INCLUDING) {
					{
					{
					setState(2547); ((Table_bodyContext)_localctx).like_option = like_option();
					((Table_bodyContext)_localctx).like_opt.add(((Table_bodyContext)_localctx).like_option);
					}
					}
					setState(2552);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class Table_column_definitionContext extends ParserRuleContext {
		public IdentifierContext column_name;
		public Data_typeContext datatype;
		public IdentifierContext collation;
		public Column_constraintContext column_constraint;
		public List<Column_constraintContext> colmn_constraint = new ArrayList<Column_constraintContext>();
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
		enterRule(_localctx, 100, RULE_table_column_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2555); ((Table_column_definitionContext)_localctx).column_name = identifier();
			{
			setState(2556); ((Table_column_definitionContext)_localctx).datatype = data_type();
			}
			setState(2559);
			_la = _input.LA(1);
			if (_la==COLLATE) {
				{
				setState(2557); match(COLLATE);
				setState(2558); ((Table_column_definitionContext)_localctx).collation = identifier();
				}
			}

			setState(2564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONSTRAINT || _la==DEFAULT || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (NOT - 85)) | (1L << (NULL - 85)) | (1L << (PRIMARY - 85)) | (1L << (REFERENCES - 85)) | (1L << (UNIQUE - 85)))) != 0) || _la==CHECK) {
				{
				{
				setState(2561); ((Table_column_definitionContext)_localctx).column_constraint = column_constraint();
				((Table_column_definitionContext)_localctx).colmn_constraint.add(((Table_column_definitionContext)_localctx).column_constraint);
				}
				}
				setState(2566);
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
		enterRule(_localctx, 102, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2567);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(2568);
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
		public IdentifierContext identifier;
		public List<IdentifierContext> column_name_unique = new ArrayList<IdentifierContext>();
		public Index_parametersContext index_parameters_unique;
		public List<IdentifierContext> column_name_pr_key = new ArrayList<IdentifierContext>();
		public Index_parametersContext index_parameters_pr_key;
		public IdentifierContext index_method;
		public IdentifierContext exclude_element;
		public List<IdentifierContext> operator = new ArrayList<IdentifierContext>();
		public IdentifierContext predicat;
		public List<IdentifierContext> column_name_for_key = new ArrayList<IdentifierContext>();
		public Schema_qualified_nameContext reftable;
		public List<IdentifierContext> refcolumn = new ArrayList<IdentifierContext>();
		public ActionContext action_on_delete;
		public ActionContext action_on_update;
		public TerminalNode DEFERRED() { return getToken(SQLParser.DEFERRED, 0); }
		public List<TerminalNode> FULL() { return getTokens(SQLParser.FULL); }
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
		public TerminalNode DELETE(int i) {
			return getToken(SQLParser.DELETE, i);
		}
		public List<TerminalNode> PARTIAL() { return getTokens(SQLParser.PARTIAL); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public TerminalNode INITIALLY() { return getToken(SQLParser.INITIALLY, 0); }
		public List<TerminalNode> ON() { return getTokens(SQLParser.ON); }
		public TerminalNode SIMPLE(int i) {
			return getToken(SQLParser.SIMPLE, i);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public TerminalNode UPDATE(int i) {
			return getToken(SQLParser.UPDATE, i);
		}
		public TerminalNode PARTIAL(int i) {
			return getToken(SQLParser.PARTIAL, i);
		}
		public List<TerminalNode> SIMPLE() { return getTokens(SQLParser.SIMPLE); }
		public List<TerminalNode> DELETE() { return getTokens(SQLParser.DELETE); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public List<TerminalNode> UPDATE() { return getTokens(SQLParser.UPDATE); }
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
		public TerminalNode FULL(int i) {
			return getToken(SQLParser.FULL, i);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public TerminalNode REFERENCES() { return getToken(SQLParser.REFERENCES, 0); }
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public List<TerminalNode> MATCH() { return getTokens(SQLParser.MATCH); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public TerminalNode PRIMARY() { return getToken(SQLParser.PRIMARY, 0); }
		public TerminalNode MATCH(int i) {
			return getToken(SQLParser.MATCH, i);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode FOREIGN() { return getToken(SQLParser.FOREIGN, 0); }
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
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
		enterRule(_localctx, 104, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2572);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2570); match(CONSTRAINT);
				setState(2571); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2673);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(2574); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(2575); match(UNIQUE);
				setState(2576); match(LEFT_PAREN);
				setState(2577); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).column_name_unique.add(((Table_constraintContext)_localctx).identifier);
				setState(2582);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2578); match(COMMA);
					setState(2579); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).column_name_unique.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2584);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2585); match(RIGHT_PAREN);
				setState(2586); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2588); match(PRIMARY);
				setState(2589); match(KEY);
				setState(2590); match(LEFT_PAREN);
				setState(2591); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).column_name_pr_key.add(((Table_constraintContext)_localctx).identifier);
				setState(2596);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2592); match(COMMA);
					setState(2593); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).column_name_pr_key.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2598);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2599); match(RIGHT_PAREN);
				setState(2600); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(2602); match(EXCLUDE);
				setState(2605);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(2603); match(USING);
					setState(2604); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(2607); match(LEFT_PAREN);
				setState(2608); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(2609); match(WITH);
				setState(2610); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).operator.add(((Table_constraintContext)_localctx).identifier);
				setState(2615);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2611); match(COMMA);
					setState(2612); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).operator.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2617);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2618); match(RIGHT_PAREN);
				setState(2619); index_parameters();
				setState(2625);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(2620); match(WHERE);
					setState(2621); match(LEFT_PAREN);
					setState(2622); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(2623); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(2627); match(FOREIGN);
				setState(2628); match(KEY);
				setState(2629); match(LEFT_PAREN);
				setState(2630); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).column_name_for_key.add(((Table_constraintContext)_localctx).identifier);
				setState(2635);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2631); match(COMMA);
					setState(2632); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).column_name_for_key.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2637);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2638); match(RIGHT_PAREN);
				setState(2639); match(REFERENCES);
				setState(2640); ((Table_constraintContext)_localctx).reftable = schema_qualified_name();
				setState(2652);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2641); match(LEFT_PAREN);
					setState(2642); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).refcolumn.add(((Table_constraintContext)_localctx).identifier);
					setState(2647);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2643); match(COMMA);
						setState(2644); ((Table_constraintContext)_localctx).identifier = identifier();
						((Table_constraintContext)_localctx).refcolumn.add(((Table_constraintContext)_localctx).identifier);
						}
						}
						setState(2649);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2650); match(RIGHT_PAREN);
					}
				}

				setState(2670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MATCH || _la==ON) {
					{
					setState(2668);
					switch ( getInterpreter().adaptivePredict(_input,351,_ctx) ) {
					case 1:
						{
						setState(2660);
						switch ( getInterpreter().adaptivePredict(_input,350,_ctx) ) {
						case 1:
							{
							{
							setState(2654); match(MATCH);
							setState(2655); match(FULL);
							}
							}
							break;
						case 2:
							{
							{
							setState(2656); match(MATCH);
							setState(2657); match(PARTIAL);
							}
							}
							break;
						case 3:
							{
							{
							setState(2658); match(MATCH);
							setState(2659); match(SIMPLE);
							}
							}
							break;
						}
						}
						break;
					case 2:
						{
						{
						setState(2662); match(ON);
						setState(2663); match(DELETE);
						setState(2664); ((Table_constraintContext)_localctx).action_on_delete = action();
						}
						}
						break;
					case 3:
						{
						{
						setState(2665); match(ON);
						setState(2666); match(UPDATE);
						setState(2667); ((Table_constraintContext)_localctx).action_on_update = action();
						}
						}
						break;
					}
					}
					setState(2672);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2678);
			switch ( getInterpreter().adaptivePredict(_input,354,_ctx) ) {
			case 1:
				{
				setState(2675); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2676); match(NOT);
				setState(2677); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2684);
			switch ( getInterpreter().adaptivePredict(_input,355,_ctx) ) {
			case 1:
				{
				{
				setState(2680); match(INITIALLY);
				setState(2681); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2682); match(INITIALLY);
				setState(2683); match(IMMEDIATE);
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
		enterRule(_localctx, 106, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2688);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2686); match(CONSTRAINT);
				setState(2687); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2725);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(2690); match(NOT);
				setState(2691); match(NULL);
				}
				break;
			case NULL:
				{
				setState(2692); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(2693); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				setState(2694); match(DEFAULT);
				setState(2697);
				switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
				case 1:
					{
					setState(2695); ((Column_constraintContext)_localctx).default_expr_data = data_type();
					}
					break;
				case 2:
					{
					setState(2696); ((Column_constraintContext)_localctx).default_expr = value_expression();
					}
					break;
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(2699); match(UNIQUE);
				setState(2700); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2701); match(PRIMARY);
				setState(2702); match(KEY);
				setState(2703); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(2704); match(REFERENCES);
				setState(2705); ((Column_constraintContext)_localctx).reftable = schema_qualified_name();
				{
				{
				setState(2706); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(2713);
				switch ( getInterpreter().adaptivePredict(_input,358,_ctx) ) {
				case 1:
					{
					setState(2707); match(MATCH);
					setState(2708); match(FULL);
					}
					break;
				case 2:
					{
					setState(2709); match(MATCH);
					setState(2710); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(2711); match(MATCH);
					setState(2712); match(SIMPLE);
					}
					break;
				}
				setState(2718);
				switch ( getInterpreter().adaptivePredict(_input,359,_ctx) ) {
				case 1:
					{
					setState(2715); match(ON);
					setState(2716); match(DELETE);
					setState(2717); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2723);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(2720); match(ON);
					setState(2721); match(UPDATE);
					setState(2722); ((Column_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2730);
			switch ( getInterpreter().adaptivePredict(_input,362,_ctx) ) {
			case 1:
				{
				setState(2727); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2728); match(NOT);
				setState(2729); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2736);
			switch ( getInterpreter().adaptivePredict(_input,363,_ctx) ) {
			case 1:
				{
				{
				setState(2732); match(INITIALLY);
				setState(2733); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2734); match(INITIALLY);
				setState(2735); match(IMMEDIATE);
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
		public Value_expressionContext expression;
		public TerminalNode CHECK() { return getToken(SQLParser.CHECK, 0); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
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
		enterRule(_localctx, 108, RULE_check_boolean_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2738); match(CHECK);
			setState(2740); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2739); match(LEFT_PAREN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2742); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,364,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(2744); ((Check_boolean_expressionContext)_localctx).expression = value_expression();
			setState(2746); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2745); match(RIGHT_PAREN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2748); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,365,_ctx);
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

	public static class Storage_parameterContext extends ParserRuleContext {
		public IdentifierContext storage_param;
		public Value_expressionContext value;
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public TerminalNode EQUAL(int i) {
			return getToken(SQLParser.EQUAL, i);
		}
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
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
		enterRule(_localctx, 110, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2750); match(LEFT_PAREN);
			setState(2759); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2751); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(2754);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(2752); match(EQUAL);
					setState(2753); ((Storage_parameterContext)_localctx).value = value_expression();
					}
				}

				setState(2757);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2756); match(COMMA);
					}
				}

				}
				}
				setState(2761); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0) );
			setState(2763); match(RIGHT_PAREN);
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
		enterRule(_localctx, 112, RULE_with_storage_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2765); match(WITH);
			setState(2766); storage_parameter();
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
		enterRule(_localctx, 114, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2773);
			switch ( getInterpreter().adaptivePredict(_input,369,_ctx) ) {
			case 1:
				{
				setState(2768); with_storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(2769); match(WITH);
				setState(2770); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(2771); match(WITHOUT);
				setState(2772); match(OIDS);
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
		enterRule(_localctx, 116, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2784);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(2775); match(ON);
				setState(2776); match(COMMIT);
				setState(2782);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(2777); match(PRESERVE);
					setState(2778); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(2779); match(DELETE);
					setState(2780); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(2781); match(DROP);
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
		enterRule(_localctx, 118, RULE_table_space);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2788);
			_la = _input.LA(1);
			if (_la==TABLESPACE) {
				{
				setState(2786); match(TABLESPACE);
				setState(2787); ((Table_spaceContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 120, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2796);
			switch ( getInterpreter().adaptivePredict(_input,373,_ctx) ) {
			case 1:
				{
				setState(2790); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(2791); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(2792); match(SET);
				setState(2793); match(NULL);
				}
				break;
			case 4:
				{
				setState(2794); match(SET);
				setState(2795); match(DEFAULT);
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
		enterRule(_localctx, 122, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2799);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2798); with_storage_parameter();
				}
			}

			setState(2805);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(2801); match(USING);
				setState(2802); match(INDEX);
				setState(2803); match(TABLESPACE);
				setState(2804); ((Index_parametersContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 124, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2807); match(LEFT_PAREN);
			setState(2808); field_element();
			setState(2813);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2809); match(COMMA);
				setState(2810); field_element();
				}
				}
				setState(2815);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2816); match(RIGHT_PAREN);
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
		enterRule(_localctx, 126, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2818); ((Field_elementContext)_localctx).name = identifier();
			setState(2819); field_type();
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
		enterRule(_localctx, 128, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2821); data_type();
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
		enterRule(_localctx, 130, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2823); match(WITH);
			setState(2824); match(LEFT_PAREN);
			setState(2825); param();
			setState(2830);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2826); match(COMMA);
				setState(2827); param();
				}
				}
				setState(2832);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2833); match(RIGHT_PAREN);
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
		public IdentifierContext key;
		public Numeric_value_expressionContext value;
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
		enterRule(_localctx, 132, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2835); ((ParamContext)_localctx).key = identifier();
			setState(2836); match(EQUAL);
			setState(2837); ((ParamContext)_localctx).value = numeric_value_expression();
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

	public static class Partition_by_columnsContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Schema_qualified_nameContext schema_qualified_name(int i) {
			return getRuleContext(Schema_qualified_nameContext.class,i);
		}
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public Partition_by_columnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_by_columns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPartition_by_columns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPartition_by_columns(this);
		}
	}

	public final Partition_by_columnsContext partition_by_columns() throws RecognitionException {
		Partition_by_columnsContext _localctx = new Partition_by_columnsContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_partition_by_columns);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2839); match(PARTITION);
			setState(2840); match(BY);
			setState(2841); schema_qualified_name();
			setState(2846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2842); match(COMMA);
				setState(2843); schema_qualified_name();
				}
				}
				setState(2848);
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
		enterRule(_localctx, 136, RULE_drop_table_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2849); match(DROP);
			setState(2850); match(TABLE);
			setState(2851); schema_qualified_name();
			setState(2853);
			_la = _input.LA(1);
			if (_la==PURGE) {
				{
				setState(2852); match(PURGE);
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
		enterRule(_localctx, 138, RULE_identifier);
		int _la;
		try {
			setState(2863);
			switch (_input.LA(1)) {
			case Identifier:
			case QuotedIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2855);
				_la = _input.LA(1);
				if ( !(_la==Identifier || _la==QuotedIdentifier) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case REPLACE:
			case ADMIN:
			case ALWAYS:
			case ARRAY:
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
			case CONCURRENTLY:
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
			case EVENT:
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
			case OVER:
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
			case REGCONFIG:
			case REGEXP:
			case RENAME:
			case REPLICA:
			case RESET:
			case RESTART:
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
			case STDIN:
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
			case TYPES:
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
			case INET:
			case INTERVAL:
			case VOID:
			case DOUBLE_QUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2857);
				_la = _input.LA(1);
				if (_la==DOUBLE_QUOTE) {
					{
					setState(2856); match(DOUBLE_QUOTE);
					}
				}

				setState(2859); nonreserved_keywords();
				setState(2861);
				switch ( getInterpreter().adaptivePredict(_input,381,_ctx) ) {
				case 1:
					{
					setState(2860); match(DOUBLE_QUOTE);
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
		public TerminalNode PURGE() { return getToken(SQLParser.PURGE, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
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
		public TerminalNode CONCURRENTLY() { return getToken(SQLParser.CONCURRENTLY, 0); }
		public TerminalNode DATA() { return getToken(SQLParser.DATA, 0); }
		public TerminalNode OVERWRITE() { return getToken(SQLParser.OVERWRITE, 0); }
		public TerminalNode INET() { return getToken(SQLParser.INET, 0); }
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
		public TerminalNode RESTART() { return getToken(SQLParser.RESTART, 0); }
		public TerminalNode INTERSECTION() { return getToken(SQLParser.INTERSECTION, 0); }
		public TerminalNode VOLATILE() { return getToken(SQLParser.VOLATILE, 0); }
		public TerminalNode REGCONFIG() { return getToken(SQLParser.REGCONFIG, 0); }
		public TerminalNode TEMPLATE() { return getToken(SQLParser.TEMPLATE, 0); }
		public TerminalNode CLASS() { return getToken(SQLParser.CLASS, 0); }
		public TerminalNode LESS() { return getToken(SQLParser.LESS, 0); }
		public TerminalNode MILLENNIUM() { return getToken(SQLParser.MILLENNIUM, 0); }
		public TerminalNode SIMPLE() { return getToken(SQLParser.SIMPLE, 0); }
		public TerminalNode CALLED() { return getToken(SQLParser.CALLED, 0); }
		public TerminalNode OPTION() { return getToken(SQLParser.OPTION, 0); }
		public TerminalNode ISSTRICT() { return getToken(SQLParser.ISSTRICT, 0); }
		public TerminalNode ARRAY() { return getToken(SQLParser.ARRAY, 0); }
		public TerminalNode TINYINT() { return getToken(SQLParser.TINYINT, 0); }
		public TerminalNode USER() { return getToken(SQLParser.USER, 0); }
		public TerminalNode STORAGE() { return getToken(SQLParser.STORAGE, 0); }
		public TerminalNode STDIN() { return getToken(SQLParser.STDIN, 0); }
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
		public TerminalNode OVER() { return getToken(SQLParser.OVER, 0); }
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
		public TerminalNode EVENT() { return getToken(SQLParser.EVENT, 0); }
		public TerminalNode MINVALUE() { return getToken(SQLParser.MINVALUE, 0); }
		public TerminalNode MICROSECONDS() { return getToken(SQLParser.MICROSECONDS, 0); }
		public TerminalNode DISABLE() { return getToken(SQLParser.DISABLE, 0); }
		public TerminalNode CLUSTER() { return getToken(SQLParser.CLUSTER, 0); }
		public TerminalNode HASH() { return getToken(SQLParser.HASH, 0); }
		public TerminalNode DECIMAL() { return getToken(SQLParser.DECIMAL, 0); }
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode ENABLE() { return getToken(SQLParser.ENABLE, 0); }
		public TerminalNode THAN() { return getToken(SQLParser.THAN, 0); }
		public TerminalNode REGEXP() { return getToken(SQLParser.REGEXP, 0); }
		public TerminalNode EPOCH() { return getToken(SQLParser.EPOCH, 0); }
		public TerminalNode ADMIN() { return getToken(SQLParser.ADMIN, 0); }
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
		public TerminalNode TYPES() { return getToken(SQLParser.TYPES, 0); }
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
		public TerminalNode REPLACE() { return getToken(SQLParser.REPLACE, 0); }
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
		enterRule(_localctx, 140, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2865);
			_la = _input.LA(1);
			if ( !(((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)))) != 0)) ) {
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
		enterRule(_localctx, 142, RULE_unsigned_literal);
		try {
			setState(2869);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2867); unsigned_numeric_literal();
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
				setState(2868); general_literal();
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
		public Truth_valueContext truth_value() {
			return getRuleContext(Truth_valueContext.class,0);
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
		enterRule(_localctx, 144, RULE_general_literal);
		try {
			setState(2874);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2871); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(2872); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(2873); truth_value();
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
		enterRule(_localctx, 146, RULE_datetime_literal);
		try {
			setState(2879);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(2876); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2877); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2878); date_literal();
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
		enterRule(_localctx, 148, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2881); match(TIME);
			setState(2882); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
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
		enterRule(_localctx, 150, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2884); match(TIMESTAMP);
			setState(2885); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
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
		enterRule(_localctx, 152, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2887); match(DATE);
			setState(2888); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
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
		public TerminalNode LEFT_BRACKET() { return getToken(SQLParser.LEFT_BRACKET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(SQLParser.RIGHT_BRACKET, 0); }
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
		enterRule(_localctx, 154, RULE_data_type);
		try {
			setState(2897);
			switch (_input.LA(1)) {
			case REPLACE:
			case TRIGGER:
			case ADMIN:
			case ALWAYS:
			case ARRAY:
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
			case CONCURRENTLY:
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
			case EVENT:
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
			case OVER:
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
			case REGCONFIG:
			case REGEXP:
			case RENAME:
			case REPLICA:
			case RESET:
			case RESTART:
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
			case STDIN:
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
			case TYPES:
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
			case INET:
			case INTERVAL:
			case VOID:
			case DOUBLE_QUOTE:
			case Identifier:
			case QuotedIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2890); predefined_type();
				setState(2893);
				switch ( getInterpreter().adaptivePredict(_input,386,_ctx) ) {
				case 1:
					{
					setState(2891); match(LEFT_BRACKET);
					setState(2892); match(RIGHT_BRACKET);
					}
					break;
				}
				}
				break;
			case SETOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(2895); match(SETOF);
				setState(2896); ((Data_typeContext)_localctx).value = identifier();
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
		public TerminalNode REGCLASS() { return getToken(SQLParser.REGCLASS, 0); }
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
		public TerminalNode REGCONFIG() { return getToken(SQLParser.REGCONFIG, 0); }
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
		public TerminalNode INET() { return getToken(SQLParser.INET, 0); }
		public Numeric_typeContext numeric_type() {
			return getRuleContext(Numeric_typeContext.class,0);
		}
		public Datetime_typeContext datetime_type() {
			return getRuleContext(Datetime_typeContext.class,0);
		}
		public Binary_typeContext binary_type() {
			return getRuleContext(Binary_typeContext.class,0);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
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
		enterRule(_localctx, 156, RULE_predefined_type);
		int _la;
		try {
			setState(2910);
			switch ( getInterpreter().adaptivePredict(_input,388,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2899); character_string_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2900); national_character_string_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2901); binary_large_object_string_type();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2902); numeric_type();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2903); boolean_type();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2904); datetime_type();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2905); bit_type();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2906); binary_type();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2907); network_type();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2908);
				_la = _input.LA(1);
				if ( !(_la==TRIGGER || _la==REGCONFIG || ((((_la - 312)) & ~0x3f) == 0 && ((1L << (_la - 312)) & ((1L << (REGCLASS - 312)) | (1L << (UUID - 312)) | (1L << (INET - 312)) | (1L << (VOID - 312)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2909); schema_qualified_name();
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
		enterRule(_localctx, 158, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2912); match(INET4);
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
		enterRule(_localctx, 160, RULE_character_string_type);
		int _la;
		try {
			setState(2937);
			switch ( getInterpreter().adaptivePredict(_input,394,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2914); match(CHARACTER);
				setState(2916);
				switch ( getInterpreter().adaptivePredict(_input,389,_ctx) ) {
				case 1:
					{
					setState(2915); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2918); match(CHAR);
				setState(2920);
				switch ( getInterpreter().adaptivePredict(_input,390,_ctx) ) {
				case 1:
					{
					setState(2919); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2922); match(CHARACTER);
				setState(2923); match(VARYING);
				setState(2925);
				switch ( getInterpreter().adaptivePredict(_input,391,_ctx) ) {
				case 1:
					{
					setState(2924); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2927); match(CHAR);
				setState(2928); match(VARYING);
				setState(2930);
				switch ( getInterpreter().adaptivePredict(_input,392,_ctx) ) {
				case 1:
					{
					setState(2929); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2932); match(VARCHAR);
				setState(2934);
				switch ( getInterpreter().adaptivePredict(_input,393,_ctx) ) {
				case 1:
					{
					setState(2933); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2936);
				_la = _input.LA(1);
				if ( !(_la==TEXT || _la==INTERVAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
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
		enterRule(_localctx, 162, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2939); match(LEFT_PAREN);
			setState(2940); match(NUMBER);
			setState(2941); match(RIGHT_PAREN);
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
		enterRule(_localctx, 164, RULE_national_character_string_type);
		try {
			setState(2978);
			switch ( getInterpreter().adaptivePredict(_input,402,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2943); match(NATIONAL);
				setState(2944); match(CHARACTER);
				setState(2946);
				switch ( getInterpreter().adaptivePredict(_input,395,_ctx) ) {
				case 1:
					{
					setState(2945); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2948); match(NATIONAL);
				setState(2949); match(CHAR);
				setState(2951);
				switch ( getInterpreter().adaptivePredict(_input,396,_ctx) ) {
				case 1:
					{
					setState(2950); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2953); match(NCHAR);
				setState(2955);
				switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
				case 1:
					{
					setState(2954); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2957); match(NATIONAL);
				setState(2958); match(CHARACTER);
				setState(2959); match(VARYING);
				setState(2961);
				switch ( getInterpreter().adaptivePredict(_input,398,_ctx) ) {
				case 1:
					{
					setState(2960); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2963); match(NATIONAL);
				setState(2964); match(CHAR);
				setState(2965); match(VARYING);
				setState(2967);
				switch ( getInterpreter().adaptivePredict(_input,399,_ctx) ) {
				case 1:
					{
					setState(2966); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2969); match(NCHAR);
				setState(2970); match(VARYING);
				setState(2972);
				switch ( getInterpreter().adaptivePredict(_input,400,_ctx) ) {
				case 1:
					{
					setState(2971); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2974); match(NVARCHAR);
				setState(2976);
				switch ( getInterpreter().adaptivePredict(_input,401,_ctx) ) {
				case 1:
					{
					setState(2975); type_length();
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
		enterRule(_localctx, 166, RULE_binary_large_object_string_type);
		try {
			setState(2988);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(2980); match(BLOB);
				setState(2982);
				switch ( getInterpreter().adaptivePredict(_input,403,_ctx) ) {
				case 1:
					{
					setState(2981); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(2984); match(BYTEA);
				setState(2986);
				switch ( getInterpreter().adaptivePredict(_input,404,_ctx) ) {
				case 1:
					{
					setState(2985); type_length();
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
		enterRule(_localctx, 168, RULE_numeric_type);
		try {
			setState(2992);
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
				setState(2990); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2991); approximate_numeric_type();
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
		enterRule(_localctx, 170, RULE_exact_numeric_type);
		int _la;
		try {
			setState(3007);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2994); match(NUMERIC);
				setState(2996);
				switch ( getInterpreter().adaptivePredict(_input,407,_ctx) ) {
				case 1:
					{
					setState(2995); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2998); match(DECIMAL);
				setState(3000);
				switch ( getInterpreter().adaptivePredict(_input,408,_ctx) ) {
				case 1:
					{
					setState(2999); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(3002); match(DEC);
				setState(3004);
				switch ( getInterpreter().adaptivePredict(_input,409,_ctx) ) {
				case 1:
					{
					setState(3003); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
				enterOuterAlt(_localctx, 4);
				{
				setState(3006);
				_la = _input.LA(1);
				if ( !(((((_la - 300)) & ~0x3f) == 0 && ((1L << (_la - 300)) & ((1L << (INT1 - 300)) | (1L << (INT2 - 300)) | (1L << (INT4 - 300)) | (1L << (INT8 - 300)) | (1L << (TINYINT - 300)) | (1L << (SMALLINT - 300)) | (1L << (INT - 300)) | (1L << (INTEGER - 300)) | (1L << (BIGINT - 300)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
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
		enterRule(_localctx, 172, RULE_approximate_numeric_type);
		int _la;
		try {
			setState(3018);
			switch (_input.LA(1)) {
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(3009); match(FLOAT);
				setState(3011);
				switch ( getInterpreter().adaptivePredict(_input,411,_ctx) ) {
				case 1:
					{
					setState(3010); precision_param();
					}
					break;
				}
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(3013);
				_la = _input.LA(1);
				if ( !(((((_la - 309)) & ~0x3f) == 0 && ((1L << (_la - 309)) & ((1L << (FLOAT4 - 309)) | (1L << (FLOAT8 - 309)) | (1L << (REAL - 309)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(3014); match(DOUBLE);
				setState(3016);
				switch ( getInterpreter().adaptivePredict(_input,412,_ctx) ) {
				case 1:
					{
					setState(3015); match(PRECISION);
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
		enterRule(_localctx, 174, RULE_precision_param);
		try {
			setState(3028);
			switch ( getInterpreter().adaptivePredict(_input,414,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3020); match(LEFT_PAREN);
				setState(3021); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(3022); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3023); match(LEFT_PAREN);
				setState(3024); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(3025); match(COMMA);
				setState(3026); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(3027); match(RIGHT_PAREN);
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
		enterRule(_localctx, 176, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3030);
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
		enterRule(_localctx, 178, RULE_datetime_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3047);
			switch (_input.LA(1)) {
			case DATE:
				{
				setState(3032); match(DATE);
				}
				break;
			case TIME:
				{
				setState(3033); match(TIME);
				setState(3037);
				switch ( getInterpreter().adaptivePredict(_input,415,_ctx) ) {
				case 1:
					{
					setState(3034); match(WITH);
					setState(3035); match(TIME);
					setState(3036); match(ZONE);
					}
					break;
				}
				}
				break;
			case TIMETZ:
				{
				setState(3039); match(TIMETZ);
				}
				break;
			case TIMESTAMP:
				{
				setState(3040); match(TIMESTAMP);
				setState(3044);
				switch ( getInterpreter().adaptivePredict(_input,416,_ctx) ) {
				case 1:
					{
					setState(3041);
					_la = _input.LA(1);
					if ( !(_la==WITH || _la==WITHOUT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(3042); match(TIME);
					setState(3043); match(ZONE);
					}
					break;
				}
				}
				break;
			case TIMESTAMPTZ:
				{
				setState(3046); match(TIMESTAMPTZ);
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
		enterRule(_localctx, 180, RULE_bit_type);
		try {
			setState(3062);
			switch ( getInterpreter().adaptivePredict(_input,421,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3049); match(BIT);
				setState(3051);
				switch ( getInterpreter().adaptivePredict(_input,418,_ctx) ) {
				case 1:
					{
					setState(3050); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3053); match(VARBIT);
				setState(3055);
				switch ( getInterpreter().adaptivePredict(_input,419,_ctx) ) {
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
				setState(3057); match(BIT);
				setState(3058); match(VARYING);
				setState(3060);
				switch ( getInterpreter().adaptivePredict(_input,420,_ctx) ) {
				case 1:
					{
					setState(3059); type_length();
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
		enterRule(_localctx, 182, RULE_binary_type);
		try {
			setState(3077);
			switch ( getInterpreter().adaptivePredict(_input,425,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3064); match(BINARY);
				setState(3066);
				switch ( getInterpreter().adaptivePredict(_input,422,_ctx) ) {
				case 1:
					{
					setState(3065); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3068); match(BINARY);
				setState(3069); match(VARYING);
				setState(3071);
				switch ( getInterpreter().adaptivePredict(_input,423,_ctx) ) {
				case 1:
					{
					setState(3070); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3073); match(VARBINARY);
				setState(3075);
				switch ( getInterpreter().adaptivePredict(_input,424,_ctx) ) {
				case 1:
					{
					setState(3074); type_length();
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
		enterRule(_localctx, 184, RULE_value_expression_primary);
		try {
			setState(3081);
			switch ( getInterpreter().adaptivePredict(_input,426,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3079); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3080); nonparenthesized_value_expression_primary();
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
		enterRule(_localctx, 186, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3083); match(LEFT_PAREN);
			setState(3084); value_expression();
			setState(3085); match(RIGHT_PAREN);
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
		public All_arrayContext all_array() {
			return getRuleContext(All_arrayContext.class,0);
		}
		public Scalar_subqueryContext scalar_subquery() {
			return getRuleContext(Scalar_subqueryContext.class,0);
		}
		public Cast_specificationContext cast_specification() {
			return getRuleContext(Cast_specificationContext.class,0);
		}
		public Function_definition_name_parenContext function_definition_name_paren() {
			return getRuleContext(Function_definition_name_parenContext.class,0);
		}
		public Case_abbreviationContext case_abbreviation() {
			return getRuleContext(Case_abbreviationContext.class,0);
		}
		public Set_function_specificationContext set_function_specification() {
			return getRuleContext(Set_function_specificationContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Column_referenceContext column_reference() {
			return getRuleContext(Column_referenceContext.class,0);
		}
		public Query_specificationContext query_specification() {
			return getRuleContext(Query_specificationContext.class,0);
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
		enterRule(_localctx, 188, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(3098);
			switch ( getInterpreter().adaptivePredict(_input,427,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3087); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3088); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3089); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3090); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3091); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3092); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3093); function_definition_name_paren();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(3094); match(NULL);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(3095); query_specification();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(3096); all_array();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(3097); case_abbreviation();
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
		enterRule(_localctx, 190, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3100); unsigned_literal();
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
		enterRule(_localctx, 192, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3102);
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
		enterRule(_localctx, 194, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3105);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(3104); sign();
				}
			}

			setState(3107); unsigned_numeric_literal();
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
		enterRule(_localctx, 196, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3109); aggregate_function();
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
		enterRule(_localctx, 198, RULE_aggregate_function);
		try {
			setState(3119);
			switch ( getInterpreter().adaptivePredict(_input,430,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3111); match(COUNT);
				setState(3112); match(LEFT_PAREN);
				setState(3113); match(MULTIPLY);
				setState(3114); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3115); general_set_function();
				setState(3117);
				switch ( getInterpreter().adaptivePredict(_input,429,_ctx) ) {
				case 1:
					{
					setState(3116); filter_clause();
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
		enterRule(_localctx, 200, RULE_general_set_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3121); set_function_type();
			setState(3122); match(LEFT_PAREN);
			setState(3124);
			switch ( getInterpreter().adaptivePredict(_input,431,_ctx) ) {
			case 1:
				{
				setState(3123); set_qualifier();
				}
				break;
			}
			setState(3126); value_expression();
			setState(3127); match(RIGHT_PAREN);
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
		enterRule(_localctx, 202, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3129);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (SOME - 117)) | (1L << (AVG - 117)) | (1L << (COLLECT - 117)) | (1L << (COUNT - 117)))) != 0) || ((((_la - 181)) & ~0x3f) == 0 && ((1L << (_la - 181)) & ((1L << (EVERY - 181)) | (1L << (FUSION - 181)) | (1L << (INTERSECTION - 181)) | (1L << (MAX - 181)) | (1L << (MIN - 181)))) != 0) || ((((_la - 265)) & ~0x3f) == 0 && ((1L << (_la - 265)) & ((1L << (STDDEV_POP - 265)) | (1L << (STDDEV_SAMP - 265)) | (1L << (SUM - 265)) | (1L << (VAR_SAMP - 265)) | (1L << (VAR_POP - 265)))) != 0)) ) {
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
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
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
		enterRule(_localctx, 204, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3131); match(FILTER);
			setState(3132); match(LEFT_PAREN);
			setState(3133); where_clause();
			setState(3134); match(RIGHT_PAREN);
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
		enterRule(_localctx, 206, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3136); match(GROUPING);
			setState(3137); match(LEFT_PAREN);
			setState(3138); column_reference_list();
			setState(3139); match(RIGHT_PAREN);
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
		enterRule(_localctx, 208, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3141); case_specification();
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
		public TerminalNode NULLIF() { return getToken(SQLParser.NULLIF, 0); }
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
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
		enterRule(_localctx, 210, RULE_case_abbreviation);
		int _la;
		try {
			setState(3161);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(3143); match(NULLIF);
				setState(3144); match(LEFT_PAREN);
				setState(3145); numeric_value_expression();
				setState(3146); match(COMMA);
				setState(3147); value_expression();
				setState(3148); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3150); match(COALESCE);
				setState(3151); match(LEFT_PAREN);
				setState(3152); numeric_value_expression();
				setState(3155); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(3153); match(COMMA);
					setState(3154); value_expression();
					}
					}
					setState(3157); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(3159); match(RIGHT_PAREN);
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
		enterRule(_localctx, 212, RULE_case_specification);
		try {
			setState(3165);
			switch ( getInterpreter().adaptivePredict(_input,434,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3163); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3164); searched_case();
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
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
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
		enterRule(_localctx, 214, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3167); match(CASE);
			setState(3168); value_expression();
			setState(3170); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3169); simple_when_clause();
				}
				}
				setState(3172); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(3175);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(3174); else_clause();
				}
			}

			setState(3177); match(END);
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
		enterRule(_localctx, 216, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3179); match(CASE);
			setState(3181); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3180); searched_when_clause();
				}
				}
				setState(3183); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(3186);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(3185); else_clause();
				}
			}

			setState(3188); match(END);
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
		enterRule(_localctx, 218, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3190); match(WHEN);
			setState(3191); search_condition();
			setState(3192); match(THEN);
			setState(3193); result();
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
		enterRule(_localctx, 220, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3195); match(WHEN);
			setState(3196); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(3197); match(THEN);
			setState(3198); ((Searched_when_clauseContext)_localctx).r = result();
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
		enterRule(_localctx, 222, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3200); match(ELSE);
			setState(3201); ((Else_clauseContext)_localctx).r = result();
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
		enterRule(_localctx, 224, RULE_result);
		try {
			setState(3205);
			switch ( getInterpreter().adaptivePredict(_input,439,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3203); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3204); match(NULL);
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
		enterRule(_localctx, 226, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3207); match(CAST);
			setState(3208); match(LEFT_PAREN);
			setState(3209); cast_operand();
			setState(3210); match(AS);
			setState(3211); cast_target();
			setState(3212); match(RIGHT_PAREN);
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
		enterRule(_localctx, 228, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3214); value_expression();
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
		enterRule(_localctx, 230, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3216); data_type();
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
		public Array_expressionContext array_expression() {
			return getRuleContext(Array_expressionContext.class,0);
		}
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
		enterRule(_localctx, 232, RULE_value_expression);
		try {
			setState(3222);
			switch ( getInterpreter().adaptivePredict(_input,440,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3218); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3219); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3220); boolean_value_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3221); array_expression();
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

	public static class Array_expressionContext extends ParserRuleContext {
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(SQLParser.LEFT_BRACKET, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(SQLParser.RIGHT_BRACKET, 0); }
		public TerminalNode ARRAY() { return getToken(SQLParser.ARRAY, 0); }
		public Array_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterArray_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitArray_expression(this);
		}
	}

	public final Array_expressionContext array_expression() throws RecognitionException {
		Array_expressionContext _localctx = new Array_expressionContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_array_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3224); match(ARRAY);
			setState(3225); match(LEFT_BRACKET);
			setState(3226); value_expression();
			setState(3231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3227); match(COMMA);
				setState(3228); value_expression();
				}
				}
				setState(3233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3234); match(RIGHT_BRACKET);
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

	public static class All_arrayContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public Array_expressionContext array_expression() {
			return getRuleContext(Array_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public All_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_all_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAll_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAll_array(this);
		}
	}

	public final All_arrayContext all_array() throws RecognitionException {
		All_arrayContext _localctx = new All_arrayContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_all_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3236); match(ALL);
			setState(3237); match(LEFT_PAREN);
			setState(3238); array_expression();
			setState(3239); match(RIGHT_PAREN);
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

	public static class Bit_operationContext extends ParserRuleContext {
		public TerminalNode BIT_AND() { return getToken(SQLParser.BIT_AND, 0); }
		public Character_value_expressionContext character_value_expression(int i) {
			return getRuleContext(Character_value_expressionContext.class,i);
		}
		public List<Character_value_expressionContext> character_value_expression() {
			return getRuleContexts(Character_value_expressionContext.class);
		}
		public Bit_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBit_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBit_operation(this);
		}
	}

	public final Bit_operationContext bit_operation() throws RecognitionException {
		Bit_operationContext _localctx = new Bit_operationContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_bit_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3241); character_value_expression();
			setState(3242); match(BIT_AND);
			setState(3243); character_value_expression();
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
		public Bit_operationContext bit_operation() {
			return getRuleContext(Bit_operationContext.class,0);
		}
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
		enterRule(_localctx, 240, RULE_common_value_expression);
		try {
			setState(3249);
			switch ( getInterpreter().adaptivePredict(_input,442,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3245); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3246); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3247); bit_operation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3248); match(NULL);
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
		enterRule(_localctx, 242, RULE_numeric_value_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3251); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(3256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,443,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3252);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(3253); ((Numeric_value_expressionContext)_localctx).right = term();
					}
					} 
				}
				setState(3258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,443,_ctx);
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
		enterRule(_localctx, 244, RULE_term);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3259); ((TermContext)_localctx).left = factor();
			setState(3264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,444,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3260);
					_la = _input.LA(1);
					if ( !(((((_la - 356)) & ~0x3f) == 0 && ((1L << (_la - 356)) & ((1L << (MULTIPLY - 356)) | (1L << (DIVIDE - 356)) | (1L << (MODULAR - 356)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(3261); ((TermContext)_localctx).right = factor();
					}
					} 
				}
				setState(3266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,444,_ctx);
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
		enterRule(_localctx, 246, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3268);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(3267); sign();
				}
			}

			setState(3270); numeric_primary();
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
		enterRule(_localctx, 248, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3272); match(LEFT_PAREN);
			setState(3273); numeric_value_expression();
			setState(3278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3274); match(COMMA);
				setState(3275); numeric_value_expression();
				}
				}
				setState(3280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3281); match(RIGHT_PAREN);
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
		public Value_expression_primary_castContext value_expression_primary_cast() {
			return getRuleContext(Value_expression_primary_castContext.class,0);
		}
		public Numeric_value_functionContext numeric_value_function() {
			return getRuleContext(Numeric_value_functionContext.class,0);
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
		enterRule(_localctx, 250, RULE_numeric_primary);
		try {
			setState(3285);
			switch ( getInterpreter().adaptivePredict(_input,447,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3283); value_expression_primary_cast();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3284); numeric_value_function();
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

	public static class Value_expression_primary_castContext extends ParserRuleContext {
		public Cast_targetContext cast_target(int i) {
			return getRuleContext(Cast_targetContext.class,i);
		}
		public List<Cast_targetContext> cast_target() {
			return getRuleContexts(Cast_targetContext.class);
		}
		public List<TerminalNode> CAST_EXPRESSION() { return getTokens(SQLParser.CAST_EXPRESSION); }
		public TerminalNode CAST_EXPRESSION(int i) {
			return getToken(SQLParser.CAST_EXPRESSION, i);
		}
		public Value_expression_primaryContext value_expression_primary() {
			return getRuleContext(Value_expression_primaryContext.class,0);
		}
		public Value_expression_primary_castContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expression_primary_cast; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterValue_expression_primary_cast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitValue_expression_primary_cast(this);
		}
	}

	public final Value_expression_primary_castContext value_expression_primary_cast() throws RecognitionException {
		Value_expression_primary_castContext _localctx = new Value_expression_primary_castContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_value_expression_primary_cast);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3287); value_expression_primary();
			setState(3292);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,448,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3288); match(CAST_EXPRESSION);
					setState(3289); cast_target();
					}
					} 
				}
				setState(3294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,448,_ctx);
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
		enterRule(_localctx, 254, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3295);
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
		enterRule(_localctx, 256, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3297); extract_expression();
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
		enterRule(_localctx, 258, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3299); match(EXTRACT);
			setState(3300); match(LEFT_PAREN);
			setState(3301); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(3302); match(FROM);
			setState(3303); extract_source();
			setState(3304); match(RIGHT_PAREN);
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
		enterRule(_localctx, 260, RULE_extract_field);
		try {
			setState(3309);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3306); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3307); time_zone_field();
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
				setState(3308); extended_datetime_field();
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
		enterRule(_localctx, 262, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3311);
			_la = _input.LA(1);
			if ( !(((((_la - 273)) & ~0x3f) == 0 && ((1L << (_la - 273)) & ((1L << (TIMEZONE - 273)) | (1L << (TIMEZONE_HOUR - 273)) | (1L << (TIMEZONE_MINUTE - 273)))) != 0)) ) {
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
		enterRule(_localctx, 264, RULE_extract_source);
		try {
			setState(3315);
			switch ( getInterpreter().adaptivePredict(_input,450,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3313); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3314); datetime_literal();
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
		enterRule(_localctx, 266, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3317); character_value_expression();
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
		public Character_value_expressionContext character_value_expression() {
			return getRuleContext(Character_value_expressionContext.class,0);
		}
		public Character_factorContext character_factor(int i) {
			return getRuleContext(Character_factorContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
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
		enterRule(_localctx, 268, RULE_character_value_expression);
		try {
			int _alt;
			setState(3331);
			switch ( getInterpreter().adaptivePredict(_input,452,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3319); character_factor();
				setState(3324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,451,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(3320); match(CONCATENATION_OPERATOR);
						setState(3321); character_factor();
						}
						} 
					}
					setState(3326);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,451,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3327); match(LEFT_PAREN);
				setState(3328); character_value_expression();
				setState(3329); match(RIGHT_PAREN);
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
		enterRule(_localctx, 270, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3333); character_primary();
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
		public Value_expression_primary_castContext value_expression_primary_cast() {
			return getRuleContext(Value_expression_primary_castContext.class,0);
		}
		public String_value_functionContext string_value_function() {
			return getRuleContext(String_value_functionContext.class,0);
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
		enterRule(_localctx, 272, RULE_character_primary);
		try {
			setState(3337);
			switch ( getInterpreter().adaptivePredict(_input,453,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3335); value_expression_primary_cast();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3336); string_value_function();
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
		enterRule(_localctx, 274, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3339); trim_function();
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
		enterRule(_localctx, 276, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3341); match(TRIM);
			setState(3342); match(LEFT_PAREN);
			setState(3343); trim_operands();
			setState(3344); match(RIGHT_PAREN);
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
		enterRule(_localctx, 278, RULE_trim_operands);
		int _la;
		try {
			setState(3360);
			switch ( getInterpreter().adaptivePredict(_input,457,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3353);
				switch ( getInterpreter().adaptivePredict(_input,456,_ctx) ) {
				case 1:
					{
					setState(3347);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(3346); trim_specification();
						}
					}

					setState(3350);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (NULL - 86)) | (1L << (REPLACE - 86)) | (1L << (SELECT - 86)) | (1L << (SOME - 86)) | (1L << (TRUE - 86)) | (1L << (ADMIN - 86)) | (1L << (ALWAYS - 86)) | (1L << (ARRAY - 86)) | (1L << (AVG - 86)) | (1L << (BETWEEN - 86)) | (1L << (BY - 86)) | (1L << (CACHE - 86)) | (1L << (CALLED - 86)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (CLASS - 150)) | (1L << (CENTURY - 150)) | (1L << (CHARACTER - 150)) | (1L << (CHECK - 150)) | (1L << (CLUSTER - 150)) | (1L << (COLLECT - 150)) | (1L << (COALESCE - 150)) | (1L << (COLUMN - 150)) | (1L << (COMMENT - 150)) | (1L << (COMMENTS - 150)) | (1L << (COMMIT - 150)) | (1L << (CONCURRENTLY - 150)) | (1L << (CONFIGURATION - 150)) | (1L << (COST - 150)) | (1L << (COUNT - 150)) | (1L << (CUBE - 150)) | (1L << (CURRENT - 150)) | (1L << (CYCLE - 150)) | (1L << (DATA - 150)) | (1L << (DAY - 150)) | (1L << (DEC - 150)) | (1L << (DECADE - 150)) | (1L << (DEFINER - 150)) | (1L << (DICTIONARY - 150)) | (1L << (DISABLE - 150)) | (1L << (DOW - 150)) | (1L << (DOY - 150)) | (1L << (DROP - 150)) | (1L << (ENABLE - 150)) | (1L << (EPOCH - 150)) | (1L << (EVENT - 150)) | (1L << (EVERY - 150)) | (1L << (EXISTS - 150)) | (1L << (EXTENDED - 150)) | (1L << (EXTERNAL - 150)) | (1L << (EXTRACT - 150)) | (1L << (FAMILY - 150)) | (1L << (FILTER - 150)) | (1L << (FIRST - 150)) | (1L << (FORMAT - 150)) | (1L << (FUSION - 150)) | (1L << (GROUPING - 150)) | (1L << (HASH - 150)) | (1L << (INHERIT - 150)) | (1L << (INDEX - 150)) | (1L << (INCREMENT - 150)) | (1L << (INPUT - 150)) | (1L << (INSERT - 150)) | (1L << (INTERSECTION - 150)) | (1L << (ISCACHABLE - 150)) | (1L << (ISODOW - 150)) | (1L << (ISOYEAR - 150)) | (1L << (ISSTRICT - 150)) | (1L << (LANGUAGE - 150)) | (1L << (LARGE - 150)) | (1L << (LAST - 150)) | (1L << (LESS - 150)) | (1L << (LIST - 150)) | (1L << (LOCATION - 150)) | (1L << (MAIN - 150)) | (1L << (MATCH - 150)) | (1L << (MAX - 150)))) != 0) || ((((_la - 214)) & ~0x3f) == 0 && ((1L << (_la - 214)) & ((1L << (MAXVALUE - 214)) | (1L << (MICROSECONDS - 214)) | (1L << (MILLENNIUM - 214)) | (1L << (MILLISECONDS - 214)) | (1L << (MIN - 214)) | (1L << (MINVALUE - 214)) | (1L << (MINUTE - 214)) | (1L << (MONTH - 214)) | (1L << (NATIONAL - 214)) | (1L << (NO - 214)) | (1L << (NONE - 214)) | (1L << (NULLIF - 214)) | (1L << (OBJECT - 214)) | (1L << (ON - 214)) | (1L << (ONLY - 214)) | (1L << (OPTION - 214)) | (1L << (OPTIONS - 214)) | (1L << (OVER - 214)) | (1L << (OVERWRITE - 214)) | (1L << (PARSER - 214)) | (1L << (PARTIAL - 214)) | (1L << (PARTITION - 214)) | (1L << (PARTITIONS - 214)) | (1L << (PLAIN - 214)) | (1L << (PRECISION - 214)) | (1L << (PUBLIC - 214)) | (1L << (PURGE - 214)) | (1L << (QUARTER - 214)) | (1L << (RANGE - 214)) | (1L << (REGCONFIG - 214)) | (1L << (REGEXP - 214)) | (1L << (RENAME - 214)) | (1L << (REPLICA - 214)) | (1L << (RESET - 214)) | (1L << (RESTART - 214)) | (1L << (RLIKE - 214)) | (1L << (ROLLUP - 214)) | (1L << (SEARCH - 214)) | (1L << (SECOND - 214)) | (1L << (SECURITY - 214)) | (1L << (SERVER - 214)) | (1L << (SET - 214)) | (1L << (SIMILAR - 214)) | (1L << (SIMPLE - 214)) | (1L << (STABLE - 214)) | (1L << (START - 214)) | (1L << (STATISTICS - 214)) | (1L << (STDIN - 214)) | (1L << (STORAGE - 214)) | (1L << (STDDEV_POP - 214)) | (1L << (STDDEV_SAMP - 214)) | (1L << (SUBPARTITION - 214)) | (1L << (SUM - 214)) | (1L << (TABLESPACE - 214)) | (1L << (TEMPLATE - 214)) | (1L << (THAN - 214)) | (1L << (TIMEZONE - 214)) | (1L << (TIMEZONE_HOUR - 214)) | (1L << (TIMEZONE_MINUTE - 214)) | (1L << (TRIM - 214)) | (1L << (TO - 214)))) != 0) || ((((_la - 278)) & ~0x3f) == 0 && ((1L << (_la - 278)) & ((1L << (TYPE - 278)) | (1L << (TYPES - 278)) | (1L << (UNKNOWN - 278)) | (1L << (UNLOGGED - 278)) | (1L << (USER - 278)) | (1L << (VALID - 278)) | (1L << (VALIDATE - 278)) | (1L << (VALUES - 278)) | (1L << (VAR_SAMP - 278)) | (1L << (VAR_POP - 278)) | (1L << (VARYING - 278)) | (1L << (VERSION - 278)) | (1L << (VOLATILE - 278)) | (1L << (WEEK - 278)) | (1L << (WINDOW - 278)) | (1L << (WRAPPER - 278)) | (1L << (YEAR - 278)) | (1L << (ZONE - 278)) | (1L << (BOOLEAN - 278)) | (1L << (BOOL - 278)) | (1L << (BIT - 278)) | (1L << (VARBIT - 278)) | (1L << (INT1 - 278)) | (1L << (INT2 - 278)) | (1L << (INT4 - 278)) | (1L << (INT8 - 278)) | (1L << (TINYINT - 278)) | (1L << (SMALLINT - 278)) | (1L << (INT - 278)) | (1L << (INTEGER - 278)) | (1L << (BIGINT - 278)) | (1L << (FLOAT4 - 278)) | (1L << (FLOAT8 - 278)) | (1L << (REAL - 278)) | (1L << (FLOAT - 278)) | (1L << (DOUBLE - 278)) | (1L << (NUMERIC - 278)) | (1L << (DECIMAL - 278)) | (1L << (CHAR - 278)) | (1L << (VARCHAR - 278)) | (1L << (NCHAR - 278)) | (1L << (NVARCHAR - 278)) | (1L << (DATE - 278)) | (1L << (TIME - 278)) | (1L << (TIMETZ - 278)) | (1L << (TIMESTAMP - 278)) | (1L << (TIMESTAMPTZ - 278)) | (1L << (TEXT - 278)) | (1L << (UUID - 278)) | (1L << (VARBINARY - 278)) | (1L << (BLOB - 278)) | (1L << (BYTEA - 278)) | (1L << (INET4 - 278)) | (1L << (INET - 278)) | (1L << (INTERVAL - 278)) | (1L << (VOID - 278)))) != 0) || ((((_la - 352)) & ~0x3f) == 0 && ((1L << (_la - 352)) & ((1L << (LEFT_PAREN - 352)) | (1L << (DOUBLE_QUOTE - 352)) | (1L << (NUMBER - 352)) | (1L << (REAL_NUMBER - 352)) | (1L << (Identifier - 352)) | (1L << (QuotedIdentifier - 352)) | (1L << (Character_String_Literal - 352)))) != 0)) {
						{
						setState(3349); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(3352); match(FROM);
					}
					break;
				}
				setState(3355); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3356); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(3357); match(COMMA);
				setState(3358); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
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
		enterRule(_localctx, 280, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3362);
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
		enterRule(_localctx, 282, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3364); or_predicate();
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
		enterRule(_localctx, 284, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3366); and_predicate();
			setState(3371);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,458,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3367); match(OR);
					setState(3368); or_predicate();
					}
					} 
				}
				setState(3373);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,458,_ctx);
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
		enterRule(_localctx, 286, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3374); boolean_factor();
			setState(3379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,459,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3375); match(AND);
					setState(3376); and_predicate();
					}
					} 
				}
				setState(3381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,459,_ctx);
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
		enterRule(_localctx, 288, RULE_boolean_factor);
		try {
			setState(3385);
			switch ( getInterpreter().adaptivePredict(_input,460,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3382); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3383); match(NOT);
				setState(3384); boolean_test();
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
		enterRule(_localctx, 290, RULE_boolean_test);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3387); boolean_primary();
			setState(3389);
			switch ( getInterpreter().adaptivePredict(_input,461,_ctx) ) {
			case 1:
				{
				setState(3388); is_clause();
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
		enterRule(_localctx, 292, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3391); match(IS);
			setState(3393);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3392); match(NOT);
				}
			}

			setState(3395); ((Is_clauseContext)_localctx).t = truth_value();
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
		enterRule(_localctx, 294, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3397);
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
		enterRule(_localctx, 296, RULE_boolean_primary);
		try {
			setState(3401);
			switch ( getInterpreter().adaptivePredict(_input,463,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3399); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3400); boolean_predicand();
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
		enterRule(_localctx, 298, RULE_boolean_predicand);
		try {
			setState(3405);
			switch ( getInterpreter().adaptivePredict(_input,464,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3403); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3404); nonparenthesized_value_expression_primary();
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
		enterRule(_localctx, 300, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3407); match(LEFT_PAREN);
			setState(3408); boolean_value_expression();
			setState(3409); match(RIGHT_PAREN);
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
		enterRule(_localctx, 302, RULE_row_value_expression);
		try {
			setState(3413);
			switch ( getInterpreter().adaptivePredict(_input,465,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3411); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3412); explicit_row_value_constructor();
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
		enterRule(_localctx, 304, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3415); nonparenthesized_value_expression_primary();
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
		enterRule(_localctx, 306, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3417); match(NULL);
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
		enterRule(_localctx, 308, RULE_row_value_predicand);
		try {
			setState(3421);
			switch ( getInterpreter().adaptivePredict(_input,466,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3419); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3420); row_value_constructor_predicand();
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
		enterRule(_localctx, 310, RULE_row_value_constructor_predicand);
		try {
			setState(3425);
			switch ( getInterpreter().adaptivePredict(_input,467,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3423); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3424); boolean_predicand();
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
		enterRule(_localctx, 312, RULE_table_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3427); from_clause();
			setState(3429);
			switch ( getInterpreter().adaptivePredict(_input,468,_ctx) ) {
			case 1:
				{
				setState(3428); where_clause();
				}
				break;
			}
			setState(3432);
			switch ( getInterpreter().adaptivePredict(_input,469,_ctx) ) {
			case 1:
				{
				setState(3431); groupby_clause();
				}
				break;
			}
			setState(3435);
			switch ( getInterpreter().adaptivePredict(_input,470,_ctx) ) {
			case 1:
				{
				setState(3434); having_clause();
				}
				break;
			}
			setState(3438);
			switch ( getInterpreter().adaptivePredict(_input,471,_ctx) ) {
			case 1:
				{
				setState(3437); orderby_clause();
				}
				break;
			}
			setState(3441);
			switch ( getInterpreter().adaptivePredict(_input,472,_ctx) ) {
			case 1:
				{
				setState(3440); limit_clause();
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

	public static class From_clauseContext extends ParserRuleContext {
		public Table_reference_listContext table_reference_list() {
			return getRuleContext(Table_reference_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public As_clauseContext as_clause() {
			return getRuleContext(As_clauseContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Query_specificationContext query_specification() {
			return getRuleContext(Query_specificationContext.class,0);
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
		enterRule(_localctx, 314, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3443); match(FROM);
			setState(3445);
			switch ( getInterpreter().adaptivePredict(_input,473,_ctx) ) {
			case 1:
				{
				setState(3444); match(LEFT_PAREN);
				}
				break;
			}
			setState(3449);
			switch (_input.LA(1)) {
			case REPLACE:
			case ADMIN:
			case ALWAYS:
			case ARRAY:
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
			case CONCURRENTLY:
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
			case EVENT:
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
			case OVER:
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
			case REGCONFIG:
			case REGEXP:
			case RENAME:
			case REPLICA:
			case RESET:
			case RESTART:
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
			case STDIN:
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
			case TYPES:
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
			case INET:
			case INTERVAL:
			case VOID:
			case LEFT_PAREN:
			case DOUBLE_QUOTE:
			case Identifier:
			case QuotedIdentifier:
				{
				setState(3447); table_reference_list();
				}
				break;
			case SELECT:
				{
				setState(3448); query_specification();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(3452);
			switch ( getInterpreter().adaptivePredict(_input,475,_ctx) ) {
			case 1:
				{
				setState(3451); match(RIGHT_PAREN);
				}
				break;
			}
			setState(3455);
			switch ( getInterpreter().adaptivePredict(_input,476,_ctx) ) {
			case 1:
				{
				setState(3454); as_clause();
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
		enterRule(_localctx, 316, RULE_table_reference_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3457); table_reference();
			setState(3462);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,477,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3458); match(COMMA);
					setState(3459); table_reference();
					}
					} 
				}
				setState(3464);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,477,_ctx);
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
		enterRule(_localctx, 318, RULE_table_reference);
		try {
			setState(3467);
			switch ( getInterpreter().adaptivePredict(_input,478,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3465); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3466); table_primary();
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
		enterRule(_localctx, 320, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3469); table_primary();
			setState(3471); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(3470); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(3473); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,479,_ctx);
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
		enterRule(_localctx, 322, RULE_joined_table_primary);
		int _la;
		try {
			setState(3494);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(3475); match(CROSS);
				setState(3476); match(JOIN);
				setState(3477); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3479);
				_la = _input.LA(1);
				if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (FULL - 51)) | (1L << (INNER - 51)) | (1L << (LEFT - 51)) | (1L << (RIGHT - 51)))) != 0)) {
					{
					setState(3478); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3481); match(JOIN);
				setState(3482); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(3483); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(3485); match(NATURAL);
				setState(3487);
				_la = _input.LA(1);
				if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (FULL - 51)) | (1L << (INNER - 51)) | (1L << (LEFT - 51)) | (1L << (RIGHT - 51)))) != 0)) {
					{
					setState(3486); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3489); match(JOIN);
				setState(3490); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(3491); match(UNION);
				setState(3492); match(JOIN);
				setState(3493); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 324, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3496); match(CROSS);
			setState(3497); match(JOIN);
			setState(3498); ((Cross_joinContext)_localctx).r = table_primary();
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
		enterRule(_localctx, 326, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3501);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (FULL - 51)) | (1L << (INNER - 51)) | (1L << (LEFT - 51)) | (1L << (RIGHT - 51)))) != 0)) {
				{
				setState(3500); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(3503); match(JOIN);
			setState(3504); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(3505); ((Qualified_joinContext)_localctx).s = join_specification();
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
		enterRule(_localctx, 328, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3507); match(NATURAL);
			setState(3509);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (FULL - 51)) | (1L << (INNER - 51)) | (1L << (LEFT - 51)) | (1L << (RIGHT - 51)))) != 0)) {
				{
				setState(3508); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(3511); match(JOIN);
			setState(3512); ((Natural_joinContext)_localctx).r = table_primary();
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
		enterRule(_localctx, 330, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3514); match(UNION);
			setState(3515); match(JOIN);
			setState(3516); ((Union_joinContext)_localctx).r = table_primary();
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
		enterRule(_localctx, 332, RULE_join_type);
		try {
			setState(3520);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3518); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3519); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 334, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3522); outer_join_type_part2();
			setState(3524);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(3523); match(OUTER);
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
		enterRule(_localctx, 336, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3526);
			_la = _input.LA(1);
			if ( !(((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (FULL - 51)) | (1L << (LEFT - 51)) | (1L << (RIGHT - 51)))) != 0)) ) {
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
		enterRule(_localctx, 338, RULE_join_specification);
		try {
			setState(3530);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(3528); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(3529); named_columns_join();
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
		enterRule(_localctx, 340, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3532); match(ON);
			setState(3533); search_condition();
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
		enterRule(_localctx, 342, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3535); match(USING);
			setState(3536); match(LEFT_PAREN);
			setState(3537); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(3538); match(RIGHT_PAREN);
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
		public Alias_defContext alias;
		public IdentifierContext name;
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Alias_tableContext alias_table() {
			return getRuleContext(Alias_tableContext.class,0);
		}
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
		public Alias_defContext alias_def() {
			return getRuleContext(Alias_defContext.class,0);
		}
		public Table_referenceContext table_reference() {
			return getRuleContext(Table_referenceContext.class,0);
		}
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
		enterRule(_localctx, 344, RULE_table_primary);
		int _la;
		try {
			setState(3571);
			switch ( getInterpreter().adaptivePredict(_input,494,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3542);
				switch ( getInterpreter().adaptivePredict(_input,488,_ctx) ) {
				case 1:
					{
					setState(3540); alias_table();
					}
					break;
				case 2:
					{
					setState(3541); table_or_query_name();
					}
					break;
				}
				setState(3548);
				switch ( getInterpreter().adaptivePredict(_input,490,_ctx) ) {
				case 1:
					{
					setState(3545);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(3544); match(AS);
						}
					}

					setState(3547); ((Table_primaryContext)_localctx).alias = alias_def();
					}
					break;
				}
				setState(3554);
				switch ( getInterpreter().adaptivePredict(_input,491,_ctx) ) {
				case 1:
					{
					setState(3550); match(LEFT_PAREN);
					setState(3551); column_name_list();
					setState(3552); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3556); derived_table();
				setState(3558);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3557); match(AS);
					}
				}

				setState(3560); ((Table_primaryContext)_localctx).name = identifier();
				setState(3565);
				switch ( getInterpreter().adaptivePredict(_input,493,_ctx) ) {
				case 1:
					{
					setState(3561); match(LEFT_PAREN);
					setState(3562); column_name_list();
					setState(3563); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3567); match(LEFT_PAREN);
				setState(3568); table_reference();
				setState(3569); match(RIGHT_PAREN);
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
		enterRule(_localctx, 346, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3573); identifier();
			setState(3578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3574); match(COMMA);
				setState(3575); identifier();
				}
				}
				setState(3580);
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

	public static class Alias_defContext extends ParserRuleContext {
		public Alias_tableContext alias_table() {
			return getRuleContext(Alias_tableContext.class,0);
		}
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Alias_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAlias_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAlias_def(this);
		}
	}

	public final Alias_defContext alias_def() throws RecognitionException {
		Alias_defContext _localctx = new Alias_defContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_alias_def);
		try {
			setState(3583);
			switch ( getInterpreter().adaptivePredict(_input,496,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3581); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3582); alias_table();
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

	public static class Alias_tableContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
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
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
		}
		public Alias_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAlias_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAlias_table(this);
		}
	}

	public final Alias_tableContext alias_table() throws RecognitionException {
		Alias_tableContext _localctx = new Alias_tableContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_alias_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3585); schema_qualified_name();
			setState(3586); match(LEFT_PAREN);
			setState(3595);
			_la = _input.LA(1);
			if (((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (REPLACE - 105)) | (1L << (ADMIN - 105)) | (1L << (ALWAYS - 105)) | (1L << (ARRAY - 105)) | (1L << (AVG - 105)) | (1L << (BETWEEN - 105)) | (1L << (BY - 105)) | (1L << (CACHE - 105)) | (1L << (CALLED - 105)) | (1L << (CLASS - 105)) | (1L << (CENTURY - 105)) | (1L << (CHARACTER - 105)) | (1L << (CHECK - 105)) | (1L << (CLUSTER - 105)) | (1L << (COLLECT - 105)) | (1L << (COALESCE - 105)) | (1L << (COLUMN - 105)) | (1L << (COMMENT - 105)) | (1L << (COMMENTS - 105)) | (1L << (COMMIT - 105)) | (1L << (CONCURRENTLY - 105)) | (1L << (CONFIGURATION - 105)) | (1L << (COST - 105)) | (1L << (COUNT - 105)) | (1L << (CUBE - 105)) | (1L << (CURRENT - 105)) | (1L << (CYCLE - 105)) | (1L << (DATA - 105)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (DEC - 169)) | (1L << (DECADE - 169)) | (1L << (DEFINER - 169)) | (1L << (DICTIONARY - 169)) | (1L << (DISABLE - 169)) | (1L << (DOW - 169)) | (1L << (DOY - 169)) | (1L << (DROP - 169)) | (1L << (ENABLE - 169)) | (1L << (EPOCH - 169)) | (1L << (EVENT - 169)) | (1L << (EVERY - 169)) | (1L << (EXISTS - 169)) | (1L << (EXTENDED - 169)) | (1L << (EXTERNAL - 169)) | (1L << (EXTRACT - 169)) | (1L << (FAMILY - 169)) | (1L << (FILTER - 169)) | (1L << (FIRST - 169)) | (1L << (FORMAT - 169)) | (1L << (FUSION - 169)) | (1L << (GROUPING - 169)) | (1L << (HASH - 169)) | (1L << (INHERIT - 169)) | (1L << (INDEX - 169)) | (1L << (INCREMENT - 169)) | (1L << (INPUT - 169)) | (1L << (INSERT - 169)) | (1L << (INTERSECTION - 169)) | (1L << (ISCACHABLE - 169)) | (1L << (ISODOW - 169)) | (1L << (ISOYEAR - 169)) | (1L << (ISSTRICT - 169)) | (1L << (LANGUAGE - 169)) | (1L << (LARGE - 169)) | (1L << (LAST - 169)) | (1L << (LESS - 169)) | (1L << (LIST - 169)) | (1L << (LOCATION - 169)) | (1L << (MAIN - 169)) | (1L << (MATCH - 169)) | (1L << (MAX - 169)) | (1L << (MAXVALUE - 169)) | (1L << (MICROSECONDS - 169)) | (1L << (MILLENNIUM - 169)) | (1L << (MILLISECONDS - 169)) | (1L << (MIN - 169)) | (1L << (MINVALUE - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)) | (1L << (NATIONAL - 169)) | (1L << (NO - 169)) | (1L << (NONE - 169)) | (1L << (NULLIF - 169)) | (1L << (OBJECT - 169)) | (1L << (ON - 169)) | (1L << (ONLY - 169)) | (1L << (OPTION - 169)) | (1L << (OPTIONS - 169)))) != 0) || ((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & ((1L << (OVER - 233)) | (1L << (OVERWRITE - 233)) | (1L << (PARSER - 233)) | (1L << (PARTIAL - 233)) | (1L << (PARTITION - 233)) | (1L << (PARTITIONS - 233)) | (1L << (PLAIN - 233)) | (1L << (PRECISION - 233)) | (1L << (PUBLIC - 233)) | (1L << (PURGE - 233)) | (1L << (QUARTER - 233)) | (1L << (RANGE - 233)) | (1L << (REGCONFIG - 233)) | (1L << (REGEXP - 233)) | (1L << (RENAME - 233)) | (1L << (REPLICA - 233)) | (1L << (RESET - 233)) | (1L << (RESTART - 233)) | (1L << (RLIKE - 233)) | (1L << (ROLLUP - 233)) | (1L << (SEARCH - 233)) | (1L << (SECOND - 233)) | (1L << (SECURITY - 233)) | (1L << (SERVER - 233)) | (1L << (SET - 233)) | (1L << (SIMILAR - 233)) | (1L << (SIMPLE - 233)) | (1L << (STABLE - 233)) | (1L << (START - 233)) | (1L << (STATISTICS - 233)) | (1L << (STDIN - 233)) | (1L << (STORAGE - 233)) | (1L << (STDDEV_POP - 233)) | (1L << (STDDEV_SAMP - 233)) | (1L << (SUBPARTITION - 233)) | (1L << (SUM - 233)) | (1L << (TABLESPACE - 233)) | (1L << (TEMPLATE - 233)) | (1L << (THAN - 233)) | (1L << (TIMEZONE - 233)) | (1L << (TIMEZONE_HOUR - 233)) | (1L << (TIMEZONE_MINUTE - 233)) | (1L << (TRIM - 233)) | (1L << (TO - 233)) | (1L << (TYPE - 233)) | (1L << (TYPES - 233)) | (1L << (UNKNOWN - 233)) | (1L << (UNLOGGED - 233)) | (1L << (USER - 233)) | (1L << (VALID - 233)) | (1L << (VALIDATE - 233)) | (1L << (VALUES - 233)) | (1L << (VAR_SAMP - 233)) | (1L << (VAR_POP - 233)) | (1L << (VARYING - 233)) | (1L << (VERSION - 233)) | (1L << (VOLATILE - 233)) | (1L << (WEEK - 233)) | (1L << (WINDOW - 233)) | (1L << (WRAPPER - 233)) | (1L << (YEAR - 233)) | (1L << (ZONE - 233)) | (1L << (BOOLEAN - 233)))) != 0) || ((((_la - 297)) & ~0x3f) == 0 && ((1L << (_la - 297)) & ((1L << (BOOL - 297)) | (1L << (BIT - 297)) | (1L << (VARBIT - 297)) | (1L << (INT1 - 297)) | (1L << (INT2 - 297)) | (1L << (INT4 - 297)) | (1L << (INT8 - 297)) | (1L << (TINYINT - 297)) | (1L << (SMALLINT - 297)) | (1L << (INT - 297)) | (1L << (INTEGER - 297)) | (1L << (BIGINT - 297)) | (1L << (FLOAT4 - 297)) | (1L << (FLOAT8 - 297)) | (1L << (REAL - 297)) | (1L << (FLOAT - 297)) | (1L << (DOUBLE - 297)) | (1L << (NUMERIC - 297)) | (1L << (DECIMAL - 297)) | (1L << (CHAR - 297)) | (1L << (VARCHAR - 297)) | (1L << (NCHAR - 297)) | (1L << (NVARCHAR - 297)) | (1L << (DATE - 297)) | (1L << (TIME - 297)) | (1L << (TIMETZ - 297)) | (1L << (TIMESTAMP - 297)) | (1L << (TIMESTAMPTZ - 297)) | (1L << (TEXT - 297)) | (1L << (UUID - 297)) | (1L << (VARBINARY - 297)) | (1L << (BLOB - 297)) | (1L << (BYTEA - 297)) | (1L << (INET4 - 297)) | (1L << (INET - 297)) | (1L << (INTERVAL - 297)) | (1L << (VOID - 297)))) != 0) || ((((_la - 363)) & ~0x3f) == 0 && ((1L << (_la - 363)) & ((1L << (DOUBLE_QUOTE - 363)) | (1L << (Identifier - 363)) | (1L << (QuotedIdentifier - 363)))) != 0)) {
				{
				setState(3587); identifier();
				setState(3592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(3588); match(COMMA);
					setState(3589); identifier();
					}
					}
					setState(3594);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(3597); match(RIGHT_PAREN);
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
			setState(3599); table_subquery();
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
			setState(3601); match(WHERE);
			setState(3602); search_condition();
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
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
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
			setState(3609);
			switch ( getInterpreter().adaptivePredict(_input,499,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3604); match(LEFT_PAREN);
				setState(3605); search_condition();
				setState(3606); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3608); value_expression();
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
			setState(3611); match(GROUP);
			setState(3612); match(BY);
			setState(3613); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3615); grouping_element();
			setState(3620);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,500,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3616); match(COMMA);
					setState(3617); grouping_element();
					}
					} 
				}
				setState(3622);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,500,_ctx);
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
			setState(3627);
			switch ( getInterpreter().adaptivePredict(_input,501,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3623); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3624); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3625); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3626); ordinary_grouping_set();
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
			setState(3634);
			switch ( getInterpreter().adaptivePredict(_input,502,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3629); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3630); match(LEFT_PAREN);
				setState(3631); row_value_predicand_list();
				setState(3632); match(RIGHT_PAREN);
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
			setState(3636); ordinary_grouping_set();
			setState(3641);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3637); match(COMMA);
				setState(3638); ordinary_grouping_set();
				}
				}
				setState(3643);
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
			setState(3644); match(ROLLUP);
			setState(3645); match(LEFT_PAREN);
			setState(3646); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3647); match(RIGHT_PAREN);
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
			setState(3649); match(CUBE);
			setState(3650); match(LEFT_PAREN);
			setState(3651); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3652); match(RIGHT_PAREN);
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
			setState(3654); match(LEFT_PAREN);
			setState(3655); match(RIGHT_PAREN);
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
			setState(3657); match(HAVING);
			setState(3658); boolean_value_expression();
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
			setState(3660); row_value_predicand();
			setState(3665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3661); match(COMMA);
				setState(3662); row_value_predicand();
				}
				}
				setState(3667);
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
			setState(3668); query_expression_body();
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
			setState(3672);
			switch ( getInterpreter().adaptivePredict(_input,505,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3670); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3671); joined_table();
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
			setState(3682);
			switch ( getInterpreter().adaptivePredict(_input,507,_ctx) ) {
			case 1:
				{
				setState(3674); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(3675); joined_table();
				setState(3676);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3678);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3677);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3680); query_term();
				}
				break;
			}
			setState(3691);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(3684);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3686);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3685);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3688); query_term();
				}
				}
				setState(3693);
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
			setState(3696);
			switch ( getInterpreter().adaptivePredict(_input,510,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3694); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3695); joined_table();
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
			setState(3706);
			switch ( getInterpreter().adaptivePredict(_input,512,_ctx) ) {
			case 1:
				{
				setState(3698); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(3699); joined_table();
				setState(3700); match(INTERSECT);
				setState(3702);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3701);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3704); query_primary();
				}
				break;
			}
			setState(3715);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(3708); match(INTERSECT);
				setState(3710);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3709);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3712); query_primary();
				}
				}
				setState(3717);
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
			setState(3720);
			switch ( getInterpreter().adaptivePredict(_input,515,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3718); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3719); joined_table();
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
			setState(3727);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3722); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3723); match(LEFT_PAREN);
				setState(3724); non_join_query_expression();
				setState(3725); match(RIGHT_PAREN);
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
			setState(3731);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(3729); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3730); explicit_table();
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
			setState(3733); match(TABLE);
			setState(3734); table_or_query_name();
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
			setState(3738);
			switch ( getInterpreter().adaptivePredict(_input,518,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3736); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3737); identifier();
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3740); identifier();
			setState(3747);
			switch ( getInterpreter().adaptivePredict(_input,520,_ctx) ) {
			case 1:
				{
				setState(3741); match(DOT);
				setState(3742); identifier();
				setState(3745);
				switch ( getInterpreter().adaptivePredict(_input,519,_ctx) ) {
				case 1:
					{
					setState(3743); match(DOT);
					setState(3744); identifier();
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3749); match(SELECT);
			setState(3751);
			switch ( getInterpreter().adaptivePredict(_input,521,_ctx) ) {
			case 1:
				{
				setState(3750); set_qualifier();
				}
				break;
			}
			setState(3753); select_list();
			setState(3755);
			switch ( getInterpreter().adaptivePredict(_input,522,_ctx) ) {
			case 1:
				{
				setState(3754); table_expression();
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3757); select_sublist();
			setState(3762);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,523,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3758); match(COMMA);
					setState(3759); select_sublist();
					}
					} 
				}
				setState(3764);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,523,_ctx);
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
			setState(3767);
			switch ( getInterpreter().adaptivePredict(_input,524,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3765); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3766); qualified_asterisk();
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
		public Over_clauseContext over_clause(int i) {
			return getRuleContext(Over_clauseContext.class,i);
		}
		public As_clauseContext as_clause(int i) {
			return getRuleContext(As_clauseContext.class,i);
		}
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public List<As_clauseContext> as_clause() {
			return getRuleContexts(As_clauseContext.class);
		}
		public List<Over_clauseContext> over_clause() {
			return getRuleContexts(Over_clauseContext.class);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3769); value_expression();
			setState(3774);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,526,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(3772);
					switch ( getInterpreter().adaptivePredict(_input,525,_ctx) ) {
					case 1:
						{
						setState(3770); as_clause();
						}
						break;
					case 2:
						{
						setState(3771); over_clause();
						}
						break;
					}
					} 
				}
				setState(3776);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,526,_ctx);
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
			setState(3779);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(3777); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(3778); match(DOT);
				}
			}

			setState(3781); match(MULTIPLY);
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
			setState(3783);
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
			setState(3788);
			switch ( getInterpreter().adaptivePredict(_input,528,_ctx) ) {
			case 1:
				{
				setState(3785); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(3786); match(DOT);
				}
				break;
			}
			setState(3790); ((Column_referenceContext)_localctx).name = identifier();
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
			setState(3793);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(3792); match(AS);
				}
			}

			setState(3795); identifier();
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

	public static class Over_clauseContext extends ParserRuleContext {
		public TerminalNode OVER() { return getToken(SQLParser.OVER, 0); }
		public Order_specificationContext order_specification(int i) {
			return getRuleContext(Order_specificationContext.class,i);
		}
		public List<Order_specificationContext> order_specification() {
			return getRuleContexts(Order_specificationContext.class);
		}
		public Orderby_clauseContext orderby_clause(int i) {
			return getRuleContext(Orderby_clauseContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Partition_by_columnsContext> partition_by_columns() {
			return getRuleContexts(Partition_by_columnsContext.class);
		}
		public List<Orderby_clauseContext> orderby_clause() {
			return getRuleContexts(Orderby_clauseContext.class);
		}
		public Partition_by_columnsContext partition_by_columns(int i) {
			return getRuleContext(Partition_by_columnsContext.class,i);
		}
		public Over_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_over_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOver_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOver_clause(this);
		}
	}

	public final Over_clauseContext over_clause() throws RecognitionException {
		Over_clauseContext _localctx = new Over_clauseContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_over_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3797); match(OVER);
			setState(3798); match(LEFT_PAREN);
			setState(3804);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ASC || _la==DESC || _la==ORDER || _la==PARTITION) {
				{
				setState(3802);
				switch (_input.LA(1)) {
				case PARTITION:
					{
					setState(3799); partition_by_columns();
					}
					break;
				case ORDER:
					{
					setState(3800); orderby_clause();
					}
					break;
				case ASC:
				case DESC:
					{
					setState(3801); order_specification();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(3806);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3807); match(RIGHT_PAREN);
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
		enterRule(_localctx, 418, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3809); column_reference();
			setState(3814);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3810); match(COMMA);
				setState(3811); column_reference();
				}
				}
				setState(3816);
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
		enterRule(_localctx, 420, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3817); subquery();
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
		enterRule(_localctx, 422, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3819); subquery();
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
		enterRule(_localctx, 424, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3821); subquery();
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
		enterRule(_localctx, 426, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3823); match(LEFT_PAREN);
			setState(3824); query_expression();
			setState(3825); match(RIGHT_PAREN);
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
		enterRule(_localctx, 428, RULE_predicate);
		try {
			setState(3833);
			switch ( getInterpreter().adaptivePredict(_input,533,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3827); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3828); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3829); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3830); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3831); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3832); exists_predicate();
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
		enterRule(_localctx, 430, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3835); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(3836); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(3837); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
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
		enterRule(_localctx, 432, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3839);
			_la = _input.LA(1);
			if ( !(((((_la - 342)) & ~0x3f) == 0 && ((1L << (_la - 342)) & ((1L << (EQUAL - 342)) | (1L << (NOT_EQUAL - 342)) | (1L << (LTH - 342)) | (1L << (LEQ - 342)) | (1L << (GTH - 342)) | (1L << (GEQ - 342)))) != 0)) ) {
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
		enterRule(_localctx, 434, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3841); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3842); between_predicate_part_2();
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
		enterRule(_localctx, 436, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3845);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3844); match(NOT);
				}
			}

			setState(3847); match(BETWEEN);
			setState(3849);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(3848);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(3851); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(3852); match(AND);
			setState(3853); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
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
		enterRule(_localctx, 438, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3855); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(3857);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3856); match(NOT);
				}
			}

			setState(3859); match(IN);
			setState(3860); in_predicate_value();
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
		enterRule(_localctx, 440, RULE_in_predicate_value);
		try {
			setState(3867);
			switch ( getInterpreter().adaptivePredict(_input,537,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3862); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3863); match(LEFT_PAREN);
				setState(3864); in_value_list();
				setState(3865); match(RIGHT_PAREN);
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
		enterRule(_localctx, 442, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3869); row_value_expression();
			setState(3874);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3870); match(COMMA);
				setState(3871); row_value_expression();
				}
				}
				setState(3876);
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
		enterRule(_localctx, 444, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3877); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(3878); pattern_matcher();
			setState(3879); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
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
		enterRule(_localctx, 446, RULE_pattern_matcher);
		int _la;
		try {
			setState(3886);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3882);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3881); match(NOT);
					}
				}

				setState(3884); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(3885); regex_matcher();
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
		enterRule(_localctx, 448, RULE_negativable_matcher);
		int _la;
		try {
			setState(3891);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case REGEXP:
			case RLIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3888);
				_la = _input.LA(1);
				if ( !(_la==ILIKE || _la==LIKE || _la==REGEXP || _la==RLIKE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(3889); match(SIMILAR);
				setState(3890); match(TO);
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
		enterRule(_localctx, 450, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3893);
			_la = _input.LA(1);
			if ( !(((((_la - 336)) & ~0x3f) == 0 && ((1L << (_la - 336)) & ((1L << (Similar_To - 336)) | (1L << (Not_Similar_To - 336)) | (1L << (Similar_To_Case_Insensitive - 336)) | (1L << (Not_Similar_To_Case_Insensitive - 336)))) != 0)) ) {
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
		enterRule(_localctx, 452, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3895); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3896); match(IS);
			setState(3898);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3897); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(3900); match(NULL);
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
		enterRule(_localctx, 454, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3902); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(3903); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(3904); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(3905); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
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
		enterRule(_localctx, 456, RULE_quantifier);
		try {
			setState(3909);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3907); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3908); some();
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
		enterRule(_localctx, 458, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3911); match(ALL);
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
		enterRule(_localctx, 460, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3913);
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
		enterRule(_localctx, 462, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3916);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3915); match(NOT);
				}
			}

			setState(3918); match(EXISTS);
			setState(3919); ((Exists_predicateContext)_localctx).s = table_subquery();
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
		enterRule(_localctx, 464, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3921); match(UNIQUE);
			setState(3922); ((Unique_predicateContext)_localctx).s = table_subquery();
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
		enterRule(_localctx, 466, RULE_primary_datetime_field);
		try {
			setState(3926);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3924); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(3925); match(SECOND);
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
		enterRule(_localctx, 468, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3928);
			_la = _input.LA(1);
			if ( !(((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (DAY - 169)) | (1L << (HOUR - 169)) | (1L << (MINUTE - 169)) | (1L << (MONTH - 169)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 470, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3930);
			_la = _input.LA(1);
			if ( !(((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (CENTURY - 151)) | (1L << (DECADE - 151)) | (1L << (DOW - 151)) | (1L << (DOY - 151)) | (1L << (EPOCH - 151)) | (1L << (ISODOW - 151)) | (1L << (ISOYEAR - 151)))) != 0) || ((((_la - 215)) & ~0x3f) == 0 && ((1L << (_la - 215)) & ((1L << (MICROSECONDS - 215)) | (1L << (MILLENNIUM - 215)) | (1L << (MILLISECONDS - 215)) | (1L << (QUARTER - 215)))) != 0) || _la==WEEK) ) {
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
		enterRule(_localctx, 472, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3932); match(ORDER);
			setState(3933); match(BY);
			setState(3934); sort_specifier_list();
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

	public static class Sort_specifier_parenContext extends ParserRuleContext {
		public Sort_specifier_parenContext sort_specifier_paren(int i) {
			return getRuleContext(Sort_specifier_parenContext.class,i);
		}
		public List<Sort_specifier_parenContext> sort_specifier_paren() {
			return getRuleContexts(Sort_specifier_parenContext.class);
		}
		public Sort_specifier_listContext sort_specifier_list() {
			return getRuleContext(Sort_specifier_listContext.class,0);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public Sort_specifier_parenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort_specifier_paren; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSort_specifier_paren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSort_specifier_paren(this);
		}
	}

	public final Sort_specifier_parenContext sort_specifier_paren() throws RecognitionException {
		Sort_specifier_parenContext _localctx = new Sort_specifier_parenContext(_ctx, getState());
		enterRule(_localctx, 474, RULE_sort_specifier_paren);
		int _la;
		try {
			setState(3945);
			switch ( getInterpreter().adaptivePredict(_input,548,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3936); sort_specifier_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3937); match(LEFT_PAREN);
				setState(3940); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(3940);
					switch ( getInterpreter().adaptivePredict(_input,546,_ctx) ) {
					case 1:
						{
						setState(3938);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==LEFT_PAREN || _la==RIGHT_PAREN) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						break;
					case 2:
						{
						setState(3939); sort_specifier_paren();
						}
						break;
					}
					}
					setState(3942); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << ALTER) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << COPY) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DELIMITER) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << ELSE) | (1L << END) | (1L << ENCODING) | (1L << ESCAPE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FORCE_QUOTE) | (1L << FORCE_NOT_NULL) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << HANDLER) | (1L << HEADER) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IMMUTABLE - 64)) | (1L << (IN - 64)) | (1L << (INCLUDING - 64)) | (1L << (INHERITS - 64)) | (1L << (INITIALLY - 64)) | (1L << (INLINE - 64)) | (1L << (INNER - 64)) | (1L << (INTERSECT - 64)) | (1L << (INTO - 64)) | (1L << (INOUT - 64)) | (1L << (INSTEAD - 64)) | (1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (OWNER - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRUSTED - 64)) | (1L << (TRIGGER - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (TRUE - 128)) | (1L << (TRUNCATE - 128)) | (1L << (UNION - 128)) | (1L << (UNIQUE - 128)) | (1L << (UPDATE - 128)) | (1L << (USAGE - 128)) | (1L << (USING - 128)) | (1L << (VALIDATOR - 128)) | (1L << (VARIADIC - 128)) | (1L << (VIEW - 128)) | (1L << (WHEN - 128)) | (1L << (WHERE - 128)) | (1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (ALWAYS - 128)) | (1L << (ARRAY - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (CLUSTER - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONCURRENTLY - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DISABLE - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (ENABLE - 128)) | (1L << (EPOCH - 128)) | (1L << (EVENT - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTENDED - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (HASH - 192)) | (1L << (HOUR - 192)) | (1L << (INHERIT - 192)) | (1L << (INDEX - 192)) | (1L << (INDEXES - 192)) | (1L << (INCREMENT - 192)) | (1L << (INPUT - 192)) | (1L << (INSERT - 192)) | (1L << (INTERSECTION - 192)) | (1L << (ISCACHABLE - 192)) | (1L << (ISODOW - 192)) | (1L << (ISOYEAR - 192)) | (1L << (ISSTRICT - 192)) | (1L << (LANGUAGE - 192)) | (1L << (LARGE - 192)) | (1L << (LAST - 192)) | (1L << (LESS - 192)) | (1L << (LIST - 192)) | (1L << (LOCATION - 192)) | (1L << (MAIN - 192)) | (1L << (MATCH - 192)) | (1L << (MAX - 192)) | (1L << (MAXVALUE - 192)) | (1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (N_DISTINCT - 192)) | (1L << (N_DISTINCT_INHERITED - 192)) | (1L << (OBJECT - 192)) | (1L << (ON - 192)) | (1L << (ONLY - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVER - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PLAIN - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGCONFIG - 192)) | (1L << (REGEXP - 192)) | (1L << (RENAME - 192)) | (1L << (REPLICA - 192)) | (1L << (RESET - 192)) | (1L << (RESTART - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (SERVER - 256)) | (1L << (SET - 256)) | (1L << (SIMILAR - 256)) | (1L << (SIMPLE - 256)) | (1L << (STABLE - 256)) | (1L << (START - 256)) | (1L << (STATISTICS - 256)) | (1L << (STDIN - 256)) | (1L << (STORAGE - 256)) | (1L << (STDDEV_POP - 256)) | (1L << (STDDEV_SAMP - 256)) | (1L << (SUBPARTITION - 256)) | (1L << (SUM - 256)) | (1L << (TABLESPACE - 256)) | (1L << (TABLES - 256)) | (1L << (TEMPLATE - 256)) | (1L << (THAN - 256)) | (1L << (TIMEZONE - 256)) | (1L << (TIMEZONE_HOUR - 256)) | (1L << (TIMEZONE_MINUTE - 256)) | (1L << (TRIM - 256)) | (1L << (TO - 256)) | (1L << (TYPE - 256)) | (1L << (TYPES - 256)) | (1L << (UNKNOWN - 256)) | (1L << (UNLOGGED - 256)) | (1L << (USER - 256)) | (1L << (VALID - 256)) | (1L << (VALIDATE - 256)) | (1L << (VALUES - 256)) | (1L << (VAR_SAMP - 256)) | (1L << (VAR_POP - 256)) | (1L << (VARYING - 256)) | (1L << (VERSION - 256)) | (1L << (VOLATILE - 256)) | (1L << (WEEK - 256)) | (1L << (WINDOW - 256)) | (1L << (WRAPPER - 256)) | (1L << (YEAR - 256)) | (1L << (ZONE - 256)) | (1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (NVARCHAR - 320)) | (1L << (DATE - 320)) | (1L << (TIME - 320)) | (1L << (TIMETZ - 320)) | (1L << (TIMESTAMP - 320)) | (1L << (TIMESTAMPTZ - 320)) | (1L << (TEXT - 320)) | (1L << (UUID - 320)) | (1L << (BINARY - 320)) | (1L << (VARBINARY - 320)) | (1L << (BLOB - 320)) | (1L << (BYTEA - 320)) | (1L << (INET4 - 320)) | (1L << (INET - 320)) | (1L << (INTERVAL - 320)) | (1L << (VOID - 320)) | (1L << (Similar_To - 320)) | (1L << (Not_Similar_To - 320)) | (1L << (Similar_To_Case_Insensitive - 320)) | (1L << (Not_Similar_To_Case_Insensitive - 320)) | (1L << (CAST_EXPRESSION - 320)) | (1L << (ASSIGN - 320)) | (1L << (EQUAL - 320)) | (1L << (COLON - 320)) | (1L << (SEMI_COLON - 320)) | (1L << (COMMA - 320)) | (1L << (CONCATENATION_OPERATOR - 320)) | (1L << (NOT_EQUAL - 320)) | (1L << (LTH - 320)) | (1L << (LEQ - 320)) | (1L << (GTH - 320)) | (1L << (GEQ - 320)) | (1L << (LEFT_PAREN - 320)) | (1L << (PLUS - 320)) | (1L << (MINUS - 320)) | (1L << (MULTIPLY - 320)) | (1L << (DIVIDE - 320)) | (1L << (MODULAR - 320)) | (1L << (DOT - 320)) | (1L << (UNDERLINE - 320)) | (1L << (VERTICAL_BAR - 320)) | (1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (LEFT_BRACKET - 320)) | (1L << (RIGHT_BRACKET - 320)) | (1L << (BIT_AND - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (QuotedIdentifier - 320)) | (1L << (UnterminatedQuotedIdentifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (BeginDollarStringConstant - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)) | (1L << (Text_between_Dollar - 320)) | (1L << (EndDollarStringConstant - 320)))) != 0) );
				setState(3944); match(RIGHT_PAREN);
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
		enterRule(_localctx, 476, RULE_sort_specifier_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3947); sort_specifier();
			setState(3952);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,549,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3948); match(COMMA);
					setState(3949); sort_specifier();
					}
					} 
				}
				setState(3954);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,549,_ctx);
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
		enterRule(_localctx, 478, RULE_sort_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3955); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(3957);
			switch ( getInterpreter().adaptivePredict(_input,550,_ctx) ) {
			case 1:
				{
				setState(3956); ((Sort_specifierContext)_localctx).order = order_specification();
				}
				break;
			}
			setState(3960);
			switch ( getInterpreter().adaptivePredict(_input,551,_ctx) ) {
			case 1:
				{
				setState(3959); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 480, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3962);
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
		enterRule(_localctx, 482, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3964); match(LIMIT);
			setState(3965); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
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
		enterRule(_localctx, 484, RULE_null_ordering);
		try {
			setState(3971);
			switch ( getInterpreter().adaptivePredict(_input,552,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3967); match(NULL);
				setState(3968); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3969); match(NULL);
				setState(3970); match(LAST);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0180\u0f88\4\2\t"+
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
		"\t\u00f1\4\u00f2\t\u00f2\4\u00f3\t\u00f3\4\u00f4\t\u00f4\3\2\3\2\3\2\7"+
		"\2\u01ec\n\2\f\2\16\2\u01ef\13\2\3\2\3\2\3\3\3\3\5\3\u01f5\n\3\3\4\3\4"+
		"\5\4\u01f9\n\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0201\n\5\f\5\16\5\u0204\13"+
		"\5\3\5\3\5\5\5\u0208\n\5\3\5\5\5\u020b\n\5\3\5\3\5\3\5\5\5\u0210\n\5\3"+
		"\5\5\5\u0213\n\5\3\5\3\5\3\5\3\5\7\5\u0219\n\5\f\5\16\5\u021c\13\5\3\5"+
		"\3\5\5\5\u0220\n\5\3\6\3\6\3\6\3\6\5\6\u0226\n\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6\u022e\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0239\n\6\f\6"+
		"\16\6\u023c\13\6\3\6\3\6\3\6\5\6\u0241\n\6\3\6\3\6\3\6\3\6\3\6\7\6\u0248"+
		"\n\6\f\6\16\6\u024b\13\6\3\6\3\6\3\6\3\6\5\6\u0251\n\6\3\7\3\7\3\7\5\7"+
		"\u0256\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0263\n\b\3"+
		"\b\3\b\3\b\3\b\5\b\u0269\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0273"+
		"\n\t\3\n\3\n\3\n\6\n\u0278\n\n\r\n\16\n\u0279\3\n\5\n\u027d\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0288\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\5\f\u0291\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\5\r\u029b\n\r"+
		"\3\r\6\r\u029e\n\r\r\r\16\r\u029f\3\r\3\r\3\r\7\r\u02a5\n\r\f\r\16\r\u02a8"+
		"\13\r\3\r\3\r\5\r\u02ac\n\r\3\r\3\r\3\r\3\r\5\r\u02b2\n\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u02bb\n\r\3\r\3\r\5\r\u02bf\n\r\3\16\3\16\5\16\u02c3"+
		"\n\16\3\16\3\16\3\16\5\16\u02c8\n\16\3\16\3\16\5\16\u02cc\n\16\3\16\3"+
		"\16\5\16\u02d0\n\16\3\16\3\16\5\16\u02d4\n\16\3\16\3\16\3\16\5\16\u02d9"+
		"\n\16\3\16\3\16\3\16\3\16\5\16\u02df\n\16\3\16\3\16\5\16\u02e3\n\16\3"+
		"\16\3\16\5\16\u02e7\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u02fa\n\16\f\16\16\16\u02fd"+
		"\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0306\n\16\f\16\16\16\u0309"+
		"\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0313\n\16\5\16\u0315"+
		"\n\16\3\16\3\16\3\16\3\16\5\16\u031b\n\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u0326\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0330\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\7\16\u034d\n\16\f\16\16\16\u0350\13\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u0363\n\16\3\17\3\17\3\17\3\17\3\20\3\20\5\20\u036b\n\20\3\20\3\20\3"+
		"\20\5\20\u0370\n\20\3\20\3\20\3\20\3\20\5\20\u0376\n\20\3\20\5\20\u0379"+
		"\n\20\3\20\3\20\5\20\u037d\n\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u038f\n\22\3\22\3\22\3\22"+
		"\5\22\u0394\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u03a3\n\22\3\22\3\22\5\22\u03a7\n\22\3\22\3\22\3\22\5"+
		"\22\u03ac\n\22\5\22\u03ae\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u03b7\n\23\f\23\16\23\u03ba\13\23\5\23\u03bc\n\23\3\23\3\23\3\23\3\23"+
		"\3\23\7\23\u03c3\n\23\f\23\16\23\u03c6\13\23\5\23\u03c8\n\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\7\24\u03d0\n\24\f\24\16\24\u03d3\13\24\3\24\3\24"+
		"\5\24\u03d7\n\24\5\24\u03d9\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7"+
		"\24\u03e2\n\24\f\24\16\24\u03e5\13\24\3\24\3\24\5\24\u03e9\n\24\5\24\u03eb"+
		"\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u03f4\n\24\5\24\u03f6\n"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u03ff\n\24\5\24\u0401\n\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u040a\n\24\3\24\3\24\3\24\7\24"+
		"\u040f\n\24\f\24\16\24\u0412\13\24\3\24\3\24\5\24\u0416\n\24\5\24\u0418"+
		"\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0421\n\24\3\24\3\24\3\24"+
		"\7\24\u0426\n\24\f\24\16\24\u0429\13\24\3\24\3\24\5\24\u042d\n\24\5\24"+
		"\u042f\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0438\n\24\3\24\3"+
		"\24\3\24\5\24\u043d\n\24\5\24\u043f\n\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0448\n\24\3\24\3\24\3\24\5\24\u044d\n\24\5\24\u044f\n\24\3"+
		"\24\3\24\3\24\5\24\u0454\n\24\3\25\3\25\3\25\5\25\u0459\n\25\3\25\3\25"+
		"\3\25\3\25\5\25\u045f\n\25\3\25\5\25\u0462\n\25\7\25\u0464\n\25\f\25\16"+
		"\25\u0467\13\25\3\25\3\25\3\25\3\25\5\25\u046d\n\25\3\25\5\25\u0470\n"+
		"\25\3\26\3\26\3\26\5\26\u0475\n\26\3\26\3\26\3\26\5\26\u047a\n\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u0482\n\26\3\26\3\26\3\26\3\26\5\26\u0488"+
		"\n\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0490\n\26\3\26\3\26\3\26\3\26"+
		"\5\26\u0496\n\26\7\26\u0498\n\26\f\26\16\26\u049b\13\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\7\26\u04a4\n\26\f\26\16\26\u04a7\13\26\3\26\3\26"+
		"\5\26\u04ab\n\26\3\27\5\27\u04ae\n\27\3\27\3\27\5\27\u04b2\n\27\3\27\5"+
		"\27\u04b5\n\27\3\27\3\27\3\27\3\27\5\27\u04bb\n\27\3\27\3\27\5\27\u04bf"+
		"\n\27\3\27\3\27\5\27\u04c3\n\27\3\27\3\27\5\27\u04c7\n\27\3\30\3\30\3"+
		"\30\3\30\5\30\u04cd\n\30\3\30\3\30\5\30\u04d1\n\30\3\30\3\30\5\30\u04d5"+
		"\n\30\3\30\3\30\5\30\u04d9\n\30\3\30\3\30\5\30\u04dd\n\30\3\31\3\31\5"+
		"\31\u04e1\n\31\3\31\5\31\u04e4\n\31\3\31\5\31\u04e7\n\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u04ef\n\31\3\31\3\31\5\31\u04f3\n\31\5\31\u04f5\n"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0503"+
		"\n\32\f\32\16\32\u0506\13\32\3\32\3\32\5\32\u050a\n\32\6\32\u050c\n\32"+
		"\r\32\16\32\u050d\5\32\u0510\n\32\3\32\3\32\3\32\3\32\3\33\3\33\5\33\u0518"+
		"\n\33\3\33\3\33\3\33\3\33\3\33\7\33\u051f\n\33\f\33\16\33\u0522\13\33"+
		"\3\33\3\33\3\33\3\33\3\33\5\33\u0529\n\33\3\33\3\33\3\33\3\33\5\33\u052f"+
		"\n\33\7\33\u0531\n\33\f\33\16\33\u0534\13\33\5\33\u0536\n\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u053e\n\34\3\35\5\35\u0541\n\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\5\35\u0549\n\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35"+
		"\u0551\n\35\f\35\16\35\u0554\13\35\5\35\u0556\n\35\5\35\u0558\n\35\3\35"+
		"\5\35\u055b\n\35\6\35\u055d\n\35\r\35\16\35\u055e\3\35\3\35\3\35\3\35"+
		"\5\35\u0565\n\35\3\35\3\35\3\35\5\35\u056a\n\35\3\35\3\35\3\35\3\35\5"+
		"\35\u0570\n\35\3\35\3\35\5\35\u0574\n\35\3\35\5\35\u0577\n\35\3\35\3\35"+
		"\5\35\u057b\n\35\3\35\3\35\3\35\3\35\3\35\5\35\u0582\n\35\3\35\3\35\7"+
		"\35\u0586\n\35\f\35\16\35\u0589\13\35\3\35\3\35\3\36\3\36\3\36\3\36\5"+
		"\36\u0591\n\36\3\36\3\36\3\36\7\36\u0596\n\36\f\36\16\36\u0599\13\36\3"+
		"\36\3\36\5\36\u059d\n\36\5\36\u059f\n\36\3\36\3\36\5\36\u05a3\n\36\3\36"+
		"\6\36\u05a6\n\36\r\36\16\36\u05a7\3\36\3\36\3\36\3\36\3\36\6\36\u05af"+
		"\n\36\r\36\16\36\u05b0\5\36\u05b3\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\7\36\u05bc\n\36\f\36\16\36\u05bf\13\36\3\36\3\36\6\36\u05c3\n\36\r"+
		"\36\16\36\u05c4\3\36\3\36\5\36\u05c9\n\36\3\36\3\36\3\36\3\36\7\36\u05cf"+
		"\n\36\f\36\16\36\u05d2\13\36\3\36\3\36\5\36\u05d6\n\36\3\36\3\36\5\36"+
		"\u05da\n\36\3\36\3\36\3\36\7\36\u05df\n\36\f\36\16\36\u05e2\13\36\3\36"+
		"\3\36\3\36\6\36\u05e7\n\36\r\36\16\36\u05e8\3\36\3\36\5\36\u05ed\n\36"+
		"\5\36\u05ef\n\36\3\36\3\36\3\36\3\36\3\36\7\36\u05f6\n\36\f\36\16\36\u05f9"+
		"\13\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0602\n\36\f\36\16\36\u0605"+
		"\13\36\5\36\u0607\n\36\3\36\3\36\3\36\6\36\u060c\n\36\r\36\16\36\u060d"+
		"\3\36\3\36\5\36\u0612\n\36\5\36\u0614\n\36\3\36\3\36\3\36\3\36\3\36\7"+
		"\36\u061b\n\36\f\36\16\36\u061e\13\36\3\36\3\36\3\36\3\36\3\36\5\36\u0625"+
		"\n\36\5\36\u0627\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0630\n"+
		"\36\f\36\16\36\u0633\13\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36"+
		"\u063d\n\36\f\36\16\36\u0640\13\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\7\36\u0649\n\36\f\36\16\36\u064c\13\36\3\36\3\36\5\36\u0650\n\36\3\36"+
		"\3\36\3\36\5\36\u0655\n\36\5\36\u0657\n\36\3\36\3\36\3\36\5\36\u065c\n"+
		"\36\3\36\3\36\3\36\3\36\3\36\5\36\u0663\n\36\6\36\u0665\n\36\r\36\16\36"+
		"\u0666\3\36\3\36\5\36\u066b\n\36\5\36\u066d\n\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\7\36\u0675\n\36\f\36\16\36\u0678\13\36\3\36\3\36\3\36\3\36\5"+
		"\36\u067e\n\36\6\36\u0680\n\36\r\36\16\36\u0681\3\36\3\36\5\36\u0686\n"+
		"\36\5\36\u0688\n\36\3\36\3\36\3\36\3\36\3\36\7\36\u068f\n\36\f\36\16\36"+
		"\u0692\13\36\3\36\3\36\3\36\3\36\3\36\5\36\u0699\n\36\5\36\u069b\n\36"+
		"\3\36\3\36\3\36\3\36\3\36\7\36\u06a2\n\36\f\36\16\36\u06a5\13\36\3\36"+
		"\3\36\5\36\u06a9\n\36\3\36\3\36\3\36\5\36\u06ae\n\36\3\36\3\36\3\36\7"+
		"\36\u06b3\n\36\f\36\16\36\u06b6\13\36\3\36\3\36\3\36\3\36\7\36\u06bc\n"+
		"\36\f\36\16\36\u06bf\13\36\3\36\5\36\u06c2\n\36\5\36\u06c4\n\36\3\37\3"+
		"\37\5\37\u06c8\n\37\3\37\3\37\5\37\u06cc\n\37\3\37\3\37\5\37\u06d0\n\37"+
		"\3\37\3\37\5\37\u06d4\n\37\7\37\u06d6\n\37\f\37\16\37\u06d9\13\37\3\37"+
		"\5\37\u06dc\n\37\3 \3 \3 \3 \7 \u06e2\n \f \16 \u06e5\13 \3 \3 \5 \u06e9"+
		"\n \5 \u06eb\n \3 \3 \5 \u06ef\n \3 \3 \5 \u06f3\n \6 \u06f5\n \r \16"+
		" \u06f6\3 \3 \3 \3 \3 \3 \5 \u06ff\n \6 \u0701\n \r \16 \u0702\5 \u0705"+
		"\n \3 \3 \3 \3 \3 \3 \7 \u070d\n \f \16 \u0710\13 \6 \u0712\n \r \16 "+
		"\u0713\3 \3 \5 \u0718\n \3 \3 \3 \7 \u071d\n \f \16 \u0720\13 \5 \u0722"+
		"\n \3 \3 \5 \u0726\n \3 \3 \5 \u072a\n \6 \u072c\n \r \16 \u072d\3 \3"+
		" \3 \3 \3 \7 \u0735\n \f \16 \u0738\13 \3 \3 \5 \u073c\n \5 \u073e\n "+
		"\3 \3 \3 \3 \3 \7 \u0745\n \f \16 \u0748\13 \6 \u074a\n \r \16 \u074b"+
		"\3 \3 \3 \3 \3 \3 \3 \7 \u0755\n \f \16 \u0758\13 \5 \u075a\n \3 \3 \3"+
		" \3 \3 \7 \u0761\n \f \16 \u0764\13 \3 \3 \5 \u0768\n \5 \u076a\n \3 "+
		"\3 \3 \3 \3 \7 \u0771\n \f \16 \u0774\13 \3 \3 \3 \3 \3 \5 \u077b\n \5"+
		" \u077d\n \3 \3 \3 \3 \3 \3 \3 \7 \u0786\n \f \16 \u0789\13 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \7 \u0793\n \f \16 \u0796\13 \3 \3 \3 \3 \3 \3 \3 \7 \u079f"+
		"\n \f \16 \u07a2\13 \3 \3 \5 \u07a6\n \3 \3 \3 \5 \u07ab\n \5 \u07ad\n"+
		" \3 \3 \3 \5 \u07b2\n \3 \3 \3 \3 \5 \u07b8\n \6 \u07ba\n \r \16 \u07bb"+
		"\3 \3 \5 \u07c0\n \5 \u07c2\n \3 \3 \3 \3 \3 \3 \7 \u07ca\n \f \16 \u07cd"+
		"\13 \3 \3 \3 \3 \5 \u07d3\n \6 \u07d5\n \r \16 \u07d6\3 \3 \5 \u07db\n"+
		" \5 \u07dd\n \3 \3 \3 \3 \3 \7 \u07e4\n \f \16 \u07e7\13 \3 \3 \3 \3 "+
		"\3 \5 \u07ee\n \5 \u07f0\n \3 \3 \3 \3 \3 \7 \u07f7\n \f \16 \u07fa\13"+
		" \3 \3 \3 \3 \3 \7 \u0801\n \f \16 \u0804\13 \3 \3 \3 \3 \7 \u080a\n "+
		"\f \16 \u080d\13 \3 \3 \3 \5 \u0812\n \5 \u0814\n \3!\3!\5!\u0818\n!\3"+
		"!\3!\5!\u081c\n!\3!\3!\5!\u0820\n!\3!\3!\5!\u0824\n!\7!\u0826\n!\f!\16"+
		"!\u0829\13!\3!\3!\3!\5!\u082e\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0838"+
		"\n\"\f\"\16\"\u083b\13\"\5\"\u083d\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0860\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\5\"\u0869\n\"\3\"\5\"\u086c\n\"\3\"\5\"\u086f\n\"\3\"\3\"\3\"\3#\3"+
		"#\5#\u0876\n#\3#\3#\3#\3#\3#\5#\u087d\n#\3#\3#\3#\3#\3#\3#\7#\u0885\n"+
		"#\f#\16#\u0888\13#\3#\3#\5#\u088c\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\5#\u089b\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u08ab"+
		"\n#\3#\3#\7#\u08af\n#\f#\16#\u08b2\13#\3#\3#\3#\3#\3#\3#\7#\u08ba\n#\f"+
		"#\16#\u08bd\13#\6#\u08bf\n#\r#\16#\u08c0\3#\3#\3#\3#\3#\7#\u08c8\n#\f"+
		"#\16#\u08cb\13#\3#\3#\5#\u08cf\n#\3$\3$\3$\3%\3%\3%\3%\5%\u08d8\n%\3%"+
		"\3%\3%\5%\u08dd\n%\7%\u08df\n%\f%\16%\u08e2\13%\5%\u08e4\n%\3%\3%\3&\3"+
		"&\3&\3\'\3\'\6\'\u08ed\n\'\r\'\16\'\u08ee\3\'\3\'\3(\5(\u08f4\n(\3(\5"+
		"(\u08f7\n(\3(\3(\3(\5(\u08fc\n(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3,\3,\7"+
		",\u090a\n,\f,\16,\u090d\13,\5,\u090f\n,\3,\3,\3-\3-\3-\3-\3-\3-\3-\7-"+
		"\u091a\n-\f-\16-\u091d\13-\3.\5.\u0920\n.\3.\3.\3.\7.\u0925\n.\f.\16."+
		"\u0928\13.\3/\3/\5/\u092c\n/\3/\3/\3/\3/\3/\5/\u0933\n/\3/\3/\3/\3/\5"+
		"/\u0939\n/\3/\3/\5/\u093d\n/\3/\3/\3/\3/\5/\u0943\n/\3/\3/\3/\3/\3/\5"+
		"/\u094a\n/\5/\u094c\n/\3\60\3\60\3\60\3\60\5\60\u0952\n\60\3\60\7\60\u0955"+
		"\n\60\f\60\16\60\u0958\13\60\3\60\3\60\3\60\7\60\u095d\n\60\f\60\16\60"+
		"\u0960\13\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u0968\n\60\3\60\3\60\5"+
		"\60\u096c\n\60\5\60\u096e\n\60\3\61\3\61\5\61\u0972\n\61\3\61\5\61\u0975"+
		"\n\61\3\61\3\61\3\61\3\61\5\61\u097b\n\61\7\61\u097d\n\61\f\61\16\61\u0980"+
		"\13\61\3\61\3\61\3\61\3\61\3\61\5\61\u0987\n\61\6\61\u0989\n\61\r\61\16"+
		"\61\u098a\3\61\3\61\5\61\u098f\n\61\3\61\3\61\3\61\3\61\5\61\u0995\n\61"+
		"\3\61\7\61\u0998\n\61\f\61\16\61\u099b\13\61\3\62\5\62\u099e\n\62\3\62"+
		"\3\62\5\62\u09a2\n\62\3\62\3\62\3\62\3\62\5\62\u09a8\n\62\3\62\3\62\3"+
		"\62\3\62\3\62\7\62\u09af\n\62\f\62\16\62\u09b2\13\62\5\62\u09b4\n\62\3"+
		"\62\3\62\3\62\3\62\3\62\5\62\u09bb\n\62\6\62\u09bd\n\62\r\62\16\62\u09be"+
		"\3\62\3\62\5\62\u09c3\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\7\62\u09d0\n\62\f\62\16\62\u09d3\13\62\3\62\5\62\u09d6\n\62"+
		"\3\62\3\62\3\62\3\62\3\62\7\62\u09dd\n\62\f\62\16\62\u09e0\13\62\3\62"+
		"\7\62\u09e3\n\62\f\62\16\62\u09e6\13\62\3\62\3\62\5\62\u09ea\n\62\3\62"+
		"\3\62\3\62\3\62\5\62\u09f0\n\62\3\63\3\63\3\63\3\63\3\63\7\63\u09f7\n"+
		"\63\f\63\16\63\u09fa\13\63\5\63\u09fc\n\63\3\64\3\64\3\64\3\64\5\64\u0a02"+
		"\n\64\3\64\7\64\u0a05\n\64\f\64\16\64\u0a08\13\64\3\65\3\65\3\65\3\66"+
		"\3\66\5\66\u0a0f\n\66\3\66\3\66\3\66\3\66\3\66\3\66\7\66\u0a17\n\66\f"+
		"\66\16\66\u0a1a\13\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\7\66"+
		"\u0a25\n\66\f\66\16\66\u0a28\13\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66"+
		"\u0a30\n\66\3\66\3\66\3\66\3\66\3\66\3\66\7\66\u0a38\n\66\f\66\16\66\u0a3b"+
		"\13\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u0a44\n\66\3\66\3\66\3"+
		"\66\3\66\3\66\3\66\7\66\u0a4c\n\66\f\66\16\66\u0a4f\13\66\3\66\3\66\3"+
		"\66\3\66\3\66\3\66\3\66\7\66\u0a58\n\66\f\66\16\66\u0a5b\13\66\3\66\3"+
		"\66\5\66\u0a5f\n\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u0a67\n\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\7\66\u0a6f\n\66\f\66\16\66\u0a72\13\66\5\66"+
		"\u0a74\n\66\3\66\3\66\3\66\5\66\u0a79\n\66\3\66\3\66\3\66\3\66\5\66\u0a7f"+
		"\n\66\3\67\3\67\5\67\u0a83\n\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67"+
		"\u0a8c\n\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\5\67\u0a9c\n\67\3\67\3\67\3\67\5\67\u0aa1\n\67\3\67\3\67\3"+
		"\67\5\67\u0aa6\n\67\5\67\u0aa8\n\67\3\67\3\67\3\67\5\67\u0aad\n\67\3\67"+
		"\3\67\3\67\3\67\5\67\u0ab3\n\67\38\38\68\u0ab7\n8\r8\168\u0ab8\38\38\6"+
		"8\u0abd\n8\r8\168\u0abe\39\39\39\39\59\u0ac5\n9\39\59\u0ac8\n9\69\u0aca"+
		"\n9\r9\169\u0acb\39\39\3:\3:\3:\3;\3;\3;\3;\3;\5;\u0ad8\n;\3<\3<\3<\3"+
		"<\3<\3<\3<\5<\u0ae1\n<\5<\u0ae3\n<\3=\3=\5=\u0ae7\n=\3>\3>\3>\3>\3>\3"+
		">\5>\u0aef\n>\3?\5?\u0af2\n?\3?\3?\3?\3?\5?\u0af8\n?\3@\3@\3@\3@\7@\u0afe"+
		"\n@\f@\16@\u0b01\13@\3@\3@\3A\3A\3A\3B\3B\3C\3C\3C\3C\3C\7C\u0b0f\nC\f"+
		"C\16C\u0b12\13C\3C\3C\3D\3D\3D\3D\3E\3E\3E\3E\3E\7E\u0b1f\nE\fE\16E\u0b22"+
		"\13E\3F\3F\3F\3F\5F\u0b28\nF\3G\3G\5G\u0b2c\nG\3G\3G\5G\u0b30\nG\5G\u0b32"+
		"\nG\3H\3H\3I\3I\5I\u0b38\nI\3J\3J\3J\5J\u0b3d\nJ\3K\3K\3K\5K\u0b42\nK"+
		"\3L\3L\3L\3M\3M\3M\3N\3N\3N\3O\3O\3O\5O\u0b50\nO\3O\3O\5O\u0b54\nO\3P"+
		"\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\5P\u0b61\nP\3Q\3Q\3R\3R\5R\u0b67\nR\3R"+
		"\3R\5R\u0b6b\nR\3R\3R\3R\5R\u0b70\nR\3R\3R\3R\5R\u0b75\nR\3R\3R\5R\u0b79"+
		"\nR\3R\5R\u0b7c\nR\3S\3S\3S\3S\3T\3T\3T\5T\u0b85\nT\3T\3T\3T\5T\u0b8a"+
		"\nT\3T\3T\5T\u0b8e\nT\3T\3T\3T\3T\5T\u0b94\nT\3T\3T\3T\3T\5T\u0b9a\nT"+
		"\3T\3T\3T\5T\u0b9f\nT\3T\3T\5T\u0ba3\nT\5T\u0ba5\nT\3U\3U\5U\u0ba9\nU"+
		"\3U\3U\5U\u0bad\nU\5U\u0baf\nU\3V\3V\5V\u0bb3\nV\3W\3W\5W\u0bb7\nW\3W"+
		"\3W\5W\u0bbb\nW\3W\3W\5W\u0bbf\nW\3W\5W\u0bc2\nW\3X\3X\5X\u0bc6\nX\3X"+
		"\3X\3X\5X\u0bcb\nX\5X\u0bcd\nX\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u0bd7\nY\3Z"+
		"\3Z\3[\3[\3[\3[\3[\5[\u0be0\n[\3[\3[\3[\3[\3[\5[\u0be7\n[\3[\5[\u0bea"+
		"\n[\3\\\3\\\5\\\u0bee\n\\\3\\\3\\\5\\\u0bf2\n\\\3\\\3\\\3\\\5\\\u0bf7"+
		"\n\\\5\\\u0bf9\n\\\3]\3]\5]\u0bfd\n]\3]\3]\3]\5]\u0c02\n]\3]\3]\5]\u0c06"+
		"\n]\5]\u0c08\n]\3^\3^\5^\u0c0c\n^\3_\3_\3_\3_\3`\3`\3`\3`\3`\3`\3`\3`"+
		"\3`\3`\3`\5`\u0c1d\n`\3a\3a\3b\3b\3c\5c\u0c24\nc\3c\3c\3d\3d\3e\3e\3e"+
		"\3e\3e\3e\5e\u0c30\ne\5e\u0c32\ne\3f\3f\3f\5f\u0c37\nf\3f\3f\3f\3g\3g"+
		"\3h\3h\3h\3h\3h\3i\3i\3i\3i\3i\3j\3j\3k\3k\3k\3k\3k\3k\3k\3k\3k\3k\3k"+
		"\3k\6k\u0c56\nk\rk\16k\u0c57\3k\3k\5k\u0c5c\nk\3l\3l\5l\u0c60\nl\3m\3"+
		"m\3m\6m\u0c65\nm\rm\16m\u0c66\3m\5m\u0c6a\nm\3m\3m\3n\3n\6n\u0c70\nn\r"+
		"n\16n\u0c71\3n\5n\u0c75\nn\3n\3n\3o\3o\3o\3o\3o\3p\3p\3p\3p\3p\3q\3q\3"+
		"q\3r\3r\5r\u0c88\nr\3s\3s\3s\3s\3s\3s\3s\3t\3t\3u\3u\3v\3v\3v\3v\5v\u0c99"+
		"\nv\3w\3w\3w\3w\3w\7w\u0ca0\nw\fw\16w\u0ca3\13w\3w\3w\3x\3x\3x\3x\3x\3"+
		"y\3y\3y\3y\3z\3z\3z\3z\5z\u0cb4\nz\3{\3{\3{\7{\u0cb9\n{\f{\16{\u0cbc\13"+
		"{\3|\3|\3|\7|\u0cc1\n|\f|\16|\u0cc4\13|\3}\5}\u0cc7\n}\3}\3}\3~\3~\3~"+
		"\3~\7~\u0ccf\n~\f~\16~\u0cd2\13~\3~\3~\3\177\3\177\5\177\u0cd8\n\177\3"+
		"\u0080\3\u0080\3\u0080\7\u0080\u0cdd\n\u0080\f\u0080\16\u0080\u0ce0\13"+
		"\u0080\3\u0081\3\u0081\3\u0082\3\u0082\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\3\u0083\3\u0083\3\u0083\3\u0084\3\u0084\3\u0084\5\u0084\u0cf0\n\u0084"+
		"\3\u0085\3\u0085\3\u0086\3\u0086\5\u0086\u0cf6\n\u0086\3\u0087\3\u0087"+
		"\3\u0088\3\u0088\3\u0088\7\u0088\u0cfd\n\u0088\f\u0088\16\u0088\u0d00"+
		"\13\u0088\3\u0088\3\u0088\3\u0088\3\u0088\5\u0088\u0d06\n\u0088\3\u0089"+
		"\3\u0089\3\u008a\3\u008a\5\u008a\u0d0c\n\u008a\3\u008b\3\u008b\3\u008c"+
		"\3\u008c\3\u008c\3\u008c\3\u008c\3\u008d\5\u008d\u0d16\n\u008d\3\u008d"+
		"\5\u008d\u0d19\n\u008d\3\u008d\5\u008d\u0d1c\n\u008d\3\u008d\3\u008d\3"+
		"\u008d\3\u008d\3\u008d\5\u008d\u0d23\n\u008d\3\u008e\3\u008e\3\u008f\3"+
		"\u008f\3\u0090\3\u0090\3\u0090\7\u0090\u0d2c\n\u0090\f\u0090\16\u0090"+
		"\u0d2f\13\u0090\3\u0091\3\u0091\3\u0091\7\u0091\u0d34\n\u0091\f\u0091"+
		"\16\u0091\u0d37\13\u0091\3\u0092\3\u0092\3\u0092\5\u0092\u0d3c\n\u0092"+
		"\3\u0093\3\u0093\5\u0093\u0d40\n\u0093\3\u0094\3\u0094\5\u0094\u0d44\n"+
		"\u0094\3\u0094\3\u0094\3\u0095\3\u0095\3\u0096\3\u0096\5\u0096\u0d4c\n"+
		"\u0096\3\u0097\3\u0097\5\u0097\u0d50\n\u0097\3\u0098\3\u0098\3\u0098\3"+
		"\u0098\3\u0099\3\u0099\5\u0099\u0d58\n\u0099\3\u009a\3\u009a\3\u009b\3"+
		"\u009b\3\u009c\3\u009c\5\u009c\u0d60\n\u009c\3\u009d\3\u009d\5\u009d\u0d64"+
		"\n\u009d\3\u009e\3\u009e\5\u009e\u0d68\n\u009e\3\u009e\5\u009e\u0d6b\n"+
		"\u009e\3\u009e\5\u009e\u0d6e\n\u009e\3\u009e\5\u009e\u0d71\n\u009e\3\u009e"+
		"\5\u009e\u0d74\n\u009e\3\u009f\3\u009f\5\u009f\u0d78\n\u009f\3\u009f\3"+
		"\u009f\5\u009f\u0d7c\n\u009f\3\u009f\5\u009f\u0d7f\n\u009f\3\u009f\5\u009f"+
		"\u0d82\n\u009f\3\u00a0\3\u00a0\3\u00a0\7\u00a0\u0d87\n\u00a0\f\u00a0\16"+
		"\u00a0\u0d8a\13\u00a0\3\u00a1\3\u00a1\5\u00a1\u0d8e\n\u00a1\3\u00a2\3"+
		"\u00a2\6\u00a2\u0d92\n\u00a2\r\u00a2\16\u00a2\u0d93\3\u00a3\3\u00a3\3"+
		"\u00a3\3\u00a3\5\u00a3\u0d9a\n\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3"+
		"\u00a3\3\u00a3\5\u00a3\u0da2\n\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3"+
		"\u00a3\5\u00a3\u0da9\n\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a5\5"+
		"\u00a5\u0db0\n\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a5\3\u00a6\3\u00a6\5"+
		"\u00a6\u0db8\n\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a7\3\u00a7\3\u00a7\3"+
		"\u00a7\3\u00a8\3\u00a8\5\u00a8\u0dc3\n\u00a8\3\u00a9\3\u00a9\5\u00a9\u0dc7"+
		"\n\u00a9\3\u00aa\3\u00aa\3\u00ab\3\u00ab\5\u00ab\u0dcd\n\u00ab\3\u00ac"+
		"\3\u00ac\3\u00ac\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ae\3\u00ae"+
		"\5\u00ae\u0dd9\n\u00ae\3\u00ae\5\u00ae\u0ddc\n\u00ae\3\u00ae\5\u00ae\u0ddf"+
		"\n\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u0de5\n\u00ae\3\u00ae"+
		"\3\u00ae\5\u00ae\u0de9\n\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae"+
		"\5\u00ae\u0df0\n\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u0df6\n"+
		"\u00ae\3\u00af\3\u00af\3\u00af\7\u00af\u0dfb\n\u00af\f\u00af\16\u00af"+
		"\u0dfe\13\u00af\3\u00b0\3\u00b0\5\u00b0\u0e02\n\u00b0\3\u00b1\3\u00b1"+
		"\3\u00b1\3\u00b1\3\u00b1\7\u00b1\u0e09\n\u00b1\f\u00b1\16\u00b1\u0e0c"+
		"\13\u00b1\5\u00b1\u0e0e\n\u00b1\3\u00b1\3\u00b1\3\u00b2\3\u00b2\3\u00b3"+
		"\3\u00b3\3\u00b3\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\5\u00b4\u0e1c"+
		"\n\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b6\3\u00b6\3\u00b6\7\u00b6"+
		"\u0e25\n\u00b6\f\u00b6\16\u00b6\u0e28\13\u00b6\3\u00b7\3\u00b7\3\u00b7"+
		"\3\u00b7\5\u00b7\u0e2e\n\u00b7\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8"+
		"\5\u00b8\u0e35\n\u00b8\3\u00b9\3\u00b9\3\u00b9\7\u00b9\u0e3a\n\u00b9\f"+
		"\u00b9\16\u00b9\u0e3d\13\u00b9\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba"+
		"\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bc\3\u00bc\3\u00bc\3\u00bd"+
		"\3\u00bd\3\u00bd\3\u00be\3\u00be\3\u00be\7\u00be\u0e52\n\u00be\f\u00be"+
		"\16\u00be\u0e55\13\u00be\3\u00bf\3\u00bf\3\u00c0\3\u00c0\5\u00c0\u0e5b"+
		"\n\u00c0\3\u00c1\3\u00c1\3\u00c1\3\u00c1\5\u00c1\u0e61\n\u00c1\3\u00c1"+
		"\3\u00c1\5\u00c1\u0e65\n\u00c1\3\u00c1\3\u00c1\5\u00c1\u0e69\n\u00c1\3"+
		"\u00c1\7\u00c1\u0e6c\n\u00c1\f\u00c1\16\u00c1\u0e6f\13\u00c1\3\u00c2\3"+
		"\u00c2\5\u00c2\u0e73\n\u00c2\3\u00c3\3\u00c3\3\u00c3\3\u00c3\5\u00c3\u0e79"+
		"\n\u00c3\3\u00c3\3\u00c3\5\u00c3\u0e7d\n\u00c3\3\u00c3\3\u00c3\5\u00c3"+
		"\u0e81\n\u00c3\3\u00c3\7\u00c3\u0e84\n\u00c3\f\u00c3\16\u00c3\u0e87\13"+
		"\u00c3\3\u00c4\3\u00c4\5\u00c4\u0e8b\n\u00c4\3\u00c5\3\u00c5\3\u00c5\3"+
		"\u00c5\3\u00c5\5\u00c5\u0e92\n\u00c5\3\u00c6\3\u00c6\5\u00c6\u0e96\n\u00c6"+
		"\3\u00c7\3\u00c7\3\u00c7\3\u00c8\3\u00c8\5\u00c8\u0e9d\n\u00c8\3\u00c9"+
		"\3\u00c9\3\u00c9\3\u00c9\3\u00c9\5\u00c9\u0ea4\n\u00c9\5\u00c9\u0ea6\n"+
		"\u00c9\3\u00ca\3\u00ca\5\u00ca\u0eaa\n\u00ca\3\u00ca\3\u00ca\5\u00ca\u0eae"+
		"\n\u00ca\3\u00cb\3\u00cb\3\u00cb\7\u00cb\u0eb3\n\u00cb\f\u00cb\16\u00cb"+
		"\u0eb6\13\u00cb\3\u00cc\3\u00cc\5\u00cc\u0eba\n\u00cc\3\u00cd\3\u00cd"+
		"\3\u00cd\7\u00cd\u0ebf\n\u00cd\f\u00cd\16\u00cd\u0ec2\13\u00cd\3\u00ce"+
		"\3\u00ce\5\u00ce\u0ec6\n\u00ce\3\u00ce\3\u00ce\3\u00cf\3\u00cf\3\u00d0"+
		"\3\u00d0\3\u00d0\5\u00d0\u0ecf\n\u00d0\3\u00d0\3\u00d0\3\u00d1\5\u00d1"+
		"\u0ed4\n\u00d1\3\u00d1\3\u00d1\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2"+
		"\7\u00d2\u0edd\n\u00d2\f\u00d2\16\u00d2\u0ee0\13\u00d2\3\u00d2\3\u00d2"+
		"\3\u00d3\3\u00d3\3\u00d3\7\u00d3\u0ee7\n\u00d3\f\u00d3\16\u00d3\u0eea"+
		"\13\u00d3\3\u00d4\3\u00d4\3\u00d5\3\u00d5\3\u00d6\3\u00d6\3\u00d7\3\u00d7"+
		"\3\u00d7\3\u00d7\3\u00d8\3\u00d8\3\u00d8\3\u00d8\3\u00d8\3\u00d8\5\u00d8"+
		"\u0efc\n\u00d8\3\u00d9\3\u00d9\3\u00d9\3\u00d9\3\u00da\3\u00da\3\u00db"+
		"\3\u00db\3\u00db\3\u00dc\5\u00dc\u0f08\n\u00dc\3\u00dc\3\u00dc\5\u00dc"+
		"\u0f0c\n\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dd\3\u00dd\5\u00dd"+
		"\u0f14\n\u00dd\3\u00dd\3\u00dd\3\u00dd\3\u00de\3\u00de\3\u00de\3\u00de"+
		"\3\u00de\5\u00de\u0f1e\n\u00de\3\u00df\3\u00df\3\u00df\7\u00df\u0f23\n"+
		"\u00df\f\u00df\16\u00df\u0f26\13\u00df\3\u00e0\3\u00e0\3\u00e0\3\u00e0"+
		"\3\u00e1\5\u00e1\u0f2d\n\u00e1\3\u00e1\3\u00e1\5\u00e1\u0f31\n\u00e1\3"+
		"\u00e2\3\u00e2\3\u00e2\5\u00e2\u0f36\n\u00e2\3\u00e3\3\u00e3\3\u00e4\3"+
		"\u00e4\3\u00e4\5\u00e4\u0f3d\n\u00e4\3\u00e4\3\u00e4\3\u00e5\3\u00e5\3"+
		"\u00e5\3\u00e5\3\u00e5\3\u00e6\3\u00e6\5\u00e6\u0f48\n\u00e6\3\u00e7\3"+
		"\u00e7\3\u00e8\3\u00e8\3\u00e9\5\u00e9\u0f4f\n\u00e9\3\u00e9\3\u00e9\3"+
		"\u00e9\3\u00ea\3\u00ea\3\u00ea\3\u00eb\3\u00eb\5\u00eb\u0f59\n\u00eb\3"+
		"\u00ec\3\u00ec\3\u00ed\3\u00ed\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ef"+
		"\3\u00ef\3\u00ef\3\u00ef\6\u00ef\u0f67\n\u00ef\r\u00ef\16\u00ef\u0f68"+
		"\3\u00ef\5\u00ef\u0f6c\n\u00ef\3\u00f0\3\u00f0\3\u00f0\7\u00f0\u0f71\n"+
		"\u00f0\f\u00f0\16\u00f0\u0f74\13\u00f0\3\u00f1\3\u00f1\5\u00f1\u0f78\n"+
		"\u00f1\3\u00f1\5\u00f1\u0f7b\n\u00f1\3\u00f2\3\u00f2\3\u00f3\3\u00f3\3"+
		"\u00f3\3\u00f4\3\u00f4\3\u00f4\3\u00f4\5\u00f4\u0f86\n\u00f4\3\u00f4\2"+
		"\2\u00f5\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2"+
		"\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba"+
		"\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2"+
		"\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea"+
		"\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102"+
		"\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a"+
		"\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e\u0130\u0132"+
		"\u0134\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146\u0148\u014a"+
		"\u014c\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c\u015e\u0160\u0162"+
		"\u0164\u0166\u0168\u016a\u016c\u016e\u0170\u0172\u0174\u0176\u0178\u017a"+
		"\u017c\u017e\u0180\u0182\u0184\u0186\u0188\u018a\u018c\u018e\u0190\u0192"+
		"\u0194\u0196\u0198\u019a\u019c\u019e\u01a0\u01a2\u01a4\u01a6\u01a8\u01aa"+
		"\u01ac\u01ae\u01b0\u01b2\u01b4\u01b6\u01b8\u01ba\u01bc\u01be\u01c0\u01c2"+
		"\u01c4\u01c6\u01c8\u01ca\u01cc\u01ce\u01d0\u01d2\u01d4\u01d6\u01d8\u01da"+
		"\u01dc\u01de\u01e0\u01e2\u01e4\u01e6\2>\4\288\u0117\u0117\4\2aa\u00f9"+
		"\u00f9\4\2\21\21ll\4\2\u00b3\u00b3\u0103\u0103\4\2\u00b0\u00b0\u00b4\u00b4"+
		"\4\2\u0091\u0091\u00fa\u00fa\4\2ZZ\u009c\u009c\4\2  AA\3\2\u00e4\u00e5"+
		"\4\2gg\u011c\u011c\t\2!!jjtt\u0081\u0081\u0083\u0083\u0086\u0086\u00c9"+
		"\u00c9\4\2tt\u0086\u0087\4\2UUuu\4\2\u0117\u0117\u0158\u0158\5\2!!\u0083"+
		"\u0083\u00c9\u00c9\4\2hhxx\6\2jjtt\u0086\u0086\u00c9\u00c9\5\2\25\25\32"+
		"\32|}\4\2\32\32\u0087\u0087\4\2tt\u0086\u0086\5\2\26\26pp\u0081\u0081"+
		"\4\2\u0098\u0098\u00bc\u00bc\6\2\u00a4\u00a4\u00af\u00af\u00ed\u00ed\u0111"+
		"\u0111\20\2\24\24\30\30\34\34%%//ggqr{{\u008b\u008b\u009f\u009f\u00c5"+
		"\u00c5\u0102\u0102\u010f\u010f\u0118\u0118\7\2BByy\u0106\u0106\u0124\u0124"+
		"\u0126\u0126\4\2MM\u00ae\u00ae\4\2\35\35\u0158\u0158\4\2\u00cb\u00cb\u00ce"+
		"\u00ce\6\2CCKK\\\\\u008a\u008a\3\2|}\4\299UU\4\2--DD\b\2\7\7\27\27\36"+
		"\36\u00a1\u00a1\u00c6\u00c6\u010a\u010a\3\2\u0176\u0177\n\2kk\u0090\u00c2"+
		"\u00c4\u00c5\u00c7\u00e3\u00e6\u010f\u0111\u0139\u013b\u0149\u014b\u0151"+
		"\b\2\u0081\u0081\u00f7\u00f7\u013a\u013a\u0149\u0149\u014f\u014f\u0151"+
		"\u0151\4\2\u0148\u0148\u0150\u0150\3\2\u012e\u0136\3\2\u0137\u0139\3\2"+
		"\u012a\u012b\3\2\u008e\u008f\3\2\u0172\u0173\17\2\n\nww\u0093\u0093\u009d"+
		"\u009d\u00a6\u00a6\u00b7\u00b7\u00c0\u00c0\u00ca\u00ca\u00d7\u00d7\u00dc"+
		"\u00dc\u010b\u010c\u010e\u010e\u0120\u0121\3\2\u0164\u0165\3\2\u0166\u0168"+
		"\3\2\u0113\u0115\5\2\17\17QQ\177\177\5\2\60\60\u0082\u0082\u011a\u011a"+
		"\5\2\65\65RRoo\4\2++\u0084\u0084\4\2\7\7$$\4\2\u0158\u0158\u015d\u0161"+
		"\4\2\13\13zz\6\2@@SS\u00f8\u00f8\u00fd\u00fd\3\2\u0152\u0155\4\2\n\nw"+
		"w\6\2\u00ab\u00ab\u00c3\u00c3\u00de\u00df\u0128\u0128\n\2\u0099\u0099"+
		"\u00ad\u00ad\u00b1\u00b2\u00b5\u00b5\u00cc\u00cd\u00d9\u00db\u00f5\u00f5"+
		"\u0125\u0125\3\2\u0162\u0163\4\2\f\f##\u1182\2\u01ed\3\2\2\2\4\u01f4\3"+
		"\2\2\2\6\u01f8\3\2\2\2\b\u01fa\3\2\2\2\n\u0250\3\2\2\2\f\u0255\3\2\2\2"+
		"\16\u0268\3\2\2\2\20\u026a\3\2\2\2\22\u0274\3\2\2\2\24\u0289\3\2\2\2\26"+
		"\u0290\3\2\2\2\30\u02be\3\2\2\2\32\u0362\3\2\2\2\34\u0364\3\2\2\2\36\u036a"+
		"\3\2\2\2 \u037e\3\2\2\2\"\u03ad\3\2\2\2$\u03af\3\2\2\2&\u0453\3\2\2\2"+
		"(\u0455\3\2\2\2*\u0471\3\2\2\2,\u04ad\3\2\2\2.\u04c8\3\2\2\2\60\u04e0"+
		"\3\2\2\2\62\u04f6\3\2\2\2\64\u0515\3\2\2\2\66\u053d\3\2\2\28\u0540\3\2"+
		"\2\2:\u058c\3\2\2\2<\u06c5\3\2\2\2>\u06dd\3\2\2\2@\u0815\3\2\2\2B\u082f"+
		"\3\2\2\2D\u0875\3\2\2\2F\u08d0\3\2\2\2H\u08d3\3\2\2\2J\u08e7\3\2\2\2L"+
		"\u08ea\3\2\2\2N\u08f3\3\2\2\2P\u08fd\3\2\2\2R\u08ff\3\2\2\2T\u0901\3\2"+
		"\2\2V\u0904\3\2\2\2X\u0912\3\2\2\2Z\u091f\3\2\2\2\\\u094b\3\2\2\2^\u094d"+
		"\3\2\2\2`\u0971\3\2\2\2b\u09a1\3\2\2\2d\u09fb\3\2\2\2f\u09fd\3\2\2\2h"+
		"\u0a09\3\2\2\2j\u0a0e\3\2\2\2l\u0a82\3\2\2\2n\u0ab4\3\2\2\2p\u0ac0\3\2"+
		"\2\2r\u0acf\3\2\2\2t\u0ad7\3\2\2\2v\u0ae2\3\2\2\2x\u0ae6\3\2\2\2z\u0aee"+
		"\3\2\2\2|\u0af1\3\2\2\2~\u0af9\3\2\2\2\u0080\u0b04\3\2\2\2\u0082\u0b07"+
		"\3\2\2\2\u0084\u0b09\3\2\2\2\u0086\u0b15\3\2\2\2\u0088\u0b19\3\2\2\2\u008a"+
		"\u0b23\3\2\2\2\u008c\u0b31\3\2\2\2\u008e\u0b33\3\2\2\2\u0090\u0b37\3\2"+
		"\2\2\u0092\u0b3c\3\2\2\2\u0094\u0b41\3\2\2\2\u0096\u0b43\3\2\2\2\u0098"+
		"\u0b46\3\2\2\2\u009a\u0b49\3\2\2\2\u009c\u0b53\3\2\2\2\u009e\u0b60\3\2"+
		"\2\2\u00a0\u0b62\3\2\2\2\u00a2\u0b7b\3\2\2\2\u00a4\u0b7d\3\2\2\2\u00a6"+
		"\u0ba4\3\2\2\2\u00a8\u0bae\3\2\2\2\u00aa\u0bb2\3\2\2\2\u00ac\u0bc1\3\2"+
		"\2\2\u00ae\u0bcc\3\2\2\2\u00b0\u0bd6\3\2\2\2\u00b2\u0bd8\3\2\2\2\u00b4"+
		"\u0be9\3\2\2\2\u00b6\u0bf8\3\2\2\2\u00b8\u0c07\3\2\2\2\u00ba\u0c0b\3\2"+
		"\2\2\u00bc\u0c0d\3\2\2\2\u00be\u0c1c\3\2\2\2\u00c0\u0c1e\3\2\2\2\u00c2"+
		"\u0c20\3\2\2\2\u00c4\u0c23\3\2\2\2\u00c6\u0c27\3\2\2\2\u00c8\u0c31\3\2"+
		"\2\2\u00ca\u0c33\3\2\2\2\u00cc\u0c3b\3\2\2\2\u00ce\u0c3d\3\2\2\2\u00d0"+
		"\u0c42\3\2\2\2\u00d2\u0c47\3\2\2\2\u00d4\u0c5b\3\2\2\2\u00d6\u0c5f\3\2"+
		"\2\2\u00d8\u0c61\3\2\2\2\u00da\u0c6d\3\2\2\2\u00dc\u0c78\3\2\2\2\u00de"+
		"\u0c7d\3\2\2\2\u00e0\u0c82\3\2\2\2\u00e2\u0c87\3\2\2\2\u00e4\u0c89\3\2"+
		"\2\2\u00e6\u0c90\3\2\2\2\u00e8\u0c92\3\2\2\2\u00ea\u0c98\3\2\2\2\u00ec"+
		"\u0c9a\3\2\2\2\u00ee\u0ca6\3\2\2\2\u00f0\u0cab\3\2\2\2\u00f2\u0cb3\3\2"+
		"\2\2\u00f4\u0cb5\3\2\2\2\u00f6\u0cbd\3\2\2\2\u00f8\u0cc6\3\2\2\2\u00fa"+
		"\u0cca\3\2\2\2\u00fc\u0cd7\3\2\2\2\u00fe\u0cd9\3\2\2\2\u0100\u0ce1\3\2"+
		"\2\2\u0102\u0ce3\3\2\2\2\u0104\u0ce5\3\2\2\2\u0106\u0cef\3\2\2\2\u0108"+
		"\u0cf1\3\2\2\2\u010a\u0cf5\3\2\2\2\u010c\u0cf7\3\2\2\2\u010e\u0d05\3\2"+
		"\2\2\u0110\u0d07\3\2\2\2\u0112\u0d0b\3\2\2\2\u0114\u0d0d\3\2\2\2\u0116"+
		"\u0d0f\3\2\2\2\u0118\u0d22\3\2\2\2\u011a\u0d24\3\2\2\2\u011c\u0d26\3\2"+
		"\2\2\u011e\u0d28\3\2\2\2\u0120\u0d30\3\2\2\2\u0122\u0d3b\3\2\2\2\u0124"+
		"\u0d3d\3\2\2\2\u0126\u0d41\3\2\2\2\u0128\u0d47\3\2\2\2\u012a\u0d4b\3\2"+
		"\2\2\u012c\u0d4f\3\2\2\2\u012e\u0d51\3\2\2\2\u0130\u0d57\3\2\2\2\u0132"+
		"\u0d59\3\2\2\2\u0134\u0d5b\3\2\2\2\u0136\u0d5f\3\2\2\2\u0138\u0d63\3\2"+
		"\2\2\u013a\u0d65\3\2\2\2\u013c\u0d75\3\2\2\2\u013e\u0d83\3\2\2\2\u0140"+
		"\u0d8d\3\2\2\2\u0142\u0d8f\3\2\2\2\u0144\u0da8\3\2\2\2\u0146\u0daa\3\2"+
		"\2\2\u0148\u0daf\3\2\2\2\u014a\u0db5\3\2\2\2\u014c\u0dbc\3\2\2\2\u014e"+
		"\u0dc2\3\2\2\2\u0150\u0dc4\3\2\2\2\u0152\u0dc8\3\2\2\2\u0154\u0dcc\3\2"+
		"\2\2\u0156\u0dce\3\2\2\2\u0158\u0dd1\3\2\2\2\u015a\u0df5\3\2\2\2\u015c"+
		"\u0df7\3\2\2\2\u015e\u0e01\3\2\2\2\u0160\u0e03\3\2\2\2\u0162\u0e11\3\2"+
		"\2\2\u0164\u0e13\3\2\2\2\u0166\u0e1b\3\2\2\2\u0168\u0e1d\3\2\2\2\u016a"+
		"\u0e21\3\2\2\2\u016c\u0e2d\3\2\2\2\u016e\u0e34\3\2\2\2\u0170\u0e36\3\2"+
		"\2\2\u0172\u0e3e\3\2\2\2\u0174\u0e43\3\2\2\2\u0176\u0e48\3\2\2\2\u0178"+
		"\u0e4b\3\2\2\2\u017a\u0e4e\3\2\2\2\u017c\u0e56\3\2\2\2\u017e\u0e5a\3\2"+
		"\2\2\u0180\u0e64\3\2\2\2\u0182\u0e72\3\2\2\2\u0184\u0e7c\3\2\2\2\u0186"+
		"\u0e8a\3\2\2\2\u0188\u0e91\3\2\2\2\u018a\u0e95\3\2\2\2\u018c\u0e97\3\2"+
		"\2\2\u018e\u0e9c\3\2\2\2\u0190\u0e9e\3\2\2\2\u0192\u0ea7\3\2\2\2\u0194"+
		"\u0eaf\3\2\2\2\u0196\u0eb9\3\2\2\2\u0198\u0ebb\3\2\2\2\u019a\u0ec5\3\2"+
		"\2\2\u019c\u0ec9\3\2\2\2\u019e\u0ece\3\2\2\2\u01a0\u0ed3\3\2\2\2\u01a2"+
		"\u0ed7\3\2\2\2\u01a4\u0ee3\3\2\2\2\u01a6\u0eeb\3\2\2\2\u01a8\u0eed\3\2"+
		"\2\2\u01aa\u0eef\3\2\2\2\u01ac\u0ef1\3\2\2\2\u01ae\u0efb\3\2\2\2\u01b0"+
		"\u0efd\3\2\2\2\u01b2\u0f01\3\2\2\2\u01b4\u0f03\3\2\2\2\u01b6\u0f07\3\2"+
		"\2\2\u01b8\u0f11\3\2\2\2\u01ba\u0f1d\3\2\2\2\u01bc\u0f1f\3\2\2\2\u01be"+
		"\u0f27\3\2\2\2\u01c0\u0f30\3\2\2\2\u01c2\u0f35\3\2\2\2\u01c4\u0f37\3\2"+
		"\2\2\u01c6\u0f39\3\2\2\2\u01c8\u0f40\3\2\2\2\u01ca\u0f47\3\2\2\2\u01cc"+
		"\u0f49\3\2\2\2\u01ce\u0f4b\3\2\2\2\u01d0\u0f4e\3\2\2\2\u01d2\u0f53\3\2"+
		"\2\2\u01d4\u0f58\3\2\2\2\u01d6\u0f5a\3\2\2\2\u01d8\u0f5c\3\2\2\2\u01da"+
		"\u0f5e\3\2\2\2\u01dc\u0f6b\3\2\2\2\u01de\u0f6d\3\2\2\2\u01e0\u0f75\3\2"+
		"\2\2\u01e2\u0f7c\3\2\2\2\u01e4\u0f7e\3\2\2\2\u01e6\u0f85\3\2\2\2\u01e8"+
		"\u01e9\5\4\3\2\u01e9\u01ea\7\u015a\2\2\u01ea\u01ec\3\2\2\2\u01eb\u01e8"+
		"\3\2\2\2\u01ec\u01ef\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee"+
		"\u01f0\3\2\2\2\u01ef\u01ed\3\2\2\2\u01f0\u01f1\7\2\2\3\u01f1\3\3\2\2\2"+
		"\u01f2\u01f5\5\6\4\2\u01f3\u01f5\5\f\7\2\u01f4\u01f2\3\2\2\2\u01f4\u01f3"+
		"\3\2\2\2\u01f5\5\3\2\2\2\u01f6\u01f9\5\u017c\u00bf\2\u01f7\u01f9\5\b\5"+
		"\2\u01f8\u01f6\3\2\2\2\u01f8\u01f7\3\2\2\2\u01f9\7\3\2\2\2\u01fa\u020a"+
		"\7\31\2\2\u01fb\u0207\5\u0190\u00c9\2\u01fc\u01fd\7\u0162\2\2\u01fd\u0202"+
		"\5\u0190\u00c9\2\u01fe\u01ff\7\u015b\2\2\u01ff\u0201\5\u0190\u00c9\2\u0200"+
		"\u01fe\3\2\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2"+
		"\2\2\u0203\u0205\3\2\2\2\u0204\u0202\3\2\2\2\u0205\u0206\7\u0163\2\2\u0206"+
		"\u0208\3\2\2\2\u0207\u01fc\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020b\3\2"+
		"\2\2\u0209\u020b\5\u0192\u00ca\2\u020a\u01fb\3\2\2\2\u020a\u0209\3\2\2"+
		"\2\u020b\u020c\3\2\2\2\u020c\u020f\t\2\2\2\u020d\u0210\5\u008cG\2\u020e"+
		"\u0210\7\u0109\2\2\u020f\u020d\3\2\2\2\u020f\u020e\3\2\2\2\u0210\u021f"+
		"\3\2\2\2\u0211\u0213\7\u008e\2\2\u0212\u0211\3\2\2\2\u0212\u0213\3\2\2"+
		"\2\u0213\u0214\3\2\2\2\u0214\u0215\7\u0162\2\2\u0215\u021a\5\n\6\2\u0216"+
		"\u0217\7\u015b\2\2\u0217\u0219\5\n\6\2\u0218\u0216\3\2\2\2\u0219\u021c"+
		"\3\2\2\2\u021a\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u021d\3\2\2\2\u021c"+
		"\u021a\3\2\2\2\u021d\u021e\7\u0163\2\2\u021e\u0220\3\2\2\2\u021f\u0212"+
		"\3\2\2\2\u021f\u0220\3\2\2\2\u0220\t\3\2\2\2\u0221\u0222\7\u00bf\2\2\u0222"+
		"\u0251\5\u008cG\2\u0223\u0225\7Z\2\2\u0224\u0226\5\u0128\u0095\2\u0225"+
		"\u0224\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0251\3\2\2\2\u0227\u0228\7\""+
		"\2\2\u0228\u0251\5\u008cG\2\u0229\u022a\7X\2\2\u022a\u0251\5\u008cG\2"+
		"\u022b\u022d\7>\2\2\u022c\u022e\5\u0128\u0095\2\u022d\u022c\3\2\2\2\u022d"+
		"\u022e\3\2\2\2\u022e\u0251\3\2\2\2\u022f\u0230\7\u016c\2\2\u0230\u0251"+
		"\5\u008cG\2\u0231\u0232\7*\2\2\u0232\u0251\5\u008cG\2\u0233\u0240\7\63"+
		"\2\2\u0234\u0235\7\u0162\2\2\u0235\u023a\5\u0190\u00c9\2\u0236\u0237\7"+
		"\u015b\2\2\u0237\u0239\5\u0190\u00c9\2\u0238\u0236\3\2\2\2\u0239\u023c"+
		"\3\2\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023d\3\2\2\2\u023c"+
		"\u023a\3\2\2\2\u023d\u023e\7\u0163\2\2\u023e\u0241\3\2\2\2\u023f\u0241"+
		"\7\u0166\2\2\u0240\u0234\3\2\2\2\u0240\u023f\3\2\2\2\u0241\u0251\3\2\2"+
		"\2\u0242\u0243\7\64\2\2\u0243\u0244\7\u0162\2\2\u0244\u0249\5\u0190\u00c9"+
		"\2\u0245\u0246\7\u015b\2\2\u0246\u0248\5\u0190\u00c9\2\u0247\u0245\3\2"+
		"\2\2\u0248\u024b\3\2\2\2\u0249\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a"+
		"\u024c\3\2\2\2\u024b\u0249\3\2\2\2\u024c\u024d\7\u0163\2\2\u024d\u0251"+
		"\3\2\2\2\u024e\u024f\7)\2\2\u024f\u0251\5\u008cG\2\u0250\u0221\3\2\2\2"+
		"\u0250\u0223\3\2\2\2\u0250\u0227\3\2\2\2\u0250\u0229\3\2\2\2\u0250\u022b"+
		"\3\2\2\2\u0250\u022f\3\2\2\2\u0250\u0231\3\2\2\2\u0250\u0233\3\2\2\2\u0250"+
		"\u0242\3\2\2\2\u0250\u024e\3\2\2\2\u0251\13\3\2\2\2\u0252\u0256\5\16\b"+
		"\2\u0253\u0256\5\20\t\2\u0254\u0256\5\u008aF\2\u0255\u0252\3\2\2\2\u0255"+
		"\u0253\3\2\2\2\u0255\u0254\3\2\2\2\u0256\r\3\2\2\2\u0257\u0262\7\32\2"+
		"\2\u0258\u0263\5b\62\2\u0259\u0263\5,\27\2\u025a\u0263\5.\30\2\u025b\u0263"+
		"\58\35\2\u025c\u0263\5D#\2\u025d\u0263\5Z.\2\u025e\u0263\5^\60\2\u025f"+
		"\u0263\5`\61\2\u0260\u0263\5\60\31\2\u0261\u0263\5\62\32\2\u0262\u0258"+
		"\3\2\2\2\u0262\u0259\3\2\2\2\u0262\u025a\3\2\2\2\u0262\u025b\3\2\2\2\u0262"+
		"\u025c\3\2\2\2\u0262\u025d\3\2\2\2\u0262\u025e\3\2\2\2\u0262\u025f\3\2"+
		"\2\2\u0262\u0260\3\2\2\2\u0262\u0261\3\2\2\2\u0263\u0269\3\2\2\2\u0264"+
		"\u0269\5B\"\2\u0265\u0269\5:\36\2\u0266\u0269\5\64\33\2\u0267\u0269\5"+
		"> \2\u0268\u0257\3\2\2\2\u0268\u0264\3\2\2\2\u0268\u0265\3\2\2\2\u0268"+
		"\u0266\3\2\2\2\u0268\u0267\3\2\2\2\u0269\17\3\2\2\2\u026a\u0272\7\b\2"+
		"\2\u026b\u0273\5\22\n\2\u026c\u0273\5\24\13\2\u026d\u0273\5\26\f\2\u026e"+
		"\u0273\5\30\r\2\u026f\u0273\5$\23\2\u0270\u0273\5(\25\2\u0271\u0273\5"+
		"*\26\2\u0272\u026b\3\2\2\2\u0272\u026c\3\2\2\2\u0272\u026d\3\2\2\2\u0272"+
		"\u026e\3\2\2\2\u0272\u026f\3\2\2\2\u0272\u0270\3\2\2\2\u0272\u0271\3\2"+
		"\2\2\u0273\21\3\2\2\2\u0274\u0275\7\66\2\2\u0275\u0287\5H%\2\u0276\u0278"+
		"\5\"\22\2\u0277\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u0277\3\2\2\2"+
		"\u0279\u027a\3\2\2\2\u027a\u027c\3\2\2\2\u027b\u027d\7l\2\2\u027c\u027b"+
		"\3\2\2\2\u027c\u027d\3\2\2\2\u027d\u0288\3\2\2\2\u027e\u027f\7\u00f9\2"+
		"\2\u027f\u0280\7\u0117\2\2\u0280\u0288\5\u0190\u00c9\2\u0281\u0282\7a"+
		"\2\2\u0282\u0283\7\u0117\2\2\u0283\u0288\5\u008cG\2\u0284\u0285\7\u0103"+
		"\2\2\u0285\u0286\7q\2\2\u0286\u0288\5\u0190\u00c9\2\u0287\u0277\3\2\2"+
		"\2\u0287\u027e\3\2\2\2\u0287\u0281\3\2\2\2\u0287\u0284\3\2\2\2\u0288\23"+
		"\3\2\2\2\u0289\u028a\7q\2\2\u028a\u028b\5\u008cG\2\u028b\u028c\t\3\2\2"+
		"\u028c\u028d\7\u0117\2\2\u028d\u028e\5\u008cG\2\u028e\25\3\2\2\2\u028f"+
		"\u0291\7f\2\2\u0290\u028f\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0292\3\2"+
		"\2\2\u0292\u0293\7\u00cf\2\2\u0293\u0294\5\u008cG\2\u0294\u0295\t\3\2"+
		"\2\u0295\u0296\7\u0117\2\2\u0296\u0297\5\u008cG\2\u0297\27\3\2\2\2\u0298"+
		"\u029a\7{\2\2\u0299\u029b\7\u00e8\2\2\u029a\u0299\3\2\2\2\u029a\u029b"+
		"\3\2\2\2\u029b\u029d\3\2\2\2\u029c\u029e\5\u0190\u00c9\2\u029d\u029c\3"+
		"\2\2\2\u029e\u029f\3\2\2\2\u029f\u029d\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0"+
		"\u02b1\3\2\2\2\u02a1\u02a6\5\32\16\2\u02a2\u02a3\7\u015b\2\2\u02a3\u02a5"+
		"\5\32\16\2\u02a4\u02a2\3\2\2\2\u02a5\u02a8\3\2\2\2\u02a6\u02a4\3\2\2\2"+
		"\u02a6\u02a7\3\2\2\2\u02a7\u02b2\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a9\u02ab"+
		"\7\u00f9\2\2\u02aa\u02ac\7\u009f\2\2\u02ab\u02aa\3\2\2\2\u02ab\u02ac\3"+
		"\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae\5\u0190\u00c9\2\u02ae\u02af\7\u0117"+
		"\2\2\u02af\u02b0\5\u0190\u00c9\2\u02b0\u02b2\3\2\2\2\u02b1\u02a1\3\2\2"+
		"\2\u02b1\u02a9\3\2\2\2\u02b2\u02bf\3\2\2\2\u02b3\u02b4\7\b\2\2\u02b4\u02b5"+
		"\7{\2\2\u02b5\u02ba\5\u0190\u00c9\2\u02b6\u02b7\7\u00f9\2\2\u02b7\u02bb"+
		"\7\u0117\2\2\u02b8\u02b9\7\u0103\2\2\u02b9\u02bb\7q\2\2\u02ba\u02b6\3"+
		"\2\2\2\u02ba\u02b8\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02bd\5\u0190\u00c9"+
		"\2\u02bd\u02bf\3\2\2\2\u02be\u0298\3\2\2\2\u02be\u02b3\3\2\2\2\u02bf\31"+
		"\3\2\2\2\u02c0\u02c2\7\3\2\2\u02c1\u02c3\7\u009f\2\2\u02c2\u02c1\3\2\2"+
		"\2\u02c2\u02c3\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u0363\5f\64\2\u02c5\u02c7"+
		"\7\u00b3\2\2\u02c6\u02c8\7\u009f\2\2\u02c7\u02c6\3\2\2\2\u02c7\u02c8\3"+
		"\2\2\2\u02c8\u02cb\3\2\2\2\u02c9\u02ca\7?\2\2\u02ca\u02cc\7\u00b8\2\2"+
		"\u02cb\u02c9\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02cf"+
		"\5\u0190\u00c9\2\u02ce\u02d0\t\4\2\2\u02cf\u02ce\3\2\2\2\u02cf\u02d0\3"+
		"\2\2\2\u02d0\u0363\3\2\2\2\u02d1\u02d3\7\b\2\2\u02d2\u02d4\7\u009f\2\2"+
		"\u02d3\u02d2\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d8"+
		"\5\u0190\u00c9\2\u02d6\u02d7\7\u0103\2\2\u02d7\u02d9\7\u00aa\2\2\u02d8"+
		"\u02d6\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u02db\7\u0118"+
		"\2\2\u02db\u02de\5\u009cO\2\u02dc\u02dd\7\23\2\2\u02dd\u02df\5\u008cG"+
		"\2\u02de\u02dc\3\2\2\2\u02de\u02df\3\2\2\2\u02df\u02e2\3\2\2\2\u02e0\u02e1"+
		"\7\u0088\2\2\u02e1\u02e3\5\u00eav\2\u02e2\u02e0\3\2\2\2\u02e2\u02e3\3"+
		"\2\2\2\u02e3\u0363\3\2\2\2\u02e4\u02e6\7\b\2\2\u02e5\u02e7\7\u009f\2\2"+
		"\u02e6\u02e5\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u0314"+
		"\5\u0190\u00c9\2\u02e9\u02ea\7\u0103\2\2\u02ea\u02eb\7\35\2\2\u02eb\u0315"+
		"\5\u00eav\2\u02ec\u02ed\7\u00b3\2\2\u02ed\u0315\7\35\2\2\u02ee\u02ef\t"+
		"\5\2\2\u02ef\u02f0\7W\2\2\u02f0\u0315\7X\2\2\u02f1\u02f2\7\u0103\2\2\u02f2"+
		"\u02f3\7\u0108\2\2\u02f3\u0315\7\u0172\2\2\u02f4\u02f5\7\u0103\2\2\u02f5"+
		"\u02f6\7\u0162\2\2\u02f6\u02fb\5\34\17\2\u02f7\u02f8\7\u015b\2\2\u02f8"+
		"\u02fa\5\34\17\2\u02f9\u02f7\3\2\2\2\u02fa\u02fd\3\2\2\2\u02fb\u02f9\3"+
		"\2\2\2\u02fb\u02fc\3\2\2\2\u02fc\u02fe\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fe"+
		"\u02ff\7\u0163\2\2\u02ff\u0315\3\2\2\2\u0300\u0301\7\u00fb\2\2\u0301\u0302"+
		"\7\u0162\2\2\u0302\u0307\5 \21\2\u0303\u0304\7\u015b\2\2\u0304\u0306\5"+
		" \21\2\u0305\u0303\3\2\2\2\u0306\u0309\3\2\2\2\u0307\u0305\3\2\2\2\u0307"+
		"\u0308\3\2\2\2\u0308\u030a\3\2\2\2\u0309\u0307\3\2\2\2\u030a\u030b\7\u0163"+
		"\2\2\u030b\u0315\3\2\2\2\u030c\u030d\7\u0103\2\2\u030d\u030e\7\u010a\2"+
		"\2\u030e\u0313\7\u00f1\2\2\u030f\u0313\7\u00ba\2\2\u0310\u0313\7\u00b9"+
		"\2\2\u0311\u0313\7\u00d5\2\2\u0312\u030c\3\2\2\2\u0312\u030f\3\2\2\2\u0312"+
		"\u0310\3\2\2\2\u0312\u0311\3\2\2\2\u0313\u0315\3\2\2\2\u0314\u02e9\3\2"+
		"\2\2\u0314\u02ec\3\2\2\2\u0314\u02ee\3\2\2\2\u0314\u02f1\3\2\2\2\u0314"+
		"\u02f4\3\2\2\2\u0314\u0300\3\2\2\2\u0314\u0312\3\2\2\2\u0315\u0363\3\2"+
		"\2\2\u0316\u0317\7\3\2\2\u0317\u031a\5j\66\2\u0318\u0319\7W\2\2\u0319"+
		"\u031b\7\u011d\2\2\u031a\u0318\3\2\2\2\u031a\u031b\3\2\2\2\u031b\u0363"+
		"\3\2\2\2\u031c\u031d\7\3\2\2\u031d\u0363\5\36\20\2\u031e\u031f\7\u011e"+
		"\2\2\u031f\u0320\7\26\2\2\u0320\u0363\5\u0190\u00c9\2\u0321\u0322\7\u00b3"+
		"\2\2\u0322\u0325\7\26\2\2\u0323\u0324\7?\2\2\u0324\u0326\7\u00b8\2\2\u0325"+
		"\u0323\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u0328\5\u0190"+
		"\u00c9\2\u0328\u0329\t\4\2\2\u0329\u0363\3\2\2\2\u032a\u032b\t\6\2\2\u032b"+
		"\u032f\7\u0081\2\2\u032c\u0330\5\u0190\u00c9\2\u032d\u0330\7\7\2\2\u032e"+
		"\u0330\7\u011c\2\2\u032f\u032c\3\2\2\2\u032f\u032d\3\2\2\2\u032f\u032e"+
		"\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u0363\3\2\2\2\u0331\u0332\7\u00b4\2"+
		"\2\u0332\u0333\t\7\2\2\u0333\u0334\7\u0081\2\2\u0334\u0363\5\u0190\u00c9"+
		"\2\u0335\u0336\t\6\2\2\u0336\u0337\7p\2\2\u0337\u0363\5\u0190\u00c9\2"+
		"\u0338\u0339\7\u00b4\2\2\u0339\u033a\t\7\2\2\u033a\u033b\7p\2\2\u033b"+
		"\u0363\5\u0190\u00c9\2\u033c\u033d\7\u009c\2\2\u033d\u033e\7\u00e7\2\2"+
		"\u033e\u0363\5\u0190\u00c9\2\u033f\u0340\7\u0103\2\2\u0340\u0341\7\u008f"+
		"\2\2\u0341\u0363\t\b\2\2\u0342\u0343\7\u0103\2\2\u0343\u0344\7\u008e\2"+
		"\2\u0344\u0363\7Z\2\2\u0345\u0346\7\u0103\2\2\u0346\u0363\5p9\2\u0347"+
		"\u0348\7\u00fb\2\2\u0348\u0349\7\u0162\2\2\u0349\u034e\5r:\2\u034a\u034b"+
		"\7\u015b\2\2\u034b\u034d\5r:\2\u034c\u034a\3\2\2\2\u034d\u0350\3\2\2\2"+
		"\u034e\u034c\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0351\3\2\2\2\u0350\u034e"+
		"\3\2\2\2\u0351\u0352\7\u0163\2\2\u0352\u0363\3\2\2\2\u0353\u0354\7\u00c4"+
		"\2\2\u0354\u0363\5\u0190\u00c9\2\u0355\u0356\7\u00e1\2\2\u0356\u0357\7"+
		"\u00c4\2\2\u0357\u0363\5\u0190\u00c9\2\u0358\u0359\7Y\2\2\u0359\u0363"+
		"\5\u0190\u00c9\2\u035a\u035b\7W\2\2\u035b\u0363\7Y\2\2\u035c\u035d\7a"+
		"\2\2\u035d\u035e\7\u0117\2\2\u035e\u0363\5\u0190\u00c9\2\u035f\u0360\7"+
		"\u0103\2\2\u0360\u0361\7\u010f\2\2\u0361\u0363\5\u0190\u00c9\2\u0362\u02c0"+
		"\3\2\2\2\u0362\u02c5\3\2\2\2\u0362\u02d1\3\2\2\2\u0362\u02e4\3\2\2\2\u0362"+
		"\u0316\3\2\2\2\u0362\u031c\3\2\2\2\u0362\u031e\3\2\2\2\u0362\u0321\3\2"+
		"\2\2\u0362\u032a\3\2\2\2\u0362\u0331\3\2\2\2\u0362\u0335\3\2\2\2\u0362"+
		"\u0338\3\2\2\2\u0362\u033c\3\2\2\2\u0362\u033f\3\2\2\2\u0362\u0342\3\2"+
		"\2\2\u0362\u0345\3\2\2\2\u0362\u0347\3\2\2\2\u0362\u0353\3\2\2\2\u0362"+
		"\u0355\3\2\2\2\u0362\u0358\3\2\2\2\u0362\u035a\3\2\2\2\u0362\u035c\3\2"+
		"\2\2\u0362\u035f\3\2\2\2\u0363\33\3\2\2\2\u0364\u0365\5 \21\2\u0365\u0366"+
		"\7\u0158\2\2\u0366\u0367\5\u00c4c\2\u0367\35\3\2\2\2\u0368\u0369\7\26"+
		"\2\2\u0369\u036b\5\u0190\u00c9\2\u036a\u0368\3\2\2\2\u036a\u036b\3\2\2"+
		"\2\u036b\u036f\3\2\2\2\u036c\u0370\7\u0085\2\2\u036d\u036e\7c\2\2\u036e"+
		"\u0370\7P\2\2\u036f\u036c\3\2\2\2\u036f\u036d\3\2\2\2\u0370\u0371\3\2"+
		"\2\2\u0371\u0372\7\u0088\2\2\u0372\u0373\7\u00c5\2\2\u0373\u0378\5\u0190"+
		"\u00c9\2\u0374\u0376\7W\2\2\u0375\u0374\3\2\2\2\u0375\u0376\3\2\2\2\u0376"+
		"\u0377\3\2\2\2\u0377\u0379\7\37\2\2\u0378\u0375\3\2\2\2\u0378\u0379\3"+
		"\2\2\2\u0379\u037c\3\2\2\2\u037a\u037b\7F\2\2\u037b\u037d\t\t\2\2\u037c"+
		"\u037a\3\2\2\2\u037c\u037d\3\2\2\2\u037d\37\3\2\2\2\u037e\u037f\t\n\2"+
		"\2\u037f!\3\2\2\2\u0380\u0381\7\u0097\2\2\u0381\u0382\7\u00e7\2\2\u0382"+
		"\u0383\7X\2\2\u0383\u03ae\7\u00c8\2\2\u0384\u0385\7m\2\2\u0385\u0386\7"+
		"X\2\2\u0386\u0387\7\u00e7\2\2\u0387\u0388\7X\2\2\u0388\u03ae\7\u00c8\2"+
		"\2\u0389\u038a\7y\2\2\u038a\u03ae\7B\2\2\u038b\u03ae\7\u0106\2\2\u038c"+
		"\u038e\7\u0124\2\2\u038d\u038f\7\u00ba\2\2\u038e\u038d\3\2\2\2\u038e\u038f"+
		"\3\2\2\2\u038f\u0390\3\2\2\2\u0390\u0391\7\u0101\2\2\u0391\u03ae\7M\2"+
		"\2\u0392\u0394\7\u00ba\2\2\u0393\u0392\3\2\2\2\u0393\u0394\3\2\2\2\u0394"+
		"\u0395\3\2\2\2\u0395\u0396\7\u0101\2\2\u0396\u03ae\7\u00ae\2\2\u0397\u0398"+
		"\7\u00a5\2\2\u0398\u03ae\7\u0172\2\2\u0399\u039a\7i\2\2\u039a\u03ae\7"+
		"\u0172\2\2\u039b\u039c\7\u0103\2\2\u039c\u03a6\5\u008cG\2\u039d\u039e"+
		"\7\u0117\2\2\u039e\u03a3\5\u008cG\2\u039f\u03a0\7\u0158\2\2\u03a0\u03a3"+
		"\5\u008cG\2\u03a1\u03a3\7\35\2\2\u03a2\u039d\3\2\2\2\u03a2\u039f\3\2\2"+
		"\2\u03a2\u03a1\3\2\2\2\u03a3\u03a7\3\2\2\2\u03a4\u03a5\78\2\2\u03a5\u03a7"+
		"\7\u00a8\2\2\u03a6\u03a2\3\2\2\2\u03a6\u03a4\3\2\2\2\u03a7\u03ae\3\2\2"+
		"\2\u03a8\u03ab\7\u00fb\2\2\u03a9\u03ac\5\u008cG\2\u03aa\u03ac\7\7\2\2"+
		"\u03ab\u03a9\3\2\2\2\u03ab\u03aa\3\2\2\2\u03ac\u03ae\3\2\2\2\u03ad\u0380"+
		"\3\2\2\2\u03ad\u0384\3\2\2\2\u03ad\u0389\3\2\2\2\u03ad\u038b\3\2\2\2\u03ad"+
		"\u038c\3\2\2\2\u03ad\u0393\3\2\2\2\u03ad\u0397\3\2\2\2\u03ad\u0399\3\2"+
		"\2\2\u03ad\u039b\3\2\2\2\u03ad\u03a8\3\2\2\2\u03ae#\3\2\2\2\u03af\u03b0"+
		"\7\35\2\2\u03b0\u03bb\7d\2\2\u03b1\u03b2\7\61\2\2\u03b2\u03b3\t\13\2\2"+
		"\u03b3\u03b8\5\u008cG\2\u03b4\u03b5\7\u015b\2\2\u03b5\u03b7\5\u008cG\2"+
		"\u03b6\u03b4\3\2\2\2\u03b7\u03ba\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b8\u03b9"+
		"\3\2\2\2\u03b9\u03bc\3\2\2\2\u03ba\u03b8\3\2\2\2\u03bb\u03b1\3\2\2\2\u03bb"+
		"\u03bc\3\2\2\2\u03bc\u03c7\3\2\2\2\u03bd\u03be\7C\2\2\u03be\u03bf\7q\2"+
		"\2\u03bf\u03c4\5\u008cG\2\u03c0\u03c1\7\u015b\2\2\u03c1\u03c3\5\u008c"+
		"G\2\u03c2\u03c0\3\2\2\2\u03c3\u03c6\3\2\2\2\u03c4\u03c2\3\2\2\2\u03c4"+
		"\u03c5\3\2\2\2\u03c5\u03c8\3\2\2\2\u03c6\u03c4\3\2\2\2\u03c7\u03bd\3\2"+
		"\2\2\u03c7\u03c8\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9\u03ca\5&\24\2\u03ca"+
		"%\3\2\2\2\u03cb\u03d8\7:\2\2\u03cc\u03d1\t\f\2\2\u03cd\u03ce\7\u015b\2"+
		"\2\u03ce\u03d0\t\f\2\2\u03cf\u03cd\3\2\2\2\u03d0\u03d3\3\2\2\2\u03d1\u03cf"+
		"\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03d9\3\2\2\2\u03d3\u03d1\3\2\2\2\u03d4"+
		"\u03d6\7\7\2\2\u03d5\u03d7\7d\2\2\u03d6\u03d5\3\2\2\2\u03d6\u03d7\3\2"+
		"\2\2\u03d7\u03d9\3\2\2\2\u03d8\u03cc\3\2\2\2\u03d8\u03d4\3\2\2\2\u03d9"+
		"\u03da\3\2\2\2\u03da\u03db\7\u00e7\2\2\u03db\u03dc\7\u0110\2\2\u03dc\u0454"+
		"\5@!\2\u03dd\u03ea\7:\2\2\u03de\u03e3\t\r\2\2\u03df\u03e0\7\u015b\2\2"+
		"\u03e0\u03e2\t\r\2\2\u03e1\u03df\3\2\2\2\u03e2\u03e5\3\2\2\2\u03e3\u03e1"+
		"\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4\u03eb\3\2\2\2\u03e5\u03e3\3\2\2\2\u03e6"+
		"\u03e8\7\7\2\2\u03e7\u03e9\7d\2\2\u03e8\u03e7\3\2\2\2\u03e8\u03e9\3\2"+
		"\2\2\u03e9\u03eb\3\2\2\2\u03ea\u03de\3\2\2\2\u03ea\u03e6\3\2\2\2\u03eb"+
		"\u03ec\3\2\2\2\u03ec\u03ed\7\u00e7\2\2\u03ed\u03ee\7s\2\2\u03ee\u0454"+
		"\5@!\2\u03ef\u03f5\7:\2\2\u03f0\u03f6\7.\2\2\u03f1\u03f3\7\7\2\2\u03f2"+
		"\u03f4\7d\2\2\u03f3\u03f2\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4\u03f6\3\2"+
		"\2\2\u03f5\u03f0\3\2\2\2\u03f5\u03f1\3\2\2\2\u03f6\u03f7\3\2\2\2\u03f7"+
		"\u03f8\7\u00e7\2\2\u03f8\u03f9\7\67\2\2\u03f9\u0454\5@!\2\u03fa\u0400"+
		"\7:\2\2\u03fb\u0401\7\u0087\2\2\u03fc\u03fe\7\7\2\2\u03fd\u03ff\7d\2\2"+
		"\u03fe\u03fd\3\2\2\2\u03fe\u03ff\3\2\2\2\u03ff\u0401\3\2\2\2\u0400\u03fb"+
		"\3\2\2\2\u0400\u03fc\3\2\2\2\u0401\u0402\3\2\2\2\u0402\u0403\7\u00e7\2"+
		"\2\u0403\u0404\7\u0119\2\2\u0404\u0454\5@!\2\u0405\u0409\7n\2\2\u0406"+
		"\u0407\7:\2\2\u0407\u0408\7\u00e9\2\2\u0408\u040a\7\61\2\2\u0409\u0406"+
		"\3\2\2\2\u0409\u040a\3\2\2\2\u040a\u0417\3\2\2\2\u040b\u0410\t\f\2\2\u040c"+
		"\u040d\7\u015b\2\2\u040d\u040f\t\f\2\2\u040e\u040c\3\2\2\2\u040f\u0412"+
		"\3\2\2\2\u0410\u040e\3\2\2\2\u0410\u0411\3\2\2\2\u0411\u0418\3\2\2\2\u0412"+
		"\u0410\3\2\2\2\u0413\u0415\7\7\2\2\u0414\u0416\7d\2\2\u0415\u0414\3\2"+
		"\2\2\u0415\u0416\3\2\2\2\u0416\u0418\3\2\2\2\u0417\u040b\3\2\2\2\u0417"+
		"\u0413\3\2\2\2\u0418\u0419\3\2\2\2\u0419\u041a\7\u00e7\2\2\u041a\u041b"+
		"\7\u0110\2\2\u041b\u0454\5<\37\2\u041c\u0420\7n\2\2\u041d\u041e\7:\2\2"+
		"\u041e\u041f\7\u00e9\2\2\u041f\u0421\7\61\2\2\u0420\u041d\3\2\2\2\u0420"+
		"\u0421\3\2\2\2\u0421\u042e\3\2\2\2\u0422\u0427\t\r\2\2\u0423\u0424\7\u015b"+
		"\2\2\u0424\u0426\t\r\2\2\u0425\u0423\3\2\2\2\u0426\u0429\3\2\2\2\u0427"+
		"\u0425\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u042f\3\2\2\2\u0429\u0427\3\2"+
		"\2\2\u042a\u042c\7\7\2\2\u042b\u042d\7d\2\2\u042c\u042b\3\2\2\2\u042c"+
		"\u042d\3\2\2\2\u042d\u042f\3\2\2\2\u042e\u0422\3\2\2\2\u042e\u042a\3\2"+
		"\2\2\u042f\u0430\3\2\2\2\u0430\u0431\7\u00e7\2\2\u0431\u0432\7s\2\2\u0432"+
		"\u0454\5<\37\2\u0433\u0437\7n\2\2\u0434\u0435\7:\2\2\u0435\u0436\7\u00e9"+
		"\2\2\u0436\u0438\7\61\2\2\u0437\u0434\3\2\2\2\u0437\u0438\3\2\2\2\u0438"+
		"\u043e\3\2\2\2\u0439\u043f\7.\2\2\u043a\u043c\7\7\2\2\u043b\u043d\7d\2"+
		"\2\u043c\u043b\3\2\2\2\u043c\u043d\3\2\2\2\u043d\u043f\3\2\2\2\u043e\u0439"+
		"\3\2\2\2\u043e\u043a\3\2\2\2\u043f\u0440\3\2\2\2\u0440\u0441\7\u00e7\2"+
		"\2\u0441\u0442\7\67\2\2\u0442\u0454\5<\37\2\u0443\u0447\7n\2\2\u0444\u0445"+
		"\7:\2\2\u0445\u0446\7\u00e9\2\2\u0446\u0448\7\61\2\2\u0447\u0444\3\2\2"+
		"\2\u0447\u0448\3\2\2\2\u0448\u044e\3\2\2\2\u0449\u044f\7\u0087\2\2\u044a"+
		"\u044c\7\7\2\2\u044b\u044d\7d\2\2\u044c\u044b\3\2\2\2\u044c\u044d\3\2"+
		"\2\2\u044d\u044f\3\2\2\2\u044e\u0449\3\2\2\2\u044e\u044a\3\2\2\2\u044f"+
		"\u0450\3\2\2\2\u0450\u0451\7\u00e7\2\2\u0451\u0452\7\u0119\2\2\u0452\u0454"+
		"\5<\37\2\u0453\u03cb\3\2\2\2\u0453\u03dd\3\2\2\2\u0453\u03ef\3\2\2\2\u0453"+
		"\u03fa\3\2\2\2\u0453\u0405\3\2\2\2\u0453\u041c\3\2\2\2\u0453\u0433\3\2"+
		"\2\2\u0453\u0443\3\2\2\2\u0454\'\3\2\2\2\u0455\u0458\7r\2\2\u0456\u0457"+
		"\7?\2\2\u0457\u0459\7\u00b8\2\2\u0458\u0456\3\2\2\2\u0458\u0459\3\2\2"+
		"\2\u0459\u045a\3\2\2\2\u045a\u046f\5\u0190\u00c9\2\u045b\u0464\5\\/\2"+
		"\u045c\u0461\7\u00fc\2\2\u045d\u045f\7\u008e\2\2\u045e\u045d\3\2\2\2\u045e"+
		"\u045f\3\2\2\2\u045f\u0460\3\2\2\2\u0460\u0462\5\u008cG\2\u0461\u045e"+
		"\3\2\2\2\u0461\u0462\3\2\2\2\u0462\u0464\3\2\2\2\u0463\u045b\3\2\2\2\u0463"+
		"\u045c\3\2\2\2\u0464\u0467\3\2\2\2\u0465\u0463\3\2\2\2\u0465\u0466\3\2"+
		"\2\2\u0466\u0470\3\2\2\2\u0467\u0465\3\2\2\2\u0468\u0469\t\3\2\2\u0469"+
		"\u046d\7\u0117\2\2\u046a\u046b\7\u0103\2\2\u046b\u046d\7q\2\2\u046c\u0468"+
		"\3\2\2\2\u046c\u046a\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u0470\5\u0190\u00c9"+
		"\2\u046f\u0465\3\2\2\2\u046f\u046c\3\2\2\2\u0470)\3\2\2\2\u0471\u0474"+
		"\7\u008b\2\2\u0472\u0473\7?\2\2\u0473\u0475\7\u00b8\2\2\u0474\u0472\3"+
		"\2\2\2\u0474\u0475\3\2\2\2\u0475\u0476\3\2\2\2\u0476\u04aa\5\u0190\u00c9"+
		"\2\u0477\u0479\7\b\2\2\u0478\u047a\7\u009f\2\2\u0479\u0478\3\2\2\2\u0479"+
		"\u047a\3\2\2\2\u047a\u047b\3\2\2\2\u047b\u0481\5\u0190\u00c9\2\u047c\u047d"+
		"\7\u0103\2\2\u047d\u047e\7\35\2\2\u047e\u0482\5\u00eav\2\u047f\u0480\7"+
		"\u00b3\2\2\u0480\u0482\7\35\2\2\u0481\u047c\3\2\2\2\u0481\u047f\3\2\2"+
		"\2\u0482\u04ab\3\2\2\2\u0483\u0484\t\3\2\2\u0484\u0488\7\u0117\2\2\u0485"+
		"\u0486\7\u0103\2\2\u0486\u0488\7q\2\2\u0487\u0483\3\2\2\2\u0487\u0485"+
		"\3\2\2\2\u0488\u0489\3\2\2\2\u0489\u04ab\5\u0190\u00c9\2\u048a\u048b\7"+
		"\u0103\2\2\u048b\u048c\7\u0162\2\2\u048c\u048f\5\u008cG\2\u048d\u048e"+
		"\7\u0158\2\2\u048e\u0490\5\u00eav\2\u048f\u048d\3\2\2\2\u048f\u0490\3"+
		"\2\2\2\u0490\u0499\3\2\2\2\u0491\u0492\7\u015b\2\2\u0492\u0495\5\u008c"+
		"G\2\u0493\u0494\7\u0158\2\2\u0494\u0496\5\u00eav\2\u0495\u0493\3\2\2\2"+
		"\u0495\u0496\3\2\2\2\u0496\u0498\3\2\2\2\u0497\u0491\3\2\2\2\u0498\u049b"+
		"\3\2\2\2\u0499\u0497\3\2\2\2\u0499\u049a\3\2\2\2\u049a\u049c\3\2\2\2\u049b"+
		"\u0499\3\2\2\2\u049c\u049d\7\u0163\2\2\u049d\u04ab\3\2\2\2\u049e\u049f"+
		"\7\u00fb\2\2\u049f\u04a0\7\u0162\2\2\u04a0\u04a5\5\u008cG\2\u04a1\u04a2"+
		"\7\u015b\2\2\u04a2\u04a4\5\u008cG\2\u04a3\u04a1\3\2\2\2\u04a4\u04a7\3"+
		"\2\2\2\u04a5\u04a3\3\2\2\2\u04a5\u04a6\3\2\2\2\u04a6\u04a8\3\2\2\2\u04a7"+
		"\u04a5\3\2\2\2\u04a8\u04a9\7\u0163\2\2\u04a9\u04ab\3\2\2\2\u04aa\u0477"+
		"\3\2\2\2\u04aa\u0487\3\2\2\2\u04aa\u048a\3\2\2\2\u04aa\u049e\3\2\2\2\u04ab"+
		"+\3\2\2\2\u04ac\u04ae\7\u0085\2\2\u04ad\u04ac\3\2\2\2\u04ad\u04ae\3\2"+
		"\2\2\u04ae\u04af\3\2\2\2\u04af\u04b1\7\u00c5\2\2\u04b0\u04b2\7\u00a3\2"+
		"\2\u04b1\u04b0\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2\u04b4\3\2\2\2\u04b3\u04b5"+
		"\5\u0190\u00c9\2\u04b4\u04b3\3\2\2\2\u04b4\u04b5\3\2\2\2\u04b5\u04b6\3"+
		"\2\2\2\u04b6\u04b7\7\u00e7\2\2\u04b7\u04ba\5\u0190\u00c9\2\u04b8\u04b9"+
		"\7\u0088\2\2\u04b9\u04bb\5\u0190\u00c9\2\u04ba\u04b8\3\2\2\2\u04ba\u04bb"+
		"\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc\u04be\5\u01dc\u00ef\2\u04bd\u04bf\5"+
		"\u0084C\2\u04be\u04bd\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf\u04c2\3\2\2\2"+
		"\u04c0\u04c1\7\u010f\2\2\u04c1\u04c3\5\u0190\u00c9\2\u04c2\u04c0\3\2\2"+
		"\2\u04c2\u04c3\3\2\2\2\u04c3\u04c6\3\2\2\2\u04c4\u04c5\7\u008d\2\2\u04c5"+
		"\u04c7\5\u011c\u008f\2\u04c6\u04c4\3\2\2\2\u04c6\u04c7\3\2\2\2\u04c7-"+
		"\3\2\2\2\u04c8\u04cc\7/\2\2\u04c9\u04ca\7?\2\2\u04ca\u04cb\7W\2\2\u04cb"+
		"\u04cd\7\u00b8\2\2\u04cc\u04c9\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd\u04ce"+
		"\3\2\2\2\u04ce\u04d0\5\u008cG\2\u04cf\u04d1\7\u008e\2\2\u04d0\u04cf\3"+
		"\2\2\2\u04d0\u04d1\3\2\2\2\u04d1\u04d4\3\2\2\2\u04d2\u04d3\7q\2\2\u04d3"+
		"\u04d5\5\u008cG\2\u04d4\u04d2\3\2\2\2\u04d4\u04d5\3\2\2\2\u04d5\u04d8"+
		"\3\2\2\2\u04d6\u04d7\7\u0123\2\2\u04d7\u04d9\5\u0090I\2\u04d8\u04d6\3"+
		"\2\2\2\u04d8\u04d9\3\2\2\2\u04d9\u04dc\3\2\2\2\u04da\u04db\78\2\2\u04db"+
		"\u04dd\5\u0090I\2\u04dc\u04da\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd/\3\2\2"+
		"\2\u04de\u04df\7^\2\2\u04df\u04e1\7k\2\2\u04e0\u04de\3\2\2\2\u04e0\u04e1"+
		"\3\2\2\2\u04e1\u04e3\3\2\2\2\u04e2\u04e4\7\u0080\2\2\u04e3\u04e2\3\2\2"+
		"\2\u04e3\u04e4\3\2\2\2\u04e4\u04e6\3\2\2\2\u04e5\u04e7\7f\2\2\u04e6\u04e5"+
		"\3\2\2\2\u04e6\u04e7\3\2\2\2\u04e7\u04e8\3\2\2\2\u04e8\u04e9\7\u00cf\2"+
		"\2\u04e9\u04f4\5\u008cG\2\u04ea\u04eb\7=\2\2\u04eb\u04ee\5\u0190\u00c9"+
		"\2\u04ec\u04ed\7G\2\2\u04ed\u04ef\5\u0190\u00c9\2\u04ee\u04ec\3\2\2\2"+
		"\u04ee\u04ef\3\2\2\2\u04ef\u04f2\3\2\2\2\u04f0\u04f1\7\u0089\2\2\u04f1"+
		"\u04f3\5\u0190\u00c9\2\u04f2\u04f0\3\2\2\2\u04f2\u04f3\3\2\2\2\u04f3\u04f5"+
		"\3\2\2\2\u04f4\u04ea\3\2\2\2\u04f4\u04f5\3\2\2\2\u04f5\61\3\2\2\2\u04f6"+
		"\u04f7\7\u00b6\2\2\u04f7\u04f8\7\u0081\2\2\u04f8\u04f9\5\u0190\u00c9\2"+
		"\u04f9\u04fa\7\u00e7\2\2\u04fa\u050f\5\u0190\u00c9\2\u04fb\u04fc\7\u008c"+
		"\2\2\u04fc\u050b\5\u0190\u00c9\2\u04fd\u04fe\7C\2\2\u04fe\u04ff\7\u0162"+
		"\2\2\u04ff\u0504\7\u0179\2\2\u0500\u0501\7\u015b\2\2\u0501\u0503\7\u0179"+
		"\2\2\u0502\u0500\3\2\2\2\u0503\u0506\3\2\2\2\u0504\u0502\3\2\2\2\u0504"+
		"\u0505\3\2\2\2\u0505\u0507\3\2\2\2\u0506\u0504\3\2\2\2\u0507\u0509\7\u0163"+
		"\2\2\u0508\u050a\7\t\2\2\u0509\u0508\3\2\2\2\u0509\u050a\3\2\2\2\u050a"+
		"\u050c\3\2\2\2\u050b\u04fd\3\2\2\2\u050c\u050d\3\2\2\2\u050d\u050b\3\2"+
		"\2\2\u050d\u050e\3\2\2\2\u050e\u0510\3\2\2\2\u050f\u04fb\3\2\2\2\u050f"+
		"\u0510\3\2\2\2\u0510\u0511\3\2\2\2\u0511\u0512\7.\2\2\u0512\u0513\7e\2"+
		"\2\u0513\u0514\5\u00eav\2\u0514\63\3\2\2\2\u0515\u0517\7\u0103\2\2\u0516"+
		"\u0518\t\16\2\2\u0517\u0516\3\2\2\2\u0517\u0518\3\2\2\2\u0518\u0535\3"+
		"\2\2\2\u0519\u051a\5\u008cG\2\u051a\u051b\t\17\2\2\u051b\u0520\5\66\34"+
		"\2\u051c\u051d\7\u015b\2\2\u051d\u051f\5\66\34\2\u051e\u051c\3\2\2\2\u051f"+
		"\u0522\3\2\2\2\u0520\u051e\3\2\2\2\u0520\u0521\3\2\2\2\u0521\u0536\3\2"+
		"\2\2\u0522\u0520\3\2\2\2\u0523\u0524\7\u0144\2\2\u0524\u0528\7\u0129\2"+
		"\2\u0525\u0529\5\u008cG\2\u0526\u0529\7U\2\2\u0527\u0529\7\35\2\2\u0528"+
		"\u0525\3\2\2\2\u0528\u0526\3\2\2\2\u0528\u0527\3\2\2\2\u0529\u0532\3\2"+
		"\2\2\u052a\u052e\7\u015b\2\2\u052b\u052f\5\u008cG\2\u052c\u052f\7U\2\2"+
		"\u052d\u052f\7\35\2\2\u052e\u052b\3\2\2\2\u052e\u052c\3\2\2\2\u052e\u052d"+
		"\3\2\2\2\u052f\u0531\3\2\2\2\u0530\u052a\3\2\2\2\u0531\u0534\3\2\2\2\u0532"+
		"\u0530\3\2\2\2\u0532\u0533\3\2\2\2\u0533\u0536\3\2\2\2\u0534\u0532\3\2"+
		"\2\2\u0535\u0519\3\2\2\2\u0535\u0523\3\2\2\2\u0536\65\3\2\2\2\u0537\u053e"+
		"\5\u00eav\2\u0538\u0539\7\u016c\2\2\u0539\u053a\5\u00eav\2\u053a\u053b"+
		"\7\u016c\2\2\u053b\u053e\3\2\2\2\u053c\u053e\7\35\2\2\u053d\u0537\3\2"+
		"\2\2\u053d\u0538\3\2\2\2\u053d\u053c\3\2\2\2\u053e\67\3\2\2\2\u053f\u0541"+
		"\7\26\2\2\u0540\u053f\3\2\2\2\u0540\u0541\3\2\2\2\u0541\u0542\3\2\2\2"+
		"\u0542\u0543\7\u0081\2\2\u0543\u0548\5\u008cG\2\u0544\u0549\7\16\2\2\u0545"+
		"\u0546\7L\2\2\u0546\u0549\7Y\2\2\u0547\u0549\7\5\2\2\u0548\u0544\3\2\2"+
		"\2\u0548\u0545\3\2\2\2\u0548\u0547\3\2\2\2\u0549\u055c\3\2\2\2\u054a\u0558"+
		"\t\20\2\2\u054b\u0555\7\u0086\2\2\u054c\u054d\7Y\2\2\u054d\u0552\5\u008c"+
		"G\2\u054e\u054f\7\u015b\2\2\u054f\u0551\5\u008cG\2\u0550\u054e\3\2\2\2"+
		"\u0551\u0554\3\2\2\2\u0552\u0550\3\2\2\2\u0552\u0553\3\2\2\2\u0553\u0556"+
		"\3\2\2\2\u0554\u0552\3\2\2\2\u0555\u054c\3\2\2\2\u0555\u0556\3\2\2\2\u0556"+
		"\u0558\3\2\2\2\u0557\u054a\3\2\2\2\u0557\u054b\3\2\2\2\u0558\u055a\3\2"+
		"\2\2\u0559\u055b\7^\2\2\u055a\u0559\3\2\2\2\u055a\u055b\3\2\2\2\u055b"+
		"\u055d\3\2\2\2\u055c\u0557\3\2\2\2\u055d\u055e\3\2\2\2\u055e\u055c\3\2"+
		"\2\2\u055e\u055f\3\2\2\2\u055f\u0560\3\2\2\2\u0560\u0561\7\u00e7\2\2\u0561"+
		"\u0564\5\u0190\u00c9\2\u0562\u0563\78\2\2\u0563\u0565\5\u0190\u00c9\2"+
		"\u0564\u0562\3\2\2\2\u0564\u0565\3\2\2\2\u0565\u056f\3\2\2\2\u0566\u0567"+
		"\7W\2\2\u0567\u0570\7\37\2\2\u0568\u056a\7\37\2\2\u0569\u0568\3\2\2\2"+
		"\u0569\u056a\3\2\2\2\u056a\u056b\3\2\2\2\u056b\u056c\7F\2\2\u056c\u0570"+
		"\7A\2\2\u056d\u056e\7F\2\2\u056e\u0570\7 \2\2\u056f\u0566\3\2\2\2\u056f"+
		"\u0569\3\2\2\2\u056f\u056d\3\2\2\2\u056f\u0570\3\2\2\2\u0570\u0576\3\2"+
		"\2\2\u0571\u0573\7\61\2\2\u0572\u0574\7&\2\2\u0573\u0572\3\2\2\2\u0573"+
		"\u0574\3\2\2\2\u0574\u0575\3\2\2\2\u0575\u0577\t\21\2\2\u0576\u0571\3"+
		"\2\2\2\u0576\u0577\3\2\2\2\u0577\u057a\3\2\2\2\u0578\u0579\7\u008c\2\2"+
		"\u0579\u057b\5\u011c\u008f\2\u057a\u0578\3\2\2\2\u057a\u057b\3\2\2\2\u057b"+
		"\u057c\3\2\2\2\u057c\u057d\7.\2\2\u057d\u057e\7e\2\2\u057e\u057f\5\u0190"+
		"\u00c9\2\u057f\u0581\7\u0162\2\2\u0580\u0582\5\u008cG\2\u0581\u0580\3"+
		"\2\2\2\u0581\u0582\3\2\2\2\u0582\u0587\3\2\2\2\u0583\u0584\7\u015b\2\2"+
		"\u0584\u0586\5\u008cG\2\u0585\u0583\3\2\2\2\u0586\u0589\3\2\2\2\u0587"+
		"\u0585\3\2\2\2\u0587\u0588\3\2\2\2\u0588\u058a\3\2\2\2\u0589\u0587\3\2"+
		"\2\2\u058a\u058b\7\u0163\2\2\u058b9\3\2\2\2\u058c\u06c3\7n\2\2\u058d\u058e"+
		"\7:\2\2\u058e\u058f\7\u00e9\2\2\u058f\u0591\7\61\2\2\u0590\u058d\3\2\2"+
		"\2\u0590\u0591\3\2\2\2\u0591\u06a8\3\2\2\2\u0592\u0597\t\f\2\2\u0593\u0594"+
		"\7\u015b\2\2\u0594\u0596\t\f\2\2\u0595\u0593\3\2\2\2\u0596\u0599\3\2\2"+
		"\2\u0597\u0595\3\2\2\2\u0597\u0598\3\2\2\2\u0598\u059f\3\2\2\2\u0599\u0597"+
		"\3\2\2\2\u059a\u059c\7\7\2\2\u059b\u059d\7d\2\2\u059c\u059b\3\2\2\2\u059c"+
		"\u059d\3\2\2\2\u059d\u059f\3\2\2\2\u059e\u0592\3\2\2\2\u059e\u059a\3\2"+
		"\2\2\u059f\u05a0\3\2\2\2\u05a0\u05b2\7\u00e7\2\2\u05a1\u05a3\7{\2\2\u05a2"+
		"\u05a1\3\2\2\2\u05a2\u05a3\3\2\2\2\u05a3\u05a4\3\2\2\2\u05a4\u05a6\5\u0190"+
		"\u00c9\2\u05a5\u05a2\3\2\2\2\u05a6\u05a7\3\2\2\2\u05a7\u05a5\3\2\2\2\u05a7"+
		"\u05a8\3\2\2\2\u05a8\u05b3\3\2\2\2\u05a9\u05aa\7\7\2\2\u05aa\u05ab\7\u0110"+
		"\2\2\u05ab\u05ac\7C\2\2\u05ac\u05ae\7q\2\2\u05ad\u05af\5\u008cG\2\u05ae"+
		"\u05ad\3\2\2\2\u05af\u05b0\3\2\2\2\u05b0\u05ae\3\2\2\2\u05b0\u05b1\3\2"+
		"\2\2\u05b1\u05b3\3\2\2\2\u05b2\u05a5\3\2\2\2\u05b2\u05a9\3\2\2\2\u05b3"+
		"\u05b4\3\2\2\2\u05b4\u05b5\5<\37\2\u05b5\u06a9\3\2\2\2\u05b6\u05b7\t\22"+
		"\2\2\u05b7\u05b8\7\u0162\2\2\u05b8\u05bd\5\u008cG\2\u05b9\u05ba\7\u015b"+
		"\2\2\u05ba\u05bc\5\u008cG\2\u05bb\u05b9\3\2\2\2\u05bc\u05bf\3\2\2\2\u05bd"+
		"\u05bb\3\2\2\2\u05bd\u05be\3\2\2\2\u05be\u05c0\3\2\2\2\u05bf\u05bd\3\2"+
		"\2\2\u05c0\u05c1\7\u0163\2\2\u05c1\u05c3\3\2\2\2\u05c2\u05b6\3\2\2\2\u05c3"+
		"\u05c4\3\2\2\2\u05c4\u05c2\3\2\2\2\u05c4\u05c5\3\2\2\2\u05c5\u05d6\3\2"+
		"\2\2\u05c6\u05c8\7\7\2\2\u05c7\u05c9\7d\2\2\u05c8\u05c7\3\2\2\2\u05c8"+
		"\u05c9\3\2\2\2\u05c9\u05ca\3\2\2\2\u05ca\u05cb\7\u0162\2\2\u05cb\u05d0"+
		"\5\u008cG\2\u05cc\u05cd\7\u015b\2\2\u05cd\u05cf\5\u008cG\2\u05ce\u05cc"+
		"\3\2\2\2\u05cf\u05d2\3\2\2\2\u05d0\u05ce\3\2\2\2\u05d0\u05d1\3\2\2\2\u05d1"+
		"\u05d3\3\2\2\2\u05d2\u05d0\3\2\2\2\u05d3\u05d4\7\u0163\2\2\u05d4\u05d6"+
		"\3\2\2\2\u05d5\u05c2\3\2\2\2\u05d5\u05c6\3\2\2\2\u05d6\u05d7\3\2\2\2\u05d7"+
		"\u05d9\7\u00e7\2\2\u05d8\u05da\7{\2\2\u05d9\u05d8\3\2\2\2\u05d9\u05da"+
		"\3\2\2\2\u05da\u05db\3\2\2\2\u05db\u05e0\5\u0190\u00c9\2\u05dc\u05dd\7"+
		"\u015b\2\2\u05dd\u05df\5\u0190\u00c9\2\u05de\u05dc\3\2\2\2\u05df\u05e2"+
		"\3\2\2\2\u05e0\u05de\3\2\2\2\u05e0\u05e1\3\2\2\2\u05e1\u05e3\3\2\2\2\u05e2"+
		"\u05e0\3\2\2\2\u05e3\u05e4\5<\37\2\u05e4\u06a9\3\2\2\2\u05e5\u05e7\t\r"+
		"\2\2\u05e6\u05e5\3\2\2\2\u05e7\u05e8\3\2\2\2\u05e8\u05e6\3\2\2\2\u05e8"+
		"\u05e9\3\2\2\2\u05e9\u05ef\3\2\2\2\u05ea\u05ec\7\7\2\2\u05eb\u05ed\7d"+
		"\2\2\u05ec\u05eb\3\2\2\2\u05ec\u05ed\3\2\2\2\u05ed\u05ef\3\2\2\2\u05ee"+
		"\u05e6\3\2\2\2\u05ee\u05ea\3\2\2\2\u05ef\u05f0\3\2\2\2\u05f0\u0606\7\u00e7"+
		"\2\2\u05f1\u05f2\7r\2\2\u05f2\u05f7\5\u0190\u00c9\2\u05f3\u05f4\7\u015b"+
		"\2\2\u05f4\u05f6\5\u0190\u00c9\2\u05f5\u05f3\3\2\2\2\u05f6\u05f9\3\2\2"+
		"\2\u05f7\u05f5\3\2\2\2\u05f7\u05f8\3\2\2\2\u05f8\u0607\3\2\2\2\u05f9\u05f7"+
		"\3\2\2\2\u05fa\u05fb\7\7\2\2\u05fb\u05fc\7s\2\2\u05fc\u05fd\7C\2\2\u05fd"+
		"\u05fe\7q\2\2\u05fe\u0603\5\u008cG\2\u05ff\u0600\7\u015b\2\2\u0600\u0602"+
		"\5\u008cG\2\u0601\u05ff\3\2\2\2\u0602\u0605\3\2\2\2\u0603\u0601\3\2\2"+
		"\2\u0603\u0604\3\2\2\2\u0604\u0607\3\2\2\2\u0605\u0603\3\2\2\2\u0606\u05f1"+
		"\3\2\2\2\u0606\u05fa\3\2\2\2\u0607\u0608\3\2\2\2\u0608\u0609\5<\37\2\u0609"+
		"\u06a9\3\2\2\2\u060a\u060c\t\23\2\2\u060b\u060a\3\2\2\2\u060c\u060d\3"+
		"\2\2\2\u060d\u060b\3\2\2\2\u060d\u060e\3\2\2\2\u060e\u0614\3\2\2\2\u060f"+
		"\u0611\7\7\2\2\u0610\u0612\7d\2\2\u0611\u0610\3\2\2\2\u0611\u0612\3\2"+
		"\2\2\u0612\u0614\3\2\2\2\u0613\u060b\3\2\2\2\u0613\u060f\3\2\2\2\u0614"+
		"\u0615\3\2\2\2\u0615\u0616\7\u00e7\2\2\u0616\u0617\7\34\2\2\u0617\u061c"+
		"\5\u008cG\2\u0618\u0619\7\u015b\2\2\u0619\u061b\5\u008cG\2\u061a\u0618"+
		"\3\2\2\2\u061b\u061e\3\2\2\2\u061c\u061a\3\2\2\2\u061c\u061d\3\2\2\2\u061d"+
		"\u061f\3\2\2\2\u061e\u061c\3\2\2\2\u061f\u0620\5<\37\2\u0620\u06a9\3\2"+
		"\2\2\u0621\u0627\7\u0087\2\2\u0622\u0624\7\7\2\2\u0623\u0625\7d\2\2\u0624"+
		"\u0623\3\2\2\2\u0624\u0625\3\2\2\2\u0625\u0627\3\2\2\2\u0626\u0621\3\2"+
		"\2\2\u0626\u0622\3\2\2\2\u0627\u064f\3\2\2\2\u0628\u0629\7\u00e7\2\2\u0629"+
		"\u062a\7\62\2\2\u062a\u062b\7\u00aa\2\2\u062b\u062c\7\u0127\2\2\u062c"+
		"\u0631\5\u0190\u00c9\2\u062d\u062e\7\u015b\2\2\u062e\u0630\5\u0190\u00c9"+
		"\2\u062f\u062d\3\2\2\2\u0630\u0633\3\2\2\2\u0631\u062f\3\2\2\2\u0631\u0632"+
		"\3\2\2\2\u0632\u0634\3\2\2\2\u0633\u0631\3\2\2\2\u0634\u0635\5<\37\2\u0635"+
		"\u0650\3\2\2\2\u0636\u0637\7\u00e7\2\2\u0637\u0638\7\62\2\2\u0638\u0639"+
		"\7\u0102\2\2\u0639\u063e\5\u008cG\2\u063a\u063b\7\u015b\2\2\u063b\u063d"+
		"\5\u008cG\2\u063c\u063a\3\2\2\2\u063d\u0640\3\2\2\2\u063e\u063c\3\2\2"+
		"\2\u063e\u063f\3\2\2\2\u063f\u0641\3\2\2\2\u0640\u063e\3\2\2\2\u0641\u0642"+
		"\5<\37\2\u0642\u0650\3\2\2\2\u0643\u0644\7\u00e7\2\2\u0644\u0645\7\u00cf"+
		"\2\2\u0645\u064a\5\u008cG\2\u0646\u0647\7\u015b\2\2\u0647\u0649\5\u008c"+
		"G\2\u0648\u0646\3\2\2\2\u0649\u064c\3\2\2\2\u064a\u0648\3\2\2\2\u064a"+
		"\u064b\3\2\2\2\u064b\u064d\3\2\2\2\u064c\u064a\3\2\2\2\u064d\u064e\5<"+
		"\37\2\u064e\u0650\3\2\2\2\u064f\u0628\3\2\2\2\u064f\u0636\3\2\2\2\u064f"+
		"\u0643\3\2\2\2\u0650\u06a9\3\2\2\2\u0651\u0657\7.\2\2\u0652\u0654\7\7"+
		"\2\2\u0653\u0655\7d\2\2\u0654\u0653\3\2\2\2\u0654\u0655\3\2\2\2\u0655"+
		"\u0657\3\2\2\2\u0656\u0651\3\2\2\2\u0656\u0652\3\2\2\2\u0657\u0658\3\2"+
		"\2\2\u0658\u065b\7\u00e7\2\2\u0659\u065c\5T+\2\u065a\u065c\5X-\2\u065b"+
		"\u0659\3\2\2\2\u065b\u065a\3\2\2\2\u065c\u065d\3\2\2\2\u065d\u065e\5<"+
		"\37\2\u065e\u06a9\3\2\2\2\u065f\u0665\7t\2\2\u0660\u0662\7\u0086\2\2\u0661"+
		"\u0663\7\u015b\2\2\u0662\u0661\3\2\2\2\u0662\u0663\3\2\2\2\u0663\u0665"+
		"\3\2\2\2\u0664\u065f\3\2\2\2\u0664\u0660\3\2\2\2\u0665\u0666\3\2\2\2\u0666"+
		"\u0664\3\2\2\2\u0666\u0667\3\2\2\2\u0667\u066d\3\2\2\2\u0668\u066a\7\7"+
		"\2\2\u0669\u066b\7d\2\2\u066a\u0669\3\2\2\2\u066a\u066b\3\2\2\2\u066b"+
		"\u066d\3\2\2\2\u066c\u0664\3\2\2\2\u066c\u0668\3\2\2\2\u066d\u066e\3\2"+
		"\2\2\u066e\u066f\7\u00e7\2\2\u066f\u0670\7\u00d0\2\2\u0670\u0671\7\u00e6"+
		"\2\2\u0671\u0676\5\u008cG\2\u0672\u0673\7\u015b\2\2\u0673\u0675\5\u008c"+
		"G\2\u0674\u0672\3\2\2\2\u0675\u0678\3\2\2\2\u0676\u0674\3\2\2\2\u0676"+
		"\u0677\3\2\2\2\u0677\u0679\3\2\2\2\u0678\u0676\3\2\2\2\u0679\u067a\5<"+
		"\37\2\u067a\u06a9\3\2\2\2\u067b\u067d\t\24\2\2\u067c\u067e\7\u015b\2\2"+
		"\u067d\u067c\3\2\2\2\u067d\u067e\3\2\2\2\u067e\u0680\3\2\2\2\u067f\u067b"+
		"\3\2\2\2\u0680\u0681\3\2\2\2\u0681\u067f\3\2\2\2\u0681\u0682\3\2\2\2\u0682"+
		"\u0688\3\2\2\2\u0683\u0685\7\7\2\2\u0684\u0686\7d\2\2\u0685\u0684\3\2"+
		"\2\2\u0685\u0686\3\2\2\2\u0686\u0688\3\2\2\2\u0687\u067f\3\2\2\2\u0687"+
		"\u0683\3\2\2\2\u0688\u0689\3\2\2\2\u0689\u068a\7\u00e7\2\2\u068a\u068b"+
		"\7q\2\2\u068b\u0690\5\u008cG\2\u068c\u068d\7\u015b\2\2\u068d\u068f\5\u008c"+
		"G\2\u068e\u068c\3\2\2\2\u068f\u0692\3\2\2\2\u0690\u068e\3\2\2\2\u0690"+
		"\u0691\3\2\2\2\u0691\u0693\3\2\2\2\u0692\u0690\3\2\2\2\u0693\u0694\5<"+
		"\37\2\u0694\u06a9\3\2\2\2\u0695\u069b\7\32\2\2\u0696\u0698\7\7\2\2\u0697"+
		"\u0699\7d\2\2\u0698\u0697\3\2\2\2\u0698\u0699\3\2\2\2\u0699\u069b\3\2"+
		"\2\2\u069a\u0695\3\2\2\2\u069a\u0696\3\2\2\2\u069b\u069c\3\2\2\2\u069c"+
		"\u069d\7\u00e7\2\2\u069d\u069e\7\u010f\2\2\u069e\u06a3\5\u008cG\2\u069f"+
		"\u06a0\7\u015b\2\2\u06a0\u06a2\5\u008cG\2\u06a1\u069f\3\2\2\2\u06a2\u06a5"+
		"\3\2\2\2\u06a3\u06a1\3\2\2\2\u06a3\u06a4\3\2\2\2\u06a4\u06a6\3\2\2\2\u06a5"+
		"\u06a3\3\2\2\2\u06a6\u06a7\5<\37\2\u06a7\u06a9\3\2\2\2\u06a8\u059e\3\2"+
		"\2\2\u06a8\u05d5\3\2\2\2\u06a8\u05ee\3\2\2\2\u06a8\u0613\3\2\2\2\u06a8"+
		"\u0626\3\2\2\2\u06a8\u0656\3\2\2\2\u06a8\u066c\3\2\2\2\u06a8\u0687\3\2"+
		"\2\2\u06a8\u069a\3\2\2\2\u06a9\u06c4\3\2\2\2\u06aa\u06ab\7\u0090\2\2\u06ab"+
		"\u06ac\7\u00e9\2\2\u06ac\u06ae\7\61\2\2\u06ad\u06aa\3\2\2\2\u06ad\u06ae"+
		"\3\2\2\2\u06ae\u06af\3\2\2\2\u06af\u06b4\5\u008cG\2\u06b0\u06b1\7\u015b"+
		"\2\2\u06b1\u06b3\5\u008cG\2\u06b2\u06b0\3\2\2\2\u06b3\u06b6\3\2\2\2\u06b4"+
		"\u06b2\3\2\2\2\u06b4\u06b5\3\2\2\2\u06b5\u06b7\3\2\2\2\u06b6\u06b4\3\2"+
		"\2\2\u06b7\u06b8\78\2\2\u06b8\u06bd\5\u008cG\2\u06b9\u06ba\7\u015b\2\2"+
		"\u06ba\u06bc\5\u008cG\2\u06bb\u06b9\3\2\2\2\u06bc\u06bf\3\2\2\2\u06bd"+
		"\u06bb\3\2\2\2\u06bd\u06be\3\2\2\2\u06be\u06c1\3\2\2\2\u06bf\u06bd\3\2"+
		"\2\2\u06c0\u06c2\t\4\2\2\u06c1\u06c0\3\2\2\2\u06c1\u06c2\3\2\2\2\u06c2"+
		"\u06c4\3\2\2\2\u06c3\u0590\3\2\2\2\u06c3\u06ad\3\2\2\2\u06c4;\3\2\2\2"+
		"\u06c5\u06cb\78\2\2\u06c6\u06c8\7;\2\2\u06c7\u06c6\3\2\2\2\u06c7\u06c8"+
		"\3\2\2\2\u06c8\u06c9\3\2\2\2\u06c9\u06cc\5\u008cG\2\u06ca\u06cc\7\u00f3"+
		"\2\2\u06cb\u06c7\3\2\2\2\u06cb\u06ca\3\2\2\2\u06cc\u06d7\3\2\2\2\u06cd"+
		"\u06d3\7\u015b\2\2\u06ce\u06d0\7;\2\2\u06cf\u06ce\3\2\2\2\u06cf\u06d0"+
		"\3\2\2\2\u06d0\u06d1\3\2\2\2\u06d1\u06d4\5\u008cG\2\u06d2\u06d4\7\u00f3"+
		"\2\2\u06d3\u06cf\3\2\2\2\u06d3\u06d2\3\2\2\2\u06d4\u06d6\3\2\2\2\u06d5"+
		"\u06cd\3\2\2\2\u06d6\u06d9\3\2\2\2\u06d7\u06d5\3\2\2\2\u06d7\u06d8\3\2"+
		"\2\2\u06d8\u06db\3\2\2\2\u06d9\u06d7\3\2\2\2\u06da\u06dc\t\4\2\2\u06db"+
		"\u06da\3\2\2\2\u06db\u06dc\3\2\2\2\u06dc=\3\2\2\2\u06dd\u0813\7:\2\2\u06de"+
		"\u06e3\t\f\2\2\u06df\u06e0\7\u015b\2\2\u06e0\u06e2\t\f\2\2\u06e1\u06df"+
		"\3\2\2\2\u06e2\u06e5\3\2\2\2\u06e3\u06e1\3\2\2\2\u06e3\u06e4\3\2\2\2\u06e4"+
		"\u06eb\3\2\2\2\u06e5\u06e3\3\2\2\2\u06e6\u06e8\7\7\2\2\u06e7\u06e9\7d"+
		"\2\2\u06e8\u06e7\3\2\2\2\u06e8\u06e9\3\2\2\2\u06e9\u06eb\3\2\2\2\u06ea"+
		"\u06de\3\2\2\2\u06ea\u06e6\3\2\2\2\u06eb\u06ec\3\2\2\2\u06ec\u0704\7\u00e7"+
		"\2\2\u06ed\u06ef\7{\2\2\u06ee\u06ed\3\2\2\2\u06ee\u06ef\3\2\2\2\u06ef"+
		"\u06f4\3\2\2\2\u06f0\u06f2\5\u0190\u00c9\2\u06f1\u06f3\7\u015b\2\2\u06f2"+
		"\u06f1\3\2\2\2\u06f2\u06f3\3\2\2\2\u06f3\u06f5\3\2\2\2\u06f4\u06f0\3\2"+
		"\2\2\u06f5\u06f6\3\2\2\2\u06f6\u06f4\3\2\2\2\u06f6\u06f7\3\2\2\2\u06f7"+
		"\u0705\3\2\2\2\u06f8\u06f9\7\7\2\2\u06f9\u06fa\7\u0110\2\2\u06fa\u06fb"+
		"\7C\2\2\u06fb\u0700\7q\2\2\u06fc\u06fe\5\u008cG\2\u06fd\u06ff\7\u015b"+
		"\2\2\u06fe\u06fd\3\2\2\2\u06fe\u06ff\3\2\2\2\u06ff\u0701\3\2\2\2\u0700"+
		"\u06fc\3\2\2\2\u0701\u0702\3\2\2\2\u0702\u0700\3\2\2\2\u0702\u0703\3\2"+
		"\2\2\u0703\u0705\3\2\2\2\u0704\u06ee\3\2\2\2\u0704\u06f8\3\2\2\2\u0705"+
		"\u0706\3\2\2\2\u0706\u0707\5@!\2\u0707\u0814\3\2\2\2\u0708\u0709\t\22"+
		"\2\2\u0709\u070e\5\u008cG\2\u070a\u070b\7\u015b\2\2\u070b\u070d\5\u008c"+
		"G\2\u070c\u070a\3\2\2\2\u070d\u0710\3\2\2\2\u070e\u070c\3\2\2\2\u070e"+
		"\u070f\3\2\2\2\u070f\u0712\3\2\2\2\u0710\u070e\3\2\2\2\u0711\u0708\3\2"+
		"\2\2\u0712\u0713\3\2\2\2\u0713\u0711\3\2\2\2\u0713\u0714\3\2\2\2\u0714"+
		"\u0722\3\2\2\2\u0715\u0717\7\7\2\2\u0716\u0718\7d\2\2\u0717\u0716\3\2"+
		"\2\2\u0717\u0718\3\2\2\2\u0718\u0719\3\2\2\2\u0719\u071e\5\u008cG\2\u071a"+
		"\u071b\7\u015b\2\2\u071b\u071d\5\u008cG\2\u071c\u071a\3\2\2\2\u071d\u0720"+
		"\3\2\2\2\u071e\u071c\3\2\2\2\u071e\u071f\3\2\2\2\u071f\u0722\3\2\2\2\u0720"+
		"\u071e\3\2\2\2\u0721\u0711\3\2\2\2\u0721\u0715\3\2\2\2\u0722\u0723\3\2"+
		"\2\2\u0723\u072b\7\u00e7\2\2\u0724\u0726\7{\2\2\u0725\u0724\3\2\2\2\u0725"+
		"\u0726\3\2\2\2\u0726\u0727\3\2\2\2\u0727\u0729\5\u0190\u00c9\2\u0728\u072a"+
		"\7\u015b\2\2\u0729\u0728\3\2\2\2\u0729\u072a\3\2\2\2\u072a\u072c\3\2\2"+
		"\2\u072b\u0725\3\2\2\2\u072c\u072d\3\2\2\2\u072d\u072b\3\2\2\2\u072d\u072e"+
		"\3\2\2\2\u072e\u072f\3\2\2\2\u072f\u0730\5@!\2\u0730\u0814\3\2\2\2\u0731"+
		"\u0736\t\r\2\2\u0732\u0733\7\u015b\2\2\u0733\u0735\t\r\2\2\u0734\u0732"+
		"\3\2\2\2\u0735\u0738\3\2\2\2\u0736\u0734\3\2\2\2\u0736\u0737\3\2\2\2\u0737"+
		"\u073e\3\2\2\2\u0738\u0736\3\2\2\2\u0739\u073b\7\7\2\2\u073a\u073c\7d"+
		"\2\2\u073b\u073a\3\2\2\2\u073b\u073c\3\2\2\2\u073c\u073e\3\2\2\2\u073d"+
		"\u0731\3\2\2\2\u073d\u0739\3\2\2\2\u073e\u073f\3\2\2\2\u073f\u0759\7\u00e7"+
		"\2\2\u0740\u0741\7r\2\2\u0741\u0746\5\u008cG\2\u0742\u0743\7\u015b\2\2"+
		"\u0743\u0745\5\u008cG\2\u0744\u0742\3\2\2\2\u0745\u0748\3\2\2\2\u0746"+
		"\u0744\3\2\2\2\u0746\u0747\3\2\2\2\u0747\u074a\3\2\2\2\u0748\u0746\3\2"+
		"\2\2\u0749\u0740\3\2\2\2\u074a\u074b\3\2\2\2\u074b\u0749\3\2\2\2\u074b"+
		"\u074c\3\2\2\2\u074c\u075a\3\2\2\2\u074d\u074e\7\7\2\2\u074e\u074f\7s"+
		"\2\2\u074f\u0750\7C\2\2\u0750\u0751\7q\2\2\u0751\u0756\5\u008cG\2\u0752"+
		"\u0753\7\u015b\2\2\u0753\u0755\5\u008cG\2\u0754\u0752\3\2\2\2\u0755\u0758"+
		"\3\2\2\2\u0756\u0754\3\2\2\2\u0756\u0757\3\2\2\2\u0757\u075a\3\2\2\2\u0758"+
		"\u0756\3\2\2\2\u0759\u0749\3\2\2\2\u0759\u074d\3\2\2\2\u075a\u075b\3\2"+
		"\2\2\u075b\u075c\5@!\2\u075c\u0814\3\2\2\2\u075d\u0762\t\23\2\2\u075e"+
		"\u075f\7\u015b\2\2\u075f\u0761\t\23\2\2\u0760\u075e\3\2\2\2\u0761\u0764"+
		"\3\2\2\2\u0762\u0760\3\2\2\2\u0762\u0763\3\2\2\2\u0763\u076a\3\2\2\2\u0764"+
		"\u0762\3\2\2\2\u0765\u0767\7\7\2\2\u0766\u0768\7d\2\2\u0767\u0766\3\2"+
		"\2\2\u0767\u0768\3\2\2\2\u0768\u076a\3\2\2\2\u0769\u075d\3\2\2\2\u0769"+
		"\u0765\3\2\2\2\u076a\u076b\3\2\2\2\u076b\u076c\7\u00e7\2\2\u076c\u076d"+
		"\7\34\2\2\u076d\u0772\5\u008cG\2\u076e\u076f\7\u015b\2\2\u076f\u0771\5"+
		"\u008cG\2\u0770\u076e\3\2\2\2\u0771\u0774\3\2\2\2\u0772\u0770\3\2\2\2"+
		"\u0772\u0773\3\2\2\2\u0773\u0775\3\2\2\2\u0774\u0772\3\2\2\2\u0775\u0776"+
		"\5@!\2\u0776\u0814\3\2\2\2\u0777\u077d\7\u0087\2\2\u0778\u077a\7\7\2\2"+
		"\u0779\u077b\7d\2\2\u077a\u0779\3\2\2\2\u077a\u077b\3\2\2\2\u077b\u077d"+
		"\3\2\2\2\u077c\u0777\3\2\2\2\u077c\u0778\3\2\2\2\u077d\u07a5\3\2\2\2\u077e"+
		"\u077f\7\u00e7\2\2\u077f\u0780\7\62\2\2\u0780\u0781\7\u00aa\2\2\u0781"+
		"\u0782\7\u0127\2\2\u0782\u0787\5\u008cG\2\u0783\u0784\7\u015b\2\2\u0784"+
		"\u0786\5\u008cG\2\u0785\u0783\3\2\2\2\u0786\u0789\3\2\2\2\u0787\u0785"+
		"\3\2\2\2\u0787\u0788\3\2\2\2\u0788\u078a\3\2\2\2\u0789\u0787\3\2\2\2\u078a"+
		"\u078b\5@!\2\u078b\u07a6\3\2\2\2\u078c\u078d\7\u00e7\2\2\u078d\u078e\7"+
		"\62\2\2\u078e\u078f\7\u0102\2\2\u078f\u0794\5\u008cG\2\u0790\u0791\7\u015b"+
		"\2\2\u0791\u0793\5\u008cG\2\u0792\u0790\3\2\2\2\u0793\u0796\3\2\2\2\u0794"+
		"\u0792\3\2\2\2\u0794\u0795\3\2\2\2\u0795\u0797\3\2\2\2\u0796\u0794\3\2"+
		"\2\2\u0797\u0798\5@!\2\u0798\u07a6\3\2\2\2\u0799\u079a\7\u00e7\2\2\u079a"+
		"\u079b\7\u00cf\2\2\u079b\u07a0\5\u008cG\2\u079c\u079d\7\u015b\2\2\u079d"+
		"\u079f\5\u008cG\2\u079e\u079c\3\2\2\2\u079f\u07a2\3\2\2\2\u07a0\u079e"+
		"\3\2\2\2\u07a0\u07a1\3\2\2\2\u07a1\u07a3\3\2\2\2\u07a2\u07a0\3\2\2\2\u07a3"+
		"\u07a4\5@!\2\u07a4\u07a6\3\2\2\2\u07a5\u077e\3\2\2\2\u07a5\u078c\3\2\2"+
		"\2\u07a5\u0799\3\2\2\2\u07a6\u0814\3\2\2\2\u07a7\u07ad\7.\2\2\u07a8\u07aa"+
		"\7\7\2\2\u07a9\u07ab\7d\2\2\u07aa\u07a9\3\2\2\2\u07aa\u07ab\3\2\2\2\u07ab"+
		"\u07ad\3\2\2\2\u07ac\u07a7\3\2\2\2\u07ac\u07a8\3\2\2\2\u07ad\u07ae\3\2"+
		"\2\2\u07ae\u07b1\7\u00e7\2\2\u07af\u07b2\5T+\2\u07b0\u07b2\5X-\2\u07b1"+
		"\u07af\3\2\2\2\u07b1\u07b0\3\2\2\2\u07b2\u07b3\3\2\2\2\u07b3\u07b4\5@"+
		"!\2\u07b4\u0814\3\2\2\2\u07b5\u07b7\t\25\2\2\u07b6\u07b8\7\u015b\2\2\u07b7"+
		"\u07b6\3\2\2\2\u07b7\u07b8\3\2\2\2\u07b8\u07ba\3\2\2\2\u07b9\u07b5\3\2"+
		"\2\2\u07ba\u07bb\3\2\2\2\u07bb\u07b9\3\2\2\2\u07bb\u07bc\3\2\2\2\u07bc"+
		"\u07c2\3\2\2\2\u07bd\u07bf\7\7\2\2\u07be\u07c0\7d\2\2\u07bf\u07be\3\2"+
		"\2\2\u07bf\u07c0\3\2\2\2\u07c0\u07c2\3\2\2\2\u07c1\u07b9\3\2\2\2\u07c1"+
		"\u07bd\3\2\2\2\u07c2\u07c3\3\2\2\2\u07c3";
	private static final String _serializedATNSegment1 =
		"\u07c4\7\u00e7\2\2\u07c4\u07c5\7\u00d0\2\2\u07c5\u07c6\7\u00e6\2\2\u07c6"+
		"\u07cb\5\u008cG\2\u07c7\u07c8\7\u015b\2\2\u07c8\u07ca\5\u008cG\2\u07c9"+
		"\u07c7\3\2\2\2\u07ca\u07cd\3\2\2\2\u07cb\u07c9\3\2\2\2\u07cb\u07cc\3\2"+
		"\2\2\u07cc\u07ce\3\2\2\2\u07cd\u07cb\3\2\2\2\u07ce\u07cf\5@!\2\u07cf\u0814"+
		"\3\2\2\2\u07d0\u07d2\t\24\2\2\u07d1\u07d3\7\u015b\2\2\u07d2\u07d1\3\2"+
		"\2\2\u07d2\u07d3\3\2\2\2\u07d3\u07d5\3\2\2\2\u07d4\u07d0\3\2\2\2\u07d5"+
		"\u07d6\3\2\2\2\u07d6\u07d4\3\2\2\2\u07d6\u07d7\3\2\2\2\u07d7\u07dd\3\2"+
		"\2\2\u07d8\u07da\7\7\2\2\u07d9\u07db\7d\2\2\u07da\u07d9\3\2\2\2\u07da"+
		"\u07db\3\2\2\2\u07db\u07dd\3\2\2\2\u07dc\u07d4\3\2\2\2\u07dc\u07d8\3\2"+
		"\2\2\u07dd\u07de\3\2\2\2\u07de\u07df\7\u00e7\2\2\u07df\u07e0\7q\2\2\u07e0"+
		"\u07e5\5\u008cG\2\u07e1\u07e2\7\u015b\2\2\u07e2\u07e4\5\u008cG\2\u07e3"+
		"\u07e1\3\2\2\2\u07e4\u07e7\3\2\2\2\u07e5\u07e3\3\2\2\2\u07e5\u07e6\3\2"+
		"\2\2\u07e6\u07e8\3\2\2\2\u07e7\u07e5\3\2\2\2\u07e8\u07e9\5@!\2\u07e9\u0814"+
		"\3\2\2\2\u07ea\u07f0\7\32\2\2\u07eb\u07ed\7\7\2\2\u07ec\u07ee\7d\2\2\u07ed"+
		"\u07ec\3\2\2\2\u07ed\u07ee\3\2\2\2\u07ee\u07f0\3\2\2\2\u07ef\u07ea\3\2"+
		"\2\2\u07ef\u07eb\3\2\2\2\u07f0\u07f1\3\2\2\2\u07f1\u07f2\7\u00e7\2\2\u07f2"+
		"\u07f3\7\u010f\2\2\u07f3\u07f8\5\u008cG\2\u07f4\u07f5\7\u015b\2\2\u07f5"+
		"\u07f7\5\u008cG\2\u07f6\u07f4\3\2\2\2\u07f7\u07fa\3\2\2\2\u07f8\u07f6"+
		"\3\2\2\2\u07f8\u07f9\3\2\2\2\u07f9\u07fb\3\2\2\2\u07fa\u07f8\3\2\2\2\u07fb"+
		"\u07fc\5@!\2\u07fc\u0814\3\2\2\2\u07fd\u0802\5\u008cG\2\u07fe\u07ff\7"+
		"\u015b\2\2\u07ff\u0801\5\u008cG\2\u0800\u07fe\3\2\2\2\u0801\u0804\3\2"+
		"\2\2\u0802\u0800\3\2\2\2\u0802\u0803\3\2\2\2\u0803\u0805\3\2\2\2\u0804"+
		"\u0802\3\2\2\2\u0805\u0806\7\u0117\2\2\u0806\u080b\5\u008cG\2\u0807\u0808"+
		"\7\u015b\2\2\u0808\u080a\5\u008cG\2\u0809\u0807\3\2\2\2\u080a\u080d\3"+
		"\2\2\2\u080b\u0809\3\2\2\2\u080b\u080c\3\2\2\2\u080c\u0811\3\2\2\2\u080d"+
		"\u080b\3\2\2\2\u080e\u080f\7\u008e\2\2\u080f\u0810\7\u0090\2\2\u0810\u0812"+
		"\7\u00e9\2\2\u0811\u080e\3\2\2\2\u0811\u0812\3\2\2\2\u0812\u0814\3\2\2"+
		"\2\u0813\u06ea\3\2\2\2\u0813\u0721\3\2\2\2\u0813\u073d\3\2\2\2\u0813\u0769"+
		"\3\2\2\2\u0813\u077c\3\2\2\2\u0813\u07ac\3\2\2\2\u0813\u07c1\3\2\2\2\u0813"+
		"\u07dc\3\2\2\2\u0813\u07ef\3\2\2\2\u0813\u07fd\3\2\2\2\u0814?\3\2\2\2"+
		"\u0815\u081b\7\u0117\2\2\u0816\u0818\7;\2\2\u0817\u0816\3\2\2\2\u0817"+
		"\u0818\3\2\2\2\u0818\u0819\3\2\2\2\u0819\u081c\5\u008cG\2\u081a\u081c"+
		"\7\u00f3\2\2\u081b\u0817\3\2\2\2\u081b\u081a\3\2\2\2\u081c\u0827\3\2\2"+
		"\2\u081d\u0823\7\u015b\2\2\u081e\u0820\7;\2\2\u081f\u081e\3\2\2\2\u081f"+
		"\u0820\3\2\2\2\u0820\u0821\3\2\2\2\u0821\u0824\5\u008cG\2\u0822\u0824"+
		"\7\u00f3\2\2\u0823\u081f\3\2\2\2\u0823\u0822\3\2\2\2\u0824\u0826\3\2\2"+
		"\2\u0825\u081d\3\2\2\2\u0826\u0829\3\2\2\2\u0827\u0825\3\2\2\2\u0827\u0828"+
		"\3\2\2\2\u0828\u082d\3\2\2\2\u0829\u0827\3\2\2\2\u082a\u082b\7\u008e\2"+
		"\2\u082b\u082c\7:\2\2\u082c\u082e\7\u00e9\2\2\u082d\u082a\3\2\2\2\u082d"+
		"\u082e\3\2\2\2\u082eA\3\2\2\2\u082f\u0830\7\u00a0\2\2\u0830\u086e\7\u00e7"+
		"\2\2\u0831\u0832\7\4\2\2\u0832\u0833\5\u0190\u00c9\2\u0833\u083c\7\u0162"+
		"\2\2\u0834\u0839\5\u009cO\2\u0835\u0836\7\u015b\2\2\u0836\u0838\5\u009c"+
		"O\2\u0837\u0835\3\2\2\2\u0838\u083b\3\2\2\2\u0839\u0837\3\2\2\2\u0839"+
		"\u083a\3\2\2\2\u083a\u083d\3\2\2\2\u083b\u0839\3\2\2\2\u083c\u0834\3\2"+
		"\2\2\u083c\u083d\3\2\2\2\u083d\u083e\3\2\2\2\u083e\u083f\7\u0163\2\2\u083f"+
		"\u086f\3\2\2\2\u0840\u0841\7\22\2\2\u0841\u0842\7\u0162\2\2\u0842\u0843"+
		"\5\u009cO\2\u0843\u0844\7\6\2\2\u0844\u0845\5\u009cO\2\u0845\u0846\7\u0163"+
		"\2\2\u0846\u086f\3\2\2\2\u0847\u0848\t\26\2\2\u0848\u0849\5\u0190\u00c9"+
		"\2\u0849\u084a\7\u00e7\2\2\u084a\u084b\5\u0190\u00c9\2\u084b\u086f\3\2"+
		"\2\2\u084c\u086f\5T+\2\u084d\u084e\7]\2\2\u084e\u084f\5\u0190\u00c9\2"+
		"\u084f\u0850\7\u0162\2\2\u0850\u0851\5\u009cO\2\u0851\u0852\7\u015b\2"+
		"\2\u0852\u0853\5\u009cO\2\u0853\u0854\7\u0163\2\2\u0854\u086f\3\2\2\2"+
		"\u0855\u0856\7]\2\2\u0856\u0857\t\27\2\2\u0857\u0858\5\u0190\u00c9\2\u0858"+
		"\u0859\7\u0088\2\2\u0859\u085a\5\u008cG\2\u085a\u086f\3\2\2\2\u085b\u085c"+
		"\7\u0148\2\2\u085c\u085d\7\u00ff\2\2\u085d\u086c\t\30\2\2\u085e\u0860"+
		"\7f\2\2\u085f\u085e\3\2\2\2\u085f\u0860\3\2\2\2\u0860\u0861\3\2\2\2\u0861"+
		"\u086c\7\u00cf\2\2\u0862\u0863\7\u00d0\2\2\u0863\u086c\7\u00e6\2\2\u0864"+
		"\u0868\7\62\2\2\u0865\u0866\7\u00aa\2\2\u0866\u0869\7\u0127\2\2\u0867"+
		"\u0869\7{\2\2\u0868\u0865\3\2\2\2\u0868\u0867\3\2\2\2\u0869\u086c\3\2"+
		"\2\2\u086a\u086c\t\31\2\2\u086b\u085b\3\2\2\2\u086b\u085f\3\2\2\2\u086b"+
		"\u0862\3\2\2\2\u086b\u0864\3\2\2\2\u086b\u086a\3\2\2\2\u086c\u086d\3\2"+
		"\2\2\u086d\u086f\5\u0190\u00c9\2\u086e\u0831\3\2\2\2\u086e\u0840\3\2\2"+
		"\2\u086e\u0847\3\2\2\2\u086e\u084c\3\2\2\2\u086e\u084d\3\2\2\2\u086e\u0855"+
		"\3\2\2\2\u086e\u086b\3\2\2\2\u086f\u0870\3\2\2\2\u0870\u0871\7N\2\2\u0871"+
		"\u0872\7\u0179\2\2\u0872C\3\2\2\2\u0873\u0874\7^\2\2\u0874\u0876\7k\2"+
		"\2\u0875\u0873\3\2\2\2\u0875\u0876\3\2\2\2\u0876\u0877\3\2\2\2\u0877\u0878"+
		"\7\66\2\2\u0878\u088b\5H%\2\u0879\u087c\7m\2\2\u087a\u087d\5\u00eav\2"+
		"\u087b\u087d\5\u009cO\2\u087c\u087a\3\2\2\2\u087c\u087b\3\2\2\2\u087d"+
		"\u088c\3\2\2\2\u087e\u087f\7m\2\2\u087f\u0880\7{\2\2\u0880\u0881\7\u0162"+
		"\2\2\u0881\u0886\5F$\2\u0882\u0883\7\u015b\2\2\u0883\u0885\5F$\2\u0884"+
		"\u0882\3\2\2\2\u0885\u0888\3\2\2\2\u0886\u0884\3\2\2\2\u0886\u0887\3\2"+
		"\2\2\u0887\u0889\3\2\2\2\u0888\u0886\3\2\2\2\u0889\u088a\7\u0163\2\2\u088a"+
		"\u088c\3\2\2\2\u088b\u0879\3\2\2\2\u088b\u087e\3\2\2\2\u088b\u088c\3\2"+
		"\2\2\u088c\u08be\3\2\2\2\u088d\u088e\7\u00cf\2\2\u088e\u08bf\5\u008cG"+
		"\2\u088f\u08bf\t\32\2\2\u0890\u0891\7\u0097\2\2\u0891\u0892\7\u00e7\2"+
		"\2\u0892\u0893\7X\2\2\u0893\u08bf\7\u00c8\2\2\u0894\u0895\7m\2\2\u0895"+
		"\u0896\7X\2\2\u0896\u0897\7\u00e7\2\2\u0897\u0898\7X\2\2\u0898\u08bf\7"+
		"\u00c8\2\2\u0899\u089b\7\u00ba\2\2\u089a\u0899\3\2\2\2\u089a\u089b\3\2"+
		"\2\2\u089b\u089c\3\2\2\2\u089c\u089d\7\u0101\2\2\u089d\u08bf\t\33\2\2"+
		"\u089e\u089f\7\u00a5\2\2\u089f\u08bf\7\u0172\2\2\u08a0\u08a1\7i\2\2\u08a1"+
		"\u08bf\7\u0172\2\2\u08a2\u08a3\7\u0103\2\2\u08a3\u08aa\5\u008cG\2\u08a4"+
		"\u08a5\7\u0117\2\2\u08a5\u08ab\5\u008cG\2\u08a6\u08a7\7\u0158\2\2\u08a7"+
		"\u08ab\5\u008cG\2\u08a8\u08a9\78\2\2\u08a9\u08ab\7\u00a8\2\2\u08aa\u08a4"+
		"\3\2\2\2\u08aa\u08a6\3\2\2\2\u08aa\u08a8\3\2\2\2\u08ab\u08b0\3\2\2\2\u08ac"+
		"\u08ad\7\u015b\2\2\u08ad\u08af\5\u008cG\2\u08ae\u08ac\3\2\2\2\u08af\u08b2"+
		"\3\2\2\2\u08b0\u08ae\3\2\2\2\u08b0\u08b1\3\2\2\2\u08b1\u08bf\3\2\2\2\u08b2"+
		"\u08b0\3\2\2\2\u08b3\u08b4\7\6\2\2\u08b4\u08bf\5L\'\2\u08b5\u08b6\7\6"+
		"\2\2\u08b6\u08bb\7\u0179\2\2\u08b7\u08b8\7\u015b\2\2\u08b8\u08ba\7\u0179"+
		"\2\2\u08b9\u08b7\3\2\2\2\u08ba\u08bd\3\2\2\2\u08bb\u08b9\3\2\2\2\u08bb"+
		"\u08bc\3\2\2\2\u08bc\u08bf\3\2\2\2\u08bd\u08bb\3\2\2\2\u08be\u088d\3\2"+
		"\2\2\u08be\u088f\3\2\2\2\u08be\u0890\3\2\2\2\u08be\u0894\3\2\2\2\u08be"+
		"\u089a\3\2\2\2\u08be\u089e\3\2\2\2\u08be\u08a0\3\2\2\2\u08be\u08a2\3\2"+
		"\2\2\u08be\u08b3\3\2\2\2\u08be\u08b5\3\2\2\2\u08bf\u08c0\3\2\2\2\u08c0"+
		"\u08be\3\2\2\2\u08c0\u08c1\3\2\2\2\u08c1\u08ce\3\2\2\2\u08c2\u08c3\7\u008e"+
		"\2\2\u08c3\u08c4\7\u0162\2\2\u08c4\u08c9\5P)\2\u08c5\u08c6\7\u015b\2\2"+
		"\u08c6\u08c8\5P)\2\u08c7\u08c5\3\2\2\2\u08c8\u08cb\3\2\2\2\u08c9\u08c7"+
		"\3\2\2\2\u08c9\u08ca\3\2\2\2\u08ca\u08cc\3\2\2\2\u08cb\u08c9\3\2\2\2\u08cc"+
		"\u08cd\7\u0163\2\2\u08cd\u08cf\3\2\2\2\u08ce\u08c2\3\2\2\2\u08ce\u08cf"+
		"\3\2\2\2\u08cfE\3\2\2\2\u08d0\u08d1\5\u008cG\2\u08d1\u08d2\5\u009cO\2"+
		"\u08d2G\3\2\2\2\u08d3\u08d4\5\u0190\u00c9\2\u08d4\u08e3\7\u0162\2\2\u08d5"+
		"\u08d7\5N(\2\u08d6\u08d8\5J&\2\u08d7\u08d6\3\2\2\2\u08d7\u08d8\3\2\2\2"+
		"\u08d8\u08e0\3\2\2\2\u08d9\u08da\7\u015b\2\2\u08da\u08dc\5N(\2\u08db\u08dd"+
		"\5J&\2\u08dc\u08db\3\2\2\2\u08dc\u08dd\3\2\2\2\u08dd\u08df\3\2\2\2\u08de"+
		"\u08d9\3\2\2\2\u08df\u08e2\3\2\2\2\u08e0\u08de\3\2\2\2\u08e0\u08e1\3\2"+
		"\2\2\u08e1\u08e4\3\2\2\2\u08e2\u08e0\3\2\2\2\u08e3\u08d5\3\2\2\2\u08e3"+
		"\u08e4\3\2\2\2\u08e4\u08e5\3\2\2\2\u08e5\u08e6\7\u0163\2\2\u08e6I\3\2"+
		"\2\2\u08e7\u08e8\t\34\2\2\u08e8\u08e9\5\u00eav\2\u08e9K\3\2\2\2\u08ea"+
		"\u08ec\7\u017b\2\2\u08eb\u08ed\7\u017f\2\2\u08ec\u08eb\3\2\2\2\u08ed\u08ee"+
		"\3\2\2\2\u08ee\u08ec\3\2\2\2\u08ee\u08ef\3\2\2\2\u08ef\u08f0\3\2\2\2\u08f0"+
		"\u08f1\7\u0180\2\2\u08f1M\3\2\2\2\u08f2\u08f4\5R*\2\u08f3\u08f2\3\2\2"+
		"\2\u08f3\u08f4\3\2\2\2\u08f4\u08f6\3\2\2\2\u08f5\u08f7\5\u008cG\2\u08f6"+
		"\u08f5\3\2\2\2\u08f6\u08f7\3\2\2\2\u08f7\u08fb\3\2\2\2\u08f8\u08fc\5\u009c"+
		"O\2\u08f9\u08fc\5\u00eav\2\u08fa\u08fc\5\u0190\u00c9\2\u08fb\u08f8\3\2"+
		"\2\2\u08fb\u08f9\3\2\2\2\u08fb\u08fa\3\2\2\2\u08fcO\3\2\2\2\u08fd\u08fe"+
		"\t\35\2\2\u08feQ\3\2\2\2\u08ff\u0900\t\36\2\2\u0900S\3\2\2\2\u0901\u0902"+
		"\7\66\2\2\u0902\u0903\5V,\2\u0903U\3\2\2\2\u0904\u0905\5\u0190\u00c9\2"+
		"\u0905\u090e\7\u0162\2\2\u0906\u090b\5N(\2\u0907\u0908\7\u015b\2\2\u0908"+
		"\u090a\5N(\2\u0909\u0907\3\2\2\2\u090a\u090d\3\2\2\2\u090b\u0909\3\2\2"+
		"\2\u090b\u090c\3\2\2\2\u090c\u090f\3\2\2\2\u090d\u090b\3\2\2\2\u090e\u0906"+
		"\3\2\2\2\u090e\u090f\3\2\2\2\u090f\u0910\3\2\2\2\u0910\u0911\7\u0163\2"+
		"\2\u0911W\3\2\2\2\u0912\u0913\7\7\2\2\u0913\u0914\7\67\2\2\u0914\u0915"+
		"\7C\2\2\u0915\u0916\7q\2\2\u0916\u091b\5\u008cG\2\u0917\u0918\7\u015b"+
		"\2\2\u0918\u091a\5\u008cG\2\u0919\u0917\3\2\2\2\u091a\u091d\3\2\2\2\u091b"+
		"\u0919\3\2\2\2\u091b\u091c\3\2\2\2\u091cY\3\2\2\2\u091d\u091b\3\2\2\2"+
		"\u091e\u0920\t\37\2\2\u091f\u091e\3\2\2\2\u091f\u0920\3\2\2\2\u0920\u0921"+
		"\3\2\2\2\u0921\u0922\7r\2\2\u0922\u0926\5\u0190\u00c9\2\u0923\u0925\5"+
		"\\/\2\u0924\u0923\3\2\2\2\u0925\u0928\3\2\2\2\u0926\u0924\3\2\2\2\u0926"+
		"\u0927\3\2\2\2\u0927[\3\2\2\2\u0928\u0926\3\2\2\2\u0929\u092b\7\u00c7"+
		"\2\2\u092a\u092c\7\u0095\2\2\u092b\u092a\3\2\2\2\u092b\u092c\3\2\2\2\u092c"+
		"\u092d\3\2\2\2\u092d\u094c\7\u0172\2\2\u092e\u092f\7\u00dd\2\2\u092f\u0933"+
		"\5\u00c4c\2\u0930\u0931\7\u00e1\2\2\u0931\u0933\7\u00dd\2\2\u0932\u092e"+
		"\3\2\2\2\u0932\u0930\3\2\2\2\u0933\u094c\3\2\2\2\u0934\u0935\7\u00d8\2"+
		"\2\u0935\u0939\5\u00c4c\2\u0936\u0937\7\u00e1\2\2\u0937\u0939\7\u00d8"+
		"\2\2\u0938\u0934\3\2\2\2\u0938\u0936\3\2\2\2\u0939\u094c\3\2\2\2\u093a"+
		"\u093c\7\u0107\2\2\u093b\u093d\7\u008e\2\2\u093c\u093b\3\2\2\2\u093c\u093d"+
		"\3\2\2\2\u093d\u093e\3\2\2\2\u093e\u094c\5\u00c4c\2\u093f\u0940\7\u0096"+
		"\2\2\u0940\u094c\5\u00c4c\2\u0941\u0943\7\u00e1\2\2\u0942\u0941\3\2\2"+
		"\2\u0942\u0943\3\2\2\2\u0943\u0944\3\2\2\2\u0944\u094c\7\u00a9\2\2\u0945"+
		"\u0946\7`\2\2\u0946\u0949\7\u0095\2\2\u0947\u094a\5\u0190\u00c9\2\u0948"+
		"\u094a\7\u00e2\2\2\u0949\u0947\3\2\2\2\u0949\u0948\3\2\2\2\u094a\u094c"+
		"\3\2\2\2\u094b\u0929\3\2\2\2\u094b\u0932\3\2\2\2\u094b\u0938\3\2\2\2\u094b"+
		"\u093a\3\2\2\2\u094b\u093f\3\2\2\2\u094b\u0942\3\2\2\2\u094b\u0945\3\2"+
		"\2\2\u094c]\3\2\2\2\u094d\u096d\7q\2\2\u094e\u0951\5\u008cG\2\u094f\u0950"+
		"\7\r\2\2\u0950\u0952\5\u008cG\2\u0951\u094f\3\2\2\2\u0951\u0952\3\2\2"+
		"\2\u0952\u0956\3\2\2\2\u0953\u0955\5\2\2\2\u0954\u0953\3\2\2\2\u0955\u0958"+
		"\3\2\2\2\u0956\u0954\3\2\2\2\u0956\u0957\3\2\2\2\u0957\u096e\3\2\2\2\u0958"+
		"\u0956\3\2\2\2\u0959\u095a\7\r\2\2\u095a\u095e\5\u008cG\2\u095b\u095d"+
		"\5\2\2\2\u095c\u095b\3\2\2\2\u095d\u0960\3\2\2\2\u095e\u095c\3\2\2\2\u095e"+
		"\u095f\3\2\2\2\u095f\u096e\3\2\2\2\u0960\u095e\3\2\2\2\u0961\u0962\7?"+
		"\2\2\u0962\u0963\7W\2\2\u0963\u096b\7\u00b8\2\2\u0964\u0967\5\u008cG\2"+
		"\u0965\u0966\7\r\2\2\u0966\u0968\5\u008cG\2\u0967\u0965\3\2\2\2\u0967"+
		"\u0968\3\2\2\2\u0968\u096c\3\2\2\2\u0969\u096a\7\r\2\2\u096a\u096c\5\u008c"+
		"G\2\u096b\u0964\3\2\2\2\u096b\u0969\3\2\2\2\u096c\u096e\3\2\2\2\u096d"+
		"\u094e\3\2\2\2\u096d\u0959\3\2\2\2\u096d\u0961\3\2\2\2\u096e_\3\2\2\2"+
		"\u096f\u0970\7^\2\2\u0970\u0972\7k\2\2\u0971\u096f\3\2\2\2\u0971\u0972"+
		"\3\2\2\2\u0972\u0974\3\2\2\2\u0973\u0975\t\37\2\2\u0974\u0973\3\2\2\2"+
		"\u0974\u0975\3\2\2\2\u0975\u0976\3\2\2\2\u0976\u0977\7\u008b\2\2\u0977"+
		"\u097e\5\u0190\u00c9\2\u0978\u097a\5\u008cG\2\u0979\u097b\7\u015b\2\2"+
		"\u097a\u0979\3\2\2\2\u097a\u097b\3\2\2\2\u097b\u097d\3\2\2\2\u097c\u0978"+
		"\3\2\2\2\u097d\u0980\3\2\2\2\u097e\u097c\3\2\2\2\u097e\u097f\3\2\2\2\u097f"+
		"\u098e\3\2\2\2\u0980\u097e\3\2\2\2\u0981\u0982\7\u008e\2\2\u0982\u0988"+
		"\7\u0162\2\2\u0983\u0986\5\u008cG\2\u0984\u0985\7\u0158\2\2\u0985\u0987"+
		"\5\u008cG\2\u0986\u0984\3\2\2\2\u0986\u0987\3\2\2\2\u0987\u0989\3\2\2"+
		"\2\u0988\u0983\3\2\2\2\u0989\u098a\3\2\2\2\u098a\u0988\3\2\2\2\u098a\u098b"+
		"\3\2\2\2\u098b\u098c\3\2\2\2\u098c\u098d\7\u0163\2\2\u098d\u098f\3\2\2"+
		"\2\u098e\u0981\3\2\2\2\u098e\u098f\3\2\2\2\u098f\u0990\3\2\2\2\u0990\u0991"+
		"\7\6\2\2\u0991\u0999\5\u0192\u00ca\2\u0992\u0994\7\u0084\2\2\u0993\u0995"+
		"\7\7\2\2\u0994\u0993\3\2\2\2\u0994\u0995\3\2\2\2\u0995\u0996\3\2\2\2\u0996"+
		"\u0998\5\u0192\u00ca\2\u0997\u0992\3\2\2\2\u0998\u099b\3\2\2\2\u0999\u0997"+
		"\3\2\2\2\u0999\u099a\3\2\2\2\u099aa\3\2\2\2\u099b\u0999\3\2\2\2\u099c"+
		"\u099e\t \2\2\u099d\u099c\3\2\2\2\u099d\u099e\3\2\2\2\u099e\u099f\3\2"+
		"\2\2\u099f\u09a2\t\37\2\2\u09a0\u09a2\7\u011b\2\2\u09a1\u099d\3\2\2\2"+
		"\u09a1\u09a0\3\2\2\2\u09a1\u09a2\3\2\2\2\u09a2\u09a3\3\2\2\2\u09a3\u09a7"+
		"\7{\2\2\u09a4\u09a5\7?\2\2\u09a5\u09a6\7W\2\2\u09a6\u09a8\7\u00b8\2\2"+
		"\u09a7\u09a4\3\2\2\2\u09a7\u09a8\3\2\2\2\u09a8\u09a9\3\2\2\2\u09a9\u09ef"+
		"\5\u0190\u00c9\2\u09aa\u09b3\7\u0162\2\2\u09ab\u09b0\5d\63\2\u09ac\u09ad"+
		"\7\u015b\2\2\u09ad\u09af\5d\63\2\u09ae\u09ac\3\2\2\2\u09af\u09b2\3\2\2"+
		"\2\u09b0\u09ae\3\2\2\2\u09b0\u09b1\3\2\2\2\u09b1\u09b4\3\2\2\2\u09b2\u09b0"+
		"\3\2\2\2\u09b3\u09ab\3\2\2\2\u09b3\u09b4\3\2\2\2\u09b4\u09b5\3\2\2\2\u09b5"+
		"\u09c2\7\u0163\2\2\u09b6\u09b7\7E\2\2\u09b7\u09bc\7\u0162\2\2\u09b8\u09ba"+
		"\5\u0190\u00c9\2\u09b9\u09bb\7\u015b\2\2\u09ba\u09b9\3\2\2\2\u09ba\u09bb"+
		"\3\2\2\2\u09bb\u09bd\3\2\2\2\u09bc\u09b8\3\2\2\2\u09bd\u09be\3\2\2\2\u09be"+
		"\u09bc\3\2\2\2\u09be\u09bf\3\2\2\2\u09bf\u09c0\3\2\2\2\u09c0\u09c1\7\u0163"+
		"\2\2\u09c1\u09c3\3\2\2\2\u09c2\u09b6\3\2\2\2\u09c2\u09c3\3\2\2\2\u09c3"+
		"\u09c4\3\2\2\2\u09c4\u09c5\5t;\2\u09c5\u09c6\5v<\2\u09c6\u09c7\5x=\2\u09c7"+
		"\u09f0\3\2\2\2\u09c8\u09c9\7Y\2\2\u09c9\u09e9\5\u008cG\2\u09ca\u09d5\7"+
		"\u0162\2\2\u09cb\u09cc\5\u008cG\2\u09cc\u09cd\7\u008e\2\2\u09cd\u09d1"+
		"\7\u00ea\2\2\u09ce\u09d0\5l\67\2\u09cf\u09ce\3\2\2\2\u09d0\u09d3\3\2\2"+
		"\2\u09d1\u09cf\3\2\2\2\u09d1\u09d2\3\2\2\2\u09d2\u09d6\3\2\2\2\u09d3\u09d1"+
		"\3\2\2\2\u09d4\u09d6\5j\66\2\u09d5\u09cb\3\2\2\2\u09d5\u09d4\3\2\2\2\u09d6"+
		"\u09e4\3\2\2\2\u09d7\u09d8\7\u015b\2\2\u09d8\u09d9\5\u008cG\2\u09d9\u09da"+
		"\7\u008e\2\2\u09da\u09de\7\u00ea\2\2\u09db\u09dd\5l\67\2\u09dc\u09db\3"+
		"\2\2\2\u09dd\u09e0\3\2\2\2\u09de\u09dc\3\2\2\2\u09de\u09df\3\2\2\2\u09df"+
		"\u09e3\3\2\2\2\u09e0\u09de\3\2\2\2\u09e1\u09e3\5j\66\2\u09e2\u09d7\3\2"+
		"\2\2\u09e2\u09e1\3\2\2\2\u09e3\u09e6\3\2\2\2\u09e4\u09e2\3\2\2\2\u09e4"+
		"\u09e5\3\2\2\2\u09e5\u09e7\3\2\2\2\u09e6\u09e4\3\2\2\2\u09e7\u09e8\7\u0163"+
		"\2\2\u09e8\u09ea\3\2\2\2\u09e9\u09ca\3\2\2\2\u09e9\u09ea\3\2\2\2\u09ea"+
		"\u09eb\3\2\2\2\u09eb\u09ec\5t;\2\u09ec\u09ed\5v<\2\u09ed\u09ee\5x=\2\u09ee"+
		"\u09f0\3\2\2\2\u09ef\u09aa\3\2\2\2\u09ef\u09c8\3\2\2\2\u09f0c\3\2\2\2"+
		"\u09f1\u09fc\5f\64\2\u09f2\u09fc\5j\66\2\u09f3\u09f4\7S\2\2\u09f4\u09f8"+
		"\5\u008cG\2\u09f5\u09f7\5h\65\2\u09f6\u09f5\3\2\2\2\u09f7\u09fa\3\2\2"+
		"\2\u09f8\u09f6\3\2\2\2\u09f8\u09f9\3\2\2\2\u09f9\u09fc\3\2\2\2\u09fa\u09f8"+
		"\3\2\2\2\u09fb\u09f1\3\2\2\2\u09fb\u09f2\3\2\2\2\u09fb\u09f3\3\2\2\2\u09fc"+
		"e\3\2\2\2\u09fd\u09fe\5\u008cG\2\u09fe\u0a01\5\u009cO\2\u09ff\u0a00\7"+
		"\23\2\2\u0a00\u0a02\5\u008cG\2\u0a01\u09ff\3\2\2\2\u0a01\u0a02\3\2\2\2"+
		"\u0a02\u0a06\3\2\2\2\u0a03\u0a05\5l\67\2\u0a04\u0a03\3\2\2\2\u0a05\u0a08"+
		"\3\2\2\2\u0a06\u0a04\3\2\2\2\u0a06\u0a07\3\2\2\2\u0a07g\3\2\2\2\u0a08"+
		"\u0a06\3\2\2\2\u0a09\u0a0a\t!\2\2\u0a0a\u0a0b\t\"\2\2\u0a0bi\3\2\2\2\u0a0c"+
		"\u0a0d\7\26\2\2\u0a0d\u0a0f\5\u008cG\2\u0a0e\u0a0c\3\2\2\2\u0a0e\u0a0f"+
		"\3\2\2\2\u0a0f\u0a73\3\2\2\2\u0a10\u0a74\5n8\2\u0a11\u0a12\7\u0085\2\2"+
		"\u0a12\u0a13\7\u0162\2\2\u0a13\u0a18\5\u008cG\2\u0a14\u0a15\7\u015b\2"+
		"\2\u0a15\u0a17\5\u008cG\2\u0a16\u0a14\3\2\2\2\u0a17\u0a1a\3\2\2\2\u0a18"+
		"\u0a16\3\2\2\2\u0a18\u0a19\3\2\2\2\u0a19\u0a1b\3\2\2\2\u0a1a\u0a18\3\2"+
		"\2\2\u0a1b\u0a1c\7\u0163\2\2\u0a1c\u0a1d\5|?\2\u0a1d\u0a74\3\2\2\2\u0a1e"+
		"\u0a1f\7c\2\2\u0a1f\u0a20\7P\2\2\u0a20\u0a21\7\u0162\2\2\u0a21\u0a26\5"+
		"\u008cG\2\u0a22\u0a23\7\u015b\2\2\u0a23\u0a25\5\u008cG\2\u0a24\u0a22\3"+
		"\2\2\2\u0a25\u0a28\3\2\2\2\u0a26\u0a24\3\2\2\2\u0a26\u0a27\3\2\2\2\u0a27"+
		"\u0a29\3\2\2\2\u0a28\u0a26\3\2\2\2\u0a29\u0a2a\7\u0163\2\2\u0a2a\u0a2b"+
		"\5|?\2\u0a2b\u0a74\3\2\2\2\u0a2c\u0a2f\7,\2\2\u0a2d\u0a2e\7\u0088\2\2"+
		"\u0a2e\u0a30\5\u008cG\2\u0a2f\u0a2d\3\2\2\2\u0a2f\u0a30\3\2\2\2\u0a30"+
		"\u0a31\3\2\2\2\u0a31\u0a32\7\u0162\2\2\u0a32\u0a33\5\u008cG\2\u0a33\u0a34"+
		"\7\u008e\2\2\u0a34\u0a39\5\u008cG\2\u0a35\u0a36\7\u015b\2\2\u0a36\u0a38"+
		"\5\u008cG\2\u0a37\u0a35\3\2\2\2\u0a38\u0a3b\3\2\2\2\u0a39\u0a37\3\2\2"+
		"\2\u0a39\u0a3a\3\2\2\2\u0a3a\u0a3c\3\2\2\2\u0a3b\u0a39\3\2\2\2\u0a3c\u0a3d"+
		"\7\u0163\2\2\u0a3d\u0a43\5|?\2\u0a3e\u0a3f\7\u008d\2\2\u0a3f\u0a40\7\u0162"+
		"\2\2\u0a40\u0a41\5\u008cG\2\u0a41\u0a42\7\u0163\2\2\u0a42\u0a44\3\2\2"+
		"\2\u0a43\u0a3e\3\2\2\2\u0a43\u0a44\3\2\2\2\u0a44\u0a74\3\2\2\2\u0a45\u0a46"+
		"\7\62\2\2\u0a46\u0a47\7P\2\2\u0a47\u0a48\7\u0162\2\2\u0a48\u0a4d\5\u008c"+
		"G\2\u0a49\u0a4a\7\u015b\2\2\u0a4a\u0a4c\5\u008cG\2\u0a4b\u0a49\3\2\2\2"+
		"\u0a4c\u0a4f\3\2\2\2\u0a4d\u0a4b\3\2\2\2\u0a4d\u0a4e\3\2\2\2\u0a4e\u0a50"+
		"\3\2\2\2\u0a4f\u0a4d\3\2\2\2\u0a50\u0a51\7\u0163\2\2\u0a51\u0a52\7j\2"+
		"\2\u0a52\u0a5e\5\u0190\u00c9\2\u0a53\u0a54\7\u0162\2\2\u0a54\u0a59\5\u008c"+
		"G\2\u0a55\u0a56\7\u015b\2\2\u0a56\u0a58\5\u008cG\2\u0a57\u0a55\3\2\2\2"+
		"\u0a58\u0a5b\3\2\2\2\u0a59\u0a57\3\2\2\2\u0a59\u0a5a\3\2\2\2\u0a5a\u0a5c"+
		"\3\2\2\2\u0a5b\u0a59\3\2\2\2\u0a5c\u0a5d\7\u0163\2\2\u0a5d\u0a5f\3\2\2"+
		"\2\u0a5e\u0a53\3\2\2\2\u0a5e\u0a5f\3\2\2\2\u0a5f\u0a70\3\2\2\2\u0a60\u0a61"+
		"\7\u00d6\2\2\u0a61\u0a67\7\65\2\2\u0a62\u0a63\7\u00d6\2\2\u0a63\u0a67"+
		"\7\u00ee\2\2\u0a64\u0a65\7\u00d6\2\2\u0a65\u0a67\7\u0105\2\2\u0a66\u0a60"+
		"\3\2\2\2\u0a66\u0a62\3\2\2\2\u0a66\u0a64\3\2\2\2\u0a67\u0a6f\3\2\2\2\u0a68"+
		"\u0a69\7\u00e7\2\2\u0a69\u0a6a\7!\2\2\u0a6a\u0a6f\5z>\2\u0a6b\u0a6c\7"+
		"\u00e7\2\2\u0a6c\u0a6d\7\u0086\2\2\u0a6d\u0a6f\5z>\2\u0a6e\u0a66\3\2\2"+
		"\2\u0a6e\u0a68\3\2\2\2\u0a6e\u0a6b\3\2\2\2\u0a6f\u0a72\3\2\2\2\u0a70\u0a6e"+
		"\3\2\2\2\u0a70\u0a71\3\2\2\2\u0a71\u0a74\3\2\2\2\u0a72\u0a70\3\2\2\2\u0a73"+
		"\u0a10\3\2\2\2\u0a73\u0a11\3\2\2\2\u0a73\u0a1e\3\2\2\2\u0a73\u0a2c\3\2"+
		"\2\2\u0a73\u0a45\3\2\2\2\u0a74\u0a78\3\2\2\2\u0a75\u0a79\7\37\2\2\u0a76"+
		"\u0a77\7W\2\2\u0a77\u0a79\7\37\2\2\u0a78\u0a75\3\2\2\2\u0a78\u0a76\3\2"+
		"\2\2\u0a78\u0a79\3\2\2\2\u0a79\u0a7e\3\2\2\2\u0a7a\u0a7b\7F\2\2\u0a7b"+
		"\u0a7f\7 \2\2\u0a7c\u0a7d\7F\2\2\u0a7d\u0a7f\7A\2\2\u0a7e\u0a7a\3\2\2"+
		"\2\u0a7e\u0a7c\3\2\2\2\u0a7e\u0a7f\3\2\2\2\u0a7fk\3\2\2\2\u0a80\u0a81"+
		"\7\26\2\2\u0a81\u0a83\5\u008cG\2\u0a82\u0a80\3\2\2\2\u0a82\u0a83\3\2\2"+
		"\2\u0a83\u0aa7\3\2\2\2\u0a84\u0a85\7W\2\2\u0a85\u0aa8\7X\2\2\u0a86\u0aa8"+
		"\7X\2\2\u0a87\u0aa8\5n8\2\u0a88\u0a8b\7\35\2\2\u0a89\u0a8c\5\u009cO\2"+
		"\u0a8a\u0a8c\5\u00eav\2\u0a8b\u0a89\3\2\2\2\u0a8b\u0a8a\3\2\2\2\u0a8c"+
		"\u0aa8\3\2\2\2\u0a8d\u0a8e\7\u0085\2\2\u0a8e\u0aa8\5|?\2\u0a8f\u0a90\7"+
		"c\2\2\u0a90\u0a91\7P\2\2\u0a91\u0aa8\5|?\2\u0a92\u0a93\7j\2\2\u0a93\u0a94"+
		"\5\u0190\u00c9\2\u0a94\u0a9b\5\u008cG\2\u0a95\u0a96\7\u00d6\2\2\u0a96"+
		"\u0a9c\7\65\2\2\u0a97\u0a98\7\u00d6\2\2\u0a98\u0a9c\7\u00ee\2\2\u0a99"+
		"\u0a9a\7\u00d6\2\2\u0a9a\u0a9c\7\u0105\2\2\u0a9b\u0a95\3\2\2\2\u0a9b\u0a97"+
		"\3\2\2\2\u0a9b\u0a99\3\2\2\2\u0a9b\u0a9c\3\2\2\2\u0a9c\u0aa0\3\2\2\2\u0a9d"+
		"\u0a9e\7\u00e7\2\2\u0a9e\u0a9f\7!\2\2\u0a9f\u0aa1\5z>\2\u0aa0\u0a9d\3"+
		"\2\2\2\u0aa0\u0aa1\3\2\2\2\u0aa1\u0aa5\3\2\2\2\u0aa2\u0aa3\7\u00e7\2\2"+
		"\u0aa3\u0aa4\7\u0086\2\2\u0aa4\u0aa6\5z>\2\u0aa5\u0aa2\3\2\2\2\u0aa5\u0aa6"+
		"\3\2\2\2\u0aa6\u0aa8\3\2\2\2\u0aa7\u0a84\3\2\2\2\u0aa7\u0a86\3\2\2\2\u0aa7"+
		"\u0a87\3\2\2\2\u0aa7\u0a88\3\2\2\2\u0aa7\u0a8d\3\2\2\2\u0aa7\u0a8f\3\2"+
		"\2\2\u0aa7\u0a92\3\2\2\2\u0aa8\u0aac\3\2\2\2\u0aa9\u0aad\7\37\2\2\u0aaa"+
		"\u0aab\7W\2\2\u0aab\u0aad\7\37\2\2\u0aac\u0aa9\3\2\2\2\u0aac\u0aaa\3\2"+
		"\2\2\u0aac\u0aad\3\2\2\2\u0aad\u0ab2\3\2\2\2\u0aae\u0aaf\7F\2\2\u0aaf"+
		"\u0ab3\7 \2\2\u0ab0\u0ab1\7F\2\2\u0ab1\u0ab3\7A\2\2\u0ab2\u0aae\3\2\2"+
		"\2\u0ab2\u0ab0\3\2\2\2\u0ab2\u0ab3\3\2\2\2\u0ab3m\3\2\2\2\u0ab4\u0ab6"+
		"\7\u009b\2\2\u0ab5\u0ab7\7\u0162\2\2\u0ab6\u0ab5\3\2\2\2\u0ab7\u0ab8\3"+
		"\2\2\2\u0ab8\u0ab6\3\2\2\2\u0ab8\u0ab9\3\2\2\2\u0ab9\u0aba\3\2\2\2\u0aba"+
		"\u0abc\5\u00eav\2\u0abb\u0abd\7\u0163\2\2\u0abc\u0abb\3\2\2\2\u0abd\u0abe"+
		"\3\2\2\2\u0abe\u0abc\3\2\2\2\u0abe\u0abf\3\2\2\2\u0abfo\3\2\2\2\u0ac0"+
		"\u0ac9\7\u0162\2\2\u0ac1\u0ac4\5\u008cG\2\u0ac2\u0ac3\7\u0158\2\2\u0ac3"+
		"\u0ac5\5\u00eav\2\u0ac4\u0ac2\3\2\2\2\u0ac4\u0ac5\3\2\2\2\u0ac5\u0ac7"+
		"\3\2\2\2\u0ac6\u0ac8\7\u015b\2\2\u0ac7\u0ac6\3\2\2\2\u0ac7\u0ac8\3\2\2"+
		"\2\u0ac8\u0aca\3\2\2\2\u0ac9\u0ac1\3\2\2\2\u0aca\u0acb\3\2\2\2\u0acb\u0ac9"+
		"\3\2\2\2\u0acb\u0acc\3\2\2\2\u0acc\u0acd\3\2\2\2\u0acd\u0ace\7\u0163\2"+
		"\2\u0aceq\3\2\2\2\u0acf\u0ad0\7\u008e\2\2\u0ad0\u0ad1\5p9\2\u0ad1s\3\2"+
		"\2\2\u0ad2\u0ad8\5r:\2\u0ad3\u0ad4\7\u008e\2\2\u0ad4\u0ad8\7Z\2\2\u0ad5"+
		"\u0ad6\7\u008f\2\2\u0ad6\u0ad8\7Z\2\2\u0ad7\u0ad2\3\2\2\2\u0ad7\u0ad3"+
		"\3\2\2\2\u0ad7\u0ad5\3\2\2\2\u0ad7\u0ad8\3\2\2\2\u0ad8u\3\2\2\2\u0ad9"+
		"\u0ada\7\u00e7\2\2\u0ada\u0ae0\7\u00a2\2\2\u0adb\u0adc\7b\2\2\u0adc\u0ae1"+
		"\7i\2\2\u0add\u0ade\7!\2\2\u0ade\u0ae1\7i\2\2\u0adf\u0ae1\7\u00b3\2\2"+
		"\u0ae0\u0adb\3\2\2\2\u0ae0\u0add\3\2\2\2\u0ae0\u0adf\3\2\2\2\u0ae1\u0ae3"+
		"\3\2\2\2\u0ae2\u0ad9\3\2\2\2\u0ae2\u0ae3\3\2\2\2\u0ae3w\3\2\2\2\u0ae4"+
		"\u0ae5\7\u010f\2\2\u0ae5\u0ae7\5\u008cG\2\u0ae6\u0ae4\3\2\2\2\u0ae6\u0ae7"+
		"\3\2\2\2\u0ae7y\3\2\2\2\u0ae8\u0aef\7l\2\2\u0ae9\u0aef\7\21\2\2\u0aea"+
		"\u0aeb\7\u0103\2\2\u0aeb\u0aef\7X\2\2\u0aec\u0aed\7\u0103\2\2\u0aed\u0aef"+
		"\7\35\2\2\u0aee\u0ae8\3\2\2\2\u0aee\u0ae9\3\2\2\2\u0aee\u0aea\3\2\2\2"+
		"\u0aee\u0aec\3\2\2\2\u0aef{\3\2\2\2\u0af0\u0af2\5r:\2\u0af1\u0af0\3\2"+
		"\2\2\u0af1\u0af2\3\2\2\2\u0af2\u0af7\3\2\2\2\u0af3\u0af4\7\u0088\2\2\u0af4"+
		"\u0af5\7\u00c5\2\2\u0af5\u0af6\7\u010f\2\2\u0af6\u0af8\5\u008cG\2\u0af7"+
		"\u0af3\3\2\2\2\u0af7\u0af8\3\2\2\2\u0af8}\3\2\2\2\u0af9\u0afa\7\u0162"+
		"\2\2\u0afa\u0aff\5\u0080A\2\u0afb\u0afc\7\u015b\2\2\u0afc\u0afe\5\u0080"+
		"A\2\u0afd\u0afb\3\2\2\2\u0afe\u0b01\3\2\2\2\u0aff\u0afd\3\2\2\2\u0aff"+
		"\u0b00\3\2\2\2\u0b00\u0b02\3\2\2\2\u0b01\u0aff\3\2\2\2\u0b02\u0b03\7\u0163"+
		"\2\2\u0b03\177\3\2\2\2\u0b04\u0b05\5\u008cG\2\u0b05\u0b06\5\u0082B\2\u0b06"+
		"\u0081\3\2\2\2\u0b07\u0b08\5\u009cO\2\u0b08\u0083\3\2\2\2\u0b09\u0b0a"+
		"\7\u008e\2\2\u0b0a\u0b0b\7\u0162\2\2\u0b0b\u0b10\5\u0086D\2\u0b0c\u0b0d"+
		"\7\u015b\2\2\u0b0d\u0b0f\5\u0086D\2\u0b0e\u0b0c\3\2\2\2\u0b0f\u0b12\3"+
		"\2\2\2\u0b10\u0b0e\3\2\2\2\u0b10\u0b11\3\2\2\2\u0b11\u0b13\3\2\2\2\u0b12"+
		"\u0b10\3\2\2\2\u0b13\u0b14\7\u0163\2\2\u0b14\u0085\3\2\2\2\u0b15\u0b16"+
		"\5\u008cG\2\u0b16\u0b17\7\u0158\2\2\u0b17\u0b18\5\u00f4{\2\u0b18\u0087"+
		"\3\2\2\2\u0b19\u0b1a\7\u00ef\2\2\u0b1a\u0b1b\7\u0095\2\2\u0b1b\u0b20\5"+
		"\u0190\u00c9\2\u0b1c\u0b1d\7\u015b\2\2\u0b1d\u0b1f\5\u0190\u00c9\2\u0b1e"+
		"\u0b1c\3\2\2\2\u0b1f\u0b22\3\2\2\2\u0b20\u0b1e\3\2\2\2\u0b20\u0b21\3\2"+
		"\2\2\u0b21\u0089\3\2\2\2\u0b22\u0b20\3\2\2\2\u0b23\u0b24\7\u00b3\2\2\u0b24"+
		"\u0b25\7{\2\2\u0b25\u0b27\5\u0190\u00c9\2\u0b26\u0b28\7\u00f4\2\2\u0b27"+
		"\u0b26\3\2\2\2\u0b27\u0b28\3\2\2\2\u0b28\u008b\3\2\2\2\u0b29\u0b32\t#"+
		"\2\2\u0b2a\u0b2c\7\u016d\2\2\u0b2b\u0b2a\3\2\2\2\u0b2b\u0b2c\3\2\2\2\u0b2c"+
		"\u0b2d\3\2\2\2\u0b2d\u0b2f\5\u008eH\2\u0b2e\u0b30\7\u016d\2\2\u0b2f\u0b2e"+
		"\3\2\2\2\u0b2f\u0b30\3\2\2\2\u0b30\u0b32\3\2\2\2\u0b31\u0b29\3\2\2\2\u0b31"+
		"\u0b2b\3\2\2\2\u0b32\u008d\3\2\2\2\u0b33\u0b34\t$\2\2\u0b34\u008f\3\2"+
		"\2\2\u0b35\u0b38\5\u00c2b\2\u0b36\u0b38\5\u0092J\2\u0b37\u0b35\3\2\2\2"+
		"\u0b37\u0b36\3\2\2\2\u0b38\u0091\3\2\2\2\u0b39\u0b3d\7\u0179\2\2\u0b3a"+
		"\u0b3d\5\u0094K\2\u0b3b\u0b3d\5\u0128\u0095\2\u0b3c\u0b39\3\2\2\2\u0b3c"+
		"\u0b3a\3\2\2\2\u0b3c\u0b3b\3\2\2\2\u0b3d\u0093\3\2\2\2\u0b3e\u0b42\5\u0098"+
		"M\2\u0b3f\u0b42\5\u0096L\2\u0b40\u0b42\5\u009aN\2\u0b41\u0b3e\3\2\2\2"+
		"\u0b41\u0b3f\3\2\2\2\u0b41\u0b40\3\2\2\2\u0b42\u0095\3\2\2\2\u0b43\u0b44"+
		"\7\u0144\2\2\u0b44\u0b45\7\u0179\2\2\u0b45\u0097\3\2\2\2\u0b46\u0b47\7"+
		"\u0146\2\2\u0b47\u0b48\7\u0179\2\2\u0b48\u0099\3\2\2\2\u0b49\u0b4a\7\u0143"+
		"\2\2\u0b4a\u0b4b\7\u0179\2\2\u0b4b\u009b\3\2\2\2\u0b4c\u0b4f\5\u009eP"+
		"\2\u0b4d\u0b4e\7\u016f\2\2\u0b4e\u0b50\7\u0170\2\2\u0b4f\u0b4d\3\2\2\2"+
		"\u0b4f\u0b50\3\2\2\2\u0b50\u0b54\3\2\2\2\u0b51\u0b52\7v\2\2\u0b52\u0b54"+
		"\5\u008cG\2\u0b53\u0b4c\3\2\2\2\u0b53\u0b51\3\2\2\2\u0b54\u009d\3\2\2"+
		"\2\u0b55\u0b61\5\u00a2R\2\u0b56\u0b61\5\u00a6T\2\u0b57\u0b61\5\u00a8U"+
		"\2\u0b58\u0b61\5\u00aaV\2\u0b59\u0b61\5\u00b2Z\2\u0b5a\u0b61\5\u00b4["+
		"\2\u0b5b\u0b61\5\u00b6\\\2\u0b5c\u0b61\5\u00b8]\2\u0b5d\u0b61\5\u00a0"+
		"Q\2\u0b5e\u0b61\t%\2\2\u0b5f\u0b61\5\u0190\u00c9\2\u0b60\u0b55\3\2\2\2"+
		"\u0b60\u0b56\3\2\2\2\u0b60\u0b57\3\2\2\2\u0b60\u0b58\3\2\2\2\u0b60\u0b59"+
		"\3\2\2\2\u0b60\u0b5a\3\2\2\2\u0b60\u0b5b\3\2\2\2\u0b60\u0b5c\3\2\2\2\u0b60"+
		"\u0b5d\3\2\2\2\u0b60\u0b5e\3\2\2\2\u0b60\u0b5f\3\2\2\2\u0b61\u009f\3\2"+
		"\2\2\u0b62\u0b63\7\u014e\2\2\u0b63\u00a1\3\2\2\2\u0b64\u0b66\7\u009a\2"+
		"\2\u0b65\u0b67\5\u00a4S\2\u0b66\u0b65\3\2\2\2\u0b66\u0b67\3\2\2\2\u0b67"+
		"\u0b7c\3\2\2\2\u0b68\u0b6a\7\u013f\2\2\u0b69\u0b6b\5\u00a4S\2\u0b6a\u0b69"+
		"\3\2\2\2\u0b6a\u0b6b\3\2\2\2\u0b6b\u0b7c\3\2\2\2\u0b6c\u0b6d\7\u009a\2"+
		"\2\u0b6d\u0b6f\7\u0122\2\2\u0b6e\u0b70\5\u00a4S\2\u0b6f\u0b6e\3\2\2\2"+
		"\u0b6f\u0b70\3\2\2\2\u0b70\u0b7c\3\2\2\2\u0b71\u0b72\7\u013f\2\2\u0b72"+
		"\u0b74\7\u0122\2\2\u0b73\u0b75\5\u00a4S\2\u0b74\u0b73\3\2\2\2\u0b74\u0b75"+
		"\3\2\2\2\u0b75\u0b7c\3\2\2\2\u0b76\u0b78\7\u0140\2\2\u0b77\u0b79\5\u00a4"+
		"S\2\u0b78\u0b77\3\2\2\2\u0b78\u0b79\3\2\2\2\u0b79\u0b7c\3\2\2\2\u0b7a"+
		"\u0b7c\t&\2\2\u0b7b\u0b64\3\2\2\2\u0b7b\u0b68\3\2\2\2\u0b7b\u0b6c\3\2"+
		"\2\2\u0b7b\u0b71\3\2\2\2\u0b7b\u0b76\3\2\2\2\u0b7b\u0b7a\3\2\2\2\u0b7c"+
		"\u00a3\3\2\2\2\u0b7d\u0b7e\7\u0162\2\2\u0b7e\u0b7f\7\u0172\2\2\u0b7f\u0b80"+
		"\7\u0163\2\2\u0b80\u00a5\3\2\2\2\u0b81\u0b82\7\u00e0\2\2\u0b82\u0b84\7"+
		"\u009a\2\2\u0b83\u0b85\5\u00a4S\2\u0b84\u0b83\3\2\2\2\u0b84\u0b85\3\2"+
		"\2\2\u0b85\u0ba5\3\2\2\2\u0b86\u0b87\7\u00e0\2\2\u0b87\u0b89\7\u013f\2"+
		"\2\u0b88\u0b8a\5\u00a4S\2\u0b89\u0b88\3\2\2\2\u0b89\u0b8a\3\2\2\2\u0b8a"+
		"\u0ba5\3\2\2\2\u0b8b\u0b8d\7\u0141\2\2\u0b8c\u0b8e\5\u00a4S\2\u0b8d\u0b8c"+
		"\3\2\2\2\u0b8d\u0b8e\3\2\2\2\u0b8e\u0ba5\3\2\2\2\u0b8f\u0b90\7\u00e0\2"+
		"\2\u0b90\u0b91\7\u009a\2\2\u0b91\u0b93\7\u0122\2\2\u0b92\u0b94\5\u00a4"+
		"S\2\u0b93\u0b92\3\2\2\2\u0b93\u0b94\3\2\2\2\u0b94\u0ba5\3\2\2\2\u0b95"+
		"\u0b96\7\u00e0\2\2\u0b96\u0b97\7\u013f\2\2\u0b97\u0b99\7\u0122\2\2\u0b98"+
		"\u0b9a\5\u00a4S\2\u0b99\u0b98\3\2\2\2\u0b99\u0b9a\3\2\2\2\u0b9a\u0ba5"+
		"\3\2\2\2\u0b9b\u0b9c\7\u0141\2\2\u0b9c\u0b9e\7\u0122\2\2\u0b9d\u0b9f\5"+
		"\u00a4S\2\u0b9e\u0b9d\3\2\2\2\u0b9e\u0b9f\3\2\2\2\u0b9f\u0ba5\3\2\2\2"+
		"\u0ba0\u0ba2\7\u0142\2\2\u0ba1\u0ba3\5\u00a4S\2\u0ba2\u0ba1\3\2\2\2\u0ba2"+
		"\u0ba3\3\2\2\2\u0ba3\u0ba5\3\2\2\2\u0ba4\u0b81\3\2\2\2\u0ba4\u0b86\3\2"+
		"\2\2\u0ba4\u0b8b\3\2\2\2\u0ba4\u0b8f\3\2\2\2\u0ba4\u0b95\3\2\2\2\u0ba4"+
		"\u0b9b\3\2\2\2\u0ba4\u0ba0\3\2\2\2\u0ba5\u00a7\3\2\2\2\u0ba6\u0ba8\7\u014c"+
		"\2\2\u0ba7\u0ba9\5\u00a4S\2\u0ba8\u0ba7\3\2\2\2\u0ba8\u0ba9\3\2\2\2\u0ba9"+
		"\u0baf\3\2\2\2\u0baa\u0bac\7\u014d\2\2\u0bab\u0bad\5\u00a4S\2\u0bac\u0bab"+
		"\3\2\2\2\u0bac\u0bad\3\2\2\2\u0bad\u0baf\3\2\2\2\u0bae\u0ba6\3\2\2\2\u0bae"+
		"\u0baa\3\2\2\2\u0baf\u00a9\3\2\2\2\u0bb0\u0bb3\5\u00acW\2\u0bb1\u0bb3"+
		"\5\u00aeX\2\u0bb2\u0bb0\3\2\2\2\u0bb2\u0bb1\3\2\2\2\u0bb3\u00ab\3\2\2"+
		"\2\u0bb4\u0bb6\7\u013d\2\2\u0bb5\u0bb7\5\u00b0Y\2\u0bb6\u0bb5\3\2\2\2"+
		"\u0bb6\u0bb7\3\2\2\2\u0bb7\u0bc2\3\2\2\2\u0bb8\u0bba\7\u013e\2\2\u0bb9"+
		"\u0bbb\5\u00b0Y\2\u0bba\u0bb9\3\2\2\2\u0bba\u0bbb\3\2\2\2\u0bbb\u0bc2"+
		"\3\2\2\2\u0bbc\u0bbe\7\u00ac\2\2\u0bbd\u0bbf\5\u00b0Y\2\u0bbe\u0bbd\3"+
		"\2\2\2\u0bbe\u0bbf\3\2\2\2\u0bbf\u0bc2\3\2\2\2\u0bc0\u0bc2\t\'\2\2\u0bc1"+
		"\u0bb4\3\2\2\2\u0bc1\u0bb8\3\2\2\2\u0bc1\u0bbc\3\2\2\2\u0bc1\u0bc0\3\2"+
		"\2\2\u0bc2\u00ad\3\2\2\2\u0bc3\u0bc5\7\u013b\2\2\u0bc4\u0bc6\5\u00b0Y"+
		"\2\u0bc5\u0bc4\3\2\2\2\u0bc5\u0bc6\3\2\2\2\u0bc6\u0bcd\3\2\2\2\u0bc7\u0bcd"+
		"\t(\2\2\u0bc8\u0bca\7\u013c\2\2\u0bc9\u0bcb\7\u00f2\2\2\u0bca\u0bc9\3"+
		"\2\2\2\u0bca\u0bcb\3\2\2\2\u0bcb\u0bcd\3\2\2\2\u0bcc\u0bc3\3\2\2\2\u0bcc"+
		"\u0bc7\3\2\2\2\u0bcc\u0bc8\3\2\2\2\u0bcd\u00af\3\2\2\2\u0bce\u0bcf\7\u0162"+
		"\2\2\u0bcf\u0bd0\7\u0172\2\2\u0bd0\u0bd7\7\u0163\2\2\u0bd1\u0bd2\7\u0162"+
		"\2\2\u0bd2\u0bd3\7\u0172\2\2\u0bd3\u0bd4\7\u015b\2\2\u0bd4\u0bd5\7\u0172"+
		"\2\2\u0bd5\u0bd7\7\u0163\2\2\u0bd6\u0bce\3\2\2\2\u0bd6\u0bd1\3\2\2\2\u0bd7"+
		"\u00b1\3\2\2\2\u0bd8\u0bd9\t)\2\2\u0bd9\u00b3\3\2\2\2\u0bda\u0bea\7\u0143"+
		"\2\2\u0bdb\u0bdf\7\u0144\2\2\u0bdc\u0bdd\7\u008e\2\2\u0bdd\u0bde\7\u0144"+
		"\2\2\u0bde\u0be0\7\u0129\2\2\u0bdf\u0bdc\3\2\2\2\u0bdf\u0be0\3\2\2\2\u0be0"+
		"\u0bea\3\2\2\2\u0be1\u0bea\7\u0145\2\2\u0be2\u0be6\7\u0146\2\2\u0be3\u0be4"+
		"\t*\2\2\u0be4\u0be5\7\u0144\2\2\u0be5\u0be7\7\u0129\2\2\u0be6\u0be3\3"+
		"\2\2\2\u0be6\u0be7\3\2\2\2\u0be7\u0bea\3\2\2\2\u0be8\u0bea\7\u0147\2\2"+
		"\u0be9\u0bda\3\2\2\2\u0be9\u0bdb\3\2\2\2\u0be9\u0be1\3\2\2\2\u0be9\u0be2"+
		"\3\2\2\2\u0be9\u0be8\3\2\2\2\u0bea\u00b5\3\2\2\2\u0beb\u0bed\7\u012c\2"+
		"\2\u0bec\u0bee\5\u00a4S\2\u0bed\u0bec\3\2\2\2\u0bed\u0bee\3\2\2\2\u0bee"+
		"\u0bf9\3\2\2\2\u0bef\u0bf1\7\u012d\2\2\u0bf0\u0bf2\5\u00a4S\2\u0bf1\u0bf0"+
		"\3\2\2\2\u0bf1\u0bf2\3\2\2\2\u0bf2\u0bf9\3\2\2\2\u0bf3\u0bf4\7\u012c\2"+
		"\2\u0bf4\u0bf6\7\u0122\2\2\u0bf5\u0bf7\5\u00a4S\2\u0bf6\u0bf5\3\2\2\2"+
		"\u0bf6\u0bf7\3\2\2\2\u0bf7\u0bf9\3\2\2\2\u0bf8\u0beb\3\2\2\2\u0bf8\u0bef"+
		"\3\2\2\2\u0bf8\u0bf3\3\2\2\2\u0bf9\u00b7\3\2\2\2\u0bfa\u0bfc\7\u014a\2"+
		"\2\u0bfb\u0bfd\5\u00a4S\2\u0bfc\u0bfb\3\2\2\2\u0bfc\u0bfd\3\2\2\2\u0bfd"+
		"\u0c08\3\2\2\2\u0bfe\u0bff\7\u014a\2\2\u0bff\u0c01\7\u0122\2\2\u0c00\u0c02"+
		"\5\u00a4S\2\u0c01\u0c00\3\2\2\2\u0c01\u0c02\3\2\2\2\u0c02\u0c08\3\2\2"+
		"\2\u0c03\u0c05\7\u014b\2\2\u0c04\u0c06\5\u00a4S\2\u0c05\u0c04\3\2\2\2"+
		"\u0c05\u0c06\3\2\2\2\u0c06\u0c08\3\2\2\2\u0c07\u0bfa\3\2\2\2\u0c07\u0bfe"+
		"\3\2\2\2\u0c07\u0c03\3\2\2\2\u0c08\u00b9\3\2\2\2\u0c09\u0c0c\5\u00bc_"+
		"\2\u0c0a\u0c0c\5\u00be`\2\u0c0b\u0c09\3\2\2\2\u0c0b\u0c0a\3\2\2\2\u0c0c"+
		"\u00bb\3\2\2\2\u0c0d\u0c0e\7\u0162\2\2\u0c0e\u0c0f\5\u00eav\2\u0c0f\u0c10"+
		"\7\u0163\2\2\u0c10\u00bd\3\2\2\2\u0c11\u0c1d\5\u00c0a\2\u0c12\u0c1d\5"+
		"\u019e\u00d0\2\u0c13\u0c1d\5\u00c6d\2\u0c14\u0c1d\5\u01a6\u00d4\2\u0c15"+
		"\u0c1d\5\u00d2j\2\u0c16\u0c1d\5\u00e4s\2\u0c17\u0c1d\5V,\2\u0c18\u0c1d"+
		"\7X\2\2\u0c19\u0c1d\5\u0192\u00ca\2\u0c1a\u0c1d\5\u00eex\2\u0c1b\u0c1d"+
		"\5\u00d4k\2\u0c1c\u0c11\3\2\2\2\u0c1c\u0c12\3\2\2\2\u0c1c\u0c13\3\2\2"+
		"\2\u0c1c\u0c14\3\2\2\2\u0c1c\u0c15\3\2\2\2\u0c1c\u0c16\3\2\2\2\u0c1c\u0c17"+
		"\3\2\2\2\u0c1c\u0c18\3\2\2\2\u0c1c\u0c19\3\2\2\2\u0c1c\u0c1a\3\2\2\2\u0c1c"+
		"\u0c1b\3\2\2\2\u0c1d\u00bf\3\2\2\2\u0c1e\u0c1f\5\u0090I\2\u0c1f\u00c1"+
		"\3\2\2\2\u0c20\u0c21\t+\2\2\u0c21\u00c3\3\2\2\2\u0c22\u0c24\5\u0100\u0081"+
		"\2\u0c23\u0c22\3\2\2\2\u0c23\u0c24\3\2\2\2\u0c24\u0c25\3\2\2\2\u0c25\u0c26"+
		"\5\u00c2b\2\u0c26\u00c5\3\2\2\2\u0c27\u0c28\5\u00c8e\2\u0c28\u00c7\3\2"+
		"\2\2\u0c29\u0c2a\7\u00a6\2\2\u0c2a\u0c2b\7\u0162\2\2\u0c2b\u0c2c\7\u0166"+
		"\2\2\u0c2c\u0c32\7\u0163\2\2\u0c2d\u0c2f\5\u00caf\2\u0c2e\u0c30\5\u00ce"+
		"h\2\u0c2f\u0c2e\3\2\2\2\u0c2f\u0c30\3\2\2\2\u0c30\u0c32\3\2\2\2\u0c31"+
		"\u0c29\3\2\2\2\u0c31\u0c2d\3\2\2\2\u0c32\u00c9\3\2\2\2\u0c33\u0c34\5\u00cc"+
		"g\2\u0c34\u0c36\7\u0162\2\2\u0c35\u0c37\5\u019c\u00cf\2\u0c36\u0c35\3"+
		"\2\2\2\u0c36\u0c37\3\2\2\2\u0c37\u0c38\3\2\2\2\u0c38\u0c39\5\u00eav\2"+
		"\u0c39\u0c3a\7\u0163\2\2\u0c3a\u00cb\3\2\2\2\u0c3b\u0c3c\t,\2\2\u0c3c"+
		"\u00cd\3\2\2\2\u0c3d\u0c3e\7\u00bd\2\2\u0c3e\u0c3f\7\u0162\2\2\u0c3f\u0c40"+
		"\5\u0164\u00b3\2\u0c40\u0c41\7\u0163\2\2\u0c41\u00cf\3\2\2\2\u0c42\u0c43"+
		"\7\u00c1\2\2\u0c43\u0c44\7\u0162\2\2\u0c44\u0c45\5\u01a4\u00d3\2\u0c45"+
		"\u0c46\7\u0163\2\2\u0c46\u00d1\3\2\2\2\u0c47\u0c48\5\u00d6l\2\u0c48\u00d3"+
		"\3\2\2\2\u0c49\u0c4a\7\u00e3\2\2\u0c4a\u0c4b\7\u0162\2\2\u0c4b\u0c4c\5"+
		"\u00f4{\2\u0c4c\u0c4d\7\u015b\2\2\u0c4d\u0c4e\5\u00eav\2\u0c4e\u0c4f\7"+
		"\u0163\2\2\u0c4f\u0c5c\3\2\2\2\u0c50\u0c51\7\u009e\2\2\u0c51\u0c52\7\u0162"+
		"\2\2\u0c52\u0c55\5\u00f4{\2\u0c53\u0c54\7\u015b\2\2\u0c54\u0c56\5\u00ea"+
		"v\2\u0c55\u0c53\3\2\2\2\u0c56\u0c57\3\2\2\2\u0c57\u0c55\3\2\2\2\u0c57"+
		"\u0c58\3\2\2\2\u0c58\u0c59\3\2\2\2\u0c59\u0c5a\7\u0163\2\2\u0c5a\u0c5c"+
		"\3\2\2\2\u0c5b\u0c49\3\2\2\2\u0c5b\u0c50\3\2\2\2\u0c5c\u00d5\3\2\2\2\u0c5d"+
		"\u0c60\5\u00d8m\2\u0c5e\u0c60\5\u00dan\2\u0c5f\u0c5d\3\2\2\2\u0c5f\u0c5e"+
		"\3\2\2\2\u0c60\u00d7\3\2\2\2\u0c61\u0c62\7\20\2\2\u0c62\u0c64\5\u00ea"+
		"v\2\u0c63\u0c65\5\u00dco\2\u0c64\u0c63\3\2\2\2\u0c65\u0c66\3\2\2\2\u0c66"+
		"\u0c64\3\2\2\2\u0c66\u0c67\3\2\2\2\u0c67\u0c69\3\2\2\2\u0c68\u0c6a\5\u00e0"+
		"q\2\u0c69\u0c68\3\2\2\2\u0c69\u0c6a\3\2\2\2\u0c6a\u0c6b\3\2\2\2\u0c6b"+
		"\u0c6c\7(\2\2\u0c6c\u00d9\3\2\2\2\u0c6d\u0c6f\7\20\2\2\u0c6e\u0c70\5\u00de"+
		"p\2\u0c6f\u0c6e\3\2\2\2\u0c70\u0c71\3\2\2\2\u0c71\u0c6f\3\2\2\2\u0c71"+
		"\u0c72\3\2\2\2\u0c72\u0c74\3\2\2\2\u0c73\u0c75\5\u00e0q\2\u0c74\u0c73"+
		"\3\2\2\2\u0c74\u0c75\3\2\2\2\u0c75\u0c76\3\2\2\2\u0c76\u0c77\7(\2\2\u0c77"+
		"\u00db\3\2\2\2\u0c78\u0c79\7\u008c\2\2\u0c79\u0c7a\5\u0166\u00b4\2\u0c7a"+
		"\u0c7b\7~\2\2\u0c7b\u0c7c\5\u00e2r\2\u0c7c\u00dd\3\2\2\2\u0c7d\u0c7e\7"+
		"\u008c\2\2\u0c7e\u0c7f\5\u0166\u00b4\2\u0c7f\u0c80\7~\2\2\u0c80\u0c81"+
		"\5\u00e2r\2\u0c81\u00df\3\2\2\2\u0c82\u0c83\7\'\2\2\u0c83\u0c84\5\u00e2"+
		"r\2\u0c84\u00e1\3\2\2\2\u0c85\u0c88\5\u00eav\2\u0c86\u0c88\7X\2\2\u0c87"+
		"\u0c85\3\2\2\2\u0c87\u0c86\3\2\2\2\u0c88\u00e3\3\2\2\2\u0c89\u0c8a\7\22"+
		"\2\2\u0c8a\u0c8b\7\u0162\2\2\u0c8b\u0c8c\5\u00e6t\2\u0c8c\u0c8d\7\6\2"+
		"\2\u0c8d\u0c8e\5\u00e8u\2\u0c8e\u0c8f\7\u0163\2\2\u0c8f\u00e5\3\2\2\2"+
		"\u0c90\u0c91\5\u00eav\2\u0c91\u00e7\3\2\2\2\u0c92\u0c93\5\u009cO\2\u0c93"+
		"\u00e9\3\2\2\2\u0c94\u0c99\5\u00f2z\2\u0c95\u0c99\5\u0130\u0099\2\u0c96"+
		"\u0c99\5\u011c\u008f\2\u0c97\u0c99\5\u00ecw\2\u0c98\u0c94\3\2\2\2\u0c98"+
		"\u0c95\3\2\2\2\u0c98\u0c96\3\2\2\2\u0c98\u0c97\3\2\2\2\u0c99\u00eb\3\2"+
		"\2\2\u0c9a\u0c9b\7\u0092\2\2\u0c9b\u0c9c\7\u016f\2\2\u0c9c\u0ca1\5\u00ea"+
		"v\2\u0c9d\u0c9e\7\u015b\2\2\u0c9e\u0ca0\5\u00eav\2\u0c9f\u0c9d\3\2\2\2"+
		"\u0ca0\u0ca3\3\2\2\2\u0ca1\u0c9f\3\2\2\2\u0ca1\u0ca2\3\2\2\2\u0ca2\u0ca4"+
		"\3\2\2\2\u0ca3\u0ca1\3\2\2\2\u0ca4\u0ca5\7\u0170\2\2\u0ca5\u00ed\3\2\2"+
		"\2\u0ca6\u0ca7\7\7\2\2\u0ca7\u0ca8\7\u0162\2\2\u0ca8\u0ca9\5\u00ecw\2"+
		"\u0ca9\u0caa\7\u0163\2\2\u0caa\u00ef\3\2\2\2\u0cab\u0cac\5\u010e\u0088"+
		"\2\u0cac\u0cad\7\u0171\2\2\u0cad\u0cae\5\u010e\u0088\2\u0cae\u00f1\3\2"+
		"\2\2\u0caf\u0cb4\5\u00f4{\2\u0cb0\u0cb4\5\u010c\u0087\2\u0cb1\u0cb4\5"+
		"\u00f0y\2\u0cb2\u0cb4\7X\2\2\u0cb3\u0caf\3\2\2\2\u0cb3\u0cb0\3\2\2\2\u0cb3"+
		"\u0cb1\3\2\2\2\u0cb3\u0cb2\3\2\2\2\u0cb4\u00f3\3\2\2\2\u0cb5\u0cba\5\u00f6"+
		"|\2\u0cb6\u0cb7\t-\2\2\u0cb7\u0cb9\5\u00f6|\2\u0cb8\u0cb6\3\2\2\2\u0cb9"+
		"\u0cbc\3\2\2\2\u0cba\u0cb8\3\2\2\2\u0cba\u0cbb\3\2\2\2\u0cbb\u00f5\3\2"+
		"\2\2\u0cbc\u0cba\3\2\2\2\u0cbd\u0cc2\5\u00f8}\2\u0cbe\u0cbf\t.\2\2\u0cbf"+
		"\u0cc1\5\u00f8}\2\u0cc0\u0cbe\3\2\2\2\u0cc1\u0cc4\3\2\2\2\u0cc2\u0cc0"+
		"\3\2\2\2\u0cc2\u0cc3\3\2\2\2\u0cc3\u00f7\3\2\2\2\u0cc4\u0cc2\3\2\2\2\u0cc5"+
		"\u0cc7\5\u0100\u0081\2\u0cc6\u0cc5\3\2\2\2\u0cc6\u0cc7\3\2\2\2\u0cc7\u0cc8"+
		"\3\2\2\2\u0cc8\u0cc9\5\u00fc\177\2\u0cc9\u00f9\3\2\2\2\u0cca\u0ccb\7\u0162"+
		"\2\2\u0ccb\u0cd0\5\u00f4{\2\u0ccc\u0ccd\7\u015b\2\2\u0ccd\u0ccf\5\u00f4"+
		"{\2\u0cce\u0ccc\3\2\2\2\u0ccf\u0cd2\3\2\2\2\u0cd0\u0cce\3\2\2\2\u0cd0"+
		"\u0cd1\3\2\2\2\u0cd1\u0cd3\3\2\2\2\u0cd2\u0cd0\3\2\2\2\u0cd3\u0cd4\7\u0163"+
		"\2\2\u0cd4\u00fb\3\2\2\2\u0cd5\u0cd8\5\u00fe\u0080\2\u0cd6\u0cd8\5\u0102"+
		"\u0082\2\u0cd7\u0cd5\3\2\2\2\u0cd7\u0cd6\3\2\2\2\u0cd8\u00fd\3\2\2\2\u0cd9"+
		"\u0cde\5\u00ba^\2\u0cda\u0cdb\7\u0156\2\2\u0cdb\u0cdd\5\u00e8u\2\u0cdc"+
		"\u0cda\3\2\2\2\u0cdd\u0ce0\3\2\2\2\u0cde\u0cdc\3\2\2\2\u0cde\u0cdf\3\2"+
		"\2\2\u0cdf\u00ff\3\2\2\2\u0ce0\u0cde\3\2\2\2\u0ce1\u0ce2\t-\2\2\u0ce2"+
		"\u0101\3\2\2\2\u0ce3\u0ce4\5\u0104\u0083\2\u0ce4\u0103\3\2\2\2\u0ce5\u0ce6"+
		"\7\u00bb\2\2\u0ce6\u0ce7\7\u0162\2\2\u0ce7\u0ce8\5\u0106\u0084\2\u0ce8"+
		"\u0ce9\78\2\2\u0ce9\u0cea\5\u010a\u0086\2\u0cea\u0ceb\7\u0163\2\2\u0ceb"+
		"\u0105\3\2\2\2\u0cec\u0cf0\5\u01d4\u00eb\2\u0ced\u0cf0\5\u0108\u0085\2"+
		"\u0cee\u0cf0\5\u01d8\u00ed\2\u0cef\u0cec\3\2\2\2\u0cef\u0ced\3\2\2\2\u0cef"+
		"\u0cee\3\2\2\2\u0cf0\u0107\3\2\2\2\u0cf1\u0cf2\t/\2\2\u0cf2\u0109\3\2"+
		"\2\2\u0cf3\u0cf6\5\u019e\u00d0\2\u0cf4\u0cf6\5\u0094K\2\u0cf5\u0cf3\3"+
		"\2\2\2\u0cf5\u0cf4\3\2\2\2\u0cf6\u010b\3\2\2\2\u0cf7\u0cf8\5\u010e\u0088"+
		"\2\u0cf8\u010d\3\2\2\2\u0cf9\u0cfe\5\u0110\u0089\2\u0cfa\u0cfb\7\u015c"+
		"\2\2\u0cfb\u0cfd\5\u0110\u0089\2\u0cfc\u0cfa\3\2\2\2\u0cfd\u0d00\3\2\2"+
		"\2\u0cfe\u0cfc\3\2\2\2\u0cfe\u0cff\3\2\2\2\u0cff\u0d06\3\2\2\2\u0d00\u0cfe"+
		"\3\2\2\2\u0d01\u0d02\7\u0162\2\2\u0d02\u0d03\5\u010e\u0088\2\u0d03\u0d04"+
		"\7\u0163\2\2\u0d04\u0d06\3\2\2\2\u0d05\u0cf9\3\2\2\2\u0d05\u0d01\3\2\2"+
		"\2\u0d06\u010f\3\2\2\2\u0d07\u0d08\5\u0112\u008a\2\u0d08\u0111\3\2\2\2"+
		"\u0d09\u0d0c\5\u00fe\u0080\2\u0d0a\u0d0c\5\u0114\u008b\2\u0d0b\u0d09\3"+
		"\2\2\2\u0d0b\u0d0a\3\2\2\2\u0d0c\u0113\3\2\2\2\u0d0d\u0d0e\5\u0116\u008c"+
		"\2\u0d0e\u0115\3\2\2\2\u0d0f\u0d10\7\u0116\2\2\u0d10\u0d11\7\u0162\2\2"+
		"\u0d11\u0d12\5\u0118\u008d\2\u0d12\u0d13\7\u0163\2\2\u0d13\u0117\3\2\2"+
		"\2\u0d14\u0d16\5\u011a\u008e\2\u0d15\u0d14\3\2\2\2\u0d15\u0d16\3\2\2\2"+
		"\u0d16\u0d18\3\2\2\2\u0d17\u0d19\5\u010e\u0088\2\u0d18\u0d17\3\2\2\2\u0d18"+
		"\u0d19\3\2\2\2\u0d19\u0d1a\3\2\2\2\u0d1a\u0d1c\78\2\2\u0d1b\u0d15\3\2"+
		"\2\2\u0d1b\u0d1c\3\2\2\2\u0d1c\u0d1d\3\2\2\2\u0d1d\u0d23\5\u010e\u0088"+
		"\2\u0d1e\u0d1f\5\u010e\u0088\2\u0d1f\u0d20\7\u015b\2\2\u0d20\u0d21\5\u010e"+
		"\u0088\2\u0d21\u0d23\3\2\2\2\u0d22\u0d1b\3\2\2\2\u0d22\u0d1e\3\2\2\2\u0d23"+
		"\u0119\3\2\2\2\u0d24\u0d25\t\60\2\2\u0d25\u011b\3\2\2\2\u0d26\u0d27\5"+
		"\u011e\u0090\2\u0d27\u011d\3\2\2\2\u0d28\u0d2d\5\u0120\u0091\2\u0d29\u0d2a"+
		"\7^\2\2\u0d2a\u0d2c\5\u011e\u0090\2\u0d2b\u0d29\3\2\2\2\u0d2c\u0d2f\3"+
		"\2\2\2\u0d2d\u0d2b\3\2\2\2\u0d2d\u0d2e\3\2\2\2\u0d2e\u011f\3\2\2\2\u0d2f"+
		"\u0d2d\3\2\2\2\u0d30\u0d35\5\u0122\u0092\2\u0d31\u0d32\7\t\2\2\u0d32\u0d34"+
		"\5\u0120\u0091\2\u0d33\u0d31\3\2\2\2\u0d34\u0d37\3\2\2\2\u0d35\u0d33\3"+
		"\2\2\2\u0d35\u0d36\3\2\2\2\u0d36\u0121\3\2\2\2\u0d37\u0d35\3\2\2\2\u0d38"+
		"\u0d3c\5\u0124\u0093\2\u0d39\u0d3a\7W\2\2\u0d3a\u0d3c\5\u0124\u0093\2"+
		"\u0d3b\u0d38\3\2\2\2\u0d3b\u0d39\3\2\2\2\u0d3c\u0123\3\2\2\2\u0d3d\u0d3f"+
		"\5\u012a\u0096\2\u0d3e\u0d40\5\u0126\u0094\2\u0d3f\u0d3e\3\2\2\2\u0d3f"+
		"\u0d40\3\2\2\2\u0d40\u0125\3\2\2\2\u0d41\u0d43\7N\2\2\u0d42\u0d44\7W\2"+
		"\2\u0d43\u0d42\3\2\2\2\u0d43\u0d44\3\2\2\2\u0d44\u0d45\3\2\2\2\u0d45\u0d46"+
		"\5\u0128\u0095\2\u0d46\u0127\3\2\2\2\u0d47\u0d48\t\61\2\2\u0d48\u0129"+
		"\3\2\2\2\u0d49\u0d4c\5\u01ae\u00d8\2\u0d4a\u0d4c\5\u012c\u0097\2\u0d4b"+
		"\u0d49\3\2\2\2\u0d4b\u0d4a\3\2\2\2\u0d4c\u012b\3\2\2\2\u0d4d\u0d50\5\u012e"+
		"\u0098\2\u0d4e\u0d50\5\u00be`\2\u0d4f\u0d4d\3\2\2\2\u0d4f\u0d4e\3\2\2"+
		"\2\u0d50\u012d\3\2\2\2\u0d51\u0d52\7\u0162\2\2\u0d52\u0d53\5\u011c\u008f"+
		"\2\u0d53\u0d54\7\u0163\2\2\u0d54\u012f\3\2\2\2\u0d55\u0d58\5\u0132\u009a"+
		"\2\u0d56\u0d58\5\u0134\u009b\2\u0d57\u0d55\3\2\2\2\u0d57\u0d56\3\2\2\2"+
		"\u0d58\u0131\3\2\2\2\u0d59\u0d5a\5\u00be`\2\u0d5a\u0133\3\2\2\2\u0d5b"+
		"\u0d5c\7X\2\2\u0d5c\u0135\3\2\2\2\u0d5d\u0d60\5\u0132\u009a\2\u0d5e\u0d60"+
		"\5\u0138\u009d\2\u0d5f\u0d5d\3\2\2\2\u0d5f\u0d5e\3\2\2\2\u0d60\u0137\3"+
		"\2\2\2\u0d61\u0d64\5\u00f2z\2\u0d62\u0d64\5\u012c\u0097\2\u0d63\u0d61"+
		"\3\2\2\2\u0d63\u0d62\3\2\2\2\u0d64\u0139\3\2\2\2\u0d65\u0d67\5\u013c\u009f"+
		"\2\u0d66\u0d68\5\u0164\u00b3\2\u0d67\u0d66\3\2\2\2\u0d67\u0d68\3\2\2\2"+
		"\u0d68\u0d6a\3\2\2\2\u0d69\u0d6b\5\u0168\u00b5\2\u0d6a\u0d69\3\2\2\2\u0d6a"+
		"\u0d6b\3\2\2\2\u0d6b\u0d6d\3\2\2\2\u0d6c\u0d6e\5\u0178\u00bd\2\u0d6d\u0d6c"+
		"\3\2\2\2\u0d6d\u0d6e\3\2\2\2\u0d6e\u0d70\3\2\2\2\u0d6f\u0d71\5\u01da\u00ee"+
		"\2\u0d70\u0d6f\3\2\2\2\u0d70\u0d71\3\2\2\2\u0d71\u0d73\3\2\2\2\u0d72\u0d74"+
		"\5\u01e4\u00f3\2\u0d73\u0d72\3\2\2\2\u0d73\u0d74\3\2\2\2\u0d74\u013b\3"+
		"\2\2\2\u0d75\u0d77\78\2\2\u0d76\u0d78\7\u0162\2\2\u0d77\u0d76\3\2\2\2"+
		"\u0d77\u0d78\3\2\2\2\u0d78\u0d7b\3\2\2\2\u0d79\u0d7c\5\u013e\u00a0\2\u0d7a"+
		"\u0d7c\5\u0192\u00ca\2\u0d7b\u0d79\3\2\2\2\u0d7b\u0d7a\3\2\2\2\u0d7c\u0d7e"+
		"\3\2\2\2\u0d7d\u0d7f\7\u0163\2\2\u0d7e\u0d7d\3\2\2\2\u0d7e\u0d7f\3\2\2"+
		"\2\u0d7f\u0d81\3\2\2\2\u0d80\u0d82\5\u01a0\u00d1\2\u0d81\u0d80\3\2\2\2"+
		"\u0d81\u0d82\3\2\2\2\u0d82\u013d\3\2\2\2\u0d83\u0d88\5\u0140\u00a1\2\u0d84"+
		"\u0d85\7\u015b\2\2\u0d85\u0d87\5\u0140\u00a1\2\u0d86\u0d84\3\2\2\2\u0d87"+
		"\u0d8a\3\2\2\2\u0d88\u0d86\3\2\2\2\u0d88\u0d89\3\2\2\2\u0d89\u013f\3\2"+
		"\2\2\u0d8a\u0d88\3\2\2\2\u0d8b\u0d8e\5\u0142\u00a2\2\u0d8c\u0d8e\5\u015a"+
		"\u00ae\2\u0d8d\u0d8b\3\2\2\2\u0d8d\u0d8c\3\2\2\2\u0d8e\u0141\3\2\2\2\u0d8f"+
		"\u0d91\5\u015a\u00ae\2\u0d90\u0d92\5\u0144\u00a3\2\u0d91\u0d90\3\2\2\2"+
		"\u0d92\u0d93\3\2\2\2\u0d93\u0d91\3\2\2\2\u0d93\u0d94\3\2\2\2\u0d94\u0143"+
		"\3\2\2\2\u0d95\u0d96\7\33\2\2\u0d96\u0d97\7O\2\2\u0d97\u0da9\5\u015a\u00ae"+
		"\2\u0d98\u0d9a\5\u014e\u00a8\2\u0d99\u0d98\3\2\2\2\u0d99\u0d9a\3\2\2\2"+
		"\u0d9a\u0d9b\3\2\2\2\u0d9b\u0d9c\7O\2\2\u0d9c\u0d9d\5\u015a\u00ae\2\u0d9d"+
		"\u0d9e\5\u0154\u00ab\2\u0d9e\u0da9\3\2\2\2\u0d9f\u0da1\7V\2\2\u0da0\u0da2"+
		"\5\u014e\u00a8\2\u0da1\u0da0\3\2\2\2\u0da1\u0da2\3\2\2\2\u0da2\u0da3\3"+
		"\2\2\2\u0da3\u0da4\7O\2\2\u0da4\u0da9\5\u015a\u00ae\2\u0da5\u0da6\7\u0084"+
		"\2\2\u0da6\u0da7\7O\2\2\u0da7\u0da9\5\u015a\u00ae\2\u0da8\u0d95\3\2\2"+
		"\2\u0da8\u0d99\3\2\2\2\u0da8\u0d9f\3\2\2\2\u0da8\u0da5\3\2\2\2\u0da9\u0145"+
		"\3\2\2\2\u0daa\u0dab\7\33\2\2\u0dab\u0dac\7O\2\2\u0dac\u0dad\5\u015a\u00ae"+
		"\2\u0dad\u0147\3\2\2\2\u0dae\u0db0\5\u014e\u00a8\2\u0daf\u0dae\3\2\2\2"+
		"\u0daf\u0db0\3\2\2\2\u0db0\u0db1\3\2\2\2\u0db1\u0db2\7O\2\2\u0db2\u0db3"+
		"\5\u015a\u00ae\2\u0db3\u0db4\5\u0154\u00ab\2\u0db4\u0149\3\2\2\2\u0db5"+
		"\u0db7\7V\2\2\u0db6\u0db8\5\u014e\u00a8\2\u0db7\u0db6\3\2\2\2\u0db7\u0db8"+
		"\3\2\2\2\u0db8\u0db9\3\2\2\2\u0db9\u0dba\7O\2\2\u0dba\u0dbb\5\u015a\u00ae"+
		"\2\u0dbb\u014b\3\2\2\2\u0dbc\u0dbd\7\u0084\2\2\u0dbd\u0dbe\7O\2\2\u0dbe"+
		"\u0dbf\5\u015a\u00ae\2\u0dbf\u014d\3\2\2\2\u0dc0\u0dc3\7H\2\2\u0dc1\u0dc3"+
		"\5\u0150\u00a9\2\u0dc2\u0dc0\3\2\2\2\u0dc2\u0dc1\3\2\2\2\u0dc3\u014f\3"+
		"\2\2\2\u0dc4\u0dc6\5\u0152\u00aa\2\u0dc5\u0dc7\7[\2\2\u0dc6\u0dc5\3\2"+
		"\2\2\u0dc6\u0dc7\3\2\2\2\u0dc7\u0151\3\2\2\2\u0dc8\u0dc9\t\62\2\2\u0dc9"+
		"\u0153\3\2\2\2\u0dca\u0dcd\5\u0156\u00ac\2\u0dcb\u0dcd\5\u0158\u00ad\2"+
		"\u0dcc\u0dca\3\2\2\2\u0dcc\u0dcb\3\2\2\2\u0dcd\u0155\3\2\2\2\u0dce\u0dcf"+
		"\7\u00e7\2\2\u0dcf\u0dd0\5\u0166\u00b4\2\u0dd0\u0157\3\2\2\2\u0dd1\u0dd2"+
		"\7\u0088\2\2\u0dd2\u0dd3\7\u0162\2\2\u0dd3\u0dd4\5\u01a4\u00d3\2\u0dd4"+
		"\u0dd5\7\u0163\2\2\u0dd5\u0159\3\2\2\2\u0dd6\u0dd9\5\u0160\u00b1\2\u0dd7"+
		"\u0dd9\5\u018e\u00c8\2\u0dd8\u0dd6\3\2\2\2\u0dd8\u0dd7\3\2\2\2\u0dd9\u0dde"+
		"\3\2\2\2\u0dda\u0ddc\7\6\2\2\u0ddb\u0dda\3\2\2\2\u0ddb\u0ddc\3\2\2\2\u0ddc"+
		"\u0ddd\3\2\2\2\u0ddd\u0ddf\5\u015e\u00b0\2\u0dde\u0ddb\3\2\2\2\u0dde\u0ddf"+
		"\3\2\2\2\u0ddf\u0de4\3\2\2\2\u0de0\u0de1\7\u0162\2\2\u0de1\u0de2\5\u015c"+
		"\u00af\2\u0de2\u0de3\7\u0163\2\2\u0de3\u0de5\3\2\2\2\u0de4\u0de0\3\2\2"+
		"\2\u0de4\u0de5\3\2\2\2\u0de5\u0df6\3\2\2\2\u0de6\u0de8\5\u0162\u00b2\2"+
		"\u0de7\u0de9\7\6\2\2\u0de8\u0de7\3\2\2\2\u0de8\u0de9\3\2\2\2\u0de9\u0dea"+
		"\3\2\2\2\u0dea\u0def\5\u008cG\2\u0deb\u0dec\7\u0162\2\2\u0dec\u0ded\5"+
		"\u015c\u00af\2\u0ded\u0dee\7\u0163\2\2\u0dee\u0df0\3\2\2\2\u0def\u0deb"+
		"\3\2\2\2\u0def\u0df0\3\2\2\2\u0df0\u0df6\3\2\2\2\u0df1\u0df2\7\u0162\2"+
		"\2\u0df2\u0df3\5\u0140\u00a1\2\u0df3\u0df4\7\u0163\2\2\u0df4\u0df6\3\2"+
		"\2\2\u0df5\u0dd8\3\2\2\2\u0df5\u0de6\3\2\2\2\u0df5\u0df1\3\2\2\2\u0df6"+
		"\u015b\3\2\2\2\u0df7\u0dfc\5\u008cG\2\u0df8\u0df9\7\u015b\2\2\u0df9\u0dfb"+
		"\5\u008cG\2\u0dfa\u0df8\3\2\2\2\u0dfb\u0dfe\3\2\2\2\u0dfc\u0dfa\3\2\2"+
		"\2\u0dfc\u0dfd\3\2\2\2\u0dfd\u015d\3\2\2\2\u0dfe\u0dfc\3\2\2\2\u0dff\u0e02"+
		"\5\u0190\u00c9\2\u0e00\u0e02\5\u0160\u00b1\2\u0e01\u0dff\3\2\2\2\u0e01"+
		"\u0e00\3\2\2\2\u0e02\u015f\3\2\2\2\u0e03\u0e04\5\u0190\u00c9\2\u0e04\u0e0d"+
		"\7\u0162\2\2\u0e05\u0e0a\5\u008cG\2\u0e06\u0e07\7\u015b\2\2\u0e07\u0e09"+
		"\5\u008cG\2\u0e08\u0e06\3\2\2\2\u0e09\u0e0c\3\2\2\2\u0e0a\u0e08\3\2\2"+
		"\2\u0e0a\u0e0b\3\2\2\2\u0e0b\u0e0e\3\2\2\2\u0e0c\u0e0a\3\2\2\2\u0e0d\u0e05"+
		"\3\2\2\2\u0e0d\u0e0e\3\2\2\2\u0e0e\u0e0f\3\2\2\2\u0e0f\u0e10\7\u0163\2"+
		"\2\u0e10\u0161\3\2\2\2\u0e11\u0e12\5\u01aa\u00d6\2\u0e12\u0163\3\2\2\2"+
		"\u0e13\u0e14\7\u008d\2\2\u0e14\u0e15\5\u0166\u00b4\2\u0e15\u0165\3\2\2"+
		"\2\u0e16\u0e17\7\u0162\2\2\u0e17\u0e18\5\u0166\u00b4\2\u0e18\u0e19\7\u0163"+
		"\2\2\u0e19\u0e1c\3\2\2\2\u0e1a\u0e1c\5\u00eav\2\u0e1b\u0e16\3\2\2\2\u0e1b"+
		"\u0e1a\3\2\2\2\u0e1c\u0167\3\2\2\2\u0e1d\u0e1e\7;\2\2\u0e1e\u0e1f\7\u0095"+
		"\2\2\u0e1f\u0e20\5\u016a\u00b6\2\u0e20\u0169\3\2\2\2\u0e21\u0e26\5\u016c"+
		"\u00b7\2\u0e22\u0e23\7\u015b\2\2\u0e23\u0e25\5\u016c\u00b7\2\u0e24\u0e22"+
		"\3\2\2\2\u0e25\u0e28\3\2\2\2\u0e26\u0e24\3\2\2\2\u0e26\u0e27\3\2\2\2\u0e27"+
		"\u016b\3\2\2\2\u0e28\u0e26\3\2\2\2\u0e29\u0e2e\5\u0172\u00ba\2\u0e2a\u0e2e"+
		"\5\u0174\u00bb\2\u0e2b\u0e2e\5\u0176\u00bc\2\u0e2c\u0e2e\5\u016e\u00b8"+
		"\2\u0e2d\u0e29\3\2\2\2\u0e2d\u0e2a\3\2\2\2\u0e2d\u0e2b\3\2\2\2\u0e2d\u0e2c"+
		"\3\2\2\2\u0e2e\u016d\3\2\2\2\u0e2f\u0e35\5\u0136\u009c\2\u0e30\u0e31\7"+
		"\u0162\2\2\u0e31\u0e32\5\u017a\u00be\2\u0e32\u0e33\7\u0163\2\2\u0e33\u0e35"+
		"\3\2\2\2\u0e34\u0e2f\3\2\2\2\u0e34\u0e30\3\2\2\2\u0e35\u016f\3\2\2\2\u0e36"+
		"\u0e3b\5\u016e\u00b8\2\u0e37\u0e38\7\u015b\2\2\u0e38\u0e3a\5\u016e\u00b8"+
		"\2\u0e39\u0e37\3\2\2\2\u0e3a\u0e3d\3\2\2\2\u0e3b\u0e39\3\2\2\2\u0e3b\u0e3c"+
		"\3\2\2\2\u0e3c\u0171\3\2\2\2\u0e3d\u0e3b\3\2\2\2\u0e3e\u0e3f\7\u00fe\2"+
		"\2\u0e3f\u0e40\7\u0162\2\2\u0e40\u0e41\5\u0170\u00b9\2\u0e41\u0e42\7\u0163"+
		"\2\2\u0e42\u0173\3\2\2\2\u0e43\u0e44\7\u00a7\2\2\u0e44\u0e45\7\u0162\2"+
		"\2\u0e45\u0e46\5\u0170\u00b9\2\u0e46\u0e47\7\u0163\2\2\u0e47\u0175\3\2"+
		"\2\2\u0e48\u0e49\7\u0162\2\2\u0e49\u0e4a\7\u0163\2\2\u0e4a\u0177\3\2\2"+
		"\2\u0e4b\u0e4c\7<\2\2\u0e4c\u0e4d\5\u011c\u008f\2\u0e4d\u0179\3\2\2\2"+
		"\u0e4e\u0e53\5\u0136\u009c\2\u0e4f\u0e50\7\u015b\2\2\u0e50\u0e52\5\u0136"+
		"\u009c\2\u0e51\u0e4f\3\2\2\2\u0e52\u0e55\3\2\2\2\u0e53\u0e51\3\2\2\2\u0e53"+
		"\u0e54\3\2\2\2\u0e54\u017b\3\2\2\2\u0e55\u0e53\3\2\2\2\u0e56\u0e57\5\u017e"+
		"\u00c0\2\u0e57\u017d\3\2\2\2\u0e58\u0e5b\5\u0180\u00c1\2\u0e59\u0e5b\5"+
		"\u0142\u00a2\2\u0e5a\u0e58\3\2\2\2\u0e5a\u0e59\3\2\2\2\u0e5b\u017f\3\2"+
		"\2\2\u0e5c\u0e65\5\u0184\u00c3\2\u0e5d\u0e5e\5\u0142\u00a2\2\u0e5e\u0e60"+
		"\t\63\2\2\u0e5f\u0e61\t\64\2\2\u0e60\u0e5f\3\2\2\2\u0e60\u0e61\3\2\2\2"+
		"\u0e61\u0e62\3\2\2\2\u0e62\u0e63\5\u0182\u00c2\2\u0e63\u0e65\3\2\2\2\u0e64"+
		"\u0e5c\3\2\2\2\u0e64\u0e5d\3\2\2\2\u0e65\u0e6d\3\2\2\2\u0e66\u0e68\t\63"+
		"\2\2\u0e67\u0e69\t\64\2\2\u0e68\u0e67\3\2\2\2\u0e68\u0e69\3\2\2\2\u0e69"+
		"\u0e6a\3\2\2\2\u0e6a\u0e6c\5\u0182\u00c2\2\u0e6b\u0e66\3\2\2\2\u0e6c\u0e6f"+
		"\3\2\2\2\u0e6d\u0e6b\3\2\2\2\u0e6d\u0e6e\3\2\2\2\u0e6e\u0181\3\2\2\2\u0e6f"+
		"\u0e6d\3\2\2\2\u0e70\u0e73\5\u0184\u00c3\2\u0e71\u0e73\5\u0142\u00a2\2"+
		"\u0e72\u0e70\3\2\2\2\u0e72\u0e71\3\2\2\2\u0e73\u0183\3\2\2\2\u0e74\u0e7d"+
		"\5\u0188\u00c5\2\u0e75\u0e76\5\u0142\u00a2\2\u0e76\u0e78\7I\2\2\u0e77"+
		"\u0e79\t\64\2\2\u0e78\u0e77\3\2\2\2\u0e78\u0e79\3\2\2\2\u0e79\u0e7a\3"+
		"\2\2\2\u0e7a\u0e7b\5\u0186\u00c4\2\u0e7b\u0e7d\3\2\2\2\u0e7c\u0e74\3\2"+
		"\2\2\u0e7c\u0e75\3\2\2\2\u0e7d\u0e85\3\2\2\2\u0e7e\u0e80\7I\2\2\u0e7f"+
		"\u0e81\t\64\2\2\u0e80\u0e7f\3\2\2\2\u0e80\u0e81\3\2\2\2\u0e81\u0e82\3"+
		"\2\2\2\u0e82\u0e84\5\u0186\u00c4\2\u0e83\u0e7e\3\2\2\2\u0e84\u0e87\3\2"+
		"\2\2\u0e85\u0e83\3\2\2\2\u0e85\u0e86\3\2\2\2\u0e86\u0185\3\2\2\2\u0e87"+
		"\u0e85\3\2\2\2\u0e88\u0e8b\5\u0188\u00c5\2\u0e89\u0e8b\5\u0142\u00a2\2"+
		"\u0e8a\u0e88\3\2\2\2\u0e8a\u0e89\3\2\2\2\u0e8b\u0187\3\2\2\2\u0e8c\u0e92"+
		"\5\u018a\u00c6\2\u0e8d\u0e8e\7\u0162\2\2\u0e8e\u0e8f\5\u0180\u00c1\2\u0e8f"+
		"\u0e90\7\u0163\2\2\u0e90\u0e92\3\2\2\2\u0e91\u0e8c\3\2\2\2\u0e91\u0e8d"+
		"\3\2\2\2\u0e92\u0189\3\2\2\2\u0e93\u0e96\5\u0192\u00ca\2\u0e94\u0e96\5"+
		"\u018c\u00c7\2\u0e95\u0e93\3\2\2\2\u0e95\u0e94\3\2\2\2\u0e96\u018b\3\2"+
		"\2\2\u0e97\u0e98\7{\2\2\u0e98\u0e99\5\u018e\u00c8\2\u0e99\u018d\3\2\2"+
		"\2\u0e9a\u0e9d\5\u0190\u00c9\2\u0e9b\u0e9d\5\u008cG\2\u0e9c\u0e9a\3\2"+
		"\2\2\u0e9c\u0e9b\3\2\2\2\u0e9d\u018f\3\2\2\2\u0e9e\u0ea5\5\u008cG\2\u0e9f"+
		"\u0ea0\7\u0169\2\2\u0ea0\u0ea3\5\u008cG\2\u0ea1\u0ea2\7\u0169\2\2\u0ea2"+
		"\u0ea4\5\u008cG\2\u0ea3\u0ea1\3\2\2\2\u0ea3\u0ea4\3\2\2\2\u0ea4\u0ea6"+
		"\3\2\2\2\u0ea5\u0e9f\3\2\2\2\u0ea5\u0ea6\3\2\2\2\u0ea6\u0191\3\2\2\2\u0ea7"+
		"\u0ea9\7t\2\2\u0ea8\u0eaa\5\u019c\u00cf\2\u0ea9\u0ea8\3\2\2\2\u0ea9\u0eaa"+
		"\3\2\2\2\u0eaa\u0eab\3\2\2\2\u0eab\u0ead\5\u0194\u00cb\2\u0eac\u0eae\5"+
		"\u013a\u009e\2\u0ead\u0eac\3\2\2\2\u0ead\u0eae\3\2\2\2\u0eae\u0193\3\2"+
		"\2\2\u0eaf\u0eb4\5\u0196\u00cc\2\u0eb0\u0eb1\7\u015b\2\2\u0eb1\u0eb3\5"+
		"\u0196\u00cc\2\u0eb2\u0eb0\3\2\2\2\u0eb3\u0eb6\3\2\2\2\u0eb4\u0eb2\3\2"+
		"\2\2\u0eb4\u0eb5\3\2\2\2\u0eb5\u0195\3\2\2\2\u0eb6\u0eb4\3\2\2\2\u0eb7"+
		"\u0eba\5\u0198\u00cd\2\u0eb8\u0eba\5\u019a\u00ce\2\u0eb9\u0eb7\3\2\2\2"+
		"\u0eb9\u0eb8\3\2\2\2\u0eba\u0197\3\2\2\2\u0ebb\u0ec0\5\u00eav\2\u0ebc"+
		"\u0ebf\5\u01a0\u00d1\2\u0ebd\u0ebf\5\u01a2\u00d2\2\u0ebe\u0ebc\3\2\2\2"+
		"\u0ebe\u0ebd\3\2\2\2\u0ebf\u0ec2\3\2\2\2\u0ec0\u0ebe\3\2\2\2\u0ec0\u0ec1"+
		"\3\2\2\2\u0ec1\u0199\3\2\2\2\u0ec2\u0ec0\3\2\2\2\u0ec3\u0ec4\7\u0176\2"+
		"\2\u0ec4\u0ec6\7\u0169\2\2\u0ec5\u0ec3\3\2\2\2\u0ec5\u0ec6\3\2\2\2\u0ec6"+
		"\u0ec7\3\2\2\2\u0ec7\u0ec8\7\u0166\2\2\u0ec8\u019b\3\2\2\2\u0ec9\u0eca"+
		"\t\64\2\2\u0eca\u019d\3\2\2\2\u0ecb\u0ecc\5\u008cG\2\u0ecc\u0ecd\7\u0169"+
		"\2\2\u0ecd\u0ecf\3\2\2\2\u0ece\u0ecb\3\2\2\2\u0ece\u0ecf\3\2\2\2\u0ecf"+
		"\u0ed0\3\2\2\2\u0ed0\u0ed1\5\u008cG\2\u0ed1\u019f\3\2\2\2\u0ed2\u0ed4"+
		"\7\6\2\2\u0ed3\u0ed2\3\2\2\2\u0ed3\u0ed4\3\2\2\2\u0ed4\u0ed5\3\2\2\2\u0ed5"+
		"\u0ed6\5\u008cG\2\u0ed6\u01a1\3\2\2\2\u0ed7\u0ed8\7\u00eb\2\2\u0ed8\u0ede"+
		"\7\u0162\2\2\u0ed9\u0edd\5\u0088E\2\u0eda\u0edd\5\u01da\u00ee\2\u0edb"+
		"\u0edd\5\u01e2\u00f2\2\u0edc\u0ed9\3\2\2\2\u0edc\u0eda\3\2\2\2\u0edc\u0edb"+
		"\3\2\2\2\u0edd\u0ee0\3\2\2\2\u0ede\u0edc\3\2\2\2\u0ede\u0edf\3\2\2\2\u0edf"+
		"\u0ee1\3\2\2\2\u0ee0\u0ede\3\2\2\2\u0ee1\u0ee2\7\u0163\2\2\u0ee2\u01a3"+
		"\3\2\2\2\u0ee3\u0ee8\5\u019e\u00d0\2\u0ee4\u0ee5\7\u015b\2\2\u0ee5\u0ee7"+
		"\5\u019e\u00d0\2\u0ee6\u0ee4\3\2\2\2\u0ee7\u0eea\3\2\2\2\u0ee8\u0ee6\3"+
		"\2\2\2\u0ee8\u0ee9\3\2\2\2\u0ee9\u01a5\3\2\2\2\u0eea\u0ee8\3\2\2\2\u0eeb"+
		"\u0eec\5\u01ac\u00d7\2\u0eec\u01a7\3\2\2\2\u0eed\u0eee\5\u01ac\u00d7\2"+
		"\u0eee\u01a9\3\2\2\2\u0eef\u0ef0\5\u01ac\u00d7\2\u0ef0\u01ab\3\2\2\2\u0ef1"+
		"\u0ef2\7\u0162\2\2\u0ef2\u0ef3\5\u017c\u00bf\2\u0ef3\u0ef4\7\u0163\2\2"+
		"\u0ef4\u01ad\3\2\2\2\u0ef5\u0efc\5\u01b0\u00d9\2\u0ef6\u0efc\5\u01b4\u00db"+
		"\2\u0ef7\u0efc\5\u01b8\u00dd\2\u0ef8\u0efc\5\u01be\u00e0\2\u0ef9\u0efc"+
		"\5\u01c6\u00e4\2\u0efa\u0efc\5\u01d0\u00e9\2\u0efb\u0ef5\3\2\2\2\u0efb"+
		"\u0ef6\3\2\2\2\u0efb\u0ef7\3\2\2\2\u0efb\u0ef8\3\2\2\2\u0efb\u0ef9\3\2"+
		"\2\2\u0efb\u0efa\3\2\2\2\u0efc\u01af\3\2\2\2\u0efd\u0efe\5\u0136\u009c"+
		"\2\u0efe\u0eff\5\u01b2\u00da\2\u0eff\u0f00\5\u0136\u009c\2\u0f00\u01b1"+
		"\3\2\2\2\u0f01\u0f02\t\65\2\2\u0f02\u01b3\3\2\2\2\u0f03\u0f04\5\u0136"+
		"\u009c\2\u0f04\u0f05\5\u01b6\u00dc\2\u0f05\u01b5\3\2\2\2\u0f06\u0f08\7"+
		"W\2\2\u0f07\u0f06\3\2\2\2\u0f07\u0f08\3\2\2\2\u0f08\u0f09\3\2\2\2\u0f09"+
		"\u0f0b\7\u0094\2\2\u0f0a\u0f0c\t\66\2\2\u0f0b\u0f0a\3\2\2\2\u0f0b\u0f0c"+
		"\3\2\2\2\u0f0c\u0f0d\3\2\2\2\u0f0d\u0f0e\5\u0136\u009c\2\u0f0e\u0f0f\7"+
		"\t\2\2\u0f0f\u0f10\5\u0136\u009c\2\u0f10\u01b7\3\2\2\2\u0f11\u0f13\5\u00f4"+
		"{\2\u0f12\u0f14\7W\2\2\u0f13\u0f12\3\2\2\2\u0f13\u0f14\3\2\2\2\u0f14\u0f15"+
		"\3\2\2\2\u0f15\u0f16\7C\2\2\u0f16\u0f17\5\u01ba\u00de\2\u0f17\u01b9\3"+
		"\2\2\2\u0f18\u0f1e\5\u01aa\u00d6\2\u0f19\u0f1a\7\u0162\2\2\u0f1a\u0f1b"+
		"\5\u01bc\u00df\2\u0f1b\u0f1c\7\u0163\2\2\u0f1c\u0f1e\3\2\2\2\u0f1d\u0f18"+
		"\3\2\2\2\u0f1d\u0f19\3\2\2\2\u0f1e\u01bb\3\2\2\2\u0f1f\u0f24\5\u0130\u0099"+
		"\2\u0f20\u0f21\7\u015b\2\2\u0f21\u0f23\5\u0130\u0099\2\u0f22\u0f20\3\2"+
		"\2\2\u0f23\u0f26\3\2\2\2\u0f24\u0f22\3\2\2\2\u0f24\u0f25\3\2\2\2\u0f25"+
		"\u01bd\3\2\2\2\u0f26\u0f24\3\2\2\2\u0f27\u0f28\5\u0136\u009c\2\u0f28\u0f29"+
		"\5\u01c0\u00e1\2\u0f29\u0f2a\7\u0179\2\2\u0f2a\u01bf\3\2\2\2\u0f2b\u0f2d"+
		"\7W\2\2\u0f2c\u0f2b\3\2\2\2\u0f2c\u0f2d\3\2\2\2\u0f2d\u0f2e\3\2\2\2\u0f2e"+
		"\u0f31\5\u01c2\u00e2\2\u0f2f\u0f31\5\u01c4\u00e3\2\u0f30\u0f2c\3\2\2\2"+
		"\u0f30\u0f2f\3\2\2\2\u0f31\u01c1\3\2\2\2\u0f32\u0f36\t\67\2\2\u0f33\u0f34"+
		"\7\u0104\2\2\u0f34\u0f36\7\u0117\2\2\u0f35\u0f32\3\2\2\2\u0f35\u0f33\3"+
		"\2\2\2\u0f36\u01c3\3\2\2\2\u0f37\u0f38\t8\2\2\u0f38\u01c5\3\2\2\2\u0f39"+
		"\u0f3a\5\u0136\u009c\2\u0f3a\u0f3c\7N\2\2\u0f3b\u0f3d\7W\2\2\u0f3c\u0f3b"+
		"\3\2\2\2\u0f3c\u0f3d\3\2\2\2\u0f3d\u0f3e\3\2\2\2\u0f3e\u0f3f\7X\2\2\u0f3f"+
		"\u01c7\3\2\2\2\u0f40\u0f41\5\u00f4{\2\u0f41\u0f42\5\u01b2\u00da\2\u0f42"+
		"\u0f43\5\u01ca\u00e6\2\u0f43\u0f44\5\u01aa\u00d6\2\u0f44\u01c9\3\2\2\2"+
		"\u0f45\u0f48\5\u01cc\u00e7\2\u0f46\u0f48\5\u01ce\u00e8\2\u0f47\u0f45\3"+
		"\2\2\2\u0f47\u0f46\3\2\2\2\u0f48\u01cb\3\2\2\2\u0f49\u0f4a\7\7\2\2\u0f4a"+
		"\u01cd\3\2\2\2\u0f4b\u0f4c\t9\2\2\u0f4c\u01cf\3\2\2\2\u0f4d\u0f4f\7W\2"+
		"\2\u0f4e\u0f4d\3\2\2\2\u0f4e\u0f4f\3\2\2\2\u0f4f\u0f50\3\2\2\2\u0f50\u0f51"+
		"\7\u00b8\2\2\u0f51\u0f52\5\u01aa\u00d6\2\u0f52\u01d1\3\2\2\2\u0f53\u0f54"+
		"\7\u0085\2\2\u0f54\u0f55\5\u01aa\u00d6\2\u0f55\u01d3\3\2\2\2\u0f56\u0f59"+
		"\5\u01d6\u00ec\2\u0f57\u0f59\7\u0100\2\2\u0f58\u0f56\3\2\2\2\u0f58\u0f57"+
		"\3\2\2\2\u0f59\u01d5\3\2\2\2\u0f5a\u0f5b\t:\2\2\u0f5b\u01d7\3\2\2\2\u0f5c"+
		"\u0f5d\t;\2\2\u0f5d\u01d9\3\2\2\2\u0f5e\u0f5f\7_\2\2\u0f5f\u0f60\7\u0095"+
		"\2\2\u0f60\u0f61\5\u01de\u00f0\2\u0f61\u01db\3\2\2\2\u0f62\u0f6c\5\u01de"+
		"\u00f0\2\u0f63\u0f66\7\u0162\2\2\u0f64\u0f67\n<\2\2\u0f65\u0f67\5\u01dc"+
		"\u00ef\2\u0f66\u0f64\3\2\2\2\u0f66\u0f65\3\2\2\2\u0f67\u0f68\3\2\2\2\u0f68"+
		"\u0f66\3\2\2\2\u0f68\u0f69\3\2\2\2\u0f69\u0f6a\3\2\2\2\u0f6a\u0f6c\7\u0163"+
		"\2\2\u0f6b\u0f62\3\2\2\2\u0f6b\u0f63\3\2\2\2\u0f6c\u01dd\3\2\2\2\u0f6d"+
		"\u0f72\5\u01e0\u00f1\2\u0f6e\u0f6f\7\u015b\2\2\u0f6f\u0f71\5\u01e0\u00f1"+
		"\2\u0f70\u0f6e\3\2\2\2\u0f71\u0f74\3\2\2\2\u0f72\u0f70\3\2\2\2\u0f72\u0f73"+
		"\3\2\2\2\u0f73\u01df\3\2\2\2\u0f74\u0f72\3\2\2\2\u0f75\u0f77\5\u0136\u009c"+
		"\2\u0f76\u0f78\5\u01e2\u00f2\2\u0f77\u0f76\3\2\2\2\u0f77\u0f78\3\2\2\2"+
		"\u0f78\u0f7a\3\2\2\2\u0f79\u0f7b\5\u01e6\u00f4\2\u0f7a\u0f79\3\2\2\2\u0f7a"+
		"\u0f7b\3\2\2\2\u0f7b\u01e1\3\2\2\2\u0f7c\u0f7d\t=\2\2\u0f7d\u01e3\3\2"+
		"\2\2\u0f7e\u0f7f\7T\2\2\u0f7f\u0f80\5\u00f4{\2\u0f80\u01e5\3\2\2\2\u0f81"+
		"\u0f82\7X\2\2\u0f82\u0f86\7\u00be\2\2\u0f83\u0f84\7X\2\2\u0f84\u0f86\7"+
		"\u00d1\2\2\u0f85\u0f81\3\2\2\2\u0f85\u0f83\3\2\2\2\u0f86\u01e7\3\2\2\2"+
		"\u022b\u01ed\u01f4\u01f8\u0202\u0207\u020a\u020f\u0212\u021a\u021f\u0225"+
		"\u022d\u023a\u0240\u0249\u0250\u0255\u0262\u0268\u0272\u0279\u027c\u0287"+
		"\u0290\u029a\u029f\u02a6\u02ab\u02b1\u02ba\u02be\u02c2\u02c7\u02cb\u02cf"+
		"\u02d3\u02d8\u02de\u02e2\u02e6\u02fb\u0307\u0312\u0314\u031a\u0325\u032f"+
		"\u034e\u0362\u036a\u036f\u0375\u0378\u037c\u038e\u0393\u03a2\u03a6\u03ab"+
		"\u03ad\u03b8\u03bb\u03c4\u03c7\u03d1\u03d6\u03d8\u03e3\u03e8\u03ea\u03f3"+
		"\u03f5\u03fe\u0400\u0409\u0410\u0415\u0417\u0420\u0427\u042c\u042e\u0437"+
		"\u043c\u043e\u0447\u044c\u044e\u0453\u0458\u045e\u0461\u0463\u0465\u046c"+
		"\u046f\u0474\u0479\u0481\u0487\u048f\u0495\u0499\u04a5\u04aa\u04ad\u04b1"+
		"\u04b4\u04ba\u04be\u04c2\u04c6\u04cc\u04d0\u04d4\u04d8\u04dc\u04e0\u04e3"+
		"\u04e6\u04ee\u04f2\u04f4\u0504\u0509\u050d\u050f\u0517\u0520\u0528\u052e"+
		"\u0532\u0535\u053d\u0540\u0548\u0552\u0555\u0557\u055a\u055e\u0564\u0569"+
		"\u056f\u0573\u0576\u057a\u0581\u0587\u0590\u0597\u059c\u059e\u05a2\u05a7"+
		"\u05b0\u05b2\u05bd\u05c4\u05c8\u05d0\u05d5\u05d9\u05e0\u05e8\u05ec\u05ee"+
		"\u05f7\u0603\u0606\u060d\u0611\u0613\u061c\u0624\u0626\u0631\u063e\u064a"+
		"\u064f\u0654\u0656\u065b\u0662\u0664\u0666\u066a\u066c\u0676\u067d\u0681"+
		"\u0685\u0687\u0690\u0698\u069a\u06a3\u06a8\u06ad\u06b4\u06bd\u06c1\u06c3"+
		"\u06c7\u06cb\u06cf\u06d3\u06d7\u06db\u06e3\u06e8\u06ea\u06ee\u06f2\u06f6"+
		"\u06fe\u0702\u0704\u070e\u0713\u0717\u071e\u0721\u0725\u0729\u072d\u0736"+
		"\u073b\u073d\u0746\u074b\u0756\u0759\u0762\u0767\u0769\u0772\u077a\u077c"+
		"\u0787\u0794\u07a0\u07a5\u07aa\u07ac\u07b1\u07b7\u07bb\u07bf\u07c1\u07cb"+
		"\u07d2\u07d6\u07da\u07dc\u07e5\u07ed\u07ef\u07f8\u0802\u080b\u0811\u0813"+
		"\u0817\u081b\u081f\u0823\u0827\u082d\u0839\u083c\u085f\u0868\u086b\u086e"+
		"\u0875\u087c\u0886\u088b\u089a\u08aa\u08b0\u08bb\u08be\u08c0\u08c9\u08ce"+
		"\u08d7\u08dc\u08e0\u08e3\u08ee\u08f3\u08f6\u08fb\u090b\u090e\u091b\u091f"+
		"\u0926\u092b\u0932\u0938\u093c\u0942\u0949\u094b\u0951\u0956\u095e\u0967"+
		"\u096b\u096d\u0971\u0974\u097a\u097e\u0986\u098a\u098e\u0994\u0999\u099d"+
		"\u09a1\u09a7\u09b0\u09b3\u09ba\u09be\u09c2\u09d1\u09d5\u09de\u09e2\u09e4"+
		"\u09e9\u09ef\u09f8\u09fb\u0a01\u0a06\u0a0e\u0a18\u0a26\u0a2f\u0a39\u0a43"+
		"\u0a4d\u0a59\u0a5e\u0a66\u0a6e\u0a70\u0a73\u0a78\u0a7e\u0a82\u0a8b\u0a9b"+
		"\u0aa0\u0aa5\u0aa7\u0aac\u0ab2\u0ab8\u0abe\u0ac4\u0ac7\u0acb\u0ad7\u0ae0"+
		"\u0ae2\u0ae6\u0aee\u0af1\u0af7\u0aff\u0b10\u0b20\u0b27\u0b2b\u0b2f\u0b31"+
		"\u0b37\u0b3c\u0b41\u0b4f\u0b53\u0b60\u0b66\u0b6a\u0b6f\u0b74\u0b78\u0b7b"+
		"\u0b84\u0b89\u0b8d\u0b93\u0b99\u0b9e\u0ba2\u0ba4\u0ba8\u0bac\u0bae\u0bb2"+
		"\u0bb6\u0bba\u0bbe\u0bc1\u0bc5\u0bca\u0bcc\u0bd6\u0bdf\u0be6\u0be9\u0bed"+
		"\u0bf1\u0bf6\u0bf8\u0bfc\u0c01\u0c05\u0c07\u0c0b\u0c1c\u0c23\u0c2f\u0c31"+
		"\u0c36\u0c57\u0c5b\u0c5f\u0c66\u0c69\u0c71\u0c74\u0c87\u0c98\u0ca1\u0cb3"+
		"\u0cba\u0cc2\u0cc6\u0cd0\u0cd7\u0cde\u0cef\u0cf5\u0cfe\u0d05\u0d0b\u0d15"+
		"\u0d18\u0d1b\u0d22\u0d2d\u0d35\u0d3b\u0d3f\u0d43\u0d4b\u0d4f\u0d57\u0d5f"+
		"\u0d63\u0d67\u0d6a\u0d6d\u0d70\u0d73\u0d77\u0d7b\u0d7e\u0d81\u0d88\u0d8d"+
		"\u0d93\u0d99\u0da1\u0da8\u0daf\u0db7\u0dc2\u0dc6\u0dcc\u0dd8\u0ddb\u0dde"+
		"\u0de4\u0de8\u0def\u0df5\u0dfc\u0e01\u0e0a\u0e0d\u0e1b\u0e26\u0e2d\u0e34"+
		"\u0e3b\u0e53\u0e5a\u0e60\u0e64\u0e68\u0e6d\u0e72\u0e78\u0e7c\u0e80\u0e85"+
		"\u0e8a\u0e91\u0e95\u0e9c\u0ea3\u0ea5\u0ea9\u0ead\u0eb4\u0eb9\u0ebe\u0ec0"+
		"\u0ec5\u0ece\u0ed3\u0edc\u0ede\u0ee8\u0efb\u0f07\u0f0b\u0f13\u0f1d\u0f24"+
		"\u0f2c\u0f30\u0f35\u0f3c\u0f47\u0f4e\u0f58\u0f66\u0f68\u0f6b\u0f72\u0f77"+
		"\u0f7a\u0f85";
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