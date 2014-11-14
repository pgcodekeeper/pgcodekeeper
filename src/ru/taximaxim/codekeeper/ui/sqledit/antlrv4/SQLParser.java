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
		FUNCTION=45, ISODOW=185, OVERWRITE=212, FUNCTIONS=46, ROW=94, PRECISION=217, 
		ILIKE=54, Character_String_Literal=340, NOT=77, EXCEPT=36, FOREIGN=43, 
		CACHE=138, PRIVILEGES=90, BYTEA=299, MONTH=203, STATEMENT=110, CHARACTER=142, 
		TYPE=250, BlockComment=335, VARBIT=267, STDDEV_POP=237, CREATE=22, COMMENTS=148, 
		ESC_SEQUENCES=341, USING=126, UNLOGGED=252, NOT_EQUAL=313, TIMEZONE_MINUTE=247, 
		VERTICAL_BAR=327, VARIADIC=128, TIMESTAMPTZ=293, REGEXP=222, FAMILY=170, 
		GEQ=317, HANDLER=52, STDDEV_SAMP=238, DIVIDE=323, BLOB=298, STRICT=111, 
		PRESERVE=88, ASC=9, GROUPING=175, SUBPARTITION=239, VALIDATOR=127, KEY=70, 
		SETOF=108, TEMP=114, ELSE=35, NUMBER=333, BOOL=265, TRAILING=117, DEFINER=160, 
		SEMI_COLON=310, INT=274, RLIKE=225, LEADING=71, RESTRICT=98, SERVER=230, 
		PROCEDURAL=92, TABLESPACE=241, MILLISECONDS=199, REAL=279, INTERSECT=63, 
		GROUP=50, LANGUAGE=188, SEQUENCES=105, OUT=82, REAL_NUMBER=334, NONE=206, 
		TRIM=248, LEFT_PAREN=318, LOCATION=193, SEARCH=227, END=34, CONSTRAINT=19, 
		TIMEZONE_HOUR=246, RENAME=223, CAST_EXPRESSION=306, ALTER=5, OPTION=210, 
		ISOYEAR=186, UUID=295, NCHAR=287, EXECUTE=39, OWNER=87, INPUT=181, TABLE=113, 
		VARCHAR=286, FLOAT=281, VERSION=257, MICROSECONDS=197, IMMUTABLE=56, ASYMMETRIC=8, 
		SUM=240, UnterminatedQuotedIdentifier=339, OWNED=86, Space=342, INOUT=65, 
		STORAGE=236, TIME=290, AS=3, RIGHT_PAREN=319, THEN=116, MAXVALUE=196, 
		COLLATION=17, DOUBLE_UNDER_DOLLAR=332, LEFT=72, REPLACE=97, AVG=135, ZONE=263, 
		TRUNCATE=121, COLUMN=146, TRUSTED=118, PLUS=320, EXISTS=167, NVARCHAR=288, 
		Not_Similar_To=303, RETURNS=99, LIKE=73, COLLATE=16, INTEGER=275, OUTER=81, 
		BY=137, DEFERRABLE=27, TO=249, SET=231, RIGHT=101, HAVING=51, MIN=200, 
		SESSION=107, MINUS=321, TEXT=294, HOUR=177, QuotedIdentifier=338, CONCATENATION_OPERATOR=312, 
		CONVERSION=21, UNION=122, CURRENT=154, COLON=309, COMMIT=149, SCHEMA=103, 
		DATABASE=24, DECIMAL=284, DROP=164, BIGINT=276, WHEN=130, ROWS=95, START=235, 
		BIT=266, LARGE=189, REVOKE=100, NATURAL=76, FORMAT=173, PUBLIC=218, AGGREGATE=1, 
		EXTENSION=40, BETWEEN=136, OPTIONS=211, FIRST=172, CAST=15, WEEK=259, 
		EXTERNAL=168, DOUBLE_QUOTE=329, VARYING=256, RESET=224, TRIGGER=119, CASE=13, 
		CHAR=285, INT8=271, COUNT=152, DAY=157, CASCADE=14, COST=151, INT2=269, 
		INT1=268, Identifier=337, INT4=270, ISCACHABLE=184, QUOTE=328, MODULAR=324, 
		INVOKER=67, FULL=44, DICTIONARY=161, THAN=244, QUARTER=220, INSERT=182, 
		INHERITS=59, CONNECT=18, INTERSECTION=183, LESS=191, TINYINT=272, BOTH=12, 
		Similar_To_Case_Insensitive=304, DOUBLE=282, ADMIN=134, SYMMETRIC=112, 
		VOID=301, ISSTRICT=187, EACH=33, LAST=190, COMMENT=147, SELECT=106, INTO=64, 
		UNIQUE=123, COALESCE=145, SECOND=228, ROLE=93, RULE=102, VIEW=129, EPOCH=165, 
		ROLLUP=226, NULL=78, WITHOUT=133, NO=205, EVERY=166, ON=209, MATCH=194, 
		PRIMARY=89, DELETE=29, INET4=300, NUMERIC=283, LOCAL=75, OF=79, EXCLUDING=38, 
		LIST=192, TABLES=242, UNDERLINE=326, SEQUENCE=104, Not_Similar_To_Case_Insensitive=305, 
		CUBE=153, NATIONAL=204, CALLED=139, VAR_POP=255, OR=84, FILTER=171, CHECK=143, 
		INLINE=61, FROM=47, FALSE=41, COLLECT=144, PARSER=213, DISTINCT=31, TEMPORARY=115, 
		TIMESTAMP=292, SIMPLE=233, DOLLAR=330, CONSTRAINTS=20, WHERE=131, DEC=158, 
		VAR_SAMP=254, NULLIF=207, CLASS=140, TIMETZ=291, INNER=62, YEAR=262, TIMEZONE=245, 
		ORDER=85, AUTHORIZATION=10, LIMIT=74, DECADE=159, GTH=316, CYCLE=155, 
		White_Space=343, MAX=195, UPDATE=124, LineComment=336, DEFERRED=28, FOR=42, 
		FLOAT4=277, CONFIGURATION=150, FLOAT8=278, AND=6, CROSS=23, Similar_To=302, 
		USAGE=125, IF=53, INDEX=178, OIDS=80, BOOLEAN=264, IN=57, MINVALUE=201, 
		UNKNOWN=251, MULTIPLY=322, OBJECT=208, COMMA=311, REFERENCES=96, PARTITION=215, 
		IS=68, PARTITIONS=216, SOME=109, EQUAL=308, ALL=4, DOUBLE_DOLLAR=331, 
		DOT=325, EXTRACT=169, CENTURY=141, STABLE=234, SECURITY=229, PARTIAL=214, 
		DOW=162, EXCLUDE=37, WITH=132, INITIALLY=60, DOY=163, FUSION=174, GRANT=49, 
		VARBINARY=297, VOLATILE=258, OPERATOR=83, DEFAULT=25, VALUES=253, HASH=176, 
		RANGE=221, MILLENNIUM=198, INDEXES=179, PURGE=219, BEFORE=11, AFTER=2, 
		INSTEAD=66, WRAPPER=261, TRUE=120, PROCEDURE=91, JOIN=69, SIMILAR=232, 
		DOMAIN=32, DEFAULTS=26, LTH=314, INCREMENT=180, ANY=7, TEMPLATE=243, BAD=344, 
		ASSIGN=307, REGCLASS=280, IMMEDIATE=55, WINDOW=260, BINARY=296, DESC=30, 
		DATE=289, MINUTE=202, GLOBAL=48, DATA=156, INCLUDING=58, LEQ=315, SMALLINT=273;
	public static final String[] tokenNames = {
		"<INVALID>", "AGGREGATE", "AFTER", "AS", "ALL", "ALTER", "AND", "ANY", 
		"ASYMMETRIC", "ASC", "AUTHORIZATION", "BEFORE", "BOTH", "CASE", "CASCADE", 
		"CAST", "COLLATE", "COLLATION", "CONNECT", "CONSTRAINT", "CONSTRAINTS", 
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
		"WITH", "WITHOUT", "ADMIN", "AVG", "BETWEEN", "BY", "CACHE", "CALLED", 
		"CLASS", "CENTURY", "CHARACTER", "CHECK", "COLLECT", "COALESCE", "COLUMN", 
		"COMMENT", "COMMENTS", "COMMIT", "CONFIGURATION", "COST", "COUNT", "CUBE", 
		"CURRENT", "CYCLE", "DATA", "DAY", "DEC", "DECADE", "DEFINER", "DICTIONARY", 
		"DOW", "DOY", "DROP", "EPOCH", "EVERY", "EXISTS", "EXTERNAL", "EXTRACT", 
		"FAMILY", "FILTER", "FIRST", "FORMAT", "FUSION", "GROUPING", "HASH", "HOUR", 
		"INDEX", "INDEXES", "INCREMENT", "INPUT", "INSERT", "INTERSECTION", "ISCACHABLE", 
		"ISODOW", "ISOYEAR", "ISSTRICT", "LANGUAGE", "LARGE", "LAST", "LESS", 
		"LIST", "LOCATION", "MATCH", "MAX", "MAXVALUE", "MICROSECONDS", "MILLENNIUM", 
		"MILLISECONDS", "MIN", "MINVALUE", "MINUTE", "MONTH", "NATIONAL", "NO", 
		"NONE", "NULLIF", "OBJECT", "ON", "OPTION", "OPTIONS", "OVERWRITE", "PARSER", 
		"PARTIAL", "PARTITION", "PARTITIONS", "PRECISION", "PUBLIC", "PURGE", 
		"QUARTER", "RANGE", "REGEXP", "RENAME", "RESET", "RLIKE", "ROLLUP", "SEARCH", 
		"SECOND", "SECURITY", "SERVER", "SET", "SIMILAR", "SIMPLE", "STABLE", 
		"START", "STORAGE", "STDDEV_POP", "STDDEV_SAMP", "SUBPARTITION", "SUM", 
		"TABLESPACE", "TABLES", "TEMPLATE", "THAN", "TIMEZONE", "TIMEZONE_HOUR", 
		"TIMEZONE_MINUTE", "TRIM", "TO", "TYPE", "UNKNOWN", "UNLOGGED", "VALUES", 
		"VAR_SAMP", "VAR_POP", "VARYING", "VERSION", "VOLATILE", "WEEK", "WINDOW", 
		"WRAPPER", "YEAR", "ZONE", "BOOLEAN", "BOOL", "BIT", "VARBIT", "INT1", 
		"INT2", "INT4", "INT8", "TINYINT", "SMALLINT", "INT", "INTEGER", "BIGINT", 
		"FLOAT4", "FLOAT8", "REAL", "REGCLASS", "FLOAT", "DOUBLE", "NUMERIC", 
		"DECIMAL", "CHAR", "VARCHAR", "NCHAR", "NVARCHAR", "DATE", "TIME", "TIMETZ", 
		"TIMESTAMP", "TIMESTAMPTZ", "TEXT", "UUID", "BINARY", "VARBINARY", "BLOB", 
		"BYTEA", "INET4", "VOID", "'~'", "'!~'", "'~*'", "'!~*'", "CAST_EXPRESSION", 
		"':='", "'='", "':'", "';'", "','", "CONCATENATION_OPERATOR", "NOT_EQUAL", 
		"'<'", "'<='", "'>'", "'>='", "'('", "')'", "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'.'", "'_'", "'|'", "'''", "'\"'", "'$'", "'$$'", "'$_$'", "NUMBER", 
		"REAL_NUMBER", "BlockComment", "LineComment", "Identifier", "QuotedIdentifier", 
		"UnterminatedQuotedIdentifier", "Character_String_Literal", "ESC_SEQUENCES", 
		"' '", "White_Space", "BAD"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_data_statement = 2, RULE_data_change_statement = 3, 
		RULE_schema_statement = 4, RULE_schema_create = 5, RULE_schema_alter = 6, 
		RULE_alter_function_statement = 7, RULE_alter_schema_statement = 8, RULE_alter_language_statement = 9, 
		RULE_function_action = 10, RULE_index_statement = 11, RULE_create_extension_statement = 12, 
		RULE_create_language_statement = 13, RULE_set_statement = 14, RULE_create_trigger_statement = 15, 
		RULE_revoke_statement = 16, RULE_revoke_from_cascade_restrict = 17, RULE_grant_statement = 18, 
		RULE_grant_to_rule = 19, RULE_comment_on_statement = 20, RULE_create_function_statement = 21, 
		RULE_function_parameters = 22, RULE_function_body = 23, RULE_function_body_separator = 24, 
		RULE_function_body_separator_dollar_under = 25, RULE_function_attribute = 26, 
		RULE_argmode = 27, RULE_function_definition = 28, RULE_functions_definition_schema = 29, 
		RULE_create_sequence_statement = 30, RULE_create_schema_statement = 31, 
		RULE_create_view_statement = 32, RULE_query = 33, RULE_create_table_statement = 34, 
		RULE_like_option = 35, RULE_table_constraint = 36, RULE_column_constraint = 37, 
		RULE_check_boolean_expression = 38, RULE_storage_parameter = 39, RULE_storage_parameter_oid = 40, 
		RULE_on_commit = 41, RULE_table_space = 42, RULE_action = 43, RULE_index_parameters = 44, 
		RULE_table_elements = 45, RULE_field_element = 46, RULE_field_type = 47, 
		RULE_param_clause = 48, RULE_param = 49, RULE_method_specifier = 50, RULE_table_space_specifier = 51, 
		RULE_table_space_name = 52, RULE_table_partitioning_clauses = 53, RULE_range_partitions = 54, 
		RULE_range_value_clause_list = 55, RULE_range_value_clause = 56, RULE_hash_partitions = 57, 
		RULE_individual_hash_partitions = 58, RULE_individual_hash_partition = 59, 
		RULE_hash_partitions_by_quantity = 60, RULE_list_partitions = 61, RULE_list_value_clause_list = 62, 
		RULE_list_value_partition = 63, RULE_column_partitions = 64, RULE_partition_name = 65, 
		RULE_drop_table_statement = 66, RULE_identifier = 67, RULE_nonreserved_keywords = 68, 
		RULE_unsigned_literal = 69, RULE_general_literal = 70, RULE_datetime_literal = 71, 
		RULE_time_literal = 72, RULE_timestamp_literal = 73, RULE_date_literal = 74, 
		RULE_boolean_literal = 75, RULE_data_type = 76, RULE_predefined_type = 77, 
		RULE_regclass = 78, RULE_network_type = 79, RULE_character_string_type = 80, 
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
		RULE_common_value_expression = 117, RULE_numeric_value_expression = 118, 
		RULE_term = 119, RULE_factor = 120, RULE_array = 121, RULE_numeric_primary = 122, 
		RULE_sign = 123, RULE_numeric_value_function = 124, RULE_extract_expression = 125, 
		RULE_extract_field = 126, RULE_time_zone_field = 127, RULE_extract_source = 128, 
		RULE_string_value_expression = 129, RULE_character_value_expression = 130, 
		RULE_character_factor = 131, RULE_character_primary = 132, RULE_string_value_function = 133, 
		RULE_trim_function = 134, RULE_trim_operands = 135, RULE_trim_specification = 136, 
		RULE_boolean_value_expression = 137, RULE_or_predicate = 138, RULE_and_predicate = 139, 
		RULE_boolean_factor = 140, RULE_boolean_test = 141, RULE_is_clause = 142, 
		RULE_truth_value = 143, RULE_boolean_primary = 144, RULE_boolean_predicand = 145, 
		RULE_parenthesized_boolean_value_expression = 146, RULE_row_value_expression = 147, 
		RULE_row_value_special_case = 148, RULE_explicit_row_value_constructor = 149, 
		RULE_row_value_predicand = 150, RULE_row_value_constructor_predicand = 151, 
		RULE_table_expression = 152, RULE_from_clause = 153, RULE_table_reference_list = 154, 
		RULE_table_reference = 155, RULE_joined_table = 156, RULE_joined_table_primary = 157, 
		RULE_cross_join = 158, RULE_qualified_join = 159, RULE_natural_join = 160, 
		RULE_union_join = 161, RULE_join_type = 162, RULE_outer_join_type = 163, 
		RULE_outer_join_type_part2 = 164, RULE_join_specification = 165, RULE_join_condition = 166, 
		RULE_named_columns_join = 167, RULE_table_primary = 168, RULE_column_name_list = 169, 
		RULE_derived_table = 170, RULE_where_clause = 171, RULE_search_condition = 172, 
		RULE_groupby_clause = 173, RULE_grouping_element_list = 174, RULE_grouping_element = 175, 
		RULE_ordinary_grouping_set = 176, RULE_ordinary_grouping_set_list = 177, 
		RULE_rollup_list = 178, RULE_cube_list = 179, RULE_empty_grouping_set = 180, 
		RULE_having_clause = 181, RULE_row_value_predicand_list = 182, RULE_query_expression = 183, 
		RULE_query_expression_body = 184, RULE_non_join_query_expression = 185, 
		RULE_query_term = 186, RULE_non_join_query_term = 187, RULE_query_primary = 188, 
		RULE_non_join_query_primary = 189, RULE_simple_table = 190, RULE_explicit_table = 191, 
		RULE_table_or_query_name = 192, RULE_schema_qualified_name = 193, RULE_query_specification = 194, 
		RULE_select_list = 195, RULE_select_sublist = 196, RULE_derived_column = 197, 
		RULE_qualified_asterisk = 198, RULE_set_qualifier = 199, RULE_column_reference = 200, 
		RULE_as_clause = 201, RULE_column_reference_list = 202, RULE_scalar_subquery = 203, 
		RULE_row_subquery = 204, RULE_table_subquery = 205, RULE_subquery = 206, 
		RULE_predicate = 207, RULE_comparison_predicate = 208, RULE_comp_op = 209, 
		RULE_between_predicate = 210, RULE_between_predicate_part_2 = 211, RULE_in_predicate = 212, 
		RULE_in_predicate_value = 213, RULE_in_value_list = 214, RULE_pattern_matching_predicate = 215, 
		RULE_pattern_matcher = 216, RULE_negativable_matcher = 217, RULE_regex_matcher = 218, 
		RULE_null_predicate = 219, RULE_quantified_comparison_predicate = 220, 
		RULE_quantifier = 221, RULE_all = 222, RULE_some = 223, RULE_exists_predicate = 224, 
		RULE_unique_predicate = 225, RULE_primary_datetime_field = 226, RULE_non_second_primary_datetime_field = 227, 
		RULE_extended_datetime_field = 228, RULE_routine_invocation = 229, RULE_function_names_for_reserved_words = 230, 
		RULE_function_name = 231, RULE_sql_argument_list = 232, RULE_orderby_clause = 233, 
		RULE_sort_specifier_list = 234, RULE_sort_specifier = 235, RULE_order_specification = 236, 
		RULE_limit_clause = 237, RULE_null_ordering = 238, RULE_insert_statement = 239;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"schema_create", "schema_alter", "alter_function_statement", "alter_schema_statement", 
		"alter_language_statement", "function_action", "index_statement", "create_extension_statement", 
		"create_language_statement", "set_statement", "create_trigger_statement", 
		"revoke_statement", "revoke_from_cascade_restrict", "grant_statement", 
		"grant_to_rule", "comment_on_statement", "create_function_statement", 
		"function_parameters", "function_body", "function_body_separator", "function_body_separator_dollar_under", 
		"function_attribute", "argmode", "function_definition", "functions_definition_schema", 
		"create_sequence_statement", "create_schema_statement", "create_view_statement", 
		"query", "create_table_statement", "like_option", "table_constraint", 
		"column_constraint", "check_boolean_expression", "storage_parameter", 
		"storage_parameter_oid", "on_commit", "table_space", "action", "index_parameters", 
		"table_elements", "field_element", "field_type", "param_clause", "param", 
		"method_specifier", "table_space_specifier", "table_space_name", "table_partitioning_clauses", 
		"range_partitions", "range_value_clause_list", "range_value_clause", "hash_partitions", 
		"individual_hash_partitions", "individual_hash_partition", "hash_partitions_by_quantity", 
		"list_partitions", "list_value_clause_list", "list_value_partition", "column_partitions", 
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
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALTER) | (1L << CREATE) | (1L << GRANT))) != 0) || _la==REVOKE || _la==COMMENT || _la==DROP || _la==SET) {
				{
				{
				setState(480); statement();
				setState(482);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(481); match(SEMI_COLON);
					}
				}

				}
				}
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(489); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(491); schema_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(493); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(495); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(500);
			switch (_input.LA(1)) {
			case CREATE:
			case GRANT:
			case REVOKE:
			case COMMENT:
			case SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(497); schema_create();
				}
				break;
			case ALTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(498); schema_alter();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 3);
				{
				setState(499); drop_table_statement();
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
			setState(515);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(502); create_table_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(503); index_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(504); create_extension_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(505); create_trigger_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(506); create_function_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(507); create_sequence_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(508); create_schema_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(509); create_view_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(510); comment_on_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(511); revoke_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(512); set_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(513); grant_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(514); create_language_statement();
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
			setState(520);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(517); alter_function_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(518); alter_schema_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(519); alter_language_statement();
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
			setState(558);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(522); match(ALTER);
				setState(523); match(FUNCTION);
				setState(524); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(525); function_parameters();
				setState(527); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(526); function_action();
					}
					}
					setState(529); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (RETURNS - 99)) | (1L << (STRICT - 99)) | (1L << (CALLED - 99)))) != 0) || _la==EXTERNAL || _la==SECURITY || _la==STABLE || _la==VOLATILE );
				setState(532);
				_la = _input.LA(1);
				if (_la==RESTRICT) {
					{
					setState(531); match(RESTRICT);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(534); match(ALTER);
				setState(535); match(FUNCTION);
				setState(536); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(537); function_parameters();
				setState(538); match(RENAME);
				setState(539); match(TO);
				setState(540); ((Alter_function_statementContext)_localctx).new_name = schema_qualified_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(542); match(ALTER);
				setState(543); match(FUNCTION);
				setState(544); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(545); function_parameters();
				setState(546); match(OWNER);
				setState(547); match(TO);
				setState(548); ((Alter_function_statementContext)_localctx).new_owner = identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(550); match(ALTER);
				setState(551); match(FUNCTION);
				setState(552); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(553); function_parameters();
				setState(554); match(SET);
				setState(555); match(SCHEMA);
				setState(556); ((Alter_function_statementContext)_localctx).new_schema = schema_qualified_name();
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
			setState(574);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(560); match(ALTER);
				setState(561); match(SCHEMA);
				setState(562); ((Alter_schema_statementContext)_localctx).name = identifier();
				setState(563); match(RENAME);
				setState(564); match(TO);
				setState(565); ((Alter_schema_statementContext)_localctx).new_name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(567); match(ALTER);
				setState(568); match(SCHEMA);
				setState(569); ((Alter_schema_statementContext)_localctx).name = identifier();
				setState(570); match(OWNER);
				setState(571); match(TO);
				setState(572); ((Alter_schema_statementContext)_localctx).new_owner = identifier();
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
			setState(596);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(576); match(ALTER);
				setState(578);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(577); match(PROCEDURAL);
					}
				}

				setState(580); match(LANGUAGE);
				setState(581); ((Alter_language_statementContext)_localctx).name = identifier();
				setState(582); match(RENAME);
				setState(583); match(TO);
				setState(584); ((Alter_language_statementContext)_localctx).new_name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(586); match(ALTER);
				setState(588);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(587); match(PROCEDURAL);
					}
				}

				setState(590); match(LANGUAGE);
				setState(591); ((Alter_language_statementContext)_localctx).name = identifier();
				setState(592); match(OWNER);
				setState(593); match(TO);
				setState(594); ((Alter_language_statementContext)_localctx).new_owner = identifier();
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
		enterRule(_localctx, 20, RULE_function_action);
		int _la;
		try {
			setState(643);
			switch (_input.LA(1)) {
			case CALLED:
				enterOuterAlt(_localctx, 1);
				{
				setState(598); match(CALLED);
				setState(599); match(ON);
				setState(600); match(NULL);
				setState(601); match(INPUT);
				}
				break;
			case RETURNS:
				enterOuterAlt(_localctx, 2);
				{
				setState(602); match(RETURNS);
				setState(603); match(NULL);
				setState(604); match(ON);
				setState(605); match(NULL);
				setState(606); match(INPUT);
				}
				break;
			case STRICT:
				enterOuterAlt(_localctx, 3);
				{
				setState(607); match(STRICT);
				setState(608); match(IMMUTABLE);
				}
				break;
			case STABLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(609); match(STABLE);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(610); match(VOLATILE);
				setState(612);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(611); match(EXTERNAL);
					}
				}

				setState(614); match(SECURITY);
				setState(615); match(INVOKER);
				}
				break;
			case EXTERNAL:
			case SECURITY:
				enterOuterAlt(_localctx, 6);
				{
				setState(617);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(616); match(EXTERNAL);
					}
				}

				setState(619); match(SECURITY);
				setState(620); match(DEFINER);
				setState(621); match(COST);
				setState(622); ((Function_actionContext)_localctx).execution_cost = match(NUMBER);
				setState(623); match(ROWS);
				setState(624); ((Function_actionContext)_localctx).result_rows = match(NUMBER);
				setState(625); match(SET);
				setState(626); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(632);
				switch (_input.LA(1)) {
				case TO:
					{
					setState(627); match(TO);
					setState(628); ((Function_actionContext)_localctx).value = identifier();
					}
					break;
				case EQUAL:
					{
					setState(629); match(EQUAL);
					setState(630); ((Function_actionContext)_localctx).value = identifier();
					}
					break;
				case DEFAULT:
					{
					setState(631); match(DEFAULT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(634); match(SET);
				setState(635); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(636); match(FROM);
				setState(637); match(CURRENT);
				setState(638); match(RESET);
				setState(639); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(640); match(RESET);
				setState(641); match(ALL);
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
		enterRule(_localctx, 22, RULE_index_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645); match(CREATE);
			setState(647);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(646); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(649); match(INDEX);
			setState(650); ((Index_statementContext)_localctx).n = identifier();
			setState(651); match(ON);
			setState(652); ((Index_statementContext)_localctx).t = schema_qualified_name();
			setState(654);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(653); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(656); match(LEFT_PAREN);
			setState(657); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(658); match(RIGHT_PAREN);
			setState(660);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(659); ((Index_statementContext)_localctx).p = param_clause();
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
		enterRule(_localctx, 24, RULE_create_extension_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(662); match(CREATE);
			setState(663); match(EXTENSION);
			setState(667);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(664); match(IF);
				setState(665); match(NOT);
				setState(666); match(EXISTS);
				}
			}

			setState(669); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(671);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(670); match(WITH);
				}
			}

			setState(675);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(673); match(SCHEMA);
				setState(674); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(679);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(677); match(VERSION);
				setState(678); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(683);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(681); match(FROM);
				setState(682); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
		enterRule(_localctx, 26, RULE_create_language_statement);
		int _la;
		try {
			setState(718);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(685); match(CREATE);
				setState(688);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(686); match(OR);
					setState(687); match(REPLACE);
					}
				}

				setState(691);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(690); match(PROCEDURAL);
					}
				}

				setState(693); match(LANGUAGE);
				setState(694); ((Create_language_statementContext)_localctx).name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(695); match(CREATE);
				setState(698);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(696); match(OR);
					setState(697); match(REPLACE);
					}
				}

				setState(701);
				_la = _input.LA(1);
				if (_la==TRUSTED) {
					{
					setState(700); match(TRUSTED);
					}
				}

				setState(704);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(703); match(PROCEDURAL);
					}
				}

				setState(706); match(LANGUAGE);
				setState(707); ((Create_language_statementContext)_localctx).name = identifier();
				setState(708); match(HANDLER);
				setState(709); ((Create_language_statementContext)_localctx).call_handler = schema_qualified_name();
				setState(712);
				_la = _input.LA(1);
				if (_la==INLINE) {
					{
					setState(710); match(INLINE);
					setState(711); ((Create_language_statementContext)_localctx).inline_handler = schema_qualified_name();
					}
				}

				setState(716);
				_la = _input.LA(1);
				if (_la==VALIDATOR) {
					{
					setState(714); match(VALIDATOR);
					setState(715); ((Create_language_statementContext)_localctx).valfunction = schema_qualified_name();
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
		enterRule(_localctx, 28, RULE_set_statement);
		int _la;
		try {
			int _alt;
			setState(759);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(720); match(SET);
				setState(722);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(721);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(724); ((Set_statementContext)_localctx).config_param = identifier();
				setState(725);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(737); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(732);
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
						case AVG:
						case BETWEEN:
						case BY:
						case CACHE:
						case CALLED:
						case CLASS:
						case CENTURY:
						case CHARACTER:
						case CHECK:
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
						case DOW:
						case DOY:
						case DROP:
						case EPOCH:
						case EVERY:
						case EXISTS:
						case EXTERNAL:
						case EXTRACT:
						case FAMILY:
						case FILTER:
						case FIRST:
						case FORMAT:
						case FUSION:
						case GROUPING:
						case HASH:
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
						case OPTION:
						case OPTIONS:
						case OVERWRITE:
						case PARSER:
						case PARTIAL:
						case PARTITION:
						case PARTITIONS:
						case PRECISION:
						case PUBLIC:
						case PURGE:
						case QUARTER:
						case RANGE:
						case REGEXP:
						case RENAME:
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
						case VALUES:
						case VAR_SAMP:
						case VAR_POP:
						case VARYING:
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
							setState(726); ((Set_statementContext)_localctx).value = value_expression();
							}
							break;
						case QUOTE:
							{
							setState(727); match(QUOTE);
							setState(728); ((Set_statementContext)_localctx).value = value_expression();
							setState(729); match(QUOTE);
							}
							break;
						case DEFAULT:
							{
							setState(731); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(735);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(734); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(739); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(741); match(SET);
				setState(743);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(742);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(745); match(TIME);
				setState(746); match(ZONE);
				setState(755); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(750);
						switch (_input.LA(1)) {
						case ADMIN:
						case AVG:
						case BETWEEN:
						case BY:
						case CACHE:
						case CALLED:
						case CLASS:
						case CENTURY:
						case CHARACTER:
						case CHECK:
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
						case DOW:
						case DOY:
						case DROP:
						case EPOCH:
						case EVERY:
						case EXISTS:
						case EXTERNAL:
						case EXTRACT:
						case FAMILY:
						case FILTER:
						case FIRST:
						case FORMAT:
						case FUSION:
						case GROUPING:
						case HASH:
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
						case OPTION:
						case OPTIONS:
						case OVERWRITE:
						case PARSER:
						case PARTIAL:
						case PARTITION:
						case PARTITIONS:
						case PRECISION:
						case PUBLIC:
						case PURGE:
						case QUARTER:
						case RANGE:
						case REGEXP:
						case RENAME:
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
						case VALUES:
						case VAR_SAMP:
						case VAR_POP:
						case VARYING:
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
						case VOID:
						case DOUBLE_QUOTE:
						case Identifier:
						case QuotedIdentifier:
							{
							setState(747); ((Set_statementContext)_localctx).timezone = identifier();
							}
							break;
						case LOCAL:
							{
							setState(748); match(LOCAL);
							}
							break;
						case DEFAULT:
							{
							setState(749); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(753);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(752); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(757); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
		enterRule(_localctx, 30, RULE_create_trigger_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(761); match(CREATE);
			setState(763);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(762); match(CONSTRAINT);
				}
			}

			setState(765); match(TRIGGER);
			setState(766); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(771);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(767); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(768); match(INSTEAD);
				setState(769); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(770); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(788);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(773); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(774); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(775); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				{
				setState(776); match(UPDATE);
				setState(786);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(777); match(OF);
					setState(782); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(778); ((Create_trigger_statementContext)_localctx).columnName = identifier();
							setState(780);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(779); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(784); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(790); match(ON);
			setState(791); ((Create_trigger_statementContext)_localctx).tabl_name = schema_qualified_name();
			setState(794);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(792); match(FROM);
				setState(793); ((Create_trigger_statementContext)_localctx).referenced_table_name = schema_qualified_name();
				}
			}

			setState(805);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(796); match(NOT);
				setState(797); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(799);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(798); match(DEFERRABLE);
					}
				}

				{
				setState(801); match(INITIALLY);
				setState(802); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(803); match(INITIALLY);
				setState(804); match(DEFERRED);
				}
				}
				break;
			}
			setState(813);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(807); match(FOR);
				setState(809);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(808); match(EACH);
					}
				}

				setState(811); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(812); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(817);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(815); match(WHEN);
				{
				setState(816); boolean_value_expression();
				}
				}
			}

			setState(819); match(EXECUTE);
			setState(820); match(PROCEDURE);
			setState(821); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(822); match(LEFT_PAREN);
			setState(827);
			_la = _input.LA(1);
			if (((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0)) {
				{
				setState(823); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(825);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(824); match(COMMA);
					}
				}

				}
			}

			setState(829); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 32, RULE_revoke_statement);
		int _la;
		try {
			int _alt;
			setState(1210);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(831); match(REVOKE);
				setState(835);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(832); match(GRANT);
					setState(833); match(OPTION);
					setState(834); match(FOR);
					}
				}

				setState(846);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(838); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(837);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (REFERENCES - 96)) | (1L << (SELECT - 96)) | (1L << (TRIGGER - 96)) | (1L << (TRUNCATE - 96)) | (1L << (UPDATE - 96)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(840); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (REFERENCES - 96)) | (1L << (SELECT - 96)) | (1L << (TRIGGER - 96)) | (1L << (TRUNCATE - 96)) | (1L << (UPDATE - 96)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(842); match(ALL);
					setState(844);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(843); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(848); match(ON);
				setState(866);
				switch (_input.LA(1)) {
				case TABLE:
				case ADMIN:
				case AVG:
				case BETWEEN:
				case BY:
				case CACHE:
				case CALLED:
				case CLASS:
				case CENTURY:
				case CHARACTER:
				case CHECK:
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
				case DOW:
				case DOY:
				case DROP:
				case EPOCH:
				case EVERY:
				case EXISTS:
				case EXTERNAL:
				case EXTRACT:
				case FAMILY:
				case FILTER:
				case FIRST:
				case FORMAT:
				case FUSION:
				case GROUPING:
				case HASH:
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
				case OPTION:
				case OPTIONS:
				case OVERWRITE:
				case PARSER:
				case PARTIAL:
				case PARTITION:
				case PARTITIONS:
				case PRECISION:
				case PUBLIC:
				case PURGE:
				case QUARTER:
				case RANGE:
				case REGEXP:
				case RENAME:
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
				case VALUES:
				case VAR_SAMP:
				case VAR_POP:
				case VARYING:
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
				case VOID:
				case DOUBLE_QUOTE:
				case Identifier:
				case QuotedIdentifier:
					{
					setState(853); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(850);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(849); match(TABLE);
							}
						}

						setState(852); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
						}
						}
						setState(855); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (TABLE - 113)) | (1L << (ADMIN - 113)) | (1L << (AVG - 113)) | (1L << (BETWEEN - 113)) | (1L << (BY - 113)) | (1L << (CACHE - 113)) | (1L << (CALLED - 113)) | (1L << (CLASS - 113)) | (1L << (CENTURY - 113)) | (1L << (CHARACTER - 113)) | (1L << (CHECK - 113)) | (1L << (COLLECT - 113)) | (1L << (COALESCE - 113)) | (1L << (COLUMN - 113)) | (1L << (COMMENT - 113)) | (1L << (COMMENTS - 113)) | (1L << (COMMIT - 113)) | (1L << (CONFIGURATION - 113)) | (1L << (COST - 113)) | (1L << (COUNT - 113)) | (1L << (CUBE - 113)) | (1L << (CURRENT - 113)) | (1L << (CYCLE - 113)) | (1L << (DATA - 113)) | (1L << (DAY - 113)) | (1L << (DEC - 113)) | (1L << (DECADE - 113)) | (1L << (DEFINER - 113)) | (1L << (DICTIONARY - 113)) | (1L << (DOW - 113)) | (1L << (DOY - 113)) | (1L << (DROP - 113)) | (1L << (EPOCH - 113)) | (1L << (EVERY - 113)) | (1L << (EXISTS - 113)) | (1L << (EXTERNAL - 113)) | (1L << (EXTRACT - 113)) | (1L << (FAMILY - 113)) | (1L << (FILTER - 113)) | (1L << (FIRST - 113)) | (1L << (FORMAT - 113)) | (1L << (FUSION - 113)) | (1L << (GROUPING - 113)) | (1L << (HASH - 113)))) != 0) || ((((_la - 178)) & ~0x3f) == 0 && ((1L << (_la - 178)) & ((1L << (INDEX - 178)) | (1L << (INCREMENT - 178)) | (1L << (INPUT - 178)) | (1L << (INSERT - 178)) | (1L << (INTERSECTION - 178)) | (1L << (ISCACHABLE - 178)) | (1L << (ISODOW - 178)) | (1L << (ISOYEAR - 178)) | (1L << (ISSTRICT - 178)) | (1L << (LANGUAGE - 178)) | (1L << (LARGE - 178)) | (1L << (LAST - 178)) | (1L << (LESS - 178)) | (1L << (LIST - 178)) | (1L << (LOCATION - 178)) | (1L << (MATCH - 178)) | (1L << (MAX - 178)) | (1L << (MAXVALUE - 178)) | (1L << (MICROSECONDS - 178)) | (1L << (MILLENNIUM - 178)) | (1L << (MILLISECONDS - 178)) | (1L << (MIN - 178)) | (1L << (MINVALUE - 178)) | (1L << (MINUTE - 178)) | (1L << (MONTH - 178)) | (1L << (NATIONAL - 178)) | (1L << (NO - 178)) | (1L << (NONE - 178)) | (1L << (NULLIF - 178)) | (1L << (OBJECT - 178)) | (1L << (ON - 178)) | (1L << (OPTION - 178)) | (1L << (OPTIONS - 178)) | (1L << (OVERWRITE - 178)) | (1L << (PARSER - 178)) | (1L << (PARTIAL - 178)) | (1L << (PARTITION - 178)) | (1L << (PARTITIONS - 178)) | (1L << (PRECISION - 178)) | (1L << (PUBLIC - 178)) | (1L << (PURGE - 178)) | (1L << (QUARTER - 178)) | (1L << (RANGE - 178)) | (1L << (REGEXP - 178)) | (1L << (RENAME - 178)) | (1L << (RESET - 178)) | (1L << (RLIKE - 178)) | (1L << (ROLLUP - 178)) | (1L << (SEARCH - 178)) | (1L << (SECOND - 178)) | (1L << (SECURITY - 178)) | (1L << (SERVER - 178)) | (1L << (SET - 178)) | (1L << (SIMILAR - 178)) | (1L << (SIMPLE - 178)) | (1L << (STABLE - 178)) | (1L << (START - 178)) | (1L << (STORAGE - 178)) | (1L << (STDDEV_POP - 178)) | (1L << (STDDEV_SAMP - 178)) | (1L << (SUBPARTITION - 178)) | (1L << (SUM - 178)) | (1L << (TABLESPACE - 178)))) != 0) || ((((_la - 243)) & ~0x3f) == 0 && ((1L << (_la - 243)) & ((1L << (TEMPLATE - 243)) | (1L << (THAN - 243)) | (1L << (TIMEZONE - 243)) | (1L << (TIMEZONE_HOUR - 243)) | (1L << (TIMEZONE_MINUTE - 243)) | (1L << (TRIM - 243)) | (1L << (TO - 243)) | (1L << (TYPE - 243)) | (1L << (UNKNOWN - 243)) | (1L << (UNLOGGED - 243)) | (1L << (VALUES - 243)) | (1L << (VAR_SAMP - 243)) | (1L << (VAR_POP - 243)) | (1L << (VARYING - 243)) | (1L << (VOLATILE - 243)) | (1L << (WEEK - 243)) | (1L << (WINDOW - 243)) | (1L << (WRAPPER - 243)) | (1L << (YEAR - 243)) | (1L << (ZONE - 243)) | (1L << (BOOLEAN - 243)) | (1L << (BOOL - 243)) | (1L << (BIT - 243)) | (1L << (VARBIT - 243)) | (1L << (INT1 - 243)) | (1L << (INT2 - 243)) | (1L << (INT4 - 243)) | (1L << (INT8 - 243)) | (1L << (TINYINT - 243)) | (1L << (SMALLINT - 243)) | (1L << (INT - 243)) | (1L << (INTEGER - 243)) | (1L << (BIGINT - 243)) | (1L << (FLOAT4 - 243)) | (1L << (FLOAT8 - 243)) | (1L << (REAL - 243)) | (1L << (FLOAT - 243)) | (1L << (DOUBLE - 243)) | (1L << (NUMERIC - 243)) | (1L << (DECIMAL - 243)) | (1L << (CHAR - 243)) | (1L << (VARCHAR - 243)) | (1L << (NCHAR - 243)) | (1L << (NVARCHAR - 243)) | (1L << (DATE - 243)) | (1L << (TIME - 243)) | (1L << (TIMETZ - 243)) | (1L << (TIMESTAMP - 243)) | (1L << (TIMESTAMPTZ - 243)) | (1L << (TEXT - 243)) | (1L << (UUID - 243)) | (1L << (VARBINARY - 243)) | (1L << (BLOB - 243)) | (1L << (BYTEA - 243)) | (1L << (INET4 - 243)) | (1L << (VOID - 243)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(857); match(ALL);
					setState(858); match(TABLES);
					setState(859); match(IN);
					setState(860); match(SCHEMA);
					setState(862); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(861); ((Revoke_statementContext)_localctx).schema_name = identifier();
						}
						}
						setState(864); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(868); revoke_from_cascade_restrict();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(870); match(REVOKE);
				setState(874);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(871); match(GRANT);
					setState(872); match(OPTION);
					setState(873); match(FOR);
					}
				}

				setState(907);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(888); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(876);
						_la = _input.LA(1);
						if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (REFERENCES - 96)) | (1L << (SELECT - 96)) | (1L << (UPDATE - 96)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(877); match(LEFT_PAREN);
						setState(882); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(878); ((Revoke_statementContext)_localctx).column = identifier();
							setState(880);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(879); match(COMMA);
								}
							}

							}
							}
							setState(884); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
						setState(886); match(RIGHT_PAREN);
						}
						}
						setState(890); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (REFERENCES - 96)) | (1L << (SELECT - 96)) | (1L << (UPDATE - 96)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(892); match(ALL);
					setState(894);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(893); match(PRIVILEGES);
						}
					}

					setState(896); match(LEFT_PAREN);
					setState(901); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(897); ((Revoke_statementContext)_localctx).column = identifier();
						setState(899);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(898); match(COMMA);
							}
						}

						}
						}
						setState(903); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
					setState(905); match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(909); match(ON);
				setState(911);
				_la = _input.LA(1);
				if (_la==TABLE) {
					{
					setState(910); match(TABLE);
					}
				}

				setState(917); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(913); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
					setState(915);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(914); match(COMMA);
						}
					}

					}
					}
					setState(919); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(921); revoke_from_cascade_restrict();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(923); match(REVOKE);
				setState(927);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(924); match(GRANT);
					setState(925); match(OPTION);
					setState(926); match(FOR);
					}
				}

				setState(938);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(930); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(929);
						_la = _input.LA(1);
						if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (SELECT - 106)) | (1L << (UPDATE - 106)) | (1L << (USAGE - 106)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(932); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (SELECT - 106)) | (1L << (UPDATE - 106)) | (1L << (USAGE - 106)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(934); match(ALL);
					setState(936);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(935); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(940); match(ON);
				setState(962);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(941); match(SEQUENCE);
					setState(946); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(942); ((Revoke_statementContext)_localctx).sequence_name = schema_qualified_name();
						setState(944);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(943); match(COMMA);
							}
						}

						}
						}
						setState(948); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(950); match(ALL);
					setState(951); match(SEQUENCES);
					setState(952); match(IN);
					setState(953); match(SCHEMA);
					setState(958); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(954); ((Revoke_statementContext)_localctx).schema_name = identifier();
						setState(956);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(955); match(COMMA);
							}
						}

						}
						}
						setState(960); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(964); revoke_from_cascade_restrict();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(966); match(REVOKE);
				setState(970);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(967); match(GRANT);
					setState(968); match(OPTION);
					setState(969); match(FOR);
					}
				}

				setState(981);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(973); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(972);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(975); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(977); match(ALL);
					setState(979);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(978); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(983); match(ON);
				setState(984); match(DATABASE);
				setState(989); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(985); ((Revoke_statementContext)_localctx).database_name = identifier();
					setState(987);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(986); match(COMMA);
						}
					}

					}
					}
					setState(991); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(993); revoke_from_cascade_restrict();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(995); match(REVOKE);
				setState(999);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(996); match(GRANT);
					setState(997); match(OPTION);
					setState(998); match(FOR);
					}
				}

				setState(1006);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1001); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1002); match(ALL);
					setState(1004);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1003); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1008); match(ON);
				setState(1009); match(FOREIGN);
				setState(1010); match(DATA);
				setState(1011); match(WRAPPER);
				setState(1016); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1012); ((Revoke_statementContext)_localctx).fdw_name = schema_qualified_name();
					setState(1014);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1013); match(COMMA);
						}
					}

					}
					}
					setState(1018); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(1020); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1022); match(REVOKE);
				setState(1026);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1023); match(GRANT);
					setState(1024); match(OPTION);
					setState(1025); match(FOR);
					}
				}

				setState(1033);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1028); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1029); match(ALL);
					setState(1031);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1030); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1035); match(ON);
				setState(1036); match(FOREIGN);
				setState(1037); match(SERVER);
				setState(1042); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1038); ((Revoke_statementContext)_localctx).server_name = identifier();
					setState(1040);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1039); match(COMMA);
						}
					}

					}
					}
					setState(1044); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(1046); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1048); match(REVOKE);
				setState(1052);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1049); match(GRANT);
					setState(1050); match(OPTION);
					setState(1051); match(FOR);
					}
				}

				setState(1059);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1054); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1055); match(ALL);
					setState(1057);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1056); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1061); match(ON);
				setState(1064);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1062); function_definition();
					}
					break;
				case ALL:
					{
					setState(1063); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1066); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1068); match(REVOKE);
				setState(1072);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1069); match(GRANT);
					setState(1070); match(OPTION);
					setState(1071); match(FOR);
					}
				}

				setState(1079);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1074); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1075); match(ALL);
					setState(1077);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1076); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1081); match(ON);
				setState(1082); match(LANGUAGE);
				setState(1087); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1083); ((Revoke_statementContext)_localctx).lang_name = identifier();
					setState(1085);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1084); match(COMMA);
						}
					}

					}
					}
					setState(1089); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(1091); revoke_from_cascade_restrict();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1093); match(REVOKE);
				setState(1097);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1094); match(GRANT);
					setState(1095); match(OPTION);
					setState(1096); match(FOR);
					}
				}

				setState(1112);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1104); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(1104);
						switch (_input.LA(1)) {
						case SELECT:
							{
							setState(1099); match(SELECT);
							}
							break;
						case UPDATE:
							{
							setState(1100); match(UPDATE);
							setState(1102);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1101); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(1106); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1108); match(ALL);
					setState(1110);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1109); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1114); match(ON);
				setState(1115); match(LARGE);
				setState(1116); match(OBJECT);
				setState(1121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1117); ((Revoke_statementContext)_localctx).loid = identifier();
					setState(1119);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1118); match(COMMA);
						}
					}

					}
					}
					setState(1123); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(1125); revoke_from_cascade_restrict();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1127); match(REVOKE);
				setState(1131);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1128); match(GRANT);
					setState(1129); match(OPTION);
					setState(1130); match(FOR);
					}
				}

				setState(1145);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1137); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1133);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1135);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1134); match(COMMA);
							}
						}

						}
						}
						setState(1139); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1141); match(ALL);
					setState(1143);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1142); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1147); match(ON);
				setState(1148); match(SCHEMA);
				setState(1153); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1149); ((Revoke_statementContext)_localctx).schema_name = identifier();
					setState(1151);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1150); match(COMMA);
						}
					}

					}
					}
					setState(1155); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(1157); revoke_from_cascade_restrict();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1159); match(REVOKE);
				setState(1163);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1160); match(GRANT);
					setState(1161); match(OPTION);
					setState(1162); match(FOR);
					}
				}

				setState(1170);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1165); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1166); match(ALL);
					setState(1168);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1167); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1172); match(ON);
				setState(1173); match(TABLESPACE);
				setState(1178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1174); ((Revoke_statementContext)_localctx).tablespace_name = identifier();
					setState(1176);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1175); match(COMMA);
						}
					}

					}
					}
					setState(1180); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(1182); revoke_from_cascade_restrict();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1184); match(REVOKE);
				setState(1188);
				switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
				case 1:
					{
					setState(1185); match(ADMIN);
					setState(1186); match(OPTION);
					setState(1187); match(FOR);
					}
					break;
				}
				setState(1194); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1190); ((Revoke_statementContext)_localctx).role_name = identifier();
					setState(1192);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1191); match(COMMA);
						}
					}

					}
					}
					setState(1196); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(1198); match(FROM);
				setState(1203); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1199); ((Revoke_statementContext)_localctx).role_name = identifier();
						setState(1201);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1200); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1205); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1208);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(1207);
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
		enterRule(_localctx, 34, RULE_revoke_from_cascade_restrict);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1212); match(FROM);
			setState(1221); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1221);
					switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
					case 1:
						{
						setState(1214);
						_la = _input.LA(1);
						if (_la==GROUP) {
							{
							setState(1213); match(GROUP);
							}
						}

						setState(1216); ((Revoke_from_cascade_restrictContext)_localctx).role_name = identifier();
						}
						break;
					case 2:
						{
						setState(1217); match(PUBLIC);
						setState(1219);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1218); match(COMMA);
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
				setState(1223); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1226);
			_la = _input.LA(1);
			if (_la==CASCADE || _la==RESTRICT) {
				{
				setState(1225);
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
		enterRule(_localctx, 36, RULE_grant_statement);
		int _la;
		try {
			int _alt;
			setState(1553);
			switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1228); match(GRANT);
				setState(1238);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1230); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1229);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (REFERENCES - 96)) | (1L << (SELECT - 96)) | (1L << (TRIGGER - 96)) | (1L << (TRUNCATE - 96)) | (1L << (UPDATE - 96)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1232); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (REFERENCES - 96)) | (1L << (SELECT - 96)) | (1L << (TRIGGER - 96)) | (1L << (TRUNCATE - 96)) | (1L << (UPDATE - 96)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1234); match(ALL);
					setState(1236);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1235); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1240); match(ON);
				setState(1264);
				switch (_input.LA(1)) {
				case TABLE:
				case ADMIN:
				case AVG:
				case BETWEEN:
				case BY:
				case CACHE:
				case CALLED:
				case CLASS:
				case CENTURY:
				case CHARACTER:
				case CHECK:
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
				case DOW:
				case DOY:
				case DROP:
				case EPOCH:
				case EVERY:
				case EXISTS:
				case EXTERNAL:
				case EXTRACT:
				case FAMILY:
				case FILTER:
				case FIRST:
				case FORMAT:
				case FUSION:
				case GROUPING:
				case HASH:
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
				case OPTION:
				case OPTIONS:
				case OVERWRITE:
				case PARSER:
				case PARTIAL:
				case PARTITION:
				case PARTITIONS:
				case PRECISION:
				case PUBLIC:
				case PURGE:
				case QUARTER:
				case RANGE:
				case REGEXP:
				case RENAME:
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
				case VALUES:
				case VAR_SAMP:
				case VAR_POP:
				case VARYING:
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
				case VOID:
				case DOUBLE_QUOTE:
				case Identifier:
				case QuotedIdentifier:
					{
					{
					setState(1242);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1241); match(TABLE);
						}
					}

					setState(1248); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1244); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
							setState(1246);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1245); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1250); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(1252); match(ALL);
					setState(1253); match(TABLES);
					setState(1254); match(IN);
					setState(1255); match(SCHEMA);
					setState(1260); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1256); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(1258);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1257); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1262); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1266); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1268); match(GRANT);
				setState(1294);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1278); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1269);
						_la = _input.LA(1);
						if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (REFERENCES - 96)) | (1L << (SELECT - 96)) | (1L << (UPDATE - 96)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1274); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1270); ((Grant_statementContext)_localctx).column = identifier();
								setState(1272);
								_la = _input.LA(1);
								if (_la==COMMA) {
									{
									setState(1271); match(COMMA);
									}
								}

								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1276); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(1280); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (REFERENCES - 96)) | (1L << (SELECT - 96)) | (1L << (UPDATE - 96)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1282); match(ALL);
					setState(1284);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1283); match(PRIVILEGES);
						}
					}

					setState(1290); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1286); ((Grant_statementContext)_localctx).column = identifier();
							setState(1288);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1287); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1292); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1296); match(ON);
				setState(1304); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1298);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1297); match(TABLE);
							}
						}

						setState(1300); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
						setState(1302);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1301); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1306); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,158,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1308); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1310); match(GRANT);
				setState(1323);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(1315); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1311);
						_la = _input.LA(1);
						if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (SELECT - 106)) | (1L << (UPDATE - 106)) | (1L << (USAGE - 106)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1313);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1312); match(COMMA);
							}
						}

						}
						}
						setState(1317); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (SELECT - 106)) | (1L << (UPDATE - 106)) | (1L << (USAGE - 106)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1319); match(ALL);
					setState(1321);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1320); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1325); match(ON);
				setState(1347);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1331); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1326); match(SEQUENCE);
						setState(1327); ((Grant_statementContext)_localctx).sequence_name = identifier();
						setState(1329);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1328); match(COMMA);
							}
						}

						}
						}
						setState(1333); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(1335); match(ALL);
					setState(1336); match(SEQUENCES);
					setState(1337); match(IN);
					setState(1338); match(SCHEMA);
					setState(1343); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1339); ((Grant_statementContext)_localctx).schema_name = identifier();
							setState(1341);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1340); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1345); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1349); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1351); match(GRANT);
				setState(1364);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1356); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1352);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1354);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1353); match(COMMA);
							}
						}

						}
						}
						setState(1358); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(1360); match(ALL);
					setState(1362);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1361); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1366); match(ON);
				setState(1367); match(DATABASE);
				setState(1372); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1368); ((Grant_statementContext)_localctx).database_name = identifier();
						setState(1370);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1369); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1374); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,173,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1376); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1378); match(GRANT);
				setState(1384);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1379); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1380); match(ALL);
					setState(1382);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1381); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1386); match(ON);
				setState(1387); match(FOREIGN);
				setState(1388); match(DATA);
				setState(1389); match(WRAPPER);
				setState(1394); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1390); ((Grant_statementContext)_localctx).fdw_name = identifier();
						setState(1392);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1391); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1396); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1398); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1400); match(GRANT);
				setState(1406);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1401); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1402); match(ALL);
					setState(1404);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1403); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1408); match(ON);
				setState(1409); match(FOREIGN);
				setState(1410); match(SERVER);
				setState(1415); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1411); ((Grant_statementContext)_localctx).server_name = identifier();
						setState(1413);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1412); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1417); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1419); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1421); match(GRANT);
				setState(1427);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1422); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1423); match(ALL);
					setState(1425);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1424); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1429); match(ON);
				setState(1432);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1430); function_definition();
					}
					break;
				case ALL:
					{
					setState(1431); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1434); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1436); match(GRANT);
				setState(1442);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1437); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1438); match(ALL);
					setState(1440);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1439); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1444); match(ON);
				setState(1445); match(LANGUAGE);
				setState(1450); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1446); ((Grant_statementContext)_localctx).lang_name = identifier();
						setState(1448);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1447); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1452); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1454); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1456); match(GRANT);
				setState(1469);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1461); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1457);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1459);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1458); match(COMMA);
							}
						}

						}
						}
						setState(1463); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1465); match(ALL);
					setState(1467);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1466); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1471); match(ON);
				setState(1472); match(LARGE);
				setState(1473); match(OBJECT);
				setState(1478); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1474); ((Grant_statementContext)_localctx).loid = identifier();
						setState(1476);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1475); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1480); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1482); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1484); match(GRANT);
				setState(1497);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1489); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1485);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1487);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1486); match(COMMA);
							}
						}

						}
						}
						setState(1491); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1493); match(ALL);
					setState(1495);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1494); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1499); match(ON);
				setState(1500); match(SCHEMA);
				setState(1505); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1501); ((Grant_statementContext)_localctx).schema_name = identifier();
						setState(1503);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1502); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1507); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1509); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1511); match(GRANT);
				setState(1517);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1512); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1513); match(ALL);
					setState(1515);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1514); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1519); match(ON);
				setState(1520); match(TABLESPACE);
				setState(1525); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1521); ((Grant_statementContext)_localctx).tablespace_name = identifier();
						setState(1523);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1522); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1527); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,204,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1529); grant_to_rule();
				setState(1530); match(GRANT);
				setState(1535); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1531); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1533);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1532); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1537); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,206,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1539); match(TO);
				setState(1544); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1540); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1542);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1541); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1546); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,208,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1551);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1548); match(WITH);
					setState(1549); match(ADMIN);
					setState(1550); match(OPTION);
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
		enterRule(_localctx, 38, RULE_grant_to_rule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1555); match(TO);
			setState(1566); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1557);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1556); match(GROUP);
						}
					}

					setState(1561);
					switch ( getInterpreter().adaptivePredict(_input,212,_ctx) ) {
					case 1:
						{
						{
						setState(1559); ((Grant_to_ruleContext)_localctx).role_name = identifier();
						}
						}
						break;
					case 2:
						{
						setState(1560); match(PUBLIC);
						}
						break;
					}
					setState(1564);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1563); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1568); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1573);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1570); match(WITH);
				setState(1571); match(GRANT);
				setState(1572); match(OPTION);
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
		enterRule(_localctx, 40, RULE_comment_on_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1575); match(COMMENT);
			setState(1576); match(ON);
			setState(1695);
			switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
			case 1:
				{
				setState(1577); match(AGGREGATE);
				setState(1578); ((Comment_on_statementContext)_localctx).agg_name = schema_qualified_name();
				setState(1579); match(LEFT_PAREN);
				setState(1586);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (SETOF - 108)) | (1L << (TRIGGER - 108)) | (1L << (CHARACTER - 108)) | (1L << (DEC - 108)))) != 0) || ((((_la - 204)) & ~0x3f) == 0 && ((1L << (_la - 204)) & ((1L << (NATIONAL - 204)) | (1L << (BOOLEAN - 204)) | (1L << (BOOL - 204)) | (1L << (BIT - 204)) | (1L << (VARBIT - 204)))) != 0) || ((((_la - 268)) & ~0x3f) == 0 && ((1L << (_la - 268)) & ((1L << (INT1 - 268)) | (1L << (INT2 - 268)) | (1L << (INT4 - 268)) | (1L << (INT8 - 268)) | (1L << (TINYINT - 268)) | (1L << (SMALLINT - 268)) | (1L << (INT - 268)) | (1L << (INTEGER - 268)) | (1L << (BIGINT - 268)) | (1L << (FLOAT4 - 268)) | (1L << (FLOAT8 - 268)) | (1L << (REAL - 268)) | (1L << (REGCLASS - 268)) | (1L << (FLOAT - 268)) | (1L << (DOUBLE - 268)) | (1L << (NUMERIC - 268)) | (1L << (DECIMAL - 268)) | (1L << (CHAR - 268)) | (1L << (VARCHAR - 268)) | (1L << (NCHAR - 268)) | (1L << (NVARCHAR - 268)) | (1L << (DATE - 268)) | (1L << (TIME - 268)) | (1L << (TIMETZ - 268)) | (1L << (TIMESTAMP - 268)) | (1L << (TIMESTAMPTZ - 268)) | (1L << (TEXT - 268)) | (1L << (UUID - 268)) | (1L << (BINARY - 268)) | (1L << (VARBINARY - 268)) | (1L << (BLOB - 268)) | (1L << (BYTEA - 268)) | (1L << (INET4 - 268)) | (1L << (VOID - 268)))) != 0)) {
					{
					{
					setState(1580); ((Comment_on_statementContext)_localctx).agg_type = data_type();
					setState(1582);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1581); match(COMMA);
						}
					}

					}
					}
					setState(1588);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1589); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1591); match(CAST);
				setState(1592); match(LEFT_PAREN);
				setState(1593); ((Comment_on_statementContext)_localctx).source_type = data_type();
				setState(1594); match(AS);
				setState(1595); ((Comment_on_statementContext)_localctx).target_type = data_type();
				setState(1596); match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(1598); match(COLLATION);
				setState(1599); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 4:
				{
				setState(1600); match(COLUMN);
				setState(1601); ((Comment_on_statementContext)_localctx).column_name = schema_qualified_name();
				}
				break;
			case 5:
				{
				setState(1602); match(CONSTRAINT);
				setState(1603); ((Comment_on_statementContext)_localctx).constraint_name = schema_qualified_name();
				setState(1604); match(ON);
				setState(1605); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 6:
				{
				setState(1607); match(CONVERSION);
				setState(1608); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 7:
				{
				setState(1609); match(DATABASE);
				setState(1610); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 8:
				{
				setState(1611); match(DOMAIN);
				setState(1612); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 9:
				{
				setState(1613); match(EXTENSION);
				setState(1614); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 10:
				{
				setState(1615); match(FOREIGN);
				setState(1616); match(DATA);
				setState(1617); match(WRAPPER);
				setState(1618); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 11:
				{
				setState(1619); match(FOREIGN);
				setState(1620); match(TABLE);
				setState(1621); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 12:
				{
				setState(1622); function_definition();
				}
				break;
			case 13:
				{
				setState(1623); match(INDEX);
				setState(1624); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 14:
				{
				setState(1625); match(LARGE);
				setState(1626); match(OBJECT);
				setState(1627); ((Comment_on_statementContext)_localctx).large_object_oid = identifier();
				}
				break;
			case 15:
				{
				setState(1628); match(OPERATOR);
				setState(1629); ((Comment_on_statementContext)_localctx).operator_name = schema_qualified_name();
				setState(1630); match(LEFT_PAREN);
				setState(1631); ((Comment_on_statementContext)_localctx).left_type = data_type();
				setState(1632); match(COMMA);
				setState(1633); ((Comment_on_statementContext)_localctx).right_type = data_type();
				setState(1634); match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(1636); match(OPERATOR);
				setState(1637); match(CLASS);
				setState(1638); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1639); match(USING);
				setState(1640); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 17:
				{
				setState(1642); match(OPERATOR);
				setState(1643); match(FAMILY);
				setState(1644); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1645); match(USING);
				setState(1646); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 18:
				{
				setState(1649);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1648); match(PROCEDURAL);
					}
				}

				setState(1651); match(LANGUAGE);
				setState(1652); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 19:
				{
				setState(1653); match(ROLE);
				setState(1654); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 20:
				{
				setState(1655); match(RULE);
				setState(1656); ((Comment_on_statementContext)_localctx).rule_name = schema_qualified_name();
				setState(1657); match(ON);
				setState(1658); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 21:
				{
				setState(1660); match(SCHEMA);
				setState(1661); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 22:
				{
				setState(1662); match(SEQUENCE);
				setState(1663); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 23:
				{
				setState(1664); match(SERVER);
				setState(1665); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 24:
				{
				setState(1666); match(TABLE);
				setState(1667); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 25:
				{
				setState(1668); match(TABLESPACE);
				setState(1669); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 26:
				{
				setState(1670); match(TEXT);
				setState(1671); match(SEARCH);
				setState(1672); match(CONFIGURATION);
				setState(1673); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 27:
				{
				setState(1674); match(TEXT);
				setState(1675); match(SEARCH);
				setState(1676); match(DICTIONARY);
				setState(1677); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 28:
				{
				setState(1678); match(TEXT);
				setState(1679); match(SEARCH);
				setState(1680); match(PARSER);
				setState(1681); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 29:
				{
				setState(1682); match(TEXT);
				setState(1683); match(SEARCH);
				setState(1684); match(TEMPLATE);
				setState(1685); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 30:
				{
				setState(1686); match(TRIGGER);
				setState(1687); ((Comment_on_statementContext)_localctx).trigger_name = schema_qualified_name();
				setState(1688); match(ON);
				setState(1689); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 31:
				{
				setState(1691); match(TYPE);
				setState(1692); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 32:
				{
				setState(1693); match(VIEW);
				setState(1694); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			}
			setState(1697); match(IS);
			setState(1698); match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		public Data_typeContext rettype;
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
		enterRule(_localctx, 42, RULE_create_function_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1700); match(CREATE);
			setState(1703);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(1701); match(OR);
				setState(1702); match(REPLACE);
				}
			}

			setState(1705); match(FUNCTION);
			setState(1706); ((Create_function_statementContext)_localctx).name = schema_qualified_name();
			setState(1707); function_parameters();
			setState(1724);
			switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
			case 1:
				{
				setState(1708); match(RETURNS);
				setState(1709); ((Create_function_statementContext)_localctx).rettype = data_type();
				}
				break;
			case 2:
				{
				setState(1710); match(RETURNS);
				setState(1711); match(TABLE);
				setState(1712); match(LEFT_PAREN);
				setState(1718); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1713); ((Create_function_statementContext)_localctx).column_name = identifier();
					setState(1714); ((Create_function_statementContext)_localctx).column_type = data_type();
					setState(1716);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1715); match(COMMA);
						}
					}

					}
					}
					setState(1720); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(1722); match(RIGHT_PAREN);
				}
				break;
			}
			setState(1779); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1779);
					switch ( getInterpreter().adaptivePredict(_input,228,_ctx) ) {
					case 1:
						{
						setState(1726); match(LANGUAGE);
						setState(1727); ((Create_function_statementContext)_localctx).lang_name = identifier();
						}
						break;
					case 2:
						{
						setState(1728); match(WINDOW);
						}
						break;
					case 3:
						{
						setState(1729); match(IMMUTABLE);
						}
						break;
					case 4:
						{
						setState(1730); match(STABLE);
						}
						break;
					case 5:
						{
						setState(1731); match(VOLATILE);
						}
						break;
					case 6:
						{
						setState(1732); match(CALLED);
						setState(1733); match(ON);
						setState(1734); match(NULL);
						setState(1735); match(INPUT);
						}
						break;
					case 7:
						{
						setState(1736); match(RETURNS);
						setState(1737); match(NULL);
						setState(1738); match(ON);
						setState(1739); match(NULL);
						setState(1740); match(INPUT);
						}
						break;
					case 8:
						{
						setState(1741); match(STRICT);
						}
						break;
					case 9:
						{
						setState(1743);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1742); match(EXTERNAL);
							}
						}

						setState(1745); match(SECURITY);
						setState(1746); match(INVOKER);
						}
						break;
					case 10:
						{
						setState(1748);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1747); match(EXTERNAL);
							}
						}

						setState(1750); match(SECURITY);
						setState(1751); match(DEFINER);
						}
						break;
					case 11:
						{
						setState(1752); match(COST);
						setState(1753); ((Create_function_statementContext)_localctx).execution_cost = match(NUMBER);
						}
						break;
					case 12:
						{
						setState(1754); match(ROWS);
						setState(1755); ((Create_function_statementContext)_localctx).result_rows = match(NUMBER);
						}
						break;
					case 13:
						{
						setState(1756); match(SET);
						setState(1757); ((Create_function_statementContext)_localctx).configuration_parameter = identifier();
						setState(1764);
						switch (_input.LA(1)) {
						case TO:
							{
							setState(1758); match(TO);
							setState(1759); ((Create_function_statementContext)_localctx).value = identifier();
							}
							break;
						case EQUAL:
							{
							setState(1760); match(EQUAL);
							setState(1761); ((Create_function_statementContext)_localctx).value = identifier();
							}
							break;
						case FROM:
							{
							setState(1762); match(FROM);
							setState(1763); match(CURRENT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1770);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1766); match(COMMA);
							setState(1767); ((Create_function_statementContext)_localctx).value = identifier();
							}
							}
							setState(1772);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case 14:
						{
						setState(1773); match(AS);
						setState(1774); function_body();
						}
						break;
					case 15:
						{
						setState(1775); match(AS);
						setState(1776); match(Character_String_Literal);
						setState(1777); match(COMMA);
						setState(1778); match(Character_String_Literal);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1781); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,229,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1795);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1783); match(WITH);
				setState(1784); match(LEFT_PAREN);
				setState(1789); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1785); ((Create_function_statementContext)_localctx).attribute = function_attribute();
					setState(1787);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1786); match(COMMA);
						}
					}

					}
					}
					setState(1791); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ISCACHABLE || _la==ISSTRICT );
				setState(1793); match(RIGHT_PAREN);
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
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public Data_typeContext data_type(int i) {
			return getRuleContext(Data_typeContext.class,i);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
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
		enterRule(_localctx, 44, RULE_function_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1797); match(LEFT_PAREN);
			setState(1815);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & ((1L << (IN - 57)) | (1L << (INOUT - 57)) | (1L << (OUT - 57)) | (1L << (SETOF - 57)) | (1L << (TRIGGER - 57)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (VARIADIC - 128)) | (1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (INDEX - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (LIST - 192)) | (1L << (LOCATION - 192)) | (1L << (MATCH - 192)) | (1L << (MAX - 192)) | (1L << (MAXVALUE - 192)) | (1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (ON - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RENAME - 192)) | (1L << (RESET - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (VARYING - 256)) | (1L << (VOLATILE - 256)) | (1L << (WEEK - 256)) | (1L << (WINDOW - 256)) | (1L << (WRAPPER - 256)) | (1L << (YEAR - 256)) | (1L << (ZONE - 256)) | (1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (VOID - 256)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0)) {
				{
				{
				setState(1799);
				_la = _input.LA(1);
				if (_la==IN || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INOUT - 65)) | (1L << (OUT - 65)) | (1L << (VARIADIC - 65)))) != 0)) {
					{
					setState(1798); ((Function_parametersContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1802);
				switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
				case 1:
					{
					setState(1801); ((Function_parametersContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1804); ((Function_parametersContext)_localctx).argtype = data_type();
				setState(1808);
				switch (_input.LA(1)) {
				case DEFAULT:
					{
					setState(1805); match(DEFAULT);
					}
					break;
				case EQUAL:
					{
					setState(1806); match(EQUAL);
					setState(1807); ((Function_parametersContext)_localctx).def_value = value_expression();
					}
					break;
				case IN:
				case INOUT:
				case OUT:
				case SETOF:
				case TRIGGER:
				case VARIADIC:
				case ADMIN:
				case AVG:
				case BETWEEN:
				case BY:
				case CACHE:
				case CALLED:
				case CLASS:
				case CENTURY:
				case CHARACTER:
				case CHECK:
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
				case DOW:
				case DOY:
				case DROP:
				case EPOCH:
				case EVERY:
				case EXISTS:
				case EXTERNAL:
				case EXTRACT:
				case FAMILY:
				case FILTER:
				case FIRST:
				case FORMAT:
				case FUSION:
				case GROUPING:
				case HASH:
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
				case OPTION:
				case OPTIONS:
				case OVERWRITE:
				case PARSER:
				case PARTIAL:
				case PARTITION:
				case PARTITIONS:
				case PRECISION:
				case PUBLIC:
				case PURGE:
				case QUARTER:
				case RANGE:
				case REGEXP:
				case RENAME:
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
				case VALUES:
				case VAR_SAMP:
				case VAR_POP:
				case VARYING:
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
				case VOID:
				case COMMA:
				case RIGHT_PAREN:
				case DOUBLE_QUOTE:
				case Identifier:
				case QuotedIdentifier:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1811);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1810); match(COMMA);
					}
				}

				}
				}
				setState(1817);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1818); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_function_body);
		try {
			setState(1822);
			switch (_input.LA(1)) {
			case DOUBLE_DOLLAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1820); function_body_separator();
				}
				break;
			case DOUBLE_UNDER_DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1821); function_body_separator_dollar_under();
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
		enterRule(_localctx, 48, RULE_function_body_separator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1824); match(DOUBLE_DOLLAR);
			setState(1828);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << ALTER) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << HANDLER) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INLINE) | (1L << INNER) | (1L << INTERSECT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTO - 64)) | (1L << (INOUT - 64)) | (1L << (INSTEAD - 64)) | (1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (OWNER - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRUSTED - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)) | (1L << (VALIDATOR - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (VARIADIC - 128)) | (1L << (VIEW - 128)) | (1L << (WHEN - 128)) | (1L << (WHERE - 128)) | (1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (LIST - 192)) | (1L << (LOCATION - 192)) | (1L << (MATCH - 192)) | (1L << (MAX - 192)) | (1L << (MAXVALUE - 192)) | (1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (ON - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RENAME - 192)) | (1L << (RESET - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TABLES - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (VARYING - 256)) | (1L << (VERSION - 256)) | (1L << (VOLATILE - 256)) | (1L << (WEEK - 256)) | (1L << (WINDOW - 256)) | (1L << (WRAPPER - 256)) | (1L << (YEAR - 256)) | (1L << (ZONE - 256)) | (1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (VOID - 256)) | (1L << (Similar_To - 256)) | (1L << (Not_Similar_To - 256)) | (1L << (Similar_To_Case_Insensitive - 256)) | (1L << (Not_Similar_To_Case_Insensitive - 256)) | (1L << (CAST_EXPRESSION - 256)) | (1L << (ASSIGN - 256)) | (1L << (EQUAL - 256)) | (1L << (COLON - 256)) | (1L << (SEMI_COLON - 256)) | (1L << (COMMA - 256)) | (1L << (CONCATENATION_OPERATOR - 256)) | (1L << (NOT_EQUAL - 256)) | (1L << (LTH - 256)) | (1L << (LEQ - 256)) | (1L << (GTH - 256)) | (1L << (GEQ - 256)) | (1L << (LEFT_PAREN - 256)) | (1L << (RIGHT_PAREN - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (PLUS - 320)) | (1L << (MINUS - 320)) | (1L << (MULTIPLY - 320)) | (1L << (DIVIDE - 320)) | (1L << (MODULAR - 320)) | (1L << (DOT - 320)) | (1L << (UNDERLINE - 320)) | (1L << (VERTICAL_BAR - 320)) | (1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (DOUBLE_UNDER_DOLLAR - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (QuotedIdentifier - 320)) | (1L << (UnterminatedQuotedIdentifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)))) != 0)) {
				{
				{
				setState(1825);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==DOUBLE_DOLLAR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(1830);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1831); match(DOUBLE_DOLLAR);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 50, RULE_function_body_separator_dollar_under);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1833); match(DOUBLE_UNDER_DOLLAR);
			setState(1837);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << ALTER) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << HANDLER) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INLINE) | (1L << INNER) | (1L << INTERSECT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTO - 64)) | (1L << (INOUT - 64)) | (1L << (INSTEAD - 64)) | (1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (OWNER - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRUSTED - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)) | (1L << (VALIDATOR - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (VARIADIC - 128)) | (1L << (VIEW - 128)) | (1L << (WHEN - 128)) | (1L << (WHERE - 128)) | (1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (LIST - 192)) | (1L << (LOCATION - 192)) | (1L << (MATCH - 192)) | (1L << (MAX - 192)) | (1L << (MAXVALUE - 192)) | (1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (ON - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RENAME - 192)) | (1L << (RESET - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TABLES - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (VARYING - 256)) | (1L << (VERSION - 256)) | (1L << (VOLATILE - 256)) | (1L << (WEEK - 256)) | (1L << (WINDOW - 256)) | (1L << (WRAPPER - 256)) | (1L << (YEAR - 256)) | (1L << (ZONE - 256)) | (1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (VOID - 256)) | (1L << (Similar_To - 256)) | (1L << (Not_Similar_To - 256)) | (1L << (Similar_To_Case_Insensitive - 256)) | (1L << (Not_Similar_To_Case_Insensitive - 256)) | (1L << (CAST_EXPRESSION - 256)) | (1L << (ASSIGN - 256)) | (1L << (EQUAL - 256)) | (1L << (COLON - 256)) | (1L << (SEMI_COLON - 256)) | (1L << (COMMA - 256)) | (1L << (CONCATENATION_OPERATOR - 256)) | (1L << (NOT_EQUAL - 256)) | (1L << (LTH - 256)) | (1L << (LEQ - 256)) | (1L << (GTH - 256)) | (1L << (GEQ - 256)) | (1L << (LEFT_PAREN - 256)) | (1L << (RIGHT_PAREN - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (PLUS - 320)) | (1L << (MINUS - 320)) | (1L << (MULTIPLY - 320)) | (1L << (DIVIDE - 320)) | (1L << (MODULAR - 320)) | (1L << (DOT - 320)) | (1L << (UNDERLINE - 320)) | (1L << (VERTICAL_BAR - 320)) | (1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (DOUBLE_DOLLAR - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (QuotedIdentifier - 320)) | (1L << (UnterminatedQuotedIdentifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)))) != 0)) {
				{
				{
				setState(1834);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==DOUBLE_UNDER_DOLLAR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(1839);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1840); match(DOUBLE_UNDER_DOLLAR);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 52, RULE_function_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1842);
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
		enterRule(_localctx, 54, RULE_argmode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1844);
			_la = _input.LA(1);
			if ( !(_la==IN || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INOUT - 65)) | (1L << (OUT - 65)) | (1L << (VARIADIC - 65)))) != 0)) ) {
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
		enterRule(_localctx, 56, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1846); match(FUNCTION);
			setState(1847); ((Function_definitionContext)_localctx).func_name = identifier();
			setState(1848); match(LEFT_PAREN);
			setState(1864);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << IN))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INOUT - 65)) | (1L << (LEFT - 65)) | (1L << (NOT - 65)) | (1L << (NULL - 65)) | (1L << (OUT - 65)) | (1L << (RIGHT - 65)) | (1L << (SETOF - 65)) | (1L << (SOME - 65)) | (1L << (TRIGGER - 65)) | (1L << (TRUE - 65)) | (1L << (VARIADIC - 65)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (REGCLASS - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (BINARY - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)) | (1L << (LEFT_PAREN - 262)) | (1L << (PLUS - 262)) | (1L << (MINUS - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (NUMBER - 329)) | (1L << (REAL_NUMBER - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)) | (1L << (Character_String_Literal - 329)))) != 0)) {
				{
				{
				setState(1850);
				_la = _input.LA(1);
				if (_la==IN || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (INOUT - 65)) | (1L << (OUT - 65)) | (1L << (VARIADIC - 65)))) != 0)) {
					{
					setState(1849); ((Function_definitionContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1853);
				switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
				case 1:
					{
					setState(1852); ((Function_definitionContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1857);
				switch ( getInterpreter().adaptivePredict(_input,243,_ctx) ) {
				case 1:
					{
					setState(1855); ((Function_definitionContext)_localctx).argtype_data = data_type();
					}
					break;
				case 2:
					{
					setState(1856); ((Function_definitionContext)_localctx).argtype_expres = value_expression();
					}
					break;
				}
				setState(1860);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1859); match(COMMA);
					}
				}

				}
				}
				setState(1866);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1867); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 58, RULE_functions_definition_schema);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1869); match(ALL);
			setState(1870); match(FUNCTIONS);
			setState(1871); match(IN);
			setState(1872); match(SCHEMA);
			setState(1877); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1873); ((Functions_definition_schemaContext)_localctx).schema_name = identifier();
					setState(1875);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1874); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1879); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,247,_ctx);
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
		enterRule(_localctx, 60, RULE_create_sequence_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1881); match(CREATE);
			setState(1883);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(1882);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1885); match(SEQUENCE);
			setState(1886); ((Create_sequence_statementContext)_localctx).name = schema_qualified_name();
			setState(1923);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OWNED || _la==CACHE || ((((_la - 155)) & ~0x3f) == 0 && ((1L << (_la - 155)) & ((1L << (CYCLE - 155)) | (1L << (INCREMENT - 155)) | (1L << (MAXVALUE - 155)) | (1L << (MINVALUE - 155)) | (1L << (NO - 155)))) != 0) || _la==START) {
				{
				setState(1921);
				switch ( getInterpreter().adaptivePredict(_input,255,_ctx) ) {
				case 1:
					{
					{
					setState(1887); match(INCREMENT);
					setState(1889);
					_la = _input.LA(1);
					if (_la==BY) {
						{
						setState(1888); match(BY);
						}
					}

					setState(1891); ((Create_sequence_statementContext)_localctx).incr = match(NUMBER);
					}
					}
					break;
				case 2:
					{
					setState(1896);
					switch (_input.LA(1)) {
					case MINVALUE:
						{
						setState(1892); match(MINVALUE);
						setState(1893); ((Create_sequence_statementContext)_localctx).minval = match(NUMBER);
						}
						break;
					case NO:
						{
						setState(1894); match(NO);
						setState(1895); match(MINVALUE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case 3:
					{
					setState(1902);
					switch (_input.LA(1)) {
					case MAXVALUE:
						{
						setState(1898); match(MAXVALUE);
						setState(1899); ((Create_sequence_statementContext)_localctx).maxval = numeric_type();
						}
						break;
					case NO:
						{
						setState(1900); match(NO);
						setState(1901); match(MAXVALUE);
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
					setState(1904); match(START);
					setState(1906);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(1905); match(WITH);
						}
					}

					setState(1908); ((Create_sequence_statementContext)_localctx).start_val = match(NUMBER);
					}
					}
					break;
				case 5:
					{
					{
					setState(1909); match(CACHE);
					setState(1910); ((Create_sequence_statementContext)_localctx).cache_val = match(NUMBER);
					}
					}
					break;
				case 6:
					{
					{
					setState(1912);
					_la = _input.LA(1);
					if (_la==NO) {
						{
						setState(1911); match(NO);
						}
					}

					setState(1914); match(CYCLE);
					}
					}
					break;
				case 7:
					{
					{
					setState(1915); match(OWNED);
					setState(1916); match(BY);
					setState(1919);
					switch ( getInterpreter().adaptivePredict(_input,254,_ctx) ) {
					case 1:
						{
						setState(1917); ((Create_sequence_statementContext)_localctx).col_name = schema_qualified_name();
						}
						break;
					case 2:
						{
						setState(1918); match(NONE);
						}
						break;
					}
					}
					}
					break;
				}
				}
				setState(1925);
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
		enterRule(_localctx, 62, RULE_create_schema_statement);
		int _la;
		try {
			int _alt;
			setState(1966);
			switch ( getInterpreter().adaptivePredict(_input,261,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1926); match(CREATE);
				setState(1927); match(SCHEMA);
				setState(1928); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(1931);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(1929); match(AUTHORIZATION);
					setState(1930); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				setState(1936);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,258,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1933); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(1938);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,258,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1939); match(CREATE);
				setState(1940); match(SCHEMA);
				setState(1941); match(AUTHORIZATION);
				setState(1942); ((Create_schema_statementContext)_localctx).user_name = identifier();
				setState(1946);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,259,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1943); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(1948);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,259,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1949); match(CREATE);
				setState(1950); match(SCHEMA);
				setState(1951); match(IF);
				setState(1952); match(NOT);
				setState(1953); match(EXISTS);
				setState(1954); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(1957);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(1955); match(AUTHORIZATION);
					setState(1956); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1959); match(CREATE);
				setState(1960); match(SCHEMA);
				setState(1961); match(IF);
				setState(1962); match(NOT);
				setState(1963); match(EXISTS);
				setState(1964); match(AUTHORIZATION);
				setState(1965); ((Create_schema_statementContext)_localctx).user_name = identifier();
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
		enterRule(_localctx, 64, RULE_create_view_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1968); match(CREATE);
			setState(1971);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(1969); match(OR);
				setState(1970); match(REPLACE);
				}
			}

			setState(1974);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(1973);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1976); match(VIEW);
			setState(1977); ((Create_view_statementContext)_localctx).name = schema_qualified_name();
			setState(1984);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0)) {
				{
				{
				setState(1978); ((Create_view_statementContext)_localctx).column_name = identifier();
				setState(1980);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1979); match(COMMA);
					}
				}

				}
				}
				setState(1986);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2000);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1987); match(WITH);
				setState(1988); match(LEFT_PAREN);
				setState(1994); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1989); ((Create_view_statementContext)_localctx).view_option_name = identifier();
					setState(1992);
					_la = _input.LA(1);
					if (_la==EQUAL) {
						{
						setState(1990); match(EQUAL);
						setState(1991); ((Create_view_statementContext)_localctx).view_option_value = identifier();
						}
					}

					}
					}
					setState(1996); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(1998); match(RIGHT_PAREN);
				}
			}

			setState(2002); match(AS);
			setState(2003); query_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 66, RULE_query);
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
		public IdentifierContext column_name;
		public Data_typeContext datatype;
		public IdentifierContext collation;
		public Column_constraintContext colmn_constraint;
		public Table_constraintContext tabl_constraint;
		public IdentifierContext parent_table;
		public Like_optionContext like_opt;
		public IdentifierContext type_name;
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
		public Table_constraintContext table_constraint(int i) {
			return getRuleContext(Table_constraintContext.class,i);
		}
		public TerminalNode OF() { return getToken(SQLParser.OF, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode TEMP() { return getToken(SQLParser.TEMP, 0); }
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public List<Data_typeContext> data_type() {
			return getRuleContexts(Data_typeContext.class);
		}
		public List<TerminalNode> LIKE() { return getTokens(SQLParser.LIKE); }
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
		public List<TerminalNode> COLLATE() { return getTokens(SQLParser.COLLATE); }
		public TerminalNode UNLOGGED() { return getToken(SQLParser.UNLOGGED, 0); }
		public TerminalNode COLLATE(int i) {
			return getToken(SQLParser.COLLATE, i);
		}
		public List<Column_constraintContext> column_constraint() {
			return getRuleContexts(Column_constraintContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Data_typeContext data_type(int i) {
			return getRuleContext(Data_typeContext.class,i);
		}
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
		enterRule(_localctx, 68, RULE_create_table_statement);
		int _la;
		try {
			int _alt;
			setState(2119);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2007); match(CREATE);
				setState(2013);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(2009);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(2008);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(2011);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(2012); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2015); match(TABLE);
				setState(2019);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(2016); match(IF);
					setState(2017); match(NOT);
					setState(2018); match(EXISTS);
					}
				}

				setState(2021); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(2022); match(LEFT_PAREN);
				setState(2053);
				_la = _input.LA(1);
				if (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (CONSTRAINT - 19)) | (1L << (EXCLUDE - 19)) | (1L << (FOREIGN - 19)) | (1L << (LIKE - 19)))) != 0) || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (PRIMARY - 89)) | (1L << (UNIQUE - 89)) | (1L << (ADMIN - 89)) | (1L << (AVG - 89)) | (1L << (BETWEEN - 89)) | (1L << (BY - 89)) | (1L << (CACHE - 89)) | (1L << (CALLED - 89)) | (1L << (CLASS - 89)) | (1L << (CENTURY - 89)) | (1L << (CHARACTER - 89)) | (1L << (CHECK - 89)) | (1L << (COLLECT - 89)) | (1L << (COALESCE - 89)) | (1L << (COLUMN - 89)) | (1L << (COMMENT - 89)) | (1L << (COMMENTS - 89)) | (1L << (COMMIT - 89)) | (1L << (CONFIGURATION - 89)) | (1L << (COST - 89)) | (1L << (COUNT - 89)))) != 0) || ((((_la - 153)) & ~0x3f) == 0 && ((1L << (_la - 153)) & ((1L << (CUBE - 153)) | (1L << (CURRENT - 153)) | (1L << (CYCLE - 153)) | (1L << (DATA - 153)) | (1L << (DAY - 153)) | (1L << (DEC - 153)) | (1L << (DECADE - 153)) | (1L << (DEFINER - 153)) | (1L << (DICTIONARY - 153)) | (1L << (DOW - 153)) | (1L << (DOY - 153)) | (1L << (DROP - 153)) | (1L << (EPOCH - 153)) | (1L << (EVERY - 153)) | (1L << (EXISTS - 153)) | (1L << (EXTERNAL - 153)) | (1L << (EXTRACT - 153)) | (1L << (FAMILY - 153)) | (1L << (FILTER - 153)) | (1L << (FIRST - 153)) | (1L << (FORMAT - 153)) | (1L << (FUSION - 153)) | (1L << (GROUPING - 153)) | (1L << (HASH - 153)) | (1L << (INDEX - 153)) | (1L << (INCREMENT - 153)) | (1L << (INPUT - 153)) | (1L << (INSERT - 153)) | (1L << (INTERSECTION - 153)) | (1L << (ISCACHABLE - 153)) | (1L << (ISODOW - 153)) | (1L << (ISOYEAR - 153)) | (1L << (ISSTRICT - 153)) | (1L << (LANGUAGE - 153)) | (1L << (LARGE - 153)) | (1L << (LAST - 153)) | (1L << (LESS - 153)) | (1L << (LIST - 153)) | (1L << (LOCATION - 153)) | (1L << (MATCH - 153)) | (1L << (MAX - 153)) | (1L << (MAXVALUE - 153)) | (1L << (MICROSECONDS - 153)) | (1L << (MILLENNIUM - 153)) | (1L << (MILLISECONDS - 153)) | (1L << (MIN - 153)) | (1L << (MINVALUE - 153)) | (1L << (MINUTE - 153)) | (1L << (MONTH - 153)) | (1L << (NATIONAL - 153)) | (1L << (NO - 153)) | (1L << (NONE - 153)) | (1L << (NULLIF - 153)) | (1L << (OBJECT - 153)) | (1L << (ON - 153)) | (1L << (OPTION - 153)) | (1L << (OPTIONS - 153)) | (1L << (OVERWRITE - 153)) | (1L << (PARSER - 153)) | (1L << (PARTIAL - 153)) | (1L << (PARTITION - 153)) | (1L << (PARTITIONS - 153)))) != 0) || ((((_la - 217)) & ~0x3f) == 0 && ((1L << (_la - 217)) & ((1L << (PRECISION - 217)) | (1L << (PUBLIC - 217)) | (1L << (PURGE - 217)) | (1L << (QUARTER - 217)) | (1L << (RANGE - 217)) | (1L << (REGEXP - 217)) | (1L << (RENAME - 217)) | (1L << (RESET - 217)) | (1L << (RLIKE - 217)) | (1L << (ROLLUP - 217)) | (1L << (SEARCH - 217)) | (1L << (SECOND - 217)) | (1L << (SECURITY - 217)) | (1L << (SERVER - 217)) | (1L << (SET - 217)) | (1L << (SIMILAR - 217)) | (1L << (SIMPLE - 217)) | (1L << (STABLE - 217)) | (1L << (START - 217)) | (1L << (STORAGE - 217)) | (1L << (STDDEV_POP - 217)) | (1L << (STDDEV_SAMP - 217)) | (1L << (SUBPARTITION - 217)) | (1L << (SUM - 217)) | (1L << (TABLESPACE - 217)) | (1L << (TEMPLATE - 217)) | (1L << (THAN - 217)) | (1L << (TIMEZONE - 217)) | (1L << (TIMEZONE_HOUR - 217)) | (1L << (TIMEZONE_MINUTE - 217)) | (1L << (TRIM - 217)) | (1L << (TO - 217)) | (1L << (TYPE - 217)) | (1L << (UNKNOWN - 217)) | (1L << (UNLOGGED - 217)) | (1L << (VALUES - 217)) | (1L << (VAR_SAMP - 217)) | (1L << (VAR_POP - 217)) | (1L << (VARYING - 217)) | (1L << (VOLATILE - 217)) | (1L << (WEEK - 217)) | (1L << (WINDOW - 217)) | (1L << (WRAPPER - 217)) | (1L << (YEAR - 217)) | (1L << (ZONE - 217)) | (1L << (BOOLEAN - 217)) | (1L << (BOOL - 217)) | (1L << (BIT - 217)) | (1L << (VARBIT - 217)) | (1L << (INT1 - 217)) | (1L << (INT2 - 217)) | (1L << (INT4 - 217)) | (1L << (INT8 - 217)) | (1L << (TINYINT - 217)) | (1L << (SMALLINT - 217)) | (1L << (INT - 217)) | (1L << (INTEGER - 217)) | (1L << (BIGINT - 217)) | (1L << (FLOAT4 - 217)) | (1L << (FLOAT8 - 217)) | (1L << (REAL - 217)))) != 0) || ((((_la - 281)) & ~0x3f) == 0 && ((1L << (_la - 281)) & ((1L << (FLOAT - 281)) | (1L << (DOUBLE - 281)) | (1L << (NUMERIC - 281)) | (1L << (DECIMAL - 281)) | (1L << (CHAR - 281)) | (1L << (VARCHAR - 281)) | (1L << (NCHAR - 281)) | (1L << (NVARCHAR - 281)) | (1L << (DATE - 281)) | (1L << (TIME - 281)) | (1L << (TIMETZ - 281)) | (1L << (TIMESTAMP - 281)) | (1L << (TIMESTAMPTZ - 281)) | (1L << (TEXT - 281)) | (1L << (UUID - 281)) | (1L << (VARBINARY - 281)) | (1L << (BLOB - 281)) | (1L << (BYTEA - 281)) | (1L << (INET4 - 281)) | (1L << (VOID - 281)) | (1L << (DOUBLE_QUOTE - 281)) | (1L << (Identifier - 281)) | (1L << (QuotedIdentifier - 281)))) != 0)) {
					{
					setState(2049); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2044);
						switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
						case 1:
							{
							{
							setState(2023); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(2024); ((Create_table_statementContext)_localctx).datatype = data_type();
							setState(2027);
							_la = _input.LA(1);
							if (_la==COLLATE) {
								{
								setState(2025); match(COLLATE);
								setState(2026); ((Create_table_statementContext)_localctx).collation = identifier();
								}
							}

							setState(2032);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,273,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(2029); ((Create_table_statementContext)_localctx).colmn_constraint = column_constraint();
									}
									} 
								}
								setState(2034);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,273,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(2035); ((Create_table_statementContext)_localctx).tabl_constraint = table_constraint();
							}
							break;
						case 3:
							{
							{
							setState(2036); match(LIKE);
							setState(2037); ((Create_table_statementContext)_localctx).parent_table = identifier();
							setState(2041);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==EXCLUDING || _la==INCLUDING) {
								{
								{
								setState(2038); ((Create_table_statementContext)_localctx).like_opt = like_option();
								}
								}
								setState(2043);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							break;
						}
						setState(2047);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2046); match(COMMA);
							}
						}

						}
						}
						setState(2051); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (CONSTRAINT - 19)) | (1L << (EXCLUDE - 19)) | (1L << (FOREIGN - 19)) | (1L << (LIKE - 19)))) != 0) || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (PRIMARY - 89)) | (1L << (UNIQUE - 89)) | (1L << (ADMIN - 89)) | (1L << (AVG - 89)) | (1L << (BETWEEN - 89)) | (1L << (BY - 89)) | (1L << (CACHE - 89)) | (1L << (CALLED - 89)) | (1L << (CLASS - 89)) | (1L << (CENTURY - 89)) | (1L << (CHARACTER - 89)) | (1L << (CHECK - 89)) | (1L << (COLLECT - 89)) | (1L << (COALESCE - 89)) | (1L << (COLUMN - 89)) | (1L << (COMMENT - 89)) | (1L << (COMMENTS - 89)) | (1L << (COMMIT - 89)) | (1L << (CONFIGURATION - 89)) | (1L << (COST - 89)) | (1L << (COUNT - 89)))) != 0) || ((((_la - 153)) & ~0x3f) == 0 && ((1L << (_la - 153)) & ((1L << (CUBE - 153)) | (1L << (CURRENT - 153)) | (1L << (CYCLE - 153)) | (1L << (DATA - 153)) | (1L << (DAY - 153)) | (1L << (DEC - 153)) | (1L << (DECADE - 153)) | (1L << (DEFINER - 153)) | (1L << (DICTIONARY - 153)) | (1L << (DOW - 153)) | (1L << (DOY - 153)) | (1L << (DROP - 153)) | (1L << (EPOCH - 153)) | (1L << (EVERY - 153)) | (1L << (EXISTS - 153)) | (1L << (EXTERNAL - 153)) | (1L << (EXTRACT - 153)) | (1L << (FAMILY - 153)) | (1L << (FILTER - 153)) | (1L << (FIRST - 153)) | (1L << (FORMAT - 153)) | (1L << (FUSION - 153)) | (1L << (GROUPING - 153)) | (1L << (HASH - 153)) | (1L << (INDEX - 153)) | (1L << (INCREMENT - 153)) | (1L << (INPUT - 153)) | (1L << (INSERT - 153)) | (1L << (INTERSECTION - 153)) | (1L << (ISCACHABLE - 153)) | (1L << (ISODOW - 153)) | (1L << (ISOYEAR - 153)) | (1L << (ISSTRICT - 153)) | (1L << (LANGUAGE - 153)) | (1L << (LARGE - 153)) | (1L << (LAST - 153)) | (1L << (LESS - 153)) | (1L << (LIST - 153)) | (1L << (LOCATION - 153)) | (1L << (MATCH - 153)) | (1L << (MAX - 153)) | (1L << (MAXVALUE - 153)) | (1L << (MICROSECONDS - 153)) | (1L << (MILLENNIUM - 153)) | (1L << (MILLISECONDS - 153)) | (1L << (MIN - 153)) | (1L << (MINVALUE - 153)) | (1L << (MINUTE - 153)) | (1L << (MONTH - 153)) | (1L << (NATIONAL - 153)) | (1L << (NO - 153)) | (1L << (NONE - 153)) | (1L << (NULLIF - 153)) | (1L << (OBJECT - 153)) | (1L << (ON - 153)) | (1L << (OPTION - 153)) | (1L << (OPTIONS - 153)) | (1L << (OVERWRITE - 153)) | (1L << (PARSER - 153)) | (1L << (PARTIAL - 153)) | (1L << (PARTITION - 153)) | (1L << (PARTITIONS - 153)))) != 0) || ((((_la - 217)) & ~0x3f) == 0 && ((1L << (_la - 217)) & ((1L << (PRECISION - 217)) | (1L << (PUBLIC - 217)) | (1L << (PURGE - 217)) | (1L << (QUARTER - 217)) | (1L << (RANGE - 217)) | (1L << (REGEXP - 217)) | (1L << (RENAME - 217)) | (1L << (RESET - 217)) | (1L << (RLIKE - 217)) | (1L << (ROLLUP - 217)) | (1L << (SEARCH - 217)) | (1L << (SECOND - 217)) | (1L << (SECURITY - 217)) | (1L << (SERVER - 217)) | (1L << (SET - 217)) | (1L << (SIMILAR - 217)) | (1L << (SIMPLE - 217)) | (1L << (STABLE - 217)) | (1L << (START - 217)) | (1L << (STORAGE - 217)) | (1L << (STDDEV_POP - 217)) | (1L << (STDDEV_SAMP - 217)) | (1L << (SUBPARTITION - 217)) | (1L << (SUM - 217)) | (1L << (TABLESPACE - 217)) | (1L << (TEMPLATE - 217)) | (1L << (THAN - 217)) | (1L << (TIMEZONE - 217)) | (1L << (TIMEZONE_HOUR - 217)) | (1L << (TIMEZONE_MINUTE - 217)) | (1L << (TRIM - 217)) | (1L << (TO - 217)) | (1L << (TYPE - 217)) | (1L << (UNKNOWN - 217)) | (1L << (UNLOGGED - 217)) | (1L << (VALUES - 217)) | (1L << (VAR_SAMP - 217)) | (1L << (VAR_POP - 217)) | (1L << (VARYING - 217)) | (1L << (VOLATILE - 217)) | (1L << (WEEK - 217)) | (1L << (WINDOW - 217)) | (1L << (WRAPPER - 217)) | (1L << (YEAR - 217)) | (1L << (ZONE - 217)) | (1L << (BOOLEAN - 217)) | (1L << (BOOL - 217)) | (1L << (BIT - 217)) | (1L << (VARBIT - 217)) | (1L << (INT1 - 217)) | (1L << (INT2 - 217)) | (1L << (INT4 - 217)) | (1L << (INT8 - 217)) | (1L << (TINYINT - 217)) | (1L << (SMALLINT - 217)) | (1L << (INT - 217)) | (1L << (INTEGER - 217)) | (1L << (BIGINT - 217)) | (1L << (FLOAT4 - 217)) | (1L << (FLOAT8 - 217)) | (1L << (REAL - 217)))) != 0) || ((((_la - 281)) & ~0x3f) == 0 && ((1L << (_la - 281)) & ((1L << (FLOAT - 281)) | (1L << (DOUBLE - 281)) | (1L << (NUMERIC - 281)) | (1L << (DECIMAL - 281)) | (1L << (CHAR - 281)) | (1L << (VARCHAR - 281)) | (1L << (NCHAR - 281)) | (1L << (NVARCHAR - 281)) | (1L << (DATE - 281)) | (1L << (TIME - 281)) | (1L << (TIMETZ - 281)) | (1L << (TIMESTAMP - 281)) | (1L << (TIMESTAMPTZ - 281)) | (1L << (TEXT - 281)) | (1L << (UUID - 281)) | (1L << (VARBINARY - 281)) | (1L << (BLOB - 281)) | (1L << (BYTEA - 281)) | (1L << (INET4 - 281)) | (1L << (VOID - 281)) | (1L << (DOUBLE_QUOTE - 281)) | (1L << (Identifier - 281)) | (1L << (QuotedIdentifier - 281)))) != 0) );
					}
				}

				setState(2055); match(RIGHT_PAREN);
				setState(2068);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(2056); match(INHERITS);
					setState(2057); match(LEFT_PAREN);
					setState(2062); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2058); ((Create_table_statementContext)_localctx).parent_table = identifier();
						setState(2060);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2059); match(COMMA);
							}
						}

						}
						}
						setState(2064); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
					setState(2066); match(RIGHT_PAREN);
					}
				}

				setState(2070); storage_parameter_oid();
				setState(2071); on_commit();
				setState(2072); table_space();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2074); match(CREATE);
				setState(2080);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(2076);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(2075);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(2078);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(2079); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2082); match(TABLE);
				setState(2086);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(2083); match(IF);
					setState(2084); match(NOT);
					setState(2085); match(EXISTS);
					}
				}

				setState(2088); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(2089); match(OF);
				setState(2090); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(2113);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2091); match(LEFT_PAREN);
					setState(2107); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2102);
						switch ( getInterpreter().adaptivePredict(_input,286,_ctx) ) {
						case 1:
							{
							{
							setState(2092); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(2093); match(WITH);
							setState(2094); match(OPTIONS);
							setState(2098);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,285,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(2095); ((Create_table_statementContext)_localctx).col_constraint = column_constraint();
									}
									} 
								}
								setState(2100);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,285,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(2101); table_constraint();
							}
							break;
						}
						setState(2105);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2104); match(COMMA);
							}
						}

						}
						}
						setState(2109); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (PRIMARY - 89)) | (1L << (UNIQUE - 89)) | (1L << (ADMIN - 89)) | (1L << (AVG - 89)) | (1L << (BETWEEN - 89)) | (1L << (BY - 89)) | (1L << (CACHE - 89)) | (1L << (CALLED - 89)) | (1L << (CLASS - 89)) | (1L << (CENTURY - 89)) | (1L << (CHARACTER - 89)) | (1L << (CHECK - 89)) | (1L << (COLLECT - 89)) | (1L << (COALESCE - 89)) | (1L << (COLUMN - 89)) | (1L << (COMMENT - 89)) | (1L << (COMMENTS - 89)) | (1L << (COMMIT - 89)) | (1L << (CONFIGURATION - 89)) | (1L << (COST - 89)) | (1L << (COUNT - 89)))) != 0) || ((((_la - 153)) & ~0x3f) == 0 && ((1L << (_la - 153)) & ((1L << (CUBE - 153)) | (1L << (CURRENT - 153)) | (1L << (CYCLE - 153)) | (1L << (DATA - 153)) | (1L << (DAY - 153)) | (1L << (DEC - 153)) | (1L << (DECADE - 153)) | (1L << (DEFINER - 153)) | (1L << (DICTIONARY - 153)) | (1L << (DOW - 153)) | (1L << (DOY - 153)) | (1L << (DROP - 153)) | (1L << (EPOCH - 153)) | (1L << (EVERY - 153)) | (1L << (EXISTS - 153)) | (1L << (EXTERNAL - 153)) | (1L << (EXTRACT - 153)) | (1L << (FAMILY - 153)) | (1L << (FILTER - 153)) | (1L << (FIRST - 153)) | (1L << (FORMAT - 153)) | (1L << (FUSION - 153)) | (1L << (GROUPING - 153)) | (1L << (HASH - 153)) | (1L << (INDEX - 153)) | (1L << (INCREMENT - 153)) | (1L << (INPUT - 153)) | (1L << (INSERT - 153)) | (1L << (INTERSECTION - 153)) | (1L << (ISCACHABLE - 153)) | (1L << (ISODOW - 153)) | (1L << (ISOYEAR - 153)) | (1L << (ISSTRICT - 153)) | (1L << (LANGUAGE - 153)) | (1L << (LARGE - 153)) | (1L << (LAST - 153)) | (1L << (LESS - 153)) | (1L << (LIST - 153)) | (1L << (LOCATION - 153)) | (1L << (MATCH - 153)) | (1L << (MAX - 153)) | (1L << (MAXVALUE - 153)) | (1L << (MICROSECONDS - 153)) | (1L << (MILLENNIUM - 153)) | (1L << (MILLISECONDS - 153)) | (1L << (MIN - 153)) | (1L << (MINVALUE - 153)) | (1L << (MINUTE - 153)) | (1L << (MONTH - 153)) | (1L << (NATIONAL - 153)) | (1L << (NO - 153)) | (1L << (NONE - 153)) | (1L << (NULLIF - 153)) | (1L << (OBJECT - 153)) | (1L << (ON - 153)) | (1L << (OPTION - 153)) | (1L << (OPTIONS - 153)) | (1L << (OVERWRITE - 153)) | (1L << (PARSER - 153)) | (1L << (PARTIAL - 153)) | (1L << (PARTITION - 153)) | (1L << (PARTITIONS - 153)))) != 0) || ((((_la - 217)) & ~0x3f) == 0 && ((1L << (_la - 217)) & ((1L << (PRECISION - 217)) | (1L << (PUBLIC - 217)) | (1L << (PURGE - 217)) | (1L << (QUARTER - 217)) | (1L << (RANGE - 217)) | (1L << (REGEXP - 217)) | (1L << (RENAME - 217)) | (1L << (RESET - 217)) | (1L << (RLIKE - 217)) | (1L << (ROLLUP - 217)) | (1L << (SEARCH - 217)) | (1L << (SECOND - 217)) | (1L << (SECURITY - 217)) | (1L << (SERVER - 217)) | (1L << (SET - 217)) | (1L << (SIMILAR - 217)) | (1L << (SIMPLE - 217)) | (1L << (STABLE - 217)) | (1L << (START - 217)) | (1L << (STORAGE - 217)) | (1L << (STDDEV_POP - 217)) | (1L << (STDDEV_SAMP - 217)) | (1L << (SUBPARTITION - 217)) | (1L << (SUM - 217)) | (1L << (TABLESPACE - 217)) | (1L << (TEMPLATE - 217)) | (1L << (THAN - 217)) | (1L << (TIMEZONE - 217)) | (1L << (TIMEZONE_HOUR - 217)) | (1L << (TIMEZONE_MINUTE - 217)) | (1L << (TRIM - 217)) | (1L << (TO - 217)) | (1L << (TYPE - 217)) | (1L << (UNKNOWN - 217)) | (1L << (UNLOGGED - 217)) | (1L << (VALUES - 217)) | (1L << (VAR_SAMP - 217)) | (1L << (VAR_POP - 217)) | (1L << (VARYING - 217)) | (1L << (VOLATILE - 217)) | (1L << (WEEK - 217)) | (1L << (WINDOW - 217)) | (1L << (WRAPPER - 217)) | (1L << (YEAR - 217)) | (1L << (ZONE - 217)) | (1L << (BOOLEAN - 217)) | (1L << (BOOL - 217)) | (1L << (BIT - 217)) | (1L << (VARBIT - 217)) | (1L << (INT1 - 217)) | (1L << (INT2 - 217)) | (1L << (INT4 - 217)) | (1L << (INT8 - 217)) | (1L << (TINYINT - 217)) | (1L << (SMALLINT - 217)) | (1L << (INT - 217)) | (1L << (INTEGER - 217)) | (1L << (BIGINT - 217)) | (1L << (FLOAT4 - 217)) | (1L << (FLOAT8 - 217)) | (1L << (REAL - 217)))) != 0) || ((((_la - 281)) & ~0x3f) == 0 && ((1L << (_la - 281)) & ((1L << (FLOAT - 281)) | (1L << (DOUBLE - 281)) | (1L << (NUMERIC - 281)) | (1L << (DECIMAL - 281)) | (1L << (CHAR - 281)) | (1L << (VARCHAR - 281)) | (1L << (NCHAR - 281)) | (1L << (NVARCHAR - 281)) | (1L << (DATE - 281)) | (1L << (TIME - 281)) | (1L << (TIMETZ - 281)) | (1L << (TIMESTAMP - 281)) | (1L << (TIMESTAMPTZ - 281)) | (1L << (TEXT - 281)) | (1L << (UUID - 281)) | (1L << (VARBINARY - 281)) | (1L << (BLOB - 281)) | (1L << (BYTEA - 281)) | (1L << (INET4 - 281)) | (1L << (VOID - 281)) | (1L << (DOUBLE_QUOTE - 281)) | (1L << (Identifier - 281)) | (1L << (QuotedIdentifier - 281)))) != 0) );
					setState(2111); match(RIGHT_PAREN);
					}
				}

				setState(2115); storage_parameter_oid();
				setState(2116); on_commit();
				setState(2117); table_space();
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
		enterRule(_localctx, 70, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2121);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(2122);
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
		enterRule(_localctx, 72, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2126);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2124); match(CONSTRAINT);
				setState(2125); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2226);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(2128); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(2129); match(UNIQUE);
				setState(2130); match(LEFT_PAREN);
				setState(2135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2131); ((Table_constraintContext)_localctx).column_name_unique = identifier();
					setState(2133);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2132); match(COMMA);
						}
					}

					}
					}
					setState(2137); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(2139); match(RIGHT_PAREN);
				setState(2140); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2142); match(PRIMARY);
				setState(2143); match(KEY);
				setState(2144); match(LEFT_PAREN);
				setState(2149); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2145); ((Table_constraintContext)_localctx).column_name_pr_key = identifier();
					setState(2147);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2146); match(COMMA);
						}
					}

					}
					}
					setState(2151); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(2153); match(RIGHT_PAREN);
				setState(2154); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(2156); match(EXCLUDE);
				setState(2159);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(2157); match(USING);
					setState(2158); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(2161); match(LEFT_PAREN);
				setState(2162); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(2163); match(WITH);
				setState(2168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2164); ((Table_constraintContext)_localctx).operator = identifier();
					setState(2166);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2165); match(COMMA);
						}
					}

					}
					}
					setState(2170); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(2172); match(RIGHT_PAREN);
				setState(2173); index_parameters();
				setState(2179);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(2174); match(WHERE);
					setState(2175); match(LEFT_PAREN);
					setState(2176); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(2177); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(2181); match(FOREIGN);
				setState(2182); match(KEY);
				setState(2183); match(LEFT_PAREN);
				setState(2188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2184); ((Table_constraintContext)_localctx).column_name_for_key = identifier();
					setState(2186);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2185); match(COMMA);
						}
					}

					}
					}
					setState(2190); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
				setState(2192); match(RIGHT_PAREN);
				setState(2193); match(REFERENCES);
				setState(2194); ((Table_constraintContext)_localctx).reftable = identifier();
				setState(2206);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2195); match(LEFT_PAREN);
					setState(2200); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2196); ((Table_constraintContext)_localctx).refcolumn = identifier();
						setState(2198);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2197); match(COMMA);
							}
						}

						}
						}
						setState(2202); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
					setState(2204); match(RIGHT_PAREN);
					}
				}

				setState(2214);
				switch ( getInterpreter().adaptivePredict(_input,305,_ctx) ) {
				case 1:
					{
					{
					setState(2208); match(MATCH);
					setState(2209); match(FULL);
					}
					}
					break;
				case 2:
					{
					{
					setState(2210); match(MATCH);
					setState(2211); match(PARTIAL);
					}
					}
					break;
				case 3:
					{
					{
					setState(2212); match(MATCH);
					setState(2213); match(SIMPLE);
					}
					}
					break;
				}
				setState(2219);
				switch ( getInterpreter().adaptivePredict(_input,306,_ctx) ) {
				case 1:
					{
					setState(2216); match(ON);
					setState(2217); match(DELETE);
					setState(2218); ((Table_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2224);
				switch ( getInterpreter().adaptivePredict(_input,307,_ctx) ) {
				case 1:
					{
					setState(2221); match(ON);
					setState(2222); match(UPDATE);
					setState(2223); ((Table_constraintContext)_localctx).action_on_update = action();
					}
					break;
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2231);
			switch (_input.LA(1)) {
			case DEFERRABLE:
				{
				setState(2228); match(DEFERRABLE);
				}
				break;
			case NOT:
				{
				{
				setState(2229); match(NOT);
				setState(2230); match(DEFERRABLE);
				}
				}
				break;
			case CONSTRAINT:
			case EXCLUDE:
			case FOREIGN:
			case INITIALLY:
			case LIKE:
			case PRIMARY:
			case UNIQUE:
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
			case CACHE:
			case CALLED:
			case CLASS:
			case CENTURY:
			case CHARACTER:
			case CHECK:
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
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTERNAL:
			case EXTRACT:
			case FAMILY:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
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
			case OPTION:
			case OPTIONS:
			case OVERWRITE:
			case PARSER:
			case PARTIAL:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PUBLIC:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RENAME:
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
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
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
			case VOID:
			case COMMA:
			case RIGHT_PAREN:
			case DOUBLE_QUOTE:
			case Identifier:
			case QuotedIdentifier:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2237);
			switch ( getInterpreter().adaptivePredict(_input,310,_ctx) ) {
			case 1:
				{
				{
				setState(2233); match(INITIALLY);
				setState(2234); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2235); match(INITIALLY);
				setState(2236); match(IMMEDIATE);
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
		enterRule(_localctx, 74, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2241);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2239); match(CONSTRAINT);
				setState(2240); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2278);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(2243); match(NOT);
				setState(2244); match(NULL);
				}
				break;
			case NULL:
				{
				setState(2245); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(2246); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				setState(2247); match(DEFAULT);
				setState(2250);
				switch ( getInterpreter().adaptivePredict(_input,312,_ctx) ) {
				case 1:
					{
					setState(2248); ((Column_constraintContext)_localctx).default_expr_data = data_type();
					}
					break;
				case 2:
					{
					setState(2249); ((Column_constraintContext)_localctx).default_expr = value_expression();
					}
					break;
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(2252); match(UNIQUE);
				setState(2253); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2254); match(PRIMARY);
				setState(2255); match(KEY);
				setState(2256); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(2257); match(REFERENCES);
				setState(2258); ((Column_constraintContext)_localctx).reftable = schema_qualified_name();
				{
				{
				setState(2259); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(2266);
				switch ( getInterpreter().adaptivePredict(_input,313,_ctx) ) {
				case 1:
					{
					setState(2260); match(MATCH);
					setState(2261); match(FULL);
					}
					break;
				case 2:
					{
					setState(2262); match(MATCH);
					setState(2263); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(2264); match(MATCH);
					setState(2265); match(SIMPLE);
					}
					break;
				}
				setState(2271);
				switch ( getInterpreter().adaptivePredict(_input,314,_ctx) ) {
				case 1:
					{
					setState(2268); match(ON);
					setState(2269); match(DELETE);
					setState(2270); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2276);
				switch ( getInterpreter().adaptivePredict(_input,315,_ctx) ) {
				case 1:
					{
					setState(2273); match(ON);
					setState(2274); match(UPDATE);
					setState(2275); ((Column_constraintContext)_localctx).action_on_update = action();
					}
					break;
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2283);
			switch ( getInterpreter().adaptivePredict(_input,317,_ctx) ) {
			case 1:
				{
				setState(2280); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2281); match(NOT);
				setState(2282); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2289);
			switch ( getInterpreter().adaptivePredict(_input,318,_ctx) ) {
			case 1:
				{
				{
				setState(2285); match(INITIALLY);
				setState(2286); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2287); match(INITIALLY);
				setState(2288); match(IMMEDIATE);
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
		enterRule(_localctx, 76, RULE_check_boolean_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2291); match(CHECK);
			setState(2292); match(LEFT_PAREN);
			setState(2293); ((Check_boolean_expressionContext)_localctx).expression = boolean_value_expression();
			setState(2294); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
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
		enterRule(_localctx, 78, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2296); match(WITH);
			setState(2297); match(LEFT_PAREN);
			setState(2306); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2298); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(2301);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(2299); match(EQUAL);
					setState(2300); ((Storage_parameterContext)_localctx).value = identifier();
					}
				}

				setState(2304);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2303); match(COMMA);
					}
				}

				}
				}
				setState(2308); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)))) != 0) );
			setState(2310); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		public Storage_parameterContext storage_parameter() {
			return getRuleContext(Storage_parameterContext.class,0);
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
		enterRule(_localctx, 80, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2317);
			switch ( getInterpreter().adaptivePredict(_input,322,_ctx) ) {
			case 1:
				{
				setState(2312); storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(2313); match(WITH);
				setState(2314); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(2315); match(WITHOUT);
				setState(2316); match(OIDS);
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
		enterRule(_localctx, 82, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2328);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(2319); match(ON);
				setState(2320); match(COMMIT);
				setState(2326);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(2321); match(PRESERVE);
					setState(2322); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(2323); match(DELETE);
					setState(2324); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(2325); match(DROP);
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
		enterRule(_localctx, 84, RULE_table_space);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2332);
			_la = _input.LA(1);
			if (_la==TABLESPACE) {
				{
				setState(2330); match(TABLESPACE);
				setState(2331); ((Table_spaceContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 86, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2340);
			switch ( getInterpreter().adaptivePredict(_input,326,_ctx) ) {
			case 1:
				{
				setState(2334); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(2335); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(2336); match(SET);
				setState(2337); match(NULL);
				}
				break;
			case 4:
				{
				setState(2338); match(SET);
				setState(2339); match(DEFAULT);
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
		public Storage_parameterContext storage_parameter() {
			return getRuleContext(Storage_parameterContext.class,0);
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
		enterRule(_localctx, 88, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2343);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2342); storage_parameter();
				}
			}

			setState(2349);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(2345); match(USING);
				setState(2346); match(INDEX);
				setState(2347); match(TABLESPACE);
				setState(2348); ((Index_parametersContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 90, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2351); match(LEFT_PAREN);
			setState(2352); field_element();
			setState(2357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2353); match(COMMA);
				setState(2354); field_element();
				}
				}
				setState(2359);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2360); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 92, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2362); ((Field_elementContext)_localctx).name = identifier();
			setState(2363); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 94, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2365); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 96, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2367); match(WITH);
			setState(2368); match(LEFT_PAREN);
			setState(2369); param();
			setState(2374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2370); match(COMMA);
				setState(2371); param();
				}
				}
				setState(2376);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2377); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 98, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2379); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(2380); match(EQUAL);
			setState(2381); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 100, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2383); match(USING);
			setState(2384); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 102, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2386); match(TABLESPACE);
			setState(2387); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 104, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2389); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 106, RULE_table_partitioning_clauses);
		try {
			setState(2395);
			switch ( getInterpreter().adaptivePredict(_input,331,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2391); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2392); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2393); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2394); column_partitions();
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
		enterRule(_localctx, 108, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2397); match(PARTITION);
			setState(2398); match(BY);
			setState(2399); match(RANGE);
			setState(2400); match(LEFT_PAREN);
			setState(2401); column_reference_list();
			setState(2402); match(RIGHT_PAREN);
			setState(2403); match(LEFT_PAREN);
			setState(2404); range_value_clause_list();
			setState(2405); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 110, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2407); range_value_clause();
			setState(2412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2408); match(COMMA);
				setState(2409); range_value_clause();
				}
				}
				setState(2414);
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
		enterRule(_localctx, 112, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2415); match(PARTITION);
			setState(2416); partition_name();
			setState(2417); match(VALUES);
			setState(2418); match(LESS);
			setState(2419); match(THAN);
			setState(2431);
			switch ( getInterpreter().adaptivePredict(_input,335,_ctx) ) {
			case 1:
				{
				setState(2420); match(LEFT_PAREN);
				setState(2421); value_expression();
				setState(2422); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(2425);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2424); match(LEFT_PAREN);
					}
				}

				setState(2427); match(MAXVALUE);
				setState(2429);
				switch ( getInterpreter().adaptivePredict(_input,334,_ctx) ) {
				case 1:
					{
					setState(2428); match(RIGHT_PAREN);
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
		enterRule(_localctx, 114, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2433); match(PARTITION);
			setState(2434); match(BY);
			setState(2435); match(HASH);
			setState(2436); match(LEFT_PAREN);
			setState(2437); column_reference_list();
			setState(2438); match(RIGHT_PAREN);
			setState(2444);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(2439); match(LEFT_PAREN);
				setState(2440); individual_hash_partitions();
				setState(2441); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(2443); hash_partitions_by_quantity();
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
		enterRule(_localctx, 116, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2446); individual_hash_partition();
			setState(2451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2447); match(COMMA);
				setState(2448); individual_hash_partition();
				}
				}
				setState(2453);
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
		enterRule(_localctx, 118, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2454); match(PARTITION);
			setState(2455); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 120, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2457); match(PARTITIONS);
			setState(2458); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 122, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2460); match(PARTITION);
			setState(2461); match(BY);
			setState(2462); match(LIST);
			setState(2463); match(LEFT_PAREN);
			setState(2464); column_reference_list();
			setState(2465); match(RIGHT_PAREN);
			setState(2466); match(LEFT_PAREN);
			setState(2467); list_value_clause_list();
			setState(2468); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 124, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2470); list_value_partition();
			setState(2475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2471); match(COMMA);
				setState(2472); list_value_partition();
				}
				}
				setState(2477);
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
		enterRule(_localctx, 126, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2478); match(PARTITION);
			setState(2479); partition_name();
			setState(2480); match(VALUES);
			setState(2482);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(2481); match(IN);
				}
			}

			setState(2484); match(LEFT_PAREN);
			setState(2485); in_value_list();
			setState(2486); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 128, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2488); match(PARTITION);
			setState(2489); match(BY);
			setState(2490); match(COLUMN);
			setState(2491); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2493); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 132, RULE_drop_table_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2495); match(DROP);
			setState(2496); match(TABLE);
			setState(2497); schema_qualified_name();
			setState(2499);
			_la = _input.LA(1);
			if (_la==PURGE) {
				{
				setState(2498); match(PURGE);
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
		enterRule(_localctx, 134, RULE_identifier);
		int _la;
		try {
			setState(2510);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2501); match(Identifier);
				}
				break;
			case QuotedIdentifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(2502); match(QuotedIdentifier);
				}
				break;
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
			case CACHE:
			case CALLED:
			case CLASS:
			case CENTURY:
			case CHARACTER:
			case CHECK:
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
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTERNAL:
			case EXTRACT:
			case FAMILY:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
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
			case OPTION:
			case OPTIONS:
			case OVERWRITE:
			case PARSER:
			case PARTIAL:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PUBLIC:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RENAME:
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
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
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
			case VOID:
			case DOUBLE_QUOTE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2504);
				_la = _input.LA(1);
				if (_la==DOUBLE_QUOTE) {
					{
					setState(2503); match(DOUBLE_QUOTE);
					}
				}

				setState(2506); nonreserved_keywords();
				setState(2508);
				switch ( getInterpreter().adaptivePredict(_input,342,_ctx) ) {
				case 1:
					{
					setState(2507); match(DOUBLE_QUOTE);
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
		public TerminalNode QUARTER() { return getToken(SQLParser.QUARTER, 0); }
		public TerminalNode EVERY() { return getToken(SQLParser.EVERY, 0); }
		public TerminalNode NVARCHAR() { return getToken(SQLParser.NVARCHAR, 0); }
		public TerminalNode INT1() { return getToken(SQLParser.INT1, 0); }
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public TerminalNode MAX() { return getToken(SQLParser.MAX, 0); }
		public TerminalNode ROLLUP() { return getToken(SQLParser.ROLLUP, 0); }
		public TerminalNode SECOND() { return getToken(SQLParser.SECOND, 0); }
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
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public TerminalNode VARBINARY() { return getToken(SQLParser.VARBINARY, 0); }
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
		public TerminalNode DATA() { return getToken(SQLParser.DATA, 0); }
		public TerminalNode OVERWRITE() { return getToken(SQLParser.OVERWRITE, 0); }
		public TerminalNode NCHAR() { return getToken(SQLParser.NCHAR, 0); }
		public TerminalNode DICTIONARY() { return getToken(SQLParser.DICTIONARY, 0); }
		public TerminalNode TIMEZONE_HOUR() { return getToken(SQLParser.TIMEZONE_HOUR, 0); }
		public TerminalNode TIMETZ() { return getToken(SQLParser.TIMETZ, 0); }
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
		public TerminalNode STORAGE() { return getToken(SQLParser.STORAGE, 0); }
		public TerminalNode GROUPING() { return getToken(SQLParser.GROUPING, 0); }
		public TerminalNode TIMESTAMPTZ() { return getToken(SQLParser.TIMESTAMPTZ, 0); }
		public TerminalNode NATIONAL() { return getToken(SQLParser.NATIONAL, 0); }
		public TerminalNode BETWEEN() { return getToken(SQLParser.BETWEEN, 0); }
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public TerminalNode PARSER() { return getToken(SQLParser.PARSER, 0); }
		public TerminalNode UNLOGGED() { return getToken(SQLParser.UNLOGGED, 0); }
		public TerminalNode INCREMENT() { return getToken(SQLParser.INCREMENT, 0); }
		public TerminalNode FUSION() { return getToken(SQLParser.FUSION, 0); }
		public TerminalNode COMMIT() { return getToken(SQLParser.COMMIT, 0); }
		public TerminalNode SECURITY() { return getToken(SQLParser.SECURITY, 0); }
		public TerminalNode INT2() { return getToken(SQLParser.INT2, 0); }
		public TerminalNode VARBIT() { return getToken(SQLParser.VARBIT, 0); }
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
		public TerminalNode DOW() { return getToken(SQLParser.DOW, 0); }
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public TerminalNode SEARCH() { return getToken(SQLParser.SEARCH, 0); }
		public TerminalNode MINVALUE() { return getToken(SQLParser.MINVALUE, 0); }
		public TerminalNode MICROSECONDS() { return getToken(SQLParser.MICROSECONDS, 0); }
		public TerminalNode HASH() { return getToken(SQLParser.HASH, 0); }
		public TerminalNode DECIMAL() { return getToken(SQLParser.DECIMAL, 0); }
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
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
		public TerminalNode STABLE() { return getToken(SQLParser.STABLE, 0); }
		public TerminalNode SERVER() { return getToken(SQLParser.SERVER, 0); }
		public TerminalNode REAL() { return getToken(SQLParser.REAL, 0); }
		public TerminalNode COMMENT() { return getToken(SQLParser.COMMENT, 0); }
		public TerminalNode DAY() { return getToken(SQLParser.DAY, 0); }
		public TerminalNode LANGUAGE() { return getToken(SQLParser.LANGUAGE, 0); }
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
		enterRule(_localctx, 136, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2512);
			_la = _input.LA(1);
			if ( !(((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (ADMIN - 134)) | (1L << (AVG - 134)) | (1L << (BETWEEN - 134)) | (1L << (BY - 134)) | (1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MILLENNIUM - 198)) | (1L << (MILLISECONDS - 198)) | (1L << (MIN - 198)) | (1L << (MINVALUE - 198)) | (1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (YEAR - 262)) | (1L << (ZONE - 262)) | (1L << (BOOLEAN - 262)) | (1L << (BOOL - 262)) | (1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)))) != 0)) ) {
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
		enterRule(_localctx, 138, RULE_unsigned_literal);
		try {
			setState(2516);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2514); unsigned_numeric_literal();
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
				setState(2515); general_literal();
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
		enterRule(_localctx, 140, RULE_general_literal);
		try {
			setState(2521);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2518); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(2519); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(2520); boolean_literal();
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
		enterRule(_localctx, 142, RULE_datetime_literal);
		try {
			setState(2526);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(2523); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2524); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2525); date_literal();
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
		enterRule(_localctx, 144, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2528); match(TIME);
			setState(2529); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 146, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2531); match(TIMESTAMP);
			setState(2532); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 148, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2534); match(DATE);
			setState(2535); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 150, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2537);
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
		enterRule(_localctx, 152, RULE_data_type);
		try {
			setState(2542);
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
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(2539); predefined_type();
				}
				break;
			case SETOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(2540); match(SETOF);
				setState(2541); ((Data_typeContext)_localctx).value = identifier();
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
		enterRule(_localctx, 154, RULE_predefined_type);
		try {
			setState(2557);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2544); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2545); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(2546); binary_large_object_string_type();
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
				setState(2547); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(2548); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(2549); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2550); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(2551); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(2552); network_type();
				}
				break;
			case REGCLASS:
				enterOuterAlt(_localctx, 10);
				{
				setState(2553); regclass();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 11);
				{
				setState(2554); match(TRIGGER);
				}
				break;
			case UUID:
				enterOuterAlt(_localctx, 12);
				{
				setState(2555); match(UUID);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 13);
				{
				setState(2556); match(VOID);
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
		enterRule(_localctx, 156, RULE_regclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2559); match(REGCLASS);
			}
		}
		catch (RecognitionException re) {
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
			setState(2561); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		try {
			setState(2586);
			switch ( getInterpreter().adaptivePredict(_input,354,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2563); match(CHARACTER);
				setState(2565);
				switch ( getInterpreter().adaptivePredict(_input,349,_ctx) ) {
				case 1:
					{
					setState(2564); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2567); match(CHAR);
				setState(2569);
				switch ( getInterpreter().adaptivePredict(_input,350,_ctx) ) {
				case 1:
					{
					setState(2568); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2571); match(CHARACTER);
				setState(2572); match(VARYING);
				setState(2574);
				switch ( getInterpreter().adaptivePredict(_input,351,_ctx) ) {
				case 1:
					{
					setState(2573); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2576); match(CHAR);
				setState(2577); match(VARYING);
				setState(2579);
				switch ( getInterpreter().adaptivePredict(_input,352,_ctx) ) {
				case 1:
					{
					setState(2578); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2581); match(VARCHAR);
				setState(2583);
				switch ( getInterpreter().adaptivePredict(_input,353,_ctx) ) {
				case 1:
					{
					setState(2582); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2585); match(TEXT);
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
			setState(2588); match(LEFT_PAREN);
			setState(2589); match(NUMBER);
			setState(2590); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(2627);
			switch ( getInterpreter().adaptivePredict(_input,362,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2592); match(NATIONAL);
				setState(2593); match(CHARACTER);
				setState(2595);
				switch ( getInterpreter().adaptivePredict(_input,355,_ctx) ) {
				case 1:
					{
					setState(2594); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2597); match(NATIONAL);
				setState(2598); match(CHAR);
				setState(2600);
				switch ( getInterpreter().adaptivePredict(_input,356,_ctx) ) {
				case 1:
					{
					setState(2599); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2602); match(NCHAR);
				setState(2604);
				switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
				case 1:
					{
					setState(2603); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2606); match(NATIONAL);
				setState(2607); match(CHARACTER);
				setState(2608); match(VARYING);
				setState(2610);
				switch ( getInterpreter().adaptivePredict(_input,358,_ctx) ) {
				case 1:
					{
					setState(2609); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2612); match(NATIONAL);
				setState(2613); match(CHAR);
				setState(2614); match(VARYING);
				setState(2616);
				switch ( getInterpreter().adaptivePredict(_input,359,_ctx) ) {
				case 1:
					{
					setState(2615); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2618); match(NCHAR);
				setState(2619); match(VARYING);
				setState(2621);
				switch ( getInterpreter().adaptivePredict(_input,360,_ctx) ) {
				case 1:
					{
					setState(2620); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2623); match(NVARCHAR);
				setState(2625);
				switch ( getInterpreter().adaptivePredict(_input,361,_ctx) ) {
				case 1:
					{
					setState(2624); type_length();
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
			setState(2637);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(2629); match(BLOB);
				setState(2631);
				switch ( getInterpreter().adaptivePredict(_input,363,_ctx) ) {
				case 1:
					{
					setState(2630); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(2633); match(BYTEA);
				setState(2635);
				switch ( getInterpreter().adaptivePredict(_input,364,_ctx) ) {
				case 1:
					{
					setState(2634); type_length();
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
			setState(2641);
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
				setState(2639); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2640); approximate_numeric_type();
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
		try {
			setState(2664);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2643); match(NUMERIC);
				setState(2645);
				switch ( getInterpreter().adaptivePredict(_input,367,_ctx) ) {
				case 1:
					{
					setState(2644); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2647); match(DECIMAL);
				setState(2649);
				switch ( getInterpreter().adaptivePredict(_input,368,_ctx) ) {
				case 1:
					{
					setState(2648); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(2651); match(DEC);
				setState(2653);
				switch ( getInterpreter().adaptivePredict(_input,369,_ctx) ) {
				case 1:
					{
					setState(2652); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(2655); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2656); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(2657); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2658); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(2659); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(2660); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(2661); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(2662); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(2663); match(BIGINT);
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
		try {
			setState(2676);
			switch ( getInterpreter().adaptivePredict(_input,372,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2666); match(FLOAT);
				setState(2668);
				switch ( getInterpreter().adaptivePredict(_input,371,_ctx) ) {
				case 1:
					{
					setState(2667); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2670); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2671); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2672); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2673); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2674); match(DOUBLE);
				setState(2675); match(PRECISION);
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
		enterRule(_localctx, 174, RULE_precision_param);
		try {
			setState(2686);
			switch ( getInterpreter().adaptivePredict(_input,373,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2678); match(LEFT_PAREN);
				setState(2679); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2680); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2681); match(LEFT_PAREN);
				setState(2682); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2683); match(COMMA);
				setState(2684); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(2685); match(RIGHT_PAREN);
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
			setState(2688);
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
		try {
			setState(2707);
			switch ( getInterpreter().adaptivePredict(_input,374,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2690); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2691); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2692); match(TIME);
				setState(2693); match(WITH);
				setState(2694); match(TIME);
				setState(2695); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2696); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2697); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2698); match(TIMESTAMP);
				setState(2699); match(WITH);
				setState(2700); match(TIME);
				setState(2701); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2702); match(TIMESTAMP);
				setState(2703); match(WITHOUT);
				setState(2704); match(TIME);
				setState(2705); match(ZONE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2706); match(TIMESTAMPTZ);
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
		enterRule(_localctx, 180, RULE_bit_type);
		try {
			setState(2722);
			switch ( getInterpreter().adaptivePredict(_input,378,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2709); match(BIT);
				setState(2711);
				switch ( getInterpreter().adaptivePredict(_input,375,_ctx) ) {
				case 1:
					{
					setState(2710); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2713); match(VARBIT);
				setState(2715);
				switch ( getInterpreter().adaptivePredict(_input,376,_ctx) ) {
				case 1:
					{
					setState(2714); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2717); match(BIT);
				setState(2718); match(VARYING);
				setState(2720);
				switch ( getInterpreter().adaptivePredict(_input,377,_ctx) ) {
				case 1:
					{
					setState(2719); type_length();
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
			setState(2737);
			switch ( getInterpreter().adaptivePredict(_input,382,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2724); match(BINARY);
				setState(2726);
				switch ( getInterpreter().adaptivePredict(_input,379,_ctx) ) {
				case 1:
					{
					setState(2725); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2728); match(BINARY);
				setState(2729); match(VARYING);
				setState(2731);
				switch ( getInterpreter().adaptivePredict(_input,380,_ctx) ) {
				case 1:
					{
					setState(2730); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2733); match(VARBINARY);
				setState(2735);
				switch ( getInterpreter().adaptivePredict(_input,381,_ctx) ) {
				case 1:
					{
					setState(2734); type_length();
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
			setState(2741);
			switch ( getInterpreter().adaptivePredict(_input,383,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2739); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2740); nonparenthesized_value_expression_primary();
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
			setState(2743); match(LEFT_PAREN);
			setState(2744); value_expression();
			setState(2745); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 188, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(2754);
			switch ( getInterpreter().adaptivePredict(_input,384,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2747); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2748); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2749); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2750); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2751); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2752); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2753); routine_invocation();
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
			setState(2756); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
			setState(2758);
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
			setState(2761);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2760); sign();
				}
			}

			setState(2763); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
			setState(2765); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
			setState(2775);
			switch ( getInterpreter().adaptivePredict(_input,387,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2767); match(COUNT);
				setState(2768); match(LEFT_PAREN);
				setState(2769); match(MULTIPLY);
				setState(2770); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2771); general_set_function();
				setState(2773);
				switch ( getInterpreter().adaptivePredict(_input,386,_ctx) ) {
				case 1:
					{
					setState(2772); filter_clause();
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2777); set_function_type();
			setState(2778); match(LEFT_PAREN);
			setState(2780);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(2779); set_qualifier();
				}
			}

			setState(2782); value_expression();
			setState(2783); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(2785);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & ((1L << (SOME - 109)) | (1L << (AVG - 109)) | (1L << (COLLECT - 109)) | (1L << (COUNT - 109)) | (1L << (EVERY - 109)))) != 0) || ((((_la - 174)) & ~0x3f) == 0 && ((1L << (_la - 174)) & ((1L << (FUSION - 174)) | (1L << (INTERSECTION - 174)) | (1L << (MAX - 174)) | (1L << (MIN - 174)) | (1L << (STDDEV_POP - 174)))) != 0) || ((((_la - 238)) & ~0x3f) == 0 && ((1L << (_la - 238)) & ((1L << (STDDEV_SAMP - 238)) | (1L << (SUM - 238)) | (1L << (VAR_SAMP - 238)) | (1L << (VAR_POP - 238)))) != 0)) ) {
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
		enterRule(_localctx, 204, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2787); match(FILTER);
			setState(2788); match(LEFT_PAREN);
			setState(2789); match(WHERE);
			setState(2790); search_condition();
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
			setState(2793); match(GROUPING);
			setState(2794); match(LEFT_PAREN);
			setState(2795); column_reference_list();
			setState(2796); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(2798); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 210, RULE_case_abbreviation);
		int _la;
		try {
			setState(2818);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(2800); match(NULLIF);
				setState(2801); match(LEFT_PAREN);
				setState(2802); numeric_value_expression();
				setState(2803); match(COMMA);
				setState(2804); boolean_value_expression();
				setState(2805); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2807); match(COALESCE);
				setState(2808); match(LEFT_PAREN);
				setState(2809); numeric_value_expression();
				setState(2812); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2810); match(COMMA);
					setState(2811); boolean_value_expression();
					}
					}
					setState(2814); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(2816); match(RIGHT_PAREN);
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
			setState(2822);
			switch ( getInterpreter().adaptivePredict(_input,391,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2820); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2821); searched_case();
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
		enterRule(_localctx, 214, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2824); match(CASE);
			setState(2825); boolean_value_expression();
			setState(2827); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2826); simple_when_clause();
				}
				}
				setState(2829); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2832);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2831); else_clause();
				}
			}

			setState(2834); match(END);
			}
		}
		catch (RecognitionException re) {
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
			setState(2836); match(CASE);
			setState(2838); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2837); searched_when_clause();
				}
				}
				setState(2840); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2843);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2842); else_clause();
				}
			}

			setState(2845); match(END);
			}
		}
		catch (RecognitionException re) {
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
			setState(2847); match(WHEN);
			setState(2848); search_condition();
			setState(2849); match(THEN);
			setState(2850); result();
			}
		}
		catch (RecognitionException re) {
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
			setState(2852); match(WHEN);
			setState(2853); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(2854); match(THEN);
			setState(2855); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
			setState(2857); match(ELSE);
			setState(2858); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
			setState(2862);
			switch ( getInterpreter().adaptivePredict(_input,396,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2860); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2861); match(NULL);
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
			setState(2864); match(CAST);
			setState(2865); match(LEFT_PAREN);
			setState(2866); cast_operand();
			setState(2867); match(AS);
			setState(2868); cast_target();
			setState(2869); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
			setState(2871); value_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(2873); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 232, RULE_value_expression);
		try {
			setState(2878);
			switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2875); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2876); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2877); boolean_value_expression();
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
		enterRule(_localctx, 234, RULE_common_value_expression);
		try {
			setState(2883);
			switch ( getInterpreter().adaptivePredict(_input,398,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2880); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2881); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2882); match(NULL);
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
		enterRule(_localctx, 236, RULE_numeric_value_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2885); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(2890);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,399,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2886);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(2887); ((Numeric_value_expressionContext)_localctx).right = term();
					}
					} 
				}
				setState(2892);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,399,_ctx);
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
		enterRule(_localctx, 238, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2893); ((TermContext)_localctx).left = factor();
			setState(2898);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 322)) & ~0x3f) == 0 && ((1L << (_la - 322)) & ((1L << (MULTIPLY - 322)) | (1L << (DIVIDE - 322)) | (1L << (MODULAR - 322)))) != 0)) {
				{
				{
				setState(2894);
				_la = _input.LA(1);
				if ( !(((((_la - 322)) & ~0x3f) == 0 && ((1L << (_la - 322)) & ((1L << (MULTIPLY - 322)) | (1L << (DIVIDE - 322)) | (1L << (MODULAR - 322)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2895); ((TermContext)_localctx).right = factor();
				}
				}
				setState(2900);
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
		enterRule(_localctx, 240, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2902);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2901); sign();
				}
			}

			setState(2904); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 242, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2906); match(LEFT_PAREN);
			setState(2907); numeric_value_expression();
			setState(2912);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2908); match(COMMA);
				setState(2909); numeric_value_expression();
				}
				}
				setState(2914);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2915); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 244, RULE_numeric_primary);
		int _la;
		try {
			setState(2926);
			switch ( getInterpreter().adaptivePredict(_input,404,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2917); value_expression_primary();
				setState(2922);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(2918); match(CAST_EXPRESSION);
					setState(2919); cast_target();
					}
					}
					setState(2924);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2925); numeric_value_function();
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
		enterRule(_localctx, 246, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2928);
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
		enterRule(_localctx, 248, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2930); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 250, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2932); match(EXTRACT);
			setState(2933); match(LEFT_PAREN);
			setState(2934); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(2935); match(FROM);
			setState(2936); extract_source();
			setState(2937); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 252, RULE_extract_field);
		try {
			setState(2942);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2939); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2940); time_zone_field();
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
				setState(2941); extended_datetime_field();
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
		enterRule(_localctx, 254, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2944);
			_la = _input.LA(1);
			if ( !(((((_la - 245)) & ~0x3f) == 0 && ((1L << (_la - 245)) & ((1L << (TIMEZONE - 245)) | (1L << (TIMEZONE_HOUR - 245)) | (1L << (TIMEZONE_MINUTE - 245)))) != 0)) ) {
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
		enterRule(_localctx, 256, RULE_extract_source);
		try {
			setState(2948);
			switch ( getInterpreter().adaptivePredict(_input,406,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2946); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2947); datetime_literal();
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
		enterRule(_localctx, 258, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2950); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 260, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2952); character_factor();
			setState(2957);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(2953); match(CONCATENATION_OPERATOR);
				setState(2954); character_factor();
				}
				}
				setState(2959);
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
		enterRule(_localctx, 262, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2960); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 264, RULE_character_primary);
		try {
			setState(2964);
			switch ( getInterpreter().adaptivePredict(_input,408,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2962); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2963); string_value_function();
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
		enterRule(_localctx, 266, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2966); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 268, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2968); match(TRIM);
			setState(2969); match(LEFT_PAREN);
			setState(2970); trim_operands();
			setState(2971); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 270, RULE_trim_operands);
		int _la;
		try {
			setState(2987);
			switch ( getInterpreter().adaptivePredict(_input,412,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2980);
				switch ( getInterpreter().adaptivePredict(_input,411,_ctx) ) {
				case 1:
					{
					setState(2974);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(2973); trim_specification();
						}
					}

					setState(2977);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (LEFT - 72)) | (1L << (RIGHT - 72)) | (1L << (SOME - 72)) | (1L << (TRUE - 72)) | (1L << (ADMIN - 72)) | (1L << (AVG - 72)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (BETWEEN - 136)) | (1L << (BY - 136)) | (1L << (CACHE - 136)) | (1L << (CALLED - 136)) | (1L << (CLASS - 136)) | (1L << (CENTURY - 136)) | (1L << (CHARACTER - 136)) | (1L << (CHECK - 136)) | (1L << (COLLECT - 136)) | (1L << (COALESCE - 136)) | (1L << (COLUMN - 136)) | (1L << (COMMENT - 136)) | (1L << (COMMENTS - 136)) | (1L << (COMMIT - 136)) | (1L << (CONFIGURATION - 136)) | (1L << (COST - 136)) | (1L << (COUNT - 136)) | (1L << (CUBE - 136)) | (1L << (CURRENT - 136)) | (1L << (CYCLE - 136)) | (1L << (DATA - 136)) | (1L << (DAY - 136)) | (1L << (DEC - 136)) | (1L << (DECADE - 136)) | (1L << (DEFINER - 136)) | (1L << (DICTIONARY - 136)) | (1L << (DOW - 136)) | (1L << (DOY - 136)) | (1L << (DROP - 136)) | (1L << (EPOCH - 136)) | (1L << (EVERY - 136)) | (1L << (EXISTS - 136)) | (1L << (EXTERNAL - 136)) | (1L << (EXTRACT - 136)) | (1L << (FAMILY - 136)) | (1L << (FILTER - 136)) | (1L << (FIRST - 136)) | (1L << (FORMAT - 136)) | (1L << (FUSION - 136)) | (1L << (GROUPING - 136)) | (1L << (HASH - 136)) | (1L << (INDEX - 136)) | (1L << (INCREMENT - 136)) | (1L << (INPUT - 136)) | (1L << (INSERT - 136)) | (1L << (INTERSECTION - 136)) | (1L << (ISCACHABLE - 136)) | (1L << (ISODOW - 136)) | (1L << (ISOYEAR - 136)) | (1L << (ISSTRICT - 136)) | (1L << (LANGUAGE - 136)) | (1L << (LARGE - 136)) | (1L << (LAST - 136)) | (1L << (LESS - 136)) | (1L << (LIST - 136)) | (1L << (LOCATION - 136)) | (1L << (MATCH - 136)) | (1L << (MAX - 136)) | (1L << (MAXVALUE - 136)) | (1L << (MICROSECONDS - 136)) | (1L << (MILLENNIUM - 136)) | (1L << (MILLISECONDS - 136)))) != 0) || ((((_la - 200)) & ~0x3f) == 0 && ((1L << (_la - 200)) & ((1L << (MIN - 200)) | (1L << (MINVALUE - 200)) | (1L << (MINUTE - 200)) | (1L << (MONTH - 200)) | (1L << (NATIONAL - 200)) | (1L << (NO - 200)) | (1L << (NONE - 200)) | (1L << (NULLIF - 200)) | (1L << (OBJECT - 200)) | (1L << (ON - 200)) | (1L << (OPTION - 200)) | (1L << (OPTIONS - 200)) | (1L << (OVERWRITE - 200)) | (1L << (PARSER - 200)) | (1L << (PARTIAL - 200)) | (1L << (PARTITION - 200)) | (1L << (PARTITIONS - 200)) | (1L << (PRECISION - 200)) | (1L << (PUBLIC - 200)) | (1L << (PURGE - 200)) | (1L << (QUARTER - 200)) | (1L << (RANGE - 200)) | (1L << (REGEXP - 200)) | (1L << (RENAME - 200)) | (1L << (RESET - 200)) | (1L << (RLIKE - 200)) | (1L << (ROLLUP - 200)) | (1L << (SEARCH - 200)) | (1L << (SECOND - 200)) | (1L << (SECURITY - 200)) | (1L << (SERVER - 200)) | (1L << (SET - 200)) | (1L << (SIMILAR - 200)) | (1L << (SIMPLE - 200)) | (1L << (STABLE - 200)) | (1L << (START - 200)) | (1L << (STORAGE - 200)) | (1L << (STDDEV_POP - 200)) | (1L << (STDDEV_SAMP - 200)) | (1L << (SUBPARTITION - 200)) | (1L << (SUM - 200)) | (1L << (TABLESPACE - 200)) | (1L << (TEMPLATE - 200)) | (1L << (THAN - 200)) | (1L << (TIMEZONE - 200)) | (1L << (TIMEZONE_HOUR - 200)) | (1L << (TIMEZONE_MINUTE - 200)) | (1L << (TRIM - 200)) | (1L << (TO - 200)) | (1L << (TYPE - 200)) | (1L << (UNKNOWN - 200)) | (1L << (UNLOGGED - 200)) | (1L << (VALUES - 200)) | (1L << (VAR_SAMP - 200)) | (1L << (VAR_POP - 200)) | (1L << (VARYING - 200)) | (1L << (VOLATILE - 200)) | (1L << (WEEK - 200)) | (1L << (WINDOW - 200)) | (1L << (WRAPPER - 200)) | (1L << (YEAR - 200)) | (1L << (ZONE - 200)))) != 0) || ((((_la - 264)) & ~0x3f) == 0 && ((1L << (_la - 264)) & ((1L << (BOOLEAN - 264)) | (1L << (BOOL - 264)) | (1L << (BIT - 264)) | (1L << (VARBIT - 264)) | (1L << (INT1 - 264)) | (1L << (INT2 - 264)) | (1L << (INT4 - 264)) | (1L << (INT8 - 264)) | (1L << (TINYINT - 264)) | (1L << (SMALLINT - 264)) | (1L << (INT - 264)) | (1L << (INTEGER - 264)) | (1L << (BIGINT - 264)) | (1L << (FLOAT4 - 264)) | (1L << (FLOAT8 - 264)) | (1L << (REAL - 264)) | (1L << (FLOAT - 264)) | (1L << (DOUBLE - 264)) | (1L << (NUMERIC - 264)) | (1L << (DECIMAL - 264)) | (1L << (CHAR - 264)) | (1L << (VARCHAR - 264)) | (1L << (NCHAR - 264)) | (1L << (NVARCHAR - 264)) | (1L << (DATE - 264)) | (1L << (TIME - 264)) | (1L << (TIMETZ - 264)) | (1L << (TIMESTAMP - 264)) | (1L << (TIMESTAMPTZ - 264)) | (1L << (TEXT - 264)) | (1L << (UUID - 264)) | (1L << (VARBINARY - 264)) | (1L << (BLOB - 264)) | (1L << (BYTEA - 264)) | (1L << (INET4 - 264)) | (1L << (VOID - 264)) | (1L << (LEFT_PAREN - 264)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (NUMBER - 329)) | (1L << (REAL_NUMBER - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)) | (1L << (Character_String_Literal - 329)))) != 0)) {
						{
						setState(2976); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(2979); match(FROM);
					}
					break;
				}
				setState(2982); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2983); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(2984); match(COMMA);
				setState(2985); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
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
		enterRule(_localctx, 272, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2989);
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
		enterRule(_localctx, 274, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2991); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 276, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2993); and_predicate();
			setState(2998);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,413,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2994); match(OR);
					setState(2995); or_predicate();
					}
					} 
				}
				setState(3000);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,413,_ctx);
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
		enterRule(_localctx, 278, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3001); boolean_factor();
			setState(3006);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,414,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3002); match(AND);
					setState(3003); and_predicate();
					}
					} 
				}
				setState(3008);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,414,_ctx);
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
		enterRule(_localctx, 280, RULE_boolean_factor);
		try {
			setState(3012);
			switch ( getInterpreter().adaptivePredict(_input,415,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3009); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3010); match(NOT);
				setState(3011); boolean_test();
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
		enterRule(_localctx, 282, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3014); boolean_primary();
			setState(3016);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(3015); is_clause();
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
		enterRule(_localctx, 284, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3018); match(IS);
			setState(3020);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3019); match(NOT);
				}
			}

			setState(3022); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 286, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3024);
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
		enterRule(_localctx, 288, RULE_boolean_primary);
		try {
			setState(3028);
			switch ( getInterpreter().adaptivePredict(_input,418,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3026); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3027); boolean_predicand();
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
		enterRule(_localctx, 290, RULE_boolean_predicand);
		try {
			setState(3032);
			switch ( getInterpreter().adaptivePredict(_input,419,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3030); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3031); nonparenthesized_value_expression_primary();
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
		enterRule(_localctx, 292, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3034); match(LEFT_PAREN);
			setState(3035); boolean_value_expression();
			setState(3036); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 294, RULE_row_value_expression);
		try {
			setState(3040);
			switch (_input.LA(1)) {
			case ANY:
			case CASE:
			case CAST:
			case FALSE:
			case LEFT:
			case RIGHT:
			case SOME:
			case TRUE:
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
			case CACHE:
			case CALLED:
			case CLASS:
			case CENTURY:
			case CHARACTER:
			case CHECK:
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
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTERNAL:
			case EXTRACT:
			case FAMILY:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
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
			case OPTION:
			case OPTIONS:
			case OVERWRITE:
			case PARSER:
			case PARTIAL:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PUBLIC:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RENAME:
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
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
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
			case VOID:
			case LEFT_PAREN:
			case DOUBLE_QUOTE:
			case NUMBER:
			case REAL_NUMBER:
			case Identifier:
			case QuotedIdentifier:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(3038); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(3039); explicit_row_value_constructor();
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
		enterRule(_localctx, 296, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3042); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 298, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3044); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 300, RULE_row_value_predicand);
		try {
			setState(3048);
			switch ( getInterpreter().adaptivePredict(_input,421,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3046); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3047); row_value_constructor_predicand();
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
		enterRule(_localctx, 302, RULE_row_value_constructor_predicand);
		try {
			setState(3052);
			switch ( getInterpreter().adaptivePredict(_input,422,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3050); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3051); boolean_predicand();
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
		enterRule(_localctx, 304, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3054); from_clause();
			setState(3056);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(3055); where_clause();
				}
			}

			setState(3059);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(3058); groupby_clause();
				}
			}

			setState(3062);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(3061); having_clause();
				}
			}

			setState(3065);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(3064); orderby_clause();
				}
			}

			setState(3068);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(3067); limit_clause();
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
		enterRule(_localctx, 306, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3070); match(FROM);
			setState(3071); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 308, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3073); table_reference();
			setState(3078);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3074); match(COMMA);
				setState(3075); table_reference();
				}
				}
				setState(3080);
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
		enterRule(_localctx, 310, RULE_table_reference);
		try {
			setState(3083);
			switch ( getInterpreter().adaptivePredict(_input,429,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3081); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3082); table_primary();
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
		enterRule(_localctx, 312, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3085); table_primary();
			setState(3087); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(3086); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(3089); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,430,_ctx);
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
		enterRule(_localctx, 314, RULE_joined_table_primary);
		int _la;
		try {
			setState(3110);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(3091); match(CROSS);
				setState(3092); match(JOIN);
				setState(3093); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3095);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (FULL - 44)) | (1L << (INNER - 44)) | (1L << (LEFT - 44)) | (1L << (RIGHT - 44)))) != 0)) {
					{
					setState(3094); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3097); match(JOIN);
				setState(3098); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(3099); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(3101); match(NATURAL);
				setState(3103);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (FULL - 44)) | (1L << (INNER - 44)) | (1L << (LEFT - 44)) | (1L << (RIGHT - 44)))) != 0)) {
					{
					setState(3102); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3105); match(JOIN);
				setState(3106); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(3107); match(UNION);
				setState(3108); match(JOIN);
				setState(3109); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 316, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3112); match(CROSS);
			setState(3113); match(JOIN);
			setState(3114); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 318, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3117);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (FULL - 44)) | (1L << (INNER - 44)) | (1L << (LEFT - 44)) | (1L << (RIGHT - 44)))) != 0)) {
				{
				setState(3116); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(3119); match(JOIN);
			setState(3120); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(3121); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 320, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3123); match(NATURAL);
			setState(3125);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (FULL - 44)) | (1L << (INNER - 44)) | (1L << (LEFT - 44)) | (1L << (RIGHT - 44)))) != 0)) {
				{
				setState(3124); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(3127); match(JOIN);
			setState(3128); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 322, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3130); match(UNION);
			setState(3131); match(JOIN);
			setState(3132); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 324, RULE_join_type);
		try {
			setState(3136);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3134); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3135); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 326, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3138); outer_join_type_part2();
			setState(3140);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(3139); match(OUTER);
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
		enterRule(_localctx, 328, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3142);
			_la = _input.LA(1);
			if ( !(((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (FULL - 44)) | (1L << (LEFT - 44)) | (1L << (RIGHT - 44)))) != 0)) ) {
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
		enterRule(_localctx, 330, RULE_join_specification);
		try {
			setState(3146);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(3144); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(3145); named_columns_join();
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
		enterRule(_localctx, 332, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3148); match(ON);
			setState(3149); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 334, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3151); match(USING);
			setState(3152); match(LEFT_PAREN);
			setState(3153); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(3154); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 336, RULE_table_primary);
		int _la;
		try {
			setState(3180);
			switch (_input.LA(1)) {
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
			case CACHE:
			case CALLED:
			case CLASS:
			case CENTURY:
			case CHARACTER:
			case CHECK:
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
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTERNAL:
			case EXTRACT:
			case FAMILY:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
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
			case OPTION:
			case OPTIONS:
			case OVERWRITE:
			case PARSER:
			case PARTIAL:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PUBLIC:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RENAME:
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
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
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
			case VOID:
			case DOUBLE_QUOTE:
			case Identifier:
			case QuotedIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(3156); table_or_query_name();
				setState(3161);
				switch ( getInterpreter().adaptivePredict(_input,440,_ctx) ) {
				case 1:
					{
					setState(3158);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(3157); match(AS);
						}
					}

					setState(3160); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(3167);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3163); match(LEFT_PAREN);
					setState(3164); column_name_list();
					setState(3165); match(RIGHT_PAREN);
					}
				}

				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3169); derived_table();
				setState(3171);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3170); match(AS);
					}
				}

				setState(3173); ((Table_primaryContext)_localctx).name = identifier();
				setState(3178);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3174); match(LEFT_PAREN);
					setState(3175); column_name_list();
					setState(3176); match(RIGHT_PAREN);
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
		enterRule(_localctx, 338, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3182); identifier();
			setState(3187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3183); match(COMMA);
				setState(3184); identifier();
				}
				}
				setState(3189);
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
		enterRule(_localctx, 340, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3190); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 342, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3192); match(WHERE);
			setState(3193); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 344, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3195); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 346, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3197); match(GROUP);
			setState(3198); match(BY);
			setState(3199); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 348, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3201); grouping_element();
			setState(3206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3202); match(COMMA);
				setState(3203); grouping_element();
				}
				}
				setState(3208);
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
		enterRule(_localctx, 350, RULE_grouping_element);
		try {
			setState(3213);
			switch ( getInterpreter().adaptivePredict(_input,447,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3209); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3210); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3211); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3212); ordinary_grouping_set();
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
		enterRule(_localctx, 352, RULE_ordinary_grouping_set);
		try {
			setState(3220);
			switch ( getInterpreter().adaptivePredict(_input,448,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3215); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3216); match(LEFT_PAREN);
				setState(3217); row_value_predicand_list();
				setState(3218); match(RIGHT_PAREN);
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
		enterRule(_localctx, 354, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3222); ordinary_grouping_set();
			setState(3227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3223); match(COMMA);
				setState(3224); ordinary_grouping_set();
				}
				}
				setState(3229);
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
		enterRule(_localctx, 356, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3230); match(ROLLUP);
			setState(3231); match(LEFT_PAREN);
			setState(3232); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3233); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 358, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3235); match(CUBE);
			setState(3236); match(LEFT_PAREN);
			setState(3237); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3238); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 360, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3240); match(LEFT_PAREN);
			setState(3241); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 362, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3243); match(HAVING);
			setState(3244); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 364, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3246); row_value_predicand();
			setState(3251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3247); match(COMMA);
				setState(3248); row_value_predicand();
				}
				}
				setState(3253);
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
		enterRule(_localctx, 366, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3254); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 368, RULE_query_expression_body);
		try {
			setState(3258);
			switch ( getInterpreter().adaptivePredict(_input,451,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3256); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3257); joined_table();
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
		enterRule(_localctx, 370, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3268);
			switch ( getInterpreter().adaptivePredict(_input,453,_ctx) ) {
			case 1:
				{
				setState(3260); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(3261); joined_table();
				setState(3262);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3264);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3263);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3266); query_term();
				}
				break;
			}
			setState(3277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(3270);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3272);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3271);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3274); query_term();
				}
				}
				setState(3279);
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
		enterRule(_localctx, 372, RULE_query_term);
		try {
			setState(3282);
			switch ( getInterpreter().adaptivePredict(_input,456,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3280); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3281); joined_table();
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
		enterRule(_localctx, 374, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3292);
			switch ( getInterpreter().adaptivePredict(_input,458,_ctx) ) {
			case 1:
				{
				setState(3284); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(3285); joined_table();
				setState(3286); match(INTERSECT);
				setState(3288);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3287);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3290); query_primary();
				}
				break;
			}
			setState(3301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(3294); match(INTERSECT);
				setState(3296);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3295);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3298); query_primary();
				}
				}
				setState(3303);
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
		enterRule(_localctx, 376, RULE_query_primary);
		try {
			setState(3306);
			switch ( getInterpreter().adaptivePredict(_input,461,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3304); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3305); joined_table();
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
		enterRule(_localctx, 378, RULE_non_join_query_primary);
		try {
			setState(3313);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3308); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3309); match(LEFT_PAREN);
				setState(3310); non_join_query_expression();
				setState(3311); match(RIGHT_PAREN);
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
		enterRule(_localctx, 380, RULE_simple_table);
		try {
			setState(3317);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(3315); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3316); explicit_table();
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
		enterRule(_localctx, 382, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3319); match(TABLE);
			setState(3320); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 384, RULE_table_or_query_name);
		try {
			setState(3324);
			switch ( getInterpreter().adaptivePredict(_input,464,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3322); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3323); identifier();
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
		enterRule(_localctx, 386, RULE_schema_qualified_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3326); identifier();
			setState(3333);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(3327); match(DOT);
				setState(3328); identifier();
				setState(3331);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(3329); match(DOT);
					setState(3330); identifier();
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
		enterRule(_localctx, 388, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3335); match(SELECT);
			setState(3337);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(3336); set_qualifier();
				}
			}

			setState(3339); select_list();
			setState(3341);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(3340); table_expression();
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
		enterRule(_localctx, 390, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3343); select_sublist();
			setState(3348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3344); match(COMMA);
				setState(3345); select_sublist();
				}
				}
				setState(3350);
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
		enterRule(_localctx, 392, RULE_select_sublist);
		try {
			setState(3353);
			switch ( getInterpreter().adaptivePredict(_input,470,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3351); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3352); qualified_asterisk();
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
		enterRule(_localctx, 394, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3355); value_expression();
			setState(3357);
			switch ( getInterpreter().adaptivePredict(_input,471,_ctx) ) {
			case 1:
				{
				setState(3356); as_clause();
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
		enterRule(_localctx, 396, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3361);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(3359); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(3360); match(DOT);
				}
			}

			setState(3363); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 398, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3365);
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
		enterRule(_localctx, 400, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3370);
			switch ( getInterpreter().adaptivePredict(_input,473,_ctx) ) {
			case 1:
				{
				setState(3367); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(3368); match(DOT);
				}
				break;
			}
			setState(3372); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 402, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3375);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(3374); match(AS);
				}
			}

			setState(3377); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 404, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3379); column_reference();
			setState(3384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3380); match(COMMA);
				setState(3381); column_reference();
				}
				}
				setState(3386);
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
		enterRule(_localctx, 406, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3387); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 408, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3389); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 410, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3391); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 412, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3393); match(LEFT_PAREN);
			setState(3394); query_expression();
			setState(3395); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 414, RULE_predicate);
		try {
			setState(3403);
			switch ( getInterpreter().adaptivePredict(_input,476,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3397); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3398); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3399); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3400); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3401); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3402); exists_predicate();
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
		enterRule(_localctx, 416, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3405); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(3406); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(3407); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 418, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3409);
			_la = _input.LA(1);
			if ( !(((((_la - 308)) & ~0x3f) == 0 && ((1L << (_la - 308)) & ((1L << (EQUAL - 308)) | (1L << (NOT_EQUAL - 308)) | (1L << (LTH - 308)) | (1L << (LEQ - 308)) | (1L << (GTH - 308)) | (1L << (GEQ - 308)))) != 0)) ) {
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
		enterRule(_localctx, 420, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3411); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3412); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 422, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3415);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3414); match(NOT);
				}
			}

			setState(3417); match(BETWEEN);
			setState(3419);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(3418);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(3421); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(3422); match(AND);
			setState(3423); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 424, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3425); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(3427);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3426); match(NOT);
				}
			}

			setState(3429); match(IN);
			setState(3430); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 426, RULE_in_predicate_value);
		try {
			setState(3437);
			switch ( getInterpreter().adaptivePredict(_input,480,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3432); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3433); match(LEFT_PAREN);
				setState(3434); in_value_list();
				setState(3435); match(RIGHT_PAREN);
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
		enterRule(_localctx, 428, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3439); row_value_expression();
			setState(3444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3440); match(COMMA);
				setState(3441); row_value_expression();
				}
				}
				setState(3446);
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
		enterRule(_localctx, 430, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3447); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(3448); pattern_matcher();
			setState(3449); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 432, RULE_pattern_matcher);
		int _la;
		try {
			setState(3456);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3452);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3451); match(NOT);
					}
				}

				setState(3454); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(3455); regex_matcher();
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
		enterRule(_localctx, 434, RULE_negativable_matcher);
		try {
			setState(3464);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3458); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3459); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(3460); match(SIMILAR);
				setState(3461); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(3462); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(3463); match(RLIKE);
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
		enterRule(_localctx, 436, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3466);
			_la = _input.LA(1);
			if ( !(((((_la - 302)) & ~0x3f) == 0 && ((1L << (_la - 302)) & ((1L << (Similar_To - 302)) | (1L << (Not_Similar_To - 302)) | (1L << (Similar_To_Case_Insensitive - 302)) | (1L << (Not_Similar_To_Case_Insensitive - 302)))) != 0)) ) {
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
		enterRule(_localctx, 438, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3468); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3469); match(IS);
			setState(3471);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3470); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(3473); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 440, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3475); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(3476); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(3477); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(3478); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 442, RULE_quantifier);
		try {
			setState(3482);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3480); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3481); some();
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
		enterRule(_localctx, 444, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3484); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 446, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3486);
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
		enterRule(_localctx, 448, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3489);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3488); match(NOT);
				}
			}

			setState(3491); match(EXISTS);
			setState(3492); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 450, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3494); match(UNIQUE);
			setState(3495); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 452, RULE_primary_datetime_field);
		try {
			setState(3499);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3497); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(3498); match(SECOND);
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
		enterRule(_localctx, 454, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3501);
			_la = _input.LA(1);
			if ( !(((((_la - 157)) & ~0x3f) == 0 && ((1L << (_la - 157)) & ((1L << (DAY - 157)) | (1L << (HOUR - 157)) | (1L << (MINUTE - 157)) | (1L << (MONTH - 157)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 456, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3503);
			_la = _input.LA(1);
			if ( !(((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (CENTURY - 141)) | (1L << (DECADE - 141)) | (1L << (DOW - 141)) | (1L << (DOY - 141)) | (1L << (EPOCH - 141)) | (1L << (ISODOW - 141)) | (1L << (ISOYEAR - 141)) | (1L << (MICROSECONDS - 141)) | (1L << (MILLENNIUM - 141)) | (1L << (MILLISECONDS - 141)))) != 0) || _la==QUARTER || _la==WEEK) ) {
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
		enterRule(_localctx, 458, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3505); function_name();
			setState(3506); match(LEFT_PAREN);
			setState(3508);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (LEFT - 72)) | (1L << (NOT - 72)) | (1L << (NULL - 72)) | (1L << (RIGHT - 72)) | (1L << (SOME - 72)) | (1L << (TRUE - 72)) | (1L << (ADMIN - 72)) | (1L << (AVG - 72)))) != 0) || ((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (BETWEEN - 136)) | (1L << (BY - 136)) | (1L << (CACHE - 136)) | (1L << (CALLED - 136)) | (1L << (CLASS - 136)) | (1L << (CENTURY - 136)) | (1L << (CHARACTER - 136)) | (1L << (CHECK - 136)) | (1L << (COLLECT - 136)) | (1L << (COALESCE - 136)) | (1L << (COLUMN - 136)) | (1L << (COMMENT - 136)) | (1L << (COMMENTS - 136)) | (1L << (COMMIT - 136)) | (1L << (CONFIGURATION - 136)) | (1L << (COST - 136)) | (1L << (COUNT - 136)) | (1L << (CUBE - 136)) | (1L << (CURRENT - 136)) | (1L << (CYCLE - 136)) | (1L << (DATA - 136)) | (1L << (DAY - 136)) | (1L << (DEC - 136)) | (1L << (DECADE - 136)) | (1L << (DEFINER - 136)) | (1L << (DICTIONARY - 136)) | (1L << (DOW - 136)) | (1L << (DOY - 136)) | (1L << (DROP - 136)) | (1L << (EPOCH - 136)) | (1L << (EVERY - 136)) | (1L << (EXISTS - 136)) | (1L << (EXTERNAL - 136)) | (1L << (EXTRACT - 136)) | (1L << (FAMILY - 136)) | (1L << (FILTER - 136)) | (1L << (FIRST - 136)) | (1L << (FORMAT - 136)) | (1L << (FUSION - 136)) | (1L << (GROUPING - 136)) | (1L << (HASH - 136)) | (1L << (INDEX - 136)) | (1L << (INCREMENT - 136)) | (1L << (INPUT - 136)) | (1L << (INSERT - 136)) | (1L << (INTERSECTION - 136)) | (1L << (ISCACHABLE - 136)) | (1L << (ISODOW - 136)) | (1L << (ISOYEAR - 136)) | (1L << (ISSTRICT - 136)) | (1L << (LANGUAGE - 136)) | (1L << (LARGE - 136)) | (1L << (LAST - 136)) | (1L << (LESS - 136)) | (1L << (LIST - 136)) | (1L << (LOCATION - 136)) | (1L << (MATCH - 136)) | (1L << (MAX - 136)) | (1L << (MAXVALUE - 136)) | (1L << (MICROSECONDS - 136)) | (1L << (MILLENNIUM - 136)) | (1L << (MILLISECONDS - 136)))) != 0) || ((((_la - 200)) & ~0x3f) == 0 && ((1L << (_la - 200)) & ((1L << (MIN - 200)) | (1L << (MINVALUE - 200)) | (1L << (MINUTE - 200)) | (1L << (MONTH - 200)) | (1L << (NATIONAL - 200)) | (1L << (NO - 200)) | (1L << (NONE - 200)) | (1L << (NULLIF - 200)) | (1L << (OBJECT - 200)) | (1L << (ON - 200)) | (1L << (OPTION - 200)) | (1L << (OPTIONS - 200)) | (1L << (OVERWRITE - 200)) | (1L << (PARSER - 200)) | (1L << (PARTIAL - 200)) | (1L << (PARTITION - 200)) | (1L << (PARTITIONS - 200)) | (1L << (PRECISION - 200)) | (1L << (PUBLIC - 200)) | (1L << (PURGE - 200)) | (1L << (QUARTER - 200)) | (1L << (RANGE - 200)) | (1L << (REGEXP - 200)) | (1L << (RENAME - 200)) | (1L << (RESET - 200)) | (1L << (RLIKE - 200)) | (1L << (ROLLUP - 200)) | (1L << (SEARCH - 200)) | (1L << (SECOND - 200)) | (1L << (SECURITY - 200)) | (1L << (SERVER - 200)) | (1L << (SET - 200)) | (1L << (SIMILAR - 200)) | (1L << (SIMPLE - 200)) | (1L << (STABLE - 200)) | (1L << (START - 200)) | (1L << (STORAGE - 200)) | (1L << (STDDEV_POP - 200)) | (1L << (STDDEV_SAMP - 200)) | (1L << (SUBPARTITION - 200)) | (1L << (SUM - 200)) | (1L << (TABLESPACE - 200)) | (1L << (TEMPLATE - 200)) | (1L << (THAN - 200)) | (1L << (TIMEZONE - 200)) | (1L << (TIMEZONE_HOUR - 200)) | (1L << (TIMEZONE_MINUTE - 200)) | (1L << (TRIM - 200)) | (1L << (TO - 200)) | (1L << (TYPE - 200)) | (1L << (UNKNOWN - 200)) | (1L << (UNLOGGED - 200)) | (1L << (VALUES - 200)) | (1L << (VAR_SAMP - 200)) | (1L << (VAR_POP - 200)) | (1L << (VARYING - 200)) | (1L << (VOLATILE - 200)) | (1L << (WEEK - 200)) | (1L << (WINDOW - 200)) | (1L << (WRAPPER - 200)) | (1L << (YEAR - 200)) | (1L << (ZONE - 200)))) != 0) || ((((_la - 264)) & ~0x3f) == 0 && ((1L << (_la - 264)) & ((1L << (BOOLEAN - 264)) | (1L << (BOOL - 264)) | (1L << (BIT - 264)) | (1L << (VARBIT - 264)) | (1L << (INT1 - 264)) | (1L << (INT2 - 264)) | (1L << (INT4 - 264)) | (1L << (INT8 - 264)) | (1L << (TINYINT - 264)) | (1L << (SMALLINT - 264)) | (1L << (INT - 264)) | (1L << (INTEGER - 264)) | (1L << (BIGINT - 264)) | (1L << (FLOAT4 - 264)) | (1L << (FLOAT8 - 264)) | (1L << (REAL - 264)) | (1L << (FLOAT - 264)) | (1L << (DOUBLE - 264)) | (1L << (NUMERIC - 264)) | (1L << (DECIMAL - 264)) | (1L << (CHAR - 264)) | (1L << (VARCHAR - 264)) | (1L << (NCHAR - 264)) | (1L << (NVARCHAR - 264)) | (1L << (DATE - 264)) | (1L << (TIME - 264)) | (1L << (TIMETZ - 264)) | (1L << (TIMESTAMP - 264)) | (1L << (TIMESTAMPTZ - 264)) | (1L << (TEXT - 264)) | (1L << (UUID - 264)) | (1L << (VARBINARY - 264)) | (1L << (BLOB - 264)) | (1L << (BYTEA - 264)) | (1L << (INET4 - 264)) | (1L << (VOID - 264)) | (1L << (LEFT_PAREN - 264)) | (1L << (PLUS - 264)) | (1L << (MINUS - 264)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (DOUBLE_QUOTE - 329)) | (1L << (NUMBER - 329)) | (1L << (REAL_NUMBER - 329)) | (1L << (Identifier - 329)) | (1L << (QuotedIdentifier - 329)) | (1L << (Character_String_Literal - 329)))) != 0)) {
				{
				setState(3507); sql_argument_list();
				}
			}

			setState(3510); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 460, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3512);
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
		enterRule(_localctx, 462, RULE_function_name);
		try {
			setState(3516);
			switch (_input.LA(1)) {
			case ADMIN:
			case AVG:
			case BETWEEN:
			case BY:
			case CACHE:
			case CALLED:
			case CLASS:
			case CENTURY:
			case CHARACTER:
			case CHECK:
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
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXISTS:
			case EXTERNAL:
			case EXTRACT:
			case FAMILY:
			case FILTER:
			case FIRST:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
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
			case OPTION:
			case OPTIONS:
			case OVERWRITE:
			case PARSER:
			case PARTIAL:
			case PARTITION:
			case PARTITIONS:
			case PRECISION:
			case PUBLIC:
			case PURGE:
			case QUARTER:
			case RANGE:
			case REGEXP:
			case RENAME:
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
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
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
			case VOID:
			case DOUBLE_QUOTE:
			case Identifier:
			case QuotedIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(3514); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3515); function_names_for_reserved_words();
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
		enterRule(_localctx, 464, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3518); value_expression();
			setState(3523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3519); match(COMMA);
				setState(3520); value_expression();
				}
				}
				setState(3525);
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
		enterRule(_localctx, 466, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3526); match(ORDER);
			setState(3527); match(BY);
			setState(3528); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 468, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3530); sort_specifier();
			setState(3535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3531); match(COMMA);
				setState(3532); sort_specifier();
				}
				}
				setState(3537);
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
		enterRule(_localctx, 470, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3538); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(3540);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(3539); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(3543);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(3542); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 472, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3545);
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
		enterRule(_localctx, 474, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3547); match(LIMIT);
			setState(3548); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 476, RULE_null_ordering);
		try {
			setState(3554);
			switch ( getInterpreter().adaptivePredict(_input,495,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3550); match(NULL);
				setState(3551); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3552); match(NULL);
				setState(3553); match(LAST);
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
		enterRule(_localctx, 478, RULE_insert_statement);
		int _la;
		try {
			setState(3585);
			switch ( getInterpreter().adaptivePredict(_input,501,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3556); match(INSERT);
				setState(3558);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3557); match(OVERWRITE);
					}
				}

				setState(3560); match(INTO);
				setState(3561); schema_qualified_name();
				setState(3566);
				switch ( getInterpreter().adaptivePredict(_input,497,_ctx) ) {
				case 1:
					{
					setState(3562); match(LEFT_PAREN);
					setState(3563); column_name_list();
					setState(3564); match(RIGHT_PAREN);
					}
					break;
				}
				setState(3568); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3570); match(INSERT);
				setState(3572);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3571); match(OVERWRITE);
					}
				}

				setState(3574); match(INTO);
				setState(3575); match(LOCATION);
				setState(3576); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(3582);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(3577); match(USING);
					setState(3578); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(3580);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(3579); param_clause();
						}
					}

					}
				}

				setState(3584); query_expression();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u015a\u0e06\4\2\t"+
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
		"\t\u00f1\3\2\3\2\5\2\u01e5\n\2\7\2\u01e7\n\2\f\2\16\2\u01ea\13\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\5\6\u01f7\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0206\n\7\3\b\3\b\3\b\5\b\u020b"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\6\t\u0212\n\t\r\t\16\t\u0213\3\t\5\t\u0217\n"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0231\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0241\n\n\3\13\3\13\5\13\u0245\n\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u024f\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u0257\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u0267\n\f\3\f\3\f\3\f\5\f\u026c\n\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u027b\n\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u0286\n\f\3\r\3\r\5\r\u028a\n\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u0291\n\r\3\r\3\r\3\r\3\r\5\r\u0297\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u029e\n\16\3\16\3\16\5\16\u02a2\n\16\3\16\3\16\5\16\u02a6\n"+
		"\16\3\16\3\16\5\16\u02aa\n\16\3\16\3\16\5\16\u02ae\n\16\3\17\3\17\3\17"+
		"\5\17\u02b3\n\17\3\17\5\17\u02b6\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u02bd"+
		"\n\17\3\17\5\17\u02c0\n\17\3\17\5\17\u02c3\n\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\5\17\u02cb\n\17\3\17\3\17\5\17\u02cf\n\17\5\17\u02d1\n\17\3\20"+
		"\3\20\5\20\u02d5\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u02df"+
		"\n\20\3\20\5\20\u02e2\n\20\6\20\u02e4\n\20\r\20\16\20\u02e5\3\20\3\20"+
		"\5\20\u02ea\n\20\3\20\3\20\3\20\3\20\3\20\5\20\u02f1\n\20\3\20\5\20\u02f4"+
		"\n\20\6\20\u02f6\n\20\r\20\16\20\u02f7\5\20\u02fa\n\20\3\21\3\21\5\21"+
		"\u02fe\n\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0306\n\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\5\21\u030f\n\21\6\21\u0311\n\21\r\21\16\21\u0312"+
		"\5\21\u0315\n\21\5\21\u0317\n\21\3\21\3\21\3\21\3\21\5\21\u031d\n\21\3"+
		"\21\3\21\3\21\5\21\u0322\n\21\3\21\3\21\3\21\3\21\5\21\u0328\n\21\3\21"+
		"\3\21\5\21\u032c\n\21\3\21\3\21\5\21\u0330\n\21\3\21\3\21\5\21\u0334\n"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u033c\n\21\5\21\u033e\n\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\5\22\u0346\n\22\3\22\6\22\u0349\n\22\r\22\16"+
		"\22\u034a\3\22\3\22\5\22\u034f\n\22\5\22\u0351\n\22\3\22\3\22\5\22\u0355"+
		"\n\22\3\22\6\22\u0358\n\22\r\22\16\22\u0359\3\22\3\22\3\22\3\22\3\22\6"+
		"\22\u0361\n\22\r\22\16\22\u0362\5\22\u0365\n\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\5\22\u036d\n\22\3\22\3\22\3\22\3\22\5\22\u0373\n\22\6\22\u0375"+
		"\n\22\r\22\16\22\u0376\3\22\3\22\6\22\u037b\n\22\r\22\16\22\u037c\3\22"+
		"\3\22\5\22\u0381\n\22\3\22\3\22\3\22\5\22\u0386\n\22\6\22\u0388\n\22\r"+
		"\22\16\22\u0389\3\22\3\22\5\22\u038e\n\22\3\22\3\22\5\22\u0392\n\22\3"+
		"\22\3\22\5\22\u0396\n\22\6\22\u0398\n\22\r\22\16\22\u0399\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u03a2\n\22\3\22\6\22\u03a5\n\22\r\22\16\22\u03a6"+
		"\3\22\3\22\5\22\u03ab\n\22\5\22\u03ad\n\22\3\22\3\22\3\22\3\22\5\22\u03b3"+
		"\n\22\6\22\u03b5\n\22\r\22\16\22\u03b6\3\22\3\22\3\22\3\22\3\22\3\22\5"+
		"\22\u03bf\n\22\6\22\u03c1\n\22\r\22\16\22\u03c2\5\22\u03c5\n\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\5\22\u03cd\n\22\3\22\6\22\u03d0\n\22\r\22\16\22"+
		"\u03d1\3\22\3\22\5\22\u03d6\n\22\5\22\u03d8\n\22\3\22\3\22\3\22\3\22\5"+
		"\22\u03de\n\22\6\22\u03e0\n\22\r\22\16\22\u03e1\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\5\22\u03ea\n\22\3\22\3\22\3\22\5\22\u03ef\n\22\5\22\u03f1\n\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u03f9\n\22\6\22\u03fb\n\22\r\22\16"+
		"\22\u03fc\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0405\n\22\3\22\3\22\3\22"+
		"\5\22\u040a\n\22\5\22\u040c\n\22\3\22\3\22\3\22\3\22\3\22\5\22\u0413\n"+
		"\22\6\22\u0415\n\22\r\22\16\22\u0416\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u041f\n\22\3\22\3\22\3\22\5\22\u0424\n\22\5\22\u0426\n\22\3\22\3\22\3"+
		"\22\5\22\u042b\n\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0433\n\22\3\22"+
		"\3\22\3\22\5\22\u0438\n\22\5\22\u043a\n\22\3\22\3\22\3\22\3\22\5\22\u0440"+
		"\n\22\6\22\u0442\n\22\r\22\16\22\u0443\3\22\3\22\3\22\3\22\3\22\3\22\5"+
		"\22\u044c\n\22\3\22\3\22\3\22\5\22\u0451\n\22\6\22\u0453\n\22\r\22\16"+
		"\22\u0454\3\22\3\22\5\22\u0459\n\22\5\22\u045b\n\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u0462\n\22\6\22\u0464\n\22\r\22\16\22\u0465\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u046e\n\22\3\22\3\22\5\22\u0472\n\22\6\22\u0474\n"+
		"\22\r\22\16\22\u0475\3\22\3\22\5\22\u047a\n\22\5\22\u047c\n\22\3\22\3"+
		"\22\3\22\3\22\5\22\u0482\n\22\6\22\u0484\n\22\r\22\16\22\u0485\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\5\22\u048e\n\22\3\22\3\22\3\22\5\22\u0493\n\22"+
		"\5\22\u0495\n\22\3\22\3\22\3\22\3\22\5\22\u049b\n\22\6\22\u049d\n\22\r"+
		"\22\16\22\u049e\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u04a7\n\22\3\22\3\22"+
		"\5\22\u04ab\n\22\6\22\u04ad\n\22\r\22\16\22\u04ae\3\22\3\22\3\22\5\22"+
		"\u04b4\n\22\6\22\u04b6\n\22\r\22\16\22\u04b7\3\22\5\22\u04bb\n\22\5\22"+
		"\u04bd\n\22\3\23\3\23\5\23\u04c1\n\23\3\23\3\23\3\23\5\23\u04c6\n\23\6"+
		"\23\u04c8\n\23\r\23\16\23\u04c9\3\23\5\23\u04cd\n\23\3\24\3\24\6\24\u04d1"+
		"\n\24\r\24\16\24\u04d2\3\24\3\24\5\24\u04d7\n\24\5\24\u04d9\n\24\3\24"+
		"\3\24\5\24\u04dd\n\24\3\24\3\24\5\24\u04e1\n\24\6\24\u04e3\n\24\r\24\16"+
		"\24\u04e4\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u04ed\n\24\6\24\u04ef\n\24"+
		"\r\24\16\24\u04f0\5\24\u04f3\n\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u04fb"+
		"\n\24\6\24\u04fd\n\24\r\24\16\24\u04fe\6\24\u0501\n\24\r\24\16\24\u0502"+
		"\3\24\3\24\5\24\u0507\n\24\3\24\3\24\5\24\u050b\n\24\6\24\u050d\n\24\r"+
		"\24\16\24\u050e\5\24\u0511\n\24\3\24\3\24\5\24\u0515\n\24\3\24\3\24\5"+
		"\24\u0519\n\24\6\24\u051b\n\24\r\24\16\24\u051c\3\24\3\24\3\24\3\24\3"+
		"\24\5\24\u0524\n\24\6\24\u0526\n\24\r\24\16\24\u0527\3\24\3\24\5\24\u052c"+
		"\n\24\5\24\u052e\n\24\3\24\3\24\3\24\3\24\5\24\u0534\n\24\6\24\u0536\n"+
		"\24\r\24\16\24\u0537\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0540\n\24\6\24"+
		"\u0542\n\24\r\24\16\24\u0543\5\24\u0546\n\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u054d\n\24\6\24\u054f\n\24\r\24\16\24\u0550\3\24\3\24\5\24\u0555"+
		"\n\24\5\24\u0557\n\24\3\24\3\24\3\24\3\24\5\24\u055d\n\24\6\24\u055f\n"+
		"\24\r\24\16\24\u0560\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0569\n\24\5\24"+
		"\u056b\n\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0573\n\24\6\24\u0575\n"+
		"\24\r\24\16\24\u0576\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u057f\n\24\5\24"+
		"\u0581\n\24\3\24\3\24\3\24\3\24\3\24\5\24\u0588\n\24\6\24\u058a\n\24\r"+
		"\24\16\24\u058b\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0594\n\24\5\24\u0596"+
		"\n\24\3\24\3\24\3\24\5\24\u059b\n\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u05a3\n\24\5\24\u05a5\n\24\3\24\3\24\3\24\3\24\5\24\u05ab\n\24\6\24\u05ad"+
		"\n\24\r\24\16\24\u05ae\3\24\3\24\3\24\3\24\3\24\5\24\u05b6\n\24\6\24\u05b8"+
		"\n\24\r\24\16\24\u05b9\3\24\3\24\5\24\u05be\n\24\5\24\u05c0\n\24\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u05c7\n\24\6\24\u05c9\n\24\r\24\16\24\u05ca"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u05d2\n\24\6\24\u05d4\n\24\r\24\16\24\u05d5"+
		"\3\24\3\24\5\24\u05da\n\24\5\24\u05dc\n\24\3\24\3\24\3\24\3\24\5\24\u05e2"+
		"\n\24\6\24\u05e4\n\24\r\24\16\24\u05e5\3\24\3\24\3\24\3\24\3\24\3\24\5"+
		"\24\u05ee\n\24\5\24\u05f0\n\24\3\24\3\24\3\24\3\24\5\24\u05f6\n\24\6\24"+
		"\u05f8\n\24\r\24\16\24\u05f9\3\24\3\24\3\24\3\24\5\24\u0600\n\24\6\24"+
		"\u0602\n\24\r\24\16\24\u0603\3\24\3\24\3\24\5\24\u0609\n\24\6\24\u060b"+
		"\n\24\r\24\16\24\u060c\3\24\3\24\3\24\5\24\u0612\n\24\5\24\u0614\n\24"+
		"\3\25\3\25\5\25\u0618\n\25\3\25\3\25\5\25\u061c\n\25\3\25\5\25\u061f\n"+
		"\25\6\25\u0621\n\25\r\25\16\25\u0622\3\25\3\25\3\25\5\25\u0628\n\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0631\n\26\7\26\u0633\n\26\f\26"+
		"\16\26\u0636\13\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0674\n\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u06a2\n\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u06aa\n\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u06b7\n\27\6\27\u06b9"+
		"\n\27\r\27\16\27\u06ba\3\27\3\27\5\27\u06bf\n\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u06d2"+
		"\n\27\3\27\3\27\3\27\5\27\u06d7\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u06e7\n\27\3\27\3\27\7\27\u06eb"+
		"\n\27\f\27\16\27\u06ee\13\27\3\27\3\27\3\27\3\27\3\27\3\27\6\27\u06f6"+
		"\n\27\r\27\16\27\u06f7\3\27\3\27\3\27\3\27\5\27\u06fe\n\27\6\27\u0700"+
		"\n\27\r\27\16\27\u0701\3\27\3\27\5\27\u0706\n\27\3\30\3\30\5\30\u070a"+
		"\n\30\3\30\5\30\u070d\n\30\3\30\3\30\3\30\3\30\5\30\u0713\n\30\3\30\5"+
		"\30\u0716\n\30\7\30\u0718\n\30\f\30\16\30\u071b\13\30\3\30\3\30\3\31\3"+
		"\31\5\31\u0721\n\31\3\32\3\32\7\32\u0725\n\32\f\32\16\32\u0728\13\32\3"+
		"\32\3\32\3\33\3\33\7\33\u072e\n\33\f\33\16\33\u0731\13\33\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u073d\n\36\3\36\5\36\u0740"+
		"\n\36\3\36\3\36\5\36\u0744\n\36\3\36\5\36\u0747\n\36\7\36\u0749\n\36\f"+
		"\36\16\36\u074c\13\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0756"+
		"\n\37\6\37\u0758\n\37\r\37\16\37\u0759\3 \3 \5 \u075e\n \3 \3 \3 \3 \5"+
		" \u0764\n \3 \3 \3 \3 \3 \5 \u076b\n \3 \3 \3 \3 \5 \u0771\n \3 \3 \5"+
		" \u0775\n \3 \3 \3 \3 \5 \u077b\n \3 \3 \3 \3 \3 \5 \u0782\n \7 \u0784"+
		"\n \f \16 \u0787\13 \3!\3!\3!\3!\3!\5!\u078e\n!\3!\7!\u0791\n!\f!\16!"+
		"\u0794\13!\3!\3!\3!\3!\3!\7!\u079b\n!\f!\16!\u079e\13!\3!\3!\3!\3!\3!"+
		"\3!\3!\3!\5!\u07a8\n!\3!\3!\3!\3!\3!\3!\3!\5!\u07b1\n!\3\"\3\"\3\"\5\""+
		"\u07b6\n\"\3\"\5\"\u07b9\n\"\3\"\3\"\3\"\3\"\5\"\u07bf\n\"\7\"\u07c1\n"+
		"\"\f\"\16\"\u07c4\13\"\3\"\3\"\3\"\3\"\3\"\5\"\u07cb\n\"\6\"\u07cd\n\""+
		"\r\"\16\"\u07ce\3\"\3\"\5\"\u07d3\n\"\3\"\3\"\3\"\3#\3#\3$\3$\5$\u07dc"+
		"\n$\3$\3$\5$\u07e0\n$\3$\3$\3$\3$\5$\u07e6\n$\3$\3$\3$\3$\3$\3$\5$\u07ee"+
		"\n$\3$\7$\u07f1\n$\f$\16$\u07f4\13$\3$\3$\3$\3$\7$\u07fa\n$\f$\16$\u07fd"+
		"\13$\5$\u07ff\n$\3$\5$\u0802\n$\6$\u0804\n$\r$\16$\u0805\5$\u0808\n$\3"+
		"$\3$\3$\3$\3$\5$\u080f\n$\6$\u0811\n$\r$\16$\u0812\3$\3$\5$\u0817\n$\3"+
		"$\3$\3$\3$\3$\3$\5$\u081f\n$\3$\3$\5$\u0823\n$\3$\3$\3$\3$\5$\u0829\n"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\7$\u0833\n$\f$\16$\u0836\13$\3$\5$\u0839\n$"+
		"\3$\5$\u083c\n$\6$\u083e\n$\r$\16$\u083f\3$\3$\5$\u0844\n$\3$\3$\3$\3"+
		"$\5$\u084a\n$\3%\3%\3%\3&\3&\5&\u0851\n&\3&\3&\3&\3&\3&\5&\u0858\n&\6"+
		"&\u085a\n&\r&\16&\u085b\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0866\n&\6&\u0868\n"+
		"&\r&\16&\u0869\3&\3&\3&\3&\3&\3&\5&\u0872\n&\3&\3&\3&\3&\3&\5&\u0879\n"+
		"&\6&\u087b\n&\r&\16&\u087c\3&\3&\3&\3&\3&\3&\3&\5&\u0886\n&\3&\3&\3&\3"+
		"&\3&\5&\u088d\n&\6&\u088f\n&\r&\16&\u0890\3&\3&\3&\3&\3&\3&\5&\u0899\n"+
		"&\6&\u089b\n&\r&\16&\u089c\3&\3&\5&\u08a1\n&\3&\3&\3&\3&\3&\3&\5&\u08a9"+
		"\n&\3&\3&\3&\5&\u08ae\n&\3&\3&\3&\5&\u08b3\n&\5&\u08b5\n&\3&\3&\3&\5&"+
		"\u08ba\n&\3&\3&\3&\3&\5&\u08c0\n&\3\'\3\'\5\'\u08c4\n\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\5\'\u08cd\n\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\5\'\u08dd\n\'\3\'\3\'\3\'\5\'\u08e2\n\'\3\'\3\'\3\'\5\'"+
		"\u08e7\n\'\5\'\u08e9\n\'\3\'\3\'\3\'\5\'\u08ee\n\'\3\'\3\'\3\'\3\'\5\'"+
		"\u08f4\n\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\5)\u0900\n)\3)\5)\u0903\n)\6"+
		")\u0905\n)\r)\16)\u0906\3)\3)\3*\3*\3*\3*\3*\5*\u0910\n*\3+\3+\3+\3+\3"+
		"+\3+\3+\5+\u0919\n+\5+\u091b\n+\3,\3,\5,\u091f\n,\3-\3-\3-\3-\3-\3-\5"+
		"-\u0927\n-\3.\5.\u092a\n.\3.\3.\3.\3.\5.\u0930\n.\3/\3/\3/\3/\7/\u0936"+
		"\n/\f/\16/\u0939\13/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\62"+
		"\3\62\7\62\u0947\n\62\f\62\16\62\u094a\13\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\67\3\67\3\67\3\67\5\67"+
		"\u095e\n\67\38\38\38\38\38\38\38\38\38\38\39\39\39\79\u096d\n9\f9\169"+
		"\u0970\139\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\5:\u097c\n:\3:\3:\5:\u0980\n"+
		":\5:\u0982\n:\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\5;\u098f\n;\3<\3<\3<\7"+
		"<\u0994\n<\f<\16<\u0997\13<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?"+
		"\3?\3?\3@\3@\3@\7@\u09ac\n@\f@\16@\u09af\13@\3A\3A\3A\3A\5A\u09b5\nA\3"+
		"A\3A\3A\3A\3B\3B\3B\3B\3B\3C\3C\3D\3D\3D\3D\5D\u09c6\nD\3E\3E\3E\5E\u09cb"+
		"\nE\3E\3E\5E\u09cf\nE\5E\u09d1\nE\3F\3F\3G\3G\5G\u09d7\nG\3H\3H\3H\5H"+
		"\u09dc\nH\3I\3I\3I\5I\u09e1\nI\3J\3J\3J\3K\3K\3K\3L\3L\3L\3M\3M\3N\3N"+
		"\3N\5N\u09f1\nN\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\5O\u0a00\nO\3P"+
		"\3P\3Q\3Q\3R\3R\5R\u0a08\nR\3R\3R\5R\u0a0c\nR\3R\3R\3R\5R\u0a11\nR\3R"+
		"\3R\3R\5R\u0a16\nR\3R\3R\5R\u0a1a\nR\3R\5R\u0a1d\nR\3S\3S\3S\3S\3T\3T"+
		"\3T\5T\u0a26\nT\3T\3T\3T\5T\u0a2b\nT\3T\3T\5T\u0a2f\nT\3T\3T\3T\3T\5T"+
		"\u0a35\nT\3T\3T\3T\3T\5T\u0a3b\nT\3T\3T\3T\5T\u0a40\nT\3T\3T\5T\u0a44"+
		"\nT\5T\u0a46\nT\3U\3U\5U\u0a4a\nU\3U\3U\5U\u0a4e\nU\5U\u0a50\nU\3V\3V"+
		"\5V\u0a54\nV\3W\3W\5W\u0a58\nW\3W\3W\5W\u0a5c\nW\3W\3W\5W\u0a60\nW\3W"+
		"\3W\3W\3W\3W\3W\3W\3W\3W\5W\u0a6b\nW\3X\3X\5X\u0a6f\nX\3X\3X\3X\3X\3X"+
		"\3X\5X\u0a77\nX\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u0a81\nY\3Z\3Z\3[\3[\3[\3["+
		"\3[\3[\3[\3[\3[\3[\3[\3[\3[\3[\3[\3[\3[\5[\u0a96\n[\3\\\3\\\5\\\u0a9a"+
		"\n\\\3\\\3\\\5\\\u0a9e\n\\\3\\\3\\\3\\\5\\\u0aa3\n\\\5\\\u0aa5\n\\\3]"+
		"\3]\5]\u0aa9\n]\3]\3]\3]\5]\u0aae\n]\3]\3]\5]\u0ab2\n]\5]\u0ab4\n]\3^"+
		"\3^\5^\u0ab8\n^\3_\3_\3_\3_\3`\3`\3`\3`\3`\3`\3`\5`\u0ac5\n`\3a\3a\3b"+
		"\3b\3c\5c\u0acc\nc\3c\3c\3d\3d\3e\3e\3e\3e\3e\3e\5e\u0ad8\ne\5e\u0ada"+
		"\ne\3f\3f\3f\5f\u0adf\nf\3f\3f\3f\3g\3g\3h\3h\3h\3h\3h\3h\3i\3i\3i\3i"+
		"\3i\3j\3j\3k\3k\3k\3k\3k\3k\3k\3k\3k\3k\3k\3k\6k\u0aff\nk\rk\16k\u0b00"+
		"\3k\3k\5k\u0b05\nk\3l\3l\5l\u0b09\nl\3m\3m\3m\6m\u0b0e\nm\rm\16m\u0b0f"+
		"\3m\5m\u0b13\nm\3m\3m\3n\3n\6n\u0b19\nn\rn\16n\u0b1a\3n\5n\u0b1e\nn\3"+
		"n\3n\3o\3o\3o\3o\3o\3p\3p\3p\3p\3p\3q\3q\3q\3r\3r\5r\u0b31\nr\3s\3s\3"+
		"s\3s\3s\3s\3s\3t\3t\3u\3u\3v\3v\3v\5v\u0b41\nv\3w\3w\3w\5w\u0b46\nw\3"+
		"x\3x\3x\7x\u0b4b\nx\fx\16x\u0b4e\13x\3y\3y\3y\7y\u0b53\ny\fy\16y\u0b56"+
		"\13y\3z\5z\u0b59\nz\3z\3z\3{\3{\3{\3{\7{\u0b61\n{\f{\16{\u0b64\13{\3{"+
		"\3{\3|\3|\3|\7|\u0b6b\n|\f|\16|\u0b6e\13|\3|\5|\u0b71\n|\3}\3}\3~\3~\3"+
		"\177\3\177\3\177\3\177\3\177\3\177\3\177\3\u0080\3\u0080\3\u0080\5\u0080"+
		"\u0b81\n\u0080\3\u0081\3\u0081\3\u0082\3\u0082\5\u0082\u0b87\n\u0082\3"+
		"\u0083\3\u0083\3\u0084\3\u0084\3\u0084\7\u0084\u0b8e\n\u0084\f\u0084\16"+
		"\u0084\u0b91\13\u0084\3\u0085\3\u0085\3\u0086\3\u0086\5\u0086\u0b97\n"+
		"\u0086\3\u0087\3\u0087\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0089"+
		"\5\u0089\u0ba1\n\u0089\3\u0089\5\u0089\u0ba4\n\u0089\3\u0089\5\u0089\u0ba7"+
		"\n\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\5\u0089\u0bae\n\u0089"+
		"\3\u008a\3\u008a\3\u008b\3\u008b\3\u008c\3\u008c\3\u008c\7\u008c\u0bb7"+
		"\n\u008c\f\u008c\16\u008c\u0bba\13\u008c\3\u008d\3\u008d\3\u008d\7\u008d"+
		"\u0bbf\n\u008d\f\u008d\16\u008d\u0bc2\13\u008d\3\u008e\3\u008e\3\u008e"+
		"\5\u008e\u0bc7\n\u008e\3\u008f\3\u008f\5\u008f\u0bcb\n\u008f\3\u0090\3"+
		"\u0090\5\u0090\u0bcf\n\u0090\3\u0090\3\u0090\3\u0091\3\u0091\3\u0092\3"+
		"\u0092\5\u0092\u0bd7\n\u0092\3\u0093\3\u0093\5\u0093\u0bdb\n\u0093\3\u0094"+
		"\3\u0094\3\u0094\3\u0094\3\u0095\3\u0095\5\u0095\u0be3\n\u0095\3\u0096"+
		"\3\u0096\3\u0097\3\u0097\3\u0098\3\u0098\5\u0098\u0beb\n\u0098\3\u0099"+
		"\3\u0099\5\u0099\u0bef\n\u0099\3\u009a\3\u009a\5\u009a\u0bf3\n\u009a\3"+
		"\u009a\5\u009a\u0bf6\n\u009a\3\u009a\5\u009a\u0bf9\n\u009a\3\u009a\5\u009a"+
		"\u0bfc\n\u009a\3\u009a\5\u009a\u0bff\n\u009a\3\u009b\3\u009b\3\u009b\3"+
		"\u009c\3\u009c\3\u009c\7\u009c\u0c07\n\u009c\f\u009c\16\u009c\u0c0a\13"+
		"\u009c\3\u009d\3\u009d\5\u009d\u0c0e\n\u009d\3\u009e\3\u009e\6\u009e\u0c12"+
		"\n\u009e\r\u009e\16\u009e\u0c13\3\u009f\3\u009f\3\u009f\3\u009f\5\u009f"+
		"\u0c1a\n\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\5\u009f"+
		"\u0c22\n\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\5\u009f\u0c29\n"+
		"\u009f\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a1\5\u00a1\u0c30\n\u00a1\3"+
		"\u00a1\3\u00a1\3\u00a1\3\u00a1\3\u00a2\3\u00a2\5\u00a2\u0c38\n\u00a2\3"+
		"\u00a2\3\u00a2\3\u00a2\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a4\3\u00a4"+
		"\5\u00a4\u0c43\n\u00a4\3\u00a5\3\u00a5\5\u00a5\u0c47\n\u00a5\3\u00a6\3"+
		"\u00a6\3\u00a7\3\u00a7\5\u00a7\u0c4d\n\u00a7\3\u00a8\3\u00a8\3\u00a8\3"+
		"\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00aa\3\u00aa\5\u00aa\u0c59\n"+
		"\u00aa\3\u00aa\5\u00aa\u0c5c\n\u00aa\3\u00aa\3\u00aa\3\u00aa\3\u00aa\5"+
		"\u00aa\u0c62\n\u00aa\3\u00aa\3\u00aa\5\u00aa\u0c66\n\u00aa\3\u00aa\3\u00aa"+
		"\3\u00aa\3\u00aa\3\u00aa\5\u00aa\u0c6d\n\u00aa\5\u00aa\u0c6f\n\u00aa\3"+
		"\u00ab\3\u00ab\3\u00ab\7\u00ab\u0c74\n\u00ab\f\u00ab\16\u00ab\u0c77\13"+
		"\u00ab\3\u00ac\3\u00ac\3\u00ad\3\u00ad\3\u00ad\3\u00ae\3\u00ae\3\u00af"+
		"\3\u00af\3\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b0\7\u00b0\u0c87\n\u00b0"+
		"\f\u00b0\16\u00b0\u0c8a\13\u00b0\3\u00b1\3\u00b1\3\u00b1\3\u00b1\5\u00b1"+
		"\u0c90\n\u00b1\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\5\u00b2\u0c97\n"+
		"\u00b2\3\u00b3\3\u00b3\3\u00b3\7\u00b3\u0c9c\n\u00b3\f\u00b3\16\u00b3"+
		"\u0c9f\13\u00b3\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b5\3\u00b5"+
		"\3\u00b5\3\u00b5\3\u00b5\3\u00b6\3\u00b6\3\u00b6\3\u00b7\3\u00b7\3\u00b7"+
		"\3\u00b8\3\u00b8\3\u00b8\7\u00b8\u0cb4\n\u00b8\f\u00b8\16\u00b8\u0cb7"+
		"\13\u00b8\3\u00b9\3\u00b9\3\u00ba\3\u00ba\5\u00ba\u0cbd\n\u00ba\3\u00bb"+
		"\3\u00bb\3\u00bb\3\u00bb\5\u00bb\u0cc3\n\u00bb\3\u00bb\3\u00bb\5\u00bb"+
		"\u0cc7\n\u00bb\3\u00bb\3\u00bb\5\u00bb\u0ccb\n\u00bb\3\u00bb\7\u00bb\u0cce"+
		"\n\u00bb\f\u00bb\16\u00bb\u0cd1\13\u00bb\3\u00bc\3\u00bc\5\u00bc\u0cd5"+
		"\n\u00bc\3\u00bd\3\u00bd\3\u00bd\3\u00bd\5\u00bd\u0cdb\n\u00bd\3\u00bd"+
		"\3\u00bd\5\u00bd\u0cdf\n\u00bd\3\u00bd\3\u00bd\5\u00bd\u0ce3\n\u00bd\3"+
		"\u00bd\7\u00bd\u0ce6\n\u00bd\f\u00bd\16\u00bd\u0ce9\13\u00bd\3\u00be\3"+
		"\u00be\5\u00be\u0ced\n\u00be\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf\5"+
		"\u00bf\u0cf4\n\u00bf\3\u00c0\3\u00c0\5\u00c0\u0cf8\n\u00c0\3\u00c1\3\u00c1"+
		"\3\u00c1\3\u00c2\3\u00c2\5\u00c2\u0cff\n\u00c2\3\u00c3\3\u00c3\3\u00c3"+
		"\3\u00c3\3\u00c3\5\u00c3\u0d06\n\u00c3\5\u00c3\u0d08\n\u00c3\3\u00c4\3"+
		"\u00c4\5\u00c4\u0d0c\n\u00c4\3\u00c4\3\u00c4\5\u00c4\u0d10\n\u00c4\3\u00c5"+
		"\3\u00c5\3\u00c5\7\u00c5\u0d15\n\u00c5\f\u00c5\16\u00c5\u0d18\13\u00c5"+
		"\3\u00c6\3\u00c6\5\u00c6\u0d1c\n\u00c6\3\u00c7\3\u00c7\5\u00c7\u0d20\n"+
		"\u00c7\3\u00c8\3\u00c8\5\u00c8\u0d24\n\u00c8\3\u00c8\3\u00c8\3\u00c9\3"+
		"\u00c9\3\u00ca\3\u00ca\3\u00ca\5\u00ca\u0d2d\n\u00ca\3\u00ca\3\u00ca\3"+
		"\u00cb\5\u00cb\u0d32\n\u00cb\3\u00cb\3\u00cb\3\u00cc\3\u00cc\3\u00cc\7"+
		"\u00cc\u0d39\n\u00cc\f\u00cc\16\u00cc\u0d3c\13\u00cc\3\u00cd\3\u00cd\3"+
		"\u00ce\3\u00ce\3\u00cf\3\u00cf\3\u00d0\3\u00d0\3\u00d0\3\u00d0\3\u00d1"+
		"\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d1\5\u00d1\u0d4e\n\u00d1\3\u00d2"+
		"\3\u00d2\3\u00d2\3\u00d2\3\u00d3\3\u00d3\3\u00d4\3\u00d4\3\u00d4\3\u00d5"+
		"\5\u00d5\u0d5a\n\u00d5\3\u00d5\3\u00d5\5\u00d5\u0d5e\n\u00d5\3\u00d5\3"+
		"\u00d5\3\u00d5\3\u00d5\3\u00d6\3\u00d6\5\u00d6\u0d66\n\u00d6\3\u00d6\3"+
		"\u00d6\3\u00d6\3\u00d7\3\u00d7\3\u00d7\3\u00d7\3\u00d7\5\u00d7\u0d70\n"+
		"\u00d7\3\u00d8\3\u00d8\3\u00d8\7\u00d8\u0d75\n\u00d8\f\u00d8\16\u00d8"+
		"\u0d78\13\u00d8\3\u00d9\3\u00d9\3\u00d9\3\u00d9\3\u00da\5\u00da\u0d7f"+
		"\n\u00da\3\u00da\3\u00da\5\u00da\u0d83\n\u00da\3\u00db\3\u00db\3\u00db"+
		"\3\u00db\3\u00db\3\u00db\5\u00db\u0d8b\n\u00db\3\u00dc\3\u00dc\3\u00dd"+
		"\3\u00dd\3\u00dd\5\u00dd\u0d92\n\u00dd\3\u00dd\3\u00dd\3\u00de\3\u00de"+
		"\3\u00de\3\u00de\3\u00de\3\u00df\3\u00df\5\u00df\u0d9d\n\u00df\3\u00e0"+
		"\3\u00e0\3\u00e1\3\u00e1\3\u00e2\5\u00e2\u0da4\n\u00e2\3\u00e2\3\u00e2"+
		"\3\u00e2\3\u00e3\3\u00e3\3\u00e3\3\u00e4\3\u00e4\5\u00e4\u0dae\n\u00e4"+
		"\3\u00e5\3\u00e5\3\u00e6\3\u00e6\3\u00e7\3\u00e7\3\u00e7\5\u00e7\u0db7"+
		"\n\u00e7\3\u00e7\3\u00e7\3\u00e8\3\u00e8\3\u00e9\3\u00e9\5\u00e9\u0dbf"+
		"\n\u00e9\3\u00ea\3\u00ea\3\u00ea\7\u00ea\u0dc4\n\u00ea\f\u00ea\16\u00ea"+
		"\u0dc7\13\u00ea\3\u00eb\3\u00eb\3\u00eb\3\u00eb\3\u00ec\3\u00ec\3\u00ec"+
		"\7\u00ec\u0dd0\n\u00ec\f\u00ec\16\u00ec\u0dd3\13\u00ec\3\u00ed\3\u00ed"+
		"\5\u00ed\u0dd7\n\u00ed\3\u00ed\5\u00ed\u0dda\n\u00ed\3\u00ee\3\u00ee\3"+
		"\u00ef\3\u00ef\3\u00ef\3\u00f0\3\u00f0\3\u00f0\3\u00f0\5\u00f0\u0de5\n"+
		"\u00f0\3\u00f1\3\u00f1\5\u00f1\u0de9\n\u00f1\3\u00f1\3\u00f1\3\u00f1\3"+
		"\u00f1\3\u00f1\3\u00f1\5\u00f1\u0df1\n\u00f1\3\u00f1\3\u00f1\3\u00f1\3"+
		"\u00f1\5\u00f1\u0df7\n\u00f1\3\u00f1\3\u00f1\3\u00f1\3\u00f1\3\u00f1\3"+
		"\u00f1\5\u00f1\u0dff\n\u00f1\5\u00f1\u0e01\n\u00f1\3\u00f1\5\u00f1\u0e04"+
		"\n\u00f1\3\u00f1\2\2\u00f2\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c"+
		"\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4"+
		"\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc"+
		"\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4"+
		"\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc"+
		"\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114"+
		"\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c"+
		"\u012e\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144"+
		"\u0146\u0148\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c"+
		"\u015e\u0160\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170\u0172\u0174"+
		"\u0176\u0178\u017a\u017c\u017e\u0180\u0182\u0184\u0186\u0188\u018a\u018c"+
		"\u018e\u0190\u0192\u0194\u0196\u0198\u019a\u019c\u019e\u01a0\u01a2\u01a4"+
		"\u01a6\u01a8\u01aa\u01ac\u01ae\u01b0\u01b2\u01b4\u01b6\u01b8\u01ba\u01bc"+
		"\u01be\u01c0\u01c2\u01c4\u01c6\u01c8\u01ca\u01cc\u01ce\u01d0\u01d2\u01d4"+
		"\u01d6\u01d8\u01da\u01dc\u01de\u01e0\2\'\4\2MMmm\4\2\u00fb\u00fb\u0136"+
		"\u0136\t\2\37\37bbllyy{{~~\u00b8\u00b8\6\2bbll~~\u00b8\u00b8\4\2ll~\177"+
		"\5\2\24\24\30\30tu\4\2\30\30\177\177\4\2\20\20dd\4\2ll~~\3\2\u014d\u014d"+
		"\3\2\u014e\u014e\4\2\u00ba\u00ba\u00bd\u00bd\6\2;;CCTT\u0082\u0082\3\2"+
		"tu\4\2\62\62MM\4\2((<<\b\2\6\6\26\26\34\34\u0096\u0096\u00b5\u00b5\u00ee"+
		"\u00ee\t\2\u0088\u00b2\u00b4\u00b4\u00b6\u00f3\u00f5\u0102\u0104\u0119"+
		"\u011b\u0129\u012b\u012f\5\2++zz\u00fd\u00fd\3\2\u010a\u010b\3\2\u014f"+
		"\u0150\17\2\t\too\u0089\u0089\u0092\u0092\u009a\u009a\u00a8\u00a8\u00b0"+
		"\u00b0\u00b9\u00b9\u00c5\u00c5\u00ca\u00ca\u00ef\u00f0\u00f2\u00f2\u0100"+
		"\u0101\3\2\u0142\u0143\3\2\u0144\u0146\3\2\u00f7\u00f9\5\2\16\16IIww\5"+
		"\2..JJgg\4\2&&||\4\2\6\6!!\4\2\u0136\u0136\u013b\u013f\4\2\n\nrr\3\2\u0130"+
		"\u0133\4\2\t\too\6\2\u009f\u009f\u00b3\u00b3\u00cc\u00cd\u0108\u0108\n"+
		"\2\u008f\u008f\u00a1\u00a1\u00a4\u00a5\u00a7\u00a7\u00bb\u00bc\u00c7\u00c9"+
		"\u00de\u00de\u0105\u0105\4\2JJgg\4\2\13\13  \u0fc9\2\u01e8\3\2\2\2\4\u01ed"+
		"\3\2\2\2\6\u01ef\3\2\2\2\b\u01f1\3\2\2\2\n\u01f6\3\2\2\2\f\u0205\3\2\2"+
		"\2\16\u020a\3\2\2\2\20\u0230\3\2\2\2\22\u0240\3\2\2\2\24\u0256\3\2\2\2"+
		"\26\u0285\3\2\2\2\30\u0287\3\2\2\2\32\u0298\3\2\2\2\34\u02d0\3\2\2\2\36"+
		"\u02f9\3\2\2\2 \u02fb\3\2\2\2\"\u04bc\3\2\2\2$\u04be\3\2\2\2&\u0613\3"+
		"\2\2\2(\u0615\3\2\2\2*\u0629\3\2\2\2,\u06a6\3\2\2\2.\u0707\3\2\2\2\60"+
		"\u0720\3\2\2\2\62\u0722\3\2\2\2\64\u072b\3\2\2\2\66\u0734\3\2\2\28\u0736"+
		"\3\2\2\2:\u0738\3\2\2\2<\u074f\3\2\2\2>\u075b\3\2\2\2@\u07b0\3\2\2\2B"+
		"\u07b2\3\2\2\2D\u07d7\3\2\2\2F\u0849\3\2\2\2H\u084b\3\2\2\2J\u0850\3\2"+
		"\2\2L\u08c3\3\2\2\2N\u08f5\3\2\2\2P\u08fa\3\2\2\2R\u090f\3\2\2\2T\u091a"+
		"\3\2\2\2V\u091e\3\2\2\2X\u0926\3\2\2\2Z\u0929\3\2\2\2\\\u0931\3\2\2\2"+
		"^\u093c\3\2\2\2`\u093f\3\2\2\2b\u0941\3\2\2\2d\u094d\3\2\2\2f\u0951\3"+
		"\2\2\2h\u0954\3\2\2\2j\u0957\3\2\2\2l\u095d\3\2\2\2n\u095f\3\2\2\2p\u0969"+
		"\3\2\2\2r\u0971\3\2\2\2t\u0983\3\2\2\2v\u0990\3\2\2\2x\u0998\3\2\2\2z"+
		"\u099b\3\2\2\2|\u099e\3\2\2\2~\u09a8\3\2\2\2\u0080\u09b0\3\2\2\2\u0082"+
		"\u09ba\3\2\2\2\u0084\u09bf\3\2\2\2\u0086\u09c1\3\2\2\2\u0088\u09d0\3\2"+
		"\2\2\u008a\u09d2\3\2\2\2\u008c\u09d6\3\2\2\2\u008e\u09db\3\2\2\2\u0090"+
		"\u09e0\3\2\2\2\u0092\u09e2\3\2\2\2\u0094\u09e5\3\2\2\2\u0096\u09e8\3\2"+
		"\2\2\u0098\u09eb\3\2\2\2\u009a\u09f0\3\2\2\2\u009c\u09ff\3\2\2\2\u009e"+
		"\u0a01\3\2\2\2\u00a0\u0a03\3\2\2\2\u00a2\u0a1c\3\2\2\2\u00a4\u0a1e\3\2"+
		"\2\2\u00a6\u0a45\3\2\2\2\u00a8\u0a4f\3\2\2\2\u00aa\u0a53\3\2\2\2\u00ac"+
		"\u0a6a\3\2\2\2\u00ae\u0a76\3\2\2\2\u00b0\u0a80\3\2\2\2\u00b2\u0a82\3\2"+
		"\2\2\u00b4\u0a95\3\2\2\2\u00b6\u0aa4\3\2\2\2\u00b8\u0ab3\3\2\2\2\u00ba"+
		"\u0ab7\3\2\2\2\u00bc\u0ab9\3\2\2\2\u00be\u0ac4\3\2\2\2\u00c0\u0ac6\3\2"+
		"\2\2\u00c2\u0ac8\3\2\2\2\u00c4\u0acb\3\2\2\2\u00c6\u0acf\3\2\2\2\u00c8"+
		"\u0ad9\3\2\2\2\u00ca\u0adb\3\2\2\2\u00cc\u0ae3\3\2\2\2\u00ce\u0ae5\3\2"+
		"\2\2\u00d0\u0aeb\3\2\2\2\u00d2\u0af0\3\2\2\2\u00d4\u0b04\3\2\2\2\u00d6"+
		"\u0b08\3\2\2\2\u00d8\u0b0a\3\2\2\2\u00da\u0b16\3\2\2\2\u00dc\u0b21\3\2"+
		"\2\2\u00de\u0b26\3\2\2\2\u00e0\u0b2b\3\2\2\2\u00e2\u0b30\3\2\2\2\u00e4"+
		"\u0b32\3\2\2\2\u00e6\u0b39\3\2\2\2\u00e8\u0b3b\3\2\2\2\u00ea\u0b40\3\2"+
		"\2\2\u00ec\u0b45\3\2\2\2\u00ee\u0b47\3\2\2\2\u00f0\u0b4f\3\2\2\2\u00f2"+
		"\u0b58\3\2\2\2\u00f4\u0b5c\3\2\2\2\u00f6\u0b70\3\2\2\2\u00f8\u0b72\3\2"+
		"\2\2\u00fa\u0b74\3\2\2\2\u00fc\u0b76\3\2\2\2\u00fe\u0b80\3\2\2\2\u0100"+
		"\u0b82\3\2\2\2\u0102\u0b86\3\2\2\2\u0104\u0b88\3\2\2\2\u0106\u0b8a\3\2"+
		"\2\2\u0108\u0b92\3\2\2\2\u010a\u0b96\3\2\2\2\u010c\u0b98\3\2\2\2\u010e"+
		"\u0b9a\3\2\2\2\u0110\u0bad\3\2\2\2\u0112\u0baf\3\2\2\2\u0114\u0bb1\3\2"+
		"\2\2\u0116\u0bb3\3\2\2\2\u0118\u0bbb\3\2\2\2\u011a\u0bc6\3\2\2\2\u011c"+
		"\u0bc8\3\2\2\2\u011e\u0bcc\3\2\2\2\u0120\u0bd2\3\2\2\2\u0122\u0bd6\3\2"+
		"\2\2\u0124\u0bda\3\2\2\2\u0126\u0bdc\3\2\2\2\u0128\u0be2\3\2\2\2\u012a"+
		"\u0be4\3\2\2\2\u012c\u0be6\3\2\2\2\u012e\u0bea\3\2\2\2\u0130\u0bee\3\2"+
		"\2\2\u0132\u0bf0\3\2\2\2\u0134\u0c00\3\2\2\2\u0136\u0c03\3\2\2\2\u0138"+
		"\u0c0d\3\2\2\2\u013a\u0c0f\3\2\2\2\u013c\u0c28\3\2\2\2\u013e\u0c2a\3\2"+
		"\2\2\u0140\u0c2f\3\2\2\2\u0142\u0c35\3\2\2\2\u0144\u0c3c\3\2\2\2\u0146"+
		"\u0c42\3\2\2\2\u0148\u0c44\3\2\2\2\u014a\u0c48\3\2\2\2\u014c\u0c4c\3\2"+
		"\2\2\u014e\u0c4e\3\2\2\2\u0150\u0c51\3\2\2\2\u0152\u0c6e\3\2\2\2\u0154"+
		"\u0c70\3\2\2\2\u0156\u0c78\3\2\2\2\u0158\u0c7a\3\2\2\2\u015a\u0c7d\3\2"+
		"\2\2\u015c\u0c7f\3\2\2\2\u015e\u0c83\3\2\2\2\u0160\u0c8f\3\2\2\2\u0162"+
		"\u0c96\3\2\2\2\u0164\u0c98\3\2\2\2\u0166\u0ca0\3\2\2\2\u0168\u0ca5\3\2"+
		"\2\2\u016a\u0caa\3\2\2\2\u016c\u0cad\3\2\2\2\u016e\u0cb0\3\2\2\2\u0170"+
		"\u0cb8\3\2\2\2\u0172\u0cbc\3\2\2\2\u0174\u0cc6\3\2\2\2\u0176\u0cd4\3\2"+
		"\2\2\u0178\u0cde\3\2\2\2\u017a\u0cec\3\2\2\2\u017c\u0cf3\3\2\2\2\u017e"+
		"\u0cf7\3\2\2\2\u0180\u0cf9\3\2\2\2\u0182\u0cfe\3\2\2\2\u0184\u0d00\3\2"+
		"\2\2\u0186\u0d09\3\2\2\2\u0188\u0d11\3\2\2\2\u018a\u0d1b\3\2\2\2\u018c"+
		"\u0d1d\3\2\2\2\u018e\u0d23\3\2\2\2\u0190\u0d27\3\2\2\2\u0192\u0d2c\3\2"+
		"\2\2\u0194\u0d31\3\2\2\2\u0196\u0d35\3\2\2\2\u0198\u0d3d\3\2\2\2\u019a"+
		"\u0d3f\3\2\2\2\u019c\u0d41\3\2\2\2\u019e\u0d43\3\2\2\2\u01a0\u0d4d\3\2"+
		"\2\2\u01a2\u0d4f\3\2\2\2\u01a4\u0d53\3\2\2\2\u01a6\u0d55\3\2\2\2\u01a8"+
		"\u0d59\3\2\2\2\u01aa\u0d63\3\2\2\2\u01ac\u0d6f\3\2\2\2\u01ae\u0d71\3\2"+
		"\2\2\u01b0\u0d79\3\2\2\2\u01b2\u0d82\3\2\2\2\u01b4\u0d8a\3\2\2\2\u01b6"+
		"\u0d8c\3\2\2\2\u01b8\u0d8e\3\2\2\2\u01ba\u0d95\3\2\2\2\u01bc\u0d9c\3\2"+
		"\2\2\u01be\u0d9e\3\2\2\2\u01c0\u0da0\3\2\2\2\u01c2\u0da3\3\2\2\2\u01c4"+
		"\u0da8\3\2\2\2\u01c6\u0dad\3\2\2\2\u01c8\u0daf\3\2\2\2\u01ca\u0db1\3\2"+
		"\2\2\u01cc\u0db3\3\2\2\2\u01ce\u0dba\3\2\2\2\u01d0\u0dbe\3\2\2\2\u01d2"+
		"\u0dc0\3\2\2\2\u01d4\u0dc8\3\2\2\2\u01d6\u0dcc\3\2\2\2\u01d8\u0dd4\3\2"+
		"\2\2\u01da\u0ddb\3\2\2\2\u01dc\u0ddd\3\2\2\2\u01de\u0de4\3\2\2\2\u01e0"+
		"\u0e03\3\2\2\2\u01e2\u01e4\5\4\3\2\u01e3\u01e5\7\u0138\2\2\u01e4\u01e3"+
		"\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e7\3\2\2\2\u01e6\u01e2\3\2\2\2\u01e7"+
		"\u01ea\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb\3\2"+
		"\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ec\7\2\2\3\u01ec\3\3\2\2\2\u01ed\u01ee"+
		"\5\n\6\2\u01ee\5\3\2\2\2\u01ef\u01f0\5\u0170\u00b9\2\u01f0\7\3\2\2\2\u01f1"+
		"\u01f2\5\u01e0\u00f1\2\u01f2\t\3\2\2\2\u01f3\u01f7\5\f\7\2\u01f4\u01f7"+
		"\5\16\b\2\u01f5\u01f7\5\u0086D\2\u01f6\u01f3\3\2\2\2\u01f6\u01f4\3\2\2"+
		"\2\u01f6\u01f5\3\2\2\2\u01f7\13\3\2\2\2\u01f8\u0206\5F$\2\u01f9\u0206"+
		"\5\30\r\2\u01fa\u0206\5\32\16\2\u01fb\u0206\5 \21\2\u01fc\u0206\5,\27"+
		"\2\u01fd\u0206\5> \2\u01fe\u0206\5@!\2\u01ff\u0206\5B\"\2\u0200\u0206"+
		"\5*\26\2\u0201\u0206\5\"\22\2\u0202\u0206\5\36\20\2\u0203\u0206\5&\24"+
		"\2\u0204\u0206\5\34\17\2\u0205\u01f8\3\2\2\2\u0205\u01f9\3\2\2\2\u0205"+
		"\u01fa\3\2\2\2\u0205\u01fb\3\2\2\2\u0205\u01fc\3\2\2\2\u0205\u01fd\3\2"+
		"\2\2\u0205\u01fe\3\2\2\2\u0205\u01ff\3\2\2\2\u0205\u0200\3\2\2\2\u0205"+
		"\u0201\3\2\2\2\u0205\u0202\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0204\3\2"+
		"\2\2\u0206\r\3\2\2\2\u0207\u020b\5\20\t\2\u0208\u020b\5\22\n\2\u0209\u020b"+
		"\5\24\13\2\u020a\u0207\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u0209\3\2\2\2"+
		"\u020b\17\3\2\2\2\u020c\u020d\7\7\2\2\u020d\u020e\7/\2\2\u020e\u020f\5"+
		"\u0184\u00c3\2\u020f\u0211\5.\30\2\u0210\u0212\5\26\f\2\u0211\u0210\3"+
		"\2\2\2\u0212\u0213\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214"+
		"\u0216\3\2\2\2\u0215\u0217\7d\2\2\u0216\u0215\3\2\2\2\u0216\u0217\3\2"+
		"\2\2\u0217\u0231\3\2\2\2\u0218\u0219\7\7\2\2\u0219\u021a\7/\2\2\u021a"+
		"\u021b\5\u0184\u00c3\2\u021b\u021c\5.\30\2\u021c\u021d\7\u00e1\2\2\u021d"+
		"\u021e\7\u00fb\2\2\u021e\u021f\5\u0184\u00c3\2\u021f\u0231\3\2\2\2\u0220"+
		"\u0221\7\7\2\2\u0221\u0222\7/\2\2\u0222\u0223\5\u0184\u00c3\2\u0223\u0224"+
		"\5.\30\2\u0224\u0225\7Y\2\2\u0225\u0226\7\u00fb\2\2\u0226\u0227\5\u0088"+
		"E\2\u0227\u0231\3\2\2\2\u0228\u0229\7\7\2\2\u0229\u022a\7/\2\2\u022a\u022b"+
		"\5\u0184\u00c3\2\u022b\u022c\5.\30\2\u022c\u022d\7\u00e9\2\2\u022d\u022e"+
		"\7i\2\2\u022e\u022f\5\u0184\u00c3\2\u022f\u0231\3\2\2\2\u0230\u020c\3"+
		"\2\2\2\u0230\u0218\3\2\2\2\u0230\u0220\3\2\2\2\u0230\u0228\3\2\2\2\u0231"+
		"\21\3\2\2\2\u0232\u0233\7\7\2\2\u0233\u0234\7i\2\2\u0234\u0235\5\u0088"+
		"E\2\u0235\u0236\7\u00e1\2\2\u0236\u0237\7\u00fb\2\2\u0237\u0238\5\u0088"+
		"E\2\u0238\u0241\3\2\2\2\u0239\u023a\7\7\2\2\u023a\u023b\7i\2\2\u023b\u023c"+
		"\5\u0088E\2\u023c\u023d\7Y\2\2\u023d\u023e\7\u00fb\2\2\u023e\u023f\5\u0088"+
		"E\2\u023f\u0241\3\2\2\2\u0240\u0232\3\2\2\2\u0240\u0239\3\2\2\2\u0241"+
		"\23\3\2\2\2\u0242\u0244\7\7\2\2\u0243\u0245\7^\2\2\u0244\u0243\3\2\2\2"+
		"\u0244\u0245\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0247\7\u00be\2\2\u0247"+
		"\u0248\5\u0088E\2\u0248\u0249\7\u00e1\2\2\u0249\u024a\7\u00fb\2\2\u024a"+
		"\u024b\5\u0088E\2\u024b\u0257\3\2\2\2\u024c\u024e\7\7\2\2\u024d\u024f"+
		"\7^\2\2\u024e\u024d\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0250\3\2\2\2\u0250"+
		"\u0251\7\u00be\2\2\u0251\u0252\5\u0088E\2\u0252\u0253\7Y\2\2\u0253\u0254"+
		"\7\u00fb\2\2\u0254\u0255\5\u0088E\2\u0255\u0257\3\2\2\2\u0256\u0242\3"+
		"\2\2\2\u0256\u024c\3\2\2\2\u0257\25\3\2\2\2\u0258\u0259\7\u008d\2\2\u0259"+
		"\u025a\7\u00d3\2\2\u025a\u025b\7P\2\2\u025b\u0286\7\u00b7\2\2\u025c\u025d"+
		"\7e\2\2\u025d\u025e\7P\2\2\u025e\u025f\7\u00d3\2\2\u025f\u0260\7P\2\2"+
		"\u0260\u0286\7\u00b7\2\2\u0261\u0262\7q\2\2\u0262\u0286\7:\2\2\u0263\u0286"+
		"\7\u00ec\2\2\u0264\u0266\7\u0104\2\2\u0265\u0267\7\u00aa\2\2\u0266\u0265"+
		"\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u0269\7\u00e7\2"+
		"\2\u0269\u0286\7E\2\2\u026a\u026c\7\u00aa\2\2\u026b\u026a\3\2\2\2\u026b"+
		"\u026c\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026e\7\u00e7\2\2\u026e\u026f"+
		"\7\u00a2\2\2\u026f\u0270\7\u0099\2\2\u0270\u0271\7\u014f\2\2\u0271\u0272"+
		"\7a\2\2\u0272\u0273\7\u014f\2\2\u0273\u0274\7\u00e9\2\2\u0274\u027a\5"+
		"\u0088E\2\u0275\u0276\7\u00fb\2\2\u0276\u027b\5\u0088E\2\u0277\u0278\7"+
		"\u0136\2\2\u0278\u027b\5\u0088E\2\u0279\u027b\7\33\2\2\u027a\u0275\3\2"+
		"\2\2\u027a\u0277\3\2\2\2\u027a\u0279\3\2\2\2\u027b\u027c\3\2\2\2\u027c"+
		"\u027d\7\u00e9\2\2\u027d\u027e\5\u0088E\2\u027e\u027f\7\61\2\2\u027f\u0280"+
		"\7\u009c\2\2\u0280\u0281\7\u00e2\2\2\u0281\u0282\5\u0088E\2\u0282\u0283"+
		"\7\u00e2\2\2\u0283\u0284\7\6\2\2\u0284\u0286\3\2\2\2\u0285\u0258\3\2\2"+
		"\2\u0285\u025c\3\2\2\2\u0285\u0261\3\2\2\2\u0285\u0263\3\2\2\2\u0285\u0264"+
		"\3\2\2\2\u0285\u026b\3\2\2\2\u0286\27\3\2\2\2\u0287\u0289\7\30\2\2\u0288"+
		"\u028a\7}\2\2\u0289\u0288\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028b\3\2"+
		"\2\2\u028b\u028c\7\u00b4\2\2\u028c\u028d\5\u0088E\2\u028d\u028e\7\u00d3"+
		"\2\2\u028e\u0290\5\u0184\u00c3\2\u028f\u0291\5f\64\2\u0290\u028f\3\2\2"+
		"\2\u0290\u0291\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\7\u0140\2\2\u0293"+
		"\u0294\5\u01d6\u00ec\2\u0294\u0296\7\u0141\2\2\u0295\u0297\5b\62\2\u0296"+
		"\u0295\3\2\2\2\u0296\u0297\3\2\2\2\u0297\31\3\2\2\2\u0298\u0299\7\30\2"+
		"\2\u0299\u029d\7*\2\2\u029a\u029b\7\67\2\2\u029b\u029c\7O\2\2\u029c\u029e"+
		"\7\u00a9\2\2\u029d\u029a\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u029f\3\2\2"+
		"\2\u029f\u02a1\5\u0088E\2\u02a0\u02a2\7\u0086\2\2\u02a1\u02a0\3\2\2\2"+
		"\u02a1\u02a2\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a4\7i\2\2\u02a4\u02a6"+
		"\5\u0088E\2\u02a5\u02a3\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02a9\3\2\2"+
		"\2\u02a7\u02a8\7\u0103\2\2\u02a8\u02aa\5\u0088E\2\u02a9\u02a7\3\2\2\2"+
		"\u02a9\u02aa\3\2\2\2\u02aa\u02ad\3\2\2\2\u02ab\u02ac\7\61\2\2\u02ac\u02ae"+
		"\5\u0088E\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\33\3\2\2\2\u02af"+
		"\u02b2\7\30\2\2\u02b0\u02b1\7V\2\2\u02b1\u02b3\7c\2\2\u02b2\u02b0\3\2"+
		"\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b5\3\2\2\2\u02b4\u02b6\7^\2\2\u02b5"+
		"\u02b4\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b8\7\u00be"+
		"\2\2\u02b8\u02d1\5\u0088E\2\u02b9\u02bc\7\30\2\2\u02ba\u02bb\7V\2\2\u02bb"+
		"\u02bd\7c\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02bf\3\2"+
		"\2\2\u02be\u02c0\7x\2\2\u02bf\u02be\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0"+
		"\u02c2\3\2\2\2\u02c1\u02c3\7^\2\2\u02c2\u02c1\3\2\2\2\u02c2\u02c3\3\2"+
		"\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02c5\7\u00be\2\2\u02c5\u02c6\5\u0088E"+
		"\2\u02c6\u02c7\7\66\2\2\u02c7\u02ca\5\u0184\u00c3\2\u02c8\u02c9\7?\2\2"+
		"\u02c9\u02cb\5\u0184\u00c3\2\u02ca\u02c8\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb"+
		"\u02ce\3\2\2\2\u02cc\u02cd\7\u0081\2\2\u02cd\u02cf\5\u0184\u00c3\2\u02ce"+
		"\u02cc\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02d1\3\2\2\2\u02d0\u02af\3\2"+
		"\2\2\u02d0\u02b9\3\2\2\2\u02d1\35\3\2\2\2\u02d2\u02d4\7\u00e9\2\2\u02d3"+
		"\u02d5\t\2\2\2\u02d4\u02d3\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d6\3\2"+
		"\2\2\u02d6\u02d7\5\u0088E\2\u02d7\u02e3\t\3\2\2\u02d8\u02df\5\u00eav\2"+
		"\u02d9\u02da\7\u014a\2\2\u02da\u02db\5\u00eav\2\u02db\u02dc\7\u014a\2"+
		"\2\u02dc\u02df\3\2\2\2\u02dd\u02df\7\33\2\2\u02de\u02d8\3\2\2\2\u02de"+
		"\u02d9\3\2\2\2\u02de\u02dd\3\2\2\2\u02df\u02e1\3\2\2\2\u02e0\u02e2\7\u0139"+
		"\2\2\u02e1\u02e0\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e4\3\2\2\2\u02e3"+
		"\u02de\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e5\u02e6\3\2"+
		"\2\2\u02e6\u02fa\3\2\2\2\u02e7\u02e9\7\u00e9\2\2\u02e8\u02ea\t\2\2\2\u02e9"+
		"\u02e8\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ec\7\u0124"+
		"\2\2\u02ec\u02f5\7\u0109\2\2\u02ed\u02f1\5\u0088E\2\u02ee\u02f1\7M\2\2"+
		"\u02ef\u02f1\7\33\2\2\u02f0\u02ed\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f0\u02ef"+
		"\3\2\2\2\u02f1\u02f3\3\2\2\2\u02f2\u02f4\7\u0139\2\2\u02f3\u02f2\3\2\2"+
		"\2\u02f3\u02f4\3\2\2\2\u02f4\u02f6\3\2\2\2\u02f5\u02f0\3\2\2\2\u02f6\u02f7"+
		"\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02fa\3\2\2\2\u02f9"+
		"\u02d2\3\2\2\2\u02f9\u02e7\3\2\2\2\u02fa\37\3\2\2\2\u02fb\u02fd\7\30\2"+
		"\2\u02fc\u02fe\7\25\2\2\u02fd\u02fc\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe"+
		"\u02ff\3\2\2\2\u02ff\u0300\7y\2\2\u0300\u0305\5\u0088E\2\u0301\u0306\7"+
		"\r\2\2\u0302\u0303\7D\2\2\u0303\u0306\7Q\2\2\u0304\u0306\7\4\2\2\u0305"+
		"\u0301\3\2\2\2\u0305\u0302\3\2\2\2\u0305\u0304\3\2\2\2\u0306\u0316\3\2"+
		"\2\2\u0307\u0317\7\u00b8\2\2\u0308\u0317\7\37\2\2\u0309\u0317\7{\2\2\u030a"+
		"\u0314\7~\2\2\u030b\u0310\7Q\2\2\u030c\u030e\5\u0088E\2\u030d\u030f\7"+
		"\u0139\2\2\u030e\u030d\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0311\3\2\2\2"+
		"\u0310\u030c\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0310\3\2\2\2\u0312\u0313"+
		"\3\2\2\2\u0313\u0315\3\2\2\2\u0314\u030b\3\2\2\2\u0314\u0315\3\2\2\2\u0315"+
		"\u0317\3\2\2\2\u0316\u0307\3\2\2\2\u0316\u0308\3\2\2\2\u0316\u0309\3\2"+
		"\2\2\u0316\u030a\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u0319\7\u00d3\2\2\u0319"+
		"\u031c\5\u0184\u00c3\2\u031a\u031b\7\61\2\2\u031b\u031d\5\u0184\u00c3"+
		"\2\u031c\u031a\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u0327\3\2\2\2\u031e\u031f"+
		"\7O\2\2\u031f\u0328\7\35\2\2\u0320\u0322\7\35\2\2\u0321\u0320\3\2\2\2"+
		"\u0321\u0322\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0324\7>\2\2\u0324\u0328"+
		"\79\2\2\u0325\u0326\7>\2\2\u0326\u0328\7\36\2\2\u0327\u031e\3\2\2\2\u0327"+
		"\u0321\3\2\2\2\u0327\u0325\3\2\2\2\u0327\u0328\3\2\2\2\u0328\u032f\3\2"+
		"\2\2\u0329\u032b\7,\2\2\u032a\u032c\7#\2\2\u032b\u032a\3\2\2\2\u032b\u032c"+
		"\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u0330\7`\2\2\u032e\u0330\7p\2\2\u032f"+
		"\u0329\3\2\2\2\u032f\u032e\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u0333\3\2"+
		"\2\2\u0331\u0332\7\u0084\2\2\u0332\u0334\5\u0114\u008b\2\u0333\u0331\3"+
		"\2\2\2\u0333\u0334\3\2\2\2\u0334\u0335\3\2\2\2\u0335\u0336\7)\2\2\u0336"+
		"\u0337\7]\2\2\u0337\u0338\5\u0088E\2\u0338\u033d\7\u0140\2\2\u0339\u033b"+
		"\5\u0088E\2\u033a\u033c\7\u0139\2\2\u033b\u033a\3\2\2\2\u033b\u033c\3"+
		"\2\2\2\u033c\u033e\3\2\2\2\u033d\u0339\3\2\2\2\u033d\u033e\3\2\2\2\u033e"+
		"\u033f\3\2\2\2\u033f\u0340\7\u0141\2\2\u0340!\3\2\2\2\u0341\u0345\7f\2"+
		"\2\u0342\u0343\7\63\2\2\u0343\u0344\7\u00d4\2\2\u0344\u0346\7,\2\2\u0345"+
		"\u0342\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u0350\3\2\2\2\u0347\u0349\t\4"+
		"\2\2\u0348\u0347\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u0348\3\2\2\2\u034a"+
		"\u034b\3\2\2\2\u034b\u0351\3\2\2\2\u034c\u034e\7\6\2\2\u034d\u034f\7\\"+
		"\2\2\u034e\u034d\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0351\3\2\2\2\u0350"+
		"\u0348\3\2\2\2\u0350\u034c\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0364\7\u00d3"+
		"\2\2\u0353\u0355\7s\2\2\u0354\u0353\3\2\2\2\u0354\u0355\3\2\2\2\u0355"+
		"\u0356\3\2\2\2\u0356\u0358\5\u0184\u00c3\2\u0357\u0354\3\2\2\2\u0358\u0359"+
		"\3\2\2\2\u0359\u0357\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u0365\3\2\2\2\u035b"+
		"\u035c\7\6\2\2\u035c\u035d\7\u00f4\2\2\u035d\u035e\7;\2\2\u035e\u0360"+
		"\7i\2\2\u035f\u0361\5\u0088E\2\u0360\u035f\3\2\2\2\u0361\u0362\3\2\2\2"+
		"\u0362\u0360\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0365\3\2\2\2\u0364\u0357"+
		"\3\2\2\2\u0364\u035b\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0367\5$\23\2\u0367"+
		"\u04bd\3\2\2\2\u0368\u036c\7f\2\2\u0369\u036a\7\63\2\2\u036a\u036b\7\u00d4"+
		"\2\2\u036b\u036d\7,\2\2\u036c\u0369\3\2\2\2\u036c\u036d\3\2\2\2\u036d"+
		"\u038d\3\2\2\2\u036e\u036f\t\5\2\2\u036f\u0374\7\u0140\2\2\u0370\u0372"+
		"\5\u0088E\2\u0371\u0373\7\u0139\2\2\u0372\u0371\3\2\2\2\u0372\u0373\3"+
		"\2\2\2\u0373\u0375\3\2\2\2\u0374\u0370\3\2\2\2\u0375\u0376\3\2\2\2\u0376"+
		"\u0374\3\2\2\2\u0376\u0377\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u0379\7\u0141"+
		"\2\2\u0379\u037b\3\2\2\2\u037a\u036e\3\2\2\2\u037b\u037c\3\2\2\2\u037c"+
		"\u037a\3\2\2\2\u037c\u037d\3\2\2\2\u037d\u038e\3\2\2\2\u037e\u0380\7\6"+
		"\2\2\u037f\u0381\7\\\2\2\u0380\u037f\3\2\2\2\u0380\u0381\3\2\2\2\u0381"+
		"\u0382\3\2\2\2\u0382\u0387\7\u0140\2\2\u0383\u0385\5\u0088E\2\u0384\u0386"+
		"\7\u0139\2\2\u0385\u0384\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u0388\3\2\2"+
		"\2\u0387\u0383\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u0387\3\2\2\2\u0389\u038a"+
		"\3\2\2\2\u038a\u038b\3\2\2\2\u038b\u038c\7\u0141\2\2\u038c\u038e\3\2\2"+
		"\2\u038d\u037a\3\2\2\2\u038d\u037e\3\2\2\2\u038e\u038f\3\2\2\2\u038f\u0391"+
		"\7\u00d3\2\2\u0390\u0392\7s\2\2\u0391\u0390\3\2\2\2\u0391\u0392\3\2\2"+
		"\2\u0392\u0397\3\2\2\2\u0393\u0395\5\u0184\u00c3\2\u0394\u0396\7\u0139"+
		"\2\2\u0395\u0394\3\2\2\2\u0395\u0396\3\2\2\2\u0396\u0398\3\2\2\2\u0397"+
		"\u0393\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u0397\3\2\2\2\u0399\u039a\3\2"+
		"\2\2\u039a\u039b\3\2\2\2\u039b\u039c\5$\23\2\u039c\u04bd\3\2\2\2\u039d"+
		"\u03a1\7f\2\2\u039e\u039f\7\63\2\2\u039f\u03a0\7\u00d4\2\2\u03a0\u03a2"+
		"\7,\2\2\u03a1\u039e\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03ac\3\2\2\2\u03a3"+
		"\u03a5\t\6\2\2\u03a4\u03a3\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03a4\3\2"+
		"\2\2\u03a6\u03a7\3\2\2\2\u03a7\u03ad\3\2\2\2\u03a8\u03aa\7\6\2\2\u03a9"+
		"\u03ab\7\\\2\2\u03aa\u03a9\3\2\2\2\u03aa\u03ab\3\2\2\2\u03ab\u03ad\3\2"+
		"\2\2\u03ac\u03a4\3\2\2\2\u03ac\u03a8\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae"+
		"\u03c4\7\u00d3\2\2\u03af\u03b4\7j\2\2\u03b0\u03b2\5\u0184\u00c3\2\u03b1"+
		"\u03b3\7\u0139\2\2\u03b2\u03b1\3\2\2\2\u03b2\u03b3\3\2\2\2\u03b3\u03b5"+
		"\3\2\2\2\u03b4\u03b0\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03b4\3\2\2\2\u03b6"+
		"\u03b7\3\2\2\2\u03b7\u03c5\3\2\2\2\u03b8\u03b9\7\6\2\2\u03b9\u03ba\7k"+
		"\2\2\u03ba\u03bb\7;\2\2\u03bb\u03c0\7i\2\2\u03bc\u03be\5\u0088E\2\u03bd"+
		"\u03bf\7\u0139\2\2\u03be\u03bd\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03c1"+
		"\3\2\2\2\u03c0\u03bc\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c0\3\2\2\2\u03c2"+
		"\u03c3\3\2\2\2\u03c3\u03c5\3\2\2\2\u03c4\u03af\3\2\2\2\u03c4\u03b8\3\2"+
		"\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03c7\5$\23\2\u03c7\u04bd\3\2\2\2\u03c8"+
		"\u03cc\7f\2\2\u03c9\u03ca\7\63\2\2\u03ca\u03cb\7\u00d4\2\2\u03cb\u03cd"+
		"\7,\2\2\u03cc\u03c9\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03d7\3\2\2\2\u03ce"+
		"\u03d0\t\7\2\2\u03cf\u03ce\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03cf\3\2"+
		"\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03d8\3\2\2\2\u03d3\u03d5\7\6\2\2\u03d4"+
		"\u03d6\7\\\2\2\u03d5\u03d4\3\2\2\2\u03d5\u03d6\3\2\2\2\u03d6\u03d8\3\2"+
		"\2\2\u03d7\u03cf\3\2\2\2\u03d7\u03d3\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9"+
		"\u03da\7\u00d3\2\2\u03da\u03df\7\32\2\2\u03db\u03dd\5\u0088E\2\u03dc\u03de"+
		"\7\u0139\2\2\u03dd\u03dc\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03e0\3\2\2"+
		"\2\u03df\u03db\3\2\2\2\u03e0\u03e1\3\2\2\2\u03e1\u03df\3\2\2\2\u03e1\u03e2"+
		"\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3\u03e4\5$\23\2\u03e4\u04bd\3\2\2\2\u03e5"+
		"\u03e9\7f\2\2\u03e6\u03e7\7\63\2\2\u03e7\u03e8\7\u00d4\2\2\u03e8\u03ea"+
		"\7,\2\2\u03e9\u03e6\3\2\2\2\u03e9\u03ea\3\2\2\2\u03ea\u03f0\3\2\2\2\u03eb"+
		"\u03f1\7\177\2\2\u03ec\u03ee\7\6\2\2\u03ed\u03ef\7\\\2\2\u03ee\u03ed\3"+
		"\2\2\2\u03ee\u03ef\3\2\2\2\u03ef\u03f1\3\2\2\2\u03f0\u03eb\3\2\2\2\u03f0"+
		"\u03ec\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f3\7\u00d3\2\2\u03f3\u03f4"+
		"\7-\2\2\u03f4\u03f5\7\u009e\2\2\u03f5\u03fa\7\u0107\2\2\u03f6\u03f8\5"+
		"\u0184\u00c3\2\u03f7\u03f9\7\u0139\2\2\u03f8\u03f7\3\2\2\2\u03f8\u03f9"+
		"\3\2\2\2\u03f9\u03fb\3\2\2\2\u03fa\u03f6\3\2\2\2\u03fb\u03fc\3\2\2\2\u03fc"+
		"\u03fa\3\2\2\2\u03fc\u03fd\3\2\2\2\u03fd\u03fe\3\2\2\2\u03fe\u03ff\5$"+
		"\23\2\u03ff\u04bd\3\2\2\2\u0400\u0404\7f\2\2\u0401\u0402\7\63\2\2\u0402"+
		"\u0403\7\u00d4\2\2\u0403\u0405\7,\2\2\u0404\u0401\3\2\2\2\u0404\u0405"+
		"\3\2\2\2\u0405\u040b\3\2\2\2\u0406\u040c\7\177\2\2\u0407\u0409\7\6\2\2"+
		"\u0408\u040a\7\\\2\2\u0409\u0408\3\2\2\2\u0409\u040a\3\2\2\2\u040a\u040c"+
		"\3\2\2\2\u040b\u0406\3\2\2\2\u040b\u0407\3\2\2\2\u040c\u040d\3\2\2\2\u040d"+
		"\u040e\7\u00d3\2\2\u040e\u040f\7-\2\2\u040f\u0414\7\u00e8\2\2\u0410\u0412"+
		"\5\u0088E\2\u0411\u0413\7\u0139\2\2\u0412\u0411\3\2\2\2\u0412\u0413\3"+
		"\2\2\2\u0413\u0415\3\2\2\2\u0414\u0410\3\2\2\2\u0415\u0416\3\2\2\2\u0416"+
		"\u0414\3\2\2\2\u0416\u0417\3\2\2\2\u0417\u0418\3\2\2\2\u0418\u0419\5$"+
		"\23\2\u0419\u04bd\3\2\2\2\u041a\u041e\7f\2\2\u041b\u041c\7\63\2\2\u041c"+
		"\u041d\7\u00d4\2\2\u041d\u041f\7,\2\2\u041e\u041b\3\2\2\2\u041e\u041f"+
		"\3\2\2\2\u041f\u0425\3\2\2\2\u0420\u0426\7)\2\2\u0421\u0423\7\6\2\2\u0422"+
		"\u0424\7\\\2\2\u0423\u0422\3\2\2\2\u0423\u0424\3\2\2\2\u0424\u0426\3\2"+
		"\2\2\u0425\u0420\3\2\2\2\u0425\u0421\3\2\2\2\u0426\u0427\3\2\2\2\u0427"+
		"\u042a\7\u00d3\2\2\u0428\u042b\5:\36\2\u0429\u042b\5<\37\2\u042a\u0428"+
		"\3\2\2\2\u042a\u0429\3\2\2\2\u042b\u042c\3\2\2\2\u042c\u042d\5$\23\2\u042d"+
		"\u04bd\3\2\2\2\u042e\u0432\7f\2\2\u042f\u0430\7\63\2\2\u0430\u0431\7\u00d4"+
		"\2\2\u0431\u0433\7,\2\2\u0432\u042f\3\2\2\2\u0432\u0433\3\2\2\2\u0433"+
		"\u0439\3\2\2\2\u0434\u043a\7\177\2\2\u0435\u0437\7\6\2\2\u0436\u0438\7"+
		"\\\2\2\u0437\u0436\3\2\2\2\u0437\u0438\3\2\2\2\u0438\u043a\3\2\2\2\u0439"+
		"\u0434\3\2\2\2\u0439\u0435\3\2\2\2\u043a\u043b\3\2\2\2\u043b\u043c\7\u00d3"+
		"\2\2\u043c\u0441\7\u00be\2\2\u043d\u043f\5\u0088E\2\u043e\u0440\7\u0139"+
		"\2\2\u043f\u043e\3\2\2\2\u043f\u0440\3\2\2\2\u0440\u0442\3\2\2\2\u0441"+
		"\u043d\3\2\2\2\u0442\u0443\3\2\2\2\u0443\u0441\3\2\2\2\u0443\u0444\3\2"+
		"\2\2\u0444\u0445\3\2\2\2\u0445\u0446\5$\23\2\u0446\u04bd\3\2\2\2\u0447"+
		"\u044b\7f\2\2\u0448\u0449\7\63\2\2\u0449\u044a\7\u00d4\2\2\u044a\u044c"+
		"\7,\2\2\u044b\u0448\3\2\2\2\u044b\u044c\3\2\2\2\u044c\u045a\3\2\2\2\u044d"+
		"\u0453\7l\2\2\u044e\u0450\7~\2\2\u044f\u0451\7\u0139\2\2\u0450\u044f\3"+
		"\2\2\2\u0450\u0451\3\2\2\2\u0451\u0453\3\2\2\2\u0452\u044d\3\2\2\2\u0452"+
		"\u044e\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u0452\3\2\2\2\u0454\u0455\3\2"+
		"\2\2\u0455\u045b\3\2\2\2\u0456\u0458\7\6\2\2\u0457\u0459\7\\\2\2\u0458"+
		"\u0457\3\2\2\2\u0458\u0459\3\2\2\2\u0459\u045b\3\2\2\2\u045a\u0452\3\2"+
		"\2\2\u045a\u0456\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u045d\7\u00d3\2\2\u045d"+
		"\u045e\7\u00bf\2\2\u045e\u0463\7\u00d2\2\2\u045f\u0461\5\u0088E\2\u0460"+
		"\u0462\7\u0139\2\2\u0461\u0460\3\2\2\2\u0461\u0462\3\2\2\2\u0462\u0464"+
		"\3\2\2\2\u0463\u045f\3\2\2\2\u0464\u0465\3\2\2\2\u0465\u0463\3\2\2\2\u0465"+
		"\u0466\3\2\2\2\u0466\u0467\3\2\2\2\u0467\u0468\5$\23\2\u0468\u04bd\3\2"+
		"\2\2\u0469\u046d\7f\2\2\u046a\u046b\7\63\2\2\u046b\u046c\7\u00d4\2\2\u046c"+
		"\u046e\7,\2\2\u046d\u046a\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u047b\3\2"+
		"\2\2\u046f\u0471\t\b\2\2\u0470\u0472\7\u0139\2\2\u0471\u0470\3\2\2\2\u0471"+
		"\u0472\3\2\2\2\u0472\u0474\3\2\2\2\u0473\u046f\3\2\2\2\u0474\u0475\3\2"+
		"\2\2\u0475\u0473\3\2\2\2\u0475\u0476\3\2\2\2\u0476\u047c\3\2\2\2\u0477"+
		"\u0479\7\6\2\2\u0478\u047a\7\\\2\2\u0479\u0478\3\2\2\2\u0479\u047a\3\2"+
		"\2\2\u047a\u047c\3\2\2\2\u047b\u0473\3\2\2\2\u047b\u0477\3\2\2\2\u047c"+
		"\u047d\3\2\2\2\u047d\u047e\7\u00d3\2\2\u047e\u0483\7i\2\2\u047f\u0481"+
		"\5\u0088E\2\u0480\u0482\7\u0139\2\2\u0481\u0480\3\2\2\2\u0481\u0482\3"+
		"\2\2\2\u0482\u0484\3\2\2\2\u0483\u047f\3\2\2\2\u0484\u0485\3\2\2\2\u0485"+
		"\u0483\3\2\2\2\u0485\u0486\3\2\2\2\u0486\u0487\3\2\2\2\u0487\u0488\5$"+
		"\23\2\u0488\u04bd\3\2\2\2\u0489\u048d\7f\2\2\u048a\u048b\7\63\2\2\u048b"+
		"\u048c\7\u00d4\2\2\u048c\u048e\7,\2\2\u048d\u048a\3\2\2\2\u048d\u048e"+
		"\3\2\2\2\u048e\u0494\3\2\2\2\u048f\u0495\7\30\2\2\u0490\u0492\7\6\2\2"+
		"\u0491\u0493\7\\\2\2\u0492\u0491\3\2\2\2\u0492\u0493\3\2\2\2\u0493\u0495"+
		"\3\2\2\2\u0494\u048f\3\2\2\2\u0494\u0490\3\2\2\2\u0495\u0496\3\2\2\2\u0496"+
		"\u0497\7\u00d3\2\2\u0497\u049c\7\u00f3\2\2\u0498\u049a\5\u0088E\2\u0499"+
		"\u049b\7\u0139\2\2\u049a\u0499\3\2\2\2\u049a\u049b\3\2\2\2\u049b\u049d"+
		"\3\2\2\2\u049c\u0498\3\2\2\2\u049d\u049e\3\2\2\2\u049e\u049c\3\2\2\2\u049e"+
		"\u049f\3\2\2\2\u049f\u04a0\3\2\2\2\u04a0\u04a1\5$\23\2\u04a1\u04bd\3\2"+
		"\2\2\u04a2\u04a6\7f\2\2\u04a3\u04a4\7\u0088\2\2\u04a4\u04a5\7\u00d4\2"+
		"\2\u04a5\u04a7\7,\2\2\u04a6\u04a3\3\2\2\2\u04a6\u04a7\3\2\2\2\u04a7\u04ac"+
		"\3\2\2\2\u04a8\u04aa\5\u0088E\2\u04a9\u04ab\7\u0139\2\2\u04aa\u04a9\3"+
		"\2\2\2\u04aa\u04ab\3\2\2\2\u04ab\u04ad\3\2\2\2\u04ac\u04a8\3\2\2\2\u04ad"+
		"\u04ae\3\2\2\2\u04ae\u04ac\3\2\2\2\u04ae\u04af\3\2\2\2\u04af\u04b0\3\2"+
		"\2\2\u04b0\u04b5\7\61\2\2\u04b1\u04b3\5\u0088E\2\u04b2\u04b4\7\u0139\2"+
		"\2\u04b3\u04b2\3\2\2\2\u04b3\u04b4\3\2\2\2\u04b4\u04b6\3\2\2\2\u04b5\u04b1"+
		"\3\2\2\2\u04b6\u04b7\3\2\2\2\u04b7\u04b5\3\2\2\2\u04b7\u04b8\3\2\2\2\u04b8"+
		"\u04ba\3\2\2\2\u04b9\u04bb\t\t\2\2\u04ba\u04b9\3\2\2\2\u04ba\u04bb\3\2"+
		"\2\2\u04bb\u04bd\3\2\2\2\u04bc\u0341\3\2\2\2\u04bc\u0368\3\2\2\2\u04bc"+
		"\u039d\3\2\2\2\u04bc\u03c8\3\2\2\2\u04bc\u03e5\3\2\2\2\u04bc\u0400\3\2"+
		"\2\2\u04bc\u041a\3\2\2\2\u04bc\u042e\3\2\2\2\u04bc\u0447\3\2\2\2\u04bc"+
		"\u0469\3\2\2\2\u04bc\u0489\3\2\2\2\u04bc\u04a2\3\2\2\2\u04bd#\3\2\2\2"+
		"\u04be\u04c7\7\61\2\2\u04bf\u04c1\7\64\2\2\u04c0\u04bf\3\2\2\2\u04c0\u04c1"+
		"\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2\u04c8\5\u0088E\2\u04c3\u04c5\7\u00dc"+
		"\2\2\u04c4\u04c6\7\u0139\2\2\u04c5\u04c4\3\2\2\2\u04c5\u04c6\3\2\2\2\u04c6"+
		"\u04c8\3\2\2\2\u04c7\u04c0\3\2\2\2\u04c7\u04c3\3\2\2\2\u04c8\u04c9\3\2"+
		"\2\2\u04c9\u04c7\3\2\2\2\u04c9\u04ca\3\2\2\2\u04ca\u04cc\3\2\2\2\u04cb"+
		"\u04cd\t\t\2\2\u04cc\u04cb\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd%\3\2\2\2"+
		"\u04ce\u04d8\7\63\2\2\u04cf\u04d1\t\4\2\2\u04d0\u04cf\3\2\2\2\u04d1\u04d2"+
		"\3\2\2\2\u04d2\u04d0\3\2\2\2\u04d2\u04d3\3\2\2\2\u04d3\u04d9\3\2\2\2\u04d4"+
		"\u04d6\7\6\2\2\u04d5\u04d7\7\\\2\2\u04d6\u04d5\3\2\2\2\u04d6\u04d7\3\2"+
		"\2\2\u04d7\u04d9\3\2\2\2\u04d8\u04d0\3\2\2\2\u04d8\u04d4\3\2\2\2\u04d9"+
		"\u04da\3\2\2\2\u04da\u04f2\7\u00d3\2\2\u04db\u04dd\7s\2\2\u04dc\u04db"+
		"\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd\u04e2\3\2\2\2\u04de\u04e0\5\u0184\u00c3"+
		"\2\u04df\u04e1\7\u0139\2\2\u04e0\u04df\3\2\2\2\u04e0\u04e1\3\2\2\2\u04e1"+
		"\u04e3\3\2\2\2\u04e2\u04de\3\2\2\2\u04e3\u04e4\3\2\2\2\u04e4\u04e2\3\2"+
		"\2\2\u04e4\u04e5\3\2\2\2\u04e5\u04f3\3\2\2\2\u04e6\u04e7\7\6\2\2\u04e7"+
		"\u04e8\7\u00f4\2\2\u04e8\u04e9\7;\2\2\u04e9\u04ee\7i\2\2\u04ea\u04ec\5"+
		"\u0088E\2\u04eb\u04ed\7\u0139\2\2\u04ec\u04eb\3\2\2\2\u04ec\u04ed\3\2"+
		"\2\2\u04ed\u04ef\3\2\2\2\u04ee\u04ea\3\2\2\2\u04ef\u04f0\3\2\2\2\u04f0"+
		"\u04ee\3\2\2\2\u04f0\u04f1\3\2\2\2\u04f1\u04f3\3\2\2\2\u04f2\u04dc\3\2"+
		"\2\2\u04f2\u04e6\3\2\2\2\u04f3\u04f4\3\2\2\2\u04f4\u04f5\5(\25\2\u04f5"+
		"\u0614\3\2\2\2\u04f6\u0510\7\63\2\2\u04f7\u04fc\t\5\2\2\u04f8\u04fa\5"+
		"\u0088E\2\u04f9\u04fb\7\u0139\2\2\u04fa\u04f9\3\2\2\2\u04fa\u04fb\3\2"+
		"\2\2\u04fb\u04fd\3\2\2\2\u04fc\u04f8\3\2\2\2\u04fd\u04fe\3\2\2\2\u04fe"+
		"\u04fc\3\2\2\2\u04fe\u04ff\3\2\2\2\u04ff\u0501\3\2\2\2\u0500\u04f7\3\2"+
		"\2\2\u0501\u0502\3\2\2\2\u0502\u0500\3\2\2\2\u0502\u0503\3\2\2\2\u0503"+
		"\u0511\3\2\2\2\u0504\u0506\7\6\2\2\u0505\u0507\7\\\2\2\u0506\u0505\3\2"+
		"\2\2\u0506\u0507\3\2\2\2\u0507\u050c\3\2\2\2\u0508\u050a\5\u0088E\2\u0509"+
		"\u050b\7\u0139\2\2\u050a\u0509\3\2\2\2\u050a\u050b\3\2\2\2\u050b\u050d"+
		"\3\2\2\2\u050c\u0508\3\2\2\2\u050d\u050e\3\2\2\2\u050e\u050c\3\2\2\2\u050e"+
		"\u050f\3\2\2\2\u050f\u0511\3\2\2\2\u0510\u0500\3\2\2\2\u0510\u0504\3\2"+
		"\2\2\u0511\u0512\3\2\2\2\u0512\u051a\7\u00d3\2\2\u0513\u0515\7s\2\2\u0514"+
		"\u0513\3\2\2\2\u0514\u0515\3\2\2\2\u0515\u0516\3\2\2\2\u0516\u0518\5\u0184"+
		"\u00c3\2\u0517\u0519\7\u0139\2\2\u0518\u0517\3\2\2\2\u0518\u0519\3\2\2"+
		"\2\u0519\u051b\3\2\2\2\u051a\u0514\3\2\2\2\u051b\u051c\3\2\2\2\u051c\u051a"+
		"\3\2\2\2\u051c\u051d\3\2\2\2\u051d\u051e\3\2\2\2\u051e\u051f\5(\25\2\u051f"+
		"\u0614\3\2\2\2\u0520\u052d\7\63\2\2\u0521\u0523\t\6\2\2\u0522\u0524\7"+
		"\u0139\2\2\u0523\u0522\3\2\2\2\u0523\u0524\3\2\2\2\u0524\u0526\3\2\2\2"+
		"\u0525\u0521\3\2\2\2\u0526\u0527\3\2\2\2\u0527\u0525\3\2\2\2\u0527\u0528"+
		"\3\2\2\2\u0528\u052e\3\2\2\2\u0529\u052b\7\6\2\2\u052a\u052c\7\\\2\2\u052b"+
		"\u052a\3\2\2\2\u052b\u052c\3\2\2\2\u052c\u052e\3\2\2\2\u052d\u0525\3\2"+
		"\2\2\u052d\u0529\3\2\2\2\u052e\u052f\3\2\2\2\u052f\u0545\7\u00d3\2\2\u0530"+
		"\u0531\7j\2\2\u0531\u0533\5\u0088E\2\u0532\u0534\7\u0139\2\2\u0533\u0532"+
		"\3\2\2\2\u0533\u0534\3\2\2\2\u0534\u0536\3\2\2\2\u0535\u0530\3\2\2\2\u0536"+
		"\u0537\3\2\2\2\u0537\u0535\3\2\2\2\u0537\u0538\3\2\2\2\u0538\u0546\3\2"+
		"\2\2\u0539\u053a\7\6\2\2\u053a\u053b\7k\2\2\u053b\u053c\7;\2\2\u053c\u0541"+
		"\7i\2\2\u053d\u053f\5\u0088E\2\u053e\u0540\7\u0139\2\2\u053f\u053e\3\2"+
		"\2\2\u053f\u0540\3\2\2\2\u0540\u0542\3\2\2\2\u0541\u053d\3\2\2\2\u0542"+
		"\u0543\3\2\2\2\u0543\u0541\3\2\2\2\u0543\u0544\3\2\2\2\u0544\u0546\3\2"+
		"\2\2\u0545\u0535\3\2\2\2\u0545\u0539\3\2\2\2\u0546\u0547\3\2\2\2\u0547"+
		"\u0548\5(\25\2\u0548\u0614\3\2\2\2\u0549\u0556\7\63\2\2\u054a\u054c\t"+
		"\7\2\2\u054b\u054d\7\u0139\2\2\u054c\u054b\3\2\2\2\u054c\u054d\3\2\2\2"+
		"\u054d\u054f\3\2\2\2\u054e\u054a\3\2\2\2\u054f\u0550\3\2\2\2\u0550\u054e"+
		"\3\2\2\2\u0550\u0551\3\2\2\2\u0551\u0557\3\2\2\2\u0552\u0554\7\6\2\2\u0553"+
		"\u0555\7\\\2\2\u0554\u0553\3\2\2\2\u0554\u0555\3\2\2\2\u0555\u0557\3\2"+
		"\2\2\u0556\u054e\3\2\2\2\u0556\u0552\3\2\2\2\u0557\u0558\3\2\2\2\u0558"+
		"\u0559\7\u00d3\2\2\u0559\u055e\7\32\2\2\u055a\u055c\5\u0088E\2\u055b\u055d"+
		"\7\u0139\2\2\u055c\u055b\3\2\2\2\u055c\u055d\3\2\2\2\u055d\u055f\3\2\2"+
		"\2\u055e\u055a\3\2\2\2\u055f\u0560\3\2\2\2\u0560\u055e\3\2\2\2\u0560\u0561"+
		"\3\2\2\2\u0561\u0562\3\2\2\2\u0562\u0563\5(\25\2\u0563\u0614\3\2\2\2\u0564"+
		"\u056a\7\63\2\2\u0565\u056b\7\177\2\2\u0566\u0568\7\6\2\2\u0567\u0569"+
		"\7\\\2\2\u0568\u0567\3\2\2\2\u0568\u0569\3\2\2\2\u0569\u056b\3\2\2\2\u056a"+
		"\u0565\3\2\2\2\u056a\u0566\3\2\2\2\u056b\u056c\3\2\2\2\u056c\u056d\7\u00d3"+
		"\2\2\u056d\u056e\7-\2\2\u056e\u056f\7\u009e\2\2\u056f\u0574\7\u0107\2"+
		"\2\u0570\u0572\5\u0088E\2\u0571\u0573\7\u0139\2\2\u0572\u0571\3\2\2\2"+
		"\u0572\u0573\3\2\2\2\u0573\u0575\3\2\2\2\u0574\u0570\3\2\2\2\u0575\u0576"+
		"\3\2\2\2\u0576\u0574\3\2\2\2\u0576\u0577\3\2\2\2\u0577\u0578\3\2\2\2\u0578"+
		"\u0579\5(\25\2\u0579\u0614\3\2\2\2\u057a\u0580\7\63\2\2\u057b\u0581\7"+
		"\177\2\2\u057c\u057e\7\6\2\2\u057d\u057f\7\\\2\2\u057e\u057d\3\2\2\2\u057e"+
		"\u057f\3\2\2\2\u057f\u0581\3\2\2\2\u0580\u057b\3\2\2\2\u0580\u057c\3\2"+
		"\2\2\u0581\u0582\3\2\2\2\u0582\u0583\7\u00d3\2\2\u0583\u0584\7-\2\2\u0584"+
		"\u0589\7\u00e8\2\2\u0585\u0587\5\u0088E\2\u0586\u0588\7\u0139\2\2\u0587"+
		"\u0586\3\2\2\2\u0587\u0588\3\2\2\2\u0588\u058a\3\2\2\2\u0589\u0585\3\2"+
		"\2\2\u058a\u058b\3\2\2\2\u058b\u0589\3\2\2\2\u058b\u058c\3\2\2\2\u058c"+
		"\u058d\3\2\2\2\u058d\u058e\5(\25\2\u058e\u0614\3\2\2\2\u058f\u0595\7\63"+
		"\2\2\u0590\u0596\7)\2\2\u0591\u0593\7\6\2\2\u0592\u0594\7\\\2\2\u0593"+
		"\u0592\3\2\2\2\u0593\u0594\3\2\2\2\u0594\u0596\3\2\2\2\u0595\u0590\3\2"+
		"\2\2\u0595\u0591\3\2\2\2\u0596\u0597\3\2\2\2\u0597\u059a\7\u00d3\2\2\u0598"+
		"\u059b\5:\36\2\u0599\u059b\5<\37\2\u059a\u0598\3\2\2\2\u059a\u0599\3\2"+
		"\2\2\u059b\u059c\3\2\2\2\u059c\u059d\5(\25\2\u059d\u0614\3\2\2\2\u059e"+
		"\u05a4\7\63\2\2\u059f\u05a5\7\177\2\2\u05a0\u05a2\7\6\2\2\u05a1\u05a3"+
		"\7\\\2\2\u05a2\u05a1\3\2\2\2\u05a2\u05a3\3\2\2\2\u05a3\u05a5\3\2\2\2\u05a4"+
		"\u059f\3\2\2\2\u05a4\u05a0\3\2\2\2\u05a5\u05a6\3\2\2\2\u05a6\u05a7\7\u00d3"+
		"\2\2\u05a7\u05ac\7\u00be\2\2\u05a8\u05aa\5\u0088E\2\u05a9\u05ab\7\u0139"+
		"\2\2\u05aa\u05a9\3\2\2\2\u05aa\u05ab\3\2\2\2\u05ab\u05ad\3\2\2\2\u05ac"+
		"\u05a8\3\2\2\2\u05ad\u05ae\3\2\2\2\u05ae\u05ac\3\2\2\2\u05ae\u05af\3\2"+
		"\2\2\u05af\u05b0\3\2\2\2\u05b0\u05b1\5(\25\2\u05b1\u0614\3\2\2\2\u05b2"+
		"\u05bf\7\63\2\2\u05b3\u05b5\t\n\2\2\u05b4\u05b6\7\u0139\2\2\u05b5\u05b4"+
		"\3\2\2\2\u05b5\u05b6\3\2\2\2\u05b6\u05b8\3\2\2\2\u05b7\u05b3\3\2\2\2\u05b8"+
		"\u05b9\3\2\2\2\u05b9\u05b7\3\2\2\2\u05b9\u05ba\3\2\2\2\u05ba\u05c0\3\2"+
		"\2\2\u05bb\u05bd\7\6\2\2\u05bc\u05be\7\\\2\2\u05bd\u05bc\3\2\2\2\u05bd"+
		"\u05be\3\2\2\2\u05be\u05c0\3\2\2\2\u05bf\u05b7\3\2\2\2\u05bf\u05bb\3\2"+
		"\2\2\u05c0\u05c1\3\2\2\2\u05c1\u05c2\7\u00d3\2\2\u05c2\u05c3\7\u00bf\2"+
		"\2\u05c3\u05c8\7\u00d2\2\2\u05c4\u05c6\5\u0088E\2\u05c5\u05c7\7\u0139"+
		"\2\2\u05c6\u05c5\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u05c9\3\2\2\2\u05c8"+
		"\u05c4\3\2\2\2\u05c9\u05ca\3\2\2\2\u05ca\u05c8\3\2\2\2\u05ca\u05cb\3\2"+
		"\2\2\u05cb\u05cc\3\2\2\2\u05cc\u05cd\5(\25\2\u05cd\u0614\3\2\2\2\u05ce"+
		"\u05db\7\63\2\2\u05cf\u05d1\t\b\2\2\u05d0\u05d2\7\u0139\2\2\u05d1\u05d0"+
		"\3\2\2\2\u05d1\u05d2\3\2\2\2\u05d2\u05d4\3\2\2\2\u05d3\u05cf\3\2\2\2\u05d4"+
		"\u05d5\3\2\2\2\u05d5\u05d3\3\2\2\2\u05d5\u05d6\3\2\2\2\u05d6\u05dc\3\2"+
		"\2\2\u05d7\u05d9\7\6\2\2\u05d8\u05da\7\\\2\2\u05d9\u05d8\3\2\2\2\u05d9"+
		"\u05da\3\2\2\2\u05da\u05dc\3\2\2\2\u05db\u05d3\3\2\2\2\u05db\u05d7\3\2"+
		"\2\2\u05dc\u05dd\3\2\2\2\u05dd\u05de\7\u00d3\2\2\u05de\u05e3\7i\2\2\u05df"+
		"\u05e1\5\u0088E\2\u05e0\u05e2\7\u0139\2\2\u05e1\u05e0\3\2\2\2\u05e1\u05e2"+
		"\3\2\2\2\u05e2\u05e4\3\2\2\2\u05e3\u05df\3\2\2\2\u05e4\u05e5\3\2\2\2\u05e5"+
		"\u05e3\3\2\2\2\u05e5\u05e6\3\2\2\2\u05e6\u05e7\3\2\2\2\u05e7\u05e8\5("+
		"\25\2\u05e8\u0614\3\2\2\2\u05e9\u05ef\7\63\2\2\u05ea\u05f0\7\30\2\2\u05eb"+
		"\u05ed\7\6\2\2\u05ec\u05ee\7\\\2\2\u05ed\u05ec\3\2\2\2\u05ed\u05ee\3\2"+
		"\2\2\u05ee\u05f0\3\2\2\2\u05ef\u05ea\3\2\2\2\u05ef\u05eb\3\2\2\2\u05f0"+
		"\u05f1\3\2\2\2\u05f1\u05f2\7\u00d3\2\2\u05f2\u05f7\7\u00f3\2\2\u05f3\u05f5"+
		"\5\u0088E\2\u05f4\u05f6\7\u0139\2\2\u05f5\u05f4\3\2\2\2\u05f5\u05f6\3"+
		"\2\2\2\u05f6\u05f8\3\2\2\2\u05f7\u05f3\3\2\2\2\u05f8\u05f9\3\2\2\2\u05f9"+
		"\u05f7\3\2\2\2\u05f9\u05fa\3\2\2\2\u05fa\u05fb\3\2\2\2\u05fb\u05fc\5("+
		"\25\2\u05fc\u0601\7\63\2\2\u05fd\u05ff\5\u0088E\2\u05fe\u0600\7\u0139"+
		"\2\2\u05ff\u05fe\3\2\2\2\u05ff\u0600\3\2\2\2\u0600\u0602\3\2\2\2\u0601"+
		"\u05fd\3\2\2\2\u0602\u0603\3\2\2\2\u0603\u0601\3\2\2\2\u0603\u0604\3\2"+
		"\2\2\u0604\u0605\3\2\2\2\u0605\u060a\7\u00fb\2\2\u0606\u0608\5\u0088E"+
		"\2\u0607\u0609\7\u0139\2\2\u0608\u0607\3\2\2\2\u0608\u0609\3\2\2\2\u0609"+
		"\u060b\3\2\2\2\u060a\u0606\3\2\2\2\u060b\u060c\3\2\2\2\u060c\u060a\3\2"+
		"\2\2\u060c\u060d\3\2\2\2\u060d\u0611\3\2\2\2\u060e\u060f\7\u0086\2\2\u060f"+
		"\u0610\7\u0088\2\2\u0610\u0612\7\u00d4\2\2\u0611\u060e\3\2\2\2\u0611\u0612"+
		"\3\2\2\2\u0612\u0614\3\2\2\2\u0613\u04ce\3\2\2\2\u0613\u04f6\3\2\2\2\u0613"+
		"\u0520\3\2\2\2\u0613\u0549\3\2\2\2\u0613\u0564\3\2\2\2\u0613\u057a\3\2"+
		"\2\2\u0613\u058f\3\2\2\2\u0613\u059e\3\2\2\2\u0613\u05b2\3\2\2\2\u0613"+
		"\u05ce\3\2\2\2\u0613\u05e9\3\2\2\2\u0614\'\3\2\2\2\u0615\u0620\7\u00fb"+
		"\2\2\u0616\u0618\7\64\2\2\u0617\u0616\3\2\2\2\u0617\u0618\3\2\2\2\u0618"+
		"\u061b\3\2\2\2\u0619\u061c\5\u0088E\2\u061a\u061c\7\u00dc\2\2\u061b\u0619"+
		"\3\2\2\2\u061b\u061a\3\2\2\2\u061c\u061e\3\2\2\2\u061d\u061f\7\u0139\2"+
		"\2\u061e\u061d\3\2\2\2\u061e\u061f\3\2\2\2\u061f\u0621\3\2\2\2\u0620\u0617"+
		"\3\2\2\2\u0621\u0622\3\2\2\2\u0622\u0620\3\2\2\2\u0622\u0623\3\2\2\2\u0623"+
		"\u0627\3\2\2\2\u0624\u0625\7\u0086\2\2\u0625\u0626\7\63\2\2\u0626\u0628"+
		"\7\u00d4\2\2\u0627\u0624\3\2\2\2\u0627\u0628\3\2\2\2\u0628)\3\2\2\2\u0629"+
		"\u062a\7\u0095\2\2\u062a\u06a1\7\u00d3\2\2\u062b\u062c\7\3\2\2\u062c\u062d"+
		"\5\u0184\u00c3\2\u062d\u0634\7\u0140\2\2\u062e\u0630\5\u009aN\2\u062f"+
		"\u0631\7\u0139\2\2\u0630\u062f\3\2\2\2\u0630\u0631\3\2\2\2\u0631\u0633"+
		"\3\2\2\2\u0632\u062e\3\2\2\2\u0633\u0636\3\2\2\2\u0634\u0632\3\2\2\2\u0634"+
		"\u0635\3\2\2\2\u0635\u0637\3\2\2\2\u0636\u0634\3\2\2\2\u0637\u0638\7\u0141"+
		"\2\2\u0638\u06a2\3\2\2\2\u0639\u063a\7\21\2\2\u063a\u063b\7\u0140\2\2"+
		"\u063b\u063c\5\u009aN\2\u063c\u063d\7\5\2\2\u063d\u063e\5\u009aN\2\u063e"+
		"\u063f\7\u0141\2\2\u063f\u06a2\3\2\2\2\u0640\u0641\7\23\2\2\u0641\u06a2"+
		"\5\u0184\u00c3\2\u0642\u0643\7\u0094\2\2\u0643\u06a2\5\u0184\u00c3\2\u0644"+
		"\u0645\7\25\2\2\u0645\u0646\5\u0184\u00c3\2\u0646\u0647\7\u00d3\2\2\u0647"+
		"\u0648\5\u0184\u00c3\2\u0648\u06a2\3\2\2\2\u0649\u064a\7\27\2\2\u064a"+
		"\u06a2\5\u0184\u00c3\2\u064b\u064c\7\32\2\2\u064c\u06a2\5\u0184\u00c3"+
		"\2\u064d\u064e\7\"\2\2\u064e\u06a2\5\u0184\u00c3\2\u064f\u0650\7*\2\2"+
		"\u0650\u06a2\5\u0184\u00c3\2\u0651\u0652\7-\2\2\u0652\u0653\7\u009e\2"+
		"\2\u0653\u0654\7\u0107\2\2\u0654\u06a2\5\u0184\u00c3\2\u0655\u0656\7-"+
		"\2\2\u0656\u0657\7s\2\2\u0657\u06a2\5\u0184\u00c3\2\u0658\u06a2\5:\36"+
		"\2\u0659\u065a\7\u00b4\2\2\u065a\u06a2\5\u0184\u00c3\2\u065b\u065c\7\u00bf"+
		"\2\2\u065c\u065d\7\u00d2\2\2\u065d\u06a2\5\u0088E\2\u065e\u065f\7U\2\2"+
		"\u065f\u0660\5\u0184\u00c3\2\u0660\u0661\7\u0140\2\2\u0661\u0662\5\u009a"+
		"N\2\u0662\u0663\7\u0139\2\2\u0663\u0664\5\u009aN\2\u0664\u0665\7\u0141"+
		"\2\2\u0665\u06a2\3\2\2\2\u0666\u0667\7U\2\2\u0667\u0668\7\u008e\2\2\u0668"+
		"\u0669\5\u0184\u00c3\2\u0669\u066a\7\u0080\2\2\u066a\u066b\5\u0088E\2"+
		"\u066b\u06a2\3\2\2\2\u066c\u066d\7U\2\2\u066d\u066e\7\u00ac\2\2\u066e"+
		"\u066f\5\u0184\u00c3\2\u066f\u0670\7\u0080\2\2\u0670\u0671\5\u0088E\2"+
		"\u0671\u06a2\3\2\2\2\u0672\u0674\7^\2\2\u0673\u0672\3\2\2\2\u0673\u0674"+
		"\3\2\2\2\u0674\u0675\3\2\2\2\u0675\u0676\7\u00be\2\2\u0676\u06a2\5\u0184"+
		"\u00c3\2\u0677\u0678\7_\2\2\u0678\u06a2\5\u0184\u00c3\2\u0679\u067a\7"+
		"h\2\2\u067a\u067b\5\u0184\u00c3\2\u067b\u067c\7\u00d3\2\2\u067c\u067d"+
		"\5\u0184\u00c3\2\u067d\u06a2\3\2\2\2\u067e\u067f\7i\2\2\u067f\u06a2\5"+
		"\u0184\u00c3\2\u0680\u0681\7j\2\2\u0681\u06a2\5\u0184\u00c3\2\u0682\u0683"+
		"\7\u00e8\2\2\u0683\u06a2\5\u0184\u00c3\2\u0684\u0685\7s\2\2\u0685\u06a2"+
		"\5\u0184\u00c3\2\u0686\u0687\7\u00f3\2\2\u0687\u06a2\5\u0184\u00c3\2\u0688"+
		"\u0689\7\u0128\2\2\u0689\u068a\7\u00e5\2\2\u068a\u068b\7\u0098\2\2\u068b"+
		"\u06a2\5\u0184\u00c3\2\u068c\u068d\7\u0128\2\2\u068d\u068e\7\u00e5\2\2"+
		"\u068e\u068f\7\u00a3\2\2\u068f\u06a2\5\u0184\u00c3\2\u0690\u0691\7\u0128"+
		"\2\2\u0691\u0692\7\u00e5\2\2\u0692\u0693\7\u00d7\2\2\u0693\u06a2\5\u0184"+
		"\u00c3\2\u0694\u0695\7\u0128\2\2\u0695\u0696\7\u00e5\2\2\u0696\u0697\7"+
		"\u00f5\2\2\u0697\u06a2\5\u0184\u00c3\2\u0698\u0699\7y\2\2\u0699\u069a"+
		"\5\u0184\u00c3\2\u069a\u069b\7\u00d3\2\2\u069b\u069c\5\u0184\u00c3\2\u069c"+
		"\u06a2\3\2\2\2\u069d\u069e\7\u00fc\2\2\u069e\u06a2\5\u0184\u00c3\2\u069f"+
		"\u06a0\7\u0083\2\2\u06a0\u06a2\5\u0184\u00c3\2\u06a1\u062b\3\2\2\2\u06a1"+
		"\u0639\3\2\2\2\u06a1\u0640\3\2\2\2\u06a1\u0642\3\2\2\2\u06a1\u0644\3\2"+
		"\2\2\u06a1\u0649\3\2\2\2\u06a1\u064b\3\2\2\2\u06a1\u064d\3\2\2\2\u06a1"+
		"\u064f\3\2\2\2\u06a1\u0651\3\2\2\2\u06a1\u0655\3\2\2\2\u06a1\u0658\3\2"+
		"\2\2\u06a1\u0659\3\2\2\2\u06a1\u065b\3\2\2\2\u06a1\u065e\3\2\2\2\u06a1"+
		"\u0666\3\2\2\2\u06a1\u066c\3\2\2\2\u06a1\u0673\3\2\2\2\u06a1\u0677\3\2"+
		"\2\2\u06a1\u0679\3\2\2\2\u06a1\u067e\3\2\2\2\u06a1\u0680\3\2\2\2\u06a1"+
		"\u0682\3\2\2\2\u06a1\u0684\3\2\2\2\u06a1\u0686\3\2\2\2\u06a1\u0688\3\2"+
		"\2\2\u06a1\u068c\3\2\2\2\u06a1\u0690\3\2\2\2\u06a1\u0694\3\2\2\2\u06a1"+
		"\u0698\3\2\2\2\u06a1\u069d\3\2\2\2\u06a1\u069f\3\2\2\2\u06a2\u06a3\3\2"+
		"\2\2\u06a3\u06a4\7F\2\2\u06a4\u06a5\7\u0156\2\2\u06a5+\3\2\2\2\u06a6\u06a9"+
		"\7\30\2\2\u06a7\u06a8\7V\2\2\u06a8\u06aa\7c\2\2\u06a9\u06a7\3\2\2\2\u06a9"+
		"\u06aa\3\2\2\2\u06aa\u06ab\3\2\2\2\u06ab\u06ac\7/\2\2\u06ac\u06ad\5\u0184"+
		"\u00c3\2\u06ad\u06be\5.\30\2\u06ae\u06af\7e\2\2\u06af\u06bf\5\u009aN\2"+
		"\u06b0\u06b1\7e\2\2\u06b1\u06b2\7s\2\2\u06b2\u06b8\7\u0140\2\2\u06b3\u06b4"+
		"\5\u0088E\2\u06b4\u06b6\5\u009aN\2\u06b5\u06b7\7\u0139\2\2\u06b6\u06b5"+
		"\3\2\2\2\u06b6\u06b7\3\2\2\2\u06b7\u06b9\3\2\2\2\u06b8\u06b3\3\2\2\2\u06b9"+
		"\u06ba\3\2\2\2\u06ba\u06b8\3\2\2\2\u06ba\u06bb\3\2\2\2\u06bb\u06bc\3\2"+
		"\2\2\u06bc\u06bd\7\u0141\2\2\u06bd\u06bf\3\2\2\2\u06be\u06ae\3\2\2\2\u06be"+
		"\u06b0\3\2\2\2\u06be\u06bf\3\2\2\2\u06bf\u06f5\3\2\2\2\u06c0\u06c1\7\u00be"+
		"\2\2\u06c1\u06f6\5\u0088E\2\u06c2\u06f6\7\u0106\2\2\u06c3\u06f6\7:\2\2"+
		"\u06c4\u06f6\7\u00ec\2\2\u06c5\u06f6\7\u0104\2\2\u06c6\u06c7\7\u008d\2"+
		"\2\u06c7\u06c8\7\u00d3\2\2\u06c8\u06c9\7P\2\2\u06c9\u06f6\7\u00b7\2\2"+
		"\u06ca\u06cb\7e\2\2\u06cb\u06cc\7P\2\2\u06cc\u06cd\7\u00d3\2\2\u06cd\u06ce"+
		"\7P\2\2\u06ce\u06f6\7\u00b7\2\2\u06cf\u06f6\7q\2\2\u06d0\u06d2\7\u00aa"+
		"\2\2\u06d1\u06d0\3\2\2\2\u06d1\u06d2\3\2\2\2\u06d2\u06d3\3\2\2\2\u06d3"+
		"\u06d4\7\u00e7\2\2\u06d4\u06f6\7E\2\2\u06d5\u06d7\7\u00aa\2\2\u06d6\u06d5"+
		"\3\2\2\2\u06d6\u06d7\3\2\2\2\u06d7\u06d8\3\2\2\2\u06d8\u06d9\7\u00e7\2"+
		"\2\u06d9\u06f6\7\u00a2\2\2\u06da\u06db\7\u0099\2\2\u06db\u06f6\7\u014f"+
		"\2\2\u06dc\u06dd\7a\2\2\u06dd\u06f6\7\u014f\2\2\u06de\u06df\7\u00e9\2"+
		"\2\u06df\u06e6\5\u0088E\2\u06e0\u06e1\7\u00fb\2\2\u06e1\u06e7\5\u0088"+
		"E\2\u06e2\u06e3\7\u0136\2\2\u06e3\u06e7\5\u0088E\2\u06e4\u06e5\7\61\2"+
		"\2\u06e5\u06e7\7\u009c\2\2\u06e6\u06e0\3\2\2\2\u06e6\u06e2\3\2\2\2\u06e6"+
		"\u06e4\3\2\2\2\u06e7\u06ec\3\2\2\2\u06e8\u06e9\7\u0139\2\2\u06e9\u06eb"+
		"\5\u0088E\2\u06ea\u06e8\3\2\2\2\u06eb\u06ee\3\2\2\2\u06ec\u06ea\3\2\2"+
		"\2\u06ec\u06ed\3\2\2\2\u06ed\u06f6\3\2\2\2\u06ee\u06ec\3\2\2\2\u06ef\u06f0"+
		"\7\5\2\2\u06f0\u06f6\5\60\31\2\u06f1\u06f2\7\5\2\2\u06f2\u06f3\7\u0156"+
		"\2\2\u06f3\u06f4\7\u0139\2\2\u06f4\u06f6\7\u0156\2\2\u06f5\u06c0\3\2\2"+
		"\2\u06f5\u06c2\3\2\2\2\u06f5\u06c3\3\2\2\2\u06f5\u06c4\3\2\2\2\u06f5\u06c5"+
		"\3\2\2\2\u06f5\u06c6\3\2\2\2\u06f5\u06ca\3\2\2\2\u06f5\u06cf\3\2\2\2\u06f5"+
		"\u06d1\3\2\2\2\u06f5\u06d6\3\2\2\2\u06f5\u06da\3\2\2\2\u06f5\u06dc\3\2"+
		"\2\2\u06f5\u06de\3\2\2\2\u06f5\u06ef\3\2\2\2\u06f5\u06f1\3\2\2\2\u06f6"+
		"\u06f7\3\2\2\2\u06f7\u06f5\3\2\2\2\u06f7\u06f8\3\2\2\2\u06f8\u0705\3\2"+
		"\2\2\u06f9\u06fa\7\u0086\2\2\u06fa\u06ff\7\u0140\2\2\u06fb\u06fd\5\66"+
		"\34\2\u06fc\u06fe\7\u0139\2\2\u06fd\u06fc\3\2\2\2\u06fd\u06fe\3\2\2\2"+
		"\u06fe\u0700\3\2\2\2\u06ff\u06fb\3\2\2\2\u0700\u0701\3\2\2\2\u0701\u06ff"+
		"\3\2\2\2\u0701\u0702\3\2\2\2\u0702\u0703\3\2\2\2\u0703\u0704\7\u0141\2"+
		"\2\u0704\u0706\3\2\2\2\u0705\u06f9\3\2\2\2\u0705\u0706\3\2\2\2\u0706-"+
		"\3\2\2\2\u0707\u0719\7\u0140\2\2\u0708\u070a\58\35\2\u0709\u0708\3\2\2"+
		"\2\u0709\u070a\3\2\2\2\u070a\u070c\3\2\2\2\u070b\u070d\5\u0088E\2\u070c"+
		"\u070b\3\2\2\2\u070c\u070d\3\2\2\2\u070d\u070e\3\2\2\2\u070e\u0712\5\u009a"+
		"N\2\u070f\u0713\7\33\2\2\u0710\u0711\7\u0136\2\2\u0711\u0713\5\u00eav"+
		"\2\u0712\u070f\3\2\2\2\u0712\u0710\3\2\2\2\u0712\u0713\3\2\2\2\u0713\u0715"+
		"\3\2\2\2\u0714\u0716\7\u0139\2\2\u0715\u0714\3\2\2\2\u0715\u0716\3\2\2"+
		"\2\u0716\u0718\3\2\2\2\u0717\u0709\3\2\2\2\u0718\u071b\3\2\2\2\u0719\u0717"+
		"\3\2\2\2\u0719\u071a\3\2\2\2\u071a\u071c\3\2\2\2\u071b\u0719\3\2\2\2\u071c"+
		"\u071d\7\u0141\2\2\u071d/\3\2\2\2\u071e\u0721\5\62\32\2\u071f\u0721\5"+
		"\64\33\2\u0720\u071e\3\2\2\2\u0720\u071f\3\2\2\2\u0721\61\3\2\2\2\u0722"+
		"\u0726\7\u014d\2\2\u0723\u0725\n\13\2\2\u0724\u0723\3\2\2\2\u0725\u0728"+
		"\3\2\2\2\u0726\u0724\3\2\2\2\u0726\u0727\3\2\2\2\u0727\u0729\3\2\2\2\u0728"+
		"\u0726\3\2\2\2\u0729\u072a\7\u014d\2\2\u072a\63\3\2\2\2\u072b\u072f\7"+
		"\u014e\2\2\u072c\u072e\n\f\2\2\u072d\u072c\3\2\2\2\u072e\u0731\3\2\2\2"+
		"\u072f\u072d\3\2\2\2\u072f\u0730\3\2\2\2\u0730\u0732\3\2\2\2\u0731\u072f"+
		"\3\2\2\2\u0732\u0733\7\u014e\2\2\u0733\65\3\2\2\2\u0734\u0735\t\r\2\2"+
		"\u0735\67\3\2\2\2\u0736\u0737\t\16\2\2\u07379\3\2\2\2\u0738\u0739\7/\2"+
		"\2\u0739\u073a\5\u0088E\2\u073a\u074a\7\u0140\2\2\u073b\u073d\58\35\2"+
		"\u073c\u073b\3\2\2\2\u073c\u073d\3\2\2\2\u073d\u073f\3\2\2\2\u073e\u0740"+
		"\5\u0088E\2\u073f\u073e\3\2\2\2\u073f\u0740\3\2\2\2\u0740\u0743\3\2\2"+
		"\2\u0741\u0744\5\u009aN\2\u0742\u0744\5\u00eav\2\u0743\u0741\3\2\2\2\u0743"+
		"\u0742\3\2\2\2\u0744\u0746\3\2\2\2\u0745\u0747\7\u0139\2\2\u0746\u0745"+
		"\3\2\2\2\u0746\u0747\3\2\2\2\u0747\u0749\3\2\2\2\u0748\u073c\3\2\2\2\u0749"+
		"\u074c\3\2\2\2\u074a\u0748\3\2\2\2\u074a\u074b\3\2\2\2\u074b\u074d\3\2"+
		"\2\2\u074c\u074a\3\2\2\2\u074d\u074e\7\u0141\2\2\u074e;\3\2\2\2\u074f"+
		"\u0750\7\6\2\2\u0750\u0751\7\60\2\2\u0751\u0752\7;\2\2\u0752\u0757\7i"+
		"\2\2\u0753\u0755\5\u0088E\2\u0754\u0756\7\u0139\2\2\u0755\u0754\3\2\2"+
		"\2\u0755\u0756\3\2\2\2\u0756\u0758\3\2\2\2\u0757\u0753\3\2\2\2\u0758\u0759"+
		"\3\2\2\2\u0759\u0757\3\2\2\2\u0759\u075a\3\2\2\2\u075a=\3\2\2\2\u075b"+
		"\u075d\7\30\2\2\u075c\u075e\t\17\2\2\u075d\u075c\3\2\2\2\u075d\u075e\3"+
		"\2\2\2\u075e\u075f\3\2\2\2\u075f\u0760\7j\2\2\u0760\u0785\5\u0184\u00c3"+
		"\2\u0761\u0763\7\u00b6\2\2\u0762\u0764\7\u008b\2\2\u0763\u0762\3\2\2\2"+
		"\u0763\u0764\3\2\2\2\u0764\u0765\3\2\2\2\u0765\u0784\7\u014f\2\2\u0766"+
		"\u0767\7\u00cb\2\2\u0767\u076b\7\u014f\2\2\u0768\u0769\7\u00cf\2\2\u0769"+
		"\u076b\7\u00cb\2\2\u076a\u0766\3\2\2\2\u076a\u0768\3\2\2\2\u076b\u0784"+
		"\3\2\2\2\u076c\u076d\7\u00c6\2\2\u076d\u0771\5\u00aaV\2\u076e\u076f\7"+
		"\u00cf\2\2\u076f\u0771\7\u00c6\2\2\u0770\u076c\3\2\2\2\u0770\u076e\3\2"+
		"\2\2\u0771\u0784\3\2\2\2\u0772\u0774\7\u00ed\2\2\u0773\u0775\7\u0086\2"+
		"\2\u0774\u0773\3\2\2\2\u0774\u0775\3\2\2\2\u0775\u0776\3\2\2\2\u0776\u0784"+
		"\7\u014f\2\2\u0777\u0778\7\u008c\2\2\u0778\u0784\7\u014f\2\2\u0779\u077b"+
		"\7\u00cf\2\2\u077a\u0779\3\2\2\2\u077a\u077b\3\2\2\2\u077b\u077c\3\2\2"+
		"\2\u077c\u0784\7\u009d\2\2\u077d\u077e\7X\2\2\u077e\u0781\7\u008b\2\2"+
		"\u077f\u0782\5\u0184\u00c3\2\u0780\u0782\7\u00d0\2\2\u0781\u077f\3\2\2"+
		"\2\u0781\u0780\3\2\2\2\u0782\u0784\3\2\2\2\u0783\u0761\3\2\2\2\u0783\u076a"+
		"\3\2\2\2\u0783\u0770\3\2\2\2\u0783\u0772\3\2\2\2\u0783\u0777\3\2\2\2\u0783"+
		"\u077a\3\2\2\2\u0783\u077d\3\2\2\2\u0784\u0787\3\2\2\2\u0785\u0783\3\2"+
		"\2\2\u0785\u0786\3\2\2\2\u0786?\3\2\2\2\u0787\u0785\3\2\2\2\u0788\u0789"+
		"\7\30\2\2\u0789\u078a\7i\2\2\u078a\u078d\5\u0088E\2\u078b\u078c\7\f\2"+
		"\2\u078c\u078e\5\u0088E\2\u078d\u078b\3\2\2\2\u078d\u078e\3\2\2\2\u078e"+
		"\u0792\3\2\2\2\u078f\u0791\5\2\2\2\u0790\u078f\3\2\2\2\u0791\u0794\3\2"+
		"\2\2\u0792\u0790\3\2\2\2\u0792\u0793\3\2\2\2\u0793\u07b1\3\2\2\2\u0794"+
		"\u0792\3\2\2\2\u0795\u0796\7\30\2\2\u0796\u0797\7i\2\2\u0797\u0798\7\f"+
		"\2\2\u0798\u079c\5\u0088E\2\u0799\u079b\5\2\2\2\u079a\u0799\3\2\2\2\u079b"+
		"\u079e\3\2\2\2\u079c\u079a\3\2\2\2\u079c\u079d\3\2\2\2\u079d\u07b1\3\2"+
		"\2\2\u079e\u079c\3\2\2\2\u079f\u07a0\7\30\2\2\u07a0\u07a1\7i\2\2\u07a1"+
		"\u07a2\7\67\2\2\u07a2\u07a3\7O\2\2\u07a3\u07a4\7\u00a9\2\2\u07a4\u07a7"+
		"\5\u0088E\2\u07a5\u07a6\7\f\2\2\u07a6\u07a8\5\u0088E\2\u07a7\u07a5\3\2"+
		"\2\2\u07a7\u07a8\3\2\2\2\u07a8\u07b1\3\2\2\2\u07a9\u07aa\7\30\2\2\u07aa"+
		"\u07ab\7i\2\2\u07ab\u07ac\7\67\2\2\u07ac\u07ad\7O\2\2\u07ad\u07ae\7\u00a9"+
		"\2\2\u07ae\u07af\7\f\2\2\u07af\u07b1\5\u0088E\2\u07b0\u0788\3\2\2\2\u07b0"+
		"\u0795\3\2\2\2\u07b0\u079f\3\2\2\2\u07b0\u07a9\3\2\2\2\u07b1A\3\2\2\2"+
		"\u07b2\u07b5\7\30\2\2\u07b3\u07b4\7V\2\2\u07b4\u07b6\7c\2\2\u07b5\u07b3"+
		"\3\2\2\2\u07b5\u07b6\3\2\2\2\u07b6\u07b8\3\2\2\2\u07b7\u07b9\t\17\2\2"+
		"\u07b8\u07b7\3\2\2\2\u07b8\u07b9\3\2\2\2\u07b9\u07ba\3\2\2\2\u07ba\u07bb"+
		"\7\u0083\2\2\u07bb\u07c2\5\u0184\u00c3\2\u07bc\u07be\5\u0088E\2\u07bd"+
		"\u07bf\7\u0139\2\2\u07be\u07bd\3\2\2\2\u07be\u07bf\3\2\2\2\u07bf\u07c1"+
		"\3\2\2\2\u07c0\u07bc\3\2\2\2\u07c1\u07c4\3\2\2\2\u07c2\u07c0\3\2\2\2\u07c2"+
		"\u07c3\3\2\2\2\u07c3\u07d2\3\2\2\2\u07c4\u07c2\3\2\2\2\u07c5\u07c6\7\u0086"+
		"\2\2\u07c6\u07cc\7\u0140\2\2\u07c7\u07ca\5\u0088E\2\u07c8\u07c9\7\u0136"+
		"\2\2\u07c9\u07cb\5\u0088E\2\u07ca\u07c8\3\2\2\2\u07ca\u07cb\3\2\2\2\u07cb"+
		"\u07cd\3\2\2\2\u07cc\u07c7\3\2\2\2\u07cd\u07ce\3\2\2\2\u07ce\u07cc\3\2"+
		"\2\2\u07ce\u07cf\3\2\2\2\u07cf\u07d0\3\2\2\2\u07d0\u07d1\7\u0141\2\2\u07d1"+
		"\u07d3\3\2\2\2\u07d2\u07c5\3\2\2\2\u07d2\u07d3\3\2\2\2\u07d3\u07d4\3\2"+
		"\2\2\u07d4\u07d5\7\5\2\2\u07d5\u07d6\5\u0186\u00c4\2\u07d6C\3\2\2\2\u07d7"+
		"\u07d8\3\2\2\2\u07d8E\3\2\2\2\u07d9\u07df\7\30\2\2\u07da\u07dc\t\20\2"+
		"\2\u07db\u07da\3\2\2\2\u07db\u07dc\3\2\2\2\u07dc\u07dd\3\2\2\2\u07dd\u07e0"+
		"\t\17\2\2\u07de\u07e0\7\u00fe\2\2\u07df\u07db\3\2\2\2\u07df\u07de\3\2"+
		"\2\2\u07df\u07e0\3\2\2\2\u07e0\u07e1\3\2\2\2\u07e1\u07e5\7s\2\2\u07e2"+
		"\u07e3\7\67\2\2\u07e3\u07e4\7O\2\2\u07e4\u07e6\7\u00a9\2\2\u07e5\u07e2"+
		"\3\2\2\2\u07e5\u07e6\3\2\2\2\u07e6\u07e7\3\2\2\2\u07e7\u07e8\5\u0184\u00c3"+
		"\2\u07e8\u0807\7\u0140\2\2\u07e9\u07ea\5\u0088E\2\u07ea\u07ed\5\u009a"+
		"N\2\u07eb\u07ec\7\22\2\2\u07ec\u07ee\5\u0088E\2\u07ed\u07eb\3\2\2\2\u07ed"+
		"\u07ee\3\2\2\2\u07ee\u07f2\3\2\2\2\u07ef\u07f1\5L\'\2\u07f0\u07ef\3\2"+
		"\2\2\u07f1\u07f4\3\2\2\2\u07f2\u07f0\3\2\2\2\u07f2\u07f3\3\2\2\2\u07f3"+
		"\u07ff\3\2\2\2\u07f4\u07f2\3\2\2\2\u07f5\u07ff\5J&\2\u07f6\u07f7\7K\2"+
		"\2\u07f7\u07fb\5\u0088E\2\u07f8\u07fa\5H%\2\u07f9\u07f8\3\2\2\2\u07fa"+
		"\u07fd\3\2\2\2\u07fb\u07f9\3\2\2\2\u07fb\u07fc\3\2\2\2\u07fc\u07ff\3\2"+
		"\2\2\u07fd\u07fb\3\2\2\2\u07fe\u07e9\3\2\2\2\u07fe\u07f5\3\2\2\2\u07fe"+
		"\u07f6\3\2\2\2\u07ff\u0801\3\2\2\2\u0800\u0802\7\u0139\2\2\u0801\u0800"+
		"\3\2\2\2\u0801\u0802\3\2\2\2\u0802\u0804\3\2\2\2\u0803\u07fe\3\2\2\2\u0804"+
		"\u0805\3\2\2\2\u0805\u0803\3\2\2\2\u0805\u0806\3\2\2\2\u0806\u0808\3\2"+
		"\2\2\u0807\u0803\3\2\2\2\u0807\u0808\3\2\2\2\u0808\u0809\3\2\2\2\u0809"+
		"\u0816\7\u0141\2\2\u080a\u080b\7=\2\2\u080b\u0810\7\u0140\2\2\u080c\u080e"+
		"\5\u0088E\2\u080d\u080f\7\u0139\2\2\u080e\u080d\3\2\2\2\u080e\u080f\3"+
		"\2\2\2\u080f\u0811\3\2\2\2\u0810\u080c\3\2\2\2\u0811\u0812\3\2\2\2\u0812"+
		"\u0810\3\2\2\2\u0812\u0813\3\2\2\2\u0813\u0814\3\2\2\2\u0814\u0815\7\u0141"+
		"\2\2\u0815\u0817\3\2\2\2\u0816\u080a\3\2\2\2\u0816\u0817\3\2\2\2\u0817"+
		"\u0818\3\2\2\2\u0818\u0819\5R*\2\u0819\u081a\5T+\2\u081a\u081b\5V,\2\u081b"+
		"\u084a\3\2\2\2\u081c\u0822\7\30\2\2\u081d\u081f\t\20\2\2\u081e\u081d\3"+
		"\2\2\2\u081e\u081f\3\2\2\2\u081f\u0820\3\2\2\2\u0820\u0823\t\17\2\2\u0821"+
		"\u0823\7\u00fe\2\2\u0822\u081e\3\2\2\2\u0822\u0821\3\2\2\2\u0822\u0823"+
		"\3\2\2\2\u0823\u0824\3\2\2\2\u0824\u0828\7s\2\2\u0825\u0826\7\67\2\2\u0826"+
		"\u0827\7O\2\2\u0827\u0829\7\u00a9\2\2\u0828\u0825\3\2\2\2\u0828\u0829"+
		"\3\2\2\2\u0829\u082a\3\2\2\2\u082a\u082b\5\u0184\u00c3\2\u082b\u082c\7"+
		"Q\2\2\u082c\u0843\5\u0088E\2\u082d\u083d\7\u0140\2\2\u082e\u082f\5\u0088"+
		"E\2\u082f\u0830\7\u0086\2\2\u0830\u0834\7\u00d5\2\2\u0831\u0833\5L\'\2"+
		"\u0832\u0831\3\2\2\2\u0833\u0836\3\2\2\2\u0834\u0832\3\2\2\2\u0834\u0835"+
		"\3\2\2\2\u0835\u0839\3\2\2\2\u0836\u0834\3\2\2\2\u0837\u0839\5J&\2\u0838"+
		"\u082e\3\2\2\2\u0838\u0837\3\2\2\2\u0839\u083b\3";
	private static final String _serializedATNSegment1 =
		"\2\2\2\u083a\u083c\7\u0139\2\2\u083b\u083a\3\2\2\2\u083b\u083c\3\2\2\2"+
		"\u083c\u083e\3\2\2\2\u083d\u0838\3\2\2\2\u083e\u083f\3\2\2\2\u083f\u083d"+
		"\3\2\2\2\u083f\u0840\3\2\2\2\u0840\u0841\3\2\2\2\u0841\u0842\7\u0141\2"+
		"\2\u0842\u0844\3\2\2\2\u0843\u082d\3\2\2\2\u0843\u0844\3\2\2\2\u0844\u0845"+
		"\3\2\2\2\u0845\u0846\5R*\2\u0846\u0847\5T+\2\u0847\u0848\5V,\2\u0848\u084a"+
		"\3\2\2\2\u0849\u07d9\3\2\2\2\u0849\u081c\3\2\2\2\u084aG\3\2\2\2\u084b"+
		"\u084c\t\21\2\2\u084c\u084d\t\22\2\2\u084dI\3\2\2\2\u084e\u084f\7\25\2"+
		"\2\u084f\u0851\5\u0088E\2\u0850\u084e\3\2\2\2\u0850\u0851\3\2\2\2\u0851"+
		"\u08b4\3\2\2\2\u0852\u08b5\5N(\2\u0853\u0854\7}\2\2\u0854\u0859\7\u0140"+
		"\2\2\u0855\u0857\5\u0088E\2\u0856\u0858\7\u0139\2\2\u0857\u0856\3\2\2"+
		"\2\u0857\u0858\3\2\2\2\u0858\u085a\3\2\2\2\u0859\u0855\3\2\2\2\u085a\u085b"+
		"\3\2\2\2\u085b\u0859\3\2\2\2\u085b\u085c\3\2\2\2\u085c\u085d\3\2\2\2\u085d"+
		"\u085e\7\u0141\2\2\u085e\u085f\5Z.\2\u085f\u08b5\3\2\2\2\u0860\u0861\7"+
		"[\2\2\u0861\u0862\7H\2\2\u0862\u0867\7\u0140\2\2\u0863\u0865\5\u0088E"+
		"\2\u0864\u0866\7\u0139\2\2\u0865\u0864\3\2\2\2\u0865\u0866\3\2\2\2\u0866"+
		"\u0868\3\2\2\2\u0867\u0863\3\2\2\2\u0868\u0869\3\2\2\2\u0869\u0867\3\2"+
		"\2\2\u0869\u086a\3\2\2\2\u086a\u086b\3\2\2\2\u086b\u086c\7\u0141\2\2\u086c"+
		"\u086d\5Z.\2\u086d\u08b5\3\2\2\2\u086e\u0871\7\'\2\2\u086f\u0870\7\u0080"+
		"\2\2\u0870\u0872\5\u0088E\2\u0871\u086f\3\2\2\2\u0871\u0872\3\2\2\2\u0872"+
		"\u0873\3\2\2\2\u0873\u0874\7\u0140\2\2\u0874\u0875\5\u0088E\2\u0875\u087a"+
		"\7\u0086\2\2\u0876\u0878\5\u0088E\2\u0877\u0879\7\u0139\2\2\u0878\u0877"+
		"\3\2\2\2\u0878\u0879\3\2\2\2\u0879\u087b\3\2\2\2\u087a\u0876\3\2\2\2\u087b"+
		"\u087c\3\2\2\2\u087c\u087a\3\2\2\2\u087c\u087d\3\2\2\2\u087d\u087e\3\2"+
		"\2\2\u087e\u087f\7\u0141\2\2\u087f\u0885\5Z.\2\u0880\u0881\7\u0085\2\2"+
		"\u0881\u0882\7\u0140\2\2\u0882\u0883\5\u0088E\2\u0883\u0884\7\u0141\2"+
		"\2\u0884\u0886\3\2\2\2\u0885\u0880\3\2\2\2\u0885\u0886\3\2\2\2\u0886\u08b5"+
		"\3\2\2\2\u0887\u0888\7-\2\2\u0888\u0889\7H\2\2\u0889\u088e\7\u0140\2\2"+
		"\u088a\u088c\5\u0088E\2\u088b\u088d\7\u0139\2\2\u088c\u088b\3\2\2\2\u088c"+
		"\u088d\3\2\2\2\u088d\u088f\3\2\2\2\u088e\u088a\3\2\2\2\u088f\u0890\3\2"+
		"\2\2\u0890\u088e\3\2\2\2\u0890\u0891\3\2\2\2\u0891\u0892\3\2\2\2\u0892"+
		"\u0893\7\u0141\2\2\u0893\u0894\7b\2\2\u0894\u08a0\5\u0088E\2\u0895\u089a"+
		"\7\u0140\2\2\u0896\u0898\5\u0088E\2\u0897\u0899\7\u0139\2\2\u0898\u0897"+
		"\3\2\2\2\u0898\u0899\3\2\2\2\u0899\u089b\3\2\2\2\u089a\u0896\3\2\2\2\u089b"+
		"\u089c\3\2\2\2\u089c\u089a\3\2\2\2\u089c\u089d\3\2\2\2\u089d\u089e\3\2"+
		"\2\2\u089e\u089f\7\u0141\2\2\u089f\u08a1\3\2\2\2\u08a0\u0895\3\2\2\2\u08a0"+
		"\u08a1\3\2\2\2\u08a1\u08a8\3\2\2\2\u08a2\u08a3\7\u00c4\2\2\u08a3\u08a9"+
		"\7.\2\2\u08a4\u08a5\7\u00c4\2\2\u08a5\u08a9\7\u00d8\2\2\u08a6\u08a7\7"+
		"\u00c4\2\2\u08a7\u08a9\7\u00eb\2\2\u08a8\u08a2\3\2\2\2\u08a8\u08a4\3\2"+
		"\2\2\u08a8\u08a6\3\2\2\2\u08a8\u08a9\3\2\2\2\u08a9\u08ad\3\2\2\2\u08aa"+
		"\u08ab\7\u00d3\2\2\u08ab\u08ac\7\37\2\2\u08ac\u08ae\5X-\2\u08ad\u08aa"+
		"\3\2\2\2\u08ad\u08ae\3\2\2\2\u08ae\u08b2\3\2\2\2\u08af\u08b0\7\u00d3\2"+
		"\2\u08b0\u08b1\7~\2\2\u08b1\u08b3\5X-\2\u08b2\u08af\3\2\2\2\u08b2\u08b3"+
		"\3\2\2\2\u08b3\u08b5\3\2\2\2\u08b4\u0852\3\2\2\2\u08b4\u0853\3\2\2\2\u08b4"+
		"\u0860\3\2\2\2\u08b4\u086e\3\2\2\2\u08b4\u0887\3\2\2\2\u08b5\u08b9\3\2"+
		"\2\2\u08b6\u08ba\7\35\2\2\u08b7\u08b8\7O\2\2\u08b8\u08ba\7\35\2\2\u08b9"+
		"\u08b6\3\2\2\2\u08b9\u08b7\3\2\2\2\u08b9\u08ba\3\2\2\2\u08ba\u08bf\3\2"+
		"\2\2\u08bb\u08bc\7>\2\2\u08bc\u08c0\7\36\2\2\u08bd\u08be\7>\2\2\u08be"+
		"\u08c0\79\2\2\u08bf\u08bb\3\2\2\2\u08bf\u08bd\3\2\2\2\u08bf\u08c0\3\2"+
		"\2\2\u08c0K\3\2\2\2\u08c1\u08c2\7\25\2\2\u08c2\u08c4\5\u0088E\2\u08c3"+
		"\u08c1\3\2\2\2\u08c3\u08c4\3\2\2\2\u08c4\u08e8\3\2\2\2\u08c5\u08c6\7O"+
		"\2\2\u08c6\u08e9\7P\2\2\u08c7\u08e9\7P\2\2\u08c8\u08e9\5N(\2\u08c9\u08cc"+
		"\7\33\2\2\u08ca\u08cd\5\u009aN\2\u08cb\u08cd\5\u00eav\2\u08cc\u08ca\3"+
		"\2\2\2\u08cc\u08cb\3\2\2\2\u08cd\u08e9\3\2\2\2\u08ce\u08cf\7}\2\2\u08cf"+
		"\u08e9\5Z.\2\u08d0\u08d1\7[\2\2\u08d1\u08d2\7H\2\2\u08d2\u08e9\5Z.\2\u08d3"+
		"\u08d4\7b\2\2\u08d4\u08d5\5\u0184\u00c3\2\u08d5\u08dc\5\u0088E\2\u08d6"+
		"\u08d7\7\u00c4\2\2\u08d7\u08dd\7.\2\2\u08d8\u08d9\7\u00c4\2\2\u08d9\u08dd"+
		"\7\u00d8\2\2\u08da\u08db\7\u00c4\2\2\u08db\u08dd\7\u00eb\2\2\u08dc\u08d6"+
		"\3\2\2\2\u08dc\u08d8\3\2\2\2\u08dc\u08da\3\2\2\2\u08dc\u08dd\3\2\2\2\u08dd"+
		"\u08e1\3\2\2\2\u08de\u08df\7\u00d3\2\2\u08df\u08e0\7\37\2\2\u08e0\u08e2"+
		"\5X-\2\u08e1\u08de\3\2\2\2\u08e1\u08e2\3\2\2\2\u08e2\u08e6\3\2\2\2\u08e3"+
		"\u08e4\7\u00d3\2\2\u08e4\u08e5\7~\2\2\u08e5\u08e7\5X-\2\u08e6\u08e3\3"+
		"\2\2\2\u08e6\u08e7\3\2\2\2\u08e7\u08e9\3\2\2\2\u08e8\u08c5\3\2\2\2\u08e8"+
		"\u08c7\3\2\2\2\u08e8\u08c8\3\2\2\2\u08e8\u08c9\3\2\2\2\u08e8\u08ce\3\2"+
		"\2\2\u08e8\u08d0\3\2\2\2\u08e8\u08d3\3\2\2\2\u08e9\u08ed\3\2\2\2\u08ea"+
		"\u08ee\7\35\2\2\u08eb\u08ec\7O\2\2\u08ec\u08ee\7\35\2\2\u08ed\u08ea\3"+
		"\2\2\2\u08ed\u08eb\3\2\2\2\u08ed\u08ee\3\2\2\2\u08ee\u08f3\3\2\2\2\u08ef"+
		"\u08f0\7>\2\2\u08f0\u08f4\7\36\2\2\u08f1\u08f2\7>\2\2\u08f2\u08f4\79\2"+
		"\2\u08f3\u08ef\3\2\2\2\u08f3\u08f1\3\2\2\2\u08f3\u08f4\3\2\2\2\u08f4M"+
		"\3\2\2\2\u08f5\u08f6\7\u0091\2\2\u08f6\u08f7\7\u0140\2\2\u08f7\u08f8\5"+
		"\u0114\u008b\2\u08f8\u08f9\7\u0141\2\2\u08f9O\3\2\2\2\u08fa\u08fb\7\u0086"+
		"\2\2\u08fb\u0904\7\u0140\2\2\u08fc\u08ff\5\u0088E\2\u08fd\u08fe\7\u0136"+
		"\2\2\u08fe\u0900\5\u0088E\2\u08ff\u08fd\3\2\2\2\u08ff\u0900\3\2\2\2\u0900"+
		"\u0902\3\2\2\2\u0901\u0903\7\u0139\2\2\u0902\u0901\3\2\2\2\u0902\u0903"+
		"\3\2\2\2\u0903\u0905\3\2\2\2\u0904\u08fc\3\2\2\2\u0905\u0906\3\2\2\2\u0906"+
		"\u0904\3\2\2\2\u0906\u0907\3\2\2\2\u0907\u0908\3\2\2\2\u0908\u0909\7\u0141"+
		"\2\2\u0909Q\3\2\2\2\u090a\u0910\5P)\2\u090b\u090c\7\u0086\2\2\u090c\u0910"+
		"\7R\2\2\u090d\u090e\7\u0087\2\2\u090e\u0910\7R\2\2\u090f\u090a\3\2\2\2"+
		"\u090f\u090b\3\2\2\2\u090f\u090d\3\2\2\2\u090f\u0910\3\2\2\2\u0910S\3"+
		"\2\2\2\u0911\u0912\7\u00d3\2\2\u0912\u0918\7\u0097\2\2\u0913\u0914\7Z"+
		"\2\2\u0914\u0919\7a\2\2\u0915\u0916\7\37\2\2\u0916\u0919\7a\2\2\u0917"+
		"\u0919\7\u00a6\2\2\u0918\u0913\3\2\2\2\u0918\u0915\3\2\2\2\u0918\u0917"+
		"\3\2\2\2\u0919\u091b\3\2\2\2\u091a\u0911\3\2\2\2\u091a\u091b\3\2\2\2\u091b"+
		"U\3\2\2\2\u091c\u091d\7\u00f3\2\2\u091d\u091f\5\u0088E\2\u091e\u091c\3"+
		"\2\2\2\u091e\u091f\3\2\2\2\u091fW\3\2\2\2\u0920\u0927\7d\2\2\u0921\u0927"+
		"\7\20\2\2\u0922\u0923\7\u00e9\2\2\u0923\u0927\7P\2\2\u0924\u0925\7\u00e9"+
		"\2\2\u0925\u0927\7\33\2\2\u0926\u0920\3\2\2\2\u0926\u0921\3\2\2\2\u0926"+
		"\u0922\3\2\2\2\u0926\u0924\3\2\2\2\u0927Y\3\2\2\2\u0928\u092a\5P)\2\u0929"+
		"\u0928\3\2\2\2\u0929\u092a\3\2\2\2\u092a\u092f\3\2\2\2\u092b\u092c\7\u0080"+
		"\2\2\u092c\u092d\7\u00b4\2\2\u092d\u092e\7\u00f3\2\2\u092e\u0930\5\u0088"+
		"E\2\u092f\u092b\3\2\2\2\u092f\u0930\3\2\2\2\u0930[\3\2\2\2\u0931\u0932"+
		"\7\u0140\2\2\u0932\u0937\5^\60\2\u0933\u0934\7\u0139\2\2\u0934\u0936\5"+
		"^\60\2\u0935\u0933\3\2\2\2\u0936\u0939\3\2\2\2\u0937\u0935\3\2\2\2\u0937"+
		"\u0938\3\2\2\2\u0938\u093a\3\2\2\2\u0939\u0937\3\2\2\2\u093a\u093b\7\u0141"+
		"\2\2\u093b]\3\2\2\2\u093c\u093d\5\u0088E\2\u093d\u093e\5`\61\2\u093e_"+
		"\3\2\2\2\u093f\u0940\5\u009aN\2\u0940a\3\2\2\2\u0941\u0942\7\u0086\2\2"+
		"\u0942\u0943\7\u0140\2\2\u0943\u0948\5d\63\2\u0944\u0945\7\u0139\2\2\u0945"+
		"\u0947\5d\63\2\u0946\u0944\3\2\2\2\u0947\u094a\3\2\2\2\u0948\u0946\3\2"+
		"\2\2\u0948\u0949\3\2\2\2\u0949\u094b\3\2\2\2\u094a\u0948\3\2\2\2\u094b"+
		"\u094c\7\u0141\2\2\u094cc\3\2\2\2\u094d\u094e\7\u0156\2\2\u094e\u094f"+
		"\7\u0136\2\2\u094f\u0950\5\u00eex\2\u0950e\3\2\2\2\u0951\u0952\7\u0080"+
		"\2\2\u0952\u0953\5\u0088E\2\u0953g\3\2\2\2\u0954\u0955\7\u00f3\2\2\u0955"+
		"\u0956\5j\66\2\u0956i\3\2\2\2\u0957\u0958\5\u0088E\2\u0958k\3\2\2\2\u0959"+
		"\u095e\5n8\2\u095a\u095e\5t;\2\u095b\u095e\5|?\2\u095c\u095e\5\u0082B"+
		"\2\u095d\u0959\3\2\2\2\u095d\u095a\3\2\2\2\u095d\u095b\3\2\2\2\u095d\u095c"+
		"\3\2\2\2\u095em\3\2\2\2\u095f\u0960\7\u00d9\2\2\u0960\u0961\7\u008b\2"+
		"\2\u0961\u0962\7\u00df\2\2\u0962\u0963\7\u0140\2\2\u0963\u0964\5\u0196"+
		"\u00cc\2\u0964\u0965\7\u0141\2\2\u0965\u0966\7\u0140\2\2\u0966\u0967\5"+
		"p9\2\u0967\u0968\7\u0141\2\2\u0968o\3\2\2\2\u0969\u096e\5r:\2\u096a\u096b"+
		"\7\u0139\2\2\u096b\u096d\5r:\2\u096c\u096a\3\2\2\2\u096d\u0970\3\2\2\2"+
		"\u096e\u096c\3\2\2\2\u096e\u096f\3\2\2\2\u096fq\3\2\2\2\u0970\u096e\3"+
		"\2\2\2\u0971\u0972\7\u00d9\2\2\u0972\u0973\5\u0084C\2\u0973\u0974\7\u00ff"+
		"\2\2\u0974\u0975\7\u00c1\2\2\u0975\u0981\7\u00f6\2\2\u0976\u0977\7\u0140"+
		"\2\2\u0977\u0978\5\u00eav\2\u0978\u0979\7\u0141\2\2\u0979\u0982\3\2\2"+
		"\2\u097a\u097c\7\u0140\2\2\u097b\u097a\3\2\2\2\u097b\u097c\3\2\2\2\u097c"+
		"\u097d\3\2\2\2\u097d\u097f\7\u00c6\2\2\u097e\u0980\7\u0141\2\2\u097f\u097e"+
		"\3\2\2\2\u097f\u0980\3\2\2\2\u0980\u0982\3\2\2\2\u0981\u0976\3\2\2\2\u0981"+
		"\u097b\3\2\2\2\u0982s\3\2\2\2\u0983\u0984\7\u00d9\2\2\u0984\u0985\7\u008b"+
		"\2\2\u0985\u0986\7\u00b2\2\2\u0986\u0987\7\u0140\2\2\u0987\u0988\5\u0196"+
		"\u00cc\2\u0988\u098e\7\u0141\2\2\u0989\u098a\7\u0140\2\2\u098a\u098b\5"+
		"v<\2\u098b\u098c\7\u0141\2\2\u098c\u098f\3\2\2\2\u098d\u098f\5z>\2\u098e"+
		"\u0989\3\2\2\2\u098e\u098d\3\2\2\2\u098fu\3\2\2\2\u0990\u0995\5x=\2\u0991"+
		"\u0992\7\u0139\2\2\u0992\u0994\5x=\2\u0993\u0991\3\2\2\2\u0994\u0997\3"+
		"\2\2\2\u0995\u0993\3\2\2\2\u0995\u0996\3\2\2\2\u0996w\3\2\2\2\u0997\u0995"+
		"\3\2\2\2\u0998\u0999\7\u00d9\2\2\u0999\u099a\5\u0084C\2\u099ay\3\2\2\2"+
		"\u099b\u099c\7\u00da\2\2\u099c\u099d\5\u00eex\2\u099d{\3\2\2\2\u099e\u099f"+
		"\7\u00d9\2\2\u099f\u09a0\7\u008b\2\2\u09a0\u09a1\7\u00c2\2\2\u09a1\u09a2"+
		"\7\u0140\2\2\u09a2\u09a3\5\u0196\u00cc\2\u09a3\u09a4\7\u0141\2\2\u09a4"+
		"\u09a5\7\u0140\2\2\u09a5\u09a6\5~@\2\u09a6\u09a7\7\u0141\2\2\u09a7}\3"+
		"\2\2\2\u09a8\u09ad\5\u0080A\2\u09a9\u09aa\7\u0139\2\2\u09aa\u09ac\5\u0080"+
		"A\2\u09ab\u09a9\3\2\2\2\u09ac\u09af\3\2\2\2\u09ad\u09ab\3\2\2\2\u09ad"+
		"\u09ae\3\2\2\2\u09ae\177\3\2\2\2\u09af\u09ad\3\2\2\2\u09b0\u09b1\7\u00d9"+
		"\2\2\u09b1\u09b2\5\u0084C\2\u09b2\u09b4\7\u00ff\2\2\u09b3\u09b5\7;\2\2"+
		"\u09b4\u09b3\3\2\2\2\u09b4\u09b5\3\2\2\2\u09b5\u09b6\3\2\2\2\u09b6\u09b7"+
		"\7\u0140\2\2\u09b7\u09b8\5\u01ae\u00d8\2\u09b8\u09b9\7\u0141\2\2\u09b9"+
		"\u0081\3\2\2\2\u09ba\u09bb\7\u00d9\2\2\u09bb\u09bc\7\u008b\2\2\u09bc\u09bd"+
		"\7\u0094\2\2\u09bd\u09be\5\\/\2\u09be\u0083\3\2\2\2\u09bf\u09c0\5\u0088"+
		"E\2\u09c0\u0085\3\2\2\2\u09c1\u09c2\7\u00a6\2\2\u09c2\u09c3\7s\2\2\u09c3"+
		"\u09c5\5\u0184\u00c3\2\u09c4\u09c6\7\u00dd\2\2\u09c5\u09c4\3\2\2\2\u09c5"+
		"\u09c6\3\2\2\2\u09c6\u0087\3\2\2\2\u09c7\u09d1\7\u0153\2\2\u09c8\u09d1"+
		"\7\u0154\2\2\u09c9\u09cb\7\u014b\2\2\u09ca\u09c9\3\2\2\2\u09ca\u09cb\3"+
		"\2\2\2\u09cb\u09cc\3\2\2\2\u09cc\u09ce\5\u008aF\2\u09cd\u09cf\7\u014b"+
		"\2\2\u09ce\u09cd\3\2\2\2\u09ce\u09cf\3\2\2\2\u09cf\u09d1\3\2\2\2\u09d0"+
		"\u09c7\3\2\2\2\u09d0\u09c8\3\2\2\2\u09d0\u09ca\3\2\2\2\u09d1\u0089\3\2"+
		"\2\2\u09d2\u09d3\t\23\2\2\u09d3\u008b\3\2\2\2\u09d4\u09d7\5\u00c2b\2\u09d5"+
		"\u09d7\5\u008eH\2\u09d6\u09d4\3\2\2\2\u09d6\u09d5\3\2\2\2\u09d7\u008d"+
		"\3\2\2\2\u09d8\u09dc\7\u0156\2\2\u09d9\u09dc\5\u0090I\2\u09da\u09dc\5"+
		"\u0098M\2\u09db\u09d8\3\2\2\2\u09db\u09d9\3\2\2\2\u09db\u09da\3\2\2\2"+
		"\u09dc\u008f\3\2\2\2\u09dd\u09e1\5\u0094K\2\u09de\u09e1\5\u0092J\2\u09df"+
		"\u09e1\5\u0096L\2\u09e0\u09dd\3\2\2\2\u09e0\u09de\3\2\2\2\u09e0\u09df"+
		"\3\2\2\2\u09e1\u0091\3\2\2\2\u09e2\u09e3\7\u0124\2\2\u09e3\u09e4\7\u0156"+
		"\2\2\u09e4\u0093\3\2\2\2\u09e5\u09e6\7\u0126\2\2\u09e6\u09e7\7\u0156\2"+
		"\2\u09e7\u0095\3\2\2\2\u09e8\u09e9\7\u0123\2\2\u09e9\u09ea\7\u0156\2\2"+
		"\u09ea\u0097\3\2\2\2\u09eb\u09ec\t\24\2\2\u09ec\u0099\3\2\2\2\u09ed\u09f1"+
		"\5\u009cO\2\u09ee\u09ef\7n\2\2\u09ef\u09f1\5\u0088E\2\u09f0\u09ed\3\2"+
		"\2\2\u09f0\u09ee\3\2\2\2\u09f1\u009b\3\2\2\2\u09f2\u0a00\5\u00a2R\2\u09f3"+
		"\u0a00\5\u00a6T\2\u09f4\u0a00\5\u00a8U\2\u09f5\u0a00\5\u00aaV\2\u09f6"+
		"\u0a00\5\u00b2Z\2\u09f7\u0a00\5\u00b4[\2\u09f8\u0a00\5\u00b6\\\2\u09f9"+
		"\u0a00\5\u00b8]\2\u09fa\u0a00\5\u00a0Q\2\u09fb\u0a00\5\u009eP\2\u09fc"+
		"\u0a00\7y\2\2\u09fd\u0a00\7\u0129\2\2\u09fe\u0a00\7\u012f\2\2\u09ff\u09f2"+
		"\3\2\2\2\u09ff\u09f3\3\2\2\2\u09ff\u09f4\3\2\2\2\u09ff\u09f5\3\2\2\2\u09ff"+
		"\u09f6\3\2\2\2\u09ff\u09f7\3\2\2\2\u09ff\u09f8\3\2\2\2\u09ff\u09f9\3\2"+
		"\2\2\u09ff\u09fa\3\2\2\2\u09ff\u09fb\3\2\2\2\u09ff\u09fc\3\2\2\2\u09ff"+
		"\u09fd\3\2\2\2\u09ff\u09fe\3\2\2\2\u0a00\u009d\3\2\2\2\u0a01\u0a02\7\u011a"+
		"\2\2\u0a02\u009f\3\2\2\2\u0a03\u0a04\7\u012e\2\2\u0a04\u00a1\3\2\2\2\u0a05"+
		"\u0a07\7\u0090\2\2\u0a06\u0a08\5\u00a4S\2\u0a07\u0a06\3\2\2\2\u0a07\u0a08"+
		"\3\2\2\2\u0a08\u0a1d\3\2\2\2\u0a09\u0a0b\7\u011f\2\2\u0a0a\u0a0c\5\u00a4"+
		"S\2\u0a0b\u0a0a\3\2\2\2\u0a0b\u0a0c\3\2\2\2\u0a0c\u0a1d\3\2\2\2\u0a0d"+
		"\u0a0e\7\u0090\2\2\u0a0e\u0a10\7\u0102\2\2\u0a0f\u0a11\5\u00a4S\2\u0a10"+
		"\u0a0f\3\2\2\2\u0a10\u0a11\3\2\2\2\u0a11\u0a1d\3\2\2\2\u0a12\u0a13\7\u011f"+
		"\2\2\u0a13\u0a15\7\u0102\2\2\u0a14\u0a16\5\u00a4S\2\u0a15\u0a14\3\2\2"+
		"\2\u0a15\u0a16\3\2\2\2\u0a16\u0a1d\3\2\2\2\u0a17\u0a19\7\u0120\2\2\u0a18"+
		"\u0a1a\5\u00a4S\2\u0a19\u0a18\3\2\2\2\u0a19\u0a1a\3\2\2\2\u0a1a\u0a1d"+
		"\3\2\2\2\u0a1b\u0a1d\7\u0128\2\2\u0a1c\u0a05\3\2\2\2\u0a1c\u0a09\3\2\2"+
		"\2\u0a1c\u0a0d\3\2\2\2\u0a1c\u0a12\3\2\2\2\u0a1c\u0a17\3\2\2\2\u0a1c\u0a1b"+
		"\3\2\2\2\u0a1d\u00a3\3\2\2\2\u0a1e\u0a1f\7\u0140\2\2\u0a1f\u0a20\7\u014f"+
		"\2\2\u0a20\u0a21\7\u0141\2\2\u0a21\u00a5\3\2\2\2\u0a22\u0a23\7\u00ce\2"+
		"\2\u0a23\u0a25\7\u0090\2\2\u0a24\u0a26\5\u00a4S\2\u0a25\u0a24\3\2\2\2"+
		"\u0a25\u0a26\3\2\2\2\u0a26\u0a46\3\2\2\2\u0a27\u0a28\7\u00ce\2\2\u0a28"+
		"\u0a2a\7\u011f\2\2\u0a29\u0a2b\5\u00a4S\2\u0a2a\u0a29\3\2\2\2\u0a2a\u0a2b"+
		"\3\2\2\2\u0a2b\u0a46\3\2\2\2\u0a2c\u0a2e\7\u0121\2\2\u0a2d\u0a2f\5\u00a4"+
		"S\2\u0a2e\u0a2d\3\2\2\2\u0a2e\u0a2f\3\2\2\2\u0a2f\u0a46\3\2\2\2\u0a30"+
		"\u0a31\7\u00ce\2\2\u0a31\u0a32\7\u0090\2\2\u0a32\u0a34\7\u0102\2\2\u0a33"+
		"\u0a35\5\u00a4S\2\u0a34\u0a33\3\2\2\2\u0a34\u0a35\3\2\2\2\u0a35\u0a46"+
		"\3\2\2\2\u0a36\u0a37\7\u00ce\2\2\u0a37\u0a38\7\u011f\2\2\u0a38\u0a3a\7"+
		"\u0102\2\2\u0a39\u0a3b\5\u00a4S\2\u0a3a\u0a39\3\2\2\2\u0a3a\u0a3b\3\2"+
		"\2\2\u0a3b\u0a46\3\2\2\2\u0a3c\u0a3d\7\u0121\2\2\u0a3d\u0a3f\7\u0102\2"+
		"\2\u0a3e\u0a40\5\u00a4S\2\u0a3f\u0a3e\3\2\2\2\u0a3f\u0a40\3\2\2\2\u0a40"+
		"\u0a46\3\2\2\2\u0a41\u0a43\7\u0122\2\2\u0a42\u0a44\5\u00a4S\2\u0a43\u0a42"+
		"\3\2\2\2\u0a43\u0a44\3\2\2\2\u0a44\u0a46\3\2\2\2\u0a45\u0a22\3\2\2\2\u0a45"+
		"\u0a27\3\2\2\2\u0a45\u0a2c\3\2\2\2\u0a45\u0a30\3\2\2\2\u0a45\u0a36\3\2"+
		"\2\2\u0a45\u0a3c\3\2\2\2\u0a45\u0a41\3\2\2\2\u0a46\u00a7\3\2\2\2\u0a47"+
		"\u0a49\7\u012c\2\2\u0a48\u0a4a\5\u00a4S\2\u0a49\u0a48\3\2\2\2\u0a49\u0a4a"+
		"\3\2\2\2\u0a4a\u0a50\3\2\2\2\u0a4b\u0a4d\7\u012d\2\2\u0a4c\u0a4e\5\u00a4"+
		"S\2\u0a4d\u0a4c\3\2\2\2\u0a4d\u0a4e\3\2\2\2\u0a4e\u0a50\3\2\2\2\u0a4f"+
		"\u0a47\3\2\2\2\u0a4f\u0a4b\3\2\2\2\u0a50\u00a9\3\2\2\2\u0a51\u0a54\5\u00ac"+
		"W\2\u0a52\u0a54\5\u00aeX\2\u0a53\u0a51\3\2\2\2\u0a53\u0a52\3\2\2\2\u0a54"+
		"\u00ab\3\2\2\2\u0a55\u0a57\7\u011d\2\2\u0a56\u0a58\5\u00b0Y\2\u0a57\u0a56"+
		"\3\2\2\2\u0a57\u0a58\3\2\2\2\u0a58\u0a6b\3\2\2\2\u0a59\u0a5b\7\u011e\2"+
		"\2\u0a5a\u0a5c\5\u00b0Y\2\u0a5b\u0a5a\3\2\2\2\u0a5b\u0a5c\3\2\2\2\u0a5c"+
		"\u0a6b\3\2\2\2\u0a5d\u0a5f\7\u00a0\2\2\u0a5e\u0a60\5\u00b0Y\2\u0a5f\u0a5e"+
		"\3\2\2\2\u0a5f\u0a60\3\2\2\2\u0a60\u0a6b\3\2\2\2\u0a61\u0a6b\7\u010e\2"+
		"\2\u0a62\u0a6b\7\u0112\2\2\u0a63\u0a6b\7\u010f\2\2\u0a64\u0a6b\7\u0113"+
		"\2\2\u0a65\u0a6b\7\u0110\2\2\u0a66\u0a6b\7\u0114\2\2\u0a67\u0a6b\7\u0115"+
		"\2\2\u0a68\u0a6b\7\u0111\2\2\u0a69\u0a6b\7\u0116\2\2\u0a6a\u0a55\3\2\2"+
		"\2\u0a6a\u0a59\3\2\2\2\u0a6a\u0a5d\3\2\2\2\u0a6a\u0a61\3\2\2\2\u0a6a\u0a62"+
		"\3\2\2\2\u0a6a\u0a63\3\2\2\2\u0a6a\u0a64\3\2\2\2\u0a6a\u0a65\3\2\2\2\u0a6a"+
		"\u0a66\3\2\2\2\u0a6a\u0a67\3\2\2\2\u0a6a\u0a68\3\2\2\2\u0a6a\u0a69\3\2"+
		"\2\2\u0a6b\u00ad\3\2\2\2\u0a6c\u0a6e\7\u011b\2\2\u0a6d\u0a6f\5\u00b0Y"+
		"\2\u0a6e\u0a6d\3\2\2\2\u0a6e\u0a6f\3\2\2\2\u0a6f\u0a77\3\2\2\2\u0a70\u0a77"+
		"\7\u0117\2\2\u0a71\u0a77\7\u0119\2\2\u0a72\u0a77\7\u0118\2\2\u0a73\u0a77"+
		"\7\u011c\2\2\u0a74\u0a75\7\u011c\2\2\u0a75\u0a77\7\u00db\2\2\u0a76\u0a6c"+
		"\3\2\2\2\u0a76\u0a70\3\2\2\2\u0a76\u0a71\3\2\2\2\u0a76\u0a72\3\2\2\2\u0a76"+
		"\u0a73\3\2\2\2\u0a76\u0a74\3\2\2\2\u0a77\u00af\3\2\2\2\u0a78\u0a79\7\u0140"+
		"\2\2\u0a79\u0a7a\7\u014f\2\2\u0a7a\u0a81\7\u0141\2\2\u0a7b\u0a7c\7\u0140"+
		"\2\2\u0a7c\u0a7d\7\u014f\2\2\u0a7d\u0a7e\7\u0139\2\2\u0a7e\u0a7f\7\u014f"+
		"\2\2\u0a7f\u0a81\7\u0141\2\2\u0a80\u0a78\3\2\2\2\u0a80\u0a7b\3\2\2\2\u0a81"+
		"\u00b1\3\2\2\2\u0a82\u0a83\t\25\2\2\u0a83\u00b3\3\2\2\2\u0a84\u0a96\7"+
		"\u0123\2\2\u0a85\u0a96\7\u0124\2\2\u0a86\u0a87\7\u0124\2\2\u0a87\u0a88"+
		"\7\u0086\2\2\u0a88\u0a89\7\u0124\2\2\u0a89\u0a96\7\u0109\2\2\u0a8a\u0a96"+
		"\7\u0125\2\2\u0a8b\u0a96\7\u0126\2\2\u0a8c\u0a8d\7\u0126\2\2\u0a8d\u0a8e"+
		"\7\u0086\2\2\u0a8e\u0a8f\7\u0124\2\2\u0a8f\u0a96\7\u0109\2\2\u0a90\u0a91"+
		"\7\u0126\2\2\u0a91\u0a92\7\u0087\2\2\u0a92\u0a93\7\u0124\2\2\u0a93\u0a96"+
		"\7\u0109\2\2\u0a94\u0a96\7\u0127\2\2\u0a95\u0a84\3\2\2\2\u0a95\u0a85\3"+
		"\2\2\2\u0a95\u0a86\3\2\2\2\u0a95\u0a8a\3\2\2\2\u0a95\u0a8b\3\2\2\2\u0a95"+
		"\u0a8c\3\2\2\2\u0a95\u0a90\3\2\2\2\u0a95\u0a94\3\2\2\2\u0a96\u00b5\3\2"+
		"\2\2\u0a97\u0a99\7\u010c\2\2\u0a98\u0a9a\5\u00a4S\2\u0a99\u0a98\3\2\2"+
		"\2\u0a99\u0a9a\3\2\2\2\u0a9a\u0aa5\3\2\2\2\u0a9b\u0a9d\7\u010d\2\2\u0a9c"+
		"\u0a9e\5\u00a4S\2\u0a9d\u0a9c\3\2\2\2\u0a9d\u0a9e\3\2\2\2\u0a9e\u0aa5"+
		"\3\2\2\2\u0a9f\u0aa0\7\u010c\2\2\u0aa0\u0aa2\7\u0102\2\2\u0aa1\u0aa3\5"+
		"\u00a4S\2\u0aa2\u0aa1\3\2\2\2\u0aa2\u0aa3\3\2\2\2\u0aa3\u0aa5\3\2\2\2"+
		"\u0aa4\u0a97\3\2\2\2\u0aa4\u0a9b\3\2\2\2\u0aa4\u0a9f\3\2\2\2\u0aa5\u00b7"+
		"\3\2\2\2\u0aa6\u0aa8\7\u012a\2\2\u0aa7\u0aa9\5\u00a4S\2\u0aa8\u0aa7\3"+
		"\2\2\2\u0aa8\u0aa9\3\2\2\2\u0aa9\u0ab4\3\2\2\2\u0aaa\u0aab\7\u012a\2\2"+
		"\u0aab\u0aad\7\u0102\2\2\u0aac\u0aae\5\u00a4S\2\u0aad\u0aac\3\2\2\2\u0aad"+
		"\u0aae\3\2\2\2\u0aae\u0ab4\3\2\2\2\u0aaf\u0ab1\7\u012b\2\2\u0ab0\u0ab2"+
		"\5\u00a4S\2\u0ab1\u0ab0\3\2\2\2\u0ab1\u0ab2\3\2\2\2\u0ab2\u0ab4\3\2\2"+
		"\2\u0ab3\u0aa6\3\2\2\2\u0ab3\u0aaa\3\2\2\2\u0ab3\u0aaf\3\2\2\2\u0ab4\u00b9"+
		"\3\2\2\2\u0ab5\u0ab8\5\u00bc_\2\u0ab6\u0ab8\5\u00be`\2\u0ab7\u0ab5\3\2"+
		"\2\2\u0ab7\u0ab6\3\2\2\2\u0ab8\u00bb\3\2\2\2\u0ab9\u0aba\7\u0140\2\2\u0aba"+
		"\u0abb\5\u00eav\2\u0abb\u0abc\7\u0141\2\2\u0abc\u00bd\3\2\2\2\u0abd\u0ac5"+
		"\5\u00c0a\2\u0abe\u0ac5\5\u0192\u00ca\2\u0abf\u0ac5\5\u00c6d\2\u0ac0\u0ac5"+
		"\5\u0198\u00cd\2\u0ac1\u0ac5\5\u00d2j\2\u0ac2\u0ac5\5\u00e4s\2\u0ac3\u0ac5"+
		"\5\u01cc\u00e7\2\u0ac4\u0abd\3\2\2\2\u0ac4\u0abe\3\2\2\2\u0ac4\u0abf\3"+
		"\2\2\2\u0ac4\u0ac0\3\2\2\2\u0ac4\u0ac1\3\2\2\2\u0ac4\u0ac2\3\2\2\2\u0ac4"+
		"\u0ac3\3\2\2\2\u0ac5\u00bf\3\2\2\2\u0ac6\u0ac7\5\u008cG\2\u0ac7\u00c1"+
		"\3\2\2\2\u0ac8\u0ac9\t\26\2\2\u0ac9\u00c3\3\2\2\2\u0aca\u0acc\5\u00f8"+
		"}\2\u0acb\u0aca\3\2\2\2\u0acb\u0acc\3\2\2\2\u0acc\u0acd\3\2\2\2\u0acd"+
		"\u0ace\5\u00c2b\2\u0ace\u00c5\3\2\2\2\u0acf\u0ad0\5\u00c8e\2\u0ad0\u00c7"+
		"\3\2\2\2\u0ad1\u0ad2\7\u009a\2\2\u0ad2\u0ad3\7\u0140\2\2\u0ad3\u0ad4\7"+
		"\u0144\2\2\u0ad4\u0ada\7\u0141\2\2\u0ad5\u0ad7\5\u00caf\2\u0ad6\u0ad8"+
		"\5\u00ceh\2\u0ad7\u0ad6\3\2\2\2\u0ad7\u0ad8\3\2\2\2\u0ad8\u0ada\3\2\2"+
		"\2\u0ad9\u0ad1\3\2\2\2\u0ad9\u0ad5\3\2\2\2\u0ada\u00c9\3\2\2\2\u0adb\u0adc"+
		"\5\u00ccg\2\u0adc\u0ade\7\u0140\2\2\u0add\u0adf\5\u0190\u00c9\2\u0ade"+
		"\u0add\3\2\2\2\u0ade\u0adf\3\2\2\2\u0adf\u0ae0\3\2\2\2\u0ae0\u0ae1\5\u00ea"+
		"v\2\u0ae1\u0ae2\7\u0141\2\2\u0ae2\u00cb\3\2\2\2\u0ae3\u0ae4\t\27\2\2\u0ae4"+
		"\u00cd\3\2\2\2\u0ae5\u0ae6\7\u00ad\2\2\u0ae6\u0ae7\7\u0140\2\2\u0ae7\u0ae8"+
		"\7\u0085\2\2\u0ae8\u0ae9\5\u015a\u00ae\2\u0ae9\u0aea\7\u0141\2\2\u0aea"+
		"\u00cf\3\2\2\2\u0aeb\u0aec\7\u00b1\2\2\u0aec\u0aed\7\u0140\2\2\u0aed\u0aee"+
		"\5\u0196\u00cc\2\u0aee\u0aef\7\u0141\2\2\u0aef\u00d1\3\2\2\2\u0af0\u0af1"+
		"\5\u00d6l\2\u0af1\u00d3\3\2\2\2\u0af2\u0af3\7\u00d1\2\2\u0af3\u0af4\7"+
		"\u0140\2\2\u0af4\u0af5\5\u00eex\2\u0af5\u0af6\7\u0139\2\2\u0af6\u0af7"+
		"\5\u0114\u008b\2\u0af7\u0af8\7\u0141\2\2\u0af8\u0b05\3\2\2\2\u0af9\u0afa"+
		"\7\u0093\2\2\u0afa\u0afb\7\u0140\2\2\u0afb\u0afe\5\u00eex\2\u0afc\u0afd"+
		"\7\u0139\2\2\u0afd\u0aff\5\u0114\u008b\2\u0afe\u0afc\3\2\2\2\u0aff\u0b00"+
		"\3\2\2\2\u0b00\u0afe\3\2\2\2\u0b00\u0b01\3\2\2\2\u0b01\u0b02\3\2\2\2\u0b02"+
		"\u0b03\7\u0141\2\2\u0b03\u0b05\3\2\2\2\u0b04\u0af2\3\2\2\2\u0b04\u0af9"+
		"\3\2\2\2\u0b05\u00d5\3\2\2\2\u0b06\u0b09\5\u00d8m\2\u0b07\u0b09\5\u00da"+
		"n\2\u0b08\u0b06\3\2\2\2\u0b08\u0b07\3\2\2\2\u0b09\u00d7\3\2\2\2\u0b0a"+
		"\u0b0b\7\17\2\2\u0b0b\u0b0d\5\u0114\u008b\2\u0b0c\u0b0e\5\u00dco\2\u0b0d"+
		"\u0b0c\3\2\2\2\u0b0e\u0b0f\3\2\2\2\u0b0f\u0b0d\3\2\2\2\u0b0f\u0b10\3\2"+
		"\2\2\u0b10\u0b12\3\2\2\2\u0b11\u0b13\5\u00e0q\2\u0b12\u0b11\3\2\2\2\u0b12"+
		"\u0b13\3\2\2\2\u0b13\u0b14\3\2\2\2\u0b14\u0b15\7$\2\2\u0b15\u00d9\3\2"+
		"\2\2\u0b16\u0b18\7\17\2\2\u0b17\u0b19\5\u00dep\2\u0b18\u0b17\3\2\2\2\u0b19"+
		"\u0b1a\3\2\2\2\u0b1a\u0b18\3\2\2\2\u0b1a\u0b1b\3\2\2\2\u0b1b\u0b1d\3\2"+
		"\2\2\u0b1c\u0b1e\5\u00e0q\2\u0b1d\u0b1c\3\2\2\2\u0b1d\u0b1e\3\2\2\2\u0b1e"+
		"\u0b1f\3\2\2\2\u0b1f\u0b20\7$\2\2\u0b20\u00db\3\2\2\2\u0b21\u0b22\7\u0084"+
		"\2\2\u0b22\u0b23\5\u015a\u00ae\2\u0b23\u0b24\7v\2\2\u0b24\u0b25\5\u00e2"+
		"r\2\u0b25\u00dd\3\2\2\2\u0b26\u0b27\7\u0084\2\2\u0b27\u0b28\5\u015a\u00ae"+
		"\2\u0b28\u0b29\7v\2\2\u0b29\u0b2a\5\u00e2r\2\u0b2a\u00df\3\2\2\2\u0b2b"+
		"\u0b2c\7%\2\2\u0b2c\u0b2d\5\u00e2r\2\u0b2d\u00e1\3\2\2\2\u0b2e\u0b31\5"+
		"\u00eav\2\u0b2f\u0b31\7P\2\2\u0b30\u0b2e\3\2\2\2\u0b30\u0b2f\3\2\2\2\u0b31"+
		"\u00e3\3\2\2\2\u0b32\u0b33\7\21\2\2\u0b33\u0b34\7\u0140\2\2\u0b34\u0b35"+
		"\5\u00e6t\2\u0b35\u0b36\7\5\2\2\u0b36\u0b37\5\u00e8u\2\u0b37\u0b38\7\u0141"+
		"\2\2\u0b38\u00e5\3\2\2\2\u0b39\u0b3a\5\u00eav\2\u0b3a\u00e7\3\2\2\2\u0b3b"+
		"\u0b3c\5\u009aN\2\u0b3c\u00e9\3\2\2\2\u0b3d\u0b41\5\u00ecw\2\u0b3e\u0b41"+
		"\5\u0128\u0095\2\u0b3f\u0b41\5\u0114\u008b\2\u0b40\u0b3d\3\2\2\2\u0b40"+
		"\u0b3e\3\2\2\2\u0b40\u0b3f\3\2\2\2\u0b41\u00eb\3\2\2\2\u0b42\u0b46\5\u00ee"+
		"x\2\u0b43\u0b46\5\u0104\u0083\2\u0b44\u0b46\7P\2\2\u0b45\u0b42\3\2\2\2"+
		"\u0b45\u0b43\3\2\2\2\u0b45\u0b44\3\2\2\2\u0b46\u00ed\3\2\2\2\u0b47\u0b4c"+
		"\5\u00f0y\2\u0b48\u0b49\t\30\2\2\u0b49\u0b4b\5\u00f0y\2\u0b4a\u0b48\3"+
		"\2\2\2\u0b4b\u0b4e\3\2\2\2\u0b4c\u0b4a\3\2\2\2\u0b4c\u0b4d\3\2\2\2\u0b4d"+
		"\u00ef\3\2\2\2\u0b4e\u0b4c\3\2\2\2\u0b4f\u0b54\5\u00f2z\2\u0b50\u0b51"+
		"\t\31\2\2\u0b51\u0b53\5\u00f2z\2\u0b52\u0b50\3\2\2\2\u0b53\u0b56\3\2\2"+
		"\2\u0b54\u0b52\3\2\2\2\u0b54\u0b55\3\2\2\2\u0b55\u00f1\3\2\2\2\u0b56\u0b54"+
		"\3\2\2\2\u0b57\u0b59\5\u00f8}\2\u0b58\u0b57\3\2\2\2\u0b58\u0b59\3\2\2"+
		"\2\u0b59\u0b5a\3\2\2\2\u0b5a\u0b5b\5\u00f6|\2\u0b5b\u00f3\3\2\2\2\u0b5c"+
		"\u0b5d\7\u0140\2\2\u0b5d\u0b62\5\u00eex\2\u0b5e\u0b5f\7\u0139\2\2\u0b5f"+
		"\u0b61\5\u00eex\2\u0b60\u0b5e\3\2\2\2\u0b61\u0b64\3\2\2\2\u0b62\u0b60"+
		"\3\2\2\2\u0b62\u0b63\3\2\2\2\u0b63\u0b65\3\2\2\2\u0b64\u0b62\3\2\2\2\u0b65"+
		"\u0b66\7\u0141\2\2\u0b66\u00f5\3\2\2\2\u0b67\u0b6c\5\u00ba^\2\u0b68\u0b69"+
		"\7\u0134\2\2\u0b69\u0b6b\5\u00e8u\2\u0b6a\u0b68\3\2\2\2\u0b6b\u0b6e\3"+
		"\2\2\2\u0b6c\u0b6a\3\2\2\2\u0b6c\u0b6d\3\2\2\2\u0b6d\u0b71\3\2\2\2\u0b6e"+
		"\u0b6c\3\2\2\2\u0b6f\u0b71\5\u00fa~\2\u0b70\u0b67\3\2\2\2\u0b70\u0b6f"+
		"\3\2\2\2\u0b71\u00f7\3\2\2\2\u0b72\u0b73\t\30\2\2\u0b73\u00f9\3\2\2\2"+
		"\u0b74\u0b75\5\u00fc\177\2\u0b75\u00fb\3\2\2\2\u0b76\u0b77\7\u00ab\2\2"+
		"\u0b77\u0b78\7\u0140\2\2\u0b78\u0b79\5\u00fe\u0080\2\u0b79\u0b7a\7\61"+
		"\2\2\u0b7a\u0b7b\5\u0102\u0082\2\u0b7b\u0b7c\7\u0141\2\2\u0b7c\u00fd\3"+
		"\2\2\2\u0b7d\u0b81\5\u01c6\u00e4\2\u0b7e\u0b81\5\u0100\u0081\2\u0b7f\u0b81"+
		"\5\u01ca\u00e6\2\u0b80\u0b7d\3\2\2\2\u0b80\u0b7e\3\2\2\2\u0b80\u0b7f\3"+
		"\2\2\2\u0b81\u00ff\3\2\2\2\u0b82\u0b83\t\32\2\2\u0b83\u0101\3\2\2\2\u0b84"+
		"\u0b87\5\u0192\u00ca\2\u0b85\u0b87\5\u0090I\2\u0b86\u0b84\3\2\2\2\u0b86"+
		"\u0b85\3\2\2\2\u0b87\u0103\3\2\2\2\u0b88\u0b89\5\u0106\u0084\2\u0b89\u0105"+
		"\3\2\2\2\u0b8a\u0b8f\5\u0108\u0085\2\u0b8b\u0b8c\7\u013a\2\2\u0b8c\u0b8e"+
		"\5\u0108\u0085\2\u0b8d\u0b8b\3\2\2\2\u0b8e\u0b91\3\2\2\2\u0b8f\u0b8d\3"+
		"\2\2\2\u0b8f\u0b90\3\2\2\2\u0b90\u0107\3\2\2\2\u0b91\u0b8f\3\2\2\2\u0b92"+
		"\u0b93\5\u010a\u0086\2\u0b93\u0109\3\2\2\2\u0b94\u0b97\5\u00ba^\2\u0b95"+
		"\u0b97\5\u010c\u0087\2\u0b96\u0b94\3\2\2\2\u0b96\u0b95\3\2\2\2\u0b97\u010b"+
		"\3\2\2\2\u0b98\u0b99\5\u010e\u0088\2\u0b99\u010d\3\2\2\2\u0b9a\u0b9b\7"+
		"\u00fa\2\2\u0b9b\u0b9c\7\u0140\2\2\u0b9c\u0b9d\5\u0110\u0089\2\u0b9d\u0b9e"+
		"\7\u0141\2\2\u0b9e\u010f\3\2\2\2\u0b9f\u0ba1\5\u0112\u008a\2\u0ba0\u0b9f"+
		"\3\2\2\2\u0ba0\u0ba1\3\2\2\2\u0ba1\u0ba3\3\2\2\2\u0ba2\u0ba4\5\u0106\u0084"+
		"\2\u0ba3\u0ba2\3\2\2\2\u0ba3\u0ba4\3\2\2\2\u0ba4\u0ba5\3\2\2\2\u0ba5\u0ba7"+
		"\7\61\2\2\u0ba6\u0ba0\3\2\2\2\u0ba6\u0ba7\3\2\2\2\u0ba7\u0ba8\3\2\2\2"+
		"\u0ba8\u0bae\5\u0106\u0084\2\u0ba9\u0baa\5\u0106\u0084\2\u0baa\u0bab\7"+
		"\u0139\2\2\u0bab\u0bac\5\u0106\u0084\2\u0bac\u0bae\3\2\2\2\u0bad\u0ba6"+
		"\3\2\2\2\u0bad\u0ba9\3\2\2\2\u0bae\u0111\3\2\2\2\u0baf\u0bb0\t\33\2\2"+
		"\u0bb0\u0113\3\2\2\2\u0bb1\u0bb2\5\u0116\u008c\2\u0bb2\u0115\3\2\2\2\u0bb3"+
		"\u0bb8\5\u0118\u008d\2\u0bb4\u0bb5\7V\2\2\u0bb5\u0bb7\5\u0116\u008c\2"+
		"\u0bb6\u0bb4\3\2\2\2\u0bb7\u0bba\3\2\2\2\u0bb8\u0bb6\3\2\2\2\u0bb8\u0bb9"+
		"\3\2\2\2\u0bb9\u0117\3\2\2\2\u0bba\u0bb8\3\2\2\2\u0bbb\u0bc0\5\u011a\u008e"+
		"\2\u0bbc\u0bbd\7\b\2\2\u0bbd\u0bbf\5\u0118\u008d\2\u0bbe\u0bbc\3\2\2\2"+
		"\u0bbf\u0bc2\3\2\2\2\u0bc0\u0bbe\3\2\2\2\u0bc0\u0bc1\3\2\2\2\u0bc1\u0119"+
		"\3\2\2\2\u0bc2\u0bc0\3\2\2\2\u0bc3\u0bc7\5\u011c\u008f\2\u0bc4\u0bc5\7"+
		"O\2\2\u0bc5\u0bc7\5\u011c\u008f\2\u0bc6\u0bc3\3\2\2\2\u0bc6\u0bc4\3\2"+
		"\2\2\u0bc7\u011b\3\2\2\2\u0bc8\u0bca\5\u0122\u0092\2\u0bc9\u0bcb\5\u011e"+
		"\u0090\2\u0bca\u0bc9\3\2\2\2\u0bca\u0bcb\3\2\2\2\u0bcb\u011d\3\2\2\2\u0bcc"+
		"\u0bce\7F\2\2\u0bcd\u0bcf\7O\2\2\u0bce\u0bcd\3\2\2\2\u0bce\u0bcf\3\2\2"+
		"\2\u0bcf\u0bd0\3\2\2\2\u0bd0\u0bd1\5\u0120\u0091\2\u0bd1\u011f\3\2\2\2"+
		"\u0bd2\u0bd3\t\24\2\2\u0bd3\u0121\3\2\2\2\u0bd4\u0bd7\5\u01a0\u00d1\2"+
		"\u0bd5\u0bd7\5\u0124\u0093\2\u0bd6\u0bd4\3\2\2\2\u0bd6\u0bd5\3\2\2\2\u0bd7"+
		"\u0123\3\2\2\2\u0bd8\u0bdb\5\u0126\u0094\2\u0bd9\u0bdb\5\u00be`\2\u0bda"+
		"\u0bd8\3\2\2\2\u0bda\u0bd9\3\2\2\2\u0bdb\u0125\3\2\2\2\u0bdc\u0bdd\7\u0140"+
		"\2\2\u0bdd\u0bde\5\u0114\u008b\2\u0bde\u0bdf\7\u0141\2\2\u0bdf\u0127\3"+
		"\2\2\2\u0be0\u0be3\5\u012a\u0096\2\u0be1\u0be3\5\u012c\u0097\2\u0be2\u0be0"+
		"\3\2\2\2\u0be2\u0be1\3\2\2\2\u0be3\u0129\3\2\2\2\u0be4\u0be5\5\u00be`"+
		"\2\u0be5\u012b\3\2\2\2\u0be6\u0be7\7P\2\2\u0be7\u012d\3\2\2\2\u0be8\u0beb"+
		"\5\u012a\u0096\2\u0be9\u0beb\5\u0130\u0099\2\u0bea\u0be8\3\2\2\2\u0bea"+
		"\u0be9\3\2\2\2\u0beb\u012f\3\2\2\2\u0bec\u0bef\5\u00ecw\2\u0bed\u0bef"+
		"\5\u0124\u0093\2\u0bee\u0bec\3\2\2\2\u0bee\u0bed\3\2\2\2\u0bef\u0131\3"+
		"\2\2\2\u0bf0\u0bf2\5\u0134\u009b\2\u0bf1\u0bf3\5\u0158\u00ad\2\u0bf2\u0bf1"+
		"\3\2\2\2\u0bf2\u0bf3\3\2\2\2\u0bf3\u0bf5\3\2\2\2\u0bf4\u0bf6\5\u015c\u00af"+
		"\2\u0bf5\u0bf4\3\2\2\2\u0bf5\u0bf6\3\2\2\2\u0bf6\u0bf8\3\2\2\2\u0bf7\u0bf9"+
		"\5\u016c\u00b7\2\u0bf8\u0bf7\3\2\2\2\u0bf8\u0bf9\3\2\2\2\u0bf9\u0bfb\3"+
		"\2\2\2\u0bfa\u0bfc\5\u01d4\u00eb\2\u0bfb\u0bfa\3\2\2\2\u0bfb\u0bfc\3\2"+
		"\2\2\u0bfc\u0bfe\3\2\2\2\u0bfd\u0bff\5\u01dc\u00ef\2\u0bfe\u0bfd\3\2\2"+
		"\2\u0bfe\u0bff\3\2\2\2\u0bff\u0133\3\2\2\2\u0c00\u0c01\7\61\2\2\u0c01"+
		"\u0c02\5\u0136\u009c\2\u0c02\u0135\3\2\2\2\u0c03\u0c08\5\u0138\u009d\2"+
		"\u0c04\u0c05\7\u0139\2\2\u0c05\u0c07\5\u0138\u009d\2\u0c06\u0c04\3\2\2"+
		"\2\u0c07\u0c0a\3\2\2\2\u0c08\u0c06\3\2\2\2\u0c08\u0c09\3\2\2\2\u0c09\u0137"+
		"\3\2\2\2\u0c0a\u0c08\3\2\2\2\u0c0b\u0c0e\5\u013a\u009e\2\u0c0c\u0c0e\5"+
		"\u0152\u00aa\2\u0c0d\u0c0b\3\2\2\2\u0c0d\u0c0c\3\2\2\2\u0c0e\u0139\3\2"+
		"\2\2\u0c0f\u0c11\5\u0152\u00aa\2\u0c10\u0c12\5\u013c\u009f\2\u0c11\u0c10"+
		"\3\2\2\2\u0c12\u0c13\3\2\2\2\u0c13\u0c11\3\2\2\2\u0c13\u0c14\3\2\2\2\u0c14"+
		"\u013b\3\2\2\2\u0c15\u0c16\7\31\2\2\u0c16\u0c17\7G\2\2\u0c17\u0c29\5\u0152"+
		"\u00aa\2\u0c18\u0c1a\5\u0146\u00a4\2\u0c19\u0c18\3\2\2\2\u0c19\u0c1a\3"+
		"\2\2\2\u0c1a\u0c1b\3\2\2\2\u0c1b\u0c1c\7G\2\2\u0c1c\u0c1d\5\u0152\u00aa"+
		"\2\u0c1d\u0c1e\5\u014c\u00a7\2\u0c1e\u0c29\3\2\2\2\u0c1f\u0c21\7N\2\2"+
		"\u0c20\u0c22\5\u0146\u00a4\2\u0c21\u0c20\3\2\2\2\u0c21\u0c22\3\2\2\2\u0c22"+
		"\u0c23\3\2\2\2\u0c23\u0c24\7G\2\2\u0c24\u0c29\5\u0152\u00aa\2\u0c25\u0c26"+
		"\7|\2\2\u0c26\u0c27\7G\2\2\u0c27\u0c29\5\u0152\u00aa\2\u0c28\u0c15\3\2"+
		"\2\2\u0c28\u0c19\3\2\2\2\u0c28\u0c1f\3\2\2\2\u0c28\u0c25\3\2\2\2\u0c29"+
		"\u013d\3\2\2\2\u0c2a\u0c2b\7\31\2\2\u0c2b\u0c2c\7G\2\2\u0c2c\u0c2d\5\u0152"+
		"\u00aa\2\u0c2d\u013f\3\2\2\2\u0c2e\u0c30\5\u0146\u00a4\2\u0c2f\u0c2e\3"+
		"\2\2\2\u0c2f\u0c30\3\2\2\2\u0c30\u0c31\3\2\2\2\u0c31\u0c32\7G\2\2\u0c32"+
		"\u0c33\5\u0152\u00aa\2\u0c33\u0c34\5\u014c\u00a7\2\u0c34\u0141\3\2\2\2"+
		"\u0c35\u0c37\7N\2\2\u0c36\u0c38\5\u0146\u00a4\2\u0c37\u0c36\3\2\2\2\u0c37"+
		"\u0c38\3\2\2\2\u0c38\u0c39\3\2\2\2\u0c39\u0c3a\7G\2\2\u0c3a\u0c3b\5\u0152"+
		"\u00aa\2\u0c3b\u0143\3\2\2\2\u0c3c\u0c3d\7|\2\2\u0c3d\u0c3e\7G\2\2\u0c3e"+
		"\u0c3f\5\u0152\u00aa\2\u0c3f\u0145\3\2\2\2\u0c40\u0c43\7@\2\2\u0c41\u0c43"+
		"\5\u0148\u00a5\2\u0c42\u0c40\3\2\2\2\u0c42\u0c41\3\2\2\2\u0c43\u0147\3"+
		"\2\2\2\u0c44\u0c46\5\u014a\u00a6\2\u0c45\u0c47\7S\2\2\u0c46\u0c45\3\2"+
		"\2\2\u0c46\u0c47\3\2\2\2\u0c47\u0149\3\2\2\2\u0c48\u0c49\t\34\2\2\u0c49"+
		"\u014b\3\2\2\2\u0c4a\u0c4d\5\u014e\u00a8\2\u0c4b\u0c4d\5\u0150\u00a9\2"+
		"\u0c4c\u0c4a\3\2\2\2\u0c4c\u0c4b\3\2\2\2\u0c4d\u014d\3\2\2\2\u0c4e\u0c4f"+
		"\7\u00d3\2\2\u0c4f\u0c50\5\u015a\u00ae\2\u0c50\u014f\3\2\2\2\u0c51\u0c52"+
		"\7\u0080\2\2\u0c52\u0c53\7\u0140\2\2\u0c53\u0c54\5\u0196\u00cc\2\u0c54"+
		"\u0c55\7\u0141\2\2\u0c55\u0151\3\2\2\2\u0c56\u0c5b\5\u0182\u00c2\2\u0c57"+
		"\u0c59\7\5\2\2\u0c58\u0c57\3\2\2\2\u0c58\u0c59\3\2\2\2\u0c59\u0c5a\3\2"+
		"\2\2\u0c5a\u0c5c\5\u0088E\2\u0c5b\u0c58\3\2\2\2\u0c5b\u0c5c\3\2\2\2\u0c5c"+
		"\u0c61\3\2\2\2\u0c5d\u0c5e\7\u0140\2\2\u0c5e\u0c5f\5\u0154\u00ab\2\u0c5f"+
		"\u0c60\7\u0141\2\2\u0c60\u0c62\3\2\2\2\u0c61\u0c5d\3\2\2\2\u0c61\u0c62"+
		"\3\2\2\2\u0c62\u0c6f\3\2\2\2\u0c63\u0c65\5\u0156\u00ac\2\u0c64\u0c66\7"+
		"\5\2\2\u0c65\u0c64\3\2\2\2\u0c65\u0c66\3\2\2\2\u0c66\u0c67\3\2\2\2\u0c67"+
		"\u0c6c\5\u0088E\2\u0c68\u0c69\7\u0140\2\2\u0c69\u0c6a\5\u0154\u00ab\2"+
		"\u0c6a\u0c6b\7\u0141\2\2\u0c6b\u0c6d\3\2\2\2\u0c6c\u0c68\3\2\2\2\u0c6c"+
		"\u0c6d\3\2\2\2\u0c6d\u0c6f\3\2\2\2\u0c6e\u0c56\3\2\2\2\u0c6e\u0c63\3\2"+
		"\2\2\u0c6f\u0153\3\2\2\2\u0c70\u0c75\5\u0088E\2\u0c71\u0c72\7\u0139\2"+
		"\2\u0c72\u0c74\5\u0088E\2\u0c73\u0c71\3\2\2\2\u0c74\u0c77\3\2\2\2\u0c75"+
		"\u0c73\3\2\2\2\u0c75\u0c76\3\2\2\2\u0c76\u0155\3\2\2\2\u0c77\u0c75\3\2"+
		"\2\2\u0c78\u0c79\5\u019c\u00cf\2\u0c79\u0157\3\2\2\2\u0c7a\u0c7b\7\u0085"+
		"\2\2\u0c7b\u0c7c\5\u015a\u00ae\2\u0c7c\u0159\3\2\2\2\u0c7d\u0c7e\5\u00ea"+
		"v\2\u0c7e\u015b\3\2\2\2\u0c7f\u0c80\7\64\2\2\u0c80\u0c81\7\u008b\2\2\u0c81"+
		"\u0c82\5\u015e\u00b0\2\u0c82\u015d\3\2\2\2\u0c83\u0c88\5\u0160\u00b1\2"+
		"\u0c84\u0c85\7\u0139\2\2\u0c85\u0c87\5\u0160\u00b1\2\u0c86\u0c84\3\2\2"+
		"\2\u0c87\u0c8a\3\2\2\2\u0c88\u0c86\3\2\2\2\u0c88\u0c89\3\2\2\2\u0c89\u015f"+
		"\3\2\2\2\u0c8a\u0c88\3\2\2\2\u0c8b\u0c90\5\u0166\u00b4\2\u0c8c\u0c90\5"+
		"\u0168\u00b5\2\u0c8d\u0c90\5\u016a\u00b6\2\u0c8e\u0c90\5\u0162\u00b2\2"+
		"\u0c8f\u0c8b\3\2\2\2\u0c8f\u0c8c\3\2\2\2\u0c8f\u0c8d\3\2\2\2\u0c8f\u0c8e"+
		"\3\2\2\2\u0c90\u0161\3\2\2\2\u0c91\u0c97\5\u012e\u0098\2\u0c92\u0c93\7"+
		"\u0140\2\2\u0c93\u0c94\5\u016e\u00b8\2\u0c94\u0c95\7\u0141\2\2\u0c95\u0c97"+
		"\3\2\2\2\u0c96\u0c91\3\2\2\2\u0c96\u0c92\3\2\2\2\u0c97\u0163\3\2\2\2\u0c98"+
		"\u0c9d\5\u0162\u00b2\2\u0c99\u0c9a\7\u0139\2\2\u0c9a\u0c9c\5\u0162\u00b2"+
		"\2\u0c9b\u0c99\3\2\2\2\u0c9c\u0c9f\3\2\2\2\u0c9d\u0c9b\3\2\2\2\u0c9d\u0c9e"+
		"\3\2\2\2\u0c9e\u0165\3\2\2\2\u0c9f\u0c9d\3\2\2\2\u0ca0\u0ca1\7\u00e4\2"+
		"\2\u0ca1\u0ca2\7\u0140\2\2\u0ca2\u0ca3\5\u0164\u00b3\2\u0ca3\u0ca4\7\u0141"+
		"\2\2\u0ca4\u0167\3\2\2\2\u0ca5\u0ca6\7\u009b\2\2\u0ca6\u0ca7\7\u0140\2"+
		"\2\u0ca7\u0ca8\5\u0164\u00b3\2\u0ca8\u0ca9\7\u0141\2\2\u0ca9\u0169\3\2"+
		"\2\2\u0caa\u0cab\7\u0140\2\2\u0cab\u0cac\7\u0141\2\2\u0cac\u016b\3\2\2"+
		"\2\u0cad\u0cae\7\65\2\2\u0cae\u0caf\5\u0114\u008b\2\u0caf\u016d\3\2\2"+
		"\2\u0cb0\u0cb5\5\u012e\u0098\2\u0cb1\u0cb2\7\u0139\2\2\u0cb2\u0cb4\5\u012e"+
		"\u0098\2\u0cb3\u0cb1\3\2\2\2\u0cb4\u0cb7\3\2\2\2\u0cb5\u0cb3\3\2\2\2\u0cb5"+
		"\u0cb6\3\2\2\2\u0cb6\u016f\3\2\2\2\u0cb7\u0cb5\3\2\2\2\u0cb8\u0cb9\5\u0172"+
		"\u00ba\2\u0cb9\u0171\3\2\2\2\u0cba\u0cbd\5\u0174\u00bb\2\u0cbb\u0cbd\5"+
		"\u013a\u009e\2\u0cbc\u0cba\3\2\2\2\u0cbc\u0cbb\3\2\2\2\u0cbd\u0173\3\2"+
		"\2\2\u0cbe\u0cc7\5\u0178\u00bd\2\u0cbf\u0cc0\5\u013a\u009e\2\u0cc0\u0cc2"+
		"\t\35\2\2\u0cc1\u0cc3\t\36\2\2\u0cc2\u0cc1\3\2\2\2\u0cc2\u0cc3\3\2\2\2"+
		"\u0cc3\u0cc4\3\2\2\2\u0cc4\u0cc5\5\u0176\u00bc\2\u0cc5\u0cc7\3\2\2\2\u0cc6"+
		"\u0cbe\3\2\2\2\u0cc6\u0cbf\3\2\2\2\u0cc7\u0ccf\3\2\2\2\u0cc8\u0cca\t\35"+
		"\2\2\u0cc9\u0ccb\t\36\2\2\u0cca\u0cc9\3\2\2\2\u0cca\u0ccb\3\2\2\2\u0ccb"+
		"\u0ccc\3\2\2\2\u0ccc\u0cce\5\u0176\u00bc\2\u0ccd\u0cc8\3\2\2\2\u0cce\u0cd1"+
		"\3\2\2\2\u0ccf\u0ccd\3\2\2\2\u0ccf\u0cd0\3\2\2\2\u0cd0\u0175\3\2\2\2\u0cd1"+
		"\u0ccf\3\2\2\2\u0cd2\u0cd5\5\u0178\u00bd\2\u0cd3\u0cd5\5\u013a\u009e\2"+
		"\u0cd4\u0cd2\3\2\2\2\u0cd4\u0cd3\3\2\2\2\u0cd5\u0177\3\2\2\2\u0cd6\u0cdf"+
		"\5\u017c\u00bf\2\u0cd7\u0cd8\5\u013a\u009e\2\u0cd8\u0cda\7A\2\2\u0cd9"+
		"\u0cdb\t\36\2\2\u0cda\u0cd9\3\2\2\2\u0cda\u0cdb\3\2\2\2\u0cdb\u0cdc\3"+
		"\2\2\2\u0cdc\u0cdd\5\u017a\u00be\2\u0cdd\u0cdf\3\2\2\2\u0cde\u0cd6\3\2"+
		"\2\2\u0cde\u0cd7\3\2\2\2\u0cdf\u0ce7\3\2\2\2\u0ce0\u0ce2\7A\2\2\u0ce1"+
		"\u0ce3\t\36\2\2\u0ce2\u0ce1\3\2\2\2\u0ce2\u0ce3\3\2\2\2\u0ce3\u0ce4\3"+
		"\2\2\2\u0ce4\u0ce6\5\u017a\u00be\2\u0ce5\u0ce0\3\2\2\2\u0ce6\u0ce9\3\2"+
		"\2\2\u0ce7\u0ce5\3\2\2\2\u0ce7\u0ce8\3\2\2\2\u0ce8\u0179\3\2\2\2\u0ce9"+
		"\u0ce7\3\2\2\2\u0cea\u0ced\5\u017c\u00bf\2\u0ceb\u0ced\5\u013a\u009e\2"+
		"\u0cec\u0cea\3\2\2\2\u0cec\u0ceb\3\2\2\2\u0ced\u017b\3\2\2\2\u0cee\u0cf4"+
		"\5\u017e\u00c0\2\u0cef\u0cf0\7\u0140\2\2\u0cf0\u0cf1\5\u0174\u00bb\2\u0cf1"+
		"\u0cf2\7\u0141\2\2\u0cf2\u0cf4\3\2\2\2\u0cf3\u0cee\3\2\2\2\u0cf3\u0cef"+
		"\3\2\2\2\u0cf4\u017d\3\2\2\2\u0cf5\u0cf8\5\u0186\u00c4\2\u0cf6\u0cf8\5"+
		"\u0180\u00c1\2\u0cf7\u0cf5\3\2\2\2\u0cf7\u0cf6\3\2\2\2\u0cf8\u017f\3\2"+
		"\2\2\u0cf9\u0cfa\7s\2\2\u0cfa\u0cfb\5\u0182\u00c2\2\u0cfb\u0181\3\2\2"+
		"\2\u0cfc\u0cff\5\u0184\u00c3\2\u0cfd\u0cff\5\u0088E\2\u0cfe\u0cfc\3\2"+
		"\2\2\u0cfe\u0cfd\3\2\2\2\u0cff\u0183\3\2\2\2\u0d00\u0d07\5\u0088E\2\u0d01"+
		"\u0d02\7\u0147\2\2\u0d02\u0d05\5\u0088E\2\u0d03\u0d04\7\u0147\2\2\u0d04"+
		"\u0d06\5\u0088E\2\u0d05\u0d03\3\2\2\2\u0d05\u0d06\3\2\2\2\u0d06\u0d08"+
		"\3\2\2\2\u0d07\u0d01\3\2\2\2\u0d07\u0d08\3\2\2\2\u0d08\u0185\3\2\2\2\u0d09"+
		"\u0d0b\7l\2\2\u0d0a\u0d0c\5\u0190\u00c9\2\u0d0b\u0d0a\3\2\2\2\u0d0b\u0d0c"+
		"\3\2\2\2\u0d0c\u0d0d\3\2\2\2\u0d0d\u0d0f\5\u0188\u00c5\2\u0d0e\u0d10\5"+
		"\u0132\u009a\2\u0d0f\u0d0e\3\2\2\2\u0d0f\u0d10\3\2\2\2\u0d10\u0187\3\2"+
		"\2\2\u0d11\u0d16\5\u018a\u00c6\2\u0d12\u0d13\7\u0139\2\2\u0d13\u0d15\5"+
		"\u018a\u00c6\2\u0d14\u0d12\3\2\2\2\u0d15\u0d18\3\2\2\2\u0d16\u0d14\3\2"+
		"\2\2\u0d16\u0d17\3\2\2\2\u0d17\u0189\3\2\2\2\u0d18\u0d16\3\2\2\2\u0d19"+
		"\u0d1c\5\u018c\u00c7\2\u0d1a\u0d1c\5\u018e\u00c8\2\u0d1b\u0d19\3\2\2\2"+
		"\u0d1b\u0d1a\3\2\2\2\u0d1c\u018b\3\2\2\2\u0d1d\u0d1f\5\u00eav\2\u0d1e"+
		"\u0d20\5\u0194\u00cb\2\u0d1f\u0d1e\3\2\2\2\u0d1f\u0d20\3\2\2\2\u0d20\u018d"+
		"\3\2\2\2\u0d21\u0d22\7\u0153\2\2\u0d22\u0d24\7\u0147\2\2\u0d23\u0d21\3"+
		"\2\2\2\u0d23\u0d24\3\2\2\2\u0d24\u0d25\3\2\2\2\u0d25\u0d26\7\u0144\2\2"+
		"\u0d26\u018f\3\2\2\2\u0d27\u0d28\t\36\2\2\u0d28\u0191\3\2\2\2\u0d29\u0d2a"+
		"\5\u0088E\2\u0d2a\u0d2b\7\u0147\2\2\u0d2b\u0d2d\3\2\2\2\u0d2c\u0d29\3"+
		"\2\2\2\u0d2c\u0d2d\3\2\2\2\u0d2d\u0d2e\3\2\2\2\u0d2e\u0d2f\5\u0088E\2"+
		"\u0d2f\u0193\3\2\2\2\u0d30\u0d32\7\5\2\2\u0d31\u0d30\3\2\2\2\u0d31\u0d32"+
		"\3\2\2\2\u0d32\u0d33\3\2\2\2\u0d33\u0d34\5\u0088E\2\u0d34\u0195\3\2\2"+
		"\2\u0d35\u0d3a\5\u0192\u00ca\2\u0d36\u0d37\7\u0139\2\2\u0d37\u0d39\5\u0192"+
		"\u00ca\2\u0d38\u0d36\3\2\2\2\u0d39\u0d3c\3\2\2\2\u0d3a\u0d38\3\2\2\2\u0d3a"+
		"\u0d3b\3\2\2\2\u0d3b\u0197\3\2\2\2\u0d3c\u0d3a\3\2\2\2\u0d3d\u0d3e\5\u019e"+
		"\u00d0\2\u0d3e\u0199\3\2\2\2\u0d3f\u0d40\5\u019e\u00d0\2\u0d40\u019b\3"+
		"\2\2\2\u0d41\u0d42\5\u019e\u00d0\2\u0d42\u019d\3\2\2\2\u0d43\u0d44\7\u0140"+
		"\2\2\u0d44\u0d45\5\u0170\u00b9\2\u0d45\u0d46\7\u0141\2\2\u0d46\u019f\3"+
		"\2\2\2\u0d47\u0d4e\5\u01a2\u00d2\2\u0d48\u0d4e\5\u01a6\u00d4\2\u0d49\u0d4e"+
		"\5\u01aa\u00d6\2\u0d4a\u0d4e\5\u01b0\u00d9\2\u0d4b\u0d4e\5\u01b8\u00dd"+
		"\2\u0d4c\u0d4e\5\u01c2\u00e2\2\u0d4d\u0d47\3\2\2\2\u0d4d\u0d48\3\2\2\2"+
		"\u0d4d\u0d49\3\2\2\2\u0d4d\u0d4a\3\2\2\2\u0d4d\u0d4b\3\2\2\2\u0d4d\u0d4c"+
		"\3\2\2\2\u0d4e\u01a1\3\2\2\2\u0d4f\u0d50\5\u012e\u0098\2\u0d50\u0d51\5"+
		"\u01a4\u00d3\2\u0d51\u0d52\5\u012e\u0098\2\u0d52\u01a3\3\2\2\2\u0d53\u0d54"+
		"\t\37\2\2\u0d54\u01a5\3\2\2\2\u0d55\u0d56\5\u012e\u0098\2\u0d56\u0d57"+
		"\5\u01a8\u00d5\2\u0d57\u01a7\3\2\2\2\u0d58\u0d5a\7O\2\2\u0d59\u0d58\3"+
		"\2\2\2\u0d59\u0d5a\3\2\2\2\u0d5a\u0d5b\3\2\2\2\u0d5b\u0d5d\7\u008a\2\2"+
		"\u0d5c\u0d5e\t \2\2\u0d5d\u0d5c\3\2\2\2\u0d5d\u0d5e\3\2\2\2\u0d5e\u0d5f"+
		"\3\2\2\2\u0d5f\u0d60\5\u012e\u0098\2\u0d60\u0d61\7\b\2\2\u0d61\u0d62\5"+
		"\u012e\u0098\2\u0d62\u01a9\3\2\2\2\u0d63\u0d65\5\u00eex\2\u0d64\u0d66"+
		"\7O\2\2\u0d65\u0d64\3\2\2\2\u0d65\u0d66\3\2\2\2\u0d66\u0d67\3\2\2\2\u0d67"+
		"\u0d68\7;\2\2\u0d68\u0d69\5\u01ac\u00d7\2\u0d69\u01ab\3\2\2\2\u0d6a\u0d70"+
		"\5\u019c\u00cf\2\u0d6b\u0d6c\7\u0140\2\2\u0d6c\u0d6d\5\u01ae\u00d8\2\u0d6d"+
		"\u0d6e\7\u0141\2\2\u0d6e\u0d70\3\2\2\2\u0d6f\u0d6a\3\2\2\2\u0d6f\u0d6b"+
		"\3\2\2\2\u0d70\u01ad\3\2\2\2\u0d71\u0d76\5\u0128\u0095\2\u0d72\u0d73\7"+
		"\u0139\2\2\u0d73\u0d75\5\u0128\u0095\2\u0d74\u0d72\3\2\2\2\u0d75\u0d78"+
		"\3\2\2\2\u0d76\u0d74\3\2\2\2\u0d76\u0d77\3\2\2\2\u0d77\u01af\3\2\2\2\u0d78"+
		"\u0d76\3\2\2\2\u0d79\u0d7a\5\u012e\u0098\2\u0d7a\u0d7b\5\u01b2\u00da\2"+
		"\u0d7b\u0d7c\7\u0156\2\2\u0d7c\u01b1\3\2\2\2\u0d7d\u0d7f\7O\2\2\u0d7e"+
		"\u0d7d\3\2\2\2\u0d7e\u0d7f\3\2\2\2\u0d7f\u0d80\3\2\2\2\u0d80\u0d83\5\u01b4"+
		"\u00db\2\u0d81\u0d83\5\u01b6\u00dc\2\u0d82\u0d7e\3\2\2\2\u0d82\u0d81\3"+
		"\2\2\2\u0d83\u01b3\3\2\2\2\u0d84\u0d8b\7K\2\2\u0d85\u0d8b\78\2\2\u0d86"+
		"\u0d87\7\u00ea\2\2\u0d87\u0d8b\7\u00fb\2\2\u0d88\u0d8b\7\u00e0\2\2\u0d89"+
		"\u0d8b\7\u00e3\2\2\u0d8a\u0d84\3\2\2\2\u0d8a\u0d85\3\2\2\2\u0d8a\u0d86"+
		"\3\2\2\2\u0d8a\u0d88\3\2\2\2\u0d8a\u0d89\3\2\2\2\u0d8b\u01b5\3\2\2\2\u0d8c"+
		"\u0d8d\t!\2\2\u0d8d\u01b7\3\2\2\2\u0d8e\u0d8f\5\u012e\u0098\2\u0d8f\u0d91"+
		"\7F\2\2\u0d90\u0d92\7O\2\2\u0d91\u0d90\3\2\2\2\u0d91\u0d92\3\2\2\2\u0d92"+
		"\u0d93\3\2\2\2\u0d93\u0d94\7P\2\2\u0d94\u01b9\3\2\2\2\u0d95\u0d96\5\u00ee"+
		"x\2\u0d96\u0d97\5\u01a4\u00d3\2\u0d97\u0d98\5\u01bc\u00df\2\u0d98\u0d99"+
		"\5\u019c\u00cf\2\u0d99\u01bb\3\2\2\2\u0d9a\u0d9d\5\u01be\u00e0\2\u0d9b"+
		"\u0d9d\5\u01c0\u00e1\2\u0d9c\u0d9a\3\2\2\2\u0d9c\u0d9b\3\2\2\2\u0d9d\u01bd"+
		"\3\2\2\2\u0d9e\u0d9f\7\6\2\2\u0d9f\u01bf\3\2\2\2\u0da0\u0da1\t\"\2\2\u0da1"+
		"\u01c1\3\2\2\2\u0da2\u0da4\7O\2\2\u0da3\u0da2\3\2\2\2\u0da3\u0da4\3\2"+
		"\2\2\u0da4\u0da5\3\2\2\2\u0da5\u0da6\7\u00a9\2\2\u0da6\u0da7\5\u019c\u00cf"+
		"\2\u0da7\u01c3\3\2\2\2\u0da8\u0da9\7}\2\2\u0da9\u0daa\5\u019c\u00cf\2"+
		"\u0daa\u01c5\3\2\2\2\u0dab\u0dae\5\u01c8\u00e5\2\u0dac\u0dae\7\u00e6\2"+
		"\2\u0dad\u0dab\3\2\2\2\u0dad\u0dac\3\2\2\2\u0dae\u01c7\3\2\2\2\u0daf\u0db0"+
		"\t#\2\2\u0db0\u01c9\3\2\2\2\u0db1\u0db2\t$\2\2\u0db2\u01cb\3\2\2\2\u0db3"+
		"\u0db4\5\u01d0\u00e9\2\u0db4\u0db6\7\u0140\2\2\u0db5\u0db7\5\u01d2\u00ea"+
		"\2\u0db6\u0db5\3\2\2\2\u0db6\u0db7\3\2\2\2\u0db7\u0db8\3\2\2\2\u0db8\u0db9"+
		"\7\u0141\2\2\u0db9\u01cd\3\2\2\2\u0dba\u0dbb\t%\2\2\u0dbb\u01cf\3\2\2"+
		"\2\u0dbc\u0dbf\5\u0088E\2\u0dbd\u0dbf\5\u01ce\u00e8\2\u0dbe\u0dbc\3\2"+
		"\2\2\u0dbe\u0dbd\3\2\2\2\u0dbf\u01d1\3\2\2\2\u0dc0\u0dc5\5\u00eav\2\u0dc1"+
		"\u0dc2\7\u0139\2\2\u0dc2\u0dc4\5\u00eav\2\u0dc3\u0dc1\3\2\2\2\u0dc4\u0dc7"+
		"\3\2\2\2\u0dc5\u0dc3\3\2\2\2\u0dc5\u0dc6\3\2\2\2\u0dc6\u01d3\3\2\2\2\u0dc7"+
		"\u0dc5\3\2\2\2\u0dc8\u0dc9\7W\2\2\u0dc9\u0dca\7\u008b\2\2\u0dca\u0dcb"+
		"\5\u01d6\u00ec\2\u0dcb\u01d5\3\2\2\2\u0dcc\u0dd1\5\u01d8\u00ed\2\u0dcd"+
		"\u0dce\7\u0139\2\2\u0dce\u0dd0\5\u01d8\u00ed\2\u0dcf\u0dcd\3\2\2\2\u0dd0"+
		"\u0dd3\3\2\2\2\u0dd1\u0dcf\3\2\2\2\u0dd1\u0dd2\3\2\2\2\u0dd2\u01d7\3\2"+
		"\2\2\u0dd3\u0dd1\3\2\2\2\u0dd4\u0dd6\5\u012e\u0098\2\u0dd5\u0dd7\5\u01da"+
		"\u00ee\2\u0dd6\u0dd5\3\2\2\2\u0dd6\u0dd7\3\2\2\2\u0dd7\u0dd9\3\2\2\2\u0dd8"+
		"\u0dda\5\u01de\u00f0\2\u0dd9\u0dd8\3\2\2\2\u0dd9\u0dda\3\2\2\2\u0dda\u01d9"+
		"\3\2\2\2\u0ddb\u0ddc\t&\2\2\u0ddc\u01db\3\2\2\2\u0ddd\u0dde\7L\2\2\u0dde"+
		"\u0ddf\5\u00eex\2\u0ddf\u01dd\3\2\2\2\u0de0\u0de1\7P\2\2\u0de1\u0de5\7"+
		"\u00ae\2\2\u0de2\u0de3\7P\2\2\u0de3\u0de5\7\u00c0\2\2\u0de4\u0de0\3\2"+
		"\2\2\u0de4\u0de2\3\2\2\2\u0de5\u01df\3\2\2\2\u0de6\u0de8\7\u00b8\2\2\u0de7"+
		"\u0de9\7\u00d6\2\2\u0de8\u0de7\3\2\2\2\u0de8\u0de9\3\2\2\2\u0de9\u0dea"+
		"\3\2\2\2\u0dea\u0deb\7B\2\2\u0deb\u0df0\5\u0184\u00c3\2\u0dec\u0ded\7"+
		"\u0140\2\2\u0ded\u0dee\5\u0154\u00ab\2\u0dee\u0def\7\u0141\2\2\u0def\u0df1"+
		"\3\2\2\2\u0df0\u0dec\3\2\2\2\u0df0\u0df1\3\2\2\2\u0df1\u0df2\3\2\2\2\u0df2"+
		"\u0df3\5\u0170\u00b9\2\u0df3\u0e04\3\2\2\2\u0df4\u0df6\7\u00b8\2\2\u0df5"+
		"\u0df7\7\u00d6\2\2\u0df6\u0df5\3\2\2\2\u0df6\u0df7\3\2\2\2\u0df7\u0df8"+
		"\3\2\2\2\u0df8\u0df9\7B\2\2\u0df9\u0dfa\7\u00c3\2\2\u0dfa\u0e00\7\u0156"+
		"\2\2\u0dfb\u0dfc\7\u0080\2\2\u0dfc\u0dfe\5\u0088E\2\u0dfd\u0dff\5b\62"+
		"\2\u0dfe\u0dfd\3\2\2\2\u0dfe\u0dff\3\2\2\2\u0dff\u0e01\3\2\2\2\u0e00\u0dfb"+
		"\3\2\2\2\u0e00\u0e01\3\2\2\2\u0e01\u0e02\3\2\2\2\u0e02\u0e04\5\u0170\u00b9"+
		"\2\u0e03\u0de6\3\2\2\2\u0e03\u0df4\3\2\2\2\u0e04\u01e1\3\2\2\2\u01f8\u01e4"+
		"\u01e8\u01f6\u0205\u020a\u0213\u0216\u0230\u0240\u0244\u024e\u0256\u0266"+
		"\u026b\u027a\u0285\u0289\u0290\u0296\u029d\u02a1\u02a5\u02a9\u02ad\u02b2"+
		"\u02b5\u02bc\u02bf\u02c2\u02ca\u02ce\u02d0\u02d4\u02de\u02e1\u02e5\u02e9"+
		"\u02f0\u02f3\u02f7\u02f9\u02fd\u0305\u030e\u0312\u0314\u0316\u031c\u0321"+
		"\u0327\u032b\u032f\u0333\u033b\u033d\u0345\u034a\u034e\u0350\u0354\u0359"+
		"\u0362\u0364\u036c\u0372\u0376\u037c\u0380\u0385\u0389\u038d\u0391\u0395"+
		"\u0399\u03a1\u03a6\u03aa\u03ac\u03b2\u03b6\u03be\u03c2\u03c4\u03cc\u03d1"+
		"\u03d5\u03d7\u03dd\u03e1\u03e9\u03ee\u03f0\u03f8\u03fc\u0404\u0409\u040b"+
		"\u0412\u0416\u041e\u0423\u0425\u042a\u0432\u0437\u0439\u043f\u0443\u044b"+
		"\u0450\u0452\u0454\u0458\u045a\u0461\u0465\u046d\u0471\u0475\u0479\u047b"+
		"\u0481\u0485\u048d\u0492\u0494\u049a\u049e\u04a6\u04aa\u04ae\u04b3\u04b7"+
		"\u04ba\u04bc\u04c0\u04c5\u04c7\u04c9\u04cc\u04d2\u04d6\u04d8\u04dc\u04e0"+
		"\u04e4\u04ec\u04f0\u04f2\u04fa\u04fe\u0502\u0506\u050a\u050e\u0510\u0514"+
		"\u0518\u051c\u0523\u0527\u052b\u052d\u0533\u0537\u053f\u0543\u0545\u054c"+
		"\u0550\u0554\u0556\u055c\u0560\u0568\u056a\u0572\u0576\u057e\u0580\u0587"+
		"\u058b\u0593\u0595\u059a\u05a2\u05a4\u05aa\u05ae\u05b5\u05b9\u05bd\u05bf"+
		"\u05c6\u05ca\u05d1\u05d5\u05d9\u05db\u05e1\u05e5\u05ed\u05ef\u05f5\u05f9"+
		"\u05ff\u0603\u0608\u060c\u0611\u0613\u0617\u061b\u061e\u0622\u0627\u0630"+
		"\u0634\u0673\u06a1\u06a9\u06b6\u06ba\u06be\u06d1\u06d6\u06e6\u06ec\u06f5"+
		"\u06f7\u06fd\u0701\u0705\u0709\u070c\u0712\u0715\u0719\u0720\u0726\u072f"+
		"\u073c\u073f\u0743\u0746\u074a\u0755\u0759\u075d\u0763\u076a\u0770\u0774"+
		"\u077a\u0781\u0783\u0785\u078d\u0792\u079c\u07a7\u07b0\u07b5\u07b8\u07be"+
		"\u07c2\u07ca\u07ce\u07d2\u07db\u07df\u07e5\u07ed\u07f2\u07fb\u07fe\u0801"+
		"\u0805\u0807\u080e\u0812\u0816\u081e\u0822\u0828\u0834\u0838\u083b\u083f"+
		"\u0843\u0849\u0850\u0857\u085b\u0865\u0869\u0871\u0878\u087c\u0885\u088c"+
		"\u0890\u0898\u089c\u08a0\u08a8\u08ad\u08b2\u08b4\u08b9\u08bf\u08c3\u08cc"+
		"\u08dc\u08e1\u08e6\u08e8\u08ed\u08f3\u08ff\u0902\u0906\u090f\u0918\u091a"+
		"\u091e\u0926\u0929\u092f\u0937\u0948\u095d\u096e\u097b\u097f\u0981\u098e"+
		"\u0995\u09ad\u09b4\u09c5\u09ca\u09ce\u09d0\u09d6\u09db\u09e0\u09f0\u09ff"+
		"\u0a07\u0a0b\u0a10\u0a15\u0a19\u0a1c\u0a25\u0a2a\u0a2e\u0a34\u0a3a\u0a3f"+
		"\u0a43\u0a45\u0a49\u0a4d\u0a4f\u0a53\u0a57\u0a5b\u0a5f\u0a6a\u0a6e\u0a76"+
		"\u0a80\u0a95\u0a99\u0a9d\u0aa2\u0aa4\u0aa8\u0aad\u0ab1\u0ab3\u0ab7\u0ac4"+
		"\u0acb\u0ad7\u0ad9\u0ade\u0b00\u0b04\u0b08\u0b0f\u0b12\u0b1a\u0b1d\u0b30"+
		"\u0b40\u0b45\u0b4c\u0b54\u0b58\u0b62\u0b6c\u0b70\u0b80\u0b86\u0b8f\u0b96"+
		"\u0ba0\u0ba3\u0ba6\u0bad\u0bb8\u0bc0\u0bc6\u0bca\u0bce\u0bd6\u0bda\u0be2"+
		"\u0bea\u0bee\u0bf2\u0bf5\u0bf8\u0bfb\u0bfe\u0c08\u0c0d\u0c13\u0c19\u0c21"+
		"\u0c28\u0c2f\u0c37\u0c42\u0c46\u0c4c\u0c58\u0c5b\u0c61\u0c65\u0c6c\u0c6e"+
		"\u0c75\u0c88\u0c8f\u0c96\u0c9d\u0cb5\u0cbc\u0cc2\u0cc6\u0cca\u0ccf\u0cd4"+
		"\u0cda\u0cde\u0ce2\u0ce7\u0cec\u0cf3\u0cf7\u0cfe\u0d05\u0d07\u0d0b\u0d0f"+
		"\u0d16\u0d1b\u0d1f\u0d23\u0d2c\u0d31\u0d3a\u0d4d\u0d59\u0d5d\u0d65\u0d6f"+
		"\u0d76\u0d7e\u0d82\u0d8a\u0d91\u0d9c\u0da3\u0dad\u0db6\u0dbe\u0dc5\u0dd1"+
		"\u0dd6\u0dd9\u0de4\u0de8\u0df0\u0df6\u0dfe\u0e00\u0e03";
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