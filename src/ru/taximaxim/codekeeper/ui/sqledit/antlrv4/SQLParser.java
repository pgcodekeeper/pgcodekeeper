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
		FUNCTION=45, ISODOW=181, OVERWRITE=208, FUNCTIONS=46, ROW=92, PRECISION=213, 
		ILIKE=53, Character_String_Literal=334, NOT=75, EXCEPT=36, FOREIGN=43, 
		CACHE=134, PRIVILEGES=88, BYTEA=295, MONTH=199, STATEMENT=108, CHARACTER=138, 
		TYPE=246, BlockComment=331, VARBIT=263, STDDEV_POP=233, CREATE=22, COMMENTS=144, 
		ESC_SEQUENCES=335, USING=123, UNLOGGED=248, NOT_EQUAL=309, TIMEZONE_MINUTE=243, 
		VERTICAL_BAR=323, VARIADIC=124, TIMESTAMPTZ=289, REGEXP=218, FAMILY=166, 
		GEQ=313, STDDEV_SAMP=234, DIVIDE=319, BLOB=294, STRICT=109, PRESERVE=86, 
		ASC=9, GROUPING=171, SUBPARTITION=235, KEY=68, SETOF=106, TEMP=112, ELSE=35, 
		NUMBER=329, BOOL=261, TRAILING=115, DEFINER=156, SEMI_COLON=306, INT=270, 
		RLIKE=221, RESTRICT=96, LEADING=69, SERVER=226, PROCEDURAL=90, TABLESPACE=237, 
		MILLISECONDS=195, REAL=275, INTERSECT=61, GROUP=50, LANGUAGE=184, SEQUENCES=103, 
		OUT=80, REAL_NUMBER=330, NONE=202, TRIM=244, LEFT_PAREN=314, LOCATION=189, 
		SEARCH=223, END=34, CONSTRAINT=19, TIMEZONE_HOUR=242, RENAME=219, CAST_EXPRESSION=302, 
		ALTER=5, OPTION=206, ISOYEAR=182, UUID=291, NCHAR=283, EXECUTE=39, OWNER=85, 
		INPUT=177, TABLE=111, VARCHAR=282, FLOAT=277, VERSION=253, MICROSECONDS=193, 
		IMMUTABLE=55, ASYMMETRIC=8, SUM=236, OWNED=84, Space=336, INOUT=63, STORAGE=232, 
		TIME=286, AS=3, RIGHT_PAREN=315, THEN=114, COLLATION=17, MAXVALUE=192, 
		DOUBLE_UNDER_DOLLAR=328, REPLACE=95, LEFT=70, AVG=131, ZONE=259, TRUNCATE=118, 
		COLUMN=142, PLUS=316, EXISTS=163, NVARCHAR=284, Not_Similar_To=299, RETURNS=97, 
		LIKE=71, COLLATE=16, INTEGER=271, OUTER=79, BY=133, DEFERRABLE=27, TO=245, 
		SET=227, RIGHT=99, HAVING=51, MIN=196, SESSION=105, MINUS=317, TEXT=290, 
		HOUR=173, CONCATENATION_OPERATOR=308, CONVERSION=21, UNION=119, CURRENT=150, 
		COLON=305, COMMIT=145, SCHEMA=101, DATABASE=24, DECIMAL=280, DROP=160, 
		BIGINT=272, WHEN=126, ROWS=93, START=231, BIT=262, LARGE=185, REVOKE=98, 
		NATURAL=74, FORMAT=169, PUBLIC=214, AGGREGATE=1, EXTENSION=40, BETWEEN=132, 
		OPTIONS=207, FIRST=168, CAST=15, WEEK=255, EXTERNAL=164, DOUBLE_QUOTE=325, 
		VARYING=252, RESET=220, TRIGGER=116, CASE=13, CHAR=281, INT8=267, COUNT=148, 
		DAY=153, CASCADE=14, COST=147, INT2=265, INT1=264, Identifier=333, INT4=266, 
		ISCACHABLE=180, QUOTE=324, MODULAR=320, INVOKER=65, FULL=44, DICTIONARY=157, 
		THAN=240, QUARTER=216, INSERT=178, INHERITS=58, CONNECT=18, INTERSECTION=179, 
		LESS=187, TINYINT=268, BOTH=12, Similar_To_Case_Insensitive=300, DOUBLE=278, 
		ADMIN=130, SYMMETRIC=110, VOID=297, ISSTRICT=183, EACH=33, LAST=186, COMMENT=143, 
		SELECT=104, INTO=62, UNIQUE=120, COALESCE=141, SECOND=224, ROLE=91, RULE=100, 
		VIEW=125, EPOCH=161, ROLLUP=222, NULL=76, WITHOUT=129, NO=201, EVERY=162, 
		ON=205, MATCH=190, PRIMARY=87, DELETE=29, INET4=296, NUMERIC=279, LOCAL=73, 
		OF=77, EXCLUDING=38, LIST=188, TABLES=238, UNDERLINE=322, SEQUENCE=102, 
		Not_Similar_To_Case_Insensitive=301, CUBE=149, NATIONAL=200, CALLED=135, 
		VAR_POP=251, OR=82, FILTER=167, CHECK=139, FROM=47, FALSE=41, COLLECT=140, 
		PARSER=209, DISTINCT=31, TEMPORARY=113, TIMESTAMP=288, SIMPLE=229, DOLLAR=326, 
		CONSTRAINTS=20, WHERE=127, DEC=154, VAR_SAMP=250, NULLIF=203, CLASS=136, 
		TIMETZ=287, INNER=60, YEAR=258, TIMEZONE=241, ORDER=83, AUTHORIZATION=10, 
		LIMIT=72, DECADE=155, GTH=312, CYCLE=151, White_Space=337, UPDATE=121, 
		MAX=191, LineComment=332, DEFERRED=28, FOR=42, FLOAT4=273, CONFIGURATION=146, 
		FLOAT8=274, AND=6, CROSS=23, Similar_To=298, USAGE=122, IF=52, INDEX=174, 
		OIDS=78, BOOLEAN=260, IN=56, MINVALUE=197, UNKNOWN=247, MULTIPLY=318, 
		OBJECT=204, COMMA=307, REFERENCES=94, PARTITION=211, IS=66, PARTITIONS=212, 
		SOME=107, EQUAL=304, ALL=4, DOUBLE_DOLLAR=327, DOT=321, EXTRACT=165, CENTURY=137, 
		STABLE=230, SECURITY=225, PARTIAL=210, DOW=158, EXCLUDE=37, WITH=128, 
		INITIALLY=59, DOY=159, FUSION=170, GRANT=49, VARBINARY=293, VOLATILE=254, 
		OPERATOR=81, DEFAULT=25, VALUES=249, HASH=172, RANGE=217, MILLENNIUM=194, 
		INDEXES=175, PURGE=215, BEFORE=11, AFTER=2, INSTEAD=64, WRAPPER=257, TRUE=117, 
		PROCEDURE=89, JOIN=67, SIMILAR=228, DOMAIN=32, DEFAULTS=26, LTH=310, INCREMENT=176, 
		ANY=7, TEMPLATE=239, BAD=338, ASSIGN=303, REGCLASS=276, IMMEDIATE=54, 
		WINDOW=256, BINARY=292, DESC=30, DATE=285, MINUTE=198, GLOBAL=48, DATA=152, 
		INCLUDING=57, LEQ=311, SMALLINT=269;
	public static final String[] tokenNames = {
		"<INVALID>", "AGGREGATE", "AFTER", "AS", "ALL", "ALTER", "AND", "ANY", 
		"ASYMMETRIC", "ASC", "AUTHORIZATION", "BEFORE", "BOTH", "CASE", "CASCADE", 
		"CAST", "COLLATE", "COLLATION", "CONNECT", "CONSTRAINT", "CONSTRAINTS", 
		"CONVERSION", "CREATE", "CROSS", "DATABASE", "DEFAULT", "DEFAULTS", "DEFERRABLE", 
		"DEFERRED", "DELETE", "DESC", "DISTINCT", "DOMAIN", "EACH", "END", "ELSE", 
		"EXCEPT", "EXCLUDE", "EXCLUDING", "EXECUTE", "EXTENSION", "FALSE", "FOR", 
		"FOREIGN", "FULL", "FUNCTION", "FUNCTIONS", "FROM", "GLOBAL", "GRANT", 
		"GROUP", "HAVING", "IF", "ILIKE", "IMMEDIATE", "IMMUTABLE", "IN", "INCLUDING", 
		"INHERITS", "INITIALLY", "INNER", "INTERSECT", "INTO", "INOUT", "INSTEAD", 
		"INVOKER", "IS", "JOIN", "KEY", "LEADING", "LEFT", "LIKE", "LIMIT", "LOCAL", 
		"NATURAL", "NOT", "NULL", "OF", "OIDS", "OUTER", "OUT", "OPERATOR", "OR", 
		"ORDER", "OWNED", "OWNER", "PRESERVE", "PRIMARY", "PRIVILEGES", "PROCEDURE", 
		"PROCEDURAL", "ROLE", "ROW", "ROWS", "REFERENCES", "REPLACE", "RESTRICT", 
		"RETURNS", "REVOKE", "RIGHT", "RULE", "SCHEMA", "SEQUENCE", "SEQUENCES", 
		"SELECT", "SESSION", "SETOF", "SOME", "STATEMENT", "STRICT", "SYMMETRIC", 
		"TABLE", "TEMP", "TEMPORARY", "THEN", "TRAILING", "TRIGGER", "TRUE", "TRUNCATE", 
		"UNION", "UNIQUE", "UPDATE", "USAGE", "USING", "VARIADIC", "VIEW", "WHEN", 
		"WHERE", "WITH", "WITHOUT", "ADMIN", "AVG", "BETWEEN", "BY", "CACHE", 
		"CALLED", "CLASS", "CENTURY", "CHARACTER", "CHECK", "COLLECT", "COALESCE", 
		"COLUMN", "COMMENT", "COMMENTS", "COMMIT", "CONFIGURATION", "COST", "COUNT", 
		"CUBE", "CURRENT", "CYCLE", "DATA", "DAY", "DEC", "DECADE", "DEFINER", 
		"DICTIONARY", "DOW", "DOY", "DROP", "EPOCH", "EVERY", "EXISTS", "EXTERNAL", 
		"EXTRACT", "FAMILY", "FILTER", "FIRST", "FORMAT", "FUSION", "GROUPING", 
		"HASH", "HOUR", "INDEX", "INDEXES", "INCREMENT", "INPUT", "INSERT", "INTERSECTION", 
		"ISCACHABLE", "ISODOW", "ISOYEAR", "ISSTRICT", "LANGUAGE", "LARGE", "LAST", 
		"LESS", "LIST", "LOCATION", "MATCH", "MAX", "MAXVALUE", "MICROSECONDS", 
		"MILLENNIUM", "MILLISECONDS", "MIN", "MINVALUE", "MINUTE", "MONTH", "NATIONAL", 
		"NO", "NONE", "NULLIF", "OBJECT", "ON", "OPTION", "OPTIONS", "OVERWRITE", 
		"PARSER", "PARTIAL", "PARTITION", "PARTITIONS", "PRECISION", "PUBLIC", 
		"PURGE", "QUARTER", "RANGE", "REGEXP", "RENAME", "RESET", "RLIKE", "ROLLUP", 
		"SEARCH", "SECOND", "SECURITY", "SERVER", "SET", "SIMILAR", "SIMPLE", 
		"STABLE", "START", "STORAGE", "STDDEV_POP", "STDDEV_SAMP", "SUBPARTITION", 
		"SUM", "TABLESPACE", "TABLES", "TEMPLATE", "THAN", "TIMEZONE", "TIMEZONE_HOUR", 
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
		"REAL_NUMBER", "BlockComment", "LineComment", "Identifier", "Character_String_Literal", 
		"ESC_SEQUENCES", "' '", "White_Space", "BAD"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_data_statement = 2, RULE_data_change_statement = 3, 
		RULE_schema_statement = 4, RULE_schema_create = 5, RULE_schema_alter = 6, 
		RULE_alter_function_statement = 7, RULE_function_action = 8, RULE_index_statement = 9, 
		RULE_create_extension_statement = 10, RULE_set_statement = 11, RULE_create_trigger_statement = 12, 
		RULE_revoke_statement = 13, RULE_revoke_from_cascade_restrict = 14, RULE_grant_statement = 15, 
		RULE_grant_to_rule = 16, RULE_comment_on_statement = 17, RULE_create_function_statement = 18, 
		RULE_function_parameters = 19, RULE_function_body = 20, RULE_function_body_separator = 21, 
		RULE_function_body_separator_dollar_under = 22, RULE_function_attribute = 23, 
		RULE_argmode = 24, RULE_function_definition = 25, RULE_functions_definition_schema = 26, 
		RULE_create_sequence_statement = 27, RULE_create_schema_statement = 28, 
		RULE_create_view_statement = 29, RULE_query = 30, RULE_create_table_statement = 31, 
		RULE_like_option = 32, RULE_table_constraint = 33, RULE_column_constraint = 34, 
		RULE_check_boolean_expression = 35, RULE_storage_parameter = 36, RULE_storage_parameter_oid = 37, 
		RULE_on_commit = 38, RULE_table_space = 39, RULE_action = 40, RULE_index_parameters = 41, 
		RULE_table_elements = 42, RULE_field_element = 43, RULE_field_type = 44, 
		RULE_param_clause = 45, RULE_param = 46, RULE_method_specifier = 47, RULE_table_space_specifier = 48, 
		RULE_table_space_name = 49, RULE_table_partitioning_clauses = 50, RULE_range_partitions = 51, 
		RULE_range_value_clause_list = 52, RULE_range_value_clause = 53, RULE_hash_partitions = 54, 
		RULE_individual_hash_partitions = 55, RULE_individual_hash_partition = 56, 
		RULE_hash_partitions_by_quantity = 57, RULE_list_partitions = 58, RULE_list_value_clause_list = 59, 
		RULE_list_value_partition = 60, RULE_column_partitions = 61, RULE_partition_name = 62, 
		RULE_drop_table_statement = 63, RULE_identifier = 64, RULE_nonreserved_keywords = 65, 
		RULE_unsigned_literal = 66, RULE_general_literal = 67, RULE_datetime_literal = 68, 
		RULE_time_literal = 69, RULE_timestamp_literal = 70, RULE_date_literal = 71, 
		RULE_boolean_literal = 72, RULE_data_type = 73, RULE_predefined_type = 74, 
		RULE_regclass = 75, RULE_network_type = 76, RULE_character_string_type = 77, 
		RULE_type_length = 78, RULE_national_character_string_type = 79, RULE_binary_large_object_string_type = 80, 
		RULE_numeric_type = 81, RULE_exact_numeric_type = 82, RULE_approximate_numeric_type = 83, 
		RULE_precision_param = 84, RULE_boolean_type = 85, RULE_datetime_type = 86, 
		RULE_bit_type = 87, RULE_binary_type = 88, RULE_value_expression_primary = 89, 
		RULE_parenthesized_value_expression = 90, RULE_nonparenthesized_value_expression_primary = 91, 
		RULE_unsigned_value_specification = 92, RULE_unsigned_numeric_literal = 93, 
		RULE_signed_numerical_literal = 94, RULE_set_function_specification = 95, 
		RULE_aggregate_function = 96, RULE_general_set_function = 97, RULE_set_function_type = 98, 
		RULE_filter_clause = 99, RULE_grouping_operation = 100, RULE_case_expression = 101, 
		RULE_case_abbreviation = 102, RULE_case_specification = 103, RULE_simple_case = 104, 
		RULE_searched_case = 105, RULE_simple_when_clause = 106, RULE_searched_when_clause = 107, 
		RULE_else_clause = 108, RULE_result = 109, RULE_cast_specification = 110, 
		RULE_cast_operand = 111, RULE_cast_target = 112, RULE_value_expression = 113, 
		RULE_common_value_expression = 114, RULE_numeric_value_expression = 115, 
		RULE_term = 116, RULE_factor = 117, RULE_array = 118, RULE_numeric_primary = 119, 
		RULE_sign = 120, RULE_numeric_value_function = 121, RULE_extract_expression = 122, 
		RULE_extract_field = 123, RULE_time_zone_field = 124, RULE_extract_source = 125, 
		RULE_string_value_expression = 126, RULE_character_value_expression = 127, 
		RULE_character_factor = 128, RULE_character_primary = 129, RULE_string_value_function = 130, 
		RULE_trim_function = 131, RULE_trim_operands = 132, RULE_trim_specification = 133, 
		RULE_boolean_value_expression = 134, RULE_or_predicate = 135, RULE_and_predicate = 136, 
		RULE_boolean_factor = 137, RULE_boolean_test = 138, RULE_is_clause = 139, 
		RULE_truth_value = 140, RULE_boolean_primary = 141, RULE_boolean_predicand = 142, 
		RULE_parenthesized_boolean_value_expression = 143, RULE_row_value_expression = 144, 
		RULE_row_value_special_case = 145, RULE_explicit_row_value_constructor = 146, 
		RULE_row_value_predicand = 147, RULE_row_value_constructor_predicand = 148, 
		RULE_table_expression = 149, RULE_from_clause = 150, RULE_table_reference_list = 151, 
		RULE_table_reference = 152, RULE_joined_table = 153, RULE_joined_table_primary = 154, 
		RULE_cross_join = 155, RULE_qualified_join = 156, RULE_natural_join = 157, 
		RULE_union_join = 158, RULE_join_type = 159, RULE_outer_join_type = 160, 
		RULE_outer_join_type_part2 = 161, RULE_join_specification = 162, RULE_join_condition = 163, 
		RULE_named_columns_join = 164, RULE_table_primary = 165, RULE_column_name_list = 166, 
		RULE_derived_table = 167, RULE_where_clause = 168, RULE_search_condition = 169, 
		RULE_groupby_clause = 170, RULE_grouping_element_list = 171, RULE_grouping_element = 172, 
		RULE_ordinary_grouping_set = 173, RULE_ordinary_grouping_set_list = 174, 
		RULE_rollup_list = 175, RULE_cube_list = 176, RULE_empty_grouping_set = 177, 
		RULE_having_clause = 178, RULE_row_value_predicand_list = 179, RULE_query_expression = 180, 
		RULE_query_expression_body = 181, RULE_non_join_query_expression = 182, 
		RULE_query_term = 183, RULE_non_join_query_term = 184, RULE_query_primary = 185, 
		RULE_non_join_query_primary = 186, RULE_simple_table = 187, RULE_explicit_table = 188, 
		RULE_table_or_query_name = 189, RULE_schema_qualified_name = 190, RULE_query_specification = 191, 
		RULE_select_list = 192, RULE_select_sublist = 193, RULE_derived_column = 194, 
		RULE_qualified_asterisk = 195, RULE_set_qualifier = 196, RULE_column_reference = 197, 
		RULE_as_clause = 198, RULE_column_reference_list = 199, RULE_scalar_subquery = 200, 
		RULE_row_subquery = 201, RULE_table_subquery = 202, RULE_subquery = 203, 
		RULE_predicate = 204, RULE_comparison_predicate = 205, RULE_comp_op = 206, 
		RULE_between_predicate = 207, RULE_between_predicate_part_2 = 208, RULE_in_predicate = 209, 
		RULE_in_predicate_value = 210, RULE_in_value_list = 211, RULE_pattern_matching_predicate = 212, 
		RULE_pattern_matcher = 213, RULE_negativable_matcher = 214, RULE_regex_matcher = 215, 
		RULE_null_predicate = 216, RULE_quantified_comparison_predicate = 217, 
		RULE_quantifier = 218, RULE_all = 219, RULE_some = 220, RULE_exists_predicate = 221, 
		RULE_unique_predicate = 222, RULE_primary_datetime_field = 223, RULE_non_second_primary_datetime_field = 224, 
		RULE_extended_datetime_field = 225, RULE_routine_invocation = 226, RULE_function_names_for_reserved_words = 227, 
		RULE_function_name = 228, RULE_sql_argument_list = 229, RULE_orderby_clause = 230, 
		RULE_sort_specifier_list = 231, RULE_sort_specifier = 232, RULE_order_specification = 233, 
		RULE_limit_clause = 234, RULE_null_ordering = 235, RULE_insert_statement = 236;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"schema_create", "schema_alter", "alter_function_statement", "function_action", 
		"index_statement", "create_extension_statement", "set_statement", "create_trigger_statement", 
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
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALTER) | (1L << CREATE) | (1L << GRANT))) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (REVOKE - 98)) | (1L << (COMMENT - 98)) | (1L << (DROP - 98)))) != 0) || _la==SET) {
				{
				{
				setState(474); statement();
				setState(476);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(475); match(SEMI_COLON);
					}
				}

				}
				}
				setState(482);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(483); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(485); schema_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(487); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(489); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(494);
			switch (_input.LA(1)) {
			case CREATE:
			case GRANT:
			case REVOKE:
			case COMMENT:
			case SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(491); schema_create();
				}
				break;
			case ALTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(492); schema_alter();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 3);
				{
				setState(493); drop_table_statement();
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
			setState(508);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(496); create_table_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(497); index_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(498); create_extension_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(499); create_trigger_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(500); create_function_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(501); create_sequence_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(502); create_schema_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(503); create_view_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(504); comment_on_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(505); revoke_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(506); set_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(507); grant_statement();
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
			enterOuterAlt(_localctx, 1);
			{
			setState(510); alter_function_statement();
			}
		}
		catch (RecognitionException re) {
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
			setState(548);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(512); match(ALTER);
				setState(513); match(FUNCTION);
				setState(514); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(515); function_parameters();
				setState(517); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(516); function_action();
					}
					}
					setState(519); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (RETURNS - 97)) | (1L << (STRICT - 97)) | (1L << (CALLED - 97)))) != 0) || _la==EXTERNAL || _la==SECURITY || _la==STABLE || _la==VOLATILE );
				setState(522);
				_la = _input.LA(1);
				if (_la==RESTRICT) {
					{
					setState(521); match(RESTRICT);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(524); match(ALTER);
				setState(525); match(FUNCTION);
				setState(526); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(527); function_parameters();
				setState(528); match(RENAME);
				setState(529); match(TO);
				setState(530); ((Alter_function_statementContext)_localctx).new_name = schema_qualified_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(532); match(ALTER);
				setState(533); match(FUNCTION);
				setState(534); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(535); function_parameters();
				setState(536); match(OWNER);
				setState(537); match(TO);
				setState(538); ((Alter_function_statementContext)_localctx).new_owner = identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(540); match(ALTER);
				setState(541); match(FUNCTION);
				setState(542); ((Alter_function_statementContext)_localctx).name = schema_qualified_name();
				setState(543); function_parameters();
				setState(544); match(SET);
				setState(545); match(SCHEMA);
				setState(546); ((Alter_function_statementContext)_localctx).new_schema = schema_qualified_name();
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
		enterRule(_localctx, 16, RULE_function_action);
		int _la;
		try {
			setState(595);
			switch (_input.LA(1)) {
			case CALLED:
				enterOuterAlt(_localctx, 1);
				{
				setState(550); match(CALLED);
				setState(551); match(ON);
				setState(552); match(NULL);
				setState(553); match(INPUT);
				}
				break;
			case RETURNS:
				enterOuterAlt(_localctx, 2);
				{
				setState(554); match(RETURNS);
				setState(555); match(NULL);
				setState(556); match(ON);
				setState(557); match(NULL);
				setState(558); match(INPUT);
				}
				break;
			case STRICT:
				enterOuterAlt(_localctx, 3);
				{
				setState(559); match(STRICT);
				setState(560); match(IMMUTABLE);
				}
				break;
			case STABLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(561); match(STABLE);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(562); match(VOLATILE);
				setState(564);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(563); match(EXTERNAL);
					}
				}

				setState(566); match(SECURITY);
				setState(567); match(INVOKER);
				}
				break;
			case EXTERNAL:
			case SECURITY:
				enterOuterAlt(_localctx, 6);
				{
				setState(569);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(568); match(EXTERNAL);
					}
				}

				setState(571); match(SECURITY);
				setState(572); match(DEFINER);
				setState(573); match(COST);
				setState(574); ((Function_actionContext)_localctx).execution_cost = match(NUMBER);
				setState(575); match(ROWS);
				setState(576); ((Function_actionContext)_localctx).result_rows = match(NUMBER);
				setState(577); match(SET);
				setState(578); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(584);
				switch (_input.LA(1)) {
				case TO:
					{
					setState(579); match(TO);
					setState(580); ((Function_actionContext)_localctx).value = identifier();
					}
					break;
				case EQUAL:
					{
					setState(581); match(EQUAL);
					setState(582); ((Function_actionContext)_localctx).value = identifier();
					}
					break;
				case DEFAULT:
					{
					setState(583); match(DEFAULT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(586); match(SET);
				setState(587); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(588); match(FROM);
				setState(589); match(CURRENT);
				setState(590); match(RESET);
				setState(591); ((Function_actionContext)_localctx).configuration_parameter = identifier();
				setState(592); match(RESET);
				setState(593); match(ALL);
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
		enterRule(_localctx, 18, RULE_index_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597); match(CREATE);
			setState(599);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(598); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(601); match(INDEX);
			setState(602); ((Index_statementContext)_localctx).n = identifier();
			setState(603); match(ON);
			setState(604); ((Index_statementContext)_localctx).t = schema_qualified_name();
			setState(606);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(605); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(608); match(LEFT_PAREN);
			setState(609); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(610); match(RIGHT_PAREN);
			setState(612);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(611); ((Index_statementContext)_localctx).p = param_clause();
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
		enterRule(_localctx, 20, RULE_create_extension_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614); match(CREATE);
			setState(615); match(EXTENSION);
			setState(619);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(616); match(IF);
				setState(617); match(NOT);
				setState(618); match(EXISTS);
				}
			}

			setState(621); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(623);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(622); match(WITH);
				}
			}

			setState(627);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(625); match(SCHEMA);
				setState(626); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(631);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(629); match(VERSION);
				setState(630); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(635);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(633); match(FROM);
				setState(634); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
		enterRule(_localctx, 22, RULE_set_statement);
		int _la;
		try {
			int _alt;
			setState(676);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(637); match(SET);
				setState(639);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(638);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(641); ((Set_statementContext)_localctx).config_param = identifier();
				setState(642);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(654); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(649);
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
						case Character_String_Literal:
							{
							setState(643); ((Set_statementContext)_localctx).value = value_expression();
							}
							break;
						case QUOTE:
							{
							setState(644); match(QUOTE);
							setState(645); ((Set_statementContext)_localctx).value = value_expression();
							setState(646); match(QUOTE);
							}
							break;
						case DEFAULT:
							{
							setState(648); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(652);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(651); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(656); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(658); match(SET);
				setState(660);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(659);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(662); match(TIME);
				setState(663); match(ZONE);
				setState(672); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(667);
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
							{
							setState(664); ((Set_statementContext)_localctx).timezone = identifier();
							}
							break;
						case LOCAL:
							{
							setState(665); match(LOCAL);
							}
							break;
						case DEFAULT:
							{
							setState(666); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(670);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(669); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(674); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		enterRule(_localctx, 24, RULE_create_trigger_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(678); match(CREATE);
			setState(680);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(679); match(CONSTRAINT);
				}
			}

			setState(682); match(TRIGGER);
			setState(683); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(688);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(684); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(685); match(INSTEAD);
				setState(686); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(687); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(705);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(690); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(691); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(692); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				{
				setState(693); match(UPDATE);
				setState(703);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(694); match(OF);
					setState(699); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(695); ((Create_trigger_statementContext)_localctx).columnName = identifier();
							setState(697);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(696); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(701); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(707); match(ON);
			setState(708); ((Create_trigger_statementContext)_localctx).tabl_name = schema_qualified_name();
			setState(711);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(709); match(FROM);
				setState(710); ((Create_trigger_statementContext)_localctx).referenced_table_name = schema_qualified_name();
				}
			}

			setState(722);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(713); match(NOT);
				setState(714); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(716);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(715); match(DEFERRABLE);
					}
				}

				{
				setState(718); match(INITIALLY);
				setState(719); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(720); match(INITIALLY);
				setState(721); match(DEFERRED);
				}
				}
				break;
			}
			setState(730);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(724); match(FOR);
				setState(726);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(725); match(EACH);
					}
				}

				setState(728); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(729); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(734);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(732); match(WHEN);
				{
				setState(733); boolean_value_expression();
				}
				}
			}

			setState(736); match(EXECUTE);
			setState(737); match(PROCEDURE);
			setState(738); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(739); match(LEFT_PAREN);
			setState(744);
			_la = _input.LA(1);
			if (((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier) {
				{
				setState(740); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(742);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(741); match(COMMA);
					}
				}

				}
			}

			setState(746); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 26, RULE_revoke_statement);
		int _la;
		try {
			int _alt;
			setState(1127);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(748); match(REVOKE);
				setState(752);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(749); match(GRANT);
					setState(750); match(OPTION);
					setState(751); match(FOR);
					}
				}

				setState(763);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(755); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(754);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (REFERENCES - 94)) | (1L << (SELECT - 94)) | (1L << (TRIGGER - 94)) | (1L << (TRUNCATE - 94)) | (1L << (UPDATE - 94)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(757); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (REFERENCES - 94)) | (1L << (SELECT - 94)) | (1L << (TRIGGER - 94)) | (1L << (TRUNCATE - 94)) | (1L << (UPDATE - 94)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(759); match(ALL);
					setState(761);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(760); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(765); match(ON);
				setState(783);
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
					{
					setState(770); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(767);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(766); match(TABLE);
							}
						}

						setState(769); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
						}
						}
						setState(772); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 111)) & ~0x3f) == 0 && ((1L << (_la - 111)) & ((1L << (TABLE - 111)) | (1L << (ADMIN - 111)) | (1L << (AVG - 111)) | (1L << (BETWEEN - 111)) | (1L << (BY - 111)) | (1L << (CACHE - 111)) | (1L << (CALLED - 111)) | (1L << (CLASS - 111)) | (1L << (CENTURY - 111)) | (1L << (CHARACTER - 111)) | (1L << (CHECK - 111)) | (1L << (COLLECT - 111)) | (1L << (COALESCE - 111)) | (1L << (COLUMN - 111)) | (1L << (COMMENT - 111)) | (1L << (COMMENTS - 111)) | (1L << (COMMIT - 111)) | (1L << (CONFIGURATION - 111)) | (1L << (COST - 111)) | (1L << (COUNT - 111)) | (1L << (CUBE - 111)) | (1L << (CURRENT - 111)) | (1L << (CYCLE - 111)) | (1L << (DATA - 111)) | (1L << (DAY - 111)) | (1L << (DEC - 111)) | (1L << (DECADE - 111)) | (1L << (DEFINER - 111)) | (1L << (DICTIONARY - 111)) | (1L << (DOW - 111)) | (1L << (DOY - 111)) | (1L << (DROP - 111)) | (1L << (EPOCH - 111)) | (1L << (EVERY - 111)) | (1L << (EXISTS - 111)) | (1L << (EXTERNAL - 111)) | (1L << (EXTRACT - 111)) | (1L << (FAMILY - 111)) | (1L << (FILTER - 111)) | (1L << (FIRST - 111)) | (1L << (FORMAT - 111)) | (1L << (FUSION - 111)) | (1L << (GROUPING - 111)) | (1L << (HASH - 111)) | (1L << (INDEX - 111)))) != 0) || ((((_la - 176)) & ~0x3f) == 0 && ((1L << (_la - 176)) & ((1L << (INCREMENT - 176)) | (1L << (INPUT - 176)) | (1L << (INSERT - 176)) | (1L << (INTERSECTION - 176)) | (1L << (ISCACHABLE - 176)) | (1L << (ISODOW - 176)) | (1L << (ISOYEAR - 176)) | (1L << (ISSTRICT - 176)) | (1L << (LANGUAGE - 176)) | (1L << (LARGE - 176)) | (1L << (LAST - 176)) | (1L << (LESS - 176)) | (1L << (LIST - 176)) | (1L << (LOCATION - 176)) | (1L << (MATCH - 176)) | (1L << (MAX - 176)) | (1L << (MAXVALUE - 176)) | (1L << (MICROSECONDS - 176)) | (1L << (MILLENNIUM - 176)) | (1L << (MILLISECONDS - 176)) | (1L << (MIN - 176)) | (1L << (MINVALUE - 176)) | (1L << (MINUTE - 176)) | (1L << (MONTH - 176)) | (1L << (NATIONAL - 176)) | (1L << (NO - 176)) | (1L << (NONE - 176)) | (1L << (NULLIF - 176)) | (1L << (OBJECT - 176)) | (1L << (ON - 176)) | (1L << (OPTION - 176)) | (1L << (OPTIONS - 176)) | (1L << (OVERWRITE - 176)) | (1L << (PARSER - 176)) | (1L << (PARTIAL - 176)) | (1L << (PARTITION - 176)) | (1L << (PARTITIONS - 176)) | (1L << (PRECISION - 176)) | (1L << (PUBLIC - 176)) | (1L << (PURGE - 176)) | (1L << (QUARTER - 176)) | (1L << (RANGE - 176)) | (1L << (REGEXP - 176)) | (1L << (RENAME - 176)) | (1L << (RESET - 176)) | (1L << (RLIKE - 176)) | (1L << (ROLLUP - 176)) | (1L << (SEARCH - 176)) | (1L << (SECOND - 176)) | (1L << (SECURITY - 176)) | (1L << (SERVER - 176)) | (1L << (SET - 176)) | (1L << (SIMILAR - 176)) | (1L << (SIMPLE - 176)) | (1L << (STABLE - 176)) | (1L << (START - 176)) | (1L << (STORAGE - 176)) | (1L << (STDDEV_POP - 176)) | (1L << (STDDEV_SAMP - 176)) | (1L << (SUBPARTITION - 176)) | (1L << (SUM - 176)) | (1L << (TABLESPACE - 176)) | (1L << (TEMPLATE - 176)))) != 0) || ((((_la - 240)) & ~0x3f) == 0 && ((1L << (_la - 240)) & ((1L << (THAN - 240)) | (1L << (TIMEZONE - 240)) | (1L << (TIMEZONE_HOUR - 240)) | (1L << (TIMEZONE_MINUTE - 240)) | (1L << (TRIM - 240)) | (1L << (TO - 240)) | (1L << (TYPE - 240)) | (1L << (UNKNOWN - 240)) | (1L << (UNLOGGED - 240)) | (1L << (VALUES - 240)) | (1L << (VAR_SAMP - 240)) | (1L << (VAR_POP - 240)) | (1L << (VARYING - 240)) | (1L << (VOLATILE - 240)) | (1L << (WEEK - 240)) | (1L << (WINDOW - 240)) | (1L << (WRAPPER - 240)) | (1L << (YEAR - 240)) | (1L << (ZONE - 240)) | (1L << (BOOLEAN - 240)) | (1L << (BOOL - 240)) | (1L << (BIT - 240)) | (1L << (VARBIT - 240)) | (1L << (INT1 - 240)) | (1L << (INT2 - 240)) | (1L << (INT4 - 240)) | (1L << (INT8 - 240)) | (1L << (TINYINT - 240)) | (1L << (SMALLINT - 240)) | (1L << (INT - 240)) | (1L << (INTEGER - 240)) | (1L << (BIGINT - 240)) | (1L << (FLOAT4 - 240)) | (1L << (FLOAT8 - 240)) | (1L << (REAL - 240)) | (1L << (FLOAT - 240)) | (1L << (DOUBLE - 240)) | (1L << (NUMERIC - 240)) | (1L << (DECIMAL - 240)) | (1L << (CHAR - 240)) | (1L << (VARCHAR - 240)) | (1L << (NCHAR - 240)) | (1L << (NVARCHAR - 240)) | (1L << (DATE - 240)) | (1L << (TIME - 240)) | (1L << (TIMETZ - 240)) | (1L << (TIMESTAMP - 240)) | (1L << (TIMESTAMPTZ - 240)) | (1L << (TEXT - 240)) | (1L << (UUID - 240)) | (1L << (VARBINARY - 240)) | (1L << (BLOB - 240)) | (1L << (BYTEA - 240)) | (1L << (INET4 - 240)) | (1L << (VOID - 240)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					}
					break;
				case ALL:
					{
					setState(774); match(ALL);
					setState(775); match(TABLES);
					setState(776); match(IN);
					setState(777); match(SCHEMA);
					setState(779); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(778); ((Revoke_statementContext)_localctx).schema_name = identifier();
						}
						}
						setState(781); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(785); revoke_from_cascade_restrict();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(787); match(REVOKE);
				setState(791);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(788); match(GRANT);
					setState(789); match(OPTION);
					setState(790); match(FOR);
					}
				}

				setState(824);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(805); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(793);
						_la = _input.LA(1);
						if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (REFERENCES - 94)) | (1L << (SELECT - 94)) | (1L << (UPDATE - 94)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(794); match(LEFT_PAREN);
						setState(799); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(795); ((Revoke_statementContext)_localctx).column = identifier();
							setState(797);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(796); match(COMMA);
								}
							}

							}
							}
							setState(801); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
						setState(803); match(RIGHT_PAREN);
						}
						}
						setState(807); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (REFERENCES - 94)) | (1L << (SELECT - 94)) | (1L << (UPDATE - 94)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(809); match(ALL);
					setState(811);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(810); match(PRIVILEGES);
						}
					}

					setState(813); match(LEFT_PAREN);
					setState(818); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(814); ((Revoke_statementContext)_localctx).column = identifier();
						setState(816);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(815); match(COMMA);
							}
						}

						}
						}
						setState(820); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					setState(822); match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(826); match(ON);
				setState(828);
				_la = _input.LA(1);
				if (_la==TABLE) {
					{
					setState(827); match(TABLE);
					}
				}

				setState(834); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(830); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
					setState(832);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(831); match(COMMA);
						}
					}

					}
					}
					setState(836); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(838); revoke_from_cascade_restrict();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(840); match(REVOKE);
				setState(844);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(841); match(GRANT);
					setState(842); match(OPTION);
					setState(843); match(FOR);
					}
				}

				setState(855);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(847); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(846);
						_la = _input.LA(1);
						if ( !(((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (SELECT - 104)) | (1L << (UPDATE - 104)) | (1L << (USAGE - 104)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(849); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (SELECT - 104)) | (1L << (UPDATE - 104)) | (1L << (USAGE - 104)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(851); match(ALL);
					setState(853);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(852); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(857); match(ON);
				setState(879);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(858); match(SEQUENCE);
					setState(863); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(859); ((Revoke_statementContext)_localctx).sequence_name = schema_qualified_name();
						setState(861);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(860); match(COMMA);
							}
						}

						}
						}
						setState(865); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					}
					break;
				case ALL:
					{
					setState(867); match(ALL);
					setState(868); match(SEQUENCES);
					setState(869); match(IN);
					setState(870); match(SCHEMA);
					setState(875); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(871); ((Revoke_statementContext)_localctx).schema_name = identifier();
						setState(873);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(872); match(COMMA);
							}
						}

						}
						}
						setState(877); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(881); revoke_from_cascade_restrict();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(883); match(REVOKE);
				setState(887);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(884); match(GRANT);
					setState(885); match(OPTION);
					setState(886); match(FOR);
					}
				}

				setState(898);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(890); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(889);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(892); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(894); match(ALL);
					setState(896);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(895); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(900); match(ON);
				setState(901); match(DATABASE);
				setState(906); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(902); ((Revoke_statementContext)_localctx).database_name = identifier();
					setState(904);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(903); match(COMMA);
						}
					}

					}
					}
					setState(908); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(910); revoke_from_cascade_restrict();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(912); match(REVOKE);
				setState(916);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(913); match(GRANT);
					setState(914); match(OPTION);
					setState(915); match(FOR);
					}
				}

				setState(923);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(918); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(919); match(ALL);
					setState(921);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(920); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(925); match(ON);
				setState(926); match(FOREIGN);
				setState(927); match(DATA);
				setState(928); match(WRAPPER);
				setState(933); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(929); ((Revoke_statementContext)_localctx).fdw_name = schema_qualified_name();
					setState(931);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(930); match(COMMA);
						}
					}

					}
					}
					setState(935); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(937); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(939); match(REVOKE);
				setState(943);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(940); match(GRANT);
					setState(941); match(OPTION);
					setState(942); match(FOR);
					}
				}

				setState(950);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(945); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(946); match(ALL);
					setState(948);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(947); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(952); match(ON);
				setState(953); match(FOREIGN);
				setState(954); match(SERVER);
				setState(959); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(955); ((Revoke_statementContext)_localctx).server_name = identifier();
					setState(957);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(956); match(COMMA);
						}
					}

					}
					}
					setState(961); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(963); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(965); match(REVOKE);
				setState(969);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(966); match(GRANT);
					setState(967); match(OPTION);
					setState(968); match(FOR);
					}
				}

				setState(976);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(971); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(972); match(ALL);
					setState(974);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(973); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(978); match(ON);
				setState(981);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(979); function_definition();
					}
					break;
				case ALL:
					{
					setState(980); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(983); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(985); match(REVOKE);
				setState(989);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(986); match(GRANT);
					setState(987); match(OPTION);
					setState(988); match(FOR);
					}
				}

				setState(996);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(991); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(992); match(ALL);
					setState(994);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(993); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(998); match(ON);
				setState(999); match(LANGUAGE);
				setState(1004); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1000); ((Revoke_statementContext)_localctx).lang_name = identifier();
					setState(1002);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1001); match(COMMA);
						}
					}

					}
					}
					setState(1006); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1008); revoke_from_cascade_restrict();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1010); match(REVOKE);
				setState(1014);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1011); match(GRANT);
					setState(1012); match(OPTION);
					setState(1013); match(FOR);
					}
				}

				setState(1029);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1021); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(1021);
						switch (_input.LA(1)) {
						case SELECT:
							{
							setState(1016); match(SELECT);
							}
							break;
						case UPDATE:
							{
							setState(1017); match(UPDATE);
							setState(1019);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1018); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(1023); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1025); match(ALL);
					setState(1027);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1026); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1031); match(ON);
				setState(1032); match(LARGE);
				setState(1033); match(OBJECT);
				setState(1038); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1034); ((Revoke_statementContext)_localctx).loid = identifier();
					setState(1036);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1035); match(COMMA);
						}
					}

					}
					}
					setState(1040); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1042); revoke_from_cascade_restrict();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1044); match(REVOKE);
				setState(1048);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1045); match(GRANT);
					setState(1046); match(OPTION);
					setState(1047); match(FOR);
					}
				}

				setState(1062);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1054); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1050);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1052);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1051); match(COMMA);
							}
						}

						}
						}
						setState(1056); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1058); match(ALL);
					setState(1060);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1059); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1064); match(ON);
				setState(1065); match(SCHEMA);
				setState(1070); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1066); ((Revoke_statementContext)_localctx).schema_name = identifier();
					setState(1068);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1067); match(COMMA);
						}
					}

					}
					}
					setState(1072); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1074); revoke_from_cascade_restrict();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1076); match(REVOKE);
				setState(1080);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(1077); match(GRANT);
					setState(1078); match(OPTION);
					setState(1079); match(FOR);
					}
				}

				setState(1087);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1082); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1083); match(ALL);
					setState(1085);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1084); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1089); match(ON);
				setState(1090); match(TABLESPACE);
				setState(1095); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1091); ((Revoke_statementContext)_localctx).tablespace_name = identifier();
					setState(1093);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1092); match(COMMA);
						}
					}

					}
					}
					setState(1097); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1099); revoke_from_cascade_restrict();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1101); match(REVOKE);
				setState(1105);
				switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
				case 1:
					{
					setState(1102); match(ADMIN);
					setState(1103); match(OPTION);
					setState(1104); match(FOR);
					}
					break;
				}
				setState(1111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1107); ((Revoke_statementContext)_localctx).role_name = identifier();
					setState(1109);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1108); match(COMMA);
						}
					}

					}
					}
					setState(1113); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1115); match(FROM);
				setState(1120); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1116); ((Revoke_statementContext)_localctx).role_name = identifier();
						setState(1118);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1117); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1122); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1125);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(1124);
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
		enterRule(_localctx, 28, RULE_revoke_from_cascade_restrict);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1129); match(FROM);
			setState(1138); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1138);
					switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
					case 1:
						{
						setState(1131);
						_la = _input.LA(1);
						if (_la==GROUP) {
							{
							setState(1130); match(GROUP);
							}
						}

						setState(1133); ((Revoke_from_cascade_restrictContext)_localctx).role_name = identifier();
						}
						break;
					case 2:
						{
						setState(1134); match(PUBLIC);
						setState(1136);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1135); match(COMMA);
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
				setState(1140); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1143);
			_la = _input.LA(1);
			if (_la==CASCADE || _la==RESTRICT) {
				{
				setState(1142);
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
		enterRule(_localctx, 30, RULE_grant_statement);
		int _la;
		try {
			int _alt;
			setState(1470);
			switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1145); match(GRANT);
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
						if ( !(_la==DELETE || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (REFERENCES - 94)) | (1L << (SELECT - 94)) | (1L << (TRIGGER - 94)) | (1L << (TRUNCATE - 94)) | (1L << (UPDATE - 94)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1149); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (REFERENCES - 94)) | (1L << (SELECT - 94)) | (1L << (TRIGGER - 94)) | (1L << (TRUNCATE - 94)) | (1L << (UPDATE - 94)))) != 0) || _la==INSERT );
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
				setState(1181);
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
					{
					{
					setState(1159);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1158); match(TABLE);
						}
					}

					setState(1165); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1161); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
							setState(1163);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1162); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1167); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(1169); match(ALL);
					setState(1170); match(TABLES);
					setState(1171); match(IN);
					setState(1172); match(SCHEMA);
					setState(1177); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1173); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(1175);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1174); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1179); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1183); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1185); match(GRANT);
				setState(1211);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1195); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1186);
						_la = _input.LA(1);
						if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (REFERENCES - 94)) | (1L << (SELECT - 94)) | (1L << (UPDATE - 94)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1191); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1187); ((Grant_statementContext)_localctx).column = identifier();
								setState(1189);
								_la = _input.LA(1);
								if (_la==COMMA) {
									{
									setState(1188); match(COMMA);
									}
								}

								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1193); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(1197); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (REFERENCES - 94)) | (1L << (SELECT - 94)) | (1L << (UPDATE - 94)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1199); match(ALL);
					setState(1201);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1200); match(PRIVILEGES);
						}
					}

					setState(1207); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1203); ((Grant_statementContext)_localctx).column = identifier();
							setState(1205);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1204); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1209); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1213); match(ON);
				setState(1221); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1215);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1214); match(TABLE);
							}
						}

						setState(1217); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
						setState(1219);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1218); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1223); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1225); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1227); match(GRANT);
				setState(1240);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(1232); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1228);
						_la = _input.LA(1);
						if ( !(((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (SELECT - 104)) | (1L << (UPDATE - 104)) | (1L << (USAGE - 104)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1230);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1229); match(COMMA);
							}
						}

						}
						}
						setState(1234); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (SELECT - 104)) | (1L << (UPDATE - 104)) | (1L << (USAGE - 104)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1236); match(ALL);
					setState(1238);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1237); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1242); match(ON);
				setState(1264);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1248); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1243); match(SEQUENCE);
						setState(1244); ((Grant_statementContext)_localctx).sequence_name = identifier();
						setState(1246);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1245); match(COMMA);
							}
						}

						}
						}
						setState(1250); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(1252); match(ALL);
					setState(1253); match(SEQUENCES);
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
							setState(1256); ((Grant_statementContext)_localctx).schema_name = identifier();
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
						_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1266); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1268); match(GRANT);
				setState(1281);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1273); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1269);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1271);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1270); match(COMMA);
							}
						}

						}
						}
						setState(1275); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(1277); match(ALL);
					setState(1279);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1278); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1283); match(ON);
				setState(1284); match(DATABASE);
				setState(1289); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1285); ((Grant_statementContext)_localctx).database_name = identifier();
						setState(1287);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1286); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1291); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,160,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1293); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1295); match(GRANT);
				setState(1301);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1296); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1297); match(ALL);
					setState(1299);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1298); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1303); match(ON);
				setState(1304); match(FOREIGN);
				setState(1305); match(DATA);
				setState(1306); match(WRAPPER);
				setState(1311); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1307); ((Grant_statementContext)_localctx).fdw_name = identifier();
						setState(1309);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1308); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1313); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1315); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1317); match(GRANT);
				setState(1323);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1318); match(USAGE);
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
				setState(1326); match(FOREIGN);
				setState(1327); match(SERVER);
				setState(1332); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1328); ((Grant_statementContext)_localctx).server_name = identifier();
						setState(1330);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1329); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1334); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1336); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1338); match(GRANT);
				setState(1344);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1339); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1340); match(ALL);
					setState(1342);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1341); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1346); match(ON);
				setState(1349);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1347); function_definition();
					}
					break;
				case ALL:
					{
					setState(1348); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1351); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1353); match(GRANT);
				setState(1359);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1354); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1355); match(ALL);
					setState(1357);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1356); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1361); match(ON);
				setState(1362); match(LANGUAGE);
				setState(1367); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1363); ((Grant_statementContext)_localctx).lang_name = identifier();
						setState(1365);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1364); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1369); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1371); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1373); match(GRANT);
				setState(1386);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1378); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1374);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1376);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1375); match(COMMA);
							}
						}

						}
						}
						setState(1380); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1382); match(ALL);
					setState(1384);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1383); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1388); match(ON);
				setState(1389); match(LARGE);
				setState(1390); match(OBJECT);
				setState(1395); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1391); ((Grant_statementContext)_localctx).loid = identifier();
						setState(1393);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1392); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1397); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1399); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1401); match(GRANT);
				setState(1414);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1406); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1402);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1404);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1403); match(COMMA);
							}
						}

						}
						}
						setState(1408); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(1410); match(ALL);
					setState(1412);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1411); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1416); match(ON);
				setState(1417); match(SCHEMA);
				setState(1422); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1418); ((Grant_statementContext)_localctx).schema_name = identifier();
						setState(1420);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1419); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1424); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1426); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1428); match(GRANT);
				setState(1434);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1429); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1430); match(ALL);
					setState(1432);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1431); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1436); match(ON);
				setState(1437); match(TABLESPACE);
				setState(1442); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1438); ((Grant_statementContext)_localctx).tablespace_name = identifier();
						setState(1440);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1439); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1444); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1446); grant_to_rule();
				setState(1447); match(GRANT);
				setState(1452); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1448); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1450);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1449); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1454); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1456); match(TO);
				setState(1461); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1457); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1459);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1458); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1463); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1468);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1465); match(WITH);
					setState(1466); match(ADMIN);
					setState(1467); match(OPTION);
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
		enterRule(_localctx, 32, RULE_grant_to_rule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1472); match(TO);
			setState(1483); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1474);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1473); match(GROUP);
						}
					}

					setState(1478);
					switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
					case 1:
						{
						{
						setState(1476); ((Grant_to_ruleContext)_localctx).role_name = identifier();
						}
						}
						break;
					case 2:
						{
						setState(1477); match(PUBLIC);
						}
						break;
					}
					setState(1481);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1480); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1485); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1490);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1487); match(WITH);
				setState(1488); match(GRANT);
				setState(1489); match(OPTION);
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
		enterRule(_localctx, 34, RULE_comment_on_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1492); match(COMMENT);
			setState(1493); match(ON);
			setState(1612);
			switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
			case 1:
				{
				setState(1494); match(AGGREGATE);
				setState(1495); ((Comment_on_statementContext)_localctx).agg_name = schema_qualified_name();
				setState(1496); match(LEFT_PAREN);
				setState(1503);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (SETOF - 106)) | (1L << (TRIGGER - 106)) | (1L << (CHARACTER - 106)) | (1L << (DEC - 106)))) != 0) || ((((_la - 200)) & ~0x3f) == 0 && ((1L << (_la - 200)) & ((1L << (NATIONAL - 200)) | (1L << (BOOLEAN - 200)) | (1L << (BOOL - 200)) | (1L << (BIT - 200)) | (1L << (VARBIT - 200)))) != 0) || ((((_la - 264)) & ~0x3f) == 0 && ((1L << (_la - 264)) & ((1L << (INT1 - 264)) | (1L << (INT2 - 264)) | (1L << (INT4 - 264)) | (1L << (INT8 - 264)) | (1L << (TINYINT - 264)) | (1L << (SMALLINT - 264)) | (1L << (INT - 264)) | (1L << (INTEGER - 264)) | (1L << (BIGINT - 264)) | (1L << (FLOAT4 - 264)) | (1L << (FLOAT8 - 264)) | (1L << (REAL - 264)) | (1L << (REGCLASS - 264)) | (1L << (FLOAT - 264)) | (1L << (DOUBLE - 264)) | (1L << (NUMERIC - 264)) | (1L << (DECIMAL - 264)) | (1L << (CHAR - 264)) | (1L << (VARCHAR - 264)) | (1L << (NCHAR - 264)) | (1L << (NVARCHAR - 264)) | (1L << (DATE - 264)) | (1L << (TIME - 264)) | (1L << (TIMETZ - 264)) | (1L << (TIMESTAMP - 264)) | (1L << (TIMESTAMPTZ - 264)) | (1L << (TEXT - 264)) | (1L << (UUID - 264)) | (1L << (BINARY - 264)) | (1L << (VARBINARY - 264)) | (1L << (BLOB - 264)) | (1L << (BYTEA - 264)) | (1L << (INET4 - 264)) | (1L << (VOID - 264)))) != 0)) {
					{
					{
					setState(1497); ((Comment_on_statementContext)_localctx).agg_type = data_type();
					setState(1499);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1498); match(COMMA);
						}
					}

					}
					}
					setState(1505);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1506); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1508); match(CAST);
				setState(1509); match(LEFT_PAREN);
				setState(1510); ((Comment_on_statementContext)_localctx).source_type = data_type();
				setState(1511); match(AS);
				setState(1512); ((Comment_on_statementContext)_localctx).target_type = data_type();
				setState(1513); match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(1515); match(COLLATION);
				setState(1516); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 4:
				{
				setState(1517); match(COLUMN);
				setState(1518); ((Comment_on_statementContext)_localctx).column_name = schema_qualified_name();
				}
				break;
			case 5:
				{
				setState(1519); match(CONSTRAINT);
				setState(1520); ((Comment_on_statementContext)_localctx).constraint_name = schema_qualified_name();
				setState(1521); match(ON);
				setState(1522); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 6:
				{
				setState(1524); match(CONVERSION);
				setState(1525); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 7:
				{
				setState(1526); match(DATABASE);
				setState(1527); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 8:
				{
				setState(1528); match(DOMAIN);
				setState(1529); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 9:
				{
				setState(1530); match(EXTENSION);
				setState(1531); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 10:
				{
				setState(1532); match(FOREIGN);
				setState(1533); match(DATA);
				setState(1534); match(WRAPPER);
				setState(1535); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 11:
				{
				setState(1536); match(FOREIGN);
				setState(1537); match(TABLE);
				setState(1538); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 12:
				{
				setState(1539); function_definition();
				}
				break;
			case 13:
				{
				setState(1540); match(INDEX);
				setState(1541); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 14:
				{
				setState(1542); match(LARGE);
				setState(1543); match(OBJECT);
				setState(1544); ((Comment_on_statementContext)_localctx).large_object_oid = identifier();
				}
				break;
			case 15:
				{
				setState(1545); match(OPERATOR);
				setState(1546); ((Comment_on_statementContext)_localctx).operator_name = schema_qualified_name();
				setState(1547); match(LEFT_PAREN);
				setState(1548); ((Comment_on_statementContext)_localctx).left_type = data_type();
				setState(1549); match(COMMA);
				setState(1550); ((Comment_on_statementContext)_localctx).right_type = data_type();
				setState(1551); match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(1553); match(OPERATOR);
				setState(1554); match(CLASS);
				setState(1555); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1556); match(USING);
				setState(1557); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 17:
				{
				setState(1559); match(OPERATOR);
				setState(1560); match(FAMILY);
				setState(1561); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1562); match(USING);
				setState(1563); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 18:
				{
				setState(1566);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1565); match(PROCEDURAL);
					}
				}

				setState(1568); match(LANGUAGE);
				setState(1569); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 19:
				{
				setState(1570); match(ROLE);
				setState(1571); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 20:
				{
				setState(1572); match(RULE);
				setState(1573); ((Comment_on_statementContext)_localctx).rule_name = schema_qualified_name();
				setState(1574); match(ON);
				setState(1575); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 21:
				{
				setState(1577); match(SCHEMA);
				setState(1578); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 22:
				{
				setState(1579); match(SEQUENCE);
				setState(1580); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 23:
				{
				setState(1581); match(SERVER);
				setState(1582); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 24:
				{
				setState(1583); match(TABLE);
				setState(1584); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 25:
				{
				setState(1585); match(TABLESPACE);
				setState(1586); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 26:
				{
				setState(1587); match(TEXT);
				setState(1588); match(SEARCH);
				setState(1589); match(CONFIGURATION);
				setState(1590); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 27:
				{
				setState(1591); match(TEXT);
				setState(1592); match(SEARCH);
				setState(1593); match(DICTIONARY);
				setState(1594); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 28:
				{
				setState(1595); match(TEXT);
				setState(1596); match(SEARCH);
				setState(1597); match(PARSER);
				setState(1598); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 29:
				{
				setState(1599); match(TEXT);
				setState(1600); match(SEARCH);
				setState(1601); match(TEMPLATE);
				setState(1602); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 30:
				{
				setState(1603); match(TRIGGER);
				setState(1604); ((Comment_on_statementContext)_localctx).trigger_name = schema_qualified_name();
				setState(1605); match(ON);
				setState(1606); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 31:
				{
				setState(1608); match(TYPE);
				setState(1609); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 32:
				{
				setState(1610); match(VIEW);
				setState(1611); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			}
			setState(1614); match(IS);
			setState(1615); match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 36, RULE_create_function_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1617); match(CREATE);
			setState(1620);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(1618); match(OR);
				setState(1619); match(REPLACE);
				}
			}

			setState(1622); match(FUNCTION);
			setState(1623); ((Create_function_statementContext)_localctx).name = schema_qualified_name();
			setState(1624); function_parameters();
			setState(1641);
			switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
			case 1:
				{
				setState(1625); match(RETURNS);
				setState(1626); ((Create_function_statementContext)_localctx).rettype = data_type();
				}
				break;
			case 2:
				{
				setState(1627); match(RETURNS);
				setState(1628); match(TABLE);
				setState(1629); match(LEFT_PAREN);
				setState(1635); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1630); ((Create_function_statementContext)_localctx).column_name = identifier();
					setState(1631); ((Create_function_statementContext)_localctx).column_type = data_type();
					setState(1633);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1632); match(COMMA);
						}
					}

					}
					}
					setState(1637); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1639); match(RIGHT_PAREN);
				}
				break;
			}
			setState(1696); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1696);
					switch ( getInterpreter().adaptivePredict(_input,215,_ctx) ) {
					case 1:
						{
						setState(1643); match(LANGUAGE);
						setState(1644); ((Create_function_statementContext)_localctx).lang_name = identifier();
						}
						break;
					case 2:
						{
						setState(1645); match(WINDOW);
						}
						break;
					case 3:
						{
						setState(1646); match(IMMUTABLE);
						}
						break;
					case 4:
						{
						setState(1647); match(STABLE);
						}
						break;
					case 5:
						{
						setState(1648); match(VOLATILE);
						}
						break;
					case 6:
						{
						setState(1649); match(CALLED);
						setState(1650); match(ON);
						setState(1651); match(NULL);
						setState(1652); match(INPUT);
						}
						break;
					case 7:
						{
						setState(1653); match(RETURNS);
						setState(1654); match(NULL);
						setState(1655); match(ON);
						setState(1656); match(NULL);
						setState(1657); match(INPUT);
						}
						break;
					case 8:
						{
						setState(1658); match(STRICT);
						}
						break;
					case 9:
						{
						setState(1660);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1659); match(EXTERNAL);
							}
						}

						setState(1662); match(SECURITY);
						setState(1663); match(INVOKER);
						}
						break;
					case 10:
						{
						setState(1665);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1664); match(EXTERNAL);
							}
						}

						setState(1667); match(SECURITY);
						setState(1668); match(DEFINER);
						}
						break;
					case 11:
						{
						setState(1669); match(COST);
						setState(1670); ((Create_function_statementContext)_localctx).execution_cost = match(NUMBER);
						}
						break;
					case 12:
						{
						setState(1671); match(ROWS);
						setState(1672); ((Create_function_statementContext)_localctx).result_rows = match(NUMBER);
						}
						break;
					case 13:
						{
						setState(1673); match(SET);
						setState(1674); ((Create_function_statementContext)_localctx).configuration_parameter = identifier();
						setState(1681);
						switch (_input.LA(1)) {
						case TO:
							{
							setState(1675); match(TO);
							setState(1676); ((Create_function_statementContext)_localctx).value = identifier();
							}
							break;
						case EQUAL:
							{
							setState(1677); match(EQUAL);
							setState(1678); ((Create_function_statementContext)_localctx).value = identifier();
							}
							break;
						case FROM:
							{
							setState(1679); match(FROM);
							setState(1680); match(CURRENT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1687);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1683); match(COMMA);
							setState(1684); ((Create_function_statementContext)_localctx).value = identifier();
							}
							}
							setState(1689);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case 14:
						{
						setState(1690); match(AS);
						setState(1691); function_body();
						}
						break;
					case 15:
						{
						setState(1692); match(AS);
						setState(1693); match(Character_String_Literal);
						setState(1694); match(COMMA);
						setState(1695); match(Character_String_Literal);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1698); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,216,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1712);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1700); match(WITH);
				setState(1701); match(LEFT_PAREN);
				setState(1706); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1702); ((Create_function_statementContext)_localctx).attribute = function_attribute();
					setState(1704);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1703); match(COMMA);
						}
					}

					}
					}
					setState(1708); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ISCACHABLE || _la==ISSTRICT );
				setState(1710); match(RIGHT_PAREN);
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
		enterRule(_localctx, 38, RULE_function_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1714); match(LEFT_PAREN);
			setState(1732);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IN || _la==INOUT || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (OUT - 80)) | (1L << (SETOF - 80)) | (1L << (TRIGGER - 80)) | (1L << (VARIADIC - 80)) | (1L << (ADMIN - 80)) | (1L << (AVG - 80)) | (1L << (BETWEEN - 80)) | (1L << (BY - 80)) | (1L << (CACHE - 80)) | (1L << (CALLED - 80)) | (1L << (CLASS - 80)) | (1L << (CENTURY - 80)) | (1L << (CHARACTER - 80)) | (1L << (CHECK - 80)) | (1L << (COLLECT - 80)) | (1L << (COALESCE - 80)) | (1L << (COLUMN - 80)) | (1L << (COMMENT - 80)))) != 0) || ((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & ((1L << (COMMENTS - 144)) | (1L << (COMMIT - 144)) | (1L << (CONFIGURATION - 144)) | (1L << (COST - 144)) | (1L << (COUNT - 144)) | (1L << (CUBE - 144)) | (1L << (CURRENT - 144)) | (1L << (CYCLE - 144)) | (1L << (DATA - 144)) | (1L << (DAY - 144)) | (1L << (DEC - 144)) | (1L << (DECADE - 144)) | (1L << (DEFINER - 144)) | (1L << (DICTIONARY - 144)) | (1L << (DOW - 144)) | (1L << (DOY - 144)) | (1L << (DROP - 144)) | (1L << (EPOCH - 144)) | (1L << (EVERY - 144)) | (1L << (EXISTS - 144)) | (1L << (EXTERNAL - 144)) | (1L << (EXTRACT - 144)) | (1L << (FAMILY - 144)) | (1L << (FILTER - 144)) | (1L << (FIRST - 144)) | (1L << (FORMAT - 144)) | (1L << (FUSION - 144)) | (1L << (GROUPING - 144)) | (1L << (HASH - 144)) | (1L << (INDEX - 144)) | (1L << (INCREMENT - 144)) | (1L << (INPUT - 144)) | (1L << (INSERT - 144)) | (1L << (INTERSECTION - 144)) | (1L << (ISCACHABLE - 144)) | (1L << (ISODOW - 144)) | (1L << (ISOYEAR - 144)) | (1L << (ISSTRICT - 144)) | (1L << (LANGUAGE - 144)) | (1L << (LARGE - 144)) | (1L << (LAST - 144)) | (1L << (LESS - 144)) | (1L << (LIST - 144)) | (1L << (LOCATION - 144)) | (1L << (MATCH - 144)) | (1L << (MAX - 144)) | (1L << (MAXVALUE - 144)) | (1L << (MICROSECONDS - 144)) | (1L << (MILLENNIUM - 144)) | (1L << (MILLISECONDS - 144)) | (1L << (MIN - 144)) | (1L << (MINVALUE - 144)) | (1L << (MINUTE - 144)) | (1L << (MONTH - 144)) | (1L << (NATIONAL - 144)) | (1L << (NO - 144)) | (1L << (NONE - 144)) | (1L << (NULLIF - 144)) | (1L << (OBJECT - 144)) | (1L << (ON - 144)) | (1L << (OPTION - 144)) | (1L << (OPTIONS - 144)))) != 0) || ((((_la - 208)) & ~0x3f) == 0 && ((1L << (_la - 208)) & ((1L << (OVERWRITE - 208)) | (1L << (PARSER - 208)) | (1L << (PARTIAL - 208)) | (1L << (PARTITION - 208)) | (1L << (PARTITIONS - 208)) | (1L << (PRECISION - 208)) | (1L << (PUBLIC - 208)) | (1L << (PURGE - 208)) | (1L << (QUARTER - 208)) | (1L << (RANGE - 208)) | (1L << (REGEXP - 208)) | (1L << (RENAME - 208)) | (1L << (RESET - 208)) | (1L << (RLIKE - 208)) | (1L << (ROLLUP - 208)) | (1L << (SEARCH - 208)) | (1L << (SECOND - 208)) | (1L << (SECURITY - 208)) | (1L << (SERVER - 208)) | (1L << (SET - 208)) | (1L << (SIMILAR - 208)) | (1L << (SIMPLE - 208)) | (1L << (STABLE - 208)) | (1L << (START - 208)) | (1L << (STORAGE - 208)) | (1L << (STDDEV_POP - 208)) | (1L << (STDDEV_SAMP - 208)) | (1L << (SUBPARTITION - 208)) | (1L << (SUM - 208)) | (1L << (TABLESPACE - 208)) | (1L << (TEMPLATE - 208)) | (1L << (THAN - 208)) | (1L << (TIMEZONE - 208)) | (1L << (TIMEZONE_HOUR - 208)) | (1L << (TIMEZONE_MINUTE - 208)) | (1L << (TRIM - 208)) | (1L << (TO - 208)) | (1L << (TYPE - 208)) | (1L << (UNKNOWN - 208)) | (1L << (UNLOGGED - 208)) | (1L << (VALUES - 208)) | (1L << (VAR_SAMP - 208)) | (1L << (VAR_POP - 208)) | (1L << (VARYING - 208)) | (1L << (VOLATILE - 208)) | (1L << (WEEK - 208)) | (1L << (WINDOW - 208)) | (1L << (WRAPPER - 208)) | (1L << (YEAR - 208)) | (1L << (ZONE - 208)) | (1L << (BOOLEAN - 208)) | (1L << (BOOL - 208)) | (1L << (BIT - 208)) | (1L << (VARBIT - 208)) | (1L << (INT1 - 208)) | (1L << (INT2 - 208)) | (1L << (INT4 - 208)) | (1L << (INT8 - 208)) | (1L << (TINYINT - 208)) | (1L << (SMALLINT - 208)) | (1L << (INT - 208)) | (1L << (INTEGER - 208)))) != 0) || ((((_la - 272)) & ~0x3f) == 0 && ((1L << (_la - 272)) & ((1L << (BIGINT - 272)) | (1L << (FLOAT4 - 272)) | (1L << (FLOAT8 - 272)) | (1L << (REAL - 272)) | (1L << (REGCLASS - 272)) | (1L << (FLOAT - 272)) | (1L << (DOUBLE - 272)) | (1L << (NUMERIC - 272)) | (1L << (DECIMAL - 272)) | (1L << (CHAR - 272)) | (1L << (VARCHAR - 272)) | (1L << (NCHAR - 272)) | (1L << (NVARCHAR - 272)) | (1L << (DATE - 272)) | (1L << (TIME - 272)) | (1L << (TIMETZ - 272)) | (1L << (TIMESTAMP - 272)) | (1L << (TIMESTAMPTZ - 272)) | (1L << (TEXT - 272)) | (1L << (UUID - 272)) | (1L << (BINARY - 272)) | (1L << (VARBINARY - 272)) | (1L << (BLOB - 272)) | (1L << (BYTEA - 272)) | (1L << (INET4 - 272)) | (1L << (VOID - 272)) | (1L << (DOUBLE_QUOTE - 272)) | (1L << (Identifier - 272)))) != 0)) {
				{
				{
				setState(1716);
				_la = _input.LA(1);
				if (_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) {
					{
					setState(1715); ((Function_parametersContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1719);
				switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
				case 1:
					{
					setState(1718); ((Function_parametersContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1721); ((Function_parametersContext)_localctx).argtype = data_type();
				setState(1725);
				switch (_input.LA(1)) {
				case DEFAULT:
					{
					setState(1722); match(DEFAULT);
					}
					break;
				case EQUAL:
					{
					setState(1723); match(EQUAL);
					setState(1724); ((Function_parametersContext)_localctx).def_value = value_expression();
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
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1728);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1727); match(COMMA);
					}
				}

				}
				}
				setState(1734);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1735); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 40, RULE_function_body);
		try {
			setState(1739);
			switch (_input.LA(1)) {
			case DOUBLE_DOLLAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1737); function_body_separator();
				}
				break;
			case DOUBLE_UNDER_DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1738); function_body_separator_dollar_under();
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
		enterRule(_localctx, 42, RULE_function_body_separator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1741); match(DOUBLE_DOLLAR);
			setState(1745);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << ALTER) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INNER) | (1L << INTERSECT) | (1L << INTO) | (1L << INOUT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INSTEAD - 64)) | (1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (OWNER - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)) | (1L << (VARIADIC - 64)) | (1L << (VIEW - 64)) | (1L << (WHEN - 64)) | (1L << (WHERE - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MAXVALUE - 192)) | (1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (ON - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RENAME - 192)) | (1L << (RESET - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TABLES - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VERSION - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (WINDOW - 256)) | (1L << (WRAPPER - 256)) | (1L << (YEAR - 256)) | (1L << (ZONE - 256)) | (1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (VOID - 256)) | (1L << (Similar_To - 256)) | (1L << (Not_Similar_To - 256)) | (1L << (Similar_To_Case_Insensitive - 256)) | (1L << (Not_Similar_To_Case_Insensitive - 256)) | (1L << (CAST_EXPRESSION - 256)) | (1L << (ASSIGN - 256)) | (1L << (EQUAL - 256)) | (1L << (COLON - 256)) | (1L << (SEMI_COLON - 256)) | (1L << (COMMA - 256)) | (1L << (CONCATENATION_OPERATOR - 256)) | (1L << (NOT_EQUAL - 256)) | (1L << (LTH - 256)) | (1L << (LEQ - 256)) | (1L << (GTH - 256)) | (1L << (GEQ - 256)) | (1L << (LEFT_PAREN - 256)) | (1L << (RIGHT_PAREN - 256)) | (1L << (PLUS - 256)) | (1L << (MINUS - 256)) | (1L << (MULTIPLY - 256)) | (1L << (DIVIDE - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (MODULAR - 320)) | (1L << (DOT - 320)) | (1L << (UNDERLINE - 320)) | (1L << (VERTICAL_BAR - 320)) | (1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (DOUBLE_UNDER_DOLLAR - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)))) != 0)) {
				{
				{
				setState(1742);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==DOUBLE_DOLLAR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(1747);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1748); match(DOUBLE_DOLLAR);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 44, RULE_function_body_separator_dollar_under);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1750); match(DOUBLE_UNDER_DOLLAR);
			setState(1754);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << ALTER) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INNER) | (1L << INTERSECT) | (1L << INTO) | (1L << INOUT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INSTEAD - 64)) | (1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (OWNER - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)) | (1L << (VARIADIC - 64)) | (1L << (VIEW - 64)) | (1L << (WHEN - 64)) | (1L << (WHERE - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (WITH - 128)) | (1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MAXVALUE - 192)) | (1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (ON - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RENAME - 192)) | (1L << (RESET - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TABLES - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VERSION - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (WINDOW - 256)) | (1L << (WRAPPER - 256)) | (1L << (YEAR - 256)) | (1L << (ZONE - 256)) | (1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (VOID - 256)) | (1L << (Similar_To - 256)) | (1L << (Not_Similar_To - 256)) | (1L << (Similar_To_Case_Insensitive - 256)) | (1L << (Not_Similar_To_Case_Insensitive - 256)) | (1L << (CAST_EXPRESSION - 256)) | (1L << (ASSIGN - 256)) | (1L << (EQUAL - 256)) | (1L << (COLON - 256)) | (1L << (SEMI_COLON - 256)) | (1L << (COMMA - 256)) | (1L << (CONCATENATION_OPERATOR - 256)) | (1L << (NOT_EQUAL - 256)) | (1L << (LTH - 256)) | (1L << (LEQ - 256)) | (1L << (GTH - 256)) | (1L << (GEQ - 256)) | (1L << (LEFT_PAREN - 256)) | (1L << (RIGHT_PAREN - 256)) | (1L << (PLUS - 256)) | (1L << (MINUS - 256)) | (1L << (MULTIPLY - 256)) | (1L << (DIVIDE - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (MODULAR - 320)) | (1L << (DOT - 320)) | (1L << (UNDERLINE - 320)) | (1L << (VERTICAL_BAR - 320)) | (1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (DOUBLE_DOLLAR - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)))) != 0)) {
				{
				{
				setState(1751);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==DOUBLE_UNDER_DOLLAR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(1756);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1757); match(DOUBLE_UNDER_DOLLAR);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_function_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1759);
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
		enterRule(_localctx, 48, RULE_argmode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1761);
			_la = _input.LA(1);
			if ( !(_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) ) {
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
		enterRule(_localctx, 50, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1763); match(FUNCTION);
			setState(1764); ((Function_definitionContext)_localctx).func_name = identifier();
			setState(1765); match(LEFT_PAREN);
			setState(1781);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << IN) | (1L << INOUT))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LEFT - 70)) | (1L << (NOT - 70)) | (1L << (NULL - 70)) | (1L << (OUT - 70)) | (1L << (RIGHT - 70)) | (1L << (SETOF - 70)) | (1L << (SOME - 70)) | (1L << (TRIGGER - 70)) | (1L << (TRUE - 70)) | (1L << (VARIADIC - 70)) | (1L << (ADMIN - 70)) | (1L << (AVG - 70)) | (1L << (BETWEEN - 70)) | (1L << (BY - 70)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)) | (1L << (MILLENNIUM - 134)) | (1L << (MILLISECONDS - 134)) | (1L << (MIN - 134)) | (1L << (MINVALUE - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)) | (1L << (YEAR - 198)) | (1L << (ZONE - 198)) | (1L << (BOOLEAN - 198)) | (1L << (BOOL - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (REGCLASS - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (BINARY - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)) | (1L << (LEFT_PAREN - 262)) | (1L << (PLUS - 262)) | (1L << (MINUS - 262)) | (1L << (DOUBLE_QUOTE - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (NUMBER - 329)) | (1L << (REAL_NUMBER - 329)) | (1L << (Identifier - 329)) | (1L << (Character_String_Literal - 329)))) != 0)) {
				{
				{
				setState(1767);
				_la = _input.LA(1);
				if (_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) {
					{
					setState(1766); ((Function_definitionContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1770);
				switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
				case 1:
					{
					setState(1769); ((Function_definitionContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1774);
				switch ( getInterpreter().adaptivePredict(_input,230,_ctx) ) {
				case 1:
					{
					setState(1772); ((Function_definitionContext)_localctx).argtype_data = data_type();
					}
					break;
				case 2:
					{
					setState(1773); ((Function_definitionContext)_localctx).argtype_expres = value_expression();
					}
					break;
				}
				setState(1777);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1776); match(COMMA);
					}
				}

				}
				}
				setState(1783);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1784); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 52, RULE_functions_definition_schema);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1786); match(ALL);
			setState(1787); match(FUNCTIONS);
			setState(1788); match(IN);
			setState(1789); match(SCHEMA);
			setState(1794); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1790); ((Functions_definition_schemaContext)_localctx).schema_name = identifier();
					setState(1792);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1791); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1796); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,234,_ctx);
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
		enterRule(_localctx, 54, RULE_create_sequence_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1798); match(CREATE);
			setState(1800);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(1799);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1802); match(SEQUENCE);
			setState(1803); ((Create_sequence_statementContext)_localctx).name = schema_qualified_name();
			setState(1840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OWNED || _la==CACHE || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (CYCLE - 151)) | (1L << (INCREMENT - 151)) | (1L << (MAXVALUE - 151)) | (1L << (MINVALUE - 151)) | (1L << (NO - 151)))) != 0) || _la==START) {
				{
				setState(1838);
				switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
				case 1:
					{
					{
					setState(1804); match(INCREMENT);
					setState(1806);
					_la = _input.LA(1);
					if (_la==BY) {
						{
						setState(1805); match(BY);
						}
					}

					setState(1808); ((Create_sequence_statementContext)_localctx).incr = match(NUMBER);
					}
					}
					break;
				case 2:
					{
					setState(1813);
					switch (_input.LA(1)) {
					case MINVALUE:
						{
						setState(1809); match(MINVALUE);
						setState(1810); ((Create_sequence_statementContext)_localctx).minval = match(NUMBER);
						}
						break;
					case NO:
						{
						setState(1811); match(NO);
						setState(1812); match(MINVALUE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case 3:
					{
					setState(1819);
					switch (_input.LA(1)) {
					case MAXVALUE:
						{
						setState(1815); match(MAXVALUE);
						setState(1816); ((Create_sequence_statementContext)_localctx).maxval = numeric_type();
						}
						break;
					case NO:
						{
						setState(1817); match(NO);
						setState(1818); match(MAXVALUE);
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
					setState(1821); match(START);
					setState(1823);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(1822); match(WITH);
						}
					}

					setState(1825); ((Create_sequence_statementContext)_localctx).start_val = match(NUMBER);
					}
					}
					break;
				case 5:
					{
					{
					setState(1826); match(CACHE);
					setState(1827); ((Create_sequence_statementContext)_localctx).cache_val = match(NUMBER);
					}
					}
					break;
				case 6:
					{
					{
					setState(1829);
					_la = _input.LA(1);
					if (_la==NO) {
						{
						setState(1828); match(NO);
						}
					}

					setState(1831); match(CYCLE);
					}
					}
					break;
				case 7:
					{
					{
					setState(1832); match(OWNED);
					setState(1833); match(BY);
					setState(1836);
					switch ( getInterpreter().adaptivePredict(_input,241,_ctx) ) {
					case 1:
						{
						setState(1834); ((Create_sequence_statementContext)_localctx).col_name = schema_qualified_name();
						}
						break;
					case 2:
						{
						setState(1835); match(NONE);
						}
						break;
					}
					}
					}
					break;
				}
				}
				setState(1842);
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
		enterRule(_localctx, 56, RULE_create_schema_statement);
		int _la;
		try {
			int _alt;
			setState(1883);
			switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1843); match(CREATE);
				setState(1844); match(SCHEMA);
				setState(1845); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(1848);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(1846); match(AUTHORIZATION);
					setState(1847); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				setState(1853);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,245,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1850); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(1855);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,245,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1856); match(CREATE);
				setState(1857); match(SCHEMA);
				setState(1858); match(AUTHORIZATION);
				setState(1859); ((Create_schema_statementContext)_localctx).user_name = identifier();
				setState(1863);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,246,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1860); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(1865);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,246,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1866); match(CREATE);
				setState(1867); match(SCHEMA);
				setState(1868); match(IF);
				setState(1869); match(NOT);
				setState(1870); match(EXISTS);
				setState(1871); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(1874);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(1872); match(AUTHORIZATION);
					setState(1873); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1876); match(CREATE);
				setState(1877); match(SCHEMA);
				setState(1878); match(IF);
				setState(1879); match(NOT);
				setState(1880); match(EXISTS);
				setState(1881); match(AUTHORIZATION);
				setState(1882); ((Create_schema_statementContext)_localctx).user_name = identifier();
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
		enterRule(_localctx, 58, RULE_create_view_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1885); match(CREATE);
			setState(1888);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(1886); match(OR);
				setState(1887); match(REPLACE);
				}
			}

			setState(1891);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(1890);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1893); match(VIEW);
			setState(1894); ((Create_view_statementContext)_localctx).name = schema_qualified_name();
			setState(1901);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier) {
				{
				{
				setState(1895); ((Create_view_statementContext)_localctx).column_name = identifier();
				setState(1897);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1896); match(COMMA);
					}
				}

				}
				}
				setState(1903);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1917);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1904); match(WITH);
				setState(1905); match(LEFT_PAREN);
				setState(1911); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1906); ((Create_view_statementContext)_localctx).view_option_name = identifier();
					setState(1909);
					_la = _input.LA(1);
					if (_la==EQUAL) {
						{
						setState(1907); match(EQUAL);
						setState(1908); ((Create_view_statementContext)_localctx).view_option_value = identifier();
						}
					}

					}
					}
					setState(1913); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1915); match(RIGHT_PAREN);
				}
			}

			setState(1919); match(AS);
			setState(1920); query_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 60, RULE_query);
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
		enterRule(_localctx, 62, RULE_create_table_statement);
		int _la;
		try {
			int _alt;
			setState(2036);
			switch ( getInterpreter().adaptivePredict(_input,277,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1924); match(CREATE);
				setState(1930);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1926);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1925);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1928);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1929); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1932); match(TABLE);
				setState(1936);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1933); match(IF);
					setState(1934); match(NOT);
					setState(1935); match(EXISTS);
					}
				}

				setState(1938); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1939); match(LEFT_PAREN);
				setState(1970);
				_la = _input.LA(1);
				if (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (CONSTRAINT - 19)) | (1L << (EXCLUDE - 19)) | (1L << (FOREIGN - 19)) | (1L << (LIKE - 19)))) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (PRIMARY - 87)) | (1L << (UNIQUE - 87)) | (1L << (ADMIN - 87)) | (1L << (AVG - 87)) | (1L << (BETWEEN - 87)) | (1L << (BY - 87)) | (1L << (CACHE - 87)) | (1L << (CALLED - 87)) | (1L << (CLASS - 87)) | (1L << (CENTURY - 87)) | (1L << (CHARACTER - 87)) | (1L << (CHECK - 87)) | (1L << (COLLECT - 87)) | (1L << (COALESCE - 87)) | (1L << (COLUMN - 87)) | (1L << (COMMENT - 87)) | (1L << (COMMENTS - 87)) | (1L << (COMMIT - 87)) | (1L << (CONFIGURATION - 87)) | (1L << (COST - 87)) | (1L << (COUNT - 87)) | (1L << (CUBE - 87)) | (1L << (CURRENT - 87)))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (CYCLE - 151)) | (1L << (DATA - 151)) | (1L << (DAY - 151)) | (1L << (DEC - 151)) | (1L << (DECADE - 151)) | (1L << (DEFINER - 151)) | (1L << (DICTIONARY - 151)) | (1L << (DOW - 151)) | (1L << (DOY - 151)) | (1L << (DROP - 151)) | (1L << (EPOCH - 151)) | (1L << (EVERY - 151)) | (1L << (EXISTS - 151)) | (1L << (EXTERNAL - 151)) | (1L << (EXTRACT - 151)) | (1L << (FAMILY - 151)) | (1L << (FILTER - 151)) | (1L << (FIRST - 151)) | (1L << (FORMAT - 151)) | (1L << (FUSION - 151)) | (1L << (GROUPING - 151)) | (1L << (HASH - 151)) | (1L << (INDEX - 151)) | (1L << (INCREMENT - 151)) | (1L << (INPUT - 151)) | (1L << (INSERT - 151)) | (1L << (INTERSECTION - 151)) | (1L << (ISCACHABLE - 151)) | (1L << (ISODOW - 151)) | (1L << (ISOYEAR - 151)) | (1L << (ISSTRICT - 151)) | (1L << (LANGUAGE - 151)) | (1L << (LARGE - 151)) | (1L << (LAST - 151)) | (1L << (LESS - 151)) | (1L << (LIST - 151)) | (1L << (LOCATION - 151)) | (1L << (MATCH - 151)) | (1L << (MAX - 151)) | (1L << (MAXVALUE - 151)) | (1L << (MICROSECONDS - 151)) | (1L << (MILLENNIUM - 151)) | (1L << (MILLISECONDS - 151)) | (1L << (MIN - 151)) | (1L << (MINVALUE - 151)) | (1L << (MINUTE - 151)) | (1L << (MONTH - 151)) | (1L << (NATIONAL - 151)) | (1L << (NO - 151)) | (1L << (NONE - 151)) | (1L << (NULLIF - 151)) | (1L << (OBJECT - 151)) | (1L << (ON - 151)) | (1L << (OPTION - 151)) | (1L << (OPTIONS - 151)) | (1L << (OVERWRITE - 151)) | (1L << (PARSER - 151)) | (1L << (PARTIAL - 151)) | (1L << (PARTITION - 151)) | (1L << (PARTITIONS - 151)) | (1L << (PRECISION - 151)) | (1L << (PUBLIC - 151)))) != 0) || ((((_la - 215)) & ~0x3f) == 0 && ((1L << (_la - 215)) & ((1L << (PURGE - 215)) | (1L << (QUARTER - 215)) | (1L << (RANGE - 215)) | (1L << (REGEXP - 215)) | (1L << (RENAME - 215)) | (1L << (RESET - 215)) | (1L << (RLIKE - 215)) | (1L << (ROLLUP - 215)) | (1L << (SEARCH - 215)) | (1L << (SECOND - 215)) | (1L << (SECURITY - 215)) | (1L << (SERVER - 215)) | (1L << (SET - 215)) | (1L << (SIMILAR - 215)) | (1L << (SIMPLE - 215)) | (1L << (STABLE - 215)) | (1L << (START - 215)) | (1L << (STORAGE - 215)) | (1L << (STDDEV_POP - 215)) | (1L << (STDDEV_SAMP - 215)) | (1L << (SUBPARTITION - 215)) | (1L << (SUM - 215)) | (1L << (TABLESPACE - 215)) | (1L << (TEMPLATE - 215)) | (1L << (THAN - 215)) | (1L << (TIMEZONE - 215)) | (1L << (TIMEZONE_HOUR - 215)) | (1L << (TIMEZONE_MINUTE - 215)) | (1L << (TRIM - 215)) | (1L << (TO - 215)) | (1L << (TYPE - 215)) | (1L << (UNKNOWN - 215)) | (1L << (UNLOGGED - 215)) | (1L << (VALUES - 215)) | (1L << (VAR_SAMP - 215)) | (1L << (VAR_POP - 215)) | (1L << (VARYING - 215)) | (1L << (VOLATILE - 215)) | (1L << (WEEK - 215)) | (1L << (WINDOW - 215)) | (1L << (WRAPPER - 215)) | (1L << (YEAR - 215)) | (1L << (ZONE - 215)) | (1L << (BOOLEAN - 215)) | (1L << (BOOL - 215)) | (1L << (BIT - 215)) | (1L << (VARBIT - 215)) | (1L << (INT1 - 215)) | (1L << (INT2 - 215)) | (1L << (INT4 - 215)) | (1L << (INT8 - 215)) | (1L << (TINYINT - 215)) | (1L << (SMALLINT - 215)) | (1L << (INT - 215)) | (1L << (INTEGER - 215)) | (1L << (BIGINT - 215)) | (1L << (FLOAT4 - 215)) | (1L << (FLOAT8 - 215)) | (1L << (REAL - 215)) | (1L << (FLOAT - 215)) | (1L << (DOUBLE - 215)))) != 0) || ((((_la - 279)) & ~0x3f) == 0 && ((1L << (_la - 279)) & ((1L << (NUMERIC - 279)) | (1L << (DECIMAL - 279)) | (1L << (CHAR - 279)) | (1L << (VARCHAR - 279)) | (1L << (NCHAR - 279)) | (1L << (NVARCHAR - 279)) | (1L << (DATE - 279)) | (1L << (TIME - 279)) | (1L << (TIMETZ - 279)) | (1L << (TIMESTAMP - 279)) | (1L << (TIMESTAMPTZ - 279)) | (1L << (TEXT - 279)) | (1L << (UUID - 279)) | (1L << (VARBINARY - 279)) | (1L << (BLOB - 279)) | (1L << (BYTEA - 279)) | (1L << (INET4 - 279)) | (1L << (VOID - 279)) | (1L << (DOUBLE_QUOTE - 279)) | (1L << (Identifier - 279)))) != 0)) {
					{
					setState(1966); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1961);
						switch ( getInterpreter().adaptivePredict(_input,262,_ctx) ) {
						case 1:
							{
							{
							setState(1940); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1941); ((Create_table_statementContext)_localctx).datatype = data_type();
							setState(1944);
							_la = _input.LA(1);
							if (_la==COLLATE) {
								{
								setState(1942); match(COLLATE);
								setState(1943); ((Create_table_statementContext)_localctx).collation = identifier();
								}
							}

							setState(1949);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,260,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1946); ((Create_table_statementContext)_localctx).colmn_constraint = column_constraint();
									}
									} 
								}
								setState(1951);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,260,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1952); ((Create_table_statementContext)_localctx).tabl_constraint = table_constraint();
							}
							break;
						case 3:
							{
							{
							setState(1953); match(LIKE);
							setState(1954); ((Create_table_statementContext)_localctx).parent_table = identifier();
							setState(1958);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==EXCLUDING || _la==INCLUDING) {
								{
								{
								setState(1955); ((Create_table_statementContext)_localctx).like_opt = like_option();
								}
								}
								setState(1960);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							break;
						}
						setState(1964);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1963); match(COMMA);
							}
						}

						}
						}
						setState(1968); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (CONSTRAINT - 19)) | (1L << (EXCLUDE - 19)) | (1L << (FOREIGN - 19)) | (1L << (LIKE - 19)))) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (PRIMARY - 87)) | (1L << (UNIQUE - 87)) | (1L << (ADMIN - 87)) | (1L << (AVG - 87)) | (1L << (BETWEEN - 87)) | (1L << (BY - 87)) | (1L << (CACHE - 87)) | (1L << (CALLED - 87)) | (1L << (CLASS - 87)) | (1L << (CENTURY - 87)) | (1L << (CHARACTER - 87)) | (1L << (CHECK - 87)) | (1L << (COLLECT - 87)) | (1L << (COALESCE - 87)) | (1L << (COLUMN - 87)) | (1L << (COMMENT - 87)) | (1L << (COMMENTS - 87)) | (1L << (COMMIT - 87)) | (1L << (CONFIGURATION - 87)) | (1L << (COST - 87)) | (1L << (COUNT - 87)) | (1L << (CUBE - 87)) | (1L << (CURRENT - 87)))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (CYCLE - 151)) | (1L << (DATA - 151)) | (1L << (DAY - 151)) | (1L << (DEC - 151)) | (1L << (DECADE - 151)) | (1L << (DEFINER - 151)) | (1L << (DICTIONARY - 151)) | (1L << (DOW - 151)) | (1L << (DOY - 151)) | (1L << (DROP - 151)) | (1L << (EPOCH - 151)) | (1L << (EVERY - 151)) | (1L << (EXISTS - 151)) | (1L << (EXTERNAL - 151)) | (1L << (EXTRACT - 151)) | (1L << (FAMILY - 151)) | (1L << (FILTER - 151)) | (1L << (FIRST - 151)) | (1L << (FORMAT - 151)) | (1L << (FUSION - 151)) | (1L << (GROUPING - 151)) | (1L << (HASH - 151)) | (1L << (INDEX - 151)) | (1L << (INCREMENT - 151)) | (1L << (INPUT - 151)) | (1L << (INSERT - 151)) | (1L << (INTERSECTION - 151)) | (1L << (ISCACHABLE - 151)) | (1L << (ISODOW - 151)) | (1L << (ISOYEAR - 151)) | (1L << (ISSTRICT - 151)) | (1L << (LANGUAGE - 151)) | (1L << (LARGE - 151)) | (1L << (LAST - 151)) | (1L << (LESS - 151)) | (1L << (LIST - 151)) | (1L << (LOCATION - 151)) | (1L << (MATCH - 151)) | (1L << (MAX - 151)) | (1L << (MAXVALUE - 151)) | (1L << (MICROSECONDS - 151)) | (1L << (MILLENNIUM - 151)) | (1L << (MILLISECONDS - 151)) | (1L << (MIN - 151)) | (1L << (MINVALUE - 151)) | (1L << (MINUTE - 151)) | (1L << (MONTH - 151)) | (1L << (NATIONAL - 151)) | (1L << (NO - 151)) | (1L << (NONE - 151)) | (1L << (NULLIF - 151)) | (1L << (OBJECT - 151)) | (1L << (ON - 151)) | (1L << (OPTION - 151)) | (1L << (OPTIONS - 151)) | (1L << (OVERWRITE - 151)) | (1L << (PARSER - 151)) | (1L << (PARTIAL - 151)) | (1L << (PARTITION - 151)) | (1L << (PARTITIONS - 151)) | (1L << (PRECISION - 151)) | (1L << (PUBLIC - 151)))) != 0) || ((((_la - 215)) & ~0x3f) == 0 && ((1L << (_la - 215)) & ((1L << (PURGE - 215)) | (1L << (QUARTER - 215)) | (1L << (RANGE - 215)) | (1L << (REGEXP - 215)) | (1L << (RENAME - 215)) | (1L << (RESET - 215)) | (1L << (RLIKE - 215)) | (1L << (ROLLUP - 215)) | (1L << (SEARCH - 215)) | (1L << (SECOND - 215)) | (1L << (SECURITY - 215)) | (1L << (SERVER - 215)) | (1L << (SET - 215)) | (1L << (SIMILAR - 215)) | (1L << (SIMPLE - 215)) | (1L << (STABLE - 215)) | (1L << (START - 215)) | (1L << (STORAGE - 215)) | (1L << (STDDEV_POP - 215)) | (1L << (STDDEV_SAMP - 215)) | (1L << (SUBPARTITION - 215)) | (1L << (SUM - 215)) | (1L << (TABLESPACE - 215)) | (1L << (TEMPLATE - 215)) | (1L << (THAN - 215)) | (1L << (TIMEZONE - 215)) | (1L << (TIMEZONE_HOUR - 215)) | (1L << (TIMEZONE_MINUTE - 215)) | (1L << (TRIM - 215)) | (1L << (TO - 215)) | (1L << (TYPE - 215)) | (1L << (UNKNOWN - 215)) | (1L << (UNLOGGED - 215)) | (1L << (VALUES - 215)) | (1L << (VAR_SAMP - 215)) | (1L << (VAR_POP - 215)) | (1L << (VARYING - 215)) | (1L << (VOLATILE - 215)) | (1L << (WEEK - 215)) | (1L << (WINDOW - 215)) | (1L << (WRAPPER - 215)) | (1L << (YEAR - 215)) | (1L << (ZONE - 215)) | (1L << (BOOLEAN - 215)) | (1L << (BOOL - 215)) | (1L << (BIT - 215)) | (1L << (VARBIT - 215)) | (1L << (INT1 - 215)) | (1L << (INT2 - 215)) | (1L << (INT4 - 215)) | (1L << (INT8 - 215)) | (1L << (TINYINT - 215)) | (1L << (SMALLINT - 215)) | (1L << (INT - 215)) | (1L << (INTEGER - 215)) | (1L << (BIGINT - 215)) | (1L << (FLOAT4 - 215)) | (1L << (FLOAT8 - 215)) | (1L << (REAL - 215)) | (1L << (FLOAT - 215)) | (1L << (DOUBLE - 215)))) != 0) || ((((_la - 279)) & ~0x3f) == 0 && ((1L << (_la - 279)) & ((1L << (NUMERIC - 279)) | (1L << (DECIMAL - 279)) | (1L << (CHAR - 279)) | (1L << (VARCHAR - 279)) | (1L << (NCHAR - 279)) | (1L << (NVARCHAR - 279)) | (1L << (DATE - 279)) | (1L << (TIME - 279)) | (1L << (TIMETZ - 279)) | (1L << (TIMESTAMP - 279)) | (1L << (TIMESTAMPTZ - 279)) | (1L << (TEXT - 279)) | (1L << (UUID - 279)) | (1L << (VARBINARY - 279)) | (1L << (BLOB - 279)) | (1L << (BYTEA - 279)) | (1L << (INET4 - 279)) | (1L << (VOID - 279)) | (1L << (DOUBLE_QUOTE - 279)) | (1L << (Identifier - 279)))) != 0) );
					}
				}

				setState(1972); match(RIGHT_PAREN);
				setState(1985);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(1973); match(INHERITS);
					setState(1974); match(LEFT_PAREN);
					setState(1979); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1975); ((Create_table_statementContext)_localctx).parent_table = identifier();
						setState(1977);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1976); match(COMMA);
							}
						}

						}
						}
						setState(1981); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					setState(1983); match(RIGHT_PAREN);
					}
				}

				setState(1987); storage_parameter_oid();
				setState(1988); on_commit();
				setState(1989); table_space();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1991); match(CREATE);
				setState(1997);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1993);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1992);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1995);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1996); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1999); match(TABLE);
				setState(2003);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(2000); match(IF);
					setState(2001); match(NOT);
					setState(2002); match(EXISTS);
					}
				}

				setState(2005); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(2006); match(OF);
				setState(2007); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(2030);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2008); match(LEFT_PAREN);
					setState(2024); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2019);
						switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
						case 1:
							{
							{
							setState(2009); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(2010); match(WITH);
							setState(2011); match(OPTIONS);
							setState(2015);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,272,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(2012); ((Create_table_statementContext)_localctx).col_constraint = column_constraint();
									}
									} 
								}
								setState(2017);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,272,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(2018); table_constraint();
							}
							break;
						}
						setState(2022);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2021); match(COMMA);
							}
						}

						}
						}
						setState(2026); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (PRIMARY - 87)) | (1L << (UNIQUE - 87)) | (1L << (ADMIN - 87)) | (1L << (AVG - 87)) | (1L << (BETWEEN - 87)) | (1L << (BY - 87)) | (1L << (CACHE - 87)) | (1L << (CALLED - 87)) | (1L << (CLASS - 87)) | (1L << (CENTURY - 87)) | (1L << (CHARACTER - 87)) | (1L << (CHECK - 87)) | (1L << (COLLECT - 87)) | (1L << (COALESCE - 87)) | (1L << (COLUMN - 87)) | (1L << (COMMENT - 87)) | (1L << (COMMENTS - 87)) | (1L << (COMMIT - 87)) | (1L << (CONFIGURATION - 87)) | (1L << (COST - 87)) | (1L << (COUNT - 87)) | (1L << (CUBE - 87)) | (1L << (CURRENT - 87)))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (CYCLE - 151)) | (1L << (DATA - 151)) | (1L << (DAY - 151)) | (1L << (DEC - 151)) | (1L << (DECADE - 151)) | (1L << (DEFINER - 151)) | (1L << (DICTIONARY - 151)) | (1L << (DOW - 151)) | (1L << (DOY - 151)) | (1L << (DROP - 151)) | (1L << (EPOCH - 151)) | (1L << (EVERY - 151)) | (1L << (EXISTS - 151)) | (1L << (EXTERNAL - 151)) | (1L << (EXTRACT - 151)) | (1L << (FAMILY - 151)) | (1L << (FILTER - 151)) | (1L << (FIRST - 151)) | (1L << (FORMAT - 151)) | (1L << (FUSION - 151)) | (1L << (GROUPING - 151)) | (1L << (HASH - 151)) | (1L << (INDEX - 151)) | (1L << (INCREMENT - 151)) | (1L << (INPUT - 151)) | (1L << (INSERT - 151)) | (1L << (INTERSECTION - 151)) | (1L << (ISCACHABLE - 151)) | (1L << (ISODOW - 151)) | (1L << (ISOYEAR - 151)) | (1L << (ISSTRICT - 151)) | (1L << (LANGUAGE - 151)) | (1L << (LARGE - 151)) | (1L << (LAST - 151)) | (1L << (LESS - 151)) | (1L << (LIST - 151)) | (1L << (LOCATION - 151)) | (1L << (MATCH - 151)) | (1L << (MAX - 151)) | (1L << (MAXVALUE - 151)) | (1L << (MICROSECONDS - 151)) | (1L << (MILLENNIUM - 151)) | (1L << (MILLISECONDS - 151)) | (1L << (MIN - 151)) | (1L << (MINVALUE - 151)) | (1L << (MINUTE - 151)) | (1L << (MONTH - 151)) | (1L << (NATIONAL - 151)) | (1L << (NO - 151)) | (1L << (NONE - 151)) | (1L << (NULLIF - 151)) | (1L << (OBJECT - 151)) | (1L << (ON - 151)) | (1L << (OPTION - 151)) | (1L << (OPTIONS - 151)) | (1L << (OVERWRITE - 151)) | (1L << (PARSER - 151)) | (1L << (PARTIAL - 151)) | (1L << (PARTITION - 151)) | (1L << (PARTITIONS - 151)) | (1L << (PRECISION - 151)) | (1L << (PUBLIC - 151)))) != 0) || ((((_la - 215)) & ~0x3f) == 0 && ((1L << (_la - 215)) & ((1L << (PURGE - 215)) | (1L << (QUARTER - 215)) | (1L << (RANGE - 215)) | (1L << (REGEXP - 215)) | (1L << (RENAME - 215)) | (1L << (RESET - 215)) | (1L << (RLIKE - 215)) | (1L << (ROLLUP - 215)) | (1L << (SEARCH - 215)) | (1L << (SECOND - 215)) | (1L << (SECURITY - 215)) | (1L << (SERVER - 215)) | (1L << (SET - 215)) | (1L << (SIMILAR - 215)) | (1L << (SIMPLE - 215)) | (1L << (STABLE - 215)) | (1L << (START - 215)) | (1L << (STORAGE - 215)) | (1L << (STDDEV_POP - 215)) | (1L << (STDDEV_SAMP - 215)) | (1L << (SUBPARTITION - 215)) | (1L << (SUM - 215)) | (1L << (TABLESPACE - 215)) | (1L << (TEMPLATE - 215)) | (1L << (THAN - 215)) | (1L << (TIMEZONE - 215)) | (1L << (TIMEZONE_HOUR - 215)) | (1L << (TIMEZONE_MINUTE - 215)) | (1L << (TRIM - 215)) | (1L << (TO - 215)) | (1L << (TYPE - 215)) | (1L << (UNKNOWN - 215)) | (1L << (UNLOGGED - 215)) | (1L << (VALUES - 215)) | (1L << (VAR_SAMP - 215)) | (1L << (VAR_POP - 215)) | (1L << (VARYING - 215)) | (1L << (VOLATILE - 215)) | (1L << (WEEK - 215)) | (1L << (WINDOW - 215)) | (1L << (WRAPPER - 215)) | (1L << (YEAR - 215)) | (1L << (ZONE - 215)) | (1L << (BOOLEAN - 215)) | (1L << (BOOL - 215)) | (1L << (BIT - 215)) | (1L << (VARBIT - 215)) | (1L << (INT1 - 215)) | (1L << (INT2 - 215)) | (1L << (INT4 - 215)) | (1L << (INT8 - 215)) | (1L << (TINYINT - 215)) | (1L << (SMALLINT - 215)) | (1L << (INT - 215)) | (1L << (INTEGER - 215)) | (1L << (BIGINT - 215)) | (1L << (FLOAT4 - 215)) | (1L << (FLOAT8 - 215)) | (1L << (REAL - 215)) | (1L << (FLOAT - 215)) | (1L << (DOUBLE - 215)))) != 0) || ((((_la - 279)) & ~0x3f) == 0 && ((1L << (_la - 279)) & ((1L << (NUMERIC - 279)) | (1L << (DECIMAL - 279)) | (1L << (CHAR - 279)) | (1L << (VARCHAR - 279)) | (1L << (NCHAR - 279)) | (1L << (NVARCHAR - 279)) | (1L << (DATE - 279)) | (1L << (TIME - 279)) | (1L << (TIMETZ - 279)) | (1L << (TIMESTAMP - 279)) | (1L << (TIMESTAMPTZ - 279)) | (1L << (TEXT - 279)) | (1L << (UUID - 279)) | (1L << (VARBINARY - 279)) | (1L << (BLOB - 279)) | (1L << (BYTEA - 279)) | (1L << (INET4 - 279)) | (1L << (VOID - 279)) | (1L << (DOUBLE_QUOTE - 279)) | (1L << (Identifier - 279)))) != 0) );
					setState(2028); match(RIGHT_PAREN);
					}
				}

				setState(2032); storage_parameter_oid();
				setState(2033); on_commit();
				setState(2034); table_space();
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
		enterRule(_localctx, 64, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2038);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(2039);
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
		enterRule(_localctx, 66, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2043);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2041); match(CONSTRAINT);
				setState(2042); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2143);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(2045); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(2046); match(UNIQUE);
				setState(2047); match(LEFT_PAREN);
				setState(2052); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2048); ((Table_constraintContext)_localctx).column_name_unique = identifier();
					setState(2050);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2049); match(COMMA);
						}
					}

					}
					}
					setState(2054); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(2056); match(RIGHT_PAREN);
				setState(2057); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2059); match(PRIMARY);
				setState(2060); match(KEY);
				setState(2061); match(LEFT_PAREN);
				setState(2066); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2062); ((Table_constraintContext)_localctx).column_name_pr_key = identifier();
					setState(2064);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2063); match(COMMA);
						}
					}

					}
					}
					setState(2068); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(2070); match(RIGHT_PAREN);
				setState(2071); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(2073); match(EXCLUDE);
				setState(2076);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(2074); match(USING);
					setState(2075); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(2078); match(LEFT_PAREN);
				setState(2079); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(2080); match(WITH);
				setState(2085); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2081); ((Table_constraintContext)_localctx).operator = identifier();
					setState(2083);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2082); match(COMMA);
						}
					}

					}
					}
					setState(2087); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(2089); match(RIGHT_PAREN);
				setState(2090); index_parameters();
				setState(2096);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(2091); match(WHERE);
					setState(2092); match(LEFT_PAREN);
					setState(2093); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(2094); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(2098); match(FOREIGN);
				setState(2099); match(KEY);
				setState(2100); match(LEFT_PAREN);
				setState(2105); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2101); ((Table_constraintContext)_localctx).column_name_for_key = identifier();
					setState(2103);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2102); match(COMMA);
						}
					}

					}
					}
					setState(2107); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(2109); match(RIGHT_PAREN);
				setState(2110); match(REFERENCES);
				setState(2111); ((Table_constraintContext)_localctx).reftable = identifier();
				setState(2123);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2112); match(LEFT_PAREN);
					setState(2117); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2113); ((Table_constraintContext)_localctx).refcolumn = identifier();
						setState(2115);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2114); match(COMMA);
							}
						}

						}
						}
						setState(2119); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					setState(2121); match(RIGHT_PAREN);
					}
				}

				setState(2131);
				switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
				case 1:
					{
					{
					setState(2125); match(MATCH);
					setState(2126); match(FULL);
					}
					}
					break;
				case 2:
					{
					{
					setState(2127); match(MATCH);
					setState(2128); match(PARTIAL);
					}
					}
					break;
				case 3:
					{
					{
					setState(2129); match(MATCH);
					setState(2130); match(SIMPLE);
					}
					}
					break;
				}
				setState(2136);
				switch ( getInterpreter().adaptivePredict(_input,293,_ctx) ) {
				case 1:
					{
					setState(2133); match(ON);
					setState(2134); match(DELETE);
					setState(2135); ((Table_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2141);
				switch ( getInterpreter().adaptivePredict(_input,294,_ctx) ) {
				case 1:
					{
					setState(2138); match(ON);
					setState(2139); match(UPDATE);
					setState(2140); ((Table_constraintContext)_localctx).action_on_update = action();
					}
					break;
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2148);
			switch (_input.LA(1)) {
			case DEFERRABLE:
				{
				setState(2145); match(DEFERRABLE);
				}
				break;
			case NOT:
				{
				{
				setState(2146); match(NOT);
				setState(2147); match(DEFERRABLE);
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
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2154);
			switch ( getInterpreter().adaptivePredict(_input,297,_ctx) ) {
			case 1:
				{
				{
				setState(2150); match(INITIALLY);
				setState(2151); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2152); match(INITIALLY);
				setState(2153); match(IMMEDIATE);
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
		enterRule(_localctx, 68, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2158);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2156); match(CONSTRAINT);
				setState(2157); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2195);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(2160); match(NOT);
				setState(2161); match(NULL);
				}
				break;
			case NULL:
				{
				setState(2162); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(2163); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				setState(2164); match(DEFAULT);
				setState(2167);
				switch ( getInterpreter().adaptivePredict(_input,299,_ctx) ) {
				case 1:
					{
					setState(2165); ((Column_constraintContext)_localctx).default_expr_data = data_type();
					}
					break;
				case 2:
					{
					setState(2166); ((Column_constraintContext)_localctx).default_expr = value_expression();
					}
					break;
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(2169); match(UNIQUE);
				setState(2170); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2171); match(PRIMARY);
				setState(2172); match(KEY);
				setState(2173); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(2174); match(REFERENCES);
				setState(2175); ((Column_constraintContext)_localctx).reftable = schema_qualified_name();
				{
				{
				setState(2176); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(2183);
				switch ( getInterpreter().adaptivePredict(_input,300,_ctx) ) {
				case 1:
					{
					setState(2177); match(MATCH);
					setState(2178); match(FULL);
					}
					break;
				case 2:
					{
					setState(2179); match(MATCH);
					setState(2180); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(2181); match(MATCH);
					setState(2182); match(SIMPLE);
					}
					break;
				}
				setState(2188);
				switch ( getInterpreter().adaptivePredict(_input,301,_ctx) ) {
				case 1:
					{
					setState(2185); match(ON);
					setState(2186); match(DELETE);
					setState(2187); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2193);
				switch ( getInterpreter().adaptivePredict(_input,302,_ctx) ) {
				case 1:
					{
					setState(2190); match(ON);
					setState(2191); match(UPDATE);
					setState(2192); ((Column_constraintContext)_localctx).action_on_update = action();
					}
					break;
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2200);
			switch ( getInterpreter().adaptivePredict(_input,304,_ctx) ) {
			case 1:
				{
				setState(2197); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2198); match(NOT);
				setState(2199); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2206);
			switch ( getInterpreter().adaptivePredict(_input,305,_ctx) ) {
			case 1:
				{
				{
				setState(2202); match(INITIALLY);
				setState(2203); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2204); match(INITIALLY);
				setState(2205); match(IMMEDIATE);
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
		enterRule(_localctx, 70, RULE_check_boolean_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2208); match(CHECK);
			setState(2209); match(LEFT_PAREN);
			setState(2210); ((Check_boolean_expressionContext)_localctx).expression = boolean_value_expression();
			setState(2211); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 72, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2213); match(WITH);
			setState(2214); match(LEFT_PAREN);
			setState(2223); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2215); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(2218);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(2216); match(EQUAL);
					setState(2217); ((Storage_parameterContext)_localctx).value = identifier();
					}
				}

				setState(2221);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2220); match(COMMA);
					}
				}

				}
				}
				setState(2225); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
			setState(2227); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 74, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2234);
			switch ( getInterpreter().adaptivePredict(_input,309,_ctx) ) {
			case 1:
				{
				setState(2229); storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(2230); match(WITH);
				setState(2231); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(2232); match(WITHOUT);
				setState(2233); match(OIDS);
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
		enterRule(_localctx, 76, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2245);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(2236); match(ON);
				setState(2237); match(COMMIT);
				setState(2243);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(2238); match(PRESERVE);
					setState(2239); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(2240); match(DELETE);
					setState(2241); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(2242); match(DROP);
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
		enterRule(_localctx, 78, RULE_table_space);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2249);
			_la = _input.LA(1);
			if (_la==TABLESPACE) {
				{
				setState(2247); match(TABLESPACE);
				setState(2248); ((Table_spaceContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 80, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2257);
			switch ( getInterpreter().adaptivePredict(_input,313,_ctx) ) {
			case 1:
				{
				setState(2251); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(2252); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(2253); match(SET);
				setState(2254); match(NULL);
				}
				break;
			case 4:
				{
				setState(2255); match(SET);
				setState(2256); match(DEFAULT);
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
		enterRule(_localctx, 82, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2260);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2259); storage_parameter();
				}
			}

			setState(2266);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(2262); match(USING);
				setState(2263); match(INDEX);
				setState(2264); match(TABLESPACE);
				setState(2265); ((Index_parametersContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 84, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2268); match(LEFT_PAREN);
			setState(2269); field_element();
			setState(2274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2270); match(COMMA);
				setState(2271); field_element();
				}
				}
				setState(2276);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2277); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 86, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2279); ((Field_elementContext)_localctx).name = identifier();
			setState(2280); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 88, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2282); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 90, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2284); match(WITH);
			setState(2285); match(LEFT_PAREN);
			setState(2286); param();
			setState(2291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2287); match(COMMA);
				setState(2288); param();
				}
				}
				setState(2293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		enterRule(_localctx, 92, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2296); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(2297); match(EQUAL);
			setState(2298); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 94, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2300); match(USING);
			setState(2301); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 96, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2303); match(TABLESPACE);
			setState(2304); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 98, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2306); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 100, RULE_table_partitioning_clauses);
		try {
			setState(2312);
			switch ( getInterpreter().adaptivePredict(_input,318,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2308); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2309); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2310); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2311); column_partitions();
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
		enterRule(_localctx, 102, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2314); match(PARTITION);
			setState(2315); match(BY);
			setState(2316); match(RANGE);
			setState(2317); match(LEFT_PAREN);
			setState(2318); column_reference_list();
			setState(2319); match(RIGHT_PAREN);
			setState(2320); match(LEFT_PAREN);
			setState(2321); range_value_clause_list();
			setState(2322); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 104, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2324); range_value_clause();
			setState(2329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2325); match(COMMA);
				setState(2326); range_value_clause();
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
		enterRule(_localctx, 106, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2332); match(PARTITION);
			setState(2333); partition_name();
			setState(2334); match(VALUES);
			setState(2335); match(LESS);
			setState(2336); match(THAN);
			setState(2348);
			switch ( getInterpreter().adaptivePredict(_input,322,_ctx) ) {
			case 1:
				{
				setState(2337); match(LEFT_PAREN);
				setState(2338); value_expression();
				setState(2339); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(2342);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2341); match(LEFT_PAREN);
					}
				}

				setState(2344); match(MAXVALUE);
				setState(2346);
				switch ( getInterpreter().adaptivePredict(_input,321,_ctx) ) {
				case 1:
					{
					setState(2345); match(RIGHT_PAREN);
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
		enterRule(_localctx, 108, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2350); match(PARTITION);
			setState(2351); match(BY);
			setState(2352); match(HASH);
			setState(2353); match(LEFT_PAREN);
			setState(2354); column_reference_list();
			setState(2355); match(RIGHT_PAREN);
			setState(2361);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(2356); match(LEFT_PAREN);
				setState(2357); individual_hash_partitions();
				setState(2358); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(2360); hash_partitions_by_quantity();
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
		enterRule(_localctx, 110, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2363); individual_hash_partition();
			setState(2368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2364); match(COMMA);
				setState(2365); individual_hash_partition();
				}
				}
				setState(2370);
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
		enterRule(_localctx, 112, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2371); match(PARTITION);
			setState(2372); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 114, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2374); match(PARTITIONS);
			setState(2375); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 116, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2377); match(PARTITION);
			setState(2378); match(BY);
			setState(2379); match(LIST);
			setState(2380); match(LEFT_PAREN);
			setState(2381); column_reference_list();
			setState(2382); match(RIGHT_PAREN);
			setState(2383); match(LEFT_PAREN);
			setState(2384); list_value_clause_list();
			setState(2385); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 118, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2387); list_value_partition();
			setState(2392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2388); match(COMMA);
				setState(2389); list_value_partition();
				}
				}
				setState(2394);
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
		enterRule(_localctx, 120, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2395); match(PARTITION);
			setState(2396); partition_name();
			setState(2397); match(VALUES);
			setState(2399);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(2398); match(IN);
				}
			}

			setState(2401); match(LEFT_PAREN);
			setState(2402); in_value_list();
			setState(2403); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 122, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2405); match(PARTITION);
			setState(2406); match(BY);
			setState(2407); match(COLUMN);
			setState(2408); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 124, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2410); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 126, RULE_drop_table_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2412); match(DROP);
			setState(2413); match(TABLE);
			setState(2414); schema_qualified_name();
			setState(2416);
			_la = _input.LA(1);
			if (_la==PURGE) {
				{
				setState(2415); match(PURGE);
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
		enterRule(_localctx, 128, RULE_identifier);
		int _la;
		try {
			setState(2432);
			switch ( getInterpreter().adaptivePredict(_input,332,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2419);
				_la = _input.LA(1);
				if (_la==DOUBLE_QUOTE) {
					{
					setState(2418); match(DOUBLE_QUOTE);
					}
				}

				setState(2421); match(Identifier);
				setState(2423);
				switch ( getInterpreter().adaptivePredict(_input,329,_ctx) ) {
				case 1:
					{
					setState(2422); match(DOUBLE_QUOTE);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2426);
				_la = _input.LA(1);
				if (_la==DOUBLE_QUOTE) {
					{
					setState(2425); match(DOUBLE_QUOTE);
					}
				}

				setState(2428); nonreserved_keywords();
				setState(2430);
				switch ( getInterpreter().adaptivePredict(_input,331,_ctx) ) {
				case 1:
					{
					setState(2429); match(DOUBLE_QUOTE);
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
		enterRule(_localctx, 130, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2434);
			_la = _input.LA(1);
			if ( !(((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (ADMIN - 130)) | (1L << (AVG - 130)) | (1L << (BETWEEN - 130)) | (1L << (BY - 130)) | (1L << (CACHE - 130)) | (1L << (CALLED - 130)) | (1L << (CLASS - 130)) | (1L << (CENTURY - 130)) | (1L << (CHARACTER - 130)) | (1L << (CHECK - 130)) | (1L << (COLLECT - 130)) | (1L << (COALESCE - 130)) | (1L << (COLUMN - 130)) | (1L << (COMMENT - 130)) | (1L << (COMMENTS - 130)) | (1L << (COMMIT - 130)) | (1L << (CONFIGURATION - 130)) | (1L << (COST - 130)) | (1L << (COUNT - 130)) | (1L << (CUBE - 130)) | (1L << (CURRENT - 130)) | (1L << (CYCLE - 130)) | (1L << (DATA - 130)) | (1L << (DAY - 130)) | (1L << (DEC - 130)) | (1L << (DECADE - 130)) | (1L << (DEFINER - 130)) | (1L << (DICTIONARY - 130)) | (1L << (DOW - 130)) | (1L << (DOY - 130)) | (1L << (DROP - 130)) | (1L << (EPOCH - 130)) | (1L << (EVERY - 130)) | (1L << (EXISTS - 130)) | (1L << (EXTERNAL - 130)) | (1L << (EXTRACT - 130)) | (1L << (FAMILY - 130)) | (1L << (FILTER - 130)) | (1L << (FIRST - 130)) | (1L << (FORMAT - 130)) | (1L << (FUSION - 130)) | (1L << (GROUPING - 130)) | (1L << (HASH - 130)) | (1L << (INDEX - 130)) | (1L << (INCREMENT - 130)) | (1L << (INPUT - 130)) | (1L << (INSERT - 130)) | (1L << (INTERSECTION - 130)) | (1L << (ISCACHABLE - 130)) | (1L << (ISODOW - 130)) | (1L << (ISOYEAR - 130)) | (1L << (ISSTRICT - 130)) | (1L << (LANGUAGE - 130)) | (1L << (LARGE - 130)) | (1L << (LAST - 130)) | (1L << (LESS - 130)) | (1L << (LIST - 130)) | (1L << (LOCATION - 130)) | (1L << (MATCH - 130)) | (1L << (MAX - 130)) | (1L << (MAXVALUE - 130)) | (1L << (MICROSECONDS - 130)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (MILLENNIUM - 194)) | (1L << (MILLISECONDS - 194)) | (1L << (MIN - 194)) | (1L << (MINVALUE - 194)) | (1L << (MINUTE - 194)) | (1L << (MONTH - 194)) | (1L << (NATIONAL - 194)) | (1L << (NO - 194)) | (1L << (NONE - 194)) | (1L << (NULLIF - 194)) | (1L << (OBJECT - 194)) | (1L << (ON - 194)) | (1L << (OPTION - 194)) | (1L << (OPTIONS - 194)) | (1L << (OVERWRITE - 194)) | (1L << (PARSER - 194)) | (1L << (PARTIAL - 194)) | (1L << (PARTITION - 194)) | (1L << (PARTITIONS - 194)) | (1L << (PRECISION - 194)) | (1L << (PUBLIC - 194)) | (1L << (PURGE - 194)) | (1L << (QUARTER - 194)) | (1L << (RANGE - 194)) | (1L << (REGEXP - 194)) | (1L << (RENAME - 194)) | (1L << (RESET - 194)) | (1L << (RLIKE - 194)) | (1L << (ROLLUP - 194)) | (1L << (SEARCH - 194)) | (1L << (SECOND - 194)) | (1L << (SECURITY - 194)) | (1L << (SERVER - 194)) | (1L << (SET - 194)) | (1L << (SIMILAR - 194)) | (1L << (SIMPLE - 194)) | (1L << (STABLE - 194)) | (1L << (START - 194)) | (1L << (STORAGE - 194)) | (1L << (STDDEV_POP - 194)) | (1L << (STDDEV_SAMP - 194)) | (1L << (SUBPARTITION - 194)) | (1L << (SUM - 194)) | (1L << (TABLESPACE - 194)) | (1L << (TEMPLATE - 194)) | (1L << (THAN - 194)) | (1L << (TIMEZONE - 194)) | (1L << (TIMEZONE_HOUR - 194)) | (1L << (TIMEZONE_MINUTE - 194)) | (1L << (TRIM - 194)) | (1L << (TO - 194)) | (1L << (TYPE - 194)) | (1L << (UNKNOWN - 194)) | (1L << (UNLOGGED - 194)) | (1L << (VALUES - 194)) | (1L << (VAR_SAMP - 194)) | (1L << (VAR_POP - 194)) | (1L << (VARYING - 194)) | (1L << (VOLATILE - 194)) | (1L << (WEEK - 194)) | (1L << (WINDOW - 194)) | (1L << (WRAPPER - 194)))) != 0) || ((((_la - 258)) & ~0x3f) == 0 && ((1L << (_la - 258)) & ((1L << (YEAR - 258)) | (1L << (ZONE - 258)) | (1L << (BOOLEAN - 258)) | (1L << (BOOL - 258)) | (1L << (BIT - 258)) | (1L << (VARBIT - 258)) | (1L << (INT1 - 258)) | (1L << (INT2 - 258)) | (1L << (INT4 - 258)) | (1L << (INT8 - 258)) | (1L << (TINYINT - 258)) | (1L << (SMALLINT - 258)) | (1L << (INT - 258)) | (1L << (INTEGER - 258)) | (1L << (BIGINT - 258)) | (1L << (FLOAT4 - 258)) | (1L << (FLOAT8 - 258)) | (1L << (REAL - 258)) | (1L << (FLOAT - 258)) | (1L << (DOUBLE - 258)) | (1L << (NUMERIC - 258)) | (1L << (DECIMAL - 258)) | (1L << (CHAR - 258)) | (1L << (VARCHAR - 258)) | (1L << (NCHAR - 258)) | (1L << (NVARCHAR - 258)) | (1L << (DATE - 258)) | (1L << (TIME - 258)) | (1L << (TIMETZ - 258)) | (1L << (TIMESTAMP - 258)) | (1L << (TIMESTAMPTZ - 258)) | (1L << (TEXT - 258)) | (1L << (UUID - 258)) | (1L << (VARBINARY - 258)) | (1L << (BLOB - 258)) | (1L << (BYTEA - 258)) | (1L << (INET4 - 258)) | (1L << (VOID - 258)))) != 0)) ) {
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
		enterRule(_localctx, 132, RULE_unsigned_literal);
		try {
			setState(2438);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2436); unsigned_numeric_literal();
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
				setState(2437); general_literal();
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
		enterRule(_localctx, 134, RULE_general_literal);
		try {
			setState(2443);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2440); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(2441); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(2442); boolean_literal();
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
		enterRule(_localctx, 136, RULE_datetime_literal);
		try {
			setState(2448);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(2445); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2446); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2447); date_literal();
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
		enterRule(_localctx, 138, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2450); match(TIME);
			setState(2451); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 140, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2453); match(TIMESTAMP);
			setState(2454); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 142, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2456); match(DATE);
			setState(2457); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 144, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2459);
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
		enterRule(_localctx, 146, RULE_data_type);
		try {
			setState(2464);
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
				setState(2461); predefined_type();
				}
				break;
			case SETOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(2462); match(SETOF);
				setState(2463); ((Data_typeContext)_localctx).value = identifier();
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
		enterRule(_localctx, 148, RULE_predefined_type);
		try {
			setState(2479);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2466); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2467); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(2468); binary_large_object_string_type();
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
				setState(2469); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(2470); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(2471); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2472); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(2473); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(2474); network_type();
				}
				break;
			case REGCLASS:
				enterOuterAlt(_localctx, 10);
				{
				setState(2475); regclass();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 11);
				{
				setState(2476); match(TRIGGER);
				}
				break;
			case UUID:
				enterOuterAlt(_localctx, 12);
				{
				setState(2477); match(UUID);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 13);
				{
				setState(2478); match(VOID);
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
		enterRule(_localctx, 150, RULE_regclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2481); match(REGCLASS);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 152, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2483); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 154, RULE_character_string_type);
		try {
			setState(2508);
			switch ( getInterpreter().adaptivePredict(_input,343,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2485); match(CHARACTER);
				setState(2487);
				switch ( getInterpreter().adaptivePredict(_input,338,_ctx) ) {
				case 1:
					{
					setState(2486); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2489); match(CHAR);
				setState(2491);
				switch ( getInterpreter().adaptivePredict(_input,339,_ctx) ) {
				case 1:
					{
					setState(2490); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2493); match(CHARACTER);
				setState(2494); match(VARYING);
				setState(2496);
				switch ( getInterpreter().adaptivePredict(_input,340,_ctx) ) {
				case 1:
					{
					setState(2495); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2498); match(CHAR);
				setState(2499); match(VARYING);
				setState(2501);
				switch ( getInterpreter().adaptivePredict(_input,341,_ctx) ) {
				case 1:
					{
					setState(2500); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2503); match(VARCHAR);
				setState(2505);
				switch ( getInterpreter().adaptivePredict(_input,342,_ctx) ) {
				case 1:
					{
					setState(2504); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2507); match(TEXT);
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
		enterRule(_localctx, 156, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2510); match(LEFT_PAREN);
			setState(2511); match(NUMBER);
			setState(2512); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 158, RULE_national_character_string_type);
		try {
			setState(2549);
			switch ( getInterpreter().adaptivePredict(_input,351,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2514); match(NATIONAL);
				setState(2515); match(CHARACTER);
				setState(2517);
				switch ( getInterpreter().adaptivePredict(_input,344,_ctx) ) {
				case 1:
					{
					setState(2516); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2519); match(NATIONAL);
				setState(2520); match(CHAR);
				setState(2522);
				switch ( getInterpreter().adaptivePredict(_input,345,_ctx) ) {
				case 1:
					{
					setState(2521); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2524); match(NCHAR);
				setState(2526);
				switch ( getInterpreter().adaptivePredict(_input,346,_ctx) ) {
				case 1:
					{
					setState(2525); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2528); match(NATIONAL);
				setState(2529); match(CHARACTER);
				setState(2530); match(VARYING);
				setState(2532);
				switch ( getInterpreter().adaptivePredict(_input,347,_ctx) ) {
				case 1:
					{
					setState(2531); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2534); match(NATIONAL);
				setState(2535); match(CHAR);
				setState(2536); match(VARYING);
				setState(2538);
				switch ( getInterpreter().adaptivePredict(_input,348,_ctx) ) {
				case 1:
					{
					setState(2537); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2540); match(NCHAR);
				setState(2541); match(VARYING);
				setState(2543);
				switch ( getInterpreter().adaptivePredict(_input,349,_ctx) ) {
				case 1:
					{
					setState(2542); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2545); match(NVARCHAR);
				setState(2547);
				switch ( getInterpreter().adaptivePredict(_input,350,_ctx) ) {
				case 1:
					{
					setState(2546); type_length();
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
		enterRule(_localctx, 160, RULE_binary_large_object_string_type);
		try {
			setState(2559);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(2551); match(BLOB);
				setState(2553);
				switch ( getInterpreter().adaptivePredict(_input,352,_ctx) ) {
				case 1:
					{
					setState(2552); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(2555); match(BYTEA);
				setState(2557);
				switch ( getInterpreter().adaptivePredict(_input,353,_ctx) ) {
				case 1:
					{
					setState(2556); type_length();
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
		enterRule(_localctx, 162, RULE_numeric_type);
		try {
			setState(2563);
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
				setState(2561); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2562); approximate_numeric_type();
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
		enterRule(_localctx, 164, RULE_exact_numeric_type);
		try {
			setState(2586);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2565); match(NUMERIC);
				setState(2567);
				switch ( getInterpreter().adaptivePredict(_input,356,_ctx) ) {
				case 1:
					{
					setState(2566); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2569); match(DECIMAL);
				setState(2571);
				switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
				case 1:
					{
					setState(2570); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(2573); match(DEC);
				setState(2575);
				switch ( getInterpreter().adaptivePredict(_input,358,_ctx) ) {
				case 1:
					{
					setState(2574); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(2577); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2578); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(2579); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2580); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(2581); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(2582); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(2583); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(2584); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(2585); match(BIGINT);
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
		enterRule(_localctx, 166, RULE_approximate_numeric_type);
		try {
			setState(2598);
			switch ( getInterpreter().adaptivePredict(_input,361,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2588); match(FLOAT);
				setState(2590);
				switch ( getInterpreter().adaptivePredict(_input,360,_ctx) ) {
				case 1:
					{
					setState(2589); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2592); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2593); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2594); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2595); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2596); match(DOUBLE);
				setState(2597); match(PRECISION);
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
		enterRule(_localctx, 168, RULE_precision_param);
		try {
			setState(2608);
			switch ( getInterpreter().adaptivePredict(_input,362,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2600); match(LEFT_PAREN);
				setState(2601); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2602); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2603); match(LEFT_PAREN);
				setState(2604); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2605); match(COMMA);
				setState(2606); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(2607); match(RIGHT_PAREN);
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
		enterRule(_localctx, 170, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2610);
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
		enterRule(_localctx, 172, RULE_datetime_type);
		try {
			setState(2629);
			switch ( getInterpreter().adaptivePredict(_input,363,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2612); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2613); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2614); match(TIME);
				setState(2615); match(WITH);
				setState(2616); match(TIME);
				setState(2617); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2618); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2619); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2620); match(TIMESTAMP);
				setState(2621); match(WITH);
				setState(2622); match(TIME);
				setState(2623); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2624); match(TIMESTAMP);
				setState(2625); match(WITHOUT);
				setState(2626); match(TIME);
				setState(2627); match(ZONE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2628); match(TIMESTAMPTZ);
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
		enterRule(_localctx, 174, RULE_bit_type);
		try {
			setState(2644);
			switch ( getInterpreter().adaptivePredict(_input,367,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2631); match(BIT);
				setState(2633);
				switch ( getInterpreter().adaptivePredict(_input,364,_ctx) ) {
				case 1:
					{
					setState(2632); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2635); match(VARBIT);
				setState(2637);
				switch ( getInterpreter().adaptivePredict(_input,365,_ctx) ) {
				case 1:
					{
					setState(2636); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2639); match(BIT);
				setState(2640); match(VARYING);
				setState(2642);
				switch ( getInterpreter().adaptivePredict(_input,366,_ctx) ) {
				case 1:
					{
					setState(2641); type_length();
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
		enterRule(_localctx, 176, RULE_binary_type);
		try {
			setState(2659);
			switch ( getInterpreter().adaptivePredict(_input,371,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2646); match(BINARY);
				setState(2648);
				switch ( getInterpreter().adaptivePredict(_input,368,_ctx) ) {
				case 1:
					{
					setState(2647); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2650); match(BINARY);
				setState(2651); match(VARYING);
				setState(2653);
				switch ( getInterpreter().adaptivePredict(_input,369,_ctx) ) {
				case 1:
					{
					setState(2652); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2655); match(VARBINARY);
				setState(2657);
				switch ( getInterpreter().adaptivePredict(_input,370,_ctx) ) {
				case 1:
					{
					setState(2656); type_length();
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
		enterRule(_localctx, 178, RULE_value_expression_primary);
		try {
			setState(2663);
			switch ( getInterpreter().adaptivePredict(_input,372,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2661); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2662); nonparenthesized_value_expression_primary();
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
		enterRule(_localctx, 180, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2665); match(LEFT_PAREN);
			setState(2666); value_expression();
			setState(2667); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 182, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(2676);
			switch ( getInterpreter().adaptivePredict(_input,373,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2669); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2670); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2671); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2672); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2673); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2674); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2675); routine_invocation();
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
		enterRule(_localctx, 184, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2678); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 186, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2680);
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
		enterRule(_localctx, 188, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2683);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2682); sign();
				}
			}

			setState(2685); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 190, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2687); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 192, RULE_aggregate_function);
		try {
			setState(2697);
			switch ( getInterpreter().adaptivePredict(_input,376,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2689); match(COUNT);
				setState(2690); match(LEFT_PAREN);
				setState(2691); match(MULTIPLY);
				setState(2692); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2693); general_set_function();
				setState(2695);
				switch ( getInterpreter().adaptivePredict(_input,375,_ctx) ) {
				case 1:
					{
					setState(2694); filter_clause();
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
		enterRule(_localctx, 194, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2699); set_function_type();
			setState(2700); match(LEFT_PAREN);
			setState(2702);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(2701); set_qualifier();
				}
			}

			setState(2704); value_expression();
			setState(2705); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 196, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2707);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (SOME - 107)) | (1L << (AVG - 107)) | (1L << (COLLECT - 107)) | (1L << (COUNT - 107)) | (1L << (EVERY - 107)) | (1L << (FUSION - 107)))) != 0) || ((((_la - 179)) & ~0x3f) == 0 && ((1L << (_la - 179)) & ((1L << (INTERSECTION - 179)) | (1L << (MAX - 179)) | (1L << (MIN - 179)) | (1L << (STDDEV_POP - 179)) | (1L << (STDDEV_SAMP - 179)) | (1L << (SUM - 179)))) != 0) || _la==VAR_SAMP || _la==VAR_POP) ) {
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
		enterRule(_localctx, 198, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2709); match(FILTER);
			setState(2710); match(LEFT_PAREN);
			setState(2711); match(WHERE);
			setState(2712); search_condition();
			setState(2713); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 200, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2715); match(GROUPING);
			setState(2716); match(LEFT_PAREN);
			setState(2717); column_reference_list();
			setState(2718); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 202, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2720); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 204, RULE_case_abbreviation);
		int _la;
		try {
			setState(2740);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(2722); match(NULLIF);
				setState(2723); match(LEFT_PAREN);
				setState(2724); numeric_value_expression();
				setState(2725); match(COMMA);
				setState(2726); boolean_value_expression();
				setState(2727); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2729); match(COALESCE);
				setState(2730); match(LEFT_PAREN);
				setState(2731); numeric_value_expression();
				setState(2734); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2732); match(COMMA);
					setState(2733); boolean_value_expression();
					}
					}
					setState(2736); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(2738); match(RIGHT_PAREN);
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
		enterRule(_localctx, 206, RULE_case_specification);
		try {
			setState(2744);
			switch ( getInterpreter().adaptivePredict(_input,380,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2742); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2743); searched_case();
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
		enterRule(_localctx, 208, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2746); match(CASE);
			setState(2747); boolean_value_expression();
			setState(2749); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2748); simple_when_clause();
				}
				}
				setState(2751); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2754);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2753); else_clause();
				}
			}

			setState(2756); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 210, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2758); match(CASE);
			setState(2760); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2759); searched_when_clause();
				}
				}
				setState(2762); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2765);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2764); else_clause();
				}
			}

			setState(2767); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 212, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2769); match(WHEN);
			setState(2770); search_condition();
			setState(2771); match(THEN);
			setState(2772); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 214, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2774); match(WHEN);
			setState(2775); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(2776); match(THEN);
			setState(2777); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 216, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2779); match(ELSE);
			setState(2780); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 218, RULE_result);
		try {
			setState(2784);
			switch ( getInterpreter().adaptivePredict(_input,385,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2782); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2783); match(NULL);
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
		enterRule(_localctx, 220, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2786); match(CAST);
			setState(2787); match(LEFT_PAREN);
			setState(2788); cast_operand();
			setState(2789); match(AS);
			setState(2790); cast_target();
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
		enterRule(_localctx, 222, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2793); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 224, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2795); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 226, RULE_value_expression);
		try {
			setState(2800);
			switch ( getInterpreter().adaptivePredict(_input,386,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2797); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2798); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2799); boolean_value_expression();
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
		enterRule(_localctx, 228, RULE_common_value_expression);
		try {
			setState(2805);
			switch ( getInterpreter().adaptivePredict(_input,387,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2802); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2803); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2804); match(NULL);
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
		enterRule(_localctx, 230, RULE_numeric_value_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2807); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(2812);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,388,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2808);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(2809); ((Numeric_value_expressionContext)_localctx).right = term();
					}
					} 
				}
				setState(2814);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,388,_ctx);
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
		enterRule(_localctx, 232, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2815); ((TermContext)_localctx).left = factor();
			setState(2820);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 318)) & ~0x3f) == 0 && ((1L << (_la - 318)) & ((1L << (MULTIPLY - 318)) | (1L << (DIVIDE - 318)) | (1L << (MODULAR - 318)))) != 0)) {
				{
				{
				setState(2816);
				_la = _input.LA(1);
				if ( !(((((_la - 318)) & ~0x3f) == 0 && ((1L << (_la - 318)) & ((1L << (MULTIPLY - 318)) | (1L << (DIVIDE - 318)) | (1L << (MODULAR - 318)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2817); ((TermContext)_localctx).right = factor();
				}
				}
				setState(2822);
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
		enterRule(_localctx, 234, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2824);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2823); sign();
				}
			}

			setState(2826); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 236, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2828); match(LEFT_PAREN);
			setState(2829); numeric_value_expression();
			setState(2834);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2830); match(COMMA);
				setState(2831); numeric_value_expression();
				}
				}
				setState(2836);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2837); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 238, RULE_numeric_primary);
		int _la;
		try {
			setState(2848);
			switch ( getInterpreter().adaptivePredict(_input,393,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2839); value_expression_primary();
				setState(2844);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(2840); match(CAST_EXPRESSION);
					setState(2841); cast_target();
					}
					}
					setState(2846);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2847); numeric_value_function();
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
		enterRule(_localctx, 240, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2850);
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
		enterRule(_localctx, 242, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2852); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 244, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2854); match(EXTRACT);
			setState(2855); match(LEFT_PAREN);
			setState(2856); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(2857); match(FROM);
			setState(2858); extract_source();
			setState(2859); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 246, RULE_extract_field);
		try {
			setState(2864);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2861); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2862); time_zone_field();
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
				setState(2863); extended_datetime_field();
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
		enterRule(_localctx, 248, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2866);
			_la = _input.LA(1);
			if ( !(((((_la - 241)) & ~0x3f) == 0 && ((1L << (_la - 241)) & ((1L << (TIMEZONE - 241)) | (1L << (TIMEZONE_HOUR - 241)) | (1L << (TIMEZONE_MINUTE - 241)))) != 0)) ) {
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
		enterRule(_localctx, 250, RULE_extract_source);
		try {
			setState(2870);
			switch ( getInterpreter().adaptivePredict(_input,395,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2868); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2869); datetime_literal();
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
		enterRule(_localctx, 252, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2872); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 254, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2874); character_factor();
			setState(2879);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(2875); match(CONCATENATION_OPERATOR);
				setState(2876); character_factor();
				}
				}
				setState(2881);
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
		enterRule(_localctx, 256, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2882); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 258, RULE_character_primary);
		try {
			setState(2886);
			switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2884); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2885); string_value_function();
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
		enterRule(_localctx, 260, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2888); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 262, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2890); match(TRIM);
			setState(2891); match(LEFT_PAREN);
			setState(2892); trim_operands();
			setState(2893); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 264, RULE_trim_operands);
		int _la;
		try {
			setState(2909);
			switch ( getInterpreter().adaptivePredict(_input,401,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2902);
				switch ( getInterpreter().adaptivePredict(_input,400,_ctx) ) {
				case 1:
					{
					setState(2896);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(2895); trim_specification();
						}
					}

					setState(2899);
					_la = _input.LA(1);
					if (((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & ((1L << (ANY - 7)) | (1L << (CASE - 7)) | (1L << (CAST - 7)) | (1L << (FALSE - 7)) | (1L << (LEFT - 7)))) != 0) || ((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (RIGHT - 99)) | (1L << (SOME - 99)) | (1L << (TRUE - 99)) | (1L << (ADMIN - 99)) | (1L << (AVG - 99)) | (1L << (BETWEEN - 99)) | (1L << (BY - 99)) | (1L << (CACHE - 99)) | (1L << (CALLED - 99)) | (1L << (CLASS - 99)) | (1L << (CENTURY - 99)) | (1L << (CHARACTER - 99)) | (1L << (CHECK - 99)) | (1L << (COLLECT - 99)) | (1L << (COALESCE - 99)) | (1L << (COLUMN - 99)) | (1L << (COMMENT - 99)) | (1L << (COMMENTS - 99)) | (1L << (COMMIT - 99)) | (1L << (CONFIGURATION - 99)) | (1L << (COST - 99)) | (1L << (COUNT - 99)) | (1L << (CUBE - 99)) | (1L << (CURRENT - 99)) | (1L << (CYCLE - 99)) | (1L << (DATA - 99)) | (1L << (DAY - 99)) | (1L << (DEC - 99)) | (1L << (DECADE - 99)) | (1L << (DEFINER - 99)) | (1L << (DICTIONARY - 99)) | (1L << (DOW - 99)) | (1L << (DOY - 99)) | (1L << (DROP - 99)) | (1L << (EPOCH - 99)) | (1L << (EVERY - 99)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (EXISTS - 163)) | (1L << (EXTERNAL - 163)) | (1L << (EXTRACT - 163)) | (1L << (FAMILY - 163)) | (1L << (FILTER - 163)) | (1L << (FIRST - 163)) | (1L << (FORMAT - 163)) | (1L << (FUSION - 163)) | (1L << (GROUPING - 163)) | (1L << (HASH - 163)) | (1L << (INDEX - 163)) | (1L << (INCREMENT - 163)) | (1L << (INPUT - 163)) | (1L << (INSERT - 163)) | (1L << (INTERSECTION - 163)) | (1L << (ISCACHABLE - 163)) | (1L << (ISODOW - 163)) | (1L << (ISOYEAR - 163)) | (1L << (ISSTRICT - 163)) | (1L << (LANGUAGE - 163)) | (1L << (LARGE - 163)) | (1L << (LAST - 163)) | (1L << (LESS - 163)) | (1L << (LIST - 163)) | (1L << (LOCATION - 163)) | (1L << (MATCH - 163)) | (1L << (MAX - 163)) | (1L << (MAXVALUE - 163)) | (1L << (MICROSECONDS - 163)) | (1L << (MILLENNIUM - 163)) | (1L << (MILLISECONDS - 163)) | (1L << (MIN - 163)) | (1L << (MINVALUE - 163)) | (1L << (MINUTE - 163)) | (1L << (MONTH - 163)) | (1L << (NATIONAL - 163)) | (1L << (NO - 163)) | (1L << (NONE - 163)) | (1L << (NULLIF - 163)) | (1L << (OBJECT - 163)) | (1L << (ON - 163)) | (1L << (OPTION - 163)) | (1L << (OPTIONS - 163)) | (1L << (OVERWRITE - 163)) | (1L << (PARSER - 163)) | (1L << (PARTIAL - 163)) | (1L << (PARTITION - 163)) | (1L << (PARTITIONS - 163)) | (1L << (PRECISION - 163)) | (1L << (PUBLIC - 163)) | (1L << (PURGE - 163)) | (1L << (QUARTER - 163)) | (1L << (RANGE - 163)) | (1L << (REGEXP - 163)) | (1L << (RENAME - 163)) | (1L << (RESET - 163)) | (1L << (RLIKE - 163)) | (1L << (ROLLUP - 163)) | (1L << (SEARCH - 163)) | (1L << (SECOND - 163)) | (1L << (SECURITY - 163)) | (1L << (SERVER - 163)))) != 0) || ((((_la - 227)) & ~0x3f) == 0 && ((1L << (_la - 227)) & ((1L << (SET - 227)) | (1L << (SIMILAR - 227)) | (1L << (SIMPLE - 227)) | (1L << (STABLE - 227)) | (1L << (START - 227)) | (1L << (STORAGE - 227)) | (1L << (STDDEV_POP - 227)) | (1L << (STDDEV_SAMP - 227)) | (1L << (SUBPARTITION - 227)) | (1L << (SUM - 227)) | (1L << (TABLESPACE - 227)) | (1L << (TEMPLATE - 227)) | (1L << (THAN - 227)) | (1L << (TIMEZONE - 227)) | (1L << (TIMEZONE_HOUR - 227)) | (1L << (TIMEZONE_MINUTE - 227)) | (1L << (TRIM - 227)) | (1L << (TO - 227)) | (1L << (TYPE - 227)) | (1L << (UNKNOWN - 227)) | (1L << (UNLOGGED - 227)) | (1L << (VALUES - 227)) | (1L << (VAR_SAMP - 227)) | (1L << (VAR_POP - 227)) | (1L << (VARYING - 227)) | (1L << (VOLATILE - 227)) | (1L << (WEEK - 227)) | (1L << (WINDOW - 227)) | (1L << (WRAPPER - 227)) | (1L << (YEAR - 227)) | (1L << (ZONE - 227)) | (1L << (BOOLEAN - 227)) | (1L << (BOOL - 227)) | (1L << (BIT - 227)) | (1L << (VARBIT - 227)) | (1L << (INT1 - 227)) | (1L << (INT2 - 227)) | (1L << (INT4 - 227)) | (1L << (INT8 - 227)) | (1L << (TINYINT - 227)) | (1L << (SMALLINT - 227)) | (1L << (INT - 227)) | (1L << (INTEGER - 227)) | (1L << (BIGINT - 227)) | (1L << (FLOAT4 - 227)) | (1L << (FLOAT8 - 227)) | (1L << (REAL - 227)) | (1L << (FLOAT - 227)) | (1L << (DOUBLE - 227)) | (1L << (NUMERIC - 227)) | (1L << (DECIMAL - 227)) | (1L << (CHAR - 227)) | (1L << (VARCHAR - 227)) | (1L << (NCHAR - 227)) | (1L << (NVARCHAR - 227)) | (1L << (DATE - 227)) | (1L << (TIME - 227)) | (1L << (TIMETZ - 227)) | (1L << (TIMESTAMP - 227)) | (1L << (TIMESTAMPTZ - 227)) | (1L << (TEXT - 227)))) != 0) || ((((_la - 291)) & ~0x3f) == 0 && ((1L << (_la - 291)) & ((1L << (UUID - 291)) | (1L << (VARBINARY - 291)) | (1L << (BLOB - 291)) | (1L << (BYTEA - 291)) | (1L << (INET4 - 291)) | (1L << (VOID - 291)) | (1L << (LEFT_PAREN - 291)) | (1L << (DOUBLE_QUOTE - 291)) | (1L << (NUMBER - 291)) | (1L << (REAL_NUMBER - 291)) | (1L << (Identifier - 291)) | (1L << (Character_String_Literal - 291)))) != 0)) {
						{
						setState(2898); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(2901); match(FROM);
					}
					break;
				}
				setState(2904); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2905); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(2906); match(COMMA);
				setState(2907); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
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
		enterRule(_localctx, 266, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2911);
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
		enterRule(_localctx, 268, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2913); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 270, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2915); and_predicate();
			setState(2920);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,402,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2916); match(OR);
					setState(2917); or_predicate();
					}
					} 
				}
				setState(2922);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,402,_ctx);
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
		enterRule(_localctx, 272, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2923); boolean_factor();
			setState(2928);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,403,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2924); match(AND);
					setState(2925); and_predicate();
					}
					} 
				}
				setState(2930);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,403,_ctx);
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
		enterRule(_localctx, 274, RULE_boolean_factor);
		try {
			setState(2934);
			switch ( getInterpreter().adaptivePredict(_input,404,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2931); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2932); match(NOT);
				setState(2933); boolean_test();
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
		enterRule(_localctx, 276, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2936); boolean_primary();
			setState(2938);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(2937); is_clause();
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
		enterRule(_localctx, 278, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2940); match(IS);
			setState(2942);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2941); match(NOT);
				}
			}

			setState(2944); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 280, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2946);
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
		enterRule(_localctx, 282, RULE_boolean_primary);
		try {
			setState(2950);
			switch ( getInterpreter().adaptivePredict(_input,407,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2948); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2949); boolean_predicand();
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
		enterRule(_localctx, 284, RULE_boolean_predicand);
		try {
			setState(2954);
			switch ( getInterpreter().adaptivePredict(_input,408,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2952); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2953); nonparenthesized_value_expression_primary();
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
		enterRule(_localctx, 286, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2956); match(LEFT_PAREN);
			setState(2957); boolean_value_expression();
			setState(2958); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 288, RULE_row_value_expression);
		try {
			setState(2962);
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
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2960); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2961); explicit_row_value_constructor();
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
		enterRule(_localctx, 290, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2964); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 292, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2966); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 294, RULE_row_value_predicand);
		try {
			setState(2970);
			switch ( getInterpreter().adaptivePredict(_input,410,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2968); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2969); row_value_constructor_predicand();
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
		enterRule(_localctx, 296, RULE_row_value_constructor_predicand);
		try {
			setState(2974);
			switch ( getInterpreter().adaptivePredict(_input,411,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2972); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2973); boolean_predicand();
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
		enterRule(_localctx, 298, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2976); from_clause();
			setState(2978);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(2977); where_clause();
				}
			}

			setState(2981);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(2980); groupby_clause();
				}
			}

			setState(2984);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(2983); having_clause();
				}
			}

			setState(2987);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(2986); orderby_clause();
				}
			}

			setState(2990);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(2989); limit_clause();
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
		enterRule(_localctx, 300, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2992); match(FROM);
			setState(2993); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 302, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2995); table_reference();
			setState(3000);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2996); match(COMMA);
				setState(2997); table_reference();
				}
				}
				setState(3002);
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
		enterRule(_localctx, 304, RULE_table_reference);
		try {
			setState(3005);
			switch ( getInterpreter().adaptivePredict(_input,418,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3003); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3004); table_primary();
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
		enterRule(_localctx, 306, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3007); table_primary();
			setState(3009); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(3008); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(3011); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,419,_ctx);
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
		enterRule(_localctx, 308, RULE_joined_table_primary);
		int _la;
		try {
			setState(3032);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(3013); match(CROSS);
				setState(3014); match(JOIN);
				setState(3015); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3017);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (FULL - 44)) | (1L << (INNER - 44)) | (1L << (LEFT - 44)) | (1L << (RIGHT - 44)))) != 0)) {
					{
					setState(3016); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3019); match(JOIN);
				setState(3020); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(3021); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(3023); match(NATURAL);
				setState(3025);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (FULL - 44)) | (1L << (INNER - 44)) | (1L << (LEFT - 44)) | (1L << (RIGHT - 44)))) != 0)) {
					{
					setState(3024); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(3027); match(JOIN);
				setState(3028); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(3029); match(UNION);
				setState(3030); match(JOIN);
				setState(3031); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 310, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3034); match(CROSS);
			setState(3035); match(JOIN);
			setState(3036); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 312, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3039);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (FULL - 44)) | (1L << (INNER - 44)) | (1L << (LEFT - 44)) | (1L << (RIGHT - 44)))) != 0)) {
				{
				setState(3038); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(3041); match(JOIN);
			setState(3042); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(3043); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 314, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3045); match(NATURAL);
			setState(3047);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (FULL - 44)) | (1L << (INNER - 44)) | (1L << (LEFT - 44)) | (1L << (RIGHT - 44)))) != 0)) {
				{
				setState(3046); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(3049); match(JOIN);
			setState(3050); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 316, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3052); match(UNION);
			setState(3053); match(JOIN);
			setState(3054); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 318, RULE_join_type);
		try {
			setState(3058);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3056); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3057); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 320, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3060); outer_join_type_part2();
			setState(3062);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(3061); match(OUTER);
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
		enterRule(_localctx, 322, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3064);
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
		enterRule(_localctx, 324, RULE_join_specification);
		try {
			setState(3068);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(3066); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(3067); named_columns_join();
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
		enterRule(_localctx, 326, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3070); match(ON);
			setState(3071); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 328, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3073); match(USING);
			setState(3074); match(LEFT_PAREN);
			setState(3075); ((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(3076); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 330, RULE_table_primary);
		int _la;
		try {
			setState(3102);
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
				enterOuterAlt(_localctx, 1);
				{
				setState(3078); table_or_query_name();
				setState(3083);
				switch ( getInterpreter().adaptivePredict(_input,429,_ctx) ) {
				case 1:
					{
					setState(3080);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(3079); match(AS);
						}
					}

					setState(3082); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(3089);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3085); match(LEFT_PAREN);
					setState(3086); column_name_list();
					setState(3087); match(RIGHT_PAREN);
					}
				}

				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3091); derived_table();
				setState(3093);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3092); match(AS);
					}
				}

				setState(3095); ((Table_primaryContext)_localctx).name = identifier();
				setState(3100);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3096); match(LEFT_PAREN);
					setState(3097); column_name_list();
					setState(3098); match(RIGHT_PAREN);
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
		enterRule(_localctx, 332, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3104); identifier();
			setState(3109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3105); match(COMMA);
				setState(3106); identifier();
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
		enterRule(_localctx, 334, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3112); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 336, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3114); match(WHERE);
			setState(3115); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 338, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3117); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 340, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3119); match(GROUP);
			setState(3120); match(BY);
			setState(3121); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 342, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3123); grouping_element();
			setState(3128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3124); match(COMMA);
				setState(3125); grouping_element();
				}
				}
				setState(3130);
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
		enterRule(_localctx, 344, RULE_grouping_element);
		try {
			setState(3135);
			switch ( getInterpreter().adaptivePredict(_input,436,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3131); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3132); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3133); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3134); ordinary_grouping_set();
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
		enterRule(_localctx, 346, RULE_ordinary_grouping_set);
		try {
			setState(3142);
			switch ( getInterpreter().adaptivePredict(_input,437,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3137); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3138); match(LEFT_PAREN);
				setState(3139); row_value_predicand_list();
				setState(3140); match(RIGHT_PAREN);
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
		enterRule(_localctx, 348, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3144); ordinary_grouping_set();
			setState(3149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3145); match(COMMA);
				setState(3146); ordinary_grouping_set();
				}
				}
				setState(3151);
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
		enterRule(_localctx, 350, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3152); match(ROLLUP);
			setState(3153); match(LEFT_PAREN);
			setState(3154); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3155); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 352, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3157); match(CUBE);
			setState(3158); match(LEFT_PAREN);
			setState(3159); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3160); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 354, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3162); match(LEFT_PAREN);
			setState(3163); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 356, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3165); match(HAVING);
			setState(3166); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 358, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3168); row_value_predicand();
			setState(3173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3169); match(COMMA);
				setState(3170); row_value_predicand();
				}
				}
				setState(3175);
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
		enterRule(_localctx, 360, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3176); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 362, RULE_query_expression_body);
		try {
			setState(3180);
			switch ( getInterpreter().adaptivePredict(_input,440,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3178); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3179); joined_table();
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
		enterRule(_localctx, 364, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3190);
			switch ( getInterpreter().adaptivePredict(_input,442,_ctx) ) {
			case 1:
				{
				setState(3182); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(3183); joined_table();
				setState(3184);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3186);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3185);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3188); query_term();
				}
				break;
			}
			setState(3199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(3192);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3194);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3193);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3196); query_term();
				}
				}
				setState(3201);
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
		enterRule(_localctx, 366, RULE_query_term);
		try {
			setState(3204);
			switch ( getInterpreter().adaptivePredict(_input,445,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3202); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3203); joined_table();
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
		enterRule(_localctx, 368, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3214);
			switch ( getInterpreter().adaptivePredict(_input,447,_ctx) ) {
			case 1:
				{
				setState(3206); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(3207); joined_table();
				setState(3208); match(INTERSECT);
				setState(3210);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3209);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3212); query_primary();
				}
				break;
			}
			setState(3223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(3216); match(INTERSECT);
				setState(3218);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3217);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3220); query_primary();
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
		enterRule(_localctx, 370, RULE_query_primary);
		try {
			setState(3228);
			switch ( getInterpreter().adaptivePredict(_input,450,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3226); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3227); joined_table();
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
		enterRule(_localctx, 372, RULE_non_join_query_primary);
		try {
			setState(3235);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3230); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3231); match(LEFT_PAREN);
				setState(3232); non_join_query_expression();
				setState(3233); match(RIGHT_PAREN);
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
		enterRule(_localctx, 374, RULE_simple_table);
		try {
			setState(3239);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(3237); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3238); explicit_table();
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
		enterRule(_localctx, 376, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3241); match(TABLE);
			setState(3242); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 378, RULE_table_or_query_name);
		try {
			setState(3246);
			switch ( getInterpreter().adaptivePredict(_input,453,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3244); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3245); identifier();
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
		enterRule(_localctx, 380, RULE_schema_qualified_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3248); identifier();
			setState(3255);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(3249); match(DOT);
				setState(3250); identifier();
				setState(3253);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(3251); match(DOT);
					setState(3252); identifier();
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
		enterRule(_localctx, 382, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3257); match(SELECT);
			setState(3259);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(3258); set_qualifier();
				}
			}

			setState(3261); select_list();
			setState(3263);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(3262); table_expression();
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
		enterRule(_localctx, 384, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3265); select_sublist();
			setState(3270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3266); match(COMMA);
				setState(3267); select_sublist();
				}
				}
				setState(3272);
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
		enterRule(_localctx, 386, RULE_select_sublist);
		try {
			setState(3275);
			switch ( getInterpreter().adaptivePredict(_input,459,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3273); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3274); qualified_asterisk();
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
		enterRule(_localctx, 388, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3277); value_expression();
			setState(3279);
			switch ( getInterpreter().adaptivePredict(_input,460,_ctx) ) {
			case 1:
				{
				setState(3278); as_clause();
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
		enterRule(_localctx, 390, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3283);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(3281); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(3282); match(DOT);
				}
			}

			setState(3285); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 392, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3287);
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
		enterRule(_localctx, 394, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3292);
			switch ( getInterpreter().adaptivePredict(_input,462,_ctx) ) {
			case 1:
				{
				setState(3289); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(3290); match(DOT);
				}
				break;
			}
			setState(3294); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 396, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3297);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(3296); match(AS);
				}
			}

			setState(3299); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 398, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3301); column_reference();
			setState(3306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3302); match(COMMA);
				setState(3303); column_reference();
				}
				}
				setState(3308);
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
		enterRule(_localctx, 400, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3309); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 402, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3311); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 404, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3313); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 406, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3315); match(LEFT_PAREN);
			setState(3316); query_expression();
			setState(3317); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 408, RULE_predicate);
		try {
			setState(3325);
			switch ( getInterpreter().adaptivePredict(_input,465,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3319); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3320); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3321); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3322); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3323); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3324); exists_predicate();
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
		enterRule(_localctx, 410, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3327); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(3328); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(3329); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 412, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3331);
			_la = _input.LA(1);
			if ( !(((((_la - 304)) & ~0x3f) == 0 && ((1L << (_la - 304)) & ((1L << (EQUAL - 304)) | (1L << (NOT_EQUAL - 304)) | (1L << (LTH - 304)) | (1L << (LEQ - 304)) | (1L << (GTH - 304)) | (1L << (GEQ - 304)))) != 0)) ) {
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
		enterRule(_localctx, 414, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3333); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3334); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 416, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3337);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3336); match(NOT);
				}
			}

			setState(3339); match(BETWEEN);
			setState(3341);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(3340);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(3343); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(3344); match(AND);
			setState(3345); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 418, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3347); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(3349);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3348); match(NOT);
				}
			}

			setState(3351); match(IN);
			setState(3352); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 420, RULE_in_predicate_value);
		try {
			setState(3359);
			switch ( getInterpreter().adaptivePredict(_input,469,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3354); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3355); match(LEFT_PAREN);
				setState(3356); in_value_list();
				setState(3357); match(RIGHT_PAREN);
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
		enterRule(_localctx, 422, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3361); row_value_expression();
			setState(3366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3362); match(COMMA);
				setState(3363); row_value_expression();
				}
				}
				setState(3368);
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
		enterRule(_localctx, 424, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3369); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(3370); pattern_matcher();
			setState(3371); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 426, RULE_pattern_matcher);
		int _la;
		try {
			setState(3378);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3374);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3373); match(NOT);
					}
				}

				setState(3376); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(3377); regex_matcher();
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
		enterRule(_localctx, 428, RULE_negativable_matcher);
		try {
			setState(3386);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3380); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3381); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(3382); match(SIMILAR);
				setState(3383); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(3384); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(3385); match(RLIKE);
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
		enterRule(_localctx, 430, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3388);
			_la = _input.LA(1);
			if ( !(((((_la - 298)) & ~0x3f) == 0 && ((1L << (_la - 298)) & ((1L << (Similar_To - 298)) | (1L << (Not_Similar_To - 298)) | (1L << (Similar_To_Case_Insensitive - 298)) | (1L << (Not_Similar_To_Case_Insensitive - 298)))) != 0)) ) {
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
		enterRule(_localctx, 432, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3390); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3391); match(IS);
			setState(3393);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3392); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(3395); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 434, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3397); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(3398); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(3399); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(3400); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 436, RULE_quantifier);
		try {
			setState(3404);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3402); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3403); some();
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
		enterRule(_localctx, 438, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3406); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 440, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3408);
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
		enterRule(_localctx, 442, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3411);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3410); match(NOT);
				}
			}

			setState(3413); match(EXISTS);
			setState(3414); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 444, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3416); match(UNIQUE);
			setState(3417); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 446, RULE_primary_datetime_field);
		try {
			setState(3421);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3419); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(3420); match(SECOND);
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
		enterRule(_localctx, 448, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3423);
			_la = _input.LA(1);
			if ( !(((((_la - 153)) & ~0x3f) == 0 && ((1L << (_la - 153)) & ((1L << (DAY - 153)) | (1L << (HOUR - 153)) | (1L << (MINUTE - 153)) | (1L << (MONTH - 153)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 450, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3425);
			_la = _input.LA(1);
			if ( !(((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (CENTURY - 137)) | (1L << (DECADE - 137)) | (1L << (DOW - 137)) | (1L << (DOY - 137)) | (1L << (EPOCH - 137)) | (1L << (ISODOW - 137)) | (1L << (ISOYEAR - 137)) | (1L << (MICROSECONDS - 137)) | (1L << (MILLENNIUM - 137)) | (1L << (MILLISECONDS - 137)))) != 0) || _la==QUARTER || _la==WEEK) ) {
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
		enterRule(_localctx, 452, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3427); function_name();
			setState(3428); match(LEFT_PAREN);
			setState(3430);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LEFT - 70)) | (1L << (NOT - 70)) | (1L << (NULL - 70)) | (1L << (RIGHT - 70)) | (1L << (SOME - 70)) | (1L << (TRUE - 70)) | (1L << (ADMIN - 70)) | (1L << (AVG - 70)) | (1L << (BETWEEN - 70)) | (1L << (BY - 70)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (CACHE - 134)) | (1L << (CALLED - 134)) | (1L << (CLASS - 134)) | (1L << (CENTURY - 134)) | (1L << (CHARACTER - 134)) | (1L << (CHECK - 134)) | (1L << (COLLECT - 134)) | (1L << (COALESCE - 134)) | (1L << (COLUMN - 134)) | (1L << (COMMENT - 134)) | (1L << (COMMENTS - 134)) | (1L << (COMMIT - 134)) | (1L << (CONFIGURATION - 134)) | (1L << (COST - 134)) | (1L << (COUNT - 134)) | (1L << (CUBE - 134)) | (1L << (CURRENT - 134)) | (1L << (CYCLE - 134)) | (1L << (DATA - 134)) | (1L << (DAY - 134)) | (1L << (DEC - 134)) | (1L << (DECADE - 134)) | (1L << (DEFINER - 134)) | (1L << (DICTIONARY - 134)) | (1L << (DOW - 134)) | (1L << (DOY - 134)) | (1L << (DROP - 134)) | (1L << (EPOCH - 134)) | (1L << (EVERY - 134)) | (1L << (EXISTS - 134)) | (1L << (EXTERNAL - 134)) | (1L << (EXTRACT - 134)) | (1L << (FAMILY - 134)) | (1L << (FILTER - 134)) | (1L << (FIRST - 134)) | (1L << (FORMAT - 134)) | (1L << (FUSION - 134)) | (1L << (GROUPING - 134)) | (1L << (HASH - 134)) | (1L << (INDEX - 134)) | (1L << (INCREMENT - 134)) | (1L << (INPUT - 134)) | (1L << (INSERT - 134)) | (1L << (INTERSECTION - 134)) | (1L << (ISCACHABLE - 134)) | (1L << (ISODOW - 134)) | (1L << (ISOYEAR - 134)) | (1L << (ISSTRICT - 134)) | (1L << (LANGUAGE - 134)) | (1L << (LARGE - 134)) | (1L << (LAST - 134)) | (1L << (LESS - 134)) | (1L << (LIST - 134)) | (1L << (LOCATION - 134)) | (1L << (MATCH - 134)) | (1L << (MAX - 134)) | (1L << (MAXVALUE - 134)) | (1L << (MICROSECONDS - 134)) | (1L << (MILLENNIUM - 134)) | (1L << (MILLISECONDS - 134)) | (1L << (MIN - 134)) | (1L << (MINVALUE - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (MINUTE - 198)) | (1L << (MONTH - 198)) | (1L << (NATIONAL - 198)) | (1L << (NO - 198)) | (1L << (NONE - 198)) | (1L << (NULLIF - 198)) | (1L << (OBJECT - 198)) | (1L << (ON - 198)) | (1L << (OPTION - 198)) | (1L << (OPTIONS - 198)) | (1L << (OVERWRITE - 198)) | (1L << (PARSER - 198)) | (1L << (PARTIAL - 198)) | (1L << (PARTITION - 198)) | (1L << (PARTITIONS - 198)) | (1L << (PRECISION - 198)) | (1L << (PUBLIC - 198)) | (1L << (PURGE - 198)) | (1L << (QUARTER - 198)) | (1L << (RANGE - 198)) | (1L << (REGEXP - 198)) | (1L << (RENAME - 198)) | (1L << (RESET - 198)) | (1L << (RLIKE - 198)) | (1L << (ROLLUP - 198)) | (1L << (SEARCH - 198)) | (1L << (SECOND - 198)) | (1L << (SECURITY - 198)) | (1L << (SERVER - 198)) | (1L << (SET - 198)) | (1L << (SIMILAR - 198)) | (1L << (SIMPLE - 198)) | (1L << (STABLE - 198)) | (1L << (START - 198)) | (1L << (STORAGE - 198)) | (1L << (STDDEV_POP - 198)) | (1L << (STDDEV_SAMP - 198)) | (1L << (SUBPARTITION - 198)) | (1L << (SUM - 198)) | (1L << (TABLESPACE - 198)) | (1L << (TEMPLATE - 198)) | (1L << (THAN - 198)) | (1L << (TIMEZONE - 198)) | (1L << (TIMEZONE_HOUR - 198)) | (1L << (TIMEZONE_MINUTE - 198)) | (1L << (TRIM - 198)) | (1L << (TO - 198)) | (1L << (TYPE - 198)) | (1L << (UNKNOWN - 198)) | (1L << (UNLOGGED - 198)) | (1L << (VALUES - 198)) | (1L << (VAR_SAMP - 198)) | (1L << (VAR_POP - 198)) | (1L << (VARYING - 198)) | (1L << (VOLATILE - 198)) | (1L << (WEEK - 198)) | (1L << (WINDOW - 198)) | (1L << (WRAPPER - 198)) | (1L << (YEAR - 198)) | (1L << (ZONE - 198)) | (1L << (BOOLEAN - 198)) | (1L << (BOOL - 198)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (BIT - 262)) | (1L << (VARBIT - 262)) | (1L << (INT1 - 262)) | (1L << (INT2 - 262)) | (1L << (INT4 - 262)) | (1L << (INT8 - 262)) | (1L << (TINYINT - 262)) | (1L << (SMALLINT - 262)) | (1L << (INT - 262)) | (1L << (INTEGER - 262)) | (1L << (BIGINT - 262)) | (1L << (FLOAT4 - 262)) | (1L << (FLOAT8 - 262)) | (1L << (REAL - 262)) | (1L << (FLOAT - 262)) | (1L << (DOUBLE - 262)) | (1L << (NUMERIC - 262)) | (1L << (DECIMAL - 262)) | (1L << (CHAR - 262)) | (1L << (VARCHAR - 262)) | (1L << (NCHAR - 262)) | (1L << (NVARCHAR - 262)) | (1L << (DATE - 262)) | (1L << (TIME - 262)) | (1L << (TIMETZ - 262)) | (1L << (TIMESTAMP - 262)) | (1L << (TIMESTAMPTZ - 262)) | (1L << (TEXT - 262)) | (1L << (UUID - 262)) | (1L << (VARBINARY - 262)) | (1L << (BLOB - 262)) | (1L << (BYTEA - 262)) | (1L << (INET4 - 262)) | (1L << (VOID - 262)) | (1L << (LEFT_PAREN - 262)) | (1L << (PLUS - 262)) | (1L << (MINUS - 262)) | (1L << (DOUBLE_QUOTE - 262)))) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & ((1L << (NUMBER - 329)) | (1L << (REAL_NUMBER - 329)) | (1L << (Identifier - 329)) | (1L << (Character_String_Literal - 329)))) != 0)) {
				{
				setState(3429); sql_argument_list();
				}
			}

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
		enterRule(_localctx, 454, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3434);
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
		enterRule(_localctx, 456, RULE_function_name);
		try {
			setState(3438);
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
				enterOuterAlt(_localctx, 1);
				{
				setState(3436); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3437); function_names_for_reserved_words();
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
		enterRule(_localctx, 458, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3440); value_expression();
			setState(3445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3441); match(COMMA);
				setState(3442); value_expression();
				}
				}
				setState(3447);
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
		enterRule(_localctx, 460, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3448); match(ORDER);
			setState(3449); match(BY);
			setState(3450); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 462, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3452); sort_specifier();
			setState(3457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3453); match(COMMA);
				setState(3454); sort_specifier();
				}
				}
				setState(3459);
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
		enterRule(_localctx, 464, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3460); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(3462);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(3461); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(3465);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(3464); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 466, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3467);
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
		enterRule(_localctx, 468, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3469); match(LIMIT);
			setState(3470); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 470, RULE_null_ordering);
		try {
			setState(3476);
			switch ( getInterpreter().adaptivePredict(_input,484,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3472); match(NULL);
				setState(3473); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3474); match(NULL);
				setState(3475); match(LAST);
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
		enterRule(_localctx, 472, RULE_insert_statement);
		int _la;
		try {
			setState(3507);
			switch ( getInterpreter().adaptivePredict(_input,490,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3478); match(INSERT);
				setState(3480);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3479); match(OVERWRITE);
					}
				}

				setState(3482); match(INTO);
				setState(3483); schema_qualified_name();
				setState(3488);
				switch ( getInterpreter().adaptivePredict(_input,486,_ctx) ) {
				case 1:
					{
					setState(3484); match(LEFT_PAREN);
					setState(3485); column_name_list();
					setState(3486); match(RIGHT_PAREN);
					}
					break;
				}
				setState(3490); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3492); match(INSERT);
				setState(3494);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3493); match(OVERWRITE);
					}
				}

				setState(3496); match(INTO);
				setState(3497); match(LOCATION);
				setState(3498); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(3504);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(3499); match(USING);
					setState(3500); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(3502);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(3501); param_clause();
						}
					}

					}
				}

				setState(3506); query_expression();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0154\u0db8\4\2\t"+
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
		"\4\u00ed\t\u00ed\4\u00ee\t\u00ee\3\2\3\2\5\2\u01df\n\2\7\2\u01e1\n\2\f"+
		"\2\16\2\u01e4\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\5\6\u01f1"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u01ff\n\7\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\6\t\u0208\n\t\r\t\16\t\u0209\3\t\5\t\u020d\n"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0227\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0237\n\n\3\n\3\n\3\n\5\n\u023c\n\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u024b\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0256\n\n\3\13\3\13\5\13\u025a\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u0261\n\13\3\13\3\13\3\13\3\13\5\13\u0267"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\5\f\u026e\n\f\3\f\3\f\5\f\u0272\n\f\3\f\3\f"+
		"\5\f\u0276\n\f\3\f\3\f\5\f\u027a\n\f\3\f\3\f\5\f\u027e\n\f\3\r\3\r\5\r"+
		"\u0282\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u028c\n\r\3\r\5\r\u028f"+
		"\n\r\6\r\u0291\n\r\r\r\16\r\u0292\3\r\3\r\5\r\u0297\n\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u029e\n\r\3\r\5\r\u02a1\n\r\6\r\u02a3\n\r\r\r\16\r\u02a4\5"+
		"\r\u02a7\n\r\3\16\3\16\5\16\u02ab\n\16\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u02b3\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u02bc\n\16\6\16"+
		"\u02be\n\16\r\16\16\16\u02bf\5\16\u02c2\n\16\5\16\u02c4\n\16\3\16\3\16"+
		"\3\16\3\16\5\16\u02ca\n\16\3\16\3\16\3\16\5\16\u02cf\n\16\3\16\3\16\3"+
		"\16\3\16\5\16\u02d5\n\16\3\16\3\16\5\16\u02d9\n\16\3\16\3\16\5\16\u02dd"+
		"\n\16\3\16\3\16\5\16\u02e1\n\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u02e9"+
		"\n\16\5\16\u02eb\n\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u02f3\n\17\3"+
		"\17\6\17\u02f6\n\17\r\17\16\17\u02f7\3\17\3\17\5\17\u02fc\n\17\5\17\u02fe"+
		"\n\17\3\17\3\17\5\17\u0302\n\17\3\17\6\17\u0305\n\17\r\17\16\17\u0306"+
		"\3\17\3\17\3\17\3\17\3\17\6\17\u030e\n\17\r\17\16\17\u030f\5\17\u0312"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u031a\n\17\3\17\3\17\3\17\3\17"+
		"\5\17\u0320\n\17\6\17\u0322\n\17\r\17\16\17\u0323\3\17\3\17\6\17\u0328"+
		"\n\17\r\17\16\17\u0329\3\17\3\17\5\17\u032e\n\17\3\17\3\17\3\17\5\17\u0333"+
		"\n\17\6\17\u0335\n\17\r\17\16\17\u0336\3\17\3\17\5\17\u033b\n\17\3\17"+
		"\3\17\5\17\u033f\n\17\3\17\3\17\5\17\u0343\n\17\6\17\u0345\n\17\r\17\16"+
		"\17\u0346\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u034f\n\17\3\17\6\17\u0352"+
		"\n\17\r\17\16\17\u0353\3\17\3\17\5\17\u0358\n\17\5\17\u035a\n\17\3\17"+
		"\3\17\3\17\3\17\5\17\u0360\n\17\6\17\u0362\n\17\r\17\16\17\u0363\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u036c\n\17\6\17\u036e\n\17\r\17\16\17\u036f"+
		"\5\17\u0372\n\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u037a\n\17\3\17\6"+
		"\17\u037d\n\17\r\17\16\17\u037e\3\17\3\17\5\17\u0383\n\17\5\17\u0385\n"+
		"\17\3\17\3\17\3\17\3\17\5\17\u038b\n\17\6\17\u038d\n\17\r\17\16\17\u038e"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0397\n\17\3\17\3\17\3\17\5\17\u039c"+
		"\n\17\5\17\u039e\n\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u03a6\n\17\6"+
		"\17\u03a8\n\17\r\17\16\17\u03a9\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u03b2"+
		"\n\17\3\17\3\17\3\17\5\17\u03b7\n\17\5\17\u03b9\n\17\3\17\3\17\3\17\3"+
		"\17\3\17\5\17\u03c0\n\17\6\17\u03c2\n\17\r\17\16\17\u03c3\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\5\17\u03cc\n\17\3\17\3\17\3\17\5\17\u03d1\n\17\5\17"+
		"\u03d3\n\17\3\17\3\17\3\17\5\17\u03d8\n\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u03e0\n\17\3\17\3\17\3\17\5\17\u03e5\n\17\5\17\u03e7\n\17\3\17"+
		"\3\17\3\17\3\17\5\17\u03ed\n\17\6\17\u03ef\n\17\r\17\16\17\u03f0\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u03f9\n\17\3\17\3\17\3\17\5\17\u03fe\n"+
		"\17\6\17\u0400\n\17\r\17\16\17\u0401\3\17\3\17\5\17\u0406\n\17\5\17\u0408"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u040f\n\17\6\17\u0411\n\17\r\17\16"+
		"\17\u0412\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u041b\n\17\3\17\3\17\5\17"+
		"\u041f\n\17\6\17\u0421\n\17\r\17\16\17\u0422\3\17\3\17\5\17\u0427\n\17"+
		"\5\17\u0429\n\17\3\17\3\17\3\17\3\17\5\17\u042f\n\17\6\17\u0431\n\17\r"+
		"\17\16\17\u0432\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u043b\n\17\3\17\3\17"+
		"\3\17\5\17\u0440\n\17\5\17\u0442\n\17\3\17\3\17\3\17\3\17\5\17\u0448\n"+
		"\17\6\17\u044a\n\17\r\17\16\17\u044b\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u0454\n\17\3\17\3\17\5\17\u0458\n\17\6\17\u045a\n\17\r\17\16\17\u045b"+
		"\3\17\3\17\3\17\5\17\u0461\n\17\6\17\u0463\n\17\r\17\16\17\u0464\3\17"+
		"\5\17\u0468\n\17\5\17\u046a\n\17\3\20\3\20\5\20\u046e\n\20\3\20\3\20\3"+
		"\20\5\20\u0473\n\20\6\20\u0475\n\20\r\20\16\20\u0476\3\20\5\20\u047a\n"+
		"\20\3\21\3\21\6\21\u047e\n\21\r\21\16\21\u047f\3\21\3\21\5\21\u0484\n"+
		"\21\5\21\u0486\n\21\3\21\3\21\5\21\u048a\n\21\3\21\3\21\5\21\u048e\n\21"+
		"\6\21\u0490\n\21\r\21\16\21\u0491\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u049a"+
		"\n\21\6\21\u049c\n\21\r\21\16\21\u049d\5\21\u04a0\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u04a8\n\21\6\21\u04aa\n\21\r\21\16\21\u04ab\6\21"+
		"\u04ae\n\21\r\21\16\21\u04af\3\21\3\21\5\21\u04b4\n\21\3\21\3\21\5\21"+
		"\u04b8\n\21\6\21\u04ba\n\21\r\21\16\21\u04bb\5\21\u04be\n\21\3\21\3\21"+
		"\5\21\u04c2\n\21\3\21\3\21\5\21\u04c6\n\21\6\21\u04c8\n\21\r\21\16\21"+
		"\u04c9\3\21\3\21\3\21\3\21\3\21\5\21\u04d1\n\21\6\21\u04d3\n\21\r\21\16"+
		"\21\u04d4\3\21\3\21\5\21\u04d9\n\21\5\21\u04db\n\21\3\21\3\21\3\21\3\21"+
		"\5\21\u04e1\n\21\6\21\u04e3\n\21\r\21\16\21\u04e4\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u04ed\n\21\6\21\u04ef\n\21\r\21\16\21\u04f0\5\21\u04f3"+
		"\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u04fa\n\21\6\21\u04fc\n\21\r\21\16"+
		"\21\u04fd\3\21\3\21\5\21\u0502\n\21\5\21\u0504\n\21\3\21\3\21\3\21\3\21"+
		"\5\21\u050a\n\21\6\21\u050c\n\21\r\21\16\21\u050d\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u0516\n\21\5\21\u0518\n\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\5\21\u0520\n\21\6\21\u0522\n\21\r\21\16\21\u0523\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u052c\n\21\5\21\u052e\n\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u0535\n\21\6\21\u0537\n\21\r\21\16\21\u0538\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u0541\n\21\5\21\u0543\n\21\3\21\3\21\3\21\5\21\u0548\n"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0550\n\21\5\21\u0552\n\21\3\21"+
		"\3\21\3\21\3\21\5\21\u0558\n\21\6\21\u055a\n\21\r\21\16\21\u055b\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u0563\n\21\6\21\u0565\n\21\r\21\16\21\u0566"+
		"\3\21\3\21\5\21\u056b\n\21\5\21\u056d\n\21\3\21\3\21\3\21\3\21\3\21\5"+
		"\21\u0574\n\21\6\21\u0576\n\21\r\21\16\21\u0577\3\21\3\21\3\21\3\21\3"+
		"\21\5\21\u057f\n\21\6\21\u0581\n\21\r\21\16\21\u0582\3\21\3\21\5\21\u0587"+
		"\n\21\5\21\u0589\n\21\3\21\3\21\3\21\3\21\5\21\u058f\n\21\6\21\u0591\n"+
		"\21\r\21\16\21\u0592\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u059b\n\21\5\21"+
		"\u059d\n\21\3\21\3\21\3\21\3\21\5\21\u05a3\n\21\6\21\u05a5\n\21\r\21\16"+
		"\21\u05a6\3\21\3\21\3\21\3\21\5\21\u05ad\n\21\6\21\u05af\n\21\r\21\16"+
		"\21\u05b0\3\21\3\21\3\21\5\21\u05b6\n\21\6\21\u05b8\n\21\r\21\16\21\u05b9"+
		"\3\21\3\21\3\21\5\21\u05bf\n\21\5\21\u05c1\n\21\3\22\3\22\5\22\u05c5\n"+
		"\22\3\22\3\22\5\22\u05c9\n\22\3\22\5\22\u05cc\n\22\6\22\u05ce\n\22\r\22"+
		"\16\22\u05cf\3\22\3\22\3\22\5\22\u05d5\n\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\5\23\u05de\n\23\7\23\u05e0\n\23\f\23\16\23\u05e3\13\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\5\23\u0621\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u064f\n\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\5\24\u0657\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0664\n\24\6\24\u0666\n\24\r\24\16\24\u0667\3\24"+
		"\3\24\5\24\u066c\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u067f\n\24\3\24\3\24\3\24\5\24"+
		"\u0684\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u0694\n\24\3\24\3\24\7\24\u0698\n\24\f\24\16\24\u069b"+
		"\13\24\3\24\3\24\3\24\3\24\3\24\3\24\6\24\u06a3\n\24\r\24\16\24\u06a4"+
		"\3\24\3\24\3\24\3\24\5\24\u06ab\n\24\6\24\u06ad\n\24\r\24\16\24\u06ae"+
		"\3\24\3\24\5\24\u06b3\n\24\3\25\3\25\5\25\u06b7\n\25\3\25\5\25\u06ba\n"+
		"\25\3\25\3\25\3\25\3\25\5\25\u06c0\n\25\3\25\5\25\u06c3\n\25\7\25\u06c5"+
		"\n\25\f\25\16\25\u06c8\13\25\3\25\3\25\3\26\3\26\5\26\u06ce\n\26\3\27"+
		"\3\27\7\27\u06d2\n\27\f\27\16\27\u06d5\13\27\3\27\3\27\3\30\3\30\7\30"+
		"\u06db\n\30\f\30\16\30\u06de\13\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\5\33\u06ea\n\33\3\33\5\33\u06ed\n\33\3\33\3\33\5\33\u06f1"+
		"\n\33\3\33\5\33\u06f4\n\33\7\33\u06f6\n\33\f\33\16\33\u06f9\13\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0703\n\34\6\34\u0705\n\34\r"+
		"\34\16\34\u0706\3\35\3\35\5\35\u070b\n\35\3\35\3\35\3\35\3\35\5\35\u0711"+
		"\n\35\3\35\3\35\3\35\3\35\3\35\5\35\u0718\n\35\3\35\3\35\3\35\3\35\5\35"+
		"\u071e\n\35\3\35\3\35\5\35\u0722\n\35\3\35\3\35\3\35\3\35\5\35\u0728\n"+
		"\35\3\35\3\35\3\35\3\35\3\35\5\35\u072f\n\35\7\35\u0731\n\35\f\35\16\35"+
		"\u0734\13\35\3\36\3\36\3\36\3\36\3\36\5\36\u073b\n\36\3\36\7\36\u073e"+
		"\n\36\f\36\16\36\u0741\13\36\3\36\3\36\3\36\3\36\3\36\7\36\u0748\n\36"+
		"\f\36\16\36\u074b\13\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0755"+
		"\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u075e\n\36\3\37\3\37\3\37"+
		"\5\37\u0763\n\37\3\37\5\37\u0766\n\37\3\37\3\37\3\37\3\37\5\37\u076c\n"+
		"\37\7\37\u076e\n\37\f\37\16\37\u0771\13\37\3\37\3\37\3\37\3\37\3\37\5"+
		"\37\u0778\n\37\6\37\u077a\n\37\r\37\16\37\u077b\3\37\3\37\5\37\u0780\n"+
		"\37\3\37\3\37\3\37\3 \3 \3!\3!\5!\u0789\n!\3!\3!\5!\u078d\n!\3!\3!\3!"+
		"\3!\5!\u0793\n!\3!\3!\3!\3!\3!\3!\5!\u079b\n!\3!\7!\u079e\n!\f!\16!\u07a1"+
		"\13!\3!\3!\3!\3!\7!\u07a7\n!\f!\16!\u07aa\13!\5!\u07ac\n!\3!\5!\u07af"+
		"\n!\6!\u07b1\n!\r!\16!\u07b2\5!\u07b5\n!\3!\3!\3!\3!\3!\5!\u07bc\n!\6"+
		"!\u07be\n!\r!\16!\u07bf\3!\3!\5!\u07c4\n!\3!\3!\3!\3!\3!\3!\5!\u07cc\n"+
		"!\3!\3!\5!\u07d0\n!\3!\3!\3!\3!\5!\u07d6\n!\3!\3!\3!\3!\3!\3!\3!\3!\7"+
		"!\u07e0\n!\f!\16!\u07e3\13!\3!\5!\u07e6\n!\3!\5!\u07e9\n!\6!\u07eb\n!"+
		"\r!\16!\u07ec\3!\3!\5!\u07f1\n!\3!\3!\3!\3!\5!\u07f7\n!\3\"\3\"\3\"\3"+
		"#\3#\5#\u07fe\n#\3#\3#\3#\3#\3#\5#\u0805\n#\6#\u0807\n#\r#\16#\u0808\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\5#\u0813\n#\6#\u0815\n#\r#\16#\u0816\3#\3#\3#\3"+
		"#\3#\3#\5#\u081f\n#\3#\3#\3#\3#\3#\5#\u0826\n#\6#\u0828\n#\r#\16#\u0829"+
		"\3#\3#\3#\3#\3#\3#\3#\5#\u0833\n#\3#\3#\3#\3#\3#\5#\u083a\n#\6#\u083c"+
		"\n#\r#\16#\u083d\3#\3#\3#\3#\3#\3#\5#\u0846\n#\6#\u0848\n#\r#\16#\u0849"+
		"\3#\3#\5#\u084e\n#\3#\3#\3#\3#\3#\3#\5#\u0856\n#\3#\3#\3#\5#\u085b\n#"+
		"\3#\3#\3#\5#\u0860\n#\5#\u0862\n#\3#\3#\3#\5#\u0867\n#\3#\3#\3#\3#\5#"+
		"\u086d\n#\3$\3$\5$\u0871\n$\3$\3$\3$\3$\3$\3$\3$\5$\u087a\n$\3$\3$\3$"+
		"\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u088a\n$\3$\3$\3$\5$\u088f\n$\3$"+
		"\3$\3$\5$\u0894\n$\5$\u0896\n$\3$\3$\3$\5$\u089b\n$\3$\3$\3$\3$\5$\u08a1"+
		"\n$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\5&\u08ad\n&\3&\5&\u08b0\n&\6&\u08b2"+
		"\n&\r&\16&\u08b3\3&\3&\3\'\3\'\3\'\3\'\3\'\5\'\u08bd\n\'\3(\3(\3(\3(\3"+
		"(\3(\3(\5(\u08c6\n(\5(\u08c8\n(\3)\3)\5)\u08cc\n)\3*\3*\3*\3*\3*\3*\5"+
		"*\u08d4\n*\3+\5+\u08d7\n+\3+\3+\3+\3+\5+\u08dd\n+\3,\3,\3,\3,\7,\u08e3"+
		"\n,\f,\16,\u08e6\13,\3,\3,\3-\3-\3-\3.\3.\3/\3/\3/\3/\3/\7/\u08f4\n/\f"+
		"/\16/\u08f7\13/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\5\64\u090b\n\64\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\7\66\u091a\n\66\f\66\16\66\u091d"+
		"\13\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u0929\n"+
		"\67\3\67\3\67\5\67\u092d\n\67\5\67\u092f\n\67\38\38\38\38\38\38\38\38"+
		"\38\38\38\58\u093c\n8\39\39\39\79\u0941\n9\f9\169\u0944\139\3:\3:\3:\3"+
		";\3;\3;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\7=\u0959\n=\f=\16=\u095c"+
		"\13=\3>\3>\3>\3>\5>\u0962\n>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3@\3@\3A\3A\3"+
		"A\3A\5A\u0973\nA\3B\5B\u0976\nB\3B\3B\5B\u097a\nB\3B\5B\u097d\nB\3B\3"+
		"B\5B\u0981\nB\5B\u0983\nB\3C\3C\3D\3D\5D\u0989\nD\3E\3E\3E\5E\u098e\n"+
		"E\3F\3F\3F\5F\u0993\nF\3G\3G\3G\3H\3H\3H\3I\3I\3I\3J\3J\3K\3K\3K\5K\u09a3"+
		"\nK\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\5L\u09b2\nL\3M\3M\3N\3N\3O"+
		"\3O\5O\u09ba\nO\3O\3O\5O\u09be\nO\3O\3O\3O\5O\u09c3\nO\3O\3O\3O\5O\u09c8"+
		"\nO\3O\3O\5O\u09cc\nO\3O\5O\u09cf\nO\3P\3P\3P\3P\3Q\3Q\3Q\5Q\u09d8\nQ"+
		"\3Q\3Q\3Q\5Q\u09dd\nQ\3Q\3Q\5Q\u09e1\nQ\3Q\3Q\3Q\3Q\5Q\u09e7\nQ\3Q\3Q"+
		"\3Q\3Q\5Q\u09ed\nQ\3Q\3Q\3Q\5Q\u09f2\nQ\3Q\3Q\5Q\u09f6\nQ\5Q\u09f8\nQ"+
		"\3R\3R\5R\u09fc\nR\3R\3R\5R\u0a00\nR\5R\u0a02\nR\3S\3S\5S\u0a06\nS\3T"+
		"\3T\5T\u0a0a\nT\3T\3T\5T\u0a0e\nT\3T\3T\5T\u0a12\nT\3T\3T\3T\3T\3T\3T"+
		"\3T\3T\3T\5T\u0a1d\nT\3U\3U\5U\u0a21\nU\3U\3U\3U\3U\3U\3U\5U\u0a29\nU"+
		"\3V\3V\3V\3V\3V\3V\3V\3V\5V\u0a33\nV\3W\3W\3X\3X\3X\3X\3X\3X\3X\3X\3X"+
		"\3X\3X\3X\3X\3X\3X\3X\3X\5X\u0a48\nX\3Y\3Y\5Y\u0a4c\nY\3Y\3Y\5Y\u0a50"+
		"\nY\3Y\3Y\3Y\5Y\u0a55\nY\5Y\u0a57\nY\3Z\3Z\5Z\u0a5b\nZ\3Z\3Z\3Z\5Z\u0a60"+
		"\nZ\3Z\3Z\5Z\u0a64\nZ\5Z\u0a66\nZ\3[\3[\5[\u0a6a\n[\3\\\3\\\3\\\3\\\3"+
		"]\3]\3]\3]\3]\3]\3]\5]\u0a77\n]\3^\3^\3_\3_\3`\5`\u0a7e\n`\3`\3`\3a\3"+
		"a\3b\3b\3b\3b\3b\3b\5b\u0a8a\nb\5b\u0a8c\nb\3c\3c\3c\5c\u0a91\nc\3c\3"+
		"c\3c\3d\3d\3e\3e\3e\3e\3e\3e\3f\3f\3f\3f\3f\3g\3g\3h\3h\3h\3h\3h\3h\3"+
		"h\3h\3h\3h\3h\3h\6h\u0ab1\nh\rh\16h\u0ab2\3h\3h\5h\u0ab7\nh\3i\3i\5i\u0abb"+
		"\ni\3j\3j\3j\6j\u0ac0\nj\rj\16j\u0ac1\3j\5j\u0ac5\nj\3j\3j\3k\3k\6k\u0acb"+
		"\nk\rk\16k\u0acc\3k\5k\u0ad0\nk\3k\3k\3l\3l\3l\3l\3l\3m\3m\3m\3m\3m\3"+
		"n\3n\3n\3o\3o\5o\u0ae3\no\3p\3p\3p\3p\3p\3p\3p\3q\3q\3r\3r\3s\3s\3s\5"+
		"s\u0af3\ns\3t\3t\3t\5t\u0af8\nt\3u\3u\3u\7u\u0afd\nu\fu\16u\u0b00\13u"+
		"\3v\3v\3v\7v\u0b05\nv\fv\16v\u0b08\13v\3w\5w\u0b0b\nw\3w\3w\3x\3x\3x\3"+
		"x\7x\u0b13\nx\fx\16x\u0b16\13x\3x\3x\3y\3y\3y\7y\u0b1d\ny\fy\16y\u0b20"+
		"\13y\3y\5y\u0b23\ny\3z\3z\3{\3{\3|\3|\3|\3|\3|\3|\3|\3}\3}\3}\5}\u0b33"+
		"\n}\3~\3~\3\177\3\177\5\177\u0b39\n\177\3\u0080\3\u0080\3\u0081\3\u0081"+
		"\3\u0081\7\u0081\u0b40\n\u0081\f\u0081\16\u0081\u0b43\13\u0081\3\u0082"+
		"\3\u0082\3\u0083\3\u0083\5\u0083\u0b49\n\u0083\3\u0084\3\u0084\3\u0085"+
		"\3\u0085\3\u0085\3\u0085\3\u0085\3\u0086\5\u0086\u0b53\n\u0086\3\u0086"+
		"\5\u0086\u0b56\n\u0086\3\u0086\5\u0086\u0b59\n\u0086\3\u0086\3\u0086\3"+
		"\u0086\3\u0086\3\u0086\5\u0086\u0b60\n\u0086\3\u0087\3\u0087\3\u0088\3"+
		"\u0088\3\u0089\3\u0089\3\u0089\7\u0089\u0b69\n\u0089\f\u0089\16\u0089"+
		"\u0b6c\13\u0089\3\u008a\3\u008a\3\u008a\7\u008a\u0b71\n\u008a\f\u008a"+
		"\16\u008a\u0b74\13\u008a\3\u008b\3\u008b\3\u008b\5\u008b\u0b79\n\u008b"+
		"\3\u008c\3\u008c\5\u008c\u0b7d\n\u008c\3\u008d\3\u008d\5\u008d\u0b81\n"+
		"\u008d\3\u008d\3\u008d\3\u008e\3\u008e\3\u008f\3\u008f\5\u008f\u0b89\n"+
		"\u008f\3\u0090\3\u0090\5\u0090\u0b8d\n\u0090\3\u0091\3\u0091\3\u0091\3"+
		"\u0091\3\u0092\3\u0092\5\u0092\u0b95\n\u0092\3\u0093\3\u0093\3\u0094\3"+
		"\u0094\3\u0095\3\u0095\5\u0095\u0b9d\n\u0095\3\u0096\3\u0096\5\u0096\u0ba1"+
		"\n\u0096\3\u0097\3\u0097\5\u0097\u0ba5\n\u0097\3\u0097\5\u0097\u0ba8\n"+
		"\u0097\3\u0097\5\u0097\u0bab\n\u0097\3\u0097\5\u0097\u0bae\n\u0097\3\u0097"+
		"\5\u0097\u0bb1\n\u0097\3\u0098\3\u0098\3\u0098\3\u0099\3\u0099\3\u0099"+
		"\7\u0099\u0bb9\n\u0099\f\u0099\16\u0099\u0bbc\13\u0099\3\u009a\3\u009a"+
		"\5\u009a\u0bc0\n\u009a\3\u009b\3\u009b\6\u009b\u0bc4\n\u009b\r\u009b\16"+
		"\u009b\u0bc5\3\u009c\3\u009c\3\u009c\3\u009c\5\u009c\u0bcc\n\u009c\3\u009c"+
		"\3\u009c\3\u009c\3\u009c\3\u009c\3\u009c\5\u009c\u0bd4\n\u009c\3\u009c"+
		"\3\u009c\3\u009c\3\u009c\3\u009c\5\u009c\u0bdb\n\u009c\3\u009d\3\u009d"+
		"\3\u009d\3\u009d\3\u009e\5\u009e\u0be2\n\u009e\3\u009e\3\u009e\3\u009e"+
		"\3\u009e\3\u009f\3\u009f\5\u009f\u0bea\n\u009f\3\u009f\3\u009f\3\u009f"+
		"\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1\5\u00a1\u0bf5\n\u00a1"+
		"\3\u00a2\3\u00a2\5\u00a2\u0bf9\n\u00a2\3\u00a3\3\u00a3\3\u00a4\3\u00a4"+
		"\5\u00a4\u0bff\n\u00a4\3\u00a5\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3\u00a6"+
		"\3\u00a6\3\u00a6\3\u00a7\3\u00a7\5\u00a7\u0c0b\n\u00a7\3\u00a7\5\u00a7"+
		"\u0c0e\n\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\5\u00a7\u0c14\n\u00a7\3"+
		"\u00a7\3\u00a7\5\u00a7\u0c18\n\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3"+
		"\u00a7\5\u00a7\u0c1f\n\u00a7\5\u00a7\u0c21\n\u00a7\3\u00a8\3\u00a8\3\u00a8"+
		"\7\u00a8\u0c26\n\u00a8\f\u00a8\16\u00a8\u0c29\13\u00a8\3\u00a9\3\u00a9"+
		"\3\u00aa\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ac"+
		"\3\u00ad\3\u00ad\3\u00ad\7\u00ad\u0c39\n\u00ad\f\u00ad\16\u00ad\u0c3c"+
		"\13\u00ad\3\u00ae\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u0c42\n\u00ae\3\u00af"+
		"\3\u00af\3\u00af\3\u00af\3\u00af\5\u00af\u0c49\n\u00af\3\u00b0\3\u00b0"+
		"\3\u00b0\7\u00b0\u0c4e\n\u00b0\f\u00b0\16\u00b0\u0c51\13\u00b0\3\u00b1"+
		"\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2"+
		"\3\u00b3\3\u00b3\3\u00b3\3\u00b4\3\u00b4\3\u00b4\3\u00b5\3\u00b5\3\u00b5"+
		"\7\u00b5\u0c66\n\u00b5\f\u00b5\16\u00b5\u0c69\13\u00b5\3\u00b6\3\u00b6"+
		"\3\u00b7\3\u00b7\5\u00b7\u0c6f\n\u00b7\3\u00b8\3\u00b8\3\u00b8\3\u00b8"+
		"\5\u00b8\u0c75\n\u00b8\3\u00b8\3\u00b8\5\u00b8\u0c79\n\u00b8\3\u00b8\3"+
		"\u00b8\5\u00b8\u0c7d\n\u00b8\3\u00b8\7\u00b8\u0c80\n\u00b8\f\u00b8\16"+
		"\u00b8\u0c83\13\u00b8\3\u00b9\3\u00b9\5\u00b9\u0c87\n\u00b9\3\u00ba\3"+
		"\u00ba\3\u00ba\3\u00ba\5\u00ba\u0c8d\n\u00ba\3\u00ba\3\u00ba\5\u00ba\u0c91"+
		"\n\u00ba\3\u00ba\3\u00ba\5\u00ba\u0c95\n\u00ba\3\u00ba\7\u00ba\u0c98\n"+
		"\u00ba\f\u00ba\16\u00ba\u0c9b\13\u00ba\3\u00bb\3\u00bb\5\u00bb\u0c9f\n"+
		"\u00bb\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bc\5\u00bc\u0ca6\n\u00bc\3"+
		"\u00bd\3\u00bd\5\u00bd\u0caa\n\u00bd\3\u00be\3\u00be\3\u00be\3\u00bf\3"+
		"\u00bf\5\u00bf\u0cb1\n\u00bf\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\5"+
		"\u00c0\u0cb8\n\u00c0\5\u00c0\u0cba\n\u00c0\3\u00c1\3\u00c1\5\u00c1\u0cbe"+
		"\n\u00c1\3\u00c1\3\u00c1\5\u00c1\u0cc2\n\u00c1\3\u00c2\3\u00c2\3\u00c2"+
		"\7\u00c2\u0cc7\n\u00c2\f\u00c2\16\u00c2\u0cca\13\u00c2\3\u00c3\3\u00c3"+
		"\5\u00c3\u0cce\n\u00c3\3\u00c4\3\u00c4\5\u00c4\u0cd2\n\u00c4\3\u00c5\3"+
		"\u00c5\5\u00c5\u0cd6\n\u00c5\3\u00c5\3\u00c5\3\u00c6\3\u00c6\3\u00c7\3"+
		"\u00c7\3\u00c7\5\u00c7\u0cdf\n\u00c7\3\u00c7\3\u00c7\3\u00c8\5\u00c8\u0ce4"+
		"\n\u00c8\3\u00c8\3\u00c8\3\u00c9\3\u00c9\3\u00c9\7\u00c9\u0ceb\n\u00c9"+
		"\f\u00c9\16\u00c9\u0cee\13\u00c9\3\u00ca\3\u00ca\3\u00cb\3\u00cb\3\u00cc"+
		"\3\u00cc\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00ce\3\u00ce\3\u00ce\3\u00ce"+
		"\3\u00ce\3\u00ce\5\u00ce\u0d00\n\u00ce\3\u00cf\3\u00cf\3\u00cf\3\u00cf"+
		"\3\u00d0\3\u00d0\3\u00d1\3\u00d1\3\u00d1\3\u00d2\5\u00d2\u0d0c\n\u00d2"+
		"\3\u00d2\3\u00d2\5\u00d2\u0d10\n\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2"+
		"\3\u00d3\3\u00d3\5\u00d3\u0d18\n\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d4"+
		"\3\u00d4\3\u00d4\3\u00d4\3\u00d4\5\u00d4\u0d22\n\u00d4\3\u00d5\3\u00d5"+
		"\3\u00d5\7\u00d5\u0d27\n\u00d5\f\u00d5\16\u00d5\u0d2a\13\u00d5\3\u00d6"+
		"\3\u00d6\3\u00d6\3\u00d6\3\u00d7\5\u00d7\u0d31\n\u00d7\3\u00d7\3\u00d7"+
		"\5\u00d7\u0d35\n\u00d7\3\u00d8\3\u00d8\3\u00d8\3\u00d8\3\u00d8\3\u00d8"+
		"\5\u00d8\u0d3d\n\u00d8\3\u00d9\3\u00d9\3\u00da\3\u00da\3\u00da\5\u00da"+
		"\u0d44\n\u00da\3\u00da\3\u00da\3\u00db\3\u00db\3\u00db\3\u00db\3\u00db"+
		"\3\u00dc\3\u00dc\5\u00dc\u0d4f\n\u00dc\3\u00dd\3\u00dd\3\u00de\3\u00de"+
		"\3\u00df\5\u00df\u0d56\n\u00df\3\u00df\3\u00df\3\u00df\3\u00e0\3\u00e0"+
		"\3\u00e0\3\u00e1\3\u00e1\5\u00e1\u0d60\n\u00e1\3\u00e2\3\u00e2\3\u00e3"+
		"\3\u00e3\3\u00e4\3\u00e4\3\u00e4\5\u00e4\u0d69\n\u00e4\3\u00e4\3\u00e4"+
		"\3\u00e5\3\u00e5\3\u00e6\3\u00e6\5\u00e6\u0d71\n\u00e6\3\u00e7\3\u00e7"+
		"\3\u00e7\7\u00e7\u0d76\n\u00e7\f\u00e7\16\u00e7\u0d79\13\u00e7\3\u00e8"+
		"\3\u00e8\3\u00e8\3\u00e8\3\u00e9\3\u00e9\3\u00e9\7\u00e9\u0d82\n\u00e9"+
		"\f\u00e9\16\u00e9\u0d85\13\u00e9\3\u00ea\3\u00ea\5\u00ea\u0d89\n\u00ea"+
		"\3\u00ea\5\u00ea\u0d8c\n\u00ea\3\u00eb\3\u00eb\3\u00ec\3\u00ec\3\u00ec"+
		"\3\u00ed\3\u00ed\3\u00ed\3\u00ed\5\u00ed\u0d97\n\u00ed\3\u00ee\3\u00ee"+
		"\5\u00ee\u0d9b\n\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee"+
		"\5\u00ee\u0da3\n\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\5\u00ee\u0da9\n"+
		"\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\5\u00ee\u0db1\n"+
		"\u00ee\5\u00ee\u0db3\n\u00ee\3\u00ee\5\u00ee\u0db6\n\u00ee\3\u00ee\2\2"+
		"\u00ef\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		">@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
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
		"\2\'\4\2KKkk\4\2\u00f7\u00f7\u0132\u0132\t\2\37\37``jjvvxx{{\u00b4\u00b4"+
		"\6\2``jj{{\u00b4\u00b4\4\2jj{|\5\2\24\24\30\30rs\4\2\30\30||\4\2\20\20"+
		"bb\4\2jj{{\3\2\u0149\u0149\3\2\u014a\u014a\4\2\u00b6\u00b6\u00b9\u00b9"+
		"\6\2::AARR~~\3\2rs\4\2\62\62KK\4\2((;;\b\2\6\6\26\26\34\34\u0092\u0092"+
		"\u00b1\u00b1\u00ea\u00ea\t\2\u0084\u00ae\u00b0\u00b0\u00b2\u00ef\u00f1"+
		"\u00fe\u0100\u0115\u0117\u0125\u0127\u012b\5\2++ww\u00f9\u00f9\3\2\u0106"+
		"\u0107\3\2\u014b\u014c\17\2\t\tmm\u0085\u0085\u008e\u008e\u0096\u0096"+
		"\u00a4\u00a4\u00ac\u00ac\u00b5\u00b5\u00c1\u00c1\u00c6\u00c6\u00eb\u00ec"+
		"\u00ee\u00ee\u00fc\u00fd\3\2\u013e\u013f\3\2\u0140\u0142\3\2\u00f3\u00f5"+
		"\5\2\16\16GGuu\5\2..HHee\4\2&&yy\4\2\6\6!!\4\2\u0132\u0132\u0137\u013b"+
		"\4\2\n\npp\3\2\u012c\u012f\4\2\t\tmm\6\2\u009b\u009b\u00af\u00af\u00c8"+
		"\u00c9\u0104\u0104\n\2\u008b\u008b\u009d\u009d\u00a0\u00a1\u00a3\u00a3"+
		"\u00b7\u00b8\u00c3\u00c5\u00da\u00da\u0101\u0101\4\2HHee\4\2\13\13  \u0f70"+
		"\2\u01e2\3\2\2\2\4\u01e7\3\2\2\2\6\u01e9\3\2\2\2\b\u01eb\3\2\2\2\n\u01f0"+
		"\3\2\2\2\f\u01fe\3\2\2\2\16\u0200\3\2\2\2\20\u0226\3\2\2\2\22\u0255\3"+
		"\2\2\2\24\u0257\3\2\2\2\26\u0268\3\2\2\2\30\u02a6\3\2\2\2\32\u02a8\3\2"+
		"\2\2\34\u0469\3\2\2\2\36\u046b\3\2\2\2 \u05c0\3\2\2\2\"\u05c2\3\2\2\2"+
		"$\u05d6\3\2\2\2&\u0653\3\2\2\2(\u06b4\3\2\2\2*\u06cd\3\2\2\2,\u06cf\3"+
		"\2\2\2.\u06d8\3\2\2\2\60\u06e1\3\2\2\2\62\u06e3\3\2\2\2\64\u06e5\3\2\2"+
		"\2\66\u06fc\3\2\2\28\u0708\3\2\2\2:\u075d\3\2\2\2<\u075f\3\2\2\2>\u0784"+
		"\3\2\2\2@\u07f6\3\2\2\2B\u07f8\3\2\2\2D\u07fd\3\2\2\2F\u0870\3\2\2\2H"+
		"\u08a2\3\2\2\2J\u08a7\3\2\2\2L\u08bc\3\2\2\2N\u08c7\3\2\2\2P\u08cb\3\2"+
		"\2\2R\u08d3\3\2\2\2T\u08d6\3\2\2\2V\u08de\3\2\2\2X\u08e9\3\2\2\2Z\u08ec"+
		"\3\2\2\2\\\u08ee\3\2\2\2^\u08fa\3\2\2\2`\u08fe\3\2\2\2b\u0901\3\2\2\2"+
		"d\u0904\3\2\2\2f\u090a\3\2\2\2h\u090c\3\2\2\2j\u0916\3\2\2\2l\u091e\3"+
		"\2\2\2n\u0930\3\2\2\2p\u093d\3\2\2\2r\u0945\3\2\2\2t\u0948\3\2\2\2v\u094b"+
		"\3\2\2\2x\u0955\3\2\2\2z\u095d\3\2\2\2|\u0967\3\2\2\2~\u096c\3\2\2\2\u0080"+
		"\u096e\3\2\2\2\u0082\u0982\3\2\2\2\u0084\u0984\3\2\2\2\u0086\u0988\3\2"+
		"\2\2\u0088\u098d\3\2\2\2\u008a\u0992\3\2\2\2\u008c\u0994\3\2\2\2\u008e"+
		"\u0997\3\2\2\2\u0090\u099a\3\2\2\2\u0092\u099d\3\2\2\2\u0094\u09a2\3\2"+
		"\2\2\u0096\u09b1\3\2\2\2\u0098\u09b3\3\2\2\2\u009a\u09b5\3\2\2\2\u009c"+
		"\u09ce\3\2\2\2\u009e\u09d0\3\2\2\2\u00a0\u09f7\3\2\2\2\u00a2\u0a01\3\2"+
		"\2\2\u00a4\u0a05\3\2\2\2\u00a6\u0a1c\3\2\2\2\u00a8\u0a28\3\2\2\2\u00aa"+
		"\u0a32\3\2\2\2\u00ac\u0a34\3\2\2\2\u00ae\u0a47\3\2\2\2\u00b0\u0a56\3\2"+
		"\2\2\u00b2\u0a65\3\2\2\2\u00b4\u0a69\3\2\2\2\u00b6\u0a6b\3\2\2\2\u00b8"+
		"\u0a76\3\2\2\2\u00ba\u0a78\3\2\2\2\u00bc\u0a7a\3\2\2\2\u00be\u0a7d\3\2"+
		"\2\2\u00c0\u0a81\3\2\2\2\u00c2\u0a8b\3\2\2\2\u00c4\u0a8d\3\2\2\2\u00c6"+
		"\u0a95\3\2\2\2\u00c8\u0a97\3\2\2\2\u00ca\u0a9d\3\2\2\2\u00cc\u0aa2\3\2"+
		"\2\2\u00ce\u0ab6\3\2\2\2\u00d0\u0aba\3\2\2\2\u00d2\u0abc\3\2\2\2\u00d4"+
		"\u0ac8\3\2\2\2\u00d6\u0ad3\3\2\2\2\u00d8\u0ad8\3\2\2\2\u00da\u0add\3\2"+
		"\2\2\u00dc\u0ae2\3\2\2\2\u00de\u0ae4\3\2\2\2\u00e0\u0aeb\3\2\2\2\u00e2"+
		"\u0aed\3\2\2\2\u00e4\u0af2\3\2\2\2\u00e6\u0af7\3\2\2\2\u00e8\u0af9\3\2"+
		"\2\2\u00ea\u0b01\3\2\2\2\u00ec\u0b0a\3\2\2\2\u00ee\u0b0e\3\2\2\2\u00f0"+
		"\u0b22\3\2\2\2\u00f2\u0b24\3\2\2\2\u00f4\u0b26\3\2\2\2\u00f6\u0b28\3\2"+
		"\2\2\u00f8\u0b32\3\2\2\2\u00fa\u0b34\3\2\2\2\u00fc\u0b38\3\2\2\2\u00fe"+
		"\u0b3a\3\2\2\2\u0100\u0b3c\3\2\2\2\u0102\u0b44\3\2\2\2\u0104\u0b48\3\2"+
		"\2\2\u0106\u0b4a\3\2\2\2\u0108\u0b4c\3\2\2\2\u010a\u0b5f\3\2\2\2\u010c"+
		"\u0b61\3\2\2\2\u010e\u0b63\3\2\2\2\u0110\u0b65\3\2\2\2\u0112\u0b6d\3\2"+
		"\2\2\u0114\u0b78\3\2\2\2\u0116\u0b7a\3\2\2\2\u0118\u0b7e\3\2\2\2\u011a"+
		"\u0b84\3\2\2\2\u011c\u0b88\3\2\2\2\u011e\u0b8c\3\2\2\2\u0120\u0b8e\3\2"+
		"\2\2\u0122\u0b94\3\2\2\2\u0124\u0b96\3\2\2\2\u0126\u0b98\3\2\2\2\u0128"+
		"\u0b9c\3\2\2\2\u012a\u0ba0\3\2\2\2\u012c\u0ba2\3\2\2\2\u012e\u0bb2\3\2"+
		"\2\2\u0130\u0bb5\3\2\2\2\u0132\u0bbf\3\2\2\2\u0134\u0bc1\3\2\2\2\u0136"+
		"\u0bda\3\2\2\2\u0138\u0bdc\3\2\2\2\u013a\u0be1\3\2\2\2\u013c\u0be7\3\2"+
		"\2\2\u013e\u0bee\3\2\2\2\u0140\u0bf4\3\2\2\2\u0142\u0bf6\3\2\2\2\u0144"+
		"\u0bfa\3\2\2\2\u0146\u0bfe\3\2\2\2\u0148\u0c00\3\2\2\2\u014a\u0c03\3\2"+
		"\2\2\u014c\u0c20\3\2\2\2\u014e\u0c22\3\2\2\2\u0150\u0c2a\3\2\2\2\u0152"+
		"\u0c2c\3\2\2\2\u0154\u0c2f\3\2\2\2\u0156\u0c31\3\2\2\2\u0158\u0c35\3\2"+
		"\2\2\u015a\u0c41\3\2\2\2\u015c\u0c48\3\2\2\2\u015e\u0c4a\3\2\2\2\u0160"+
		"\u0c52\3\2\2\2\u0162\u0c57\3\2\2\2\u0164\u0c5c\3\2\2\2\u0166\u0c5f\3\2"+
		"\2\2\u0168\u0c62\3\2\2\2\u016a\u0c6a\3\2\2\2\u016c\u0c6e\3\2\2\2\u016e"+
		"\u0c78\3\2\2\2\u0170\u0c86\3\2\2\2\u0172\u0c90\3\2\2\2\u0174\u0c9e\3\2"+
		"\2\2\u0176\u0ca5\3\2\2\2\u0178\u0ca9\3\2\2\2\u017a\u0cab\3\2\2\2\u017c"+
		"\u0cb0\3\2\2\2\u017e\u0cb2\3\2\2\2\u0180\u0cbb\3\2\2\2\u0182\u0cc3\3\2"+
		"\2\2\u0184\u0ccd\3\2\2\2\u0186\u0ccf\3\2\2\2\u0188\u0cd5\3\2\2\2\u018a"+
		"\u0cd9\3\2\2\2\u018c\u0cde\3\2\2\2\u018e\u0ce3\3\2\2\2\u0190\u0ce7\3\2"+
		"\2\2\u0192\u0cef\3\2\2\2\u0194\u0cf1\3\2\2\2\u0196\u0cf3\3\2\2\2\u0198"+
		"\u0cf5\3\2\2\2\u019a\u0cff\3\2\2\2\u019c\u0d01\3\2\2\2\u019e\u0d05\3\2"+
		"\2\2\u01a0\u0d07\3\2\2\2\u01a2\u0d0b\3\2\2\2\u01a4\u0d15\3\2\2\2\u01a6"+
		"\u0d21\3\2\2\2\u01a8\u0d23\3\2\2\2\u01aa\u0d2b\3\2\2\2\u01ac\u0d34\3\2"+
		"\2\2\u01ae\u0d3c\3\2\2\2\u01b0\u0d3e\3\2\2\2\u01b2\u0d40\3\2\2\2\u01b4"+
		"\u0d47\3\2\2\2\u01b6\u0d4e\3\2\2\2\u01b8\u0d50\3\2\2\2\u01ba\u0d52\3\2"+
		"\2\2\u01bc\u0d55\3\2\2\2\u01be\u0d5a\3\2\2\2\u01c0\u0d5f\3\2\2\2\u01c2"+
		"\u0d61\3\2\2\2\u01c4\u0d63\3\2\2\2\u01c6\u0d65\3\2\2\2\u01c8\u0d6c\3\2"+
		"\2\2\u01ca\u0d70\3\2\2\2\u01cc\u0d72\3\2\2\2\u01ce\u0d7a\3\2\2\2\u01d0"+
		"\u0d7e\3\2\2\2\u01d2\u0d86\3\2\2\2\u01d4\u0d8d\3\2\2\2\u01d6\u0d8f\3\2"+
		"\2\2\u01d8\u0d96\3\2\2\2\u01da\u0db5\3\2\2\2\u01dc\u01de\5\4\3\2\u01dd"+
		"\u01df\7\u0134\2\2\u01de\u01dd\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e1"+
		"\3\2\2\2\u01e0\u01dc\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2"+
		"\u01e3\3\2\2\2\u01e3\u01e5\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5\u01e6\7\2"+
		"\2\3\u01e6\3\3\2\2\2\u01e7\u01e8\5\n\6\2\u01e8\5\3\2\2\2\u01e9\u01ea\5"+
		"\u016a\u00b6\2\u01ea\7\3\2\2\2\u01eb\u01ec\5\u01da\u00ee\2\u01ec\t\3\2"+
		"\2\2\u01ed\u01f1\5\f\7\2\u01ee\u01f1\5\16\b\2\u01ef\u01f1\5\u0080A\2\u01f0"+
		"\u01ed\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01ef\3\2\2\2\u01f1\13\3\2\2"+
		"\2\u01f2\u01ff\5@!\2\u01f3\u01ff\5\24\13\2\u01f4\u01ff\5\26\f\2\u01f5"+
		"\u01ff\5\32\16\2\u01f6\u01ff\5&\24\2\u01f7\u01ff\58\35\2\u01f8\u01ff\5"+
		":\36\2\u01f9\u01ff\5<\37\2\u01fa\u01ff\5$\23\2\u01fb\u01ff\5\34\17\2\u01fc"+
		"\u01ff\5\30\r\2\u01fd\u01ff\5 \21\2\u01fe\u01f2\3\2\2\2\u01fe\u01f3\3"+
		"\2\2\2\u01fe\u01f4\3\2\2\2\u01fe\u01f5\3\2\2\2\u01fe\u01f6\3\2\2\2\u01fe"+
		"\u01f7\3\2\2\2\u01fe\u01f8\3\2\2\2\u01fe\u01f9\3\2\2\2\u01fe\u01fa\3\2"+
		"\2\2\u01fe\u01fb\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01fd\3\2\2\2\u01ff"+
		"\r\3\2\2\2\u0200\u0201\5\20\t\2\u0201\17\3\2\2\2\u0202\u0203\7\7\2\2\u0203"+
		"\u0204\7/\2\2\u0204\u0205\5\u017e\u00c0\2\u0205\u0207\5(\25\2\u0206\u0208"+
		"\5\22\n\2\u0207\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u0207\3\2\2\2"+
		"\u0209\u020a\3\2\2\2\u020a\u020c\3\2\2\2\u020b\u020d\7b\2\2\u020c\u020b"+
		"\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u0227\3\2\2\2\u020e\u020f\7\7\2\2\u020f"+
		"\u0210\7/\2\2\u0210\u0211\5\u017e\u00c0\2\u0211\u0212\5(\25\2\u0212\u0213"+
		"\7\u00dd\2\2\u0213\u0214\7\u00f7\2\2\u0214\u0215\5\u017e\u00c0\2\u0215"+
		"\u0227\3\2\2\2\u0216\u0217\7\7\2\2\u0217\u0218\7/\2\2\u0218\u0219\5\u017e"+
		"\u00c0\2\u0219\u021a\5(\25\2\u021a\u021b\7W\2\2\u021b\u021c\7\u00f7\2"+
		"\2\u021c\u021d\5\u0082B\2\u021d\u0227\3\2\2\2\u021e\u021f\7\7\2\2\u021f"+
		"\u0220\7/\2\2\u0220\u0221\5\u017e\u00c0\2\u0221\u0222\5(\25\2\u0222\u0223"+
		"\7\u00e5\2\2\u0223\u0224\7g\2\2\u0224\u0225\5\u017e\u00c0\2\u0225\u0227"+
		"\3\2\2\2\u0226\u0202\3\2\2\2\u0226\u020e\3\2\2\2\u0226\u0216\3\2\2\2\u0226"+
		"\u021e\3\2\2\2\u0227\21\3\2\2\2\u0228\u0229\7\u0089\2\2\u0229\u022a\7"+
		"\u00cf\2\2\u022a\u022b\7N\2\2\u022b\u0256\7\u00b3\2\2\u022c\u022d\7c\2"+
		"\2\u022d\u022e\7N\2\2\u022e\u022f\7\u00cf\2\2\u022f\u0230\7N\2\2\u0230"+
		"\u0256\7\u00b3\2\2\u0231\u0232\7o\2\2\u0232\u0256\79\2\2\u0233\u0256\7"+
		"\u00e8\2\2\u0234\u0236\7\u0100\2\2\u0235\u0237\7\u00a6\2\2\u0236\u0235"+
		"\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u0239\7\u00e3\2"+
		"\2\u0239\u0256\7C\2\2\u023a\u023c\7\u00a6\2\2\u023b\u023a\3\2\2\2\u023b"+
		"\u023c\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023e\7\u00e3\2\2\u023e\u023f"+
		"\7\u009e\2\2\u023f\u0240\7\u0095\2\2\u0240\u0241\7\u014b\2\2\u0241\u0242"+
		"\7_\2\2\u0242\u0243\7\u014b\2\2\u0243\u0244\7\u00e5\2\2\u0244\u024a\5"+
		"\u0082B\2\u0245\u0246\7\u00f7\2\2\u0246\u024b\5\u0082B\2\u0247\u0248\7"+
		"\u0132\2\2\u0248\u024b\5\u0082B\2\u0249\u024b\7\33\2\2\u024a\u0245\3\2"+
		"\2\2\u024a\u0247\3\2\2\2\u024a\u0249\3\2\2\2\u024b\u024c\3\2\2\2\u024c"+
		"\u024d\7\u00e5\2\2\u024d\u024e\5\u0082B\2\u024e\u024f\7\61\2\2\u024f\u0250"+
		"\7\u0098\2\2\u0250\u0251\7\u00de\2\2\u0251\u0252\5\u0082B\2\u0252\u0253"+
		"\7\u00de\2\2\u0253\u0254\7\6\2\2\u0254\u0256\3\2\2\2\u0255\u0228\3\2\2"+
		"\2\u0255\u022c\3\2\2\2\u0255\u0231\3\2\2\2\u0255\u0233\3\2\2\2\u0255\u0234"+
		"\3\2\2\2\u0255\u023b\3\2\2\2\u0256\23\3\2\2\2\u0257\u0259\7\30\2\2\u0258"+
		"\u025a\7z\2\2\u0259\u0258\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u025b\3\2"+
		"\2\2\u025b\u025c\7\u00b0\2\2\u025c\u025d\5\u0082B\2\u025d\u025e\7\u00cf"+
		"\2\2\u025e\u0260\5\u017e\u00c0\2\u025f\u0261\5`\61\2\u0260\u025f\3\2\2"+
		"\2\u0260\u0261\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0263\7\u013c\2\2\u0263"+
		"\u0264\5\u01d0\u00e9\2\u0264\u0266\7\u013d\2\2\u0265\u0267\5\\/\2\u0266"+
		"\u0265\3\2\2\2\u0266\u0267\3\2\2\2\u0267\25\3\2\2\2\u0268\u0269\7\30\2"+
		"\2\u0269\u026d\7*\2\2\u026a\u026b\7\66\2\2\u026b\u026c\7M\2\2\u026c\u026e"+
		"\7\u00a5\2\2\u026d\u026a\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u026f\3\2\2"+
		"\2\u026f\u0271\5\u0082B\2\u0270\u0272\7\u0082\2\2\u0271\u0270\3\2\2\2"+
		"\u0271\u0272\3\2\2\2\u0272\u0275\3\2\2\2\u0273\u0274\7g\2\2\u0274\u0276"+
		"\5\u0082B\2\u0275\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0279\3\2\2"+
		"\2\u0277\u0278\7\u00ff\2\2\u0278\u027a\5\u0082B\2\u0279\u0277\3\2\2\2"+
		"\u0279\u027a\3\2\2\2\u027a\u027d\3\2\2\2\u027b\u027c\7\61\2\2\u027c\u027e"+
		"\5\u0082B\2\u027d\u027b\3\2\2\2\u027d\u027e\3\2\2\2\u027e\27\3\2\2\2\u027f"+
		"\u0281\7\u00e5\2\2\u0280\u0282\t\2\2\2\u0281\u0280\3\2\2\2\u0281\u0282"+
		"\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0284\5\u0082B\2\u0284\u0290\t\3\2"+
		"\2\u0285\u028c\5\u00e4s\2\u0286\u0287\7\u0146\2\2\u0287\u0288\5\u00e4"+
		"s\2\u0288\u0289\7\u0146\2\2\u0289\u028c\3\2\2\2\u028a\u028c\7\33\2\2\u028b"+
		"\u0285\3\2\2\2\u028b\u0286\3\2\2\2\u028b\u028a\3\2\2\2\u028c\u028e\3\2"+
		"\2\2\u028d\u028f\7\u0135\2\2\u028e\u028d\3\2\2\2\u028e\u028f\3\2\2\2\u028f"+
		"\u0291\3\2\2\2\u0290\u028b\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0290\3\2"+
		"\2\2\u0292\u0293\3\2\2\2\u0293\u02a7\3\2\2\2\u0294\u0296\7\u00e5\2\2\u0295"+
		"\u0297\t\2\2\2\u0296\u0295\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u0298\3\2"+
		"\2\2\u0298\u0299\7\u0120\2\2\u0299\u02a2\7\u0105\2\2\u029a\u029e\5\u0082"+
		"B\2\u029b\u029e\7K\2\2\u029c\u029e\7\33\2\2\u029d\u029a\3\2\2\2\u029d"+
		"\u029b\3\2\2\2\u029d\u029c\3\2\2\2\u029e\u02a0\3\2\2\2\u029f\u02a1\7\u0135"+
		"\2\2\u02a0\u029f\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a3\3\2\2\2\u02a2"+
		"\u029d\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4\u02a5\3\2"+
		"\2\2\u02a5\u02a7\3\2\2\2\u02a6\u027f\3\2\2\2\u02a6\u0294\3\2\2\2\u02a7"+
		"\31\3\2\2\2\u02a8\u02aa\7\30\2\2\u02a9\u02ab\7\25\2\2\u02aa\u02a9\3\2"+
		"\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ad\7v\2\2\u02ad"+
		"\u02b2\5\u0082B\2\u02ae\u02b3\7\r\2\2\u02af\u02b0\7B\2\2\u02b0\u02b3\7"+
		"O\2\2\u02b1\u02b3\7\4\2\2\u02b2\u02ae\3\2\2\2\u02b2\u02af\3\2\2\2\u02b2"+
		"\u02b1\3\2\2\2\u02b3\u02c3\3\2\2\2\u02b4\u02c4\7\u00b4\2\2\u02b5\u02c4"+
		"\7\37\2\2\u02b6\u02c4\7x\2\2\u02b7\u02c1\7{\2\2\u02b8\u02bd\7O\2\2\u02b9"+
		"\u02bb\5\u0082B\2\u02ba\u02bc\7\u0135\2\2\u02bb\u02ba\3\2\2\2\u02bb\u02bc"+
		"\3\2\2\2\u02bc\u02be\3\2\2\2\u02bd\u02b9\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf"+
		"\u02bd\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c2\3\2\2\2\u02c1\u02b8\3\2"+
		"\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c4\3\2\2\2\u02c3\u02b4\3\2\2\2\u02c3"+
		"\u02b5\3\2\2\2\u02c3\u02b6\3\2\2\2\u02c3\u02b7\3\2\2\2\u02c4\u02c5\3\2"+
		"\2\2\u02c5\u02c6\7\u00cf\2\2\u02c6\u02c9\5\u017e\u00c0\2\u02c7\u02c8\7"+
		"\61\2\2\u02c8\u02ca\5\u017e\u00c0\2\u02c9\u02c7\3\2\2\2\u02c9\u02ca\3"+
		"\2\2\2\u02ca\u02d4\3\2\2\2\u02cb\u02cc\7M\2\2\u02cc\u02d5\7\35\2\2\u02cd"+
		"\u02cf\7\35\2\2\u02ce\u02cd\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02d0\3"+
		"\2\2\2\u02d0\u02d1\7=\2\2\u02d1\u02d5\78\2\2\u02d2\u02d3\7=\2\2\u02d3"+
		"\u02d5\7\36\2\2\u02d4\u02cb\3\2\2\2\u02d4\u02ce\3\2\2\2\u02d4\u02d2\3"+
		"\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02dc\3\2\2\2\u02d6\u02d8\7,\2\2\u02d7"+
		"\u02d9\7#\2\2\u02d8\u02d7\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02da\3\2"+
		"\2\2\u02da\u02dd\7^\2\2\u02db\u02dd\7n\2\2\u02dc\u02d6\3\2\2\2\u02dc\u02db"+
		"\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02e0\3\2\2\2\u02de\u02df\7\u0080\2"+
		"\2\u02df\u02e1\5\u010e\u0088\2\u02e0\u02de\3\2\2\2\u02e0\u02e1\3\2\2\2"+
		"\u02e1\u02e2\3\2\2\2\u02e2\u02e3\7)\2\2\u02e3\u02e4\7[\2\2\u02e4\u02e5"+
		"\5\u0082B\2\u02e5\u02ea\7\u013c\2\2\u02e6\u02e8\5\u0082B\2\u02e7\u02e9"+
		"\7\u0135\2\2\u02e8\u02e7\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02eb\3\2\2"+
		"\2\u02ea\u02e6\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02ed"+
		"\7\u013d\2\2\u02ed\33\3\2\2\2\u02ee\u02f2\7d\2\2\u02ef\u02f0\7\63\2\2"+
		"\u02f0\u02f1\7\u00d0\2\2\u02f1\u02f3\7,\2\2\u02f2\u02ef\3\2\2\2\u02f2"+
		"\u02f3\3\2\2\2\u02f3\u02fd\3\2\2\2\u02f4\u02f6\t\4\2\2\u02f5\u02f4\3\2"+
		"\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8"+
		"\u02fe\3\2\2\2\u02f9\u02fb\7\6\2\2\u02fa\u02fc\7Z\2\2\u02fb\u02fa\3\2"+
		"\2\2\u02fb\u02fc\3\2\2\2\u02fc\u02fe\3\2\2\2\u02fd\u02f5\3\2\2\2\u02fd"+
		"\u02f9\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0311\7\u00cf\2\2\u0300\u0302"+
		"\7q\2\2\u0301\u0300\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u0303\3\2\2\2\u0303"+
		"\u0305\5\u017e\u00c0\2\u0304\u0301\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u0304"+
		"\3\2\2\2\u0306\u0307\3\2\2\2\u0307\u0312\3\2\2\2\u0308\u0309\7\6\2\2\u0309"+
		"\u030a\7\u00f0\2\2\u030a\u030b\7:\2\2\u030b\u030d\7g\2\2\u030c\u030e\5"+
		"\u0082B\2\u030d\u030c\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u030d\3\2\2\2"+
		"\u030f\u0310\3\2\2\2\u0310\u0312\3\2\2\2\u0311\u0304\3\2\2\2\u0311\u0308"+
		"\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0314\5\36\20\2\u0314\u046a\3\2\2\2"+
		"\u0315\u0319\7d\2\2\u0316\u0317\7\63\2\2\u0317\u0318\7\u00d0\2\2\u0318"+
		"\u031a\7,\2\2\u0319\u0316\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u033a\3\2"+
		"\2\2\u031b\u031c\t\5\2\2\u031c\u0321\7\u013c\2\2\u031d\u031f\5\u0082B"+
		"\2\u031e\u0320\7\u0135\2\2\u031f\u031e\3\2\2\2\u031f\u0320\3\2\2\2\u0320"+
		"\u0322\3\2\2\2\u0321\u031d\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0321\3\2"+
		"\2\2\u0323\u0324\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0326\7\u013d\2\2\u0326"+
		"\u0328\3\2\2\2\u0327\u031b\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u0327\3\2"+
		"\2\2\u0329\u032a\3\2\2\2\u032a\u033b\3\2\2\2\u032b\u032d\7\6\2\2\u032c"+
		"\u032e\7Z\2\2\u032d\u032c\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u032f\3\2"+
		"\2\2\u032f\u0334\7\u013c\2\2\u0330\u0332\5\u0082B\2\u0331\u0333\7\u0135"+
		"\2\2\u0332\u0331\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0335\3\2\2\2\u0334"+
		"\u0330\3\2\2\2\u0335\u0336\3\2\2\2\u0336\u0334\3\2\2\2\u0336\u0337\3\2"+
		"\2\2\u0337\u0338\3\2\2\2\u0338\u0339\7\u013d\2\2\u0339\u033b\3\2\2\2\u033a"+
		"\u0327\3\2\2\2\u033a\u032b\3\2\2\2\u033b\u033c\3\2\2\2\u033c\u033e\7\u00cf"+
		"\2\2\u033d\u033f\7q\2\2\u033e\u033d\3\2\2\2\u033e\u033f\3\2\2\2\u033f"+
		"\u0344\3\2\2\2\u0340\u0342\5\u017e\u00c0\2\u0341\u0343\7\u0135\2\2\u0342"+
		"\u0341\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u0345\3\2\2\2\u0344\u0340\3\2"+
		"\2\2\u0345\u0346\3\2\2\2\u0346\u0344\3\2\2\2\u0346\u0347\3\2\2\2\u0347"+
		"\u0348\3\2\2\2\u0348\u0349\5\36\20\2\u0349\u046a\3\2\2\2\u034a\u034e\7"+
		"d\2\2\u034b\u034c\7\63\2\2\u034c\u034d\7\u00d0\2\2\u034d\u034f\7,\2\2"+
		"\u034e\u034b\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0359\3\2\2\2\u0350\u0352"+
		"\t\6\2\2\u0351\u0350\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u0351\3\2\2\2\u0353"+
		"\u0354\3\2\2\2\u0354\u035a\3\2\2\2\u0355\u0357\7\6\2\2\u0356\u0358\7Z"+
		"\2\2\u0357\u0356\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u035a\3\2\2\2\u0359"+
		"\u0351\3\2\2\2\u0359\u0355\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u0371\7\u00cf"+
		"\2\2\u035c\u0361\7h\2\2\u035d\u035f\5\u017e\u00c0\2\u035e\u0360\7\u0135"+
		"\2\2\u035f\u035e\3\2\2\2\u035f\u0360\3\2\2\2\u0360\u0362\3\2\2\2\u0361"+
		"\u035d\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0361\3\2\2\2\u0363\u0364\3\2"+
		"\2\2\u0364\u0372\3\2\2\2\u0365\u0366\7\6\2\2\u0366\u0367\7i\2\2\u0367"+
		"\u0368\7:\2\2\u0368\u036d\7g\2\2\u0369\u036b\5\u0082B\2\u036a\u036c\7"+
		"\u0135\2\2\u036b\u036a\3\2\2\2\u036b\u036c\3\2\2\2\u036c\u036e\3\2\2\2"+
		"\u036d\u0369\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u036d\3\2\2\2\u036f\u0370"+
		"\3\2\2\2\u0370\u0372\3\2\2\2\u0371\u035c\3\2\2\2\u0371\u0365\3\2\2\2\u0372"+
		"\u0373\3\2\2\2\u0373\u0374\5\36\20\2\u0374\u046a\3\2\2\2\u0375\u0379\7"+
		"d\2\2\u0376\u0377\7\63\2\2\u0377\u0378\7\u00d0\2\2\u0378\u037a\7,\2\2"+
		"\u0379\u0376\3\2\2\2\u0379\u037a\3\2\2\2\u037a\u0384\3\2\2\2\u037b\u037d"+
		"\t\7\2\2\u037c\u037b\3\2\2\2\u037d\u037e\3\2\2\2\u037e\u037c\3\2\2\2\u037e"+
		"\u037f\3\2\2\2\u037f\u0385\3\2\2\2\u0380\u0382\7\6\2\2\u0381\u0383\7Z"+
		"\2\2\u0382\u0381\3\2\2\2\u0382\u0383\3\2\2\2\u0383\u0385\3\2\2\2\u0384"+
		"\u037c\3\2\2\2\u0384\u0380\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u0387\7\u00cf"+
		"\2\2\u0387\u038c\7\32\2\2\u0388\u038a\5\u0082B\2\u0389\u038b\7\u0135\2"+
		"\2\u038a\u0389\3\2\2\2\u038a\u038b\3\2\2\2\u038b\u038d\3\2\2\2\u038c\u0388"+
		"\3\2\2\2\u038d\u038e\3\2\2\2\u038e\u038c\3\2\2\2\u038e\u038f\3\2\2\2\u038f"+
		"\u0390\3\2\2\2\u0390\u0391\5\36\20\2\u0391\u046a\3\2\2\2\u0392\u0396\7"+
		"d\2\2\u0393\u0394\7\63\2\2\u0394\u0395\7\u00d0\2\2\u0395\u0397\7,\2\2"+
		"\u0396\u0393\3\2\2\2\u0396\u0397\3\2\2\2\u0397\u039d\3\2\2\2\u0398\u039e"+
		"\7|\2\2\u0399\u039b\7\6\2\2\u039a\u039c\7Z\2\2\u039b\u039a\3\2\2\2\u039b"+
		"\u039c\3\2\2\2\u039c\u039e\3\2\2\2\u039d\u0398\3\2\2\2\u039d\u0399\3\2"+
		"\2\2\u039e\u039f\3\2\2\2\u039f\u03a0\7\u00cf\2\2\u03a0\u03a1\7-\2\2\u03a1"+
		"\u03a2\7\u009a\2\2\u03a2\u03a7\7\u0103\2\2\u03a3\u03a5\5\u017e\u00c0\2"+
		"\u03a4\u03a6\7\u0135\2\2\u03a5\u03a4\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6"+
		"\u03a8\3\2\2\2\u03a7\u03a3\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03a7\3\2"+
		"\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03ab\3\2\2\2\u03ab\u03ac\5\36\20\2\u03ac"+
		"\u046a\3\2\2\2\u03ad\u03b1\7d\2\2\u03ae\u03af\7\63\2\2\u03af\u03b0\7\u00d0"+
		"\2\2\u03b0\u03b2\7,\2\2\u03b1\u03ae\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2"+
		"\u03b8\3\2\2\2\u03b3\u03b9\7|\2\2\u03b4\u03b6\7\6\2\2\u03b5\u03b7\7Z\2"+
		"\2\u03b6\u03b5\3\2\2\2\u03b6\u03b7\3\2\2\2\u03b7\u03b9\3\2\2\2\u03b8\u03b3"+
		"\3\2\2\2\u03b8\u03b4\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba\u03bb\7\u00cf\2"+
		"\2\u03bb\u03bc\7-\2\2\u03bc\u03c1\7\u00e4\2\2\u03bd\u03bf\5\u0082B\2\u03be"+
		"\u03c0\7\u0135\2\2\u03bf\u03be\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03c2"+
		"\3\2\2\2\u03c1\u03bd\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c1\3\2\2\2\u03c3"+
		"\u03c4\3\2\2\2\u03c4\u03c5\3\2\2\2\u03c5\u03c6\5\36\20\2\u03c6\u046a\3"+
		"\2\2\2\u03c7\u03cb\7d\2\2\u03c8\u03c9\7\63\2\2\u03c9\u03ca\7\u00d0\2\2"+
		"\u03ca\u03cc\7,\2\2\u03cb\u03c8\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cc\u03d2"+
		"\3\2\2\2\u03cd\u03d3\7)\2\2\u03ce\u03d0\7\6\2\2\u03cf\u03d1\7Z\2\2\u03d0"+
		"\u03cf\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03d3\3\2\2\2\u03d2\u03cd\3\2"+
		"\2\2\u03d2\u03ce\3\2\2\2\u03d3\u03d4\3\2\2\2\u03d4\u03d7\7\u00cf\2\2\u03d5"+
		"\u03d8\5\64\33\2\u03d6\u03d8\5\66\34\2\u03d7\u03d5\3\2\2\2\u03d7\u03d6"+
		"\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9\u03da\5\36\20\2\u03da\u046a\3\2\2\2"+
		"\u03db\u03df\7d\2\2\u03dc\u03dd\7\63\2\2\u03dd\u03de\7\u00d0\2\2\u03de"+
		"\u03e0\7,\2\2\u03df\u03dc\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0\u03e6\3\2"+
		"\2\2\u03e1\u03e7\7|\2\2\u03e2\u03e4\7\6\2\2\u03e3\u03e5\7Z\2\2\u03e4\u03e3"+
		"\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5\u03e7\3\2\2\2\u03e6\u03e1\3\2\2\2\u03e6"+
		"\u03e2\3\2\2\2\u03e7\u03e8\3\2\2\2\u03e8\u03e9\7\u00cf\2\2\u03e9\u03ee"+
		"\7\u00ba\2\2\u03ea\u03ec\5\u0082B\2\u03eb\u03ed\7\u0135\2\2\u03ec\u03eb"+
		"\3\2\2\2\u03ec\u03ed\3\2\2\2\u03ed\u03ef\3\2\2\2\u03ee\u03ea\3\2\2\2\u03ef"+
		"\u03f0\3\2\2\2\u03f0\u03ee\3\2\2\2\u03f0\u03f1\3\2\2\2\u03f1\u03f2\3\2"+
		"\2\2\u03f2\u03f3\5\36\20\2\u03f3\u046a\3\2\2\2\u03f4\u03f8\7d\2\2\u03f5"+
		"\u03f6\7\63\2\2\u03f6\u03f7\7\u00d0\2\2\u03f7\u03f9\7,\2\2\u03f8\u03f5"+
		"\3\2\2\2\u03f8\u03f9\3\2\2\2\u03f9\u0407\3\2\2\2\u03fa\u0400\7j\2\2\u03fb"+
		"\u03fd\7{\2\2\u03fc\u03fe\7\u0135\2\2\u03fd\u03fc\3\2\2\2\u03fd\u03fe"+
		"\3\2\2\2\u03fe\u0400\3\2\2\2\u03ff\u03fa\3\2\2\2\u03ff\u03fb\3\2\2\2\u0400"+
		"\u0401\3\2\2\2\u0401\u03ff\3\2\2\2\u0401\u0402\3\2\2\2\u0402\u0408\3\2"+
		"\2\2\u0403\u0405\7\6\2\2\u0404\u0406\7Z\2\2\u0405\u0404\3\2\2\2\u0405"+
		"\u0406\3\2\2\2\u0406\u0408\3\2\2\2\u0407\u03ff\3\2\2\2\u0407\u0403\3\2"+
		"\2\2\u0408\u0409\3\2\2\2\u0409\u040a\7\u00cf\2\2\u040a\u040b\7\u00bb\2"+
		"\2\u040b\u0410\7\u00ce\2\2\u040c\u040e\5\u0082B\2\u040d\u040f\7\u0135"+
		"\2\2\u040e\u040d\3\2\2\2\u040e\u040f\3\2\2\2\u040f\u0411\3\2\2\2\u0410"+
		"\u040c\3\2\2\2\u0411\u0412\3\2\2\2\u0412\u0410\3\2\2\2\u0412\u0413\3\2"+
		"\2\2\u0413\u0414\3\2\2\2\u0414\u0415\5\36\20\2\u0415\u046a\3\2\2\2\u0416"+
		"\u041a\7d\2\2\u0417\u0418\7\63\2\2\u0418\u0419\7\u00d0\2\2\u0419\u041b"+
		"\7,\2\2\u041a\u0417\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u0428\3\2\2\2\u041c"+
		"\u041e\t\b\2\2\u041d\u041f\7\u0135\2\2\u041e\u041d\3\2\2\2\u041e\u041f"+
		"\3\2\2\2\u041f\u0421\3\2\2\2\u0420\u041c\3\2\2\2\u0421\u0422\3\2\2\2\u0422"+
		"\u0420\3\2\2\2\u0422\u0423\3\2\2\2\u0423\u0429\3\2\2\2\u0424\u0426\7\6"+
		"\2\2\u0425\u0427\7Z\2\2\u0426\u0425\3\2\2\2\u0426\u0427\3\2\2\2\u0427"+
		"\u0429\3\2\2\2\u0428\u0420\3\2\2\2\u0428\u0424\3\2\2\2\u0429\u042a\3\2"+
		"\2\2\u042a\u042b\7\u00cf\2\2\u042b\u0430\7g\2\2\u042c\u042e\5\u0082B\2"+
		"\u042d\u042f\7\u0135\2\2\u042e\u042d\3\2\2\2\u042e\u042f\3\2\2\2\u042f"+
		"\u0431\3\2\2\2\u0430\u042c\3\2\2\2\u0431\u0432\3\2\2\2\u0432\u0430\3\2"+
		"\2\2\u0432\u0433\3\2\2\2\u0433\u0434\3\2\2\2\u0434\u0435\5\36\20\2\u0435"+
		"\u046a\3\2\2\2\u0436\u043a\7d\2\2\u0437\u0438\7\63\2\2\u0438\u0439\7\u00d0"+
		"\2\2\u0439\u043b\7,\2\2\u043a\u0437\3\2\2\2\u043a\u043b\3\2\2\2\u043b"+
		"\u0441\3\2\2\2\u043c\u0442\7\30\2\2\u043d\u043f\7\6\2\2\u043e\u0440\7"+
		"Z\2\2\u043f\u043e\3\2\2\2\u043f\u0440\3\2\2\2\u0440\u0442\3\2\2\2\u0441"+
		"\u043c\3\2\2\2\u0441\u043d\3\2\2\2\u0442\u0443\3\2\2\2\u0443\u0444\7\u00cf"+
		"\2\2\u0444\u0449\7\u00ef\2\2\u0445\u0447\5\u0082B\2\u0446\u0448\7\u0135"+
		"\2\2\u0447\u0446\3\2\2\2\u0447\u0448\3\2\2\2\u0448\u044a\3\2\2\2\u0449"+
		"\u0445\3\2\2\2\u044a\u044b\3\2\2\2\u044b\u0449\3\2\2\2\u044b\u044c\3\2"+
		"\2\2\u044c\u044d\3\2\2\2\u044d\u044e\5\36\20\2\u044e\u046a\3\2\2\2\u044f"+
		"\u0453\7d\2\2\u0450\u0451\7\u0084\2\2\u0451\u0452\7\u00d0\2\2\u0452\u0454"+
		"\7,\2\2\u0453\u0450\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u0459\3\2\2\2\u0455"+
		"\u0457\5\u0082B\2\u0456\u0458\7\u0135\2\2\u0457\u0456\3\2\2\2\u0457\u0458"+
		"\3\2\2\2\u0458\u045a\3\2\2\2\u0459\u0455\3\2\2\2\u045a\u045b\3\2\2\2\u045b"+
		"\u0459\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u045d\3\2\2\2\u045d\u0462\7\61"+
		"\2\2\u045e\u0460\5\u0082B\2\u045f\u0461\7\u0135\2\2\u0460\u045f\3\2\2"+
		"\2\u0460\u0461\3\2\2\2\u0461\u0463\3\2\2\2\u0462\u045e\3\2\2\2\u0463\u0464"+
		"\3\2\2\2\u0464\u0462\3\2\2\2\u0464\u0465\3\2\2\2\u0465\u0467\3\2\2\2\u0466"+
		"\u0468\t\t\2\2\u0467\u0466\3\2\2\2\u0467\u0468\3\2\2\2\u0468\u046a\3\2"+
		"\2\2\u0469\u02ee\3\2\2\2\u0469\u0315\3\2\2\2\u0469\u034a\3\2\2\2\u0469"+
		"\u0375\3\2\2\2\u0469\u0392\3\2\2\2\u0469\u03ad\3\2\2\2\u0469\u03c7\3\2"+
		"\2\2\u0469\u03db\3\2\2\2\u0469\u03f4\3\2\2\2\u0469\u0416\3\2\2\2\u0469"+
		"\u0436\3\2\2\2\u0469\u044f\3\2\2\2\u046a\35\3\2\2\2\u046b\u0474\7\61\2"+
		"\2\u046c\u046e\7\64\2\2\u046d\u046c\3\2\2\2\u046d\u046e\3\2\2\2\u046e"+
		"\u046f\3\2\2\2\u046f\u0475\5\u0082B\2\u0470\u0472\7\u00d8\2\2\u0471\u0473"+
		"\7\u0135\2\2\u0472\u0471\3\2\2\2\u0472\u0473\3\2\2\2\u0473\u0475\3\2\2"+
		"\2\u0474\u046d\3\2\2\2\u0474\u0470\3\2\2\2\u0475\u0476\3\2\2\2\u0476\u0474"+
		"\3\2\2\2\u0476\u0477\3\2\2\2\u0477\u0479\3\2\2\2\u0478\u047a\t\t\2\2\u0479"+
		"\u0478\3\2\2\2\u0479\u047a\3\2\2\2\u047a\37\3\2\2\2\u047b\u0485\7\63\2"+
		"\2\u047c\u047e\t\4\2\2\u047d\u047c\3\2\2\2\u047e\u047f\3\2\2\2\u047f\u047d"+
		"\3\2\2\2\u047f\u0480\3\2\2\2\u0480\u0486\3\2\2\2\u0481\u0483\7\6\2\2\u0482"+
		"\u0484\7Z\2\2\u0483\u0482\3\2\2\2\u0483\u0484\3\2\2\2\u0484\u0486\3\2"+
		"\2\2\u0485\u047d\3\2\2\2\u0485\u0481\3\2\2\2\u0486\u0487\3\2\2\2\u0487"+
		"\u049f\7\u00cf\2\2\u0488\u048a\7q\2\2\u0489\u0488\3\2\2\2\u0489\u048a"+
		"\3\2\2\2\u048a\u048f\3\2\2\2\u048b\u048d\5\u017e\u00c0\2\u048c\u048e\7"+
		"\u0135\2\2\u048d\u048c\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u0490\3\2\2\2"+
		"\u048f\u048b\3\2\2\2\u0490\u0491\3\2\2\2\u0491\u048f\3\2\2\2\u0491\u0492"+
		"\3\2\2\2\u0492\u04a0\3\2\2\2\u0493\u0494\7\6\2\2\u0494\u0495\7\u00f0\2"+
		"\2\u0495\u0496\7:\2\2\u0496\u049b\7g\2\2\u0497\u0499\5\u0082B\2\u0498"+
		"\u049a\7\u0135\2\2\u0499\u0498\3\2\2\2\u0499\u049a\3\2\2\2\u049a\u049c"+
		"\3\2\2\2\u049b\u0497\3\2\2\2\u049c\u049d\3\2\2\2\u049d\u049b\3\2\2\2\u049d"+
		"\u049e\3\2\2\2\u049e\u04a0\3\2\2\2\u049f\u0489\3\2\2\2\u049f\u0493\3\2"+
		"\2\2\u04a0\u04a1\3\2\2\2\u04a1\u04a2\5\"\22\2\u04a2\u05c1\3\2\2\2\u04a3"+
		"\u04bd\7\63\2\2\u04a4\u04a9\t\5\2\2\u04a5\u04a7\5\u0082B\2\u04a6\u04a8"+
		"\7\u0135\2\2\u04a7\u04a6\3\2\2\2\u04a7\u04a8\3\2\2\2\u04a8\u04aa\3\2\2"+
		"\2\u04a9\u04a5\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab\u04a9\3\2\2\2\u04ab\u04ac"+
		"\3\2\2\2\u04ac\u04ae\3\2\2\2\u04ad\u04a4\3\2\2\2\u04ae\u04af\3\2\2\2\u04af"+
		"\u04ad\3\2\2\2\u04af\u04b0\3\2\2\2\u04b0\u04be\3\2\2\2\u04b1\u04b3\7\6"+
		"\2\2\u04b2\u04b4\7Z\2\2\u04b3\u04b2\3\2\2\2\u04b3\u04b4\3\2\2\2\u04b4"+
		"\u04b9\3\2\2\2\u04b5\u04b7\5\u0082B\2\u04b6\u04b8\7\u0135\2\2\u04b7\u04b6"+
		"\3\2\2\2\u04b7\u04b8\3\2\2\2\u04b8\u04ba\3\2\2\2\u04b9\u04b5\3\2\2\2\u04ba"+
		"\u04bb\3\2\2\2\u04bb\u04b9\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc\u04be\3\2"+
		"\2\2\u04bd\u04ad\3\2\2\2\u04bd\u04b1\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf"+
		"\u04c7\7\u00cf\2\2\u04c0\u04c2\7q\2\2\u04c1\u04c0\3\2\2\2\u04c1\u04c2"+
		"\3\2\2\2\u04c2\u04c3\3\2\2\2\u04c3\u04c5\5\u017e\u00c0\2\u04c4\u04c6\7"+
		"\u0135\2\2\u04c5\u04c4\3\2\2\2\u04c5\u04c6\3\2\2\2\u04c6\u04c8\3\2\2\2"+
		"\u04c7\u04c1\3\2\2\2\u04c8\u04c9\3\2\2\2\u04c9\u04c7\3\2\2\2\u04c9\u04ca"+
		"\3\2\2\2\u04ca\u04cb\3\2\2\2\u04cb\u04cc\5\"\22\2\u04cc\u05c1\3\2\2\2"+
		"\u04cd\u04da\7\63\2\2\u04ce\u04d0\t\6\2\2\u04cf\u04d1\7\u0135\2\2\u04d0"+
		"\u04cf\3\2\2\2\u04d0\u04d1\3\2\2\2\u04d1\u04d3\3\2\2\2\u04d2\u04ce\3\2"+
		"\2\2\u04d3\u04d4\3\2\2\2\u04d4\u04d2\3\2\2\2\u04d4\u04d5\3\2\2\2\u04d5"+
		"\u04db\3\2\2\2\u04d6\u04d8\7\6\2\2\u04d7\u04d9\7Z\2\2\u04d8\u04d7\3\2"+
		"\2\2\u04d8\u04d9\3\2\2\2\u04d9\u04db\3\2\2\2\u04da\u04d2\3\2\2\2\u04da"+
		"\u04d6\3\2\2\2\u04db\u04dc\3\2\2\2\u04dc\u04f2\7\u00cf\2\2\u04dd\u04de"+
		"\7h\2\2\u04de\u04e0\5\u0082B\2\u04df\u04e1\7\u0135\2\2\u04e0\u04df\3\2"+
		"\2\2\u04e0\u04e1\3\2\2\2\u04e1\u04e3\3\2\2\2\u04e2\u04dd\3\2\2\2\u04e3"+
		"\u04e4\3\2\2\2\u04e4\u04e2\3\2\2\2\u04e4\u04e5\3\2\2\2\u04e5\u04f3\3\2"+
		"\2\2\u04e6\u04e7\7\6\2\2\u04e7\u04e8\7i\2\2\u04e8\u04e9\7:\2\2\u04e9\u04ee"+
		"\7g\2\2\u04ea\u04ec\5\u0082B\2\u04eb\u04ed\7\u0135\2\2\u04ec\u04eb\3\2"+
		"\2\2\u04ec\u04ed\3\2\2\2\u04ed\u04ef\3\2\2\2\u04ee\u04ea\3\2\2\2\u04ef"+
		"\u04f0\3\2\2\2\u04f0\u04ee\3\2\2\2\u04f0\u04f1\3\2\2\2\u04f1\u04f3\3\2"+
		"\2\2\u04f2\u04e2\3\2\2\2\u04f2\u04e6\3\2\2\2\u04f3\u04f4\3\2\2\2\u04f4"+
		"\u04f5\5\"\22\2\u04f5\u05c1\3\2\2\2\u04f6\u0503\7\63\2\2\u04f7\u04f9\t"+
		"\7\2\2\u04f8\u04fa\7\u0135\2\2\u04f9\u04f8\3\2\2\2\u04f9\u04fa\3\2\2\2"+
		"\u04fa\u04fc\3\2\2\2\u04fb\u04f7\3\2\2\2\u04fc\u04fd\3\2\2\2\u04fd\u04fb"+
		"\3\2\2\2\u04fd\u04fe\3\2\2\2\u04fe\u0504\3\2\2\2\u04ff\u0501\7\6\2\2\u0500"+
		"\u0502\7Z\2\2\u0501\u0500\3\2\2\2\u0501\u0502\3\2\2\2\u0502\u0504\3\2"+
		"\2\2\u0503\u04fb\3\2\2\2\u0503\u04ff\3\2\2\2\u0504\u0505\3\2\2\2\u0505"+
		"\u0506\7\u00cf\2\2\u0506\u050b\7\32\2\2\u0507\u0509\5\u0082B\2\u0508\u050a"+
		"\7\u0135\2\2\u0509\u0508\3\2\2\2\u0509\u050a\3\2\2\2\u050a\u050c\3\2\2"+
		"\2\u050b\u0507\3\2\2\2\u050c\u050d\3\2\2\2\u050d\u050b\3\2\2\2\u050d\u050e"+
		"\3\2\2\2\u050e\u050f\3\2\2\2\u050f\u0510\5\"\22\2\u0510\u05c1\3\2\2\2"+
		"\u0511\u0517\7\63\2\2\u0512\u0518\7|\2\2\u0513\u0515\7\6\2\2\u0514\u0516"+
		"\7Z\2\2\u0515\u0514\3\2\2\2\u0515\u0516\3\2\2\2\u0516\u0518\3\2\2\2\u0517"+
		"\u0512\3\2\2\2\u0517\u0513\3\2\2\2\u0518\u0519\3\2\2\2\u0519\u051a\7\u00cf"+
		"\2\2\u051a\u051b\7-\2\2\u051b\u051c\7\u009a\2\2\u051c\u0521\7\u0103\2"+
		"\2\u051d\u051f\5\u0082B\2\u051e\u0520\7\u0135\2\2\u051f\u051e\3\2\2\2"+
		"\u051f\u0520\3\2\2\2\u0520\u0522\3\2\2\2\u0521\u051d\3\2\2\2\u0522\u0523"+
		"\3\2\2\2\u0523\u0521\3\2\2\2\u0523\u0524\3\2\2\2\u0524\u0525\3\2\2\2\u0525"+
		"\u0526\5\"\22\2\u0526\u05c1\3\2\2\2\u0527\u052d\7\63\2\2\u0528\u052e\7"+
		"|\2\2\u0529\u052b\7\6\2\2\u052a\u052c\7Z\2\2\u052b\u052a\3\2\2\2\u052b"+
		"\u052c\3\2\2\2\u052c\u052e\3\2\2\2\u052d\u0528\3\2\2\2\u052d\u0529\3\2"+
		"\2\2\u052e\u052f\3\2\2\2\u052f\u0530\7\u00cf\2\2\u0530\u0531\7-\2\2\u0531"+
		"\u0536\7\u00e4\2\2\u0532\u0534\5\u0082B\2\u0533\u0535\7\u0135\2\2\u0534"+
		"\u0533\3\2\2\2\u0534\u0535\3\2\2\2\u0535\u0537\3\2\2\2\u0536\u0532\3\2"+
		"\2\2\u0537\u0538\3\2\2\2\u0538\u0536\3\2\2\2\u0538\u0539\3\2\2\2\u0539"+
		"\u053a\3\2\2\2\u053a\u053b\5\"\22\2\u053b\u05c1\3\2\2\2\u053c\u0542\7"+
		"\63\2\2\u053d\u0543\7)\2\2\u053e\u0540\7\6\2\2\u053f\u0541\7Z\2\2\u0540"+
		"\u053f\3\2\2\2\u0540\u0541\3\2\2\2\u0541\u0543\3\2\2\2\u0542\u053d\3\2"+
		"\2\2\u0542\u053e\3\2\2\2\u0543\u0544\3\2\2\2\u0544\u0547\7\u00cf\2\2\u0545"+
		"\u0548\5\64\33\2\u0546\u0548\5\66\34\2\u0547\u0545\3\2\2\2\u0547\u0546"+
		"\3\2\2\2\u0548\u0549\3\2\2\2\u0549\u054a\5\"\22\2\u054a\u05c1\3\2\2\2"+
		"\u054b\u0551\7\63\2\2\u054c\u0552\7|\2\2\u054d\u054f\7\6\2\2\u054e\u0550"+
		"\7Z\2\2\u054f\u054e\3\2\2\2\u054f\u0550\3\2\2\2\u0550\u0552\3\2\2\2\u0551"+
		"\u054c\3\2\2\2\u0551\u054d\3\2\2\2\u0552\u0553\3\2\2\2\u0553\u0554\7\u00cf"+
		"\2\2\u0554\u0559\7\u00ba\2\2\u0555\u0557\5\u0082B\2\u0556\u0558\7\u0135"+
		"\2\2\u0557\u0556\3\2\2\2\u0557\u0558\3\2\2\2\u0558\u055a\3\2\2\2\u0559"+
		"\u0555\3\2\2\2\u055a\u055b\3\2\2\2\u055b\u0559\3\2\2\2\u055b\u055c\3\2"+
		"\2\2\u055c\u055d\3\2\2\2\u055d\u055e\5\"\22\2\u055e\u05c1\3\2\2\2\u055f"+
		"\u056c\7\63\2\2\u0560\u0562\t\n\2\2\u0561\u0563\7\u0135\2\2\u0562\u0561"+
		"\3\2\2\2\u0562\u0563\3\2\2\2\u0563\u0565\3\2\2\2\u0564\u0560\3\2\2\2\u0565"+
		"\u0566\3\2\2\2\u0566\u0564\3\2\2\2\u0566\u0567\3\2\2\2\u0567\u056d\3\2"+
		"\2\2\u0568\u056a\7\6\2\2\u0569\u056b\7Z\2\2\u056a\u0569\3\2\2\2\u056a"+
		"\u056b\3\2\2\2\u056b\u056d\3\2\2\2\u056c\u0564\3\2\2\2\u056c\u0568\3\2"+
		"\2\2\u056d\u056e\3\2\2\2\u056e\u056f\7\u00cf\2\2\u056f\u0570\7\u00bb\2"+
		"\2\u0570\u0575\7\u00ce\2\2\u0571\u0573\5\u0082B\2\u0572\u0574\7\u0135"+
		"\2\2\u0573\u0572\3\2\2\2\u0573\u0574\3\2\2\2\u0574\u0576\3\2\2\2\u0575"+
		"\u0571\3\2\2\2\u0576\u0577\3\2\2\2\u0577\u0575\3\2\2\2\u0577\u0578\3\2"+
		"\2\2\u0578\u0579\3\2\2\2\u0579\u057a\5\"\22\2\u057a\u05c1\3\2\2\2\u057b"+
		"\u0588\7\63\2\2\u057c\u057e\t\b\2\2\u057d\u057f\7\u0135\2\2\u057e\u057d"+
		"\3\2\2\2\u057e\u057f\3\2\2\2\u057f\u0581\3\2\2\2\u0580\u057c\3\2\2\2\u0581"+
		"\u0582\3\2\2\2\u0582\u0580\3\2\2\2\u0582\u0583\3\2\2\2\u0583\u0589\3\2"+
		"\2\2\u0584\u0586\7\6\2\2\u0585\u0587\7Z\2\2\u0586\u0585\3\2\2\2\u0586"+
		"\u0587\3\2\2\2\u0587\u0589\3\2\2\2\u0588\u0580\3\2\2\2\u0588\u0584\3\2"+
		"\2\2\u0589\u058a\3\2\2\2\u058a\u058b\7\u00cf\2\2\u058b\u0590\7g\2\2\u058c"+
		"\u058e\5\u0082B\2\u058d\u058f\7\u0135\2\2\u058e\u058d\3\2\2\2\u058e\u058f"+
		"\3\2\2\2\u058f\u0591\3\2\2\2\u0590\u058c\3\2\2\2\u0591\u0592\3\2\2\2\u0592"+
		"\u0590\3\2\2\2\u0592\u0593\3\2\2\2\u0593\u0594\3\2\2\2\u0594\u0595\5\""+
		"\22\2\u0595\u05c1\3\2\2\2\u0596\u059c\7\63\2\2\u0597\u059d\7\30\2\2\u0598"+
		"\u059a\7\6\2\2\u0599\u059b\7Z\2\2\u059a\u0599\3\2\2\2\u059a\u059b\3\2"+
		"\2\2\u059b\u059d\3\2\2\2\u059c\u0597\3\2\2\2\u059c\u0598\3\2\2\2\u059d"+
		"\u059e\3\2\2\2\u059e\u059f\7\u00cf\2\2\u059f\u05a4\7\u00ef\2\2\u05a0\u05a2"+
		"\5\u0082B\2\u05a1\u05a3\7\u0135\2\2\u05a2\u05a1\3\2\2\2\u05a2\u05a3\3"+
		"\2\2\2\u05a3\u05a5\3\2\2\2\u05a4\u05a0\3\2\2\2\u05a5\u05a6\3\2\2\2\u05a6"+
		"\u05a4\3\2\2\2\u05a6\u05a7\3\2\2\2\u05a7\u05a8\3\2\2\2\u05a8\u05a9\5\""+
		"\22\2\u05a9\u05ae\7\63\2\2\u05aa\u05ac\5\u0082B\2\u05ab\u05ad\7\u0135"+
		"\2\2\u05ac\u05ab\3\2\2\2\u05ac\u05ad\3\2\2\2\u05ad\u05af\3\2\2\2\u05ae"+
		"\u05aa\3\2\2\2\u05af\u05b0\3\2\2\2\u05b0\u05ae\3\2\2\2\u05b0\u05b1\3\2"+
		"\2\2\u05b1\u05b2\3\2\2\2\u05b2\u05b7\7\u00f7\2\2\u05b3\u05b5\5\u0082B"+
		"\2\u05b4\u05b6\7\u0135\2\2\u05b5\u05b4\3\2\2\2\u05b5\u05b6\3\2\2\2\u05b6"+
		"\u05b8\3\2\2\2\u05b7\u05b3\3\2\2\2\u05b8\u05b9\3\2\2\2\u05b9\u05b7\3\2"+
		"\2\2\u05b9\u05ba\3\2\2\2\u05ba\u05be\3\2\2\2\u05bb\u05bc\7\u0082\2\2\u05bc"+
		"\u05bd\7\u0084\2\2\u05bd\u05bf\7\u00d0\2\2\u05be\u05bb\3\2\2\2\u05be\u05bf"+
		"\3\2\2\2\u05bf\u05c1\3\2\2\2\u05c0\u047b\3\2\2\2\u05c0\u04a3\3\2\2\2\u05c0"+
		"\u04cd\3\2\2\2\u05c0\u04f6\3\2\2\2\u05c0\u0511\3\2\2\2\u05c0\u0527\3\2"+
		"\2\2\u05c0\u053c\3\2\2\2\u05c0\u054b\3\2\2\2\u05c0\u055f\3\2\2\2\u05c0"+
		"\u057b\3\2\2\2\u05c0\u0596\3\2\2\2\u05c1!\3\2\2\2\u05c2\u05cd\7\u00f7"+
		"\2\2\u05c3\u05c5\7\64\2\2\u05c4\u05c3\3\2\2\2\u05c4\u05c5\3\2\2\2\u05c5"+
		"\u05c8\3\2\2\2\u05c6\u05c9\5\u0082B\2\u05c7\u05c9\7\u00d8\2\2\u05c8\u05c6"+
		"\3\2\2\2\u05c8\u05c7\3\2\2\2\u05c9\u05cb\3\2\2\2\u05ca\u05cc\7\u0135\2"+
		"\2\u05cb\u05ca\3\2\2\2\u05cb\u05cc\3\2\2\2\u05cc\u05ce\3\2\2\2\u05cd\u05c4"+
		"\3\2\2\2\u05ce\u05cf\3\2\2\2\u05cf\u05cd\3\2\2\2\u05cf\u05d0\3\2\2\2\u05d0"+
		"\u05d4\3\2\2\2\u05d1\u05d2\7\u0082\2\2\u05d2\u05d3\7\63\2\2\u05d3\u05d5"+
		"\7\u00d0\2\2\u05d4\u05d1\3\2\2\2\u05d4\u05d5\3\2\2\2\u05d5#\3\2\2\2\u05d6"+
		"\u05d7\7\u0091\2\2\u05d7\u064e\7\u00cf\2\2\u05d8\u05d9\7\3\2\2\u05d9\u05da"+
		"\5\u017e\u00c0\2\u05da\u05e1\7\u013c\2\2\u05db\u05dd\5\u0094K\2\u05dc"+
		"\u05de\7\u0135\2\2\u05dd\u05dc\3\2\2\2\u05dd\u05de\3\2\2\2\u05de\u05e0"+
		"\3\2\2\2\u05df\u05db\3\2\2\2\u05e0\u05e3\3\2\2\2\u05e1\u05df\3\2\2\2\u05e1"+
		"\u05e2\3\2\2\2\u05e2\u05e4\3\2\2\2\u05e3\u05e1\3\2\2\2\u05e4\u05e5\7\u013d"+
		"\2\2\u05e5\u064f\3\2\2\2\u05e6\u05e7\7\21\2\2\u05e7\u05e8\7\u013c\2\2"+
		"\u05e8\u05e9\5\u0094K\2\u05e9\u05ea\7\5\2\2\u05ea\u05eb\5\u0094K\2\u05eb"+
		"\u05ec\7\u013d\2\2\u05ec\u064f\3\2\2\2\u05ed\u05ee\7\23\2\2\u05ee\u064f"+
		"\5\u017e\u00c0\2\u05ef\u05f0\7\u0090\2\2\u05f0\u064f\5\u017e\u00c0\2\u05f1"+
		"\u05f2\7\25\2\2\u05f2\u05f3\5\u017e\u00c0\2\u05f3\u05f4\7\u00cf\2\2\u05f4"+
		"\u05f5\5\u017e\u00c0\2\u05f5\u064f\3\2\2\2\u05f6\u05f7\7\27\2\2\u05f7"+
		"\u064f\5\u017e\u00c0\2\u05f8\u05f9\7\32\2\2\u05f9\u064f\5\u017e\u00c0"+
		"\2\u05fa\u05fb\7\"\2\2\u05fb\u064f\5\u017e\u00c0\2\u05fc\u05fd\7*\2\2"+
		"\u05fd\u064f\5\u017e\u00c0\2\u05fe\u05ff\7-\2\2\u05ff\u0600\7\u009a\2"+
		"\2\u0600\u0601\7\u0103\2\2\u0601\u064f\5\u017e\u00c0\2\u0602\u0603\7-"+
		"\2\2\u0603\u0604\7q\2\2\u0604\u064f\5\u017e\u00c0\2\u0605\u064f\5\64\33"+
		"\2\u0606\u0607\7\u00b0\2\2\u0607\u064f\5\u017e\u00c0\2\u0608\u0609\7\u00bb"+
		"\2\2\u0609\u060a\7\u00ce\2\2\u060a\u064f\5\u0082B\2\u060b\u060c\7S\2\2"+
		"\u060c\u060d\5\u017e\u00c0\2\u060d\u060e\7\u013c\2\2\u060e\u060f\5\u0094"+
		"K\2\u060f\u0610\7\u0135\2\2\u0610\u0611\5\u0094K\2\u0611\u0612\7\u013d"+
		"\2\2\u0612\u064f\3\2\2\2\u0613\u0614\7S\2\2\u0614\u0615\7\u008a\2\2\u0615"+
		"\u0616\5\u017e\u00c0\2\u0616\u0617\7}\2\2\u0617\u0618\5\u0082B\2\u0618"+
		"\u064f\3\2\2\2\u0619\u061a\7S\2\2\u061a\u061b\7\u00a8\2\2\u061b\u061c"+
		"\5\u017e\u00c0\2\u061c\u061d\7}\2\2\u061d\u061e\5\u0082B\2\u061e\u064f"+
		"\3\2\2\2\u061f\u0621\7\\\2\2\u0620\u061f\3\2\2\2\u0620\u0621\3\2\2\2\u0621"+
		"\u0622\3\2\2\2\u0622\u0623\7\u00ba\2\2\u0623\u064f\5\u017e\u00c0\2\u0624"+
		"\u0625\7]\2\2\u0625\u064f\5\u017e\u00c0\2\u0626\u0627\7f\2\2\u0627\u0628"+
		"\5\u017e\u00c0\2\u0628\u0629\7\u00cf\2\2\u0629\u062a\5\u017e\u00c0\2\u062a"+
		"\u064f\3\2\2\2\u062b\u062c\7g\2\2\u062c\u064f\5\u017e\u00c0\2\u062d\u062e"+
		"\7h\2\2\u062e\u064f\5\u017e\u00c0\2\u062f\u0630\7\u00e4\2\2\u0630\u064f"+
		"\5\u017e\u00c0\2\u0631\u0632\7q\2\2\u0632\u064f\5\u017e\u00c0\2\u0633"+
		"\u0634\7\u00ef\2\2\u0634\u064f\5\u017e\u00c0\2\u0635\u0636\7\u0124\2\2"+
		"\u0636\u0637\7\u00e1\2\2\u0637\u0638\7\u0094\2\2\u0638\u064f\5\u017e\u00c0"+
		"\2\u0639\u063a\7\u0124\2\2\u063a\u063b\7\u00e1\2\2\u063b\u063c\7\u009f"+
		"\2\2\u063c\u064f\5\u017e\u00c0\2\u063d\u063e\7\u0124\2\2\u063e\u063f\7"+
		"\u00e1\2\2\u063f\u0640\7\u00d3\2\2\u0640\u064f\5\u017e\u00c0\2\u0641\u0642"+
		"\7\u0124\2\2\u0642\u0643\7\u00e1\2\2\u0643\u0644\7\u00f1\2\2\u0644\u064f"+
		"\5\u017e\u00c0\2\u0645\u0646\7v\2\2\u0646\u0647\5\u017e\u00c0\2\u0647"+
		"\u0648\7\u00cf\2\2\u0648\u0649\5\u017e\u00c0\2\u0649\u064f\3\2\2\2\u064a"+
		"\u064b\7\u00f8\2\2\u064b\u064f\5\u017e\u00c0\2\u064c\u064d\7\177\2\2\u064d"+
		"\u064f\5\u017e\u00c0\2\u064e\u05d8\3\2\2\2\u064e\u05e6\3\2\2\2\u064e\u05ed"+
		"\3\2\2\2\u064e\u05ef\3\2\2\2\u064e\u05f1\3\2\2\2\u064e\u05f6\3\2\2\2\u064e"+
		"\u05f8\3\2\2\2\u064e\u05fa\3\2\2\2\u064e\u05fc\3\2\2\2\u064e\u05fe\3\2"+
		"\2\2\u064e\u0602\3\2\2\2\u064e\u0605\3\2\2\2\u064e\u0606\3\2\2\2\u064e"+
		"\u0608\3\2\2\2\u064e\u060b\3\2\2\2\u064e\u0613\3\2\2\2\u064e\u0619\3\2"+
		"\2\2\u064e\u0620\3\2\2\2\u064e\u0624\3\2\2\2\u064e\u0626\3\2\2\2\u064e"+
		"\u062b\3\2\2\2\u064e\u062d\3\2\2\2\u064e\u062f\3\2\2\2\u064e\u0631\3\2"+
		"\2\2\u064e\u0633\3\2\2\2\u064e\u0635\3\2\2\2\u064e\u0639\3\2\2\2\u064e"+
		"\u063d\3\2\2\2\u064e\u0641\3\2\2\2\u064e\u0645\3\2\2\2\u064e\u064a\3\2"+
		"\2\2\u064e\u064c\3\2\2\2\u064f\u0650\3\2\2\2\u0650\u0651\7D\2\2\u0651"+
		"\u0652\7\u0150\2\2\u0652%\3\2\2\2\u0653\u0656\7\30\2\2\u0654\u0655\7T"+
		"\2\2\u0655\u0657\7a\2\2\u0656\u0654\3\2\2\2\u0656\u0657\3\2\2\2\u0657"+
		"\u0658\3\2\2\2\u0658\u0659\7/\2\2\u0659\u065a\5\u017e\u00c0\2\u065a\u066b"+
		"\5(\25\2\u065b\u065c\7c\2\2\u065c\u066c\5\u0094K\2\u065d\u065e\7c\2\2"+
		"\u065e\u065f\7q\2\2\u065f\u0665\7\u013c\2\2\u0660\u0661\5\u0082B\2\u0661"+
		"\u0663\5\u0094K\2\u0662\u0664\7\u0135\2\2\u0663\u0662\3\2\2\2\u0663\u0664"+
		"\3\2\2\2\u0664\u0666\3\2\2\2\u0665\u0660\3\2\2\2\u0666\u0667\3\2\2\2\u0667"+
		"\u0665\3\2\2\2\u0667\u0668\3\2\2\2\u0668\u0669\3\2\2\2\u0669\u066a\7\u013d"+
		"\2\2\u066a\u066c\3\2\2\2\u066b\u065b\3\2\2\2\u066b\u065d\3\2\2\2\u066b"+
		"\u066c\3\2\2\2\u066c\u06a2\3\2\2\2\u066d\u066e\7\u00ba\2\2\u066e\u06a3"+
		"\5\u0082B\2\u066f\u06a3\7\u0102\2\2\u0670\u06a3\79\2\2\u0671\u06a3\7\u00e8"+
		"\2\2\u0672\u06a3\7\u0100\2\2\u0673\u0674\7\u0089\2\2\u0674\u0675\7\u00cf"+
		"\2\2\u0675\u0676\7N\2\2\u0676\u06a3\7\u00b3\2\2\u0677\u0678\7c\2\2\u0678"+
		"\u0679\7N\2\2\u0679\u067a\7\u00cf\2\2\u067a\u067b\7N\2\2\u067b\u06a3\7"+
		"\u00b3\2\2\u067c\u06a3\7o\2\2\u067d\u067f\7\u00a6\2\2\u067e\u067d\3\2"+
		"\2\2\u067e\u067f\3\2\2\2\u067f\u0680\3\2\2\2\u0680\u0681\7\u00e3\2\2\u0681"+
		"\u06a3\7C\2\2\u0682\u0684\7\u00a6\2\2\u0683\u0682\3\2\2\2\u0683\u0684"+
		"\3\2\2\2\u0684\u0685\3\2\2\2\u0685\u0686\7\u00e3\2\2\u0686\u06a3\7\u009e"+
		"\2\2\u0687\u0688\7\u0095\2\2\u0688\u06a3\7\u014b\2\2\u0689\u068a\7_\2"+
		"\2\u068a\u06a3\7\u014b\2\2\u068b\u068c\7\u00e5\2\2\u068c\u0693\5\u0082"+
		"B\2\u068d\u068e\7\u00f7\2\2\u068e\u0694\5\u0082B\2\u068f\u0690\7\u0132"+
		"\2\2\u0690\u0694\5\u0082B\2\u0691\u0692\7\61\2\2\u0692\u0694\7\u0098\2"+
		"\2\u0693\u068d\3\2\2\2\u0693\u068f\3\2\2\2\u0693\u0691\3\2\2\2\u0694\u0699"+
		"\3\2\2\2\u0695\u0696\7\u0135\2\2\u0696\u0698\5\u0082B\2\u0697\u0695\3"+
		"\2\2\2\u0698\u069b\3\2\2\2\u0699\u0697\3\2\2\2\u0699\u069a\3\2\2\2\u069a"+
		"\u06a3\3\2\2\2\u069b\u0699\3\2\2\2\u069c\u069d\7\5\2\2\u069d\u06a3\5*"+
		"\26\2\u069e\u069f\7\5\2\2\u069f\u06a0\7\u0150\2\2\u06a0\u06a1\7\u0135"+
		"\2\2\u06a1\u06a3\7\u0150\2\2\u06a2\u066d\3\2\2\2\u06a2\u066f\3\2\2\2\u06a2"+
		"\u0670\3\2\2\2\u06a2\u0671\3\2\2\2\u06a2\u0672\3\2\2\2\u06a2\u0673\3\2"+
		"\2\2\u06a2\u0677\3\2\2\2\u06a2\u067c\3\2\2\2\u06a2\u067e\3\2\2\2\u06a2"+
		"\u0683\3\2\2\2\u06a2\u0687\3\2\2\2\u06a2\u0689\3\2\2\2\u06a2\u068b\3\2"+
		"\2\2\u06a2\u069c\3\2\2\2\u06a2\u069e\3\2\2\2\u06a3\u06a4\3\2\2\2\u06a4"+
		"\u06a2\3\2\2\2\u06a4\u06a5\3\2\2\2\u06a5\u06b2\3\2\2\2\u06a6\u06a7\7\u0082"+
		"\2\2\u06a7\u06ac\7\u013c\2\2\u06a8\u06aa\5\60\31\2\u06a9\u06ab\7\u0135"+
		"\2\2\u06aa\u06a9\3\2\2\2\u06aa\u06ab\3\2\2\2\u06ab\u06ad\3\2\2\2\u06ac"+
		"\u06a8\3\2\2\2\u06ad\u06ae\3\2\2\2\u06ae\u06ac\3\2\2\2\u06ae\u06af\3\2"+
		"\2\2\u06af\u06b0\3\2\2\2\u06b0\u06b1\7\u013d\2\2\u06b1\u06b3\3\2\2\2\u06b2"+
		"\u06a6\3\2\2\2\u06b2\u06b3\3\2\2\2\u06b3\'\3\2\2\2\u06b4\u06c6\7\u013c"+
		"\2\2\u06b5\u06b7\5\62\32\2\u06b6\u06b5\3\2\2\2\u06b6\u06b7\3\2\2\2\u06b7"+
		"\u06b9\3\2\2\2\u06b8\u06ba\5\u0082B\2\u06b9\u06b8\3\2\2\2\u06b9\u06ba"+
		"\3\2\2\2\u06ba\u06bb\3\2\2\2\u06bb\u06bf\5\u0094K\2\u06bc\u06c0\7\33\2"+
		"\2\u06bd\u06be\7\u0132\2\2\u06be\u06c0\5\u00e4s\2\u06bf\u06bc\3\2\2\2"+
		"\u06bf\u06bd\3\2\2\2\u06bf\u06c0\3\2\2\2\u06c0\u06c2\3\2\2\2\u06c1\u06c3"+
		"\7\u0135\2\2\u06c2\u06c1\3\2\2\2\u06c2\u06c3\3\2\2\2\u06c3\u06c5\3\2\2"+
		"\2\u06c4\u06b6\3\2\2\2\u06c5\u06c8\3\2\2\2\u06c6\u06c4\3\2\2\2\u06c6\u06c7"+
		"\3\2\2\2\u06c7\u06c9\3\2\2\2\u06c8\u06c6\3\2\2\2\u06c9\u06ca\7\u013d\2"+
		"\2\u06ca)\3\2\2\2\u06cb\u06ce\5,\27\2\u06cc\u06ce\5.\30\2\u06cd\u06cb"+
		"\3\2\2\2\u06cd\u06cc\3\2\2\2\u06ce+\3\2\2\2\u06cf\u06d3\7\u0149\2\2\u06d0"+
		"\u06d2\n\13\2\2\u06d1\u06d0\3\2\2\2\u06d2\u06d5\3\2\2\2\u06d3\u06d1\3"+
		"\2\2\2\u06d3\u06d4\3\2\2\2\u06d4\u06d6\3\2\2\2\u06d5\u06d3\3\2\2\2\u06d6"+
		"\u06d7\7\u0149\2\2\u06d7-\3\2\2\2\u06d8\u06dc\7\u014a\2\2\u06d9\u06db"+
		"\n\f\2\2\u06da\u06d9\3\2\2\2\u06db\u06de\3\2\2\2\u06dc\u06da\3\2\2\2\u06dc"+
		"\u06dd\3\2\2\2\u06dd\u06df\3\2\2\2\u06de\u06dc\3\2\2\2\u06df\u06e0\7\u014a"+
		"\2\2\u06e0/\3\2\2\2\u06e1\u06e2\t\r\2\2\u06e2\61\3\2\2\2\u06e3\u06e4\t"+
		"\16\2\2\u06e4\63\3\2\2\2\u06e5\u06e6\7/\2\2\u06e6\u06e7\5\u0082B\2\u06e7"+
		"\u06f7\7\u013c\2\2\u06e8\u06ea\5\62\32\2\u06e9\u06e8\3\2\2\2\u06e9\u06ea"+
		"\3\2\2\2\u06ea\u06ec\3\2\2\2\u06eb\u06ed\5\u0082B\2\u06ec\u06eb\3\2\2"+
		"\2\u06ec\u06ed\3\2\2\2\u06ed\u06f0\3\2\2\2\u06ee\u06f1\5\u0094K\2\u06ef"+
		"\u06f1\5\u00e4s\2\u06f0\u06ee\3\2\2\2\u06f0\u06ef\3\2\2\2\u06f1\u06f3"+
		"\3\2\2\2\u06f2\u06f4\7\u0135\2\2\u06f3\u06f2\3\2\2\2\u06f3\u06f4\3\2\2"+
		"\2\u06f4\u06f6\3\2\2\2\u06f5\u06e9\3\2\2\2\u06f6\u06f9\3\2\2\2\u06f7\u06f5"+
		"\3\2\2\2\u06f7\u06f8\3\2\2\2\u06f8\u06fa\3\2\2\2\u06f9\u06f7\3\2\2\2\u06fa"+
		"\u06fb\7\u013d\2\2\u06fb\65\3\2\2\2\u06fc\u06fd\7\6\2\2\u06fd\u06fe\7"+
		"\60\2\2\u06fe\u06ff\7:\2\2\u06ff\u0704\7g\2\2\u0700\u0702\5\u0082B\2\u0701"+
		"\u0703\7\u0135\2\2\u0702\u0701\3\2\2\2\u0702\u0703\3\2\2\2\u0703\u0705"+
		"\3\2\2\2\u0704\u0700\3\2\2\2\u0705\u0706\3\2\2\2\u0706\u0704\3\2\2\2\u0706"+
		"\u0707\3\2\2\2\u0707\67\3\2\2\2\u0708\u070a\7\30\2\2\u0709\u070b\t\17"+
		"\2\2\u070a\u0709\3\2\2\2\u070a\u070b\3\2\2\2\u070b\u070c\3\2\2\2\u070c"+
		"\u070d\7h\2\2\u070d\u0732\5\u017e\u00c0\2\u070e\u0710\7\u00b2\2\2\u070f"+
		"\u0711\7\u0087\2\2\u0710\u070f\3\2\2\2\u0710\u0711\3\2\2\2\u0711\u0712"+
		"\3\2\2\2\u0712\u0731\7\u014b\2\2\u0713\u0714\7\u00c7\2\2\u0714\u0718\7"+
		"\u014b\2\2\u0715\u0716\7\u00cb\2\2\u0716\u0718\7\u00c7\2\2\u0717\u0713"+
		"\3\2\2\2\u0717\u0715\3\2\2\2\u0718\u0731\3\2\2\2\u0719\u071a\7\u00c2\2"+
		"\2\u071a\u071e\5\u00a4S\2\u071b\u071c\7\u00cb\2\2\u071c\u071e\7\u00c2"+
		"\2\2\u071d\u0719\3\2\2\2\u071d\u071b\3\2\2\2\u071e\u0731\3\2\2\2\u071f"+
		"\u0721\7\u00e9\2\2\u0720\u0722\7\u0082\2\2\u0721\u0720\3\2\2\2\u0721\u0722"+
		"\3\2\2\2\u0722\u0723\3\2\2\2\u0723\u0731\7\u014b\2\2\u0724\u0725\7\u0088"+
		"\2\2\u0725\u0731\7\u014b\2\2\u0726\u0728\7\u00cb\2\2\u0727\u0726\3\2\2"+
		"\2\u0727\u0728\3\2\2\2\u0728\u0729\3\2\2\2\u0729\u0731\7\u0099\2\2\u072a"+
		"\u072b\7V\2\2\u072b\u072e\7\u0087\2\2\u072c\u072f\5\u017e\u00c0\2\u072d"+
		"\u072f\7\u00cc\2\2\u072e\u072c\3\2\2\2\u072e\u072d\3\2\2\2\u072f\u0731"+
		"\3\2\2\2\u0730\u070e\3\2\2\2\u0730\u0717\3\2\2\2\u0730\u071d\3\2\2\2\u0730"+
		"\u071f\3\2\2\2\u0730\u0724\3\2\2\2\u0730\u0727\3\2\2\2\u0730\u072a\3\2"+
		"\2\2\u0731\u0734\3\2\2\2\u0732\u0730\3\2\2\2\u0732\u0733\3\2\2\2\u0733"+
		"9\3\2\2\2\u0734\u0732\3\2\2\2\u0735\u0736\7\30\2\2\u0736\u0737\7g\2\2"+
		"\u0737\u073a\5\u0082B\2\u0738\u0739\7\f\2\2\u0739\u073b\5\u0082B\2\u073a"+
		"\u0738\3\2\2\2\u073a\u073b\3\2\2\2\u073b\u073f\3\2\2\2\u073c\u073e\5\2"+
		"\2\2\u073d\u073c\3\2\2\2\u073e\u0741\3\2\2\2\u073f\u073d\3\2\2\2\u073f"+
		"\u0740\3\2\2\2\u0740\u075e\3\2\2\2\u0741\u073f\3\2\2\2\u0742\u0743\7\30"+
		"\2\2\u0743\u0744\7g\2\2\u0744\u0745\7\f\2\2\u0745\u0749\5\u0082B\2\u0746"+
		"\u0748\5\2\2\2\u0747\u0746\3\2\2\2\u0748\u074b\3\2\2\2\u0749\u0747\3\2"+
		"\2\2\u0749\u074a\3\2\2\2\u074a\u075e\3\2\2\2\u074b\u0749\3\2\2\2\u074c"+
		"\u074d\7\30\2\2\u074d\u074e\7g\2\2\u074e\u074f\7\66\2\2\u074f\u0750\7"+
		"M\2\2\u0750\u0751\7\u00a5\2\2\u0751\u0754\5\u0082B\2\u0752\u0753\7\f\2"+
		"\2\u0753\u0755\5\u0082B\2\u0754\u0752\3\2\2\2\u0754\u0755\3\2\2\2\u0755"+
		"\u075e\3\2\2\2\u0756\u0757\7\30\2\2\u0757\u0758\7g\2\2\u0758\u0759\7\66"+
		"\2\2\u0759\u075a\7M\2\2\u075a\u075b\7\u00a5\2\2\u075b\u075c\7\f\2\2\u075c"+
		"\u075e\5\u0082B\2\u075d\u0735\3\2\2\2\u075d\u0742\3\2\2\2\u075d\u074c"+
		"\3\2\2\2\u075d\u0756\3\2\2\2\u075e;\3\2\2\2\u075f\u0762\7\30\2\2\u0760"+
		"\u0761\7T\2\2\u0761\u0763\7a\2\2\u0762\u0760\3\2\2\2\u0762\u0763\3\2\2"+
		"\2\u0763\u0765\3\2\2\2\u0764\u0766\t\17\2\2\u0765\u0764\3\2\2\2\u0765"+
		"\u0766\3\2\2\2\u0766\u0767\3\2\2\2\u0767\u0768\7\177\2\2\u0768\u076f\5"+
		"\u017e\u00c0\2\u0769\u076b\5\u0082B\2\u076a\u076c\7\u0135\2\2\u076b\u076a"+
		"\3\2\2\2\u076b\u076c\3\2\2\2\u076c\u076e\3\2\2\2\u076d\u0769\3\2\2\2\u076e"+
		"\u0771\3\2\2\2\u076f\u076d\3\2\2\2\u076f\u0770\3\2\2\2\u0770\u077f\3\2"+
		"\2\2\u0771\u076f\3\2\2\2\u0772\u0773\7\u0082\2\2\u0773\u0779\7\u013c\2"+
		"\2\u0774\u0777\5\u0082B\2\u0775\u0776\7\u0132\2\2\u0776\u0778\5\u0082"+
		"B\2\u0777\u0775\3\2\2\2\u0777\u0778\3\2\2\2\u0778\u077a\3\2\2\2\u0779"+
		"\u0774\3\2\2\2\u077a\u077b\3\2\2\2\u077b\u0779\3\2\2\2\u077b\u077c\3\2"+
		"\2\2\u077c\u077d\3\2\2\2\u077d\u077e\7\u013d\2\2\u077e\u0780\3\2\2\2\u077f"+
		"\u0772\3\2\2\2\u077f\u0780\3\2\2\2\u0780\u0781\3\2\2\2\u0781\u0782\7\5"+
		"\2\2\u0782\u0783\5\u0180\u00c1\2\u0783=\3\2\2\2\u0784\u0785\3\2\2\2\u0785"+
		"?\3\2\2\2\u0786\u078c\7\30\2\2\u0787\u0789\t\20\2\2\u0788\u0787\3\2\2"+
		"\2\u0788\u0789\3\2\2\2\u0789\u078a\3\2\2\2\u078a\u078d\t\17\2\2\u078b"+
		"\u078d\7\u00fa\2\2\u078c\u0788\3\2\2\2\u078c\u078b\3\2\2\2\u078c\u078d"+
		"\3\2\2\2\u078d\u078e\3\2\2\2\u078e\u0792\7q\2\2\u078f\u0790\7\66\2\2\u0790"+
		"\u0791\7M\2\2\u0791\u0793\7\u00a5\2\2\u0792\u078f\3\2\2\2\u0792\u0793"+
		"\3\2\2\2\u0793\u0794\3\2\2\2\u0794\u0795\5\u017e\u00c0\2\u0795\u07b4\7"+
		"\u013c\2\2\u0796\u0797\5\u0082B\2\u0797\u079a\5\u0094K\2\u0798\u0799\7"+
		"\22\2\2\u0799\u079b\5\u0082B\2\u079a\u0798\3\2\2\2\u079a\u079b\3\2\2\2"+
		"\u079b\u079f\3\2\2\2\u079c\u079e\5F$\2\u079d\u079c\3\2\2\2\u079e\u07a1"+
		"\3\2\2\2\u079f\u079d\3\2\2\2\u079f\u07a0\3\2\2\2\u07a0\u07ac\3\2\2\2\u07a1"+
		"\u079f\3\2\2\2\u07a2\u07ac\5D#\2\u07a3\u07a4\7I\2\2\u07a4\u07a8\5\u0082"+
		"B\2\u07a5\u07a7\5B\"\2\u07a6\u07a5\3\2\2\2\u07a7\u07aa\3\2\2\2\u07a8\u07a6"+
		"\3\2\2\2\u07a8\u07a9\3\2\2\2\u07a9\u07ac\3\2\2\2\u07aa\u07a8\3\2\2\2\u07ab"+
		"\u0796\3\2\2\2\u07ab\u07a2\3\2\2\2\u07ab\u07a3\3\2\2\2\u07ac\u07ae\3\2"+
		"\2\2\u07ad\u07af\7\u0135\2\2\u07ae\u07ad\3\2\2\2\u07ae\u07af\3\2\2\2\u07af"+
		"\u07b1\3\2\2\2\u07b0\u07ab\3\2\2\2\u07b1\u07b2\3\2\2\2\u07b2\u07b0\3\2"+
		"\2\2\u07b2\u07b3\3\2\2\2\u07b3\u07b5\3\2\2\2\u07b4\u07b0\3\2\2\2\u07b4"+
		"\u07b5\3\2\2\2\u07b5\u07b6\3\2\2\2\u07b6\u07c3\7\u013d\2\2\u07b7\u07b8"+
		"\7<\2\2\u07b8\u07bd\7\u013c\2\2\u07b9\u07bb\5\u0082B\2\u07ba\u07bc\7\u0135"+
		"\2\2\u07bb\u07ba\3\2\2\2\u07bb\u07bc\3\2\2\2\u07bc\u07be\3\2\2\2\u07bd"+
		"\u07b9\3\2\2\2\u07be\u07bf\3\2\2\2\u07bf\u07bd\3\2\2\2\u07bf\u07c0\3\2"+
		"\2\2\u07c0\u07c1\3\2\2\2\u07c1\u07c2\7\u013d\2\2\u07c2\u07c4\3\2\2\2\u07c3"+
		"\u07b7\3\2\2\2\u07c3\u07c4\3\2\2\2\u07c4\u07c5\3\2\2\2\u07c5\u07c6\5L"+
		"\'\2\u07c6\u07c7\5N(\2\u07c7\u07c8\5P)\2\u07c8\u07f7\3\2\2\2\u07c9\u07cf"+
		"\7\30\2\2\u07ca\u07cc\t\20\2\2\u07cb\u07ca\3\2\2\2\u07cb\u07cc\3\2\2\2"+
		"\u07cc\u07cd\3\2\2\2\u07cd\u07d0\t\17\2\2\u07ce\u07d0\7\u00fa\2\2\u07cf"+
		"\u07cb\3\2\2\2\u07cf\u07ce\3\2\2\2\u07cf\u07d0\3\2\2\2\u07d0\u07d1\3\2"+
		"\2\2\u07d1\u07d5\7q\2\2\u07d2\u07d3\7\66\2\2\u07d3\u07d4\7M\2\2\u07d4"+
		"\u07d6\7\u00a5\2\2\u07d5\u07d2\3\2\2\2\u07d5\u07d6\3\2\2\2\u07d6\u07d7"+
		"\3\2\2\2\u07d7\u07d8\5\u017e\u00c0\2\u07d8\u07d9\7O\2\2\u07d9\u07f0\5"+
		"\u0082B\2\u07da\u07ea\7\u013c\2\2\u07db\u07dc\5\u0082B\2\u07dc\u07dd\7"+
		"\u0082\2\2\u07dd\u07e1\7\u00d1\2\2\u07de\u07e0\5F$\2\u07df\u07de\3\2\2"+
		"\2\u07e0\u07e3\3\2\2\2\u07e1\u07df\3\2\2\2\u07e1\u07e2\3\2\2\2\u07e2\u07e6"+
		"\3\2\2\2\u07e3\u07e1\3\2\2\2\u07e4\u07e6\5D#\2\u07e5\u07db\3\2\2\2\u07e5"+
		"\u07e4\3\2\2\2\u07e6\u07e8\3\2\2\2\u07e7\u07e9\7\u0135\2\2\u07e8\u07e7"+
		"\3\2\2\2\u07e8\u07e9\3\2\2\2\u07e9\u07eb\3\2\2\2\u07ea\u07e5\3\2\2\2\u07eb"+
		"\u07ec\3\2\2\2\u07ec\u07ea\3\2\2\2\u07ec\u07ed\3\2\2\2\u07ed\u07ee\3\2"+
		"\2\2\u07ee\u07ef\7\u013d\2\2\u07ef\u07f1\3\2\2\2\u07f0\u07da\3\2\2\2\u07f0"+
		"\u07f1\3\2\2\2\u07f1\u07f2\3\2\2\2\u07f2\u07f3\5L\'\2\u07f3\u07f4\5N("+
		"\2\u07f4\u07f5\5P)\2\u07f5\u07f7\3\2\2\2\u07f6\u0786\3\2\2\2\u07f6\u07c9"+
		"\3\2\2\2\u07f7A\3\2\2\2\u07f8\u07f9\t\21\2\2\u07f9\u07fa\t\22\2\2\u07fa"+
		"C\3\2\2\2\u07fb\u07fc\7\25\2\2\u07fc\u07fe\5\u0082B\2\u07fd\u07fb\3\2"+
		"\2\2\u07fd\u07fe\3\2\2\2\u07fe\u0861\3\2\2\2\u07ff\u0862\5H%\2\u0800\u0801"+
		"\7z\2\2\u0801\u0806\7\u013c\2\2\u0802\u0804\5\u0082B\2\u0803\u0805\7\u0135"+
		"\2\2\u0804\u0803\3\2\2\2\u0804\u0805\3\2\2\2\u0805\u0807\3\2\2\2\u0806"+
		"\u0802\3\2\2\2\u0807\u0808\3\2\2\2\u0808\u0806\3\2\2\2\u0808\u0809\3\2"+
		"\2\2\u0809\u080a\3\2\2\2\u080a\u080b\7\u013d\2\2\u080b\u080c\5T+\2\u080c"+
		"\u0862\3\2\2\2\u080d\u080e\7Y\2\2\u080e\u080f\7F\2\2\u080f\u0814\7\u013c"+
		"\2\2\u0810\u0812\5\u0082B\2\u0811\u0813\7\u0135\2\2\u0812\u0811\3\2\2"+
		"\2\u0812\u0813\3\2\2\2\u0813\u0815\3\2\2\2\u0814\u0810\3\2\2\2\u0815\u0816"+
		"\3\2\2\2\u0816\u0814\3\2\2\2\u0816\u0817\3\2\2\2\u0817\u0818\3\2\2\2\u0818"+
		"\u0819\7\u013d\2\2\u0819\u081a\5T+\2\u081a\u0862\3\2\2\2\u081b\u081e\7"+
		"\'\2\2\u081c\u081d\7}\2\2\u081d\u081f\5\u0082B\2\u081e\u081c\3\2\2\2\u081e"+
		"\u081f\3\2\2\2\u081f\u0820\3\2\2\2\u0820\u0821\7\u013c\2\2\u0821\u0822"+
		"\5\u0082B\2\u0822\u0827\7\u0082\2\2\u0823\u0825\5\u0082B\2\u0824\u0826"+
		"\7\u0135\2\2\u0825\u0824\3\2\2\2\u0825\u0826\3\2\2\2\u0826\u0828\3\2\2"+
		"\2\u0827\u0823\3\2\2\2\u0828\u0829\3\2\2\2\u0829\u0827\3\2\2\2\u0829\u082a"+
		"\3\2\2\2\u082a\u082b\3\2\2\2\u082b\u082c\7\u013d\2\2\u082c\u0832\5T+\2"+
		"\u082d\u082e\7\u0081\2\2\u082e\u082f\7\u013c\2\2\u082f\u0830\5\u0082B"+
		"\2\u0830\u0831\7\u013d\2\2\u0831\u0833\3\2\2\2\u0832\u082d\3\2\2\2\u0832"+
		"\u0833\3\2\2\2\u0833\u0862\3\2\2\2\u0834\u0835\7-\2\2\u0835\u0836\7F\2"+
		"\2\u0836\u083b\7\u013c\2\2\u0837\u0839\5\u0082B\2\u0838\u083a\7\u0135"+
		"\2\2\u0839\u0838\3\2\2\2\u0839\u083a\3\2\2\2\u083a\u083c\3\2\2\2\u083b"+
		"\u0837\3\2\2\2\u083c\u083d\3\2\2\2\u083d\u083b\3\2\2\2\u083d\u083e\3\2"+
		"\2\2\u083e\u083f\3\2\2\2\u083f\u0840\7\u013d\2\2\u0840\u0841\7`\2\2\u0841"+
		"\u084d\5\u0082B\2\u0842\u0847\7\u013c\2\2\u0843\u0845\5\u0082B\2\u0844"+
		"\u0846\7\u0135\2\2\u0845\u0844\3\2\2\2\u0845\u0846\3\2\2\2\u0846\u0848"+
		"\3\2\2\2\u0847\u0843\3\2\2\2\u0848\u0849\3\2\2\2\u0849\u0847\3\2\2\2\u0849"+
		"\u084a\3\2\2\2\u084a\u084b\3\2\2\2\u084b\u084c\7\u013d\2\2\u084c\u084e"+
		"\3\2\2\2\u084d\u0842\3\2\2\2\u084d\u084e\3\2\2\2\u084e\u0855\3\2\2\2\u084f"+
		"\u0850\7\u00c0\2";
	private static final String _serializedATNSegment1 =
		"\2\u0850\u0856\7.\2\2\u0851\u0852\7\u00c0\2\2\u0852\u0856\7\u00d4\2\2"+
		"\u0853\u0854\7\u00c0\2\2\u0854\u0856\7\u00e7\2\2\u0855\u084f\3\2\2\2\u0855"+
		"\u0851\3\2\2\2\u0855\u0853\3\2\2\2\u0855\u0856\3\2\2\2\u0856\u085a\3\2"+
		"\2\2\u0857\u0858\7\u00cf\2\2\u0858\u0859\7\37\2\2\u0859\u085b\5R*\2\u085a"+
		"\u0857\3\2\2\2\u085a\u085b\3\2\2\2\u085b\u085f\3\2\2\2\u085c\u085d\7\u00cf"+
		"\2\2\u085d\u085e\7{\2\2\u085e\u0860\5R*\2\u085f\u085c\3\2\2\2\u085f\u0860"+
		"\3\2\2\2\u0860\u0862\3\2\2\2\u0861\u07ff\3\2\2\2\u0861\u0800\3\2\2\2\u0861"+
		"\u080d\3\2\2\2\u0861\u081b\3\2\2\2\u0861\u0834\3\2\2\2\u0862\u0866\3\2"+
		"\2\2\u0863\u0867\7\35\2\2\u0864\u0865\7M\2\2\u0865\u0867\7\35\2\2\u0866"+
		"\u0863\3\2\2\2\u0866\u0864\3\2\2\2\u0866\u0867\3\2\2\2\u0867\u086c\3\2"+
		"\2\2\u0868\u0869\7=\2\2\u0869\u086d\7\36\2\2\u086a\u086b\7=\2\2\u086b"+
		"\u086d\78\2\2\u086c\u0868\3\2\2\2\u086c\u086a\3\2\2\2\u086c\u086d\3\2"+
		"\2\2\u086dE\3\2\2\2\u086e\u086f\7\25\2\2\u086f\u0871\5\u0082B\2\u0870"+
		"\u086e\3\2\2\2\u0870\u0871\3\2\2\2\u0871\u0895\3\2\2\2\u0872\u0873\7M"+
		"\2\2\u0873\u0896\7N\2\2\u0874\u0896\7N\2\2\u0875\u0896\5H%\2\u0876\u0879"+
		"\7\33\2\2\u0877\u087a\5\u0094K\2\u0878\u087a\5\u00e4s\2\u0879\u0877\3"+
		"\2\2\2\u0879\u0878\3\2\2\2\u087a\u0896\3\2\2\2\u087b\u087c\7z\2\2\u087c"+
		"\u0896\5T+\2\u087d\u087e\7Y\2\2\u087e\u087f\7F\2\2\u087f\u0896\5T+\2\u0880"+
		"\u0881\7`\2\2\u0881\u0882\5\u017e\u00c0\2\u0882\u0889\5\u0082B\2\u0883"+
		"\u0884\7\u00c0\2\2\u0884\u088a\7.\2\2\u0885\u0886\7\u00c0\2\2\u0886\u088a"+
		"\7\u00d4\2\2\u0887\u0888\7\u00c0\2\2\u0888\u088a\7\u00e7\2\2\u0889\u0883"+
		"\3\2\2\2\u0889\u0885\3\2\2\2\u0889\u0887\3\2\2\2\u0889\u088a\3\2\2\2\u088a"+
		"\u088e\3\2\2\2\u088b\u088c\7\u00cf\2\2\u088c\u088d\7\37\2\2\u088d\u088f"+
		"\5R*\2\u088e\u088b\3\2\2\2\u088e\u088f\3\2\2\2\u088f\u0893\3\2\2\2\u0890"+
		"\u0891\7\u00cf\2\2\u0891\u0892\7{\2\2\u0892\u0894\5R*\2\u0893\u0890\3"+
		"\2\2\2\u0893\u0894\3\2\2\2\u0894\u0896\3\2\2\2\u0895\u0872\3\2\2\2\u0895"+
		"\u0874\3\2\2\2\u0895\u0875\3\2\2\2\u0895\u0876\3\2\2\2\u0895\u087b\3\2"+
		"\2\2\u0895\u087d\3\2\2\2\u0895\u0880\3\2\2\2\u0896\u089a\3\2\2\2\u0897"+
		"\u089b\7\35\2\2\u0898\u0899\7M\2\2\u0899\u089b\7\35\2\2\u089a\u0897\3"+
		"\2\2\2\u089a\u0898\3\2\2\2\u089a\u089b\3\2\2\2\u089b\u08a0\3\2\2\2\u089c"+
		"\u089d\7=\2\2\u089d\u08a1\7\36\2\2\u089e\u089f\7=\2\2\u089f\u08a1\78\2"+
		"\2\u08a0\u089c\3\2\2\2\u08a0\u089e\3\2\2\2\u08a0\u08a1\3\2\2\2\u08a1G"+
		"\3\2\2\2\u08a2\u08a3\7\u008d\2\2\u08a3\u08a4\7\u013c\2\2\u08a4\u08a5\5"+
		"\u010e\u0088\2\u08a5\u08a6\7\u013d\2\2\u08a6I\3\2\2\2\u08a7\u08a8\7\u0082"+
		"\2\2\u08a8\u08b1\7\u013c\2\2\u08a9\u08ac\5\u0082B\2\u08aa\u08ab\7\u0132"+
		"\2\2\u08ab\u08ad\5\u0082B\2\u08ac\u08aa\3\2\2\2\u08ac\u08ad\3\2\2\2\u08ad"+
		"\u08af\3\2\2\2\u08ae\u08b0\7\u0135\2\2\u08af\u08ae\3\2\2\2\u08af\u08b0"+
		"\3\2\2\2\u08b0\u08b2\3\2\2\2\u08b1\u08a9\3\2\2\2\u08b2\u08b3\3\2\2\2\u08b3"+
		"\u08b1\3\2\2\2\u08b3\u08b4\3\2\2\2\u08b4\u08b5\3\2\2\2\u08b5\u08b6\7\u013d"+
		"\2\2\u08b6K\3\2\2\2\u08b7\u08bd\5J&\2\u08b8\u08b9\7\u0082\2\2\u08b9\u08bd"+
		"\7P\2\2\u08ba\u08bb\7\u0083\2\2\u08bb\u08bd\7P\2\2\u08bc\u08b7\3\2\2\2"+
		"\u08bc\u08b8\3\2\2\2\u08bc\u08ba\3\2\2\2\u08bc\u08bd\3\2\2\2\u08bdM\3"+
		"\2\2\2\u08be\u08bf\7\u00cf\2\2\u08bf\u08c5\7\u0093\2\2\u08c0\u08c1\7X"+
		"\2\2\u08c1\u08c6\7_\2\2\u08c2\u08c3\7\37\2\2\u08c3\u08c6\7_\2\2\u08c4"+
		"\u08c6\7\u00a2\2\2\u08c5\u08c0\3\2\2\2\u08c5\u08c2\3\2\2\2\u08c5\u08c4"+
		"\3\2\2\2\u08c6\u08c8\3\2\2\2\u08c7\u08be\3\2\2\2\u08c7\u08c8\3\2\2\2\u08c8"+
		"O\3\2\2\2\u08c9\u08ca\7\u00ef\2\2\u08ca\u08cc\5\u0082B\2\u08cb\u08c9\3"+
		"\2\2\2\u08cb\u08cc\3\2\2\2\u08ccQ\3\2\2\2\u08cd\u08d4\7b\2\2\u08ce\u08d4"+
		"\7\20\2\2\u08cf\u08d0\7\u00e5\2\2\u08d0\u08d4\7N\2\2\u08d1\u08d2\7\u00e5"+
		"\2\2\u08d2\u08d4\7\33\2\2\u08d3\u08cd\3\2\2\2\u08d3\u08ce\3\2\2\2\u08d3"+
		"\u08cf\3\2\2\2\u08d3\u08d1\3\2\2\2\u08d4S\3\2\2\2\u08d5\u08d7\5J&\2\u08d6"+
		"\u08d5\3\2\2\2\u08d6\u08d7\3\2\2\2\u08d7\u08dc\3\2\2\2\u08d8\u08d9\7}"+
		"\2\2\u08d9\u08da\7\u00b0\2\2\u08da\u08db\7\u00ef\2\2\u08db\u08dd\5\u0082"+
		"B\2\u08dc\u08d8\3\2\2\2\u08dc\u08dd\3\2\2\2\u08ddU\3\2\2\2\u08de\u08df"+
		"\7\u013c\2\2\u08df\u08e4\5X-\2\u08e0\u08e1\7\u0135\2\2\u08e1\u08e3\5X"+
		"-\2\u08e2\u08e0\3\2\2\2\u08e3\u08e6\3\2\2\2\u08e4\u08e2\3\2\2\2\u08e4"+
		"\u08e5\3\2\2\2\u08e5\u08e7\3\2\2\2\u08e6\u08e4\3\2\2\2\u08e7\u08e8\7\u013d"+
		"\2\2\u08e8W\3\2\2\2\u08e9\u08ea\5\u0082B\2\u08ea\u08eb\5Z.\2\u08ebY\3"+
		"\2\2\2\u08ec\u08ed\5\u0094K\2\u08ed[\3\2\2\2\u08ee\u08ef\7\u0082\2\2\u08ef"+
		"\u08f0\7\u013c\2\2\u08f0\u08f5\5^\60\2\u08f1\u08f2\7\u0135\2\2\u08f2\u08f4"+
		"\5^\60\2\u08f3\u08f1\3\2\2\2\u08f4\u08f7\3\2\2\2\u08f5\u08f3\3\2\2\2\u08f5"+
		"\u08f6\3\2\2\2\u08f6\u08f8\3\2\2\2\u08f7\u08f5\3\2\2\2\u08f8\u08f9\7\u013d"+
		"\2\2\u08f9]\3\2\2\2\u08fa\u08fb\7\u0150\2\2\u08fb\u08fc\7\u0132\2\2\u08fc"+
		"\u08fd\5\u00e8u\2\u08fd_\3\2\2\2\u08fe\u08ff\7}\2\2\u08ff\u0900\5\u0082"+
		"B\2\u0900a\3\2\2\2\u0901\u0902\7\u00ef\2\2\u0902\u0903\5d\63\2\u0903c"+
		"\3\2\2\2\u0904\u0905\5\u0082B\2\u0905e\3\2\2\2\u0906\u090b\5h\65\2\u0907"+
		"\u090b\5n8\2\u0908\u090b\5v<\2\u0909\u090b\5|?\2\u090a\u0906\3\2\2\2\u090a"+
		"\u0907\3\2\2\2\u090a\u0908\3\2\2\2\u090a\u0909\3\2\2\2\u090bg\3\2\2\2"+
		"\u090c\u090d\7\u00d5\2\2\u090d\u090e\7\u0087\2\2\u090e\u090f\7\u00db\2"+
		"\2\u090f\u0910\7\u013c\2\2\u0910\u0911\5\u0190\u00c9\2\u0911\u0912\7\u013d"+
		"\2\2\u0912\u0913\7\u013c\2\2\u0913\u0914\5j\66\2\u0914\u0915\7\u013d\2"+
		"\2\u0915i\3\2\2\2\u0916\u091b\5l\67\2\u0917\u0918\7\u0135\2\2\u0918\u091a"+
		"\5l\67\2\u0919\u0917\3\2\2\2\u091a\u091d\3\2\2\2\u091b\u0919\3\2\2\2\u091b"+
		"\u091c\3\2\2\2\u091ck\3\2\2\2\u091d\u091b\3\2\2\2\u091e\u091f\7\u00d5"+
		"\2\2\u091f\u0920\5~@\2\u0920\u0921\7\u00fb\2\2\u0921\u0922\7\u00bd\2\2"+
		"\u0922\u092e\7\u00f2\2\2\u0923\u0924\7\u013c\2\2\u0924\u0925\5\u00e4s"+
		"\2\u0925\u0926\7\u013d\2\2\u0926\u092f\3\2\2\2\u0927\u0929\7\u013c\2\2"+
		"\u0928\u0927\3\2\2\2\u0928\u0929\3\2\2\2\u0929\u092a\3\2\2\2\u092a\u092c"+
		"\7\u00c2\2\2\u092b\u092d\7\u013d\2\2\u092c\u092b\3\2\2\2\u092c\u092d\3"+
		"\2\2\2\u092d\u092f\3\2\2\2\u092e\u0923\3\2\2\2\u092e\u0928\3\2\2\2\u092f"+
		"m\3\2\2\2\u0930\u0931\7\u00d5\2\2\u0931\u0932\7\u0087\2\2\u0932\u0933"+
		"\7\u00ae\2\2\u0933\u0934\7\u013c\2\2\u0934\u0935\5\u0190\u00c9\2\u0935"+
		"\u093b\7\u013d\2\2\u0936\u0937\7\u013c\2\2\u0937\u0938\5p9\2\u0938\u0939"+
		"\7\u013d\2\2\u0939\u093c\3\2\2\2\u093a\u093c\5t;\2\u093b\u0936\3\2\2\2"+
		"\u093b\u093a\3\2\2\2\u093co\3\2\2\2\u093d\u0942\5r:\2\u093e\u093f\7\u0135"+
		"\2\2\u093f\u0941\5r:\2\u0940\u093e\3\2\2\2\u0941\u0944\3\2\2\2\u0942\u0940"+
		"\3\2\2\2\u0942\u0943\3\2\2\2\u0943q\3\2\2\2\u0944\u0942\3\2\2\2\u0945"+
		"\u0946\7\u00d5\2\2\u0946\u0947\5~@\2\u0947s\3\2\2\2\u0948\u0949\7\u00d6"+
		"\2\2\u0949\u094a\5\u00e8u\2\u094au\3\2\2\2\u094b\u094c\7\u00d5\2\2\u094c"+
		"\u094d\7\u0087\2\2\u094d\u094e\7\u00be\2\2\u094e\u094f\7\u013c\2\2\u094f"+
		"\u0950\5\u0190\u00c9\2\u0950\u0951\7\u013d\2\2\u0951\u0952\7\u013c\2\2"+
		"\u0952\u0953\5x=\2\u0953\u0954\7\u013d\2\2\u0954w\3\2\2\2\u0955\u095a"+
		"\5z>\2\u0956\u0957\7\u0135\2\2\u0957\u0959\5z>\2\u0958\u0956\3\2\2\2\u0959"+
		"\u095c\3\2\2\2\u095a\u0958\3\2\2\2\u095a\u095b\3\2\2\2\u095by\3\2\2\2"+
		"\u095c\u095a\3\2\2\2\u095d\u095e\7\u00d5\2\2\u095e\u095f\5~@\2\u095f\u0961"+
		"\7\u00fb\2\2\u0960\u0962\7:\2\2\u0961\u0960\3\2\2\2\u0961\u0962\3\2\2"+
		"\2\u0962\u0963\3\2\2\2\u0963\u0964\7\u013c\2\2\u0964\u0965\5\u01a8\u00d5"+
		"\2\u0965\u0966\7\u013d\2\2\u0966{\3\2\2\2\u0967\u0968\7\u00d5\2\2\u0968"+
		"\u0969\7\u0087\2\2\u0969\u096a\7\u0090\2\2\u096a\u096b\5V,\2\u096b}\3"+
		"\2\2\2\u096c\u096d\5\u0082B\2\u096d\177\3\2\2\2\u096e\u096f\7\u00a2\2"+
		"\2\u096f\u0970\7q\2\2\u0970\u0972\5\u017e\u00c0\2\u0971\u0973\7\u00d9"+
		"\2\2\u0972\u0971\3\2\2\2\u0972\u0973\3\2\2\2\u0973\u0081\3\2\2\2\u0974"+
		"\u0976\7\u0147\2\2\u0975\u0974\3\2\2\2\u0975\u0976\3\2\2\2\u0976\u0977"+
		"\3\2\2\2\u0977\u0979\7\u014f\2\2\u0978\u097a\7\u0147\2\2\u0979\u0978\3"+
		"\2\2\2\u0979\u097a\3\2\2\2\u097a\u0983\3\2\2\2\u097b\u097d\7\u0147\2\2"+
		"\u097c\u097b\3\2\2\2\u097c\u097d\3\2\2\2\u097d\u097e\3\2\2\2\u097e\u0980"+
		"\5\u0084C\2\u097f\u0981\7\u0147\2\2\u0980\u097f\3\2\2\2\u0980\u0981\3"+
		"\2\2\2\u0981\u0983\3\2\2\2\u0982\u0975\3\2\2\2\u0982\u097c\3\2\2\2\u0983"+
		"\u0083\3\2\2\2\u0984\u0985\t\23\2\2\u0985\u0085\3\2\2\2\u0986\u0989\5"+
		"\u00bc_\2\u0987\u0989\5\u0088E\2\u0988\u0986\3\2\2\2\u0988\u0987\3\2\2"+
		"\2\u0989\u0087\3\2\2\2\u098a\u098e\7\u0150\2\2\u098b\u098e\5\u008aF\2"+
		"\u098c\u098e\5\u0092J\2\u098d\u098a\3\2\2\2\u098d\u098b\3\2\2\2\u098d"+
		"\u098c\3\2\2\2\u098e\u0089\3\2\2\2\u098f\u0993\5\u008eH\2\u0990\u0993"+
		"\5\u008cG\2\u0991\u0993\5\u0090I\2\u0992\u098f\3\2\2\2\u0992\u0990\3\2"+
		"\2\2\u0992\u0991\3\2\2\2\u0993\u008b\3\2\2\2\u0994\u0995\7\u0120\2\2\u0995"+
		"\u0996\7\u0150\2\2\u0996\u008d\3\2\2\2\u0997\u0998\7\u0122\2\2\u0998\u0999"+
		"\7\u0150\2\2\u0999\u008f\3\2\2\2\u099a\u099b\7\u011f\2\2\u099b\u099c\7"+
		"\u0150\2\2\u099c\u0091\3\2\2\2\u099d\u099e\t\24\2\2\u099e\u0093\3\2\2"+
		"\2\u099f\u09a3\5\u0096L\2\u09a0\u09a1\7l\2\2\u09a1\u09a3\5\u0082B\2\u09a2"+
		"\u099f\3\2\2\2\u09a2\u09a0\3\2\2\2\u09a3\u0095\3\2\2\2\u09a4\u09b2\5\u009c"+
		"O\2\u09a5\u09b2\5\u00a0Q\2\u09a6\u09b2\5\u00a2R\2\u09a7\u09b2\5\u00a4"+
		"S\2\u09a8\u09b2\5\u00acW\2\u09a9\u09b2\5\u00aeX\2\u09aa\u09b2\5\u00b0"+
		"Y\2\u09ab\u09b2\5\u00b2Z\2\u09ac\u09b2\5\u009aN\2\u09ad\u09b2\5\u0098"+
		"M\2\u09ae\u09b2\7v\2\2\u09af\u09b2\7\u0125\2\2\u09b0\u09b2\7\u012b\2\2"+
		"\u09b1\u09a4\3\2\2\2\u09b1\u09a5\3\2\2\2\u09b1\u09a6\3\2\2\2\u09b1\u09a7"+
		"\3\2\2\2\u09b1\u09a8\3\2\2\2\u09b1\u09a9\3\2\2\2\u09b1\u09aa\3\2\2\2\u09b1"+
		"\u09ab\3\2\2\2\u09b1\u09ac\3\2\2\2\u09b1\u09ad\3\2\2\2\u09b1\u09ae\3\2"+
		"\2\2\u09b1\u09af\3\2\2\2\u09b1\u09b0\3\2\2\2\u09b2\u0097\3\2\2\2\u09b3"+
		"\u09b4\7\u0116\2\2\u09b4\u0099\3\2\2\2\u09b5\u09b6\7\u012a\2\2\u09b6\u009b"+
		"\3\2\2\2\u09b7\u09b9\7\u008c\2\2\u09b8\u09ba\5\u009eP\2\u09b9\u09b8\3"+
		"\2\2\2\u09b9\u09ba\3\2\2\2\u09ba\u09cf\3\2\2\2\u09bb\u09bd\7\u011b\2\2"+
		"\u09bc\u09be\5\u009eP\2\u09bd\u09bc\3\2\2\2\u09bd\u09be\3\2\2\2\u09be"+
		"\u09cf\3\2\2\2\u09bf\u09c0\7\u008c\2\2\u09c0\u09c2\7\u00fe\2\2\u09c1\u09c3"+
		"\5\u009eP\2\u09c2\u09c1\3\2\2\2\u09c2\u09c3\3\2\2\2\u09c3\u09cf\3\2\2"+
		"\2\u09c4\u09c5\7\u011b\2\2\u09c5\u09c7\7\u00fe\2\2\u09c6\u09c8\5\u009e"+
		"P\2\u09c7\u09c6\3\2\2\2\u09c7\u09c8\3\2\2\2\u09c8\u09cf\3\2\2\2\u09c9"+
		"\u09cb\7\u011c\2\2\u09ca\u09cc\5\u009eP\2\u09cb\u09ca\3\2\2\2\u09cb\u09cc"+
		"\3\2\2\2\u09cc\u09cf\3\2\2\2\u09cd\u09cf\7\u0124\2\2\u09ce\u09b7\3\2\2"+
		"\2\u09ce\u09bb\3\2\2\2\u09ce\u09bf\3\2\2\2\u09ce\u09c4\3\2\2\2\u09ce\u09c9"+
		"\3\2\2\2\u09ce\u09cd\3\2\2\2\u09cf\u009d\3\2\2\2\u09d0\u09d1\7\u013c\2"+
		"\2\u09d1\u09d2\7\u014b\2\2\u09d2\u09d3\7\u013d\2\2\u09d3\u009f\3\2\2\2"+
		"\u09d4\u09d5\7\u00ca\2\2\u09d5\u09d7\7\u008c\2\2\u09d6\u09d8\5\u009eP"+
		"\2\u09d7\u09d6\3\2\2\2\u09d7\u09d8\3\2\2\2\u09d8\u09f8\3\2\2\2\u09d9\u09da"+
		"\7\u00ca\2\2\u09da\u09dc\7\u011b\2\2\u09db\u09dd\5\u009eP\2\u09dc\u09db"+
		"\3\2\2\2\u09dc\u09dd\3\2\2\2\u09dd\u09f8\3\2\2\2\u09de\u09e0\7\u011d\2"+
		"\2\u09df\u09e1\5\u009eP\2\u09e0\u09df\3\2\2\2\u09e0\u09e1\3\2\2\2\u09e1"+
		"\u09f8\3\2\2\2\u09e2\u09e3\7\u00ca\2\2\u09e3\u09e4\7\u008c\2\2\u09e4\u09e6"+
		"\7\u00fe\2\2\u09e5\u09e7\5\u009eP\2\u09e6\u09e5\3\2\2\2\u09e6\u09e7\3"+
		"\2\2\2\u09e7\u09f8\3\2\2\2\u09e8\u09e9\7\u00ca\2\2\u09e9\u09ea\7\u011b"+
		"\2\2\u09ea\u09ec\7\u00fe\2\2\u09eb\u09ed\5\u009eP\2\u09ec\u09eb\3\2\2"+
		"\2\u09ec\u09ed\3\2\2\2\u09ed\u09f8\3\2\2\2\u09ee\u09ef\7\u011d\2\2\u09ef"+
		"\u09f1\7\u00fe\2\2\u09f0\u09f2\5\u009eP\2\u09f1\u09f0\3\2\2\2\u09f1\u09f2"+
		"\3\2\2\2\u09f2\u09f8\3\2\2\2\u09f3\u09f5\7\u011e\2\2\u09f4\u09f6\5\u009e"+
		"P\2\u09f5\u09f4\3\2\2\2\u09f5\u09f6\3\2\2\2\u09f6\u09f8\3\2\2\2\u09f7"+
		"\u09d4\3\2\2\2\u09f7\u09d9\3\2\2\2\u09f7\u09de\3\2\2\2\u09f7\u09e2\3\2"+
		"\2\2\u09f7\u09e8\3\2\2\2\u09f7\u09ee\3\2\2\2\u09f7\u09f3\3\2\2\2\u09f8"+
		"\u00a1\3\2\2\2\u09f9\u09fb\7\u0128\2\2\u09fa\u09fc\5\u009eP\2\u09fb\u09fa"+
		"\3\2\2\2\u09fb\u09fc\3\2\2\2\u09fc\u0a02\3\2\2\2\u09fd\u09ff\7\u0129\2"+
		"\2\u09fe\u0a00\5\u009eP\2\u09ff\u09fe\3\2\2\2\u09ff\u0a00\3\2\2\2\u0a00"+
		"\u0a02\3\2\2\2\u0a01\u09f9\3\2\2\2\u0a01\u09fd\3\2\2\2\u0a02\u00a3\3\2"+
		"\2\2\u0a03\u0a06\5\u00a6T\2\u0a04\u0a06\5\u00a8U\2\u0a05\u0a03\3\2\2\2"+
		"\u0a05\u0a04\3\2\2\2\u0a06\u00a5\3\2\2\2\u0a07\u0a09\7\u0119\2\2\u0a08"+
		"\u0a0a\5\u00aaV\2\u0a09\u0a08\3\2\2\2\u0a09\u0a0a\3\2\2\2\u0a0a\u0a1d"+
		"\3\2\2\2\u0a0b\u0a0d\7\u011a\2\2\u0a0c\u0a0e\5\u00aaV\2\u0a0d\u0a0c\3"+
		"\2\2\2\u0a0d\u0a0e\3\2\2\2\u0a0e\u0a1d\3\2\2\2\u0a0f\u0a11\7\u009c\2\2"+
		"\u0a10\u0a12\5\u00aaV\2\u0a11\u0a10\3\2\2\2\u0a11\u0a12\3\2\2\2\u0a12"+
		"\u0a1d\3\2\2\2\u0a13\u0a1d\7\u010a\2\2\u0a14\u0a1d\7\u010e\2\2\u0a15\u0a1d"+
		"\7\u010b\2\2\u0a16\u0a1d\7\u010f\2\2\u0a17\u0a1d\7\u010c\2\2\u0a18\u0a1d"+
		"\7\u0110\2\2\u0a19\u0a1d\7\u0111\2\2\u0a1a\u0a1d\7\u010d\2\2\u0a1b\u0a1d"+
		"\7\u0112\2\2\u0a1c\u0a07\3\2\2\2\u0a1c\u0a0b\3\2\2\2\u0a1c\u0a0f\3\2\2"+
		"\2\u0a1c\u0a13\3\2\2\2\u0a1c\u0a14\3\2\2\2\u0a1c\u0a15\3\2\2\2\u0a1c\u0a16"+
		"\3\2\2\2\u0a1c\u0a17\3\2\2\2\u0a1c\u0a18\3\2\2\2\u0a1c\u0a19\3\2\2\2\u0a1c"+
		"\u0a1a\3\2\2\2\u0a1c\u0a1b\3\2\2\2\u0a1d\u00a7\3\2\2\2\u0a1e\u0a20\7\u0117"+
		"\2\2\u0a1f\u0a21\5\u00aaV\2\u0a20\u0a1f\3\2\2\2\u0a20\u0a21\3\2\2\2\u0a21"+
		"\u0a29\3\2\2\2\u0a22\u0a29\7\u0113\2\2\u0a23\u0a29\7\u0115\2\2\u0a24\u0a29"+
		"\7\u0114\2\2\u0a25\u0a29\7\u0118\2\2\u0a26\u0a27\7\u0118\2\2\u0a27\u0a29"+
		"\7\u00d7\2\2\u0a28\u0a1e\3\2\2\2\u0a28\u0a22\3\2\2\2\u0a28\u0a23\3\2\2"+
		"\2\u0a28\u0a24\3\2\2\2\u0a28\u0a25\3\2\2\2\u0a28\u0a26\3\2\2\2\u0a29\u00a9"+
		"\3\2\2\2\u0a2a\u0a2b\7\u013c\2\2\u0a2b\u0a2c\7\u014b\2\2\u0a2c\u0a33\7"+
		"\u013d\2\2\u0a2d\u0a2e\7\u013c\2\2\u0a2e\u0a2f\7\u014b\2\2\u0a2f\u0a30"+
		"\7\u0135\2\2\u0a30\u0a31\7\u014b\2\2\u0a31\u0a33\7\u013d\2\2\u0a32\u0a2a"+
		"\3\2\2\2\u0a32\u0a2d\3\2\2\2\u0a33\u00ab\3\2\2\2\u0a34\u0a35\t\25\2\2"+
		"\u0a35\u00ad\3\2\2\2\u0a36\u0a48\7\u011f\2\2\u0a37\u0a48\7\u0120\2\2\u0a38"+
		"\u0a39\7\u0120\2\2\u0a39\u0a3a\7\u0082\2\2\u0a3a\u0a3b\7\u0120\2\2\u0a3b"+
		"\u0a48\7\u0105\2\2\u0a3c\u0a48\7\u0121\2\2\u0a3d\u0a48\7\u0122\2\2\u0a3e"+
		"\u0a3f\7\u0122\2\2\u0a3f\u0a40\7\u0082\2\2\u0a40\u0a41\7\u0120\2\2\u0a41"+
		"\u0a48\7\u0105\2\2\u0a42\u0a43\7\u0122\2\2\u0a43\u0a44\7\u0083\2\2\u0a44"+
		"\u0a45\7\u0120\2\2\u0a45\u0a48\7\u0105\2\2\u0a46\u0a48\7\u0123\2\2\u0a47"+
		"\u0a36\3\2\2\2\u0a47\u0a37\3\2\2\2\u0a47\u0a38\3\2\2\2\u0a47\u0a3c\3\2"+
		"\2\2\u0a47\u0a3d\3\2\2\2\u0a47\u0a3e\3\2\2\2\u0a47\u0a42\3\2\2\2\u0a47"+
		"\u0a46\3\2\2\2\u0a48\u00af\3\2\2\2\u0a49\u0a4b\7\u0108\2\2\u0a4a\u0a4c"+
		"\5\u009eP\2\u0a4b\u0a4a\3\2\2\2\u0a4b\u0a4c\3\2\2\2\u0a4c\u0a57\3\2\2"+
		"\2\u0a4d\u0a4f\7\u0109\2\2\u0a4e\u0a50\5\u009eP\2\u0a4f\u0a4e\3\2\2\2"+
		"\u0a4f\u0a50\3\2\2\2\u0a50\u0a57\3\2\2\2\u0a51\u0a52\7\u0108\2\2\u0a52"+
		"\u0a54\7\u00fe\2\2\u0a53\u0a55\5\u009eP\2\u0a54\u0a53\3\2\2\2\u0a54\u0a55"+
		"\3\2\2\2\u0a55\u0a57\3\2\2\2\u0a56\u0a49\3\2\2\2\u0a56\u0a4d\3\2\2\2\u0a56"+
		"\u0a51\3\2\2\2\u0a57\u00b1\3\2\2\2\u0a58\u0a5a\7\u0126\2\2\u0a59\u0a5b"+
		"\5\u009eP\2\u0a5a\u0a59\3\2\2\2\u0a5a\u0a5b\3\2\2\2\u0a5b\u0a66\3\2\2"+
		"\2\u0a5c\u0a5d\7\u0126\2\2\u0a5d\u0a5f\7\u00fe\2\2\u0a5e\u0a60\5\u009e"+
		"P\2\u0a5f\u0a5e\3\2\2\2\u0a5f\u0a60\3\2\2\2\u0a60\u0a66\3\2\2\2\u0a61"+
		"\u0a63\7\u0127\2\2\u0a62\u0a64\5\u009eP\2\u0a63\u0a62\3\2\2\2\u0a63\u0a64"+
		"\3\2\2\2\u0a64\u0a66\3\2\2\2\u0a65\u0a58\3\2\2\2\u0a65\u0a5c\3\2\2\2\u0a65"+
		"\u0a61\3\2\2\2\u0a66\u00b3\3\2\2\2\u0a67\u0a6a\5\u00b6\\\2\u0a68\u0a6a"+
		"\5\u00b8]\2\u0a69\u0a67\3\2\2\2\u0a69\u0a68\3\2\2\2\u0a6a\u00b5\3\2\2"+
		"\2\u0a6b\u0a6c\7\u013c\2\2\u0a6c\u0a6d\5\u00e4s\2\u0a6d\u0a6e\7\u013d"+
		"\2\2\u0a6e\u00b7\3\2\2\2\u0a6f\u0a77\5\u00ba^\2\u0a70\u0a77\5\u018c\u00c7"+
		"\2\u0a71\u0a77\5\u00c0a\2\u0a72\u0a77\5\u0192\u00ca\2\u0a73\u0a77\5\u00cc"+
		"g\2\u0a74\u0a77\5\u00dep\2\u0a75\u0a77\5\u01c6\u00e4\2\u0a76\u0a6f\3\2"+
		"\2\2\u0a76\u0a70\3\2\2\2\u0a76\u0a71\3\2\2\2\u0a76\u0a72\3\2\2\2\u0a76"+
		"\u0a73\3\2\2\2\u0a76\u0a74\3\2\2\2\u0a76\u0a75\3\2\2\2\u0a77\u00b9\3\2"+
		"\2\2\u0a78\u0a79\5\u0086D\2\u0a79\u00bb\3\2\2\2\u0a7a\u0a7b\t\26\2\2\u0a7b"+
		"\u00bd\3\2\2\2\u0a7c\u0a7e\5\u00f2z\2\u0a7d\u0a7c\3\2\2\2\u0a7d\u0a7e"+
		"\3\2\2\2\u0a7e\u0a7f\3\2\2\2\u0a7f\u0a80\5\u00bc_\2\u0a80\u00bf\3\2\2"+
		"\2\u0a81\u0a82\5\u00c2b\2\u0a82\u00c1\3\2\2\2\u0a83\u0a84\7\u0096\2\2"+
		"\u0a84\u0a85\7\u013c\2\2\u0a85\u0a86\7\u0140\2\2\u0a86\u0a8c\7\u013d\2"+
		"\2\u0a87\u0a89\5\u00c4c\2\u0a88\u0a8a\5\u00c8e\2\u0a89\u0a88\3\2\2\2\u0a89"+
		"\u0a8a\3\2\2\2\u0a8a\u0a8c\3\2\2\2\u0a8b\u0a83\3\2\2\2\u0a8b\u0a87\3\2"+
		"\2\2\u0a8c\u00c3\3\2\2\2\u0a8d\u0a8e\5\u00c6d\2\u0a8e\u0a90\7\u013c\2"+
		"\2\u0a8f\u0a91\5\u018a\u00c6\2\u0a90\u0a8f\3\2\2\2\u0a90\u0a91\3\2\2\2"+
		"\u0a91\u0a92\3\2\2\2\u0a92\u0a93\5\u00e4s\2\u0a93\u0a94\7\u013d\2\2\u0a94"+
		"\u00c5\3\2\2\2\u0a95\u0a96\t\27\2\2\u0a96\u00c7\3\2\2\2\u0a97\u0a98\7"+
		"\u00a9\2\2\u0a98\u0a99\7\u013c\2\2\u0a99\u0a9a\7\u0081\2\2\u0a9a\u0a9b"+
		"\5\u0154\u00ab\2\u0a9b\u0a9c\7\u013d\2\2\u0a9c\u00c9\3\2\2\2\u0a9d\u0a9e"+
		"\7\u00ad\2\2\u0a9e\u0a9f\7\u013c\2\2\u0a9f\u0aa0\5\u0190\u00c9\2\u0aa0"+
		"\u0aa1\7\u013d\2\2\u0aa1\u00cb\3\2\2\2\u0aa2\u0aa3\5\u00d0i\2\u0aa3\u00cd"+
		"\3\2\2\2\u0aa4\u0aa5\7\u00cd\2\2\u0aa5\u0aa6\7\u013c\2\2\u0aa6\u0aa7\5"+
		"\u00e8u\2\u0aa7\u0aa8\7\u0135\2\2\u0aa8\u0aa9\5\u010e\u0088\2\u0aa9\u0aaa"+
		"\7\u013d\2\2\u0aaa\u0ab7\3\2\2\2\u0aab\u0aac\7\u008f\2\2\u0aac\u0aad\7"+
		"\u013c\2\2\u0aad\u0ab0\5\u00e8u\2\u0aae\u0aaf\7\u0135\2\2\u0aaf\u0ab1"+
		"\5\u010e\u0088\2\u0ab0\u0aae\3\2\2\2\u0ab1\u0ab2\3\2\2\2\u0ab2\u0ab0\3"+
		"\2\2\2\u0ab2\u0ab3\3\2\2\2\u0ab3\u0ab4\3\2\2\2\u0ab4\u0ab5\7\u013d\2\2"+
		"\u0ab5\u0ab7\3\2\2\2\u0ab6\u0aa4\3\2\2\2\u0ab6\u0aab\3\2\2\2\u0ab7\u00cf"+
		"\3\2\2\2\u0ab8\u0abb\5\u00d2j\2\u0ab9\u0abb\5\u00d4k\2\u0aba\u0ab8\3\2"+
		"\2\2\u0aba\u0ab9\3\2\2\2\u0abb\u00d1\3\2\2\2\u0abc\u0abd\7\17\2\2\u0abd"+
		"\u0abf\5\u010e\u0088\2\u0abe\u0ac0\5\u00d6l\2\u0abf\u0abe\3\2\2\2\u0ac0"+
		"\u0ac1\3\2\2\2\u0ac1\u0abf\3\2\2\2\u0ac1\u0ac2\3\2\2\2\u0ac2\u0ac4\3\2"+
		"\2\2\u0ac3\u0ac5\5\u00dan\2\u0ac4\u0ac3\3\2\2\2\u0ac4\u0ac5\3\2\2\2\u0ac5"+
		"\u0ac6\3\2\2\2\u0ac6\u0ac7\7$\2\2\u0ac7\u00d3\3\2\2\2\u0ac8\u0aca\7\17"+
		"\2\2\u0ac9\u0acb\5\u00d8m\2\u0aca\u0ac9\3\2\2\2\u0acb\u0acc\3\2\2\2\u0acc"+
		"\u0aca\3\2\2\2\u0acc\u0acd\3\2\2\2\u0acd\u0acf\3\2\2\2\u0ace\u0ad0\5\u00da"+
		"n\2\u0acf\u0ace\3\2\2\2\u0acf\u0ad0\3\2\2\2\u0ad0\u0ad1\3\2\2\2\u0ad1"+
		"\u0ad2\7$\2\2\u0ad2\u00d5\3\2\2\2\u0ad3\u0ad4\7\u0080\2\2\u0ad4\u0ad5"+
		"\5\u0154\u00ab\2\u0ad5\u0ad6\7t\2\2\u0ad6\u0ad7\5\u00dco\2\u0ad7\u00d7"+
		"\3\2\2\2\u0ad8\u0ad9\7\u0080\2\2\u0ad9\u0ada\5\u0154\u00ab\2\u0ada\u0adb"+
		"\7t\2\2\u0adb\u0adc\5\u00dco\2\u0adc\u00d9\3\2\2\2\u0add\u0ade\7%\2\2"+
		"\u0ade\u0adf\5\u00dco\2\u0adf\u00db\3\2\2\2\u0ae0\u0ae3\5\u00e4s\2\u0ae1"+
		"\u0ae3\7N\2\2\u0ae2\u0ae0\3\2\2\2\u0ae2\u0ae1\3\2\2\2\u0ae3\u00dd\3\2"+
		"\2\2\u0ae4\u0ae5\7\21\2\2\u0ae5\u0ae6\7\u013c\2\2\u0ae6\u0ae7\5\u00e0"+
		"q\2\u0ae7\u0ae8\7\5\2\2\u0ae8\u0ae9\5\u00e2r\2\u0ae9\u0aea\7\u013d\2\2"+
		"\u0aea\u00df\3\2\2\2\u0aeb\u0aec\5\u00e4s\2\u0aec\u00e1\3\2\2\2\u0aed"+
		"\u0aee\5\u0094K\2\u0aee\u00e3\3\2\2\2\u0aef\u0af3\5\u00e6t\2\u0af0\u0af3"+
		"\5\u0122\u0092\2\u0af1\u0af3\5\u010e\u0088\2\u0af2\u0aef\3\2\2\2\u0af2"+
		"\u0af0\3\2\2\2\u0af2\u0af1\3\2\2\2\u0af3\u00e5\3\2\2\2\u0af4\u0af8\5\u00e8"+
		"u\2\u0af5\u0af8\5\u00fe\u0080\2\u0af6\u0af8\7N\2\2\u0af7\u0af4\3\2\2\2"+
		"\u0af7\u0af5\3\2\2\2\u0af7\u0af6\3\2\2\2\u0af8\u00e7\3\2\2\2\u0af9\u0afe"+
		"\5\u00eav\2\u0afa\u0afb\t\30\2\2\u0afb\u0afd\5\u00eav\2\u0afc\u0afa\3"+
		"\2\2\2\u0afd\u0b00\3\2\2\2\u0afe\u0afc\3\2\2\2\u0afe\u0aff\3\2\2\2\u0aff"+
		"\u00e9\3\2\2\2\u0b00\u0afe\3\2\2\2\u0b01\u0b06\5\u00ecw\2\u0b02\u0b03"+
		"\t\31\2\2\u0b03\u0b05\5\u00ecw\2\u0b04\u0b02\3\2\2\2\u0b05\u0b08\3\2\2"+
		"\2\u0b06\u0b04\3\2\2\2\u0b06\u0b07\3\2\2\2\u0b07\u00eb\3\2\2\2\u0b08\u0b06"+
		"\3\2\2\2\u0b09\u0b0b\5\u00f2z\2\u0b0a\u0b09\3\2\2\2\u0b0a\u0b0b\3\2\2"+
		"\2\u0b0b\u0b0c\3\2\2\2\u0b0c\u0b0d\5\u00f0y\2\u0b0d\u00ed\3\2\2\2\u0b0e"+
		"\u0b0f\7\u013c\2\2\u0b0f\u0b14\5\u00e8u\2\u0b10\u0b11\7\u0135\2\2\u0b11"+
		"\u0b13\5\u00e8u\2\u0b12\u0b10\3\2\2\2\u0b13\u0b16\3\2\2\2\u0b14\u0b12"+
		"\3\2\2\2\u0b14\u0b15\3\2\2\2\u0b15\u0b17\3\2\2\2\u0b16\u0b14\3\2\2\2\u0b17"+
		"\u0b18\7\u013d\2\2\u0b18\u00ef\3\2\2\2\u0b19\u0b1e\5\u00b4[\2\u0b1a\u0b1b"+
		"\7\u0130\2\2\u0b1b\u0b1d\5\u00e2r\2\u0b1c\u0b1a\3\2\2\2\u0b1d\u0b20\3"+
		"\2\2\2\u0b1e\u0b1c\3\2\2\2\u0b1e\u0b1f\3\2\2\2\u0b1f\u0b23\3\2\2\2\u0b20"+
		"\u0b1e\3\2\2\2\u0b21\u0b23\5\u00f4{\2\u0b22\u0b19\3\2\2\2\u0b22\u0b21"+
		"\3\2\2\2\u0b23\u00f1\3\2\2\2\u0b24\u0b25\t\30\2\2\u0b25\u00f3\3\2\2\2"+
		"\u0b26\u0b27\5\u00f6|\2\u0b27\u00f5\3\2\2\2\u0b28\u0b29\7\u00a7\2\2\u0b29"+
		"\u0b2a\7\u013c\2\2\u0b2a\u0b2b\5\u00f8}\2\u0b2b\u0b2c\7\61\2\2\u0b2c\u0b2d"+
		"\5\u00fc\177\2\u0b2d\u0b2e\7\u013d\2\2\u0b2e\u00f7\3\2\2\2\u0b2f\u0b33"+
		"\5\u01c0\u00e1\2\u0b30\u0b33\5\u00fa~\2\u0b31\u0b33\5\u01c4\u00e3\2\u0b32"+
		"\u0b2f\3\2\2\2\u0b32\u0b30\3\2\2\2\u0b32\u0b31\3\2\2\2\u0b33\u00f9\3\2"+
		"\2\2\u0b34\u0b35\t\32\2\2\u0b35\u00fb\3\2\2\2\u0b36\u0b39\5\u018c\u00c7"+
		"\2\u0b37\u0b39\5\u008aF\2\u0b38\u0b36\3\2\2\2\u0b38\u0b37\3\2\2\2\u0b39"+
		"\u00fd\3\2\2\2\u0b3a\u0b3b\5\u0100\u0081\2\u0b3b\u00ff\3\2\2\2\u0b3c\u0b41"+
		"\5\u0102\u0082\2\u0b3d\u0b3e\7\u0136\2\2\u0b3e\u0b40\5\u0102\u0082\2\u0b3f"+
		"\u0b3d\3\2\2\2\u0b40\u0b43\3\2\2\2\u0b41\u0b3f\3\2\2\2\u0b41\u0b42\3\2"+
		"\2\2\u0b42\u0101\3\2\2\2\u0b43\u0b41\3\2\2\2\u0b44\u0b45\5\u0104\u0083"+
		"\2\u0b45\u0103\3\2\2\2\u0b46\u0b49\5\u00b4[\2\u0b47\u0b49\5\u0106\u0084"+
		"\2\u0b48\u0b46\3\2\2\2\u0b48\u0b47\3\2\2\2\u0b49\u0105\3\2\2\2\u0b4a\u0b4b"+
		"\5\u0108\u0085\2\u0b4b\u0107\3\2\2\2\u0b4c\u0b4d\7\u00f6\2\2\u0b4d\u0b4e"+
		"\7\u013c\2\2\u0b4e\u0b4f\5\u010a\u0086\2\u0b4f\u0b50\7\u013d\2\2\u0b50"+
		"\u0109\3\2\2\2\u0b51\u0b53\5\u010c\u0087\2\u0b52\u0b51\3\2\2\2\u0b52\u0b53"+
		"\3\2\2\2\u0b53\u0b55\3\2\2\2\u0b54\u0b56\5\u0100\u0081\2\u0b55\u0b54\3"+
		"\2\2\2\u0b55\u0b56\3\2\2\2\u0b56\u0b57\3\2\2\2\u0b57\u0b59\7\61\2\2\u0b58"+
		"\u0b52\3\2\2\2\u0b58\u0b59\3\2\2\2\u0b59\u0b5a\3\2\2\2\u0b5a\u0b60\5\u0100"+
		"\u0081\2\u0b5b\u0b5c\5\u0100\u0081\2\u0b5c\u0b5d\7\u0135\2\2\u0b5d\u0b5e"+
		"\5\u0100\u0081\2\u0b5e\u0b60\3\2\2\2\u0b5f\u0b58\3\2\2\2\u0b5f\u0b5b\3"+
		"\2\2\2\u0b60\u010b\3\2\2\2\u0b61\u0b62\t\33\2\2\u0b62\u010d\3\2\2\2\u0b63"+
		"\u0b64\5\u0110\u0089\2\u0b64\u010f\3\2\2\2\u0b65\u0b6a\5\u0112\u008a\2"+
		"\u0b66\u0b67\7T\2\2\u0b67\u0b69\5\u0110\u0089\2\u0b68\u0b66\3\2\2\2\u0b69"+
		"\u0b6c\3\2\2\2\u0b6a\u0b68\3\2\2\2\u0b6a\u0b6b\3\2\2\2\u0b6b\u0111\3\2"+
		"\2\2\u0b6c\u0b6a\3\2\2\2\u0b6d\u0b72\5\u0114\u008b\2\u0b6e\u0b6f\7\b\2"+
		"\2\u0b6f\u0b71\5\u0112\u008a\2\u0b70\u0b6e\3\2\2\2\u0b71\u0b74\3\2\2\2"+
		"\u0b72\u0b70\3\2\2\2\u0b72\u0b73\3\2\2\2\u0b73\u0113\3\2\2\2\u0b74\u0b72"+
		"\3\2\2\2\u0b75\u0b79\5\u0116\u008c\2\u0b76\u0b77\7M\2\2\u0b77\u0b79\5"+
		"\u0116\u008c\2\u0b78\u0b75\3\2\2\2\u0b78\u0b76\3\2\2\2\u0b79\u0115\3\2"+
		"\2\2\u0b7a\u0b7c\5\u011c\u008f\2\u0b7b\u0b7d\5\u0118\u008d\2\u0b7c\u0b7b"+
		"\3\2\2\2\u0b7c\u0b7d\3\2\2\2\u0b7d\u0117\3\2\2\2\u0b7e\u0b80\7D\2\2\u0b7f"+
		"\u0b81\7M\2\2\u0b80\u0b7f\3\2\2\2\u0b80\u0b81\3\2\2\2\u0b81\u0b82\3\2"+
		"\2\2\u0b82\u0b83\5\u011a\u008e\2\u0b83\u0119\3\2\2\2\u0b84\u0b85\t\24"+
		"\2\2\u0b85\u011b\3\2\2\2\u0b86\u0b89\5\u019a\u00ce\2\u0b87\u0b89\5\u011e"+
		"\u0090\2\u0b88\u0b86\3\2\2\2\u0b88\u0b87\3\2\2\2\u0b89\u011d\3\2\2\2\u0b8a"+
		"\u0b8d\5\u0120\u0091\2\u0b8b\u0b8d\5\u00b8]\2\u0b8c\u0b8a\3\2\2\2\u0b8c"+
		"\u0b8b\3\2\2\2\u0b8d\u011f\3\2\2\2\u0b8e\u0b8f\7\u013c\2\2\u0b8f\u0b90"+
		"\5\u010e\u0088\2\u0b90\u0b91\7\u013d\2\2\u0b91\u0121\3\2\2\2\u0b92\u0b95"+
		"\5\u0124\u0093\2\u0b93\u0b95\5\u0126\u0094\2\u0b94\u0b92\3\2\2\2\u0b94"+
		"\u0b93\3\2\2\2\u0b95\u0123\3\2\2\2\u0b96\u0b97\5\u00b8]\2\u0b97\u0125"+
		"\3\2\2\2\u0b98\u0b99\7N\2\2\u0b99\u0127\3\2\2\2\u0b9a\u0b9d\5\u0124\u0093"+
		"\2\u0b9b\u0b9d\5\u012a\u0096\2\u0b9c\u0b9a\3\2\2\2\u0b9c\u0b9b\3\2\2\2"+
		"\u0b9d\u0129\3\2\2\2\u0b9e\u0ba1\5\u00e6t\2\u0b9f\u0ba1\5\u011e\u0090"+
		"\2\u0ba0\u0b9e\3\2\2\2\u0ba0\u0b9f\3\2\2\2\u0ba1\u012b\3\2\2\2\u0ba2\u0ba4"+
		"\5\u012e\u0098\2\u0ba3\u0ba5\5\u0152\u00aa\2\u0ba4\u0ba3\3\2\2\2\u0ba4"+
		"\u0ba5\3\2\2\2\u0ba5\u0ba7\3\2\2\2\u0ba6\u0ba8\5\u0156\u00ac\2\u0ba7\u0ba6"+
		"\3\2\2\2\u0ba7\u0ba8\3\2\2\2\u0ba8\u0baa\3\2\2\2\u0ba9\u0bab\5\u0166\u00b4"+
		"\2\u0baa\u0ba9\3\2\2\2\u0baa\u0bab\3\2\2\2\u0bab\u0bad\3\2\2\2\u0bac\u0bae"+
		"\5\u01ce\u00e8\2\u0bad\u0bac\3\2\2\2\u0bad\u0bae\3\2\2\2\u0bae\u0bb0\3"+
		"\2\2\2\u0baf\u0bb1\5\u01d6\u00ec\2\u0bb0\u0baf\3\2\2\2\u0bb0\u0bb1\3\2"+
		"\2\2\u0bb1\u012d\3\2\2\2\u0bb2\u0bb3\7\61\2\2\u0bb3\u0bb4\5\u0130\u0099"+
		"\2\u0bb4\u012f\3\2\2\2\u0bb5\u0bba\5\u0132\u009a\2\u0bb6\u0bb7\7\u0135"+
		"\2\2\u0bb7\u0bb9\5\u0132\u009a\2\u0bb8\u0bb6\3\2\2\2\u0bb9\u0bbc\3\2\2"+
		"\2\u0bba\u0bb8\3\2\2\2\u0bba\u0bbb\3\2\2\2\u0bbb\u0131\3\2\2\2\u0bbc\u0bba"+
		"\3\2\2\2\u0bbd\u0bc0\5\u0134\u009b\2\u0bbe\u0bc0\5\u014c\u00a7\2\u0bbf"+
		"\u0bbd\3\2\2\2\u0bbf\u0bbe\3\2\2\2\u0bc0\u0133\3\2\2\2\u0bc1\u0bc3\5\u014c"+
		"\u00a7\2\u0bc2\u0bc4\5\u0136\u009c\2\u0bc3\u0bc2\3\2\2\2\u0bc4\u0bc5\3"+
		"\2\2\2\u0bc5\u0bc3\3\2\2\2\u0bc5\u0bc6\3\2\2\2\u0bc6\u0135\3\2\2\2\u0bc7"+
		"\u0bc8\7\31\2\2\u0bc8\u0bc9\7E\2\2\u0bc9\u0bdb\5\u014c\u00a7\2\u0bca\u0bcc"+
		"\5\u0140\u00a1\2\u0bcb\u0bca\3\2\2\2\u0bcb\u0bcc\3\2\2\2\u0bcc\u0bcd\3"+
		"\2\2\2\u0bcd\u0bce\7E\2\2\u0bce\u0bcf\5\u014c\u00a7\2\u0bcf\u0bd0\5\u0146"+
		"\u00a4\2\u0bd0\u0bdb\3\2\2\2\u0bd1\u0bd3\7L\2\2\u0bd2\u0bd4\5\u0140\u00a1"+
		"\2\u0bd3\u0bd2\3\2\2\2\u0bd3\u0bd4\3\2\2\2\u0bd4\u0bd5\3\2\2\2\u0bd5\u0bd6"+
		"\7E\2\2\u0bd6\u0bdb\5\u014c\u00a7\2\u0bd7\u0bd8\7y\2\2\u0bd8\u0bd9\7E"+
		"\2\2\u0bd9\u0bdb\5\u014c\u00a7\2\u0bda\u0bc7\3\2\2\2\u0bda\u0bcb\3\2\2"+
		"\2\u0bda\u0bd1\3\2\2\2\u0bda\u0bd7\3\2\2\2\u0bdb\u0137\3\2\2\2\u0bdc\u0bdd"+
		"\7\31\2\2\u0bdd\u0bde\7E\2\2\u0bde\u0bdf\5\u014c\u00a7\2\u0bdf\u0139\3"+
		"\2\2\2\u0be0\u0be2\5\u0140\u00a1\2\u0be1\u0be0\3\2\2\2\u0be1\u0be2\3\2"+
		"\2\2\u0be2\u0be3\3\2\2\2\u0be3\u0be4\7E\2\2\u0be4\u0be5\5\u014c\u00a7"+
		"\2\u0be5\u0be6\5\u0146\u00a4\2\u0be6\u013b\3\2\2\2\u0be7\u0be9\7L\2\2"+
		"\u0be8\u0bea\5\u0140\u00a1\2\u0be9\u0be8\3\2\2\2\u0be9\u0bea\3\2\2\2\u0bea"+
		"\u0beb\3\2\2\2\u0beb\u0bec\7E\2\2\u0bec\u0bed\5\u014c\u00a7\2\u0bed\u013d"+
		"\3\2\2\2\u0bee\u0bef\7y\2\2\u0bef\u0bf0\7E\2\2\u0bf0\u0bf1\5\u014c\u00a7"+
		"\2\u0bf1\u013f\3\2\2\2\u0bf2\u0bf5\7>\2\2\u0bf3\u0bf5\5\u0142\u00a2\2"+
		"\u0bf4\u0bf2\3\2\2\2\u0bf4\u0bf3\3\2\2\2\u0bf5\u0141\3\2\2\2\u0bf6\u0bf8"+
		"\5\u0144\u00a3\2\u0bf7\u0bf9\7Q\2\2\u0bf8\u0bf7\3\2\2\2\u0bf8\u0bf9\3"+
		"\2\2\2\u0bf9\u0143\3\2\2\2\u0bfa\u0bfb\t\34\2\2\u0bfb\u0145\3\2\2\2\u0bfc"+
		"\u0bff\5\u0148\u00a5\2\u0bfd\u0bff\5\u014a\u00a6\2\u0bfe\u0bfc\3\2\2\2"+
		"\u0bfe\u0bfd\3\2\2\2\u0bff\u0147\3\2\2\2\u0c00\u0c01\7\u00cf\2\2\u0c01"+
		"\u0c02\5\u0154\u00ab\2\u0c02\u0149\3\2\2\2\u0c03\u0c04\7}\2\2\u0c04\u0c05"+
		"\7\u013c\2\2\u0c05\u0c06\5\u0190\u00c9\2\u0c06\u0c07\7\u013d\2\2\u0c07"+
		"\u014b\3\2\2\2\u0c08\u0c0d\5\u017c\u00bf\2\u0c09\u0c0b\7\5\2\2\u0c0a\u0c09"+
		"\3\2\2\2\u0c0a\u0c0b\3\2\2\2\u0c0b\u0c0c\3\2\2\2\u0c0c\u0c0e\5\u0082B"+
		"\2\u0c0d\u0c0a\3\2\2\2\u0c0d\u0c0e\3\2\2\2\u0c0e\u0c13\3\2\2\2\u0c0f\u0c10"+
		"\7\u013c\2\2\u0c10\u0c11\5\u014e\u00a8\2\u0c11\u0c12\7\u013d\2\2\u0c12"+
		"\u0c14\3\2\2\2\u0c13\u0c0f\3\2\2\2\u0c13\u0c14\3\2\2\2\u0c14\u0c21\3\2"+
		"\2\2\u0c15\u0c17\5\u0150\u00a9\2\u0c16\u0c18\7\5\2\2\u0c17\u0c16\3\2\2"+
		"\2\u0c17\u0c18\3\2\2\2\u0c18\u0c19\3\2\2\2\u0c19\u0c1e\5\u0082B\2\u0c1a"+
		"\u0c1b\7\u013c\2\2\u0c1b\u0c1c\5\u014e\u00a8\2\u0c1c\u0c1d\7\u013d\2\2"+
		"\u0c1d\u0c1f\3\2\2\2\u0c1e\u0c1a\3\2\2\2\u0c1e\u0c1f\3\2\2\2\u0c1f\u0c21"+
		"\3\2\2\2\u0c20\u0c08\3\2\2\2\u0c20\u0c15\3\2\2\2\u0c21\u014d\3\2\2\2\u0c22"+
		"\u0c27\5\u0082B\2\u0c23\u0c24\7\u0135\2\2\u0c24\u0c26\5\u0082B\2\u0c25"+
		"\u0c23\3\2\2\2\u0c26\u0c29\3\2\2\2\u0c27\u0c25\3\2\2\2\u0c27\u0c28\3\2"+
		"\2\2\u0c28\u014f\3\2\2\2\u0c29\u0c27\3\2\2\2\u0c2a\u0c2b\5\u0196\u00cc"+
		"\2\u0c2b\u0151\3\2\2\2\u0c2c\u0c2d\7\u0081\2\2\u0c2d\u0c2e\5\u0154\u00ab"+
		"\2\u0c2e\u0153\3\2\2\2\u0c2f\u0c30\5\u00e4s\2\u0c30\u0155\3\2\2\2\u0c31"+
		"\u0c32\7\64\2\2\u0c32\u0c33\7\u0087\2\2\u0c33\u0c34\5\u0158\u00ad\2\u0c34"+
		"\u0157\3\2\2\2\u0c35\u0c3a\5\u015a\u00ae\2\u0c36\u0c37\7\u0135\2\2\u0c37"+
		"\u0c39\5\u015a\u00ae\2\u0c38\u0c36\3\2\2\2\u0c39\u0c3c\3\2\2\2\u0c3a\u0c38"+
		"\3\2\2\2\u0c3a\u0c3b\3\2\2\2\u0c3b\u0159\3\2\2\2\u0c3c\u0c3a\3\2\2\2\u0c3d"+
		"\u0c42\5\u0160\u00b1\2\u0c3e\u0c42\5\u0162\u00b2\2\u0c3f\u0c42\5\u0164"+
		"\u00b3\2\u0c40\u0c42\5\u015c\u00af\2\u0c41\u0c3d\3\2\2\2\u0c41\u0c3e\3"+
		"\2\2\2\u0c41\u0c3f\3\2\2\2\u0c41\u0c40\3\2\2\2\u0c42\u015b\3\2\2\2\u0c43"+
		"\u0c49\5\u0128\u0095\2\u0c44\u0c45\7\u013c\2\2\u0c45\u0c46\5\u0168\u00b5"+
		"\2\u0c46\u0c47\7\u013d\2\2\u0c47\u0c49\3\2\2\2\u0c48\u0c43\3\2\2\2\u0c48"+
		"\u0c44\3\2\2\2\u0c49\u015d\3\2\2\2\u0c4a\u0c4f\5\u015c\u00af\2\u0c4b\u0c4c"+
		"\7\u0135\2\2\u0c4c\u0c4e\5\u015c\u00af\2\u0c4d\u0c4b\3\2\2\2\u0c4e\u0c51"+
		"\3\2\2\2\u0c4f\u0c4d\3\2\2\2\u0c4f\u0c50\3\2\2\2\u0c50\u015f\3\2\2\2\u0c51"+
		"\u0c4f\3\2\2\2\u0c52\u0c53\7\u00e0\2\2\u0c53\u0c54\7\u013c\2\2\u0c54\u0c55"+
		"\5\u015e\u00b0\2\u0c55\u0c56\7\u013d\2\2\u0c56\u0161\3\2\2\2\u0c57\u0c58"+
		"\7\u0097\2\2\u0c58\u0c59\7\u013c\2\2\u0c59\u0c5a\5\u015e\u00b0\2\u0c5a"+
		"\u0c5b\7\u013d\2\2\u0c5b\u0163\3\2\2\2\u0c5c\u0c5d\7\u013c\2\2\u0c5d\u0c5e"+
		"\7\u013d\2\2\u0c5e\u0165\3\2\2\2\u0c5f\u0c60\7\65\2\2\u0c60\u0c61\5\u010e"+
		"\u0088\2\u0c61\u0167\3\2\2\2\u0c62\u0c67\5\u0128\u0095\2\u0c63\u0c64\7"+
		"\u0135\2\2\u0c64\u0c66\5\u0128\u0095\2\u0c65\u0c63\3\2\2\2\u0c66\u0c69"+
		"\3\2\2\2\u0c67\u0c65\3\2\2\2\u0c67\u0c68\3\2\2\2\u0c68\u0169\3\2\2\2\u0c69"+
		"\u0c67\3\2\2\2\u0c6a\u0c6b\5\u016c\u00b7\2\u0c6b\u016b\3\2\2\2\u0c6c\u0c6f"+
		"\5\u016e\u00b8\2\u0c6d\u0c6f\5\u0134\u009b\2\u0c6e\u0c6c\3\2\2\2\u0c6e"+
		"\u0c6d\3\2\2\2\u0c6f\u016d\3\2\2\2\u0c70\u0c79\5\u0172\u00ba\2\u0c71\u0c72"+
		"\5\u0134\u009b\2\u0c72\u0c74\t\35\2\2\u0c73\u0c75\t\36\2\2\u0c74\u0c73"+
		"\3\2\2\2\u0c74\u0c75\3\2\2\2\u0c75\u0c76\3\2\2\2\u0c76\u0c77\5\u0170\u00b9"+
		"\2\u0c77\u0c79\3\2\2\2\u0c78\u0c70\3\2\2\2\u0c78\u0c71\3\2\2\2\u0c79\u0c81"+
		"\3\2\2\2\u0c7a\u0c7c\t\35\2\2\u0c7b\u0c7d\t\36\2\2\u0c7c\u0c7b\3\2\2\2"+
		"\u0c7c\u0c7d\3\2\2\2\u0c7d\u0c7e\3\2\2\2\u0c7e\u0c80\5\u0170\u00b9\2\u0c7f"+
		"\u0c7a\3\2\2\2\u0c80\u0c83\3\2\2\2\u0c81\u0c7f\3\2\2\2\u0c81\u0c82\3\2"+
		"\2\2\u0c82\u016f\3\2\2\2\u0c83\u0c81\3\2\2\2\u0c84\u0c87\5\u0172\u00ba"+
		"\2\u0c85\u0c87\5\u0134\u009b\2\u0c86\u0c84\3\2\2\2\u0c86\u0c85\3\2\2\2"+
		"\u0c87\u0171\3\2\2\2\u0c88\u0c91\5\u0176\u00bc\2\u0c89\u0c8a\5\u0134\u009b"+
		"\2\u0c8a\u0c8c\7?\2\2\u0c8b\u0c8d\t\36\2\2\u0c8c\u0c8b\3\2\2\2\u0c8c\u0c8d"+
		"\3\2\2\2\u0c8d\u0c8e\3\2\2\2\u0c8e\u0c8f\5\u0174\u00bb\2\u0c8f\u0c91\3"+
		"\2\2\2\u0c90\u0c88\3\2\2\2\u0c90\u0c89\3\2\2\2\u0c91\u0c99\3\2\2\2\u0c92"+
		"\u0c94\7?\2\2\u0c93\u0c95\t\36\2\2\u0c94\u0c93\3\2\2\2\u0c94\u0c95\3\2"+
		"\2\2\u0c95\u0c96\3\2\2\2\u0c96\u0c98\5\u0174\u00bb\2\u0c97\u0c92\3\2\2"+
		"\2\u0c98\u0c9b\3\2\2\2\u0c99\u0c97\3\2\2\2\u0c99\u0c9a\3\2\2\2\u0c9a\u0173"+
		"\3\2\2\2\u0c9b\u0c99\3\2\2\2\u0c9c\u0c9f\5\u0176\u00bc\2\u0c9d\u0c9f\5"+
		"\u0134\u009b\2\u0c9e\u0c9c\3\2\2\2\u0c9e\u0c9d\3\2\2\2\u0c9f\u0175\3\2"+
		"\2\2\u0ca0\u0ca6\5\u0178\u00bd\2\u0ca1\u0ca2\7\u013c\2\2\u0ca2\u0ca3\5"+
		"\u016e\u00b8\2\u0ca3\u0ca4\7\u013d\2\2\u0ca4\u0ca6\3\2\2\2\u0ca5\u0ca0"+
		"\3\2\2\2\u0ca5\u0ca1\3\2\2\2\u0ca6\u0177\3\2\2\2\u0ca7\u0caa\5\u0180\u00c1"+
		"\2\u0ca8\u0caa\5\u017a\u00be\2\u0ca9\u0ca7\3\2\2\2\u0ca9\u0ca8\3\2\2\2"+
		"\u0caa\u0179\3\2\2\2\u0cab\u0cac\7q\2\2\u0cac\u0cad\5\u017c\u00bf\2\u0cad"+
		"\u017b\3\2\2\2\u0cae\u0cb1\5\u017e\u00c0\2\u0caf\u0cb1\5\u0082B\2\u0cb0"+
		"\u0cae\3\2\2\2\u0cb0\u0caf\3\2\2\2\u0cb1\u017d\3\2\2\2\u0cb2\u0cb9\5\u0082"+
		"B\2\u0cb3\u0cb4\7\u0143\2\2\u0cb4\u0cb7\5\u0082B\2\u0cb5\u0cb6\7\u0143"+
		"\2\2\u0cb6\u0cb8\5\u0082B\2\u0cb7\u0cb5\3\2\2\2\u0cb7\u0cb8\3\2\2\2\u0cb8"+
		"\u0cba\3\2\2\2\u0cb9\u0cb3\3\2\2\2\u0cb9\u0cba\3\2\2\2\u0cba\u017f\3\2"+
		"\2\2\u0cbb\u0cbd\7j\2\2\u0cbc\u0cbe\5\u018a\u00c6\2\u0cbd\u0cbc\3\2\2"+
		"\2\u0cbd\u0cbe\3\2\2\2\u0cbe\u0cbf\3\2\2\2\u0cbf\u0cc1\5\u0182\u00c2\2"+
		"\u0cc0\u0cc2\5\u012c\u0097\2\u0cc1\u0cc0\3\2\2\2\u0cc1\u0cc2\3\2\2\2\u0cc2"+
		"\u0181\3\2\2\2\u0cc3\u0cc8\5\u0184\u00c3\2\u0cc4\u0cc5\7\u0135\2\2\u0cc5"+
		"\u0cc7\5\u0184\u00c3\2\u0cc6\u0cc4\3\2\2\2\u0cc7\u0cca\3\2\2\2\u0cc8\u0cc6"+
		"\3\2\2\2\u0cc8\u0cc9\3\2\2\2\u0cc9\u0183\3\2\2\2\u0cca\u0cc8\3\2\2\2\u0ccb"+
		"\u0cce\5\u0186\u00c4\2\u0ccc\u0cce\5\u0188\u00c5\2\u0ccd\u0ccb\3\2\2\2"+
		"\u0ccd\u0ccc\3\2\2\2\u0cce\u0185\3\2\2\2\u0ccf\u0cd1\5\u00e4s\2\u0cd0"+
		"\u0cd2\5\u018e\u00c8\2\u0cd1\u0cd0\3\2\2\2\u0cd1\u0cd2\3\2\2\2\u0cd2\u0187"+
		"\3\2\2\2\u0cd3\u0cd4\7\u014f\2\2\u0cd4\u0cd6\7\u0143\2\2\u0cd5\u0cd3\3"+
		"\2\2\2\u0cd5\u0cd6\3\2\2\2\u0cd6\u0cd7\3\2\2\2\u0cd7\u0cd8\7\u0140\2\2"+
		"\u0cd8\u0189\3\2\2\2\u0cd9\u0cda\t\36\2\2\u0cda\u018b\3\2\2\2\u0cdb\u0cdc"+
		"\5\u0082B\2\u0cdc\u0cdd\7\u0143\2\2\u0cdd\u0cdf\3\2\2\2\u0cde\u0cdb\3"+
		"\2\2\2\u0cde\u0cdf\3\2\2\2\u0cdf\u0ce0\3\2\2\2\u0ce0\u0ce1\5\u0082B\2"+
		"\u0ce1\u018d\3\2\2\2\u0ce2\u0ce4\7\5\2\2\u0ce3\u0ce2\3\2\2\2\u0ce3\u0ce4"+
		"\3\2\2\2\u0ce4\u0ce5\3\2\2\2\u0ce5\u0ce6\5\u0082B\2\u0ce6\u018f\3\2\2"+
		"\2\u0ce7\u0cec\5\u018c\u00c7\2\u0ce8\u0ce9\7\u0135\2\2\u0ce9\u0ceb\5\u018c"+
		"\u00c7\2\u0cea\u0ce8\3\2\2\2\u0ceb\u0cee\3\2\2\2\u0cec\u0cea\3\2\2\2\u0cec"+
		"\u0ced\3\2\2\2\u0ced\u0191\3\2\2\2\u0cee\u0cec\3\2\2\2\u0cef\u0cf0\5\u0198"+
		"\u00cd\2\u0cf0\u0193\3\2\2\2\u0cf1\u0cf2\5\u0198\u00cd\2\u0cf2\u0195\3"+
		"\2\2\2\u0cf3\u0cf4\5\u0198\u00cd\2\u0cf4\u0197\3\2\2\2\u0cf5\u0cf6\7\u013c"+
		"\2\2\u0cf6\u0cf7\5\u016a\u00b6\2\u0cf7\u0cf8\7\u013d\2\2\u0cf8\u0199\3"+
		"\2\2\2\u0cf9\u0d00\5\u019c\u00cf\2\u0cfa\u0d00\5\u01a0\u00d1\2\u0cfb\u0d00"+
		"\5\u01a4\u00d3\2\u0cfc\u0d00\5\u01aa\u00d6\2\u0cfd\u0d00\5\u01b2\u00da"+
		"\2\u0cfe\u0d00\5\u01bc\u00df\2\u0cff\u0cf9\3\2\2\2\u0cff\u0cfa\3\2\2\2"+
		"\u0cff\u0cfb\3\2\2\2\u0cff\u0cfc\3\2\2\2\u0cff\u0cfd\3\2\2\2\u0cff\u0cfe"+
		"\3\2\2\2\u0d00\u019b\3\2\2\2\u0d01\u0d02\5\u0128\u0095\2\u0d02\u0d03\5"+
		"\u019e\u00d0\2\u0d03\u0d04\5\u0128\u0095\2\u0d04\u019d\3\2\2\2\u0d05\u0d06"+
		"\t\37\2\2\u0d06\u019f\3\2\2\2\u0d07\u0d08\5\u0128\u0095\2\u0d08\u0d09"+
		"\5\u01a2\u00d2\2\u0d09\u01a1\3\2\2\2\u0d0a\u0d0c\7M\2\2\u0d0b\u0d0a\3"+
		"\2\2\2\u0d0b\u0d0c\3\2\2\2\u0d0c\u0d0d\3\2\2\2\u0d0d\u0d0f\7\u0086\2\2"+
		"\u0d0e\u0d10\t \2\2\u0d0f\u0d0e\3\2\2\2\u0d0f\u0d10\3\2\2\2\u0d10\u0d11"+
		"\3\2\2\2\u0d11\u0d12\5\u0128\u0095\2\u0d12\u0d13\7\b\2\2\u0d13\u0d14\5"+
		"\u0128\u0095\2\u0d14\u01a3\3\2\2\2\u0d15\u0d17\5\u00e8u\2\u0d16\u0d18"+
		"\7M\2\2\u0d17\u0d16\3\2\2\2\u0d17\u0d18\3\2\2\2\u0d18\u0d19\3\2\2\2\u0d19"+
		"\u0d1a\7:\2\2\u0d1a\u0d1b\5\u01a6\u00d4\2\u0d1b\u01a5\3\2\2\2\u0d1c\u0d22"+
		"\5\u0196\u00cc\2\u0d1d\u0d1e\7\u013c\2\2\u0d1e\u0d1f\5\u01a8\u00d5\2\u0d1f"+
		"\u0d20\7\u013d\2\2\u0d20\u0d22\3\2\2\2\u0d21\u0d1c\3\2\2\2\u0d21\u0d1d"+
		"\3\2\2\2\u0d22\u01a7\3\2\2\2\u0d23\u0d28\5\u0122\u0092\2\u0d24\u0d25\7"+
		"\u0135\2\2\u0d25\u0d27\5\u0122\u0092\2\u0d26\u0d24\3\2\2\2\u0d27\u0d2a"+
		"\3\2\2\2\u0d28\u0d26\3\2\2\2\u0d28\u0d29\3\2\2\2\u0d29\u01a9\3\2\2\2\u0d2a"+
		"\u0d28\3\2\2\2\u0d2b\u0d2c\5\u0128\u0095\2\u0d2c\u0d2d\5\u01ac\u00d7\2"+
		"\u0d2d\u0d2e\7\u0150\2\2\u0d2e\u01ab\3\2\2\2\u0d2f\u0d31\7M\2\2\u0d30"+
		"\u0d2f\3\2\2\2\u0d30\u0d31\3\2\2\2\u0d31\u0d32\3\2\2\2\u0d32\u0d35\5\u01ae"+
		"\u00d8\2\u0d33\u0d35\5\u01b0\u00d9\2\u0d34\u0d30\3\2\2\2\u0d34\u0d33\3"+
		"\2\2\2\u0d35\u01ad\3\2\2\2\u0d36\u0d3d\7I\2\2\u0d37\u0d3d\7\67\2\2\u0d38"+
		"\u0d39\7\u00e6\2\2\u0d39\u0d3d\7\u00f7\2\2\u0d3a\u0d3d\7\u00dc\2\2\u0d3b"+
		"\u0d3d\7\u00df\2\2\u0d3c\u0d36\3\2\2\2\u0d3c\u0d37\3\2\2\2\u0d3c\u0d38"+
		"\3\2\2\2\u0d3c\u0d3a\3\2\2\2\u0d3c\u0d3b\3\2\2\2\u0d3d\u01af\3\2\2\2\u0d3e"+
		"\u0d3f\t!\2\2\u0d3f\u01b1\3\2\2\2\u0d40\u0d41\5\u0128\u0095\2\u0d41\u0d43"+
		"\7D\2\2\u0d42\u0d44\7M\2\2\u0d43\u0d42\3\2\2\2\u0d43\u0d44\3\2\2\2\u0d44"+
		"\u0d45\3\2\2\2\u0d45\u0d46\7N\2\2\u0d46\u01b3\3\2\2\2\u0d47\u0d48\5\u00e8"+
		"u\2\u0d48\u0d49\5\u019e\u00d0\2\u0d49\u0d4a\5\u01b6\u00dc\2\u0d4a\u0d4b"+
		"\5\u0196\u00cc\2\u0d4b\u01b5\3\2\2\2\u0d4c\u0d4f\5\u01b8\u00dd\2\u0d4d"+
		"\u0d4f\5\u01ba\u00de\2\u0d4e\u0d4c\3\2\2\2\u0d4e\u0d4d\3\2\2\2\u0d4f\u01b7"+
		"\3\2\2\2\u0d50\u0d51\7\6\2\2\u0d51\u01b9\3\2\2\2\u0d52\u0d53\t\"\2\2\u0d53"+
		"\u01bb\3\2\2\2\u0d54\u0d56\7M\2\2\u0d55\u0d54\3\2\2\2\u0d55\u0d56\3\2"+
		"\2\2\u0d56\u0d57\3\2\2\2\u0d57\u0d58\7\u00a5\2\2\u0d58\u0d59\5\u0196\u00cc"+
		"\2\u0d59\u01bd\3\2\2\2\u0d5a\u0d5b\7z\2\2\u0d5b\u0d5c\5\u0196\u00cc\2"+
		"\u0d5c\u01bf\3\2\2\2\u0d5d\u0d60\5\u01c2\u00e2\2\u0d5e\u0d60\7\u00e2\2"+
		"\2\u0d5f\u0d5d\3\2\2\2\u0d5f\u0d5e\3\2\2\2\u0d60\u01c1\3\2\2\2\u0d61\u0d62"+
		"\t#\2\2\u0d62\u01c3\3\2\2\2\u0d63\u0d64\t$\2\2\u0d64\u01c5\3\2\2\2\u0d65"+
		"\u0d66\5\u01ca\u00e6\2\u0d66\u0d68\7\u013c\2\2\u0d67\u0d69\5\u01cc\u00e7"+
		"\2\u0d68\u0d67\3\2\2\2\u0d68\u0d69\3\2\2\2\u0d69\u0d6a\3\2\2\2\u0d6a\u0d6b"+
		"\7\u013d\2\2\u0d6b\u01c7\3\2\2\2\u0d6c\u0d6d\t%\2\2\u0d6d\u01c9\3\2\2"+
		"\2\u0d6e\u0d71\5\u0082B\2\u0d6f\u0d71\5\u01c8\u00e5\2\u0d70\u0d6e\3\2"+
		"\2\2\u0d70\u0d6f\3\2\2\2\u0d71\u01cb\3\2\2\2\u0d72\u0d77\5\u00e4s\2\u0d73"+
		"\u0d74\7\u0135\2\2\u0d74\u0d76\5\u00e4s\2\u0d75\u0d73\3\2\2\2\u0d76\u0d79"+
		"\3\2\2\2\u0d77\u0d75\3\2\2\2\u0d77\u0d78\3\2\2\2\u0d78\u01cd\3\2\2\2\u0d79"+
		"\u0d77\3\2\2\2\u0d7a\u0d7b\7U\2\2\u0d7b\u0d7c\7\u0087\2\2\u0d7c\u0d7d"+
		"\5\u01d0\u00e9\2\u0d7d\u01cf\3\2\2\2\u0d7e\u0d83\5\u01d2\u00ea\2\u0d7f"+
		"\u0d80\7\u0135\2\2\u0d80\u0d82\5\u01d2\u00ea\2\u0d81\u0d7f\3\2\2\2\u0d82"+
		"\u0d85\3\2\2\2\u0d83\u0d81\3\2\2\2\u0d83\u0d84\3\2\2\2\u0d84\u01d1\3\2"+
		"\2\2\u0d85\u0d83\3\2\2\2\u0d86\u0d88\5\u0128\u0095\2\u0d87\u0d89\5\u01d4"+
		"\u00eb\2\u0d88\u0d87\3\2\2\2\u0d88\u0d89\3\2\2\2\u0d89\u0d8b\3\2\2\2\u0d8a"+
		"\u0d8c\5\u01d8\u00ed\2\u0d8b\u0d8a\3\2\2\2\u0d8b\u0d8c\3\2\2\2\u0d8c\u01d3"+
		"\3\2\2\2\u0d8d\u0d8e\t&\2\2\u0d8e\u01d5\3\2\2\2\u0d8f\u0d90\7J\2\2\u0d90"+
		"\u0d91\5\u00e8u\2\u0d91\u01d7\3\2\2\2\u0d92\u0d93\7N\2\2\u0d93\u0d97\7"+
		"\u00aa\2\2\u0d94\u0d95\7N\2\2\u0d95\u0d97\7\u00bc\2\2\u0d96\u0d92\3\2"+
		"\2\2\u0d96\u0d94\3\2\2\2\u0d97\u01d9\3\2\2\2\u0d98\u0d9a\7\u00b4\2\2\u0d99"+
		"\u0d9b\7\u00d2\2\2\u0d9a\u0d99\3\2\2\2\u0d9a\u0d9b\3\2\2\2\u0d9b\u0d9c"+
		"\3\2\2\2\u0d9c\u0d9d\7@\2\2\u0d9d\u0da2\5\u017e\u00c0\2\u0d9e\u0d9f\7"+
		"\u013c\2\2\u0d9f\u0da0\5\u014e\u00a8\2\u0da0\u0da1\7\u013d\2\2\u0da1\u0da3"+
		"\3\2\2\2\u0da2\u0d9e\3\2\2\2\u0da2\u0da3\3\2\2\2\u0da3\u0da4\3\2\2\2\u0da4"+
		"\u0da5\5\u016a\u00b6\2\u0da5\u0db6\3\2\2\2\u0da6\u0da8\7\u00b4\2\2\u0da7"+
		"\u0da9\7\u00d2\2\2\u0da8\u0da7\3\2\2\2\u0da8\u0da9\3\2\2\2\u0da9\u0daa"+
		"\3\2\2\2\u0daa\u0dab\7@\2\2\u0dab\u0dac\7\u00bf\2\2\u0dac\u0db2\7\u0150"+
		"\2\2\u0dad\u0dae\7}\2\2\u0dae\u0db0\5\u0082B\2\u0daf\u0db1\5\\/\2\u0db0"+
		"\u0daf\3\2\2\2\u0db0\u0db1\3\2\2\2\u0db1\u0db3\3\2\2\2\u0db2\u0dad\3\2"+
		"\2\2\u0db2\u0db3\3\2\2\2\u0db3\u0db4\3\2\2\2\u0db4\u0db6\5\u016a\u00b6"+
		"\2\u0db5\u0d98\3\2\2\2\u0db5\u0da6\3\2\2\2\u0db6\u01db\3\2\2\2\u01ed\u01de"+
		"\u01e2\u01f0\u01fe\u0209\u020c\u0226\u0236\u023b\u024a\u0255\u0259\u0260"+
		"\u0266\u026d\u0271\u0275\u0279\u027d\u0281\u028b\u028e\u0292\u0296\u029d"+
		"\u02a0\u02a4\u02a6\u02aa\u02b2\u02bb\u02bf\u02c1\u02c3\u02c9\u02ce\u02d4"+
		"\u02d8\u02dc\u02e0\u02e8\u02ea\u02f2\u02f7\u02fb\u02fd\u0301\u0306\u030f"+
		"\u0311\u0319\u031f\u0323\u0329\u032d\u0332\u0336\u033a\u033e\u0342\u0346"+
		"\u034e\u0353\u0357\u0359\u035f\u0363\u036b\u036f\u0371\u0379\u037e\u0382"+
		"\u0384\u038a\u038e\u0396\u039b\u039d\u03a5\u03a9\u03b1\u03b6\u03b8\u03bf"+
		"\u03c3\u03cb\u03d0\u03d2\u03d7\u03df\u03e4\u03e6\u03ec\u03f0\u03f8\u03fd"+
		"\u03ff\u0401\u0405\u0407\u040e\u0412\u041a\u041e\u0422\u0426\u0428\u042e"+
		"\u0432\u043a\u043f\u0441\u0447\u044b\u0453\u0457\u045b\u0460\u0464\u0467"+
		"\u0469\u046d\u0472\u0474\u0476\u0479\u047f\u0483\u0485\u0489\u048d\u0491"+
		"\u0499\u049d\u049f\u04a7\u04ab\u04af\u04b3\u04b7\u04bb\u04bd\u04c1\u04c5"+
		"\u04c9\u04d0\u04d4\u04d8\u04da\u04e0\u04e4\u04ec\u04f0\u04f2\u04f9\u04fd"+
		"\u0501\u0503\u0509\u050d\u0515\u0517\u051f\u0523\u052b\u052d\u0534\u0538"+
		"\u0540\u0542\u0547\u054f\u0551\u0557\u055b\u0562\u0566\u056a\u056c\u0573"+
		"\u0577\u057e\u0582\u0586\u0588\u058e\u0592\u059a\u059c\u05a2\u05a6\u05ac"+
		"\u05b0\u05b5\u05b9\u05be\u05c0\u05c4\u05c8\u05cb\u05cf\u05d4\u05dd\u05e1"+
		"\u0620\u064e\u0656\u0663\u0667\u066b\u067e\u0683\u0693\u0699\u06a2\u06a4"+
		"\u06aa\u06ae\u06b2\u06b6\u06b9\u06bf\u06c2\u06c6\u06cd\u06d3\u06dc\u06e9"+
		"\u06ec\u06f0\u06f3\u06f7\u0702\u0706\u070a\u0710\u0717\u071d\u0721\u0727"+
		"\u072e\u0730\u0732\u073a\u073f\u0749\u0754\u075d\u0762\u0765\u076b\u076f"+
		"\u0777\u077b\u077f\u0788\u078c\u0792\u079a\u079f\u07a8\u07ab\u07ae\u07b2"+
		"\u07b4\u07bb\u07bf\u07c3\u07cb\u07cf\u07d5\u07e1\u07e5\u07e8\u07ec\u07f0"+
		"\u07f6\u07fd\u0804\u0808\u0812\u0816\u081e\u0825\u0829\u0832\u0839\u083d"+
		"\u0845\u0849\u084d\u0855\u085a\u085f\u0861\u0866\u086c\u0870\u0879\u0889"+
		"\u088e\u0893\u0895\u089a\u08a0\u08ac\u08af\u08b3\u08bc\u08c5\u08c7\u08cb"+
		"\u08d3\u08d6\u08dc\u08e4\u08f5\u090a\u091b\u0928\u092c\u092e\u093b\u0942"+
		"\u095a\u0961\u0972\u0975\u0979\u097c\u0980\u0982\u0988\u098d\u0992\u09a2"+
		"\u09b1\u09b9\u09bd\u09c2\u09c7\u09cb\u09ce\u09d7\u09dc\u09e0\u09e6\u09ec"+
		"\u09f1\u09f5\u09f7\u09fb\u09ff\u0a01\u0a05\u0a09\u0a0d\u0a11\u0a1c\u0a20"+
		"\u0a28\u0a32\u0a47\u0a4b\u0a4f\u0a54\u0a56\u0a5a\u0a5f\u0a63\u0a65\u0a69"+
		"\u0a76\u0a7d\u0a89\u0a8b\u0a90\u0ab2\u0ab6\u0aba\u0ac1\u0ac4\u0acc\u0acf"+
		"\u0ae2\u0af2\u0af7\u0afe\u0b06\u0b0a\u0b14\u0b1e\u0b22\u0b32\u0b38\u0b41"+
		"\u0b48\u0b52\u0b55\u0b58\u0b5f\u0b6a\u0b72\u0b78\u0b7c\u0b80\u0b88\u0b8c"+
		"\u0b94\u0b9c\u0ba0\u0ba4\u0ba7\u0baa\u0bad\u0bb0\u0bba\u0bbf\u0bc5\u0bcb"+
		"\u0bd3\u0bda\u0be1\u0be9\u0bf4\u0bf8\u0bfe\u0c0a\u0c0d\u0c13\u0c17\u0c1e"+
		"\u0c20\u0c27\u0c3a\u0c41\u0c48\u0c4f\u0c67\u0c6e\u0c74\u0c78\u0c7c\u0c81"+
		"\u0c86\u0c8c\u0c90\u0c94\u0c99\u0c9e\u0ca5\u0ca9\u0cb0\u0cb7\u0cb9\u0cbd"+
		"\u0cc1\u0cc8\u0ccd\u0cd1\u0cd5\u0cde\u0ce3\u0cec\u0cff\u0d0b\u0d0f\u0d17"+
		"\u0d21\u0d28\u0d30\u0d34\u0d3c\u0d43\u0d4e\u0d55\u0d5f\u0d68\u0d70\u0d77"+
		"\u0d83\u0d88\u0d8b\u0d96\u0d9a\u0da2\u0da8\u0db0\u0db2\u0db5";
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