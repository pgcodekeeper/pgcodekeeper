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
		OWNED=87, EndDollarStringConstant=373, Space=369, INOUT=66, STORAGE=256, 
		TIME=314, AS=4, RIGHT_PAREN=345, THEN=117, MAXVALUE=207, COLLATION=18, 
		LEFT=73, REPLACE=98, AVG=138, ZONE=287, TRUNCATE=122, COLUMN=150, TRUSTED=119, 
		PLUS=346, EXISTS=175, NVARCHAR=312, Not_Similar_To=329, RETURNS=100, LIKE=74, 
		COLLATE=17, ADD=1, INTEGER=299, OUTER=82, BY=140, DEFERRABLE=28, TO=269, 
		INHERIT=187, SET=250, RIGHT=102, HAVING=52, MIN=211, SESSION=108, MINUS=347, 
		TEXT=318, HOUR=186, QuotedIdentifier=364, CONCATENATION_OPERATOR=338, 
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
		FROM=48, FALSE=42, COLLECT=148, BeginDollarStringConstant=368, PARSER=228, 
		DISTINCT=32, TEMPORARY=116, TIMESTAMP=316, SIMPLE=252, DOLLAR=356, OVER=226, 
		CONSTRAINTS=21, WHERE=132, DEC=163, VAR_SAMP=278, NULLIF=218, MAIN=204, 
		CLASS=143, Text_between_Dollar=372, TIMETZ=315, INNER=63, YEAR=286, TIMEZONE=265, 
		ORDER=86, AUTHORIZATION=11, LIMIT=75, DECADE=164, GTH=342, CYCLE=160, 
		White_Space=370, MAX=206, UPDATE=125, LineComment=362, DEFERRED=29, FOR=43, 
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
		BAD=371, ASSIGN=333, REGCLASS=304, IMMEDIATE=56, CLUSTER=147, WINDOW=284, 
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
		"Character_String_Literal", "ESC_SEQUENCES", "BeginDollarStringConstant", 
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
		RULE_function_definition = 37, RULE_function_definition_name_paren = 38, 
		RULE_functions_definition_schema = 39, RULE_create_sequence_statement = 40, 
		RULE_sequence_body = 41, RULE_create_schema_statement = 42, RULE_create_view_statement = 43, 
		RULE_create_table_statement = 44, RULE_table_body = 45, RULE_table_column_definition = 46, 
		RULE_like_option = 47, RULE_table_constraint = 48, RULE_column_constraint = 49, 
		RULE_check_boolean_expression = 50, RULE_storage_parameter = 51, RULE_with_storage_parameter = 52, 
		RULE_storage_parameter_oid = 53, RULE_on_commit = 54, RULE_table_space = 55, 
		RULE_action = 56, RULE_index_parameters = 57, RULE_table_elements = 58, 
		RULE_field_element = 59, RULE_field_type = 60, RULE_param_clause = 61, 
		RULE_param = 62, RULE_method_specifier = 63, RULE_table_space_specifier = 64, 
		RULE_table_space_name = 65, RULE_table_partitioning_clauses = 66, RULE_range_partitions = 67, 
		RULE_range_value_clause_list = 68, RULE_range_value_clause = 69, RULE_hash_partitions = 70, 
		RULE_individual_hash_partitions = 71, RULE_individual_hash_partition = 72, 
		RULE_hash_partitions_by_quantity = 73, RULE_list_partitions = 74, RULE_list_value_clause_list = 75, 
		RULE_list_value_partition = 76, RULE_column_partitions = 77, RULE_partition_by_columns = 78, 
		RULE_partition_name = 79, RULE_drop_table_statement = 80, RULE_identifier = 81, 
		RULE_nonreserved_keywords = 82, RULE_unsigned_literal = 83, RULE_general_literal = 84, 
		RULE_datetime_literal = 85, RULE_time_literal = 86, RULE_timestamp_literal = 87, 
		RULE_date_literal = 88, RULE_data_type = 89, RULE_predefined_type = 90, 
		RULE_regclass = 91, RULE_network_type = 92, RULE_character_string_type = 93, 
		RULE_type_length = 94, RULE_national_character_string_type = 95, RULE_binary_large_object_string_type = 96, 
		RULE_numeric_type = 97, RULE_exact_numeric_type = 98, RULE_approximate_numeric_type = 99, 
		RULE_precision_param = 100, RULE_boolean_type = 101, RULE_datetime_type = 102, 
		RULE_bit_type = 103, RULE_binary_type = 104, RULE_value_expression_primary = 105, 
		RULE_parenthesized_value_expression = 106, RULE_nonparenthesized_value_expression_primary = 107, 
		RULE_unsigned_value_specification = 108, RULE_unsigned_numeric_literal = 109, 
		RULE_signed_numerical_literal = 110, RULE_set_function_specification = 111, 
		RULE_aggregate_function = 112, RULE_general_set_function = 113, RULE_set_function_type = 114, 
		RULE_filter_clause = 115, RULE_grouping_operation = 116, RULE_case_expression = 117, 
		RULE_case_abbreviation = 118, RULE_case_specification = 119, RULE_simple_case = 120, 
		RULE_searched_case = 121, RULE_simple_when_clause = 122, RULE_searched_when_clause = 123, 
		RULE_else_clause = 124, RULE_result = 125, RULE_cast_specification = 126, 
		RULE_cast_operand = 127, RULE_cast_target = 128, RULE_value_expression = 129, 
		RULE_array_expression = 130, RULE_common_value_expression = 131, RULE_numeric_value_expression = 132, 
		RULE_term = 133, RULE_factor = 134, RULE_array = 135, RULE_numeric_primary = 136, 
		RULE_value_expression_primary_cast = 137, RULE_sign = 138, RULE_numeric_value_function = 139, 
		RULE_extract_expression = 140, RULE_extract_field = 141, RULE_time_zone_field = 142, 
		RULE_extract_source = 143, RULE_string_value_expression = 144, RULE_character_value_expression = 145, 
		RULE_character_factor = 146, RULE_character_primary = 147, RULE_string_value_function = 148, 
		RULE_trim_function = 149, RULE_trim_operands = 150, RULE_trim_specification = 151, 
		RULE_boolean_value_expression = 152, RULE_or_predicate = 153, RULE_and_predicate = 154, 
		RULE_boolean_factor = 155, RULE_boolean_test = 156, RULE_is_clause = 157, 
		RULE_truth_value = 158, RULE_boolean_primary = 159, RULE_boolean_predicand = 160, 
		RULE_parenthesized_boolean_value_expression = 161, RULE_row_value_expression = 162, 
		RULE_row_value_special_case = 163, RULE_explicit_row_value_constructor = 164, 
		RULE_row_value_predicand = 165, RULE_row_value_constructor_predicand = 166, 
		RULE_table_expression = 167, RULE_from_clause = 168, RULE_table_reference_list = 169, 
		RULE_table_reference = 170, RULE_joined_table = 171, RULE_joined_table_primary = 172, 
		RULE_cross_join = 173, RULE_qualified_join = 174, RULE_natural_join = 175, 
		RULE_union_join = 176, RULE_join_type = 177, RULE_outer_join_type = 178, 
		RULE_outer_join_type_part2 = 179, RULE_join_specification = 180, RULE_join_condition = 181, 
		RULE_named_columns_join = 182, RULE_table_primary = 183, RULE_column_name_list = 184, 
		RULE_alias_def = 185, RULE_alias_table = 186, RULE_derived_table = 187, 
		RULE_where_clause = 188, RULE_search_condition = 189, RULE_groupby_clause = 190, 
		RULE_grouping_element_list = 191, RULE_grouping_element = 192, RULE_ordinary_grouping_set = 193, 
		RULE_ordinary_grouping_set_list = 194, RULE_rollup_list = 195, RULE_cube_list = 196, 
		RULE_empty_grouping_set = 197, RULE_having_clause = 198, RULE_row_value_predicand_list = 199, 
		RULE_query_expression = 200, RULE_query_expression_body = 201, RULE_non_join_query_expression = 202, 
		RULE_query_term = 203, RULE_non_join_query_term = 204, RULE_query_primary = 205, 
		RULE_non_join_query_primary = 206, RULE_simple_table = 207, RULE_explicit_table = 208, 
		RULE_table_or_query_name = 209, RULE_schema_qualified_name = 210, RULE_query_specification = 211, 
		RULE_select_list = 212, RULE_select_sublist = 213, RULE_derived_column = 214, 
		RULE_qualified_asterisk = 215, RULE_set_qualifier = 216, RULE_column_reference = 217, 
		RULE_as_clause = 218, RULE_over_clause = 219, RULE_column_reference_list = 220, 
		RULE_scalar_subquery = 221, RULE_row_subquery = 222, RULE_table_subquery = 223, 
		RULE_subquery = 224, RULE_predicate = 225, RULE_comparison_predicate = 226, 
		RULE_comp_op = 227, RULE_between_predicate = 228, RULE_between_predicate_part_2 = 229, 
		RULE_in_predicate = 230, RULE_in_predicate_value = 231, RULE_in_value_list = 232, 
		RULE_pattern_matching_predicate = 233, RULE_pattern_matcher = 234, RULE_negativable_matcher = 235, 
		RULE_regex_matcher = 236, RULE_null_predicate = 237, RULE_quantified_comparison_predicate = 238, 
		RULE_quantifier = 239, RULE_all = 240, RULE_some = 241, RULE_exists_predicate = 242, 
		RULE_unique_predicate = 243, RULE_primary_datetime_field = 244, RULE_non_second_primary_datetime_field = 245, 
		RULE_extended_datetime_field = 246, RULE_orderby_clause = 247, RULE_sort_specifier_paren = 248, 
		RULE_sort_specifier_list = 249, RULE_sort_specifier = 250, RULE_order_specification = 251, 
		RULE_limit_clause = 252, RULE_null_ordering = 253;
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
		"argmode", "function_definition", "function_definition_name_paren", "functions_definition_schema", 
		"create_sequence_statement", "sequence_body", "create_schema_statement", 
		"create_view_statement", "create_table_statement", "table_body", "table_column_definition", 
		"like_option", "table_constraint", "column_constraint", "check_boolean_expression", 
		"storage_parameter", "with_storage_parameter", "storage_parameter_oid", 
		"on_commit", "table_space", "action", "index_parameters", "table_elements", 
		"field_element", "field_type", "param_clause", "param", "method_specifier", 
		"table_space_specifier", "table_space_name", "table_partitioning_clauses", 
		"range_partitions", "range_value_clause_list", "range_value_clause", "hash_partitions", 
		"individual_hash_partitions", "individual_hash_partition", "hash_partitions_by_quantity", 
		"list_partitions", "list_value_clause_list", "list_value_partition", "column_partitions", 
		"partition_by_columns", "partition_name", "drop_table_statement", "identifier", 
		"nonreserved_keywords", "unsigned_literal", "general_literal", "datetime_literal", 
		"time_literal", "timestamp_literal", "date_literal", "data_type", "predefined_type", 
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
		"value_expression", "array_expression", "common_value_expression", "numeric_value_expression", 
		"term", "factor", "array", "numeric_primary", "value_expression_primary_cast", 
		"sign", "numeric_value_function", "extract_expression", "extract_field", 
		"time_zone_field", "extract_source", "string_value_expression", "character_value_expression", 
		"character_factor", "character_primary", "string_value_function", "trim_function", 
		"trim_operands", "trim_specification", "boolean_value_expression", "or_predicate", 
		"and_predicate", "boolean_factor", "boolean_test", "is_clause", "truth_value", 
		"boolean_primary", "boolean_predicand", "parenthesized_boolean_value_expression", 
		"row_value_expression", "row_value_special_case", "explicit_row_value_constructor", 
		"row_value_predicand", "row_value_constructor_predicand", "table_expression", 
		"from_clause", "table_reference_list", "table_reference", "joined_table", 
		"joined_table_primary", "cross_join", "qualified_join", "natural_join", 
		"union_join", "join_type", "outer_join_type", "outer_join_type_part2", 
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
			setState(513);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALTER) | (1L << CREATE) | (1L << GRANT))) != 0) || _la==REVOKE || _la==COMMENT || _la==DROP || _la==SET) {
				{
				{
				setState(508); statement();
				setState(509); match(SEMI_COLON);
				}
				}
				setState(515);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(516); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(518); schema_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(523);
			switch (_input.LA(1)) {
			case CREATE:
			case GRANT:
			case REVOKE:
			case COMMENT:
			case SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(520); schema_create();
				}
				break;
			case ALTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(521); schema_alter();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 3);
				{
				setState(522); drop_table_statement();
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
			setState(539);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(525); create_table_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(526); index_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(527); create_extension_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(528); create_trigger_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(529); create_function_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(530); create_sequence_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(531); create_schema_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(532); create_view_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(533); comment_on_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(534); revoke_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(535); set_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(536); grant_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(537); create_language_statement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(538); create_event_trigger();
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
			setState(547);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(541); alter_function_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(542); alter_schema_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(543); alter_language_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(544); alter_table_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(545); alter_default_privileges();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(546); alter_sequence_statement();
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
			setState(581);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(549); match(ALTER);
				setState(550); match(FUNCTION);
				setState(551); function_parameters();
				setState(553); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(552); function_action();
					}
					}
					setState(555); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (ROWS - 96)) | (1L << (RETURNS - 96)) | (1L << (STRICT - 96)) | (1L << (CALLED - 96)) | (1L << (COST - 96)))) != 0) || _la==EXTERNAL || ((((_la - 242)) & ~0x3f) == 0 && ((1L << (_la - 242)) & ((1L << (RESET - 242)) | (1L << (SECURITY - 242)) | (1L << (SET - 242)) | (1L << (STABLE - 242)) | (1L << (VOLATILE - 242)))) != 0) );
				setState(558);
				_la = _input.LA(1);
				if (_la==RESTRICT) {
					{
					setState(557); match(RESTRICT);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(560); match(ALTER);
				setState(561); match(FUNCTION);
				setState(562); function_parameters();
				setState(563); match(RENAME);
				setState(564); match(TO);
				setState(565); ((Alter_function_statementContext)_localctx).new_name = schema_qualified_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(567); match(ALTER);
				setState(568); match(FUNCTION);
				setState(569); function_parameters();
				setState(570); match(OWNER);
				setState(571); match(TO);
				setState(572); ((Alter_function_statementContext)_localctx).new_owner = identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(574); match(ALTER);
				setState(575); match(FUNCTION);
				setState(576); function_parameters();
				setState(577); match(SET);
				setState(578); match(SCHEMA);
				setState(579); ((Alter_function_statementContext)_localctx).new_schema = schema_qualified_name();
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
			setState(597);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(583); match(ALTER);
				setState(584); match(SCHEMA);
				setState(585); ((Alter_schema_statementContext)_localctx).name = identifier();
				setState(586); match(RENAME);
				setState(587); match(TO);
				setState(588); ((Alter_schema_statementContext)_localctx).new_name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(590); match(ALTER);
				setState(591); match(SCHEMA);
				setState(592); ((Alter_schema_statementContext)_localctx).name = identifier();
				setState(593); match(OWNER);
				setState(594); match(TO);
				setState(595); ((Alter_schema_statementContext)_localctx).new_owner = identifier();
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
			setState(619);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
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
				setState(605); match(RENAME);
				setState(606); match(TO);
				setState(607); ((Alter_language_statementContext)_localctx).new_name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(609); match(ALTER);
				setState(611);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(610); match(PROCEDURAL);
					}
				}

				setState(613); match(LANGUAGE);
				setState(614); ((Alter_language_statementContext)_localctx).name = identifier();
				setState(615); match(OWNER);
				setState(616); match(TO);
				setState(617); ((Alter_language_statementContext)_localctx).new_owner = identifier();
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
			setState(671);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(621); match(ALTER);
				setState(622); match(TABLE);
				setState(624);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(623); match(ONLY);
					}
					break;
				}
				setState(627); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(626); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(629); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(631); table_action();
				setState(636);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					{
					setState(632); match(COMMA);
					}
					setState(633); table_action();
					}
					}
					setState(638);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(639); match(ALTER);
				setState(640); match(TABLE);
				setState(642);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(641); match(ONLY);
					}
					break;
				}
				setState(645); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(644); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(647); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(649); match(RENAME);
				setState(651);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(650); match(COLUMN);
					}
					break;
				}
				setState(653); ((Alter_table_statementContext)_localctx).column = schema_qualified_name();
				setState(654); match(TO);
				setState(655); ((Alter_table_statementContext)_localctx).new_column = schema_qualified_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(657); match(ALTER);
				setState(658); match(TABLE);
				setState(659); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
				setState(660); match(RENAME);
				setState(661); match(TO);
				setState(662); ((Alter_table_statementContext)_localctx).new_name = schema_qualified_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(664); match(ALTER);
				setState(665); match(TABLE);
				setState(666); ((Alter_table_statementContext)_localctx).name = schema_qualified_name();
				setState(667); match(SET);
				setState(668); match(SCHEMA);
				setState(669); ((Alter_table_statementContext)_localctx).new_schema = schema_qualified_name();
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
			setState(867);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(673); match(ADD);
				setState(675);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(674); match(COLUMN);
					}
					break;
				}
				setState(677); table_column_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(678); match(DROP);
				setState(680);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(679); match(COLUMN);
					}
					break;
				}
				setState(684);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(682); match(IF);
					setState(683); match(EXISTS);
					}
				}

				setState(686); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(688);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(687);
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
				setState(690); match(ALTER);
				setState(692);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(691); match(COLUMN);
					}
					break;
				}
				setState(694); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(697);
				_la = _input.LA(1);
				if (_la==SET) {
					{
					setState(695); match(SET);
					setState(696); match(DATA);
					}
				}

				setState(699); match(TYPE);
				setState(700); ((Table_actionContext)_localctx).datatype = data_type();
				setState(703);
				_la = _input.LA(1);
				if (_la==COLLATE) {
					{
					setState(701); match(COLLATE);
					setState(702); ((Table_actionContext)_localctx).collation = identifier();
					}
				}

				setState(707);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(705); match(USING);
					setState(706); ((Table_actionContext)_localctx).expression = value_expression();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(709); match(ALTER);
				setState(711);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(710); match(COLUMN);
					}
					break;
				}
				setState(713); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(714); match(SET);
				setState(715); match(DEFAULT);
				setState(716); ((Table_actionContext)_localctx).expression = value_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(718); match(ALTER);
				setState(720);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(719); match(COLUMN);
					}
					break;
				}
				setState(722); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(723); match(DROP);
				setState(724); match(DEFAULT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(726); match(ALTER);
				setState(728);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(727); match(COLUMN);
					}
					break;
				}
				setState(730); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(731); match(SET);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(733); match(DROP);
				setState(734); match(NOT);
				setState(735); match(NULL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(736); match(ALTER);
				setState(738);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(737); match(COLUMN);
					}
					break;
				}
				setState(740); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(741); match(SET);
				setState(742); match(STATISTICS);
				setState(743); ((Table_actionContext)_localctx).integer = match(NUMBER);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(745); match(ALTER);
				setState(747);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(746); match(COLUMN);
					}
					break;
				}
				setState(749); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(750); match(SET);
				setState(751); match(LEFT_PAREN);
				setState(752); attribute_option_value();
				setState(757);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(753); match(COMMA);
					setState(754); attribute_option_value();
					}
					}
					setState(759);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(760); match(RIGHT_PAREN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(762); match(ALTER);
				setState(764);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(763); match(COLUMN);
					}
					break;
				}
				setState(766); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(767); match(RESET);
				setState(768); match(LEFT_PAREN);
				setState(769); ((Table_actionContext)_localctx).table_attribute_option = table_attribute_option();
				((Table_actionContext)_localctx).attribute_option.add(((Table_actionContext)_localctx).table_attribute_option);
				setState(774);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(770); match(COMMA);
					setState(771); ((Table_actionContext)_localctx).table_attribute_option = table_attribute_option();
					((Table_actionContext)_localctx).attribute_option.add(((Table_actionContext)_localctx).table_attribute_option);
					}
					}
					setState(776);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(777); match(RIGHT_PAREN);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(779); match(ALTER);
				setState(781);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(780); match(COLUMN);
					}
					break;
				}
				setState(783); ((Table_actionContext)_localctx).column = schema_qualified_name();
				setState(784); match(SET);
				setState(785); match(STORAGE);
				setState(786); match(PLAIN);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(788); match(EXTERNAL);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(789); match(EXTENDED);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(790); match(MAIN);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(791); match(ADD);
				setState(792); ((Table_actionContext)_localctx).tabl_constraint = table_constraint();
				setState(795);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(793); match(NOT);
					setState(794); match(VALID);
					}
				}

				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(797); match(ADD);
				setState(798); ((Table_actionContext)_localctx).tabl_constraint_using_index = table_constraint_using_index();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(799); match(VALIDATE);
				setState(800); match(CONSTRAINT);
				setState(801); ((Table_actionContext)_localctx).constraint_name = schema_qualified_name();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(802); match(DROP);
				setState(803); match(CONSTRAINT);
				setState(806);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(804); match(IF);
					setState(805); match(EXISTS);
					}
				}

				setState(808); ((Table_actionContext)_localctx).constraint_name = schema_qualified_name();
				setState(809);
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
				setState(811);
				_la = _input.LA(1);
				if ( !(_la==DISABLE || _la==ENABLE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(812); match(TRIGGER);
				setState(816);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(813); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
					}
					break;
				case 2:
					{
					setState(814); match(ALL);
					}
					break;
				case 3:
					{
					setState(815); match(USER);
					}
					break;
				}
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(818); match(ENABLE);
				setState(819);
				_la = _input.LA(1);
				if ( !(_la==ALWAYS || _la==REPLICA) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(820); match(TRIGGER);
				setState(821); ((Table_actionContext)_localctx).trigger_name = schema_qualified_name();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(822);
				_la = _input.LA(1);
				if ( !(_la==DISABLE || _la==ENABLE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(823); match(RULE);
				setState(824); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(825); match(ENABLE);
				setState(826);
				_la = _input.LA(1);
				if ( !(_la==ALWAYS || _la==REPLICA) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(827); match(RULE);
				setState(828); ((Table_actionContext)_localctx).rewrite_rule_name = schema_qualified_name();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(829); match(CLUSTER);
				setState(830); match(ON);
				setState(831); ((Table_actionContext)_localctx).index_name = schema_qualified_name();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(832); match(SET);
				setState(833); match(WITHOUT);
				setState(834);
				_la = _input.LA(1);
				if ( !(_la==OIDS || _la==CLUSTER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(835); match(SET);
				setState(836); match(WITH);
				setState(837); match(OIDS);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(838); match(SET);
				setState(839); storage_parameter();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(840); match(RESET);
				setState(841); match(LEFT_PAREN);
				setState(842); with_storage_parameter();
				setState(847);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(843); match(COMMA);
					setState(844); with_storage_parameter();
					}
					}
					setState(849);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(850); match(RIGHT_PAREN);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(852); match(INHERIT);
				setState(853); ((Table_actionContext)_localctx).parent_table = schema_qualified_name();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(854); match(NO);
				setState(855); match(INHERIT);
				setState(856); ((Table_actionContext)_localctx).parent_table = schema_qualified_name();
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(857); match(OF);
				setState(858); ((Table_actionContext)_localctx).type_name = schema_qualified_name();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(859); match(NOT);
				setState(860); match(OF);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(861); match(OWNER);
				setState(862); match(TO);
				setState(863); ((Table_actionContext)_localctx).new_owner = schema_qualified_name();
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(864); match(SET);
				setState(865); match(TABLESPACE);
				setState(866); ((Table_actionContext)_localctx).new_tablespace = schema_qualified_name();
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
			setState(869); ((Attribute_option_valueContext)_localctx).attribute_option = table_attribute_option();
			setState(870); match(EQUAL);
			setState(871); ((Attribute_option_valueContext)_localctx).value = signed_numerical_literal();
			}
		}
		catch (RecognitionException re) {
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
			setState(894);
			switch (_input.LA(1)) {
			case CONSTRAINT:
			case UNIQUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(875);
				_la = _input.LA(1);
				if (_la==CONSTRAINT) {
					{
					setState(873); match(CONSTRAINT);
					setState(874); ((Table_constraint_using_indexContext)_localctx).constraint_name = schema_qualified_name();
					}
				}

				setState(877); match(UNIQUE);
				}
				break;
			case PRIMARY:
				enterOuterAlt(_localctx, 2);
				{
				setState(878); match(PRIMARY);
				setState(879); match(KEY);
				setState(880); match(USING);
				setState(881); match(INDEX);
				setState(882); ((Table_constraint_using_indexContext)_localctx).index_name = schema_qualified_name();
				setState(886);
				switch (_input.LA(1)) {
				case DEFERRABLE:
					{
					setState(883); match(DEFERRABLE);
					}
					break;
				case NOT:
					{
					setState(884); match(NOT);
					setState(885); match(DEFERRABLE);
					}
					break;
				case INITIALLY:
				case SEMI_COLON:
				case COMMA:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(892);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(888); match(INITIALLY);
					setState(889); match(DEFERRED);
					}
					break;
				case 2:
					{
					setState(890); match(INITIALLY);
					setState(891); match(IMMEDIATE);
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
			setState(896);
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
			setState(943);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(898); match(CALLED);
				setState(899); match(ON);
				setState(900); match(NULL);
				setState(901); match(INPUT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(902); match(RETURNS);
				setState(903); match(NULL);
				setState(904); match(ON);
				setState(905); match(NULL);
				setState(906); match(INPUT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(907); match(STRICT);
				setState(908); match(IMMUTABLE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(909); match(STABLE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(910); match(VOLATILE);
				setState(912);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(911); match(EXTERNAL);
					}
				}

				setState(914); match(SECURITY);
				setState(915); match(INVOKER);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(917);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(916); match(EXTERNAL);
					}
				}

				setState(919); match(SECURITY);
				setState(920); match(DEFINER);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(921); match(COST);
				setState(922); ((Function_actionContext)_localctx).execution_cost = match(NUMBER);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(923); match(ROWS);
				setState(924); ((Function_actionContext)_localctx).result_rows = match(NUMBER);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(925); match(SET);
				setState(926); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(932);
				switch (_input.LA(1)) {
				case TO:
					{
					setState(927); match(TO);
					setState(928); ((Function_actionContext)_localctx).value = identifier();
					}
					break;
				case EQUAL:
					{
					setState(929); match(EQUAL);
					setState(930); ((Function_actionContext)_localctx).value = identifier();
					}
					break;
				case DEFAULT:
					{
					setState(931); match(DEFAULT);
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
				setState(934); match(SET);
				setState(935); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(936); match(FROM);
				setState(937); match(CURRENT);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(939); match(RESET);
				setState(940); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(941); match(RESET);
				setState(942); match(ALL);
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
			setState(945); match(ALTER);
			setState(946); match(DEFAULT);
			setState(947); match(PRIVILEGES);
			setState(958);
			_la = _input.LA(1);
			if (_la==FOR) {
				{
				setState(948); match(FOR);
				setState(949);
				_la = _input.LA(1);
				if ( !(_la==ROLE || _la==USER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(950); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
				((Alter_default_privilegesContext)_localctx).target_role.add(((Alter_default_privilegesContext)_localctx).identifier);
				setState(955);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(951); match(COMMA);
					setState(952); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
					((Alter_default_privilegesContext)_localctx).target_role.add(((Alter_default_privilegesContext)_localctx).identifier);
					}
					}
					setState(957);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(970);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(960); match(IN);
				setState(961); match(SCHEMA);
				setState(962); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
				((Alter_default_privilegesContext)_localctx).schema_name.add(((Alter_default_privilegesContext)_localctx).identifier);
				setState(967);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(963); match(COMMA);
					setState(964); ((Alter_default_privilegesContext)_localctx).identifier = identifier();
					((Alter_default_privilegesContext)_localctx).schema_name.add(((Alter_default_privilegesContext)_localctx).identifier);
					}
					}
					setState(969);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(972); abbreviated_grant_or_revoke();
			}
		}
		catch (RecognitionException re) {
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
			setState(1110);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(974); match(GRANT);
				setState(987);
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
					setState(975);
					_la = _input.LA(1);
					if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(980);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(976); match(COMMA);
						setState(977);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(982);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(983); match(ALL);
					setState(985);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(984); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(989); match(ON);
				setState(990); match(TABLES);
				setState(991); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(992); match(GRANT);
				setState(1005);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					{
					setState(993);
					_la = _input.LA(1);
					if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(998);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(994); match(COMMA);
						setState(995);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1000);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(1001); match(ALL);
					setState(1003);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1002); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1007); match(ON);
				setState(1008); match(SEQUENCES);
				setState(1009); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1010); match(GRANT);
				setState(1016);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1011); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1012); match(ALL);
					setState(1014);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1013); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1018); match(ON);
				setState(1019); match(FUNCTIONS);
				setState(1020); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1021); match(GRANT);
				setState(1027);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1022); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1023); match(ALL);
					setState(1025);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1024); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1029); match(ON);
				setState(1030); match(TYPES);
				setState(1031); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1032); match(REVOKE);
				setState(1036);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1033); match(GRANT);
					setState(1034); match(OPTION);
					setState(1035); match(FOR);
					}
				}

				setState(1050);
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
					setState(1038);
					_la = _input.LA(1);
					if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1043);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1039); match(COMMA);
						setState(1040);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1045);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(1046); match(ALL);
					setState(1048);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1047); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1052); match(ON);
				setState(1053); match(TABLES);
				setState(1054); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1055); match(REVOKE);
				setState(1059);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1056); match(GRANT);
					setState(1057); match(OPTION);
					setState(1058); match(FOR);
					}
				}

				setState(1073);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					{
					setState(1061);
					_la = _input.LA(1);
					if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1066);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1062); match(COMMA);
						setState(1063);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1068);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(1069); match(ALL);
					setState(1071);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1070); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1075); match(ON);
				setState(1076); match(SEQUENCES);
				setState(1077); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1078); match(REVOKE);
				setState(1082);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1079); match(GRANT);
					setState(1080); match(OPTION);
					setState(1081); match(FOR);
					}
				}

				setState(1089);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1084); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1085); match(ALL);
					setState(1087);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1086); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1091); match(ON);
				setState(1092); match(FUNCTIONS);
				setState(1093); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1094); match(REVOKE);
				setState(1098);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1095); match(GRANT);
					setState(1096); match(OPTION);
					setState(1097); match(FOR);
					}
				}

				setState(1105);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1100); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1101); match(ALL);
					setState(1103);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1102); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1107); match(ON);
				setState(1108); match(TYPES);
				setState(1109); revoke_from_cascade_restrict();
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
			setState(1165);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1112); match(ALTER);
				setState(1113); match(SEQUENCE);
				setState(1116);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1114); match(IF);
					setState(1115); match(EXISTS);
					}
				}

				setState(1118); ((Alter_sequence_statementContext)_localctx).name = schema_qualified_name();
				setState(1129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OWNED || _la==CACHE || ((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (CYCLE - 160)) | (1L << (INCREMENT - 160)) | (1L << (MAXVALUE - 160)) | (1L << (MINVALUE - 160)) | (1L << (NO - 160)))) != 0) || _la==RESTART || _la==START) {
					{
					setState(1127);
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
						setState(1119); sequence_body();
						}
						break;
					case RESTART:
						{
						setState(1120); match(RESTART);
						setState(1125);
						switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
						case 1:
							{
							setState(1122);
							_la = _input.LA(1);
							if (_la==WITH) {
								{
								setState(1121); match(WITH);
								}
							}

							setState(1124); ((Alter_sequence_statementContext)_localctx).restart = identifier();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(1131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1132); match(ALTER);
				setState(1133); match(SEQUENCE);
				setState(1136);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1134); match(IF);
					setState(1135); match(EXISTS);
					}
				}

				setState(1138); ((Alter_sequence_statementContext)_localctx).name = schema_qualified_name();
				setState(1139); match(OWNER);
				setState(1140); match(TO);
				setState(1141); ((Alter_sequence_statementContext)_localctx).new_owner = schema_qualified_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1143); match(ALTER);
				setState(1144); match(SEQUENCE);
				setState(1147);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1145); match(IF);
					setState(1146); match(EXISTS);
					}
				}

				setState(1149); ((Alter_sequence_statementContext)_localctx).name = schema_qualified_name();
				setState(1150); match(RENAME);
				setState(1151); match(TO);
				setState(1152); ((Alter_sequence_statementContext)_localctx).new_name = schema_qualified_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1154); match(ALTER);
				setState(1155); match(SEQUENCE);
				setState(1158);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1156); match(IF);
					setState(1157); match(EXISTS);
					}
				}

				setState(1160); ((Alter_sequence_statementContext)_localctx).name = schema_qualified_name();
				setState(1161); match(SET);
				setState(1162); match(SCHEMA);
				setState(1163); ((Alter_sequence_statementContext)_localctx).new_schema = schema_qualified_name();
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
			setState(1167); match(CREATE);
			setState(1169);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(1168); match(UNIQUE);
				}
			}

			setState(1171); match(INDEX);
			setState(1173);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(1172); match(CONCURRENTLY);
				}
				break;
			}
			setState(1176);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				{
				setState(1175); ((Index_statementContext)_localctx).name = schema_qualified_name();
				}
				break;
			}
			setState(1178); match(ON);
			setState(1179); ((Index_statementContext)_localctx).table_name = schema_qualified_name();
			setState(1182);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(1180); match(USING);
				setState(1181); ((Index_statementContext)_localctx).method = schema_qualified_name();
				}
			}

			setState(1184); sort_specifier_paren();
			setState(1186);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1185); param_clause();
				}
			}

			setState(1190);
			_la = _input.LA(1);
			if (_la==TABLESPACE) {
				{
				setState(1188); match(TABLESPACE);
				setState(1189); ((Index_statementContext)_localctx).tablespace_name = schema_qualified_name();
				}
			}

			setState(1194);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1192); match(WHERE);
				setState(1193); ((Index_statementContext)_localctx).predic = boolean_value_expression();
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
			setState(1196); match(CREATE);
			setState(1197); match(EXTENSION);
			setState(1201);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1198); match(IF);
				setState(1199); match(NOT);
				setState(1200); match(EXISTS);
				}
			}

			setState(1203); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(1205);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1204); match(WITH);
				}
			}

			setState(1209);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(1207); match(SCHEMA);
				setState(1208); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(1213);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(1211); match(VERSION);
				setState(1212); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(1217);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(1215); match(FROM);
				setState(1216); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
			setState(1252);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1219); match(CREATE);
				setState(1222);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(1220); match(OR);
					setState(1221); match(REPLACE);
					}
				}

				setState(1225);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1224); match(PROCEDURAL);
					}
				}

				setState(1227); match(LANGUAGE);
				setState(1228); ((Create_language_statementContext)_localctx).name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1229); match(CREATE);
				setState(1232);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(1230); match(OR);
					setState(1231); match(REPLACE);
					}
				}

				setState(1235);
				_la = _input.LA(1);
				if (_la==TRUSTED) {
					{
					setState(1234); match(TRUSTED);
					}
				}

				setState(1238);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1237); match(PROCEDURAL);
					}
				}

				setState(1240); match(LANGUAGE);
				setState(1241); ((Create_language_statementContext)_localctx).name = identifier();
				setState(1242); match(HANDLER);
				setState(1243); ((Create_language_statementContext)_localctx).call_handler = schema_qualified_name();
				setState(1246);
				_la = _input.LA(1);
				if (_la==INLINE) {
					{
					setState(1244); match(INLINE);
					setState(1245); ((Create_language_statementContext)_localctx).inline_handler = schema_qualified_name();
					}
				}

				setState(1250);
				_la = _input.LA(1);
				if (_la==VALIDATOR) {
					{
					setState(1248); match(VALIDATOR);
					setState(1249); ((Create_language_statementContext)_localctx).valfunction = schema_qualified_name();
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
			setState(1254); match(CREATE);
			setState(1255); match(EVENT);
			setState(1256); match(TRIGGER);
			setState(1257); ((Create_event_triggerContext)_localctx).name = schema_qualified_name();
			setState(1258); match(ON);
			setState(1259); ((Create_event_triggerContext)_localctx).event = schema_qualified_name();
			setState(1280);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(1260); match(WHEN);
				setState(1261); ((Create_event_triggerContext)_localctx).filter_variable = schema_qualified_name();
				setState(1276); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1262); match(IN);
					setState(1263); match(LEFT_PAREN);
					setState(1264); ((Create_event_triggerContext)_localctx).Character_String_Literal = match(Character_String_Literal);
					((Create_event_triggerContext)_localctx).filter_value.add(((Create_event_triggerContext)_localctx).Character_String_Literal);
					setState(1269);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1265); match(COMMA);
						setState(1266); ((Create_event_triggerContext)_localctx).Character_String_Literal = match(Character_String_Literal);
						((Create_event_triggerContext)_localctx).filter_value.add(((Create_event_triggerContext)_localctx).Character_String_Literal);
						}
						}
						setState(1271);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1272); match(RIGHT_PAREN);
					setState(1274);
					_la = _input.LA(1);
					if (_la==AND) {
						{
						setState(1273); match(AND);
						}
					}

					}
					}
					setState(1278); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IN );
				}
			}

			setState(1282); match(EXECUTE);
			setState(1283); match(PROCEDURE);
			setState(1284); ((Create_event_triggerContext)_localctx).funct_name = value_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(1322);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1286); match(SET);
				setState(1288);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(1287);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1290); ((Set_statementContext)_localctx).config_param = identifier();
				setState(1291);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1292); set_statement_value();
				setState(1297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1293); match(COMMA);
					setState(1294); set_statement_value();
					}
					}
					setState(1299);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1300); match(SET);
				setState(1302);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(1301);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(1304); match(TIME);
				setState(1305); match(ZONE);
				setState(1309);
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
					setState(1306); ((Set_statementContext)_localctx).timezone = identifier();
					}
					break;
				case LOCAL:
					{
					setState(1307); match(LOCAL);
					}
					break;
				case DEFAULT:
					{
					setState(1308); match(DEFAULT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1311); match(COMMA);
					setState(1315);
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
						setState(1312); ((Set_statementContext)_localctx).timezone = identifier();
						}
						break;
					case LOCAL:
						{
						setState(1313); match(LOCAL);
						}
						break;
					case DEFAULT:
						{
						setState(1314); match(DEFAULT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(1321);
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
			setState(1330);
			switch (_input.LA(1)) {
			case ANY:
			case CASE:
			case CAST:
			case FALSE:
			case NOT:
			case NULL:
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
				setState(1324); ((Set_statement_valueContext)_localctx).value = value_expression();
				}
				break;
			case QUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1325); match(QUOTE);
				setState(1326); ((Set_statement_valueContext)_localctx).value = value_expression();
				setState(1327); match(QUOTE);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1329); match(DEFAULT);
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
			setState(1332); match(CREATE);
			setState(1334);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1333); match(CONSTRAINT);
				}
			}

			setState(1336); match(TRIGGER);
			setState(1337); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(1342);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(1338); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(1339); match(INSTEAD);
				setState(1340); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(1341); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1364); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1359);
				switch (_input.LA(1)) {
				case INSERT:
					{
					setState(1344); match(INSERT);
					}
					break;
				case DELETE:
					{
					setState(1345); match(DELETE);
					}
					break;
				case TRUNCATE:
					{
					setState(1346); match(TRUNCATE);
					}
					break;
				case UPDATE:
					{
					{
					setState(1347); match(UPDATE);
					setState(1357);
					_la = _input.LA(1);
					if (_la==OF) {
						{
						setState(1348); match(OF);
						setState(1349); ((Create_trigger_statementContext)_localctx).identifier = identifier();
						((Create_trigger_statementContext)_localctx).columnName.add(((Create_trigger_statementContext)_localctx).identifier);
						setState(1354);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1350); match(COMMA);
							setState(1351); ((Create_trigger_statementContext)_localctx).identifier = identifier();
							((Create_trigger_statementContext)_localctx).columnName.add(((Create_trigger_statementContext)_localctx).identifier);
							}
							}
							setState(1356);
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
				setState(1362);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(1361); match(OR);
					}
				}

				}
				}
				setState(1366); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DELETE || _la==TRUNCATE || _la==UPDATE || _la==INSERT );
			setState(1368); match(ON);
			setState(1369); ((Create_trigger_statementContext)_localctx).tabl_name = schema_qualified_name();
			setState(1372);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(1370); match(FROM);
				setState(1371); ((Create_trigger_statementContext)_localctx).referenced_table_name = schema_qualified_name();
				}
			}

			setState(1383);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				{
				setState(1374); match(NOT);
				setState(1375); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(1377);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(1376); match(DEFERRABLE);
					}
				}

				{
				setState(1379); match(INITIALLY);
				setState(1380); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(1381); match(INITIALLY);
				setState(1382); match(DEFERRED);
				}
				}
				break;
			}
			setState(1391);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(1385); match(FOR);
				setState(1387);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(1386); match(EACH);
					}
				}

				setState(1389); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(1390); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1395);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(1393); match(WHEN);
				{
				setState(1394); boolean_value_expression();
				}
				}
			}

			setState(1397); match(EXECUTE);
			setState(1398); match(PROCEDURE);
			setState(1399); ((Create_trigger_statementContext)_localctx).func_name = schema_qualified_name();
			setState(1400); match(LEFT_PAREN);
			setState(1402);
			_la = _input.LA(1);
			if (((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0)) {
				{
				setState(1401); ((Create_trigger_statementContext)_localctx).identifier = identifier();
				((Create_trigger_statementContext)_localctx).arguments.add(((Create_trigger_statementContext)_localctx).identifier);
				}
			}

			setState(1408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1404); match(COMMA);
				setState(1405); ((Create_trigger_statementContext)_localctx).identifier = identifier();
				((Create_trigger_statementContext)_localctx).arguments.add(((Create_trigger_statementContext)_localctx).identifier);
				}
				}
				setState(1410);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1411); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(1795);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1413); match(REVOKE);
				setState(1417);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1414); match(GRANT);
					setState(1415); match(OPTION);
					setState(1416); match(FOR);
					}
				}

				setState(1431);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1419);
					_la = _input.LA(1);
					if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1424);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1420); match(COMMA);
						setState(1421);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1426);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ALL:
					{
					setState(1427); match(ALL);
					setState(1429);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1428); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1433); match(ON);
				setState(1451);
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
					setState(1438); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1435);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1434); match(TABLE);
							}
						}

						setState(1437); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
						((Revoke_statementContext)_localctx).table_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
						}
						}
						setState(1440); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (TABLE - 114)) | (1L << (ADMIN - 114)) | (1L << (ALWAYS - 114)) | (1L << (ARRAY - 114)) | (1L << (AVG - 114)) | (1L << (BETWEEN - 114)) | (1L << (BY - 114)) | (1L << (CACHE - 114)) | (1L << (CALLED - 114)) | (1L << (CLASS - 114)) | (1L << (CENTURY - 114)) | (1L << (CHARACTER - 114)) | (1L << (CHECK - 114)) | (1L << (CLUSTER - 114)) | (1L << (COLLECT - 114)) | (1L << (COALESCE - 114)) | (1L << (COLUMN - 114)) | (1L << (COMMENT - 114)) | (1L << (COMMENTS - 114)) | (1L << (COMMIT - 114)) | (1L << (CONCURRENTLY - 114)) | (1L << (CONFIGURATION - 114)) | (1L << (COST - 114)) | (1L << (COUNT - 114)) | (1L << (CUBE - 114)) | (1L << (CURRENT - 114)) | (1L << (CYCLE - 114)) | (1L << (DATA - 114)) | (1L << (DAY - 114)) | (1L << (DEC - 114)) | (1L << (DECADE - 114)) | (1L << (DEFINER - 114)) | (1L << (DICTIONARY - 114)) | (1L << (DISABLE - 114)) | (1L << (DOW - 114)) | (1L << (DOY - 114)) | (1L << (DROP - 114)) | (1L << (ENABLE - 114)) | (1L << (EPOCH - 114)) | (1L << (EVENT - 114)) | (1L << (EVERY - 114)) | (1L << (EXISTS - 114)) | (1L << (EXTENDED - 114)) | (1L << (EXTERNAL - 114)))) != 0) || ((((_la - 178)) & ~0x3f) == 0 && ((1L << (_la - 178)) & ((1L << (EXTRACT - 178)) | (1L << (FAMILY - 178)) | (1L << (FILTER - 178)) | (1L << (FIRST - 178)) | (1L << (FORMAT - 178)) | (1L << (FUSION - 178)) | (1L << (GROUPING - 178)) | (1L << (HASH - 178)) | (1L << (INHERIT - 178)) | (1L << (INDEX - 178)) | (1L << (INCREMENT - 178)) | (1L << (INPUT - 178)) | (1L << (INSERT - 178)) | (1L << (INTERSECTION - 178)) | (1L << (ISCACHABLE - 178)) | (1L << (ISODOW - 178)) | (1L << (ISOYEAR - 178)) | (1L << (ISSTRICT - 178)) | (1L << (LANGUAGE - 178)) | (1L << (LARGE - 178)) | (1L << (LAST - 178)) | (1L << (LESS - 178)) | (1L << (LIST - 178)) | (1L << (LOCATION - 178)) | (1L << (MAIN - 178)) | (1L << (MATCH - 178)) | (1L << (MAX - 178)) | (1L << (MAXVALUE - 178)) | (1L << (MICROSECONDS - 178)) | (1L << (MILLENNIUM - 178)) | (1L << (MILLISECONDS - 178)) | (1L << (MIN - 178)) | (1L << (MINVALUE - 178)) | (1L << (MINUTE - 178)) | (1L << (MONTH - 178)) | (1L << (NATIONAL - 178)) | (1L << (NO - 178)) | (1L << (NONE - 178)) | (1L << (NULLIF - 178)) | (1L << (OBJECT - 178)) | (1L << (ON - 178)) | (1L << (ONLY - 178)) | (1L << (OPTION - 178)) | (1L << (OPTIONS - 178)) | (1L << (OVER - 178)) | (1L << (OVERWRITE - 178)) | (1L << (PARSER - 178)) | (1L << (PARTIAL - 178)) | (1L << (PARTITION - 178)) | (1L << (PARTITIONS - 178)) | (1L << (PLAIN - 178)) | (1L << (PRECISION - 178)) | (1L << (PUBLIC - 178)) | (1L << (PURGE - 178)) | (1L << (QUARTER - 178)) | (1L << (RANGE - 178)) | (1L << (REGCONFIG - 178)) | (1L << (REGEXP - 178)) | (1L << (RENAME - 178)) | (1L << (REPLICA - 178)))) != 0) || ((((_la - 242)) & ~0x3f) == 0 && ((1L << (_la - 242)) & ((1L << (RESET - 242)) | (1L << (RESTART - 242)) | (1L << (RLIKE - 242)) | (1L << (ROLLUP - 242)) | (1L << (SEARCH - 242)) | (1L << (SECOND - 242)) | (1L << (SECURITY - 242)) | (1L << (SERVER - 242)) | (1L << (SET - 242)) | (1L << (SIMILAR - 242)) | (1L << (SIMPLE - 242)) | (1L << (STABLE - 242)) | (1L << (START - 242)) | (1L << (STATISTICS - 242)) | (1L << (STORAGE - 242)) | (1L << (STDDEV_POP - 242)) | (1L << (STDDEV_SAMP - 242)) | (1L << (SUBPARTITION - 242)) | (1L << (SUM - 242)) | (1L << (TABLESPACE - 242)) | (1L << (TEMPLATE - 242)) | (1L << (THAN - 242)) | (1L << (TIMEZONE - 242)) | (1L << (TIMEZONE_HOUR - 242)) | (1L << (TIMEZONE_MINUTE - 242)) | (1L << (TRIM - 242)) | (1L << (TO - 242)) | (1L << (TYPE - 242)) | (1L << (TYPES - 242)) | (1L << (UNKNOWN - 242)) | (1L << (UNLOGGED - 242)) | (1L << (USER - 242)) | (1L << (VALID - 242)) | (1L << (VALIDATE - 242)) | (1L << (VALUES - 242)) | (1L << (VAR_SAMP - 242)) | (1L << (VAR_POP - 242)) | (1L << (VARYING - 242)) | (1L << (VERSION - 242)) | (1L << (VOLATILE - 242)) | (1L << (WEEK - 242)) | (1L << (WINDOW - 242)) | (1L << (WRAPPER - 242)) | (1L << (YEAR - 242)) | (1L << (ZONE - 242)) | (1L << (BOOLEAN - 242)) | (1L << (BOOL - 242)) | (1L << (BIT - 242)) | (1L << (VARBIT - 242)) | (1L << (INT1 - 242)) | (1L << (INT2 - 242)) | (1L << (INT4 - 242)) | (1L << (INT8 - 242)) | (1L << (TINYINT - 242)) | (1L << (SMALLINT - 242)) | (1L << (INT - 242)) | (1L << (INTEGER - 242)) | (1L << (BIGINT - 242)) | (1L << (FLOAT4 - 242)) | (1L << (FLOAT8 - 242)) | (1L << (REAL - 242)) | (1L << (FLOAT - 242)))) != 0) || ((((_la - 306)) & ~0x3f) == 0 && ((1L << (_la - 306)) & ((1L << (DOUBLE - 306)) | (1L << (NUMERIC - 306)) | (1L << (DECIMAL - 306)) | (1L << (CHAR - 306)) | (1L << (VARCHAR - 306)) | (1L << (NCHAR - 306)) | (1L << (NVARCHAR - 306)) | (1L << (DATE - 306)) | (1L << (TIME - 306)) | (1L << (TIMETZ - 306)) | (1L << (TIMESTAMP - 306)) | (1L << (TIMESTAMPTZ - 306)) | (1L << (TEXT - 306)) | (1L << (UUID - 306)) | (1L << (VARBINARY - 306)) | (1L << (BLOB - 306)) | (1L << (BYTEA - 306)) | (1L << (INET4 - 306)) | (1L << (INET - 306)) | (1L << (INTERVAL - 306)) | (1L << (VOID - 306)) | (1L << (DOUBLE_QUOTE - 306)) | (1L << (Identifier - 306)) | (1L << (QuotedIdentifier - 306)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1442); match(ALL);
					setState(1443); match(TABLES);
					setState(1444); match(IN);
					setState(1445); match(SCHEMA);
					setState(1447); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1446); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
						}
						}
						setState(1449); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1453); revoke_from_cascade_restrict();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1455); match(REVOKE);
				setState(1459);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1456); match(GRANT);
					setState(1457); match(OPTION);
					setState(1458); match(FOR);
					}
				}

				setState(1492);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1473); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1461);
						_la = _input.LA(1);
						if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1462); match(LEFT_PAREN);
						setState(1463); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
						setState(1468);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1464); match(COMMA);
							setState(1465); ((Revoke_statementContext)_localctx).identifier = identifier();
							((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
							}
							}
							setState(1470);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1471); match(RIGHT_PAREN);
						}
						}
						setState(1475); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1477); match(ALL);
					setState(1479);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1478); match(PRIVILEGES);
						}
					}

					setState(1481); match(LEFT_PAREN);
					setState(1482); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
					setState(1487);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1483); match(COMMA);
						setState(1484); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).column.add(((Revoke_statementContext)_localctx).identifier);
						}
						}
						setState(1489);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1490); match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1494); match(ON);
				setState(1496);
				_la = _input.LA(1);
				if (_la==TABLE) {
					{
					setState(1495); match(TABLE);
					}
				}

				setState(1498); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
				((Revoke_statementContext)_localctx).table_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
				setState(1503);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1499); match(COMMA);
					setState(1500); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
					((Revoke_statementContext)_localctx).table_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
					}
					}
					setState(1505);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1506); revoke_from_cascade_restrict();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1508); match(REVOKE);
				setState(1512);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1509); match(GRANT);
					setState(1510); match(OPTION);
					setState(1511); match(FOR);
					}
				}

				setState(1523);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(1515); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1514);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1517); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1519); match(ALL);
					setState(1521);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1520); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1525); match(ON);
				setState(1547);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1526); match(SEQUENCE);
					setState(1527); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
					((Revoke_statementContext)_localctx).sequence_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
					setState(1532);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1528); match(COMMA);
						setState(1529); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
						((Revoke_statementContext)_localctx).sequence_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
						}
						}
						setState(1534);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ALL:
					{
					setState(1535); match(ALL);
					setState(1536); match(SEQUENCES);
					setState(1537); match(IN);
					setState(1538); match(SCHEMA);
					setState(1539); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
					setState(1544);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1540); match(COMMA);
						setState(1541); ((Revoke_statementContext)_localctx).identifier = identifier();
						((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
						}
						}
						setState(1546);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1549); revoke_from_cascade_restrict();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1551); match(REVOKE);
				setState(1555);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1552); match(GRANT);
					setState(1553); match(OPTION);
					setState(1554); match(FOR);
					}
				}

				setState(1566);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1558); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1557);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1560); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(1562); match(ALL);
					setState(1564);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1563); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1568); match(ON);
				setState(1569); match(DATABASE);
				setState(1570); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).database_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1575);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1571); match(COMMA);
					setState(1572); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).database_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1577);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1578); revoke_from_cascade_restrict();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1580); match(REVOKE);
				setState(1584);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1581); match(GRANT);
					setState(1582); match(OPTION);
					setState(1583); match(FOR);
					}
				}

				setState(1591);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1586); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1587); match(ALL);
					setState(1589);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1588); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1593); match(ON);
				setState(1594); match(FOREIGN);
				setState(1595); match(DATA);
				setState(1596); match(WRAPPER);
				setState(1597); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
				((Revoke_statementContext)_localctx).fdw_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
				setState(1602);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1598); match(COMMA);
					setState(1599); ((Revoke_statementContext)_localctx).schema_qualified_name = schema_qualified_name();
					((Revoke_statementContext)_localctx).fdw_name.add(((Revoke_statementContext)_localctx).schema_qualified_name);
					}
					}
					setState(1604);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1605); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
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
				setState(1622); match(SERVER);
				setState(1623); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).server_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1624); match(COMMA);
					setState(1625); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).server_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1630);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1631); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1633); match(REVOKE);
				setState(1637);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1634); match(GRANT);
					setState(1635); match(OPTION);
					setState(1636); match(FOR);
					}
				}

				setState(1644);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1639); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1640); match(ALL);
					setState(1642);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1641); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1646); match(ON);
				setState(1649);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1647); function_definition();
					}
					break;
				case ALL:
					{
					setState(1648); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1651); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1653); match(REVOKE);
				setState(1657);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1654); match(GRANT);
					setState(1655); match(OPTION);
					setState(1656); match(FOR);
					}
				}

				setState(1664);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1659); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1660); match(ALL);
					setState(1662);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1661); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1666); match(ON);
				setState(1667); match(LANGUAGE);
				setState(1668); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).lang_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1673);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1669); match(COMMA);
					setState(1670); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).lang_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1675);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1676); revoke_from_cascade_restrict();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1678); match(REVOKE);
				setState(1682);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1679); match(GRANT);
					setState(1680); match(OPTION);
					setState(1681); match(FOR);
					}
				}

				setState(1697);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1689); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(1689);
						switch (_input.LA(1)) {
						case SELECT:
							{
							setState(1684); match(SELECT);
							}
							break;
						case UPDATE:
							{
							setState(1685); match(UPDATE);
							setState(1687);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1686); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(1691); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1693); match(ALL);
					setState(1695);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1694); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1699); match(ON);
				setState(1700); match(LARGE);
				setState(1701); match(OBJECT);
				setState(1702); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).loid.add(((Revoke_statementContext)_localctx).identifier);
				setState(1707);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1703); match(COMMA);
					setState(1704); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).loid.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1709);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1710); revoke_from_cascade_restrict();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1712); match(REVOKE);
				setState(1716);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1713); match(GRANT);
					setState(1714); match(OPTION);
					setState(1715); match(FOR);
					}
				}

				setState(1730);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1722); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1718);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1720);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1719); match(COMMA);
							}
						}

						}
						}
						setState(1724); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1726); match(ALL);
					setState(1728);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1727); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1732); match(ON);
				setState(1733); match(SCHEMA);
				setState(1734); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1739);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1735); match(COMMA);
					setState(1736); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).schema_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1741);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1742); revoke_from_cascade_restrict();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1744); match(REVOKE);
				setState(1748);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1745); match(GRANT);
					setState(1746); match(OPTION);
					setState(1747); match(FOR);
					}
				}

				setState(1755);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1750); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1751); match(ALL);
					setState(1753);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1752); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1757); match(ON);
				setState(1758); match(TABLESPACE);
				setState(1759); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).tablespace_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1764);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1760); match(COMMA);
					setState(1761); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).tablespace_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1766);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1767); revoke_from_cascade_restrict();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1769); match(REVOKE);
				setState(1773);
				switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
				case 1:
					{
					setState(1770); match(ADMIN);
					setState(1771); match(OPTION);
					setState(1772); match(FOR);
					}
					break;
				}
				setState(1775); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1780);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1776); match(COMMA);
					setState(1777); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1782);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1783); match(FROM);
				setState(1784); ((Revoke_statementContext)_localctx).identifier = identifier();
				((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
				setState(1789);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1785); match(COMMA);
					setState(1786); ((Revoke_statementContext)_localctx).identifier = identifier();
					((Revoke_statementContext)_localctx).role_name.add(((Revoke_statementContext)_localctx).identifier);
					}
					}
					setState(1791);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1793);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(1792);
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
			setState(1797); match(FROM);
			setState(1803);
			switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
			case 1:
				{
				setState(1799);
				_la = _input.LA(1);
				if (_la==GROUP) {
					{
					setState(1798); match(GROUP);
					}
				}

				setState(1801); ((Revoke_from_cascade_restrictContext)_localctx).identifier = identifier();
				((Revoke_from_cascade_restrictContext)_localctx).role_name.add(((Revoke_from_cascade_restrictContext)_localctx).identifier);
				}
				break;
			case 2:
				{
				setState(1802); match(PUBLIC);
				}
				break;
			}
			setState(1815);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1805); match(COMMA);
				setState(1811);
				switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
				case 1:
					{
					setState(1807);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1806); match(GROUP);
						}
					}

					setState(1809); ((Revoke_from_cascade_restrictContext)_localctx).identifier = identifier();
					((Revoke_from_cascade_restrictContext)_localctx).role_name.add(((Revoke_from_cascade_restrictContext)_localctx).identifier);
					}
					break;
				case 2:
					{
					setState(1810); match(PUBLIC);
					}
					break;
				}
				}
				}
				setState(1817);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1819);
			_la = _input.LA(1);
			if (_la==CASCADE || _la==RESTRICT) {
				{
				setState(1818);
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
			setState(2153);
			switch ( getInterpreter().adaptivePredict(_input,261,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1821); match(GRANT);
				setState(1834);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1822);
					_la = _input.LA(1);
					if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1827);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1823); match(COMMA);
						setState(1824);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (TRIGGER - 97)) | (1L << (TRUNCATE - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1829);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ALL:
					{
					setState(1830); match(ALL);
					setState(1832);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1831); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1836); match(ON);
				setState(1860);
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
					setState(1838);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1837); match(TABLE);
						}
					}

					setState(1844); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1840); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
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
						_alt = getInterpreter().adaptivePredict(_input,210,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(1848); match(ALL);
					setState(1849); match(TABLES);
					setState(1850); match(IN);
					setState(1851); match(SCHEMA);
					setState(1856); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1852); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(1854);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1853); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1858); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,212,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1862); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1864); match(GRANT);
				setState(1890);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1874); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1865);
						_la = _input.LA(1);
						if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1866); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
						setState(1871);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1867); match(COMMA);
							setState(1868); ((Grant_statementContext)_localctx).identifier = identifier();
							((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
							}
							}
							setState(1873);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						setState(1876); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REFERENCES - 97)) | (1L << (SELECT - 97)) | (1L << (UPDATE - 97)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1878); match(ALL);
					setState(1880);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1879); match(PRIVILEGES);
						}
					}

					setState(1882); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
					setState(1887);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1883); match(COMMA);
						setState(1884); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).column.add(((Grant_statementContext)_localctx).identifier);
						}
						}
						setState(1889);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1892); match(ON);
				setState(1900); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1894);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1893); match(TABLE);
							}
						}

						setState(1896); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
						setState(1898);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1897); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1902); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,221,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1904); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1906); match(GRANT);
				setState(1919);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					{
					setState(1907);
					_la = _input.LA(1);
					if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1912);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1908); match(COMMA);
						setState(1909);
						_la = _input.LA(1);
						if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SELECT - 107)) | (1L << (UPDATE - 107)) | (1L << (USAGE - 107)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1914);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ALL:
					{
					setState(1915); match(ALL);
					setState(1917);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1916); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1921); match(ON);
				setState(1947);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1931); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1922); match(SEQUENCE);
						setState(1923); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).sequence_name.add(((Grant_statementContext)_localctx).identifier);
						setState(1928);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1924); match(COMMA);
							setState(1925); ((Grant_statementContext)_localctx).identifier = identifier();
							((Grant_statementContext)_localctx).sequence_name.add(((Grant_statementContext)_localctx).identifier);
							}
							}
							setState(1930);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						setState(1933); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(1935); match(ALL);
					setState(1936); match(SEQUENCES);
					setState(1937); match(IN);
					setState(1938); match(SCHEMA);
					setState(1939); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
					setState(1944);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1940); match(COMMA);
						setState(1941); ((Grant_statementContext)_localctx).identifier = identifier();
						((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
						}
						}
						setState(1946);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1949); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1951); match(GRANT);
				setState(1964);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1952);
					_la = _input.LA(1);
					if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(1957);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1953); match(COMMA);
						setState(1954);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1959);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case ALL:
					{
					setState(1960); match(ALL);
					setState(1962);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1961); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1966); match(ON);
				setState(1967); match(DATABASE);
				setState(1968); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).database_name.add(((Grant_statementContext)_localctx).identifier);
				setState(1973);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1969); match(COMMA);
					setState(1970); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).database_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(1975);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1976); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1978); match(GRANT);
				setState(1984);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1979); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1980); match(ALL);
					setState(1982);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1981); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1986); match(ON);
				setState(1987); match(FOREIGN);
				setState(1988); match(DATA);
				setState(1989); match(WRAPPER);
				setState(1990); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).fdw_name.add(((Grant_statementContext)_localctx).identifier);
				setState(1995);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1991); match(COMMA);
					setState(1992); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).fdw_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(1997);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1998); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2000); match(GRANT);
				setState(2006);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(2001); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(2002); match(ALL);
					setState(2004);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2003); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2008); match(ON);
				setState(2009); match(FOREIGN);
				setState(2010); match(SERVER);
				setState(2011); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).server_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2016);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2012); match(COMMA);
					setState(2013); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).server_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2018);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2019); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2021); match(GRANT);
				setState(2027);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(2022); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(2023); match(ALL);
					setState(2025);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2024); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2029); match(ON);
				setState(2032);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(2030); function_definition();
					}
					break;
				case ALL:
					{
					setState(2031); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2034); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2036); match(GRANT);
				setState(2042);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(2037); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(2038); match(ALL);
					setState(2040);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2039); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2044); match(ON);
				setState(2045); match(LANGUAGE);
				setState(2046); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).lang_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2051);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2047); match(COMMA);
					setState(2048); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).lang_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2053);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2054); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2056); match(GRANT);
				setState(2069);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(2061); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2057);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(2059);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2058); match(COMMA);
							}
						}

						}
						}
						setState(2063); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
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
				setState(2072); match(LARGE);
				setState(2073); match(OBJECT);
				setState(2074); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).loid.add(((Grant_statementContext)_localctx).identifier);
				setState(2079);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2075); match(COMMA);
					setState(2076); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).loid.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2081);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2082); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2084); match(GRANT);
				setState(2097);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(2089); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2085);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(2087);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2086); match(COMMA);
							}
						}

						}
						}
						setState(2091); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(2093); match(ALL);
					setState(2095);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2094); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2099); match(ON);
				setState(2100); match(SCHEMA);
				setState(2101); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2102); match(COMMA);
					setState(2103); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).schema_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2109); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2111); match(GRANT);
				setState(2117);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(2112); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(2113); match(ALL);
					setState(2115);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(2114); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2119); match(ON);
				setState(2120); match(TABLESPACE);
				setState(2121); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).tablespace_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2122); match(COMMA);
					setState(2123); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).tablespace_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2129); grant_to_rule();
				setState(2130); match(GRANT);
				setState(2131); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2132); match(COMMA);
					setState(2133); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2139); match(TO);
				setState(2140); ((Grant_statementContext)_localctx).identifier = identifier();
				((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
				setState(2145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2141); match(COMMA);
					setState(2142); ((Grant_statementContext)_localctx).identifier = identifier();
					((Grant_statementContext)_localctx).role_name.add(((Grant_statementContext)_localctx).identifier);
					}
					}
					setState(2147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2151);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(2148); match(WITH);
					setState(2149); match(ADMIN);
					setState(2150); match(OPTION);
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
			setState(2155); match(TO);
			setState(2161);
			switch ( getInterpreter().adaptivePredict(_input,263,_ctx) ) {
			case 1:
				{
				setState(2157);
				_la = _input.LA(1);
				if (_la==GROUP) {
					{
					setState(2156); match(GROUP);
					}
				}

				{
				setState(2159); ((Grant_to_ruleContext)_localctx).identifier = identifier();
				((Grant_to_ruleContext)_localctx).role_name.add(((Grant_to_ruleContext)_localctx).identifier);
				}
				}
				break;
			case 2:
				{
				setState(2160); match(PUBLIC);
				}
				break;
			}
			setState(2173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2163); match(COMMA);
				setState(2169);
				switch ( getInterpreter().adaptivePredict(_input,265,_ctx) ) {
				case 1:
					{
					setState(2165);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(2164); match(GROUP);
						}
					}

					{
					setState(2167); ((Grant_to_ruleContext)_localctx).identifier = identifier();
					((Grant_to_ruleContext)_localctx).role_name.add(((Grant_to_ruleContext)_localctx).identifier);
					}
					}
					break;
				case 2:
					{
					setState(2168); match(PUBLIC);
					}
					break;
				}
				}
				}
				setState(2175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2179);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2176); match(WITH);
				setState(2177); match(GRANT);
				setState(2178); match(OPTION);
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
			setState(2181); match(COMMENT);
			setState(2182); match(ON);
			setState(2302);
			switch ( getInterpreter().adaptivePredict(_input,271,_ctx) ) {
			case 1:
				{
				setState(2183); match(AGGREGATE);
				setState(2184); ((Comment_on_statementContext)_localctx).agg_name = schema_qualified_name();
				setState(2185); match(LEFT_PAREN);
				setState(2194);
				_la = _input.LA(1);
				if (((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & ((1L << (SETOF - 109)) | (1L << (TRIGGER - 109)) | (1L << (CHARACTER - 109)) | (1L << (DEC - 109)))) != 0) || _la==NATIONAL || _la==REGCONFIG || ((((_la - 288)) & ~0x3f) == 0 && ((1L << (_la - 288)) & ((1L << (BOOLEAN - 288)) | (1L << (BOOL - 288)) | (1L << (BIT - 288)) | (1L << (VARBIT - 288)) | (1L << (INT1 - 288)) | (1L << (INT2 - 288)) | (1L << (INT4 - 288)) | (1L << (INT8 - 288)) | (1L << (TINYINT - 288)) | (1L << (SMALLINT - 288)) | (1L << (INT - 288)) | (1L << (INTEGER - 288)) | (1L << (BIGINT - 288)) | (1L << (FLOAT4 - 288)) | (1L << (FLOAT8 - 288)) | (1L << (REAL - 288)) | (1L << (REGCLASS - 288)) | (1L << (FLOAT - 288)) | (1L << (DOUBLE - 288)) | (1L << (NUMERIC - 288)) | (1L << (DECIMAL - 288)) | (1L << (CHAR - 288)) | (1L << (VARCHAR - 288)) | (1L << (NCHAR - 288)) | (1L << (NVARCHAR - 288)) | (1L << (DATE - 288)) | (1L << (TIME - 288)) | (1L << (TIMETZ - 288)) | (1L << (TIMESTAMP - 288)) | (1L << (TIMESTAMPTZ - 288)) | (1L << (TEXT - 288)) | (1L << (UUID - 288)) | (1L << (BINARY - 288)) | (1L << (VARBINARY - 288)) | (1L << (BLOB - 288)) | (1L << (BYTEA - 288)) | (1L << (INET4 - 288)) | (1L << (INET - 288)) | (1L << (INTERVAL - 288)) | (1L << (VOID - 288)))) != 0)) {
					{
					setState(2186); ((Comment_on_statementContext)_localctx).data_type = data_type();
					((Comment_on_statementContext)_localctx).agg_type.add(((Comment_on_statementContext)_localctx).data_type);
					setState(2191);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2187); match(COMMA);
						setState(2188); ((Comment_on_statementContext)_localctx).data_type = data_type();
						((Comment_on_statementContext)_localctx).agg_type.add(((Comment_on_statementContext)_localctx).data_type);
						}
						}
						setState(2193);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(2196); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(2198); match(CAST);
				setState(2199); match(LEFT_PAREN);
				setState(2200); ((Comment_on_statementContext)_localctx).source_type = data_type();
				setState(2201); match(AS);
				setState(2202); ((Comment_on_statementContext)_localctx).target_type = data_type();
				setState(2203); match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(2205); match(COLLATION);
				setState(2206); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 4:
				{
				setState(2207); match(COLUMN);
				setState(2208); ((Comment_on_statementContext)_localctx).column_name = schema_qualified_name();
				}
				break;
			case 5:
				{
				setState(2209); match(CONSTRAINT);
				setState(2210); ((Comment_on_statementContext)_localctx).constraint_name = schema_qualified_name();
				setState(2211); match(ON);
				setState(2212); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 6:
				{
				setState(2214); match(CONVERSION);
				setState(2215); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 7:
				{
				setState(2216); match(DATABASE);
				setState(2217); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 8:
				{
				setState(2218); match(DOMAIN);
				setState(2219); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 9:
				{
				setState(2220); match(EXTENSION);
				setState(2221); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 10:
				{
				setState(2222); match(FOREIGN);
				setState(2223); match(DATA);
				setState(2224); match(WRAPPER);
				setState(2225); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 11:
				{
				setState(2226); match(FOREIGN);
				setState(2227); match(TABLE);
				setState(2228); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 12:
				{
				setState(2229); function_definition();
				}
				break;
			case 13:
				{
				setState(2230); match(INDEX);
				setState(2231); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 14:
				{
				setState(2232); match(LARGE);
				setState(2233); match(OBJECT);
				setState(2234); ((Comment_on_statementContext)_localctx).large_object_oid = identifier();
				}
				break;
			case 15:
				{
				setState(2235); match(OPERATOR);
				setState(2236); ((Comment_on_statementContext)_localctx).operator_name = schema_qualified_name();
				setState(2237); match(LEFT_PAREN);
				setState(2238); ((Comment_on_statementContext)_localctx).left_type = data_type();
				setState(2239); match(COMMA);
				setState(2240); ((Comment_on_statementContext)_localctx).right_type = data_type();
				setState(2241); match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(2243); match(OPERATOR);
				setState(2244); match(CLASS);
				setState(2245); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(2246); match(USING);
				setState(2247); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 17:
				{
				setState(2249); match(OPERATOR);
				setState(2250); match(FAMILY);
				setState(2251); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(2252); match(USING);
				setState(2253); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 18:
				{
				setState(2256);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(2255); match(PROCEDURAL);
					}
				}

				setState(2258); match(LANGUAGE);
				setState(2259); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 19:
				{
				setState(2260); match(ROLE);
				setState(2261); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 20:
				{
				setState(2262); match(RULE);
				setState(2263); ((Comment_on_statementContext)_localctx).rule_name = schema_qualified_name();
				setState(2264); match(ON);
				setState(2265); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 21:
				{
				setState(2267); match(SCHEMA);
				setState(2268); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 22:
				{
				setState(2269); match(SEQUENCE);
				setState(2270); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 23:
				{
				setState(2271); match(SERVER);
				setState(2272); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 24:
				{
				setState(2273); match(TABLE);
				setState(2274); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 25:
				{
				setState(2275); match(TABLESPACE);
				setState(2276); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 26:
				{
				setState(2277); match(TEXT);
				setState(2278); match(SEARCH);
				setState(2279); match(CONFIGURATION);
				setState(2280); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 27:
				{
				setState(2281); match(TEXT);
				setState(2282); match(SEARCH);
				setState(2283); match(DICTIONARY);
				setState(2284); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 28:
				{
				setState(2285); match(TEXT);
				setState(2286); match(SEARCH);
				setState(2287); match(PARSER);
				setState(2288); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 29:
				{
				setState(2289); match(TEXT);
				setState(2290); match(SEARCH);
				setState(2291); match(TEMPLATE);
				setState(2292); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 30:
				{
				setState(2293); match(TRIGGER);
				setState(2294); ((Comment_on_statementContext)_localctx).trigger_name = schema_qualified_name();
				setState(2295); match(ON);
				setState(2296); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 31:
				{
				setState(2298); match(TYPE);
				setState(2299); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 32:
				{
				setState(2300); match(VIEW);
				setState(2301); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			}
			setState(2304); match(IS);
			setState(2305); match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode FUNCTION() { return getToken(SQLParser.FUNCTION, 0); }
		public List<TerminalNode> SECURITY() { return getTokens(SQLParser.SECURITY); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode NUMBER(int i) {
			return getToken(SQLParser.NUMBER, i);
		}
		public TerminalNode REPLACE() { return getToken(SQLParser.REPLACE, 0); }
		public List<TerminalNode> RETURNS() { return getTokens(SQLParser.RETURNS); }
		public TerminalNode WINDOW(int i) {
			return getToken(SQLParser.WINDOW, i);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
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
			setState(2307); match(CREATE);
			setState(2310);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(2308); match(OR);
				setState(2309); match(REPLACE);
				}
			}

			setState(2312); match(FUNCTION);
			setState(2313); function_parameters();
			setState(2332);
			switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
			case 1:
				{
				setState(2314); match(RETURNS);
				setState(2317);
				switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
				case 1:
					{
					setState(2315); ((Create_function_statementContext)_localctx).rettype = value_expression();
					}
					break;
				case 2:
					{
					setState(2316); ((Create_function_statementContext)_localctx).rettype_data = data_type();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(2319); match(RETURNS);
				setState(2320); match(TABLE);
				setState(2321); match(LEFT_PAREN);
				setState(2322); function_column_name_type();
				setState(2327);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2323); match(COMMA);
					setState(2324); function_column_name_type();
					}
					}
					setState(2329);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2330); match(RIGHT_PAREN);
				}
				break;
			}
			setState(2383); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(2383);
				switch ( getInterpreter().adaptivePredict(_input,280,_ctx) ) {
				case 1:
					{
					setState(2334); match(LANGUAGE);
					setState(2335); ((Create_function_statementContext)_localctx).lang_name = identifier();
					}
					break;
				case 2:
					{
					setState(2336);
					_la = _input.LA(1);
					if ( !(_la==IMMUTABLE || _la==STRICT || ((((_la - 253)) & ~0x3f) == 0 && ((1L << (_la - 253)) & ((1L << (STABLE - 253)) | (1L << (VOLATILE - 253)) | (1L << (WINDOW - 253)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case 3:
					{
					setState(2337); match(CALLED);
					setState(2338); match(ON);
					setState(2339); match(NULL);
					setState(2340); match(INPUT);
					}
					break;
				case 4:
					{
					setState(2341); match(RETURNS);
					setState(2342); match(NULL);
					setState(2343); match(ON);
					setState(2344); match(NULL);
					setState(2345); match(INPUT);
					}
					break;
				case 5:
					{
					setState(2347);
					_la = _input.LA(1);
					if (_la==EXTERNAL) {
						{
						setState(2346); match(EXTERNAL);
						}
					}

					setState(2349); match(SECURITY);
					setState(2350); match(INVOKER);
					}
					break;
				case 6:
					{
					setState(2352);
					_la = _input.LA(1);
					if (_la==EXTERNAL) {
						{
						setState(2351); match(EXTERNAL);
						}
					}

					setState(2354); match(SECURITY);
					setState(2355); match(DEFINER);
					}
					break;
				case 7:
					{
					setState(2356); match(COST);
					setState(2357); ((Create_function_statementContext)_localctx).execution_cost = match(NUMBER);
					}
					break;
				case 8:
					{
					setState(2358); match(ROWS);
					setState(2359); ((Create_function_statementContext)_localctx).result_rows = match(NUMBER);
					}
					break;
				case 9:
					{
					setState(2360); match(SET);
					setState(2361); ((Create_function_statementContext)_localctx).configuration_parameter = identifier();
					setState(2368);
					switch (_input.LA(1)) {
					case TO:
						{
						setState(2362); match(TO);
						setState(2363); ((Create_function_statementContext)_localctx).value = identifier();
						}
						break;
					case EQUAL:
						{
						setState(2364); match(EQUAL);
						setState(2365); ((Create_function_statementContext)_localctx).value = identifier();
						}
						break;
					case FROM:
						{
						setState(2366); match(FROM);
						setState(2367); match(CURRENT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2374);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2370); match(COMMA);
						setState(2371); ((Create_function_statementContext)_localctx).value = identifier();
						}
						}
						setState(2376);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 10:
					{
					setState(2377); match(AS);
					setState(2378); function_body();
					}
					break;
				case 11:
					{
					setState(2379); match(AS);
					setState(2380); match(Character_String_Literal);
					setState(2381); match(COMMA);
					setState(2382); match(Character_String_Literal);
					}
					break;
				}
				}
				setState(2385); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AS || _la==IMMUTABLE || ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (ROWS - 96)) | (1L << (RETURNS - 96)) | (1L << (STRICT - 96)) | (1L << (CALLED - 96)) | (1L << (COST - 96)))) != 0) || _la==EXTERNAL || _la==LANGUAGE || ((((_la - 248)) & ~0x3f) == 0 && ((1L << (_la - 248)) & ((1L << (SECURITY - 248)) | (1L << (SET - 248)) | (1L << (STABLE - 248)) | (1L << (VOLATILE - 248)) | (1L << (WINDOW - 248)))) != 0) );
			setState(2399);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2387); match(WITH);
				setState(2388); match(LEFT_PAREN);
				setState(2389); ((Create_function_statementContext)_localctx).function_attribute = function_attribute();
				((Create_function_statementContext)_localctx).attribute.add(((Create_function_statementContext)_localctx).function_attribute);
				setState(2394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2390); match(COMMA);
					setState(2391); ((Create_function_statementContext)_localctx).function_attribute = function_attribute();
					((Create_function_statementContext)_localctx).attribute.add(((Create_function_statementContext)_localctx).function_attribute);
					}
					}
					setState(2396);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2397); match(RIGHT_PAREN);
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
			setState(2401); ((Function_column_name_typeContext)_localctx).column_name = identifier();
			setState(2402); ((Function_column_name_typeContext)_localctx).column_type = data_type();
			}
		}
		catch (RecognitionException re) {
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
			setState(2404); ((Function_parametersContext)_localctx).name = schema_qualified_name();
			setState(2405); match(LEFT_PAREN);
			setState(2420);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << IN))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INOUT - 66)) | (1L << (NOT - 66)) | (1L << (NULL - 66)) | (1L << (OUT - 66)) | (1L << (SETOF - 66)) | (1L << (SOME - 66)) | (1L << (TRIGGER - 66)) | (1L << (TRUE - 66)) | (1L << (VARIADIC - 66)))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (REGCLASS - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (BINARY - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (LEFT_PAREN - 327)) | (1L << (PLUS - 327)) | (1L << (MINUS - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (NUMBER - 327)) | (1L << (REAL_NUMBER - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)) | (1L << (Character_String_Literal - 327)))) != 0)) {
				{
				setState(2406); function_arguments();
				setState(2408);
				_la = _input.LA(1);
				if (_la==DEFAULT || _la==EQUAL) {
					{
					setState(2407); function_def_value();
					}
				}

				setState(2417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2410); match(COMMA);
					setState(2411); function_arguments();
					setState(2413);
					_la = _input.LA(1);
					if (_la==DEFAULT || _la==EQUAL) {
						{
						setState(2412); function_def_value();
						}
					}

					}
					}
					setState(2419);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(2422); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(2424);
			_la = _input.LA(1);
			if ( !(_la==DEFAULT || _la==EQUAL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(2425); ((Function_def_valueContext)_localctx).def_value = value_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(2427); match(BeginDollarStringConstant);
			setState(2429); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2428); match(Text_between_Dollar);
				}
				}
				setState(2431); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Text_between_Dollar );
			setState(2433); match(EndDollarStringConstant);
			}
		}
		catch (RecognitionException re) {
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
			setState(2436);
			_la = _input.LA(1);
			if (_la==IN || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INOUT - 66)) | (1L << (OUT - 66)) | (1L << (VARIADIC - 66)))) != 0)) {
				{
				setState(2435); ((Function_argumentsContext)_localctx).arg_mode = argmode();
				}
			}

			setState(2439);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				{
				setState(2438); ((Function_argumentsContext)_localctx).argname = identifier();
				}
				break;
			}
			setState(2444);
			switch ( getInterpreter().adaptivePredict(_input,291,_ctx) ) {
			case 1:
				{
				setState(2441); ((Function_argumentsContext)_localctx).argtype_data = data_type();
				}
				break;
			case 2:
				{
				setState(2442); ((Function_argumentsContext)_localctx).argtype_expres = value_expression();
				}
				break;
			case 3:
				{
				setState(2443); ((Function_argumentsContext)_localctx).argtype_schema = schema_qualified_name();
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
			setState(2446);
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
			setState(2448);
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
		enterRule(_localctx, 74, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2450); match(FUNCTION);
			setState(2451); function_definition_name_paren();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_function_definition_name_paren);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2453); ((Function_definition_name_parenContext)_localctx).func_name = schema_qualified_name();
			setState(2454); match(LEFT_PAREN);
			setState(2463);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << IN))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INOUT - 66)) | (1L << (NOT - 66)) | (1L << (NULL - 66)) | (1L << (OUT - 66)) | (1L << (SETOF - 66)) | (1L << (SOME - 66)) | (1L << (TRIGGER - 66)) | (1L << (TRUE - 66)) | (1L << (VARIADIC - 66)))) != 0) || ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (REGCLASS - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (BINARY - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (LEFT_PAREN - 327)) | (1L << (PLUS - 327)) | (1L << (MINUS - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (NUMBER - 327)) | (1L << (REAL_NUMBER - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)) | (1L << (Character_String_Literal - 327)))) != 0)) {
				{
				setState(2455); function_arguments();
				setState(2460);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2456); match(COMMA);
					setState(2457); function_arguments();
					}
					}
					setState(2462);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(2465); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 78, RULE_functions_definition_schema);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2467); match(ALL);
			setState(2468); match(FUNCTIONS);
			setState(2469); match(IN);
			setState(2470); match(SCHEMA);
			setState(2471); ((Functions_definition_schemaContext)_localctx).identifier = identifier();
			((Functions_definition_schemaContext)_localctx).schema_name.add(((Functions_definition_schemaContext)_localctx).identifier);
			setState(2476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2472); match(COMMA);
				setState(2473); ((Functions_definition_schemaContext)_localctx).identifier = identifier();
				((Functions_definition_schemaContext)_localctx).schema_name.add(((Functions_definition_schemaContext)_localctx).identifier);
				}
				}
				setState(2478);
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
		enterRule(_localctx, 80, RULE_create_sequence_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2479); match(CREATE);
			setState(2481);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(2480);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2483); match(SEQUENCE);
			setState(2484); ((Create_sequence_statementContext)_localctx).name = schema_qualified_name();
			setState(2488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OWNED || _la==CACHE || ((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (CYCLE - 160)) | (1L << (INCREMENT - 160)) | (1L << (MAXVALUE - 160)) | (1L << (MINVALUE - 160)) | (1L << (NO - 160)))) != 0) || _la==START) {
				{
				{
				setState(2485); sequence_body();
				}
				}
				setState(2490);
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
		enterRule(_localctx, 82, RULE_sequence_body);
		int _la;
		try {
			setState(2525);
			switch ( getInterpreter().adaptivePredict(_input,303,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2491); match(INCREMENT);
				setState(2493);
				_la = _input.LA(1);
				if (_la==BY) {
					{
					setState(2492); match(BY);
					}
				}

				setState(2495); ((Sequence_bodyContext)_localctx).incr = match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2500);
				switch (_input.LA(1)) {
				case MINVALUE:
					{
					setState(2496); match(MINVALUE);
					setState(2497); ((Sequence_bodyContext)_localctx).minval = match(NUMBER);
					}
					break;
				case NO:
					{
					setState(2498); match(NO);
					setState(2499); match(MINVALUE);
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
				setState(2506);
				switch (_input.LA(1)) {
				case MAXVALUE:
					{
					setState(2502); match(MAXVALUE);
					setState(2503); ((Sequence_bodyContext)_localctx).maxval = numeric_type();
					}
					break;
				case NO:
					{
					setState(2504); match(NO);
					setState(2505); match(MAXVALUE);
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
				setState(2508); match(START);
				setState(2510);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(2509); match(WITH);
					}
				}

				setState(2512); ((Sequence_bodyContext)_localctx).start_val = match(NUMBER);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2513); match(CACHE);
				setState(2514); ((Sequence_bodyContext)_localctx).cache_val = match(NUMBER);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2516);
				_la = _input.LA(1);
				if (_la==NO) {
					{
					setState(2515); match(NO);
					}
				}

				setState(2518); match(CYCLE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2519); match(OWNED);
				setState(2520); match(BY);
				setState(2523);
				switch ( getInterpreter().adaptivePredict(_input,302,_ctx) ) {
				case 1:
					{
					setState(2521); ((Sequence_bodyContext)_localctx).col_name = schema_qualified_name();
					}
					break;
				case 2:
					{
					setState(2522); match(NONE);
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
		enterRule(_localctx, 84, RULE_create_schema_statement);
		int _la;
		try {
			setState(2567);
			switch ( getInterpreter().adaptivePredict(_input,308,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2527); match(CREATE);
				setState(2528); match(SCHEMA);
				setState(2529); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(2532);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(2530); match(AUTHORIZATION);
					setState(2531); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				setState(2537);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - -1)) & ~0x3f) == 0 && ((1L << (_la - -1)) & ((1L << (EOF - -1)) | (1L << (ALTER - -1)) | (1L << (CREATE - -1)) | (1L << (GRANT - -1)))) != 0) || _la==REVOKE || _la==COMMENT || _la==DROP || _la==SET) {
					{
					{
					setState(2534); ((Create_schema_statementContext)_localctx).schema_element = sql();
					}
					}
					setState(2539);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2540); match(CREATE);
				setState(2541); match(SCHEMA);
				setState(2542); match(AUTHORIZATION);
				setState(2543); ((Create_schema_statementContext)_localctx).user_name = identifier();
				setState(2547);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - -1)) & ~0x3f) == 0 && ((1L << (_la - -1)) & ((1L << (EOF - -1)) | (1L << (ALTER - -1)) | (1L << (CREATE - -1)) | (1L << (GRANT - -1)))) != 0) || _la==REVOKE || _la==COMMENT || _la==DROP || _la==SET) {
					{
					{
					setState(2544); ((Create_schema_statementContext)_localctx).schema_element = sql();
					}
					}
					setState(2549);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2550); match(CREATE);
				setState(2551); match(SCHEMA);
				setState(2552); match(IF);
				setState(2553); match(NOT);
				setState(2554); match(EXISTS);
				setState(2555); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(2558);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(2556); match(AUTHORIZATION);
					setState(2557); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2560); match(CREATE);
				setState(2561); match(SCHEMA);
				setState(2562); match(IF);
				setState(2563); match(NOT);
				setState(2564); match(EXISTS);
				setState(2565); match(AUTHORIZATION);
				setState(2566); ((Create_schema_statementContext)_localctx).user_name = identifier();
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
		enterRule(_localctx, 86, RULE_create_view_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2569); match(CREATE);
			setState(2572);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(2570); match(OR);
				setState(2571); match(REPLACE);
				}
			}

			setState(2575);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(2574);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(2577); match(VIEW);
			setState(2578); ((Create_view_statementContext)_localctx).name = schema_qualified_name();
			setState(2585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0)) {
				{
				{
				setState(2579); ((Create_view_statementContext)_localctx).identifier = identifier();
				((Create_view_statementContext)_localctx).column_name.add(((Create_view_statementContext)_localctx).identifier);
				setState(2581);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2580); match(COMMA);
					}
				}

				}
				}
				setState(2587);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2601);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2588); match(WITH);
				setState(2589); match(LEFT_PAREN);
				setState(2595); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2590); ((Create_view_statementContext)_localctx).view_option_name = identifier();
					setState(2593);
					_la = _input.LA(1);
					if (_la==EQUAL) {
						{
						setState(2591); match(EQUAL);
						setState(2592); ((Create_view_statementContext)_localctx).view_option_value = identifier();
						}
					}

					}
					}
					setState(2597); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0) );
				setState(2599); match(RIGHT_PAREN);
				}
			}

			setState(2603); match(AS);
			setState(2604); query_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 88, RULE_create_table_statement);
		int _la;
		try {
			int _alt;
			setState(2705);
			switch ( getInterpreter().adaptivePredict(_input,333,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2606); match(CREATE);
				setState(2612);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(2608);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(2607);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(2610);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(2611); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2614); match(TABLE);
				setState(2618);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(2615); match(IF);
					setState(2616); match(NOT);
					setState(2617); match(EXISTS);
					}
				}

				setState(2620); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(2621); match(LEFT_PAREN);
				setState(2630);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (LIKE - 74)) | (1L << (PRIMARY - 74)) | (1L << (UNIQUE - 74)) | (1L << (ADMIN - 74)) | (1L << (ALWAYS - 74)) | (1L << (ARRAY - 74)))) != 0) || ((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (AVG - 138)) | (1L << (BETWEEN - 138)) | (1L << (BY - 138)) | (1L << (CACHE - 138)) | (1L << (CALLED - 138)) | (1L << (CLASS - 138)) | (1L << (CENTURY - 138)) | (1L << (CHARACTER - 138)) | (1L << (CHECK - 138)) | (1L << (CLUSTER - 138)) | (1L << (COLLECT - 138)) | (1L << (COALESCE - 138)) | (1L << (COLUMN - 138)) | (1L << (COMMENT - 138)) | (1L << (COMMENTS - 138)) | (1L << (COMMIT - 138)) | (1L << (CONCURRENTLY - 138)) | (1L << (CONFIGURATION - 138)) | (1L << (COST - 138)) | (1L << (COUNT - 138)) | (1L << (CUBE - 138)) | (1L << (CURRENT - 138)) | (1L << (CYCLE - 138)) | (1L << (DATA - 138)) | (1L << (DAY - 138)) | (1L << (DEC - 138)) | (1L << (DECADE - 138)) | (1L << (DEFINER - 138)) | (1L << (DICTIONARY - 138)) | (1L << (DISABLE - 138)) | (1L << (DOW - 138)) | (1L << (DOY - 138)) | (1L << (DROP - 138)) | (1L << (ENABLE - 138)) | (1L << (EPOCH - 138)) | (1L << (EVENT - 138)) | (1L << (EVERY - 138)) | (1L << (EXISTS - 138)) | (1L << (EXTENDED - 138)) | (1L << (EXTERNAL - 138)) | (1L << (EXTRACT - 138)) | (1L << (FAMILY - 138)) | (1L << (FILTER - 138)) | (1L << (FIRST - 138)) | (1L << (FORMAT - 138)) | (1L << (FUSION - 138)) | (1L << (GROUPING - 138)) | (1L << (HASH - 138)) | (1L << (INHERIT - 138)) | (1L << (INDEX - 138)) | (1L << (INCREMENT - 138)) | (1L << (INPUT - 138)) | (1L << (INSERT - 138)) | (1L << (INTERSECTION - 138)) | (1L << (ISCACHABLE - 138)) | (1L << (ISODOW - 138)) | (1L << (ISOYEAR - 138)) | (1L << (ISSTRICT - 138)) | (1L << (LANGUAGE - 138)) | (1L << (LARGE - 138)) | (1L << (LAST - 138)) | (1L << (LESS - 138)))) != 0) || ((((_la - 202)) & ~0x3f) == 0 && ((1L << (_la - 202)) & ((1L << (LIST - 202)) | (1L << (LOCATION - 202)) | (1L << (MAIN - 202)) | (1L << (MATCH - 202)) | (1L << (MAX - 202)) | (1L << (MAXVALUE - 202)) | (1L << (MICROSECONDS - 202)) | (1L << (MILLENNIUM - 202)) | (1L << (MILLISECONDS - 202)) | (1L << (MIN - 202)) | (1L << (MINVALUE - 202)) | (1L << (MINUTE - 202)) | (1L << (MONTH - 202)) | (1L << (NATIONAL - 202)) | (1L << (NO - 202)) | (1L << (NONE - 202)) | (1L << (NULLIF - 202)) | (1L << (OBJECT - 202)) | (1L << (ON - 202)) | (1L << (ONLY - 202)) | (1L << (OPTION - 202)) | (1L << (OPTIONS - 202)) | (1L << (OVER - 202)) | (1L << (OVERWRITE - 202)) | (1L << (PARSER - 202)) | (1L << (PARTIAL - 202)) | (1L << (PARTITION - 202)) | (1L << (PARTITIONS - 202)) | (1L << (PLAIN - 202)) | (1L << (PRECISION - 202)) | (1L << (PUBLIC - 202)) | (1L << (PURGE - 202)) | (1L << (QUARTER - 202)) | (1L << (RANGE - 202)) | (1L << (REGCONFIG - 202)) | (1L << (REGEXP - 202)) | (1L << (RENAME - 202)) | (1L << (REPLICA - 202)) | (1L << (RESET - 202)) | (1L << (RESTART - 202)) | (1L << (RLIKE - 202)) | (1L << (ROLLUP - 202)) | (1L << (SEARCH - 202)) | (1L << (SECOND - 202)) | (1L << (SECURITY - 202)) | (1L << (SERVER - 202)) | (1L << (SET - 202)) | (1L << (SIMILAR - 202)) | (1L << (SIMPLE - 202)) | (1L << (STABLE - 202)) | (1L << (START - 202)) | (1L << (STATISTICS - 202)) | (1L << (STORAGE - 202)) | (1L << (STDDEV_POP - 202)) | (1L << (STDDEV_SAMP - 202)) | (1L << (SUBPARTITION - 202)) | (1L << (SUM - 202)) | (1L << (TABLESPACE - 202)) | (1L << (TEMPLATE - 202)) | (1L << (THAN - 202)) | (1L << (TIMEZONE - 202)))) != 0) || ((((_la - 266)) & ~0x3f) == 0 && ((1L << (_la - 266)) & ((1L << (TIMEZONE_HOUR - 266)) | (1L << (TIMEZONE_MINUTE - 266)) | (1L << (TRIM - 266)) | (1L << (TO - 266)) | (1L << (TYPE - 266)) | (1L << (TYPES - 266)) | (1L << (UNKNOWN - 266)) | (1L << (UNLOGGED - 266)) | (1L << (USER - 266)) | (1L << (VALID - 266)) | (1L << (VALIDATE - 266)) | (1L << (VALUES - 266)) | (1L << (VAR_SAMP - 266)) | (1L << (VAR_POP - 266)) | (1L << (VARYING - 266)) | (1L << (VERSION - 266)) | (1L << (VOLATILE - 266)) | (1L << (WEEK - 266)) | (1L << (WINDOW - 266)) | (1L << (WRAPPER - 266)) | (1L << (YEAR - 266)) | (1L << (ZONE - 266)) | (1L << (BOOLEAN - 266)) | (1L << (BOOL - 266)) | (1L << (BIT - 266)) | (1L << (VARBIT - 266)) | (1L << (INT1 - 266)) | (1L << (INT2 - 266)) | (1L << (INT4 - 266)) | (1L << (INT8 - 266)) | (1L << (TINYINT - 266)) | (1L << (SMALLINT - 266)) | (1L << (INT - 266)) | (1L << (INTEGER - 266)) | (1L << (BIGINT - 266)) | (1L << (FLOAT4 - 266)) | (1L << (FLOAT8 - 266)) | (1L << (REAL - 266)) | (1L << (FLOAT - 266)) | (1L << (DOUBLE - 266)) | (1L << (NUMERIC - 266)) | (1L << (DECIMAL - 266)) | (1L << (CHAR - 266)) | (1L << (VARCHAR - 266)) | (1L << (NCHAR - 266)) | (1L << (NVARCHAR - 266)) | (1L << (DATE - 266)) | (1L << (TIME - 266)) | (1L << (TIMETZ - 266)) | (1L << (TIMESTAMP - 266)) | (1L << (TIMESTAMPTZ - 266)) | (1L << (TEXT - 266)) | (1L << (UUID - 266)) | (1L << (VARBINARY - 266)) | (1L << (BLOB - 266)) | (1L << (BYTEA - 266)) | (1L << (INET4 - 266)) | (1L << (INET - 266)) | (1L << (INTERVAL - 266)) | (1L << (VOID - 266)))) != 0) || ((((_la - 355)) & ~0x3f) == 0 && ((1L << (_la - 355)) & ((1L << (DOUBLE_QUOTE - 355)) | (1L << (Identifier - 355)) | (1L << (QuotedIdentifier - 355)))) != 0)) {
					{
					setState(2622); table_body();
					setState(2627);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2623); match(COMMA);
						setState(2624); table_body();
						}
						}
						setState(2629);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(2632); match(RIGHT_PAREN);
				setState(2645);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(2633); match(INHERITS);
					setState(2634); match(LEFT_PAREN);
					setState(2639); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2635); ((Create_table_statementContext)_localctx).paret_table = schema_qualified_name();
						setState(2637);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2636); match(COMMA);
							}
						}

						}
						}
						setState(2641); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0) );
					setState(2643); match(RIGHT_PAREN);
					}
				}

				setState(2647); storage_parameter_oid();
				setState(2648); on_commit();
				setState(2649); table_space();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2651); match(CREATE);
				setState(2657);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(2653);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(2652);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(2655);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(2656); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2659); match(TABLE);
				setState(2663);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(2660); match(IF);
					setState(2661); match(NOT);
					setState(2662); match(EXISTS);
					}
				}

				setState(2665); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(2666); match(OF);
				setState(2667); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(2699);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2668); match(LEFT_PAREN);
					setState(2679);
					switch ( getInterpreter().adaptivePredict(_input,328,_ctx) ) {
					case 1:
						{
						{
						setState(2669); ((Create_table_statementContext)_localctx).column_name = identifier();
						setState(2670); match(WITH);
						setState(2671); match(OPTIONS);
						setState(2675);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,327,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(2672); ((Create_table_statementContext)_localctx).column_constraint = column_constraint();
								((Create_table_statementContext)_localctx).col_constraint.add(((Create_table_statementContext)_localctx).column_constraint);
								}
								} 
							}
							setState(2677);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,327,_ctx);
						}
						}
						}
						break;
					case 2:
						{
						setState(2678); table_constraint();
						}
						break;
					}
					setState(2694);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (PRIMARY - 90)) | (1L << (UNIQUE - 90)) | (1L << (CHECK - 90)))) != 0) || _la==COMMA) {
						{
						setState(2692);
						switch (_input.LA(1)) {
						case COMMA:
							{
							setState(2681); match(COMMA);
							{
							setState(2682); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(2683); match(WITH);
							setState(2684); match(OPTIONS);
							setState(2688);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,329,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(2685); ((Create_table_statementContext)_localctx).column_constraint = column_constraint();
									((Create_table_statementContext)_localctx).col_constraint.add(((Create_table_statementContext)_localctx).column_constraint);
									}
									} 
								}
								setState(2690);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,329,_ctx);
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
							setState(2691); table_constraint();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(2696);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2697); match(RIGHT_PAREN);
					}
				}

				setState(2701); storage_parameter_oid();
				setState(2702); on_commit();
				setState(2703); table_space();
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
		enterRule(_localctx, 90, RULE_table_body);
		int _la;
		try {
			setState(2717);
			switch ( getInterpreter().adaptivePredict(_input,335,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2707); table_column_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2708); ((Table_bodyContext)_localctx).tabl_constraint = table_constraint();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2709); match(LIKE);
				setState(2710); ((Table_bodyContext)_localctx).parent_table = identifier();
				setState(2714);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==EXCLUDING || _la==INCLUDING) {
					{
					{
					setState(2711); ((Table_bodyContext)_localctx).like_option = like_option();
					((Table_bodyContext)_localctx).like_opt.add(((Table_bodyContext)_localctx).like_option);
					}
					}
					setState(2716);
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
		enterRule(_localctx, 92, RULE_table_column_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2719); ((Table_column_definitionContext)_localctx).column_name = identifier();
			setState(2722);
			switch ( getInterpreter().adaptivePredict(_input,336,_ctx) ) {
			case 1:
				{
				setState(2720); ((Table_column_definitionContext)_localctx).datatype = data_type();
				}
				break;
			case 2:
				{
				setState(2721); ((Table_column_definitionContext)_localctx).datatype_iden = schema_qualified_name();
				}
				break;
			}
			setState(2726);
			_la = _input.LA(1);
			if (_la==COLLATE) {
				{
				setState(2724); match(COLLATE);
				setState(2725); ((Table_column_definitionContext)_localctx).collation = identifier();
				}
			}

			setState(2731);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (CONSTRAINT - 20)) | (1L << (DEFAULT - 20)) | (1L << (NOT - 20)) | (1L << (NULL - 20)))) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (PRIMARY - 90)) | (1L << (REFERENCES - 90)) | (1L << (UNIQUE - 90)) | (1L << (CHECK - 90)))) != 0)) {
				{
				{
				setState(2728); ((Table_column_definitionContext)_localctx).column_constraint = column_constraint();
				((Table_column_definitionContext)_localctx).colmn_constraint.add(((Table_column_definitionContext)_localctx).column_constraint);
				}
				}
				setState(2733);
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
		enterRule(_localctx, 94, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2734);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(2735);
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
		enterRule(_localctx, 96, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2739);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2737); match(CONSTRAINT);
				setState(2738); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2840);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(2741); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(2742); match(UNIQUE);
				setState(2743); match(LEFT_PAREN);
				setState(2744); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).column_name_unique.add(((Table_constraintContext)_localctx).identifier);
				setState(2749);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2745); match(COMMA);
					setState(2746); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).column_name_unique.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2751);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2752); match(RIGHT_PAREN);
				setState(2753); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2755); match(PRIMARY);
				setState(2756); match(KEY);
				setState(2757); match(LEFT_PAREN);
				setState(2758); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).column_name_pr_key.add(((Table_constraintContext)_localctx).identifier);
				setState(2763);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2759); match(COMMA);
					setState(2760); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).column_name_pr_key.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2765);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2766); match(RIGHT_PAREN);
				setState(2767); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(2769); match(EXCLUDE);
				setState(2772);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(2770); match(USING);
					setState(2771); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(2774); match(LEFT_PAREN);
				setState(2775); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(2776); match(WITH);
				setState(2777); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).operator.add(((Table_constraintContext)_localctx).identifier);
				setState(2782);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2778); match(COMMA);
					setState(2779); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).operator.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2784);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2785); match(RIGHT_PAREN);
				setState(2786); index_parameters();
				setState(2792);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(2787); match(WHERE);
					setState(2788); match(LEFT_PAREN);
					setState(2789); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(2790); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(2794); match(FOREIGN);
				setState(2795); match(KEY);
				setState(2796); match(LEFT_PAREN);
				setState(2797); ((Table_constraintContext)_localctx).identifier = identifier();
				((Table_constraintContext)_localctx).column_name_for_key.add(((Table_constraintContext)_localctx).identifier);
				setState(2802);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2798); match(COMMA);
					setState(2799); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).column_name_for_key.add(((Table_constraintContext)_localctx).identifier);
					}
					}
					setState(2804);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2805); match(RIGHT_PAREN);
				setState(2806); match(REFERENCES);
				setState(2807); ((Table_constraintContext)_localctx).reftable = schema_qualified_name();
				setState(2819);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2808); match(LEFT_PAREN);
					setState(2809); ((Table_constraintContext)_localctx).identifier = identifier();
					((Table_constraintContext)_localctx).refcolumn.add(((Table_constraintContext)_localctx).identifier);
					setState(2814);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(2810); match(COMMA);
						setState(2811); ((Table_constraintContext)_localctx).identifier = identifier();
						((Table_constraintContext)_localctx).refcolumn.add(((Table_constraintContext)_localctx).identifier);
						}
						}
						setState(2816);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2817); match(RIGHT_PAREN);
					}
				}

				setState(2837);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MATCH || _la==ON) {
					{
					setState(2835);
					switch ( getInterpreter().adaptivePredict(_input,349,_ctx) ) {
					case 1:
						{
						setState(2827);
						switch ( getInterpreter().adaptivePredict(_input,348,_ctx) ) {
						case 1:
							{
							{
							setState(2821); match(MATCH);
							setState(2822); match(FULL);
							}
							}
							break;
						case 2:
							{
							{
							setState(2823); match(MATCH);
							setState(2824); match(PARTIAL);
							}
							}
							break;
						case 3:
							{
							{
							setState(2825); match(MATCH);
							setState(2826); match(SIMPLE);
							}
							}
							break;
						}
						}
						break;
					case 2:
						{
						{
						setState(2829); match(ON);
						setState(2830); match(DELETE);
						setState(2831); ((Table_constraintContext)_localctx).action_on_delete = action();
						}
						}
						break;
					case 3:
						{
						{
						setState(2832); match(ON);
						setState(2833); match(UPDATE);
						setState(2834); ((Table_constraintContext)_localctx).action_on_update = action();
						}
						}
						break;
					}
					}
					setState(2839);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2845);
			switch ( getInterpreter().adaptivePredict(_input,352,_ctx) ) {
			case 1:
				{
				setState(2842); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2843); match(NOT);
				setState(2844); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2851);
			switch ( getInterpreter().adaptivePredict(_input,353,_ctx) ) {
			case 1:
				{
				{
				setState(2847); match(INITIALLY);
				setState(2848); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2849); match(INITIALLY);
				setState(2850); match(IMMEDIATE);
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
		enterRule(_localctx, 98, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2855);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2853); match(CONSTRAINT);
				setState(2854); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2892);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(2857); match(NOT);
				setState(2858); match(NULL);
				}
				break;
			case NULL:
				{
				setState(2859); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(2860); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				setState(2861); match(DEFAULT);
				setState(2864);
				switch ( getInterpreter().adaptivePredict(_input,355,_ctx) ) {
				case 1:
					{
					setState(2862); ((Column_constraintContext)_localctx).default_expr_data = data_type();
					}
					break;
				case 2:
					{
					setState(2863); ((Column_constraintContext)_localctx).default_expr = value_expression();
					}
					break;
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(2866); match(UNIQUE);
				setState(2867); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2868); match(PRIMARY);
				setState(2869); match(KEY);
				setState(2870); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(2871); match(REFERENCES);
				setState(2872); ((Column_constraintContext)_localctx).reftable = schema_qualified_name();
				{
				{
				setState(2873); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(2880);
				switch ( getInterpreter().adaptivePredict(_input,356,_ctx) ) {
				case 1:
					{
					setState(2874); match(MATCH);
					setState(2875); match(FULL);
					}
					break;
				case 2:
					{
					setState(2876); match(MATCH);
					setState(2877); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(2878); match(MATCH);
					setState(2879); match(SIMPLE);
					}
					break;
				}
				setState(2885);
				switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
				case 1:
					{
					setState(2882); match(ON);
					setState(2883); match(DELETE);
					setState(2884); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2890);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(2887); match(ON);
					setState(2888); match(UPDATE);
					setState(2889); ((Column_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2897);
			switch ( getInterpreter().adaptivePredict(_input,360,_ctx) ) {
			case 1:
				{
				setState(2894); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2895); match(NOT);
				setState(2896); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2903);
			switch ( getInterpreter().adaptivePredict(_input,361,_ctx) ) {
			case 1:
				{
				{
				setState(2899); match(INITIALLY);
				setState(2900); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2901); match(INITIALLY);
				setState(2902); match(IMMEDIATE);
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
		enterRule(_localctx, 100, RULE_check_boolean_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2905); match(CHECK);
			setState(2907); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2906); match(LEFT_PAREN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2909); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,362,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(2911); ((Check_boolean_expressionContext)_localctx).expression = value_expression();
			setState(2913); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2912); match(RIGHT_PAREN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2915); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,363,_ctx);
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
		enterRule(_localctx, 102, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2917); match(LEFT_PAREN);
			setState(2926); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2918); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(2921);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(2919); match(EQUAL);
					setState(2920); ((Storage_parameterContext)_localctx).value = value_expression();
					}
				}

				setState(2924);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2923); match(COMMA);
					}
				}

				}
				}
				setState(2928); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0) );
			setState(2930); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 104, RULE_with_storage_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2932); match(WITH);
			setState(2933); storage_parameter();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 106, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2940);
			switch ( getInterpreter().adaptivePredict(_input,367,_ctx) ) {
			case 1:
				{
				setState(2935); with_storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(2936); match(WITH);
				setState(2937); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(2938); match(WITHOUT);
				setState(2939); match(OIDS);
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
		enterRule(_localctx, 108, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2951);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(2942); match(ON);
				setState(2943); match(COMMIT);
				setState(2949);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(2944); match(PRESERVE);
					setState(2945); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(2946); match(DELETE);
					setState(2947); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(2948); match(DROP);
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
		enterRule(_localctx, 110, RULE_table_space);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2955);
			_la = _input.LA(1);
			if (_la==TABLESPACE) {
				{
				setState(2953); match(TABLESPACE);
				setState(2954); ((Table_spaceContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 112, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2963);
			switch ( getInterpreter().adaptivePredict(_input,371,_ctx) ) {
			case 1:
				{
				setState(2957); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(2958); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(2959); match(SET);
				setState(2960); match(NULL);
				}
				break;
			case 4:
				{
				setState(2961); match(SET);
				setState(2962); match(DEFAULT);
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
		enterRule(_localctx, 114, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2966);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2965); with_storage_parameter();
				}
			}

			setState(2972);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(2968); match(USING);
				setState(2969); match(INDEX);
				setState(2970); match(TABLESPACE);
				setState(2971); ((Index_parametersContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 116, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2974); match(LEFT_PAREN);
			setState(2975); field_element();
			setState(2980);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2976); match(COMMA);
				setState(2977); field_element();
				}
				}
				setState(2982);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2983); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 118, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2985); ((Field_elementContext)_localctx).name = identifier();
			setState(2986); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 120, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2988); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 122, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2990); match(WITH);
			setState(2991); match(LEFT_PAREN);
			setState(2992); param();
			setState(2997);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2993); match(COMMA);
				setState(2994); param();
				}
				}
				setState(2999);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3000); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 124, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3002); ((ParamContext)_localctx).key = identifier();
			setState(3003); match(EQUAL);
			setState(3004); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 126, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3006); match(USING);
			setState(3007); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 128, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3009); match(TABLESPACE);
			setState(3010); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3012); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 132, RULE_table_partitioning_clauses);
		try {
			setState(3018);
			switch ( getInterpreter().adaptivePredict(_input,376,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3014); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3015); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3016); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3017); column_partitions();
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
		enterRule(_localctx, 134, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3020); match(PARTITION);
			setState(3021); match(BY);
			setState(3022); match(RANGE);
			setState(3023); match(LEFT_PAREN);
			setState(3024); column_reference_list();
			setState(3025); match(RIGHT_PAREN);
			setState(3026); match(LEFT_PAREN);
			setState(3027); range_value_clause_list();
			setState(3028); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 136, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3030); range_value_clause();
			setState(3035);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3031); match(COMMA);
				setState(3032); range_value_clause();
				}
				}
				setState(3037);
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
		enterRule(_localctx, 138, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3038); match(PARTITION);
			setState(3039); partition_name();
			setState(3040); match(VALUES);
			setState(3041); match(LESS);
			setState(3042); match(THAN);
			setState(3054);
			switch ( getInterpreter().adaptivePredict(_input,380,_ctx) ) {
			case 1:
				{
				setState(3043); match(LEFT_PAREN);
				setState(3044); value_expression();
				setState(3045); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(3048);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3047); match(LEFT_PAREN);
					}
				}

				setState(3050); match(MAXVALUE);
				setState(3052);
				switch ( getInterpreter().adaptivePredict(_input,379,_ctx) ) {
				case 1:
					{
					setState(3051); match(RIGHT_PAREN);
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
		enterRule(_localctx, 140, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3056); match(PARTITION);
			setState(3057); match(BY);
			setState(3058); match(HASH);
			setState(3059); match(LEFT_PAREN);
			setState(3060); column_reference_list();
			setState(3061); match(RIGHT_PAREN);
			setState(3067);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(3062); match(LEFT_PAREN);
				setState(3063); individual_hash_partitions();
				setState(3064); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(3066); hash_partitions_by_quantity();
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
		enterRule(_localctx, 142, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3069); individual_hash_partition();
			setState(3074);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3070); match(COMMA);
				setState(3071); individual_hash_partition();
				}
				}
				setState(3076);
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
		enterRule(_localctx, 144, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3077); match(PARTITION);
			setState(3078); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 146, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3080); match(PARTITIONS);
			setState(3081); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 148, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3083); match(PARTITION);
			setState(3084); match(BY);
			setState(3085); match(LIST);
			setState(3086); match(LEFT_PAREN);
			setState(3087); column_reference_list();
			setState(3088); match(RIGHT_PAREN);
			setState(3089); match(LEFT_PAREN);
			setState(3090); list_value_clause_list();
			setState(3091); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 150, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3093); list_value_partition();
			setState(3098);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3094); match(COMMA);
				setState(3095); list_value_partition();
				}
				}
				setState(3100);
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
		enterRule(_localctx, 152, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3101); match(PARTITION);
			setState(3102); partition_name();
			setState(3103); match(VALUES);
			setState(3105);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(3104); match(IN);
				}
			}

			setState(3107); match(LEFT_PAREN);
			setState(3108); in_value_list();
			setState(3109); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 154, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3111); match(PARTITION);
			setState(3112); match(BY);
			setState(3113); match(COLUMN);
			setState(3114); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 156, RULE_partition_by_columns);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3116); match(PARTITION);
			setState(3117); match(BY);
			setState(3118); schema_qualified_name();
			setState(3123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3119); match(COMMA);
				setState(3120); schema_qualified_name();
				}
				}
				setState(3125);
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
		enterRule(_localctx, 158, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3126); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 160, RULE_drop_table_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3128); match(DROP);
			setState(3129); match(TABLE);
			setState(3130); schema_qualified_name();
			setState(3132);
			_la = _input.LA(1);
			if (_la==PURGE) {
				{
				setState(3131); match(PURGE);
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
		enterRule(_localctx, 162, RULE_identifier);
		int _la;
		try {
			setState(3143);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(3134); match(Identifier);
				}
				break;
			case QuotedIdentifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(3135); match(QuotedIdentifier);
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
				setState(3137);
				_la = _input.LA(1);
				if (_la==DOUBLE_QUOTE) {
					{
					setState(3136); match(DOUBLE_QUOTE);
					}
				}

				setState(3139); nonreserved_keywords();
				setState(3141);
				switch ( getInterpreter().adaptivePredict(_input,388,_ctx) ) {
				case 1:
					{
					setState(3140); match(DOUBLE_QUOTE);
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
		enterRule(_localctx, 164, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3145);
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
		enterRule(_localctx, 166, RULE_unsigned_literal);
		try {
			setState(3149);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3147); unsigned_numeric_literal();
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
				setState(3148); general_literal();
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
		enterRule(_localctx, 168, RULE_general_literal);
		try {
			setState(3154);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(3151); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(3152); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(3153); truth_value();
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
		enterRule(_localctx, 170, RULE_datetime_literal);
		try {
			setState(3159);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(3156); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3157); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(3158); date_literal();
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
		enterRule(_localctx, 172, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3161); match(TIME);
			setState(3162); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 174, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3164); match(TIMESTAMP);
			setState(3165); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 176, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3167); match(DATE);
			setState(3168); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
			setState(3177);
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
				setState(3170); predefined_type();
				setState(3173);
				switch ( getInterpreter().adaptivePredict(_input,393,_ctx) ) {
				case 1:
					{
					setState(3171); match(LEFT_BRACKET);
					setState(3172); match(RIGHT_BRACKET);
					}
					break;
				}
				}
				break;
			case SETOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(3175); match(SETOF);
				setState(3176); ((Data_typeContext)_localctx).value = identifier();
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
			setState(3194);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
			case INTERVAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3179); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(3180); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(3181); binary_large_object_string_type();
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
				setState(3182); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(3183); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(3184); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(3185); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(3186); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(3187); network_type();
				}
				break;
			case REGCLASS:
				enterOuterAlt(_localctx, 10);
				{
				setState(3188); regclass();
				}
				break;
			case REGCONFIG:
				enterOuterAlt(_localctx, 11);
				{
				setState(3189); match(REGCONFIG);
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 12);
				{
				setState(3190); match(TRIGGER);
				}
				break;
			case UUID:
				enterOuterAlt(_localctx, 13);
				{
				setState(3191); match(UUID);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 14);
				{
				setState(3192); match(VOID);
				}
				break;
			case INET:
				enterOuterAlt(_localctx, 15);
				{
				setState(3193); match(INET);
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
			setState(3196); match(REGCLASS);
			}
		}
		catch (RecognitionException re) {
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
			setState(3198); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
			setState(3224);
			switch ( getInterpreter().adaptivePredict(_input,401,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3200); match(CHARACTER);
				setState(3202);
				switch ( getInterpreter().adaptivePredict(_input,396,_ctx) ) {
				case 1:
					{
					setState(3201); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3204); match(CHAR);
				setState(3206);
				switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
				case 1:
					{
					setState(3205); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3208); match(CHARACTER);
				setState(3209); match(VARYING);
				setState(3211);
				switch ( getInterpreter().adaptivePredict(_input,398,_ctx) ) {
				case 1:
					{
					setState(3210); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3213); match(CHAR);
				setState(3214); match(VARYING);
				setState(3216);
				switch ( getInterpreter().adaptivePredict(_input,399,_ctx) ) {
				case 1:
					{
					setState(3215); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3218); match(VARCHAR);
				setState(3220);
				switch ( getInterpreter().adaptivePredict(_input,400,_ctx) ) {
				case 1:
					{
					setState(3219); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3222); match(TEXT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3223); match(INTERVAL);
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
			setState(3226); match(LEFT_PAREN);
			setState(3227); match(NUMBER);
			setState(3228); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(3265);
			switch ( getInterpreter().adaptivePredict(_input,409,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3230); match(NATIONAL);
				setState(3231); match(CHARACTER);
				setState(3233);
				switch ( getInterpreter().adaptivePredict(_input,402,_ctx) ) {
				case 1:
					{
					setState(3232); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3235); match(NATIONAL);
				setState(3236); match(CHAR);
				setState(3238);
				switch ( getInterpreter().adaptivePredict(_input,403,_ctx) ) {
				case 1:
					{
					setState(3237); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3240); match(NCHAR);
				setState(3242);
				switch ( getInterpreter().adaptivePredict(_input,404,_ctx) ) {
				case 1:
					{
					setState(3241); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3244); match(NATIONAL);
				setState(3245); match(CHARACTER);
				setState(3246); match(VARYING);
				setState(3248);
				switch ( getInterpreter().adaptivePredict(_input,405,_ctx) ) {
				case 1:
					{
					setState(3247); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3250); match(NATIONAL);
				setState(3251); match(CHAR);
				setState(3252); match(VARYING);
				setState(3254);
				switch ( getInterpreter().adaptivePredict(_input,406,_ctx) ) {
				case 1:
					{
					setState(3253); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3256); match(NCHAR);
				setState(3257); match(VARYING);
				setState(3259);
				switch ( getInterpreter().adaptivePredict(_input,407,_ctx) ) {
				case 1:
					{
					setState(3258); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3261); match(NVARCHAR);
				setState(3263);
				switch ( getInterpreter().adaptivePredict(_input,408,_ctx) ) {
				case 1:
					{
					setState(3262); type_length();
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
			setState(3275);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(3267); match(BLOB);
				setState(3269);
				switch ( getInterpreter().adaptivePredict(_input,410,_ctx) ) {
				case 1:
					{
					setState(3268); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(3271); match(BYTEA);
				setState(3273);
				switch ( getInterpreter().adaptivePredict(_input,411,_ctx) ) {
				case 1:
					{
					setState(3272); type_length();
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
			setState(3279);
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
				setState(3277); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3278); approximate_numeric_type();
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
			setState(3302);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(3281); match(NUMERIC);
				setState(3283);
				switch ( getInterpreter().adaptivePredict(_input,414,_ctx) ) {
				case 1:
					{
					setState(3282); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(3285); match(DECIMAL);
				setState(3287);
				switch ( getInterpreter().adaptivePredict(_input,415,_ctx) ) {
				case 1:
					{
					setState(3286); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(3289); match(DEC);
				setState(3291);
				switch ( getInterpreter().adaptivePredict(_input,416,_ctx) ) {
				case 1:
					{
					setState(3290); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(3293); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(3294); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(3295); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(3296); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(3297); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(3298); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(3299); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(3300); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(3301); match(BIGINT);
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
			setState(3314);
			switch ( getInterpreter().adaptivePredict(_input,419,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3304); match(FLOAT);
				setState(3306);
				switch ( getInterpreter().adaptivePredict(_input,418,_ctx) ) {
				case 1:
					{
					setState(3305); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3308); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3309); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3310); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3311); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3312); match(DOUBLE);
				setState(3313); match(PRECISION);
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
			setState(3324);
			switch ( getInterpreter().adaptivePredict(_input,420,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3316); match(LEFT_PAREN);
				setState(3317); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(3318); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3319); match(LEFT_PAREN);
				setState(3320); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(3321); match(COMMA);
				setState(3322); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(3323); match(RIGHT_PAREN);
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
			setState(3326);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3343);
			switch (_input.LA(1)) {
			case DATE:
				{
				setState(3328); match(DATE);
				}
				break;
			case TIME:
				{
				setState(3329); match(TIME);
				setState(3333);
				switch ( getInterpreter().adaptivePredict(_input,421,_ctx) ) {
				case 1:
					{
					setState(3330); match(WITH);
					setState(3331); match(TIME);
					setState(3332); match(ZONE);
					}
					break;
				}
				}
				break;
			case TIMETZ:
				{
				setState(3335); match(TIMETZ);
				}
				break;
			case TIMESTAMP:
				{
				setState(3336); match(TIMESTAMP);
				setState(3340);
				switch ( getInterpreter().adaptivePredict(_input,422,_ctx) ) {
				case 1:
					{
					setState(3337);
					_la = _input.LA(1);
					if ( !(_la==WITH || _la==WITHOUT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(3338); match(TIME);
					setState(3339); match(ZONE);
					}
					break;
				}
				}
				break;
			case TIMESTAMPTZ:
				{
				setState(3342); match(TIMESTAMPTZ);
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
		enterRule(_localctx, 206, RULE_bit_type);
		try {
			setState(3358);
			switch ( getInterpreter().adaptivePredict(_input,427,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3345); match(BIT);
				setState(3347);
				switch ( getInterpreter().adaptivePredict(_input,424,_ctx) ) {
				case 1:
					{
					setState(3346); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3349); match(VARBIT);
				setState(3351);
				switch ( getInterpreter().adaptivePredict(_input,425,_ctx) ) {
				case 1:
					{
					setState(3350); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3353); match(BIT);
				setState(3354); match(VARYING);
				setState(3356);
				switch ( getInterpreter().adaptivePredict(_input,426,_ctx) ) {
				case 1:
					{
					setState(3355); type_length();
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
			setState(3373);
			switch ( getInterpreter().adaptivePredict(_input,431,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3360); match(BINARY);
				setState(3362);
				switch ( getInterpreter().adaptivePredict(_input,428,_ctx) ) {
				case 1:
					{
					setState(3361); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3364); match(BINARY);
				setState(3365); match(VARYING);
				setState(3367);
				switch ( getInterpreter().adaptivePredict(_input,429,_ctx) ) {
				case 1:
					{
					setState(3366); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3369); match(VARBINARY);
				setState(3371);
				switch ( getInterpreter().adaptivePredict(_input,430,_ctx) ) {
				case 1:
					{
					setState(3370); type_length();
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
			setState(3377);
			switch ( getInterpreter().adaptivePredict(_input,432,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3375); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3376); nonparenthesized_value_expression_primary();
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
		enterRule(_localctx, 212, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3379); match(LEFT_PAREN);
			setState(3380); value_expression();
			setState(3381); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		public Function_definition_name_parenContext function_definition_name_paren() {
			return getRuleContext(Function_definition_name_parenContext.class,0);
		}
		public Set_function_specificationContext set_function_specification() {
			return getRuleContext(Set_function_specificationContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Column_referenceContext column_reference() {
			return getRuleContext(Column_referenceContext.class,0);
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
			setState(3391);
			switch ( getInterpreter().adaptivePredict(_input,433,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3383); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3384); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3385); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3386); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3387); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3388); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3389); function_definition_name_paren();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(3390); match(NULL);
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
			setState(3393); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
			setState(3395);
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
			setState(3398);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(3397); sign();
				}
			}

			setState(3400); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
			setState(3402); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
			setState(3412);
			switch ( getInterpreter().adaptivePredict(_input,436,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3404); match(COUNT);
				setState(3405); match(LEFT_PAREN);
				setState(3406); match(MULTIPLY);
				setState(3407); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3408); general_set_function();
				setState(3410);
				switch ( getInterpreter().adaptivePredict(_input,435,_ctx) ) {
				case 1:
					{
					setState(3409); filter_clause();
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
			setState(3414); set_function_type();
			setState(3415); match(LEFT_PAREN);
			setState(3417);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(3416); set_qualifier();
				}
			}

			setState(3419); value_expression();
			setState(3420); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(3422);
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
		enterRule(_localctx, 230, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3424); match(FILTER);
			setState(3425); match(LEFT_PAREN);
			setState(3426); where_clause();
			setState(3427); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(3429); match(GROUPING);
			setState(3430); match(LEFT_PAREN);
			setState(3431); column_reference_list();
			setState(3432); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(3434); case_specification();
			}
		}
		catch (RecognitionException re) {
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
			setState(3454);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(3436); match(NULLIF);
				setState(3437); match(LEFT_PAREN);
				setState(3438); numeric_value_expression();
				setState(3439); match(COMMA);
				setState(3440); boolean_value_expression();
				setState(3441); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3443); match(COALESCE);
				setState(3444); match(LEFT_PAREN);
				setState(3445); numeric_value_expression();
				setState(3448); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(3446); match(COMMA);
					setState(3447); boolean_value_expression();
					}
					}
					setState(3450); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(3452); match(RIGHT_PAREN);
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
			setState(3458);
			switch ( getInterpreter().adaptivePredict(_input,440,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3456); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3457); searched_case();
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
			setState(3460); match(CASE);
			setState(3461); boolean_value_expression();
			setState(3463); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3462); simple_when_clause();
				}
				}
				setState(3465); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(3468);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(3467); else_clause();
				}
			}

			setState(3470); match(END);
			}
		}
		catch (RecognitionException re) {
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
			setState(3472); match(CASE);
			setState(3474); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3473); searched_when_clause();
				}
				}
				setState(3476); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(3479);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(3478); else_clause();
				}
			}

			setState(3481); match(END);
			}
		}
		catch (RecognitionException re) {
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
			setState(3483); match(WHEN);
			setState(3484); search_condition();
			setState(3485); match(THEN);
			setState(3486); result();
			}
		}
		catch (RecognitionException re) {
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
			setState(3488); match(WHEN);
			setState(3489); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(3490); match(THEN);
			setState(3491); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
			setState(3493); match(ELSE);
			setState(3494); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
			setState(3498);
			switch ( getInterpreter().adaptivePredict(_input,445,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3496); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3497); match(NULL);
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
			setState(3500); match(CAST);
			setState(3501); match(LEFT_PAREN);
			setState(3502); cast_operand();
			setState(3503); match(AS);
			setState(3504); cast_target();
			setState(3505); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(3507); value_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(3509); data_type();
			}
		}
		catch (RecognitionException re) {
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
			setState(3515);
			switch ( getInterpreter().adaptivePredict(_input,446,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3511); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3512); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3513); boolean_value_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3514); array_expression();
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
			setState(3517); match(ARRAY);
			setState(3518); match(LEFT_BRACKET);
			setState(3519); value_expression();
			setState(3524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3520); match(COMMA);
				setState(3521); value_expression();
				}
				}
				setState(3526);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3527); match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
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
			setState(3532);
			switch ( getInterpreter().adaptivePredict(_input,448,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3529); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3530); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3531); match(NULL);
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
			setState(3534); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(3539);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,449,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3535);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(3536); ((Numeric_value_expressionContext)_localctx).right = term();
					}
					} 
				}
				setState(3541);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,449,_ctx);
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
			setState(3542); ((TermContext)_localctx).left = factor();
			setState(3547);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,450,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3543);
					_la = _input.LA(1);
					if ( !(((((_la - 348)) & ~0x3f) == 0 && ((1L << (_la - 348)) & ((1L << (MULTIPLY - 348)) | (1L << (DIVIDE - 348)) | (1L << (MODULAR - 348)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(3544); ((TermContext)_localctx).right = factor();
					}
					} 
				}
				setState(3549);
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
			setState(3551);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(3550); sign();
				}
			}

			setState(3553); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
			setState(3555); match(LEFT_PAREN);
			setState(3556); numeric_value_expression();
			setState(3561);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3557); match(COMMA);
				setState(3558); numeric_value_expression();
				}
				}
				setState(3563);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3564); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 272, RULE_numeric_primary);
		try {
			setState(3568);
			switch ( getInterpreter().adaptivePredict(_input,453,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3566); value_expression_primary_cast();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3567); numeric_value_function();
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
		enterRule(_localctx, 274, RULE_value_expression_primary_cast);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3570); value_expression_primary();
			setState(3575);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,454,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3571); match(CAST_EXPRESSION);
					setState(3572); cast_target();
					}
					} 
				}
				setState(3577);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,454,_ctx);
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
		enterRule(_localctx, 276, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3578);
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
		enterRule(_localctx, 278, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3580); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 280, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3582); match(EXTRACT);
			setState(3583); match(LEFT_PAREN);
			setState(3584); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(3585); match(FROM);
			setState(3586); extract_source();
			setState(3587); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 282, RULE_extract_field);
		try {
			setState(3592);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3589); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3590); time_zone_field();
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
				setState(3591); extended_datetime_field();
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
		enterRule(_localctx, 284, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3594);
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
		enterRule(_localctx, 286, RULE_extract_source);
		try {
			setState(3598);
			switch ( getInterpreter().adaptivePredict(_input,456,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3596); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3597); datetime_literal();
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
		enterRule(_localctx, 288, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3600); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 290, RULE_character_value_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3602); character_factor();
			setState(3607);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,457,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3603); match(CONCATENATION_OPERATOR);
					setState(3604); character_factor();
					}
					} 
				}
				setState(3609);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,457,_ctx);
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
		enterRule(_localctx, 292, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3610); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 294, RULE_character_primary);
		try {
			setState(3614);
			switch ( getInterpreter().adaptivePredict(_input,458,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3612); value_expression_primary_cast();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3613); string_value_function();
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
		enterRule(_localctx, 296, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3616); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 298, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3618); match(TRIM);
			setState(3619); match(LEFT_PAREN);
			setState(3620); trim_operands();
			setState(3621); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 300, RULE_trim_operands);
		int _la;
		try {
			setState(3637);
			switch ( getInterpreter().adaptivePredict(_input,462,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3630);
				switch ( getInterpreter().adaptivePredict(_input,461,_ctx) ) {
				case 1:
					{
					setState(3624);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(3623); trim_specification();
						}
					}

					setState(3627);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (NULL - 79)) | (1L << (SOME - 79)) | (1L << (TRUE - 79)) | (1L << (ADMIN - 79)) | (1L << (ALWAYS - 79)) | (1L << (ARRAY - 79)) | (1L << (AVG - 79)) | (1L << (BETWEEN - 79)) | (1L << (BY - 79)) | (1L << (CACHE - 79)) | (1L << (CALLED - 79)))) != 0) || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & ((1L << (CLASS - 143)) | (1L << (CENTURY - 143)) | (1L << (CHARACTER - 143)) | (1L << (CHECK - 143)) | (1L << (CLUSTER - 143)) | (1L << (COLLECT - 143)) | (1L << (COALESCE - 143)) | (1L << (COLUMN - 143)) | (1L << (COMMENT - 143)) | (1L << (COMMENTS - 143)) | (1L << (COMMIT - 143)) | (1L << (CONCURRENTLY - 143)) | (1L << (CONFIGURATION - 143)) | (1L << (COST - 143)) | (1L << (COUNT - 143)) | (1L << (CUBE - 143)) | (1L << (CURRENT - 143)) | (1L << (CYCLE - 143)) | (1L << (DATA - 143)) | (1L << (DAY - 143)) | (1L << (DEC - 143)) | (1L << (DECADE - 143)) | (1L << (DEFINER - 143)) | (1L << (DICTIONARY - 143)) | (1L << (DISABLE - 143)) | (1L << (DOW - 143)) | (1L << (DOY - 143)) | (1L << (DROP - 143)) | (1L << (ENABLE - 143)) | (1L << (EPOCH - 143)) | (1L << (EVENT - 143)) | (1L << (EVERY - 143)) | (1L << (EXISTS - 143)) | (1L << (EXTENDED - 143)) | (1L << (EXTERNAL - 143)) | (1L << (EXTRACT - 143)) | (1L << (FAMILY - 143)) | (1L << (FILTER - 143)) | (1L << (FIRST - 143)) | (1L << (FORMAT - 143)) | (1L << (FUSION - 143)) | (1L << (GROUPING - 143)) | (1L << (HASH - 143)) | (1L << (INHERIT - 143)) | (1L << (INDEX - 143)) | (1L << (INCREMENT - 143)) | (1L << (INPUT - 143)) | (1L << (INSERT - 143)) | (1L << (INTERSECTION - 143)) | (1L << (ISCACHABLE - 143)) | (1L << (ISODOW - 143)) | (1L << (ISOYEAR - 143)) | (1L << (ISSTRICT - 143)) | (1L << (LANGUAGE - 143)) | (1L << (LARGE - 143)) | (1L << (LAST - 143)) | (1L << (LESS - 143)) | (1L << (LIST - 143)) | (1L << (LOCATION - 143)) | (1L << (MAIN - 143)) | (1L << (MATCH - 143)) | (1L << (MAX - 143)))) != 0) || ((((_la - 207)) & ~0x3f) == 0 && ((1L << (_la - 207)) & ((1L << (MAXVALUE - 207)) | (1L << (MICROSECONDS - 207)) | (1L << (MILLENNIUM - 207)) | (1L << (MILLISECONDS - 207)) | (1L << (MIN - 207)) | (1L << (MINVALUE - 207)) | (1L << (MINUTE - 207)) | (1L << (MONTH - 207)) | (1L << (NATIONAL - 207)) | (1L << (NO - 207)) | (1L << (NONE - 207)) | (1L << (NULLIF - 207)) | (1L << (OBJECT - 207)) | (1L << (ON - 207)) | (1L << (ONLY - 207)) | (1L << (OPTION - 207)) | (1L << (OPTIONS - 207)) | (1L << (OVER - 207)) | (1L << (OVERWRITE - 207)) | (1L << (PARSER - 207)) | (1L << (PARTIAL - 207)) | (1L << (PARTITION - 207)) | (1L << (PARTITIONS - 207)) | (1L << (PLAIN - 207)) | (1L << (PRECISION - 207)) | (1L << (PUBLIC - 207)) | (1L << (PURGE - 207)) | (1L << (QUARTER - 207)) | (1L << (RANGE - 207)) | (1L << (REGCONFIG - 207)) | (1L << (REGEXP - 207)) | (1L << (RENAME - 207)) | (1L << (REPLICA - 207)) | (1L << (RESET - 207)) | (1L << (RESTART - 207)) | (1L << (RLIKE - 207)) | (1L << (ROLLUP - 207)) | (1L << (SEARCH - 207)) | (1L << (SECOND - 207)) | (1L << (SECURITY - 207)) | (1L << (SERVER - 207)) | (1L << (SET - 207)) | (1L << (SIMILAR - 207)) | (1L << (SIMPLE - 207)) | (1L << (STABLE - 207)) | (1L << (START - 207)) | (1L << (STATISTICS - 207)) | (1L << (STORAGE - 207)) | (1L << (STDDEV_POP - 207)) | (1L << (STDDEV_SAMP - 207)) | (1L << (SUBPARTITION - 207)) | (1L << (SUM - 207)) | (1L << (TABLESPACE - 207)) | (1L << (TEMPLATE - 207)) | (1L << (THAN - 207)) | (1L << (TIMEZONE - 207)) | (1L << (TIMEZONE_HOUR - 207)) | (1L << (TIMEZONE_MINUTE - 207)) | (1L << (TRIM - 207)) | (1L << (TO - 207)) | (1L << (TYPE - 207)))) != 0) || ((((_la - 271)) & ~0x3f) == 0 && ((1L << (_la - 271)) & ((1L << (TYPES - 271)) | (1L << (UNKNOWN - 271)) | (1L << (UNLOGGED - 271)) | (1L << (USER - 271)) | (1L << (VALID - 271)) | (1L << (VALIDATE - 271)) | (1L << (VALUES - 271)) | (1L << (VAR_SAMP - 271)) | (1L << (VAR_POP - 271)) | (1L << (VARYING - 271)) | (1L << (VERSION - 271)) | (1L << (VOLATILE - 271)) | (1L << (WEEK - 271)) | (1L << (WINDOW - 271)) | (1L << (WRAPPER - 271)) | (1L << (YEAR - 271)) | (1L << (ZONE - 271)) | (1L << (BOOLEAN - 271)) | (1L << (BOOL - 271)) | (1L << (BIT - 271)) | (1L << (VARBIT - 271)) | (1L << (INT1 - 271)) | (1L << (INT2 - 271)) | (1L << (INT4 - 271)) | (1L << (INT8 - 271)) | (1L << (TINYINT - 271)) | (1L << (SMALLINT - 271)) | (1L << (INT - 271)) | (1L << (INTEGER - 271)) | (1L << (BIGINT - 271)) | (1L << (FLOAT4 - 271)) | (1L << (FLOAT8 - 271)) | (1L << (REAL - 271)) | (1L << (FLOAT - 271)) | (1L << (DOUBLE - 271)) | (1L << (NUMERIC - 271)) | (1L << (DECIMAL - 271)) | (1L << (CHAR - 271)) | (1L << (VARCHAR - 271)) | (1L << (NCHAR - 271)) | (1L << (NVARCHAR - 271)) | (1L << (DATE - 271)) | (1L << (TIME - 271)) | (1L << (TIMETZ - 271)) | (1L << (TIMESTAMP - 271)) | (1L << (TIMESTAMPTZ - 271)) | (1L << (TEXT - 271)) | (1L << (UUID - 271)) | (1L << (VARBINARY - 271)) | (1L << (BLOB - 271)) | (1L << (BYTEA - 271)) | (1L << (INET4 - 271)) | (1L << (INET - 271)) | (1L << (INTERVAL - 271)) | (1L << (VOID - 271)))) != 0) || ((((_la - 344)) & ~0x3f) == 0 && ((1L << (_la - 344)) & ((1L << (LEFT_PAREN - 344)) | (1L << (DOUBLE_QUOTE - 344)) | (1L << (NUMBER - 344)) | (1L << (REAL_NUMBER - 344)) | (1L << (Identifier - 344)) | (1L << (QuotedIdentifier - 344)) | (1L << (Character_String_Literal - 344)))) != 0)) {
						{
						setState(3626); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(3629); match(FROM);
					}
					break;
				}
				setState(3632); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3633); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(3634); match(COMMA);
				setState(3635); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
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
		enterRule(_localctx, 302, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3639);
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
		enterRule(_localctx, 304, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3641); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 306, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3643); and_predicate();
			setState(3648);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,463,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3644); match(OR);
					setState(3645); or_predicate();
					}
					} 
				}
				setState(3650);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,463,_ctx);
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
		enterRule(_localctx, 308, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3651); boolean_factor();
			setState(3656);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,464,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3652); match(AND);
					setState(3653); and_predicate();
					}
					} 
				}
				setState(3658);
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
		enterRule(_localctx, 310, RULE_boolean_factor);
		try {
			setState(3662);
			switch ( getInterpreter().adaptivePredict(_input,465,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3659); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3660); match(NOT);
				setState(3661); boolean_test();
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
		enterRule(_localctx, 312, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3664); boolean_primary();
			setState(3666);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(3665); is_clause();
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
		enterRule(_localctx, 314, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3668); match(IS);
			setState(3670);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3669); match(NOT);
				}
			}

			setState(3672); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 316, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3674);
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
		enterRule(_localctx, 318, RULE_boolean_primary);
		try {
			setState(3678);
			switch ( getInterpreter().adaptivePredict(_input,468,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3676); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3677); boolean_predicand();
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
		enterRule(_localctx, 320, RULE_boolean_predicand);
		try {
			setState(3682);
			switch ( getInterpreter().adaptivePredict(_input,469,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3680); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3681); nonparenthesized_value_expression_primary();
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
		enterRule(_localctx, 322, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3684); match(LEFT_PAREN);
			setState(3685); boolean_value_expression();
			setState(3686); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 324, RULE_row_value_expression);
		try {
			setState(3690);
			switch ( getInterpreter().adaptivePredict(_input,470,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3688); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3689); explicit_row_value_constructor();
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
		enterRule(_localctx, 326, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3692); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 328, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3694); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 330, RULE_row_value_predicand);
		try {
			setState(3698);
			switch ( getInterpreter().adaptivePredict(_input,471,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3696); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3697); row_value_constructor_predicand();
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
		enterRule(_localctx, 332, RULE_row_value_constructor_predicand);
		try {
			setState(3702);
			switch ( getInterpreter().adaptivePredict(_input,472,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3700); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3701); boolean_predicand();
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
		enterRule(_localctx, 334, RULE_table_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3704); from_clause();
			setState(3706);
			switch ( getInterpreter().adaptivePredict(_input,473,_ctx) ) {
			case 1:
				{
				setState(3705); where_clause();
				}
				break;
			}
			setState(3709);
			switch ( getInterpreter().adaptivePredict(_input,474,_ctx) ) {
			case 1:
				{
				setState(3708); groupby_clause();
				}
				break;
			}
			setState(3712);
			switch ( getInterpreter().adaptivePredict(_input,475,_ctx) ) {
			case 1:
				{
				setState(3711); having_clause();
				}
				break;
			}
			setState(3715);
			switch ( getInterpreter().adaptivePredict(_input,476,_ctx) ) {
			case 1:
				{
				setState(3714); orderby_clause();
				}
				break;
			}
			setState(3718);
			switch ( getInterpreter().adaptivePredict(_input,477,_ctx) ) {
			case 1:
				{
				setState(3717); limit_clause();
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
		enterRule(_localctx, 336, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3720); match(FROM);
			setState(3722);
			switch ( getInterpreter().adaptivePredict(_input,478,_ctx) ) {
			case 1:
				{
				setState(3721); match(LEFT_PAREN);
				}
				break;
			}
			setState(3726);
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
				setState(3724); table_reference_list();
				}
				break;
			case SELECT:
				{
				setState(3725); query_specification();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(3729);
			switch ( getInterpreter().adaptivePredict(_input,480,_ctx) ) {
			case 1:
				{
				setState(3728); match(RIGHT_PAREN);
				}
				break;
			}
			setState(3732);
			switch ( getInterpreter().adaptivePredict(_input,481,_ctx) ) {
			case 1:
				{
				setState(3731); as_clause();
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
		enterRule(_localctx, 338, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3734); table_reference();
			setState(3739);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3735); match(COMMA);
				setState(3736); table_reference();
				}
				}
				setState(3741);
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
		enterRule(_localctx, 340, RULE_table_reference);
		try {
			setState(3744);
			switch ( getInterpreter().adaptivePredict(_input,483,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3742); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3743); table_primary();
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
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
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
		enterRule(_localctx, 342, RULE_joined_table);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3747);
			switch ( getInterpreter().adaptivePredict(_input,484,_ctx) ) {
			case 1:
				{
				setState(3746); match(LEFT_PAREN);
				}
				break;
			}
			setState(3749); table_primary();
			setState(3751);
			_la = _input.LA(1);
			if (_la==RIGHT_PAREN) {
				{
				setState(3750); match(RIGHT_PAREN);
				}
			}

			setState(3754); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(3753); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(3756); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,486,_ctx);
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
		enterRule(_localctx, 344, RULE_joined_table_primary);
		int _la;
		try {
			setState(3777);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(3758); match(CROSS);
				setState(3759); match(JOIN);
				setState(3760); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3762);
				_la = _input.LA(1);
				if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
					{
					setState(3761); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3764); match(JOIN);
				setState(3765); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(3766); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(3768); match(NATURAL);
				setState(3770);
				_la = _input.LA(1);
				if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
					{
					setState(3769); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3772); match(JOIN);
				setState(3773); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(3774); match(UNION);
				setState(3775); match(JOIN);
				setState(3776); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 346, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3779); match(CROSS);
			setState(3780); match(JOIN);
			setState(3781); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 348, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3784);
			_la = _input.LA(1);
			if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
				{
				setState(3783); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(3786); match(JOIN);
			setState(3787); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(3788); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 350, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3790); match(NATURAL);
			setState(3792);
			_la = _input.LA(1);
			if (((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (FULL - 45)) | (1L << (INNER - 45)) | (1L << (LEFT - 45)) | (1L << (RIGHT - 45)))) != 0)) {
				{
				setState(3791); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(3794); match(JOIN);
			setState(3795); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 352, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3797); match(UNION);
			setState(3798); match(JOIN);
			setState(3799); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 354, RULE_join_type);
		try {
			setState(3803);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3801); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3802); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 356, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3805); outer_join_type_part2();
			setState(3807);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(3806); match(OUTER);
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
		enterRule(_localctx, 358, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3809);
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
		enterRule(_localctx, 360, RULE_join_specification);
		try {
			setState(3813);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(3811); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(3812); named_columns_join();
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
		enterRule(_localctx, 362, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3815); match(ON);
			setState(3816); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 364, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3818); match(USING);
			setState(3819); match(LEFT_PAREN);
			setState(3820); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(3821); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 366, RULE_table_primary);
		int _la;
		try {
			setState(3850);
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
				setState(3825);
				switch ( getInterpreter().adaptivePredict(_input,495,_ctx) ) {
				case 1:
					{
					setState(3823); alias_table();
					}
					break;
				case 2:
					{
					setState(3824); table_or_query_name();
					}
					break;
				}
				setState(3831);
				switch ( getInterpreter().adaptivePredict(_input,497,_ctx) ) {
				case 1:
					{
					setState(3828);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(3827); match(AS);
						}
					}

					setState(3830); ((Table_primaryContext)_localctx).alias = alias_def();
					}
					break;
				}
				setState(3837);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3833); match(LEFT_PAREN);
					setState(3834); column_name_list();
					setState(3835); match(RIGHT_PAREN);
					}
				}

				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3839); derived_table();
				setState(3841);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3840); match(AS);
					}
				}

				setState(3843); ((Table_primaryContext)_localctx).name = identifier();
				setState(3848);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3844); match(LEFT_PAREN);
					setState(3845); column_name_list();
					setState(3846); match(RIGHT_PAREN);
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
		enterRule(_localctx, 368, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3852); identifier();
			setState(3857);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3853); match(COMMA);
				setState(3854); identifier();
				}
				}
				setState(3859);
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
		enterRule(_localctx, 370, RULE_alias_def);
		try {
			setState(3862);
			switch ( getInterpreter().adaptivePredict(_input,503,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3860); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3861); alias_table();
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
		enterRule(_localctx, 372, RULE_alias_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3864); schema_qualified_name();
			setState(3865); match(LEFT_PAREN);
			setState(3874);
			_la = _input.LA(1);
			if (((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (ADMIN - 135)) | (1L << (ALWAYS - 135)) | (1L << (ARRAY - 135)) | (1L << (AVG - 135)) | (1L << (BETWEEN - 135)) | (1L << (BY - 135)) | (1L << (CACHE - 135)) | (1L << (CALLED - 135)) | (1L << (CLASS - 135)) | (1L << (CENTURY - 135)) | (1L << (CHARACTER - 135)) | (1L << (CHECK - 135)) | (1L << (CLUSTER - 135)) | (1L << (COLLECT - 135)) | (1L << (COALESCE - 135)) | (1L << (COLUMN - 135)) | (1L << (COMMENT - 135)) | (1L << (COMMENTS - 135)) | (1L << (COMMIT - 135)) | (1L << (CONCURRENTLY - 135)) | (1L << (CONFIGURATION - 135)) | (1L << (COST - 135)) | (1L << (COUNT - 135)) | (1L << (CUBE - 135)) | (1L << (CURRENT - 135)) | (1L << (CYCLE - 135)) | (1L << (DATA - 135)) | (1L << (DAY - 135)) | (1L << (DEC - 135)) | (1L << (DECADE - 135)) | (1L << (DEFINER - 135)) | (1L << (DICTIONARY - 135)) | (1L << (DISABLE - 135)) | (1L << (DOW - 135)) | (1L << (DOY - 135)) | (1L << (DROP - 135)) | (1L << (ENABLE - 135)) | (1L << (EPOCH - 135)) | (1L << (EVENT - 135)) | (1L << (EVERY - 135)) | (1L << (EXISTS - 135)) | (1L << (EXTENDED - 135)) | (1L << (EXTERNAL - 135)) | (1L << (EXTRACT - 135)) | (1L << (FAMILY - 135)) | (1L << (FILTER - 135)) | (1L << (FIRST - 135)) | (1L << (FORMAT - 135)) | (1L << (FUSION - 135)) | (1L << (GROUPING - 135)) | (1L << (HASH - 135)) | (1L << (INHERIT - 135)) | (1L << (INDEX - 135)) | (1L << (INCREMENT - 135)) | (1L << (INPUT - 135)) | (1L << (INSERT - 135)) | (1L << (INTERSECTION - 135)) | (1L << (ISCACHABLE - 135)) | (1L << (ISODOW - 135)) | (1L << (ISOYEAR - 135)) | (1L << (ISSTRICT - 135)) | (1L << (LANGUAGE - 135)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (LARGE - 199)) | (1L << (LAST - 199)) | (1L << (LESS - 199)) | (1L << (LIST - 199)) | (1L << (LOCATION - 199)) | (1L << (MAIN - 199)) | (1L << (MATCH - 199)) | (1L << (MAX - 199)) | (1L << (MAXVALUE - 199)) | (1L << (MICROSECONDS - 199)) | (1L << (MILLENNIUM - 199)) | (1L << (MILLISECONDS - 199)) | (1L << (MIN - 199)) | (1L << (MINVALUE - 199)) | (1L << (MINUTE - 199)) | (1L << (MONTH - 199)) | (1L << (NATIONAL - 199)) | (1L << (NO - 199)) | (1L << (NONE - 199)) | (1L << (NULLIF - 199)) | (1L << (OBJECT - 199)) | (1L << (ON - 199)) | (1L << (ONLY - 199)) | (1L << (OPTION - 199)) | (1L << (OPTIONS - 199)) | (1L << (OVER - 199)) | (1L << (OVERWRITE - 199)) | (1L << (PARSER - 199)) | (1L << (PARTIAL - 199)) | (1L << (PARTITION - 199)) | (1L << (PARTITIONS - 199)) | (1L << (PLAIN - 199)) | (1L << (PRECISION - 199)) | (1L << (PUBLIC - 199)) | (1L << (PURGE - 199)) | (1L << (QUARTER - 199)) | (1L << (RANGE - 199)) | (1L << (REGCONFIG - 199)) | (1L << (REGEXP - 199)) | (1L << (RENAME - 199)) | (1L << (REPLICA - 199)) | (1L << (RESET - 199)) | (1L << (RESTART - 199)) | (1L << (RLIKE - 199)) | (1L << (ROLLUP - 199)) | (1L << (SEARCH - 199)) | (1L << (SECOND - 199)) | (1L << (SECURITY - 199)) | (1L << (SERVER - 199)) | (1L << (SET - 199)) | (1L << (SIMILAR - 199)) | (1L << (SIMPLE - 199)) | (1L << (STABLE - 199)) | (1L << (START - 199)) | (1L << (STATISTICS - 199)) | (1L << (STORAGE - 199)) | (1L << (STDDEV_POP - 199)) | (1L << (STDDEV_SAMP - 199)) | (1L << (SUBPARTITION - 199)) | (1L << (SUM - 199)) | (1L << (TABLESPACE - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (TEMPLATE - 263)) | (1L << (THAN - 263)) | (1L << (TIMEZONE - 263)) | (1L << (TIMEZONE_HOUR - 263)) | (1L << (TIMEZONE_MINUTE - 263)) | (1L << (TRIM - 263)) | (1L << (TO - 263)) | (1L << (TYPE - 263)) | (1L << (TYPES - 263)) | (1L << (UNKNOWN - 263)) | (1L << (UNLOGGED - 263)) | (1L << (USER - 263)) | (1L << (VALID - 263)) | (1L << (VALIDATE - 263)) | (1L << (VALUES - 263)) | (1L << (VAR_SAMP - 263)) | (1L << (VAR_POP - 263)) | (1L << (VARYING - 263)) | (1L << (VERSION - 263)) | (1L << (VOLATILE - 263)) | (1L << (WEEK - 263)) | (1L << (WINDOW - 263)) | (1L << (WRAPPER - 263)) | (1L << (YEAR - 263)) | (1L << (ZONE - 263)) | (1L << (BOOLEAN - 263)) | (1L << (BOOL - 263)) | (1L << (BIT - 263)) | (1L << (VARBIT - 263)) | (1L << (INT1 - 263)) | (1L << (INT2 - 263)) | (1L << (INT4 - 263)) | (1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (INET - 263)) | (1L << (INTERVAL - 263)))) != 0) || ((((_la - 327)) & ~0x3f) == 0 && ((1L << (_la - 327)) & ((1L << (VOID - 327)) | (1L << (DOUBLE_QUOTE - 327)) | (1L << (Identifier - 327)) | (1L << (QuotedIdentifier - 327)))) != 0)) {
				{
				setState(3866); identifier();
				setState(3871);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(3867); match(COMMA);
					setState(3868); identifier();
					}
					}
					setState(3873);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(3876); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 374, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3878); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 376, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3880); match(WHERE);
			setState(3881); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 378, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3884);
			switch ( getInterpreter().adaptivePredict(_input,506,_ctx) ) {
			case 1:
				{
				setState(3883); match(LEFT_PAREN);
				}
				break;
			}
			setState(3886); value_expression();
			setState(3888);
			switch ( getInterpreter().adaptivePredict(_input,507,_ctx) ) {
			case 1:
				{
				setState(3887); match(RIGHT_PAREN);
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
		enterRule(_localctx, 380, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3890); match(GROUP);
			setState(3891); match(BY);
			setState(3892); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 382, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3894); grouping_element();
			setState(3899);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3895); match(COMMA);
				setState(3896); grouping_element();
				}
				}
				setState(3901);
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
		enterRule(_localctx, 384, RULE_grouping_element);
		try {
			setState(3906);
			switch ( getInterpreter().adaptivePredict(_input,509,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3902); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3903); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3904); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3905); ordinary_grouping_set();
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
		enterRule(_localctx, 386, RULE_ordinary_grouping_set);
		try {
			setState(3913);
			switch ( getInterpreter().adaptivePredict(_input,510,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3908); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3909); match(LEFT_PAREN);
				setState(3910); row_value_predicand_list();
				setState(3911); match(RIGHT_PAREN);
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
		enterRule(_localctx, 388, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3915); ordinary_grouping_set();
			setState(3920);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3916); match(COMMA);
				setState(3917); ordinary_grouping_set();
				}
				}
				setState(3922);
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
		enterRule(_localctx, 390, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3923); match(ROLLUP);
			setState(3924); match(LEFT_PAREN);
			setState(3925); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3926); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 392, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3928); match(CUBE);
			setState(3929); match(LEFT_PAREN);
			setState(3930); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3931); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 394, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3933); match(LEFT_PAREN);
			setState(3934); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 396, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3936); match(HAVING);
			setState(3937); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 398, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3939); row_value_predicand();
			setState(3944);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3940); match(COMMA);
				setState(3941); row_value_predicand();
				}
				}
				setState(3946);
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
		enterRule(_localctx, 400, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3947); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 402, RULE_query_expression_body);
		try {
			setState(3951);
			switch ( getInterpreter().adaptivePredict(_input,513,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3949); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3950); joined_table();
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
		enterRule(_localctx, 404, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3961);
			switch ( getInterpreter().adaptivePredict(_input,515,_ctx) ) {
			case 1:
				{
				setState(3953); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(3954); joined_table();
				setState(3955);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3957);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3956);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3959); query_term();
				}
				break;
			}
			setState(3970);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(3963);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3965);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3964);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3967); query_term();
				}
				}
				setState(3972);
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
		enterRule(_localctx, 406, RULE_query_term);
		try {
			setState(3975);
			switch ( getInterpreter().adaptivePredict(_input,518,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3973); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3974); joined_table();
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
		enterRule(_localctx, 408, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3985);
			switch ( getInterpreter().adaptivePredict(_input,520,_ctx) ) {
			case 1:
				{
				setState(3977); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(3978); joined_table();
				setState(3979); match(INTERSECT);
				setState(3981);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3980);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3983); query_primary();
				}
				break;
			}
			setState(3994);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(3987); match(INTERSECT);
				setState(3989);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3988);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3991); query_primary();
				}
				}
				setState(3996);
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
		enterRule(_localctx, 410, RULE_query_primary);
		try {
			setState(3999);
			switch ( getInterpreter().adaptivePredict(_input,523,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3997); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3998); joined_table();
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
		enterRule(_localctx, 412, RULE_non_join_query_primary);
		try {
			setState(4006);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(4001); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(4002); match(LEFT_PAREN);
				setState(4003); non_join_query_expression();
				setState(4004); match(RIGHT_PAREN);
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
		enterRule(_localctx, 414, RULE_simple_table);
		try {
			setState(4010);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(4008); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(4009); explicit_table();
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
		enterRule(_localctx, 416, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4012); match(TABLE);
			setState(4013); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 418, RULE_table_or_query_name);
		try {
			setState(4017);
			switch ( getInterpreter().adaptivePredict(_input,526,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4015); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4016); identifier();
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
		enterRule(_localctx, 420, RULE_schema_qualified_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4019); identifier();
			setState(4026);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(4020); match(DOT);
				setState(4021); identifier();
				setState(4024);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(4022); match(DOT);
					setState(4023); identifier();
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
		enterRule(_localctx, 422, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4028); match(SELECT);
			setState(4030);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(4029); set_qualifier();
				}
			}

			setState(4032); select_list();
			setState(4034);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(4033); table_expression();
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
		enterRule(_localctx, 424, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4036); select_sublist();
			setState(4041);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(4037); match(COMMA);
				setState(4038); select_sublist();
				}
				}
				setState(4043);
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
		enterRule(_localctx, 426, RULE_select_sublist);
		try {
			setState(4046);
			switch ( getInterpreter().adaptivePredict(_input,532,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4044); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4045); qualified_asterisk();
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
		enterRule(_localctx, 428, RULE_derived_column);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(4048); value_expression();
			setState(4053);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,534,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(4051);
					switch ( getInterpreter().adaptivePredict(_input,533,_ctx) ) {
					case 1:
						{
						setState(4049); as_clause();
						}
						break;
					case 2:
						{
						setState(4050); over_clause();
						}
						break;
					}
					} 
				}
				setState(4055);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,534,_ctx);
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
		enterRule(_localctx, 430, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4058);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(4056); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(4057); match(DOT);
				}
			}

			setState(4060); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 432, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4062);
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
		enterRule(_localctx, 434, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4067);
			switch ( getInterpreter().adaptivePredict(_input,536,_ctx) ) {
			case 1:
				{
				setState(4064); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(4065); match(DOT);
				}
				break;
			}
			setState(4069); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 436, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4072);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(4071); match(AS);
				}
			}

			setState(4074); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 438, RULE_over_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4076); match(OVER);
			setState(4077); match(LEFT_PAREN);
			setState(4083);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ASC || _la==DESC || _la==ORDER || _la==PARTITION) {
				{
				setState(4081);
				switch (_input.LA(1)) {
				case PARTITION:
					{
					setState(4078); partition_by_columns();
					}
					break;
				case ORDER:
					{
					setState(4079); orderby_clause();
					}
					break;
				case ASC:
				case DESC:
					{
					setState(4080); order_specification();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(4085);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(4086); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 440, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4088); column_reference();
			setState(4093);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(4089); match(COMMA);
				setState(4090); column_reference();
				}
				}
				setState(4095);
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
		enterRule(_localctx, 442, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4096); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 444, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4098); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 446, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4100); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 448, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4102); match(LEFT_PAREN);
			setState(4103); query_expression();
			setState(4104); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 450, RULE_predicate);
		try {
			setState(4112);
			switch ( getInterpreter().adaptivePredict(_input,541,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4106); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4107); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(4108); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(4109); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(4110); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(4111); exists_predicate();
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
		enterRule(_localctx, 452, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4114); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(4115); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(4116); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 454, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4118);
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
		enterRule(_localctx, 456, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4120); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(4121); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 458, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4124);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(4123); match(NOT);
				}
			}

			setState(4126); match(BETWEEN);
			setState(4128);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(4127);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(4130); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(4131); match(AND);
			setState(4132); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 460, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4134); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(4136);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(4135); match(NOT);
				}
			}

			setState(4138); match(IN);
			setState(4139); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 462, RULE_in_predicate_value);
		try {
			setState(4146);
			switch ( getInterpreter().adaptivePredict(_input,545,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4141); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4142); match(LEFT_PAREN);
				setState(4143); in_value_list();
				setState(4144); match(RIGHT_PAREN);
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
		enterRule(_localctx, 464, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4148); row_value_expression();
			setState(4153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(4149); match(COMMA);
				setState(4150); row_value_expression();
				}
				}
				setState(4155);
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
		enterRule(_localctx, 466, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4156); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(4157); pattern_matcher();
			setState(4158); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 468, RULE_pattern_matcher);
		int _la;
		try {
			setState(4165);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(4161);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(4160); match(NOT);
					}
				}

				setState(4163); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(4164); regex_matcher();
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
		enterRule(_localctx, 470, RULE_negativable_matcher);
		try {
			setState(4173);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(4167); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(4168); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(4169); match(SIMILAR);
				setState(4170); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(4171); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(4172); match(RLIKE);
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
		enterRule(_localctx, 472, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4175);
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
		enterRule(_localctx, 474, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4177); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(4178); match(IS);
			setState(4180);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(4179); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(4182); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 476, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4184); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(4185); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(4186); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(4187); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 478, RULE_quantifier);
		try {
			setState(4191);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(4189); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(4190); some();
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
		enterRule(_localctx, 480, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4193); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 482, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4195);
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
		enterRule(_localctx, 484, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4198);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(4197); match(NOT);
				}
			}

			setState(4200); match(EXISTS);
			setState(4201); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 486, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4203); match(UNIQUE);
			setState(4204); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 488, RULE_primary_datetime_field);
		try {
			setState(4208);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(4206); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(4207); match(SECOND);
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
		enterRule(_localctx, 490, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4210);
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
		enterRule(_localctx, 492, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4212);
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
		enterRule(_localctx, 494, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4214); match(ORDER);
			setState(4215); match(BY);
			setState(4216); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 496, RULE_sort_specifier_paren);
		int _la;
		try {
			setState(4227);
			switch ( getInterpreter().adaptivePredict(_input,556,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4218); sort_specifier_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4219); match(LEFT_PAREN);
				setState(4222); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(4222);
					switch ( getInterpreter().adaptivePredict(_input,554,_ctx) ) {
					case 1:
						{
						setState(4220);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==LEFT_PAREN || _la==RIGHT_PAREN) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						break;
					case 2:
						{
						setState(4221); sort_specifier_paren();
						}
						break;
					}
					}
					setState(4224); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << ALTER) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << HANDLER) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INLINE) | (1L << INNER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTERSECT - 64)) | (1L << (INTO - 64)) | (1L << (INOUT - 64)) | (1L << (INSTEAD - 64)) | (1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (OWNER - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRUSTED - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (VALIDATOR - 128)) | (1L << (VARIADIC - 128)) | (1L << (VIEW - 128)) | (1L << (WHEN - 128)) | (1L << (WHERE - 128)) | (1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (ALWAYS - 128)) | (1L << (ARRAY - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (CLUSTER - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONCURRENTLY - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DISABLE - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (ENABLE - 128)) | (1L << (EPOCH - 128)) | (1L << (EVENT - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTENDED - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INHERIT - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (INSERT - 192)) | (1L << (INTERSECTION - 192)) | (1L << (ISCACHABLE - 192)) | (1L << (ISODOW - 192)) | (1L << (ISOYEAR - 192)) | (1L << (ISSTRICT - 192)) | (1L << (LANGUAGE - 192)) | (1L << (LARGE - 192)) | (1L << (LAST - 192)) | (1L << (LESS - 192)) | (1L << (LIST - 192)) | (1L << (LOCATION - 192)) | (1L << (MAIN - 192)) | (1L << (MATCH - 192)) | (1L << (MAX - 192)) | (1L << (MAXVALUE - 192)) | (1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (N_DISTINCT - 192)) | (1L << (N_DISTINCT_INHERITED - 192)) | (1L << (OBJECT - 192)) | (1L << (ON - 192)) | (1L << (ONLY - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVER - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PLAIN - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGCONFIG - 192)) | (1L << (REGEXP - 192)) | (1L << (RENAME - 192)) | (1L << (REPLICA - 192)) | (1L << (RESET - 192)) | (1L << (RESTART - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STATISTICS - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (STORAGE - 256)) | (1L << (STDDEV_POP - 256)) | (1L << (STDDEV_SAMP - 256)) | (1L << (SUBPARTITION - 256)) | (1L << (SUM - 256)) | (1L << (TABLESPACE - 256)) | (1L << (TABLES - 256)) | (1L << (TEMPLATE - 256)) | (1L << (THAN - 256)) | (1L << (TIMEZONE - 256)) | (1L << (TIMEZONE_HOUR - 256)) | (1L << (TIMEZONE_MINUTE - 256)) | (1L << (TRIM - 256)) | (1L << (TO - 256)) | (1L << (TYPE - 256)) | (1L << (TYPES - 256)) | (1L << (UNKNOWN - 256)) | (1L << (UNLOGGED - 256)) | (1L << (USER - 256)) | (1L << (VALID - 256)) | (1L << (VALIDATE - 256)) | (1L << (VALUES - 256)) | (1L << (VAR_SAMP - 256)) | (1L << (VAR_POP - 256)) | (1L << (VARYING - 256)) | (1L << (VERSION - 256)) | (1L << (VOLATILE - 256)) | (1L << (WEEK - 256)) | (1L << (WINDOW - 256)) | (1L << (WRAPPER - 256)) | (1L << (YEAR - 256)) | (1L << (ZONE - 256)) | (1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (BINARY - 320)) | (1L << (VARBINARY - 320)) | (1L << (BLOB - 320)) | (1L << (BYTEA - 320)) | (1L << (INET4 - 320)) | (1L << (INET - 320)) | (1L << (INTERVAL - 320)) | (1L << (VOID - 320)) | (1L << (Similar_To - 320)) | (1L << (Not_Similar_To - 320)) | (1L << (Similar_To_Case_Insensitive - 320)) | (1L << (Not_Similar_To_Case_Insensitive - 320)) | (1L << (CAST_EXPRESSION - 320)) | (1L << (ASSIGN - 320)) | (1L << (EQUAL - 320)) | (1L << (COLON - 320)) | (1L << (SEMI_COLON - 320)) | (1L << (COMMA - 320)) | (1L << (CONCATENATION_OPERATOR - 320)) | (1L << (NOT_EQUAL - 320)) | (1L << (LTH - 320)) | (1L << (LEQ - 320)) | (1L << (GTH - 320)) | (1L << (GEQ - 320)) | (1L << (LEFT_PAREN - 320)) | (1L << (PLUS - 320)) | (1L << (MINUS - 320)) | (1L << (MULTIPLY - 320)) | (1L << (DIVIDE - 320)) | (1L << (MODULAR - 320)) | (1L << (DOT - 320)) | (1L << (UNDERLINE - 320)) | (1L << (VERTICAL_BAR - 320)) | (1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (LEFT_BRACKET - 320)) | (1L << (RIGHT_BRACKET - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (QuotedIdentifier - 320)) | (1L << (UnterminatedQuotedIdentifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (BeginDollarStringConstant - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)) | (1L << (Text_between_Dollar - 320)) | (1L << (EndDollarStringConstant - 320)))) != 0) );
				setState(4226); match(RIGHT_PAREN);
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
		enterRule(_localctx, 498, RULE_sort_specifier_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(4229); sort_specifier();
			setState(4234);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,557,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(4230); match(COMMA);
					setState(4231); sort_specifier();
					}
					} 
				}
				setState(4236);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,557,_ctx);
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
		enterRule(_localctx, 500, RULE_sort_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4237); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(4239);
			switch ( getInterpreter().adaptivePredict(_input,558,_ctx) ) {
			case 1:
				{
				setState(4238); ((Sort_specifierContext)_localctx).order = order_specification();
				}
				break;
			}
			setState(4242);
			switch ( getInterpreter().adaptivePredict(_input,559,_ctx) ) {
			case 1:
				{
				setState(4241); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 502, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4244);
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
		enterRule(_localctx, 504, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4246); match(LIMIT);
			setState(4247); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 506, RULE_null_ordering);
		try {
			setState(4253);
			switch ( getInterpreter().adaptivePredict(_input,560,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4249); match(NULL);
				setState(4250); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(4251); match(NULL);
				setState(4252); match(LAST);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0177\u10a2\4\2\t"+
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
		"\4\u00ff\t\u00ff\3\2\3\2\3\2\7\2\u0202\n\2\f\2\16\2\u0205\13\2\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\4\5\4\u020e\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5\u021e\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0226\n"+
		"\6\3\7\3\7\3\7\3\7\6\7\u022c\n\7\r\7\16\7\u022d\3\7\5\7\u0231\n\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7\u0248\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\b\u0258\n\b\3\t\3\t\5\t\u025c\n\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\t\u0266\n\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u026e\n\t\3\n\3\n\3"+
		"\n\5\n\u0273\n\n\3\n\6\n\u0276\n\n\r\n\16\n\u0277\3\n\3\n\3\n\7\n\u027d"+
		"\n\n\f\n\16\n\u0280\13\n\3\n\3\n\3\n\5\n\u0285\n\n\3\n\6\n\u0288\n\n\r"+
		"\n\16\n\u0289\3\n\3\n\5\n\u028e\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u02a2\n\n\3\13\3\13\5\13\u02a6"+
		"\n\13\3\13\3\13\3\13\5\13\u02ab\n\13\3\13\3\13\5\13\u02af\n\13\3\13\3"+
		"\13\5\13\u02b3\n\13\3\13\3\13\5\13\u02b7\n\13\3\13\3\13\3\13\5\13\u02bc"+
		"\n\13\3\13\3\13\3\13\3\13\5\13\u02c2\n\13\3\13\3\13\5\13\u02c6\n\13\3"+
		"\13\3\13\5\13\u02ca\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u02d3"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u02db\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u02e5\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u02ee\n\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u02f6\n\13\f\13\16"+
		"\13\u02f9\13\13\3\13\3\13\3\13\3\13\5\13\u02ff\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\7\13\u0307\n\13\f\13\16\13\u030a\13\13\3\13\3\13\3\13\3\13"+
		"\5\13\u0310\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u031e\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u0329\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0333\n\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0350"+
		"\n\13\f\13\16\13\u0353\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0366\n\13\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\5\r\u036e\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0379"+
		"\n\r\3\r\3\r\3\r\3\r\5\r\u037f\n\r\5\r\u0381\n\r\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0393"+
		"\n\17\3\17\3\17\3\17\5\17\u0398\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u03a7\n\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u03b2\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\7\20\u03bc\n\20\f\20\16\20\u03bf\13\20\5\20\u03c1\n\20\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u03c8\n\20\f\20\16\20\u03cb\13\20\5\20\u03cd\n\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u03d5\n\21\f\21\16\21\u03d8\13\21"+
		"\3\21\3\21\5\21\u03dc\n\21\5\21\u03de\n\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\7\21\u03e7\n\21\f\21\16\21\u03ea\13\21\3\21\3\21\5\21\u03ee\n"+
		"\21\5\21\u03f0\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u03f9\n\21"+
		"\5\21\u03fb\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0404\n\21\5"+
		"\21\u0406\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u040f\n\21\3\21"+
		"\3\21\3\21\7\21\u0414\n\21\f\21\16\21\u0417\13\21\3\21\3\21\5\21\u041b"+
		"\n\21\5\21\u041d\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0426\n"+
		"\21\3\21\3\21\3\21\7\21\u042b\n\21\f\21\16\21\u042e\13\21\3\21\3\21\5"+
		"\21\u0432\n\21\5\21\u0434\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u043d\n\21\3\21\3\21\3\21\5\21\u0442\n\21\5\21\u0444\n\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\5\21\u044d\n\21\3\21\3\21\3\21\5\21\u0452\n\21"+
		"\5\21\u0454\n\21\3\21\3\21\3\21\5\21\u0459\n\21\3\22\3\22\3\22\3\22\5"+
		"\22\u045f\n\22\3\22\3\22\3\22\3\22\5\22\u0465\n\22\3\22\5\22\u0468\n\22"+
		"\7\22\u046a\n\22\f\22\16\22\u046d\13\22\3\22\3\22\3\22\3\22\5\22\u0473"+
		"\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u047e\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0489\n\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u0490\n\22\3\23\3\23\5\23\u0494\n\23\3\23\3\23\5\23\u0498"+
		"\n\23\3\23\5\23\u049b\n\23\3\23\3\23\3\23\3\23\5\23\u04a1\n\23\3\23\3"+
		"\23\5\23\u04a5\n\23\3\23\3\23\5\23\u04a9\n\23\3\23\3\23\5\23\u04ad\n\23"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u04b4\n\24\3\24\3\24\5\24\u04b8\n\24\3"+
		"\24\3\24\5\24\u04bc\n\24\3\24\3\24\5\24\u04c0\n\24\3\24\3\24\5\24\u04c4"+
		"\n\24\3\25\3\25\3\25\5\25\u04c9\n\25\3\25\5\25\u04cc\n\25\3\25\3\25\3"+
		"\25\3\25\3\25\5\25\u04d3\n\25\3\25\5\25\u04d6\n\25\3\25\5\25\u04d9\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u04e1\n\25\3\25\3\25\5\25\u04e5\n"+
		"\25\5\25\u04e7\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\7\26\u04f6\n\26\f\26\16\26\u04f9\13\26\3\26\3\26\5\26"+
		"\u04fd\n\26\6\26\u04ff\n\26\r\26\16\26\u0500\5\26\u0503\n\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\5\27\u050b\n\27\3\27\3\27\3\27\3\27\3\27\7\27\u0512"+
		"\n\27\f\27\16\27\u0515\13\27\3\27\3\27\5\27\u0519\n\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u0520\n\27\3\27\3\27\3\27\3\27\5\27\u0526\n\27\7\27\u0528"+
		"\n\27\f\27\16\27\u052b\13\27\5\27\u052d\n\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u0535\n\30\3\31\3\31\5\31\u0539\n\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\5\31\u0541\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u054b\n\31\f\31\16\31\u054e\13\31\5\31\u0550\n\31\5\31\u0552\n\31\3\31"+
		"\5\31\u0555\n\31\6\31\u0557\n\31\r\31\16\31\u0558\3\31\3\31\3\31\3\31"+
		"\5\31\u055f\n\31\3\31\3\31\3\31\5\31\u0564\n\31\3\31\3\31\3\31\3\31\5"+
		"\31\u056a\n\31\3\31\3\31\5\31\u056e\n\31\3\31\3\31\5\31\u0572\n\31\3\31"+
		"\3\31\5\31\u0576\n\31\3\31\3\31\3\31\3\31\3\31\5\31\u057d\n\31\3\31\3"+
		"\31\7\31\u0581\n\31\f\31\16\31\u0584\13\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\5\32\u058c\n\32\3\32\3\32\3\32\7\32\u0591\n\32\f\32\16\32\u0594\13"+
		"\32\3\32\3\32\5\32\u0598\n\32\5\32\u059a\n\32\3\32\3\32\5\32\u059e\n\32"+
		"\3\32\6\32\u05a1\n\32\r\32\16\32\u05a2\3\32\3\32\3\32\3\32\3\32\6\32\u05aa"+
		"\n\32\r\32\16\32\u05ab\5\32\u05ae\n\32\3\32\3\32\3\32\3\32\3\32\3\32\5"+
		"\32\u05b6\n\32\3\32\3\32\3\32\3\32\3\32\7\32\u05bd\n\32\f\32\16\32\u05c0"+
		"\13\32\3\32\3\32\6\32\u05c4\n\32\r\32\16\32\u05c5\3\32\3\32\5\32\u05ca"+
		"\n\32\3\32\3\32\3\32\3\32\7\32\u05d0\n\32\f\32\16\32\u05d3\13\32\3\32"+
		"\3\32\5\32\u05d7\n\32\3\32\3\32\5\32\u05db\n\32\3\32\3\32\3\32\7\32\u05e0"+
		"\n\32\f\32\16\32\u05e3\13\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u05eb"+
		"\n\32\3\32\6\32\u05ee\n\32\r\32\16\32\u05ef\3\32\3\32\5\32\u05f4\n\32"+
		"\5\32\u05f6\n\32\3\32\3\32\3\32\3\32\3\32\7\32\u05fd\n\32\f\32\16\32\u0600"+
		"\13\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0609\n\32\f\32\16\32\u060c"+
		"\13\32\5\32\u060e\n\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0616\n\32\3"+
		"\32\6\32\u0619\n\32\r\32\16\32\u061a\3\32\3\32\5\32\u061f\n\32\5\32\u0621"+
		"\n\32\3\32\3\32\3\32\3\32\3\32\7\32\u0628\n\32\f\32\16\32\u062b\13\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0633\n\32\3\32\3\32\3\32\5\32\u0638"+
		"\n\32\5\32\u063a\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0643\n"+
		"\32\f\32\16\32\u0646\13\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u064e\n"+
		"\32\3\32\3\32\3\32\5\32\u0653\n\32\5\32\u0655\n\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\7\32\u065d\n\32\f\32\16\32\u0660\13\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u0668\n\32\3\32\3\32\3\32\5\32\u066d\n\32\5\32\u066f\n"+
		"\32\3\32\3\32\3\32\5\32\u0674\n\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32"+
		"\u067c\n\32\3\32\3\32\3\32\5\32\u0681\n\32\5\32\u0683\n\32\3\32\3\32\3"+
		"\32\3\32\3\32\7\32\u068a\n\32\f\32\16\32\u068d\13\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\5\32\u0695\n\32\3\32\3\32\3\32\5\32\u069a\n\32\6\32\u069c"+
		"\n\32\r\32\16\32\u069d\3\32\3\32\5\32\u06a2\n\32\5\32\u06a4\n\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\7\32\u06ac\n\32\f\32\16\32\u06af\13\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u06b7\n\32\3\32\3\32\5\32\u06bb\n\32\6"+
		"\32\u06bd\n\32\r\32\16\32\u06be\3\32\3\32\5\32\u06c3\n\32\5\32\u06c5\n"+
		"\32\3\32\3\32\3\32\3\32\3\32\7\32\u06cc\n\32\f\32\16\32\u06cf\13\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\5\32\u06d7\n\32\3\32\3\32\3\32\5\32\u06dc"+
		"\n\32\5\32\u06de\n\32\3\32\3\32\3\32\3\32\3\32\7\32\u06e5\n\32\f\32\16"+
		"\32\u06e8\13\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u06f0\n\32\3\32\3\32"+
		"\3\32\7\32\u06f5\n\32\f\32\16\32\u06f8\13\32\3\32\3\32\3\32\3\32\7\32"+
		"\u06fe\n\32\f\32\16\32\u0701\13\32\3\32\5\32\u0704\n\32\5\32\u0706\n\32"+
		"\3\33\3\33\5\33\u070a\n\33\3\33\3\33\5\33\u070e\n\33\3\33\3\33\5\33\u0712"+
		"\n\33\3\33\3\33\5\33\u0716\n\33\7\33\u0718\n\33\f\33\16\33\u071b\13\33"+
		"\3\33\5\33\u071e\n\33\3\34\3\34\3\34\3\34\7\34\u0724\n\34\f\34\16\34\u0727"+
		"\13\34\3\34\3\34\5\34\u072b\n\34\5\34\u072d\n\34\3\34\3\34\5\34\u0731"+
		"\n\34\3\34\3\34\5\34\u0735\n\34\6\34\u0737\n\34\r\34\16\34\u0738\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u0741\n\34\6\34\u0743\n\34\r\34\16\34\u0744"+
		"\5\34\u0747\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0750\n\34\f"+
		"\34\16\34\u0753\13\34\6\34\u0755\n\34\r\34\16\34\u0756\3\34\3\34\5\34"+
		"\u075b\n\34\3\34\3\34\3\34\7\34\u0760\n\34\f\34\16\34\u0763\13\34\5\34"+
		"\u0765\n\34\3\34\3\34\5\34\u0769\n\34\3\34\3\34\5\34\u076d\n\34\6\34\u076f"+
		"\n\34\r\34\16\34\u0770\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0779\n\34\f"+
		"\34\16\34\u077c\13\34\3\34\3\34\5\34\u0780\n\34\5\34\u0782\n\34\3\34\3"+
		"\34\3\34\3\34\3\34\7\34\u0789\n\34\f\34\16\34\u078c\13\34\6\34\u078e\n"+
		"\34\r\34\16\34\u078f\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0799\n\34"+
		"\f\34\16\34\u079c\13\34\5\34\u079e\n\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\7\34\u07a6\n\34\f\34\16\34\u07a9\13\34\3\34\3\34\5\34\u07ad\n\34\5\34"+
		"\u07af\n\34\3\34\3\34\3\34\3\34\3\34\7\34\u07b6\n\34\f\34\16\34\u07b9"+
		"\13\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u07c1\n\34\5\34\u07c3\n\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u07cc\n\34\f\34\16\34\u07cf\13"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u07d7\n\34\5\34\u07d9\n\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\7\34\u07e1\n\34\f\34\16\34\u07e4\13\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u07ec\n\34\5\34\u07ee\n\34\3\34\3\34\3"+
		"\34\5\34\u07f3\n\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u07fb\n\34\5\34"+
		"\u07fd\n\34\3\34\3\34\3\34\3\34\3\34\7\34\u0804\n\34\f\34\16\34\u0807"+
		"\13\34\3\34\3\34\3\34\3\34\3\34\5\34\u080e\n\34\6\34\u0810\n\34\r\34\16"+
		"\34\u0811\3\34\3\34\5\34\u0816\n\34\5\34\u0818\n\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\7\34\u0820\n\34\f\34\16\34\u0823\13\34\3\34\3\34\3\34\3\34"+
		"\3\34\5\34\u082a\n\34\6\34\u082c\n\34\r\34\16\34\u082d\3\34\3\34\5\34"+
		"\u0832\n\34\5\34\u0834\n\34\3\34\3\34\3\34\3\34\3\34\7\34\u083b\n\34\f"+
		"\34\16\34\u083e\13\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0846\n\34\5"+
		"\34\u0848\n\34\3\34\3\34\3\34\3\34\3\34\7\34\u084f\n\34\f\34\16\34\u0852"+
		"\13\34\3\34\3\34\3\34\3\34\3\34\7\34\u0859\n\34\f\34\16\34\u085c\13\34"+
		"\3\34\3\34\3\34\3\34\7\34\u0862\n\34\f\34\16\34\u0865\13\34\3\34\3\34"+
		"\3\34\5\34\u086a\n\34\5\34\u086c\n\34\3\35\3\35\5\35\u0870\n\35\3\35\3"+
		"\35\5\35\u0874\n\35\3\35\3\35\5\35\u0878\n\35\3\35\3\35\5\35\u087c\n\35"+
		"\7\35\u087e\n\35\f\35\16\35\u0881\13\35\3\35\3\35\3\35\5\35\u0886\n\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0890\n\36\f\36\16\36\u0893"+
		"\13\36\5\36\u0895\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u08d3\n\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u0901\n\36\3\36\3\36\3\36\3\37\3\37\3\37\5\37\u0909\n\37\3\37\3"+
		"\37\3\37\3\37\3\37\5\37\u0910\n\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37"+
		"\u0918\n\37\f\37\16\37\u091b\13\37\3\37\3\37\5\37\u091f\n\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u092e\n\37"+
		"\3\37\3\37\3\37\5\37\u0933\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0943\n\37\3\37\3\37\7\37\u0947\n"+
		"\37\f\37\16\37\u094a\13\37\3\37\3\37\3\37\3\37\3\37\3\37\6\37\u0952\n"+
		"\37\r\37\16\37\u0953\3\37\3\37\3\37\3\37\3\37\7\37\u095b\n\37\f\37\16"+
		"\37\u095e\13\37\3\37\3\37\5\37\u0962\n\37\3 \3 \3 \3!\3!\3!\3!\5!\u096b"+
		"\n!\3!\3!\3!\5!\u0970\n!\7!\u0972\n!\f!\16!\u0975\13!\5!\u0977\n!\3!\3"+
		"!\3\"\3\"\3\"\3#\3#\6#\u0980\n#\r#\16#\u0981\3#\3#\3$\5$\u0987\n$\3$\5"+
		"$\u098a\n$\3$\3$\3$\5$\u098f\n$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3"+
		"(\7(\u099d\n(\f(\16(\u09a0\13(\5(\u09a2\n(\3(\3(\3)\3)\3)\3)\3)\3)\3)"+
		"\7)\u09ad\n)\f)\16)\u09b0\13)\3*\3*\5*\u09b4\n*\3*\3*\3*\7*\u09b9\n*\f"+
		"*\16*\u09bc\13*\3+\3+\5+\u09c0\n+\3+\3+\3+\3+\3+\5+\u09c7\n+\3+\3+\3+"+
		"\3+\5+\u09cd\n+\3+\3+\5+\u09d1\n+\3+\3+\3+\3+\5+\u09d7\n+\3+\3+\3+\3+"+
		"\3+\5+\u09de\n+\5+\u09e0\n+\3,\3,\3,\3,\3,\5,\u09e7\n,\3,\7,\u09ea\n,"+
		"\f,\16,\u09ed\13,\3,\3,\3,\3,\3,\7,\u09f4\n,\f,\16,\u09f7\13,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\5,\u0a01\n,\3,\3,\3,\3,\3,\3,\3,\5,\u0a0a\n,\3-\3-\3"+
		"-\5-\u0a0f\n-\3-\5-\u0a12\n-\3-\3-\3-\3-\5-\u0a18\n-\7-\u0a1a\n-\f-\16"+
		"-\u0a1d\13-\3-\3-\3-\3-\3-\5-\u0a24\n-\6-\u0a26\n-\r-\16-\u0a27\3-\3-"+
		"\5-\u0a2c\n-\3-\3-\3-\3.\3.\5.\u0a33\n.\3.\3.\5.\u0a37\n.\3.\3.\3.\3."+
		"\5.\u0a3d\n.\3.\3.\3.\3.\3.\7.\u0a44\n.\f.\16.\u0a47\13.\5.\u0a49\n.\3"+
		".\3.\3.\3.\3.\5.\u0a50\n.\6.\u0a52\n.\r.\16.\u0a53\3.\3.\5.\u0a58\n.\3"+
		".\3.\3.\3.\3.\3.\5.\u0a60\n.\3.\3.\5.\u0a64\n.\3.\3.\3.\3.\5.\u0a6a\n"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\7.\u0a74\n.\f.\16.\u0a77\13.\3.\5.\u0a7a\n."+
		"\3.\3.\3.\3.\3.\7.\u0a81\n.\f.\16.\u0a84\13.\3.\7.\u0a87\n.\f.\16.\u0a8a"+
		"\13.\3.\3.\5.\u0a8e\n.\3.\3.\3.\3.\5.\u0a94\n.\3/\3/\3/\3/\3/\7/\u0a9b"+
		"\n/\f/\16/\u0a9e\13/\5/\u0aa0\n/\3\60\3\60\3\60\5\60\u0aa5\n\60\3\60\3"+
		"\60\5\60\u0aa9\n\60\3\60\7\60\u0aac\n\60\f\60\16\60\u0aaf\13\60\3\61\3"+
		"\61\3\61\3\62\3\62\5\62\u0ab6\n\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62"+
		"\u0abe\n\62\f\62\16\62\u0ac1\13\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\7\62\u0acc\n\62\f\62\16\62\u0acf\13\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\5\62\u0ad7\n\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u0adf\n"+
		"\62\f\62\16\62\u0ae2\13\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0aeb"+
		"\n\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u0af3\n\62\f\62\16\62\u0af6\13"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u0aff\n\62\f\62\16\62\u0b02"+
		"\13\62\3\62\3\62\5\62\u0b06\n\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0b0e"+
		"\n\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u0b16\n\62\f\62\16\62\u0b19\13"+
		"\62\5\62\u0b1b\n\62\3\62\3\62\3\62\5\62\u0b20\n\62\3\62\3\62\3\62\3\62"+
		"\5\62\u0b26\n\62\3\63\3\63\5\63\u0b2a\n\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\5\63\u0b33\n\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\5\63\u0b43\n\63\3\63\3\63\3\63\5\63\u0b48\n"+
		"\63\3\63\3\63\3\63\5\63\u0b4d\n\63\5\63\u0b4f\n\63\3\63\3\63\3\63\5\63"+
		"\u0b54\n\63\3\63\3\63\3\63\3\63\5\63\u0b5a\n\63\3\64\3\64\6\64\u0b5e\n"+
		"\64\r\64\16\64\u0b5f\3\64\3\64\6\64\u0b64\n\64\r\64\16\64\u0b65\3\65\3"+
		"\65\3\65\3\65\5\65\u0b6c\n\65\3\65\5\65\u0b6f\n\65\6\65\u0b71\n\65\r\65"+
		"\16\65\u0b72\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\5\67\u0b7f"+
		"\n\67\38\38\38\38\38\38\38\58\u0b88\n8\58\u0b8a\n8\39\39\59\u0b8e\n9\3"+
		":\3:\3:\3:\3:\3:\5:\u0b96\n:\3;\5;\u0b99\n;\3;\3;\3;\3;\5;\u0b9f\n;\3"+
		"<\3<\3<\3<\7<\u0ba5\n<\f<\16<\u0ba8\13<\3<\3<\3=\3=\3=\3>\3>\3?\3?\3?"+
		"\3?\3?\7?\u0bb6\n?\f?\16?\u0bb9\13?\3?\3?\3@\3@\3@\3@\3A\3A\3A\3B\3B\3"+
		"B\3C\3C\3D\3D\3D\3D\5D\u0bcd\nD\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3F\3F\3"+
		"F\7F\u0bdc\nF\fF\16F\u0bdf\13F\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\5G\u0beb"+
		"\nG\3G\3G\5G\u0bef\nG\5G\u0bf1\nG\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\5H"+
		"\u0bfe\nH\3I\3I\3I\7I\u0c03\nI\fI\16I\u0c06\13I\3J\3J\3J\3K\3K\3K\3L\3"+
		"L\3L\3L\3L\3L\3L\3L\3L\3L\3M\3M\3M\7M\u0c1b\nM\fM\16M\u0c1e\13M\3N\3N"+
		"\3N\3N\5N\u0c24\nN\3N\3N\3N\3N\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\7P\u0c34"+
		"\nP\fP\16P\u0c37\13P\3Q\3Q\3R\3R\3R\3R\5R\u0c3f\nR\3S\3S\3S\5S\u0c44\n"+
		"S\3S\3S\5S\u0c48\nS\5S\u0c4a\nS\3T\3T\3U\3U\5U\u0c50\nU\3V\3V\3V\5V\u0c55"+
		"\nV\3W\3W\3W\5W\u0c5a\nW\3X\3X\3X\3Y\3Y\3Y\3Z\3Z\3Z\3[\3[\3[\5[\u0c68"+
		"\n[\3[\3[\5[\u0c6c\n[\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\"+
		"\3\\\3\\\3\\\5\\\u0c7d\n\\\3]\3]\3^\3^\3_\3_\5_\u0c85\n_\3_\3_\5_\u0c89"+
		"\n_\3_\3_\3_\5_\u0c8e\n_\3_\3_\3_\5_\u0c93\n_\3_\3_\5_\u0c97\n_\3_\3_"+
		"\5_\u0c9b\n_\3`\3`\3`\3`\3a\3a\3a\5a\u0ca4\na\3a\3a\3a\5a\u0ca9\na\3a"+
		"\3a\5a\u0cad\na\3a\3a\3a\3a\5a\u0cb3\na\3a\3a\3a\3a\5a\u0cb9\na\3a\3a"+
		"\3a\5a\u0cbe\na\3a\3a\5a\u0cc2\na\5a\u0cc4\na\3b\3b\5b\u0cc8\nb\3b\3b"+
		"\5b\u0ccc\nb\5b\u0cce\nb\3c\3c\5c\u0cd2\nc\3d\3d\5d\u0cd6\nd\3d\3d\5d"+
		"\u0cda\nd\3d\3d\5d\u0cde\nd\3d\3d\3d\3d\3d\3d\3d\3d\3d\5d\u0ce9\nd\3e"+
		"\3e\5e\u0ced\ne\3e\3e\3e\3e\3e\3e\5e\u0cf5\ne\3f\3f\3f\3f\3f\3f\3f\3f"+
		"\5f\u0cff\nf\3g\3g\3h\3h\3h\3h\3h\5h\u0d08\nh\3h\3h\3h\3h\3h\5h\u0d0f"+
		"\nh\3h\5h\u0d12\nh\3i\3i\5i\u0d16\ni\3i\3i\5i\u0d1a\ni\3i\3i\3i\5i\u0d1f"+
		"\ni\5i\u0d21\ni\3j\3j\5j\u0d25\nj\3j\3j\3j\5j\u0d2a\nj\3j\3j\5j\u0d2e"+
		"\nj\5j\u0d30\nj\3k\3k\5k\u0d34\nk\3l\3l\3l\3l\3m\3m\3m\3m\3m\3m\3m\3m"+
		"\5m\u0d42\nm\3n\3n\3o\3o\3p\5p\u0d49\np\3p\3p\3q\3q\3r\3r\3r\3r\3r\3r"+
		"\5r\u0d55\nr\5r\u0d57\nr\3s\3s\3s\5s\u0d5c\ns\3s\3s\3s\3t\3t\3u\3u\3u"+
		"\3u\3u\3v\3v\3v\3v\3v\3w\3w\3x\3x\3x\3x\3x\3x\3x\3x\3x\3x\3x\3x\6x\u0d7b"+
		"\nx\rx\16x\u0d7c\3x\3x\5x\u0d81\nx\3y\3y\5y\u0d85\ny\3z\3z\3z\6z\u0d8a"+
		"\nz\rz\16z\u0d8b\3z\5z\u0d8f\nz\3z\3z\3{\3{\6{\u0d95\n{\r{\16{\u0d96\3"+
		"{\5{\u0d9a\n{\3{\3{\3|\3|\3|\3|\3|\3}\3}\3}\3}\3}\3~\3~\3~\3\177\3\177"+
		"\5\177\u0dad\n\177\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080"+
		"\3\u0081\3\u0081\3\u0082\3\u0082\3\u0083\3\u0083\3\u0083\3\u0083\5\u0083"+
		"\u0dbe\n\u0083\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\7\u0084\u0dc5\n"+
		"\u0084\f\u0084\16\u0084\u0dc8\13\u0084\3\u0084\3\u0084\3\u0085\3\u0085"+
		"\3\u0085\5\u0085\u0dcf\n\u0085\3\u0086\3\u0086\3\u0086\7\u0086\u0dd4\n"+
		"\u0086\f\u0086\16\u0086\u0dd7\13\u0086\3\u0087\3\u0087\3\u0087\7\u0087"+
		"\u0ddc\n\u0087\f\u0087\16\u0087\u0ddf\13\u0087\3\u0088\5\u0088\u0de2\n"+
		"\u0088\3\u0088\3\u0088\3\u0089\3\u0089\3\u0089\3\u0089\7\u0089\u0dea\n"+
		"\u0089\f\u0089\16\u0089\u0ded\13\u0089\3\u0089\3\u0089\3\u008a\3\u008a"+
		"\5\u008a\u0df3\n\u008a\3\u008b\3\u008b\3\u008b\7\u008b\u0df8\n\u008b\f"+
		"\u008b\16\u008b\u0dfb\13\u008b\3\u008c\3\u008c\3\u008d\3\u008d\3\u008e"+
		"\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008f\3\u008f\3\u008f"+
		"\5\u008f\u0e0b\n\u008f\3\u0090\3\u0090\3\u0091\3\u0091\5\u0091\u0e11\n"+
		"\u0091\3\u0092\3\u0092\3\u0093\3\u0093\3\u0093\7\u0093\u0e18\n\u0093\f"+
		"\u0093\16\u0093\u0e1b\13\u0093\3\u0094\3\u0094\3\u0095\3\u0095\5\u0095"+
		"\u0e21\n\u0095\3\u0096\3\u0096\3\u0097\3\u0097\3\u0097\3\u0097\3\u0097"+
		"\3\u0098\5\u0098\u0e2b\n\u0098\3\u0098\5\u0098\u0e2e\n\u0098\3\u0098\5"+
		"\u0098\u0e31\n\u0098\3\u0098\3\u0098\3\u0098\3\u0098\3\u0098\5\u0098\u0e38"+
		"\n\u0098\3\u0099\3\u0099\3\u009a\3\u009a\3\u009b\3\u009b\3\u009b\7\u009b"+
		"\u0e41\n\u009b\f\u009b\16\u009b\u0e44\13\u009b\3\u009c\3\u009c\3\u009c"+
		"\7\u009c\u0e49\n\u009c\f\u009c\16\u009c\u0e4c\13\u009c\3\u009d\3\u009d"+
		"\3\u009d\5\u009d\u0e51\n\u009d\3\u009e\3\u009e\5\u009e\u0e55\n\u009e\3"+
		"\u009f\3\u009f\5\u009f\u0e59\n\u009f\3\u009f\3\u009f\3\u00a0\3\u00a0\3"+
		"\u00a1\3\u00a1\5\u00a1\u0e61\n\u00a1\3\u00a2\3\u00a2\5\u00a2\u0e65\n\u00a2"+
		"\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a4\3\u00a4\5\u00a4\u0e6d\n\u00a4"+
		"\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3\u00a7\3\u00a7\5\u00a7\u0e75\n\u00a7"+
		"\3\u00a8\3\u00a8\5\u00a8\u0e79\n\u00a8\3\u00a9\3\u00a9\5\u00a9\u0e7d\n"+
		"\u00a9\3\u00a9\5\u00a9\u0e80\n\u00a9\3\u00a9\5\u00a9\u0e83\n\u00a9\3\u00a9"+
		"\5\u00a9\u0e86\n\u00a9\3\u00a9\5\u00a9\u0e89\n\u00a9\3\u00aa\3\u00aa\5"+
		"\u00aa\u0e8d\n\u00aa\3\u00aa\3\u00aa\5\u00aa\u0e91\n\u00aa\3\u00aa\5\u00aa"+
		"\u0e94\n\u00aa\3\u00aa\5\u00aa\u0e97\n\u00aa\3\u00ab\3\u00ab\3\u00ab\7"+
		"\u00ab\u0e9c\n\u00ab\f\u00ab\16\u00ab\u0e9f\13\u00ab\3\u00ac\3\u00ac\5"+
		"\u00ac\u0ea3\n\u00ac\3\u00ad\5\u00ad\u0ea6\n\u00ad\3\u00ad\3\u00ad\5\u00ad"+
		"\u0eaa\n\u00ad\3\u00ad\6\u00ad\u0ead\n\u00ad\r\u00ad\16\u00ad\u0eae\3"+
		"\u00ae\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u0eb5\n\u00ae\3\u00ae\3\u00ae\3"+
		"\u00ae\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u0ebd\n\u00ae\3\u00ae\3\u00ae\3"+
		"\u00ae\3\u00ae\3\u00ae\5\u00ae\u0ec4\n\u00ae\3\u00af\3\u00af\3\u00af\3"+
		"\u00af\3\u00b0\5\u00b0\u0ecb\n\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3"+
		"\u00b1\3\u00b1\5\u00b1\u0ed3\n\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b2\3"+
		"\u00b2\3\u00b2\3\u00b2\3\u00b3\3\u00b3\5\u00b3\u0ede\n\u00b3\3\u00b4\3"+
		"\u00b4\5\u00b4\u0ee2\n\u00b4\3\u00b5\3\u00b5\3\u00b6\3\u00b6\5\u00b6\u0ee8"+
		"\n\u00b6\3\u00b7\3\u00b7\3\u00b7\3\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8"+
		"\3\u00b9\3\u00b9\5\u00b9\u0ef4\n\u00b9\3\u00b9\5\u00b9\u0ef7\n\u00b9\3"+
		"\u00b9\5\u00b9\u0efa\n\u00b9\3\u00b9\3\u00b9\3\u00b9\3\u00b9\5\u00b9\u0f00"+
		"\n\u00b9\3\u00b9\3\u00b9\5\u00b9\u0f04\n\u00b9\3\u00b9\3\u00b9\3\u00b9"+
		"\3\u00b9\3\u00b9\5\u00b9\u0f0b\n\u00b9\5\u00b9\u0f0d\n\u00b9\3\u00ba\3"+
		"\u00ba\3\u00ba\7\u00ba\u0f12\n\u00ba\f\u00ba\16\u00ba\u0f15\13\u00ba\3"+
		"\u00bb\3\u00bb\5\u00bb\u0f19\n\u00bb\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3"+
		"\u00bc\7\u00bc\u0f20\n\u00bc\f\u00bc\16\u00bc\u0f23\13\u00bc\5\u00bc\u0f25"+
		"\n\u00bc\3\u00bc\3\u00bc\3\u00bd\3\u00bd\3\u00be\3\u00be\3\u00be\3\u00bf"+
		"\5\u00bf\u0f2f\n\u00bf\3\u00bf\3\u00bf\5\u00bf\u0f33\n\u00bf\3\u00c0\3"+
		"\u00c0\3\u00c0\3\u00c0\3\u00c1\3\u00c1\3\u00c1\7\u00c1\u0f3c\n\u00c1\f"+
		"\u00c1\16\u00c1\u0f3f\13\u00c1\3\u00c2\3\u00c2\3\u00c2\3\u00c2\5\u00c2"+
		"\u0f45\n\u00c2\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\5\u00c3\u0f4c\n"+
		"\u00c3\3\u00c4\3\u00c4\3\u00c4\7\u00c4\u0f51\n\u00c4\f\u00c4\16\u00c4"+
		"\u0f54\13\u00c4\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c6\3\u00c6"+
		"\3\u00c6\3\u00c6\3\u00c6\3\u00c7\3\u00c7\3\u00c7\3\u00c8\3\u00c8\3\u00c8"+
		"\3\u00c9\3\u00c9\3\u00c9\7\u00c9\u0f69\n\u00c9\f\u00c9\16\u00c9\u0f6c"+
		"\13\u00c9\3\u00ca\3\u00ca\3\u00cb\3\u00cb\5\u00cb\u0f72\n\u00cb\3\u00cc"+
		"\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u0f78\n\u00cc\3\u00cc\3\u00cc\5\u00cc"+
		"\u0f7c\n\u00cc\3\u00cc\3\u00cc\5\u00cc\u0f80\n\u00cc\3\u00cc\7\u00cc\u0f83"+
		"\n\u00cc\f\u00cc\16\u00cc\u0f86\13\u00cc\3\u00cd\3\u00cd\5\u00cd\u0f8a"+
		"\n\u00cd\3\u00ce\3\u00ce\3\u00ce\3\u00ce\5\u00ce\u0f90\n\u00ce\3\u00ce"+
		"\3\u00ce\5\u00ce\u0f94\n\u00ce\3\u00ce\3\u00ce\5\u00ce\u0f98\n\u00ce\3"+
		"\u00ce\7\u00ce\u0f9b\n\u00ce\f\u00ce\16\u00ce\u0f9e\13\u00ce\3\u00cf\3"+
		"\u00cf\5\u00cf\u0fa2\n\u00cf\3\u00d0\3\u00d0\3\u00d0\3\u00d0\3\u00d0\5"+
		"\u00d0\u0fa9\n\u00d0\3\u00d1\3\u00d1\5\u00d1\u0fad\n\u00d1\3\u00d2\3\u00d2"+
		"\3\u00d2\3\u00d3\3\u00d3\5\u00d3\u0fb4\n\u00d3\3\u00d4\3\u00d4\3\u00d4"+
		"\3\u00d4\3\u00d4\5\u00d4\u0fbb\n\u00d4\5\u00d4\u0fbd\n\u00d4\3\u00d5\3"+
		"\u00d5\5\u00d5\u0fc1\n\u00d5\3\u00d5\3\u00d5\5\u00d5\u0fc5\n\u00d5\3\u00d6"+
		"\3\u00d6\3\u00d6\7\u00d6\u0fca\n\u00d6\f\u00d6\16\u00d6\u0fcd\13\u00d6"+
		"\3\u00d7\3\u00d7\5\u00d7\u0fd1\n\u00d7\3\u00d8\3\u00d8\3\u00d8\7\u00d8"+
		"\u0fd6\n\u00d8\f\u00d8\16\u00d8\u0fd9\13\u00d8\3\u00d9\3\u00d9\5\u00d9"+
		"\u0fdd\n\u00d9\3\u00d9\3\u00d9\3\u00da\3\u00da\3\u00db\3\u00db\3\u00db"+
		"\5\u00db\u0fe6\n\u00db\3\u00db\3\u00db\3\u00dc\5\u00dc\u0feb\n\u00dc\3"+
		"\u00dc\3\u00dc\3\u00dd\3\u00dd\3\u00dd\3\u00dd\3\u00dd\7\u00dd\u0ff4\n"+
		"\u00dd\f\u00dd\16\u00dd\u0ff7\13\u00dd\3\u00dd\3\u00dd\3\u00de\3\u00de"+
		"\3\u00de\7\u00de\u0ffe\n\u00de\f\u00de\16\u00de\u1001\13\u00de\3\u00df"+
		"\3\u00df\3\u00e0\3\u00e0\3\u00e1\3\u00e1\3\u00e2\3\u00e2\3\u00e2\3\u00e2"+
		"\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e3\5\u00e3\u1013\n\u00e3"+
		"\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e5\3\u00e5\3\u00e6\3\u00e6\3\u00e6"+
		"\3\u00e7\5\u00e7\u101f\n\u00e7\3\u00e7\3\u00e7\5\u00e7\u1023\n\u00e7\3"+
		"\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e8\3\u00e8\5\u00e8\u102b\n\u00e8\3"+
		"\u00e8\3\u00e8\3\u00e8\3\u00e9\3\u00e9\3\u00e9\3\u00e9\3\u00e9\5\u00e9"+
		"\u1035\n\u00e9\3\u00ea\3\u00ea\3\u00ea\7\u00ea\u103a\n\u00ea\f\u00ea\16"+
		"\u00ea\u103d\13\u00ea\3\u00eb\3\u00eb\3\u00eb\3\u00eb\3\u00ec\5\u00ec"+
		"\u1044\n\u00ec\3\u00ec\3\u00ec\5\u00ec\u1048\n\u00ec\3\u00ed\3\u00ed\3"+
		"\u00ed\3\u00ed\3\u00ed\3\u00ed\5\u00ed\u1050\n\u00ed\3\u00ee\3\u00ee\3"+
		"\u00ef\3\u00ef\3\u00ef\5\u00ef\u1057\n\u00ef\3\u00ef\3\u00ef\3\u00f0\3"+
		"\u00f0\3\u00f0\3\u00f0\3\u00f0\3\u00f1\3\u00f1\5\u00f1\u1062\n\u00f1\3"+
		"\u00f2\3\u00f2\3\u00f3\3\u00f3\3\u00f4\5\u00f4\u1069\n\u00f4\3\u00f4\3"+
		"\u00f4\3\u00f4\3\u00f5\3\u00f5\3\u00f5\3\u00f6\3\u00f6\5\u00f6\u1073\n"+
		"\u00f6\3\u00f7\3\u00f7\3\u00f8\3\u00f8\3\u00f9\3\u00f9\3\u00f9\3\u00f9"+
		"\3\u00fa\3\u00fa\3\u00fa\3\u00fa\6\u00fa\u1081\n\u00fa\r\u00fa\16\u00fa"+
		"\u1082\3\u00fa\5\u00fa\u1086\n\u00fa\3\u00fb\3\u00fb\3\u00fb\7\u00fb\u108b"+
		"\n\u00fb\f\u00fb\16\u00fb\u108e\13\u00fb\3\u00fc\3\u00fc\5\u00fc\u1092"+
		"\n\u00fc\3\u00fc\5\u00fc\u1095\n\u00fc\3\u00fd\3\u00fd\3\u00fe\3\u00fe"+
		"\3\u00fe\3\u00ff\3\u00ff\3\u00ff\3\u00ff\5\u00ff\u10a0\n\u00ff\3\u00ff"+
		"\2\2\u0100\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
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
		"\u01f4\u01f6\u01f8\u01fa\u01fc\2-\4\2\21\21ee\4\2\u00a9\u00a9\u00ad\u00ad"+
		"\4\2\u008a\u008a\u00f3\u00f3\4\2SS\u0095\u0095\3\2\u00dd\u00de\4\2``\u0114"+
		"\u0114\t\2  ccmmzz||\177\177\u00c2\u00c2\4\2mm\177\u0080\4\2NNnn\4\2\u010f"+
		"\u010f\u0150\u0150\6\2ccmm\177\177\u00c2\u00c2\5\2\25\25\31\31uv\4\2\31"+
		"\31\u0080\u0080\4\2mm\177\177\7\2;;rr\u00ff\u00ff\u011c\u011c\u011e\u011e"+
		"\4\2\34\34\u0150\u0150\4\2\u00c4\u00c4\u00c7\u00c7\6\2<<DDUU\u0083\u0083"+
		"\3\2uv\4\2\63\63NN\4\2))==\b\2\7\7\27\27\35\35\u009a\u009a\u00bf\u00bf"+
		"\u0102\u0102\t\2\u0089\u00bb\u00bd\u00be\u00c0\u00dc\u00df\u0107\u0109"+
		"\u0131\u0133\u0141\u0143\u0149\3\2\u0122\u0123\3\2\u0087\u0088\3\2\u0169"+
		"\u016a\17\2\n\npp\u008c\u008c\u0096\u0096\u009f\u009f\u00b0\u00b0\u00b9"+
		"\u00b9\u00c3\u00c3\u00d0\u00d0\u00d5\u00d5\u0103\u0104\u0106\u0106\u0118"+
		"\u0119\3\2\u015c\u015d\3\2\u015e\u0160\3\2\u010b\u010d\5\2\17\17JJxx\5"+
		"\2,,{{\u0112\u0112\5\2//KKhh\4\2\'\'}}\4\2\7\7\"\"\4\2\u0150\u0150\u0155"+
		"\u0159\4\2\13\13ss\3\2\u014a\u014d\4\2\n\npp\6\2\u00a4\u00a4\u00bc\u00bc"+
		"\u00d7\u00d8\u0120\u0120\n\2\u0092\u0092\u00a6\u00a6\u00aa\u00ab\u00ae"+
		"\u00ae\u00c5\u00c6\u00d2\u00d4\u00ee\u00ee\u011d\u011d\3\2\u015a\u015b"+
		"\4\2\f\f!!\u12c9\2\u0203\3\2\2\2\4\u0208\3\2\2\2\6\u020d\3\2\2\2\b\u021d"+
		"\3\2\2\2\n\u0225\3\2\2\2\f\u0247\3\2\2\2\16\u0257\3\2\2\2\20\u026d\3\2"+
		"\2\2\22\u02a1\3\2\2\2\24\u0365\3\2\2\2\26\u0367\3\2\2\2\30\u0380\3\2\2"+
		"\2\32\u0382\3\2\2\2\34\u03b1\3\2\2\2\36\u03b3\3\2\2\2 \u0458\3\2\2\2\""+
		"\u048f\3\2\2\2$\u0491\3\2\2\2&\u04ae\3\2\2\2(\u04e6\3\2\2\2*\u04e8\3\2"+
		"\2\2,\u052c\3\2\2\2.\u0534\3\2\2\2\60\u0536\3\2\2\2\62\u0705\3\2\2\2\64"+
		"\u0707\3\2\2\2\66\u086b\3\2\2\28\u086d\3\2\2\2:\u0887\3\2\2\2<\u0905\3"+
		"\2\2\2>\u0963\3\2\2\2@\u0966\3\2\2\2B\u097a\3\2\2\2D\u097d\3\2\2\2F\u0986"+
		"\3\2\2\2H\u0990\3\2\2\2J\u0992\3\2\2\2L\u0994\3\2\2\2N\u0997\3\2\2\2P"+
		"\u09a5\3\2\2\2R\u09b1\3\2\2\2T\u09df\3\2\2\2V\u0a09\3\2\2\2X\u0a0b\3\2"+
		"\2\2Z\u0a93\3\2\2\2\\\u0a9f\3\2\2\2^\u0aa1\3\2\2\2`\u0ab0\3\2\2\2b\u0ab5"+
		"\3\2\2\2d\u0b29\3\2\2\2f\u0b5b\3\2\2\2h\u0b67\3\2\2\2j\u0b76\3\2\2\2l"+
		"\u0b7e\3\2\2\2n\u0b89\3\2\2\2p\u0b8d\3\2\2\2r\u0b95\3\2\2\2t\u0b98\3\2"+
		"\2\2v\u0ba0\3\2\2\2x\u0bab\3\2\2\2z\u0bae\3\2\2\2|\u0bb0\3\2\2\2~\u0bbc"+
		"\3\2\2\2\u0080\u0bc0\3\2\2\2\u0082\u0bc3\3\2\2\2\u0084\u0bc6\3\2\2\2\u0086"+
		"\u0bcc\3\2\2\2\u0088\u0bce\3\2\2\2\u008a\u0bd8\3\2\2\2\u008c\u0be0\3\2"+
		"\2\2\u008e\u0bf2\3\2\2\2\u0090\u0bff\3\2\2\2\u0092\u0c07\3\2\2\2\u0094"+
		"\u0c0a\3\2\2\2\u0096\u0c0d\3\2\2\2\u0098\u0c17\3\2\2\2\u009a\u0c1f\3\2"+
		"\2\2\u009c\u0c29\3\2\2\2\u009e\u0c2e\3\2\2\2\u00a0\u0c38\3\2\2\2\u00a2"+
		"\u0c3a\3\2\2\2\u00a4\u0c49\3\2\2\2\u00a6\u0c4b\3\2\2\2\u00a8\u0c4f\3\2"+
		"\2\2\u00aa\u0c54\3\2\2\2\u00ac\u0c59\3\2\2\2\u00ae\u0c5b\3\2\2\2\u00b0"+
		"\u0c5e\3\2\2\2\u00b2\u0c61\3\2\2\2\u00b4\u0c6b\3\2\2\2\u00b6\u0c7c\3\2"+
		"\2\2\u00b8\u0c7e\3\2\2\2\u00ba\u0c80\3\2\2\2\u00bc\u0c9a\3\2\2\2\u00be"+
		"\u0c9c\3\2\2\2\u00c0\u0cc3\3\2\2\2\u00c2\u0ccd\3\2\2\2\u00c4\u0cd1\3\2"+
		"\2\2\u00c6\u0ce8\3\2\2\2\u00c8\u0cf4\3\2\2\2\u00ca\u0cfe\3\2\2\2\u00cc"+
		"\u0d00\3\2\2\2\u00ce\u0d11\3\2\2\2\u00d0\u0d20\3\2\2\2\u00d2\u0d2f\3\2"+
		"\2\2\u00d4\u0d33\3\2\2\2\u00d6\u0d35\3\2\2\2\u00d8\u0d41\3\2\2\2\u00da"+
		"\u0d43\3\2\2\2\u00dc\u0d45\3\2\2\2\u00de\u0d48\3\2\2\2\u00e0\u0d4c\3\2"+
		"\2\2\u00e2\u0d56\3\2\2\2\u00e4\u0d58\3\2\2\2\u00e6\u0d60\3\2\2\2\u00e8"+
		"\u0d62\3\2\2\2\u00ea\u0d67\3\2\2\2\u00ec\u0d6c\3\2\2\2\u00ee\u0d80\3\2"+
		"\2\2\u00f0\u0d84\3\2\2\2\u00f2\u0d86\3\2\2\2\u00f4\u0d92\3\2\2\2\u00f6"+
		"\u0d9d\3\2\2\2\u00f8\u0da2\3\2\2\2\u00fa\u0da7\3\2\2\2\u00fc\u0dac\3\2"+
		"\2\2\u00fe\u0dae\3\2\2\2\u0100\u0db5\3\2\2\2\u0102\u0db7\3\2\2\2\u0104"+
		"\u0dbd\3\2\2\2\u0106\u0dbf\3\2\2\2\u0108\u0dce\3\2\2\2\u010a\u0dd0\3\2"+
		"\2\2\u010c\u0dd8\3\2\2\2\u010e\u0de1\3\2\2\2\u0110\u0de5\3\2\2\2\u0112"+
		"\u0df2\3\2\2\2\u0114\u0df4\3\2\2\2\u0116\u0dfc\3\2\2\2\u0118\u0dfe\3\2"+
		"\2\2\u011a\u0e00\3\2\2\2\u011c\u0e0a\3\2\2\2\u011e\u0e0c\3\2\2\2\u0120"+
		"\u0e10\3\2\2\2\u0122\u0e12\3\2\2\2\u0124\u0e14\3\2\2\2\u0126\u0e1c\3\2"+
		"\2\2\u0128\u0e20\3\2\2\2\u012a\u0e22\3\2\2\2\u012c\u0e24\3\2\2\2\u012e"+
		"\u0e37\3\2\2\2\u0130\u0e39\3\2\2\2\u0132\u0e3b\3\2\2\2\u0134\u0e3d\3\2"+
		"\2\2\u0136\u0e45\3\2\2\2\u0138\u0e50\3\2\2\2\u013a\u0e52\3\2\2\2\u013c"+
		"\u0e56\3\2\2\2\u013e\u0e5c\3\2\2\2\u0140\u0e60\3\2\2\2\u0142\u0e64\3\2"+
		"\2\2\u0144\u0e66\3\2\2\2\u0146\u0e6c\3\2\2\2\u0148\u0e6e\3\2\2\2\u014a"+
		"\u0e70\3\2\2\2\u014c\u0e74\3\2\2\2\u014e\u0e78\3\2\2\2\u0150\u0e7a\3\2"+
		"\2\2\u0152\u0e8a\3\2\2\2\u0154\u0e98\3\2\2\2\u0156\u0ea2\3\2\2\2\u0158"+
		"\u0ea5\3\2\2\2\u015a\u0ec3\3\2\2\2\u015c\u0ec5\3\2\2\2\u015e\u0eca\3\2"+
		"\2\2\u0160\u0ed0\3\2\2\2\u0162\u0ed7\3\2\2\2\u0164\u0edd\3\2\2\2\u0166"+
		"\u0edf\3\2\2\2\u0168\u0ee3\3\2\2\2\u016a\u0ee7\3\2\2\2\u016c\u0ee9\3\2"+
		"\2\2\u016e\u0eec\3\2\2\2\u0170\u0f0c\3\2\2\2\u0172\u0f0e\3\2\2\2\u0174"+
		"\u0f18\3\2\2\2\u0176\u0f1a\3\2\2\2\u0178\u0f28\3\2\2\2\u017a\u0f2a\3\2"+
		"\2\2\u017c\u0f2e\3\2\2\2\u017e\u0f34\3\2\2\2\u0180\u0f38\3\2\2\2\u0182"+
		"\u0f44\3\2\2\2\u0184\u0f4b\3\2\2\2\u0186\u0f4d\3\2\2\2\u0188\u0f55\3\2"+
		"\2\2\u018a\u0f5a\3\2\2\2\u018c\u0f5f\3\2\2\2\u018e\u0f62\3\2\2\2\u0190"+
		"\u0f65\3\2\2\2\u0192\u0f6d\3\2\2\2\u0194\u0f71\3\2\2\2\u0196\u0f7b\3\2"+
		"\2\2\u0198\u0f89\3\2\2\2\u019a\u0f93\3\2\2\2\u019c\u0fa1\3\2\2\2\u019e"+
		"\u0fa8\3\2\2\2\u01a0\u0fac\3\2\2\2\u01a2\u0fae\3\2\2\2\u01a4\u0fb3\3\2"+
		"\2\2\u01a6\u0fb5\3\2\2\2\u01a8\u0fbe\3\2\2\2\u01aa\u0fc6\3\2\2\2\u01ac"+
		"\u0fd0\3\2\2\2\u01ae\u0fd2\3\2\2\2\u01b0\u0fdc\3\2\2\2\u01b2\u0fe0\3\2"+
		"\2\2\u01b4\u0fe5\3\2\2\2\u01b6\u0fea\3\2\2\2\u01b8\u0fee\3\2\2\2\u01ba"+
		"\u0ffa\3\2\2\2\u01bc\u1002\3\2\2\2\u01be\u1004\3\2\2\2\u01c0\u1006\3\2"+
		"\2\2\u01c2\u1008\3\2\2\2\u01c4\u1012\3\2\2\2\u01c6\u1014\3\2\2\2\u01c8"+
		"\u1018\3\2\2\2\u01ca\u101a\3\2\2\2\u01cc\u101e\3\2\2\2\u01ce\u1028\3\2"+
		"\2\2\u01d0\u1034\3\2\2\2\u01d2\u1036\3\2\2\2\u01d4\u103e\3\2\2\2\u01d6"+
		"\u1047\3\2\2\2\u01d8\u104f\3\2\2\2\u01da\u1051\3\2\2\2\u01dc\u1053\3\2"+
		"\2\2\u01de\u105a\3\2\2\2\u01e0\u1061\3\2\2\2\u01e2\u1063\3\2\2\2\u01e4"+
		"\u1065\3\2\2\2\u01e6\u1068\3\2\2\2\u01e8\u106d\3\2\2\2\u01ea\u1072\3\2"+
		"\2\2\u01ec\u1074\3\2\2\2\u01ee\u1076\3\2\2\2\u01f0\u1078\3\2\2\2\u01f2"+
		"\u1085\3\2\2\2\u01f4\u1087\3\2\2\2\u01f6\u108f\3\2\2\2\u01f8\u1096\3\2"+
		"\2\2\u01fa\u1098\3\2\2\2\u01fc\u109f\3\2\2\2\u01fe\u01ff\5\4\3\2\u01ff"+
		"\u0200\7\u0152\2\2\u0200\u0202\3\2\2\2\u0201\u01fe\3\2\2\2\u0202\u0205"+
		"\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0206\3\2\2\2\u0205"+
		"\u0203\3\2\2\2\u0206\u0207\7\2\2\3\u0207\3\3\2\2\2\u0208\u0209\5\6\4\2"+
		"\u0209\5\3\2\2\2\u020a\u020e\5\b\5\2\u020b\u020e\5\n\6\2\u020c\u020e\5"+
		"\u00a2R\2\u020d\u020a\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020c\3\2\2\2"+
		"\u020e\7\3\2\2\2\u020f\u021e\5Z.\2\u0210\u021e\5$\23\2\u0211\u021e\5&"+
		"\24\2\u0212\u021e\5\60\31\2\u0213\u021e\5<\37\2\u0214\u021e\5R*\2\u0215"+
		"\u021e\5V,\2\u0216\u021e\5X-\2\u0217\u021e\5:\36\2\u0218\u021e\5\62\32"+
		"\2\u0219\u021e\5,\27\2\u021a\u021e\5\66\34\2\u021b\u021e\5(\25\2\u021c"+
		"\u021e\5*\26\2\u021d\u020f\3\2\2\2\u021d\u0210\3\2\2\2\u021d\u0211\3\2"+
		"\2\2\u021d\u0212\3\2\2\2\u021d\u0213\3\2\2\2\u021d\u0214\3\2\2\2\u021d"+
		"\u0215\3\2\2\2\u021d\u0216\3\2\2\2\u021d\u0217\3\2\2\2\u021d\u0218\3\2"+
		"\2\2\u021d\u0219\3\2\2\2\u021d\u021a\3\2\2\2\u021d\u021b\3\2\2\2\u021d"+
		"\u021c\3\2\2\2\u021e\t\3\2\2\2\u021f\u0226\5\f\7\2\u0220\u0226\5\16\b"+
		"\2\u0221\u0226\5\20\t\2\u0222\u0226\5\22\n\2\u0223\u0226\5\36\20\2\u0224"+
		"\u0226\5\"\22\2\u0225\u021f\3\2\2\2\u0225\u0220\3\2\2\2\u0225\u0221\3"+
		"\2\2\2\u0225\u0222\3\2\2\2\u0225\u0223\3\2\2\2\u0225\u0224\3\2\2\2\u0226"+
		"\13\3\2\2\2\u0227\u0228\7\b\2\2\u0228\u0229\7\60\2\2\u0229\u022b\5@!\2"+
		"\u022a\u022c\5\34\17\2\u022b\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022b"+
		"\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0230\3\2\2\2\u022f\u0231\7e\2\2\u0230"+
		"\u022f\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0248\3\2\2\2\u0232\u0233\7\b"+
		"\2\2\u0233\u0234\7\60\2\2\u0234\u0235\5@!\2\u0235\u0236\7\u00f2\2\2\u0236"+
		"\u0237\7\u010f\2\2\u0237\u0238\5\u01a6\u00d4\2\u0238\u0248\3\2\2\2\u0239"+
		"\u023a\7\b\2\2\u023a\u023b\7\60\2\2\u023b\u023c\5@!\2\u023c\u023d\7Z\2"+
		"\2\u023d\u023e\7\u010f\2\2\u023e\u023f\5\u00a4S\2\u023f\u0248\3\2\2\2"+
		"\u0240\u0241\7\b\2\2\u0241\u0242\7\60\2\2\u0242\u0243\5@!\2\u0243\u0244"+
		"\7\u00fc\2\2\u0244\u0245\7j\2\2\u0245\u0246\5\u01a6\u00d4\2\u0246\u0248"+
		"\3\2\2\2\u0247\u0227\3\2\2\2\u0247\u0232\3\2\2\2\u0247\u0239\3\2\2\2\u0247"+
		"\u0240\3\2\2\2\u0248\r\3\2\2\2\u0249\u024a\7\b\2\2\u024a\u024b\7j\2\2"+
		"\u024b\u024c\5\u00a4S\2\u024c\u024d\7\u00f2\2\2\u024d\u024e\7\u010f\2"+
		"\2\u024e\u024f\5\u00a4S\2\u024f\u0258\3\2\2\2\u0250\u0251\7\b\2\2\u0251"+
		"\u0252\7j\2\2\u0252\u0253\5\u00a4S\2\u0253\u0254\7Z\2\2\u0254\u0255\7"+
		"\u010f\2\2\u0255\u0256\5\u00a4S\2\u0256\u0258\3\2\2\2\u0257\u0249\3\2"+
		"\2\2\u0257\u0250\3\2\2\2\u0258\17\3\2\2\2\u0259\u025b\7\b\2\2\u025a\u025c"+
		"\7_\2\2\u025b\u025a\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025d\3\2\2\2\u025d"+
		"\u025e\7\u00c8\2\2\u025e\u025f\5\u00a4S\2\u025f\u0260\7\u00f2\2\2\u0260"+
		"\u0261\7\u010f\2\2\u0261\u0262\5\u00a4S\2\u0262\u026e\3\2\2\2\u0263\u0265"+
		"\7\b\2\2\u0264\u0266\7_\2\2\u0265\u0264\3\2\2\2\u0265\u0266\3\2\2\2\u0266"+
		"\u0267\3\2\2\2\u0267\u0268\7\u00c8\2\2\u0268\u0269\5\u00a4S\2\u0269\u026a"+
		"\7Z\2\2\u026a\u026b\7\u010f\2\2\u026b\u026c\5\u00a4S\2\u026c\u026e\3\2"+
		"\2\2\u026d\u0259\3\2\2\2\u026d\u0263\3\2\2\2\u026e\21\3\2\2\2\u026f\u0270"+
		"\7\b\2\2\u0270\u0272\7t\2\2\u0271\u0273\7\u00e1\2\2\u0272\u0271\3\2\2"+
		"\2\u0272\u0273\3\2\2\2\u0273\u0275\3\2\2\2\u0274\u0276\5\u01a6\u00d4\2"+
		"\u0275\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0278"+
		"\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027e\5\24\13\2\u027a\u027b\7\u0153"+
		"\2\2\u027b\u027d\5\24\13\2\u027c\u027a\3\2\2\2\u027d\u0280\3\2\2\2\u027e"+
		"\u027c\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u02a2\3\2\2\2\u0280\u027e\3\2"+
		"\2\2\u0281\u0282\7\b\2\2\u0282\u0284\7t\2\2\u0283\u0285\7\u00e1\2\2\u0284"+
		"\u0283\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0287\3\2\2\2\u0286\u0288\5\u01a6"+
		"\u00d4\2\u0287\u0286\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u0287\3\2\2\2\u0289"+
		"\u028a\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028d\7\u00f2\2\2\u028c\u028e"+
		"\7\u0098\2\2\u028d\u028c\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u028f\3\2\2"+
		"\2\u028f\u0290\5\u01a6\u00d4\2\u0290\u0291\7\u010f\2\2\u0291\u0292\5\u01a6"+
		"\u00d4\2\u0292\u02a2\3\2\2\2\u0293\u0294\7\b\2\2\u0294\u0295\7t\2\2\u0295"+
		"\u0296\5\u01a6\u00d4\2\u0296\u0297\7\u00f2\2\2\u0297\u0298\7\u010f\2\2"+
		"\u0298\u0299\5\u01a6\u00d4\2\u0299\u02a2\3\2\2\2\u029a\u029b\7\b\2\2\u029b"+
		"\u029c\7t\2\2\u029c\u029d\5\u01a6\u00d4\2\u029d\u029e\7\u00fc\2\2\u029e"+
		"\u029f\7j\2\2\u029f\u02a0\5\u01a6\u00d4\2\u02a0\u02a2\3\2\2\2\u02a1\u026f"+
		"\3\2\2\2\u02a1\u0281\3\2\2\2\u02a1\u0293\3\2\2\2\u02a1\u029a\3\2\2\2\u02a2"+
		"\23\3\2\2\2\u02a3\u02a5\7\3\2\2\u02a4\u02a6\7\u0098\2\2\u02a5\u02a4\3"+
		"\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u0366\5^\60\2\u02a8"+
		"\u02aa\7\u00ac\2\2\u02a9\u02ab\7\u0098\2\2\u02aa\u02a9\3\2\2\2\u02aa\u02ab"+
		"\3\2\2\2\u02ab\u02ae\3\2\2\2\u02ac\u02ad\78\2\2\u02ad\u02af\7\u00b1\2"+
		"\2\u02ae\u02ac\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b2"+
		"\5\u01a6\u00d4\2\u02b1\u02b3\t\2\2\2\u02b2\u02b1\3\2\2\2\u02b2\u02b3\3"+
		"\2\2\2\u02b3\u0366\3\2\2\2\u02b4\u02b6\7\b\2\2\u02b5\u02b7\7\u0098\2\2"+
		"\u02b6\u02b5\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02bb"+
		"\5\u01a6\u00d4\2\u02b9\u02ba\7\u00fc\2\2\u02ba\u02bc\7\u00a3\2\2\u02bb"+
		"\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02be\7\u0110"+
		"\2\2\u02be\u02c1\5\u00b4[\2\u02bf\u02c0\7\23\2\2\u02c0\u02c2\5\u00a4S"+
		"\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c5\3\2\2\2\u02c3\u02c4"+
		"\7\u0081\2\2\u02c4\u02c6\5\u0104\u0083\2\u02c5\u02c3\3\2\2\2\u02c5\u02c6"+
		"\3\2\2\2\u02c6\u0366\3\2\2\2\u02c7\u02c9\7\b\2\2\u02c8\u02ca\7\u0098\2"+
		"\2\u02c9\u02c8\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cc"+
		"\5\u01a6\u00d4\2\u02cc\u02cd\7\u00fc\2\2\u02cd\u02ce\7\34\2\2\u02ce\u02cf"+
		"\5\u0104\u0083\2\u02cf\u0366\3\2\2\2\u02d0\u02d2\7\b\2\2\u02d1\u02d3\7"+
		"\u0098\2\2\u02d2\u02d1\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d4\3\2\2\2"+
		"\u02d4\u02d5\5\u01a6\u00d4\2\u02d5\u02d6\7\u00ac\2\2\u02d6\u02d7\7\34"+
		"\2\2\u02d7\u0366\3\2\2\2\u02d8\u02da\7\b\2\2\u02d9\u02db\7\u0098\2\2\u02da"+
		"\u02d9\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02dd\5\u01a6"+
		"\u00d4\2\u02dd\u02de\7\u00fc\2\2\u02de\u0366\3\2\2\2\u02df\u02e0\7\u00ac"+
		"\2\2\u02e0\u02e1\7P\2\2\u02e1\u0366\7Q\2\2\u02e2\u02e4\7\b\2\2\u02e3\u02e5"+
		"\7\u0098\2\2\u02e4\u02e3\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5\u02e6\3\2\2"+
		"\2\u02e6\u02e7\5\u01a6\u00d4\2\u02e7\u02e8\7\u00fc\2\2\u02e8\u02e9\7\u0101"+
		"\2\2\u02e9\u02ea\7\u0169\2\2\u02ea\u0366\3\2\2\2\u02eb\u02ed\7\b\2\2\u02ec"+
		"\u02ee\7\u0098\2\2\u02ed\u02ec\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02ef"+
		"\3\2\2\2\u02ef\u02f0\5\u01a6\u00d4\2\u02f0\u02f1\7\u00fc\2\2\u02f1\u02f2"+
		"\7\u015a\2\2\u02f2\u02f7\5\26\f\2\u02f3\u02f4\7\u0153\2\2\u02f4\u02f6"+
		"\5\26\f\2\u02f5\u02f3\3\2\2\2\u02f6\u02f9\3\2\2\2\u02f7\u02f5\3\2\2\2"+
		"\u02f7\u02f8\3\2\2\2\u02f8\u02fa\3\2\2\2\u02f9\u02f7\3\2\2\2\u02fa\u02fb"+
		"\7\u015b\2\2\u02fb\u0366\3\2\2\2\u02fc\u02fe\7\b\2\2\u02fd\u02ff\7\u0098"+
		"\2\2\u02fe\u02fd\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0300\3\2\2\2\u0300"+
		"\u0301\5\u01a6\u00d4\2\u0301\u0302\7\u00f4\2\2\u0302\u0303\7\u015a\2\2"+
		"\u0303\u0308\5\32\16\2\u0304\u0305\7\u0153\2\2\u0305\u0307\5\32\16\2\u0306"+
		"\u0304\3\2\2\2\u0307\u030a\3\2\2\2\u0308\u0306\3\2\2\2\u0308\u0309\3\2"+
		"\2\2\u0309\u030b\3\2\2\2\u030a\u0308\3\2\2\2\u030b\u030c\7\u015b\2\2\u030c"+
		"\u0366\3\2\2\2\u030d\u030f\7\b\2\2\u030e\u0310\7\u0098\2\2\u030f\u030e"+
		"\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0312\5\u01a6\u00d4"+
		"\2\u0312\u0313\7\u00fc\2\2\u0313\u0314\7\u0102\2\2\u0314\u0315\7\u00ea"+
		"\2\2\u0315\u0366\3\2\2\2\u0316\u0366\7\u00b3\2\2\u0317\u0366\7\u00b2\2"+
		"\2\u0318\u0366\7\u00ce\2\2\u0319\u031a\7\3\2\2\u031a\u031d\5b\62\2\u031b"+
		"\u031c\7P\2\2\u031c\u031e\7\u0115\2\2\u031d\u031b\3\2\2\2\u031d\u031e"+
		"\3\2\2\2\u031e\u0366\3\2\2\2\u031f\u0320\7\3\2\2\u0320\u0366\5\30\r\2"+
		"\u0321\u0322\7\u0116\2\2\u0322\u0323\7\26\2\2\u0323\u0366\5\u01a6\u00d4"+
		"\2\u0324\u0325\7\u00ac\2\2\u0325\u0328\7\26\2\2\u0326\u0327\78\2\2\u0327"+
		"\u0329\7\u00b1\2\2\u0328\u0326\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032a"+
		"\3\2\2\2\u032a\u032b\5\u01a6\u00d4\2\u032b\u032c\t\2\2\2\u032c\u0366\3"+
		"\2\2\2\u032d\u032e\t\3\2\2\u032e\u0332\7z\2\2\u032f\u0333\5\u01a6\u00d4"+
		"\2\u0330\u0333\7\7\2\2\u0331\u0333\7\u0114\2\2\u0332\u032f\3\2\2\2\u0332"+
		"\u0330\3\2\2\2\u0332\u0331\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0366\3\2"+
		"\2\2\u0334\u0335\7\u00ad\2\2\u0335\u0336\t\4\2\2\u0336\u0337\7z\2\2\u0337"+
		"\u0366\5\u01a6\u00d4\2\u0338\u0339\t\3\2\2\u0339\u033a\7i\2\2\u033a\u0366"+
		"\5\u01a6\u00d4\2\u033b\u033c\7\u00ad\2\2\u033c\u033d\t\4\2\2\u033d\u033e"+
		"\7i\2\2\u033e\u0366\5\u01a6\u00d4\2\u033f\u0340\7\u0095\2\2\u0340\u0341"+
		"\7\u00e0\2\2\u0341\u0366\5\u01a6\u00d4\2\u0342\u0343\7\u00fc\2\2\u0343"+
		"\u0344\7\u0088\2\2\u0344\u0366\t\5\2\2\u0345\u0346\7\u00fc\2\2\u0346\u0347"+
		"\7\u0087\2\2\u0347\u0366\7S\2\2\u0348\u0349\7\u00fc\2\2\u0349\u0366\5"+
		"h\65\2\u034a\u034b\7\u00f4\2\2\u034b\u034c\7\u015a\2\2\u034c\u0351\5j"+
		"\66\2\u034d\u034e\7\u0153\2\2\u034e\u0350\5j\66\2\u034f\u034d\3\2\2\2"+
		"\u0350\u0353\3\2\2\2\u0351\u034f\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0354"+
		"\3\2\2\2\u0353\u0351\3\2\2\2\u0354\u0355\7\u015b\2\2\u0355\u0366\3\2\2"+
		"\2\u0356\u0357\7\u00bd\2\2\u0357\u0366\5\u01a6\u00d4\2\u0358\u0359\7\u00da"+
		"\2\2\u0359\u035a\7\u00bd\2\2\u035a\u0366\5\u01a6\u00d4\2\u035b\u035c\7"+
		"R\2\2\u035c\u0366\5\u01a6\u00d4\2\u035d\u035e\7P\2\2\u035e\u0366\7R\2"+
		"\2\u035f\u0360\7Z\2\2\u0360\u0361\7\u010f\2\2\u0361\u0366\5\u01a6\u00d4"+
		"\2\u0362\u0363\7\u00fc\2\2\u0363\u0364\7\u0107\2\2\u0364\u0366\5\u01a6"+
		"\u00d4\2\u0365\u02a3\3\2\2\2\u0365\u02a8\3\2\2\2\u0365\u02b4\3\2\2\2\u0365"+
		"\u02c7\3\2\2\2\u0365\u02d0\3\2\2\2\u0365\u02d8\3\2\2\2\u0365\u02df\3\2"+
		"\2\2\u0365\u02e2\3\2\2\2\u0365\u02eb\3\2\2\2\u0365\u02fc\3\2\2\2\u0365"+
		"\u030d\3\2\2\2\u0365\u0316\3\2\2\2\u0365\u0317\3\2\2\2\u0365\u0318\3\2"+
		"\2\2\u0365\u0319\3\2\2\2\u0365\u031f\3\2\2\2\u0365\u0321\3\2\2\2\u0365"+
		"\u0324\3\2\2\2\u0365\u032d\3\2\2\2\u0365\u0334\3\2\2\2\u0365\u0338\3\2"+
		"\2\2\u0365\u033b\3\2\2\2\u0365\u033f\3\2\2\2\u0365\u0342\3\2\2\2\u0365"+
		"\u0345\3\2\2\2\u0365\u0348\3\2\2\2\u0365\u034a\3\2\2\2\u0365\u0356\3\2"+
		"\2\2\u0365\u0358\3\2\2\2\u0365\u035b\3\2\2\2\u0365\u035d\3\2\2\2\u0365"+
		"\u035f\3\2\2\2\u0365\u0362\3\2\2\2\u0366\25\3\2\2\2\u0367\u0368\5\32\16"+
		"\2\u0368\u0369\7\u0150\2\2\u0369\u036a\5\u00dep\2\u036a\27\3\2\2\2\u036b"+
		"\u036c\7\26\2\2\u036c\u036e\5\u01a6\u00d4\2\u036d\u036b\3\2\2\2\u036d"+
		"\u036e\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0381\7~\2\2\u0370\u0371\7\\"+
		"\2\2\u0371\u0372\7I\2\2\u0372\u0373\7\u0081\2\2\u0373\u0374\7\u00be\2"+
		"\2\u0374\u0378\5\u01a6\u00d4\2\u0375\u0379\7\36\2\2\u0376\u0377\7P\2\2"+
		"\u0377\u0379\7\36\2\2\u0378\u0375\3\2\2\2\u0378\u0376\3\2\2\2\u0378\u0379"+
		"\3\2\2\2\u0379\u037e\3\2\2\2\u037a\u037b\7?\2\2\u037b\u037f\7\37\2\2\u037c"+
		"\u037d\7?\2\2\u037d\u037f\7:\2\2\u037e\u037a\3\2\2\2\u037e\u037c\3\2\2"+
		"\2\u037e\u037f\3\2\2\2\u037f\u0381\3\2\2\2\u0380\u036d\3\2\2\2\u0380\u0370"+
		"\3\2\2\2\u0381\31\3\2\2\2\u0382\u0383\t\6\2\2\u0383\33\3\2\2\2\u0384\u0385"+
		"\7\u0090\2\2\u0385\u0386\7\u00e0\2\2\u0386\u0387\7Q\2\2\u0387\u03b2\7"+
		"\u00c1\2\2\u0388\u0389\7f\2\2\u0389\u038a\7Q\2\2\u038a\u038b\7\u00e0\2"+
		"\2\u038b\u038c\7Q\2\2\u038c\u03b2\7\u00c1\2\2\u038d\u038e\7r\2\2\u038e"+
		"\u03b2\7;\2\2\u038f\u03b2\7\u00ff\2\2\u0390\u0392\7\u011c\2\2\u0391\u0393"+
		"\7\u00b3\2\2\u0392\u0391\3\2\2\2\u0392\u0393\3\2\2\2\u0393\u0394\3\2\2"+
		"\2\u0394\u0395\7\u00fa\2\2\u0395\u03b2\7F\2\2\u0396\u0398\7\u00b3\2\2"+
		"\u0397\u0396\3\2\2\2\u0397\u0398\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u039a"+
		"\7\u00fa\2\2\u039a\u03b2\7\u00a7\2\2\u039b\u039c\7\u009e\2\2\u039c\u03b2"+
		"\7\u0169\2\2\u039d\u039e\7b\2\2\u039e\u03b2\7\u0169\2\2\u039f\u03a0\7"+
		"\u00fc\2\2\u03a0\u03a6\5\u00a4S\2\u03a1\u03a2\7\u010f\2\2\u03a2\u03a7"+
		"\5\u00a4S\2\u03a3\u03a4\7\u0150\2\2\u03a4\u03a7\5\u00a4S\2\u03a5\u03a7"+
		"\7\34\2\2\u03a6\u03a1\3\2\2\2\u03a6\u03a3\3\2\2\2\u03a6\u03a5\3\2\2\2"+
		"\u03a7\u03b2\3\2\2\2\u03a8\u03a9\7\u00fc\2\2\u03a9\u03aa\5\u00a4S\2\u03aa"+
		"\u03ab\7\62\2\2\u03ab\u03ac\7\u00a1\2\2\u03ac\u03b2\3\2\2\2\u03ad\u03ae"+
		"\7\u00f4\2\2\u03ae\u03b2\5\u00a4S\2\u03af\u03b0\7\u00f4\2\2\u03b0\u03b2"+
		"\7\7\2\2\u03b1\u0384\3\2\2\2\u03b1\u0388\3\2\2\2\u03b1\u038d\3\2\2\2\u03b1"+
		"\u038f\3\2\2\2\u03b1\u0390\3\2\2\2\u03b1\u0397\3\2\2\2\u03b1\u039b\3\2"+
		"\2\2\u03b1\u039d\3\2\2\2\u03b1\u039f\3\2\2\2\u03b1\u03a8\3\2\2\2\u03b1"+
		"\u03ad\3\2\2\2\u03b1\u03af\3\2\2\2\u03b2\35\3\2\2\2\u03b3\u03b4\7\b\2"+
		"\2\u03b4\u03b5\7\34\2\2\u03b5\u03c0\7]\2\2\u03b6\u03b7\7-\2\2\u03b7\u03b8"+
		"\t\7\2\2\u03b8\u03bd\5\u00a4S\2\u03b9\u03ba\7\u0153\2\2\u03ba\u03bc\5"+
		"\u00a4S\2\u03bb\u03b9\3\2\2\2\u03bc\u03bf\3\2\2\2\u03bd\u03bb\3\2\2\2"+
		"\u03bd\u03be\3\2\2\2\u03be\u03c1\3\2\2\2\u03bf\u03bd\3\2\2\2\u03c0\u03b6"+
		"\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u03cc\3\2\2\2\u03c2\u03c3\7<\2\2\u03c3"+
		"\u03c4\7j\2\2\u03c4\u03c9\5\u00a4S\2\u03c5\u03c6\7\u0153\2\2\u03c6\u03c8"+
		"\5\u00a4S\2\u03c7\u03c5\3\2\2\2\u03c8\u03cb\3\2\2\2\u03c9\u03c7\3\2\2"+
		"\2\u03c9\u03ca\3\2\2\2\u03ca\u03cd\3\2\2\2\u03cb\u03c9\3\2\2\2\u03cc\u03c2"+
		"\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce\u03cf\5 \21\2\u03cf"+
		"\37\3\2\2\2\u03d0\u03dd\7\64\2\2\u03d1\u03d6\t\b\2\2\u03d2\u03d3\7\u0153"+
		"\2\2\u03d3\u03d5\t\b\2\2\u03d4\u03d2\3\2\2\2\u03d5\u03d8\3\2\2\2\u03d6"+
		"\u03d4\3\2\2\2\u03d6\u03d7\3\2\2\2\u03d7\u03de\3\2\2\2\u03d8\u03d6\3\2"+
		"\2\2\u03d9\u03db\7\7\2\2\u03da\u03dc\7]\2\2\u03db\u03da\3\2\2\2\u03db"+
		"\u03dc\3\2\2\2\u03dc\u03de\3\2\2\2\u03dd\u03d1\3\2\2\2\u03dd\u03d9\3\2"+
		"\2\2\u03de\u03df\3\2\2\2\u03df\u03e0\7\u00e0\2\2\u03e0\u03e1\7\u0108\2"+
		"\2\u03e1\u0459\58\35\2\u03e2\u03ef\7\64\2\2\u03e3\u03e8\t\t\2\2\u03e4"+
		"\u03e5\7\u0153\2\2\u03e5\u03e7\t\t\2\2\u03e6\u03e4\3\2\2\2\u03e7\u03ea"+
		"\3\2\2\2\u03e8\u03e6\3\2\2\2\u03e8\u03e9\3\2\2\2\u03e9\u03f0\3\2\2\2\u03ea"+
		"\u03e8\3\2\2\2\u03eb\u03ed\7\7\2\2\u03ec\u03ee\7]\2\2\u03ed\u03ec\3\2"+
		"\2\2\u03ed\u03ee\3\2\2\2\u03ee\u03f0\3\2\2\2\u03ef\u03e3\3\2\2\2\u03ef"+
		"\u03eb\3\2\2\2\u03f0\u03f1\3\2\2\2\u03f1\u03f2\7\u00e0\2\2\u03f2\u03f3"+
		"\7l\2\2\u03f3\u0459\58\35\2\u03f4\u03fa\7\64\2\2\u03f5\u03fb\7*\2\2\u03f6"+
		"\u03f8\7\7\2\2\u03f7\u03f9\7]\2\2\u03f8\u03f7\3\2\2\2\u03f8\u03f9\3\2"+
		"\2\2\u03f9\u03fb\3\2\2\2\u03fa\u03f5\3\2\2\2\u03fa\u03f6\3\2\2\2\u03fb"+
		"\u03fc\3\2\2\2\u03fc\u03fd\7\u00e0\2\2\u03fd\u03fe\7\61\2\2\u03fe\u0459"+
		"\58\35\2\u03ff\u0405\7\64\2\2\u0400\u0406\7\u0080\2\2\u0401\u0403\7\7"+
		"\2\2\u0402\u0404\7]\2\2\u0403\u0402\3\2\2\2\u0403\u0404\3\2\2\2\u0404"+
		"\u0406\3\2\2\2\u0405\u0400\3\2\2\2\u0405\u0401\3\2\2\2\u0406\u0407\3\2"+
		"\2\2\u0407\u0408\7\u00e0\2\2\u0408\u0409\7\u0111\2\2\u0409\u0459\58\35"+
		"\2\u040a\u040e\7g\2\2\u040b\u040c\7\64\2\2\u040c\u040d\7\u00e2\2\2\u040d"+
		"\u040f\7-\2\2\u040e\u040b\3\2\2\2\u040e\u040f\3\2\2\2\u040f\u041c\3\2"+
		"\2\2\u0410\u0415\t\b\2\2\u0411\u0412\7\u0153\2\2\u0412\u0414\t\b\2\2\u0413"+
		"\u0411\3\2\2\2\u0414\u0417\3\2\2\2\u0415\u0413\3\2\2\2\u0415\u0416\3\2"+
		"\2\2\u0416\u041d\3\2\2\2\u0417\u0415\3\2\2\2\u0418\u041a\7\7\2\2\u0419"+
		"\u041b\7]\2\2\u041a\u0419\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u041d\3\2"+
		"\2\2\u041c\u0410\3\2\2\2\u041c\u0418\3\2\2\2\u041d\u041e\3\2\2\2\u041e"+
		"\u041f\7\u00e0\2\2\u041f\u0420\7\u0108\2\2\u0420\u0459\5\64\33\2\u0421"+
		"\u0425\7g\2\2\u0422\u0423\7\64\2\2\u0423\u0424\7\u00e2\2\2\u0424\u0426"+
		"\7-\2\2\u0425\u0422\3\2\2\2\u0425\u0426\3\2\2\2\u0426\u0433\3\2\2\2\u0427"+
		"\u042c\t\t\2\2\u0428\u0429\7\u0153\2\2\u0429\u042b\t\t\2\2\u042a\u0428"+
		"\3\2\2\2\u042b\u042e\3\2\2\2\u042c\u042a\3\2\2\2\u042c\u042d\3\2\2\2\u042d"+
		"\u0434\3\2\2\2\u042e\u042c\3\2\2\2\u042f\u0431\7\7\2\2\u0430\u0432\7]"+
		"\2\2\u0431\u0430\3\2\2\2\u0431\u0432\3\2\2\2\u0432\u0434\3\2\2\2\u0433"+
		"\u0427\3\2\2\2\u0433\u042f\3\2\2\2\u0434\u0435\3\2\2\2\u0435\u0436\7\u00e0"+
		"\2\2\u0436\u0437\7l\2\2\u0437\u0459\5\64\33\2\u0438\u043c\7g\2\2\u0439"+
		"\u043a\7\64\2\2\u043a\u043b\7\u00e2\2\2\u043b\u043d\7-\2\2\u043c\u0439"+
		"\3\2\2\2\u043c\u043d\3\2\2\2\u043d\u0443\3\2\2\2\u043e\u0444\7*\2\2\u043f"+
		"\u0441\7\7\2\2\u0440\u0442\7]\2\2\u0441\u0440\3\2\2\2\u0441\u0442\3\2"+
		"\2\2\u0442\u0444\3\2\2\2\u0443\u043e\3\2\2\2\u0443\u043f\3\2\2\2\u0444"+
		"\u0445\3\2\2\2\u0445\u0446\7\u00e0\2\2\u0446\u0447\7\61\2\2\u0447\u0459"+
		"\5\64\33\2\u0448\u044c\7g\2\2\u0449\u044a\7\64\2\2\u044a\u044b\7\u00e2"+
		"\2\2\u044b\u044d\7-\2\2\u044c\u0449\3\2\2\2\u044c\u044d\3\2\2\2\u044d"+
		"\u0453\3\2\2\2\u044e\u0454\7\u0080\2\2\u044f\u0451\7\7\2\2\u0450\u0452"+
		"\7]\2\2\u0451\u0450\3\2\2\2\u0451\u0452\3\2\2\2\u0452\u0454\3\2\2\2\u0453"+
		"\u044e\3\2\2\2\u0453\u044f\3\2\2\2\u0454\u0455\3\2\2\2\u0455\u0456\7\u00e0"+
		"\2\2\u0456\u0457\7\u0111\2\2\u0457\u0459\5\64\33\2\u0458\u03d0\3\2\2\2"+
		"\u0458\u03e2\3\2\2\2\u0458\u03f4\3\2\2\2\u0458\u03ff\3\2\2\2\u0458\u040a"+
		"\3\2\2\2\u0458\u0421\3\2\2\2\u0458\u0438\3\2\2\2\u0458\u0448\3\2\2\2\u0459"+
		"!\3\2\2\2\u045a\u045b\7\b\2\2\u045b\u045e\7k\2\2\u045c\u045d\78\2\2\u045d"+
		"\u045f\7\u00b1\2\2\u045e\u045c\3\2\2\2\u045e\u045f\3\2\2\2\u045f\u0460"+
		"\3\2\2\2\u0460\u046b\5\u01a6\u00d4\2\u0461\u046a\5T+\2\u0462\u0467\7\u00f5"+
		"\2\2\u0463\u0465\7\u0087\2\2\u0464\u0463\3\2\2\2\u0464\u0465\3\2\2\2\u0465"+
		"\u0466\3\2\2\2\u0466\u0468\5\u00a4S\2\u0467\u0464\3\2\2\2\u0467\u0468"+
		"\3\2\2\2\u0468\u046a\3\2\2\2\u0469\u0461\3\2\2\2\u0469\u0462\3\2\2\2\u046a"+
		"\u046d\3\2\2\2\u046b\u0469\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u0490\3\2"+
		"\2\2\u046d\u046b\3\2\2\2\u046e\u046f\7\b\2\2\u046f\u0472\7k\2\2\u0470"+
		"\u0471\78\2\2\u0471\u0473\7\u00b1\2\2\u0472\u0470\3\2\2\2\u0472\u0473"+
		"\3\2\2\2\u0473\u0474\3\2\2\2\u0474\u0475\5\u01a6\u00d4\2\u0475\u0476\7"+
		"Z\2\2\u0476\u0477\7\u010f\2\2\u0477\u0478\5\u01a6\u00d4\2\u0478\u0490"+
		"\3\2\2\2\u0479\u047a\7\b\2\2\u047a\u047d\7k\2\2\u047b\u047c\78\2\2\u047c"+
		"\u047e\7\u00b1\2\2\u047d\u047b\3\2\2\2\u047d\u047e\3\2\2\2\u047e\u047f"+
		"\3\2\2\2\u047f\u0480\5\u01a6\u00d4\2\u0480\u0481\7\u00f2\2\2\u0481\u0482"+
		"\7\u010f\2\2\u0482\u0483\5\u01a6\u00d4\2\u0483\u0490\3\2\2\2\u0484\u0485"+
		"\7\b\2\2\u0485\u0488\7k\2\2\u0486\u0487\78\2\2\u0487\u0489\7\u00b1\2\2"+
		"\u0488\u0486\3\2\2\2\u0488\u0489\3\2\2\2\u0489\u048a\3\2\2\2\u048a\u048b"+
		"\5\u01a6\u00d4\2\u048b\u048c\7\u00fc\2\2\u048c\u048d\7j\2\2\u048d\u048e"+
		"\5\u01a6\u00d4\2\u048e\u0490\3\2\2\2\u048f\u045a\3\2\2\2\u048f\u046e\3"+
		"\2\2\2\u048f\u0479\3\2\2\2\u048f\u0484\3\2\2\2\u0490#\3\2\2\2\u0491\u0493"+
		"\7\31\2\2\u0492\u0494\7~\2\2\u0493\u0492\3\2\2\2\u0493\u0494\3\2\2\2\u0494"+
		"\u0495\3\2\2\2\u0495\u0497\7\u00be\2\2\u0496\u0498\7\u009c\2\2\u0497\u0496"+
		"\3\2\2\2\u0497\u0498\3\2\2\2\u0498\u049a\3\2\2\2\u0499\u049b\5\u01a6\u00d4"+
		"\2\u049a\u0499\3\2\2\2\u049a\u049b\3\2\2\2\u049b\u049c\3\2\2\2\u049c\u049d"+
		"\7\u00e0\2\2\u049d\u04a0\5\u01a6\u00d4\2\u049e\u049f\7\u0081\2\2\u049f"+
		"\u04a1\5\u01a6\u00d4\2\u04a0\u049e\3\2\2\2\u04a0\u04a1\3\2\2\2\u04a1\u04a2"+
		"\3\2\2\2\u04a2\u04a4\5\u01f2\u00fa\2\u04a3\u04a5\5|?\2\u04a4\u04a3\3\2"+
		"\2\2\u04a4\u04a5\3\2\2\2\u04a5\u04a8\3\2\2\2\u04a6\u04a7\7\u0107\2\2\u04a7"+
		"\u04a9\5\u01a6\u00d4\2\u04a8\u04a6\3\2\2\2\u04a8\u04a9\3\2\2\2\u04a9\u04ac"+
		"\3\2\2\2\u04aa\u04ab\7\u0086\2\2\u04ab\u04ad\5\u0132\u009a\2\u04ac\u04aa"+
		"\3\2\2\2\u04ac\u04ad\3\2\2\2\u04ad%\3\2\2\2\u04ae\u04af\7\31\2\2\u04af"+
		"\u04b3\7+\2\2\u04b0\u04b1\78\2\2\u04b1\u04b2\7P\2\2\u04b2\u04b4\7\u00b1"+
		"\2\2\u04b3\u04b0\3\2\2\2\u04b3\u04b4\3\2\2\2\u04b4\u04b5\3\2\2\2\u04b5"+
		"\u04b7\5\u00a4S\2\u04b6\u04b8\7\u0087\2\2\u04b7\u04b6\3\2\2\2\u04b7\u04b8"+
		"\3\2\2\2\u04b8\u04bb\3\2\2\2\u04b9\u04ba\7j\2\2\u04ba\u04bc\5\u00a4S\2"+
		"\u04bb\u04b9\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc\u04bf\3\2\2\2\u04bd\u04be"+
		"\7\u011b\2\2\u04be\u04c0\5\u00a4S\2\u04bf\u04bd\3\2\2\2\u04bf\u04c0\3"+
		"\2\2\2\u04c0\u04c3\3\2\2\2\u04c1\u04c2\7\62\2\2\u04c2\u04c4\5\u00a4S\2"+
		"\u04c3\u04c1\3\2\2\2\u04c3\u04c4\3\2\2\2\u04c4\'\3\2\2\2\u04c5\u04c8\7"+
		"\31\2\2\u04c6\u04c7\7W\2\2\u04c7\u04c9\7d\2\2\u04c8\u04c6\3\2\2\2\u04c8"+
		"\u04c9\3\2\2\2\u04c9\u04cb\3\2\2\2\u04ca\u04cc\7_\2\2\u04cb\u04ca\3\2"+
		"\2\2\u04cb\u04cc\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd\u04ce\7\u00c8\2\2\u04ce"+
		"\u04e7\5\u00a4S\2\u04cf\u04d2\7\31\2\2\u04d0\u04d1\7W\2\2\u04d1\u04d3"+
		"\7d\2\2\u04d2\u04d0\3\2\2\2\u04d2\u04d3\3\2\2\2\u04d3\u04d5\3\2\2\2\u04d4"+
		"\u04d6\7y\2\2\u04d5\u04d4\3\2\2\2\u04d5\u04d6\3\2\2\2\u04d6\u04d8\3\2"+
		"\2\2\u04d7\u04d9\7_\2\2\u04d8\u04d7\3\2\2\2\u04d8\u04d9\3\2\2\2\u04d9"+
		"\u04da\3\2\2\2\u04da\u04db\7\u00c8\2\2\u04db\u04dc\5\u00a4S\2\u04dc\u04dd"+
		"\7\67\2\2\u04dd\u04e0\5\u01a6\u00d4\2\u04de\u04df\7@\2\2\u04df\u04e1\5"+
		"\u01a6\u00d4\2\u04e0\u04de\3\2\2\2\u04e0\u04e1\3\2\2\2\u04e1\u04e4\3\2"+
		"\2\2\u04e2\u04e3\7\u0082\2\2\u04e3\u04e5\5\u01a6\u00d4\2\u04e4\u04e2\3"+
		"\2\2\2\u04e4\u04e5\3\2\2\2\u04e5\u04e7\3\2\2\2\u04e6\u04c5\3\2\2\2\u04e6"+
		"\u04cf\3\2\2\2\u04e7)\3\2\2\2\u04e8\u04e9\7\31\2\2\u04e9\u04ea\7\u00af"+
		"\2\2\u04ea\u04eb\7z\2\2\u04eb\u04ec\5\u01a6\u00d4\2\u04ec\u04ed\7\u00e0"+
		"\2\2\u04ed\u0502\5\u01a6\u00d4\2\u04ee\u04ef\7\u0085\2\2\u04ef\u04fe\5"+
		"\u01a6\u00d4\2\u04f0\u04f1\7<\2\2\u04f1\u04f2\7\u015a\2\2\u04f2\u04f7"+
		"\7\u0170\2\2\u04f3\u04f4\7\u0153\2\2\u04f4\u04f6\7\u0170\2\2\u04f5\u04f3"+
		"\3\2\2\2\u04f6\u04f9\3\2\2\2\u04f7\u04f5\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8"+
		"\u04fa\3\2\2\2\u04f9\u04f7\3\2\2\2\u04fa\u04fc\7\u015b\2\2\u04fb\u04fd"+
		"\7\t\2\2\u04fc\u04fb\3\2\2\2\u04fc\u04fd\3\2\2\2\u04fd\u04ff\3\2\2\2\u04fe"+
		"\u04f0\3\2\2\2\u04ff\u0500\3\2\2\2\u0500\u04fe\3\2\2\2\u0500\u0501\3\2"+
		"\2\2\u0501\u0503\3\2\2\2\u0502\u04ee\3\2\2\2\u0502\u0503\3\2\2\2\u0503"+
		"\u0504\3\2\2\2\u0504\u0505\7*\2\2\u0505\u0506\7^\2\2\u0506\u0507\5\u0104"+
		"\u0083\2\u0507+\3\2\2\2\u0508\u050a\7\u00fc\2\2\u0509\u050b\t\n\2\2\u050a"+
		"\u0509\3\2\2\2\u050a\u050b\3\2\2\2\u050b\u050c\3\2\2\2\u050c\u050d\5\u00a4"+
		"S\2\u050d\u050e\t\13\2\2\u050e\u0513\5.\30\2\u050f\u0510\7\u0153\2\2\u0510"+
		"\u0512\5.\30\2\u0511\u050f\3\2\2\2\u0512\u0515\3\2\2\2\u0513\u0511\3\2"+
		"\2\2\u0513\u0514\3\2\2\2\u0514\u052d\3\2\2\2\u0515\u0513\3\2\2\2\u0516"+
		"\u0518\7\u00fc\2\2\u0517\u0519\t\n\2\2\u0518\u0517\3\2\2\2\u0518\u0519"+
		"\3\2\2\2\u0519\u051a\3\2\2\2\u051a\u051b\7\u013c\2\2\u051b\u051f\7\u0121"+
		"\2\2\u051c\u0520\5\u00a4S\2\u051d\u0520\7N\2\2\u051e\u0520\7\34\2\2\u051f"+
		"\u051c\3\2\2\2\u051f\u051d\3\2\2\2\u051f\u051e\3\2\2\2\u0520\u0529\3\2"+
		"\2\2\u0521\u0525\7\u0153\2\2\u0522\u0526\5\u00a4S\2\u0523\u0526\7N\2\2"+
		"\u0524\u0526\7\34\2\2\u0525\u0522\3\2\2\2\u0525\u0523\3\2\2\2\u0525\u0524"+
		"\3\2\2\2\u0526\u0528\3\2\2\2\u0527\u0521\3\2\2\2\u0528\u052b\3\2\2\2\u0529"+
		"\u0527\3\2\2\2\u0529\u052a\3\2\2\2\u052a\u052d\3\2\2\2\u052b\u0529\3\2"+
		"\2\2\u052c\u0508\3\2\2\2\u052c\u0516\3\2\2\2\u052d-\3\2\2\2\u052e\u0535"+
		"\5\u0104\u0083\2\u052f\u0530\7\u0164\2\2\u0530\u0531\5\u0104\u0083\2\u0531"+
		"\u0532\7\u0164\2\2\u0532\u0535\3\2\2\2\u0533\u0535\7\34\2\2\u0534\u052e"+
		"\3\2\2\2\u0534\u052f\3\2\2\2\u0534\u0533\3\2\2\2\u0535/\3\2\2\2\u0536"+
		"\u0538\7\31\2\2\u0537\u0539\7\26\2\2\u0538\u0537\3\2\2\2\u0538\u0539\3"+
		"\2\2\2\u0539\u053a\3\2\2\2\u053a\u053b\7z\2\2\u053b\u0540\5\u00a4S\2\u053c"+
		"\u0541\7\16\2\2\u053d\u053e\7E\2\2\u053e\u0541\7R\2\2\u053f\u0541\7\5"+
		"\2\2\u0540\u053c\3\2\2\2\u0540\u053d\3\2\2\2\u0540\u053f\3\2\2\2\u0541"+
		"\u0556\3\2\2\2\u0542\u0552\7\u00c2\2\2\u0543\u0552\7 \2\2\u0544\u0552"+
		"\7|\2\2\u0545\u054f\7\177\2\2\u0546\u0547\7R\2\2\u0547\u054c\5\u00a4S"+
		"\2\u0548\u0549\7\u0153\2\2\u0549\u054b\5\u00a4S\2\u054a\u0548\3\2\2\2"+
		"\u054b\u054e\3\2\2\2\u054c\u054a\3\2\2\2\u054c\u054d\3\2\2\2\u054d\u0550"+
		"\3\2\2\2\u054e\u054c\3\2\2\2\u054f\u0546\3\2\2\2\u054f\u0550\3\2\2\2\u0550"+
		"\u0552\3\2\2\2\u0551\u0542\3\2\2\2\u0551\u0543\3\2\2\2\u0551\u0544\3\2"+
		"\2\2\u0551\u0545\3\2\2\2\u0552\u0554\3\2\2\2\u0553\u0555\7W\2\2\u0554"+
		"\u0553\3\2\2\2\u0554\u0555\3\2\2\2\u0555\u0557\3\2\2\2\u0556\u0551\3\2"+
		"\2\2\u0557\u0558\3\2\2\2\u0558\u0556\3\2\2\2\u0558\u0559\3\2\2\2\u0559"+
		"\u055a\3\2\2\2\u055a\u055b\7\u00e0\2\2\u055b\u055e\5\u01a6\u00d4\2\u055c"+
		"\u055d\7\62\2\2\u055d\u055f\5\u01a6\u00d4\2\u055e\u055c\3\2\2\2\u055e"+
		"\u055f\3\2\2\2\u055f\u0569\3\2\2\2\u0560\u0561\7P\2\2\u0561\u056a\7\36"+
		"\2\2\u0562\u0564\7\36\2\2\u0563\u0562\3\2\2\2\u0563\u0564\3\2\2\2\u0564"+
		"\u0565\3\2\2\2\u0565\u0566\7?\2\2\u0566\u056a\7:\2\2\u0567\u0568\7?\2"+
		"\2\u0568\u056a\7\37\2\2\u0569\u0560\3\2\2\2\u0569\u0563\3\2\2\2\u0569"+
		"\u0567\3\2\2\2\u0569\u056a\3\2\2\2\u056a\u0571\3\2\2\2\u056b\u056d\7-"+
		"\2\2\u056c\u056e\7$\2\2\u056d\u056c\3\2\2\2\u056d\u056e\3\2\2\2\u056e"+
		"\u056f\3\2\2\2\u056f\u0572\7a\2\2\u0570\u0572\7q\2\2\u0571\u056b\3\2\2"+
		"\2\u0571\u0570\3\2\2\2\u0571\u0572\3\2\2\2\u0572\u0575\3\2\2\2\u0573\u0574"+
		"\7\u0085\2\2\u0574\u0576\5\u0132\u009a\2\u0575\u0573\3\2\2\2\u0575\u0576"+
		"\3\2\2\2\u0576\u0577\3\2\2\2\u0577\u0578\7*\2\2\u0578\u0579\7^\2\2\u0579"+
		"\u057a\5\u01a6\u00d4\2\u057a\u057c\7\u015a\2\2\u057b\u057d\5\u00a4S\2"+
		"\u057c\u057b\3\2\2\2\u057c\u057d\3\2\2\2\u057d\u0582\3\2\2\2\u057e\u057f"+
		"\7\u0153\2\2\u057f\u0581\5\u00a4S\2\u0580\u057e\3\2\2\2\u0581\u0584\3"+
		"\2\2\2\u0582\u0580\3\2\2\2\u0582\u0583\3\2\2\2\u0583\u0585\3\2\2\2\u0584"+
		"\u0582\3\2\2\2\u0585\u0586\7\u015b\2\2\u0586\61\3\2\2\2\u0587\u058b\7"+
		"g\2\2\u0588\u0589\7\64\2\2\u0589\u058a\7\u00e2\2\2\u058a\u058c\7-\2\2"+
		"\u058b\u0588\3\2\2\2\u058b\u058c\3\2\2\2\u058c\u0599\3\2\2\2\u058d\u0592"+
		"\t\b\2\2\u058e\u058f\7\u0153\2\2\u058f\u0591\t\b\2\2\u0590\u058e\3\2\2"+
		"\2\u0591\u0594\3\2\2\2\u0592\u0590\3\2\2\2\u0592\u0593\3\2\2\2\u0593\u059a"+
		"\3\2\2\2\u0594\u0592\3\2\2\2\u0595\u0597\7\7\2\2\u0596\u0598\7]\2\2\u0597"+
		"\u0596\3\2\2\2\u0597\u0598\3\2\2\2\u0598\u059a\3\2\2\2\u0599\u058d\3\2"+
		"\2\2\u0599\u0595\3\2\2\2\u059a\u059b\3\2\2\2\u059b\u05ad\7\u00e0\2\2\u059c"+
		"\u059e\7t\2\2\u059d\u059c\3\2\2\2\u059d\u059e\3\2\2\2\u059e\u059f\3\2"+
		"\2\2\u059f\u05a1\5\u01a6\u00d4\2\u05a0\u059d\3\2\2\2\u05a1\u05a2\3\2\2"+
		"\2\u05a2\u05a0\3\2\2\2\u05a2\u05a3\3\2\2\2\u05a3\u05ae\3\2\2\2\u05a4\u05a5"+
		"\7\7\2\2\u05a5\u05a6\7\u0108\2\2\u05a6\u05a7\7<\2\2\u05a7\u05a9\7j\2\2"+
		"\u05a8\u05aa\5\u00a4S\2\u05a9\u05a8\3\2\2\2\u05aa\u05ab\3\2\2\2\u05ab"+
		"\u05a9\3\2\2\2\u05ab\u05ac\3\2\2\2\u05ac\u05ae\3\2\2\2\u05ad\u05a0\3\2"+
		"\2\2\u05ad\u05a4\3\2\2\2\u05ae\u05af\3\2\2\2\u05af\u05b0\5\64\33\2\u05b0"+
		"\u0706\3\2\2\2\u05b1\u05b5\7g\2\2\u05b2\u05b3\7\64\2\2\u05b3\u05b4\7\u00e2"+
		"\2\2\u05b4\u05b6\7-\2\2\u05b5\u05b2\3\2\2\2\u05b5\u05b6\3\2\2\2\u05b6"+
		"\u05d6\3\2\2\2\u05b7\u05b8\t\f\2\2\u05b8\u05b9\7\u015a\2\2\u05b9\u05be"+
		"\5\u00a4S\2\u05ba\u05bb\7\u0153\2\2\u05bb\u05bd\5\u00a4S\2\u05bc\u05ba"+
		"\3\2\2\2\u05bd\u05c0\3\2\2\2\u05be\u05bc\3\2\2\2\u05be\u05bf\3\2\2\2\u05bf"+
		"\u05c1\3\2\2\2\u05c0\u05be\3\2\2\2\u05c1\u05c2\7\u015b\2\2\u05c2\u05c4"+
		"\3\2\2\2\u05c3\u05b7\3\2\2\2\u05c4\u05c5\3\2\2\2\u05c5\u05c3\3\2\2\2\u05c5"+
		"\u05c6\3\2\2\2\u05c6\u05d7\3\2\2\2\u05c7\u05c9\7\7\2\2\u05c8\u05ca\7]"+
		"\2\2\u05c9\u05c8\3\2\2\2\u05c9\u05ca\3\2\2\2\u05ca\u05cb\3\2\2\2\u05cb"+
		"\u05cc\7\u015a\2\2\u05cc\u05d1\5\u00a4S\2\u05cd\u05ce\7\u0153\2\2\u05ce"+
		"\u05d0\5\u00a4S\2\u05cf\u05cd\3\2\2\2\u05d0\u05d3\3\2\2\2\u05d1\u05cf"+
		"\3\2\2\2\u05d1\u05d2\3\2\2\2\u05d2\u05d4\3\2\2\2\u05d3\u05d1\3\2\2\2\u05d4"+
		"\u05d5\7\u015b\2\2\u05d5\u05d7\3\2\2\2\u05d6\u05c3\3\2\2\2\u05d6\u05c7"+
		"\3\2\2\2\u05d7\u05d8\3\2\2\2\u05d8\u05da\7\u00e0\2\2\u05d9\u05db\7t\2"+
		"\2\u05da\u05d9\3\2\2\2\u05da\u05db\3\2\2\2\u05db\u05dc\3\2\2\2\u05dc\u05e1"+
		"\5\u01a6\u00d4\2\u05dd\u05de\7\u0153\2\2\u05de\u05e0\5\u01a6\u00d4\2\u05df"+
		"\u05dd\3\2\2\2\u05e0\u05e3\3\2\2\2\u05e1\u05df\3\2\2\2\u05e1\u05e2\3\2"+
		"\2\2\u05e2\u05e4\3\2\2\2\u05e3\u05e1\3\2\2\2\u05e4\u05e5\5\64\33\2\u05e5"+
		"\u0706\3\2\2\2\u05e6\u05ea\7g\2\2\u05e7\u05e8\7\64\2\2\u05e8\u05e9\7\u00e2"+
		"\2\2\u05e9\u05eb\7-\2\2\u05ea\u05e7\3\2\2\2\u05ea\u05eb\3\2\2\2\u05eb"+
		"\u05f5\3\2\2\2\u05ec\u05ee\t\t\2\2\u05ed\u05ec\3\2\2\2\u05ee\u05ef\3\2"+
		"\2\2\u05ef\u05ed\3\2\2\2\u05ef\u05f0\3\2\2\2\u05f0\u05f6\3\2\2\2\u05f1"+
		"\u05f3\7\7\2\2\u05f2\u05f4\7]\2\2\u05f3\u05f2\3\2\2\2\u05f3\u05f4\3\2"+
		"\2\2\u05f4\u05f6\3\2\2\2\u05f5\u05ed\3\2\2\2\u05f5\u05f1\3\2\2\2\u05f6"+
		"\u05f7\3\2\2\2\u05f7\u060d\7\u00e0\2\2\u05f8\u05f9\7k\2\2\u05f9\u05fe"+
		"\5\u01a6\u00d4\2\u05fa\u05fb\7\u0153\2\2\u05fb\u05fd\5\u01a6\u00d4\2\u05fc"+
		"\u05fa\3\2\2\2\u05fd\u0600\3\2\2\2\u05fe\u05fc\3\2\2\2\u05fe\u05ff\3\2"+
		"\2\2\u05ff\u060e\3\2\2\2\u0600\u05fe\3\2\2\2\u0601\u0602\7\7\2\2\u0602"+
		"\u0603\7l\2\2\u0603\u0604\7<\2\2\u0604\u0605\7j\2\2\u0605\u060a\5\u00a4"+
		"S\2\u0606\u0607\7\u0153\2\2\u0607\u0609\5\u00a4S\2\u0608\u0606\3\2\2\2"+
		"\u0609\u060c\3\2\2\2\u060a\u0608\3\2\2\2\u060a\u060b\3\2\2\2\u060b\u060e"+
		"\3\2\2\2\u060c\u060a\3\2\2\2\u060d\u05f8\3\2\2\2\u060d\u0601\3\2\2\2\u060e"+
		"\u060f\3\2\2\2\u060f\u0610\5\64\33\2\u0610\u0706\3\2\2\2\u0611\u0615\7"+
		"g\2\2\u0612\u0613\7\64\2\2\u0613\u0614\7\u00e2\2\2\u0614\u0616\7-\2\2"+
		"\u0615\u0612\3\2\2\2\u0615\u0616\3\2\2\2\u0616\u0620\3\2\2\2\u0617\u0619"+
		"\t\r\2\2\u0618\u0617\3\2\2\2\u0619\u061a\3\2\2\2\u061a\u0618\3\2\2\2\u061a"+
		"\u061b\3\2\2\2\u061b\u0621\3\2\2\2\u061c\u061e\7\7\2\2\u061d\u061f\7]"+
		"\2\2\u061e\u061d\3\2\2\2\u061e\u061f\3\2\2\2\u061f\u0621\3\2\2\2\u0620"+
		"\u0618\3\2\2\2\u0620\u061c\3\2\2\2\u0621\u0622\3\2\2\2\u0622\u0623\7\u00e0"+
		"\2\2\u0623\u0624\7\33\2\2\u0624\u0629\5\u00a4S\2\u0625\u0626\7\u0153\2"+
		"\2\u0626\u0628\5\u00a4S\2\u0627\u0625\3\2\2\2\u0628\u062b\3\2\2\2\u0629"+
		"\u0627\3\2\2\2\u0629\u062a\3\2\2\2\u062a\u062c\3\2\2\2\u062b\u0629\3\2"+
		"\2\2\u062c\u062d\5\64\33\2\u062d\u0706\3\2\2\2\u062e\u0632\7g\2\2\u062f"+
		"\u0630\7\64\2\2\u0630\u0631\7\u00e2\2\2\u0631\u0633\7-\2\2\u0632\u062f"+
		"\3\2\2\2\u0632\u0633\3\2\2\2\u0633\u0639\3\2\2\2\u0634\u063a\7\u0080\2"+
		"\2\u0635\u0637\7\7\2\2\u0636\u0638\7]\2\2\u0637\u0636\3\2\2\2\u0637\u0638"+
		"\3\2\2\2\u0638\u063a\3\2\2\2\u0639\u0634\3\2\2\2\u0639\u0635\3\2\2\2\u063a"+
		"\u063b\3\2\2\2\u063b\u063c\7\u00e0\2\2\u063c\u063d\7.\2\2\u063d\u063e"+
		"\7\u00a3\2\2\u063e\u063f\7\u011f\2\2\u063f\u0644\5\u01a6\u00d4\2\u0640"+
		"\u0641\7\u0153\2\2\u0641\u0643\5\u01a6\u00d4\2\u0642\u0640\3\2\2\2\u0643"+
		"\u0646\3\2\2\2\u0644\u0642\3\2\2\2\u0644\u0645\3\2\2\2\u0645\u0647\3\2"+
		"\2\2\u0646\u0644\3\2\2\2\u0647\u0648\5\64\33\2\u0648\u0706\3\2\2\2\u0649"+
		"\u064d\7g\2\2\u064a\u064b\7\64\2\2\u064b\u064c\7\u00e2\2\2\u064c\u064e"+
		"\7-\2\2\u064d\u064a\3\2\2\2\u064d\u064e\3\2\2\2\u064e\u0654\3\2\2\2\u064f"+
		"\u0655\7\u0080\2\2\u0650\u0652\7\7\2\2\u0651\u0653\7]\2\2\u0652\u0651"+
		"\3\2\2\2\u0652\u0653\3\2\2\2\u0653\u0655\3\2\2\2\u0654\u064f\3\2\2\2\u0654"+
		"\u0650\3\2\2\2\u0655\u0656\3\2\2\2\u0656\u0657\7\u00e0\2\2\u0657\u0658"+
		"\7.\2\2\u0658\u0659\7\u00fb\2\2\u0659\u065e\5\u00a4S\2\u065a\u065b\7\u0153"+
		"\2\2\u065b\u065d\5\u00a4S\2\u065c\u065a\3\2\2\2\u065d\u0660\3\2\2\2\u065e"+
		"\u065c\3\2\2\2\u065e\u065f\3\2\2\2\u065f\u0661\3\2\2\2\u0660\u065e\3\2"+
		"\2\2\u0661\u0662\5\64\33\2\u0662\u0706\3\2\2\2\u0663\u0667\7g\2\2\u0664"+
		"\u0665\7\64\2\2\u0665\u0666\7\u00e2\2\2\u0666\u0668\7-\2\2\u0667\u0664"+
		"\3\2\2\2\u0667\u0668\3\2\2\2\u0668\u066e\3\2\2\2\u0669\u066f\7*\2\2\u066a"+
		"\u066c\7\7\2\2\u066b\u066d\7]\2\2\u066c\u066b\3\2\2\2\u066c\u066d\3\2"+
		"\2\2\u066d\u066f\3\2\2\2\u066e\u0669\3\2\2\2\u066e\u066a\3\2\2\2\u066f"+
		"\u0670\3\2\2\2\u0670\u0673\7\u00e0\2\2\u0671\u0674\5L\'\2\u0672\u0674"+
		"\5P)\2\u0673\u0671\3\2\2\2\u0673\u0672\3\2\2\2\u0674\u0675\3\2\2\2\u0675"+
		"\u0676\5\64\33\2\u0676\u0706\3\2\2\2\u0677\u067b\7g\2\2\u0678\u0679\7"+
		"\64\2\2\u0679\u067a\7\u00e2\2\2\u067a\u067c\7-\2\2\u067b\u0678\3\2\2\2"+
		"\u067b\u067c\3\2\2\2\u067c\u0682\3\2\2\2\u067d\u0683\7\u0080\2\2\u067e"+
		"\u0680\7\7\2\2\u067f\u0681\7]\2\2\u0680\u067f\3\2\2\2\u0680\u0681\3\2"+
		"\2\2\u0681\u0683\3\2\2\2\u0682\u067d\3\2\2\2\u0682\u067e\3\2\2\2\u0683"+
		"\u0684\3\2\2\2\u0684\u0685\7\u00e0\2\2\u0685\u0686\7\u00c8\2\2\u0686\u068b"+
		"\5\u00a4S\2\u0687\u0688\7\u0153\2\2\u0688\u068a\5\u00a4S\2\u0689\u0687"+
		"\3\2\2\2\u068a\u068d\3\2\2\2\u068b\u0689\3\2\2\2\u068b\u068c\3\2\2\2\u068c"+
		"\u068e\3\2\2\2\u068d\u068b\3\2\2\2\u068e\u068f\5\64\33\2\u068f\u0706\3"+
		"\2\2\2\u0690\u0694\7g\2\2\u0691\u0692\7\64\2\2\u0692\u0693\7\u00e2\2\2"+
		"\u0693\u0695\7-\2\2\u0694\u0691\3\2\2\2\u0694\u0695\3\2\2\2\u0695\u06a3"+
		"\3\2\2\2\u0696\u069c\7m\2\2\u0697\u0699\7\177\2\2\u0698\u069a\7\u0153"+
		"\2\2\u0699\u0698\3\2\2\2\u0699\u069a\3\2\2\2\u069a\u069c\3\2\2\2\u069b"+
		"\u0696\3\2\2\2\u069b\u0697\3\2\2\2\u069c\u069d\3\2\2\2\u069d\u069b\3\2"+
		"\2\2\u069d\u069e\3\2\2\2\u069e\u06a4\3\2\2\2\u069f\u06a1\7\7\2\2\u06a0"+
		"\u06a2\7]\2\2\u06a1\u06a0\3\2\2\2\u06a1\u06a2\3\2\2\2\u06a2\u06a4\3\2"+
		"\2\2\u06a3\u069b\3\2\2\2\u06a3\u069f\3\2\2\2\u06a4\u06a5\3\2\2\2\u06a5"+
		"\u06a6\7\u00e0\2\2\u06a6\u06a7\7\u00c9\2\2\u06a7\u06a8\7\u00df\2\2\u06a8"+
		"\u06ad\5\u00a4S\2\u06a9\u06aa\7\u0153\2\2\u06aa\u06ac\5\u00a4S\2\u06ab"+
		"\u06a9\3\2\2\2\u06ac\u06af\3\2\2\2\u06ad\u06ab\3\2\2\2\u06ad\u06ae\3\2"+
		"\2\2\u06ae\u06b0\3\2\2\2\u06af\u06ad\3\2\2\2\u06b0\u06b1\5\64\33\2\u06b1"+
		"\u0706\3\2\2\2\u06b2\u06b6\7g\2\2\u06b3\u06b4\7\64\2\2\u06b4\u06b5\7\u00e2"+
		"\2\2\u06b5\u06b7\7-\2\2\u06b6\u06b3\3\2\2\2\u06b6\u06b7\3\2\2\2\u06b7"+
		"\u06c4\3\2\2\2\u06b8\u06ba\t\16\2\2\u06b9\u06bb\7\u0153\2\2\u06ba\u06b9"+
		"\3\2\2\2\u06ba\u06bb\3\2\2\2\u06bb\u06bd\3\2\2\2\u06bc\u06b8\3\2\2\2\u06bd"+
		"\u06be\3\2\2\2\u06be\u06bc\3\2\2\2\u06be\u06bf\3\2\2\2\u06bf\u06c5\3\2"+
		"\2\2\u06c0\u06c2\7\7\2\2\u06c1\u06c3\7]\2\2\u06c2\u06c1\3\2\2\2\u06c2"+
		"\u06c3\3\2\2\2\u06c3\u06c5\3\2\2\2\u06c4\u06bc\3\2\2\2\u06c4\u06c0\3\2"+
		"\2\2\u06c5\u06c6\3\2\2\2\u06c6\u06c7\7\u00e0\2\2\u06c7\u06c8\7j\2\2\u06c8"+
		"\u06cd\5\u00a4S\2\u06c9\u06ca\7\u0153\2\2\u06ca\u06cc\5\u00a4S\2\u06cb"+
		"\u06c9\3\2\2\2\u06cc\u06cf\3\2\2\2\u06cd\u06cb\3\2\2\2\u06cd\u06ce\3\2"+
		"\2\2\u06ce\u06d0\3\2\2\2\u06cf\u06cd\3\2\2\2\u06d0\u06d1\5\64\33\2\u06d1"+
		"\u0706\3\2\2\2\u06d2\u06d6\7g\2\2\u06d3\u06d4\7\64\2\2\u06d4\u06d5\7\u00e2"+
		"\2\2\u06d5\u06d7\7-\2\2\u06d6\u06d3\3\2\2\2\u06d6\u06d7\3\2\2\2\u06d7"+
		"\u06dd\3\2\2\2\u06d8\u06de\7\31\2\2\u06d9\u06db\7\7\2\2\u06da\u06dc\7"+
		"]\2\2\u06db\u06da\3\2\2\2\u06db\u06dc\3\2\2\2\u06dc\u06de\3\2\2\2\u06dd"+
		"\u06d8\3\2\2\2\u06dd\u06d9\3\2\2\2\u06de\u06df\3\2\2\2\u06df\u06e0\7\u00e0"+
		"\2\2\u06e0\u06e1\7\u0107\2\2\u06e1\u06e6\5\u00a4S\2\u06e2\u06e3\7\u0153"+
		"\2\2\u06e3\u06e5\5\u00a4S\2\u06e4\u06e2\3\2\2\2\u06e5\u06e8\3\2\2\2\u06e6"+
		"\u06e4\3\2\2\2\u06e6\u06e7\3\2\2\2\u06e7\u06e9\3\2\2\2\u06e8\u06e6\3\2"+
		"\2\2\u06e9\u06ea\5\64\33\2\u06ea\u0706\3\2\2\2\u06eb\u06ef\7g\2\2\u06ec"+
		"\u06ed\7\u0089\2\2\u06ed\u06ee\7\u00e2\2\2\u06ee\u06f0\7-\2\2\u06ef\u06ec"+
		"\3\2\2\2\u06ef\u06f0\3\2\2\2\u06f0\u06f1\3\2\2\2\u06f1\u06f6\5\u00a4S"+
		"\2\u06f2\u06f3\7\u0153\2\2\u06f3\u06f5\5\u00a4S\2\u06f4\u06f2\3\2\2\2"+
		"\u06f5\u06f8\3\2\2\2\u06f6\u06f4\3\2\2\2\u06f6\u06f7\3\2\2\2\u06f7\u06f9"+
		"\3\2\2\2\u06f8\u06f6\3\2\2\2\u06f9\u06fa\7\62\2\2\u06fa\u06ff\5\u00a4"+
		"S\2\u06fb\u06fc\7\u0153\2\2\u06fc\u06fe\5\u00a4S\2\u06fd\u06fb\3\2\2\2"+
		"\u06fe\u0701\3\2\2\2\u06ff\u06fd\3\2\2\2\u06ff\u0700\3\2\2\2\u0700\u0703"+
		"\3\2\2\2\u0701\u06ff\3\2\2\2\u0702\u0704\t\2\2\2\u0703\u0702\3\2\2\2\u0703"+
		"\u0704\3\2\2\2\u0704\u0706\3\2\2\2\u0705\u0587\3\2\2\2\u0705\u05b1\3\2"+
		"\2\2\u0705\u05e6\3\2\2\2\u0705\u0611\3\2\2\2\u0705\u062e\3\2\2\2\u0705"+
		"\u0649\3\2\2\2\u0705\u0663\3\2\2\2\u0705\u0677\3\2\2\2\u0705\u0690\3\2"+
		"\2\2\u0705\u06b2\3\2\2\2\u0705\u06d2\3\2\2\2\u0705\u06eb\3\2\2\2\u0706"+
		"\63\3\2\2\2\u0707\u070d\7\62\2\2\u0708\u070a\7\65\2\2\u0709\u0708\3\2"+
		"\2\2\u0709\u070a\3\2\2\2\u070a\u070b\3\2\2\2\u070b\u070e\5\u00a4S\2\u070c"+
		"\u070e\7\u00ec\2\2\u070d\u0709\3\2\2\2\u070d\u070c\3\2\2\2\u070e\u0719"+
		"\3\2\2\2\u070f\u0715\7\u0153\2\2\u0710\u0712\7\65\2\2\u0711\u0710\3\2"+
		"\2\2\u0711\u0712\3\2\2\2\u0712\u0713\3\2\2\2\u0713\u0716\5\u00a4S\2\u0714"+
		"\u0716\7\u00ec\2\2\u0715\u0711\3\2\2\2\u0715\u0714\3\2\2\2\u0716\u0718"+
		"\3\2\2\2\u0717\u070f\3\2\2\2\u0718\u071b\3\2\2\2\u0719\u0717\3\2\2\2\u0719"+
		"\u071a\3\2\2\2\u071a\u071d\3\2\2\2\u071b\u0719\3\2\2\2\u071c\u071e\t\2"+
		"\2\2\u071d\u071c\3\2\2\2\u071d\u071e\3\2\2\2\u071e\65\3\2\2\2\u071f\u072c"+
		"\7\64\2\2\u0720\u0725\t\b\2\2\u0721\u0722\7\u0153\2\2\u0722\u0724\t\b"+
		"\2\2\u0723\u0721\3\2\2\2\u0724\u0727\3\2\2\2\u0725\u0723\3\2\2\2\u0725"+
		"\u0726\3\2\2\2\u0726\u072d\3\2\2\2\u0727\u0725\3\2\2\2\u0728\u072a\7\7"+
		"\2\2\u0729\u072b\7]\2\2\u072a\u0729\3\2\2\2\u072a\u072b\3\2\2\2\u072b"+
		"\u072d\3\2\2\2\u072c\u0720\3\2\2\2\u072c\u0728\3\2\2\2\u072d\u072e\3\2"+
		"\2\2\u072e\u0746\7\u00e0\2\2\u072f\u0731\7t\2\2\u0730\u072f\3\2\2\2\u0730"+
		"\u0731\3\2\2\2\u0731\u0736\3\2\2\2\u0732\u0734\5\u01a6\u00d4\2\u0733\u0735"+
		"\7\u0153\2\2\u0734\u0733\3\2\2\2\u0734\u0735\3\2\2\2\u0735\u0737\3\2\2"+
		"\2\u0736\u0732\3\2\2\2\u0737\u0738\3\2\2\2\u0738\u0736\3\2\2\2\u0738\u0739"+
		"\3\2\2\2\u0739\u0747\3\2\2\2\u073a\u073b\7\7\2\2\u073b\u073c\7\u0108\2"+
		"\2\u073c\u073d\7<\2\2\u073d\u0742\7j\2\2\u073e\u0740\5\u00a4S\2\u073f"+
		"\u0741\7\u0153\2\2\u0740\u073f\3\2\2\2\u0740\u0741\3\2\2\2\u0741\u0743"+
		"\3\2\2\2\u0742\u073e\3\2\2\2\u0743\u0744\3\2\2\2\u0744\u0742\3\2\2\2\u0744"+
		"\u0745\3\2\2\2\u0745\u0747\3\2\2\2\u0746\u0730\3\2\2\2\u0746\u073a\3\2"+
		"\2\2\u0747\u0748\3\2\2\2\u0748\u0749\58\35\2\u0749\u086c\3\2\2\2\u074a"+
		"\u0764\7\64\2\2\u074b\u074c\t\f\2\2\u074c\u0751\5\u00a4S\2\u074d\u074e"+
		"\7\u0153\2\2\u074e\u0750\5\u00a4S\2\u074f\u074d\3\2\2\2\u0750\u0753\3"+
		"\2\2\2\u0751\u074f\3\2\2\2\u0751\u0752\3\2\2\2\u0752\u0755\3\2\2\2\u0753"+
		"\u0751\3\2\2\2\u0754\u074b\3\2\2\2\u0755\u0756\3\2\2\2\u0756\u0754\3\2"+
		"\2\2\u0756\u0757\3\2\2\2\u0757\u0765\3\2\2\2\u0758\u075a\7\7\2\2\u0759"+
		"\u075b\7]\2\2\u075a\u0759\3\2\2\2\u075a\u075b\3\2\2\2\u075b\u075c\3\2"+
		"\2\2\u075c\u0761\5\u00a4S\2\u075d\u075e\7\u0153\2\2\u075e\u0760\5\u00a4"+
		"S\2\u075f\u075d\3\2\2\2\u0760\u0763\3\2\2\2\u0761\u075f\3\2\2\2\u0761"+
		"\u0762\3\2\2\2\u0762\u0765\3\2\2\2\u0763\u0761\3\2\2\2\u0764\u0754\3\2"+
		"\2\2\u0764\u0758\3\2\2\2\u0765\u0766\3\2\2\2\u0766\u076e\7\u00e0\2\2\u0767"+
		"\u0769\7t\2\2\u0768\u0767\3\2\2\2\u0768\u0769\3\2\2\2\u0769\u076a\3\2"+
		"\2\2\u076a\u076c\5\u01a6\u00d4\2\u076b\u076d\7\u0153\2\2\u076c\u076b\3"+
		"\2\2\2\u076c\u076d\3\2\2\2\u076d\u076f\3\2\2\2\u076e\u0768\3\2\2\2\u076f"+
		"\u0770\3\2\2\2\u0770\u076e\3\2\2\2\u0770\u0771\3\2\2\2\u0771\u0772\3\2"+
		"\2\2\u0772\u0773\58\35\2\u0773\u086c\3\2\2\2\u0774\u0781\7\64\2\2\u0775"+
		"\u077a\t\t\2\2\u0776\u0777\7\u0153\2\2\u0777\u0779\t\t\2\2\u0778\u0776"+
		"\3\2\2\2\u0779\u077c\3\2\2\2\u077a\u0778\3\2\2\2\u077a\u077b\3\2\2\2\u077b"+
		"\u0782\3\2\2\2\u077c\u077a\3\2\2\2\u077d\u077f\7\7\2\2\u077e\u0780\7]"+
		"\2\2\u077f\u077e\3\2\2\2\u077f\u0780\3\2\2\2\u0780\u0782\3\2\2\2\u0781"+
		"\u0775\3\2\2\2\u0781\u077d\3\2\2\2\u0782\u0783\3\2\2\2\u0783\u079d\7\u00e0"+
		"\2\2\u0784\u0785\7k\2\2\u0785\u078a\5\u00a4S\2\u0786\u0787\7\u0153\2\2"+
		"\u0787\u0789\5\u00a4S\2\u0788\u0786\3\2\2\2\u0789\u078c\3\2\2\2\u078a"+
		"\u0788\3\2\2\2\u078a\u078b\3\2\2\2\u078b\u078e\3\2\2\2\u078c\u078a\3\2"+
		"\2\2\u078d\u0784\3\2\2\2\u078e\u078f\3\2\2\2\u078f\u078d\3\2\2\2\u078f"+
		"\u0790\3\2\2\2\u0790\u079e\3\2\2\2\u0791\u0792\7\7\2\2\u0792\u0793\7l"+
		"\2\2\u0793\u0794\7<\2\2\u0794\u0795\7j\2\2\u0795\u079a\5\u00a4S\2\u0796"+
		"\u0797\7\u0153\2\2\u0797\u0799";
	private static final String _serializedATNSegment1 =
		"\5\u00a4S\2\u0798\u0796\3\2\2\2\u0799\u079c\3\2\2\2\u079a\u0798\3\2\2"+
		"\2\u079a\u079b\3\2\2\2\u079b\u079e\3\2\2\2\u079c\u079a\3\2\2\2\u079d\u078d"+
		"\3\2\2\2\u079d\u0791\3\2\2\2\u079e\u079f\3\2\2\2\u079f\u07a0\58\35\2\u07a0"+
		"\u086c\3\2\2\2\u07a1\u07ae\7\64\2\2\u07a2\u07a7\t\r\2\2\u07a3\u07a4\7"+
		"\u0153\2\2\u07a4\u07a6\t\r\2\2\u07a5\u07a3\3\2\2\2\u07a6\u07a9\3\2\2\2"+
		"\u07a7\u07a5\3\2\2\2\u07a7\u07a8\3\2\2\2\u07a8\u07af\3\2\2\2\u07a9\u07a7"+
		"\3\2\2\2\u07aa\u07ac\7\7\2\2\u07ab\u07ad\7]\2\2\u07ac\u07ab\3\2\2\2\u07ac"+
		"\u07ad\3\2\2\2\u07ad\u07af\3\2\2\2\u07ae\u07a2\3\2\2\2\u07ae\u07aa\3\2"+
		"\2\2\u07af\u07b0\3\2\2\2\u07b0\u07b1\7\u00e0\2\2\u07b1\u07b2\7\33\2\2"+
		"\u07b2\u07b7\5\u00a4S\2\u07b3\u07b4\7\u0153\2\2\u07b4\u07b6\5\u00a4S\2"+
		"\u07b5\u07b3\3\2\2\2\u07b6\u07b9\3\2\2\2\u07b7\u07b5\3\2\2\2\u07b7\u07b8"+
		"\3\2\2\2\u07b8\u07ba\3\2\2\2\u07b9\u07b7\3\2\2\2\u07ba\u07bb\58\35\2\u07bb"+
		"\u086c\3\2\2\2\u07bc\u07c2\7\64\2\2\u07bd\u07c3\7\u0080\2\2\u07be\u07c0"+
		"\7\7\2\2\u07bf\u07c1\7]\2\2\u07c0\u07bf\3\2\2\2\u07c0\u07c1\3\2\2\2\u07c1"+
		"\u07c3\3\2\2\2\u07c2\u07bd\3\2\2\2\u07c2\u07be\3\2\2\2\u07c3\u07c4\3\2"+
		"\2\2\u07c4\u07c5\7\u00e0\2\2\u07c5\u07c6\7.\2\2\u07c6\u07c7\7\u00a3\2"+
		"\2\u07c7\u07c8\7\u011f\2\2\u07c8\u07cd\5\u00a4S\2\u07c9\u07ca\7\u0153"+
		"\2\2\u07ca\u07cc\5\u00a4S\2\u07cb\u07c9\3\2\2\2\u07cc\u07cf\3\2\2\2\u07cd"+
		"\u07cb\3\2\2\2\u07cd\u07ce\3\2\2\2\u07ce\u07d0\3\2\2\2\u07cf\u07cd\3\2"+
		"\2\2\u07d0\u07d1\58\35\2\u07d1\u086c\3\2\2\2\u07d2\u07d8\7\64\2\2\u07d3"+
		"\u07d9\7\u0080\2\2\u07d4\u07d6\7\7\2\2\u07d5\u07d7\7]\2\2\u07d6\u07d5"+
		"\3\2\2\2\u07d6\u07d7\3\2\2\2\u07d7\u07d9\3\2\2\2\u07d8\u07d3\3\2\2\2\u07d8"+
		"\u07d4\3\2\2\2\u07d9\u07da\3\2\2\2\u07da\u07db\7\u00e0\2\2\u07db\u07dc"+
		"\7.\2\2\u07dc\u07dd\7\u00fb\2\2\u07dd\u07e2\5\u00a4S\2\u07de\u07df\7\u0153"+
		"\2\2\u07df\u07e1\5\u00a4S\2\u07e0\u07de\3\2\2\2\u07e1\u07e4\3\2\2\2\u07e2"+
		"\u07e0\3\2\2\2\u07e2\u07e3\3\2\2\2\u07e3\u07e5\3\2\2\2\u07e4\u07e2\3\2"+
		"\2\2\u07e5\u07e6\58\35\2\u07e6\u086c\3\2\2\2\u07e7\u07ed\7\64\2\2\u07e8"+
		"\u07ee\7*\2\2\u07e9\u07eb\7\7\2\2\u07ea\u07ec\7]\2\2\u07eb\u07ea\3\2\2"+
		"\2\u07eb\u07ec\3\2\2\2\u07ec\u07ee\3\2\2\2\u07ed\u07e8\3\2\2\2\u07ed\u07e9"+
		"\3\2\2\2\u07ee\u07ef\3\2\2\2\u07ef\u07f2\7\u00e0\2\2\u07f0\u07f3\5L\'"+
		"\2\u07f1\u07f3\5P)\2\u07f2\u07f0\3\2\2\2\u07f2\u07f1\3\2\2\2\u07f3\u07f4"+
		"\3\2\2\2\u07f4\u07f5\58\35\2\u07f5\u086c\3\2\2\2\u07f6\u07fc\7\64\2\2"+
		"\u07f7\u07fd\7\u0080\2\2\u07f8\u07fa\7\7\2\2\u07f9\u07fb\7]\2\2\u07fa"+
		"\u07f9\3\2\2\2\u07fa\u07fb\3\2\2\2\u07fb\u07fd\3\2\2\2\u07fc\u07f7\3\2"+
		"\2\2\u07fc\u07f8\3\2\2\2\u07fd\u07fe\3\2\2\2\u07fe\u07ff\7\u00e0\2\2\u07ff"+
		"\u0800\7\u00c8\2\2\u0800\u0805\5\u00a4S\2\u0801\u0802\7\u0153\2\2\u0802"+
		"\u0804\5\u00a4S\2\u0803\u0801\3\2\2\2\u0804\u0807\3\2\2\2\u0805\u0803"+
		"\3\2\2\2\u0805\u0806\3\2\2\2\u0806\u0808\3\2\2\2\u0807\u0805\3\2\2\2\u0808"+
		"\u0809\58\35\2\u0809\u086c\3\2\2\2\u080a\u0817\7\64\2\2\u080b\u080d\t"+
		"\17\2\2\u080c\u080e\7\u0153\2\2\u080d\u080c\3\2\2\2\u080d\u080e\3\2\2"+
		"\2\u080e\u0810\3\2\2\2\u080f\u080b\3\2\2\2\u0810\u0811\3\2\2\2\u0811\u080f"+
		"\3\2\2\2\u0811\u0812\3\2\2\2\u0812\u0818\3\2\2\2\u0813\u0815\7\7\2\2\u0814"+
		"\u0816\7]\2\2\u0815\u0814\3\2\2\2\u0815\u0816\3\2\2\2\u0816\u0818\3\2"+
		"\2\2\u0817\u080f\3\2\2\2\u0817\u0813\3\2\2\2\u0818\u0819\3\2\2\2\u0819"+
		"\u081a\7\u00e0\2\2\u081a\u081b\7\u00c9\2\2\u081b\u081c\7\u00df\2\2\u081c"+
		"\u0821\5\u00a4S\2\u081d\u081e\7\u0153\2\2\u081e\u0820\5\u00a4S\2\u081f"+
		"\u081d\3\2\2\2\u0820\u0823\3\2\2\2\u0821\u081f\3\2\2\2\u0821\u0822\3\2"+
		"\2\2\u0822\u0824\3\2\2\2\u0823\u0821\3\2\2\2\u0824\u0825\58\35\2\u0825"+
		"\u086c\3\2\2\2\u0826\u0833\7\64\2\2\u0827\u0829\t\16\2\2\u0828\u082a\7"+
		"\u0153\2\2\u0829\u0828\3\2\2\2\u0829\u082a\3\2\2\2\u082a\u082c\3\2\2\2"+
		"\u082b\u0827\3\2\2\2\u082c\u082d\3\2\2\2\u082d\u082b\3\2\2\2\u082d\u082e"+
		"\3\2\2\2\u082e\u0834\3\2\2\2\u082f\u0831\7\7\2\2\u0830\u0832\7]\2\2\u0831"+
		"\u0830\3\2\2\2\u0831\u0832\3\2\2\2\u0832\u0834\3\2\2\2\u0833\u082b\3\2"+
		"\2\2\u0833\u082f\3\2\2\2\u0834\u0835\3\2\2\2\u0835\u0836\7\u00e0\2\2\u0836"+
		"\u0837\7j\2\2\u0837\u083c\5\u00a4S\2\u0838\u0839\7\u0153\2\2\u0839\u083b"+
		"\5\u00a4S\2\u083a\u0838\3\2\2\2\u083b\u083e\3\2\2\2\u083c\u083a\3\2\2"+
		"\2\u083c\u083d\3\2\2\2\u083d\u083f\3\2\2\2\u083e\u083c\3\2\2\2\u083f\u0840"+
		"\58\35\2\u0840\u086c\3\2\2\2\u0841\u0847\7\64\2\2\u0842\u0848\7\31\2\2"+
		"\u0843\u0845\7\7\2\2\u0844\u0846\7]\2\2\u0845\u0844\3\2\2\2\u0845\u0846"+
		"\3\2\2\2\u0846\u0848\3\2\2\2\u0847\u0842\3\2\2\2\u0847\u0843\3\2\2\2\u0848"+
		"\u0849\3\2\2\2\u0849\u084a\7\u00e0\2\2\u084a\u084b\7\u0107\2\2\u084b\u0850"+
		"\5\u00a4S\2\u084c\u084d\7\u0153\2\2\u084d\u084f\5\u00a4S\2\u084e\u084c"+
		"\3\2\2\2\u084f\u0852\3\2\2\2\u0850\u084e\3\2\2\2\u0850\u0851\3\2\2\2\u0851"+
		"\u0853\3\2\2\2\u0852\u0850\3\2\2\2\u0853\u0854\58\35\2\u0854\u0855\7\64"+
		"\2\2\u0855\u085a\5\u00a4S\2\u0856\u0857\7\u0153\2\2\u0857\u0859\5\u00a4"+
		"S\2\u0858\u0856\3\2\2\2\u0859\u085c\3\2\2\2\u085a\u0858\3\2\2\2\u085a"+
		"\u085b\3\2\2\2\u085b\u085d\3\2\2\2\u085c\u085a\3\2\2\2\u085d\u085e\7\u010f"+
		"\2\2\u085e\u0863\5\u00a4S\2\u085f\u0860\7\u0153\2\2\u0860\u0862\5\u00a4"+
		"S\2\u0861\u085f\3\2\2\2\u0862\u0865\3\2\2\2\u0863\u0861\3\2\2\2\u0863"+
		"\u0864\3\2\2\2\u0864\u0869\3\2\2\2\u0865\u0863\3\2\2\2\u0866\u0867\7\u0087"+
		"\2\2\u0867\u0868\7\u0089\2\2\u0868\u086a\7\u00e2\2\2\u0869\u0866\3\2\2"+
		"\2\u0869\u086a\3\2\2\2\u086a\u086c\3\2\2\2\u086b\u071f\3\2\2\2\u086b\u074a"+
		"\3\2\2\2\u086b\u0774\3\2\2\2\u086b\u07a1\3\2\2\2\u086b\u07bc\3\2\2\2\u086b"+
		"\u07d2\3\2\2\2\u086b\u07e7\3\2\2\2\u086b\u07f6\3\2\2\2\u086b\u080a\3\2"+
		"\2\2\u086b\u0826\3\2\2\2\u086b\u0841\3\2\2\2\u086c\67\3\2\2\2\u086d\u0873"+
		"\7\u010f\2\2\u086e\u0870\7\65\2\2\u086f\u086e\3\2\2\2\u086f\u0870\3\2"+
		"\2\2\u0870\u0871\3\2\2\2\u0871\u0874\5\u00a4S\2\u0872\u0874\7\u00ec\2"+
		"\2\u0873\u086f\3\2\2\2\u0873\u0872\3\2\2\2\u0874\u087f\3\2\2\2\u0875\u087b"+
		"\7\u0153\2\2\u0876\u0878\7\65\2\2\u0877\u0876\3\2\2\2\u0877\u0878\3\2"+
		"\2\2\u0878\u0879\3\2\2\2\u0879\u087c\5\u00a4S\2\u087a\u087c\7\u00ec\2"+
		"\2\u087b\u0877\3\2\2\2\u087b\u087a\3\2\2\2\u087c\u087e\3\2\2\2\u087d\u0875"+
		"\3\2\2\2\u087e\u0881\3\2\2\2\u087f\u087d\3\2\2\2\u087f\u0880\3\2\2\2\u0880"+
		"\u0885\3\2\2\2\u0881\u087f\3\2\2\2\u0882\u0883\7\u0087\2\2\u0883\u0884"+
		"\7\64\2\2\u0884\u0886\7\u00e2\2\2\u0885\u0882\3\2\2\2\u0885\u0886\3\2"+
		"\2\2\u08869\3\2\2\2\u0887\u0888\7\u0099\2\2\u0888\u0900\7\u00e0\2\2\u0889"+
		"\u088a\7\4\2\2\u088a\u088b\5\u01a6\u00d4\2\u088b\u0894\7\u015a\2\2\u088c"+
		"\u0891\5\u00b4[\2\u088d\u088e\7\u0153\2\2\u088e\u0890\5\u00b4[\2\u088f"+
		"\u088d\3\2\2\2\u0890\u0893\3\2\2\2\u0891\u088f\3\2\2\2\u0891\u0892\3\2"+
		"\2\2\u0892\u0895\3\2\2\2\u0893\u0891\3\2\2\2\u0894\u088c\3\2\2\2\u0894"+
		"\u0895\3\2\2\2\u0895\u0896\3\2\2\2\u0896\u0897\7\u015b\2\2\u0897\u0901"+
		"\3\2\2\2\u0898\u0899\7\22\2\2\u0899\u089a\7\u015a\2\2\u089a\u089b\5\u00b4"+
		"[\2\u089b\u089c\7\6\2\2\u089c\u089d\5\u00b4[\2\u089d\u089e\7\u015b\2\2"+
		"\u089e\u0901\3\2\2\2\u089f\u08a0\7\24\2\2\u08a0\u0901\5\u01a6\u00d4\2"+
		"\u08a1\u08a2\7\u0098\2\2\u08a2\u0901\5\u01a6\u00d4\2\u08a3\u08a4\7\26"+
		"\2\2\u08a4\u08a5\5\u01a6\u00d4\2\u08a5\u08a6\7\u00e0\2\2\u08a6\u08a7\5"+
		"\u01a6\u00d4\2\u08a7\u0901\3\2\2\2\u08a8\u08a9\7\30\2\2\u08a9\u0901\5"+
		"\u01a6\u00d4\2\u08aa\u08ab\7\33\2\2\u08ab\u0901\5\u01a6\u00d4\2\u08ac"+
		"\u08ad\7#\2\2\u08ad\u0901\5\u01a6\u00d4\2\u08ae\u08af\7+\2\2\u08af\u0901"+
		"\5\u01a6\u00d4\2\u08b0\u08b1\7.\2\2\u08b1\u08b2\7\u00a3\2\2\u08b2\u08b3"+
		"\7\u011f\2\2\u08b3\u0901\5\u01a6\u00d4\2\u08b4\u08b5\7.\2\2\u08b5\u08b6"+
		"\7t\2\2\u08b6\u0901\5\u01a6\u00d4\2\u08b7\u0901\5L\'\2\u08b8\u08b9\7\u00be"+
		"\2\2\u08b9\u0901\5\u01a6\u00d4\2\u08ba\u08bb\7\u00c9\2\2\u08bb\u08bc\7"+
		"\u00df\2\2\u08bc\u0901\5\u00a4S\2\u08bd\u08be\7V\2\2\u08be\u08bf\5\u01a6"+
		"\u00d4\2\u08bf\u08c0\7\u015a\2\2\u08c0\u08c1\5\u00b4[\2\u08c1\u08c2\7"+
		"\u0153\2\2\u08c2\u08c3\5\u00b4[\2\u08c3\u08c4\7\u015b\2\2\u08c4\u0901"+
		"\3\2\2\2\u08c5\u08c6\7V\2\2\u08c6\u08c7\7\u0091\2\2\u08c7\u08c8\5\u01a6"+
		"\u00d4\2\u08c8\u08c9\7\u0081\2\2\u08c9\u08ca\5\u00a4S\2\u08ca\u0901\3"+
		"\2\2\2\u08cb\u08cc\7V\2\2\u08cc\u08cd\7\u00b5\2\2\u08cd\u08ce\5\u01a6"+
		"\u00d4\2\u08ce\u08cf\7\u0081\2\2\u08cf\u08d0\5\u00a4S\2\u08d0\u0901\3"+
		"\2\2\2\u08d1\u08d3\7_\2\2\u08d2\u08d1\3\2\2\2\u08d2\u08d3\3\2\2\2\u08d3"+
		"\u08d4\3\2\2\2\u08d4\u08d5\7\u00c8\2\2\u08d5\u0901\5\u01a6\u00d4\2\u08d6"+
		"\u08d7\7`\2\2\u08d7\u0901\5\u01a6\u00d4\2\u08d8\u08d9\7i\2\2\u08d9\u08da"+
		"\5\u01a6\u00d4\2\u08da\u08db\7\u00e0\2\2\u08db\u08dc\5\u01a6\u00d4\2\u08dc"+
		"\u0901\3\2\2\2\u08dd\u08de\7j\2\2\u08de\u0901\5\u01a6\u00d4\2\u08df\u08e0"+
		"\7k\2\2\u08e0\u0901\5\u01a6\u00d4\2\u08e1\u08e2\7\u00fb\2\2\u08e2\u0901"+
		"\5\u01a6\u00d4\2\u08e3\u08e4\7t\2\2\u08e4\u0901\5\u01a6\u00d4\2\u08e5"+
		"\u08e6\7\u0107\2\2\u08e6\u0901\5\u01a6\u00d4\2\u08e7\u08e8\7\u0140\2\2"+
		"\u08e8\u08e9\7\u00f8\2\2\u08e9\u08ea\7\u009d\2\2\u08ea\u0901\5\u01a6\u00d4"+
		"\2\u08eb\u08ec\7\u0140\2\2\u08ec\u08ed\7\u00f8\2\2\u08ed\u08ee\7\u00a8"+
		"\2\2\u08ee\u0901\5\u01a6\u00d4\2\u08ef\u08f0\7\u0140\2\2\u08f0\u08f1\7"+
		"\u00f8\2\2\u08f1\u08f2\7\u00e6\2\2\u08f2\u0901\5\u01a6\u00d4\2\u08f3\u08f4"+
		"\7\u0140\2\2\u08f4\u08f5\7\u00f8\2\2\u08f5\u08f6\7\u0109\2\2\u08f6\u0901"+
		"\5\u01a6\u00d4\2\u08f7\u08f8\7z\2\2\u08f8\u08f9\5\u01a6\u00d4\2\u08f9"+
		"\u08fa\7\u00e0\2\2\u08fa\u08fb\5\u01a6\u00d4\2\u08fb\u0901\3\2\2\2\u08fc"+
		"\u08fd\7\u0110\2\2\u08fd\u0901\5\u01a6\u00d4\2\u08fe\u08ff\7\u0084\2\2"+
		"\u08ff\u0901\5\u01a6\u00d4\2\u0900\u0889\3\2\2\2\u0900\u0898\3\2\2\2\u0900"+
		"\u089f\3\2\2\2\u0900\u08a1\3\2\2\2\u0900\u08a3\3\2\2\2\u0900\u08a8\3\2"+
		"\2\2\u0900\u08aa\3\2\2\2\u0900\u08ac\3\2\2\2\u0900\u08ae\3\2\2\2\u0900"+
		"\u08b0\3\2\2\2\u0900\u08b4\3\2\2\2\u0900\u08b7\3\2\2\2\u0900\u08b8\3\2"+
		"\2\2\u0900\u08ba\3\2\2\2\u0900\u08bd\3\2\2\2\u0900\u08c5\3\2\2\2\u0900"+
		"\u08cb\3\2\2\2\u0900\u08d2\3\2\2\2\u0900\u08d6\3\2\2\2\u0900\u08d8\3\2"+
		"\2\2\u0900\u08dd\3\2\2\2\u0900\u08df\3\2\2\2\u0900\u08e1\3\2\2\2\u0900"+
		"\u08e3\3\2\2\2\u0900\u08e5\3\2\2\2\u0900\u08e7\3\2\2\2\u0900\u08eb\3\2"+
		"\2\2\u0900\u08ef\3\2\2\2\u0900\u08f3\3\2\2\2\u0900\u08f7\3\2\2\2\u0900"+
		"\u08fc\3\2\2\2\u0900\u08fe\3\2\2\2\u0901\u0902\3\2\2\2\u0902\u0903\7G"+
		"\2\2\u0903\u0904\7\u0170\2\2\u0904;\3\2\2\2\u0905\u0908\7\31\2\2\u0906"+
		"\u0907\7W\2\2\u0907\u0909\7d\2\2\u0908\u0906\3\2\2\2\u0908\u0909\3\2\2"+
		"\2\u0909\u090a\3\2\2\2\u090a\u090b\7\60\2\2\u090b\u091e\5@!\2\u090c\u090f"+
		"\7f\2\2\u090d\u0910\5\u0104\u0083\2\u090e\u0910\5\u00b4[\2\u090f\u090d"+
		"\3\2\2\2\u090f\u090e\3\2\2\2\u0910\u091f\3\2\2\2\u0911\u0912\7f\2\2\u0912"+
		"\u0913\7t\2\2\u0913\u0914\7\u015a\2\2\u0914\u0919\5> \2\u0915\u0916\7"+
		"\u0153\2\2\u0916\u0918\5> \2\u0917\u0915\3\2\2\2\u0918\u091b\3\2\2\2\u0919"+
		"\u0917\3\2\2\2\u0919\u091a\3\2\2\2\u091a\u091c\3\2\2\2\u091b\u0919\3\2"+
		"\2\2\u091c\u091d\7\u015b\2\2\u091d\u091f\3\2\2\2\u091e\u090c\3\2\2\2\u091e"+
		"\u0911\3\2\2\2\u091e\u091f\3\2\2\2\u091f\u0951\3\2\2\2\u0920\u0921\7\u00c8"+
		"\2\2\u0921\u0952\5\u00a4S\2\u0922\u0952\t\20\2\2\u0923\u0924\7\u0090\2"+
		"\2\u0924\u0925\7\u00e0\2\2\u0925\u0926\7Q\2\2\u0926\u0952\7\u00c1\2\2"+
		"\u0927\u0928\7f\2\2\u0928\u0929\7Q\2\2\u0929\u092a\7\u00e0\2\2\u092a\u092b"+
		"\7Q\2\2\u092b\u0952\7\u00c1\2\2\u092c\u092e\7\u00b3\2\2\u092d\u092c\3"+
		"\2\2\2\u092d\u092e\3\2\2\2\u092e\u092f\3\2\2\2\u092f\u0930\7\u00fa\2\2"+
		"\u0930\u0952\7F\2\2\u0931\u0933\7\u00b3\2\2\u0932\u0931\3\2\2\2\u0932"+
		"\u0933\3\2\2\2\u0933\u0934\3\2\2\2\u0934\u0935\7\u00fa\2\2\u0935\u0952"+
		"\7\u00a7\2\2\u0936\u0937\7\u009e\2\2\u0937\u0952\7\u0169\2\2\u0938\u0939"+
		"\7b\2\2\u0939\u0952\7\u0169\2\2\u093a\u093b\7\u00fc\2\2\u093b\u0942\5"+
		"\u00a4S\2\u093c\u093d\7\u010f\2\2\u093d\u0943\5\u00a4S\2\u093e\u093f\7"+
		"\u0150\2\2\u093f\u0943\5\u00a4S\2\u0940\u0941\7\62\2\2\u0941\u0943\7\u00a1"+
		"\2\2\u0942\u093c\3\2\2\2\u0942\u093e\3\2\2\2\u0942\u0940\3\2\2\2\u0943"+
		"\u0948\3\2\2\2\u0944\u0945\7\u0153\2\2\u0945\u0947\5\u00a4S\2\u0946\u0944"+
		"\3\2\2\2\u0947\u094a\3\2\2\2\u0948\u0946\3\2\2\2\u0948\u0949\3\2\2\2\u0949"+
		"\u0952\3\2\2\2\u094a\u0948\3\2\2\2\u094b\u094c\7\6\2\2\u094c\u0952\5D"+
		"#\2\u094d\u094e\7\6\2\2\u094e\u094f\7\u0170\2\2\u094f\u0950\7\u0153\2"+
		"\2\u0950\u0952\7\u0170\2\2\u0951\u0920\3\2\2\2\u0951\u0922\3\2\2\2\u0951"+
		"\u0923\3\2\2\2\u0951\u0927\3\2\2\2\u0951\u092d\3\2\2\2\u0951\u0932\3\2"+
		"\2\2\u0951\u0936\3\2\2\2\u0951\u0938\3\2\2\2\u0951\u093a\3\2\2\2\u0951"+
		"\u094b\3\2\2\2\u0951\u094d\3\2\2\2\u0952\u0953\3\2\2\2\u0953\u0951\3\2"+
		"\2\2\u0953\u0954\3\2\2\2\u0954\u0961\3\2\2\2\u0955\u0956\7\u0087\2\2\u0956"+
		"\u0957\7\u015a\2\2\u0957\u095c\5H%\2\u0958\u0959\7\u0153\2\2\u0959\u095b"+
		"\5H%\2\u095a\u0958\3\2\2\2\u095b\u095e\3\2\2\2\u095c\u095a\3\2\2\2\u095c"+
		"\u095d\3\2\2\2\u095d\u095f\3\2\2\2\u095e\u095c\3\2\2\2\u095f\u0960\7\u015b"+
		"\2\2\u0960\u0962\3\2\2\2\u0961\u0955\3\2\2\2\u0961\u0962\3\2\2\2\u0962"+
		"=\3\2\2\2\u0963\u0964\5\u00a4S\2\u0964\u0965\5\u00b4[\2\u0965?\3\2\2\2"+
		"\u0966\u0967\5\u01a6\u00d4\2\u0967\u0976\7\u015a\2\2\u0968\u096a\5F$\2"+
		"\u0969\u096b\5B\"\2\u096a\u0969\3\2\2\2\u096a\u096b\3\2\2\2\u096b\u0973"+
		"\3\2\2\2\u096c\u096d\7\u0153\2\2\u096d\u096f\5F$\2\u096e\u0970\5B\"\2"+
		"\u096f\u096e\3\2\2\2\u096f\u0970\3\2\2\2\u0970\u0972\3\2\2\2\u0971\u096c"+
		"\3\2\2\2\u0972\u0975\3\2\2\2\u0973\u0971\3\2\2\2\u0973\u0974\3\2\2\2\u0974"+
		"\u0977\3\2\2\2\u0975\u0973\3\2\2\2\u0976\u0968\3\2\2\2\u0976\u0977\3\2"+
		"\2\2\u0977\u0978\3\2\2\2\u0978\u0979\7\u015b\2\2\u0979A\3\2\2\2\u097a"+
		"\u097b\t\21\2\2\u097b\u097c\5\u0104\u0083\2\u097cC\3\2\2\2\u097d\u097f"+
		"\7\u0172\2\2\u097e\u0980\7\u0176\2\2\u097f\u097e\3\2\2\2\u0980\u0981\3"+
		"\2\2\2\u0981\u097f\3\2\2\2\u0981\u0982\3\2\2\2\u0982\u0983\3\2\2\2\u0983"+
		"\u0984\7\u0177\2\2\u0984E\3\2\2\2\u0985\u0987\5J&\2\u0986\u0985\3\2\2"+
		"\2\u0986\u0987\3\2\2\2\u0987\u0989\3\2\2\2\u0988\u098a\5\u00a4S\2\u0989"+
		"\u0988\3\2\2\2\u0989\u098a\3\2\2\2\u098a\u098e\3\2\2\2\u098b\u098f\5\u00b4"+
		"[\2\u098c\u098f\5\u0104\u0083\2\u098d\u098f\5\u01a6\u00d4\2\u098e\u098b"+
		"\3\2\2\2\u098e\u098c\3\2\2\2\u098e\u098d\3\2\2\2\u098fG\3\2\2\2\u0990"+
		"\u0991\t\22\2\2\u0991I\3\2\2\2\u0992\u0993\t\23\2\2\u0993K\3\2\2\2\u0994"+
		"\u0995\7\60\2\2\u0995\u0996\5N(\2\u0996M\3\2\2\2\u0997\u0998\5\u01a6\u00d4"+
		"\2\u0998\u09a1\7\u015a\2\2\u0999\u099e\5F$\2\u099a\u099b\7\u0153\2\2\u099b"+
		"\u099d\5F$\2\u099c\u099a\3\2\2\2\u099d\u09a0\3\2\2\2\u099e\u099c\3\2\2"+
		"\2\u099e\u099f\3\2\2\2\u099f\u09a2\3\2\2\2\u09a0\u099e\3\2\2\2\u09a1\u0999"+
		"\3\2\2\2\u09a1\u09a2\3\2\2\2\u09a2\u09a3\3\2\2\2\u09a3\u09a4\7\u015b\2"+
		"\2\u09a4O\3\2\2\2\u09a5\u09a6\7\7\2\2\u09a6\u09a7\7\61\2\2\u09a7\u09a8"+
		"\7<\2\2\u09a8\u09a9\7j\2\2\u09a9\u09ae\5\u00a4S\2\u09aa\u09ab\7\u0153"+
		"\2\2\u09ab\u09ad\5\u00a4S\2\u09ac\u09aa\3\2\2\2\u09ad\u09b0\3\2\2\2\u09ae"+
		"\u09ac\3\2\2\2\u09ae\u09af\3\2\2\2\u09afQ\3\2\2\2\u09b0\u09ae\3\2\2\2"+
		"\u09b1\u09b3\7\31\2\2\u09b2\u09b4\t\24\2\2\u09b3\u09b2\3\2\2\2\u09b3\u09b4"+
		"\3\2\2\2\u09b4\u09b5\3\2\2\2\u09b5\u09b6\7k\2\2\u09b6\u09ba\5\u01a6\u00d4"+
		"\2\u09b7\u09b9\5T+\2\u09b8\u09b7\3\2\2\2\u09b9\u09bc\3\2\2\2\u09ba\u09b8"+
		"\3\2\2\2\u09ba\u09bb\3\2\2\2\u09bbS\3\2\2\2\u09bc\u09ba\3\2\2\2\u09bd"+
		"\u09bf\7\u00c0\2\2\u09be\u09c0\7\u008e\2\2\u09bf\u09be\3\2\2\2\u09bf\u09c0"+
		"\3\2\2\2\u09c0\u09c1\3\2\2\2\u09c1\u09e0\7\u0169\2\2\u09c2\u09c3\7\u00d6"+
		"\2\2\u09c3\u09c7\7\u0169\2\2\u09c4\u09c5\7\u00da\2\2\u09c5\u09c7\7\u00d6"+
		"\2\2\u09c6\u09c2\3\2\2\2\u09c6\u09c4\3\2\2\2\u09c7\u09e0\3\2\2\2\u09c8"+
		"\u09c9\7\u00d1\2\2\u09c9\u09cd\5\u00c4c\2\u09ca\u09cb\7\u00da\2\2\u09cb"+
		"\u09cd\7\u00d1\2\2\u09cc\u09c8\3\2\2\2\u09cc\u09ca\3\2\2\2\u09cd\u09e0"+
		"\3\2\2\2\u09ce\u09d0\7\u0100\2\2\u09cf\u09d1\7\u0087\2\2\u09d0\u09cf\3"+
		"\2\2\2\u09d0\u09d1\3\2\2\2\u09d1\u09d2\3\2\2\2\u09d2\u09e0\7\u0169\2\2"+
		"\u09d3\u09d4\7\u008f\2\2\u09d4\u09e0\7\u0169\2\2\u09d5\u09d7\7\u00da\2"+
		"\2\u09d6\u09d5\3\2\2\2\u09d6\u09d7\3\2\2\2\u09d7\u09d8\3\2\2\2\u09d8\u09e0"+
		"\7\u00a2\2\2\u09d9\u09da\7Y\2\2\u09da\u09dd\7\u008e\2\2\u09db\u09de\5"+
		"\u01a6\u00d4\2\u09dc\u09de\7\u00db\2\2\u09dd\u09db\3\2\2\2\u09dd\u09dc"+
		"\3\2\2\2\u09de\u09e0\3\2\2\2\u09df\u09bd\3\2\2\2\u09df\u09c6\3\2\2\2\u09df"+
		"\u09cc\3\2\2\2\u09df\u09ce\3\2\2\2\u09df\u09d3\3\2\2\2\u09df\u09d6\3\2"+
		"\2\2\u09df\u09d9\3\2\2\2\u09e0U\3\2\2\2\u09e1\u09e2\7\31\2\2\u09e2\u09e3"+
		"\7j\2\2\u09e3\u09e6\5\u00a4S\2\u09e4\u09e5\7\r\2\2\u09e5\u09e7\5\u00a4"+
		"S\2\u09e6\u09e4\3\2\2\2\u09e6\u09e7\3\2\2\2\u09e7\u09eb\3\2\2\2\u09e8"+
		"\u09ea\5\2\2\2\u09e9\u09e8\3\2\2\2\u09ea\u09ed\3\2\2\2\u09eb\u09e9\3\2"+
		"\2\2\u09eb\u09ec\3\2\2\2\u09ec\u0a0a\3\2\2\2\u09ed\u09eb\3\2\2\2\u09ee"+
		"\u09ef\7\31\2\2\u09ef\u09f0\7j\2\2\u09f0\u09f1\7\r\2\2\u09f1\u09f5\5\u00a4"+
		"S\2\u09f2\u09f4\5\2\2\2\u09f3\u09f2\3\2\2\2\u09f4\u09f7\3\2\2\2\u09f5"+
		"\u09f3\3\2\2\2\u09f5\u09f6\3\2\2\2\u09f6\u0a0a\3\2\2\2\u09f7\u09f5\3\2"+
		"\2\2\u09f8\u09f9\7\31\2\2\u09f9\u09fa\7j\2\2\u09fa\u09fb\78\2\2\u09fb"+
		"\u09fc\7P\2\2\u09fc\u09fd\7\u00b1\2\2\u09fd\u0a00\5\u00a4S\2\u09fe\u09ff"+
		"\7\r\2\2\u09ff\u0a01\5\u00a4S\2\u0a00\u09fe\3\2\2\2\u0a00\u0a01\3\2\2"+
		"\2\u0a01\u0a0a\3\2\2\2\u0a02\u0a03\7\31\2\2\u0a03\u0a04\7j\2\2\u0a04\u0a05"+
		"\78\2\2\u0a05\u0a06\7P\2\2\u0a06\u0a07\7\u00b1\2\2\u0a07\u0a08\7\r\2\2"+
		"\u0a08\u0a0a\5\u00a4S\2\u0a09\u09e1\3\2\2\2\u0a09\u09ee\3\2\2\2\u0a09"+
		"\u09f8\3\2\2\2\u0a09\u0a02\3\2\2\2\u0a0aW\3\2\2\2\u0a0b\u0a0e\7\31\2\2"+
		"\u0a0c\u0a0d\7W\2\2\u0a0d\u0a0f\7d\2\2\u0a0e\u0a0c\3\2\2\2\u0a0e\u0a0f"+
		"\3\2\2\2\u0a0f\u0a11\3\2\2\2\u0a10\u0a12\t\24\2\2\u0a11\u0a10\3\2\2\2"+
		"\u0a11\u0a12\3\2\2\2\u0a12\u0a13\3\2\2\2\u0a13\u0a14\7\u0084\2\2\u0a14"+
		"\u0a1b\5\u01a6\u00d4\2\u0a15\u0a17\5\u00a4S\2\u0a16\u0a18\7\u0153\2\2"+
		"\u0a17\u0a16\3\2\2\2\u0a17\u0a18\3\2\2\2\u0a18\u0a1a\3\2\2\2\u0a19\u0a15"+
		"\3\2\2\2\u0a1a\u0a1d\3\2\2\2\u0a1b\u0a19\3\2\2\2\u0a1b\u0a1c\3\2\2\2\u0a1c"+
		"\u0a2b\3\2\2\2\u0a1d\u0a1b\3\2\2\2\u0a1e\u0a1f\7\u0087\2\2\u0a1f\u0a25"+
		"\7\u015a\2\2\u0a20\u0a23\5\u00a4S\2\u0a21\u0a22\7\u0150\2\2\u0a22\u0a24"+
		"\5\u00a4S\2\u0a23\u0a21\3\2\2\2\u0a23\u0a24\3\2\2\2\u0a24\u0a26\3\2\2"+
		"\2\u0a25\u0a20\3\2\2\2\u0a26\u0a27\3\2\2\2\u0a27\u0a25\3\2\2\2\u0a27\u0a28"+
		"\3\2\2\2\u0a28\u0a29\3\2\2\2\u0a29\u0a2a\7\u015b\2\2\u0a2a\u0a2c\3\2\2"+
		"\2\u0a2b\u0a1e\3\2\2\2\u0a2b\u0a2c\3\2\2\2\u0a2c\u0a2d\3\2\2\2\u0a2d\u0a2e"+
		"\7\6\2\2\u0a2e\u0a2f\5\u01a8\u00d5\2\u0a2fY\3\2\2\2\u0a30\u0a36\7\31\2"+
		"\2\u0a31\u0a33\t\25\2\2\u0a32\u0a31\3\2\2\2\u0a32\u0a33\3\2\2\2\u0a33"+
		"\u0a34\3\2\2\2\u0a34\u0a37\t\24\2\2\u0a35\u0a37\7\u0113\2\2\u0a36\u0a32"+
		"\3\2\2\2\u0a36\u0a35\3\2\2\2\u0a36\u0a37\3\2\2\2\u0a37\u0a38\3\2\2\2\u0a38"+
		"\u0a3c\7t\2\2\u0a39\u0a3a\78\2\2\u0a3a\u0a3b\7P\2\2\u0a3b\u0a3d\7\u00b1"+
		"\2\2\u0a3c\u0a39\3\2\2\2\u0a3c\u0a3d\3\2\2\2\u0a3d\u0a3e\3\2\2\2\u0a3e"+
		"\u0a3f\5\u01a6\u00d4\2\u0a3f\u0a48\7\u015a\2\2\u0a40\u0a45\5\\/\2\u0a41"+
		"\u0a42\7\u0153\2\2\u0a42\u0a44\5\\/\2\u0a43\u0a41\3\2\2\2\u0a44\u0a47"+
		"\3\2\2\2\u0a45\u0a43\3\2\2\2\u0a45\u0a46\3\2\2\2\u0a46\u0a49\3\2\2\2\u0a47"+
		"\u0a45\3\2\2\2\u0a48\u0a40\3\2\2\2\u0a48\u0a49\3\2\2\2\u0a49\u0a4a\3\2"+
		"\2\2\u0a4a\u0a57\7\u015b\2\2\u0a4b\u0a4c\7>\2\2\u0a4c\u0a51\7\u015a\2"+
		"\2\u0a4d\u0a4f\5\u01a6\u00d4\2\u0a4e\u0a50\7\u0153\2\2\u0a4f\u0a4e\3\2"+
		"\2\2\u0a4f\u0a50\3\2\2\2\u0a50\u0a52\3\2\2\2\u0a51\u0a4d\3\2\2\2\u0a52"+
		"\u0a53\3\2\2\2\u0a53\u0a51\3\2\2\2\u0a53\u0a54\3\2\2\2\u0a54\u0a55\3\2"+
		"\2\2\u0a55\u0a56\7\u015b\2\2\u0a56\u0a58\3\2\2\2\u0a57\u0a4b\3\2\2\2\u0a57"+
		"\u0a58\3\2\2\2\u0a58\u0a59\3\2\2\2\u0a59\u0a5a\5l\67\2\u0a5a\u0a5b\5n"+
		"8\2\u0a5b\u0a5c\5p9\2\u0a5c\u0a94\3\2\2\2\u0a5d\u0a63\7\31\2\2\u0a5e\u0a60"+
		"\t\25\2\2\u0a5f\u0a5e\3\2\2\2\u0a5f\u0a60\3\2\2\2\u0a60\u0a61\3\2\2\2"+
		"\u0a61\u0a64\t\24\2\2\u0a62\u0a64\7\u0113\2\2\u0a63\u0a5f\3\2\2\2\u0a63"+
		"\u0a62\3\2\2\2\u0a63\u0a64\3\2\2\2\u0a64\u0a65\3\2\2\2\u0a65\u0a69\7t"+
		"\2\2\u0a66\u0a67\78\2\2\u0a67\u0a68\7P\2\2\u0a68\u0a6a\7\u00b1\2\2\u0a69"+
		"\u0a66\3\2\2\2\u0a69\u0a6a\3\2\2\2\u0a6a\u0a6b\3\2\2\2\u0a6b\u0a6c\5\u01a6"+
		"\u00d4\2\u0a6c\u0a6d\7R\2\2\u0a6d\u0a8d\5\u00a4S\2\u0a6e\u0a79\7\u015a"+
		"\2\2\u0a6f\u0a70\5\u00a4S\2\u0a70\u0a71\7\u0087\2\2\u0a71\u0a75\7\u00e3"+
		"\2\2\u0a72\u0a74\5d\63\2\u0a73\u0a72\3\2\2\2\u0a74\u0a77\3\2\2\2\u0a75"+
		"\u0a73\3\2\2\2\u0a75\u0a76\3\2\2\2\u0a76\u0a7a\3\2\2\2\u0a77\u0a75\3\2"+
		"\2\2\u0a78\u0a7a\5b\62\2\u0a79\u0a6f\3\2\2\2\u0a79\u0a78\3\2\2\2\u0a7a"+
		"\u0a88\3\2\2\2\u0a7b\u0a7c\7\u0153\2\2\u0a7c\u0a7d\5\u00a4S\2\u0a7d\u0a7e"+
		"\7\u0087\2\2\u0a7e\u0a82\7\u00e3\2\2\u0a7f\u0a81\5d\63\2\u0a80\u0a7f\3"+
		"\2\2\2\u0a81\u0a84\3\2\2\2\u0a82\u0a80\3\2\2\2\u0a82\u0a83\3\2\2\2\u0a83"+
		"\u0a87\3\2\2\2\u0a84\u0a82\3\2\2\2\u0a85\u0a87\5b\62\2\u0a86\u0a7b\3\2"+
		"\2\2\u0a86\u0a85\3\2\2\2\u0a87\u0a8a\3\2\2\2\u0a88\u0a86\3\2\2\2\u0a88"+
		"\u0a89\3\2\2\2\u0a89\u0a8b\3\2\2\2\u0a8a\u0a88\3\2\2\2\u0a8b\u0a8c\7\u015b"+
		"\2\2\u0a8c\u0a8e\3\2\2\2\u0a8d\u0a6e\3\2\2\2\u0a8d\u0a8e\3\2\2\2\u0a8e"+
		"\u0a8f\3\2\2\2\u0a8f\u0a90\5l\67\2\u0a90\u0a91\5n8\2\u0a91\u0a92\5p9\2"+
		"\u0a92\u0a94\3\2\2\2\u0a93\u0a30\3\2\2\2\u0a93\u0a5d\3\2\2\2\u0a94[\3"+
		"\2\2\2\u0a95\u0aa0\5^\60\2\u0a96\u0aa0\5b\62\2\u0a97\u0a98\7L\2\2\u0a98"+
		"\u0a9c\5\u00a4S\2\u0a99\u0a9b\5`\61\2\u0a9a\u0a99\3\2\2\2\u0a9b\u0a9e"+
		"\3\2\2\2\u0a9c\u0a9a\3\2\2\2\u0a9c\u0a9d\3\2\2\2\u0a9d\u0aa0\3\2\2\2\u0a9e"+
		"\u0a9c\3\2\2\2\u0a9f\u0a95\3\2\2\2\u0a9f\u0a96\3\2\2\2\u0a9f\u0a97\3\2"+
		"\2\2\u0aa0]\3\2\2\2\u0aa1\u0aa4\5\u00a4S\2\u0aa2\u0aa5\5\u00b4[\2\u0aa3"+
		"\u0aa5\5\u01a6\u00d4\2\u0aa4\u0aa2\3\2\2\2\u0aa4\u0aa3\3\2\2\2\u0aa5\u0aa8"+
		"\3\2\2\2\u0aa6\u0aa7\7\23\2\2\u0aa7\u0aa9\5\u00a4S\2\u0aa8\u0aa6\3\2\2"+
		"\2\u0aa8\u0aa9\3\2\2\2\u0aa9\u0aad\3\2\2\2\u0aaa\u0aac\5d\63\2\u0aab\u0aaa"+
		"\3\2\2\2\u0aac\u0aaf\3\2\2\2\u0aad\u0aab\3\2\2\2\u0aad\u0aae\3\2\2\2\u0aae"+
		"_\3\2\2\2\u0aaf\u0aad\3\2\2\2\u0ab0\u0ab1\t\26\2\2\u0ab1\u0ab2\t\27\2"+
		"\2\u0ab2a\3\2\2\2\u0ab3\u0ab4\7\26\2\2\u0ab4\u0ab6\5\u00a4S\2\u0ab5\u0ab3"+
		"\3\2\2\2\u0ab5\u0ab6\3\2\2\2\u0ab6\u0b1a\3\2\2\2\u0ab7\u0b1b\5f\64\2\u0ab8"+
		"\u0ab9\7~\2\2\u0ab9\u0aba\7\u015a\2\2\u0aba\u0abf\5\u00a4S\2\u0abb\u0abc"+
		"\7\u0153\2\2\u0abc\u0abe\5\u00a4S\2\u0abd\u0abb\3\2\2\2\u0abe\u0ac1\3"+
		"\2\2\2\u0abf\u0abd\3\2\2\2\u0abf\u0ac0\3\2\2\2\u0ac0\u0ac2\3\2\2\2\u0ac1"+
		"\u0abf\3\2\2\2\u0ac2\u0ac3\7\u015b\2\2\u0ac3\u0ac4\5t;\2\u0ac4\u0b1b\3"+
		"\2\2\2\u0ac5\u0ac6\7\\\2\2\u0ac6\u0ac7\7I\2\2\u0ac7\u0ac8\7\u015a\2\2"+
		"\u0ac8\u0acd\5\u00a4S\2\u0ac9\u0aca\7\u0153\2\2\u0aca\u0acc\5\u00a4S\2"+
		"\u0acb\u0ac9\3\2\2\2\u0acc\u0acf\3\2\2\2\u0acd\u0acb\3\2\2\2\u0acd\u0ace"+
		"\3\2\2\2\u0ace\u0ad0\3\2\2\2\u0acf\u0acd\3\2\2\2\u0ad0\u0ad1\7\u015b\2"+
		"\2\u0ad1\u0ad2\5t;\2\u0ad2\u0b1b\3\2\2\2\u0ad3\u0ad6\7(\2\2\u0ad4\u0ad5"+
		"\7\u0081\2\2\u0ad5\u0ad7\5\u00a4S\2\u0ad6\u0ad4\3\2\2\2\u0ad6\u0ad7\3"+
		"\2\2\2\u0ad7\u0ad8\3\2\2\2\u0ad8\u0ad9\7\u015a\2\2\u0ad9\u0ada\5\u00a4"+
		"S\2\u0ada\u0adb\7\u0087\2\2\u0adb\u0ae0\5\u00a4S\2\u0adc\u0add\7\u0153"+
		"\2\2\u0add\u0adf\5\u00a4S\2\u0ade\u0adc\3\2\2\2\u0adf\u0ae2\3\2\2\2\u0ae0"+
		"\u0ade\3\2\2\2\u0ae0\u0ae1\3\2\2\2\u0ae1\u0ae3\3\2\2\2\u0ae2\u0ae0\3\2"+
		"\2\2\u0ae3\u0ae4\7\u015b\2\2\u0ae4\u0aea\5t;\2\u0ae5\u0ae6\7\u0086\2\2"+
		"\u0ae6\u0ae7\7\u015a\2\2\u0ae7\u0ae8\5\u00a4S\2\u0ae8\u0ae9\7\u015b\2"+
		"\2\u0ae9\u0aeb\3\2\2\2\u0aea\u0ae5\3\2\2\2\u0aea\u0aeb\3\2\2\2\u0aeb\u0b1b"+
		"\3\2\2\2\u0aec\u0aed\7.\2\2\u0aed\u0aee\7I\2\2\u0aee\u0aef\7\u015a\2\2"+
		"\u0aef\u0af4\5\u00a4S\2\u0af0\u0af1\7\u0153\2\2\u0af1\u0af3\5\u00a4S\2"+
		"\u0af2\u0af0\3\2\2\2\u0af3\u0af6\3\2\2\2\u0af4\u0af2\3\2\2\2\u0af4\u0af5"+
		"\3\2\2\2\u0af5\u0af7\3\2\2\2\u0af6\u0af4\3\2\2\2\u0af7\u0af8\7\u015b\2"+
		"\2\u0af8\u0af9\7c\2\2\u0af9\u0b05\5\u01a6\u00d4\2\u0afa\u0afb\7\u015a"+
		"\2\2\u0afb\u0b00\5\u00a4S\2\u0afc\u0afd\7\u0153\2\2\u0afd\u0aff\5\u00a4"+
		"S\2\u0afe\u0afc\3\2\2\2\u0aff\u0b02\3\2\2\2\u0b00\u0afe\3\2\2\2\u0b00"+
		"\u0b01\3\2\2\2\u0b01\u0b03\3\2\2\2\u0b02\u0b00\3\2\2\2\u0b03\u0b04\7\u015b"+
		"\2\2\u0b04\u0b06\3\2\2\2\u0b05\u0afa\3\2\2\2\u0b05\u0b06\3\2\2\2\u0b06"+
		"\u0b17\3\2\2\2\u0b07\u0b08\7\u00cf\2\2\u0b08\u0b0e\7/\2\2\u0b09\u0b0a"+
		"\7\u00cf\2\2\u0b0a\u0b0e\7\u00e7\2\2\u0b0b\u0b0c\7\u00cf\2\2\u0b0c\u0b0e"+
		"\7\u00fe\2\2\u0b0d\u0b07\3\2\2\2\u0b0d\u0b09\3\2\2\2\u0b0d\u0b0b\3\2\2"+
		"\2\u0b0e\u0b16\3\2\2\2\u0b0f\u0b10\7\u00e0\2\2\u0b10\u0b11\7 \2\2\u0b11"+
		"\u0b16\5r:\2\u0b12\u0b13\7\u00e0\2\2\u0b13\u0b14\7\177\2\2\u0b14\u0b16"+
		"\5r:\2\u0b15\u0b0d\3\2\2\2\u0b15\u0b0f\3\2\2\2\u0b15\u0b12\3\2\2\2\u0b16"+
		"\u0b19\3\2\2\2\u0b17\u0b15\3\2\2\2\u0b17\u0b18\3\2\2\2\u0b18\u0b1b\3\2"+
		"\2\2\u0b19\u0b17\3\2\2\2\u0b1a\u0ab7\3\2\2\2\u0b1a\u0ab8\3\2\2\2\u0b1a"+
		"\u0ac5\3\2\2\2\u0b1a\u0ad3\3\2\2\2\u0b1a\u0aec\3\2\2\2\u0b1b\u0b1f\3\2"+
		"\2\2\u0b1c\u0b20\7\36\2\2\u0b1d\u0b1e\7P\2\2\u0b1e\u0b20\7\36\2\2\u0b1f"+
		"\u0b1c\3\2\2\2\u0b1f\u0b1d\3\2\2\2\u0b1f\u0b20\3\2\2\2\u0b20\u0b25\3\2"+
		"\2\2\u0b21\u0b22\7?\2\2\u0b22\u0b26\7\37\2\2\u0b23\u0b24\7?\2\2\u0b24"+
		"\u0b26\7:\2\2\u0b25\u0b21\3\2\2\2\u0b25\u0b23\3\2\2\2\u0b25\u0b26\3\2"+
		"\2\2\u0b26c\3\2\2\2\u0b27\u0b28\7\26\2\2\u0b28\u0b2a\5\u00a4S\2\u0b29"+
		"\u0b27\3\2\2\2\u0b29\u0b2a\3\2\2\2\u0b2a\u0b4e\3\2\2\2\u0b2b\u0b2c\7P"+
		"\2\2\u0b2c\u0b4f\7Q\2\2\u0b2d\u0b4f\7Q\2\2\u0b2e\u0b4f\5f\64\2\u0b2f\u0b32"+
		"\7\34\2\2\u0b30\u0b33\5\u00b4[\2\u0b31\u0b33\5\u0104\u0083\2\u0b32\u0b30"+
		"\3\2\2\2\u0b32\u0b31\3\2\2\2\u0b33\u0b4f\3\2\2\2\u0b34\u0b35\7~\2\2\u0b35"+
		"\u0b4f\5t;\2\u0b36\u0b37\7\\\2\2\u0b37\u0b38\7I\2\2\u0b38\u0b4f\5t;\2"+
		"\u0b39\u0b3a\7c\2\2\u0b3a\u0b3b\5\u01a6\u00d4\2\u0b3b\u0b42\5\u00a4S\2"+
		"\u0b3c\u0b3d\7\u00cf\2\2\u0b3d\u0b43\7/\2\2\u0b3e\u0b3f\7\u00cf\2\2\u0b3f"+
		"\u0b43\7\u00e7\2\2\u0b40\u0b41\7\u00cf\2\2\u0b41\u0b43\7\u00fe\2\2\u0b42"+
		"\u0b3c\3\2\2\2\u0b42\u0b3e\3\2\2\2\u0b42\u0b40\3\2\2\2\u0b42\u0b43\3\2"+
		"\2\2\u0b43\u0b47\3\2\2\2\u0b44\u0b45\7\u00e0\2\2\u0b45\u0b46\7 \2\2\u0b46"+
		"\u0b48\5r:\2\u0b47\u0b44\3\2\2\2\u0b47\u0b48\3\2\2\2\u0b48\u0b4c\3\2\2"+
		"\2\u0b49\u0b4a\7\u00e0\2\2\u0b4a\u0b4b\7\177\2\2\u0b4b\u0b4d\5r:\2\u0b4c"+
		"\u0b49\3\2\2\2\u0b4c\u0b4d\3\2\2\2\u0b4d\u0b4f\3\2\2\2\u0b4e\u0b2b\3\2"+
		"\2\2\u0b4e\u0b2d\3\2\2\2\u0b4e\u0b2e\3\2\2\2\u0b4e\u0b2f\3\2\2\2\u0b4e"+
		"\u0b34\3\2\2\2\u0b4e\u0b36\3\2\2\2\u0b4e\u0b39\3\2\2\2\u0b4f\u0b53\3\2"+
		"\2\2\u0b50\u0b54\7\36\2\2\u0b51\u0b52\7P\2\2\u0b52\u0b54\7\36\2\2\u0b53"+
		"\u0b50\3\2\2\2\u0b53\u0b51\3\2\2\2\u0b53\u0b54\3\2\2\2\u0b54\u0b59\3\2"+
		"\2\2\u0b55\u0b56\7?\2\2\u0b56\u0b5a\7\37\2\2\u0b57\u0b58\7?\2\2\u0b58"+
		"\u0b5a\7:\2\2\u0b59\u0b55\3\2\2\2\u0b59\u0b57\3\2\2\2\u0b59\u0b5a\3\2"+
		"\2\2\u0b5ae\3\2\2\2\u0b5b\u0b5d\7\u0094\2\2\u0b5c\u0b5e\7\u015a\2\2\u0b5d"+
		"\u0b5c\3\2\2\2\u0b5e\u0b5f\3\2\2\2\u0b5f\u0b5d\3\2\2\2\u0b5f\u0b60\3\2"+
		"\2\2\u0b60\u0b61\3\2\2\2\u0b61\u0b63\5\u0104\u0083\2\u0b62\u0b64\7\u015b"+
		"\2\2\u0b63\u0b62\3\2\2\2\u0b64\u0b65\3\2\2\2\u0b65\u0b63\3\2\2\2\u0b65"+
		"\u0b66\3\2\2\2\u0b66g\3\2\2\2\u0b67\u0b70\7\u015a\2\2\u0b68\u0b6b\5\u00a4"+
		"S\2\u0b69\u0b6a\7\u0150\2\2\u0b6a\u0b6c\5\u0104\u0083\2\u0b6b\u0b69\3"+
		"\2\2\2\u0b6b\u0b6c\3\2\2\2\u0b6c\u0b6e\3\2\2\2\u0b6d\u0b6f\7\u0153\2\2"+
		"\u0b6e\u0b6d\3\2\2\2\u0b6e\u0b6f\3\2\2\2\u0b6f\u0b71\3\2\2\2\u0b70\u0b68"+
		"\3\2\2\2\u0b71\u0b72\3\2\2\2\u0b72\u0b70\3\2\2\2\u0b72\u0b73\3\2\2\2\u0b73"+
		"\u0b74\3\2\2\2\u0b74\u0b75\7\u015b\2\2\u0b75i\3\2\2\2\u0b76\u0b77\7\u0087"+
		"\2\2\u0b77\u0b78\5h\65\2\u0b78k\3\2\2\2\u0b79\u0b7f\5j\66\2\u0b7a\u0b7b"+
		"\7\u0087\2\2\u0b7b\u0b7f\7S\2\2\u0b7c\u0b7d\7\u0088\2\2\u0b7d\u0b7f\7"+
		"S\2\2\u0b7e\u0b79\3\2\2\2\u0b7e\u0b7a\3\2\2\2\u0b7e\u0b7c\3\2\2\2\u0b7e"+
		"\u0b7f\3\2\2\2\u0b7fm\3\2\2\2\u0b80\u0b81\7\u00e0\2\2\u0b81\u0b87\7\u009b"+
		"\2\2\u0b82\u0b83\7[\2\2\u0b83\u0b88\7b\2\2\u0b84\u0b85\7 \2\2\u0b85\u0b88"+
		"\7b\2\2\u0b86\u0b88\7\u00ac\2\2\u0b87\u0b82\3\2\2\2\u0b87\u0b84\3\2\2"+
		"\2\u0b87\u0b86\3\2\2\2\u0b88\u0b8a\3\2\2\2\u0b89\u0b80\3\2\2\2\u0b89\u0b8a"+
		"\3\2\2\2\u0b8ao\3\2\2\2\u0b8b\u0b8c\7\u0107\2\2\u0b8c\u0b8e\5\u00a4S\2"+
		"\u0b8d\u0b8b\3\2\2\2\u0b8d\u0b8e\3\2\2\2\u0b8eq\3\2\2\2\u0b8f\u0b96\7"+
		"e\2\2\u0b90\u0b96\7\21\2\2\u0b91\u0b92\7\u00fc\2\2\u0b92\u0b96\7Q\2\2"+
		"\u0b93\u0b94\7\u00fc\2\2\u0b94\u0b96\7\34\2\2\u0b95\u0b8f\3\2\2\2\u0b95"+
		"\u0b90\3\2\2\2\u0b95\u0b91\3\2\2\2\u0b95\u0b93\3\2\2\2\u0b96s\3\2\2\2"+
		"\u0b97\u0b99\5j\66\2\u0b98\u0b97\3\2\2\2\u0b98\u0b99\3\2\2\2\u0b99\u0b9e"+
		"\3\2\2\2\u0b9a\u0b9b\7\u0081\2\2\u0b9b\u0b9c\7\u00be\2\2\u0b9c\u0b9d\7"+
		"\u0107\2\2\u0b9d\u0b9f\5\u00a4S\2\u0b9e\u0b9a\3\2\2\2\u0b9e\u0b9f\3\2"+
		"\2\2\u0b9fu\3\2\2\2\u0ba0\u0ba1\7\u015a\2\2\u0ba1\u0ba6\5x=\2\u0ba2\u0ba3"+
		"\7\u0153\2\2\u0ba3\u0ba5\5x=\2\u0ba4\u0ba2\3\2\2\2\u0ba5\u0ba8\3\2\2\2"+
		"\u0ba6\u0ba4\3\2\2\2\u0ba6\u0ba7\3\2\2\2\u0ba7\u0ba9\3\2\2\2\u0ba8\u0ba6"+
		"\3\2\2\2\u0ba9\u0baa\7\u015b\2\2\u0baaw\3\2\2\2\u0bab\u0bac\5\u00a4S\2"+
		"\u0bac\u0bad\5z>\2\u0bady\3\2\2\2\u0bae\u0baf\5\u00b4[\2\u0baf{\3\2\2"+
		"\2\u0bb0\u0bb1\7\u0087\2\2\u0bb1\u0bb2\7\u015a\2\2\u0bb2\u0bb7\5~@\2\u0bb3"+
		"\u0bb4\7\u0153\2\2\u0bb4\u0bb6\5~@\2\u0bb5\u0bb3\3\2\2\2\u0bb6\u0bb9\3"+
		"\2\2\2\u0bb7\u0bb5\3\2\2\2\u0bb7\u0bb8\3\2\2\2\u0bb8\u0bba\3\2\2\2\u0bb9"+
		"\u0bb7\3\2\2\2\u0bba\u0bbb\7\u015b\2\2\u0bbb}\3\2\2\2\u0bbc\u0bbd\5\u00a4"+
		"S\2\u0bbd\u0bbe\7\u0150\2\2\u0bbe\u0bbf\5\u010a\u0086\2\u0bbf\177\3\2"+
		"\2\2\u0bc0\u0bc1\7\u0081\2\2\u0bc1\u0bc2\5\u00a4S\2\u0bc2\u0081\3\2\2"+
		"\2\u0bc3\u0bc4\7\u0107\2\2\u0bc4\u0bc5\5\u0084C\2\u0bc5\u0083\3\2\2\2"+
		"\u0bc6\u0bc7\5\u00a4S\2\u0bc7\u0085\3\2\2\2\u0bc8\u0bcd\5\u0088E\2\u0bc9"+
		"\u0bcd\5\u008eH\2\u0bca\u0bcd\5\u0096L\2\u0bcb\u0bcd\5\u009cO\2\u0bcc"+
		"\u0bc8\3\2\2\2\u0bcc\u0bc9\3\2\2\2\u0bcc\u0bca\3\2\2\2\u0bcc\u0bcb\3\2"+
		"\2\2\u0bcd\u0087\3\2\2\2\u0bce\u0bcf\7\u00e8\2\2\u0bcf\u0bd0\7\u008e\2"+
		"\2\u0bd0\u0bd1\7\u00ef\2\2\u0bd1\u0bd2\7\u015a\2\2\u0bd2\u0bd3\5\u01ba"+
		"\u00de\2\u0bd3\u0bd4\7\u015b\2\2\u0bd4\u0bd5\7\u015a\2\2\u0bd5\u0bd6\5"+
		"\u008aF\2\u0bd6\u0bd7\7\u015b\2\2\u0bd7\u0089\3\2\2\2\u0bd8\u0bdd\5\u008c"+
		"G\2\u0bd9\u0bda\7\u0153\2\2\u0bda\u0bdc\5\u008cG\2\u0bdb\u0bd9\3\2\2\2"+
		"\u0bdc\u0bdf\3\2\2\2\u0bdd\u0bdb\3\2\2\2\u0bdd\u0bde\3\2\2\2\u0bde\u008b"+
		"\3\2\2\2\u0bdf\u0bdd\3\2\2\2\u0be0\u0be1\7\u00e8\2\2\u0be1\u0be2\5\u00a0"+
		"Q\2\u0be2\u0be3\7\u0117\2\2\u0be3\u0be4\7\u00cb\2\2\u0be4\u0bf0\7\u010a"+
		"\2\2\u0be5\u0be6\7\u015a\2\2\u0be6\u0be7\5\u0104\u0083\2\u0be7\u0be8\7"+
		"\u015b\2\2\u0be8\u0bf1\3\2\2\2\u0be9\u0beb\7\u015a\2\2\u0bea\u0be9\3\2"+
		"\2\2\u0bea\u0beb\3\2\2\2\u0beb\u0bec\3\2\2\2\u0bec\u0bee\7\u00d1\2\2\u0bed"+
		"\u0bef\7\u015b\2\2\u0bee\u0bed\3\2\2\2\u0bee\u0bef\3\2\2\2\u0bef\u0bf1"+
		"\3\2\2\2\u0bf0\u0be5\3\2\2\2\u0bf0\u0bea\3\2\2\2\u0bf1\u008d\3\2\2\2\u0bf2"+
		"\u0bf3\7\u00e8\2\2\u0bf3\u0bf4\7\u008e\2\2\u0bf4\u0bf5\7\u00bb\2\2\u0bf5"+
		"\u0bf6\7\u015a\2\2\u0bf6\u0bf7\5\u01ba\u00de\2\u0bf7\u0bfd\7\u015b\2\2"+
		"\u0bf8\u0bf9\7\u015a\2\2\u0bf9\u0bfa\5\u0090I\2\u0bfa\u0bfb\7\u015b\2"+
		"\2\u0bfb\u0bfe\3\2\2\2\u0bfc\u0bfe\5\u0094K\2\u0bfd\u0bf8\3\2\2\2\u0bfd"+
		"\u0bfc\3\2\2\2\u0bfe\u008f\3\2\2\2\u0bff\u0c04\5\u0092J\2\u0c00\u0c01"+
		"\7\u0153\2\2\u0c01\u0c03\5\u0092J\2\u0c02\u0c00\3\2\2\2\u0c03\u0c06\3"+
		"\2\2\2\u0c04\u0c02\3\2\2\2\u0c04\u0c05\3\2\2\2\u0c05\u0091\3\2\2\2\u0c06"+
		"\u0c04\3\2\2\2\u0c07\u0c08\7\u00e8\2\2\u0c08\u0c09\5\u00a0Q\2\u0c09\u0093"+
		"\3\2\2\2\u0c0a\u0c0b\7\u00e9\2\2\u0c0b\u0c0c\5\u010a\u0086\2\u0c0c\u0095"+
		"\3\2\2\2\u0c0d\u0c0e\7\u00e8\2\2\u0c0e\u0c0f\7\u008e\2\2\u0c0f\u0c10\7"+
		"\u00cc\2\2\u0c10\u0c11\7\u015a\2\2\u0c11\u0c12\5\u01ba\u00de\2\u0c12\u0c13"+
		"\7\u015b\2\2\u0c13\u0c14\7\u015a\2\2\u0c14\u0c15\5\u0098M\2\u0c15\u0c16"+
		"\7\u015b\2\2\u0c16\u0097\3\2\2\2\u0c17\u0c1c\5\u009aN\2\u0c18\u0c19\7"+
		"\u0153\2\2\u0c19\u0c1b\5\u009aN\2\u0c1a\u0c18\3\2\2\2\u0c1b\u0c1e\3\2"+
		"\2\2\u0c1c\u0c1a\3\2\2\2\u0c1c\u0c1d\3\2\2\2\u0c1d\u0099\3\2\2\2\u0c1e"+
		"\u0c1c\3\2\2\2\u0c1f\u0c20\7\u00e8\2\2\u0c20\u0c21\5\u00a0Q\2\u0c21\u0c23"+
		"\7\u0117\2\2\u0c22\u0c24\7<\2\2\u0c23\u0c22\3\2\2\2\u0c23\u0c24\3\2\2"+
		"\2\u0c24\u0c25\3\2\2\2\u0c25\u0c26\7\u015a\2\2\u0c26\u0c27\5\u01d2\u00ea"+
		"\2\u0c27\u0c28\7\u015b\2\2\u0c28\u009b\3\2\2\2\u0c29\u0c2a\7\u00e8\2\2"+
		"\u0c2a\u0c2b\7\u008e\2\2\u0c2b\u0c2c\7\u0098\2\2\u0c2c\u0c2d\5v<\2\u0c2d"+
		"\u009d\3\2\2\2\u0c2e\u0c2f\7\u00e8\2\2\u0c2f\u0c30\7\u008e\2\2\u0c30\u0c35"+
		"\5\u01a6\u00d4\2\u0c31\u0c32\7\u0153\2\2\u0c32\u0c34\5\u01a6\u00d4\2\u0c33"+
		"\u0c31\3\2\2\2\u0c34\u0c37\3\2\2\2\u0c35\u0c33\3\2\2\2\u0c35\u0c36\3\2"+
		"\2\2\u0c36\u009f\3\2\2\2\u0c37\u0c35\3\2\2\2\u0c38\u0c39\5\u00a4S\2\u0c39"+
		"\u00a1\3\2\2\2\u0c3a\u0c3b\7\u00ac\2\2\u0c3b\u0c3c\7t\2\2\u0c3c\u0c3e"+
		"\5\u01a6\u00d4\2\u0c3d\u0c3f\7\u00ed\2\2\u0c3e\u0c3d\3\2\2\2\u0c3e\u0c3f"+
		"\3\2\2\2\u0c3f\u00a3\3\2\2\2\u0c40\u0c4a\7\u016d\2\2\u0c41\u0c4a\7\u016e"+
		"\2\2\u0c42\u0c44\7\u0165\2\2\u0c43\u0c42\3\2\2\2\u0c43\u0c44\3\2\2\2\u0c44"+
		"\u0c45\3\2\2\2\u0c45\u0c47\5\u00a6T\2\u0c46\u0c48\7\u0165\2\2\u0c47\u0c46"+
		"\3\2\2\2\u0c47\u0c48\3\2\2\2\u0c48\u0c4a\3\2\2\2\u0c49\u0c40\3\2\2\2\u0c49"+
		"\u0c41\3\2\2\2\u0c49\u0c43\3\2\2\2\u0c4a\u00a5\3\2\2\2\u0c4b\u0c4c\t\30"+
		"\2\2\u0c4c\u00a7\3\2\2\2\u0c4d\u0c50\5\u00dco\2\u0c4e\u0c50\5\u00aaV\2"+
		"\u0c4f\u0c4d\3\2\2\2\u0c4f\u0c4e\3\2\2\2\u0c50\u00a9\3\2\2\2\u0c51\u0c55"+
		"\7\u0170\2\2\u0c52\u0c55\5\u00acW\2\u0c53\u0c55\5\u013e\u00a0\2\u0c54"+
		"\u0c51\3\2\2\2\u0c54\u0c52\3\2\2\2\u0c54\u0c53\3\2\2\2\u0c55\u00ab\3\2"+
		"\2\2\u0c56\u0c5a\5\u00b0Y\2\u0c57\u0c5a\5\u00aeX\2\u0c58\u0c5a\5\u00b2"+
		"Z\2\u0c59\u0c56\3\2\2\2\u0c59\u0c57\3\2\2\2\u0c59\u0c58\3\2\2\2\u0c5a"+
		"\u00ad\3\2\2\2\u0c5b\u0c5c\7\u013c\2\2\u0c5c\u0c5d\7\u0170\2\2\u0c5d\u00af"+
		"\3\2\2\2\u0c5e\u0c5f\7\u013e\2\2\u0c5f\u0c60\7\u0170\2\2\u0c60\u00b1\3"+
		"\2\2\2\u0c61\u0c62\7\u013b\2\2\u0c62\u0c63\7\u0170\2\2\u0c63\u00b3\3\2"+
		"\2\2\u0c64\u0c67\5\u00b6\\\2\u0c65\u0c66\7\u0167\2\2\u0c66\u0c68\7\u0168"+
		"\2\2\u0c67\u0c65\3\2\2\2\u0c67\u0c68\3\2\2\2\u0c68\u0c6c\3\2\2\2\u0c69"+
		"\u0c6a\7o\2\2\u0c6a\u0c6c\5\u00a4S\2\u0c6b\u0c64\3\2\2\2\u0c6b\u0c69\3"+
		"\2\2\2\u0c6c\u00b5\3\2\2\2\u0c6d\u0c7d\5\u00bc_\2\u0c6e\u0c7d\5\u00c0"+
		"a\2\u0c6f\u0c7d\5\u00c2b\2\u0c70\u0c7d\5\u00c4c\2\u0c71\u0c7d\5\u00cc"+
		"g\2\u0c72\u0c7d\5\u00ceh\2\u0c73\u0c7d\5\u00d0i\2\u0c74\u0c7d\5\u00d2"+
		"j\2\u0c75\u0c7d\5\u00ba^\2\u0c76\u0c7d\5\u00b8]\2\u0c77\u0c7d\7\u00f0"+
		"\2\2\u0c78\u0c7d\7z\2\2\u0c79\u0c7d\7\u0141\2\2\u0c7a\u0c7d\7\u0149\2"+
		"\2\u0c7b\u0c7d\7\u0147\2\2\u0c7c\u0c6d\3\2\2\2\u0c7c\u0c6e\3\2\2\2\u0c7c"+
		"\u0c6f\3\2\2\2\u0c7c\u0c70\3\2\2\2\u0c7c\u0c71\3\2\2\2\u0c7c\u0c72\3\2"+
		"\2\2\u0c7c\u0c73\3\2\2\2\u0c7c\u0c74\3\2\2\2\u0c7c\u0c75\3\2\2\2\u0c7c"+
		"\u0c76\3\2\2\2\u0c7c\u0c77\3\2\2\2\u0c7c\u0c78\3\2\2\2\u0c7c\u0c79\3\2"+
		"\2\2\u0c7c\u0c7a\3\2\2\2\u0c7c\u0c7b\3\2\2\2\u0c7d\u00b7\3\2\2\2\u0c7e"+
		"\u0c7f\7\u0132\2\2\u0c7f\u00b9\3\2\2\2\u0c80\u0c81\7\u0146\2\2\u0c81\u00bb"+
		"\3\2\2\2\u0c82\u0c84\7\u0093\2\2\u0c83\u0c85\5\u00be`\2\u0c84\u0c83\3"+
		"\2\2\2\u0c84\u0c85\3\2\2\2\u0c85\u0c9b\3\2\2\2\u0c86\u0c88\7\u0137\2\2"+
		"\u0c87\u0c89\5\u00be`\2\u0c88\u0c87\3\2\2\2\u0c88\u0c89\3\2\2\2\u0c89"+
		"\u0c9b\3\2\2\2\u0c8a\u0c8b\7\u0093\2\2\u0c8b\u0c8d\7\u011a\2\2\u0c8c\u0c8e"+
		"\5\u00be`\2\u0c8d\u0c8c\3\2\2\2\u0c8d\u0c8e\3\2\2\2\u0c8e\u0c9b\3\2\2"+
		"\2\u0c8f\u0c90\7\u0137\2\2\u0c90\u0c92\7\u011a\2\2\u0c91\u0c93\5\u00be"+
		"`\2\u0c92\u0c91\3\2\2\2\u0c92\u0c93\3\2\2\2\u0c93\u0c9b\3\2\2\2\u0c94"+
		"\u0c96\7\u0138\2\2\u0c95\u0c97\5\u00be`\2\u0c96\u0c95\3\2\2\2\u0c96\u0c97"+
		"\3\2\2\2\u0c97\u0c9b\3\2\2\2\u0c98\u0c9b\7\u0140\2\2\u0c99\u0c9b\7\u0148"+
		"\2\2\u0c9a\u0c82\3\2\2\2\u0c9a\u0c86\3\2\2\2\u0c9a\u0c8a\3\2\2\2\u0c9a"+
		"\u0c8f\3\2\2\2\u0c9a\u0c94\3\2\2\2\u0c9a\u0c98\3\2\2\2\u0c9a\u0c99\3\2"+
		"\2\2\u0c9b\u00bd\3\2\2\2\u0c9c\u0c9d\7\u015a\2\2\u0c9d\u0c9e\7\u0169\2"+
		"\2\u0c9e\u0c9f\7\u015b\2\2\u0c9f\u00bf\3\2\2\2\u0ca0\u0ca1\7\u00d9\2\2"+
		"\u0ca1\u0ca3\7\u0093\2\2\u0ca2\u0ca4\5\u00be`\2\u0ca3\u0ca2\3\2\2\2\u0ca3"+
		"\u0ca4\3\2\2\2\u0ca4\u0cc4\3\2\2\2\u0ca5\u0ca6\7\u00d9\2\2\u0ca6\u0ca8"+
		"\7\u0137\2\2\u0ca7\u0ca9\5\u00be`\2\u0ca8\u0ca7\3\2\2\2\u0ca8\u0ca9\3"+
		"\2\2\2\u0ca9\u0cc4\3\2\2\2\u0caa\u0cac\7\u0139\2\2\u0cab\u0cad\5\u00be"+
		"`\2\u0cac\u0cab\3\2\2\2\u0cac\u0cad\3\2\2\2\u0cad\u0cc4\3\2\2\2\u0cae"+
		"\u0caf\7\u00d9\2\2\u0caf\u0cb0\7\u0093\2\2\u0cb0\u0cb2\7\u011a\2\2\u0cb1"+
		"\u0cb3\5\u00be`\2\u0cb2\u0cb1\3\2\2\2\u0cb2\u0cb3\3\2\2\2\u0cb3\u0cc4"+
		"\3\2\2\2\u0cb4\u0cb5\7\u00d9\2\2\u0cb5\u0cb6\7\u0137\2\2\u0cb6\u0cb8\7"+
		"\u011a\2\2\u0cb7\u0cb9\5\u00be`\2\u0cb8\u0cb7\3\2\2\2\u0cb8\u0cb9\3\2"+
		"\2\2\u0cb9\u0cc4\3\2\2\2\u0cba\u0cbb\7\u0139\2\2\u0cbb\u0cbd\7\u011a\2"+
		"\2\u0cbc\u0cbe\5\u00be`\2\u0cbd\u0cbc\3\2\2\2\u0cbd\u0cbe\3\2\2\2\u0cbe"+
		"\u0cc4\3\2\2\2\u0cbf\u0cc1\7\u013a\2\2\u0cc0\u0cc2\5\u00be`\2\u0cc1\u0cc0"+
		"\3\2\2\2\u0cc1\u0cc2\3\2\2\2\u0cc2\u0cc4\3\2\2\2\u0cc3\u0ca0\3\2\2\2\u0cc3"+
		"\u0ca5\3\2\2\2\u0cc3\u0caa\3\2\2\2\u0cc3\u0cae\3\2\2\2\u0cc3\u0cb4\3\2"+
		"\2\2\u0cc3\u0cba\3\2\2\2\u0cc3\u0cbf\3\2\2\2\u0cc4\u00c1\3\2\2\2\u0cc5"+
		"\u0cc7\7\u0144\2\2\u0cc6\u0cc8\5\u00be`\2\u0cc7\u0cc6\3\2\2\2\u0cc7\u0cc8"+
		"\3\2\2\2\u0cc8\u0cce\3\2\2\2\u0cc9\u0ccb\7\u0145\2\2\u0cca\u0ccc\5\u00be"+
		"`\2\u0ccb\u0cca\3\2\2\2\u0ccb\u0ccc\3\2\2\2\u0ccc\u0cce\3\2\2\2\u0ccd"+
		"\u0cc5\3\2\2\2\u0ccd\u0cc9\3\2\2\2\u0cce\u00c3\3\2\2\2\u0ccf\u0cd2\5\u00c6"+
		"d\2\u0cd0\u0cd2\5\u00c8e\2\u0cd1\u0ccf\3\2\2\2\u0cd1\u0cd0\3\2\2\2\u0cd2"+
		"\u00c5\3\2\2\2\u0cd3\u0cd5\7\u0135\2\2\u0cd4\u0cd6\5\u00caf\2\u0cd5\u0cd4"+
		"\3\2\2\2\u0cd5\u0cd6\3\2\2\2\u0cd6\u0ce9\3\2\2\2\u0cd7\u0cd9\7\u0136\2"+
		"\2\u0cd8\u0cda\5\u00caf\2\u0cd9\u0cd8\3\2\2\2\u0cd9\u0cda\3\2\2\2\u0cda"+
		"\u0ce9\3\2\2\2\u0cdb\u0cdd\7\u00a5\2\2\u0cdc\u0cde\5\u00caf\2\u0cdd\u0cdc"+
		"\3\2\2\2\u0cdd\u0cde\3\2\2\2\u0cde\u0ce9\3\2\2\2\u0cdf\u0ce9\7\u0126\2"+
		"\2\u0ce0\u0ce9\7\u012a\2\2\u0ce1\u0ce9\7\u0127\2\2\u0ce2\u0ce9\7\u012b"+
		"\2\2\u0ce3\u0ce9\7\u0128\2\2\u0ce4\u0ce9\7\u012c\2\2\u0ce5\u0ce9\7\u012d"+
		"\2\2\u0ce6\u0ce9\7\u0129\2\2\u0ce7\u0ce9\7\u012e\2\2\u0ce8\u0cd3\3\2\2"+
		"\2\u0ce8\u0cd7\3\2\2\2\u0ce8\u0cdb\3\2\2\2\u0ce8\u0cdf\3\2\2\2\u0ce8\u0ce0"+
		"\3\2\2\2\u0ce8\u0ce1\3\2\2\2\u0ce8\u0ce2\3\2\2\2\u0ce8\u0ce3\3\2\2\2\u0ce8"+
		"\u0ce4\3\2\2\2\u0ce8\u0ce5\3\2\2\2\u0ce8\u0ce6\3\2\2\2\u0ce8\u0ce7\3\2"+
		"\2\2\u0ce9\u00c7\3\2\2\2\u0cea\u0cec\7\u0133\2\2\u0ceb\u0ced\5\u00caf"+
		"\2\u0cec\u0ceb\3\2\2\2\u0cec\u0ced\3\2\2\2\u0ced\u0cf5\3\2\2\2\u0cee\u0cf5"+
		"\7\u012f\2\2\u0cef\u0cf5\7\u0131\2\2\u0cf0\u0cf5\7\u0130\2\2\u0cf1\u0cf5"+
		"\7\u0134\2\2\u0cf2\u0cf3\7\u0134\2\2\u0cf3\u0cf5\7\u00eb\2\2\u0cf4\u0cea"+
		"\3\2\2\2\u0cf4\u0cee\3\2\2\2\u0cf4\u0cef\3\2\2\2\u0cf4\u0cf0\3\2\2\2\u0cf4"+
		"\u0cf1\3\2\2\2\u0cf4\u0cf2\3\2\2\2\u0cf5\u00c9\3\2\2\2\u0cf6\u0cf7\7\u015a"+
		"\2\2\u0cf7\u0cf8\7\u0169\2\2\u0cf8\u0cff\7\u015b\2\2\u0cf9\u0cfa\7\u015a"+
		"\2\2\u0cfa\u0cfb\7\u0169\2\2\u0cfb\u0cfc\7\u0153\2\2\u0cfc\u0cfd\7\u0169"+
		"\2\2\u0cfd\u0cff\7\u015b\2\2\u0cfe\u0cf6\3\2\2\2\u0cfe\u0cf9\3\2\2\2\u0cff"+
		"\u00cb\3\2\2\2\u0d00\u0d01\t\31\2\2\u0d01\u00cd\3\2\2\2\u0d02\u0d12\7"+
		"\u013b\2\2\u0d03\u0d07\7\u013c\2\2\u0d04\u0d05\7\u0087\2\2\u0d05\u0d06"+
		"\7\u013c\2\2\u0d06\u0d08\7\u0121\2\2\u0d07\u0d04\3\2\2\2\u0d07\u0d08\3"+
		"\2\2\2\u0d08\u0d12\3\2\2\2\u0d09\u0d12\7\u013d\2\2\u0d0a\u0d0e\7\u013e"+
		"\2\2\u0d0b\u0d0c\t\32\2\2\u0d0c\u0d0d\7\u013c\2\2\u0d0d\u0d0f\7\u0121"+
		"\2\2\u0d0e\u0d0b\3\2\2\2\u0d0e\u0d0f\3\2\2\2\u0d0f\u0d12\3\2\2\2\u0d10"+
		"\u0d12\7\u013f\2\2\u0d11\u0d02\3\2\2\2\u0d11\u0d03\3\2\2\2\u0d11\u0d09"+
		"\3\2\2\2\u0d11\u0d0a\3\2\2\2\u0d11\u0d10\3\2\2\2\u0d12\u00cf\3\2\2\2\u0d13"+
		"\u0d15\7\u0124\2\2\u0d14\u0d16\5\u00be`\2\u0d15\u0d14\3\2\2\2\u0d15\u0d16"+
		"\3\2\2\2\u0d16\u0d21\3\2\2\2\u0d17\u0d19\7\u0125\2\2\u0d18\u0d1a\5\u00be"+
		"`\2\u0d19\u0d18\3\2\2\2\u0d19\u0d1a\3\2\2\2\u0d1a\u0d21\3\2\2\2\u0d1b"+
		"\u0d1c\7\u0124\2\2\u0d1c\u0d1e\7\u011a\2\2\u0d1d\u0d1f\5\u00be`\2\u0d1e"+
		"\u0d1d\3\2\2\2\u0d1e\u0d1f\3\2\2\2\u0d1f\u0d21\3\2\2\2\u0d20\u0d13\3\2"+
		"\2\2\u0d20\u0d17\3\2\2\2\u0d20\u0d1b\3\2\2\2\u0d21\u00d1\3\2\2\2\u0d22"+
		"\u0d24\7\u0142\2\2\u0d23\u0d25\5\u00be`\2\u0d24\u0d23\3\2\2\2\u0d24\u0d25"+
		"\3\2\2\2\u0d25\u0d30\3\2\2\2\u0d26\u0d27\7\u0142\2\2\u0d27\u0d29\7\u011a"+
		"\2\2\u0d28\u0d2a\5\u00be`\2\u0d29\u0d28\3\2\2\2\u0d29\u0d2a\3\2\2\2\u0d2a"+
		"\u0d30\3\2\2\2\u0d2b\u0d2d\7\u0143\2\2\u0d2c\u0d2e\5\u00be`\2\u0d2d\u0d2c"+
		"\3\2\2\2\u0d2d\u0d2e\3\2\2\2\u0d2e\u0d30\3\2\2\2\u0d2f\u0d22\3\2\2\2\u0d2f"+
		"\u0d26\3\2\2\2\u0d2f\u0d2b\3\2\2\2\u0d30\u00d3\3\2\2\2\u0d31\u0d34\5\u00d6"+
		"l\2\u0d32\u0d34\5\u00d8m\2\u0d33\u0d31\3\2\2\2\u0d33\u0d32\3\2\2\2\u0d34"+
		"\u00d5\3\2\2\2\u0d35\u0d36\7\u015a\2\2\u0d36\u0d37\5\u0104\u0083\2\u0d37"+
		"\u0d38\7\u015b\2\2\u0d38\u00d7\3\2\2\2\u0d39\u0d42\5\u00dan\2\u0d3a\u0d42"+
		"\5\u01b4\u00db\2\u0d3b\u0d42\5\u00e0q\2\u0d3c\u0d42\5\u01bc\u00df\2\u0d3d"+
		"\u0d42\5\u00ecw\2\u0d3e\u0d42\5\u00fe\u0080\2\u0d3f\u0d42\5N(\2\u0d40"+
		"\u0d42\7Q\2\2\u0d41\u0d39\3\2\2\2\u0d41\u0d3a\3\2\2\2\u0d41\u0d3b\3\2"+
		"\2\2\u0d41\u0d3c\3\2\2\2\u0d41\u0d3d\3\2\2\2\u0d41\u0d3e\3\2\2\2\u0d41"+
		"\u0d3f\3\2\2\2\u0d41\u0d40\3\2\2\2\u0d42\u00d9\3\2\2\2\u0d43\u0d44\5\u00a8"+
		"U\2\u0d44\u00db\3\2\2\2\u0d45\u0d46\t\33\2\2\u0d46\u00dd\3\2\2\2\u0d47"+
		"\u0d49\5\u0116\u008c\2\u0d48\u0d47\3\2\2\2\u0d48\u0d49\3\2\2\2\u0d49\u0d4a"+
		"\3\2\2\2\u0d4a\u0d4b\5\u00dco\2\u0d4b\u00df\3\2\2\2\u0d4c\u0d4d\5\u00e2"+
		"r\2\u0d4d\u00e1\3\2\2\2\u0d4e\u0d4f\7\u009f\2\2\u0d4f\u0d50\7\u015a\2"+
		"\2\u0d50\u0d51\7\u015e\2\2\u0d51\u0d57\7\u015b\2\2\u0d52\u0d54\5\u00e4"+
		"s\2\u0d53\u0d55\5\u00e8u\2\u0d54\u0d53\3\2\2\2\u0d54\u0d55\3\2\2\2\u0d55"+
		"\u0d57\3\2\2\2\u0d56\u0d4e\3\2\2\2\u0d56\u0d52\3\2\2\2\u0d57\u00e3\3\2"+
		"\2\2\u0d58\u0d59\5\u00e6t\2\u0d59\u0d5b\7\u015a\2\2\u0d5a\u0d5c\5\u01b2"+
		"\u00da\2\u0d5b\u0d5a\3\2\2\2\u0d5b\u0d5c\3\2\2\2\u0d5c\u0d5d\3\2\2\2\u0d5d"+
		"\u0d5e\5\u0104\u0083\2\u0d5e\u0d5f\7\u015b\2\2\u0d5f\u00e5\3\2\2\2\u0d60"+
		"\u0d61\t\34\2\2\u0d61\u00e7\3\2\2\2\u0d62\u0d63\7\u00b6\2\2\u0d63\u0d64"+
		"\7\u015a\2\2\u0d64\u0d65\5\u017a\u00be\2\u0d65\u0d66\7\u015b\2\2\u0d66"+
		"\u00e9\3\2\2\2\u0d67\u0d68\7\u00ba\2\2\u0d68\u0d69\7\u015a\2\2\u0d69\u0d6a"+
		"\5\u01ba\u00de\2\u0d6a\u0d6b\7\u015b\2\2\u0d6b\u00eb\3\2\2\2\u0d6c\u0d6d"+
		"\5\u00f0y\2\u0d6d\u00ed\3\2\2\2\u0d6e\u0d6f\7\u00dc\2\2\u0d6f\u0d70\7"+
		"\u015a\2\2\u0d70\u0d71\5\u010a\u0086\2\u0d71\u0d72\7\u0153\2\2\u0d72\u0d73"+
		"\5\u0132\u009a\2\u0d73\u0d74\7\u015b\2\2\u0d74\u0d81\3\2\2\2\u0d75\u0d76"+
		"\7\u0097\2\2\u0d76\u0d77\7\u015a\2\2\u0d77\u0d7a\5\u010a\u0086\2\u0d78"+
		"\u0d79\7\u0153\2\2\u0d79\u0d7b\5\u0132\u009a\2\u0d7a\u0d78\3\2\2\2\u0d7b"+
		"\u0d7c\3\2\2\2\u0d7c\u0d7a\3\2\2\2\u0d7c\u0d7d\3\2\2\2\u0d7d\u0d7e\3\2"+
		"\2\2\u0d7e\u0d7f\7\u015b\2\2\u0d7f\u0d81\3\2\2\2\u0d80\u0d6e\3\2\2\2\u0d80"+
		"\u0d75\3\2\2\2\u0d81\u00ef\3\2\2\2\u0d82\u0d85\5\u00f2z\2\u0d83\u0d85"+
		"\5\u00f4{\2\u0d84\u0d82\3\2\2\2\u0d84\u0d83\3\2\2\2\u0d85\u00f1\3\2\2"+
		"\2\u0d86\u0d87\7\20\2\2\u0d87\u0d89\5\u0132\u009a\2\u0d88\u0d8a\5\u00f6"+
		"|\2\u0d89\u0d88\3\2\2\2\u0d8a\u0d8b\3\2\2\2\u0d8b\u0d89\3\2\2\2\u0d8b"+
		"\u0d8c\3\2\2\2\u0d8c\u0d8e\3\2\2\2\u0d8d\u0d8f\5\u00fa~\2\u0d8e\u0d8d"+
		"\3\2\2\2\u0d8e\u0d8f\3\2\2\2\u0d8f\u0d90\3\2\2\2\u0d90\u0d91\7%\2\2\u0d91"+
		"\u00f3\3\2\2\2\u0d92\u0d94\7\20\2\2\u0d93\u0d95\5\u00f8}\2\u0d94\u0d93"+
		"\3\2\2\2\u0d95\u0d96\3\2\2\2\u0d96\u0d94\3\2\2\2\u0d96\u0d97\3\2\2\2\u0d97"+
		"\u0d99\3\2\2\2\u0d98\u0d9a\5\u00fa~\2\u0d99\u0d98\3\2\2\2\u0d99\u0d9a"+
		"\3\2\2\2\u0d9a\u0d9b\3\2\2\2\u0d9b\u0d9c\7%\2\2\u0d9c\u00f5\3\2\2\2\u0d9d"+
		"\u0d9e\7\u0085\2\2\u0d9e\u0d9f\5\u017c\u00bf\2\u0d9f\u0da0\7w\2\2\u0da0"+
		"\u0da1\5\u00fc\177\2\u0da1\u00f7\3\2\2\2\u0da2\u0da3\7\u0085\2\2\u0da3"+
		"\u0da4\5\u017c\u00bf\2\u0da4\u0da5\7w\2\2\u0da5\u0da6\5\u00fc\177\2\u0da6"+
		"\u00f9\3\2\2\2\u0da7\u0da8\7&\2\2\u0da8\u0da9\5\u00fc\177\2\u0da9\u00fb"+
		"\3\2\2\2\u0daa\u0dad\5\u0104\u0083\2\u0dab\u0dad\7Q\2\2\u0dac\u0daa\3"+
		"\2\2\2\u0dac\u0dab\3\2\2\2\u0dad\u00fd\3\2\2\2\u0dae\u0daf\7\22\2\2\u0daf"+
		"\u0db0\7\u015a\2\2\u0db0\u0db1\5\u0100\u0081\2\u0db1\u0db2\7\6\2\2\u0db2"+
		"\u0db3\5\u0102\u0082\2\u0db3\u0db4\7\u015b\2\2\u0db4\u00ff\3\2\2\2\u0db5"+
		"\u0db6\5\u0104\u0083\2\u0db6\u0101\3\2\2\2\u0db7\u0db8\5\u00b4[\2\u0db8"+
		"\u0103\3\2\2\2\u0db9\u0dbe\5\u0108\u0085\2\u0dba\u0dbe\5\u0146\u00a4\2"+
		"\u0dbb\u0dbe\5\u0132\u009a\2\u0dbc\u0dbe\5\u0106\u0084\2\u0dbd\u0db9\3"+
		"\2\2\2\u0dbd\u0dba\3\2\2\2\u0dbd\u0dbb\3\2\2\2\u0dbd\u0dbc\3\2\2\2\u0dbe"+
		"\u0105\3\2\2\2\u0dbf\u0dc0\7\u008b\2\2\u0dc0\u0dc1\7\u0167\2\2\u0dc1\u0dc6"+
		"\5\u0104\u0083\2\u0dc2\u0dc3\7\u0153\2\2\u0dc3\u0dc5\5\u0104\u0083\2\u0dc4"+
		"\u0dc2\3\2\2\2\u0dc5\u0dc8\3\2\2\2\u0dc6\u0dc4\3\2\2\2\u0dc6\u0dc7\3\2"+
		"\2\2\u0dc7\u0dc9\3\2\2\2\u0dc8\u0dc6\3\2\2\2\u0dc9\u0dca\7\u0168\2\2\u0dca"+
		"\u0107\3\2\2\2\u0dcb\u0dcf\5\u010a\u0086\2\u0dcc\u0dcf\5\u0122\u0092\2"+
		"\u0dcd\u0dcf\7Q\2\2\u0dce\u0dcb\3\2\2\2\u0dce\u0dcc\3\2\2\2\u0dce\u0dcd"+
		"\3\2\2\2\u0dcf\u0109\3\2\2\2\u0dd0\u0dd5\5\u010c\u0087\2\u0dd1\u0dd2\t"+
		"\35\2\2\u0dd2\u0dd4\5\u010c\u0087\2\u0dd3\u0dd1\3\2\2\2\u0dd4\u0dd7\3"+
		"\2\2\2\u0dd5\u0dd3\3\2\2\2\u0dd5\u0dd6\3\2\2\2\u0dd6\u010b\3\2\2\2\u0dd7"+
		"\u0dd5\3\2\2\2\u0dd8\u0ddd\5\u010e\u0088\2\u0dd9\u0dda\t\36\2\2\u0dda"+
		"\u0ddc\5\u010e\u0088\2\u0ddb\u0dd9\3\2\2\2\u0ddc\u0ddf\3\2\2\2\u0ddd\u0ddb"+
		"\3\2\2\2\u0ddd\u0dde\3\2\2\2\u0dde\u010d\3\2\2\2\u0ddf\u0ddd\3\2\2\2\u0de0"+
		"\u0de2\5\u0116\u008c\2\u0de1\u0de0\3\2\2\2\u0de1\u0de2\3\2\2\2\u0de2\u0de3"+
		"\3\2\2\2\u0de3\u0de4\5\u0112\u008a\2\u0de4\u010f\3\2\2\2\u0de5\u0de6\7"+
		"\u015a\2\2\u0de6\u0deb\5\u010a\u0086\2\u0de7\u0de8\7\u0153\2\2\u0de8\u0dea"+
		"\5\u010a\u0086\2\u0de9\u0de7\3\2\2\2\u0dea\u0ded\3\2\2\2\u0deb\u0de9\3"+
		"\2\2\2\u0deb\u0dec\3\2\2\2\u0dec\u0dee\3\2\2\2\u0ded\u0deb\3\2\2\2\u0dee"+
		"\u0def\7\u015b\2\2\u0def\u0111\3\2\2\2\u0df0\u0df3\5\u0114\u008b\2\u0df1"+
		"\u0df3\5\u0118\u008d\2\u0df2\u0df0\3\2\2\2\u0df2\u0df1\3\2\2\2\u0df3\u0113"+
		"\3\2\2\2\u0df4\u0df9\5\u00d4k\2\u0df5\u0df6\7\u014e\2\2\u0df6\u0df8\5"+
		"\u0102\u0082\2\u0df7\u0df5\3\2\2\2\u0df8\u0dfb\3\2\2\2\u0df9\u0df7\3\2"+
		"\2\2\u0df9\u0dfa\3\2\2\2\u0dfa\u0115\3\2\2\2\u0dfb\u0df9\3\2\2\2\u0dfc"+
		"\u0dfd\t\35\2\2\u0dfd\u0117\3\2\2\2\u0dfe\u0dff\5\u011a\u008e\2\u0dff"+
		"\u0119\3\2\2\2\u0e00\u0e01\7\u00b4\2\2\u0e01\u0e02\7\u015a\2\2\u0e02\u0e03"+
		"\5\u011c\u008f\2\u0e03\u0e04\7\62\2\2\u0e04\u0e05\5\u0120\u0091\2\u0e05"+
		"\u0e06\7\u015b\2\2\u0e06\u011b\3\2\2\2\u0e07\u0e0b\5\u01ea\u00f6\2\u0e08"+
		"\u0e0b\5\u011e\u0090\2\u0e09\u0e0b\5\u01ee\u00f8\2\u0e0a\u0e07\3\2\2\2"+
		"\u0e0a\u0e08\3\2\2\2\u0e0a\u0e09\3\2\2\2\u0e0b\u011d\3\2\2\2\u0e0c\u0e0d"+
		"\t\37\2\2\u0e0d\u011f\3\2\2\2\u0e0e\u0e11\5\u01b4\u00db\2\u0e0f\u0e11"+
		"\5\u00acW\2\u0e10\u0e0e\3\2\2\2\u0e10\u0e0f\3\2\2\2\u0e11\u0121\3\2\2"+
		"\2\u0e12\u0e13\5\u0124\u0093\2\u0e13\u0123\3\2\2\2\u0e14\u0e19\5\u0126"+
		"\u0094\2\u0e15\u0e16\7\u0154\2\2\u0e16\u0e18\5\u0126\u0094\2\u0e17\u0e15"+
		"\3\2\2\2\u0e18\u0e1b\3\2\2\2\u0e19\u0e17\3\2\2\2\u0e19\u0e1a\3\2\2\2\u0e1a"+
		"\u0125\3\2\2\2\u0e1b\u0e19\3\2\2\2\u0e1c\u0e1d\5\u0128\u0095\2\u0e1d\u0127"+
		"\3\2\2\2\u0e1e\u0e21\5\u0114\u008b\2\u0e1f\u0e21\5\u012a\u0096\2\u0e20"+
		"\u0e1e\3\2\2\2\u0e20\u0e1f\3\2\2\2\u0e21\u0129\3\2\2\2\u0e22\u0e23\5\u012c"+
		"\u0097\2\u0e23\u012b\3\2\2\2\u0e24\u0e25\7\u010e\2\2\u0e25\u0e26\7\u015a"+
		"\2\2\u0e26\u0e27\5\u012e\u0098\2\u0e27\u0e28\7\u015b\2\2\u0e28\u012d\3"+
		"\2\2\2\u0e29\u0e2b\5\u0130\u0099\2\u0e2a\u0e29\3\2\2\2\u0e2a\u0e2b\3\2"+
		"\2\2\u0e2b\u0e2d\3\2\2\2\u0e2c\u0e2e\5\u0124\u0093\2\u0e2d\u0e2c\3\2\2"+
		"\2\u0e2d\u0e2e\3\2\2\2\u0e2e\u0e2f\3\2\2\2\u0e2f\u0e31\7\62\2\2\u0e30"+
		"\u0e2a\3\2\2\2\u0e30\u0e31\3\2\2\2\u0e31\u0e32\3\2\2\2\u0e32\u0e38\5\u0124"+
		"\u0093\2\u0e33\u0e34\5\u0124\u0093\2\u0e34\u0e35\7\u0153\2\2\u0e35\u0e36"+
		"\5\u0124\u0093\2\u0e36\u0e38\3\2\2\2\u0e37\u0e30\3\2\2\2\u0e37\u0e33\3"+
		"\2\2\2\u0e38\u012f\3\2\2\2\u0e39\u0e3a\t \2\2\u0e3a\u0131\3\2\2\2\u0e3b"+
		"\u0e3c\5\u0134\u009b\2\u0e3c\u0133\3\2\2\2\u0e3d\u0e42\5\u0136\u009c\2"+
		"\u0e3e\u0e3f\7W\2\2\u0e3f\u0e41\5\u0134\u009b\2\u0e40\u0e3e\3\2\2\2\u0e41"+
		"\u0e44\3\2\2\2\u0e42\u0e40\3\2\2\2\u0e42\u0e43\3\2\2\2\u0e43\u0135\3\2"+
		"\2\2\u0e44\u0e42\3\2\2\2\u0e45\u0e4a\5\u0138\u009d\2\u0e46\u0e47\7\t\2"+
		"\2\u0e47\u0e49\5\u0136\u009c\2\u0e48\u0e46\3\2\2\2\u0e49\u0e4c\3\2\2\2"+
		"\u0e4a\u0e48\3\2\2\2\u0e4a\u0e4b\3\2\2\2\u0e4b\u0137\3\2\2\2\u0e4c\u0e4a"+
		"\3\2\2\2\u0e4d\u0e51\5\u013a\u009e\2\u0e4e\u0e4f\7P\2\2\u0e4f\u0e51\5"+
		"\u013a\u009e\2\u0e50\u0e4d\3\2\2\2\u0e50\u0e4e\3\2\2\2\u0e51\u0139\3\2"+
		"\2\2\u0e52\u0e54\5\u0140\u00a1\2\u0e53\u0e55\5\u013c\u009f\2\u0e54\u0e53"+
		"\3\2\2\2\u0e54\u0e55\3\2\2\2\u0e55\u013b\3\2\2\2\u0e56\u0e58\7G\2\2\u0e57"+
		"\u0e59\7P\2\2\u0e58\u0e57\3\2\2\2\u0e58\u0e59\3\2\2\2\u0e59\u0e5a\3\2"+
		"\2\2\u0e5a\u0e5b\5\u013e\u00a0\2\u0e5b\u013d\3\2\2\2\u0e5c\u0e5d\t!\2"+
		"\2\u0e5d\u013f\3\2\2\2\u0e5e\u0e61\5\u01c4\u00e3\2\u0e5f\u0e61\5\u0142"+
		"\u00a2\2\u0e60\u0e5e\3\2\2\2\u0e60\u0e5f\3\2\2\2\u0e61\u0141\3\2\2\2\u0e62"+
		"\u0e65\5\u0144\u00a3\2\u0e63\u0e65\5\u00d8m\2\u0e64\u0e62\3\2\2\2\u0e64"+
		"\u0e63\3\2\2\2\u0e65\u0143\3\2\2\2\u0e66\u0e67\7\u015a\2\2\u0e67\u0e68"+
		"\5\u0132\u009a\2\u0e68\u0e69\7\u015b\2\2\u0e69\u0145\3\2\2\2\u0e6a\u0e6d"+
		"\5\u0148\u00a5\2\u0e6b\u0e6d\5\u014a\u00a6\2\u0e6c\u0e6a\3\2\2\2\u0e6c"+
		"\u0e6b\3\2\2\2\u0e6d\u0147\3\2\2\2\u0e6e\u0e6f\5\u00d8m\2\u0e6f\u0149"+
		"\3\2\2\2\u0e70\u0e71\7Q\2\2\u0e71\u014b\3\2\2\2\u0e72\u0e75\5\u0148\u00a5"+
		"\2\u0e73\u0e75\5\u014e\u00a8\2\u0e74\u0e72\3\2\2\2\u0e74\u0e73\3\2\2\2"+
		"\u0e75\u014d\3\2\2\2\u0e76\u0e79\5\u0108\u0085\2\u0e77\u0e79\5\u0142\u00a2"+
		"\2\u0e78\u0e76\3\2\2\2\u0e78\u0e77\3\2\2\2\u0e79\u014f\3\2\2\2\u0e7a\u0e7c"+
		"\5\u0152\u00aa\2\u0e7b\u0e7d\5\u017a\u00be\2\u0e7c\u0e7b\3\2\2\2\u0e7c"+
		"\u0e7d\3\2\2\2\u0e7d\u0e7f\3\2\2\2\u0e7e\u0e80\5\u017e\u00c0\2\u0e7f\u0e7e"+
		"\3\2\2\2\u0e7f\u0e80\3\2\2\2\u0e80\u0e82\3\2\2\2\u0e81\u0e83\5\u018e\u00c8"+
		"\2\u0e82\u0e81\3\2\2\2\u0e82\u0e83\3\2\2\2\u0e83\u0e85\3\2\2\2\u0e84\u0e86"+
		"\5\u01f0\u00f9\2\u0e85\u0e84\3\2\2\2\u0e85\u0e86\3\2\2\2\u0e86\u0e88\3"+
		"\2\2\2\u0e87\u0e89\5\u01fa\u00fe\2\u0e88\u0e87\3\2\2\2\u0e88\u0e89\3\2"+
		"\2\2\u0e89\u0151\3\2\2\2\u0e8a\u0e8c\7\62\2\2\u0e8b\u0e8d\7\u015a\2\2"+
		"\u0e8c\u0e8b\3\2\2\2\u0e8c\u0e8d\3\2\2\2\u0e8d\u0e90\3\2\2\2\u0e8e\u0e91"+
		"\5\u0154\u00ab\2\u0e8f\u0e91\5\u01a8\u00d5\2\u0e90\u0e8e\3\2\2\2\u0e90"+
		"\u0e8f\3\2\2\2\u0e91\u0e93\3\2\2\2\u0e92\u0e94\7\u015b\2\2\u0e93\u0e92"+
		"\3\2\2\2\u0e93\u0e94\3\2\2\2\u0e94\u0e96\3\2\2\2\u0e95\u0e97\5\u01b6\u00dc"+
		"\2\u0e96\u0e95\3\2\2\2\u0e96\u0e97\3\2\2\2\u0e97\u0153\3\2\2\2\u0e98\u0e9d"+
		"\5\u0156\u00ac\2\u0e99\u0e9a\7\u0153\2\2\u0e9a\u0e9c\5\u0156\u00ac\2\u0e9b"+
		"\u0e99\3\2\2\2\u0e9c\u0e9f\3\2\2\2\u0e9d\u0e9b\3\2\2\2\u0e9d\u0e9e\3\2"+
		"\2\2\u0e9e\u0155\3\2\2\2\u0e9f\u0e9d\3\2\2\2\u0ea0\u0ea3\5\u0158\u00ad"+
		"\2\u0ea1\u0ea3\5\u0170\u00b9\2\u0ea2\u0ea0\3\2\2\2\u0ea2\u0ea1\3\2\2\2"+
		"\u0ea3\u0157\3\2\2\2\u0ea4\u0ea6\7\u015a\2\2\u0ea5\u0ea4\3\2\2\2\u0ea5"+
		"\u0ea6\3\2\2\2\u0ea6\u0ea7\3\2\2\2\u0ea7\u0ea9\5\u0170\u00b9\2\u0ea8\u0eaa"+
		"\7\u015b\2\2\u0ea9\u0ea8\3\2\2\2\u0ea9\u0eaa\3\2\2\2\u0eaa\u0eac\3\2\2"+
		"\2\u0eab\u0ead\5\u015a\u00ae\2\u0eac\u0eab\3\2\2\2\u0ead\u0eae\3\2\2\2"+
		"\u0eae\u0eac\3\2\2\2\u0eae\u0eaf\3\2\2\2\u0eaf\u0159\3\2\2\2\u0eb0\u0eb1"+
		"\7\32\2\2\u0eb1\u0eb2\7H\2\2\u0eb2\u0ec4\5\u0170\u00b9\2\u0eb3\u0eb5\5"+
		"\u0164\u00b3\2\u0eb4\u0eb3\3\2\2\2\u0eb4\u0eb5\3\2\2\2\u0eb5\u0eb6\3\2"+
		"\2\2\u0eb6\u0eb7\7H\2\2\u0eb7\u0eb8\5\u0170\u00b9\2\u0eb8\u0eb9\5\u016a"+
		"\u00b6\2\u0eb9\u0ec4\3\2\2\2\u0eba\u0ebc\7O\2\2\u0ebb\u0ebd\5\u0164\u00b3"+
		"\2\u0ebc\u0ebb\3\2\2\2\u0ebc\u0ebd\3\2\2\2\u0ebd\u0ebe\3\2\2\2\u0ebe\u0ebf"+
		"\7H\2\2\u0ebf\u0ec4\5\u0170\u00b9\2\u0ec0\u0ec1\7}\2\2\u0ec1\u0ec2\7H"+
		"\2\2\u0ec2\u0ec4\5\u0170\u00b9\2\u0ec3\u0eb0\3\2\2\2\u0ec3\u0eb4\3\2\2"+
		"\2\u0ec3\u0eba\3\2\2\2\u0ec3\u0ec0\3\2\2\2\u0ec4\u015b\3\2\2\2\u0ec5\u0ec6"+
		"\7\32\2\2\u0ec6\u0ec7\7H\2\2\u0ec7\u0ec8\5\u0170\u00b9\2\u0ec8\u015d\3"+
		"\2\2\2\u0ec9\u0ecb\5\u0164\u00b3\2\u0eca\u0ec9\3\2\2\2\u0eca\u0ecb\3\2"+
		"\2\2\u0ecb\u0ecc\3\2\2\2\u0ecc\u0ecd\7H\2\2\u0ecd\u0ece\5\u0170\u00b9"+
		"\2\u0ece\u0ecf\5\u016a\u00b6\2\u0ecf\u015f\3\2\2\2\u0ed0\u0ed2\7O\2\2"+
		"\u0ed1\u0ed3\5\u0164\u00b3\2\u0ed2\u0ed1\3\2\2\2\u0ed2\u0ed3\3\2\2\2\u0ed3"+
		"\u0ed4\3\2\2\2\u0ed4\u0ed5\7H\2\2\u0ed5\u0ed6\5\u0170\u00b9\2\u0ed6\u0161"+
		"\3\2\2\2\u0ed7\u0ed8\7}\2\2\u0ed8\u0ed9\7H\2\2\u0ed9\u0eda\5\u0170\u00b9"+
		"\2\u0eda\u0163\3\2\2\2\u0edb\u0ede\7A\2\2\u0edc\u0ede\5\u0166\u00b4\2"+
		"\u0edd\u0edb\3\2\2\2\u0edd\u0edc\3\2\2\2\u0ede\u0165\3\2\2\2\u0edf\u0ee1"+
		"\5\u0168\u00b5\2\u0ee0\u0ee2\7T\2\2\u0ee1\u0ee0\3\2\2\2\u0ee1\u0ee2\3"+
		"\2\2\2\u0ee2\u0167\3\2\2\2\u0ee3\u0ee4\t\"\2\2\u0ee4\u0169\3\2\2\2\u0ee5"+
		"\u0ee8\5\u016c\u00b7\2\u0ee6\u0ee8\5\u016e\u00b8\2\u0ee7\u0ee5\3\2\2\2"+
		"\u0ee7\u0ee6\3\2\2\2\u0ee8\u016b\3\2\2\2\u0ee9\u0eea\7\u00e0\2\2\u0eea"+
		"\u0eeb\5\u017c\u00bf\2\u0eeb\u016d\3\2\2\2\u0eec\u0eed\7\u0081\2\2\u0eed"+
		"\u0eee\7\u015a\2\2\u0eee\u0eef\5\u01ba\u00de\2\u0eef\u0ef0\7\u015b\2\2"+
		"\u0ef0\u016f\3\2\2\2\u0ef1\u0ef4\5\u0176\u00bc\2\u0ef2\u0ef4\5\u01a4\u00d3"+
		"\2\u0ef3\u0ef1\3\2\2\2\u0ef3\u0ef2\3\2\2\2\u0ef4\u0ef9\3\2\2\2\u0ef5\u0ef7"+
		"\7\6\2\2\u0ef6\u0ef5\3\2\2\2\u0ef6\u0ef7\3\2\2\2\u0ef7\u0ef8\3\2\2\2\u0ef8"+
		"\u0efa\5\u0174\u00bb\2\u0ef9\u0ef6\3\2\2\2\u0ef9\u0efa\3\2\2\2\u0efa\u0eff"+
		"\3\2\2\2\u0efb\u0efc\7\u015a\2\2\u0efc\u0efd\5\u0172\u00ba\2\u0efd\u0efe"+
		"\7\u015b\2\2\u0efe\u0f00\3\2\2\2\u0eff\u0efb\3\2\2\2\u0eff\u0f00\3\2\2"+
		"\2\u0f00\u0f0d\3\2\2\2\u0f01\u0f03\5\u0178\u00bd\2\u0f02\u0f04\7\6\2\2"+
		"\u0f03\u0f02\3\2\2\2\u0f03\u0f04\3\2\2\2\u0f04\u0f05\3\2\2\2\u0f05\u0f0a"+
		"\5\u00a4S\2\u0f06\u0f07\7\u015a\2\2\u0f07\u0f08\5\u0172\u00ba\2\u0f08"+
		"\u0f09\7\u015b\2\2\u0f09\u0f0b\3\2\2\2\u0f0a\u0f06\3\2\2\2\u0f0a\u0f0b"+
		"\3\2\2\2\u0f0b\u0f0d\3\2\2\2\u0f0c\u0ef3\3\2\2\2\u0f0c\u0f01\3\2\2\2\u0f0d"+
		"\u0171\3\2\2\2\u0f0e\u0f13\5\u00a4S\2\u0f0f\u0f10\7\u0153\2\2\u0f10\u0f12"+
		"\5\u00a4S\2\u0f11\u0f0f\3\2\2\2\u0f12\u0f15\3\2\2\2\u0f13\u0f11\3\2\2"+
		"\2\u0f13\u0f14\3\2\2\2\u0f14\u0173\3\2\2\2\u0f15\u0f13\3\2\2\2\u0f16\u0f19"+
		"\5\u01a6\u00d4\2\u0f17\u0f19\5\u0176\u00bc\2\u0f18\u0f16\3\2\2\2\u0f18"+
		"\u0f17\3\2\2\2\u0f19\u0175\3\2\2\2\u0f1a\u0f1b\5\u01a6\u00d4\2\u0f1b\u0f24"+
		"\7\u015a\2\2\u0f1c\u0f21\5\u00a4S\2\u0f1d\u0f1e\7\u0153\2\2\u0f1e\u0f20"+
		"\5\u00a4S\2\u0f1f\u0f1d\3\2\2\2\u0f20\u0f23\3\2\2\2\u0f21\u0f1f\3\2\2"+
		"\2\u0f21\u0f22\3\2\2\2\u0f22\u0f25\3\2\2\2\u0f23\u0f21\3\2\2\2\u0f24\u0f1c"+
		"\3\2\2\2\u0f24\u0f25\3\2\2\2\u0f25\u0f26\3\2\2\2\u0f26\u0f27\7\u015b\2"+
		"\2\u0f27\u0177\3\2\2\2\u0f28\u0f29\5\u01c0\u00e1\2\u0f29\u0179\3\2\2\2"+
		"\u0f2a\u0f2b\7\u0086\2\2\u0f2b\u0f2c\5\u017c\u00bf\2\u0f2c\u017b\3\2\2"+
		"\2\u0f2d\u0f2f\7\u015a\2\2\u0f2e\u0f2d\3\2\2\2\u0f2e\u0f2f\3\2\2\2\u0f2f"+
		"\u0f30\3\2\2\2\u0f30\u0f32\5\u0104\u0083\2\u0f31\u0f33\7\u015b\2\2\u0f32"+
		"\u0f31\3\2\2\2\u0f32\u0f33\3\2\2\2\u0f33\u017d\3\2\2\2\u0f34\u0f35\7\65"+
		"\2\2\u0f35\u0f36\7\u008e\2\2\u0f36\u0f37\5\u0180\u00c1\2\u0f37\u017f\3"+
		"\2\2\2\u0f38\u0f3d\5\u0182\u00c2\2\u0f39\u0f3a\7\u0153\2\2\u0f3a\u0f3c"+
		"\5\u0182\u00c2\2\u0f3b\u0f39\3\2\2\2\u0f3c\u0f3f\3\2\2\2\u0f3d\u0f3b\3"+
		"\2\2\2\u0f3d\u0f3e\3\2\2\2\u0f3e\u0181\3\2\2\2\u0f3f\u0f3d\3\2\2\2\u0f40"+
		"\u0f45\5\u0188\u00c5\2\u0f41\u0f45\5\u018a\u00c6\2\u0f42\u0f45\5\u018c"+
		"\u00c7\2\u0f43\u0f45\5\u0184\u00c3\2\u0f44\u0f40\3\2\2\2\u0f44\u0f41\3"+
		"\2\2\2\u0f44\u0f42\3\2\2\2\u0f44\u0f43\3\2\2\2\u0f45\u0183\3\2\2\2\u0f46"+
		"\u0f4c\5\u014c\u00a7\2\u0f47\u0f48\7\u015a\2\2\u0f48\u0f49\5\u0190\u00c9"+
		"\2\u0f49\u0f4a\7\u015b\2\2\u0f4a\u0f4c\3\2\2\2\u0f4b\u0f46\3\2\2\2\u0f4b"+
		"\u0f47\3\2\2\2\u0f4c\u0185\3\2\2\2\u0f4d\u0f52\5\u0184\u00c3\2\u0f4e\u0f4f"+
		"\7\u0153\2\2\u0f4f\u0f51\5\u0184\u00c3\2\u0f50\u0f4e\3\2\2\2\u0f51\u0f54"+
		"\3\2\2\2\u0f52\u0f50\3\2\2\2\u0f52\u0f53\3\2\2\2\u0f53\u0187\3\2\2\2\u0f54"+
		"\u0f52\3\2\2\2\u0f55\u0f56\7\u00f7\2\2\u0f56\u0f57\7\u015a\2\2\u0f57\u0f58"+
		"\5\u0186\u00c4\2\u0f58\u0f59\7\u015b\2\2\u0f59\u0189\3\2\2\2\u0f5a\u0f5b"+
		"\7\u00a0\2\2\u0f5b\u0f5c\7\u015a\2\2\u0f5c\u0f5d\5\u0186\u00c4\2\u0f5d"+
		"\u0f5e\7\u015b\2\2\u0f5e\u018b\3\2\2\2\u0f5f\u0f60\7\u015a\2\2\u0f60\u0f61"+
		"\7\u015b\2\2\u0f61\u018d\3\2\2\2\u0f62\u0f63\7\66\2\2\u0f63\u0f64\5\u0132"+
		"\u009a\2\u0f64\u018f\3\2\2\2\u0f65\u0f6a\5\u014c\u00a7\2\u0f66\u0f67\7"+
		"\u0153\2\2\u0f67\u0f69\5\u014c\u00a7\2\u0f68\u0f66\3\2\2\2\u0f69\u0f6c"+
		"\3\2\2\2\u0f6a\u0f68\3\2\2\2\u0f6a\u0f6b\3\2\2\2\u0f6b\u0191\3\2\2\2\u0f6c"+
		"\u0f6a\3\2\2\2\u0f6d\u0f6e\5\u0194\u00cb\2\u0f6e\u0193\3\2\2\2\u0f6f\u0f72"+
		"\5\u0196\u00cc\2\u0f70\u0f72\5\u0158\u00ad\2\u0f71\u0f6f\3\2\2\2\u0f71"+
		"\u0f70\3\2\2\2\u0f72\u0195\3\2\2\2\u0f73\u0f7c\5\u019a\u00ce\2\u0f74\u0f75"+
		"\5\u0158\u00ad\2\u0f75\u0f77\t#\2\2\u0f76\u0f78\t$\2\2\u0f77\u0f76\3\2"+
		"\2\2\u0f77\u0f78\3\2\2\2\u0f78\u0f79\3\2\2\2\u0f79\u0f7a\5\u0198\u00cd"+
		"\2\u0f7a\u0f7c\3\2\2\2\u0f7b\u0f73\3\2\2\2\u0f7b\u0f74\3\2\2\2\u0f7c\u0f84"+
		"\3\2\2\2\u0f7d\u0f7f\t#\2\2\u0f7e\u0f80\t$\2\2\u0f7f\u0f7e\3\2\2\2\u0f7f"+
		"\u0f80\3\2\2\2\u0f80\u0f81\3\2\2\2\u0f81\u0f83\5\u0198\u00cd\2\u0f82\u0f7d"+
		"\3\2\2\2\u0f83\u0f86\3\2\2\2\u0f84\u0f82\3\2\2\2\u0f84\u0f85\3\2\2\2\u0f85"+
		"\u0197\3\2\2\2\u0f86\u0f84\3\2\2\2\u0f87\u0f8a\5\u019a\u00ce\2\u0f88\u0f8a"+
		"\5\u0158\u00ad\2\u0f89\u0f87\3\2\2\2\u0f89\u0f88\3\2\2\2\u0f8a\u0199\3"+
		"\2\2\2\u0f8b\u0f94\5\u019e\u00d0\2\u0f8c\u0f8d\5\u0158\u00ad\2\u0f8d\u0f8f"+
		"\7B\2\2\u0f8e\u0f90\t$\2\2\u0f8f\u0f8e\3\2\2\2\u0f8f\u0f90\3\2\2\2\u0f90"+
		"\u0f91\3\2\2\2\u0f91\u0f92\5\u019c\u00cf\2\u0f92\u0f94\3\2\2\2\u0f93\u0f8b"+
		"\3\2\2\2\u0f93\u0f8c\3\2\2\2\u0f94\u0f9c\3\2\2\2\u0f95\u0f97\7B\2\2\u0f96"+
		"\u0f98\t$\2\2\u0f97\u0f96\3\2\2\2\u0f97\u0f98\3\2\2\2\u0f98\u0f99\3\2"+
		"\2\2\u0f99\u0f9b\5\u019c\u00cf\2\u0f9a\u0f95\3\2\2\2\u0f9b\u0f9e\3\2\2"+
		"\2\u0f9c\u0f9a\3\2\2\2\u0f9c\u0f9d\3\2\2\2\u0f9d\u019b\3\2\2\2\u0f9e\u0f9c"+
		"\3\2\2\2\u0f9f\u0fa2\5\u019e\u00d0\2\u0fa0\u0fa2\5\u0158\u00ad\2\u0fa1"+
		"\u0f9f\3\2\2\2\u0fa1\u0fa0\3\2\2\2\u0fa2\u019d\3\2\2\2\u0fa3\u0fa9\5\u01a0"+
		"\u00d1\2\u0fa4\u0fa5\7\u015a\2\2\u0fa5\u0fa6\5\u0196\u00cc\2\u0fa6\u0fa7"+
		"\7\u015b\2\2\u0fa7\u0fa9\3\2\2\2\u0fa8\u0fa3\3\2\2\2\u0fa8\u0fa4\3\2\2"+
		"\2\u0fa9\u019f\3\2\2\2\u0faa\u0fad\5\u01a8\u00d5\2\u0fab\u0fad\5\u01a2"+
		"\u00d2\2\u0fac\u0faa\3\2\2\2\u0fac\u0fab\3\2\2\2\u0fad\u01a1\3\2\2\2\u0fae"+
		"\u0faf\7t\2\2\u0faf\u0fb0\5\u01a4\u00d3\2\u0fb0\u01a3\3\2\2\2\u0fb1\u0fb4"+
		"\5\u01a6\u00d4\2\u0fb2\u0fb4\5\u00a4S\2\u0fb3\u0fb1\3\2\2\2\u0fb3\u0fb2"+
		"\3\2\2\2\u0fb4\u01a5\3\2\2\2\u0fb5\u0fbc\5\u00a4S\2\u0fb6\u0fb7\7\u0161"+
		"\2\2\u0fb7\u0fba\5\u00a4S\2\u0fb8\u0fb9\7\u0161\2\2\u0fb9\u0fbb\5\u00a4"+
		"S\2\u0fba\u0fb8\3\2\2\2\u0fba\u0fbb\3\2\2\2\u0fbb\u0fbd\3\2\2\2\u0fbc"+
		"\u0fb6\3\2\2\2\u0fbc\u0fbd\3\2\2\2\u0fbd\u01a7\3\2\2\2\u0fbe\u0fc0\7m"+
		"\2\2\u0fbf\u0fc1\5\u01b2\u00da\2\u0fc0\u0fbf\3\2\2\2\u0fc0\u0fc1\3\2\2"+
		"\2\u0fc1\u0fc2\3\2\2\2\u0fc2\u0fc4\5\u01aa\u00d6\2\u0fc3\u0fc5\5\u0150"+
		"\u00a9\2\u0fc4\u0fc3\3\2\2\2\u0fc4\u0fc5\3\2\2\2\u0fc5\u01a9\3\2\2\2\u0fc6"+
		"\u0fcb\5\u01ac\u00d7\2\u0fc7\u0fc8\7\u0153\2\2\u0fc8\u0fca\5\u01ac\u00d7"+
		"\2\u0fc9\u0fc7\3\2\2\2\u0fca\u0fcd\3\2\2\2\u0fcb\u0fc9\3\2\2\2\u0fcb\u0fcc"+
		"\3\2\2\2\u0fcc\u01ab\3\2\2\2\u0fcd\u0fcb\3\2\2\2\u0fce\u0fd1\5\u01ae\u00d8"+
		"\2\u0fcf\u0fd1\5\u01b0\u00d9\2\u0fd0\u0fce\3\2\2\2\u0fd0\u0fcf\3\2\2\2"+
		"\u0fd1\u01ad\3\2\2\2\u0fd2\u0fd7\5\u0104\u0083\2\u0fd3\u0fd6\5\u01b6\u00dc"+
		"\2\u0fd4\u0fd6\5\u01b8\u00dd\2\u0fd5\u0fd3\3\2\2\2\u0fd5\u0fd4\3\2\2\2"+
		"\u0fd6\u0fd9\3\2\2\2\u0fd7\u0fd5\3\2\2\2\u0fd7\u0fd8\3\2\2\2\u0fd8\u01af"+
		"\3\2\2\2\u0fd9\u0fd7\3\2\2\2\u0fda\u0fdb\7\u016d\2\2\u0fdb\u0fdd\7\u0161"+
		"\2\2\u0fdc\u0fda\3\2\2\2\u0fdc\u0fdd\3\2\2\2\u0fdd\u0fde\3\2\2\2\u0fde"+
		"\u0fdf\7\u015e\2\2\u0fdf\u01b1\3\2\2\2\u0fe0\u0fe1\t$\2\2\u0fe1\u01b3"+
		"\3\2\2\2\u0fe2\u0fe3\5\u00a4S\2\u0fe3\u0fe4\7\u0161\2\2\u0fe4\u0fe6\3"+
		"\2\2\2\u0fe5\u0fe2\3\2\2\2\u0fe5\u0fe6\3\2\2\2\u0fe6\u0fe7\3\2\2\2\u0fe7"+
		"\u0fe8\5\u00a4S\2\u0fe8\u01b5\3\2\2\2\u0fe9\u0feb\7\6\2\2\u0fea\u0fe9"+
		"\3\2\2\2\u0fea\u0feb\3\2\2\2\u0feb\u0fec\3\2\2\2\u0fec\u0fed\5\u00a4S"+
		"\2\u0fed\u01b7\3\2\2\2\u0fee\u0fef\7\u00e4\2\2\u0fef\u0ff5\7\u015a\2\2"+
		"\u0ff0\u0ff4\5\u009eP\2\u0ff1\u0ff4\5\u01f0\u00f9\2\u0ff2\u0ff4\5\u01f8"+
		"\u00fd\2\u0ff3\u0ff0\3\2\2\2\u0ff3\u0ff1\3\2\2\2\u0ff3\u0ff2\3\2\2\2\u0ff4"+
		"\u0ff7\3\2\2\2\u0ff5\u0ff3\3\2\2\2\u0ff5\u0ff6\3\2\2\2\u0ff6\u0ff8\3\2"+
		"\2\2\u0ff7\u0ff5\3\2\2\2\u0ff8\u0ff9\7\u015b\2\2\u0ff9\u01b9\3\2\2\2\u0ffa"+
		"\u0fff\5\u01b4\u00db\2\u0ffb\u0ffc\7\u0153\2\2\u0ffc\u0ffe\5\u01b4\u00db"+
		"\2\u0ffd\u0ffb\3\2\2\2\u0ffe\u1001\3\2\2\2\u0fff\u0ffd\3\2\2\2\u0fff\u1000"+
		"\3\2\2\2\u1000\u01bb\3\2\2\2\u1001\u0fff\3\2\2\2\u1002\u1003\5\u01c2\u00e2"+
		"\2\u1003\u01bd\3\2\2\2\u1004\u1005\5\u01c2\u00e2\2\u1005\u01bf\3\2\2\2"+
		"\u1006\u1007\5\u01c2\u00e2\2\u1007\u01c1\3\2\2\2\u1008\u1009\7\u015a\2"+
		"\2\u1009\u100a\5\u0192\u00ca\2\u100a\u100b\7\u015b\2\2\u100b\u01c3\3\2"+
		"\2\2\u100c\u1013\5\u01c6\u00e4\2\u100d\u1013\5\u01ca\u00e6\2\u100e\u1013"+
		"\5\u01ce\u00e8\2\u100f\u1013\5\u01d4\u00eb\2\u1010\u1013\5\u01dc\u00ef"+
		"\2\u1011\u1013\5\u01e6\u00f4\2\u1012\u100c\3\2\2\2\u1012\u100d\3\2\2\2"+
		"\u1012\u100e\3\2\2\2\u1012\u100f\3\2\2\2\u1012\u1010\3\2\2\2\u1012\u1011"+
		"\3\2\2\2\u1013\u01c5\3\2\2\2\u1014\u1015\5\u014c\u00a7\2\u1015\u1016\5"+
		"\u01c8\u00e5\2\u1016\u1017\5\u014c\u00a7\2\u1017\u01c7\3\2\2\2\u1018\u1019"+
		"\t%\2\2\u1019\u01c9\3\2\2\2\u101a\u101b\5\u014c\u00a7\2\u101b\u101c\5"+
		"\u01cc\u00e7\2\u101c\u01cb\3\2\2\2\u101d\u101f\7P\2\2\u101e\u101d\3\2"+
		"\2\2\u101e\u101f\3\2\2\2\u101f\u1020\3\2\2\2\u1020\u1022\7\u008d\2\2\u1021"+
		"\u1023\t&\2\2\u1022\u1021\3\2\2\2\u1022\u1023\3\2\2\2\u1023\u1024\3\2"+
		"\2\2\u1024\u1025\5\u014c\u00a7\2\u1025\u1026\7\t\2\2\u1026\u1027\5\u014c"+
		"\u00a7\2\u1027\u01cd\3\2\2\2\u1028\u102a\5\u010a\u0086\2\u1029\u102b\7"+
		"P\2\2\u102a\u1029\3\2\2\2\u102a\u102b\3\2\2\2\u102b\u102c\3\2\2\2\u102c"+
		"\u102d\7<\2\2\u102d\u102e\5\u01d0\u00e9\2\u102e\u01cf\3\2\2\2\u102f\u1035"+
		"\5\u01c0\u00e1\2\u1030\u1031\7\u015a\2\2\u1031\u1032\5\u01d2\u00ea\2\u1032"+
		"\u1033\7\u015b\2\2\u1033\u1035\3\2\2\2\u1034\u102f\3\2\2\2\u1034\u1030"+
		"\3\2\2\2\u1035\u01d1\3\2\2\2\u1036\u103b\5\u0146\u00a4\2\u1037\u1038\7"+
		"\u0153\2\2\u1038\u103a\5\u0146\u00a4\2\u1039\u1037\3\2\2\2\u103a\u103d"+
		"\3\2\2\2\u103b\u1039\3\2\2\2\u103b\u103c\3\2\2\2\u103c\u01d3\3\2\2\2\u103d"+
		"\u103b\3\2\2\2\u103e\u103f\5\u014c\u00a7\2\u103f\u1040\5\u01d6\u00ec\2"+
		"\u1040\u1041\7\u0170\2\2\u1041\u01d5\3\2\2\2\u1042\u1044\7P\2\2\u1043"+
		"\u1042\3\2\2\2\u1043\u1044\3\2\2\2\u1044\u1045\3\2\2\2\u1045\u1048\5\u01d8"+
		"\u00ed\2\u1046\u1048\5\u01da\u00ee\2\u1047\u1043\3\2\2\2\u1047\u1046\3"+
		"\2\2\2\u1048\u01d7\3\2\2\2\u1049\u1050\7L\2\2\u104a\u1050\79\2\2\u104b"+
		"\u104c\7\u00fd\2\2\u104c\u1050\7\u010f\2\2\u104d\u1050\7\u00f1\2\2\u104e"+
		"\u1050\7\u00f6\2\2\u104f\u1049\3\2\2\2\u104f\u104a\3\2\2\2\u104f\u104b"+
		"\3\2\2\2\u104f\u104d\3\2\2\2\u104f\u104e\3\2\2\2\u1050\u01d9\3\2\2\2\u1051"+
		"\u1052\t\'\2\2\u1052\u01db\3\2\2\2\u1053\u1054\5\u014c\u00a7\2\u1054\u1056"+
		"\7G\2\2\u1055\u1057\7P\2\2\u1056\u1055\3\2\2\2\u1056\u1057\3\2\2\2\u1057"+
		"\u1058\3\2\2\2\u1058\u1059\7Q\2\2\u1059\u01dd\3\2\2\2\u105a\u105b\5\u010a"+
		"\u0086\2\u105b\u105c\5\u01c8\u00e5\2\u105c\u105d\5\u01e0\u00f1\2\u105d"+
		"\u105e\5\u01c0\u00e1\2\u105e\u01df\3\2\2\2\u105f\u1062\5\u01e2\u00f2\2"+
		"\u1060\u1062\5\u01e4\u00f3\2\u1061\u105f\3\2\2\2\u1061\u1060\3\2\2\2\u1062"+
		"\u01e1\3\2\2\2\u1063\u1064\7\7\2\2\u1064\u01e3\3\2\2\2\u1065\u1066\t("+
		"\2\2\u1066\u01e5\3\2\2\2\u1067\u1069\7P\2\2\u1068\u1067\3\2\2\2\u1068"+
		"\u1069\3\2\2\2\u1069\u106a\3\2\2\2\u106a\u106b\7\u00b1\2\2\u106b\u106c"+
		"\5\u01c0\u00e1\2\u106c\u01e7\3\2\2\2\u106d\u106e\7~\2\2\u106e\u106f\5"+
		"\u01c0\u00e1\2\u106f\u01e9\3\2\2\2\u1070\u1073\5\u01ec\u00f7\2\u1071\u1073"+
		"\7\u00f9\2\2\u1072\u1070\3\2\2\2\u1072\u1071\3\2\2\2\u1073\u01eb\3\2\2"+
		"\2\u1074\u1075\t)\2\2\u1075\u01ed\3\2\2\2\u1076\u1077\t*\2\2\u1077\u01ef"+
		"\3\2\2\2\u1078\u1079\7X\2\2\u1079\u107a\7\u008e\2\2\u107a\u107b\5\u01f4"+
		"\u00fb\2\u107b\u01f1\3\2\2\2\u107c\u1086\5\u01f4\u00fb\2\u107d\u1080\7"+
		"\u015a\2\2\u107e\u1081\n+\2\2\u107f\u1081\5\u01f2\u00fa\2\u1080\u107e"+
		"\3\2\2\2\u1080\u107f\3\2\2\2\u1081\u1082\3\2\2\2\u1082\u1080\3\2\2\2\u1082"+
		"\u1083\3\2\2\2\u1083\u1084\3\2\2\2\u1084\u1086\7\u015b\2\2\u1085\u107c"+
		"\3\2\2\2\u1085\u107d\3\2\2\2\u1086\u01f3\3\2\2\2\u1087\u108c\5\u01f6\u00fc"+
		"\2\u1088\u1089\7\u0153\2\2\u1089\u108b\5\u01f6\u00fc\2\u108a\u1088\3\2"+
		"\2\2\u108b\u108e\3\2\2\2\u108c\u108a\3\2\2\2\u108c\u108d\3\2\2\2\u108d"+
		"\u01f5\3\2\2\2\u108e\u108c\3\2\2\2\u108f\u1091\5\u014c\u00a7\2\u1090\u1092"+
		"\5\u01f8\u00fd\2\u1091\u1090\3\2\2\2\u1091\u1092\3\2\2\2\u1092\u1094\3"+
		"\2\2\2\u1093\u1095\5\u01fc\u00ff\2\u1094\u1093\3\2\2\2\u1094\u1095\3\2"+
		"\2\2\u1095\u01f7\3\2\2\2\u1096\u1097\t,\2\2\u1097\u01f9\3\2\2\2\u1098"+
		"\u1099\7M\2\2\u1099\u109a\5\u010a\u0086\2\u109a\u01fb\3\2\2\2\u109b\u109c"+
		"\7Q\2\2\u109c\u10a0\7\u00b7\2\2\u109d\u109e\7Q\2\2\u109e\u10a0\7\u00ca"+
		"\2\2\u109f\u109b\3\2\2\2\u109f\u109d\3\2\2\2\u10a0\u01fd\3\2\2\2\u0233"+
		"\u0203\u020d\u021d\u0225\u022d\u0230\u0247\u0257\u025b\u0265\u026d\u0272"+
		"\u0277\u027e\u0284\u0289\u028d\u02a1\u02a5\u02aa\u02ae\u02b2\u02b6\u02bb"+
		"\u02c1\u02c5\u02c9\u02d2\u02da\u02e4\u02ed\u02f7\u02fe\u0308\u030f\u031d"+
		"\u0328\u0332\u0351\u0365\u036d\u0378\u037e\u0380\u0392\u0397\u03a6\u03b1"+
		"\u03bd\u03c0\u03c9\u03cc\u03d6\u03db\u03dd\u03e8\u03ed\u03ef\u03f8\u03fa"+
		"\u0403\u0405\u040e\u0415\u041a\u041c\u0425\u042c\u0431\u0433\u043c\u0441"+
		"\u0443\u044c\u0451\u0453\u0458\u045e\u0464\u0467\u0469\u046b\u0472\u047d"+
		"\u0488\u048f\u0493\u0497\u049a\u04a0\u04a4\u04a8\u04ac\u04b3\u04b7\u04bb"+
		"\u04bf\u04c3\u04c8\u04cb\u04d2\u04d5\u04d8\u04e0\u04e4\u04e6\u04f7\u04fc"+
		"\u0500\u0502\u050a\u0513\u0518\u051f\u0525\u0529\u052c\u0534\u0538\u0540"+
		"\u054c\u054f\u0551\u0554\u0558\u055e\u0563\u0569\u056d\u0571\u0575\u057c"+
		"\u0582\u058b\u0592\u0597\u0599\u059d\u05a2\u05ab\u05ad\u05b5\u05be\u05c5"+
		"\u05c9\u05d1\u05d6\u05da\u05e1\u05ea\u05ef\u05f3\u05f5\u05fe\u060a\u060d"+
		"\u0615\u061a\u061e\u0620\u0629\u0632\u0637\u0639\u0644\u064d\u0652\u0654"+
		"\u065e\u0667\u066c\u066e\u0673\u067b\u0680\u0682\u068b\u0694\u0699\u069b"+
		"\u069d\u06a1\u06a3\u06ad\u06b6\u06ba\u06be\u06c2\u06c4\u06cd\u06d6\u06db"+
		"\u06dd\u06e6\u06ef\u06f6\u06ff\u0703\u0705\u0709\u070d\u0711\u0715\u0719"+
		"\u071d\u0725\u072a\u072c\u0730\u0734\u0738\u0740\u0744\u0746\u0751\u0756"+
		"\u075a\u0761\u0764\u0768\u076c\u0770\u077a\u077f\u0781\u078a\u078f\u079a"+
		"\u079d\u07a7\u07ac\u07ae\u07b7\u07c0\u07c2\u07cd\u07d6\u07d8\u07e2\u07eb"+
		"\u07ed\u07f2\u07fa\u07fc\u0805\u080d\u0811\u0815\u0817\u0821\u0829\u082d"+
		"\u0831\u0833\u083c\u0845\u0847\u0850\u085a\u0863\u0869\u086b\u086f\u0873"+
		"\u0877\u087b\u087f\u0885\u0891\u0894\u08d2\u0900\u0908\u090f\u0919\u091e"+
		"\u092d\u0932\u0942\u0948\u0951\u0953\u095c\u0961\u096a\u096f\u0973\u0976"+
		"\u0981\u0986\u0989\u098e\u099e\u09a1\u09ae\u09b3\u09ba\u09bf\u09c6\u09cc"+
		"\u09d0\u09d6\u09dd\u09df\u09e6\u09eb\u09f5\u0a00\u0a09\u0a0e\u0a11\u0a17"+
		"\u0a1b\u0a23\u0a27\u0a2b\u0a32\u0a36\u0a3c\u0a45\u0a48\u0a4f\u0a53\u0a57"+
		"\u0a5f\u0a63\u0a69\u0a75\u0a79\u0a82\u0a86\u0a88\u0a8d\u0a93\u0a9c\u0a9f"+
		"\u0aa4\u0aa8\u0aad\u0ab5\u0abf\u0acd\u0ad6\u0ae0\u0aea\u0af4\u0b00\u0b05"+
		"\u0b0d\u0b15\u0b17\u0b1a\u0b1f\u0b25\u0b29\u0b32\u0b42\u0b47\u0b4c\u0b4e"+
		"\u0b53\u0b59\u0b5f\u0b65\u0b6b\u0b6e\u0b72\u0b7e\u0b87\u0b89\u0b8d\u0b95"+
		"\u0b98\u0b9e\u0ba6\u0bb7\u0bcc\u0bdd\u0bea\u0bee\u0bf0\u0bfd\u0c04\u0c1c"+
		"\u0c23\u0c35\u0c3e\u0c43\u0c47\u0c49\u0c4f\u0c54\u0c59\u0c67\u0c6b\u0c7c"+
		"\u0c84\u0c88\u0c8d\u0c92\u0c96\u0c9a\u0ca3\u0ca8\u0cac\u0cb2\u0cb8\u0cbd"+
		"\u0cc1\u0cc3\u0cc7\u0ccb\u0ccd\u0cd1\u0cd5\u0cd9\u0cdd\u0ce8\u0cec\u0cf4"+
		"\u0cfe\u0d07\u0d0e\u0d11\u0d15\u0d19\u0d1e\u0d20\u0d24\u0d29\u0d2d\u0d2f"+
		"\u0d33\u0d41\u0d48\u0d54\u0d56\u0d5b\u0d7c\u0d80\u0d84\u0d8b\u0d8e\u0d96"+
		"\u0d99\u0dac\u0dbd\u0dc6\u0dce\u0dd5\u0ddd\u0de1\u0deb\u0df2\u0df9\u0e0a"+
		"\u0e10\u0e19\u0e20\u0e2a\u0e2d\u0e30\u0e37\u0e42\u0e4a\u0e50\u0e54\u0e58"+
		"\u0e60\u0e64\u0e6c\u0e74\u0e78\u0e7c\u0e7f\u0e82\u0e85\u0e88\u0e8c\u0e90"+
		"\u0e93\u0e96\u0e9d\u0ea2\u0ea5\u0ea9\u0eae\u0eb4\u0ebc\u0ec3\u0eca\u0ed2"+
		"\u0edd\u0ee1\u0ee7\u0ef3\u0ef6\u0ef9\u0eff\u0f03\u0f0a\u0f0c\u0f13\u0f18"+
		"\u0f21\u0f24\u0f2e\u0f32\u0f3d\u0f44\u0f4b\u0f52\u0f6a\u0f71\u0f77\u0f7b"+
		"\u0f7f\u0f84\u0f89\u0f8f\u0f93\u0f97\u0f9c\u0fa1\u0fa8\u0fac\u0fb3\u0fba"+
		"\u0fbc\u0fc0\u0fc4\u0fcb\u0fd0\u0fd5\u0fd7\u0fdc\u0fe5\u0fea\u0ff3\u0ff5"+
		"\u0fff\u1012\u101e\u1022\u102a\u1034\u103b\u1043\u1047\u104f\u1056\u1061"+
		"\u1068\u1072\u1080\u1082\u1085\u108c\u1091\u1094\u109f";
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