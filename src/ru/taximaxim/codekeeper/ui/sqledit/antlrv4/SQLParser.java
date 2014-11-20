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
		FUNCTION=46, ISODOW=195, OVERWRITE=227, FUNCTIONS=47, ROW=95, PRECISION=233, 
		ILIKE=55, TYPES=271, ENABLE=171, Character_String_Literal=366, NOT=78, 
		EXCEPT=37, FOREIGN=44, CACHE=141, PRIVILEGES=91, BYTEA=323, MONTH=214, 
		STATEMENT=111, CHARACTER=145, TYPE=270, BlockComment=361, VARBIT=291, 
		STDDEV_POP=257, CREATE=23, COMMENTS=152, ESC_SEQUENCES=367, USING=127, 
		UNLOGGED=273, NOT_EQUAL=339, TIMEZONE_MINUTE=267, VERTICAL_BAR=353, VARIADIC=129, 
		TIMESTAMPTZ=317, RIGHT_BRACKET=358, VALID=275, REGEXP=239, FAMILY=179, 
		GEQ=343, HANDLER=53, STDDEV_SAMP=258, DIVIDE=349, DISABLE=167, BLOB=322, 
		REPLICA=241, STRICT=112, PRESERVE=89, ASC=10, GROUPING=184, SUBPARTITION=259, 
		VALIDATOR=128, KEY=71, SETOF=109, TEMP=115, ELSE=36, NUMBER=359, BOOL=289, 
		TRAILING=118, DEFINER=165, SEMI_COLON=336, INT=298, RLIKE=244, LEADING=72, 
		RESTRICT=99, SERVER=249, PROCEDURAL=93, TABLESPACE=261, MILLISECONDS=210, 
		REAL=303, INTERSECT=64, GROUP=51, LANGUAGE=198, SEQUENCES=106, OUT=83, 
		REAL_NUMBER=360, NONE=217, USER=274, TRIM=268, LEFT_PAREN=344, LOCATION=203, 
		SEARCH=246, END=35, N_DISTINCT=219, CONSTRAINT=20, TIMEZONE_HOUR=266, 
		RENAME=240, CAST_EXPRESSION=332, ALTER=6, OPTION=224, ISOYEAR=196, UUID=319, 
		NCHAR=311, PLAIN=232, ONLY=223, EXECUTE=40, LEFT_BRACKET=357, OWNER=88, 
		INPUT=191, TABLE=114, VARCHAR=310, FLOAT=305, VERSION=281, MICROSECONDS=208, 
		IMMUTABLE=57, ASYMMETRIC=9, SUM=260, N_DISTINCT_INHERITED=220, UnterminatedQuotedIdentifier=365, 
		OWNED=87, EndDollarStringConstant=374, Space=370, INOUT=66, STORAGE=256, 
		TIME=314, AS=4, RIGHT_PAREN=345, THEN=117, MAXVALUE=207, COLLATION=18, 
		LEFT=73, REPLACE=98, AVG=138, ZONE=287, TRUNCATE=122, COLUMN=150, TRUSTED=119, 
		PLUS=346, EXISTS=175, NVARCHAR=312, Not_Similar_To=329, RETURNS=100, LIKE=74, 
		COLLATE=17, ADD=1, INTEGER=299, OUTER=82, BY=140, DEFERRABLE=28, TO=269, 
		DOLLAR_FIELD=368, INHERIT=187, SET=250, RIGHT=102, HAVING=52, MIN=211, 
		SESSION=108, MINUS=347, TEXT=318, HOUR=186, QuotedIdentifier=364, CONCATENATION_OPERATOR=338, 
		CONVERSION=22, UNION=123, CURRENT=159, COLON=335, COMMIT=153, SCHEMA=104, 
		DATABASE=25, DECIMAL=308, DROP=170, BIGINT=300, WHEN=131, VALIDATE=276, 
		CONCURRENTLY=154, ROWS=96, START=254, BIT=290, LARGE=199, REVOKE=101, 
		NATURAL=77, FORMAT=182, PUBLIC=234, AGGREGATE=2, EXTENSION=41, BETWEEN=139, 
		OPTIONS=225, FIRST=181, CAST=16, WEEK=283, EXTERNAL=177, DOUBLE_QUOTE=355, 
		VARYING=280, RESET=242, REGCONFIG=238, TRIGGER=120, CASE=14, CHAR=309, 
		INT8=295, COUNT=157, DAY=162, CASCADE=15, COST=156, INT2=293, INT1=292, 
		Identifier=363, INT4=294, ISCACHABLE=194, EXTENDED=176, QUOTE=354, MODULAR=350, 
		INVOKER=68, FULL=45, DICTIONARY=166, THAN=264, QUARTER=236, INSERT=192, 
		INHERITS=60, CONNECT=19, ALWAYS=136, INTERSECTION=193, LESS=201, TINYINT=296, 
		BOTH=13, Similar_To_Case_Insensitive=330, DOUBLE=306, ADMIN=135, SYMMETRIC=113, 
		VOID=327, ISSTRICT=197, EACH=34, LAST=200, COMMENT=151, SELECT=107, INTO=65, 
		ARRAY=137, UNIQUE=124, COALESCE=149, SECOND=247, ROLE=94, RULE=103, VIEW=130, 
		EPOCH=172, ROLLUP=245, NULL=79, WITHOUT=134, NO=216, EVERY=174, ON=222, 
		RESTART=243, MATCH=205, PRIMARY=90, DELETE=30, INET4=324, NUMERIC=307, 
		LOCAL=76, LIST=202, OF=80, EXCLUDING=39, TABLES=262, UNDERLINE=352, SEQUENCE=105, 
		Not_Similar_To_Case_Insensitive=331, CUBE=158, NATIONAL=215, CALLED=142, 
		STATISTICS=255, VAR_POP=279, OR=85, FILTER=180, CHECK=146, INLINE=62, 
		FROM=48, FALSE=42, COLLECT=148, BeginDollarStringConstant=369, PARSER=228, 
		DISTINCT=32, TEMPORARY=116, TIMESTAMP=316, SIMPLE=252, DOLLAR=356, OVER=226, 
		CONSTRAINTS=21, WHERE=132, DEC=163, VAR_SAMP=278, NULLIF=218, MAIN=204, 
		CLASS=143, Text_between_Dollar=373, TIMETZ=315, INNER=63, YEAR=286, TIMEZONE=265, 
		ORDER=86, AUTHORIZATION=11, LIMIT=75, DECADE=164, GTH=342, CYCLE=160, 
		White_Space=371, MAX=206, UPDATE=125, LineComment=362, DEFERRED=29, FOR=43, 
		FLOAT4=301, CONFIGURATION=155, FLOAT8=302, AND=7, CROSS=24, Similar_To=328, 
		INTERVAL=326, USAGE=126, IF=54, INDEX=188, OIDS=81, BOOLEAN=288, IN=58, 
		MINVALUE=212, UNKNOWN=272, MULTIPLY=348, OBJECT=221, COMMA=337, REFERENCES=97, 
		PARTITION=230, IS=69, PARTITIONS=231, SOME=110, EQUAL=334, ALL=5, DOT=351, 
		EXTRACT=178, CENTURY=144, STABLE=253, SECURITY=248, PARTIAL=229, DOW=168, 
		EXCLUDE=38, WITH=133, INITIALLY=61, DOY=169, FUSION=183, GRANT=50, VARBINARY=321, 
		VOLATILE=282, OPERATOR=84, DEFAULT=26, VALUES=277, HASH=185, RANGE=237, 
		MILLENNIUM=209, INDEXES=189, PURGE=235, BEFORE=12, AFTER=3, INSTEAD=67, 
		EVENT=173, WRAPPER=285, TRUE=121, PROCEDURE=92, JOIN=70, SIMILAR=251, 
		DOMAIN=33, DEFAULTS=27, LTH=340, INCREMENT=190, ANY=8, INET=325, TEMPLATE=263, 
		BAD=372, ASSIGN=333, REGCLASS=304, IMMEDIATE=56, CLUSTER=147, WINDOW=284, 
		BINARY=320, DESC=31, DATE=313, MINUTE=213, GLOBAL=49, DATA=161, INCLUDING=59, 
		LEQ=341, SMALLINT=297;
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
		"WITH", "WITHOUT", "ADMIN", "ALWAYS", "ARRAY", "AVG", "BETWEEN", "BY", 
		"CACHE", "CALLED", "CLASS", "CENTURY", "CHARACTER", "CHECK", "CLUSTER", 
		"COLLECT", "COALESCE", "COLUMN", "COMMENT", "COMMENTS", "COMMIT", "CONCURRENTLY", 
		"CONFIGURATION", "COST", "COUNT", "CUBE", "CURRENT", "CYCLE", "DATA", 
		"DAY", "DEC", "DECADE", "DEFINER", "DICTIONARY", "DISABLE", "DOW", "DOY", 
		"DROP", "ENABLE", "EPOCH", "EVENT", "EVERY", "EXISTS", "EXTENDED", "EXTERNAL", 
		"EXTRACT", "FAMILY", "FILTER", "FIRST", "FORMAT", "FUSION", "GROUPING", 
		"HASH", "HOUR", "INHERIT", "INDEX", "INDEXES", "INCREMENT", "INPUT", "INSERT", 
		"INTERSECTION", "ISCACHABLE", "ISODOW", "ISOYEAR", "ISSTRICT", "LANGUAGE", 
		"LARGE", "LAST", "LESS", "LIST", "LOCATION", "MAIN", "MATCH", "MAX", "MAXVALUE", 
		"MICROSECONDS", "MILLENNIUM", "MILLISECONDS", "MIN", "MINVALUE", "MINUTE", 
		"MONTH", "NATIONAL", "NO", "NONE", "NULLIF", "N_DISTINCT", "N_DISTINCT_INHERITED", 
		"OBJECT", "ON", "ONLY", "OPTION", "OPTIONS", "OVER", "OVERWRITE", "PARSER", 
		"PARTIAL", "PARTITION", "PARTITIONS", "PLAIN", "PRECISION", "PUBLIC", 
		"PURGE", "QUARTER", "RANGE", "REGCONFIG", "REGEXP", "RENAME", "REPLICA", 
		"RESET", "RESTART", "RLIKE", "ROLLUP", "SEARCH", "SECOND", "SECURITY", 
		"SERVER", "SET", "SIMILAR", "SIMPLE", "STABLE", "START", "STATISTICS", 
		"STORAGE", "STDDEV_POP", "STDDEV_SAMP", "SUBPARTITION", "SUM", "TABLESPACE", 
		"TABLES", "TEMPLATE", "THAN", "TIMEZONE", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", 
		"TRIM", "TO", "TYPE", "TYPES", "UNKNOWN", "UNLOGGED", "USER", "VALID", 
		"VALIDATE", "VALUES", "VAR_SAMP", "VAR_POP", "VARYING", "VERSION", "VOLATILE", 
		"WEEK", "WINDOW", "WRAPPER", "YEAR", "ZONE", "BOOLEAN", "BOOL", "BIT", 
		"VARBIT", "INT1", "INT2", "INT4", "INT8", "TINYINT", "SMALLINT", "INT", 
		"INTEGER", "BIGINT", "FLOAT4", "FLOAT8", "REAL", "REGCLASS", "FLOAT", 
		"DOUBLE", "NUMERIC", "DECIMAL", "CHAR", "VARCHAR", "NCHAR", "NVARCHAR", 
		"DATE", "TIME", "TIMETZ", "TIMESTAMP", "TIMESTAMPTZ", "TEXT", "UUID", 
		"BINARY", "VARBINARY", "BLOB", "BYTEA", "INET4", "INET", "INTERVAL", "VOID", 
		"'~'", "'!~'", "'~*'", "'!~*'", "CAST_EXPRESSION", "':='", "'='", "':'", 
		"';'", "','", "CONCATENATION_OPERATOR", "NOT_EQUAL", "'<'", "'<='", "'>'", 
		"'>='", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'%'", "'.'", "'_'", 
		"'|'", "'''", "'\"'", "'$'", "'['", "']'", "NUMBER", "REAL_NUMBER", "BlockComment", 
		"LineComment", "Identifier", "QuotedIdentifier", "UnterminatedQuotedIdentifier", 
		"Character_String_Literal", "ESC_SEQUENCES", "DOLLAR_FIELD", "BeginDollarStringConstant", 
		"' '", "White_Space", "BAD", "Text_between_Dollar", "EndDollarStringConstant"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_schema_statement = 2, RULE_schema_create = 3, 
		RULE_schema_alter = 4, RULE_alter_function_statement = 5, RULE_alter_schema_statement = 6, 
		RULE_alter_language_statement = 7, RULE_alter_table_statement = 8, RULE_table_action = 9, 
		RULE_attribute_option_value = 10, RULE_table_constraint_using_index = 11, 
		RULE_table_attribute_option = 12, RULE_function_action = 13, RULE_alter_default_privileges = 14, 
		RULE_abbreviated_grant_or_revoke = 15, RULE_alter_sequence_statement = 16, 
		RULE_index_statement = 17, RULE_create_extension_statement = 18, RULE_create_language_statement = 19, 
		RULE_create_event_trigger = 20, RULE_set_statement = 21, RULE_set_statement_value = 22, 
		RULE_create_trigger_statement = 23, RULE_revoke_statement = 24, RULE_revoke_from_cascade_restrict = 25, 
		RULE_grant_statement = 26, RULE_grant_to_rule = 27, RULE_comment_on_statement = 28, 
		RULE_create_function_statement = 29, RULE_function_column_name_type = 30, 
		RULE_function_parameters = 31, RULE_function_def_value = 32, RULE_function_body = 33, 
		RULE_function_arguments = 34, RULE_function_attribute = 35, RULE_argmode = 36, 
		RULE_function_definition = 37, RULE_functions_definition_schema = 38, 
		RULE_create_sequence_statement = 39, RULE_sequence_body = 40, RULE_create_schema_statement = 41, 
		RULE_create_view_statement = 42, RULE_create_table_statement = 43, RULE_table_body = 44, 
		RULE_table_column_definition = 45, RULE_like_option = 46, RULE_table_constraint = 47, 
		RULE_column_constraint = 48, RULE_check_boolean_expression = 49, RULE_storage_parameter = 50, 
		RULE_with_storage_parameter = 51, RULE_storage_parameter_oid = 52, RULE_on_commit = 53, 
		RULE_table_space = 54, RULE_action = 55, RULE_index_parameters = 56, RULE_table_elements = 57, 
		RULE_field_element = 58, RULE_field_type = 59, RULE_param_clause = 60, 
		RULE_param = 61, RULE_method_specifier = 62, RULE_table_space_specifier = 63, 
		RULE_table_space_name = 64, RULE_table_partitioning_clauses = 65, RULE_range_partitions = 66, 
		RULE_range_value_clause_list = 67, RULE_range_value_clause = 68, RULE_hash_partitions = 69, 
		RULE_individual_hash_partitions = 70, RULE_individual_hash_partition = 71, 
		RULE_hash_partitions_by_quantity = 72, RULE_list_partitions = 73, RULE_list_value_clause_list = 74, 
		RULE_list_value_partition = 75, RULE_column_partitions = 76, RULE_partition_by_columns = 77, 
		RULE_partition_name = 78, RULE_drop_table_statement = 79, RULE_identifier = 80, 
		RULE_nonreserved_keywords = 81, RULE_unsigned_literal = 82, RULE_general_literal = 83, 
		RULE_datetime_literal = 84, RULE_time_literal = 85, RULE_timestamp_literal = 86, 
		RULE_date_literal = 87, RULE_boolean_literal = 88, RULE_data_type = 89, 
		RULE_predefined_type = 90, RULE_regclass = 91, RULE_network_type = 92, 
		RULE_character_string_type = 93, RULE_type_length = 94, RULE_national_character_string_type = 95, 
		RULE_binary_large_object_string_type = 96, RULE_numeric_type = 97, RULE_exact_numeric_type = 98, 
		RULE_approximate_numeric_type = 99, RULE_precision_param = 100, RULE_boolean_type = 101, 
		RULE_datetime_type = 102, RULE_bit_type = 103, RULE_binary_type = 104, 
		RULE_value_expression_primary = 105, RULE_parenthesized_value_expression = 106, 
		RULE_nonparenthesized_value_expression_primary = 107, RULE_unsigned_value_specification = 108, 
		RULE_unsigned_numeric_literal = 109, RULE_signed_numerical_literal = 110, 
		RULE_set_function_specification = 111, RULE_aggregate_function = 112, 
		RULE_general_set_function = 113, RULE_set_function_type = 114, RULE_filter_clause = 115, 
		RULE_grouping_operation = 116, RULE_case_expression = 117, RULE_case_abbreviation = 118, 
		RULE_case_specification = 119, RULE_simple_case = 120, RULE_searched_case = 121, 
		RULE_simple_when_clause = 122, RULE_searched_when_clause = 123, RULE_else_clause = 124, 
		RULE_result = 125, RULE_cast_specification = 126, RULE_cast_operand = 127, 
		RULE_cast_target = 128, RULE_value_expression = 129, RULE_array_expression = 130, 
		RULE_common_value_expression = 131, RULE_numeric_value_expression = 132, 
		RULE_term = 133, RULE_factor = 134, RULE_array = 135, RULE_numeric_primary = 136, 
		RULE_sign = 137, RULE_numeric_value_function = 138, RULE_extract_expression = 139, 
		RULE_extract_field = 140, RULE_time_zone_field = 141, RULE_extract_source = 142, 
		RULE_string_value_expression = 143, RULE_character_value_expression = 144, 
		RULE_character_factor = 145, RULE_character_primary = 146, RULE_string_value_function = 147, 
		RULE_trim_function = 148, RULE_trim_operands = 149, RULE_trim_specification = 150, 
		RULE_boolean_value_expression = 151, RULE_or_predicate = 152, RULE_and_predicate = 153, 
		RULE_boolean_factor = 154, RULE_boolean_test = 155, RULE_is_clause = 156, 
		RULE_truth_value = 157, RULE_boolean_primary = 158, RULE_boolean_predicand = 159, 
		RULE_parenthesized_boolean_value_expression = 160, RULE_row_value_expression = 161, 
		RULE_row_value_special_case = 162, RULE_explicit_row_value_constructor = 163, 
		RULE_row_value_predicand = 164, RULE_row_value_constructor_predicand = 165, 
		RULE_table_expression = 166, RULE_from_clause = 167, RULE_table_reference_list = 168, 
		RULE_table_reference = 169, RULE_joined_table = 170, RULE_joined_table_primary = 171, 
		RULE_cross_join = 172, RULE_qualified_join = 173, RULE_natural_join = 174, 
		RULE_union_join = 175, RULE_join_type = 176, RULE_outer_join_type = 177, 
		RULE_outer_join_type_part2 = 178, RULE_join_specification = 179, RULE_join_condition = 180, 
		RULE_named_columns_join = 181, RULE_table_primary = 182, RULE_column_name_list = 183, 
		RULE_alias_def = 184, RULE_alias_table = 185, RULE_derived_table = 186, 
		RULE_where_clause = 187, RULE_search_condition = 188, RULE_groupby_clause = 189, 
		RULE_grouping_element_list = 190, RULE_grouping_element = 191, RULE_ordinary_grouping_set = 192, 
		RULE_ordinary_grouping_set_list = 193, RULE_rollup_list = 194, RULE_cube_list = 195, 
		RULE_empty_grouping_set = 196, RULE_having_clause = 197, RULE_row_value_predicand_list = 198, 
		RULE_query_expression = 199, RULE_query_expression_body = 200, RULE_non_join_query_expression = 201, 
		RULE_query_term = 202, RULE_non_join_query_term = 203, RULE_query_primary = 204, 
		RULE_non_join_query_primary = 205, RULE_simple_table = 206, RULE_explicit_table = 207, 
		RULE_table_or_query_name = 208, RULE_schema_qualified_name = 209, RULE_query_specification = 210, 
		RULE_select_list = 211, RULE_select_sublist = 212, RULE_derived_column = 213, 
		RULE_qualified_asterisk = 214, RULE_set_qualifier = 215, RULE_column_reference = 216, 
		RULE_as_clause = 217, RULE_over_clause = 218, RULE_column_reference_list = 219, 
		RULE_scalar_subquery = 220, RULE_row_subquery = 221, RULE_table_subquery = 222, 
		RULE_subquery = 223, RULE_predicate = 224, RULE_comparison_predicate = 225, 
		RULE_comp_op = 226, RULE_between_predicate = 227, RULE_between_predicate_part_2 = 228, 
		RULE_in_predicate = 229, RULE_in_predicate_value = 230, RULE_in_value_list = 231, 
		RULE_pattern_matching_predicate = 232, RULE_pattern_matcher = 233, RULE_negativable_matcher = 234, 
		RULE_regex_matcher = 235, RULE_null_predicate = 236, RULE_quantified_comparison_predicate = 237, 
		RULE_quantifier = 238, RULE_all = 239, RULE_some = 240, RULE_exists_predicate = 241, 
		RULE_unique_predicate = 242, RULE_primary_datetime_field = 243, RULE_non_second_primary_datetime_field = 244, 
		RULE_extended_datetime_field = 245, RULE_routine_invocation = 246, RULE_function_names_for_reserved_words = 247, 
		RULE_function_name = 248, RULE_sql_argument_list = 249, RULE_orderby_clause = 250, 
		RULE_sort_specifier_paren = 251, RULE_sort_specifier_list = 252, RULE_sort_specifier = 253, 
		RULE_order_specification = 254, RULE_limit_clause = 255, RULE_null_ordering = 256;
	public static final String[] ruleNames = {
		"sql", "statement", "schema_statement", "schema_create", "schema_alter", 
		"alter_function_statement", "alter_schema_statement", "alter_language_statement", 
		"alter_table_statement", "table_action", "attribute_option_value", "table_constraint_using_index", 
		"table_attribute_option", "function_action", "alter_default_privileges", 
		"abbreviated_grant_or_revoke", "alter_sequence_statement", "index_statement", 
		"create_extension_statement", "create_language_statement", "create_event_trigger", 
		"set_statement", "set_statement_value", "create_trigger_statement", "revoke_statement", 
		"revoke_from_cascade_restrict", "grant_statement", "grant_to_rule", "comment_on_statement", 
		"create_function_statement", "function_column_name_type", "function_parameters", 
		"function_def_value", "function_body", "function_arguments", "function_attribute", 
		"argmode", "function_definition", "functions_definition_schema", "create_sequence_statement", 
		"sequence_body", "create_schema_statement", "create_view_statement", "create_table_statement", 
		"table_body", "table_column_definition", "like_option", "table_constraint", 
		"column_constraint", "check_boolean_expression", "storage_parameter", 
		"with_storage_parameter", "storage_parameter_oid", "on_commit", "table_space", 
		"action", "index_parameters", "table_elements", "field_element", "field_type", 
		"param_clause", "param", "method_specifier", "table_space_specifier", 
		"table_space_name", "table_partitioning_clauses", "range_partitions", 
		"range_value_clause_list", "range_value_clause", "hash_partitions", "individual_hash_partitions", 
		"individual_hash_partition", "hash_partitions_by_quantity", "list_partitions", 
		"list_value_clause_list", "list_value_partition", "column_partitions", 
		"partition_by_columns", "partition_name", "drop_table_statement", "identifier", 
		"nonreserved_keywords", "unsigned_literal", "general_literal", "datetime_literal", 
		"time_literal", "timestamp_literal", "date_literal", "boolean_literal", 
		"data_type", "predefined_type", "regclass", "network_type", "character_string_type", 
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
		"array_expression", "common_value_expression", "numeric_value_expression", 
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
		"named_columns_join", "table_primary", "column_name_list", "alias_def", 
		"alias_table", "derived_table", "where_clause", "search_condition", "groupby_clause", 
		"grouping_element_list", "grouping_element", "ordinary_grouping_set", 
		"ordinary_grouping_set_list", "rollup_list", "cube_list", "empty_grouping_set", 
		"having_clause", "row_value_predicand_list", "query_expression", "query_expression_body", 
		"non_join_query_expression", "query_term", "non_join_query_term", "query_primary", 
		"non_join_query_primary", "simple_table", "explicit_table", "table_or_query_name", 
		"schema_qualified_name", "query_specification", "select_list", "select_sublist", 
		"derived_column", "qualified_asterisk", "set_qualifier", "column_reference", 
		"as_clause", "over_clause", "column_reference_list", "scalar_subquery", 
		"row_subquery", "table_subquery", "subquery", "predicate", "comparison_predicate", 
		"comp_op", "between_predicate", "between_predicate_part_2", "in_predicate", 
		"in_predicate_value", "in_value_list", "pattern_matching_predicate", "pattern_matcher", 
		"negativable_matcher", "regex_matcher", "null_predicate", "quantified_comparison_predicate", 
		"quantifier", "all", "some", "exists_predicate", "unique_predicate", "primary_datetime_field", 
		"non_second_primary_datetime_field", "extended_datetime_field", "routine_invocation", 
		"function_names_for_reserved_words", "function_name", "sql_argument_list", 
		"orderby_clause", "sort_specifier_paren", "sort_specifier_list", "sort_specifier", 
		"order_specification", "limit_clause", "null_ordering"
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
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALTER) | (1L << CREATE) | (1L << GRANT))) != 0) || _la==REVOKE || _la==COMMENT || _la==DROP || _la==SET) {
				{
				{
				setState(514); statement();
				setState(515); match(SEMI_COLON);
				}
				}
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(522); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(524); schema_statement();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 4, RULE_schema_statement);
		try {
			setState(529);
			switch (_input.LA(1)) {
			case CREATE:
			case GRANT:
			case REVOKE:
			case COMMENT:
			case SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(526); schema_create();
				}
				break;
			case ALTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(527); schema_alter();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 3);
				{
				setState(528); drop_table_statement();
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
		public Create_event_triggerContext create_event_trigger() {
			return getRuleContext(Create_event_triggerContext.class,0);
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
		enterRule(_localctx, 6, RULE_schema_create);
		try {
			setState(545);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(531); create_table_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(532); index_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(533); create_extension_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(534); create_trigger_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(535); create_function_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(536); create_sequence_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(537); create_schema_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(538); create_view_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(539); comment_on_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(540); revoke_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(541); set_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(542); grant_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(543); create_language_statement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(544); create_event_trigger();
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
		public Alter_sequence_statementContext alter_sequence_statement() {
			return getRuleContext(Alter_sequence_statementContext.class,0);
		}
		public Alter_language_statementContext alter_language_statement() {
			return getRuleContext(Alter_language_statementContext.class,0);
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
		enterRule(_localctx, 8, RULE_schema_alter);
		try {
			setState(553);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(547); alter_function_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(548); alter_schema_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(549); alter_language_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(550); alter_table_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(551); alter_default_privileges();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(552); alter_sequence_statement();
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
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
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
		enterRule(_localctx, 10, RULE_alter_function_statement);
		int _la;
		try {
			setState(587);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(555); match(ALTER);
				setState(556); match(FUNCTION);
				setState(557); function_parameters();
				setState(559); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(558); function_action();
					}
					}
					setState(561); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (ROWS - 96)) | (1L << (RETURNS - 96)) | (1L << (STRICT - 96)) | (1L << (CALLED - 96)) | (1L << (COST - 96)))) != 0) || _la==EXTERNAL || ((((_la - 242)) & ~0x3f) == 0 && ((1L << (_la - 242)) & ((1L << (RESET - 242)) | (1L << (SECURITY - 242)) | (1L << (SET - 242)) | (1L << (STABLE - 242)) | (1L << (VOLATILE - 242)))) != 0) );
				setState(564);
				_la = _input.LA(1);
				if (_la==RESTRICT) {
					{
					setState(563); match(RESTRICT);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(566); match(ALTER);
				setState(567); match(FUNCTION);
				setState(568); function_parameters();
				setState(569); match(RENAME);
				setState(570); match(TO);
				setState(571); ((Alter_function_statementContext)_localctx).new_name = schema_qualified_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(573); match(ALTER);
				setState(574); match(FUNCTION);
				setState(575); function_parameters();
				setState(576); match(OWNER);
				setState(577); match(TO);
				setState(578); ((Alter_function_statementContext)_localctx).new_owner = identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(580); match(ALTER);
				setState(581); match(FUNCTION);
				setState(582); function_parameters();
				setState(583); match(SET);
				setState(584); match(SCHEMA);
				setState(585); ((Alter_function_statementContext)_localctx).new_schema = schema_qualified_name();
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
		enterRule(_localctx, 12, RULE_alter_schema_statement);
		try {
			setState(603);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(589); match(ALTER);
				setState(590); match(SCHEMA);
				setState(591); ((Alter_schema_statementContext)_localctx).name = identifier();
				setState(592); match(RENAME);
				setState(593); match(TO);
				setState(594); ((Alter_schema_statementContext)_localctx).new_name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(596); match(ALTER);
				setState(597); match(SCHEMA);
				setState(598); ((Alter_schema_statementContext)_localctx).name = identifier();
				setState(599); match(OWNER);
				setState(600); match(TO);
				setState(601); ((Alter_schema_statementContext)_localctx).new_owner = identifier();
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
		enterRule(_localctx, 14, RULE_alter_language_statement);
		int _la;
		try {
			setState(625);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(605); match(ALTER);
				setState(607);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(606); match(PROCEDURAL);
					}
				}

				setState(609); match(LANGUAGE);
				setState(610); ((Alter_language_statementContext)_localctx).name = identifier();
				setState(611); match(RENAME);
				setState(612); match(TO);
				setState(613); ((Alter_language_statementContext)_localctx).new_name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(615); match(ALTER);
				setState(617);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(616); match(PROCEDURAL);
					}
				}

				setState(619); match(LANGUAGE);
				setState(620); ((Alter_language_statementContext)_localctx).name = identifier();
				setState(621); match(OWNER);
				setState(622); match(TO);
				setState(623); ((Alter_language_statementContext)_localctx).new_owner = identifier();
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
		enterRule(_localctx, 16, RULE_alter_table_statement);
		int _la;
		try {
			int _alt;
			setState(677);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(627); match(ALTER);
				setState(628); match(TABLE);
				setState(630);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(629); match(ONLY);
					}
					break;
				}
				setState(633); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(632); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(635); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(637); table_action();
				setState(642);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					{
					setState(638); match(COMMA);
					}
					setState(639); table_action();
					}
					}
					setState(644);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(645); match(ALTER);
				setState(646); match(TABLE);
				setState(648);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(647); match(ONLY);
					}
					break;
				}
				setState(651); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(650); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(653); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(655); match(RENAME);
				setState(657);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(656); match(COLUMN);
					}
					break;
				}
				setState(659); ((Alter_table_statementContext)_localctx).column = schema_qualified_name();
				setState(660); match(TO);
				setState(661); ((Alter_table_statementContext)_localctx).new_column = schema_qualified_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(663); match(ALTER);
				setState(664); match(TABLE);
				setState(665); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
				setState(666); match(RENAME);
				setState(667); match(TO);
				setState(668); ((Alter_table_statementContext)_localctx).new_name = schema_qualified_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(670); match(ALTER);
				setState(671); match(TABLE);
				setState(672); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
				setState(673); match(SET);
				setState(674); match(SCHEMA);
				setState(675); ((Alter_table_statementContext)_localctx).new_schema = schema_qualified_name();
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
		enterRule(_localctx, 18, RULE_table_action);
		int _la;
		try {
			setState(894);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(679); match(ADD);
				setState(681);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(680); match(COLUMN);
					}
					break;
				}
				setState(683); table_column_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(684); match(DROP);
				setState(686);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(685); match(COLUMN);
					}
					break;
				}
				setState(690);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(688); match(IF);
					setState(689); match(EXISTS);
					}
				}

				setState(692); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(694);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(693);
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
				setState(696); match(ALTER);
				setState(698);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(697); match(COLUMN);
					}
					break;
				}
				setState(700); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(703);
				_la = _input.LA(1);
				if (_la==SET) {
					{
					setState(701); match(SET);
					setState(702); match(DATA);
					}
				}

				setState(705); match(TYPE);
				setState(706); ((Table_actionContext)_localctx).datatype = data_type();
				setState(709);
				_la = _input.LA(1);
				if (_la==COLLATE) {
					{
					setState(707); match(COLLATE);
					setState(708); ((Table_actionContext)_localctx).collation = identifier();
					}
				}

				setState(713);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(711); match(USING);
					setState(712); ((Table_actionContext)_localctx).expression = value_expression();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(715); match(ALTER);
				setState(717);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(716); match(COLUMN);
					}
					break;
				}
				setState(719); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(720); match(SET);
				setState(721); match(DEFAULT);
				setState(722); ((Table_actionContext)_localctx).expression = value_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(724); match(ALTER);
				setState(726);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(725); match(COLUMN);
					}
					break;
				}
				setState(728); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(729); match(DROP);
				setState(730); match(DEFAULT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(732); match(ALTER);
				setState(734);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(733); match(COLUMN);
					}
					break;
				}
				setState(736); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(737); match(SET);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(739); match(DROP);
				setState(740); match(NOT);
				setState(741); match(NULL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(742); match(ALTER);
				setState(744);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(743); match(COLUMN);
					}
					break;
				}
				setState(746); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(747); match(SET);
				setState(748); match(STATISTICS);
				setState(749); ((Table_actionContext)_localctx).integer = match(NUMBER);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(751); match(ALTER);
				setState(753);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(752); match(COLUMN);
					}
					break;
				}
				setState(755); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(756); match(SET);
				setState(757); match(LEFT_PAREN);
				setState(758); attribute_option_value();
				setState(763);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(759); match(COMMA);
					setState(760); attribute_option_value();
					}
					}
					setState(765);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(766); match(RIGHT_PAREN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(768); match(ALTER);
				setState(770);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(769); match(COLUMN);
					}
					break;
				}
				setState(772); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(773); match(RESET);
				setState(774); match(LEFT_PAREN);
				setState(775); ((Table_actionContext)_localctx).table_attribute_option = table_attribute_option();
				((Table_actionContext)_localctx).attribute_option.add(((Table_actionContext)_localctx).table_attribute_option);
				setState(780);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(776); match(COMMA);
					setState(777); ((Table_actionContext)_localctx).table_attribute_option = table_attribute_option();
					((Table_actionContext)_localctx).attribute_option.add(((Table_actionContext)_localctx).table_attribute_option);
					}
					}
					setState(782);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(783); match(RIGHT_PAREN);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(785); match(ALTER);
				setState(787);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(786); match(COLUMN);
					}
					break;
				}
				setState(789); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(790); match(SET);
				setState(791); match(STORAGE);
				setState(792); match(PLAIN);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(794); match(EXTERNAL);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(795); match(EXTENDED);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(796); match(MAIN);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(797); match(ADD);
				setState(798); ((Table_actionContext)_localctx).tabl_constraint = table_constraint();
				setState(801);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(799); match(NOT);
					setState(800); match(VALID);
					}
				}

				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(803); match(ADD);
				setState(804); ((Table_actionContext)_localctx).tabl_constraint_using_index = table_constraint_using_index();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(805); match(VALIDATE);
				setState(806); match(CONSTRAINT);
				setState(807); ((Table_actionContext)_localctx).constraint_name = schema_qualified_name();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(808); match(DROP);
				setState(809); match(CONSTRAINT);
				setState(812);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(810); match(IF);
					setState(811); match(EXISTS);
					}
				}

				setState(814); ((Table_actionContext)_localctx).constraint_name = schema_qualified_name();
				setState(815);
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
				setState(817); match(DISABLE);
				setState(818); match(TRIGGER);
				setState(822);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(819); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
					}
					break;
				case 2:
					{
					setState(820); match(ALL);
					}
					break;
				case 3:
					{
					setState(821); match(USER);
					}
					break;
				}
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(824); match(ENABLE);
				setState(825); match(TRIGGER);
				setState(829);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(826); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
					}
					break;
				case 2:
					{
					setState(827); match(ALL);
					}
					break;
				case 3:
					{
					setState(828); match(USER);
					}
					break;
				}
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(831); match(ENABLE);
				setState(832); match(REPLICA);
				setState(833); match(TRIGGER);
				setState(834); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(835); match(ENABLE);
				setState(836); match(ALWAYS);
				setState(837); match(TRIGGER);
				setState(838); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(839); match(DISABLE);
				setState(840); match(RULE);
				setState(841); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(842); match(ENABLE);
				setState(843); match(RULE);
				setState(844); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(845); match(ENABLE);
				setState(846); match(REPLICA);
				setState(847); match(RULE);
				setState(848); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(849); match(ENABLE);
				setState(850); match(ALWAYS);
				setState(851); match(RULE);
				setState(852); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(853); match(CLUSTER);
				setState(854); match(ON);
				setState(855); ((Table_actionContext)_localctx).index_name = schema_qualified_name();
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(856); match(SET);
				setState(857); match(WITHOUT);
				setState(858); match(CLUSTER);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(859); match(SET);
				setState(860); match(WITH);
				setState(861); match(OIDS);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(862); match(SET);
				setState(863); match(WITHOUT);
				setState(864); match(OIDS);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(865); match(SET);
				setState(866); storage_parameter();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(867); match(RESET);
				setState(868); match(LEFT_PAREN);
				setState(869); with_storage_parameter();
				setState(874);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(870); match(COMMA);
					setState(871); with_storage_parameter();
					}
					}
					setState(876);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(877); match(RIGHT_PAREN);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(879); match(INHERIT);
				setState(880); ((Table_actionContext)_localctx).parent_table = schema_qualified_name();
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(881); match(NO);
				setState(882); match(INHERIT);
				setState(883); ((Table_actionContext)_localctx).parent_table = schema_qualified_name();
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(884); match(OF);
				setState(885); ((Table_actionContext)_localctx).type_name = schema_qualified_name();
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(886); match(NOT);
				setState(887); match(OF);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(888); match(OWNER);
				setState(889); match(TO);
				setState(890); ((Table_actionContext)_localctx).new_owner = schema_qualified_name();
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(891); match(SET);
				setState(892); match(TABLESPACE);
				setState(893); ((Table_actionContext)_localctx).new_tablespace = schema_qualified_name();
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
		enterRule(_localctx, 20, RULE_attribute_option_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(896); ((Attribute_option_valueContext)_localctx).attribute_option = table_attribute_option();
			setState(897); match(EQUAL);
			setState(898); ((Attribute_option_valueContext)_localctx).value = signed_numerical_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 22, RULE_table_constraint_using_index);
		int _la;
		try {
			setState(921);
			switch (_input.LA(1)) {
			case CONSTRAINT:
			case UNIQUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(902);
				_la = _input.LA(1);
				if (_la==CONSTRAINT) {
					{
					setState(900); match(CONSTRAINT);
					setState(901); ((Table_constraint_using_indexContext)_localctx).constraint_name = schema_qualified_name();
					}
				}

				setState(904); match(UNIQUE);
				}
				break;
			case PRIMARY:
				enterOuterAlt(_localctx, 2);
				{
				setState(905); match(PRIMARY);
				setState(906); match(KEY);
				setState(907); match(USING);
				setState(908); match(INDEX);
				setState(909); ((Table_constraint_using_indexContext)_localctx).index_name = schema_qualified_name();
				setState(913);
				switch (_input.LA(1)) {
				case DEFERRABLE:
					{
					setState(910); match(DEFERRABLE);
					}
					break;
				case NOT:
					{
					setState(911); match(NOT);
					setState(912); match(DEFERRABLE);
					}
					break;
				case INITIALLY:
				case SEMI_COLON:
				case COMMA:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(919);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(915); match(INITIALLY);
					setState(916); match(DEFERRED);
					}
					break;
				case 2:
					{
					setState(917); match(INITIALLY);
					setState(918); match(IMMEDIATE);
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
		enterRule(_localctx, 24, RULE_table_attribute_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(923);
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
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
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
		enterRule(_localctx, 26, RULE_function_action);
		int _la;
		try {
			setState(970);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(925); match(CALLED);
				setState(926); match(ON);
				setState(927); match(NULL);
				setState(928); match(INPUT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(929); match(RETURNS);
				setState(930); match(NULL);
				setState(931); match(ON);
				setState(932); match(NULL);
				setState(933); match(INPUT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(934); match(STRICT);
				setState(935); match(IMMUTABLE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(936); match(STABLE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(937); match(VOLATILE);
				setState(939);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(938); match(EXTERNAL);
					}
				}

				setState(941); match(SECURITY);
				setState(942); match(INVOKER);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(944);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(943); match(EXTERNAL);
					}
				}

				setState(946); match(SECURITY);
				setState(947); match(DEFINER);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(948); match(COST);
				setState(949); ((Function_actionContext)_localctx).execution_cost = match(NUMBER);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(950); match(ROWS);
				setState(951); ((Function_actionContext)_localctx).result_rows = match(NUMBER);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(952); match(SET);
				setState(953); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(959);
				switch (_input.LA(1)) {
				case TO:
					{
					setState(954); match(TO);
					setState(955); ((Function_actionContext)_localctx).value = identifier();
					}
					break;
				case EQUAL:
					{
					setState(956); match(EQUAL);
					setState(957); ((Function_actionContext)_localctx).value = identifier();
					}
					break;
				case DEFAULT:
					{
					setState(958); match(DEFAULT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(961); match(SET);
				setState(962); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(963); match(FROM);
				setState(964); match(CURRENT);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(966); match(RESET);
				setState(967); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(968); match(RESET);
				setState(969); match(ALL);
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

	public static class Alter_default_privilegesContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public List<IdentifierContext> target_role = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> schema_name = new ArrayList<IdentifierContext>();
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode USER() { return getToken(SQLParser.USER, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Abbreviated_grant_or_revokeContext abbreviated_grant_or_revoke() {
			return getRuleContext(Abbreviated_grant_or_revokeContext.class,0);
		}
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode PRIVILEGES() { return getToken(SQLParser.PRIVILEGES, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode ROLE() { return getToken(SQLParser.ROLE, 0); }
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
		enterRule(_localctx, 28, RULE_alter_default_privileges);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(972); match(ALTER);
			setState(973); match(DEFAULT);
			setState(974); match(PRIVILEGES);
			setState(985);
			_la = _input.LA(1);
			if (_la==FOR) {
				{
				setState(975); match(FOR);
				setState(976);
				_la = _input.LA(1);
				if ( !(_la==ROLE || _la==USER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(977); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
				((Alter_default_privilegesContext)_localctx).target_role.add(((Alter_default_privilegesContext)_localctx).identifier);
				setState(982);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(978); match(COMMA);
					setState(979); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
					((Alter_default_privilegesContext)_localctx).target_role.add(((Alter_default_privilegesContext)_localctx).identifier);
					}
					}
					setState(984);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(997);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(987); match(IN);
				setState(988); match(SCHEMA);
				setState(989); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
				((Alter_default_privilegesContext)_localctx).schema_name.add(((Alter_default_privilegesContext)_localctx).identifier);
				setState(994);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(990); match(COMMA);
					setState(991); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
					((Alter_default_privilegesContext)_localctx).schema_name.add(((Alter_default_privilegesContext)_localctx).identifier);
					}
					}
					setState(996);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(999); abbreviated_grant_or_revoke();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 30, RULE_abbreviated_grant_or_revoke);
		int _la;
		try {
			setState(1137);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1001); match(GRANT);
				setState(1014);
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
					setState(1002);
					_la = _input.LA(1);
					if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1007);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1003); match(COMMA);
						setState(1004);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1009);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(1010); match(ALL);
					setState(1012);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1011); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1016); match(ON);
				setState(1017); match(TABLES);
				setState(1018); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1019); match(GRANT);
				setState(1032);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					{
					setState(1020);
					_la = _input.LA(1);
					if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1025);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1021); match(COMMA);
						setState(1022);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1027);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(1028); match(ALL);
					setState(1030);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1029); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1034); match(ON);
				setState(1035); match(SEQUENCES);
				setState(1036); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1037); match(GRANT);
				setState(1043);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1038); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1039); match(ALL);
					setState(1041);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1040); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1045); match(ON);
				setState(1046); match(FUNCTIONS);
				setState(1047); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1048); match(GRANT);
				setState(1054);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1049); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1050); match(ALL);
					setState(1052);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1051); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1056); match(ON);
				setState(1057); match(TYPES);
				setState(1058); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1059); match(REVOKE);
				setState(1063);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1060); match(GRANT);
					setState(1061); match(OPTION);
					setState(1062); match(FOR);
					}
				}

				setState(1077);
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
					setState(1065);
					_la = _input.LA(1);
					if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1070);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1066); match(COMMA);
						setState(1067);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1072);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(1073); match(ALL);
					setState(1075);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1074); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1079); match(ON);
				setState(1080); match(TABLES);
				setState(1081); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1082); match(REVOKE);
				setState(1086);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1083); match(GRANT);
					setState(1084); match(OPTION);
					setState(1085); match(FOR);
					}
				}

				setState(1100);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					{
					setState(1088);
					_la = _input.LA(1);
					if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1093);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1089); match(COMMA);
						setState(1090);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1095);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
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
				setState(1103); match(SEQUENCES);
				setState(1104); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1105); match(REVOKE);
				setState(1109);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1106); match(GRANT);
					setState(1107); match(OPTION);
					setState(1108); match(FOR);
					}
				}

				setState(1116);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1111); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1112); match(ALL);
					setState(1114);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1113); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1118); match(ON);
				setState(1119); match(FUNCTIONS);
				setState(1120); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1121); match(REVOKE);
				setState(1125);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1122); match(GRANT);
					setState(1123); match(OPTION);
					setState(1124); match(FOR);
					}
				}

				setState(1132);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1127); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1128); match(ALL);
					setState(1130);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1129); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1134); match(ON);
				setState(1135); match(TYPES);
				setState(1136); revoke_from_cascade_restrict();
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
		public Schema_qualified_nameContext new_owner;
		public Schema_qualified_nameContext new_name;
		public Schema_qualified_nameContext new_schema;
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode SCHEMA() { return getToken(SQLParser.SCHEMA, 0); }
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
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
		public List<Schema_qualified_nameContext> schema_qualified_name() {
			return getRuleContexts(Schema_qualified_nameContext.class);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
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
		enterRule(_localctx, 32, RULE_alter_sequence_statement);
		int _la;
		try {
			setState(1192);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1139); match(ALTER);
				setState(1140); match(SEQUENCE);
				setState(1143);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1141); match(IF);
					setState(1142); match(EXISTS);
					}
				}

				setState(1145); ((Alter_sequence_statementContext)_localctx).name = schema_qualified_name();
				setState(1156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OWNED || _la==CACHE || ((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (CYCLE - 160)) | (1L << (INCREMENT - 160)) | (1L << (MAXVALUE - 160)) | (1L << (MINVALUE - 160)) | (1L << (NO - 160)))) != 0) || _la==RESTART || _la==START) {
					{
					setState(1154);
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
						setState(1146); sequence_body();
						}
						break;
					case RESTART:
						{
						setState(1147); match(RESTART);
						setState(1152);
						switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
						case 1:
							{
							setState(1149);
							_la = _input.LA(1);
							if (_la==WITH) {
								{
								setState(1148); match(WITH);
								}
							}

							setState(1151); ((Alter_sequence_statementContext)_localctx).restart = identifier();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(1158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1159); match(ALTER);
				setState(1160); match(SEQUENCE);
				setState(1163);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1161); match(IF);
					setState(1162); match(EXISTS);
					}
				}

				setState(1165); ((Alter_sequence_statementContext)_localctx).name = schema_qualified_name();
				setState(1166); match(OWNER);
				setState(1167); match(TO);
				setState(1168); ((Alter_sequence_statementContext)_localctx).new_owner = schema_qualified_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1170); match(ALTER);
				setState(1171); match(SEQUENCE);
				setState(1174);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1172); match(IF);
					setState(1173); match(EXISTS);
					}
				}

				setState(1176); ((Alter_sequence_statementContext)_localctx).name = schema_qualified_name();
				setState(1177); match(RENAME);
				setState(1178); match(TO);
				setState(1179); ((Alter_sequence_statementContext)_localctx).new_name = schema_qualified_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1181); match(ALTER);
				setState(1182); match(SEQUENCE);
				setState(1185);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1183); match(IF);
					setState(1184); match(EXISTS);
					}
				}

				setState(1187); ((Alter_sequence_statementContext)_localctx).name = schema_qualified_name();
				setState(1188); match(SET);
				setState(1189); match(SCHEMA);
				setState(1190); ((Alter_sequence_statementContext)_localctx).new_schema = schema_qualified_name();
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
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
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
		enterRule(_localctx, 34, RULE_index_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1194); match(CREATE);
			setState(1196);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(1195); match(UNIQUE);
				}
			}

			setState(1198); match(INDEX);
			setState(1200);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				{
				setState(1199); match(CONCURRENTLY);
				}
				break;
			}
			setState(1203);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				{
				setState(1202); ((Index_statementContext)_localctx).name = schema_qualified_name();
				}
				break;
			}
			setState(1205); match(ON);
			setState(1206); ((Index_statementContext)_localctx).table_name = schema_qualified_name();
			setState(1209);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(1207); match(USING);
				setState(1208); ((Index_statementContext)_localctx).method = schema_qualified_name();
				}
			}

			setState(1211); sort_specifier_paren();
			setState(1213);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1212); param_clause();
				}
			}

			setState(1217);
			_la = _input.LA(1);
			if (_la==TABLESPACE) {
				{
				setState(1215); match(TABLESPACE);
				setState(1216); ((Index_statementContext)_localctx).tablespace_name = schema_qualified_name();
				}
			}

			setState(1221);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1219); match(WHERE);
				setState(1220); ((Index_statementContext)_localctx).predic = boolean_value_expression();
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
		enterRule(_localctx, 36, RULE_create_extension_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1223); match(CREATE);
			setState(1224); match(EXTENSION);
			setState(1228);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1225); match(IF);
				setState(1226); match(NOT);
				setState(1227); match(EXISTS);
				}
			}

			setState(1230); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(1232);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1231); match(WITH);
				}
			}

			setState(1236);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(1234); match(SCHEMA);
				setState(1235); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(1240);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(1238); match(VERSION);
				setState(1239); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(1244);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(1242); match(FROM);
				setState(1243); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
		enterRule(_localctx, 38, RULE_create_language_statement);
		int _la;
		try {
			setState(1279);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1246); match(CREATE);
				setState(1249);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(1247); match(OR);
					setState(1248); match(REPLACE);
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
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1256); match(CREATE);
				setState(1259);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(1257); match(OR);
					setState(1258); match(REPLACE);
					}
				}

				setState(1262);
				_la = _input.LA(1);
				if (_la==TRUSTED) {
					{
					setState(1261); match(TRUSTED);
					}
				}

				setState(1265);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1264); match(PROCEDURAL);
					}
				}

				setState(1267); match(LANGUAGE);
				setState(1268); ((Create_language_statementContext)_localctx).name = identifier();
				setState(1269); match(HANDLER);
				setState(1270); ((Create_language_statementContext)_localctx).call_handler = schema_qualified_name();
				setState(1273);
				_la = _input.LA(1);
				if (_la==INLINE) {
					{
					setState(1271); match(INLINE);
					setState(1272); ((Create_language_statementContext)_localctx).inline_handler = schema_qualified_name();
					}
				}

				setState(1277);
				_la = _input.LA(1);
				if (_la==VALIDATOR) {
					{
					setState(1275); match(VALIDATOR);
					setState(1276); ((Create_language_statementContext)_localctx).valfunction = schema_qualified_name();
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

	public static class Create_event_triggerContext extends ParserRuleContext {
		public Schema_qualified_nameContext name;
		public Schema_qualified_nameContext event;
		public Schema_qualified_nameContext filter_variable;
		public Token Character_String_Literal;
		public List<Token> filter_value = new ArrayList<Token>();
		public Value_expressionContext funct_name;
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
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
		enterRule(_localctx, 40, RULE_create_event_trigger);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1281); match(CREATE);
			setState(1282); match(EVENT);
			setState(1283); match(TRIGGER);
			setState(1284); ((Create_event_triggerContext)_localctx).name = schema_qualified_name();
			setState(1285); match(ON);
			setState(1286); ((Create_event_triggerContext)_localctx).event = schema_qualified_name();
			setState(1307);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(1287); match(WHEN);
				setState(1288); ((Create_event_triggerContext)_localctx).filter_variable = schema_qualified_name();
				setState(1303); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1289); match(IN);
					setState(1290); match(LEFT_PAREN);
					setState(1291); ((Create_event_triggerContext)_localctx).Character_String_Literal = match(Character_String_Literal);
					((Create_event_triggerContext)_localctx).filter_value.add(((Create_event_triggerContext)_localctx).Character_String_Literal);
					setState(1296);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1292); match(COMMA);
						setState(1293); ((Create_event_triggerContext)_localctx).Character_String_Literal = match(Character_String_Literal);
						((Create_event_triggerContext)_localctx).filter_value.add(((Create_event_triggerContext)_localctx).Character_String_Literal);
						}
						}
						setState(1298);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1299); match(RIGHT_PAREN);
					setState(1301);
					_la = _input.LA(1);
					if (_la==AND) {
						{
						setState(1300); match(AND);
						}
					}

					}
					}
					setState(1305); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IN );
				}
			}

			setState(1309); match(EXECUTE);
			setState(1310); match(PROCEDURE);
			setState(1311); ((Create_event_triggerContext)_localctx).funct_name = value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 42, RULE_set_statement);
		int _la;
		try {
			setState(1349);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1313); match(SET);
				setState(1315);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(1314);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1317); ((Set_statementContext)_localctx).config_param = identifier();
				setState(1318);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1319); set_statement_value();
				setState(1324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1320); match(COMMA);
					setState(1321); set_statement_value();
					}
					}
					setState(1326);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1327); match(SET);
				setState(1329);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(1328);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1331); match(TIME);
				setState(1332); match(ZONE);
				setState(1336);
				switch (_input.LA(1)) {
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
					setState(1333); ((Set_statementContext)_localctx).timezone = identifier();
					}
					break;
				case LOCAL:
					{
					setState(1334); match(LOCAL);
					}
					break;
				case DEFAULT:
					{
					setState(1335); match(DEFAULT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1338); match(COMMA);
					setState(1342);
					switch (_input.LA(1)) {
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
						setState(1339); ((Set_statementContext)_localctx).timezone = identifier();
						}
						break;
					case LOCAL:
						{
						setState(1340); match(LOCAL);
						}
						break;
					case DEFAULT:
						{
						setState(1341); match(DEFAULT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(1348);
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
		enterRule(_localctx, 44, RULE_set_statement_value);
		try {
			setState(1357);
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
				setState(1351); ((Set_statement_valueContext)_localctx).value = value_expression();
				}
				break;
			case QUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1352); match(QUOTE);
				setState(1353); ((Set_statement_valueContext)_localctx).value = value_expression();
				setState(1354); match(QUOTE);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1356); match(DEFAULT);
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
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
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
		enterRule(_localctx, 46, RULE_create_trigger_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1359); match(CREATE);
			setState(1361);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1360); match(CONSTRAINT);
				}
			}

			setState(1363); match(TRIGGER);
			setState(1364); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(1369);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(1365); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(1366); match(INSTEAD);
				setState(1367); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(1368); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1391); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1386);
				switch (_input.LA(1)) {
				case INSERT:
					{
					setState(1371); match(INSERT);
					}
					break;
				case DELETE:
					{
					setState(1372); match(DELETE);
					}
					break;
				case TRUNCATE:
					{
					setState(1373); match(TRUNCATE);
					}
					break;
				case UPDATE:
					{
					{
					setState(1374); match(UPDATE);
					setState(1384);
					_la = _input.LA(1);
					if (_la==OF) {
						{
						setState(1375); match(OF);
						setState(1376); ((Create_trigger_statementContext)_localctx).identifier = identifier();
						((Create_trigger_statementContext)_localctx).columnName.add(((Create_trigger_statementContext)_localctx).identifier);
						setState(1381);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1377); match(COMMA);
							setState(1378); ((Create_trigger_statementContext)_localctx).identifier = identifier();
							((Create_trigger_statementContext)_localctx).columnName.add(((Create_trigger_statementContext)_localctx).identifier);
							}
							}
							setState(1383);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1389);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(1388); match(OR);
					}
				}

				}
				}
				setState(1393); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DELETE || _la==TRUNCATE || _la==UPDATE || _la==INSERT );
			setState(1395); match(ON);
			setState(1396); ((Create_trigger_statementContext)_localctx).tabl_name = schema_qualified_name();
			setState(1399);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(1397); match(FROM);
				setState(1398); ((Create_trigger_statementContext)_localctx).referenced_table_name = schema_qualified_name();
				}
			}

			setState(1410);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				{
				setState(1401); match(NOT);
				setState(1402); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(1404);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(1403); match(DEFERRABLE);
					}
				}

				{
				setState(1406); match(INITIALLY);
				setState(1407); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(1408); match(INITIALLY);
				setState(1409); match(DEFERRED);
				}
				}
				break;
			}
			setState(1418);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(1412); match(FOR);
				setState(1414);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(1413); match(EACH);
					}
				}

				setState(1416); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(1417); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1422);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(1420); match(WHEN);
				{
				setState(1421); boolean_value_expression();
				}
				}
			}

			setState(1424); match(EXECUTE);
			setState(1425); match(PROCEDURE);
			setState(1426); ((Create_trigger_statementContext)_localctx).func_name = schema_qualified_name();
			setState(1427); match(LEFT_PAREN);
			setState(1429);
			_la = _input.LA(1);
			if (((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0)) {
				{
				setState(1428); ((Create_trigger_statementContext)_localctx).identifier = identifier();
				((Create_trigger_statementContext)_localctx).arguments.add(((Create_trigger_statementContext)_localctx).identifier);
				}
			}

			setState(1435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1431); match(COMMA);
				setState(1432); ((Create_trigger_statementContext)_localctx).identifier = identifier();
				((Create_trigger_statementContext)_localctx).arguments.add(((Create_trigger_statementContext)_localctx).identifier);
				}
				}
				setState(1437);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1438); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 48, RULE_revoke_statement);
		int _la;
		try {
			setState(1822);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1440); match(REVOKE);
				setState(1444);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1441); match(GRANT);
					setState(1442); match(OPTION);
					setState(1443); match(FOR);
					}
				}

				setState(1458);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1446);
					_la = _input.LA(1);
					if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1451);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1447); match(COMMA);
						setState(1448);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1453);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ALL:
					{
					setState(1454); match(ALL);
					setState(1456);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1455); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1460); match(ON);
				setState(1478);
				switch (_input.LA(1)) {
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
					setState(1465); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1462);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1461); match(TABLE);
							}
						}

						setState(1464); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
						((Revoke_statementContext)_localctx).table_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
						}
						}
						setState(1467); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (TABLE - 114)) | (1L << (ADMIN - 114)) | (1L << (ALWAYS - 114)) | (1L << (ARRAY - 114)) | (1L << (AVG - 114)) | (1L << (BETWEEN - 114)) | (1L << (BY - 114)) | (1L << (CACHE - 114)) | (1L << (CALLED - 114)) | (1L << (CLASS - 114)) | (1L << (CENTURY - 114)) | (1L << (CHARACTER - 114)) | (1L << (CHECK - 114)) | (1L << (CLUSTER - 114)) | (1L << (COLLECT - 114)) | (1L << (COALESCE - 114)) | (1L << (COLUMN - 114)) | (1L << (COMMENT - 114)) | (1L << (COMMENTS - 114)) | (1L << (COMMIT - 114)) | (1L << (CONCURRENTLY - 114)) | (1L << (CONFIGURATION - 114)) | (1L << (COST - 114)) | (1L << (COUNT - 114)) | (1L << (CUBE - 114)) | (1L << (CURRENT - 114)) | (1L << (CYCLE - 114)) | (1L << (DATA - 114)) | (1L << (DAY - 114)) | (1L << (DEC - 114)) | (1L << (DECADE - 114)) | (1L << (DEFINER - 114)) | (1L << (DICTIONARY - 114)) | (1L << (DISABLE - 114)) | (1L << (DOW - 114)) | (1L << (DOY - 114)) | (1L << (DROP - 114)) | (1L << (ENABLE - 114)) | (1L << (EPOCH - 114)) | (1L << (EVENT - 114)) | (1L << (EVERY - 114)) | (1L << (EXISTS - 114)) | (1L << (EXTENDED - 114)) | (1L << (EXTERNAL - 114)))) != 0) || ((((_la - 178)) & ~0x3f) == 0 && ((1L << (_la - 178)) & ((1L << (EXTRACT - 178)) | (1L << (FAMILY - 178)) | (1L << (FILTER - 178)) | (1L << (FIRST - 178)) | (1L << (FORMAT - 178)) | (1L << (FUSION - 178)) | (1L << (GROUPING - 178)) | (1L << (HASH - 178)) | (1L << (INHERIT - 178)) | (1L << (INDEX - 178)) | (1L << (INCREMENT - 178)) | (1L << (INPUT - 178)) | (1L << (INSERT - 178)) | (1L << (INTERSECTION - 178)) | (1L << (ISCACHABLE - 178)) | (1L << (ISODOW - 178)) | (1L << (ISOYEAR - 178)) | (1L << (ISSTRICT - 178)) | (1L << (LANGUAGE - 178)) | (1L << (LARGE - 178)) | (1L << (LAST - 178)) | (1L << (LESS - 178)) | (1L << (LIST - 178)) | (1L << (LOCATION - 178)) | (1L << (MAIN - 178)) | (1L << (MATCH - 178)) | (1L << (MAX - 178)) | (1L << (MAXVALUE - 178)) | (1L << (MICROSECONDS - 178)) | (1L << (MILLENNIUM - 178)) | (1L << (MILLISECONDS - 178)) | (1L << (MIN - 178)) | (1L << (MINVALUE - 178)) | (1L << (MINUTE - 178)) | (1L << (MONTH - 178)) | (1L << (NATIONAL - 178)) | (1L << (NO - 178)) | (1L << (NONE - 178)) | (1L << (NULLIF - 178)) | (1L << (OBJECT - 178)) | (1L << (ON - 178)) | (1L << (ONLY - 178)) | (1L << (OPTION - 178)) | (1L << (OPTIONS - 178)) | (1L << (OVER - 178)) | (1L << (OVERWRITE - 178)) | (1L << (PARSER - 178)) | (1L << (PARTIAL - 178)) | (1L << (PARTITION - 178)) | (1L << (PARTITIONS - 178)) | (1L << (PLAIN - 178)) | (1L << (PRECISION - 178)) | (1L << (PUBLIC - 178)) | (1L << (PURGE - 178)) | (1L << (QUARTER - 178)) | (1L << (RANGE - 178)) | (1L << (REGCONFIG - 178)) | (1L << (REGEXP - 178)) | (1L << (RENAME - 178)) | (1L << (REPLICA - 178)))) != 0) || ((((_la - 242)) & ~0x3f) == 0 && ((1L << (_la - 242)) & ((1L << (RESET - 242)) | (1L << (RESTART - 242)) | (1L << (RLIKE - 242)) | (1L << (ROLLUP - 242)) | (1L << (SEARCH - 242)) | (1L << (SECOND - 242)) | (1L << (SECURITY - 242)) | (1L << (SERVER - 242)) | (1L << (SET - 242)) | (1L << (SIMILAR - 242)) | (1L << (SIMPLE - 242)) | (1L << (STABLE - 242)) | (1L << (START - 242)) | (1L << (STATISTICS - 242)) | (1L << (STORAGE - 242)) | (1L << (STDDEV_POP - 242)) | (1L << (STDDEV_SAMP - 242)) | (1L << (SUBPARTITION - 242)) | (1L << (SUM - 242)) | (1L << (TABLESPACE - 242)) | (1L << (TEMPLATE - 242)) | (1L << (THAN - 242)) | (1L << (TIMEZONE - 242)) | (1L << (TIMEZONE_HOUR - 242)) | (1L << (TIMEZONE_MINUTE - 242)) | (1L << (TRIM - 242)) | (1L << (TO - 242)) | (1L << (TYPE - 242)) | (1L << (TYPES - 242)) | (1L << (UNKNOWN - 242)) | (1L << (UNLOGGED - 242)) | (1L << (USER - 242)) | (1L << (VALID - 242)) | (1L << (VALIDATE - 242)) | (1L << (VALUES - 242)) | (1L << (VAR_SAMP - 242)) | (1L << (VAR_POP - 242)) | (1L << (VARYING - 242)) | (1L << (VERSION - 242)) | (1L << (VOLATILE - 242)) | (1L << (WEEK - 242)) | (1L << (WINDOW - 242)) | (1L << (WRAPPER - 242)) | (1L << (YEAR - 242)) | (1L << (ZONE - 242)) | (1L << (BOOLEAN - 242)) | (1L << (BOOL - 242)) | (1L << (BIT - 242)) | (1L << (VARBIT - 242)) | (1L << (INT1 - 242)) | (1L << (INT2 - 242)) | (1L << (INT4 - 242)) | (1L << (INT8 - 242)) | (1L << (TINYINT - 242)) | (1L << (SMALLINT - 242)) | (1L << (INT - 242)) | (1L << (INTEGER - 242)) | (1L << (BIGINT - 242)) | (1L << (FLOAT4 - 242)) | (1L << (FLOAT8 - 242)) | (1L << (REAL - 242)) | (1L << (FLOAT - 242)))) != 0) || ((((_la - 306)) & ~0x3f) == 0 && ((1L << (_la - 306)) & ((1L << (DOUBLE - 306)) | (1L << (NUMERIC - 306)) | (1L << (DECIMAL - 306)) | (1L << (CHAR - 306)) | (1L << (VARCHAR - 306)) | (1L << (NCHAR - 306)) | (1L << (NVARCHAR - 306)) | (1L << (DATE - 306)) | (1L << (TIME - 306)) | (1L << (TIMETZ - 306)) | (1L << (TIMESTAMP - 306)) | (1L << (TIMESTAMPTZ - 306)) | (1L << (TEXT - 306)) | (1L << (UUID - 306)) | (1L << (VARBINARY - 306)) | (1L << (BLOB - 306)) | (1L << (BYTEA - 306)) | (1L << (INET4 - 306)) | (1L << (INET - 306)) | (1L << (INTERVAL - 306)) | (1L << (VOID - 306)) | (1L << (DOUBLE_QUOTE - 306)) | (1L << (Identifier - 306)) | (1L << (QuotedIdentifier - 306)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1469); match(ALL);
					setState(1470); match(TABLES);
					setState(1471); match(IN);
					setState(1472); match(SCHEMA);
					setState(1474); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1473); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
						}
						}
						setState(1476); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1480); revoke_from_cascade_restrict();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1482); match(REVOKE);
				setState(1486);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1483); match(GRANT);
					setState(1484); match(OPTION);
					setState(1485); match(FOR);
					}
				}

				setState(1519);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1500); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1488);
						_la = _input.LA(1);
						if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1489); match(LEFT_PAREN);
						setState(1490); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
						setState(1495);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1491); match(COMMA);
							setState(1492); ((Revoke_statementContext)_localctx).identifier = identifier();
							((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
							}
							}
							setState(1497);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1498); match(RIGHT_PAREN);
						}
						}
						setState(1502); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1504); match(ALL);
					setState(1506);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1505); match(PRIVILEGES);
						}
					}

					setState(1508); match(LEFT_PAREN);
					setState(1509); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
					setState(1514);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1510); match(COMMA);
						setState(1511); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
						}
						}
						setState(1516);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1517); match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1521); match(ON);
				setState(1523);
				_la = _input.LA(1);
				if (_la==TABLE) {
					{
					setState(1522); match(TABLE);
					}
				}

				setState(1525); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
				((Revoke_statementContext)_localctx).table_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
				setState(1530);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1526); match(COMMA);
					setState(1527); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
					((Revoke_statementContext)_localctx).table_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
					}
					}
					setState(1532);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1533); revoke_from_cascade_restrict();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1535); match(REVOKE);
				setState(1539);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1536); match(GRANT);
					setState(1537); match(OPTION);
					setState(1538); match(FOR);
					}
				}

				setState(1550);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(1542); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1541);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1544); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1546); match(ALL);
					setState(1548);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1547); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1552); match(ON);
				setState(1574);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1553); match(SEQUENCE);
					setState(1554); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
					((Revoke_statementContext)_localctx).sequence_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
					setState(1559);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1555); match(COMMA);
						setState(1556); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
						((Revoke_statementContext)_localctx).sequence_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
						}
						}
						setState(1561);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ALL:
					{
					setState(1562); match(ALL);
					setState(1563); match(SEQUENCES);
					setState(1564); match(IN);
					setState(1565); match(SCHEMA);
					setState(1566); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
					setState(1571);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1567); match(COMMA);
						setState(1568); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
						}
						}
						setState(1573);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1576); revoke_from_cascade_restrict();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1578); match(REVOKE);
				setState(1582);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1579); match(GRANT);
					setState(1580); match(OPTION);
					setState(1581); match(FOR);
					}
				}

				setState(1593);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1585); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1584);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1587); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(1589); match(ALL);
					setState(1591);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1590); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1595); match(ON);
				setState(1596); match(DATABASE);
				setState(1597); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).database_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1602);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1598); match(COMMA);
					setState(1599); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).database_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1604);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1605); revoke_from_cascade_restrict();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1607); match(REVOKE);
				setState(1611);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1608); match(GRANT);
					setState(1609); match(OPTION);
					setState(1610); match(FOR);
					}
				}

				setState(1618);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1613); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1614); match(ALL);
					setState(1616);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1615); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1620); match(ON);
				setState(1621); match(FOREIGN);
				setState(1622); match(DATA);
				setState(1623); match(WRAPPER);
				setState(1624); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
				((Revoke_statementContext)_localctx).fdw_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
				setState(1629);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1625); match(COMMA);
					setState(1626); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
					((Revoke_statementContext)_localctx).fdw_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
					}
					}
					setState(1631);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1632); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1634); match(REVOKE);
				setState(1638);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1635); match(GRANT);
					setState(1636); match(OPTION);
					setState(1637); match(FOR);
					}
				}

				setState(1645);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1640); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1641); match(ALL);
					setState(1643);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1642); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1647); match(ON);
				setState(1648); match(FOREIGN);
				setState(1649); match(SERVER);
				setState(1650); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).server_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1651); match(COMMA);
					setState(1652); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).server_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1657);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1658); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1660); match(REVOKE);
				setState(1664);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1661); match(GRANT);
					setState(1662); match(OPTION);
					setState(1663); match(FOR);
					}
				}

				setState(1671);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1666); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1667); match(ALL);
					setState(1669);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1668); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1673); match(ON);
				setState(1676);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1674); function_definition();
					}
					break;
				case ALL:
					{
					setState(1675); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1678); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1680); match(REVOKE);
				setState(1684);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1681); match(GRANT);
					setState(1682); match(OPTION);
					setState(1683); match(FOR);
					}
				}

				setState(1691);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1686); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1687); match(ALL);
					setState(1689);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1688); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1693); match(ON);
				setState(1694); match(LANGUAGE);
				setState(1695); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).lang_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1696); match(COMMA);
					setState(1697); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).lang_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1702);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1703); revoke_from_cascade_restrict();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1705); match(REVOKE);
				setState(1709);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1706); match(GRANT);
					setState(1707); match(OPTION);
					setState(1708); match(FOR);
					}
				}

				setState(1724);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1716); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(1716);
						switch (_input.LA(1)) {
						case SELECT:
							{
							setState(1711); match(SELECT);
							}
							break;
						case UPDATE:
							{
							setState(1712); match(UPDATE);
							setState(1714);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1713); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(1718); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1720); match(ALL);
					setState(1722);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1721); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1726); match(ON);
				setState(1727); match(LARGE);
				setState(1728); match(OBJECT);
				setState(1729); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).loid.add(((Revoke_statementContext)_localctx).identifier);
				setState(1734);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1730); match(COMMA);
					setState(1731); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).loid.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1736);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1737); revoke_from_cascade_restrict();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1739); match(REVOKE);
				setState(1743);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1740); match(GRANT);
					setState(1741); match(OPTION);
					setState(1742); match(FOR);
					}
				}

				setState(1757);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1749); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1745);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1747);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1746); match(COMMA);
							}
						}

						}
						}
						setState(1751); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1753); match(ALL);
					setState(1755);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1754); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1759); match(ON);
				setState(1760); match(SCHEMA);
				setState(1761); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1766);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1762); match(COMMA);
					setState(1763); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1768);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1769); revoke_from_cascade_restrict();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1771); match(REVOKE);
				setState(1775);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1772); match(GRANT);
					setState(1773); match(OPTION);
					setState(1774); match(FOR);
					}
				}

				setState(1782);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1777); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1778); match(ALL);
					setState(1780);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1779); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1784); match(ON);
				setState(1785); match(TABLESPACE);
				setState(1786); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).tablespace_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1791);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1787); match(COMMA);
					setState(1788); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).tablespace_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1793);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1794); revoke_from_cascade_restrict();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1796); match(REVOKE);
				setState(1800);
				switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
				case 1:
					{
					setState(1797); match(ADMIN);
					setState(1798); match(OPTION);
					setState(1799); match(FOR);
					}
					break;
				}
				setState(1802); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1807);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1803); match(COMMA);
					setState(1804); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1809);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1810); match(FROM);
				setState(1811); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1816);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1812); match(COMMA);
					setState(1813); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1818);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1820);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(1819);
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
		enterRule(_localctx, 50, RULE_revoke_from_cascade_restrict);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1824); match(FROM);
			setState(1830);
			switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
			case 1:
				{
				setState(1826);
				_la = _input.LA(1);
				if (_la==GROUP) {
					{
					setState(1825); match(GROUP);
					}
				}

				setState(1828); ((Revoke_from_cascade_restrictContext)_localctx).identifier = identifier();
				((Revoke_from_cascade_restrictContext)_localctx).role_name.add(((Revoke_from_cascade_restrictContext)_localctx).identifier);
				}
				break;
			case 2:
				{
				setState(1829); match(PUBLIC);
				}
				break;
			}
			setState(1842);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1832); match(COMMA);
				setState(1838);
				switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
				case 1:
					{
					setState(1834);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1833); match(GROUP);
						}
					}

					setState(1836); ((Revoke_from_cascade_restrictContext)_localctx).identifier = identifier();
					((Revoke_from_cascade_restrictContext)_localctx).role_name.add(((Revoke_from_cascade_restrictContext)_localctx).identifier);
					}
					break;
				case 2:
					{
					setState(1837); match(PUBLIC);
					}
					break;
				}
				}
				}
				setState(1844);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1846);
			_la = _input.LA(1);
			if (_la==CASCADE || _la==RESTRICT) {
				{
				setState(1845);
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
		enterRule(_localctx, 52, RULE_grant_statement);
		int _la;
		try {
			int _alt;
			setState(2180);
			switch ( getInterpreter().adaptivePredict(_input,262,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1848); match(GRANT);
				setState(1861);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1849);
					_la = _input.LA(1);
					if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1854);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1850); match(COMMA);
						setState(1851);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1856);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ALL:
					{
					setState(1857); match(ALL);
					setState(1859);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1858); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1863); match(ON);
				setState(1887);
				switch (_input.LA(1)) {
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
					setState(1865);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1864); match(TABLE);
						}
					}

					setState(1871); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1867); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
							setState(1869);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1868); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1873); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,211,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(1875); match(ALL);
					setState(1876); match(TABLES);
					setState(1877); match(IN);
					setState(1878); match(SCHEMA);
					setState(1883); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1879); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(1881);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1880); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1885); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,213,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1889); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1891); match(GRANT);
				setState(1917);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1901); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1892);
						_la = _input.LA(1);
						if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1893); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
						setState(1898);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1894); match(COMMA);
							setState(1895); ((Grant_statementContext)_localctx).identifier = identifier();
							((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
							}
							}
							setState(1900);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						setState(1903); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1905); match(ALL);
					setState(1907);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1906); match(PRIVILEGES);
						}
					}

					setState(1909); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
					setState(1914);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1910); match(COMMA);
						setState(1911); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
						}
						}
						setState(1916);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1919); match(ON);
				setState(1927); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1921);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1920); match(TABLE);
							}
						}

						setState(1923); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
						setState(1925);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1924); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1929); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,222,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1931); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1933); match(GRANT);
				setState(1946);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					{
					setState(1934);
					_la = _input.LA(1);
					if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1939);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1935); match(COMMA);
						setState(1936);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1941);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(1942); match(ALL);
					setState(1944);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1943); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1948); match(ON);
				setState(1974);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1958); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1949); match(SEQUENCE);
						setState(1950); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).sequence_name.add(((Grant_statementContext)_localctx).identifier);
						setState(1955);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1951); match(COMMA);
							setState(1952); ((Grant_statementContext)_localctx).identifier = identifier();
							((Grant_statementContext)_localctx).sequence_name.add(((Grant_statementContext)_localctx).identifier);
							}
							}
							setState(1957);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						setState(1960); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(1962); match(ALL);
					setState(1963); match(SEQUENCES);
					setState(1964); match(IN);
					setState(1965); match(SCHEMA);
					setState(1966); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
					setState(1971);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1967); match(COMMA);
						setState(1968); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
						}
						}
						setState(1973);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1976); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1978); match(GRANT);
				setState(1991);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1979);
					_la = _input.LA(1);
					if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1984);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1980); match(COMMA);
						setState(1981);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1986);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ALL:
					{
					setState(1987); match(ALL);
					setState(1989);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1988); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1993); match(ON);
				setState(1994); match(DATABASE);
				setState(1995); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).database_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2000);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1996); match(COMMA);
					setState(1997); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).database_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2002);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2003); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2005); match(GRANT);
				setState(2011);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(2006); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(2007); match(ALL);
					setState(2009);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2008); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2013); match(ON);
				setState(2014); match(FOREIGN);
				setState(2015); match(DATA);
				setState(2016); match(WRAPPER);
				setState(2017); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).fdw_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2022);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2018); match(COMMA);
					setState(2019); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).fdw_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2024);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2025); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2027); match(GRANT);
				setState(2033);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(2028); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(2029); match(ALL);
					setState(2031);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2030); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2035); match(ON);
				setState(2036); match(FOREIGN);
				setState(2037); match(SERVER);
				setState(2038); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).server_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2043);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2039); match(COMMA);
					setState(2040); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).server_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2045);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2046); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2048); match(GRANT);
				setState(2054);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(2049); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(2050); match(ALL);
					setState(2052);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2051); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2056); match(ON);
				setState(2059);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(2057); function_definition();
					}
					break;
				case ALL:
					{
					setState(2058); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2061); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2063); match(GRANT);
				setState(2069);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(2064); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(2065); match(ALL);
					setState(2067);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2066); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2071); match(ON);
				setState(2072); match(LANGUAGE);
				setState(2073); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).lang_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2078);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2074); match(COMMA);
					setState(2075); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).lang_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2080);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2081); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2083); match(GRANT);
				setState(2096);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(2088); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2084);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(2086);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2085); match(COMMA);
							}
						}

						}
						}
						setState(2090); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(2092); match(ALL);
					setState(2094);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2093); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2098); match(ON);
				setState(2099); match(LARGE);
				setState(2100); match(OBJECT);
				setState(2101); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).loid.add(((Grant_statementContext)_localctx).identifier);
				setState(2106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2102); match(COMMA);
					setState(2103); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).loid.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2109); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2111); match(GRANT);
				setState(2124);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(2116); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2112);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(2114);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2113); match(COMMA);
							}
						}

						}
						}
						setState(2118); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(2120); match(ALL);
					setState(2122);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2121); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2126); match(ON);
				setState(2127); match(SCHEMA);
				setState(2128); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2129); match(COMMA);
					setState(2130); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2136); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2138); match(GRANT);
				setState(2144);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(2139); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(2140); match(ALL);
					setState(2142);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2141); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2146); match(ON);
				setState(2147); match(TABLESPACE);
				setState(2148); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).tablespace_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2149); match(COMMA);
					setState(2150); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).tablespace_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2156); grant_to_rule();
				setState(2157); match(GRANT);
				setState(2158); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2159); match(COMMA);
					setState(2160); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2166); match(TO);
				setState(2167); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2168); match(COMMA);
					setState(2169); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2178);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(2175); match(WITH);
					setState(2176); match(ADMIN);
					setState(2177); match(OPTION);
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
		enterRule(_localctx, 54, RULE_grant_to_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2182); match(TO);
			setState(2188);
			switch ( getInterpreter().adaptivePredict(_input,264,_ctx) ) {
			case 1:
				{
				setState(2184);
				_la = _input.LA(1);
				if (_la==GROUP) {
					{
					setState(2183); match(GROUP);
					}
				}

				{
				setState(2186); ((Grant_to_ruleContext)_localctx).identifier = identifier();
				((Grant_to_ruleContext)_localctx).role_name.add(((Grant_to_ruleContext)_localctx).identifier);
				}
				}
				break;
			case 2:
				{
				setState(2187); match(PUBLIC);
				}
				break;
			}
			setState(2200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2190); match(COMMA);
				setState(2196);
				switch ( getInterpreter().adaptivePredict(_input,266,_ctx) ) {
				case 1:
					{
					setState(2192);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(2191); match(GROUP);
						}
					}

					{
					setState(2194); ((Grant_to_ruleContext)_localctx).identifier = identifier();
					((Grant_to_ruleContext)_localctx).role_name.add(((Grant_to_ruleContext)_localctx).identifier);
					}
					}
					break;
				case 2:
					{
					setState(2195); match(PUBLIC);
					}
					break;
				}
				}
				}
				setState(2202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2206);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2203); match(WITH);
				setState(2204); match(GRANT);
				setState(2205); match(OPTION);
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
		enterRule(_localctx, 56, RULE_comment_on_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2208); match(COMMENT);
			setState(2209); match(ON);
			setState(2329);
			switch ( getInterpreter().adaptivePredict(_input,272,_ctx) ) {
			case 1:
				{
				setState(2210); match(AGGREGATE);
				setState(2211); ((Comment_on_statementContext)_localctx).agg_name = schema_qualified_name();
				setState(2212); match(LEFT_PAREN);
				setState(2221);
				_la = _input.LA(1);
				if (((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & ((1L << (SETOF - 109)) | (1L << (TRIGGER - 109)) | (1L << (CHARACTER - 109)) | (1L << (DEC - 109)))) != 0) || _la==NATIONAL || _la==REGCONFIG || ((((_la - 288)) & ~0x3f) == 0 && ((1L << (_la - 288)) & ((1L << (BOOLEAN - 288)) | (1L << (BOOL - 288)) | (1L << (BIT - 288)) | (1L << (VARBIT - 288)) | (1L << (INT1 - 288)) | (1L << (INT2 - 288)) | (1L << (INT4 - 288)) | (1L << (INT8 - 288)) | (1L << (TINYINT - 288)) | (1L << (SMALLINT - 288)) | (1L << (INT - 288)) | (1L << (INTEGER - 288)) | (1L << (BIGINT - 288)) | (1L << (FLOAT4 - 288)) | (1L << (FLOAT8 - 288)) | (1L << (REAL - 288)) | (1L << (REGCLASS - 288)) | (1L << (FLOAT - 288)) | (1L << (DOUBLE - 288)) | (1L << (NUMERIC - 288)) | (1L << (DECIMAL - 288)) | (1L << (CHAR - 288)) | (1L << (VARCHAR - 288)) | (1L << (NCHAR - 288)) | (1L << (NVARCHAR - 288)) | (1L << (DATE - 288)) | (1L << (TIME - 288)) | (1L << (TIMETZ - 288)) | (1L << (TIMESTAMP - 288)) | (1L << (TIMESTAMPTZ - 288)) | (1L << (TEXT - 288)) | (1L << (UUID - 288)) | (1L << (BINARY - 288)) | (1L << (VARBINARY - 288)) | (1L << (BLOB - 288)) | (1L << (BYTEA - 288)) | (1L << (INET4 - 288)) | (1L << (INET - 288)) | (1L << (INTERVAL - 288)) | (1L << (VOID - 288)))) != 0)) {
					{
					setState(2213); ((Comment_on_statementContext)_localctx).data_type = data_type();
					((Comment_on_statementContext)_localctx).agg_type.add(((Comment_on_statementContext)_localctx).data_type);
					setState(2218);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2214); match(COMMA);
						setState(2215); ((Comment_on_statementContext)_localctx).data_type = data_type();
						((Comment_on_statementContext)_localctx).agg_type.add(((Comment_on_statementContext)_localctx).data_type);
						}
						}
						setState(2220);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(2223); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(2225); match(CAST);
				setState(2226); match(LEFT_PAREN);
				setState(2227); ((Comment_on_statementContext)_localctx).source_type = data_type();
				setState(2228); match(AS);
				setState(2229); ((Comment_on_statementContext)_localctx).target_type = data_type();
				setState(2230); match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(2232); match(COLLATION);
				setState(2233); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 4:
				{
				setState(2234); match(COLUMN);
				setState(2235); ((Comment_on_statementContext)_localctx).column_name = schema_qualified_name();
				}
				break;
			case 5:
				{
				setState(2236); match(CONSTRAINT);
				setState(2237); ((Comment_on_statementContext)_localctx).constraint_name = schema_qualified_name();
				setState(2238); match(ON);
				setState(2239); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 6:
				{
				setState(2241); match(CONVERSION);
				setState(2242); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 7:
				{
				setState(2243); match(DATABASE);
				setState(2244); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 8:
				{
				setState(2245); match(DOMAIN);
				setState(2246); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 9:
				{
				setState(2247); match(EXTENSION);
				setState(2248); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 10:
				{
				setState(2249); match(FOREIGN);
				setState(2250); match(DATA);
				setState(2251); match(WRAPPER);
				setState(2252); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 11:
				{
				setState(2253); match(FOREIGN);
				setState(2254); match(TABLE);
				setState(2255); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 12:
				{
				setState(2256); function_definition();
				}
				break;
			case 13:
				{
				setState(2257); match(INDEX);
				setState(2258); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 14:
				{
				setState(2259); match(LARGE);
				setState(2260); match(OBJECT);
				setState(2261); ((Comment_on_statementContext)_localctx).large_object_oid = identifier();
				}
				break;
			case 15:
				{
				setState(2262); match(OPERATOR);
				setState(2263); ((Comment_on_statementContext)_localctx).operator_name = schema_qualified_name();
				setState(2264); match(LEFT_PAREN);
				setState(2265); ((Comment_on_statementContext)_localctx).left_type = data_type();
				setState(2266); match(COMMA);
				setState(2267); ((Comment_on_statementContext)_localctx).right_type = data_type();
				setState(2268); match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(2270); match(OPERATOR);
				setState(2271); match(CLASS);
				setState(2272); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(2273); match(USING);
				setState(2274); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 17:
				{
				setState(2276); match(OPERATOR);
				setState(2277); match(FAMILY);
				setState(2278); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(2279); match(USING);
				setState(2280); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 18:
				{
				setState(2283);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(2282); match(PROCEDURAL);
					}
				}

				setState(2285); match(LANGUAGE);
				setState(2286); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 19:
				{
				setState(2287); match(ROLE);
				setState(2288); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 20:
				{
				setState(2289); match(RULE);
				setState(2290); ((Comment_on_statementContext)_localctx).rule_name = schema_qualified_name();
				setState(2291); match(ON);
				setState(2292); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 21:
				{
				setState(2294); match(SCHEMA);
				setState(2295); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 22:
				{
				setState(2296); match(SEQUENCE);
				setState(2297); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 23:
				{
				setState(2298); match(SERVER);
				setState(2299); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 24:
				{
				setState(2300); match(TABLE);
				setState(2301); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 25:
				{
				setState(2302); match(TABLESPACE);
				setState(2303); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 26:
				{
				setState(2304); match(TEXT);
				setState(2305); match(SEARCH);
				setState(2306); match(CONFIGURATION);
				setState(2307); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 27:
				{
				setState(2308); match(TEXT);
				setState(2309); match(SEARCH);
				setState(2310); match(DICTIONARY);
				setState(2311); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 28:
				{
				setState(2312); match(TEXT);
				setState(2313); match(SEARCH);
				setState(2314); match(PARSER);
				setState(2315); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 29:
				{
				setState(2316); match(TEXT);
				setState(2317); match(SEARCH);
				setState(2318); match(TEMPLATE);
				setState(2319); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 30:
				{
				setState(2320); match(TRIGGER);
				setState(2321); ((Comment_on_statementContext)_localctx).trigger_name = schema_qualified_name();
				setState(2322); match(ON);
				setState(2323); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 31:
				{
				setState(2325); match(TYPE);
				setState(2326); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 32:
				{
				setState(2327); match(VIEW);
				setState(2328); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			}
			setState(2331); match(IS);
			setState(2332); match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode STABLE(int i) {
			return getToken(SQLParser.STABLE, i);
		}
		public List<TerminalNode> COST() { return getTokens(SQLParser.COST); }
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
		enterRule(_localctx, 58, RULE_create_function_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2334); match(CREATE);
			setState(2337);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(2335); match(OR);
				setState(2336); match(REPLACE);
				}
			}

			setState(2339); match(FUNCTION);
			setState(2340); function_parameters();
			setState(2359);
			switch ( getInterpreter().adaptivePredict(_input,276,_ctx) ) {
			case 1:
				{
				setState(2341); match(RETURNS);
				setState(2344);
				switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
				case 1:
					{
					setState(2342); ((Create_function_statementContext)_localctx).rettype = value_expression();
					}
					break;
				case 2:
					{
					setState(2343); ((Create_function_statementContext)_localctx).rettype_data = data_type();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(2346); match(RETURNS);
				setState(2347); match(TABLE);
				setState(2348); match(LEFT_PAREN);
				setState(2349); function_column_name_type();
				setState(2354);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2350); match(COMMA);
					setState(2351); function_column_name_type();
					}
					}
					setState(2356);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2357); match(RIGHT_PAREN);
				}
				break;
			}
			setState(2414); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(2414);
				switch ( getInterpreter().adaptivePredict(_input,281,_ctx) ) {
				case 1:
					{
					setState(2361); match(LANGUAGE);
					setState(2362); ((Create_function_statementContext)_localctx).lang_name = identifier();
					}
					break;
				case 2:
					{
					setState(2363); match(WINDOW);
					}
					break;
				case 3:
					{
					setState(2364); match(IMMUTABLE);
					}
					break;
				case 4:
					{
					setState(2365); match(STABLE);
					}
					break;
				case 5:
					{
					setState(2366); match(VOLATILE);
					}
					break;
				case 6:
					{
					setState(2367); match(CALLED);
					setState(2368); match(ON);
					setState(2369); match(NULL);
					setState(2370); match(INPUT);
					}
					break;
				case 7:
					{
					setState(2371); match(RETURNS);
					setState(2372); match(NULL);
					setState(2373); match(ON);
					setState(2374); match(NULL);
					setState(2375); match(INPUT);
					}
					break;
				case 8:
					{
					setState(2376); match(STRICT);
					}
					break;
				case 9:
					{
					setState(2378);
					_la = _input.LA(1);
					if (_la==EXTERNAL) {
						{
						setState(2377); match(EXTERNAL);
						}
					}

					setState(2380); match(SECURITY);
					setState(2381); match(INVOKER);
					}
					break;
				case 10:
					{
					setState(2383);
					_la = _input.LA(1);
					if (_la==EXTERNAL) {
						{
						setState(2382); match(EXTERNAL);
						}
					}

					setState(2385); match(SECURITY);
					setState(2386); match(DEFINER);
					}
					break;
				case 11:
					{
					setState(2387); match(COST);
					setState(2388); ((Create_function_statementContext)_localctx).execution_cost = match(NUMBER);
					}
					break;
				case 12:
					{
					setState(2389); match(ROWS);
					setState(2390); ((Create_function_statementContext)_localctx).result_rows = match(NUMBER);
					}
					break;
				case 13:
					{
					setState(2391); match(SET);
					setState(2392); ((Create_function_statementContext)_localctx).configuration_parameter = identifier();
					setState(2399);
					switch (_input.LA(1)) {
					case TO:
						{
						setState(2393); match(TO);
						setState(2394); ((Create_function_statementContext)_localctx).value = identifier();
						}
						break;
					case EQUAL:
						{
						setState(2395); match(EQUAL);
						setState(2396); ((Create_function_statementContext)_localctx).value = identifier();
						}
						break;
					case FROM:
						{
						setState(2397); match(FROM);
						setState(2398); match(CURRENT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2405);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2401); match(COMMA);
						setState(2402); ((Create_function_statementContext)_localctx).value = identifier();
						}
						}
						setState(2407);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 14:
					{
					setState(2408); match(AS);
					setState(2409); function_body();
					}
					break;
				case 15:
					{
					setState(2410); match(AS);
					setState(2411); match(Character_String_Literal);
					setState(2412); match(COMMA);
					setState(2413); match(Character_String_Literal);
					}
					break;
				}
				}
				setState(2416); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AS || _la==IMMUTABLE || ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (ROWS - 96)) | (1L << (RETURNS - 96)) | (1L << (STRICT - 96)) | (1L << (CALLED - 96)) | (1L << (COST - 96)))) != 0) || _la==EXTERNAL || _la==LANGUAGE || ((((_la - 248)) & ~0x3f) == 0 && ((1L << (_la - 248)) & ((1L << (SECURITY - 248)) | (1L << (SET - 248)) | (1L << (STABLE - 248)) | (1L << (VOLATILE - 248)) | (1L << (WINDOW - 248)))) != 0) );
			setState(2430);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2418); match(WITH);
				setState(2419); match(LEFT_PAREN);
				setState(2420); ((Create_function_statementContext)_localctx).function_attribute = function_attribute();
				((Create_function_statementContext)_localctx).attribute.add(((Create_function_statementContext)_localctx).function_attribute);
				setState(2425);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2421); match(COMMA);
					setState(2422); ((Create_function_statementContext)_localctx).function_attribute = function_attribute();
					((Create_function_statementContext)_localctx).attribute.add(((Create_function_statementContext)_localctx).function_attribute);
					}
					}
					setState(2427);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2428); match(RIGHT_PAREN);
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
		enterRule(_localctx, 60, RULE_function_column_name_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2432); ((Function_column_name_typeContext)_localctx).column_name = identifier();
			setState(2433); ((Function_column_name_typeContext)_localctx).column_type = data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 62, RULE_function_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2435); ((Function_parametersContext)_localctx).name = schema_qualified_name();
			setState(2436); match(LEFT_PAREN);
			setState(2453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << IN))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INOUT - 66)) | (1L << (LEFT - 66)) | (1L << (NOT - 66)) | (1L << (NULL - 66)) | (1L << (OUT - 66)) | (1L << (RIGHT - 66)) | (1L << (SETOF - 66)) | (1L << (SOME - 66)) | (1L << (TRIGGER - 66)) | (1L << (TRUE - 66)) | (1L << (VARIADIC - 66)))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (REGCLASS - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (BINARY - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (LEFT_PAREN - 327)) | (1L << (PLUS - 327)) | (1L << (MINUS - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (NUMBER - 327)) | (1L << (REAL_NUMBER - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)) | (1L << (Character_String_Literal - 327)))) != 0)) {
				{
				{
				setState(2437); function_arguments();
				setState(2439);
				_la = _input.LA(1);
				if (_la==DEFAULT || _la==EQUAL) {
					{
					setState(2438); function_def_value();
					}
				}

				setState(2448);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2441); match(COMMA);
					setState(2442); function_arguments();
					setState(2444);
					_la = _input.LA(1);
					if (_la==DEFAULT || _la==EQUAL) {
						{
						setState(2443); function_def_value();
						}
					}

					}
					}
					setState(2450);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(2455);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2456); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 64, RULE_function_def_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2458);
			_la = _input.LA(1);
			if ( !(_la==DEFAULT || _la==EQUAL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(2459); ((Function_def_valueContext)_localctx).def_value = value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 66, RULE_function_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2461); match(BeginDollarStringConstant);
			setState(2463); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2462); match(Text_between_Dollar);
				}
				}
				setState(2465); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Text_between_Dollar );
			setState(2467); match(EndDollarStringConstant);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 68, RULE_function_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2470);
			_la = _input.LA(1);
			if (_la==IN || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INOUT - 66)) | (1L << (OUT - 66)) | (1L << (VARIADIC - 66)))) != 0)) {
				{
				setState(2469); ((Function_argumentsContext)_localctx).arg_mode = argmode();
				}
			}

			setState(2473);
			switch ( getInterpreter().adaptivePredict(_input,291,_ctx) ) {
			case 1:
				{
				setState(2472); ((Function_argumentsContext)_localctx).argname = identifier();
				}
				break;
			}
			setState(2478);
			switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
			case 1:
				{
				setState(2475); ((Function_argumentsContext)_localctx).argtype_data = data_type();
				}
				break;
			case 2:
				{
				setState(2476); ((Function_argumentsContext)_localctx).argtype_expres = value_expression();
				}
				break;
			case 3:
				{
				setState(2477); ((Function_argumentsContext)_localctx).argtype_schema = schema_qualified_name();
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
		enterRule(_localctx, 70, RULE_function_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2480);
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
		enterRule(_localctx, 72, RULE_argmode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2482);
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
		public Schema_qualified_nameContext func_name;
		public List<Function_argumentsContext> function_arguments() {
			return getRuleContexts(Function_argumentsContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
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
		enterRule(_localctx, 74, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2484); match(FUNCTION);
			setState(2485); ((Function_definitionContext)_localctx).func_name = schema_qualified_name();
			setState(2486); match(LEFT_PAREN);
			setState(2497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << IN))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INOUT - 66)) | (1L << (LEFT - 66)) | (1L << (NOT - 66)) | (1L << (NULL - 66)) | (1L << (OUT - 66)) | (1L << (RIGHT - 66)) | (1L << (SETOF - 66)) | (1L << (SOME - 66)) | (1L << (TRIGGER - 66)) | (1L << (TRUE - 66)) | (1L << (VARIADIC - 66)))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (REGCLASS - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (BINARY - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (LEFT_PAREN - 327)) | (1L << (PLUS - 327)) | (1L << (MINUS - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (NUMBER - 327)) | (1L << (REAL_NUMBER - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)) | (1L << (Character_String_Literal - 327)))) != 0)) {
				{
				{
				setState(2487); function_arguments();
				setState(2492);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2488); match(COMMA);
					setState(2489); function_arguments();
					}
					}
					setState(2494);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(2499);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2500); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_functions_definition_schema);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2502); match(ALL);
			setState(2503); match(FUNCTIONS);
			setState(2504); match(IN);
			setState(2505); match(SCHEMA);
			setState(2506); ((Functions_definition_schemaContext)_localctx).identifier = identifier();
			((Functions_definition_schemaContext)_localctx).schema_name.add(((Functions_definition_schemaContext)_localctx).identifier);
			setState(2511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2507); match(COMMA);
				setState(2508); ((Functions_definition_schemaContext)_localctx).identifier = identifier();
				((Functions_definition_schemaContext)_localctx).schema_name.add(((Functions_definition_schemaContext)_localctx).identifier);
				}
				}
				setState(2513);
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
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
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
		enterRule(_localctx, 78, RULE_create_sequence_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2514); match(CREATE);
			setState(2516);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(2515);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2518); match(SEQUENCE);
			setState(2519); ((Create_sequence_statementContext)_localctx).name = schema_qualified_name();
			setState(2523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OWNED || _la==CACHE || ((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (CYCLE - 160)) | (1L << (INCREMENT - 160)) | (1L << (MAXVALUE - 160)) | (1L << (MINVALUE - 160)) | (1L << (NO - 160)))) != 0) || _la==START) {
				{
				{
				setState(2520); sequence_body();
				}
				}
				setState(2525);
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
		public Token minval;
		public Numeric_typeContext maxval;
		public Token start_val;
		public Token cache_val;
		public Schema_qualified_nameContext col_name;
		public TerminalNode NO() { return getToken(SQLParser.NO, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode OWNED() { return getToken(SQLParser.OWNED, 0); }
		public TerminalNode MAXVALUE() { return getToken(SQLParser.MAXVALUE, 0); }
		public TerminalNode INCREMENT() { return getToken(SQLParser.INCREMENT, 0); }
		public TerminalNode NONE() { return getToken(SQLParser.NONE, 0); }
		public TerminalNode START() { return getToken(SQLParser.START, 0); }
		public TerminalNode MINVALUE() { return getToken(SQLParser.MINVALUE, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Numeric_typeContext numeric_type() {
			return getRuleContext(Numeric_typeContext.class,0);
		}
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
		enterRule(_localctx, 80, RULE_sequence_body);
		int _la;
		try {
			setState(2560);
			switch ( getInterpreter().adaptivePredict(_input,304,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2526); match(INCREMENT);
				setState(2528);
				_la = _input.LA(1);
				if (_la==BY) {
					{
					setState(2527); match(BY);
					}
				}

				setState(2530); ((Sequence_bodyContext)_localctx).incr = match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2535);
				switch (_input.LA(1)) {
				case MINVALUE:
					{
					setState(2531); match(MINVALUE);
					setState(2532); ((Sequence_bodyContext)_localctx).minval = match(NUMBER);
					}
					break;
				case NO:
					{
					setState(2533); match(NO);
					setState(2534); match(MINVALUE);
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
				setState(2541);
				switch (_input.LA(1)) {
				case MAXVALUE:
					{
					setState(2537); match(MAXVALUE);
					setState(2538); ((Sequence_bodyContext)_localctx).maxval = numeric_type();
					}
					break;
				case NO:
					{
					setState(2539); match(NO);
					setState(2540); match(MAXVALUE);
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
				setState(2543); match(START);
				setState(2545);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(2544); match(WITH);
					}
				}

				setState(2547); ((Sequence_bodyContext)_localctx).start_val = match(NUMBER);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2548); match(CACHE);
				setState(2549); ((Sequence_bodyContext)_localctx).cache_val = match(NUMBER);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2551);
				_la = _input.LA(1);
				if (_la==NO) {
					{
					setState(2550); match(NO);
					}
				}

				setState(2553); match(CYCLE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2554); match(OWNED);
				setState(2555); match(BY);
				setState(2558);
				switch ( getInterpreter().adaptivePredict(_input,303,_ctx) ) {
				case 1:
					{
					setState(2556); ((Sequence_bodyContext)_localctx).col_name = schema_qualified_name();
					}
					break;
				case 2:
					{
					setState(2557); match(NONE);
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
		enterRule(_localctx, 82, RULE_create_schema_statement);
		int _la;
		try {
			setState(2602);
			switch ( getInterpreter().adaptivePredict(_input,309,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2562); match(CREATE);
				setState(2563); match(SCHEMA);
				setState(2564); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(2567);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(2565); match(AUTHORIZATION);
					setState(2566); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				setState(2572);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - -1)) & ~0x3f) == 0 && ((1L << (_la - -1)) & ((1L << (EOF - -1)) | (1L << (ALTER - -1)) | (1L << (CREATE - -1)) | (1L << (GRANT - -1)))) != 0) || _la==REVOKE || _la==COMMENT || _la==DROP || _la==SET) {
					{
					{
					setState(2569); ((Create_schema_statementContext)_localctx).schema_element = sql();
					}
					}
					setState(2574);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2575); match(CREATE);
				setState(2576); match(SCHEMA);
				setState(2577); match(AUTHORIZATION);
				setState(2578); ((Create_schema_statementContext)_localctx).user_name = identifier();
				setState(2582);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - -1)) & ~0x3f) == 0 && ((1L << (_la - -1)) & ((1L << (EOF - -1)) | (1L << (ALTER - -1)) | (1L << (CREATE - -1)) | (1L << (GRANT - -1)))) != 0) || _la==REVOKE || _la==COMMENT || _la==DROP || _la==SET) {
					{
					{
					setState(2579); ((Create_schema_statementContext)_localctx).schema_element = sql();
					}
					}
					setState(2584);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2585); match(CREATE);
				setState(2586); match(SCHEMA);
				setState(2587); match(IF);
				setState(2588); match(NOT);
				setState(2589); match(EXISTS);
				setState(2590); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(2593);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(2591); match(AUTHORIZATION);
					setState(2592); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2595); match(CREATE);
				setState(2596); match(SCHEMA);
				setState(2597); match(IF);
				setState(2598); match(NOT);
				setState(2599); match(EXISTS);
				setState(2600); match(AUTHORIZATION);
				setState(2601); ((Create_schema_statementContext)_localctx).user_name = identifier();
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
		public IdentifierContext identifier;
		public List<IdentifierContext> column_name = new ArrayList<IdentifierContext>();
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
		enterRule(_localctx, 84, RULE_create_view_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2604); match(CREATE);
			setState(2607);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(2605); match(OR);
				setState(2606); match(REPLACE);
				}
			}

			setState(2610);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(2609);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2612); match(VIEW);
			setState(2613); ((Create_view_statementContext)_localctx).name = schema_qualified_name();
			setState(2620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0)) {
				{
				{
				setState(2614); ((Create_view_statementContext)_localctx).identifier = identifier();
				((Create_view_statementContext)_localctx).column_name.add(((Create_view_statementContext)_localctx).identifier);
				setState(2616);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2615); match(COMMA);
					}
				}

				}
				}
				setState(2622);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2636);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2623); match(WITH);
				setState(2624); match(LEFT_PAREN);
				setState(2630); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2625); ((Create_view_statementContext)_localctx).view_option_name = identifier();
					setState(2628);
					_la = _input.LA(1);
					if (_la==EQUAL) {
						{
						setState(2626); match(EQUAL);
						setState(2627); ((Create_view_statementContext)_localctx).view_option_value = identifier();
						}
					}

					}
					}
					setState(2632); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0) );
				setState(2634); match(RIGHT_PAREN);
				}
			}

			setState(2638); match(AS);
			setState(2639); query_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 86, RULE_create_table_statement);
		int _la;
		try {
			int _alt;
			setState(2740);
			switch ( getInterpreter().adaptivePredict(_input,334,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2641); match(CREATE);
				setState(2647);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(2643);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(2642);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(2645);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(2646); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2649); match(TABLE);
				setState(2653);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(2650); match(IF);
					setState(2651); match(NOT);
					setState(2652); match(EXISTS);
					}
				}

				setState(2655); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(2656); match(LEFT_PAREN);
				setState(2665);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (LIKE - 74)) | (1L << (PRIMARY - 74)) | (1L << (UNIQUE - 74)) | (1L << (ADMIN - 74)) | (1L << (ALWAYS - 74)) | (1L << (ARRAY - 74)))) != 0) || ((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (AVG - 138)) | (1L << (BETWEEN - 138)) | (1L << (BY - 138)) | (1L << (CACHE - 138)) | (1L << (CALLED - 138)) | (1L << (CLASS - 138)) | (1L << (CENTURY - 138)) | (1L << (CHARACTER - 138)) | (1L << (CHECK - 138)) | (1L << (CLUSTER - 138)) | (1L << (COLLECT - 138)) | (1L << (COALESCE - 138)) | (1L << (COLUMN - 138)) | (1L << (COMMENT - 138)) | (1L << (COMMENTS - 138)) | (1L << (COMMIT - 138)) | (1L << (CONCURRENTLY - 138)) | (1L << (CONFIGURATION - 138)) | (1L << (COST - 138)) | (1L << (COUNT - 138)) | (1L << (CUBE - 138)) | (1L << (CURRENT - 138)) | (1L << (CYCLE - 138)) | (1L << (DATA - 138)) | (1L << (DAY - 138)) | (1L << (DEC - 138)) | (1L << (DECADE - 138)) | (1L << (DEFINER - 138)) | (1L << (DICTIONARY - 138)) | (1L << (DISABLE - 138)) | (1L << (DOW - 138)) | (1L << (DOY - 138)) | (1L << (DROP - 138)) | (1L << (ENABLE - 138)) | (1L << (EPOCH - 138)) | (1L << (EVENT - 138)) | (1L << (EVERY - 138)) | (1L << (EXISTS - 138)) | (1L << (EXTENDED - 138)) | (1L << (EXTERNAL - 138)) | (1L << (EXTRACT - 138)) | (1L << (FAMILY - 138)) | (1L << (FILTER - 138)) | (1L << (FIRST - 138)) | (1L << (FORMAT - 138)) | (1L << (FUSION - 138)) | (1L << (GROUPING - 138)) | (1L << (HASH - 138)) | (1L << (INHERIT - 138)) | (1L << (INDEX - 138)) | (1L << (INCREMENT - 138)) | (1L << (INPUT - 138)) | (1L << (INSERT - 138)) | (1L << (INTERSECTION - 138)) | (1L << (ISCACHABLE - 138)) | (1L << (ISODOW - 138)) | (1L << (ISOYEAR - 138)) | (1L << (ISSTRICT - 138)) | (1L << (LANGUAGE - 138)) | (1L << (LARGE - 138)) | (1L << (LAST - 138)) | (1L << (LESS - 138)))) != 0) || ((((_la - 202)) & ~0x3f) == 0 && ((1L << (_la - 202)) & ((1L << (LIST - 202)) | (1L << (LOCATION - 202)) | (1L << (MAIN - 202)) | (1L << (MATCH - 202)) | (1L << (MAX - 202)) | (1L << (MAXVALUE - 202)) | (1L << (MICROSECONDS - 202)) | (1L << (MILLENNIUM - 202)) | (1L << (MILLISECONDS - 202)) | (1L << (MIN - 202)) | (1L << (MINVALUE - 202)) | (1L << (MINUTE - 202)) | (1L << (MONTH - 202)) | (1L << (NATIONAL - 202)) | (1L << (NO - 202)) | (1L << (NONE - 202)) | (1L << (NULLIF - 202)) | (1L << (OBJECT - 202)) | (1L << (ON - 202)) | (1L << (ONLY - 202)) | (1L << (OPTION - 202)) | (1L << (OPTIONS - 202)) | (1L << (OVER - 202)) | (1L << (OVERWRITE - 202)) | (1L << (PARSER - 202)) | (1L << (PARTIAL - 202)) | (1L << (PARTITION - 202)) | (1L << (PARTITIONS - 202)) | (1L << (PLAIN - 202)) | (1L << (PRECISION - 202)) | (1L << (PUBLIC - 202)) | (1L << (PURGE - 202)) | (1L << (QUARTER - 202)) | (1L << (RANGE - 202)) | (1L << (REGCONFIG - 202)) | (1L << (REGEXP - 202)) | (1L << (RENAME - 202)) | (1L << (REPLICA - 202)) | (1L << (RESET - 202)) | (1L << (RESTART - 202)) | (1L << (RLIKE - 202)) | (1L << (ROLLUP - 202)) | (1L << (SEARCH - 202)) | (1L << (SECOND - 202)) | (1L << (SECURITY - 202)) | (1L << (SERVER - 202)) | (1L << (SET - 202)) | (1L << (SIMILAR - 202)) | (1L << (SIMPLE - 202)) | (1L << (STABLE - 202)) | (1L << (START - 202)) | (1L << (STATISTICS - 202)) | (1L << (STORAGE - 202)) | (1L << (STDDEV_POP - 202)) | (1L << (STDDEV_SAMP - 202)) | (1L << (SUBPARTITION - 202)) | (1L << (SUM - 202)) | (1L << (TABLESPACE - 202)) | (1L << (TEMPLATE - 202)) | (1L << (THAN - 202)) | (1L << (TIMEZONE - 202)))) != 0) || ((((_la - 266)) & ~0x3f) == 0 && ((1L << (_la - 266)) & ((1L << (TIMEZONE_HOUR - 266)) | (1L << (TIMEZONE_MINUTE - 266)) | (1L << (TRIM - 266)) | (1L << (TO - 266)) | (1L << (TYPE - 266)) | (1L << (TYPES - 266)) | (1L << (UNKNOWN - 266)) | (1L << (UNLOGGED - 266)) | (1L << (USER - 266)) | (1L << (VALID - 266)) | (1L << (VALIDATE - 266)) | (1L << (VALUES - 266)) | (1L << (VAR_SAMP - 266)) | (1L << (VAR_POP - 266)) | (1L << (VARYING - 266)) | (1L << (VERSION - 266)) | (1L << (VOLATILE - 266)) | (1L << (WEEK - 266)) | (1L << (WINDOW - 266)) | (1L << (WRAPPER - 266)) | (1L << (YEAR - 266)) | (1L << (ZONE - 266)) | (1L << (BOOLEAN - 266)) | (1L << (BOOL - 266)) | (1L << (BIT - 266)) | (1L << (VARBIT - 266)) | (1L << (INT1 - 266)) | (1L << (INT2 - 266)) | (1L << (INT4 - 266)) | (1L << (INT8 - 266)) | (1L << (TINYINT - 266)) | (1L << (SMALLINT - 266)) | (1L << (INT - 266)) | (1L << (INTEGER - 266)) | (1L << (BIGINT - 266)) | (1L << (FLOAT4 - 266)) | (1L << (FLOAT8 - 266)) | (1L << (REAL - 266)) | (1L << (FLOAT - 266)) | (1L << (DOUBLE - 266)) | (1L << (NUMERIC - 266)) | (1L << (DECIMAL - 266)) | (1L << (CHAR - 266)) | (1L << (VARCHAR - 266)) | (1L << (NCHAR - 266)) | (1L << (NVARCHAR - 266)) | (1L << (DATE - 266)) | (1L << (TIME - 266)) | (1L << (TIMETZ - 266)) | (1L << (TIMESTAMP - 266)) | (1L << (TIMESTAMPTZ - 266)) | (1L << (TEXT - 266)) | (1L << (UUID - 266)) | (1L << (VARBINARY - 266)) | (1L << (BLOB - 266)) | (1L << (BYTEA - 266)) | (1L << (INET4 - 266)) | (1L << (INET - 266)) | (1L << (INTERVAL - 266)) | (1L << (VOID - 266)))) != 0) || ((((_la - 355)) & ~0x3f) == 0 && ((1L << (_la - 355)) & ((1L << (DOUBLE_QUOTE - 355)) | (1L << (Identifier - 355)) | (1L << (QuotedIdentifier - 355)))) != 0)) {
					{
					setState(2657); table_body();
					setState(2662);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2658); match(COMMA);
						setState(2659); table_body();
						}
						}
						setState(2664);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(2667); match(RIGHT_PAREN);
				setState(2680);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(2668); match(INHERITS);
					setState(2669); match(LEFT_PAREN);
					setState(2674); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2670); ((Create_table_statementContext)_localctx).paret_table = schema_qualified_name();
						setState(2672);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2671); match(COMMA);
							}
						}

						}
						}
						setState(2676); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0) );
					setState(2678); match(RIGHT_PAREN);
					}
				}

				setState(2682); storage_parameter_oid();
				setState(2683); on_commit();
				setState(2684); table_space();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2686); match(CREATE);
				setState(2692);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(2688);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(2687);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(2690);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(2691); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2694); match(TABLE);
				setState(2698);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(2695); match(IF);
					setState(2696); match(NOT);
					setState(2697); match(EXISTS);
					}
				}

				setState(2700); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(2701); match(OF);
				setState(2702); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(2734);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2703); match(LEFT_PAREN);
					setState(2714);
					switch ( getInterpreter().adaptivePredict(_input,329,_ctx) ) {
					case 1:
						{
						{
						setState(2704); ((Create_table_statementContext)_localctx).column_name = identifier();
						setState(2705); match(WITH);
						setState(2706); match(OPTIONS);
						setState(2710);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,328,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(2707); ((Create_table_statementContext)_localctx).column_constraint = column_constraint();
								((Create_table_statementContext)_localctx).col_constraint.add(((Create_table_statementContext)_localctx).column_constraint);
								}
								} 
							}
							setState(2712);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,328,_ctx);
						}
						}
						}
						break;
					case 2:
						{
						setState(2713); table_constraint();
						}
						break;
					}
					setState(2729);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (PRIMARY - 90)) | (1L << (UNIQUE - 90)) | (1L << (CHECK - 90)))) != 0) || _la==COMMA) {
						{
						setState(2727);
						switch (_input.LA(1)) {
						case COMMA:
							{
							setState(2716); match(COMMA);
							{
							setState(2717); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(2718); match(WITH);
							setState(2719); match(OPTIONS);
							setState(2723);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,330,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(2720); ((Create_table_statementContext)_localctx).column_constraint = column_constraint();
									((Create_table_statementContext)_localctx).col_constraint.add(((Create_table_statementContext)_localctx).column_constraint);
									}
									} 
								}
								setState(2725);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,330,_ctx);
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
							setState(2726); table_constraint();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(2731);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2732); match(RIGHT_PAREN);
					}
				}

				setState(2736); storage_parameter_oid();
				setState(2737); on_commit();
				setState(2738); table_space();
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
		enterRule(_localctx, 88, RULE_table_body);
		int _la;
		try {
			setState(2752);
			switch ( getInterpreter().adaptivePredict(_input,336,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2742); table_column_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2743); ((Table_bodyContext)_localctx).tabl_constraint = table_constraint();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2744); match(LIKE);
				setState(2745); ((Table_bodyContext)_localctx).parent_table = identifier();
				setState(2749);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==EXCLUDING || _la==INCLUDING) {
					{
					{
					setState(2746); ((Table_bodyContext)_localctx).like_option = like_option();
					((Table_bodyContext)_localctx).like_opt.add(((Table_bodyContext)_localctx).like_option);
					}
					}
					setState(2751);
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
		public Schema_qualified_nameContext datatype_iden;
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
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
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
		enterRule(_localctx, 90, RULE_table_column_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2754); ((Table_column_definitionContext)_localctx).column_name = identifier();
			setState(2757);
			switch ( getInterpreter().adaptivePredict(_input,337,_ctx) ) {
			case 1:
				{
				setState(2755); ((Table_column_definitionContext)_localctx).datatype = data_type();
				}
				break;
			case 2:
				{
				setState(2756); ((Table_column_definitionContext)_localctx).datatype_iden = schema_qualified_name();
				}
				break;
			}
			setState(2761);
			_la = _input.LA(1);
			if (_la==COLLATE) {
				{
				setState(2759); match(COLLATE);
				setState(2760); ((Table_column_definitionContext)_localctx).collation = identifier();
				}
			}

			setState(2766);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (CONSTRAINT - 20)) | (1L << (DEFAULT - 20)) | (1L << (NOT - 20)) | (1L << (NULL - 20)))) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (PRIMARY - 90)) | (1L << (REFERENCES - 90)) | (1L << (UNIQUE - 90)) | (1L << (CHECK - 90)))) != 0)) {
				{
				{
				setState(2763); ((Table_column_definitionContext)_localctx).column_constraint = column_constraint();
				((Table_column_definitionContext)_localctx).colmn_constraint.add(((Table_column_definitionContext)_localctx).column_constraint);
				}
				}
				setState(2768);
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
		enterRule(_localctx, 92, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2769);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(2770);
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
		enterRule(_localctx, 94, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2774);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2772); match(CONSTRAINT);
				setState(2773); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2875);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(2776); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(2777); match(UNIQUE);
				setState(2778); match(LEFT_PAREN);
				setState(2779); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).column_name_unique.add(((Table_constraintContext)_localctx).identifier);
				setState(2784);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2780); match(COMMA);
					setState(2781); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).column_name_unique.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2786);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2787); match(RIGHT_PAREN);
				setState(2788); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2790); match(PRIMARY);
				setState(2791); match(KEY);
				setState(2792); match(LEFT_PAREN);
				setState(2793); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).column_name_pr_key.add(((Table_constraintContext)_localctx).identifier);
				setState(2798);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2794); match(COMMA);
					setState(2795); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).column_name_pr_key.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2800);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2801); match(RIGHT_PAREN);
				setState(2802); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(2804); match(EXCLUDE);
				setState(2807);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(2805); match(USING);
					setState(2806); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(2809); match(LEFT_PAREN);
				setState(2810); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(2811); match(WITH);
				setState(2812); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).operator.add(((Table_constraintContext)_localctx).identifier);
				setState(2817);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2813); match(COMMA);
					setState(2814); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).operator.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2819);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2820); match(RIGHT_PAREN);
				setState(2821); index_parameters();
				setState(2827);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(2822); match(WHERE);
					setState(2823); match(LEFT_PAREN);
					setState(2824); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(2825); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(2829); match(FOREIGN);
				setState(2830); match(KEY);
				setState(2831); match(LEFT_PAREN);
				setState(2832); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).column_name_for_key.add(((Table_constraintContext)_localctx).identifier);
				setState(2837);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2833); match(COMMA);
					setState(2834); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).column_name_for_key.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2839);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2840); match(RIGHT_PAREN);
				setState(2841); match(REFERENCES);
				setState(2842); ((Table_constraintContext)_localctx).reftable = schema_qualified_name();
				setState(2854);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2843); match(LEFT_PAREN);
					setState(2844); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).refcolumn.add(((Table_constraintContext)_localctx).identifier);
					setState(2849);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2845); match(COMMA);
						setState(2846); ((Table_constraintContext)_localctx).identifier = identifier();
						((Table_constraintContext)_localctx).refcolumn.add(((Table_constraintContext)_localctx).identifier);
						}
						}
						setState(2851);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2852); match(RIGHT_PAREN);
					}
				}

				setState(2872);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MATCH || _la==ON) {
					{
					setState(2870);
					switch ( getInterpreter().adaptivePredict(_input,350,_ctx) ) {
					case 1:
						{
						setState(2862);
						switch ( getInterpreter().adaptivePredict(_input,349,_ctx) ) {
						case 1:
							{
							{
							setState(2856); match(MATCH);
							setState(2857); match(FULL);
							}
							}
							break;
						case 2:
							{
							{
							setState(2858); match(MATCH);
							setState(2859); match(PARTIAL);
							}
							}
							break;
						case 3:
							{
							{
							setState(2860); match(MATCH);
							setState(2861); match(SIMPLE);
							}
							}
							break;
						}
						}
						break;
					case 2:
						{
						{
						setState(2864); match(ON);
						setState(2865); match(DELETE);
						setState(2866); ((Table_constraintContext)_localctx).action_on_delete = action();
						}
						}
						break;
					case 3:
						{
						{
						setState(2867); match(ON);
						setState(2868); match(UPDATE);
						setState(2869); ((Table_constraintContext)_localctx).action_on_update = action();
						}
						}
						break;
					}
					}
					setState(2874);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2880);
			switch ( getInterpreter().adaptivePredict(_input,353,_ctx) ) {
			case 1:
				{
				setState(2877); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2878); match(NOT);
				setState(2879); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2886);
			switch ( getInterpreter().adaptivePredict(_input,354,_ctx) ) {
			case 1:
				{
				{
				setState(2882); match(INITIALLY);
				setState(2883); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2884); match(INITIALLY);
				setState(2885); match(IMMEDIATE);
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
		enterRule(_localctx, 96, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2890);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2888); match(CONSTRAINT);
				setState(2889); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2927);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(2892); match(NOT);
				setState(2893); match(NULL);
				}
				break;
			case NULL:
				{
				setState(2894); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(2895); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				setState(2896); match(DEFAULT);
				setState(2899);
				switch ( getInterpreter().adaptivePredict(_input,356,_ctx) ) {
				case 1:
					{
					setState(2897); ((Column_constraintContext)_localctx).default_expr_data = data_type();
					}
					break;
				case 2:
					{
					setState(2898); ((Column_constraintContext)_localctx).default_expr = value_expression();
					}
					break;
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(2901); match(UNIQUE);
				setState(2902); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2903); match(PRIMARY);
				setState(2904); match(KEY);
				setState(2905); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(2906); match(REFERENCES);
				setState(2907); ((Column_constraintContext)_localctx).reftable = schema_qualified_name();
				{
				{
				setState(2908); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(2915);
				switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
				case 1:
					{
					setState(2909); match(MATCH);
					setState(2910); match(FULL);
					}
					break;
				case 2:
					{
					setState(2911); match(MATCH);
					setState(2912); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(2913); match(MATCH);
					setState(2914); match(SIMPLE);
					}
					break;
				}
				setState(2920);
				switch ( getInterpreter().adaptivePredict(_input,358,_ctx) ) {
				case 1:
					{
					setState(2917); match(ON);
					setState(2918); match(DELETE);
					setState(2919); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2925);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(2922); match(ON);
					setState(2923); match(UPDATE);
					setState(2924); ((Column_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2932);
			switch ( getInterpreter().adaptivePredict(_input,361,_ctx) ) {
			case 1:
				{
				setState(2929); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2930); match(NOT);
				setState(2931); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2938);
			switch ( getInterpreter().adaptivePredict(_input,362,_ctx) ) {
			case 1:
				{
				{
				setState(2934); match(INITIALLY);
				setState(2935); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2936); match(INITIALLY);
				setState(2937); match(IMMEDIATE);
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
		enterRule(_localctx, 98, RULE_check_boolean_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2940); match(CHECK);
			setState(2942); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2941); match(LEFT_PAREN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2944); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,363,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(2946); ((Check_boolean_expressionContext)_localctx).expression = value_expression();
			setState(2948); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2947); match(RIGHT_PAREN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2950); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,364,_ctx);
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
		enterRule(_localctx, 100, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2952); match(LEFT_PAREN);
			setState(2961); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2953); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(2956);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(2954); match(EQUAL);
					setState(2955); ((Storage_parameterContext)_localctx).value = value_expression();
					}
				}

				setState(2959);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2958); match(COMMA);
					}
				}

				}
				}
				setState(2963); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0) );
			setState(2965); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 102, RULE_with_storage_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2967); match(WITH);
			setState(2968); storage_parameter();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 104, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2975);
			switch ( getInterpreter().adaptivePredict(_input,368,_ctx) ) {
			case 1:
				{
				setState(2970); with_storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(2971); match(WITH);
				setState(2972); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(2973); match(WITHOUT);
				setState(2974); match(OIDS);
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
		enterRule(_localctx, 106, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2986);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(2977); match(ON);
				setState(2978); match(COMMIT);
				setState(2984);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(2979); match(PRESERVE);
					setState(2980); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(2981); match(DELETE);
					setState(2982); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(2983); match(DROP);
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
		enterRule(_localctx, 108, RULE_table_space);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2990);
			_la = _input.LA(1);
			if (_la==TABLESPACE) {
				{
				setState(2988); match(TABLESPACE);
				setState(2989); ((Table_spaceContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 110, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2998);
			switch ( getInterpreter().adaptivePredict(_input,372,_ctx) ) {
			case 1:
				{
				setState(2992); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(2993); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(2994); match(SET);
				setState(2995); match(NULL);
				}
				break;
			case 4:
				{
				setState(2996); match(SET);
				setState(2997); match(DEFAULT);
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
		enterRule(_localctx, 112, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3001);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(3000); with_storage_parameter();
				}
			}

			setState(3007);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(3003); match(USING);
				setState(3004); match(INDEX);
				setState(3005); match(TABLESPACE);
				setState(3006); ((Index_parametersContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 114, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3009); match(LEFT_PAREN);
			setState(3010); field_element();
			setState(3015);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3011); match(COMMA);
				setState(3012); field_element();
				}
				}
				setState(3017);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3018); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 116, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3020); ((Field_elementContext)_localctx).name = identifier();
			setState(3021); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 118, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3023); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 120, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3025); match(WITH);
			setState(3026); match(LEFT_PAREN);
			setState(3027); param();
			setState(3032);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3028); match(COMMA);
				setState(3029); param();
				}
				}
				setState(3034);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3035); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 122, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3037); ((ParamContext)_localctx).key = identifier();
			setState(3038); match(EQUAL);
			setState(3039); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 124, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3041); match(USING);
			setState(3042); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 126, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3044); match(TABLESPACE);
			setState(3045); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 128, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3047); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_table_partitioning_clauses);
		try {
			setState(3053);
			switch ( getInterpreter().adaptivePredict(_input,377,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3049); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3050); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3051); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3052); column_partitions();
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
		enterRule(_localctx, 132, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3055); match(PARTITION);
			setState(3056); match(BY);
			setState(3057); match(RANGE);
			setState(3058); match(LEFT_PAREN);
			setState(3059); column_reference_list();
			setState(3060); match(RIGHT_PAREN);
			setState(3061); match(LEFT_PAREN);
			setState(3062); range_value_clause_list();
			setState(3063); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 134, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3065); range_value_clause();
			setState(3070);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3066); match(COMMA);
				setState(3067); range_value_clause();
				}
				}
				setState(3072);
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
		enterRule(_localctx, 136, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3073); match(PARTITION);
			setState(3074); partition_name();
			setState(3075); match(VALUES);
			setState(3076); match(LESS);
			setState(3077); match(THAN);
			setState(3089);
			switch ( getInterpreter().adaptivePredict(_input,381,_ctx) ) {
			case 1:
				{
				setState(3078); match(LEFT_PAREN);
				setState(3079); value_expression();
				setState(3080); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(3083);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3082); match(LEFT_PAREN);
					}
				}

				setState(3085); match(MAXVALUE);
				setState(3087);
				switch ( getInterpreter().adaptivePredict(_input,380,_ctx) ) {
				case 1:
					{
					setState(3086); match(RIGHT_PAREN);
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
		enterRule(_localctx, 138, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3091); match(PARTITION);
			setState(3092); match(BY);
			setState(3093); match(HASH);
			setState(3094); match(LEFT_PAREN);
			setState(3095); column_reference_list();
			setState(3096); match(RIGHT_PAREN);
			setState(3102);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(3097); match(LEFT_PAREN);
				setState(3098); individual_hash_partitions();
				setState(3099); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(3101); hash_partitions_by_quantity();
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
		enterRule(_localctx, 140, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3104); individual_hash_partition();
			setState(3109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3105); match(COMMA);
				setState(3106); individual_hash_partition();
				}
				}
				setState(3111);
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
		enterRule(_localctx, 142, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3112); match(PARTITION);
			setState(3113); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 144, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3115); match(PARTITIONS);
			setState(3116); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 146, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3118); match(PARTITION);
			setState(3119); match(BY);
			setState(3120); match(LIST);
			setState(3121); match(LEFT_PAREN);
			setState(3122); column_reference_list();
			setState(3123); match(RIGHT_PAREN);
			setState(3124); match(LEFT_PAREN);
			setState(3125); list_value_clause_list();
			setState(3126); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 148, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3128); list_value_partition();
			setState(3133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3129); match(COMMA);
				setState(3130); list_value_partition();
				}
				}
				setState(3135);
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
		enterRule(_localctx, 150, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3136); match(PARTITION);
			setState(3137); partition_name();
			setState(3138); match(VALUES);
			setState(3140);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(3139); match(IN);
				}
			}

			setState(3142); match(LEFT_PAREN);
			setState(3143); in_value_list();
			setState(3144); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 152, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3146); match(PARTITION);
			setState(3147); match(BY);
			setState(3148); match(COLUMN);
			setState(3149); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 154, RULE_partition_by_columns);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3151); match(PARTITION);
			setState(3152); match(BY);
			setState(3153); schema_qualified_name();
			setState(3158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3154); match(COMMA);
				setState(3155); schema_qualified_name();
				}
				}
				setState(3160);
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
		enterRule(_localctx, 156, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3161); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 158, RULE_drop_table_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3163); match(DROP);
			setState(3164); match(TABLE);
			setState(3165); schema_qualified_name();
			setState(3167);
			_la = _input.LA(1);
			if (_la==PURGE) {
				{
				setState(3166); match(PURGE);
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
		enterRule(_localctx, 160, RULE_identifier);
		int _la;
		try {
			setState(3178);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(3169); match(Identifier);
				}
				break;
			case QuotedIdentifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(3170); match(QuotedIdentifier);
				}
				break;
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
				enterOuterAlt(_localctx, 3);
				{
				setState(3172);
				_la = _input.LA(1);
				if (_la==DOUBLE_QUOTE) {
					{
					setState(3171); match(DOUBLE_QUOTE);
					}
				}

				setState(3174); nonreserved_keywords();
				setState(3176);
				switch ( getInterpreter().adaptivePredict(_input,389,_ctx) ) {
				case 1:
					{
					setState(3175); match(DOUBLE_QUOTE);
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
		enterRule(_localctx, 162, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3180);
			_la = _input.LA(1);
			if ( !(((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || _la==VOID) ) {
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
		enterRule(_localctx, 164, RULE_unsigned_literal);
		try {
			setState(3184);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3182); unsigned_numeric_literal();
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
				setState(3183); general_literal();
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
		enterRule(_localctx, 166, RULE_general_literal);
		try {
			setState(3189);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(3186); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(3187); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(3188); boolean_literal();
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
		enterRule(_localctx, 168, RULE_datetime_literal);
		try {
			setState(3194);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(3191); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3192); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(3193); date_literal();
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
		enterRule(_localctx, 170, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3196); match(TIME);
			setState(3197); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 172, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3199); match(TIMESTAMP);
			setState(3200); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 174, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3202); match(DATE);
			setState(3203); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 176, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3205);
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
		enterRule(_localctx, 178, RULE_data_type);
		try {
			setState(3214);
			switch (_input.LA(1)) {
			case TRIGGER:
			case CHARACTER:
			case DEC:
			case NATIONAL:
			case REGCONFIG:
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
				enterOuterAlt(_localctx, 1);
				{
				setState(3207); predefined_type();
				setState(3210);
				switch ( getInterpreter().adaptivePredict(_input,394,_ctx) ) {
				case 1:
					{
					setState(3208); match(LEFT_BRACKET);
					setState(3209); match(RIGHT_BRACKET);
					}
					break;
				}
				}
				break;
			case SETOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(3212); match(SETOF);
				setState(3213); ((Data_typeContext)_localctx).value = identifier();
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
		enterRule(_localctx, 180, RULE_predefined_type);
		try {
			setState(3231);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
			case INTERVAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3216); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(3217); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(3218); binary_large_object_string_type();
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
				setState(3219); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(3220); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(3221); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(3222); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(3223); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(3224); network_type();
				}
				break;
			case REGCLASS:
				enterOuterAlt(_localctx, 10);
				{
				setState(3225); regclass();
				}
				break;
			case REGCONFIG:
				enterOuterAlt(_localctx, 11);
				{
				setState(3226); match(REGCONFIG);
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 12);
				{
				setState(3227); match(TRIGGER);
				}
				break;
			case UUID:
				enterOuterAlt(_localctx, 13);
				{
				setState(3228); match(UUID);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 14);
				{
				setState(3229); match(VOID);
				}
				break;
			case INET:
				enterOuterAlt(_localctx, 15);
				{
				setState(3230); match(INET);
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
		enterRule(_localctx, 182, RULE_regclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3233); match(REGCLASS);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 184, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3235); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 186, RULE_character_string_type);
		try {
			setState(3261);
			switch ( getInterpreter().adaptivePredict(_input,402,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3237); match(CHARACTER);
				setState(3239);
				switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
				case 1:
					{
					setState(3238); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3241); match(CHAR);
				setState(3243);
				switch ( getInterpreter().adaptivePredict(_input,398,_ctx) ) {
				case 1:
					{
					setState(3242); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3245); match(CHARACTER);
				setState(3246); match(VARYING);
				setState(3248);
				switch ( getInterpreter().adaptivePredict(_input,399,_ctx) ) {
				case 1:
					{
					setState(3247); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3250); match(CHAR);
				setState(3251); match(VARYING);
				setState(3253);
				switch ( getInterpreter().adaptivePredict(_input,400,_ctx) ) {
				case 1:
					{
					setState(3252); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3255); match(VARCHAR);
				setState(3257);
				switch ( getInterpreter().adaptivePredict(_input,401,_ctx) ) {
				case 1:
					{
					setState(3256); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3259); match(TEXT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3260); match(INTERVAL);
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
		enterRule(_localctx, 188, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3263); match(LEFT_PAREN);
			setState(3264); match(NUMBER);
			setState(3265); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 190, RULE_national_character_string_type);
		try {
			setState(3302);
			switch ( getInterpreter().adaptivePredict(_input,410,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3267); match(NATIONAL);
				setState(3268); match(CHARACTER);
				setState(3270);
				switch ( getInterpreter().adaptivePredict(_input,403,_ctx) ) {
				case 1:
					{
					setState(3269); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3272); match(NATIONAL);
				setState(3273); match(CHAR);
				setState(3275);
				switch ( getInterpreter().adaptivePredict(_input,404,_ctx) ) {
				case 1:
					{
					setState(3274); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3277); match(NCHAR);
				setState(3279);
				switch ( getInterpreter().adaptivePredict(_input,405,_ctx) ) {
				case 1:
					{
					setState(3278); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3281); match(NATIONAL);
				setState(3282); match(CHARACTER);
				setState(3283); match(VARYING);
				setState(3285);
				switch ( getInterpreter().adaptivePredict(_input,406,_ctx) ) {
				case 1:
					{
					setState(3284); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3287); match(NATIONAL);
				setState(3288); match(CHAR);
				setState(3289); match(VARYING);
				setState(3291);
				switch ( getInterpreter().adaptivePredict(_input,407,_ctx) ) {
				case 1:
					{
					setState(3290); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3293); match(NCHAR);
				setState(3294); match(VARYING);
				setState(3296);
				switch ( getInterpreter().adaptivePredict(_input,408,_ctx) ) {
				case 1:
					{
					setState(3295); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3298); match(NVARCHAR);
				setState(3300);
				switch ( getInterpreter().adaptivePredict(_input,409,_ctx) ) {
				case 1:
					{
					setState(3299); type_length();
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
		enterRule(_localctx, 192, RULE_binary_large_object_string_type);
		try {
			setState(3312);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(3304); match(BLOB);
				setState(3306);
				switch ( getInterpreter().adaptivePredict(_input,411,_ctx) ) {
				case 1:
					{
					setState(3305); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(3308); match(BYTEA);
				setState(3310);
				switch ( getInterpreter().adaptivePredict(_input,412,_ctx) ) {
				case 1:
					{
					setState(3309); type_length();
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
		enterRule(_localctx, 194, RULE_numeric_type);
		try {
			setState(3316);
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
				setState(3314); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3315); approximate_numeric_type();
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
		enterRule(_localctx, 196, RULE_exact_numeric_type);
		try {
			setState(3339);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(3318); match(NUMERIC);
				setState(3320);
				switch ( getInterpreter().adaptivePredict(_input,415,_ctx) ) {
				case 1:
					{
					setState(3319); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(3322); match(DECIMAL);
				setState(3324);
				switch ( getInterpreter().adaptivePredict(_input,416,_ctx) ) {
				case 1:
					{
					setState(3323); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(3326); match(DEC);
				setState(3328);
				switch ( getInterpreter().adaptivePredict(_input,417,_ctx) ) {
				case 1:
					{
					setState(3327); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(3330); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(3331); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(3332); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(3333); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(3334); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(3335); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(3336); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(3337); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(3338); match(BIGINT);
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
		enterRule(_localctx, 198, RULE_approximate_numeric_type);
		try {
			setState(3351);
			switch ( getInterpreter().adaptivePredict(_input,420,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3341); match(FLOAT);
				setState(3343);
				switch ( getInterpreter().adaptivePredict(_input,419,_ctx) ) {
				case 1:
					{
					setState(3342); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3345); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3346); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3347); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3348); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3349); match(DOUBLE);
				setState(3350); match(PRECISION);
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
		enterRule(_localctx, 200, RULE_precision_param);
		try {
			setState(3361);
			switch ( getInterpreter().adaptivePredict(_input,421,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3353); match(LEFT_PAREN);
				setState(3354); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(3355); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3356); match(LEFT_PAREN);
				setState(3357); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(3358); match(COMMA);
				setState(3359); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(3360); match(RIGHT_PAREN);
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
		enterRule(_localctx, 202, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3363);
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
		enterRule(_localctx, 204, RULE_datetime_type);
		try {
			setState(3382);
			switch ( getInterpreter().adaptivePredict(_input,422,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3365); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3366); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3367); match(TIME);
				setState(3368); match(WITH);
				setState(3369); match(TIME);
				setState(3370); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3371); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3372); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3373); match(TIMESTAMP);
				setState(3374); match(WITH);
				setState(3375); match(TIME);
				setState(3376); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3377); match(TIMESTAMP);
				setState(3378); match(WITHOUT);
				setState(3379); match(TIME);
				setState(3380); match(ZONE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(3381); match(TIMESTAMPTZ);
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
		enterRule(_localctx, 206, RULE_bit_type);
		try {
			setState(3397);
			switch ( getInterpreter().adaptivePredict(_input,426,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3384); match(BIT);
				setState(3386);
				switch ( getInterpreter().adaptivePredict(_input,423,_ctx) ) {
				case 1:
					{
					setState(3385); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3388); match(VARBIT);
				setState(3390);
				switch ( getInterpreter().adaptivePredict(_input,424,_ctx) ) {
				case 1:
					{
					setState(3389); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3392); match(BIT);
				setState(3393); match(VARYING);
				setState(3395);
				switch ( getInterpreter().adaptivePredict(_input,425,_ctx) ) {
				case 1:
					{
					setState(3394); type_length();
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
		enterRule(_localctx, 208, RULE_binary_type);
		try {
			setState(3412);
			switch ( getInterpreter().adaptivePredict(_input,430,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3399); match(BINARY);
				setState(3401);
				switch ( getInterpreter().adaptivePredict(_input,427,_ctx) ) {
				case 1:
					{
					setState(3400); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3403); match(BINARY);
				setState(3404); match(VARYING);
				setState(3406);
				switch ( getInterpreter().adaptivePredict(_input,428,_ctx) ) {
				case 1:
					{
					setState(3405); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3408); match(VARBINARY);
				setState(3410);
				switch ( getInterpreter().adaptivePredict(_input,429,_ctx) ) {
				case 1:
					{
					setState(3409); type_length();
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
		enterRule(_localctx, 210, RULE_value_expression_primary);
		try {
			setState(3416);
			switch ( getInterpreter().adaptivePredict(_input,431,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3414); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3415); nonparenthesized_value_expression_primary();
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
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
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
		enterRule(_localctx, 212, RULE_parenthesized_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3418); match(LEFT_PAREN);
			setState(3421); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(3421);
				switch ( getInterpreter().adaptivePredict(_input,432,_ctx) ) {
				case 1:
					{
					setState(3419);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==LEFT_PAREN || _la==RIGHT_PAREN) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case 2:
					{
					setState(3420); value_expression();
					}
					break;
				}
				}
				setState(3423); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << ALTER) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << HANDLER) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INLINE) | (1L << INNER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTERSECT - 64)) | (1L << (INTO - 64)) | (1L << (INOUT - 64)) | (1L << (INSTEAD - 64)) | (1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (OWNER - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRUSTED - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (VALIDATOR - 128)) | (1L << (VARIADIC - 128)) | (1L << (VIEW - 128)) | (1L << (WHEN - 128)) | (1L << (WHERE - 128)) | (1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (ALWAYS - 128)) | (1L << (ARRAY - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (CLUSTER - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONCURRENTLY - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DISABLE - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (ENABLE - 128)) | (1L << (EPOCH - 128)) | (1L << (EVENT - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTENDED - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INHERIT - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (INSERT - 192)) | (1L << (INTERSECTION - 192)) | (1L << (ISCACHABLE - 192)) | (1L << (ISODOW - 192)) | (1L << (ISOYEAR - 192)) | (1L << (ISSTRICT - 192)) | (1L << (LANGUAGE - 192)) | (1L << (LARGE - 192)) | (1L << (LAST - 192)) | (1L << (LESS - 192)) | (1L << (LIST - 192)) | (1L << (LOCATION - 192)) | (1L << (MAIN - 192)) | (1L << (MATCH - 192)) | (1L << (MAX - 192)) | (1L << (MAXVALUE - 192)) | (1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (N_DISTINCT - 192)) | (1L << (N_DISTINCT_INHERITED - 192)) | (1L << (OBJECT - 192)) | (1L << (ON - 192)) | (1L << (ONLY - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVER - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PLAIN - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGCONFIG - 192)) | (1L << (REGEXP - 192)) | (1L << (RENAME - 192)) | (1L << (REPLICA - 192)) | (1L << (RESET - 192)) | (1L << (RESTART - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STATISTICS - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (STORAGE - 256)) | (1L << (STDDEV_POP - 256)) | (1L << (STDDEV_SAMP - 256)) | (1L << (SUBPARTITION - 256)) | (1L << (SUM - 256)) | (1L << (TABLESPACE - 256)) | (1L << (TABLES - 256)) | (1L << (TEMPLATE - 256)) | (1L << (THAN - 256)) | (1L << (TIMEZONE - 256)) | (1L << (TIMEZONE_HOUR - 256)) | (1L << (TIMEZONE_MINUTE - 256)) | (1L << (TRIM - 256)) | (1L << (TO - 256)) | (1L << (TYPE - 256)) | (1L << (TYPES - 256)) | (1L << (UNKNOWN - 256)) | (1L << (UNLOGGED - 256)) | (1L << (USER - 256)) | (1L << (VALID - 256)) | (1L << (VALIDATE - 256)) | (1L << (VALUES - 256)) | (1L << (VAR_SAMP - 256)) | (1L << (VAR_POP - 256)) | (1L << (VARYING - 256)) | (1L << (VERSION - 256)) | (1L << (VOLATILE - 256)) | (1L << (WEEK - 256)) | (1L << (WINDOW - 256)) | (1L << (WRAPPER - 256)) | (1L << (YEAR - 256)) | (1L << (ZONE - 256)) | (1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (BINARY - 320)) | (1L << (VARBINARY - 320)) | (1L << (BLOB - 320)) | (1L << (BYTEA - 320)) | (1L << (INET4 - 320)) | (1L << (INET - 320)) | (1L << (INTERVAL - 320)) | (1L << (VOID - 320)) | (1L << (Similar_To - 320)) | (1L << (Not_Similar_To - 320)) | (1L << (Similar_To_Case_Insensitive - 320)) | (1L << (Not_Similar_To_Case_Insensitive - 320)) | (1L << (CAST_EXPRESSION - 320)) | (1L << (ASSIGN - 320)) | (1L << (EQUAL - 320)) | (1L << (COLON - 320)) | (1L << (SEMI_COLON - 320)) | (1L << (COMMA - 320)) | (1L << (CONCATENATION_OPERATOR - 320)) | (1L << (NOT_EQUAL - 320)) | (1L << (LTH - 320)) | (1L << (LEQ - 320)) | (1L << (GTH - 320)) | (1L << (GEQ - 320)) | (1L << (LEFT_PAREN - 320)) | (1L << (PLUS - 320)) | (1L << (MINUS - 320)) | (1L << (MULTIPLY - 320)) | (1L << (DIVIDE - 320)) | (1L << (MODULAR - 320)) | (1L << (DOT - 320)) | (1L << (UNDERLINE - 320)) | (1L << (VERTICAL_BAR - 320)) | (1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (LEFT_BRACKET - 320)) | (1L << (RIGHT_BRACKET - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (QuotedIdentifier - 320)) | (1L << (UnterminatedQuotedIdentifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (DOLLAR_FIELD - 320)) | (1L << (BeginDollarStringConstant - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)) | (1L << (Text_between_Dollar - 320)) | (1L << (EndDollarStringConstant - 320)))) != 0) );
			setState(3425); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 214, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(3435);
			switch ( getInterpreter().adaptivePredict(_input,434,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3427); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3428); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3429); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3430); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3431); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3432); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3433); routine_invocation();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(3434); match(NULL);
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
		enterRule(_localctx, 216, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3437); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 218, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3439);
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
		enterRule(_localctx, 220, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3442);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(3441); sign();
				}
			}

			setState(3444); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 222, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3446); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 224, RULE_aggregate_function);
		try {
			setState(3456);
			switch ( getInterpreter().adaptivePredict(_input,437,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3448); match(COUNT);
				setState(3449); match(LEFT_PAREN);
				setState(3450); match(MULTIPLY);
				setState(3451); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3452); general_set_function();
				setState(3454);
				switch ( getInterpreter().adaptivePredict(_input,436,_ctx) ) {
				case 1:
					{
					setState(3453); filter_clause();
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
		enterRule(_localctx, 226, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3458); set_function_type();
			setState(3459); match(LEFT_PAREN);
			setState(3461);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(3460); set_qualifier();
				}
			}

			setState(3463); value_expression();
			setState(3464); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 228, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3466);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & ((1L << (SOME - 110)) | (1L << (AVG - 110)) | (1L << (COLLECT - 110)) | (1L << (COUNT - 110)))) != 0) || ((((_la - 174)) & ~0x3f) == 0 && ((1L << (_la - 174)) & ((1L << (EVERY - 174)) | (1L << (FUSION - 174)) | (1L << (INTERSECTION - 174)) | (1L << (MAX - 174)) | (1L << (MIN - 174)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (STDDEV_POP - 257)) | (1L << (STDDEV_SAMP - 257)) | (1L << (SUM - 257)) | (1L << (VAR_SAMP - 257)) | (1L << (VAR_POP - 257)))) != 0)) ) {
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
		enterRule(_localctx, 230, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3468); match(FILTER);
			setState(3469); match(LEFT_PAREN);
			setState(3470); match(WHERE);
			setState(3471); search_condition();
			setState(3472); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 232, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3474); match(GROUPING);
			setState(3475); match(LEFT_PAREN);
			setState(3476); column_reference_list();
			setState(3477); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 234, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3479); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 236, RULE_case_abbreviation);
		int _la;
		try {
			setState(3499);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(3481); match(NULLIF);
				setState(3482); match(LEFT_PAREN);
				setState(3483); numeric_value_expression();
				setState(3484); match(COMMA);
				setState(3485); boolean_value_expression();
				setState(3486); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3488); match(COALESCE);
				setState(3489); match(LEFT_PAREN);
				setState(3490); numeric_value_expression();
				setState(3493); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(3491); match(COMMA);
					setState(3492); boolean_value_expression();
					}
					}
					setState(3495); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(3497); match(RIGHT_PAREN);
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
		enterRule(_localctx, 238, RULE_case_specification);
		try {
			setState(3503);
			switch ( getInterpreter().adaptivePredict(_input,441,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3501); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3502); searched_case();
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
		enterRule(_localctx, 240, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3505); match(CASE);
			setState(3506); boolean_value_expression();
			setState(3508); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3507); simple_when_clause();
				}
				}
				setState(3510); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(3513);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(3512); else_clause();
				}
			}

			setState(3515); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 242, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3517); match(CASE);
			setState(3519); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3518); searched_when_clause();
				}
				}
				setState(3521); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(3524);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(3523); else_clause();
				}
			}

			setState(3526); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 244, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3528); match(WHEN);
			setState(3529); search_condition();
			setState(3530); match(THEN);
			setState(3531); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 246, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3533); match(WHEN);
			setState(3534); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(3535); match(THEN);
			setState(3536); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 248, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3538); match(ELSE);
			setState(3539); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 250, RULE_result);
		try {
			setState(3543);
			switch ( getInterpreter().adaptivePredict(_input,446,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3541); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3542); match(NULL);
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
		enterRule(_localctx, 252, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3545); match(CAST);
			setState(3546); match(LEFT_PAREN);
			setState(3547); cast_operand();
			setState(3548); match(AS);
			setState(3549); cast_target();
			setState(3550); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 254, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3552); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 256, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3554); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 258, RULE_value_expression);
		try {
			setState(3560);
			switch ( getInterpreter().adaptivePredict(_input,447,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3556); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3557); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3558); boolean_value_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3559); array_expression();
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
		enterRule(_localctx, 260, RULE_array_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3562); match(ARRAY);
			setState(3563); match(LEFT_BRACKET);
			setState(3564); value_expression();
			setState(3569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3565); match(COMMA);
				setState(3566); value_expression();
				}
				}
				setState(3571);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3572); match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 262, RULE_common_value_expression);
		try {
			setState(3577);
			switch ( getInterpreter().adaptivePredict(_input,449,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3574); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3575); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3576); match(NULL);
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
		enterRule(_localctx, 264, RULE_numeric_value_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3579); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(3584);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,450,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3580);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(3581); ((Numeric_value_expressionContext)_localctx).right = term();
					}
					} 
				}
				setState(3586);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,450,_ctx);
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
		enterRule(_localctx, 266, RULE_term);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3587); ((TermContext)_localctx).left = factor();
			setState(3592);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,451,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3588);
					_la = _input.LA(1);
					if ( !(((((_la - 348)) & ~0x3f) == 0 && ((1L << (_la - 348)) & ((1L << (MULTIPLY - 348)) | (1L << (DIVIDE - 348)) | (1L << (MODULAR - 348)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(3589); ((TermContext)_localctx).right = factor();
					}
					} 
				}
				setState(3594);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,451,_ctx);
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
		enterRule(_localctx, 268, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3596);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(3595); sign();
				}
			}

			setState(3598); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 270, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3600); match(LEFT_PAREN);
			setState(3601); numeric_value_expression();
			setState(3606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3602); match(COMMA);
				setState(3603); numeric_value_expression();
				}
				}
				setState(3608);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3609); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 272, RULE_numeric_primary);
		try {
			int _alt;
			setState(3620);
			switch ( getInterpreter().adaptivePredict(_input,455,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3611); value_expression_primary();
				setState(3616);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,454,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(3612); match(CAST_EXPRESSION);
						setState(3613); cast_target();
						}
						} 
					}
					setState(3618);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,454,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3619); numeric_value_function();
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
		enterRule(_localctx, 274, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3622);
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
		enterRule(_localctx, 276, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3624); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 278, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3626); match(EXTRACT);
			setState(3627); match(LEFT_PAREN);
			setState(3628); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(3629); match(FROM);
			setState(3630); extract_source();
			setState(3631); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 280, RULE_extract_field);
		try {
			setState(3636);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3633); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3634); time_zone_field();
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
				setState(3635); extended_datetime_field();
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
		enterRule(_localctx, 282, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3638);
			_la = _input.LA(1);
			if ( !(((((_la - 265)) & ~0x3f) == 0 && ((1L << (_la - 265)) & ((1L << (TIMEZONE - 265)) | (1L << (TIMEZONE_HOUR - 265)) | (1L << (TIMEZONE_MINUTE - 265)))) != 0)) ) {
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
		enterRule(_localctx, 284, RULE_extract_source);
		try {
			setState(3642);
			switch ( getInterpreter().adaptivePredict(_input,457,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3640); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3641); datetime_literal();
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
		enterRule(_localctx, 286, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3644); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 288, RULE_character_value_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3646); character_factor();
			setState(3651);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,458,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3647); match(CONCATENATION_OPERATOR);
					setState(3648); character_factor();
					}
					} 
				}
				setState(3653);
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
		enterRule(_localctx, 290, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3654); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 292, RULE_character_primary);
		try {
			setState(3658);
			switch ( getInterpreter().adaptivePredict(_input,459,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3656); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3657); string_value_function();
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
		enterRule(_localctx, 294, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3660); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 296, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3662); match(TRIM);
			setState(3663); match(LEFT_PAREN);
			setState(3664); trim_operands();
			setState(3665); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 298, RULE_trim_operands);
		int _la;
		try {
			setState(3681);
			switch ( getInterpreter().adaptivePredict(_input,463,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3674);
				switch ( getInterpreter().adaptivePredict(_input,462,_ctx) ) {
				case 1:
					{
					setState(3668);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(3667); trim_specification();
						}
					}

					setState(3671);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LEFT - 73)) | (1L << (NULL - 73)) | (1L << (RIGHT - 73)) | (1L << (SOME - 73)) | (1L << (TRUE - 73)) | (1L << (ADMIN - 73)) | (1L << (ALWAYS - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (ARRAY - 137)) | (1L << (AVG - 137)) | (1L << (BETWEEN - 137)) | (1L << (BY - 137)) | (1L << (CACHE - 137)) | (1L << (CALLED - 137)) | (1L << (CLASS - 137)) | (1L << (CENTURY - 137)) | (1L << (CHARACTER - 137)) | (1L << (CHECK - 137)) | (1L << (CLUSTER - 137)) | (1L << (COLLECT - 137)) | (1L << (COALESCE - 137)) | (1L << (COLUMN - 137)) | (1L << (COMMENT - 137)) | (1L << (COMMENTS - 137)) | (1L << (COMMIT - 137)) | (1L << (CONCURRENTLY - 137)) | (1L << (CONFIGURATION - 137)) | (1L << (COST - 137)) | (1L << (COUNT - 137)) | (1L << (CUBE - 137)) | (1L << (CURRENT - 137)) | (1L << (CYCLE - 137)) | (1L << (DATA - 137)) | (1L << (DAY - 137)) | (1L << (DEC - 137)) | (1L << (DECADE - 137)) | (1L << (DEFINER - 137)) | (1L << (DICTIONARY - 137)) | (1L << (DISABLE - 137)) | (1L << (DOW - 137)) | (1L << (DOY - 137)) | (1L << (DROP - 137)) | (1L << (ENABLE - 137)) | (1L << (EPOCH - 137)) | (1L << (EVENT - 137)) | (1L << (EVERY - 137)) | (1L << (EXISTS - 137)) | (1L << (EXTENDED - 137)) | (1L << (EXTERNAL - 137)) | (1L << (EXTRACT - 137)) | (1L << (FAMILY - 137)) | (1L << (FILTER - 137)) | (1L << (FIRST - 137)) | (1L << (FORMAT - 137)) | (1L << (FUSION - 137)) | (1L << (GROUPING - 137)) | (1L << (HASH - 137)) | (1L << (INHERIT - 137)) | (1L << (INDEX - 137)) | (1L << (INCREMENT - 137)) | (1L << (INPUT - 137)) | (1L << (INSERT - 137)) | (1L << (INTERSECTION - 137)) | (1L << (ISCACHABLE - 137)) | (1L << (ISODOW - 137)) | (1L << (ISOYEAR - 137)) | (1L << (ISSTRICT - 137)) | (1L << (LANGUAGE - 137)) | (1L << (LARGE - 137)) | (1L << (LAST - 137)))) != 0) || ((((_la - 201)) & ~0x3f) == 0 && ((1L << (_la - 201)) & ((1L << (LESS - 201)) | (1L << (LIST - 201)) | (1L << (LOCATION - 201)) | (1L << (MAIN - 201)) | (1L << (MATCH - 201)) | (1L << (MAX - 201)) | (1L << (MAXVALUE - 201)) | (1L << (MICROSECONDS - 201)) | (1L << (MILLENNIUM - 201)) | (1L << (MILLISECONDS - 201)) | (1L << (MIN - 201)) | (1L << (MINVALUE - 201)) | (1L << (MINUTE - 201)) | (1L << (MONTH - 201)) | (1L << (NATIONAL - 201)) | (1L << (NO - 201)) | (1L << (NONE - 201)) | (1L << (NULLIF - 201)) | (1L << (OBJECT - 201)) | (1L << (ON - 201)) | (1L << (ONLY - 201)) | (1L << (OPTION - 201)) | (1L << (OPTIONS - 201)) | (1L << (OVER - 201)) | (1L << (OVERWRITE - 201)) | (1L << (PARSER - 201)) | (1L << (PARTIAL - 201)) | (1L << (PARTITION - 201)) | (1L << (PARTITIONS - 201)) | (1L << (PLAIN - 201)) | (1L << (PRECISION - 201)) | (1L << (PUBLIC - 201)) | (1L << (PURGE - 201)) | (1L << (QUARTER - 201)) | (1L << (RANGE - 201)) | (1L << (REGCONFIG - 201)) | (1L << (REGEXP - 201)) | (1L << (RENAME - 201)) | (1L << (REPLICA - 201)) | (1L << (RESET - 201)) | (1L << (RESTART - 201)) | (1L << (RLIKE - 201)) | (1L << (ROLLUP - 201)) | (1L << (SEARCH - 201)) | (1L << (SECOND - 201)) | (1L << (SECURITY - 201)) | (1L << (SERVER - 201)) | (1L << (SET - 201)) | (1L << (SIMILAR - 201)) | (1L << (SIMPLE - 201)) | (1L << (STABLE - 201)) | (1L << (START - 201)) | (1L << (STATISTICS - 201)) | (1L << (STORAGE - 201)) | (1L << (STDDEV_POP - 201)) | (1L << (STDDEV_SAMP - 201)) | (1L << (SUBPARTITION - 201)) | (1L << (SUM - 201)) | (1L << (TABLESPACE - 201)) | (1L << (TEMPLATE - 201)) | (1L << (THAN - 201)))) != 0) || ((((_la - 265)) & ~0x3f) == 0 && ((1L << (_la - 265)) & ((1L << (TIMEZONE - 265)) | (1L << (TIMEZONE_HOUR - 265)) | (1L << (TIMEZONE_MINUTE - 265)) | (1L << (TRIM - 265)) | (1L << (TO - 265)) | (1L << (TYPE - 265)) | (1L << (TYPES - 265)) | (1L << (UNKNOWN - 265)) | (1L << (UNLOGGED - 265)) | (1L << (USER - 265)) | (1L << (VALID - 265)) | (1L << (VALIDATE - 265)) | (1L << (VALUES - 265)) | (1L << (VAR_SAMP - 265)) | (1L << (VAR_POP - 265)) | (1L << (VARYING - 265)) | (1L << (VERSION - 265)) | (1L << (VOLATILE - 265)) | (1L << (WEEK - 265)) | (1L << (WINDOW - 265)) | (1L << (WRAPPER - 265)) | (1L << (YEAR - 265)) | (1L << (ZONE - 265)) | (1L << (BOOLEAN - 265)) | (1L << (BOOL - 265)) | (1L << (BIT - 265)) | (1L << (VARBIT - 265)) | (1L << (INT1 - 265)) | (1L << (INT2 - 265)) | (1L << (INT4 - 265)) | (1L << (INT8 - 265)) | (1L << (TINYINT - 265)) | (1L << (SMALLINT - 265)) | (1L << (INT - 265)) | (1L << (INTEGER - 265)) | (1L << (BIGINT - 265)) | (1L << (FLOAT4 - 265)) | (1L << (FLOAT8 - 265)) | (1L << (REAL - 265)) | (1L << (FLOAT - 265)) | (1L << (DOUBLE - 265)) | (1L << (NUMERIC - 265)) | (1L << (DECIMAL - 265)) | (1L << (CHAR - 265)) | (1L << (VARCHAR - 265)) | (1L << (NCHAR - 265)) | (1L << (NVARCHAR - 265)) | (1L << (DATE - 265)) | (1L << (TIME - 265)) | (1L << (TIMETZ - 265)) | (1L << (TIMESTAMP - 265)) | (1L << (TIMESTAMPTZ - 265)) | (1L << (TEXT - 265)) | (1L << (UUID - 265)) | (1L << (VARBINARY - 265)) | (1L << (BLOB - 265)) | (1L << (BYTEA - 265)) | (1L << (INET4 - 265)) | (1L << (INET - 265)) | (1L << (INTERVAL - 265)) | (1L << (VOID - 265)))) != 0) || ((((_la - 344)) & ~0x3f) == 0 && ((1L << (_la - 344)) & ((1L << (LEFT_PAREN - 344)) | (1L << (DOUBLE_QUOTE - 344)) | (1L << (NUMBER - 344)) | (1L << (REAL_NUMBER - 344)) | (1L << (Identifier - 344)) | (1L << (QuotedIdentifier - 344)) | (1L << (Character_String_Literal - 344)))) != 0)) {
						{
						setState(3670); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(3673); match(FROM);
					}
					break;
				}
				setState(3676); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3677); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(3678); match(COMMA);
				setState(3679); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
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
		enterRule(_localctx, 300, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3683);
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
		enterRule(_localctx, 302, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3685); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 304, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3687); and_predicate();
			setState(3692);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,464,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3688); match(OR);
					setState(3689); or_predicate();
					}
					} 
				}
				setState(3694);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,464,_ctx);
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
		enterRule(_localctx, 306, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3695); boolean_factor();
			setState(3700);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,465,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3696); match(AND);
					setState(3697); and_predicate();
					}
					} 
				}
				setState(3702);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,465,_ctx);
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
		enterRule(_localctx, 308, RULE_boolean_factor);
		try {
			setState(3706);
			switch ( getInterpreter().adaptivePredict(_input,466,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3703); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3704); match(NOT);
				setState(3705); boolean_test();
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
		enterRule(_localctx, 310, RULE_boolean_test);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3708); boolean_primary();
			setState(3710);
			switch ( getInterpreter().adaptivePredict(_input,467,_ctx) ) {
			case 1:
				{
				setState(3709); is_clause();
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
		enterRule(_localctx, 312, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3712); match(IS);
			setState(3714);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3713); match(NOT);
				}
			}

			setState(3716); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 314, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3718);
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
		enterRule(_localctx, 316, RULE_boolean_primary);
		try {
			setState(3722);
			switch ( getInterpreter().adaptivePredict(_input,469,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3720); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3721); boolean_predicand();
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
		enterRule(_localctx, 318, RULE_boolean_predicand);
		try {
			setState(3726);
			switch ( getInterpreter().adaptivePredict(_input,470,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3724); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3725); nonparenthesized_value_expression_primary();
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
		enterRule(_localctx, 320, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3728); match(LEFT_PAREN);
			setState(3729); boolean_value_expression();
			setState(3730); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 322, RULE_row_value_expression);
		try {
			setState(3734);
			switch ( getInterpreter().adaptivePredict(_input,471,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3732); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3733); explicit_row_value_constructor();
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
		enterRule(_localctx, 324, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3736); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 326, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3738); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 328, RULE_row_value_predicand);
		try {
			setState(3742);
			switch ( getInterpreter().adaptivePredict(_input,472,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3740); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3741); row_value_constructor_predicand();
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
		enterRule(_localctx, 330, RULE_row_value_constructor_predicand);
		try {
			setState(3746);
			switch ( getInterpreter().adaptivePredict(_input,473,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3744); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3745); boolean_predicand();
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
		enterRule(_localctx, 332, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3748); from_clause();
			setState(3750);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(3749); where_clause();
				}
			}

			setState(3753);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(3752); groupby_clause();
				}
			}

			setState(3756);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(3755); having_clause();
				}
			}

			setState(3759);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(3758); orderby_clause();
				}
			}

			setState(3762);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(3761); limit_clause();
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
		enterRule(_localctx, 334, RULE_from_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3764); match(FROM);
			setState(3765); match(LEFT_PAREN);
			setState(3768);
			switch (_input.LA(1)) {
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
				setState(3766); table_reference_list();
				}
				break;
			case SELECT:
				{
				setState(3767); query_specification();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(3770); match(RIGHT_PAREN);
			setState(3772);
			_la = _input.LA(1);
			if (_la==AS || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0)) {
				{
				setState(3771); as_clause();
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
		enterRule(_localctx, 336, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3774); table_reference();
			setState(3779);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3775); match(COMMA);
				setState(3776); table_reference();
				}
				}
				setState(3781);
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
		enterRule(_localctx, 338, RULE_table_reference);
		try {
			setState(3784);
			switch ( getInterpreter().adaptivePredict(_input,482,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3782); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3783); table_primary();
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
		enterRule(_localctx, 340, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3786); table_primary();
			setState(3788); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(3787); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(3790); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,483,_ctx);
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
		enterRule(_localctx, 342, RULE_joined_table_primary);
		int _la;
		try {
			setState(3811);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(3792); match(CROSS);
				setState(3793); match(JOIN);
				setState(3794); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3796);
				_la = _input.LA(1);
				if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
					{
					setState(3795); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3798); match(JOIN);
				setState(3799); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(3800); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(3802); match(NATURAL);
				setState(3804);
				_la = _input.LA(1);
				if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
					{
					setState(3803); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3806); match(JOIN);
				setState(3807); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(3808); match(UNION);
				setState(3809); match(JOIN);
				setState(3810); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 344, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3813); match(CROSS);
			setState(3814); match(JOIN);
			setState(3815); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 346, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3818);
			_la = _input.LA(1);
			if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
				{
				setState(3817); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(3820); match(JOIN);
			setState(3821); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(3822); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 348, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3824); match(NATURAL);
			setState(3826);
			_la = _input.LA(1);
			if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
				{
				setState(3825); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(3828); match(JOIN);
			setState(3829); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 350, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3831); match(UNION);
			setState(3832); match(JOIN);
			setState(3833); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 352, RULE_join_type);
		try {
			setState(3837);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3835); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3836); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 354, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3839); outer_join_type_part2();
			setState(3841);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(3840); match(OUTER);
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
		enterRule(_localctx, 356, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3843);
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
		enterRule(_localctx, 358, RULE_join_specification);
		try {
			setState(3847);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(3845); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(3846); named_columns_join();
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
		enterRule(_localctx, 360, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3849); match(ON);
			setState(3850); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 362, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3852); match(USING);
			setState(3853); match(LEFT_PAREN);
			setState(3854); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(3855); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 364, RULE_table_primary);
		int _la;
		try {
			setState(3884);
			switch (_input.LA(1)) {
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
				enterOuterAlt(_localctx, 1);
				{
				setState(3859);
				switch ( getInterpreter().adaptivePredict(_input,492,_ctx) ) {
				case 1:
					{
					setState(3857); alias_table();
					}
					break;
				case 2:
					{
					setState(3858); table_or_query_name();
					}
					break;
				}
				setState(3865);
				switch ( getInterpreter().adaptivePredict(_input,494,_ctx) ) {
				case 1:
					{
					setState(3862);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(3861); match(AS);
						}
					}

					setState(3864); ((Table_primaryContext)_localctx).alias = alias_def();
					}
					break;
				}
				setState(3871);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3867); match(LEFT_PAREN);
					setState(3868); column_name_list();
					setState(3869); match(RIGHT_PAREN);
					}
				}

				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3873); derived_table();
				setState(3875);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3874); match(AS);
					}
				}

				setState(3877); ((Table_primaryContext)_localctx).name = identifier();
				setState(3882);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3878); match(LEFT_PAREN);
					setState(3879); column_name_list();
					setState(3880); match(RIGHT_PAREN);
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
		enterRule(_localctx, 366, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3886); identifier();
			setState(3891);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3887); match(COMMA);
				setState(3888); identifier();
				}
				}
				setState(3893);
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
		enterRule(_localctx, 368, RULE_alias_def);
		try {
			setState(3896);
			switch ( getInterpreter().adaptivePredict(_input,500,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3894); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3895); alias_table();
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
		enterRule(_localctx, 370, RULE_alias_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3898); schema_qualified_name();
			setState(3899); match(LEFT_PAREN);
			setState(3908);
			_la = _input.LA(1);
			if (((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0)) {
				{
				setState(3900); identifier();
				setState(3905);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(3901); match(COMMA);
					setState(3902); identifier();
					}
					}
					setState(3907);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(3910); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 372, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3912); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 374, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3914); match(WHERE);
			setState(3915); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 376, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3918);
			switch ( getInterpreter().adaptivePredict(_input,503,_ctx) ) {
			case 1:
				{
				setState(3917); match(LEFT_PAREN);
				}
				break;
			}
			setState(3920); value_expression();
			setState(3922);
			switch ( getInterpreter().adaptivePredict(_input,504,_ctx) ) {
			case 1:
				{
				setState(3921); match(RIGHT_PAREN);
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
		enterRule(_localctx, 378, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3924); match(GROUP);
			setState(3925); match(BY);
			setState(3926); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 380, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3928); grouping_element();
			setState(3933);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3929); match(COMMA);
				setState(3930); grouping_element();
				}
				}
				setState(3935);
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
		enterRule(_localctx, 382, RULE_grouping_element);
		try {
			setState(3940);
			switch ( getInterpreter().adaptivePredict(_input,506,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3936); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3937); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3938); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3939); ordinary_grouping_set();
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
		enterRule(_localctx, 384, RULE_ordinary_grouping_set);
		try {
			setState(3947);
			switch ( getInterpreter().adaptivePredict(_input,507,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3942); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3943); match(LEFT_PAREN);
				setState(3944); row_value_predicand_list();
				setState(3945); match(RIGHT_PAREN);
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
		enterRule(_localctx, 386, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3949); ordinary_grouping_set();
			setState(3954);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3950); match(COMMA);
				setState(3951); ordinary_grouping_set();
				}
				}
				setState(3956);
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
		enterRule(_localctx, 388, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3957); match(ROLLUP);
			setState(3958); match(LEFT_PAREN);
			setState(3959); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3960); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 390, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3962); match(CUBE);
			setState(3963); match(LEFT_PAREN);
			setState(3964); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3965); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 392, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3967); match(LEFT_PAREN);
			setState(3968); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 394, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3970); match(HAVING);
			setState(3971); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 396, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3973); row_value_predicand();
			setState(3978);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3974); match(COMMA);
				setState(3975); row_value_predicand();
				}
				}
				setState(3980);
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
		enterRule(_localctx, 398, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3981); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 400, RULE_query_expression_body);
		try {
			setState(3985);
			switch ( getInterpreter().adaptivePredict(_input,510,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3983); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3984); joined_table();
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
		enterRule(_localctx, 402, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3995);
			switch ( getInterpreter().adaptivePredict(_input,512,_ctx) ) {
			case 1:
				{
				setState(3987); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(3988); joined_table();
				setState(3989);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3991);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3990);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3993); query_term();
				}
				break;
			}
			setState(4004);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(3997);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3999);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3998);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(4001); query_term();
				}
				}
				setState(4006);
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
		enterRule(_localctx, 404, RULE_query_term);
		try {
			setState(4009);
			switch ( getInterpreter().adaptivePredict(_input,515,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4007); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4008); joined_table();
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
		enterRule(_localctx, 406, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4019);
			switch ( getInterpreter().adaptivePredict(_input,517,_ctx) ) {
			case 1:
				{
				setState(4011); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(4012); joined_table();
				setState(4013); match(INTERSECT);
				setState(4015);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(4014);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(4017); query_primary();
				}
				break;
			}
			setState(4028);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(4021); match(INTERSECT);
				setState(4023);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(4022);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(4025); query_primary();
				}
				}
				setState(4030);
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
		enterRule(_localctx, 408, RULE_query_primary);
		try {
			setState(4033);
			switch ( getInterpreter().adaptivePredict(_input,520,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4031); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4032); joined_table();
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
		enterRule(_localctx, 410, RULE_non_join_query_primary);
		try {
			setState(4040);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(4035); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(4036); match(LEFT_PAREN);
				setState(4037); non_join_query_expression();
				setState(4038); match(RIGHT_PAREN);
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
		enterRule(_localctx, 412, RULE_simple_table);
		try {
			setState(4044);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(4042); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(4043); explicit_table();
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
		enterRule(_localctx, 414, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4046); match(TABLE);
			setState(4047); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 416, RULE_table_or_query_name);
		try {
			setState(4051);
			switch ( getInterpreter().adaptivePredict(_input,523,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4049); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4050); identifier();
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
		enterRule(_localctx, 418, RULE_schema_qualified_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4053); identifier();
			setState(4060);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(4054); match(DOT);
				setState(4055); identifier();
				setState(4058);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(4056); match(DOT);
					setState(4057); identifier();
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
		enterRule(_localctx, 420, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4062); match(SELECT);
			setState(4064);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(4063); set_qualifier();
				}
			}

			setState(4066); select_list();
			setState(4068);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(4067); table_expression();
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
		enterRule(_localctx, 422, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4070); select_sublist();
			setState(4075);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(4071); match(COMMA);
				setState(4072); select_sublist();
				}
				}
				setState(4077);
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
		enterRule(_localctx, 424, RULE_select_sublist);
		try {
			setState(4080);
			switch ( getInterpreter().adaptivePredict(_input,529,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4078); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4079); qualified_asterisk();
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
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<As_clauseContext> as_clause() {
			return getRuleContexts(As_clauseContext.class);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public List<Over_clauseContext> over_clause() {
			return getRuleContexts(Over_clauseContext.class);
		}
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
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
		enterRule(_localctx, 426, RULE_derived_column);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(4085);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,530,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(4082); match(LEFT_PAREN);
					}
					} 
				}
				setState(4087);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,530,_ctx);
			}
			setState(4088); value_expression();
			setState(4092);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,531,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(4089); match(RIGHT_PAREN);
					}
					} 
				}
				setState(4094);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,531,_ctx);
			}
			setState(4099);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AS || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0)) {
				{
				setState(4097);
				switch ( getInterpreter().adaptivePredict(_input,532,_ctx) ) {
				case 1:
					{
					setState(4095); as_clause();
					}
					break;
				case 2:
					{
					setState(4096); over_clause();
					}
					break;
				}
				}
				setState(4101);
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
		enterRule(_localctx, 428, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4104);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(4102); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(4103); match(DOT);
				}
			}

			setState(4106); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 430, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4108);
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
		enterRule(_localctx, 432, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4113);
			switch ( getInterpreter().adaptivePredict(_input,535,_ctx) ) {
			case 1:
				{
				setState(4110); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(4111); match(DOT);
				}
				break;
			}
			setState(4115); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 434, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4118);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(4117); match(AS);
				}
			}

			setState(4120); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 436, RULE_over_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4122); match(OVER);
			setState(4123); match(LEFT_PAREN);
			setState(4129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ASC || _la==DESC || _la==ORDER || _la==PARTITION) {
				{
				setState(4127);
				switch (_input.LA(1)) {
				case PARTITION:
					{
					setState(4124); partition_by_columns();
					}
					break;
				case ORDER:
					{
					setState(4125); orderby_clause();
					}
					break;
				case ASC:
				case DESC:
					{
					setState(4126); order_specification();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(4131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(4132); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 438, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4134); column_reference();
			setState(4139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(4135); match(COMMA);
				setState(4136); column_reference();
				}
				}
				setState(4141);
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
		enterRule(_localctx, 440, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4142); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 442, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4144); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 444, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4146); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 446, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4148); match(LEFT_PAREN);
			setState(4149); query_expression();
			setState(4150); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 448, RULE_predicate);
		try {
			setState(4158);
			switch ( getInterpreter().adaptivePredict(_input,540,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4152); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4153); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(4154); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(4155); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(4156); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(4157); exists_predicate();
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
		enterRule(_localctx, 450, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4160); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(4161); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(4162); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 452, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4164);
			_la = _input.LA(1);
			if ( !(((((_la - 334)) & ~0x3f) == 0 && ((1L << (_la - 334)) & ((1L << (EQUAL - 334)) | (1L << (NOT_EQUAL - 334)) | (1L << (LTH - 334)) | (1L << (LEQ - 334)) | (1L << (GTH - 334)) | (1L << (GEQ - 334)))) != 0)) ) {
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
		enterRule(_localctx, 454, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4166); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(4167); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 456, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4170);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(4169); match(NOT);
				}
			}

			setState(4172); match(BETWEEN);
			setState(4174);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(4173);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(4176); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(4177); match(AND);
			setState(4178); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 458, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4180); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(4182);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(4181); match(NOT);
				}
			}

			setState(4184); match(IN);
			setState(4185); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 460, RULE_in_predicate_value);
		try {
			setState(4192);
			switch ( getInterpreter().adaptivePredict(_input,544,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4187); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4188); match(LEFT_PAREN);
				setState(4189); in_value_list();
				setState(4190); match(RIGHT_PAREN);
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
		enterRule(_localctx, 462, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4194); row_value_expression();
			setState(4199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(4195); match(COMMA);
				setState(4196); row_value_expression();
				}
				}
				setState(4201);
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
		enterRule(_localctx, 464, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4202); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(4203); pattern_matcher();
			setState(4204); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 466, RULE_pattern_matcher);
		int _la;
		try {
			setState(4211);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(4207);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(4206); match(NOT);
					}
				}

				setState(4209); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(4210); regex_matcher();
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
		enterRule(_localctx, 468, RULE_negativable_matcher);
		try {
			setState(4219);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(4213); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(4214); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(4215); match(SIMILAR);
				setState(4216); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(4217); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(4218); match(RLIKE);
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
		enterRule(_localctx, 470, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4221);
			_la = _input.LA(1);
			if ( !(((((_la - 328)) & ~0x3f) == 0 && ((1L << (_la - 328)) & ((1L << (Similar_To - 328)) | (1L << (Not_Similar_To - 328)) | (1L << (Similar_To_Case_Insensitive - 328)) | (1L << (Not_Similar_To_Case_Insensitive - 328)))) != 0)) ) {
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
		enterRule(_localctx, 472, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4223); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(4224); match(IS);
			setState(4226);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(4225); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(4228); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 474, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4230); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(4231); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(4232); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(4233); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 476, RULE_quantifier);
		try {
			setState(4237);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(4235); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(4236); some();
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
		enterRule(_localctx, 478, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4239); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 480, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4241);
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
		enterRule(_localctx, 482, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4244);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(4243); match(NOT);
				}
			}

			setState(4246); match(EXISTS);
			setState(4247); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 484, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4249); match(UNIQUE);
			setState(4250); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 486, RULE_primary_datetime_field);
		try {
			setState(4254);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(4252); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(4253); match(SECOND);
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
		enterRule(_localctx, 488, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4256);
			_la = _input.LA(1);
			if ( !(((((_la - 162)) & ~0x3f) == 0 && ((1L << (_la - 162)) & ((1L << (DAY - 162)) | (1L << (HOUR - 162)) | (1L << (MINUTE - 162)) | (1L << (MONTH - 162)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 490, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4258);
			_la = _input.LA(1);
			if ( !(((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & ((1L << (CENTURY - 144)) | (1L << (DECADE - 144)) | (1L << (DOW - 144)) | (1L << (DOY - 144)) | (1L << (EPOCH - 144)) | (1L << (ISODOW - 144)) | (1L << (ISOYEAR - 144)))) != 0) || ((((_la - 208)) & ~0x3f) == 0 && ((1L << (_la - 208)) & ((1L << (MICROSECONDS - 208)) | (1L << (MILLENNIUM - 208)) | (1L << (MILLISECONDS - 208)) | (1L << (QUARTER - 208)))) != 0) || _la==WEEK) ) {
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
		enterRule(_localctx, 492, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4260); function_name();
			setState(4261); match(LEFT_PAREN);
			setState(4263);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LEFT - 73)) | (1L << (NOT - 73)) | (1L << (NULL - 73)) | (1L << (RIGHT - 73)) | (1L << (SOME - 73)) | (1L << (TRUE - 73)) | (1L << (ADMIN - 73)) | (1L << (ALWAYS - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (ARRAY - 137)) | (1L << (AVG - 137)) | (1L << (BETWEEN - 137)) | (1L << (BY - 137)) | (1L << (CACHE - 137)) | (1L << (CALLED - 137)) | (1L << (CLASS - 137)) | (1L << (CENTURY - 137)) | (1L << (CHARACTER - 137)) | (1L << (CHECK - 137)) | (1L << (CLUSTER - 137)) | (1L << (COLLECT - 137)) | (1L << (COALESCE - 137)) | (1L << (COLUMN - 137)) | (1L << (COMMENT - 137)) | (1L << (COMMENTS - 137)) | (1L << (COMMIT - 137)) | (1L << (CONCURRENTLY - 137)) | (1L << (CONFIGURATION - 137)) | (1L << (COST - 137)) | (1L << (COUNT - 137)) | (1L << (CUBE - 137)) | (1L << (CURRENT - 137)) | (1L << (CYCLE - 137)) | (1L << (DATA - 137)) | (1L << (DAY - 137)) | (1L << (DEC - 137)) | (1L << (DECADE - 137)) | (1L << (DEFINER - 137)) | (1L << (DICTIONARY - 137)) | (1L << (DISABLE - 137)) | (1L << (DOW - 137)) | (1L << (DOY - 137)) | (1L << (DROP - 137)) | (1L << (ENABLE - 137)) | (1L << (EPOCH - 137)) | (1L << (EVENT - 137)) | (1L << (EVERY - 137)) | (1L << (EXISTS - 137)) | (1L << (EXTENDED - 137)) | (1L << (EXTERNAL - 137)) | (1L << (EXTRACT - 137)) | (1L << (FAMILY - 137)) | (1L << (FILTER - 137)) | (1L << (FIRST - 137)) | (1L << (FORMAT - 137)) | (1L << (FUSION - 137)) | (1L << (GROUPING - 137)) | (1L << (HASH - 137)) | (1L << (INHERIT - 137)) | (1L << (INDEX - 137)) | (1L << (INCREMENT - 137)) | (1L << (INPUT - 137)) | (1L << (INSERT - 137)) | (1L << (INTERSECTION - 137)) | (1L << (ISCACHABLE - 137)) | (1L << (ISODOW - 137)) | (1L << (ISOYEAR - 137)) | (1L << (ISSTRICT - 137)) | (1L << (LANGUAGE - 137)) | (1L << (LARGE - 137)) | (1L << (LAST - 137)))) != 0) || ((((_la - 201)) & ~0x3f) == 0 && ((1L << (_la - 201)) & ((1L << (LESS - 201)) | (1L << (LIST - 201)) | (1L << (LOCATION - 201)) | (1L << (MAIN - 201)) | (1L << (MATCH - 201)) | (1L << (MAX - 201)) | (1L << (MAXVALUE - 201)) | (1L << (MICROSECONDS - 201)) | (1L << (MILLENNIUM - 201)) | (1L << (MILLISECONDS - 201)) | (1L << (MIN - 201)) | (1L << (MINVALUE - 201)) | (1L << (MINUTE - 201)) | (1L << (MONTH - 201)) | (1L << (NATIONAL - 201)) | (1L << (NO - 201)) | (1L << (NONE - 201)) | (1L << (NULLIF - 201)) | (1L << (OBJECT - 201)) | (1L << (ON - 201)) | (1L << (ONLY - 201)) | (1L << (OPTION - 201)) | (1L << (OPTIONS - 201)) | (1L << (OVER - 201)) | (1L << (OVERWRITE - 201)) | (1L << (PARSER - 201)) | (1L << (PARTIAL - 201)) | (1L << (PARTITION - 201)) | (1L << (PARTITIONS - 201)) | (1L << (PLAIN - 201)) | (1L << (PRECISION - 201)) | (1L << (PUBLIC - 201)) | (1L << (PURGE - 201)) | (1L << (QUARTER - 201)) | (1L << (RANGE - 201)) | (1L << (REGCONFIG - 201)) | (1L << (REGEXP - 201)) | (1L << (RENAME - 201)) | (1L << (REPLICA - 201)) | (1L << (RESET - 201)) | (1L << (RESTART - 201)) | (1L << (RLIKE - 201)) | (1L << (ROLLUP - 201)) | (1L << (SEARCH - 201)) | (1L << (SECOND - 201)) | (1L << (SECURITY - 201)) | (1L << (SERVER - 201)) | (1L << (SET - 201)) | (1L << (SIMILAR - 201)) | (1L << (SIMPLE - 201)) | (1L << (STABLE - 201)) | (1L << (START - 201)) | (1L << (STATISTICS - 201)) | (1L << (STORAGE - 201)) | (1L << (STDDEV_POP - 201)) | (1L << (STDDEV_SAMP - 201)) | (1L << (SUBPARTITION - 201)) | (1L << (SUM - 201)) | (1L << (TABLESPACE - 201)) | (1L << (TEMPLATE - 201)) | (1L << (THAN - 201)))) != 0) || ((((_la - 265)) & ~0x3f) == 0 && ((1L << (_la - 265)) & ((1L << (TIMEZONE - 265)) | (1L << (TIMEZONE_HOUR - 265)) | (1L << (TIMEZONE_MINUTE - 265)) | (1L << (TRIM - 265)) | (1L << (TO - 265)) | (1L << (TYPE - 265)) | (1L << (TYPES - 265)) | (1L << (UNKNOWN - 265)) | (1L << (UNLOGGED - 265)) | (1L << (USER - 265)) | (1L << (VALID - 265)) | (1L << (VALIDATE - 265)) | (1L << (VALUES - 265)) | (1L << (VAR_SAMP - 265)) | (1L << (VAR_POP - 265)) | (1L << (VARYING - 265)) | (1L << (VERSION - 265)) | (1L << (VOLATILE - 265)) | (1L << (WEEK - 265)) | (1L << (WINDOW - 265)) | (1L << (WRAPPER - 265)) | (1L << (YEAR - 265)) | (1L << (ZONE - 265)) | (1L << (BOOLEAN - 265)) | (1L << (BOOL - 265)) | (1L << (BIT - 265)) | (1L << (VARBIT - 265)) | (1L << (INT1 - 265)) | (1L << (INT2 - 265)) | (1L << (INT4 - 265)) | (1L << (INT8 - 265)) | (1L << (TINYINT - 265)) | (1L << (SMALLINT - 265)) | (1L << (INT - 265)) | (1L << (INTEGER - 265)) | (1L << (BIGINT - 265)) | (1L << (FLOAT4 - 265)) | (1L << (FLOAT8 - 265)) | (1L << (REAL - 265)) | (1L << (FLOAT - 265)) | (1L << (DOUBLE - 265)) | (1L << (NUMERIC - 265)) | (1L << (DECIMAL - 265)) | (1L << (CHAR - 265)) | (1L << (VARCHAR - 265)) | (1L << (NCHAR - 265)) | (1L << (NVARCHAR - 265)) | (1L << (DATE - 265)) | (1L << (TIME - 265)) | (1L << (TIMETZ - 265)) | (1L << (TIMESTAMP - 265)) | (1L << (TIMESTAMPTZ - 265)) | (1L << (TEXT - 265)) | (1L << (UUID - 265)) | (1L << (VARBINARY - 265)) | (1L << (BLOB - 265)) | (1L << (BYTEA - 265)) | (1L << (INET4 - 265)) | (1L << (INET - 265)) | (1L << (INTERVAL - 265)) | (1L << (VOID - 265)))) != 0) || ((((_la - 344)) & ~0x3f) == 0 && ((1L << (_la - 344)) & ((1L << (LEFT_PAREN - 344)) | (1L << (PLUS - 344)) | (1L << (MINUS - 344)) | (1L << (DOUBLE_QUOTE - 344)) | (1L << (NUMBER - 344)) | (1L << (REAL_NUMBER - 344)) | (1L << (Identifier - 344)) | (1L << (QuotedIdentifier - 344)) | (1L << (Character_String_Literal - 344)))) != 0)) {
				{
				setState(4262); sql_argument_list();
				}
			}

			setState(4265); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 494, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4267);
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
		public Schema_qualified_nameContext schema_qualified_name() {
			return getRuleContext(Schema_qualified_nameContext.class,0);
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
		enterRule(_localctx, 496, RULE_function_name);
		try {
			setState(4271);
			switch (_input.LA(1)) {
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
				enterOuterAlt(_localctx, 1);
				{
				setState(4269); schema_qualified_name();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(4270); function_names_for_reserved_words();
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
		enterRule(_localctx, 498, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4273); value_expression();
			setState(4278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(4274); match(COMMA);
				setState(4275); value_expression();
				}
				}
				setState(4280);
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
		enterRule(_localctx, 500, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4281); match(ORDER);
			setState(4282); match(BY);
			setState(4283); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 502, RULE_sort_specifier_paren);
		int _la;
		try {
			setState(4294);
			switch ( getInterpreter().adaptivePredict(_input,558,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4285); sort_specifier_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4286); match(LEFT_PAREN);
				setState(4289); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(4289);
					switch ( getInterpreter().adaptivePredict(_input,556,_ctx) ) {
					case 1:
						{
						setState(4287);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==LEFT_PAREN || _la==RIGHT_PAREN) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						break;
					case 2:
						{
						setState(4288); sort_specifier_paren();
						}
						break;
					}
					}
					setState(4291); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << ALTER) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << HANDLER) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INLINE) | (1L << INNER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTERSECT - 64)) | (1L << (INTO - 64)) | (1L << (INOUT - 64)) | (1L << (INSTEAD - 64)) | (1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (OWNER - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRUSTED - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (VALIDATOR - 128)) | (1L << (VARIADIC - 128)) | (1L << (VIEW - 128)) | (1L << (WHEN - 128)) | (1L << (WHERE - 128)) | (1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (ALWAYS - 128)) | (1L << (ARRAY - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (CLUSTER - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONCURRENTLY - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DISABLE - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (ENABLE - 128)) | (1L << (EPOCH - 128)) | (1L << (EVENT - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTENDED - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INHERIT - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (INSERT - 192)) | (1L << (INTERSECTION - 192)) | (1L << (ISCACHABLE - 192)) | (1L << (ISODOW - 192)) | (1L << (ISOYEAR - 192)) | (1L << (ISSTRICT - 192)) | (1L << (LANGUAGE - 192)) | (1L << (LARGE - 192)) | (1L << (LAST - 192)) | (1L << (LESS - 192)) | (1L << (LIST - 192)) | (1L << (LOCATION - 192)) | (1L << (MAIN - 192)) | (1L << (MATCH - 192)) | (1L << (MAX - 192)) | (1L << (MAXVALUE - 192)) | (1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (N_DISTINCT - 192)) | (1L << (N_DISTINCT_INHERITED - 192)) | (1L << (OBJECT - 192)) | (1L << (ON - 192)) | (1L << (ONLY - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVER - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PLAIN - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGCONFIG - 192)) | (1L << (REGEXP - 192)) | (1L << (RENAME - 192)) | (1L << (REPLICA - 192)) | (1L << (RESET - 192)) | (1L << (RESTART - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STATISTICS - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (STORAGE - 256)) | (1L << (STDDEV_POP - 256)) | (1L << (STDDEV_SAMP - 256)) | (1L << (SUBPARTITION - 256)) | (1L << (SUM - 256)) | (1L << (TABLESPACE - 256)) | (1L << (TABLES - 256)) | (1L << (TEMPLATE - 256)) | (1L << (THAN - 256)) | (1L << (TIMEZONE - 256)) | (1L << (TIMEZONE_HOUR - 256)) | (1L << (TIMEZONE_MINUTE - 256)) | (1L << (TRIM - 256)) | (1L << (TO - 256)) | (1L << (TYPE - 256)) | (1L << (TYPES - 256)) | (1L << (UNKNOWN - 256)) | (1L << (UNLOGGED - 256)) | (1L << (USER - 256)) | (1L << (VALID - 256)) | (1L << (VALIDATE - 256)) | (1L << (VALUES - 256)) | (1L << (VAR_SAMP - 256)) | (1L << (VAR_POP - 256)) | (1L << (VARYING - 256)) | (1L << (VERSION - 256)) | (1L << (VOLATILE - 256)) | (1L << (WEEK - 256)) | (1L << (WINDOW - 256)) | (1L << (WRAPPER - 256)) | (1L << (YEAR - 256)) | (1L << (ZONE - 256)) | (1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (BINARY - 320)) | (1L << (VARBINARY - 320)) | (1L << (BLOB - 320)) | (1L << (BYTEA - 320)) | (1L << (INET4 - 320)) | (1L << (INET - 320)) | (1L << (INTERVAL - 320)) | (1L << (VOID - 320)) | (1L << (Similar_To - 320)) | (1L << (Not_Similar_To - 320)) | (1L << (Similar_To_Case_Insensitive - 320)) | (1L << (Not_Similar_To_Case_Insensitive - 320)) | (1L << (CAST_EXPRESSION - 320)) | (1L << (ASSIGN - 320)) | (1L << (EQUAL - 320)) | (1L << (COLON - 320)) | (1L << (SEMI_COLON - 320)) | (1L << (COMMA - 320)) | (1L << (CONCATENATION_OPERATOR - 320)) | (1L << (NOT_EQUAL - 320)) | (1L << (LTH - 320)) | (1L << (LEQ - 320)) | (1L << (GTH - 320)) | (1L << (GEQ - 320)) | (1L << (LEFT_PAREN - 320)) | (1L << (PLUS - 320)) | (1L << (MINUS - 320)) | (1L << (MULTIPLY - 320)) | (1L << (DIVIDE - 320)) | (1L << (MODULAR - 320)) | (1L << (DOT - 320)) | (1L << (UNDERLINE - 320)) | (1L << (VERTICAL_BAR - 320)) | (1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (LEFT_BRACKET - 320)) | (1L << (RIGHT_BRACKET - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (QuotedIdentifier - 320)) | (1L << (UnterminatedQuotedIdentifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (DOLLAR_FIELD - 320)) | (1L << (BeginDollarStringConstant - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)) | (1L << (Text_between_Dollar - 320)) | (1L << (EndDollarStringConstant - 320)))) != 0) );
				setState(4293); match(RIGHT_PAREN);
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
		enterRule(_localctx, 504, RULE_sort_specifier_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(4296); sort_specifier();
			setState(4301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,559,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(4297); match(COMMA);
					setState(4298); sort_specifier();
					}
					} 
				}
				setState(4303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,559,_ctx);
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
		enterRule(_localctx, 506, RULE_sort_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4304); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(4306);
			switch ( getInterpreter().adaptivePredict(_input,560,_ctx) ) {
			case 1:
				{
				setState(4305); ((Sort_specifierContext)_localctx).order = order_specification();
				}
				break;
			}
			setState(4309);
			switch ( getInterpreter().adaptivePredict(_input,561,_ctx) ) {
			case 1:
				{
				setState(4308); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 508, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4311);
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
		enterRule(_localctx, 510, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4313); match(LIMIT);
			setState(4314); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 512, RULE_null_ordering);
		try {
			setState(4320);
			switch ( getInterpreter().adaptivePredict(_input,562,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4316); match(NULL);
				setState(4317); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4318); match(NULL);
				setState(4319); match(LAST);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0178\u10e5\4\2\t"+
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
		"\4\u00f6\t\u00f6\4\u00f7\t\u00f7\4\u00f8\t\u00f8\4\u00f9\t\u00f9\4\u00fa"+
		"\t\u00fa\4\u00fb\t\u00fb\4\u00fc\t\u00fc\4\u00fd\t\u00fd\4\u00fe\t\u00fe"+
		"\4\u00ff\t\u00ff\4\u0100\t\u0100\4\u0101\t\u0101\4\u0102\t\u0102\3\2\3"+
		"\2\3\2\7\2\u0208\n\2\f\2\16\2\u020b\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\5"+
		"\4\u0214\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5\u0224\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u022c\n\6\3\7\3\7\3\7\3\7\6\7"+
		"\u0232\n\7\r\7\16\7\u0233\3\7\5\7\u0237\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u024e\n"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u025e\n"+
		"\b\3\t\3\t\5\t\u0262\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u026c\n\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0274\n\t\3\n\3\n\3\n\5\n\u0279\n\n\3\n\6"+
		"\n\u027c\n\n\r\n\16\n\u027d\3\n\3\n\3\n\7\n\u0283\n\n\f\n\16\n\u0286\13"+
		"\n\3\n\3\n\3\n\5\n\u028b\n\n\3\n\6\n\u028e\n\n\r\n\16\n\u028f\3\n\3\n"+
		"\5\n\u0294\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u02a8\n\n\3\13\3\13\5\13\u02ac\n\13\3\13\3\13\3\13"+
		"\5\13\u02b1\n\13\3\13\3\13\5\13\u02b5\n\13\3\13\3\13\5\13\u02b9\n\13\3"+
		"\13\3\13\5\13\u02bd\n\13\3\13\3\13\3\13\5\13\u02c2\n\13\3\13\3\13\3\13"+
		"\3\13\5\13\u02c8\n\13\3\13\3\13\5\13\u02cc\n\13\3\13\3\13\5\13\u02d0\n"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u02d9\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u02e1\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u02eb\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u02f4\n\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\7\13\u02fc\n\13\f\13\16\13\u02ff\13\13\3"+
		"\13\3\13\3\13\3\13\5\13\u0305\n\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u030d\n\13\f\13\16\13\u0310\13\13\3\13\3\13\3\13\3\13\5\13\u0316\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0324"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u032f\n\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0339\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u0340\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u036b\n\13\f\13\16\13\u036e\13\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u0381\n\13\3\f\3\f\3\f\3\f\3\r\3\r\5\r\u0389\n\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u0394\n\r\3\r\3\r\3\r\3\r\5\r\u039a\n\r\5\r\u039c"+
		"\n\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u03ae\n\17\3\17\3\17\3\17\5\17\u03b3\n\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u03c2"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u03cd\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u03d7\n\20\f\20\16\20\u03da\13"+
		"\20\5\20\u03dc\n\20\3\20\3\20\3\20\3\20\3\20\7\20\u03e3\n\20\f\20\16\20"+
		"\u03e6\13\20\5\20\u03e8\n\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u03f0"+
		"\n\21\f\21\16\21\u03f3\13\21\3\21\3\21\5\21\u03f7\n\21\5\21\u03f9\n\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0402\n\21\f\21\16\21\u0405\13"+
		"\21\3\21\3\21\5\21\u0409\n\21\5\21\u040b\n\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u0414\n\21\5\21\u0416\n\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\5\21\u041f\n\21\5\21\u0421\n\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u042a\n\21\3\21\3\21\3\21\7\21\u042f\n\21\f\21\16\21\u0432"+
		"\13\21\3\21\3\21\5\21\u0436\n\21\5\21\u0438\n\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u0441\n\21\3\21\3\21\3\21\7\21\u0446\n\21\f\21\16\21"+
		"\u0449\13\21\3\21\3\21\5\21\u044d\n\21\5\21\u044f\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u0458\n\21\3\21\3\21\3\21\5\21\u045d\n\21\5"+
		"\21\u045f\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0468\n\21\3\21"+
		"\3\21\3\21\5\21\u046d\n\21\5\21\u046f\n\21\3\21\3\21\3\21\5\21\u0474\n"+
		"\21\3\22\3\22\3\22\3\22\5\22\u047a\n\22\3\22\3\22\3\22\3\22\5\22\u0480"+
		"\n\22\3\22\5\22\u0483\n\22\7\22\u0485\n\22\f\22\16\22\u0488\13\22\3\22"+
		"\3\22\3\22\3\22\5\22\u048e\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u0499\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u04a4\n\22\3\22\3\22\3\22\3\22\3\22\5\22\u04ab\n\22\3\23\3\23\5\23\u04af"+
		"\n\23\3\23\3\23\5\23\u04b3\n\23\3\23\5\23\u04b6\n\23\3\23\3\23\3\23\3"+
		"\23\5\23\u04bc\n\23\3\23\3\23\5\23\u04c0\n\23\3\23\3\23\5\23\u04c4\n\23"+
		"\3\23\3\23\5\23\u04c8\n\23\3\24\3\24\3\24\3\24\3\24\5\24\u04cf\n\24\3"+
		"\24\3\24\5\24\u04d3\n\24\3\24\3\24\5\24\u04d7\n\24\3\24\3\24\5\24\u04db"+
		"\n\24\3\24\3\24\5\24\u04df\n\24\3\25\3\25\3\25\5\25\u04e4\n\25\3\25\5"+
		"\25\u04e7\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u04ee\n\25\3\25\5\25\u04f1"+
		"\n\25\3\25\5\25\u04f4\n\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u04fc\n"+
		"\25\3\25\3\25\5\25\u0500\n\25\5\25\u0502\n\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0511\n\26\f\26\16\26\u0514"+
		"\13\26\3\26\3\26\5\26\u0518\n\26\6\26\u051a\n\26\r\26\16\26\u051b\5\26"+
		"\u051e\n\26\3\26\3\26\3\26\3\26\3\27\3\27\5\27\u0526\n\27\3\27\3\27\3"+
		"\27\3\27\3\27\7\27\u052d\n\27\f\27\16\27\u0530\13\27\3\27\3\27\5\27\u0534"+
		"\n\27\3\27\3\27\3\27\3\27\3\27\5\27\u053b\n\27\3\27\3\27\3\27\3\27\5\27"+
		"\u0541\n\27\7\27\u0543\n\27\f\27\16\27\u0546\13\27\5\27\u0548\n\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\5\30\u0550\n\30\3\31\3\31\5\31\u0554\n\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\5\31\u055c\n\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\7\31\u0566\n\31\f\31\16\31\u0569\13\31\5\31\u056b\n\31"+
		"\5\31\u056d\n\31\3\31\5\31\u0570\n\31\6\31\u0572\n\31\r\31\16\31\u0573"+
		"\3\31\3\31\3\31\3\31\5\31\u057a\n\31\3\31\3\31\3\31\5\31\u057f\n\31\3"+
		"\31\3\31\3\31\3\31\5\31\u0585\n\31\3\31\3\31\5\31\u0589\n\31\3\31\3\31"+
		"\5\31\u058d\n\31\3\31\3\31\5\31\u0591\n\31\3\31\3\31\3\31\3\31\3\31\5"+
		"\31\u0598\n\31\3\31\3\31\7\31\u059c\n\31\f\31\16\31\u059f\13\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\5\32\u05a7\n\32\3\32\3\32\3\32\7\32\u05ac\n\32"+
		"\f\32\16\32\u05af\13\32\3\32\3\32\5\32\u05b3\n\32\5\32\u05b5\n\32\3\32"+
		"\3\32\5\32\u05b9\n\32\3\32\6\32\u05bc\n\32\r\32\16\32\u05bd\3\32\3\32"+
		"\3\32\3\32\3\32\6\32\u05c5\n\32\r\32\16\32\u05c6\5\32\u05c9\n\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u05d1\n\32\3\32\3\32\3\32\3\32\3\32\7\32"+
		"\u05d8\n\32\f\32\16\32\u05db\13\32\3\32\3\32\6\32\u05df\n\32\r\32\16\32"+
		"\u05e0\3\32\3\32\5\32\u05e5\n\32\3\32\3\32\3\32\3\32\7\32\u05eb\n\32\f"+
		"\32\16\32\u05ee\13\32\3\32\3\32\5\32\u05f2\n\32\3\32\3\32\5\32\u05f6\n"+
		"\32\3\32\3\32\3\32\7\32\u05fb\n\32\f\32\16\32\u05fe\13\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\5\32\u0606\n\32\3\32\6\32\u0609\n\32\r\32\16\32\u060a"+
		"\3\32\3\32\5\32\u060f\n\32\5\32\u0611\n\32\3\32\3\32\3\32\3\32\3\32\7"+
		"\32\u0618\n\32\f\32\16\32\u061b\13\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\7\32\u0624\n\32\f\32\16\32\u0627\13\32\5\32\u0629\n\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\5\32\u0631\n\32\3\32\6\32\u0634\n\32\r\32\16\32\u0635"+
		"\3\32\3\32\5\32\u063a\n\32\5\32\u063c\n\32\3\32\3\32\3\32\3\32\3\32\7"+
		"\32\u0643\n\32\f\32\16\32\u0646\13\32\3\32\3\32\3\32\3\32\3\32\3\32\5"+
		"\32\u064e\n\32\3\32\3\32\3\32\5\32\u0653\n\32\5\32\u0655\n\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\7\32\u065e\n\32\f\32\16\32\u0661\13\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u0669\n\32\3\32\3\32\3\32\5\32\u066e\n"+
		"\32\5\32\u0670\n\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0678\n\32\f\32"+
		"\16\32\u067b\13\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0683\n\32\3\32"+
		"\3\32\3\32\5\32\u0688\n\32\5\32\u068a\n\32\3\32\3\32\3\32\5\32\u068f\n"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0697\n\32\3\32\3\32\3\32\5\32"+
		"\u069c\n\32\5\32\u069e\n\32\3\32\3\32\3\32\3\32\3\32\7\32\u06a5\n\32\f"+
		"\32\16\32\u06a8\13\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u06b0\n\32\3"+
		"\32\3\32\3\32\5\32\u06b5\n\32\6\32\u06b7\n\32\r\32\16\32\u06b8\3\32\3"+
		"\32\5\32\u06bd\n\32\5\32\u06bf\n\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32"+
		"\u06c7\n\32\f\32\16\32\u06ca\13\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32"+
		"\u06d2\n\32\3\32\3\32\5\32\u06d6\n\32\6\32\u06d8\n\32\r\32\16\32\u06d9"+
		"\3\32\3\32\5\32\u06de\n\32\5\32\u06e0\n\32\3\32\3\32\3\32\3\32\3\32\7"+
		"\32\u06e7\n\32\f\32\16\32\u06ea\13\32\3\32\3\32\3\32\3\32\3\32\3\32\5"+
		"\32\u06f2\n\32\3\32\3\32\3\32\5\32\u06f7\n\32\5\32\u06f9\n\32\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u0700\n\32\f\32\16\32\u0703\13\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\5\32\u070b\n\32\3\32\3\32\3\32\7\32\u0710\n\32\f\32\16"+
		"\32\u0713\13\32\3\32\3\32\3\32\3\32\7\32\u0719\n\32\f\32\16\32\u071c\13"+
		"\32\3\32\5\32\u071f\n\32\5\32\u0721\n\32\3\33\3\33\5\33\u0725\n\33\3\33"+
		"\3\33\5\33\u0729\n\33\3\33\3\33\5\33\u072d\n\33\3\33\3\33\5\33\u0731\n"+
		"\33\7\33\u0733\n\33\f\33\16\33\u0736\13\33\3\33\5\33\u0739\n\33\3\34\3"+
		"\34\3\34\3\34\7\34\u073f\n\34\f\34\16\34\u0742\13\34\3\34\3\34\5\34\u0746"+
		"\n\34\5\34\u0748\n\34\3\34\3\34\5\34\u074c\n\34\3\34\3\34\5\34\u0750\n"+
		"\34\6\34\u0752\n\34\r\34\16\34\u0753\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u075c\n\34\6\34\u075e\n\34\r\34\16\34\u075f\5\34\u0762\n\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\7\34\u076b\n\34\f\34\16\34\u076e\13\34\6\34"+
		"\u0770\n\34\r\34\16\34\u0771\3\34\3\34\5\34\u0776\n\34\3\34\3\34\3\34"+
		"\7\34\u077b\n\34\f\34\16\34\u077e\13\34\5\34\u0780\n\34\3\34\3\34\5\34"+
		"\u0784\n\34\3\34\3\34\5\34\u0788\n\34\6\34\u078a\n\34\r\34\16\34\u078b"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0794\n\34\f\34\16\34\u0797\13\34"+
		"\3\34\3\34\5\34\u079b\n\34\5\34\u079d\n\34\3\34\3\34\3\34\3\34\3\34\7"+
		"\34\u07a4\n\34\f\34\16\34\u07a7\13\34\6\34\u07a9\n\34\r\34\16\34\u07aa"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u07b4\n\34\f\34\16\34\u07b7\13"+
		"\34\5\34\u07b9\n\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u07c1\n\34\f\34"+
		"\16\34\u07c4\13\34\3\34\3\34\5\34\u07c8\n\34\5\34\u07ca\n\34\3\34\3\34"+
		"\3\34\3\34\3\34\7\34\u07d1\n\34\f\34\16\34\u07d4\13\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u07dc\n\34\5\34\u07de\n\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\7\34\u07e7\n\34\f\34\16\34\u07ea\13\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\5\34\u07f2\n\34\5\34\u07f4\n\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\7\34\u07fc\n\34\f\34\16\34\u07ff\13\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\5\34\u0807\n\34\5\34\u0809\n\34\3\34\3\34\3\34\5\34\u080e\n\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\5\34\u0816\n\34\5\34\u0818\n\34\3\34\3\34"+
		"\3\34\3\34\3\34\7\34\u081f\n\34\f\34\16\34\u0822\13\34\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u0829\n\34\6\34\u082b\n\34\r\34\16\34\u082c\3\34\3\34"+
		"\5\34\u0831\n\34\5\34\u0833\n\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u083b"+
		"\n\34\f\34\16\34\u083e\13\34\3\34\3\34\3\34\3\34\3\34\5\34\u0845\n\34"+
		"\6\34\u0847\n\34\r\34\16\34\u0848\3\34\3\34\5\34\u084d\n\34\5\34\u084f"+
		"\n\34\3\34\3\34\3\34\3\34\3\34\7\34\u0856\n\34\f\34\16\34\u0859\13\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0861\n\34\5\34\u0863\n\34\3\34\3"+
		"\34\3\34\3\34\3\34\7\34\u086a\n\34\f\34\16\34\u086d\13\34\3\34\3\34\3"+
		"\34\3\34\3\34\7\34\u0874\n\34\f\34\16\34\u0877\13\34\3\34\3\34\3\34\3"+
		"\34\7\34\u087d\n\34\f\34\16\34\u0880\13\34\3\34\3\34\3\34\5\34\u0885\n"+
		"\34\5\34\u0887\n\34\3\35\3\35\5\35\u088b\n\35\3\35\3\35\5\35\u088f\n\35"+
		"\3\35\3\35\5\35\u0893\n\35\3\35\3\35\5\35\u0897\n\35\7\35\u0899\n\35\f"+
		"\35\16\35\u089c\13\35\3\35\3\35\3\35\5\35\u08a1\n\35\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\7\36\u08ab\n\36\f\36\16\36\u08ae\13\36\5\36\u08b0"+
		"\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\5\36\u08ee\n\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u091c\n\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\5\37\u0924\n\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u092b\n\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0933\n\37\f\37\16\37\u0936"+
		"\13\37\3\37\3\37\5\37\u093a\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u094d\n\37\3\37"+
		"\3\37\3\37\5\37\u0952\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\5\37\u0962\n\37\3\37\3\37\7\37\u0966\n\37\f"+
		"\37\16\37\u0969\13\37\3\37\3\37\3\37\3\37\3\37\3\37\6\37\u0971\n\37\r"+
		"\37\16\37\u0972\3\37\3\37\3\37\3\37\3\37\7\37\u097a\n\37\f\37\16\37\u097d"+
		"\13\37\3\37\3\37\5\37\u0981\n\37\3 \3 \3 \3!\3!\3!\3!\5!\u098a\n!\3!\3"+
		"!\3!\5!\u098f\n!\7!\u0991\n!\f!\16!\u0994\13!\7!\u0996\n!\f!\16!\u0999"+
		"\13!\3!\3!\3\"\3\"\3\"\3#\3#\6#\u09a2\n#\r#\16#\u09a3\3#\3#\3$\5$\u09a9"+
		"\n$\3$\5$\u09ac\n$\3$\3$\3$\5$\u09b1\n$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\7\'\u09bd\n\'\f\'\16\'\u09c0\13\'\7\'\u09c2\n\'\f\'\16\'\u09c5"+
		"\13\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\7(\u09d0\n(\f(\16(\u09d3\13(\3)\3)"+
		"\5)\u09d7\n)\3)\3)\3)\7)\u09dc\n)\f)\16)\u09df\13)\3*\3*\5*\u09e3\n*\3"+
		"*\3*\3*\3*\3*\5*\u09ea\n*\3*\3*\3*\3*\5*\u09f0\n*\3*\3*\5*\u09f4\n*\3"+
		"*\3*\3*\3*\5*\u09fa\n*\3*\3*\3*\3*\3*\5*\u0a01\n*\5*\u0a03\n*\3+\3+\3"+
		"+\3+\3+\5+\u0a0a\n+\3+\7+\u0a0d\n+\f+\16+\u0a10\13+\3+\3+\3+\3+\3+\7+"+
		"\u0a17\n+\f+\16+\u0a1a\13+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u0a24\n+\3+\3+\3"+
		"+\3+\3+\3+\3+\5+\u0a2d\n+\3,\3,\3,\5,\u0a32\n,\3,\5,\u0a35\n,\3,\3,\3"+
		",\3,\5,\u0a3b\n,\7,\u0a3d\n,\f,\16,\u0a40\13,\3,\3,\3,\3,\3,\5,\u0a47"+
		"\n,\6,\u0a49\n,\r,\16,\u0a4a\3,\3,\5,\u0a4f\n,\3,\3,\3,\3-\3-\5-\u0a56"+
		"\n-\3-\3-\5-\u0a5a\n-\3-\3-\3-\3-\5-\u0a60\n-\3-\3-\3-\3-\3-\7-\u0a67"+
		"\n-\f-\16-\u0a6a\13-\5-\u0a6c\n-\3-\3-\3-\3-\3-\5-\u0a73\n-\6-\u0a75\n"+
		"-\r-\16-\u0a76\3-\3-\5-\u0a7b\n-\3-\3-\3-\3-\3-\3-\5-\u0a83\n-\3-\3-\5"+
		"-\u0a87\n-\3-\3-\3-\3-\5-\u0a8d\n-\3-\3-\3-\3-\3-\3-\3-\3-\7-\u0a97\n"+
		"-\f-\16-\u0a9a\13-\3-\5-\u0a9d\n-\3-\3-\3-\3-\3-\7-\u0aa4\n-\f-\16-\u0aa7"+
		"\13-\3-\7-\u0aaa\n-\f-\16-\u0aad\13-\3-\3-\5-\u0ab1\n-\3-\3-\3-\3-\5-"+
		"\u0ab7\n-\3.\3.\3.\3.\3.\7.\u0abe\n.\f.\16.\u0ac1\13.\5.\u0ac3\n.\3/\3"+
		"/\3/\5/\u0ac8\n/\3/\3/\5/\u0acc\n/\3/\7/\u0acf\n/\f/\16/\u0ad2\13/\3\60"+
		"\3\60\3\60\3\61\3\61\5\61\u0ad9\n\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61"+
		"\u0ae1\n\61\f\61\16\61\u0ae4\13\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\7\61\u0aef\n\61\f\61\16\61\u0af2\13\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\5\61\u0afa\n\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u0b02\n"+
		"\61\f\61\16\61\u0b05\13\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u0b0e"+
		"\n\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u0b16\n\61\f\61\16\61\u0b19\13"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u0b22\n\61\f\61\16\61\u0b25"+
		"\13\61\3\61\3\61\5\61\u0b29\n\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u0b31"+
		"\n\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u0b39\n\61\f\61\16\61\u0b3c\13"+
		"\61\5\61\u0b3e\n\61\3\61\3\61\3\61\5\61\u0b43\n\61\3\61\3\61\3\61\3\61"+
		"\5\61\u0b49\n\61\3\62\3\62\5\62\u0b4d\n\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\5\62\u0b56\n\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\5\62\u0b66\n\62\3\62\3\62\3\62\5\62\u0b6b\n"+
		"\62\3\62\3\62\3\62\5\62\u0b70\n\62\5\62\u0b72\n\62\3\62\3\62\3\62\5\62"+
		"\u0b77\n\62\3\62\3\62\3\62\3\62\5\62\u0b7d\n\62\3\63\3\63\6\63\u0b81\n"+
		"\63\r\63\16\63\u0b82\3\63\3\63\6\63\u0b87\n\63\r\63\16\63\u0b88\3\64\3"+
		"\64\3\64\3\64\5\64\u0b8f\n\64\3\64\5\64\u0b92\n\64\6\64\u0b94\n\64\r\64"+
		"\16\64\u0b95\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\5\66\u0ba2"+
		"\n\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u0bab\n\67\5\67\u0bad\n"+
		"\67\38\38\58\u0bb1\n8\39\39\39\39\39\39\59\u0bb9\n9\3:\5:\u0bbc\n:\3:"+
		"\3:\3:\3:\5:\u0bc2\n:\3;\3;\3;\3;\7;\u0bc8\n;\f;\16;\u0bcb\13;\3;\3;\3"+
		"<\3<\3<\3=\3=\3>\3>\3>\3>\3>\7>\u0bd9\n>\f>\16>\u0bdc\13>\3>\3>\3?\3?"+
		"\3?\3?\3@\3@\3@\3A\3A\3A\3B\3B\3C\3C\3C\3C\5C\u0bf0\nC\3D\3D\3D\3D\3D"+
		"\3D\3D\3D\3D\3D\3E\3E\3E\7E\u0bff\nE\fE\16E\u0c02\13E\3F\3F\3F\3F\3F\3"+
		"F\3F\3F\3F\3F\5F\u0c0e\nF\3F\3F\5F\u0c12\nF\5F\u0c14\nF\3G\3G\3G\3G\3"+
		"G\3G\3G\3G\3G\3G\3G\5G\u0c21\nG\3H\3H\3H\7H\u0c26\nH\fH\16H\u0c29\13H"+
		"\3I\3I\3I\3J\3J\3J\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3L\3L\3L\7L\u0c3e\nL"+
		"\fL\16L\u0c41\13L\3M\3M\3M\3M\5M\u0c47\nM\3M\3M\3M\3M\3N\3N\3N\3N\3N\3"+
		"O\3O\3O\3O\3O\7O\u0c57\nO\fO\16O\u0c5a\13O\3P\3P\3Q\3Q\3Q\3Q\5Q\u0c62"+
		"\nQ\3R\3R\3R\5R\u0c67\nR\3R\3R\5R\u0c6b\nR\5R\u0c6d\nR\3S\3S\3T\3T\5T"+
		"\u0c73\nT\3U\3U\3U\5U\u0c78\nU\3V\3V\3V\5V\u0c7d\nV\3W\3W\3W\3X\3X\3X"+
		"\3Y\3Y\3Y\3Z\3Z\3[\3[\3[\5[\u0c8d\n[\3[\3[\5[\u0c91\n[\3\\\3\\\3\\\3\\"+
		"\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\5\\\u0ca2\n\\\3]\3]\3^\3"+
		"^\3_\3_\5_\u0caa\n_\3_\3_\5_\u0cae\n_\3_\3_\3_\5_\u0cb3\n_\3_\3_\3_\5"+
		"_\u0cb8\n_\3_\3_\5_\u0cbc\n_\3_\3_\5_\u0cc0\n_\3`\3`\3`\3`\3a\3a\3a\5"+
		"a\u0cc9\na\3a\3a\3a\5a\u0cce\na\3a\3a\5a\u0cd2\na\3a\3a\3a\3a\5a\u0cd8"+
		"\na\3a\3a\3a\3a\5a\u0cde\na\3a\3a\3a\5a\u0ce3\na\3a\3a\5a\u0ce7\na\5a"+
		"\u0ce9\na\3b\3b\5b\u0ced\nb\3b\3b\5b\u0cf1\nb\5b\u0cf3\nb\3c\3c\5c\u0cf7"+
		"\nc\3d\3d\5d\u0cfb\nd\3d\3d\5d\u0cff\nd\3d\3d\5d\u0d03\nd\3d\3d\3d\3d"+
		"\3d\3d\3d\3d\3d\5d\u0d0e\nd\3e\3e\5e\u0d12\ne\3e\3e\3e\3e\3e\3e\5e\u0d1a"+
		"\ne\3f\3f\3f\3f\3f\3f\3f\3f\5f\u0d24\nf\3g\3g\3h\3h\3h\3h\3h\3h\3h\3h"+
		"\3h\3h\3h\3h\3h\3h\3h\3h\3h\5h\u0d39\nh\3i\3i\5i\u0d3d\ni\3i\3i\5i\u0d41"+
		"\ni\3i\3i\3i\5i\u0d46\ni\5i\u0d48\ni\3j\3j\5j\u0d4c\nj\3j\3j\3j\5j\u0d51"+
		"\nj\3j\3j\5j\u0d55\nj\5j\u0d57\nj\3k\3k\5k\u0d5b\nk\3l\3l\3l\6l\u0d60"+
		"\nl\rl\16l\u0d61\3l\3l\3m\3m\3m\3m\3m\3m\3m\3m\5m\u0d6e\nm\3n\3n\3o\3"+
		"o\3p\5p\u0d75\np\3p\3p\3q\3q\3r\3r\3r\3r\3r\3r\5r\u0d81\nr\5r\u0d83\n"+
		"r\3s\3s\3s\5s\u0d88\ns\3s\3s\3s\3t\3t\3u\3u\3u\3u\3u\3u\3v\3v\3v\3v\3"+
		"v\3w\3w\3x\3x\3x\3x\3x\3x\3x\3x\3x\3x\3x\3x\6x\u0da8\nx\rx\16x\u0da9\3"+
		"x\3x\5x\u0dae\nx\3y\3y\5y\u0db2\ny\3z\3z\3z\6z\u0db7\nz\rz\16z\u0db8\3"+
		"z\5z\u0dbc\nz\3z\3z\3{\3{\6{\u0dc2\n{\r{\16{\u0dc3\3{\5{\u0dc7\n{\3{\3"+
		"{\3|\3|\3|\3|\3|\3}\3}\3}\3}\3}\3~\3~\3~\3\177\3\177\5\177\u0dda\n\177"+
		"\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0081\3\u0081"+
		"\3\u0082\3\u0082\3\u0083\3\u0083\3\u0083\3\u0083\5\u0083\u0deb\n\u0083"+
		"\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\7\u0084\u0df2\n\u0084\f\u0084"+
		"\16\u0084\u0df5\13\u0084\3\u0084\3\u0084\3\u0085\3\u0085\3\u0085\5\u0085"+
		"\u0dfc\n\u0085\3\u0086\3\u0086\3\u0086\7\u0086\u0e01\n\u0086\f\u0086\16"+
		"\u0086\u0e04\13\u0086\3\u0087\3\u0087\3\u0087\7\u0087\u0e09\n\u0087\f"+
		"\u0087\16\u0087\u0e0c\13\u0087\3\u0088\5\u0088\u0e0f\n\u0088\3\u0088\3"+
		"\u0088\3\u0089\3\u0089\3\u0089\3\u0089\7\u0089\u0e17\n\u0089\f\u0089\16"+
		"\u0089\u0e1a\13\u0089\3\u0089\3\u0089\3\u008a\3\u008a\3\u008a\7\u008a"+
		"\u0e21\n\u008a\f\u008a\16\u008a\u0e24\13\u008a\3\u008a\5\u008a\u0e27\n"+
		"\u008a\3\u008b\3\u008b\3\u008c\3\u008c\3\u008d\3\u008d\3\u008d\3\u008d"+
		"\3\u008d\3\u008d\3\u008d\3\u008e\3\u008e\3\u008e\5\u008e\u0e37\n\u008e"+
		"\3\u008f\3\u008f\3\u0090\3\u0090\5\u0090\u0e3d\n\u0090\3\u0091\3\u0091"+
		"\3\u0092\3\u0092\3\u0092\7\u0092\u0e44\n\u0092\f\u0092\16\u0092\u0e47"+
		"\13\u0092\3\u0093\3\u0093\3\u0094\3\u0094\5\u0094\u0e4d\n\u0094\3\u0095"+
		"\3\u0095\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096\3\u0097\5\u0097\u0e57"+
		"\n\u0097\3\u0097\5\u0097\u0e5a\n\u0097\3\u0097\5\u0097\u0e5d\n\u0097\3"+
		"\u0097\3\u0097\3\u0097\3\u0097\3\u0097\5\u0097\u0e64\n\u0097\3\u0098\3"+
		"\u0098\3\u0099\3\u0099\3\u009a\3\u009a\3\u009a\7\u009a\u0e6d\n\u009a\f"+
		"\u009a\16\u009a\u0e70\13\u009a\3\u009b\3\u009b\3\u009b\7\u009b\u0e75\n"+
		"\u009b\f\u009b\16\u009b\u0e78\13\u009b\3\u009c\3\u009c\3\u009c\5\u009c"+
		"\u0e7d\n\u009c\3\u009d\3\u009d\5\u009d\u0e81\n\u009d\3\u009e\3\u009e\5"+
		"\u009e\u0e85\n\u009e\3\u009e\3\u009e\3\u009f\3\u009f\3\u00a0\3\u00a0\5"+
		"\u00a0\u0e8d\n\u00a0\3\u00a1\3\u00a1\5\u00a1\u0e91\n\u00a1\3\u00a2\3\u00a2"+
		"\3\u00a2\3\u00a2\3\u00a3\3\u00a3\5\u00a3\u0e99\n\u00a3\3\u00a4\3\u00a4"+
		"\3\u00a5\3\u00a5\3\u00a6\3\u00a6\5\u00a6\u0ea1\n\u00a6\3\u00a7\3\u00a7"+
		"\5\u00a7\u0ea5\n\u00a7\3\u00a8\3\u00a8\5\u00a8\u0ea9\n\u00a8\3\u00a8\5"+
		"\u00a8\u0eac\n\u00a8\3\u00a8\5\u00a8\u0eaf\n\u00a8\3\u00a8\5\u00a8\u0eb2"+
		"\n\u00a8\3\u00a8\5\u00a8\u0eb5\n\u00a8\3\u00a9\3\u00a9\3\u00a9\3\u00a9"+
		"\5\u00a9\u0ebb\n\u00a9\3\u00a9\3\u00a9\5\u00a9\u0ebf\n\u00a9\3\u00aa\3"+
		"\u00aa\3\u00aa\7\u00aa\u0ec4\n\u00aa\f\u00aa\16\u00aa\u0ec7\13\u00aa\3"+
		"\u00ab\3\u00ab\5\u00ab\u0ecb\n\u00ab\3\u00ac\3\u00ac\6\u00ac\u0ecf\n\u00ac"+
		"\r\u00ac\16\u00ac\u0ed0\3\u00ad\3\u00ad\3\u00ad\3\u00ad\5\u00ad\u0ed7"+
		"\n\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\5\u00ad\u0edf"+
		"\n\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\5\u00ad\u0ee6\n\u00ad"+
		"\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00af\5\u00af\u0eed\n\u00af\3\u00af"+
		"\3\u00af\3\u00af\3\u00af\3\u00b0\3\u00b0\5\u00b0\u0ef5\n\u00b0\3\u00b0"+
		"\3\u00b0\3\u00b0\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b2\3\u00b2\5\u00b2"+
		"\u0f00\n\u00b2\3\u00b3\3\u00b3\5\u00b3\u0f04\n\u00b3\3\u00b4\3\u00b4\3"+
		"\u00b5\3\u00b5\5\u00b5\u0f0a\n\u00b5\3\u00b6\3\u00b6\3\u00b6\3\u00b7\3"+
		"\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b8\3\u00b8\5\u00b8\u0f16\n\u00b8\3"+
		"\u00b8\5\u00b8\u0f19\n\u00b8\3\u00b8\5\u00b8\u0f1c\n\u00b8\3\u00b8\3\u00b8"+
		"\3\u00b8\3\u00b8\5\u00b8\u0f22\n\u00b8\3\u00b8\3\u00b8\5\u00b8\u0f26\n"+
		"\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\5\u00b8\u0f2d\n\u00b8\5"+
		"\u00b8\u0f2f\n\u00b8\3\u00b9\3\u00b9\3\u00b9\7\u00b9\u0f34\n\u00b9\f\u00b9"+
		"\16\u00b9\u0f37\13\u00b9\3\u00ba\3\u00ba\5\u00ba\u0f3b\n\u00ba\3\u00bb"+
		"\3\u00bb\3\u00bb\3\u00bb\3\u00bb\7\u00bb\u0f42\n\u00bb\f\u00bb\16\u00bb"+
		"\u0f45\13\u00bb\5\u00bb\u0f47\n\u00bb\3\u00bb\3\u00bb\3\u00bc\3\u00bc"+
		"\3\u00bd\3\u00bd\3\u00bd\3\u00be\5\u00be\u0f51\n\u00be\3\u00be\3\u00be"+
		"\5\u00be\u0f55\n\u00be\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00c0\3\u00c0"+
		"\3\u00c0\7\u00c0\u0f5e\n\u00c0\f\u00c0\16\u00c0\u0f61\13\u00c0\3\u00c1"+
		"\3\u00c1\3\u00c1\3\u00c1\5\u00c1\u0f67\n\u00c1\3\u00c2\3\u00c2\3\u00c2"+
		"\3\u00c2\3\u00c2\5\u00c2\u0f6e\n\u00c2\3\u00c3\3\u00c3\3\u00c3\7\u00c3"+
		"\u0f73\n\u00c3\f\u00c3\16\u00c3\u0f76\13\u00c3\3\u00c4\3\u00c4\3\u00c4"+
		"\3\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c6\3\u00c6"+
		"\3\u00c6\3\u00c7\3\u00c7\3\u00c7\3\u00c8\3\u00c8\3\u00c8\7\u00c8\u0f8b"+
		"\n\u00c8\f\u00c8\16\u00c8\u0f8e\13\u00c8\3\u00c9\3\u00c9\3\u00ca\3\u00ca"+
		"\5\u00ca\u0f94\n\u00ca\3\u00cb\3\u00cb\3\u00cb\3\u00cb\5\u00cb\u0f9a\n"+
		"\u00cb\3\u00cb\3\u00cb\5\u00cb\u0f9e\n\u00cb\3\u00cb\3\u00cb\5\u00cb\u0fa2"+
		"\n\u00cb\3\u00cb\7\u00cb\u0fa5\n\u00cb\f\u00cb\16\u00cb\u0fa8\13\u00cb"+
		"\3\u00cc\3\u00cc\5\u00cc\u0fac\n\u00cc\3\u00cd\3\u00cd\3\u00cd\3\u00cd"+
		"\5\u00cd\u0fb2\n\u00cd\3\u00cd\3\u00cd\5\u00cd\u0fb6\n\u00cd\3\u00cd\3"+
		"\u00cd\5\u00cd\u0fba\n\u00cd\3\u00cd\7\u00cd\u0fbd\n\u00cd\f\u00cd\16"+
		"\u00cd\u0fc0\13\u00cd\3\u00ce\3\u00ce\5\u00ce\u0fc4\n\u00ce\3\u00cf\3"+
		"\u00cf\3\u00cf\3\u00cf\3\u00cf\5\u00cf\u0fcb\n\u00cf\3\u00d0\3\u00d0\5"+
		"\u00d0\u0fcf\n\u00d0\3\u00d1\3\u00d1\3\u00d1\3\u00d2\3\u00d2\5\u00d2\u0fd6"+
		"\n\u00d2\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\5\u00d3\u0fdd\n\u00d3"+
		"\5\u00d3\u0fdf\n\u00d3\3\u00d4\3\u00d4\5\u00d4\u0fe3\n\u00d4\3\u00d4\3"+
		"\u00d4\5\u00d4\u0fe7\n\u00d4\3\u00d5\3\u00d5\3\u00d5\7\u00d5\u0fec\n\u00d5"+
		"\f\u00d5\16\u00d5\u0fef\13\u00d5\3\u00d6\3\u00d6\5\u00d6\u0ff3\n\u00d6"+
		"\3\u00d7\7\u00d7\u0ff6\n\u00d7\f\u00d7\16\u00d7\u0ff9\13\u00d7\3\u00d7"+
		"\3\u00d7\7\u00d7\u0ffd\n\u00d7\f\u00d7\16\u00d7\u1000\13\u00d7\3\u00d7"+
		"\3\u00d7\7\u00d7\u1004\n\u00d7\f\u00d7\16\u00d7\u1007\13\u00d7\3\u00d8"+
		"\3\u00d8\5\u00d8\u100b\n\u00d8\3\u00d8\3\u00d8\3\u00d9\3\u00d9\3\u00da"+
		"\3\u00da\3\u00da\5\u00da\u1014\n\u00da\3\u00da\3\u00da\3\u00db\5\u00db"+
		"\u1019\n\u00db\3\u00db\3\u00db\3\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dc"+
		"\7\u00dc\u1022\n\u00dc\f\u00dc\16\u00dc\u1025\13\u00dc\3\u00dc\3\u00dc"+
		"\3\u00dd\3\u00dd\3\u00dd\7\u00dd\u102c\n\u00dd\f\u00dd\16\u00dd\u102f"+
		"\13\u00dd\3\u00de\3\u00de\3\u00df\3\u00df\3\u00e0\3\u00e0\3\u00e1\3\u00e1"+
		"\3\u00e1\3\u00e1\3\u00e2\3\u00e2\3\u00e2\3\u00e2\3\u00e2\3\u00e2\5\u00e2"+
		"\u1041\n\u00e2\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e4\3\u00e4\3\u00e5"+
		"\3\u00e5\3\u00e5\3\u00e6\5\u00e6\u104d\n\u00e6\3\u00e6\3\u00e6\5\u00e6"+
		"\u1051\n\u00e6\3\u00e6\3\u00e6\3\u00e6\3\u00e6\3\u00e7\3\u00e7\5\u00e7"+
		"\u1059\n\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e8\3\u00e8\3\u00e8\3\u00e8"+
		"\3\u00e8\5\u00e8\u1063\n\u00e8\3\u00e9\3\u00e9\3\u00e9\7\u00e9\u1068\n"+
		"\u00e9\f\u00e9\16\u00e9\u106b\13\u00e9\3\u00ea\3\u00ea\3\u00ea\3\u00ea"+
		"\3\u00eb\5\u00eb\u1072\n\u00eb\3\u00eb\3\u00eb\5\u00eb\u1076\n\u00eb\3"+
		"\u00ec\3\u00ec\3\u00ec\3\u00ec\3\u00ec\3\u00ec\5\u00ec\u107e\n\u00ec\3"+
		"\u00ed\3\u00ed\3\u00ee\3\u00ee\3\u00ee\5\u00ee\u1085\n\u00ee\3\u00ee\3"+
		"\u00ee\3\u00ef\3\u00ef\3\u00ef\3\u00ef\3\u00ef\3\u00f0\3\u00f0\5\u00f0"+
		"\u1090\n\u00f0\3\u00f1\3\u00f1\3\u00f2\3\u00f2\3\u00f3\5\u00f3\u1097\n"+
		"\u00f3\3\u00f3\3\u00f3\3\u00f3\3\u00f4\3\u00f4\3\u00f4\3\u00f5\3\u00f5"+
		"\5\u00f5\u10a1\n\u00f5\3\u00f6\3\u00f6\3\u00f7\3\u00f7\3\u00f8\3\u00f8"+
		"\3\u00f8\5\u00f8\u10aa\n\u00f8\3\u00f8\3\u00f8\3\u00f9\3\u00f9\3\u00fa"+
		"\3\u00fa\5\u00fa\u10b2\n\u00fa\3\u00fb\3\u00fb\3\u00fb\7\u00fb\u10b7\n"+
		"\u00fb\f\u00fb\16\u00fb\u10ba\13\u00fb\3\u00fc\3\u00fc\3\u00fc\3\u00fc"+
		"\3\u00fd\3\u00fd\3\u00fd\3\u00fd\6\u00fd\u10c4\n\u00fd\r\u00fd\16\u00fd"+
		"\u10c5\3\u00fd\5\u00fd\u10c9\n\u00fd\3\u00fe\3\u00fe\3\u00fe\7\u00fe\u10ce"+
		"\n\u00fe\f\u00fe\16\u00fe\u10d1\13\u00fe\3\u00ff\3\u00ff\5\u00ff\u10d5"+
		"\n\u00ff\3\u00ff\5\u00ff\u10d8\n\u00ff\3\u0100\3\u0100\3\u0101\3\u0101"+
		"\3\u0101\3\u0102\3\u0102\3\u0102\3\u0102\5\u0102\u10e3\n\u0102\3\u0102"+
		"\2\2\u0103\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
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
		"\u01dc\u01de\u01e0\u01e2\u01e4\u01e6\u01e8\u01ea\u01ec\u01ee\u01f0\u01f2"+
		"\u01f4\u01f6\u01f8\u01fa\u01fc\u01fe\u0200\u0202\2)\4\2\21\21ee\3\2\u00dd"+
		"\u00de\4\2``\u0114\u0114\t\2  ccmmzz||\177\177\u00c2\u00c2\4\2mm\177\u0080"+
		"\4\2NNnn\4\2\u010f\u010f\u0150\u0150\6\2ccmm\177\177\u00c2\u00c2\5\2\25"+
		"\25\31\31uv\4\2\31\31\u0080\u0080\4\2mm\177\177\4\2\34\34\u0150\u0150"+
		"\4\2\u00c4\u00c4\u00c7\u00c7\6\2<<DDUU\u0083\u0083\3\2uv\4\2\63\63NN\4"+
		"\2))==\b\2\7\7\27\27\35\35\u009a\u009a\u00bf\u00bf\u0102\u0102\t\2\u0089"+
		"\u00bb\u00bd\u00be\u00c0\u00dc\u00df\u0107\u0109\u0131\u0133\u0141\u0143"+
		"\u0149\5\2,,{{\u0112\u0112\3\2\u0122\u0123\3\2\u015a\u015b\3\2\u0169\u016a"+
		"\17\2\n\npp\u008c\u008c\u0096\u0096\u009f\u009f\u00b0\u00b0\u00b9\u00b9"+
		"\u00c3\u00c3\u00d0\u00d0\u00d5\u00d5\u0103\u0104\u0106\u0106\u0118\u0119"+
		"\3\2\u015c\u015d\3\2\u015e\u0160\3\2\u010b\u010d\5\2\17\17JJxx\5\2//K"+
		"Khh\4\2\'\'}}\4\2\7\7\"\"\4\2\u0150\u0150\u0155\u0159\4\2\13\13ss\3\2"+
		"\u014a\u014d\4\2\n\npp\6\2\u00a4\u00a4\u00bc\u00bc\u00d7\u00d8\u0120\u0120"+
		"\n\2\u0092\u0092\u00a6\u00a6\u00aa\u00ab\u00ae\u00ae\u00c5\u00c6\u00d2"+
		"\u00d4\u00ee\u00ee\u011d\u011d\4\2KKhh\4\2\f\f!!\u1319\2\u0209\3\2\2\2"+
		"\4\u020e\3\2\2\2\6\u0213\3\2\2\2\b\u0223\3\2\2\2\n\u022b\3\2\2\2\f\u024d"+
		"\3\2\2\2\16\u025d\3\2\2\2\20\u0273\3\2\2\2\22\u02a7\3\2\2\2\24\u0380\3"+
		"\2\2\2\26\u0382\3\2\2\2\30\u039b\3\2\2\2\32\u039d\3\2\2\2\34\u03cc\3\2"+
		"\2\2\36\u03ce\3\2\2\2 \u0473\3\2\2\2\"\u04aa\3\2\2\2$\u04ac\3\2\2\2&\u04c9"+
		"\3\2\2\2(\u0501\3\2\2\2*\u0503\3\2\2\2,\u0547\3\2\2\2.\u054f\3\2\2\2\60"+
		"\u0551\3\2\2\2\62\u0720\3\2\2\2\64\u0722\3\2\2\2\66\u0886\3\2\2\28\u0888"+
		"\3\2\2\2:\u08a2\3\2\2\2<\u0920\3\2\2\2>\u0982\3\2\2\2@\u0985\3\2\2\2B"+
		"\u099c\3\2\2\2D\u099f\3\2\2\2F\u09a8\3\2\2\2H\u09b2\3\2\2\2J\u09b4\3\2"+
		"\2\2L\u09b6\3\2\2\2N\u09c8\3\2\2\2P\u09d4\3\2\2\2R\u0a02\3\2\2\2T\u0a2c"+
		"\3\2\2\2V\u0a2e\3\2\2\2X\u0ab6\3\2\2\2Z\u0ac2\3\2\2\2\\\u0ac4\3\2\2\2"+
		"^\u0ad3\3\2\2\2`\u0ad8\3\2\2\2b\u0b4c\3\2\2\2d\u0b7e\3\2\2\2f\u0b8a\3"+
		"\2\2\2h\u0b99\3\2\2\2j\u0ba1\3\2\2\2l\u0bac\3\2\2\2n\u0bb0\3\2\2\2p\u0bb8"+
		"\3\2\2\2r\u0bbb\3\2\2\2t\u0bc3\3\2\2\2v\u0bce\3\2\2\2x\u0bd1\3\2\2\2z"+
		"\u0bd3\3\2\2\2|\u0bdf\3\2\2\2~\u0be3\3\2\2\2\u0080\u0be6\3\2\2\2\u0082"+
		"\u0be9\3\2\2\2\u0084\u0bef\3\2\2\2\u0086\u0bf1\3\2\2\2\u0088\u0bfb\3\2"+
		"\2\2\u008a\u0c03\3\2\2\2\u008c\u0c15\3\2\2\2\u008e\u0c22\3\2\2\2\u0090"+
		"\u0c2a\3\2\2\2\u0092\u0c2d\3\2\2\2\u0094\u0c30\3\2\2\2\u0096\u0c3a\3\2"+
		"\2\2\u0098\u0c42\3\2\2\2\u009a\u0c4c\3\2\2\2\u009c\u0c51\3\2\2\2\u009e"+
		"\u0c5b\3\2\2\2\u00a0\u0c5d\3\2\2\2\u00a2\u0c6c\3\2\2\2\u00a4\u0c6e\3\2"+
		"\2\2\u00a6\u0c72\3\2\2\2\u00a8\u0c77\3\2\2\2\u00aa\u0c7c\3\2\2\2\u00ac"+
		"\u0c7e\3\2\2\2\u00ae\u0c81\3\2\2\2\u00b0\u0c84\3\2\2\2\u00b2\u0c87\3\2"+
		"\2\2\u00b4\u0c90\3\2\2\2\u00b6\u0ca1\3\2\2\2\u00b8\u0ca3\3\2\2\2\u00ba"+
		"\u0ca5\3\2\2\2\u00bc\u0cbf\3\2\2\2\u00be\u0cc1\3\2\2\2\u00c0\u0ce8\3\2"+
		"\2\2\u00c2\u0cf2\3\2\2\2\u00c4\u0cf6\3\2\2\2\u00c6\u0d0d\3\2\2\2\u00c8"+
		"\u0d19\3\2\2\2\u00ca\u0d23\3\2\2\2\u00cc\u0d25\3\2\2\2\u00ce\u0d38\3\2"+
		"\2\2\u00d0\u0d47\3\2\2\2\u00d2\u0d56\3\2\2\2\u00d4\u0d5a\3\2\2\2\u00d6"+
		"\u0d5c\3\2\2\2\u00d8\u0d6d\3\2\2\2\u00da\u0d6f\3\2\2\2\u00dc\u0d71\3\2"+
		"\2\2\u00de\u0d74\3\2\2\2\u00e0\u0d78\3\2\2\2\u00e2\u0d82\3\2\2\2\u00e4"+
		"\u0d84\3\2\2\2\u00e6\u0d8c\3\2\2\2\u00e8\u0d8e\3\2\2\2\u00ea\u0d94\3\2"+
		"\2\2\u00ec\u0d99\3\2\2\2\u00ee\u0dad\3\2\2\2\u00f0\u0db1\3\2\2\2\u00f2"+
		"\u0db3\3\2\2\2\u00f4\u0dbf\3\2\2\2\u00f6\u0dca\3\2\2\2\u00f8\u0dcf\3\2"+
		"\2\2\u00fa\u0dd4\3\2\2\2\u00fc\u0dd9\3\2\2\2\u00fe\u0ddb\3\2\2\2\u0100"+
		"\u0de2\3\2\2\2\u0102\u0de4\3\2\2\2\u0104\u0dea\3\2\2\2\u0106\u0dec\3\2"+
		"\2\2\u0108\u0dfb\3\2\2\2\u010a\u0dfd\3\2\2\2\u010c\u0e05\3\2\2\2\u010e"+
		"\u0e0e\3\2\2\2\u0110\u0e12\3\2\2\2\u0112\u0e26\3\2\2\2\u0114\u0e28\3\2"+
		"\2\2\u0116\u0e2a\3\2\2\2\u0118\u0e2c\3\2\2\2\u011a\u0e36\3\2\2\2\u011c"+
		"\u0e38\3\2\2\2\u011e\u0e3c\3\2\2\2\u0120\u0e3e\3\2\2\2\u0122\u0e40\3\2"+
		"\2\2\u0124\u0e48\3\2\2\2\u0126\u0e4c\3\2\2\2\u0128\u0e4e\3\2\2\2\u012a"+
		"\u0e50\3\2\2\2\u012c\u0e63\3\2\2\2\u012e\u0e65\3\2\2\2\u0130\u0e67\3\2"+
		"\2\2\u0132\u0e69\3\2\2\2\u0134\u0e71\3\2\2\2\u0136\u0e7c\3\2\2\2\u0138"+
		"\u0e7e\3\2\2\2\u013a\u0e82\3\2\2\2\u013c\u0e88\3\2\2\2\u013e\u0e8c\3\2"+
		"\2\2\u0140\u0e90\3\2\2\2\u0142\u0e92\3\2\2\2\u0144\u0e98\3\2\2\2\u0146"+
		"\u0e9a\3\2\2\2\u0148\u0e9c\3\2\2\2\u014a\u0ea0\3\2\2\2\u014c\u0ea4\3\2"+
		"\2\2\u014e\u0ea6\3\2\2\2\u0150\u0eb6\3\2\2\2\u0152\u0ec0\3\2\2\2\u0154"+
		"\u0eca\3\2\2\2\u0156\u0ecc\3\2\2\2\u0158\u0ee5\3\2\2\2\u015a\u0ee7\3\2"+
		"\2\2\u015c\u0eec\3\2\2\2\u015e\u0ef2\3\2\2\2\u0160\u0ef9\3\2\2\2\u0162"+
		"\u0eff\3\2\2\2\u0164\u0f01\3\2\2\2\u0166\u0f05\3\2\2\2\u0168\u0f09\3\2"+
		"\2\2\u016a\u0f0b\3\2\2\2\u016c\u0f0e\3\2\2\2\u016e\u0f2e\3\2\2\2\u0170"+
		"\u0f30\3\2\2\2\u0172\u0f3a\3\2\2\2\u0174\u0f3c\3\2\2\2\u0176\u0f4a\3\2"+
		"\2\2\u0178\u0f4c\3\2\2\2\u017a\u0f50\3\2\2\2\u017c\u0f56\3\2\2\2\u017e"+
		"\u0f5a\3\2\2\2\u0180\u0f66\3\2\2\2\u0182\u0f6d\3\2\2\2\u0184\u0f6f\3\2"+
		"\2\2\u0186\u0f77\3\2\2\2\u0188\u0f7c\3\2\2\2\u018a\u0f81\3\2\2\2\u018c"+
		"\u0f84\3\2\2\2\u018e\u0f87\3\2\2\2\u0190\u0f8f\3\2\2\2\u0192\u0f93\3\2"+
		"\2\2\u0194\u0f9d\3\2\2\2\u0196\u0fab\3\2\2\2\u0198\u0fb5\3\2\2\2\u019a"+
		"\u0fc3\3\2\2\2\u019c\u0fca\3\2\2\2\u019e\u0fce\3\2\2\2\u01a0\u0fd0\3\2"+
		"\2\2\u01a2\u0fd5\3\2\2\2\u01a4\u0fd7\3\2\2\2\u01a6\u0fe0\3\2\2\2\u01a8"+
		"\u0fe8\3\2\2\2\u01aa\u0ff2\3\2\2\2\u01ac\u0ff7\3\2\2\2\u01ae\u100a\3\2"+
		"\2\2\u01b0\u100e\3\2\2\2\u01b2\u1013\3\2\2\2\u01b4\u1018\3\2\2\2\u01b6"+
		"\u101c\3\2\2\2\u01b8\u1028\3\2\2\2\u01ba\u1030\3\2\2\2\u01bc\u1032\3\2"+
		"\2\2\u01be\u1034\3\2\2\2\u01c0\u1036\3\2\2\2\u01c2\u1040\3\2\2\2\u01c4"+
		"\u1042\3\2\2\2\u01c6\u1046\3\2\2\2\u01c8\u1048\3\2\2\2\u01ca\u104c\3\2"+
		"\2\2\u01cc\u1056\3\2\2\2\u01ce\u1062\3\2\2\2\u01d0\u1064\3\2\2\2\u01d2"+
		"\u106c\3\2\2\2\u01d4\u1075\3\2\2\2\u01d6\u107d\3\2\2\2\u01d8\u107f\3\2"+
		"\2\2\u01da\u1081\3\2\2\2\u01dc\u1088\3\2\2\2\u01de\u108f\3\2\2\2\u01e0"+
		"\u1091\3\2\2\2\u01e2\u1093\3\2\2\2\u01e4\u1096\3\2\2\2\u01e6\u109b\3\2"+
		"\2\2\u01e8\u10a0\3\2\2\2\u01ea\u10a2\3\2\2\2\u01ec\u10a4\3\2\2\2\u01ee"+
		"\u10a6\3\2\2\2\u01f0\u10ad\3\2\2\2\u01f2\u10b1\3\2\2\2\u01f4\u10b3\3\2"+
		"\2\2\u01f6\u10bb\3\2\2\2\u01f8\u10c8\3\2\2\2\u01fa\u10ca\3\2\2\2\u01fc"+
		"\u10d2\3\2\2\2\u01fe\u10d9\3\2\2\2\u0200\u10db\3\2\2\2\u0202\u10e2\3\2"+
		"\2\2\u0204\u0205\5\4\3\2\u0205\u0206\7\u0152\2\2\u0206\u0208\3\2\2\2\u0207"+
		"\u0204\3\2\2\2\u0208\u020b\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2"+
		"\2\2\u020a\u020c\3\2\2\2\u020b\u0209\3\2\2\2\u020c\u020d\7\2\2\3\u020d"+
		"\3\3\2\2\2\u020e\u020f\5\6\4\2\u020f\5\3\2\2\2\u0210\u0214\5\b\5\2\u0211"+
		"\u0214\5\n\6\2\u0212\u0214\5\u00a0Q\2\u0213\u0210\3\2\2\2\u0213\u0211"+
		"\3\2\2\2\u0213\u0212\3\2\2\2\u0214\7\3\2\2\2\u0215\u0224\5X-\2\u0216\u0224"+
		"\5$\23\2\u0217\u0224\5&\24\2\u0218\u0224\5\60\31\2\u0219\u0224\5<\37\2"+
		"\u021a\u0224\5P)\2\u021b\u0224\5T+\2\u021c\u0224\5V,\2\u021d\u0224\5:"+
		"\36\2\u021e\u0224\5\62\32\2\u021f\u0224\5,\27\2\u0220\u0224\5\66\34\2"+
		"\u0221\u0224\5(\25\2\u0222\u0224\5*\26\2\u0223\u0215\3\2\2\2\u0223\u0216"+
		"\3\2\2\2\u0223\u0217\3\2\2\2\u0223\u0218\3\2\2\2\u0223\u0219\3\2\2\2\u0223"+
		"\u021a\3\2\2\2\u0223\u021b\3\2\2\2\u0223\u021c\3\2\2\2\u0223\u021d\3\2"+
		"\2\2\u0223\u021e\3\2\2\2\u0223\u021f\3\2\2\2\u0223\u0220\3\2\2\2\u0223"+
		"\u0221\3\2\2\2\u0223\u0222\3\2\2\2\u0224\t\3\2\2\2\u0225\u022c\5\f\7\2"+
		"\u0226\u022c\5\16\b\2\u0227\u022c\5\20\t\2\u0228\u022c\5\22\n\2\u0229"+
		"\u022c\5\36\20\2\u022a\u022c\5\"\22\2\u022b\u0225\3\2\2\2\u022b\u0226"+
		"\3\2\2\2\u022b\u0227\3\2\2\2\u022b\u0228\3\2\2\2\u022b\u0229\3\2\2\2\u022b"+
		"\u022a\3\2\2\2\u022c\13\3\2\2\2\u022d\u022e\7\b\2\2\u022e\u022f\7\60\2"+
		"\2\u022f\u0231\5@!\2\u0230\u0232\5\34\17\2\u0231\u0230\3\2\2\2\u0232\u0233"+
		"\3\2\2\2\u0233\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0236\3\2\2\2\u0235"+
		"\u0237\7e\2\2\u0236\u0235\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u024e\3\2"+
		"\2\2\u0238\u0239\7\b\2\2\u0239\u023a\7\60\2\2\u023a\u023b\5@!\2\u023b"+
		"\u023c\7\u00f2\2\2\u023c\u023d\7\u010f\2\2\u023d\u023e\5\u01a4\u00d3\2"+
		"\u023e\u024e\3\2\2\2\u023f\u0240\7\b\2\2\u0240\u0241\7\60\2\2\u0241\u0242"+
		"\5@!\2\u0242\u0243\7Z\2\2\u0243\u0244\7\u010f\2\2\u0244\u0245\5\u00a2"+
		"R\2\u0245\u024e\3\2\2\2\u0246\u0247\7\b\2\2\u0247\u0248\7\60\2\2\u0248"+
		"\u0249\5@!\2\u0249\u024a\7\u00fc\2\2\u024a\u024b\7j\2\2\u024b\u024c\5"+
		"\u01a4\u00d3\2\u024c\u024e\3\2\2\2\u024d\u022d\3\2\2\2\u024d\u0238\3\2"+
		"\2\2\u024d\u023f\3\2\2\2\u024d\u0246\3\2\2\2\u024e\r\3\2\2\2\u024f\u0250"+
		"\7\b\2\2\u0250\u0251\7j\2\2\u0251\u0252\5\u00a2R\2\u0252\u0253\7\u00f2"+
		"\2\2\u0253\u0254\7\u010f\2\2\u0254\u0255\5\u00a2R\2\u0255\u025e\3\2\2"+
		"\2\u0256\u0257\7\b\2\2\u0257\u0258\7j\2\2\u0258\u0259\5\u00a2R\2\u0259"+
		"\u025a\7Z\2\2\u025a\u025b\7\u010f\2\2\u025b\u025c\5\u00a2R\2\u025c\u025e"+
		"\3\2\2\2\u025d\u024f\3\2\2\2\u025d\u0256\3\2\2\2\u025e\17\3\2\2\2\u025f"+
		"\u0261\7\b\2\2\u0260\u0262\7_\2\2\u0261\u0260\3\2\2\2\u0261\u0262\3\2"+
		"\2\2\u0262\u0263\3\2\2\2\u0263\u0264\7\u00c8\2\2\u0264\u0265\5\u00a2R"+
		"\2\u0265\u0266\7\u00f2\2\2\u0266\u0267\7\u010f\2\2\u0267\u0268\5\u00a2"+
		"R\2\u0268\u0274\3\2\2\2\u0269\u026b\7\b\2\2\u026a\u026c\7_\2\2\u026b\u026a"+
		"\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026e\7\u00c8\2"+
		"\2\u026e\u026f\5\u00a2R\2\u026f\u0270\7Z\2\2\u0270\u0271\7\u010f\2\2\u0271"+
		"\u0272\5\u00a2R\2\u0272\u0274\3\2\2\2\u0273\u025f\3\2\2\2\u0273\u0269"+
		"\3\2\2\2\u0274\21\3\2\2\2\u0275\u0276\7\b\2\2\u0276\u0278\7t\2\2\u0277"+
		"\u0279\7\u00e1\2\2\u0278\u0277\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027b"+
		"\3\2\2\2\u027a\u027c\5\u01a4\u00d3\2\u027b\u027a\3\2\2\2\u027c\u027d\3"+
		"\2\2\2\u027d\u027b\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u027f\3\2\2\2\u027f"+
		"\u0284\5\24\13\2\u0280\u0281\7\u0153\2\2\u0281\u0283\5\24\13\2\u0282\u0280"+
		"\3\2\2\2\u0283\u0286\3\2\2\2\u0284\u0282\3\2\2\2\u0284\u0285\3\2\2\2\u0285"+
		"\u02a8\3\2\2\2\u0286\u0284\3\2\2\2\u0287\u0288\7\b\2\2\u0288\u028a\7t"+
		"\2\2\u0289\u028b\7\u00e1\2\2\u028a\u0289\3\2\2\2\u028a\u028b\3\2\2\2\u028b"+
		"\u028d\3\2\2\2\u028c\u028e\5\u01a4\u00d3\2\u028d\u028c\3\2\2\2\u028e\u028f"+
		"\3\2\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0291\3\2\2\2\u0291"+
		"\u0293\7\u00f2\2\2\u0292\u0294\7\u0098\2\2\u0293\u0292\3\2\2\2\u0293\u0294"+
		"\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0296\5\u01a4\u00d3\2\u0296\u0297\7"+
		"\u010f\2\2\u0297\u0298\5\u01a4\u00d3\2\u0298\u02a8\3\2\2\2\u0299\u029a"+
		"\7\b\2\2\u029a\u029b\7t\2\2\u029b\u029c\5\u01a4\u00d3\2\u029c\u029d\7"+
		"\u00f2\2\2\u029d\u029e\7\u010f\2\2\u029e\u029f\5\u01a4\u00d3\2\u029f\u02a8"+
		"\3\2\2\2\u02a0\u02a1\7\b\2\2\u02a1\u02a2\7t\2\2\u02a2\u02a3\5\u01a4\u00d3"+
		"\2\u02a3\u02a4\7\u00fc\2\2\u02a4\u02a5\7j\2\2\u02a5\u02a6\5\u01a4\u00d3"+
		"\2\u02a6\u02a8\3\2\2\2\u02a7\u0275\3\2\2\2\u02a7\u0287\3\2\2\2\u02a7\u0299"+
		"\3\2\2\2\u02a7\u02a0\3\2\2\2\u02a8\23\3\2\2\2\u02a9\u02ab\7\3\2\2\u02aa"+
		"\u02ac\7\u0098\2\2\u02ab\u02aa\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ad"+
		"\3\2\2\2\u02ad\u0381\5\\/\2\u02ae\u02b0\7\u00ac\2\2\u02af\u02b1\7\u0098"+
		"\2\2\u02b0\u02af\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b4\3\2\2\2\u02b2"+
		"\u02b3\78\2\2\u02b3\u02b5\7\u00b1\2\2\u02b4\u02b2\3\2\2\2\u02b4\u02b5"+
		"\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b8\5\u01a4\u00d3\2\u02b7\u02b9\t"+
		"\2\2\2\u02b8\u02b7\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u0381\3\2\2\2\u02ba"+
		"\u02bc\7\b\2\2\u02bb\u02bd\7\u0098\2\2\u02bc\u02bb\3\2\2\2\u02bc\u02bd"+
		"\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02c1\5\u01a4\u00d3\2\u02bf\u02c0\7"+
		"\u00fc\2\2\u02c0\u02c2\7\u00a3\2\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2"+
		"\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c4\7\u0110\2\2\u02c4\u02c7\5\u00b4["+
		"\2\u02c5\u02c6\7\23\2\2\u02c6\u02c8\5\u00a2R\2\u02c7\u02c5\3\2\2\2\u02c7"+
		"\u02c8\3\2\2\2\u02c8\u02cb\3\2\2\2\u02c9\u02ca\7\u0081\2\2\u02ca\u02cc"+
		"\5\u0104\u0083\2\u02cb\u02c9\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u0381\3"+
		"\2\2\2\u02cd\u02cf\7\b\2\2\u02ce\u02d0\7\u0098\2\2\u02cf\u02ce\3\2\2\2"+
		"\u02cf\u02d0\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02d2\5\u01a4\u00d3\2\u02d2"+
		"\u02d3\7\u00fc\2\2\u02d3\u02d4\7\34\2\2\u02d4\u02d5\5\u0104\u0083\2\u02d5"+
		"\u0381\3\2\2\2\u02d6\u02d8\7\b\2\2\u02d7\u02d9\7\u0098\2\2\u02d8\u02d7"+
		"\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u02db\5\u01a4\u00d3"+
		"\2\u02db\u02dc\7\u00ac\2\2\u02dc\u02dd\7\34\2\2\u02dd\u0381\3\2\2\2\u02de"+
		"\u02e0\7\b\2\2\u02df\u02e1\7\u0098\2\2\u02e0\u02df\3\2\2\2\u02e0\u02e1"+
		"\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e3\5\u01a4\u00d3\2\u02e3\u02e4\7"+
		"\u00fc\2\2\u02e4\u0381\3\2\2\2\u02e5\u02e6\7\u00ac\2\2\u02e6\u02e7\7P"+
		"\2\2\u02e7\u0381\7Q\2\2\u02e8\u02ea\7\b\2\2\u02e9\u02eb\7\u0098\2\2\u02ea"+
		"\u02e9\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02ed\5\u01a4"+
		"\u00d3\2\u02ed\u02ee\7\u00fc\2\2\u02ee\u02ef\7\u0101\2\2\u02ef\u02f0\7"+
		"\u0169\2\2\u02f0\u0381\3\2\2\2\u02f1\u02f3\7\b\2\2\u02f2\u02f4\7\u0098"+
		"\2\2\u02f3\u02f2\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5"+
		"\u02f6\5\u01a4\u00d3\2\u02f6\u02f7\7\u00fc\2\2\u02f7\u02f8\7\u015a\2\2"+
		"\u02f8\u02fd\5\26\f\2\u02f9\u02fa\7\u0153\2\2\u02fa\u02fc\5\26\f\2\u02fb"+
		"\u02f9\3\2\2\2\u02fc\u02ff\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fe\3\2"+
		"\2\2\u02fe\u0300\3\2\2\2\u02ff\u02fd\3\2\2\2\u0300\u0301\7\u015b\2\2\u0301"+
		"\u0381\3\2\2\2\u0302\u0304\7\b\2\2\u0303\u0305\7\u0098\2\2\u0304\u0303"+
		"\3\2\2\2\u0304\u0305\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u0307\5\u01a4\u00d3"+
		"\2\u0307\u0308\7\u00f4\2\2\u0308\u0309\7\u015a\2\2\u0309\u030e\5\32\16"+
		"\2\u030a\u030b\7\u0153\2\2\u030b\u030d\5\32\16\2\u030c\u030a\3\2\2\2\u030d"+
		"\u0310\3\2\2\2\u030e\u030c\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0311\3\2"+
		"\2\2\u0310\u030e\3\2\2\2\u0311\u0312\7\u015b\2\2\u0312\u0381\3\2\2\2\u0313"+
		"\u0315\7\b\2\2\u0314\u0316\7\u0098\2\2\u0315\u0314\3\2\2\2\u0315\u0316"+
		"\3\2\2\2\u0316\u0317\3\2\2\2\u0317\u0318\5\u01a4\u00d3\2\u0318\u0319\7"+
		"\u00fc\2\2\u0319\u031a\7\u0102\2\2\u031a\u031b\7\u00ea\2\2\u031b\u0381"+
		"\3\2\2\2\u031c\u0381\7\u00b3\2\2\u031d\u0381\7\u00b2\2\2\u031e\u0381\7"+
		"\u00ce\2\2\u031f\u0320\7\3\2\2\u0320\u0323\5`\61\2\u0321\u0322\7P\2\2"+
		"\u0322\u0324\7\u0115\2\2\u0323\u0321\3\2\2\2\u0323\u0324\3\2\2\2\u0324"+
		"\u0381\3\2\2\2\u0325\u0326\7\3\2\2\u0326\u0381\5\30\r\2\u0327\u0328\7"+
		"\u0116\2\2\u0328\u0329\7\26\2\2\u0329\u0381\5\u01a4\u00d3\2\u032a\u032b"+
		"\7\u00ac\2\2\u032b\u032e\7\26\2\2\u032c\u032d\78\2\2\u032d\u032f\7\u00b1"+
		"\2\2\u032e\u032c\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0330\3\2\2\2\u0330"+
		"\u0331\5\u01a4\u00d3\2\u0331\u0332\t\2\2\2\u0332\u0381\3\2\2\2\u0333\u0334"+
		"\7\u00a9\2\2\u0334\u0338\7z\2\2\u0335\u0339\5\u01a4\u00d3\2\u0336\u0339"+
		"\7\7\2\2\u0337\u0339\7\u0114\2\2\u0338\u0335\3\2\2\2\u0338\u0336\3\2\2"+
		"\2\u0338\u0337\3\2\2\2\u0338\u0339\3\2\2\2\u0339\u0381\3\2\2\2\u033a\u033b"+
		"\7\u00ad\2\2\u033b\u033f\7z\2\2\u033c\u0340\5\u01a4\u00d3\2\u033d\u0340"+
		"\7\7\2\2\u033e\u0340\7\u0114\2\2\u033f\u033c\3\2\2\2\u033f\u033d\3\2\2"+
		"\2\u033f\u033e\3\2\2\2\u033f\u0340\3\2\2\2\u0340\u0381\3\2\2\2\u0341\u0342"+
		"\7\u00ad\2\2\u0342\u0343\7\u00f3\2\2\u0343\u0344\7z\2\2\u0344\u0381\5"+
		"\u01a4\u00d3\2\u0345\u0346\7\u00ad\2\2\u0346\u0347\7\u008a\2\2\u0347\u0348"+
		"\7z\2\2\u0348\u0381\5\u01a4\u00d3\2\u0349\u034a\7\u00a9\2\2\u034a\u034b"+
		"\7i\2\2\u034b\u0381\5\u01a4\u00d3\2\u034c\u034d\7\u00ad\2\2\u034d\u034e"+
		"\7i\2\2\u034e\u0381\5\u01a4\u00d3\2\u034f\u0350\7\u00ad\2\2\u0350\u0351"+
		"\7\u00f3\2\2\u0351\u0352\7i\2\2\u0352\u0381\5\u01a4\u00d3\2\u0353\u0354"+
		"\7\u00ad\2\2\u0354\u0355\7\u008a\2\2\u0355\u0356\7i\2\2\u0356\u0381\5"+
		"\u01a4\u00d3\2\u0357\u0358\7\u0095\2\2\u0358\u0359\7\u00e0\2\2\u0359\u0381"+
		"\5\u01a4\u00d3\2\u035a\u035b\7\u00fc\2\2\u035b\u035c\7\u0088\2\2\u035c"+
		"\u0381\7\u0095\2\2\u035d\u035e\7\u00fc\2\2\u035e\u035f\7\u0087\2\2\u035f"+
		"\u0381\7S\2\2\u0360\u0361\7\u00fc\2\2\u0361\u0362\7\u0088\2\2\u0362\u0381"+
		"\7S\2\2\u0363\u0364\7\u00fc\2\2\u0364\u0381\5f\64\2\u0365\u0366\7\u00f4"+
		"\2\2\u0366\u0367\7\u015a\2\2\u0367\u036c\5h\65\2\u0368\u0369\7\u0153\2"+
		"\2\u0369\u036b\5h\65\2\u036a\u0368\3\2\2\2\u036b\u036e\3\2\2\2\u036c\u036a"+
		"\3\2\2\2\u036c\u036d\3\2\2\2\u036d\u036f\3\2\2\2\u036e\u036c\3\2\2\2\u036f"+
		"\u0370\7\u015b\2\2\u0370\u0381\3\2\2\2\u0371\u0372\7\u00bd\2\2\u0372\u0381"+
		"\5\u01a4\u00d3\2\u0373\u0374\7\u00da\2\2\u0374\u0375\7\u00bd\2\2\u0375"+
		"\u0381\5\u01a4\u00d3\2\u0376\u0377\7R\2\2\u0377\u0381\5\u01a4\u00d3\2"+
		"\u0378\u0379\7P\2\2\u0379\u0381\7R\2\2\u037a\u037b\7Z\2\2\u037b\u037c"+
		"\7\u010f\2\2\u037c\u0381\5\u01a4\u00d3\2\u037d\u037e\7\u00fc\2\2\u037e"+
		"\u037f\7\u0107\2\2\u037f\u0381\5\u01a4\u00d3\2\u0380\u02a9\3\2\2\2\u0380"+
		"\u02ae\3\2\2\2\u0380\u02ba\3\2\2\2\u0380\u02cd\3\2\2\2\u0380\u02d6\3\2"+
		"\2\2\u0380\u02de\3\2\2\2\u0380\u02e5\3\2\2\2\u0380\u02e8\3\2\2\2\u0380"+
		"\u02f1\3\2\2\2\u0380\u0302\3\2\2\2\u0380\u0313\3\2\2\2\u0380\u031c\3\2"+
		"\2\2\u0380\u031d\3\2\2\2\u0380\u031e\3\2\2\2\u0380\u031f\3\2\2\2\u0380"+
		"\u0325\3\2\2\2\u0380\u0327\3\2\2\2\u0380\u032a\3\2\2\2\u0380\u0333\3\2"+
		"\2\2\u0380\u033a\3\2\2\2\u0380\u0341\3\2\2\2\u0380\u0345\3\2\2\2\u0380"+
		"\u0349\3\2\2\2\u0380\u034c\3\2\2\2\u0380\u034f\3\2\2\2\u0380\u0353\3\2"+
		"\2\2\u0380\u0357\3\2\2\2\u0380\u035a\3\2\2\2\u0380\u035d\3\2\2\2\u0380"+
		"\u0360\3\2\2\2\u0380\u0363\3\2\2\2\u0380\u0365\3\2\2\2\u0380\u0371\3\2"+
		"\2\2\u0380\u0373\3\2\2\2\u0380\u0376\3\2\2\2\u0380\u0378\3\2\2\2\u0380"+
		"\u037a\3\2\2\2\u0380\u037d\3\2\2\2\u0381\25\3\2\2\2\u0382\u0383\5\32\16"+
		"\2\u0383\u0384\7\u0150\2\2\u0384\u0385\5\u00dep\2\u0385\27\3\2\2\2\u0386"+
		"\u0387\7\26\2\2\u0387\u0389\5\u01a4\u00d3\2\u0388\u0386\3\2\2\2\u0388"+
		"\u0389\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u039c\7~\2\2\u038b\u038c\7\\"+
		"\2\2\u038c\u038d\7I\2\2\u038d\u038e\7\u0081\2\2\u038e\u038f\7\u00be\2"+
		"\2\u038f\u0393\5\u01a4\u00d3\2\u0390\u0394\7\36\2\2\u0391\u0392\7P\2\2"+
		"\u0392\u0394\7\36\2\2\u0393\u0390\3\2\2\2\u0393\u0391\3\2\2\2\u0393\u0394"+
		"\3\2\2\2\u0394\u0399\3\2\2\2\u0395\u0396\7?\2\2\u0396\u039a\7\37\2\2\u0397"+
		"\u0398\7?\2\2\u0398\u039a\7:\2\2\u0399\u0395\3\2\2\2\u0399\u0397\3\2\2"+
		"\2\u0399\u039a\3\2\2\2\u039a\u039c\3\2\2\2\u039b\u0388\3\2\2\2\u039b\u038b"+
		"\3\2\2\2\u039c\31\3\2\2\2\u039d\u039e\t\3\2\2\u039e\33\3\2\2\2\u039f\u03a0"+
		"\7\u0090\2\2\u03a0\u03a1\7\u00e0\2\2\u03a1\u03a2\7Q\2\2\u03a2\u03cd\7"+
		"\u00c1\2\2\u03a3\u03a4\7f\2\2\u03a4\u03a5\7Q\2\2\u03a5\u03a6\7\u00e0\2"+
		"\2\u03a6\u03a7\7Q\2\2\u03a7\u03cd\7\u00c1\2\2\u03a8\u03a9\7r\2\2\u03a9"+
		"\u03cd\7;\2\2\u03aa\u03cd\7\u00ff\2\2\u03ab\u03ad\7\u011c\2\2\u03ac\u03ae"+
		"\7\u00b3\2\2\u03ad\u03ac\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae\u03af\3\2\2"+
		"\2\u03af\u03b0\7\u00fa\2\2\u03b0\u03cd\7F\2\2\u03b1\u03b3\7\u00b3\2\2"+
		"\u03b2\u03b1\3\2\2\2\u03b2\u03b3\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b5"+
		"\7\u00fa\2\2\u03b5\u03cd\7\u00a7\2\2\u03b6\u03b7\7\u009e\2\2\u03b7\u03cd"+
		"\7\u0169\2\2\u03b8\u03b9\7b\2\2\u03b9\u03cd\7\u0169\2\2\u03ba\u03bb\7"+
		"\u00fc\2\2\u03bb\u03c1\5\u00a2R\2\u03bc\u03bd\7\u010f\2\2\u03bd\u03c2"+
		"\5\u00a2R\2\u03be\u03bf\7\u0150\2\2\u03bf\u03c2\5\u00a2R\2\u03c0\u03c2"+
		"\7\34\2\2\u03c1\u03bc\3\2\2\2\u03c1\u03be\3\2\2\2\u03c1\u03c0\3\2\2\2"+
		"\u03c2\u03cd\3\2\2\2\u03c3\u03c4\7\u00fc\2\2\u03c4\u03c5\5\u00a2R\2\u03c5"+
		"\u03c6\7\62\2\2\u03c6\u03c7\7\u00a1\2\2\u03c7\u03cd\3\2\2\2\u03c8\u03c9"+
		"\7\u00f4\2\2\u03c9\u03cd\5\u00a2R\2\u03ca\u03cb\7\u00f4\2\2\u03cb\u03cd"+
		"\7\7\2\2\u03cc\u039f\3\2\2\2\u03cc\u03a3\3\2\2\2\u03cc\u03a8\3\2\2\2\u03cc"+
		"\u03aa\3\2\2\2\u03cc\u03ab\3\2\2\2\u03cc\u03b2\3\2\2\2\u03cc\u03b6\3\2"+
		"\2\2\u03cc\u03b8\3\2\2\2\u03cc\u03ba\3\2\2\2\u03cc\u03c3\3\2\2\2\u03cc"+
		"\u03c8\3\2\2\2\u03cc\u03ca\3\2\2\2\u03cd\35\3\2\2\2\u03ce\u03cf\7\b\2"+
		"\2\u03cf\u03d0\7\34\2\2\u03d0\u03db\7]\2\2\u03d1\u03d2\7-\2\2\u03d2\u03d3"+
		"\t\4\2\2\u03d3\u03d8\5\u00a2R\2\u03d4\u03d5\7\u0153\2\2\u03d5\u03d7\5"+
		"\u00a2R\2\u03d6\u03d4\3\2\2\2\u03d7\u03da\3\2\2\2\u03d8\u03d6\3\2\2\2"+
		"\u03d8\u03d9\3\2\2\2\u03d9\u03dc\3\2\2\2\u03da\u03d8\3\2\2\2\u03db\u03d1"+
		"\3\2\2\2\u03db\u03dc\3\2\2\2\u03dc\u03e7\3\2\2\2\u03dd\u03de\7<\2\2\u03de"+
		"\u03df\7j\2\2\u03df\u03e4\5\u00a2R\2\u03e0\u03e1\7\u0153\2\2\u03e1\u03e3"+
		"\5\u00a2R\2\u03e2\u03e0\3\2\2\2\u03e3\u03e6\3\2\2\2\u03e4\u03e2\3\2\2"+
		"\2\u03e4\u03e5\3\2\2\2\u03e5\u03e8\3\2\2\2\u03e6\u03e4\3\2\2\2\u03e7\u03dd"+
		"\3\2\2\2\u03e7\u03e8\3\2\2\2\u03e8\u03e9\3\2\2\2\u03e9\u03ea\5 \21\2\u03ea"+
		"\37\3\2\2\2\u03eb\u03f8\7\64\2\2\u03ec\u03f1\t\5\2\2\u03ed\u03ee\7\u0153"+
		"\2\2\u03ee\u03f0\t\5\2\2\u03ef\u03ed\3\2\2\2\u03f0\u03f3\3\2\2\2\u03f1"+
		"\u03ef\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f9\3\2\2\2\u03f3\u03f1\3\2"+
		"\2\2\u03f4\u03f6\7\7\2\2\u03f5\u03f7\7]\2\2\u03f6\u03f5\3\2\2\2\u03f6"+
		"\u03f7\3\2\2\2\u03f7\u03f9\3\2\2\2\u03f8\u03ec\3\2\2\2\u03f8\u03f4\3\2"+
		"\2\2\u03f9\u03fa\3\2\2\2\u03fa\u03fb\7\u00e0\2\2\u03fb\u03fc\7\u0108\2"+
		"\2\u03fc\u0474\58\35\2\u03fd\u040a\7\64\2\2\u03fe\u0403\t\6\2\2\u03ff"+
		"\u0400\7\u0153\2\2\u0400\u0402\t\6\2\2\u0401\u03ff\3\2\2\2\u0402\u0405"+
		"\3\2\2\2\u0403\u0401\3\2\2\2\u0403\u0404\3\2\2\2\u0404\u040b\3\2\2\2\u0405"+
		"\u0403\3\2\2\2\u0406\u0408\7\7\2\2\u0407\u0409\7]\2\2\u0408\u0407\3\2"+
		"\2\2\u0408\u0409\3\2\2\2\u0409\u040b\3\2\2\2\u040a\u03fe\3\2\2\2\u040a"+
		"\u0406\3\2\2\2\u040b\u040c\3\2\2\2\u040c\u040d\7\u00e0\2\2\u040d\u040e"+
		"\7l\2\2\u040e\u0474\58\35\2\u040f\u0415\7\64\2\2\u0410\u0416\7*\2\2\u0411"+
		"\u0413\7\7\2\2\u0412\u0414\7]\2\2\u0413\u0412\3\2\2\2\u0413\u0414\3\2"+
		"\2\2\u0414\u0416\3\2\2\2\u0415\u0410\3\2\2\2\u0415\u0411\3\2\2\2\u0416"+
		"\u0417\3\2\2\2\u0417\u0418\7\u00e0\2\2\u0418\u0419\7\61\2\2\u0419\u0474"+
		"\58\35\2\u041a\u0420\7\64\2\2\u041b\u0421\7\u0080\2\2\u041c\u041e\7\7"+
		"\2\2\u041d\u041f\7]\2\2\u041e\u041d\3\2\2\2\u041e\u041f\3\2\2\2\u041f"+
		"\u0421\3\2\2\2\u0420\u041b\3\2\2\2\u0420\u041c\3\2\2\2\u0421\u0422\3\2"+
		"\2\2\u0422\u0423\7\u00e0\2\2\u0423\u0424\7\u0111\2\2\u0424\u0474\58\35"+
		"\2\u0425\u0429\7g\2\2\u0426\u0427\7\64\2\2\u0427\u0428\7\u00e2\2\2\u0428"+
		"\u042a\7-\2\2\u0429\u0426\3\2\2\2\u0429\u042a\3\2\2\2\u042a\u0437\3\2"+
		"\2\2\u042b\u0430\t\5\2\2\u042c\u042d\7\u0153\2\2\u042d\u042f\t\5\2\2\u042e"+
		"\u042c\3\2\2\2\u042f\u0432\3\2\2\2\u0430\u042e\3\2\2\2\u0430\u0431\3\2"+
		"\2\2\u0431\u0438\3\2\2\2\u0432\u0430\3\2\2\2\u0433\u0435\7\7\2\2\u0434"+
		"\u0436\7]\2\2\u0435\u0434\3\2\2\2\u0435\u0436\3\2\2\2\u0436\u0438\3\2"+
		"\2\2\u0437\u042b\3\2\2\2\u0437\u0433\3\2\2\2\u0438\u0439\3\2\2\2\u0439"+
		"\u043a\7\u00e0\2\2\u043a\u043b\7\u0108\2\2\u043b\u0474\5\64\33\2\u043c"+
		"\u0440\7g\2\2\u043d\u043e\7\64\2\2\u043e\u043f\7\u00e2\2\2\u043f\u0441"+
		"\7-\2\2\u0440\u043d\3\2\2\2\u0440\u0441\3\2\2\2\u0441\u044e\3\2\2\2\u0442"+
		"\u0447\t\6\2\2\u0443\u0444\7\u0153\2\2\u0444\u0446\t\6\2\2\u0445\u0443"+
		"\3\2\2\2\u0446\u0449\3\2\2\2\u0447\u0445\3\2\2\2\u0447\u0448\3\2\2\2\u0448"+
		"\u044f\3\2\2\2\u0449\u0447\3\2\2\2\u044a\u044c\7\7\2\2\u044b\u044d\7]"+
		"\2\2\u044c\u044b\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u044f\3\2\2\2\u044e"+
		"\u0442\3\2\2\2\u044e\u044a\3\2\2\2\u044f\u0450\3\2\2\2\u0450\u0451\7\u00e0"+
		"\2\2\u0451\u0452\7l\2\2\u0452\u0474\5\64\33\2\u0453\u0457\7g\2\2\u0454"+
		"\u0455\7\64\2\2\u0455\u0456\7\u00e2\2\2\u0456\u0458\7-\2\2\u0457\u0454"+
		"\3\2\2\2\u0457\u0458\3\2\2\2\u0458\u045e\3\2\2\2\u0459\u045f\7*\2\2\u045a"+
		"\u045c\7\7\2\2\u045b\u045d\7]\2\2\u045c\u045b\3\2\2\2\u045c\u045d\3\2"+
		"\2\2\u045d\u045f\3\2\2\2\u045e\u0459\3\2\2\2\u045e\u045a\3\2\2\2\u045f"+
		"\u0460\3\2\2\2\u0460\u0461\7\u00e0\2\2\u0461\u0462\7\61\2\2\u0462\u0474"+
		"\5\64\33\2\u0463\u0467\7g\2\2\u0464\u0465\7\64\2\2\u0465\u0466\7\u00e2"+
		"\2\2\u0466\u0468\7-\2\2\u0467\u0464\3\2\2\2\u0467\u0468\3\2\2\2\u0468"+
		"\u046e\3\2\2\2\u0469\u046f\7\u0080\2\2\u046a\u046c\7\7\2\2\u046b\u046d"+
		"\7]\2\2\u046c\u046b\3\2\2\2\u046c\u046d\3\2\2\2\u046d\u046f\3\2\2\2\u046e"+
		"\u0469\3\2\2\2\u046e\u046a\3\2\2\2\u046f\u0470\3\2\2\2\u0470\u0471\7\u00e0"+
		"\2\2\u0471\u0472\7\u0111\2\2\u0472\u0474\5\64\33\2\u0473\u03eb\3\2\2\2"+
		"\u0473\u03fd\3\2\2\2\u0473\u040f\3\2\2\2\u0473\u041a\3\2\2\2\u0473\u0425"+
		"\3\2\2\2\u0473\u043c\3\2\2\2\u0473\u0453\3\2\2\2\u0473\u0463\3\2\2\2\u0474"+
		"!\3\2\2\2\u0475\u0476\7\b\2\2\u0476\u0479\7k\2\2\u0477\u0478\78\2\2\u0478"+
		"\u047a\7\u00b1\2\2\u0479\u0477\3\2\2\2\u0479\u047a\3\2\2\2\u047a\u047b"+
		"\3\2\2\2\u047b\u0486\5\u01a4\u00d3\2\u047c\u0485\5R*\2\u047d\u0482\7\u00f5"+
		"\2\2\u047e\u0480\7\u0087\2\2\u047f\u047e\3\2\2\2\u047f\u0480\3\2\2\2\u0480"+
		"\u0481\3\2\2\2\u0481\u0483\5\u00a2R\2\u0482\u047f\3\2\2\2\u0482\u0483"+
		"\3\2\2\2\u0483\u0485\3\2\2\2\u0484\u047c\3\2\2\2\u0484\u047d\3\2\2\2\u0485"+
		"\u0488\3\2\2\2\u0486\u0484\3\2\2\2\u0486\u0487\3\2\2\2\u0487\u04ab\3\2"+
		"\2\2\u0488\u0486\3\2\2\2\u0489\u048a\7\b\2\2\u048a\u048d\7k\2\2\u048b"+
		"\u048c\78\2\2\u048c\u048e\7\u00b1\2\2\u048d\u048b\3\2\2\2\u048d\u048e"+
		"\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u0490\5\u01a4\u00d3\2\u0490\u0491\7"+
		"Z\2\2\u0491\u0492\7\u010f\2\2\u0492\u0493\5\u01a4\u00d3\2\u0493\u04ab"+
		"\3\2\2\2\u0494\u0495\7\b\2\2\u0495\u0498\7k\2\2\u0496\u0497\78\2\2\u0497"+
		"\u0499\7\u00b1\2\2\u0498\u0496\3\2\2\2\u0498\u0499\3\2\2\2\u0499\u049a"+
		"\3\2\2\2\u049a\u049b\5\u01a4\u00d3\2\u049b\u049c\7\u00f2\2\2\u049c\u049d"+
		"\7\u010f\2\2\u049d\u049e\5\u01a4\u00d3\2\u049e\u04ab\3\2\2\2\u049f\u04a0"+
		"\7\b\2\2\u04a0\u04a3\7k\2\2\u04a1\u04a2\78\2\2\u04a2\u04a4\7\u00b1\2\2"+
		"\u04a3\u04a1\3\2\2\2\u04a3\u04a4\3\2\2\2\u04a4\u04a5\3\2\2\2\u04a5\u04a6"+
		"\5\u01a4\u00d3\2\u04a6\u04a7\7\u00fc\2\2\u04a7\u04a8\7j\2\2\u04a8\u04a9"+
		"\5\u01a4\u00d3\2\u04a9\u04ab\3\2\2\2\u04aa\u0475\3\2\2\2\u04aa\u0489\3"+
		"\2\2\2\u04aa\u0494\3\2\2\2\u04aa\u049f\3\2\2\2\u04ab#\3\2\2\2\u04ac\u04ae"+
		"\7\31\2\2\u04ad\u04af\7~\2\2\u04ae\u04ad\3\2\2\2\u04ae\u04af\3\2\2\2\u04af"+
		"\u04b0\3\2\2\2\u04b0\u04b2\7\u00be\2\2\u04b1\u04b3\7\u009c\2\2\u04b2\u04b1"+
		"\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3\u04b5\3\2\2\2\u04b4\u04b6\5\u01a4\u00d3"+
		"\2\u04b5\u04b4\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u04b7\3\2\2\2\u04b7\u04b8"+
		"\7\u00e0\2\2\u04b8\u04bb\5\u01a4\u00d3\2\u04b9\u04ba\7\u0081\2\2\u04ba"+
		"\u04bc\5\u01a4\u00d3\2\u04bb\u04b9\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc\u04bd"+
		"\3\2\2\2\u04bd\u04bf\5\u01f8\u00fd\2\u04be\u04c0\5z>\2\u04bf\u04be\3\2"+
		"\2\2\u04bf\u04c0\3\2\2\2\u04c0\u04c3\3\2\2\2\u04c1\u04c2\7\u0107\2\2\u04c2"+
		"\u04c4\5\u01a4\u00d3\2\u04c3\u04c1\3\2\2\2\u04c3\u04c4\3\2\2\2\u04c4\u04c7"+
		"\3\2\2\2\u04c5\u04c6\7\u0086\2\2\u04c6\u04c8\5\u0130\u0099\2\u04c7\u04c5"+
		"\3\2\2\2\u04c7\u04c8\3\2\2\2\u04c8%\3\2\2\2\u04c9\u04ca\7\31\2\2\u04ca"+
		"\u04ce\7+\2\2\u04cb\u04cc\78\2\2\u04cc\u04cd\7P\2\2\u04cd\u04cf\7\u00b1"+
		"\2\2\u04ce\u04cb\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf\u04d0\3\2\2\2\u04d0"+
		"\u04d2\5\u00a2R\2\u04d1\u04d3\7\u0087\2\2\u04d2\u04d1\3\2\2\2\u04d2\u04d3"+
		"\3\2\2\2\u04d3\u04d6\3\2\2\2\u04d4\u04d5\7j\2\2\u04d5\u04d7\5\u00a2R\2"+
		"\u04d6\u04d4\3\2\2\2\u04d6\u04d7\3\2\2\2\u04d7\u04da\3\2\2\2\u04d8\u04d9"+
		"\7\u011b\2\2\u04d9\u04db\5\u00a2R\2\u04da\u04d8\3\2\2\2\u04da\u04db\3"+
		"\2\2\2\u04db\u04de\3\2\2\2\u04dc\u04dd\7\62\2\2\u04dd\u04df\5\u00a2R\2"+
		"\u04de\u04dc\3\2\2\2\u04de\u04df\3\2\2\2\u04df\'\3\2\2\2\u04e0\u04e3\7"+
		"\31\2\2\u04e1\u04e2\7W\2\2\u04e2\u04e4\7d\2\2\u04e3\u04e1\3\2\2\2\u04e3"+
		"\u04e4\3\2\2\2\u04e4\u04e6\3\2\2\2\u04e5\u04e7\7_\2\2\u04e6\u04e5\3\2"+
		"\2\2\u04e6\u04e7\3\2\2\2\u04e7\u04e8\3\2\2\2\u04e8\u04e9\7\u00c8\2\2\u04e9"+
		"\u0502\5\u00a2R\2\u04ea\u04ed\7\31\2\2\u04eb\u04ec\7W\2\2\u04ec\u04ee"+
		"\7d\2\2\u04ed\u04eb\3\2\2\2\u04ed\u04ee\3\2\2\2\u04ee\u04f0\3\2\2\2\u04ef"+
		"\u04f1\7y\2\2\u04f0\u04ef\3\2\2\2\u04f0\u04f1\3\2\2\2\u04f1\u04f3\3\2"+
		"\2\2\u04f2\u04f4\7_\2\2\u04f3\u04f2\3\2\2\2\u04f3\u04f4\3\2\2\2\u04f4"+
		"\u04f5\3\2\2\2\u04f5\u04f6\7\u00c8\2\2\u04f6\u04f7\5\u00a2R\2\u04f7\u04f8"+
		"\7\67\2\2\u04f8\u04fb\5\u01a4\u00d3\2\u04f9\u04fa\7@\2\2\u04fa\u04fc\5"+
		"\u01a4\u00d3\2\u04fb\u04f9\3\2\2\2\u04fb\u04fc\3\2\2\2\u04fc\u04ff\3\2"+
		"\2\2\u04fd\u04fe\7\u0082\2\2\u04fe\u0500\5\u01a4\u00d3\2\u04ff\u04fd\3"+
		"\2\2\2\u04ff\u0500\3\2\2\2\u0500\u0502\3\2\2\2\u0501\u04e0\3\2\2\2\u0501"+
		"\u04ea\3\2\2\2\u0502)\3\2\2\2\u0503\u0504\7\31\2\2\u0504\u0505\7\u00af"+
		"\2\2\u0505\u0506\7z\2\2\u0506\u0507\5\u01a4\u00d3\2\u0507\u0508\7\u00e0"+
		"\2\2\u0508\u051d\5\u01a4\u00d3\2\u0509\u050a\7\u0085\2\2\u050a\u0519\5"+
		"\u01a4\u00d3\2\u050b\u050c\7<\2\2\u050c\u050d\7\u015a\2\2\u050d\u0512"+
		"\7\u0170\2\2\u050e\u050f\7\u0153\2\2\u050f\u0511\7\u0170\2\2\u0510\u050e"+
		"\3\2\2\2\u0511\u0514\3\2\2\2\u0512\u0510\3\2\2\2\u0512\u0513\3\2\2\2\u0513"+
		"\u0515\3\2\2\2\u0514\u0512\3\2\2\2\u0515\u0517\7\u015b\2\2\u0516\u0518"+
		"\7\t\2\2\u0517\u0516\3\2\2\2\u0517\u0518\3\2\2\2\u0518\u051a\3\2\2\2\u0519"+
		"\u050b\3\2\2\2\u051a\u051b\3\2\2\2\u051b\u0519\3\2\2\2\u051b\u051c\3\2"+
		"\2\2\u051c\u051e\3\2\2\2\u051d\u0509\3\2\2\2\u051d\u051e\3\2\2\2\u051e"+
		"\u051f\3\2\2\2\u051f\u0520\7*\2\2\u0520\u0521\7^\2\2\u0521\u0522\5\u0104"+
		"\u0083\2\u0522+\3\2\2\2\u0523\u0525\7\u00fc\2\2\u0524\u0526\t\7\2\2\u0525"+
		"\u0524\3\2\2\2\u0525\u0526\3\2\2\2\u0526\u0527\3\2\2\2\u0527\u0528\5\u00a2"+
		"R\2\u0528\u0529\t\b\2\2\u0529\u052e\5.\30\2\u052a\u052b\7\u0153\2\2\u052b"+
		"\u052d\5.\30\2\u052c\u052a\3\2\2\2\u052d\u0530\3\2\2\2\u052e\u052c\3\2"+
		"\2\2\u052e\u052f\3\2\2\2\u052f\u0548\3\2\2\2\u0530\u052e\3\2\2\2\u0531"+
		"\u0533\7\u00fc\2\2\u0532\u0534\t\7\2\2\u0533\u0532\3\2\2\2\u0533\u0534"+
		"\3\2\2\2\u0534\u0535\3\2\2\2\u0535\u0536\7\u013c\2\2\u0536\u053a\7\u0121"+
		"\2\2\u0537\u053b\5\u00a2R\2\u0538\u053b\7N\2\2\u0539\u053b\7\34\2\2\u053a"+
		"\u0537\3\2\2\2\u053a\u0538\3\2\2\2\u053a\u0539\3\2\2\2\u053b\u0544\3\2"+
		"\2\2\u053c\u0540\7\u0153\2\2\u053d\u0541\5\u00a2R\2\u053e\u0541\7N\2\2"+
		"\u053f\u0541\7\34\2\2\u0540\u053d\3\2\2\2\u0540\u053e\3\2\2\2\u0540\u053f"+
		"\3\2\2\2\u0541\u0543\3\2\2\2\u0542\u053c\3\2\2\2\u0543\u0546\3\2\2\2\u0544"+
		"\u0542\3\2\2\2\u0544\u0545\3\2\2\2\u0545\u0548\3\2\2\2\u0546\u0544\3\2"+
		"\2\2\u0547\u0523\3\2\2\2\u0547\u0531\3\2\2\2\u0548-\3\2\2\2\u0549\u0550"+
		"\5\u0104\u0083\2\u054a\u054b\7\u0164\2\2\u054b\u054c\5\u0104\u0083\2\u054c"+
		"\u054d\7\u0164\2\2\u054d\u0550\3\2\2\2\u054e\u0550\7\34\2\2\u054f\u0549"+
		"\3\2\2\2\u054f\u054a\3\2\2\2\u054f\u054e\3\2\2\2\u0550/\3\2\2\2\u0551"+
		"\u0553\7\31\2\2\u0552\u0554\7\26\2\2\u0553\u0552\3\2\2\2\u0553\u0554\3"+
		"\2\2\2\u0554\u0555\3\2\2\2\u0555\u0556\7z\2\2\u0556\u055b\5\u00a2R\2\u0557"+
		"\u055c\7\16\2\2\u0558\u0559\7E\2\2\u0559\u055c\7R\2\2\u055a\u055c\7\5"+
		"\2\2\u055b\u0557\3\2\2\2\u055b\u0558\3\2\2\2\u055b\u055a\3\2\2\2\u055c"+
		"\u0571\3\2\2\2\u055d\u056d\7\u00c2\2\2\u055e\u056d\7 \2\2\u055f\u056d"+
		"\7|\2\2\u0560\u056a\7\177\2\2\u0561\u0562\7R\2\2\u0562\u0567\5\u00a2R"+
		"\2\u0563\u0564\7\u0153\2\2\u0564\u0566\5\u00a2R\2\u0565\u0563\3\2\2\2"+
		"\u0566\u0569\3\2\2\2\u0567\u0565\3\2\2\2\u0567\u0568\3\2\2\2\u0568\u056b"+
		"\3\2\2\2\u0569\u0567\3\2\2\2\u056a\u0561\3\2\2\2\u056a\u056b\3\2\2\2\u056b"+
		"\u056d\3\2\2\2\u056c\u055d\3\2\2\2\u056c\u055e\3\2\2\2\u056c\u055f\3\2"+
		"\2\2\u056c\u0560\3\2\2\2\u056d\u056f\3\2\2\2\u056e\u0570\7W\2\2\u056f"+
		"\u056e\3\2\2\2\u056f\u0570\3\2\2\2\u0570\u0572\3\2\2\2\u0571\u056c\3\2"+
		"\2\2\u0572\u0573\3\2\2\2\u0573\u0571\3\2\2\2\u0573\u0574\3\2\2\2\u0574"+
		"\u0575\3\2\2\2\u0575\u0576\7\u00e0\2\2\u0576\u0579\5\u01a4\u00d3\2\u0577"+
		"\u0578\7\62\2\2\u0578\u057a\5\u01a4\u00d3\2\u0579\u0577\3\2\2\2\u0579"+
		"\u057a\3\2\2\2\u057a\u0584\3\2\2\2\u057b\u057c\7P\2\2\u057c\u0585\7\36"+
		"\2\2\u057d\u057f\7\36\2\2\u057e\u057d\3\2\2\2\u057e\u057f\3\2\2\2\u057f"+
		"\u0580\3\2\2\2\u0580\u0581\7?\2\2\u0581\u0585\7:\2\2\u0582\u0583\7?\2"+
		"\2\u0583\u0585\7\37\2\2\u0584\u057b\3\2\2\2\u0584\u057e\3\2\2\2\u0584"+
		"\u0582\3\2\2\2\u0584\u0585\3\2\2\2\u0585\u058c\3\2\2\2\u0586\u0588\7-"+
		"\2\2\u0587\u0589\7$\2\2\u0588\u0587\3\2\2\2\u0588\u0589\3\2\2\2\u0589"+
		"\u058a\3\2\2\2\u058a\u058d\7a\2\2\u058b\u058d\7q\2\2\u058c\u0586\3\2\2"+
		"\2\u058c\u058b\3\2\2\2\u058c\u058d\3\2\2\2\u058d\u0590\3\2\2\2\u058e\u058f"+
		"\7\u0085\2\2\u058f\u0591\5\u0130\u0099\2\u0590\u058e\3\2\2\2\u0590\u0591"+
		"\3\2\2\2\u0591\u0592\3\2\2\2\u0592\u0593\7*\2\2\u0593\u0594\7^\2\2\u0594"+
		"\u0595\5\u01a4\u00d3\2\u0595\u0597\7\u015a\2\2\u0596\u0598\5\u00a2R\2"+
		"\u0597\u0596\3\2\2\2\u0597\u0598\3\2\2\2\u0598\u059d\3\2\2\2\u0599\u059a"+
		"\7\u0153\2\2\u059a\u059c\5\u00a2R\2\u059b\u0599\3\2\2\2\u059c\u059f\3"+
		"\2\2\2\u059d\u059b\3\2\2\2\u059d\u059e\3\2\2\2\u059e\u05a0\3\2\2\2\u059f"+
		"\u059d\3\2\2\2\u05a0\u05a1\7\u015b\2\2\u05a1\61\3\2\2\2\u05a2\u05a6\7"+
		"g\2\2\u05a3\u05a4\7\64\2\2\u05a4\u05a5\7\u00e2\2\2\u05a5\u05a7\7-\2\2"+
		"\u05a6\u05a3\3\2\2\2\u05a6\u05a7\3\2\2\2\u05a7\u05b4\3\2\2\2\u05a8\u05ad"+
		"\t\5\2\2\u05a9\u05aa\7\u0153\2\2\u05aa\u05ac\t\5\2\2\u05ab\u05a9\3\2\2"+
		"\2\u05ac\u05af\3\2\2\2\u05ad\u05ab\3\2\2\2\u05ad\u05ae\3\2\2\2\u05ae\u05b5"+
		"\3\2\2\2\u05af\u05ad\3\2\2\2\u05b0\u05b2\7\7\2\2\u05b1\u05b3\7]\2\2\u05b2"+
		"\u05b1\3\2\2\2\u05b2\u05b3\3\2\2\2\u05b3\u05b5\3\2\2\2\u05b4\u05a8\3\2"+
		"\2\2\u05b4\u05b0\3\2\2\2\u05b5\u05b6\3\2\2\2\u05b6\u05c8\7\u00e0\2\2\u05b7"+
		"\u05b9\7t\2\2\u05b8\u05b7\3\2\2\2\u05b8\u05b9\3\2\2\2\u05b9\u05ba\3\2"+
		"\2\2\u05ba\u05bc\5\u01a4\u00d3\2\u05bb\u05b8\3\2\2\2\u05bc\u05bd\3\2\2"+
		"\2\u05bd\u05bb\3\2\2\2\u05bd\u05be\3\2\2\2\u05be\u05c9\3\2\2\2\u05bf\u05c0"+
		"\7\7\2\2\u05c0\u05c1\7\u0108\2\2\u05c1\u05c2\7<\2\2\u05c2\u05c4\7j\2\2"+
		"\u05c3\u05c5\5\u00a2R\2\u05c4\u05c3\3\2\2\2\u05c5\u05c6\3\2\2\2\u05c6"+
		"\u05c4\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u05c9\3\2\2\2\u05c8\u05bb\3\2"+
		"\2\2\u05c8\u05bf\3\2\2\2\u05c9\u05ca\3\2\2\2\u05ca\u05cb\5\64\33\2\u05cb"+
		"\u0721\3\2\2\2\u05cc\u05d0\7g\2\2\u05cd\u05ce\7\64\2\2\u05ce\u05cf\7\u00e2"+
		"\2\2\u05cf\u05d1\7-\2\2\u05d0\u05cd\3\2\2\2\u05d0\u05d1\3\2\2\2\u05d1"+
		"\u05f1\3\2\2\2\u05d2\u05d3\t\t\2\2\u05d3\u05d4\7\u015a\2\2\u05d4\u05d9"+
		"\5\u00a2R\2\u05d5\u05d6\7\u0153\2\2\u05d6\u05d8\5\u00a2R\2\u05d7\u05d5"+
		"\3\2\2\2\u05d8\u05db\3\2\2\2\u05d9\u05d7\3\2\2\2\u05d9\u05da\3\2\2\2\u05da"+
		"\u05dc\3\2\2\2\u05db\u05d9\3\2\2\2\u05dc\u05dd\7\u015b\2\2\u05dd\u05df"+
		"\3\2\2\2\u05de\u05d2\3\2\2\2\u05df\u05e0\3\2\2\2\u05e0\u05de\3\2\2\2\u05e0"+
		"\u05e1\3\2\2\2\u05e1\u05f2\3\2\2\2\u05e2\u05e4\7\7\2\2\u05e3\u05e5\7]"+
		"\2\2\u05e4\u05e3\3\2\2\2\u05e4\u05e5\3\2\2\2\u05e5\u05e6\3\2\2\2\u05e6"+
		"\u05e7\7\u015a\2\2\u05e7\u05ec\5\u00a2R\2\u05e8\u05e9\7\u0153\2\2\u05e9"+
		"\u05eb\5\u00a2R\2\u05ea\u05e8\3\2\2\2\u05eb\u05ee\3\2\2\2\u05ec\u05ea"+
		"\3\2\2\2\u05ec\u05ed\3\2\2\2\u05ed\u05ef\3\2\2\2\u05ee\u05ec\3\2\2\2\u05ef"+
		"\u05f0\7\u015b\2\2\u05f0\u05f2\3\2\2\2\u05f1\u05de\3\2\2\2\u05f1\u05e2"+
		"\3\2\2\2\u05f2\u05f3\3\2\2\2\u05f3\u05f5\7\u00e0\2\2\u05f4\u05f6\7t\2"+
		"\2\u05f5\u05f4\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u05f7\3\2\2\2\u05f7\u05fc"+
		"\5\u01a4\u00d3\2\u05f8\u05f9\7\u0153\2\2\u05f9\u05fb\5\u01a4\u00d3\2\u05fa"+
		"\u05f8\3\2\2\2\u05fb\u05fe\3\2\2\2\u05fc\u05fa\3\2\2\2\u05fc\u05fd\3\2"+
		"\2\2\u05fd\u05ff\3\2\2\2\u05fe\u05fc\3\2\2\2\u05ff\u0600\5\64\33\2\u0600"+
		"\u0721\3\2\2\2\u0601\u0605\7g\2\2\u0602\u0603\7\64\2\2\u0603\u0604\7\u00e2"+
		"\2\2\u0604\u0606\7-\2\2\u0605\u0602\3\2\2\2\u0605\u0606\3\2\2\2\u0606"+
		"\u0610\3\2\2\2\u0607\u0609\t\6\2\2\u0608\u0607\3\2\2\2\u0609\u060a\3\2"+
		"\2\2\u060a\u0608\3\2\2\2\u060a\u060b\3\2\2\2\u060b\u0611\3\2\2\2\u060c"+
		"\u060e\7\7\2\2\u060d\u060f\7]\2\2\u060e\u060d\3\2\2\2\u060e\u060f\3\2"+
		"\2\2\u060f\u0611\3\2\2\2\u0610\u0608\3\2\2\2\u0610\u060c\3\2\2\2\u0611"+
		"\u0612\3\2\2\2\u0612\u0628\7\u00e0\2\2\u0613\u0614\7k\2\2\u0614\u0619"+
		"\5\u01a4\u00d3\2\u0615\u0616\7\u0153\2\2\u0616\u0618\5\u01a4\u00d3\2\u0617"+
		"\u0615\3\2\2\2\u0618\u061b\3\2\2\2\u0619\u0617\3\2\2\2\u0619\u061a\3\2"+
		"\2\2\u061a\u0629\3\2\2\2\u061b\u0619\3\2\2\2\u061c\u061d\7\7\2\2\u061d"+
		"\u061e\7l\2\2\u061e\u061f\7<\2\2\u061f\u0620\7j\2\2\u0620\u0625\5\u00a2"+
		"R\2\u0621\u0622\7\u0153\2\2\u0622\u0624\5\u00a2R\2\u0623\u0621\3\2\2\2"+
		"\u0624\u0627\3\2\2\2\u0625\u0623\3\2\2\2\u0625\u0626\3\2\2\2\u0626\u0629"+
		"\3\2\2\2\u0627\u0625\3\2\2\2\u0628\u0613\3\2\2\2\u0628\u061c\3\2\2\2\u0629"+
		"\u062a\3\2\2\2\u062a\u062b\5\64\33\2\u062b\u0721\3\2\2\2\u062c\u0630\7"+
		"g\2\2\u062d\u062e\7\64\2\2\u062e\u062f\7\u00e2\2\2\u062f\u0631\7-\2\2"+
		"\u0630\u062d\3\2\2\2\u0630\u0631\3\2\2\2\u0631\u063b\3\2\2\2\u0632\u0634"+
		"\t\n\2\2\u0633\u0632\3\2\2\2\u0634\u0635\3\2\2\2\u0635\u0633\3\2\2\2\u0635"+
		"\u0636\3\2\2\2\u0636\u063c\3\2\2\2\u0637\u0639\7\7\2\2\u0638\u063a\7]"+
		"\2\2\u0639\u0638\3\2\2\2\u0639\u063a\3\2\2\2\u063a\u063c\3\2\2\2\u063b"+
		"\u0633\3\2\2\2\u063b\u0637\3\2\2\2\u063c\u063d\3\2\2\2\u063d\u063e\7\u00e0"+
		"\2\2\u063e\u063f\7\33\2\2\u063f\u0644\5\u00a2R\2\u0640\u0641\7\u0153\2"+
		"\2\u0641\u0643\5\u00a2R\2\u0642\u0640\3\2\2\2\u0643\u0646\3\2\2\2\u0644"+
		"\u0642\3\2\2\2\u0644\u0645\3\2\2\2\u0645\u0647\3\2\2\2\u0646\u0644\3\2"+
		"\2\2\u0647\u0648\5\64\33\2\u0648\u0721\3\2\2\2\u0649\u064d\7g\2\2\u064a"+
		"\u064b\7\64\2\2\u064b\u064c\7\u00e2\2\2\u064c\u064e\7-\2\2\u064d\u064a"+
		"\3\2\2\2\u064d\u064e\3\2\2\2\u064e\u0654\3\2\2\2\u064f\u0655\7\u0080\2"+
		"\2\u0650\u0652\7\7\2\2\u0651\u0653\7]\2\2\u0652\u0651\3\2\2\2\u0652\u0653"+
		"\3\2\2\2\u0653\u0655\3\2\2\2\u0654\u064f\3\2\2\2\u0654\u0650\3\2\2\2\u0655"+
		"\u0656\3\2\2\2\u0656\u0657\7\u00e0\2\2\u0657\u0658\7.\2\2\u0658\u0659"+
		"\7\u00a3\2\2\u0659\u065a\7\u011f\2\2\u065a\u065f\5\u01a4\u00d3\2\u065b"+
		"\u065c\7\u0153\2\2\u065c\u065e\5\u01a4\u00d3\2\u065d\u065b\3\2\2\2\u065e"+
		"\u0661\3\2\2\2\u065f\u065d\3\2\2\2\u065f\u0660\3\2\2\2\u0660\u0662\3\2"+
		"\2\2\u0661\u065f\3\2\2\2\u0662\u0663\5\64\33\2\u0663\u0721\3\2\2\2\u0664"+
		"\u0668\7g\2\2\u0665\u0666\7\64\2\2\u0666\u0667\7\u00e2\2\2\u0667\u0669"+
		"\7-\2\2\u0668\u0665\3\2\2\2\u0668\u0669\3\2\2\2\u0669\u066f\3\2\2\2\u066a"+
		"\u0670\7\u0080\2\2\u066b\u066d\7\7\2\2\u066c\u066e\7]\2\2\u066d\u066c"+
		"\3\2\2\2\u066d\u066e\3\2\2\2\u066e\u0670\3\2\2\2\u066f\u066a\3\2\2\2\u066f"+
		"\u066b\3\2\2\2\u0670\u0671\3\2\2\2\u0671\u0672\7\u00e0\2\2\u0672\u0673"+
		"\7.\2\2\u0673\u0674\7\u00fb\2\2\u0674\u0679\5\u00a2R\2\u0675\u0676\7\u0153"+
		"\2\2\u0676\u0678\5\u00a2R\2\u0677\u0675\3\2\2\2\u0678\u067b\3\2\2\2\u0679"+
		"\u0677\3\2\2\2\u0679\u067a\3\2\2\2\u067a\u067c\3\2\2\2\u067b\u0679\3\2"+
		"\2\2\u067c\u067d\5\64\33\2\u067d\u0721\3\2\2\2\u067e\u0682\7g\2\2\u067f"+
		"\u0680\7\64\2\2\u0680\u0681\7\u00e2\2\2\u0681\u0683\7-\2\2\u0682\u067f"+
		"\3\2\2\2\u0682\u0683\3\2\2\2\u0683\u0689\3\2\2\2\u0684\u068a\7*\2\2\u0685"+
		"\u0687\7\7\2\2\u0686\u0688\7]\2\2\u0687\u0686\3\2\2\2\u0687\u0688\3\2"+
		"\2\2\u0688\u068a\3\2\2\2\u0689\u0684\3\2\2\2\u0689\u0685\3\2\2\2\u068a"+
		"\u068b\3\2\2\2\u068b\u068e\7\u00e0\2\2\u068c\u068f\5L\'\2\u068d\u068f"+
		"\5N(\2\u068e\u068c\3\2\2\2\u068e\u068d\3\2\2\2\u068f\u0690\3\2\2\2\u0690"+
		"\u0691\5\64\33\2\u0691\u0721\3\2\2\2\u0692\u0696\7g\2\2\u0693\u0694\7"+
		"\64\2\2\u0694\u0695\7\u00e2\2\2\u0695\u0697\7-\2\2\u0696\u0693\3\2\2\2"+
		"\u0696\u0697\3\2\2\2\u0697\u069d\3\2\2\2\u0698\u069e\7\u0080\2\2\u0699"+
		"\u069b\7\7\2\2\u069a\u069c\7]\2\2\u069b\u069a\3\2\2\2\u069b\u069c\3\2"+
		"\2\2\u069c\u069e\3\2\2\2\u069d\u0698\3\2\2\2\u069d\u0699\3\2\2\2\u069e"+
		"\u069f\3\2\2\2\u069f\u06a0\7\u00e0\2\2\u06a0\u06a1\7\u00c8\2\2\u06a1\u06a6"+
		"\5\u00a2R\2\u06a2\u06a3\7\u0153\2\2\u06a3\u06a5\5\u00a2R\2\u06a4\u06a2"+
		"\3\2\2\2\u06a5\u06a8\3\2\2\2\u06a6\u06a4\3\2\2\2\u06a6\u06a7\3\2\2\2\u06a7"+
		"\u06a9\3\2\2\2\u06a8\u06a6\3\2\2\2\u06a9\u06aa\5\64\33\2\u06aa\u0721\3"+
		"\2\2\2\u06ab\u06af\7g\2\2\u06ac\u06ad\7\64\2\2\u06ad\u06ae\7\u00e2\2\2"+
		"\u06ae\u06b0\7-\2\2\u06af\u06ac\3\2\2\2\u06af\u06b0\3\2\2\2\u06b0\u06be"+
		"\3\2\2\2\u06b1\u06b7\7m\2\2\u06b2\u06b4\7\177\2\2\u06b3\u06b5\7\u0153"+
		"\2\2\u06b4\u06b3\3\2\2\2\u06b4\u06b5\3\2\2\2\u06b5\u06b7\3\2\2\2\u06b6"+
		"\u06b1\3\2\2\2\u06b6\u06b2\3\2\2\2\u06b7\u06b8\3\2\2\2\u06b8\u06b6\3\2"+
		"\2\2\u06b8\u06b9\3\2\2\2\u06b9\u06bf\3\2\2\2\u06ba\u06bc\7\7\2\2\u06bb"+
		"\u06bd\7]\2\2\u06bc\u06bb\3\2\2\2\u06bc\u06bd\3\2\2\2\u06bd\u06bf\3\2"+
		"\2\2\u06be\u06b6\3\2\2\2\u06be\u06ba\3\2\2\2\u06bf\u06c0\3\2\2\2\u06c0"+
		"\u06c1\7\u00e0\2\2\u06c1\u06c2\7\u00c9\2\2\u06c2\u06c3\7\u00df\2\2\u06c3"+
		"\u06c8\5\u00a2R\2\u06c4\u06c5\7\u0153\2\2\u06c5\u06c7\5\u00a2R\2\u06c6"+
		"\u06c4\3\2\2\2\u06c7\u06ca\3\2\2\2\u06c8\u06c6\3\2\2\2\u06c8\u06c9\3\2"+
		"\2\2\u06c9\u06cb\3\2\2\2\u06ca\u06c8\3\2\2\2\u06cb\u06cc\5\64\33\2\u06cc"+
		"\u0721\3\2\2\2\u06cd\u06d1\7g\2\2\u06ce\u06cf\7\64\2\2\u06cf\u06d0\7\u00e2"+
		"\2\2\u06d0\u06d2\7-\2\2\u06d1\u06ce\3\2\2\2\u06d1\u06d2\3\2\2\2\u06d2"+
		"\u06df\3\2\2\2\u06d3\u06d5\t\13\2\2\u06d4\u06d6\7\u0153\2\2\u06d5\u06d4"+
		"\3\2\2\2\u06d5\u06d6\3\2\2\2\u06d6\u06d8\3\2\2\2\u06d7\u06d3\3\2\2\2\u06d8"+
		"\u06d9\3\2\2\2\u06d9\u06d7\3\2\2\2\u06d9\u06da\3\2\2\2\u06da\u06e0\3\2"+
		"\2\2\u06db\u06dd\7\7\2\2\u06dc\u06de\7]\2\2\u06dd\u06dc\3\2\2\2\u06dd"+
		"\u06de\3\2\2\2\u06de\u06e0\3\2\2\2\u06df\u06d7\3\2\2\2\u06df\u06db\3\2"+
		"\2\2\u06e0\u06e1\3\2\2\2\u06e1\u06e2\7\u00e0\2\2\u06e2\u06e3\7j\2\2\u06e3"+
		"\u06e8\5\u00a2R\2\u06e4\u06e5\7\u0153\2\2\u06e5\u06e7\5\u00a2R\2\u06e6"+
		"\u06e4\3\2\2\2\u06e7\u06ea\3\2\2\2\u06e8\u06e6\3\2\2\2\u06e8\u06e9\3\2"+
		"\2\2\u06e9\u06eb\3\2\2\2\u06ea\u06e8\3\2\2\2\u06eb\u06ec\5\64\33\2\u06ec"+
		"\u0721\3\2\2\2\u06ed\u06f1\7g\2\2\u06ee\u06ef\7\64\2\2\u06ef\u06f0\7\u00e2"+
		"\2\2\u06f0\u06f2\7-\2\2\u06f1\u06ee\3\2\2\2\u06f1\u06f2\3\2\2\2\u06f2"+
		"\u06f8\3\2\2\2\u06f3\u06f9\7\31\2\2\u06f4\u06f6\7\7\2\2\u06f5\u06f7\7"+
		"]\2\2\u06f6\u06f5\3\2\2\2\u06f6\u06f7\3\2\2\2\u06f7\u06f9\3\2\2\2\u06f8"+
		"\u06f3\3\2\2\2\u06f8\u06f4\3\2\2\2\u06f9\u06fa\3\2\2\2\u06fa\u06fb\7\u00e0"+
		"\2\2\u06fb\u06fc\7\u0107\2\2\u06fc\u0701\5\u00a2R\2\u06fd\u06fe\7\u0153"+
		"\2\2\u06fe\u0700\5\u00a2R\2\u06ff\u06fd\3\2\2\2\u0700\u0703\3\2\2\2\u0701"+
		"\u06ff\3\2\2\2\u0701\u0702\3\2\2\2\u0702\u0704\3\2\2\2\u0703\u0701\3\2"+
		"\2\2\u0704\u0705\5\64\33\2\u0705\u0721\3\2\2\2\u0706\u070a\7g\2\2\u0707"+
		"\u0708\7\u0089\2\2\u0708\u0709\7\u00e2\2\2\u0709\u070b\7-\2\2\u070a\u0707"+
		"\3\2\2\2\u070a\u070b\3\2\2\2\u070b\u070c\3\2\2\2\u070c\u0711\5\u00a2R"+
		"\2\u070d\u070e\7\u0153\2\2\u070e\u0710\5\u00a2R\2\u070f\u070d\3\2\2\2"+
		"\u0710\u0713\3\2\2\2\u0711\u070f\3\2\2\2\u0711\u0712\3\2\2\2\u0712\u0714"+
		"\3\2\2\2\u0713\u0711\3\2\2\2\u0714\u0715\7\62\2\2\u0715\u071a\5\u00a2"+
		"R\2\u0716\u0717\7\u0153\2\2\u0717\u0719\5\u00a2R\2\u0718\u0716\3\2\2\2"+
		"\u0719\u071c\3\2\2\2\u071a\u0718\3\2\2\2\u071a\u071b\3\2\2\2\u071b\u071e"+
		"\3\2\2\2\u071c\u071a\3\2\2\2\u071d\u071f\t\2\2\2\u071e\u071d\3\2\2\2\u071e"+
		"\u071f\3\2\2\2\u071f\u0721\3\2\2\2\u0720\u05a2\3\2\2\2\u0720\u05cc\3\2"+
		"\2\2\u0720\u0601\3\2\2\2\u0720\u062c\3\2\2\2\u0720\u0649\3\2\2\2\u0720"+
		"\u0664\3\2\2\2\u0720\u067e\3\2\2\2\u0720\u0692\3\2\2\2\u0720\u06ab\3\2"+
		"\2\2\u0720\u06cd\3\2\2\2\u0720\u06ed\3\2\2\2\u0720\u0706\3\2\2\2\u0721"+
		"\63\3\2\2\2\u0722\u0728\7\62\2\2\u0723\u0725\7\65\2\2\u0724\u0723\3\2"+
		"\2\2\u0724\u0725\3\2\2\2\u0725\u0726\3\2\2\2\u0726\u0729\5\u00a2R\2\u0727"+
		"\u0729\7\u00ec\2\2\u0728\u0724\3\2\2\2\u0728\u0727\3\2\2\2\u0729\u0734"+
		"\3\2\2\2\u072a\u0730\7\u0153\2\2\u072b\u072d\7\65\2\2\u072c\u072b\3\2"+
		"\2\2\u072c\u072d\3\2\2\2\u072d\u072e\3\2\2\2\u072e\u0731\5\u00a2R\2\u072f"+
		"\u0731\7\u00ec\2\2\u0730\u072c\3\2\2\2\u0730\u072f\3\2\2\2\u0731\u0733"+
		"\3\2\2\2\u0732\u072a\3\2\2\2\u0733\u0736\3\2\2\2\u0734\u0732\3\2\2\2\u0734"+
		"\u0735\3\2\2\2\u0735\u0738\3\2\2\2\u0736\u0734\3\2\2\2\u0737\u0739\t\2"+
		"\2\2\u0738\u0737\3\2\2\2\u0738\u0739\3\2\2\2\u0739\65\3\2\2\2\u073a\u0747"+
		"\7\64\2\2\u073b\u0740\t\5\2\2\u073c\u073d\7\u0153\2\2\u073d\u073f\t\5"+
		"\2\2\u073e\u073c\3\2\2\2\u073f\u0742\3\2\2\2\u0740\u073e\3\2\2\2\u0740"+
		"\u0741\3\2\2\2\u0741\u0748\3\2\2\2\u0742\u0740\3\2\2\2\u0743\u0745\7\7"+
		"\2\2\u0744\u0746\7]\2\2\u0745\u0744\3\2\2\2\u0745\u0746\3\2\2\2\u0746"+
		"\u0748\3\2\2\2\u0747\u073b\3\2\2\2\u0747\u0743\3\2\2\2\u0748\u0749\3\2"+
		"\2\2\u0749\u0761\7\u00e0\2\2\u074a\u074c\7t\2\2\u074b\u074a\3\2\2\2\u074b"+
		"\u074c\3\2\2\2\u074c\u0751\3\2\2\2\u074d\u074f\5\u01a4\u00d3\2\u074e\u0750"+
		"\7\u0153\2\2\u074f\u074e\3\2\2\2\u074f\u0750\3\2\2\2\u0750\u0752\3\2\2"+
		"\2\u0751\u074d\3\2\2\2\u0752\u0753\3\2\2\2\u0753\u0751\3\2\2\2\u0753\u0754"+
		"\3\2\2\2\u0754\u0762\3\2\2\2\u0755\u0756\7\7\2\2\u0756\u0757\7\u0108\2"+
		"\2\u0757\u0758\7<\2\2\u0758\u075d\7j\2\2\u0759\u075b\5\u00a2R\2\u075a"+
		"\u075c\7\u0153\2\2\u075b\u075a\3\2\2\2\u075b\u075c\3\2\2\2\u075c\u075e"+
		"\3\2\2\2\u075d\u0759\3\2\2\2\u075e\u075f\3\2\2\2\u075f\u075d\3\2\2\2\u075f"+
		"\u0760\3\2\2\2\u0760\u0762\3\2\2\2\u0761\u074b\3\2\2\2\u0761\u0755\3\2"+
		"\2\2\u0762\u0763\3\2\2\2\u0763\u0764\58\35\2\u0764\u0887\3\2\2\2\u0765"+
		"\u077f\7\64\2\2\u0766\u0767\t\t\2\2\u0767\u076c\5\u00a2R\2\u0768\u0769"+
		"\7\u0153\2\2\u0769\u076b\5\u00a2R\2\u076a\u0768\3\2\2\2\u076b\u076e\3"+
		"\2\2\2\u076c\u076a\3\2\2\2\u076c\u076d\3\2\2\2\u076d\u0770\3\2\2\2\u076e"+
		"\u076c\3\2\2\2\u076f\u0766\3\2\2\2\u0770\u0771\3\2\2\2\u0771\u076f\3\2"+
		"\2\2\u0771\u0772\3\2\2\2\u0772\u0780\3\2\2\2\u0773\u0775\7\7\2\2\u0774"+
		"\u0776\7]\2\2\u0775\u0774\3\2\2\2\u0775\u0776\3\2\2\2\u0776\u0777\3\2"+
		"\2\2\u0777\u077c\5\u00a2R\2\u0778\u0779\7\u0153\2\2\u0779\u077b\5\u00a2"+
		"R\2\u077a\u0778\3\2\2\2\u077b\u077e\3\2\2\2\u077c\u077a\3\2\2\2\u077c"+
		"\u077d\3\2\2\2\u077d\u0780\3\2\2\2\u077e\u077c\3\2\2\2\u077f\u076f\3\2"+
		"\2\2\u077f\u0773\3\2\2\2\u0780\u0781\3\2\2\2\u0781\u0789\7\u00e0\2\2\u0782"+
		"\u0784\7t\2\2\u0783\u0782\3\2\2\2\u0783\u0784\3\2\2\2\u0784\u0785\3\2"+
		"\2\2\u0785\u0787\5\u01a4\u00d3\2";
	private static final String _serializedATNSegment1 =
		"\u0786\u0788\7\u0153\2\2\u0787\u0786\3\2\2\2\u0787\u0788\3\2\2\2\u0788"+
		"\u078a\3\2\2\2\u0789\u0783\3\2\2\2\u078a\u078b\3\2\2\2\u078b\u0789\3\2"+
		"\2\2\u078b\u078c\3\2\2\2\u078c\u078d\3\2\2\2\u078d\u078e\58\35\2\u078e"+
		"\u0887\3\2\2\2\u078f\u079c\7\64\2\2\u0790\u0795\t\6\2\2\u0791\u0792\7"+
		"\u0153\2\2\u0792\u0794\t\6\2\2\u0793\u0791\3\2\2\2\u0794\u0797\3\2\2\2"+
		"\u0795\u0793\3\2\2\2\u0795\u0796\3\2\2\2\u0796\u079d\3\2\2\2\u0797\u0795"+
		"\3\2\2\2\u0798\u079a\7\7\2\2\u0799\u079b\7]\2\2\u079a\u0799\3\2\2\2\u079a"+
		"\u079b\3\2\2\2\u079b\u079d\3\2\2\2\u079c\u0790\3\2\2\2\u079c\u0798\3\2"+
		"\2\2\u079d\u079e\3\2\2\2\u079e\u07b8\7\u00e0\2\2\u079f\u07a0\7k\2\2\u07a0"+
		"\u07a5\5\u00a2R\2\u07a1\u07a2\7\u0153\2\2\u07a2\u07a4\5\u00a2R\2\u07a3"+
		"\u07a1\3\2\2\2\u07a4\u07a7\3\2\2\2\u07a5\u07a3\3\2\2\2\u07a5\u07a6\3\2"+
		"\2\2\u07a6\u07a9\3\2\2\2\u07a7\u07a5\3\2\2\2\u07a8\u079f\3\2\2\2\u07a9"+
		"\u07aa\3\2\2\2\u07aa\u07a8\3\2\2\2\u07aa\u07ab\3\2\2\2\u07ab\u07b9\3\2"+
		"\2\2\u07ac\u07ad\7\7\2\2\u07ad\u07ae\7l\2\2\u07ae\u07af\7<\2\2\u07af\u07b0"+
		"\7j\2\2\u07b0\u07b5\5\u00a2R\2\u07b1\u07b2\7\u0153\2\2\u07b2\u07b4\5\u00a2"+
		"R\2\u07b3\u07b1\3\2\2\2\u07b4\u07b7\3\2\2\2\u07b5\u07b3\3\2\2\2\u07b5"+
		"\u07b6\3\2\2\2\u07b6\u07b9\3\2\2\2\u07b7\u07b5\3\2\2\2\u07b8\u07a8\3\2"+
		"\2\2\u07b8\u07ac\3\2\2\2\u07b9\u07ba\3\2\2\2\u07ba\u07bb\58\35\2\u07bb"+
		"\u0887\3\2\2\2\u07bc\u07c9\7\64\2\2\u07bd\u07c2\t\n\2\2\u07be\u07bf\7"+
		"\u0153\2\2\u07bf\u07c1\t\n\2\2\u07c0\u07be\3\2\2\2\u07c1\u07c4\3\2\2\2"+
		"\u07c2\u07c0\3\2\2\2\u07c2\u07c3\3\2\2\2\u07c3\u07ca\3\2\2\2\u07c4\u07c2"+
		"\3\2\2\2\u07c5\u07c7\7\7\2\2\u07c6\u07c8\7]\2\2\u07c7\u07c6\3\2\2\2\u07c7"+
		"\u07c8\3\2\2\2\u07c8\u07ca\3\2\2\2\u07c9\u07bd\3\2\2\2\u07c9\u07c5\3\2"+
		"\2\2\u07ca\u07cb\3\2\2\2\u07cb\u07cc\7\u00e0\2\2\u07cc\u07cd\7\33\2\2"+
		"\u07cd\u07d2\5\u00a2R\2\u07ce\u07cf\7\u0153\2\2\u07cf\u07d1\5\u00a2R\2"+
		"\u07d0\u07ce\3\2\2\2\u07d1\u07d4\3\2\2\2\u07d2\u07d0\3\2\2\2\u07d2\u07d3"+
		"\3\2\2\2\u07d3\u07d5\3\2\2\2\u07d4\u07d2\3\2\2\2\u07d5\u07d6\58\35\2\u07d6"+
		"\u0887\3\2\2\2\u07d7\u07dd\7\64\2\2\u07d8\u07de\7\u0080\2\2\u07d9\u07db"+
		"\7\7\2\2\u07da\u07dc\7]\2\2\u07db\u07da\3\2\2\2\u07db\u07dc\3\2\2\2\u07dc"+
		"\u07de\3\2\2\2\u07dd\u07d8\3\2\2\2\u07dd\u07d9\3\2\2\2\u07de\u07df\3\2"+
		"\2\2\u07df\u07e0\7\u00e0\2\2\u07e0\u07e1\7.\2\2\u07e1\u07e2\7\u00a3\2"+
		"\2\u07e2\u07e3\7\u011f\2\2\u07e3\u07e8\5\u00a2R\2\u07e4\u07e5\7\u0153"+
		"\2\2\u07e5\u07e7\5\u00a2R\2\u07e6\u07e4\3\2\2\2\u07e7\u07ea\3\2\2\2\u07e8"+
		"\u07e6\3\2\2\2\u07e8\u07e9\3\2\2\2\u07e9\u07eb\3\2\2\2\u07ea\u07e8\3\2"+
		"\2\2\u07eb\u07ec\58\35\2\u07ec\u0887\3\2\2\2\u07ed\u07f3\7\64\2\2\u07ee"+
		"\u07f4\7\u0080\2\2\u07ef\u07f1\7\7\2\2\u07f0\u07f2\7]\2\2\u07f1\u07f0"+
		"\3\2\2\2\u07f1\u07f2\3\2\2\2\u07f2\u07f4\3\2\2\2\u07f3\u07ee\3\2\2\2\u07f3"+
		"\u07ef\3\2\2\2\u07f4\u07f5\3\2\2\2\u07f5\u07f6\7\u00e0\2\2\u07f6\u07f7"+
		"\7.\2\2\u07f7\u07f8\7\u00fb\2\2\u07f8\u07fd\5\u00a2R\2\u07f9\u07fa\7\u0153"+
		"\2\2\u07fa\u07fc\5\u00a2R\2\u07fb\u07f9\3\2\2\2\u07fc\u07ff\3\2\2\2\u07fd"+
		"\u07fb\3\2\2\2\u07fd\u07fe\3\2\2\2\u07fe\u0800\3\2\2\2\u07ff\u07fd\3\2"+
		"\2\2\u0800\u0801\58\35\2\u0801\u0887\3\2\2\2\u0802\u0808\7\64\2\2\u0803"+
		"\u0809\7*\2\2\u0804\u0806\7\7\2\2\u0805\u0807\7]\2\2\u0806\u0805\3\2\2"+
		"\2\u0806\u0807\3\2\2\2\u0807\u0809\3\2\2\2\u0808\u0803\3\2\2\2\u0808\u0804"+
		"\3\2\2\2\u0809\u080a\3\2\2\2\u080a\u080d\7\u00e0\2\2\u080b\u080e\5L\'"+
		"\2\u080c\u080e\5N(\2\u080d\u080b\3\2\2\2\u080d\u080c\3\2\2\2\u080e\u080f"+
		"\3\2\2\2\u080f\u0810\58\35\2\u0810\u0887\3\2\2\2\u0811\u0817\7\64\2\2"+
		"\u0812\u0818\7\u0080\2\2\u0813\u0815\7\7\2\2\u0814\u0816\7]\2\2\u0815"+
		"\u0814\3\2\2\2\u0815\u0816\3\2\2\2\u0816\u0818\3\2\2\2\u0817\u0812\3\2"+
		"\2\2\u0817\u0813\3\2\2\2\u0818\u0819\3\2\2\2\u0819\u081a\7\u00e0\2\2\u081a"+
		"\u081b\7\u00c8\2\2\u081b\u0820\5\u00a2R\2\u081c\u081d\7\u0153\2\2\u081d"+
		"\u081f\5\u00a2R\2\u081e\u081c\3\2\2\2\u081f\u0822\3\2\2\2\u0820\u081e"+
		"\3\2\2\2\u0820\u0821\3\2\2\2\u0821\u0823\3\2\2\2\u0822\u0820\3\2\2\2\u0823"+
		"\u0824\58\35\2\u0824\u0887\3\2\2\2\u0825\u0832\7\64\2\2\u0826\u0828\t"+
		"\f\2\2\u0827\u0829\7\u0153\2\2\u0828\u0827\3\2\2\2\u0828\u0829\3\2\2\2"+
		"\u0829\u082b\3\2\2\2\u082a\u0826\3\2\2\2\u082b\u082c\3\2\2\2\u082c\u082a"+
		"\3\2\2\2\u082c\u082d\3\2\2\2\u082d\u0833\3\2\2\2\u082e\u0830\7\7\2\2\u082f"+
		"\u0831\7]\2\2\u0830\u082f\3\2\2\2\u0830\u0831\3\2\2\2\u0831\u0833\3\2"+
		"\2\2\u0832\u082a\3\2\2\2\u0832\u082e\3\2\2\2\u0833\u0834\3\2\2\2\u0834"+
		"\u0835\7\u00e0\2\2\u0835\u0836\7\u00c9\2\2\u0836\u0837\7\u00df\2\2\u0837"+
		"\u083c\5\u00a2R\2\u0838\u0839\7\u0153\2\2\u0839\u083b\5\u00a2R\2\u083a"+
		"\u0838\3\2\2\2\u083b\u083e\3\2\2\2\u083c\u083a\3\2\2\2\u083c\u083d\3\2"+
		"\2\2\u083d\u083f\3\2\2\2\u083e\u083c\3\2\2\2\u083f\u0840\58\35\2\u0840"+
		"\u0887\3\2\2\2\u0841\u084e\7\64\2\2\u0842\u0844\t\13\2\2\u0843\u0845\7"+
		"\u0153\2\2\u0844\u0843\3\2\2\2\u0844\u0845\3\2\2\2\u0845\u0847\3\2\2\2"+
		"\u0846\u0842\3\2\2\2\u0847\u0848\3\2\2\2\u0848\u0846\3\2\2\2\u0848\u0849"+
		"\3\2\2\2\u0849\u084f\3\2\2\2\u084a\u084c\7\7\2\2\u084b\u084d\7]\2\2\u084c"+
		"\u084b\3\2\2\2\u084c\u084d\3\2\2\2\u084d\u084f\3\2\2\2\u084e\u0846\3\2"+
		"\2\2\u084e\u084a\3\2\2\2\u084f\u0850\3\2\2\2\u0850\u0851\7\u00e0\2\2\u0851"+
		"\u0852\7j\2\2\u0852\u0857\5\u00a2R\2\u0853\u0854\7\u0153\2\2\u0854\u0856"+
		"\5\u00a2R\2\u0855\u0853\3\2\2\2\u0856\u0859\3\2\2\2\u0857\u0855\3\2\2"+
		"\2\u0857\u0858\3\2\2\2\u0858\u085a\3\2\2\2\u0859\u0857\3\2\2\2\u085a\u085b"+
		"\58\35\2\u085b\u0887\3\2\2\2\u085c\u0862\7\64\2\2\u085d\u0863\7\31\2\2"+
		"\u085e\u0860\7\7\2\2\u085f\u0861\7]\2\2\u0860\u085f\3\2\2\2\u0860\u0861"+
		"\3\2\2\2\u0861\u0863\3\2\2\2\u0862\u085d\3\2\2\2\u0862\u085e\3\2\2\2\u0863"+
		"\u0864\3\2\2\2\u0864\u0865\7\u00e0\2\2\u0865\u0866\7\u0107\2\2\u0866\u086b"+
		"\5\u00a2R\2\u0867\u0868\7\u0153\2\2\u0868\u086a\5\u00a2R\2\u0869\u0867"+
		"\3\2\2\2\u086a\u086d\3\2\2\2\u086b\u0869\3\2\2\2\u086b\u086c\3\2\2\2\u086c"+
		"\u086e\3\2\2\2\u086d\u086b\3\2\2\2\u086e\u086f\58\35\2\u086f\u0870\7\64"+
		"\2\2\u0870\u0875\5\u00a2R\2\u0871\u0872\7\u0153\2\2\u0872\u0874\5\u00a2"+
		"R\2\u0873\u0871\3\2\2\2\u0874\u0877\3\2\2\2\u0875\u0873\3\2\2\2\u0875"+
		"\u0876\3\2\2\2\u0876\u0878\3\2\2\2\u0877\u0875\3\2\2\2\u0878\u0879\7\u010f"+
		"\2\2\u0879\u087e\5\u00a2R\2\u087a\u087b\7\u0153\2\2\u087b\u087d\5\u00a2"+
		"R\2\u087c\u087a\3\2\2\2\u087d\u0880\3\2\2\2\u087e\u087c\3\2\2\2\u087e"+
		"\u087f\3\2\2\2\u087f\u0884\3\2\2\2\u0880\u087e\3\2\2\2\u0881\u0882\7\u0087"+
		"\2\2\u0882\u0883\7\u0089\2\2\u0883\u0885\7\u00e2\2\2\u0884\u0881\3\2\2"+
		"\2\u0884\u0885\3\2\2\2\u0885\u0887\3\2\2\2\u0886\u073a\3\2\2\2\u0886\u0765"+
		"\3\2\2\2\u0886\u078f\3\2\2\2\u0886\u07bc\3\2\2\2\u0886\u07d7\3\2\2\2\u0886"+
		"\u07ed\3\2\2\2\u0886\u0802\3\2\2\2\u0886\u0811\3\2\2\2\u0886\u0825\3\2"+
		"\2\2\u0886\u0841\3\2\2\2\u0886\u085c\3\2\2\2\u0887\67\3\2\2\2\u0888\u088e"+
		"\7\u010f\2\2\u0889\u088b\7\65\2\2\u088a\u0889\3\2\2\2\u088a\u088b\3\2"+
		"\2\2\u088b\u088c\3\2\2\2\u088c\u088f\5\u00a2R\2\u088d\u088f\7\u00ec\2"+
		"\2\u088e\u088a\3\2\2\2\u088e\u088d\3\2\2\2\u088f\u089a\3\2\2\2\u0890\u0896"+
		"\7\u0153\2\2\u0891\u0893\7\65\2\2\u0892\u0891\3\2\2\2\u0892\u0893\3\2"+
		"\2\2\u0893\u0894\3\2\2\2\u0894\u0897\5\u00a2R\2\u0895\u0897\7\u00ec\2"+
		"\2\u0896\u0892\3\2\2\2\u0896\u0895\3\2\2\2\u0897\u0899\3\2\2\2\u0898\u0890"+
		"\3\2\2\2\u0899\u089c\3\2\2\2\u089a\u0898\3\2\2\2\u089a\u089b\3\2\2\2\u089b"+
		"\u08a0\3\2\2\2\u089c\u089a\3\2\2\2\u089d\u089e\7\u0087\2\2\u089e\u089f"+
		"\7\64\2\2\u089f\u08a1\7\u00e2\2\2\u08a0\u089d\3\2\2\2\u08a0\u08a1\3\2"+
		"\2\2\u08a19\3\2\2\2\u08a2\u08a3\7\u0099\2\2\u08a3\u091b\7\u00e0\2\2\u08a4"+
		"\u08a5\7\4\2\2\u08a5\u08a6\5\u01a4\u00d3\2\u08a6\u08af\7\u015a\2\2\u08a7"+
		"\u08ac\5\u00b4[\2\u08a8\u08a9\7\u0153\2\2\u08a9\u08ab\5\u00b4[\2\u08aa"+
		"\u08a8\3\2\2\2\u08ab\u08ae\3\2\2\2\u08ac\u08aa\3\2\2\2\u08ac\u08ad\3\2"+
		"\2\2\u08ad\u08b0\3\2\2\2\u08ae\u08ac\3\2\2\2\u08af\u08a7\3\2\2\2\u08af"+
		"\u08b0\3\2\2\2\u08b0\u08b1\3\2\2\2\u08b1\u08b2\7\u015b\2\2\u08b2\u091c"+
		"\3\2\2\2\u08b3\u08b4\7\22\2\2\u08b4\u08b5\7\u015a\2\2\u08b5\u08b6\5\u00b4"+
		"[\2\u08b6\u08b7\7\6\2\2\u08b7\u08b8\5\u00b4[\2\u08b8\u08b9\7\u015b\2\2"+
		"\u08b9\u091c\3\2\2\2\u08ba\u08bb\7\24\2\2\u08bb\u091c\5\u01a4\u00d3\2"+
		"\u08bc\u08bd\7\u0098\2\2\u08bd\u091c\5\u01a4\u00d3\2\u08be\u08bf\7\26"+
		"\2\2\u08bf\u08c0\5\u01a4\u00d3\2\u08c0\u08c1\7\u00e0\2\2\u08c1\u08c2\5"+
		"\u01a4\u00d3\2\u08c2\u091c\3\2\2\2\u08c3\u08c4\7\30\2\2\u08c4\u091c\5"+
		"\u01a4\u00d3\2\u08c5\u08c6\7\33\2\2\u08c6\u091c\5\u01a4\u00d3\2\u08c7"+
		"\u08c8\7#\2\2\u08c8\u091c\5\u01a4\u00d3\2\u08c9\u08ca\7+\2\2\u08ca\u091c"+
		"\5\u01a4\u00d3\2\u08cb\u08cc\7.\2\2\u08cc\u08cd\7\u00a3\2\2\u08cd\u08ce"+
		"\7\u011f\2\2\u08ce\u091c\5\u01a4\u00d3\2\u08cf\u08d0\7.\2\2\u08d0\u08d1"+
		"\7t\2\2\u08d1\u091c\5\u01a4\u00d3\2\u08d2\u091c\5L\'\2\u08d3\u08d4\7\u00be"+
		"\2\2\u08d4\u091c\5\u01a4\u00d3\2\u08d5\u08d6\7\u00c9\2\2\u08d6\u08d7\7"+
		"\u00df\2\2\u08d7\u091c\5\u00a2R\2\u08d8\u08d9\7V\2\2\u08d9\u08da\5\u01a4"+
		"\u00d3\2\u08da\u08db\7\u015a\2\2\u08db\u08dc\5\u00b4[\2\u08dc\u08dd\7"+
		"\u0153\2\2\u08dd\u08de\5\u00b4[\2\u08de\u08df\7\u015b\2\2\u08df\u091c"+
		"\3\2\2\2\u08e0\u08e1\7V\2\2\u08e1\u08e2\7\u0091\2\2\u08e2\u08e3\5\u01a4"+
		"\u00d3\2\u08e3\u08e4\7\u0081\2\2\u08e4\u08e5\5\u00a2R\2\u08e5\u091c\3"+
		"\2\2\2\u08e6\u08e7\7V\2\2\u08e7\u08e8\7\u00b5\2\2\u08e8\u08e9\5\u01a4"+
		"\u00d3\2\u08e9\u08ea\7\u0081\2\2\u08ea\u08eb\5\u00a2R\2\u08eb\u091c\3"+
		"\2\2\2\u08ec\u08ee\7_\2\2\u08ed\u08ec\3\2\2\2\u08ed\u08ee\3\2\2\2\u08ee"+
		"\u08ef\3\2\2\2\u08ef\u08f0\7\u00c8\2\2\u08f0\u091c\5\u01a4\u00d3\2\u08f1"+
		"\u08f2\7`\2\2\u08f2\u091c\5\u01a4\u00d3\2\u08f3\u08f4\7i\2\2\u08f4\u08f5"+
		"\5\u01a4\u00d3\2\u08f5\u08f6\7\u00e0\2\2\u08f6\u08f7\5\u01a4\u00d3\2\u08f7"+
		"\u091c\3\2\2\2\u08f8\u08f9\7j\2\2\u08f9\u091c\5\u01a4\u00d3\2\u08fa\u08fb"+
		"\7k\2\2\u08fb\u091c\5\u01a4\u00d3\2\u08fc\u08fd\7\u00fb\2\2\u08fd\u091c"+
		"\5\u01a4\u00d3\2\u08fe\u08ff\7t\2\2\u08ff\u091c\5\u01a4\u00d3\2\u0900"+
		"\u0901\7\u0107\2\2\u0901\u091c\5\u01a4\u00d3\2\u0902\u0903\7\u0140\2\2"+
		"\u0903\u0904\7\u00f8\2\2\u0904\u0905\7\u009d\2\2\u0905\u091c\5\u01a4\u00d3"+
		"\2\u0906\u0907\7\u0140\2\2\u0907\u0908\7\u00f8\2\2\u0908\u0909\7\u00a8"+
		"\2\2\u0909\u091c\5\u01a4\u00d3\2\u090a\u090b\7\u0140\2\2\u090b\u090c\7"+
		"\u00f8\2\2\u090c\u090d\7\u00e6\2\2\u090d\u091c\5\u01a4\u00d3\2\u090e\u090f"+
		"\7\u0140\2\2\u090f\u0910\7\u00f8\2\2\u0910\u0911\7\u0109\2\2\u0911\u091c"+
		"\5\u01a4\u00d3\2\u0912\u0913\7z\2\2\u0913\u0914\5\u01a4\u00d3\2\u0914"+
		"\u0915\7\u00e0\2\2\u0915\u0916\5\u01a4\u00d3\2\u0916\u091c\3\2\2\2\u0917"+
		"\u0918\7\u0110\2\2\u0918\u091c\5\u01a4\u00d3\2\u0919\u091a\7\u0084\2\2"+
		"\u091a\u091c\5\u01a4\u00d3\2\u091b\u08a4\3\2\2\2\u091b\u08b3\3\2\2\2\u091b"+
		"\u08ba\3\2\2\2\u091b\u08bc\3\2\2\2\u091b\u08be\3\2\2\2\u091b\u08c3\3\2"+
		"\2\2\u091b\u08c5\3\2\2\2\u091b\u08c7\3\2\2\2\u091b\u08c9\3\2\2\2\u091b"+
		"\u08cb\3\2\2\2\u091b\u08cf\3\2\2\2\u091b\u08d2\3\2\2\2\u091b\u08d3\3\2"+
		"\2\2\u091b\u08d5\3\2\2\2\u091b\u08d8\3\2\2\2\u091b\u08e0\3\2\2\2\u091b"+
		"\u08e6\3\2\2\2\u091b\u08ed\3\2\2\2\u091b\u08f1\3\2\2\2\u091b\u08f3\3\2"+
		"\2\2\u091b\u08f8\3\2\2\2\u091b\u08fa\3\2\2\2\u091b\u08fc\3\2\2\2\u091b"+
		"\u08fe\3\2\2\2\u091b\u0900\3\2\2\2\u091b\u0902\3\2\2\2\u091b\u0906\3\2"+
		"\2\2\u091b\u090a\3\2\2\2\u091b\u090e\3\2\2\2\u091b\u0912\3\2\2\2\u091b"+
		"\u0917\3\2\2\2\u091b\u0919\3\2\2\2\u091c\u091d\3\2\2\2\u091d\u091e\7G"+
		"\2\2\u091e\u091f\7\u0170\2\2\u091f;\3\2\2\2\u0920\u0923\7\31\2\2\u0921"+
		"\u0922\7W\2\2\u0922\u0924\7d\2\2\u0923\u0921\3\2\2\2\u0923\u0924\3\2\2"+
		"\2\u0924\u0925\3\2\2\2\u0925\u0926\7\60\2\2\u0926\u0939\5@!\2\u0927\u092a"+
		"\7f\2\2\u0928\u092b\5\u0104\u0083\2\u0929\u092b\5\u00b4[\2\u092a\u0928"+
		"\3\2\2\2\u092a\u0929\3\2\2\2\u092b\u093a\3\2\2\2\u092c\u092d\7f\2\2\u092d"+
		"\u092e\7t\2\2\u092e\u092f\7\u015a\2\2\u092f\u0934\5> \2\u0930\u0931\7"+
		"\u0153\2\2\u0931\u0933\5> \2\u0932\u0930\3\2\2\2\u0933\u0936\3\2\2\2\u0934"+
		"\u0932\3\2\2\2\u0934\u0935\3\2\2\2\u0935\u0937\3\2\2\2\u0936\u0934\3\2"+
		"\2\2\u0937\u0938\7\u015b\2\2\u0938\u093a\3\2\2\2\u0939\u0927\3\2\2\2\u0939"+
		"\u092c\3\2\2\2\u0939\u093a\3\2\2\2\u093a\u0970\3\2\2\2\u093b\u093c\7\u00c8"+
		"\2\2\u093c\u0971\5\u00a2R\2\u093d\u0971\7\u011e\2\2\u093e\u0971\7;\2\2"+
		"\u093f\u0971\7\u00ff\2\2\u0940\u0971\7\u011c\2\2\u0941\u0942\7\u0090\2"+
		"\2\u0942\u0943\7\u00e0\2\2\u0943\u0944\7Q\2\2\u0944\u0971\7\u00c1\2\2"+
		"\u0945\u0946\7f\2\2\u0946\u0947\7Q\2\2\u0947\u0948\7\u00e0\2\2\u0948\u0949"+
		"\7Q\2\2\u0949\u0971\7\u00c1\2\2\u094a\u0971\7r\2\2\u094b\u094d\7\u00b3"+
		"\2\2\u094c\u094b\3\2\2\2\u094c\u094d\3\2\2\2\u094d\u094e\3\2\2\2\u094e"+
		"\u094f\7\u00fa\2\2\u094f\u0971\7F\2\2\u0950\u0952\7\u00b3\2\2\u0951\u0950"+
		"\3\2\2\2\u0951\u0952\3\2\2\2\u0952\u0953\3\2\2\2\u0953\u0954\7\u00fa\2"+
		"\2\u0954\u0971\7\u00a7\2\2\u0955\u0956\7\u009e\2\2\u0956\u0971\7\u0169"+
		"\2\2\u0957\u0958\7b\2\2\u0958\u0971\7\u0169\2\2\u0959\u095a\7\u00fc\2"+
		"\2\u095a\u0961\5\u00a2R\2\u095b\u095c\7\u010f\2\2\u095c\u0962\5\u00a2"+
		"R\2\u095d\u095e\7\u0150\2\2\u095e\u0962\5\u00a2R\2\u095f\u0960\7\62\2"+
		"\2\u0960\u0962\7\u00a1\2\2\u0961\u095b\3\2\2\2\u0961\u095d\3\2\2\2\u0961"+
		"\u095f\3\2\2\2\u0962\u0967\3\2\2\2\u0963\u0964\7\u0153\2\2\u0964\u0966"+
		"\5\u00a2R\2\u0965\u0963\3\2\2\2\u0966\u0969\3\2\2\2\u0967\u0965\3\2\2"+
		"\2\u0967\u0968\3\2\2\2\u0968\u0971\3\2\2\2\u0969\u0967\3\2\2\2\u096a\u096b"+
		"\7\6\2\2\u096b\u0971\5D#\2\u096c\u096d\7\6\2\2\u096d\u096e\7\u0170\2\2"+
		"\u096e\u096f\7\u0153\2\2\u096f\u0971\7\u0170\2\2\u0970\u093b\3\2\2\2\u0970"+
		"\u093d\3\2\2\2\u0970\u093e\3\2\2\2\u0970\u093f\3\2\2\2\u0970\u0940\3\2"+
		"\2\2\u0970\u0941\3\2\2\2\u0970\u0945\3\2\2\2\u0970\u094a\3\2\2\2\u0970"+
		"\u094c\3\2\2\2\u0970\u0951\3\2\2\2\u0970\u0955\3\2\2\2\u0970\u0957\3\2"+
		"\2\2\u0970\u0959\3\2\2\2\u0970\u096a\3\2\2\2\u0970\u096c\3\2\2\2\u0971"+
		"\u0972\3\2\2\2\u0972\u0970\3\2\2\2\u0972\u0973\3\2\2\2\u0973\u0980\3\2"+
		"\2\2\u0974\u0975\7\u0087\2\2\u0975\u0976\7\u015a\2\2\u0976\u097b\5H%\2"+
		"\u0977\u0978\7\u0153\2\2\u0978\u097a\5H%\2\u0979\u0977\3\2\2\2\u097a\u097d"+
		"\3\2\2\2\u097b\u0979\3\2\2\2\u097b\u097c\3\2\2\2\u097c\u097e\3\2\2\2\u097d"+
		"\u097b\3\2\2\2\u097e\u097f\7\u015b\2\2\u097f\u0981\3\2\2\2\u0980\u0974"+
		"\3\2\2\2\u0980\u0981\3\2\2\2\u0981=\3\2\2\2\u0982\u0983\5\u00a2R\2\u0983"+
		"\u0984\5\u00b4[\2\u0984?\3\2\2\2\u0985\u0986\5\u01a4\u00d3\2\u0986\u0997"+
		"\7\u015a\2\2\u0987\u0989\5F$\2\u0988\u098a\5B\"\2\u0989\u0988\3\2\2\2"+
		"\u0989\u098a\3\2\2\2\u098a\u0992\3\2\2\2\u098b\u098c\7\u0153\2\2\u098c"+
		"\u098e\5F$\2\u098d\u098f\5B\"\2\u098e\u098d\3\2\2\2\u098e\u098f\3\2\2"+
		"\2\u098f\u0991\3\2\2\2\u0990\u098b\3\2\2\2\u0991\u0994\3\2\2\2\u0992\u0990"+
		"\3\2\2\2\u0992\u0993\3\2\2\2\u0993\u0996\3\2\2\2\u0994\u0992\3\2\2\2\u0995"+
		"\u0987\3\2\2\2\u0996\u0999\3\2\2\2\u0997\u0995\3\2\2\2\u0997\u0998\3\2"+
		"\2\2\u0998\u099a\3\2\2\2\u0999\u0997\3\2\2\2\u099a\u099b\7\u015b\2\2\u099b"+
		"A\3\2\2\2\u099c\u099d\t\r\2\2\u099d\u099e\5\u0104\u0083\2\u099eC\3\2\2"+
		"\2\u099f\u09a1\7\u0173\2\2\u09a0\u09a2\7\u0177\2\2\u09a1\u09a0\3\2\2\2"+
		"\u09a2\u09a3\3\2\2\2\u09a3\u09a1\3\2\2\2\u09a3\u09a4\3\2\2\2\u09a4\u09a5"+
		"\3\2\2\2\u09a5\u09a6\7\u0178\2\2\u09a6E\3\2\2\2\u09a7\u09a9\5J&\2\u09a8"+
		"\u09a7\3\2\2\2\u09a8\u09a9\3\2\2\2\u09a9\u09ab\3\2\2\2\u09aa\u09ac\5\u00a2"+
		"R\2\u09ab\u09aa\3\2\2\2\u09ab\u09ac\3\2\2\2\u09ac\u09b0\3\2\2\2\u09ad"+
		"\u09b1\5\u00b4[\2\u09ae\u09b1\5\u0104\u0083\2\u09af\u09b1\5\u01a4\u00d3"+
		"\2\u09b0\u09ad\3\2\2\2\u09b0\u09ae\3\2\2\2\u09b0\u09af\3\2\2\2\u09b1G"+
		"\3\2\2\2\u09b2\u09b3\t\16\2\2\u09b3I\3\2\2\2\u09b4\u09b5\t\17\2\2\u09b5"+
		"K\3\2\2\2\u09b6\u09b7\7\60\2\2\u09b7\u09b8\5\u01a4\u00d3\2\u09b8\u09c3"+
		"\7\u015a\2\2\u09b9\u09be\5F$\2\u09ba\u09bb\7\u0153\2\2\u09bb\u09bd\5F"+
		"$\2\u09bc\u09ba\3\2\2\2\u09bd\u09c0\3\2\2\2\u09be\u09bc\3\2\2\2\u09be"+
		"\u09bf\3\2\2\2\u09bf\u09c2\3\2\2\2\u09c0\u09be\3\2\2\2\u09c1\u09b9\3\2"+
		"\2\2\u09c2\u09c5\3\2\2\2\u09c3\u09c1\3\2\2\2\u09c3\u09c4\3\2\2\2\u09c4"+
		"\u09c6\3\2\2\2\u09c5\u09c3\3\2\2\2\u09c6\u09c7\7\u015b\2\2\u09c7M\3\2"+
		"\2\2\u09c8\u09c9\7\7\2\2\u09c9\u09ca\7\61\2\2\u09ca\u09cb\7<\2\2\u09cb"+
		"\u09cc\7j\2\2\u09cc\u09d1\5\u00a2R\2\u09cd\u09ce\7\u0153\2\2\u09ce\u09d0"+
		"\5\u00a2R\2\u09cf\u09cd\3\2\2\2\u09d0\u09d3\3\2\2\2\u09d1\u09cf\3\2\2"+
		"\2\u09d1\u09d2\3\2\2\2\u09d2O\3\2\2\2\u09d3\u09d1\3\2\2\2\u09d4\u09d6"+
		"\7\31\2\2\u09d5\u09d7\t\20\2\2\u09d6\u09d5\3\2\2\2\u09d6\u09d7\3\2\2\2"+
		"\u09d7\u09d8\3\2\2\2\u09d8\u09d9\7k\2\2\u09d9\u09dd\5\u01a4\u00d3\2\u09da"+
		"\u09dc\5R*\2\u09db\u09da\3\2\2\2\u09dc\u09df\3\2\2\2\u09dd\u09db\3\2\2"+
		"\2\u09dd\u09de\3\2\2\2\u09deQ\3\2\2\2\u09df\u09dd\3\2\2\2\u09e0\u09e2"+
		"\7\u00c0\2\2\u09e1\u09e3\7\u008e\2\2\u09e2\u09e1\3\2\2\2\u09e2\u09e3\3"+
		"\2\2\2\u09e3\u09e4\3\2\2\2\u09e4\u0a03\7\u0169\2\2\u09e5\u09e6\7\u00d6"+
		"\2\2\u09e6\u09ea\7\u0169\2\2\u09e7\u09e8\7\u00da\2\2\u09e8\u09ea\7\u00d6"+
		"\2\2\u09e9\u09e5\3\2\2\2\u09e9\u09e7\3\2\2\2\u09ea\u0a03\3\2\2\2\u09eb"+
		"\u09ec\7\u00d1\2\2\u09ec\u09f0\5\u00c4c\2\u09ed\u09ee\7\u00da\2\2\u09ee"+
		"\u09f0\7\u00d1\2\2\u09ef\u09eb\3\2\2\2\u09ef\u09ed\3\2\2\2\u09f0\u0a03"+
		"\3\2\2\2\u09f1\u09f3\7\u0100\2\2\u09f2\u09f4\7\u0087\2\2\u09f3\u09f2\3"+
		"\2\2\2\u09f3\u09f4\3\2\2\2\u09f4\u09f5\3\2\2\2\u09f5\u0a03\7\u0169\2\2"+
		"\u09f6\u09f7\7\u008f\2\2\u09f7\u0a03\7\u0169\2\2\u09f8\u09fa\7\u00da\2"+
		"\2\u09f9\u09f8\3\2\2\2\u09f9\u09fa\3\2\2\2\u09fa\u09fb\3\2\2\2\u09fb\u0a03"+
		"\7\u00a2\2\2\u09fc\u09fd\7Y\2\2\u09fd\u0a00\7\u008e\2\2\u09fe\u0a01\5"+
		"\u01a4\u00d3\2\u09ff\u0a01\7\u00db\2\2\u0a00\u09fe\3\2\2\2\u0a00\u09ff"+
		"\3\2\2\2\u0a01\u0a03\3\2\2\2\u0a02\u09e0\3\2\2\2\u0a02\u09e9\3\2\2\2\u0a02"+
		"\u09ef\3\2\2\2\u0a02\u09f1\3\2\2\2\u0a02\u09f6\3\2\2\2\u0a02\u09f9\3\2"+
		"\2\2\u0a02\u09fc\3\2\2\2\u0a03S\3\2\2\2\u0a04\u0a05\7\31\2\2\u0a05\u0a06"+
		"\7j\2\2\u0a06\u0a09\5\u00a2R\2\u0a07\u0a08\7\r\2\2\u0a08\u0a0a\5\u00a2"+
		"R\2\u0a09\u0a07\3\2\2\2\u0a09\u0a0a\3\2\2\2\u0a0a\u0a0e\3\2\2\2\u0a0b"+
		"\u0a0d\5\2\2\2\u0a0c\u0a0b\3\2\2\2\u0a0d\u0a10\3\2\2\2\u0a0e\u0a0c\3\2"+
		"\2\2\u0a0e\u0a0f\3\2\2\2\u0a0f\u0a2d\3\2\2\2\u0a10\u0a0e\3\2\2\2\u0a11"+
		"\u0a12\7\31\2\2\u0a12\u0a13\7j\2\2\u0a13\u0a14\7\r\2\2\u0a14\u0a18\5\u00a2"+
		"R\2\u0a15\u0a17\5\2\2\2\u0a16\u0a15\3\2\2\2\u0a17\u0a1a\3\2\2\2\u0a18"+
		"\u0a16\3\2\2\2\u0a18\u0a19\3\2\2\2\u0a19\u0a2d\3\2\2\2\u0a1a\u0a18\3\2"+
		"\2\2\u0a1b\u0a1c\7\31\2\2\u0a1c\u0a1d\7j\2\2\u0a1d\u0a1e\78\2\2\u0a1e"+
		"\u0a1f\7P\2\2\u0a1f\u0a20\7\u00b1\2\2\u0a20\u0a23\5\u00a2R\2\u0a21\u0a22"+
		"\7\r\2\2\u0a22\u0a24\5\u00a2R\2\u0a23\u0a21\3\2\2\2\u0a23\u0a24\3\2\2"+
		"\2\u0a24\u0a2d\3\2\2\2\u0a25\u0a26\7\31\2\2\u0a26\u0a27\7j\2\2\u0a27\u0a28"+
		"\78\2\2\u0a28\u0a29\7P\2\2\u0a29\u0a2a\7\u00b1\2\2\u0a2a\u0a2b\7\r\2\2"+
		"\u0a2b\u0a2d\5\u00a2R\2\u0a2c\u0a04\3\2\2\2\u0a2c\u0a11\3\2\2\2\u0a2c"+
		"\u0a1b\3\2\2\2\u0a2c\u0a25\3\2\2\2\u0a2dU\3\2\2\2\u0a2e\u0a31\7\31\2\2"+
		"\u0a2f\u0a30\7W\2\2\u0a30\u0a32\7d\2\2\u0a31\u0a2f\3\2\2\2\u0a31\u0a32"+
		"\3\2\2\2\u0a32\u0a34\3\2\2\2\u0a33\u0a35\t\20\2\2\u0a34\u0a33\3\2\2\2"+
		"\u0a34\u0a35\3\2\2\2\u0a35\u0a36\3\2\2\2\u0a36\u0a37\7\u0084\2\2\u0a37"+
		"\u0a3e\5\u01a4\u00d3\2\u0a38\u0a3a\5\u00a2R\2\u0a39\u0a3b\7\u0153\2\2"+
		"\u0a3a\u0a39\3\2\2\2\u0a3a\u0a3b\3\2\2\2\u0a3b\u0a3d\3\2\2\2\u0a3c\u0a38"+
		"\3\2\2\2\u0a3d\u0a40\3\2\2\2\u0a3e\u0a3c\3\2\2\2\u0a3e\u0a3f\3\2\2\2\u0a3f"+
		"\u0a4e\3\2\2\2\u0a40\u0a3e\3\2\2\2\u0a41\u0a42\7\u0087\2\2\u0a42\u0a48"+
		"\7\u015a\2\2\u0a43\u0a46\5\u00a2R\2\u0a44\u0a45\7\u0150\2\2\u0a45\u0a47"+
		"\5\u00a2R\2\u0a46\u0a44\3\2\2\2\u0a46\u0a47\3\2\2\2\u0a47\u0a49\3\2\2"+
		"\2\u0a48\u0a43\3\2\2\2\u0a49\u0a4a\3\2\2\2\u0a4a\u0a48\3\2\2\2\u0a4a\u0a4b"+
		"\3\2\2\2\u0a4b\u0a4c\3\2\2\2\u0a4c\u0a4d\7\u015b\2\2\u0a4d\u0a4f\3\2\2"+
		"\2\u0a4e\u0a41\3\2\2\2\u0a4e\u0a4f\3\2\2\2\u0a4f\u0a50\3\2\2\2\u0a50\u0a51"+
		"\7\6\2\2\u0a51\u0a52\5\u01a6\u00d4\2\u0a52W\3\2\2\2\u0a53\u0a59\7\31\2"+
		"\2\u0a54\u0a56\t\21\2\2\u0a55\u0a54\3\2\2\2\u0a55\u0a56\3\2\2\2\u0a56"+
		"\u0a57\3\2\2\2\u0a57\u0a5a\t\20\2\2\u0a58\u0a5a\7\u0113\2\2\u0a59\u0a55"+
		"\3\2\2\2\u0a59\u0a58\3\2\2\2\u0a59\u0a5a\3\2\2\2\u0a5a\u0a5b\3\2\2\2\u0a5b"+
		"\u0a5f\7t\2\2\u0a5c\u0a5d\78\2\2\u0a5d\u0a5e\7P\2\2\u0a5e\u0a60\7\u00b1"+
		"\2\2\u0a5f\u0a5c\3\2\2\2\u0a5f\u0a60\3\2\2\2\u0a60\u0a61\3\2\2\2\u0a61"+
		"\u0a62\5\u01a4\u00d3\2\u0a62\u0a6b\7\u015a\2\2\u0a63\u0a68\5Z.\2\u0a64"+
		"\u0a65\7\u0153\2\2\u0a65\u0a67\5Z.\2\u0a66\u0a64\3\2\2\2\u0a67\u0a6a\3"+
		"\2\2\2\u0a68\u0a66\3\2\2\2\u0a68\u0a69\3\2\2\2\u0a69\u0a6c\3\2\2\2\u0a6a"+
		"\u0a68\3\2\2\2\u0a6b\u0a63\3\2\2\2\u0a6b\u0a6c\3\2\2\2\u0a6c\u0a6d\3\2"+
		"\2\2\u0a6d\u0a7a\7\u015b\2\2\u0a6e\u0a6f\7>\2\2\u0a6f\u0a74\7\u015a\2"+
		"\2\u0a70\u0a72\5\u01a4\u00d3\2\u0a71\u0a73\7\u0153\2\2\u0a72\u0a71\3\2"+
		"\2\2\u0a72\u0a73\3\2\2\2\u0a73\u0a75\3\2\2\2\u0a74\u0a70\3\2\2\2\u0a75"+
		"\u0a76\3\2\2\2\u0a76\u0a74\3\2\2\2\u0a76\u0a77\3\2\2\2\u0a77\u0a78\3\2"+
		"\2\2\u0a78\u0a79\7\u015b\2\2\u0a79\u0a7b\3\2\2\2\u0a7a\u0a6e\3\2\2\2\u0a7a"+
		"\u0a7b\3\2\2\2\u0a7b\u0a7c\3\2\2\2\u0a7c\u0a7d\5j\66\2\u0a7d\u0a7e\5l"+
		"\67\2\u0a7e\u0a7f\5n8\2\u0a7f\u0ab7\3\2\2\2\u0a80\u0a86\7\31\2\2\u0a81"+
		"\u0a83\t\21\2\2\u0a82\u0a81\3\2\2\2\u0a82\u0a83\3\2\2\2\u0a83\u0a84\3"+
		"\2\2\2\u0a84\u0a87\t\20\2\2\u0a85\u0a87\7\u0113\2\2\u0a86\u0a82\3\2\2"+
		"\2\u0a86\u0a85\3\2\2\2\u0a86\u0a87\3\2\2\2\u0a87\u0a88\3\2\2\2\u0a88\u0a8c"+
		"\7t\2\2\u0a89\u0a8a\78\2\2\u0a8a\u0a8b\7P\2\2\u0a8b\u0a8d\7\u00b1\2\2"+
		"\u0a8c\u0a89\3\2\2\2\u0a8c\u0a8d\3\2\2\2\u0a8d\u0a8e\3\2\2\2\u0a8e\u0a8f"+
		"\5\u01a4\u00d3\2\u0a8f\u0a90\7R\2\2\u0a90\u0ab0\5\u00a2R\2\u0a91\u0a9c"+
		"\7\u015a\2\2\u0a92\u0a93\5\u00a2R\2\u0a93\u0a94\7\u0087\2\2\u0a94\u0a98"+
		"\7\u00e3\2\2\u0a95\u0a97\5b\62\2\u0a96\u0a95\3\2\2\2\u0a97\u0a9a\3\2\2"+
		"\2\u0a98\u0a96\3\2\2\2\u0a98\u0a99\3\2\2\2\u0a99\u0a9d\3\2\2\2\u0a9a\u0a98"+
		"\3\2\2\2\u0a9b\u0a9d\5`\61\2\u0a9c\u0a92\3\2\2\2\u0a9c\u0a9b\3\2\2\2\u0a9d"+
		"\u0aab\3\2\2\2\u0a9e\u0a9f\7\u0153\2\2\u0a9f\u0aa0\5\u00a2R\2\u0aa0\u0aa1"+
		"\7\u0087\2\2\u0aa1\u0aa5\7\u00e3\2\2\u0aa2\u0aa4\5b\62\2\u0aa3\u0aa2\3"+
		"\2\2\2\u0aa4\u0aa7\3\2\2\2\u0aa5\u0aa3\3\2\2\2\u0aa5\u0aa6\3\2\2\2\u0aa6"+
		"\u0aaa\3\2\2\2\u0aa7\u0aa5\3\2\2\2\u0aa8\u0aaa\5`\61\2\u0aa9\u0a9e\3\2"+
		"\2\2\u0aa9\u0aa8\3\2\2\2\u0aaa\u0aad\3\2\2\2\u0aab\u0aa9\3\2\2\2\u0aab"+
		"\u0aac\3\2\2\2\u0aac\u0aae\3\2\2\2\u0aad\u0aab\3\2\2\2\u0aae\u0aaf\7\u015b"+
		"\2\2\u0aaf\u0ab1\3\2\2\2\u0ab0\u0a91\3\2\2\2\u0ab0\u0ab1\3\2\2\2\u0ab1"+
		"\u0ab2\3\2\2\2\u0ab2\u0ab3\5j\66\2\u0ab3\u0ab4\5l\67\2\u0ab4\u0ab5\5n"+
		"8\2\u0ab5\u0ab7\3\2\2\2\u0ab6\u0a53\3\2\2\2\u0ab6\u0a80\3\2\2\2\u0ab7"+
		"Y\3\2\2\2\u0ab8\u0ac3\5\\/\2\u0ab9\u0ac3\5`\61\2\u0aba\u0abb\7L\2\2\u0abb"+
		"\u0abf\5\u00a2R\2\u0abc\u0abe\5^\60\2\u0abd\u0abc\3\2\2\2\u0abe\u0ac1"+
		"\3\2\2\2\u0abf\u0abd\3\2\2\2\u0abf\u0ac0\3\2\2\2\u0ac0\u0ac3\3\2\2\2\u0ac1"+
		"\u0abf\3\2\2\2\u0ac2\u0ab8\3\2\2\2\u0ac2\u0ab9\3\2\2\2\u0ac2\u0aba\3\2"+
		"\2\2\u0ac3[\3\2\2\2\u0ac4\u0ac7\5\u00a2R\2\u0ac5\u0ac8\5\u00b4[\2\u0ac6"+
		"\u0ac8\5\u01a4\u00d3\2\u0ac7\u0ac5\3\2\2\2\u0ac7\u0ac6\3\2\2\2\u0ac8\u0acb"+
		"\3\2\2\2\u0ac9\u0aca\7\23\2\2\u0aca\u0acc\5\u00a2R\2\u0acb\u0ac9\3\2\2"+
		"\2\u0acb\u0acc\3\2\2\2\u0acc\u0ad0\3\2\2\2\u0acd\u0acf\5b\62\2\u0ace\u0acd"+
		"\3\2\2\2\u0acf\u0ad2\3\2\2\2\u0ad0\u0ace\3\2\2\2\u0ad0\u0ad1\3\2\2\2\u0ad1"+
		"]\3\2\2\2\u0ad2\u0ad0\3\2\2\2\u0ad3\u0ad4\t\22\2\2\u0ad4\u0ad5\t\23\2"+
		"\2\u0ad5_\3\2\2\2\u0ad6\u0ad7\7\26\2\2\u0ad7\u0ad9\5\u00a2R\2\u0ad8\u0ad6"+
		"\3\2\2\2\u0ad8\u0ad9\3\2\2\2\u0ad9\u0b3d\3\2\2\2\u0ada\u0b3e\5d\63\2\u0adb"+
		"\u0adc\7~\2\2\u0adc\u0add\7\u015a\2\2\u0add\u0ae2\5\u00a2R\2\u0ade\u0adf"+
		"\7\u0153\2\2\u0adf\u0ae1\5\u00a2R\2\u0ae0\u0ade\3\2\2\2\u0ae1\u0ae4\3"+
		"\2\2\2\u0ae2\u0ae0\3\2\2\2\u0ae2\u0ae3\3\2\2\2\u0ae3\u0ae5\3\2\2\2\u0ae4"+
		"\u0ae2\3\2\2\2\u0ae5\u0ae6\7\u015b\2\2\u0ae6\u0ae7\5r:\2\u0ae7\u0b3e\3"+
		"\2\2\2\u0ae8\u0ae9\7\\\2\2\u0ae9\u0aea\7I\2\2\u0aea\u0aeb\7\u015a\2\2"+
		"\u0aeb\u0af0\5\u00a2R\2\u0aec\u0aed\7\u0153\2\2\u0aed\u0aef\5\u00a2R\2"+
		"\u0aee\u0aec\3\2\2\2\u0aef\u0af2\3\2\2\2\u0af0\u0aee\3\2\2\2\u0af0\u0af1"+
		"\3\2\2\2\u0af1\u0af3\3\2\2\2\u0af2\u0af0\3\2\2\2\u0af3\u0af4\7\u015b\2"+
		"\2\u0af4\u0af5\5r:\2\u0af5\u0b3e\3\2\2\2\u0af6\u0af9\7(\2\2\u0af7\u0af8"+
		"\7\u0081\2\2\u0af8\u0afa\5\u00a2R\2\u0af9\u0af7\3\2\2\2\u0af9\u0afa\3"+
		"\2\2\2\u0afa\u0afb\3\2\2\2\u0afb\u0afc\7\u015a\2\2\u0afc\u0afd\5\u00a2"+
		"R\2\u0afd\u0afe\7\u0087\2\2\u0afe\u0b03\5\u00a2R\2\u0aff\u0b00\7\u0153"+
		"\2\2\u0b00\u0b02\5\u00a2R\2\u0b01\u0aff\3\2\2\2\u0b02\u0b05\3\2\2\2\u0b03"+
		"\u0b01\3\2\2\2\u0b03\u0b04\3\2\2\2\u0b04\u0b06\3\2\2\2\u0b05\u0b03\3\2"+
		"\2\2\u0b06\u0b07\7\u015b\2\2\u0b07\u0b0d\5r:\2\u0b08\u0b09\7\u0086\2\2"+
		"\u0b09\u0b0a\7\u015a\2\2\u0b0a\u0b0b\5\u00a2R\2\u0b0b\u0b0c\7\u015b\2"+
		"\2\u0b0c\u0b0e\3\2\2\2\u0b0d\u0b08\3\2\2\2\u0b0d\u0b0e\3\2\2\2\u0b0e\u0b3e"+
		"\3\2\2\2\u0b0f\u0b10\7.\2\2\u0b10\u0b11\7I\2\2\u0b11\u0b12\7\u015a\2\2"+
		"\u0b12\u0b17\5\u00a2R\2\u0b13\u0b14\7\u0153\2\2\u0b14\u0b16\5\u00a2R\2"+
		"\u0b15\u0b13\3\2\2\2\u0b16\u0b19\3\2\2\2\u0b17\u0b15\3\2\2\2\u0b17\u0b18"+
		"\3\2\2\2\u0b18\u0b1a\3\2\2\2\u0b19\u0b17\3\2\2\2\u0b1a\u0b1b\7\u015b\2"+
		"\2\u0b1b\u0b1c\7c\2\2\u0b1c\u0b28\5\u01a4\u00d3\2\u0b1d\u0b1e\7\u015a"+
		"\2\2\u0b1e\u0b23\5\u00a2R\2\u0b1f\u0b20\7\u0153\2\2\u0b20\u0b22\5\u00a2"+
		"R\2\u0b21\u0b1f\3\2\2\2\u0b22\u0b25\3\2\2\2\u0b23\u0b21\3\2\2\2\u0b23"+
		"\u0b24\3\2\2\2\u0b24\u0b26\3\2\2\2\u0b25\u0b23\3\2\2\2\u0b26\u0b27\7\u015b"+
		"\2\2\u0b27\u0b29\3\2\2\2\u0b28\u0b1d\3\2\2\2\u0b28\u0b29\3\2\2\2\u0b29"+
		"\u0b3a\3\2\2\2\u0b2a\u0b2b\7\u00cf\2\2\u0b2b\u0b31\7/\2\2\u0b2c\u0b2d"+
		"\7\u00cf\2\2\u0b2d\u0b31\7\u00e7\2\2\u0b2e\u0b2f\7\u00cf\2\2\u0b2f\u0b31"+
		"\7\u00fe\2\2\u0b30\u0b2a\3\2\2\2\u0b30\u0b2c\3\2\2\2\u0b30\u0b2e\3\2\2"+
		"\2\u0b31\u0b39\3\2\2\2\u0b32\u0b33\7\u00e0\2\2\u0b33\u0b34\7 \2\2\u0b34"+
		"\u0b39\5p9\2\u0b35\u0b36\7\u00e0\2\2\u0b36\u0b37\7\177\2\2\u0b37\u0b39"+
		"\5p9\2\u0b38\u0b30\3\2\2\2\u0b38\u0b32\3\2\2\2\u0b38\u0b35\3\2\2\2\u0b39"+
		"\u0b3c\3\2\2\2\u0b3a\u0b38\3\2\2\2\u0b3a\u0b3b\3\2\2\2\u0b3b\u0b3e\3\2"+
		"\2\2\u0b3c\u0b3a\3\2\2\2\u0b3d\u0ada\3\2\2\2\u0b3d\u0adb\3\2\2\2\u0b3d"+
		"\u0ae8\3\2\2\2\u0b3d\u0af6\3\2\2\2\u0b3d\u0b0f\3\2\2\2\u0b3e\u0b42\3\2"+
		"\2\2\u0b3f\u0b43\7\36\2\2\u0b40\u0b41\7P\2\2\u0b41\u0b43\7\36\2\2\u0b42"+
		"\u0b3f\3\2\2\2\u0b42\u0b40\3\2\2\2\u0b42\u0b43\3\2\2\2\u0b43\u0b48\3\2"+
		"\2\2\u0b44\u0b45\7?\2\2\u0b45\u0b49\7\37\2\2\u0b46\u0b47\7?\2\2\u0b47"+
		"\u0b49\7:\2\2\u0b48\u0b44\3\2\2\2\u0b48\u0b46\3\2\2\2\u0b48\u0b49\3\2"+
		"\2\2\u0b49a\3\2\2\2\u0b4a\u0b4b\7\26\2\2\u0b4b\u0b4d\5\u00a2R\2\u0b4c"+
		"\u0b4a\3\2\2\2\u0b4c\u0b4d\3\2\2\2\u0b4d\u0b71\3\2\2\2\u0b4e\u0b4f\7P"+
		"\2\2\u0b4f\u0b72\7Q\2\2\u0b50\u0b72\7Q\2\2\u0b51\u0b72\5d\63\2\u0b52\u0b55"+
		"\7\34\2\2\u0b53\u0b56\5\u00b4[\2\u0b54\u0b56\5\u0104\u0083\2\u0b55\u0b53"+
		"\3\2\2\2\u0b55\u0b54\3\2\2\2\u0b56\u0b72\3\2\2\2\u0b57\u0b58\7~\2\2\u0b58"+
		"\u0b72\5r:\2\u0b59\u0b5a\7\\\2\2\u0b5a\u0b5b\7I\2\2\u0b5b\u0b72\5r:\2"+
		"\u0b5c\u0b5d\7c\2\2\u0b5d\u0b5e\5\u01a4\u00d3\2\u0b5e\u0b65\5\u00a2R\2"+
		"\u0b5f\u0b60\7\u00cf\2\2\u0b60\u0b66\7/\2\2\u0b61\u0b62\7\u00cf\2\2\u0b62"+
		"\u0b66\7\u00e7\2\2\u0b63\u0b64\7\u00cf\2\2\u0b64\u0b66\7\u00fe\2\2\u0b65"+
		"\u0b5f\3\2\2\2\u0b65\u0b61\3\2\2\2\u0b65\u0b63\3\2\2\2\u0b65\u0b66\3\2"+
		"\2\2\u0b66\u0b6a\3\2\2\2\u0b67\u0b68\7\u00e0\2\2\u0b68\u0b69\7 \2\2\u0b69"+
		"\u0b6b\5p9\2\u0b6a\u0b67\3\2\2\2\u0b6a\u0b6b\3\2\2\2\u0b6b\u0b6f\3\2\2"+
		"\2\u0b6c\u0b6d\7\u00e0\2\2\u0b6d\u0b6e\7\177\2\2\u0b6e\u0b70\5p9\2\u0b6f"+
		"\u0b6c\3\2\2\2\u0b6f\u0b70\3\2\2\2\u0b70\u0b72\3\2\2\2\u0b71\u0b4e\3\2"+
		"\2\2\u0b71\u0b50\3\2\2\2\u0b71\u0b51\3\2\2\2\u0b71\u0b52\3\2\2\2\u0b71"+
		"\u0b57\3\2\2\2\u0b71\u0b59\3\2\2\2\u0b71\u0b5c\3\2\2\2\u0b72\u0b76\3\2"+
		"\2\2\u0b73\u0b77\7\36\2\2\u0b74\u0b75\7P\2\2\u0b75\u0b77\7\36\2\2\u0b76"+
		"\u0b73\3\2\2\2\u0b76\u0b74\3\2\2\2\u0b76\u0b77\3\2\2\2\u0b77\u0b7c\3\2"+
		"\2\2\u0b78\u0b79\7?\2\2\u0b79\u0b7d\7\37\2\2\u0b7a\u0b7b\7?\2\2\u0b7b"+
		"\u0b7d\7:\2\2\u0b7c\u0b78\3\2\2\2\u0b7c\u0b7a\3\2\2\2\u0b7c\u0b7d\3\2"+
		"\2\2\u0b7dc\3\2\2\2\u0b7e\u0b80\7\u0094\2\2\u0b7f\u0b81\7\u015a\2\2\u0b80"+
		"\u0b7f\3\2\2\2\u0b81\u0b82\3\2\2\2\u0b82\u0b80\3\2\2\2\u0b82\u0b83\3\2"+
		"\2\2\u0b83\u0b84\3\2\2\2\u0b84\u0b86\5\u0104\u0083\2\u0b85\u0b87\7\u015b"+
		"\2\2\u0b86\u0b85\3\2\2\2\u0b87\u0b88\3\2\2\2\u0b88\u0b86\3\2\2\2\u0b88"+
		"\u0b89\3\2\2\2\u0b89e\3\2\2\2\u0b8a\u0b93\7\u015a\2\2\u0b8b\u0b8e\5\u00a2"+
		"R\2\u0b8c\u0b8d\7\u0150\2\2\u0b8d\u0b8f\5\u0104\u0083\2\u0b8e\u0b8c\3"+
		"\2\2\2\u0b8e\u0b8f\3\2\2\2\u0b8f\u0b91\3\2\2\2\u0b90\u0b92\7\u0153\2\2"+
		"\u0b91\u0b90\3\2\2\2\u0b91\u0b92\3\2\2\2\u0b92\u0b94\3\2\2\2\u0b93\u0b8b"+
		"\3\2\2\2\u0b94\u0b95\3\2\2\2\u0b95\u0b93\3\2\2\2\u0b95\u0b96\3\2\2\2\u0b96"+
		"\u0b97\3\2\2\2\u0b97\u0b98\7\u015b\2\2\u0b98g\3\2\2\2\u0b99\u0b9a\7\u0087"+
		"\2\2\u0b9a\u0b9b\5f\64\2\u0b9bi\3\2\2\2\u0b9c\u0ba2\5h\65\2\u0b9d\u0b9e"+
		"\7\u0087\2\2\u0b9e\u0ba2\7S\2\2\u0b9f\u0ba0\7\u0088\2\2\u0ba0\u0ba2\7"+
		"S\2\2\u0ba1\u0b9c\3\2\2\2\u0ba1\u0b9d\3\2\2\2\u0ba1\u0b9f\3\2\2\2\u0ba1"+
		"\u0ba2\3\2\2\2\u0ba2k\3\2\2\2\u0ba3\u0ba4\7\u00e0\2\2\u0ba4\u0baa\7\u009b"+
		"\2\2\u0ba5\u0ba6\7[\2\2\u0ba6\u0bab\7b\2\2\u0ba7\u0ba8\7 \2\2\u0ba8\u0bab"+
		"\7b\2\2\u0ba9\u0bab\7\u00ac\2\2\u0baa\u0ba5\3\2\2\2\u0baa\u0ba7\3\2\2"+
		"\2\u0baa\u0ba9\3\2\2\2\u0bab\u0bad\3\2\2\2\u0bac\u0ba3\3\2\2\2\u0bac\u0bad"+
		"\3\2\2\2\u0badm\3\2\2\2\u0bae\u0baf\7\u0107\2\2\u0baf\u0bb1\5\u00a2R\2"+
		"\u0bb0\u0bae\3\2\2\2\u0bb0\u0bb1\3\2\2\2\u0bb1o\3\2\2\2\u0bb2\u0bb9\7"+
		"e\2\2\u0bb3\u0bb9\7\21\2\2\u0bb4\u0bb5\7\u00fc\2\2\u0bb5\u0bb9\7Q\2\2"+
		"\u0bb6\u0bb7\7\u00fc\2\2\u0bb7\u0bb9\7\34\2\2\u0bb8\u0bb2\3\2\2\2\u0bb8"+
		"\u0bb3\3\2\2\2\u0bb8\u0bb4\3\2\2\2\u0bb8\u0bb6\3\2\2\2\u0bb9q\3\2\2\2"+
		"\u0bba\u0bbc\5h\65\2\u0bbb\u0bba\3\2\2\2\u0bbb\u0bbc\3\2\2\2\u0bbc\u0bc1"+
		"\3\2\2\2\u0bbd\u0bbe\7\u0081\2\2\u0bbe\u0bbf\7\u00be\2\2\u0bbf\u0bc0\7"+
		"\u0107\2\2\u0bc0\u0bc2\5\u00a2R\2\u0bc1\u0bbd\3\2\2\2\u0bc1\u0bc2\3\2"+
		"\2\2\u0bc2s\3\2\2\2\u0bc3\u0bc4\7\u015a\2\2\u0bc4\u0bc9\5v<\2\u0bc5\u0bc6"+
		"\7\u0153\2\2\u0bc6\u0bc8\5v<\2\u0bc7\u0bc5\3\2\2\2\u0bc8\u0bcb\3\2\2\2"+
		"\u0bc9\u0bc7\3\2\2\2\u0bc9\u0bca\3\2\2\2\u0bca\u0bcc\3\2\2\2\u0bcb\u0bc9"+
		"\3\2\2\2\u0bcc\u0bcd\7\u015b\2\2\u0bcdu\3\2\2\2\u0bce\u0bcf\5\u00a2R\2"+
		"\u0bcf\u0bd0\5x=\2\u0bd0w\3\2\2\2\u0bd1\u0bd2\5\u00b4[\2\u0bd2y\3\2\2"+
		"\2\u0bd3\u0bd4\7\u0087\2\2\u0bd4\u0bd5\7\u015a\2\2\u0bd5\u0bda\5|?\2\u0bd6"+
		"\u0bd7\7\u0153\2\2\u0bd7\u0bd9\5|?\2\u0bd8\u0bd6\3\2\2\2\u0bd9\u0bdc\3"+
		"\2\2\2\u0bda\u0bd8\3\2\2\2\u0bda\u0bdb\3\2\2\2\u0bdb\u0bdd\3\2\2\2\u0bdc"+
		"\u0bda\3\2\2\2\u0bdd\u0bde\7\u015b\2\2\u0bde{\3\2\2\2\u0bdf\u0be0\5\u00a2"+
		"R\2\u0be0\u0be1\7\u0150\2\2\u0be1\u0be2\5\u010a\u0086\2\u0be2}\3\2\2\2"+
		"\u0be3\u0be4\7\u0081\2\2\u0be4\u0be5\5\u00a2R\2\u0be5\177\3\2\2\2\u0be6"+
		"\u0be7\7\u0107\2\2\u0be7\u0be8\5\u0082B\2\u0be8\u0081\3\2\2\2\u0be9\u0bea"+
		"\5\u00a2R\2\u0bea\u0083\3\2\2\2\u0beb\u0bf0\5\u0086D\2\u0bec\u0bf0\5\u008c"+
		"G\2\u0bed\u0bf0\5\u0094K\2\u0bee\u0bf0\5\u009aN\2\u0bef\u0beb\3\2\2\2"+
		"\u0bef\u0bec\3\2\2\2\u0bef\u0bed\3\2\2\2\u0bef\u0bee\3\2\2\2\u0bf0\u0085"+
		"\3\2\2\2\u0bf1\u0bf2\7\u00e8\2\2\u0bf2\u0bf3\7\u008e\2\2\u0bf3\u0bf4\7"+
		"\u00ef\2\2\u0bf4\u0bf5\7\u015a\2\2\u0bf5\u0bf6\5\u01b8\u00dd\2\u0bf6\u0bf7"+
		"\7\u015b\2\2\u0bf7\u0bf8\7\u015a\2\2\u0bf8\u0bf9\5\u0088E\2\u0bf9\u0bfa"+
		"\7\u015b\2\2\u0bfa\u0087\3\2\2\2\u0bfb\u0c00\5\u008aF\2\u0bfc\u0bfd\7"+
		"\u0153\2\2\u0bfd\u0bff\5\u008aF\2\u0bfe\u0bfc\3\2\2\2\u0bff\u0c02\3\2"+
		"\2\2\u0c00\u0bfe\3\2\2\2\u0c00\u0c01\3\2\2\2\u0c01\u0089\3\2\2\2\u0c02"+
		"\u0c00\3\2\2\2\u0c03\u0c04\7\u00e8\2\2\u0c04\u0c05\5\u009eP\2\u0c05\u0c06"+
		"\7\u0117\2\2\u0c06\u0c07\7\u00cb\2\2\u0c07\u0c13\7\u010a\2\2\u0c08\u0c09"+
		"\7\u015a\2\2\u0c09\u0c0a\5\u0104\u0083\2\u0c0a\u0c0b\7\u015b\2\2\u0c0b"+
		"\u0c14\3\2\2\2\u0c0c\u0c0e\7\u015a\2\2\u0c0d\u0c0c\3\2\2\2\u0c0d\u0c0e"+
		"\3\2\2\2\u0c0e\u0c0f\3\2\2\2\u0c0f\u0c11\7\u00d1\2\2\u0c10\u0c12\7\u015b"+
		"\2\2\u0c11\u0c10\3\2\2\2\u0c11\u0c12\3\2\2\2\u0c12\u0c14\3\2\2\2\u0c13"+
		"\u0c08\3\2\2\2\u0c13\u0c0d\3\2\2\2\u0c14\u008b\3\2\2\2\u0c15\u0c16\7\u00e8"+
		"\2\2\u0c16\u0c17\7\u008e\2\2\u0c17\u0c18\7\u00bb\2\2\u0c18\u0c19\7\u015a"+
		"\2\2\u0c19\u0c1a\5\u01b8\u00dd\2\u0c1a\u0c20\7\u015b\2\2\u0c1b\u0c1c\7"+
		"\u015a\2\2\u0c1c\u0c1d\5\u008eH\2\u0c1d\u0c1e\7\u015b\2\2\u0c1e\u0c21"+
		"\3\2\2\2\u0c1f\u0c21\5\u0092J\2\u0c20\u0c1b\3\2\2\2\u0c20\u0c1f\3\2\2"+
		"\2\u0c21\u008d\3\2\2\2\u0c22\u0c27\5\u0090I\2\u0c23\u0c24\7\u0153\2\2"+
		"\u0c24\u0c26\5\u0090I\2\u0c25\u0c23\3\2\2\2\u0c26\u0c29\3\2\2\2\u0c27"+
		"\u0c25\3\2\2\2\u0c27\u0c28\3\2\2\2\u0c28\u008f\3\2\2\2\u0c29\u0c27\3\2"+
		"\2\2\u0c2a\u0c2b\7\u00e8\2\2\u0c2b\u0c2c\5\u009eP\2\u0c2c\u0091\3\2\2"+
		"\2\u0c2d\u0c2e\7\u00e9\2\2\u0c2e\u0c2f\5\u010a\u0086\2\u0c2f\u0093\3\2"+
		"\2\2\u0c30\u0c31\7\u00e8\2\2\u0c31\u0c32\7\u008e\2\2\u0c32\u0c33\7\u00cc"+
		"\2\2\u0c33\u0c34\7\u015a\2\2\u0c34\u0c35\5\u01b8\u00dd\2\u0c35\u0c36\7"+
		"\u015b\2\2\u0c36\u0c37\7\u015a\2\2\u0c37\u0c38\5\u0096L\2\u0c38\u0c39"+
		"\7\u015b\2\2\u0c39\u0095\3\2\2\2\u0c3a\u0c3f\5\u0098M\2\u0c3b\u0c3c\7"+
		"\u0153\2\2\u0c3c\u0c3e\5\u0098M\2\u0c3d\u0c3b\3\2\2\2\u0c3e\u0c41\3\2"+
		"\2\2\u0c3f\u0c3d\3\2\2\2\u0c3f\u0c40\3\2\2\2\u0c40\u0097\3\2\2\2\u0c41"+
		"\u0c3f\3\2\2\2\u0c42\u0c43\7\u00e8\2\2\u0c43\u0c44\5\u009eP\2\u0c44\u0c46"+
		"\7\u0117\2\2\u0c45\u0c47\7<\2\2\u0c46\u0c45\3\2\2\2\u0c46\u0c47\3\2\2"+
		"\2\u0c47\u0c48\3\2\2\2\u0c48\u0c49\7\u015a\2\2\u0c49\u0c4a\5\u01d0\u00e9"+
		"\2\u0c4a\u0c4b\7\u015b\2\2\u0c4b\u0099\3\2\2\2\u0c4c\u0c4d\7\u00e8\2\2"+
		"\u0c4d\u0c4e\7\u008e\2\2\u0c4e\u0c4f\7\u0098\2\2\u0c4f\u0c50\5t;\2\u0c50"+
		"\u009b\3\2\2\2\u0c51\u0c52\7\u00e8\2\2\u0c52\u0c53\7\u008e\2\2\u0c53\u0c58"+
		"\5\u01a4\u00d3\2\u0c54\u0c55\7\u0153\2\2\u0c55\u0c57\5\u01a4\u00d3\2\u0c56"+
		"\u0c54\3\2\2\2\u0c57\u0c5a\3\2\2\2\u0c58\u0c56\3\2\2\2\u0c58\u0c59\3\2"+
		"\2\2\u0c59\u009d\3\2\2\2\u0c5a\u0c58\3\2\2\2\u0c5b\u0c5c\5\u00a2R\2\u0c5c"+
		"\u009f\3\2\2\2\u0c5d\u0c5e\7\u00ac\2\2\u0c5e\u0c5f\7t\2\2\u0c5f\u0c61"+
		"\5\u01a4\u00d3\2\u0c60\u0c62\7\u00ed\2\2\u0c61\u0c60\3\2\2\2\u0c61\u0c62"+
		"\3\2\2\2\u0c62\u00a1\3\2\2\2\u0c63\u0c6d\7\u016d\2\2\u0c64\u0c6d\7\u016e"+
		"\2\2\u0c65\u0c67\7\u0165\2\2\u0c66\u0c65\3\2\2\2\u0c66\u0c67\3\2\2\2\u0c67"+
		"\u0c68\3\2\2\2\u0c68\u0c6a\5\u00a4S\2\u0c69\u0c6b\7\u0165\2\2\u0c6a\u0c69"+
		"\3\2\2\2\u0c6a\u0c6b\3\2\2\2\u0c6b\u0c6d\3\2\2\2\u0c6c\u0c63\3\2\2\2\u0c6c"+
		"\u0c64\3\2\2\2\u0c6c\u0c66\3\2\2\2\u0c6d\u00a3\3\2\2\2\u0c6e\u0c6f\t\24"+
		"\2\2\u0c6f\u00a5\3\2\2\2\u0c70\u0c73\5\u00dco\2\u0c71\u0c73\5\u00a8U\2"+
		"\u0c72\u0c70\3\2\2\2\u0c72\u0c71\3\2\2\2\u0c73\u00a7\3\2\2\2\u0c74\u0c78"+
		"\7\u0170\2\2\u0c75\u0c78\5\u00aaV\2\u0c76\u0c78\5\u00b2Z\2\u0c77\u0c74"+
		"\3\2\2\2\u0c77\u0c75\3\2\2\2\u0c77\u0c76\3\2\2\2\u0c78\u00a9\3\2\2\2\u0c79"+
		"\u0c7d\5\u00aeX\2\u0c7a\u0c7d\5\u00acW\2\u0c7b\u0c7d\5\u00b0Y\2\u0c7c"+
		"\u0c79\3\2\2\2\u0c7c\u0c7a\3\2\2\2\u0c7c\u0c7b\3\2\2\2\u0c7d\u00ab\3\2"+
		"\2\2\u0c7e\u0c7f\7\u013c\2\2\u0c7f\u0c80\7\u0170\2\2\u0c80\u00ad\3\2\2"+
		"\2\u0c81\u0c82\7\u013e\2\2\u0c82\u0c83\7\u0170\2\2\u0c83\u00af\3\2\2\2"+
		"\u0c84\u0c85\7\u013b\2\2\u0c85\u0c86\7\u0170\2\2\u0c86\u00b1\3\2\2\2\u0c87"+
		"\u0c88\t\25\2\2\u0c88\u00b3\3\2\2\2\u0c89\u0c8c\5\u00b6\\\2\u0c8a\u0c8b"+
		"\7\u0167\2\2\u0c8b\u0c8d\7\u0168\2\2\u0c8c\u0c8a\3\2\2\2\u0c8c\u0c8d\3"+
		"\2\2\2\u0c8d\u0c91\3\2\2\2\u0c8e\u0c8f\7o\2\2\u0c8f\u0c91\5\u00a2R\2\u0c90"+
		"\u0c89\3\2\2\2\u0c90\u0c8e\3\2\2\2\u0c91\u00b5\3\2\2\2\u0c92\u0ca2\5\u00bc"+
		"_\2\u0c93\u0ca2\5\u00c0a\2\u0c94\u0ca2\5\u00c2b\2\u0c95\u0ca2\5\u00c4"+
		"c\2\u0c96\u0ca2\5\u00ccg\2\u0c97\u0ca2\5\u00ceh\2\u0c98\u0ca2\5\u00d0"+
		"i\2\u0c99\u0ca2\5\u00d2j\2\u0c9a\u0ca2\5\u00ba^\2\u0c9b\u0ca2\5\u00b8"+
		"]\2\u0c9c\u0ca2\7\u00f0\2\2\u0c9d\u0ca2\7z\2\2\u0c9e\u0ca2\7\u0141\2\2"+
		"\u0c9f\u0ca2\7\u0149\2\2\u0ca0\u0ca2\7\u0147\2\2\u0ca1\u0c92\3\2\2\2\u0ca1"+
		"\u0c93\3\2\2\2\u0ca1\u0c94\3\2\2\2\u0ca1\u0c95\3\2\2\2\u0ca1\u0c96\3\2"+
		"\2\2\u0ca1\u0c97\3\2\2\2\u0ca1\u0c98\3\2\2\2\u0ca1\u0c99\3\2\2\2\u0ca1"+
		"\u0c9a\3\2\2\2\u0ca1\u0c9b\3\2\2\2\u0ca1\u0c9c\3\2\2\2\u0ca1\u0c9d\3\2"+
		"\2\2\u0ca1\u0c9e\3\2\2\2\u0ca1\u0c9f\3\2\2\2\u0ca1\u0ca0\3\2\2\2\u0ca2"+
		"\u00b7\3\2\2\2\u0ca3\u0ca4\7\u0132\2\2\u0ca4\u00b9\3\2\2\2\u0ca5\u0ca6"+
		"\7\u0146\2\2\u0ca6\u00bb\3\2\2\2\u0ca7\u0ca9\7\u0093\2\2\u0ca8\u0caa\5"+
		"\u00be`\2\u0ca9\u0ca8\3\2\2\2\u0ca9\u0caa\3\2\2\2\u0caa\u0cc0\3\2\2\2"+
		"\u0cab\u0cad\7\u0137\2\2\u0cac\u0cae\5\u00be`\2\u0cad\u0cac\3\2\2\2\u0cad"+
		"\u0cae\3\2\2\2\u0cae\u0cc0\3\2\2\2\u0caf\u0cb0\7\u0093\2\2\u0cb0\u0cb2"+
		"\7\u011a\2\2\u0cb1\u0cb3\5\u00be`\2\u0cb2\u0cb1\3\2\2\2\u0cb2\u0cb3\3"+
		"\2\2\2\u0cb3\u0cc0\3\2\2\2\u0cb4\u0cb5\7\u0137\2\2\u0cb5\u0cb7\7\u011a"+
		"\2\2\u0cb6\u0cb8\5\u00be`\2\u0cb7\u0cb6\3\2\2\2\u0cb7\u0cb8\3\2\2\2\u0cb8"+
		"\u0cc0\3\2\2\2\u0cb9\u0cbb\7\u0138\2\2\u0cba\u0cbc\5\u00be`\2\u0cbb\u0cba"+
		"\3\2\2\2\u0cbb\u0cbc\3\2\2\2\u0cbc\u0cc0\3\2\2\2\u0cbd\u0cc0\7\u0140\2"+
		"\2\u0cbe\u0cc0\7\u0148\2\2\u0cbf\u0ca7\3\2\2\2\u0cbf\u0cab\3\2\2\2\u0cbf"+
		"\u0caf\3\2\2\2\u0cbf\u0cb4\3\2\2\2\u0cbf\u0cb9\3\2\2\2\u0cbf\u0cbd\3\2"+
		"\2\2\u0cbf\u0cbe\3\2\2\2\u0cc0\u00bd\3\2\2\2\u0cc1\u0cc2\7\u015a\2\2\u0cc2"+
		"\u0cc3\7\u0169\2\2\u0cc3\u0cc4\7\u015b\2\2\u0cc4\u00bf\3\2\2\2\u0cc5\u0cc6"+
		"\7\u00d9\2\2\u0cc6\u0cc8\7\u0093\2\2\u0cc7\u0cc9\5\u00be`\2\u0cc8\u0cc7"+
		"\3\2\2\2\u0cc8\u0cc9\3\2\2\2\u0cc9\u0ce9\3\2\2\2\u0cca\u0ccb\7\u00d9\2"+
		"\2\u0ccb\u0ccd\7\u0137\2\2\u0ccc\u0cce\5\u00be`\2\u0ccd\u0ccc\3\2\2\2"+
		"\u0ccd\u0cce\3\2\2\2\u0cce\u0ce9\3\2\2\2\u0ccf\u0cd1\7\u0139\2\2\u0cd0"+
		"\u0cd2\5\u00be`\2\u0cd1\u0cd0\3\2\2\2\u0cd1\u0cd2\3\2\2\2\u0cd2\u0ce9"+
		"\3\2\2\2\u0cd3\u0cd4\7\u00d9\2\2\u0cd4\u0cd5\7\u0093\2\2\u0cd5\u0cd7\7"+
		"\u011a\2\2\u0cd6\u0cd8\5\u00be`\2\u0cd7\u0cd6\3\2\2\2\u0cd7\u0cd8\3\2"+
		"\2\2\u0cd8\u0ce9\3\2\2\2\u0cd9\u0cda\7\u00d9\2\2\u0cda\u0cdb\7\u0137\2"+
		"\2\u0cdb\u0cdd\7\u011a\2\2\u0cdc\u0cde\5\u00be`\2\u0cdd\u0cdc\3\2\2\2"+
		"\u0cdd\u0cde\3\2\2\2\u0cde\u0ce9\3\2\2\2\u0cdf\u0ce0\7\u0139\2\2\u0ce0"+
		"\u0ce2\7\u011a\2\2\u0ce1\u0ce3\5\u00be`\2\u0ce2\u0ce1\3\2\2\2\u0ce2\u0ce3"+
		"\3\2\2\2\u0ce3\u0ce9\3\2\2\2\u0ce4\u0ce6\7\u013a\2\2\u0ce5\u0ce7\5\u00be"+
		"`\2\u0ce6\u0ce5\3\2\2\2\u0ce6\u0ce7\3\2\2\2\u0ce7\u0ce9\3\2\2\2\u0ce8"+
		"\u0cc5\3\2\2\2\u0ce8\u0cca\3\2\2\2\u0ce8\u0ccf\3\2\2\2\u0ce8\u0cd3\3\2"+
		"\2\2\u0ce8\u0cd9\3\2\2\2\u0ce8\u0cdf\3\2\2\2\u0ce8\u0ce4\3\2\2\2\u0ce9"+
		"\u00c1\3\2\2\2\u0cea\u0cec\7\u0144\2\2\u0ceb\u0ced\5\u00be`\2\u0cec\u0ceb"+
		"\3\2\2\2\u0cec\u0ced\3\2\2\2\u0ced\u0cf3\3\2\2\2\u0cee\u0cf0\7\u0145\2"+
		"\2\u0cef\u0cf1\5\u00be`\2\u0cf0\u0cef\3\2\2\2\u0cf0\u0cf1\3\2\2\2\u0cf1"+
		"\u0cf3\3\2\2\2\u0cf2\u0cea\3\2\2\2\u0cf2\u0cee\3\2\2\2\u0cf3\u00c3\3\2"+
		"\2\2\u0cf4\u0cf7\5\u00c6d\2\u0cf5\u0cf7\5\u00c8e\2\u0cf6\u0cf4\3\2\2\2"+
		"\u0cf6\u0cf5\3\2\2\2\u0cf7\u00c5\3\2\2\2\u0cf8\u0cfa\7\u0135\2\2\u0cf9"+
		"\u0cfb\5\u00caf\2\u0cfa\u0cf9\3\2\2\2\u0cfa\u0cfb\3\2\2\2\u0cfb\u0d0e"+
		"\3\2\2\2\u0cfc\u0cfe\7\u0136\2\2\u0cfd\u0cff\5\u00caf\2\u0cfe\u0cfd\3"+
		"\2\2\2\u0cfe\u0cff\3\2\2\2\u0cff\u0d0e\3\2\2\2\u0d00\u0d02\7\u00a5\2\2"+
		"\u0d01\u0d03\5\u00caf\2\u0d02\u0d01\3\2\2\2\u0d02\u0d03\3\2\2\2\u0d03"+
		"\u0d0e\3\2\2\2\u0d04\u0d0e\7\u0126\2\2\u0d05\u0d0e\7\u012a\2\2\u0d06\u0d0e"+
		"\7\u0127\2\2\u0d07\u0d0e\7\u012b\2\2\u0d08\u0d0e\7\u0128\2\2\u0d09\u0d0e"+
		"\7\u012c\2\2\u0d0a\u0d0e\7\u012d\2\2\u0d0b\u0d0e\7\u0129\2\2\u0d0c\u0d0e"+
		"\7\u012e\2\2\u0d0d\u0cf8\3\2\2\2\u0d0d\u0cfc\3\2\2\2\u0d0d\u0d00\3\2\2"+
		"\2\u0d0d\u0d04\3\2\2\2\u0d0d\u0d05\3\2\2\2\u0d0d\u0d06\3\2\2\2\u0d0d\u0d07"+
		"\3\2\2\2\u0d0d\u0d08\3\2\2\2\u0d0d\u0d09\3\2\2\2\u0d0d\u0d0a\3\2\2\2\u0d0d"+
		"\u0d0b\3\2\2\2\u0d0d\u0d0c\3\2\2\2\u0d0e\u00c7\3\2\2\2\u0d0f\u0d11\7\u0133"+
		"\2\2\u0d10\u0d12\5\u00caf\2\u0d11\u0d10\3\2\2\2\u0d11\u0d12\3\2\2\2\u0d12"+
		"\u0d1a\3\2\2\2\u0d13\u0d1a\7\u012f\2\2\u0d14\u0d1a\7\u0131\2\2\u0d15\u0d1a"+
		"\7\u0130\2\2\u0d16\u0d1a\7\u0134\2\2\u0d17\u0d18\7\u0134\2\2\u0d18\u0d1a"+
		"\7\u00eb\2\2\u0d19\u0d0f\3\2\2\2\u0d19\u0d13\3\2\2\2\u0d19\u0d14\3\2\2"+
		"\2\u0d19\u0d15\3\2\2\2\u0d19\u0d16\3\2\2\2\u0d19\u0d17\3\2\2\2\u0d1a\u00c9"+
		"\3\2\2\2\u0d1b\u0d1c\7\u015a\2\2\u0d1c\u0d1d\7\u0169\2\2\u0d1d\u0d24\7"+
		"\u015b\2\2\u0d1e\u0d1f\7\u015a\2\2\u0d1f\u0d20\7\u0169\2\2\u0d20\u0d21"+
		"\7\u0153\2\2\u0d21\u0d22\7\u0169\2\2\u0d22\u0d24\7\u015b\2\2\u0d23\u0d1b"+
		"\3\2\2\2\u0d23\u0d1e\3\2\2\2\u0d24\u00cb\3\2\2\2\u0d25\u0d26\t\26\2\2"+
		"\u0d26\u00cd\3\2\2\2\u0d27\u0d39\7\u013b\2\2\u0d28\u0d39\7\u013c\2\2\u0d29"+
		"\u0d2a\7\u013c\2\2\u0d2a\u0d2b\7\u0087\2\2\u0d2b\u0d2c\7\u013c\2\2\u0d2c"+
		"\u0d39\7\u0121\2\2\u0d2d\u0d39\7\u013d\2\2\u0d2e\u0d39\7\u013e\2\2\u0d2f"+
		"\u0d30\7\u013e\2\2\u0d30\u0d31\7\u0087\2\2\u0d31\u0d32\7\u013c\2\2\u0d32"+
		"\u0d39\7\u0121\2\2\u0d33\u0d34\7\u013e\2\2\u0d34\u0d35\7\u0088\2\2\u0d35"+
		"\u0d36\7\u013c\2\2\u0d36\u0d39\7\u0121\2\2\u0d37\u0d39\7\u013f\2\2\u0d38"+
		"\u0d27\3\2\2\2\u0d38\u0d28\3\2\2\2\u0d38\u0d29\3\2\2\2\u0d38\u0d2d\3\2"+
		"\2\2\u0d38\u0d2e\3\2\2\2\u0d38\u0d2f\3\2\2\2\u0d38\u0d33\3\2\2\2\u0d38"+
		"\u0d37\3\2\2\2\u0d39\u00cf\3\2\2\2\u0d3a\u0d3c\7\u0124\2\2\u0d3b\u0d3d"+
		"\5\u00be`\2\u0d3c\u0d3b\3\2\2\2\u0d3c\u0d3d\3\2\2\2\u0d3d\u0d48\3\2\2"+
		"\2\u0d3e\u0d40\7\u0125\2\2\u0d3f\u0d41\5\u00be`\2\u0d40\u0d3f\3\2\2\2"+
		"\u0d40\u0d41\3\2\2\2\u0d41\u0d48\3\2\2\2\u0d42\u0d43\7\u0124\2\2\u0d43"+
		"\u0d45\7\u011a\2\2\u0d44\u0d46\5\u00be`\2\u0d45\u0d44\3\2\2\2\u0d45\u0d46"+
		"\3\2\2\2\u0d46\u0d48\3\2\2\2\u0d47\u0d3a\3\2\2\2\u0d47\u0d3e\3\2\2\2\u0d47"+
		"\u0d42\3\2\2\2\u0d48\u00d1\3\2\2\2\u0d49\u0d4b\7\u0142\2\2\u0d4a\u0d4c"+
		"\5\u00be`\2\u0d4b\u0d4a\3\2\2\2\u0d4b\u0d4c\3\2\2\2\u0d4c\u0d57\3\2\2"+
		"\2\u0d4d\u0d4e\7\u0142\2\2\u0d4e\u0d50\7\u011a\2\2\u0d4f\u0d51\5\u00be"+
		"`\2\u0d50\u0d4f\3\2\2\2\u0d50\u0d51\3\2\2\2\u0d51\u0d57\3\2\2\2\u0d52"+
		"\u0d54\7\u0143\2\2\u0d53\u0d55\5\u00be`\2\u0d54\u0d53\3\2\2\2\u0d54\u0d55"+
		"\3\2\2\2\u0d55\u0d57\3\2\2\2\u0d56\u0d49\3\2\2\2\u0d56\u0d4d\3\2\2\2\u0d56"+
		"\u0d52\3\2\2\2\u0d57\u00d3\3\2\2\2\u0d58\u0d5b\5\u00d6l\2\u0d59\u0d5b"+
		"\5\u00d8m\2\u0d5a\u0d58\3\2\2\2\u0d5a\u0d59\3\2\2\2\u0d5b\u00d5\3\2\2"+
		"\2\u0d5c\u0d5f\7\u015a\2\2\u0d5d\u0d60\n\27\2\2\u0d5e\u0d60\5\u0104\u0083"+
		"\2\u0d5f\u0d5d\3\2\2\2\u0d5f\u0d5e\3\2\2\2\u0d60\u0d61\3\2\2\2\u0d61\u0d5f"+
		"\3\2\2\2\u0d61\u0d62\3\2\2\2\u0d62\u0d63\3\2\2\2\u0d63\u0d64\7\u015b\2"+
		"\2\u0d64\u00d7\3\2\2\2\u0d65\u0d6e\5\u00dan\2\u0d66\u0d6e\5\u01b2\u00da"+
		"\2\u0d67\u0d6e\5\u00e0q\2\u0d68\u0d6e\5\u01ba\u00de\2\u0d69\u0d6e\5\u00ec"+
		"w\2\u0d6a\u0d6e\5\u00fe\u0080\2\u0d6b\u0d6e\5\u01ee\u00f8\2\u0d6c\u0d6e"+
		"\7Q\2\2\u0d6d\u0d65\3\2\2\2\u0d6d\u0d66\3\2\2\2\u0d6d\u0d67\3\2\2\2\u0d6d"+
		"\u0d68\3\2\2\2\u0d6d\u0d69\3\2\2\2\u0d6d\u0d6a\3\2\2\2\u0d6d\u0d6b\3\2"+
		"\2\2\u0d6d\u0d6c\3\2\2\2\u0d6e\u00d9\3\2\2\2\u0d6f\u0d70\5\u00a6T\2\u0d70"+
		"\u00db\3\2\2\2\u0d71\u0d72\t\30\2\2\u0d72\u00dd\3\2\2\2\u0d73\u0d75\5"+
		"\u0114\u008b\2\u0d74\u0d73\3\2\2\2\u0d74\u0d75\3\2\2\2\u0d75\u0d76\3\2"+
		"\2\2\u0d76\u0d77\5\u00dco\2\u0d77\u00df\3\2\2\2\u0d78\u0d79\5\u00e2r\2"+
		"\u0d79\u00e1\3\2\2\2\u0d7a\u0d7b\7\u009f\2\2\u0d7b\u0d7c\7\u015a\2\2\u0d7c"+
		"\u0d7d\7\u015e\2\2\u0d7d\u0d83\7\u015b\2\2\u0d7e\u0d80\5\u00e4s\2\u0d7f"+
		"\u0d81\5\u00e8u\2\u0d80\u0d7f\3\2\2\2\u0d80\u0d81\3\2\2\2\u0d81\u0d83"+
		"\3\2\2\2\u0d82\u0d7a\3\2\2\2\u0d82\u0d7e\3\2\2\2\u0d83\u00e3\3\2\2\2\u0d84"+
		"\u0d85\5\u00e6t\2\u0d85\u0d87\7\u015a\2\2\u0d86\u0d88\5\u01b0\u00d9\2"+
		"\u0d87\u0d86\3\2\2\2\u0d87\u0d88\3\2\2\2\u0d88\u0d89\3\2\2\2\u0d89\u0d8a"+
		"\5\u0104\u0083\2\u0d8a\u0d8b\7\u015b\2\2\u0d8b\u00e5\3\2\2\2\u0d8c\u0d8d"+
		"\t\31\2\2\u0d8d\u00e7\3\2\2\2\u0d8e\u0d8f\7\u00b6\2\2\u0d8f\u0d90\7\u015a"+
		"\2\2\u0d90\u0d91\7\u0086\2\2\u0d91\u0d92\5\u017a\u00be\2\u0d92\u0d93\7"+
		"\u015b\2\2\u0d93\u00e9\3\2\2\2\u0d94\u0d95\7\u00ba\2\2\u0d95\u0d96\7\u015a"+
		"\2\2\u0d96\u0d97\5\u01b8\u00dd\2\u0d97\u0d98\7\u015b\2\2\u0d98\u00eb\3"+
		"\2\2\2\u0d99\u0d9a\5\u00f0y\2\u0d9a\u00ed\3\2\2\2\u0d9b\u0d9c\7\u00dc"+
		"\2\2\u0d9c\u0d9d\7\u015a\2\2\u0d9d\u0d9e\5\u010a\u0086\2\u0d9e\u0d9f\7"+
		"\u0153\2\2\u0d9f\u0da0\5\u0130\u0099\2\u0da0\u0da1\7\u015b\2\2\u0da1\u0dae"+
		"\3\2\2\2\u0da2\u0da3\7\u0097\2\2\u0da3\u0da4\7\u015a\2\2\u0da4\u0da7\5"+
		"\u010a\u0086\2\u0da5\u0da6\7\u0153\2\2\u0da6\u0da8\5\u0130\u0099\2\u0da7"+
		"\u0da5\3\2\2\2\u0da8\u0da9\3\2\2\2\u0da9\u0da7\3\2\2\2\u0da9\u0daa\3\2"+
		"\2\2\u0daa\u0dab\3\2\2\2\u0dab\u0dac\7\u015b\2\2\u0dac\u0dae\3\2\2\2\u0dad"+
		"\u0d9b\3\2\2\2\u0dad\u0da2\3\2\2\2\u0dae\u00ef\3\2\2\2\u0daf\u0db2\5\u00f2"+
		"z\2\u0db0\u0db2\5\u00f4{\2\u0db1\u0daf\3\2\2\2\u0db1\u0db0\3\2\2\2\u0db2"+
		"\u00f1\3\2\2\2\u0db3\u0db4\7\20\2\2\u0db4\u0db6\5\u0130\u0099\2\u0db5"+
		"\u0db7\5\u00f6|\2\u0db6\u0db5\3\2\2\2\u0db7\u0db8\3\2\2\2\u0db8\u0db6"+
		"\3\2\2\2\u0db8\u0db9\3\2\2\2\u0db9\u0dbb\3\2\2\2\u0dba\u0dbc\5\u00fa~"+
		"\2\u0dbb\u0dba\3\2\2\2\u0dbb\u0dbc\3\2\2\2\u0dbc\u0dbd\3\2\2\2\u0dbd\u0dbe"+
		"\7%\2\2\u0dbe\u00f3\3\2\2\2\u0dbf\u0dc1\7\20\2\2\u0dc0\u0dc2\5\u00f8}"+
		"\2\u0dc1\u0dc0\3\2\2\2\u0dc2\u0dc3\3\2\2\2\u0dc3\u0dc1\3\2\2\2\u0dc3\u0dc4"+
		"\3\2\2\2\u0dc4\u0dc6\3\2\2\2\u0dc5\u0dc7\5\u00fa~\2\u0dc6\u0dc5\3\2\2"+
		"\2\u0dc6\u0dc7\3\2\2\2\u0dc7\u0dc8\3\2\2\2\u0dc8\u0dc9\7%\2\2\u0dc9\u00f5"+
		"\3\2\2\2\u0dca\u0dcb\7\u0085\2\2\u0dcb\u0dcc\5\u017a\u00be\2\u0dcc\u0dcd"+
		"\7w\2\2\u0dcd\u0dce\5\u00fc\177\2\u0dce\u00f7\3\2\2\2\u0dcf\u0dd0\7\u0085"+
		"\2\2\u0dd0\u0dd1\5\u017a\u00be\2\u0dd1\u0dd2\7w\2\2\u0dd2\u0dd3\5\u00fc"+
		"\177\2\u0dd3\u00f9\3\2\2\2\u0dd4\u0dd5\7&\2\2\u0dd5\u0dd6\5\u00fc\177"+
		"\2\u0dd6\u00fb\3\2\2\2\u0dd7\u0dda\5\u0104\u0083\2\u0dd8\u0dda\7Q\2\2"+
		"\u0dd9\u0dd7\3\2\2\2\u0dd9\u0dd8\3\2\2\2\u0dda\u00fd\3\2\2\2\u0ddb\u0ddc"+
		"\7\22\2\2\u0ddc\u0ddd\7\u015a\2\2\u0ddd\u0dde\5\u0100\u0081\2\u0dde\u0ddf"+
		"\7\6\2\2\u0ddf\u0de0\5\u0102\u0082\2\u0de0\u0de1\7\u015b\2\2\u0de1\u00ff"+
		"\3\2\2\2\u0de2\u0de3\5\u0104\u0083\2\u0de3\u0101\3\2\2\2\u0de4\u0de5\5"+
		"\u00b4[\2\u0de5\u0103\3\2\2\2\u0de6\u0deb\5\u0108\u0085\2\u0de7\u0deb"+
		"\5\u0144\u00a3\2\u0de8\u0deb\5\u0130\u0099\2\u0de9\u0deb\5\u0106\u0084"+
		"\2\u0dea\u0de6\3\2\2\2\u0dea\u0de7\3\2\2\2\u0dea\u0de8\3\2\2\2\u0dea\u0de9"+
		"\3\2\2\2\u0deb\u0105\3\2\2\2\u0dec\u0ded\7\u008b\2\2\u0ded\u0dee\7\u0167"+
		"\2\2\u0dee\u0df3\5\u0104\u0083\2\u0def\u0df0\7\u0153\2\2\u0df0\u0df2\5"+
		"\u0104\u0083\2\u0df1\u0def\3\2\2\2\u0df2\u0df5\3\2\2\2\u0df3\u0df1\3\2"+
		"\2\2\u0df3\u0df4\3\2\2\2\u0df4\u0df6\3\2\2\2\u0df5\u0df3\3\2\2\2\u0df6"+
		"\u0df7\7\u0168\2\2\u0df7\u0107\3\2\2\2\u0df8\u0dfc\5\u010a\u0086\2\u0df9"+
		"\u0dfc\5\u0120\u0091\2\u0dfa\u0dfc\7Q\2\2\u0dfb\u0df8\3\2\2\2\u0dfb\u0df9"+
		"\3\2\2\2\u0dfb\u0dfa\3\2\2\2\u0dfc\u0109\3\2\2\2\u0dfd\u0e02\5\u010c\u0087"+
		"\2\u0dfe\u0dff\t\32\2\2\u0dff\u0e01\5\u010c\u0087\2\u0e00\u0dfe\3\2\2"+
		"\2\u0e01\u0e04\3\2\2\2\u0e02\u0e00\3\2\2\2\u0e02\u0e03\3\2\2\2\u0e03\u010b"+
		"\3\2\2\2\u0e04\u0e02\3\2\2\2\u0e05\u0e0a\5\u010e\u0088\2\u0e06\u0e07\t"+
		"\33\2\2\u0e07\u0e09\5\u010e\u0088\2\u0e08\u0e06\3\2\2\2\u0e09\u0e0c\3"+
		"\2\2\2\u0e0a\u0e08\3\2\2\2\u0e0a\u0e0b\3\2\2\2\u0e0b\u010d\3\2\2\2\u0e0c"+
		"\u0e0a\3\2\2\2\u0e0d\u0e0f\5\u0114\u008b\2\u0e0e\u0e0d\3\2\2\2\u0e0e\u0e0f"+
		"\3\2\2\2\u0e0f\u0e10\3\2\2\2\u0e10\u0e11\5\u0112\u008a\2\u0e11\u010f\3"+
		"\2\2\2\u0e12\u0e13\7\u015a\2\2\u0e13\u0e18\5\u010a\u0086\2\u0e14\u0e15"+
		"\7\u0153\2\2\u0e15\u0e17\5\u010a\u0086\2\u0e16\u0e14\3\2\2\2\u0e17\u0e1a"+
		"\3\2\2\2\u0e18\u0e16\3\2\2\2\u0e18\u0e19\3\2\2\2\u0e19\u0e1b\3\2\2\2\u0e1a"+
		"\u0e18\3\2\2\2\u0e1b\u0e1c\7\u015b\2\2\u0e1c\u0111\3\2\2\2\u0e1d\u0e22"+
		"\5\u00d4k\2\u0e1e\u0e1f\7\u014e\2\2\u0e1f\u0e21\5\u0102\u0082\2\u0e20"+
		"\u0e1e\3\2\2\2\u0e21\u0e24\3\2\2\2\u0e22\u0e20\3\2\2\2\u0e22\u0e23\3\2"+
		"\2\2\u0e23\u0e27\3\2\2\2\u0e24\u0e22\3\2\2\2\u0e25\u0e27\5\u0116\u008c"+
		"\2\u0e26\u0e1d\3\2\2\2\u0e26\u0e25\3\2\2\2\u0e27\u0113\3\2\2\2\u0e28\u0e29"+
		"\t\32\2\2\u0e29\u0115\3\2\2\2\u0e2a\u0e2b\5\u0118\u008d\2\u0e2b\u0117"+
		"\3\2\2\2\u0e2c\u0e2d\7\u00b4\2\2\u0e2d\u0e2e\7\u015a\2\2\u0e2e\u0e2f\5"+
		"\u011a\u008e\2\u0e2f\u0e30\7\62\2\2\u0e30\u0e31\5\u011e\u0090\2\u0e31"+
		"\u0e32\7\u015b\2\2\u0e32\u0119\3\2\2\2\u0e33\u0e37\5\u01e8\u00f5\2\u0e34"+
		"\u0e37\5\u011c\u008f\2\u0e35\u0e37\5\u01ec\u00f7\2\u0e36\u0e33\3\2\2\2"+
		"\u0e36\u0e34\3\2\2\2\u0e36\u0e35\3\2\2\2\u0e37\u011b\3\2\2\2\u0e38\u0e39"+
		"\t\34\2\2\u0e39\u011d\3\2\2\2\u0e3a\u0e3d\5\u01b2\u00da\2\u0e3b\u0e3d"+
		"\5\u00aaV\2\u0e3c\u0e3a\3\2\2\2\u0e3c\u0e3b\3\2\2\2\u0e3d\u011f\3\2\2"+
		"\2\u0e3e\u0e3f\5\u0122\u0092\2\u0e3f\u0121\3\2\2\2\u0e40\u0e45\5\u0124"+
		"\u0093\2\u0e41\u0e42\7\u0154\2\2\u0e42\u0e44\5\u0124\u0093\2\u0e43\u0e41"+
		"\3\2\2\2\u0e44\u0e47\3\2\2\2\u0e45\u0e43\3\2\2\2\u0e45\u0e46\3\2\2\2\u0e46"+
		"\u0123\3\2\2\2\u0e47\u0e45\3\2\2\2\u0e48\u0e49\5\u0126\u0094\2\u0e49\u0125"+
		"\3\2\2\2\u0e4a\u0e4d\5\u00d4k\2\u0e4b\u0e4d\5\u0128\u0095\2\u0e4c\u0e4a"+
		"\3\2\2\2\u0e4c\u0e4b\3\2\2\2\u0e4d\u0127\3\2\2\2\u0e4e\u0e4f\5\u012a\u0096"+
		"\2\u0e4f\u0129\3\2\2\2\u0e50\u0e51\7\u010e\2\2\u0e51\u0e52\7\u015a\2\2"+
		"\u0e52\u0e53\5\u012c\u0097\2\u0e53\u0e54\7\u015b\2\2\u0e54\u012b\3\2\2"+
		"\2\u0e55\u0e57\5\u012e\u0098\2\u0e56\u0e55\3\2\2\2\u0e56\u0e57\3\2\2\2"+
		"\u0e57\u0e59\3\2\2\2\u0e58\u0e5a\5\u0122\u0092\2\u0e59\u0e58\3\2\2\2\u0e59"+
		"\u0e5a\3\2\2\2\u0e5a\u0e5b\3\2\2\2\u0e5b\u0e5d\7\62\2\2\u0e5c\u0e56\3"+
		"\2\2\2\u0e5c\u0e5d\3\2\2\2\u0e5d\u0e5e\3\2\2\2\u0e5e\u0e64\5\u0122\u0092"+
		"\2\u0e5f\u0e60\5\u0122\u0092\2\u0e60\u0e61\7\u0153\2\2\u0e61\u0e62\5\u0122"+
		"\u0092\2\u0e62\u0e64\3\2\2\2\u0e63\u0e5c\3\2\2\2\u0e63\u0e5f\3\2\2\2\u0e64"+
		"\u012d\3\2\2\2\u0e65\u0e66\t\35\2\2\u0e66\u012f\3\2\2\2\u0e67\u0e68\5"+
		"\u0132\u009a\2\u0e68\u0131\3\2\2\2\u0e69\u0e6e\5\u0134\u009b\2\u0e6a\u0e6b"+
		"\7W\2\2\u0e6b\u0e6d\5\u0132\u009a\2\u0e6c\u0e6a\3\2\2\2\u0e6d\u0e70\3"+
		"\2\2\2\u0e6e\u0e6c\3\2\2\2\u0e6e\u0e6f\3\2\2\2\u0e6f\u0133\3\2\2\2\u0e70"+
		"\u0e6e\3\2\2\2\u0e71\u0e76\5\u0136\u009c\2\u0e72\u0e73\7\t\2\2\u0e73\u0e75"+
		"\5\u0134\u009b\2\u0e74\u0e72\3\2\2\2\u0e75\u0e78\3\2\2\2\u0e76\u0e74\3"+
		"\2\2\2\u0e76\u0e77\3\2\2\2\u0e77\u0135\3\2\2\2\u0e78\u0e76\3\2\2\2\u0e79"+
		"\u0e7d\5\u0138\u009d\2\u0e7a\u0e7b\7P\2\2\u0e7b\u0e7d\5\u0138\u009d\2"+
		"\u0e7c\u0e79\3\2\2\2\u0e7c\u0e7a\3\2\2\2\u0e7d\u0137\3\2\2\2\u0e7e\u0e80"+
		"\5\u013e\u00a0\2\u0e7f\u0e81\5\u013a\u009e\2\u0e80\u0e7f\3\2\2\2\u0e80"+
		"\u0e81\3\2\2\2\u0e81\u0139\3\2\2\2\u0e82\u0e84\7G\2\2\u0e83\u0e85\7P\2"+
		"\2\u0e84\u0e83\3\2\2\2\u0e84\u0e85\3\2\2\2\u0e85\u0e86\3\2\2\2\u0e86\u0e87"+
		"\5\u013c\u009f\2\u0e87\u013b\3\2\2\2\u0e88\u0e89\t\25\2\2\u0e89\u013d"+
		"\3\2\2\2\u0e8a\u0e8d\5\u01c2\u00e2\2\u0e8b\u0e8d\5\u0140\u00a1\2\u0e8c"+
		"\u0e8a\3\2\2\2\u0e8c\u0e8b\3\2\2\2\u0e8d\u013f\3\2\2\2\u0e8e\u0e91\5\u0142"+
		"\u00a2\2\u0e8f\u0e91\5\u00d8m\2\u0e90\u0e8e\3\2\2\2\u0e90\u0e8f\3\2\2"+
		"\2\u0e91\u0141\3\2\2\2\u0e92\u0e93\7\u015a\2\2\u0e93\u0e94\5\u0130\u0099"+
		"\2\u0e94\u0e95\7\u015b\2\2\u0e95\u0143\3\2\2\2\u0e96\u0e99\5\u0146\u00a4"+
		"\2\u0e97\u0e99\5\u0148\u00a5\2\u0e98\u0e96\3\2\2\2\u0e98\u0e97\3\2\2\2"+
		"\u0e99\u0145\3\2\2\2\u0e9a\u0e9b\5\u00d8m\2\u0e9b\u0147\3\2\2\2\u0e9c"+
		"\u0e9d\7Q\2\2\u0e9d\u0149\3\2\2\2\u0e9e\u0ea1\5\u0146\u00a4\2\u0e9f\u0ea1"+
		"\5\u014c\u00a7\2\u0ea0\u0e9e\3\2\2\2\u0ea0\u0e9f\3\2\2\2\u0ea1\u014b\3"+
		"\2\2\2\u0ea2\u0ea5\5\u0108\u0085\2\u0ea3\u0ea5\5\u0140\u00a1\2\u0ea4\u0ea2"+
		"\3\2\2\2\u0ea4\u0ea3\3\2\2\2\u0ea5\u014d\3\2\2\2\u0ea6\u0ea8\5\u0150\u00a9"+
		"\2\u0ea7\u0ea9\5\u0178\u00bd\2\u0ea8\u0ea7\3\2\2\2\u0ea8\u0ea9\3\2\2\2"+
		"\u0ea9\u0eab\3\2\2\2\u0eaa\u0eac\5\u017c\u00bf\2\u0eab\u0eaa\3\2\2\2\u0eab"+
		"\u0eac\3\2\2\2\u0eac\u0eae\3\2\2\2\u0ead\u0eaf\5\u018c\u00c7\2\u0eae\u0ead"+
		"\3\2\2\2\u0eae\u0eaf\3\2\2\2\u0eaf\u0eb1\3\2\2\2\u0eb0\u0eb2\5\u01f6\u00fc"+
		"\2\u0eb1\u0eb0\3\2\2\2\u0eb1\u0eb2\3\2\2\2\u0eb2\u0eb4\3\2\2\2\u0eb3\u0eb5"+
		"\5\u0200\u0101\2\u0eb4\u0eb3\3\2\2\2\u0eb4\u0eb5\3\2\2\2\u0eb5\u014f\3"+
		"\2\2\2\u0eb6\u0eb7\7\62\2\2\u0eb7\u0eba\7\u015a\2\2\u0eb8\u0ebb\5\u0152"+
		"\u00aa\2\u0eb9\u0ebb\5\u01a6\u00d4\2\u0eba\u0eb8\3\2\2\2\u0eba\u0eb9\3"+
		"\2\2\2\u0ebb\u0ebc\3\2\2\2\u0ebc\u0ebe\7\u015b\2\2\u0ebd\u0ebf\5\u01b4"+
		"\u00db\2\u0ebe\u0ebd\3\2\2\2\u0ebe\u0ebf\3\2\2\2\u0ebf\u0151\3\2\2\2\u0ec0"+
		"\u0ec5\5\u0154\u00ab\2\u0ec1\u0ec2\7\u0153\2\2\u0ec2\u0ec4\5\u0154\u00ab"+
		"\2\u0ec3\u0ec1\3\2\2\2\u0ec4\u0ec7\3\2\2\2\u0ec5\u0ec3\3\2\2\2\u0ec5\u0ec6"+
		"\3\2\2\2\u0ec6\u0153\3\2\2\2\u0ec7\u0ec5\3\2\2\2\u0ec8\u0ecb\5\u0156\u00ac"+
		"\2\u0ec9\u0ecb\5\u016e\u00b8\2\u0eca\u0ec8\3\2\2\2\u0eca\u0ec9\3\2\2\2"+
		"\u0ecb\u0155\3\2\2\2\u0ecc\u0ece\5\u016e\u00b8\2\u0ecd\u0ecf\5\u0158\u00ad"+
		"\2\u0ece\u0ecd\3\2\2\2\u0ecf\u0ed0\3\2\2\2\u0ed0\u0ece\3\2\2\2\u0ed0\u0ed1"+
		"\3\2\2\2\u0ed1\u0157\3\2\2\2\u0ed2\u0ed3\7\32\2\2\u0ed3\u0ed4\7H\2\2\u0ed4"+
		"\u0ee6\5\u016e\u00b8\2\u0ed5\u0ed7\5\u0162\u00b2\2\u0ed6\u0ed5\3\2\2\2"+
		"\u0ed6\u0ed7\3\2\2\2\u0ed7\u0ed8\3\2\2\2\u0ed8\u0ed9\7H\2\2\u0ed9\u0eda"+
		"\5\u016e\u00b8\2\u0eda\u0edb\5\u0168\u00b5\2\u0edb\u0ee6\3\2\2\2\u0edc"+
		"\u0ede\7O\2\2\u0edd\u0edf\5\u0162\u00b2\2\u0ede\u0edd\3\2\2\2\u0ede\u0edf"+
		"\3\2\2\2\u0edf\u0ee0\3\2\2\2\u0ee0\u0ee1\7H\2\2\u0ee1\u0ee6\5\u016e\u00b8"+
		"\2\u0ee2\u0ee3\7}\2\2\u0ee3\u0ee4\7H\2\2\u0ee4\u0ee6\5\u016e\u00b8\2\u0ee5"+
		"\u0ed2\3\2\2\2\u0ee5\u0ed6\3\2\2\2\u0ee5\u0edc\3\2\2\2\u0ee5\u0ee2\3\2"+
		"\2\2\u0ee6\u0159\3\2\2\2\u0ee7\u0ee8\7\32\2\2\u0ee8\u0ee9\7H\2\2\u0ee9"+
		"\u0eea\5\u016e\u00b8\2\u0eea\u015b\3\2\2\2\u0eeb\u0eed\5\u0162\u00b2\2"+
		"\u0eec\u0eeb\3\2\2\2\u0eec\u0eed\3\2\2\2\u0eed\u0eee\3\2\2\2\u0eee\u0eef"+
		"\7H\2\2\u0eef\u0ef0\5\u016e\u00b8\2\u0ef0\u0ef1\5\u0168\u00b5\2\u0ef1"+
		"\u015d\3\2\2\2\u0ef2\u0ef4\7O\2\2\u0ef3\u0ef5\5\u0162\u00b2\2\u0ef4\u0ef3"+
		"\3\2\2\2\u0ef4\u0ef5\3\2\2\2\u0ef5\u0ef6\3\2\2\2\u0ef6\u0ef7\7H\2\2\u0ef7"+
		"\u0ef8\5\u016e\u00b8\2\u0ef8\u015f\3\2\2\2\u0ef9\u0efa\7}\2\2\u0efa\u0efb"+
		"\7H\2\2\u0efb\u0efc\5\u016e\u00b8\2\u0efc\u0161\3\2\2\2\u0efd\u0f00\7"+
		"A\2\2\u0efe\u0f00\5\u0164\u00b3\2\u0eff\u0efd\3\2\2\2\u0eff\u0efe\3\2"+
		"\2\2\u0f00\u0163\3\2\2\2\u0f01\u0f03\5\u0166\u00b4\2\u0f02\u0f04\7T\2"+
		"\2\u0f03\u0f02\3\2\2\2\u0f03\u0f04\3\2\2\2\u0f04\u0165\3\2\2\2\u0f05\u0f06"+
		"\t\36\2\2\u0f06\u0167\3\2\2\2\u0f07\u0f0a\5\u016a\u00b6\2\u0f08\u0f0a"+
		"\5\u016c\u00b7\2\u0f09\u0f07\3\2\2\2\u0f09\u0f08\3\2\2\2\u0f0a\u0169\3"+
		"\2\2\2\u0f0b\u0f0c\7\u00e0\2\2\u0f0c\u0f0d\5\u017a\u00be\2\u0f0d\u016b"+
		"\3\2\2\2\u0f0e\u0f0f\7\u0081\2\2\u0f0f\u0f10\7\u015a\2\2\u0f10\u0f11\5"+
		"\u01b8\u00dd\2\u0f11\u0f12\7\u015b\2\2\u0f12\u016d\3\2\2\2\u0f13\u0f16"+
		"\5\u0174\u00bb\2\u0f14\u0f16\5\u01a2\u00d2\2\u0f15\u0f13\3\2\2\2\u0f15"+
		"\u0f14\3\2\2\2\u0f16\u0f1b\3\2\2\2\u0f17\u0f19\7\6\2\2\u0f18\u0f17\3\2"+
		"\2\2\u0f18\u0f19\3\2\2\2\u0f19\u0f1a\3\2\2\2\u0f1a\u0f1c\5\u0172\u00ba"+
		"\2\u0f1b\u0f18\3\2\2\2\u0f1b\u0f1c\3\2\2\2\u0f1c\u0f21\3\2\2\2\u0f1d\u0f1e"+
		"\7\u015a\2\2\u0f1e\u0f1f\5\u0170\u00b9\2\u0f1f\u0f20\7\u015b\2\2\u0f20"+
		"\u0f22\3\2\2\2\u0f21\u0f1d\3\2\2\2\u0f21\u0f22\3\2\2\2\u0f22\u0f2f\3\2"+
		"\2\2\u0f23\u0f25\5\u0176\u00bc\2\u0f24\u0f26\7\6\2\2\u0f25\u0f24\3\2\2"+
		"\2\u0f25\u0f26\3\2\2\2\u0f26\u0f27\3\2\2\2\u0f27\u0f2c\5\u00a2R\2\u0f28"+
		"\u0f29\7\u015a\2\2\u0f29\u0f2a\5\u0170\u00b9\2\u0f2a\u0f2b\7\u015b\2\2"+
		"\u0f2b\u0f2d\3\2\2\2\u0f2c\u0f28\3\2\2\2\u0f2c\u0f2d\3\2\2\2\u0f2d\u0f2f"+
		"\3\2\2\2\u0f2e\u0f15\3\2\2\2\u0f2e\u0f23\3\2\2\2\u0f2f\u016f\3\2\2\2\u0f30"+
		"\u0f35\5\u00a2R\2\u0f31\u0f32\7\u0153\2\2\u0f32\u0f34\5\u00a2R\2\u0f33"+
		"\u0f31\3\2\2\2\u0f34\u0f37\3\2\2\2\u0f35\u0f33\3\2\2\2\u0f35\u0f36\3\2"+
		"\2\2\u0f36\u0171\3\2\2\2\u0f37\u0f35\3\2\2\2\u0f38\u0f3b\5\u01a4\u00d3"+
		"\2\u0f39\u0f3b\5\u0174\u00bb\2\u0f3a\u0f38\3\2\2\2\u0f3a\u0f39\3\2\2\2"+
		"\u0f3b\u0173\3\2\2\2\u0f3c\u0f3d\5\u01a4\u00d3\2\u0f3d\u0f46\7\u015a\2"+
		"\2\u0f3e\u0f43\5\u00a2R\2\u0f3f\u0f40\7\u0153\2\2\u0f40\u0f42\5\u00a2"+
		"R\2\u0f41\u0f3f\3\2\2\2\u0f42\u0f45\3\2\2\2\u0f43\u0f41\3\2\2\2\u0f43"+
		"\u0f44\3\2\2\2\u0f44\u0f47\3\2\2\2\u0f45\u0f43\3\2\2\2\u0f46\u0f3e\3\2"+
		"\2\2\u0f46\u0f47\3\2\2\2\u0f47\u0f48\3\2\2\2\u0f48\u0f49\7\u015b\2\2\u0f49"+
		"\u0175\3\2\2\2\u0f4a\u0f4b\5\u01be\u00e0\2\u0f4b\u0177\3\2\2\2\u0f4c\u0f4d"+
		"\7\u0086\2\2\u0f4d\u0f4e\5\u017a\u00be\2\u0f4e\u0179\3\2\2\2\u0f4f\u0f51"+
		"\7\u015a\2\2\u0f50\u0f4f\3\2\2\2\u0f50\u0f51\3\2\2\2\u0f51\u0f52\3\2\2"+
		"\2\u0f52\u0f54\5\u0104\u0083\2\u0f53\u0f55\7\u015b\2\2\u0f54\u0f53\3\2"+
		"\2\2\u0f54\u0f55\3\2\2\2\u0f55\u017b\3\2\2\2\u0f56\u0f57\7\65\2\2\u0f57"+
		"\u0f58\7\u008e\2\2\u0f58\u0f59\5\u017e\u00c0\2\u0f59\u017d\3\2\2\2\u0f5a"+
		"\u0f5f\5\u0180\u00c1\2\u0f5b\u0f5c\7\u0153\2\2\u0f5c\u0f5e\5\u0180\u00c1"+
		"\2\u0f5d\u0f5b\3\2\2\2\u0f5e\u0f61\3\2\2\2\u0f5f\u0f5d\3\2\2\2\u0f5f\u0f60"+
		"\3\2\2\2\u0f60\u017f\3\2\2\2\u0f61\u0f5f\3\2\2\2\u0f62\u0f67\5\u0186\u00c4"+
		"\2\u0f63\u0f67\5\u0188\u00c5\2\u0f64\u0f67\5\u018a\u00c6\2\u0f65\u0f67"+
		"\5\u0182\u00c2\2\u0f66\u0f62\3\2\2\2\u0f66\u0f63\3\2\2\2\u0f66\u0f64\3"+
		"\2\2\2\u0f66\u0f65\3\2\2\2\u0f67\u0181\3\2\2\2\u0f68\u0f6e\5\u014a\u00a6"+
		"\2\u0f69\u0f6a\7\u015a\2\2\u0f6a\u0f6b\5\u018e\u00c8\2\u0f6b\u0f6c\7\u015b"+
		"\2\2\u0f6c\u0f6e\3\2\2\2\u0f6d\u0f68\3\2\2\2\u0f6d\u0f69\3\2\2\2\u0f6e"+
		"\u0183\3\2\2\2\u0f6f\u0f74\5\u0182\u00c2\2\u0f70\u0f71\7\u0153\2\2\u0f71"+
		"\u0f73\5\u0182\u00c2\2\u0f72\u0f70\3\2\2\2\u0f73\u0f76\3\2\2\2\u0f74\u0f72"+
		"\3\2\2\2\u0f74\u0f75\3\2\2\2\u0f75\u0185\3\2\2\2\u0f76\u0f74\3\2\2\2\u0f77"+
		"\u0f78\7\u00f7\2\2\u0f78\u0f79\7\u015a\2\2\u0f79\u0f7a\5\u0184\u00c3\2"+
		"\u0f7a\u0f7b\7\u015b\2\2\u0f7b\u0187\3\2\2\2\u0f7c\u0f7d\7\u00a0\2\2\u0f7d"+
		"\u0f7e\7\u015a\2\2\u0f7e\u0f7f\5\u0184\u00c3\2\u0f7f\u0f80\7\u015b\2\2"+
		"\u0f80\u0189\3\2\2\2\u0f81\u0f82\7\u015a\2\2\u0f82\u0f83\7\u015b\2\2\u0f83"+
		"\u018b\3\2\2\2\u0f84\u0f85\7\66\2\2\u0f85\u0f86\5\u0130\u0099\2\u0f86"+
		"\u018d\3\2\2\2\u0f87\u0f8c\5\u014a\u00a6\2\u0f88\u0f89\7\u0153\2\2\u0f89"+
		"\u0f8b\5\u014a\u00a6\2\u0f8a\u0f88\3\2\2\2\u0f8b\u0f8e\3\2\2\2\u0f8c\u0f8a"+
		"\3\2\2\2\u0f8c\u0f8d\3\2\2\2\u0f8d\u018f\3\2\2\2\u0f8e\u0f8c\3\2\2\2\u0f8f"+
		"\u0f90\5\u0192\u00ca\2\u0f90\u0191\3\2\2\2\u0f91\u0f94\5\u0194\u00cb\2"+
		"\u0f92\u0f94\5\u0156\u00ac\2\u0f93\u0f91\3\2\2\2\u0f93\u0f92\3\2\2\2\u0f94"+
		"\u0193\3\2\2\2\u0f95\u0f9e\5\u0198\u00cd\2\u0f96\u0f97\5\u0156\u00ac\2"+
		"\u0f97\u0f99\t\37\2\2\u0f98\u0f9a\t \2\2\u0f99\u0f98\3\2\2\2\u0f99\u0f9a"+
		"\3\2\2\2\u0f9a\u0f9b\3\2\2\2\u0f9b\u0f9c\5\u0196\u00cc\2\u0f9c\u0f9e\3"+
		"\2\2\2\u0f9d\u0f95\3\2\2\2\u0f9d\u0f96\3\2\2\2\u0f9e\u0fa6\3\2\2\2\u0f9f"+
		"\u0fa1\t\37\2\2\u0fa0\u0fa2\t \2\2\u0fa1\u0fa0\3\2\2\2\u0fa1\u0fa2\3\2"+
		"\2\2\u0fa2\u0fa3\3\2\2\2\u0fa3\u0fa5\5\u0196\u00cc\2\u0fa4\u0f9f\3\2\2"+
		"\2\u0fa5\u0fa8\3\2\2\2\u0fa6\u0fa4\3\2\2\2\u0fa6\u0fa7\3\2\2\2\u0fa7\u0195"+
		"\3\2\2\2\u0fa8\u0fa6\3\2\2\2\u0fa9\u0fac\5\u0198\u00cd\2\u0faa\u0fac\5"+
		"\u0156\u00ac\2\u0fab\u0fa9\3\2\2\2\u0fab\u0faa\3\2\2\2\u0fac\u0197\3\2"+
		"\2\2\u0fad\u0fb6\5\u019c\u00cf\2\u0fae\u0faf\5\u0156\u00ac\2\u0faf\u0fb1"+
		"\7B\2\2\u0fb0\u0fb2\t \2\2\u0fb1\u0fb0\3\2\2\2\u0fb1\u0fb2\3\2\2\2\u0fb2"+
		"\u0fb3\3\2\2\2\u0fb3\u0fb4\5\u019a\u00ce\2\u0fb4\u0fb6\3\2\2\2\u0fb5\u0fad"+
		"\3\2\2\2\u0fb5\u0fae\3\2\2\2\u0fb6\u0fbe\3\2\2\2\u0fb7\u0fb9\7B\2\2\u0fb8"+
		"\u0fba\t \2\2\u0fb9\u0fb8\3\2\2\2\u0fb9\u0fba\3\2\2\2\u0fba\u0fbb\3\2"+
		"\2\2\u0fbb\u0fbd\5\u019a\u00ce\2\u0fbc\u0fb7\3\2\2\2\u0fbd\u0fc0\3\2\2"+
		"\2\u0fbe\u0fbc\3\2\2\2\u0fbe\u0fbf\3\2\2\2\u0fbf\u0199\3\2\2\2\u0fc0\u0fbe"+
		"\3\2\2\2\u0fc1\u0fc4\5\u019c\u00cf\2\u0fc2\u0fc4\5\u0156\u00ac\2\u0fc3"+
		"\u0fc1\3\2\2\2\u0fc3\u0fc2\3\2\2\2\u0fc4\u019b\3\2\2\2\u0fc5\u0fcb\5\u019e"+
		"\u00d0\2\u0fc6\u0fc7\7\u015a\2\2\u0fc7\u0fc8\5\u0194\u00cb\2\u0fc8\u0fc9"+
		"\7\u015b\2\2\u0fc9\u0fcb\3\2\2\2\u0fca\u0fc5\3\2\2\2\u0fca\u0fc6\3\2\2"+
		"\2\u0fcb\u019d\3\2\2\2\u0fcc\u0fcf\5\u01a6\u00d4\2\u0fcd\u0fcf\5\u01a0"+
		"\u00d1\2\u0fce\u0fcc\3\2\2\2\u0fce\u0fcd\3\2\2\2\u0fcf\u019f\3\2\2\2\u0fd0"+
		"\u0fd1\7t\2\2\u0fd1\u0fd2\5\u01a2\u00d2\2\u0fd2\u01a1\3\2\2\2\u0fd3\u0fd6"+
		"\5\u01a4\u00d3\2\u0fd4\u0fd6\5\u00a2R\2\u0fd5\u0fd3\3\2\2\2\u0fd5\u0fd4"+
		"\3\2\2\2\u0fd6\u01a3\3\2\2\2\u0fd7\u0fde\5\u00a2R\2\u0fd8\u0fd9\7\u0161"+
		"\2\2\u0fd9\u0fdc\5\u00a2R\2\u0fda\u0fdb\7\u0161\2\2\u0fdb\u0fdd\5\u00a2"+
		"R\2\u0fdc\u0fda\3\2\2\2\u0fdc\u0fdd\3\2\2\2\u0fdd\u0fdf\3\2\2\2\u0fde"+
		"\u0fd8\3\2\2\2\u0fde\u0fdf\3\2\2\2\u0fdf\u01a5\3\2\2\2\u0fe0\u0fe2\7m"+
		"\2\2\u0fe1\u0fe3\5\u01b0\u00d9\2\u0fe2\u0fe1\3\2\2\2\u0fe2\u0fe3\3\2\2"+
		"\2\u0fe3\u0fe4\3\2\2\2\u0fe4\u0fe6\5\u01a8\u00d5\2\u0fe5\u0fe7\5\u014e"+
		"\u00a8\2\u0fe6\u0fe5\3\2\2\2\u0fe6\u0fe7\3\2\2\2\u0fe7\u01a7\3\2\2\2\u0fe8"+
		"\u0fed\5\u01aa\u00d6\2\u0fe9\u0fea\7\u0153\2\2\u0fea\u0fec\5\u01aa\u00d6"+
		"\2\u0feb\u0fe9\3\2\2\2\u0fec\u0fef\3\2\2\2\u0fed\u0feb\3\2\2\2\u0fed\u0fee"+
		"\3\2\2\2\u0fee\u01a9\3\2\2\2\u0fef\u0fed\3\2\2\2\u0ff0\u0ff3\5\u01ac\u00d7"+
		"\2\u0ff1\u0ff3\5\u01ae\u00d8\2\u0ff2\u0ff0\3\2\2\2\u0ff2\u0ff1\3\2\2\2"+
		"\u0ff3\u01ab\3\2\2\2\u0ff4\u0ff6\7\u015a\2\2\u0ff5\u0ff4\3\2\2\2\u0ff6"+
		"\u0ff9\3\2\2\2\u0ff7\u0ff5\3\2\2\2\u0ff7\u0ff8\3\2\2\2\u0ff8\u0ffa\3\2"+
		"\2\2\u0ff9\u0ff7\3\2\2\2\u0ffa\u0ffe\5\u0104\u0083\2\u0ffb\u0ffd\7\u015b"+
		"\2\2\u0ffc\u0ffb\3\2\2\2\u0ffd\u1000\3\2\2\2\u0ffe\u0ffc\3\2\2\2\u0ffe"+
		"\u0fff\3\2\2\2\u0fff\u1005\3\2\2\2\u1000\u0ffe\3\2\2\2\u1001\u1004\5\u01b4"+
		"\u00db\2\u1002\u1004\5\u01b6\u00dc\2\u1003\u1001\3\2\2\2\u1003\u1002\3"+
		"\2\2\2\u1004\u1007\3\2\2\2\u1005\u1003\3\2\2\2\u1005\u1006\3\2\2\2\u1006"+
		"\u01ad\3\2\2\2\u1007\u1005\3\2\2\2\u1008\u1009\7\u016d\2\2\u1009\u100b"+
		"\7\u0161\2\2\u100a\u1008\3\2\2\2\u100a\u100b\3\2\2\2\u100b\u100c\3\2\2"+
		"\2\u100c\u100d\7\u015e\2\2\u100d\u01af\3\2\2\2\u100e\u100f\t \2\2\u100f"+
		"\u01b1\3\2\2\2\u1010\u1011\5\u00a2R\2\u1011\u1012\7\u0161\2\2\u1012\u1014"+
		"\3\2\2\2\u1013\u1010\3\2\2\2\u1013\u1014\3\2\2\2\u1014\u1015\3\2\2\2\u1015"+
		"\u1016\5\u00a2R\2\u1016\u01b3\3\2\2\2\u1017\u1019\7\6\2\2\u1018\u1017"+
		"\3\2\2\2\u1018\u1019\3\2\2\2\u1019\u101a\3\2\2\2\u101a\u101b\5\u00a2R"+
		"\2\u101b\u01b5\3\2\2\2\u101c\u101d\7\u00e4\2\2\u101d\u1023\7\u015a\2\2"+
		"\u101e\u1022\5\u009cO\2\u101f\u1022\5\u01f6\u00fc\2\u1020\u1022\5\u01fe"+
		"\u0100\2\u1021\u101e\3\2\2\2\u1021\u101f\3\2\2\2\u1021\u1020\3\2\2\2\u1022"+
		"\u1025\3\2\2\2\u1023\u1021\3\2\2\2\u1023\u1024\3\2\2\2\u1024\u1026\3\2"+
		"\2\2\u1025\u1023\3\2\2\2\u1026\u1027\7\u015b\2\2\u1027\u01b7\3\2\2\2\u1028"+
		"\u102d\5\u01b2\u00da\2\u1029\u102a\7\u0153\2\2\u102a\u102c\5\u01b2\u00da"+
		"\2\u102b\u1029\3\2\2\2\u102c\u102f\3\2\2\2\u102d\u102b\3\2\2\2\u102d\u102e"+
		"\3\2\2\2\u102e\u01b9\3\2\2\2\u102f\u102d\3\2\2\2\u1030\u1031\5\u01c0\u00e1"+
		"\2\u1031\u01bb\3\2\2\2\u1032\u1033\5\u01c0\u00e1\2\u1033\u01bd\3\2\2\2"+
		"\u1034\u1035\5\u01c0\u00e1\2\u1035\u01bf\3\2\2\2\u1036\u1037\7\u015a\2"+
		"\2\u1037\u1038\5\u0190\u00c9\2\u1038\u1039\7\u015b\2\2\u1039\u01c1\3\2"+
		"\2\2\u103a\u1041\5\u01c4\u00e3\2\u103b\u1041\5\u01c8\u00e5\2\u103c\u1041"+
		"\5\u01cc\u00e7\2\u103d\u1041\5\u01d2\u00ea\2\u103e\u1041\5\u01da\u00ee"+
		"\2\u103f\u1041\5\u01e4\u00f3\2\u1040\u103a\3\2\2\2\u1040\u103b\3\2\2\2"+
		"\u1040\u103c\3\2\2\2\u1040\u103d\3\2\2\2\u1040\u103e\3\2\2\2\u1040\u103f"+
		"\3\2\2\2\u1041\u01c3\3\2\2\2\u1042\u1043\5\u014a\u00a6\2\u1043\u1044\5"+
		"\u01c6\u00e4\2\u1044\u1045\5\u014a\u00a6\2\u1045\u01c5\3\2\2\2\u1046\u1047"+
		"\t!\2\2\u1047\u01c7\3\2\2\2\u1048\u1049\5\u014a\u00a6\2\u1049\u104a\5"+
		"\u01ca\u00e6\2\u104a\u01c9\3\2\2\2\u104b\u104d\7P\2\2\u104c\u104b\3\2"+
		"\2\2\u104c\u104d\3\2\2\2\u104d\u104e\3\2\2\2\u104e\u1050\7\u008d\2\2\u104f"+
		"\u1051\t\"\2\2\u1050\u104f\3\2\2\2\u1050\u1051\3\2\2\2\u1051\u1052\3\2"+
		"\2\2\u1052\u1053\5\u014a\u00a6\2\u1053\u1054\7\t\2\2\u1054\u1055\5\u014a"+
		"\u00a6\2\u1055\u01cb\3\2\2\2\u1056\u1058\5\u010a\u0086\2\u1057\u1059\7"+
		"P\2\2\u1058\u1057\3\2\2\2\u1058\u1059\3\2\2\2\u1059\u105a\3\2\2\2\u105a"+
		"\u105b\7<\2\2\u105b\u105c\5\u01ce\u00e8\2\u105c\u01cd\3\2\2\2\u105d\u1063"+
		"\5\u01be\u00e0\2\u105e\u105f\7\u015a\2\2\u105f\u1060\5\u01d0\u00e9\2\u1060"+
		"\u1061\7\u015b\2\2\u1061\u1063\3\2\2\2\u1062\u105d\3\2\2\2\u1062\u105e"+
		"\3\2\2\2\u1063\u01cf\3\2\2\2\u1064\u1069\5\u0144\u00a3\2\u1065\u1066\7"+
		"\u0153\2\2\u1066\u1068\5\u0144\u00a3\2\u1067\u1065\3\2\2\2\u1068\u106b"+
		"\3\2\2\2\u1069\u1067\3\2\2\2\u1069\u106a\3\2\2\2\u106a\u01d1\3\2\2\2\u106b"+
		"\u1069\3\2\2\2\u106c\u106d\5\u014a\u00a6\2\u106d\u106e\5\u01d4\u00eb\2"+
		"\u106e\u106f\7\u0170\2\2\u106f\u01d3\3\2\2\2\u1070\u1072\7P\2\2\u1071"+
		"\u1070\3\2\2\2\u1071\u1072\3\2\2\2\u1072\u1073\3\2\2\2\u1073\u1076\5\u01d6"+
		"\u00ec\2\u1074\u1076\5\u01d8\u00ed\2\u1075\u1071\3\2\2\2\u1075\u1074\3"+
		"\2\2\2\u1076\u01d5\3\2\2\2\u1077\u107e\7L\2\2\u1078\u107e\79\2\2\u1079"+
		"\u107a\7\u00fd\2\2\u107a\u107e\7\u010f\2\2\u107b\u107e\7\u00f1\2\2\u107c"+
		"\u107e\7\u00f6\2\2\u107d\u1077\3\2\2\2\u107d\u1078\3\2\2\2\u107d\u1079"+
		"\3\2\2\2\u107d\u107b\3\2\2\2\u107d\u107c\3\2\2\2\u107e\u01d7\3\2\2\2\u107f"+
		"\u1080\t#\2\2\u1080\u01d9\3\2\2\2\u1081\u1082\5\u014a\u00a6\2\u1082\u1084"+
		"\7G\2\2\u1083\u1085\7P\2\2\u1084\u1083\3\2\2\2\u1084\u1085\3\2\2\2\u1085"+
		"\u1086\3\2\2\2\u1086\u1087\7Q\2\2\u1087\u01db\3\2\2\2\u1088\u1089\5\u010a"+
		"\u0086\2\u1089\u108a\5\u01c6\u00e4\2\u108a\u108b\5\u01de\u00f0\2\u108b"+
		"\u108c\5\u01be\u00e0\2\u108c\u01dd\3\2\2\2\u108d\u1090\5\u01e0\u00f1\2"+
		"\u108e\u1090\5\u01e2\u00f2\2\u108f\u108d\3\2\2\2\u108f\u108e\3\2\2\2\u1090"+
		"\u01df\3\2\2\2\u1091\u1092\7\7\2\2\u1092\u01e1\3\2\2\2\u1093\u1094\t$"+
		"\2\2\u1094\u01e3\3\2\2\2\u1095\u1097\7P\2\2\u1096\u1095\3\2\2\2\u1096"+
		"\u1097\3\2\2\2\u1097\u1098\3\2\2\2\u1098\u1099\7\u00b1\2\2\u1099\u109a"+
		"\5\u01be\u00e0\2\u109a\u01e5\3\2\2\2\u109b\u109c\7~\2\2\u109c\u109d\5"+
		"\u01be\u00e0\2\u109d\u01e7\3\2\2\2\u109e\u10a1\5\u01ea\u00f6\2\u109f\u10a1"+
		"\7\u00f9\2\2\u10a0\u109e\3\2\2\2\u10a0\u109f\3\2\2\2\u10a1\u01e9\3\2\2"+
		"\2\u10a2\u10a3\t%\2\2\u10a3\u01eb\3\2\2\2\u10a4\u10a5\t&\2\2\u10a5\u01ed"+
		"\3\2\2\2\u10a6\u10a7\5\u01f2\u00fa\2\u10a7\u10a9\7\u015a\2\2\u10a8\u10aa"+
		"\5\u01f4\u00fb\2\u10a9\u10a8\3\2\2\2\u10a9\u10aa\3\2\2\2\u10aa\u10ab\3"+
		"\2\2\2\u10ab\u10ac\7\u015b\2\2\u10ac\u01ef\3\2\2\2\u10ad\u10ae\t\'\2\2"+
		"\u10ae\u01f1\3\2\2\2\u10af\u10b2\5\u01a4\u00d3\2\u10b0\u10b2\5\u01f0\u00f9"+
		"\2\u10b1\u10af\3\2\2\2\u10b1\u10b0\3\2\2\2\u10b2\u01f3\3\2\2\2\u10b3\u10b8"+
		"\5\u0104\u0083\2\u10b4\u10b5\7\u0153\2\2\u10b5\u10b7\5\u0104\u0083\2\u10b6"+
		"\u10b4\3\2\2\2\u10b7\u10ba\3\2\2\2\u10b8\u10b6\3\2\2\2\u10b8\u10b9\3\2"+
		"\2\2\u10b9\u01f5\3\2\2\2\u10ba\u10b8\3\2\2\2\u10bb\u10bc\7X\2\2\u10bc"+
		"\u10bd\7\u008e\2\2\u10bd\u10be\5\u01fa\u00fe\2\u10be\u01f7\3\2\2\2\u10bf"+
		"\u10c9\5\u01fa\u00fe\2\u10c0\u10c3\7\u015a\2\2\u10c1\u10c4\n\27\2\2\u10c2"+
		"\u10c4\5\u01f8\u00fd\2\u10c3\u10c1\3\2\2\2\u10c3\u10c2\3\2\2\2\u10c4\u10c5"+
		"\3\2\2\2\u10c5\u10c3\3\2\2\2\u10c5\u10c6\3\2\2\2\u10c6\u10c7\3\2\2\2\u10c7"+
		"\u10c9\7\u015b\2\2\u10c8\u10bf\3\2\2\2\u10c8\u10c0\3\2\2\2\u10c9\u01f9"+
		"\3\2\2\2\u10ca\u10cf\5\u01fc\u00ff\2\u10cb\u10cc\7\u0153\2\2\u10cc\u10ce"+
		"\5\u01fc\u00ff\2\u10cd\u10cb\3\2\2\2\u10ce\u10d1\3\2\2\2\u10cf\u10cd\3"+
		"\2\2\2\u10cf\u10d0\3\2\2\2\u10d0\u01fb\3\2\2\2\u10d1\u10cf\3\2\2\2\u10d2"+
		"\u10d4\5\u014a\u00a6\2\u10d3\u10d5\5\u01fe\u0100\2\u10d4\u10d3\3\2\2\2"+
		"\u10d4\u10d5\3\2\2\2\u10d5\u10d7\3\2\2\2\u10d6\u10d8\5\u0202\u0102\2\u10d7"+
		"\u10d6\3\2\2\2\u10d7\u10d8\3\2\2\2\u10d8\u01fd\3\2\2\2\u10d9\u10da\t("+
		"\2\2\u10da\u01ff\3\2\2\2\u10db\u10dc\7M\2\2\u10dc\u10dd\5\u010a\u0086"+
		"\2\u10dd\u0201\3\2\2\2\u10de\u10df\7Q\2\2\u10df\u10e3\7\u00b7\2\2\u10e0"+
		"\u10e1\7Q\2\2\u10e1\u10e3\7\u00ca\2\2\u10e2\u10de\3\2\2\2\u10e2\u10e0"+
		"\3\2\2\2\u10e3\u0203\3\2\2\2\u0235\u0209\u0213\u0223\u022b\u0233\u0236"+
		"\u024d\u025d\u0261\u026b\u0273\u0278\u027d\u0284\u028a\u028f\u0293\u02a7"+
		"\u02ab\u02b0\u02b4\u02b8\u02bc\u02c1\u02c7\u02cb\u02cf\u02d8\u02e0\u02ea"+
		"\u02f3\u02fd\u0304\u030e\u0315\u0323\u032e\u0338\u033f\u036c\u0380\u0388"+
		"\u0393\u0399\u039b\u03ad\u03b2\u03c1\u03cc\u03d8\u03db\u03e4\u03e7\u03f1"+
		"\u03f6\u03f8\u0403\u0408\u040a\u0413\u0415\u041e\u0420\u0429\u0430\u0435"+
		"\u0437\u0440\u0447\u044c\u044e\u0457\u045c\u045e\u0467\u046c\u046e\u0473"+
		"\u0479\u047f\u0482\u0484\u0486\u048d\u0498\u04a3\u04aa\u04ae\u04b2\u04b5"+
		"\u04bb\u04bf\u04c3\u04c7\u04ce\u04d2\u04d6\u04da\u04de\u04e3\u04e6\u04ed"+
		"\u04f0\u04f3\u04fb\u04ff\u0501\u0512\u0517\u051b\u051d\u0525\u052e\u0533"+
		"\u053a\u0540\u0544\u0547\u054f\u0553\u055b\u0567\u056a\u056c\u056f\u0573"+
		"\u0579\u057e\u0584\u0588\u058c\u0590\u0597\u059d\u05a6\u05ad\u05b2\u05b4"+
		"\u05b8\u05bd\u05c6\u05c8\u05d0\u05d9\u05e0\u05e4\u05ec\u05f1\u05f5\u05fc"+
		"\u0605\u060a\u060e\u0610\u0619\u0625\u0628\u0630\u0635\u0639\u063b\u0644"+
		"\u064d\u0652\u0654\u065f\u0668\u066d\u066f\u0679\u0682\u0687\u0689\u068e"+
		"\u0696\u069b\u069d\u06a6\u06af\u06b4\u06b6\u06b8\u06bc\u06be\u06c8\u06d1"+
		"\u06d5\u06d9\u06dd\u06df\u06e8\u06f1\u06f6\u06f8\u0701\u070a\u0711\u071a"+
		"\u071e\u0720\u0724\u0728\u072c\u0730\u0734\u0738\u0740\u0745\u0747\u074b"+
		"\u074f\u0753\u075b\u075f\u0761\u076c\u0771\u0775\u077c\u077f\u0783\u0787"+
		"\u078b\u0795\u079a\u079c\u07a5\u07aa\u07b5\u07b8\u07c2\u07c7\u07c9\u07d2"+
		"\u07db\u07dd\u07e8\u07f1\u07f3\u07fd\u0806\u0808\u080d\u0815\u0817\u0820"+
		"\u0828\u082c\u0830\u0832\u083c\u0844\u0848\u084c\u084e\u0857\u0860\u0862"+
		"\u086b\u0875\u087e\u0884\u0886\u088a\u088e\u0892\u0896\u089a\u08a0\u08ac"+
		"\u08af\u08ed\u091b\u0923\u092a\u0934\u0939\u094c\u0951\u0961\u0967\u0970"+
		"\u0972\u097b\u0980\u0989\u098e\u0992\u0997\u09a3\u09a8\u09ab\u09b0\u09be"+
		"\u09c3\u09d1\u09d6\u09dd\u09e2\u09e9\u09ef\u09f3\u09f9\u0a00\u0a02\u0a09"+
		"\u0a0e\u0a18\u0a23\u0a2c\u0a31\u0a34\u0a3a\u0a3e\u0a46\u0a4a\u0a4e\u0a55"+
		"\u0a59\u0a5f\u0a68\u0a6b\u0a72\u0a76\u0a7a\u0a82\u0a86\u0a8c\u0a98\u0a9c"+
		"\u0aa5\u0aa9\u0aab\u0ab0\u0ab6\u0abf\u0ac2\u0ac7\u0acb\u0ad0\u0ad8\u0ae2"+
		"\u0af0\u0af9\u0b03\u0b0d\u0b17\u0b23\u0b28\u0b30\u0b38\u0b3a\u0b3d\u0b42"+
		"\u0b48\u0b4c\u0b55\u0b65\u0b6a\u0b6f\u0b71\u0b76\u0b7c\u0b82\u0b88\u0b8e"+
		"\u0b91\u0b95\u0ba1\u0baa\u0bac\u0bb0\u0bb8\u0bbb\u0bc1\u0bc9\u0bda\u0bef"+
		"\u0c00\u0c0d\u0c11\u0c13\u0c20\u0c27\u0c3f\u0c46\u0c58\u0c61\u0c66\u0c6a"+
		"\u0c6c\u0c72\u0c77\u0c7c\u0c8c\u0c90\u0ca1\u0ca9\u0cad\u0cb2\u0cb7\u0cbb"+
		"\u0cbf\u0cc8\u0ccd\u0cd1\u0cd7\u0cdd\u0ce2\u0ce6\u0ce8\u0cec\u0cf0\u0cf2"+
		"\u0cf6\u0cfa\u0cfe\u0d02\u0d0d\u0d11\u0d19\u0d23\u0d38\u0d3c\u0d40\u0d45"+
		"\u0d47\u0d4b\u0d50\u0d54\u0d56\u0d5a\u0d5f\u0d61\u0d6d\u0d74\u0d80\u0d82"+
		"\u0d87\u0da9\u0dad\u0db1\u0db8\u0dbb\u0dc3\u0dc6\u0dd9\u0dea\u0df3\u0dfb"+
		"\u0e02\u0e0a\u0e0e\u0e18\u0e22\u0e26\u0e36\u0e3c\u0e45\u0e4c\u0e56\u0e59"+
		"\u0e5c\u0e63\u0e6e\u0e76\u0e7c\u0e80\u0e84\u0e8c\u0e90\u0e98\u0ea0\u0ea4"+
		"\u0ea8\u0eab\u0eae\u0eb1\u0eb4\u0eba\u0ebe\u0ec5\u0eca\u0ed0\u0ed6\u0ede"+
		"\u0ee5\u0eec\u0ef4\u0eff\u0f03\u0f09\u0f15\u0f18\u0f1b\u0f21\u0f25\u0f2c"+
		"\u0f2e\u0f35\u0f3a\u0f43\u0f46\u0f50\u0f54\u0f5f\u0f66\u0f6d\u0f74\u0f8c"+
		"\u0f93\u0f99\u0f9d\u0fa1\u0fa6\u0fab\u0fb1\u0fb5\u0fb9\u0fbe\u0fc3\u0fca"+
		"\u0fce\u0fd5\u0fdc\u0fde\u0fe2\u0fe6\u0fed\u0ff2\u0ff7\u0ffe\u1003\u1005"+
		"\u100a\u1013\u1018\u1021\u1023\u102d\u1040\u104c\u1050\u1058\u1062\u1069"+
		"\u1071\u1075\u107d\u1084\u108f\u1096\u10a0\u10a9\u10b1\u10b8\u10c3\u10c5"+
		"\u10c8\u10cf\u10d4\u10d7\u10e2";
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