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
		FUNCTION=44, ISODOW=180, OVERWRITE=206, FUNCTIONS=45, ROW=91, PRECISION=211, 
		ILIKE=52, Character_String_Literal=330, NOT=74, EXCEPT=35, FOREIGN=42, 
		CACHE=133, PRIVILEGES=87, BYTEA=291, MONTH=198, STATEMENT=107, CHARACTER=137, 
		TYPE=242, BlockComment=327, VARBIT=259, STDDEV_POP=229, CREATE=21, COMMENTS=143, 
		ESC_SEQUENCES=331, USING=122, UNLOGGED=244, NOT_EQUAL=305, TIMEZONE_MINUTE=239, 
		VERTICAL_BAR=319, VARIADIC=123, TIMESTAMPTZ=285, REGEXP=216, FAMILY=165, 
		GEQ=309, STDDEV_SAMP=230, DIVIDE=315, BLOB=290, STRICT=108, PRESERVE=85, 
		ASC=8, GROUPING=170, SUBPARTITION=231, KEY=67, SETOF=105, TEMP=111, ELSE=34, 
		NUMBER=325, BOOL=257, TRAILING=114, DEFINER=155, SEMI_COLON=302, INT=266, 
		RLIKE=217, RESTRICT=95, LEADING=68, SERVER=222, PROCEDURAL=89, TABLESPACE=233, 
		MILLISECONDS=194, REAL=271, INTERSECT=60, GROUP=49, LANGUAGE=183, SEQUENCES=102, 
		OUT=80, REAL_NUMBER=326, NONE=201, TRIM=240, LEFT_PAREN=310, LOCATION=188, 
		SEARCH=219, END=33, CONSTRAINT=18, TIMEZONE_HOUR=238, CAST_EXPRESSION=298, 
		OPTION=204, ISOYEAR=181, UUID=287, NCHAR=279, EXECUTE=38, INPUT=176, TABLE=110, 
		VARCHAR=278, FLOAT=273, VERSION=249, IMMUTABLE=54, MICROSECONDS=192, ASYMMETRIC=7, 
		SUM=232, OWNED=84, Space=332, INOUT=62, STORAGE=228, TIME=282, AS=3, RIGHT_PAREN=311, 
		THEN=113, COLLATION=16, MAXVALUE=191, DOUBLE_UNDER_DOLLAR=324, REPLACE=94, 
		LEFT=69, AVG=130, ZONE=255, TRUNCATE=117, COLUMN=141, PLUS=312, EXISTS=162, 
		NVARCHAR=280, Not_Similar_To=295, RETURNS=96, LIKE=70, COLLATE=15, INTEGER=267, 
		OUTER=79, BY=132, DEFERRABLE=26, TO=241, SET=223, RIGHT=98, HAVING=50, 
		MIN=195, SESSION=104, MINUS=313, TEXT=286, HOUR=172, CONCATENATION_OPERATOR=304, 
		CONVERSION=20, UNION=118, CURRENT=149, COLON=301, COMMIT=144, SCHEMA=100, 
		DATABASE=23, DECIMAL=276, DROP=159, BIGINT=268, WHEN=125, ROWS=92, START=227, 
		BIT=258, LARGE=184, REVOKE=97, NATURAL=73, FORMAT=168, PUBLIC=212, AGGREGATE=1, 
		EXTENSION=39, BETWEEN=131, OPTIONS=205, FIRST=167, CAST=14, WEEK=251, 
		EXTERNAL=163, DOUBLE_QUOTE=321, VARYING=248, TRIGGER=115, CASE=12, CHAR=277, 
		INT8=263, COUNT=147, DAY=152, CASCADE=13, COST=146, INT2=261, INT1=260, 
		Identifier=329, INT4=262, ISCACHABLE=179, QUOTE=320, MODULAR=316, INVOKER=64, 
		FULL=43, DICTIONARY=156, THAN=236, QUARTER=214, INSERT=177, INHERITS=57, 
		CONNECT=17, INTERSECTION=178, LESS=186, TINYINT=264, BOTH=11, Similar_To_Case_Insensitive=296, 
		DOUBLE=274, ADMIN=129, SYMMETRIC=109, VOID=293, ISSTRICT=182, EACH=32, 
		LAST=185, COMMENT=142, SELECT=103, INTO=61, UNIQUE=119, COALESCE=140, 
		SECOND=220, ROLE=90, RULE=99, VIEW=124, EPOCH=160, ROLLUP=218, NULL=75, 
		WITHOUT=128, NO=200, EVERY=161, ON=78, MATCH=189, PRIMARY=86, DELETE=28, 
		INET4=292, NUMERIC=275, LOCAL=72, OF=76, EXCLUDING=37, LIST=187, TABLES=234, 
		UNDERLINE=318, SEQUENCE=101, Not_Similar_To_Case_Insensitive=297, CUBE=148, 
		NATIONAL=199, CALLED=134, VAR_POP=247, OR=82, FILTER=166, CHECK=138, FROM=46, 
		FALSE=40, COLLECT=139, PARSER=207, DISTINCT=30, TEMPORARY=112, TIMESTAMP=284, 
		SIMPLE=225, DOLLAR=322, CONSTRAINTS=19, WHERE=126, DEC=153, VAR_SAMP=246, 
		NULLIF=202, CLASS=135, TIMETZ=283, INNER=59, YEAR=254, TIMEZONE=237, ORDER=83, 
		AUTHORIZATION=9, LIMIT=71, DECADE=154, GTH=308, CYCLE=150, White_Space=333, 
		UPDATE=120, MAX=190, LineComment=328, DEFERRED=27, FOR=41, FLOAT4=269, 
		CONFIGURATION=145, FLOAT8=270, AND=5, CROSS=22, Similar_To=294, USAGE=121, 
		IF=51, INDEX=173, OIDS=77, BOOLEAN=256, IN=55, MINVALUE=196, UNKNOWN=243, 
		MULTIPLY=314, OBJECT=203, COMMA=303, REFERENCES=93, PARTITION=209, IS=65, 
		PARTITIONS=210, SOME=106, EQUAL=300, ALL=4, DOUBLE_DOLLAR=323, DOT=317, 
		EXTRACT=164, CENTURY=136, STABLE=226, SECURITY=221, PARTIAL=208, DOW=157, 
		EXCLUDE=36, WITH=127, INITIALLY=58, DOY=158, FUSION=169, GRANT=48, VARBINARY=289, 
		VOLATILE=250, OPERATOR=81, DEFAULT=24, VALUES=245, HASH=171, RANGE=215, 
		MILLENNIUM=193, INDEXES=174, PURGE=213, BEFORE=10, AFTER=2, INSTEAD=63, 
		WRAPPER=253, TRUE=116, PROCEDURE=88, JOIN=66, SIMILAR=224, DOMAIN=31, 
		DEFAULTS=25, LTH=306, INCREMENT=175, ANY=6, TEMPLATE=235, BAD=334, ASSIGN=299, 
		REGCLASS=272, IMMEDIATE=53, WINDOW=252, BINARY=288, DESC=29, DATE=281, 
		MINUTE=197, GLOBAL=47, DATA=151, INCLUDING=56, LEQ=307, SMALLINT=265;
	public static final String[] tokenNames = {
		"<INVALID>", "AGGREGATE", "AFTER", "AS", "ALL", "AND", "ANY", "ASYMMETRIC", 
		"ASC", "AUTHORIZATION", "BEFORE", "BOTH", "CASE", "CASCADE", "CAST", "COLLATE", 
		"COLLATION", "CONNECT", "CONSTRAINT", "CONSTRAINTS", "CONVERSION", "CREATE", 
		"CROSS", "DATABASE", "DEFAULT", "DEFAULTS", "DEFERRABLE", "DEFERRED", 
		"DELETE", "DESC", "DISTINCT", "DOMAIN", "EACH", "END", "ELSE", "EXCEPT", 
		"EXCLUDE", "EXCLUDING", "EXECUTE", "EXTENSION", "FALSE", "FOR", "FOREIGN", 
		"FULL", "FUNCTION", "FUNCTIONS", "FROM", "GLOBAL", "GRANT", "GROUP", "HAVING", 
		"IF", "ILIKE", "IMMEDIATE", "IMMUTABLE", "IN", "INCLUDING", "INHERITS", 
		"INITIALLY", "INNER", "INTERSECT", "INTO", "INOUT", "INSTEAD", "INVOKER", 
		"IS", "JOIN", "KEY", "LEADING", "LEFT", "LIKE", "LIMIT", "LOCAL", "NATURAL", 
		"NOT", "NULL", "OF", "OIDS", "ON", "OUTER", "OUT", "OPERATOR", "OR", "ORDER", 
		"OWNED", "PRESERVE", "PRIMARY", "PRIVILEGES", "PROCEDURE", "PROCEDURAL", 
		"ROLE", "ROW", "ROWS", "REFERENCES", "REPLACE", "RESTRICT", "RETURNS", 
		"REVOKE", "RIGHT", "RULE", "SCHEMA", "SEQUENCE", "SEQUENCES", "SELECT", 
		"SESSION", "SETOF", "SOME", "STATEMENT", "STRICT", "SYMMETRIC", "TABLE", 
		"TEMP", "TEMPORARY", "THEN", "TRAILING", "TRIGGER", "TRUE", "TRUNCATE", 
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
		"NO", "NONE", "NULLIF", "OBJECT", "OPTION", "OPTIONS", "OVERWRITE", "PARSER", 
		"PARTIAL", "PARTITION", "PARTITIONS", "PRECISION", "PUBLIC", "PURGE", 
		"QUARTER", "RANGE", "REGEXP", "RLIKE", "ROLLUP", "SEARCH", "SECOND", "SECURITY", 
		"SERVER", "SET", "SIMILAR", "SIMPLE", "STABLE", "START", "STORAGE", "STDDEV_POP", 
		"STDDEV_SAMP", "SUBPARTITION", "SUM", "TABLESPACE", "TABLES", "TEMPLATE", 
		"THAN", "TIMEZONE", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", "TRIM", "TO", 
		"TYPE", "UNKNOWN", "UNLOGGED", "VALUES", "VAR_SAMP", "VAR_POP", "VARYING", 
		"VERSION", "VOLATILE", "WEEK", "WINDOW", "WRAPPER", "YEAR", "ZONE", "BOOLEAN", 
		"BOOL", "BIT", "VARBIT", "INT1", "INT2", "INT4", "INT8", "TINYINT", "SMALLINT", 
		"INT", "INTEGER", "BIGINT", "FLOAT4", "FLOAT8", "REAL", "REGCLASS", "FLOAT", 
		"DOUBLE", "NUMERIC", "DECIMAL", "CHAR", "VARCHAR", "NCHAR", "NVARCHAR", 
		"DATE", "TIME", "TIMETZ", "TIMESTAMP", "TIMESTAMPTZ", "TEXT", "UUID", 
		"BINARY", "VARBINARY", "BLOB", "BYTEA", "INET4", "VOID", "'~'", "'!~'", 
		"'~*'", "'!~*'", "CAST_EXPRESSION", "':='", "'='", "':'", "';'", "','", 
		"CONCATENATION_OPERATOR", "NOT_EQUAL", "'<'", "'<='", "'>'", "'>='", "'('", 
		"')'", "'+'", "'-'", "'*'", "'/'", "'%'", "'.'", "'_'", "'|'", "'''", 
		"'\"'", "'$'", "'$$'", "'$_$'", "NUMBER", "REAL_NUMBER", "BlockComment", 
		"LineComment", "Identifier", "Character_String_Literal", "ESC_SEQUENCES", 
		"' '", "White_Space", "BAD"
	};
	public static final int
		RULE_sql = 0, RULE_statement = 1, RULE_data_statement = 2, RULE_data_change_statement = 3, 
		RULE_schema_statement = 4, RULE_index_statement = 5, RULE_create_extension_statement = 6, 
		RULE_set_statement = 7, RULE_create_trigger_statement = 8, RULE_revoke_statement = 9, 
		RULE_revoke_from_cascade_restrict = 10, RULE_grant_statement = 11, RULE_grant_to_rule = 12, 
		RULE_comment_on_statement = 13, RULE_create_function_statement = 14, RULE_function_body = 15, 
		RULE_function_body_separator = 16, RULE_function_body_separator_dollar_under = 17, 
		RULE_function_attribute = 18, RULE_argmode = 19, RULE_function_definition = 20, 
		RULE_functions_definition_schema = 21, RULE_create_sequence_statement = 22, 
		RULE_create_schema_statement = 23, RULE_create_view_statement = 24, RULE_query = 25, 
		RULE_create_table_statement = 26, RULE_like_option = 27, RULE_table_constraint = 28, 
		RULE_column_constraint = 29, RULE_check_boolean_expression = 30, RULE_storage_parameter = 31, 
		RULE_storage_parameter_oid = 32, RULE_on_commit = 33, RULE_table_space = 34, 
		RULE_action = 35, RULE_index_parameters = 36, RULE_table_elements = 37, 
		RULE_field_element = 38, RULE_field_type = 39, RULE_param_clause = 40, 
		RULE_param = 41, RULE_method_specifier = 42, RULE_table_space_specifier = 43, 
		RULE_table_space_name = 44, RULE_table_partitioning_clauses = 45, RULE_range_partitions = 46, 
		RULE_range_value_clause_list = 47, RULE_range_value_clause = 48, RULE_hash_partitions = 49, 
		RULE_individual_hash_partitions = 50, RULE_individual_hash_partition = 51, 
		RULE_hash_partitions_by_quantity = 52, RULE_list_partitions = 53, RULE_list_value_clause_list = 54, 
		RULE_list_value_partition = 55, RULE_column_partitions = 56, RULE_partition_name = 57, 
		RULE_drop_table_statement = 58, RULE_identifier = 59, RULE_nonreserved_keywords = 60, 
		RULE_unsigned_literal = 61, RULE_general_literal = 62, RULE_datetime_literal = 63, 
		RULE_time_literal = 64, RULE_timestamp_literal = 65, RULE_date_literal = 66, 
		RULE_boolean_literal = 67, RULE_data_type = 68, RULE_predefined_type = 69, 
		RULE_regclass = 70, RULE_network_type = 71, RULE_character_string_type = 72, 
		RULE_type_length = 73, RULE_national_character_string_type = 74, RULE_binary_large_object_string_type = 75, 
		RULE_numeric_type = 76, RULE_exact_numeric_type = 77, RULE_approximate_numeric_type = 78, 
		RULE_precision_param = 79, RULE_boolean_type = 80, RULE_datetime_type = 81, 
		RULE_bit_type = 82, RULE_binary_type = 83, RULE_value_expression_primary = 84, 
		RULE_parenthesized_value_expression = 85, RULE_nonparenthesized_value_expression_primary = 86, 
		RULE_unsigned_value_specification = 87, RULE_unsigned_numeric_literal = 88, 
		RULE_signed_numerical_literal = 89, RULE_set_function_specification = 90, 
		RULE_aggregate_function = 91, RULE_general_set_function = 92, RULE_set_function_type = 93, 
		RULE_filter_clause = 94, RULE_grouping_operation = 95, RULE_case_expression = 96, 
		RULE_case_abbreviation = 97, RULE_case_specification = 98, RULE_simple_case = 99, 
		RULE_searched_case = 100, RULE_simple_when_clause = 101, RULE_searched_when_clause = 102, 
		RULE_else_clause = 103, RULE_result = 104, RULE_cast_specification = 105, 
		RULE_cast_operand = 106, RULE_cast_target = 107, RULE_value_expression = 108, 
		RULE_common_value_expression = 109, RULE_numeric_value_expression = 110, 
		RULE_term = 111, RULE_factor = 112, RULE_array = 113, RULE_numeric_primary = 114, 
		RULE_sign = 115, RULE_numeric_value_function = 116, RULE_extract_expression = 117, 
		RULE_extract_field = 118, RULE_time_zone_field = 119, RULE_extract_source = 120, 
		RULE_string_value_expression = 121, RULE_character_value_expression = 122, 
		RULE_character_factor = 123, RULE_character_primary = 124, RULE_string_value_function = 125, 
		RULE_trim_function = 126, RULE_trim_operands = 127, RULE_trim_specification = 128, 
		RULE_boolean_value_expression = 129, RULE_or_predicate = 130, RULE_and_predicate = 131, 
		RULE_boolean_factor = 132, RULE_boolean_test = 133, RULE_is_clause = 134, 
		RULE_truth_value = 135, RULE_boolean_primary = 136, RULE_boolean_predicand = 137, 
		RULE_parenthesized_boolean_value_expression = 138, RULE_row_value_expression = 139, 
		RULE_row_value_special_case = 140, RULE_explicit_row_value_constructor = 141, 
		RULE_row_value_predicand = 142, RULE_row_value_constructor_predicand = 143, 
		RULE_table_expression = 144, RULE_from_clause = 145, RULE_table_reference_list = 146, 
		RULE_table_reference = 147, RULE_joined_table = 148, RULE_joined_table_primary = 149, 
		RULE_cross_join = 150, RULE_qualified_join = 151, RULE_natural_join = 152, 
		RULE_union_join = 153, RULE_join_type = 154, RULE_outer_join_type = 155, 
		RULE_outer_join_type_part2 = 156, RULE_join_specification = 157, RULE_join_condition = 158, 
		RULE_named_columns_join = 159, RULE_table_primary = 160, RULE_column_name_list = 161, 
		RULE_derived_table = 162, RULE_where_clause = 163, RULE_search_condition = 164, 
		RULE_groupby_clause = 165, RULE_grouping_element_list = 166, RULE_grouping_element = 167, 
		RULE_ordinary_grouping_set = 168, RULE_ordinary_grouping_set_list = 169, 
		RULE_rollup_list = 170, RULE_cube_list = 171, RULE_empty_grouping_set = 172, 
		RULE_having_clause = 173, RULE_row_value_predicand_list = 174, RULE_query_expression = 175, 
		RULE_query_expression_body = 176, RULE_non_join_query_expression = 177, 
		RULE_query_term = 178, RULE_non_join_query_term = 179, RULE_query_primary = 180, 
		RULE_non_join_query_primary = 181, RULE_simple_table = 182, RULE_explicit_table = 183, 
		RULE_table_or_query_name = 184, RULE_schema_qualified_name = 185, RULE_query_specification = 186, 
		RULE_select_list = 187, RULE_select_sublist = 188, RULE_derived_column = 189, 
		RULE_qualified_asterisk = 190, RULE_set_qualifier = 191, RULE_column_reference = 192, 
		RULE_as_clause = 193, RULE_column_reference_list = 194, RULE_scalar_subquery = 195, 
		RULE_row_subquery = 196, RULE_table_subquery = 197, RULE_subquery = 198, 
		RULE_predicate = 199, RULE_comparison_predicate = 200, RULE_comp_op = 201, 
		RULE_between_predicate = 202, RULE_between_predicate_part_2 = 203, RULE_in_predicate = 204, 
		RULE_in_predicate_value = 205, RULE_in_value_list = 206, RULE_pattern_matching_predicate = 207, 
		RULE_pattern_matcher = 208, RULE_negativable_matcher = 209, RULE_regex_matcher = 210, 
		RULE_null_predicate = 211, RULE_quantified_comparison_predicate = 212, 
		RULE_quantifier = 213, RULE_all = 214, RULE_some = 215, RULE_exists_predicate = 216, 
		RULE_unique_predicate = 217, RULE_primary_datetime_field = 218, RULE_non_second_primary_datetime_field = 219, 
		RULE_extended_datetime_field = 220, RULE_routine_invocation = 221, RULE_function_names_for_reserved_words = 222, 
		RULE_function_name = 223, RULE_sql_argument_list = 224, RULE_orderby_clause = 225, 
		RULE_sort_specifier_list = 226, RULE_sort_specifier = 227, RULE_order_specification = 228, 
		RULE_limit_clause = 229, RULE_null_ordering = 230, RULE_insert_statement = 231;
	public static final String[] ruleNames = {
		"sql", "statement", "data_statement", "data_change_statement", "schema_statement", 
		"index_statement", "create_extension_statement", "set_statement", "create_trigger_statement", 
		"revoke_statement", "revoke_from_cascade_restrict", "grant_statement", 
		"grant_to_rule", "comment_on_statement", "create_function_statement", 
		"function_body", "function_body_separator", "function_body_separator_dollar_under", 
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
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CREATE || _la==GRANT || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (REVOKE - 97)) | (1L << (SELECT - 97)) | (1L << (TABLE - 97)) | (1L << (ADMIN - 97)) | (1L << (AVG - 97)) | (1L << (BETWEEN - 97)) | (1L << (BY - 97)) | (1L << (CACHE - 97)) | (1L << (CALLED - 97)) | (1L << (CLASS - 97)) | (1L << (CENTURY - 97)) | (1L << (CHARACTER - 97)) | (1L << (CHECK - 97)) | (1L << (COLLECT - 97)) | (1L << (COALESCE - 97)) | (1L << (COLUMN - 97)) | (1L << (COMMENT - 97)) | (1L << (COMMENTS - 97)) | (1L << (COMMIT - 97)) | (1L << (CONFIGURATION - 97)) | (1L << (COST - 97)) | (1L << (COUNT - 97)) | (1L << (CUBE - 97)) | (1L << (CURRENT - 97)) | (1L << (CYCLE - 97)) | (1L << (DATA - 97)) | (1L << (DAY - 97)) | (1L << (DEC - 97)) | (1L << (DECADE - 97)) | (1L << (DEFINER - 97)) | (1L << (DICTIONARY - 97)) | (1L << (DOW - 97)) | (1L << (DOY - 97)) | (1L << (DROP - 97)) | (1L << (EPOCH - 97)))) != 0) || ((((_la - 161)) & ~0x3f) == 0 && ((1L << (_la - 161)) & ((1L << (EVERY - 161)) | (1L << (EXISTS - 161)) | (1L << (EXTERNAL - 161)) | (1L << (EXTRACT - 161)) | (1L << (FAMILY - 161)) | (1L << (FILTER - 161)) | (1L << (FIRST - 161)) | (1L << (FORMAT - 161)) | (1L << (FUSION - 161)) | (1L << (GROUPING - 161)) | (1L << (HASH - 161)) | (1L << (INDEX - 161)) | (1L << (INCREMENT - 161)) | (1L << (INPUT - 161)) | (1L << (INSERT - 161)) | (1L << (INTERSECTION - 161)) | (1L << (ISCACHABLE - 161)) | (1L << (ISODOW - 161)) | (1L << (ISOYEAR - 161)) | (1L << (ISSTRICT - 161)) | (1L << (LANGUAGE - 161)) | (1L << (LARGE - 161)) | (1L << (LAST - 161)) | (1L << (LESS - 161)) | (1L << (LIST - 161)) | (1L << (LOCATION - 161)) | (1L << (MATCH - 161)) | (1L << (MAX - 161)) | (1L << (MAXVALUE - 161)) | (1L << (MICROSECONDS - 161)) | (1L << (MILLENNIUM - 161)) | (1L << (MILLISECONDS - 161)) | (1L << (MIN - 161)) | (1L << (MINVALUE - 161)) | (1L << (MINUTE - 161)) | (1L << (MONTH - 161)) | (1L << (NATIONAL - 161)) | (1L << (NO - 161)) | (1L << (NONE - 161)) | (1L << (NULLIF - 161)) | (1L << (OBJECT - 161)) | (1L << (OPTION - 161)) | (1L << (OPTIONS - 161)) | (1L << (OVERWRITE - 161)) | (1L << (PARSER - 161)) | (1L << (PARTIAL - 161)) | (1L << (PARTITION - 161)) | (1L << (PARTITIONS - 161)) | (1L << (PRECISION - 161)) | (1L << (PUBLIC - 161)) | (1L << (PURGE - 161)) | (1L << (QUARTER - 161)) | (1L << (RANGE - 161)) | (1L << (REGEXP - 161)) | (1L << (RLIKE - 161)) | (1L << (ROLLUP - 161)) | (1L << (SEARCH - 161)) | (1L << (SECOND - 161)) | (1L << (SECURITY - 161)) | (1L << (SERVER - 161)) | (1L << (SET - 161)) | (1L << (SIMILAR - 161)))) != 0) || ((((_la - 225)) & ~0x3f) == 0 && ((1L << (_la - 225)) & ((1L << (SIMPLE - 225)) | (1L << (STABLE - 225)) | (1L << (START - 225)) | (1L << (STORAGE - 225)) | (1L << (STDDEV_POP - 225)) | (1L << (STDDEV_SAMP - 225)) | (1L << (SUBPARTITION - 225)) | (1L << (SUM - 225)) | (1L << (TABLESPACE - 225)) | (1L << (TEMPLATE - 225)) | (1L << (THAN - 225)) | (1L << (TIMEZONE - 225)) | (1L << (TIMEZONE_HOUR - 225)) | (1L << (TIMEZONE_MINUTE - 225)) | (1L << (TRIM - 225)) | (1L << (TO - 225)) | (1L << (TYPE - 225)) | (1L << (UNKNOWN - 225)) | (1L << (UNLOGGED - 225)) | (1L << (VALUES - 225)) | (1L << (VAR_SAMP - 225)) | (1L << (VAR_POP - 225)) | (1L << (VARYING - 225)) | (1L << (VOLATILE - 225)) | (1L << (WEEK - 225)) | (1L << (WINDOW - 225)) | (1L << (WRAPPER - 225)) | (1L << (YEAR - 225)) | (1L << (ZONE - 225)) | (1L << (BOOLEAN - 225)) | (1L << (BOOL - 225)) | (1L << (BIT - 225)) | (1L << (VARBIT - 225)) | (1L << (INT1 - 225)) | (1L << (INT2 - 225)) | (1L << (INT4 - 225)) | (1L << (INT8 - 225)) | (1L << (TINYINT - 225)) | (1L << (SMALLINT - 225)) | (1L << (INT - 225)) | (1L << (INTEGER - 225)) | (1L << (BIGINT - 225)) | (1L << (FLOAT4 - 225)) | (1L << (FLOAT8 - 225)) | (1L << (REAL - 225)) | (1L << (FLOAT - 225)) | (1L << (DOUBLE - 225)) | (1L << (NUMERIC - 225)) | (1L << (DECIMAL - 225)) | (1L << (CHAR - 225)) | (1L << (VARCHAR - 225)) | (1L << (NCHAR - 225)) | (1L << (NVARCHAR - 225)) | (1L << (DATE - 225)) | (1L << (TIME - 225)) | (1L << (TIMETZ - 225)) | (1L << (TIMESTAMP - 225)) | (1L << (TIMESTAMPTZ - 225)) | (1L << (TEXT - 225)) | (1L << (UUID - 225)))) != 0) || ((((_la - 289)) & ~0x3f) == 0 && ((1L << (_la - 289)) & ((1L << (VARBINARY - 289)) | (1L << (BLOB - 289)) | (1L << (BYTEA - 289)) | (1L << (INET4 - 289)) | (1L << (VOID - 289)) | (1L << (LEFT_PAREN - 289)) | (1L << (DOUBLE_QUOTE - 289)) | (1L << (Identifier - 289)))) != 0)) {
				{
				{
				setState(464); statement();
				setState(466);
				_la = _input.LA(1);
				if (_la==SEMI_COLON) {
					{
					setState(465); match(SEMI_COLON);
					}
				}

				}
				}
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(473); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
		public Create_function_statementContext create_function_statement() {
			return getRuleContext(Create_function_statementContext.class,0);
		}
		public Create_sequence_statementContext create_sequence_statement() {
			return getRuleContext(Create_sequence_statementContext.class,0);
		}
		public Data_statementContext data_statement() {
			return getRuleContext(Data_statementContext.class,0);
		}
		public Index_statementContext index_statement() {
			return getRuleContext(Index_statementContext.class,0);
		}
		public Schema_statementContext schema_statement() {
			return getRuleContext(Schema_statementContext.class,0);
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
		public Create_schema_statementContext create_schema_statement() {
			return getRuleContext(Create_schema_statementContext.class,0);
		}
		public Grant_statementContext grant_statement() {
			return getRuleContext(Grant_statementContext.class,0);
		}
		public Create_trigger_statementContext create_trigger_statement() {
			return getRuleContext(Create_trigger_statementContext.class,0);
		}
		public Create_view_statementContext create_view_statement() {
			return getRuleContext(Create_view_statementContext.class,0);
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
			setState(488);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(475); data_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(476); schema_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(477); index_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(478); create_extension_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(479); set_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(480); create_trigger_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(481); grant_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(482); revoke_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(483); comment_on_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(484); create_function_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(485); create_sequence_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(486); create_schema_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(487); create_view_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
			setState(490); query_expression();
			}
		}
		catch (RecognitionException re) {
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
			setState(492); insert_statement();
			}
		}
		catch (RecognitionException re) {
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
		public Create_table_statementContext create_table_statement() {
			return getRuleContext(Create_table_statementContext.class,0);
		}
		public Drop_table_statementContext drop_table_statement() {
			return getRuleContext(Drop_table_statementContext.class,0);
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
			setState(496);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(494); create_table_statement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(495); drop_table_statement();
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
		enterRule(_localctx, 10, RULE_index_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498); match(CREATE);
			setState(500);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(499); ((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(502); match(INDEX);
			setState(503); ((Index_statementContext)_localctx).n = identifier();
			setState(504); match(ON);
			setState(505); ((Index_statementContext)_localctx).t = schema_qualified_name();
			setState(507);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(506); ((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(509); match(LEFT_PAREN);
			setState(510); ((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(511); match(RIGHT_PAREN);
			setState(513);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(512); ((Index_statementContext)_localctx).p = param_clause();
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
		enterRule(_localctx, 12, RULE_create_extension_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515); match(CREATE);
			setState(516); match(EXTENSION);
			setState(520);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(517); match(IF);
				setState(518); match(NOT);
				setState(519); match(EXISTS);
				}
			}

			setState(522); ((Create_extension_statementContext)_localctx).name = identifier();
			setState(524);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(523); match(WITH);
				}
			}

			setState(528);
			_la = _input.LA(1);
			if (_la==SCHEMA) {
				{
				setState(526); match(SCHEMA);
				setState(527); ((Create_extension_statementContext)_localctx).schema_name = identifier();
				}
			}

			setState(532);
			_la = _input.LA(1);
			if (_la==VERSION) {
				{
				setState(530); match(VERSION);
				setState(531); ((Create_extension_statementContext)_localctx).version = identifier();
				}
			}

			setState(536);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(534); match(FROM);
				setState(535); ((Create_extension_statementContext)_localctx).old_version = identifier();
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
		public IdentifierContext value;
		public IdentifierContext timezone;
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode QUOTE(int i) {
			return getToken(SQLParser.QUOTE, i);
		}
		public TerminalNode SESSION() { return getToken(SQLParser.SESSION, 0); }
		public TerminalNode TIME() { return getToken(SQLParser.TIME, 0); }
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
		enterRule(_localctx, 14, RULE_set_statement);
		int _la;
		try {
			int _alt;
			setState(577);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(538); match(SET);
				setState(540);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(539);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(542); ((Set_statementContext)_localctx).config_param = identifier();
				setState(543);
				_la = _input.LA(1);
				if ( !(_la==TO || _la==EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(555); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(550);
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
							setState(544); ((Set_statementContext)_localctx).value = identifier();
							}
							break;
						case QUOTE:
							{
							setState(545); match(QUOTE);
							setState(546); ((Set_statementContext)_localctx).value = identifier();
							setState(547); match(QUOTE);
							}
							break;
						case DEFAULT:
							{
							setState(549); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(553);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(552); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(557); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(559); match(SET);
				setState(561);
				_la = _input.LA(1);
				if (_la==LOCAL || _la==SESSION) {
					{
					setState(560);
					_la = _input.LA(1);
					if ( !(_la==LOCAL || _la==SESSION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(563); match(TIME);
				setState(564); match(ZONE);
				setState(573); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(568);
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
							setState(565); ((Set_statementContext)_localctx).timezone = identifier();
							}
							break;
						case LOCAL:
							{
							setState(566); match(LOCAL);
							}
							break;
						case DEFAULT:
							{
							setState(567); match(DEFAULT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(571);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(570); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(575); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		enterRule(_localctx, 16, RULE_create_trigger_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579); match(CREATE);
			setState(581);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(580); match(CONSTRAINT);
				}
			}

			setState(583); match(TRIGGER);
			setState(584); ((Create_trigger_statementContext)_localctx).name = identifier();
			setState(589);
			switch (_input.LA(1)) {
			case BEFORE:
				{
				setState(585); match(BEFORE);
				}
				break;
			case INSTEAD:
				{
				{
				setState(586); match(INSTEAD);
				setState(587); match(OF);
				}
				}
				break;
			case AFTER:
				{
				setState(588); match(AFTER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(606);
			switch (_input.LA(1)) {
			case INSERT:
				{
				setState(591); match(INSERT);
				}
				break;
			case DELETE:
				{
				setState(592); match(DELETE);
				}
				break;
			case TRUNCATE:
				{
				setState(593); match(TRUNCATE);
				}
				break;
			case UPDATE:
				{
				{
				setState(594); match(UPDATE);
				setState(604);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(595); match(OF);
					setState(600); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(596); ((Create_trigger_statementContext)_localctx).columnName = identifier();
						setState(598);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(597); match(COMMA);
							}
						}

						}
						}
						setState(602); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(608); match(ON);
			setState(609); ((Create_trigger_statementContext)_localctx).tabl_name = schema_qualified_name();
			setState(612);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(610); match(FROM);
				setState(611); ((Create_trigger_statementContext)_localctx).referenced_table_name = schema_qualified_name();
				}
			}

			setState(623);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(614); match(NOT);
				setState(615); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				setState(617);
				_la = _input.LA(1);
				if (_la==DEFERRABLE) {
					{
					setState(616); match(DEFERRABLE);
					}
				}

				{
				setState(619); match(INITIALLY);
				setState(620); match(IMMEDIATE);
				}
				}
				break;
			case 3:
				{
				{
				setState(621); match(INITIALLY);
				setState(622); match(DEFERRED);
				}
				}
				break;
			}
			setState(631);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(625); match(FOR);
				setState(627);
				_la = _input.LA(1);
				if (_la==EACH) {
					{
					setState(626); match(EACH);
					}
				}

				setState(629); match(ROW);
				}
				break;
			case STATEMENT:
				{
				setState(630); match(STATEMENT);
				}
				break;
			case EXECUTE:
			case WHEN:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(635);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(633); match(WHEN);
				{
				setState(634); boolean_value_expression();
				}
				}
			}

			setState(637); match(EXECUTE);
			setState(638); match(PROCEDURE);
			setState(639); ((Create_trigger_statementContext)_localctx).func_name = identifier();
			setState(640); match(LEFT_PAREN);
			setState(645);
			_la = _input.LA(1);
			if (((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier) {
				{
				setState(641); ((Create_trigger_statementContext)_localctx).arguments = identifier();
				setState(643);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(642); match(COMMA);
					}
				}

				}
			}

			setState(647); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 18, RULE_revoke_statement);
		int _la;
		try {
			int _alt;
			setState(1028);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(649); match(REVOKE);
				setState(653);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(650); match(GRANT);
					setState(651); match(OPTION);
					setState(652); match(FOR);
					}
				}

				setState(664);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(656); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(655);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(658); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(660); match(ALL);
					setState(662);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(661); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(666); match(ON);
				setState(684);
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
					setState(671); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(668);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(667); match(TABLE);
							}
						}

						setState(670); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
						}
						}
						setState(673); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & ((1L << (TABLE - 110)) | (1L << (ADMIN - 110)) | (1L << (AVG - 110)) | (1L << (BETWEEN - 110)) | (1L << (BY - 110)) | (1L << (CACHE - 110)) | (1L << (CALLED - 110)) | (1L << (CLASS - 110)) | (1L << (CENTURY - 110)) | (1L << (CHARACTER - 110)) | (1L << (CHECK - 110)) | (1L << (COLLECT - 110)) | (1L << (COALESCE - 110)) | (1L << (COLUMN - 110)) | (1L << (COMMENT - 110)) | (1L << (COMMENTS - 110)) | (1L << (COMMIT - 110)) | (1L << (CONFIGURATION - 110)) | (1L << (COST - 110)) | (1L << (COUNT - 110)) | (1L << (CUBE - 110)) | (1L << (CURRENT - 110)) | (1L << (CYCLE - 110)) | (1L << (DATA - 110)) | (1L << (DAY - 110)) | (1L << (DEC - 110)) | (1L << (DECADE - 110)) | (1L << (DEFINER - 110)) | (1L << (DICTIONARY - 110)) | (1L << (DOW - 110)) | (1L << (DOY - 110)) | (1L << (DROP - 110)) | (1L << (EPOCH - 110)) | (1L << (EVERY - 110)) | (1L << (EXISTS - 110)) | (1L << (EXTERNAL - 110)) | (1L << (EXTRACT - 110)) | (1L << (FAMILY - 110)) | (1L << (FILTER - 110)) | (1L << (FIRST - 110)) | (1L << (FORMAT - 110)) | (1L << (FUSION - 110)) | (1L << (GROUPING - 110)) | (1L << (HASH - 110)) | (1L << (INDEX - 110)))) != 0) || ((((_la - 175)) & ~0x3f) == 0 && ((1L << (_la - 175)) & ((1L << (INCREMENT - 175)) | (1L << (INPUT - 175)) | (1L << (INSERT - 175)) | (1L << (INTERSECTION - 175)) | (1L << (ISCACHABLE - 175)) | (1L << (ISODOW - 175)) | (1L << (ISOYEAR - 175)) | (1L << (ISSTRICT - 175)) | (1L << (LANGUAGE - 175)) | (1L << (LARGE - 175)) | (1L << (LAST - 175)) | (1L << (LESS - 175)) | (1L << (LIST - 175)) | (1L << (LOCATION - 175)) | (1L << (MATCH - 175)) | (1L << (MAX - 175)) | (1L << (MAXVALUE - 175)) | (1L << (MICROSECONDS - 175)) | (1L << (MILLENNIUM - 175)) | (1L << (MILLISECONDS - 175)) | (1L << (MIN - 175)) | (1L << (MINVALUE - 175)) | (1L << (MINUTE - 175)) | (1L << (MONTH - 175)) | (1L << (NATIONAL - 175)) | (1L << (NO - 175)) | (1L << (NONE - 175)) | (1L << (NULLIF - 175)) | (1L << (OBJECT - 175)) | (1L << (OPTION - 175)) | (1L << (OPTIONS - 175)) | (1L << (OVERWRITE - 175)) | (1L << (PARSER - 175)) | (1L << (PARTIAL - 175)) | (1L << (PARTITION - 175)) | (1L << (PARTITIONS - 175)) | (1L << (PRECISION - 175)) | (1L << (PUBLIC - 175)) | (1L << (PURGE - 175)) | (1L << (QUARTER - 175)) | (1L << (RANGE - 175)) | (1L << (REGEXP - 175)) | (1L << (RLIKE - 175)) | (1L << (ROLLUP - 175)) | (1L << (SEARCH - 175)) | (1L << (SECOND - 175)) | (1L << (SECURITY - 175)) | (1L << (SERVER - 175)) | (1L << (SET - 175)) | (1L << (SIMILAR - 175)) | (1L << (SIMPLE - 175)) | (1L << (STABLE - 175)) | (1L << (START - 175)) | (1L << (STORAGE - 175)) | (1L << (STDDEV_POP - 175)) | (1L << (STDDEV_SAMP - 175)) | (1L << (SUBPARTITION - 175)) | (1L << (SUM - 175)) | (1L << (TABLESPACE - 175)) | (1L << (TEMPLATE - 175)) | (1L << (THAN - 175)) | (1L << (TIMEZONE - 175)) | (1L << (TIMEZONE_HOUR - 175)))) != 0) || ((((_la - 239)) & ~0x3f) == 0 && ((1L << (_la - 239)) & ((1L << (TIMEZONE_MINUTE - 239)) | (1L << (TRIM - 239)) | (1L << (TO - 239)) | (1L << (TYPE - 239)) | (1L << (UNKNOWN - 239)) | (1L << (UNLOGGED - 239)) | (1L << (VALUES - 239)) | (1L << (VAR_SAMP - 239)) | (1L << (VAR_POP - 239)) | (1L << (VARYING - 239)) | (1L << (VOLATILE - 239)) | (1L << (WEEK - 239)) | (1L << (WINDOW - 239)) | (1L << (WRAPPER - 239)) | (1L << (YEAR - 239)) | (1L << (ZONE - 239)) | (1L << (BOOLEAN - 239)) | (1L << (BOOL - 239)) | (1L << (BIT - 239)) | (1L << (VARBIT - 239)) | (1L << (INT1 - 239)) | (1L << (INT2 - 239)) | (1L << (INT4 - 239)) | (1L << (INT8 - 239)) | (1L << (TINYINT - 239)) | (1L << (SMALLINT - 239)) | (1L << (INT - 239)) | (1L << (INTEGER - 239)) | (1L << (BIGINT - 239)) | (1L << (FLOAT4 - 239)) | (1L << (FLOAT8 - 239)) | (1L << (REAL - 239)) | (1L << (FLOAT - 239)) | (1L << (DOUBLE - 239)) | (1L << (NUMERIC - 239)) | (1L << (DECIMAL - 239)) | (1L << (CHAR - 239)) | (1L << (VARCHAR - 239)) | (1L << (NCHAR - 239)) | (1L << (NVARCHAR - 239)) | (1L << (DATE - 239)) | (1L << (TIME - 239)) | (1L << (TIMETZ - 239)) | (1L << (TIMESTAMP - 239)) | (1L << (TIMESTAMPTZ - 239)) | (1L << (TEXT - 239)) | (1L << (UUID - 239)) | (1L << (VARBINARY - 239)) | (1L << (BLOB - 239)) | (1L << (BYTEA - 239)) | (1L << (INET4 - 239)) | (1L << (VOID - 239)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					}
					break;
				case ALL:
					{
					setState(675); match(ALL);
					setState(676); match(TABLES);
					setState(677); match(IN);
					setState(678); match(SCHEMA);
					setState(680); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(679); ((Revoke_statementContext)_localctx).schema_name = identifier();
						}
						}
						setState(682); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(686); revoke_from_cascade_restrict();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(688); match(REVOKE);
				setState(692);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(689); match(GRANT);
					setState(690); match(OPTION);
					setState(691); match(FOR);
					}
				}

				setState(725);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(706); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(694);
						_la = _input.LA(1);
						if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(695); match(LEFT_PAREN);
						setState(700); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(696); ((Revoke_statementContext)_localctx).column = identifier();
							setState(698);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(697); match(COMMA);
								}
							}

							}
							}
							setState(702); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
						setState(704); match(RIGHT_PAREN);
						}
						}
						setState(708); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(710); match(ALL);
					setState(712);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(711); match(PRIVILEGES);
						}
					}

					setState(714); match(LEFT_PAREN);
					setState(719); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(715); ((Revoke_statementContext)_localctx).column = identifier();
						setState(717);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(716); match(COMMA);
							}
						}

						}
						}
						setState(721); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					setState(723); match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(727); match(ON);
				setState(729);
				_la = _input.LA(1);
				if (_la==TABLE) {
					{
					setState(728); match(TABLE);
					}
				}

				setState(735); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(731); ((Revoke_statementContext)_localctx).table_name = schema_qualified_name();
					setState(733);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(732); match(COMMA);
						}
					}

					}
					}
					setState(737); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(739); revoke_from_cascade_restrict();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(741); match(REVOKE);
				setState(745);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(742); match(GRANT);
					setState(743); match(OPTION);
					setState(744); match(FOR);
					}
				}

				setState(756);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(748); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(747);
						_la = _input.LA(1);
						if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(750); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(752); match(ALL);
					setState(754);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(753); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(758); match(ON);
				setState(780);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(759); match(SEQUENCE);
					setState(764); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(760); ((Revoke_statementContext)_localctx).sequence_name = schema_qualified_name();
						setState(762);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(761); match(COMMA);
							}
						}

						}
						}
						setState(766); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					}
					break;
				case ALL:
					{
					setState(768); match(ALL);
					setState(769); match(SEQUENCES);
					setState(770); match(IN);
					setState(771); match(SCHEMA);
					setState(776); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(772); ((Revoke_statementContext)_localctx).schema_name = identifier();
						setState(774);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(773); match(COMMA);
							}
						}

						}
						}
						setState(778); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(782); revoke_from_cascade_restrict();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(784); match(REVOKE);
				setState(788);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(785); match(GRANT);
					setState(786); match(OPTION);
					setState(787); match(FOR);
					}
				}

				setState(799);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(791); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(790);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(793); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(795); match(ALL);
					setState(797);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(796); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(801); match(ON);
				setState(802); match(DATABASE);
				setState(807); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(803); ((Revoke_statementContext)_localctx).database_name = identifier();
					setState(805);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(804); match(COMMA);
						}
					}

					}
					}
					setState(809); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(811); revoke_from_cascade_restrict();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(813); match(REVOKE);
				setState(817);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(814); match(GRANT);
					setState(815); match(OPTION);
					setState(816); match(FOR);
					}
				}

				setState(824);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(819); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(820); match(ALL);
					setState(822);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(821); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(826); match(ON);
				setState(827); match(FOREIGN);
				setState(828); match(DATA);
				setState(829); match(WRAPPER);
				setState(834); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(830); ((Revoke_statementContext)_localctx).fdw_name = schema_qualified_name();
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
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(838); revoke_from_cascade_restrict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
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

				setState(851);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(846); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(847); match(ALL);
					setState(849);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(848); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(853); match(ON);
				setState(854); match(FOREIGN);
				setState(855); match(SERVER);
				setState(860); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(856); ((Revoke_statementContext)_localctx).server_name = identifier();
					setState(858);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(857); match(COMMA);
						}
					}

					}
					}
					setState(862); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(864); revoke_from_cascade_restrict();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(866); match(REVOKE);
				setState(870);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(867); match(GRANT);
					setState(868); match(OPTION);
					setState(869); match(FOR);
					}
				}

				setState(877);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(872); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(873); match(ALL);
					setState(875);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(874); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(879); match(ON);
				setState(882);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(880); function_definition();
					}
					break;
				case ALL:
					{
					setState(881); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(884); revoke_from_cascade_restrict();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(886); match(REVOKE);
				setState(890);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(887); match(GRANT);
					setState(888); match(OPTION);
					setState(889); match(FOR);
					}
				}

				setState(897);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(892); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(893); match(ALL);
					setState(895);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(894); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(899); match(ON);
				setState(900); match(LANGUAGE);
				setState(905); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(901); ((Revoke_statementContext)_localctx).lang_name = identifier();
					setState(903);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(902); match(COMMA);
						}
					}

					}
					}
					setState(907); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(909); revoke_from_cascade_restrict();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(911); match(REVOKE);
				setState(915);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(912); match(GRANT);
					setState(913); match(OPTION);
					setState(914); match(FOR);
					}
				}

				setState(930);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(922); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(922);
						switch (_input.LA(1)) {
						case SELECT:
							{
							setState(917); match(SELECT);
							}
							break;
						case UPDATE:
							{
							setState(918); match(UPDATE);
							setState(920);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(919); match(COMMA);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(924); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(926); match(ALL);
					setState(928);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(927); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(932); match(ON);
				setState(933); match(LARGE);
				setState(934); match(OBJECT);
				setState(939); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(935); ((Revoke_statementContext)_localctx).loid = identifier();
					setState(937);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(936); match(COMMA);
						}
					}

					}
					}
					setState(941); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(943); revoke_from_cascade_restrict();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(945); match(REVOKE);
				setState(949);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(946); match(GRANT);
					setState(947); match(OPTION);
					setState(948); match(FOR);
					}
				}

				setState(963);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(955); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(951);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(953);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(952); match(COMMA);
							}
						}

						}
						}
						setState(957); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
					}
					break;
				case ALL:
					{
					setState(959); match(ALL);
					setState(961);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(960); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(965); match(ON);
				setState(966); match(SCHEMA);
				setState(971); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(967); ((Revoke_statementContext)_localctx).schema_name = identifier();
					setState(969);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(968); match(COMMA);
						}
					}

					}
					}
					setState(973); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(975); revoke_from_cascade_restrict();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(977); match(REVOKE);
				setState(981);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(978); match(GRANT);
					setState(979); match(OPTION);
					setState(980); match(FOR);
					}
				}

				setState(988);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(983); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(984); match(ALL);
					setState(986);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(985); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(990); match(ON);
				setState(991); match(TABLESPACE);
				setState(996); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(992); ((Revoke_statementContext)_localctx).tablespace_name = identifier();
					setState(994);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(993); match(COMMA);
						}
					}

					}
					}
					setState(998); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1000); revoke_from_cascade_restrict();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1002); match(REVOKE);
				setState(1006);
				switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
				case 1:
					{
					setState(1003); match(ADMIN);
					setState(1004); match(OPTION);
					setState(1005); match(FOR);
					}
					break;
				}
				setState(1012); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1008); ((Revoke_statementContext)_localctx).role_name = identifier();
					setState(1010);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1009); match(COMMA);
						}
					}

					}
					}
					setState(1014); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1016); match(FROM);
				setState(1021); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1017); ((Revoke_statementContext)_localctx).role_name = identifier();
						setState(1019);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1018); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1023); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1026);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(1025);
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
		enterRule(_localctx, 20, RULE_revoke_from_cascade_restrict);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1030); match(FROM);
			setState(1039); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1039);
					switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
					case 1:
						{
						setState(1032);
						_la = _input.LA(1);
						if (_la==GROUP) {
							{
							setState(1031); match(GROUP);
							}
						}

						setState(1034); ((Revoke_from_cascade_restrictContext)_localctx).role_name = identifier();
						}
						break;
					case 2:
						{
						setState(1035); match(PUBLIC);
						setState(1037);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1036); match(COMMA);
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
				setState(1041); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1044);
			_la = _input.LA(1);
			if (_la==CASCADE || _la==RESTRICT) {
				{
				setState(1043);
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
		enterRule(_localctx, 22, RULE_grant_statement);
		int _la;
		try {
			int _alt;
			setState(1371);
			switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1046); match(GRANT);
				setState(1056);
				switch (_input.LA(1)) {
				case DELETE:
				case REFERENCES:
				case SELECT:
				case TRIGGER:
				case TRUNCATE:
				case UPDATE:
				case INSERT:
					{
					setState(1048); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1047);
						_la = _input.LA(1);
						if ( !(_la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						}
						setState(1050); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DELETE || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (TRIGGER - 93)) | (1L << (TRUNCATE - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1052); match(ALL);
					setState(1054);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1053); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1058); match(ON);
				setState(1082);
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
					setState(1060);
					_la = _input.LA(1);
					if (_la==TABLE) {
						{
						setState(1059); match(TABLE);
						}
					}

					setState(1066); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1062); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
							setState(1064);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1063); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1068); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				case ALL:
					{
					{
					setState(1070); match(ALL);
					setState(1071); match(TABLES);
					setState(1072); match(IN);
					setState(1073); match(SCHEMA);
					setState(1078); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1074); ((Grant_statementContext)_localctx).schem_name = identifier();
							setState(1076);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1075); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1080); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1084); grant_to_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1086); match(GRANT);
				setState(1112);
				switch (_input.LA(1)) {
				case REFERENCES:
				case SELECT:
				case UPDATE:
				case INSERT:
					{
					setState(1096); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1087);
						_la = _input.LA(1);
						if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1092); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1088); ((Grant_statementContext)_localctx).column = identifier();
								setState(1090);
								_la = _input.LA(1);
								if (_la==COMMA) {
									{
									setState(1089); match(COMMA);
									}
								}

								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1094); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(1098); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (REFERENCES - 93)) | (1L << (SELECT - 93)) | (1L << (UPDATE - 93)))) != 0) || _la==INSERT );
					}
					break;
				case ALL:
					{
					setState(1100); match(ALL);
					setState(1102);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1101); match(PRIVILEGES);
						}
					}

					setState(1108); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1104); ((Grant_statementContext)_localctx).column = identifier();
						setState(1106);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1105); match(COMMA);
							}
						}

						}
						}
						setState(1110); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1114); match(ON);
				setState(1122); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1116);
						_la = _input.LA(1);
						if (_la==TABLE) {
							{
							setState(1115); match(TABLE);
							}
						}

						setState(1118); ((Grant_statementContext)_localctx).tabl_name = schema_qualified_name();
						setState(1120);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1119); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1124); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1126); grant_to_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1128); match(GRANT);
				setState(1141);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
				case USAGE:
					{
					setState(1133); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1129);
						_la = _input.LA(1);
						if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1131);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1130); match(COMMA);
							}
						}

						}
						}
						setState(1135); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (SELECT - 103)) | (1L << (UPDATE - 103)) | (1L << (USAGE - 103)))) != 0) );
					}
					break;
				case ALL:
					{
					setState(1137); match(ALL);
					setState(1139);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1138); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1143); match(ON);
				setState(1165);
				switch (_input.LA(1)) {
				case SEQUENCE:
					{
					setState(1149); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1144); match(SEQUENCE);
						setState(1145); ((Grant_statementContext)_localctx).sequence_name = identifier();
						setState(1147);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1146); match(COMMA);
							}
						}

						}
						}
						setState(1151); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEQUENCE );
					}
					break;
				case ALL:
					{
					setState(1153); match(ALL);
					setState(1154); match(SEQUENCES);
					setState(1155); match(IN);
					setState(1156); match(SCHEMA);
					setState(1161); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1157); ((Grant_statementContext)_localctx).schema_name = identifier();
							setState(1159);
							_la = _input.LA(1);
							if (_la==COMMA) {
								{
								setState(1158); match(COMMA);
								}
							}

							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1163); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1167); grant_to_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1169); match(GRANT);
				setState(1182);
				switch (_input.LA(1)) {
				case CONNECT:
				case CREATE:
				case TEMP:
				case TEMPORARY:
					{
					setState(1174); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1170);
						_la = _input.LA(1);
						if ( !(_la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1172);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1171); match(COMMA);
							}
						}

						}
						}
						setState(1176); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CONNECT || _la==CREATE || _la==TEMP || _la==TEMPORARY );
					}
					break;
				case ALL:
					{
					setState(1178); match(ALL);
					setState(1180);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1179); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1184); match(ON);
				setState(1185); match(DATABASE);
				setState(1190); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1186); ((Grant_statementContext)_localctx).database_name = identifier();
						setState(1188);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1187); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1192); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1194); grant_to_rule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1196); match(GRANT);
				setState(1202);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1197); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1198); match(ALL);
					setState(1200);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1199); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1204); match(ON);
				setState(1205); match(FOREIGN);
				setState(1206); match(DATA);
				setState(1207); match(WRAPPER);
				setState(1212); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1208); ((Grant_statementContext)_localctx).fdw_name = identifier();
						setState(1210);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1209); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1214); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1216); grant_to_rule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1218); match(GRANT);
				setState(1224);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1219); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1220); match(ALL);
					setState(1222);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1221); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1226); match(ON);
				setState(1227); match(FOREIGN);
				setState(1228); match(SERVER);
				setState(1233); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1229); ((Grant_statementContext)_localctx).server_name = identifier();
						setState(1231);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1230); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1235); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1237); grant_to_rule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1239); match(GRANT);
				setState(1245);
				switch (_input.LA(1)) {
				case EXECUTE:
					{
					setState(1240); match(EXECUTE);
					}
					break;
				case ALL:
					{
					setState(1241); match(ALL);
					setState(1243);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1242); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1247); match(ON);
				setState(1250);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(1248); function_definition();
					}
					break;
				case ALL:
					{
					setState(1249); functions_definition_schema();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1252); grant_to_rule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1254); match(GRANT);
				setState(1260);
				switch (_input.LA(1)) {
				case USAGE:
					{
					setState(1255); match(USAGE);
					}
					break;
				case ALL:
					{
					setState(1256); match(ALL);
					setState(1258);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1257); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1262); match(ON);
				setState(1263); match(LANGUAGE);
				setState(1268); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1264); ((Grant_statementContext)_localctx).lang_name = identifier();
						setState(1266);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1265); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1270); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1272); grant_to_rule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1274); match(GRANT);
				setState(1287);
				switch (_input.LA(1)) {
				case SELECT:
				case UPDATE:
					{
					setState(1279); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1275);
						_la = _input.LA(1);
						if ( !(_la==SELECT || _la==UPDATE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1277);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1276); match(COMMA);
							}
						}

						}
						}
						setState(1281); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SELECT || _la==UPDATE );
					}
					break;
				case ALL:
					{
					setState(1283); match(ALL);
					setState(1285);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1284); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1289); match(ON);
				setState(1290); match(LARGE);
				setState(1291); match(OBJECT);
				setState(1296); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1292); ((Grant_statementContext)_localctx).loid = identifier();
						setState(1294);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1293); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1298); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1300); grant_to_rule();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1302); match(GRANT);
				setState(1315);
				switch (_input.LA(1)) {
				case CREATE:
				case USAGE:
					{
					setState(1307); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1303);
						_la = _input.LA(1);
						if ( !(_la==CREATE || _la==USAGE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1305);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1304); match(COMMA);
							}
						}

						}
						}
						setState(1309); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CREATE || _la==USAGE );
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
				setState(1318); match(SCHEMA);
				setState(1323); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1319); ((Grant_statementContext)_localctx).schema_name = identifier();
						setState(1321);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1320); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1325); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1327); grant_to_rule();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1329); match(GRANT);
				setState(1335);
				switch (_input.LA(1)) {
				case CREATE:
					{
					setState(1330); match(CREATE);
					}
					break;
				case ALL:
					{
					setState(1331); match(ALL);
					setState(1333);
					_la = _input.LA(1);
					if (_la==PRIVILEGES) {
						{
						setState(1332); match(PRIVILEGES);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1337); match(ON);
				setState(1338); match(TABLESPACE);
				setState(1343); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1339); ((Grant_statementContext)_localctx).tablespace_name = identifier();
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
					_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1347); grant_to_rule();
				setState(1348); match(GRANT);
				setState(1353); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1349); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1351);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1350); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1355); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1357); match(TO);
				setState(1362); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1358); ((Grant_statementContext)_localctx).role_name = identifier();
						setState(1360);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1359); match(COMMA);
							}
						}

						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1364); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1369);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(1366); match(WITH);
					setState(1367); match(ADMIN);
					setState(1368); match(OPTION);
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
		enterRule(_localctx, 24, RULE_grant_to_rule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1373); match(TO);
			setState(1384); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1375);
					_la = _input.LA(1);
					if (_la==GROUP) {
						{
						setState(1374); match(GROUP);
						}
					}

					setState(1379);
					switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
					case 1:
						{
						{
						setState(1377); ((Grant_to_ruleContext)_localctx).role_name = identifier();
						}
						}
						break;
					case 2:
						{
						setState(1378); match(PUBLIC);
						}
						break;
					}
					setState(1382);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1381); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1386); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1391);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1388); match(WITH);
				setState(1389); match(GRANT);
				setState(1390); match(OPTION);
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
		enterRule(_localctx, 26, RULE_comment_on_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1393); match(COMMENT);
			setState(1394); match(ON);
			setState(1513);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				{
				setState(1395); match(AGGREGATE);
				setState(1396); ((Comment_on_statementContext)_localctx).agg_name = schema_qualified_name();
				setState(1397); match(LEFT_PAREN);
				setState(1404);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (SETOF - 105)) | (1L << (TRIGGER - 105)) | (1L << (CHARACTER - 105)) | (1L << (DEC - 105)))) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & ((1L << (NATIONAL - 199)) | (1L << (BOOLEAN - 199)) | (1L << (BOOL - 199)) | (1L << (BIT - 199)) | (1L << (VARBIT - 199)) | (1L << (INT1 - 199)) | (1L << (INT2 - 199)) | (1L << (INT4 - 199)))) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & ((1L << (INT8 - 263)) | (1L << (TINYINT - 263)) | (1L << (SMALLINT - 263)) | (1L << (INT - 263)) | (1L << (INTEGER - 263)) | (1L << (BIGINT - 263)) | (1L << (FLOAT4 - 263)) | (1L << (FLOAT8 - 263)) | (1L << (REAL - 263)) | (1L << (REGCLASS - 263)) | (1L << (FLOAT - 263)) | (1L << (DOUBLE - 263)) | (1L << (NUMERIC - 263)) | (1L << (DECIMAL - 263)) | (1L << (CHAR - 263)) | (1L << (VARCHAR - 263)) | (1L << (NCHAR - 263)) | (1L << (NVARCHAR - 263)) | (1L << (DATE - 263)) | (1L << (TIME - 263)) | (1L << (TIMETZ - 263)) | (1L << (TIMESTAMP - 263)) | (1L << (TIMESTAMPTZ - 263)) | (1L << (TEXT - 263)) | (1L << (UUID - 263)) | (1L << (BINARY - 263)) | (1L << (VARBINARY - 263)) | (1L << (BLOB - 263)) | (1L << (BYTEA - 263)) | (1L << (INET4 - 263)) | (1L << (VOID - 263)))) != 0)) {
					{
					{
					setState(1398); ((Comment_on_statementContext)_localctx).agg_type = data_type();
					setState(1400);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1399); match(COMMA);
						}
					}

					}
					}
					setState(1406);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1407); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1409); match(CAST);
				setState(1410); match(LEFT_PAREN);
				setState(1411); ((Comment_on_statementContext)_localctx).source_type = data_type();
				setState(1412); match(AS);
				setState(1413); ((Comment_on_statementContext)_localctx).target_type = data_type();
				setState(1414); match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(1416); match(COLLATION);
				setState(1417); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 4:
				{
				setState(1418); match(COLUMN);
				setState(1419); ((Comment_on_statementContext)_localctx).column_name = schema_qualified_name();
				}
				break;
			case 5:
				{
				setState(1420); match(CONSTRAINT);
				setState(1421); ((Comment_on_statementContext)_localctx).constraint_name = schema_qualified_name();
				setState(1422); match(ON);
				setState(1423); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 6:
				{
				setState(1425); match(CONVERSION);
				setState(1426); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 7:
				{
				setState(1427); match(DATABASE);
				setState(1428); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 8:
				{
				setState(1429); match(DOMAIN);
				setState(1430); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 9:
				{
				setState(1431); match(EXTENSION);
				setState(1432); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 10:
				{
				setState(1433); match(FOREIGN);
				setState(1434); match(DATA);
				setState(1435); match(WRAPPER);
				setState(1436); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 11:
				{
				setState(1437); match(FOREIGN);
				setState(1438); match(TABLE);
				setState(1439); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 12:
				{
				setState(1440); function_definition();
				}
				break;
			case 13:
				{
				setState(1441); match(INDEX);
				setState(1442); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 14:
				{
				setState(1443); match(LARGE);
				setState(1444); match(OBJECT);
				setState(1445); ((Comment_on_statementContext)_localctx).large_object_oid = identifier();
				}
				break;
			case 15:
				{
				setState(1446); match(OPERATOR);
				setState(1447); ((Comment_on_statementContext)_localctx).operator_name = schema_qualified_name();
				setState(1448); match(LEFT_PAREN);
				setState(1449); ((Comment_on_statementContext)_localctx).left_type = data_type();
				setState(1450); match(COMMA);
				setState(1451); ((Comment_on_statementContext)_localctx).right_type = data_type();
				setState(1452); match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(1454); match(OPERATOR);
				setState(1455); match(CLASS);
				setState(1456); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1457); match(USING);
				setState(1458); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 17:
				{
				setState(1460); match(OPERATOR);
				setState(1461); match(FAMILY);
				setState(1462); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				setState(1463); match(USING);
				setState(1464); ((Comment_on_statementContext)_localctx).index_method = identifier();
				}
				break;
			case 18:
				{
				setState(1467);
				_la = _input.LA(1);
				if (_la==PROCEDURAL) {
					{
					setState(1466); match(PROCEDURAL);
					}
				}

				setState(1469); match(LANGUAGE);
				setState(1470); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 19:
				{
				setState(1471); match(ROLE);
				setState(1472); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 20:
				{
				setState(1473); match(RULE);
				setState(1474); ((Comment_on_statementContext)_localctx).rule_name = schema_qualified_name();
				setState(1475); match(ON);
				setState(1476); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 21:
				{
				setState(1478); match(SCHEMA);
				setState(1479); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 22:
				{
				setState(1480); match(SEQUENCE);
				setState(1481); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 23:
				{
				setState(1482); match(SERVER);
				setState(1483); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 24:
				{
				setState(1484); match(TABLE);
				setState(1485); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 25:
				{
				setState(1486); match(TABLESPACE);
				setState(1487); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 26:
				{
				setState(1488); match(TEXT);
				setState(1489); match(SEARCH);
				setState(1490); match(CONFIGURATION);
				setState(1491); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 27:
				{
				setState(1492); match(TEXT);
				setState(1493); match(SEARCH);
				setState(1494); match(DICTIONARY);
				setState(1495); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 28:
				{
				setState(1496); match(TEXT);
				setState(1497); match(SEARCH);
				setState(1498); match(PARSER);
				setState(1499); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 29:
				{
				setState(1500); match(TEXT);
				setState(1501); match(SEARCH);
				setState(1502); match(TEMPLATE);
				setState(1503); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 30:
				{
				setState(1504); match(TRIGGER);
				setState(1505); ((Comment_on_statementContext)_localctx).trigger_name = schema_qualified_name();
				setState(1506); match(ON);
				setState(1507); ((Comment_on_statementContext)_localctx).table_name = schema_qualified_name();
				}
				break;
			case 31:
				{
				setState(1509); match(TYPE);
				setState(1510); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			case 32:
				{
				setState(1511); match(VIEW);
				setState(1512); ((Comment_on_statementContext)_localctx).object_name = schema_qualified_name();
				}
				break;
			}
			setState(1515); match(IS);
			setState(1516); match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		public ArgmodeContext arg_mode;
		public IdentifierContext argname;
		public Data_typeContext argtype;
		public Value_expressionContext def_value;
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
		public List<TerminalNode> DEFAULT() { return getTokens(SQLParser.DEFAULT); }
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
		public List<ArgmodeContext> argmode() {
			return getRuleContexts(ArgmodeContext.class);
		}
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
		public ArgmodeContext argmode(int i) {
			return getRuleContext(ArgmodeContext.class,i);
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
		public TerminalNode DEFAULT(int i) {
			return getToken(SQLParser.DEFAULT, i);
		}
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
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public List<TerminalNode> DEFINER() { return getTokens(SQLParser.DEFINER); }
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
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
		enterRule(_localctx, 28, RULE_create_function_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1518); match(CREATE);
			setState(1521);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(1519); match(OR);
				setState(1520); match(REPLACE);
				}
			}

			setState(1523); match(FUNCTION);
			setState(1524); ((Create_function_statementContext)_localctx).name = schema_qualified_name();
			setState(1525); match(LEFT_PAREN);
			setState(1543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IN || _la==INOUT || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (OUT - 80)) | (1L << (SETOF - 80)) | (1L << (TRIGGER - 80)) | (1L << (VARIADIC - 80)) | (1L << (ADMIN - 80)) | (1L << (AVG - 80)) | (1L << (BETWEEN - 80)) | (1L << (BY - 80)) | (1L << (CACHE - 80)) | (1L << (CALLED - 80)) | (1L << (CLASS - 80)) | (1L << (CENTURY - 80)) | (1L << (CHARACTER - 80)) | (1L << (CHECK - 80)) | (1L << (COLLECT - 80)) | (1L << (COALESCE - 80)) | (1L << (COLUMN - 80)) | (1L << (COMMENT - 80)) | (1L << (COMMENTS - 80)))) != 0) || ((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & ((1L << (COMMIT - 144)) | (1L << (CONFIGURATION - 144)) | (1L << (COST - 144)) | (1L << (COUNT - 144)) | (1L << (CUBE - 144)) | (1L << (CURRENT - 144)) | (1L << (CYCLE - 144)) | (1L << (DATA - 144)) | (1L << (DAY - 144)) | (1L << (DEC - 144)) | (1L << (DECADE - 144)) | (1L << (DEFINER - 144)) | (1L << (DICTIONARY - 144)) | (1L << (DOW - 144)) | (1L << (DOY - 144)) | (1L << (DROP - 144)) | (1L << (EPOCH - 144)) | (1L << (EVERY - 144)) | (1L << (EXISTS - 144)) | (1L << (EXTERNAL - 144)) | (1L << (EXTRACT - 144)) | (1L << (FAMILY - 144)) | (1L << (FILTER - 144)) | (1L << (FIRST - 144)) | (1L << (FORMAT - 144)) | (1L << (FUSION - 144)) | (1L << (GROUPING - 144)) | (1L << (HASH - 144)) | (1L << (INDEX - 144)) | (1L << (INCREMENT - 144)) | (1L << (INPUT - 144)) | (1L << (INSERT - 144)) | (1L << (INTERSECTION - 144)) | (1L << (ISCACHABLE - 144)) | (1L << (ISODOW - 144)) | (1L << (ISOYEAR - 144)) | (1L << (ISSTRICT - 144)) | (1L << (LANGUAGE - 144)) | (1L << (LARGE - 144)) | (1L << (LAST - 144)) | (1L << (LESS - 144)) | (1L << (LIST - 144)) | (1L << (LOCATION - 144)) | (1L << (MATCH - 144)) | (1L << (MAX - 144)) | (1L << (MAXVALUE - 144)) | (1L << (MICROSECONDS - 144)) | (1L << (MILLENNIUM - 144)) | (1L << (MILLISECONDS - 144)) | (1L << (MIN - 144)) | (1L << (MINVALUE - 144)) | (1L << (MINUTE - 144)) | (1L << (MONTH - 144)) | (1L << (NATIONAL - 144)) | (1L << (NO - 144)) | (1L << (NONE - 144)) | (1L << (NULLIF - 144)) | (1L << (OBJECT - 144)) | (1L << (OPTION - 144)) | (1L << (OPTIONS - 144)) | (1L << (OVERWRITE - 144)) | (1L << (PARSER - 144)))) != 0) || ((((_la - 208)) & ~0x3f) == 0 && ((1L << (_la - 208)) & ((1L << (PARTIAL - 208)) | (1L << (PARTITION - 208)) | (1L << (PARTITIONS - 208)) | (1L << (PRECISION - 208)) | (1L << (PUBLIC - 208)) | (1L << (PURGE - 208)) | (1L << (QUARTER - 208)) | (1L << (RANGE - 208)) | (1L << (REGEXP - 208)) | (1L << (RLIKE - 208)) | (1L << (ROLLUP - 208)) | (1L << (SEARCH - 208)) | (1L << (SECOND - 208)) | (1L << (SECURITY - 208)) | (1L << (SERVER - 208)) | (1L << (SET - 208)) | (1L << (SIMILAR - 208)) | (1L << (SIMPLE - 208)) | (1L << (STABLE - 208)) | (1L << (START - 208)) | (1L << (STORAGE - 208)) | (1L << (STDDEV_POP - 208)) | (1L << (STDDEV_SAMP - 208)) | (1L << (SUBPARTITION - 208)) | (1L << (SUM - 208)) | (1L << (TABLESPACE - 208)) | (1L << (TEMPLATE - 208)) | (1L << (THAN - 208)) | (1L << (TIMEZONE - 208)) | (1L << (TIMEZONE_HOUR - 208)) | (1L << (TIMEZONE_MINUTE - 208)) | (1L << (TRIM - 208)) | (1L << (TO - 208)) | (1L << (TYPE - 208)) | (1L << (UNKNOWN - 208)) | (1L << (UNLOGGED - 208)) | (1L << (VALUES - 208)) | (1L << (VAR_SAMP - 208)) | (1L << (VAR_POP - 208)) | (1L << (VARYING - 208)) | (1L << (VOLATILE - 208)) | (1L << (WEEK - 208)) | (1L << (WINDOW - 208)) | (1L << (WRAPPER - 208)) | (1L << (YEAR - 208)) | (1L << (ZONE - 208)) | (1L << (BOOLEAN - 208)) | (1L << (BOOL - 208)) | (1L << (BIT - 208)) | (1L << (VARBIT - 208)) | (1L << (INT1 - 208)) | (1L << (INT2 - 208)) | (1L << (INT4 - 208)) | (1L << (INT8 - 208)) | (1L << (TINYINT - 208)) | (1L << (SMALLINT - 208)) | (1L << (INT - 208)) | (1L << (INTEGER - 208)) | (1L << (BIGINT - 208)) | (1L << (FLOAT4 - 208)) | (1L << (FLOAT8 - 208)) | (1L << (REAL - 208)))) != 0) || ((((_la - 272)) & ~0x3f) == 0 && ((1L << (_la - 272)) & ((1L << (REGCLASS - 272)) | (1L << (FLOAT - 272)) | (1L << (DOUBLE - 272)) | (1L << (NUMERIC - 272)) | (1L << (DECIMAL - 272)) | (1L << (CHAR - 272)) | (1L << (VARCHAR - 272)) | (1L << (NCHAR - 272)) | (1L << (NVARCHAR - 272)) | (1L << (DATE - 272)) | (1L << (TIME - 272)) | (1L << (TIMETZ - 272)) | (1L << (TIMESTAMP - 272)) | (1L << (TIMESTAMPTZ - 272)) | (1L << (TEXT - 272)) | (1L << (UUID - 272)) | (1L << (BINARY - 272)) | (1L << (VARBINARY - 272)) | (1L << (BLOB - 272)) | (1L << (BYTEA - 272)) | (1L << (INET4 - 272)) | (1L << (VOID - 272)) | (1L << (DOUBLE_QUOTE - 272)) | (1L << (Identifier - 272)))) != 0)) {
				{
				{
				setState(1527);
				_la = _input.LA(1);
				if (_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) {
					{
					setState(1526); ((Create_function_statementContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1530);
				switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
				case 1:
					{
					setState(1529); ((Create_function_statementContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1532); ((Create_function_statementContext)_localctx).argtype = data_type();
				setState(1536);
				switch (_input.LA(1)) {
				case DEFAULT:
					{
					setState(1533); match(DEFAULT);
					}
					break;
				case EQUAL:
					{
					setState(1534); match(EQUAL);
					setState(1535); ((Create_function_statementContext)_localctx).def_value = value_expression();
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
				setState(1539);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1538); match(COMMA);
					}
				}

				}
				}
				setState(1545);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1546); match(RIGHT_PAREN);
			setState(1563);
			switch ( getInterpreter().adaptivePredict(_input,208,_ctx) ) {
			case 1:
				{
				setState(1547); match(RETURNS);
				setState(1548); ((Create_function_statementContext)_localctx).rettype = data_type();
				}
				break;
			case 2:
				{
				setState(1549); match(RETURNS);
				setState(1550); match(TABLE);
				setState(1551); match(LEFT_PAREN);
				setState(1557); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1552); ((Create_function_statementContext)_localctx).column_name = identifier();
					setState(1553); ((Create_function_statementContext)_localctx).column_type = data_type();
					setState(1555);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1554); match(COMMA);
						}
					}

					}
					}
					setState(1559); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1561); match(RIGHT_PAREN);
				}
				break;
			}
			setState(1618); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1618);
					switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
					case 1:
						{
						setState(1565); match(LANGUAGE);
						setState(1566); ((Create_function_statementContext)_localctx).lang_name = identifier();
						}
						break;
					case 2:
						{
						setState(1567); match(WINDOW);
						}
						break;
					case 3:
						{
						setState(1568); match(IMMUTABLE);
						}
						break;
					case 4:
						{
						setState(1569); match(STABLE);
						}
						break;
					case 5:
						{
						setState(1570); match(VOLATILE);
						}
						break;
					case 6:
						{
						setState(1571); match(CALLED);
						setState(1572); match(ON);
						setState(1573); match(NULL);
						setState(1574); match(INPUT);
						}
						break;
					case 7:
						{
						setState(1575); match(RETURNS);
						setState(1576); match(NULL);
						setState(1577); match(ON);
						setState(1578); match(NULL);
						setState(1579); match(INPUT);
						}
						break;
					case 8:
						{
						setState(1580); match(STRICT);
						}
						break;
					case 9:
						{
						setState(1582);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1581); match(EXTERNAL);
							}
						}

						setState(1584); match(SECURITY);
						setState(1585); match(INVOKER);
						}
						break;
					case 10:
						{
						setState(1587);
						_la = _input.LA(1);
						if (_la==EXTERNAL) {
							{
							setState(1586); match(EXTERNAL);
							}
						}

						setState(1589); match(SECURITY);
						setState(1590); match(DEFINER);
						}
						break;
					case 11:
						{
						setState(1591); match(COST);
						setState(1592); ((Create_function_statementContext)_localctx).execution_cost = match(NUMBER);
						}
						break;
					case 12:
						{
						setState(1593); match(ROWS);
						setState(1594); ((Create_function_statementContext)_localctx).result_rows = match(NUMBER);
						}
						break;
					case 13:
						{
						setState(1595); match(SET);
						setState(1596); ((Create_function_statementContext)_localctx).configuration_parameter = identifier();
						setState(1603);
						switch (_input.LA(1)) {
						case TO:
							{
							setState(1597); match(TO);
							setState(1598); ((Create_function_statementContext)_localctx).value = identifier();
							}
							break;
						case EQUAL:
							{
							setState(1599); match(EQUAL);
							setState(1600); ((Create_function_statementContext)_localctx).value = identifier();
							}
							break;
						case FROM:
							{
							setState(1601); match(FROM);
							setState(1602); match(CURRENT);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1609);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1605); match(COMMA);
							setState(1606); ((Create_function_statementContext)_localctx).value = identifier();
							}
							}
							setState(1611);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case 14:
						{
						setState(1612); match(AS);
						setState(1613); function_body();
						}
						break;
					case 15:
						{
						setState(1614); match(AS);
						setState(1615); match(Character_String_Literal);
						setState(1616); match(COMMA);
						setState(1617); match(Character_String_Literal);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1620); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1634);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1622); match(WITH);
				setState(1623); match(LEFT_PAREN);
				setState(1628); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1624); ((Create_function_statementContext)_localctx).attribute = function_attribute();
					setState(1626);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1625); match(COMMA);
						}
					}

					}
					}
					setState(1630); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ISCACHABLE || _la==ISSTRICT );
				setState(1632); match(RIGHT_PAREN);
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
		enterRule(_localctx, 30, RULE_function_body);
		try {
			setState(1638);
			switch (_input.LA(1)) {
			case DOUBLE_DOLLAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1636); function_body_separator();
				}
				break;
			case DOUBLE_UNDER_DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1637); function_body_separator_dollar_under();
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
		enterRule(_localctx, 32, RULE_function_body_separator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1640); match(DOUBLE_DOLLAR);
			setState(1644);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INNER) | (1L << INTERSECT) | (1L << INTO) | (1L << INOUT) | (1L << INSTEAD))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (ON - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)) | (1L << (VARIADIC - 64)) | (1L << (VIEW - 64)) | (1L << (WHEN - 64)) | (1L << (WHERE - 64)) | (1L << (WITH - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TABLES - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VERSION - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (VOID - 256)) | (1L << (Similar_To - 256)) | (1L << (Not_Similar_To - 256)) | (1L << (Similar_To_Case_Insensitive - 256)) | (1L << (Not_Similar_To_Case_Insensitive - 256)) | (1L << (CAST_EXPRESSION - 256)) | (1L << (ASSIGN - 256)) | (1L << (EQUAL - 256)) | (1L << (COLON - 256)) | (1L << (SEMI_COLON - 256)) | (1L << (COMMA - 256)) | (1L << (CONCATENATION_OPERATOR - 256)) | (1L << (NOT_EQUAL - 256)) | (1L << (LTH - 256)) | (1L << (LEQ - 256)) | (1L << (GTH - 256)) | (1L << (GEQ - 256)) | (1L << (LEFT_PAREN - 256)) | (1L << (RIGHT_PAREN - 256)) | (1L << (PLUS - 256)) | (1L << (MINUS - 256)) | (1L << (MULTIPLY - 256)) | (1L << (DIVIDE - 256)) | (1L << (MODULAR - 256)) | (1L << (DOT - 256)) | (1L << (UNDERLINE - 256)) | (1L << (VERTICAL_BAR - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (DOUBLE_UNDER_DOLLAR - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)))) != 0)) {
				{
				{
				setState(1641);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==DOUBLE_DOLLAR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(1646);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1647); match(DOUBLE_DOLLAR);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 34, RULE_function_body_separator_dollar_under);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1649); match(DOUBLE_UNDER_DOLLAR);
			setState(1653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGGREGATE) | (1L << AFTER) | (1L << AS) | (1L << ALL) | (1L << AND) | (1L << ANY) | (1L << ASYMMETRIC) | (1L << ASC) | (1L << AUTHORIZATION) | (1L << BEFORE) | (1L << BOTH) | (1L << CASE) | (1L << CASCADE) | (1L << CAST) | (1L << COLLATE) | (1L << COLLATION) | (1L << CONNECT) | (1L << CONSTRAINT) | (1L << CONSTRAINTS) | (1L << CONVERSION) | (1L << CREATE) | (1L << CROSS) | (1L << DATABASE) | (1L << DEFAULT) | (1L << DEFAULTS) | (1L << DEFERRABLE) | (1L << DEFERRED) | (1L << DELETE) | (1L << DESC) | (1L << DISTINCT) | (1L << DOMAIN) | (1L << EACH) | (1L << END) | (1L << ELSE) | (1L << EXCEPT) | (1L << EXCLUDE) | (1L << EXCLUDING) | (1L << EXECUTE) | (1L << EXTENSION) | (1L << FALSE) | (1L << FOR) | (1L << FOREIGN) | (1L << FULL) | (1L << FUNCTION) | (1L << FUNCTIONS) | (1L << FROM) | (1L << GLOBAL) | (1L << GRANT) | (1L << GROUP) | (1L << HAVING) | (1L << IF) | (1L << ILIKE) | (1L << IMMEDIATE) | (1L << IMMUTABLE) | (1L << IN) | (1L << INCLUDING) | (1L << INHERITS) | (1L << INITIALLY) | (1L << INNER) | (1L << INTERSECT) | (1L << INTO) | (1L << INOUT) | (1L << INSTEAD))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INVOKER - 64)) | (1L << (IS - 64)) | (1L << (JOIN - 64)) | (1L << (KEY - 64)) | (1L << (LEADING - 64)) | (1L << (LEFT - 64)) | (1L << (LIKE - 64)) | (1L << (LIMIT - 64)) | (1L << (LOCAL - 64)) | (1L << (NATURAL - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (OF - 64)) | (1L << (OIDS - 64)) | (1L << (ON - 64)) | (1L << (OUTER - 64)) | (1L << (OUT - 64)) | (1L << (OPERATOR - 64)) | (1L << (OR - 64)) | (1L << (ORDER - 64)) | (1L << (OWNED - 64)) | (1L << (PRESERVE - 64)) | (1L << (PRIMARY - 64)) | (1L << (PRIVILEGES - 64)) | (1L << (PROCEDURE - 64)) | (1L << (PROCEDURAL - 64)) | (1L << (ROLE - 64)) | (1L << (ROW - 64)) | (1L << (ROWS - 64)) | (1L << (REFERENCES - 64)) | (1L << (REPLACE - 64)) | (1L << (RESTRICT - 64)) | (1L << (RETURNS - 64)) | (1L << (REVOKE - 64)) | (1L << (RIGHT - 64)) | (1L << (RULE - 64)) | (1L << (SCHEMA - 64)) | (1L << (SEQUENCE - 64)) | (1L << (SEQUENCES - 64)) | (1L << (SELECT - 64)) | (1L << (SESSION - 64)) | (1L << (SETOF - 64)) | (1L << (SOME - 64)) | (1L << (STATEMENT - 64)) | (1L << (STRICT - 64)) | (1L << (SYMMETRIC - 64)) | (1L << (TABLE - 64)) | (1L << (TEMP - 64)) | (1L << (TEMPORARY - 64)) | (1L << (THEN - 64)) | (1L << (TRAILING - 64)) | (1L << (TRIGGER - 64)) | (1L << (TRUE - 64)) | (1L << (TRUNCATE - 64)) | (1L << (UNION - 64)) | (1L << (UNIQUE - 64)) | (1L << (UPDATE - 64)) | (1L << (USAGE - 64)) | (1L << (USING - 64)) | (1L << (VARIADIC - 64)) | (1L << (VIEW - 64)) | (1L << (WHEN - 64)) | (1L << (WHERE - 64)) | (1L << (WITH - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (WITHOUT - 128)) | (1L << (ADMIN - 128)) | (1L << (AVG - 128)) | (1L << (BETWEEN - 128)) | (1L << (BY - 128)) | (1L << (CACHE - 128)) | (1L << (CALLED - 128)) | (1L << (CLASS - 128)) | (1L << (CENTURY - 128)) | (1L << (CHARACTER - 128)) | (1L << (CHECK - 128)) | (1L << (COLLECT - 128)) | (1L << (COALESCE - 128)) | (1L << (COLUMN - 128)) | (1L << (COMMENT - 128)) | (1L << (COMMENTS - 128)) | (1L << (COMMIT - 128)) | (1L << (CONFIGURATION - 128)) | (1L << (COST - 128)) | (1L << (COUNT - 128)) | (1L << (CUBE - 128)) | (1L << (CURRENT - 128)) | (1L << (CYCLE - 128)) | (1L << (DATA - 128)) | (1L << (DAY - 128)) | (1L << (DEC - 128)) | (1L << (DECADE - 128)) | (1L << (DEFINER - 128)) | (1L << (DICTIONARY - 128)) | (1L << (DOW - 128)) | (1L << (DOY - 128)) | (1L << (DROP - 128)) | (1L << (EPOCH - 128)) | (1L << (EVERY - 128)) | (1L << (EXISTS - 128)) | (1L << (EXTERNAL - 128)) | (1L << (EXTRACT - 128)) | (1L << (FAMILY - 128)) | (1L << (FILTER - 128)) | (1L << (FIRST - 128)) | (1L << (FORMAT - 128)) | (1L << (FUSION - 128)) | (1L << (GROUPING - 128)) | (1L << (HASH - 128)) | (1L << (HOUR - 128)) | (1L << (INDEX - 128)) | (1L << (INDEXES - 128)) | (1L << (INCREMENT - 128)) | (1L << (INPUT - 128)) | (1L << (INSERT - 128)) | (1L << (INTERSECTION - 128)) | (1L << (ISCACHABLE - 128)) | (1L << (ISODOW - 128)) | (1L << (ISOYEAR - 128)) | (1L << (ISSTRICT - 128)) | (1L << (LANGUAGE - 128)) | (1L << (LARGE - 128)) | (1L << (LAST - 128)) | (1L << (LESS - 128)) | (1L << (LIST - 128)) | (1L << (LOCATION - 128)) | (1L << (MATCH - 128)) | (1L << (MAX - 128)) | (1L << (MAXVALUE - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (MICROSECONDS - 192)) | (1L << (MILLENNIUM - 192)) | (1L << (MILLISECONDS - 192)) | (1L << (MIN - 192)) | (1L << (MINVALUE - 192)) | (1L << (MINUTE - 192)) | (1L << (MONTH - 192)) | (1L << (NATIONAL - 192)) | (1L << (NO - 192)) | (1L << (NONE - 192)) | (1L << (NULLIF - 192)) | (1L << (OBJECT - 192)) | (1L << (OPTION - 192)) | (1L << (OPTIONS - 192)) | (1L << (OVERWRITE - 192)) | (1L << (PARSER - 192)) | (1L << (PARTIAL - 192)) | (1L << (PARTITION - 192)) | (1L << (PARTITIONS - 192)) | (1L << (PRECISION - 192)) | (1L << (PUBLIC - 192)) | (1L << (PURGE - 192)) | (1L << (QUARTER - 192)) | (1L << (RANGE - 192)) | (1L << (REGEXP - 192)) | (1L << (RLIKE - 192)) | (1L << (ROLLUP - 192)) | (1L << (SEARCH - 192)) | (1L << (SECOND - 192)) | (1L << (SECURITY - 192)) | (1L << (SERVER - 192)) | (1L << (SET - 192)) | (1L << (SIMILAR - 192)) | (1L << (SIMPLE - 192)) | (1L << (STABLE - 192)) | (1L << (START - 192)) | (1L << (STORAGE - 192)) | (1L << (STDDEV_POP - 192)) | (1L << (STDDEV_SAMP - 192)) | (1L << (SUBPARTITION - 192)) | (1L << (SUM - 192)) | (1L << (TABLESPACE - 192)) | (1L << (TABLES - 192)) | (1L << (TEMPLATE - 192)) | (1L << (THAN - 192)) | (1L << (TIMEZONE - 192)) | (1L << (TIMEZONE_HOUR - 192)) | (1L << (TIMEZONE_MINUTE - 192)) | (1L << (TRIM - 192)) | (1L << (TO - 192)) | (1L << (TYPE - 192)) | (1L << (UNKNOWN - 192)) | (1L << (UNLOGGED - 192)) | (1L << (VALUES - 192)) | (1L << (VAR_SAMP - 192)) | (1L << (VAR_POP - 192)) | (1L << (VARYING - 192)) | (1L << (VERSION - 192)) | (1L << (VOLATILE - 192)) | (1L << (WEEK - 192)) | (1L << (WINDOW - 192)) | (1L << (WRAPPER - 192)) | (1L << (YEAR - 192)) | (1L << (ZONE - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (BOOLEAN - 256)) | (1L << (BOOL - 256)) | (1L << (BIT - 256)) | (1L << (VARBIT - 256)) | (1L << (INT1 - 256)) | (1L << (INT2 - 256)) | (1L << (INT4 - 256)) | (1L << (INT8 - 256)) | (1L << (TINYINT - 256)) | (1L << (SMALLINT - 256)) | (1L << (INT - 256)) | (1L << (INTEGER - 256)) | (1L << (BIGINT - 256)) | (1L << (FLOAT4 - 256)) | (1L << (FLOAT8 - 256)) | (1L << (REAL - 256)) | (1L << (REGCLASS - 256)) | (1L << (FLOAT - 256)) | (1L << (DOUBLE - 256)) | (1L << (NUMERIC - 256)) | (1L << (DECIMAL - 256)) | (1L << (CHAR - 256)) | (1L << (VARCHAR - 256)) | (1L << (NCHAR - 256)) | (1L << (NVARCHAR - 256)) | (1L << (DATE - 256)) | (1L << (TIME - 256)) | (1L << (TIMETZ - 256)) | (1L << (TIMESTAMP - 256)) | (1L << (TIMESTAMPTZ - 256)) | (1L << (TEXT - 256)) | (1L << (UUID - 256)) | (1L << (BINARY - 256)) | (1L << (VARBINARY - 256)) | (1L << (BLOB - 256)) | (1L << (BYTEA - 256)) | (1L << (INET4 - 256)) | (1L << (VOID - 256)) | (1L << (Similar_To - 256)) | (1L << (Not_Similar_To - 256)) | (1L << (Similar_To_Case_Insensitive - 256)) | (1L << (Not_Similar_To_Case_Insensitive - 256)) | (1L << (CAST_EXPRESSION - 256)) | (1L << (ASSIGN - 256)) | (1L << (EQUAL - 256)) | (1L << (COLON - 256)) | (1L << (SEMI_COLON - 256)) | (1L << (COMMA - 256)) | (1L << (CONCATENATION_OPERATOR - 256)) | (1L << (NOT_EQUAL - 256)) | (1L << (LTH - 256)) | (1L << (LEQ - 256)) | (1L << (GTH - 256)) | (1L << (GEQ - 256)) | (1L << (LEFT_PAREN - 256)) | (1L << (RIGHT_PAREN - 256)) | (1L << (PLUS - 256)) | (1L << (MINUS - 256)) | (1L << (MULTIPLY - 256)) | (1L << (DIVIDE - 256)) | (1L << (MODULAR - 256)) | (1L << (DOT - 256)) | (1L << (UNDERLINE - 256)) | (1L << (VERTICAL_BAR - 256)))) != 0) || ((((_la - 320)) & ~0x3f) == 0 && ((1L << (_la - 320)) & ((1L << (QUOTE - 320)) | (1L << (DOUBLE_QUOTE - 320)) | (1L << (DOLLAR - 320)) | (1L << (DOUBLE_DOLLAR - 320)) | (1L << (NUMBER - 320)) | (1L << (REAL_NUMBER - 320)) | (1L << (BlockComment - 320)) | (1L << (LineComment - 320)) | (1L << (Identifier - 320)) | (1L << (Character_String_Literal - 320)) | (1L << (ESC_SEQUENCES - 320)) | (1L << (Space - 320)) | (1L << (White_Space - 320)) | (1L << (BAD - 320)))) != 0)) {
				{
				{
				setState(1650);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==DOUBLE_UNDER_DOLLAR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(1655);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1656); match(DOUBLE_UNDER_DOLLAR);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 36, RULE_function_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1658);
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
		enterRule(_localctx, 38, RULE_argmode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1660);
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
		enterRule(_localctx, 40, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1662); match(FUNCTION);
			setState(1663); ((Function_definitionContext)_localctx).func_name = identifier();
			setState(1664); match(LEFT_PAREN);
			setState(1680);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE) | (1L << IN) | (1L << INOUT))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LEFT - 69)) | (1L << (NOT - 69)) | (1L << (NULL - 69)) | (1L << (OUT - 69)) | (1L << (RIGHT - 69)) | (1L << (SETOF - 69)) | (1L << (SOME - 69)) | (1L << (TRIGGER - 69)) | (1L << (TRUE - 69)) | (1L << (VARIADIC - 69)) | (1L << (ADMIN - 69)) | (1L << (AVG - 69)) | (1L << (BETWEEN - 69)) | (1L << (BY - 69)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (CACHE - 133)) | (1L << (CALLED - 133)) | (1L << (CLASS - 133)) | (1L << (CENTURY - 133)) | (1L << (CHARACTER - 133)) | (1L << (CHECK - 133)) | (1L << (COLLECT - 133)) | (1L << (COALESCE - 133)) | (1L << (COLUMN - 133)) | (1L << (COMMENT - 133)) | (1L << (COMMENTS - 133)) | (1L << (COMMIT - 133)) | (1L << (CONFIGURATION - 133)) | (1L << (COST - 133)) | (1L << (COUNT - 133)) | (1L << (CUBE - 133)) | (1L << (CURRENT - 133)) | (1L << (CYCLE - 133)) | (1L << (DATA - 133)) | (1L << (DAY - 133)) | (1L << (DEC - 133)) | (1L << (DECADE - 133)) | (1L << (DEFINER - 133)) | (1L << (DICTIONARY - 133)) | (1L << (DOW - 133)) | (1L << (DOY - 133)) | (1L << (DROP - 133)) | (1L << (EPOCH - 133)) | (1L << (EVERY - 133)) | (1L << (EXISTS - 133)) | (1L << (EXTERNAL - 133)) | (1L << (EXTRACT - 133)) | (1L << (FAMILY - 133)) | (1L << (FILTER - 133)) | (1L << (FIRST - 133)) | (1L << (FORMAT - 133)) | (1L << (FUSION - 133)) | (1L << (GROUPING - 133)) | (1L << (HASH - 133)) | (1L << (INDEX - 133)) | (1L << (INCREMENT - 133)) | (1L << (INPUT - 133)) | (1L << (INSERT - 133)) | (1L << (INTERSECTION - 133)) | (1L << (ISCACHABLE - 133)) | (1L << (ISODOW - 133)) | (1L << (ISOYEAR - 133)) | (1L << (ISSTRICT - 133)) | (1L << (LANGUAGE - 133)) | (1L << (LARGE - 133)) | (1L << (LAST - 133)) | (1L << (LESS - 133)) | (1L << (LIST - 133)) | (1L << (LOCATION - 133)) | (1L << (MATCH - 133)) | (1L << (MAX - 133)) | (1L << (MAXVALUE - 133)) | (1L << (MICROSECONDS - 133)) | (1L << (MILLENNIUM - 133)) | (1L << (MILLISECONDS - 133)) | (1L << (MIN - 133)) | (1L << (MINVALUE - 133)))) != 0) || ((((_la - 197)) & ~0x3f) == 0 && ((1L << (_la - 197)) & ((1L << (MINUTE - 197)) | (1L << (MONTH - 197)) | (1L << (NATIONAL - 197)) | (1L << (NO - 197)) | (1L << (NONE - 197)) | (1L << (NULLIF - 197)) | (1L << (OBJECT - 197)) | (1L << (OPTION - 197)) | (1L << (OPTIONS - 197)) | (1L << (OVERWRITE - 197)) | (1L << (PARSER - 197)) | (1L << (PARTIAL - 197)) | (1L << (PARTITION - 197)) | (1L << (PARTITIONS - 197)) | (1L << (PRECISION - 197)) | (1L << (PUBLIC - 197)) | (1L << (PURGE - 197)) | (1L << (QUARTER - 197)) | (1L << (RANGE - 197)) | (1L << (REGEXP - 197)) | (1L << (RLIKE - 197)) | (1L << (ROLLUP - 197)) | (1L << (SEARCH - 197)) | (1L << (SECOND - 197)) | (1L << (SECURITY - 197)) | (1L << (SERVER - 197)) | (1L << (SET - 197)) | (1L << (SIMILAR - 197)) | (1L << (SIMPLE - 197)) | (1L << (STABLE - 197)) | (1L << (START - 197)) | (1L << (STORAGE - 197)) | (1L << (STDDEV_POP - 197)) | (1L << (STDDEV_SAMP - 197)) | (1L << (SUBPARTITION - 197)) | (1L << (SUM - 197)) | (1L << (TABLESPACE - 197)) | (1L << (TEMPLATE - 197)) | (1L << (THAN - 197)) | (1L << (TIMEZONE - 197)) | (1L << (TIMEZONE_HOUR - 197)) | (1L << (TIMEZONE_MINUTE - 197)) | (1L << (TRIM - 197)) | (1L << (TO - 197)) | (1L << (TYPE - 197)) | (1L << (UNKNOWN - 197)) | (1L << (UNLOGGED - 197)) | (1L << (VALUES - 197)) | (1L << (VAR_SAMP - 197)) | (1L << (VAR_POP - 197)) | (1L << (VARYING - 197)) | (1L << (VOLATILE - 197)) | (1L << (WEEK - 197)) | (1L << (WINDOW - 197)) | (1L << (WRAPPER - 197)) | (1L << (YEAR - 197)) | (1L << (ZONE - 197)) | (1L << (BOOLEAN - 197)) | (1L << (BOOL - 197)) | (1L << (BIT - 197)) | (1L << (VARBIT - 197)) | (1L << (INT1 - 197)))) != 0) || ((((_la - 261)) & ~0x3f) == 0 && ((1L << (_la - 261)) & ((1L << (INT2 - 261)) | (1L << (INT4 - 261)) | (1L << (INT8 - 261)) | (1L << (TINYINT - 261)) | (1L << (SMALLINT - 261)) | (1L << (INT - 261)) | (1L << (INTEGER - 261)) | (1L << (BIGINT - 261)) | (1L << (FLOAT4 - 261)) | (1L << (FLOAT8 - 261)) | (1L << (REAL - 261)) | (1L << (REGCLASS - 261)) | (1L << (FLOAT - 261)) | (1L << (DOUBLE - 261)) | (1L << (NUMERIC - 261)) | (1L << (DECIMAL - 261)) | (1L << (CHAR - 261)) | (1L << (VARCHAR - 261)) | (1L << (NCHAR - 261)) | (1L << (NVARCHAR - 261)) | (1L << (DATE - 261)) | (1L << (TIME - 261)) | (1L << (TIMETZ - 261)) | (1L << (TIMESTAMP - 261)) | (1L << (TIMESTAMPTZ - 261)) | (1L << (TEXT - 261)) | (1L << (UUID - 261)) | (1L << (BINARY - 261)) | (1L << (VARBINARY - 261)) | (1L << (BLOB - 261)) | (1L << (BYTEA - 261)) | (1L << (INET4 - 261)) | (1L << (VOID - 261)) | (1L << (LEFT_PAREN - 261)) | (1L << (PLUS - 261)) | (1L << (MINUS - 261)) | (1L << (DOUBLE_QUOTE - 261)))) != 0) || ((((_la - 325)) & ~0x3f) == 0 && ((1L << (_la - 325)) & ((1L << (NUMBER - 325)) | (1L << (REAL_NUMBER - 325)) | (1L << (Identifier - 325)) | (1L << (Character_String_Literal - 325)))) != 0)) {
				{
				{
				setState(1666);
				_la = _input.LA(1);
				if (_la==IN || _la==INOUT || _la==OUT || _la==VARIADIC) {
					{
					setState(1665); ((Function_definitionContext)_localctx).arg_mode = argmode();
					}
				}

				setState(1669);
				switch ( getInterpreter().adaptivePredict(_input,222,_ctx) ) {
				case 1:
					{
					setState(1668); ((Function_definitionContext)_localctx).argname = identifier();
					}
					break;
				}
				setState(1673);
				switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
				case 1:
					{
					setState(1671); ((Function_definitionContext)_localctx).argtype_data = data_type();
					}
					break;
				case 2:
					{
					setState(1672); ((Function_definitionContext)_localctx).argtype_expres = value_expression();
					}
					break;
				}
				setState(1676);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1675); match(COMMA);
					}
				}

				}
				}
				setState(1682);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1683); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 42, RULE_functions_definition_schema);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1685); match(ALL);
			setState(1686); match(FUNCTIONS);
			setState(1687); match(IN);
			setState(1688); match(SCHEMA);
			setState(1693); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1689); ((Functions_definition_schemaContext)_localctx).schema_name = identifier();
					setState(1691);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1690); match(COMMA);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1695); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,227,_ctx);
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
		enterRule(_localctx, 44, RULE_create_sequence_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1697); match(CREATE);
			setState(1699);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(1698);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1701); match(SEQUENCE);
			setState(1702); ((Create_sequence_statementContext)_localctx).name = schema_qualified_name();
			setState(1739);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,236,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(1737);
					switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
					case 1:
						{
						{
						setState(1703); match(INCREMENT);
						setState(1705);
						_la = _input.LA(1);
						if (_la==BY) {
							{
							setState(1704); match(BY);
							}
						}

						setState(1707); ((Create_sequence_statementContext)_localctx).incr = match(NUMBER);
						}
						}
						break;
					case 2:
						{
						setState(1712);
						switch (_input.LA(1)) {
						case MINVALUE:
							{
							setState(1708); match(MINVALUE);
							setState(1709); ((Create_sequence_statementContext)_localctx).minval = match(NUMBER);
							}
							break;
						case NO:
							{
							setState(1710); match(NO);
							setState(1711); match(MINVALUE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 3:
						{
						setState(1718);
						switch (_input.LA(1)) {
						case MAXVALUE:
							{
							setState(1714); match(MAXVALUE);
							setState(1715); ((Create_sequence_statementContext)_localctx).maxval = numeric_type();
							}
							break;
						case NO:
							{
							setState(1716); match(NO);
							setState(1717); match(MAXVALUE);
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
						setState(1720); match(START);
						setState(1722);
						_la = _input.LA(1);
						if (_la==WITH) {
							{
							setState(1721); match(WITH);
							}
						}

						setState(1724); ((Create_sequence_statementContext)_localctx).start_val = match(NUMBER);
						}
						}
						break;
					case 5:
						{
						{
						setState(1725); match(CACHE);
						setState(1726); ((Create_sequence_statementContext)_localctx).cache_val = match(NUMBER);
						}
						}
						break;
					case 6:
						{
						{
						setState(1728);
						_la = _input.LA(1);
						if (_la==NO) {
							{
							setState(1727); match(NO);
							}
						}

						setState(1730); match(CYCLE);
						}
						}
						break;
					case 7:
						{
						{
						setState(1731); match(OWNED);
						setState(1732); match(BY);
						setState(1735);
						switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
						case 1:
							{
							setState(1733); ((Create_sequence_statementContext)_localctx).col_name = schema_qualified_name();
							}
							break;
						case 2:
							{
							setState(1734); match(NONE);
							}
							break;
						}
						}
						}
						break;
					}
					} 
				}
				setState(1741);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,236,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 46, RULE_create_schema_statement);
		int _la;
		try {
			int _alt;
			setState(1782);
			switch ( getInterpreter().adaptivePredict(_input,241,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1742); match(CREATE);
				setState(1743); match(SCHEMA);
				setState(1744); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(1747);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(1745); match(AUTHORIZATION);
					setState(1746); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				setState(1752);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,238,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1749); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(1754);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,238,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1755); match(CREATE);
				setState(1756); match(SCHEMA);
				setState(1757); match(AUTHORIZATION);
				setState(1758); ((Create_schema_statementContext)_localctx).user_name = identifier();
				setState(1762);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,239,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1759); ((Create_schema_statementContext)_localctx).schema_element = sql();
						}
						} 
					}
					setState(1764);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,239,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1765); match(CREATE);
				setState(1766); match(SCHEMA);
				setState(1767); match(IF);
				setState(1768); match(NOT);
				setState(1769); match(EXISTS);
				setState(1770); ((Create_schema_statementContext)_localctx).schema_name = identifier();
				setState(1773);
				_la = _input.LA(1);
				if (_la==AUTHORIZATION) {
					{
					setState(1771); match(AUTHORIZATION);
					setState(1772); ((Create_schema_statementContext)_localctx).user_name = identifier();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1775); match(CREATE);
				setState(1776); match(SCHEMA);
				setState(1777); match(IF);
				setState(1778); match(NOT);
				setState(1779); match(EXISTS);
				setState(1780); match(AUTHORIZATION);
				setState(1781); ((Create_schema_statementContext)_localctx).user_name = identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 48, RULE_create_view_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1784); match(CREATE);
			setState(1787);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(1785); match(OR);
				setState(1786); match(REPLACE);
				}
			}

			setState(1790);
			_la = _input.LA(1);
			if (_la==TEMP || _la==TEMPORARY) {
				{
				setState(1789);
				_la = _input.LA(1);
				if ( !(_la==TEMP || _la==TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1792); match(VIEW);
			setState(1793); ((Create_view_statementContext)_localctx).name = schema_qualified_name();
			setState(1800);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier) {
				{
				{
				setState(1794); ((Create_view_statementContext)_localctx).column_name = identifier();
				setState(1796);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1795); match(COMMA);
					}
				}

				}
				}
				setState(1802);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1816);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1803); match(WITH);
				setState(1804); match(LEFT_PAREN);
				setState(1810); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1805); ((Create_view_statementContext)_localctx).view_option_name = identifier();
					setState(1808);
					_la = _input.LA(1);
					if (_la==EQUAL) {
						{
						setState(1806); match(EQUAL);
						setState(1807); ((Create_view_statementContext)_localctx).view_option_value = identifier();
						}
					}

					}
					}
					setState(1812); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1814); match(RIGHT_PAREN);
				}
			}

			setState(1818); match(AS);
			setState(1819); query_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 50, RULE_query);
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
		enterRule(_localctx, 52, RULE_create_table_statement);
		int _la;
		try {
			int _alt;
			setState(1935);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1823); match(CREATE);
				setState(1829);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1825);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1824);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1827);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1828); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1831); match(TABLE);
				setState(1835);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1832); match(IF);
					setState(1833); match(NOT);
					setState(1834); match(EXISTS);
					}
				}

				setState(1837); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1838); match(LEFT_PAREN);
				setState(1869);
				_la = _input.LA(1);
				if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (CONSTRAINT - 18)) | (1L << (EXCLUDE - 18)) | (1L << (FOREIGN - 18)) | (1L << (LIKE - 18)))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (PRIMARY - 86)) | (1L << (UNIQUE - 86)) | (1L << (ADMIN - 86)) | (1L << (AVG - 86)) | (1L << (BETWEEN - 86)) | (1L << (BY - 86)) | (1L << (CACHE - 86)) | (1L << (CALLED - 86)) | (1L << (CLASS - 86)) | (1L << (CENTURY - 86)) | (1L << (CHARACTER - 86)) | (1L << (CHECK - 86)) | (1L << (COLLECT - 86)) | (1L << (COALESCE - 86)) | (1L << (COLUMN - 86)) | (1L << (COMMENT - 86)) | (1L << (COMMENTS - 86)) | (1L << (COMMIT - 86)) | (1L << (CONFIGURATION - 86)) | (1L << (COST - 86)) | (1L << (COUNT - 86)) | (1L << (CUBE - 86)) | (1L << (CURRENT - 86)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (CYCLE - 150)) | (1L << (DATA - 150)) | (1L << (DAY - 150)) | (1L << (DEC - 150)) | (1L << (DECADE - 150)) | (1L << (DEFINER - 150)) | (1L << (DICTIONARY - 150)) | (1L << (DOW - 150)) | (1L << (DOY - 150)) | (1L << (DROP - 150)) | (1L << (EPOCH - 150)) | (1L << (EVERY - 150)) | (1L << (EXISTS - 150)) | (1L << (EXTERNAL - 150)) | (1L << (EXTRACT - 150)) | (1L << (FAMILY - 150)) | (1L << (FILTER - 150)) | (1L << (FIRST - 150)) | (1L << (FORMAT - 150)) | (1L << (FUSION - 150)) | (1L << (GROUPING - 150)) | (1L << (HASH - 150)) | (1L << (INDEX - 150)) | (1L << (INCREMENT - 150)) | (1L << (INPUT - 150)) | (1L << (INSERT - 150)) | (1L << (INTERSECTION - 150)) | (1L << (ISCACHABLE - 150)) | (1L << (ISODOW - 150)) | (1L << (ISOYEAR - 150)) | (1L << (ISSTRICT - 150)) | (1L << (LANGUAGE - 150)) | (1L << (LARGE - 150)) | (1L << (LAST - 150)) | (1L << (LESS - 150)) | (1L << (LIST - 150)) | (1L << (LOCATION - 150)) | (1L << (MATCH - 150)) | (1L << (MAX - 150)) | (1L << (MAXVALUE - 150)) | (1L << (MICROSECONDS - 150)) | (1L << (MILLENNIUM - 150)) | (1L << (MILLISECONDS - 150)) | (1L << (MIN - 150)) | (1L << (MINVALUE - 150)) | (1L << (MINUTE - 150)) | (1L << (MONTH - 150)) | (1L << (NATIONAL - 150)) | (1L << (NO - 150)) | (1L << (NONE - 150)) | (1L << (NULLIF - 150)) | (1L << (OBJECT - 150)) | (1L << (OPTION - 150)) | (1L << (OPTIONS - 150)) | (1L << (OVERWRITE - 150)) | (1L << (PARSER - 150)) | (1L << (PARTIAL - 150)) | (1L << (PARTITION - 150)) | (1L << (PARTITIONS - 150)) | (1L << (PRECISION - 150)) | (1L << (PUBLIC - 150)) | (1L << (PURGE - 150)))) != 0) || ((((_la - 214)) & ~0x3f) == 0 && ((1L << (_la - 214)) & ((1L << (QUARTER - 214)) | (1L << (RANGE - 214)) | (1L << (REGEXP - 214)) | (1L << (RLIKE - 214)) | (1L << (ROLLUP - 214)) | (1L << (SEARCH - 214)) | (1L << (SECOND - 214)) | (1L << (SECURITY - 214)) | (1L << (SERVER - 214)) | (1L << (SET - 214)) | (1L << (SIMILAR - 214)) | (1L << (SIMPLE - 214)) | (1L << (STABLE - 214)) | (1L << (START - 214)) | (1L << (STORAGE - 214)) | (1L << (STDDEV_POP - 214)) | (1L << (STDDEV_SAMP - 214)) | (1L << (SUBPARTITION - 214)) | (1L << (SUM - 214)) | (1L << (TABLESPACE - 214)) | (1L << (TEMPLATE - 214)) | (1L << (THAN - 214)) | (1L << (TIMEZONE - 214)) | (1L << (TIMEZONE_HOUR - 214)) | (1L << (TIMEZONE_MINUTE - 214)) | (1L << (TRIM - 214)) | (1L << (TO - 214)) | (1L << (TYPE - 214)) | (1L << (UNKNOWN - 214)) | (1L << (UNLOGGED - 214)) | (1L << (VALUES - 214)) | (1L << (VAR_SAMP - 214)) | (1L << (VAR_POP - 214)) | (1L << (VARYING - 214)) | (1L << (VOLATILE - 214)) | (1L << (WEEK - 214)) | (1L << (WINDOW - 214)) | (1L << (WRAPPER - 214)) | (1L << (YEAR - 214)) | (1L << (ZONE - 214)) | (1L << (BOOLEAN - 214)) | (1L << (BOOL - 214)) | (1L << (BIT - 214)) | (1L << (VARBIT - 214)) | (1L << (INT1 - 214)) | (1L << (INT2 - 214)) | (1L << (INT4 - 214)) | (1L << (INT8 - 214)) | (1L << (TINYINT - 214)) | (1L << (SMALLINT - 214)) | (1L << (INT - 214)) | (1L << (INTEGER - 214)) | (1L << (BIGINT - 214)) | (1L << (FLOAT4 - 214)) | (1L << (FLOAT8 - 214)) | (1L << (REAL - 214)) | (1L << (FLOAT - 214)) | (1L << (DOUBLE - 214)) | (1L << (NUMERIC - 214)) | (1L << (DECIMAL - 214)) | (1L << (CHAR - 214)))) != 0) || ((((_la - 278)) & ~0x3f) == 0 && ((1L << (_la - 278)) & ((1L << (VARCHAR - 278)) | (1L << (NCHAR - 278)) | (1L << (NVARCHAR - 278)) | (1L << (DATE - 278)) | (1L << (TIME - 278)) | (1L << (TIMETZ - 278)) | (1L << (TIMESTAMP - 278)) | (1L << (TIMESTAMPTZ - 278)) | (1L << (TEXT - 278)) | (1L << (UUID - 278)) | (1L << (VARBINARY - 278)) | (1L << (BLOB - 278)) | (1L << (BYTEA - 278)) | (1L << (INET4 - 278)) | (1L << (VOID - 278)) | (1L << (DOUBLE_QUOTE - 278)) | (1L << (Identifier - 278)))) != 0)) {
					{
					setState(1865); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1860);
						switch ( getInterpreter().adaptivePredict(_input,255,_ctx) ) {
						case 1:
							{
							{
							setState(1839); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1840); ((Create_table_statementContext)_localctx).datatype = data_type();
							setState(1843);
							_la = _input.LA(1);
							if (_la==COLLATE) {
								{
								setState(1841); match(COLLATE);
								setState(1842); ((Create_table_statementContext)_localctx).collation = identifier();
								}
							}

							setState(1848);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,253,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1845); ((Create_table_statementContext)_localctx).colmn_constraint = column_constraint();
									}
									} 
								}
								setState(1850);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,253,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1851); ((Create_table_statementContext)_localctx).tabl_constraint = table_constraint();
							}
							break;
						case 3:
							{
							{
							setState(1852); match(LIKE);
							setState(1853); ((Create_table_statementContext)_localctx).parent_table = identifier();
							setState(1857);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==EXCLUDING || _la==INCLUDING) {
								{
								{
								setState(1854); ((Create_table_statementContext)_localctx).like_opt = like_option();
								}
								}
								setState(1859);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							break;
						}
						setState(1863);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1862); match(COMMA);
							}
						}

						}
						}
						setState(1867); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (CONSTRAINT - 18)) | (1L << (EXCLUDE - 18)) | (1L << (FOREIGN - 18)) | (1L << (LIKE - 18)))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (PRIMARY - 86)) | (1L << (UNIQUE - 86)) | (1L << (ADMIN - 86)) | (1L << (AVG - 86)) | (1L << (BETWEEN - 86)) | (1L << (BY - 86)) | (1L << (CACHE - 86)) | (1L << (CALLED - 86)) | (1L << (CLASS - 86)) | (1L << (CENTURY - 86)) | (1L << (CHARACTER - 86)) | (1L << (CHECK - 86)) | (1L << (COLLECT - 86)) | (1L << (COALESCE - 86)) | (1L << (COLUMN - 86)) | (1L << (COMMENT - 86)) | (1L << (COMMENTS - 86)) | (1L << (COMMIT - 86)) | (1L << (CONFIGURATION - 86)) | (1L << (COST - 86)) | (1L << (COUNT - 86)) | (1L << (CUBE - 86)) | (1L << (CURRENT - 86)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (CYCLE - 150)) | (1L << (DATA - 150)) | (1L << (DAY - 150)) | (1L << (DEC - 150)) | (1L << (DECADE - 150)) | (1L << (DEFINER - 150)) | (1L << (DICTIONARY - 150)) | (1L << (DOW - 150)) | (1L << (DOY - 150)) | (1L << (DROP - 150)) | (1L << (EPOCH - 150)) | (1L << (EVERY - 150)) | (1L << (EXISTS - 150)) | (1L << (EXTERNAL - 150)) | (1L << (EXTRACT - 150)) | (1L << (FAMILY - 150)) | (1L << (FILTER - 150)) | (1L << (FIRST - 150)) | (1L << (FORMAT - 150)) | (1L << (FUSION - 150)) | (1L << (GROUPING - 150)) | (1L << (HASH - 150)) | (1L << (INDEX - 150)) | (1L << (INCREMENT - 150)) | (1L << (INPUT - 150)) | (1L << (INSERT - 150)) | (1L << (INTERSECTION - 150)) | (1L << (ISCACHABLE - 150)) | (1L << (ISODOW - 150)) | (1L << (ISOYEAR - 150)) | (1L << (ISSTRICT - 150)) | (1L << (LANGUAGE - 150)) | (1L << (LARGE - 150)) | (1L << (LAST - 150)) | (1L << (LESS - 150)) | (1L << (LIST - 150)) | (1L << (LOCATION - 150)) | (1L << (MATCH - 150)) | (1L << (MAX - 150)) | (1L << (MAXVALUE - 150)) | (1L << (MICROSECONDS - 150)) | (1L << (MILLENNIUM - 150)) | (1L << (MILLISECONDS - 150)) | (1L << (MIN - 150)) | (1L << (MINVALUE - 150)) | (1L << (MINUTE - 150)) | (1L << (MONTH - 150)) | (1L << (NATIONAL - 150)) | (1L << (NO - 150)) | (1L << (NONE - 150)) | (1L << (NULLIF - 150)) | (1L << (OBJECT - 150)) | (1L << (OPTION - 150)) | (1L << (OPTIONS - 150)) | (1L << (OVERWRITE - 150)) | (1L << (PARSER - 150)) | (1L << (PARTIAL - 150)) | (1L << (PARTITION - 150)) | (1L << (PARTITIONS - 150)) | (1L << (PRECISION - 150)) | (1L << (PUBLIC - 150)) | (1L << (PURGE - 150)))) != 0) || ((((_la - 214)) & ~0x3f) == 0 && ((1L << (_la - 214)) & ((1L << (QUARTER - 214)) | (1L << (RANGE - 214)) | (1L << (REGEXP - 214)) | (1L << (RLIKE - 214)) | (1L << (ROLLUP - 214)) | (1L << (SEARCH - 214)) | (1L << (SECOND - 214)) | (1L << (SECURITY - 214)) | (1L << (SERVER - 214)) | (1L << (SET - 214)) | (1L << (SIMILAR - 214)) | (1L << (SIMPLE - 214)) | (1L << (STABLE - 214)) | (1L << (START - 214)) | (1L << (STORAGE - 214)) | (1L << (STDDEV_POP - 214)) | (1L << (STDDEV_SAMP - 214)) | (1L << (SUBPARTITION - 214)) | (1L << (SUM - 214)) | (1L << (TABLESPACE - 214)) | (1L << (TEMPLATE - 214)) | (1L << (THAN - 214)) | (1L << (TIMEZONE - 214)) | (1L << (TIMEZONE_HOUR - 214)) | (1L << (TIMEZONE_MINUTE - 214)) | (1L << (TRIM - 214)) | (1L << (TO - 214)) | (1L << (TYPE - 214)) | (1L << (UNKNOWN - 214)) | (1L << (UNLOGGED - 214)) | (1L << (VALUES - 214)) | (1L << (VAR_SAMP - 214)) | (1L << (VAR_POP - 214)) | (1L << (VARYING - 214)) | (1L << (VOLATILE - 214)) | (1L << (WEEK - 214)) | (1L << (WINDOW - 214)) | (1L << (WRAPPER - 214)) | (1L << (YEAR - 214)) | (1L << (ZONE - 214)) | (1L << (BOOLEAN - 214)) | (1L << (BOOL - 214)) | (1L << (BIT - 214)) | (1L << (VARBIT - 214)) | (1L << (INT1 - 214)) | (1L << (INT2 - 214)) | (1L << (INT4 - 214)) | (1L << (INT8 - 214)) | (1L << (TINYINT - 214)) | (1L << (SMALLINT - 214)) | (1L << (INT - 214)) | (1L << (INTEGER - 214)) | (1L << (BIGINT - 214)) | (1L << (FLOAT4 - 214)) | (1L << (FLOAT8 - 214)) | (1L << (REAL - 214)) | (1L << (FLOAT - 214)) | (1L << (DOUBLE - 214)) | (1L << (NUMERIC - 214)) | (1L << (DECIMAL - 214)) | (1L << (CHAR - 214)))) != 0) || ((((_la - 278)) & ~0x3f) == 0 && ((1L << (_la - 278)) & ((1L << (VARCHAR - 278)) | (1L << (NCHAR - 278)) | (1L << (NVARCHAR - 278)) | (1L << (DATE - 278)) | (1L << (TIME - 278)) | (1L << (TIMETZ - 278)) | (1L << (TIMESTAMP - 278)) | (1L << (TIMESTAMPTZ - 278)) | (1L << (TEXT - 278)) | (1L << (UUID - 278)) | (1L << (VARBINARY - 278)) | (1L << (BLOB - 278)) | (1L << (BYTEA - 278)) | (1L << (INET4 - 278)) | (1L << (VOID - 278)) | (1L << (DOUBLE_QUOTE - 278)) | (1L << (Identifier - 278)))) != 0) );
					}
				}

				setState(1871); match(RIGHT_PAREN);
				setState(1884);
				_la = _input.LA(1);
				if (_la==INHERITS) {
					{
					setState(1872); match(INHERITS);
					setState(1873); match(LEFT_PAREN);
					setState(1878); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1874); ((Create_table_statementContext)_localctx).parent_table = identifier();
						setState(1876);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1875); match(COMMA);
							}
						}

						}
						}
						setState(1880); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					setState(1882); match(RIGHT_PAREN);
					}
				}

				setState(1886); storage_parameter_oid();
				setState(1887); on_commit();
				setState(1888); table_space();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1890); match(CREATE);
				setState(1896);
				switch (_input.LA(1)) {
				case GLOBAL:
				case LOCAL:
				case TEMP:
				case TEMPORARY:
					{
					setState(1892);
					_la = _input.LA(1);
					if (_la==GLOBAL || _la==LOCAL) {
						{
						setState(1891);
						_la = _input.LA(1);
						if ( !(_la==GLOBAL || _la==LOCAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(1894);
					_la = _input.LA(1);
					if ( !(_la==TEMP || _la==TEMPORARY) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case UNLOGGED:
					{
					setState(1895); match(UNLOGGED);
					}
					break;
				case TABLE:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1898); match(TABLE);
				setState(1902);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1899); match(IF);
					setState(1900); match(NOT);
					setState(1901); match(EXISTS);
					}
				}

				setState(1904); ((Create_table_statementContext)_localctx).n = schema_qualified_name();
				setState(1905); match(OF);
				setState(1906); ((Create_table_statementContext)_localctx).type_name = identifier();
				setState(1929);
				switch ( getInterpreter().adaptivePredict(_input,269,_ctx) ) {
				case 1:
					{
					setState(1907); match(LEFT_PAREN);
					setState(1923); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1918);
						switch ( getInterpreter().adaptivePredict(_input,266,_ctx) ) {
						case 1:
							{
							{
							setState(1908); ((Create_table_statementContext)_localctx).column_name = identifier();
							setState(1909); match(WITH);
							setState(1910); match(OPTIONS);
							setState(1914);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,265,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(1911); ((Create_table_statementContext)_localctx).col_constraint = column_constraint();
									}
									} 
								}
								setState(1916);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,265,_ctx);
							}
							}
							}
							break;
						case 2:
							{
							setState(1917); table_constraint();
							}
							break;
						}
						setState(1921);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(1920); match(COMMA);
							}
						}

						}
						}
						setState(1925); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTRAINT) | (1L << EXCLUDE) | (1L << FOREIGN))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (PRIMARY - 86)) | (1L << (UNIQUE - 86)) | (1L << (ADMIN - 86)) | (1L << (AVG - 86)) | (1L << (BETWEEN - 86)) | (1L << (BY - 86)) | (1L << (CACHE - 86)) | (1L << (CALLED - 86)) | (1L << (CLASS - 86)) | (1L << (CENTURY - 86)) | (1L << (CHARACTER - 86)) | (1L << (CHECK - 86)) | (1L << (COLLECT - 86)) | (1L << (COALESCE - 86)) | (1L << (COLUMN - 86)) | (1L << (COMMENT - 86)) | (1L << (COMMENTS - 86)) | (1L << (COMMIT - 86)) | (1L << (CONFIGURATION - 86)) | (1L << (COST - 86)) | (1L << (COUNT - 86)) | (1L << (CUBE - 86)) | (1L << (CURRENT - 86)))) != 0) || ((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (CYCLE - 150)) | (1L << (DATA - 150)) | (1L << (DAY - 150)) | (1L << (DEC - 150)) | (1L << (DECADE - 150)) | (1L << (DEFINER - 150)) | (1L << (DICTIONARY - 150)) | (1L << (DOW - 150)) | (1L << (DOY - 150)) | (1L << (DROP - 150)) | (1L << (EPOCH - 150)) | (1L << (EVERY - 150)) | (1L << (EXISTS - 150)) | (1L << (EXTERNAL - 150)) | (1L << (EXTRACT - 150)) | (1L << (FAMILY - 150)) | (1L << (FILTER - 150)) | (1L << (FIRST - 150)) | (1L << (FORMAT - 150)) | (1L << (FUSION - 150)) | (1L << (GROUPING - 150)) | (1L << (HASH - 150)) | (1L << (INDEX - 150)) | (1L << (INCREMENT - 150)) | (1L << (INPUT - 150)) | (1L << (INSERT - 150)) | (1L << (INTERSECTION - 150)) | (1L << (ISCACHABLE - 150)) | (1L << (ISODOW - 150)) | (1L << (ISOYEAR - 150)) | (1L << (ISSTRICT - 150)) | (1L << (LANGUAGE - 150)) | (1L << (LARGE - 150)) | (1L << (LAST - 150)) | (1L << (LESS - 150)) | (1L << (LIST - 150)) | (1L << (LOCATION - 150)) | (1L << (MATCH - 150)) | (1L << (MAX - 150)) | (1L << (MAXVALUE - 150)) | (1L << (MICROSECONDS - 150)) | (1L << (MILLENNIUM - 150)) | (1L << (MILLISECONDS - 150)) | (1L << (MIN - 150)) | (1L << (MINVALUE - 150)) | (1L << (MINUTE - 150)) | (1L << (MONTH - 150)) | (1L << (NATIONAL - 150)) | (1L << (NO - 150)) | (1L << (NONE - 150)) | (1L << (NULLIF - 150)) | (1L << (OBJECT - 150)) | (1L << (OPTION - 150)) | (1L << (OPTIONS - 150)) | (1L << (OVERWRITE - 150)) | (1L << (PARSER - 150)) | (1L << (PARTIAL - 150)) | (1L << (PARTITION - 150)) | (1L << (PARTITIONS - 150)) | (1L << (PRECISION - 150)) | (1L << (PUBLIC - 150)) | (1L << (PURGE - 150)))) != 0) || ((((_la - 214)) & ~0x3f) == 0 && ((1L << (_la - 214)) & ((1L << (QUARTER - 214)) | (1L << (RANGE - 214)) | (1L << (REGEXP - 214)) | (1L << (RLIKE - 214)) | (1L << (ROLLUP - 214)) | (1L << (SEARCH - 214)) | (1L << (SECOND - 214)) | (1L << (SECURITY - 214)) | (1L << (SERVER - 214)) | (1L << (SET - 214)) | (1L << (SIMILAR - 214)) | (1L << (SIMPLE - 214)) | (1L << (STABLE - 214)) | (1L << (START - 214)) | (1L << (STORAGE - 214)) | (1L << (STDDEV_POP - 214)) | (1L << (STDDEV_SAMP - 214)) | (1L << (SUBPARTITION - 214)) | (1L << (SUM - 214)) | (1L << (TABLESPACE - 214)) | (1L << (TEMPLATE - 214)) | (1L << (THAN - 214)) | (1L << (TIMEZONE - 214)) | (1L << (TIMEZONE_HOUR - 214)) | (1L << (TIMEZONE_MINUTE - 214)) | (1L << (TRIM - 214)) | (1L << (TO - 214)) | (1L << (TYPE - 214)) | (1L << (UNKNOWN - 214)) | (1L << (UNLOGGED - 214)) | (1L << (VALUES - 214)) | (1L << (VAR_SAMP - 214)) | (1L << (VAR_POP - 214)) | (1L << (VARYING - 214)) | (1L << (VOLATILE - 214)) | (1L << (WEEK - 214)) | (1L << (WINDOW - 214)) | (1L << (WRAPPER - 214)) | (1L << (YEAR - 214)) | (1L << (ZONE - 214)) | (1L << (BOOLEAN - 214)) | (1L << (BOOL - 214)) | (1L << (BIT - 214)) | (1L << (VARBIT - 214)) | (1L << (INT1 - 214)) | (1L << (INT2 - 214)) | (1L << (INT4 - 214)) | (1L << (INT8 - 214)) | (1L << (TINYINT - 214)) | (1L << (SMALLINT - 214)) | (1L << (INT - 214)) | (1L << (INTEGER - 214)) | (1L << (BIGINT - 214)) | (1L << (FLOAT4 - 214)) | (1L << (FLOAT8 - 214)) | (1L << (REAL - 214)) | (1L << (FLOAT - 214)) | (1L << (DOUBLE - 214)) | (1L << (NUMERIC - 214)) | (1L << (DECIMAL - 214)) | (1L << (CHAR - 214)))) != 0) || ((((_la - 278)) & ~0x3f) == 0 && ((1L << (_la - 278)) & ((1L << (VARCHAR - 278)) | (1L << (NCHAR - 278)) | (1L << (NVARCHAR - 278)) | (1L << (DATE - 278)) | (1L << (TIME - 278)) | (1L << (TIMETZ - 278)) | (1L << (TIMESTAMP - 278)) | (1L << (TIMESTAMPTZ - 278)) | (1L << (TEXT - 278)) | (1L << (UUID - 278)) | (1L << (VARBINARY - 278)) | (1L << (BLOB - 278)) | (1L << (BYTEA - 278)) | (1L << (INET4 - 278)) | (1L << (VOID - 278)) | (1L << (DOUBLE_QUOTE - 278)) | (1L << (Identifier - 278)))) != 0) );
					setState(1927); match(RIGHT_PAREN);
					}
					break;
				}
				setState(1931); storage_parameter_oid();
				setState(1932); on_commit();
				setState(1933); table_space();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 54, RULE_like_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1937);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(1938);
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
		enterRule(_localctx, 56, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1942);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1940); match(CONSTRAINT);
				setState(1941); ((Table_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2042);
			switch (_input.LA(1)) {
			case CHECK:
				{
				setState(1944); check_boolean_expression();
				}
				break;
			case UNIQUE:
				{
				{
				setState(1945); match(UNIQUE);
				setState(1946); match(LEFT_PAREN);
				setState(1951); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1947); ((Table_constraintContext)_localctx).column_name_unique = identifier();
					setState(1949);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1948); match(COMMA);
						}
					}

					}
					}
					setState(1953); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1955); match(RIGHT_PAREN);
				setState(1956); ((Table_constraintContext)_localctx).index_parameters_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(1958); match(PRIMARY);
				setState(1959); match(KEY);
				setState(1960); match(LEFT_PAREN);
				setState(1965); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1961); ((Table_constraintContext)_localctx).column_name_pr_key = identifier();
					setState(1963);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1962); match(COMMA);
						}
					}

					}
					}
					setState(1967); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1969); match(RIGHT_PAREN);
				setState(1970); ((Table_constraintContext)_localctx).index_parameters_pr_key = index_parameters();
				}
				}
				break;
			case EXCLUDE:
				{
				{
				setState(1972); match(EXCLUDE);
				setState(1975);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1973); match(USING);
					setState(1974); ((Table_constraintContext)_localctx).index_method = identifier();
					}
				}

				setState(1977); match(LEFT_PAREN);
				setState(1978); ((Table_constraintContext)_localctx).exclude_element = identifier();
				setState(1979); match(WITH);
				setState(1984); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1980); ((Table_constraintContext)_localctx).operator = identifier();
					setState(1982);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1981); match(COMMA);
						}
					}

					}
					}
					setState(1986); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(1988); match(RIGHT_PAREN);
				setState(1989); index_parameters();
				setState(1995);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1990); match(WHERE);
					setState(1991); match(LEFT_PAREN);
					setState(1992); ((Table_constraintContext)_localctx).predicat = identifier();
					setState(1993); match(RIGHT_PAREN);
					}
				}

				}
				}
				break;
			case FOREIGN:
				{
				{
				setState(1997); match(FOREIGN);
				setState(1998); match(KEY);
				setState(1999); match(LEFT_PAREN);
				setState(2004); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2000); ((Table_constraintContext)_localctx).column_name_for_key = identifier();
					setState(2002);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2001); match(COMMA);
						}
					}

					}
					}
					setState(2006); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
				setState(2008); match(RIGHT_PAREN);
				setState(2009); match(REFERENCES);
				setState(2010); ((Table_constraintContext)_localctx).reftable = identifier();
				setState(2022);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2011); match(LEFT_PAREN);
					setState(2016); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2012); ((Table_constraintContext)_localctx).refcolumn = identifier();
						setState(2014);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2013); match(COMMA);
							}
						}

						}
						}
						setState(2018); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
					setState(2020); match(RIGHT_PAREN);
					}
				}

				setState(2030);
				switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
				case 1:
					{
					{
					setState(2024); match(MATCH);
					setState(2025); match(FULL);
					}
					}
					break;
				case 2:
					{
					{
					setState(2026); match(MATCH);
					setState(2027); match(PARTIAL);
					}
					}
					break;
				case 3:
					{
					{
					setState(2028); match(MATCH);
					setState(2029); match(SIMPLE);
					}
					}
					break;
				}
				setState(2035);
				switch ( getInterpreter().adaptivePredict(_input,286,_ctx) ) {
				case 1:
					{
					setState(2032); match(ON);
					setState(2033); match(DELETE);
					setState(2034); ((Table_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2040);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(2037); match(ON);
					setState(2038); match(UPDATE);
					setState(2039); ((Table_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2047);
			switch (_input.LA(1)) {
			case DEFERRABLE:
				{
				setState(2044); match(DEFERRABLE);
				}
				break;
			case NOT:
				{
				{
				setState(2045); match(NOT);
				setState(2046); match(DEFERRABLE);
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
			setState(2053);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				{
				{
				setState(2049); match(INITIALLY);
				setState(2050); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2051); match(INITIALLY);
				setState(2052); match(IMMEDIATE);
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
		enterRule(_localctx, 58, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2057);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(2055); match(CONSTRAINT);
				setState(2056); ((Column_constraintContext)_localctx).constraint_name = identifier();
				}
			}

			setState(2094);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(2059); match(NOT);
				setState(2060); match(NULL);
				}
				break;
			case NULL:
				{
				setState(2061); match(NULL);
				}
				break;
			case CHECK:
				{
				setState(2062); check_boolean_expression();
				}
				break;
			case DEFAULT:
				{
				setState(2063); match(DEFAULT);
				setState(2066);
				switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
				case 1:
					{
					setState(2064); ((Column_constraintContext)_localctx).default_expr_data = data_type();
					}
					break;
				case 2:
					{
					setState(2065); ((Column_constraintContext)_localctx).default_expr = value_expression();
					}
					break;
				}
				}
				break;
			case UNIQUE:
				{
				{
				setState(2068); match(UNIQUE);
				setState(2069); ((Column_constraintContext)_localctx).index_params_unique = index_parameters();
				}
				}
				break;
			case PRIMARY:
				{
				{
				setState(2070); match(PRIMARY);
				setState(2071); match(KEY);
				setState(2072); ((Column_constraintContext)_localctx).index_params_pr_key = index_parameters();
				}
				}
				break;
			case REFERENCES:
				{
				{
				setState(2073); match(REFERENCES);
				setState(2074); ((Column_constraintContext)_localctx).reftable = schema_qualified_name();
				{
				{
				setState(2075); ((Column_constraintContext)_localctx).refcolumn = identifier();
				}
				}
				setState(2082);
				switch ( getInterpreter().adaptivePredict(_input,293,_ctx) ) {
				case 1:
					{
					setState(2076); match(MATCH);
					setState(2077); match(FULL);
					}
					break;
				case 2:
					{
					setState(2078); match(MATCH);
					setState(2079); match(PARTIAL);
					}
					break;
				case 3:
					{
					setState(2080); match(MATCH);
					setState(2081); match(SIMPLE);
					}
					break;
				}
				setState(2087);
				switch ( getInterpreter().adaptivePredict(_input,294,_ctx) ) {
				case 1:
					{
					setState(2084); match(ON);
					setState(2085); match(DELETE);
					setState(2086); ((Column_constraintContext)_localctx).action_on_delete = action();
					}
					break;
				}
				setState(2092);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(2089); match(ON);
					setState(2090); match(UPDATE);
					setState(2091); ((Column_constraintContext)_localctx).action_on_update = action();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2099);
			switch ( getInterpreter().adaptivePredict(_input,297,_ctx) ) {
			case 1:
				{
				setState(2096); match(DEFERRABLE);
				}
				break;
			case 2:
				{
				{
				setState(2097); match(NOT);
				setState(2098); match(DEFERRABLE);
				}
				}
				break;
			}
			setState(2105);
			switch ( getInterpreter().adaptivePredict(_input,298,_ctx) ) {
			case 1:
				{
				{
				setState(2101); match(INITIALLY);
				setState(2102); match(DEFERRED);
				}
				}
				break;
			case 2:
				{
				{
				setState(2103); match(INITIALLY);
				setState(2104); match(IMMEDIATE);
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
		enterRule(_localctx, 60, RULE_check_boolean_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2107); match(CHECK);
			setState(2108); match(LEFT_PAREN);
			setState(2109); ((Check_boolean_expressionContext)_localctx).expression = boolean_value_expression();
			setState(2110); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 62, RULE_storage_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2112); match(WITH);
			setState(2113); match(LEFT_PAREN);
			setState(2122); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2114); ((Storage_parameterContext)_localctx).storage_param = identifier();
				setState(2117);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(2115); match(EQUAL);
					setState(2116); ((Storage_parameterContext)_localctx).value = identifier();
					}
				}

				setState(2120);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2119); match(COMMA);
					}
				}

				}
				}
				setState(2124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0) || _la==DOUBLE_QUOTE || _la==Identifier );
			setState(2126); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 64, RULE_storage_parameter_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2133);
			switch ( getInterpreter().adaptivePredict(_input,302,_ctx) ) {
			case 1:
				{
				setState(2128); storage_parameter();
				}
				break;
			case 2:
				{
				{
				setState(2129); match(WITH);
				setState(2130); match(OIDS);
				}
				}
				break;
			case 3:
				{
				{
				setState(2131); match(WITHOUT);
				setState(2132); match(OIDS);
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
		enterRule(_localctx, 66, RULE_on_commit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2144);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(2135); match(ON);
				setState(2136); match(COMMIT);
				setState(2142);
				switch (_input.LA(1)) {
				case PRESERVE:
					{
					{
					setState(2137); match(PRESERVE);
					setState(2138); match(ROWS);
					}
					}
					break;
				case DELETE:
					{
					{
					setState(2139); match(DELETE);
					setState(2140); match(ROWS);
					}
					}
					break;
				case DROP:
					{
					setState(2141); match(DROP);
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
		enterRule(_localctx, 68, RULE_table_space);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2148);
			switch ( getInterpreter().adaptivePredict(_input,305,_ctx) ) {
			case 1:
				{
				setState(2146); match(TABLESPACE);
				setState(2147); ((Table_spaceContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 70, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2156);
			switch ( getInterpreter().adaptivePredict(_input,306,_ctx) ) {
			case 1:
				{
				setState(2150); match(RESTRICT);
				}
				break;
			case 2:
				{
				setState(2151); match(CASCADE);
				}
				break;
			case 3:
				{
				setState(2152); match(SET);
				setState(2153); match(NULL);
				}
				break;
			case 4:
				{
				setState(2154); match(SET);
				setState(2155); match(DEFAULT);
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
		enterRule(_localctx, 72, RULE_index_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2159);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(2158); storage_parameter();
				}
			}

			setState(2165);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(2161); match(USING);
				setState(2162); match(INDEX);
				setState(2163); match(TABLESPACE);
				setState(2164); ((Index_parametersContext)_localctx).tablespace = identifier();
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
		enterRule(_localctx, 74, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2167); match(LEFT_PAREN);
			setState(2168); field_element();
			setState(2173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2169); match(COMMA);
				setState(2170); field_element();
				}
				}
				setState(2175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2176); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 76, RULE_field_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2178); ((Field_elementContext)_localctx).name = identifier();
			setState(2179); field_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 78, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2181); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 80, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2183); match(WITH);
			setState(2184); match(LEFT_PAREN);
			setState(2185); param();
			setState(2190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2186); match(COMMA);
				setState(2187); param();
				}
				}
				setState(2192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2193); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 82, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2195); ((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(2196); match(EQUAL);
			setState(2197); ((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 84, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2199); match(USING);
			setState(2200); ((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 86, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2202); match(TABLESPACE);
			setState(2203); table_space_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 88, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2205); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 90, RULE_table_partitioning_clauses);
		try {
			setState(2211);
			switch ( getInterpreter().adaptivePredict(_input,311,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2207); range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2208); hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2209); list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2210); column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 92, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2213); match(PARTITION);
			setState(2214); match(BY);
			setState(2215); match(RANGE);
			setState(2216); match(LEFT_PAREN);
			setState(2217); column_reference_list();
			setState(2218); match(RIGHT_PAREN);
			setState(2219); match(LEFT_PAREN);
			setState(2220); range_value_clause_list();
			setState(2221); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 94, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2223); range_value_clause();
			setState(2228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2224); match(COMMA);
				setState(2225); range_value_clause();
				}
				}
				setState(2230);
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
		enterRule(_localctx, 96, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2231); match(PARTITION);
			setState(2232); partition_name();
			setState(2233); match(VALUES);
			setState(2234); match(LESS);
			setState(2235); match(THAN);
			setState(2247);
			switch ( getInterpreter().adaptivePredict(_input,315,_ctx) ) {
			case 1:
				{
				setState(2236); match(LEFT_PAREN);
				setState(2237); value_expression();
				setState(2238); match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(2241);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2240); match(LEFT_PAREN);
					}
				}

				setState(2243); match(MAXVALUE);
				setState(2245);
				switch ( getInterpreter().adaptivePredict(_input,314,_ctx) ) {
				case 1:
					{
					setState(2244); match(RIGHT_PAREN);
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
		enterRule(_localctx, 98, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2249); match(PARTITION);
			setState(2250); match(BY);
			setState(2251); match(HASH);
			setState(2252); match(LEFT_PAREN);
			setState(2253); column_reference_list();
			setState(2254); match(RIGHT_PAREN);
			setState(2260);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(2255); match(LEFT_PAREN);
				setState(2256); individual_hash_partitions();
				setState(2257); match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(2259); hash_partitions_by_quantity();
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
		enterRule(_localctx, 100, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2262); individual_hash_partition();
			setState(2267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2263); match(COMMA);
				setState(2264); individual_hash_partition();
				}
				}
				setState(2269);
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
		enterRule(_localctx, 102, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2270); match(PARTITION);
			setState(2271); partition_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 104, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2273); match(PARTITIONS);
			setState(2274); ((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 106, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2276); match(PARTITION);
			setState(2277); match(BY);
			setState(2278); match(LIST);
			setState(2279); match(LEFT_PAREN);
			setState(2280); column_reference_list();
			setState(2281); match(RIGHT_PAREN);
			setState(2282); match(LEFT_PAREN);
			setState(2283); list_value_clause_list();
			setState(2284); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 108, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2286); list_value_partition();
			setState(2291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2287); match(COMMA);
				setState(2288); list_value_partition();
				}
				}
				setState(2293);
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
		enterRule(_localctx, 110, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2294); match(PARTITION);
			setState(2295); partition_name();
			setState(2296); match(VALUES);
			setState(2298);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(2297); match(IN);
				}
			}

			setState(2300); match(LEFT_PAREN);
			setState(2301); in_value_list();
			setState(2302); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 112, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2304); match(PARTITION);
			setState(2305); match(BY);
			setState(2306); match(COLUMN);
			setState(2307); table_elements();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 114, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2309); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 116, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2311); match(DROP);
			setState(2312); match(TABLE);
			setState(2313); schema_qualified_name();
			setState(2315);
			switch ( getInterpreter().adaptivePredict(_input,320,_ctx) ) {
			case 1:
				{
				setState(2314); match(PURGE);
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
		enterRule(_localctx, 118, RULE_identifier);
		int _la;
		try {
			setState(2331);
			switch ( getInterpreter().adaptivePredict(_input,325,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2318);
				_la = _input.LA(1);
				if (_la==DOUBLE_QUOTE) {
					{
					setState(2317); match(DOUBLE_QUOTE);
					}
				}

				setState(2320); match(Identifier);
				setState(2322);
				switch ( getInterpreter().adaptivePredict(_input,322,_ctx) ) {
				case 1:
					{
					setState(2321); match(DOUBLE_QUOTE);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2325);
				_la = _input.LA(1);
				if (_la==DOUBLE_QUOTE) {
					{
					setState(2324); match(DOUBLE_QUOTE);
					}
				}

				setState(2327); nonreserved_keywords();
				setState(2329);
				switch ( getInterpreter().adaptivePredict(_input,324,_ctx) ) {
				case 1:
					{
					setState(2328); match(DOUBLE_QUOTE);
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
		public TerminalNode CALLED() { return getToken(SQLParser.CALLED, 0); }
		public TerminalNode SIMPLE() { return getToken(SQLParser.SIMPLE, 0); }
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
		enterRule(_localctx, 120, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2333);
			_la = _input.LA(1);
			if ( !(((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (ADMIN - 129)) | (1L << (AVG - 129)) | (1L << (BETWEEN - 129)) | (1L << (BY - 129)) | (1L << (CACHE - 129)) | (1L << (CALLED - 129)) | (1L << (CLASS - 129)) | (1L << (CENTURY - 129)) | (1L << (CHARACTER - 129)) | (1L << (CHECK - 129)) | (1L << (COLLECT - 129)) | (1L << (COALESCE - 129)) | (1L << (COLUMN - 129)) | (1L << (COMMENT - 129)) | (1L << (COMMENTS - 129)) | (1L << (COMMIT - 129)) | (1L << (CONFIGURATION - 129)) | (1L << (COST - 129)) | (1L << (COUNT - 129)) | (1L << (CUBE - 129)) | (1L << (CURRENT - 129)) | (1L << (CYCLE - 129)) | (1L << (DATA - 129)) | (1L << (DAY - 129)) | (1L << (DEC - 129)) | (1L << (DECADE - 129)) | (1L << (DEFINER - 129)) | (1L << (DICTIONARY - 129)) | (1L << (DOW - 129)) | (1L << (DOY - 129)) | (1L << (DROP - 129)) | (1L << (EPOCH - 129)) | (1L << (EVERY - 129)) | (1L << (EXISTS - 129)) | (1L << (EXTERNAL - 129)) | (1L << (EXTRACT - 129)) | (1L << (FAMILY - 129)) | (1L << (FILTER - 129)) | (1L << (FIRST - 129)) | (1L << (FORMAT - 129)) | (1L << (FUSION - 129)) | (1L << (GROUPING - 129)) | (1L << (HASH - 129)) | (1L << (INDEX - 129)) | (1L << (INCREMENT - 129)) | (1L << (INPUT - 129)) | (1L << (INSERT - 129)) | (1L << (INTERSECTION - 129)) | (1L << (ISCACHABLE - 129)) | (1L << (ISODOW - 129)) | (1L << (ISOYEAR - 129)) | (1L << (ISSTRICT - 129)) | (1L << (LANGUAGE - 129)) | (1L << (LARGE - 129)) | (1L << (LAST - 129)) | (1L << (LESS - 129)) | (1L << (LIST - 129)) | (1L << (LOCATION - 129)) | (1L << (MATCH - 129)) | (1L << (MAX - 129)) | (1L << (MAXVALUE - 129)) | (1L << (MICROSECONDS - 129)))) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (MILLENNIUM - 193)) | (1L << (MILLISECONDS - 193)) | (1L << (MIN - 193)) | (1L << (MINVALUE - 193)) | (1L << (MINUTE - 193)) | (1L << (MONTH - 193)) | (1L << (NATIONAL - 193)) | (1L << (NO - 193)) | (1L << (NONE - 193)) | (1L << (NULLIF - 193)) | (1L << (OBJECT - 193)) | (1L << (OPTION - 193)) | (1L << (OPTIONS - 193)) | (1L << (OVERWRITE - 193)) | (1L << (PARSER - 193)) | (1L << (PARTIAL - 193)) | (1L << (PARTITION - 193)) | (1L << (PARTITIONS - 193)) | (1L << (PRECISION - 193)) | (1L << (PUBLIC - 193)) | (1L << (PURGE - 193)) | (1L << (QUARTER - 193)) | (1L << (RANGE - 193)) | (1L << (REGEXP - 193)) | (1L << (RLIKE - 193)) | (1L << (ROLLUP - 193)) | (1L << (SEARCH - 193)) | (1L << (SECOND - 193)) | (1L << (SECURITY - 193)) | (1L << (SERVER - 193)) | (1L << (SET - 193)) | (1L << (SIMILAR - 193)) | (1L << (SIMPLE - 193)) | (1L << (STABLE - 193)) | (1L << (START - 193)) | (1L << (STORAGE - 193)) | (1L << (STDDEV_POP - 193)) | (1L << (STDDEV_SAMP - 193)) | (1L << (SUBPARTITION - 193)) | (1L << (SUM - 193)) | (1L << (TABLESPACE - 193)) | (1L << (TEMPLATE - 193)) | (1L << (THAN - 193)) | (1L << (TIMEZONE - 193)) | (1L << (TIMEZONE_HOUR - 193)) | (1L << (TIMEZONE_MINUTE - 193)) | (1L << (TRIM - 193)) | (1L << (TO - 193)) | (1L << (TYPE - 193)) | (1L << (UNKNOWN - 193)) | (1L << (UNLOGGED - 193)) | (1L << (VALUES - 193)) | (1L << (VAR_SAMP - 193)) | (1L << (VAR_POP - 193)) | (1L << (VARYING - 193)) | (1L << (VOLATILE - 193)) | (1L << (WEEK - 193)) | (1L << (WINDOW - 193)) | (1L << (WRAPPER - 193)) | (1L << (YEAR - 193)) | (1L << (ZONE - 193)) | (1L << (BOOLEAN - 193)))) != 0) || ((((_la - 257)) & ~0x3f) == 0 && ((1L << (_la - 257)) & ((1L << (BOOL - 257)) | (1L << (BIT - 257)) | (1L << (VARBIT - 257)) | (1L << (INT1 - 257)) | (1L << (INT2 - 257)) | (1L << (INT4 - 257)) | (1L << (INT8 - 257)) | (1L << (TINYINT - 257)) | (1L << (SMALLINT - 257)) | (1L << (INT - 257)) | (1L << (INTEGER - 257)) | (1L << (BIGINT - 257)) | (1L << (FLOAT4 - 257)) | (1L << (FLOAT8 - 257)) | (1L << (REAL - 257)) | (1L << (FLOAT - 257)) | (1L << (DOUBLE - 257)) | (1L << (NUMERIC - 257)) | (1L << (DECIMAL - 257)) | (1L << (CHAR - 257)) | (1L << (VARCHAR - 257)) | (1L << (NCHAR - 257)) | (1L << (NVARCHAR - 257)) | (1L << (DATE - 257)) | (1L << (TIME - 257)) | (1L << (TIMETZ - 257)) | (1L << (TIMESTAMP - 257)) | (1L << (TIMESTAMPTZ - 257)) | (1L << (TEXT - 257)) | (1L << (UUID - 257)) | (1L << (VARBINARY - 257)) | (1L << (BLOB - 257)) | (1L << (BYTEA - 257)) | (1L << (INET4 - 257)) | (1L << (VOID - 257)))) != 0)) ) {
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
		enterRule(_localctx, 122, RULE_unsigned_literal);
		try {
			setState(2337);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2335); unsigned_numeric_literal();
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
				setState(2336); general_literal();
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
		enterRule(_localctx, 124, RULE_general_literal);
		try {
			setState(2342);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2339); match(Character_String_Literal);
				}
				break;
			case DATE:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(2340); datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(2341); boolean_literal();
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
		enterRule(_localctx, 126, RULE_datetime_literal);
		try {
			setState(2347);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(2344); timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2345); time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2346); date_literal();
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
		enterRule(_localctx, 128, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2349); match(TIME);
			setState(2350); ((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 130, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2352); match(TIMESTAMP);
			setState(2353); ((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 132, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2355); match(DATE);
			setState(2356); ((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 134, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2358);
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
		enterRule(_localctx, 136, RULE_data_type);
		try {
			setState(2363);
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
				setState(2360); predefined_type();
				}
				break;
			case SETOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(2361); match(SETOF);
				setState(2362); ((Data_typeContext)_localctx).value = identifier();
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
		enterRule(_localctx, 138, RULE_predefined_type);
		try {
			setState(2378);
			switch (_input.LA(1)) {
			case CHARACTER:
			case CHAR:
			case VARCHAR:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2365); character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2366); national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(2367); binary_large_object_string_type();
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
				setState(2368); numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(2369); boolean_type();
				}
				break;
			case DATE:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
				enterOuterAlt(_localctx, 6);
				{
				setState(2370); datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2371); bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(2372); binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(2373); network_type();
				}
				break;
			case REGCLASS:
				enterOuterAlt(_localctx, 10);
				{
				setState(2374); regclass();
				}
				break;
			case TRIGGER:
				enterOuterAlt(_localctx, 11);
				{
				setState(2375); match(TRIGGER);
				}
				break;
			case UUID:
				enterOuterAlt(_localctx, 12);
				{
				setState(2376); match(UUID);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 13);
				{
				setState(2377); match(VOID);
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
		enterRule(_localctx, 140, RULE_regclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2380); match(REGCLASS);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 142, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2382); match(INET4);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 144, RULE_character_string_type);
		try {
			setState(2407);
			switch ( getInterpreter().adaptivePredict(_input,336,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2384); match(CHARACTER);
				setState(2386);
				switch ( getInterpreter().adaptivePredict(_input,331,_ctx) ) {
				case 1:
					{
					setState(2385); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2388); match(CHAR);
				setState(2390);
				switch ( getInterpreter().adaptivePredict(_input,332,_ctx) ) {
				case 1:
					{
					setState(2389); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2392); match(CHARACTER);
				setState(2393); match(VARYING);
				setState(2395);
				switch ( getInterpreter().adaptivePredict(_input,333,_ctx) ) {
				case 1:
					{
					setState(2394); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2397); match(CHAR);
				setState(2398); match(VARYING);
				setState(2400);
				switch ( getInterpreter().adaptivePredict(_input,334,_ctx) ) {
				case 1:
					{
					setState(2399); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2402); match(VARCHAR);
				setState(2404);
				switch ( getInterpreter().adaptivePredict(_input,335,_ctx) ) {
				case 1:
					{
					setState(2403); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2406); match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 146, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2409); match(LEFT_PAREN);
			setState(2410); match(NUMBER);
			setState(2411); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 148, RULE_national_character_string_type);
		try {
			setState(2448);
			switch ( getInterpreter().adaptivePredict(_input,344,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2413); match(NATIONAL);
				setState(2414); match(CHARACTER);
				setState(2416);
				switch ( getInterpreter().adaptivePredict(_input,337,_ctx) ) {
				case 1:
					{
					setState(2415); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2418); match(NATIONAL);
				setState(2419); match(CHAR);
				setState(2421);
				switch ( getInterpreter().adaptivePredict(_input,338,_ctx) ) {
				case 1:
					{
					setState(2420); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2423); match(NCHAR);
				setState(2425);
				switch ( getInterpreter().adaptivePredict(_input,339,_ctx) ) {
				case 1:
					{
					setState(2424); type_length();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2427); match(NATIONAL);
				setState(2428); match(CHARACTER);
				setState(2429); match(VARYING);
				setState(2431);
				switch ( getInterpreter().adaptivePredict(_input,340,_ctx) ) {
				case 1:
					{
					setState(2430); type_length();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2433); match(NATIONAL);
				setState(2434); match(CHAR);
				setState(2435); match(VARYING);
				setState(2437);
				switch ( getInterpreter().adaptivePredict(_input,341,_ctx) ) {
				case 1:
					{
					setState(2436); type_length();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2439); match(NCHAR);
				setState(2440); match(VARYING);
				setState(2442);
				switch ( getInterpreter().adaptivePredict(_input,342,_ctx) ) {
				case 1:
					{
					setState(2441); type_length();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2444); match(NVARCHAR);
				setState(2446);
				switch ( getInterpreter().adaptivePredict(_input,343,_ctx) ) {
				case 1:
					{
					setState(2445); type_length();
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
		enterRule(_localctx, 150, RULE_binary_large_object_string_type);
		try {
			setState(2458);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(2450); match(BLOB);
				setState(2452);
				switch ( getInterpreter().adaptivePredict(_input,345,_ctx) ) {
				case 1:
					{
					setState(2451); type_length();
					}
					break;
				}
				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(2454); match(BYTEA);
				setState(2456);
				switch ( getInterpreter().adaptivePredict(_input,346,_ctx) ) {
				case 1:
					{
					setState(2455); type_length();
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
		enterRule(_localctx, 152, RULE_numeric_type);
		try {
			setState(2462);
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
				setState(2460); exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2461); approximate_numeric_type();
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
		enterRule(_localctx, 154, RULE_exact_numeric_type);
		try {
			setState(2485);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2464); match(NUMERIC);
				setState(2466);
				switch ( getInterpreter().adaptivePredict(_input,349,_ctx) ) {
				case 1:
					{
					setState(2465); precision_param();
					}
					break;
				}
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2468); match(DECIMAL);
				setState(2470);
				switch ( getInterpreter().adaptivePredict(_input,350,_ctx) ) {
				case 1:
					{
					setState(2469); precision_param();
					}
					break;
				}
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(2472); match(DEC);
				setState(2474);
				switch ( getInterpreter().adaptivePredict(_input,351,_ctx) ) {
				case 1:
					{
					setState(2473); precision_param();
					}
					break;
				}
				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 4);
				{
				setState(2476); match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2477); match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 6);
				{
				setState(2478); match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2479); match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 8);
				{
				setState(2480); match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 9);
				{
				setState(2481); match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 10);
				{
				setState(2482); match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 11);
				{
				setState(2483); match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 12);
				{
				setState(2484); match(BIGINT);
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
		enterRule(_localctx, 156, RULE_approximate_numeric_type);
		try {
			setState(2497);
			switch ( getInterpreter().adaptivePredict(_input,354,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2487); match(FLOAT);
				setState(2489);
				switch ( getInterpreter().adaptivePredict(_input,353,_ctx) ) {
				case 1:
					{
					setState(2488); precision_param();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2491); match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2492); match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2493); match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2494); match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2495); match(DOUBLE);
				setState(2496); match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 158, RULE_precision_param);
		try {
			setState(2507);
			switch ( getInterpreter().adaptivePredict(_input,355,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2499); match(LEFT_PAREN);
				setState(2500); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2501); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2502); match(LEFT_PAREN);
				setState(2503); ((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2504); match(COMMA);
				setState(2505); ((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(2506); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 160, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2509);
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
		enterRule(_localctx, 162, RULE_datetime_type);
		try {
			setState(2524);
			switch ( getInterpreter().adaptivePredict(_input,356,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2511); match(DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2512); match(TIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2513); match(TIME);
				setState(2514); match(WITH);
				setState(2515); match(TIME);
				setState(2516); match(ZONE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2517); match(TIMETZ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2518); match(TIMESTAMP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2519); match(TIMESTAMP);
				setState(2520); match(WITH);
				setState(2521); match(TIME);
				setState(2522); match(ZONE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2523); match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 164, RULE_bit_type);
		try {
			setState(2539);
			switch ( getInterpreter().adaptivePredict(_input,360,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2526); match(BIT);
				setState(2528);
				switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
				case 1:
					{
					setState(2527); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2530); match(VARBIT);
				setState(2532);
				switch ( getInterpreter().adaptivePredict(_input,358,_ctx) ) {
				case 1:
					{
					setState(2531); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2534); match(BIT);
				setState(2535); match(VARYING);
				setState(2537);
				switch ( getInterpreter().adaptivePredict(_input,359,_ctx) ) {
				case 1:
					{
					setState(2536); type_length();
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
		enterRule(_localctx, 166, RULE_binary_type);
		try {
			setState(2554);
			switch ( getInterpreter().adaptivePredict(_input,364,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2541); match(BINARY);
				setState(2543);
				switch ( getInterpreter().adaptivePredict(_input,361,_ctx) ) {
				case 1:
					{
					setState(2542); type_length();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2545); match(BINARY);
				setState(2546); match(VARYING);
				setState(2548);
				switch ( getInterpreter().adaptivePredict(_input,362,_ctx) ) {
				case 1:
					{
					setState(2547); type_length();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2550); match(VARBINARY);
				setState(2552);
				switch ( getInterpreter().adaptivePredict(_input,363,_ctx) ) {
				case 1:
					{
					setState(2551); type_length();
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
		enterRule(_localctx, 168, RULE_value_expression_primary);
		try {
			setState(2558);
			switch ( getInterpreter().adaptivePredict(_input,365,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2556); parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2557); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 170, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2560); match(LEFT_PAREN);
			setState(2561); value_expression();
			setState(2562); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 172, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(2571);
			switch ( getInterpreter().adaptivePredict(_input,366,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2564); unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2565); column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2566); set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2567); scalar_subquery();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2568); case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2569); cast_specification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2570); routine_invocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 174, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2573); unsigned_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 176, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2575);
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
		enterRule(_localctx, 178, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2578);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2577); sign();
				}
			}

			setState(2580); unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 180, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2582); aggregate_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 182, RULE_aggregate_function);
		try {
			setState(2592);
			switch ( getInterpreter().adaptivePredict(_input,369,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2584); match(COUNT);
				setState(2585); match(LEFT_PAREN);
				setState(2586); match(MULTIPLY);
				setState(2587); match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2588); general_set_function();
				setState(2590);
				switch ( getInterpreter().adaptivePredict(_input,368,_ctx) ) {
				case 1:
					{
					setState(2589); filter_clause();
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
		enterRule(_localctx, 184, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2594); set_function_type();
			setState(2595); match(LEFT_PAREN);
			setState(2597);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(2596); set_qualifier();
				}
			}

			setState(2599); value_expression();
			setState(2600); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 186, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2602);
			_la = _input.LA(1);
			if ( !(_la==ANY || ((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (SOME - 106)) | (1L << (AVG - 106)) | (1L << (COLLECT - 106)) | (1L << (COUNT - 106)) | (1L << (EVERY - 106)) | (1L << (FUSION - 106)))) != 0) || ((((_la - 178)) & ~0x3f) == 0 && ((1L << (_la - 178)) & ((1L << (INTERSECTION - 178)) | (1L << (MAX - 178)) | (1L << (MIN - 178)) | (1L << (STDDEV_POP - 178)) | (1L << (STDDEV_SAMP - 178)) | (1L << (SUM - 178)))) != 0) || _la==VAR_SAMP || _la==VAR_POP) ) {
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
		enterRule(_localctx, 188, RULE_filter_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2604); match(FILTER);
			setState(2605); match(LEFT_PAREN);
			setState(2606); match(WHERE);
			setState(2607); search_condition();
			setState(2608); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 190, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2610); match(GROUPING);
			setState(2611); match(LEFT_PAREN);
			setState(2612); column_reference_list();
			setState(2613); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 192, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2615); case_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 194, RULE_case_abbreviation);
		int _la;
		try {
			setState(2635);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(2617); match(NULLIF);
				setState(2618); match(LEFT_PAREN);
				setState(2619); numeric_value_expression();
				setState(2620); match(COMMA);
				setState(2621); boolean_value_expression();
				setState(2622); match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2624); match(COALESCE);
				setState(2625); match(LEFT_PAREN);
				setState(2626); numeric_value_expression();
				setState(2629); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2627); match(COMMA);
					setState(2628); boolean_value_expression();
					}
					}
					setState(2631); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(2633); match(RIGHT_PAREN);
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
		enterRule(_localctx, 196, RULE_case_specification);
		try {
			setState(2639);
			switch ( getInterpreter().adaptivePredict(_input,373,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2637); simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2638); searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 198, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2641); match(CASE);
			setState(2642); boolean_value_expression();
			setState(2644); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2643); simple_when_clause();
				}
				}
				setState(2646); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2649);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2648); else_clause();
				}
			}

			setState(2651); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 200, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2653); match(CASE);
			setState(2655); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2654); searched_when_clause();
				}
				}
				setState(2657); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2660);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2659); else_clause();
				}
			}

			setState(2662); match(END);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 202, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2664); match(WHEN);
			setState(2665); search_condition();
			setState(2666); match(THEN);
			setState(2667); result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 204, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2669); match(WHEN);
			setState(2670); ((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(2671); match(THEN);
			setState(2672); ((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 206, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2674); match(ELSE);
			setState(2675); ((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 208, RULE_result);
		try {
			setState(2679);
			switch ( getInterpreter().adaptivePredict(_input,378,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2677); value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2678); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 210, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2681); match(CAST);
			setState(2682); match(LEFT_PAREN);
			setState(2683); cast_operand();
			setState(2684); match(AS);
			setState(2685); cast_target();
			setState(2686); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 212, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2688); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 214, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2690); data_type();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 216, RULE_value_expression);
		try {
			setState(2695);
			switch ( getInterpreter().adaptivePredict(_input,379,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2692); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2693); row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2694); boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 218, RULE_common_value_expression);
		try {
			setState(2700);
			switch ( getInterpreter().adaptivePredict(_input,380,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2697); numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2698); string_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2699); match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 220, RULE_numeric_value_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2702); ((Numeric_value_expressionContext)_localctx).left = term();
			setState(2707);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,381,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2703);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(2704); ((Numeric_value_expressionContext)_localctx).right = term();
					}
					} 
				}
				setState(2709);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,381,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 222, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2710); ((TermContext)_localctx).left = factor();
			setState(2715);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 314)) & ~0x3f) == 0 && ((1L << (_la - 314)) & ((1L << (MULTIPLY - 314)) | (1L << (DIVIDE - 314)) | (1L << (MODULAR - 314)))) != 0)) {
				{
				{
				setState(2711);
				_la = _input.LA(1);
				if ( !(((((_la - 314)) & ~0x3f) == 0 && ((1L << (_la - 314)) & ((1L << (MULTIPLY - 314)) | (1L << (DIVIDE - 314)) | (1L << (MODULAR - 314)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(2712); ((TermContext)_localctx).right = factor();
				}
				}
				setState(2717);
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
		enterRule(_localctx, 224, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2719);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2718); sign();
				}
			}

			setState(2721); numeric_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 226, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2723); match(LEFT_PAREN);
			setState(2724); numeric_value_expression();
			setState(2729);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2725); match(COMMA);
				setState(2726); numeric_value_expression();
				}
				}
				setState(2731);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2732); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 228, RULE_numeric_primary);
		int _la;
		try {
			setState(2743);
			switch ( getInterpreter().adaptivePredict(_input,386,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2734); value_expression_primary();
				setState(2739);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(2735); match(CAST_EXPRESSION);
					setState(2736); cast_target();
					}
					}
					setState(2741);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2742); numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 230, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2745);
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
		enterRule(_localctx, 232, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2747); extract_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 234, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2749); match(EXTRACT);
			setState(2750); match(LEFT_PAREN);
			setState(2751); ((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(2752); match(FROM);
			setState(2753); extract_source();
			setState(2754); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 236, RULE_extract_field);
		try {
			setState(2759);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2756); primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2757); time_zone_field();
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
				setState(2758); extended_datetime_field();
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
		enterRule(_localctx, 238, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2761);
			_la = _input.LA(1);
			if ( !(((((_la - 237)) & ~0x3f) == 0 && ((1L << (_la - 237)) & ((1L << (TIMEZONE - 237)) | (1L << (TIMEZONE_HOUR - 237)) | (1L << (TIMEZONE_MINUTE - 237)))) != 0)) ) {
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
		enterRule(_localctx, 240, RULE_extract_source);
		try {
			setState(2765);
			switch ( getInterpreter().adaptivePredict(_input,388,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2763); column_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2764); datetime_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 242, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2767); character_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 244, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2769); character_factor();
			setState(2774);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(2770); match(CONCATENATION_OPERATOR);
				setState(2771); character_factor();
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
		enterRule(_localctx, 246, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2777); character_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 248, RULE_character_primary);
		try {
			setState(2781);
			switch ( getInterpreter().adaptivePredict(_input,390,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2779); value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2780); string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 250, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2783); trim_function();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 252, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2785); match(TRIM);
			setState(2786); match(LEFT_PAREN);
			setState(2787); trim_operands();
			setState(2788); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 254, RULE_trim_operands);
		int _la;
		try {
			setState(2804);
			switch ( getInterpreter().adaptivePredict(_input,394,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2797);
				switch ( getInterpreter().adaptivePredict(_input,393,_ctx) ) {
				case 1:
					{
					setState(2791);
					_la = _input.LA(1);
					if (_la==BOTH || _la==LEADING || _la==TRAILING) {
						{
						setState(2790); trim_specification();
						}
					}

					setState(2794);
					_la = _input.LA(1);
					if (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (ANY - 6)) | (1L << (CASE - 6)) | (1L << (CAST - 6)) | (1L << (FALSE - 6)) | (1L << (LEFT - 6)))) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (RIGHT - 98)) | (1L << (SOME - 98)) | (1L << (TRUE - 98)) | (1L << (ADMIN - 98)) | (1L << (AVG - 98)) | (1L << (BETWEEN - 98)) | (1L << (BY - 98)) | (1L << (CACHE - 98)) | (1L << (CALLED - 98)) | (1L << (CLASS - 98)) | (1L << (CENTURY - 98)) | (1L << (CHARACTER - 98)) | (1L << (CHECK - 98)) | (1L << (COLLECT - 98)) | (1L << (COALESCE - 98)) | (1L << (COLUMN - 98)) | (1L << (COMMENT - 98)) | (1L << (COMMENTS - 98)) | (1L << (COMMIT - 98)) | (1L << (CONFIGURATION - 98)) | (1L << (COST - 98)) | (1L << (COUNT - 98)) | (1L << (CUBE - 98)) | (1L << (CURRENT - 98)) | (1L << (CYCLE - 98)) | (1L << (DATA - 98)) | (1L << (DAY - 98)) | (1L << (DEC - 98)) | (1L << (DECADE - 98)) | (1L << (DEFINER - 98)) | (1L << (DICTIONARY - 98)) | (1L << (DOW - 98)) | (1L << (DOY - 98)) | (1L << (DROP - 98)) | (1L << (EPOCH - 98)) | (1L << (EVERY - 98)))) != 0) || ((((_la - 162)) & ~0x3f) == 0 && ((1L << (_la - 162)) & ((1L << (EXISTS - 162)) | (1L << (EXTERNAL - 162)) | (1L << (EXTRACT - 162)) | (1L << (FAMILY - 162)) | (1L << (FILTER - 162)) | (1L << (FIRST - 162)) | (1L << (FORMAT - 162)) | (1L << (FUSION - 162)) | (1L << (GROUPING - 162)) | (1L << (HASH - 162)) | (1L << (INDEX - 162)) | (1L << (INCREMENT - 162)) | (1L << (INPUT - 162)) | (1L << (INSERT - 162)) | (1L << (INTERSECTION - 162)) | (1L << (ISCACHABLE - 162)) | (1L << (ISODOW - 162)) | (1L << (ISOYEAR - 162)) | (1L << (ISSTRICT - 162)) | (1L << (LANGUAGE - 162)) | (1L << (LARGE - 162)) | (1L << (LAST - 162)) | (1L << (LESS - 162)) | (1L << (LIST - 162)) | (1L << (LOCATION - 162)) | (1L << (MATCH - 162)) | (1L << (MAX - 162)) | (1L << (MAXVALUE - 162)) | (1L << (MICROSECONDS - 162)) | (1L << (MILLENNIUM - 162)) | (1L << (MILLISECONDS - 162)) | (1L << (MIN - 162)) | (1L << (MINVALUE - 162)) | (1L << (MINUTE - 162)) | (1L << (MONTH - 162)) | (1L << (NATIONAL - 162)) | (1L << (NO - 162)) | (1L << (NONE - 162)) | (1L << (NULLIF - 162)) | (1L << (OBJECT - 162)) | (1L << (OPTION - 162)) | (1L << (OPTIONS - 162)) | (1L << (OVERWRITE - 162)) | (1L << (PARSER - 162)) | (1L << (PARTIAL - 162)) | (1L << (PARTITION - 162)) | (1L << (PARTITIONS - 162)) | (1L << (PRECISION - 162)) | (1L << (PUBLIC - 162)) | (1L << (PURGE - 162)) | (1L << (QUARTER - 162)) | (1L << (RANGE - 162)) | (1L << (REGEXP - 162)) | (1L << (RLIKE - 162)) | (1L << (ROLLUP - 162)) | (1L << (SEARCH - 162)) | (1L << (SECOND - 162)) | (1L << (SECURITY - 162)) | (1L << (SERVER - 162)) | (1L << (SET - 162)) | (1L << (SIMILAR - 162)) | (1L << (SIMPLE - 162)))) != 0) || ((((_la - 226)) & ~0x3f) == 0 && ((1L << (_la - 226)) & ((1L << (STABLE - 226)) | (1L << (START - 226)) | (1L << (STORAGE - 226)) | (1L << (STDDEV_POP - 226)) | (1L << (STDDEV_SAMP - 226)) | (1L << (SUBPARTITION - 226)) | (1L << (SUM - 226)) | (1L << (TABLESPACE - 226)) | (1L << (TEMPLATE - 226)) | (1L << (THAN - 226)) | (1L << (TIMEZONE - 226)) | (1L << (TIMEZONE_HOUR - 226)) | (1L << (TIMEZONE_MINUTE - 226)) | (1L << (TRIM - 226)) | (1L << (TO - 226)) | (1L << (TYPE - 226)) | (1L << (UNKNOWN - 226)) | (1L << (UNLOGGED - 226)) | (1L << (VALUES - 226)) | (1L << (VAR_SAMP - 226)) | (1L << (VAR_POP - 226)) | (1L << (VARYING - 226)) | (1L << (VOLATILE - 226)) | (1L << (WEEK - 226)) | (1L << (WINDOW - 226)) | (1L << (WRAPPER - 226)) | (1L << (YEAR - 226)) | (1L << (ZONE - 226)) | (1L << (BOOLEAN - 226)) | (1L << (BOOL - 226)) | (1L << (BIT - 226)) | (1L << (VARBIT - 226)) | (1L << (INT1 - 226)) | (1L << (INT2 - 226)) | (1L << (INT4 - 226)) | (1L << (INT8 - 226)) | (1L << (TINYINT - 226)) | (1L << (SMALLINT - 226)) | (1L << (INT - 226)) | (1L << (INTEGER - 226)) | (1L << (BIGINT - 226)) | (1L << (FLOAT4 - 226)) | (1L << (FLOAT8 - 226)) | (1L << (REAL - 226)) | (1L << (FLOAT - 226)) | (1L << (DOUBLE - 226)) | (1L << (NUMERIC - 226)) | (1L << (DECIMAL - 226)) | (1L << (CHAR - 226)) | (1L << (VARCHAR - 226)) | (1L << (NCHAR - 226)) | (1L << (NVARCHAR - 226)) | (1L << (DATE - 226)) | (1L << (TIME - 226)) | (1L << (TIMETZ - 226)) | (1L << (TIMESTAMP - 226)) | (1L << (TIMESTAMPTZ - 226)) | (1L << (TEXT - 226)) | (1L << (UUID - 226)) | (1L << (VARBINARY - 226)))) != 0) || ((((_la - 290)) & ~0x3f) == 0 && ((1L << (_la - 290)) & ((1L << (BLOB - 290)) | (1L << (BYTEA - 290)) | (1L << (INET4 - 290)) | (1L << (VOID - 290)) | (1L << (LEFT_PAREN - 290)) | (1L << (DOUBLE_QUOTE - 290)) | (1L << (NUMBER - 290)) | (1L << (REAL_NUMBER - 290)) | (1L << (Identifier - 290)) | (1L << (Character_String_Literal - 290)))) != 0)) {
						{
						setState(2793); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(2796); match(FROM);
					}
					break;
				}
				setState(2799); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2800); ((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(2801); match(COMMA);
				setState(2802); ((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 256, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2806);
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
		enterRule(_localctx, 258, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2808); or_predicate();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 260, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2810); and_predicate();
			setState(2815);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,395,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2811); match(OR);
					setState(2812); or_predicate();
					}
					} 
				}
				setState(2817);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,395,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 262, RULE_and_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2818); boolean_factor();
			setState(2823);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,396,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2819); match(AND);
					setState(2820); and_predicate();
					}
					} 
				}
				setState(2825);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,396,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 264, RULE_boolean_factor);
		try {
			setState(2829);
			switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2826); boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2827); match(NOT);
				setState(2828); boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 266, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2831); boolean_primary();
			setState(2833);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(2832); is_clause();
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
		enterRule(_localctx, 268, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2835); match(IS);
			setState(2837);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2836); match(NOT);
				}
			}

			setState(2839); ((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 270, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2841);
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
		enterRule(_localctx, 272, RULE_boolean_primary);
		try {
			setState(2845);
			switch ( getInterpreter().adaptivePredict(_input,400,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2843); predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2844); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 274, RULE_boolean_predicand);
		try {
			setState(2849);
			switch ( getInterpreter().adaptivePredict(_input,401,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2847); parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2848); nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 276, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2851); match(LEFT_PAREN);
			setState(2852); boolean_value_expression();
			setState(2853); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 278, RULE_row_value_expression);
		try {
			setState(2857);
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
				setState(2855); row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2856); explicit_row_value_constructor();
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
		enterRule(_localctx, 280, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2859); nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 282, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2861); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 284, RULE_row_value_predicand);
		try {
			setState(2865);
			switch ( getInterpreter().adaptivePredict(_input,403,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2863); row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2864); row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 286, RULE_row_value_constructor_predicand);
		try {
			setState(2869);
			switch ( getInterpreter().adaptivePredict(_input,404,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2867); common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2868); boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 288, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2871); from_clause();
			setState(2873);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(2872); where_clause();
				}
			}

			setState(2876);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(2875); groupby_clause();
				}
			}

			setState(2879);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(2878); having_clause();
				}
			}

			setState(2882);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(2881); orderby_clause();
				}
			}

			setState(2885);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(2884); limit_clause();
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
		enterRule(_localctx, 290, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2887); match(FROM);
			setState(2888); table_reference_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 292, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2890); table_reference();
			setState(2895);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2891); match(COMMA);
				setState(2892); table_reference();
				}
				}
				setState(2897);
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
		enterRule(_localctx, 294, RULE_table_reference);
		try {
			setState(2900);
			switch ( getInterpreter().adaptivePredict(_input,411,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2898); joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2899); table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 296, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2902); table_primary();
			setState(2904); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2903); joined_table_primary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2906); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,412,_ctx);
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
		enterRule(_localctx, 298, RULE_joined_table_primary);
		int _la;
		try {
			setState(2927);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(2908); match(CROSS);
				setState(2909); match(JOIN);
				setState(2910); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2912);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
					{
					setState(2911); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2914); match(JOIN);
				setState(2915); ((Joined_table_primaryContext)_localctx).right = table_primary();
				setState(2916); ((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2918); match(NATURAL);
				setState(2920);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
					{
					setState(2919); ((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2922); match(JOIN);
				setState(2923); ((Joined_table_primaryContext)_localctx).right = table_primary();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(2924); match(UNION);
				setState(2925); match(JOIN);
				setState(2926); ((Joined_table_primaryContext)_localctx).right = table_primary();
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
		enterRule(_localctx, 300, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2929); match(CROSS);
			setState(2930); match(JOIN);
			setState(2931); ((Cross_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 302, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2934);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
				{
				setState(2933); ((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(2936); match(JOIN);
			setState(2937); ((Qualified_joinContext)_localctx).r = table_primary();
			setState(2938); ((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 304, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2940); match(NATURAL);
			setState(2942);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (INNER - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) {
				{
				setState(2941); ((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(2944); match(JOIN);
			setState(2945); ((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 306, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2947); match(UNION);
			setState(2948); match(JOIN);
			setState(2949); ((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 308, RULE_join_type);
		try {
			setState(2953);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2951); match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2952); ((Join_typeContext)_localctx).t = outer_join_type();
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
		enterRule(_localctx, 310, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2955); outer_join_type_part2();
			setState(2957);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(2956); match(OUTER);
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
		enterRule(_localctx, 312, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2959);
			_la = _input.LA(1);
			if ( !(((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (FULL - 43)) | (1L << (LEFT - 43)) | (1L << (RIGHT - 43)))) != 0)) ) {
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
		enterRule(_localctx, 314, RULE_join_specification);
		try {
			setState(2963);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(2961); join_condition();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(2962); named_columns_join();
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
		enterRule(_localctx, 316, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2965); match(ON);
			setState(2966); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 318, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2968); match(USING);
			setState(2969); match(LEFT_PAREN);
			setState(2970); ((Named_columns_joinContext)_localctx).f = column_reference_list();
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
		enterRule(_localctx, 320, RULE_table_primary);
		int _la;
		try {
			setState(2997);
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
				setState(2973); table_or_query_name();
				setState(2978);
				switch ( getInterpreter().adaptivePredict(_input,422,_ctx) ) {
				case 1:
					{
					setState(2975);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(2974); match(AS);
						}
					}

					setState(2977); ((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(2984);
				switch ( getInterpreter().adaptivePredict(_input,423,_ctx) ) {
				case 1:
					{
					setState(2980); match(LEFT_PAREN);
					setState(2981); column_name_list();
					setState(2982); match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(2986); derived_table();
				setState(2988);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(2987); match(AS);
					}
				}

				setState(2990); ((Table_primaryContext)_localctx).name = identifier();
				setState(2995);
				switch ( getInterpreter().adaptivePredict(_input,425,_ctx) ) {
				case 1:
					{
					setState(2991); match(LEFT_PAREN);
					setState(2992); column_name_list();
					setState(2993); match(RIGHT_PAREN);
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
		enterRule(_localctx, 322, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2999); identifier();
			setState(3004);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3000); match(COMMA);
				setState(3001); identifier();
				}
				}
				setState(3006);
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
		enterRule(_localctx, 324, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3007); table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 326, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3009); match(WHERE);
			setState(3010); search_condition();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 328, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3012); value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 330, RULE_groupby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3014); match(GROUP);
			setState(3015); match(BY);
			setState(3016); ((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 332, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3018); grouping_element();
			setState(3023);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3019); match(COMMA);
				setState(3020); grouping_element();
				}
				}
				setState(3025);
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
		enterRule(_localctx, 334, RULE_grouping_element);
		try {
			setState(3030);
			switch ( getInterpreter().adaptivePredict(_input,429,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3026); rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3027); cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3028); empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3029); ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 336, RULE_ordinary_grouping_set);
		try {
			setState(3037);
			switch ( getInterpreter().adaptivePredict(_input,430,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3032); row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3033); match(LEFT_PAREN);
				setState(3034); row_value_predicand_list();
				setState(3035); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 338, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3039); ordinary_grouping_set();
			setState(3044);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3040); match(COMMA);
				setState(3041); ordinary_grouping_set();
				}
				}
				setState(3046);
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
		enterRule(_localctx, 340, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3047); match(ROLLUP);
			setState(3048); match(LEFT_PAREN);
			setState(3049); ((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3050); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 342, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3052); match(CUBE);
			setState(3053); match(LEFT_PAREN);
			setState(3054); ((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3055); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 344, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3057); match(LEFT_PAREN);
			setState(3058); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 346, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3060); match(HAVING);
			setState(3061); boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 348, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3063); row_value_predicand();
			setState(3068);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3064); match(COMMA);
				setState(3065); row_value_predicand();
				}
				}
				setState(3070);
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
		enterRule(_localctx, 350, RULE_query_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3071); query_expression_body();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 352, RULE_query_expression_body);
		try {
			setState(3075);
			switch ( getInterpreter().adaptivePredict(_input,433,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3073); non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3074); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 354, RULE_non_join_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3085);
			switch ( getInterpreter().adaptivePredict(_input,435,_ctx) ) {
			case 1:
				{
				setState(3077); non_join_query_term();
				}
				break;
			case 2:
				{
				setState(3078); joined_table();
				setState(3079);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3081);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3080);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3083); query_term();
				}
				break;
			}
			setState(3094);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==UNION) {
				{
				{
				setState(3087);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(3089);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3088);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3091); query_term();
				}
				}
				setState(3096);
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
		enterRule(_localctx, 356, RULE_query_term);
		try {
			setState(3099);
			switch ( getInterpreter().adaptivePredict(_input,438,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3097); non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3098); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 358, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3109);
			switch ( getInterpreter().adaptivePredict(_input,440,_ctx) ) {
			case 1:
				{
				setState(3101); non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(3102); joined_table();
				setState(3103); match(INTERSECT);
				setState(3105);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3104);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3107); query_primary();
				}
				break;
			}
			setState(3118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(3111); match(INTERSECT);
				setState(3113);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3112);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(3115); query_primary();
				}
				}
				setState(3120);
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
		enterRule(_localctx, 360, RULE_query_primary);
		try {
			setState(3123);
			switch ( getInterpreter().adaptivePredict(_input,443,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3121); non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3122); joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 362, RULE_non_join_query_primary);
		try {
			setState(3130);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3125); simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3126); match(LEFT_PAREN);
				setState(3127); non_join_query_expression();
				setState(3128); match(RIGHT_PAREN);
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
		enterRule(_localctx, 364, RULE_simple_table);
		try {
			setState(3134);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(3132); query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3133); explicit_table();
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
		enterRule(_localctx, 366, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3136); match(TABLE);
			setState(3137); table_or_query_name();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 368, RULE_table_or_query_name);
		try {
			setState(3141);
			switch ( getInterpreter().adaptivePredict(_input,446,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3139); schema_qualified_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3140); identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 370, RULE_schema_qualified_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3143); identifier();
			setState(3150);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(3144); match(DOT);
				setState(3145); identifier();
				setState(3148);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(3146); match(DOT);
					setState(3147); identifier();
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
		enterRule(_localctx, 372, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3152); match(SELECT);
			setState(3154);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(3153); set_qualifier();
				}
			}

			setState(3156); select_list();
			setState(3158);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(3157); table_expression();
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
		enterRule(_localctx, 374, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3160); select_sublist();
			setState(3165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3161); match(COMMA);
				setState(3162); select_sublist();
				}
				}
				setState(3167);
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
		enterRule(_localctx, 376, RULE_select_sublist);
		try {
			setState(3170);
			switch ( getInterpreter().adaptivePredict(_input,452,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3168); derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3169); qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 378, RULE_derived_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3172); value_expression();
			setState(3174);
			switch ( getInterpreter().adaptivePredict(_input,453,_ctx) ) {
			case 1:
				{
				setState(3173); as_clause();
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
		enterRule(_localctx, 380, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3178);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(3176); ((Qualified_asteriskContext)_localctx).tb_name = match(Identifier);
				setState(3177); match(DOT);
				}
			}

			setState(3180); match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 382, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3182);
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
		enterRule(_localctx, 384, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3187);
			switch ( getInterpreter().adaptivePredict(_input,455,_ctx) ) {
			case 1:
				{
				setState(3184); ((Column_referenceContext)_localctx).tb_name = identifier();
				setState(3185); match(DOT);
				}
				break;
			}
			setState(3189); ((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 386, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3192);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(3191); match(AS);
				}
			}

			setState(3194); identifier();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 388, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3196); column_reference();
			setState(3201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3197); match(COMMA);
				setState(3198); column_reference();
				}
				}
				setState(3203);
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
		enterRule(_localctx, 390, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3204); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 392, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3206); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 394, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3208); subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 396, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3210); match(LEFT_PAREN);
			setState(3211); query_expression();
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
		enterRule(_localctx, 398, RULE_predicate);
		try {
			setState(3220);
			switch ( getInterpreter().adaptivePredict(_input,458,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3214); comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3215); between_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3216); in_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3217); pattern_matching_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3218); null_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3219); exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 400, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3222); ((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(3223); ((Comparison_predicateContext)_localctx).c = comp_op();
			setState(3224); ((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 402, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3226);
			_la = _input.LA(1);
			if ( !(((((_la - 300)) & ~0x3f) == 0 && ((1L << (_la - 300)) & ((1L << (EQUAL - 300)) | (1L << (NOT_EQUAL - 300)) | (1L << (LTH - 300)) | (1L << (LEQ - 300)) | (1L << (GTH - 300)) | (1L << (GEQ - 300)))) != 0)) ) {
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
		enterRule(_localctx, 404, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3228); ((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3229); between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 406, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3232);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3231); match(NOT);
				}
			}

			setState(3234); match(BETWEEN);
			setState(3236);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(3235);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(3238); ((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(3239); match(AND);
			setState(3240); ((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 408, RULE_in_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3242); ((In_predicateContext)_localctx).predicand = numeric_value_expression();
			setState(3244);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3243); match(NOT);
				}
			}

			setState(3246); match(IN);
			setState(3247); in_predicate_value();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 410, RULE_in_predicate_value);
		try {
			setState(3254);
			switch ( getInterpreter().adaptivePredict(_input,462,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3249); table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3250); match(LEFT_PAREN);
				setState(3251); in_value_list();
				setState(3252); match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 412, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3256); row_value_expression();
			setState(3261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3257); match(COMMA);
				setState(3258); row_value_expression();
				}
				}
				setState(3263);
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
		enterRule(_localctx, 414, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3264); ((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(3265); pattern_matcher();
			setState(3266); ((Pattern_matching_predicateContext)_localctx).s = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 416, RULE_pattern_matcher);
		int _la;
		try {
			setState(3273);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3269);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3268); match(NOT);
					}
				}

				setState(3271); negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(3272); regex_matcher();
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
		enterRule(_localctx, 418, RULE_negativable_matcher);
		try {
			setState(3281);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3275); match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3276); match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(3277); match(SIMILAR);
				setState(3278); match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(3279); match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(3280); match(RLIKE);
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
		enterRule(_localctx, 420, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3283);
			_la = _input.LA(1);
			if ( !(((((_la - 294)) & ~0x3f) == 0 && ((1L << (_la - 294)) & ((1L << (Similar_To - 294)) | (1L << (Not_Similar_To - 294)) | (1L << (Similar_To_Case_Insensitive - 294)) | (1L << (Not_Similar_To_Case_Insensitive - 294)))) != 0)) ) {
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
		enterRule(_localctx, 422, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3285); ((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3286); match(IS);
			setState(3288);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3287); ((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(3290); match(NULL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 424, RULE_quantified_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3292); ((Quantified_comparison_predicateContext)_localctx).l = numeric_value_expression();
			setState(3293); ((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(3294); ((Quantified_comparison_predicateContext)_localctx).q = quantifier();
			setState(3295); ((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 426, RULE_quantifier);
		try {
			setState(3299);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3297); all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3298); some();
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
		enterRule(_localctx, 428, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3301); match(ALL);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 430, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3303);
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
		enterRule(_localctx, 432, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3306);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3305); match(NOT);
				}
			}

			setState(3308); match(EXISTS);
			setState(3309); ((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 434, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3311); match(UNIQUE);
			setState(3312); ((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 436, RULE_primary_datetime_field);
		try {
			setState(3316);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3314); non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(3315); match(SECOND);
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
		enterRule(_localctx, 438, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3318);
			_la = _input.LA(1);
			if ( !(((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (DAY - 152)) | (1L << (HOUR - 152)) | (1L << (MINUTE - 152)) | (1L << (MONTH - 152)))) != 0) || _la==YEAR) ) {
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
		enterRule(_localctx, 440, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3320);
			_la = _input.LA(1);
			if ( !(((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (CENTURY - 136)) | (1L << (DECADE - 136)) | (1L << (DOW - 136)) | (1L << (DOY - 136)) | (1L << (EPOCH - 136)) | (1L << (ISODOW - 136)) | (1L << (ISOYEAR - 136)) | (1L << (MICROSECONDS - 136)) | (1L << (MILLENNIUM - 136)) | (1L << (MILLISECONDS - 136)))) != 0) || _la==QUARTER || _la==WEEK) ) {
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
		enterRule(_localctx, 442, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3322); function_name();
			setState(3323); match(LEFT_PAREN);
			setState(3325);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << CASE) | (1L << CAST) | (1L << FALSE))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LEFT - 69)) | (1L << (NOT - 69)) | (1L << (NULL - 69)) | (1L << (RIGHT - 69)) | (1L << (SOME - 69)) | (1L << (TRUE - 69)) | (1L << (ADMIN - 69)) | (1L << (AVG - 69)) | (1L << (BETWEEN - 69)) | (1L << (BY - 69)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (CACHE - 133)) | (1L << (CALLED - 133)) | (1L << (CLASS - 133)) | (1L << (CENTURY - 133)) | (1L << (CHARACTER - 133)) | (1L << (CHECK - 133)) | (1L << (COLLECT - 133)) | (1L << (COALESCE - 133)) | (1L << (COLUMN - 133)) | (1L << (COMMENT - 133)) | (1L << (COMMENTS - 133)) | (1L << (COMMIT - 133)) | (1L << (CONFIGURATION - 133)) | (1L << (COST - 133)) | (1L << (COUNT - 133)) | (1L << (CUBE - 133)) | (1L << (CURRENT - 133)) | (1L << (CYCLE - 133)) | (1L << (DATA - 133)) | (1L << (DAY - 133)) | (1L << (DEC - 133)) | (1L << (DECADE - 133)) | (1L << (DEFINER - 133)) | (1L << (DICTIONARY - 133)) | (1L << (DOW - 133)) | (1L << (DOY - 133)) | (1L << (DROP - 133)) | (1L << (EPOCH - 133)) | (1L << (EVERY - 133)) | (1L << (EXISTS - 133)) | (1L << (EXTERNAL - 133)) | (1L << (EXTRACT - 133)) | (1L << (FAMILY - 133)) | (1L << (FILTER - 133)) | (1L << (FIRST - 133)) | (1L << (FORMAT - 133)) | (1L << (FUSION - 133)) | (1L << (GROUPING - 133)) | (1L << (HASH - 133)) | (1L << (INDEX - 133)) | (1L << (INCREMENT - 133)) | (1L << (INPUT - 133)) | (1L << (INSERT - 133)) | (1L << (INTERSECTION - 133)) | (1L << (ISCACHABLE - 133)) | (1L << (ISODOW - 133)) | (1L << (ISOYEAR - 133)) | (1L << (ISSTRICT - 133)) | (1L << (LANGUAGE - 133)) | (1L << (LARGE - 133)) | (1L << (LAST - 133)) | (1L << (LESS - 133)) | (1L << (LIST - 133)) | (1L << (LOCATION - 133)) | (1L << (MATCH - 133)) | (1L << (MAX - 133)) | (1L << (MAXVALUE - 133)) | (1L << (MICROSECONDS - 133)) | (1L << (MILLENNIUM - 133)) | (1L << (MILLISECONDS - 133)) | (1L << (MIN - 133)) | (1L << (MINVALUE - 133)))) != 0) || ((((_la - 197)) & ~0x3f) == 0 && ((1L << (_la - 197)) & ((1L << (MINUTE - 197)) | (1L << (MONTH - 197)) | (1L << (NATIONAL - 197)) | (1L << (NO - 197)) | (1L << (NONE - 197)) | (1L << (NULLIF - 197)) | (1L << (OBJECT - 197)) | (1L << (OPTION - 197)) | (1L << (OPTIONS - 197)) | (1L << (OVERWRITE - 197)) | (1L << (PARSER - 197)) | (1L << (PARTIAL - 197)) | (1L << (PARTITION - 197)) | (1L << (PARTITIONS - 197)) | (1L << (PRECISION - 197)) | (1L << (PUBLIC - 197)) | (1L << (PURGE - 197)) | (1L << (QUARTER - 197)) | (1L << (RANGE - 197)) | (1L << (REGEXP - 197)) | (1L << (RLIKE - 197)) | (1L << (ROLLUP - 197)) | (1L << (SEARCH - 197)) | (1L << (SECOND - 197)) | (1L << (SECURITY - 197)) | (1L << (SERVER - 197)) | (1L << (SET - 197)) | (1L << (SIMILAR - 197)) | (1L << (SIMPLE - 197)) | (1L << (STABLE - 197)) | (1L << (START - 197)) | (1L << (STORAGE - 197)) | (1L << (STDDEV_POP - 197)) | (1L << (STDDEV_SAMP - 197)) | (1L << (SUBPARTITION - 197)) | (1L << (SUM - 197)) | (1L << (TABLESPACE - 197)) | (1L << (TEMPLATE - 197)) | (1L << (THAN - 197)) | (1L << (TIMEZONE - 197)) | (1L << (TIMEZONE_HOUR - 197)) | (1L << (TIMEZONE_MINUTE - 197)) | (1L << (TRIM - 197)) | (1L << (TO - 197)) | (1L << (TYPE - 197)) | (1L << (UNKNOWN - 197)) | (1L << (UNLOGGED - 197)) | (1L << (VALUES - 197)) | (1L << (VAR_SAMP - 197)) | (1L << (VAR_POP - 197)) | (1L << (VARYING - 197)) | (1L << (VOLATILE - 197)) | (1L << (WEEK - 197)) | (1L << (WINDOW - 197)) | (1L << (WRAPPER - 197)) | (1L << (YEAR - 197)) | (1L << (ZONE - 197)) | (1L << (BOOLEAN - 197)) | (1L << (BOOL - 197)) | (1L << (BIT - 197)) | (1L << (VARBIT - 197)) | (1L << (INT1 - 197)))) != 0) || ((((_la - 261)) & ~0x3f) == 0 && ((1L << (_la - 261)) & ((1L << (INT2 - 261)) | (1L << (INT4 - 261)) | (1L << (INT8 - 261)) | (1L << (TINYINT - 261)) | (1L << (SMALLINT - 261)) | (1L << (INT - 261)) | (1L << (INTEGER - 261)) | (1L << (BIGINT - 261)) | (1L << (FLOAT4 - 261)) | (1L << (FLOAT8 - 261)) | (1L << (REAL - 261)) | (1L << (FLOAT - 261)) | (1L << (DOUBLE - 261)) | (1L << (NUMERIC - 261)) | (1L << (DECIMAL - 261)) | (1L << (CHAR - 261)) | (1L << (VARCHAR - 261)) | (1L << (NCHAR - 261)) | (1L << (NVARCHAR - 261)) | (1L << (DATE - 261)) | (1L << (TIME - 261)) | (1L << (TIMETZ - 261)) | (1L << (TIMESTAMP - 261)) | (1L << (TIMESTAMPTZ - 261)) | (1L << (TEXT - 261)) | (1L << (UUID - 261)) | (1L << (VARBINARY - 261)) | (1L << (BLOB - 261)) | (1L << (BYTEA - 261)) | (1L << (INET4 - 261)) | (1L << (VOID - 261)) | (1L << (LEFT_PAREN - 261)) | (1L << (PLUS - 261)) | (1L << (MINUS - 261)) | (1L << (DOUBLE_QUOTE - 261)))) != 0) || ((((_la - 325)) & ~0x3f) == 0 && ((1L << (_la - 325)) & ((1L << (NUMBER - 325)) | (1L << (REAL_NUMBER - 325)) | (1L << (Identifier - 325)) | (1L << (Character_String_Literal - 325)))) != 0)) {
				{
				setState(3324); sql_argument_list();
				}
			}

			setState(3327); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 444, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3329);
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
		enterRule(_localctx, 446, RULE_function_name);
		try {
			setState(3333);
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
				setState(3331); identifier();
				}
				break;
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(3332); function_names_for_reserved_words();
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
		enterRule(_localctx, 448, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3335); value_expression();
			setState(3340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3336); match(COMMA);
				setState(3337); value_expression();
				}
				}
				setState(3342);
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
		enterRule(_localctx, 450, RULE_orderby_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3343); match(ORDER);
			setState(3344); match(BY);
			setState(3345); sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 452, RULE_sort_specifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3347); sort_specifier();
			setState(3352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3348); match(COMMA);
				setState(3349); sort_specifier();
				}
				}
				setState(3354);
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
		enterRule(_localctx, 454, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3355); ((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(3357);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(3356); ((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(3360);
			_la = _input.LA(1);
			if (_la==NULL) {
				{
				setState(3359); ((Sort_specifierContext)_localctx).null_order = null_ordering();
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
		enterRule(_localctx, 456, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3362);
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
		enterRule(_localctx, 458, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3364); match(LIMIT);
			setState(3365); ((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 460, RULE_null_ordering);
		try {
			setState(3371);
			switch ( getInterpreter().adaptivePredict(_input,477,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3367); match(NULL);
				setState(3368); match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3369); match(NULL);
				setState(3370); match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 462, RULE_insert_statement);
		int _la;
		try {
			setState(3402);
			switch ( getInterpreter().adaptivePredict(_input,483,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3373); match(INSERT);
				setState(3375);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3374); match(OVERWRITE);
					}
				}

				setState(3377); match(INTO);
				setState(3378); schema_qualified_name();
				setState(3383);
				switch ( getInterpreter().adaptivePredict(_input,479,_ctx) ) {
				case 1:
					{
					setState(3379); match(LEFT_PAREN);
					setState(3380); column_name_list();
					setState(3381); match(RIGHT_PAREN);
					}
					break;
				}
				setState(3385); query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3387); match(INSERT);
				setState(3389);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3388); match(OVERWRITE);
					}
				}

				setState(3391); match(INTO);
				setState(3392); match(LOCATION);
				setState(3393); ((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(3399);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(3394); match(USING);
					setState(3395); ((Insert_statementContext)_localctx).file_type = identifier();
					setState(3397);
					_la = _input.LA(1);
					if (_la==WITH) {
						{
						setState(3396); param_clause();
						}
					}

					}
				}

				setState(3401); query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0150\u0d4f\4\2\t"+
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
		"\t\u00e8\4\u00e9\t\u00e9\3\2\3\2\5\2\u01d5\n\2\7\2\u01d7\n\2\f\2\16\2"+
		"\u01da\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3\u01eb\n\3\3\4\3\4\3\5\3\5\3\6\3\6\5\6\u01f3\n\6\3\7\3\7\5\7\u01f7"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\5\7\u01fe\n\7\3\7\3\7\3\7\3\7\5\7\u0204\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\5\b\u020b\n\b\3\b\3\b\5\b\u020f\n\b\3\b\3\b\5\b\u0213"+
		"\n\b\3\b\3\b\5\b\u0217\n\b\3\b\3\b\5\b\u021b\n\b\3\t\3\t\5\t\u021f\n\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0229\n\t\3\t\5\t\u022c\n\t\6\t\u022e"+
		"\n\t\r\t\16\t\u022f\3\t\3\t\5\t\u0234\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u023b"+
		"\n\t\3\t\5\t\u023e\n\t\6\t\u0240\n\t\r\t\16\t\u0241\5\t\u0244\n\t\3\n"+
		"\3\n\5\n\u0248\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0250\n\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0259\n\n\6\n\u025b\n\n\r\n\16\n\u025c\5\n\u025f\n"+
		"\n\5\n\u0261\n\n\3\n\3\n\3\n\3\n\5\n\u0267\n\n\3\n\3\n\3\n\5\n\u026c\n"+
		"\n\3\n\3\n\3\n\3\n\5\n\u0272\n\n\3\n\3\n\5\n\u0276\n\n\3\n\3\n\5\n\u027a"+
		"\n\n\3\n\3\n\5\n\u027e\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0286\n\n\5\n\u0288"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u0290\n\13\3\13\6\13\u0293\n\13"+
		"\r\13\16\13\u0294\3\13\3\13\5\13\u0299\n\13\5\13\u029b\n\13\3\13\3\13"+
		"\5\13\u029f\n\13\3\13\6\13\u02a2\n\13\r\13\16\13\u02a3\3\13\3\13\3\13"+
		"\3\13\3\13\6\13\u02ab\n\13\r\13\16\13\u02ac\5\13\u02af\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u02b7\n\13\3\13\3\13\3\13\3\13\5\13\u02bd\n"+
		"\13\6\13\u02bf\n\13\r\13\16\13\u02c0\3\13\3\13\6\13\u02c5\n\13\r\13\16"+
		"\13\u02c6\3\13\3\13\5\13\u02cb\n\13\3\13\3\13\3\13\5\13\u02d0\n\13\6\13"+
		"\u02d2\n\13\r\13\16\13\u02d3\3\13\3\13\5\13\u02d8\n\13\3\13\3\13\5\13"+
		"\u02dc\n\13\3\13\3\13\5\13\u02e0\n\13\6\13\u02e2\n\13\r\13\16\13\u02e3"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u02ec\n\13\3\13\6\13\u02ef\n\13\r"+
		"\13\16\13\u02f0\3\13\3\13\5\13\u02f5\n\13\5\13\u02f7\n\13\3\13\3\13\3"+
		"\13\3\13\5\13\u02fd\n\13\6\13\u02ff\n\13\r\13\16\13\u0300\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u0309\n\13\6\13\u030b\n\13\r\13\16\13\u030c\5"+
		"\13\u030f\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0317\n\13\3\13\6\13"+
		"\u031a\n\13\r\13\16\13\u031b\3\13\3\13\5\13\u0320\n\13\5\13\u0322\n\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0328\n\13\6\13\u032a\n\13\r\13\16\13\u032b"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0334\n\13\3\13\3\13\3\13\5\13\u0339"+
		"\n\13\5\13\u033b\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0343\n\13\6"+
		"\13\u0345\n\13\r\13\16\13\u0346\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u034f"+
		"\n\13\3\13\3\13\3\13\5\13\u0354\n\13\5\13\u0356\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u035d\n\13\6\13\u035f\n\13\r\13\16\13\u0360\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u0369\n\13\3\13\3\13\3\13\5\13\u036e\n\13\5\13"+
		"\u0370\n\13\3\13\3\13\3\13\5\13\u0375\n\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u037d\n\13\3\13\3\13\3\13\5\13\u0382\n\13\5\13\u0384\n\13\3\13"+
		"\3\13\3\13\3\13\5\13\u038a\n\13\6\13\u038c\n\13\r\13\16\13\u038d\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u0396\n\13\3\13\3\13\3\13\5\13\u039b\n"+
		"\13\6\13\u039d\n\13\r\13\16\13\u039e\3\13\3\13\5\13\u03a3\n\13\5\13\u03a5"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u03ac\n\13\6\13\u03ae\n\13\r\13\16"+
		"\13\u03af\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u03b8\n\13\3\13\3\13\5\13"+
		"\u03bc\n\13\6\13\u03be\n\13\r\13\16\13\u03bf\3\13\3\13\5\13\u03c4\n\13"+
		"\5\13\u03c6\n\13\3\13\3\13\3\13\3\13\5\13\u03cc\n\13\6\13\u03ce\n\13\r"+
		"\13\16\13\u03cf\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u03d8\n\13\3\13\3\13"+
		"\3\13\5\13\u03dd\n\13\5\13\u03df\n\13\3\13\3\13\3\13\3\13\5\13\u03e5\n"+
		"\13\6\13\u03e7\n\13\r\13\16\13\u03e8\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u03f1\n\13\3\13\3\13\5\13\u03f5\n\13\6\13\u03f7\n\13\r\13\16\13\u03f8"+
		"\3\13\3\13\3\13\5\13\u03fe\n\13\6\13\u0400\n\13\r\13\16\13\u0401\3\13"+
		"\5\13\u0405\n\13\5\13\u0407\n\13\3\f\3\f\5\f\u040b\n\f\3\f\3\f\3\f\5\f"+
		"\u0410\n\f\6\f\u0412\n\f\r\f\16\f\u0413\3\f\5\f\u0417\n\f\3\r\3\r\6\r"+
		"\u041b\n\r\r\r\16\r\u041c\3\r\3\r\5\r\u0421\n\r\5\r\u0423\n\r\3\r\3\r"+
		"\5\r\u0427\n\r\3\r\3\r\5\r\u042b\n\r\6\r\u042d\n\r\r\r\16\r\u042e\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u0437\n\r\6\r\u0439\n\r\r\r\16\r\u043a\5\r\u043d"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0445\n\r\6\r\u0447\n\r\r\r\16\r\u0448"+
		"\6\r\u044b\n\r\r\r\16\r\u044c\3\r\3\r\5\r\u0451\n\r\3\r\3\r\5\r\u0455"+
		"\n\r\6\r\u0457\n\r\r\r\16\r\u0458\5\r\u045b\n\r\3\r\3\r\5\r\u045f\n\r"+
		"\3\r\3\r\5\r\u0463\n\r\6\r\u0465\n\r\r\r\16\r\u0466\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u046e\n\r\6\r\u0470\n\r\r\r\16\r\u0471\3\r\3\r\5\r\u0476\n\r\5"+
		"\r\u0478\n\r\3\r\3\r\3\r\3\r\5\r\u047e\n\r\6\r\u0480\n\r\r\r\16\r\u0481"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u048a\n\r\6\r\u048c\n\r\r\r\16\r\u048d\5"+
		"\r\u0490\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u0497\n\r\6\r\u0499\n\r\r\r\16\r"+
		"\u049a\3\r\3\r\5\r\u049f\n\r\5\r\u04a1\n\r\3\r\3\r\3\r\3\r\5\r\u04a7\n"+
		"\r\6\r\u04a9\n\r\r\r\16\r\u04aa\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04b3\n\r"+
		"\5\r\u04b5\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04bd\n\r\6\r\u04bf\n\r\r\r"+
		"\16\r\u04c0\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u04c9\n\r\5\r\u04cb\n\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u04d2\n\r\6\r\u04d4\n\r\r\r\16\r\u04d5\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u04de\n\r\5\r\u04e0\n\r\3\r\3\r\3\r\5\r\u04e5\n\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u04ed\n\r\5\r\u04ef\n\r\3\r\3\r\3\r\3\r\5\r\u04f5"+
		"\n\r\6\r\u04f7\n\r\r\r\16\r\u04f8\3\r\3\r\3\r\3\r\3\r\5\r\u0500\n\r\6"+
		"\r\u0502\n\r\r\r\16\r\u0503\3\r\3\r\5\r\u0508\n\r\5\r\u050a\n\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u0511\n\r\6\r\u0513\n\r\r\r\16\r\u0514\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u051c\n\r\6\r\u051e\n\r\r\r\16\r\u051f\3\r\3\r\5\r\u0524"+
		"\n\r\5\r\u0526\n\r\3\r\3\r\3\r\3\r\5\r\u052c\n\r\6\r\u052e\n\r\r\r\16"+
		"\r\u052f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0538\n\r\5\r\u053a\n\r\3\r\3\r\3"+
		"\r\3\r\5\r\u0540\n\r\6\r\u0542\n\r\r\r\16\r\u0543\3\r\3\r\3\r\3\r\5\r"+
		"\u054a\n\r\6\r\u054c\n\r\r\r\16\r\u054d\3\r\3\r\3\r\5\r\u0553\n\r\6\r"+
		"\u0555\n\r\r\r\16\r\u0556\3\r\3\r\3\r\5\r\u055c\n\r\5\r\u055e\n\r\3\16"+
		"\3\16\5\16\u0562\n\16\3\16\3\16\5\16\u0566\n\16\3\16\5\16\u0569\n\16\6"+
		"\16\u056b\n\16\r\16\16\16\u056c\3\16\3\16\3\16\5\16\u0572\n\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17\u057b\n\17\7\17\u057d\n\17\f\17\16\17"+
		"\u0580\13\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u05be\n\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u05ec"+
		"\n\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u05f4\n\20\3\20\3\20\3\20\3\20"+
		"\5\20\u05fa\n\20\3\20\5\20\u05fd\n\20\3\20\3\20\3\20\3\20\5\20\u0603\n"+
		"\20\3\20\5\20\u0606\n\20\7\20\u0608\n\20\f\20\16\20\u060b\13\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0616\n\20\6\20\u0618\n\20"+
		"\r\20\16\20\u0619\3\20\3\20\5\20\u061e\n\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0631"+
		"\n\20\3\20\3\20\3\20\5\20\u0636\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0646\n\20\3\20\3\20\7\20\u064a"+
		"\n\20\f\20\16\20\u064d\13\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u0655"+
		"\n\20\r\20\16\20\u0656\3\20\3\20\3\20\3\20\5\20\u065d\n\20\6\20\u065f"+
		"\n\20\r\20\16\20\u0660\3\20\3\20\5\20\u0665\n\20\3\21\3\21\5\21\u0669"+
		"\n\21\3\22\3\22\7\22\u066d\n\22\f\22\16\22\u0670\13\22\3\22\3\22\3\23"+
		"\3\23\7\23\u0676\n\23\f\23\16\23\u0679\13\23\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\5\26\u0685\n\26\3\26\5\26\u0688\n\26\3\26\3"+
		"\26\5\26\u068c\n\26\3\26\5\26\u068f\n\26\7\26\u0691\n\26\f\26\16\26\u0694"+
		"\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u069e\n\27\6\27\u06a0"+
		"\n\27\r\27\16\27\u06a1\3\30\3\30\5\30\u06a6\n\30\3\30\3\30\3\30\3\30\5"+
		"\30\u06ac\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u06b3\n\30\3\30\3\30\3\30"+
		"\3\30\5\30\u06b9\n\30\3\30\3\30\5\30\u06bd\n\30\3\30\3\30\3\30\3\30\5"+
		"\30\u06c3\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u06ca\n\30\7\30\u06cc\n\30"+
		"\f\30\16\30\u06cf\13\30\3\31\3\31\3\31\3\31\3\31\5\31\u06d6\n\31\3\31"+
		"\7\31\u06d9\n\31\f\31\16\31\u06dc\13\31\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u06e3\n\31\f\31\16\31\u06e6\13\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u06f0\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u06f9\n"+
		"\31\3\32\3\32\3\32\5\32\u06fe\n\32\3\32\5\32\u0701\n\32\3\32\3\32\3\32"+
		"\3\32\5\32\u0707\n\32\7\32\u0709\n\32\f\32\16\32\u070c\13\32\3\32\3\32"+
		"\3\32\3\32\3\32\5\32\u0713\n\32\6\32\u0715\n\32\r\32\16\32\u0716\3\32"+
		"\3\32\5\32\u071b\n\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\5\34\u0724\n"+
		"\34\3\34\3\34\5\34\u0728\n\34\3\34\3\34\3\34\3\34\5\34\u072e\n\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u0736\n\34\3\34\7\34\u0739\n\34\f\34\16"+
		"\34\u073c\13\34\3\34\3\34\3\34\3\34\7\34\u0742\n\34\f\34\16\34\u0745\13"+
		"\34\5\34\u0747\n\34\3\34\5\34\u074a\n\34\6\34\u074c\n\34\r\34\16\34\u074d"+
		"\5\34\u0750\n\34\3\34\3\34\3\34\3\34\3\34\5\34\u0757\n\34\6\34\u0759\n"+
		"\34\r\34\16\34\u075a\3\34\3\34\5\34\u075f\n\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\5\34\u0767\n\34\3\34\3\34\5\34\u076b\n\34\3\34\3\34\3\34\3\34\5"+
		"\34\u0771\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u077b\n\34"+
		"\f\34\16\34\u077e\13\34\3\34\5\34\u0781\n\34\3\34\5\34\u0784\n\34\6\34"+
		"\u0786\n\34\r\34\16\34\u0787\3\34\3\34\5\34\u078c\n\34\3\34\3\34\3\34"+
		"\3\34\5\34\u0792\n\34\3\35\3\35\3\35\3\36\3\36\5\36\u0799\n\36\3\36\3"+
		"\36\3\36\3\36\3\36\5\36\u07a0\n\36\6\36\u07a2\n\36\r\36\16\36\u07a3\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u07ae\n\36\6\36\u07b0\n\36"+
		"\r\36\16\36\u07b1\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u07ba\n\36\3\36\3"+
		"\36\3\36\3\36\3\36\5\36\u07c1\n\36\6\36\u07c3\n\36\r\36\16\36\u07c4\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u07ce\n\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u07d5\n\36\6\36\u07d7\n\36\r\36\16\36\u07d8\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\5\36\u07e1\n\36\6\36\u07e3\n\36\r\36\16\36\u07e4\3\36"+
		"\3\36\5\36\u07e9\n\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u07f1\n\36\3"+
		"\36\3\36\3\36\5\36\u07f6\n\36\3\36\3\36\3\36\5\36\u07fb\n\36\5\36\u07fd"+
		"\n\36\3\36\3\36\3\36\5\36\u0802\n\36\3\36\3\36\3\36\3\36\5\36\u0808\n"+
		"\36\3\37\3\37\5\37\u080c\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u0815\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\5\37\u0825\n\37\3\37\3\37\3\37\5\37\u082a\n\37\3\37\3\37\3"+
		"\37\5\37\u082f\n\37\5\37\u0831\n\37\3\37\3\37\3\37\5\37\u0836\n\37\3\37"+
		"\3\37\3\37\3\37\5\37\u083c\n\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\5!\u0848"+
		"\n!\3!\5!\u084b\n!\6!\u084d\n!\r!\16!\u084e\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\5\"\u0858\n\"\3#\3#\3#\3#\3#\3#\3#\5#\u0861\n#\5#\u0863\n#\3$\3$\5$\u0867"+
		"\n$\3%\3%\3%\3%\3%\3%\5%\u086f\n%\3&\5&\u0872\n&\3&\3&\3&\3&\5&\u0878"+
		"\n&\3\'\3\'\3\'\3\'\7\'\u087e\n\'\f\'\16\'\u0881\13\'\3\'\3\'\3(\3(\3"+
		"(\3)\3)\3*\3*\3*\3*\3*\7*\u088f\n*\f*\16*\u0892\13*\3*\3*\3+\3+\3+\3+"+
		"\3,\3,\3,\3-\3-\3-\3.\3.\3/\3/\3/\3/\5/\u08a6\n/\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\7\61\u08b5\n\61\f\61\16\61"+
		"\u08b8\13\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u08c4"+
		"\n\62\3\62\3\62\5\62\u08c8\n\62\5\62\u08ca\n\62\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u08d7\n\63\3\64\3\64\3\64\7\64"+
		"\u08dc\n\64\f\64\16\64\u08df\13\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\78\u08f4\n8\f8"+
		"\168\u08f7\138\39\39\39\39\59\u08fd\n9\39\39\39\39\3:\3:\3:\3:\3:\3;\3"+
		";\3<\3<\3<\3<\5<\u090e\n<\3=\5=\u0911\n=\3=\3=\5=\u0915\n=\3=\5=\u0918"+
		"\n=\3=\3=\5=\u091c\n=\5=\u091e\n=\3>\3>\3?\3?\5?\u0924\n?\3@\3@\3@\5@"+
		"\u0929\n@\3A\3A\3A\5A\u092e\nA\3B\3B\3B\3C\3C\3C\3D\3D\3D\3E\3E\3F\3F"+
		"\3F\5F\u093e\nF\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\5G\u094d\nG\3H"+
		"\3H\3I\3I\3J\3J\5J\u0955\nJ\3J\3J\5J\u0959\nJ\3J\3J\3J\5J\u095e\nJ\3J"+
		"\3J\3J\5J\u0963\nJ\3J\3J\5J\u0967\nJ\3J\5J\u096a\nJ\3K\3K\3K\3K\3L\3L"+
		"\3L\5L\u0973\nL\3L\3L\3L\5L\u0978\nL\3L\3L\5L\u097c\nL\3L\3L\3L\3L\5L"+
		"\u0982\nL\3L\3L\3L\3L\5L\u0988\nL\3L\3L\3L\5L\u098d\nL\3L\3L\5L\u0991"+
		"\nL\5L\u0993\nL\3M\3M\5M\u0997\nM\3M\3M\5M\u099b\nM\5M\u099d\nM\3N\3N"+
		"\5N\u09a1\nN\3O\3O\5O\u09a5\nO\3O\3O\5O\u09a9\nO\3O\3O\5O\u09ad\nO\3O"+
		"\3O\3O\3O\3O\3O\3O\3O\3O\5O\u09b8\nO\3P\3P\5P\u09bc\nP\3P\3P\3P\3P\3P"+
		"\3P\5P\u09c4\nP\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\5Q\u09ce\nQ\3R\3R\3S\3S\3S\3S"+
		"\3S\3S\3S\3S\3S\3S\3S\3S\3S\5S\u09df\nS\3T\3T\5T\u09e3\nT\3T\3T\5T\u09e7"+
		"\nT\3T\3T\3T\5T\u09ec\nT\5T\u09ee\nT\3U\3U\5U\u09f2\nU\3U\3U\3U\5U\u09f7"+
		"\nU\3U\3U\5U\u09fb\nU\5U\u09fd\nU\3V\3V\5V\u0a01\nV\3W\3W\3W\3W\3X\3X"+
		"\3X\3X\3X\3X\3X\5X\u0a0e\nX\3Y\3Y\3Z\3Z\3[\5[\u0a15\n[\3[\3[\3\\\3\\\3"+
		"]\3]\3]\3]\3]\3]\5]\u0a21\n]\5]\u0a23\n]\3^\3^\3^\5^\u0a28\n^\3^\3^\3"+
		"^\3_\3_\3`\3`\3`\3`\3`\3`\3a\3a\3a\3a\3a\3b\3b\3c\3c\3c\3c\3c\3c\3c\3"+
		"c\3c\3c\3c\3c\6c\u0a48\nc\rc\16c\u0a49\3c\3c\5c\u0a4e\nc\3d\3d\5d\u0a52"+
		"\nd\3e\3e\3e\6e\u0a57\ne\re\16e\u0a58\3e\5e\u0a5c\ne\3e\3e\3f\3f\6f\u0a62"+
		"\nf\rf\16f\u0a63\3f\5f\u0a67\nf\3f\3f\3g\3g\3g\3g\3g\3h\3h\3h\3h\3h\3"+
		"i\3i\3i\3j\3j\5j\u0a7a\nj\3k\3k\3k\3k\3k\3k\3k\3l\3l\3m\3m\3n\3n\3n\5"+
		"n\u0a8a\nn\3o\3o\3o\5o\u0a8f\no\3p\3p\3p\7p\u0a94\np\fp\16p\u0a97\13p"+
		"\3q\3q\3q\7q\u0a9c\nq\fq\16q\u0a9f\13q\3r\5r\u0aa2\nr\3r\3r\3s\3s\3s\3"+
		"s\7s\u0aaa\ns\fs\16s\u0aad\13s\3s\3s\3t\3t\3t\7t\u0ab4\nt\ft\16t\u0ab7"+
		"\13t\3t\5t\u0aba\nt\3u\3u\3v\3v\3w\3w\3w\3w\3w\3w\3w\3x\3x\3x\5x\u0aca"+
		"\nx\3y\3y\3z\3z\5z\u0ad0\nz\3{\3{\3|\3|\3|\7|\u0ad7\n|\f|\16|\u0ada\13"+
		"|\3}\3}\3~\3~\5~\u0ae0\n~\3\177\3\177\3\u0080\3\u0080\3\u0080\3\u0080"+
		"\3\u0080\3\u0081\5\u0081\u0aea\n\u0081\3\u0081\5\u0081\u0aed\n\u0081\3"+
		"\u0081\5\u0081\u0af0\n\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\5"+
		"\u0081\u0af7\n\u0081\3\u0082\3\u0082\3\u0083\3\u0083\3\u0084\3\u0084\3"+
		"\u0084\7\u0084\u0b00\n\u0084\f\u0084\16\u0084\u0b03\13\u0084\3\u0085\3"+
		"\u0085\3\u0085\7\u0085\u0b08\n\u0085\f\u0085\16\u0085\u0b0b\13\u0085\3"+
		"\u0086\3\u0086\3\u0086\5\u0086\u0b10\n\u0086\3\u0087\3\u0087\5\u0087\u0b14"+
		"\n\u0087\3\u0088\3\u0088\5\u0088\u0b18\n\u0088\3\u0088\3\u0088\3\u0089"+
		"\3\u0089\3\u008a\3\u008a\5\u008a\u0b20\n\u008a\3\u008b\3\u008b\5\u008b"+
		"\u0b24\n\u008b\3\u008c\3\u008c\3\u008c\3\u008c\3\u008d\3\u008d\5\u008d"+
		"\u0b2c\n\u008d\3\u008e\3\u008e\3\u008f\3\u008f\3\u0090\3\u0090\5\u0090"+
		"\u0b34\n\u0090\3\u0091\3\u0091\5\u0091\u0b38\n\u0091\3\u0092\3\u0092\5"+
		"\u0092\u0b3c\n\u0092\3\u0092\5\u0092\u0b3f\n\u0092\3\u0092\5\u0092\u0b42"+
		"\n\u0092\3\u0092\5\u0092\u0b45\n\u0092\3\u0092\5\u0092\u0b48\n\u0092\3"+
		"\u0093\3\u0093\3\u0093\3\u0094\3\u0094\3\u0094\7\u0094\u0b50\n\u0094\f"+
		"\u0094\16\u0094\u0b53\13\u0094\3\u0095\3\u0095\5\u0095\u0b57\n\u0095\3"+
		"\u0096\3\u0096\6\u0096\u0b5b\n\u0096\r\u0096\16\u0096\u0b5c\3\u0097\3"+
		"\u0097\3\u0097\3\u0097\5\u0097\u0b63\n\u0097\3\u0097\3\u0097\3\u0097\3"+
		"\u0097\3\u0097\3\u0097\5\u0097\u0b6b\n\u0097\3\u0097\3\u0097\3\u0097\3"+
		"\u0097\3\u0097\5\u0097\u0b72\n\u0097\3\u0098\3\u0098\3\u0098\3\u0098\3"+
		"\u0099\5\u0099\u0b79\n\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u009a\3"+
		"\u009a\5\u009a\u0b81\n\u009a\3\u009a\3\u009a\3\u009a\3\u009b\3\u009b\3"+
		"\u009b\3\u009b\3\u009c\3\u009c\5\u009c\u0b8c\n\u009c\3\u009d\3\u009d\5"+
		"\u009d\u0b90\n\u009d\3\u009e\3\u009e\3\u009f\3\u009f\5\u009f\u0b96\n\u009f"+
		"\3\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1\3\u00a1\3\u00a1\3\u00a1\3\u00a2"+
		"\3\u00a2\5\u00a2\u0ba2\n\u00a2\3\u00a2\5\u00a2\u0ba5\n\u00a2\3\u00a2\3"+
		"\u00a2\3\u00a2\3\u00a2\5\u00a2\u0bab\n\u00a2\3\u00a2\3\u00a2\5\u00a2\u0baf"+
		"\n\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2\5\u00a2\u0bb6\n\u00a2"+
		"\5\u00a2\u0bb8\n\u00a2\3\u00a3\3\u00a3\3\u00a3\7\u00a3\u0bbd\n\u00a3\f"+
		"\u00a3\16\u00a3\u0bc0\13\u00a3\3\u00a4\3\u00a4\3\u00a5\3\u00a5\3\u00a5"+
		"\3\u00a6\3\u00a6\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a8\3\u00a8\3\u00a8"+
		"\7\u00a8\u0bd0\n\u00a8\f\u00a8\16\u00a8\u0bd3\13\u00a8\3\u00a9\3\u00a9"+
		"\3\u00a9\3\u00a9\5\u00a9\u0bd9\n\u00a9\3\u00aa\3\u00aa\3\u00aa\3\u00aa"+
		"\3\u00aa\5\u00aa\u0be0\n\u00aa\3\u00ab\3\u00ab\3\u00ab\7\u00ab\u0be5\n"+
		"\u00ab\f\u00ab\16\u00ab\u0be8\13\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ac"+
		"\3\u00ac\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ae\3\u00ae\3\u00ae"+
		"\3\u00af\3\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b0\7\u00b0\u0bfd\n\u00b0"+
		"\f\u00b0\16\u00b0\u0c00\13\u00b0\3\u00b1\3\u00b1\3\u00b2\3\u00b2\5\u00b2"+
		"\u0c06\n\u00b2\3\u00b3\3\u00b3\3\u00b3\3\u00b3\5\u00b3\u0c0c\n\u00b3\3"+
		"\u00b3\3\u00b3\5\u00b3\u0c10\n\u00b3\3\u00b3\3\u00b3\5\u00b3\u0c14\n\u00b3"+
		"\3\u00b3\7\u00b3\u0c17\n\u00b3\f\u00b3\16\u00b3\u0c1a\13\u00b3\3\u00b4"+
		"\3\u00b4\5\u00b4\u0c1e\n\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\5\u00b5"+
		"\u0c24\n\u00b5\3\u00b5\3\u00b5\5\u00b5\u0c28\n\u00b5\3\u00b5\3\u00b5\5"+
		"\u00b5\u0c2c\n\u00b5\3\u00b5\7\u00b5\u0c2f\n\u00b5\f\u00b5\16\u00b5\u0c32"+
		"\13\u00b5\3\u00b6\3\u00b6\5\u00b6\u0c36\n\u00b6\3\u00b7\3\u00b7\3\u00b7"+
		"\3\u00b7\3\u00b7\5\u00b7\u0c3d\n\u00b7\3\u00b8\3\u00b8\5\u00b8\u0c41\n"+
		"\u00b8\3\u00b9\3\u00b9\3\u00b9\3\u00ba\3\u00ba\5\u00ba\u0c48\n\u00ba\3"+
		"\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\5\u00bb\u0c4f\n\u00bb\5\u00bb\u0c51"+
		"\n\u00bb\3\u00bc\3\u00bc\5\u00bc\u0c55\n\u00bc\3\u00bc\3\u00bc\5\u00bc"+
		"\u0c59\n\u00bc\3\u00bd\3\u00bd\3\u00bd\7\u00bd\u0c5e\n\u00bd\f\u00bd\16"+
		"\u00bd\u0c61\13\u00bd\3\u00be\3\u00be\5\u00be\u0c65\n\u00be\3\u00bf\3"+
		"\u00bf\5\u00bf\u0c69\n\u00bf\3\u00c0\3\u00c0\5\u00c0\u0c6d\n\u00c0\3\u00c0"+
		"\3\u00c0\3\u00c1\3\u00c1\3\u00c2\3\u00c2\3\u00c2\5\u00c2\u0c76\n\u00c2"+
		"\3\u00c2\3\u00c2\3\u00c3\5\u00c3\u0c7b\n\u00c3\3\u00c3\3\u00c3\3\u00c4"+
		"\3\u00c4\3\u00c4\7\u00c4\u0c82\n\u00c4\f\u00c4\16\u00c4\u0c85\13\u00c4"+
		"\3\u00c5\3\u00c5\3\u00c6\3\u00c6\3\u00c7\3\u00c7\3\u00c8\3\u00c8\3\u00c8"+
		"\3\u00c8\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9\5\u00c9\u0c97"+
		"\n\u00c9\3\u00ca\3\u00ca\3\u00ca\3\u00ca\3\u00cb\3\u00cb\3\u00cc\3\u00cc"+
		"\3\u00cc\3\u00cd\5\u00cd\u0ca3\n\u00cd\3\u00cd\3\u00cd\5\u00cd\u0ca7\n"+
		"\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00ce\3\u00ce\5\u00ce\u0caf\n"+
		"\u00ce\3\u00ce\3\u00ce\3\u00ce\3\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00cf"+
		"\5\u00cf\u0cb9\n\u00cf\3\u00d0\3\u00d0\3\u00d0\7\u00d0\u0cbe\n\u00d0\f"+
		"\u00d0\16\u00d0\u0cc1\13\u00d0\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d2"+
		"\5\u00d2\u0cc8\n\u00d2\3\u00d2\3\u00d2\5\u00d2\u0ccc\n\u00d2\3\u00d3\3"+
		"\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\5\u00d3\u0cd4\n\u00d3\3\u00d4\3"+
		"\u00d4\3\u00d5\3\u00d5\3\u00d5\5\u00d5\u0cdb\n\u00d5\3\u00d5\3\u00d5\3"+
		"\u00d6\3\u00d6\3\u00d6\3\u00d6\3\u00d6\3\u00d7\3\u00d7\5\u00d7\u0ce6\n"+
		"\u00d7\3\u00d8\3\u00d8\3\u00d9\3\u00d9\3\u00da\5\u00da\u0ced\n\u00da\3"+
		"\u00da\3\u00da\3\u00da\3\u00db\3\u00db\3\u00db\3\u00dc\3\u00dc\5\u00dc"+
		"\u0cf7\n\u00dc\3\u00dd\3\u00dd\3\u00de\3\u00de\3\u00df\3\u00df\3\u00df"+
		"\5\u00df\u0d00\n\u00df\3\u00df\3\u00df\3\u00e0\3\u00e0\3\u00e1\3\u00e1"+
		"\5\u00e1\u0d08\n\u00e1\3\u00e2\3\u00e2\3\u00e2\7\u00e2\u0d0d\n\u00e2\f"+
		"\u00e2\16\u00e2\u0d10\13\u00e2\3\u00e3\3\u00e3\3\u00e3\3\u00e3\3\u00e4"+
		"\3\u00e4\3\u00e4\7\u00e4\u0d19\n\u00e4\f\u00e4\16\u00e4\u0d1c\13\u00e4"+
		"\3\u00e5\3\u00e5\5\u00e5\u0d20\n\u00e5\3\u00e5\5\u00e5\u0d23\n\u00e5\3"+
		"\u00e6\3\u00e6\3\u00e7\3\u00e7\3\u00e7\3\u00e8\3\u00e8\3\u00e8\3\u00e8"+
		"\5\u00e8\u0d2e\n\u00e8\3\u00e9\3\u00e9\5\u00e9\u0d32\n\u00e9\3\u00e9\3"+
		"\u00e9\3\u00e9\3\u00e9\3\u00e9\3\u00e9\5\u00e9\u0d3a\n\u00e9\3\u00e9\3"+
		"\u00e9\3\u00e9\3\u00e9\5\u00e9\u0d40\n\u00e9\3\u00e9\3\u00e9\3\u00e9\3"+
		"\u00e9\3\u00e9\3\u00e9\5\u00e9\u0d48\n\u00e9\5\u00e9\u0d4a\n\u00e9\3\u00e9"+
		"\5\u00e9\u0d4d\n\u00e9\3\u00e9\2\2\u00ea\2\4\6\b\n\f\16\20\22\24\26\30"+
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
		"\2\'\4\2JJjj\4\2\u00f3\u00f3\u012e\u012e\t\2\36\36__iiuuwwzz\u00b3\u00b3"+
		"\6\2__iizz\u00b3\u00b3\4\2iiz{\5\2\23\23\27\27qr\4\2\27\27{{\4\2\17\17"+
		"aa\4\2iizz\3\2\u0145\u0145\3\2\u0146\u0146\4\2\u00b5\u00b5\u00b8\u00b8"+
		"\6\299@@RR}}\3\2qr\4\2\61\61JJ\4\2\'\'::\b\2\6\6\25\25\33\33\u0091\u0091"+
		"\u00b0\u00b0\u00e6\u00e6\t\2\u0083\u00ad\u00af\u00af\u00b1\u00eb\u00ed"+
		"\u00fa\u00fc\u0111\u0113\u0121\u0123\u0127\5\2**vv\u00f5\u00f5\3\2\u0102"+
		"\u0103\3\2\u0147\u0148\17\2\b\bll\u0084\u0084\u008d\u008d\u0095\u0095"+
		"\u00a3\u00a3\u00ab\u00ab\u00b4\u00b4\u00c0\u00c0\u00c5\u00c5\u00e7\u00e8"+
		"\u00ea\u00ea\u00f8\u00f9\3\2\u013a\u013b\3\2\u013c\u013e\3\2\u00ef\u00f1"+
		"\5\2\r\rFFtt\5\2--GGdd\4\2%%xx\4\2\6\6  \4\2\u012e\u012e\u0133\u0137\4"+
		"\2\t\too\3\2\u0128\u012b\4\2\b\bll\6\2\u009a\u009a\u00ae\u00ae\u00c7\u00c8"+
		"\u0100\u0100\n\2\u008a\u008a\u009c\u009c\u009f\u00a0\u00a2\u00a2\u00b6"+
		"\u00b7\u00c2\u00c4\u00d8\u00d8\u00fd\u00fd\4\2GGdd\4\2\n\n\37\37\u0efd"+
		"\2\u01d8\3\2\2\2\4\u01ea\3\2\2\2\6\u01ec\3\2\2\2\b\u01ee\3\2\2\2\n\u01f2"+
		"\3\2\2\2\f\u01f4\3\2\2\2\16\u0205\3\2\2\2\20\u0243\3\2\2\2\22\u0245\3"+
		"\2\2\2\24\u0406\3\2\2\2\26\u0408\3\2\2\2\30\u055d\3\2\2\2\32\u055f\3\2"+
		"\2\2\34\u0573\3\2\2\2\36\u05f0\3\2\2\2 \u0668\3\2\2\2\"\u066a\3\2\2\2"+
		"$\u0673\3\2\2\2&\u067c\3\2\2\2(\u067e\3\2\2\2*\u0680\3\2\2\2,\u0697\3"+
		"\2\2\2.\u06a3\3\2\2\2\60\u06f8\3\2\2\2\62\u06fa\3\2\2\2\64\u071f\3\2\2"+
		"\2\66\u0791\3\2\2\28\u0793\3\2\2\2:\u0798\3\2\2\2<\u080b\3\2\2\2>\u083d"+
		"\3\2\2\2@\u0842\3\2\2\2B\u0857\3\2\2\2D\u0862\3\2\2\2F\u0866\3\2\2\2H"+
		"\u086e\3\2\2\2J\u0871\3\2\2\2L\u0879\3\2\2\2N\u0884\3\2\2\2P\u0887\3\2"+
		"\2\2R\u0889\3\2\2\2T\u0895\3\2\2\2V\u0899\3\2\2\2X\u089c\3\2\2\2Z\u089f"+
		"\3\2\2\2\\\u08a5\3\2\2\2^\u08a7\3\2\2\2`\u08b1\3\2\2\2b\u08b9\3\2\2\2"+
		"d\u08cb\3\2\2\2f\u08d8\3\2\2\2h\u08e0\3\2\2\2j\u08e3\3\2\2\2l\u08e6\3"+
		"\2\2\2n\u08f0\3\2\2\2p\u08f8\3\2\2\2r\u0902\3\2\2\2t\u0907\3\2\2\2v\u0909"+
		"\3\2\2\2x\u091d\3\2\2\2z\u091f\3\2\2\2|\u0923\3\2\2\2~\u0928\3\2\2\2\u0080"+
		"\u092d\3\2\2\2\u0082\u092f\3\2\2\2\u0084\u0932\3\2\2\2\u0086\u0935\3\2"+
		"\2\2\u0088\u0938\3\2\2\2\u008a\u093d\3\2\2\2\u008c\u094c\3\2\2\2\u008e"+
		"\u094e\3\2\2\2\u0090\u0950\3\2\2\2\u0092\u0969\3\2\2\2\u0094\u096b\3\2"+
		"\2\2\u0096\u0992\3\2\2\2\u0098\u099c\3\2\2\2\u009a\u09a0\3\2\2\2\u009c"+
		"\u09b7\3\2\2\2\u009e\u09c3\3\2\2\2\u00a0\u09cd\3\2\2\2\u00a2\u09cf\3\2"+
		"\2\2\u00a4\u09de\3\2\2\2\u00a6\u09ed\3\2\2\2\u00a8\u09fc\3\2\2\2\u00aa"+
		"\u0a00\3\2\2\2\u00ac\u0a02\3\2\2\2\u00ae\u0a0d\3\2\2\2\u00b0\u0a0f\3\2"+
		"\2\2\u00b2\u0a11\3\2\2\2\u00b4\u0a14\3\2\2\2\u00b6\u0a18\3\2\2\2\u00b8"+
		"\u0a22\3\2\2\2\u00ba\u0a24\3\2\2\2\u00bc\u0a2c\3\2\2\2\u00be\u0a2e\3\2"+
		"\2\2\u00c0\u0a34\3\2\2\2\u00c2\u0a39\3\2\2\2\u00c4\u0a4d\3\2\2\2\u00c6"+
		"\u0a51\3\2\2\2\u00c8\u0a53\3\2\2\2\u00ca\u0a5f\3\2\2\2\u00cc\u0a6a\3\2"+
		"\2\2\u00ce\u0a6f\3\2\2\2\u00d0\u0a74\3\2\2\2\u00d2\u0a79\3\2\2\2\u00d4"+
		"\u0a7b\3\2\2\2\u00d6\u0a82\3\2\2\2\u00d8\u0a84\3\2\2\2\u00da\u0a89\3\2"+
		"\2\2\u00dc\u0a8e\3\2\2\2\u00de\u0a90\3\2\2\2\u00e0\u0a98\3\2\2\2\u00e2"+
		"\u0aa1\3\2\2\2\u00e4\u0aa5\3\2\2\2\u00e6\u0ab9\3\2\2\2\u00e8\u0abb\3\2"+
		"\2\2\u00ea\u0abd\3\2\2\2\u00ec\u0abf\3\2\2\2\u00ee\u0ac9\3\2\2\2\u00f0"+
		"\u0acb\3\2\2\2\u00f2\u0acf\3\2\2\2\u00f4\u0ad1\3\2\2\2\u00f6\u0ad3\3\2"+
		"\2\2\u00f8\u0adb\3\2\2\2\u00fa\u0adf\3\2\2\2\u00fc\u0ae1\3\2\2\2\u00fe"+
		"\u0ae3\3\2\2\2\u0100\u0af6\3\2\2\2\u0102\u0af8\3\2\2\2\u0104\u0afa\3\2"+
		"\2\2\u0106\u0afc\3\2\2\2\u0108\u0b04\3\2\2\2\u010a\u0b0f\3\2\2\2\u010c"+
		"\u0b11\3\2\2\2\u010e\u0b15\3\2\2\2\u0110\u0b1b\3\2\2\2\u0112\u0b1f\3\2"+
		"\2\2\u0114\u0b23\3\2\2\2\u0116\u0b25\3\2\2\2\u0118\u0b2b\3\2\2\2\u011a"+
		"\u0b2d\3\2\2\2\u011c\u0b2f\3\2\2\2\u011e\u0b33\3\2\2\2\u0120\u0b37\3\2"+
		"\2\2\u0122\u0b39\3\2\2\2\u0124\u0b49\3\2\2\2\u0126\u0b4c\3\2\2\2\u0128"+
		"\u0b56\3\2\2\2\u012a\u0b58\3\2\2\2\u012c\u0b71\3\2\2\2\u012e\u0b73\3\2"+
		"\2\2\u0130\u0b78\3\2\2\2\u0132\u0b7e\3\2\2\2\u0134\u0b85\3\2\2\2\u0136"+
		"\u0b8b\3\2\2\2\u0138\u0b8d\3\2\2\2\u013a\u0b91\3\2\2\2\u013c\u0b95\3\2"+
		"\2\2\u013e\u0b97\3\2\2\2\u0140\u0b9a\3\2\2\2\u0142\u0bb7\3\2\2\2\u0144"+
		"\u0bb9\3\2\2\2\u0146\u0bc1\3\2\2\2\u0148\u0bc3\3\2\2\2\u014a\u0bc6\3\2"+
		"\2\2\u014c\u0bc8\3\2\2\2\u014e\u0bcc\3\2\2\2\u0150\u0bd8\3\2\2\2\u0152"+
		"\u0bdf\3\2\2\2\u0154\u0be1\3\2\2\2\u0156\u0be9\3\2\2\2\u0158\u0bee\3\2"+
		"\2\2\u015a\u0bf3\3\2\2\2\u015c\u0bf6\3\2\2\2\u015e\u0bf9\3\2\2\2\u0160"+
		"\u0c01\3\2\2\2\u0162\u0c05\3\2\2\2\u0164\u0c0f\3\2\2\2\u0166\u0c1d\3\2"+
		"\2\2\u0168\u0c27\3\2\2\2\u016a\u0c35\3\2\2\2\u016c\u0c3c\3\2\2\2\u016e"+
		"\u0c40\3\2\2\2\u0170\u0c42\3\2\2\2\u0172\u0c47\3\2\2\2\u0174\u0c49\3\2"+
		"\2\2\u0176\u0c52\3\2\2\2\u0178\u0c5a\3\2\2\2\u017a\u0c64\3\2\2\2\u017c"+
		"\u0c66\3\2\2\2\u017e\u0c6c\3\2\2\2\u0180\u0c70\3\2\2\2\u0182\u0c75\3\2"+
		"\2\2\u0184\u0c7a\3\2\2\2\u0186\u0c7e\3\2\2\2\u0188\u0c86\3\2\2\2\u018a"+
		"\u0c88\3\2\2\2\u018c\u0c8a\3\2\2\2\u018e\u0c8c\3\2\2\2\u0190\u0c96\3\2"+
		"\2\2\u0192\u0c98\3\2\2\2\u0194\u0c9c\3\2\2\2\u0196\u0c9e\3\2\2\2\u0198"+
		"\u0ca2\3\2\2\2\u019a\u0cac\3\2\2\2\u019c\u0cb8\3\2\2\2\u019e\u0cba\3\2"+
		"\2\2\u01a0\u0cc2\3\2\2\2\u01a2\u0ccb\3\2\2\2\u01a4\u0cd3\3\2\2\2\u01a6"+
		"\u0cd5\3\2\2\2\u01a8\u0cd7\3\2\2\2\u01aa\u0cde\3\2\2\2\u01ac\u0ce5\3\2"+
		"\2\2\u01ae\u0ce7\3\2\2\2\u01b0\u0ce9\3\2\2\2\u01b2\u0cec\3\2\2\2\u01b4"+
		"\u0cf1\3\2\2\2\u01b6\u0cf6\3\2\2\2\u01b8\u0cf8\3\2\2\2\u01ba\u0cfa\3\2"+
		"\2\2\u01bc\u0cfc\3\2\2\2\u01be\u0d03\3\2\2\2\u01c0\u0d07\3\2\2\2\u01c2"+
		"\u0d09\3\2\2\2\u01c4\u0d11\3\2\2\2\u01c6\u0d15\3\2\2\2\u01c8\u0d1d\3\2"+
		"\2\2\u01ca\u0d24\3\2\2\2\u01cc\u0d26\3\2\2\2\u01ce\u0d2d\3\2\2\2\u01d0"+
		"\u0d4c\3\2\2\2\u01d2\u01d4\5\4\3\2\u01d3\u01d5\7\u0130\2\2\u01d4\u01d3"+
		"\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01d2\3\2\2\2\u01d7"+
		"\u01da\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01db\3\2"+
		"\2\2\u01da\u01d8\3\2\2\2\u01db\u01dc\7\2\2\3\u01dc\3\3\2\2\2\u01dd\u01eb"+
		"\5\6\4\2\u01de\u01eb\5\n\6\2\u01df\u01eb\5\f\7\2\u01e0\u01eb\5\16\b\2"+
		"\u01e1\u01eb\5\20\t\2\u01e2\u01eb\5\22\n\2\u01e3\u01eb\5\30\r\2\u01e4"+
		"\u01eb\5\24\13\2\u01e5\u01eb\5\34\17\2\u01e6\u01eb\5\36\20\2\u01e7\u01eb"+
		"\5.\30\2\u01e8\u01eb\5\60\31\2\u01e9\u01eb\5\62\32\2\u01ea\u01dd\3\2\2"+
		"\2\u01ea\u01de\3\2\2\2\u01ea\u01df\3\2\2\2\u01ea\u01e0\3\2\2\2\u01ea\u01e1"+
		"\3\2\2\2\u01ea\u01e2\3\2\2\2\u01ea\u01e3\3\2\2\2\u01ea\u01e4\3\2\2\2\u01ea"+
		"\u01e5\3\2\2\2\u01ea\u01e6\3\2\2\2\u01ea\u01e7\3\2\2\2\u01ea\u01e8\3\2"+
		"\2\2\u01ea\u01e9\3\2\2\2\u01eb\5\3\2\2\2\u01ec\u01ed\5\u0160\u00b1\2\u01ed"+
		"\7\3\2\2\2\u01ee\u01ef\5\u01d0\u00e9\2\u01ef\t\3\2\2\2\u01f0\u01f3\5\66"+
		"\34\2\u01f1\u01f3\5v<\2\u01f2\u01f0\3\2\2\2\u01f2\u01f1\3\2\2\2\u01f3"+
		"\13\3\2\2\2\u01f4\u01f6\7\27\2\2\u01f5\u01f7\7y\2\2\u01f6\u01f5\3\2\2"+
		"\2\u01f6\u01f7\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\7\u00af\2\2\u01f9"+
		"\u01fa\5x=\2\u01fa\u01fb\7P\2\2\u01fb\u01fd\5\u0174\u00bb\2\u01fc\u01fe"+
		"\5V,\2\u01fd\u01fc\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff"+
		"\u0200\7\u0138\2\2\u0200\u0201\5\u01c6\u00e4\2\u0201\u0203\7\u0139\2\2"+
		"\u0202\u0204\5R*\2\u0203\u0202\3\2\2\2\u0203\u0204\3\2\2\2\u0204\r\3\2"+
		"\2\2\u0205\u0206\7\27\2\2\u0206\u020a\7)\2\2\u0207\u0208\7\65\2\2\u0208"+
		"\u0209\7L\2\2\u0209\u020b\7\u00a4\2\2\u020a\u0207\3\2\2\2\u020a\u020b"+
		"\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020e\5x=\2\u020d\u020f\7\u0081\2\2"+
		"\u020e\u020d\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0212\3\2\2\2\u0210\u0211"+
		"\7f\2\2\u0211\u0213\5x=\2\u0212\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213"+
		"\u0216\3\2\2\2\u0214\u0215\7\u00fb\2\2\u0215\u0217\5x=\2\u0216\u0214\3"+
		"\2\2\2\u0216\u0217\3\2\2\2\u0217\u021a\3\2\2\2\u0218\u0219\7\60\2\2\u0219"+
		"\u021b\5x=\2\u021a\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021b\17\3\2\2\2"+
		"\u021c\u021e\7\u00e1\2\2\u021d\u021f\t\2\2\2\u021e\u021d\3\2\2\2\u021e"+
		"\u021f\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0221\5x=\2\u0221\u022d\t\3\2"+
		"\2\u0222\u0229\5x=\2\u0223\u0224\7\u0142\2\2\u0224\u0225\5x=\2\u0225\u0226"+
		"\7\u0142\2\2\u0226\u0229\3\2\2\2\u0227\u0229\7\32\2\2\u0228\u0222\3\2"+
		"\2\2\u0228\u0223\3\2\2\2\u0228\u0227\3\2\2\2\u0229\u022b\3\2\2\2\u022a"+
		"\u022c\7\u0131\2\2\u022b\u022a\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022e"+
		"\3\2\2\2\u022d\u0228\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u022d\3\2\2\2\u022f"+
		"\u0230\3\2\2\2\u0230\u0244\3\2\2\2\u0231\u0233\7\u00e1\2\2\u0232\u0234"+
		"\t\2\2\2\u0233\u0232\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0235\3\2\2\2\u0235"+
		"\u0236\7\u011c\2\2\u0236\u023f\7\u0101\2\2\u0237\u023b\5x=\2\u0238\u023b"+
		"\7J\2\2\u0239\u023b\7\32\2\2\u023a\u0237\3\2\2\2\u023a\u0238\3\2\2\2\u023a"+
		"\u0239\3\2\2\2\u023b\u023d\3\2\2\2\u023c\u023e\7\u0131\2\2\u023d\u023c"+
		"\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0240\3\2\2\2\u023f\u023a\3\2\2\2\u0240"+
		"\u0241\3\2\2\2\u0241\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0244\3\2"+
		"\2\2\u0243\u021c\3\2\2\2\u0243\u0231\3\2\2\2\u0244\21\3\2\2\2\u0245\u0247"+
		"\7\27\2\2\u0246\u0248\7\24\2\2\u0247\u0246\3\2\2\2\u0247\u0248\3\2\2\2"+
		"\u0248\u0249\3\2\2\2\u0249\u024a\7u\2\2\u024a\u024f\5x=\2\u024b\u0250"+
		"\7\f\2\2\u024c\u024d\7A\2\2\u024d\u0250\7N\2\2\u024e\u0250\7\4\2\2\u024f"+
		"\u024b\3\2\2\2\u024f\u024c\3\2\2\2\u024f\u024e\3\2\2\2\u0250\u0260\3\2"+
		"\2\2\u0251\u0261\7\u00b3\2\2\u0252\u0261\7\36\2\2\u0253\u0261\7w\2\2\u0254"+
		"\u025e\7z\2\2\u0255\u025a\7N\2\2\u0256\u0258\5x=\2\u0257\u0259\7\u0131"+
		"\2\2\u0258\u0257\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025b\3\2\2\2\u025a"+
		"\u0256\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025a\3\2\2\2\u025c\u025d\3\2"+
		"\2\2\u025d\u025f\3\2\2\2\u025e\u0255\3\2\2\2\u025e\u025f\3\2\2\2\u025f"+
		"\u0261\3\2\2\2\u0260\u0251\3\2\2\2\u0260\u0252\3\2\2\2\u0260\u0253\3\2"+
		"\2\2\u0260\u0254\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0263\7P\2\2\u0263"+
		"\u0266\5\u0174\u00bb\2\u0264\u0265\7\60\2\2\u0265\u0267\5\u0174\u00bb"+
		"\2\u0266\u0264\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0271\3\2\2\2\u0268\u0269"+
		"\7L\2\2\u0269\u0272\7\34\2\2\u026a\u026c\7\34\2\2\u026b\u026a\3\2\2\2"+
		"\u026b\u026c\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026e\7<\2\2\u026e\u0272"+
		"\7\67\2\2\u026f\u0270\7<\2\2\u0270\u0272\7\35\2\2\u0271\u0268\3\2\2\2"+
		"\u0271\u026b\3\2\2\2\u0271\u026f\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0279"+
		"\3\2\2\2\u0273\u0275\7+\2\2\u0274\u0276\7\"\2\2\u0275\u0274\3\2\2\2\u0275"+
		"\u0276\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u027a\7]\2\2\u0278\u027a\7m\2"+
		"\2\u0279\u0273\3\2\2\2\u0279\u0278\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027d"+
		"\3\2\2\2\u027b\u027c\7\177\2\2\u027c\u027e\5\u0104\u0083\2\u027d\u027b"+
		"\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0280\7(\2\2\u0280"+
		"\u0281\7Z\2\2\u0281\u0282\5x=\2\u0282\u0287\7\u0138\2\2\u0283\u0285\5"+
		"x=\2\u0284\u0286\7\u0131\2\2\u0285\u0284\3\2\2\2\u0285\u0286\3\2\2\2\u0286"+
		"\u0288\3\2\2\2\u0287\u0283\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0289\3\2"+
		"\2\2\u0289\u028a\7\u0139\2\2\u028a\23\3\2\2\2\u028b\u028f\7c\2\2\u028c"+
		"\u028d\7\62\2\2\u028d\u028e\7\u00ce\2\2\u028e\u0290\7+\2\2\u028f\u028c"+
		"\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u029a\3\2\2\2\u0291\u0293\t\4\2\2\u0292"+
		"\u0291\3\2\2\2\u0293\u0294\3\2\2\2\u0294\u0292\3\2\2\2\u0294\u0295\3\2"+
		"\2\2\u0295\u029b\3\2\2\2\u0296\u0298\7\6\2\2\u0297\u0299\7Y\2\2\u0298"+
		"\u0297\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029b\3\2\2\2\u029a\u0292\3\2"+
		"\2\2\u029a\u0296\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u02ae\7P\2\2\u029d"+
		"\u029f\7p\2\2\u029e\u029d\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a0\3\2"+
		"\2\2\u02a0\u02a2\5\u0174\u00bb\2\u02a1\u029e\3\2\2\2\u02a2\u02a3\3\2\2"+
		"\2\u02a3\u02a1\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4\u02af\3\2\2\2\u02a5\u02a6"+
		"\7\6\2\2\u02a6\u02a7\7\u00ec\2\2\u02a7\u02a8\79\2\2\u02a8\u02aa\7f\2\2"+
		"\u02a9\u02ab\5x=\2\u02aa\u02a9\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02aa"+
		"\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02af\3\2\2\2\u02ae\u02a1\3\2\2\2\u02ae"+
		"\u02a5\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b1\5\26\f\2\u02b1\u0407\3"+
		"\2\2\2\u02b2\u02b6\7c\2\2\u02b3\u02b4\7\62\2\2\u02b4\u02b5\7\u00ce\2\2"+
		"\u02b5\u02b7\7+\2\2\u02b6\u02b3\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02d7"+
		"\3\2\2\2\u02b8\u02b9\t\5\2\2\u02b9\u02be\7\u0138\2\2\u02ba\u02bc\5x=\2"+
		"\u02bb\u02bd\7\u0131\2\2\u02bc\u02bb\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd"+
		"\u02bf\3\2\2\2\u02be\u02ba\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02be\3\2"+
		"\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c3\7\u0139\2\2\u02c3"+
		"\u02c5\3\2\2\2\u02c4\u02b8\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02c4\3\2"+
		"\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02d8\3\2\2\2\u02c8\u02ca\7\6\2\2\u02c9"+
		"\u02cb\7Y\2\2\u02ca\u02c9\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cc\3\2"+
		"\2\2\u02cc\u02d1\7\u0138\2\2\u02cd\u02cf\5x=\2\u02ce\u02d0\7\u0131\2\2"+
		"\u02cf\u02ce\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d2\3\2\2\2\u02d1\u02cd"+
		"\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4"+
		"\u02d5\3\2\2\2\u02d5\u02d6\7\u0139\2\2\u02d6\u02d8\3\2\2\2\u02d7\u02c4"+
		"\3\2\2\2\u02d7\u02c8\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02db\7P\2\2\u02da"+
		"\u02dc\7p\2\2\u02db\u02da\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02e1\3\2"+
		"\2\2\u02dd\u02df\5\u0174\u00bb\2\u02de\u02e0\7\u0131\2\2\u02df\u02de\3"+
		"\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02e2\3\2\2\2\u02e1\u02dd\3\2\2\2\u02e2"+
		"\u02e3\3\2\2\2\u02e3\u02e1\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e5\3\2"+
		"\2\2\u02e5\u02e6\5\26\f\2\u02e6\u0407\3\2\2\2\u02e7\u02eb\7c\2\2\u02e8"+
		"\u02e9\7\62\2\2\u02e9\u02ea\7\u00ce\2\2\u02ea\u02ec\7+\2\2\u02eb\u02e8"+
		"\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02f6\3\2\2\2\u02ed\u02ef\t\6\2\2\u02ee"+
		"\u02ed\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f0\u02f1\3\2"+
		"\2\2\u02f1\u02f7\3\2\2\2\u02f2\u02f4\7\6\2\2\u02f3\u02f5\7Y\2\2\u02f4"+
		"\u02f3\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f7\3\2\2\2\u02f6\u02ee\3\2"+
		"\2\2\u02f6\u02f2\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u030e\7P\2\2\u02f9"+
		"\u02fe\7g\2\2\u02fa\u02fc\5\u0174\u00bb\2\u02fb\u02fd\7\u0131\2\2\u02fc"+
		"\u02fb\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd\u02ff\3\2\2\2\u02fe\u02fa\3\2"+
		"\2\2\u02ff\u0300\3\2\2\2\u0300\u02fe\3\2\2\2\u0300\u0301\3\2\2\2\u0301"+
		"\u030f\3\2\2\2\u0302\u0303\7\6\2\2\u0303\u0304\7h\2\2\u0304\u0305\79\2"+
		"\2\u0305\u030a\7f\2\2\u0306\u0308\5x=\2\u0307\u0309\7\u0131\2\2\u0308"+
		"\u0307\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u030b\3\2\2\2\u030a\u0306\3\2"+
		"\2\2\u030b\u030c\3\2\2\2\u030c\u030a\3\2\2\2\u030c\u030d\3\2\2\2\u030d"+
		"\u030f\3\2\2\2\u030e\u02f9\3\2\2\2\u030e\u0302\3\2\2\2\u030f\u0310\3\2"+
		"\2\2\u0310\u0311\5\26\f\2\u0311\u0407\3\2\2\2\u0312\u0316\7c\2\2\u0313"+
		"\u0314\7\62\2\2\u0314\u0315\7\u00ce\2\2\u0315\u0317\7+\2\2\u0316\u0313"+
		"\3\2\2\2\u0316\u0317\3\2\2\2\u0317\u0321\3\2\2\2\u0318\u031a\t\7\2\2\u0319"+
		"\u0318\3\2\2\2\u031a\u031b\3\2\2\2\u031b\u0319\3\2\2\2\u031b\u031c\3\2"+
		"\2\2\u031c\u0322\3\2\2\2\u031d\u031f\7\6\2\2\u031e\u0320\7Y\2\2\u031f"+
		"\u031e\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0322\3\2\2\2\u0321\u0319\3\2"+
		"\2\2\u0321\u031d\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0324\7P\2\2\u0324"+
		"\u0329\7\31\2\2\u0325\u0327\5x=\2\u0326\u0328\7\u0131\2\2\u0327\u0326"+
		"\3\2\2\2\u0327\u0328\3\2\2\2\u0328\u032a\3\2\2\2\u0329\u0325\3\2\2\2\u032a"+
		"\u032b\3\2\2\2\u032b\u0329\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u032d\3\2"+
		"\2\2\u032d\u032e\5\26\f\2\u032e\u0407\3\2\2\2\u032f\u0333\7c\2\2\u0330"+
		"\u0331\7\62\2\2\u0331\u0332\7\u00ce\2\2\u0332\u0334\7+\2\2\u0333\u0330"+
		"\3\2\2\2\u0333\u0334\3\2\2\2\u0334\u033a\3\2\2\2\u0335\u033b\7{\2\2\u0336"+
		"\u0338\7\6\2\2\u0337\u0339\7Y\2\2\u0338\u0337\3\2\2\2\u0338\u0339\3\2"+
		"\2\2\u0339\u033b\3\2\2\2\u033a\u0335\3\2\2\2\u033a\u0336\3\2\2\2\u033b"+
		"\u033c\3\2\2\2\u033c\u033d\7P\2\2\u033d\u033e\7,\2\2\u033e\u033f\7\u0099"+
		"\2\2\u033f\u0344\7\u00ff\2\2\u0340\u0342\5\u0174\u00bb\2\u0341\u0343\7"+
		"\u0131\2\2\u0342\u0341\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u0345\3\2\2\2"+
		"\u0344\u0340\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u0344\3\2\2\2\u0346\u0347"+
		"\3\2\2\2\u0347\u0348\3\2\2\2\u0348\u0349\5\26\f\2\u0349\u0407\3\2\2\2"+
		"\u034a\u034e\7c\2\2\u034b\u034c\7\62\2\2\u034c\u034d\7\u00ce\2\2\u034d"+
		"\u034f\7+\2\2\u034e\u034b\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0355\3\2"+
		"\2\2\u0350\u0356\7{\2\2\u0351\u0353\7\6\2\2\u0352\u0354\7Y\2\2\u0353\u0352"+
		"\3\2\2\2\u0353\u0354\3\2\2\2\u0354\u0356\3\2\2\2\u0355\u0350\3\2\2\2\u0355"+
		"\u0351\3\2\2\2\u0356\u0357\3\2\2\2\u0357\u0358\7P\2\2\u0358\u0359\7,\2"+
		"\2\u0359\u035e\7\u00e0\2\2\u035a\u035c\5x=\2\u035b\u035d\7\u0131\2\2\u035c"+
		"\u035b\3\2\2\2\u035c\u035d\3\2\2\2\u035d\u035f\3\2\2\2\u035e\u035a\3\2"+
		"\2\2\u035f\u0360\3\2\2\2\u0360\u035e\3\2\2\2\u0360\u0361\3\2\2\2\u0361"+
		"\u0362\3\2\2\2\u0362\u0363\5\26\f\2\u0363\u0407\3\2\2\2\u0364\u0368\7"+
		"c\2\2\u0365\u0366\7\62\2\2\u0366\u0367\7\u00ce\2\2\u0367\u0369\7+\2\2"+
		"\u0368\u0365\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u036f\3\2\2\2\u036a\u0370"+
		"\7(\2\2\u036b\u036d\7\6\2\2\u036c\u036e\7Y\2\2\u036d\u036c\3\2\2\2\u036d"+
		"\u036e\3\2\2\2\u036e\u0370\3\2\2\2\u036f\u036a\3\2\2\2\u036f\u036b\3\2"+
		"\2\2\u0370\u0371\3\2\2\2\u0371\u0374\7P\2\2\u0372\u0375\5*\26\2\u0373"+
		"\u0375\5,\27\2\u0374\u0372\3\2\2\2\u0374\u0373\3\2\2\2\u0375\u0376\3\2"+
		"\2\2\u0376\u0377\5\26\f\2\u0377\u0407\3\2\2\2\u0378\u037c\7c\2\2\u0379"+
		"\u037a\7\62\2\2\u037a\u037b\7\u00ce\2\2\u037b\u037d\7+\2\2\u037c\u0379"+
		"\3\2\2\2\u037c\u037d\3\2\2\2\u037d\u0383\3\2\2\2\u037e\u0384\7{\2\2\u037f"+
		"\u0381\7\6\2\2\u0380\u0382\7Y\2\2\u0381\u0380\3\2\2\2\u0381\u0382\3\2"+
		"\2\2\u0382\u0384\3\2\2\2\u0383\u037e\3\2\2\2\u0383\u037f\3\2\2\2\u0384"+
		"\u0385\3\2\2\2\u0385\u0386\7P\2\2\u0386\u038b\7\u00b9\2\2\u0387\u0389"+
		"\5x=\2\u0388\u038a\7\u0131\2\2\u0389\u0388\3\2\2\2\u0389\u038a\3\2\2\2"+
		"\u038a\u038c\3\2\2\2\u038b\u0387\3\2\2\2\u038c\u038d\3\2\2\2\u038d\u038b"+
		"\3\2\2\2\u038d\u038e\3\2\2\2\u038e\u038f\3\2\2\2\u038f\u0390\5\26\f\2"+
		"\u0390\u0407\3\2\2\2\u0391\u0395\7c\2\2\u0392\u0393\7\62\2\2\u0393\u0394"+
		"\7\u00ce\2\2\u0394\u0396\7+\2\2\u0395\u0392\3\2\2\2\u0395\u0396\3\2\2"+
		"\2\u0396\u03a4\3\2\2\2\u0397\u039d\7i\2\2\u0398\u039a\7z\2\2\u0399\u039b"+
		"\7\u0131\2\2\u039a\u0399\3\2\2\2\u039a\u039b\3\2\2\2\u039b\u039d\3\2\2"+
		"\2\u039c\u0397\3\2\2\2\u039c\u0398\3\2\2\2\u039d\u039e\3\2\2\2\u039e\u039c"+
		"\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u03a5\3\2\2\2\u03a0\u03a2\7\6\2\2\u03a1"+
		"\u03a3\7Y\2\2\u03a2\u03a1\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a5\3\2"+
		"\2\2\u03a4\u039c\3\2\2\2\u03a4\u03a0\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6"+
		"\u03a7\7P\2\2\u03a7\u03a8\7\u00ba\2\2\u03a8\u03ad\7\u00cd\2\2\u03a9\u03ab"+
		"\5x=\2\u03aa\u03ac\7\u0131\2\2\u03ab\u03aa\3\2\2\2\u03ab\u03ac\3\2\2\2"+
		"\u03ac\u03ae\3\2\2\2\u03ad\u03a9\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03ad"+
		"\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b2\5\26\f\2"+
		"\u03b2\u0407\3\2\2\2\u03b3\u03b7\7c\2\2\u03b4\u03b5\7\62\2\2\u03b5\u03b6"+
		"\7\u00ce\2\2\u03b6\u03b8\7+\2\2\u03b7\u03b4\3\2\2\2\u03b7\u03b8\3\2\2"+
		"\2\u03b8\u03c5\3\2\2\2\u03b9\u03bb\t\b\2\2\u03ba\u03bc\7\u0131\2\2\u03bb"+
		"\u03ba\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc\u03be\3\2\2\2\u03bd\u03b9\3\2"+
		"\2\2\u03be\u03bf\3\2\2\2\u03bf\u03bd\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0"+
		"\u03c6\3\2\2\2\u03c1\u03c3\7\6\2\2\u03c2\u03c4\7Y\2\2\u03c3\u03c2\3\2"+
		"\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03c6\3\2\2\2\u03c5\u03bd\3\2\2\2\u03c5"+
		"\u03c1\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7\u03c8\7P\2\2\u03c8\u03cd\7f\2"+
		"\2\u03c9\u03cb\5x=\2\u03ca\u03cc\7\u0131\2\2\u03cb\u03ca\3\2\2\2\u03cb"+
		"\u03cc\3\2\2\2\u03cc\u03ce\3\2\2\2\u03cd\u03c9\3\2\2\2\u03ce\u03cf\3\2"+
		"\2\2\u03cf\u03cd\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1"+
		"\u03d2\5\26\f\2\u03d2\u0407\3\2\2\2\u03d3\u03d7\7c\2\2\u03d4\u03d5\7\62"+
		"\2\2\u03d5\u03d6\7\u00ce\2\2\u03d6\u03d8\7+\2\2\u03d7\u03d4\3\2\2\2\u03d7"+
		"\u03d8\3\2\2\2\u03d8\u03de\3\2\2\2\u03d9\u03df\7\27\2\2\u03da\u03dc\7"+
		"\6\2\2\u03db\u03dd\7Y\2\2\u03dc\u03db\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd"+
		"\u03df\3\2\2\2\u03de\u03d9\3\2\2\2\u03de\u03da\3\2\2\2\u03df\u03e0\3\2"+
		"\2\2\u03e0\u03e1\7P\2\2\u03e1\u03e6\7\u00eb\2\2\u03e2\u03e4\5x=\2\u03e3"+
		"\u03e5\7\u0131\2\2\u03e4\u03e3\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5\u03e7"+
		"\3\2\2\2\u03e6\u03e2\3\2\2\2\u03e7\u03e8\3\2\2\2\u03e8\u03e6\3\2\2\2\u03e8"+
		"\u03e9\3\2\2\2\u03e9\u03ea\3\2\2\2\u03ea\u03eb\5\26\f\2\u03eb\u0407\3"+
		"\2\2\2\u03ec\u03f0\7c\2\2\u03ed\u03ee\7\u0083\2\2\u03ee\u03ef\7\u00ce"+
		"\2\2\u03ef\u03f1\7+\2\2\u03f0\u03ed\3\2\2\2\u03f0\u03f1\3\2\2\2\u03f1"+
		"\u03f6\3\2\2\2\u03f2\u03f4\5x=\2\u03f3\u03f5\7\u0131\2\2\u03f4\u03f3\3"+
		"\2\2\2\u03f4\u03f5\3\2\2\2\u03f5\u03f7\3\2\2\2\u03f6\u03f2\3\2\2\2\u03f7"+
		"\u03f8\3\2\2\2\u03f8\u03f6\3\2\2\2\u03f8\u03f9\3\2\2\2\u03f9\u03fa\3\2"+
		"\2\2\u03fa\u03ff\7\60\2\2\u03fb\u03fd\5x=\2\u03fc\u03fe\7\u0131\2\2\u03fd"+
		"\u03fc\3\2\2\2\u03fd\u03fe\3\2\2\2\u03fe\u0400\3\2\2\2\u03ff\u03fb\3\2"+
		"\2\2\u0400\u0401\3\2\2\2\u0401\u03ff\3\2\2\2\u0401\u0402\3\2\2\2\u0402"+
		"\u0404\3\2\2\2\u0403\u0405\t\t\2\2\u0404\u0403\3\2\2\2\u0404\u0405\3\2"+
		"\2\2\u0405\u0407\3\2\2\2\u0406\u028b\3\2\2\2\u0406\u02b2\3\2\2\2\u0406"+
		"\u02e7\3\2\2\2\u0406\u0312\3\2\2\2\u0406\u032f\3\2\2\2\u0406\u034a\3\2"+
		"\2\2\u0406\u0364\3\2\2\2\u0406\u0378\3\2\2\2\u0406\u0391\3\2\2\2\u0406"+
		"\u03b3\3\2\2\2\u0406\u03d3\3\2\2\2\u0406\u03ec\3\2\2\2\u0407\25\3\2\2"+
		"\2\u0408\u0411\7\60\2\2\u0409\u040b\7\63\2\2\u040a\u0409\3\2\2\2\u040a"+
		"\u040b\3\2\2\2\u040b\u040c\3\2\2\2\u040c\u0412\5x=\2\u040d\u040f\7\u00d6"+
		"\2\2\u040e\u0410\7\u0131\2\2\u040f\u040e\3\2\2\2\u040f\u0410\3\2\2\2\u0410"+
		"\u0412\3\2\2\2\u0411\u040a\3\2\2\2\u0411\u040d\3\2\2\2\u0412\u0413\3\2"+
		"\2\2\u0413\u0411\3\2\2\2\u0413\u0414\3\2\2\2\u0414\u0416\3\2\2\2\u0415"+
		"\u0417\t\t\2\2\u0416\u0415\3\2\2\2\u0416\u0417\3\2\2\2\u0417\27\3\2\2"+
		"\2\u0418\u0422\7\62\2\2\u0419\u041b\t\4\2\2\u041a\u0419\3\2\2\2\u041b"+
		"\u041c\3\2\2\2\u041c\u041a\3\2\2\2\u041c\u041d\3\2\2\2\u041d\u0423\3\2"+
		"\2\2\u041e\u0420\7\6\2\2\u041f\u0421\7Y\2\2\u0420\u041f\3\2\2\2\u0420"+
		"\u0421\3\2\2\2\u0421\u0423\3\2\2\2\u0422\u041a\3\2\2\2\u0422\u041e\3\2"+
		"\2\2\u0423\u0424\3\2\2\2\u0424\u043c\7P\2\2\u0425\u0427\7p\2\2\u0426\u0425"+
		"\3\2\2\2\u0426\u0427\3\2\2\2\u0427\u042c\3\2\2\2\u0428\u042a\5\u0174\u00bb"+
		"\2\u0429\u042b\7\u0131\2\2\u042a\u0429\3\2\2\2\u042a\u042b\3\2\2\2\u042b"+
		"\u042d\3\2\2\2\u042c\u0428\3\2\2\2\u042d\u042e\3\2\2\2\u042e\u042c\3\2"+
		"\2\2\u042e\u042f\3\2\2\2\u042f\u043d\3\2\2\2\u0430\u0431\7\6\2\2\u0431"+
		"\u0432\7\u00ec\2\2\u0432\u0433\79\2\2\u0433\u0438\7f\2\2\u0434\u0436\5"+
		"x=\2\u0435\u0437\7\u0131\2\2\u0436\u0435\3\2\2\2\u0436\u0437\3\2\2\2\u0437"+
		"\u0439\3\2\2\2\u0438\u0434\3\2\2\2\u0439\u043a\3\2\2\2\u043a\u0438\3\2"+
		"\2\2\u043a\u043b\3\2\2\2\u043b\u043d\3\2\2\2\u043c\u0426\3\2\2\2\u043c"+
		"\u0430\3\2\2\2\u043d\u043e\3\2\2\2\u043e\u043f\5\32\16\2\u043f\u055e\3"+
		"\2\2\2\u0440\u045a\7\62\2\2\u0441\u0446\t\5\2\2\u0442\u0444\5x=\2\u0443"+
		"\u0445\7\u0131\2\2\u0444\u0443\3\2\2\2\u0444\u0445\3\2\2\2\u0445\u0447"+
		"\3\2\2\2\u0446\u0442\3\2\2\2\u0447\u0448\3\2\2\2\u0448\u0446\3\2\2\2\u0448"+
		"\u0449\3\2\2\2\u0449\u044b\3\2\2\2\u044a\u0441\3\2\2\2\u044b\u044c\3\2"+
		"\2\2\u044c\u044a\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u045b\3\2\2\2\u044e"+
		"\u0450\7\6\2\2\u044f\u0451\7Y\2\2\u0450\u044f\3\2\2\2\u0450\u0451\3\2"+
		"\2\2\u0451\u0456\3\2\2\2\u0452\u0454\5x=\2\u0453\u0455\7\u0131\2\2\u0454"+
		"\u0453\3\2\2\2\u0454\u0455\3\2\2\2\u0455\u0457\3\2\2\2\u0456\u0452\3\2"+
		"\2\2\u0457\u0458\3\2\2\2\u0458\u0456\3\2\2\2\u0458\u0459\3\2\2\2\u0459"+
		"\u045b\3\2\2\2\u045a\u044a\3\2\2\2\u045a\u044e\3\2\2\2\u045b\u045c\3\2"+
		"\2\2\u045c\u0464\7P\2\2\u045d\u045f\7p\2\2\u045e\u045d\3\2\2\2\u045e\u045f"+
		"\3\2\2\2\u045f\u0460\3\2\2\2\u0460\u0462\5\u0174\u00bb\2\u0461\u0463\7"+
		"\u0131\2\2\u0462\u0461\3\2\2\2\u0462\u0463\3\2\2\2\u0463\u0465\3\2\2\2"+
		"\u0464\u045e\3\2\2\2\u0465\u0466\3\2\2\2\u0466\u0464\3\2\2\2\u0466\u0467"+
		"\3\2\2\2\u0467\u0468\3\2\2\2\u0468\u0469\5\32\16\2\u0469\u055e\3\2\2\2"+
		"\u046a\u0477\7\62\2\2\u046b\u046d\t\6\2\2\u046c\u046e\7\u0131\2\2\u046d"+
		"\u046c\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u0470\3\2\2\2\u046f\u046b\3\2"+
		"\2\2\u0470\u0471\3\2\2\2\u0471\u046f\3\2\2\2\u0471\u0472\3\2\2\2\u0472"+
		"\u0478\3\2\2\2\u0473\u0475\7\6\2\2\u0474\u0476\7Y\2\2\u0475\u0474\3\2"+
		"\2\2\u0475\u0476\3\2\2\2\u0476\u0478\3\2\2\2\u0477\u046f\3\2\2\2\u0477"+
		"\u0473\3\2\2\2\u0478\u0479\3\2\2\2\u0479\u048f\7P\2\2\u047a\u047b\7g\2"+
		"\2\u047b\u047d\5x=\2\u047c\u047e\7\u0131\2\2\u047d\u047c\3\2\2\2\u047d"+
		"\u047e\3\2\2\2\u047e\u0480\3\2\2\2\u047f\u047a\3\2\2\2\u0480\u0481\3\2"+
		"\2\2\u0481\u047f\3\2\2\2\u0481\u0482\3\2\2\2\u0482\u0490\3\2\2\2\u0483"+
		"\u0484\7\6\2\2\u0484\u0485\7h\2\2\u0485\u0486\79\2\2\u0486\u048b\7f\2"+
		"\2\u0487\u0489\5x=\2\u0488\u048a\7\u0131\2\2\u0489\u0488\3\2\2\2\u0489"+
		"\u048a\3\2\2\2\u048a\u048c\3\2\2\2\u048b\u0487\3\2\2\2\u048c\u048d\3\2"+
		"\2\2\u048d\u048b\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u0490\3\2\2\2\u048f"+
		"\u047f\3\2\2\2\u048f\u0483\3\2\2\2\u0490\u0491\3\2\2\2\u0491\u0492\5\32"+
		"\16\2\u0492\u055e\3\2\2\2\u0493\u04a0\7\62\2\2\u0494\u0496\t\7\2\2\u0495"+
		"\u0497\7\u0131\2\2\u0496\u0495\3\2\2\2\u0496\u0497\3\2\2\2\u0497\u0499"+
		"\3\2\2\2\u0498\u0494\3\2\2\2\u0499\u049a\3\2\2\2\u049a\u0498\3\2\2\2\u049a"+
		"\u049b\3\2\2\2\u049b\u04a1\3\2\2\2\u049c\u049e\7\6\2\2\u049d\u049f\7Y"+
		"\2\2\u049e\u049d\3\2\2\2\u049e\u049f\3\2\2\2\u049f\u04a1\3\2\2\2\u04a0"+
		"\u0498\3\2\2\2\u04a0\u049c\3\2\2\2\u04a1\u04a2\3\2\2\2\u04a2\u04a3\7P"+
		"\2\2\u04a3\u04a8\7\31\2\2\u04a4\u04a6\5x=\2\u04a5\u04a7\7\u0131\2\2\u04a6"+
		"\u04a5\3\2\2\2\u04a6\u04a7\3\2\2\2\u04a7\u04a9\3\2\2\2\u04a8\u04a4\3\2"+
		"\2\2\u04a9\u04aa\3\2\2\2\u04aa\u04a8\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab"+
		"\u04ac\3\2\2\2\u04ac\u04ad\5\32\16\2\u04ad\u055e\3\2\2\2\u04ae\u04b4\7"+
		"\62\2\2\u04af\u04b5\7{\2\2\u04b0\u04b2\7\6\2\2\u04b1\u04b3\7Y\2\2\u04b2"+
		"\u04b1\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3\u04b5\3\2\2\2\u04b4\u04af\3\2"+
		"\2\2\u04b4\u04b0\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u04b7\7P\2\2\u04b7"+
		"\u04b8\7,\2\2\u04b8\u04b9\7\u0099\2\2\u04b9\u04be\7\u00ff\2\2\u04ba\u04bc"+
		"\5x=\2\u04bb\u04bd\7\u0131\2\2\u04bc\u04bb\3\2\2\2\u04bc\u04bd\3\2\2\2"+
		"\u04bd\u04bf\3\2\2\2\u04be\u04ba\3\2\2\2\u04bf\u04c0\3\2\2\2\u04c0\u04be"+
		"\3\2\2\2\u04c0\u04c1\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2\u04c3\5\32\16\2"+
		"\u04c3\u055e\3\2\2\2\u04c4\u04ca\7\62\2\2\u04c5\u04cb\7{\2\2\u04c6\u04c8"+
		"\7\6\2\2\u04c7\u04c9\7Y\2\2\u04c8\u04c7\3\2\2\2\u04c8\u04c9\3\2\2\2\u04c9"+
		"\u04cb\3\2\2\2\u04ca\u04c5\3\2\2\2\u04ca\u04c6\3\2\2\2\u04cb\u04cc\3\2"+
		"\2\2\u04cc\u04cd\7P\2\2\u04cd\u04ce\7,\2\2\u04ce\u04d3\7\u00e0\2\2\u04cf"+
		"\u04d1\5x=\2\u04d0\u04d2\7\u0131\2\2\u04d1\u04d0\3\2\2\2\u04d1\u04d2\3"+
		"\2\2\2\u04d2\u04d4\3\2\2\2\u04d3\u04cf\3\2\2\2\u04d4\u04d5\3\2\2\2\u04d5"+
		"\u04d3\3\2\2\2\u04d5\u04d6\3\2\2\2\u04d6\u04d7\3\2\2\2\u04d7\u04d8\5\32"+
		"\16\2\u04d8\u055e\3\2\2\2\u04d9\u04df\7\62\2\2\u04da\u04e0\7(\2\2\u04db"+
		"\u04dd\7\6\2\2\u04dc\u04de\7Y\2\2\u04dd\u04dc\3\2\2\2\u04dd\u04de\3\2"+
		"\2\2\u04de\u04e0\3\2\2\2\u04df\u04da\3\2\2\2\u04df\u04db\3\2\2\2\u04e0"+
		"\u04e1\3\2\2\2\u04e1\u04e4\7P\2\2\u04e2\u04e5\5*\26\2\u04e3\u04e5\5,\27"+
		"\2\u04e4\u04e2\3\2\2\2\u04e4\u04e3\3\2\2\2\u04e5\u04e6\3\2\2\2\u04e6\u04e7"+
		"\5\32\16\2\u04e7\u055e\3\2\2\2\u04e8\u04ee\7\62\2\2\u04e9\u04ef\7{\2\2"+
		"\u04ea\u04ec\7\6\2\2\u04eb\u04ed\7Y\2\2\u04ec\u04eb\3\2\2\2\u04ec\u04ed"+
		"\3\2\2\2\u04ed\u04ef\3\2\2\2\u04ee\u04e9\3\2\2\2\u04ee\u04ea\3\2\2\2\u04ef"+
		"\u04f0\3\2\2\2\u04f0\u04f1\7P\2\2\u04f1\u04f6\7\u00b9\2\2\u04f2\u04f4"+
		"\5x=\2\u04f3\u04f5\7\u0131\2\2\u04f4\u04f3\3\2\2\2\u04f4\u04f5\3\2\2\2"+
		"\u04f5\u04f7\3\2\2\2\u04f6\u04f2\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8\u04f6"+
		"\3\2\2\2\u04f8\u04f9\3\2\2\2\u04f9\u04fa\3\2\2\2\u04fa\u04fb\5\32\16\2"+
		"\u04fb\u055e\3\2\2\2\u04fc\u0509\7\62\2\2\u04fd\u04ff\t\n\2\2\u04fe\u0500"+
		"\7\u0131\2\2\u04ff\u04fe\3\2\2\2\u04ff\u0500\3\2\2\2\u0500\u0502\3\2\2"+
		"\2\u0501\u04fd\3\2\2\2\u0502\u0503\3\2\2\2\u0503\u0501\3\2\2\2\u0503\u0504"+
		"\3\2\2\2\u0504\u050a\3\2\2\2\u0505\u0507\7\6\2\2\u0506\u0508\7Y\2\2\u0507"+
		"\u0506\3\2\2\2\u0507\u0508\3\2\2\2\u0508\u050a\3\2\2\2\u0509\u0501\3\2"+
		"\2\2\u0509\u0505\3\2\2\2\u050a\u050b\3\2\2\2\u050b\u050c\7P\2\2\u050c"+
		"\u050d\7\u00ba\2\2\u050d\u0512\7\u00cd\2\2\u050e\u0510\5x=\2\u050f\u0511"+
		"\7\u0131\2\2\u0510\u050f\3\2\2\2\u0510\u0511\3\2\2\2\u0511\u0513\3\2\2"+
		"\2\u0512\u050e\3\2\2\2\u0513\u0514\3\2\2\2\u0514\u0512\3\2\2\2\u0514\u0515"+
		"\3\2\2\2\u0515\u0516\3\2\2\2\u0516\u0517\5\32\16\2\u0517\u055e\3\2\2\2"+
		"\u0518\u0525\7\62\2\2\u0519\u051b\t\b\2\2\u051a\u051c\7\u0131\2\2\u051b"+
		"\u051a\3\2\2\2\u051b\u051c\3\2\2\2\u051c\u051e\3\2\2\2\u051d\u0519\3\2"+
		"\2\2\u051e\u051f\3\2\2\2\u051f\u051d\3\2\2\2\u051f\u0520\3\2\2\2\u0520"+
		"\u0526\3\2\2\2\u0521\u0523\7\6\2\2\u0522\u0524\7Y\2\2\u0523\u0522\3\2"+
		"\2\2\u0523\u0524\3\2\2\2\u0524\u0526\3\2\2\2\u0525\u051d\3\2\2\2\u0525"+
		"\u0521\3\2\2\2\u0526\u0527\3\2\2\2\u0527\u0528\7P\2\2\u0528\u052d\7f\2"+
		"\2\u0529\u052b\5x=\2\u052a\u052c\7\u0131\2\2\u052b\u052a\3\2\2\2\u052b"+
		"\u052c\3\2\2\2\u052c\u052e\3\2\2\2\u052d\u0529\3\2\2\2\u052e\u052f\3\2"+
		"\2\2\u052f\u052d\3\2\2\2\u052f\u0530\3\2\2\2\u0530\u0531\3\2\2\2\u0531"+
		"\u0532\5\32\16\2\u0532\u055e\3\2\2\2\u0533\u0539\7\62\2\2\u0534\u053a"+
		"\7\27\2\2\u0535\u0537\7\6\2\2\u0536\u0538\7Y\2\2\u0537\u0536\3\2\2\2\u0537"+
		"\u0538\3\2\2\2\u0538\u053a\3\2\2\2\u0539\u0534\3\2\2\2\u0539\u0535\3\2"+
		"\2\2\u053a\u053b\3\2\2\2\u053b\u053c\7P\2\2\u053c\u0541\7\u00eb\2\2\u053d"+
		"\u053f\5x=\2\u053e\u0540\7\u0131\2\2\u053f\u053e\3\2\2\2\u053f\u0540\3"+
		"\2\2\2\u0540\u0542\3\2\2\2\u0541\u053d\3\2\2\2\u0542\u0543\3\2\2\2\u0543"+
		"\u0541\3\2\2\2\u0543\u0544\3\2\2\2\u0544\u0545\3\2\2\2\u0545\u0546\5\32"+
		"\16\2\u0546\u054b\7\62\2\2\u0547\u0549\5x=\2\u0548\u054a\7\u0131\2\2\u0549"+
		"\u0548\3\2\2\2\u0549\u054a\3\2\2\2\u054a\u054c\3\2\2\2\u054b\u0547\3\2"+
		"\2\2\u054c\u054d\3\2\2\2\u054d\u054b\3\2\2\2\u054d\u054e\3\2\2\2\u054e"+
		"\u054f\3\2\2\2\u054f\u0554\7\u00f3\2\2\u0550\u0552\5x=\2\u0551\u0553\7"+
		"\u0131\2\2\u0552\u0551\3\2\2\2\u0552\u0553\3\2\2\2\u0553\u0555\3\2\2\2"+
		"\u0554\u0550\3\2\2\2\u0555\u0556\3\2\2\2\u0556\u0554\3\2\2\2\u0556\u0557"+
		"\3\2\2\2\u0557\u055b\3\2\2\2\u0558\u0559\7\u0081\2\2\u0559\u055a\7\u0083"+
		"\2\2\u055a\u055c\7\u00ce\2\2\u055b\u0558\3\2\2\2\u055b\u055c\3\2\2\2\u055c"+
		"\u055e\3\2\2\2\u055d\u0418\3\2\2\2\u055d\u0440\3\2\2\2\u055d\u046a\3\2"+
		"\2\2\u055d\u0493\3\2\2\2\u055d\u04ae\3\2\2\2\u055d\u04c4\3\2\2\2\u055d"+
		"\u04d9\3\2\2\2\u055d\u04e8\3\2\2\2\u055d\u04fc\3\2\2\2\u055d\u0518\3\2"+
		"\2\2\u055d\u0533\3\2\2\2\u055e\31\3\2\2\2\u055f\u056a\7\u00f3\2\2\u0560"+
		"\u0562\7\63\2\2\u0561\u0560\3\2\2\2\u0561\u0562\3\2\2\2\u0562\u0565\3"+
		"\2\2\2\u0563\u0566\5x=\2\u0564\u0566\7\u00d6\2\2\u0565\u0563\3\2\2\2\u0565"+
		"\u0564\3\2\2\2\u0566\u0568\3\2\2\2\u0567\u0569\7\u0131\2\2\u0568\u0567"+
		"\3\2\2\2\u0568\u0569\3\2\2\2\u0569\u056b\3\2\2\2\u056a\u0561\3\2\2\2\u056b"+
		"\u056c\3\2\2\2\u056c\u056a\3\2\2\2\u056c\u056d\3\2\2\2\u056d\u0571\3\2"+
		"\2\2\u056e\u056f\7\u0081\2\2\u056f\u0570\7\62\2\2\u0570\u0572\7\u00ce"+
		"\2\2\u0571\u056e\3\2\2\2\u0571\u0572\3\2\2\2\u0572\33\3\2\2\2\u0573\u0574"+
		"\7\u0090\2\2\u0574\u05eb\7P\2\2\u0575\u0576\7\3\2\2\u0576\u0577\5\u0174"+
		"\u00bb\2\u0577\u057e\7\u0138\2\2\u0578\u057a\5\u008aF\2\u0579\u057b\7"+
		"\u0131\2\2\u057a\u0579\3\2\2\2\u057a\u057b\3\2\2\2\u057b\u057d\3\2\2\2"+
		"\u057c\u0578\3\2\2\2\u057d\u0580\3\2\2\2\u057e\u057c\3\2\2\2\u057e\u057f"+
		"\3\2\2\2\u057f\u0581\3\2\2\2\u0580\u057e\3\2\2\2\u0581\u0582\7\u0139\2"+
		"\2\u0582\u05ec\3\2\2\2\u0583\u0584\7\20\2\2\u0584\u0585\7\u0138\2\2\u0585"+
		"\u0586\5\u008aF\2\u0586\u0587\7\5\2\2\u0587\u0588\5\u008aF\2\u0588\u0589"+
		"\7\u0139\2\2\u0589\u05ec\3\2\2\2\u058a\u058b\7\22\2\2\u058b\u05ec\5\u0174"+
		"\u00bb\2\u058c\u058d\7\u008f\2\2\u058d\u05ec\5\u0174\u00bb\2\u058e\u058f"+
		"\7\24\2\2\u058f\u0590\5\u0174\u00bb\2\u0590\u0591\7P\2\2\u0591\u0592\5"+
		"\u0174\u00bb\2\u0592\u05ec\3\2\2\2\u0593\u0594\7\26\2\2\u0594\u05ec\5"+
		"\u0174\u00bb\2\u0595\u0596\7\31\2\2\u0596\u05ec\5\u0174\u00bb\2\u0597"+
		"\u0598\7!\2\2\u0598\u05ec\5\u0174\u00bb\2\u0599\u059a\7)\2\2\u059a\u05ec"+
		"\5\u0174\u00bb\2\u059b\u059c\7,\2\2\u059c\u059d\7\u0099\2\2\u059d\u059e"+
		"\7\u00ff\2\2\u059e\u05ec\5\u0174\u00bb\2\u059f\u05a0\7,\2\2\u05a0\u05a1"+
		"\7p\2\2\u05a1\u05ec\5\u0174\u00bb\2\u05a2\u05ec\5*\26\2\u05a3\u05a4\7"+
		"\u00af\2\2\u05a4\u05ec\5\u0174\u00bb\2\u05a5\u05a6\7\u00ba\2\2\u05a6\u05a7"+
		"\7\u00cd\2\2\u05a7\u05ec\5x=\2\u05a8\u05a9\7S\2\2\u05a9\u05aa\5\u0174"+
		"\u00bb\2\u05aa\u05ab\7\u0138\2\2\u05ab\u05ac\5\u008aF\2\u05ac\u05ad\7"+
		"\u0131\2\2\u05ad\u05ae\5\u008aF\2\u05ae\u05af\7\u0139\2\2\u05af\u05ec"+
		"\3\2\2\2\u05b0\u05b1\7S\2\2\u05b1\u05b2\7\u0089\2\2\u05b2\u05b3\5\u0174"+
		"\u00bb\2\u05b3\u05b4\7|\2\2\u05b4\u05b5\5x=\2\u05b5\u05ec\3\2\2\2\u05b6"+
		"\u05b7\7S\2\2\u05b7\u05b8\7\u00a7\2\2\u05b8\u05b9\5\u0174\u00bb\2\u05b9"+
		"\u05ba\7|\2\2\u05ba\u05bb\5x=\2\u05bb\u05ec\3\2\2\2\u05bc\u05be\7[\2\2"+
		"\u05bd\u05bc\3\2\2\2\u05bd\u05be\3\2\2\2\u05be\u05bf\3\2\2\2\u05bf\u05c0"+
		"\7\u00b9\2\2\u05c0\u05ec\5\u0174\u00bb\2\u05c1\u05c2\7\\\2\2\u05c2\u05ec"+
		"\5\u0174\u00bb\2\u05c3\u05c4\7e\2\2\u05c4\u05c5\5\u0174\u00bb\2\u05c5"+
		"\u05c6\7P\2\2\u05c6\u05c7\5\u0174\u00bb\2\u05c7\u05ec\3\2\2\2\u05c8\u05c9"+
		"\7f\2\2\u05c9\u05ec\5\u0174\u00bb\2\u05ca\u05cb\7g\2\2\u05cb\u05ec\5\u0174"+
		"\u00bb\2\u05cc\u05cd\7\u00e0\2\2\u05cd\u05ec\5\u0174\u00bb\2\u05ce\u05cf"+
		"\7p\2\2\u05cf\u05ec\5\u0174\u00bb\2\u05d0\u05d1\7\u00eb\2\2\u05d1\u05ec"+
		"\5\u0174\u00bb\2\u05d2\u05d3\7\u0120\2\2\u05d3\u05d4\7\u00dd\2\2\u05d4"+
		"\u05d5\7\u0093\2\2\u05d5\u05ec\5\u0174\u00bb\2\u05d6\u05d7\7\u0120\2\2"+
		"\u05d7\u05d8\7\u00dd\2\2\u05d8\u05d9\7\u009e\2\2\u05d9\u05ec\5\u0174\u00bb"+
		"\2\u05da\u05db\7\u0120\2\2\u05db\u05dc\7\u00dd\2\2\u05dc\u05dd\7\u00d1"+
		"\2\2\u05dd\u05ec\5\u0174\u00bb\2\u05de\u05df\7\u0120\2\2\u05df\u05e0\7"+
		"\u00dd\2\2\u05e0\u05e1\7\u00ed\2\2\u05e1\u05ec\5\u0174\u00bb\2\u05e2\u05e3"+
		"\7u\2\2\u05e3\u05e4\5\u0174\u00bb\2\u05e4\u05e5\7P\2\2\u05e5\u05e6\5\u0174"+
		"\u00bb\2\u05e6\u05ec\3\2\2\2\u05e7\u05e8\7\u00f4\2\2\u05e8\u05ec\5\u0174"+
		"\u00bb\2\u05e9\u05ea\7~\2\2\u05ea\u05ec\5\u0174\u00bb\2\u05eb\u0575\3"+
		"\2\2\2\u05eb\u0583\3\2\2\2\u05eb\u058a\3\2\2\2\u05eb\u058c\3\2\2\2\u05eb"+
		"\u058e\3\2\2\2\u05eb\u0593\3\2\2\2\u05eb\u0595\3\2\2\2\u05eb\u0597\3\2"+
		"\2\2\u05eb\u0599\3\2\2\2\u05eb\u059b\3\2\2\2\u05eb\u059f\3\2\2\2\u05eb"+
		"\u05a2\3\2\2\2\u05eb\u05a3\3\2\2\2\u05eb\u05a5\3\2\2\2\u05eb\u05a8\3\2"+
		"\2\2\u05eb\u05b0\3\2\2\2\u05eb\u05b6\3\2\2\2\u05eb\u05bd\3\2\2\2\u05eb"+
		"\u05c1\3\2\2\2\u05eb\u05c3\3\2\2\2\u05eb\u05c8\3\2\2\2\u05eb\u05ca\3\2"+
		"\2\2\u05eb\u05cc\3\2\2\2\u05eb\u05ce\3\2\2\2\u05eb\u05d0\3\2\2\2\u05eb"+
		"\u05d2\3\2\2\2\u05eb\u05d6\3\2\2\2\u05eb\u05da\3\2\2\2\u05eb\u05de\3\2"+
		"\2\2\u05eb\u05e2\3\2\2\2\u05eb\u05e7\3\2\2\2\u05eb\u05e9\3\2\2\2\u05ec"+
		"\u05ed\3\2\2\2\u05ed\u05ee\7C\2\2\u05ee\u05ef\7\u014c\2\2\u05ef\35\3\2"+
		"\2\2\u05f0\u05f3\7\27\2\2\u05f1\u05f2\7T\2\2\u05f2\u05f4\7`\2\2\u05f3"+
		"\u05f1\3\2\2\2\u05f3\u05f4\3\2\2\2\u05f4\u05f5\3\2\2\2\u05f5\u05f6\7."+
		"\2\2\u05f6\u05f7\5\u0174\u00bb\2\u05f7\u0609\7\u0138\2\2\u05f8\u05fa\5"+
		"(\25\2\u05f9\u05f8\3\2\2\2\u05f9\u05fa\3\2\2\2\u05fa\u05fc\3\2\2\2\u05fb"+
		"\u05fd\5x=\2\u05fc\u05fb\3\2\2\2\u05fc\u05fd\3\2\2\2\u05fd\u05fe\3\2\2"+
		"\2\u05fe\u0602\5\u008aF\2\u05ff\u0603\7\32\2\2\u0600\u0601\7\u012e\2\2"+
		"\u0601\u0603\5\u00dan\2\u0602\u05ff\3\2\2\2\u0602\u0600\3\2\2\2\u0602"+
		"\u0603\3\2\2\2\u0603\u0605\3\2\2\2\u0604\u0606\7\u0131\2\2\u0605\u0604"+
		"\3\2\2\2\u0605\u0606\3\2\2\2\u0606\u0608\3\2\2\2\u0607\u05f9\3\2\2\2\u0608"+
		"\u060b\3\2\2\2\u0609\u0607\3\2\2\2\u0609\u060a\3\2\2\2\u060a\u060c\3\2"+
		"\2\2\u060b\u0609\3\2\2\2\u060c\u061d\7\u0139\2\2\u060d\u060e\7b\2\2\u060e"+
		"\u061e\5\u008aF\2\u060f\u0610\7b\2\2\u0610\u0611\7p\2\2\u0611\u0617\7"+
		"\u0138\2\2\u0612\u0613\5x=\2\u0613\u0615\5\u008aF\2\u0614\u0616\7\u0131"+
		"\2\2\u0615\u0614\3\2\2\2\u0615\u0616\3\2\2\2\u0616\u0618\3\2\2\2\u0617"+
		"\u0612\3\2\2\2\u0618\u0619\3\2\2\2\u0619\u0617\3\2\2\2\u0619\u061a\3\2"+
		"\2\2\u061a\u061b\3\2\2\2\u061b\u061c\7\u0139\2\2\u061c\u061e\3\2\2\2\u061d"+
		"\u060d\3\2\2\2\u061d\u060f\3\2\2\2\u061d\u061e\3\2\2\2\u061e\u0654\3\2"+
		"\2\2\u061f\u0620\7\u00b9\2\2\u0620\u0655\5x=\2\u0621\u0655\7\u00fe\2\2"+
		"\u0622\u0655\78\2\2\u0623\u0655\7\u00e4\2\2\u0624\u0655\7\u00fc\2\2\u0625"+
		"\u0626\7\u0088\2\2\u0626\u0627\7P\2\2\u0627\u0628\7M\2\2\u0628\u0655\7"+
		"\u00b2\2\2\u0629\u062a\7b\2\2\u062a\u062b\7M\2\2\u062b\u062c\7P\2\2\u062c"+
		"\u062d\7M\2\2\u062d\u0655\7\u00b2\2\2\u062e\u0655\7n\2\2\u062f\u0631\7"+
		"\u00a5\2\2\u0630\u062f\3\2\2\2\u0630\u0631\3\2\2\2\u0631\u0632\3\2\2\2"+
		"\u0632\u0633\7\u00df\2\2\u0633\u0655\7B\2\2\u0634\u0636\7\u00a5\2\2\u0635"+
		"\u0634\3\2\2\2\u0635\u0636\3\2\2\2\u0636\u0637\3\2\2\2\u0637\u0638\7\u00df"+
		"\2\2\u0638\u0655\7\u009d\2\2\u0639\u063a\7\u0094\2\2\u063a\u0655\7\u0147"+
		"\2\2\u063b\u063c\7^\2\2\u063c\u0655\7\u0147\2\2\u063d\u063e\7\u00e1\2"+
		"\2\u063e\u0645\5x=\2\u063f\u0640\7\u00f3\2\2\u0640\u0646\5x=\2\u0641\u0642"+
		"\7\u012e\2\2\u0642\u0646\5x=\2\u0643\u0644\7\60\2\2\u0644\u0646\7\u0097"+
		"\2\2\u0645\u063f\3\2\2\2\u0645\u0641\3\2\2\2\u0645\u0643\3\2\2\2\u0646"+
		"\u064b\3\2\2\2\u0647\u0648\7\u0131\2\2\u0648\u064a\5x=\2\u0649\u0647\3"+
		"\2\2\2\u064a\u064d\3\2\2\2\u064b\u0649\3\2\2\2\u064b\u064c\3\2\2\2\u064c"+
		"\u0655\3\2\2\2\u064d\u064b\3\2\2\2\u064e\u064f\7\5\2\2\u064f\u0655\5 "+
		"\21\2\u0650\u0651\7\5\2\2\u0651\u0652\7\u014c\2\2\u0652\u0653\7\u0131"+
		"\2\2\u0653\u0655\7\u014c\2\2\u0654\u061f\3\2\2\2\u0654\u0621\3\2\2\2\u0654"+
		"\u0622\3\2\2\2\u0654\u0623\3\2\2\2\u0654\u0624\3\2\2\2\u0654\u0625\3\2"+
		"\2\2\u0654\u0629\3\2\2\2\u0654\u062e\3\2\2\2\u0654\u0630\3\2\2\2\u0654"+
		"\u0635\3\2\2\2\u0654\u0639\3\2\2\2\u0654\u063b\3\2\2\2\u0654\u063d\3\2"+
		"\2\2\u0654\u064e\3\2\2\2\u0654\u0650\3\2\2\2\u0655\u0656\3\2\2\2\u0656"+
		"\u0654\3\2\2\2\u0656\u0657\3\2\2\2\u0657\u0664\3\2\2\2\u0658\u0659\7\u0081"+
		"\2\2\u0659\u065e\7\u0138\2\2\u065a\u065c\5&\24\2\u065b\u065d\7\u0131\2"+
		"\2\u065c\u065b\3\2\2\2\u065c\u065d\3\2\2\2\u065d\u065f\3\2\2\2\u065e\u065a"+
		"\3\2\2\2\u065f\u0660\3\2\2\2\u0660\u065e\3\2\2\2\u0660\u0661\3\2\2\2\u0661"+
		"\u0662\3\2\2\2\u0662\u0663\7\u0139\2\2\u0663\u0665\3\2\2\2\u0664\u0658"+
		"\3\2\2\2\u0664\u0665\3\2\2\2\u0665\37\3\2\2\2\u0666\u0669\5\"\22\2\u0667"+
		"\u0669\5$\23\2\u0668\u0666\3\2\2\2\u0668\u0667\3\2\2\2\u0669!\3\2\2\2"+
		"\u066a\u066e\7\u0145\2\2\u066b\u066d\n\13\2\2\u066c\u066b\3\2\2\2\u066d"+
		"\u0670\3\2\2\2\u066e\u066c\3\2\2\2\u066e\u066f\3\2\2\2\u066f\u0671\3\2"+
		"\2\2\u0670\u066e\3\2\2\2\u0671\u0672\7\u0145\2\2\u0672#\3\2\2\2\u0673"+
		"\u0677\7\u0146\2\2\u0674\u0676\n\f\2\2\u0675\u0674\3\2\2\2\u0676\u0679"+
		"\3\2\2\2\u0677\u0675\3\2\2\2\u0677\u0678\3\2\2\2\u0678\u067a\3\2\2\2\u0679"+
		"\u0677\3\2\2\2\u067a\u067b\7\u0146\2\2\u067b%\3\2\2\2\u067c\u067d\t\r"+
		"\2\2\u067d\'\3\2\2\2\u067e\u067f\t\16\2\2\u067f)\3\2\2\2\u0680\u0681\7"+
		".\2\2\u0681\u0682\5x=\2\u0682\u0692\7\u0138\2\2\u0683\u0685\5(\25\2\u0684"+
		"\u0683\3\2\2\2\u0684\u0685\3\2\2\2\u0685\u0687\3\2\2\2\u0686\u0688\5x"+
		"=\2\u0687\u0686\3\2\2\2\u0687\u0688\3\2\2\2\u0688\u068b\3\2\2\2\u0689"+
		"\u068c\5\u008aF\2\u068a\u068c\5\u00dan\2\u068b\u0689\3\2\2\2\u068b\u068a"+
		"\3\2\2\2\u068c\u068e\3\2\2\2\u068d\u068f\7\u0131\2\2\u068e\u068d\3\2\2"+
		"\2\u068e\u068f\3\2\2\2\u068f\u0691\3\2\2\2\u0690\u0684\3\2\2\2\u0691\u0694"+
		"\3\2\2\2\u0692\u0690\3\2\2\2\u0692\u0693\3\2\2\2\u0693\u0695\3\2\2\2\u0694"+
		"\u0692\3\2\2\2\u0695\u0696\7\u0139\2\2\u0696+\3\2\2\2\u0697\u0698\7\6"+
		"\2\2\u0698\u0699\7/\2\2\u0699\u069a\79\2\2\u069a\u069f\7f\2\2\u069b\u069d"+
		"\5x=\2\u069c\u069e\7\u0131\2\2\u069d\u069c\3\2\2\2\u069d\u069e\3\2\2\2"+
		"\u069e\u06a0\3\2\2\2\u069f\u069b\3\2\2\2\u06a0\u06a1\3\2\2\2\u06a1\u069f"+
		"\3\2\2\2\u06a1\u06a2\3\2\2\2\u06a2-\3\2\2\2\u06a3\u06a5\7\27\2\2\u06a4"+
		"\u06a6\t\17\2\2\u06a5\u06a4\3\2\2\2\u06a5\u06a6\3\2\2\2\u06a6\u06a7\3"+
		"\2\2\2\u06a7\u06a8\7g\2\2\u06a8\u06cd\5\u0174\u00bb\2\u06a9\u06ab\7\u00b1"+
		"\2\2\u06aa\u06ac\7\u0086\2\2\u06ab\u06aa\3\2\2\2\u06ab\u06ac\3\2\2\2\u06ac"+
		"\u06ad\3\2\2\2\u06ad\u06cc\7\u0147\2\2\u06ae\u06af\7\u00c6\2\2\u06af\u06b3"+
		"\7\u0147\2\2\u06b0\u06b1\7\u00ca\2\2\u06b1\u06b3\7\u00c6\2\2\u06b2\u06ae"+
		"\3\2\2\2\u06b2\u06b0\3\2\2\2\u06b3\u06cc\3\2\2\2\u06b4\u06b5\7\u00c1\2"+
		"\2\u06b5\u06b9\5\u009aN\2\u06b6\u06b7\7\u00ca\2\2\u06b7\u06b9\7\u00c1"+
		"\2\2\u06b8\u06b4\3\2\2\2\u06b8\u06b6\3\2\2\2\u06b9\u06cc\3\2\2\2\u06ba"+
		"\u06bc\7\u00e5\2\2\u06bb\u06bd\7\u0081\2\2\u06bc\u06bb\3\2\2\2\u06bc\u06bd"+
		"\3\2\2\2\u06bd\u06be\3\2\2\2\u06be\u06cc\7\u0147\2\2\u06bf\u06c0\7\u0087"+
		"\2\2\u06c0\u06cc\7\u0147\2\2\u06c1\u06c3\7\u00ca\2\2\u06c2\u06c1\3\2\2"+
		"\2\u06c2\u06c3\3\2\2\2\u06c3\u06c4\3\2\2\2\u06c4\u06cc\7\u0098\2\2\u06c5"+
		"\u06c6\7V\2\2\u06c6\u06c9\7\u0086\2\2\u06c7\u06ca\5\u0174\u00bb\2\u06c8"+
		"\u06ca\7\u00cb\2\2\u06c9\u06c7\3\2\2\2\u06c9\u06c8\3\2\2\2\u06ca\u06cc"+
		"\3\2\2\2\u06cb\u06a9\3\2\2\2\u06cb\u06b2\3\2\2\2\u06cb\u06b8\3\2\2\2\u06cb"+
		"\u06ba\3\2\2\2\u06cb\u06bf\3\2\2\2\u06cb\u06c2\3\2\2\2\u06cb\u06c5\3\2"+
		"\2\2\u06cc\u06cf\3\2\2\2\u06cd\u06cb\3\2\2\2\u06cd\u06ce\3\2\2\2\u06ce"+
		"/\3\2\2\2\u06cf\u06cd\3\2\2\2\u06d0\u06d1\7\27\2\2\u06d1\u06d2\7f\2\2"+
		"\u06d2\u06d5\5x=\2\u06d3\u06d4\7\13\2\2\u06d4\u06d6\5x=\2\u06d5\u06d3"+
		"\3\2\2\2\u06d5\u06d6\3\2\2\2\u06d6\u06da\3\2\2\2\u06d7\u06d9\5\2\2\2\u06d8"+
		"\u06d7\3\2\2\2\u06d9\u06dc\3\2\2\2\u06da\u06d8\3\2\2\2\u06da\u06db\3\2"+
		"\2\2\u06db\u06f9\3\2\2\2\u06dc\u06da\3\2\2\2\u06dd\u06de\7\27\2\2\u06de"+
		"\u06df\7f\2\2\u06df\u06e0\7\13\2\2\u06e0\u06e4\5x=\2\u06e1\u06e3\5\2\2"+
		"\2\u06e2\u06e1\3\2\2\2\u06e3\u06e6\3\2\2\2\u06e4\u06e2\3\2\2\2\u06e4\u06e5"+
		"\3\2\2\2\u06e5\u06f9\3\2\2\2\u06e6\u06e4\3\2\2\2\u06e7\u06e8\7\27\2\2"+
		"\u06e8\u06e9\7f\2\2\u06e9\u06ea\7\65\2\2\u06ea\u06eb\7L\2\2\u06eb\u06ec"+
		"\7\u00a4\2\2\u06ec\u06ef\5x=\2\u06ed\u06ee\7\13\2\2\u06ee\u06f0\5x=\2"+
		"\u06ef\u06ed\3\2\2\2\u06ef\u06f0\3\2\2\2\u06f0\u06f9\3\2\2\2\u06f1\u06f2"+
		"\7\27\2\2\u06f2\u06f3\7f\2\2\u06f3\u06f4\7\65\2\2\u06f4\u06f5\7L\2\2\u06f5"+
		"\u06f6\7\u00a4\2\2\u06f6\u06f7\7\13\2\2\u06f7\u06f9\5x=\2\u06f8\u06d0"+
		"\3\2\2\2\u06f8\u06dd\3\2\2\2\u06f8\u06e7\3\2\2\2\u06f8\u06f1\3\2\2\2\u06f9"+
		"\61\3\2\2\2\u06fa\u06fd\7\27\2\2\u06fb\u06fc\7T\2\2\u06fc\u06fe\7`\2\2"+
		"\u06fd\u06fb\3\2\2\2\u06fd\u06fe\3\2\2\2\u06fe\u0700\3\2\2\2\u06ff\u0701"+
		"\t\17\2\2\u0700\u06ff\3\2\2\2\u0700\u0701\3\2\2\2\u0701\u0702\3\2\2\2"+
		"\u0702\u0703\7~\2\2\u0703\u070a\5\u0174\u00bb\2\u0704\u0706\5x=\2\u0705"+
		"\u0707\7\u0131\2\2\u0706\u0705\3\2\2\2\u0706\u0707\3\2\2\2\u0707\u0709"+
		"\3\2\2\2\u0708\u0704\3\2\2\2\u0709\u070c\3\2\2\2\u070a\u0708\3\2\2\2\u070a"+
		"\u070b\3\2\2\2\u070b\u071a\3\2\2\2\u070c\u070a\3\2\2\2\u070d\u070e\7\u0081"+
		"\2\2\u070e\u0714\7\u0138\2\2\u070f\u0712\5x=\2\u0710\u0711\7\u012e\2\2"+
		"\u0711\u0713\5x=\2\u0712\u0710\3\2\2\2\u0712\u0713\3\2\2\2\u0713\u0715"+
		"\3\2\2\2\u0714\u070f\3\2\2\2\u0715\u0716\3\2\2\2\u0716\u0714\3\2\2\2\u0716"+
		"\u0717\3\2\2\2\u0717\u0718\3\2\2\2\u0718\u0719\7\u0139\2\2\u0719\u071b"+
		"\3\2\2\2\u071a\u070d\3\2\2\2\u071a\u071b\3\2\2\2\u071b\u071c\3\2\2\2\u071c"+
		"\u071d\7\5\2\2\u071d\u071e\5\u0176\u00bc\2\u071e\63\3\2\2\2\u071f\u0720"+
		"\3\2\2\2\u0720\65\3\2\2\2\u0721\u0727\7\27\2\2\u0722\u0724\t\20\2\2\u0723"+
		"\u0722\3\2\2\2\u0723\u0724\3\2\2\2\u0724\u0725\3\2\2\2\u0725\u0728\t\17"+
		"\2\2\u0726\u0728\7\u00f6\2\2\u0727\u0723\3\2\2\2\u0727\u0726\3\2\2\2\u0727"+
		"\u0728\3\2\2\2\u0728\u0729\3\2\2\2\u0729\u072d\7p\2\2\u072a\u072b\7\65"+
		"\2\2\u072b\u072c\7L\2\2\u072c\u072e\7\u00a4\2\2\u072d\u072a\3\2\2\2\u072d"+
		"\u072e\3\2\2\2\u072e\u072f\3\2\2\2\u072f\u0730\5\u0174\u00bb\2\u0730\u074f"+
		"\7\u0138\2\2\u0731\u0732\5x=\2\u0732\u0735\5\u008aF\2\u0733\u0734\7\21"+
		"\2\2\u0734\u0736\5x=\2\u0735\u0733\3\2\2\2\u0735\u0736\3\2\2\2\u0736\u073a"+
		"\3\2\2\2\u0737\u0739\5<\37\2\u0738\u0737\3\2\2\2\u0739\u073c\3\2\2\2\u073a"+
		"\u0738\3\2\2\2\u073a\u073b\3\2\2\2\u073b\u0747\3\2\2\2\u073c\u073a\3\2"+
		"\2\2\u073d\u0747\5:\36\2\u073e\u073f\7H\2\2\u073f\u0743\5x=\2\u0740\u0742"+
		"\58\35\2\u0741\u0740\3\2\2\2\u0742\u0745\3\2\2\2\u0743\u0741\3\2\2\2\u0743"+
		"\u0744\3\2\2\2\u0744\u0747\3\2\2\2\u0745\u0743\3\2\2\2\u0746\u0731\3\2"+
		"\2\2\u0746\u073d\3\2\2\2\u0746\u073e\3\2\2\2\u0747\u0749\3\2\2\2\u0748"+
		"\u074a\7\u0131\2\2\u0749\u0748\3\2\2\2\u0749\u074a\3\2\2\2\u074a\u074c"+
		"\3\2\2\2\u074b\u0746\3\2\2\2\u074c\u074d\3\2\2\2\u074d\u074b\3\2\2\2\u074d"+
		"\u074e\3\2\2\2\u074e\u0750\3\2\2\2\u074f\u074b\3\2\2\2\u074f\u0750\3\2"+
		"\2\2\u0750\u0751\3\2\2\2\u0751\u075e\7\u0139\2\2\u0752\u0753\7;\2\2\u0753"+
		"\u0758\7\u0138\2\2\u0754\u0756\5x=\2\u0755\u0757\7\u0131\2\2\u0756\u0755"+
		"\3\2\2\2\u0756\u0757\3\2\2\2\u0757\u0759\3\2\2\2\u0758\u0754\3\2\2\2\u0759"+
		"\u075a\3\2\2\2\u075a\u0758\3\2\2\2\u075a\u075b\3\2\2\2\u075b\u075c\3\2"+
		"\2\2\u075c\u075d\7\u0139\2\2\u075d\u075f\3\2\2\2\u075e\u0752\3\2\2\2\u075e"+
		"\u075f\3\2\2\2\u075f\u0760\3\2\2\2\u0760\u0761\5B\"\2\u0761\u0762\5D#"+
		"\2\u0762\u0763\5F$\2\u0763\u0792\3\2\2\2\u0764\u076a\7\27\2\2\u0765\u0767"+
		"\t\20\2\2\u0766\u0765\3\2\2\2\u0766\u0767\3\2\2\2\u0767\u0768\3\2\2\2"+
		"\u0768\u076b\t\17\2\2\u0769\u076b\7\u00f6\2\2\u076a\u0766\3\2\2\2\u076a"+
		"\u0769\3\2\2\2\u076a\u076b\3\2\2\2\u076b\u076c\3\2\2\2\u076c\u0770\7p"+
		"\2\2\u076d\u076e\7\65\2\2\u076e\u076f\7L\2\2\u076f\u0771\7\u00a4\2\2\u0770"+
		"\u076d\3\2\2\2\u0770\u0771\3\2\2\2\u0771\u0772\3\2\2\2\u0772\u0773\5\u0174"+
		"\u00bb\2\u0773\u0774\7N\2\2\u0774\u078b\5x=\2\u0775\u0785\7\u0138\2\2"+
		"\u0776\u0777\5x=\2\u0777\u0778\7\u0081\2\2\u0778\u077c\7\u00cf\2\2\u0779"+
		"\u077b\5<\37\2\u077a\u0779\3\2\2\2\u077b\u077e\3\2\2\2\u077c\u077a\3\2"+
		"\2\2\u077c\u077d\3\2\2\2\u077d\u0781\3\2\2\2\u077e\u077c\3\2\2\2\u077f"+
		"\u0781\5:\36\2\u0780\u0776\3\2\2\2\u0780\u077f\3\2\2\2\u0781\u0783\3\2"+
		"\2\2\u0782\u0784\7\u0131\2\2\u0783\u0782\3\2\2\2\u0783\u0784\3\2\2\2\u0784"+
		"\u0786\3\2\2\2\u0785\u0780\3\2\2\2\u0786\u0787\3\2\2\2\u0787\u0785\3\2"+
		"\2\2\u0787\u0788\3\2\2\2\u0788\u0789\3\2\2\2\u0789\u078a\7\u0139\2\2\u078a"+
		"\u078c\3\2\2\2\u078b\u0775\3\2\2\2\u078b\u078c\3\2\2\2\u078c\u078d\3\2"+
		"\2\2\u078d\u078e\5B\"\2\u078e\u078f\5D#\2\u078f\u0790\5F$\2\u0790\u0792"+
		"\3\2\2\2\u0791\u0721\3\2\2\2\u0791\u0764\3\2\2\2\u0792\67\3\2\2\2\u0793"+
		"\u0794\t\21\2\2\u0794\u0795\t\22\2\2\u07959\3\2\2\2\u0796\u0797\7\24\2"+
		"\2\u0797\u0799\5x=\2\u0798\u0796\3\2\2\2\u0798\u0799\3\2\2\2\u0799\u07fc"+
		"\3\2\2\2\u079a\u07fd\5> \2\u079b\u079c\7y\2\2\u079c\u07a1\7\u0138\2\2"+
		"\u079d\u079f\5x=\2\u079e\u07a0\7\u0131\2\2\u079f\u079e\3\2\2\2\u079f\u07a0"+
		"\3\2\2\2\u07a0\u07a2\3\2\2\2\u07a1\u079d\3\2\2\2\u07a2\u07a3\3\2\2\2\u07a3"+
		"\u07a1\3\2\2\2\u07a3\u07a4\3\2\2\2\u07a4\u07a5\3\2\2\2\u07a5\u07a6\7\u0139"+
		"\2\2\u07a6\u07a7\5J&\2\u07a7\u07fd\3\2\2\2\u07a8\u07a9\7X\2\2\u07a9\u07aa"+
		"\7E\2\2\u07aa\u07af\7\u0138\2\2\u07ab\u07ad\5x=\2\u07ac\u07ae\7\u0131"+
		"\2\2\u07ad\u07ac\3\2\2\2\u07ad\u07ae\3\2\2\2\u07ae\u07b0\3\2\2\2\u07af"+
		"\u07ab\3\2\2\2\u07b0\u07b1\3\2\2\2\u07b1\u07af\3\2\2\2\u07b1\u07b2\3\2"+
		"\2\2\u07b2\u07b3\3\2\2\2\u07b3\u07b4\7\u0139\2\2\u07b4\u07b5\5J&\2\u07b5"+
		"\u07fd\3\2\2\2\u07b6\u07b9\7&\2\2\u07b7\u07b8\7|\2\2\u07b8\u07ba\5x=\2"+
		"\u07b9\u07b7\3\2\2\2\u07b9\u07ba\3\2\2\2\u07ba\u07bb\3\2\2\2\u07bb\u07bc"+
		"\7\u0138\2\2\u07bc\u07bd\5x=\2\u07bd\u07c2\7\u0081\2\2\u07be\u07c0\5x"+
		"=\2\u07bf\u07c1\7\u0131\2\2\u07c0\u07bf\3\2\2\2\u07c0\u07c1\3\2\2\2\u07c1"+
		"\u07c3\3\2\2\2\u07c2\u07be\3\2\2\2\u07c3\u07c4\3\2\2\2\u07c4\u07c2\3\2"+
		"\2\2\u07c4\u07c5\3\2\2\2\u07c5\u07c6\3\2\2\2\u07c6\u07c7\7\u0139\2\2\u07c7"+
		"\u07cd\5J&\2\u07c8\u07c9\7\u0080\2\2\u07c9\u07ca\7\u0138\2\2\u07ca\u07cb"+
		"\5x=\2\u07cb\u07cc\7\u0139\2\2\u07cc\u07ce\3\2\2\2\u07cd\u07c8\3\2\2\2"+
		"\u07cd\u07ce\3\2\2\2\u07ce\u07fd\3\2\2\2\u07cf\u07d0\7,\2\2\u07d0\u07d1"+
		"\7E\2\2\u07d1\u07d6\7\u0138\2\2\u07d2\u07d4\5x=\2\u07d3\u07d5\7\u0131"+
		"\2\2\u07d4\u07d3\3\2\2\2\u07d4\u07d5\3\2\2\2\u07d5\u07d7\3\2\2\2\u07d6"+
		"\u07d2\3\2\2\2\u07d7\u07d8\3\2\2\2\u07d8\u07d6\3\2\2\2\u07d8\u07d9\3\2"+
		"\2\2\u07d9\u07da\3\2\2\2\u07da\u07db\7\u0139\2\2\u07db\u07dc\7_\2\2\u07dc"+
		"\u07e8\5x=\2\u07dd\u07e2\7\u0138\2\2\u07de\u07e0\5x=\2\u07df\u07e1\7\u0131"+
		"\2\2\u07e0\u07df\3\2\2\2\u07e0\u07e1\3\2\2\2\u07e1\u07e3\3\2\2\2\u07e2"+
		"\u07de\3\2\2\2\u07e3\u07e4\3\2\2\2\u07e4\u07e2\3\2\2\2\u07e4\u07e5\3\2"+
		"\2\2\u07e5\u07e6\3\2\2\2\u07e6\u07e7\7\u0139\2\2\u07e7\u07e9\3\2\2\2\u07e8"+
		"\u07dd\3\2\2\2\u07e8\u07e9\3\2\2\2\u07e9\u07f0\3\2\2\2\u07ea\u07eb\7\u00bf"+
		"\2\2\u07eb\u07f1\7-\2\2\u07ec\u07ed\7\u00bf\2\2\u07ed\u07f1\7\u00d2\2"+
		"\2\u07ee\u07ef\7\u00bf\2\2\u07ef\u07f1\7\u00e3\2\2\u07f0\u07ea\3\2\2\2"+
		"\u07f0\u07ec\3\2\2\2\u07f0\u07ee\3\2\2\2\u07f0\u07f1\3\2\2\2\u07f1\u07f5"+
		"\3\2\2\2\u07f2\u07f3\7P\2\2\u07f3\u07f4\7\36\2\2\u07f4\u07f6\5H%\2\u07f5"+
		"\u07f2\3\2\2\2\u07f5\u07f6\3\2\2\2\u07f6\u07fa\3\2\2\2\u07f7\u07f8\7P"+
		"\2\2\u07f8\u07f9\7z\2\2\u07f9\u07fb\5H%\2\u07fa\u07f7\3\2\2\2\u07fa\u07fb"+
		"\3\2\2\2\u07fb\u07fd\3\2\2\2\u07fc\u079a\3\2\2\2\u07fc\u079b\3\2\2\2\u07fc"+
		"\u07a8\3\2\2\2\u07fc\u07b6\3\2\2\2\u07fc\u07cf\3\2\2\2\u07fd\u0801\3\2"+
		"\2\2\u07fe\u0802\7\34\2\2\u07ff\u0800\7L\2\2\u0800\u0802\7\34\2\2\u0801"+
		"\u07fe\3\2\2\2\u0801\u07ff\3\2\2\2\u0801\u0802\3\2\2\2\u0802\u0807\3\2"+
		"\2\2\u0803\u0804\7<\2\2\u0804\u0808\7\35\2\2\u0805\u0806\7<\2\2\u0806"+
		"\u0808\7\67\2\2\u0807\u0803\3\2\2\2\u0807\u0805\3\2\2\2\u0807\u0808\3"+
		"\2\2\2\u0808;\3\2\2\2\u0809\u080a\7\24\2\2\u080a\u080c\5x=\2\u080b\u0809"+
		"\3\2\2\2\u080b\u080c\3\2\2\2\u080c\u0830\3\2\2\2\u080d\u080e\7L\2\2\u080e"+
		"\u0831\7M\2\2\u080f\u0831\7M\2\2\u0810\u0831\5> \2\u0811\u0814\7\32\2"+
		"\2\u0812\u0815\5\u008aF\2\u0813\u0815\5\u00dan\2\u0814\u0812\3\2\2\2\u0814"+
		"\u0813\3\2\2\2\u0815\u0831\3\2\2\2\u0816\u0817\7y\2\2\u0817\u0831\5J&"+
		"\2\u0818\u0819\7X\2\2\u0819\u081a\7E\2\2\u081a\u0831\5J&\2\u081b\u081c"+
		"\7_\2\2\u081c\u081d\5\u0174\u00bb\2\u081d\u0824\5x=\2\u081e\u081f\7\u00bf"+
		"\2\2\u081f\u0825\7-\2\2\u0820\u0821\7\u00bf\2\2\u0821\u0825\7\u00d2\2"+
		"\2\u0822\u0823\7\u00bf\2\2\u0823\u0825\7\u00e3\2\2\u0824\u081e\3\2\2\2"+
		"\u0824\u0820\3\2\2\2\u0824\u0822\3\2\2\2\u0824\u0825\3\2\2\2\u0825\u0829"+
		"\3\2\2\2\u0826\u0827\7P\2\2\u0827\u0828\7\36\2\2\u0828\u082a\5H%\2\u0829"+
		"\u0826\3\2\2\2\u0829\u082a\3\2\2\2\u082a\u082e\3\2\2\2\u082b\u082c\7P"+
		"\2\2\u082c\u082d\7z\2\2\u082d\u082f\5H%\2\u082e\u082b\3\2\2\2\u082e\u082f"+
		"\3\2\2\2\u082f\u0831\3\2\2\2\u0830\u080d\3\2\2\2\u0830\u080f\3\2\2\2\u0830"+
		"\u0810\3\2\2\2\u0830\u0811\3\2\2\2\u0830\u0816\3\2\2\2\u0830\u0818\3\2"+
		"\2\2\u0830\u081b\3\2\2\2\u0831\u0835\3\2\2\2\u0832\u0836\7\34\2\2\u0833"+
		"\u0834\7L\2\2\u0834\u0836\7\34\2\2\u0835\u0832\3\2\2\2\u0835\u0833\3\2"+
		"\2\2\u0835\u0836\3\2\2\2\u0836\u083b\3\2\2\2\u0837\u0838\7<\2\2\u0838"+
		"\u083c\7\35\2\2\u0839\u083a\7<\2\2\u083a\u083c\7\67\2\2\u083b\u0837\3"+
		"\2\2\2\u083b\u0839\3\2\2\2\u083b\u083c\3\2\2\2\u083c=\3\2\2\2\u083d\u083e"+
		"\7\u008c\2\2\u083e\u083f\7\u0138\2\2\u083f\u0840\5\u0104\u0083\2\u0840"+
		"\u0841\7\u0139\2\2\u0841?\3\2\2\2\u0842\u0843\7\u0081\2\2\u0843\u084c"+
		"\7\u0138\2\2\u0844\u0847\5x=\2\u0845\u0846\7\u012e\2\2\u0846\u0848\5x"+
		"=\2\u0847\u0845\3\2\2\2\u0847\u0848\3\2\2\2\u0848\u084a\3\2\2\2\u0849"+
		"\u084b\7\u0131\2\2\u084a\u0849\3\2\2\2\u084a\u084b\3\2\2\2\u084b\u084d"+
		"\3\2\2\2\u084c\u0844\3\2\2\2\u084d\u084e\3\2\2\2\u084e\u084c\3\2\2\2\u084e"+
		"\u084f\3\2\2\2\u084f\u0850\3\2\2\2\u0850\u0851\7\u0139\2\2\u0851A\3\2"+
		"\2\2\u0852\u0858\5@!\2\u0853\u0854\7\u0081\2\2\u0854\u0858\7O\2\2\u0855"+
		"\u0856\7\u0082\2\2\u0856\u0858\7O\2\2\u0857\u0852\3\2\2\2\u0857\u0853"+
		"\3\2\2\2\u0857\u0855\3\2\2\2\u0857\u0858\3\2\2\2\u0858C\3\2\2\2\u0859"+
		"\u085a\7P\2\2";
	private static final String _serializedATNSegment1 =
		"\u085a\u0860\7\u0092\2\2\u085b\u085c\7W\2\2\u085c\u0861\7^\2\2\u085d\u085e"+
		"\7\36\2\2\u085e\u0861\7^\2\2\u085f\u0861\7\u00a1\2\2\u0860\u085b\3\2\2"+
		"\2\u0860\u085d\3\2\2\2\u0860\u085f\3\2\2\2\u0861\u0863\3\2\2\2\u0862\u0859"+
		"\3\2\2\2\u0862\u0863\3\2\2\2\u0863E\3\2\2\2\u0864\u0865\7\u00eb\2\2\u0865"+
		"\u0867\5x=\2\u0866\u0864\3\2\2\2\u0866\u0867\3\2\2\2\u0867G\3\2\2\2\u0868"+
		"\u086f\7a\2\2\u0869\u086f\7\17\2\2\u086a\u086b\7\u00e1\2\2\u086b\u086f"+
		"\7M\2\2\u086c\u086d\7\u00e1\2\2\u086d\u086f\7\32\2\2\u086e\u0868\3\2\2"+
		"\2\u086e\u0869\3\2\2\2\u086e\u086a\3\2\2\2\u086e\u086c\3\2\2\2\u086fI"+
		"\3\2\2\2\u0870\u0872\5@!\2\u0871\u0870\3\2\2\2\u0871\u0872\3\2\2\2\u0872"+
		"\u0877\3\2\2\2\u0873\u0874\7|\2\2\u0874\u0875\7\u00af\2\2\u0875\u0876"+
		"\7\u00eb\2\2\u0876\u0878\5x=\2\u0877\u0873\3\2\2\2\u0877\u0878\3\2\2\2"+
		"\u0878K\3\2\2\2\u0879\u087a\7\u0138\2\2\u087a\u087f\5N(\2\u087b\u087c"+
		"\7\u0131\2\2\u087c\u087e\5N(\2\u087d\u087b\3\2\2\2\u087e\u0881\3\2\2\2"+
		"\u087f\u087d\3\2\2\2\u087f\u0880\3\2\2\2\u0880\u0882\3\2\2\2\u0881\u087f"+
		"\3\2\2\2\u0882\u0883\7\u0139\2\2\u0883M\3\2\2\2\u0884\u0885\5x=\2\u0885"+
		"\u0886\5P)\2\u0886O\3\2\2\2\u0887\u0888\5\u008aF\2\u0888Q\3\2\2\2\u0889"+
		"\u088a\7\u0081\2\2\u088a\u088b\7\u0138\2\2\u088b\u0890\5T+\2\u088c\u088d"+
		"\7\u0131\2\2\u088d\u088f\5T+\2\u088e\u088c\3\2\2\2\u088f\u0892\3\2\2\2"+
		"\u0890\u088e\3\2\2\2\u0890\u0891\3\2\2\2\u0891\u0893\3\2\2\2\u0892\u0890"+
		"\3\2\2\2\u0893\u0894\7\u0139\2\2\u0894S\3\2\2\2\u0895\u0896\7\u014c\2"+
		"\2\u0896\u0897\7\u012e\2\2\u0897\u0898\5\u00dep\2\u0898U\3\2\2\2\u0899"+
		"\u089a\7|\2\2\u089a\u089b\5x=\2\u089bW\3\2\2\2\u089c\u089d\7\u00eb\2\2"+
		"\u089d\u089e\5Z.\2\u089eY\3\2\2\2\u089f\u08a0\5x=\2\u08a0[\3\2\2\2\u08a1"+
		"\u08a6\5^\60\2\u08a2\u08a6\5d\63\2\u08a3\u08a6\5l\67\2\u08a4\u08a6\5r"+
		":\2\u08a5\u08a1\3\2\2\2\u08a5\u08a2\3\2\2\2\u08a5\u08a3\3\2\2\2\u08a5"+
		"\u08a4\3\2\2\2\u08a6]\3\2\2\2\u08a7\u08a8\7\u00d3\2\2\u08a8\u08a9\7\u0086"+
		"\2\2\u08a9\u08aa\7\u00d9\2\2\u08aa\u08ab\7\u0138\2\2\u08ab\u08ac\5\u0186"+
		"\u00c4\2\u08ac\u08ad\7\u0139\2\2\u08ad\u08ae\7\u0138\2\2\u08ae\u08af\5"+
		"`\61\2\u08af\u08b0\7\u0139\2\2\u08b0_\3\2\2\2\u08b1\u08b6\5b\62\2\u08b2"+
		"\u08b3\7\u0131\2\2\u08b3\u08b5\5b\62\2\u08b4\u08b2\3\2\2\2\u08b5\u08b8"+
		"\3\2\2\2\u08b6\u08b4\3\2\2\2\u08b6\u08b7\3\2\2\2\u08b7a\3\2\2\2\u08b8"+
		"\u08b6\3\2\2\2\u08b9\u08ba\7\u00d3\2\2\u08ba\u08bb\5t;\2\u08bb\u08bc\7"+
		"\u00f7\2\2\u08bc\u08bd\7\u00bc\2\2\u08bd\u08c9\7\u00ee\2\2\u08be\u08bf"+
		"\7\u0138\2\2\u08bf\u08c0\5\u00dan\2\u08c0\u08c1\7\u0139\2\2\u08c1\u08ca"+
		"\3\2\2\2\u08c2\u08c4\7\u0138\2\2\u08c3\u08c2\3\2\2\2\u08c3\u08c4\3\2\2"+
		"\2\u08c4\u08c5\3\2\2\2\u08c5\u08c7\7\u00c1\2\2\u08c6\u08c8\7\u0139\2\2"+
		"\u08c7\u08c6\3\2\2\2\u08c7\u08c8\3\2\2\2\u08c8\u08ca\3\2\2\2\u08c9\u08be"+
		"\3\2\2\2\u08c9\u08c3\3\2\2\2\u08cac\3\2\2\2\u08cb\u08cc\7\u00d3\2\2\u08cc"+
		"\u08cd\7\u0086\2\2\u08cd\u08ce\7\u00ad\2\2\u08ce\u08cf\7\u0138\2\2\u08cf"+
		"\u08d0\5\u0186\u00c4\2\u08d0\u08d6\7\u0139\2\2\u08d1\u08d2\7\u0138\2\2"+
		"\u08d2\u08d3\5f\64\2\u08d3\u08d4\7\u0139\2\2\u08d4\u08d7\3\2\2\2\u08d5"+
		"\u08d7\5j\66\2\u08d6\u08d1\3\2\2\2\u08d6\u08d5\3\2\2\2\u08d7e\3\2\2\2"+
		"\u08d8\u08dd\5h\65\2\u08d9\u08da\7\u0131\2\2\u08da\u08dc\5h\65\2\u08db"+
		"\u08d9\3\2\2\2\u08dc\u08df\3\2\2\2\u08dd\u08db\3\2\2\2\u08dd\u08de\3\2"+
		"\2\2\u08deg\3\2\2\2\u08df\u08dd\3\2\2\2\u08e0\u08e1\7\u00d3\2\2\u08e1"+
		"\u08e2\5t;\2\u08e2i\3\2\2\2\u08e3\u08e4\7\u00d4\2\2\u08e4\u08e5\5\u00de"+
		"p\2\u08e5k\3\2\2\2\u08e6\u08e7\7\u00d3\2\2\u08e7\u08e8\7\u0086\2\2\u08e8"+
		"\u08e9\7\u00bd\2\2\u08e9\u08ea\7\u0138\2\2\u08ea\u08eb\5\u0186\u00c4\2"+
		"\u08eb\u08ec\7\u0139\2\2\u08ec\u08ed\7\u0138\2\2\u08ed\u08ee\5n8\2\u08ee"+
		"\u08ef\7\u0139\2\2\u08efm\3\2\2\2\u08f0\u08f5\5p9\2\u08f1\u08f2\7\u0131"+
		"\2\2\u08f2\u08f4\5p9\2\u08f3\u08f1\3\2\2\2\u08f4\u08f7\3\2\2\2\u08f5\u08f3"+
		"\3\2\2\2\u08f5\u08f6\3\2\2\2\u08f6o\3\2\2\2\u08f7\u08f5\3\2\2\2\u08f8"+
		"\u08f9\7\u00d3\2\2\u08f9\u08fa\5t;\2\u08fa\u08fc\7\u00f7\2\2\u08fb\u08fd"+
		"\79\2\2\u08fc\u08fb\3\2\2\2\u08fc\u08fd\3\2\2\2\u08fd\u08fe\3\2\2\2\u08fe"+
		"\u08ff\7\u0138\2\2\u08ff\u0900\5\u019e\u00d0\2\u0900\u0901\7\u0139\2\2"+
		"\u0901q\3\2\2\2\u0902\u0903\7\u00d3\2\2\u0903\u0904\7\u0086\2\2\u0904"+
		"\u0905\7\u008f\2\2\u0905\u0906\5L\'\2\u0906s\3\2\2\2\u0907\u0908\5x=\2"+
		"\u0908u\3\2\2\2\u0909\u090a\7\u00a1\2\2\u090a\u090b\7p\2\2\u090b\u090d"+
		"\5\u0174\u00bb\2\u090c\u090e\7\u00d7\2\2\u090d\u090c\3\2\2\2\u090d\u090e"+
		"\3\2\2\2\u090ew\3\2\2\2\u090f\u0911\7\u0143\2\2\u0910\u090f\3\2\2\2\u0910"+
		"\u0911\3\2\2\2\u0911\u0912\3\2\2\2\u0912\u0914\7\u014b\2\2\u0913\u0915"+
		"\7\u0143\2\2\u0914\u0913\3\2\2\2\u0914\u0915\3\2\2\2\u0915\u091e\3\2\2"+
		"\2\u0916\u0918\7\u0143\2\2\u0917\u0916\3\2\2\2\u0917\u0918\3\2\2\2\u0918"+
		"\u0919\3\2\2\2\u0919\u091b\5z>\2\u091a\u091c\7\u0143\2\2\u091b\u091a\3"+
		"\2\2\2\u091b\u091c\3\2\2\2\u091c\u091e\3\2\2\2\u091d\u0910\3\2\2\2\u091d"+
		"\u0917\3\2\2\2\u091ey\3\2\2\2\u091f\u0920\t\23\2\2\u0920{\3\2\2\2\u0921"+
		"\u0924\5\u00b2Z\2\u0922\u0924\5~@\2\u0923\u0921\3\2\2\2\u0923\u0922\3"+
		"\2\2\2\u0924}\3\2\2\2\u0925\u0929\7\u014c\2\2\u0926\u0929\5\u0080A\2\u0927"+
		"\u0929\5\u0088E\2\u0928\u0925\3\2\2\2\u0928\u0926\3\2\2\2\u0928\u0927"+
		"\3\2\2\2\u0929\177\3\2\2\2\u092a\u092e\5\u0084C\2\u092b\u092e\5\u0082"+
		"B\2\u092c\u092e\5\u0086D\2\u092d\u092a\3\2\2\2\u092d\u092b\3\2\2\2\u092d"+
		"\u092c\3\2\2\2\u092e\u0081\3\2\2\2\u092f\u0930\7\u011c\2\2\u0930\u0931"+
		"\7\u014c\2\2\u0931\u0083\3\2\2\2\u0932\u0933\7\u011e\2\2\u0933\u0934\7"+
		"\u014c\2\2\u0934\u0085\3\2\2\2\u0935\u0936\7\u011b\2\2\u0936\u0937\7\u014c"+
		"\2\2\u0937\u0087\3\2\2\2\u0938\u0939\t\24\2\2\u0939\u0089\3\2\2\2\u093a"+
		"\u093e\5\u008cG\2\u093b\u093c\7k\2\2\u093c\u093e\5x=\2\u093d\u093a\3\2"+
		"\2\2\u093d\u093b\3\2\2\2\u093e\u008b\3\2\2\2\u093f\u094d\5\u0092J\2\u0940"+
		"\u094d\5\u0096L\2\u0941\u094d\5\u0098M\2\u0942\u094d\5\u009aN\2\u0943"+
		"\u094d\5\u00a2R\2\u0944\u094d\5\u00a4S\2\u0945\u094d\5\u00a6T\2\u0946"+
		"\u094d\5\u00a8U\2\u0947\u094d\5\u0090I\2\u0948\u094d\5\u008eH\2\u0949"+
		"\u094d\7u\2\2\u094a\u094d\7\u0121\2\2\u094b\u094d\7\u0127\2\2\u094c\u093f"+
		"\3\2\2\2\u094c\u0940\3\2\2\2\u094c\u0941\3\2\2\2\u094c\u0942\3\2\2\2\u094c"+
		"\u0943\3\2\2\2\u094c\u0944\3\2\2\2\u094c\u0945\3\2\2\2\u094c\u0946\3\2"+
		"\2\2\u094c\u0947\3\2\2\2\u094c\u0948\3\2\2\2\u094c\u0949\3\2\2\2\u094c"+
		"\u094a\3\2\2\2\u094c\u094b\3\2\2\2\u094d\u008d\3\2\2\2\u094e\u094f\7\u0112"+
		"\2\2\u094f\u008f\3\2\2\2\u0950\u0951\7\u0126\2\2\u0951\u0091\3\2\2\2\u0952"+
		"\u0954\7\u008b\2\2\u0953\u0955\5\u0094K\2\u0954\u0953\3\2\2\2\u0954\u0955"+
		"\3\2\2\2\u0955\u096a\3\2\2\2\u0956\u0958\7\u0117\2\2\u0957\u0959\5\u0094"+
		"K\2\u0958\u0957\3\2\2\2\u0958\u0959\3\2\2\2\u0959\u096a\3\2\2\2\u095a"+
		"\u095b\7\u008b\2\2\u095b\u095d\7\u00fa\2\2\u095c\u095e\5\u0094K\2\u095d"+
		"\u095c\3\2\2\2\u095d\u095e\3\2\2\2\u095e\u096a\3\2\2\2\u095f\u0960\7\u0117"+
		"\2\2\u0960\u0962\7\u00fa\2\2\u0961\u0963\5\u0094K\2\u0962\u0961\3\2\2"+
		"\2\u0962\u0963\3\2\2\2\u0963\u096a\3\2\2\2\u0964\u0966\7\u0118\2\2\u0965"+
		"\u0967\5\u0094K\2\u0966\u0965\3\2\2\2\u0966\u0967\3\2\2\2\u0967\u096a"+
		"\3\2\2\2\u0968\u096a\7\u0120\2\2\u0969\u0952\3\2\2\2\u0969\u0956\3\2\2"+
		"\2\u0969\u095a\3\2\2\2\u0969\u095f\3\2\2\2\u0969\u0964\3\2\2\2\u0969\u0968"+
		"\3\2\2\2\u096a\u0093\3\2\2\2\u096b\u096c\7\u0138\2\2\u096c\u096d\7\u0147"+
		"\2\2\u096d\u096e\7\u0139\2\2\u096e\u0095\3\2\2\2\u096f\u0970\7\u00c9\2"+
		"\2\u0970\u0972\7\u008b\2\2\u0971\u0973\5\u0094K\2\u0972\u0971\3\2\2\2"+
		"\u0972\u0973\3\2\2\2\u0973\u0993\3\2\2\2\u0974\u0975\7\u00c9\2\2\u0975"+
		"\u0977\7\u0117\2\2\u0976\u0978\5\u0094K\2\u0977\u0976\3\2\2\2\u0977\u0978"+
		"\3\2\2\2\u0978\u0993\3\2\2\2\u0979\u097b\7\u0119\2\2\u097a\u097c\5\u0094"+
		"K\2\u097b\u097a\3\2\2\2\u097b\u097c\3\2\2\2\u097c\u0993\3\2\2\2\u097d"+
		"\u097e\7\u00c9\2\2\u097e\u097f\7\u008b\2\2\u097f\u0981\7\u00fa\2\2\u0980"+
		"\u0982\5\u0094K\2\u0981\u0980\3\2\2\2\u0981\u0982\3\2\2\2\u0982\u0993"+
		"\3\2\2\2\u0983\u0984\7\u00c9\2\2\u0984\u0985\7\u0117\2\2\u0985\u0987\7"+
		"\u00fa\2\2\u0986\u0988\5\u0094K\2\u0987\u0986\3\2\2\2\u0987\u0988\3\2"+
		"\2\2\u0988\u0993\3\2\2\2\u0989\u098a\7\u0119\2\2\u098a\u098c\7\u00fa\2"+
		"\2\u098b\u098d\5\u0094K\2\u098c\u098b\3\2\2\2\u098c\u098d\3\2\2\2\u098d"+
		"\u0993\3\2\2\2\u098e\u0990\7\u011a\2\2\u098f\u0991\5\u0094K\2\u0990\u098f"+
		"\3\2\2\2\u0990\u0991\3\2\2\2\u0991\u0993\3\2\2\2\u0992\u096f\3\2\2\2\u0992"+
		"\u0974\3\2\2\2\u0992\u0979\3\2\2\2\u0992\u097d\3\2\2\2\u0992\u0983\3\2"+
		"\2\2\u0992\u0989\3\2\2\2\u0992\u098e\3\2\2\2\u0993\u0097\3\2\2\2\u0994"+
		"\u0996\7\u0124\2\2\u0995\u0997\5\u0094K\2\u0996\u0995\3\2\2\2\u0996\u0997"+
		"\3\2\2\2\u0997\u099d\3\2\2\2\u0998\u099a\7\u0125\2\2\u0999\u099b\5\u0094"+
		"K\2\u099a\u0999\3\2\2\2\u099a\u099b\3\2\2\2\u099b\u099d\3\2\2\2\u099c"+
		"\u0994\3\2\2\2\u099c\u0998\3\2\2\2\u099d\u0099\3\2\2\2\u099e\u09a1\5\u009c"+
		"O\2\u099f\u09a1\5\u009eP\2\u09a0\u099e\3\2\2\2\u09a0\u099f\3\2\2\2\u09a1"+
		"\u009b\3\2\2\2\u09a2\u09a4\7\u0115\2\2\u09a3\u09a5\5\u00a0Q\2\u09a4\u09a3"+
		"\3\2\2\2\u09a4\u09a5\3\2\2\2\u09a5\u09b8\3\2\2\2\u09a6\u09a8\7\u0116\2"+
		"\2\u09a7\u09a9\5\u00a0Q\2\u09a8\u09a7\3\2\2\2\u09a8\u09a9\3\2\2\2\u09a9"+
		"\u09b8\3\2\2\2\u09aa\u09ac\7\u009b\2\2\u09ab\u09ad\5\u00a0Q\2\u09ac\u09ab"+
		"\3\2\2\2\u09ac\u09ad\3\2\2\2\u09ad\u09b8\3\2\2\2\u09ae\u09b8\7\u0106\2"+
		"\2\u09af\u09b8\7\u010a\2\2\u09b0\u09b8\7\u0107\2\2\u09b1\u09b8\7\u010b"+
		"\2\2\u09b2\u09b8\7\u0108\2\2\u09b3\u09b8\7\u010c\2\2\u09b4\u09b8\7\u010d"+
		"\2\2\u09b5\u09b8\7\u0109\2\2\u09b6\u09b8\7\u010e\2\2\u09b7\u09a2\3\2\2"+
		"\2\u09b7\u09a6\3\2\2\2\u09b7\u09aa\3\2\2\2\u09b7\u09ae\3\2\2\2\u09b7\u09af"+
		"\3\2\2\2\u09b7\u09b0\3\2\2\2\u09b7\u09b1\3\2\2\2\u09b7\u09b2\3\2\2\2\u09b7"+
		"\u09b3\3\2\2\2\u09b7\u09b4\3\2\2\2\u09b7\u09b5\3\2\2\2\u09b7\u09b6\3\2"+
		"\2\2\u09b8\u009d\3\2\2\2\u09b9\u09bb\7\u0113\2\2\u09ba\u09bc\5\u00a0Q"+
		"\2\u09bb\u09ba\3\2\2\2\u09bb\u09bc\3\2\2\2\u09bc\u09c4\3\2\2\2\u09bd\u09c4"+
		"\7\u010f\2\2\u09be\u09c4\7\u0111\2\2\u09bf\u09c4\7\u0110\2\2\u09c0\u09c4"+
		"\7\u0114\2\2\u09c1\u09c2\7\u0114\2\2\u09c2\u09c4\7\u00d5\2\2\u09c3\u09b9"+
		"\3\2\2\2\u09c3\u09bd\3\2\2\2\u09c3\u09be\3\2\2\2\u09c3\u09bf\3\2\2\2\u09c3"+
		"\u09c0\3\2\2\2\u09c3\u09c1\3\2\2\2\u09c4\u009f\3\2\2\2\u09c5\u09c6\7\u0138"+
		"\2\2\u09c6\u09c7\7\u0147\2\2\u09c7\u09ce\7\u0139\2\2\u09c8\u09c9\7\u0138"+
		"\2\2\u09c9\u09ca\7\u0147\2\2\u09ca\u09cb\7\u0131\2\2\u09cb\u09cc\7\u0147"+
		"\2\2\u09cc\u09ce\7\u0139\2\2\u09cd\u09c5\3\2\2\2\u09cd\u09c8\3\2\2\2\u09ce"+
		"\u00a1\3\2\2\2\u09cf\u09d0\t\25\2\2\u09d0\u00a3\3\2\2\2\u09d1\u09df\7"+
		"\u011b\2\2\u09d2\u09df\7\u011c\2\2\u09d3\u09d4\7\u011c\2\2\u09d4\u09d5"+
		"\7\u0081\2\2\u09d5\u09d6\7\u011c\2\2\u09d6\u09df\7\u0101\2\2\u09d7\u09df"+
		"\7\u011d\2\2\u09d8\u09df\7\u011e\2\2\u09d9\u09da\7\u011e\2\2\u09da\u09db"+
		"\7\u0081\2\2\u09db\u09dc\7\u011c\2\2\u09dc\u09df\7\u0101\2\2\u09dd\u09df"+
		"\7\u011f\2\2\u09de\u09d1\3\2\2\2\u09de\u09d2\3\2\2\2\u09de\u09d3\3\2\2"+
		"\2\u09de\u09d7\3\2\2\2\u09de\u09d8\3\2\2\2\u09de\u09d9\3\2\2\2\u09de\u09dd"+
		"\3\2\2\2\u09df\u00a5\3\2\2\2\u09e0\u09e2\7\u0104\2\2\u09e1\u09e3\5\u0094"+
		"K\2\u09e2\u09e1\3\2\2\2\u09e2\u09e3\3\2\2\2\u09e3\u09ee\3\2\2\2\u09e4"+
		"\u09e6\7\u0105\2\2\u09e5\u09e7\5\u0094K\2\u09e6\u09e5\3\2\2\2\u09e6\u09e7"+
		"\3\2\2\2\u09e7\u09ee\3\2\2\2\u09e8\u09e9\7\u0104\2\2\u09e9\u09eb\7\u00fa"+
		"\2\2\u09ea\u09ec\5\u0094K\2\u09eb\u09ea\3\2\2\2\u09eb\u09ec\3\2\2\2\u09ec"+
		"\u09ee\3\2\2\2\u09ed\u09e0\3\2\2\2\u09ed\u09e4\3\2\2\2\u09ed\u09e8\3\2"+
		"\2\2\u09ee\u00a7\3\2\2\2\u09ef\u09f1\7\u0122\2\2\u09f0\u09f2\5\u0094K"+
		"\2\u09f1\u09f0\3\2\2\2\u09f1\u09f2\3\2\2\2\u09f2\u09fd\3\2\2\2\u09f3\u09f4"+
		"\7\u0122\2\2\u09f4\u09f6\7\u00fa\2\2\u09f5\u09f7\5\u0094K\2\u09f6\u09f5"+
		"\3\2\2\2\u09f6\u09f7\3\2\2\2\u09f7\u09fd\3\2\2\2\u09f8\u09fa\7\u0123\2"+
		"\2\u09f9\u09fb\5\u0094K\2\u09fa\u09f9\3\2\2\2\u09fa\u09fb\3\2\2\2\u09fb"+
		"\u09fd\3\2\2\2\u09fc\u09ef\3\2\2\2\u09fc\u09f3\3\2\2\2\u09fc\u09f8\3\2"+
		"\2\2\u09fd\u00a9\3\2\2\2\u09fe\u0a01\5\u00acW\2\u09ff\u0a01\5\u00aeX\2"+
		"\u0a00\u09fe\3\2\2\2\u0a00\u09ff\3\2\2\2\u0a01\u00ab\3\2\2\2\u0a02\u0a03"+
		"\7\u0138\2\2\u0a03\u0a04\5\u00dan\2\u0a04\u0a05\7\u0139\2\2\u0a05\u00ad"+
		"\3\2\2\2\u0a06\u0a0e\5\u00b0Y\2\u0a07\u0a0e\5\u0182\u00c2\2\u0a08\u0a0e"+
		"\5\u00b6\\\2\u0a09\u0a0e\5\u0188\u00c5\2\u0a0a\u0a0e\5\u00c2b\2\u0a0b"+
		"\u0a0e\5\u00d4k\2\u0a0c\u0a0e\5\u01bc\u00df\2\u0a0d\u0a06\3\2\2\2\u0a0d"+
		"\u0a07\3\2\2\2\u0a0d\u0a08\3\2\2\2\u0a0d\u0a09\3\2\2\2\u0a0d\u0a0a\3\2"+
		"\2\2\u0a0d\u0a0b\3\2\2\2\u0a0d\u0a0c\3\2\2\2\u0a0e\u00af\3\2\2\2\u0a0f"+
		"\u0a10\5|?\2\u0a10\u00b1\3\2\2\2\u0a11\u0a12\t\26\2\2\u0a12\u00b3\3\2"+
		"\2\2\u0a13\u0a15\5\u00e8u\2\u0a14\u0a13\3\2\2\2\u0a14\u0a15\3\2\2\2\u0a15"+
		"\u0a16\3\2\2\2\u0a16\u0a17\5\u00b2Z\2\u0a17\u00b5\3\2\2\2\u0a18\u0a19"+
		"\5\u00b8]\2\u0a19\u00b7\3\2\2\2\u0a1a\u0a1b\7\u0095\2\2\u0a1b\u0a1c\7"+
		"\u0138\2\2\u0a1c\u0a1d\7\u013c\2\2\u0a1d\u0a23\7\u0139\2\2\u0a1e\u0a20"+
		"\5\u00ba^\2\u0a1f\u0a21\5\u00be`\2\u0a20\u0a1f\3\2\2\2\u0a20\u0a21\3\2"+
		"\2\2\u0a21\u0a23\3\2\2\2\u0a22\u0a1a\3\2\2\2\u0a22\u0a1e\3\2\2\2\u0a23"+
		"\u00b9\3\2\2\2\u0a24\u0a25\5\u00bc_\2\u0a25\u0a27\7\u0138\2\2\u0a26\u0a28"+
		"\5\u0180\u00c1\2\u0a27\u0a26\3\2\2\2\u0a27\u0a28\3\2\2\2\u0a28\u0a29\3"+
		"\2\2\2\u0a29\u0a2a\5\u00dan\2\u0a2a\u0a2b\7\u0139\2\2\u0a2b\u00bb\3\2"+
		"\2\2\u0a2c\u0a2d\t\27\2\2\u0a2d\u00bd\3\2\2\2\u0a2e\u0a2f\7\u00a8\2\2"+
		"\u0a2f\u0a30\7\u0138\2\2\u0a30\u0a31\7\u0080\2\2\u0a31\u0a32\5\u014a\u00a6"+
		"\2\u0a32\u0a33\7\u0139\2\2\u0a33\u00bf\3\2\2\2\u0a34\u0a35\7\u00ac\2\2"+
		"\u0a35\u0a36\7\u0138\2\2\u0a36\u0a37\5\u0186\u00c4\2\u0a37\u0a38\7\u0139"+
		"\2\2\u0a38\u00c1\3\2\2\2\u0a39\u0a3a\5\u00c6d\2\u0a3a\u00c3\3\2\2\2\u0a3b"+
		"\u0a3c\7\u00cc\2\2\u0a3c\u0a3d\7\u0138\2\2\u0a3d\u0a3e\5\u00dep\2\u0a3e"+
		"\u0a3f\7\u0131\2\2\u0a3f\u0a40\5\u0104\u0083\2\u0a40\u0a41\7\u0139\2\2"+
		"\u0a41\u0a4e\3\2\2\2\u0a42\u0a43\7\u008e\2\2\u0a43\u0a44\7\u0138\2\2\u0a44"+
		"\u0a47\5\u00dep\2\u0a45\u0a46\7\u0131\2\2\u0a46\u0a48\5\u0104\u0083\2"+
		"\u0a47\u0a45\3\2\2\2\u0a48\u0a49\3\2\2\2\u0a49\u0a47\3\2\2\2\u0a49\u0a4a"+
		"\3\2\2\2\u0a4a\u0a4b\3\2\2\2\u0a4b\u0a4c\7\u0139\2\2\u0a4c\u0a4e\3\2\2"+
		"\2\u0a4d\u0a3b\3\2\2\2\u0a4d\u0a42\3\2\2\2\u0a4e\u00c5\3\2\2\2\u0a4f\u0a52"+
		"\5\u00c8e\2\u0a50\u0a52\5\u00caf\2\u0a51\u0a4f\3\2\2\2\u0a51\u0a50\3\2"+
		"\2\2\u0a52\u00c7\3\2\2\2\u0a53\u0a54\7\16\2\2\u0a54\u0a56\5\u0104\u0083"+
		"\2\u0a55\u0a57\5\u00ccg\2\u0a56\u0a55\3\2\2\2\u0a57\u0a58\3\2\2\2\u0a58"+
		"\u0a56\3\2\2\2\u0a58\u0a59\3\2\2\2\u0a59\u0a5b\3\2\2\2\u0a5a\u0a5c\5\u00d0"+
		"i\2\u0a5b\u0a5a\3\2\2\2\u0a5b\u0a5c\3\2\2\2\u0a5c\u0a5d\3\2\2\2\u0a5d"+
		"\u0a5e\7#\2\2\u0a5e\u00c9\3\2\2\2\u0a5f\u0a61\7\16\2\2\u0a60\u0a62\5\u00ce"+
		"h\2\u0a61\u0a60\3\2\2\2\u0a62\u0a63\3\2\2\2\u0a63\u0a61\3\2\2\2\u0a63"+
		"\u0a64\3\2\2\2\u0a64\u0a66\3\2\2\2\u0a65\u0a67\5\u00d0i\2\u0a66\u0a65"+
		"\3\2\2\2\u0a66\u0a67\3\2\2\2\u0a67\u0a68\3\2\2\2\u0a68\u0a69\7#\2\2\u0a69"+
		"\u00cb\3\2\2\2\u0a6a\u0a6b\7\177\2\2\u0a6b\u0a6c\5\u014a\u00a6\2\u0a6c"+
		"\u0a6d\7s\2\2\u0a6d\u0a6e\5\u00d2j\2\u0a6e\u00cd\3\2\2\2\u0a6f\u0a70\7"+
		"\177\2\2\u0a70\u0a71\5\u014a\u00a6\2\u0a71\u0a72\7s\2\2\u0a72\u0a73\5"+
		"\u00d2j\2\u0a73\u00cf\3\2\2\2\u0a74\u0a75\7$\2\2\u0a75\u0a76\5\u00d2j"+
		"\2\u0a76\u00d1\3\2\2\2\u0a77\u0a7a\5\u00dan\2\u0a78\u0a7a\7M\2\2\u0a79"+
		"\u0a77\3\2\2\2\u0a79\u0a78\3\2\2\2\u0a7a\u00d3\3\2\2\2\u0a7b\u0a7c\7\20"+
		"\2\2\u0a7c\u0a7d\7\u0138\2\2\u0a7d\u0a7e\5\u00d6l\2\u0a7e\u0a7f\7\5\2"+
		"\2\u0a7f\u0a80\5\u00d8m\2\u0a80\u0a81\7\u0139\2\2\u0a81\u00d5\3\2\2\2"+
		"\u0a82\u0a83\5\u00dan\2\u0a83\u00d7\3\2\2\2\u0a84\u0a85\5\u008aF\2\u0a85"+
		"\u00d9\3\2\2\2\u0a86\u0a8a\5\u00dco\2\u0a87\u0a8a\5\u0118\u008d\2\u0a88"+
		"\u0a8a\5\u0104\u0083\2\u0a89\u0a86\3\2\2\2\u0a89\u0a87\3\2\2\2\u0a89\u0a88"+
		"\3\2\2\2\u0a8a\u00db\3\2\2\2\u0a8b\u0a8f\5\u00dep\2\u0a8c\u0a8f\5\u00f4"+
		"{\2\u0a8d\u0a8f\7M\2\2\u0a8e\u0a8b\3\2\2\2\u0a8e\u0a8c\3\2\2\2\u0a8e\u0a8d"+
		"\3\2\2\2\u0a8f\u00dd\3\2\2\2\u0a90\u0a95\5\u00e0q\2\u0a91\u0a92\t\30\2"+
		"\2\u0a92\u0a94\5\u00e0q\2\u0a93\u0a91\3\2\2\2\u0a94\u0a97\3\2\2\2\u0a95"+
		"\u0a93\3\2\2\2\u0a95\u0a96\3\2\2\2\u0a96\u00df\3\2\2\2\u0a97\u0a95\3\2"+
		"\2\2\u0a98\u0a9d\5\u00e2r\2\u0a99\u0a9a\t\31\2\2\u0a9a\u0a9c\5\u00e2r"+
		"\2\u0a9b\u0a99\3\2\2\2\u0a9c\u0a9f\3\2\2\2\u0a9d\u0a9b\3\2\2\2\u0a9d\u0a9e"+
		"\3\2\2\2\u0a9e\u00e1\3\2\2\2\u0a9f\u0a9d\3\2\2\2\u0aa0\u0aa2\5\u00e8u"+
		"\2\u0aa1\u0aa0\3\2\2\2\u0aa1\u0aa2\3\2\2\2\u0aa2\u0aa3\3\2\2\2\u0aa3\u0aa4"+
		"\5\u00e6t\2\u0aa4\u00e3\3\2\2\2\u0aa5\u0aa6\7\u0138\2\2\u0aa6\u0aab\5"+
		"\u00dep\2\u0aa7\u0aa8\7\u0131\2\2\u0aa8\u0aaa\5\u00dep\2\u0aa9\u0aa7\3"+
		"\2\2\2\u0aaa\u0aad\3\2\2\2\u0aab\u0aa9\3\2\2\2\u0aab\u0aac\3\2\2\2\u0aac"+
		"\u0aae\3\2\2\2\u0aad\u0aab\3\2\2\2\u0aae\u0aaf\7\u0139\2\2\u0aaf\u00e5"+
		"\3\2\2\2\u0ab0\u0ab5\5\u00aaV\2\u0ab1\u0ab2\7\u012c\2\2\u0ab2\u0ab4\5"+
		"\u00d8m\2\u0ab3\u0ab1\3\2\2\2\u0ab4\u0ab7\3\2\2\2\u0ab5\u0ab3\3\2\2\2"+
		"\u0ab5\u0ab6\3\2\2\2\u0ab6\u0aba\3\2\2\2\u0ab7\u0ab5\3\2\2\2\u0ab8\u0aba"+
		"\5\u00eav\2\u0ab9\u0ab0\3\2\2\2\u0ab9\u0ab8\3\2\2\2\u0aba\u00e7\3\2\2"+
		"\2\u0abb\u0abc\t\30\2\2\u0abc\u00e9\3\2\2\2\u0abd\u0abe\5\u00ecw\2\u0abe"+
		"\u00eb\3\2\2\2\u0abf\u0ac0\7\u00a6\2\2\u0ac0\u0ac1\7\u0138\2\2\u0ac1\u0ac2"+
		"\5\u00eex\2\u0ac2\u0ac3\7\60\2\2\u0ac3\u0ac4\5\u00f2z\2\u0ac4\u0ac5\7"+
		"\u0139\2\2\u0ac5\u00ed\3\2\2\2\u0ac6\u0aca\5\u01b6\u00dc\2\u0ac7\u0aca"+
		"\5\u00f0y\2\u0ac8\u0aca\5\u01ba\u00de\2\u0ac9\u0ac6\3\2\2\2\u0ac9\u0ac7"+
		"\3\2\2\2\u0ac9\u0ac8\3\2\2\2\u0aca\u00ef\3\2\2\2\u0acb\u0acc\t\32\2\2"+
		"\u0acc\u00f1\3\2\2\2\u0acd\u0ad0\5\u0182\u00c2\2\u0ace\u0ad0\5\u0080A"+
		"\2\u0acf\u0acd\3\2\2\2\u0acf\u0ace\3\2\2\2\u0ad0\u00f3\3\2\2\2\u0ad1\u0ad2"+
		"\5\u00f6|\2\u0ad2\u00f5\3\2\2\2\u0ad3\u0ad8\5\u00f8}\2\u0ad4\u0ad5\7\u0132"+
		"\2\2\u0ad5\u0ad7\5\u00f8}\2\u0ad6\u0ad4\3\2\2\2\u0ad7\u0ada\3\2\2\2\u0ad8"+
		"\u0ad6\3\2\2\2\u0ad8\u0ad9\3\2\2\2\u0ad9\u00f7\3\2\2\2\u0ada\u0ad8\3\2"+
		"\2\2\u0adb\u0adc\5\u00fa~\2\u0adc\u00f9\3\2\2\2\u0add\u0ae0\5\u00aaV\2"+
		"\u0ade\u0ae0\5\u00fc\177\2\u0adf\u0add\3\2\2\2\u0adf\u0ade\3\2\2\2\u0ae0"+
		"\u00fb\3\2\2\2\u0ae1\u0ae2\5\u00fe\u0080\2\u0ae2\u00fd\3\2\2\2\u0ae3\u0ae4"+
		"\7\u00f2\2\2\u0ae4\u0ae5\7\u0138\2\2\u0ae5\u0ae6\5\u0100\u0081\2\u0ae6"+
		"\u0ae7\7\u0139\2\2\u0ae7\u00ff\3\2\2\2\u0ae8\u0aea\5\u0102\u0082\2\u0ae9"+
		"\u0ae8\3\2\2\2\u0ae9\u0aea\3\2\2\2\u0aea\u0aec\3\2\2\2\u0aeb\u0aed\5\u00f6"+
		"|\2\u0aec\u0aeb\3\2\2\2\u0aec\u0aed\3\2\2\2\u0aed\u0aee\3\2\2\2\u0aee"+
		"\u0af0\7\60\2\2\u0aef\u0ae9\3\2\2\2\u0aef\u0af0\3\2\2\2\u0af0\u0af1\3"+
		"\2\2\2\u0af1\u0af7\5\u00f6|\2\u0af2\u0af3\5\u00f6|\2\u0af3\u0af4\7\u0131"+
		"\2\2\u0af4\u0af5\5\u00f6|\2\u0af5\u0af7\3\2\2\2\u0af6\u0aef\3\2\2\2\u0af6"+
		"\u0af2\3\2\2\2\u0af7\u0101\3\2\2\2\u0af8\u0af9\t\33\2\2\u0af9\u0103\3"+
		"\2\2\2\u0afa\u0afb\5\u0106\u0084\2\u0afb\u0105\3\2\2\2\u0afc\u0b01\5\u0108"+
		"\u0085\2\u0afd\u0afe\7T\2\2\u0afe\u0b00\5\u0106\u0084\2\u0aff\u0afd\3"+
		"\2\2\2\u0b00\u0b03\3\2\2\2\u0b01\u0aff\3\2\2\2\u0b01\u0b02\3\2\2\2\u0b02"+
		"\u0107\3\2\2\2\u0b03\u0b01\3\2\2\2\u0b04\u0b09\5\u010a\u0086\2\u0b05\u0b06"+
		"\7\7\2\2\u0b06\u0b08\5\u0108\u0085\2\u0b07\u0b05\3\2\2\2\u0b08\u0b0b\3"+
		"\2\2\2\u0b09\u0b07\3\2\2\2\u0b09\u0b0a\3\2\2\2\u0b0a\u0109\3\2\2\2\u0b0b"+
		"\u0b09\3\2\2\2\u0b0c\u0b10\5\u010c\u0087\2\u0b0d\u0b0e\7L\2\2\u0b0e\u0b10"+
		"\5\u010c\u0087\2\u0b0f\u0b0c\3\2\2\2\u0b0f\u0b0d\3\2\2\2\u0b10\u010b\3"+
		"\2\2\2\u0b11\u0b13\5\u0112\u008a\2\u0b12\u0b14\5\u010e\u0088\2\u0b13\u0b12"+
		"\3\2\2\2\u0b13\u0b14\3\2\2\2\u0b14\u010d\3\2\2\2\u0b15\u0b17\7C\2\2\u0b16"+
		"\u0b18\7L\2\2\u0b17\u0b16\3\2\2\2\u0b17\u0b18\3\2\2\2\u0b18\u0b19\3\2"+
		"\2\2\u0b19\u0b1a\5\u0110\u0089\2\u0b1a\u010f\3\2\2\2\u0b1b\u0b1c\t\24"+
		"\2\2\u0b1c\u0111\3\2\2\2\u0b1d\u0b20\5\u0190\u00c9\2\u0b1e\u0b20\5\u0114"+
		"\u008b\2\u0b1f\u0b1d\3\2\2\2\u0b1f\u0b1e\3\2\2\2\u0b20\u0113\3\2\2\2\u0b21"+
		"\u0b24\5\u0116\u008c\2\u0b22\u0b24\5\u00aeX\2\u0b23\u0b21\3\2\2\2\u0b23"+
		"\u0b22\3\2\2\2\u0b24\u0115\3\2\2\2\u0b25\u0b26\7\u0138\2\2\u0b26\u0b27"+
		"\5\u0104\u0083\2\u0b27\u0b28\7\u0139\2\2\u0b28\u0117\3\2\2\2\u0b29\u0b2c"+
		"\5\u011a\u008e\2\u0b2a\u0b2c\5\u011c\u008f\2\u0b2b\u0b29\3\2\2\2\u0b2b"+
		"\u0b2a\3\2\2\2\u0b2c\u0119\3\2\2\2\u0b2d\u0b2e\5\u00aeX\2\u0b2e\u011b"+
		"\3\2\2\2\u0b2f\u0b30\7M\2\2\u0b30\u011d\3\2\2\2\u0b31\u0b34\5\u011a\u008e"+
		"\2\u0b32\u0b34\5\u0120\u0091\2\u0b33\u0b31\3\2\2\2\u0b33\u0b32\3\2\2\2"+
		"\u0b34\u011f\3\2\2\2\u0b35\u0b38\5\u00dco\2\u0b36\u0b38\5\u0114\u008b"+
		"\2\u0b37\u0b35\3\2\2\2\u0b37\u0b36\3\2\2\2\u0b38\u0121\3\2\2\2\u0b39\u0b3b"+
		"\5\u0124\u0093\2\u0b3a\u0b3c\5\u0148\u00a5\2\u0b3b\u0b3a\3\2\2\2\u0b3b"+
		"\u0b3c\3\2\2\2\u0b3c\u0b3e\3\2\2\2\u0b3d\u0b3f\5\u014c\u00a7\2\u0b3e\u0b3d"+
		"\3\2\2\2\u0b3e\u0b3f\3\2\2\2\u0b3f\u0b41\3\2\2\2\u0b40\u0b42\5\u015c\u00af"+
		"\2\u0b41\u0b40\3\2\2\2\u0b41\u0b42\3\2\2\2\u0b42\u0b44\3\2\2\2\u0b43\u0b45"+
		"\5\u01c4\u00e3\2\u0b44\u0b43\3\2\2\2\u0b44\u0b45\3\2\2\2\u0b45\u0b47\3"+
		"\2\2\2\u0b46\u0b48\5\u01cc\u00e7\2\u0b47\u0b46\3\2\2\2\u0b47\u0b48\3\2"+
		"\2\2\u0b48\u0123\3\2\2\2\u0b49\u0b4a\7\60\2\2\u0b4a\u0b4b\5\u0126\u0094"+
		"\2\u0b4b\u0125\3\2\2\2\u0b4c\u0b51\5\u0128\u0095\2\u0b4d\u0b4e\7\u0131"+
		"\2\2\u0b4e\u0b50\5\u0128\u0095\2\u0b4f\u0b4d\3\2\2\2\u0b50\u0b53\3\2\2"+
		"\2\u0b51\u0b4f\3\2\2\2\u0b51\u0b52\3\2\2\2\u0b52\u0127\3\2\2\2\u0b53\u0b51"+
		"\3\2\2\2\u0b54\u0b57\5\u012a\u0096\2\u0b55\u0b57\5\u0142\u00a2\2\u0b56"+
		"\u0b54\3\2\2\2\u0b56\u0b55\3\2\2\2\u0b57\u0129\3\2\2\2\u0b58\u0b5a\5\u0142"+
		"\u00a2\2\u0b59\u0b5b\5\u012c\u0097\2\u0b5a\u0b59\3\2\2\2\u0b5b\u0b5c\3"+
		"\2\2\2\u0b5c\u0b5a\3\2\2\2\u0b5c\u0b5d\3\2\2\2\u0b5d\u012b\3\2\2\2\u0b5e"+
		"\u0b5f\7\30\2\2\u0b5f\u0b60\7D\2\2\u0b60\u0b72\5\u0142\u00a2\2\u0b61\u0b63"+
		"\5\u0136\u009c\2\u0b62\u0b61\3\2\2\2\u0b62\u0b63\3\2\2\2\u0b63\u0b64\3"+
		"\2\2\2\u0b64\u0b65\7D\2\2\u0b65\u0b66\5\u0142\u00a2\2\u0b66\u0b67\5\u013c"+
		"\u009f\2\u0b67\u0b72\3\2\2\2\u0b68\u0b6a\7K\2\2\u0b69\u0b6b\5\u0136\u009c"+
		"\2\u0b6a\u0b69\3\2\2\2\u0b6a\u0b6b\3\2\2\2\u0b6b\u0b6c\3\2\2\2\u0b6c\u0b6d"+
		"\7D\2\2\u0b6d\u0b72\5\u0142\u00a2\2\u0b6e\u0b6f\7x\2\2\u0b6f\u0b70\7D"+
		"\2\2\u0b70\u0b72\5\u0142\u00a2\2\u0b71\u0b5e\3\2\2\2\u0b71\u0b62\3\2\2"+
		"\2\u0b71\u0b68\3\2\2\2\u0b71\u0b6e\3\2\2\2\u0b72\u012d\3\2\2\2\u0b73\u0b74"+
		"\7\30\2\2\u0b74\u0b75\7D\2\2\u0b75\u0b76\5\u0142\u00a2\2\u0b76\u012f\3"+
		"\2\2\2\u0b77\u0b79\5\u0136\u009c\2\u0b78\u0b77\3\2\2\2\u0b78\u0b79\3\2"+
		"\2\2\u0b79\u0b7a\3\2\2\2\u0b7a\u0b7b\7D\2\2\u0b7b\u0b7c\5\u0142\u00a2"+
		"\2\u0b7c\u0b7d\5\u013c\u009f\2\u0b7d\u0131\3\2\2\2\u0b7e\u0b80\7K\2\2"+
		"\u0b7f\u0b81\5\u0136\u009c\2\u0b80\u0b7f\3\2\2\2\u0b80\u0b81\3\2\2\2\u0b81"+
		"\u0b82\3\2\2\2\u0b82\u0b83\7D\2\2\u0b83\u0b84\5\u0142\u00a2\2\u0b84\u0133"+
		"\3\2\2\2\u0b85\u0b86\7x\2\2\u0b86\u0b87\7D\2\2\u0b87\u0b88\5\u0142\u00a2"+
		"\2\u0b88\u0135\3\2\2\2\u0b89\u0b8c\7=\2\2\u0b8a\u0b8c\5\u0138\u009d\2"+
		"\u0b8b\u0b89\3\2\2\2\u0b8b\u0b8a\3\2\2\2\u0b8c\u0137\3\2\2\2\u0b8d\u0b8f"+
		"\5\u013a\u009e\2\u0b8e\u0b90\7Q\2\2\u0b8f\u0b8e\3\2\2\2\u0b8f\u0b90\3"+
		"\2\2\2\u0b90\u0139\3\2\2\2\u0b91\u0b92\t\34\2\2\u0b92\u013b\3\2\2\2\u0b93"+
		"\u0b96\5\u013e\u00a0\2\u0b94\u0b96\5\u0140\u00a1\2\u0b95\u0b93\3\2\2\2"+
		"\u0b95\u0b94\3\2\2\2\u0b96\u013d\3\2\2\2\u0b97\u0b98\7P\2\2\u0b98\u0b99"+
		"\5\u014a\u00a6\2\u0b99\u013f\3\2\2\2\u0b9a\u0b9b\7|\2\2\u0b9b\u0b9c\7"+
		"\u0138\2\2\u0b9c\u0b9d\5\u0186\u00c4\2\u0b9d\u0b9e\7\u0139\2\2\u0b9e\u0141"+
		"\3\2\2\2\u0b9f\u0ba4\5\u0172\u00ba\2\u0ba0\u0ba2\7\5\2\2\u0ba1\u0ba0\3"+
		"\2\2\2\u0ba1\u0ba2\3\2\2\2\u0ba2\u0ba3\3\2\2\2\u0ba3\u0ba5\5x=\2\u0ba4"+
		"\u0ba1\3\2\2\2\u0ba4\u0ba5\3\2\2\2\u0ba5\u0baa\3\2\2\2\u0ba6\u0ba7\7\u0138"+
		"\2\2\u0ba7\u0ba8\5\u0144\u00a3\2\u0ba8\u0ba9\7\u0139\2\2\u0ba9\u0bab\3"+
		"\2\2\2\u0baa\u0ba6\3\2\2\2\u0baa\u0bab\3\2\2\2\u0bab\u0bb8\3\2\2\2\u0bac"+
		"\u0bae\5\u0146\u00a4\2\u0bad\u0baf\7\5\2\2\u0bae\u0bad\3\2\2\2\u0bae\u0baf"+
		"\3\2\2\2\u0baf\u0bb0\3\2\2\2\u0bb0\u0bb5\5x=\2\u0bb1\u0bb2\7\u0138\2\2"+
		"\u0bb2\u0bb3\5\u0144\u00a3\2\u0bb3\u0bb4\7\u0139\2\2\u0bb4\u0bb6\3\2\2"+
		"\2\u0bb5\u0bb1\3\2\2\2\u0bb5\u0bb6\3\2\2\2\u0bb6\u0bb8\3\2\2\2\u0bb7\u0b9f"+
		"\3\2\2\2\u0bb7\u0bac\3\2\2\2\u0bb8\u0143\3\2\2\2\u0bb9\u0bbe\5x=\2\u0bba"+
		"\u0bbb\7\u0131\2\2\u0bbb\u0bbd\5x=\2\u0bbc\u0bba\3\2\2\2\u0bbd\u0bc0\3"+
		"\2\2\2\u0bbe\u0bbc\3\2\2\2\u0bbe\u0bbf\3\2\2\2\u0bbf\u0145\3\2\2\2\u0bc0"+
		"\u0bbe\3\2\2\2\u0bc1\u0bc2\5\u018c\u00c7\2\u0bc2\u0147\3\2\2\2\u0bc3\u0bc4"+
		"\7\u0080\2\2\u0bc4\u0bc5\5\u014a\u00a6\2\u0bc5\u0149\3\2\2\2\u0bc6\u0bc7"+
		"\5\u00dan\2\u0bc7\u014b\3\2\2\2\u0bc8\u0bc9\7\63\2\2\u0bc9\u0bca\7\u0086"+
		"\2\2\u0bca\u0bcb\5\u014e\u00a8\2\u0bcb\u014d\3\2\2\2\u0bcc\u0bd1\5\u0150"+
		"\u00a9\2\u0bcd\u0bce\7\u0131\2\2\u0bce\u0bd0\5\u0150\u00a9\2\u0bcf\u0bcd"+
		"\3\2\2\2\u0bd0\u0bd3\3\2\2\2\u0bd1\u0bcf\3\2\2\2\u0bd1\u0bd2\3\2\2\2\u0bd2"+
		"\u014f\3\2\2\2\u0bd3\u0bd1\3\2\2\2\u0bd4\u0bd9\5\u0156\u00ac\2\u0bd5\u0bd9"+
		"\5\u0158\u00ad\2\u0bd6\u0bd9\5\u015a\u00ae\2\u0bd7\u0bd9\5\u0152\u00aa"+
		"\2\u0bd8\u0bd4\3\2\2\2\u0bd8\u0bd5\3\2\2\2\u0bd8\u0bd6\3\2\2\2\u0bd8\u0bd7"+
		"\3\2\2\2\u0bd9\u0151\3\2\2\2\u0bda\u0be0\5\u011e\u0090\2\u0bdb\u0bdc\7"+
		"\u0138\2\2\u0bdc\u0bdd\5\u015e\u00b0\2\u0bdd\u0bde\7\u0139\2\2\u0bde\u0be0"+
		"\3\2\2\2\u0bdf\u0bda\3\2\2\2\u0bdf\u0bdb\3\2\2\2\u0be0\u0153\3\2\2\2\u0be1"+
		"\u0be6\5\u0152\u00aa\2\u0be2\u0be3\7\u0131\2\2\u0be3\u0be5\5\u0152\u00aa"+
		"\2\u0be4\u0be2\3\2\2\2\u0be5\u0be8\3\2\2\2\u0be6\u0be4\3\2\2\2\u0be6\u0be7"+
		"\3\2\2\2\u0be7\u0155\3\2\2\2\u0be8\u0be6\3\2\2\2\u0be9\u0bea\7\u00dc\2"+
		"\2\u0bea\u0beb\7\u0138\2\2\u0beb\u0bec\5\u0154\u00ab\2\u0bec\u0bed\7\u0139"+
		"\2\2\u0bed\u0157\3\2\2\2\u0bee\u0bef\7\u0096\2\2\u0bef\u0bf0\7\u0138\2"+
		"\2\u0bf0\u0bf1\5\u0154\u00ab\2\u0bf1\u0bf2\7\u0139\2\2\u0bf2\u0159\3\2"+
		"\2\2\u0bf3\u0bf4\7\u0138\2\2\u0bf4\u0bf5\7\u0139\2\2\u0bf5\u015b\3\2\2"+
		"\2\u0bf6\u0bf7\7\64\2\2\u0bf7\u0bf8\5\u0104\u0083\2\u0bf8\u015d\3\2\2"+
		"\2\u0bf9\u0bfe\5\u011e\u0090\2\u0bfa\u0bfb\7\u0131\2\2\u0bfb\u0bfd\5\u011e"+
		"\u0090\2\u0bfc\u0bfa\3\2\2\2\u0bfd\u0c00\3\2\2\2\u0bfe\u0bfc\3\2\2\2\u0bfe"+
		"\u0bff\3\2\2\2\u0bff\u015f\3\2\2\2\u0c00\u0bfe\3\2\2\2\u0c01\u0c02\5\u0162"+
		"\u00b2\2\u0c02\u0161\3\2\2\2\u0c03\u0c06\5\u0164\u00b3\2\u0c04\u0c06\5"+
		"\u012a\u0096\2\u0c05\u0c03\3\2\2\2\u0c05\u0c04\3\2\2\2\u0c06\u0163\3\2"+
		"\2\2\u0c07\u0c10\5\u0168\u00b5\2\u0c08\u0c09\5\u012a\u0096\2\u0c09\u0c0b"+
		"\t\35\2\2\u0c0a\u0c0c\t\36\2\2\u0c0b\u0c0a\3\2\2\2\u0c0b\u0c0c\3\2\2\2"+
		"\u0c0c\u0c0d\3\2\2\2\u0c0d\u0c0e\5\u0166\u00b4\2\u0c0e\u0c10\3\2\2\2\u0c0f"+
		"\u0c07\3\2\2\2\u0c0f\u0c08\3\2\2\2\u0c10\u0c18\3\2\2\2\u0c11\u0c13\t\35"+
		"\2\2\u0c12\u0c14\t\36\2\2\u0c13\u0c12\3\2\2\2\u0c13\u0c14\3\2\2\2\u0c14"+
		"\u0c15\3\2\2\2\u0c15\u0c17\5\u0166\u00b4\2\u0c16\u0c11\3\2\2\2\u0c17\u0c1a"+
		"\3\2\2\2\u0c18\u0c16\3\2\2\2\u0c18\u0c19\3\2\2\2\u0c19\u0165\3\2\2\2\u0c1a"+
		"\u0c18\3\2\2\2\u0c1b\u0c1e\5\u0168\u00b5\2\u0c1c\u0c1e\5\u012a\u0096\2"+
		"\u0c1d\u0c1b\3\2\2\2\u0c1d\u0c1c\3\2\2\2\u0c1e\u0167\3\2\2\2\u0c1f\u0c28"+
		"\5\u016c\u00b7\2\u0c20\u0c21\5\u012a\u0096\2\u0c21\u0c23\7>\2\2\u0c22"+
		"\u0c24\t\36\2\2\u0c23\u0c22\3\2\2\2\u0c23\u0c24\3\2\2\2\u0c24\u0c25\3"+
		"\2\2\2\u0c25\u0c26\5\u016a\u00b6\2\u0c26\u0c28\3\2\2\2\u0c27\u0c1f\3\2"+
		"\2\2\u0c27\u0c20\3\2\2\2\u0c28\u0c30\3\2\2\2\u0c29\u0c2b\7>\2\2\u0c2a"+
		"\u0c2c\t\36\2\2\u0c2b\u0c2a\3\2\2\2\u0c2b\u0c2c\3\2\2\2\u0c2c\u0c2d\3"+
		"\2\2\2\u0c2d\u0c2f\5\u016a\u00b6\2\u0c2e\u0c29\3\2\2\2\u0c2f\u0c32\3\2"+
		"\2\2\u0c30\u0c2e\3\2\2\2\u0c30\u0c31\3\2\2\2\u0c31\u0169\3\2\2\2\u0c32"+
		"\u0c30\3\2\2\2\u0c33\u0c36\5\u016c\u00b7\2\u0c34\u0c36\5\u012a\u0096\2"+
		"\u0c35\u0c33\3\2\2\2\u0c35\u0c34\3\2\2\2\u0c36\u016b\3\2\2\2\u0c37\u0c3d"+
		"\5\u016e\u00b8\2\u0c38\u0c39\7\u0138\2\2\u0c39\u0c3a\5\u0164\u00b3\2\u0c3a"+
		"\u0c3b\7\u0139\2\2\u0c3b\u0c3d\3\2\2\2\u0c3c\u0c37\3\2\2\2\u0c3c\u0c38"+
		"\3\2\2\2\u0c3d\u016d\3\2\2\2\u0c3e\u0c41\5\u0176\u00bc\2\u0c3f\u0c41\5"+
		"\u0170\u00b9\2\u0c40\u0c3e\3\2\2\2\u0c40\u0c3f\3\2\2\2\u0c41\u016f\3\2"+
		"\2\2\u0c42\u0c43\7p\2\2\u0c43\u0c44\5\u0172\u00ba\2\u0c44\u0171\3\2\2"+
		"\2\u0c45\u0c48\5\u0174\u00bb\2\u0c46\u0c48\5x=\2\u0c47\u0c45\3\2\2\2\u0c47"+
		"\u0c46\3\2\2\2\u0c48\u0173\3\2\2\2\u0c49\u0c50\5x=\2\u0c4a\u0c4b\7\u013f"+
		"\2\2\u0c4b\u0c4e\5x=\2\u0c4c\u0c4d\7\u013f\2\2\u0c4d\u0c4f\5x=\2\u0c4e"+
		"\u0c4c\3\2\2\2\u0c4e\u0c4f\3\2\2\2\u0c4f\u0c51\3\2\2\2\u0c50\u0c4a\3\2"+
		"\2\2\u0c50\u0c51\3\2\2\2\u0c51\u0175\3\2\2\2\u0c52\u0c54\7i\2\2\u0c53"+
		"\u0c55\5\u0180\u00c1\2\u0c54\u0c53\3\2\2\2\u0c54\u0c55\3\2\2\2\u0c55\u0c56"+
		"\3\2\2\2\u0c56\u0c58\5\u0178\u00bd\2\u0c57\u0c59\5\u0122\u0092\2\u0c58"+
		"\u0c57\3\2\2\2\u0c58\u0c59\3\2\2\2\u0c59\u0177\3\2\2\2\u0c5a\u0c5f\5\u017a"+
		"\u00be\2\u0c5b\u0c5c\7\u0131\2\2\u0c5c\u0c5e\5\u017a\u00be\2\u0c5d\u0c5b"+
		"\3\2\2\2\u0c5e\u0c61\3\2\2\2\u0c5f\u0c5d\3\2\2\2\u0c5f\u0c60\3\2\2\2\u0c60"+
		"\u0179\3\2\2\2\u0c61\u0c5f\3\2\2\2\u0c62\u0c65\5\u017c\u00bf\2\u0c63\u0c65"+
		"\5\u017e\u00c0\2\u0c64\u0c62\3\2\2\2\u0c64\u0c63\3\2\2\2\u0c65\u017b\3"+
		"\2\2\2\u0c66\u0c68\5\u00dan\2\u0c67\u0c69\5\u0184\u00c3\2\u0c68\u0c67"+
		"\3\2\2\2\u0c68\u0c69\3\2\2\2\u0c69\u017d\3\2\2\2\u0c6a\u0c6b\7\u014b\2"+
		"\2\u0c6b\u0c6d\7\u013f\2\2\u0c6c\u0c6a\3\2\2\2\u0c6c\u0c6d\3\2\2\2\u0c6d"+
		"\u0c6e\3\2\2\2\u0c6e\u0c6f\7\u013c\2\2\u0c6f\u017f\3\2\2\2\u0c70\u0c71"+
		"\t\36\2\2\u0c71\u0181\3\2\2\2\u0c72\u0c73\5x=\2\u0c73\u0c74\7\u013f\2"+
		"\2\u0c74\u0c76\3\2\2\2\u0c75\u0c72\3\2\2\2\u0c75\u0c76\3\2\2\2\u0c76\u0c77"+
		"\3\2\2\2\u0c77\u0c78\5x=\2\u0c78\u0183\3\2\2\2\u0c79\u0c7b\7\5\2\2\u0c7a"+
		"\u0c79\3\2\2\2\u0c7a\u0c7b\3\2\2\2\u0c7b\u0c7c\3\2\2\2\u0c7c\u0c7d\5x"+
		"=\2\u0c7d\u0185\3\2\2\2\u0c7e\u0c83\5\u0182\u00c2\2\u0c7f\u0c80\7\u0131"+
		"\2\2\u0c80\u0c82\5\u0182\u00c2\2\u0c81\u0c7f\3\2\2\2\u0c82\u0c85\3\2\2"+
		"\2\u0c83\u0c81\3\2\2\2\u0c83\u0c84\3\2\2\2\u0c84\u0187\3\2\2\2\u0c85\u0c83"+
		"\3\2\2\2\u0c86\u0c87\5\u018e\u00c8\2\u0c87\u0189\3\2\2\2\u0c88\u0c89\5"+
		"\u018e\u00c8\2\u0c89\u018b\3\2\2\2\u0c8a\u0c8b\5\u018e\u00c8\2\u0c8b\u018d"+
		"\3\2\2\2\u0c8c\u0c8d\7\u0138\2\2\u0c8d\u0c8e\5\u0160\u00b1\2\u0c8e\u0c8f"+
		"\7\u0139\2\2\u0c8f\u018f\3\2\2\2\u0c90\u0c97\5\u0192\u00ca\2\u0c91\u0c97"+
		"\5\u0196\u00cc\2\u0c92\u0c97\5\u019a\u00ce\2\u0c93\u0c97\5\u01a0\u00d1"+
		"\2\u0c94\u0c97\5\u01a8\u00d5\2\u0c95\u0c97\5\u01b2\u00da\2\u0c96\u0c90"+
		"\3\2\2\2\u0c96\u0c91\3\2\2\2\u0c96\u0c92\3\2\2\2\u0c96\u0c93\3\2\2\2\u0c96"+
		"\u0c94\3\2\2\2\u0c96\u0c95\3\2\2\2\u0c97\u0191\3\2\2\2\u0c98\u0c99\5\u011e"+
		"\u0090\2\u0c99\u0c9a\5\u0194\u00cb\2\u0c9a\u0c9b\5\u011e\u0090\2\u0c9b"+
		"\u0193\3\2\2\2\u0c9c\u0c9d\t\37\2\2\u0c9d\u0195\3\2\2\2\u0c9e\u0c9f\5"+
		"\u011e\u0090\2\u0c9f\u0ca0\5\u0198\u00cd\2\u0ca0\u0197\3\2\2\2\u0ca1\u0ca3"+
		"\7L\2\2\u0ca2\u0ca1\3\2\2\2\u0ca2\u0ca3\3\2\2\2\u0ca3\u0ca4\3\2\2\2\u0ca4"+
		"\u0ca6\7\u0085\2\2\u0ca5\u0ca7\t \2\2\u0ca6\u0ca5\3\2\2\2\u0ca6\u0ca7"+
		"\3\2\2\2\u0ca7\u0ca8\3\2\2\2\u0ca8\u0ca9\5\u011e\u0090\2\u0ca9\u0caa\7"+
		"\7\2\2\u0caa\u0cab\5\u011e\u0090\2\u0cab\u0199\3\2\2\2\u0cac\u0cae\5\u00de"+
		"p\2\u0cad\u0caf\7L\2\2\u0cae\u0cad\3\2\2\2\u0cae\u0caf\3\2\2\2\u0caf\u0cb0"+
		"\3\2\2\2\u0cb0\u0cb1\79\2\2\u0cb1\u0cb2\5\u019c\u00cf\2\u0cb2\u019b\3"+
		"\2\2\2\u0cb3\u0cb9\5\u018c\u00c7\2\u0cb4\u0cb5\7\u0138\2\2\u0cb5\u0cb6"+
		"\5\u019e\u00d0\2\u0cb6\u0cb7\7\u0139\2\2\u0cb7\u0cb9\3\2\2\2\u0cb8\u0cb3"+
		"\3\2\2\2\u0cb8\u0cb4\3\2\2\2\u0cb9\u019d\3\2\2\2\u0cba\u0cbf\5\u0118\u008d"+
		"\2\u0cbb\u0cbc\7\u0131\2\2\u0cbc\u0cbe\5\u0118\u008d\2\u0cbd\u0cbb\3\2"+
		"\2\2\u0cbe\u0cc1\3\2\2\2\u0cbf\u0cbd\3\2\2\2\u0cbf\u0cc0\3\2\2\2\u0cc0"+
		"\u019f\3\2\2\2\u0cc1\u0cbf\3\2\2\2\u0cc2\u0cc3\5\u011e\u0090\2\u0cc3\u0cc4"+
		"\5\u01a2\u00d2\2\u0cc4\u0cc5\7\u014c\2\2\u0cc5\u01a1\3\2\2\2\u0cc6\u0cc8"+
		"\7L\2\2\u0cc7\u0cc6\3\2\2\2\u0cc7\u0cc8\3\2\2\2\u0cc8\u0cc9\3\2\2\2\u0cc9"+
		"\u0ccc\5\u01a4\u00d3\2\u0cca\u0ccc\5\u01a6\u00d4\2\u0ccb\u0cc7\3\2\2\2"+
		"\u0ccb\u0cca\3\2\2\2\u0ccc\u01a3\3\2\2\2\u0ccd\u0cd4\7H\2\2\u0cce\u0cd4"+
		"\7\66\2\2\u0ccf\u0cd0\7\u00e2\2\2\u0cd0\u0cd4\7\u00f3\2\2\u0cd1\u0cd4"+
		"\7\u00da\2\2\u0cd2\u0cd4\7\u00db\2\2\u0cd3\u0ccd\3\2\2\2\u0cd3\u0cce\3"+
		"\2\2\2\u0cd3\u0ccf\3\2\2\2\u0cd3\u0cd1\3\2\2\2\u0cd3\u0cd2\3\2\2\2\u0cd4"+
		"\u01a5\3\2\2\2\u0cd5\u0cd6\t!\2\2\u0cd6\u01a7\3\2\2\2\u0cd7\u0cd8\5\u011e"+
		"\u0090\2\u0cd8\u0cda\7C\2\2\u0cd9\u0cdb\7L\2\2\u0cda\u0cd9\3\2\2\2\u0cda"+
		"\u0cdb\3\2\2\2\u0cdb\u0cdc\3\2\2\2\u0cdc\u0cdd\7M\2\2\u0cdd\u01a9\3\2"+
		"\2\2\u0cde\u0cdf\5\u00dep\2\u0cdf\u0ce0\5\u0194\u00cb\2\u0ce0\u0ce1\5"+
		"\u01ac\u00d7\2\u0ce1\u0ce2\5\u018c\u00c7\2\u0ce2\u01ab\3\2\2\2\u0ce3\u0ce6"+
		"\5\u01ae\u00d8\2\u0ce4\u0ce6\5\u01b0\u00d9\2\u0ce5\u0ce3\3\2\2\2\u0ce5"+
		"\u0ce4\3\2\2\2\u0ce6\u01ad\3\2\2\2\u0ce7\u0ce8\7\6\2\2\u0ce8\u01af\3\2"+
		"\2\2\u0ce9\u0cea\t\"\2\2\u0cea\u01b1\3\2\2\2\u0ceb\u0ced\7L\2\2\u0cec"+
		"\u0ceb\3\2\2\2\u0cec\u0ced\3\2\2\2\u0ced\u0cee\3\2\2\2\u0cee\u0cef\7\u00a4"+
		"\2\2\u0cef\u0cf0\5\u018c\u00c7\2\u0cf0\u01b3\3\2\2\2\u0cf1\u0cf2\7y\2"+
		"\2\u0cf2\u0cf3\5\u018c\u00c7\2\u0cf3\u01b5\3\2\2\2\u0cf4\u0cf7\5\u01b8"+
		"\u00dd\2\u0cf5\u0cf7\7\u00de\2\2\u0cf6\u0cf4\3\2\2\2\u0cf6\u0cf5\3\2\2"+
		"\2\u0cf7\u01b7\3\2\2\2\u0cf8\u0cf9\t#\2\2\u0cf9\u01b9\3\2\2\2\u0cfa\u0cfb"+
		"\t$\2\2\u0cfb\u01bb\3\2\2\2\u0cfc\u0cfd\5\u01c0\u00e1\2\u0cfd\u0cff\7"+
		"\u0138\2\2\u0cfe\u0d00\5\u01c2\u00e2\2\u0cff\u0cfe\3\2\2\2\u0cff\u0d00"+
		"\3\2\2\2\u0d00\u0d01\3\2\2\2\u0d01\u0d02\7\u0139\2\2\u0d02\u01bd\3\2\2"+
		"\2\u0d03\u0d04\t%\2\2\u0d04\u01bf\3\2\2\2\u0d05\u0d08\5x=\2\u0d06\u0d08"+
		"\5\u01be\u00e0\2\u0d07\u0d05\3\2\2\2\u0d07\u0d06\3\2\2\2\u0d08\u01c1\3"+
		"\2\2\2\u0d09\u0d0e\5\u00dan\2\u0d0a\u0d0b\7\u0131\2\2\u0d0b\u0d0d\5\u00da"+
		"n\2\u0d0c\u0d0a\3\2\2\2\u0d0d\u0d10\3\2\2\2\u0d0e\u0d0c\3\2\2\2\u0d0e"+
		"\u0d0f\3\2\2\2\u0d0f\u01c3\3\2\2\2\u0d10\u0d0e\3\2\2\2\u0d11\u0d12\7U"+
		"\2\2\u0d12\u0d13\7\u0086\2\2\u0d13\u0d14\5\u01c6\u00e4\2\u0d14\u01c5\3"+
		"\2\2\2\u0d15\u0d1a\5\u01c8\u00e5\2\u0d16\u0d17\7\u0131\2\2\u0d17\u0d19"+
		"\5\u01c8\u00e5\2\u0d18\u0d16\3\2\2\2\u0d19\u0d1c\3\2\2\2\u0d1a\u0d18\3"+
		"\2\2\2\u0d1a\u0d1b\3\2\2\2\u0d1b\u01c7\3\2\2\2\u0d1c\u0d1a\3\2\2\2\u0d1d"+
		"\u0d1f\5\u011e\u0090\2\u0d1e\u0d20\5\u01ca\u00e6\2\u0d1f\u0d1e\3\2\2\2"+
		"\u0d1f\u0d20\3\2\2\2\u0d20\u0d22\3\2\2\2\u0d21\u0d23\5\u01ce\u00e8\2\u0d22"+
		"\u0d21\3\2\2\2\u0d22\u0d23\3\2\2\2\u0d23\u01c9\3\2\2\2\u0d24\u0d25\t&"+
		"\2\2\u0d25\u01cb\3\2\2\2\u0d26\u0d27\7I\2\2\u0d27\u0d28\5\u00dep\2\u0d28"+
		"\u01cd\3\2\2\2\u0d29\u0d2a\7M\2\2\u0d2a\u0d2e\7\u00a9\2\2\u0d2b\u0d2c"+
		"\7M\2\2\u0d2c\u0d2e\7\u00bb\2\2\u0d2d\u0d29\3\2\2\2\u0d2d\u0d2b\3\2\2"+
		"\2\u0d2e\u01cf\3\2\2\2\u0d2f\u0d31\7\u00b3\2\2\u0d30\u0d32\7\u00d0\2\2"+
		"\u0d31\u0d30\3\2\2\2\u0d31\u0d32\3\2\2\2\u0d32\u0d33\3\2\2\2\u0d33\u0d34"+
		"\7?\2\2\u0d34\u0d39\5\u0174\u00bb\2\u0d35\u0d36\7\u0138\2\2\u0d36\u0d37"+
		"\5\u0144\u00a3\2\u0d37\u0d38\7\u0139\2\2\u0d38\u0d3a\3\2\2\2\u0d39\u0d35"+
		"\3\2\2\2\u0d39\u0d3a\3\2\2\2\u0d3a\u0d3b\3\2\2\2\u0d3b\u0d3c\5\u0160\u00b1"+
		"\2\u0d3c\u0d4d\3\2\2\2\u0d3d\u0d3f\7\u00b3\2\2\u0d3e\u0d40\7\u00d0\2\2"+
		"\u0d3f\u0d3e\3\2\2\2\u0d3f\u0d40\3\2\2\2\u0d40\u0d41\3\2\2\2\u0d41\u0d42"+
		"\7?\2\2\u0d42\u0d43\7\u00be\2\2\u0d43\u0d49\7\u014c\2\2\u0d44\u0d45\7"+
		"|\2\2\u0d45\u0d47\5x=\2\u0d46\u0d48\5R*\2\u0d47\u0d46\3\2\2\2\u0d47\u0d48"+
		"\3\2\2\2\u0d48\u0d4a\3\2\2\2\u0d49\u0d44\3\2\2\2\u0d49\u0d4a\3\2\2\2\u0d4a"+
		"\u0d4b\3\2\2\2\u0d4b\u0d4d\5\u0160\u00b1\2\u0d4c\u0d2f\3\2\2\2\u0d4c\u0d3d"+
		"\3\2\2\2\u0d4d\u01d1\3\2\2\2\u01e6\u01d4\u01d8\u01ea\u01f2\u01f6\u01fd"+
		"\u0203\u020a\u020e\u0212\u0216\u021a\u021e\u0228\u022b\u022f\u0233\u023a"+
		"\u023d\u0241\u0243\u0247\u024f\u0258\u025c\u025e\u0260\u0266\u026b\u0271"+
		"\u0275\u0279\u027d\u0285\u0287\u028f\u0294\u0298\u029a\u029e\u02a3\u02ac"+
		"\u02ae\u02b6\u02bc\u02c0\u02c6\u02ca\u02cf\u02d3\u02d7\u02db\u02df\u02e3"+
		"\u02eb\u02f0\u02f4\u02f6\u02fc\u0300\u0308\u030c\u030e\u0316\u031b\u031f"+
		"\u0321\u0327\u032b\u0333\u0338\u033a\u0342\u0346\u034e\u0353\u0355\u035c"+
		"\u0360\u0368\u036d\u036f\u0374\u037c\u0381\u0383\u0389\u038d\u0395\u039a"+
		"\u039c\u039e\u03a2\u03a4\u03ab\u03af\u03b7\u03bb\u03bf\u03c3\u03c5\u03cb"+
		"\u03cf\u03d7\u03dc\u03de\u03e4\u03e8\u03f0\u03f4\u03f8\u03fd\u0401\u0404"+
		"\u0406\u040a\u040f\u0411\u0413\u0416\u041c\u0420\u0422\u0426\u042a\u042e"+
		"\u0436\u043a\u043c\u0444\u0448\u044c\u0450\u0454\u0458\u045a\u045e\u0462"+
		"\u0466\u046d\u0471\u0475\u0477\u047d\u0481\u0489\u048d\u048f\u0496\u049a"+
		"\u049e\u04a0\u04a6\u04aa\u04b2\u04b4\u04bc\u04c0\u04c8\u04ca\u04d1\u04d5"+
		"\u04dd\u04df\u04e4\u04ec\u04ee\u04f4\u04f8\u04ff\u0503\u0507\u0509\u0510"+
		"\u0514\u051b\u051f\u0523\u0525\u052b\u052f\u0537\u0539\u053f\u0543\u0549"+
		"\u054d\u0552\u0556\u055b\u055d\u0561\u0565\u0568\u056c\u0571\u057a\u057e"+
		"\u05bd\u05eb\u05f3\u05f9\u05fc\u0602\u0605\u0609\u0615\u0619\u061d\u0630"+
		"\u0635\u0645\u064b\u0654\u0656\u065c\u0660\u0664\u0668\u066e\u0677\u0684"+
		"\u0687\u068b\u068e\u0692\u069d\u06a1\u06a5\u06ab\u06b2\u06b8\u06bc\u06c2"+
		"\u06c9\u06cb\u06cd\u06d5\u06da\u06e4\u06ef\u06f8\u06fd\u0700\u0706\u070a"+
		"\u0712\u0716\u071a\u0723\u0727\u072d\u0735\u073a\u0743\u0746\u0749\u074d"+
		"\u074f\u0756\u075a\u075e\u0766\u076a\u0770\u077c\u0780\u0783\u0787\u078b"+
		"\u0791\u0798\u079f\u07a3\u07ad\u07b1\u07b9\u07c0\u07c4\u07cd\u07d4\u07d8"+
		"\u07e0\u07e4\u07e8\u07f0\u07f5\u07fa\u07fc\u0801\u0807\u080b\u0814\u0824"+
		"\u0829\u082e\u0830\u0835\u083b\u0847\u084a\u084e\u0857\u0860\u0862\u0866"+
		"\u086e\u0871\u0877\u087f\u0890\u08a5\u08b6\u08c3\u08c7\u08c9\u08d6\u08dd"+
		"\u08f5\u08fc\u090d\u0910\u0914\u0917\u091b\u091d\u0923\u0928\u092d\u093d"+
		"\u094c\u0954\u0958\u095d\u0962\u0966\u0969\u0972\u0977\u097b\u0981\u0987"+
		"\u098c\u0990\u0992\u0996\u099a\u099c\u09a0\u09a4\u09a8\u09ac\u09b7\u09bb"+
		"\u09c3\u09cd\u09de\u09e2\u09e6\u09eb\u09ed\u09f1\u09f6\u09fa\u09fc\u0a00"+
		"\u0a0d\u0a14\u0a20\u0a22\u0a27\u0a49\u0a4d\u0a51\u0a58\u0a5b\u0a63\u0a66"+
		"\u0a79\u0a89\u0a8e\u0a95\u0a9d\u0aa1\u0aab\u0ab5\u0ab9\u0ac9\u0acf\u0ad8"+
		"\u0adf\u0ae9\u0aec\u0aef\u0af6\u0b01\u0b09\u0b0f\u0b13\u0b17\u0b1f\u0b23"+
		"\u0b2b\u0b33\u0b37\u0b3b\u0b3e\u0b41\u0b44\u0b47\u0b51\u0b56\u0b5c\u0b62"+
		"\u0b6a\u0b71\u0b78\u0b80\u0b8b\u0b8f\u0b95\u0ba1\u0ba4\u0baa\u0bae\u0bb5"+
		"\u0bb7\u0bbe\u0bd1\u0bd8\u0bdf\u0be6\u0bfe\u0c05\u0c0b\u0c0f\u0c13\u0c18"+
		"\u0c1d\u0c23\u0c27\u0c2b\u0c30\u0c35\u0c3c\u0c40\u0c47\u0c4e\u0c50\u0c54"+
		"\u0c58\u0c5f\u0c64\u0c68\u0c6c\u0c75\u0c7a\u0c83\u0c96\u0ca2\u0ca6\u0cae"+
		"\u0cb8\u0cbf\u0cc7\u0ccb\u0cd3\u0cda\u0ce5\u0cec\u0cf6\u0cff\u0d07\u0d0e"+
		"\u0d1a\u0d1f\u0d22\u0d2d\u0d31\u0d39\u0d3f\u0d47\u0d49\u0d4c";
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